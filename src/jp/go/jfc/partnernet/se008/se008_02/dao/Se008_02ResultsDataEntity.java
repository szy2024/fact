//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe008_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_02ResultsDataEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 検索開始日を取得します。
	 * 
	 * @return 検索終了日
	 */
	public String getSearch_start_date() {
		return (String) getValue("SEARCH_START_DATE");
	}

	/**
	 * 検索開始日を設定します。
	 * 
	 * @param search_start_date
	 *            検索開始日
	 */
	public void setSearch_start_date(String search_start_date) {
		setValue("SEARCH_START_DATE", search_start_date);
	}

	/**
	 * 検索終了日を取得します。
	 * 
	 * @return 検索終了日
	 */
	public String getSearch_end_date() {
		return (String) getValue("SEARCH_END_DATE");
	}

	/**
	 * 検索終了日を設定します。
	 * 
	 * @param search_end_date
	 *            検索終了日
	 */
	public void setSearch_end_date(String search_end_date) {
		setValue("SEARCH_END_DATE", search_end_date);
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
	 * @param Date_Haraikomi
	 *            払込年月日
	 */
	public void setDate_Haraikomi(String Date_Haraikomi) {
		setValue("Date_Haraikomi", Date_Haraikomi);
	}

	/**
	 * 扱店コードを取得します。
	 * 
	 * @return 扱店コード
	 */
	public String getCode_Organization() {
		return (String) getValue("Code_Organization");
	}

	/**
	 * 扱店コードを設定します。
	 * 
	 * @param Code_Organization
	 *            扱店コード
	 */
	public void setCode_Organization(String Code_Organization) {
		setValue("Code_Organization", Code_Organization);
	}

	/**
	 * 農協コードを取得します。
	 * 
	 * @return 農協コード
	 */
	public String getCode_Noukyou() {
		return (String) getValue("Code_Noukyou");
	}

	/**
	 * 農協コードを設定します。
	 * 
	 * @param Code_Noukyou
	 *            農協コード
	 */
	public void setCode_Noukyou(String Code_Noukyou) {
		setValue("Code_Noukyou", Code_Noukyou);
	}

	/**
	 * 顧客名を取得します。
	 * 
	 * @return 顧客名
	 */
	public String getName_Customer() {
		return (String) getValue("Name_Customer");
	}

	/**
	 * 顧客名を設定します。
	 * 
	 * @param Name_Customer
	 *            顧客名
	 */
	public void setName_Customer(String Name_Customer) {
		setValue("Name_Customer", Name_Customer);
	}

	/**
	 * 公庫支店名を取得します。
	 * 
	 * @return 公庫支店名
	 */
	public String getName_KoukoShiten() {
		return (String) getValue("Name_KoukoShiten");
	}

	/**
	 * 公庫支店名を設定します。
	 * 
	 * @param Name_KoukoShiten
	 *            公庫支店名
	 */
	public void setName_KoukoShiten(String Name_KoukoShiten) {
		setValue("Name_KoukoShiten", Name_KoukoShiten);
	}

	/**
	 * 店舗を取得します。
	 * 
	 * @return 店舗
	 */
	public String getCode_Tenpo() {
		return (String) getValue("Code_Tenpo");
	}

	/**
	 * 店舗を設定します。
	 * 
	 * @param Code_Tenpo
	 *            店舗
	 */
	public void setCode_Tenpo(String Code_Tenpo) {
		setValue("Code_Tenpo", Code_Tenpo);
	}

	/**
	 * 年度を取得します。
	 * 
	 * @return 年度
	 */
	public String getYear() {
		return (String) getValue("Year");
	}

	/**
	 * 年度を設定します。
	 * 
	 * @param Year
	 *            年度
	 */
	public void setYear(String Year) {
		setValue("Year", Year);
	}

	/**
	 * 方式資金を取得します。
	 * 
	 * @return 方式資金
	 */
	public String getKubun_HoshikiShikin() {
		return (String) getValue("Kubun_HoshikiShikin");
	}

	/**
	 * 方式資金を設定します。
	 * 
	 * @param Kubun_HoshikiShikin
	 *            方式資金
	 */
	public void setKubun_HoshikiShikin(String Kubun_HoshikiShikin) {
		setValue("Kubun_HoshikiShikin", Kubun_HoshikiShikin);
	}

	/**
	 * 番号を取得します。
	 * 
	 * @return 番号
	 */
	public String getID_Ringi() {
		return (String) getValue("ID_Ringi");
	}

	/**
	 * 番号を設定します。
	 * 
	 * @param ID_Ringi
	 *            番号
	 */
	public void setID_Ringi(String ID_Ringi) {
		setValue("ID_Ringi", ID_Ringi);
	}

	/**
	 * 枝番を取得します。
	 * 
	 * @return 枝番
	 */
	public String getID_RingiBranch() {
		return (String) getValue("ID_RingiBranch");
	}

	/**
	 * 枝番を設定します。
	 * 
	 * @param ID_RingiBranch
	 *            枝番
	 */
	public void setID_RingiBranch(String ID_RingiBranch) {
		setValue("ID_RingiBranch", ID_RingiBranch);
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
	 * @param M_YakujoRisoku
	 *            約定利息
	 */
	public void setM_YakujoRisoku(java.math.BigDecimal M_YakujoRisoku) {
		setValue("M_YakujoRisoku", M_YakujoRisoku);
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
	 * @param M_YakujoGankin
	 *            約定元金
	 */
	public void setM_YakujoGankin(java.math.BigDecimal M_YakujoGankin) {
		setValue("M_YakujoGankin", M_YakujoGankin);
	}

	/**
	 * 請求繰上償還元金を取得します。
	 * 
	 * @return 請求繰上償還元金
	 */
	public java.math.BigDecimal getM_SeiKuriGankin() {
		return (java.math.BigDecimal) getValue("M_SeiKuriGankin ");
	}

	/**
	 * 請求繰上償還元金を設定します。
	 * 
	 * @param M_SeiKuriGankin
	 *            請求繰上償還元金
	 */
	public void setM_SeiKuriGankin(java.math.BigDecimal M_SeiKuriGankin) {
		setValue("M_SeiKuriGankin ", M_SeiKuriGankin);
	}

	/**
	 * 請求繰上償還利息を取得します。
	 * 
	 * @return 請求繰上償還利息
	 */
	public java.math.BigDecimal getM_SeiKuriRisoku() {
		return (java.math.BigDecimal) getValue("M_SeiKuriRisoku");
	}

	/**
	 * 請求繰上償還利息を設定します。
	 * 
	 * @param M_SeiKuriRisoku
	 *            請求繰上償還利息
	 */
	public void setM_SeiKuriRisoku(java.math.BigDecimal M_SeiKuriRisoku) {
		setValue("M_SeiKuriRisoku", M_SeiKuriRisoku);
	}

	/**
	 * 任意繰上償還利息を取得します。
	 * 
	 * @return 任意繰上償還利息
	 */
	public java.math.BigDecimal getM_NinKuriRisoku() {
		return (java.math.BigDecimal) getValue("M_NinKuriRisoku");
	}

	/**
	 * 任意繰上償還利息を設定します。
	 * 
	 * @param M_NinKuriRisoku
	 *            任意繰上償還利息
	 */
	public void setM_NinKuriRisoku(java.math.BigDecimal M_NinKuriRisoku) {
		setValue("M_NinKuriRisoku", M_NinKuriRisoku);
	}

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
	 * 実行年月日を取得します。
	 * 
	 * @return 実行年月日
	 */
	public String getDate_Jikko() {
		return (String) getValue("Date_Jikko");
	}

	/**
	 * 実行年月日を設定します。
	 * 
	 * @param Date_Jikko
	 *            実行年月日
	 */
	public void setDate_Jikko(String Date_Jikko) {
		setValue("Date_Jikko", Date_Jikko);
	}

	/**
	 * 特利有効年月日を取得します。
	 * 
	 * @return 特利有効年月日
	 */
	public String getDate_TokuriYuko() {
		return (String) getValue("Date_TokuriYuko");
	}

	/**
	 * 特利有効年月日を設定します。
	 * 
	 * @param Date_TokuriYuko
	 *            特利有効年月日
	 */
	public void setDate_TokuriYuko(String Date_TokuriYuko) {
		setValue("Date_TokuriYuko", Date_TokuriYuko);
	}

	/**
	 * 特利を取得します。
	 * 
	 * @return 特利
	 */
	public String getTokuri() {
		return (String) getValue("Tokuri");
	}

	/**
	 * 特利を設定します。
	 * 
	 * @param Tokuri
	 *            特利
	 */
	public void setTokuri(String Tokuri) {
		setValue("Tokuri", Tokuri);
	}

	/**
	 * 利率を取得します。
	 * 
	 * @return 利率
	 */
	public String getRiritsu() {
		return (String) getValue("Riritsu");
	}

	/**
	 * 利率を設定します。
	 * 
	 * @param Riritsu
	 *            利率
	 */
	public void setRiritsu(String Riritsu) {
		setValue("Riritsu", Riritsu);
	}

	/**
	 * 償還方法コードを取得します。
	 * 
	 * @return 償還方法コード
	 */
	public String getCode_ShokanHouhou() {
		return (String) getValue("Code_ShokanHouhou");
	}

	/**
	 * 償還方法コードを設定します。
	 * 
	 * @param Code_ShokanHouhou
	 *            償還方法コード
	 */
	public void setCode_ShokanHouhou(String Code_ShokanHouhou) {
		setValue("Code_ShokanHouhou", Code_ShokanHouhou);
	}

	/**
	 * 控除利息を取得します。
	 * 
	 * @return 控除利息
	 */
	public java.math.BigDecimal getM_KojoRisoku() {
		return (java.math.BigDecimal) getValue("M_KojoRisoku");
	}

	/**
	 * 控除利息を設定します。
	 * 
	 * @param M_KojoRisoku
	 *            控除利息
	 */
	public void setM_KojoRisoku(java.math.BigDecimal M_KojoRisoku) {
		setValue("M_KojoRisoku", M_KojoRisoku);
	}

}