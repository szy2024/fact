//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_02.web;

import java.util.List;

import jp.go.jfc.partnernet.cr008.cr008_02.service.Cr008_02M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはCr008_02のFormクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 顧客名一覧 */
    private PNPagingTable<Cr008_02M1DTO> Cr008_02M1Table = new PNPagingTableSerial<Cr008_02M1DTO>(
            "Cr008_02M1Table");
    // private PNPagingTable<Cr008_02M1DTO> Cr008_02M1Table
    // = new PNPagingTableMemory<Cr008_02M1DTO>("Cr008_02M1Table");

    /** ステータス */
    private String lblError;
    /** 顧客名（ヘッダ） */
    private String lblSearchCustomer;
    /** 全件数 */
    private int ID_AllCount;
    /** 明細リスト1 */
    private List<Cr008_02M1DTO> MEISAI_LIST1;
    /** ログインユーザ扱店コード */
    private String Cr008_02_Code_Organizaion;
    /** 選択行番号 */
    private String selectedIndex;

    /**
     * 顧客名一覧を取得します。
     * @return 顧客名一覧
     */
    public PNPagingTable<Cr008_02M1DTO> getCr008_02M1Table() {
        return Cr008_02M1Table;
    }

    /**
     * 顧客名一覧を設定します。
     * @param Cr008_02M1Table 顧客名一覧
     */
    public void setCr008_02M1Table(PNPagingTable<Cr008_02M1DTO> Cr008_02M1Table) {
        this.Cr008_02M1Table = Cr008_02M1Table;
    }

    /**
     * 顧客名一覧テーブルレコードを取得します。
     * @return 顧客名一覧テーブル
     */
    public List<Cr008_02M1DTO> getCr008_02M1TableRecord() {
        return getCr008_02M1Table().getRecordList();
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 顧客名（ヘッダ）を取得します。
     * @return 顧客名（ヘッダ）
     */
    public String getLblSearchCustomer() {
        return lblSearchCustomer;
    }

    /**
     * 顧客名（ヘッダ）を設定します。
     * @param lblSearchCustomer 顧客名（ヘッダ）
     */
    public void setLblSearchCustomer(String lblSearchCustomer) {
        this.lblSearchCustomer = lblSearchCustomer;
    }

    /**
     * 全件数を取得します。
     * @return 全件数
     */
    public int getID_AllCount() {
        return ID_AllCount;
    }

    /**
     * 全件数を設定します。
     * @param ID_AllCount 全件数
     */
    public void setID_AllCount(int ID_AllCount) {
        this.ID_AllCount = ID_AllCount;
    }

    /**
     * 明細リスト1を取得します。
     * @return 明細リスト1
     */
    public List<Cr008_02M1DTO> getMEISAI_LIST1() {
        return MEISAI_LIST1;
    }

    /**
     * 明細リスト1を設定します。
     * @param MEISAI_LIST1 明細リスト1
     */
    public void setMEISAI_LIST1(List<Cr008_02M1DTO> MEISAI_LIST1) {
        this.MEISAI_LIST1 = MEISAI_LIST1;
    }

    /**
     * ログインユーザ扱店コードを取得します。
     * @return ログインユーザ扱店コード
     */
    public String getCr008_02_Code_Organizaion() {
        return Cr008_02_Code_Organizaion;
    }

    /**
     * ログインユーザ扱店コードを設定します。
     * @param Cr008_02_Code_Organizaion ログインユーザ扱店コード
     */
    public void setCr008_02_Code_Organizaion(String Cr008_02_Code_Organizaion) {
        this.Cr008_02_Code_Organizaion = Cr008_02_Code_Organizaion;
    }

    /**
     * <pre>
     * 選択行番号を取得します。
     * </pre>
     *
     * @return 選択行番号
     */
    public String getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * <pre>
     * 選択行番号を設定します。
     * </pre>
     *
     * @param selectedIndex 選択行番号
     */
    public void setSelectedIndex(String selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

}