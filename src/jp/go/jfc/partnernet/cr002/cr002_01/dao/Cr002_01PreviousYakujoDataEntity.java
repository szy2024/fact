//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01PreviousYakujoDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/25 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr002_01PreviousYakujoDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr002_01PreviousYakujoDataEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_ID_Credit() {
        return (java.math.BigDecimal) getValue("ID_ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(java.math.BigDecimal ID_ID_Credit) {
        setValue("ID_ID_Credit", ID_ID_Credit);
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

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public java.math.BigDecimal getM_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("M_YakujoRisoku");
    }

    /**
     * 約定利息を設定します。
     * @param M_YakujoRisoku 約定利息
     */
    public void setM_YakujoRisoku(java.math.BigDecimal M_YakujoRisoku) {
        setValue("M_YakujoRisoku", M_YakujoRisoku);
    }

    /**
     * 請求繰上償還利息を取得します。
     * @return 請求繰上償還利息
     */
    public java.math.BigDecimal getM_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("M_SeiKuriRisoku");
    }

    /**
     * 請求繰上償還利息を設定します。
     * @param M_SeiKuriRisoku 請求繰上償還利息
     */
    public void setM_SeiKuriRisoku(java.math.BigDecimal M_SeiKuriRisoku) {
        setValue("M_SeiKuriRisoku", M_SeiKuriRisoku);
    }

}