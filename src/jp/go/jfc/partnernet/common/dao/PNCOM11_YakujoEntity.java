//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM11_YakujoEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 4.0.0   | 2020/11/30 | 番場　千沙都          | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはPNCOM11_YakujoDAOのEntityクラスです。
 * </pre>
 *
 * @author 番場　千沙都
 * @version 4.0.0
 */
public class PNCOM11_YakujoEntity extends PNBaseEntity {

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
     * 検索条件モード(検索条件分岐用パラメータ)を取得します。
     * @return
     */
    public String getWhereMode() {
        return (String) getValue("whereMode");
    }

    /**
     * 検索条件モード(検索条件分岐用パラメータ)を設定します。
     * @param
     */
    public void setWhereMode(String whereMode) {
        setValue("whereMode", whereMode);
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public BigDecimal getM_YakujoGankin() {
    	return (BigDecimal) getValue("M_YakujoGankin");
    }

    /**
     * 約定元金を設定します。
     * @param M_YakujoGankin 約定元金
     */
    public void setM_YakujoGankin(BigDecimal M_YakujoGankin) {
    	setValue("M_YakujoGankin",M_YakujoGankin);
    }

    /**
     * 約定前残高を取得します。
     * @return 約定前残高
     */
    public BigDecimal getM_ZandakaBeforeYakujo() {
    	return (BigDecimal) getValue("M_ZandakaBeforeYakujo");
    }

    /**
     * 約定前残高を設定します。
     * @param M_ZandakaBeforeYakujo 約定前残高
     */
    public void setM_ZandakaBeforeYakujo(BigDecimal M_ZandakaBeforeYakujo) {
    	setValue("M_ZandakaBeforeYakujo",M_ZandakaBeforeYakujo);
    }

    /**
     * 請求繰上償還元金を取得します。
     * @return 請求繰上償還元金
     */
    public BigDecimal getM_SeiKuriGankin() {
        return (BigDecimal) getValue("M_SeiKuriGankin");
    }

    /**
     * 請求繰上償還元金を設定します。
     * @param M_SeiKuriGankin 請求繰上償還元金
     */
    public void setM_SeiKuriGankin(BigDecimal M_SeiKuriGankin) {
        setValue("M_SeiKuriGankin", M_SeiKuriGankin);
    }


}