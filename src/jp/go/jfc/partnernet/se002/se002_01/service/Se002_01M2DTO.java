//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se002_01M2DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se002.se002_01.service;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe002_01のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se002_01M2DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 払出未了_顧客名 */
    private String ID_Name_Customer;
    /** 払出未了_公庫支店 */
    private String ID_Name_KoukoShiten;
    /** 払出未了_扱店 */
    private String ID_Code_Organization;
    /** 払出未了_店舗 */
    private String ID_Code_Tenpo;
    /** 払出未了_年度 */
    private String ID_Year;
    /** 払出未了_方式資金 */
    private String ID_Kubun_Hoshiki;
    /** 払出未了_資金 */
    private String ID_Kubun_Shikin;
    /** 払出未了_番号 */
    private String ID_ID_Ringi;
    /** 払出未了_枝番 */
    private String ID_ID_RingiBranch;
    /** 払出未了_貸付決定日 */
    private String ID_Date_JuriKetteikisan;
    /** 払出未了_貸付決定額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Kettei;
    /** 払出未了_貸付実行日 */
    private String ID_Date_Jikko;
    /** 払出未了_貸付実行額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Kashitsuke;
    /** 払出未了_資金払出未了額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KashitsukeukeireZan;
    /** 払出未了_貸付実行期限 */
    private String ID_Date_JikkoKigen;
    /** 払出未了_資金払出期限 */
    private String ID_Shinko_Kanri_Date_Jikko;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se002_01M2DTO() {
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
    public Se002_01M2DTO(Se002_01M2DTO orig) {
        super(orig);
    }

    /**
     * 払出未了_顧客名を取得します。
     * @return 払出未了_顧客名
     */
    public String getID_Name_Customer() {
        return ID_Name_Customer;
    }

    /**
     * 払出未了_顧客名を設定します。
     * @param ID_Name_Customer 払出未了_顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        this.ID_Name_Customer = ID_Name_Customer;
    }

    /**
     * 払出未了_公庫支店を取得します。
     * @return 払出未了_公庫支店
     */
    public String getID_Name_KoukoShiten() {
        return ID_Name_KoukoShiten;
    }

    /**
     * 払出未了_公庫支店を設定します。
     * @param ID_Name_KoukoShiten 払出未了_公庫支店
     */
    public void setID_Name_KoukoShiten(String ID_Name_KoukoShiten) {
        this.ID_Name_KoukoShiten = ID_Name_KoukoShiten;
    }

    /**
     * 払出未了_扱店を取得します。
     * @return 払出未了_扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 払出未了_扱店を設定します。
     * @param ID_Code_Organization 払出未了_扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 払出未了_店舗を取得します。
     * @return 払出未了_店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 払出未了_店舗を設定します。
     * @param ID_Code_Tenpo 払出未了_店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 払出未了_年度を取得します。
     * @return 払出未了_年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 払出未了_年度を設定します。
     * @param ID_Year 払出未了_年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 払出未了_方式資金を取得します。
     * @return 払出未了_方式資金
     */
    public String getID_Kubun_Hoshiki() {
        return ID_Kubun_Hoshiki;
    }

    /**
     * 払出未了_方式資金を設定します。
     * @param ID_Kubun_Hoshiki 払出未了_方式資金
     */
    public void setID_Kubun_Hoshiki(String ID_Kubun_Hoshiki) {
        this.ID_Kubun_Hoshiki = ID_Kubun_Hoshiki;
    }

    /**
     * 払出未了_資金を取得します。
     * @return 払出未了_資金
     */
    public String getID_Kubun_Shikin() {
        return ID_Kubun_Shikin;
    }

    /**
     * 払出未了_資金を設定します。
     * @param ID_Kubun_Shikin 払出未了_資金
     */
    public void setID_Kubun_Shikin(String ID_Kubun_Shikin) {
        this.ID_Kubun_Shikin = ID_Kubun_Shikin;
    }

    /**
     * 払出未了_番号を取得します。
     * @return 払出未了_番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 払出未了_番号を設定します。
     * @param ID_ID_Ringi 払出未了_番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 払出未了_枝番を取得します。
     * @return 払出未了_枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 払出未了_枝番を設定します。
     * @param ID_ID_RingiBranch 払出未了_枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 払出未了_貸付決定日を取得します。
     * @return 払出未了_貸付決定日
     */
    public String getID_Date_JuriKetteikisan() {
        return ID_Date_JuriKetteikisan;
    }

    /**
     * 払出未了_貸付決定日を設定します。
     * @param ID_Date_JuriKetteikisan 払出未了_貸付決定日
     */
    public void setID_Date_JuriKetteikisan(String ID_Date_JuriKetteikisan) {
        this.ID_Date_JuriKetteikisan = ID_Date_JuriKetteikisan;
    }

    /**
     * 払出未了_貸付決定額を取得します。
     * @return 払出未了_貸付決定額
     */
    public java.math.BigDecimal getID_M_Kettei() {
        return ID_M_Kettei;
    }

    /**
     * 払出未了_貸付決定額を設定します。
     * @param ID_M_Kettei 払出未了_貸付決定額
     */
    public void setID_M_Kettei(java.math.BigDecimal ID_M_Kettei) {
        this.ID_M_Kettei = ID_M_Kettei;
    }

    /**
     * 払出未了_貸付実行日を取得します。
     * @return 払出未了_貸付実行日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 払出未了_貸付実行日を設定します。
     * @param ID_Date_Jikko 払出未了_貸付実行日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 払出未了_貸付実行額を取得します。
     * @return 払出未了_貸付実行額
     */
    public java.math.BigDecimal getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 払出未了_貸付実行額を設定します。
     * @param ID_M_Kashitsuke 払出未了_貸付実行額
     */
    public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 払出未了_資金払出未了額を取得します。
     * @return 払出未了_資金払出未了額
     */
    public java.math.BigDecimal getID_M_KashitsukeukeireZan() {
        return ID_M_KashitsukeukeireZan;
    }

    /**
     * 払出未了_資金払出未了額を設定します。
     * @param ID_M_KashitsukeukeireZan 払出未了_資金払出未了額
     */
    public void setID_M_KashitsukeukeireZan(java.math.BigDecimal ID_M_KashitsukeukeireZan) {
        this.ID_M_KashitsukeukeireZan = ID_M_KashitsukeukeireZan;
    }

    /**
     * 払出未了_貸付実行期限を取得します。
     * @return 払出未了_貸付実行期限
     */
    public String getID_Date_JikkoKigen() {
        return ID_Date_JikkoKigen;
    }

    /**
     * 払出未了_貸付実行期限を設定します。
     * @param ID_Date_JikkoKigen 払出未了_貸付実行期限
     */
    public void setID_Date_JikkoKigen(String ID_Date_JikkoKigen) {
        this.ID_Date_JikkoKigen = ID_Date_JikkoKigen;
    }

    /**
     * 払出未了_資金払出期限を取得します。
     * @return 払出未了_資金払出期限
     */
    public String getID_Shinko_Kanri_Date_Jikko() {
        return ID_Shinko_Kanri_Date_Jikko;
    }

    /**
     * 払出未了_資金払出期限を設定します。
     * @param ID_Shinko_Kanri_Date_Jikko 払出未了_資金払出期限
     */
    public void setID_Shinko_Kanri_Date_Jikko(String ID_Shinko_Kanri_Date_Jikko) {
        this.ID_Shinko_Kanri_Date_Jikko = ID_Shinko_Kanri_Date_Jikko;
    }

}