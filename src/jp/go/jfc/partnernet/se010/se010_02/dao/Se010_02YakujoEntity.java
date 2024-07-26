//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02YakujoEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe010_02YakujoDAOのEntityクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_02YakujoEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 債権管理番号を取得します。
	 * 
	 * @return 債権管理番号
	 */
	public String getID_Credit() {
		return (String) getValue("ID_Credit");
	}

	/**
	 * 債権管理番号を設定します。
	 * 
	 * @param ID_Credit 債権管理番号
	 */
	public void setID_Credit(String ID_Credit) {
		setValue("ID_Credit", ID_Credit);
	}

	/**
	 * 貸付実行日を取得します。
	 * 
	 * @return 貸付実行日
	 */
	public String getStrDateKashitsukeJikko() {
		return (String) getValue("strDateKashitsukeJikko");
	}

	/**
	 * 貸付実行日を設定します。
	 * 
	 * @param strDateKashitsukeJikko 貸付実行日
	 */
	public void setStrDateKashitsukeJikko(String strDateKashitsukeJikko) {
		setValue("strDateKashitsukeJikko", strDateKashitsukeJikko);
	}

	/**
	 * 繰上償還期限の月末を取得します。
	 * 
	 * @return 繰上償還期限の月末
	 */
	public String getStrDateShokanKigen() {
		return (String) getValue("strDateShokanKigen");
	}

	/**
	 * 繰上償還期限の月末を設定します。
	 * 
	 * @param strDateShokanKigen 繰上償還期限の月末
	 */
	public void setStrDateShokanKigen(String strDateShokanKigen) {
		setValue("strDateShokanKigen", strDateShokanKigen);
	}

	/**
	 * 払込年月日を取得します。
	 * 
	 * @return 払込年月日
	 */
	public String getDate_Haraikomi() {
		return (String) getValue("Date_Haraikomi");
	}

	/**
	 * 払込年月日を設定します。
	 * 
	 * @param Date_Haraikomi 払込年月日
	 */
	public void setDate_Haraikomi(String Date_Haraikomi) {
		setValue("Date_Haraikomi", Date_Haraikomi);
	}

	/**
	 * 約定元金を取得します。
	 * 
	 * @return 約定元金
	 */
	public java.math.BigDecimal getM_YakujoGankin() {
		return (java.math.BigDecimal) getValue("M_YakujoGankin");
	}

	/**
	 * 約定元金を設定します。
	 * 
	 * @param M_YakujoGankin 約定元金
	 */
	public void setM_YakujoGankin(java.math.BigDecimal M_YakujoGankin) {
		setValue("M_YakujoGankin", M_YakujoGankin);
	}

	/**
	 * 約定利息を取得します。
	 * 
	 * @return 約定利息
	 */
	public java.math.BigDecimal getM_YakujoRisoku() {
		return (java.math.BigDecimal) getValue("M_YakujoRisoku");
	}

	/**
	 * 約定利息を設定します。
	 * 
	 * @param M_YakujoRisoku 約定利息
	 */
	public void setM_YakujoRisoku(java.math.BigDecimal M_YakujoRisoku) {
		setValue("M_YakujoRisoku", M_YakujoRisoku);
	}

	/**
	 * 約定前残高を取得します。
	 * 
	 * @return 約定前残高
	 */
	public java.math.BigDecimal getM_ZandakaBeforeYakujo() {
		return (java.math.BigDecimal) getValue("M_ZandakaBeforeYakujo");
	}

	/**
	 * 約定前残高を設定します。
	 * 
	 * @param M_ZandakaBeforeYakujo 約定前残高
	 */
	public void setM_ZandakaBeforeYakujo(java.math.BigDecimal M_ZandakaBeforeYakujo) {
		setValue("M_ZandakaBeforeYakujo", M_ZandakaBeforeYakujo);
	}

}