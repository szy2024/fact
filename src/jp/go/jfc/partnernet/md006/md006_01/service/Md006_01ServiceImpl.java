//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/10 | 矢嶋　洋              | 新規作成
// 2.0.0   | 2017/12/01 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_01.service;

import java.math.BigDecimal;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import com.fujitsu.crust.common.CFWStringChecker;

import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.md006.md006_01.dao.Md006_01TatekaeReportModViewDAO;
import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.KanjomeisaiDAO;
import jp.go.jfc.partnernet.md006.md006_01.dao.Md006_01TatekaeReportModViewEntity;
import jp.go.jfc.partnernet.md006.md006_01.service.Md006_01DTO;
import jp.go.jfc.partnernet.common.dao.KanjomeisaiEntity;

/**
 * <pre>
 * このクラスはmd006_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Md006_01ServiceImpl extends PNBaseService implements Md006_01Service {

    /** md006_01tatekaereportmodviewdao */
    @Autowired
    private Md006_01TatekaeReportModViewDAO md006_01tatekaereportmodviewdao;

    /** kanjomeisaidao */
    @Autowired
    private KanjomeisaiDAO kanjomeisaidao;

    /**
     * Md006_01ServiceのgetEditData
     *
     * @param inDto Md006_01DTO
     * @return Md006_01DTO
     */
    @Override
    public Md006_01DTO getEditData(Md006_01DTO inDto) {

        Md006_01DTO outDto = new Md006_01DTO();

        Md006_01TatekaeReportModViewEntity inEntity = new Md006_01TatekaeReportModViewEntity();
        Md006_01TatekaeReportModViewEntity outEntity = new Md006_01TatekaeReportModViewEntity();

        // 編集対象データの取得
        // DAOへのパラメータに検索条件を設定（Md006_01TatekaeReportModViewEntity)
        // 　・DTO.報告書番号 → 報告書番号
        inEntity.setID_Report(inDto.getID_ID_Report());

        // MD006_01TatekaeReportModViewDAO.findByCondition
        // 該当なしの場合、エラーメッセージリストにメッセージを蓄積する。
        // ・メッセージ：PM9060E　該当データがありません。
        List<Md006_01TatekaeReportModViewEntity> outEntityList = md006_01tatekaereportmodviewdao
                .findByCondition(inEntity);

        // 検索結果のレコード件数を設定
        outDto.setRecordCount(outEntityList.size());

        if (PNCommonConstants.RECORD_COUNT_ONE == outEntityList.size()) {

            // 該当ありの場合、出力パラメータの編集を行う。
            outEntity = outEntityList.get(0);
            // ・Entity.報告年月日　→　報告年月日
            outDto.setLblID_Date_Report(outEntity.getDate_Report());
            // ・Entity.顧客名　→　顧客名、顧客名（修正）
            outDto.setTxtID_Name_Customer_Red(outEntity.getName_Customer());
            outDto.setTxtID_Name_Customer(outEntity.getName_Customer());
            // ・Entity.扱店名　→　扱店名、扱店名（修正）
            outDto.setTxtID_Name_Organization_Red(outEntity.getName_Organization());
            outDto.setTxtID_Name_Organization(outEntity.getName_Organization());
            // ・Entity.公庫支店コード　→　公庫支店、公庫支店（修正）
            outDto.setTxtID_Code_KoukoShiten_Red(outEntity.getCode_KoukoShiten());
            outDto.setTxtID_Code_KoukoShiten(outEntity.getCode_KoukoShiten());
            // ・Entity.扱店コード　→　扱店、扱店（修正）
            outDto.setTxtID_Code_Organization_Red(outEntity.getCode_Organization());
            outDto.setTxtID_Code_Organization(outEntity.getCode_Organization());
            // ・Entity.店舗コード　→　店舗、店舗（修正）
            outDto.setTxtID_Code_Tenpo_Red(outEntity.getCode_Tenpo());
            outDto.setTxtID_Code_Tenpo(outEntity.getCode_Tenpo());
            // ・Entity.年度　→　年度、年度（修正）
            outDto.setTxtID_Year_Red(outEntity.getYear());
            outDto.setTxtID_Year(outEntity.getYear());
            // ・Entity.方式資金　→　方式資金、方式資金（修正）
            outDto.setTxtID_Code_HoshikiShikin_Red(outEntity.getCode_HoshikiShikin());
            outDto.setTxtID_Code_HoshikiShikin(outEntity.getCode_HoshikiShikin());
            // ・Entity.稟議番号　→　番号、番号（修正）
            outDto.setTxtID_ID_Ringi_Red(outEntity.getID_Ringi());
            outDto.setTxtID_ID_Ringi(outEntity.getID_Ringi());
            // ・Entity.稟議番号枝番　→　枝番、枝番（修正）
            if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outEntity.getID_RingiBranch())) {
                outDto.setTxtID_ID_RingiBranch_Red(PNCommonConstants.LITERAL_BLANK);
                outDto.setTxtID_ID_RingiBranch(PNCommonConstants.LITERAL_BLANK);
            }
            else {
                outDto.setTxtID_ID_RingiBranch_Red(outEntity.getID_RingiBranch());
                outDto.setTxtID_ID_RingiBranch(outEntity.getID_RingiBranch());
            }
            // ・Entity.入金日　→　入金日
            outDto.setTxtID_Date_Nyukin_Red(outEntity.getDate_Nyukin());
            // ・Entity.立替金利息(円) →　立替金利息(円)、立替金利息(円)（修正）
            outDto.setTxtID_M_TatekaeRisoku_Red(outEntity.getM_TatekaeRisoku());
            outDto.setTxtID_M_TatekaeRisoku(outEntity.getM_TatekaeRisoku());
            // ・Entity.立替金(円)　→　立替金(円)、立替金(円)（修正）
            outDto.setTxtID_M_Tatekae_Red(outEntity.getM_Tatekae());
            outDto.setTxtID_M_Tatekae(outEntity.getM_Tatekae());
            // ・Entity.仮受金(一般口)からの充当額(円) →　仮受金(一般口)からの充当額(円)、仮受金(一般口)からの充当額(円)（修正）
            if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity
                    .getM_KariukeIppanJuto()))) {
                outDto.setTxtID_M_KariukeIppanJuto_Red(null);
                outDto.setTxtID_M_KariukeIppanJuto(null);
            }
            else {
                outDto.setTxtID_M_KariukeIppanJuto_Red(outEntity.getM_KariukeIppanJuto());
                outDto.setTxtID_M_KariukeIppanJuto(outEntity.getM_KariukeIppanJuto());
            }
            // ・Entity.立替金の種類　→　立替金の種類、立替金の種類（修正）
            outDto.setTxtID_Code_TatekaekinShurui_Red(outEntity.getCode_TatekaekinShurui());
            outDto.setTxtID_Code_TatekaekinShurui(outEntity.getCode_TatekaekinShurui());
            // ・Entity.公庫立替日　→　公庫立替日、公庫立替日（修正）
            outDto.setTxtID_Date_KoukoTatekae_Red(outEntity.getDate_KoukoTatekae());
            outDto.setTxtID_Date_KoukoTatekae(outEntity.getDate_KoukoTatekae());
            // ・Entity.計(円)　→　計(円)、計(円)（修正）
            outDto.setTxtID_M_Kei_Red(outEntity.getM_Kei());
            outDto.setTxtID_M_Kei(outEntity.getM_Kei());
            // ・Entity.送金額(円) →　送金額(円)、送金額(円)（修正）
            outDto.setTxtID_M_Sokin_Red(outEntity.getM_Sokin());
            outDto.setTxtID_M_Sokin(outEntity.getM_Sokin());
            // ・Entity.受入後立替金残高(円)　→　受入後立替金残高(円)、受入後立替金残高(円)（修正）
            outDto.setTxtID_M_TatekaeZanAfterUkeire_Red(outEntity.getM_TatekaeZanAfterUkeire());
            outDto.setTxtID_M_TatekaeZanAfterUkeire(outEntity.getM_TatekaeZanAfterUkeire());
            // ・Entity.受託者勘定処理年月　→　受託者勘定処理年月、受託者勘定処理年月（修正）
            outDto.setTxtID_Date_Jtkshori_Red(outEntity.getDate_Jtkshori());
            outDto.setTxtID_Date_Jtkshori(outEntity.getDate_Jtkshori());
            // ・Entity.送金日 →　送金日
            outDto.setTxtID_Date_Sokin_Red(outEntity.getDate_Sokin());
            // ・Entity.送金日番号 →　送金日番号､送金日番号（修正）
            outDto.setTxtID_ID_Sokinbi_Red(outEntity.getID_Sokinbi());
            outDto.setTxtID_ID_Sokinbi(outEntity.getID_Sokinbi());
            // ・Entity.報告時分秒　→　報告時分秒
            outDto.setID_Time_Report(outEntity.getTime_Report());
            // 　- Entity.データコード　→　データコード
            outDto.setDataCode(outEntity.getDataCode());
            // 　- Entity.履歴番号　→　履歴番号
            outDto.setID_History(outEntity.getID_History());
            // 　- Entity.ステータス　→　ステータス
            outDto.setID_Status(outEntity.getStatus());
            // 　- Entity.処理種別　→　処理種別
            outDto.setTypeProcess(outEntity.getType_Process());
            // 　- Entity.取消済フラグ　→　取消済フラグ
            outDto.setFlag_Torikeshizumi(outEntity.getFlag_Torikeshizumi());
            // 　- Entity.債権管理番号　→　債権管理番号
            outDto.setID_Credit(outEntity.getID_Credit());
            // 　- Entity.退避履歴番号　→　退避履歴番号
            outDto.setKeep_ID_History(outEntity.getKeep_ID_History());
            // 　- Entity.退避受入後金残高　→　退避受入後金残高
            outDto.setKeep_M_TatekaeZanAfterUkeire(outEntity.getKeep_M_TatekaeZanAfterUkeire());
            // 　- Entity.最新更新日時　→　最新更新日時
            outDto.setData_LastUpDate(outEntity.getData_LastUpDate());
            // ・Entity.退避仮受仮払番号　→　退避仮受仮払番号
            outDto.setKeep_ID_Karibarai(outEntity.getKeep_ID_Karibarai());
            // 　- Entity.退避本支店コード　→　退避本支店コード
            outDto.setKeep_Code_HonShiten(outEntity.getKeep_Code_HonShiten());

            // 以下、Entityの当該項目に値が入っている場合和暦変換後設定を行う。（共通部品にて変換する）
            // ・和暦変換（Entity.入金日）
