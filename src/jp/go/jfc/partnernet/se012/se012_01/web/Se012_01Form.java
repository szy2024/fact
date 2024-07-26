//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import jp.go.jfc.partnernet.se012.se012_01.service.Se012_01M1DTO;

import java.util.List;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;
import jp.go.jfc.partnernet.se012.se012_01.service.Se012_01DTO;
import java.util.LinkedHashMap;

/**
 * <pre>
 * このクラスはse012_01のFormクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se012_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 業務委託手数料通知対象年月一覧 */
    private PNPagingTable<Se012_01M1DTO> se012_01M1Table = new PNPagingTableSerial<Se012_01M1DTO>("se012_01M1Table");
    // private PNPagingTable<Se012_01M1DTO> se012_01m1Table
    // = new PNPagingTableMemory<Se012_01M1DTO>("se012_01m1Table");

    /** エラー */
    private String lblerror;
    /** 検索扱店コード */
    private String txtid_srccode_organization;
    /** 検索店舗コード */
    private String txtid_srccode_tenpo;
    /** 未加盟店検索 */
    private Integer chkid_searchmikameiten;
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
    private List<Se012_01M1DTO> meisai_list;
    /** 検索結果該当件数 */
    private int searchcount;
    /** 退避検索条件 */
    private Se012_01DTO bksearchcondition;
    /** 選択行番号 */
    private String selectedindex;
    /** 店舗列非表示フラグ */
    private String flgdisplaynonetenpocol;

    /**
     * 業務委託手数料通知対象年月一覧を取得します。
     * @return 業務委託手数料通知対象年月一覧
     */
    public PNPagingTable<Se012_01M1DTO> getSe012_01M1Table() {
        return se012_01M1Table;
    }

    /**
     * 業務委託手数料通知対象年月一覧を設定します。
     * @param se012_01m1Table 業務委託手数料通知対象年月一覧
     */
    public void setSe012_01M1Table(PNPagingTable<Se012_01M1DTO> se012_01m1Table) {
        this.se012_01M1Table = se012_01m1Table;
    }

    /**
     * 業務委託手数料通知対象年月一覧テーブルレコードを取得します。
     * @return 業務委託手数料通知対象年月一覧テーブル
     */
    public List<Se012_01M1DTO> getSe012_01M1TableRecord() {
        return getSe012_01M1Table().getRecordList();
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
     * 検索店舗コードを取得します。
     * @return 検索店舗コード
     */
    public String getTxtid_srccode_tenpo() {
        return txtid_srccode_tenpo;
    }

    /**
     * 検索店舗コードを設定します。
     * @param txtid_srccode_tenpo 検索店舗コード
     */
    public void setTxtid_srccode_tenpo(String txtid_srccode_tenpo) {
        this.txtid_srccode_tenpo = txtid_srccode_tenpo;
    }

    /**
     * 未加盟店検索を取得します。
     * @return 未加盟店検索
     */
    public Integer getChkid_searchmikameiten() {
        return chkid_searchmikameiten;
    }

    /**
     * 未加盟店検索を設定します。
     * @param chkid_searchmikameiten 未加盟店検索
     */
    public void setChkid_searchmikameiten(Integer chkid_searchmikameiten) {
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
    public List<Se012_01M1DTO> getMeisai_list() {
        return meisai_list;
    }

    /**
     * 明細リストを設定します。
     * @param meisai_list 明細リスト
     */
    public void setMeisai_list(List<Se012_01M1DTO> meisai_list) {
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
    public Se012_01DTO getBksearchcondition() {
        return bksearchcondition;
    }

    /**
     * 退避検索条件を設定します。
     * @param bksearchcondition 退避検索条件
     */
    public void setBksearchcondition(Se012_01DTO bksearchcondition) {
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

    /**
     * 店舗列非表示フラグを取得します。
     * @return
     */
    public String getFlgunneededtenpo() {
        return flgdisplaynonetenpocol;
    }

    /**
     * 店舗列非表示フラグを設定します。
     * @param flgunneededtenpo
     */
    public void setFlgunneededtenpo(String flgunneededtenpo) {
        this.flgdisplaynonetenpocol = flgunneededtenpo;
    }

}