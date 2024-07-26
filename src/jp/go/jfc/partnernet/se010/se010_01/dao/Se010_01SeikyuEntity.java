//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01SeikyuEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe010_01SeikyuDAOのEntityクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01SeikyuEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return (String) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 繰償後第一回払込期日を取得します。
     * @return 繰償後第一回払込期日
     */
    public String getStrDate_KurishoTaisho() {
        return (String) getValue("strDate_KurishoTaisho");
    }

    /**
     * 繰償後第一回払込期日を設定します。
     * @param strDate_KurishoTaisho 繰償後第一回払込期日
     */
    public void setStrDate_KurishoTaisho(String strDate_KurishoTaisho) {
        setValue("strDate_KurishoTaisho", strDate_KurishoTaisho);
    }

    /**
     * 繰償後第一回払込期日Toを取得します。
     * @return 繰償後第一回払込期日To
     */
    public String getStrDate_KurishoTaishoTo() {
        return (String) getValue("strDate_KurishoTaishoTo");
    }

    /**
     * 繰償後第一回払込期日Toを設定します。
     * @param strDate_KurishoTaishoTo 繰償後第一回払込期日To
     */
    public void setStrDate_KurishoTaishoTo(String strDate_KurishoTaishoTo) {
        setValue("strDate_KurishoTaishoTo", strDate_KurishoTaishoTo);
    }

    /**
     * 請求繰上償還元金を取得します。
     * @return 請求繰上償還元金
     */
    public java.math.BigDecimal getM_SeiKuriGankin() {
        return (java.math.BigDecimal) getValue("M_SeiKuriGankin");
    }

    /**
     * 請求繰上償還元金を設定します。
     * @param M_SeiKuriGankin 請求繰上償還元金
     */
    public void setM_SeiKuriGankin(java.math.BigDecimal M_SeiKuriGankin) {
        setValue("M_SeiKuriGankin", M_SeiKuriGankin);
    }

}