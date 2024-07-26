//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se006_14DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/03 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_14.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse006_14のDTOクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_14DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラー */
    private String lblError;
    /** 交付依頼年月（年） */
    private String lblID_KofuIraiYear;
    /** 交付依頼年月（月） */
    private String lblID_KofuIraiMonth;
    /** 依頼予定額_合計 */
    private java.math.BigDecimal lblID_Irai_Kei;
    /** 元金充当額_合計 */
    private java.math.BigDecimal lblID_Ganju_Kei;
    /** 報告書番号 */
    private String lblID_Report;

    /** 明細リスト */
    private java.util.List<Se006_14M1DTO> meisai_list = new java.util.ArrayList<Se006_14M1DTO>(6);

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_14DTO() {
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
    public Se006_14DTO(Se006_14DTO orig) {
        super(orig);
    }

    /**
     * エラーを取得します。
     *
     * @return エラー
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーを設定します。
     *
     * @param lblerror エラー
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 交付依頼年月（年）を取得します。
     *
     * @return 交付依頼年月（年）
     */
    public String getLblID_KofuIraiYear() {
        return lblID_KofuIraiYear;
    }

    /**
     * 交付依頼年月（年）を設定します。
     *
     * @param lblID_KofuIraiYear 交付依頼年月（年）
     */
    public void setLblID_KofuIraiYear(String lblID_KofuIraiYear) {
        this.lblID_KofuIraiYear = lblID_KofuIraiYear;
    }

    /**
     * 交付依頼年月（月）を取得します。
     *
     * @return 交付依頼年月（月）
     */
    public String getLblID_KofuIraiMonth() {
        return lblID_KofuIraiMonth;
    }

    /**
     * 交付依頼年月（月）を設定します。
     *
     * @param lblID_KofuIraiMonth 交付依頼年月（月）
     */
    public void setLblID_KofuIraiMonth(String lblID_KofuIraiMonth) {
        this.lblID_KofuIraiMonth = lblID_KofuIraiMonth;
    }

    /**
     * 依頼予定額_合計を取得します。
     *
     * @return 依頼予定額_合計
     */
    public java.math.BigDecimal getLblID_Irai_Kei() {
        return lblID_Irai_Kei;
    }

    /**
     * 依頼予定額_合計を設定します。
     *
     * @param lblID_Irai_Kei 依頼予定額_合計
     */
    public void setLblID_Irai_Kei(java.math.BigDecimal lblID_Irai_Kei) {
        this.lblID_Irai_Kei = lblID_Irai_Kei;
    }

    /**
     * 元金充当額_合計を取得します。
     *
     * @return 元金充当額_合計
     */
    public java.math.BigDecimal getLblID_Ganju_Kei() {
        return lblID_Ganju_Kei;
    }

    /**
     * 元金充当額_合計を設定します。
     *
     * @param lblID_Ganju_Kei 元金充当額_合計
     */
    public void setLblID_Ganju_Kei(java.math.BigDecimal lblID_Ganju_Kei) {
        this.lblID_Ganju_Kei = lblID_Ganju_Kei;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getLblid_report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public java.util.List<Se006_14M1DTO> getMeisai_list() {
        return meisai_list;
    }

    /**
     * 明細リストを設定します。
     *
     * @param meisai_list 明細リスト
     */
    public void setMeisai_list(java.util.List<Se006_14M1DTO> meisai_list) {
        this.meisai_list = meisai_list;
    }

}