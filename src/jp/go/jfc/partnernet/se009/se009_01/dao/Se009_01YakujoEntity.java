//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01YakujoEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe009_01YakujoDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01YakujoEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public BigDecimal getID_Credit() {
        return (BigDecimal) getValue("ID_Credit");
    }

    /**
     *
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 払込年月日を取得します。
     * @return 払込年月日
     */
    public String getDate_Haraikomi() {
        return (String) getValue("Date_Haraikomi");
    }

    /**
     * 払込年月日を設定します。
     * @param Date_Haraikomi 払込年月日
     */
    public void setDate_Haraikomi(String Date_Haraikomi) {
        setValue("Date_Haraikomi", Date_Haraikomi);
    }

    /**
     * 約定前残高を取得します。
     * @return 約定前残高
     */
    public java.math.BigDecimal getM_ZandakaBeforeYakujo() {
        return (java.math.BigDecimal) getValue("M_ZandakaBeforeYakujo");
    }

    /**
     * 約定前残高を設定します。
     * @param M_ZandakaBeforeYakujo 約定前残高
     */
    public void setM_ZandakaBeforeYakujo(java.math.BigDecimal M_ZandakaBeforeYakujo) {
        setValue("M_ZandakaBeforeYakujo", M_ZandakaBeforeYakujo);
    }

}