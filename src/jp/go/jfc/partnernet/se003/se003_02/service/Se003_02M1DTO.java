//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.service;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe003_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 払出日 */
    private String ID_Date_HaraidashiJuto;
    /** 区分 */
    private String ID_Kubun_Haraidashi;
    /** 払出額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Haraidashi;
    /** 払出累計額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_HaraidashiRuikei;
    /** 繰償額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Kurisho;
    /** 繰償累計額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KurishoRuikei;
    /** 受入金残高 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KashitsukeukeireZan;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se003_02M1DTO() {
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
    public Se003_02M1DTO(Se003_02M1DTO orig) {
        super(orig);
    }

    /**
     * 払出日を取得します。
     * @return 払出日
     */
    public String getID_Date_HaraidashiJuto() {
        return ID_Date_HaraidashiJuto;
    }

    /**
     * 払出日を設定します。
     * @param ID_Date_HaraidashiJuto 払出日
     */
    public void setID_Date_HaraidashiJuto(String ID_Date_HaraidashiJuto) {
        this.ID_Date_HaraidashiJuto = ID_Date_HaraidashiJuto;
    }

    /**
     * 区分を取得します。
     * @return 区分
     */
    public String getID_Kubun_Haraidashi() {
        return ID_Kubun_Haraidashi;
    }

    /**
     * 区分を設定します。
     * @param ID_Kubun_Haraidashi 区分
     */
    public void setID_Kubun_Haraidashi(String ID_Kubun_Haraidashi) {
        this.ID_Kubun_Haraidashi = ID_Kubun_Haraidashi;
    }

    /**
     * 払出額を取得します。
     * @return 払出額
     */
    public java.math.BigDecimal getID_M_Haraidashi() {
        return ID_M_Haraidashi;
    }

    /**
     * 払出額を設定します。
     * @param ID_M_Haraidashi 払出額
     */
    public void setID_M_Haraidashi(java.math.BigDecimal ID_M_Haraidashi) {
        this.ID_M_Haraidashi = ID_M_Haraidashi;
    }

    /**
     * 払出累計額を取得します。
     * @return 払出累計額
     */
    public java.math.BigDecimal getID_M_HaraidashiRuikei() {
        return ID_M_HaraidashiRuikei;
    }

    /**
     * 払出累計額を設定します。
     * @param ID_M_HaraidashiRuik 払出累計額
     */
    public void setID_M_HaraidashiRuikei(java.math.BigDecimal ID_M_HaraidashiRuikei) {
        this.ID_M_HaraidashiRuikei = ID_M_HaraidashiRuikei;
    }

    /**
     * 繰償額を取得します。
     * @return 繰償額
     */
    public java.math.BigDecimal getID_M_Kurisho() {
        return ID_M_Kurisho;
    }

    /**
     * 繰償額を設定します。
     * @param ID_M_Kurisho 繰償額
     */
    public void setID_M_Kurisho(java.math.BigDecimal ID_M_Kurisho) {
        this.ID_M_Kurisho = ID_M_Kurisho;
    }

    /**
     * 繰償累計額を取得します。
     * @return 繰償累計額
     */
    public java.math.BigDecimal getID_M_KurishoRuikei() {
        return ID_M_KurishoRuikei;
    }

    /**
     * 繰償累計額を設定します。
     * @param ID_M_KurishoRuike 繰償累計額
     */
    public void setID_M_KurishoRuikei(java.math.BigDecimal ID_M_KurishoRuikei) {
        this.ID_M_KurishoRuikei = ID_M_KurishoRuikei;
    }

    /**
     * 受入金残高を取得します。
     * @return 受入金残高
     */
    public java.math.BigDecimal getID_M_KashitsukeukeireZan() {
        return ID_M_KashitsukeukeireZan;
    }

    /**
     * 受入金残高を設定します。
     * @param ID_M_KashitsukeukeireZan 受入金残高
     */
    public void setID_M_KashitsukeukeireZan(java.math.BigDecimal ID_M_KashitsukeukeireZan) {
        this.ID_M_KashitsukeukeireZan = ID_M_KashitsukeukeireZan;
    }

}