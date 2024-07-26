//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se016_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/13 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se016.se016_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse016_01のDTOクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se016_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店 */
    private String lblID_Code_Organization;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 表示ファイル名 */
    private String lblID_Disp_DocName;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** ファイル名 */
    private String lblID_DocName;
    /** 添付ファイルアップロード先パス */
    private String lblID_UploadFilePath;
    /** 報告書番号 */
    private String lblID_Report;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se016_01M1DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Se016_01M1DTO(Se016_01M1DTO orig) {
        super(orig);
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
     * @param lblID_Code_Organization 扱店
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
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
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
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
     * @param lblID_Disp_DocName 表示ファイル名
     */
    public void setLblID_Disp_DocName(String lblID_Disp_DocName) {
        this.lblID_Disp_DocName = lblID_Disp_DocName;
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
     * @param lblID_Code_Tenpo 店舗
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * ファイル名を取得します。
     *
     * @return ファイル名
     */
    public String getLblID_DocName() {
        return lblID_DocName;
    }

    /**
     * ファイル名を設定します。
     *
     * @param lblID_DocName ファイル名
     */
    public void setLblID_DocName(String lblID_DocName) {
        this.lblID_DocName = lblID_DocName;
    }

    /**
     * 添付ファイルアップロード先パスを取得します。
     *
     * @return 添付ファイルアップロード先パス
     */
    public String getLblID_UploadFilePath() {
        return lblID_UploadFilePath;
    }

    /**
     * 添付ファイルアップロード先パスを設定します。
     *
     * @param lblID_UploadFilePath 添付ファイルアップロード先パス
     */
    public void setLblID_UploadFilePath(String lblID_UploadFilePath) {
        this.lblID_UploadFilePath = lblID_UploadFilePath;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 添付ファイルアップロード先パス
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }
}