//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_02.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd003_02のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md003_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** エラー */
    private String lblErr;
    /** メッセージ */
    private String lblMessage;
    /** コメント */
    private String lblComment;
    /** 赤データ入力領域タイトル */
    private String lblID_Head_Red;
    /** 赤データ入力領域タイトル（"赤"） */
    private String lblID_Head_Red2;
    /** 顧客名 */
    private String lblID_Name_Customer_Red;
    /** 扱店名 */
    private String lblID_Name_Organization_Red;
    /** 公庫支店 */
    private String lblID_Code_KoukoShiten_Red;
    /** 扱店 */
    private String lblID_Code_Organization_Red;
    /** 店舗 */
    private String lblID_Code_Tenpo_Red;
    /** 年度 */
    private String lblID_Year_Red;
    /** 方式資金 */
    private String lblID_Code_HoshikiShikin_Red;
    /** 番号 */
    private String lblID_ID_Ringi_Red;
    /** 枝番 */
    private String lblID_ID_RingiBranch_Red;
    /** 貸付実行日 */
    private String lblID_Date_Kashitsukejikko_Red;
    /** 貸付金額 */
    private String lblID_M_Kashitsuke_Red;
    /** 資金使途 */
    private String lblID_Code_ShikinShito_Red;
    /** 事業別 */
    private String lblID_Code_Jigyobetsu_Red;
    /** 利率（％） */
    private String lblID_Riritsu_Red;
    /** 特利区分 */
    private String lblID_Kubun_Tokuri_Red;
    /** 特利（％） */
    private String lblID_Tokuri_Red;
    /** 償還方法 */
    private String lblID_Code_Shokan_Red;
    /** 据置期限 */
    private String lblID_Date_SueokiKigen_Red;
    /** 償還期限 */
    private String lblID_Date_ShokanKigen_Red;
    /** 元利金払込日 */
    private String lblID_Date_GanrikinHaraiKomi_Red;
    /** 元利又は元金均等額(円) */
    private String lblID_M_GankinKinto_Red;
    /** 払込前残元金(円) */
    private String lblID_M_KashitsukeZandaka_Red;
    /** 払込期日 */
    private String lblID_Date_Haraikomi_Red;
    /** 払込金額(円) */
    private String lblID_M_Haraikomi_Red;
    /** 控除利息(円) */
    private String lblID_M_KojoRisoku_Red;
    /** 差引払込額(円) */
    private String lblID_M_SashihikiHaraikomi_Red;
    /** 払込後残元金(円) */
    private String lblID_M_ZangankinAfterHaraikomi_Red;
    /** 約定利息(円) */
    private String lblID_M_YakujoRisoku_Red;
    /** 約定元金(円) */
    private String lblID_M_YakujoGankin_Red;
    /** 遅延損害金(円) */
    private String lblID_M_ChienSongai_Red;
    /** 違約金(円) */
    private String lblID_M_Iyaku_Red;
    /** 違約金(利子軽減分)(円) */
    private String lblID_M_IyakuRishikeigen_Red;
    /** 仮受金からの充当額(円) */
    private String lblID_M_KariukeIppanJuto_Red;
    /** 入金日 */
    private String lblID_Date_Nyukin_Red;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori_Red;
    /** 送金日 */
    private String lblID_Date_Sokin_Red;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi_Red;
    /** 代弁履行後の作成 */
    private String ckhAfter_Daibensai_Red;
    /** 黒データ入力領域タイトル */
    private String lblID_Head;
    /** 顧客名（修正） */
    private String lblID_Name_Customer;
    /** 扱店名（修正） */
    private String lblID_Name_Organization;
    /** 公庫支店（修正） */
    private String lblID_Code_KoukoShiten;
    /** 扱店（修正） */
    private String lblID_Code_Organization;
    /** 店舗（修正） */
    private String lblID_Code_Tenpo;
    /** 年度（修正） */
    private String lblID_Year;
    /** 方式資金（修正） */
    private String lblID_Code_HoshikiShikin;
    /** 番号（修正） */
    private String lblID_ID_Ringi;
    /** 枝番（修正） */
    private String lblID_ID_RingiBranch;
    /** 貸付実行日（修正） */
    private String lblID_Date_Kashitsukejikko;
    /** 貸付金額（修正） */
    private String lblID_M_Kashitsuke;
    /** 資金使途（修正） */
    private String lblID_Code_ShikinShito;
    /** 事業別（修正） */
    private String lblID_Code_Jigyobetsu;
    /** 利率（％）（修正） */
    private String lblID_Riritsu;
    /** 特利区分（修正） */
    private String lblID_Code_TokuriKubun;
    /** 特利（％）（修正） */
    private String lblID_Tokuri;
    /** 償還方法（修正） */
    private String lblID_Code_Shokan;
    /** 据置期限（修正） */
    private String lblID_Date_SueokiKigen;
    /** 償還期限（修正） */
    private String lblID_Date_ShokanKigen;
    /** 元利金払込日（修正） */
    private String lblID_Date_GanrikinHaraikomi;
    /** 元利又は元金均等額(円)（修正） */
    private String lblID_M_GankinKinto;
    /** 払込前残元金(円)（修正） */
    private String lblID_M_KashitsukeZandaka;
    /** 払込期日（修正） */
    private String lblID_Date_Haraikomi;
    /** 払込金額(円)（修正） */
    private String lblID_M_Haraikomi;
    /** 控除利息(円)（修正） */
    private String lblID_M_KojoRisoku;
    /** 差引払込額(円)（修正） */
    private String lblID_M_SashihikiHaraikomi;
    /** 払込後残元金(円)（修正） */
    private String lblID_M_ZangankinAfterHaraikomi;
    /** 約定利息(円)（修正） */
    private String lblID_M_YakujoRisoku;
    /** 約定元金(円)（修正） */
    private String lblID_M_YakujoGankin;
    /** 遅延損害金(円)（修正） */
    private String lblID_M_ChienSongai;
    /** 違約金(円)（修正） */
    private String lblID_M_Iyaku;
    /** 違約金(利子軽減分)(円)（修正） */
    private String lblID_M_IyakuRishikeigen;
    /** 仮受金からの充当額(円)（修正） */
    private String lblID_M_KariukeIppanJuto;
    /** 入金日（修正） */
    private String lblID_Date_Nyukin;
    /** 受託者勘定処理年月（修正） */
    private String lblID_Date_Jtkshori;
    /** 送金日（修正） */
    private String lblID_Date_Sokin;
    /** 送金日番号（修正） */
    private String lblID_ID_Sokinbi;
    /** 代弁履行後の作成（修正） */
    private String ckhAfter_Daibensai;
    /** 初期データの報告年月日 */
    private String ID_Date_Report_Pri;
    /** 初期データの顧客名 */
    private String ID_Name_Customer_Pri;
    /** 初期データの扱店名 */
    private String ID_Name_Organization_Pri;
    /** 初期データの公庫支店 */
    private String ID_Code_KoukoShiten_Pri;
    /** 初期データの扱店 */
    private String ID_Code_Organization_Pri;
    /** 初期データの店舗 */
    private String ID_Code_Tenpo_Pri;
    /** 初期データの年度 */
    private String ID_Year_Pri;
    /** 初期データの方式資金 */
    private String ID_Code_HoshikiShikin_Pri;
    /** 初期データの番号 */
    private String ID_ID_Ringi_Pri;
    /** 初期データの枝番 */
    private String ID_ID_RingiBranch_Pri;
    /** 初期データの貸付実行日 */
    private String ID_Date_kashitsukeJikko_Pri;
    /** 初期データの貸付金額 */
    private String ID_M_Kashitsuke_Pri;
    /** 初期データの資金使途 */
    private String ID_Code_ShikinShito_Pri;
    /** 初期データの事業別 */
    private String ID_Code_Jigyobetsu_Pri;
    /** 初期データの利率(%) */
    private String ID_Riritsu_Pri;
    /** 初期データの特利区分 */
    private String ID_Code_TokuriKubun_Pri;
    /** 初期データの特利(%) */
    private String ID_Tokuri_Pri;
    /** 初期データの償還方法 */
    private String ID_Code_Shokan_Pri;
    /** 初期データの据置期限 */
    private String ID_Date_SueokiKigen_Pri;
    /** 初期データの償還期限 */
    private String ID_Date_ShokanKigen_Pri;
    /** 初期データの元利金払込日 */
    private String ID_Date_GanrikinHaraikomi_Pri;
    /** 初期データの元利又は元金均等額 */
    private String ID_M_GankinKinto_Pri;
    /** 初期データの払込前残元金 */
    private String ID_M_KashitsukeZandaka_Pri;
    /** 初期データの払込期日 */
    private String ID_Date_Haraikomi_Pri;
    /** 初期データの払込額 */
    private String ID_M_Haraikomi_Pri;
    /** 初期データの控除利息 */
    private String ID_M_KojoRisoku_Pri;
    /** 初期データの入金日 */
    private String ID_Date_Nyukin_Pri;
    /** 初期データの約定利息 */
    private String ID_M_YakujoRisoku_Pri;
    /** 初期データの約定元金 */
    private String ID_M_YakujoGankin_Pri;
    /** 初期データの遅延損害金 */
    private String ID_M_ChienSongai_Pri;
    /** 初期データの違約金 */
    private String ID_M_Iyaku_Pri;
    /** 初期データの違約金（利子軽減分） */
    private String ID_M_IyakuRishikeigen_Pri;
    /** 初期データの仮受金からの充当額 */
    private String ID_M_KariukeIppanJuto_Pri;
    /** 初期データの差引払込額 */
    private String ID_M_SashihikiHaraikomi_Pri;
    /** 初期データの払込後残元金 */
    private String ID_M_ZangankinAfterHaraikomi_Pri;
    /** 初期データの受託者勘定処理年月 */
    private String ID_Date_Jtkshori_Pri;
    /** 初期データの送金日 */
    private String ID_Date_Sokin_Pri;
    /** 初期データの送金日番号 */
    private String ID_ID_Sokinbi_Pri;
    /** 初期データの報告書番号 */
    private String ID_ID_Report_Pri;
    /** 初期データの報告時分秒 */
    private String ID_Time_Report_Pri;
    /** 初期データのユーザID */
    private String ID_User_ID_Pri;
    /** 初期データの伝送番号 */
    private String ID_ID_Denso_Pri;
    /** 初期データのデータコード */
    private String ID_DataCode_Pri;
    /** 初期データの残高件数 */
    private String ID_Count_Zandaka_Pri;
    /** 初期データの履歴番号 */
    private String ID_ID_History_Pri;
    /** 初期データのステータス */
    private String ID_Status_Pri;
    /** 初期データの処理種別 */
    private String ID_Type_Process_Pri;
    /** 初期データの取消済フラグ */
    private String ID_Flag_Torikeshizumi_Pri;
    /** 初期データのエラー番号 */
    private String ID_Code_Error_Pri;
    /** 初期データのエラーメッセージ */
    private String ID_ErrorMessage_Pri;
    /** 初期データの退避貸付金残高 */
    private String ID_Keep_M_KashitsukeZan_Pri;
    /** 初期データの退避約定元金 */
    private String ID_Keep_M_YakujoGankin_Pri;
    /** 初期データの退避約定利息 */
    private String ID_Keep_M_YakujoRisoku_Pri;
    /** 初期データの退避償還期限 */
    private String ID_Keep_Date_ShokanKigen_Pri;
    /** 初期データの債権管理番号 */
    private String ID_ID_Credit_Pri;
    /** 初期データの顧客コード */
    private String ID_Code_Customer_Pri;
    /** 初期データの充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko_Pri;
    /** 初期データの請求データの退避任意繰償還利息 */
    private String ID_Keep_Seikyu_M_NinKuriRisoku_Pri;
    /** 初期データの請求データの退避請求繰償還利息 */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku_Pri;
    /** 初期データの請求データの退避請求繰償還元金 */
    private String ID_Keep_Seikyu_M_SeiKuriGankin_Pri;
    /** 初期データの約定データの退避請求繰償還利息 */
    private String ID_Keep_Yakujo_M_SeiKuriRisoku_Pri;
    /** 初期データの元利金計 */
    private String ID_M_GanrikinKei_Pri;
    /** 初期データの最新データ更新日付 */
    private String ID_Data_LastUpDate_Pri;
    /** 初期データの退避履歴番号 */
    private String ID_Keep_ID_History_Pri;
    /** 初期データの扱店別稟議データより取得した償還期限年月 */
    private String ID_Date_ShokanKigen_aRingi_Pri;
    /** 初期データの扱店別稟議データより取得した貸付残高 */
    private String ID_M_KashitsukeZandaka_aRingi_Pri;
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
    /** 退避約定元金 */
    private String ID_Keep_M_YakujoGankin_Red;
    /** 退避約定利息 */
    private String ID_Keep_M_YakujoRisoku_Red;
    /** 退避約定元金(修正) */
    private String ID_Keep_M_YakujoGankin;
    /** 退避約定利息(修正) */
    private String ID_Keep_M_YakujoRisoku;
    /** 履歴番号 */
    private String ID_ID_History_Red;
    /** データコード */
    private String ID_DataCode_Red;
    /** 残高件数 */
    private String ID_Count_Zandaka_Red;
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
    /** 退避償還期限 */
    private String ID_Keep_Date_ShokanKigen_Red;
    /** 債権管理番号 */
    private String ID_ID_Credit_Red;
    /** 顧客コード */
    private String ID_Code_Customer_Red;
    /** 扱店別稟議データの貸付残高 */
    private String ID_M_KashitsukeZandaka_aRingi_Red;
    /** 扱店別稟議データの償還期限 */
    private String ID_Date_ShokanKigen_aRingi_Red;
    /** 請求データの約定元金 */
    private String ID_M_YakujoGankin_Seikyu_Red;
    /** 請求データの約定利息 */
    private String ID_M_YakujoRisoku_Seikyu_Red;
    /** 充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko_RED;
    /** 請求データの退避任意繰上償還利息 */
    private String ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    /** 請求データの退避請求繰上償還利息 */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    /** 請求データの退避請求繰上償還元金 */
    private String ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    /** 約定データの退避請求繰上償還利息 */
    private String ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
    /** 最新データ更新日付 */
    private String ID_Data_LastUpDate_Red;
    /** 退避履歴番号 */
    private String ID_Keep_ID_History_Red;
    /** 履歴番号(修正) */
    private String ID_ID_History;
    /** データコード(修正) */
    private String ID_DataCode;
    /** 残高件数(修正) */
    private String ID_Count_Zandaka;
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
    /** 退避償還期限(修正) */
    private String ID_Keep_Date_ShokanKigen;
    /** 債権管理番号(修正) */
    private String ID_ID_Credit;
    /** 顧客コード(修正) */
    private String ID_Code_Customer;
    /** 扱店別稟議データの貸付残高(修正) */
    private String ID_M_KashitsukeZandaka_aRingi;
    /** 扱店別稟議データの償還期限(修正) */
    private String ID_Date_ShokanKigen_aRingi;
    /** 請求データの約定元金(修正) */
    private String ID_M_YakujoGankin_Seikyu;
    /** 請求データの約定利息(修正) */
    private String ID_M_YakujoRisoku_Seikyu;
    /** 充当順序変更区分(修正) */
    private String ID_Kubun_JutoJunjoHenko;
    /** 請求データの退避任意繰上償還利息(修正) */
    private String ID_Keep_Seikyu_M_NinKuriRisoku;
    /** 請求データの退避請求繰上償還利息(修正) */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku;
    /** 請求データの退避請求繰上償還元金(修正) */
    private String ID_Keep_Seikyu_M_SeiKuriGankin;
    /** 約定データの退避請求繰上償還利息(修正) */
    private String ID_Keep_Yakujo_M_SeiKuriRisoku;
    /** 最新データ更新日付(修正) */
    private String ID_Data_LastUpDate;
    /** 退避履歴番号(修正) */
    private String ID_Keep_ID_History;
    /** モードタイプ */
    private String ModeType;
    /** 元利金計 */
    private String ID_M_GanrikinKei_Red;
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
    /** 元利金計(修正) */
    private String ID_M_GanrikinKei;
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
    /** 請求データの任意繰上償還利息 */
    private String ID_Seikyu_M_NinKuriRisoku_Red;
    /** 請求データの請求繰上償還利息 */
    private String ID_Seikyu_M_SeiKuriRisoku_Red;
    /** 請求データの請求繰上償還元金 */
    private String ID_Seikyu_M_SeiKuriGankin_Red;
    /** 約定データの請求繰上償還利息 */
    private String ID_Yakujo_M_SeiKuriRisoku_Red;
    /** 請求データの任意繰上償還利息(修正) */
    private String ID_Seikyu_M_NinKuriRisoku;
    /** 請求データの請求繰上償還利息(修正) */
    private String ID_Seikyu_M_SeiKuriRisoku;
    /** 請求データの請求繰上償還元金(修正) */
    private String ID_Seikyu_M_SeiKuriGankin;
    /** 約定データの請求繰上償還利息(修正) */
    private String ID_Yakujo_M_SeiKuriRisoku;
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
     * コメントを取得します。
     *
     * @return コメント
     */
    public String getLblComment() {
        return lblComment;
    }

    /**
     * コメントを設定します。
     *
     * @param lblComment コメント
     */
    public void setLblComment(String lblComment) {
        this.lblComment = lblComment;
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
    public String getLblID_Name_Customer_Red() {
        return lblID_Name_Customer_Red;
    }

    /**
     * 顧客名を設定します。
     *
     * @param lblID_Name_Customer_Red 顧客名
     */
    public void setLblID_Name_Customer_Red(String lblID_Name_Customer_Red) {
        this.lblID_Name_Customer_Red = lblID_Name_Customer_Red;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getLblID_Name_Organization_Red() {
        return lblID_Name_Organization_Red;
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblID_Name_Organization_Red 扱店名
     */
    public void setLblID_Name_Organization_Red(String lblID_Name_Organization_Red) {
        this.lblID_Name_Organization_Red = lblID_Name_Organization_Red;
    }

    /**
     * 公庫支店を取得します。
     *
     * @return 公庫支店
     */
    public String getLblID_Code_KoukoShiten_Red() {
        return lblID_Code_KoukoShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     *
     * @param lblID_Code_KoukoShiten_Red 公庫支店
     */
    public void setLblID_Code_KoukoShiten_Red(String lblID_Code_KoukoShiten_Red) {
        this.lblID_Code_KoukoShiten_Red = lblID_Code_KoukoShiten_Red;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getLblID_Code_Organization_Red() {
        return lblID_Code_Organization_Red;
    }

    /**
     * 扱店を設定します。
     *
     * @param lblID_Code_Organization_Red 扱店
     */
    public void setLblID_Code_Organization_Red(String lblID_Code_Organization_Red) {
        this.lblID_Code_Organization_Red = lblID_Code_Organization_Red;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getLblID_Code_Tenpo_Red() {
        return lblID_Code_Tenpo_Red;
    }

    /**
     * 店舗を設定します。
     *
     * @param lblID_Code_Tenpo_Red 店舗
     */
    public void setLblID_Code_Tenpo_Red(String lblID_Code_Tenpo_Red) {
        this.lblID_Code_Tenpo_Red = lblID_Code_Tenpo_Red;
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getLblID_Year_Red() {
        return lblID_Year_Red;
    }

    /**
     * 年度を設定します。
     *
     * @param lblID_Year_Red 年度
     */
    public void setLblID_Year_Red(String lblID_Year_Red) {
        this.lblID_Year_Red = lblID_Year_Red;
    }

    /**
     * 方式資金を取得します。
     *
     * @return 方式資金
     */
    public String getLblID_Code_HoshikiShikin_Red() {
        return lblID_Code_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     *
     * @param lblID_Code_HoshikiShikin_Red 方式資金
     */
    public void setLblID_Code_HoshikiShikin_Red(String lblID_Code_HoshikiShikin_Red) {
        this.lblID_Code_HoshikiShikin_Red = lblID_Code_HoshikiShikin_Red;
    }

    /**
     * 番号を取得します。
     *
     * @return 番号
     */
    public String getLblID_ID_Ringi_Red() {
        return lblID_ID_Ringi_Red;
    }

    /**
     * 番号を設定します。
     *
     * @param lblID_ID_Ringi_Red 番号
     */
    public void setLblID_ID_Ringi_Red(String lblID_ID_Ringi_Red) {
        this.lblID_ID_Ringi_Red = lblID_ID_Ringi_Red;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch_Red() {
        return lblID_ID_RingiBranch_Red;
    }

    /**
     * 枝番を設定します。
     *
     * @param lblID_ID_RingiBranch_Red 枝番
     */
    public void setLblID_ID_RingiBranch_Red(String lblID_ID_RingiBranch_Red) {
        this.lblID_ID_RingiBranch_Red = lblID_ID_RingiBranch_Red;
    }

    /**
     * 貸付実行日を取得します。
     *
     * @return 貸付実行日
     */
    public String getLblID_Date_Kashitsukejikko_Red() {
        return lblID_Date_Kashitsukejikko_Red;
    }

    /**
     * 貸付実行日を設定します。
     *
     * @param lblID_Date_Kashitsukejikko_Red 貸付実行日
     */
    public void setLblID_Date_Kashitsukejikko_Red(String lblID_Date_Kashitsukejikko_Red) {
        this.lblID_Date_Kashitsukejikko_Red = lblID_Date_Kashitsukejikko_Red;
    }

    /**
     * 貸付金額を取得します。
     *
     * @return 貸付金額
     */
    public String getLblID_M_Kashitsuke_Red() {
        return lblID_M_Kashitsuke_Red;
    }

    /**
     * 貸付金額を設定します。
     *
     * @param lblID_M_Kashitsuke_Red 貸付金額
     */
    public void setLblID_M_Kashitsuke_Red(String lblID_M_Kashitsuke_Red) {
        this.lblID_M_Kashitsuke_Red = lblID_M_Kashitsuke_Red;
    }

    /**
     * 資金使途を取得します。
     *
     * @return 資金使途
     */
    public String getLblID_Code_ShikinShito_Red() {
        return lblID_Code_ShikinShito_Red;
    }

    /**
     * 資金使途を設定します。
     *
     * @param lblID_Code_ShikinShito_Red 資金使途
     */
    public void setLblID_Code_ShikinShito_Red(String lblID_Code_ShikinShito_Red) {
        this.lblID_Code_ShikinShito_Red = lblID_Code_ShikinShito_Red;
    }

    /**
     * 事業別を取得します。
     *
     * @return 事業別
     */
    public String getLblID_Code_Jigyobetsu_Red() {
        return lblID_Code_Jigyobetsu_Red;
    }

    /**
     * 事業別を設定します。
     *
     * @param lblID_Code_Jigyobetsu_Red 事業別
     */
    public void setLblID_Code_Jigyobetsu_Red(String lblID_Code_Jigyobetsu_Red) {
        this.lblID_Code_Jigyobetsu_Red = lblID_Code_Jigyobetsu_Red;
    }

    /**
     * 利率（％）を取得します。
     *
     * @return 利率（％）
     */
    public String getLblID_Riritsu_Red() {
        return lblID_Riritsu_Red;
    }

    /**
     * 利率（％）を設定します。
     *
     * @param lblID_Riritsu_Red 利率（％）
     */
    public void setLblID_Riritsu_Red(String lblID_Riritsu_Red) {
        this.lblID_Riritsu_Red = lblID_Riritsu_Red;
    }

    /**
     * 特利区分を取得します。
     *
     * @return 特利区分
     */
    public String getLblID_Kubun_Tokuri_Red() {
        return lblID_Kubun_Tokuri_Red;
    }

    /**
     * 特利区分を設定します。
     *
     * @param lblID_Kubun_Tokuri_Red 特利区分
     */
    public void setLblID_Kubun_Tokuri_Red(String lblID_Kubun_Tokuri_Red) {
        this.lblID_Kubun_Tokuri_Red = lblID_Kubun_Tokuri_Red;
    }

    /**
     * 特利（％）を取得します。
     *
     * @return 特利（％）
     */
    public String getLblID_Tokuri_Red() {
        return lblID_Tokuri_Red;
    }

    /**
     * 特利（％）を設定します。
     *
     * @param lblID_Tokuri_Red 特利（％）
     */
    public void setLblID_Tokuri_Red(String lblID_Tokuri_Red) {
        this.lblID_Tokuri_Red = lblID_Tokuri_Red;
    }

    /**
     * 償還方法を取得します。
     *
     * @return 償還方法
     */
    public String getLblID_Code_Shokan_Red() {
        return lblID_Code_Shokan_Red;
    }

    /**
     * 償還方法を設定します。
     *
     * @param lblID_Code_Shokan_Red 償還方法
     */
    public void setLblID_Code_Shokan_Red(String lblID_Code_Shokan_Red) {
        this.lblID_Code_Shokan_Red = lblID_Code_Shokan_Red;
    }

    /**
     * 据置期限を取得します。
     *
     * @return 据置期限
     */
    public String getLblID_Date_SueokiKigen_Red() {
        return lblID_Date_SueokiKigen_Red;
    }

    /**
     * 据置期限を設定します。
     *
     * @param lblID_Date_SueokiKigen_Red 据置期限
     */
    public void setLblID_Date_SueokiKigen_Red(String lblID_Date_SueokiKigen_Red) {
        this.lblID_Date_SueokiKigen_Red = lblID_Date_SueokiKigen_Red;
    }

    /**
     * 償還期限を取得します。
     *
     * @return 償還期限
     */
    public String getLblID_Date_ShokanKigen_Red() {
        return lblID_Date_ShokanKigen_Red;
    }

    /**
     * 償還期限を設定します。
     *
     * @param lblID_Date_ShokanKigen_Red 償還期限
     */
    public void setLblID_Date_ShokanKigen_Red(String lblID_Date_ShokanKigen_Red) {
        this.lblID_Date_ShokanKigen_Red = lblID_Date_ShokanKigen_Red;
    }

    /**
     * 元利金払込日を取得します。
     *
     * @return 元利金払込日
     */
    public String getLblID_Date_GanrikinHaraiKomi_Red() {
        return lblID_Date_GanrikinHaraiKomi_Red;
    }

    /**
     * 元利金払込日を設定します。
     *
     * @param lblID_Date_GanrikinHaraiKomi_Red 元利金払込日
     */
    public void setLblID_Date_GanrikinHaraiKomi_Red(String lblID_Date_GanrikinHaraiKomi_Red) {
        this.lblID_Date_GanrikinHaraiKomi_Red = lblID_Date_GanrikinHaraiKomi_Red;
    }

    /**
     * 元利又は元金均等額(円)を取得します。
     *
     * @return 元利又は元金均等額(円)
     */
    public String getLblID_M_GankinKinto_Red() {
        return lblID_M_GankinKinto_Red;
    }

    /**
     * 元利又は元金均等額(円)を設定します。
     *
     * @param lblID_M_GankinKinto_Red 元利又は元金均等額(円)
     */
    public void setLblID_M_GankinKinto_Red(String lblID_M_GankinKinto_Red) {
        this.lblID_M_GankinKinto_Red = lblID_M_GankinKinto_Red;
    }

    /**
     * 払込前残元金(円)を取得します。
     *
     * @return 払込前残元金(円)
     */
    public String getLblID_M_KashitsukeZandaka_Red() {
        return lblID_M_KashitsukeZandaka_Red;
    }

    /**
     * 払込前残元金(円)を設定します。
     *
     * @param lblID_M_KashitsukeZandaka_Red 払込前残元金(円)
     */
    public void setLblID_M_KashitsukeZandaka_Red(String lblID_M_KashitsukeZandaka_Red) {
        this.lblID_M_KashitsukeZandaka_Red = lblID_M_KashitsukeZandaka_Red;
    }

    /**
     * 払込期日を取得します。
     *
     * @return 払込期日
     */
    public String getLblID_Date_Haraikomi_Red() {
        return lblID_Date_Haraikomi_Red;
    }

    /**
     * 払込期日を設定します。
     *
     * @param lblID_Date_Haraikomi_Red 払込期日
     */
    public void setLblID_Date_Haraikomi_Red(String lblID_Date_Haraikomi_Red) {
        this.lblID_Date_Haraikomi_Red = lblID_Date_Haraikomi_Red;
    }

    /**
     * 払込金額(円)を取得します。
     *
     * @return 払込金額(円)
     */
    public String getLblID_M_Haraikomi_Red() {
        return lblID_M_Haraikomi_Red;
    }

    /**
     * 払込金額(円)を設定します。
     *
     * @param lblID_M_Haraikomi_Red 払込金額(円)
     */
    public void setLblID_M_Haraikomi_Red(String lblID_M_Haraikomi_Red) {
        this.lblID_M_Haraikomi_Red = lblID_M_Haraikomi_Red;
    }

    /**
     * 控除利息(円)を取得します。
     *
     * @return 控除利息(円)
     */
    public String getLblID_M_KojoRisoku_Red() {
        return lblID_M_KojoRisoku_Red;
    }

    /**
     * 控除利息(円)を設定します。
     *
     * @param lblID_M_KojoRisoku_Red 控除利息(円)
     */
    public void setLblID_M_KojoRisoku_Red(String lblID_M_KojoRisoku_Red) {
        this.lblID_M_KojoRisoku_Red = lblID_M_KojoRisoku_Red;
    }

    /**
     * 差引払込額(円)を取得します。
     *
     * @return 差引払込額(円)
     */
    public String getLblID_M_SashihikiHaraikomi_Red() {
        return lblID_M_SashihikiHaraikomi_Red;
    }

    /**
     * 差引払込額(円)を設定します。
     *
     * @param lblID_M_SashihikiHaraikomi_Red 差引払込額(円)
     */
    public void setLblID_M_SashihikiHaraikomi_Red(String lblID_M_SashihikiHaraikomi_Red) {
        this.lblID_M_SashihikiHaraikomi_Red = lblID_M_SashihikiHaraikomi_Red;
    }

    /**
     * 払込後残元金(円)を取得します。
     *
     * @return 払込後残元金(円)
     */
    public String getLblID_M_ZangankinAfterHaraikomi_Red() {
        return lblID_M_ZangankinAfterHaraikomi_Red;
    }

    /**
     * 払込後残元金(円)を設定します。
     *
     * @param lblID_M_ZangankinAfterHaraikomi_Red 払込後残元金(円)
     */
    public void setLblID_M_ZangankinAfterHaraikomi_Red(String lblID_M_ZangankinAfterHaraikomi_Red) {
        this.lblID_M_ZangankinAfterHaraikomi_Red = lblID_M_ZangankinAfterHaraikomi_Red;
    }

    /**
     * 約定利息(円)を取得します。
     *
     * @return 約定利息(円)
     */
    public String getLblID_M_YakujoRisoku_Red() {
        return lblID_M_YakujoRisoku_Red;
    }

    /**
     * 約定利息(円)を設定します。
     *
     * @param lblID_M_YakujoRisoku_Red 約定利息(円)
     */
    public void setLblID_M_YakujoRisoku_Red(String lblID_M_YakujoRisoku_Red) {
        this.lblID_M_YakujoRisoku_Red = lblID_M_YakujoRisoku_Red;
    }

    /**
     * 約定元金(円)を取得します。
     *
     * @return 約定元金(円)
     */
    public String getLblID_M_YakujoGankin_Red() {
        return lblID_M_YakujoGankin_Red;
    }

    /**
     * 約定元金(円)を設定します。
     *
     * @param lblID_M_YakujoGankin_Red 約定元金(円)
     */
    public void setLblID_M_YakujoGankin_Red(String lblID_M_YakujoGankin_Red) {
        this.lblID_M_YakujoGankin_Red = lblID_M_YakujoGankin_Red;
    }

    /**
     * 遅延損害金(円)を取得します。
     *
     * @return 遅延損害金(円)
     */
    public String getLblID_M_ChienSongai_Red() {
        return lblID_M_ChienSongai_Red;
    }

    /**
     * 遅延損害金(円)を設定します。
     *
     * @param lblID_M_ChienSongai_Red 遅延損害金(円)
     */
    public void setLblID_M_ChienSongai_Red(String lblID_M_ChienSongai_Red) {
        this.lblID_M_ChienSongai_Red = lblID_M_ChienSongai_Red;
    }

    /**
     * 違約金(円)を取得します。
     *
     * @return 違約金(円)
     */
    public String getLblID_M_Iyaku_Red() {
        return lblID_M_Iyaku_Red;
    }

    /**
     * 違約金(円)を設定します。
     *
     * @param lblID_M_Iyaku_Red 違約金(円)
     */
    public void setLblID_M_Iyaku_Red(String lblID_M_Iyaku_Red) {
        this.lblID_M_Iyaku_Red = lblID_M_Iyaku_Red;
    }

    /**
     * 違約金(利子軽減分)(円)を取得します。
     *
     * @return 違約金(利子軽減分)(円)
     */
    public String getLblID_M_IyakuRishikeigen_Red() {
        return lblID_M_IyakuRishikeigen_Red;
    }

    /**
     * 違約金(利子軽減分)(円)を設定します。
     *
     * @param lblID_M_IyakuRishikeigen_Red 違約金(利子軽減分)(円)
     */
    public void setLblID_M_IyakuRishikeigen_Red(String lblID_M_IyakuRishikeigen_Red) {
        this.lblID_M_IyakuRishikeigen_Red = lblID_M_IyakuRishikeigen_Red;
    }

    /**
     * 仮受金からの充当額(円)を取得します。
     *
     * @return 仮受金からの充当額(円)
     */
    public String getLblID_M_KariukeIppanJuto_Red() {
        return lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金からの充当額(円)を設定します。
     *
     * @param lblID_M_KariukeIppanJuto_Red 仮受金からの充当額(円)
     */
    public void setLblID_M_KariukeIppanJuto_Red(String lblID_M_KariukeIppanJuto_Red) {
        this.lblID_M_KariukeIppanJuto_Red = lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 入金日を取得します。
     *
     * @return 入金日
     */
    public String getLblID_Date_Nyukin_Red() {
        return lblID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     *
     * @param lblID_Date_Nyukin_Red 入金日
     */
    public void setLblID_Date_Nyukin_Red(String lblID_Date_Nyukin_Red) {
        this.lblID_Date_Nyukin_Red = lblID_Date_Nyukin_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     *
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_Jtkshori_Red() {
        return lblID_Date_Jtkshori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     *
     * @param lblID_Date_Jtkshori_Red 受託者勘定処理年月
     */
    public void setLblID_Date_Jtkshori_Red(String lblID_Date_Jtkshori_Red) {
        this.lblID_Date_Jtkshori_Red = lblID_Date_Jtkshori_Red;
    }

    /**
     * 送金日を取得します。
     *
     * @return 送金日
     */
    public String getLblID_Date_Sokin_Red() {
        return lblID_Date_Sokin_Red;
    }

    /**
     * 送金日を設定します。
     *
     * @param lblID_Date_Sokin_Red 送金日
     */
    public void setLblID_Date_Sokin_Red(String lblID_Date_Sokin_Red) {
        this.lblID_Date_Sokin_Red = lblID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     *
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi_Red() {
        return lblID_ID_Sokinbi_Red;
    }

    /**
     * 送金日番号を設定します。
     *
     * @param lblID_ID_Sokinbi_Red 送金日番号
     */
    public void setLblID_ID_Sokinbi_Red(String lblID_ID_Sokinbi_Red) {
        this.lblID_ID_Sokinbi_Red = lblID_ID_Sokinbi_Red;
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
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名（修正）を設定します。
     *
     * @param lblID_Name_Customer 顧客名（修正）
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 扱店名（修正）を取得します。
     *
     * @return 扱店名（修正）
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名（修正）を設定します。
     *
     * @param lblID_Name_Organization 扱店名（修正）
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 公庫支店（修正）を取得します。
     *
     * @return 公庫支店（修正）
     */
    public String getLblID_Code_KoukoShiten() {
        return lblID_Code_KoukoShiten;
    }

    /**
     * 公庫支店（修正）を設定します。
     *
     * @param lblID_Code_KoukoShiten 公庫支店（修正）
     */
    public void setLblID_Code_KoukoShiten(String lblID_Code_KoukoShiten) {
        this.lblID_Code_KoukoShiten = lblID_Code_KoukoShiten;
    }

    /**
     * 扱店（修正）を取得します。
     *
     * @return 扱店（修正）
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店（修正）を設定します。
     *
     * @param lblID_Code_Organization 扱店（修正）
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗（修正）を取得します。
     *
     * @return 店舗（修正）
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗（修正）を設定します。
     *
     * @param lblID_Code_Tenpo 店舗（修正）
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 年度（修正）を取得します。
     *
     * @return 年度（修正）
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度（修正）を設定します。
     *
     * @param lblID_Year 年度（修正）
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }

    /**
     * 方式資金（修正）を取得します。
     *
     * @return 方式資金（修正）
     */
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金（修正）を設定します。
     *
     * @param lblID_Code_HoshikiShikin 方式資金（修正）
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
    }

    /**
     * 番号（修正）を取得します。
     *
     * @return 番号（修正）
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号（修正）を設定します。
     *
     * @param lblID_ID_Ringi 番号（修正）
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }

    /**
     * 枝番（修正）を取得します。
     *
     * @return 枝番（修正）
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番（修正）を設定します。
     *
     * @param lblID_ID_RingiBranch 枝番（修正）
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }

    /**
     * 貸付実行日（修正）を取得します。
     *
     * @return 貸付実行日（修正）
     */
    public String getLblID_Date_Kashitsukejikko() {
        return lblID_Date_Kashitsukejikko;
    }

    /**
     * 貸付実行日（修正）を設定します。
     *
     * @param lblID_Date_Kashitsukejikko 貸付実行日（修正）
     */
    public void setLblID_Date_Kashitsukejikko(String lblID_Date_Kashitsukejikko) {
        this.lblID_Date_Kashitsukejikko = lblID_Date_Kashitsukejikko;
    }

    /**
     * 貸付金額（修正）を取得します。
     *
     * @return 貸付金額（修正）
     */
    public String getLblID_M_Kashitsuke() {
        return lblID_M_Kashitsuke;
    }

    /**
     * 貸付金額（修正）を設定します。
     *
     * @param lblID_M_Kashitsuke 貸付金額（修正）
     */
    public void setLblID_M_Kashitsuke(String lblID_M_Kashitsuke) {
        this.lblID_M_Kashitsuke = lblID_M_Kashitsuke;
    }

    /**
     * 資金使途（修正）を取得します。
     *
     * @return 資金使途（修正）
     */
    public String getLblID_Code_ShikinShito() {
        return lblID_Code_ShikinShito;
    }

    /**
     * 資金使途（修正）を設定します。
     *
     * @param lblID_Code_ShikinShito 資金使途（修正）
     */
    public void setLblID_Code_ShikinShito(String lblID_Code_ShikinShito) {
        this.lblID_Code_ShikinShito = lblID_Code_ShikinShito;
    }

    /**
     * 事業別（修正）を取得します。
     *
     * @return 事業別（修正）
     */
    public String getLblID_Code_Jigyobetsu() {
        return lblID_Code_Jigyobetsu;
    }

    /**
     * 事業別（修正）を設定します。
     *
     * @param lblID_Code_Jigyobetsu 事業別（修正）
     */
    public void setLblID_Code_Jigyobetsu(String lblID_Code_Jigyobetsu) {
        this.lblID_Code_Jigyobetsu = lblID_Code_Jigyobetsu;
    }

    /**
     * 利率（％）（修正）を取得します。
     *
     * @return 利率（％）（修正）
     */
    public String getLblID_Riritsu() {
        return lblID_Riritsu;
    }

    /**
     * 利率（％）（修正）を設定します。
     *
     * @param lblID_Riritsu 利率（％）（修正）
     */
    public void setLblID_Riritsu(String lblID_Riritsu) {
        this.lblID_Riritsu = lblID_Riritsu;
    }

    /**
     * 特利区分（修正）を取得します。
     *
     * @return 特利区分（修正）
     */
    public String getLblID_Code_TokuriKubun() {
        return lblID_Code_TokuriKubun;
    }

    /**
     * 特利区分（修正）を設定します。
     *
     * @param lblID_Code_TokuriKubun 特利区分（修正）
     */
    public void setLblID_Code_TokuriKubun(String lblID_Code_TokuriKubun) {
        this.lblID_Code_TokuriKubun = lblID_Code_TokuriKubun;
    }

    /**
     * 特利（％）（修正）を取得します。
     *
     * @return 特利（％）（修正）
     */
    public String getLblID_Tokuri() {
        return lblID_Tokuri;
    }

    /**
     * 特利（％）（修正）を設定します。
     *
     * @param lblID_Tokuri 特利（％）（修正）
     */
    public void setLblID_Tokuri(String lblID_Tokuri) {
        this.lblID_Tokuri = lblID_Tokuri;
    }

    /**
     * 償還方法（修正）を取得します。
     *
     * @return 償還方法（修正）
     */
    public String getLblID_Code_Shokan() {
        return lblID_Code_Shokan;
    }

    /**
     * 償還方法（修正）を設定します。
     *
     * @param lblID_Code_Shokan 償還方法（修正）
     */
    public void setLblID_Code_Shokan(String lblID_Code_Shokan) {
        this.lblID_Code_Shokan = lblID_Code_Shokan;
    }

    /**
     * 据置期限（修正）を取得します。
     *
     * @return 据置期限（修正）
     */
    public String getLblID_Date_SueokiKigen() {
        return lblID_Date_SueokiKigen;
    }

    /**
     * 据置期限（修正）を設定します。
     *
     * @param lblID_Date_SueokiKigen 据置期限（修正）
     */
    public void setLblID_Date_SueokiKigen(String lblID_Date_SueokiKigen) {
        this.lblID_Date_SueokiKigen = lblID_Date_SueokiKigen;
    }

    /**
     * 償還期限（修正）を取得します。
     *
     * @return 償還期限（修正）
     */
    public String getLblID_Date_ShokanKigen() {
        return lblID_Date_ShokanKigen;
    }

    /**
     * 償還期限（修正）を設定します。
     *
     * @param lblID_Date_ShokanKigen 償還期限（修正）
     */
    public void setLblID_Date_ShokanKigen(String lblID_Date_ShokanKigen) {
        this.lblID_Date_ShokanKigen = lblID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日（修正）を取得します。
     *
     * @return 元利金払込日（修正）
     */
    public String getLblID_Date_GanrikinHaraikomi() {
        return lblID_Date_GanrikinHaraikomi;
    }

    /**
     * 元利金払込日（修正）を設定します。
     *
     * @param lblID_Date_GanrikinHaraikomi 元利金払込日（修正）
     */
    public void setLblID_Date_GanrikinHaraikomi(String lblID_Date_GanrikinHaraikomi) {
        this.lblID_Date_GanrikinHaraikomi = lblID_Date_GanrikinHaraikomi;
    }

    /**
     * 元利又は元金均等額(円)（修正）を取得します。
     *
     * @return 元利又は元金均等額(円)（修正）
     */
    public String getLblID_M_GankinKinto() {
        return lblID_M_GankinKinto;
    }

    /**
     * 元利又は元金均等額(円)（修正）を設定します。
     *
     * @param lblID_M_GankinKinto 元利又は元金均等額(円)（修正）
     */
    public void setLblID_M_GankinKinto(String lblID_M_GankinKinto) {
        this.lblID_M_GankinKinto = lblID_M_GankinKinto;
    }

    /**
     * 払込前残元金(円)（修正）を取得します。
     *
     * @return 払込前残元金(円)（修正）
     */
    public String getLblID_M_KashitsukeZandaka() {
        return lblID_M_KashitsukeZandaka;
    }

    /**
     * 払込前残元金(円)（修正）を設定します。
     *
     * @param lblID_M_KashitsukeZandaka 払込前残元金(円)（修正）
     */
    public void setLblID_M_KashitsukeZandaka(String lblID_M_KashitsukeZandaka) {
        this.lblID_M_KashitsukeZandaka = lblID_M_KashitsukeZandaka;
    }

    /**
     * 払込期日（修正）を取得します。
     *
     * @return 払込期日（修正）
     */
    public String getLblID_Date_Haraikomi() {
        return lblID_Date_Haraikomi;
    }

    /**
     * 払込期日（修正）を設定します。
     *
     * @param lblID_Date_Haraikomi 払込期日（修正）
     */
    public void setLblID_Date_Haraikomi(String lblID_Date_Haraikomi) {
        this.lblID_Date_Haraikomi = lblID_Date_Haraikomi;
    }

    /**
     * 払込金額(円)（修正）を取得します。
     *
     * @return 払込金額(円)（修正）
     */
    public String getLblID_M_Haraikomi() {
        return lblID_M_Haraikomi;
    }

    /**
     * 払込金額(円)（修正）を設定します。
     *
     * @param lblID_M_Haraikomi 払込金額(円)（修正）
     */
    public void setLblID_M_Haraikomi(String lblID_M_Haraikomi) {
        this.lblID_M_Haraikomi = lblID_M_Haraikomi;
    }

    /**
     * 控除利息(円)（修正）を取得します。
     *
     * @return 控除利息(円)（修正）
     */
    public String getLblID_M_KojoRisoku() {
        return lblID_M_KojoRisoku;
    }

    /**
     * 控除利息(円)（修正）を設定します。
     *
     * @param lblID_M_KojoRisoku 控除利息(円)（修正）
     */
    public void setLblID_M_KojoRisoku(String lblID_M_KojoRisoku) {
        this.lblID_M_KojoRisoku = lblID_M_KojoRisoku;
    }

    /**
     * 差引払込額(円)（修正）を取得します。
     *
     * @return 差引払込額(円)（修正）
     */
    public String getLblID_M_SashihikiHaraikomi() {
        return lblID_M_SashihikiHaraikomi;
    }

    /**
     * 差引払込額(円)（修正）を設定します。
     *
     * @param lblID_M_SashihikiHaraikomi 差引払込額(円)（修正）
     */
    public void setLblID_M_SashihikiHaraikomi(String lblID_M_SashihikiHaraikomi) {
        this.lblID_M_SashihikiHaraikomi = lblID_M_SashihikiHaraikomi;
    }

    /**
     * 払込後残元金(円)（修正）を取得します。
     *
     * @return 払込後残元金(円)（修正）
     */
    public String getLblID_M_ZangankinAfterHaraikomi() {
        return lblID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 払込後残元金(円)（修正）を設定します。
     *
     * @param lblID_M_ZangankinAfterHaraikomi 払込後残元金(円)（修正）
     */
    public void setLblID_M_ZangankinAfterHaraikomi(String lblID_M_ZangankinAfterHaraikomi) {
        this.lblID_M_ZangankinAfterHaraikomi = lblID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 約定利息(円)（修正）を取得します。
     *
     * @return 約定利息(円)（修正）
     */
    public String getLblID_M_YakujoRisoku() {
        return lblID_M_YakujoRisoku;
    }

    /**
     * 約定利息(円)（修正）を設定します。
     *
     * @param lblID_M_YakujoRisoku 約定利息(円)（修正）
     */
    public void setLblID_M_YakujoRisoku(String lblID_M_YakujoRisoku) {
        this.lblID_M_YakujoRisoku = lblID_M_YakujoRisoku;
    }

    /**
     * 約定元金(円)（修正）を取得します。
     *
     * @return 約定元金(円)（修正）
     */
    public String getLblID_M_YakujoGankin() {
        return lblID_M_YakujoGankin;
    }

    /**
     * 約定元金(円)（修正）を設定します。
     *
     * @param lblID_M_YakujoGankin 約定元金(円)（修正）
     */
    public void setLblID_M_YakujoGankin(String lblID_M_YakujoGankin) {
        this.lblID_M_YakujoGankin = lblID_M_YakujoGankin;
    }

    /**
     * 遅延損害金(円)（修正）を取得します。
     *
     * @return 遅延損害金(円)（修正）
     */
    public String getLblID_M_ChienSongai() {
        return lblID_M_ChienSongai;
    }

    /**
     * 遅延損害金(円)（修正）を設定します。
     *
     * @param lblID_M_ChienSongai 遅延損害金(円)（修正）
     */
    public void setLblID_M_ChienSongai(String lblID_M_ChienSongai) {
        this.lblID_M_ChienSongai = lblID_M_ChienSongai;
    }

    /**
     * 違約金(円)（修正）を取得します。
     *
     * @return 違約金(円)（修正）
     */
    public String getLblID_M_Iyaku() {
        return lblID_M_Iyaku;
    }

    /**
     * 違約金(円)（修正）を設定します。
     *
     * @param lblID_M_Iyaku 違約金(円)（修正）
     */
    public void setLblID_M_Iyaku(String lblID_M_Iyaku) {
        this.lblID_M_Iyaku = lblID_M_Iyaku;
    }

    /**
     * 違約金(利子軽減分)(円)（修正）を取得します。
     *
     * @return 違約金(利子軽減分)(円)（修正）
     */
    public String getLblID_M_IyakuRishikeigen() {
        return lblID_M_IyakuRishikeigen;
    }

    /**
     * 違約金(利子軽減分)(円)（修正）を設定します。
     *
     * @param lblID_M_IyakuRishikeigen 違約金(利子軽減分)(円)（修正）
     */
    public void setLblID_M_IyakuRishikeigen(String lblID_M_IyakuRishikeigen) {
        this.lblID_M_IyakuRishikeigen = lblID_M_IyakuRishikeigen;
    }

    /**
     * 仮受金からの充当額(円)（修正）を取得します。
     *
     * @return 仮受金からの充当額(円)（修正）
     */
    public String getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額(円)（修正）を設定します。
     *
     * @param lblID_M_KariukeIppanJuto 仮受金からの充当額(円)（修正）
     */
    public void setLblID_M_KariukeIppanJuto(String lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }

    /**
     * 入金日（修正）を取得します。
     *
     * @return 入金日（修正）
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日（修正）を設定します。
     *
     * @param lblID_Date_Nyukin 入金日（修正）
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }

    /**
     * 受託者勘定処理年月（修正）を取得します。
     *
     * @return 受託者勘定処理年月（修正）
     */
    public String getLblID_Date_Jtkshori() {
        return lblID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月（修正）を設定します。
     *
     * @param lblID_Date_Jtkshori 受託者勘定処理年月（修正）
     */
    public void setLblID_Date_Jtkshori(String lblID_Date_Jtkshori) {
        this.lblID_Date_Jtkshori = lblID_Date_Jtkshori;
    }

    /**
     * 送金日（修正）を取得します。
     *
     * @return 送金日（修正）
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金日（修正）を設定します。
     *
     * @param lblID_Date_Sokin 送金日（修正）
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }

    /**
     * 送金日番号（修正）を取得します。
     *
     * @return 送金日番号（修正）
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号（修正）を設定します。
     *
     * @param lblID_ID_Sokinbi 送金日番号（修正）
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
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
     * 初期データの報告年月日を取得します。
     *
     * @return 初期データの報告年月日
     */
    public String getID_Date_Report_Pri() {
        return ID_Date_Report_Pri;
    }

    /**
     * 初期データの報告年月日を設定します。
     *
     * @param ID_Date_Report_Pri 初期データの報告年月日
     */
    public void setID_Date_Report_Pri(String ID_Date_Report_Pri) {
        this.ID_Date_Report_Pri = ID_Date_Report_Pri;
    }

    /**
     * 初期データの顧客名を取得します。
     *
     * @return 初期データの顧客名
     */
    public String getID_Name_Customer_Pri() {
        return ID_Name_Customer_Pri;
    }

    /**
     * 初期データの顧客名を設定します。
     *
     * @param ID_Name_Customer_Pri 初期データの顧客名
     */
    public void setID_Name_Customer_Pri(String ID_Name_Customer_Pri) {
        this.ID_Name_Customer_Pri = ID_Name_Customer_Pri;
    }

    /**
     * 初期データの扱店名を取得します。
     *
     * @return 初期データの扱店名
     */
    public String getID_Name_Organization_Pri() {
        return ID_Name_Organization_Pri;
    }

    /**
     * 初期データの扱店名を設定します。
     *
     * @param ID_Name_Organization_Pri 初期データの扱店名
     */
    public void setID_Name_Organization_Pri(String ID_Name_Organization_Pri) {
        this.ID_Name_Organization_Pri = ID_Name_Organization_Pri;
    }

    /**
     * 初期データの公庫支店を取得します。
     *
     * @return 初期データの公庫支店
     */
    public String getID_Code_KoukoShiten_Pri() {
        return ID_Code_KoukoShiten_Pri;
    }

    /**
     * 初期データの公庫支店を設定します。
     *
     * @param ID_Code_KoukoShiten_Pri 初期データの公庫支店
     */
    public void setID_Code_KoukoShiten_Pri(String ID_Code_KoukoShiten_Pri) {
        this.ID_Code_KoukoShiten_Pri = ID_Code_KoukoShiten_Pri;
    }

    /**
     * 初期データの扱店を取得します。
     *
     * @return 初期データの扱店
     */
    public String getID_Code_Organization_Pri() {
        return ID_Code_Organization_Pri;
    }

    /**
     * 初期データの扱店を設定します。
     *
     * @param ID_Code_Organization_Pri 初期データの扱店
     */
    public void setID_Code_Organization_Pri(String ID_Code_Organization_Pri) {
        this.ID_Code_Organization_Pri = ID_Code_Organization_Pri;
    }

    /**
     * 初期データの店舗を取得します。
     *
     * @return 初期データの店舗
     */
    public String getID_Code_Tenpo_Pri() {
        return ID_Code_Tenpo_Pri;
    }

    /**
     * 初期データの店舗を設定します。
     *
     * @param ID_Code_Tenpo_Pri 初期データの店舗
     */
    public void setID_Code_Tenpo_Pri(String ID_Code_Tenpo_Pri) {
        this.ID_Code_Tenpo_Pri = ID_Code_Tenpo_Pri;
    }

    /**
     * 初期データの年度を取得します。
     *
     * @return 初期データの年度
     */
    public String getID_Year_Pri() {
        return ID_Year_Pri;
    }

    /**
     * 初期データの年度を設定します。
     *
     * @param ID_Year_Pri 初期データの年度
     */
    public void setID_Year_Pri(String ID_Year_Pri) {
        this.ID_Year_Pri = ID_Year_Pri;
    }

    /**
     * 初期データの方式資金を取得します。
     *
     * @return 初期データの方式資金
     */
    public String getID_Code_HoshikiShikin_Pri() {
        return ID_Code_HoshikiShikin_Pri;
    }

    /**
     * 初期データの方式資金を設定します。
     *
     * @param ID_Code_HoshikiShikin_Pri 初期データの方式資金
     */
    public void setID_Code_HoshikiShikin_Pri(String ID_Code_HoshikiShikin_Pri) {
        this.ID_Code_HoshikiShikin_Pri = ID_Code_HoshikiShikin_Pri;
    }

    /**
     * 初期データの番号を取得します。
     *
     * @return 初期データの番号
     */
    public String getID_ID_Ringi_Pri() {
        return ID_ID_Ringi_Pri;
    }

    /**
     * 初期データの番号を設定します。
     *
     * @param ID_ID_Ringi_Pri 初期データの番号
     */
    public void setID_ID_Ringi_Pri(String ID_ID_Ringi_Pri) {
        this.ID_ID_Ringi_Pri = ID_ID_Ringi_Pri;
    }

    /**
     * 初期データの枝番を取得します。
     *
     * @return 初期データの枝番
     */
    public String getID_ID_RingiBranch_Pri() {
        return ID_ID_RingiBranch_Pri;
    }

    /**
     * 初期データの枝番を設定します。
     *
     * @param ID_ID_RingiBranch_Pri 初期データの枝番
     */
    public void setID_ID_RingiBranch_Pri(String ID_ID_RingiBranch_Pri) {
        this.ID_ID_RingiBranch_Pri = ID_ID_RingiBranch_Pri;
    }

    /**
     * 初期データの貸付実行日を取得します。
     *
     * @return 初期データの貸付実行日
     */
    public String getID_Date_kashitsukeJikko_Pri() {
        return ID_Date_kashitsukeJikko_Pri;
    }

    /**
     * 初期データの貸付実行日を設定します。
     *
     * @param ID_Date_kashitsukeJikko_Pri 初期データの貸付実行日
     */
    public void setID_Date_kashitsukeJikko_Pri(String ID_Date_kashitsukeJikko_Pri) {
        this.ID_Date_kashitsukeJikko_Pri = ID_Date_kashitsukeJikko_Pri;
    }

    /**
     * 初期データの貸付金額を取得します。
     *
     * @return 初期データの貸付金額
     */
    public String getID_M_Kashitsuke_Pri() {
        return ID_M_Kashitsuke_Pri;
    }

    /**
     * 初期データの貸付金額を設定します。
     *
     * @param ID_M_Kashitsuke_Pri 初期データの貸付金額
     */
    public void setID_M_Kashitsuke_Pri(String ID_M_Kashitsuke_Pri) {
        this.ID_M_Kashitsuke_Pri = ID_M_Kashitsuke_Pri;
    }

    /**
     * 初期データの資金使途を取得します。
     *
     * @return 初期データの資金使途
     */
    public String getID_Code_ShikinShito_Pri() {
        return ID_Code_ShikinShito_Pri;
    }

    /**
     * 初期データの資金使途を設定します。
     *
     * @param ID_Code_ShikinShito_Pri 初期データの資金使途
     */
    public void setID_Code_ShikinShito_Pri(String ID_Code_ShikinShito_Pri) {
        this.ID_Code_ShikinShito_Pri = ID_Code_ShikinShito_Pri;
    }

    /**
     * 初期データの事業別を取得します。
     *
     * @return 初期データの事業別
     */
    public String getID_Code_Jigyobetsu_Pri() {
        return ID_Code_Jigyobetsu_Pri;
    }

    /**
     * 初期データの事業別を設定します。
     *
     * @param ID_Code_Jigyobetsu_Pri 初期データの事業別
     */
    public void setID_Code_Jigyobetsu_Pri(String ID_Code_Jigyobetsu_Pri) {
        this.ID_Code_Jigyobetsu_Pri = ID_Code_Jigyobetsu_Pri;
    }

    /**
     * 初期データの利率(%)を取得します。
     *
     * @return 初期データの利率(%)
     */
    public String getID_Riritsu_Pri() {
        return ID_Riritsu_Pri;
    }

    /**
     * 初期データの利率(%)を設定します。
     *
     * @param ID_Riritsu_Pri 初期データの利率(%)
     */
    public void setID_Riritsu_Pri(String ID_Riritsu_Pri) {
        this.ID_Riritsu_Pri = ID_Riritsu_Pri;
    }

    /**
     * 初期データの特利区分を取得します。
     *
     * @return 初期データの特利区分
     */
    public String getID_Code_TokuriKubun_Pri() {
        return ID_Code_TokuriKubun_Pri;
    }

    /**
     * 初期データの特利区分を設定します。
     *
     * @param ID_Code_TokuriKubun_Pri 初期データの特利区分
     */
    public void setID_Code_TokuriKubun_Pri(String ID_Code_TokuriKubun_Pri) {
        this.ID_Code_TokuriKubun_Pri = ID_Code_TokuriKubun_Pri;
    }

    /**
     * 初期データの特利(%)を取得します。
     *
     * @return 初期データの特利(%)
     */
    public String getID_Tokuri_Pri() {
        return ID_Tokuri_Pri;
    }

    /**
     * 初期データの特利(%)を設定します。
     *
     * @param ID_Tokuri_Pri 初期データの特利(%)
     */
    public void setID_Tokuri_Pri(String ID_Tokuri_Pri) {
        this.ID_Tokuri_Pri = ID_Tokuri_Pri;
    }

    /**
     * 初期データの償還方法を取得します。
     *
     * @return 初期データの償還方法
     */
    public String getID_Code_Shokan_Pri() {
        return ID_Code_Shokan_Pri;
    }

    /**
     * 初期データの償還方法を設定します。
     *
     * @param ID_Code_Shokan_Pri 初期データの償還方法
     */
    public void setID_Code_Shokan_Pri(String ID_Code_Shokan_Pri) {
        this.ID_Code_Shokan_Pri = ID_Code_Shokan_Pri;
    }

    /**
     * 初期データの据置期限を取得します。
     *
     * @return 初期データの据置期限
     */
    public String getID_Date_SueokiKigen_Pri() {
        return ID_Date_SueokiKigen_Pri;
    }

    /**
     * 初期データの据置期限を設定します。
     *
     * @param ID_Date_SueokiKigen_Pri 初期データの据置期限
     */
    public void setID_Date_SueokiKigen_Pri(String ID_Date_SueokiKigen_Pri) {
        this.ID_Date_SueokiKigen_Pri = ID_Date_SueokiKigen_Pri;
    }

    /**
     * 初期データの償還期限を取得します。
     *
     * @return 初期データの償還期限
     */
    public String getID_Date_ShokanKigen_Pri() {
        return ID_Date_ShokanKigen_Pri;
    }

    /**
     * 初期データの償還期限を設定します。
     *
     * @param ID_Date_ShokanKigen_Pri 初期データの償還期限
     */
    public void setID_Date_ShokanKigen_Pri(String ID_Date_ShokanKigen_Pri) {
        this.ID_Date_ShokanKigen_Pri = ID_Date_ShokanKigen_Pri;
    }

    /**
     * 初期データの元利金払込日を取得します。
     *
     * @return 初期データの元利金払込日
     */
    public String getID_Date_GanrikinHaraikomi_Pri() {
        return ID_Date_GanrikinHaraikomi_Pri;
    }

    /**
     * 初期データの元利金払込日を設定します。
     *
     * @param ID_Date_GanrikinHaraikomi_Pri 初期データの元利金払込日
     */
    public void setID_Date_GanrikinHaraikomi_Pri(String ID_Date_GanrikinHaraikomi_Pri) {
        this.ID_Date_GanrikinHaraikomi_Pri = ID_Date_GanrikinHaraikomi_Pri;
    }

    /**
     * 初期データの元利又は元金均等額を取得します。
     *
     * @return 初期データの元利又は元金均等額
     */
    public String getID_M_GankinKinto_Pri() {
        return ID_M_GankinKinto_Pri;
    }

    /**
     * 初期データの元利又は元金均等額を設定します。
     *
     * @param ID_M_GankinKinto_Pri 初期データの元利又は元金均等額
     */
    public void setID_M_GankinKinto_Pri(String ID_M_GankinKinto_Pri) {
        this.ID_M_GankinKinto_Pri = ID_M_GankinKinto_Pri;
    }

    /**
     * 初期データの払込前残元金を取得します。
     *
     * @return 初期データの払込前残元金
     */
    public String getID_M_KashitsukeZandaka_Pri() {
        return ID_M_KashitsukeZandaka_Pri;
    }

    /**
     * 初期データの払込前残元金を設定します。
     *
     * @param ID_M_KashitsukeZandaka_Pri 初期データの払込前残元金
     */
    public void setID_M_KashitsukeZandaka_Pri(String ID_M_KashitsukeZandaka_Pri) {
        this.ID_M_KashitsukeZandaka_Pri = ID_M_KashitsukeZandaka_Pri;
    }

    /**
     * 初期データの払込期日を取得します。
     *
     * @return 初期データの払込期日
     */
    public String getID_Date_Haraikomi_Pri() {
        return ID_Date_Haraikomi_Pri;
    }

    /**
     * 初期データの払込期日を設定します。
     *
     * @param ID_Date_Haraikomi_Pri 初期データの払込期日
     */
    public void setID_Date_Haraikomi_Pri(String ID_Date_Haraikomi_Pri) {
        this.ID_Date_Haraikomi_Pri = ID_Date_Haraikomi_Pri;
    }

    /**
     * 初期データの払込額を取得します。
     *
     * @return 初期データの払込額
     */
    public String getID_M_Haraikomi_Pri() {
        return ID_M_Haraikomi_Pri;
    }

    /**
     * 初期データの払込額を設定します。
     *
     * @param ID_M_Haraikomi_Pri 初期データの払込額
     */
    public void setID_M_Haraikomi_Pri(String ID_M_Haraikomi_Pri) {
        this.ID_M_Haraikomi_Pri = ID_M_Haraikomi_Pri;
    }

    /**
     * 初期データの控除利息を取得します。
     *
     * @return 初期データの控除利息
     */
    public String getID_M_KojoRisoku_Pri() {
        return ID_M_KojoRisoku_Pri;
    }

    /**
     * 初期データの控除利息を設定します。
     *
     * @param ID_M_KojoRisoku_Pri 初期データの控除利息
     */
    public void setID_M_KojoRisoku_Pri(String ID_M_KojoRisoku_Pri) {
        this.ID_M_KojoRisoku_Pri = ID_M_KojoRisoku_Pri;
    }

    /**
     * 初期データの入金日を取得します。
     *
     * @return 初期データの入金日
     */
    public String getID_Date_Nyukin_Pri() {
        return ID_Date_Nyukin_Pri;
    }

    /**
     * 初期データの入金日を設定します。
     *
     * @param ID_Date_Nyukin_Pri 初期データの入金日
     */
    public void setID_Date_Nyukin_Pri(String ID_Date_Nyukin_Pri) {
        this.ID_Date_Nyukin_Pri = ID_Date_Nyukin_Pri;
    }

    /**
     * 初期データの約定利息を取得します。
     *
     * @return 初期データの約定利息
     */
    public String getID_M_YakujoRisoku_Pri() {
        return ID_M_YakujoRisoku_Pri;
    }

    /**
     * 初期データの約定利息を設定します。
     *
     * @param ID_M_YakujoRisoku_Pri 初期データの約定利息
     */
    public void setID_M_YakujoRisoku_Pri(String ID_M_YakujoRisoku_Pri) {
        this.ID_M_YakujoRisoku_Pri = ID_M_YakujoRisoku_Pri;
    }

    /**
     * 初期データの約定元金を取得します。
     *
     * @return 初期データの約定元金
     */
    public String getID_M_YakujoGankin_Pri() {
        return ID_M_YakujoGankin_Pri;
    }

    /**
     * 初期データの約定元金を設定します。
     *
     * @param ID_M_YakujoGankin_Pri 初期データの約定元金
     */
    public void setID_M_YakujoGankin_Pri(String ID_M_YakujoGankin_Pri) {
        this.ID_M_YakujoGankin_Pri = ID_M_YakujoGankin_Pri;
    }

    /**
     * 初期データの遅延損害金を取得します。
     *
     * @return 初期データの遅延損害金
     */
    public String getID_M_ChienSongai_Pri() {
        return ID_M_ChienSongai_Pri;
    }

    /**
     * 初期データの遅延損害金を設定します。
     *
     * @param ID_M_ChienSongai_Pri 初期データの遅延損害金
     */
    public void setID_M_ChienSongai_Pri(String ID_M_ChienSongai_Pri) {
        this.ID_M_ChienSongai_Pri = ID_M_ChienSongai_Pri;
    }

    /**
     * 初期データの違約金を取得します。
     *
     * @return 初期データの違約金
     */
    public String getID_M_Iyaku_Pri() {
        return ID_M_Iyaku_Pri;
    }

    /**
     * 初期データの違約金を設定します。
     *
     * @param ID_M_Iyaku_Pri 初期データの違約金
     */
    public void setID_M_Iyaku_Pri(String ID_M_Iyaku_Pri) {
        this.ID_M_Iyaku_Pri = ID_M_Iyaku_Pri;
    }

    /**
     * 初期データの違約金（利子軽減分）を取得します。
     *
     * @return 初期データの違約金（利子軽減分）
     */
    public String getID_M_IyakuRishikeigen_Pri() {
        return ID_M_IyakuRishikeigen_Pri;
    }

    /**
     * 初期データの違約金（利子軽減分）を設定します。
     *
     * @param ID_M_IyakuRishikeigen_Pri 初期データの違約金（利子軽減分）
     */
    public void setID_M_IyakuRishikeigen_Pri(String ID_M_IyakuRishikeigen_Pri) {
        this.ID_M_IyakuRishikeigen_Pri = ID_M_IyakuRishikeigen_Pri;
    }

    /**
     * 初期データの仮受金からの充当額を取得します。
     *
     * @return 初期データの仮受金からの充当額
     */
    public String getID_M_KariukeIppanJuto_Pri() {
        return ID_M_KariukeIppanJuto_Pri;
    }

    /**
     * 初期データの仮受金からの充当額を設定します。
     *
     * @param ID_M_KariukeIppanJuto_Pri 初期データの仮受金からの充当額
     */
    public void setID_M_KariukeIppanJuto_Pri(String ID_M_KariukeIppanJuto_Pri) {
        this.ID_M_KariukeIppanJuto_Pri = ID_M_KariukeIppanJuto_Pri;
    }

    /**
     * 初期データの差引払込額を取得します。
     *
     * @return 初期データの差引払込額
     */
    public String getID_M_SashihikiHaraikomi_Pri() {
        return ID_M_SashihikiHaraikomi_Pri;
    }

    /**
     * 初期データの差引払込額を設定します。
     *
     * @param ID_M_SashihikiHaraikomi_Pri 初期データの差引払込額
     */
    public void setID_M_SashihikiHaraikomi_Pri(String ID_M_SashihikiHaraikomi_Pri) {
        this.ID_M_SashihikiHaraikomi_Pri = ID_M_SashihikiHaraikomi_Pri;
    }

    /**
     * 初期データの払込後残元金を取得します。
     *
     * @return 初期データの払込後残元金
     */
    public String getID_M_ZangankinAfterHaraikomi_Pri() {
        return ID_M_ZangankinAfterHaraikomi_Pri;
    }

    /**
     * 初期データの払込後残元金を設定します。
     *
     * @param ID_M_ZangankinAfterHaraikomi_Pri 初期データの払込後残元金
     */
    public void setID_M_ZangankinAfterHaraikomi_Pri(String ID_M_ZangankinAfterHaraikomi_Pri) {
        this.ID_M_ZangankinAfterHaraikomi_Pri = ID_M_ZangankinAfterHaraikomi_Pri;
    }

    /**
     * 初期データの受託者勘定処理年月を取得します。
     *
     * @return 初期データの受託者勘定処理年月
     */
    public String getID_Date_Jtkshori_Pri() {
        return ID_Date_Jtkshori_Pri;
    }

    /**
     * 初期データの受託者勘定処理年月を設定します。
     *
     * @param ID_Date_Jtkshori_Pri 初期データの受託者勘定処理年月
     */
    public void setID_Date_Jtkshori_Pri(String ID_Date_Jtkshori_Pri) {
        this.ID_Date_Jtkshori_Pri = ID_Date_Jtkshori_Pri;
    }

    /**
     * 初期データの送金日を取得します。
     *
     * @return 初期データの送金日
     */
    public String getID_Date_Sokin_Pri() {
        return ID_Date_Sokin_Pri;
    }

    /**
     * 初期データの送金日を設定します。
     *
     * @param ID_Date_Sokin_Pri 初期データの送金日
     */
    public void setID_Date_Sokin_Pri(String ID_Date_Sokin_Pri) {
        this.ID_Date_Sokin_Pri = ID_Date_Sokin_Pri;
    }

    /**
     * 初期データの送金日番号を取得します。
     *
     * @return 初期データの送金日番号
     */
    public String getID_ID_Sokinbi_Pri() {
        return ID_ID_Sokinbi_Pri;
    }

    /**
     * 初期データの送金日番号を設定します。
     *
     * @param ID_ID_Sokinbi_Pri 初期データの送金日番号
     */
    public void setID_ID_Sokinbi_Pri(String ID_ID_Sokinbi_Pri) {
        this.ID_ID_Sokinbi_Pri = ID_ID_Sokinbi_Pri;
    }

    /**
     * 初期データの報告書番号を取得します。
     *
     * @return 初期データの報告書番号
     */
    public String getID_ID_Report_Pri() {
        return ID_ID_Report_Pri;
    }

    /**
     * 初期データの報告書番号を設定します。
     *
     * @param ID_ID_Report_Pri 初期データの報告書番号
     */
    public void setID_ID_Report_Pri(String ID_ID_Report_Pri) {
        this.ID_ID_Report_Pri = ID_ID_Report_Pri;
    }

    /**
     * 初期データの報告時分秒を取得します。
     *
     * @return 初期データの報告時分秒
     */
    public String getID_Time_Report_Pri() {
        return ID_Time_Report_Pri;
    }

    /**
     * 初期データの報告時分秒を設定します。
     *
     * @param ID_Time_Report_Pri 初期データの報告時分秒
     */
    public void setID_Time_Report_Pri(String ID_Time_Report_Pri) {
        this.ID_Time_Report_Pri = ID_Time_Report_Pri;
    }

    /**
     * 初期データのユーザIDを取得します。
     *
     * @return 初期データのユーザID
     */
    public String getID_User_ID_Pri() {
        return ID_User_ID_Pri;
    }

    /**
     * 初期データのユーザIDを設定します。
     *
     * @param ID_User_ID_Pri 初期データのユーザID
     */
    public void setID_User_ID_Pri(String ID_User_ID_Pri) {
        this.ID_User_ID_Pri = ID_User_ID_Pri;
    }

    /**
     * 初期データの伝送番号を取得します。
     *
     * @return 初期データの伝送番号
     */
    public String getID_ID_Denso_Pri() {
        return ID_ID_Denso_Pri;
    }

    /**
     * 初期データの伝送番号を設定します。
     *
     * @param ID_ID_Denso_Pri 初期データの伝送番号
     */
    public void setID_ID_Denso_Pri(String ID_ID_Denso_Pri) {
        this.ID_ID_Denso_Pri = ID_ID_Denso_Pri;
    }

    /**
     * 初期データのデータコードを取得します。
     *
     * @return 初期データのデータコード
     */
    public String getID_DataCode_Pri() {
        return ID_DataCode_Pri;
    }

    /**
     * 初期データのデータコードを設定します。
     *
     * @param ID_DataCode_Pri 初期データのデータコード
     */
    public void setID_DataCode_Pri(String ID_DataCode_Pri) {
        this.ID_DataCode_Pri = ID_DataCode_Pri;
    }

    /**
     * 初期データの残高件数を取得します。
     *
     * @return 初期データの残高件数
     */
    public String getID_Count_Zandaka_Pri() {
        return ID_Count_Zandaka_Pri;
    }

    /**
     * 初期データの残高件数を設定します。
     *
     * @param ID_Count_Zandaka_Pri 初期データの残高件数
     */
    public void setID_Count_Zandaka_Pri(String ID_Count_Zandaka_Pri) {
        this.ID_Count_Zandaka_Pri = ID_Count_Zandaka_Pri;
    }

    /**
     * 初期データの履歴番号を取得します。
     *
     * @return 初期データの履歴番号
     */
    public String getID_ID_History_Pri() {
        return ID_ID_History_Pri;
    }

    /**
     * 初期データの履歴番号を設定します。
     *
     * @param ID_ID_History_Pri 初期データの履歴番号
     */
    public void setID_ID_History_Pri(String ID_ID_History_Pri) {
        this.ID_ID_History_Pri = ID_ID_History_Pri;
    }

    /**
     * 初期データのステータスを取得します。
     *
     * @return 初期データのステータス
     */
    public String getID_Status_Pri() {
        return ID_Status_Pri;
    }

    /**
     * 初期データのステータスを設定します。
     *
     * @param ID_Status_Pri 初期データのステータス
     */
    public void setID_Status_Pri(String ID_Status_Pri) {
        this.ID_Status_Pri = ID_Status_Pri;
    }

    /**
     * 初期データの処理種別を取得します。
     *
     * @return 初期データの処理種別
     */
    public String getID_Type_Process_Pri() {
        return ID_Type_Process_Pri;
    }

    /**
     * 初期データの処理種別を設定します。
     *
     * @param ID_Type_Process_Pri 初期データの処理種別
     */
    public void setID_Type_Process_Pri(String ID_Type_Process_Pri) {
        this.ID_Type_Process_Pri = ID_Type_Process_Pri;
    }

    /**
     * 初期データの取消済フラグを取得します。
     *
     * @return 初期データの取消済フラグ
     */
    public String getID_Flag_Torikeshizumi_Pri() {
        return ID_Flag_Torikeshizumi_Pri;
    }

    /**
     * 初期データの取消済フラグを設定します。
     *
     * @param ID_Flag_Torikeshizumi_Pri 初期データの取消済フラグ
     */
    public void setID_Flag_Torikeshizumi_Pri(String ID_Flag_Torikeshizumi_Pri) {
        this.ID_Flag_Torikeshizumi_Pri = ID_Flag_Torikeshizumi_Pri;
    }

    /**
     * 初期データのエラー番号を取得します。
     *
     * @return 初期データのエラー番号
     */
    public String getID_Code_Error_Pri() {
        return ID_Code_Error_Pri;
    }

    /**
     * 初期データのエラー番号を設定します。
     *
     * @param ID_Code_Error_Pri 初期データのエラー番号
     */
    public void setID_Code_Error_Pri(String ID_Code_Error_Pri) {
        this.ID_Code_Error_Pri = ID_Code_Error_Pri;
    }

    /**
     * 初期データのエラーメッセージを取得します。
     *
     * @return 初期データのエラーメッセージ
     */
    public String getID_ErrorMessage_Pri() {
        return ID_ErrorMessage_Pri;
    }

    /**
     * 初期データのエラーメッセージを設定します。
     *
     * @param ID_ErrorMessage_Pri 初期データのエラーメッセージ
     */
    public void setID_ErrorMessage_Pri(String ID_ErrorMessage_Pri) {
        this.ID_ErrorMessage_Pri = ID_ErrorMessage_Pri;
    }

    /**
     * 初期データの退避貸付金残高を取得します。
     *
     * @return 初期データの退避貸付金残高
     */
    public String getID_Keep_M_KashitsukeZan_Pri() {
        return ID_Keep_M_KashitsukeZan_Pri;
    }

    /**
     * 初期データの退避貸付金残高を設定します。
     *
     * @param ID_Keep_M_KashitsukeZan_Pri 初期データの退避貸付金残高
     */
    public void setID_Keep_M_KashitsukeZan_Pri(String ID_Keep_M_KashitsukeZan_Pri) {
        this.ID_Keep_M_KashitsukeZan_Pri = ID_Keep_M_KashitsukeZan_Pri;
    }

    /**
     * 初期データの退避約定元金を取得します。
     *
     * @return 初期データの退避約定元金
     */
    public String getID_Keep_M_YakujoGankin_Pri() {
        return ID_Keep_M_YakujoGankin_Pri;
    }

    /**
     * 初期データの退避約定元金を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Pri 初期データの退避約定元金
     */
    public void setID_Keep_M_YakujoGankin_Pri(String ID_Keep_M_YakujoGankin_Pri) {
        this.ID_Keep_M_YakujoGankin_Pri = ID_Keep_M_YakujoGankin_Pri;
    }

    /**
     * 初期データの退避約定利息を取得します。
     *
     * @return 初期データの退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku_Pri() {
        return ID_Keep_M_YakujoRisoku_Pri;
    }

    /**
     * 初期データの退避約定利息を設定します。
     *
     * @param ID_Keep_M_YakujoRisoku_Pri 初期データの退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku_Pri(String ID_Keep_M_YakujoRisoku_Pri) {
        this.ID_Keep_M_YakujoRisoku_Pri = ID_Keep_M_YakujoRisoku_Pri;
    }

    /**
     * 初期データの退避償還期限を取得します。
     *
     * @return 初期データの退避償還期限
     */
    public String getID_Keep_Date_ShokanKigen_Pri() {
        return ID_Keep_Date_ShokanKigen_Pri;
    }

    /**
     * 初期データの退避償還期限を設定します。
     *
     * @param ID_Keep_Date_ShokanKigen_Pri 初期データの退避償還期限
     */
    public void setID_Keep_Date_ShokanKigen_Pri(String ID_Keep_Date_ShokanKigen_Pri) {
        this.ID_Keep_Date_ShokanKigen_Pri = ID_Keep_Date_ShokanKigen_Pri;
    }

    /**
     * 初期データの債権管理番号を取得します。
     *
     * @return 初期データの債権管理番号
     */
    public String getID_ID_Credit_Pri() {
        return ID_ID_Credit_Pri;
    }

    /**
     * 初期データの債権管理番号を設定します。
     *
     * @param ID_ID_Credit_Pri 初期データの債権管理番号
     */
    public void setID_ID_Credit_Pri(String ID_ID_Credit_Pri) {
        this.ID_ID_Credit_Pri = ID_ID_Credit_Pri;
    }

    /**
     * 初期データの顧客コードを取得します。
     *
     * @return 初期データの顧客コード
     */
    public String getID_Code_Customer_Pri() {
        return ID_Code_Customer_Pri;
    }

    /**
     * 初期データの顧客コードを設定します。
     *
     * @param ID_Code_Customer_Pri 初期データの顧客コード
     */
    public void setID_Code_Customer_Pri(String ID_Code_Customer_Pri) {
        this.ID_Code_Customer_Pri = ID_Code_Customer_Pri;
    }

    /**
     * 初期データの充当順序変更区分を取得します。
     *
     * @return 初期データの充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko_Pri() {
        return ID_Kubun_JutoJunjoHenko_Pri;
    }

    /**
     * 初期データの充当順序変更区分を設定します。
     *
     * @param ID_Kubun_JutoJunjoHenko_Pri 初期データの充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko_Pri(String ID_Kubun_JutoJunjoHenko_Pri) {
        this.ID_Kubun_JutoJunjoHenko_Pri = ID_Kubun_JutoJunjoHenko_Pri;
    }

    /**
     * 初期データの請求データの退避任意繰償還利息を取得します。
     *
     * @return 初期データの請求データの退避任意繰償還利息
     */
    public String getID_Keep_Seikyu_M_NinKuriRisoku_Pri() {
        return ID_Keep_Seikyu_M_NinKuriRisoku_Pri;
    }

    /**
     * 初期データの請求データの退避任意繰償還利息を設定します。
     *
     * @param ID_Keep_Seikyu_M_NinKuriRisoku_Pri 初期データの請求データの退避任意繰償還利息
     */
    public void setID_Keep_Seikyu_M_NinKuriRisoku_Pri(String ID_Keep_Seikyu_M_NinKuriRisoku_Pri) {
        this.ID_Keep_Seikyu_M_NinKuriRisoku_Pri = ID_Keep_Seikyu_M_NinKuriRisoku_Pri;
    }

    /**
     * 初期データの請求データの退避請求繰償還利息を取得します。
     *
     * @return 初期データの請求データの退避請求繰償還利息
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku_Pri() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku_Pri;
    }

    /**
     * 初期データの請求データの退避請求繰償還利息を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriRisoku_Pri 初期データの請求データの退避請求繰償還利息
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku_Pri(String ID_Keep_Seikyu_M_SeiKuriRisoku_Pri) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku_Pri = ID_Keep_Seikyu_M_SeiKuriRisoku_Pri;
    }

    /**
     * 初期データの請求データの退避請求繰償還元金を取得します。
     *
     * @return 初期データの請求データの退避請求繰償還元金
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin_Pri() {
        return ID_Keep_Seikyu_M_SeiKuriGankin_Pri;
    }

    /**
     * 初期データの請求データの退避請求繰償還元金を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriGankin_Pri 初期データの請求データの退避請求繰償還元金
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin_Pri(String ID_Keep_Seikyu_M_SeiKuriGankin_Pri) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin_Pri = ID_Keep_Seikyu_M_SeiKuriGankin_Pri;
    }

    /**
     * 初期データの約定データの退避請求繰償還利息を取得します。
     *
     * @return 初期データの約定データの退避請求繰償還利息
     */
    public String getID_Keep_Yakujo_M_SeiKuriRisoku_Pri() {
        return ID_Keep_Yakujo_M_SeiKuriRisoku_Pri;
    }

    /**
     * 初期データの約定データの退避請求繰償還利息を設定します。
     *
     * @param ID_Keep_Yakujo_M_SeiKuriRisoku_Pri 初期データの約定データの退避請求繰償還利息
     */
    public void setID_Keep_Yakujo_M_SeiKuriRisoku_Pri(String ID_Keep_Yakujo_M_SeiKuriRisoku_Pri) {
        this.ID_Keep_Yakujo_M_SeiKuriRisoku_Pri = ID_Keep_Yakujo_M_SeiKuriRisoku_Pri;
    }

    /**
     * 初期データの元利金計を取得します。
     *
     * @return 初期データの元利金計
     */
    public String getID_M_GanrikinKei_Pri() {
        return ID_M_GanrikinKei_Pri;
    }

    /**
     * 初期データの元利金計を設定します。
     *
     * @param ID_M_GanrikinKei_Pri 初期データの元利金計
     */
    public void setID_M_GanrikinKei_Pri(String ID_M_GanrikinKei_Pri) {
        this.ID_M_GanrikinKei_Pri = ID_M_GanrikinKei_Pri;
    }

    /**
     * 初期データの最新データ更新日付を取得します。
     *
     * @return 初期データの最新データ更新日付
     */
    public String getID_Data_LastUpDate_Pri() {
        return ID_Data_LastUpDate_Pri;
    }

    /**
     * 初期データの最新データ更新日付を設定します。
     *
     * @param ID_Data_LastUpDate_Pri 初期データの最新データ更新日付
     */
    public void setID_Data_LastUpDate_Pri(String ID_Data_LastUpDate_Pri) {
        this.ID_Data_LastUpDate_Pri = ID_Data_LastUpDate_Pri;
    }

    /**
     * 初期データの退避履歴番号を取得します。
     *
     * @return 初期データの退避履歴番号
     */
    public String getID_Keep_ID_History_Pri() {
        return ID_Keep_ID_History_Pri;
    }

    /**
     * 初期データの退避履歴番号を設定します。
     *
     * @param ID_Keep_ID_History_Pri 初期データの退避履歴番号
     */
    public void setID_Keep_ID_History_Pri(String ID_Keep_ID_History_Pri) {
        this.ID_Keep_ID_History_Pri = ID_Keep_ID_History_Pri;
    }

    /**
     * 初期データの扱店別稟議データより取得した償還期限年月を取得します。
     *
     * @return 初期データの扱店別稟議データより取得した償還期限年月
     */
    public String getID_Date_ShokanKigen_aRingi_Pri() {
        return ID_Date_ShokanKigen_aRingi_Pri;
    }

    /**
     * 初期データの扱店別稟議データより取得した償還期限年月を設定します。
     *
     * @param ID_Date_ShokanKigen_aRingi_Pri 初期データの扱店別稟議データより取得した償還期限年月
     */
    public void setID_Date_ShokanKigen_aRingi_Pri(String ID_Date_ShokanKigen_aRingi_Pri) {
        this.ID_Date_ShokanKigen_aRingi_Pri = ID_Date_ShokanKigen_aRingi_Pri;
    }

    /**
     * 初期データの扱店別稟議データより取得した貸付残高を取得します。
     *
     * @return 初期データの扱店別稟議データより取得した貸付残高
     */
    public String getID_M_KashitsukeZandaka_aRingi_Pri() {
        return ID_M_KashitsukeZandaka_aRingi_Pri;
    }

    /**
     * 初期データの扱店別稟議データより取得した貸付残高を設定します。
     *
     * @param ID_M_KashitsukeZandaka_aRingi_Pri 初期データの扱店別稟議データより取得した貸付残高
     */
    public void setID_M_KashitsukeZandaka_aRingi_Pri(String ID_M_KashitsukeZandaka_aRingi_Pri) {
        this.ID_M_KashitsukeZandaka_aRingi_Pri = ID_M_KashitsukeZandaka_aRingi_Pri;
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
     * @param ID_Keep_M_YakujoGankin_Red 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku_Red(String ID_Keep_M_YakujoRisoku_Red) {
        this.ID_Keep_M_YakujoRisoku_Red = ID_Keep_M_YakujoRisoku_Red;
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
     * @param ID_Keep_M_YakujoGankin_Red エラーメッセージ
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
     * @param ID_Keep_M_YakujoGankin_Red 退避償還期限
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
     * @param ID_Keep_M_YakujoGankin_Red 扱店別稟議データの貸付残高
     */
    public void setID_M_KashitsukeZandaka_aRingi_Red(String ID_M_KashitsukeZandaka_aRingi_Red) {
        // this.ID_Keep_M_YakujoGankin_Red = ID_M_KashitsukeZandaka_aRingi_Red;
        this.ID_M_KashitsukeZandaka_aRingi_Red = ID_M_KashitsukeZandaka_aRingi_Red;
    }

    /**
     * 扱店別稟議データの償還期限を取得します。
     *
     * @return 扱店別稟議データの償還期限
     */
    public String getID_Date_ShokanKigen_aRingi_Red() {
        return ID_Date_ShokanKigen_aRingi_Red;
    }

    /**
     * 扱店別稟議データの償還期限を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 扱店別稟議データの償還期限
     */
    public void setID_Date_ShokanKigen_aRingi_Red(String ID_Date_ShokanKigen_aRingi_Red) {
        this.ID_Date_ShokanKigen_aRingi_Red = ID_Date_ShokanKigen_aRingi_Red;
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
     * @param ID_Keep_M_YakujoGankin_Red 請求データの約定利息
     */
    public void setID_M_YakujoRisoku_Seikyu_Red(String ID_M_YakujoRisoku_Seikyu_Red) {
        this.ID_M_YakujoRisoku_Seikyu_Red = ID_M_YakujoRisoku_Seikyu_Red;
    }

    /**
     * 充当順序変更区分を取得します。
     *
     * @return 充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko_RED() {
        return ID_Kubun_JutoJunjoHenko_RED;
    }

    /**
     * 充当順序変更区分を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko_RED(String ID_Kubun_JutoJunjoHenko_RED) {
        this.ID_Kubun_JutoJunjoHenko_RED = ID_Kubun_JutoJunjoHenko_RED;
    }

    /**
     * 請求データの退避任意繰上償還利息を取得します。
     *
     * @return 請求データの退避任意繰上償還利息
     */
    public String getID_Keep_Seikyu_M_NinKuriRisoku_Red() {
        return ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの退避任意繰上償還利息を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 請求データの退避任意繰上償還利息
     */
    public void setID_Keep_Seikyu_M_NinKuriRisoku_Red(String ID_Keep_Seikyu_M_NinKuriRisoku_Red) {
        this.ID_Keep_Seikyu_M_NinKuriRisoku_Red = ID_Keep_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰上償還利息を取得します。
     *
     * @return 請求データの退避請求繰上償還利息
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku_Red() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰上償還利息を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 請求データの退避請求繰上償還利息
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku_Red(String ID_Keep_Seikyu_M_SeiKuriRisoku_Red) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku_Red = ID_Keep_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの退避請求繰上償還元金を取得します。
     *
     * @return 請求データの退避請求繰上償還元金
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin_Red() {
        return ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 請求データの退避請求繰上償還元金を設定します。
     *
     * @param ID_Keep_M_YakujoGankin_Red 請求データの退避請求繰上償還元金
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin_Red(String ID_Keep_Seikyu_M_SeiKuriGankin_Red) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin_Red = ID_Keep_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 約定データの退避請求繰上償還利息を取得します。
     *
     * @return 約定データの退避請求繰上償還利息
     */
    public String getID_ID_Keep_Yakujo_M_SeiKuriRisoku_Red() {
        return ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
    }

    /**
     * 約定データの退避請求繰上償還利息を設定します。
     *
     * @param ID_Keep_Yakujo_M_SeiKuriRisoku_Red 約定データの退避請求繰上償還利息
     */
    public void setID_Keep_Yakujo_M_SeiKuriRisoku_Red(String ID_Keep_Yakujo_M_SeiKuriRisoku_Red) {
        this.ID_Keep_Yakujo_M_SeiKuriRisoku_Red = ID_Keep_Yakujo_M_SeiKuriRisoku_Red;
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
     * 扱店別稟議データの償還期限(修正)を取得します。
     *
     * @return 扱店別稟議データの償還期限(修正)
     */
    public String getID_Date_ShokanKigen_aRingi() {
        return ID_Date_ShokanKigen_aRingi;
    }

    /**
     * 扱店別稟議データの償還期限(修正)を設定します。
     *
     * @param ID_Date_ShokanKigen_aRingi 扱店別稟議データの償還期限(修正)
     */
    public void setID_Date_ShokanKigen_aRingi(String ID_Date_ShokanKigen_aRingi) {
        this.ID_Date_ShokanKigen_aRingi = ID_Date_ShokanKigen_aRingi;
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
     * 請求データの退避任意繰上償還利息(修正)を取得します。
     *
     * @return 請求データの退避任意繰上償還利息(修正)
     */
    public String getID_Keep_Seikyu_M_NinKuriRisoku() {
        return ID_Keep_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの退避任意繰上償還利息(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_NinKuriRisoku 請求データの退避任意繰上償還利息(修正)
     */
    public void setID_Keep_Seikyu_M_NinKuriRisoku(String ID_Keep_Seikyu_M_NinKuriRisoku) {
        this.ID_Keep_Seikyu_M_NinKuriRisoku = ID_Keep_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの退避請求繰上償還利息(修正)を取得します。
     *
     * @return 請求データの退避請求繰上償還利息(修正)
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの退避請求繰上償還利息(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriRisoku 請求データの退避請求繰上償還利息(修正)
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku(String ID_Keep_Seikyu_M_SeiKuriRisoku) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku = ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの退避請求繰上償還元金(修正)を取得します。
     *
     * @return 請求データの退避請求繰上償還元金(修正)
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin() {
        return ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 請求データの退避請求繰上償還元金(修正)を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriGankin 請求データの退避請求繰上償還元金(修正)
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin(String ID_Keep_Seikyu_M_SeiKuriGankin) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin = ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 約定データの退避請求繰上償還利息(修正)を取得します。
     *
     * @return 約定データの退避請求繰上償還利息(修正)
     */
    public String getID_Keep_Yakujo_M_SeiKuriRisoku() {
        return ID_Keep_Yakujo_M_SeiKuriRisoku;
    }

    /**
     * 約定データの退避請求繰上償還利息(修正)を設定します。
     *
     * @param ID_Keep_Yakujo_M_SeiKuriRisoku 約定データの退避請求繰上償還利息(修正)
     */
    public void setID_Keep_Yakujo_M_SeiKuriRisoku(String ID_Keep_Yakujo_M_SeiKuriRisoku) {
        this.ID_Keep_Yakujo_M_SeiKuriRisoku = ID_Keep_Yakujo_M_SeiKuriRisoku;
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
     * @param ModeType モードタイプ
     */
    public void setModeType(String ModeType) {
        this.ModeType = ModeType;
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
     * @param ID_Keep_ID_History 報告年月日
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
     * @param ID_Keep_ID_History 報告時分秒(修正)
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
     * 請求データの任意繰上償還利息を取得します。
     *
     * @return 請求データの任意繰上償還利息
     */
    public String getID_Seikyu_M_NinKuriRisoku_Red() {
        return ID_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの任意繰上償還利息を設定します。
     *
     * @param ID_Seikyu_M_NinKuriRisoku_Red 請求データの任意繰上償還利息
     */
    public void setID_Seikyu_M_NinKuriRisoku_Red(String ID_Seikyu_M_NinKuriRisoku_Red) {
        this.ID_Seikyu_M_NinKuriRisoku_Red = ID_Seikyu_M_NinKuriRisoku_Red;
    }

    /**
     * 請求データの請求繰上償還利息を取得します。
     *
     * @return 請求データの請求繰上償還利息
     */
    public String getID_Seikyu_M_SeiKuriRisoku_Red() {
        return ID_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの請求繰上償還利息を設定します。
     *
     * @param ID_ID_Denso 請求データの請求繰上償還利息
     */
    public void setID_Seikyu_M_SeiKuriRisoku_Red(String ID_Seikyu_M_SeiKuriRisoku_Red) {
        this.ID_Seikyu_M_SeiKuriRisoku_Red = ID_Seikyu_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの請求繰上償還元金を取得します。
     *
     * @return 請求データの請求繰上償還元金
     */
    public String getID_Seikyu_M_SeiKuriGankin_Red() {
        return ID_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 請求データの請求繰上償還元金を設定します。
     *
     * @param ID_ID_Denso 請求データの請求繰上償還元金
     */
    public void setID_Seikyu_M_SeiKuriGankin_Red(String ID_Seikyu_M_SeiKuriGankin_Red) {
        this.ID_Seikyu_M_SeiKuriGankin_Red = ID_Seikyu_M_SeiKuriGankin_Red;
    }

    /**
     * 約定データの請求繰上償還利息を取得します。
     *
     * @return 約定データの請求繰上償還利息
     */
    public String getID_Yakujo_M_SeiKuriRisoku_Red() {
        return ID_Yakujo_M_SeiKuriRisoku_Red;
    }

    /**
     * 約定データの請求繰上償還利息を設定します。
     *
     * @param ID_ID_Denso 約定データの請求繰上償還利息
     */
    public void setID_Yakujo_M_SeiKuriRisoku_Red(String ID_Yakujo_M_SeiKuriRisoku_Red) {
        this.ID_Yakujo_M_SeiKuriRisoku_Red = ID_Yakujo_M_SeiKuriRisoku_Red;
    }

    /**
     * 請求データの任意繰上償還利息(修正)を取得します。
     *
     * @return 請求データの任意繰上償還利息(修正)
     */
    public String getID_Seikyu_M_NinKuriRisoku() {
        return ID_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの任意繰上償還利息(修正)を設定します。
     *
     * @param ID_ID_Denso 請求データの任意繰上償還利息(修正)
     */
    public void setID_Seikyu_M_NinKuriRisoku(String ID_Seikyu_M_NinKuriRisoku) {
        this.ID_Seikyu_M_NinKuriRisoku = ID_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの請求繰上償還利息(修正)を取得します。
     *
     * @return 請求データの請求繰上償還利息(修正)
     */
    public String getID_Seikyu_M_SeiKuriRisoku() {
        return ID_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの請求繰上償還利息(修正)を設定します。
     *
     * @param ID_Seikyu_M_SeiKuriRisoku 請求データの請求繰上償還利息(修正)
     */
    public void setID_Seikyu_M_SeiKuriRisoku(String ID_Seikyu_M_SeiKuriRisoku) {
        this.ID_Seikyu_M_SeiKuriRisoku = ID_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの請求繰上償還元金(修正)を取得します。
     *
     * @return 請求データの請求繰上償還元金(修正)
     */
    public String getID_Seikyu_M_SeiKuriGankin() {
        return ID_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 請求データの請求繰上償還元金(修正)を設定します。
     *
     * @param ID_ID_Denso 請求データの請求繰上償還元金(修正)
     */
    public void setID_Seikyu_M_SeiKuriGankin(String ID_Seikyu_M_SeiKuriGankin) {
        this.ID_Seikyu_M_SeiKuriGankin = ID_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 約定データの請求繰上償還利息(修正)を取得します。
     *
     * @return 約定データの請求繰上償還利息(修正)
     */
    public String getID_Yakujo_M_SeiKuriRisoku() {
        return ID_Yakujo_M_SeiKuriRisoku;
    }

    /**
     * 約定データの請求繰上償還利息(修正)を設定します。
     *
     * @param ID_Yakujo_M_SeiKuriRisoku 約定データの請求繰上償還利息(修正)
     */
    public void setID_Yakujo_M_SeiKuriRisoku(String ID_Yakujo_M_SeiKuriRisoku) {
        this.ID_Yakujo_M_SeiKuriRisoku = ID_Yakujo_M_SeiKuriRisoku;
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

}