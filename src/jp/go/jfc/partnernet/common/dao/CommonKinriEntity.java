//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : CommonKinriEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCommonKinriDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class CommonKinriEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 金利呼称コードを取得します。
     * @return 金利呼称コード
     */
    public String getCode_KinriKosho() {
        return (String) getValue("Code_KinriKosho");
    }

    /**
     * 金利呼称コードを設定します。
     * @param Code_KinriKosho 金利呼称コード
     */
    public void setCode_KinriKosho(String Code_KinriKosho) {
        setValue("Code_KinriKosho", Code_KinriKosho);
    }

    /**
     * 金利呼称細目コードを取得します。
     * @return 金利呼称細目コード
     */
    public String getCode_KinriKoshoSaimoku() {
        return (String) getValue("Code_KinriKoshoSaimoku");
    }

    /**
     * 金利呼称細目コード設定します。
     * @param Code_KinriKoshoSaimoku 金利呼称細目コード
     */
    public void setCode_KinriKoshoSaimoku(String Code_KinriKoshoSaimoku) {
        setValue("Code_KinriKoshoSaimoku", Code_KinriKoshoSaimoku);
    }

    /**
     * 適用開始年月日を取得します。
     * @return 適用開始年月日
     */
    public String getDate_TekiyouStart() {
        return (String) getValue("Date_TekiyouStart");
    }

    /**
     * 適用開始年月日を設定します。
     * @param Date_TekiyouStart 適用開始年月日
     */
    public void setDate_TekiyouStart(String Date_TekiyouStart) {
        setValue("Date_TekiyouStart", Date_TekiyouStart);
    }

    /**
     * 適用終了年月日を取得します。
     * @return 適用終了年月日
     */
    public String getDate_TekiyouEnd() {
        return (String) getValue("Date_TekiyouEnd");
    }

    /**
     * 適用終了年月日を設定します。
     * @param Date_TekiyouEnd 適用終了年月日
     */
    public void setDate_TekiyouEnd(String Date_TekiyouEnd) {
        setValue("Date_TekiyouEnd", Date_TekiyouEnd);
    }

    /**
     * 貸付期間年数を取得します。
     * @return 貸付期間年数
     */
    public BigDecimal getYears_KashitsukeKikan() {
        return (BigDecimal) getValue("Years_KashitsukeKikan");
    }

    /**
     * 貸付期間年数を設定します。
     * @param Years_KashitsukeKikan 貸付期間年数
     */
    public void setYears_KashitsukeKikan(BigDecimal Years_KashitsukeKikan) {
        setValue("Years_KashitsukeKikan", Years_KashitsukeKikan);
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public BigDecimal getRiritsu() {
        return (BigDecimal) getValue("Riritsu");
    }

    /**
     * 利率を設定します。
     * @param Riritsu 利率
     */
    public void setRiritsu(BigDecimal Riritsu) {
        setValue("Riritsu", Riritsu);
    }

    /**
     * 利子助成率を取得します。
     * @return 利子助成率
     */
    public BigDecimal getRishiJoseiRitsu() {
        return (BigDecimal) getValue("RishiJoseiRitsu");
    }

    /**
     * 利子助成率を設定します。
     * @param RishiJoseiRitsu 利子助成率
     */
    public void setRishiJoseiRitsu(BigDecimal RishiJoseiRitsu) {
        setValue("RishiJoseiRitsu", RishiJoseiRitsu);
    }

}