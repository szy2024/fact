//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02GetNyukinHistoryDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe003_02GetNyukinHistoryDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02NyukinHistoryDataEntity extends PNBaseEntity {
    
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
     * 入金年月日を取得します。
     * @return 入金年月日
     */
    public String getDate_Nyukin() {
        return (String) getValue("Date_Nyukin");
    }

    /**
     * 入金年月日を設定します。
     * @param Date_Nyukin 入金年月日
     */
    public void setDate_Nyukin(String Date_Nyukin) {
        setValue("Date_Nyukin", Date_Nyukin);
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
     * 任意繰上償還利息を取得します。
     * @return 任意繰上償還利息
     */
    public java.math.BigDecimal getM_NinKuriRisoku() {
        return (java.math.BigDecimal) getValue("M_NinKuriRisoku");
    }

    /**
     * 任意繰上償還利息を設定します。
     * @param M_NinKuriRisoku 任意繰上償還利息
     */
    public void setM_NinKuriRisoku(java.math.BigDecimal M_NinKuriRisoku) {
        setValue("M_NinKuriRisoku", M_NinKuriRisoku);
    }

    /**
     * 任意繰上償還元金を取得します。
     * @return 任意繰上償還元金
     */
    public java.math.BigDecimal getM_NinKuriGankin() {
        return (java.math.BigDecimal) getValue("M_NinKuriGankin");
    }

    /**
     * 任意繰上償還元金を設定します。
     * @param M_NinKuriGankin 任意繰上償還元金
     */
    public void setM_NinKuriGankin(java.math.BigDecimal M_NinKuriGankin) {
        setValue("M_NinKuriGankin", M_NinKuriGankin);
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

    /**
     * 遅延損害金を取得します。
     * @return 遅延損害金
     */
    public java.math.BigDecimal getM_ChienSongai() {
        return (java.math.BigDecimal) getValue("M_ChienSongai");
    }

    /**
     * 遅延損害金を設定します。
     * @param M_ChienSongai 遅延損害金
     */
    public void setM_ChienSongai(java.math.BigDecimal M_ChienSongai) {
        setValue("M_ChienSongai", M_ChienSongai);
    }

    /**
     * 違約金を取得します。
     * @return 違約金
     */
    public java.math.BigDecimal getM_Iyaku() {
        return (java.math.BigDecimal) getValue("M_Iyaku");
    }

    /**
     * 違約金を設定します。
     * @param M_Iyaku 違約金
     */
    public void setM_Iyaku(java.math.BigDecimal M_Iyaku) {
        setValue("M_Iyaku", M_Iyaku);
    }

    /**
     * 転用違約金を取得します。
     * @return 転用違約金
     */
    public java.math.BigDecimal getM_TenyoIyaku() {
        return (java.math.BigDecimal) getValue("M_TenyoIyaku");
    }

    /**
     * 転用違約金を設定します。
     * @param M_TenyoIyaku 転用違約金
     */
    public void setM_TenyoIyaku(java.math.BigDecimal M_TenyoIyaku) {
        setValue("M_TenyoIyaku", M_TenyoIyaku);
    }

    /**
     * 棚上遅延損害金を取得します。
     * @return 棚上遅延損害金
     */
    public java.math.BigDecimal getM_TanaageChienSongai() {
        return (java.math.BigDecimal) getValue("M_TanaageChienSongai");
    }

    /**
     * 棚上遅延損害金を設定します。
     * @param M_TanaageChienSongai 棚上遅延損害金
     */
    public void setM_TanaageChienSongai(java.math.BigDecimal M_TanaageChienSongai) {
        setValue("M_TanaageChienSongai", M_TanaageChienSongai);
    }

    /**
     * 今回発生遅延損害金を取得します。
     * @return 今回発生遅延損害金
     */
    public java.math.BigDecimal getM_ThisChienSongai() {
        return (java.math.BigDecimal) getValue("M_ThisChienSongai");
    }

    /**
     * 今回発生遅延損害金を設定します。
     * @param M_ThisChienSongai 今回発生遅延損害金
     */
    public void setM_ThisChienSongai(java.math.BigDecimal M_ThisChienSongai) {
        setValue("M_ThisChienSongai", M_ThisChienSongai);
    }

    /**
     * 代位弁済金納付区分を取得します。
     * @return 代位弁済金納付区分
     */
    public String getKubun_DaibeNoufu() {
        return (String) getValue("Kubun_DaibeNoufu");
    }

    /**
     * 代位弁済金納付区分を設定します。
     * @param Kubun_DaibeNoufu 代位弁済金納付区分
     */
    public void setKubun_DaibeNoufu(String Kubun_DaibeNoufu) {
        setValue("Kubun_DaibeNoufu", Kubun_DaibeNoufu);
    }

}