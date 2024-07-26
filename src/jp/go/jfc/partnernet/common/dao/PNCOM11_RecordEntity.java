//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM11_RecordEntity
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
 * このクラスはEntityクラスです。
 * </pre>
 *
 * @author 番場　千沙都
 * @version 4.0.0
 */
public class PNCOM11_RecordEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 計算開始日を取得します。
     * @return 計算開始日
     */
    public String getDate_KeisanKaishi() {
        return (String) getValue("Date_KeisanKaishi");
    }

    /**
     * 計算開始日を設定します。
     * @param Date_KeisanKaishi 計算開始日
     */
    public void setDate_KeisanKaishi(String Date_KeisanKaishi) {
        setValue("Date_KeisanKaishi", Date_KeisanKaishi);
    }

    /**
     * 計算終了日を取得します。
     * @return 計算終了日
     */
    public String getDate_KeisanSyuryo() {
        return (String) getValue("Date_KeisanSyuryo");
    }

    /**
     * 計算終了日を設定します。
     * @param Date_KeisanSyuryo 計算終了日
     */
    public void setDate_KeisanSyuryo(String Date_KeisanSyuryo) {
        setValue("Date_KeisanSyuryo", Date_KeisanSyuryo);
    }

    /**
     * 日数を取得します。
     * @return 日数
     */
    public String getCountDate() {
        return (String) getValue("CountDate");
    }

    /**
     * 日数を設定します。
     * @param CountDate 日数
     */
    public void setCountDate(String CountDate) {
        setValue("CountDate", CountDate);
    }

    /**
     * 償還額を取得します。
     * @return 償還額
     */
    public BigDecimal getM_Shokangaku() {
    	return (BigDecimal) getValue("M_Shokangaku");
    }

    /**
     * 償還額を設定します。
     * @param M_Shokangaku 償還額
     */
    public void setM_Shokangaku(BigDecimal M_Shokangaku) {
    	setValue("M_Shokangaku",M_Shokangaku);
    }

    /**
     * 払出済残高を取得します。
     * @return 払出済残高
     */
    public BigDecimal getM_Haraidashizumizan() {
    	return (BigDecimal) getValue("M_Haraidashizumizan");
    }

    /**
     * 払出済残高を設定します。
     * @param M_Haraidashizumizan 払出済残高
     */
    public void setM_Haraidashizumizan(BigDecimal M_Haraidashizumizan) {
    	setValue("M_Haraidashizumizan",M_Haraidashizumizan);
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getRiritsu() {
        return (String) getValue("Riritsu");
    }

    /**
     * 利率を設定します。
     * @param Riritsu 利率
     */
    public void setRiritsu(String Riritsu) {
        setValue("Riritsu", Riritsu);
    }

    /**
     * 期間約定利息を取得します。
     * @return 期間内約定利息
     */
    public BigDecimal getM_UnitPeriod() {
        return (BigDecimal) getValue("M_UnitPeriod");
    }

    /**
     * 期間約定利息を設定します。
     * @param M_UnitPeriod 期間内約定利息
     */
    public void setM_UnitPeriod(BigDecimal M_UnitPeriod) {
        setValue("M_UnitPeriod", M_UnitPeriod);
    }


}