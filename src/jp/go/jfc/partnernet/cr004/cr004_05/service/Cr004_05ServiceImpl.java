//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_05Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_05.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.cr004.common.Cr004Constants;
import jp.go.jfc.partnernet.cr004.cr004_05.dao.Cr004_05ResultYakujo1DAO;
import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonStringUtils;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.common.calculation.PNKeisanFukin;
import jp.go.jfc.partnernet.common.dao.KurishoreportDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.AringiDAO;
import jp.go.jfc.partnernet.cr004.cr004_05.dao.Cr004_05ResultYakujo1Entity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.KurishoreportEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.common.dao.AringiEntity;

/**
 * <pre>
 * このクラスはcr004_05のサービスクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_05ServiceImpl extends PNBaseService implements Cr004_05Service {

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** cr004_05resultyakujo1dao */
    @Autowired
    private Cr004_05ResultYakujo1DAO cr004_05resultyakujo1dao;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** kurishoreportdao */
    @Autowired
    private KurishoreportDAO kurishoreportdao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    private static final BigDecimal RETRUN_ERROR = BigDecimal.valueOf(-1);

    /**
     * Cr004_05ServiceのsetUpdateInputData
     *
     * @param inDto Cr004_05DTO
     * @return Cr004_05DTO
     */
    @Override
    public Cr004_05DTO setUpdateInputData(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 償還方法区分
        String categoryShokanHouhou = inDto.getID_Code_ShokanHouhou().substring(0, 1);

        // 繰上償還事由区分
        String categoryKurishojiyu = "";
        if (!StringUtils.isEmpty(inDto.getLblID_Code_Kurishojiyu())) {
            categoryKurishojiyu = inDto.getLblID_Code_Kurishojiyu().substring(0, 1);
        }

        // --------------------------------------------------------------------
        // 　　①元利金均等償還・期限固定時の処理
        // 　　⑤元利金均等償還時の約定利息算出の処理
        // --------------------------------------------------------------------
        if (Cr004Constants.CODE_SHOKANHOUHOU_1.equals(categoryShokanHouhou)
                && (Cr004Constants.CODE_KURISHOJIYU_1.equals(categoryKurishojiyu) || Cr004Constants.CODE_KURISHOJIYU_5
                        .equals(categoryKurishojiyu))) {

            Cr004_05DTO tmpDto = new Cr004_05DTO();
            Cr004_05DTO tmpDto2 = new Cr004_05DTO();

            // 元利金均等償還・期限固定の算出処理
            tmpDto = ganrikinShokanFukinEdit1(inDto);
            outDto.setPreserve_ID_M_YakujoGankin(tmpDto.getPreserve_ID_M_YakujoGankin());
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto.getPreserve_ID_M_YakujoRisoku());
            outDto.setPreserve_ID_Date_ShokanKigen(tmpDto.getPreserve_ID_Date_ShokanKigen());
            outDto.setPreserve_ID_M_Fukin(tmpDto.getPreserve_ID_M_Fukin());

            // 元利金均等償還時の約定利息の算出処理
            tmpDto2 = ganrikinShokanRisokuEdit(tmpDto);
            outDto.setPreserve_ID_Kubun_JohenKianchu(tmpDto2.getPreserve_ID_Kubun_JohenKianchu());
            outDto.setPreserve_ID_M_GankinFukinto(tmpDto2.getPreserve_ID_M_GankinFukinto());
            outDto.setPreserve_ID_Code_Chosei(tmpDto2.getPreserve_ID_Code_Chosei());
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto2.getPreserve_ID_M_YakujoRisoku());
        }

        // --------------------------------------------------------------------
        // 　　②元利金均等償還・期限短縮時の処理
        // 　　⑤元利金均等償還時の約定利息の算出処理
        // --------------------------------------------------------------------
        if (Cr004Constants.CODE_SHOKANHOUHOU_1.equals(categoryShokanHouhou)
                && (Cr004Constants.CODE_KURISHOJIYU_3.equals(categoryKurishojiyu) || Cr004Constants.CODE_KURISHOJIYU_6
                        .equals(categoryKurishojiyu))) {

            Cr004_05DTO tmpDto = new Cr004_05DTO();
            Cr004_05DTO tmpDto2 = new Cr004_05DTO();

            // 元利金均等償還・期限短縮の算出処理
            tmpDto = ganrikinShokanFukinEdit2(inDto);
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto.getPreserve_ID_M_YakujoRisoku());
            outDto.setPreserve_ID_M_Fukin(tmpDto.getPreserve_ID_M_Fukin());
            outDto.setPreserve_ID_Date_ShokanKigen(tmpDto.getPreserve_ID_Date_ShokanKigen());
            outDto.setPreserve_ID_M_YakujoGankin(tmpDto.getPreserve_ID_M_YakujoGankin());

            // 元利金均等償還時の約定利息の算出処理
            tmpDto2 = ganrikinShokanRisokuEdit(tmpDto);
            outDto.setPreserve_ID_Kubun_JohenKianchu(tmpDto2.getPreserve_ID_Kubun_JohenKianchu());
            outDto.setPreserve_ID_M_GankinFukinto(tmpDto2.getPreserve_ID_M_GankinFukinto());
            outDto.setPreserve_ID_Code_Chosei(tmpDto2.getPreserve_ID_Code_Chosei());
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto2.getPreserve_ID_M_YakujoRisoku());
        }

        // --------------------------------------------------------------------
        // 　　③元金均等償還・期限固定時の処理
        // 　　⑥元金均等償還の約定元金、約定利息の算出の処理
        // --------------------------------------------------------------------
        if (Cr004Constants.CODE_SHOKANHOUHOU_2.equals(categoryShokanHouhou)
                && (Cr004Constants.CODE_KURISHOJIYU_1.equals(categoryKurishojiyu) || Cr004Constants.CODE_KURISHOJIYU_5
                        .equals(categoryKurishojiyu))) {

            Cr004_05DTO tmpDto = new Cr004_05DTO();
            Cr004_05DTO tmpDto2 = new Cr004_05DTO();

            // 元金均等償還・期限固定の算出処理
            tmpDto = gankinShokanFukinEdit(inDto);
            outDto.setPreserve_ID_M_Fukin(tmpDto.getPreserve_ID_M_Fukin());
            outDto.setPreserve_ID_M_GankinFukinto(tmpDto.getPreserve_ID_M_GankinFukinto());
            outDto.setPreserve_ID_Date_ShokanKigen(tmpDto.getPreserve_ID_Date_ShokanKigen());
            outDto.setPreserve_ID_Code_Chosei(tmpDto.getPreserve_ID_Code_Chosei());

            // 元金均等償還の約定元金、約定利息の算出の処理
            tmpDto2 = gankinShokanRisokuEdit(tmpDto);
            outDto.setPreserve_ID_Kubun_JohenKianchu(tmpDto2.getPreserve_ID_Kubun_JohenKianchu());
            outDto.setPreserve_ID_M_YakujoGankin(tmpDto2.getPreserve_ID_M_YakujoGankin());
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto2.getPreserve_ID_M_YakujoRisoku());
        }

        // --------------------------------------------------------------------
        // 　　④元金均等償還・期限短縮時の処理
        // 　　⑥元金均等償還の約定元金、約定利息の算出の処理
        // --------------------------------------------------------------------
        if (Cr004Constants.CODE_SHOKANHOUHOU_2.equals(categoryShokanHouhou)
                && (Cr004Constants.CODE_KURISHOJIYU_3.equals(categoryKurishojiyu) || Cr004Constants.CODE_KURISHOJIYU_6
                        .equals(categoryKurishojiyu))) {

            Cr004_05DTO tmpDto = new Cr004_05DTO();
            Cr004_05DTO tmpDto2 = new Cr004_05DTO();

            // 元金均等償還・期限短縮の算出処理
            tmpDto = gankinShokanFukinEdit2(inDto);
            outDto.setPreserve_ID_M_Fukin(tmpDto.getPreserve_ID_M_Fukin());
            outDto.setPreserve_ID_Code_Chosei(tmpDto.getPreserve_ID_Code_Chosei());
            outDto.setPreserve_ID_M_GankinFukinto(tmpDto.getPreserve_ID_M_GankinFukinto());
            outDto.setPreserve_ID_Date_ShokanKigen(tmpDto.getPreserve_ID_Date_ShokanKigen());

            // 元金均等償還の約定元金、約定利息の算出処理
            tmpDto2 = gankinShokanRisokuEdit(tmpDto);
            outDto.setPreserve_ID_Kubun_JohenKianchu(tmpDto2.getPreserve_ID_Kubun_JohenKianchu());
            outDto.setPreserve_ID_M_YakujoGankin(tmpDto2.getPreserve_ID_M_YakujoGankin());
            outDto.setPreserve_ID_M_YakujoRisoku(tmpDto2.getPreserve_ID_M_YakujoRisoku());
        }

        // --------------------------------------------------------------------
        // 　　⑦定期償還時の処理
        // --------------------------------------------------------------------
        if (Cr004Constants.CODE_SHOKANHOUHOU_3.equals(categoryShokanHouhou)
                || Cr004Constants.CODE_SHOKANHOUHOU_9.equals(categoryShokanHouhou)) {

            // 　　　DTOの計算・条変起案中区分＝９
            // 　　　DTOの計算・賦金＝DTOの賦金
            // 　　　DTOの計算・元金不均等額＝DTOの繰償後元金不均等額(円)
            // 　　　DTOの計算・調整コード＝DTOの元金不均等額区分
            // 　　　DTOの計算・償還期限年月＝退避償還期限年月
            outDto.setPreserve_ID_Kubun_JohenKianchu("9");
            outDto.setPreserve_ID_M_Fukin(inDto.getID_M_Fukin());
            outDto.setPreserve_ID_M_GankinFukinto(inDto.getLblID_M_GankinFukintoAfterKurisho());
            outDto.setPreserve_ID_Code_Chosei(inDto.getID_Kubun_GankinFukintogaku());
            outDto.setPreserve_ID_Date_ShokanKigen(inDto.getID_Date_ShokanKigen());
        }

        // --------------------------------------------------------------------
        // 　　⑧計算無し処理
        // --------------------------------------------------------------------
        if ((Cr004Constants.CODE_SHOKANHOUHOU_1.equals(categoryShokanHouhou) || Cr004Constants.CODE_SHOKANHOUHOU_2
                .equals(categoryShokanHouhou))
                && (Cr004Constants.CODE_KURISHOJIYU_2.equals(categoryKurishojiyu)
                        || Cr004Constants.CODE_KURISHOJIYU_4.equals(categoryKurishojiyu) || StringUtils
                            .isEmpty(categoryKurishojiyu))) {

            // 　　　DTOの計算・条変起案中区分＝DTOの条件起案中区分
            // 　　　DTOの計算・賦金＝DTOの賦金
            // 　　　DTOの計算・元金不均等額＝DTOの繰償後元金不均等額(円)
            // 　　　DTOの計算・調整コード＝DTOの元金不均等額区分
            // 　　　DTOの計算・償還期限年月＝退避償還期限年月
            outDto.setPreserve_ID_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu());
            outDto.setPreserve_ID_M_Fukin(inDto.getID_M_Fukin());
            outDto.setPreserve_ID_M_GankinFukinto(inDto.getLblID_M_GankinFukintoAfterKurisho());
            outDto.setPreserve_ID_Code_Chosei(inDto.getID_Kubun_GankinFukintogaku());
            outDto.setPreserve_ID_Date_ShokanKigen(inDto.getID_Date_ShokanKigen());
        }

        // 　２．報告書履歴への追加処理
        // 　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、「履歴番号保持」に設定する。（最大番号＋１の番号を取得）
        // 　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、「報告書番号保持」を取得する。（最大番号＋１の番号を取得）
        String newIdHistory = pnCommonDBComponents.getIdHistoryRh();
        String newIdReport = pnCommonDBComponents.getIdReportRh();
        String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
        String timeReport = PNFormatUtils.formatDate(PNDateUtils.getSystemDate(),
                Cr004Constants.DATE_PATTERN_HHMMSS);
        String StrDateReport = PNFormatUtils.formatDate(PNDateUtils.getSystemDate(),
                Cr004Constants.DATE_PATTERN_HHMMSS_C);
        ReporthistoryEntity inEntityReporthistory = new ReporthistoryEntity();

        // 　　　２－３．報告書履歴データの登録用引数を設定する。（Entityに設定する項目が空文字の場合、NULLを設定する）
        // 　　　　単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、引数を設定する。

        // 　　　　　履歴番号の設定
        if (!newIdHistory.equals(outDto.getID_ID_History())) {
            // 　　　　　　　　DTOの履歴番号と「履歴番号保持」が異なる場合、「履歴番号保持」をDTOの履歴番号に設定する。
            // 　　　　　　　　DTOの履歴番号⇒ReportHistoryEntity.履歴番号
            outDto.setID_ID_History(newIdHistory);
            inEntityReporthistory.setID_History(outDto.getID_ID_History());
        }
        // 　　　　　報告書番号の設定
        if (!newIdReport.equals(outDto.getID_ID_Report())) {
            // 　　　　　　　　DTOの報告書番号と「報告書番号保持」が異なる場合、「報告書番号保持」をDTOの報告書番号に設定する。
            // 　　　　　　　　DTOの報告書番号⇒ReportHistoryEntity.報告書番号
            outDto.setID_ID_Report(newIdReport);
            inEntityReporthistory.setID_Report(outDto.getID_ID_Report());
        }
        // 　　　　　報告年月日の設定
        // 　　　　　　　　DTOの報告年月日を変換（yyyy年mm月dd日(X)⇒yyyymmdd）⇒ReportHistoryEntity.報告年月日
        inEntityReporthistory.setDate_Report(dateReport);
        // 　　　　　報告時分秒の設定
        // 　　　　　　　　システム時間を画面項目の報告時分秒に設定
        // 　　　　　　　　DTOの報告時分秒⇒ReportHistoryEntity.報告時分秒
        inEntityReporthistory.setTime_Report(timeReport);
        // 　　　　　ステータスの設定
        // 　　　　　　　　DTOのステータス⇒ReportHistoryEntity.ステータス
        inEntityReporthistory.setStatus(new BigDecimal(outDto.getID_Status()));
        // 　　　　　データコードの設定
        // 　　　　　　　　DTOのデータコード⇒ReportHistoryEntity.データコード
        inEntityReporthistory.setDataCode(outDto.getID_DataCode());
        // 　　　　　処理種別の設定
        // 　　　　　　　　DTOの処理種別⇒ReportHistoryEntity.処理種別
        inEntityReporthistory.setType_Process(outDto.getID_Type_Process());
        // 　　　　　取消済フラグの設定
        // 　　　　　　　　DTOの取消済フラグ⇒ReportHistoryEntity.取消済フラグ
        inEntityReporthistory.setFlag_Torikeshizumi(new BigDecimal(outDto.getID_Flag_Torikeshizumi()));
        // 　　　　　ユーザIDの設定
        // 　　　　　　　　DTOのユーザID⇒ReportHistoryEntity.ユーザID
        inEntityReporthistory.setUserID(outDto.getID_UserID());
        // 　　　　　扱店名の設定
        // 　　　　　　　　DTOの扱店名⇒ReportHistoryEntity.扱店名
        inEntityReporthistory.setName_Organization(outDto.getLblID_Name_Organization());
        // 　　　　　顧客名の設定
        // 　　　　　　　　DTOの顧客名⇒ReportHistoryEntity.顧客名
        inEntityReporthistory.setName_Customer(outDto.getLblID_Name_Customer());
        // 　　　　　公庫支店の設定
        // 　　　　　　　　DTOの公庫支店⇒ReportHistoryEntity.公庫支店
        inEntityReporthistory.setCode_KoukoShiten(outDto.getLblID_Code_ShokanHonShiten());
        // 　　　　　扱店の設定
        // 　　　　　　　　DTOの扱店⇒ReportHistoryEntity.扱店
        inEntityReporthistory.setCode_Organization(outDto.getLblID_Code_Organization());
        // 　　　　　店舗の設定
        // 　　　　　　　　DTOの店舗⇒ReportHistoryEntity.店舗
        inEntityReporthistory.setCode_Tenpo(outDto.getLblID_Code_Tenpo());
        // 　　　　　年度の設定
        // 　　　　　　　　DTOの年度を西暦に変換(Hxx/Hx→9999)⇒ReportHistoryEntity.年度
        inEntityReporthistory.setYear(PNCommonComponents.dateFmtJC_Gyy(outDto.getLblID_Year()));
        // 　　　　　方式資金の設定
        // 　　　　　　　　DTOの方式資金⇒ReportHistoryEntity.方式資金
        inEntityReporthistory.setCode_HoshikiShikin(outDto.getLblID_Code_HoshikiShikin());
        // 　　　　　稟議番号の設定
        // 　　　　　　　　DTOの番号⇒ReportHistoryEntity.稟議番号
        inEntityReporthistory.setID_Ringi(outDto.getLblID_ID_Ringi());
        // 　　　　　稟議番号枝番の設定
        // 　　　　　　　　DTOの枝番⇒ReportHistoryEntity.稟議番号枝番　　　　　※枝番が空文字の場合、０を設定
        inEntityReporthistory.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(outDto
                .getLblID_ID_RingiBranch()));
        // 　　　　　債権管理番号の設定
        // 　　　　　　　　DTOの債権管理番号⇒ReportHistoryEntity.債権管理番号
        inEntityReporthistory.setID_Credit(new BigDecimal(outDto.getID_ID_Credit()));

        // 　　　　　退避賦金、退避元金不均等額、退避元金不均等額区分、退避約定元金、退避約定利息、退避償還期限年月の設定
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避賦金
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避元金不均等額
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避元金不均等額区分
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避約定元金
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避約定利息
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.退避償還期限年月
        inEntityReporthistory.setKeep_M_Fukin(null);
        inEntityReporthistory.setKeep_M_GankinFukinto(null);
        inEntityReporthistory.setKeep_Kubun_GankinFukinto(null);
        inEntityReporthistory.setKeep_M_YakujoGankin(null);
        inEntityReporthistory.setKeep_M_YakujoRisoku(null);
        inEntityReporthistory.setKeep_Date_ShokanKigen(null);

        // 　　　　　　　　DTOの繰上償還事由コード＜＞空文字かつ、
        // 　　　　　　　　　DTOの繰上償還事由コード１文字目＜＞２かつ、DTOの繰上償還事由コード１文字目＜＞４かつ、
        // 　　　　　　　　　DTOの償還方法コード１文字目＜＞３かつ、DTOの償還方法コード１文字目＜＞９の場合、以下を行う
        if (!StringUtils.isEmpty(categoryKurishojiyu)
                && !Arrays.asList(
                        new String[]{Cr004Constants.CODE_KURISHOJIYU_2, Cr004Constants.CODE_KURISHOJIYU_4})
                        .contains(categoryKurishojiyu)
                && !Arrays.asList(
                        new String[]{Cr004Constants.CODE_SHOKANHOUHOU_3, Cr004Constants.CODE_SHOKANHOUHOU_9})
                        .contains(categoryShokanHouhou)) {
            // 　　　　　　　　　　※請求なし かつ 定期償還・特殊償還以外の場合、画面項目を設定（但し設定項目が空文字時は設定しない）
            // 　　　　　　　　　　DTOの賦金⇒ReportHistoryEntity.賦金
            if (!StringUtils.isEmpty(outDto.getID_M_Fukin())) {
                inEntityReporthistory.setKeep_M_Fukin(PNCommonUtils.cnvBigStrMoney(outDto.getID_M_Fukin()));
            }
            // 　　　　　　　　　　DTOの元金不均等額⇒ReportHistoryEntity.退避元金不均等額
            if (!StringUtils.isEmpty(outDto.getID_M_GankinFukinto())) {
                inEntityReporthistory.setKeep_M_GankinFukinto(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_GankinFukinto()));
            }
            // 　　　　　　　　　　DTOの元金不均等額⇒ReportHistoryEntity.退避元金不均等額区分
            if (!StringUtils.isEmpty(outDto.getID_Kubun_GankinFukintogaku())) {
                inEntityReporthistory.setKeep_Kubun_GankinFukinto(outDto.getID_Kubun_GankinFukintogaku());
            }
            // 　　　　　　　　　　DTOの約定元金・請求⇒ReportHistoryEntity.退避約定元金
            if (!StringUtils.isEmpty(outDto.getID_M_YakujoGankin_Seikyu())) {
                inEntityReporthistory.setKeep_M_YakujoGankin(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_YakujoGankin_Seikyu()));
            }
            // 　　　　　　　　　　DTOの約定利息・請求⇒ReportHistoryEntity.退避約定利息
            if (!StringUtils.isEmpty(outDto.getID_M_YakujoRisoku_Seikyu())) {
                inEntityReporthistory.setKeep_M_YakujoRisoku(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_YakujoRisoku_Seikyu()));
            }
            // 　　　　　　　　　　DTOの退避償還期限年月⇒ReportHistoryEntity.退避償還期限年月
            if (!StringUtils.isEmpty(outDto.getID_Date_ShokanKigen())) {
                inEntityReporthistory.setKeep_Date_ShokanKigen(outDto.getID_Date_ShokanKigen());
            }
        }

        // 　　　　　退避貸付金残高の設定
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.貸付金残高
        inEntityReporthistory.setKeep_M_KashitsukeZan(null);

        // 　　　　　　　　DTOの償還方法コード１文字目＜＞３かつ、DTOの償還方法コード１文字目＜＞９の場合、以下を行う
        if (!Cr004Constants.CODE_SHOKANHOUHOU_3.equals(categoryShokanHouhou)
                && !Cr004Constants.CODE_SHOKANHOUHOU_9.equals(categoryShokanHouhou)) {
            // 　　　　　　　　　　※定期償還・特殊償還以外の場合、画面項目を設定（但し設定項目が空文字時は設定しない）
            // 　　　　　　　　　　DTOの貸付金残高⇒ReportHistoryEntity.退避貸付金残高
            if (!StringUtils.isEmpty(outDto.getID_M_KashitsukeZandaka())) {
                inEntityReporthistory.setKeep_M_KashitsukeZan(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_KashitsukeZandaka()));
            }
        }

        // 　　　　　請求データの退避請求繰上償還利息、請求データの退避請求繰上償還元金の設定
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.請求データの退避請求繰上償還利息
        // 　　　　　　　　ＮＵＬＬ⇒ReportHistoryEntity.請求データの退避請求繰上償還元金
        inEntityReporthistory.setKeep_Seikyu_M_SeiKuriRisoku(null);
        inEntityReporthistory.setKeep_Seikyu_M_SeiKuriGankin(null);

        // 　　　　　　　　DTOの繰上償還事由コード＜＞空文字かつ、
        // 　　　　　　　　　DTOの繰上償還事由コード１文字目＜＞２かつ、DTOの繰上償還事由コード１文字目＜＞４
        if (!StringUtils.isEmpty(inDto.getLblID_Code_Kurishojiyu())
                && !Cr004Constants.CODE_KURISHOJIYU_2.equals(categoryKurishojiyu)
                && !Cr004Constants.CODE_KURISHOJIYU_4.equals(categoryKurishojiyu)) {
            // 　　　　　　　　　　※請求なしの場合、画面項目を設定（但し設定項目が空文字時は設定しない）
            // 　　　　　　　　　　請求繰上償還利息・請求⇒ReportHistoryEntity.請求データの退避請求繰上償還利息
            // 　　　　　　　　　　請求繰上償還元金・請求⇒ReportHistoryEntity.請求データの退避請求繰上償還元金
            if (!StringUtils.isEmpty(outDto.getID_M_SeiKuriRisoku_Seikyu())) {
                inEntityReporthistory.setKeep_Seikyu_M_SeiKuriRisoku(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_SeiKuriRisoku_Seikyu()));
            }
            if (!StringUtils.isEmpty(outDto.getID_M_SeiKuriGankin_Seikyu())) {
                inEntityReporthistory.setKeep_Seikyu_M_SeiKuriGankin(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_SeiKuriGankin_Seikyu()));
            }
        }

        // 　　　　　扱店別稟議データの退避条変起案中区分設定
        // 　　　　　　　　DTOの条件起案中区分⇒ReportHistoryEntity.扱店別稟議データの退避条変起案中区分
        inEntityReporthistory.setKeep_JohenKianchu(outDto.getID_Kubun_JohenKianchu());

        // 　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            reporthistorydao.insert(inEntityReporthistory);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNSystemException(dke);
        }

        // 　３．繰上償還報告書データの追加処理
        // 　　　３－１．繰上償還報告書データの存在チェック
        // 　　　　　繰上償還報告書データの存在チェックをする。（報告書番号のレコード有無）
        // 　　　　　　単テーブルアクセス定義「繰上償還報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　　　報告書番号＝DTOの報告書番号
        // 　　　　　　　　KurishoReportDAO.countByCondition
        KurishoreportEntity inEntityKurishoreport = new KurishoreportEntity();
        inEntityKurishoreport.setID_Report(outDto.getID_ID_Report());
        long hitcountKurishoreport = kurishoreportdao.countByCondition(inEntityKurishoreport);

        // 　　　　　繰上償還報告書データの取得件数＞０の場合、業務エラーとし、以降の処理は行わない。
        if (PNCommonConstants.RECORD_COUNT_ZERO < hitcountKurishoreport) {
            // 　　　　　　　エラーメッセージ：BA001 DB010
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }

        // 　　　３－２．繰上償還払込・充当報告書データの登録用引数を設定する。（設定する画面項目が空白の場合、NULLを設定する）
        // 　　　　単テーブルアクセス定義「繰上償還報告書データ　登録処理」を参照し、引数を設定する。
        // 　　　　　報告書番号の設定
        // 　　　　　　　　DTOの報告書番号⇒KurishoReportEntity.報告書番号
        inEntityKurishoreport.setID_Report(outDto.getID_ID_Report());
        // 　　　　　報告年月日の設定
        // 　　　　　　　　DTOの報告年月日を変換（yyyy年mm月dd日(X)⇒yyyymmdd）⇒KurishoReportEntity.報告年月日
        inEntityKurishoreport.setDate_Report(dateReport);
        // 　　　　　報告時分秒の設定
        // 　　　　　　　　DTOの報告時分秒⇒KurishoReportEntity.報告時分秒
        inEntityKurishoreport.setTime_Report(timeReport);
        // 　　　　　ユーザIDの設定
        // 　　　　　　　　DTOのユーザID⇒KurishoReportEntity.ユーザID
        inEntityKurishoreport.setUserID(outDto.getID_UserID());
        // 　　　　　伝送番号の設定
        // 　　　　　　　　DTOの伝送番号⇒KurishoReportEntity.伝送番号
        inEntityKurishoreport.setID_Denso(outDto.getID_ID_Denso());
        // 　　　　　データコードの設定
        // 　　　　　　　　DTOのデータコード⇒KurishoReportEntity.データコード
        inEntityKurishoreport.setDataCode(outDto.getID_DataCode());
        // 　　　　　公庫支店の設定
        // 　　　　　　　　DTOの公庫支店⇒KurishoReportEntity.公庫支店
        inEntityKurishoreport.setCode_KoukoShiten(outDto.getLblID_Code_ShokanHonShiten());
        // 　　　　　扱店の設定
        // 　　　　　　　　DTOの扱店⇒KurishoReportEntity.扱店
        inEntityKurishoreport.setCode_Organization(outDto.getLblID_Code_Organization());
        // 　　　　　店舗の設定
        // 　　　　　　　　DTOの店舗⇒KurishoReportEntity.店舗
        inEntityKurishoreport.setCode_Tenpo(outDto.getLblID_Code_Tenpo());
        // 　　　　　受託者勘定処理年月の設定
        // 　　　　　　　　DTOの受託者勘定処理年月を西暦に変換し設定(yyyymm)⇒KurishoReportEntity.受託者勘定処理年月
        inEntityKurishoreport.setDate_Jtkshori(PNCommonComponents.dateFmtJC_Gyymm(
                outDto.getLblID_Date_JtkShori(), ""));
        // 　　　　　送金日の設定
        // 　　　　　　　　DTOの送金日を西暦に変換し設定(yyyymmdd)⇒KurishoReportEntity.送金日
        if (!StringUtils.isEmpty(outDto.getLblID_Date_Sokin())) {
            inEntityKurishoreport.setDate_Sokin(PNCommonComponents.dateFmtJC_Gyymmdd(
                    outDto.getLblID_Date_Sokin(), ""));
        }
        // 　　　　　送金日番号の設定
        // 　　　　　　　　DTOの送金日番号⇒KurishoReportEntity.送金日番号
        inEntityKurishoreport.setID_Sokinbi(outDto.getLblID_ID_Sokinbi());
        // 　　　　　年度の設定
        // 　　　　　　　　DTOの年度を西暦に変換(Hxx/Hx→9999)⇒KurishoReportEntity.年度
        inEntityKurishoreport.setYear(PNCommonComponents.dateFmtJC_Gyy(outDto.getLblID_Year()));
        // 　　　　　方式資金の設定
        // 　　　　　　　　DTOの方式資金⇒KurishoReportEntity.方式資金
        inEntityKurishoreport.setCode_HoshikiShikin(outDto.getLblID_Code_HoshikiShikin());
        // 　　　　　稟議番号の設定
        // 　　　　　　　　DTOの番号⇒KurishoReportEntity.稟議番号
        inEntityKurishoreport.setID_Ringi(outDto.getLblID_ID_Ringi());
        // 　　　　　稟議番号枝番の設定
        // 　　　　　　　　DTOの枝番⇒KurishoReportEntity.稟議番号枝番　　　　　※枝番が空文字の場合、０を設定
        inEntityKurishoreport.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(outDto
                .getLblID_ID_RingiBranch()));
        // 　　　　　繰償後第１回払込期日の設定
        // 　　　　　　　　DTOの繰償後第１回払込期日を西暦に変換し設定(yyyymmdd)⇒KurishoReportEntity.繰償後第１回払込期日
        inEntityKurishoreport.setDate_FirstHaraikomiAfterKuriS(PNCommonComponents.dateFmtJC_Gyymmdd(
                outDto.getLblID_Date_FirstHaraikomiAfterKurisho(), ""));
        // 　　　　　入金日の設定
        // 　　　　　　　　DTOの入金日を西暦に変換し設定(yyyymmdd)⇒KurishoReportEntity.入金日
        inEntityKurishoreport.setDate_Nyukin(PNCommonComponents.dateFmtJC_Gyymmdd(
                outDto.getLblID_Date_Nyukin(), ""));
        // 　　　　　繰上償還事由コードの設定
        // 　　　　　　　　DTOの繰上償還事由コード⇒KurishoReportEntity.繰上償還事由コード
        if (!StringUtils.isEmpty(outDto.getLblID_Code_Kurishojiyu())) {
            inEntityKurishoreport.setCode_KurishoJiyu(outDto.getLblID_Code_Kurishojiyu());
        }
        // 　　　　　利息の設定
        // 　　　　　　　　DTOの利息⇒KurishoReportEntity.利息
        if (!StringUtils.isEmpty(outDto.getLblID_M_KurishoRisoku())) {
            inEntityKurishoreport.setM_KurishoRisoku(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_KurishoRisoku()));
        }
        // 　　　　　元金の設定
        // 　　　　　　　　DTOの元金⇒KurishoReportEntity.元金
        if (!StringUtils.isEmpty(outDto.getLblID_M_KurishoGankin())) {
            inEntityKurishoreport.setM_KurishoGankin(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_KurishoGankin()));
        }
        // 　　　　　仮受金からの充当額の設定
        // 　　　　　　　　DTOの仮受金からの充当額⇒KurishoReportEntity.仮受金からの充当額
        if (!StringUtils.isEmpty(outDto.getLblID_M_KariukeIppanJuto())) {
            inEntityKurishoreport.setM_KariukeIppanJuto(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_KariukeIppanJuto()));
        }
        // 　　　　　控除利息の設定
        // 　　　　　　　　DTOの控除利息⇒KurishoReportEntity.控除利息
        if (!StringUtils.isEmpty(outDto.getLblID_M_KojoRisoku())) {
            inEntityKurishoreport
                    .setM_KojoRisoku(PNCommonUtils.cnvBigStrMoney(outDto.getLblID_M_KojoRisoku()));
        }
        // 　　　　　送金額の設定
        // 　　　　　　　　DTOの送金額⇒KurishoReportEntity.送金額
        if (!StringUtils.isEmpty(outDto.getLblID_M_Sokin())) {
            inEntityKurishoreport.setM_Sokin(PNCommonUtils.cnvBigStrMoney(outDto.getLblID_M_Sokin()));
        }
        // 　　　　　繰償後残元金(円)の設定
        // 　　　　　　　　DTOの繰償後残元金(円)⇒KurishoReportEntity.繰償後残元金
        if (!StringUtils.isEmpty(outDto.getLblID_M_ZanGankinAfterKurisho())) {
            inEntityKurishoreport.setM_ZanAfterKurisho(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_ZanGankinAfterKurisho()));
        }
        // 　　　　　繰償後元金均等額の設定
        // 　　　　　　　　DTOの繰償後元金均等額(円)⇒KurishoReportEntity.繰償後元金均等額
        if (!StringUtils.isEmpty(outDto.getLblID_M_GankinKintoAfterKurisho())) {
            inEntityKurishoreport.setM_GankinKintoAfterKurisho(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_GankinKintoAfterKurisho()));
        }
        // 　　　　　繰償後元金不均等額の設定
        // 　　　　　　　　DTOの繰償後元金不均等額(円)⇒KurishoReportEntity.繰償後元金不均等額
        if (!StringUtils.isEmpty(outDto.getLblID_M_GankinFukintoAfterKurisho())) {
            inEntityKurishoreport.setM_GankinFukintoAfterKurisho(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_GankinFukintoAfterKurisho()));
        }
        // 　　　　　調整コードの設定
        // 　　　　　　　　DTOの計算・調整コード⇒KurishoReportEntity.調整コード
        if (!StringUtils.isEmpty(outDto.getRdoID_Code_chosei())) {
            inEntityKurishoreport.setCode_Chosei(outDto.getPreserve_ID_Code_Chosei());
        }
        // 　　　　　繰上償還手数料の設定
        // 　　　　　　　　DTOの繰上償還手数料(円)⇒KurishoReportEntity.繰上償還手数料
        if (!StringUtils.isEmpty(outDto.getLblID_M_KurishoCommision())) {
            inEntityKurishoreport.setM_KurishoCommission(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_KurishoCommision()));
        }
        // 　　　　　払込期日１の設定
        // 　　　　　　　　DTOの払込期日①⇒KurishoReportEntity.払込期日１
        if (!StringUtils.isEmpty(outDto.getLblID_Date_Haraikomi1())) {
            inEntityKurishoreport.setDate_Haraikomi1(PNCommonComponents.dateFmtJC_Gyymmdd(
                    outDto.getLblID_Date_Haraikomi1(), ""));
        }
        // 　　　　　払込元金１の設定
        // 　　　　　　　　DTOの払込元金①⇒KurishoReportEntity.払込元金１
        if (!StringUtils.isEmpty(outDto.getLblID_M_HaraikomiGankin1())) {
            inEntityKurishoreport.setM_HaraikomiGankin1(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_HaraikomiGankin1()));
        }
        // 　　　　　払込期日２の設定
        // 　　　　　　　　DTOの払込期日②⇒KurishoReportEntity.払込期日２
        if (!StringUtils.isEmpty(outDto.getLblID_Date_Haraikomi2())) {
            inEntityKurishoreport.setDate_Haraikomi2(PNCommonComponents.dateFmtJC_Gyymmdd(
                    outDto.getLblID_Date_Haraikomi2(), ""));
        }
        // 　　　　　払込元金２の設定
        // 　　　　　　　　DTOの払込元金②⇒KurishoReportEntity.払込元金２
        if (!StringUtils.isEmpty(outDto.getLblID_M_HaraikomiGankin2())) {
            inEntityKurishoreport.setM_HaraikomiGankin2(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_HaraikomiGankin2()));
        }
        // 　　　　　払込期日３の設定
        // 　　　　　　　　DTOの払込期日③⇒KurishoReportEntity.払込期日３
        if (!StringUtils.isEmpty(outDto.getLblID_Date_Haraikomi3())) {
            inEntityKurishoreport.setDate_Haraikomi3(PNCommonComponents.dateFmtJC_Gyymmdd(
                    outDto.getLblID_Date_Haraikomi3(), ""));
        }
        // 　　　　　払込元金３の設定
        // 　　　　　　　　DTOの払込元金③⇒KurishoReportEntity.払込元金３
        if (!StringUtils.isEmpty(outDto.getLblID_M_HaraikomiGankin3())) {
            inEntityKurishoreport.setM_HaraikomiGankin3(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_HaraikomiGankin3()));
        }
        // 　　　　　払込期日４の設定
        // 　　　　　　　　DTOの払込期日④⇒KurishoReportEntity.払込期日４
        if (!StringUtils.isEmpty(outDto.getLblID_Date_Haraikomi4())) {
            inEntityKurishoreport.setDate_Haraikomi4(PNCommonComponents.dateFmtJC_Gyymmdd(
                    outDto.getLblID_Date_Haraikomi4(), ""));
        }
        // 　　　　　払込元金４の設定
        // 　　　　　　　　DTOの払込元金④⇒KurishoReportEntity.払込元金４
        if (!StringUtils.isEmpty(outDto.getLblID_M_HaraikomiGankin4())) {
            inEntityKurishoreport.setM_HaraikomiGankin4(PNCommonUtils.cnvBigStrMoney(outDto
                    .getLblID_M_HaraikomiGankin4()));
        }
        // 　　　　　扱店名の設定
        // 　　　　　　　　DTOの扱店名⇒KurishoReportEntity.扱店名
        inEntityKurishoreport.setName_Organization(outDto.getLblID_Name_Organization());
        // 　　　　　顧客名の設定
        // 　　　　　　　　DTOの顧客名⇒KurishoReportEntity.顧客名
        inEntityKurishoreport.setName_Customer(outDto.getLblID_Name_Customer());
        // 　　　　KurishoReportDAO.insert
        // KurishoReportEntity inEntity = new KurishoReportEntity();
        try {
            kurishoreportdao.insert(inEntityKurishoreport);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNSystemException(dke);
        }

        // 　４．請求データの更新処理
        // 　　　DTOの完了画面メッセージ表示要フラグに不要(False)を設定
        outDto.setFlgSeikyuUpdate(false);

        // 　　　DTOの請求データ更新要否フラグが更新要(True)の場合、以下を行う
        if (outDto.getID_SeikyunashiKurisho()) {

            // 　　　　　償還方法コード＜＞３かつ、償還方法コード＜＞９の場合、以下を行う
            if (!Cr004Constants.CODE_KURISHOJIYU_3.equals(categoryShokanHouhou)
                    && !Cr004Constants.CODE_KURISHOJIYU_9.equals(categoryShokanHouhou)) {

                // 　　　　　　　DTOの完了画面メッセージ表示要フラグに要(True)を設定
                outDto.setFlgSeikyuUpdate(true);

                // 　　　　　　　請求データの存在チェックをする。
                // 　　　　　　　単テーブルアクセス定義「SeikyuDAO　単テーブルアクセスNo.2」を参照し、条件を設定する。
                // 　　　　　　　　・債権管理番号：DTOの債権管理番号
                // 　　　　　　　　・払込年月日：償還後第1回払込期日
                // 　　　　　　　SeikyuDAO.countByCondition
                SeikyuEntity inEntitySeikyu = new SeikyuEntity();
                inEntitySeikyu.setID_Credit(new BigDecimal(outDto.getID_ID_Credit()));
                inEntitySeikyu.setDate_Haraikomi(PNCommonComponents.dateFmtJC_Gyymmdd(
                        outDto.getLblID_Date_FirstHaraikomiAfterKurisho(), ""));
                long hitcountSeikyu = seikyudao.countByCondition(inEntitySeikyu);

                // 　　　　　　　取得した件数＝０の場合、業務エラーとする。　
                if (PNCommonConstants.RECORD_COUNT_ZERO == hitcountSeikyu) {
                    // 　　　　　　　　　エラーメッセージ：BA001、DB011
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E);
                }

                // 　　　　　　　取得した件数＞１の場合、業務エラーとする。
                if (PNCommonConstants.RECORD_COUNT_ONE < hitcountSeikyu) {
                    // 　　　　　　　　　エラーメッセージ：BA001、DB004
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E);
                }

                // 　　　　　　　請求データの排他読込を行う。
                // 　　　　　　　　単テーブルアクセス定義「「SeikyuDAO　単テーブルアクセスNo.3」を参照し、条件を設定する。
                // 　　　　　　　　・債権管理番号：DTOの債権管理番号
                // 　　　　　　　　・払込年月日：償還後第1回払込期日
                // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
                // SeikyuEntity inEntity = new SeikyuEntity();
                try {
                    SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntitySeikyu);
                    if (null == outEntity) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // すでに更新されているかチェック処理を記述
                } catch (CFWFindParameterException fpe) {
                    // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                } catch (CFWForUpdateException fue) {
                    // 排他エラー
                    // 　　　　　　　排他エラーの場合、業務エラーとする。　
                    // 　　　　　　　　　エラーメッセージ：BA001、DB007
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                }

                // 　　　　　　　請求データの更新用引数を設定する。
                // 　　　　　　　　単テーブルアクセス定義「SeikyuDAO　単テーブルアクセスNo.1」を参照し、引数を設定する。
                // 　　　　　　　　　※更新値が空文字の場合、NULLを設定する
                // 　　　　　　　　・約定元金：DTOの計算・賦金・約定元金
                // 　　　　　　　　・約定利息：DTOの計算・賦金・約定利息
                if (!StringUtils.isEmpty(outDto.getPreserve_ID_M_YakujoGankin())) {
                    inEntitySeikyu.setM_YakujoGankin(PNCommonUtils.cnvBigStrMoney(outDto
                            .getPreserve_ID_M_YakujoGankin()));
                } else {
                    inEntitySeikyu.setM_YakujoGankin(BigDecimal.ZERO);
                }
                if (!StringUtils.isEmpty(outDto.getPreserve_ID_M_YakujoRisoku())) {
                    inEntitySeikyu.setM_YakujoRisoku(PNCommonUtils.cnvBigStrMoney(outDto
                            .getPreserve_ID_M_YakujoRisoku()));
                } else {
                    inEntitySeikyu.setM_YakujoRisoku(BigDecimal.ZERO);
                }
                // 　　　　　　　　SeikyuDAO.update
                // SeikyuEntity inEntity = new SeikyuEntity();
                // 更新情報を転記する処理を記述
                //
                try {
                    // 更新の実行
                    seikyudao.update(inEntitySeikyu);
                    // 画面に必要な値を返却する処理を記述
                } catch (CFWFindParameterException fpe) {
                    // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                } catch (CFWDuplicateKeyException dke) {
                    // 主キー更新時の一意性制約エラー
                    throw new PNSystemException(dke);
                }
            }
        }

        // 　５．扱店別稟議データの更新
        // 　　　扱店別稟議データの存在チェックをする。
        // 　　　　複数テーブルアクセス定義「AringDAO　単テーブルアクセスNo.2」を参照し、条件を設定する。
        // 　　　　・債権管理番号：DTOの債権管理番号
        AringiEntity inEntityAringi = new AringiEntity();
        inEntityAringi.setID_Credit(new BigDecimal(outDto.getID_ID_Credit()));
        // 　　　　扱店別稟議データの更新用引数を設定する。
        // 　　　　複数テーブルアクセス定義「AringDAO　単テーブルアクセスNo.1」を参照し、条件を設定する。
        // 　　　　　※更新値が空文字の場合、NULLを設定する
        // 　　　　　賦金の設定
        // 　　　　　　　　DTOの計算・賦金⇒AringiEntity.賦金
        if (!StringUtils.isEmpty(outDto.getPreserve_ID_M_Fukin())) {
            inEntityAringi.setM_Fukin(PNCommonUtils.cnvBigStrMoney(outDto.getPreserve_ID_M_Fukin()));
        } else {
            inEntityAringi.setM_Fukin(BigDecimal.ZERO);
        }
        // 　　　　　元金不均等額の設定
        // 　　　　　　　　DTOの計算・元金不均等額⇒AringiEntity.元金不均等額
        if (!StringUtils.isEmpty(outDto.getPreserve_ID_M_GankinFukinto())) {
            inEntityAringi.setM_GankinFukinto(PNCommonUtils.cnvBigStrMoney(outDto
                    .getPreserve_ID_M_GankinFukinto()));
        } else {
            inEntityAringi.setM_GankinFukinto(BigDecimal.ZERO);
        }
        // 　　　　　元金不均等額区分の設定
        // 　　　　　　　　DTOの計算・調整コード⇒AringiEntity.元金不均等額区分
        if (!StringUtils.isEmpty(outDto.getPreserve_ID_Code_Chosei())) {
            inEntityAringi.setKubun_GankinFukintogaku(outDto.getPreserve_ID_Code_Chosei());
        } else {
            inEntityAringi.setKubun_GankinFukintogaku(null);
        }
        // 　　　　　償還期限年月の設定
        // 　　　　　　　　DTOの計算・償還期限年月⇒AringiEntity.償還期限年月
        inEntityAringi.setDate_ShokanKigen(outDto.getPreserve_ID_Date_ShokanKigen());
        // 　　　　　条変起案中区分の設定
        // 　　　　　　　　DTO項目の計算・条変起案中区分⇒AringiEntity.条変起案中区分
        inEntityAringi.setKubun_JohenKianchu(outDto.getPreserve_ID_Kubun_JohenKianchu());

        // 　　　　　貸付金残高の設定　　　　　　※定期償還、特殊償還の場合は元の残高のままとする。それ以外は繰上償還後残元金を新たな残高とする。
        // 　　　　　　　償還方法コードの１文字目が３又は、９の場合、以下を設定する
        if (Cr004Constants.CODE_SHOKANHOUHOU_3.equals(categoryShokanHouhou)
                || Cr004Constants.CODE_SHOKANHOUHOU_9.equals(categoryShokanHouhou)) {
            // 　　　　　　　　　DTO項目の貸付金残高⇒AringiEntity.貸付金残高
            if (!StringUtils.isEmpty(outDto.getID_M_KashitsukeZandaka())) {
                inEntityAringi.setM_KashitsukeZandaka(PNCommonUtils.cnvBigStrMoney(outDto
                        .getID_M_KashitsukeZandaka()));
            } else {
                inEntityAringi.setM_KashitsukeZandaka(BigDecimal.ZERO);
            }
        } else {
            // 　　　　　　　上記以外(else)の場合、以下を設定する
            // 　　　　　　　　　DTO項目の繰償後残元金(円)⇒AringiEntity.貸付金残高
            if (!StringUtils.isEmpty(outDto.getLblID_M_ZanGankinAfterKurisho())) {
                inEntityAringi.setM_KashitsukeZandaka(PNCommonUtils.cnvBigStrMoney(outDto
                        .getLblID_M_ZanGankinAfterKurisho()));
            } else {
                inEntityAringi.setM_KashitsukeZandaka(BigDecimal.ZERO);
            }
        }

        // 　　　　　最新更新日時の設定
        inEntityAringi.setData_LastUpDate(cnvTimeStamp(dateReport, StrDateReport));

        try {

            // 　　　　AringiDAO.findByPrimaryKeyForUpdate
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntityAringi);

            if (null == outEntity) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

            // すでに更新されているかチェック処理を記述
            // 　　　　取得データの最新更新日時＜＞DTOの稟議・最新更新日時の場合、業務エラーとする。
            if (!PNCommonComponents.diffDate(outDto.getID_Data_LastUpDate(), outEntity.getData_LastUpDate())) {
                // 　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

            // 更新情報を転記する処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            // 　　　　排他エラーの場合、業務エラーとする。　
            // 　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }

        // 　　　　AringiDAO.update
        // AringiEntity inEntity = new AringiEntity();
        try {
            // 更新の実行
            aringidao.update(inEntityAringi);
            // 画面に必要な値を返却する処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNSystemException(dke);
        }

        return outDto;
    }

    /**
     * 元利金均等償還・期限固定時の処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO ganrikinShokanFukinEdit1(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 据置期限年月
        String sueokiKigen = inDto.getID_Date_SueokiKigen();
        // 退避償還期限年月
        String shokanKigen = inDto.getID_Date_ShokanKigen();
        // 償還後第1回払込期日
        String firstHaraikomiAfterKurisho = PNCommonComponents.dateFmtJC_Gyymmdd(
                inDto.getLblID_Date_FirstHaraikomiAfterKurisho(), "");

        // 償還期限月数ワーク
        int tmpShokanKigenMonth = 0;
        // 償還月数ワーク
        int tmpShokanMonth = 0;
        // 償還回数ワーク
        int tmpShokanCount = 0;

        // 　　　（元利金均等償還・期限固定時の賦金・償還期限・約定元金・約定利息を算出する。）
        // 　　　DTOの計算・賦金・約定元金に空文字を設定
        // 　　　DTOの計算・賦金・約定利息に空文字を設定
        // 　　　DTOの計算・償還期限年月に退避償還期限年月を設定
        outDto.setPreserve_ID_M_YakujoGankin("");
        outDto.setPreserve_ID_M_YakujoRisoku("");
        outDto.setPreserve_ID_Date_ShokanKigen(shokanKigen);

        // 償還期限月数
        tmpShokanKigenMonth = getSyokanKigenMonth(sueokiKigen, firstHaraikomiAfterKurisho, shokanKigen);

        // 償還月数取得
        tmpShokanMonth = getShiyoukanMonth(inDto.getID_Code_ShokanHouhou());

        // 据置期限が存在するかつ償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
        if (!StringUtils.isEmpty(sueokiKigen)
                && 0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　　　　　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        } else {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　＋　１　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth + 1).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        }

        // 　　　賦金計算　（共通処理を使用し、賦金を計算する。　戻り値Listで、賦金計算結果、初回約定元金を取得する）
        // 　　　　（計算パラメータ）
        // 　　　　・貸付金残高：DTOの繰償後残元金(円)を設定
        // 　　　　・年利率（x1000）：DTOの利率を設定
        // 　　　　・年払い回数：償還方法コード
        // 　　　　・償還回数：償還回数ワーク
        // 　　　　（計算結果）
        List<BigDecimal> fukinList = PNKeisanFukin.getFukin(
                PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_ZanGankinAfterKurisho()),
                inDto.getID_Riritsu(), inDto.getID_Code_ShokanHouhou(), tmpShokanCount);

        // 　　　　　計算エラー時、業務エラーとする。　　　　　　　　計算失敗のエラー。
        if (RETRUN_ERROR.equals(fukinList.get(0))) {
            // 　　　　　　　エラーメッセージ：PM9990E
            throw new PNServiceException(PNCommonMessageConstants.PM9990E, new String[]{""}, false);
        }

        // 　　　　　取得した賦金計算結果をDTOの計算・賦金に設定する
        // 　　　　　取得した初回約定元金をDTOの計算・賦金・約定元金に設定する
        outDto.setPreserve_ID_M_Fukin(fukinList.get(0).toString());
        // 　　　約定元金・請求にデータがある（空文字、０以外）場合、以下を行う
        if (!"0".equals(PNCommonComponents.cnvNulltoZero(inDto.getID_M_YakujoGankin_Seikyu()))) {
            outDto.setPreserve_ID_M_YakujoGankin(fukinList.get(1).toString());
        } else {
            // 　　　上記以外(else)の場合、以下を行う
            // 　　　　　DTOの計算・賦金・約定元金に０を設定
            outDto.setPreserve_ID_M_YakujoGankin("0");
        }

        return outDto;
    }

    /**
     * 元利金均等償還・期限短縮時の処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO ganrikinShokanFukinEdit2(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);
        // 据置期限年月
        String sueokiKigen = PNCommonComponents.cnvNulltoBlank(inDto.getID_Date_SueokiKigen());
        // 退避償還期限年月
        String shokanKigen = PNCommonComponents.cnvNulltoBlank(inDto.getID_Date_ShokanKigen());
        // 償還後第1回払込期日
        String firstHaraikomiAfterKurisho = PNCommonComponents.dateFmtJC_Gyymmdd(
                inDto.getLblID_Date_FirstHaraikomiAfterKurisho(), "");
        // 繰償後残元金(円)
        BigDecimal zanGankinAfterKurisho = PNCommonUtils.cnvBigStrMoney(inDto
                .getLblID_M_ZanGankinAfterKurisho());

        // 元金ワーク
        BigDecimal tmpGankin = BigDecimal.ZERO;
        // 約定検索条件
        String yakujoSearchCondition = "";
        // 約定日ワーク
        String tmpDateYakujo = "";
        // 償還期限年月ワーク
        String tmpShokanKigenYearMonth = "";
        // 償還期限月数ワーク
        int tmpShokanKigenMonth = 0;
        // 償還月数ワーク
        int tmpShokanMonth = 0;
        // 償還回数ワーク
        int tmpShokanCount = 0;

        // 　　　据置期限年月にデータがある（ＮＵＬＬ、空文字以外）場合、以下を行う
        if (!StringUtils.isEmpty(sueokiKigen)) {
            // 　　　　　償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
            if (0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
                // 　　　　　　　約定日ワークに据置期限年月と元利金払込月日の日（３文字目から２文字）を連結し設定
                // 　　　　　　　約定検索条件：０　（払込年月日＞払込年月日指定）
                tmpDateYakujo = sueokiKigen + inDto.getID_Date_GanrikinHaraiKomi().substring(2, 4);
                yakujoSearchCondition = Cr004Constants.KIND_SEARCHYAKUJO_0;
            } else {
                // 　　　　　以外(else)の場合、以下を行う
                // 　　　　　　　約定日ワークに償還後第1回払込期日を設定
                // 　　　　　　　約定検索条件：１　（払込年月日≧払込年月日指定）
                tmpDateYakujo = firstHaraikomiAfterKurisho;
                yakujoSearchCondition = Cr004Constants.KIND_SEARCHYAKUJO_1;
            }
        } else {
            // 　　　以外(else)の場合、以下を行う
            // 　　　　　約定日ワークに償還後第1回払込期日を設定
            // 　　　　　約定検索条件：１　（払込年月日≧払込年月日指定）
            tmpDateYakujo = firstHaraikomiAfterKurisho;
            yakujoSearchCondition = Cr004Constants.KIND_SEARCHYAKUJO_1;
        }

        // 　　　元金ワークにDTOの元金(円)を設定
        // 　　　カウンタ＝０
        // 　　　ループ（元金ワーク＞０の間）
        tmpGankin = PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_KurishoGankin());
        int loopCount = 0;
        while (0 < tmpGankin.compareTo(BigDecimal.ZERO)) {

            // 　　　　　カウンタを＋１
            loopCount++;

            // 　　　　　カウンタ＞１の場合、以下を行う　　（ループ２回目以降の場合）
            // 　　　　　　　約定検索条件：０　（払込年月日＞払込年月日指定）
            if (1 < loopCount) {
                yakujoSearchCondition = Cr004Constants.KIND_SEARCHYAKUJO_0;
            }

            // 　　　　　約定データ取得の検索条件を設定
            // 　　　　　　複数テーブルアクセス定義の「Cr004_05ResultYakujo1DAO」を参照し、条件を設定する。（検索条件は設定値を継続使用）
            // 　　　　　　・債権管理番号：債権管理番号
            // 　　　　　　・払込年月日：約定日ワーク
            // 　　　　　　Cr004_05ResultYakujo1DAO.findByCondition
            List<Cr004_05ResultYakujo1Entity> outEntityList = getYakujoData(inDto.getID_ID_Credit(),
                    yakujoSearchCondition, tmpDateYakujo);

            // 　　　　　取得件数無しの場合、業務エラーとする　　　　　　　　元金ワークが０以下になる前に約定データ無しとなった場合。
            // 　　　　　　　エラーメッセージ：PM9010E
            if (PNCommonConstants.RECORD_COUNT_ZERO == outEntityList.size()) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[]{""}, false);
            }

            // 　　　　　元金ワーク＝元金ワーク　－　取得した約定元金
            // 　　　　　約定日ワークに取得した払込年月日を設定
            tmpGankin = tmpGankin.subtract(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                    .getM_YakujoGankin()));
            tmpDateYakujo = outEntityList.get(0).getDate_Haraikomi();

            // 　　　ループＥｎｄ
        }

        // 　　　DTOの計算・賦金・約定元金に空文字を設定
        // 　　　DTOの計算・賦金・約定利息に空文字を設定
        outDto.setPreserve_ID_M_YakujoGankin("");
        outDto.setPreserve_ID_M_YakujoRisoku("");

        // 　　　元金ワーク＝０の場合、以下を行う
        if (BigDecimal.ZERO.equals(tmpGankin)) {
            // 　　　　　繰償後残元金＝０の場合、以下を行う
            if (BigDecimal.ZERO.equals(zanGankinAfterKurisho)) {
                // 　　　　　　　DTOの計算・賦金・約定元金に０を設定
                // 　　　　　　　DTOの計算・賦金・約定利息に０を設定
                outDto.setPreserve_ID_M_YakujoGankin("0");
                outDto.setPreserve_ID_M_YakujoRisoku("0");
            } else {
                // 　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　約定データ取得の検索条件を設定
                // 　　　　　　　　複数テーブルアクセス定義の「Cr004_05ResultYakujo1DAO」を参照し、条件を設定する。
                // 　　　　　　　　・債権管理番号：債権管理番号
                // 　　　　　　　　・約定検索条件：０　（払込年月日＞払込年月日指定）
                // 　　　　　　　　・払込年月日：約定日ワーク
                // 　　　　　　　　Cr004_05ResultYakujo1DAO.findByCondition
                List<Cr004_05ResultYakujo1Entity> outEntityList = getYakujoData(inDto.getID_ID_Credit(),
                        Cr004Constants.KIND_SEARCHYAKUJO_0, tmpDateYakujo);

                // 　　　　　　　取得件数無しの場合、業務エラーとする　　　　　　　本状態で約定データ無しは想定外。
                // 　　　　　　　　　エラーメッセージ：PM9010E
                if (PNCommonConstants.RECORD_COUNT_ZERO == outEntityList.size()) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[]{""}, false);
                }

                // 　　　　　　　DTOの計算・賦金・約定元金に取得した約定元金を設定
                // 　　　　　　　DTOの計算・賦金・約定利息に取得した約定利息を設定
                outDto.setPreserve_ID_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(
                        outEntityList.get(0).getM_YakujoGankin()).toString());
                outDto.setPreserve_ID_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(
                        outEntityList.get(0).getM_YakujoRisoku()).toString());
            }
        }

        // 償還期限月数
        tmpShokanKigenMonth = getSyokanKigenMonth(sueokiKigen, firstHaraikomiAfterKurisho, shokanKigen);

        // 償還月数取得
        tmpShokanMonth = getShiyoukanMonth(inDto.getID_Code_ShokanHouhou());

        // 据置期限が存在するかつ償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
        if (!StringUtils.isEmpty(sueokiKigen)
                && 0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　　　　　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        } else {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　＋　１　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth + 1).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        }

        // 　　　元金ワーク＜＞０場合、以下を行う　　※入力約定元金が約定データｎ件分の約定元金合計と釣り合わないとき
        // 　　　　　繰上償還後の償還回数ワーク＝償還回数ワーク－（ループカウンタ－１）
        // 　　　上記以外(else)の場合、以下を行う　　※入力約定元金が約定データｎ件分の約定元金合計と釣り合ったとき
        // 　　　　　繰上償還後の償還回数ワーク＝償還回数ワーク－ループカウンタ
        if (!BigDecimal.ZERO.equals(tmpGankin)) {
            tmpShokanCount = tmpShokanCount - (loopCount - 1);
        } else {
            tmpShokanCount = tmpShokanCount - loopCount;
        }

        // 　　　繰上償還後の償還回数ワーク＝０の場合、以下を行う
        if (0 == tmpShokanCount) {
            // 　　　　　償還期限月数ワーク＝繰上償還後の償還回数ワーク＊償還月数ワーク
            // 　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、償還期限月数ワーク値分の月数を加算し計算
            tmpShokanKigenMonth = tmpShokanCount * tmpShokanMonth;
            tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpShokanKigenMonth);
        } else {
            // 　　　上記以外(else)の場合、以下を行う
            // 　　　　　据置期限年月にデータがある（ＮＵＬＬ、空文字以外）場合、以下を行う
            if (!StringUtils.isEmpty(sueokiKigen)) {
                // 　　　　　　　償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
                if (0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
                    // 　　　　　　　　　償還期限月数ワーク＝繰上償還後の償還回数ワーク＊償還月数ワーク
                    // 　　　　　　　　　償還期限年月ワーク＝据置期限年月＋"01"に対して、償還期限月数ワーク値分の月数を加算し計算
                    tmpShokanKigenMonth = tmpShokanCount * tmpShokanMonth;
                    tmpShokanKigenYearMonth = addStrMonth(sueokiKigen + PNCommonConstants.FIRST_DAY_OF_MONTH,
                            tmpShokanKigenMonth);
                } else {
                    // 　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　償還期限月数ワーク＝（繰上償還後の償還回数ワーク－１）＊償還月数ワーク
                    // 　　　　　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、償還期限月数ワーク値分の月数を加算し計算
                    tmpShokanKigenMonth = (tmpShokanCount - 1) * tmpShokanMonth;
                    tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpShokanKigenMonth);
                }
            } else {
                // 　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　償還期限月数ワーク＝（繰上償還後の償還回数ワーク－１）＊償還月数ワーク
                // 　　　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、償還期限月数ワーク値分の月数を加算し計算
                tmpShokanKigenMonth = (tmpShokanCount - 1) * tmpShokanMonth;
                tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpShokanKigenMonth);
            }

            // 　　　DTOの計算・償還期限年月に償還期限年月ワークを設定
            outDto.setPreserve_ID_Date_ShokanKigen(tmpShokanKigenYearMonth.substring(0, 6));

            List<BigDecimal> fukinList = null;
            // 　　　元金ワーク＜＞０場合、以下を行う　　※入力約定元金が約定データｎ件分の約定元金合計と釣り合わないとき
            if (!BigDecimal.ZERO.equals(tmpGankin)) {
                // 　　　　　賦金計算　（共通処理を使用し、賦金を計算する。　戻り値Listで、賦金計算結果、初回約定元金を取得する）
                // 　　　　　　（計算パラメータ）
                // 　　　　　　・貸付金残高：DTOの繰償後残元金(円)を設定
                // 　　　　　　・年利率（x1000）：DTOの利率を設定
                // 　　　　　　・年払い回数：償還方法コード
                // 　　　　　　・償還回数：繰上償還後の償還回数ワーク
                // 　　　　　　（計算結果）
                fukinList = PNKeisanFukin.getFukin(zanGankinAfterKurisho, inDto.getID_Riritsu(),
                        inDto.getID_Code_ShokanHouhou(), tmpShokanCount);
                // 　　　　　　　計算エラー時、業務エラーとする。　　　　計算失敗のエラー
                if (RETRUN_ERROR.equals(fukinList.get(0))) {
                    // 　　　　　　　　　エラーメッセージ：BA002　FEX004
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E, new String[]{""}, false);
                }
                // 　　　　　　　取得した賦金計算結果をDTOの計算・賦金に設定する
                outDto.setPreserve_ID_M_Fukin(fukinList.get(0).toString());
            } else {
                // 　　　上記以外(else)の場合、以下を行う
                // 　　　　　繰償後残元金(円)＝０の場合、以下を行う
                if (BigDecimal.ZERO.equals(zanGankinAfterKurisho)) {
                    // 　　　　　　　DTOの計算・賦金に０を設定する
                    outDto.setPreserve_ID_M_Fukin("0");
                } else {
                    // 　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　DTOの計算・賦金にDTOの賦金を設定する
                    outDto.setPreserve_ID_M_Fukin(inDto.getID_M_Fukin());
                }
            }

            // 　　　約定元金・請求にデータがある（空文字、０以外）場合、以下を行う
            if (!"0".equals(PNCommonComponents.cnvNulltoZero(inDto.getID_M_YakujoGankin_Seikyu()))) {
                // 　　　　　元金ワーク＜＞０場合、以下を行う　　※入力約定元金が約定データｎ件分の約定元金合計と釣り合わないとき
                if (!BigDecimal.ZERO.equals(tmpGankin)) {
                    // 　　　　　　　DTOの計算・賦金・約定元金に賦金計算で取得した初回約定元金を設定する
                    outDto.setPreserve_ID_M_YakujoGankin(fukinList.get(1).toString());
                }
                // 　　　　　上記以外(else)の場合、無処理
            } else {
                // 　　　上記以外(else)の場合、以下を行う
                // 　　　　　DTOの計算・賦金・約定元金に０を設定
                outDto.setPreserve_ID_M_YakujoGankin("0");
            }

        }

        return outDto;
    }

    /**
     * 元金均等償還・期限固定時の処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO gankinShokanFukinEdit(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 　　　DTOの計算・賦金にDTOの繰償後元金均等額(円)を設定
        // 　　　DTOの計算・元金不均等額にDTOの繰償後元金不均等額(円)を設定
        // 　　　DTOの計算・償還期限年月にDTOの退避償還期限年月
        // 　　　DTOの計算・調整コードにDTOの調整コードを設定
        outDto.setPreserve_ID_M_Fukin(inDto.getLblID_M_GankinKintoAfterKurisho());
        outDto.setPreserve_ID_M_GankinFukinto(inDto.getLblID_M_GankinFukintoAfterKurisho());
        outDto.setPreserve_ID_Date_ShokanKigen(inDto.getID_Date_ShokanKigen());
        outDto.setPreserve_ID_Code_Chosei(inDto.getRdoID_Code_chosei());

        return outDto;
    }

    /**
     * 元金均等償還・期限短縮時の処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO gankinShokanFukinEdit2(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 据置期限年月
        String sueokiKigen = PNCommonComponents.cnvNulltoBlank(inDto.getID_Date_SueokiKigen());
        // 退避償還期限年月
        String shokanKigen = PNCommonComponents.cnvNulltoBlank(inDto.getID_Date_ShokanKigen());
        // 償還後第1回払込期日
        String firstHaraikomiAfterKurisho = PNCommonComponents.dateFmtJC_Gyymmdd(
                inDto.getLblID_Date_FirstHaraikomiAfterKurisho(), "");
        // 賦金
        BigDecimal fukin = PNCommonUtils.cnvBigStrMoney(inDto.getID_M_Fukin());
        // 貸付金残高
        BigDecimal kashitsukeZandaka = PNCommonUtils.cnvBigStrMoney(inDto.getID_M_KashitsukeZandaka());
        // 元金
        BigDecimal kurishoGankin = PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_KurishoGankin());

        // 繰償後貸付残高ワーク
        BigDecimal tmpKurishogoKashitsukeZandaka = BigDecimal.ZERO;
        // 繰償後貸付残高余りワーク
        BigDecimal tmpMod = BigDecimal.ZERO;
        // 元利金不均等額ワーク
        BigDecimal tmpGanrikinFukintougaku = BigDecimal.ZERO;
        // 償還期限年月ワーク
        String tmpShokanKigenYearMonth = "";
        // 短縮後償還回数ワーク
        int tmpTansyukuShokanCount = 0;
        // 加算月数ワーク
        int tmpAddMonth = 0;
        // 償還期限月数ワーク
        int tmpShokanKigenMonth = 0;
        // 償還月数ワーク
        int tmpShokanMonth = 0;
        // 償還回数ワーク
        int tmpShokanCount = 0;

        // 　　　計算・賦金にDTOの賦金を設定
        outDto.setPreserve_ID_M_Fukin(inDto.getID_M_Fukin());

        // 　　　繰償後貸付残高ワーク＝貸付金残高－元金(円)　　　　　※計算対象が空文字時は０として計算する
        tmpKurishogoKashitsukeZandaka = kashitsukeZandaka.subtract(kurishoGankin);

        // 　　　短縮後の償還回数ワーク＝繰償後貸付残高ワーク／DTOの賦金　　　（除算は端数切捨て）
        tmpTansyukuShokanCount = tmpKurishogoKashitsukeZandaka.divide(fukin, Cr004Constants.SCALE_0,
                BigDecimal.ROUND_DOWN).intValue();

        // 　　　繰償後貸付残高余りワーク＝繰償後貸付残高ワークをDTOの賦金で割った余り
        tmpMod = tmpKurishogoKashitsukeZandaka.remainder(fukin);

        // 　　　繰償後貸付残高余りワーク＝０の場合、以下を行う
        if (BigDecimal.ZERO.equals(tmpMod)) {
            // ---------------------------------------------------------
            // 元利金不均等額ワーク＝０
            // ---------------------------------------------------------
            tmpGanrikinFukintougaku = BigDecimal.ZERO;
            // ---------------------------------------------------------
            // DTOの計算・調整コードに空文字を設定
            // ---------------------------------------------------------
            outDto.setPreserve_ID_Code_Chosei(Cr004Constants.CODE_CHOSEI_0_NASHI);
        } else {
            // 　　　上記以外(else)の場合、以下を行う
            // ---------------------------------------------------------
            // 元利金不均等額ワーク＝繰償後貸付残高余りワーク
            // ---------------------------------------------------------
            tmpGanrikinFukintougaku = tmpMod;
            // 短縮後の償還回数ワーク＝短縮後の償還回数ワーク＋１
            tmpTansyukuShokanCount = tmpTansyukuShokanCount + 1;
            // ---------------------------------------------------------
            // DTOの計算・調整コードに 2 を設定　※2:最終回
            // ---------------------------------------------------------
            outDto.setPreserve_ID_Code_Chosei(Cr004Constants.CODE_CHOSEI_2_SAISYU);
        }

        // 償還期限月数
        tmpShokanKigenMonth = getSyokanKigenMonth(sueokiKigen, firstHaraikomiAfterKurisho, shokanKigen);

        // 償還月数取得
        tmpShokanMonth = getShiyoukanMonth(inDto.getID_Code_ShokanHouhou());

        // 据置期限が存在するかつ償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
        if (!StringUtils.isEmpty(sueokiKigen)
                && 0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　　　　　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        } else {
            // 　　　償還回数ワーク＝償還期限月数ワーク／償還月数ワーク　＋　１　　　　　（除算は端数切捨て）
            tmpShokanCount = new BigDecimal(tmpShokanKigenMonth / tmpShokanMonth + 1).setScale(
                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN).intValue();
        }

        // 　　　償還回数ワーク＜短縮後の償還回数ワークの場合、以下を行う
        if (tmpShokanCount < tmpTansyukuShokanCount) {
            // 　　　　　元利金不均等額ワーク＞０の場合、以下を行う
            if (0 < tmpGanrikinFukintougaku.compareTo(BigDecimal.ZERO)) {
                // 　　　　　　　元利金不均等額ワーク＝元利金不均等額ワーク＋（短縮後の償還回数ワーク－償還回数ワーク）＊DTOの賦金
                tmpGanrikinFukintougaku = tmpGanrikinFukintougaku.add(new BigDecimal(tmpTansyukuShokanCount
                        - tmpShokanCount).multiply(fukin));
            } else {
                // 　　　　　以外(else)の場合、以下を行う
                // 　　　　　　　元利金不均等額ワーク＝DTOの賦金＋（短縮後の償還回数ワーク－償還回数ワーク）＊DTOの賦金
                // 　　　　　　　DTOの計算・調整コードに 2 を設定　　　　　　　　　　※2:最終回
                tmpGanrikinFukintougaku = fukin.add(new BigDecimal(tmpTansyukuShokanCount - tmpShokanCount)
                        .multiply(fukin));
                outDto.setPreserve_ID_Code_Chosei(Cr004Constants.CODE_CHOSEI_2_SAISYU);
            }
        }

        // --------------------------------
        // 元金不均等額
        // --------------------------------
        // 　　　計算・元金不均等額に元利金不均等額ワークを設定
        outDto.setPreserve_ID_M_GankinFukinto(tmpGanrikinFukintougaku.toString());

        // 　　　短縮後の償還回数ワーク＝０の場合、以下を行う
        if (0 == tmpTansyukuShokanCount) {
            // 　　　　　加算月数ワーク＝短縮後の償還回数ワーク＊償還月数ワーク
            // 　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、加算月数ワーク値分の月数を加算し計算
            tmpAddMonth = tmpTansyukuShokanCount * tmpShokanMonth;
            tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpAddMonth);
        } else {
            // 　　　以外(else)の場合、以下を行う
            // 　　　　　据置期限年月にデータがある（ＮＵＬＬ、空文字以外）場合、以下を行う
            if (!StringUtils.isEmpty(sueokiKigen)) {
                // 　　　　　　　償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
                if (0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
                    // 　　　　　　　　　償還期限月数ワーク＝短縮後の償還回数ワーク＊償還月数ワーク
                    // 　　　　　　　　　償還期限年月ワーク＝据置期限年月＋"01"に対して、償還期限月数ワーク値分の月数を加算し計算
                    tmpShokanKigenMonth = tmpTansyukuShokanCount * tmpShokanMonth;
                    tmpShokanKigenYearMonth = addStrMonth(sueokiKigen + PNCommonConstants.FIRST_DAY_OF_MONTH,
                            tmpShokanKigenMonth);
                } else {
                    // 　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　償還期限月数ワーク＝（短縮後の償還回数ワーク－１）＊償還月数ワーク
                    // 　　　　　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、償還期限月数ワーク値分の月数を加算し計算
                    tmpShokanKigenMonth = (tmpTansyukuShokanCount - 1) * tmpShokanMonth;
                    tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpShokanKigenMonth);
                }
            } else {
                // 　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　償還期限月数ワーク＝（短縮後の償還回数ワーク－１）＊償還月数ワーク
                // 　　　　　　　償還期限年月ワーク＝償還後第1回払込期日に対して、償還期限月数ワーク値分の月数を加算し計算
                tmpShokanKigenMonth = (tmpTansyukuShokanCount - 1) * tmpShokanMonth;
                tmpShokanKigenYearMonth = addStrMonth(firstHaraikomiAfterKurisho, tmpShokanKigenMonth);
            }
        }

        // -----------------------------------------
        // 償還期限年月
        // -----------------------------------------
        // 　　　償還期限年月ワークを設定の年月＞DTOの退避償還期限年月の場合、以下を行う
        if (0 < tmpShokanKigenYearMonth.substring(0, 6).compareTo(shokanKigen)) {
            // 　　　　　DTOの計算・償還期限年月にDTOの退避償還期限年月を設定
            outDto.setPreserve_ID_Date_ShokanKigen(shokanKigen);
        } else {
            // 　　　上記以外(else)の場合、以下を行う
            // 　　　　　DTOの計算・償還期限年月に償還期限年月ワークの年月を設定
            outDto.setPreserve_ID_Date_ShokanKigen(tmpShokanKigenYearMonth.substring(0, 6));
        }

        return outDto;
    }

    /**
     * 元利金均等償還時の約定利息算出処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO ganrikinShokanRisokuEdit(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 償還方法コード
        String shokanHouhou = inDto.getID_Code_ShokanHouhou();
        // 特利有効年月日
        String tokuriYuko = inDto.getID_Date_TokuriYuko();
        // 実行年月日
        String jikko = inDto.getID_Date_Jikko();
        // 償還後第1回払込期日
        String firstHaraikomiAfterKurisho = PNCommonComponents.dateFmtJC_Gyymmdd(
                inDto.getLblID_Date_FirstHaraikomiAfterKurisho(), "");
        // 貸付金残高
        BigDecimal kashitsukeZandaka = PNCommonUtils.cnvBigStrMoney(inDto.getID_M_KashitsukeZandaka());
        // 元金
        BigDecimal kurishoGankin = PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_KurishoGankin());
        // 繰償後残元金(円)
        BigDecimal zanGankinAfterKurisho = PNCommonUtils.cnvBigStrMoney(inDto
                .getLblID_M_ZanGankinAfterKurisho());
        // 計算・賦金
        BigDecimal preserveFukin = PNCommonUtils.cnvBigStrMoney(inDto.getPreserve_ID_M_Fukin());
        // 計算・賦金・約定元金
        BigDecimal preserveYakujoGankin = PNCommonUtils.cnvBigStrMoney(inDto.getPreserve_ID_M_YakujoGankin());
        // 計算・賦金・約定利息
        BigDecimal preserveYakujoRisoku = PNCommonUtils.cnvBigStrMoney(inDto.getPreserve_ID_M_YakujoRisoku());

        // 暫定約定利息ワーク
        BigDecimal tmpYakujoRisoku = BigDecimal.ZERO;
        // 暫定約定利息ワーク１
        BigDecimal tmpYakujoRisoku1 = BigDecimal.ZERO;
        // 暫定約定利息ワーク２
        BigDecimal tmpYakujoRisoku2 = BigDecimal.ZERO;
        // 特利ワーク
        BigDecimal tmpTokuri = BigDecimal.ZERO;
        // 利率ワーク
        BigDecimal tmpRiritsu = BigDecimal.ZERO;
        // 起算日ワーク
        String tmpDateKisan = "";
        // 精算日ワーク
        String tmpDateSeisan = "";
        // 特利有効年月日ワーク
        String tmpDateTokuriyukou = "";
        // 年払回数
        int tmpIntervalMonth = 0;
        // 日数ワーク１
        int tmpDay1 = 0;
        // 日数ワーク２
        int tmpDay2 = 0;
        // 約定データ取得済フラグ
        boolean yakujoSyutokuzumiFlag = false;

        // --------------------------------
        // 条変起案中区分：変更なし
        // --------------------------------
        // 　　　DTOの計算・条変起案中区分にDTOの条変起案中区分を設定
        outDto.setPreserve_ID_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu());

        // --------------------------------
        // 元金不均等額：０
        // --------------------------------
        // 　　　DTOの計算・元金不均等額に０を設定
        outDto.setPreserve_ID_M_GankinFukinto("0");

        // --------------------------------
        // 調整コード：なし
        // --------------------------------
        // 　　　DTOの計算・調整コードに空文字を設定
        outDto.setPreserve_ID_Code_Chosei(Cr004Constants.CODE_CHOSEI_0_NASHI);

        // --------------------------------
        // 約定利息
        // --------------------------------
        // 　　　DTOの計算・賦金・約定利息＝空文字の場合、以下を行う
        if (StringUtils.isEmpty(inDto.getPreserve_ID_M_YakujoRisoku())) {
            // 　　　　　DTOの繰償後残元金(円)＝０の場合、以下を行う
            if (BigDecimal.ZERO.equals(zanGankinAfterKurisho)) {
                // 　　　　　　　暫定約定利息ワーク＝０
                tmpYakujoRisoku = BigDecimal.ZERO;
            } else {
                // 　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　暫定約定利息ワーク＝計算・賦金－計算・賦金・約定元金
                tmpYakujoRisoku = preserveFukin.subtract(preserveYakujoGankin);
            }
            // 　　　　　DTOの計算・賦金・約定利息に暫定約定利息ワークを設定
            preserveYakujoRisoku = tmpYakujoRisoku;
        }

        // 　　　　　約定データ取得の検索条件を設定
        // 　　　　　　複数テーブルアクセス定義の「Cr004_05ResultYakujo1DAO」を参照し、条件を設定する。
        // 　　　　　　・債権管理番号：DTOの債権管理番号
        // 　　　　　　・約定検索条件：２　（払込年月日＜払込年月日指定）
        // 　　　　　　・払込年月日：DTOの償還後第1回払込期日
        // 　　　　　　Cr004_05ResultYakujo1DAO.findByCondition
        List<Cr004_05ResultYakujo1Entity> outEntityList = getYakujoData(inDto.getID_ID_Credit(),
                Cr004Constants.KIND_SEARCHYAKUJO_2, firstHaraikomiAfterKurisho);

        // 　　　　　取得件数が１件以上の場合、以下を行う
        if (0 < outEntityList.size()) {
            // 　　　　　　　起算日ワークに取得した払込年月日を設定する
            // 　　　　　　　約定データ取得済フラグ（ワーク）にTrue設定
            tmpDateKisan = outEntityList.get(0).getDate_Haraikomi();
            yakujoSyutokuzumiFlag = true;
        } else {
            // 　　　　　上記以外(else)の場合、以下を行う
            // 　　　　　　　起算日ワークに実行年月日を設定する
            // 　　　　　　　約定データ取得済フラグ（ワーク）にFalse設定
            tmpDateKisan = jikko;
            yakujoSyutokuzumiFlag = false;
        }

        // 　　　　　精算日にDTOの償還後第1回払込期日を設定
        tmpDateSeisan = firstHaraikomiAfterKurisho;

        // 　　　　　特利ワークにDTOの特利を設定（ＤＢ値のままなので、そのまま設定）
        // 　　　　　利率ワークにDTOの利率を設定（ＤＢ値のままなので、そのまま設定）
        tmpTokuri = PNCommonComponents.cnvStrtoBig(inDto.getID_Tokuri());
        tmpRiritsu = PNCommonComponents.cnvStrtoBig(inDto.getID_Riritsu());

        // 　　　　　約定データ取得済フラグ（ワーク）が取得未（False）の場合、以下を行う
        if (!yakujoSyutokuzumiFlag) {
            // 　　　　　　　DTOの特利有効年月日＝空文字又は、（DTOの特利有効年月日＜＞空文字かつ、利率ワーク≦特利ワーク）の場合、以下を行う
            if (StringUtils.isEmpty(tokuriYuko)
                    || (!StringUtils.isEmpty(tokuriYuko) && 0 <= tmpTokuri.compareTo(tmpRiritsu))) {

                // 　　　　　　　　　DTOの計算・賦金・約定元金＝０の場合、以下を行う
                if (BigDecimal.ZERO.equals(preserveYakujoGankin)) {
                    // 年払回数取得
                    tmpIntervalMonth = getIntervalMonth(shokanHouhou);
                    // 　　　　　　　　　　　暫定約定利息ワーク＝（（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク）／年払回数／１０００００　　(除算は都度、端数切捨て）
                    tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu))
                            .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                    BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);
                } else {
                    // 　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　暫定約定利息ワークにDTOの計算・賦金・約定利息を設定
                    tmpYakujoRisoku = preserveYakujoRisoku;
                }

                // 　　　　　　　特利有効年月日＜＞空文字かつ、利率ワーク＞特利ワークの場合、以下を行う
            } else if (!StringUtils.isEmpty(tokuriYuko) && 0 < tmpRiritsu.compareTo(tmpTokuri)) {

                // 　　　　　　　　　実行年月日≦特利有効年月日かつ、特利有効年月日≦償還後第1回払込期日の場合、以下を行う
                if (0 <= tokuriYuko.compareTo(jikko) && 0 <= firstHaraikomiAfterKurisho.compareTo(tokuriYuko)) {

                    // 　　　　　　　　　　　日数ワーク１に、特利有効年月日と実行年月日の差分日数を設定する。
                    // 　　　　　　　　　　　日数ワーク２に、償還後第1回払込期日と特利有効年月日の差分日数を設定する。
                    // 　　　　　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 　　　　　　　　　　　暫定約定利息ワーク２＝（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク／３６５＊日数ワーク２　　（端数有）
                    // 　　　　　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００＋暫定約定利息ワーク２／１０００００　　　　　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(tokuriYuko, jikko);
                    tmpDay2 = differenceDays(firstHaraikomiAfterKurisho, tokuriYuko);
                    tmpYakujoRisoku1 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku2 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay2));
                    tmpYakujoRisoku = (tmpYakujoRisoku1.divide(new BigDecimal(100000),
                            Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN)).add(tmpYakujoRisoku2.divide(
                            new BigDecimal(100000), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN));

                    // 　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　償還後第1回払込期日＜特利有効年月日の場合、以下を行う
                } else if (0 < tokuriYuko.compareTo(firstHaraikomiAfterKurisho)) {

                    // 日数ワーク１に、償還後第1回払込期日と実行年月日の差分日数を設定する。
                    // 暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(firstHaraikomiAfterKurisho, jikko);
                    tmpYakujoRisoku1 = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri))
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku = tmpYakujoRisoku1.divide(new BigDecimal(100000), Cr004Constants.SCALE_0,
                            BigDecimal.ROUND_DOWN);

                }
            }
        }

        // 　　　　　約定データ取得済フラグ（ワーク）が取得済（True）の場合、以下を行う
        if (yakujoSyutokuzumiFlag) {
            // 　　　　　　　DTOの特利有効年月日＝空文字又は、（DTOの特利有効年月日＜＞空文字かつ、利率ワーク≦特利ワーク）の場合、以下を行う
            if (StringUtils.isEmpty(tokuriYuko)
                    || (!StringUtils.isEmpty(tokuriYuko) && 0 <= tmpTokuri.compareTo(tmpRiritsu))) {

                // 　　　　　　　　　DTOの計算・賦金・約定元金＝０の場合、以下を行う
                if (BigDecimal.ZERO.equals(preserveYakujoGankin)) {
                    // 年払回数取得
                    tmpIntervalMonth = getIntervalMonth(shokanHouhou);
                    // 　　　　　　　　　　　暫定約定利息ワーク＝（（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク）／年払回数／１０００００　　(除算は都度、端数切捨て）
                    tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu))
                            .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                    BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);
                } else {
                    // 　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　暫定約定利息ワーク＝DTOの計算・賦金・約定利息
                    tmpYakujoRisoku = preserveYakujoRisoku;
                }

                // 　　　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　　　DTOの特利有効年月日＜＞空文字かつ、利率ワーク＞特利ワークの場合、以下を行う
            } else if (!StringUtils.isEmpty(tokuriYuko) && 0 > tmpTokuri.compareTo(tmpRiritsu)) {

                // 　　　　　　　　　　　特利有効年月日ワークにDTOの特利有効年月日を設定
                tmpDateTokuriyukou = tokuriYuko;

                // 　　　　　　　　　　　特利有効年月日ワーク＜起算日ワークの場合、以下を行う
                if (0 < tmpDateKisan.compareTo(tmpDateTokuriyukou)) {

                    // 　　　　　　　　　　　　　DTOの計算・賦金・約定元金＝０の場合、以下を行う
                    if (BigDecimal.ZERO.equals(preserveYakujoGankin)) {
                        // 年払回数取得
                        tmpIntervalMonth = getIntervalMonth(shokanHouhou);
                        // 暫定約定利息ワーク＝（（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク）／年払回数／１０００００　　(除算は都度、端数切捨て）
                        tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu))
                                .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                        BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                        Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);
                    } else {
                        // 　　　　　　　　　　　　　上記以外(else)の場合、以下を行う
                        // 　　　　　　　　　　　　　　　暫定約定利息ワーク＝DTOの計算・賦金・約定利息
                        tmpYakujoRisoku = preserveYakujoRisoku;
                    }

                    // 　　　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　　　起算日ワーク≦特利有効年月日かつ、特利有効年月日≦精算日の場合、以下を行う
                } else if (0 <= tmpDateTokuriyukou.compareTo(tmpDateKisan)
                        && 0 <= tmpDateSeisan.compareTo(tmpDateTokuriyukou)) {

                    // 　　　　　　　　　　　　　　　日数ワーク１に、起算日ワークと特利有効年月日ワークの差分日数を設定する。
                    // 　　　　　　　　　　　　　　　日数ワーク２に、特利有効年月日ワークのと精算日ワークの差分日数を設定する。
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク２＝（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク／３６５＊日数ワーク２　　（端数有）
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００＋暫定約定利息ワーク２／１０００００　　　　　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(tmpDateTokuriyukou, tmpDateKisan);
                    tmpDay2 = differenceDays(tmpDateSeisan, tmpDateTokuriyukou);
                    tmpYakujoRisoku1 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku2 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay2));
                    tmpYakujoRisoku = (tmpYakujoRisoku1.divide(new BigDecimal(100000),
                            Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN)).add(tmpYakujoRisoku2.divide(
                            new BigDecimal(100000), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN));

                    // 　　　　　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　　　　　精算日ワーク＜特利有効年月日の場合、以下を行う
                } else if (0 < tmpDateTokuriyukou.compareTo(tmpDateSeisan)) {

                    // 年払回数取得
                    tmpIntervalMonth = getIntervalMonth(shokanHouhou);
                    // 　　　　　　　　　　　　　　　　　暫定約定利息ワーク＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／年払月数ワーク／１０００００　　(除算は端数切捨て）
                    tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri))
                            .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                    BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);

                }
            }
        }

        // 　　　DTOの計算・賦金・約定利息に暫定約定利息ワークを設定
        outDto.setPreserve_ID_M_YakujoRisoku(tmpYakujoRisoku.toString());

        return outDto;
    }

    /**
     * 元金均等償還時の約定利息算出処理を行います。
     *
     * @param inDto
     * @return outDto
     */
    private Cr004_05DTO gankinShokanRisokuEdit(Cr004_05DTO inDto) {

        Cr004_05DTO outDto = new Cr004_05DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 償還方法コード
        String shokanHouhou = inDto.getID_Code_ShokanHouhou();
        // 繰上償還事由区分
        String categoryKurishojiyu = "";
        if (!StringUtils.isEmpty(inDto.getLblID_Code_Kurishojiyu())) {
            categoryKurishojiyu = inDto.getLblID_Code_Kurishojiyu().substring(0, 1);
        }
        // 据置期限年月
        String sueokiKigen = PNCommonComponents.cnvNulltoBlank(inDto.getID_Date_SueokiKigen());
        // 実行年月日
        String jikko = inDto.getID_Date_Jikko();
        // 特利有効年月日
        String tokuriYuko = inDto.getID_Date_TokuriYuko();
        // 償還後第1回払込期日
        String firstHaraikomiAfterKurisho = PNCommonComponents.dateFmtJC_Gyymmdd(
                inDto.getLblID_Date_FirstHaraikomiAfterKurisho(), "");
        // 繰償後元金不均等額(円)
        BigDecimal gankinFukintoAfterKurisho = PNCommonUtils.cnvBigStrMoney(inDto
                .getLblID_M_GankinFukintoAfterKurisho());
        // 貸付金残高
        BigDecimal kashitsukeZandaka = PNCommonUtils.cnvBigStrMoney(inDto.getID_M_KashitsukeZandaka());
        // 元金
        BigDecimal kurishoGankin = PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_KurishoGankin());
        // 調整コード
        String codeChosei = inDto.getRdoID_Code_chosei();

        // 暫定約定利息ワーク
        BigDecimal tmpYakujoRisoku = BigDecimal.ZERO;
        // 暫定約定利息ワーク１
        BigDecimal tmpYakujoRisoku1 = BigDecimal.ZERO;
        // 暫定約定利息ワーク２
        BigDecimal tmpYakujoRisoku2 = BigDecimal.ZERO;
        // 特利ワーク
        BigDecimal tmpTokuri = BigDecimal.ZERO;
        // 利率ワーク
        BigDecimal tmpRiritsu = BigDecimal.ZERO;
        // 起算日ワーク
        String tmpDateKisan = "";
        // 精算日ワーク
        String tmpDateSeisan = "";
        // 特利有効年月日ワーク
        String tmpDateTokuriyukou = "";
        // 年払回数
        int tmpIntervalMonth = 0;
        // 日数ワーク１
        int tmpDay1 = 0;
        // 日数ワーク２
        int tmpDay2 = 0;
        // 約定データ取得済フラグ
        boolean yakujoSyutokuzumiFlag = false;

        // --------------------------------
        // 条変起案中区分：変更なし
        // --------------------------------
        // 　　　DTOの計算・条変起案中区分にDTOの条変起案中区分を設定
        outDto.setPreserve_ID_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu());

        // --------------------------------
        // 約定元金
        // --------------------------------
        // 　　　DTOの繰償事由コードの１文字目が１又は、５の場合、以下を行う　　　　　　（期限固定の場合）
        if (Cr004Constants.CODE_KURISHOJIYU_1.equals(categoryKurishojiyu)
                || Cr004Constants.CODE_KURISHOJIYU_5.equals(categoryKurishojiyu)) {
            // 　　　　　DTOの計算・賦金・約定元金＝DTOの繰償後元金均等額(円)
            outDto.setPreserve_ID_M_YakujoGankin(inDto.getLblID_M_GankinKintoAfterKurisho());
            // 　　　　　DTOの繰償後元金不均等額(円)＜＞空文字かつ、DTOの繰償後元金不均等額(円)＜＞０かつ、DTOの調整コード＝１の場合、以下を行う
            if (!BigDecimal.ZERO.equals(gankinFukintoAfterKurisho)
                    && Cr004Constants.CODE_CHOSEI_1_SYOKAI.equals(codeChosei)) {
                // 　　　　　　　DTOの据置期限年月にデータがある（ＮＵＬＬ、空文字以外）場合、以下を行う
                if (!StringUtils.isEmpty(sueokiKigen)) {
                    // 　　　　　　　　　DTOの据置期限年月＜DTOの償還後第1回払込期日の年月の場合、以下を行う
                    if (0 < firstHaraikomiAfterKurisho.substring(0, 6).compareTo(sueokiKigen)) {
                        // 　　　　　　　　　　　DTOの計算・賦金・約定元金＝DTOの繰償後元金不均等額(円)
                        outDto.setPreserve_ID_M_YakujoGankin(inDto.getLblID_M_GankinFukintoAfterKurisho());
                    }
                    // 　　　　　　　　　上記以外(else)の場合、無処理
                } else {
                    // 　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　DTOの計算・賦金・約定元金＝DTOの繰償後元金不均等額(円)
                    outDto.setPreserve_ID_M_YakujoGankin(inDto.getLblID_M_GankinFukintoAfterKurisho());
                }
            }
            // 　　　DTOの繰償事由コードの１文字目が３又は、６の場合、以下を行う　　　　　（期限短縮の場合）
        } else if (Cr004Constants.CODE_KURISHOJIYU_3.equals(categoryKurishojiyu)
                || Cr004Constants.CODE_KURISHOJIYU_6.equals(categoryKurishojiyu)) {
            // 　　　　　DTOの計算・賦金・約定元金＝DTOの約定元金・請求
            outDto.setPreserve_ID_M_YakujoGankin(inDto.getID_M_YakujoGankin_Seikyu());
        }

        // --------------------------------
        // 約定利息
        // --------------------------------
        // 　　　約定データ取得の検索条件を設定
        // 　　　　複数テーブルアクセス定義の「Cr004_05ResultYakujo1DAO」を参照し、条件を設定する。
        // 　　　　・債権管理番号：DTOの債権管理番号
        // 　　　　・約定検索条件：２　（払込年月日＜払込年月日指定）
        // 　　　　・払込年月日：DTOの償還後第1回払込期日
        // 　　　　Cr004_05ResultYakujo1DAO.findByCondition
        List<Cr004_05ResultYakujo1Entity> outEntityList = getYakujoData(inDto.getID_ID_Credit(),
                Cr004Constants.KIND_SEARCHYAKUJO_2, firstHaraikomiAfterKurisho);

        // 　　　取得件数が１件以上の場合、以下を行う
        if (0 < outEntityList.size()) {
            // 　　　　　起算日ワークに取得した払込年月日を設定する
            // 　　　　　約定データ取得済フラグ（ワーク）にTrue設定
            tmpDateKisan = outEntityList.get(0).getDate_Haraikomi();
            yakujoSyutokuzumiFlag = true;
        } else {
            // 　　　上記以外(else)の場合、以下を行う
            // 　　　　　起算日ワークに実行年月日を設定する
            // 　　　　　約定データ取得済フラグ（ワーク）にFalse設定
            tmpDateKisan = jikko;
            yakujoSyutokuzumiFlag = false;
        }

        // 　　　精算日にDTOの償還後第1回払込期日を設定
        tmpDateSeisan = firstHaraikomiAfterKurisho;

        // 　　　特利ワークにDTOの特利を設定（ＤＢ値のままなので、そのまま設定）
        // 　　　利率ワークにDTOの利率を設定（ＤＢ値のままなので、そのまま設定）
        tmpTokuri = PNCommonComponents.cnvStrtoBig(inDto.getID_Tokuri());
        tmpRiritsu = PNCommonComponents.cnvStrtoBig(inDto.getID_Riritsu());

        // 年払回数取得
        tmpIntervalMonth = getIntervalMonth(shokanHouhou);

        // 　　　約定データ取得済フラグ（ワーク）が取得未（False）の場合、以下を行う
        if (!yakujoSyutokuzumiFlag) {
            // 　　　　　DTOの特利有効年月日＝空文字又は、（DTOの特利有効年月日＜＞空文字かつ、利率ワーク≦特利ワーク）の場合、以下を行う
            if (StringUtils.isEmpty(tokuriYuko)
                    || (!StringUtils.isEmpty(tokuriYuko) && 0 <= tmpTokuri.compareTo(tmpRiritsu))) {

                // 　　　　　　　日数ワーク１に、償還後第1回払込期日と実行年月日の差分日数を設定する。
                // 　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク／３６５＊日数ワーク１　　（端数有）
                // 　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００　　　　　　　　　　　　　　　　　　　　　　　　　　　　　(除算は端数切捨て）
                tmpDay1 = differenceDays(firstHaraikomiAfterKurisho, jikko);
                tmpYakujoRisoku1 = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)).divide(
                        new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN).multiply(
                        new BigDecimal(tmpDay1));
                tmpYakujoRisoku = tmpYakujoRisoku1.divide(new BigDecimal(100000), Cr004Constants.SCALE_0,
                        BigDecimal.ROUND_DOWN);

                // 　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　DTOの特利有効年月日＜＞空文字かつ、利率ワーク＞特利ワークの場合、以下を行う
            } else if (!StringUtils.isEmpty(tokuriYuko) && 0 > tmpTokuri.compareTo(tmpRiritsu)) {

                // 　　　　　　　　　実行年月日≦特利有効年月日かつ、特利有効年月日≦償還後第1回払込期日の場合、以下を行う
                if (0 <= tokuriYuko.compareTo(jikko) && 0 <= firstHaraikomiAfterKurisho.compareTo(tokuriYuko)) {

                    // 　　　　　　　　　　　日数ワーク１に、特利有効年月日と実行年月日の差分日数を設定する。
                    // 　　　　　　　　　　　日数ワーク２に、償還後第1回払込期日と特利有効年月日の差分日数を設定する。
                    // 　　　　　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 　　　　　　　　　　　暫定約定利息ワーク２＝（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク／３６５＊日数ワーク２　　（端数有）
                    // 　　　　　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００＋暫定約定利息ワーク２／１０００００　　　　　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(tokuriYuko, jikko);
                    tmpDay2 = differenceDays(firstHaraikomiAfterKurisho, tokuriYuko);
                    tmpYakujoRisoku1 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku2 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay2));
                    tmpYakujoRisoku = (tmpYakujoRisoku1.divide(new BigDecimal(100000),
                            Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN)).add(tmpYakujoRisoku2.divide(
                            new BigDecimal(100000), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN));

                    // 　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　償還後第1回払込期日＜特利有効年月日の場合、以下を行う
                } else if (0 < tokuriYuko.compareTo(firstHaraikomiAfterKurisho)) {

                    // 　　　　　　　　　　　　　日数ワーク１に、償還後第1回払込期日と実行年月日の差分日数を設定する。
                    // 　　　　　　　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 　　　　　　　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００　　　　　　　　　　　　　　　　　　　　　　　　　　　　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(firstHaraikomiAfterKurisho, tmpDateKisan);
                    tmpYakujoRisoku1 = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri))
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku = tmpYakujoRisoku1.divide(new BigDecimal(100000), Cr004Constants.SCALE_0,
                            BigDecimal.ROUND_DOWN);

                }
            }
        }

        // 　　　　　約定データ取得済フラグ（ワーク）が取得済（True）の場合、以下を行う
        if (yakujoSyutokuzumiFlag) {
            // 　　　　　　　DTOの特利有効年月日＝空文字又は、（DTOの特利有効年月日＜＞空文字かつ、利率ワーク≦特利ワーク）の場合、以下を行う
            if (StringUtils.isEmpty(tokuriYuko)
                    || (!StringUtils.isEmpty(tokuriYuko) && 0 <= tmpTokuri.compareTo(tmpRiritsu))) {

                // 　　　　　　　　　暫定約定利息ワーク＝（（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク）／年払回数／１０００００　　(除算は都度、端数切捨て）
                tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)).divide(
                        new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN)
                        .divide(new BigDecimal(100000), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);

                // 　　　　　　　上記以外(else)の場合、以下を行う
                // 　　　　　　　　　DTOの特利有効年月日＜＞空文字かつ、利率ワーク＞特利ワークの場合、以下を行う
            } else if (!StringUtils.isEmpty(tokuriYuko) && 0 > tmpTokuri.compareTo(tmpRiritsu)) {

                // 　　　　　　　　　　　特利有効年月日ワークにDTOの特利有効年月日を設定
                tmpDateTokuriyukou = tokuriYuko;

                // 　　　　　　　　　　　特利有効年月日ワーク＜起算日ワークの場合、以下を行う
                if (0 < tmpDateKisan.compareTo(tmpDateTokuriyukou)) {

                    // 暫定約定利息ワーク＝（（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク）／年払回数／１０００００　　(除算は都度、端数切捨て）
                    tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu))
                            .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                    BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);

                    // 　　　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　　　起算日ワーク≦特利有効年月日かつ、特利有効年月日≦精算日の場合、以下を行う
                } else if (0 <= tmpDateTokuriyukou.compareTo(tmpDateKisan)
                        && 0 <= tmpDateSeisan.compareTo(tmpDateTokuriyukou)) {

                    // 　　　　　　　　　　　　　　　日数ワーク１に、起算日ワークと特利有効年月日ワークの差分日数を設定する。
                    // 　　　　　　　　　　　　　　　日数ワーク２に、特利有効年月日ワークのと精算日ワークの差分日数を設定する。
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク１＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／３６５＊日数ワーク１　　（端数有）
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク２＝（DTOの貸付金残高－DTOの元金(円)）＊利率ワーク／３６５＊日数ワーク２　　（端数有）
                    // 　　　　　　　　　　　　　　　暫定約定利息ワーク＝暫定約定利息ワーク１／１０００００＋暫定約定利息ワーク２／１０００００　　　　　　(除算は端数切捨て）
                    tmpDay1 = differenceDays(tmpDateTokuriyukou, tmpDateKisan);
                    tmpDay2 = differenceDays(tmpDateSeisan, tmpDateTokuriyukou);
                    tmpYakujoRisoku1 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay1));
                    tmpYakujoRisoku2 = (kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpRiritsu)
                            .divide(new BigDecimal(365), Cr004Constants.SCALE_6, BigDecimal.ROUND_DOWN)
                            .multiply(new BigDecimal(tmpDay2));
                    tmpYakujoRisoku = (tmpYakujoRisoku1.divide(new BigDecimal(100000),
                            Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN)).add(tmpYakujoRisoku2.divide(
                            new BigDecimal(100000), Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN));

                    // 　　　　　　　　　　　　　上記以外(else)の場合、以下を行う
                    // 　　　　　　　　　　　　　　　精算日ワーク＜特利有効年月日の場合、以下を行う
                } else if (0 < tmpDateTokuriyukou.compareTo(tmpDateSeisan)) {

                    // 　　　　　　　　　　　　　　　　　暫定約定利息ワーク＝（DTOの貸付金残高－DTOの元金(円)）＊特利ワーク／年払回数ワーク／１０００００　　(除算は端数切捨て）
                    tmpYakujoRisoku = ((kashitsukeZandaka.subtract(kurishoGankin)).multiply(tmpTokuri))
                            .divide(new BigDecimal(tmpIntervalMonth), Cr004Constants.SCALE_0,
                                    BigDecimal.ROUND_DOWN).divide(new BigDecimal(100000),
                                    Cr004Constants.SCALE_0, BigDecimal.ROUND_DOWN);

                }
            }
        }

        // 　　　DTOの計算・賦金・約定利息に暫定約定利息ワークを設定
        outDto.setPreserve_ID_M_YakujoRisoku(tmpYakujoRisoku.toString());

        return outDto;
    }

    /**
     * 約定データを取得します。
     *
     * @param ID_Credit 債権管理番号
     * @param kind 約定検索条件
     * @param yakujoubi 約定日
     * @return 約定データリスト
     */
    public java.util.List<Cr004_05ResultYakujo1Entity> getYakujoData(String ID_Credit, String kind,
            String yakujoubi) {
        Cr004_05ResultYakujo1Entity inEntity = new Cr004_05ResultYakujo1Entity();
        List<Cr004_05ResultYakujo1Entity> outEntityList = new ArrayList<Cr004_05ResultYakujo1Entity>();
        inEntity.setCr004_04_ID_Credit(ID_Credit);
        inEntity.setCr004_04_Kind(kind);
        inEntity.setCr004_04_Date_Haraikomi(yakujoubi);
        outEntityList = cr004_05resultyakujo1dao.findByCondition(inEntity);
        return outEntityList;
    }

    /**
     * 償還期限月数を取得します。
     *
     * @param sueokiKigen 据置期限年月
     * @param firstHaraikomiAfterKurisho 償還後第1回払込期日
     * @param shokanKigen 退避償還期限年月
     * @return int 償還期限月数
     */
    public int getSyokanKigenMonth(String sueokiKigen, String firstHaraikomiAfterKurisho, String shokanKigen) {
        // 　　　据置期限年月にデータがある（ＮＵＬＬ、空文字以外）場合、以下を行う
        // 　　　　　償還後第1回払込期日の年月≦据置期限年月の場合、以下を行う
        // 　　　　　　　償還期限月数ワークに、据置期限年月と退避償還期限年月の差分月数を設定する。
        // 　　　　　以外(else)の場合、以下を行う
        // 　　　　　　　償還期限月数ワークに、償還後第1回払込期日と退避償還期限年月の差分月数を設定する。
        // 　　　以外(else)の場合、以下を行う
        // 　　　　　償還期限月数ワークに、償還後第1回払込期日と退避償還期限年月の差分月数を設定する。
        int syokanKigenMonth = 0;
        if (!StringUtils.isEmpty(sueokiKigen)) {
            if (0 <= sueokiKigen.compareTo(firstHaraikomiAfterKurisho.substring(0, 6))) {
                syokanKigenMonth = differenceMonth(shokanKigen, sueokiKigen);
            } else {
                syokanKigenMonth = differenceMonth(shokanKigen, firstHaraikomiAfterKurisho);
            }
        } else {
            syokanKigenMonth = differenceMonth(shokanKigen, firstHaraikomiAfterKurisho);
        }
        return syokanKigenMonth;
    }

    /**
     *
     * <pre>
     * 償還月数取得を取得します。
     * </pre>
     *
     * @param code_ShokanHouhou 償還方法
     * @return int 償還月数
     */
    private int getShiyoukanMonth(String code_ShokanHouhou) {
        // 　　　償還方法コード2文字目が 1 の場合、償還月数ワークに 12 を設定する。 ※年1回の支払い
        // 　　　償還方法コード2文字目が 2 の場合、償還月数ワークに 6 を設定する。 ※年2回の支払い
        // 　　　償還方法コード2文字目が 4 の場合、償還月数ワークに 3 を設定する。 ※年4回の支払い
        // 　　　償還方法コード2文字目が 6 の場合、償還月数ワークに 2 を設定する。 ※年6回の支払い
        // 　　　償還方法コード2文字目が B の場合、償還月数ワークに 1 を設定する。 ※年12回の支払い
        String stChar = code_ShokanHouhou.substring(1, 2);
        int shiyoukanMonth = 0;
        if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_1.equals(stChar)) {
            shiyoukanMonth = 12;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_2.equals(stChar)) {
            shiyoukanMonth = 6;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_4.equals(stChar)) {
            shiyoukanMonth = 3;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_6.equals(stChar)) {
            shiyoukanMonth = 2;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_B.equals(stChar)) {
            shiyoukanMonth = 1;
        }
        return shiyoukanMonth;
    }

    /**
     *
     * <pre>
     * 年払回数取得を取得します。
     * </pre>
     *
     * @param code_ShokanHouhou 償還方法
     * @return int 年払回数
     */
    private int getIntervalMonth(String code_ShokanHouhou) {
        // 　　　　　　　　　　　DTOの償還方法コード2文字目が 1 の場合、年払回数ワークに 1 を設定する。 ※年1回の支払い
        // 　　　　　　　　　　　DTOの償還方法コード2文字目が 2 の場合、年払回数ワークに 2 を設定する。 ※年2回の支払い
        // 　　　　　　　　　　　DTOの償還方法コード2文字目が 4 の場合、年払回数ワークに 4 を設定する。 ※年4回の支払い
        // 　　　　　　　　　　　DTOの償還方法コード2文字目が 6 の場合、年払回数ワークに 6 を設定する。 ※年6回の支払い
        // 　　　　　　　　　　　DTOの償還方法コード2文字目が B の場合、年払回数ワークに 12 を設定する。 ※年12回の支払い
        String stChar = code_ShokanHouhou.substring(1, 2);
        int intIntervalMonth = 0;
        if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_1.equals(stChar)) {
            intIntervalMonth = 1;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_2.equals(stChar)) {
            intIntervalMonth = 2;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_4.equals(stChar)) {
            intIntervalMonth = 4;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_6.equals(stChar)) {
            intIntervalMonth = 6;
        } else if (Cr004Constants.CODE_SHOKANHOUHOU_SECOND_B.equals(stChar)) {
            intIntervalMonth = 12;
        }
        return intIntervalMonth;
    }

    /**
     * 2つの日付の差を求めます。 日付文字列 strDate1 - strDate2 が何日かを返します。
     *
     * @param strDate1 日付文字列 yyyy/MM/dd
     * @param strDate2 日付文字列 yyyy/MM/dd
     * @return 2つの日付の差
     * @throws ParseException 日付フォーマットが不正な場合
     */
    public int differenceDays(String strDate1, String strDate2) {
        if (null == strDate1 || null == strDate2) {
            return 0;
        }
        try {
            Date date1 = toDate(strDate1, "yyyyMMdd");
            Date date2 = toDate(strDate2, "yyyyMMdd");
            return differenceCalcuDays(date1, date2);
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 2つの日付の差を求めます。
     *
     * @param date1 日付 java.util.Date
     * @param date2 日付 java.util.Date
     * @return 2つの日付の差
     */
    public static int differenceCalcuDays(Date date1, Date date2) {
        long datetime1 = date1.getTime();
        long datetime2 = date2.getTime();
        long one_date_time = 1000 * 60 * 60 * 24;
        long diffDays = (datetime1 - datetime2) / one_date_time;
        return new Long(diffDays).intValue();
    }

    /**
     * 2つの日付の月数の差を求めます。 日付文字列 strDate1 - strDate2 が何ヵ月かを整数で返します。 ※月末日により判定
     *
     * @param strDate1 日付文字列1 yyyyMMdd
     * @param strDate2 日付文字列2 yyyyMMdd
     * @return 2つの日付の月数の差
     * @throws ParseException 日付フォーマットが不正な場合
     */
    private int differenceMonth(String strDate1, String strDate2) {
        if (null == strDate1 || null == strDate2) {
            return 0;
        }

        Date date1;
        Date date2;
        String strdate1 = strDate1;
        String strdate2 = strDate2;

        if (6 == strDate1.length()) {
            strdate1 = strDate1 + PNCommonConstants.FIRST_DAY_OF_MONTH;
        }
        strdate1 = PNCommonStringUtils.concatString(
                String.format("%04d", PNDateUtils.getLastDateByString(strdate1)[0]),
                String.format("%02d", PNDateUtils.getLastDateByString(strdate1)[1]),
                String.format("%02d", PNDateUtils.getLastDateByString(strdate1)[2]));

        if (6 == strDate2.length()) {
            strdate2 = strDate2 + PNCommonConstants.FIRST_DAY_OF_MONTH;
        }
        strdate2 = PNCommonStringUtils.concatString(
                String.format("%04d", PNDateUtils.getLastDateByString(strdate2)[0]),
                String.format("%02d", PNDateUtils.getLastDateByString(strdate2)[1]),
                String.format("%02d", PNDateUtils.getLastDateByString(strdate2)[2]));

        try {
            date1 = toDate(strdate1, "yyyyMMdd");
            date2 = toDate(strdate2, "yyyyMMdd");
            return differenceCalcuMonth(date1, date2);
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 2つの日付の月数の差を求めます。 java.util.Date 型の日付 date1 - date2 が何ヵ月かを整数で返します。 ※端数の日数は無視します。
     *
     * @param date1 日付1 java.util.Date
     * @param date2 日付2 java.util.Date
     * @return 2つの日付の月数の差
     */
    private static int differenceCalcuMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.DATE, 1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.DATE, 1);
        int count = 0;
        if (cal1.before(cal2)) {
            while (cal1.before(cal2)) {
                cal1.add(Calendar.MONTH, 1);
                count--;
            }
        } else {
            count--;
            while (!cal1.before(cal2)) {
                cal1.add(Calendar.MONTH, -1);
                count++;
            }
        }
        return count;
    }

    /**
     *
     * <pre>
     * Date型に変換します。
     * </pre>
     *
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    private Date toDate(String str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(str);
        return date;
    }

    /**
     *
     * <pre>
     * 日時(String型)を指定した月の加減算をします。
     * </pre>
     *
     * @param strDate 日付
     * @param amount 月数
     * @return 加減算後の日時(String型)
     */
    private String addStrMonth(String strDate, int amount) {
        String addMonthDate = "";
        Date date = PNDateUtils.toDate(strDate, PNDateUtils.DATE_PATTERN_YYYYMMDD);
        addMonthDate = new SimpleDateFormat(PNDateUtils.DATE_PATTERN_YYYYMMDD).format(PNDateUtils.addMonths(
                date, amount));
        return addMonthDate;
    }

    /**
     * 日付文字列（西暦yyyyMMdd）と時刻文字（hh:mm:ss）からTimestampを返す。
     *
     * @param strDate 日付文字列（西暦yyyyMMdd）
     * @param strTime 時刻文字（hh:mm:ss）
     * @return Timestamp
     */
    private Timestamp cnvTimeStamp(String strDate, String strTime) {

        Timestamp ret = null;
        try {
            String strDateTime = PNCommonComponents.concatString(strDate, " ", strTime);
            ret = new Timestamp(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(strDateTime).getTime());

        } catch (IllegalArgumentException iae) {
            ret = null;
        } catch (NullPointerException npe) {
            ret = null;
        } catch (ParseException pe) {
            ret = null;
        }

        return ret;
    }
}