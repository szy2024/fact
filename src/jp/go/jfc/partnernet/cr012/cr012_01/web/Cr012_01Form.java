//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.web;

import java.util.List;

import jp.go.jfc.partnernet.cr012.cr012_01.service.Cr012_01M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr012_01のFormクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr012_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 包括委任状等の交付依頼明細 */
    private PNPagingTable<Cr012_01M1DTO> cr012_01M1Table = new PNPagingTableSerial<Cr012_01M1DTO>("cr012_01M1Table");

    /** メッセージＩＤ */
    private String lblMessageID;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 包括委任状等の交付依頼明細 */
    private List<Cr012_01M1DTO> MEISAI_LIST;

    /**
     * 包括委任状等の交付依頼明細を取得します。
     *
     * @return 包括委任状等の交付依頼明細
     */
    public PNPagingTable<Cr012_01M1DTO> getCr012_01M1Table() {
        return cr012_01M1Table;
    }

    /**
     * 包括委任状等の交付依頼明細を設定します。
     *
     * @param cr012_01m1Table
     *            包括委任状等の交付依頼明細
     */
    public void setCr012_01M1Table(PNPagingTable<Cr012_01M1DTO> cr012_01M1Table) {
        this.cr012_01M1Table = cr012_01M1Table;
    }

    /**
     * 包括委任状等の交付依頼明細テーブルレコードを取得します。
     *
     * @return 包括委任状等の交付依頼明細テーブル
     */
    public List<Cr012_01M1DTO> getCr012_01M1TableRecord() {
        return getCr012_01M1Table().getRecordList();
    }

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
     * @param lblID_Date_Report
     *            報告年月日
     */
    public void setLblID_Date_Report(String lblID_date_report) {
        this.lblID_Date_Report = lblID_date_report;
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
     * 包括委任状等の交付依頼明細を取得します。
     *
     * @return 包括委任状等の交付依頼明細
     */
    public List getMeisai_list() {
        return MEISAI_LIST;
    }

    /**
     * 包括委任状等の交付依頼明細を設定します。
     *
     * @param meisai_list
     */
    public void setMeisai_list(List meisai_list) {
        MEISAI_LIST = meisai_list;
    }

}