//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01ServiceImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.service;

import java.math.BigDecimal;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.HokatsureportDAO;
import jp.go.jfc.partnernet.common.dao.HokatsureportEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.cr012.common.Cr012Constants;
import jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataDAO;
import jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataEntity;
import jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01TenpoNameResultDataDAO;
import jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01TenpoNameResultDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;

/**
 * <pre>
 * このクラスはCr012_01のサービスクラスです。
 * </pre>
 *
 * @author木村　しのぶ
 * @version 2.0.0
 */
public class Cr012_01ServiceImpl extends PNBaseService implements Cr012_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Cr012_01ServiceImpl.class);

    /** ReporthistoryDAO */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** HokatsuReportDAO */
    @Autowired
    private HokatsureportDAO hokatsureportdao;

    /** cr012_01resultdatadao */
    @Autowired
    private Cr012_01ResultDataDAO cr012_01resultdatadao;

    /** cr012_01tenponameresultdatadao */
    @Autowired
    private Cr012_01TenpoNameResultDataDAO cr012_01tenponameresultdatadao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr012_01Serviceの登録メソッド
     *
     * @param inDto
     *            Cr012_01DTO
     * @return Cr012_01DTO
     */
    @Override
    public Cr012_01DTO regist(Cr012_01DTO inDto) {

        Cr012_01DTO outDto = inDto;

        log.info("包括委任状等の交付依頼報告書の登録");
        // 金融機関名称の取得
        Cr012_01TenpoNameResultDataEntity inTenpoNameEntity = new Cr012_01TenpoNameResultDataEntity();
        // 取得条件の設定
        // 　　・ログインユーザの権限種別
        inTenpoNameEntity.setRolecode(PNCommonInfoHolder.getCommonInfo().getRoleCode());
        // 　　・ログインユーザの扱店コード
        inTenpoNameEntity.setCode_organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        // 　　・ログインユーザの店舗コード
        inTenpoNameEntity.setCode_tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());
        List<Cr012_01TenpoNameResultDataEntity> outTenpoNameEntityList =
                cr012_01tenponameresultdatadao.findByCondition(inTenpoNameEntity);

        if (null == outTenpoNameEntityList || 0 == outTenpoNameEntityList.size()) {
            // ■取得した件数　＝ ０件　の場合、業務エラーとする。
            // 　　メッセージID：PM9060E : 該当データがありません。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        else {
            // ■上記以外の場合、取得した情報をDTOに設定する。
            outDto.setLblID_Name_Organization(outTenpoNameEntityList.get(0).getName_organization());
        }

        // 報告書履歴データの登録
        // 共通部品より履歴番号最大値を取得　 ⇒　履歴番号最大値
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        // 共通部品より報告書番号最大値を取得　 ⇒　報告書番号最大値
        String strID_Report = pnCommonDBComponents.getIdReportRh();
        // システム時間を"HHMMSS"形式で取得 ⇒ 現在時刻(HHMMSS)
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // 報告日の重複チェック
        Cr012_01ResultDataEntity inResultDataEntity = new Cr012_01ResultDataEntity();
        // DTO.報告日をyyyyMMdd形式に変換　⇒　報告年月日（yyyyMMdd）
        String strDateReport = inDto.getLblID_Date_Report().replaceAll(
                Cr012Constants.STR_YEAR, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Cr012Constants.STR_MONTH, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Cr012Constants.STR_DAY, PNCommonConstants.LITERAL_BLANK);

        // 報告年月日が同一のデータの件数を取得する。
        // 取得条件の設定
        inResultDataEntity.setRolecode(PNCommonInfoHolder.getCommonInfo().getRoleCode());
        inResultDataEntity.setCode_organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        inResultDataEntity.setCode_tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());
        inResultDataEntity.setDate_report(strDateReport);

        long hiCountResult = cr012_01resultdatadao.countByCondition(inResultDataEntity);
        if (0 < hiCountResult) {
            // ■取得した件数＞０の場合、エラーとする。
            // 　　メッセージID：PM3960E : {0}のデータは既に登録済みの為、登録できません。　※{0}･･･"報告日が" +
            // DTO.報告日
            String messageFuka = "報告日が" + inDto.getLblID_Date_Report();
            throw new PNServiceException(PNCommonMessageConstants.PM3960E, new String[] { messageFuka }, false);
        }

        // 件数取得条件設定
        ReporthistoryEntity searchEntityRH = new ReporthistoryEntity();
        searchEntityRH.setID_History(strID_History);

        // 単テーブルアクセス定義「報告書履歴データのNo1.件数取得」を実行し、件数を取得する。
        long hitCountRH = reporthistorydao.countByCondition(searchEntityRH);

        if (hitCountRH != 0) {
            // ■取得した件数　≠　０　の場合、エラーとする。
            // メッセージID：PM9010E
            // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }

        try {
            // 報告書履歴データの登録内容の編集
            ReporthistoryEntity inEntityRH =
                    setReportHistory(inDto,
                            outDto.getLblID_Name_Organization(),
                            strID_History,
                            strID_Report,
                            strDateReport,
                            strSysDateTime);

            // 単テーブルアクセス定義の「報告書履歴データのNo2.登録処理」を実行し、報告書データを新規登録する。
            // 　ReporthistoryDAO.insert
            // ReporthistoryEntity inEntity = new ReporthistoryEntity();
            int intResult = reporthistorydao.insert(inEntityRH);

            if (1 != intResult) {
                // ■登録結果件数≠１の場合、エラーとする。
                // メッセージID：PM9010E
                // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }

        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("報告書履歴データ登録時にエラー発生", dke);
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, dke);
        }

        // -----------------------------------------------------------------------------
        // 包括委任状等の交付依頼報告書データの登録
        // -----------------------------------------------------------------------------

        // 件数取得条件設定
        HokatsureportEntity searchEntityHKT = new HokatsureportEntity();
        searchEntityHKT.setID_Report(strID_Report);

        // 単テーブルアクセス定義「包括委任状等の交付依頼報告書データのNo3.件数取得」を実行し、件数を取得する。
        // 　　HokatsuReportDAO.countByCondition
        // HokatsuReportEntity inEntity = new HokatsuReportEntity();
        long hitcountHKT = hokatsureportdao.countByCondition(searchEntityHKT);

        if (0 != hitcountHKT) {
            // ■取得した件数　≠　０　の場合、エラーとする。
            // メッセージID：PM9010E
            // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        try {

            // 単テーブルアクセス定義の「包括委任状等の交付依頼報告書データのNo4.登録処理」を実行し
            // 報告書データを新規登録する。
            // 　HokatsuReportDAO.insert
            // HokatsuReportEntity inEntity = new HokatsuReportEntity();

            // 包括委任状等の交付依頼報告書データの登録内容の編集
            HokatsureportEntity inEntityHKT = setHokatsuReport(inDto, strID_Report, strDateReport, strSysDateTime);

            int intResult = hokatsureportdao.insert(inEntityHKT);
            if (1 != intResult) {
                // 　■登録結果件数≠１の場合、エラーとする。
                // 　　メッセージID：PM9010E :
                // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("包括委任状等の交付依頼報告書データ登録時にエラー発生", dke);
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, dke);

        }

        return outDto;
    }

    /**
     * 報告書履歴データ設定処理
     *
     * @param inDto
     *            画面情報
     * @param strNameOrg
     *            扱店名
     * @param strID_History
     *            履歴番号保持
     * @param strID_Report
     *            報告書番号保持
     * @param strDateRepor
     *            報告年月日
     * @param strSysDateTime
     *            報告時分秒
     * @return 報告書履歴データ
     */
    private ReporthistoryEntity setReportHistory(Cr012_01DTO inDto, String strNameOrg, String strID_History,
            String strID_Report, String strDateReport, String strSysDateTime) {
        ReporthistoryEntity inEntity = new ReporthistoryEntity();

        // DAOへのパラメータに報告書履歴データの登録内容を設定する。
        // 履歴番号最大値 ⇒ ReporthistoryEntity.履歴番号
        inEntity.setID_History(strID_History);

        // 報告書番号最大値 ⇒ ReporthistoryEntity.報告書番号
        inEntity.setID_Report(strID_Report);

        // 報告年月日(YYYYMMDD) ⇒ ReporthistoryEntity.報告年月日
        inEntity.setDate_Report(strDateReport);

        // 現在時刻（hhmmss） ⇒ ReporthistoryEntity.報告時分秒
        inEntity.setTime_Report(strSysDateTime);

        // 6（ステータス無し） ⇒ ReporthistoryEntity.ステータス
        inEntity.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_6));

        // 空文字 ⇒ ReporthistoryEntity.原本番号
        inEntity.setID_Master(PNCommonConstants.LITERAL_BLANK);

        // 90257150（包括委任状等の交付依頼報告書） ⇒ ReporthistoryEntity.データコード
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257150);

        // 00（作成） ⇒ ReporthistoryEntity.処理種別
        inEntity.setType_Process(PNCommonConstants.TYPE_PROCESS_00);

        // 0（取消非対象） ⇒ ReporthistoryEntity.取消済みフラグ
        inEntity.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // ログインユーザのユーザID ⇒ ReporthistoryEntity.ユーザID
        inEntity.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());

        // Cr012_01TenpoNameResultsDataEntity.扱店名 ⇒ ReporthistoryEntity.扱店名
        inEntity.setName_Organization(strNameOrg);

        // 空文字 ⇒ ReporthistoryEntity.顧客名
        inEntity.setName_Customer(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.公庫支店コード
        inEntity.setCode_KoukoShiten(PNCommonConstants.LITERAL_BLANK);

        // ログインユーザの扱店コード ⇒ ReporthistoryEntity.扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());

        // ログインユーザの店舗コード ⇒ ReporthistoryEntity.店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

        // 空文字 ⇒ ReporthistoryEntity.年度
        inEntity.setYear(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.方式資金
        inEntity.setCode_HoshikiShikin(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.稟議番号
        inEntity.setID_Ringi(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.稟議番号枝番
        inEntity.setID_RingiBranch(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.エラーコード
        inEntity.setCode_Error(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.エラーメッセージ
        inEntity.setErrorMessage(PNCommonConstants.LITERAL_BLANK);

        // null ⇒ ReporthistoryEntity.債権管理番号
        inEntity.setID_Credit(null);

        // "0" ⇒ ReporthistoryEntity.退避賦金
        inEntity.setKeep_M_Fukin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避元金不均等額
        inEntity.setKeep_M_GankinFukinto(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.退避元金不均等額区分
        inEntity.setKeep_Kubun_GankinFukinto(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.退避貸付金残高
        inEntity.setKeep_M_KashitsukeZan(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避約定元金
        inEntity.setKeep_M_YakujoGankin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避約定利息
        inEntity.setKeep_M_YakujoRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.退避償還期限年月
        inEntity.setKeep_Date_ShokanKigen(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.元利金受入充当報告書の控除利息
        inEntity.setKeep_M_KojoRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.元利金受入充当報告書の払込期日
        inEntity.setKeep_Date_Haraikomi(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.請求データの退避任意繰上償還利息
        inEntity.setKeep_Seikyu_M_NinKuriRisoku(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.請求データの退避請求繰上償還利息
        inEntity.setKeep_Seikyu_M_SeiKuriRisoku(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.請求データの退避請求繰上償還元金
        inEntity.setKeep_Seikyu_M_SeiKuriGankin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.約定データの退避請求繰上償還利息
        inEntity.setKeep_Yakujo_M_SeiKuriRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.扱店別稟議データの退避条変起案中区分
        inEntity.setKeep_JohenKianchu(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.退避履歴番号
        inEntity.setKeep_ID_History(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        inEntity.setKeep_Flag_Kj(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避受入後立替金残高
        inEntity.setKeep_M_TatekaeZanAfterUkeire(BigDecimal.ZERO);

        return inEntity;
    }

    /**
     * 包括委任状等の交付依頼報告書データ設定処理
     *
     * @param inDto
     *            画面情報
     * @param strID_Report
     *            報告書番号保持
     * @param strDateReport
     *            報告年月日
     * @param strSysDateTime
     *            報告時分秒
     * @return 包括委任状等の交付依頼報告書データ
     */
    private HokatsureportEntity setHokatsuReport(Cr012_01DTO inDto, String strID_Report, String strDateReport,
            String strSysDateTime) {

        HokatsureportEntity inEntity = new HokatsureportEntity();
        Cr012_01M1DTO m1Dto = inDto.getMEISAI_LIST().get(0);

        // DAOへのパラメータに包括委任状等の交付依頼報告書データの登録内容を設定する。
        // 報告書番号
        inEntity.setID_Report(strID_Report);

        // 報告年月日
        inEntity.setDate_Report(strDateReport);

        // 報告時分秒
        inEntity.setTime_Report(strSysDateTime);

        // ユーザＩＤ
        inEntity.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());

        // 伝送番号
        inEntity.setID_Denso("");

        // データコード（包括委任状等の交付依頼報告書）
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257150);

        // 扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());

        // 店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

        BigDecimal bgValue = null;
        // 包括委任状数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_HokatsuInin());
        inEntity.setSu_HokatsuInin(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.現在事項一部証明書数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_GenzaiJiko());
        inEntity.setSu_GenzaiJiko(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.印鑑証明書数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_InkanShohmei());
        inEntity.setSu_InkanShohmei(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.変更抄本数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_HenkoShohhon());
        inEntity.setSu_HenkoShohhon(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.新閉鎖謄本数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_SinHeisa());
        inEntity.setSu_SinHeisa(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.旧閉鎖抄本数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_KyuHeisa());
        inEntity.setSu_KyuHeisa(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.閉鎖事項全部証明書数量（空白またはnullの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getTxtID_Su_HeisaJiko());
        inEntity.setSu_HeisaJiko(PNCommonComponents.cnvNulltoZero(bgValue));
        // 　・DTO.至急発行フラグ（NULLの場合0）
        bgValue = PNCommonComponents.cnvStrtoBig(m1Dto.getChkID_ShikyuHakko());
        inEntity.setFlag_ShikyuHakko(PNCommonComponents.cnvNulltoZero(bgValue));

        return inEntity;

    }

}