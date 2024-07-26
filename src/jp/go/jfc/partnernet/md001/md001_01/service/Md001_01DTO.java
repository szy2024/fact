//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはmd001_01のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Md001_01DTO extends PNBaseDTO {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 報告年月日 */
	private String txtID_Date_Report;
	/** エラー */
	private String lblErr;
	/** メッセージ */
	private String lblMessage;
	/** 赤データ入力領域タイトル */
	private String lblID_Head_Red;
	/** 顧客名 */
	private String txtID_Name_Customer_Red;
	/** 扱店名 */
	private String txtID_Name_Organization_Red;
	/** 公庫支店 */
	private String txtID_Code_KoukoShiten_Red;
	/** 扱店 */
	private String txtID_Code_Organization_Red;
	/** 店舗 */
	private String txtID_Code_Tenpo_Red;
	/** 年度 */
	private String txtID_Year_Red;
	/** 方式資金 */
	private String txtID_Code_HoshikiShikin_Red;
	/** 番号 */
	private String txtID_ID_Ringi_Red;
	/** 枝番 */
	private String txtID_ID_RingiBranch_Red;
	/** 資金使途 */
	private String txtID_Code_ShikinShito_Red;
	/** 事業別 */
	private String txtID_Code_Jigyobetsu_Red;
	/** 利率（％） */
	private String txtID_Riritsu_Red;
	/** 特利区分 */
	private String txtID_Kubun_Tokuri_Red;
	/** 特利（％） */
	private String txtID_Tokuri_Red;
	/** 据置期限 */
	private String txtID_Date_SueokiKigen_Red;
	/** 償還期限 */
	private String txtID_Date_ShokanKigen_Red;
	/** 受託者勘定処理年月 */
	private String txtID_Date_Jtkshori_Red;
	/** 元利金払込日 */
	private String txtID_Date_GanrikinHaraikomi_Red;
	/** 貸付実行日 */
	private String txtID_Date_Kashitsukejikko_Red;
	/** 貸付実行金額(円) */
	private String txtID_M_Kashitsuke_Red;
	/** 資金交付額(円) */
	private String txtID_M_ShikinKofu_Red;
	/** 貸付受入金受入額(円) */
	private String txtID_M_KashitukeUkeire_Red;
	/** 受託者勘定処理年月(元号) */
	private String ID_Date_Jtkshori_Gengo_Red;
	/** 受託者勘定処理年月(年) */
	private String ID_Date_Jtkshori_Nen_Red;
	/** 受託者勘定処理年月(月) */
	private String drpID_Date_JtkshoriTsuki_Red;
	/** 黒データ入力領域タイトル */
	private String lblID_Head;
	/** 顧客名（修正） */
	private String txtID_Name_Customer;
	/** 扱店名（修正） */
	private String txtID_Name_Organization;
	/** 公庫支店（修正） */
	private String txtID_Code_KoukoShiten;
	/** 扱店（修正） */
	private String txtID_Code_Organization;
	/** 店舗（修正） */
	private String txtID_Code_Tenpo;
	/** 年度（修正） */
	private String txtID_Year;
	/** 方式資金（修正） */
	private String txtID_Code_HoshikiShikin;
	/** 番号（修正） */
	private String txtID_ID_Ringi;
	/** 枝番（修正） */
	private String txtID_ID_RingiBranch;
	/** 資金使途（修正） */
	private String txtID_Code_ShikinShito;
	/** 事業別（修正） */
	private String txtID_Code_Jigyobetsu;
	/** 利率（％）（修正） */
	private String txtID_Riritsu;
	/** 特利区分（修正） */
	private String txtID_Kubun_Tokuri;
	/** 特利（％）（修正） */
	private String txtID_Tokuri;
	/** 据置期限（修正） */
	private String txtID_Date_SueokiKigen;
	/** 償還期限（修正） */
	private String txtID_Date_ShokanKigen;
	/** 受託者勘定処理年月（修正） */
	private String txtID_Date_Jtkshori;
	/** 元利金払込日（修正） */
	private String txtID_Date_GanrikinHaraikomi;
	/** 貸付実行日（元号）（修正） */
	private String ID_Date_Kashitsukejikko_Gengo;
	/** 貸付実行日（年）（修正） */
	private String ID_Date_Kashitsukejikko_Nen;
	/** 貸付実行日（月）（修正） */
	private String drpID_Date_KashitsukejikkoTsuki;
	/** 貸付実行日（日）（修正） */
	private String drpID_Date_KashitsukejikkoBi;
	/** 貸付実行金額（修正） */
	private String txtID_M_Kashitsuke;
	/** 資金交付額（修正） */
	private String txtID_M_ShikinKofu;
	/** 貸付受入金受入額 */
	private String txtID_M_KashitukeUkeire;
	/** 受託者勘定処理年月(元号)（修正） */
	private String ID_Date_Jtkshori_Gengo;
	/** 受託者勘定処理年月(年)（修正） */
	private String ID_Date_Jtkshori_Nen;
	/** 受託者勘定処理年月(月)（修正） */
	private String drpID_Date_JtkshoriTsuki;
	/** 報告時分秒 */
	private String Time_Report;
	/** 報告書種別（値） */
	private String DataCode;
	/** ステータス */
	private String Status;
	/** 報告書番号 */
	private String ID_Report;
	/** 操作選択 */
	private String ID_OperationSelect;
	/** 処理種別 */
	private String Type_Process;
	/** エラー追加情報 */
	private String ErrAddInfo;
	/** モードタイプ */
	private String ModeType;
	/** 処理モード */
	private String ProcessMode;
	/** 履歴番号（非表示） */
	private String ID_ID_History_Red;
	/** 処理種別（非表示） */
	private String ID_Type_Process_Red;
	/** 取消済みフラグ（非表示） */
	private String ID_Flag_Torikeshizumi_Red;
	/** エラーコード（非表示） */
	private String ID_Code_Error_Red;
	/** 債権管理番号（非表示） */
	private String ID_ID_Credit_Red;
	/** 伝送番号（非表示） */
	private String ID_ID_Denso_Red;
	/** 貸付件数（非表示） */
	private String ID_Count_Kashitsuke_Red;
	/** 原本番号（非表示） */
	private String ID_ID_Maste_Red;
	/** 署名データ（非表示） */
	private String ID_SignData_Red;
	/** ステータス（値）（非表示） */
	private String ID_Status_Red;
	/** データコード（非表示） */
	private String ID_DataCode_Red;
	/** ユーザID（非表示） */
	private String ID_UserID_Red;
	/** 報告時分秒（非表示） */
	private String ID_Time_Report_Red;
	/** 貸付実行作成済みフラグ（非表示） */
	private String ID_Flag_Kj_Red;
	/** 顧客コード（非表示） */
	private String ID_Code_Customer_Red;
	/** 実行起算予定日（非表示） */
	private String ID_Date_JuriKisan_Red;
	/** 決定起算年月日（非表示） */
	private String ID_Date_KetteiKisan_Red;
	/** 退避償還期限年月（非表示） */
	private String ID_Keep_Date_ShokanKigen_Red;
	/** 退避履歴番号(非表示) */
	private String ID_keep_ID_History_Red;
	/** 退避実行済みフラグ（非表示） */
	private String ID_Keep_Flag_Kj_Red;
	/** 扱店別稟議データより取得した実行済みフラグ（非表示） */
	private String ID_aRingi_Flag_Kj_Red;
	/** 扱店別稟議データより取得した償還期限年月（非表示） */
	private String ID_aRingi_Date_ShokanKigen_Red;
	/** 扱店別稟議データの利率 */
	private String ID_aRingi_Riritsu_Red;
	/** 扱店別稟議データの特利 */
	private String ID_aRingi_Tokuri_Red;
	/** 最新データ更新日付（非表示） */
	private String ID_Data_LastUpDate_Red;
	/** 履歴番号（非表示）（修正） */
	private String ID_ID_History;
	/** 処理種別（非表示）（修正） */
	private String ID_Type_Process;
	/** 取消済みフラグ（非表示）（修正） */
	private String ID_Flag_Torikeshizumi;
	/** エラーコード（非表示）（修正） */
	private String ID_Code_Error;
	/** 債権管理番号（非表示）（修正） */
	private String ID_ID_Credit;
	/** 伝送番号（非表示）（修正） */
	private String ID_ID_Denso;
	/** 貸付件数（非表示）（修正） */
	private String ID_Count_Kashitsuke;
	/** 原本番号（非表示）（修正） */
	private String ID_ID_Maste;
	/** 署名データ（非表示）（修正） */
	private String ID_SignData;
	/** ステータス（値）（非表示）（修正） */
	private String ID_Status;
	/** データコード（非表示）（修正） */
	private String ID_DataCode;
	/** ユーザID（非表示）（修正） */
	private String ID_UserID;
	/** 報告時分秒（非表示）（修正） */
	private String ID_Time_Report;
	/** 貸付実行作成済みフラグ（非表示）（修正） */
	private String ID_Flag_Kj;
	/** 顧客コード（非表示）（修正） */
	private String ID_Code_Customer;
	/** 実行起算予定日（非表示）（修正） */
	private String ID_Date_JuriKisan;
	/** 決定起算年月日（非表示）（修正） */
	private String ID_Date_KetteiKisan;
	/** 退避償還期限年月（非表示）（修正） */
	private String ID_Keep_Date_ShokanKigen;
	/** 退避履歴番号(非表示)（修正） */
	private String ID_keep_ID_History;
	/** 退避実行済みフラグ（非表示）（修正） */
	private String ID_Keep_Flag_Kj;
	/** 扱店別稟議データより取得した実行済みフラグ（非表示）（修正） */
	private String ID_aRingi_Flag_Kj;
	/** 扱店別稟議データより取得した償還期限年月（非表示）（修正） */
	private String ID_aRingi_Date_ShokanKigen;
	/** 扱店別稟議データの利率（修正） */
	private String ID_aRingi_Riritsu;
	/** 扱店別稟議データの特利（修正） */
	private String ID_aRingi_Tokuri;
	/** 最新データ更新日付（非表示）（修正） */
	private String ID_Data_LastUpDate;

	/**
	 * <pre>
	 * コンストラクター。
	 * </pre>
	 *
	 */
	public Md001_01DTO() {
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
	public Md001_01DTO(Md001_01DTO orig) {
		super(orig);
	}

	/**
	 * 報告年月日を取得します。
	 * 
	 * @return 報告年月日
	 */
	public String getTxtID_Date_Report() {
		return txtID_Date_Report;
	}

	/**
	 * 報告年月日を設定します。
	 * 
	 * @param txtID_Date_Report
	 *            報告年月日
	 */
	public void setTxtID_Date_Report(String txtID_Date_Report) {
		this.txtID_Date_Report = txtID_Date_Report;
	}

	/**
	 * エラーを取得します。
	 * 
	 * @return エラー
	 */
	public String getLblErr() {
		return lblErr;
	}

	/**
	 * エラーを設定します。
	 * 
	 * @param lblErr
	 *            エラー
	 */
	public void setLblErr(String lblErr) {
		this.lblErr = lblErr;
	}

	/**
	 * メッセージを取得します。
	 * 
	 * @return メッセージ
	 */
	public String getLblMessage() {
		return lblMessage;
	}

	/**
	 * メッセージを設定します。
	 * 
	 * @param lblMessage
	 *            メッセージ
	 */
	public void setLblMessage(String lblMessage) {
		this.lblMessage = lblMessage;
	}

	/**
	 * 赤データ入力領域タイトルを取得します。
	 *
	 * @return 赤データ入力領域タイトル
	 */
	public String getLblID_Head_Red() {
		return lblID_Head_Red;
	}

	/**
	 * 赤データ入力領域タイトルを設定します。
	 *
	 * @param lblID_Head_Red
	 *            赤データ入力領域タイトル
	 */
	public void setLblID_Head_Red(String lblID_Head_Red) {
		this.lblID_Head_Red = lblID_Head_Red;
	}

	/**
	 * 顧客名を取得します。
	 * 
	 * @return 顧客名
	 */
	public String getTxtID_Name_Customer_Red() {
		return txtID_Name_Customer_Red;
	}

	/**
	 * 顧客名を設定します。
	 * 
	 * @param txtID_Name_Customer_Red
	 *            顧客名
	 */
	public void setTxtID_Name_Customer_Red(String txtID_Name_Customer_Red) {
		this.txtID_Name_Customer_Red = txtID_Name_Customer_Red;
	}

	/**
	 * 扱店名を取得します。
	 * 
	 * @return 扱店名
	 */
	public String getTxtID_Name_Organization_Red() {
		return txtID_Name_Organization_Red;
	}

	/**
	 * 扱店名を設定します。
	 * 
	 * @param txtID_Name_Organization_Red
	 *            扱店名
	 */
	public void setTxtID_Name_Organization_Red(
			String txtID_Name_Organization_Red) {
		this.txtID_Name_Organization_Red = txtID_Name_Organization_Red;
	}

	/**
	 * 公庫支店を取得します。
	 * 
	 * @return 公庫支店
	 */
	public String getTxtID_Code_KoukoShiten_Red() {
		return txtID_Code_KoukoShiten_Red;
	}

	/**
	 * 公庫支店を設定します。
	 * 
	 * @param txtID_Code_KoukoShiten_Red
	 *            公庫支店
	 */
	public void setTxtID_Code_KoukoShiten_Red(String txtID_Code_KoukoShiten_Red) {
		this.txtID_Code_KoukoShiten_Red = txtID_Code_KoukoShiten_Red;
	}

	/**
	 * 扱店を取得します。
	 * 
	 * @return 扱店
	 */
	public String getTxtID_Code_Organization_Red() {
		return txtID_Code_Organization_Red;
	}

	/**
	 * 扱店を設定します。
	 * 
	 * @param txtID_Code_Organization_Red
	 *            扱店
	 */
	public void setTxtID_Code_Organization_Red(
			String txtID_Code_Organization_Red) {
		this.txtID_Code_Organization_Red = txtID_Code_Organization_Red;
	}

	/**
	 * 店舗を取得します。
	 * 
	 * @return 店舗
	 */
	public String getTxtID_Code_Tenpo_Red() {
		return txtID_Code_Tenpo_Red;
	}

	/**
	 * 店舗を設定します。
	 * 
	 * @param txtID_Code_Tenpo_Red
	 *            店舗
	 */
	public void setTxtID_Code_Tenpo_Red(String txtID_Code_Tenpo_Red) {
		this.txtID_Code_Tenpo_Red = txtID_Code_Tenpo_Red;
	}

	/**
	 * 年度を取得します。
	 * 
	 * @return 年度
	 */
	public String getTxtID_Year_Red() {
		return txtID_Year_Red;
	}

	/**
	 * 年度を設定します。
	 * 
	 * @param txtID_Year_Red
	 *            年度
	 */
	public void setTxtID_Year_Red(String txtID_Year_Red) {
		this.txtID_Year_Red = txtID_Year_Red;
	}

	/**
	 * 方式資金を取得します。
	 * 
	 * @return 方式資金
	 */
	public String getTxtID_Code_HoshikiShikin_Red() {
		return txtID_Code_HoshikiShikin_Red;
	}

	/**
	 * 方式資金を設定します。
	 * 
	 * @param txtID_Code_HoshikiShikin_Red
	 *            方式資金
	 */
	public void setTxtID_Code_HoshikiShikin_Red(
			String txtID_Code_HoshikiShikin_Red) {
		this.txtID_Code_HoshikiShikin_Red = txtID_Code_HoshikiShikin_Red;
	}

	/**
	 * 番号を取得します。
	 * 
	 * @return 番号
	 */
	public String getTxtID_ID_Ringi_Red() {
		return txtID_ID_Ringi_Red;
	}

	/**
	 * 番号を設定します。
	 * 
	 * @param txtID_ID_Ringi_Red
	 *            番号
	 */
	public void setTxtID_ID_Ringi_Red(String txtID_ID_Ringi_Red) {
		this.txtID_ID_Ringi_Red = txtID_ID_Ringi_Red;
	}

	/**
	 * 枝番を取得します。
	 * 
	 * @return 枝番
	 */
	public String getTxtID_ID_RingiBranch_Red() {
		return txtID_ID_RingiBranch_Red;
	}

	/**
	 * 枝番を設定します。
	 * 
	 * @param txtID_ID_RingiBranch_Red
	 *            枝番
	 */
	public void setTxtID_ID_RingiBranch_Red(String txtID_ID_RingiBranch_Red) {
		this.txtID_ID_RingiBranch_Red = txtID_ID_RingiBranch_Red;
	}

	/**
	 * 資金使途を取得します。
	 * 
	 * @return 資金使途
	 */
	public String getTxtID_Code_ShikinShito_Red() {
		return txtID_Code_ShikinShito_Red;
	}

	/**
	 * 資金使途を設定します。
	 * 
	 * @param txtID_Code_ShikinShito_Red
	 *            資金使途
	 */
	public void setTxtID_Code_ShikinShito_Red(String txtID_Code_ShikinShito_Red) {
		this.txtID_Code_ShikinShito_Red = txtID_Code_ShikinShito_Red;
	}

	/**
	 * 事業別を取得します。
	 * 
	 * @return 事業別
	 */
	public String getTxtID_Code_Jigyobetsu_Red() {
		return txtID_Code_Jigyobetsu_Red;
	}

	/**
	 * 事業別を設定します。
	 * 
	 * @param txtID_Code_Jigyobetsu_Red
	 *            事業別
	 */
	public void setTxtID_Code_Jigyobetsu_Red(String txtID_Code_Jigyobetsu_Red) {
		this.txtID_Code_Jigyobetsu_Red = txtID_Code_Jigyobetsu_Red;
	}

	/**
	 * 利率（％）を取得します。
	 * 
	 * @return 利率（％）
	 */
	public String getTxtID_Riritsu_Red() {
		return txtID_Riritsu_Red;
	}

	/**
	 * 利率（％）を設定します。
	 * 
	 * @param txtID_Riritsu_Red
	 *            利率（％）
	 */
	public void setTxtID_Riritsu_Red(String txtID_Riritsu_Red) {
		this.txtID_Riritsu_Red = txtID_Riritsu_Red;
	}

	/**
	 * 特利区分を取得します。
	 * 
	 * @return 特利区分
	 */
	public String getTxtID_Kubun_Tokuri_Red() {
		return txtID_Kubun_Tokuri_Red;
	}

	/**
	 * 特利区分を設定します。
	 * 
	 * @param txtID_Kubun_Tokuri_Red
	 *            特利区分
	 */
	public void setTxtID_Kubun_Tokuri_Red(String txtID_Kubun_Tokuri_Red) {
		this.txtID_Kubun_Tokuri_Red = txtID_Kubun_Tokuri_Red;
	}

	/**
	 * 特利（％）を取得します。
	 * 
	 * @return 特利（％）
	 */
	public String getTxtID_Tokuri_Red() {
		return txtID_Tokuri_Red;
	}

	/**
	 * 特利（％）を設定します。
	 * 
	 * @param txtID_Tokuri_Red
	 *            特利（％）
	 */
	public void setTxtID_Tokuri_Red(String txtID_Tokuri_Red) {
		this.txtID_Tokuri_Red = txtID_Tokuri_Red;
	}

	/**
	 * 据置期限を取得します。
	 * 
	 * @return 据置期限
	 */
	public String getTxtID_Date_SueokiKigen_Red() {
		return txtID_Date_SueokiKigen_Red;
	}

	/**
	 * 据置期限を設定します。
	 * 
	 * @param txtID_Date_SueokiKigen_Red
	 *            据置期限
	 */
	public void setTxtID_Date_SueokiKigen_Red(String txtID_Date_SueokiKigen_Red) {
		this.txtID_Date_SueokiKigen_Red = txtID_Date_SueokiKigen_Red;
	}

	/**
	 * 償還期限を取得します。
	 * 
	 * @return 償還期限
	 */
	public String getTxtID_Date_ShokanKigen_Red() {
		return txtID_Date_ShokanKigen_Red;
	}

	/**
	 * 償還期限を設定します。
	 * 
	 * @param txtID_Date_ShokanKigen_Red
	 *            償還期限
	 */
	public void setTxtID_Date_ShokanKigen_Red(String txtID_Date_ShokanKigen_Red) {
		this.txtID_Date_ShokanKigen_Red = txtID_Date_ShokanKigen_Red;
	}

	/**
	 * 受託者勘定処理年月を取得します。
	 * 
	 * @return 受託者勘定処理年月
	 */
	public String getTxtID_Date_Jtkshori_Red() {
		return txtID_Date_Jtkshori_Red;
	}

	/**
	 * 受託者勘定処理年月を設定します。
	 * 
	 * @param txtID_Date_Jtkshori_Red
	 *            受託者勘定処理年月
	 */
	public void setTxtID_Date_Jtkshori_Red(String txtID_Date_Jtkshori_Red) {
		this.txtID_Date_Jtkshori_Red = txtID_Date_Jtkshori_Red;
	}

	/**
	 * 元利金払込日を取得します。
	 * 
	 * @return 元利金払込日
	 */
	public String getTxtID_Date_GanrikinHaraikomi_Red() {
		return txtID_Date_GanrikinHaraikomi_Red;
	}

	/**
	 * 元利金払込日を設定します。
	 * 
	 * @param txtID_Date_GanrikinHaraikomi_Red
	 *            元利金払込日
	 */
	public void setTxtID_Date_GanrikinHaraikomi_Red(
			String txtID_Date_GanrikinHaraikomi_Red) {
		this.txtID_Date_GanrikinHaraikomi_Red = txtID_Date_GanrikinHaraikomi_Red;
	}

	/**
	 * 貸付実行日を取得します。
	 * 
	 * @return 貸付実行日
	 */
	public String getTxtID_Date_Kashitsukejikko_Red() {
		return txtID_Date_Kashitsukejikko_Red;
	}

	/**
	 * 貸付実行日を設定します。
	 * 
	 * @param txtID_Date_Kashitsukejikko_Red
	 *            貸付実行日
	 */
	public void setTxtID_Date_Kashitsukejikko_Red(
			String txtID_Date_Kashitsukejikko_Red) {
		this.txtID_Date_Kashitsukejikko_Red = txtID_Date_Kashitsukejikko_Red;
	}

	/**
	 * 貸付実行金額(円)を取得します。
	 * 
	 * @return 貸付実行金額(円)
	 */
	public String getTxtID_M_Kashitsuke_Red() {
		return txtID_M_Kashitsuke_Red;
	}

	/**
	 * 貸付実行金額(円)を設定します。
	 * 
	 * @param txtID_M_Kashitsuke_Red
	 *            貸付実行金額(円)
	 */
	public void setTxtID_M_Kashitsuke_Red(String txtID_M_Kashitsuke_Red) {
		this.txtID_M_Kashitsuke_Red = txtID_M_Kashitsuke_Red;
	}

	/**
	 * 資金交付額(円)を取得します。
	 * 
	 * @return 資金交付額(円)
	 */
	public String getTxtID_M_ShikinKofu_Red() {
		return txtID_M_ShikinKofu_Red;
	}

	/**
	 * 資金交付額(円)を設定します。
	 * 
	 * @param txtID_M_ShikinKofu_Red
	 *            資金交付額(円)
	 */
	public void setTxtID_M_ShikinKofu_Red(String txtID_M_ShikinKofu_Red) {
		this.txtID_M_ShikinKofu_Red = txtID_M_ShikinKofu_Red;
	}

	/**
	 * 貸付受入金受入額(円)を取得します。
	 * 
	 * @return 貸付受入金受入額(円)
	 */
	public String getTxtID_M_KashitukeUkeire_Red() {
		return txtID_M_KashitukeUkeire_Red;
	}

	/**
	 * 貸付受入金受入額(円)を設定します。
	 * 
	 * @param txtID_M_KashitukeUkeire_Red
	 *            貸付受入金受入額(円)
	 */
	public void setTxtID_M_KashitukeUkeire_Red(
			String txtID_M_KashitukeUkeire_Red) {
		this.txtID_M_KashitukeUkeire_Red = txtID_M_KashitukeUkeire_Red;
	}

	/**
	 * 受託者勘定処理年月(元号)を取得します。
	 * 
	 * @return 受託者勘定処理年月(元号)
	 */
	public String getID_Date_Jtkshori_Gengo_Red() {
		return ID_Date_Jtkshori_Gengo_Red;
	}

	/**
	 * 受託者勘定処理年月(元号)を設定します。
	 * 
	 * @param ID_Date_Jtkshori_Gengo_Red
	 *            受託者勘定処理年月(元号)
	 */
	public void setID_Date_Jtkshori_Gengo_Red(String ID_Date_Jtkshori_Gengo_Red) {
		this.ID_Date_Jtkshori_Gengo_Red = ID_Date_Jtkshori_Gengo_Red;
	}

	/**
	 * 受託者勘定処理年月(年)を取得します。
	 * 
	 * @return 受託者勘定処理年月(年)
	 */
	public String getID_Date_Jtkshori_Nen_Red() {
		return ID_Date_Jtkshori_Nen_Red;
	}

	/**
	 * 受託者勘定処理年月(年)を設定します。
	 * 
	 * @param ID_Date_Jtkshori_Nen_Red
	 *            受託者勘定処理年月(年)
	 */
	public void setID_Date_Jtkshori_Nen_Red(String ID_Date_Jtkshori_Nen_Red) {
		this.ID_Date_Jtkshori_Nen_Red = ID_Date_Jtkshori_Nen_Red;
	}

	/**
	 * 受託者勘定処理年月(月)を取得します。
	 * 
	 * @return 受託者勘定処理年月(月)
	 */
	public String getDrpID_Date_JtkshoriTsuki_Red() {
		return drpID_Date_JtkshoriTsuki_Red;
	}

	/**
	 * 受託者勘定処理年月(月)を設定します。
	 * 
	 * @param drpID_Date_JtkshoriTsuki_Red
	 *            受託者勘定処理年月(月)
	 */
	public void setDrpID_Date_JtkshoriTsuki_Red(
			String drpID_Date_JtkshoriTsuki_Red) {
		this.drpID_Date_JtkshoriTsuki_Red = drpID_Date_JtkshoriTsuki_Red;
	}

	/**
	 * 黒データ入力領域タイトルを取得します。
	 *
	 * @return 黒データ入力領域タイトル
	 */
	public String getLblID_Head() {
		return lblID_Head;
	}

	/**
	 * 黒データ入力領域タイトルを設定します。
	 *
	 * @param lblID_Head
	 *            黒データ入力領域タイトル
	 */
	public void setLblID_Head(String lblID_Head) {
		this.lblID_Head = lblID_Head;
	}

	/**
	 * 顧客名（修正）を取得します。
	 * 
	 * @return 顧客名（修正）
	 */
	public String getTxtID_Name_Customer() {
		return txtID_Name_Customer;
	}

	/**
	 * 顧客名（修正）を設定します。
	 * 
	 * @param txtID_Name_Customer
	 *            顧客名（修正）
	 */
	public void setTxtID_Name_Customer(String txtID_Name_Customer) {
		this.txtID_Name_Customer = txtID_Name_Customer;
	}

	/**
	 * 扱店名（修正）を取得します。
	 * 
	 * @return 扱店名（修正）
	 */
	public String getTxtID_Name_Organization() {
		return txtID_Name_Organization;
	}

	/**
	 * 扱店名（修正）を設定します。
	 * 
	 * @param txtID_Name_Organization
	 *            扱店名（修正）
	 */
	public void setTxtID_Name_Organization(String txtID_Name_Organization) {
		this.txtID_Name_Organization = txtID_Name_Organization;
	}

	/**
	 * 公庫支店（修正）を取得します。
	 * 
	 * @return 公庫支店（修正）
	 */
	public String getTxtID_Code_KoukoShiten() {
		return txtID_Code_KoukoShiten;
	}

	/**
	 * 公庫支店（修正）を設定します。
	 * 
	 * @param txtID_Code_KoukoShiten
	 *            公庫支店（修正）
	 */
	public void setTxtID_Code_KoukoShiten(String txtID_Code_KoukoShiten) {
		this.txtID_Code_KoukoShiten = txtID_Code_KoukoShiten;
	}

	/**
	 * 扱店（修正）を取得します。
	 * 
	 * @return 扱店（修正）
	 */
	public String getTxtID_Code_Organization() {
		return txtID_Code_Organization;
	}

	/**
	 * 扱店（修正）を設定します。
	 * 
	 * @param txtID_Code_Organization
	 *            扱店（修正）
	 */
	public void setTxtID_Code_Organization(String txtID_Code_Organization) {
		this.txtID_Code_Organization = txtID_Code_Organization;
	}

	/**
	 * 店舗（修正）を取得します。
	 * 
	 * @return 店舗（修正）
	 */
	public String getTxtID_Code_Tenpo() {
		return txtID_Code_Tenpo;
	}

	/**
	 * 店舗（修正）を設定します。
	 * 
	 * @param txtID_Code_Tenpo
	 *            店舗（修正）
	 */
	public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
		this.txtID_Code_Tenpo = txtID_Code_Tenpo;
	}

	/**
	 * 年度（修正）を取得します。
	 * 
	 * @return 年度（修正）
	 */
	public String getTxtID_Year() {
		return txtID_Year;
	}

	/**
	 * 年度（修正）を設定します。
	 * 
	 * @param txtID_Year
	 *            年度（修正）
	 */
	public void setTxtID_Year(String txtID_Year) {
		this.txtID_Year = txtID_Year;
	}

	/**
	 * 方式資金（修正）を取得します。
	 * 
	 * @return 方式資金（修正）
	 */
	public String getTxtID_Code_HoshikiShikin() {
		return txtID_Code_HoshikiShikin;
	}

	/**
	 * 方式資金（修正）を設定します。
	 * 
	 * @param txtID_Code_HoshikiShikin
	 *            方式資金（修正）
	 */
	public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
		this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
	}

	/**
	 * 番号（修正）を取得します。
	 * 
	 * @return 番号（修正）
	 */
	public String getTxtID_ID_Ringi() {
		return txtID_ID_Ringi;
	}

	/**
	 * 番号（修正）を設定します。
	 * 
	 * @param txtID_ID_Ringi
	 *            番号（修正）
	 */
	public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
		this.txtID_ID_Ringi = txtID_ID_Ringi;
	}

	/**
	 * 枝番（修正）を取得します。
	 * 
	 * @return 枝番（修正）
	 */
	public String getTxtID_ID_RingiBranch() {
		return txtID_ID_RingiBranch;
	}

	/**
	 * 枝番（修正）を設定します。
	 * 
	 * @param txtID_ID_RingiBranch
	 *            枝番（修正）
	 */
	public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
		this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
	}

	/**
	 * 資金使途（修正）を取得します。
	 * 
	 * @return 資金使途（修正）
	 */
	public String getTxtID_Code_ShikinShito() {
		return txtID_Code_ShikinShito;
	}

	/**
	 * 資金使途（修正）を設定します。
	 * 
	 * @param txtID_Code_ShikinShito
	 *            資金使途（修正）
	 */
	public void setTxtID_Code_ShikinShito(String txtID_Code_ShikinShito) {
		this.txtID_Code_ShikinShito = txtID_Code_ShikinShito;
	}

	/**
	 * 事業別（修正）を取得します。
	 * 
	 * @return 事業別（修正）
	 */
	public String getTxtID_Code_Jigyobetsu() {
		return txtID_Code_Jigyobetsu;
	}

	/**
	 * 事業別（修正）を設定します。
	 * 
	 * @param txtID_Code_Jigyobetsu
	 *            事業別（修正）
	 */
	public void setTxtID_Code_Jigyobetsu(String txtID_Code_Jigyobetsu) {
		this.txtID_Code_Jigyobetsu = txtID_Code_Jigyobetsu;
	}

	/**
	 * 利率（％）（修正）を取得します。
	 * 
	 * @return 利率（％）（修正）
	 */
	public String getTxtID_Riritsu() {
		return txtID_Riritsu;
	}

	/**
	 * 利率（％）（修正）を設定します。
	 * 
	 * @param txtID_Riritsu
	 *            利率（％）（修正）
	 */
	public void setTxtID_Riritsu(String txtID_Riritsu) {
		this.txtID_Riritsu = txtID_Riritsu;
	}

	/**
	 * 特利区分（修正）を取得します。
	 * 
	 * @return 特利区分（修正）
	 */
	public String getTxtID_Kubun_Tokuri() {
		return txtID_Kubun_Tokuri;
	}

	/**
	 * 特利区分（修正）を設定します。
	 * 
	 * @param txtID_Kubun_Tokuri
	 *            特利区分（修正）
	 */
	public void setTxtID_Kubun_Tokuri(String txtID_Kubun_Tokuri) {
		this.txtID_Kubun_Tokuri = txtID_Kubun_Tokuri;
	}

	/**
	 * 特利（％）（修正）を取得します。
	 * 
	 * @return 特利（％）（修正）
	 */
	public String getTxtID_Tokuri() {
		return txtID_Tokuri;
	}

	/**
	 * 特利（％）（修正）を設定します。
	 * 
	 * @param txtID_Tokuri
	 *            特利（％）（修正）
	 */
	public void setTxtID_Tokuri(String txtID_Tokuri) {
		this.txtID_Tokuri = txtID_Tokuri;
	}

	/**
	 * 据置期限（修正）を取得します。
	 * 
	 * @return 据置期限（修正）
	 */
	public String getTxtID_Date_SueokiKigen() {
		return txtID_Date_SueokiKigen;
	}

	/**
	 * 据置期限（修正）を設定します。
	 * 
	 * @param txtID_Date_SueokiKigen
	 *            据置期限（修正）
	 */
	public void setTxtID_Date_SueokiKigen(String txtID_Date_SueokiKigen) {
		this.txtID_Date_SueokiKigen = txtID_Date_SueokiKigen;
	}

	/**
	 * 償還期限（修正）を取得します。
	 * 
	 * @return 償還期限（修正）
	 */
	public String getTxtID_Date_ShokanKigen() {
		return txtID_Date_ShokanKigen;
	}

	/**
	 * 償還期限（修正）を設定します。
	 * 
	 * @param txtID_Date_ShokanKigen
	 *            償還期限（修正）
	 */
	public void setTxtID_Date_ShokanKigen(String txtID_Date_ShokanKigen) {
		this.txtID_Date_ShokanKigen = txtID_Date_ShokanKigen;
	}

	/**
	 * 受託者勘定処理年月（修正）を取得します。
	 * 
	 * @return 受託者勘定処理年月（修正）
	 */
	public String getTxtID_Date_Jtkshori() {
		return txtID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月（修正）を設定します。
	 * 
	 * @param txtID_Date_Jtkshori
	 *            受託者勘定処理年月（修正）
	 */
	public void setTxtID_Date_Jtkshori(String txtID_Date_Jtkshori) {
		this.txtID_Date_Jtkshori = txtID_Date_Jtkshori;
	}

	/**
	 * 元利金払込日（修正）を取得します。
	 * 
	 * @return 元利金払込日（修正）
	 */
	public String getTxtID_Date_GanrikinHaraikomi() {
		return txtID_Date_GanrikinHaraikomi;
	}

	/**
	 * 元利金払込日（修正）を設定します。
	 * 
	 * @param txtID_Date_GanrikinHaraikomi
	 *            元利金払込日（修正）
	 */
	public void setTxtID_Date_GanrikinHaraikomi(
			String txtID_Date_GanrikinHaraikomi) {
		this.txtID_Date_GanrikinHaraikomi = txtID_Date_GanrikinHaraikomi;
	}

	/**
	 * 貸付実行日（元号）（修正）を取得します。
	 * 
	 * @return 貸付実行日（元号）（修正）
	 */
	public String getID_Date_Kashitsukejikko_Gengo() {
		return ID_Date_Kashitsukejikko_Gengo;
	}

	/**
	 * 貸付実行日（元号）（修正）を設定します。
	 * 
	 * @param ID_Date_Kashitsukejikko_Gengo
	 *            貸付実行日（元号）（修正）
	 */
	public void setID_Date_Kashitsukejikko_Gengo(
			String ID_Date_Kashitsukejikko_Gengo) {
		this.ID_Date_Kashitsukejikko_Gengo = ID_Date_Kashitsukejikko_Gengo;
	}

	/**
	 * 貸付実行日（年）（修正）を取得します。
	 * 
	 * @return 貸付実行日（年）（修正）
	 */
	public String getID_Date_Kashitsukejikko_Nen() {
		return ID_Date_Kashitsukejikko_Nen;
	}

	/**
	 * 貸付実行日（年）（修正）を設定します。
	 * 
	 * @param ID_Date_Kashitsukejikko_Nen
	 *            貸付実行日（年）（修正）
	 */
	public void setID_Date_Kashitsukejikko_Nen(
			String ID_Date_Kashitsukejikko_Nen) {
		this.ID_Date_Kashitsukejikko_Nen = ID_Date_Kashitsukejikko_Nen;
	}

	/**
	 * 貸付実行日（月）（修正）を取得します。
	 * 
	 * @return 貸付実行日（月）（修正）
	 */
	public String getDrpID_Date_KashitsukejikkoTsuki() {
		return drpID_Date_KashitsukejikkoTsuki;
	}

	/**
	 * 貸付実行日（月）（修正）を設定します。
	 * 
	 * @param drpID_Date_KashitsukejikkoTsuki
	 *            貸付実行日（月）（修正）
	 */
	public void setDrpID_Date_KashitsukejikkoTsuki(
			String drpID_Date_KashitsukejikkoTsuki) {
		this.drpID_Date_KashitsukejikkoTsuki = drpID_Date_KashitsukejikkoTsuki;
	}

	/**
	 * 貸付実行日（日）（修正）を取得します。
	 * 
	 * @return 貸付実行日（日）（修正）
	 */
	public String getDrpID_Date_KashitsukejikkoBi() {
		return drpID_Date_KashitsukejikkoBi;
	}

	/**
	 * 貸付実行日（日）（修正）を設定します。
	 * 
	 * @param drpID_Date_KashitsukejikkoBi
	 *            貸付実行日（日）（修正）
	 */
	public void setDrpID_Date_KashitsukejikkoBi(
			String drpID_Date_KashitsukejikkoBi) {
		this.drpID_Date_KashitsukejikkoBi = drpID_Date_KashitsukejikkoBi;
	}

	/**
	 * 貸付実行金額（修正）を取得します。
	 * 
	 * @return 貸付実行金額（修正）
	 */
	public String getTxtID_M_Kashitsuke() {
		return txtID_M_Kashitsuke;
	}

	/**
	 * 貸付実行金額（修正）を設定します。
	 * 
	 * @param txtID_M_Kashitsuke
	 *            貸付実行金額（修正）
	 */
	public void setTxtID_M_Kashitsuke(String txtID_M_Kashitsuke) {
		this.txtID_M_Kashitsuke = txtID_M_Kashitsuke;
	}

	/**
	 * 資金交付額（修正）を取得します。
	 * 
	 * @return 資金交付額（修正）
	 */
	public String getTxtID_M_ShikinKofu() {
		return txtID_M_ShikinKofu;
	}

	/**
	 * 資金交付額（修正）を設定します。
	 * 
	 * @param txtID_M_ShikinKofu
	 *            資金交付額（修正）
	 */
	public void setTxtID_M_ShikinKofu(String txtID_M_ShikinKofu) {
		this.txtID_M_ShikinKofu = txtID_M_ShikinKofu;
	}

	/**
	 * 貸付受入金受入額を取得します。
	 * 
	 * @return 貸付受入金受入額
	 */
	public String getTxtID_M_KashitukeUkeire() {
		return txtID_M_KashitukeUkeire;
	}

	/**
	 * 貸付受入金受入額を設定します。
	 * 
	 * @param txtID_M_KashitukeUkeire
	 *            貸付受入金受入額
	 */
	public void setTxtID_M_KashitukeUkeire(String txtID_M_KashitukeUkeire) {
		this.txtID_M_KashitukeUkeire = txtID_M_KashitukeUkeire;
	}

	/**
	 * 受託者勘定処理年月(元号)（修正）を取得します。
	 * 
	 * @return 受託者勘定処理年月(元号)（修正）
	 */
	public String getID_Date_Jtkshori_Gengo() {
		return ID_Date_Jtkshori_Gengo;
	}

	/**
	 * 受託者勘定処理年月(元号)（修正）を設定します。
	 * 
	 * @param ID_Date_Jtkshori_Gengo
	 *            受託者勘定処理年月(元号)（修正）
	 */
	public void setID_Date_Jtkshori_Gengo(String ID_Date_Jtkshori_Gengo) {
		this.ID_Date_Jtkshori_Gengo = ID_Date_Jtkshori_Gengo;
	}

	/**
	 * 受託者勘定処理年月(年)（修正）を取得します。
	 * 
	 * @return 受託者勘定処理年月(年)（修正）
	 */
	public String getID_Date_Jtkshori_Nen() {
		return ID_Date_Jtkshori_Nen;
	}

	/**
	 * 受託者勘定処理年月(年)（修正）を設定します。
	 * 
	 * @param ID_Date_Jtkshori_Nen
	 *            受託者勘定処理年月(年)（修正）
	 */
	public void setID_Date_Jtkshori_Nen(String ID_Date_Jtkshori_Nen) {
		this.ID_Date_Jtkshori_Nen = ID_Date_Jtkshori_Nen;
	}

	/**
	 * 受託者勘定処理年月(月)（修正）を取得します。
	 * 
	 * @return 受託者勘定処理年月(月)（修正）
	 */
	public String getDrpID_Date_JtkshoriTsuki() {
		return drpID_Date_JtkshoriTsuki;
	}

	/**
	 * 受託者勘定処理年月(月)（修正）を設定します。
	 * 
	 * @param drpID_Date_JtkshoriTsuki
	 *            受託者勘定処理年月(月)（修正）
	 */
	public void setDrpID_Date_JtkshoriTsuki(String drpID_Date_JtkshoriTsuki) {
		this.drpID_Date_JtkshoriTsuki = drpID_Date_JtkshoriTsuki;
	}

	/**
	 * 報告時分秒を取得します。
	 * 
	 * @return 報告時分秒
	 */
	public String getTime_Report() {
		return Time_Report;
	}

	/**
	 * 報告時分秒を設定します。
	 * 
	 * @param Time_Report
	 *            報告時分秒
	 */
	public void setTime_Report(String Time_Report) {
		this.Time_Report = Time_Report;
	}

	/**
	 * 報告書種別（値）を取得します。
	 * 
	 * @return 報告書種別（値）
	 */
	public String getDataCode() {
		return DataCode;
	}

	/**
	 * 報告書種別（値）を設定します。
	 * 
	 * @param DataCode
	 *            報告書種別（値）
	 */
	public void setDataCode(String DataCode) {
		this.DataCode = DataCode;
	}

	/**
	 * ステータスを取得します。
	 * 
	 * @return ステータス
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * ステータスを設定します。
	 * 
	 * @param Status
	 *            ステータス
	 */
	public void setStatus(String Status) {
		this.Status = Status;
	}

	/**
	 * 報告書番号を取得します。
	 * 
	 * @return 報告書番号
	 */
	public String getID_Report() {
		return ID_Report;
	}

	/**
	 * 報告書番号を設定します。
	 * 
	 * @param ID_Report
	 *            報告書番号
	 */
	public void setID_Report(String ID_Report) {
		this.ID_Report = ID_Report;
	}

	/**
	 * 操作選択を取得します。
	 * 
	 * @return 操作選択
	 */
	public String getID_OperationSelect() {
		return ID_OperationSelect;
	}

	/**
	 * 操作選択を設定します。
	 * 
	 * @param ID_OperationSelect
	 *            操作選択
	 */
	public void setID_OperationSelect(String ID_OperationSelect) {
		this.ID_OperationSelect = ID_OperationSelect;
	}

	/**
	 * 処理種別を取得します。
	 * 
	 * @return 処理種別
	 */
	public String getType_Process() {
		return Type_Process;
	}

	/**
	 * 処理種別を設定します。
	 * 
	 * @param Type_Process
	 *            処理種別
	 */
	public void setType_Process(String Type_Process) {
		this.Type_Process = Type_Process;
	}

	/**
	 * エラー追加情報を取得します。
	 * 
	 * @return エラー追加情報
	 */
	public String getErrAddInfo() {
		return ErrAddInfo;
	}

	/**
	 * エラー追加情報を設定します。
	 * 
	 * @param ErrAddInfo
	 *            エラー追加情報
	 */
	public void setErrAddInfo(String ErrAddInfo) {
		this.ErrAddInfo = ErrAddInfo;
	}

	/**
	 * モードタイプを取得します。
	 * 
	 * @return モードタイプ
	 */
	public String getModeType() {
		return ModeType;
	}

	/**
	 * モードタイプを設定します。
	 * 
	 * @param ModeType
	 *            モードタイプ
	 */
	public void setModeType(String ModeType) {
		this.ModeType = ModeType;
	}

	/**
	 * 処理モードを取得します。
	 * 
	 * @return 処理モード
	 */
	public String getProcessMode() {
		return ProcessMode;
	}

	/**
	 * 処理モードを設定します。
	 * 
	 * @param ProcessMode
	 *            処理モード
	 */
	public void setProcessMode(String ProcessMode) {
		this.ProcessMode = ProcessMode;
	}

	/**
	 * 履歴番号（非表示）を取得します。
	 * 
	 * @return 履歴番号（非表示）
	 */
	public String getID_ID_History_Red() {
		return ID_ID_History_Red;
	}

	/**
	 * 履歴番号（非表示）を設定します。
	 * 
	 * @param ID_ID_History_Red
	 *            履歴番号（非表示）
	 */
	public void setID_ID_History_Red(String ID_ID_History_Red) {
		this.ID_ID_History_Red = ID_ID_History_Red;
	}

	/**
	 * 処理種別（非表示）を取得します。
	 * 
	 * @return 処理種別（非表示）
	 */
	public String getID_Type_Process_Red() {
		return ID_Type_Process_Red;
	}

	/**
	 * 処理種別（非表示）を設定します。
	 * 
	 * @param ID_Type_Process_Red
	 *            処理種別（非表示）
	 */
	public void setID_Type_Process_Red(String ID_Type_Process_Red) {
		this.ID_Type_Process_Red = ID_Type_Process_Red;
	}

	/**
	 * 取消済みフラグ（非表示）を取得します。
	 * 
	 * @return 取消済みフラグ（非表示）
	 */
	public String getID_Flag_Torikeshizumi_Red() {
		return ID_Flag_Torikeshizumi_Red;
	}

	/**
	 * 取消済みフラグ（非表示）を設定します。
	 * 
	 * @param ID_Flag_Torikeshizumi_Red
	 *            取消済みフラグ（非表示）
	 */
	public void setID_Flag_Torikeshizumi_Red(String ID_Flag_Torikeshizumi_Red) {
		this.ID_Flag_Torikeshizumi_Red = ID_Flag_Torikeshizumi_Red;
	}

	/**
	 * エラーコード（非表示）を取得します。
	 * 
	 * @return エラーコード（非表示）
	 */
	public String getID_Code_Error_Red() {
		return ID_Code_Error_Red;
	}

	/**
	 * エラーコード（非表示）を設定します。
	 * 
	 * @param ID_Code_Error_Red
	 *            エラーコード（非表示）
	 */
	public void setID_Code_Error_Red(String ID_Code_Error_Red) {
		this.ID_Code_Error_Red = ID_Code_Error_Red;
	}

	/**
	 * 債権管理番号（非表示）を取得します。
	 * 
	 * @return 債権管理番号（非表示）
	 */
	public String getID_ID_Credit_Red() {
		return ID_ID_Credit_Red;
	}

	/**
	 * 債権管理番号（非表示）を設定します。
	 * 
	 * @param ID_ID_Credit_Red
	 *            債権管理番号（非表示）
	 */
	public void setID_ID_Credit_Red(String ID_ID_Credit_Red) {
		this.ID_ID_Credit_Red = ID_ID_Credit_Red;
	}

	/**
	 * 伝送番号（非表示）を取得します。
	 * 
	 * @return 伝送番号（非表示）
	 */
	public String getID_ID_Denso_Red() {
		return ID_ID_Denso_Red;
	}

	/**
	 * 伝送番号（非表示）を設定します。
	 * 
	 * @param ID_ID_Denso_Red
	 *            伝送番号（非表示）
	 */
	public void setID_ID_Denso_Red(String ID_ID_Denso_Red) {
		this.ID_ID_Denso_Red = ID_ID_Denso_Red;
	}

	/**
	 * 貸付件数（非表示）を取得します。
	 * 
	 * @return 貸付件数（非表示）
	 */
	public String getID_Count_Kashitsuke_Red() {
		return ID_Count_Kashitsuke_Red;
	}

	/**
	 * 貸付件数（非表示）を設定します。
	 * 
	 * @param ID_Count_Kashitsuke_Red
	 *            貸付件数（非表示）
	 */
	public void setID_Count_Kashitsuke_Red(String ID_Count_Kashitsuke_Red) {
		this.ID_Count_Kashitsuke_Red = ID_Count_Kashitsuke_Red;
	}

	/**
	 * 原本番号（非表示）を取得します。
	 * 
	 * @return 原本番号（非表示）
	 */
	public String getID_ID_Maste_Red() {
		return ID_ID_Maste_Red;
	}

	/**
	 * 原本番号（非表示）を設定します。
	 * 
	 * @param ID_ID_Maste_Red
	 *            原本番号（非表示）
	 */
	public void setID_ID_Maste_Red(String ID_ID_Maste_Red) {
		this.ID_ID_Maste_Red = ID_ID_Maste_Red;
	}

	/**
	 * 署名データ（非表示）を取得します。
	 * 
	 * @return 署名データ（非表示）
	 */
	public String getID_SignData_Red() {
		return ID_SignData_Red;
	}

	/**
	 * 署名データ（非表示）を設定します。
	 * 
	 * @param ID_SignData_Red
	 *            署名データ（非表示）
	 */
	public void setID_SignData_Red(String ID_SignData_Red) {
		this.ID_SignData_Red = ID_SignData_Red;
	}

	/**
	 * ステータス（値）（非表示）を取得します。
	 * 
	 * @return ステータス（値）（非表示）
	 */
	public String getID_Status_Red() {
		return ID_Status_Red;
	}

	/**
	 * ステータス（値）（非表示）を設定します。
	 * 
	 * @param ID_Status_Red
	 *            ステータス（値）（非表示）
	 */
	public void setID_Status_Red(String ID_Status_Red) {
		this.ID_Status_Red = ID_Status_Red;
	}

	/**
	 * データコード（非表示）を取得します。
	 * 
	 * @return データコード（非表示）
	 */
	public String getID_DataCode_Red() {
		return ID_DataCode_Red;
	}

	/**
	 * データコード（非表示）を設定します。
	 * 
	 * @param ID_DataCode_Red
	 *            データコード（非表示）
	 */
	public void setID_DataCode_Red(String ID_DataCode_Red) {
		this.ID_DataCode_Red = ID_DataCode_Red;
	}

	/**
	 * ユーザID（非表示）を取得します。
	 * 
	 * @return ユーザID（非表示）
	 */
	public String getID_UserID_Red() {
		return ID_UserID_Red;
	}

	/**
	 * ユーザID（非表示）を設定します。
	 * 
	 * @param ID_UserID_Red
	 *            ユーザID（非表示）
	 */
	public void setID_UserID_Red(String ID_UserID_Red) {
		this.ID_UserID_Red = ID_UserID_Red;
	}

	/**
	 * 報告時分秒（非表示）を取得します。
	 * 
	 * @return 報告時分秒（非表示）
	 */
	public String getID_Time_Report_Red() {
		return ID_Time_Report_Red;
	}

	/**
	 * 報告時分秒（非表示）を設定します。
	 * 
	 * @param ID_Time_Report_Red
	 *            報告時分秒（非表示）
	 */
	public void setID_Time_Report_Red(String ID_Time_Report_Red) {
		this.ID_Time_Report_Red = ID_Time_Report_Red;
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）を取得します。
	 * 
	 * @return 貸付実行作成済みフラグ（非表示）
	 */
	public String getID_Flag_Kj_Red() {
		return ID_Flag_Kj_Red;
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）を設定します。
	 * 
	 * @param ID_Flag_Kj_Red
	 *            貸付実行作成済みフラグ（非表示）
	 */
	public void setID_Flag_Kj_Red(String ID_Flag_Kj_Red) {
		this.ID_Flag_Kj_Red = ID_Flag_Kj_Red;
	}

	/**
	 * 顧客コード（非表示）を取得します。
	 * 
	 * @return 顧客コード（非表示）
	 */
	public String getID_Code_Customer_Red() {
		return ID_Code_Customer_Red;
	}

	/**
	 * 顧客コード（非表示）を設定します。
	 * 
	 * @param ID_Code_Customer_Red
	 *            顧客コード（非表示）
	 */
	public void setID_Code_Customer_Red(String ID_Code_Customer_Red) {
		this.ID_Code_Customer_Red = ID_Code_Customer_Red;
	}

	/**
	 * 実行起算予定日（非表示）を取得します。
	 * 
	 * @return 実行起算予定日（非表示）
	 */
	public String getID_Date_JuriKisan_Red() {
		return ID_Date_JuriKisan_Red;
	}

	/**
	 * 実行起算予定日（非表示）を設定します。
	 * 
	 * @param ID_Date_JuriKisan_Red
	 *            実行起算予定日（非表示）
	 */
	public void setID_Date_JuriKisan_Red(String ID_Date_JuriKisan_Red) {
		this.ID_Date_JuriKisan_Red = ID_Date_JuriKisan_Red;
	}

	/**
	 * 決定起算年月日（非表示）を取得します。
	 * 
	 * @return 決定起算年月日（非表示）
	 */
	public String getID_Date_KetteiKisan_Red() {
		return ID_Date_KetteiKisan_Red;
	}

	/**
	 * 決定起算年月日（非表示）を設定します。
	 * 
	 * @param ID_Date_KetteiKisan_Red
	 *            決定起算年月日（非表示）
	 */
	public void setID_Date_KetteiKisan_Red(String ID_Date_KetteiKisan_Red) {
		this.ID_Date_KetteiKisan_Red = ID_Date_KetteiKisan_Red;
	}

	/**
	 * 退避償還期限年月（非表示）を取得します。
	 * 
	 * @return 退避償還期限年月（非表示）
	 */
	public String getID_Keep_Date_ShokanKigen_Red() {
		return ID_Keep_Date_ShokanKigen_Red;
	}

	/**
	 * 退避償還期限年月（非表示）を設定します。
	 * 
	 * @param ID_Keep_Date_ShokanKigen_Red
	 *            退避償還期限年月（非表示）
	 */
	public void setID_Keep_Date_ShokanKigen_Red(
			String ID_Keep_Date_ShokanKigen_Red) {
		this.ID_Keep_Date_ShokanKigen_Red = ID_Keep_Date_ShokanKigen_Red;
	}

	/**
	 * 退避履歴番号(非表示)を取得します。
	 * 
	 * @return 退避履歴番号(非表示)
	 */
	public String getID_keep_ID_History_Red() {
		return ID_keep_ID_History_Red;
	}

	/**
	 * 退避履歴番号(非表示)を設定します。
	 * 
	 * @param ID_keep_ID_History_Red
	 *            退避履歴番号(非表示)
	 */
	public void setID_keep_ID_History_Red(String ID_keep_ID_History_Red) {
		this.ID_keep_ID_History_Red = ID_keep_ID_History_Red;
	}

	/**
	 * 退避実行済みフラグ（非表示）を取得します。
	 * 
	 * @return 退避実行済みフラグ（非表示）
	 */
	public String getID_Keep_Flag_Kj_Red() {
		return ID_Keep_Flag_Kj_Red;
	}

	/**
	 * 退避実行済みフラグ（非表示）を設定します。
	 * 
	 * @param ID_Keep_Flag_Kj_Red
	 *            退避実行済みフラグ（非表示）
	 */
	public void setID_Keep_Flag_Kj_Red(String ID_Keep_Flag_Kj_Red) {
		this.ID_Keep_Flag_Kj_Red = ID_Keep_Flag_Kj_Red;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）を取得します。
	 * 
	 * @return 扱店別稟議データより取得した実行済みフラグ（非表示）
	 */
	public String getID_aRingi_Flag_Kj_Red() {
		return ID_aRingi_Flag_Kj_Red;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）を設定します。
	 * 
	 * @param ID_aRingi_Flag_Kj_Red
	 *            扱店別稟議データより取得した実行済みフラグ（非表示）
	 */
	public void setID_aRingi_Flag_Kj_Red(String ID_aRingi_Flag_Kj_Red) {
		this.ID_aRingi_Flag_Kj_Red = ID_aRingi_Flag_Kj_Red;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を取得します。
	 * 
	 * @return 扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public String getID_aRingi_Date_ShokanKigen_Red() {
		return ID_aRingi_Date_ShokanKigen_Red;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を設定します。
	 * 
	 * @param ID_aRingi_Date_ShokanKigen_Red
	 *            扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public void setID_aRingi_Date_ShokanKigen_Red(
			String ID_aRingi_Date_ShokanKigen_Red) {
		this.ID_aRingi_Date_ShokanKigen_Red = ID_aRingi_Date_ShokanKigen_Red;
	}

	/**
	 * 扱店別稟議データの利率を取得します。
	 * 
	 * @return 扱店別稟議データの利率
	 */
	public String getID_aRingi_Riritsu_Red() {
		return ID_aRingi_Riritsu_Red;
	}

	/**
	 * 扱店別稟議データの利率を設定します。
	 * 
	 * @param ID_aRingi_Riritsu_Red
	 *            扱店別稟議データの利率
	 */
	public void setID_aRingi_Riritsu_Red(String ID_aRingi_Riritsu_Red) {
		this.ID_aRingi_Riritsu_Red = ID_aRingi_Riritsu_Red;
	}

	/**
	 * 扱店別稟議データの特利を取得します。
	 * 
	 * @return 扱店別稟議データの特利
	 */
	public String getID_aRingi_Tokuri_Red() {
		return ID_aRingi_Tokuri_Red;
	}

	/**
	 * 扱店別稟議データの特利を設定します。
	 * 
	 * @param ID_aRingi_Tokuri_Red
	 *            扱店別稟議データの特利
	 */
	public void setID_aRingi_Tokuri_Red(String ID_aRingi_Tokuri_Red) {
		this.ID_aRingi_Tokuri_Red = ID_aRingi_Tokuri_Red;
	}

	/**
	 * 最新データ更新日付（非表示）を取得します。
	 * 
	 * @return 最新データ更新日付（非表示）
	 */
	public String getID_Data_LastUpDate_Red() {
		return ID_Data_LastUpDate_Red;
	}

	/**
	 * 最新データ更新日付（非表示）を設定します。
	 * 
	 * @param ID_Data_LastUpDate_Red
	 *            最新データ更新日付（非表示）
	 */
	public void setID_Data_LastUpDate_Red(String ID_Data_LastUpDate_Red) {
		this.ID_Data_LastUpDate_Red = ID_Data_LastUpDate_Red;
	}

	/**
	 * 履歴番号（非表示）（修正）を取得します。
	 * 
	 * @return 履歴番号（非表示）（修正）
	 */
	public String getID_ID_History() {
		return ID_ID_History;
	}

	/**
	 * 履歴番号（非表示）（修正）を設定します。
	 * 
	 * @param ID_ID_History
	 *            履歴番号（非表示）（修正）
	 */
	public void setID_ID_History(String ID_ID_History) {
		this.ID_ID_History = ID_ID_History;
	}

	/**
	 * 処理種別（非表示）（修正）を取得します。
	 * 
	 * @return 処理種別（非表示）（修正）
	 */
	public String getID_Type_Process() {
		return ID_Type_Process;
	}

	/**
	 * 処理種別（非表示）（修正）を設定します。
	 * 
	 * @param ID_Type_Process
	 *            処理種別（非表示）（修正）
	 */
	public void setID_Type_Process(String ID_Type_Process) {
		this.ID_Type_Process = ID_Type_Process;
	}

	/**
	 * 取消済みフラグ（非表示）（修正）を取得します。
	 * 
	 * @return 取消済みフラグ（非表示）（修正）
	 */
	public String getID_Flag_Torikeshizumi() {
		return ID_Flag_Torikeshizumi;
	}

	/**
	 * 取消済みフラグ（非表示）（修正）を設定します。
	 * 
	 * @param ID_Flag_Torikeshizumi
	 *            取消済みフラグ（非表示）（修正）
	 */
	public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
		this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
	}

	/**
	 * エラーコード（非表示）（修正）を取得します。
	 * 
	 * @return エラーコード（非表示）（修正）
	 */
	public String getID_Code_Error() {
		return ID_Code_Error;
	}

	/**
	 * エラーコード（非表示）（修正）を設定します。
	 * 
	 * @param ID_Code_Error
	 *            エラーコード（非表示）（修正）
	 */
	public void setID_Code_Error(String ID_Code_Error) {
		this.ID_Code_Error = ID_Code_Error;
	}

	/**
	 * 債権管理番号（非表示）（修正）を取得します。
	 * 
	 * @return 債権管理番号（非表示）（修正）
	 */
	public String getID_ID_Credit() {
		return ID_ID_Credit;
	}

	/**
	 * 債権管理番号（非表示）（修正）を設定します。
	 * 
	 * @param ID_ID_Credit
	 *            債権管理番号（非表示）（修正）
	 */
	public void setID_ID_Credit(String ID_ID_Credit) {
		this.ID_ID_Credit = ID_ID_Credit;
	}

	/**
	 * 伝送番号（非表示）（修正）を取得します。
	 * 
	 * @return 伝送番号（非表示）（修正）
	 */
	public String getID_ID_Denso() {
		return ID_ID_Denso;
	}

	/**
	 * 伝送番号（非表示）（修正）を設定します。
	 * 
	 * @param ID_ID_Denso
	 *            伝送番号（非表示）（修正）
	 */
	public void setID_ID_Denso(String ID_ID_Denso) {
		this.ID_ID_Denso = ID_ID_Denso;
	}

	/**
	 * 貸付件数（非表示）（修正）を取得します。
	 * 
	 * @return 貸付件数（非表示）（修正）
	 */
	public String getID_Count_Kashitsuke() {
		return ID_Count_Kashitsuke;
	}

	/**
	 * 貸付件数（非表示）（修正）を設定します。
	 * 
	 * @param ID_Count_Kashitsuke
	 *            貸付件数（非表示）（修正）
	 */
	public void setID_Count_Kashitsuke(String ID_Count_Kashitsuke) {
		this.ID_Count_Kashitsuke = ID_Count_Kashitsuke;
	}

	/**
	 * 原本番号（非表示）（修正）を取得します。
	 * 
	 * @return 原本番号（非表示）（修正）
	 */
	public String getID_ID_Maste() {
		return ID_ID_Maste;
	}

	/**
	 * 原本番号（非表示）（修正）を設定します。
	 * 
	 * @param ID_ID_Maste
	 *            原本番号（非表示）（修正）
	 */
	public void setID_ID_Maste(String ID_ID_Maste) {
		this.ID_ID_Maste = ID_ID_Maste;
	}

	/**
	 * 署名データ（非表示）（修正）を取得します。
	 * 
	 * @return 署名データ（非表示）（修正）
	 */
	public String getID_SignData() {
		return ID_SignData;
	}

	/**
	 * 署名データ（非表示）（修正）を設定します。
	 * 
	 * @param ID_SignData
	 *            署名データ（非表示）（修正）
	 */
	public void setID_SignData(String ID_SignData) {
		this.ID_SignData = ID_SignData;
	}

	/**
	 * ステータス（値）（非表示）（修正）を取得します。
	 * 
	 * @return ステータス（値）（非表示）（修正）
	 */
	public String getID_Status() {
		return ID_Status;
	}

	/**
	 * ステータス（値）（非表示）（修正）を設定します。
	 * 
	 * @param ID_Status
	 *            ステータス（値）（非表示）（修正）
	 */
	public void setID_Status(String ID_Status) {
		this.ID_Status = ID_Status;
	}

	/**
	 * データコード（非表示）（修正）を取得します。
	 * 
	 * @return データコード（非表示）（修正）
	 */
	public String getID_DataCode() {
		return ID_DataCode;
	}

	/**
	 * データコード（非表示）（修正）を設定します。
	 * 
	 * @param ID_DataCode
	 *            データコード（非表示）（修正）
	 */
	public void setID_DataCode(String ID_DataCode) {
		this.ID_DataCode = ID_DataCode;
	}

	/**
	 * ユーザID（非表示）（修正）を取得します。
	 * 
	 * @return ユーザID（非表示）（修正）
	 */
	public String getID_UserID() {
		return ID_UserID;
	}

	/**
	 * ユーザID（非表示）（修正）を設定します。
	 * 
	 * @param ID_UserID
	 *            ユーザID（非表示）（修正）
	 */
	public void setID_UserID(String ID_UserID) {
		this.ID_UserID = ID_UserID;
	}

	/**
	 * 報告時分秒（非表示）（修正）を取得します。
	 * 
	 * @return 報告時分秒（非表示）（修正）
	 */
	public String getID_Time_Report() {
		return ID_Time_Report;
	}

	/**
	 * 報告時分秒（非表示）（修正）を設定します。
	 * 
	 * @param ID_Time_Report
	 *            報告時分秒（非表示）（修正）
	 */
	public void setID_Time_Report(String ID_Time_Report) {
		this.ID_Time_Report = ID_Time_Report;
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）（修正）を取得します。
	 * 
	 * @return 貸付実行作成済みフラグ（非表示）（修正）
	 */
	public String getID_Flag_Kj() {
		return ID_Flag_Kj;
	}

	/**
	 * 貸付実行作成済みフラグ（非表示）（修正）を設定します。
	 * 
	 * @param ID_Flag_Kj
	 *            貸付実行作成済みフラグ（非表示）（修正）
	 */
	public void setID_Flag_Kj(String ID_Flag_Kj) {
		this.ID_Flag_Kj = ID_Flag_Kj;
	}

	/**
	 * 顧客コード（非表示）（修正）を取得します。
	 * 
	 * @return 顧客コード（非表示）（修正）
	 */
	public String getID_Code_Customer() {
		return ID_Code_Customer;
	}

	/**
	 * 顧客コード（非表示）（修正）を設定します。
	 * 
	 * @param ID_Code_Customer
	 *            顧客コード（非表示）（修正）
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		this.ID_Code_Customer = ID_Code_Customer;
	}

	/**
	 * 実行起算予定日（非表示）（修正）を取得します。
	 * 
	 * @return 実行起算予定日（非表示）（修正）
	 */
	public String getID_Date_JuriKisan() {
		return ID_Date_JuriKisan;
	}

	/**
	 * 実行起算予定日（非表示）（修正）を設定します。
	 * 
	 * @param ID_Date_JuriKisan
	 *            実行起算予定日（非表示）（修正）
	 */
	public void setID_Date_JuriKisan(String ID_Date_JuriKisan) {
		this.ID_Date_JuriKisan = ID_Date_JuriKisan;
	}

	/**
	 * 決定起算年月日（非表示）（修正）を取得します。
	 * 
	 * @return 決定起算年月日（非表示）（修正）
	 */
	public String getID_Date_KetteiKisan() {
		return ID_Date_KetteiKisan;
	}

	/**
	 * 決定起算年月日（非表示）（修正）を設定します。
	 * 
	 * @param ID_Date_KetteiKisan
	 *            決定起算年月日（非表示）（修正）
	 */
	public void setID_Date_KetteiKisan(String ID_Date_KetteiKisan) {
		this.ID_Date_KetteiKisan = ID_Date_KetteiKisan;
	}

	/**
	 * 退避償還期限年月（非表示）（修正）を取得します。
	 * 
	 * @return 退避償還期限年月（非表示）（修正）
	 */
	public String getID_Keep_Date_ShokanKigen() {
		return ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 退避償還期限年月（非表示）（修正）を設定します。
	 * 
	 * @param ID_Keep_Date_ShokanKigen
	 *            退避償還期限年月（非表示）（修正）
	 */
	public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
		this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 退避履歴番号(非表示)（修正）を取得します。
	 * 
	 * @return 退避履歴番号(非表示)（修正）
	 */
	public String getID_keep_ID_History() {
		return ID_keep_ID_History;
	}

	/**
	 * 退避履歴番号(非表示)（修正）を設定します。
	 * 
	 * @param ID_keep_ID_History
	 *            退避履歴番号(非表示)（修正）
	 */
	public void setID_keep_ID_History(String ID_keep_ID_History) {
		this.ID_keep_ID_History = ID_keep_ID_History;
	}

	/**
	 * 退避実行済みフラグ（非表示）（修正）を取得します。
	 * 
	 * @return 退避実行済みフラグ（非表示）（修正）
	 */
	public String getID_Keep_Flag_Kj() {
		return ID_Keep_Flag_Kj;
	}

	/**
	 * 退避実行済みフラグ（非表示）（修正）を設定します。
	 * 
	 * @param ID_Keep_Flag_Kj
	 *            退避実行済みフラグ（非表示）（修正）
	 */
	public void setID_Keep_Flag_Kj(String ID_Keep_Flag_Kj) {
		this.ID_Keep_Flag_Kj = ID_Keep_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）（修正）を取得します。
	 * 
	 * @return 扱店別稟議データより取得した実行済みフラグ（非表示）（修正）
	 */
	public String getID_aRingi_Flag_Kj() {
		return ID_aRingi_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグ（非表示）（修正）を設定します。
	 * 
	 * @param ID_aRingi_Flag_Kj
	 *            扱店別稟議データより取得した実行済みフラグ（非表示）（修正）
	 */
	public void setID_aRingi_Flag_Kj(String ID_aRingi_Flag_Kj) {
		this.ID_aRingi_Flag_Kj = ID_aRingi_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）（修正）を取得します。
	 * 
	 * @return 扱店別稟議データより取得した償還期限年月（非表示）（修正）
	 */
	public String getID_aRingi_Date_ShokanKigen() {
		return ID_aRingi_Date_ShokanKigen;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）（修正）を設定します。
	 * 
	 * @param ID_aRingi_Date_ShokanKigen
	 *            扱店別稟議データより取得した償還期限年月（非表示）（修正）
	 */
	public void setID_aRingi_Date_ShokanKigen(String ID_aRingi_Date_ShokanKigen) {
		this.ID_aRingi_Date_ShokanKigen = ID_aRingi_Date_ShokanKigen;
	}

	/**
	 * 扱店別稟議データの利率（修正）を取得します。
	 * 
	 * @return 扱店別稟議データの利率（修正）
	 */
	public String getID_aRingi_Riritsu() {
		return ID_aRingi_Riritsu;
	}

	/**
	 * 扱店別稟議データの利率（修正）を設定します。
	 * 
	 * @param ID_aRingi_Riritsu
	 *            扱店別稟議データの利率（修正）
	 */
	public void setID_aRingi_Riritsu(String ID_aRingi_Riritsu) {
		this.ID_aRingi_Riritsu = ID_aRingi_Riritsu;
	}

	/**
	 * 扱店別稟議データの特利（修正）を取得します。
	 * 
	 * @return 扱店別稟議データの特利（修正）
	 */
	public String getID_aRingi_Tokuri() {
		return ID_aRingi_Tokuri;
	}

	/**
	 * 扱店別稟議データの特利（修正）を設定します。
	 * 
	 * @param ID_aRingi_Tokuri
	 *            扱店別稟議データの特利（修正）
	 */
	public void setID_aRingi_Tokuri(String ID_aRingi_Tokuri) {
		this.ID_aRingi_Tokuri = ID_aRingi_Tokuri;
	}

	/**
	 * 最新データ更新日付（非表示）（修正）を取得します。
	 * 
	 * @return 最新データ更新日付（非表示）（修正）
	 */
	public String getID_Data_LastUpDate() {
		return ID_Data_LastUpDate;
	}

	/**
	 * 最新データ更新日付（非表示）（修正）を設定します。
	 * 
	 * @param ID_Data_LastUpDate
	 *            最新データ更新日付（非表示）（修正）
	 */
	public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
		this.ID_Data_LastUpDate = ID_Data_LastUpDate;
	}

}