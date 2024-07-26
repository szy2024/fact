//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_02form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_02.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.se001.se001_02.service.Se001_02M1DTO;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;
import jp.go.jfc.partnernet.se001.se001_02.service.Se001_02DTO;

/**
 * <pre>
 * このクラスはse001_02のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se001_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 明細リスト1 */
    private PNPagingTable<Se001_02M1DTO> se001_02M1Table = new PNPagingTableSerial<Se001_02M1DTO>(
            "se001_02M1Table");

    private Se001_02DTO bkSearchCondition = null;

    /** 検索数保持 */
    private int searchCount;
    /** 顧客名称 */
    private String lblSearchCustomer;
    /** 顧客名入力値 */
    private String Se001_02_In_Name_Customer;
    /** 顧客名選択値 */
    private String Se001_03_In_Name_Customer;
    /** 扱店コード選択値 */
    private String Se001_03_In_Code_Organization;
    /** 貸付先コード選択値 */
    private String Se001_03_In_Code_Customer;
    /** リンクNo */
    private String Link_No;

    /**
     * 明細を取得します。
     * @return 明細
     */
    public PNPagingTable<Se001_02M1DTO> getSe001_02M1Table() {
        return se001_02M1Table;
    }

    /**
     * 明細を設定します。
     * @param se001_02M1Table 明細
     */
    public void setSe001_02M1Table(PNPagingTable<Se001_02M1DTO> se001_02M1Table) {
        this.se001_02M1Table = se001_02M1Table;
    }

    /**
     * 明細テーブルレコードを取得します。
     * @return 明細テーブル
     */
    public List<Se001_02M1DTO> getSe001_02M1TableRecord() {
        return getSe001_02M1Table().getRecordList();
    }

    /**
     * 顧客名称を取得します。
     * @return 顧客名称
     */
    public String getLblSearchCustomer() {
        return lblSearchCustomer;
    }

    /**
     * 顧客名称を設定します。
     * @param lblSearchCustomer 顧客名称
     */
    public void setLblSearchCustomer(String lblSearchCustomer) {
        this.lblSearchCustomer = lblSearchCustomer;
    }

    /**
     * 顧客名入力値を取得します。
     * @return 顧客名入力値
     */
    public String getSe001_02_In_Name_Customer() {
        return Se001_02_In_Name_Customer;
    }

    /**
     * 顧客名入力値を設定します。
     * @param Se001_02_In_Name_Customer 顧客名入力値
     */
    public void setSe001_02_In_Name_Customer(String Se001_02_In_Name_Customer) {
        this.Se001_02_In_Name_Customer = Se001_02_In_Name_Customer;
    }

    /**
     * 顧客名選択値を取得します。
     * @return 顧客名選択値
     */
    public String getSe001_03_In_Name_Customer() {
        return Se001_03_In_Name_Customer;
    }

    /**
     * 顧客名選択値を設定します。
     * @param Se001_03_In_Name_Customer 顧客名選択値
     */
    public void setSe001_03_In_Name_Customer(String Se001_03_In_Name_Customer) {
        this.Se001_03_In_Name_Customer = Se001_03_In_Name_Customer;
    }

    /**
     * 扱店コード選択値を取得します。
     * @return 扱店コード選択値
     */
    public String getSe001_03_In_Code_Organization() {
        return Se001_03_In_Code_Organization;
    }

    /**
     * 扱店コード選択値を設定します。
     * @param Se001_03_In_Code_Organization 扱店コード選択値
     */
    public void setSe001_03_In_Code_Organization(String Se001_03_In_Code_Organization) {
        this.Se001_03_In_Code_Organization = Se001_03_In_Code_Organization;
    }

    /**
     * 貸付先コード選択値を取得します。
     * @return 貸付先コード選択値
     */
    public String getSe001_03_In_Code_Customer() {
        return Se001_03_In_Code_Customer;
    }

    /**
     * 貸付先コード選択値を設定します。
     * @param Se001_03_In_Code_Customer 貸付先コード選択値
     */
    public void setSe001_03_In_Code_Customer(String Se001_03_In_Code_Customer) {
        this.Se001_03_In_Code_Customer = Se001_03_In_Code_Customer;
    }

    /**
     * 退避検索条件を取得します。
     * @return 退避検索条件
     */
    public Se001_02DTO getBkSearchCondition() {
        return bkSearchCondition;
    }

    /**
     * 退避検索条件を設定します。
     * @param bkSearchCondition 退避検索条件
     */
    public void setBkSearchCondition(Se001_02DTO bkSearchCondition) {
        this.bkSearchCondition = bkSearchCondition;
    }

    /**
     * 検索数を取得します。
     * @return 検索数
     */
    public int getSearchCount() {
        return searchCount;
    }

    /**
     * 検索数を設定します。
     * @param searchCount 検索数
     */
    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    /**
     * リンクNoを取得します。
     * @return リンクNo
     */
    public String getLinkno() {
        return Link_No;
    }

    /**
     * リンクNoを設定します。
     * @param linkno リンクNo
     */
    public void setLinkno(String Link_No) {
        this.Link_No = Link_No;
    }

}