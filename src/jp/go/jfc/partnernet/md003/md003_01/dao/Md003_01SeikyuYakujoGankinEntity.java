//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_01SeikyuYakujoGankinEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/28 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd003_01SeikyuYakujoGankinDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md003_01SeikyuYakujoGankinEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_Credit() {
        return (java.math.BigDecimal) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(java.math.BigDecimal ID_Credit) {
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
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getM_YakujoGankin() {
        return (java.math.BigDecimal) getValue("M_YakujoGankin");
    }

    /**
     * 約定元金を設定します。
     * @param M_YakujoGankin 約定元金
     */
    public void setM_YakujoGankin(java.math.BigDecimal M_YakujoGankin) {
        setValue("M_YakujoGankin", M_YakujoGankin);
    }

}