//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : md010_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md010.md010_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはmd010_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md010_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 交付日（月） */
    private String lblID_KofuDateMonth;
    /** 交付日（日） */
    private String drpID_KofuDateDate;
    /** 交付日（日）_プルダウンリスト */
    private java.util.LinkedHashMap<String, Object> KOFU_DATE_PULLDOWN;
    /** 依頼予定額 */
    private String txtID_Irai;
    /** 元金充当額 */
    private String txtID_Ganju;
    /** 更新日時 */
    private java.sql.Timestamp DateTime_Update;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md010_01M1DTO() {
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
    public Md010_01M1DTO(Md010_01M1DTO orig) {
        super(orig);
    }

    /**
     * 交付日（月）を取得します。
     * @return 交付日（月）
     */
    public String getLblID_KofuDateMonth() {
        return lblID_KofuDateMonth;
    }

    /**
     * 交付日（月）を設定します。
     * @param lblID_KofuDateMonth 交付日（月）
     */
    public void setLblID_KofuDateMonth(String lblID_KofuDateMonth) {
        this.lblID_KofuDateMonth = lblID_KofuDateMonth;
    }

    /**
     * 交付日（日）を取得します。
     * @return 交付日（日）
     */
    public String getDrpID_KofuDateDate() {
        return drpID_KofuDateDate;
    }

    /**
     * 交付日（日）を設定します。
     * @param drpID_KofuDateDate 交付日（日）
     */
    public void setDrpID_KofuDateDate(String drpID_KofuDateDate) {
        this.drpID_KofuDateDate = drpID_KofuDateDate;
    }

    /**
     * 交付日（日）_プルダウンリストを取得します。
     *
     * @return 交付日（日）_プルダウンリスト
     */
    public java.util.LinkedHashMap<String, Object> getKOFU_DATE_PULLDOWN() {
        return KOFU_DATE_PULLDOWN;
    }

    /**
     * 交付日（日）_プルダウンリストを設定します。
     *
     * @param KOFU_DATE_PULLDOWN
     *            交付日（日）_プルダウンリスト
     */
    public void setKOFU_DATE_PULLDOWN(java.util.LinkedHashMap<String, Object> KOFU_DATE_PULLDOWN) {
        this.KOFU_DATE_PULLDOWN = KOFU_DATE_PULLDOWN;
    }

    /**
     * 依頼予定額を取得します。
     * @return 依頼予定額
     */
    public String getTxtID_Irai() {
        return txtID_Irai;
    }

    /**
     * 依頼予定額を設定します。
     * @param txtID_Irai 依頼予定額
     */
    public void setTxtID_Irai(String txtID_Irai) {
        this.txtID_Irai = txtID_Irai;
    }

    /**
     * 元金充当額を取得します。
     * @return 元金充当額
     */
    public String getTxtID_Ganju() {
        return txtID_Ganju;
    }

    /**
     * 元金充当額を設定します。
     * @param txtID_Ganju 元金充当額
     */
    public void setTxtID_Ganju(String txtID_Ganju) {
        this.txtID_Ganju = txtID_Ganju;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public java.sql.Timestamp getDateTime_Update() {
        return DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(java.sql.Timestamp DateTime_Update) {
        this.DateTime_Update = DateTime_Update;
    }
}