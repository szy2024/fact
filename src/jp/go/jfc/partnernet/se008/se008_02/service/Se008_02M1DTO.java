//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.service;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse008_02のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_02M1DTO extends PNBaseDTO {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 顧客名 */
	private String ID_Name_Customer;
	/** 公庫支店名 */
	private String ID_Name_KoukoShiten;
	/** 扱店 */
	private String ID_Code_Organization;
	/** 店舗 */
	private String ID_Code_Tenpo;
	/** 年度 */
	private String ID_Year;
	/** 方式資金 */
	private String ID_Kubun_HoshikiShikin;
	/** 番号 */
	private String ID_ID_Ringi;
	/** 枝番 */
	private String ID_ID_RingiBranch;
	/** 払込期日 */
	private String ID_Date_Haraikomi;
	/** 約定利息 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_YakujoRisoku;
	/** 約定元金 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_YakujoGankin;
	/** 控除利息 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_KojoRisoku;
	/** 請求繰上償還元金 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_SeiKuriGankin;
	/** 請求繰上償還利息 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_SeiKuriRisoku;
	/** 任意繰上償還利息 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal ID_M_NinKuriRisoku;

	/** 債権管理番号 */
	private java.math.BigDecimal ID_Credit;
	/** 実行年月日 */
	private String Date_Jikko;
	/** 特利有効年月日 */
	private String Date_TokuriYuko;
	/** 特利 */
	private java.math.BigDecimal Tokuri;
	/** 利率 */
	private java.math.BigDecimal Riritsu;
	/** 償還方法コード */
	private String Code_ShokanHouhou;

	/** 約定利息計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_YakujoRisokuKEI;
	/** 約定元金計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_YakujoGankinKEI;
	/** 控除利息計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KojoRisokuKEI;
	/** 請求繰上償還元金計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_SeiKuriGankinKEI;
	/** 請求繰上償還利息計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_SeiKuriRisokuKEI;
	/** 任意繰上償還利息計 */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_NiniRisokuKEI;
	/** 合計行表示フラグ */
	private String totalDisplayFlg;

	/**
	 * <pre>
	 * コンストラクター。
	 * </pre>
	 *
	 */
	public Se008_02M1DTO() {
		// Controller及びServiceでのインスタンス生成の為
	}

	/**
	 * <pre>
	 * コンストラクター。
	 * 引数のDTOの中身を取得しセットします。
	 * </pre>
	 *
	 * @param orig
	 *            設定元DTO
	 * @throws Exception
	 *             例外
	 */
	public Se008_02M1DTO(Se008_02M1DTO orig) {
		super(orig);
	}

	/**
	 * 顧客名を取得します。
	 *
	 * @return 顧客名
	 */
	public String getID_Name_Customer() {
		return ID_Name_Customer;
	}

	/**
	 * 顧客名を設定します。
	 *
	 * @param ID_Name_Customer
	 *            顧客名
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		this.ID_Name_Customer = ID_Name_Customer;
	}

	/**
	 * 公庫支店名を取得します。
	 *
	 * @return 公庫支店名
	 */
	public String getID_Name_KoukoShiten() {
		return ID_Name_KoukoShiten;
	}

	/**
	 * 公庫支店名を設定します。
	 *
	 * @param ID_Name_KoukoShiten
	 *            公庫支店名
	 */
	public void setID_Name_KoukoShiten(String ID_Name_KoukoShiten) {
		this.ID_Name_KoukoShiten = ID_Name_KoukoShiten;
	}

	/**
	 * 扱店を取得します。
	 *
	 * @return 扱店
	 */
	public String getID_Code_Organization() {
		return ID_Code_Organization;
	}

	/**
	 * 扱店を設定します。
	 *
	 * @param ID_Code_Organization
	 *            扱店
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		this.ID_Code_Organization = ID_Code_Organization;
	}

	/**
	 * 店舗を取得します。
	 *
	 * @return 店舗
	 */
	public String getID_Code_Tenpo() {
		return ID_Code_Tenpo;
	}

	/**
	 * 店舗を設定します。
	 *
	 * @param ID_Code_Tenpo
	 *            店舗
	 */
	public void setID_Code_Tenpo(String ID_Code_Tenpo) {
		this.ID_Code_Tenpo = ID_Code_Tenpo;
	}

	/**
	 * 年度を取得します。
	 *
	 * @return 年度
	 */
	public String getID_Year() {
		return ID_Year;
	}

	/**
	 * 年度を設定します。
	 *
	 * @param ID_Year
	 *            年度
	 */
	public void setID_Year(String ID_Year) {
		this.ID_Year = ID_Year;
	}

	/**
	 * 方式資金を取得します。
	 *
	 * @return 方式資金
	 */
	public String getID_Kubun_HoshikiShikin() {
		return ID_Kubun_HoshikiShikin;
	}

	/**
	 * 方式資金を設定します。
	 *
	 * @param ID_Kubun_HoshikiShikin
	 *            方式資金
	 */
	public void setID_Kubun_HoshikiShikin(String ID_Kubun_HoshikiShikin) {
		this.ID_Kubun_HoshikiShikin = ID_Kubun_HoshikiShikin;
	}

	/**
	 * 番号を取得します。
	 *
	 * @return 番号
	 */
	public String getID_ID_Ringi() {
		return ID_ID_Ringi;
	}

	/**
	 * 番号を設定します。
	 *
	 * @param ID_ID_Ringi
	 *            番号
	 */
	public void setID_ID_Ringi(String ID_ID_Ringi) {
		this.ID_ID_Ringi = ID_ID_Ringi;
	}

	/**
	 * 枝番を取得します。
	 *
	 * @return 枝番
	 */
	public String getID_ID_RingiBranch() {
		return ID_ID_RingiBranch;
	}

	/**
	 * 枝番を設定します。
	 *
	 * @param ID_ID_RingiBranch
	 *            枝番
	 */
	public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
		this.ID_ID_RingiBranch = ID_ID_RingiBranch;
	}

	/**
	 * 払込期日を取得します。
	 *
	 * @return 払込期日
	 */
	public String getID_Date_Haraikomi() {
		return ID_Date_Haraikomi;
	}

	/**
	 * 払込期日を設定します。
	 *
	 * @param ID_Date_Haraikomi
	 *            払込期日
	 */
	public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
		this.ID_Date_Haraikomi = ID_Date_Haraikomi;
	}

	/**
	 * 約定利息を取得します。
	 *
	 * @return 約定利息
	 */
	public java.math.BigDecimal getID_M_YakujoRisoku() {
		return ID_M_YakujoRisoku;
	}

	/**
	 * 約定利息を設定します。
	 *
	 * @param ID_M_YakujoRisoku
	 *            約定利息
	 */
	public void setID_M_YakujoRisoku(java.math.BigDecimal ID_M_YakujoRisoku) {
		this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
	}

	/**
	 * 約定元金を取得します。
	 *
	 * @return 約定元金
	 */
	public java.math.BigDecimal getID_M_YakujoGankin() {
		return ID_M_YakujoGankin;
	}

	/**
	 * 約定元金を設定します。
	 *
	 * @param ID_M_YakujoGankin
	 *            約定元金
	 */
	public void setID_M_YakujoGankin(java.math.BigDecimal ID_M_YakujoGankin) {
		this.ID_M_YakujoGankin = ID_M_YakujoGankin;
	}

	/**
	 * 控除利息を取得します。
	 *
	 * @return 控除利息
	 */
	public java.math.BigDecimal getID_M_KojoRisoku() {
		return ID_M_KojoRisoku;
	}

	/**
	 * 控除利息を設定します。
	 *
	 * @param ID_M_KojoRisoku
	 *            控除利息
	 */
	public void setID_M_KojoRisoku(java.math.BigDecimal ID_M_KojoRisoku) {
		this.ID_M_KojoRisoku = ID_M_KojoRisoku;
	}

	/**
	 * 請求繰上償還元金を取得します。
	 *
	 * @return 請求繰上償還元金
	 */
	public java.math.BigDecimal getID_M_SeiKuriGankin() {
		return ID_M_SeiKuriGankin;
	}

	/**
	 * 請求繰上償還元金を設定します。
	 *
	 * @param ID_M_SeiKuriGankin
	 *            請求繰上償還元金
	 */
	public void setID_M_SeiKuriGankin(java.math.BigDecimal ID_M_SeiKuriGankin) {
		this.ID_M_SeiKuriGankin = ID_M_SeiKuriGankin;
	}

	/**
	 * 請求繰上償還利息を取得します。
	 *
	 * @return 請求繰上償還利息
	 */
	public java.math.BigDecimal getID_M_SeiKuriRisoku() {
		return ID_M_SeiKuriRisoku;
	}

	/**
	 * 請求繰上償還利息を設定します。
	 *
	 * @param ID_M_SeiKuriRisoku
	 *            請求繰上償還利息
	 */
	public void setID_M_SeiKuriRisoku(java.math.BigDecimal ID_M_SeiKuriRisoku) {
		this.ID_M_SeiKuriRisoku = ID_M_SeiKuriRisoku;
	}

	/**
	 * 任意繰上償還利息を取得します。
	 *
	 * @return 任意繰上償還利息
	 */
	public java.math.BigDecimal getID_M_NinKuriRisoku() {
		return ID_M_NinKuriRisoku;
	}

	/**
	 * 任意繰上償還利息を設定します。
	 *
	 * @param ID_M_NinKuriRisoku
	 *            任意繰上償還利息
	 */
	public void setID_M_NinKuriRisoku(java.math.BigDecimal ID_M_NinKuriRisoku) {
		this.ID_M_NinKuriRisoku = ID_M_NinKuriRisoku;
	}

	/**
	 * 債権管理番号を取得します。
	 *
	 * @return 債権管理番号
	 */
	public java.math.BigDecimal getID_Credit() {
		return ID_Credit;
	}

	/**
	 * 債権管理番号を設定します。
	 *
	 * @param ID_Credit
	 *            債権管理番号
	 */
	public void setID_Credit(java.math.BigDecimal ID_Credit) {
		this.ID_Credit = ID_Credit;
	}

	/**
	 * 実行年月日を取得します。
	 *
	 * @return 実行年月日
	 */
	public String getDate_Jikko() {
		return Date_Jikko;
	}

	/**
	 * 実行年月日を設定します。
	 *
	 * @param Date_Jikko
	 *            実行年月日
	 */
	public void setDate_Jikko(String Date_Jikko) {
		this.Date_Jikko = Date_Jikko;
	}

	/**
	 * 特利有効年月日を取得します。
	 *
	 * @return 特利有効年月日
	 */
	public String getDate_TokuriYuko() {
		return Date_TokuriYuko;
	}

	/**
	 * 特利有効年月日を設定します。
	 *
	 * @param Date_TokuriYuko
	 *            特利有効年月日
	 */
	public void setDate_TokuriYuko(String Date_TokuriYuko) {
		this.Date_TokuriYuko = Date_TokuriYuko;
	}

	/**
	 * 特利を取得します。
	 *
	 * @return 特利
	 */
	public java.math.BigDecimal getTokuri() {
		return Tokuri;
	}

	/**
	 * 特利を設定します。
	 *
	 * @param Tokuri
	 *            特利
	 */
	public void setTokuri(java.math.BigDecimal Tokuri) {
		this.Tokuri = Tokuri;
	}

	/**
	 * 利率を取得します。
	 *
	 * @return 利率
	 */
	public java.math.BigDecimal getRiritsu() {
		return Riritsu;
	}

	/**
	 * 利率を設定します。
	 *
	 * @param Riritsu
	 *            利率
	 */
	public void setRiritsu(java.math.BigDecimal Riritsu) {
		this.Riritsu = Riritsu;
	}

	/**
	 * 償還方法コードを取得します。
	 *
	 * @return 償還方法コード
	 */
	public String getCode_ShokanHouhou() {
		return Code_ShokanHouhou;
	}

	/**
	 * 償還方法コードを設定します。
	 *
	 * @param Code_ShokanHouhou
	 *            償還方法コード
	 */
	public void setCode_ShokanHouhou(String Code_ShokanHouhou) {
		this.Code_ShokanHouhou = Code_ShokanHouhou;
	}

	/**
	 * 約定利息計を取得します。
	 *
	 * @return 約定利息計
	 */
	public BigDecimal getLblID_M_YakujoRisokuKEI() {
		return lblID_M_YakujoRisokuKEI;
	}

	/**
	 * 約定利息計を設定します。
	 *
	 * @param lblID_M_YakujoRisokuKEI
	 *            約定利息計
	 */
	public void setLblID_M_YakujoRisokuKEI(BigDecimal lblID_M_YakujoRisokuKEI) {
		this.lblID_M_YakujoRisokuKEI = lblID_M_YakujoRisokuKEI;
	}

	/**
	 * 約定元金計を取得します。
	 *
	 * @return 約定元金計
	 */
	public BigDecimal getLblID_M_YakujoGankinKEI() {
		return lblID_M_YakujoGankinKEI;
	}

	/**
	 * 約定元金計を設定します。
	 *
	 * @param lblID_M_YakujoGankinKEI
	 *            約定元金計
	 */
	public void setLblID_M_YakujoGankinKEI(BigDecimal lblID_M_YakujoGankinKEI) {
		this.lblID_M_YakujoGankinKEI = lblID_M_YakujoGankinKEI;
	}

	/**
	 * 控除利息計を取得します。
	 *
	 * @return 控除利息計
	 */
	public BigDecimal getLblID_M_KojoRisokuKEI() {
		return lblID_M_KojoRisokuKEI;
	}

	/**
	 * 控除利息計を設定します。
	 *
	 * @param lblID_M_KojoRisokuKEI
	 *            控除利息計
	 */
	public void setLblID_M_KojoRisokuKEI(BigDecimal lblID_M_KojoRisokuKEI) {
		this.lblID_M_KojoRisokuKEI = lblID_M_KojoRisokuKEI;
	}

	/**
	 * 請求繰上償還元金計を取得します。
	 *
	 * @return 請求繰上償還元金計
	 */
	public BigDecimal getLblID_M_SeiKuriGankinKEI() {
		return lblID_M_SeiKuriGankinKEI;
	}

	/**
	 * 請求繰上償還元金計を設定します。
	 *
	 * @param lblID_M_SeiKuriGankinKEI
	 *            請求繰上償還元金計
	 */
	public void setLblID_M_SeiKuriGankinKEI(BigDecimal lblID_M_SeiKuriGankinKEI) {
		this.lblID_M_SeiKuriGankinKEI = lblID_M_SeiKuriGankinKEI;
	}

	/**
	 * 請求繰上償還利息計を取得します。
	 *
	 * @return 請求繰上償還利息計
	 */
	public BigDecimal getLblID_M_SeiKuriRisokuKEI() {
		return lblID_M_SeiKuriRisokuKEI;
	}

	/**
	 * 請求繰上償還利息計を設定します。
	 *
	 * @param lblID_M_SeiKuriRisokuKEI
	 *            請求繰上償還利息計
	 */
	public void setLblID_M_SeiKuriRisokuKEI(BigDecimal lblID_M_SeiKuriRisokuKEI) {
		this.lblID_M_SeiKuriRisokuKEI = lblID_M_SeiKuriRisokuKEI;
	}

	/**
	 * 任意繰上償還利息計を取得します。
	 *
	 * @return 任意繰上償還利息計
	 */
	public BigDecimal getLblID_M_NiniRisokuKEI() {
		return lblID_M_NiniRisokuKEI;
	}

	/**
	 * 任意繰上償還利息計を設定します。
	 *
	 * @param lblID_M_NiniRisokuKEI
	 *            任意繰上償還利息計
	 */
	public void setLblID_M_NiniRisokuKEI(BigDecimal lblID_M_NiniRisokuKEI) {
		this.lblID_M_NiniRisokuKEI = lblID_M_NiniRisokuKEI;
	}

	/**
	 * 合計行表示フラグを取得します。
	 *
	 * @param totalDisplayFlg
	 *            合計行表示フラグ
	 */
	public String getTotalDisplayFlg() {
		return totalDisplayFlg;
	}

	/**
	 * 合計行表示フラグを設定します。
	 *
	 * @param totalDisplayFlg
	 *            合計行表示フラグ
	 */
	public void setTotalDisplayFlg(String totalDisplayFlg) {
		this.totalDisplayFlg = totalDisplayFlg;
	}
}