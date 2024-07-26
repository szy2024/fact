//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02GetHaraidashiDataEntity
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
 * このクラスはSe003_02GetHaraidashiDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02HaraidashiDataEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 債権管理番号を取得します。
	 *
	 * @return 債権管理番号
	 */
	public java.math.BigDecimal getID_Credit() {
		return (java.math.BigDecimal) getValue("ID_Credit");
	}

	/**
	 * 債権管理番号を設定します。
	 *
	 * @param ID_Credit
	 *            債権管理番号
	 */
	public void setID_Credit(java.math.BigDecimal ID_Credit) {
		setValue("ID_Credit", ID_Credit);
	}

	/**
	 * 払出充当年月日を取得します。
	 *
	 * @return 払出充当年月日
	 */
	public String getDate_HaraidashiJuto() {
		return (String) getValue("Date_HaraidashiJuto");
	}

	/**
	 * 払出充当年月日を設定します。
	 *
	 * @param Date_HaraidashiJuto
	 *            払出充当年月日
	 */
	public void setDate_HaraidashiJuto(String Date_HaraidashiJuto) {
		setValue("Date_HaraidashiJuto", Date_HaraidashiJuto);
	}

	/**
	 * 払出額を取得します。
	 *
	 * @return 払出額
	 */
	public java.math.BigDecimal getM_Haraidashi() {
		return (java.math.BigDecimal) getValue("M_Haraidashi");
	}

	/**
	 * 払出額を設定します。
	 *
	 * @param M_Haraidashi
	 *            払出額
	 */
	public void setM_Haraidashi(java.math.BigDecimal M_Haraidashi) {
		setValue("M_Haraidashi", M_Haraidashi);
	}

	/**
	 * 払出累計額を取得します。
	 *
	 * @return 払出累計額
	 */
	public java.math.BigDecimal getM_HaraidashiRuikei() {
		return (java.math.BigDecimal) getValue("M_HaraidashiRuikei");
	}

	/**
	 * 払出累計額を設定します。
	 *
	 * @param M_HaraidashiRuikei
	 *            払出累計額
	 */
	public void setM_HaraidashiRuikei(java.math.BigDecimal M_HaraidashiRuikei) {
		setValue("M_HaraidashiRuikei", M_HaraidashiRuikei);
	}

	/**
	 * 繰上償還額を取得します。
	 *
	 * @return 繰上償還額
	 */
	public java.math.BigDecimal getM_Kurisho() {
		return (java.math.BigDecimal) getValue("M_Kurisho");
	}

	/**
	 * 繰上償還額を設定します。
	 *
	 * @param M_Kurisho
	 *            繰上償還額
	 */
	public void setM_Kurisho(java.math.BigDecimal M_Kurisho) {
		setValue("M_Kurisho", M_Kurisho);
	}

	/**
	 * 繰上償還累計額を取得します。
	 *
	 * @return 繰上償還累計額
	 */
	public java.math.BigDecimal getM_KurishoRuikei() {
		return (java.math.BigDecimal) getValue("M_KurishoRuikei");
	}

	/**
	 * 繰上償還累計額を設定します。
	 *
	 * @param M_KurishoRuikei
	 *            繰上償還累計額
	 */
	public void setM_KurishoRuikei(java.math.BigDecimal M_KurishoRuikei) {
		setValue("M_KurishoRuikei", M_KurishoRuikei);
	}

	/**
	 * 貸付受入金残高を取得します。
	 *
	 * @return 貸付受入金残高
	 */
	public java.math.BigDecimal getM_KashitsukeukeireZan() {
		return (java.math.BigDecimal) getValue("M_KashitsukeukeireZan");
	}

	/**
	 * 貸付受入金残高を設定します。
	 *
	 * @param M_KashitsukeukeireZan
	 *            貸付受入金残高
	 */
	public void setM_KashitsukeukeireZan(
			java.math.BigDecimal M_KashitsukeukeireZan) {
		setValue("M_KashitsukeukeireZan", M_KashitsukeukeireZan);
	}

}