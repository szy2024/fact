//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md013_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村しのぶ            | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md013.md013_01.service;

import java.io.File;
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
import jp.go.jfc.partnernet.md013.common.Md013Constants;
import jp.go.jfc.partnernet.md013.md013_01.dao.Md013_01ResultDataDAO;
import jp.go.jfc.partnernet.md013.md013_01.dao.Md013_01ResultDataEntity;
import jp.go.jfc.partnernet.md013.md013_01.dao.Md013_01TenpoNameResultDataDAO;
import jp.go.jfc.partnernet.md013.md013_01.dao.Md013_01TenpoNameResultDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはmd013_01のサービスクラスです。
 * </pre>
 *
 * @author Md013_01ServiceImpl
 * @version 2.0.0
 */
public class Md013_01ServiceImpl extends PNBaseService implements Md013_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Md013_01ServiceImpl.class);

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** teitokenreportdao */
    @Autowired
    private TeitokenreportDAO teitokenreportdao;

    /** md013_01resultdatadao */
    @Autowired
    private Md013_01ResultDataDAO md013_01resultdatadao;

    /** md013_01tenponameresultsdatadao */
    @Autowired
    private Md013_01TenpoNameResultDataDAO md013_01tenponameresultdatadao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Md013_01ServiceのgetResultsData
     *
     * @param inDto Md013_01DTO
     * @return Md013_01DTO
     */
    @Override
    public Md013_01DTO getResultsData(Md013_01DTO inDto) {

        Md013_01DTO outDto = new Md013_01DTO();
        log.debug("（根）抵当権抹消に係る報告報告書データの取得");
        // 取消・修正対象データの取得
        Md013_01ResultDataEntity inEntity = new Md013_01ResultDataEntity();
        // ・DTO.報告書番号⇒Md013_01ResultDataEntity.報告書番号
        inEntity.setId_report(inDto.getLblID_Report());
        List<Md013_01ResultDataEntity> outEntityList = md013_01resultdatadao.findByCondition(inEntity);

        // 取得件数をDTOに設定する。
        // ・取得件数 ⇒DTO.取得件数
        int dataCount = 0;
        if (null != outEntityList) {
            dataCount = outEntityList.size();
        }
        outDto.setDataCount(dataCount);

        // 取得件数＞０件の場合、取得した情報をDTOに設定する。
        if (dataCount > 0) {

            // Entity⇒DTOに転記
            // ・Md013_01ResultDataEntity.添付ファイル⇒DTO.添付ファイル
            outDto.setLblID_DocName(outEntityList.get(0).getDocname());
            // ・Md013_01ResultDataEntity.登録済みファイル名
            outDto.setLblID_Regist_DocName(outEntityList.get(0).getDocname());
            // ・Md013_01ResultDataEntity.扱店名  ⇒DTO.発信名
            outDto.setLblID_SendName_Organization(outEntityList.get(0).getName_organization());
            // ・Md013_01ResultDataEntity.報告年月日
            // 和暦に変換して設定する
            outDto.setLblID_SendDate_Report(dateFmt(outEntityList.get(0).getDate_report()));

            // ・Md013_01ResultDataEntity.報告年月日⇒DTO.報告年月日
            outDto.setLblID_Date_Report(outEntityList.get(0).getDate_report());
            // ・Md013_01ResultDataEntity.表示ファイル名⇒DTO.表示ファイル名
            outDto.setLblID_Disp_DocName(outEntityList.get(0).getDisp_docname());
            // ・Md013_01ResultDataEntity.添付ファイルアップロード先パス⇒DTO.添付ファイルアップロード先パス
            outDto.setLblID_UploadFilePath(outEntityList.get(0).getFilepath());
            // ・Md013_01ResultDataEntity.扱店名  ⇒DTO.扱店名
            outDto.setLblID_Name_Organization(outEntityList.get(0).getName_organization());
            // ・Md013_01ResultDataEntity.扱店  ⇒DTO.扱店
            outDto.setLblID_Code_Organization(outEntityList.get(0).getCode_organization());
            // ・Md013_01ResultDataEntity.店舗  ⇒DTO.店舗
            outDto.setLblID_Code_Tenpo(outEntityList.get(0).getCode_tenpo());
            // ・Md013_01ResultDataEntity.履歴番号  ⇒DTO.履歴番号
            outDto.setLblID_History(outEntityList.get(0).getId_history());
            // ・Md013_01ResultDataEntity.更新日時  ⇒DTO.更新日時
            outDto.setLblID_DateTime_Update(outEntityList.get(0).getDatetime_update());
            // ・Md013_01ResultDataEntity.添付ファイルアップロード先パス
            // ⇒DTO.退避添付ファイルアップロード先パス
            outDto.setLblID_KeepUploadFilePath(outEntityList.get(0).getFilepath());

            // 金融機関名称の取得
            // ・ログインユーザの権限種別
            String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();
            // ・ログインユーザの扱店コード
            String codeOrga = PNCommonInfoHolder.getCommonInfo().getCode_Organization();
            // ・ログインユーザの店舗コード
            String codetenpo = PNCommonInfoHolder.getCommonInfo().getCode_Tenpo();
            // 受渡パラメータの操作選択が削除の場合
            if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(inDto.getLblID_ProcessMode())) {
                codeOrga = outEntityList.get(0).getCode_organization();
                codetenpo = outEntityList.get(0).getCode_tenpo();
            }

            String strNameOrganization = getNameOrganization(inDto, codeOrga, codetenpo, roleCode);
            if (strNameOrganization == null) {
                // ■金融機関名称がnull（取得した件数＝０）の場合、業務エラーとする。
                // エラーメッセージ：PM9060E
                outDto.setDataCount(0);
                return outDto;
            }
            outDto.setLblID_Name_Organization(strNameOrganization);
            outDto.setLblID_SendName_Organization(strNameOrganization);

        }

        return outDto;
    }

    /**
     * Md013_01ServiceのupdateDataDel
     *
     * @param inDto
     *            Md013_01DTO
     * @return Md013_01DTO
     */
    @Override
    public Md013_01DTO updateDataDel(Md013_01DTO inDto) {

        Md013_01DTO outDto = new Md013_01DTO();

        log.info("（根）抵当権抹消に係る報告書の削除");
        // 共通部品より業務日付を取得 ⇒業務日付
        String strGyoumuDate = pnCommonDBComponents.getPNBusinessDay(1);
        if (!PNCommonComponents.checkDate(strGyoumuDate)) {
            log.error("業務日付取得が不正です。[" + strGyoumuDate + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 共通部品よりシステム時間を取得 ⇒報告時分秒
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // DTO.報告日をYYYYMMDD形式に編集 ⇒報告年月日(YYYYMMDD)
        String strDateReport = inDto.getLblID_Date_Report().replaceAll(
                Md013Constants.STR_YEAR, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Md013Constants.STR_MONTH, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Md013Constants.STR_DAY, PNCommonConstants.LITERAL_BLANK);

        // -----------------------------------------------------------------------------
        // （１）．金融機関名称の取得
        // -----------------------------------------------------------------------------
        // 金融機関名称の取得
        // ・ログインユーザの権限種別
        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();
        // ・ログインユーザの扱店コード
        String codeOrga = PNCommonInfoHolder.getCommonInfo().getCode_Organization();
        // ・ログインユーザの店舗コード
        String codetenpo = PNCommonInfoHolder.getCommonInfo().getCode_Tenpo();
        String strNameOrganization = getNameOrganization(inDto, codeOrga, codetenpo, roleCode);
        if (strNameOrganization == null) {
            // ■取得した件数 ＝ ０ の場合、業務エラーとする。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        inDto.setLblID_Name_Organization(strNameOrganization);

        // -----------------------------------------------------------------------------
        // （２）．楽観的排他
        // -----------------------------------------------------------------------------
        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.5件数取得」を実行し、件数を取得する。
        TeitokenreportEntity inEntityTTK = new TeitokenreportEntity();

        // 取得条件の設定
        // ・DTO.報告書番号⇒TeitokenReportEntity.報告書番号
        inEntityTTK.setID_Report(inDto.getLblID_Report());
        // ・DTO.更新日時⇒TeitokenReportEntity.更新日時
        inEntityTTK.setDateTime_Update(inDto.getLblID_DateTime_Update());
        long hitcountTTK = teitokenreportdao.countByCondition(inEntityTTK);
        if (1 != hitcountTTK) {
            // ■取得した件数 ≠ １ の場合、業務エラーとする。
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // -----------------------------------------------------------------------------
        // （３）．報告書履歴データの更新
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        updateReportHistory(inDto);

        // -----------------------------------------------------------------------------
        // （４）．（根）抵当権抹消に係る報告報告書データの該当レコードの削除
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        TeitokenreportEntity outEntityTTK = new TeitokenreportEntity();
        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.6排他読込」を実行し、排他制御を行う。
        try {
            outEntityTTK = teitokenreportdao.findByPrimaryKeyForUpdate(inEntityTTK);

            if (outEntityTTK == null) {
                // すでに更新されているかチェック処理を記述
                // ■排他エラーの場合、業務エラーとする。
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0]);
            }

        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);

        }
        catch (CFWForUpdateException fue) {
            // 排他エラー
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], fue);

        }

        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.7削除処理」を実行し、削除を行う。
        // TeitokenReportDAO.delete
        try {
            int intResult = teitokenreportdao.delete(outEntityTTK);
            if (1 != intResult) {
                // ■削除結果件数≠１の場合、業務エラーとする。
                // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }

        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);

        }

        // -----------------------------------------------------------------------------
        // （５）．報告書履歴データの登録
        // -----------------------------------------------------------------------------
        insertReportHistory(inDto, strGyoumuDate, strSysDateTime, PNCommonConstants.TYPE_PROCESS_10, new BigDecimal(
                PNCommonConstants.STATUS_VALUE_7));

        return outDto;
    }

    /**
     * Md013_01ServiceのupdateDataMod
     *
     * @param inDto
     *            Md013_01DTO
     * @return Md013_01DTO
     */
    @Override
    public Md013_01DTO updateDataMod(Md013_01DTO inDto) {

        Md013_01DTO outDto = new Md013_01DTO();

        log.info("（根）抵当権抹消に係る報告書の修正");
        // 共通部品より業務日付を取得 ⇒業務日付
        String strGyoumuDate = pnCommonDBComponents.getPNBusinessDay(1);
        if (!PNCommonComponents.checkDate(strGyoumuDate)) {
            log.error("業務日付取得が不正です。[" + strGyoumuDate + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 共通部品よりシステム時間を取得 ⇒報告時分秒
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // DTO.報告日をYYYYMMDD形式に編集 ⇒報告年月日(YYYYMMDD)
        String strDateReport = inDto.getLblID_Date_Report().replaceAll(
                Md013Constants.STR_YEAR, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Md013Constants.STR_MONTH, PNCommonConstants.LITERAL_BLANK);
        strDateReport = strDateReport.replaceAll(
                Md013Constants.STR_DAY, PNCommonConstants.LITERAL_BLANK);

        // -----------------------------------------------------------------------------
        // （１）．金融機関名称の取得
        // -----------------------------------------------------------------------------
        // 金融機関名称の取得
        // ・ログインユーザの権限種別
        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();
        // ・ログインユーザの扱店コード
        String codeOrga = PNCommonInfoHolder.getCommonInfo().getCode_Organization();
        // ・ログインユーザの店舗コード
        String codetenpo = PNCommonInfoHolder.getCommonInfo().getCode_Tenpo();
        String strNameOrganization = getNameOrganization(inDto, codeOrga, codetenpo, roleCode);
        if (strNameOrganization == null) {
            // ■取得した件数 ＝ ０ の場合、業務エラーとする。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        inDto.setLblID_Name_Organization(strNameOrganization);

        // -----------------------------------------------------------------------------
        // （２）．楽観的排他
        // -----------------------------------------------------------------------------
        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.5件数取得」を実行し、件数を取得する。
        TeitokenreportEntity inEntityTTK = new TeitokenreportEntity();

        // 取得条件の設定
        // ・DTO.報告書番号⇒TeitokenReportEntity.報告書番号
        inEntityTTK.setID_Report(inDto.getLblID_Report());
        // ・DTO.更新日時⇒TeitokenReportEntity.更新日時
        inEntityTTK.setDateTime_Update(inDto.getLblID_DateTime_Update());
        // TeitokenReportDAO.countByCondition
        long hitcountTTK = teitokenreportdao.countByCondition(inEntityTTK);
        if (1 != hitcountTTK) {
            // ■取得した件数 ≠ １ の場合、業務エラーとする。
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // -----------------------------------------------------------------------------
        // （３）．報告書履歴データの更新
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        updateReportHistory(inDto);

        // -----------------------------------------------------------------------------
        // （４）．（根）抵当権抹消に係る報告報告書データの更新
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        TeitokenreportEntity outEntityTTK = new TeitokenreportEntity();
        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.6排他読込」を実行し、排他制御を行う。
        try {
            outEntityTTK = teitokenreportdao.findByPrimaryKeyForUpdate(inEntityTTK);

            if (outEntityTTK == null) {
                // すでに更新されているかチェック処理を記述
                // ■排他エラーの場合、業務エラーとする。
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0]);
            }

        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);

        }
        catch (CFWForUpdateException fue) {
            // 排他エラー
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], fue);

        }

        // （根）抵当権抹消に係る報告報告書データを設定する。
        // ・業務日付（yyyyMMdd） ⇒ TeitokenReportEntity.報告年月日
        outEntityTTK.setDate_Report(strGyoumuDate);
        // ・現在時刻（hhmmdd） ⇒ TeitokenReportEntity.報告時分秒
        outEntityTTK.setTime_Report(strSysDateTime);
        // ・ログインユーザのユーザID ⇒ TeitokenReportEntity.ユーザID
        outEntityTTK.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());
        // ・90257160（（根）抵当権抹消に係る報告報告） ⇒ TeitokenReportEntity.データコード
        outEntityTTK.setDataCode(PNCommonConstants.DATACODE_90257160);
        // ・ログインユーザの扱店 ⇒ TeitokenReportEntity.扱店
        outEntityTTK.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        // ・ログインユーザの店舗 ⇒ TeitokenReportEntity.店舗
        outEntityTTK.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

        // 拡張子の取得
        String extension = "";
        String strDocName = inDto.getLblID_DocName();
        String fileName = new File(strDocName).getName();
        int lastDotPosition = fileName.lastIndexOf(".");
        if (lastDotPosition != -1) {
            extension = fileName.substring(lastDotPosition);
        }

        // 表示ファイル名
        outEntityTTK.setDisp_DocName(inDto.getLblID_DocName());
        // 添付ファイル
        outEntityTTK.setDocName(inDto.getLblID_DocName());
        // 添付ファイルアップロード先パス ⇒ TeitokenReportEntity.添付ファイルアップロード先パス
        outEntityTTK.setFilePath(inDto.getLblID_UploadFilePath());

        // 単テーブルアクセス定義「（根）抵当権抹消に係る報告報告書データNo.8更新処理」を実行し、更新を行う。
        try {
            // 更新の実行
            int intResult = teitokenreportdao.update(outEntityTTK);
            if (1 != intResult) {
                // ■更新結果件数≠１の場合、業務エラーとする。
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E);
            }
        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);

        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("包括委任状等の交付依頼報告書データ更新時にエラー発生", dke);
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], dke);

        }

        // -----------------------------------------------------------------------------
        // （５）．報告書履歴データの登録
        // -----------------------------------------------------------------------------
        insertReportHistory(inDto, strGyoumuDate, strSysDateTime, PNCommonConstants.TYPE_PROCESS_20, new BigDecimal(
                PNCommonConstants.STATUS_VALUE_6));

        return outDto;
    }

    /**
     * 金融機関名称の取得メソッド
     *
     * @param inDto Md013_01DTO
     * @param codeOrga 扱店コード
     * @param codeTenpo 店舗コード
     * @param roleCode 権限種別
     * @return Md013_01DTO
     */
    private String getNameOrganization(Md013_01DTO inDto, String codeOrga, String codeTenpo, String roleCode) {

        String strNameOrganization = null;

        // 金融機関名称の取得
        // Md013_01TenpoNameResultsDataDAO.findByCondition
        Md013_01TenpoNameResultDataEntity inTenpoNameEntity = new Md013_01TenpoNameResultDataEntity();
        // 取得条件の設定
        // ・ログインユーザの権限種別
        if (!roleCode.isEmpty()) {
            inTenpoNameEntity.setRolecode(roleCode);
        }
        // ・ログインユーザの扱店コード
        inTenpoNameEntity.setCode_organization(codeOrga);
        // ・ログインユーザの店舗コード
        inTenpoNameEntity.setCode_tenpo(codeTenpo);
        List<Md013_01TenpoNameResultDataEntity> outTenpoNameEntityList =
                md013_01tenponameresultdatadao.findByCondition(inTenpoNameEntity);

        if (null == outTenpoNameEntityList || outTenpoNameEntityList.size() == 0) {
            // ■金融機関名称がnull（取得した件数＝０）の場合
            return null;
        }
        else {
            Md013_01DTO outDto = new Md013_01DTO();

            // ■取得件数をDTOに設定する。
            // ・取得件数⇒Md013_01DTO.取得件数
            outDto.setDataCount(outTenpoNameEntityList.size());

            // EntityからDTOデータを設定する。
            strNameOrganization = outTenpoNameEntityList.get(0).getName_organization();
        }

        return strNameOrganization;
    }

    /**
     * 報告書履歴データの更新メソッド
     *
     * @param inDto
     */
    private void updateReportHistory(Md013_01DTO inDto) {
        // データの更新処理を行う。
        // 単テーブルアクセス定義「報告書履歴データNo.2排他読込」を実行し、排他制御を行う。
        ReporthistoryEntity inEntityRH = new ReporthistoryEntity();
        // 取得条件の設定
        // ・DTO.履歴番号 ⇒ReporthistoryEntity.履歴番号
        inEntityRH.setID_History(inDto.getLblID_History());
        // ReporthistoryDAO.findByPrimaryKeyForUpdate
        ReporthistoryEntity outEntityRH = new ReporthistoryEntity();
        try {
            outEntityRH = reporthistorydao.findByPrimaryKeyForUpdate(inEntityRH);

            if (null == outEntityRH) {
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E);
            }
            // すでに更新されているかチェック処理を記述
            BigDecimal flgTorikeshiZumi_1 = new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1);
            if (flgTorikeshiZumi_1.equals(outEntityRH.getFlag_Torikeshizumi())) {
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E);
            }

        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);
        }
        catch (CFWForUpdateException fue) {
            // ■排他エラーの場合、業務エラーとする。
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], fue);
        }

        // 報告書履歴データを設定する。
        // ・NULL⇒ReporthistoryEntity.報告書番号
        outEntityRH.setID_Report(null);
        // ・１（取消対象） ⇒ReporthistoryEntity.取消済フラグ
        outEntityRH.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1));

        // 単テーブルアクセス定義「報告書履歴データNo.3更新処理」を実行し、更新を行う。
        try {
            // 更新の実行
            int intResult = reporthistorydao.update(outEntityRH);
            if (1 != intResult) {
                // ■更新結果件数≠１の場合、業務エラーとする。
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E);
            }

        }
        catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            log.fatal("検索に必要なパラメータが未設定です", fpe);
            // メッセージID：PM9990E : システムエラーが発生しました。日本政策金融公庫までご連絡ください。
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, fpe);

        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("報告書履歴データ更新時にエラー発生", dke);
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], dke);
        }

    }

    /**
     * 報告書履歴データの登録
     *
     * @param inDto 画面情報
     * @param strType_Process 処理種別
     * @param bdStatus ステータス
     */
    private void insertReportHistory(Md013_01DTO inDto, String strGyoumuDate, String strSysDateTime,
            String strType_Process, BigDecimal bdStatus) {

        // 共通部品より履歴番号最大値を取得 ⇒履歴番号最大値
        String strID_History = pnCommonDBComponents.getIdHistoryRh();

        // 報告書履歴データを設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();

        // ・履歴番号最大値 ⇒ ReporthistoryEntity.履歴番号
        inEntity.setID_History(strID_History);

        // ・DTO.報告書番号 ⇒ ReporthistoryEntity.報告書番号
        inEntity.setID_Report(inDto.getLblID_Report());

        // ・業務日付 ⇒ ReporthistoryEntity.報告年月日
        inEntity.setDate_Report(strGyoumuDate);

        // ・報告時分秒 ⇒ ReporthistoryEntity.現在時刻
        inEntity.setTime_Report(strSysDateTime);

        // ・取消：7(ステータス無し)修正：6(ステータス無し) ⇒ ReporthistoryEntity.ステータス
        inEntity.setStatus(bdStatus);

        // ・空文字 ⇒ ReporthistoryEntity.原本番号
        inEntity.setID_Master(PNCommonConstants.LITERAL_BLANK);

        // ・90257160（（根）抵当権抹消に係る報告報告書） ⇒ ReporthistoryEntity.データコード
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257160);

        // ・取消：10（削除）修正：20（修正） ⇒ ReporthistoryEntity.処理種別
        inEntity.setType_Process(strType_Process);

        // ・0（取消非対象） ⇒ ReporthistoryEntity.取消済みフラグ
        inEntity.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // ・ログインユーザのユーザID ⇒ ReporthistoryEntity.ユーザID
        inEntity.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());

        // ・DTO.扱店名 ⇒ ReporthistoryEntity.扱店名
        inEntity.setName_Organization(inDto.getLblID_Name_Organization());

        // ・空文字 ⇒ ReporthistoryEntity.顧客名
        inEntity.setName_Customer(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.公庫支店コード
        inEntity.setCode_KoukoShiten(PNCommonConstants.LITERAL_BLANK);

        // ・ログインユーザの扱店コード  ⇒ ReporthistoryEntity.扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());

        // ・ログインユーザの.店舗コード  ⇒ ReporthistoryEntity.店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

        // ・空文字 ⇒ ReporthistoryEntity.年度
        inEntity.setYear(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.方式資金
        inEntity.setCode_HoshikiShikin(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.稟議番号
        inEntity.setID_Ringi(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.稟議番号枝番
        inEntity.setID_RingiBranch(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.エラーコード
        inEntity.setCode_Error(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.エラーメッセージ
        inEntity.setErrorMessage(PNCommonConstants.LITERAL_BLANK);

        // ・0 ⇒ ReporthistoryEntity.債権管理番号
        inEntity.setID_Credit(null);

        // ・0 ⇒ ReporthistoryEntity.退避賦金
        inEntity.setKeep_M_Fukin(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.退避元金不均等額
        inEntity.setKeep_M_GankinFukinto(BigDecimal.ZERO);

        // ・空文字 ⇒ ReporthistoryEntity.退避元金不均等額区分
        inEntity.setKeep_Kubun_GankinFukinto(PNCommonConstants.LITERAL_BLANK);

        // ・0 ⇒ ReporthistoryEntity.退避貸付金残高
        inEntity.setKeep_M_KashitsukeZan(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.退避約定元金
        inEntity.setKeep_M_YakujoGankin(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.退避約定利息
        inEntity.setKeep_M_YakujoRisoku(BigDecimal.ZERO);

        // ・空文字 ⇒ ReporthistoryEntity.退避償還期限年月
        inEntity.setKeep_Date_ShokanKigen(PNCommonConstants.LITERAL_BLANK);

        // ・0 ⇒ ReporthistoryEntity.元利金受入充当報告書の控除利息
        inEntity.setKeep_M_KojoRisoku(BigDecimal.ZERO);

        // ・空文字 ⇒ ReporthistoryEntity.元利金受入充当報告書の払込期日
        inEntity.setKeep_Date_Haraikomi(PNCommonConstants.LITERAL_BLANK);

        // ・0 ⇒ ReporthistoryEntity.請求データの退避任意繰上償還利息
        inEntity.setKeep_Seikyu_M_NinKuriRisoku(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.請求データの退避請求繰上償還利息
        inEntity.setKeep_Seikyu_M_SeiKuriRisoku(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.請求データの退避請求繰上償還元金
        inEntity.setKeep_Seikyu_M_SeiKuriGankin(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.約定データの退避請求繰上償還利息
        inEntity.setKeep_Yakujo_M_SeiKuriRisoku(BigDecimal.ZERO);

        // ・空文字 ⇒ ReporthistoryEntity.扱店別稟議データの退避条変起案中区分
        inEntity.setKeep_JohenKianchu(PNCommonConstants.LITERAL_BLANK);

        // ・空文字 ⇒ ReporthistoryEntity.退避履歴番号
        inEntity.setKeep_ID_History(PNCommonConstants.LITERAL_BLANK);

        // ・0 ⇒ ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        inEntity.setKeep_Flag_Kj(BigDecimal.ZERO);

        // ・0 ⇒ ReporthistoryEntity.退避受入後立替金残高
        inEntity.setKeep_M_TatekaeZanAfterUkeire(BigDecimal.ZERO);

        // 単テーブルアクセス定義「報告書履歴データのNo.1件数取得」を実行し、件数を取得する。
        long hitcountRH = reporthistorydao.countByCondition(inEntity);

        if (hitcountRH > 0) {
            // ■取得した件数＞０の場合、業務エラーとする。
            // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }
        // 単テーブルアクセス定義「報告書履歴データNo.4登録処理」を実行し、登録を行う。
        try {
            int intResult = reporthistorydao.insert(inEntity);
            if (1 != intResult) {
                // ■登録結果件数≠１の場合、業務エラーとする。
                // メッセージID：PM9030E : 他のユーザによってデータが更新されています。再検索を行ってください。
                throw new PNServiceException(PNCommonMessageConstants.PM9030E);
            }

        }
        catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            log.fatal("報告書履歴データ登録時にエラー発生", dke);
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, new String[0], dke);

        }
    }

    /**
     * <pre>
     * yyymmdd形式の日付をGyy年mm月dd日形式の日付に変換します。
     * </pre>
     *
     * @param String
     *            inDate
     * @return String outDate
     */
    public String dateFmt(String inDate) {

        // 日付形式チェック
        if (!PNCommonComponents.checkDate(inDate)) {
            log.error("不正な日付が指定されています");
            throw new PNSystemException();
        }

        // yyyymmdd ⇒ Gyy
        String dateGyy = PNCommonComponents.dateFmtAD_YYYY(inDate.substring(
                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX,
                PNCommonConstants.DATE1_YEAR_END_INDEX));

        // yyyymmdd ⇒ mm
        String dateDD = inDate.substring(
                PNCommonConstants.DATE1_MONTH_BEGIN_INDEX,
                PNCommonConstants.DATE1_MONTH_END_INDEX);

        // yyyymmdd ⇒ dd
        String dateMM = inDate.substring(
                PNCommonConstants.DATE1_DAY_BEGIN_INDEX,
                PNCommonConstants.DATE1_DAY_END_INDEX);

        // Gyy + 年 + mm + 月 + dd +日
        String outDate = PNCommonComponents.concatString(dateGyy,
                Md013Constants.STR_YEAR,
                dateDD,
                Md013Constants.STR_MONTH,
                dateMM,
                Md013Constants.STR_DAY);

        return outDate;

    }
}