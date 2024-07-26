//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se016_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/13 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se016.se016_01.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse016_01のDTOクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se016_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラー */
    private String lblErr;
    /** 検索扱店コード */
    private String txtID_srcCode_Organization;
    /** 表示開始年月日（年） */
    private String drpID_HyoziStartYear;
    /** 表示開始年月日（月） */
    private String drpID_HyoziStartMonth;
    /** 表示開始年月日（日） */
    private String drpID_HyoziStartDay;
    /** 表示終了年月日（年） */
    private String drpID_HyoziEndYear;
    /** 表示終了年月日（月） */
    private String drpID_HyoziEndMonth;
    /** 表示終了年月日（日） */
    private String drpID_HyoziEndDay;
    /** 表示開始年月日（年）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziStartYear_PulldownList;
    /** 表示開始年月日（月）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziStartMonth_PulldownList;
    /** 表示開始年月日（日）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziStartDay_PulldownList;
    /** 表示終了年月日（年）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziEndYear_PulldownList;
    /** 表示終了年月日（月）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziEndMonth_PulldownList;
    /** 表示終了年月日（日）プルダウンリスト */
    private java.util.LinkedHashMap<String, String> drpID_HyoziEndDay_PulldownList;
    /** 明細リスト */
    private List<Se016_01M1DTO> meisai_list = new ArrayList<Se016_01M1DTO>(0);
    /** 検索結果該当件数 */
    private int searchCount;
    /** 退避検索条件 */
    private byte[] bkSearchCondition;
    /** 選択行番号 */
    private String selectedIndex;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se016_01DTO() {
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
    public Se016_01DTO(Se016_01DTO orig) {
        super(orig);
    }

    /**
     * エラーを取得します。
     *
     * @return エラー
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * エラーを設定します。
     *
     * @param lblErr エラー
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
    }

    /**
     * 検索扱店コードを取得します。
     *
     * @return 検索扱店コード
     */
    public String getTxtID_srcCode_Organization() {
        return txtID_srcCode_Organization;
    }

    /**
     * 検索扱店コードを設定します。
     *
     * @param txtID_srcCode_Organization 検索扱店コード
     */
    public void setTxtID_srcCode_Organization(String txtID_srcCode_Organization) {
        this.txtID_srcCode_Organization = txtID_srcCode_Organization;
    }

    /**
     * 表示開始年月日（年）を取得します。
     *
     * @return 表示開始年月日（年）
     */
    public String getDrpID_HyoziStartYear() {
        return drpID_HyoziStartYear;
    }

    /**
     * 表示開始年月日（年）を設定します。
     *
     * @param drpID_HyoziStartYear 表示開始年月日（年）
     */
    public void setDrpID_HyoziStartYear(String drpID_HyoziStartYear) {
        this.drpID_HyoziStartYear = drpID_HyoziStartYear;
    }

    /**
     * 表示開始年月日（月）を取得します。
     *
     * @return 表示開始年月日（月）
     */
    public String getDrpID_HyoziStartMonth() {
        return drpID_HyoziStartMonth;
    }

    /**
     * 表示開始年月日（月）を設定します。
     *
     * @param drpID_HyoziStartMonth 表示開始年月日（月）
     */
    public void setDrpID_HyoziStartMonth(String drpID_HyoziStartMonth) {
        this.drpID_HyoziStartMonth = drpID_HyoziStartMonth;
    }

    /**
     * 表示開始年月日（日）を取得します。
     *
     * @return 表示開始年月日（日）
     */
    public String getDrpID_HyoziStartDay() {
        return drpID_HyoziStartDay;
    }

    /**
     * 表示開始年月日（日）を設定します。
     *
     * @param drpID_HyoziStartDay 表示開始年月日（日）
     */
    public void setDrpID_HyoziStartDay(String drpID_HyoziStartDay) {
        this.drpID_HyoziStartDay = drpID_HyoziStartDay;
    }

    /**
     * 表示終了年月日（年）を取得します。
     *
     * @return 表示終了年月日（年）
     */
    public String getDrpID_HyoziEndYear() {
        return drpID_HyoziEndYear;
    }

    /**
     * 表示終了年月日（年）を設定します。
     *
     * @param drpID_HyoziEndYear 表示終了年月日（年）
     */
    public void setDrpID_HyoziEndYear(String drpID_HyoziEndYear) {
        this.drpID_HyoziEndYear = drpID_HyoziEndYear;
    }

    /**
     * 表示終了年月日（月）を取得します。
     *
     * @return 表示終了年月日（月）
     */
    public String getDrpID_HyoziEndMonth() {
        return drpID_HyoziEndMonth;
    }

    /**
     * 表示終了年月日（月）を設定します。
     *
     * @param drpID_HyoziEndMonth 表示終了年月日（月）
     */
    public void setDrpID_HyoziEndMonth(String drpID_HyoziEndMonth) {
        this.drpID_HyoziEndMonth = drpID_HyoziEndMonth;
    }

    /**
     * 表示終了年月日（日）を取得します。
     *
     * @return 表示終了年月日（日）
     */
    public String getDrpID_HyoziEndDay() {
        return drpID_HyoziEndDay;
    }

    /**
     * 表示終了年月日（日）を設定します。
     *
     * @param drpID_HyoziEndDay 表示終了年月日（日）
     */
    public void setDrpID_HyoziEndDay(String drpID_HyoziEndDay) {
        this.drpID_HyoziEndDay = drpID_HyoziEndDay;
    }

    /**
     * 表示開始年月日（年）プルダウンリストを取得します。
     *
     * @return 表示開始年月日（年）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziStartYear_PulldownList() {
        return drpID_HyoziStartYear_PulldownList;
    }

    /**
     * 表示開始年月日（年）プルダウンリストを設定します。
     *
     * @param drpID_HyoziStartYear_PulldownList 表示開始年月日（年）プルダウンリスト
     */
    public void setDrpID_HyoziStartYear_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziStartYear_PulldownList) {
        this.drpID_HyoziStartYear_PulldownList = drpID_HyoziStartYear_PulldownList;
    }

    /**
     * 表示開始年月日（月）プルダウンリストを取得します。
     *
     * @return 表示開始年月日（月）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziStartMonth_PulldownList() {
        return drpID_HyoziStartMonth_PulldownList;
    }

    /**
     * 表示開始年月日（月）プルダウンリストを設定します。
     *
     * @param drpID_HyoziStartMonth_PulldownList 表示開始年月日（月）プルダウンリスト
     */
    public void setDrpID_HyoziStartMonth_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziStartMonth_PulldownList) {
        this.drpID_HyoziStartMonth_PulldownList = drpID_HyoziStartMonth_PulldownList;
    }

    /**
     * 表示開始年月日（日）プルダウンリストを取得します。
     *
     * @return 表示開始年月日（日）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziStartDay_PulldownList() {
        return drpID_HyoziStartDay_PulldownList;
    }

    /**
     * 表示開始年月日（日）プルダウンリストを設定します。
     *
     * @param drpID_HyoziStartDay_PulldownList 表示開始年月日（日）プルダウンリスト
     */
    public void setDrpID_HyoziStartDay_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziStartDay_PulldownList) {
        this.drpID_HyoziStartDay_PulldownList = drpID_HyoziStartDay_PulldownList;
    }

    /**
     * 表示終了年月日（年）プルダウンリストを取得します。
     *
     * @return 表示終了年月日（年）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziEndYear_PulldownList() {
        return drpID_HyoziEndYear_PulldownList;
    }

    /**
     * 表示終了年月日（年）プルダウンリストを設定します。
     *
     * @param drpID_HyoziEndYear_PulldownList 表示終了年月日（年）プルダウンリスト
     */
    public void setDrpID_HyoziEndYear_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziEndYear_PulldownList) {
        this.drpID_HyoziEndYear_PulldownList = drpID_HyoziEndYear_PulldownList;
    }

    /**
     * 表示終了年月日（月）プルダウンリストを取得します。
     *
     * @return 表示終了年月日（月）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziEndMonth_PulldownList() {
        return drpID_HyoziEndMonth_PulldownList;
    }

    /**
     * 表示終了年月日（月）プルダウンリストを設定します。
     *
     * @param drpID_HyoziEndMonth_PulldownList 表示終了年月日（月）プルダウンリスト
     */
    public void setDrpID_HyoziEndMonth_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziEndMonth_PulldownList) {
        this.drpID_HyoziEndMonth_PulldownList = drpID_HyoziEndMonth_PulldownList;
    }

    /**
     * 表示終了年月日（日）プルダウンリストを取得します。
     *
     * @return 表示終了年月日（日）プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getDrpID_HyoziEndDay_PulldownList() {
        return drpID_HyoziEndDay_PulldownList;
    }

    /**
     * 表示終了年月日（日）プルダウンリストを設定します。
     *
     * @param drpID_HyoziEndDay_PulldownList 表示終了年月日（日）プルダウンリスト
     */
    public void setDrpID_HyoziEndDay_PulldownList(
            java.util.LinkedHashMap<String, String> drpID_HyoziEndDay_PulldownList) {
        this.drpID_HyoziEndDay_PulldownList = drpID_HyoziEndDay_PulldownList;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public List<Se016_01M1DTO> getMeisai_list() {
        return meisai_list;
    }

    /**
     * 明細リストを設定します。
     *
     * @param meisai_list 明細リスト
     */
    public void setMeisai_list(List<Se016_01M1DTO> meisai_list) {
        this.meisai_list = meisai_list;
    }

    /**
     * 検索結果該当件数を取得します。
     *
     * @return 検索結果該当件数
     */
    public int getSearchCount() {
        return searchCount;
    }

    /**
     * 検索結果該当件数を設定します。
     *
     * @param searchCount 検索結果該当件数
     */
    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    /**
     * 退避検索条件を取得します。
     *
     * @return 退避検索条件
     */
    public byte[] getBkSearchCondition() {
        return bkSearchCondition;
    }

    /**
     * 退避検索条件を設定します。
     *
     * @param bkSearchCondition 退避検索条件
     */
    public void setBkSearchCondition(byte[] bkSearchCondition) {
        this.bkSearchCondition = bkSearchCondition;
    }

    /**
     * 選択行番号を取得します。
     *
     * @return 選択行番号
     */
    public String getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * 選択行番号を設定します。
     *
     * @param selectedIndex 選択行番号
     */
    public void setSelectedIndex(String selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

}