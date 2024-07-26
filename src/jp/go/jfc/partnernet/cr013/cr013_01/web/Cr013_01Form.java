//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr013_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.web;

import org.springframework.web.multipart.MultipartFile;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr013_01のFormクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr013_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージＩＤ */
    private String lblMessageID;
    /** 発信者 */
    private String lblID_Name_Organizat;
    /** 発信日 */
    private String lblID_SendDate_Report;
    /** 添付ファイル名 */
    private String lblID_DocName;
    /** 表示ファイル名 */
    private String lblID_Disp_DocName;
    /** アップロードファイル名 */
    private String lblID_UpLoadName;
    /** 添付ファイルアップロード先パス */
    private String lblID_UpLoadFilePath;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** データ取得件数 */
    private int dataCount;
    /** 表示制御 */
    private String flgDisp;

    /** MultipartFile インタフェースのfileUpload変数を宣言 */
    private MultipartFile fileUpload;

    /**
     * メッセージＩＤを取得します。
     *
     * @return メッセージＩＤ
     */
    public String getLblMessageID() {
        return lblMessageID;
    }

    /**
     * メッセージＩＤを設定します。
     *
     * @param lblerr
     *            メッセージＩＤ
     */
    public void setLblMessageID(String lblMessageID) {
        this.lblMessageID = lblMessageID;
    }

    /**
     * 発信者を取得します。
     *
     * @return 発信者
     */
    public String getLblID_Name_Organizat() {
        return lblID_Name_Organizat;
    }

    /**
     * 発信者を設定します。
     *
     * @param lblid_name_organizat
     *            発信者
     */
    public void setLblID_Name_Organizat(String lblid_name_organizat) {
        this.lblID_Name_Organizat = lblid_name_organizat;
    }

    /**
     * 発信日を取得します。
     *
     * @return 発信日
     */
    public String getLblID_SendDate_Report() {
        return lblID_SendDate_Report;
    }

    /**
     * 発信日を設定します。
     *
     * @param lblid_senddate_report
     *            発信日
     */
    public void setLblID_SendDate_Report(String lblid_senddate_report) {
        this.lblID_SendDate_Report = lblid_senddate_report;
    }

    /**
     * 添付ファイル名を取得します。
     *
     * @return ファイル名
     */
    public String getLblID_DocName() {
        return lblID_DocName;
    }

    /**
     * 添付ファイル名を設定します。
     *
     * @param lblid_docname
     *            ファイル名
     */
    public void setLblID_DocName(String lblid_docname) {
        this.lblID_DocName = lblid_docname;
    }

    /**
     * 表示ファイル名を取得します。
     *
     * @return 表示ファイル名
     */
    public String getLblID_Disp_DocName() {
        return lblID_Disp_DocName;
    }

    /**
     * 表示ファイル名を設定します。
     *
     * @param lblid_disp_docname
     *            表示ファイル名
     */
    public void setLblID_Disp_DocName(String lblid_disp_docname) {
        this.lblID_Disp_DocName = lblid_disp_docname;
    }

    /**
     * アップロードファイル名を取得します。
     *
     * @return アップロードファイル名
     */
    public String getLblID_UpLoadNam() {
        return lblID_UpLoadName;
    }

    /**
     * アップロードファイル名を設定します。
     *
     * @param lblid_uploadname
     *            アップロードファイル名
     */
    public void setLblID_UpLoadNam(String lblid_uploadname) {
        this.lblID_UpLoadName = lblid_uploadname;
    }

    /**
     * 添付ファイルアップロード先パスを取得します。
     *
     * @return 添付ファイルアップロード先パス
     */
    public String getLblID_UpLoadFilePath() {
        return lblID_UpLoadFilePath;
    }

    /**
     * 添付ファイルアップロード先パスを設定します。
     *
     * @param lblid_uploadfilepath
     *            添付ファイルアップロード先パス
     */
    public void setLblID_UpLoadFilePath(String lblid_uploadfilepath) {
        this.lblID_UpLoadFilePath = lblid_uploadfilepath;
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
     * @param lblid_code_organization
     *            扱店
     */
    public void setLblID_Code_Organization(String lblid_code_organization) {
        this.lblID_Code_Organization = lblid_code_organization;
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
     * @param lblid_code_tenpo
     *            店舗
     */
    public void setLblID_Code_Tenpo(String lblid_code_tenpo) {
        this.lblID_Code_Tenpo = lblid_code_tenpo;
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

    /**
     * 表示制御を取得します。
     *
     * @return 表示制御
     */
    public String getFlgDisp() {
        return flgDisp;
    }

    /**
     * 表示制御を設定します。
     *
     * @param flgDisp
     *            表示制御
     */
    public void setFlgDisp(String flgDisp) {
        this.flgDisp = flgDisp;
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