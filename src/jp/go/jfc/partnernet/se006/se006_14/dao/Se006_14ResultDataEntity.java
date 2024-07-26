//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_14ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/03 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_14.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_14ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_14ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     *
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 交付依頼年月を取得します。
     *
     * @return 交付依頼年月
     */
    public String getDate_KofuIrai() {
        return (String)getValue("Date_KofuIrai");
    }

    /**
     * 交付依頼年月を設定します。
     *
     * @param Date_KofuIrai 交付依頼年月
     */
    public void setDate_KofuIrai(String Date_KofuIrai) {
        setValue("Date_KofuIrai", Date_KofuIrai);
    }

    /**
     * 交付年月日を取得します。
     *
     * @return 交付年月日
     */
    public String getDate_Kofu() {
        return (String)getValue("Date_Kofu");
    }

    /**
     * 交付年月日を設定します。
     *
     * @param date_kofu 交付年月日
     */
    public void setDate_Kofu(String Date_Kofu) {
        setValue("Date_Kofu", Date_Kofu);
    }

    /**
     * 依頼資金交付予定額を取得します。
     *
     * @return 依頼資金交付予定額
     */
    public java.math.BigDecimal getM_Irai_ShikinKofu() {
        return (java.math.BigDecimal)getValue("M_Irai_ShikinKofu");
    }

    /**
     * 依頼資金交付予定額を設定します。
     *
     * @param M_Irai_ShikinKofu 依頼資金交付予定額
     */
    public void setM_Irai_ShikinKofu(java.math.BigDecimal M_Irai_ShikinKofu) {
        setValue("M_Irai_ShikinKofu", M_Irai_ShikinKofu);
    }

    /**
     * 元金充当額を取得します。
     *
     * @return 元金充当額
     */
    public java.math.BigDecimal getM_Ganju() {
        return (java.math.BigDecimal)getValue("M_Ganju");
    }

    /**
     * 元金充当額を設定します。
     *
     * @param M_Ganju 元金充当額
     */
    public void setM_Ganju(java.math.BigDecimal M_Ganju) {
        setValue("M_Ganju", M_Ganju);
    }

    /**
     * 依頼資金交付予定額(合計)を取得します。
     *
     * @return 依頼資金交付予定額(合計)
     */
    public java.math.BigDecimal getIrai_Kei() {
        return (java.math.BigDecimal)getValue("Irai_Kei");
    }

    /**
     * 依頼資金交付予定額(合計)を設定します。
     *
     * @param Irai_Kei 依頼資金交付予定額(合計)
     */
    public void setIrai_Kei(java.math.BigDecimal Irai_Kei) {
        setValue("Irai_Kei", Irai_Kei);
    }

    /**
     * 元金充当額(合計)を取得します。
     *
     * @return 元金充当額(合計)
     */
    public java.math.BigDecimal getGanju_Kei() {
        return (java.math.BigDecimal)getValue("Ganju_Kei");
    }

    /**
     * 元金充当額(合計)を設定します。
     *
     * @param Ganju_Kei 元金充当額(合計)
     */
    public void setGanju_Kei(java.math.BigDecimal Ganju_Kei) {
        setValue("Ganju_Kei", Ganju_Kei);
    }

}