// [ADD] Ver 3.0.0 - START
            // ・初期元号　→ 入金日（修正）（元号）
            outDto.setDrpID_Date_Nyukin_Gengou(PNCommonComponents.getInitgengo());
            // ・空文字　→ 入金日（修正）（年）
            outDto.setTxtID_Date_Nyukin_Year("");
            // ・空文字　→ 入金日（修正）（月）
            outDto.setDrpID_Date_Nyukin_Month("");
            // ・空文字　→ 入金日（修正）（日）
            outDto.setDrpID_Date_Nyukin_Day("");
// [ADD] Ver 3.0.0 - END
            if (null != outEntity.getDate_Nyukin()
                    && !CFWStringChecker.checkDigit(outEntity.getDate_Nyukin(), 0)) {
                String[] nyukinWareki = PNCommonComponents.dateFmtAD_YYYYMMDD(outEntity.getDate_Nyukin())
                        .replace(".", "-").split("-");
                // ・和暦変換後のEntity.入金日（元号）　→ 入金日（修正）（元号）
                outDto.setDrpID_Date_Nyukin_Gengou(nyukinWareki[0].substring(0, 1));
                // ・和暦変換後のEntity.入金日（年）　→ 入金日（修正）（年）
                outDto.setTxtID_Date_Nyukin_Year(nyukinWareki[0].substring(1));
                // ・和暦変換後のEntity.入金日（月）　→ 入金日（修正）（月）
                outDto.setDrpID_Date_Nyukin_Month(nyukinWareki[1]);
                // ・和暦変換後のEntity.入金日（日）　→ 入金日（修正）（日）
                outDto.setDrpID_Date_Nyukin_Day(nyukinWareki[2]);
            }

            // ・和暦変換（Entity.送金日）
