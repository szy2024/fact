//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr011_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.web;

import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.cr011.cr011_01.service.Cr011_01M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr011_01のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr011_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 資金交付依頼明細 */
    private PNPagingTable<Cr011_01M1DTO> cr011_01m1Table =
            new PNPagingTableSerial<Cr011_01M1DTO>("cr011_01m1Table");

    /** メッセージＩＤ */
    private String lblMessageID;
    /** 指定交付日（年） */
    private String drpID_ShiteiKofuYear;
    /** 指定交付日（月） */
    private String drpID_ShiteiKofuMonth;
    /** 指定交付日（日） */
    private String drpID_ShiteiKofuDate;
    /** 指定交付日（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_YEAR_PULLDOWN_LIST;
    /** 指定交付日（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_MONTH_PULLDOWN_LIST;
    /** 指定交付日（日）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_DATE_PULLDOWN_LIST;
    /** 初期表示時刻 */
    private String lblID_InitDispTime;

    /**
     * 資金交付依頼明細を取得します。
     * @return 資金交付依頼明細
     */
    public PNPagingTable<Cr011_01M1DTO> getCr011_01m1Table() {
        return cr011_01m1Table;
    }

    /**
     * 資金交付依頼明細を設定します。
     * @param cr011_01m1Table 資金交付依頼明細
     */
    public void setCr011_01m1Table(PNPagingTable<Cr011_01M1DTO> cr011_01m1Table) {
        this.cr011_01m1Table = cr011_01m1Table;
    }

    /**
     * 資金交付依頼明細テーブルレコードを取得します。
     * @return 資金交付依頼明細テーブル
     */
    public List<Cr011_01M1DTO> getCr011_01m1TableRecord() {
        return getCr011_01m1Table().getRecordList();
    }

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblMessageID() {
        return lblMessageID;
    }

    /**
     * エラーを設定します。
     * @param lblMessageID エラー
     */
    public void setLblMessageID(String lblMessageID) {
        this.lblMessageID = lblMessageID;
    }

    /**
     * 指定交付日（年）を取得します。
     * @return 指定交付日（年）
     */
    public String getDrpID_ShiteiKofuYear() {
        return drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（年）を設定します。
     * @param drpID_ShiteiKofuYear 指定交付日（年）
     */
    public void setDrpID_ShiteiKofuYear(String drpID_ShiteiKofuYear) {
        this.drpID_ShiteiKofuYear = drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（月）を取得します。
     * @return 指定交付日（月）
     */
    public String getDrpID_ShiteiKofuMonth() {
        return drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（月）を設定します。
     * @param drpID_ShiteiKofuMonth 指定交付日（月）
     */
    public void setDrpID_ShiteiKofuMonth(String drpID_ShiteiKofuMonth) {
        this.drpID_ShiteiKofuMonth = drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（日）を取得します。
     * @return 指定交付日（日）
     */
    public String getDrpID_ShiteiKofuDate() {
        return drpID_ShiteiKofuDate;
    }

    /**
     * 指定交付日（日）を設定します。
     * @param drpID_ShiteiKofuDate 指定交付日（日）
     */
    public void setDrpID_ShiteiKofuDate(String drpID_ShiteiKofuDate) {
        this.drpID_ShiteiKofuDate = drpID_ShiteiKofuDate;
    }

    /**
     * 指定交付日（年）_プルダウンリストを取得します。
     * @return 指定交付日（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_YEAR_PULLDOWN_LIST() {
        return SHITEIKOHU_YEAR_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（年）_プルダウンリストを設定します。
     * @param SHITEIKOHU_YEAR_PULLDOWN_LIST 指定交付日（年）_プルダウンリスト
     */
    public void setSHITEIKOHU_YEAR_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_YEAR_PULLDOWN_LIST) {
        this.SHITEIKOHU_YEAR_PULLDOWN_LIST = SHITEIKOHU_YEAR_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（月）_プルダウンリストを取得します。
     * @return 指定交付日（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_MONTH_PULLDOWN_LIST() {
        return SHITEIKOHU_MONTH_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（月）_プルダウンリストを設定します。
     * @param SHITEIKOHU_MONTH_PULLDOWN_LIST 指定交付日（月）_プルダウンリスト
     */
    public void setSHITEIKOHU_MONTH_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_MONTH_PULLDOWN_LIST) {
        this.SHITEIKOHU_MONTH_PULLDOWN_LIST = SHITEIKOHU_MONTH_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（日）_プルダウンリストを取得します。
     * @return 指定交付日（日）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_DATE_PULLDOWN_LIST() {
        return SHITEIKOHU_DATE_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（日）_プルダウンリストを設定します。
     * @param SHITEIKOHU_DATE_PULLDOWN_LIST 指定交付日（日）_プルダウンリスト
     */
    public void setSHITEIKOHU_DATE_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_DATE_PULLDOWN_LIST) {
        this.SHITEIKOHU_DATE_PULLDOWN_LIST = SHITEIKOHU_DATE_PULLDOWN_LIST;
    }

    /**
     * 初期表示時刻を取得します。
     * @return 初期表示時刻
     */
    public String getLblID_InitDispTime() {
        return lblID_InitDispTime;
    }

    /**
     * 初期表示時刻を設定します。
     * @param lblID_InitDispTime 初期表示時刻
     */
    public void setLblID_InitDispTime(String lblID_InitDispTime) {
        this.lblID_InitDispTime = lblID_InitDispTime;
    }

}