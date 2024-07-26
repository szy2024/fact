//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01SeikyuDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd004_01SeikyuDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_01SeikyuDataEntity extends PNBaseEntity {
    
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
     * 払込年月日２を取得します。
     * @return 払込年月日２
     */
    public String getID_Date_Haraikomi() {
        return (String) getValue("ID_Date_Haraikomi");
    }

    /**
     * 払込年月日２を設定します。
     * @param ID_Date_Haraikomi 払込年月日２
     */
    public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
        setValue("ID_Date_Haraikomi", ID_Date_Haraikomi);
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getID_M_YakujoGankin() {
        return (java.math.BigDecimal) getValue("ID_M_YakujoGankin");
    }

    /**
     * 約定元金を設定します。
     * @param ID_M_YakujoGankin 約定元金
     */
    public void setID_M_YakujoGankin(java.math.BigDecimal ID_M_YakujoGankin) {
        setValue("ID_M_YakujoGankin", ID_M_YakujoGankin);
    }

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public java.math.BigDecimal getID_M_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("ID_M_YakujoRisoku");
    }

    /**
     * 約定利息を設定します。
     * @param ID_M_YakujoRisoku 約定利息
     */
    public void setID_M_YakujoRisoku(java.math.BigDecimal ID_M_YakujoRisoku) {
        setValue("ID_M_YakujoRisoku", ID_M_YakujoRisoku);
    }

    /**
     * 請求繰上償還元金を取得します。
     * @return 請求繰上償還元金
     */
    public java.math.BigDecimal getID_M_SeiKuriGankin() {
        return (java.math.BigDecimal) getValue("ID_M_SeiKuriGankin");
    }

    /**
     * 請求繰上償還元金を設定します。
     * @param ID_M_SeiKuriGankin 請求繰上償還元金
     */
    public void setID_M_SeiKuriGankin(java.math.BigDecimal ID_M_SeiKuriGankin) {
        setValue("ID_M_SeiKuriGankin", ID_M_SeiKuriGankin);
    }

    /**
     * 請求繰上償還利息を取得します。
     * @return 請求繰上償還利息
     */
    public java.math.BigDecimal getID_M_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("ID_M_SeiKuriRisoku");
    }

    /**
     * 請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku 請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku(java.math.BigDecimal ID_M_SeiKuriRisoku) {
        setValue("ID_M_SeiKuriRisoku", ID_M_SeiKuriRisoku);
    }

    /**
     * 任意繰上償還利息を取得します。
     * @return 任意繰上償還利息
     */
    public java.math.BigDecimal getID_M_NinKuriRisoku() {
        return (java.math.BigDecimal) getValue("ID_M_NinKuriRisoku");
    }

    /**
     * 任意繰上償還利息を設定します。
     * @param ID_M_NinKuriRisoku 任意繰上償還利息
     */
    public void setID_M_NinKuriRisoku(java.math.BigDecimal ID_M_NinKuriRisoku) {
        setValue("ID_M_NinKuriRisoku", ID_M_NinKuriRisoku);
    }

}