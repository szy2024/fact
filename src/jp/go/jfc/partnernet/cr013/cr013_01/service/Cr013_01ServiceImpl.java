//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr013_01ServiceImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.service;

import java.math.BigDecimal;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.TeitokenreportDAO;
import jp.go.jfc.partnernet.common.dao.TeitokenreportEntity;
import jp.go.jfc.partnernet.cr013.cr013_01.dao.Cr013_01TenpoNameResultDataDAO;
import jp.go.jfc.partnernet.cr013.cr013_01.dao.Cr013_01TenpoNameResultDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;

/**
 * <pre>
 * このクラスはcr013_01のサービスクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr013_01ServiceImpl extends PNBaseService implements Cr013_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Cr013_01ServiceImpl.class);

    /** ReporthistoryDAO */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** TteitokenReportDAO */
    @Autowired
    private TeitokenreportDAO teitokenreportdao;

    /** cr013_01tenponameresultdatadao */
    @Autowired
    private Cr013_01TenpoNameResultDataDAO cr013_01tenponameresultdatadao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr013_01Serviceの初期表示時の扱店名取得メソッド
     *
     * @param inDto Cr013_01DTO
     * @return Cr013_01DTO
     */
    @Override
    public Cr013_01DTO getInitData(Cr013_01DTO inDto) {

        Cr013_01DTO outDto = new Cr013_01DTO();
        outDto = inDto;

        // 金融機関名称の取得
        // 　　Cr013_01TenpoNameResultsDataDAO.findByCondition
        Cr013_01TenpoNameResultDataEntity inTenpoNameEntity = new Cr013_01TenpoNameResultDataEntity();
        // 取得条件の設定
        // 　　・ログインユーザの権限種別
        inTenpoNameEntity.setRolecode(PNCommonInfoHolder.getCommonInfo().getRoleCode());
        // 　　・ログインユーザの扱店コード
        inTenpoNameEntity.setCode_organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        // 　　・ログインユーザの店舗コード
        inTenpoNameEntity.setCode_tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());
        List<Cr013_01TenpoNameResultDataEntity> outTenpoNameEntityList =
                cr013_01tenponameresultdatadao.findByCondition(inTenpoNameEntity);
        // ■取得件数をDTOに設定する。
        // ・取得件数　⇒　Cr013_01DTO.取得件数
        outDto.setDataCount(0);
        if (null != outTenpoNameEntityList) {
            outDto.setDataCount(outTenpoNameEntityList.size());
        }

        // ■取得件数　＝　0　の場合
        // 　処理なし。
        // ■上記以外の場合
        if (0 != outDto.getDataCount()) {
            // 　　EntityからDTOデータを設定する。
            // ・Cr013_01TenpoNameResultsDataEntity.扱店名　⇒　Cr013_01DTO.扱店名
            outDto.setLblID_Name_Organizat(outTenpoNameEntityList.get(0).getName_organization());
        }

        return outDto;
    }

    /**
     * Cr013_01Serviceの登録メソッド
     *
     * @param inDto Cr013_01DTO
     * @return Cr013_01DTO
     */
    @Override
    public Cr013_01DTO regist(Cr013_01DTO inDto) {

        Cr013_01DTO outDto = new Cr013_01DTO();

        log.debug("（根）抵当権抹消に係る報告報告書データの登録");
        outDto = inDto;

        // 共通部品より履歴番号最大値を取得　 ⇒　履歴番号最大値
        String strID_History = pnCommonDBComponents.getIdHistoryRh();

        // 共通部品より報告書番号最大値を取得　 ⇒　報告書番号最大値
        String strID_Report = pnCommonDBComponents.getIdReportRh();

        // 共通関数を使用し、報告日を取得する。 ⇒ 報告年月日(YYYYMMDD)
        String strReportDate = pnCommonDBComponents.getPNBusinessDay(1);
        if (!PNCommonComponents.checkDate(strReportDate)) {
            log.error("業務日付取得が不正です。[" + strReportDate + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // システム時間を"HHMMSS"形式で取得 ⇒ 現在時刻(HHMMSS)
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // 件数取得条件設定
        ReporthistoryEntity searchEntityRH = new ReporthistoryEntity();
        searchEntityRH.setID_History(strID_History);

        // 単テーブルアクセス定義「報告書履歴データのNo1.件数取得」を参照し、件数を取得する。
        // 　　ReporthistoryDAO.countByCondition
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        // long hitcount = reporthistorydao.countByCondition(inEntity);
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
                    setReportHistory(inDto, outDto.getLblID_Name_Organizat(), strID_History, strID_Report,
                            strReportDate, strSysDateTime);

            // 単テーブルアクセス定義の「報告書履歴データのNo2.登録処理」を実行し、報告書データを新規登録する。
            // 　　ReporthistoryDAO.insert
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
        // （根）抵当権抹消に係る報告報告書データの登録
        // -----------------------------------------------------------------------------

        // 件数取得条件設定
        TeitokenreportEntity searchEntityTTK = new TeitokenreportEntity();
        searchEntityTTK.setID_Report(strID_Report);

        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データのNo3.件数取得」を参照し、件数を取得する。
        // 　　TeitokenReportDAO.countByCondition
        // TeitokenReportEntity inEntity = new TeitokenReportEntity();
        // long hitcount = teitokenreportdao.countByCondition(inEntity);
        long hitcountTTK = teitokenreportdao.countByCondition(searchEntityTTK);

        if (0 != hitcountTTK) {
            // ■取得した件数　≠　０　の場合、エラーとする。
            // メッセージID：PM9010E
            // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }

        try {

            // 単テーブルアクセス定義の「（根）抵当権抹消に係る報告報告書データのNo4.登録処理」を実行し、
            // 報告書データを新規登録する。
            // 　TeitokenReportDAO.insert
            // TeitokenReportEntity inEntity = new TeitokenReportEntity();

            // （根）抵当権抹消に係る報告報告書データの登録内容の編集
            TeitokenreportEntity inEntityTTK = setTeitokenReport(inDto, strID_Report, strReportDate, strSysDateTime);

            int intResult = teitokenreportdao.insert(inEntityTTK);
            if (1 != intResult) {
                // 　■登録結果件数≠１の場合、エラーとする。
                // 　　メッセージID：PM9010E :
                // 他のユーザによってデータが更新されています。メニューから再度操作を行って下さい。
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }

        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("（根）抵当権抹消に係る報告報告書データ登録時にエラー発生", dke);
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
    private ReporthistoryEntity setReportHistory(Cr013_01DTO inDto, String strNameOrg, String strID_History,
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

        // 90257160（（根）抵当権抹消に係る報告報告書） ⇒ ReporthistoryEntity.データコード
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257160);

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
     * （根）抵当権抹消に係る報告報告書データ設定処理
     *
     * @param inDto
     *            画面情報
     * @param strID_Report
     *            報告書番号保持
     * @param strDateReport
     *            報告年月日
     * @param strSysDateTime
     *            報告時分秒
     * @return （根）抵当権抹消に係る報告報告書データ
     */
    private TeitokenreportEntity setTeitokenReport(Cr013_01DTO inDto, String strID_Report, String strDateReport,
            String strSysDateTime) {

        TeitokenreportEntity inEntity = new TeitokenreportEntity();

        // DAOへのパラメータに（根）抵当権抹消に係る報告報告書データの登録内容を設定する。
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

        // データコード（（根）抵当権抹消に係る報告報告書）
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257160);

        // 扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());

        // 店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

        // 拡張子の取得
        String extension = inDto.getLblID_Extension();

        // 表示ファイル名
        inEntity.setDisp_DocName(inDto.getLblID_DocName());
        // 添付ファイル
        inEntity.setDocName(inDto.getLblID_DocName());
        // 添付ファイルアップロード先パス ⇒ TeitokenReportEntity.添付ファイルアップロード先パス
        inEntity.setFilePath(inDto.getLblID_UpLoadFilePath());

        return inEntity;

    }

}