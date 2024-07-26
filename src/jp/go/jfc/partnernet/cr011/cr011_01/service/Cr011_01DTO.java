//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : cr011_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr011_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr011_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 指定交付日（年） */
    private String drpID_ShiteiKofuYear;
    /** 指定交付日（月） */
    private String drpID_ShiteiKofuMonth;
    /** 指定交付日（日） */
    private String drpID_ShiteiKofuDate;
    /** 明細リスト */
    private java.util.List<Cr011_01M1DTO> MEISAI_LIST = new java.util.ArrayList<Cr011_01M1DTO>();

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr011_01DTO() {
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
    public Cr011_01DTO(Cr011_01DTO orig) {
        super(orig);
    }

    /**
     * 指定交付日（年）を取得します。
     * @return 指定交付日（年）
     */
    public String getDrpID_ShiteiKofuYear() {
        return drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（年）を設定します。
     * @param drpID_ShiteiKofuYear 指定交付日（年）
     */
    public void setDrpID_ShiteiKofuYear(String drpID_ShiteiKofuYear) {
        this.drpID_ShiteiKofuYear = drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（月）を取得します。
     * @return 指定交付日（月）
     */
    public String getDrpID_ShiteiKofuMonth() {
        return drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（月）を設定します。
     * @param drpID_ShiteiKofuMonth 指定交付日（月）
     */
    public void setDrpID_ShiteiKofuMonth(String drpID_ShiteiKofuMonth) {
        this.drpID_ShiteiKofuMonth = drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（日）を取得します。
     * @return 指定交付日（日）
     */
    public String getDrpID_ShiteiKofuDate() {
        return drpID_ShiteiKofuDate;
    }

    /**
     * 指定交付日（日）を設定します。
     * @param drpID_ShiteiKofuDate 指定交付日（日）
     */
    public void setDrpID_ShiteiKofuDate(String drpID_ShiteiKofuDate) {
        this.drpID_ShiteiKofuDate = drpID_ShiteiKofuDate;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public java.util.List<Cr011_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param MEISAI_LIST  明細リスト
     */
    public void setMEISAI_LIST(java.util.List<Cr011_01M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }
}