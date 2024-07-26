//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM02_HaraidashiEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/02 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはPNCOM02_HaraidashiDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class PNCOM02_HaraidashiEntity extends PNBaseEntity {

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
     * 払出充当年月日(FROM)を取得します(検索条件に使用)
     * @return 払出充当年月日(FROM)
     */
    public String getDate_HaraidashiJuto_From() {
        return (String) getValue("Date_HaraidashiJuto_From");
    }

    /**
     * 払出充当年月日(FROM)を設定します(検索条件に使用)
     * @param Date_HaraidashiJuto_From 払出充当年月日(FROM)
     */
    public void setDate_HaraidashiJuto_From(String Date_HaraidashiJuto_From) {
        setValue("Date_HaraidashiJuto_From", Date_HaraidashiJuto_From);
    }

    /**
     * 払出充当年月日(TO)を取得します(検索条件に使用)
     * @return 払出充当年月日(TO)
     */
    public String getDate_HaraidashiJuto_To() {
        return (String) getValue("Date_HaraidashiJuto_To");
    }

    /**
     * 払出充当年月日(TO)を設定します(検索条件に使用)
     * @param Date_HaraidashiJuto_To 払出充当年月日(TO)
     */
    public void setDate_HaraidashiJuto_To(String Date_HaraidashiJuto_To) {
        setValue("Date_HaraidashiJuto_To", Date_HaraidashiJuto_To);
    }

    /**
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public BigDecimal getM_KashitsukeukeireZan() {
        return (BigDecimal) getValue("M_KashitsukeukeireZan");
    }

    /**
     * 貸付受入金残高を設定します。
     * @param M_KashitsukeukeireZan 貸付受入金残高
     */
    public void setM_KashitsukeukeireZan(BigDecimal M_KashitsukeukeireZan) {
        setValue("M_KashitsukeukeireZan", M_KashitsukeukeireZan);
    }

    /**
     * 貸付受入金残高積数を取得します。
     * @return 貸付受入金残高積数
     */
    public BigDecimal getM_ZandakaSekisu() {
        return (BigDecimal) getValue("M_ZandakaSekisu");
    }

    /**
     * 貸付受入金残高積数を設定します。
     * @param M_ZandakaSekisu 貸付受入金残高積数
     */
    public void setM_ZandakaSekisu(BigDecimal M_ZandakaSekisu) {
        setValue("M_ZandakaSekisu", M_ZandakaSekisu);
    }

    /**
     * 払出充当年月日を取得します。
     * @return 払出充当年月日
     */
    public String getDate_HaraidashiJuto() {
        return (String) getValue("Date_HaraidashiJuto");
    }

    /**
     * 払出充当年月日を設定します。
     * @param Date_HaraidashiJuto 払出充当年月日
     */
    public void setDate_HaraidashiJuto(String Date_HaraidashiJuto) {
        setValue("Date_HaraidashiJuto", Date_HaraidashiJuto);
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

}