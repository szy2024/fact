//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/28 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd003_01のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md003_01Form extends PNBaseForm {

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
    /** 貸付実行日 */
    private String txtID_Date_KashitsukeJikko_Red;
    /** 貸付実行金額(円) */
    private String txtID_M_Kashitsuke_Red;
    /** 資金使途 */
    private String txtID_Code_ShikinShito_Red;
    /** 事業別 */
    private String txtID_Code_Jigyobetsu_Red;
    /** 利率（％） */
    private String txtID_Riritsu_Red;
    /** 特利区分 */
    private String txtID_Code_TokuriKubun_Red;
    /** 特利（％） */
    private String txtID_Tokuri_Red;
    /** 償還方法 */
    private String txtID_Code_Shokan_Red;
    /** 据置期限 */
    private String txtID_Date_SueokiKigen_Red;
    /** 償還期限 */
    private String txtID_Date_ShokanKigen_Red;
    /** 元利金払込日 */
    private String txtID_Date_GanrikinHaraikomi_Red;
    /** 元利又は元金均等額(円) */
    private String txtID_M_GankinKinto_Red;
    /** 払込前残元金(円) */
    private String txtID_M_KashitsukeZandaka_Red;
    /** 払込期日 */
    private String txtID_Date_Haraikomi_Red;
    /** 払込金額(円) */
    private String txtID_M_Haraikomi_Red;
    /** 控除利息(円) */
    private String txtID_M_KojoRisoku_Red;
    /** 差引払込額(円) */
    private String txtID_M_SashihikiHaraikomi_Red;
    /** 払込後残元金(円) */
    private String txtID_M_ZangankinAfterHaraikomi_Red;
    /** 約定利息(円) */
    private String txtID_M_YakujoRisoku_Red;
    /** 約定元金(円) */
    private String txtID_M_YakujoGankin_Red;
    /** 遅延損害金(円) */
    private String txtID_M_ChienSongai_Red;
    /** 違約金(円) */
    private String txtID_M_Iyaku_Red;
    /** 違約金(利子軽減分)(円) */
    private String txtID_M_IyakuRishikeigen_Red;
    /** 仮受金からの充当額(円) */
    private String txtID_M_KariukeIppanJuto_Red;
    /** 入金日 */
    private String txtID_Date_Nyukin_Red;
    /** 受託者勘定処理年月 */
    private String txtID_Date_Jtkshori_Red;
    /** 送金日 */
    private String txtID_Date_Sokin_Red;
    /** 送金日番号 */
    private String txtID_ID_Sokinbi_Red;
    /** 代弁履行後の作成 */
    private String ckhAfter_Daibensai_Red;
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
    /** 貸付実行日（修正） */
    private String txtID_Date_kashitsukeJikko;
    /** 貸付実行金額（修正） */
    private String txtID_M_Kashitsuke;
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
    /** 償還方法（修正） */
    private String txtID_Code_Shokan;
    /** 据置期限（修正） */
    private String txtID_Date_SueokiKigen;
    /** 償還期限（修正） */
    private String txtID_Date_ShokanKigen;
    /** 元利金払込日（修正） */
    private String txtID_Date_GanrikinHaraikomi;
    /** 元利又は元金均等額(円)（修正） */
    private String txtID_M_GankinKinto;
    /** 払込前残元金(円)（修正） */
    private String txtID_M_KashitsukeZandaka;
    /** 払込期日（修正） */
    private String txtID_Date_Haraikomi;
    /** 払込金額(円)（修正） */
    private String txtID_M_Haraikomi;
    /** 控除利息(円)（修正） */
    private String txtID_M_KojoRisoku;
    /** 差引払込額(円)（修正） */
    private String txtID_M_SashihikiHaraikomi;
    /** 払込後残元金(円)（修正） */
    private String txtID_M_ZangankinAfterHaraikomi;
    /** 約定利息(円)（修正） */
    private String txtID_M_YakujoRisoku;
    /** 約定元金(円)（修正） */
    private String txtID_M_YakujoGankin;
    /** 遅延損害金(円)（修正） */
    private String txtID_M_ChienSongai;
    /** 違約金(円)（修正） */
    private String txtID_M_Iyaku;
    /** 違約金(利子軽減分)(円)（修正） */
    private String txtID_M_IyakuRishikeigen;
    /** 仮受金からの充当額(円)（修正） */
    private String txtID_M_KariukeIppanJuto;
    /** 入金日(元号)（修正） */
    private String ID_Date_Nyukin_Gengo;
    /** 入金日(年)（修正） */
    private String ID_Date_Nyukin_Nen;
    /** 入金日(月)（修正） */
    private String drpID_Date_NyukinTsuki;
    /** 入金日(日)（修正） */
    private String drpID_Date_NyukinBi;
    /** 受託者勘定処理年月（修正） */
    private String txtID_Date_Jtkshori;
    /** 送金日(元号)（修正） */
    private String ID_Date_Sokin_Gengo;
    /** 送金日(年)（修正） */
    private String ID_Date_Sokin_Nen;
    /** 送金日(月)（修正） */
    private String drpID_Date_SokinTsuki;
    /** 送金日(日)（修正） */
    private String drpID_Date_SokinBi;
    /** 送金日番号（修正） */
    private String txtID_ID_Sokinbi;
    /** 代弁履行後の作成（修正） */
    private String ckhAfter_Daibensai;
    /** 受託者勘定処理年月(元号)（修正） */
    private String ID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月(年)（修正） */
    private String ID_Date_Jtkshori_Nen;
    /** 受託者勘定処理年月(月)（修正） */
    private String drpID_Date_JtkshoriTsuki;
    /** 報告書番号 */
    private String ID_ID_Report_Red;
    /** 報告年月日 */
    private String ID_Date_Report_Red;
    /** 報告時分秒 */
    private String ID_Time_Report_Red;
    /** ユーザID */
    private String ID_User_ID_Red;
    /** 伝送番号 */
    private String ID_ID_Denso_Red;
    /** データコード */
    private String ID_DataCode_Red;
    /** 残高件数 */
    private String ID_Count_Zandaka_Red;
    /** 履歴番号 */
    private String ID_ID_History_Red;
    /** ステータス */
    private String ID_Status_Red;
    /** 処理種別 */
    private String ID_Type_Process_Red;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi_Red;
    /** エラー番号 */
    private String ID_Code_Error_Red;
    /** エラーメッセージ */
    private String ID_ErrorMessage_Red;
    /** 退避貸付金残高 */
    private String ID_Keep_M_KashitsukeZan_Red;
    /** 退避約定元金 */
    private String ID_Keep_M_YakujoGankin_Red;
    /** 退避約定利息 */
    private String ID_Keep_M_YakujoRisoku_Red;
    /** 退避償還期限 */
    private String ID_Keep_Date_ShokanKigen_Red;
    /** 債権管理番号 */
    private String ID_ID_Credit_Red;
    /** 顧客コード */
    private String ID_Code_Customer_Red;
    /** 充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko_Red;
    /** 請求データの退避任意繰償還利息 */
    private String ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    /** 請求データの退避請求繰償還利息 */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    /** 請求データの退避請求繰償還元金 */
    private String ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    /** 約定データの退避請求繰償還利息 */
    private String ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
    /** 元利金計 */
    private String ID_M_GanrikinKei_Red;
    /** 最新データ更新日付 */
    private String ID_Data_LastUpDate_Red;
    /** 退避履歴番号 */
    private String ID_Keep_ID_History_Red;
    /** 扱店別稟議データの償還期限年月 */
    private String ID_Date_ShokanKigen_aRingi_Red;
    /** 扱店別稟議データの貸付残高 */
    private String ID_M_KashitsukeZandaka_aRingi_Red;
    /** 請求データの約定元金 */
    private String ID_M_YakujoGankin_Seikyu_Red;
    /** 請求データの約定利息 */
    private String ID_M_YakujoRisoku_Seikyu_Red;
    /** 報告書番号(修正) */
    private String ID_ID_Report;
    /** 報告年月日(修正) */
    private String ID_Date_Report;
    /** 報告時分秒(修正) */
    private String ID_Time_Report;
    /** ユーザID(修正) */
    private String ID_User_ID;
    /** 伝送番号(修正) */
    private String ID_ID_Denso;
    /** データコード(修正) */
    private String ID_DataCode;
    /** 残高件数(修正) */
    private String ID_Count_Zandaka;
    /** 履歴番号(修正) */
    private String ID_ID_History;
    /** ステータス(修正) */
    private String ID_Status;
    /** 処理種別(修正) */
    private String ID_Type_Process;
    /** 取消済フラグ(修正) */
    private String ID_Flag_Torikeshizumi;
    /** エラー番号(修正) */
    private String ID_Code_Error;
    /** エラーメッセージ(修正) */
    private String ID_ErrorMessage;
    /** 退避貸付金残高(修正) */
    private String ID_Keep_M_KashitsukeZan;
    /** 退避約定元金(修正) */
    private String ID_Keep_M_YakujoGankin;
    /** 退避約定利息(修正) */
    private String ID_Keep_M_YakujoRisoku;
    /** 退避償還期限(修正) */
    private String ID_Keep_Date_ShokanKigen;
    /** 債権管理番号(修正) */
    private String ID_ID_Credit;
    /** 顧客コード(修正) */
    private String ID_Code_Customer;
    /** 充当順序変更区分(修正) */
    private String ID_Kubun_JutoJunjoHenko;
    /** 請求データの退避任意繰償還利息(修正) */
    private String ID_Keep_Seikyu_M_NinKuriRisoku;
    /** 請求データの退避請求繰償還利息(修正) */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku;
    /** 請求データの退避請求繰償還元金(修正) */
    private String ID_Keep_Seikyu_M_SeiKuriGankin;
    /** 約定データの退避請求繰償還利息(修正) */
    private String ID_Keep_Yakujo_M_SeiKuriRisoku;
    /** 元利金計(修正) */
    private String ID_M_GanrikinKei;
    /** 最新データ更新日付(修正) */
    private String ID_Data_LastUpDate;
    /** 退避履歴番号(修正) */
    private String ID_Keep_ID_History;
    /** 扱店別稟議データの償還期限年月(修正) */
    private String ID_Date_ShokanKigen_aRingi;
    /** 扱店別稟議データの貸付残高(修正) */
    private String ID_M_KashitsukeZandaka_aRingi;
    /** 請求データの約定元金(修正) */
    private String ID_M_YakujoGankin_Seikyu;
    /** 請求データの約定利息(修正) */
    private String ID_M_YakujoRisoku_Seikyu;
    /** 件数 */
    private String Kensu;
    /** 約定元金 */
    private String M_YakujoGankin;
    /** 報告時分秒(非表示) */
    private String ID_Time_Report_H;
    /** 報告書番号(非表示) */
    private String ID_ID_Report_H;
    /** 処理モード */
    private String ProcessMode;
    /** 赤データ入力領域 */
    private String redArea;
    /** 黒データ入力領域 */
    private String blackArea;
    /** 最新の請求データの約定元金 */
    private String New_M_YakujoGankin;
    /** 最新の請求データの約定利息 */
    private String New_M_YakujoRisoku;
    /** 最新の請求データの任意繰償還利息 */
    private String New_M_Seikyu_NinKuriRisoku;
    /** 最新の請求データの請求繰償還利息 */
    private String New_M_Seikyu_SeiKuriRisoku;
    /** 最新の請求データの請求繰償還元金 */
    private String New_M_Seikyu_SeiKuriGankin;
    /** 入力の約定利息 */
    private String ID_Input_M_YakujoRisoku;
    /** 入力の約定元金 */
    private String ID_Input_M_YakujoGankin;
    /** 入力の控除利息 */
    private String ID_Input_M_KojoRisoku;
    /** 約定利息　ＤＢ取得値 */
    private String ID_M_YakujoRisoku;
    /** 約定元金　ＤＢ取得値 */
    private String ID_M_YakujoGankin;

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
     * @param lblID_Date_Report 報告年月日
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
     * @param lblErr エラー
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
     * @param lblMessage メッセージ
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
     * @param lblID_Head_Red 赤データ入力領域タイトル
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
     * @param lblID_Head_Red2 赤データ入力領域タイトル（"赤"）
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
     * @param txtID_Name_Customer_Red 顧客名
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
     * @param txtID_Name_Organization_Red 扱店名
     */
    public void setTxtID_Name_Organization_Red(String txtID_Name_Organization_Red) {
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
     * @param txtID_Code_KoukoShiten_Red 公庫支店
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
     * @param txtID_Code_Organization_Red 扱店
     */
    public void setTxtID_Code_Organization_Red(String txtID_Code_Organization_Red) {
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
     * @param txtID_Code_Tenpo_Red 店舗
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
     * @param txtID_Year_Red 年度
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
     * @param txtID_Code_HoshikiShikin_Red 方式資金
     */
    public void setTxtID_Code_HoshikiShikin_Red(String txtID_Code_HoshikiShikin_Red) {
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
     * @param txtID_ID_Ringi_Red 番号
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
     * @param txtID_ID_RingiBranch_Red 枝番
     */
    public void setTxtID_ID_RingiBranch_Red(String txtID_ID_RingiBranch_Red) {
        this.txtID_ID_RingiBranch_Red = txtID_ID_RingiBranch_Red;
    }

    /**
     * 貸付実行日を取得します。
     *
     * @return 貸付実行日
     */
    public String getTxtID_Date_KashitsukeJikko_Red() {
        return txtID_Date_KashitsukeJikko_Red;
    }

    /**
     * 貸付実行日を設定します。
     *
     * @param txtID_Date_KashitsukeJikko_Red 貸付実行日
     */
    public void setTxtID_Date_KashitsukeJikko_Red(String txtID_Date_KashitsukeJikko_Red) {
        this.txtID_Date_KashitsukeJikko_Red = txtID_Date_KashitsukeJikko_Red;
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
     * @param txtID_M_Kashitsuke_Red 貸付実行金額(円)
     */
    public void setTxtID_M_Kashitsuke_Red(String txtID_M_Kashitsuke_Red) {
        this.txtID_M_Kashitsuke_Red = txtID_M_Kashitsuke_Red;
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
     * @param txtID_Code_ShikinShito_Red 資金使途
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
     * @param txtID_Code_Jigyobetsu_Red 事業別
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
     * @param txtID_Riritsu_Red 利率（％）
     */
    public void setTxtID_Riritsu_Red(String txtID_Riritsu_Red) {
        this.txtID_Riritsu_Red = txtID_Riritsu_Red;
    }

    /**
     * 特利区分を取得します。
     *
     * @return 特利区分
     */
    public String getTxtID_Code_TokuriKubun_Red() {
        return txtID_Code_TokuriKubun_Red;
    }

    /**
     * 特利区分を設定します。
     *
     * @param txtID_Code_TokuriKubun_Red 特利区分
     */
    public void setTxtID_Code_TokuriKubun_Red(String txtID_Code_TokuriKubun_Red) {
        this.txtID_Code_TokuriKubun_Red = txtID_Code_TokuriKubun_Red;
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
     * @param txtID_Tokuri_Red 特利（％）
     */
    public void setTxtID_Tokuri_Red(String txtID_Tokuri_Red) {
        this.txtID_Tokuri_Red = txtID_Tokuri_Red;
    }

    /**
     * 償還方法を取得します。
     *
     * @return 償還方法
     */
    public String getTxtID_Code_Shokan_Red() {
        return txtID_Code_Shokan_Red;
    }

    /**
     * 償還方法を設定します。
     *
     * @param txtID_Code_Shokan_Red 償還方法
     */
    public void setTxtID_Code_Shokan_Red(String txtID_Code_Shokan_Red) {
        this.txtID_Code_Shokan_Red = txtID_Code_Shokan_Red;
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
     * @param txtID_Date_SueokiKigen_Red 据置期限
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
     * @param txtID_Date_ShokanKigen_Red 償還期限
     */
    public void setTxtID_Date_ShokanKigen_Red(String txtID_Date_ShokanKigen_Red) {
        this.txtID_Date_ShokanKigen_Red = txtID_Date_ShokanKigen_Red;
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
     * @param txtID_Date_GanrikinHaraikomi_Red 元利金払込日
     */
    public void setTxtID_Date_GanrikinHaraikomi_Red(String txtID_Date_GanrikinHaraikomi_Red) {
        this.txtID_Date_GanrikinHaraikomi_Red = txtID_Date_GanrikinHaraikomi_Red;
    }

    /**
     * 元利又は元金均等額(円)を取得します。
     *
     * @return 元利又は元金均等額(円)
     */
    public String getTxtID_M_GankinKinto_Red() {
        return txtID_M_GankinKinto_Red;
    }

    /**
     * 元利又は元金均等額(円)を設定します。
     *
     * @param txtID_M_GankinKinto_Red 元利又は元金均等額(円)
     */
    public void setTxtID_M_GankinKinto_Red(String txtID_M_GankinKinto_Red) {
        this.txtID_M_GankinKinto_Red = txtID_M_GankinKinto_Red;
    }

    /**
     * 払込前残元金(円)を取得します。
     *
     * @return 払込前残元金(円)
     */
    public String getTxtID_M_KashitsukeZandaka_Red() {
        return txtID_M_KashitsukeZandaka_Red;
    }

    /**
     * 払込前残元金(円)を設定します。
     *
     * @param txtID_M_KashitsukeZandaka_Red 払込前残元金(円)
     */
    public void setTxtID_M_KashitsukeZandaka_Red(String txtID_M_KashitsukeZandaka_Red) {
        this.txtID_M_KashitsukeZandaka_Red = txtID_M_KashitsukeZandaka_Red;
    }

    /**
     * 払込期日を取得します。
     *
     * @return 払込期日
     */
    public String getTxtID_Date_Haraikomi_Red() {
        return txtID_Date_Haraikomi_Red;
    }

    /**
     * 払込期日を設定します。
     *
     * @param txtID_Date_Haraikomi_Red 払込期日
     */
    public void setTxtID_Date_Haraikomi_Red(String txtID_Date_Haraikomi_Red) {
        this.txtID_Date_Haraikomi_Red = txtID_Date_Haraikomi_Red;
    }

    /**
     * 払込金額(円)を取得します。
     *
     * @return 払込金額(円)
     */
    public String getTxtID_M_Haraikomi_Red() {
        return txtID_M_Haraikomi_Red;
    }

    /**
     * 払込金額(円)を設定します。
     *
     * @param txtID_M_Haraikomi_Red 払込金額(円)
     */
    public void setTxtID_M_Haraikomi_Red(String txtID_M_Haraikomi_Red) {
        this.txtID_M_Haraikomi_Red = txtID_M_Haraikomi_Red;
    }

    /**
     * 控除利息(円)を取得します。
     *
     * @return 控除利息(円)
     */
    public String getTxtID_M_KojoRisoku_Red() {
        return txtID_M_KojoRisoku_Red;
    }

    /**
     * 控除利息(円)を設定します。
     *
     * @param txtID_M_KojoRisoku_Red 控除利息(円)
     */
    public void setTxtID_M_KojoRisoku_Red(String txtID_M_KojoRisoku_Red) {
        this.txtID_M_KojoRisoku_Red = txtID_M_KojoRisoku_Red;
    }

    /**
     * 差引払込額(円)を取得します。
     *
     * @return 差引払込額(円)
     */
    public String getTxtID_M_SashihikiHaraikomi_Red() {
        return txtID_M_SashihikiHaraikomi_Red;
    }

    /**
     * 差引払込額(円)を設定します。
     *
     * @param txtID_M_SashihikiHaraikomi_Red 差引払込額(円)
     */
    public void setTxtID_M_SashihikiHaraikomi_Red(String txtID_M_SashihikiHaraikomi_Red) {
        this.txtID_M_SashihikiHaraikomi_Red = txtID_M_SashihikiHaraikomi_Red;
    }

    /**
     * 払込後残元金(円)を取得します。
     *
     * @return 払込後残元金(円)
     */
    public String getTxtID_M_ZangankinAfterHaraikomi_Red() {
        return txtID_M_ZangankinAfterHaraikomi_Red;
    }

    /**
     * 払込後残元金(円)を設定します。
     *
     * @param txtID_M_ZangankinAfterHaraikomi_Red 払込後残元金(円)
     */
    public void setTxtID_M_ZangankinAfterHaraikomi_Red(String txtID_M_ZangankinAfterHaraikomi_Red) {
        this.txtID_M_ZangankinAfterHaraikomi_Red = txtID_M_ZangankinAfterHaraikomi_Red;
    }

    /**
     * 約定利息(円)を取得します。
     *
     * @return 約定利息(円)
     */
    public String getTxtID_M_YakujoRisoku_Red() {
        return txtID_M_YakujoRisoku_Red;
    }

    /**
     * 約定利息(円)を設定します。
     *
     * @param txtID_M_YakujoRisoku_Red 約定利息(円)
     */
    public void setTxtID_M_YakujoRisoku_Red(String txtID_M_YakujoRisoku_Red) {
        this.txtID_M_YakujoRisoku_Red = txtID_M_YakujoRisoku_Red;
    }

    /**
     * 約定元金(円)を取得します。
     *
     * @return 約定元金(円)
     */
    public String getTxtID_M_YakujoGankin_Red() {
        return txtID_M_YakujoGankin_Red;
    }

    /**
     * 約定元金(円)を設定します。
     *
     * @param txtID_M_YakujoGankin_Red 約定元金(円)
     */
    public void setTxtID_M_YakujoGankin_Red(String txtID_M_YakujoGankin_Red) {
        this.txtID_M_YakujoGankin_Red = txtID_M_YakujoGankin_Red;
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
     * @param txtID_M_ChienSongai_Red 遅延損害金(円)
     */
    public void setTxtID_M_ChienSongai_Red(String txtID_M_ChienSongai_Red) {
        this.txtID_M_ChienSongai_Red = txtID_M_ChienSongai_Red;
    }

    /**
     * 違約金(円)を取得します。
     *
     * @return 違約金(円)
     */
    public String getTxtID_M_Iyaku_Red() {
        return txtID_M_Iyaku_Red;
    }

    /**
     * 違約金(円)を設定します。
     *
     * @param txtID_M_Iyaku_Red 違約金(円)
     */
    public void setTxtID_M_Iyaku_Red(String txtID_M_Iyaku_Red) {
        this.txtID_M_Iyaku_Red = txtID_M_Iyaku_Red;
    }

    /**
     * 違約金(利子軽減分)(円)を取得します。
     *
     * @return 違約金(利子軽減分)(円)
     */
    public String getTxtID_M_IyakuRishikeigen_Red() {
        return txtID_M_IyakuRishikeigen_Red;
    }

    /**
     * 違約金(利子軽減分)(円)を設定します。
     *
     * @param txtID_M_IyakuRishikeigen_Red 違約金(利子軽減分)(円)
     */
    public void setTxtID_M_IyakuRishikeigen_Red(String txtID_M_IyakuRishikeigen_Red) {
        this.txtID_M_IyakuRishikeigen_Red = txtID_M_IyakuRishikeigen_Red;
    }

    /**
     * 仮受金からの充当額(円)を取得します。
     *
     * @return 仮受金からの充当額(円)
     */
    public String getTxtID_M_KariukeIppanJuto_Red() {
        return txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金からの充当額(円)を設定します。
     *
     * @param txtID_M_KariukeIppanJuto_Red 仮受金からの充当額(円)
     */
    public void setTxtID_M_KariukeIppanJuto_Red(String txtID_M_KariukeIppanJuto_Red) {
        this.txtID_M_KariukeIppanJuto_Red = txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 入金日を取得します。
     *
     * @return 入金日
     */
    public String getTxtID_Date_Nyukin_Red() {
        return txtID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     *
     * @param txtID_Date_Nyukin_Red 入金日
     */
    public void setTxtID_Date_Nyukin_Red(String txtID_Date_Nyukin_Red) {
        this.txtID_Date_Nyukin_Red = txtID_Date_Nyukin_Red;
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
     * @param txtID_Date_Jtkshori_Red 受託者勘定処理年月
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
     * @param txtID_Date_Sokin_Red 送金日
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
     * @param txtID_ID_Sokinbi_Red 送金日番号
     */
    public void setTxtID_ID_Sokinbi_Red(String txtID_ID_Sokinbi_Red) {
        this.txtID_ID_Sokinbi_Red = txtID_ID_Sokinbi_Red;
    }

    /**
     * 代弁履行後の作成を取得します。
     *
     * @return 代弁履行後の作成
     */
    public String getCkhAfter_Daibensai_Red() {
        return ckhAfter_Daibensai_Red;
    }

    /**
     * 代弁履行後の作成を設定します。
     *
     * @param ckhAfter_Daibensai_Red 代弁履行後の作成
     */
    public void setCkhAfter_Daibensai_Red(String ckhAfter_Daibensai_Red) {
        this.ckhAfter_Daibensai_Red = ckhAfter_Daibensai_Red;
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
     * @param ID_Date_Jtkshori_Gengo_Red 受託者勘定処理年月(元号)
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
     * @param ID_Date_Jtkshori_Nen_Red 受託者勘定処理年月(年)
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
     * @param drpID_Date_JtkshoriTsuki_Red 受託者勘定処理年月(月)
     */
    public void setDrpID_Date_JtkshoriTsuki_Red(String drpID_Date_JtkshoriTsuki_Red) {
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
     * @param lblID_Head 黒データ入力領域タイトル
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
     * @param txtID_Name_Customer 顧客名（修正）
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
     * @param txtID_Name_Organization 扱店名（修正）
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
     * @param txtID_Code_KoukoShiten 公庫支店（修正）
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
     * @param txtID_Code_Organization 扱店（修正）
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
     * @param txtID_Code_Tenpo 店舗（修正）
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
     * @param txtID_Year 年度（修正）
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
     * @param txtID_Code_HoshikiShikin 方式資金（修正）
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
     * @param txtID_ID_Ringi 番号（修正）
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
     * @param txtID_ID_RingiBranch 枝番（修正）
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 貸付実行日（修正）を取得します。
     *
     * @return 貸付実行日（修正）
     */
    public String getTxtID_Date_kashitsukeJikko() {
        return txtID_Date_kashitsukeJikko;
    }

    /**
     * 貸付実行日（修正）を設定します。
     *
     * @param txtID_Date_kashitsukeJikko 貸付実行日（修正）
     */
    public void setTxtID_Date_kashitsukeJikko(String txtID_Date_kashitsukeJikko) {
        this.txtID_Date_kashitsukeJikko = txtID_Date_kashitsukeJikko;
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
     * @param txtID_M_Kashitsuke 貸付実行金額（修正）
     */
    public void setTxtID_M_Kashitsuke(String txtID_M_Kashitsuke) {
        this.txtID_M_Kashitsuke = txtID_M_Kashitsuke;
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
     * @param txtID_Code_ShikinShito 資金使途（修正）
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
     * @param txtID_Code_Jigyobetsu 事業別（修正）
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
     * @param txtID_Riritsu 利率（％）（修正）
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
     * @param txtID_Kubun_Tokuri 特利区分（修正）
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
     * @param txtID_Tokuri 特利（％）（修正）
     */
    public void setTxtID_Tokuri(String txtID_Tokuri) {
        this.txtID_Tokuri = txtID_Tokuri;
    }

    /**
     * 償還方法（修正）を取得します。
     *
     * @return 償還方法（修正）
     */
    public String getTxtID_Code_Shokan() {
        return txtID_Code_Shokan;
    }

    /**
     * 償還方法（修正）を設定します。
     *
     * @param txtID_Code_Shokan 償還方法（修正）
     */
    public void setTxtID_Code_Shokan(String txtID_Code_Shokan) {
        this.txtID_Code_Shokan = txtID_Code_Shokan;
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
     * @param txtID_Date_SueokiKigen 据置期限（修正）
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
     * @param txtID_Date_ShokanKigen 償還期限（修正）
     */
    public void setTxtID_Date_ShokanKigen(String txtID_Date_ShokanKigen) {
        this.txtID_Date_ShokanKigen = txtID_Date_ShokanKigen;
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
     * @param txtID_Date_GanrikinHaraikomi 元利金払込日（修正）
     */
    public void setTxtID_Date_GanrikinHaraikomi(String txtID_Date_GanrikinHaraikomi) {
        this.txtID_Date_GanrikinHaraikomi = txtID_Date_GanrikinHaraikomi;
    }

    /**
     * 元利又は元金均等額(円)（修正）を取得します。
     *
     * @return 元利又は元金均等額(円)（修正）
     */
    public String getTxtID_M_GankinKinto() {
        return txtID_M_GankinKinto;
    }

    /**
     * 元利又は元金均等額(円)（修正）を設定します。
     *
     * @param txtID_M_GankinKinto 元利又は元金均等額(円)（修正）
     */
    public void setTxtID_M_GankinKinto(String txtID_M_GankinKinto) {
        this.txtID_M_GankinKinto = txtID_M_GankinKinto;
    }

    /**
     * 払込前残元金(円)（修正）を取得します。
     *
     * @return 払込前残元金(円)（修正）
     */
    public String getTxtID_M_KashitsukeZandaka() {
        return txtID_M_KashitsukeZandaka;
    }

    /**
     * 払込前残元金(円)（修正）を設定します。
     *
     * @param txtID_M_KashitsukeZandaka 払込前残元金(円)（修正）
     */
    public void setTxtID_M_KashitsukeZandaka(String txtID_M_KashitsukeZandaka) {
        this.txtID_M_KashitsukeZandaka = txtID_M_KashitsukeZandaka;
    }

    /**
     * 払込期日（修正）を取得します。
     *
     * @return 払込期日（修正）
     */
    public String getTxtID_Date_Haraikomi() {
        return txtID_Date_Haraikomi;
    }

    /**
     * 払込期日（修正）を設定します。
     *
     * @param txtID_Date_Haraikomi 払込期日（修正）
     */
    public void setTxtID_Date_Haraikomi(String txtID_Date_Haraikomi) {
        this.txtID_Date_Haraikomi = txtID_Date_Haraikomi;
    }

    /**
     * 払込金額(円)（修正）を取得します。
     *
     * @return 払込金額(円)（修正）
     */
    public String getTxtID_M_Haraikomi() {
        return txtID_M_Haraikomi;
    }

    /**
     * 払込金額(円)（修正）を設定します。
     *
     * @param txtID_M_Haraikomi 払込金額(円)（修正）
     */
    public void setTxtID_M_Haraikomi(String txtID_M_Haraikomi) {
        this.txtID_M_Haraikomi = txtID_M_Haraikomi;
    }

    /**
     * 控除利息(円)（修正）を取得します。
     *
     * @return 控除利息(円)（修正）
     */
    public String getTxtID_M_KojoRisoku() {
        return txtID_M_KojoRisoku;
    }

    /**
     * 控除利息(円)（修正）を設定します。
     *
     * @param txtID_M_KojoRisoku 控除利息(円)（修正）
     */
    public void setTxtID_M_KojoRisoku(String txtID_M_KojoRisoku) {
        this.txtID_M_KojoRisoku = txtID_M_KojoRisoku;
    }

    /**
     * 差引払込額(円)（修正）を取得します。
     *
     * @return 差引払込額(円)（修正）
     */
    public String getTxtID_M_SashihikiHaraikomi() {
        return txtID_M_SashihikiHaraikomi;
    }

    /**
     * 差引払込額(円)（修正）を設定します。
     *
     * @param txtID_M_SashihikiHaraikomi 差引払込額(円)（修正）
     */
    public void setTxtID_M_SashihikiHaraikomi(String txtID_M_SashihikiHaraikomi) {
        this.txtID_M_SashihikiHaraikomi = txtID_M_SashihikiHaraikomi;
    }

    /**
     * 払込後残元金(円)（修正）を取得します。
     *
     * @return 払込後残元金(円)（修正）
     */
    public String getTxtID_M_ZangankinAfterHaraikomi() {
        return txtID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 払込後残元金(円)（修正）を設定します。
     *
     * @param txtID_M_ZangankinAfterHaraikomi 払込後残元金(円)（修正）
     */
    public void setTxtID_M_ZangankinAfterHaraikomi(String txtID_M_ZangankinAfterHaraikomi) {
        this.txtID_M_ZangankinAfterHaraikomi = txtID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 約定利息(円)（修正）を取得します。
     *
     * @return 約定利息(円)（修正）
     */
    public String getTxtID_M_YakujoRisoku() {
        return txtID_M_YakujoRisoku;
    }

    /**
     * 約定利息(円)（修正）を設定します。
     *
     * @param txtID_M_YakujoRisoku 約定利息(円)（修正）
     */
    public void setTxtID_M_YakujoRisoku(String txtID_M_YakujoRisoku) {
        this.txtID_M_YakujoRisoku = txtID_M_YakujoRisoku;
    }

    /**
     * 約定元金(円)（修正）を取得します。
     *
     * @return 約定元金(円)（修正）
     */
    public String getTxtID_M_YakujoGankin() {
        return txtID_M_YakujoGankin;
    }

    /**
     * 約定元金(円)（修正）を設定します。
     *
     * @param txtID_M_YakujoGankin 約定元金(円)（修正）
     */
    public void setTxtID_M_YakujoGankin(String txtID_M_YakujoGankin) {
        this.txtID_M_YakujoGankin = txtID_M_YakujoGankin;
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
     * @param txtID_M_ChienSongai 遅延損害金(円)（修正）
     */
    public void setTxtID_M_ChienSongai(String txtID_M_ChienSongai) {
        this.txtID_M_ChienSongai = txtID_M_ChienSongai;
    }

    /**
     * 違約金(円)（修正）を取得します。
     *
     * @return 違約金(円)（修正）
     */
    public String getTxtID_M_Iyaku() {
        return txtID_M_Iyaku;
    }

    /**
     * 違約金(円)（修正）を設定します。
     *
     * @param txtID_M_Iyaku 違約金(円)（修正）
     */
    public void setTxtID_M_Iyaku(String txtID_M_Iyaku) {
        this.txtID_M_Iyaku = txtID_M_Iyaku;
    }

    /**
     * 違約金(利子軽減分)(円)（修正）を取得します。
     *
     * @return 違約金(利子軽減分)(円)（修正）
     */
    public String getTxtID_M_IyakuRishikeigen() {
        return txtID_M_IyakuRishikeigen;
    }

    /**
     * 違約金(利子軽減分)(円)（修正）を設定します。
     *
     * @param txtID_M_IyakuRishikeigen 違約金(利子軽減分)(円)（修正）
     */
    public void setTxtID_M_IyakuRishikeigen(String txtID_M_IyakuRishikeigen) {
        this.txtID_M_IyakuRishikeigen = txtID_M_IyakuRishikeigen;
    }

    /**
     * 仮受金からの充当額(円)（修正）を取得します。
     *
     * @return 仮受金からの充当額(円)（修正）
     */
    public String getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額(円)（修正）を設定します。
     *
     * @param txtID_M_KariukeIppanJuto 仮受金からの充当額(円)（修正）
     */
    public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 入金日(元号)（修正）を取得します。
     *
     * @return 入金日(元号)（修正）
     */
    public String getID_Date_Nyukin_Gengo() {
        return ID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日(元号)（修正）を設定します。
     *
     * @param ID_Date_Nyukin_Gengo 入金日(元号)（修正）
     */
    public void setID_Date_Nyukin_Gengo(String ID_Date_Nyukin_Gengo) {
        this.ID_Date_Nyukin_Gengo = ID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日(年)（修正）を取得します。
     *
     * @return 入金日(年)（修正）
     */
    public String getID_Date_Nyukin_Nen() {
        return ID_Date_Nyukin_Nen;
    }

    /**
     * 入金日(年)（修正）を設定します。
     *
     * @param ID_Date_Nyukin_Nen 入金日(年)（修正）
     */
    public void setID_Date_Nyukin_Nen(String ID_Date_Nyukin_Nen) {
        this.ID_Date_Nyukin_Nen = ID_Date_Nyukin_Nen;
    }

    /**
     * 入金日(月)（修正）を取得します。
     *
     * @return 入金日(月)（修正）
     */
    public String getDrpID_Date_NyukinTsuki() {
        return drpID_Date_NyukinTsuki;
    }

    /**
     * 入金日(月)（修正）を設定します。
     *
     * @param drpID_Date_NyukinTsuki 入金日(月)（修正）
     */
    public void setDrpID_Date_NyukinTsuki(String drpID_Date_NyukinTsuki) {
        this.drpID_Date_NyukinTsuki = drpID_Date_NyukinTsuki;
    }

    /**
     * 入金日(日)（修正）を取得します。
     *
     * @return 入金日(日)（修正）
     */
    public String getDrpID_Date_NyukinBi() {
        return drpID_Date_NyukinBi;
    }

    /**
     * 入金日(日)（修正）を設定します。
     *
     * @param drpID_Date_NyukinBi 入金日(日)（修正）
     */
    public void setDrpID_Date_NyukinBi(String drpID_Date_NyukinBi) {
        this.drpID_Date_NyukinBi = drpID_Date_NyukinBi;
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
     * @param txtID_Date_Jtkshori 受託者勘定処理年月（修正）
     */
    public void setTxtID_Date_Jtkshori(String txtID_Date_Jtkshori) {
        this.txtID_Date_Jtkshori = txtID_Date_Jtkshori;
    }

    /**
     * 送金日(元号)（修正）を取得します。
     *
     * @return 送金日(元号)（修正）
     */
    public String getID_Date_Sokin_Gengo() {
        return ID_Date_Sokin_Gengo;
    }

    /**
     * 送金日(元号)（修正）を設定します。
     *
     * @param ID_Date_Sokin_Gengo 送金日(元号)（修正）
     */
    public void setID_Date_Sokin_Gengo(String ID_Date_Sokin_Gengo) {
        this.ID_Date_Sokin_Gengo = ID_Date_Sokin_Gengo;
    }

    /**
     * 送金日(年)（修正）を取得します。
     *
     * @return 送金日(年)（修正）
     */
    public String getID_Date_Sokin_Nen() {
        return ID_Date_Sokin_Nen;
    }

    /**
     * 送金日(年)（修正）を設定します。
     *
     * @param ID_Date_Sokin_Nen 送金日(年)（修正）
     */
    public void setID_Date_Sokin_Nen(String ID_Date_Sokin_Nen) {
        this.ID_Date_Sokin_Nen = ID_Date_Sokin_Nen;
    }

    /**
     * 送金日(月)（修正）を取得します。
     *
     * @return 送金日(月)（修正）
     */
    public String getDrpID_Date_SokinTsuki() {
        return drpID_Date_SokinTsuki;
    }

    /**
     * 送金日(月)（修正）を設定します。
     *
     * @param drpID_Date_SokinTsuki 送金日(月)（修正）
     */
    public void setDrpID_Date_SokinTsuki(String drpID_Date_SokinTsuki) {
        this.drpID_Date_SokinTsuki = drpID_Date_SokinTsuki;
    }

    /**
     * 送金日(日)（修正）を取得します。
     *
     * @return 送金日(日)（修正）
     */
    public String getDrpID_Date_SokinBi() {
        return drpID_Date_SokinBi;
    }

    /**
     * 送金日(日)（修正）を設定します。
     *
     * @param drpID_Date_SokinBi 送金日(日)（修正）
     */
    public void setDrpID_Date_SokinBi(String drpID_Date_SokinBi) {
        this.drpID_Date_SokinBi = drpID_Date_SokinBi;
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
     * @param txtID_ID_Sokinbi 送金日番号（修正）
     */
    public void setTxtID_ID_Sokinbi(String txtID_ID_Sokinbi) {
        this.txtID_ID_Sokinbi = txtID_ID_Sokinbi;
    }

    /**
     * 代弁履行後の作成（修正）を取得します。
     *
     * @return 代弁履行後の作成（修正）
     */
    public String getCkhAfter_Daibensai() {
        return ckhAfter_Daibensai;
    }

    /**
     * 代弁履行後の作成（修正）を設定します。
     *
     * @param ckhAfter_Daibensai 代弁履行後の作成（修正）
     */
    public void setCkhAfter_Daibensai(String ckhAfter_Daibensai) {
        this.ckhAfter_Daibensai = ckhAfter_Daibensai;
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
     * @param ID_Date_Jtkshori_Gengo 受託者勘定処理年月(元号)（修正）
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
     * @param ID_Date_Jtkshori_Nen 受託者勘定処理年月(年)（修正）
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
     * @param drpID_Date_JtkshoriTsuki 受託者勘定処理年月(月)（修正）
     */
    public void setDrpID_Date_JtkshoriTsuki(String drpID_Date_JtkshoriTsuki) {
        this.drpID_Date_JtkshoriTsuki = drpID_Date_JtkshoriTsuki;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_ID_Report_Red() {
        return ID_ID_Report_Red;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param ID_ID_Report_Red 報告書番号
     */
    public void setID_ID_Report_Red(String ID_ID_Report_Red) {
        this.ID_ID_Report_Red = ID_ID_Report_Red;
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getID_Date_Report_Red() {
        return ID_Date_Report_Red;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param ID_Date_Report_Red 報告年月日
     */
    public void setID_Date_Report_Red(String ID_Date_Report_Red) {
        this.ID_Date_Report_Red = ID_Date_Report_Red;
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getID_Time_Report_Red() {
        return ID_Time_Report_Red;
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param ID_Time_Report_Red 報告時分秒
     */
    public void setID_Time_Report_Red(String ID_Time_Report_Red) {
        this.ID_Time_Report_Red = ID_Time_Report_Red;
    }

    /**
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public String getID_User_ID_Red() {
        return ID_User_ID_Red;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param ID_User_ID_Red ユーザID
     */
    public void setID_User_ID_Red(String ID_User_ID_Red) {
        this.ID_User_ID_Red = ID_User_ID_Red;
    }

    /**
     * 伝送番号を取得します。
     *
     * @return 伝送番号
     */
    public String getID_ID_Denso_Red() {
        return ID_ID_Denso_Red;
    }

    /**
     * 伝送番号を設定します。
     *
     * @param ID_ID_Denso_Red 伝送番号
     */
    public void setID_ID_Denso_Red(String ID_ID_Denso_Red) {
        this.ID_ID_Denso_Red = ID_ID_Denso_Red;
    }

    /**
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getID_DataCode_Red() {
        return ID_DataCode_Red;
    }

    /**
     * データコードを設定します。
     *
     * @param ID_DataCode_Red データコード
     */
    public void setID_DataCode_Red(String ID_DataCode_Red) {
        this.ID_DataCode_Red = ID_DataCode_Red;
    }

    /**
     * 残高件数を取得します。
     *
     * @return 残高件数
     */
    public String getID_Count_Zandaka_Red() {
        return ID_Count_Zandaka_Red;
    }

    /**
     * 残高件数を設定します。
     *
     * @param ID_Count_Zandaka_Red 残高件数
     */
    public void setID_Count_Zandaka_Red(String ID_Count_Zandaka_Red) {
        this.ID_Count_Zandaka_Red = ID_Count_Zandaka_Red;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getID_ID_History_Red() {
        return ID_ID_History_Red;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param ID_ID_History_Red 履歴番号
     */
    public void setID_ID_History_Red(String ID_ID_History_Red) {
        this.ID_ID_History_Red = ID_ID_History_Red;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getID_Status_Red() {
        return ID_Status_Red;
    }

    /**
     * ステータスを設定します。
     *
     * @param ID_Status_Red ステータス
     */
    public void setID_Status_Red(String ID_Status_Red) {
        this.ID_Status_Red = ID_Status_Red;
    }

    /**
     * 処理種別を取得します。
     *
     * @return 処理種別
     */
    public String getID_Type_Process_Red() {
        return ID_Type_Process_Red;
    }

    /**
     * 処理種別を設定します。
     *
     * @param ID_Type_Process_Red 処理種別
     */
    public void setID_Type_Process_Red(String ID_Type_Process_Red) {
        this.ID_Type_Process_Red = ID_Type_Process_Red;
    }

    /**
     * 取消済フラグを取得します。
     *
     * @return 取消済フラグ
     */
    public String getID_Flag_Torikeshizumi_Red() {
        return ID_Flag_Torikeshizumi_Red;
    }

    /**
     * 取消済フラグを設定します。
     *
     * @param ID_Flag_Torikeshizumi_Red 取消済フラグ
     */
    public void setID_Flag_Torikeshizumi_Red(String ID_Flag_Torikeshizumi_Red) {
        this.ID_Flag_Torikeshizumi_Red = ID_Flag_Torikeshizumi_Red;
    }

    /**
     * エラー番号を取得します。
     *
     * @return エラー番号
     */
    public String getID_Code_Error_Red() {
        return ID_Code_Error_Red;
    }

    /**
     * エラー番号を設定します。
     *
     * @param ID_Code_Error_Red エラー番号
     */
    public void setID_Code_Error_Red(String ID_Code_Error_Red) {
        this.ID_Code_Error_Red = ID_Code_Error_Red;
    }

    /**
     * エラーメッセージを取得します。
     *
     * @return エラーメッセージ
     */
    public String getID_ErrorMessage_Red() {
        return ID_ErrorMessage_Red;
    }

    /**
     * エラーメッセージを設定します。
     *
     * @param ID_ErrorMessage_Red エラーメッセージ
     */
    public void setID_ErrorMessage_Red(String ID_ErrorMessage_Red) {
        this.ID_ErrorMessage_Red = ID_ErrorMessage_Red;
    }

    /**
     * 退避貸付金残高を取得します。
     *
     * @return 退避貸付金残高
     */
    public String getID_Keep_M_KashitsukeZan_Red() {
        return ID_Keep_M_KashitsukeZan_Red;
    }

    /**
     * 退避貸付金残高を設定します。
     *
     * @param ID_Keep_M_KashitsukeZan_Red 退避貸付金残高
     */
    public void setID_Keep_M_KashitsukeZan_Red(String ID_Keep_M_KashitsukeZan_Red) {
        this.ID_Keep_M_KashitsukeZan_Red = ID_Keep_M_KashitsukeZan_Red;
    }

    /**
     * 退避約定元金を取得します。
     *
     * @return 退避約定元金
     */
    public String getID_Keep_M_YakujoGankin_Red() {
        return ID_Keep_M_YakujoGankin_Red;
    }

    /**
     * 退避約定元金を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin_Red(String ID_Keep_M_YakujoGankin_Red) {
        this.ID_Keep_M_YakujoGankin_Red = ID_Keep_M_YakujoGankin_Red;
    }

    /**
     * 退避約定利息を取得します。
     *
     * @return 退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku_Red() {
        return ID_Keep_M_YakujoRisoku_Red;
    }

    /**
     * 退避約定利息を設定します。
     *
     * @param ID_Keep_M_YakujoRisoku_Red 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku_Red(String ID_Keep_M_YakujoRisoku_Red) {
        this.ID_Keep_M_YakujoRisoku_Red = ID_Keep_M_YakujoRisoku_Red;
    }

    /**
     * 退避償還期限を取得します。
     *
     * @return 退避償還期限
     */
    public String getID_Keep_Date_ShokanKigen_Red() {
        return ID_Keep_Date_ShokanKigen_Red;
    }

    /**
     * 退避償還期限を設定します。
     *
     * @param ID_Keep_Date_ShokanKigen_Red 退避償還期限
     */
    public void setID_Keep_Date_ShokanKigen_Red(String ID_Keep_Date_ShokanKigen_Red) {
        this.ID_Keep_Date_ShokanKigen_Red = ID_Keep_Date_ShokanKigen_Red;
    }

    /**
     * 債権管理番号を取得します。
     *
     * @return 債権管理番号
     */
    public String getID_ID_Credit_Red() {
        return ID_ID_Credit_Red;
    }

    /**
     * 債権管理番号を設定します。
     *
     * @param ID_ID_Credit_Red 債権管理番号
     */
    public void setID_ID_Credit_Red(String ID_ID_Credit_Red) {
        this.ID_ID_Credit_Red = ID_ID_Credit_Red;
    }

    /**
     * 顧客コードを取得します。
     *
     * @return 顧客コード
     */
    public String getID_Code_Customer_Red() {
        return ID_Code_Customer_Red;
    }

    /**
     * 顧客コードを設定します。
     *
     * @param ID_Code_Customer_Red 顧客コード
     */
    public void setID_Code_Customer_Red(String ID_Code_Customer_Red) {
        this.ID_Code_Customer_Red = ID_Code_Customer_Red;
    }

    /**
     * 充当順序変更区分を取得します。
     *
     * @return 充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko_Red() {
        return ID_Kubun_JutoJunjoHenko_Red;
    }

    /**
     * 充当順序変更区分を設定します。
     *
     * @param ID_Kubun_JutoJunjoHenko_Red 充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko_Red(String ID_Kubun_JutoJunjoHenko_Red) {
        this.ID_Kubun_JutoJunjoHenko_Red = ID_Kubun_JutoJunjoHenko_Red;
    }

    /**
     * 請求データの退避任意繰償還利息を取得します。
     *
     * @return 請求データの退避任意繰償還利息
     */
    public String getID_Keep_Seikyu_M_NinKuriRisoku_Red() {
        return ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの退避任意繰償還利息を設定します。
     *
     * @param ID_Keep_Seikyu_M_NinKuriRisoku_Red 請求データの退避任意繰償還利息
     */
    public void setID_Keep_Seikyu_M_NinKuriRisoku_Red(String ID_Keep_Seikyu_M_NinKuriRisoku_Red) {
        this.ID_Keep_Seikyu_M_NinKuriRisoku_Red = ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰償還利息を取得します。
     *
     * @return 請求データの退避請求繰償還利息
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku_Red() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰償還利息を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriRisoku_Red 請求データの退避請求繰償還利息
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku_Red(String ID_Keep_Seikyu_M_SeiKuriRisoku_Red) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku_Red = ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰償還元金を取得します。
     *
     * @return 請求データの退避請求繰償還元金
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin_Red() {
        return ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 請求データの退避請求繰償還元金を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriGankin_Red 請求データの退避請求繰償還元金
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin_Red(String ID_Keep_Seikyu_M_SeiKuriGankin_Red) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin_Red = ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 約定データの退避請求繰償還利息を取得します。
     *
     * @return 約定データの退避請求繰償還利息
     */
    public String getID_Keep_Yakujo_M_SeiKuriRisoku_Red() {
        return ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
    }

    /**
     * 約定データの退避請求繰償還利息を設定します。
     *
     * @param ID_Keep_Yakujo_M_SeiKuriRisoku_Red 約定データの退避請求繰償還利息
     */
    public void setID_Keep_Yakujo_M_SeiKuriRisoku_Red(String ID_Keep_Yakujo_M_SeiKuriRisoku_Red) {
        this.ID_Keep_Yakujo_M_SeiKuriRisoku_Red = ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
    }

    /**
     * 元利金計を取得します。
     *
     * @return 元利金計
     */
    public String getID_M_GanrikinKei_Red() {
        return ID_M_GanrikinKei_Red;
    }

    /**
     * 元利金計を設定します。
     *
     * @param ID_M_GanrikinKei_Red 元利金計
     */
    public void setID_M_GanrikinKei_Red(String ID_M_GanrikinKei_Red) {
        this.ID_M_GanrikinKei_Red = ID_M_GanrikinKei_Red;
    }

    /**
     * 最新データ更新日付を取得します。
     *
     * @return 最新データ更新日付
     */
    public String getID_Data_LastUpDate_Red() {
        return ID_Data_LastUpDate_Red;
    }

    /**
     * 最新データ更新日付を設定します。
     *
     * @param ID_Data_LastUpDate_Red 最新データ更新日付
     */
    public void setID_Data_LastUpDate_Red(String ID_Data_LastUpDate_Red) {
        this.ID_Data_LastUpDate_Red = ID_Data_LastUpDate_Red;
    }

    /**
     * 退避履歴番号を取得します。
     *
     * @return 退避履歴番号
     */
    public String getID_Keep_ID_History_Red() {
        return ID_Keep_ID_History_Red;
    }

    /**
     * 退避履歴番号を設定します。
     *
     * @param ID_Keep_ID_History_Red 退避履歴番号
     */
    public void setID_Keep_ID_History_Red(String ID_Keep_ID_History_Red) {
        this.ID_Keep_ID_History_Red = ID_Keep_ID_History_Red;
    }

    /**
     * 扱店別稟議データの償還期限年月を取得します。
     *
     * @return 扱店別稟議データの償還期限年月
     */
    public String getID_Date_ShokanKigen_aRingi_Red() {
        return ID_Date_ShokanKigen_aRingi_Red;
    }

    /**
     * 扱店別稟議データの償還期限年月を設定します。
     *
     * @param ID_Date_ShokanKigen_aRingi_Red 扱店別稟議データの償還期限年月
     */
    public void setID_Date_ShokanKigen_aRingi_Red(String ID_Date_ShokanKigen_aRingi_Red) {
        this.ID_Date_ShokanKigen_aRingi_Red = ID_Date_ShokanKigen_aRingi_Red;
    }

    /**
     * 扱店別稟議データの貸付残高を取得します。
     *
     * @return 扱店別稟議データの貸付残高
     */
    public String getID_M_KashitsukeZandaka_aRingi_Red() {
        return ID_M_KashitsukeZandaka_aRingi_Red;
    }

    /**
     * 扱店別稟議データの貸付残高を設定します。
     *
     * @param ID_M_KashitsukeZandaka_aRingi_Red 扱店別稟議データの貸付残高
     */
    public void setID_M_KashitsukeZandaka_aRingi_Red(String ID_M_KashitsukeZandaka_aRingi_Red) {
        this.ID_M_KashitsukeZandaka_aRingi_Red = ID_M_KashitsukeZandaka_aRingi_Red;
    }

    /**
     * 請求データの約定元金を取得します。
     *
     * @return 請求データの約定元金
     */
    public String getID_M_YakujoGankin_Seikyu_Red() {
        return ID_M_YakujoGankin_Seikyu_Red;
    }

    /**
     * 請求データの約定元金を設定します。
     *
     * @param ID_M_YakujoGankin_Seikyu_Red 請求データの約定元金
     */
    public void setID_M_YakujoGankin_Seikyu_Red(String ID_M_YakujoGankin_Seikyu_Red) {
        this.ID_M_YakujoGankin_Seikyu_Red = ID_M_YakujoGankin_Seikyu_Red;
    }

    /**
     * 請求データの約定利息を取得します。
     *
     * @return 請求データの約定利息
     */
    public String getID_M_YakujoRisoku_Seikyu_Red() {
        return ID_M_YakujoRisoku_Seikyu_Red;
    }

    /**
     * 請求データの約定利息を設定します。
     *
     * @param ID_M_YakujoRisoku_Seikyu_Red 請求データの約定利息
     */
    public void setID_M_YakujoRisoku_Seikyu_Red(String ID_M_YakujoRisoku_Seikyu_Red) {
        this.ID_M_YakujoRisoku_Seikyu_Red = ID_M_YakujoRisoku_Seikyu_Red;
    }

    /**
     * 報告書番号(修正)を取得します。
     *
     * @return 報告書番号(修正)
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号(修正)を設定します。
     *
     * @param ID_ID_Report 報告書番号(修正)
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 報告年月日(修正)を取得します。
     *
     * @return 報告年月日(修正)
     */
    public String getID_Date_Report() {
        return ID_Date_Report;
    }

    /**
     * 報告年月日(修正)を設定します。
     *
     * @param ID_Date_Report 報告年月日(修正)
     */
    public void setID_Date_Report(String ID_Date_Report) {
        this.ID_Date_Report = ID_Date_Report;
    }

    /**
     * 報告時分秒(修正)を取得します。
     *
     * @return 報告時分秒(修正)
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒(修正)を設定します。
     *
     * @param ID_Time_Report 報告時分秒(修正)
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * ユーザID(修正)を取得します。
     *
     * @return ユーザID(修正)
     */
    public String getID_User_ID() {
        return ID_User_ID;
    }

    /**
     * ユーザID(修正)を設定します。
     *
     * @param ID_User_ID ユーザID(修正)
     */
    public void setID_User_ID(String ID_User_ID) {
        this.ID_User_ID = ID_User_ID;
    }

    /**
     * 伝送番号(修正)を取得します。
     *
     * @return 伝送番号(修正)
     */
    public String getID_ID_Denso() {
        return ID_ID_Denso;
    }

    /**
     * 伝送番号(修正)を設定します。
     *
     * @param ID_ID_Denso 伝送番号(修正)
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        this.ID_ID_Denso = ID_ID_Denso;
    }

    /**
     * データコード(修正)を取得します。
     *
     * @return データコード(修正)
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコード(修正)を設定します。
     *
     * @param ID_DataCode データコード(修正)
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 残高件数(修正)を取得します。
     *
     * @return 残高件数(修正)
     */
    public String getID_Count_Zandaka() {
        return ID_Count_Zandaka;
    }

    /**
     * 残高件数(修正)を設定します。
     *
     * @param ID_Count_Zandaka 残高件数(修正)
     */
    public void setID_Count_Zandaka(String ID_Count_Zandaka) {
        this.ID_Count_Zandaka = ID_Count_Zandaka;
    }

    /**
     * 履歴番号(修正)を取得します。
     *
     * @return 履歴番号(修正)
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号(修正)を設定します。
     *
     * @param ID_ID_History 履歴番号(修正)
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * ステータス(修正)を取得します。
     *
     * @return ステータス(修正)
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータス(修正)を設定します。
     *
     * @param ID_Status ステータス(修正)
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 処理種別(修正)を取得します。
     *
     * @return 処理種別(修正)
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
    }

    /**
     * 処理種別(修正)を設定します。
     *
     * @param ID_Type_Process 処理種別(修正)
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
    }

    /**
     * 取消済フラグ(修正)を取得します。
     *
     * @return 取消済フラグ(修正)
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済フラグ(修正)を設定します。
     *
     * @param ID_Flag_Torikeshizumi 取消済フラグ(修正)
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * エラー番号(修正)を取得します。
     *
     * @return エラー番号(修正)
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラー番号(修正)を設定します。
     *
     * @param ID_Code_Error エラー番号(修正)
     */
    public void setID_Code_Error(String ID_Code_Error) {
        this.ID_Code_Error = ID_Code_Error;
    }

    /**
     * エラーメッセージ(修正)を取得します。
     *
     * @return エラーメッセージ(修正)
     */
    public String getID_ErrorMessage() {
        return ID_ErrorMessage;
    }

    /**
     * エラーメッセージ(修正)を設定します。
     *
     * @param ID_ErrorMessage エラーメッセージ(修正)
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        this.ID_ErrorMessage = ID_ErrorMessage;
    }

    /**
     * 退避貸付金残高(修正)を取得します。
     *
     * @return 退避貸付金残高(修正)
     */
    public String getID_Keep_M_KashitsukeZan() {
        return ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避貸付金残高(修正)を設定します。
     *
     * @param ID_Keep_M_KashitsukeZan 退避貸付金残高(修正)
     */
    public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
        this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避約定元金(修正)を取得します。
     *
     * @return 退避約定元金(修正)
     */
    public String getID_Keep_M_YakujoGankin() {
        return ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定元金(修正)を設定します。
     *
     * @param ID_Keep_M_YakujoGankin 退避約定元金(修正)
     */
    public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
        this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定利息(修正)を取得します。
     *
     * @return 退避約定利息(修正)
     */
    public String getID_Keep_M_YakujoRisoku() {
        return ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避約定利息(修正)を設定します。
     *
     * @param ID_Keep_M_YakujoRisoku 退避約定利息(修正)
     */
    public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
        this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避償還期限(修正)を取得します。
     *
     * @return 退避償還期限(修正)
     */
    public String getID_Keep_Date_ShokanKigen() {
        return ID_Keep_Date_ShokanKigen;
    }

    /**
     * 退避償還期限(修正)を設定します。
     *
     * @param ID_Keep_Date_ShokanKigen 退避償還期限(修正)
     */
    public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
        this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
    }

    /**
     * 債権管理番号(修正)を取得します。
     *
     * @return 債権管理番号(修正)
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号(修正)を設定します。
     *
     * @param ID_ID_Credit 債権管理番号(修正)
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 顧客コード(修正)を取得します。
     *
     * @return 顧客コード(修正)
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 顧客コード(修正)を設定します。
     *
     * @param ID_Code_Customer 顧客コード(修正)
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
    }

    /**
     * 充当順序変更区分(修正)を取得します。
     *
     * @return 充当順序変更区分(修正)
     */
    public String getID_Kubun_JutoJunjoHenko() {
        return ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 充当順序変更区分(修正)を設定します。
     *
     * @param ID_Kubun_JutoJunjoHenko 充当順序変更区分(修正)
     */
    public void setID_Kubun_JutoJunjoHenko(String ID_Kubun_JutoJunjoHenko) {
        this.ID_Kubun_JutoJunjoHenko = ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 請求データの退避任意繰償還利息(修正)を取得します。
     *
     * @return 請求データの退避任意繰償還利息(修正)
     */
    public String getID_Keep_Seikyu_M_NinKuriRisoku() {
        return ID_Keep_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの退避任意繰償還利息(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_NinKuriRisoku 請求データの退避任意繰償還利息(修正)
     */
    public void setID_Keep_Seikyu_M_NinKuriRisoku(String ID_Keep_Seikyu_M_NinKuriRisoku) {
        this.ID_Keep_Seikyu_M_NinKuriRisoku = ID_Keep_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの退避請求繰償還利息(修正)を取得します。
     *
     * @return 請求データの退避請求繰償還利息(修正)
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの退避請求繰償還利息(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriRisoku 請求データの退避請求繰償還利息(修正)
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku(String ID_Keep_Seikyu_M_SeiKuriRisoku) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku = ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの退避請求繰償還元金(修正)を取得します。
     *
     * @return 請求データの退避請求繰償還元金(修正)
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin() {
        return ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 請求データの退避請求繰償還元金(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriGankin 請求データの退避請求繰償還元金(修正)
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin(String ID_Keep_Seikyu_M_SeiKuriGankin) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin = ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 約定データの退避請求繰償還利息(修正)を取得します。
     *
     * @return 約定データの退避請求繰償還利息(修正)
     */
    public String getID_Keep_Yakujo_M_SeiKuriRisoku() {
        return ID_Keep_Yakujo_M_SeiKuriRisoku;
    }

    /**
     * 約定データの退避請求繰償還利息(修正)を設定します。
     *
     * @param ID_Keep_Yakujo_M_SeiKuriRisoku 約定データの退避請求繰償還利息(修正)
     */
    public void setID_Keep_Yakujo_M_SeiKuriRisoku(String ID_Keep_Yakujo_M_SeiKuriRisoku) {
        this.ID_Keep_Yakujo_M_SeiKuriRisoku = ID_Keep_Yakujo_M_SeiKuriRisoku;
    }

    /**
     * 元利金計(修正)を取得します。
     *
     * @return 元利金計(修正)
     */
    public String getID_M_GanrikinKei() {
        return ID_M_GanrikinKei;
    }

    /**
     * 元利金計(修正)を設定します。
     *
     * @param ID_M_GanrikinKei 元利金計(修正)
     */
    public void setID_M_GanrikinKei(String ID_M_GanrikinKei) {
        this.ID_M_GanrikinKei = ID_M_GanrikinKei;
    }

    /**
     * 最新データ更新日付(修正)を取得します。
     *
     * @return 最新データ更新日付(修正)
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新データ更新日付(修正)を設定します。
     *
     * @param ID_Data_LastUpDate 最新データ更新日付(修正)
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 退避履歴番号(修正)を取得します。
     *
     * @return 退避履歴番号(修正)
     */
    public String getID_Keep_ID_History() {
        return ID_Keep_ID_History;
    }

    /**
     * 退避履歴番号(修正)を設定します。
     *
     * @param ID_Keep_ID_History 退避履歴番号(修正)
     */
    public void setID_Keep_ID_History(String ID_Keep_ID_History) {
        this.ID_Keep_ID_History = ID_Keep_ID_History;
    }

    /**
     * 扱店別稟議データの償還期限年月(修正)を取得します。
     *
     * @return 扱店別稟議データの償還期限年月(修正)
     */
    public String getID_Date_ShokanKigen_aRingi() {
        return ID_Date_ShokanKigen_aRingi;
    }

    /**
     * 扱店別稟議データの償還期限年月(修正)を設定します。
     *
     * @param ID_Date_ShokanKigen_aRingi 扱店別稟議データの償還期限年月(修正)
     */
    public void setID_Date_ShokanKigen_aRingi(String ID_Date_ShokanKigen_aRingi) {
        this.ID_Date_ShokanKigen_aRingi = ID_Date_ShokanKigen_aRingi;
    }

    /**
     * 扱店別稟議データの貸付残高(修正)を取得します。
     *
     * @return 扱店別稟議データの貸付残高(修正)
     */
    public String getID_M_KashitsukeZandaka_aRingi() {
        return ID_M_KashitsukeZandaka_aRingi;
    }

    /**
     * 扱店別稟議データの貸付残高(修正)を設定します。
     *
     * @param ID_M_KashitsukeZandaka_aRingi 扱店別稟議データの貸付残高(修正)
     */
    public void setID_M_KashitsukeZandaka_aRingi(String ID_M_KashitsukeZandaka_aRingi) {
        this.ID_M_KashitsukeZandaka_aRingi = ID_M_KashitsukeZandaka_aRingi;
    }

    /**
     * 請求データの約定元金(修正)を取得します。
     *
     * @return 請求データの約定元金(修正)
     */
    public String getID_M_YakujoGankin_Seikyu() {
        return ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 請求データの約定元金(修正)を設定します。
     *
     * @param ID_M_YakujoGankin_Seikyu 請求データの約定元金(修正)
     */
    public void setID_M_YakujoGankin_Seikyu(String ID_M_YakujoGankin_Seikyu) {
        this.ID_M_YakujoGankin_Seikyu = ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 請求データの約定利息(修正)を取得します。
     *
     * @return 請求データの約定利息(修正)
     */
    public String getID_M_YakujoRisoku_Seikyu() {
        return ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 請求データの約定利息(修正)を設定します。
     *
     * @param ID_M_YakujoRisoku_Seikyu 請求データの約定利息(修正)
     */
    public void setID_M_YakujoRisoku_Seikyu(String ID_M_YakujoRisoku_Seikyu) {
        this.ID_M_YakujoRisoku_Seikyu = ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 件数を取得します。
     *
     * @return 件数
     */
    public String getKensu() {
        return Kensu;
    }

    /**
     * 件数を設定します。
     *
     * @param Kensu 件数
     */
    public void setKensu(String Kensu) {
        this.Kensu = Kensu;
    }

    /**
     * 約定元金を取得します。
     *
     * @return 約定元金
     */
    public String getM_YakujoGankin() {
        return M_YakujoGankin;
    }

    /**
     * 約定元金を設定します。
     *
     * @param M_YakujoGankin 約定元金
     */
    public void setM_YakujoGankin(String M_YakujoGankin) {
        this.M_YakujoGankin = M_YakujoGankin;
    }

    /**
     * 報告時分秒(非表示)を取得します。
     *
     * @return 報告時分秒(非表示)
     */
    public String getID_Time_Report_H() {
        return ID_Time_Report_H;
    }

    /**
     * 報告時分秒(非表示)を設定します。
     *
     * @param ID_Time_Report_H 報告時分秒(非表示)
     */
    public void setID_Time_Report_H(String ID_Time_Report_H) {
        this.ID_Time_Report_H = ID_Time_Report_H;
    }

    /**
     * 報告書番号(非表示)を取得します。
     *
     * @return 報告書番号(非表示)
     */
    public String getID_ID_Report_H() {
        return ID_ID_Report_H;
    }

    /**
     * 報告書番号(非表示)を設定します。
     *
     * @param ID_ID_Report_H 報告書番号(非表示)
     */
    public void setID_ID_Report_H(String ID_ID_Report_H) {
        this.ID_ID_Report_H = ID_ID_Report_H;
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
     * @param ProcessMode 処理モード
     */
    public void setProcessMode(String ProcessMode) {
        this.ProcessMode = ProcessMode;
    }

    /**
     * 赤データ入力領域を取得します。
     *
     * @return 赤データ入力領域
     */
    public String getRedArea() {
        return redArea;
    }

    /**
     * 赤データ入力領域を設定します。
     *
     * @param redArea 赤データ入力領域
     */
    public void setRedArea(String redArea) {
        this.redArea = redArea;
    }

    /**
     * 黒データ入力領域を取得します。
     *
     * @return 黒データ入力領域
     */
    public String getBlackArea() {
        return blackArea;
    }

    /**
     * 黒データ入力領域を設定します。
     *
     * @param blackArea 黒データ入力領域
     */
    public void setBlackArea(String blackArea) {
        this.blackArea = blackArea;
    }

    /**
     * 最新の請求データの約定元金を取得します。
     *
     * @return 最新の請求データの約定元金
     */
    public String getNew_M_YakujoGankin() {
        return New_M_YakujoGankin;
    }

    /**
     * 最新の請求データの約定元金を設定します。
     *
     * @param M_New_YakujoGankin 最新の請求データの約定元金
     */
    public void setNew_M_YakujoGankin(String New_M_YakujoGankin) {
        this.New_M_YakujoGankin = New_M_YakujoGankin;
    }

    /**
     * 最新の請求データの約定利息を取得します。
     *
     * @return 最新の請求データの約定利息
     */
    public String getNew_M_YakujoRisoku() {
        return New_M_YakujoRisoku;
    }

    /**
     * 最新の請求データの約定利息を設定します。
     *
     * @param M_New_YakujoGankin 最新の請求データの約定利息
     */
    public void setNew_M_YakujoRisoku(String New_M_YakujoRisoku) {
        this.New_M_YakujoRisoku = New_M_YakujoRisoku;
    }

    /**
     * 最新の請求データの任意繰償還利息を取得します。
     *
     * @return 最新の請求データの任意繰償還利息
     */
    public String getNew_M_Seikyu_NinKuriRisoku() {
        return New_M_Seikyu_NinKuriRisoku;
    }

    /**
     * 最新の請求データの任意繰償還利息を設定します。
     *
     * @param M_New_YakujoGankin 最新の請求データの任意繰償還利息
     */
    public void setNew_M_Seikyu_NinKuriRisoku(String New_M_Seikyu_NinKuriRisoku) {
        this.New_M_Seikyu_NinKuriRisoku = New_M_Seikyu_NinKuriRisoku;
    }

    /**
     * 最新の請求データの請求繰償還利息を取得します。
     *
     * @return 最新の請求データの請求繰償還利息
     */
    public String getNew_M_Seikyu_SeiKuriRisoku() {
        return New_M_Seikyu_SeiKuriRisoku;
    }

    /**
     * 最新の請求データの請求繰償還利息を設定します。
     *
     * @param M_New_YakujoGankin 最新の請求データの請求繰償還利息
     */
    public void setNew_M_Seikyu_SeiKuriRisoku(String New_M_Seikyu_SeiKuriRisoku) {
        this.New_M_Seikyu_SeiKuriRisoku = New_M_Seikyu_SeiKuriRisoku;
    }

    /**
     * 最新の請求データの請求繰償還元金を取得します。
     *
     * @return 最新の請求データの請求繰償還元金
     */
    public String getNew_M_Seikyu_SeiKuriGankin() {
        return New_M_Seikyu_SeiKuriGankin;
    }

    /**
     * 最新の請求データの請求繰償還元金を設定します。
     *
     * @param M_New_YakujoGankin 最新の請求データの請求繰償還元金
     */
    public void setNew_M_Seikyu_SeiKuriGankin(String New_M_Seikyu_SeiKuriGankin) {
        this.New_M_Seikyu_SeiKuriGankin = New_M_Seikyu_SeiKuriGankin;
    }

    /**
     * 入力の約定利息を取得します。
     *
     * @return 入力の約定利息
     */
    public String getID_Input_M_YakujoRisoku() {
        return ID_Input_M_YakujoRisoku;
    }

    /**
     * 入力の約定利息を設定します。
     *
     * @param ID_Input_M_YakujoRisoku 入力の約定利息
     */
    public void setID_Input_M_YakujoRisoku(String ID_Input_M_YakujoRisoku) {
        this.ID_Input_M_YakujoRisoku = ID_Input_M_YakujoRisoku;
    }

    /**
     * 入力の約定元金を取得します。
     *
     * @return 入力の約定利息
     */
    public String getID_Input_M_YakujoGankin() {
        return ID_Input_M_YakujoGankin;
    }

    /**
     * 入力の約定元金を設定します。
     *
     * @param ID_Input_M_YakujoGankin 入力の約定利息
     */
    public void setID_Input_M_YakujoGankin(String ID_Input_M_YakujoGankin) {
        this.ID_Input_M_YakujoGankin = ID_Input_M_YakujoGankin;
    }

    /**
     * 入力の控除利息を取得します。
     *
     * @return 入力の控除利息
     */
    public String getID_Input_M_KojoRisoku() {
        return ID_Input_M_KojoRisoku;
    }

    /**
     * 入力の控除利息を設定します。
     *
     * @param ID_Input_M_KojoRisoku 入力の控除利息
     */
    public void setID_Input_M_KojoRisoku(String ID_Input_M_KojoRisoku) {
        this.ID_Input_M_KojoRisoku = ID_Input_M_KojoRisoku;
    }

    /**
     * 約定利息　ＤＢ取得値を取得します。
     *
     * @return 約定利息　ＤＢ取得値
     */
    public String getID_M_YakujoRisoku() {
        return ID_M_YakujoRisoku;
    }

    /**
     * 約定利息　ＤＢ取得値を設定します。
     *
     * @param ID_M_YakujoRisoku 約定利息　ＤＢ取得値
     */
    public void setID_M_YakujoRisoku(String ID_M_YakujoRisoku) {
        this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
    }

    /**
     * 約定元金　ＤＢ取得値を取得します。
     *
     * @return 約定元金　ＤＢ取得値
     */
    public String getID_M_YakujoGankin() {
        return ID_M_YakujoGankin;
    }

    /**
     * 約定元金　ＤＢ取得値を設定します。
     *
     * @param ID_M_YakujoGankin 約定元金(円)（修正）
     */
    public void setID_M_YakujoGankin(String ID_M_YakujoGankin) {
        this.ID_M_YakujoGankin = ID_M_YakujoGankin;
    }

}