//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut004_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut004.ut004_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * このクラスはut004_01のFormクラスです。
 * </pre>
 *
 * @author  林　晃平
 * @version 2.0.0
 */
public class Ut004_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 文書種別 */
    private String drpID_ID_InfoType;
    /** 文書名 */
    private String txtID_ID_DocName;
    /** 文書番号 */
    private String txtID_ID_DocNumber;
    /** 様式番号 */
    private String txtID_ID_FormatNumber;
// [ADD] Ver 2.0.0 - START
    /** 改正日付(元号) */
    private String drpID_DateTime_DocUpdate_Gengo;
// [ADD] Ver 2.0.0 - END
    /** 改正日付(年) */
    private String txtID_DateTime_DocUpdate_Year;
    /** 改正日付(月) */
    private String drpID_DateTime_DocUpdate_Month;
    /** 改正日付(日) */
    private String drpID_DateTime_DocUpdate_Day;

    /** MultipartFile インタフェースのfileUpload変数を宣言 */
    private MultipartFile fileUpload;

    /**
     * 文書種別を取得します。
     * @return 文書種別
     */
    public String getDrpID_ID_InfoType() {
        return drpID_ID_InfoType;
    }

    /**
     * 文書種別を設定します。
     * @param drpID_ID_InfoType 文書種別
     */
    public void setDrpID_ID_InfoType(String drpID_ID_InfoType) {
        this.drpID_ID_InfoType = drpID_ID_InfoType;
    }

    /**
     * 文書名を取得します。
     * @return 文書名
     */
    public String getTxtID_ID_DocName() {
        return txtID_ID_DocName;
    }

    /**
     * 文書名を設定します。
     * @param txtID_ID_DocName 文書名
     */
    public void setTxtID_ID_DocName(String txtID_ID_DocName) {
        this.txtID_ID_DocName = txtID_ID_DocName;
    }

    /**
     * 文書番号を取得します。
     * @return 文書番号
     */
    public String getTxtID_ID_DocNumber() {
        return txtID_ID_DocNumber;
    }

    /**
     * 文書番号を設定します。
     * @param txtID_ID_DocNumber 文書番号
     */
    public void setTxtID_ID_DocNumber(String txtID_ID_DocNumber) {
        this.txtID_ID_DocNumber = txtID_ID_DocNumber;
    }

    /**
     * 様式番号を取得します。
     * @return 様式番号
     */
    public String getTxtID_ID_FormatNumber() {
        return txtID_ID_FormatNumber;
    }

    /**
     * 様式番号を設定します。
     * @param txtID_ID_FormatNumber 様式番号
     */
    public void setTxtID_ID_FormatNumber(String txtID_ID_FormatNumber) {
        this.txtID_ID_FormatNumber = txtID_ID_FormatNumber;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * 改正日付(元号)を取得します。
     * @return 改正日付(元号)
     */
    public String getDrpID_DateTime_DocUpdate_Gengo() {
        return drpID_DateTime_DocUpdate_Gengo;
    }

    /**
     * 改正日付(元号)を設定します。
     * @param drpID_DateTime_DocUpdate_Gengo 改正日付(元号)
     */
    public void setDrpID_DateTime_DocUpdate_Gengo(String drpID_DateTime_DocUpdate_Gengo) {
        this.drpID_DateTime_DocUpdate_Gengo = drpID_DateTime_DocUpdate_Gengo;
    }
// [ADD] Ver 2.0.0 - END

    /**
     * 改正日付(年)を取得します。
     * @return 改正日付(年)
     */
    public String getTxtID_DateTime_DocUpdate_Year() {
        return txtID_DateTime_DocUpdate_Year;
    }

    /**
     * 改正日付(年)を設定します。
     * @param txtID_DateTime_DocUpdate_Year 改正日付(年)
     */
    public void setTxtID_DateTime_DocUpdate_Year(String txtID_DateTime_DocUpdate_Year) {
        this.txtID_DateTime_DocUpdate_Year = txtID_DateTime_DocUpdate_Year;
    }

    /**
     * 改正日付(月)を取得します。
     * @return 改正日付(月)
     */
    public String getDrpID_DateTime_DocUpdate_Month() {
        return drpID_DateTime_DocUpdate_Month;
    }

    /**
     * 改正日付(月)を設定します。
     * @param drpID_DateTime_DocUpdate_Month 改正日付(月)
     */
    public void setDrpID_DateTime_DocUpdate_Month(String drpID_DateTime_DocUpdate_Month) {
        this.drpID_DateTime_DocUpdate_Month = drpID_DateTime_DocUpdate_Month;
    }

    /**
     * 改正日付(日)を取得します。
     * @return 改正日付(日)
     */
    public String getDrpID_DateTime_DocUpdate_Day() {
        return drpID_DateTime_DocUpdate_Day;
    }

    /**
     * 改正日付(日)を設定します。
     * @param drpID_DateTime_DocUpdate_Day 改正日付(日)
     */
    public void setDrpID_DateTime_DocUpdate_Day(String drpID_DateTime_DocUpdate_Day) {
        this.drpID_DateTime_DocUpdate_Day = drpID_DateTime_DocUpdate_Day;
    }

    // /**
    // * 登録ファイル名を取得します。
    // * @return 登録ファイル名
    // */
    // public String getUploadFile() {
    // return uploadFile;
    // }
    //
    // /**
    // * 登録ファイル名を設定します。
    // * @param uploadFile 登録ファイル名
    // */
    // public void setUploadFile(String uploadFile) {
    // this.uploadFile = uploadFile;
    // }

    /** MultipartFile インタフェースのfileUpload変数を宣言を取得します。 */
    public MultipartFile getFileUpload() {
        return fileUpload;
    }

    /** MultipartFile インタフェースのfileUpload変数を宣言を設定します。 */
    public void setFileUpload(MultipartFile fileUpload) {
        this.fileUpload = fileUpload;
    }

}