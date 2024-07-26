//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se014_01SumWeekEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe014_01SumWeekDAOのEntityクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se014_01SumWeekEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 集計対象年月日を取得します。
     * @return 集計対象年月日
     */
    public String getDate_shukei_taisho() {
        return (String)getValue("Date_Shukei_Taisho");
    }

    /**
     * 集計対象年月日を設定します。
     * @param date_shukei_taisho 集計対象年月日
     */
    public void setDate_shukei_taisho(String date_shukei_taisho) {
        setValue("Date_Shukei_Taisho", date_shukei_taisho);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     * @param code_organization 扱店コード
     */
    public void setCode_organization(String code_organization) {
        setValue("Code_Organization", code_organization);
    }

    /**
     * 金融機関名称を取得します。
     * @return 金融機関名称
     */
    public String getName_organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 金融機関名称を設定します。
     * @param name_organization 金融機関名称
     */
    public void setName_organization(String name_organization) {
        setValue("Name_Organization", name_organization);
    }

    /**
     * 依頼予定額を取得します。
     * @return 依頼予定額
     */
    public java.math.BigDecimal getM_yotei() {
        return (java.math.BigDecimal)getValue("M_Yotei");
    }

    /**
     * 依頼予定額を設定します。
     * @param m_yotei 依頼予定額
     */
    public void setM_yotei(java.math.BigDecimal m_yotei) {
        setValue("M_Yotei", m_yotei);
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を取得します。
     * @return 資金交付金残高見込額（指定交付日の前日現在）
     */
    public java.math.BigDecimal getM_zanmikomi() {
        return (java.math.BigDecimal)getValue("M_ZanMikomi");
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を設定します。
     * @param m_zanmikomi 資金交付金残高見込額（指定交付日の前日現在）
     */
    public void setM_zanmikomi(java.math.BigDecimal m_zanmikomi) {
        setValue("M_ZanMikomi", m_zanmikomi);
    }

    /**
     * 元金充当額（外数）を取得します。
     * @return 元金充当額（外数）
     */
    public java.math.BigDecimal getM_ganju() {
        return (java.math.BigDecimal)getValue("M_Ganju_Gaisu");
    }

    /**
     * 元金充当額（外数）を設定します。
     * @param m_ganju_gaisu 元金充当額（外数）
     */
    public void setM_ganju(java.math.BigDecimal m_ganju_gaisu) {
        setValue("M_Ganju_Gaisu", m_ganju_gaisu);
    }

    /**
     * 指定交付日を取得します。
     * @return 指定交付日
     */
    public String getDate_kofu() {
        return (String)getValue("Date_Kofu");
    }

    /**
     * 指定交付日を設定します。
     * @param date_kofu 指定交付日
     */
    public void setDate_kofu(String date_kofu) {
        setValue("Date_Kofu", date_kofu);
    }
}