//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_01.web;

import java.util.LinkedHashMap;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはSe008_01のFormクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_01Form extends PNBaseForm {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** メッセージ */
	private String lblError;

	/** 検索開始年月日（年） */
	private String searchStartYear;
	/** 検索開始年月日（月） */
	private String searchStartMonth;
	/** 検索開始年月日（日） */
	private String searchStartDate;
	/** 検索終了年月日（年） */
	private String searchEndYear;
	/** 検索終了年月日（月） */
	private String searchEndMonth;
	/** 検索終了年月日（日） */
	private String searchEndDate;

	/** 検索開始年ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchStartYear_PulldownList = new LinkedHashMap<String, Object>();
	/** 検索開始月ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchStartMonth_PulldownList = new LinkedHashMap<String, Object>();
	/** 検索開始日ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchStartDay_PulldownList = new LinkedHashMap<String, Object>();
	/** 検索終了年ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchEndYear_PulldownList = new LinkedHashMap<String, Object>();
	/** 検索終了月ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchEndMonth_PulldownList = new LinkedHashMap<String, Object>();
	/** 検索終了日ドロップダウンリスト */
	private LinkedHashMap<String, Object> searchEndDay_PulldownList = new LinkedHashMap<String, Object>();

	/**
	 * メッセージを取得します。
	 * 
	 * @return メッセージ
	 */
	public String getLblError() {
		return lblError;
	}

	/**
	 * メッセージを設定します。
	 * 
	 * @param lblError
	 *            メッセージ
	 */
	public void setLblError(String lblError) {
		this.lblError = lblError;
	}

	/**
	 * 検索開始年月日（年）を取得します。
	 * 
	 * @return 検索開始年月日（年）
	 */
	public String getSearchStartYear() {
		return searchStartYear;
	}

	/**
	 * 検索開始年月日（年）を設定します。
	 * 
	 * @param searchStartYear
	 *            検索開始年月日（年）
	 */
	public void setSearchStartYear(String searchStartYear) {
		this.searchStartYear = searchStartYear;
	}

	/**
	 * 検索開始年月日（月）を取得します。
	 * 
	 * @return 検索開始年月日（月）
	 */
	public String getSearchStartMonth() {
		return searchStartMonth;
	}

	/**
	 * 検索開始年月日（月）を設定します。
	 * 
	 * @param searchStartMonth
	 *            検索開始年月日（月）
	 */
	public void setSearchStartMonth(String searchStartMonth) {
		this.searchStartMonth = searchStartMonth;
	}

	/**
	 * 検索開始年月日（日）を取得します。
	 * 
	 * @return 検索開始年月日（日）
	 */
	public String getSearchStartDate() {
		return searchStartDate;
	}

	/**
	 * 検索開始年月日（日）を設定します。
	 * 
	 * @param searchStartDate
	 *            検索開始年月日（日）
	 */
	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	/**
	 * 検索終了年月日（年）を取得します。
	 * 
	 * @return 検索終了年月日（年）
	 */
	public String getSearchEndYear() {
		return searchEndYear;
	}

	/**
	 * 検索終了年月日（年）を設定します。
	 * 
	 * @param searchEndYear
	 *            検索終了年月日（年）
	 */
	public void setSearchEndYear(String searchEndYear) {
		this.searchEndYear = searchEndYear;
	}

	/**
	 * 検索終了年月日（月）を取得します。
	 * 
	 * @return 検索終了年月日（月）
	 */
	public String getSearchEndMonth() {
		return searchEndMonth;
	}

	/**
	 * 検索終了年月日（月）を設定します。
	 * 
	 * @param searchEndMonth
	 *            検索終了年月日（月）
	 */
	public void setSearchEndMonth(String searchEndMonth) {
		this.searchEndMonth = searchEndMonth;
	}

	/**
	 * 検索終了年月日（日）を取得します。
	 * 
	 * @return 検索終了年月日（日）
	 */
	public String getSearchEndDate() {
		return searchEndDate;
	}

	/**
	 * 検索終了年月日（日）を設定します。
	 * 
	 * @param searchEndDate
	 *            検索終了年月日（日）
	 */
	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	/**
	 * 検索終了年ドロップダウンリストを設定します。
	 * 
	 * @param public 検索終了年ドロップダウンリスト
	 */
	public void setSearchStartYear_PulldownList(
			LinkedHashMap<String, Object> pMap) {
		this.searchStartYear_PulldownList = pMap;
	}

	/**
	 * 検索終了年ドロップダウンリストを取得します。
	 * 
	 * @param 検索終了年ドロップダウンリスト
	 */
	public LinkedHashMap<String, Object> getSearchStartYear_PulldownList() {
		return searchStartYear_PulldownList;
	}

	/**
	 * 検索終了月ドロップダウンリストを設定します。
	 * 
	 * @param searchStartMonth_PulldownList
	 *            検索終了月ドロップダウンリスト
	 */
	public void setSearchStartMonth_PulldownList(
			LinkedHashMap<String, Object> pMap) {
		this.searchStartMonth_PulldownList = pMap;
	}

	/**
	 * 検索終了月ドロップダウンリストを取得します。
	 * 
	 * @param 検索終了月ドロップダウンリスト
	 */
	public LinkedHashMap<String, Object> getSearchStartMonth_PulldownList() {
		return searchStartMonth_PulldownList;
	}

	/**
	 * 検索終了日ドロップダウンリストを設定します。
	 * 
	 * @param searchStartDay_PulldownList
	 *            検索終了日ドロップダウンリスト
	 */
	public void setSearchStartDay_PulldownList(
			LinkedHashMap<String, Object> pMap) {
		this.searchStartDay_PulldownList = pMap;
	}

	/**
	 * 検索終了日ドロップダウンリストを取得します。
	 * 
	 * @param 検索終了日ドロップダウンリスト
	 */
	public LinkedHashMap<String, Object> getSearchStartDay_PulldownList() {
		return searchStartDay_PulldownList;
	}

	/**
	 * 検索終了年ドロップダウンリストを設定します。
	 * 
	 * @param searchEndYear_PulldownList
	 *            検索終了年ドロップダウンリスト
	 */
	public void setSearchEndYear_PulldownList(LinkedHashMap<String, Object> pMap) {
		this.searchEndYear_PulldownList = pMap;
	}

	/**
	 * 検索終了年ドロップダウンリストを設定します。
	 * 
	 * @param 検索終了年ドロップダウを取得します
	 *            。ンリスト
	 */
	public LinkedHashMap<String, Object> getSearchEndYear_PulldownList() {
		return searchEndYear_PulldownList;
	}

	/**
	 * 検索終了月ドロップダウンリストを設定します。
	 * 
	 * @param searchEndMonth_PulldownList
	 *            検索終了月ドロップダウンリスト
	 */
	public void setSearchEndMonth_PulldownList(
			LinkedHashMap<String, Object> pMap) {
		this.searchEndMonth_PulldownList = pMap;
	}

	/**
	 * 検索終了月ドロップダウンリストを取得します。
	 * 
	 * @param 検索終了月ドロップダウンリスト
	 */
	public LinkedHashMap<String, Object> getSearchEndMonth_PulldownList() {
		return searchEndMonth_PulldownList;
	}

	/**
	 * 検索終了日ドロップダウンリストを設定します。
	 * 
	 * @param searchEndDay_PulldownList
	 *            検索終了日ドロップダウンリスト
	 */
	public void setSearchEndDay_PulldownList(LinkedHashMap<String, Object> pMap) {
		this.searchEndDay_PulldownList = pMap;
	}

	/**
	 * 検索終了日ドロップダウンリストを取得します。
	 * 
	 * @param 検索終了日ドロップダウンリスト
	 */
	public LinkedHashMap<String, Object> getSearchEndDay_PulldownList() {
		return searchEndDay_PulldownList;
	}

}