// [ADD] Ver 3.0.0 - START
            // ・初期元号　→ 送金日（修正）（元号）
            outDto.setDrpID_Date_Sokin_Gengou(PNCommonComponents.getInitgengo());
            // ・空文字　→ 送金日（修正）（年）
            outDto.setTxtID_Date_Sokin_Year("");
            // ・空文字　→ 送金日（修正）（月）
            outDto.setDrpID_Date_Sokin_Month("");
            // ・空文字　→ 送金日（修正）（日）
            outDto.setDrpID_Date_Sokin_Day("");
// [ADD] Ver 3.0.0 - END
            if (null != outEntity.getDate_Sokin()
                    && !CFWStringChecker.checkDigit(outEntity.getDate_Sokin(), 0)) {
                String[] sokinWareki = PNCommonComponents.dateFmtAD_YYYYMMDD(outEntity.getDate_Sokin())
                        .replace(".", "-").split("-");
                // ・和暦変換後のEntity.送金日（元号）　→ 送金日（修正）（元号）
                outDto.setDrpID_Date_Sokin_Gengou(sokinWareki[0].substring(0, 1));
                // ・和暦変換後のEntity.送金日（年）　→ 送金日（修正）（年）
                outDto.setTxtID_Date_Sokin_Year(sokinWareki[0].substring(1));
                // ・和暦変換後のEntity.送金日（月）　→ 送金日（修正）（月）
                outDto.setDrpID_Date_Sokin_Month(sokinWareki[1]);
                // ・和暦変換後のEntity.送金日（日）　→ 送金日（修正）（日）
                outDto.setDrpID_Date_Sokin_Day(sokinWareki[2]);
            }

            // ・和暦変換後（Entity.受託者勘定処理年月）
