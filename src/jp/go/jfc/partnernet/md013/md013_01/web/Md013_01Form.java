//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md013_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md013.md013_01.web;

import java.sql.Timestamp;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import org.springframework.web.multipart.MultipartFile;

//import com.fujitsu.PNfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはmd013_01のFormクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md013_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージID */
    private String lblMessageID;
    /** 発信者 */
    private String lblID_SendName_Organization;
    /** 発信日 */
    private String lblID_SendDate_Report;
    /** 登録済みファイル名 */
    private String lblID_Regist_DocName;
    /** 修正添付ファイル名 */
    private String lblID_DocName;
    /** 表示ファイル名 */
    private String lblID_Disp_DocName;
    /** 添付ファイルアップロード先パス */
    private String lblID_UploadFilePath;
    /** 履歴番号 */
    private String lblID_History;
    /** 更新日時 */
    private Timestamp lblID_DateTime_Update;
    /** 報告書番号 */
    private String lblID_Report;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 報告時分秒 */
    private String lblID_Time_Report;
    /** 処理モード */
    private String lblID_ProcessMode;
    /** 検索条件_報告書種別 */
    private String lblID_Keep_DataCode;
    /** 検索条件_検索タイプ */
    private String lblID_Keep_SearchType;
    /** 退避添付ファイルアップロード先パス */
    private String lblID_KeepUploadFilePath;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 更新済みフラグ */
    private String lblID_Flag_Koushinzumi;
    /** データ取得件数 */
    private int dataCount;
    /** MultipartFile インタフェースのfileUpload変数を宣言 */
    private MultipartFile fileUpload;

    /**
     * メッセージIDを取得します。
     *
     * @return メッセージID
     */
    public String getLblMessageID() {
        return lblMessageID;
    }

    /**
     * メッセージIDを設定します。
     *
     * @param lblMessageID
     *            メッセージID
     */
    public void setLblMessageID(String lblMessageID) {
        this.lblMessageID = lblMessageID;
    }

    /**
     * 発信者を取得します。
     * @return 発信者
     */
    public String getLblID_SendName_Organization() {
        return lblID_SendName_Organization;
    }

    /**
     * 発信者を設定します。
     * @param lblID_SendName_Organization 発信者
     */
    public void setLblID_SendName_Organization(String lblID_SendName_Organization) {
        this.lblID_SendName_Organization = lblID_SendName_Organization;
    }

    /**
     * 発信日を取得します。
     * @return 発信日
     */
    public String getLblID_SendDate_Report() {
        return lblID_SendDate_Report;
    }

    /**
     * 発信日を設定します。
     * @param lblID_SendDate_Report 発信日
     */
    public void setLblID_SendDate_Report(String lblID_SendDate_Report) {
        this.lblID_SendDate_Report = lblID_SendDate_Report;
    }

    /**
     * 登録済みファイル名を取得します。
     * @return 登録済みファイル名
     */
    public String getLblID_Regist_DocName() {
        return lblID_Regist_DocName;
    }

    /**
     * 登録済みファイル名を設定します。
     * @param lblID_Regist_DocName 登録済みファイル名
     */
    public void setLblID_Regist_DocName(String lblID_Regist_DocName) {
        this.lblID_Regist_DocName = lblID_Regist_DocName;
    }

    /**
     * 修正添付ファイル名を取得します。
     * @return 修正添付ファイル名
     */
    public String getLblID_DocName() {
        return lblID_DocName;
    }

    /**
     * 修正添付ファイル名を設定します。
     * @param lblID_DocName 修正添付ファイル名
     */
    public void setLblID_DocName(String lblID_DocName) {
        this.lblID_DocName = lblID_DocName;
    }

    /**
     * 表示ファイル名を取得します。
     * @return 表示ファイル名
     */
    public String getLblID_Disp_DocName() {
        return lblID_Disp_DocName;
    }

    /**
     * 表示ファイル名を設定します。
     * @param lblID_Disp_DocName 表示ファイル名
     */
    public void setLblID_Disp_DocName(String lblID_Disp_DocName) {
        this.lblID_Disp_DocName = lblID_Disp_DocName;
    }

    /**
     * 添付ファイルアップロード先パスを取得します。
     * @return 添付ファイルアップロード先パス
     */
    public String getLblID_UploadFilePath() {
        return lblID_UploadFilePath;
    }

    /**
     * 添付ファイルアップロード先パスを設定します。
     * @param lblID_UploadFilePath 添付ファイルアップロード先パス
     */
    public void setLblID_UploadFilePath(String lblID_UploadFilePath) {
        this.lblID_UploadFilePath = lblID_UploadFilePath;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getLblID_History() {
        return lblID_History;
    }

    /**
     * 履歴番号を設定します。
     * @param lblID_History 履歴番号
     */
    public void setLblID_History(String lblID_History) {
        this.lblID_History = lblID_History;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public Timestamp getLblID_DateTime_Update() {
        return lblID_DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param lblID_DateTime_Update 更新日時
     */
    public void setLblID_DateTime_Update(Timestamp lblID_DateTime_Update) {
        this.lblID_DateTime_Update = lblID_DateTime_Update;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblID_date_report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_date_report) {
        this.lblID_Date_Report = lblID_date_report;
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getLblID_Time_Report() {
        return lblID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param lblid_time_report 報告時分秒
     */
    public void setLblID_Time_Report(String lblID_Time_Report) {
        this.lblID_Time_Report = lblID_Time_Report;
    }

    /**
     * 処理モードを取得します。
     * @return 処理モード
     */
    public String getLblID_ProcessMode() {
        return lblID_ProcessMode;
    }

    /**
     * 処理モードを設定します。
     * @param lblID_ProcessMode 処理モード
     */
    public void setLblID_ProcessMode(String lblID_ProcessMode) {
        this.lblID_ProcessMode = lblID_ProcessMode;
    }

    /**
     * 検索条件_報告書種別を取得します。
     * @return 検索条件_報告書種別
     */
    public String getLblID_Keep_DataCode() {
        return lblID_Keep_DataCode;
    }

    /**
     * 検索条件_報告書種別を設定します。
     * @param lblID_keep_datacode 検索条件_報告書種別
     */
    public void setLblID_Keep_DataCode(String lblID_keep_datacode) {
        this.lblID_Keep_DataCode = lblID_keep_datacode;
    }

    /**
     * 検索条件_検索タイプを取得します。
     * @return 検索条件_検索タイプ
     */
    public String getLblID_Keep_SearchType() {
        return lblID_Keep_SearchType;
    }

    /**
     * 検索条件_検索タイプを設定します。
     * @param lblID_Keep_SearchType 検索条件_検索タイプ
     */
    public void setLblID_Keep_SearchType(String lblID_Keep_SearchType) {
        this.lblID_Keep_SearchType = lblID_Keep_SearchType;
    }

    /**
     * 退避添付ファイルアップロード先パスを取得します。
     * @return 退避添付ファイルアップロード先パス
     */
    public String getLblID_KeepUploadFilePath() {
        return lblID_KeepUploadFilePath;
    }

    /**
     * 退避添付ファイルアップロード先パスを設定します。
     * @param lblID_KeepUploadFilePath 退避添付ファイルアップロード先パス
     */
    public void setLblID_KeepUploadFilePath(String lblID_KeepUploadFilePath) {
        this.lblID_KeepUploadFilePath = lblID_KeepUploadFilePath;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblID_name_organization
     *            扱店名
     */
    public void setLblID_Name_Organization(String lblID_name_organization) {
        this.lblID_Name_Organization = lblID_name_organization;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param lblID_code_organization
     *            扱店
     */
    public void setLblID_Code_Organization(String lblID_code_organization) {
        this.lblID_Code_Organization = lblID_code_organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param lblID_code_tenpo
     *            店舗
     */
    public void setLblID_Code_Tenpo(String lblID_code_tenpo) {
        this.lblID_Code_Tenpo = lblID_code_tenpo;
    }

    /**
     * 更新済みフラグを取得します。
     *
     * @return 更新済みフラグ
     */
    public String getLblID_Flag_Koushinzumi() {
        return lblID_Flag_Koushinzumi;
    }

    /**
     * 更新済みフラグを設定します。
     *
     * @param lblID_Flag_Koushinzumi
     */
    public void setLblID_Flag_Koushinzumi(String lblID_Flag_Koushinzumi) {
        this.lblID_Flag_Koushinzumi = lblID_Flag_Koushinzumi;
    }

    /**
     * データ取得件数を取得します。
     *
     * @return データ取得件数
     */
    public int getDataCount() {
        return dataCount;
    }

    /**
     * データ取得件数を設定します。
     *
     * @param dataCount
     *            データ取得件数
     */
    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    /** MultipartFile インタフェースのfileUpload変数を宣言を取得します。 */
    public MultipartFile getFileUpload() {
        return fileUpload;
    }

    /** MultipartFile インタフェースのfileUpload変数を宣言を設定します。 */
    public void setFileUpload(MultipartFile fileUpload) {
        this.fileUpload = fileUpload;
    }

}