//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_03DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_03.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr008_03のDTOクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_03DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ステータス */
    private String lblError;
    /** 顧客名（ヘッダ） */
    private String lblSearchCustomer;
    /** 住所（ヘッダ） */
    private String lblSearchAddr;
    /** 顧客名入力値 */
    private String Cr008_03_In_Name_Customer;
    /** 貸付先コード入力値 */
    private String Cr008_03_In_Code_Customer;
    /** 扱店コード入力値 */
    private String Cr008_03_In_Code_Organization;
    /** 明細リスト1 */
    private List<Cr008_03M1DTO> MEISAI_LIST1;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr008_03DTO() {
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
    public Cr008_03DTO(Cr008_03DTO orig) {
        super(orig);
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
     * 住所（ヘッダ）を取得します。
     * @return 住所（ヘッダ）
     */
    public String getLblSearchAddr() {
        return lblSearchAddr;
    }

    /**
     * 住所（ヘッダ）を設定します。
     * @param lblSearchAddr 住所（ヘッダ）
     */
    public void setLblSearchAddr(String lblSearchAddr) {
        this.lblSearchAddr = lblSearchAddr;
    }

    /**
     * 顧客名入力値を取得します。
     * @return 顧客名入力値
     */
    public String getCr008_03_In_Name_Customer() {
        return Cr008_03_In_Name_Customer;
    }

    /**
     * 顧客名入力値を設定します。
     * @param Cr008_03_In_Name_Customer 顧客名入力値
     */
    public void setCr008_03_In_Name_Customer(String Cr008_03_In_Name_Customer) {
        this.Cr008_03_In_Name_Customer = Cr008_03_In_Name_Customer;
    }

    /**
     * 貸付先コード入力値を取得します。
     * @return 貸付先コード入力値
     */
    public String getCr008_03_In_Code_Customer() {
        return Cr008_03_In_Code_Customer;
    }

    /**
     * 貸付先コード入力値を設定します。
     * @param Cr008_03_In_Code_Customer 貸付先コード入力値
     */
    public void setCr008_03_In_Code_Customer(String Cr008_03_In_Code_Customer) {
        this.Cr008_03_In_Code_Customer = Cr008_03_In_Code_Customer;
    }

    /**
     * 扱店コード入力値を取得します。
     * @return 扱店コード入力値
     */
    public String getCr008_03_In_Code_Organization() {
        return Cr008_03_In_Code_Organization;
    }

    /**
     * 扱店コード入力値を設定します。
     * @param Cr008_03_In_Code_Organization 扱店コード入力値
     */
    public void setCr008_03_In_Code_Organization(String Cr008_03_In_Code_Organization) {
        this.Cr008_03_In_Code_Organization = Cr008_03_In_Code_Organization;
    }

    /**
     * 明細リスト1を取得します。
     * @return 明細リスト1
     */
    public List<Cr008_03M1DTO> getMEISAI_LIST1() {
        return MEISAI_LIST1;
    }

    /**
     * 明細リスト1を設定します。
     * @param MEISAI_LIST1 明細リスト1
     */
    public void setMEISAI_LIST1(List<Cr008_03M1DTO> MEISAI_LIST1) {
        this.MEISAI_LIST1 = MEISAI_LIST1;
    }

}