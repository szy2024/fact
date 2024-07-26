//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd001_01ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Md001_01ResultsDataEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 扱店を取得します。
	 *
	 * @return 扱店
	 */
	public String getCode_Organization() {
		return (String) getValue("Code_Organization");
	}

	/**
	 * 扱店を設定します。
	 *
	 * @param Code_Organization
	 *            扱店
	 */
	public void setCode_Organization(String Code_Organization) {
		setValue("Code_Organization", Code_Organization);
	}

	/**
	 * 報告年月日を取得します。
	 *
	 * @return 報告年月日
	 */
	public String getDate_Report() {
		return (String) getValue("Date_Report");
	}

	/**
	 * 報告年月日を設定します。
	 *
	 * @param Date_Report
	 *            報告年月日
	 */
	public void setDate_Report(String Date_Report) {
		setValue("Date_Report", Date_Report);
	}

	/**
	 * 報告書番号を取得します。
	 *
	 * @return 報告書番号
	 */
	public String getID_Report() {
		return (String) getValue("ID_Report");
	}

	/**
	 * 報告書番号を設定します。
	 *
	 * @param ID_Report
	 *            報告書番号
	 */
	public void setID_Report(String ID_Report) {
		setValue("ID_Report", ID_Report);
	}

	/**
	 * ステータス（値）を取得します。
	 *
	 * @return ステータス
	 */
	public java.math.BigDecimal getStatus() {
		return (java.math.BigDecimal) getValue("Status");
	}

	/**
	 * ステータス（値）を設定します。
	 *
	 * @param Status
	 *            ステータス（値）
	 */
	public void setStatus(java.math.BigDecimal Status) {
		setValue("Status", Status);
	}

	/**
	 * 報告年月日２を取得します。
	 *
	 * @return 報告年月日２
	 */
	public String getID_Date_Report() {
		return (String) getValue("ID_Date_Report");
	}

	/**
	 * 報告年月日２を設定します。
	 *
	 * @param ID_Date_Report
	 *            報告年月日２
	 */
	public void setID_Date_Report(String ID_Date_Report) {
		setValue("ID_Date_Report", ID_Date_Report);
	}

	/**
	 * 報告書番号２を取得します。
	 *
	 * @return 報告書番号２
	 */
	public String getID_ID_Report() {
		return (String) getValue("ID_ID_Report");
	}

	/**
	 * 報告書番号２を設定します。
	 *
	 * @param ID_ID_Report
	 *            報告書番号２
	 */
	public void setID_ID_Report(String ID_ID_Report) {
		setValue("ID_ID_Report", ID_ID_Report);
	}

	/**
	 * ステータスを取得します。
	 *
	 * @return ステータス
	 */
	public String getID_ErrorMessage() {
		return (String) getValue("ID_ErrorMessage");
	}

	/**
	 * ステータスを設定します。
	 *
	 * @param ID_ErrorMessage
	 *            ステータス
	 */
	public void setID_ErrorMessage(String ID_ErrorMessage) {
		setValue("ID_ErrorMessage", ID_ErrorMessage);
	}

	/**
	 * 顧客名を取得します。
	 *
	 * @return 顧客名
	 */
	public String getID_Name_Customer() {
		return (String) getValue("ID_Name_Customer");
	}

	/**
	 * 顧客名を設定します。
	 *
	 * @param ID_Name_Customer
	 *            顧客名
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		setValue("ID_Name_Customer", ID_Name_Customer);
	}

	/**
	 * 扱店名を取得します。
	 *
	 * @return 扱店名
	 */
	public String getID_Name_Organization() {
		return (String) getValue("ID_Name_Organization");
	}

	/**
	 * 扱店名を設定します。
	 *
	 * @param ID_Name_Organization
	 *            扱店名
	 */
	public void setID_Name_Organization(String ID_Name_Organization) {
		setValue("ID_Name_Organization", ID_Name_Organization);
	}

	/**
	 * 公庫支店を取得します。
	 *
	 * @return 公庫支店
	 */
	public String getID_Code_KoukoShiten() {
		return (String) getValue("ID_Code_KoukoShiten");
	}

	/**
	 * 公庫支店を設定します。
	 *
	 * @param ID_Code_KoukoShiten
	 *            公庫支店
	 */
	public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
		setValue("ID_Code_KoukoShiten", ID_Code_KoukoShiten);
	}

	/**
	 * 扱店２を取得します。
	 *
	 * @return 扱店２
	 */
	public String getID_Code_Organization() {
		return (String) getValue("ID_Code_Organization");
	}

	/**
	 * 扱店２を設定します。
	 *
	 * @param ID_Code_Organization
	 *            扱店２
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		setValue("ID_Code_Organization", ID_Code_Organization);
	}

	/**
	 * 店舗を取得します。
	 *
	 * @return 店舗
	 */
	public String getID_Code_Tenpo() {
		return (String) getValue("ID_Code_Tenpo");
	}

	/**
	 * 店舗を設定します。
	 *
	 * @param ID_Code_Tenpo
	 *            店舗
	 */
	public void setID_Code_Tenpo(String ID_Code_Tenpo) {
		setValue("ID_Code_Tenpo", ID_Code_Tenpo);
	}

	/**
	 * 年度を取得します。
	 *
	 * @return 年度
	 */
	public String getID_Year() {
		return (String) getValue("ID_Year");
	}

	/**
	 * 年度を設定します。
	 *
	 * @param ID_Year
	 *            年度
	 */
	public void setID_Year(String ID_Year) {
		setValue("ID_Year", ID_Year);
	}

	/**
	 * 方式資金を取得します。
	 *
	 * @return 方式資金
	 */
	public String getID_Code_HoshikiShikin() {
		return (String) getValue("ID_Code_HoshikiShikin");
	}

	/**
	 * 方式資金を設定します。
	 *
	 * @param ID_Code_HoshikiShikin
	 *            方式資金
	 */
	public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
		setValue("ID_Code_HoshikiShikin", ID_Code_HoshikiShikin);
	}

	/**
	 * 番号を取得します。
	 *
	 * @return 番号
	 */
	public String getID_ID_Ringi() {
		return (String) getValue("ID_ID_Ringi");
	}

	/**
	 * 番号を設定します。
	 *
	 * @param ID_ID_Ringi
	 *            番号
	 */
	public void setID_ID_Ringi(String ID_ID_Ringi) {
		setValue("ID_ID_Ringi", ID_ID_Ringi);
	}

	/**
	 * 枝番を取得します。
	 *
	 * @return 枝番
	 */
	public String getID_ID_RingiBranch() {
		return (String) getValue("ID_ID_RingiBranch");
	}

	/**
	 * 枝番を設定します。
	 *
	 * @param ID_ID_RingiBranch
	 *            枝番
	 */
	public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
		setValue("ID_ID_RingiBranch", ID_ID_RingiBranch);
	}

	/**
	 * 資金使途を取得します。
	 *
	 * @return 資金使途
	 */
	public String getID_Code_ShikinShito() {
		return (String) getValue("ID_Code_ShikinShito");
	}

	/**
	 * 資金使途を設定します。
	 *
	 * @param ID_Code_ShikinShito
	 *            資金使途
	 */
	public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
		setValue("ID_Code_ShikinShito", ID_Code_ShikinShito);
	}

	/**
	 * 事業別を取得します。
	 *
	 * @return 事業別
	 */
	public String getID_Code_Jigyobetsu() {
		return (String) getValue("ID_Code_Jigyobetsu");
	}

	/**
	 * 事業別を設定します。
	 *
	 * @param ID_Code_Jigyobetsu
	 *            事業別
	 */
	public void setID_Code_Jigyobetsu(String ID_Code_Jigyobetsu) {
		setValue("ID_Code_Jigyobetsu", ID_Code_Jigyobetsu);
	}

	/**
	 * 利率(%)を取得します。
	 *
	 * @return 利率(%)
	 */
	public String getID_Riritsu() {
		return (String) getValue("ID_Riritsu");
	}

	/**
	 * 利率(%)を設定します。
	 *
	 * @param ID_Riritsu
	 *            利率(%)
	 */
	public void setID_Riritsu(String ID_Riritsu) {
		setValue("ID_Riritsu", ID_Riritsu);
	}

	/**
	 * 特利区分を取得します。
	 *
	 * @return 特利区分
	 */
	public String getID_Kubun_Tokuri() {
		return (String) getValue("ID_Kubun_Tokuri");
	}

	/**
	 * 特利区分を設定します。
	 *
	 * @param ID_Kubun_Tokuri
	 *            特利区分
	 */
	public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
		setValue("ID_Kubun_Tokuri", ID_Kubun_Tokuri);
	}

	/**
	 * 特利(%)を取得します。
	 *
	 * @return 特利(%)
	 */
	public String getID_Tokuri() {
		return (String) getValue("ID_Tokuri");
	}

	/**
	 * 特利(%)を設定します。
	 *
	 * @param ID_Tokuri
	 *            特利(%)
	 */
	public void setID_Tokuri(String ID_Tokuri) {
		setValue("ID_Tokuri", ID_Tokuri);
	}

	/**
	 * 据置期限を取得します。
	 *
	 * @return 据置期限
	 */
	public String getID_Date_SueokiKigen() {
		return (String) getValue("ID_Date_SueokiKigen");
	}

	/**
	 * 据置期限を設定します。
	 *
	 * @param ID_Date_SueokiKigen
	 *            据置期限
	 */
	public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
		setValue("ID_Date_SueokiKigen", ID_Date_SueokiKigen);
	}

	/**
	 * 償還期限を取得します。
	 *
	 * @return 償還期限
	 */
	public String getID_Date_ShokanKigen() {
		return (String) getValue("ID_Date_ShokanKigen");
	}

	/**
	 * 償還期限を設定します。
	 *
	 * @param ID_Date_ShokanKigen
	 *            償還期限
	 */
	public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
		setValue("ID_Date_ShokanKigen", ID_Date_ShokanKigen);
	}

	/**
	 * 元利金払込日を取得します。
	 *
	 * @return 元利金払込日
	 */
	public String getID_Date_GanrikinHaraikomi() {
		return (String) getValue("ID_Date_GanrikinHaraikomi");
	}

	/**
	 * 元利金払込日を設定します。
	 *
	 * @param ID_Date_GanrikinHaraikomi
	 *            元利金払込日
	 */
	public void setID_Date_GanrikinHaraikomi(String ID_Date_GanrikinHaraikomi) {
		setValue("ID_Date_GanrikinHaraikomi", ID_Date_GanrikinHaraikomi);
	}

	/**
	 * 受託者勘定処理年月を取得します。
	 *
	 * @return 受託者勘定処理年月
	 */
	public String getID_Date_Jtkshori() {
		return (String) getValue("ID_Date_Jtkshori");
	}

	/**
	 * 受託者勘定処理年月を設定します。
	 *
	 * @param ID_Date_Jtkshori
	 *            受託者勘定処理年月
	 */
	public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
		setValue("ID_Date_Jtkshori", ID_Date_Jtkshori);
	}

	/**
	 * 貸付実行日を取得します。
	 *
	 * @return 貸付実行日
	 */
	public String getID_Date_Kashitsukejikko() {
		return (String) getValue("ID_Date_Kashitsukejikko");
	}

	/**
	 * 貸付実行日を設定します。
	 *
	 * @param ID_Date_Kashitsukejikko
	 *            貸付実行日
	 */
	public void setID_Date_Kashitsukejikko(String ID_Date_Kashitsukejikko) {
		setValue("ID_Date_Kashitsukejikko", ID_Date_Kashitsukejikko);
	}

	/**
	 * 貸付実行額を取得します。
	 *
	 * @return 貸付実行額
	 */
	public java.math.BigDecimal getID_M_Kashitsuke() {
		return (java.math.BigDecimal) getValue("ID_M_Kashitsuke");
	}

	/**
	 * 貸付実行額を設定します。
	 *
	 * @param ID_M_Kashitsuke
	 *            貸付実行額
	 */
	public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
		setValue("ID_M_Kashitsuke", ID_M_Kashitsuke);
	}

	/**
	 * 資金交付額を取得します。
	 *
	 * @return 資金交付額
	 */
	public java.math.BigDecimal getID_M_ShikinKofu() {
		return (java.math.BigDecimal) getValue("ID_M_ShikinKofu");
	}

	/**
	 * 資金交付額を設定します。
	 *
	 * @param ID_M_ShikinKofu
	 *            資金交付額
	 */
	public void setID_M_ShikinKofu(java.math.BigDecimal ID_M_ShikinKofu) {
		setValue("ID_M_ShikinKofu", ID_M_ShikinKofu);
	}

	/**
	 * 貸付受入金受入額を取得します。
	 *
	 * @return 貸付受入金受入額
	 */
	public java.math.BigDecimal getID_M_KashitukeUkeire() {
		return (java.math.BigDecimal) getValue("ID_M_KashitukeUkeire");
	}

	/**
	 * 貸付受入金受入額を設定します。
	 *
	 * @param ID_M_KashitukeUkeire
	 *            貸付受入金受入額
	 */
	public void setID_M_KashitukeUkeire(
			java.math.BigDecimal ID_M_KashitukeUkeire) {
		setValue("ID_M_KashitukeUkeire", ID_M_KashitukeUkeire);
	}

	/**
	 * 履歴番号（非表示）を取得します。
	 *
	 * @return 履歴番号（非表示）
	 */
	public String getID_ID_History() {
		return (String) getValue("ID_ID_History");
	}

	/**
	 * 履歴番号（非表示）を設定します。
	 *
	 * @param ID_ID_History
	 *            履歴番号（非表示）
	 */
	public void setID_ID_History(String ID_ID_History) {
		setValue("ID_ID_History", ID_ID_History);
	}

	/**
	 * 処理種別（非表示）を取得します。
	 *
	 * @return 処理種別（非表示）
	 */
	public String getID_Type_Process() {
		return (String) getValue("ID_Type_Process");
	}

	/**
	 * 処理種別（非表示）を設定します。
	 *
	 * @param ID_Type_Process
	 *            処理種別（非表示）
	 */
	public void setID_Type_Process(String ID_Type_Process) {
		setValue("ID_Type_Process", ID_Type_Process);
	}

	/**
	 * 取消済みフラグ（非表示）を取得します。
	 *
	 * @return 取消済みフラグ（非表示）
	 */
	public String getID_Flag_Torikeshizumi() {
		return (String) getValue("ID_Flag_Torikeshizumi");
	}

	/**
	 * 取消済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Flag_Torikeshizumi
	 *            取消済みフラグ（非表示）
	 */
	public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
		setValue("ID_Flag_Torikeshizumi", ID_Flag_Torikeshizumi);
	}

	/**
	 * エラーコード（非表示）を取得します。
	 *
	 * @return エラーコード（非表示）
	 */
	public String getID_Code_Error() {
		return (String) getValue("ID_Code_Error");
	}

	/**
	 * エラーコード（非表示）を設定します。
	 *
	 * @param ID_Code_Error
	 *            エラーコード（非表示）
	 */
	public void setID_Code_Error(String ID_Code_Error) {
		setValue("ID_Code_Error", ID_Code_Error);
	}

	/**
	 * 債権管理番号（非表示）を取得します。
	 *
	 * @return 債権管理番号（非表示）
	 */
	public String getID_ID_Credit() {
		return (String) getValue("ID_ID_Credit");
	}

	/**
	 * 債権管理番号（非表示）を設定します。
	 *
	 * @param ID_ID_Credit
	 *            債権管理番号（非表示）
	 */
	public void setID_ID_Credit(String ID_ID_Credit) {
		setValue("ID_ID_Credit", ID_ID_Credit);
	}

	/**
	 * 伝送番号（非表示）を取得します。
	 *
	 * @return 伝送番号（非表示）
	 */
	public String getID_ID_Denso() {
		return (String) getValue("ID_ID_Denso");
	}

	/**
	 * 伝送番号（非表示）を設定します。
	 *
	 * @param ID_ID_Denso
	 *            伝送番号（非表示）
	 */
	public void setID_ID_Denso(String ID_ID_Denso) {
		setValue("ID_ID_Denso", ID_ID_Denso);
	}

	/**
	 * 貸付件数（非表示）を取得します。
	 *
	 * @return 貸付件数（非表示）
	 */
	public String getID_Count_Kashitsuke() {
		return (String) getValue("ID_Count_Kashitsuke");
	}

	/**
	 * 貸付件数（非表示）を設定します。
	 *
	 * @param ID_Count_Kashitsuke
	 *            貸付件数（非表示）
	 */
	public void setID_Count_Kashitsuke(String ID_Count_Kashitsuke) {
		setValue("ID_Count_Kashitsuke", ID_Count_Kashitsuke);
	}

	/**
	 * 原本番号（非表示）を取得します。
	 *
	 * @return 原本番号（非表示）
	 */
	public String getID_ID_Maste() {
		return (String) getValue("ID_ID_Maste");
	}

	/**
	 * 原本番号（非表示）を設定します。
	 *
	 * @param ID_ID_Maste
	 *            原本番号（非表示）
	 */
	public void setID_ID_Maste(String ID_ID_Maste) {
		setValue("ID_ID_Maste", ID_ID_Maste);
	}

	/**
	 * 署名データ（非表示）を取得します。
	 *
	 * @return 署名データ（非表示）
	 */
	public String getID_SignData() {
		return (String) getValue("ID_SignData");
	}

	/**
	 * 署名データ（非表示）を設定します。
	 *
	 * @param ID_SignData
	 *            署名データ（非表示）
	 */
	public void setID_SignData(String ID_SignData) {
		setValue("ID_SignData", ID_SignData);
	}

	/**
	 * ステータス（値）（非表示）を取得します。
	 *
	 * @return ステータス（値）（非表示）
	 */
	public String getID_Status() {
		return (String) getValue("ID_Status");
	}

	/**
	 * ステータス（値）（非表示）を設定します。
	 *
	 * @param ID_Status
	 *            ステータス（値）（非表示）
	 */
	public void setID_Status(String ID_Status) {
		setValue("ID_Status", ID_Status);
	}

	/**
	 * データコード（非表示）を取得します。
	 *
	 * @return データコード（非表示）
	 */
	public String getID_DataCode() {
		return (String) getValue("ID_DataCode");
	}

	/**
	 * データコード（非表示）を設定します。
	 *
	 * @param ID_DataCode
	 *            データコード（非表示）
	 */
	public void setID_DataCode(String ID_DataCode) {
		setValue("ID_DataCode", ID_DataCode);
	}

	/**
	 * ユーザID（非表示）を取得します。
	 *
	 * @return ユーザID（非表示）
	 */
	public String getID_UserID() {
		return (String) getValue("ID_UserID");
	}

	/**
	 * ユーザID（非表示）を設定します。
	 *
	 * @param ID_UserID
	 *            ユーザID（非表示）
	 */
	public void setID_UserID(String ID_UserID) {
		setValue("ID_UserID", ID_UserID);
	}

	/**
	 * 報告時分秒（非表示）を取得します。
	 *
	 * @return 報告時分秒（非表示）
	 */
	public String getID_Time_Report() {
		return (String) getValue("ID_Time_Report");
	}

	/**
	 * 報告時分秒（非表示）を設定します。
	 *
	 * @param ID_Time_Report
	 *            報告時分秒（非表示）
	 */
	public void setID_Time_Report(String ID_Time_Report) {
		setValue("ID_Time_Report", ID_Time_Report);
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）を取得します。
	 *
	 * @return 貸付実行作成済みフラグ（非表示）
	 */
	public String getID_Flag_Kj() {
		return (String) getValue("ID_Flag_Kj");
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Flag_Kj
	 *            貸付実行作成済みフラグ（非表示）
	 */
	public void setID_Flag_Kj(String ID_Flag_Kj) {
		setValue("ID_Flag_Kj", ID_Flag_Kj);
	}

	/**
	 * 顧客コード（非表示）を取得します。
	 *
	 * @return 顧客コード（非表示）
	 */
	public String getID_Code_Customer() {
		return (String) getValue("ID_Code_Customer");
	}

	/**
	 * 顧客コード（非表示）を設定します。
	 *
	 * @param ID_Code_Customer
	 *            顧客コード（非表示）
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		setValue("ID_Code_Customer", ID_Code_Customer);
	}

	/**
	 * 実行起算予定日（非表示）を取得します。
	 *
	 * @return 実行起算予定日（非表示）
	 */
	public String getID_Date_JuriKisan() {
		return (String) getValue("ID_Date_JuriKisan");
	}

	/**
	 * 実行起算予定日（非表示）を設定します。
	 *
	 * @param ID_Date_JuriKisan
	 *            実行起算予定日（非表示）
	 */
	public void setID_Date_JuriKisan(String ID_Date_JuriKisan) {
		setValue("ID_Date_JuriKisan", ID_Date_JuriKisan);
	}

	/**
	 * 決定起算年月日（非表示）を取得します。
	 *
	 * @return 決定起算年月日（非表示）
	 */
	public String getID_Date_KetteiKisan() {
		return (String) getValue("ID_Date_KetteiKisan");
	}

	/**
	 * 決定起算年月日（非表示）を設定します。
	 *
	 * @param ID_Date_KetteiKisan
	 *            決定起算年月日（非表示）
	 */
	public void setID_Date_KetteiKisan(String ID_Date_KetteiKisan) {
		setValue("ID_Date_KetteiKisan", ID_Date_KetteiKisan);
	}

	/**
	 * 退避償還期限年月（非表示）を取得します。
	 *
	 * @return 退避償還期限年月（非表示）
	 */
	public String getID_Keep_Date_ShokanKigen() {
		return (String) getValue("ID_Keep_Date_ShokanKigen");
	}

	/**
	 * 退避償還期限年月（非表示）を設定します。
	 *
	 * @param ID_Keep_Date_ShokanKigen
	 *            退避償還期限年月（非表示）
	 */
	public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
		setValue("ID_Keep_Date_ShokanKigen", ID_Keep_Date_ShokanKigen);
	}

	/**
	 * 退避実行済みフラグ（非表示）を取得します。
	 *
	 * @return 退避実行済みフラグ（非表示）
	 */
	public String getID_Keep_Flag_Kj() {
		return (String) getValue("ID_Keep_Flag_Kj");
	}

	/**
	 * 退避実行済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Keep_Flag_Kj
	 *            退避実行済みフラグ（非表示）
	 */
	public void setID_Keep_Flag_Kj(String ID_Keep_Flag_Kj) {
		setValue("ID_Keep_Flag_Kj", ID_Keep_Flag_Kj);
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）を取得します。
	 *
	 * @return 扱店別稟議データより取得した実行済みフラグ（非表示）
	 */
	public String getID_aRingi_Flag_Kj() {
		return (String) getValue("ID_aRingi_Flag_Kj");
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）を設定します。
	 *
	 * @param ID_aRingi_Flag_Kj
	 *            扱店別稟議データより取得した実行済みフラグ（非表示）
	 */
	public void setID_aRingi_Flag_Kj(String ID_aRingi_Flag_Kj) {
		setValue("ID_aRingi_Flag_Kj", ID_aRingi_Flag_Kj);
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を取得します。
	 *
	 * @return 扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public String getID_aRingi_Date_ShokanKigen() {
		return (String) getValue("ID_aRingi_Date_ShokanKigen");
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を設定します。
	 *
	 * @param ID_aRingi_Date_ShokanKigen
	 *            扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public void setID_aRingi_Date_ShokanKigen(String ID_aRingi_Date_ShokanKigen) {
		setValue("ID_aRingi_Date_ShokanKigen", ID_aRingi_Date_ShokanKigen);
	}

	/**
	 * 扱店別稟議データの利率を取得します。
	 *
	 * @return 扱店別稟議データの利率
	 */
	public String getID_aRingi_Riritsu() {
		return (String) getValue("ID_aRingi_Riritsu");
	}

	/**
	 * 扱店別稟議データの利率を設定します。
	 *
	 * @param ID_aRingi_Riritsu
	 *            扱店別稟議データの利率
	 */
	public void setID_aRingi_Riritsu(String ID_aRingi_Riritsu) {
		setValue("ID_aRingi_Riritsu", ID_aRingi_Riritsu);
	}

	/**
	 * 扱店別稟議データの特利を取得します。
	 *
	 * @return 扱店別稟議データの特利
	 */
	public String getID_aRingi_Tokuri() {
		return (String) getValue("ID_aRingi_Tokuri");
	}

	/**
	 * 扱店別稟議データの特利を設定します。
	 *
	 * @param ID_aRingi_Tokuri
	 *            扱店別稟議データの特利
	 */
	public void setID_aRingi_Tokuri(String ID_aRingi_Tokuri) {
		setValue("ID_aRingi_Tokuri", ID_aRingi_Tokuri);
	}

	/**
	 * 最新データ更新日付（非表示）を取得します。
	 *
	 * @return 最新データ更新日付（非表示）
	 */
	public String getID_Data_LastUpDate() {
		return (String) getValue("ID_Data_LastUpDate");
	}

	/**
	 * 最新データ更新日付（非表示）を設定します。
	 *
	 * @param ID_Data_LastUpDate
	 *            最新データ更新日付（非表示）
	 */
	public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
		setValue("ID_Data_LastUpDate", ID_Data_LastUpDate);
	}

	/**
	 * 扱店別稟議データより取得した退避履歴番号(非表示)を取得します。
	 *
	 * @return 扱店別稟議データより取得した退避履歴番号(非表示)
	 */
	public String getID_keep_ID_History() {
		return (String) getValue("ID_keep_ID_History");
	}

	/**
	 * 退避履歴番号(非表示)を設定します。
	 *
	 * @param ID_keep_ID_History
	 *            退避履歴番号(非表示)
	 */
	public void setID_keep_ID_History(String ID_keep_ID_History) {
		setValue("ID_keep_ID_History", ID_keep_ID_History);
	}

}