// [ADD] Ver 3.0.0 - START
            // ・初期元号　→ 受託者勘定処理年（元号）、受託者勘定処理年月（修正）（元号）
            outDto.setDrpID_Date_Jtkshori_Gengou_Red(PNCommonComponents.getInitgengo());
            outDto.setDrpID_Date_Jtkshori_Gengou(PNCommonComponents.getInitgengo());
// [ADD] Ver 3.0.0 - END
            if (null != outEntity.getDate_Jtkshori()
                    && !CFWStringChecker.checkDigit(outEntity.getDate_Jtkshori(), 0)) {
                String[] jtkshoriWareki = PNCommonComponents.dateFmtAD_YYYYMM(outEntity.getDate_Jtkshori())
                        .replace(".", "-").split("-");
                // ・和暦変換後のEntity.受託者勘定処理年月（元号）　→ 受託者勘定処理年（元号）、受託者勘定処理年月（修正）（元号）
                outDto.setDrpID_Date_Jtkshori_Gengou_Red(jtkshoriWareki[0].substring(0, 1));
                outDto.setDrpID_Date_Jtkshori_Gengou(jtkshoriWareki[0].substring(0, 1));
                // ・和暦変換後のEntity.受託者勘定\処理年月（年）　→ 受託者勘定処理年月（年）、受託者勘定処理年月（修正）（年）
                // outDto.setTxtID_Date_Jtkshori_Year_Red(jtkshoriWareki[0].substring(1));
                // outDto.setTxtID_Date_Jtkshori_Year(jtkshoriWareki[0].substring(1));
                // ・和暦変換後のEntity.受託者勘定処理年月（月）　→ 受託者勘定処理年月（月）、受託者勘定処理年月（修正）（月）
                // outDto.setDrpID_Date_Jtkshori_Month_Red(jtkshoriWareki[1]);
                // outDto.setDrpID_Date_Jtkshori_Month(jtkshoriWareki[1]);
            }

        }

        // 呼び出し元に復帰する。
        return outDto;
    }

    /**
     * Md006_01ServiceのgetKariukeZanAfterSeisan
     *
     * @param inDto Md006_01DTO
     * @return Md006_01DTO
     */
    @Override
    public Md006_01DTO getKariukeZanAfterSeisan(Md006_01DTO inDto) {

        Md006_01DTO outDto = new Md006_01DTO();

        KanjomeisaiEntity inEntity = new KanjomeisaiEntity();
        KanjomeisaiEntity outEntity = new KanjomeisaiEntity();

        // 仮受仮払精算後残高の取得
        // ・DAOへのパラメータに検索条件を設定（KanjomeisaiEntity)
        // 　- DTO.公庫支店　→　Entity.所管本支店コード
        inEntity.setCode_ShokanHonShiten(inDto.getTxtID_Code_KoukoShiten_Red());
        // 　- DTO.扱店　→　Entity.扱店コード
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization_Red());
        // 　- DTO.店舗　→　Entity.店舗コード
        inEntity.setCode_Tenpo(inDto.getTxtID_Code_Tenpo_Red());
        // 　- DTO.公庫立替日　→　Entity.仮受仮払年月日
        inEntity.setDate_Karibarai(inDto.getTxtID_Date_KoukoTatekae_Red());
        // 　- DTO.退避仮受仮払番号　→　Entity.仮受仮払番号
        inEntity.setID_Karibarai(inDto.getKeep_ID_Karibarai());
        // 　- DTO.退避本支店コード　→　Entity.本支店コード
        inEntity.setCode_HonShiten(inDto.getKeep_Code_HonShiten());

        // ・KanjomeiDaiDAO.findByCondition
        List<KanjomeisaiEntity> outEntityList = kanjomeisaidao.findByCondition(inEntity);
        if (1 > outEntityList.size()) {
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }

        // 出力パラメータの編集を行う。
        outEntity = outEntityList.get(0);
        // ・Entity.仮受仮払精算後残高　→　DTO.仮受仮払精算後残高
        outDto.setID_M_KaribaraiZanAfterSeisan(outEntity.getM_KaribaraiZanAfterSeisan());
        // 呼び出し元に復帰する。

        return outDto;
    }

}