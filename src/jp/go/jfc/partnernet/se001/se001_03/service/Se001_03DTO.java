//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.service;

import java.util.List;
import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe001_03のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se001_03DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 顧客名称 */
    private String lblID_Name_Customer;
    /** 住所１ */
    private String lblCustomerAddress1;
    /** 住所２ */
    private String lblCustomerAddress2;
    /** 住所３ */
    private String lblCustomerAddress3;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** メッセージ */
    private String lblError;
    /** 扱店コード選択値 */
    private String Se001_03_In_Code_Organization;
    /** 貸付先コード選択値 */
    private String Se001_03_In_Code_Customer;
    /** 案件情報 */
    private List<Se001_03M1DTO> MEISAI_AnkenLIST;
    /** 延滞情報 */
    private List<Se001_03M2DTO> MEISAI_EntaiLIST;

    /** ステータス */
    private String lblStatus;

    /** 全件数 */
    private int ID_AllCount;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se001_03DTO() {
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
    public Se001_03DTO(Se001_03DTO orig) {
        super(orig);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblStatus() {
        return lblStatus;
    }

    /**
     * ステータスを設定します。
     * @param String ステータス情報
     */
    public void setLblStatus(String lblStatus) {
        this.lblStatus = lblStatus;
    }

    /**
     * 顧客名称を取得します。
     * @return 顧客名称
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名称を設定します。
     * @param lblID_Name_Customer 顧客名称
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 住所１を取得します。
     * @return 住所１
     */
    public String getLblCustomerAddress1() {
        return lblCustomerAddress1;
    }

    /**
     * 住所１を設定します。
     * @param lblCustomerAddress1 住所１
     */
    public void setLblCustomerAddress1(String lblCustomerAddress1) {
        this.lblCustomerAddress1 = lblCustomerAddress1;
    }

    /**
     * 住所２を取得します。
     * @return 住所２
     */
    public String getLblCustomerAddress2() {
        return lblCustomerAddress2;
    }

    /**
     * 住所２を設定します。
     * @param lblCustomerAddress2 住所２
     */
    public void setLblCustomerAddress2(String lblCustomerAddress2) {
        this.lblCustomerAddress2 = lblCustomerAddress2;
    }

    /**
     * 住所３を取得します。
     * @return 住所３
     */
    public String getLblCustomerAddress3() {
        return lblCustomerAddress3;
    }

    /**
     * 住所３を設定します。
     * @param lblCustomerAddress3 住所３
     */
    public void setLblCustomerAddress3(String lblCustomerAddress3) {
        this.lblCustomerAddress3 = lblCustomerAddress3;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * メッセージを設定します。
     * @param lblError メッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
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
     * 案件情報を取得します。
     * @return 案件情報
     */
    public List<Se001_03M1DTO> getMEISAI_AnkenLIST() {
        return MEISAI_AnkenLIST;
    }

    /**
     * 案件情報を設定します。
     * @param MEISAI_AnkenLIST 案件情報
     */
    public void setMEISAI_AnkenLIST(List<Se001_03M1DTO> MEISAI_AnkenLIST) {
        this.MEISAI_AnkenLIST = MEISAI_AnkenLIST;
    }

    /**
     * 延滞情報を取得します。
     * @return 延滞情報
     */
    public List<Se001_03M2DTO> getMEISAI_EntaiLIST() {
        return MEISAI_EntaiLIST;
    }

    /**
     * 延滞情報を設定します。
     * @param MEISAI_EntaiLIST 延滞情報
     */
    public void setMEISAI_EntaiLIST(List<Se001_03M2DTO> MEISAI_EntaiLIST) {
        this.MEISAI_EntaiLIST = MEISAI_EntaiLIST;
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

}