//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_16Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.web;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.se006.se006_16.service.Se006_16M1DTO;

/**
 * <pre>
 * このクラスはse006_16のFormクラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
public class Se006_16Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 包括委任状等の交付依頼明細 */
    private PNPagingTable<Se006_16M1DTO> se006_16m1Table = new PNPagingTableSerial<Se006_16M1DTO>("se006_16m1Table");

    /** エラー */
    private String lblErr;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 報告書番号 */
    private String lblID_Report;
    /** 検索条件_報告書種別 */
    private String lblID_Keep_DataCode;
    /** 検索条件_検索開始年月日（年） */
    private String lblID_Keep_SearchStartYear;
    /** 検索条件_検索開始年月日（月） */
    private String lblID_Keep_SearchStartMonth;
    /** 検索条件_検索開始年月日（日） */
    private String lblID_Keep_SearchStartDate;
    /** 検索条件_検索終了年月日（年） */
    private String lblID_Keep_SearchEndYear;
    /** 検索条件_検索終了年月日（月） */
    private String lblID_Keep_SearchEndMonth;
    /** 検索条件_検索終了年月日（日） */
    private String lblID_Keep_SearchEndDate;
    /** 検索条件_支店 */
    private String lblID_Keep_Shiten;
    /** 検索条件_融資番号(扱店) */
    private String lblID_Keep_YN_Code_Organization;
    /** 検索条件_融資番号（店舗） */
    private String lblID_Keep_YN_Code_Tenpo;
    /** 検索条件_融資番号（年度） */
    private String lblID_Keep_YN_Year;
    /** 検索条件_融資番号（方式資金） */
    private String lblID_Keep_YN_Kubun_HoshikiShikin;
    /** 検索条件_融資番号（番号） */
    private String lblID_Keep_YN_Ringi;
    /** 検索条件_融資番号（枝番） */
    private String lblID_Keep_YN_RingiBranch;
    /** 業務エラー件数 */
    private int lblID_BizErrorCount;

    /**
     * 包括委任状等の交付依頼明細を取得します。
     * @return 包括委任状等の交付依頼明細
     */
    public PNPagingTable<Se006_16M1DTO> getSe006_16m1Table() {
        return se006_16m1Table;
    }

    /**
     * 包括委任状等の交付依頼明細を設定します。
     * @param se006_16m1Table 包括委任状等の交付依頼明細
     */
    public void setSe006_16m1Table(PNPagingTable<Se006_16M1DTO> se006_16m1Table) {
        this.se006_16m1Table = se006_16m1Table;
    }

    /**
     * 包括委任状等の交付依頼明細テーブルレコードを取得します。
     * @return 包括委任状等の交付依頼明細テーブル
     */
    public List<Se006_16M1DTO> getSe006_16m1TableRecord() {
        return getSe006_16m1Table().getRecordList();
    }

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * エラーを設定します。
     * @param lblErr エラー
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
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
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
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
     * 検索条件_報告書種別を取得します。
     * @return 検索条件_報告書種別
     */
    public String getLblID_Keep_DataCode() {
        return lblID_Keep_DataCode;
    }

    /**
     * 検索条件_報告書種別を設定します。
     * @param lblID_Keep_DataCode 検索条件_報告書種別
     */
    public void setLblID_Keep_DataCode(String lblID_Keep_DataCode) {
        this.lblID_Keep_DataCode = lblID_Keep_DataCode;
    }

    /**
     * 検索条件_検索開始年月日（年）を取得します。
     * @return 検索条件_検索開始年月日（年）
     */
    public String getLblID_Keep_SearchStartYear() {
        return lblID_Keep_SearchStartYear;
    }

    /**
     * 検索条件_検索開始年月日（年）を設定します。
     * @param lblID_Keep_SearchStartYear 検索条件_検索開始年月日（年）
     */
    public void setLblID_Keep_SearchStartYear(String lblID_Keep_SearchStartYear) {
        this.lblID_Keep_SearchStartYear = lblID_Keep_SearchStartYear;
    }

    /**
     * 検索条件_検索開始年月日（月）を取得します。
     * @return 検索条件_検索開始年月日（月）
     */
    public String getLblID_Keep_SearchStartMonth() {
        return lblID_Keep_SearchStartMonth;
    }

    /**
     * 検索条件_検索開始年月日（月）を設定します。
     * @param lblID_Keep_SearchStartMonth 検索条件_検索開始年月日（月）
     */
    public void setLblID_Keep_SearchStartMonth(String lblID_Keep_SearchStartMonth) {
        this.lblID_Keep_SearchStartMonth = lblID_Keep_SearchStartMonth;
    }

    /**
     * 検索条件_検索開始年月日（日）を取得します。
     * @return 検索条件_検索開始年月日（日）
     */
    public String getLblID_Keep_SearchStartDate() {
        return lblID_Keep_SearchStartDate;
    }

    /**
     * 検索条件_検索開始年月日（日）を設定します。
     * @param lblID_Keep_SearchStartDate 検索条件_検索開始年月日（日）
     */
    public void setLblID_Keep_SearchStartDate(String lblID_Keep_SearchStartDate) {
        this.lblID_Keep_SearchStartDate = lblID_Keep_SearchStartDate;
    }

    /**
     * 検索条件_検索終了年月日（年）を取得します。
     * @return 検索条件_検索終了年月日（年）
     */
    public String getLblID_Keep_SearchEndYear() {
        return lblID_Keep_SearchEndYear;
    }

    /**
     * 検索条件_検索終了年月日（年）を設定します。
     * @param lblID_Keep_SearchEndYear 検索条件_検索終了年月日（年）
     */
    public void setLblID_Keep_SearchEndYear(String lblID_Keep_SearchEndYear) {
        this.lblID_Keep_SearchEndYear = lblID_Keep_SearchEndYear;
    }

    /**
     * 検索条件_検索終了年月日（月）を取得します。
     * @return 検索条件_検索終了年月日（月）
     */
    public String getLblID_Keep_SearchEndMonth() {
        return lblID_Keep_SearchEndMonth;
    }

    /**
     * 検索条件_検索終了年月日（月）を設定します。
     * @param lblID_Keep_SearchEndMonth 検索条件_検索終了年月日（月）
     */
    public void setLblID_Keep_SearchEndMonth(String lblID_Keep_SearchEndMonth) {
        this.lblID_Keep_SearchEndMonth = lblID_Keep_SearchEndMonth;
    }

    /**
     * 検索条件_検索終了年月日（日）を取得します。
     * @return 検索条件_検索終了年月日（日）
     */
    public String getLblID_Keep_SearchEndDate() {
        return lblID_Keep_SearchEndDate;
    }

    /**
     * 検索条件_検索終了年月日（日）を設定します。
     * @param lblID_Keep_SearchEndDate 検索条件_検索終了年月日（日）
     */
    public void setLblID_Keep_SearchEndDate(String lblID_Keep_SearchEndDate) {
        this.lblID_Keep_SearchEndDate = lblID_Keep_SearchEndDate;
    }

    /**
     * 検索条件_支店を取得します。
     * @return 検索条件_支店
     */
    public String getLblID_Keep_Shiten() {
        return lblID_Keep_Shiten;
    }

    /**
     * 検索条件_支店を設定します。
     * @param lblID_Keep_Shiten 検索条件_支店
     */
    public void setLblID_Keep_Shiten(String lblID_Keep_Shiten) {
        this.lblID_Keep_Shiten = lblID_Keep_Shiten;
    }

    /**
     * 検索条件_融資番号(扱店)を取得します。
     * @return 検索条件_融資番号(扱店)
     */
    public String getLblID_Keep_YN_Code_Organization() {
        return lblID_Keep_YN_Code_Organization;
    }

    /**
     * 検索条件_融資番号(扱店)を設定します。
     * @param lblID_Keep_YN_Code_Organization 検索条件_融資番号(扱店)
     */
    public void setLblID_Keep_YN_Code_Organization(String lblID_Keep_YN_Code_Organization) {
        this.lblID_Keep_YN_Code_Organization = lblID_Keep_YN_Code_Organization;
    }

    /**
     * 検索条件_融資番号（店舗）を取得します。
     * @return 検索条件_融資番号（店舗）
     */
    public String getLblID_Keep_YN_Code_Tenpo() {
        return lblID_Keep_YN_Code_Tenpo;
    }

    /**
     * 検索条件_融資番号（店舗）を設定します。
     * @param lblID_Keep_YN_Code_Tenpo 検索条件_融資番号（店舗）
     */
    public void setLblID_Keep_YN_Code_Tenpo(String lblID_Keep_YN_Code_Tenpo) {
        this.lblID_Keep_YN_Code_Tenpo = lblID_Keep_YN_Code_Tenpo;
    }

    /**
     * 検索条件_融資番号（年度）を取得します。
     * @return 検索条件_融資番号（年度）
     */
    public String getLblID_Keep_YN_Year() {
        return lblID_Keep_YN_Year;
    }

    /**
     * 検索条件_融資番号（年度）を設定します。
     * @param lblID_Keep_YN_Year 検索条件_融資番号（年度）
     */
    public void setLblID_Keep_YN_Year(String lblID_Keep_YN_Year) {
        this.lblID_Keep_YN_Year = lblID_Keep_YN_Year;
    }

    /**
     * 検索条件_融資番号（方式資金）を取得します。
     * @return 検索条件_融資番号（方式資金）
     */
    public String getLblID_Keep_YN_Kubun_HoshikiShikin() {
        return lblID_Keep_YN_Kubun_HoshikiShikin;
    }

    /**
     * 検索条件_融資番号（方式資金）を設定します。
     * @param lblID_Keep_YN_Kubun_HoshikiShikin 検索条件_融資番号（方式資金）
     */
    public void setLblID_Keep_YN_Kubun_HoshikiShikin(String lblID_Keep_YN_Kubun_HoshikiShikin) {
        this.lblID_Keep_YN_Kubun_HoshikiShikin = lblID_Keep_YN_Kubun_HoshikiShikin;
    }

    /**
     * 検索条件_融資番号（番号）を取得します。
     * @return 検索条件_融資番号（番号）
     */
    public String getLblID_Keep_YN_Ringi() {
        return lblID_Keep_YN_Ringi;
    }

    /**
     * 検索条件_融資番号（番号）を設定します。
     * @param lblID_Keep_YN_Ringi 検索条件_融資番号（番号）
     */
    public void setLblID_Keep_YN_Ringi(String lblID_Keep_YN_Ringi) {
        this.lblID_Keep_YN_Ringi = lblID_Keep_YN_Ringi;
    }

    /**
     * 検索条件_融資番号（枝番）を取得します。
     * @return 検索条件_融資番号（枝番）
     */
    public String getLblID_Keep_YN_RingiBranch() {
        return lblID_Keep_YN_RingiBranch;
    }

    /**
     * 検索条件_融資番号（枝番）を設定します。
     * @param lblID_Keep_YN_RingiBranch 検索条件_融資番号（枝番）
     */
    public void setLblID_Keep_YN_RingiBranch(String lblID_Keep_YN_RingiBranch) {
        this.lblID_Keep_YN_RingiBranch = lblID_Keep_YN_RingiBranch;
    }

    /**
     * 業務エラー件数を取得します。
     *
     * @return 業務エラー件数
     */
    public int getLblID_BizErrorCount() {
        return lblID_BizErrorCount;
    }

    /**
     * 業務エラー件数を設定します。
     *
     * @param lblID_BizErrorCount 業務エラー件数
     */
    public void setLblID_BizErrorCount(int lblID_BizErrorCount) {
        this.lblID_BizErrorCount = lblID_BizErrorCount;
    }

}