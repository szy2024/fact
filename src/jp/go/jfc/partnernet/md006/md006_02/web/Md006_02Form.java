//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_02.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd006_02のFormクラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
public class Md006_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラー */
    private String lblError;
    /** メッセージ */
    private String lblBack;
    /** 報告年月日 */
    private String lblID_Date_Report;
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
    private String lblID_Kubun_HoshikiShikin_Red;
    /** 番号 */
    private String lblID_ID_Ringi_Red;
    /** 枝番 */
    private String lblID_ID_RingiBranch_Red;
    /** 入金日 */
    private String lblID_Date_Nyukin_Red;
    /** 立替金利息(円) */
    private String lblID_M_TatekaeRisoku_Red;
    /** 立替金(円) */
    private String lblID_M_Tatekae_Red;
    /** 仮受金(一般口)からの充当額(円) */
    private String lblID_M_KariukeIppanJuto_Red;
    /** 立替金の種類 */
    private String lblID_Code_TatekaekinShurui_Red;
    /** 公庫立替日 */
    private String lblID_Date_KoukoTatekae_Red;
    /** 計(円) */
    private String lblID_M_Kei_Red;
    /** 送金額(円) */
    private String lblID_M_Sokin_Red;
    /** 受入後立替金残高(円) */
    private String lblID_M_TatekaeZanAfterUkeire_Red;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori_Red;
    /** 送金年月日 */
    private String lblID_Date_Sokin_Red;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi_Red;
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
    private String lblID_Kubun_HoshikiShikin;
    /** 番号（修正） */
    private String lblID_ID_Ringi;
    /** 枝番（修正） */
    private String lblID_ID_RingiBranch;
    /** 入金日（修正） */
    private String lblID_Date_Nyukin;
    /** 立替金利息(円)（修正） */
    private String lblID_M_TatekaeRisoku;
    /** 立替金(円)（修正） */
    private String lblID_M_Tatekae;
    /** 仮受金(一般口)からの充当額(円)（修正） */
    private String lblID_M_KariukeIppanJuto;
    /** 立替金の種類（修正） */
    private String lblID_Code_TatekaekinShurui;
    /** 公庫立替日（修正） */
    private String lblID_Date_KoukoTatekae;
    /** 計(円)（修正） */
    private String lblID_M_Kei;
    /** 送金額(円)（修正） */
    private String lblID_M_Sokin;
    /** 受入後立替金残高(円)（修正） */
    private String lblID_M_TatekaeZanAfterUkeire;
    /** 受託者勘定処理年月（修正） */
    private String lblID_Date_Jtkshori;
    /** 送金年月日（修正） */
    private String lblID_Date_Sokin;
    /** 送金日番号（修正） */
    private String lblID_ID_Sokinbi;
    /** 処理モード */
    private String ProcessMode;
    /** 入力受託者勘定処理年月（元号） */
    private String ID_Date_Jtkshori_Gengou_Red;
    /** 入力受託者勘定処理年月（年） */
    private String ID_Date_Jtkshori_Year_Red;
    /** 入力受託者勘定処理年月（月） */
    private String ID_Date_Jtkshori_Month_Red;
    /** 入力受託者勘定処理年月（元号）（修正） */
    private String ID_Date_Jtkshori_Gengou;
    /** 入力受託者勘定処理年月（年）（修正） */
    private String ID_Date_Jtkshori_Year;
    /** 入力受託者勘定処理年月（月）（修正） */
    private String ID_Date_Jtkshori_Month;
    /** 入力入金日（元号）（修正） */
    private String ID_Date_Nyukin_Gengou;
    /** 入力入金日（年）（修正） */
    private String ID_Date_Nyukin_Year;
    /** 入力入金日（月）（修正） */
    private String ID_Date_Nyukin_Month;
    /** 入力入金日（日）（修正） */
    private String ID_Date_Nyukin_Day;
    /** 入力送金年月日（元号）（修正） */
    private String ID_Date_Sokin_Gengou;
    /** 入力送金年月日（年）（修正） */
    private String ID_Date_Sokin_Year;
    /** 入力送金年月日（月）（修正） */
    private String ID_Date_Sokin_Month;
    /** 入力送金年月日（日）（修正） */
    private String ID_Date_Sokin_Day;
    /** 報告書番号（非表示） */
    private String ID_ID_Report;
    /** 報告時分秒（非表示） */
    private String ID_Time_Report;
    /** ユーザID（非表示） */
    private String ID_UserID;
    /** 伝送番号（非表示） */
    private String ID_ID_Denso_Red;
    /** データコード（非表示） */
    private String ID_DataCode_Red;
    /** 履歴番号（非表示） */
    private String ID_ID_History_Red;
    /** ステータス（値）（非表示） */
    private String ID_Status_Red;
    /** 処理種別（非表示） */
    private String ID_Type_Process_Red;
    /** 取消済みフラグ（非表示） */
    private String ID_Flag_Torikeshizumi_Red;
    /** 債権管理番号（非表示） */
    private String ID_ID_Credit_Red;
    /** 退避履歴番号（非表示） */
    private String ID_Keep_ID_History_Red;
    /** 退避実行済みフラグ（非表示） */
    private String ID_Keep_Flag_Kj_Red;
    /** 退避受入後立替金残高（非表示） */
    private String ID_Keep_M_TatekaeZanAfterUkeire_Red;
    /** 最新更新日時（非表示） */
    private String ID_Data_LastUpDate_Red;
    /** 仮受仮払番号（非表示） */
    private String ID_ID_Karibarai_Red;
    /** 仮受仮払年月日（非表示） */
    private String ID_Date_Karibarai_Red;
    /** 本支店コード（非表示） */
    private String ID_Code_HonShiten_Red;
    /** 仮受仮払精算後残高（非表示） */
    private String ID_M_KaribaraiZanAfterSeisan_Red;
    /** 伝送番号（非表示）（修正） */
    private String ID_ID_Denso;
    /** データコード（非表示）（修正） */
    private String ID_DataCode;
    /** 履歴番号（非表示）（修正） */
    private String ID_ID_History;
    /** ステータス（値）（非表示）（修正） */
    private String ID_Status;
    /** 処理種別（非表示）（修正） */
    private String ID_Type_Process;
    /** 取消済みフラグ（非表示）（修正） */
    private String ID_Flag_Torikeshizumi;
    /** 債権管理番号（非表示）（修正） */
    private String ID_ID_Credit;
    /** 退避履歴番号（非表示）（修正） */
    private String ID_Keep_ID_History;
    /** 退避実行済みフラグ（非表示）（修正） */
    private String ID_Keep_Flag_Kj;
    /** 退避受入後立替金残高（非表示）（修正） */
    private String ID_Keep_M_TatekaeZanAfterUkeire;
    /** 最新更新日時（非表示）（修正） */
    private String ID_Data_LastUpDate;
    /** 仮受仮払番号（非表示）（修正） */
    private String ID_ID_Karibarai;
    /** 仮受仮払年月日（非表示）（修正） */
    private String ID_Date_Karibarai;
    /** 本支店コード（非表示）（修正） */
    private String ID_Code_HonShiten;
    /** 仮受仮払精算後残高（非表示）（修正） */
    private String ID_M_KaribaraiZanAfterSeisan;
    /** 赤データ入力領域タイトル */
    private String redAreaTitle;
    /** 赤データ入力領域 */
    private String redArea;
    /** 黒データ入力領域タイトル */
    private String blackAreaTitle;
    /** 黒データ入力領域 */
    private String blackArea;

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーを設定します。
     * @param lblError エラー
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblBack() {
        return lblBack;
    }

    /**
     * エラーを設定します。
     * @param lblError エラー
     */
    public void setLblBack(String lblBack) {
        this.lblBack = lblBack;
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getLblID_Name_Customer_Red() {
        return lblID_Name_Customer_Red;
    }

    /**
     * 顧客名を設定します。
     * @param lblID_Name_Customer_Red 顧客名
     */
    public void setLblID_Name_Customer_Red(String lblID_Name_Customer_Red) {
        this.lblID_Name_Customer_Red = lblID_Name_Customer_Red;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization_Red() {
        return lblID_Name_Organization_Red;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization_Red 扱店名
     */
    public void setLblID_Name_Organization_Red(String lblID_Name_Organization_Red) {
        this.lblID_Name_Organization_Red = lblID_Name_Organization_Red;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getLblID_Code_KoukoShiten_Red() {
        return lblID_Code_KoukoShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_KoukoShiten_Red 公庫支店
     */
    public void setLblID_Code_KoukoShiten_Red(String lblID_Code_KoukoShiten_Red) {
        this.lblID_Code_KoukoShiten_Red = lblID_Code_KoukoShiten_Red;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization_Red() {
        return lblID_Code_Organization_Red;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization_Red 扱店
     */
    public void setLblID_Code_Organization_Red(String lblID_Code_Organization_Red) {
        this.lblID_Code_Organization_Red = lblID_Code_Organization_Red;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo_Red() {
        return lblID_Code_Tenpo_Red;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo_Red 店舗
     */
    public void setLblID_Code_Tenpo_Red(String lblID_Code_Tenpo_Red) {
        this.lblID_Code_Tenpo_Red = lblID_Code_Tenpo_Red;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getLblID_Year_Red() {
        return lblID_Year_Red;
    }

    /**
     * 年度を設定します。
     * @param lblID_Year_Red 年度
     */
    public void setLblID_Year_Red(String lblID_Year_Red) {
        this.lblID_Year_Red = lblID_Year_Red;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getLblID_Kubun_HoshikiShikin_Red() {
        return lblID_Kubun_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Kubun_HoshikiShikin_Red 方式資金
     */
    public void setLblID_Kubun_HoshikiShikin_Red(String lblID_Kubun_HoshikiShikin_Red) {
        this.lblID_Kubun_HoshikiShikin_Red = lblID_Kubun_HoshikiShikin_Red;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getLblID_ID_Ringi_Red() {
        return lblID_ID_Ringi_Red;
    }

    /**
     * 番号を設定します。
     * @param lblID_ID_Ringi_Red 番号
     */
    public void setLblID_ID_Ringi_Red(String lblID_ID_Ringi_Red) {
        this.lblID_ID_Ringi_Red = lblID_ID_Ringi_Red;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch_Red() {
        return lblID_ID_RingiBranch_Red;
    }

    /**
     * 枝番を設定します。
     * @param lblID_ID_RingiBranch_Red 枝番
     */
    public void setLblID_ID_RingiBranch_Red(String lblID_ID_RingiBranch_Red) {
        this.lblID_ID_RingiBranch_Red = lblID_ID_RingiBranch_Red;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getLblID_Date_Nyukin_Red() {
        return lblID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     * @param lblID_Date_Nyukin_Red 入金日
     */
    public void setLblID_Date_Nyukin_Red(String lblID_Date_Nyukin_Red) {
        this.lblID_Date_Nyukin_Red = lblID_Date_Nyukin_Red;
    }

    /**
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public String getLblID_M_TatekaeRisoku_Red() {
        return lblID_M_TatekaeRisoku_Red;
    }

    /**
     * 立替金利息(円)を設定します。
     * @param lblID_M_TatekaeRisoku_Red 立替金利息(円)
     */
    public void setLblID_M_TatekaeRisoku_Red(String lblID_M_TatekaeRisoku_Red) {
        this.lblID_M_TatekaeRisoku_Red = lblID_M_TatekaeRisoku_Red;
    }

    /**
     * 立替金(円)を取得します。
     * @return 立替金(円)
     */
    public String getLblID_M_Tatekae_Red() {
        return lblID_M_Tatekae_Red;
    }

    /**
     * 立替金(円)を設定します。
     * @param lblID_M_Tatekae_Red 立替金(円)
     */
    public void setLblID_M_Tatekae_Red(String lblID_M_Tatekae_Red) {
        this.lblID_M_Tatekae_Red = lblID_M_Tatekae_Red;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     * @return 仮受金(一般口)からの充当額(円)
     */
    public String getLblID_M_KariukeIppanJuto_Red() {
        return lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     * @param lblID_M_KariukeIppanJuto_Red 仮受金(一般口)からの充当額(円)
     */
    public void setLblID_M_KariukeIppanJuto_Red(String lblID_M_KariukeIppanJuto_Red) {
        this.lblID_M_KariukeIppanJuto_Red = lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getLblID_Code_TatekaekinShurui_Red() {
        return lblID_Code_TatekaekinShurui_Red;
    }

    /**
     * 立替金の種類を設定します。
     * @param lblID_Code_TatekaekinShurui_Red 立替金の種類
     */
    public void setLblID_Code_TatekaekinShurui_Red(String lblID_Code_TatekaekinShurui_Red) {
        this.lblID_Code_TatekaekinShurui_Red = lblID_Code_TatekaekinShurui_Red;
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getLblID_Date_KoukoTatekae_Red() {
        return lblID_Date_KoukoTatekae_Red;
    }

    /**
     * 公庫立替日を設定します。
     * @param lblID_Date_KoukoTatekae_Red 公庫立替日
     */
    public void setLblID_Date_KoukoTatekae_Red(String lblID_Date_KoukoTatekae_Red) {
        this.lblID_Date_KoukoTatekae_Red = lblID_Date_KoukoTatekae_Red;
    }

    /**
     * 計(円)を取得します。
     * @return 計(円)
     */
    public String getLblID_M_Kei_Red() {
        return lblID_M_Kei_Red;
    }

    /**
     * 計(円)を設定します。
     * @param lblID_M_Kei_Red 計(円)
     */
    public void setLblID_M_Kei_Red(String lblID_M_Kei_Red) {
        this.lblID_M_Kei_Red = lblID_M_Kei_Red;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public String getLblID_M_Sokin_Red() {
        return lblID_M_Sokin_Red;
    }

    /**
     * 送金額(円)を設定します。
     * @param lblID_M_Sokin_Red 送金額(円)
     */
    public void setLblID_M_Sokin_Red(String lblID_M_Sokin_Red) {
        this.lblID_M_Sokin_Red = lblID_M_Sokin_Red;
    }

    /**
     * 受入後立替金残高(円)を取得します。
     * @return 受入後立替金残高(円)
     */
    public String getLblID_M_TatekaeZanAfterUkeire_Red() {
        return lblID_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 受入後立替金残高(円)を設定します。
     * @param lblID_M_TatekaeZanAfterUkeire_Red 受入後立替金残高(円)
     */
    public void setLblID_M_TatekaeZanAfterUkeire_Red(String lblID_M_TatekaeZanAfterUkeire_Red) {
        this.lblID_M_TatekaeZanAfterUkeire_Red = lblID_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_Jtkshori_Red() {
        return lblID_Date_Jtkshori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param lblID_Date_Jtkshori_Red 受託者勘定処理年月
     */
    public void setLblID_Date_Jtkshori_Red(String lblID_Date_Jtkshori_Red) {
        this.lblID_Date_Jtkshori_Red = lblID_Date_Jtkshori_Red;
    }

    /**
     * 送金年月日を取得します。
     * @return 送金年月日
     */
    public String getLblID_Date_Sokin_Red() {
        return lblID_Date_Sokin_Red;
    }

    /**
     * 送金年月日を設定します。
     * @param lblID_Date_Sokin_Red 送金年月日
     */
    public void setLblID_Date_Sokin_Red(String lblID_Date_Sokin_Red) {
        this.lblID_Date_Sokin_Red = lblID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi_Red() {
        return lblID_ID_Sokinbi_Red;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_ID_Sokinbi_Red 送金日番号
     */
    public void setLblID_ID_Sokinbi_Red(String lblID_ID_Sokinbi_Red) {
        this.lblID_ID_Sokinbi_Red = lblID_ID_Sokinbi_Red;
    }

    /**
     * 顧客名（修正）を取得します。
     * @return 顧客名（修正）
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名（修正）を設定します。
     * @param lblID_Name_Customer 顧客名（修正）
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 扱店名（修正）を取得します。
     * @return 扱店名（修正）
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名（修正）を設定します。
     * @param lblID_Name_Organization 扱店名（修正）
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 公庫支店（修正）を取得します。
     * @return 公庫支店（修正）
     */
    public String getLblID_Code_KoukoShiten() {
        return lblID_Code_KoukoShiten;
    }

    /**
     * 公庫支店（修正）を設定します。
     * @param lblID_Code_KoukoShiten 公庫支店（修正）
     */
    public void setLblID_Code_KoukoShiten(String lblID_Code_KoukoShiten) {
        this.lblID_Code_KoukoShiten = lblID_Code_KoukoShiten;
    }

    /**
     * 扱店（修正）を取得します。
     * @return 扱店（修正）
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店（修正）を設定します。
     * @param lblID_Code_Organization 扱店（修正）
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗（修正）を取得します。
     * @return 店舗（修正）
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗（修正）を設定します。
     * @param lblID_Code_Tenpo 店舗（修正）
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 年度（修正）を取得します。
     * @return 年度（修正）
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度（修正）を設定します。
     * @param lblID_Year 年度（修正）
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }

    /**
     * 方式資金（修正）を取得します。
     * @return 方式資金（修正）
     */
    public String getLblID_Kubun_HoshikiShikin() {
        return lblID_Kubun_HoshikiShikin;
    }

    /**
     * 方式資金（修正）を設定します。
     * @param lblID_Kubun_HoshikiShikin 方式資金（修正）
     */
    public void setLblID_Kubun_HoshikiShikin(String lblID_Kubun_HoshikiShikin) {
        this.lblID_Kubun_HoshikiShikin = lblID_Kubun_HoshikiShikin;
    }

    /**
     * 番号（修正）を取得します。
     * @return 番号（修正）
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号（修正）を設定します。
     * @param lblID_ID_Ringi 番号（修正）
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }

    /**
     * 枝番（修正）を取得します。
     * @return 枝番（修正）
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番（修正）を設定します。
     * @param lblID_ID_RingiBranch 枝番（修正）
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }

    /**
     * 入金日（修正）を取得します。
     * @return 入金日（修正）
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日（修正）を設定します。
     * @param lblID_Date_Nyukin 入金日（修正）
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }

    /**
     * 立替金利息(円)（修正）を取得します。
     * @return 立替金利息(円)（修正）
     */
    public String getLblID_M_TatekaeRisoku() {
        return lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金利息(円)（修正）を設定します。
     * @param lblID_M_TatekaeRisoku 立替金利息(円)（修正）
     */
    public void setLblID_M_TatekaeRisoku(String lblID_M_TatekaeRisoku) {
        this.lblID_M_TatekaeRisoku = lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金(円)（修正）を取得します。
     * @return 立替金(円)（修正）
     */
    public String getLblID_M_Tatekae() {
        return lblID_M_Tatekae;
    }

    /**
     * 立替金(円)（修正）を設定します。
     * @param lblID_M_Tatekae 立替金(円)（修正）
     */
    public void setLblID_M_Tatekae(String lblID_M_Tatekae) {
        this.lblID_M_Tatekae = lblID_M_Tatekae;
    }

    /**
     * 仮受金(一般口)からの充当額(円)（修正）を取得します。
     * @return 仮受金(一般口)からの充当額(円)（修正）
     */
    public String getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額(円)（修正）を設定します。
     * @param lblID_M_KariukeIppanJuto 仮受金(一般口)からの充当額(円)（修正）
     */
    public void setLblID_M_KariukeIppanJuto(String lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }

    /**
     * 立替金の種類（修正）を取得します。
     * @return 立替金の種類（修正）
     */
    public String getLblID_Code_TatekaekinShurui() {
        return lblID_Code_TatekaekinShurui;
    }

    /**
     * 立替金の種類（修正）を設定します。
     * @param lblID_Code_TatekaekinShurui 立替金の種類（修正）
     */
    public void setLblID_Code_TatekaekinShurui(String lblID_Code_TatekaekinShurui) {
        this.lblID_Code_TatekaekinShurui = lblID_Code_TatekaekinShurui;
    }

    /**
     * 公庫立替日（修正）を取得します。
     * @return 公庫立替日（修正）
     */
    public String getLblID_Date_KoukoTatekae() {
        return lblID_Date_KoukoTatekae;
    }

    /**
     * 公庫立替日（修正）を設定します。
     * @param lblID_Date_KoukoTatekae 公庫立替日（修正）
     */
    public void setLblID_Date_KoukoTatekae(String lblID_Date_KoukoTatekae) {
        this.lblID_Date_KoukoTatekae = lblID_Date_KoukoTatekae;
    }

    /**
     * 計(円)（修正）を取得します。
     * @return 計(円)（修正）
     */
    public String getLblID_M_Kei() {
        return lblID_M_Kei;
    }

    /**
     * 計(円)（修正）を設定します。
     * @param lblID_M_Kei 計(円)（修正）
     */
    public void setLblID_M_Kei(String lblID_M_Kei) {
        this.lblID_M_Kei = lblID_M_Kei;
    }

    /**
     * 送金額(円)（修正）を取得します。
     * @return 送金額(円)（修正）
     */
    public String getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額(円)（修正）を設定します。
     * @param lblID_M_Sokin 送金額(円)（修正）
     */
    public void setLblID_M_Sokin(String lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
    }

    /**
     * 受入後立替金残高(円)（修正）を取得します。
     * @return 受入後立替金残高(円)（修正）
     */
    public String getLblID_M_TatekaeZanAfterUkeire() {
        return lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受入後立替金残高(円)（修正）を設定します。
     * @param lblID_M_TatekaeZanAfterUkeire 受入後立替金残高(円)（修正）
     */
    public void setLblID_M_TatekaeZanAfterUkeire(String lblID_M_TatekaeZanAfterUkeire) {
        this.lblID_M_TatekaeZanAfterUkeire = lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受託者勘定処理年月（修正）を取得します。
     * @return 受託者勘定処理年月（修正）
     */
    public String getLblID_Date_Jtkshori() {
        return lblID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月（修正）を設定します。
     * @param lblID_Date_Jtkshori 受託者勘定処理年月（修正）
     */
    public void setLblID_Date_Jtkshori(String lblID_Date_Jtkshori) {
        this.lblID_Date_Jtkshori = lblID_Date_Jtkshori;
    }

    /**
     * 送金年月日（修正）を取得します。
     * @return 送金年月日（修正）
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金年月日（修正）を設定します。
     * @param lblID_Date_Sokin 送金年月日（修正）
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }

    /**
     * 送金日番号（修正）を取得します。
     * @return 送金日番号（修正）
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号（修正）を設定します。
     * @param lblID_ID_Sokinbi 送金日番号（修正）
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
    }

    /**
     * 処理モードを取得します。
     * @return 処理モード
     */
    public String getProcessMode() {
        return ProcessMode;
    }

    /**
     * 処理モードを設定します。
     * @param ProcessMode 処理モード
     */
    public void setProcessMode(String ProcessMode) {
        this.ProcessMode = ProcessMode;
    }

    /**
     * 入力受託者勘定処理年月（元号）を取得します。
     * @return 入力受託者勘定処理年月（元号）
     */
    public String getID_Date_Jtkshori_Gengou_Red() {
        return ID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 入力受託者勘定処理年月（元号）を設定します。
     * @param ID_Date_Jtkshori_Gengou_Red 入力受託者勘定処理年月（元号）
     */
    public void setID_Date_Jtkshori_Gengou_Red(String ID_Date_Jtkshori_Gengou_Red) {
        this.ID_Date_Jtkshori_Gengou_Red = ID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 入力受託者勘定処理年月（年）を取得します。
     * @return 入力受託者勘定処理年月（年）
     */
    public String getID_Date_Jtkshori_Year_Red() {
        return ID_Date_Jtkshori_Year_Red;
    }

    /**
     * 入力受託者勘定処理年月（年）を設定します。
     * @param ID_Date_Jtkshori_Year_Red 入力受託者勘定処理年月（年）
     */
    public void setID_Date_Jtkshori_Year_Red(String ID_Date_Jtkshori_Year_Red) {
        this.ID_Date_Jtkshori_Year_Red = ID_Date_Jtkshori_Year_Red;
    }

    /**
     * 入力受託者勘定処理年月（月）を取得します。
     * @return 入力受託者勘定処理年月（月）
     */
    public String getID_Date_Jtkshori_Month_Red() {
        return ID_Date_Jtkshori_Month_Red;
    }

    /**
     * 入力受託者勘定処理年月（月）を設定します。
     * @param ID_Date_Jtkshori_Month_Red 入力受託者勘定処理年月（月）
     */
    public void setID_Date_Jtkshori_Month_Red(String ID_Date_Jtkshori_Month_Red) {
        this.ID_Date_Jtkshori_Month_Red = ID_Date_Jtkshori_Month_Red;
    }

    /**
     * 入力受託者勘定処理年月（元号）（修正）を取得します。
     * @return 入力受託者勘定処理年月（元号）（修正）
     */
    public String getID_Date_Jtkshori_Gengou() {
        return ID_Date_Jtkshori_Gengou;
    }

    /**
     * 入力受託者勘定処理年月（元号）（修正）を設定します。
     * @param ID_Date_Jtkshori_Gengou 入力受託者勘定処理年月（元号）（修正）
     */
    public void setID_Date_Jtkshori_Gengou(String ID_Date_Jtkshori_Gengou) {
        this.ID_Date_Jtkshori_Gengou = ID_Date_Jtkshori_Gengou;
    }

    /**
     * 入力受託者勘定処理年月（年）（修正）を取得します。
     * @return 入力受託者勘定処理年月（年）（修正）
     */
    public String getID_Date_Jtkshori_Year() {
        return ID_Date_Jtkshori_Year;
    }

    /**
     * 入力受託者勘定処理年月（年）（修正）を設定します。
     * @param ID_Date_Jtkshori_Year 入力受託者勘定処理年月（年）（修正）
     */
    public void setID_Date_Jtkshori_Year(String ID_Date_Jtkshori_Year) {
        this.ID_Date_Jtkshori_Year = ID_Date_Jtkshori_Year;
    }

    /**
     * 入力受託者勘定処理年月（月）（修正）を取得します。
     * @return 入力受託者勘定処理年月（月）（修正）
     */
    public String getID_Date_Jtkshori_Month() {
        return ID_Date_Jtkshori_Month;
    }

    /**
     * 入力受託者勘定処理年月（月）（修正）を設定します。
     * @param ID_Date_Jtkshori_Month 入力受託者勘定処理年月（月）（修正）
     */
    public void setID_Date_Jtkshori_Month(String ID_Date_Jtkshori_Month) {
        this.ID_Date_Jtkshori_Month = ID_Date_Jtkshori_Month;
    }

    /**
     * 入力入金日（元号）（修正）を取得します。
     * @return 入力入金日（元号）（修正）
     */
    public String getID_Date_Nyukin_Gengou() {
        return ID_Date_Nyukin_Gengou;
    }

    /**
     * 入力入金日（元号）（修正）を設定します。
     * @param ID_Date_Nyukin_Gengou 入力入金日（元号）（修正）
     */
    public void setID_Date_Nyukin_Gengou(String ID_Date_Nyukin_Gengou) {
        this.ID_Date_Nyukin_Gengou = ID_Date_Nyukin_Gengou;
    }

    /**
     * 入力入金日（年）（修正）を取得します。
     * @return 入力入金日（年）（修正）
     */
    public String getID_Date_Nyukin_Year() {
        return ID_Date_Nyukin_Year;
    }

    /**
     * 入力入金日（年）（修正）を設定します。
     * @param ID_Date_Nyukin_Year 入力入金日（年）（修正）
     */
    public void setID_Date_Nyukin_Year(String ID_Date_Nyukin_Year) {
        this.ID_Date_Nyukin_Year = ID_Date_Nyukin_Year;
    }

    /**
     * 入力入金日（月）（修正）を取得します。
     * @return 入力入金日（月）（修正）
     */
    public String getID_Date_Nyukin_Month() {
        return ID_Date_Nyukin_Month;
    }

    /**
     * 入力入金日（月）（修正）を設定します。
     * @param ID_Date_Nyukin_Month 入力入金日（月）（修正）
     */
    public void setID_Date_Nyukin_Month(String ID_Date_Nyukin_Month) {
        this.ID_Date_Nyukin_Month = ID_Date_Nyukin_Month;
    }

    /**
     * 入力入金日（日）（修正）を取得します。
     * @return 入力入金日（日）（修正）
     */
    public String getID_Date_Nyukin_Day() {
        return ID_Date_Nyukin_Day;
    }

    /**
     * 入力入金日（日）（修正）を設定します。
     * @param ID_Date_Nyukin_Day 入力入金日（日）（修正）
     */
    public void setID_Date_Nyukin_Day(String ID_Date_Nyukin_Day) {
        this.ID_Date_Nyukin_Day = ID_Date_Nyukin_Day;
    }

    /**
     * 入力送金年月日（元号）（修正）を取得します。
     * @return 入力送金年月日（元号）（修正）
     */
    public String getID_Date_Sokin_Gengou() {
        return ID_Date_Sokin_Gengou;
    }

    /**
     * 入力送金年月日（元号）（修正）を設定します。
     * @param ID_Date_Sokin_Gengou 入力送金年月日（元号）（修正）
     */
    public void setID_Date_Sokin_Gengou(String ID_Date_Sokin_Gengou) {
        this.ID_Date_Sokin_Gengou = ID_Date_Sokin_Gengou;
    }

    /**
     * 入力送金年月日（年）（修正）を取得します。
     * @return 入力送金年月日（年）（修正）
     */
    public String getID_Date_Sokin_Year() {
        return ID_Date_Sokin_Year;
    }

    /**
     * 入力送金年月日（年）（修正）を設定します。
     * @param ID_Date_Sokin_Year 入力送金年月日（年）（修正）
     */
    public void setID_Date_Sokin_Year(String ID_Date_Sokin_Year) {
        this.ID_Date_Sokin_Year = ID_Date_Sokin_Year;
    }

    /**
     * 入力送金年月日（月）（修正）を取得します。
     * @return 入力送金年月日（月）（修正）
     */
    public String getID_Date_Sokin_Month() {
        return ID_Date_Sokin_Month;
    }

    /**
     * 入力送金年月日（月）（修正）を設定します。
     * @param ID_Date_Sokin_Month 入力送金年月日（月）（修正）
     */
    public void setID_Date_Sokin_Month(String ID_Date_Sokin_Month) {
        this.ID_Date_Sokin_Month = ID_Date_Sokin_Month;
    }

    /**
     * 入力送金年月日（日）（修正）を取得します。
     * @return 入力送金年月日（日）（修正）
     */
    public String getID_Date_Sokin_Day() {
        return ID_Date_Sokin_Day;
    }

    /**
     * 入力送金年月日（日）（修正）を設定します。
     * @param ID_Date_Sokin_Day 入力送金年月日（日）（修正）
     */
    public void setID_Date_Sokin_Day(String ID_Date_Sokin_Day) {
        this.ID_Date_Sokin_Day = ID_Date_Sokin_Day;
    }

    /**
     * 報告書番号（非表示）を取得します。
     * @return 報告書番号（非表示）
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号（非表示）を設定します。
     * @param ID_ID_Report 報告書番号（非表示）
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 報告時分秒（非表示）を取得します。
     * @return 報告時分秒（非表示）
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒（非表示）を設定します。
     * @param ID_Time_Report 報告時分秒（非表示）
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * ユーザID（非表示）を取得します。
     * @return ユーザID（非表示）
     */
    public String getID_UserID() {
        return ID_UserID;
    }

    /**
     * ユーザID（非表示）を設定します。
     * @param ID_UserID ユーザID（非表示）
     */
    public void setID_UserID(String ID_UserID) {
        this.ID_UserID = ID_UserID;
    }

    /**
     * 伝送番号（非表示）を取得します。
     * @return 伝送番号（非表示）
     */
    public String getID_ID_Denso_Red() {
        return ID_ID_Denso_Red;
    }

    /**
     * 伝送番号（非表示）を設定します。
     * @param ID_ID_Denso_Red 伝送番号（非表示）
     */
    public void setID_ID_Denso_Red(String ID_ID_Denso_Red) {
        this.ID_ID_Denso_Red = ID_ID_Denso_Red;
    }

    /**
     * データコード（非表示）を取得します。
     * @return データコード（非表示）
     */
    public String getID_DataCode_Red() {
        return ID_DataCode_Red;
    }

    /**
     * データコード（非表示）を設定します。
     * @param ID_DataCode_Red データコード（非表示）
     */
    public void setID_DataCode_Red(String ID_DataCode_Red) {
        this.ID_DataCode_Red = ID_DataCode_Red;
    }

    /**
     * 履歴番号（非表示）を取得します。
     * @return 履歴番号（非表示）
     */
    public String getID_ID_History_Red() {
        return ID_ID_History_Red;
    }

    /**
     * 履歴番号（非表示）を設定します。
     * @param ID_ID_History_Red 履歴番号（非表示）
     */
    public void setID_ID_History_Red(String ID_ID_History_Red) {
        this.ID_ID_History_Red = ID_ID_History_Red;
    }

    /**
     * ステータス（値）（非表示）を取得します。
     * @return ステータス（値）（非表示）
     */
    public String getID_Status_Red() {
        return ID_Status_Red;
    }

    /**
     * ステータス（値）（非表示）を設定します。
     * @param ID_Status_Red ステータス（値）（非表示）
     */
    public void setID_Status_Red(String ID_Status_Red) {
        this.ID_Status_Red = ID_Status_Red;
    }

    /**
     * 処理種別（非表示）を取得します。
     * @return 処理種別（非表示）
     */
    public String getID_Type_Process_Red() {
        return ID_Type_Process_Red;
    }

    /**
     * 処理種別（非表示）を設定します。
     * @param ID_Type_Process_Red 処理種別（非表示）
     */
    public void setID_Type_Process_Red(String ID_Type_Process_Red) {
        this.ID_Type_Process_Red = ID_Type_Process_Red;
    }

    /**
     * 取消済みフラグ（非表示）を取得します。
     * @return 取消済みフラグ（非表示）
     */
    public String getID_Flag_Torikeshizumi_Red() {
        return ID_Flag_Torikeshizumi_Red;
    }

    /**
     * 取消済みフラグ（非表示）を設定します。
     * @param ID_Flag_Torikeshizumi_Red 取消済みフラグ（非表示）
     */
    public void setID_Flag_Torikeshizumi_Red(String ID_Flag_Torikeshizumi_Red) {
        this.ID_Flag_Torikeshizumi_Red = ID_Flag_Torikeshizumi_Red;
    }

    /**
     * 債権管理番号（非表示）を取得します。
     * @return 債権管理番号（非表示）
     */
    public String getID_ID_Credit_Red() {
        return ID_ID_Credit_Red;
    }

    /**
     * 債権管理番号（非表示）を設定します。
     * @param ID_ID_Credit_Red 債権管理番号（非表示）
     */
    public void setID_ID_Credit_Red(String ID_ID_Credit_Red) {
        this.ID_ID_Credit_Red = ID_ID_Credit_Red;
    }

    /**
     * 退避履歴番号（非表示）を取得します。
     * @return 退避履歴番号（非表示）
     */
    public String getID_Keep_ID_History_Red() {
        return ID_Keep_ID_History_Red;
    }

    /**
     * 退避履歴番号（非表示）を設定します。
     * @param ID_Keep_ID_History_Red 退避履歴番号（非表示）
     */
    public void setID_Keep_ID_History_Red(String ID_Keep_ID_History_Red) {
        this.ID_Keep_ID_History_Red = ID_Keep_ID_History_Red;
    }

    /**
     * 退避実行済みフラグ（非表示）を取得します。
     * @return 退避実行済みフラグ（非表示）
     */
    public String getID_Keep_Flag_Kj_Red() {
        return ID_Keep_Flag_Kj_Red;
    }

    /**
     * 退避実行済みフラグ（非表示）を設定します。
     * @param ID_Keep_Flag_Kj_Red 退避実行済みフラグ（非表示）
     */
    public void setID_Keep_Flag_Kj_Red(String ID_Keep_Flag_Kj_Red) {
        this.ID_Keep_Flag_Kj_Red = ID_Keep_Flag_Kj_Red;
    }

    /**
     * 退避受入後立替金残高（非表示）を取得します。
     * @return 退避受入後立替金残高（非表示）
     */
    public String getID_Keep_M_TatekaeZanAfterUkeire_Red() {
        return ID_Keep_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 退避受入後立替金残高（非表示）を設定します。
     * @param ID_Keep_M_TatekaeZanAfterUkeire_Red 退避受入後立替金残高（非表示）
     */
    public void setID_Keep_M_TatekaeZanAfterUkeire_Red(String ID_Keep_M_TatekaeZanAfterUkeire_Red) {
        this.ID_Keep_M_TatekaeZanAfterUkeire_Red = ID_Keep_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 最新更新日時（非表示）を取得します。
     * @return 最新更新日時（非表示）
     */
    public String getID_Data_LastUpDate_Red() {
        return ID_Data_LastUpDate_Red;
    }

    /**
     * 最新更新日時（非表示）を設定します。
     * @param ID_Data_LastUpDate_Red 最新更新日時（非表示）
     */
    public void setID_Data_LastUpDate_Red(String ID_Data_LastUpDate_Red) {
        this.ID_Data_LastUpDate_Red = ID_Data_LastUpDate_Red;
    }

    /**
     * 仮受仮払番号（非表示）を取得します。
     * @return 仮受仮払番号（非表示）
     */
    public String getID_ID_Karibarai_Red() {
        return ID_ID_Karibarai_Red;
    }

    /**
     * 仮受仮払番号（非表示）を設定します。
     * @param ID_ID_Karibarai_Red 仮受仮払番号（非表示）
     */
    public void setID_ID_Karibarai_Red(String ID_ID_Karibarai_Red) {
        this.ID_ID_Karibarai_Red = ID_ID_Karibarai_Red;
    }

    /**
     * 仮受仮払年月日（非表示）を取得します。
     * @return 仮受仮払年月日（非表示）
     */
    public String getID_Date_Karibarai_Red() {
        return ID_Date_Karibarai_Red;
    }

    /**
     * 仮受仮払年月日（非表示）を設定します。
     * @param ID_Date_Karibarai_Red 仮受仮払年月日（非表示）
     */
    public void setID_Date_Karibarai_Red(String ID_Date_Karibarai_Red) {
        this.ID_Date_Karibarai_Red = ID_Date_Karibarai_Red;
    }

    /**
     * 本支店コード（非表示）を取得します。
     * @return 本支店コード（非表示）
     */
    public String getID_Code_HonShiten_Red() {
        return ID_Code_HonShiten_Red;
    }

    /**
     * 本支店コード（非表示）を設定します。
     * @param ID_Code_HonShiten_Red 本支店コード（非表示）
     */
    public void setID_Code_HonShiten_Red(String ID_Code_HonShiten_Red) {
        this.ID_Code_HonShiten_Red = ID_Code_HonShiten_Red;
    }

    /**
     * 仮受仮払精算後残高（非表示）を取得します。
     * @return 仮受仮払精算後残高（非表示）
     */
    public String getID_M_KaribaraiZanAfterSeisan_Red() {
        return ID_M_KaribaraiZanAfterSeisan_Red;
    }

    /**
     * 仮受仮払精算後残高（非表示）を設定します。
     * @param ID_M_KaribaraiZanAfterSeisan_Red 仮受仮払精算後残高（非表示）
     */
    public void setID_M_KaribaraiZanAfterSeisan_Red(String ID_M_KaribaraiZanAfterSeisan_Red) {
        this.ID_M_KaribaraiZanAfterSeisan_Red = ID_M_KaribaraiZanAfterSeisan_Red;
    }

    /**
     * 伝送番号（非表示）（修正）を取得します。
     * @return 伝送番号（非表示）（修正）
     */
    public String getID_ID_Denso() {
        return ID_ID_Denso;
    }

    /**
     * 伝送番号（非表示）（修正）を設定します。
     * @param ID_ID_Denso 伝送番号（非表示）（修正）
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        this.ID_ID_Denso = ID_ID_Denso;
    }

    /**
     * データコード（非表示）（修正）を取得します。
     * @return データコード（非表示）（修正）
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコード（非表示）（修正）を設定します。
     * @param ID_DataCode データコード（非表示）（修正）
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 履歴番号（非表示）（修正）を取得します。
     * @return 履歴番号（非表示）（修正）
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号（非表示）（修正）を設定します。
     * @param ID_ID_History 履歴番号（非表示）（修正）
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * ステータス（値）（非表示）（修正）を取得します。
     * @return ステータス（値）（非表示）（修正）
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータス（値）（非表示）（修正）を設定します。
     * @param ID_Status ステータス（値）（非表示）（修正）
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 処理種別（非表示）（修正）を取得します。
     * @return 処理種別（非表示）（修正）
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
    }

    /**
     * 処理種別（非表示）（修正）を設定します。
     * @param ID_Type_Process 処理種別（非表示）（修正）
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
    }

    /**
     * 取消済みフラグ（非表示）（修正）を取得します。
     * @return 取消済みフラグ（非表示）（修正）
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済みフラグ（非表示）（修正）を設定します。
     * @param ID_Flag_Torikeshizumi 取消済みフラグ（非表示）（修正）
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * 債権管理番号（非表示）（修正）を取得します。
     * @return 債権管理番号（非表示）（修正）
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号（非表示）（修正）を設定します。
     * @param ID_ID_Credit 債権管理番号（非表示）（修正）
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 退避履歴番号（非表示）（修正）を取得します。
     * @return 退避履歴番号（非表示）（修正）
     */
    public String getID_Keep_ID_History() {
        return ID_Keep_ID_History;
    }

    /**
     * 退避履歴番号（非表示）（修正）を設定します。
     * @param ID_Keep_ID_History 退避履歴番号（非表示）（修正）
     */
    public void setID_Keep_ID_History(String ID_Keep_ID_History) {
        this.ID_Keep_ID_History = ID_Keep_ID_History;
    }

    /**
     * 退避実行済みフラグ（非表示）（修正）を取得します。
     * @return 退避実行済みフラグ（非表示）（修正）
     */
    public String getID_Keep_Flag_Kj() {
        return ID_Keep_Flag_Kj;
    }

    /**
     * 退避実行済みフラグ（非表示）（修正）を設定します。
     * @param ID_Keep_Flag_Kj 退避実行済みフラグ（非表示）（修正）
     */
    public void setID_Keep_Flag_Kj(String ID_Keep_Flag_Kj) {
        this.ID_Keep_Flag_Kj = ID_Keep_Flag_Kj;
    }

    /**
     * 退避受入後立替金残高（非表示）（修正）を取得します。
     * @return 退避受入後立替金残高（非表示）（修正）
     */
    public String getID_Keep_M_TatekaeZanAfterUkeire() {
        return ID_Keep_M_TatekaeZanAfterUkeire;
    }

    /**
     * 退避受入後立替金残高（非表示）（修正）を設定します。
     * @param ID_Keep_M_TatekaeZanAfterUkeire 退避受入後立替金残高（非表示）（修正）
     */
    public void setID_Keep_M_TatekaeZanAfterUkeire(String ID_Keep_M_TatekaeZanAfterUkeire) {
        this.ID_Keep_M_TatekaeZanAfterUkeire = ID_Keep_M_TatekaeZanAfterUkeire;
    }

    /**
     * 最新更新日時（非表示）（修正）を取得します。
     * @return 最新更新日時（非表示）（修正）
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新更新日時（非表示）（修正）を設定します。
     * @param ID_Data_LastUpDate 最新更新日時（非表示）（修正）
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 仮受仮払番号（非表示）（修正）を取得します。
     * @return 仮受仮払番号（非表示）（修正）
     */
    public String getID_ID_Karibarai() {
        return ID_ID_Karibarai;
    }

    /**
     * 仮受仮払番号（非表示）（修正）を設定します。
     * @param ID_ID_Karibarai 仮受仮払番号（非表示）（修正）
     */
    public void setID_ID_Karibarai(String ID_ID_Karibarai) {
        this.ID_ID_Karibarai = ID_ID_Karibarai;
    }

    /**
     * 仮受仮払年月日（非表示）（修正）を取得します。
     * @return 仮受仮払年月日（非表示）（修正）
     */
    public String getID_Date_Karibarai() {
        return ID_Date_Karibarai;
    }

    /**
     * 仮受仮払年月日（非表示）（修正）を設定します。
     * @param ID_Date_Karibarai 仮受仮払年月日（非表示）（修正）
     */
    public void setID_Date_Karibarai(String ID_Date_Karibarai) {
        this.ID_Date_Karibarai = ID_Date_Karibarai;
    }

    /**
     * 本支店コード（非表示）（修正）を取得します。
     * @return 本支店コード（非表示）（修正）
     */
    public String getID_Code_HonShiten() {
        return ID_Code_HonShiten;
    }

    /**
     * 本支店コード（非表示）（修正）を設定します。
     * @param ID_Code_HonShiten 本支店コード（非表示）（修正）
     */
    public void setID_Code_HonShiten(String ID_Code_HonShiten) {
        this.ID_Code_HonShiten = ID_Code_HonShiten;
    }

    /**
     * 仮受仮払精算後残高（非表示）（修正）を取得します。
     * @return 仮受仮払精算後残高（非表示）（修正）
     */
    public String getID_M_KaribaraiZanAfterSeisan() {
        return ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 仮受仮払精算後残高（非表示）（修正）を設定します。
     * @param ID_M_KaribaraiZanAfterSeisan 仮受仮払精算後残高（非表示）（修正）
     */
    public void setID_M_KaribaraiZanAfterSeisan(String ID_M_KaribaraiZanAfterSeisan) {
        this.ID_M_KaribaraiZanAfterSeisan = ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 赤データ入力領域タイトルを取得します。
     * @return 赤データ入力領域タイトル
     */
    public String getRedAreaTitle() {
        return redAreaTitle;
    }

    /**
     * 赤データ入力領域タイトルを設定します。
     * @param redAreaTitle 赤データ入力領域タイトル
     */
    public void setRedAreaTitle(String redAreaTitle) {
        this.redAreaTitle = redAreaTitle;
    }

    /**
     * 赤データ入力領域を取得します。
     * @return 赤データ入力領域
     */
    public String getRedArea() {
        return redArea;
    }

    /**
     * 赤データ入力領域を設定します。
     * @param redArea 赤データ入力領域
     */
    public void setRedArea(String redArea) {
        this.redArea = redArea;
    }

    /**
     * 黒データ入力領域タイトルを取得します。
     * @return 黒データ入力領域タイトル
     */
    public String getBlackAreaTitle() {
        return blackAreaTitle;
    }

    /**
     * 黒データ入力領域タイトルを設定します。
     * @param blackAreaTitle 黒データ入力領域タイトル
     */
    public void setBlackAreaTitle(String blackAreaTitle) {
        this.blackAreaTitle = blackAreaTitle;
    }

    /**
     * 黒データ入力領域を取得します。
     * @return 黒データ入力領域
     */
    public String getBlackArea() {
        return blackArea;
    }

    /**
     * 黒データ入力領域を設定します。
     * @param blackArea 黒データ入力領域
     */
    public void setBlackArea(String blackArea) {
        this.blackArea = blackArea;
    }

}