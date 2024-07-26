//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/05 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import java.util.LinkedHashMap;

/**
 * <pre>
 * このクラスはse006_01のFormクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告書種別 */
    private String ID_DataCode;
    /** 実行・回収関係報告書詳細 */
    private String ID_DataCode_Detail;
    /** 検索開始年月日（年） */
    private String ID_SearchStartYear;
    /** 検索開始年月日（月） */
    private String ID_SearchStartMonth;
    /** 検索開始年月日（日） */
    private String ID_SearchStartDate;
    /** 検索終了年月日（年） */
    private String ID_SearchEndYear;
    /** 検索終了年月日（月） */
    private String ID_SearchEndMonth;
    /** 検索終了年月日（日） */
    private String ID_SearchEndDate;
    /** 支店 */
    private String ID_Shiten;
    /** 扱店コード */
    private String ID_Code_Organization;
    /** 融資番号(扱店) */
    private String ID_YN_Code_Organization;
    /** 融資番号（店舗） */
    private String ID_YN_Code_Tenpo;
    /** 融資番号（年度） */
    private String ID_YN_Year;
    /** 融資番号（方式資金） */
    private String ID_YN_Kubun_HoshikiShikin;
    /** 融資番号（番号） */
    private String ID_YN_Ringi;
    /** 融資番号（枝番） */
    private String ID_YN_RingiBranch;
    /** 報告書種別_プルダウンリスト */
    private LinkedHashMap<String, String> DATACODE_PULLDOWN_LIST;
    /** 実行・回収関係報告書詳細_プルダウンリスト */
    private LinkedHashMap<String, String> DATACODE_DETAIL_PULLDOWN_LIST;
    /** 検索開始年月日（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_START_YEAR_PULLDOWN_LIST;
    /** 検索開始年月日（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_START_MONTH_PULLDOWN_LIST;
    /** 検索開始年月日（日）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_START_DATE_PULLDOWN_LIST;
    /** 検索終了年月日（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_END_YEAR_PULLDOWN_LIST;
    /** 検索終了年月日（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_END_MONTH_PULLDOWN_LIST;
    /** 検索終了年月日（日）_プルダウンリスト */
    private LinkedHashMap<String, Object> SEARCH_END_DATE_PULLDOWN_LIST;
    /** 公庫支店_プルダウンリスト */
    private LinkedHashMap<String, String> KOUKOSHITEN_CODE_PULLDOWN_LIST;
    /** チェック起算日 */
    private String CHECK_DATE;
    /** 前翌指定 */
    private String SKIP_DAYS;
    /** 非営業日 */
    private String Date_hieigyo;
    /** 祝日区分 */
    private String Kubun_shukujitsu;
    /** 営業日 */
    private String Date_eigyo;

    /**
     * 報告書種別を取得します。
     *
     * @return 報告書種別
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * 報告書種別を設定します。
     *
     * @param ID_DataCode 報告書種別
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 実行・回収関係報告書詳細を取得します。
     *
     * @return 実行・回収関係報告書詳細
     */
    public String getID_DataCode_Detail() {
        return ID_DataCode_Detail;
    }

    /**
     * 実行・回収関係報告書詳細を設定します。
     *
     * @param ID_DataCode_Detail 実行・回収関係報告書詳細
     */
    public void setID_DataCode_Detail(String ID_DataCode_Detail) {
        this.ID_DataCode_Detail = ID_DataCode_Detail;
    }

    /**
     * 検索開始年月日（年）を取得します。
     *
     * @return 検索開始年月日（年）
     */
    public String getID_SearchStartYear() {
        return ID_SearchStartYear;
    }

    /**
     * 検索開始年月日（年）を設定します。
     *
     * @param ID_SearchStartYear 検索開始年月日（年）
     */
    public void setID_SearchStartYear(String ID_SearchStartYear) {
        this.ID_SearchStartYear = ID_SearchStartYear;
    }

    /**
     * 検索開始年月日（月）を取得します。
     *
     * @return 検索開始年月日（月）
     */
    public String getID_SearchStartMonth() {
        return ID_SearchStartMonth;
    }

    /**
     * 検索開始年月日（月）を設定します。
     *
     * @param ID_SearchStartMonth 検索開始年月日（月）
     */
    public void setID_SearchStartMonth(String ID_SearchStartMonth) {
        this.ID_SearchStartMonth = ID_SearchStartMonth;
    }

    /**
     * 検索開始年月日（日）を取得します。
     *
     * @return 検索開始年月日（日）
     */
    public String getID_SearchStartDate() {
        return ID_SearchStartDate;
    }

    /**
     * 検索開始年月日（日）を設定します。
     *
     * @param ID_SearchStartDate 検索開始年月日（日）
     */
    public void setID_SearchStartDate(String ID_SearchStartDate) {
        this.ID_SearchStartDate = ID_SearchStartDate;
    }

    /**
     * 検索終了年月日（年）を取得します。
     *
     * @return 検索終了年月日（年）
     */
    public String getID_SearchEndYear() {
        return ID_SearchEndYear;
    }

    /**
     * 検索終了年月日（年）を設定します。
     *
     * @param ID_SearchEndYear 検索終了年月日（年）
     */
    public void setID_SearchEndYear(String ID_SearchEndYear) {
        this.ID_SearchEndYear = ID_SearchEndYear;
    }

    /**
     * 検索終了年月日（月）を取得します。
     *
     * @return 検索終了年月日（月）
     */
    public String getID_SearchEndMonth() {
        return ID_SearchEndMonth;
    }

    /**
     * 検索終了年月日（月）を設定します。
     *
     * @param ID_SearchEndMonth 検索終了年月日（月）
     */
    public void setID_SearchEndMonth(String ID_SearchEndMonth) {
        this.ID_SearchEndMonth = ID_SearchEndMonth;
    }

    /**
     * 検索終了年月日（日）を取得します。
     *
     * @return 検索終了年月日（日）
     */
    public String getID_SearchEndDate() {
        return ID_SearchEndDate;
    }

    /**
     * 検索終了年月日（日）を設定します。
     *
     * @param ID_SearchEndDate 検索終了年月日（日）
     */
    public void setID_SearchEndDate(String ID_SearchEndDate) {
        this.ID_SearchEndDate = ID_SearchEndDate;
    }

    /**
     * 支店を取得します。
     *
     * @return 支店
     */
    public String getID_Shiten() {
        return ID_Shiten;
    }

    /**
     * 支店を設定します。
     *
     * @param ID_Shiten
     *            支店
     */
    public void setID_Shiten(String ID_Shiten) {
        this.ID_Shiten = ID_Shiten;
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     *
     * @param ID_Code_Organization
     *            扱店コード
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 融資番号(扱店)を取得します。
     *
     * @return 融資番号(扱店)
     */
    public String getID_YN_Code_Organization() {
        return ID_YN_Code_Organization;
    }

    /**
     * 融資番号(扱店)を設定します。
     *
     * @param ID_YN_Code_Organization
     *            融資番号(扱店)
     */
    public void setID_YN_Code_Organization(String ID_YN_Code_Organization) {
        this.ID_YN_Code_Organization = ID_YN_Code_Organization;
    }

    /**
     * 融資番号（店舗）を取得します。
     *
     * @return 融資番号（店舗）
     */
    public String getID_YN_Code_Tenpo() {
        return ID_YN_Code_Tenpo;
    }

    /**
     * 融資番号（店舗）を設定します。
     *
     * @param ID_YN_Code_Tenpo
     *            融資番号（店舗）
     */
    public void setID_YN_Code_Tenpo(String ID_YN_Code_Tenpo) {
        this.ID_YN_Code_Tenpo = ID_YN_Code_Tenpo;
    }

    /**
     * 融資番号（年度）を取得します。
     *
     * @return 融資番号（年度）
     */
    public String getID_YN_Year() {
        return ID_YN_Year;
    }

    /**
     * 融資番号（年度）を設定します。
     *
     * @param ID_YN_Year
     *            融資番号（年度）
     */
    public void setID_YN_Year(String ID_YN_Year) {
        this.ID_YN_Year = ID_YN_Year;
    }

    /**
     * 融資番号（方式資金）を取得します。
     *
     * @return 融資番号（方式資金）
     */
    public String getID_YN_Kubun_HoshikiShikin() {
        return ID_YN_Kubun_HoshikiShikin;
    }

    /**
     * 融資番号（方式資金）を設定します。
     *
     * @param ID_YN_Kubun_HoshikiShikin
     *            融資番号（方式資金）
     */
    public void setID_YN_Kubun_HoshikiShikin(String ID_YN_Kubun_HoshikiShikin) {
        this.ID_YN_Kubun_HoshikiShikin = ID_YN_Kubun_HoshikiShikin;
    }

    /**
     * 融資番号（番号）を取得します。
     *
     * @return 融資番号（番号）
     */
    public String getID_YN_Ringi() {
        return ID_YN_Ringi;
    }

    /**
     * 融資番号（番号）を設定します。
     *
     * @param ID_YN_Ringi
     *            融資番号（番号）
     */
    public void setID_YN_Ringi(String ID_YN_Ringi) {
        this.ID_YN_Ringi = ID_YN_Ringi;
    }

    /**
     * 融資番号（枝番）を取得します。
     *
     * @return 融資番号（枝番）
     */
    public String getID_YN_RingiBranch() {
        return ID_YN_RingiBranch;
    }

    /**
     * 融資番号（枝番）を設定します。
     *
     * @param ID_YN_RingiBranch
     *            融資番号（枝番）
     */
    public void setID_YN_RingiBranch(String ID_YN_RingiBranch) {
        this.ID_YN_RingiBranch = ID_YN_RingiBranch;
    }

    /**
     * 報告書種別_プルダウンリストを取得します。
     *
     * @return 報告書種別_プルダウンリスト
     */
    public LinkedHashMap<String, String> getDATACODE_PULLDOWN_LIST() {
        return DATACODE_PULLDOWN_LIST;
    }

    /**
     * 報告書種別_プルダウンリストを設定します。
     *
     * @param DATACODE_PULLDOWN_LIST 報告書種別_プルダウンリスト
     */
    public void setDATACODE_PULLDOWN_LIST(LinkedHashMap<String, String> DATACODE_PULLDOWN_LIST) {
        this.DATACODE_PULLDOWN_LIST = DATACODE_PULLDOWN_LIST;
    }

    /**
     * 実行・回収関係報告書詳細_プルダウンリストを取得します。
     *
     * @return 実行・回収関係報告書詳細_プルダウンリスト
     */
    public LinkedHashMap<String, String> getDATACODE_DETAIL_PULLDOWN_LIST() {
        return DATACODE_DETAIL_PULLDOWN_LIST;
    }

    /**
     * 実行・回収関係報告書詳細_プルダウンリストを設定します。
     *
     * @param DATACODE_DETAIL_PULLDOWN_LIST 実行・回収関係報告書詳細_プルダウンリスト
     */
    public void setDATACODE_DETAIL_PULLDOWN_LIST(LinkedHashMap<String, String> DATACODE_DETAIL_PULLDOWN_LIST) {
        this.DATACODE_DETAIL_PULLDOWN_LIST = DATACODE_DETAIL_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（年）_プルダウンリストを取得します。
     *
     * @return 検索開始年月日（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_START_YEAR_PULLDOWN_LIST() {
        return SEARCH_START_YEAR_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（年）_プルダウンリストを設定します。
     *
     * @param SEARCH_START_YEAR_PULLDOWN_LIST 検索開始年月日（年）_プルダウンリスト
     */
    public void setSEARCH_START_YEAR_PULLDOWN_LIST(
            LinkedHashMap<String, Object> SEARCH_START_YEAR_PULLDOWN_LIST) {
        this.SEARCH_START_YEAR_PULLDOWN_LIST = SEARCH_START_YEAR_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（月）_プルダウンリストを取得します。
     *
     * @return 検索開始年月日（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_START_MONTH_PULLDOWN_LIST() {
        return SEARCH_START_MONTH_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（月）_プルダウンリストを設定します。
     *
     * @param SEARCH_START_MONTH_PULLDOWN_LIST 検索開始年月日（月）_プルダウンリスト
     */
    public void setSEARCH_START_MONTH_PULLDOWN_LIST(
            LinkedHashMap<String, Object> SEARCH_START_MONTH_PULLDOWN_LIST) {
        this.SEARCH_START_MONTH_PULLDOWN_LIST = SEARCH_START_MONTH_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（日）_プルダウンリストを取得します。
     *
     * @return 検索開始年月日（日）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_START_DATE_PULLDOWN_LIST() {
        return SEARCH_START_DATE_PULLDOWN_LIST;
    }

    /**
     * 検索開始年月日（日）_プルダウンリストを設定します。
     *
     * @param SEARCH_START_DATE_PULLDOWN_LIST 検索開始年月日（日）_プルダウンリスト
     */
    public void setSEARCH_START_DATE_PULLDOWN_LIST(
            LinkedHashMap<String, Object> SEARCH_START_DATE_PULLDOWN_LIST) {
        this.SEARCH_START_DATE_PULLDOWN_LIST = SEARCH_START_DATE_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（年）_プルダウンリストを取得します。
     *
     * @return 検索終了年月日（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_END_YEAR_PULLDOWN_LIST() {
        return SEARCH_END_YEAR_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（年）_プルダウンリストを設定します。
     *
     * @param SEARCH_END_YEAR_PULLDOWN_LIST 検索終了年月日（年）_プルダウンリスト
     */
    public void setSEARCH_END_YEAR_PULLDOWN_LIST(LinkedHashMap<String, Object> SEARCH_END_YEAR_PULLDOWN_LIST) {
        this.SEARCH_END_YEAR_PULLDOWN_LIST = SEARCH_END_YEAR_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（月）_プルダウンリストを取得します。
     *
     * @return 検索終了年月日（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_END_MONTH_PULLDOWN_LIST() {
        return SEARCH_END_MONTH_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（月）_プルダウンリストを設定します。
     *
     * @param SEARCH_END_MONTH_PULLDOWN_LIST 検索終了年月日（月）_プルダウンリスト
     */
    public void setSEARCH_END_MONTH_PULLDOWN_LIST(LinkedHashMap<String, Object> SEARCH_END_MONTH_PULLDOWN_LIST) {
        this.SEARCH_END_MONTH_PULLDOWN_LIST = SEARCH_END_MONTH_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（日）_プルダウンリストを取得します。
     *
     * @return 検索終了年月日（日）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSEARCH_END_DATE_PULLDOWN_LIST() {
        return SEARCH_END_DATE_PULLDOWN_LIST;
    }

    /**
     * 検索終了年月日（日）_プルダウンリストを設定します。
     *
     * @param SEARCH_END_DATE_PULLDOWN_LIST 検索終了年月日（日）_プルダウンリスト
     */
    public void setSEARCH_END_DATE_PULLDOWN_LIST(LinkedHashMap<String, Object> SEARCH_END_DATE_PULLDOWN_LIST) {
        this.SEARCH_END_DATE_PULLDOWN_LIST = SEARCH_END_DATE_PULLDOWN_LIST;
    }

    /**
     * 公庫支店_プルダウンリストを取得します。
     *
     * @return 公庫支店_プルダウンリスト
     */
    public LinkedHashMap<String, String> getKOUKOSHITEN_CODE_PULLDOWN_LIST() {
        return KOUKOSHITEN_CODE_PULLDOWN_LIST;
    }

    /**
     * 公庫支店_プルダウンリストを設定します。
     *
     * @param KOUKOSHITEN_CODE_PULLDOWN_LIST
     *            公庫支店_プルダウンリスト
     */
    public void setKOUKOSHITEN_CODE_PULLDOWN_LIST(LinkedHashMap<String, String> KOUKOSHITEN_CODE_PULLDOWN_LIST) {
        this.KOUKOSHITEN_CODE_PULLDOWN_LIST = KOUKOSHITEN_CODE_PULLDOWN_LIST;
    }

    /**
     * チェック起算日を取得します。
     *
     * @return チェック起算日
     */
    public String getCHECK_DATE() {
        return CHECK_DATE;
    }

    /**
     * チェック起算日を設定します。
     *
     * @param CHECK_DATE チェック起算日
     */
    public void setCHECK_DATE(String CHECK_DATE) {
        this.CHECK_DATE = CHECK_DATE;
    }

    /**
     * 前翌指定を取得します。
     *
     * @return 前翌指定
     */
    public String getSKIP_DAYS() {
        return SKIP_DAYS;
    }

    /**
     * 前翌指定を設定します。
     *
     * @param SKIP_DAYS 前翌指定
     */
    public void setSKIP_DAYS(String SKIP_DAYS) {
        this.SKIP_DAYS = SKIP_DAYS;
    }

    /**
     * 非営業日を取得します。
     *
     * @return 非営業日
     */
    public String getDate_hieigyo() {
        return Date_hieigyo;
    }

    /**
     * 非営業日を設定します。
     *
     * @param Date_hieigyo 非営業日
     */
    public void setDate_hieigyo(String Date_hieigyo) {
        this.Date_hieigyo = Date_hieigyo;
    }

    /**
     * 祝日区分を取得します。
     *
     * @return 祝日区分
     */
    public String getKubun_shukujitsu() {
        return Kubun_shukujitsu;
    }

    /**
     * 祝日区分を設定します。
     *
     * @param Kubun_shukujitsu 祝日区分
     */
    public void setKubun_shukujitsu(String Kubun_shukujitsu) {
        this.Kubun_shukujitsu = Kubun_shukujitsu;
    }

    /**
     * 営業日を取得します。
     *
     * @return 営業日
     */
    public String getDate_eigyo() {
        return Date_eigyo;
    }

    /**
     * 営業日を設定します。
     *
     * @param Date_eigyo 営業日
     */
    public void setDate_eigyo(String Date_eigyo) {
        this.Date_eigyo = Date_eigyo;
    }

}