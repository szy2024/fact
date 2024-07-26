//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_02.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr005_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 顧客名（ヘッダ） */
    private String lblSearchCustomer;
    /** 顧客名入力値 */
    private String Cr005_02_In_Name_Customer;
    /** 全件数 */
    private int ID_AllCount;
    /** 明細リスト1 */
    // private java.util.List MEISAI_LIST1 = new java.util.ArrayList(0);
    private List<Cr005_02M1DTO> MEISAI_LIST1;
    /** ログインユーザ扱店コード */
    private String Cr005_02_Code_Organizaion;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr005_02DTO() {
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
    public Cr005_02DTO(Cr005_02DTO orig) {
        super(orig);
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
     * 顧客名入力値を取得します。
     * @return 顧客名入力値
     */
    public String getCr005_02_In_Name_Customer() {
        return Cr005_02_In_Name_Customer;
    }

    /**
     * 顧客名入力値を設定します。
     * @param Cr005_02_In_Name_Customer 顧客名入力値
     */
    public void setCr005_02_In_Name_Customer(String Cr005_02_In_Name_Customer) {
        this.Cr005_02_In_Name_Customer = Cr005_02_In_Name_Customer;
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
    public List<Cr005_02M1DTO> getMEISAI_LIST1() {
        return MEISAI_LIST1;
    }

    /**
     * 明細リスト1を設定します。
     * @param MEISAI_LIST1 明細リスト1
     */
    public void setMEISAI_LIST1(List<Cr005_02M1DTO> MEISAI_LIST1) {
        this.MEISAI_LIST1 = MEISAI_LIST1;
    }

    /**
     * ログインユーザ扱店コードを取得します。
     * @return ログインユーザ扱店コード
     */
    public String getCr005_02_Code_Organizaion() {
        return Cr005_02_Code_Organizaion;
    }

    /**
     * ログインユーザ扱店コードを設定します。
     * @param Cr005_02_Code_Organizaion ログインユーザ扱店コード
     */
    public void setCr005_02_Code_Organizaion(String Cr005_02_Code_Organizaion) {
        this.Cr005_02_Code_Organizaion = Cr005_02_Code_Organizaion;
    }

}