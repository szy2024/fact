//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : se013_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.service;

import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse013_01のDTOクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se013_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラー */
    private String lblerror;
    /** 検索扱店コード */
    private String txtid_srccode_organization;
    /** 未加盟店検索 */
    private String chkid_searchmikameiten;
    /** 検索開始年月（年） */
    private String drpid_searchstartym_year;
    /** 検索開始年月（月） */
    private String drpid_searchstartym_month;
    /** 検索終了年月（年） */
    private String drpid_searchendym_year;
    /** 検索終了年月（月） */
    private String drpid_searchendym_month;
    /** 検索開始年月（年）プルダウンリスト */
    private LinkedHashMap<String, Object> ym_searchstart_year_pulldown_list;
    /** 検索開始年月（月）プルダウンリスト */
    private LinkedHashMap<String, Object> ym_searchstart_month_pulldown_list;
    /** 検索終了年月（年）プルダウンリスト */
    private LinkedHashMap<String, Object> ym_searchend_year_pulldown_list;
    /** 検索終了年月（月）プルダウンリスト */
    private LinkedHashMap<String, Object> ym_searchend_month_pulldown_list;
    /** 明細リスト */
    private List<Se013_01M1DTO> meisai_list = new java.util.ArrayList(0);
    /** 検索結果該当件数 */
    private int searchcount;
    /** 退避検索条件 */
    private byte[] bksearchcondition;
    /** 選択行番号 */
    private String selectedindex;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se013_01DTO() {
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
    public Se013_01DTO(Se013_01DTO orig) {
        super(orig);
    }

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblerror() {
        return lblerror;
    }

    /**
     * エラーを設定します。
     * @param lblerror エラー
     */
    public void setLblerror(String lblerror) {
        this.lblerror = lblerror;
    }

    /**
     * 検索扱店コードを取得します。
     * @return 検索扱店コード
     */
    public String getTxtid_srccode_organization() {
        return txtid_srccode_organization;
    }

    /**
     * 検索扱店コードを設定します。
     * @param txtid_srccode_organization 検索扱店コード
     */
    public void setTxtid_srccode_organization(String txtid_srccode_organization) {
        this.txtid_srccode_organization = txtid_srccode_organization;
    }

    /**
     * 未加盟店検索を取得します。
     * @return 未加盟店検索
     */
    public String getChkid_searchmikameiten() {
        return chkid_searchmikameiten;
    }

    /**
     * 未加盟店検索を設定します。
     * @param chkid_searchmikameiten 未加盟店検索
     */
    public void setChkid_searchmikameiten(String chkid_searchmikameiten) {
        this.chkid_searchmikameiten = chkid_searchmikameiten;
    }

    /**
     * 検索開始年月（年）を取得します。
     * @return 検索開始年月（年）
     */
    public String getDrpid_searchstartym_year() {
        return drpid_searchstartym_year;
    }

    /**
     * 検索開始年月（年）を設定します。
     * @param drpid_searchstartym_year 検索開始年月（年）
     */
    public void setDrpid_searchstartym_year(String drpid_searchstartym_year) {
        this.drpid_searchstartym_year = drpid_searchstartym_year;
    }

    /**
     * 検索開始年月（月）を取得します。
     * @return 検索開始年月（月）
     */
    public String getDrpid_searchstartym_month() {
        return drpid_searchstartym_month;
    }

    /**
     * 検索開始年月（月）を設定します。
     * @param drpid_searchstartym_month 検索開始年月（月）
     */
    public void setDrpid_searchstartym_month(String drpid_searchstartym_month) {
        this.drpid_searchstartym_month = drpid_searchstartym_month;
    }

    /**
     * 検索終了年月（年）を取得します。
     * @return 検索終了年月（年）
     */
    public String getDrpid_searchendym_year() {
        return drpid_searchendym_year;
    }

    /**
     * 検索終了年月（年）を設定します。
     * @param drpid_searchendym_year 検索終了年月（年）
     */
    public void setDrpid_searchendym_year(String drpid_searchendym_year) {
        this.drpid_searchendym_year = drpid_searchendym_year;
    }

    /**
     * 検索終了年月（月）を取得します。
     * @return 検索終了年月（月）
     */
    public String getDrpid_searchendym_month() {
        return drpid_searchendym_month;
    }

    /**
     * 検索終了年月（月）を設定します。
     * @param drpid_searchendym_month 検索終了年月（月）
     */
    public void setDrpid_searchendym_month(String drpid_searchendym_month) {
        this.drpid_searchendym_month = drpid_searchendym_month;
    }

    /**
     * 検索開始年月（年）プルダウンリストを取得します。
     * @return 検索開始年月（年）プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYm_searchstart_year_pulldown_list() {
        return ym_searchstart_year_pulldown_list;
    }

    /**
     * 検索開始年月（年）プルダウンリストを設定します。
     * @param ym_searchstart_year_pulldown_list 検索開始年月（年）プルダウンリスト
     */
    public void setYm_searchstart_year_pulldown_list(LinkedHashMap<String, Object> ym_searchstart_year_pulldown_list) {
        this.ym_searchstart_year_pulldown_list = ym_searchstart_year_pulldown_list;
    }

    /**
     * 検索開始年月（月）プルダウンリストを取得します。
     * @return 検索開始年月（月）プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYm_searchstart_month_pulldown_list() {
        return ym_searchstart_month_pulldown_list;
    }

    /**
     * 検索開始年月（月）プルダウンリストを設定します。
     * @param ym_searchstart_month_pulldown_list 検索開始年月（月）プルダウンリスト
     */
    public void setYm_searchstart_month_pulldown_list(
            LinkedHashMap<String, Object> ym_searchstart_month_pulldown_list) {
        this.ym_searchstart_month_pulldown_list = ym_searchstart_month_pulldown_list;
    }

    /**
     * 検索終了年月（年）プルダウンリストを取得します。
     * @return 検索終了年月（年）プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYm_searchend_year_pulldown_list() {
        return ym_searchend_year_pulldown_list;
    }

    /**
     * 検索終了年月（年）プルダウンリストを設定します。
     * @param ym_searchend_year_pulldown_list 検索終了年月（年）プルダウンリスト
     */
    public void setYm_searchend_year_pulldown_list(LinkedHashMap<String, Object> ym_searchend_year_pulldown_list) {
        this.ym_searchend_year_pulldown_list = ym_searchend_year_pulldown_list;
    }

    /**
     * 検索終了年月（月）プルダウンリストを取得します。
     * @return 検索終了年月（月）プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYm_searchend_month_pulldown_list() {
        return ym_searchend_month_pulldown_list;
    }

    /**
     * 検索終了年月（月）プルダウンリストを設定します。
     * @param ym_searchend_month_pulldown_list 検索終了年月（月）プルダウンリスト
     */
    public void setYm_searchend_month_pulldown_list(LinkedHashMap<String, Object> ym_searchend_month_pulldown_list) {
        this.ym_searchend_month_pulldown_list = ym_searchend_month_pulldown_list;
    }

    /**
     * 明細リストを取得します。
     * @return 明細リスト
     */
    public List<Se013_01M1DTO> getMeisai_list() {
        return meisai_list;
    }

    /**
     * 明細リストを設定します。
     * @param meisai_list 明細リスト
     */
    public void setMeisai_list(List<Se013_01M1DTO> meisai_list) {
        this.meisai_list = meisai_list;
    }

    /**
     * 検索結果該当件数を取得します。
     * @return 検索結果該当件数
     */
    public int getSearchcount() {
        return searchcount;
    }

    /**
     * 検索結果該当件数を設定します。
     * @param searchcount 検索結果該当件数
     */
    public void setSearchcount(int searchcount) {
        this.searchcount = searchcount;
    }

    /**
     * 退避検索条件を取得します。
     * @return 退避検索条件
     */
    public byte[] getBksearchcondition() {
        return bksearchcondition;
    }

    /**
     * 退避検索条件を設定します。
     * @param bksearchcondition 退避検索条件
     */
    public void setBksearchcondition(byte[] bksearchcondition) {
        this.bksearchcondition = bksearchcondition;
    }

    /**
     * 選択行番号を取得します。
     * @return 選択行番号
     */
    public String getSelectedindex() {
        return selectedindex;
    }

    /**
     * 選択行番号を設定します。
     * @param selectedindex 選択行番号
     */
    public void setSelectedindex(String selectedindex) {
        this.selectedindex = selectedindex;
    }

}