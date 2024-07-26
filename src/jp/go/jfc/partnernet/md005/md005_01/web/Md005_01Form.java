//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/30 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_01.web;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd005_01のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md005_01Form extends PNBaseForm {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 報告年月日 */
	private String lblID_Date_Report;
	/** エラー */
	private String lblErr;
	/** メッセージ */
	private String lblMessage;
	/** 赤データ入力領域タイトル */
	private String lblID_Head_Red;
	/** 赤データ入力領域タイトル（"赤"） */
	private String lblID_Head_Red2;
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
	/** 充当対象払込期日 */
	private String txtID_Date_JutoTaisho_Red;
	/** 代弁金払込日 */
	private String txtID_Date_DaibenkinHaraikomi_Red;
	/** 遅延損害金(円) */
	private String txtID_M_ChienSongai_Red;
	/** 利息(円) */
	private String txtID_M_Risoku_Red;
	/** 繰上償還手数料(円) */
	private String txtID_M_KurishoCommission_Red;
	/** 元金(円) */
	private String txtID_M_Gankin_Red;
	/** 仮受金(一般口)からの充当額(円) */
	private String txtID_M_KariukeIppanJuto_Red;
	/** 計(円) */
	private String txtID_M_Kei_Red;
	/** 送金額(円) */
	private String txtID_M_Sokin_Red;
	/** 代弁金充当後残元金(円) */
	private String txtID_M_ZanGanAfterDaibenJuto_Red;
	/** 受託者勘定処理年月 */
	private String txtID_Date_Jtkshori_Red;
	/** 送金日 */
	private String txtID_Date_Sokin_Red;
	/** 送金日番号 */
	private String txtID_ID_Sokinbi_Red;
	/** 受託者勘定処理年月(元号) */
	private String drpID_Date_JtkshoriGengou_Red;
	/** 受託者勘定処理年月(年) */
	private String txtID_Date_JtkshoriYear_Red;
	/** 受託者勘定処理年月(月) */
	private String drpID_Date_JtkshoriMonth_Red;
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
	/** 充当対象払込期日(元号)（修正） */
	private String drpID_Date_JutoTaishoGengou;
	/** 充当対象払込期日(年)（修正） */
	private String txtID_Date_JutoTaishoYear;
	/** 充当対象払込期日(月)（修正） */
	private String drpID_Date_JutoTaishoMonth;
	/** 充当対象払込期日(日)（修正） */
	private String drpID_Date_JutoTaishoDay;
	/** 代弁金払込日(元号)（修正） */
	private String drpID_Date_DaibenkinHaraikomiGengou;
	/** 代弁金払込日(年)（修正） */
	private String txtID_Date_DaibenkinHaraikomiYear;
	/** 代弁金払込日(月)（修正） */
	private String drpID_Date_DaibenkinHaraikomiMonth;
	/** 代弁金払込日(日)（修正） */
	private String drpID_Date_DaibenkinHaraikomiDay;
	/** 遅延損害金(円)（修正） */
	private String txtID_M_ChienSongai;
	/** 利息(円)（修正） */
	private String txtID_M_Risoku;
	/** 繰上償還手数料(円)（修正） */
	private String txtID_M_KurishoCommission;
	/** 元金(円)（修正） */
	private String txtID_M_Gankin;
	/** 仮受金(一般口)からの充当額(円)（修正） */
	private String txtID_M_KariukeIppanJuto;
	/** 計(円)（修正） */
	private String txtID_M_Kei;
	/** 送金額(円)（修正） */
	private String txtID_M_Sokin;
	/** 代弁金充当後残元金(円)（修正） */
	private String txtID_M_ZanGanAfterDaibenJuto;
	/** 受託者勘定処理年月（修正） */
	private String txtID_Date_Jtkshori;
	/** 送金日(元号)（修正） */
	private String drpID_Date_SokinGengou;
	/** 送金日(年)（修正） */
	private String txtID_Date_SokinYear;
	/** 送金日(月)（修正） */
	private String drpID_Date_SokinMonth;
	/** 送金日(日)（修正） */
	private String drpID_Date_SokinDay;
	/** 送金日番号（修正） */
	private String txtID_ID_Sokinbi;
	/** 受託者勘定処理年月(元号)（修正） */
	private String drpID_Date_JtkshoriGengou;
	/** 受託者勘定処理年月(年)（修正） */
	private String txtID_Date_JtkshoriYear;
	/** 受託者勘定処理年月(月)（修正） */
	private String drpID_Date_JtkshoriMonth;
	/** 報告書番号 */
	private String ID_ID_Report;
	/** 報告年月日A */
	private String ID_Date_Report;
	/** 扱店名A */
	private String ID_Name_Organization;
	/** 顧客名A */
	private String ID_Name_Customer;
	/** 公庫支店A */
	private String ID_Code_KoukoShiten;
	/** 扱店A */
	private String ID_Code_Organization;
	/** 店舗A */
	private String ID_Code_Tenpo;
	/** 年度A */
	private String ID_Year;
	/** 方式資金A */
	private String ID_Code_HoshikiShikin;
	/** 番号A */
	private String ID_ID_Ringi;
	/** 枝番A */
	private String ID_ID_RingiBranch;
	/** 充当対象払込期日A */
	private String ID_Date_JutoTaisho;
	/** 充当対象払込期日(元号) */
	private String ID_Date_JutoTaishoGengou;
	/** 充当対象払込期日(西暦年) */
	private String ID_Date_JutoTaishoYear;
	/** 充当対象払込期日(月) */
	private String ID_Date_JutoTaishoMonth;
	/** 充当対象払込期日入力 */
	private String ID_Date_JutoTaishoYear_Input;
	/** 充当対象払込期日(日) */
	private String ID_Date_JutoTaishoDay;
	/** 代弁金払込日A */
	private String ID_Date_DaibenkinHaraikomi;
	/** 代弁金払込日(元号) */
	private String ID_Date_DaibenkinHaraikomiGengou;
	/** 代位金払込日入力 */
	private String ID_Date_DaibenkinHaraikomiYear_Input;
	/** 代弁金払込日(西暦年) */
	private String ID_Date_DaibenkinHaraikomiYear;
	/** 代弁金払込日(月) */
	private String ID_Date_DaibenkinHaraikomiMonth;
	/** 代弁金払込日(日) */
	private String ID_Date_DaibenkinHaraikomiDay;
	/** 遅延損害金 */
	private String ID_M_ChienSongai;
	/** 利息 */
	private String ID_M_Risoku;
	/** 元金 */
	private String ID_M_Gankin;
	/** 計 */
	private String ID_M_Kei;
	/** 仮受金(一般口)からの充当額 */
	private String ID_M_KariukeIppanJuto;
	/** 代弁金充当後残元金 */
	private String ID_M_ZanGanAfterDaibenJuto;
	/** 繰上償還手数料 */
	private String ID_M_KurishoCommission;
	/** 送金額 */
	private String ID_M_Sokin;
	/** 送金日A */
	private String ID_Date_Sokin;
	/** 送信日(年号) */
	private String ID_Date_SokinGengou;
	/** 送信日(西暦年) */
	private String ID_Date_SokinYear;
	/** 送信日人力 */
	private String ID_Date_SokinYear_Input;
	/** 送信日(月) */
	private String ID_Date_SokinMonth;
	/** 送信日(日) */
	private String ID_Date_SokinDay;
	/** 送金日番号A */
	private String ID_ID_Sokinbi;
	/** 受託者勘定処理年月A */
	private String ID_Date_Jtkshori;
	/** 受託者勘定処理年月入力 */
	private String ID_Date_JtkshoriYear_Input;
	/** 受託者勘定処理年月(元号) */
	private String ID_Date_JtkshoriGengou;
	/** 受託者勘定処理年月(年) */
	private String ID_Date_JtkshoriYear;
	/** 受託者勘定処理年月(月) */
	private String ID_Date_JtkshoriMonth;
	/** M_貸付残高 */
	private String ID_M_KashitsukeZandaka;
	/** 表示画面のヘッダ項目 */
	private String ID_InputHead;
	/** 債権管理番号 */
	private String ID_ID_Credit;
	/** 請求繰償利息 */
	private String ID_M_SeiKuriRisoku;
	/** 請求繰償元金 */
	private String ID_M_SeiKuriGankin;
	/** 請求データに登録を行う請求繰償利息 */
	private String ID_Seikyu_M_SeiKuriRisoku;
	/** 請求データに登録を行う請求繰償元金 */
	private String ID_Seikyu_M_SeiKuriGankin;
	/** M_約定利息 */
	private String ID_M_YakujoRisoku;
	/** M_約定元金 */
	private String ID_M_YakujoGankin;
	/** 退避貸付金残高（非表示） */
	private String ID_Keep_M_KashitsukeZan;
	/** 退避約定元金 */
	private String ID_Keep_M_YakujoGankin;
	/** 退避約定利息 */
	private String ID_Keep_M_YakujoRisoku;
	/** 退避請求繰償利息 */
	private String ID_Keep_Seikyu_M_SeiKuriRisoku;
	/** 退避請求繰償元金 */
	private String ID_Keep_Seikyu_M_SeiKuriGankin;
	/** 取消済みフラグ（非表示） */
	private String ID_Flag_Torikeshizumi;
	/** 退避償還期限（非表示） */
	private String ID_Keep_Date_ShokanKigen;
	/** 報告時分秒（非表示） */
	private String ID_Time_Report;
	/** 原本番号 */
	private String ID_ID_Master;
	/** 電子署名付データ（非表示） */
	private String ID_SignData;
	/** 取消用払出・債権管理番号 */
	private String ID_Ins_ID_Credit;
	/** 扱店別稟議データに登録を行う払込前残元金 */
	private String ID_M_KashitsukeZandaka_aRingi;
	/** 扱店別稟議データに登録を行う償還期限 */
	private String ID_Date_ShokanKigen_aRingi;
	/** 請求データに登録を行う約定利息 */
	private String ID_M_YakujoRisoku_Seikyu;
	/** 請求データに登録を行う約定元金 */
	private String ID_M_YakujoGankin_Yakujo;
	/** 履歴番号（非表示） */
	private String ID_ID_History;
	/** ステータス（非表示） */
	private String ID_Status;
	/** 処理種別 */
	private String ID_Type_Process;
	/** データコード */
	private String ID_DataCode;
	/** 扱店別稟議データの最新データ更新日付 */
	private String ID_Data_LastUpDate;
	/** ユーザID（非表示） */
	private String ID_User_ID;
	/** 伝送番号（非表示） */
	private String ID_ID_Denso;
	/** エラー番号（非表示） */
	private String ID_Code_Error;
	/** エラーメッセージ（非表示） */
	private String ID_ErrorMessage;
	/** 顧客コード（非表示） */
	private String ID_Code_Customer;
	/** 方式(非表示） */
	private String ID_Kubun_Hoshiki;
	/** 資金(非表示） */
	private String ID_Kubun_Shikin;
	/** 償還期限年月(非表示) */
	private String ID_Date_ShokanKigen;
	/** 退避履歴番号 */
	private String ID_Keep_ID_History;
	/** 退避実行済みフラグ */
	private String ID_Keep_Flag_Kj;
	/** 扱店別稟議データより取得した実行済みフラグ */
	private String ID_aRingi_Flag_Kj;
	/** 扱店別稟議データより取得した償還期限年月 */
	private String ID_aRingi_Date_ShokanKigen;
	/** 報告書種別（値）(非表示) */
	private String dataCode;
	/** 処理モード */
	private String processMode;
	/** 赤データ入力域 */
	private String red_Area;
	/** 黒データ入力域 */
	private String brack_Area;
	/** モードタイプ */
	private String modeType;
	/** 退避貸付金残高（非表示） */
	private BigDecimal keep_M_KashitsukeZan;
	/** 更正（赤）データの請求データ「約定利息」 */
	private String ID_M_YakujoRisoku_Seikyu_Red;
	/** 更正（赤）データの請求データ「約定元金」 */
	private String ID_M_YakujoGankin_Seikyu_Red;
	/** 更正（赤）データの請求データ「請求繰償利息」 */
	private String ID_M_SeiKuriRisoku_Seikyu_Red;
	/** 更正（赤）データの請求データ「請求繰償元金」 */
	private String ID_M_SeiKuriGankin_Seikyu_Red;

	/**
	 * 報告年月日を取得します。
	 *
	 * @return 報告年月日
	 */
	public String getLblID_Date_Report() {
		return lblID_Date_Report;
	}

	/**
	 * 報告年月日を設定します。
	 *
	 * @param lblID_Date_Report
	 *            報告年月日
	 */
	public void setLblID_Date_Report(String lblID_Date_Report) {
		this.lblID_Date_Report = lblID_Date_Report;
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
	 * 赤データ入力領域タイトル（"赤"） を取得します。
	 *
	 * @return 赤データ入力領域タイトル（"赤"）
	 */
	public String getLblID_Head_Red2() {
		return lblID_Head_Red2;
	}

	/**
	 * 赤データ入力領域タイトル（"赤"） を設定します。
	 *
	 * @param lblID_Head_Red2
	 *            赤データ入力領域タイトル（"赤"）
	 */
	public void setLblID_Head_Red2(String lblID_Head_Red2) {
		this.lblID_Head_Red2 = lblID_Head_Red2;
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
	 * 充当対象払込期日を取得します。
	 *
	 * @return 充当対象払込期日
	 */
	public String getTxtID_Date_JutoTaisho_Red() {
		return txtID_Date_JutoTaisho_Red;
	}

	/**
	 * 充当対象払込期日を設定します。
	 *
	 * @param txtID_Date_JutoTaisho_Red
	 *            充当対象払込期日
	 */
	public void setTxtID_Date_JutoTaisho_Red(String txtID_Date_JutoTaisho_Red) {
		this.txtID_Date_JutoTaisho_Red = txtID_Date_JutoTaisho_Red;
	}

	/**
	 * 代弁金払込日を取得します。
	 *
	 * @return 代弁金払込日
	 */
	public String getTxtID_Date_DaibenkinHaraikomi_Red() {
		return txtID_Date_DaibenkinHaraikomi_Red;
	}

	/**
	 * 代弁金払込日を設定します。
	 *
	 * @param txtID_Date_DaibenkinHaraikomi_Red
	 *            代弁金払込日
	 */
	public void setTxtID_Date_DaibenkinHaraikomi_Red(
			String txtID_Date_DaibenkinHaraikomi_Red) {
		this.txtID_Date_DaibenkinHaraikomi_Red = txtID_Date_DaibenkinHaraikomi_Red;
	}

	/**
	 * 遅延損害金(円)を取得します。
	 *
	 * @return 遅延損害金(円)
	 */
	public String getTxtID_M_ChienSongai_Red() {
		return txtID_M_ChienSongai_Red;
	}

	/**
	 * 遅延損害金(円)を設定します。
	 *
	 * @param txtID_M_ChienSongai_Red
	 *            遅延損害金(円)
	 */
	public void setTxtID_M_ChienSongai_Red(String txtID_M_ChienSongai_Red) {
		this.txtID_M_ChienSongai_Red = txtID_M_ChienSongai_Red;
	}

	/**
	 * 利息(円)を取得します。
	 *
	 * @return 利息(円)
	 */
	public String getTxtID_M_Risoku_Red() {
		return txtID_M_Risoku_Red;
	}

	/**
	 * 利息(円)を設定します。
	 *
	 * @param txtID_M_Risoku_Red
	 *            利息(円)
	 */
	public void setTxtID_M_Risoku_Red(String txtID_M_Risoku_Red) {
		this.txtID_M_Risoku_Red = txtID_M_Risoku_Red;
	}

	/**
	 * 繰上償還手数料(円)を取得します。
	 *
	 * @return 繰上償還手数料(円)
	 */
	public String getTxtID_M_KurishoCommission_Red() {
		return txtID_M_KurishoCommission_Red;
	}

	/**
	 * 繰上償還手数料(円)を設定します。
	 *
	 * @param txtID_M_KurishoCommission_Red
	 *            繰上償還手数料(円)
	 */
	public void setTxtID_M_KurishoCommission_Red(
			String txtID_M_KurishoCommission_Red) {
		this.txtID_M_KurishoCommission_Red = txtID_M_KurishoCommission_Red;
	}

	/**
	 * 元金(円)を取得します。
	 *
	 * @return 元金(円)
	 */
	public String getTxtID_M_Gankin_Red() {
		return txtID_M_Gankin_Red;
	}

	/**
	 * 元金(円)を設定します。
	 *
	 * @param txtID_M_Gankin_Red
	 *            元金(円)
	 */
	public void setTxtID_M_Gankin_Red(String txtID_M_Gankin_Red) {
		this.txtID_M_Gankin_Red = txtID_M_Gankin_Red;
	}

	/**
	 * 仮受金(一般口)からの充当額(円)を取得します。
	 *
	 * @return 仮受金(一般口)からの充当額(円)
	 */
	public String getTxtID_M_KariukeIppanJuto_Red() {
		return txtID_M_KariukeIppanJuto_Red;
	}

	/**
	 * 仮受金(一般口)からの充当額(円)を設定します。
	 *
	 * @param txtID_M_KariukeIppanJuto_Red
	 *            仮受金(一般口)からの充当額(円)
	 */
	public void setTxtID_M_KariukeIppanJuto_Red(
			String txtID_M_KariukeIppanJuto_Red) {
		this.txtID_M_KariukeIppanJuto_Red = txtID_M_KariukeIppanJuto_Red;
	}

	/**
	 * 計(円)を取得します。
	 *
	 * @return 計(円)
	 */
	public String getTxtID_M_Kei_Red() {
		return txtID_M_Kei_Red;
	}

	/**
	 * 計(円)を設定します。
	 *
	 * @param txtID_M_Kei_Red
	 *            計(円)
	 */
	public void setTxtID_M_Kei_Red(String txtID_M_Kei_Red) {
		this.txtID_M_Kei_Red = txtID_M_Kei_Red;
	}

	/**
	 * 送金額(円)を取得します。
	 *
	 * @return 送金額(円)
	 */
	public String getTxtID_M_Sokin_Red() {
		return txtID_M_Sokin_Red;
	}

	/**
	 * 送金額(円)を設定します。
	 *
	 * @param txtID_M_Sokin_Red
	 *            送金額(円)
	 */
	public void setTxtID_M_Sokin_Red(String txtID_M_Sokin_Red) {
		this.txtID_M_Sokin_Red = txtID_M_Sokin_Red;
	}

	/**
	 * 代弁金充当後残元金(円)を取得します。
	 *
	 * @return 代弁金充当後残元金(円)
	 */
	public String getTxtID_M_ZanGanAfterDaibenJuto_Red() {
		return txtID_M_ZanGanAfterDaibenJuto_Red;
	}

	/**
	 * 代弁金充当後残元金(円)を設定します。
	 *
	 * @param txtID_M_ZanGanAfterDaibenJuto_Red
	 *            代弁金充当後残元金(円)
	 */
	public void setTxtID_M_ZanGanAfterDaibenJuto_Red(
			String txtID_M_ZanGanAfterDaibenJuto_Red) {
		this.txtID_M_ZanGanAfterDaibenJuto_Red = txtID_M_ZanGanAfterDaibenJuto_Red;
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
	 * 送金日を取得します。
	 *
	 * @return 送金日
	 */
	public String getTxtID_Date_Sokin_Red() {
		return txtID_Date_Sokin_Red;
	}

	/**
	 * 送金日を設定します。
	 *
	 * @param txtID_Date_Sokin_Red
	 *            送金日
	 */
	public void setTxtID_Date_Sokin_Red(String txtID_Date_Sokin_Red) {
		this.txtID_Date_Sokin_Red = txtID_Date_Sokin_Red;
	}

	/**
	 * 送金日番号を取得します。
	 *
	 * @return 送金日番号
	 */
	public String getTxtID_ID_Sokinbi_Red() {
		return txtID_ID_Sokinbi_Red;
	}

	/**
	 * 送金日番号を設定します。
	 *
	 * @param txtID_ID_Sokinbi_Red
	 *            送金日番号
	 */
	public void setTxtID_ID_Sokinbi_Red(String txtID_ID_Sokinbi_Red) {
		this.txtID_ID_Sokinbi_Red = txtID_ID_Sokinbi_Red;
	}

	/**
	 * 受託者勘定処理年月(元号)を取得します。
	 *
	 * @return 受託者勘定処理年月(元号)
	 */
	public String getDrpID_Date_JtkshoriGengou_Red() {
		return drpID_Date_JtkshoriGengou_Red;
	}

	/**
	 * 受託者勘定処理年月(元号)を設定します。
	 *
	 * @param drpID_Date_JtkshoriGengou_Red
	 *            受託者勘定処理年月(元号)
	 */
	public void setDrpID_Date_JtkshoriGengou_Red(
			String drpID_Date_JtkshoriGengou_Red) {
		this.drpID_Date_JtkshoriGengou_Red = drpID_Date_JtkshoriGengou_Red;
	}

	/**
	 * 受託者勘定処理年月(年)を取得します。
	 *
	 * @return 受託者勘定処理年月(年)
	 */
	public String getTxtID_Date_JtkshoriYear_Red() {
		return txtID_Date_JtkshoriYear_Red;
	}

	/**
	 * 受託者勘定処理年月(年)を設定します。
	 *
	 * @param txtID_Date_JtkshoriYear_Red
	 *            受託者勘定処理年月(年)
	 */
	public void setTxtID_Date_JtkshoriYear_Red(
			String txtID_Date_JtkshoriYear_Red) {
		this.txtID_Date_JtkshoriYear_Red = txtID_Date_JtkshoriYear_Red;
	}

	/**
	 * 受託者勘定処理年月(月)を取得します。
	 *
	 * @return 受託者勘定処理年月(月)
	 */
	public String getDrpID_Date_JtkshoriMonth_Red() {
		return drpID_Date_JtkshoriMonth_Red;
	}

	/**
	 * 受託者勘定処理年月(月)を設定します。
	 *
	 * @param drpID_Date_JtkshoriMonth_Red
	 *            受託者勘定処理年月(月)
	 */
	public void setDrpID_Date_JtkshoriMonth_Red(
			String drpID_Date_JtkshoriMonth_Red) {
		this.drpID_Date_JtkshoriMonth_Red = drpID_Date_JtkshoriMonth_Red;
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
	 * 充当対象払込期日(元号)（修正）を取得します。
	 *
	 * @return 充当対象払込期日(元号)（修正）
	 */
	public String getDrpID_Date_JutoTaishoGengou() {
		return drpID_Date_JutoTaishoGengou;
	}

	/**
	 * 充当対象払込期日(元号)（修正）を設定します。
	 *
	 * @param drpID_Date_JutoTaishoGengou
	 *            充当対象払込期日(元号)（修正）
	 */
	public void setDrpID_Date_JutoTaishoGengou(
			String drpID_Date_JutoTaishoGengou) {
		this.drpID_Date_JutoTaishoGengou = drpID_Date_JutoTaishoGengou;
	}

	/**
	 * 充当対象払込期日(年)（修正）を取得します。
	 *
	 * @return 充当対象払込期日(年)（修正）
	 */
	public String getTxtID_Date_JutoTaishoYear() {
		return txtID_Date_JutoTaishoYear;
	}

	/**
	 * 充当対象払込期日(年)（修正）を設定します。
	 *
	 * @param txtID_Date_JutoTaishoYear
	 *            充当対象払込期日(年)（修正）
	 */
	public void setTxtID_Date_JutoTaishoYear(String txtID_Date_JutoTaishoYear) {
		this.txtID_Date_JutoTaishoYear = txtID_Date_JutoTaishoYear;
	}

	/**
	 * 充当対象払込期日(月)（修正）を取得します。
	 *
	 * @return 充当対象払込期日(月)（修正）
	 */
	public String getDrpID_Date_JutoTaishoMonth() {
		return drpID_Date_JutoTaishoMonth;
	}

	/**
	 * 充当対象払込期日(月)（修正）を設定します。
	 *
	 * @param drpID_Date_JutoTaishoMonth
	 *            充当対象払込期日(月)（修正）
	 */
	public void setDrpID_Date_JutoTaishoMonth(String drpID_Date_JutoTaishoMonth) {
		this.drpID_Date_JutoTaishoMonth = drpID_Date_JutoTaishoMonth;
	}

	/**
	 * 充当対象払込期日(日)（修正）を取得します。
	 *
	 * @return 充当対象払込期日(日)（修正）
	 */
	public String getDrpID_Date_JutoTaishoDay() {
		return drpID_Date_JutoTaishoDay;
	}

	/**
	 * 充当対象払込期日(日)（修正）を設定します。
	 *
	 * @param drpID_Date_JutoTaishoDay
	 *            充当対象払込期日(日)（修正）
	 */
	public void setDrpID_Date_JutoTaishoDay(String drpID_Date_JutoTaishoDay) {
		this.drpID_Date_JutoTaishoDay = drpID_Date_JutoTaishoDay;
	}

	/**
	 * 代弁金払込日(元号)（修正）を取得します。
	 *
	 * @return 代弁金払込日(元号)（修正）
	 */
	public String getDrpID_Date_DaibenkinHaraikomiGengou() {
		return drpID_Date_DaibenkinHaraikomiGengou;
	}

	/**
	 * 代弁金払込日(元号)（修正）を設定します。
	 *
	 * @param drpID_Date_DaibenkinHaraikomiGengou
	 *            代弁金払込日(元号)（修正）
	 */
	public void setDrpID_Date_DaibenkinHaraikomiGengou(
			String drpID_Date_DaibenkinHaraikomiGengou) {
		this.drpID_Date_DaibenkinHaraikomiGengou = drpID_Date_DaibenkinHaraikomiGengou;
	}

	/**
	 * 代弁金払込日(年)（修正）を取得します。
	 *
	 * @return 代弁金払込日(年)（修正）
	 */
	public String getTxtID_Date_DaibenkinHaraikomiYear() {
		return txtID_Date_DaibenkinHaraikomiYear;
	}

	/**
	 * 代弁金払込日(年)（修正）を設定します。
	 *
	 * @param txtID_Date_DaibenkinHaraikomiYear
	 *            代弁金払込日(年)（修正）
	 */
	public void setTxtID_Date_DaibenkinHaraikomiYear(
			String txtID_Date_DaibenkinHaraikomiYear) {
		this.txtID_Date_DaibenkinHaraikomiYear = txtID_Date_DaibenkinHaraikomiYear;
	}

	/**
	 * 代弁金払込日(月)（修正）を取得します。
	 *
	 * @return 代弁金払込日(月)（修正）
	 */
	public String getDrpID_Date_DaibenkinHaraikomiMonth() {
		return drpID_Date_DaibenkinHaraikomiMonth;
	}

	/**
	 * 代弁金払込日(月)（修正）を設定します。
	 *
	 * @param drpID_Date_DaibenkinHaraikomiMonth
	 *            代弁金払込日(月)（修正）
	 */
	public void setDrpID_Date_DaibenkinHaraikomiMonth(
			String drpID_Date_DaibenkinHaraikomiMonth) {
		this.drpID_Date_DaibenkinHaraikomiMonth = drpID_Date_DaibenkinHaraikomiMonth;
	}

	/**
	 * 代弁金払込日(日)（修正）を取得します。
	 *
	 * @return 代弁金払込日(日)（修正）
	 */
	public String getDrpID_Date_DaibenkinHaraikomiDay() {
		return drpID_Date_DaibenkinHaraikomiDay;
	}

	/**
	 * 代弁金払込日(日)（修正）を設定します。
	 *
	 * @param drpID_Date_DaibenkinHaraikomiDay
	 *            代弁金払込日(日)（修正）
	 */
	public void setDrpID_Date_DaibenkinHaraikomiDay(
			String drpID_Date_DaibenkinHaraikomiDay) {
		this.drpID_Date_DaibenkinHaraikomiDay = drpID_Date_DaibenkinHaraikomiDay;
	}

	/**
	 * 遅延損害金(円)（修正）を取得します。
	 *
	 * @return 遅延損害金(円)（修正）
	 */
	public String getTxtID_M_ChienSongai() {
		return txtID_M_ChienSongai;
	}

	/**
	 * 遅延損害金(円)（修正）を設定します。
	 *
	 * @param txtID_M_ChienSongai
	 *            遅延損害金(円)（修正）
	 */
	public void setTxtID_M_ChienSongai(String txtID_M_ChienSongai) {
		this.txtID_M_ChienSongai = txtID_M_ChienSongai;
	}

	/**
	 * 利息(円)（修正）を取得します。
	 *
	 * @return 利息(円)（修正）
	 */
	public String getTxtID_M_Risoku() {
		return txtID_M_Risoku;
	}

	/**
	 * 利息(円)（修正）を設定します。
	 *
	 * @param txtID_M_Risoku
	 *            利息(円)（修正）
	 */
	public void setTxtID_M_Risoku(String txtID_M_Risoku) {
		this.txtID_M_Risoku = txtID_M_Risoku;
	}

	/**
	 * 繰上償還手数料(円)（修正）を取得します。
	 *
	 * @return 繰上償還手数料(円)（修正）
	 */
	public String getTxtID_M_KurishoCommission() {
		return txtID_M_KurishoCommission;
	}

	/**
	 * 繰上償還手数料(円)（修正）を設定します。
	 *
	 * @param txtID_M_KurishoCommission
	 *            繰上償還手数料(円)（修正）
	 */
	public void setTxtID_M_KurishoCommission(String txtID_M_KurishoCommission) {
		this.txtID_M_KurishoCommission = txtID_M_KurishoCommission;
	}

	/**
	 * 元金(円)（修正）を取得します。
	 *
	 * @return 元金(円)（修正）
	 */
	public String getTxtID_M_Gankin() {
		return txtID_M_Gankin;
	}

	/**
	 * 元金(円)（修正）を設定します。
	 *
	 * @param txtID_M_Gankin
	 *            元金(円)（修正）
	 */
	public void setTxtID_M_Gankin(String txtID_M_Gankin) {
		this.txtID_M_Gankin = txtID_M_Gankin;
	}

	/**
	 * 仮受金(一般口)からの充当額(円)（修正）を取得します。
	 *
	 * @return 仮受金(一般口)からの充当額(円)（修正）
	 */
	public String getTxtID_M_KariukeIppanJuto() {
		return txtID_M_KariukeIppanJuto;
	}

	/**
	 * 仮受金(一般口)からの充当額(円)（修正）を設定します。
	 *
	 * @param txtID_M_KariukeIppanJuto
	 *            仮受金(一般口)からの充当額(円)（修正）
	 */
	public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
		this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
	}

	/**
	 * 計(円)（修正）を取得します。
	 *
	 * @return 計(円)（修正）
	 */
	public String getTxtID_M_Kei() {
		return txtID_M_Kei;
	}

	/**
	 * 計(円)（修正）を設定します。
	 *
	 * @param txtID_M_Kei
	 *            計(円)（修正）
	 */
	public void setTxtID_M_Kei(String txtID_M_Kei) {
		this.txtID_M_Kei = txtID_M_Kei;
	}

	/**
	 * 送金額(円)（修正）を取得します。
	 *
	 * @return 送金額(円)（修正）
	 */
	public String getTxtID_M_Sokin() {
		return txtID_M_Sokin;
	}

	/**
	 * 送金額(円)（修正）を設定します。
	 *
	 * @param txtID_M_Sokin
	 *            送金額(円)（修正）
	 */
	public void setTxtID_M_Sokin(String txtID_M_Sokin) {
		this.txtID_M_Sokin = txtID_M_Sokin;
	}

	/**
	 * 代弁金充当後残元金(円)（修正）を取得します。
	 *
	 * @return 代弁金充当後残元金(円)（修正）
	 */
	public String getTxtID_M_ZanGanAfterDaibenJuto() {
		return txtID_M_ZanGanAfterDaibenJuto;
	}

	/**
	 * 代弁金充当後残元金(円)（修正）を設定します。
	 *
	 * @param txtID_M_ZanGanAfterDaibenJuto
	 *            代弁金充当後残元金(円)（修正）
	 */
	public void setTxtID_M_ZanGanAfterDaibenJuto(
			String txtID_M_ZanGanAfterDaibenJuto) {
		this.txtID_M_ZanGanAfterDaibenJuto = txtID_M_ZanGanAfterDaibenJuto;
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
	 * 送金日(元号)（修正）を取得します。
	 *
	 * @return 送金日(元号)（修正）
	 */
	public String getDrpID_Date_SokinGengou() {
		return drpID_Date_SokinGengou;
	}

	/**
	 * 送金日(元号)（修正）を設定します。
	 *
	 * @param drpID_Date_SokinGengou
	 *            送金日(元号)（修正）
	 */
	public void setDrpID_Date_SokinGengou(String drpID_Date_SokinGengou) {
		this.drpID_Date_SokinGengou = drpID_Date_SokinGengou;
	}

	/**
	 * 送金日(年)（修正）を取得します。
	 *
	 * @return 送金日(年)（修正）
	 */
	public String getTxtID_Date_SokinYear() {
		return txtID_Date_SokinYear;
	}

	/**
	 * 送金日(年)（修正）を設定します。
	 *
	 * @param txtID_Date_SokinYear
	 *            送金日(年)（修正）
	 */
	public void setTxtID_Date_SokinYear(String txtID_Date_SokinYear) {
		this.txtID_Date_SokinYear = txtID_Date_SokinYear;
	}

	/**
	 * 送金日(月)（修正）を取得します。
	 *
	 * @return 送金日(月)（修正）
	 */
	public String getDrpID_Date_SokinMonth() {
		return drpID_Date_SokinMonth;
	}

	/**
	 * 送金日(月)（修正）を設定します。
	 *
	 * @param drpID_Date_SokinMonth
	 *            送金日(月)（修正）
	 */
	public void setDrpID_Date_SokinMonth(String drpID_Date_SokinMonth) {
		this.drpID_Date_SokinMonth = drpID_Date_SokinMonth;
	}

	/**
	 * 送金日(日)（修正）を取得します。
	 *
	 * @return 送金日(日)（修正）
	 */
	public String getDrpID_Date_SokinDay() {
		return drpID_Date_SokinDay;
	}

	/**
	 * 送金日(日)（修正）を設定します。
	 *
	 * @param drpID_Date_SokinDay
	 *            送金日(日)（修正）
	 */
	public void setDrpID_Date_SokinDay(String drpID_Date_SokinDay) {
		this.drpID_Date_SokinDay = drpID_Date_SokinDay;
	}

	/**
	 * 送金日番号（修正）を取得します。
	 *
	 * @return 送金日番号（修正）
	 */
	public String getTxtID_ID_Sokinbi() {
		return txtID_ID_Sokinbi;
	}

	/**
	 * 送金日番号（修正）を設定します。
	 *
	 * @param txtID_ID_Sokinbi
	 *            送金日番号（修正）
	 */
	public void setTxtID_ID_Sokinbi(String txtID_ID_Sokinbi) {
		this.txtID_ID_Sokinbi = txtID_ID_Sokinbi;
	}

	/**
	 * 受託者勘定処理年月(元号)（修正）を取得します。
	 *
	 * @return 受託者勘定処理年月(元号)（修正）
	 */
	public String getDrpID_Date_JtkshoriGengou() {
		return drpID_Date_JtkshoriGengou;
	}

	/**
	 * 受託者勘定処理年月(元号)（修正）を設定します。
	 *
	 * @param drpID_Date_JtkshoriGengou
	 *            受託者勘定処理年月(元号)（修正）
	 */
	public void setDrpID_Date_JtkshoriGengou(String drpID_Date_JtkshoriGengou) {
		this.drpID_Date_JtkshoriGengou = drpID_Date_JtkshoriGengou;
	}

	/**
	 * 受託者勘定処理年月(年)（修正）を取得します。
	 *
	 * @return 受託者勘定処理年月(年)（修正）
	 */
	public String getTxtID_Date_JtkshoriYear() {
		return txtID_Date_JtkshoriYear;
	}

	/**
	 * 受託者勘定処理年月(年)（修正）を設定します。
	 *
	 * @param txtID_Date_JtkshoriYear
	 *            受託者勘定処理年月(年)（修正）
	 */
	public void setTxtID_Date_JtkshoriYear(String txtID_Date_JtkshoriYear) {
		this.txtID_Date_JtkshoriYear = txtID_Date_JtkshoriYear;
	}

	/**
	 * 受託者勘定処理年月(月)（修正）を取得します。
	 *
	 * @return 受託者勘定処理年月(月)（修正）
	 */
	public String getDrpID_Date_JtkshoriMonth() {
		return drpID_Date_JtkshoriMonth;
	}

	/**
	 * 受託者勘定処理年月(月)（修正）を設定します。
	 *
	 * @param drpID_Date_JtkshoriMonth
	 *            受託者勘定処理年月(月)（修正）
	 */
	public void setDrpID_Date_JtkshoriMonth(String drpID_Date_JtkshoriMonth) {
		this.drpID_Date_JtkshoriMonth = drpID_Date_JtkshoriMonth;
	}

	/**
	 * 報告書番号を取得します。
	 *
	 * @return 報告書番号
	 */
	public String getID_ID_Report() {
		return ID_ID_Report;
	}

	/**
	 * 報告書番号を設定します。
	 *
	 * @param ID_ID_Report
	 *            報告書番号
	 */
	public void setID_ID_Report(String ID_ID_Report) {
		this.ID_ID_Report = ID_ID_Report;
	}

	/**
	 * 報告年月日Aを取得します。
	 *
	 * @return 報告年月日A
	 */
	public String getID_Date_Report() {
		return ID_Date_Report;
	}

	/**
	 * 報告年月日Aを設定します。
	 *
	 * @param ID_Date_Report
	 *            報告年月日A
	 */
	public void setID_Date_Report(String ID_Date_Report) {
		this.ID_Date_Report = ID_Date_Report;
	}

	/**
	 * 扱店名Aを取得します。
	 *
	 * @return 扱店名A
	 */
	public String getID_Name_Organization() {
		return ID_Name_Organization;
	}

	/**
	 * 扱店名Aを設定します。
	 *
	 * @param ID_Name_Organization
	 *            扱店名A
	 */
	public void setID_Name_Organization(String ID_Name_Organization) {
		this.ID_Name_Organization = ID_Name_Organization;
	}

	/**
	 * 顧客名Aを取得します。
	 *
	 * @return 顧客名A
	 */
	public String getID_Name_Customer() {
		return ID_Name_Customer;
	}

	/**
	 * 顧客名Aを設定します。
	 *
	 * @param ID_Name_Customer
	 *            顧客名A
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		this.ID_Name_Customer = ID_Name_Customer;
	}

	/**
	 * 公庫支店Aを取得します。
	 *
	 * @return 公庫支店A
	 */
	public String getID_Code_KoukoShiten() {
		return ID_Code_KoukoShiten;
	}

	/**
	 * 公庫支店Aを設定します。
	 *
	 * @param ID_Code_KoukoShiten
	 *            公庫支店A
	 */
	public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
		this.ID_Code_KoukoShiten = ID_Code_KoukoShiten;
	}

	/**
	 * 扱店Aを取得します。
	 *
	 * @return 扱店A
	 */
	public String getID_Code_Organization() {
		return ID_Code_Organization;
	}

	/**
	 * 扱店Aを設定します。
	 *
	 * @param ID_Code_Organization
	 *            扱店A
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		this.ID_Code_Organization = ID_Code_Organization;
	}

	/**
	 * 店舗Aを取得します。
	 *
	 * @return 店舗A
	 */
	public String getID_Code_Tenpo() {
		return ID_Code_Tenpo;
	}

	/**
	 * 店舗Aを設定します。
	 *
	 * @param ID_Code_Tenpo
	 *            店舗A
	 */
	public void setID_Code_Tenpo(String ID_Code_Tenpo) {
		this.ID_Code_Tenpo = ID_Code_Tenpo;
	}

	/**
	 * 年度Aを取得します。
	 *
	 * @return 年度A
	 */
	public String getID_Year() {
		return ID_Year;
	}

	/**
	 * 年度Aを設定します。
	 *
	 * @param ID_Year
	 *            年度A
	 */
	public void setID_Year(String ID_Year) {
		this.ID_Year = ID_Year;
	}

	/**
	 * 方式資金Aを取得します。
	 *
	 * @return 方式資金A
	 */
	public String getID_Code_HoshikiShikin() {
		return ID_Code_HoshikiShikin;
	}

	/**
	 * 方式資金Aを設定します。
	 *
	 * @param ID_Code_HoshikiShikin
	 *            方式資金A
	 */
	public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
		this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
	}

	/**
	 * 番号Aを取得します。
	 *
	 * @return 番号A
	 */
	public String getID_ID_Ringi() {
		return ID_ID_Ringi;
	}

	/**
	 * 番号Aを設定します。
	 *
	 * @param ID_ID_Ringi
	 *            番号A
	 */
	public void setID_ID_Ringi(String ID_ID_Ringi) {
		this.ID_ID_Ringi = ID_ID_Ringi;
	}

	/**
	 * 枝番Aを取得します。
	 *
	 * @return 枝番A
	 */
	public String getID_ID_RingiBranch() {
		return ID_ID_RingiBranch;
	}

	/**
	 * 枝番Aを設定します。
	 *
	 * @param ID_ID_RingiBranch
	 *            枝番A
	 */
	public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
		this.ID_ID_RingiBranch = ID_ID_RingiBranch;
	}

	/**
	 * 充当対象払込期日Aを取得します。
	 *
	 * @return 充当対象払込期日A
	 */
	public String getID_Date_JutoTaisho() {
		return ID_Date_JutoTaisho;
	}

	/**
	 * 充当対象払込期日Aを設定します。
	 *
	 * @param ID_Date_JutoTaisho
	 *            充当対象払込期日A
	 */
	public void setID_Date_JutoTaisho(String ID_Date_JutoTaisho) {
		this.ID_Date_JutoTaisho = ID_Date_JutoTaisho;
	}

	/**
	 * 充当対象払込期日(元号)を取得します。
	 *
	 * @return 充当対象払込期日(元号)
	 */
	public String getID_Date_JutoTaishoGengou() {
		return ID_Date_JutoTaishoGengou;
	}

	/**
	 * 充当対象払込期日(元号)を設定します。
	 *
	 * @param ID_Date_JutoTaishoGengou
	 *            充当対象払込期日(元号)
	 */
	public void setID_Date_JutoTaishoGengou(String ID_Date_JutoTaishoGengou) {
		this.ID_Date_JutoTaishoGengou = ID_Date_JutoTaishoGengou;
	}

	/**
	 * 充当対象払込期日(西暦年)を取得します。
	 *
	 * @return 充当対象払込期日(西暦年)
	 */
	public String getID_Date_JutoTaishoYear() {
		return ID_Date_JutoTaishoYear;
	}

	/**
	 * 充当対象払込期日(西暦年)を設定します。
	 *
	 * @param ID_Date_JutoTaishoYear
	 *            充当対象払込期日(西暦年)
	 */
	public void setID_Date_JutoTaishoYear(String ID_Date_JutoTaishoYear) {
		this.ID_Date_JutoTaishoYear = ID_Date_JutoTaishoYear;
	}

	/**
	 * 充当対象払込期日(月)を取得します。
	 *
	 * @return 充当対象払込期日(月)
	 */
	public String getID_Date_JutoTaishoMonth() {
		return ID_Date_JutoTaishoMonth;
	}

	/**
	 * 充当対象払込期日(月)を設定します。
	 *
	 * @param ID_Date_JutoTaishoMonth
	 *            充当対象払込期日(月)
	 */
	public void setID_Date_JutoTaishoMonth(String ID_Date_JutoTaishoMonth) {
		this.ID_Date_JutoTaishoMonth = ID_Date_JutoTaishoMonth;
	}

	/**
	 * 充当対象払込期日入力を取得します。
	 *
	 * @return 充当対象払込期日入力
	 */
	public String getID_Date_JutoTaishoYear_Input() {
		return ID_Date_JutoTaishoYear_Input;
	}

	/**
	 * 充当対象払込期日入力を設定します。
	 *
	 * @param ID_Date_JutoTaishoYear_Input
	 *            充当対象払込期日入力
	 */
	public void setID_Date_JutoTaishoYear_Input(
			String ID_Date_JutoTaishoYear_Input) {
		this.ID_Date_JutoTaishoYear_Input = ID_Date_JutoTaishoYear_Input;
	}

	/**
	 * 充当対象払込期日(日)を取得します。
	 *
	 * @return 充当対象払込期日(日)
	 */
	public String getID_Date_JutoTaishoDay() {
		return ID_Date_JutoTaishoDay;
	}

	/**
	 * 充当対象払込期日(日)を設定します。
	 *
	 * @param ID_Date_JutoTaishoDay
	 *            充当対象払込期日(日)
	 */
	public void setID_Date_JutoTaishoDay(String ID_Date_JutoTaishoDay) {
		this.ID_Date_JutoTaishoDay = ID_Date_JutoTaishoDay;
	}

	/**
	 * 代弁金払込日Aを取得します。
	 *
	 * @return 代弁金払込日A
	 */
	public String getID_Date_DaibenkinHaraikomi() {
		return ID_Date_DaibenkinHaraikomi;
	}

	/**
	 * 代弁金払込日Aを設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomi
	 *            代弁金払込日A
	 */
	public void setID_Date_DaibenkinHaraikomi(String ID_Date_DaibenkinHaraikomi) {
		this.ID_Date_DaibenkinHaraikomi = ID_Date_DaibenkinHaraikomi;
	}

	/**
	 * 代弁金払込日(元号)を取得します。
	 *
	 * @return 代弁金払込日(元号)
	 */
	public String getID_Date_DaibenkinHaraikomiGengou() {
		return ID_Date_DaibenkinHaraikomiGengou;
	}

	/**
	 * 代弁金払込日(元号)を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomiGengou
	 *            代弁金払込日(元号)
	 */
	public void setID_Date_DaibenkinHaraikomiGengou(
			String ID_Date_DaibenkinHaraikomiGengou) {
		this.ID_Date_DaibenkinHaraikomiGengou = ID_Date_DaibenkinHaraikomiGengou;
	}

	/**
	 * 代位金払込日入力を取得します。
	 *
	 * @return 代位金払込日入力
	 */
	public String getID_Date_DaibenkinHaraikomiYear_Input() {
		return ID_Date_DaibenkinHaraikomiYear_Input;
	}

	/**
	 * 代位金払込日入力を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomiYear_Input
	 *            代位金払込日入力
	 */
	public void setID_Date_DaibenkinHaraikomiYear_Input(
			String ID_Date_DaibenkinHaraikomiYear_Input) {
		this.ID_Date_DaibenkinHaraikomiYear_Input = ID_Date_DaibenkinHaraikomiYear_Input;
	}

	/**
	 * 代弁金払込日(西暦年)を取得します。
	 *
	 * @return 代弁金払込日(西暦年)
	 */
	public String getID_Date_DaibenkinHaraikomiYear() {
		return ID_Date_DaibenkinHaraikomiYear;
	}

	/**
	 * 代弁金払込日(西暦年)を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomiYear
	 *            代弁金払込日(西暦年)
	 */
	public void setID_Date_DaibenkinHaraikomiYear(
			String ID_Date_DaibenkinHaraikomiYear) {
		this.ID_Date_DaibenkinHaraikomiYear = ID_Date_DaibenkinHaraikomiYear;
	}

	/**
	 * 代弁金払込日(月)を取得します。
	 *
	 * @return 代弁金払込日(月)
	 */
	public String getID_Date_DaibenkinHaraikomiMonth() {
		return ID_Date_DaibenkinHaraikomiMonth;
	}

	/**
	 * 代弁金払込日(月)を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomiMonth
	 *            代弁金払込日(月)
	 */
	public void setID_Date_DaibenkinHaraikomiMonth(
			String ID_Date_DaibenkinHaraikomiMonth) {
		this.ID_Date_DaibenkinHaraikomiMonth = ID_Date_DaibenkinHaraikomiMonth;
	}

	/**
	 * 代弁金払込日(日)を取得します。
	 *
	 * @return 代弁金払込日(日)
	 */
	public String getID_Date_DaibenkinHaraikomiDay() {
		return ID_Date_DaibenkinHaraikomiDay;
	}

	/**
	 * 代弁金払込日(日)を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomiDay
	 *            代弁金払込日(日)
	 */
	public void setID_Date_DaibenkinHaraikomiDay(
			String ID_Date_DaibenkinHaraikomiDay) {
		this.ID_Date_DaibenkinHaraikomiDay = ID_Date_DaibenkinHaraikomiDay;
	}

	/**
	 * 遅延損害金を取得します。
	 *
	 * @return 遅延損害金
	 */
	public String getID_M_ChienSongai() {
		return ID_M_ChienSongai;
	}

	/**
	 * 遅延損害金を設定します。
	 *
	 * @param ID_M_ChienSongai
	 *            遅延損害金
	 */
	public void setID_M_ChienSongai(String ID_M_ChienSongai) {
		this.ID_M_ChienSongai = ID_M_ChienSongai;
	}

	/**
	 * 利息を取得します。
	 *
	 * @return 利息
	 */
	public String getID_M_Risoku() {
		return ID_M_Risoku;
	}

	/**
	 * 利息を設定します。
	 *
	 * @param ID_M_Risoku
	 *            利息
	 */
	public void setID_M_Risoku(String ID_M_Risoku) {
		this.ID_M_Risoku = ID_M_Risoku;
	}

	/**
	 * 元金を取得します。
	 *
	 * @return 元金
	 */
	public String getID_M_Gankin() {
		return ID_M_Gankin;
	}

	/**
	 * 元金を設定します。
	 *
	 * @param ID_M_Gankin
	 *            元金
	 */
	public void setID_M_Gankin(String ID_M_Gankin) {
		this.ID_M_Gankin = ID_M_Gankin;
	}

	/**
	 * 計を取得します。
	 *
	 * @return 計
	 */
	public String getID_M_Kei() {
		return ID_M_Kei;
	}

	/**
	 * 計を設定します。
	 *
	 * @param ID_M_Kei
	 *            計
	 */
	public void setID_M_Kei(String ID_M_Kei) {
		this.ID_M_Kei = ID_M_Kei;
	}

	/**
	 * 仮受金(一般口)からの充当額を取得します。
	 *
	 * @return 仮受金(一般口)からの充当額
	 */
	public String getID_M_KariukeIppanJuto() {
		return ID_M_KariukeIppanJuto;
	}

	/**
	 * 仮受金(一般口)からの充当額を設定します。
	 *
	 * @param ID_M_KariukeIppanJuto
	 *            仮受金(一般口)からの充当額
	 */
	public void setID_M_KariukeIppanJuto(String ID_M_KariukeIppanJuto) {
		this.ID_M_KariukeIppanJuto = ID_M_KariukeIppanJuto;
	}

	/**
	 * 代弁金充当後残元金を取得します。
	 *
	 * @return 代弁金充当後残元金
	 */
	public String getID_M_ZanGanAfterDaibenJuto() {
		return ID_M_ZanGanAfterDaibenJuto;
	}

	/**
	 * 代弁金充当後残元金を設定します。
	 *
	 * @param ID_M_ZanGanAfterDaibenJuto
	 *            代弁金充当後残元金
	 */
	public void setID_M_ZanGanAfterDaibenJuto(String ID_M_ZanGanAfterDaibenJuto) {
		this.ID_M_ZanGanAfterDaibenJuto = ID_M_ZanGanAfterDaibenJuto;
	}

	/**
	 * 繰上償還手数料を取得します。
	 *
	 * @return 繰上償還手数料
	 */
	public String getID_M_KurishoCommission() {
		return ID_M_KurishoCommission;
	}

	/**
	 * 繰上償還手数料を設定します。
	 *
	 * @param ID_M_KurishoCommission
	 *            繰上償還手数料
	 */
	public void setID_M_KurishoCommission(String ID_M_KurishoCommission) {
		this.ID_M_KurishoCommission = ID_M_KurishoCommission;
	}

	/**
	 * 送金額を取得します。
	 *
	 * @return 送金額
	 */
	public String getID_M_Sokin() {
		return ID_M_Sokin;
	}

	/**
	 * 送金額を設定します。
	 *
	 * @param ID_M_Sokin
	 *            送金額
	 */
	public void setID_M_Sokin(String ID_M_Sokin) {
		this.ID_M_Sokin = ID_M_Sokin;
	}

	/**
	 * 送金日Aを取得します。
	 *
	 * @return 送金日A
	 */
	public String getID_Date_Sokin() {
		return ID_Date_Sokin;
	}

	/**
	 * 送金日Aを設定します。
	 *
	 * @param ID_Date_Sokin
	 *            送金日A
	 */
	public void setID_Date_Sokin(String ID_Date_Sokin) {
		this.ID_Date_Sokin = ID_Date_Sokin;
	}

	/**
	 * 送信日(年号)を取得します。
	 *
	 * @return 送信日(年号)
	 */
	public String getID_Date_SokinGengou() {
		return ID_Date_SokinGengou;
	}

	/**
	 * 送信日(年号)を設定します。
	 *
	 * @param ID_Date_SokinGengou
	 *            送信日(年号)
	 */
	public void setID_Date_SokinGengou(String ID_Date_SokinGengou) {
		this.ID_Date_SokinGengou = ID_Date_SokinGengou;
	}

	/**
	 * 送信日(西暦年)を取得します。
	 *
	 * @return 送信日(西暦年)
	 */
	public String getID_Date_SokinYear() {
		return ID_Date_SokinYear;
	}

	/**
	 * 送信日(西暦年)を設定します。
	 *
	 * @param ID_Date_SokinYear
	 *            送信日(西暦年)
	 */
	public void setID_Date_SokinYear(String ID_Date_SokinYear) {
		this.ID_Date_SokinYear = ID_Date_SokinYear;
	}

	/**
	 * 送信日人力を取得します。
	 *
	 * @return 送信日人力
	 */
	public String getID_Date_SokinYear_Input() {
		return ID_Date_SokinYear_Input;
	}

	/**
	 * 送信日人力を設定します。
	 *
	 * @param ID_Date_SokinYear_Input
	 *            送信日人力
	 */
	public void setID_Date_SokinYear_Input(String ID_Date_SokinYear_Input) {
		this.ID_Date_SokinYear_Input = ID_Date_SokinYear_Input;
	}

	/**
	 * 送信日(月)を取得します。
	 *
	 * @return 送信日(月)
	 */
	public String getID_Date_SokinMonth() {
		return ID_Date_SokinMonth;
	}

	/**
	 * 送信日(月)を設定します。
	 *
	 * @param ID_Date_SokinMonth
	 *            送信日(月)
	 */
	public void setID_Date_SokinMonth(String ID_Date_SokinMonth) {
		this.ID_Date_SokinMonth = ID_Date_SokinMonth;
	}

	/**
	 * 送信日(日)を取得します。
	 *
	 * @return 送信日(日)
	 */
	public String getID_Date_SokinDay() {
		return ID_Date_SokinDay;
	}

	/**
	 * 送信日(日)を設定します。
	 *
	 * @param ID_Date_SokinDay
	 *            送信日(日)
	 */
	public void setID_Date_SokinDay(String ID_Date_SokinDay) {
		this.ID_Date_SokinDay = ID_Date_SokinDay;
	}

	/**
	 * 送金日番号Aを取得します。
	 *
	 * @return 送金日番号A
	 */
	public String getID_ID_Sokinbi() {
		return ID_ID_Sokinbi;
	}

	/**
	 * 送金日番号Aを設定します。
	 *
	 * @param ID_ID_Sokinbi
	 *            送金日番号A
	 */
	public void setID_ID_Sokinbi(String ID_ID_Sokinbi) {
		this.ID_ID_Sokinbi = ID_ID_Sokinbi;
	}

	/**
	 * 受託者勘定処理年月Aを取得します。
	 *
	 * @return 受託者勘定処理年月A
	 */
	public String getID_Date_Jtkshori() {
		return ID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月Aを設定します。
	 *
	 * @param ID_Date_Jtkshori
	 *            受託者勘定処理年月A
	 */
	public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
		this.ID_Date_Jtkshori = ID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月入力を取得します。
	 *
	 * @return 受託者勘定処理年月入力
	 */
	public String getID_Date_JtkshoriYear_Input() {
		return ID_Date_JtkshoriYear_Input;
	}

	/**
	 * 受託者勘定処理年月入力を設定します。
	 *
	 * @param ID_Date_JtkshoriYear_Input
	 *            受託者勘定処理年月入力
	 */
	public void setID_Date_JtkshoriYear_Input(String ID_Date_JtkshoriYear_Input) {
		this.ID_Date_JtkshoriYear_Input = ID_Date_JtkshoriYear_Input;
	}

	/**
	 * 受託者勘定処理年月(元号)を取得します。
	 *
	 * @return 受託者勘定処理年月(元号)
	 */
	public String getID_Date_JtkshoriGengou() {
		return ID_Date_JtkshoriGengou;
	}

	/**
	 * 受託者勘定処理年月(元号)を設定します。
	 *
	 * @param ID_Date_JtkshoriGengou
	 *            受託者勘定処理年月(元号)
	 */
	public void setID_Date_JtkshoriGengou(String ID_Date_JtkshoriGengou) {
		this.ID_Date_JtkshoriGengou = ID_Date_JtkshoriGengou;
	}

	/**
	 * 受託者勘定処理年月(年)を取得します。
	 *
	 * @return 受託者勘定処理年月(年)
	 */
	public String getID_Date_JtkshoriYear() {
		return ID_Date_JtkshoriYear;
	}

	/**
	 * 受託者勘定処理年月(年)を設定します。
	 *
	 * @param ID_Date_JtkshoriYear
	 *            受託者勘定処理年月(年)
	 */
	public void setID_Date_JtkshoriYear(String ID_Date_JtkshoriYear) {
		this.ID_Date_JtkshoriYear = ID_Date_JtkshoriYear;
	}

	/**
	 * 受託者勘定処理年月(月)を取得します。
	 *
	 * @return 受託者勘定処理年月(月)
	 */
	public String getID_Date_JtkshoriMonth() {
		return ID_Date_JtkshoriMonth;
	}

	/**
	 * 受託者勘定処理年月(月)を設定します。
	 *
	 * @param ID_Date_JtkshoriMonth
	 *            受託者勘定処理年月(月)
	 */
	public void setID_Date_JtkshoriMonth(String ID_Date_JtkshoriMonth) {
		this.ID_Date_JtkshoriMonth = ID_Date_JtkshoriMonth;
	}

	/**
	 * M_貸付残高を取得します。
	 *
	 * @return M_貸付残高
	 */
	public String getID_M_KashitsukeZandaka() {
		return ID_M_KashitsukeZandaka;
	}

	/**
	 * M_貸付残高を設定します。
	 *
	 * @param ID_M_KashitsukeZandaka
	 *            M_貸付残高
	 */
	public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
		this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
	}

	/**
	 * 表示画面のヘッダ項目を取得します。
	 *
	 * @return 表示画面のヘッダ項目
	 */
	public String getID_InputHead() {
		return ID_InputHead;
	}

	/**
	 * 表示画面のヘッダ項目を設定します。
	 *
	 * @param ID_InputHead
	 *            表示画面のヘッダ項目
	 */
	public void setID_InputHead(String ID_InputHead) {
		this.ID_InputHead = ID_InputHead;
	}

	/**
	 * 債権管理番号を取得します。
	 *
	 * @return 債権管理番号
	 */
	public String getID_ID_Credit() {
		return ID_ID_Credit;
	}

	/**
	 * 債権管理番号を設定します。
	 *
	 * @param ID_ID_Credit
	 *            債権管理番号
	 */
	public void setID_ID_Credit(String ID_ID_Credit) {
		this.ID_ID_Credit = ID_ID_Credit;
	}

	/**
	 * 請求繰償利息を取得します。
	 *
	 * @return 請求繰償利息
	 */
	public String getID_M_SeiKuriRisoku() {
		return ID_M_SeiKuriRisoku;
	}

	/**
	 * 請求繰償利息を設定します。
	 *
	 * @param ID_M_SeiKuriRisoku
	 *            請求繰償利息
	 */
	public void setID_M_SeiKuriRisoku(String ID_M_SeiKuriRisoku) {
		this.ID_M_SeiKuriRisoku = ID_M_SeiKuriRisoku;
	}

	/**
	 * 請求繰償元金を取得します。
	 *
	 * @return 請求繰償元金
	 */
	public String getID_M_SeiKuriGankin() {
		return ID_M_SeiKuriGankin;
	}

	/**
	 * 請求繰償元金を設定します。
	 *
	 * @param ID_M_SeiKuriGankin
	 *            請求繰償元金
	 */
	public void setID_M_SeiKuriGankin(String ID_M_SeiKuriGankin) {
		this.ID_M_SeiKuriGankin = ID_M_SeiKuriGankin;
	}

	/**
	 * 請求データに登録を行う請求繰償利息を取得します。
	 *
	 * @return 請求データに登録を行う請求繰償利息
	 */
	public String getID_Seikyu_M_SeiKuriRisoku() {
		return ID_Seikyu_M_SeiKuriRisoku;
	}

	/**
	 * 請求データに登録を行う請求繰償利息を設定します。
	 *
	 * @param ID_Seikyu_M_SeiKuriRisoku
	 *            請求データに登録を行う請求繰償利息
	 */
	public void setID_Seikyu_M_SeiKuriRisoku(String ID_Seikyu_M_SeiKuriRisoku) {
		this.ID_Seikyu_M_SeiKuriRisoku = ID_Seikyu_M_SeiKuriRisoku;
	}

	/**
	 * 請求データに登録を行う請求繰償元金を取得します。
	 *
	 * @return 請求データに登録を行う請求繰償元金
	 */
	public String getID_Seikyu_M_SeiKuriGankin() {
		return ID_Seikyu_M_SeiKuriGankin;
	}

	/**
	 * 請求データに登録を行う請求繰償元金を設定します。
	 *
	 * @param ID_Seikyu_M_SeiKuriGankin
	 *            請求データに登録を行う請求繰償元金
	 */
	public void setID_Seikyu_M_SeiKuriGankin(String ID_Seikyu_M_SeiKuriGankin) {
		this.ID_Seikyu_M_SeiKuriGankin = ID_Seikyu_M_SeiKuriGankin;
	}

	/**
	 * M_約定利息を取得します。
	 *
	 * @return M_約定利息
	 */
	public String getID_M_YakujoRisoku() {
		return ID_M_YakujoRisoku;
	}

	/**
	 * M_約定利息を設定します。
	 *
	 * @param ID_M_YakujoRisoku
	 *            M_約定利息
	 */
	public void setID_M_YakujoRisoku(String ID_M_YakujoRisoku) {
		this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
	}

	/**
	 * M_約定元金を取得します。
	 *
	 * @return M_約定元金
	 */
	public String getID_M_YakujoGankin() {
		return ID_M_YakujoGankin;
	}

	/**
	 * M_約定元金を設定します。
	 *
	 * @param ID_M_YakujoGankin
	 *            M_約定元金
	 */
	public void setID_M_YakujoGankin(String ID_M_YakujoGankin) {
		this.ID_M_YakujoGankin = ID_M_YakujoGankin;
	}

	/**
	 * 退避貸付金残高（非表示）を取得します。
	 *
	 * @return 退避貸付金残高（非表示）
	 */
	public String getID_Keep_M_KashitsukeZan() {
		return ID_Keep_M_KashitsukeZan;
	}

	/**
	 * 退避貸付金残高（非表示）を設定します。
	 *
	 * @param ID_Keep_M_KashitsukeZan
	 *            退避貸付金残高（非表示）
	 */
	public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
		this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
	}

	/**
	 * 退避約定元金を取得します。
	 *
	 * @return 退避約定元金
	 */
	public String getID_Keep_M_YakujoGankin() {
		return ID_Keep_M_YakujoGankin;
	}

	/**
	 * 退避約定元金を設定します。
	 *
	 * @param ID_Keep_M_YakujoGankin
	 *            退避約定元金
	 */
	public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
		this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
	}

	/**
	 * 退避約定利息を取得します。
	 *
	 * @return 退避約定利息
	 */
	public String getID_Keep_M_YakujoRisoku() {
		return ID_Keep_M_YakujoRisoku;
	}

	/**
	 * 退避約定利息を設定します。
	 *
	 * @param ID_Keep_M_YakujoRisoku
	 *            退避約定利息
	 */
	public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
		this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
	}

	/**
	 * 退避請求繰償利息を取得します。
	 *
	 * @return 退避請求繰償利息
	 */
	public String getID_Keep_Seikyu_M_SeiKuriRisoku() {
		return ID_Keep_Seikyu_M_SeiKuriRisoku;
	}

	/**
	 * 退避請求繰償利息を設定します。
	 *
	 * @param ID_Keep_Seikyu_M_SeiKuriRisoku
	 *            退避請求繰償利息
	 */
	public void setID_Keep_Seikyu_M_SeiKuriRisoku(
			String ID_Keep_Seikyu_M_SeiKuriRisoku) {
		this.ID_Keep_Seikyu_M_SeiKuriRisoku = ID_Keep_Seikyu_M_SeiKuriRisoku;
	}

	/**
	 * 退避請求繰償元金を取得します。
	 *
	 * @return 退避請求繰償元金
	 */
	public String getID_Keep_Seikyu_M_SeiKuriGankin() {
		return ID_Keep_Seikyu_M_SeiKuriGankin;
	}

	/**
	 * 退避請求繰償元金を設定します。
	 *
	 * @param ID_Keep_Seikyu_M_SeiKuriGankin
	 *            退避請求繰償元金
	 */
	public void setID_Keep_Seikyu_M_SeiKuriGankin(
			String ID_Keep_Seikyu_M_SeiKuriGankin) {
		this.ID_Keep_Seikyu_M_SeiKuriGankin = ID_Keep_Seikyu_M_SeiKuriGankin;
	}

	/**
	 * 取消済みフラグ（非表示）を取得します。
	 *
	 * @return 取消済みフラグ（非表示）
	 */
	public String getID_Flag_Torikeshizumi() {
		return ID_Flag_Torikeshizumi;
	}

	/**
	 * 取消済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Flag_Torikeshizumi
	 *            取消済みフラグ（非表示）
	 */
	public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
		this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
	}

	/**
	 * 退避償還期限（非表示）を取得します。
	 *
	 * @return 退避償還期限（非表示）
	 */
	public String getID_Keep_Date_ShokanKigen() {
		return ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 退避償還期限（非表示）を設定します。
	 *
	 * @param ID_Keep_Date_ShokanKigen
	 *            退避償還期限（非表示）
	 */
	public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
		this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 報告時分秒（非表示）を取得します。
	 *
	 * @return 報告時分秒（非表示）
	 */
	public String getID_Time_Report() {
		return ID_Time_Report;
	}

	/**
	 * 報告時分秒（非表示）を設定します。
	 *
	 * @param ID_Time_Report
	 *            報告時分秒（非表示）
	 */
	public void setID_Time_Report(String ID_Time_Report) {
		this.ID_Time_Report = ID_Time_Report;
	}

	/**
	 * 原本番号を取得します。
	 *
	 * @return 原本番号
	 */
	public String getID_ID_Master() {
		return ID_ID_Master;
	}

	/**
	 * 原本番号を設定します。
	 *
	 * @param ID_ID_Master
	 *            原本番号
	 */
	public void setID_ID_Master(String ID_ID_Master) {
		this.ID_ID_Master = ID_ID_Master;
	}

	/**
	 * 電子署名付データ（非表示）を取得します。
	 *
	 * @return 電子署名付データ（非表示）
	 */
	public String getID_SignData() {
		return ID_SignData;
	}

	/**
	 * 電子署名付データ（非表示）を設定します。
	 *
	 * @param ID_SignData
	 *            電子署名付データ（非表示）
	 */
	public void setID_SignData(String ID_SignData) {
		this.ID_SignData = ID_SignData;
	}

	/**
	 * 取消用払出・債権管理番号を取得します。
	 *
	 * @return 取消用払出・債権管理番号
	 */
	public String getID_Ins_ID_Credit() {
		return ID_Ins_ID_Credit;
	}

	/**
	 * 取消用払出・債権管理番号を設定します。
	 *
	 * @param ID_Ins_ID_Credit
	 *            取消用払出・債権管理番号
	 */
	public void setID_Ins_ID_Credit(String ID_Ins_ID_Credit) {
		this.ID_Ins_ID_Credit = ID_Ins_ID_Credit;
	}

	/**
	 * 扱店別稟議データに登録を行う払込前残元金を取得します。
	 *
	 * @return 扱店別稟議データに登録を行う払込前残元金
	 */
	public String getID_M_KashitsukeZandaka_aRingi() {
		return ID_M_KashitsukeZandaka_aRingi;
	}

	/**
	 * 扱店別稟議データに登録を行う払込前残元金を設定します。
	 *
	 * @param ID_M_KashitsukeZandaka_aRingi
	 *            扱店別稟議データに登録を行う払込前残元金
	 */
	public void setID_M_KashitsukeZandaka_aRingi(
			String ID_M_KashitsukeZandaka_aRingi) {
		this.ID_M_KashitsukeZandaka_aRingi = ID_M_KashitsukeZandaka_aRingi;
	}

	/**
	 * 扱店別稟議データに登録を行う償還期限を取得します。
	 *
	 * @return 扱店別稟議データに登録を行う償還期限
	 */
	public String getID_Date_ShokanKigen_aRingi() {
		return ID_Date_ShokanKigen_aRingi;
	}

	/**
	 * 扱店別稟議データに登録を行う償還期限を設定します。
	 *
	 * @param ID_Date_ShokanKigen_aRingi
	 *            扱店別稟議データに登録を行う償還期限
	 */
	public void setID_Date_ShokanKigen_aRingi(String ID_Date_ShokanKigen_aRingi) {
		this.ID_Date_ShokanKigen_aRingi = ID_Date_ShokanKigen_aRingi;
	}

	/**
	 * 請求データに登録を行う約定利息を取得します。
	 *
	 * @return 請求データに登録を行う約定利息
	 */
	public String getID_M_YakujoRisoku_Seikyu() {
		return ID_M_YakujoRisoku_Seikyu;
	}

	/**
	 * 請求データに登録を行う約定利息を設定します。
	 *
	 * @param ID_M_YakujoRisoku_Seikyu
	 *            請求データに登録を行う約定利息
	 */
	public void setID_M_YakujoRisoku_Seikyu(String ID_M_YakujoRisoku_Seikyu) {
		this.ID_M_YakujoRisoku_Seikyu = ID_M_YakujoRisoku_Seikyu;
	}

	/**
	 * 請求データに登録を行う約定元金を取得します。
	 *
	 * @return 請求データに登録を行う約定元金
	 */
	public String getID_M_YakujoGankin_Yakujo() {
		return ID_M_YakujoGankin_Yakujo;
	}

	/**
	 * 請求データに登録を行う約定元金を設定します。
	 *
	 * @param ID_M_YakujoGankin_Yakujo
	 *            請求データに登録を行う約定元金
	 */
	public void setID_M_YakujoGankin_Yakujo(String ID_M_YakujoGankin_Yakujo) {
		this.ID_M_YakujoGankin_Yakujo = ID_M_YakujoGankin_Yakujo;
	}

	/**
	 * 履歴番号（非表示）を取得します。
	 *
	 * @return 履歴番号（非表示）
	 */
	public String getID_ID_History() {
		return ID_ID_History;
	}

	/**
	 * 履歴番号（非表示）を設定します。
	 *
	 * @param ID_ID_History
	 *            履歴番号（非表示）
	 */
	public void setID_ID_History(String ID_ID_History) {
		this.ID_ID_History = ID_ID_History;
	}

	/**
	 * ステータス（非表示）を取得します。
	 *
	 * @return ステータス（非表示）
	 */
	public String getID_Status() {
		return ID_Status;
	}

	/**
	 * ステータス（非表示）を設定します。
	 *
	 * @param ID_Status
	 *            ステータス（非表示）
	 */
	public void setID_Status(String ID_Status) {
		this.ID_Status = ID_Status;
	}

	/**
	 * 処理種別を取得します。
	 *
	 * @return 処理種別
	 */
	public String getID_Type_Process() {
		return ID_Type_Process;
	}

	/**
	 * 処理種別を設定します。
	 *
	 * @param ID_Type_Process
	 *            処理種別
	 */
	public void setID_Type_Process(String ID_Type_Process) {
		this.ID_Type_Process = ID_Type_Process;
	}

	/**
	 * データコードを取得します。
	 *
	 * @return データコード
	 */
	public String getID_DataCode() {
		return ID_DataCode;
	}

	/**
	 * データコードを設定します。
	 *
	 * @param ID_DataCode
	 *            データコード
	 */
	public void setID_DataCode(String ID_DataCode) {
		this.ID_DataCode = ID_DataCode;
	}

	/**
	 * 扱店別稟議データの最新データ更新日付を取得します。
	 *
	 * @return 扱店別稟議データの最新データ更新日付
	 */
	public String getID_Data_LastUpDate() {
		return ID_Data_LastUpDate;
	}

	/**
	 * 扱店別稟議データの最新データ更新日付を設定します。
	 *
	 * @param ID_Data_LastUpDate
	 *            扱店別稟議データの最新データ更新日付
	 */
	public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
		this.ID_Data_LastUpDate = ID_Data_LastUpDate;
	}

	/**
	 * ユーザID（非表示）を取得します。
	 *
	 * @return ユーザID（非表示）
	 */
	public String getID_User_ID() {
		return ID_User_ID;
	}

	/**
	 * ユーザID（非表示）を設定します。
	 *
	 * @param ID_User_ID
	 *            ユーザID（非表示）
	 */
	public void setID_User_ID(String ID_User_ID) {
		this.ID_User_ID = ID_User_ID;
	}

	/**
	 * 伝送番号（非表示）を取得します。
	 *
	 * @return 伝送番号（非表示）
	 */
	public String getID_ID_Denso() {
		return ID_ID_Denso;
	}

	/**
	 * 伝送番号（非表示）を設定します。
	 *
	 * @param ID_ID_Denso
	 *            伝送番号（非表示）
	 */
	public void setID_ID_Denso(String ID_ID_Denso) {
		this.ID_ID_Denso = ID_ID_Denso;
	}

	/**
	 * エラー番号（非表示）を取得します。
	 *
	 * @return エラー番号（非表示）
	 */
	public String getID_Code_Error() {
		return ID_Code_Error;
	}

	/**
	 * エラー番号（非表示）を設定します。
	 *
	 * @param ID_Code_Error
	 *            エラー番号（非表示）
	 */
	public void setID_Code_Error(String ID_Code_Error) {
		this.ID_Code_Error = ID_Code_Error;
	}

	/**
	 * エラーメッセージ（非表示）を取得します。
	 *
	 * @return エラーメッセージ（非表示）
	 */
	public String getID_ErrorMessage() {
		return ID_ErrorMessage;
	}

	/**
	 * エラーメッセージ（非表示）を設定します。
	 *
	 * @param ID_ErrorMessage
	 *            エラーメッセージ（非表示）
	 */
	public void setID_ErrorMessage(String ID_ErrorMessage) {
		this.ID_ErrorMessage = ID_ErrorMessage;
	}

	/**
	 * 顧客コード（非表示）を取得します。
	 *
	 * @return 顧客コード（非表示）
	 */
	public String getID_Code_Customer() {
		return ID_Code_Customer;
	}

	/**
	 * 顧客コード（非表示）を設定します。
	 *
	 * @param ID_Code_Customer
	 *            顧客コード（非表示）
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		this.ID_Code_Customer = ID_Code_Customer;
	}

	/**
	 * 方式(非表示）を取得します。
	 *
	 * @return 方式(非表示）
	 */
	public String getID_Kubun_Hoshiki() {
		return ID_Kubun_Hoshiki;
	}

	/**
	 * 方式(非表示）を設定します。
	 *
	 * @param ID_Kubun_Hoshiki
	 *            方式(非表示）
	 */
	public void setID_Kubun_Hoshiki(String ID_Kubun_Hoshiki) {
		this.ID_Kubun_Hoshiki = ID_Kubun_Hoshiki;
	}

	/**
	 * 資金(非表示）を取得します。
	 *
	 * @return 資金(非表示）
	 */
	public String getID_Kubun_Shikin() {
		return ID_Kubun_Shikin;
	}

	/**
	 * 資金(非表示）を設定します。
	 *
	 * @param ID_Kubun_Shikin
	 *            資金(非表示）
	 */
	public void setID_Kubun_Shikin(String ID_Kubun_Shikin) {
		this.ID_Kubun_Shikin = ID_Kubun_Shikin;
	}

	/**
	 * 償還期限年月(非表示)を取得します。
	 *
	 * @return 償還期限年月(非表示)
	 */
	public String getID_Date_ShokanKigen() {
		return ID_Date_ShokanKigen;
	}

	/**
	 * 償還期限年月(非表示)を設定します。
	 *
	 * @param ID_Date_ShokanKigen
	 *            償還期限年月(非表示)
	 */
	public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
		this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
	}

	/**
	 * 退避履歴番号を取得します。
	 *
	 * @return 退避履歴番号
	 */
	public String getID_Keep_ID_History() {
		return ID_Keep_ID_History;
	}

	/**
	 * 退避履歴番号を設定します。
	 *
	 * @param ID_Keep_ID_History
	 *            退避履歴番号
	 */
	public void setID_Keep_ID_History(String ID_Keep_ID_History) {
		this.ID_Keep_ID_History = ID_Keep_ID_History;
	}

	/**
	 * 退避実行済みフラグを取得します。
	 *
	 * @return 退避実行済みフラグ
	 */
	public String getID_Keep_Flag_Kj() {
		return ID_Keep_Flag_Kj;
	}

	/**
	 * 退避実行済みフラグを設定します。
	 *
	 * @param ID_Keep_Flag_Kj
	 *            退避実行済みフラグ
	 */
	public void setID_Keep_Flag_Kj(String ID_Keep_Flag_Kj) {
		this.ID_Keep_Flag_Kj = ID_Keep_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグを取得します。
	 *
	 * @return 扱店別稟議データより取得した実行済みフラグ
	 */
	public String getID_aRingi_Flag_Kj() {
		return ID_aRingi_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した実行済みフラグを設定します。
	 *
	 * @param ID_aRingi_Flag_Kj
	 *            扱店別稟議データより取得した実行済みフラグ
	 */
	public void setID_aRingi_Flag_Kj(String ID_aRingi_Flag_Kj) {
		this.ID_aRingi_Flag_Kj = ID_aRingi_Flag_Kj;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月を取得します。
	 *
	 * @return 扱店別稟議データより取得した償還期限年月
	 */
	public String getID_aRingi_Date_ShokanKigen() {
		return ID_aRingi_Date_ShokanKigen;
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月を設定します。
	 *
	 * @param ID_aRingi_Date_ShokanKigen
	 *            扱店別稟議データより取得した償還期限年月
	 */
	public void setID_aRingi_Date_ShokanKigen(String ID_aRingi_Date_ShokanKigen) {
		this.ID_aRingi_Date_ShokanKigen = ID_aRingi_Date_ShokanKigen;
	}

	/**
	 * 報告書種別（値）(非表示)を取得します。
	 *
	 * @return 報告書種別（値）(非表示)
	 */
	public String getDataCode() {
		return dataCode;
	}

	/**
	 * 報告書種別（値）(非表示)を設定します。
	 *
	 * @param DataCode
	 *            報告書種別（値）(非表示)
	 */
	public void setDataCode(String DataCode) {
		this.dataCode = DataCode;
	}

	/**
	 * 処理モードを取得します。
	 *
	 * @return 処理モード
	 */
	public String getProcessMode() {
		return processMode;
	}

	/**
	 * 処理モードを設定します。
	 *
	 * @param Process_Mode
	 *            処理モード
	 */
	public void setProcessMode(String Process_Mode) {
		this.processMode = Process_Mode;
	}

	/**
	 * 赤データ入力域を取得します。
	 *
	 * @return 赤データ入力域
	 */
	public String getRed_Area() {
		return red_Area;
	}

	/**
	 * 赤データ入力域を設定します。
	 *
	 * @param Red_Area
	 *            赤データ入力域
	 */
	public void setRed_Area(String Red_Area) {
		this.red_Area = Red_Area;
	}

	/**
	 * 黒データ入力域を取得します。
	 *
	 * @return 黒データ入力域
	 */
	public String getBrack_Area() {
		return brack_Area;
	}

	/**
	 * 黒データ入力域を設定します。
	 *
	 * @param Brack_Area
	 *            黒データ入力域
	 */
	public void setBrack_Area(String Brack_Area) {
		this.brack_Area = Brack_Area;
	}

	/**
	 * モードタイプを取得します。
	 *
	 * @return モードタイプ
	 */
	public String getModeType() {
		return modeType;
	}

	/**
	 * モードタイプを設定します。
	 *
	 * @param modeType
	 *            モードタイプ
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	/**
	 * 退避貸付金残高（非表示）を取得します。
	 *
	 * @return 退避貸付金残高（非表示）
	 */
	public java.math.BigDecimal getKeep_M_KashitsukeZan() {
		return keep_M_KashitsukeZan;
	}

	/**
	 * 退避貸付金残高（非表示）を設定します。
	 *
	 * @param keep_M_KashitsukeZan
	 *            退避貸付金残高（非表示）
	 */
	public void setKeep_M_KashitsukeZan(
			java.math.BigDecimal keep_M_KashitsukeZan) {
		this.keep_M_KashitsukeZan = keep_M_KashitsukeZan;
	}

	/**
	 * 更正（赤）データの請求データ「約定利息」を取得します。
	 *
	 * @return 更正（赤）データの請求データ「約定利息」
	 */
	public String getID_M_YakujoRisoku_Seikyu_Red() {
		return ID_M_YakujoRisoku_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「約定利息」を設定します。
	 *
	 * @param ID_M_YakujoRisoku_Seikyu_Red
	 *            更正（赤）データの請求データ「約定利息」
	 */
	public void setID_M_YakujoRisoku_Seikyu_Red(
			String ID_M_YakujoRisoku_Seikyu_Red) {
		this.ID_M_YakujoRisoku_Seikyu_Red = ID_M_YakujoRisoku_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「約定元金」を取得します。
	 *
	 * @return 更正（赤）データの請求データ「約定元金」
	 */
	public String getID_M_YakujoGankin_Seikyu_Red() {
		return ID_M_YakujoGankin_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「約定元金」を設定します。
	 *
	 * @param ID_M_YakujoGankin_Seikyu_Red
	 *            更正（赤）データの請求データ「約定元金」
	 */
	public void setID_M_YakujoGankin_Seikyu_Red(
			String ID_M_YakujoGankin_Seikyu_Red) {
		this.ID_M_YakujoGankin_Seikyu_Red = ID_M_YakujoGankin_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「請求繰償利息」を取得します。
	 *
	 * @return 更正（赤）データの請求データ「請求繰償利息」
	 */
	public String getID_M_SeiKuriRisoku_Seikyu_Red() {
		return ID_M_SeiKuriRisoku_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「請求繰償利息」を設定します。
	 *
	 * @param ID_M_SeiKuriGankin_Seikyu_Red
	 *            更正（赤）データの請求データ「請求繰償利息」
	 */
	public void setID_M_SeiKuriRisoku_Seikyu_Red(
			String ID_M_SeiKuriRisoku_Seikyu_Red) {
		this.ID_M_SeiKuriRisoku_Seikyu_Red = ID_M_SeiKuriRisoku_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「請求繰償元金」を取得します。
	 *
	 * @return 更正（赤）データの請求データ「請求繰償元金」
	 */
	public String getID_M_SeiKuriGankin_Seikyu_Red() {
		return ID_M_SeiKuriGankin_Seikyu_Red;
	}

	/**
	 * 更正（赤）データの請求データ「請求繰償元金」を設定します。
	 *
	 * @param ID_M_SeiKuriGankin_Seikyu_Red
	 *            更正（赤）データの請求データ「請求繰償元金」
	 */
	public void setID_M_SeiKuriGankin_Seikyu_Red(
			String ID_M_SeiKuriGankin_Seikyu_Red) {
		this.ID_M_SeiKuriGankin_Seikyu_Red = ID_M_SeiKuriGankin_Seikyu_Red;
	}
}