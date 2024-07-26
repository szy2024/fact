//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはMd008_01のFormクラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class Md008_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 顧客名 */
    private String txtID_Name_Customer_Red;
    /** 扱店名 */
    private String txtID_Name_Organization_Red;
    /** 公庫支店 */
    private String txtID_Code_ShokanHonShiten_Red;
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
    /** 入金日 */
    private String txtID_Date_Nyukin_Red;
    /** 仮受金（一般口）受入額 */
    private String txtID_M_KariukeIppanUkeire_Red;
    /** 受託者勘定処理年月 */
    private String txtID_Date_Jtkshori_Red;
    /** 送金日 */
    private String txtID_Date_Sokin_Red;
    /** 送金日番号 */
    private String txtID_Code_Sokin_Red;
    /** 受託者勘定処理年月（元号） */
    private String drpID_Date_Jtkshori_Gengou_Red;
    /** 受託者勘定処理年月（年） */
    private String txtID_Date_Jtkshori_Year_Input_Red;
    /** 受託者勘定処理年月（月） */
    private String drpID_Date_Jtkshori_Month_Red;
    /** 顧客名(修正） */
    private String txtID_Name_Customer;
    /** 扱店名(修正） */
    private String txtID_Name_Organization;
    /** 公庫支店(修正） */
    private String txtID_Code_ShokanHonShiten;
    /** 扱店(修正） */
    private String txtID_Code_Organization;
    /** 店舗(修正） */
    private String txtID_Code_Tenpo;
    /** 年度(修正） */
    private String txtID_Year;
    /** 方式資金(修正） */
    private String txtID_Code_HoshikiShikin;
    /** 番号(修正） */
    private String txtID_ID_Ringi;
    /** 枝番(修正） */
    private String txtID_ID_RingiBranch;
    /** 入金日（元号）(修正） */
    private String drpID_Date_Nyukin_Gengou;
    /** 入金日(年)(修正） */
    private String txtID_Date_Nyukin_Year_Input;
    /** 入金日（月）(修正） */
    private String drpID_Date_Nyukin_Month;
    /** 入金日（日）(修正） */
    private String drpID_Date_Nyukin_Day;
    /** 仮受金（一般口）受入額(修正） */
    private String txtID_M_KariukeIppanUkeire;
    /** 受託者勘定処理年月（表示）(修正） */
    private String txtID_Date_Jtkshori;
    /** 送金日（元号）(修正） */
    private String drpID_Date_Sokin_Gengou;
    /** 送金日（年）(修正） */
    private String txtID_Date_Sokin_Year_Input;
    /** 送金日（月）(修正） */
    private String drpID_Date_Sokin_Month;
    /** 送金日（日）(修正） */
    private String drpID_Date_Sokin_Day;
    /** 送金日番号(修正） */
    private String txtID_Code_Sokin;
    /** 受託者勘定処理年月（元号）(修正） */
    private String drpID_Date_Jtkshori_Gengou;
    /** 受託者勘定処理年月（年）(修正） */
    private String txtID_Date_Jtkshori_Year_Input;
    /** 受託者勘定処理年月（月）(修正） */
    private String drpID_Date_Jtkshori_Month;
    /** 報告時分秒 */
    private String Time_Report;
    /** 報告書種別（値） */
    private String DataCode;
    /** 履歴番号 */
    private String ID_History;
    /** ステータス */
    private String Status;
    /** 報告書番号 */
    private String ID_Report;
    /** 最新更新日時 */
    private String ID_Data_LastUpDate;
    /** 処理モード */
    private String processMode;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 赤データ入力領域タイトル */
    private String redAreaTitle;
    /** 赤データ入力領域 */
    private String redArea;
    /** 黒データ入力領域タイトル */
    private String blackAreaTitle;
    /** 黒データ入力領域 */
    private String blackArea;

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
    public String getTxtID_Name_Customer_Red() {
        return txtID_Name_Customer_Red;
    }

    /**
     * 顧客名を設定します。
     * @param txtID_Name_Customer_Red 顧客名
     */
    public void setTxtID_Name_Customer_Red(String txtID_Name_Customer_Red) {
        this.txtID_Name_Customer_Red = txtID_Name_Customer_Red;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getTxtID_Name_Organization_Red() {
        return txtID_Name_Organization_Red;
    }

    /**
     * 扱店名を設定します。
     * @param txtID_Name_Organization_Red 扱店名
     */
    public void setTxtID_Name_Organization_Red(String txtID_Name_Organization_Red) {
        this.txtID_Name_Organization_Red = txtID_Name_Organization_Red;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getTxtID_Code_ShokanHonShiten_Red() {
        return txtID_Code_ShokanHonShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     * @param txtID_Code_ShokanHonShiten_Red 公庫支店
     */
    public void setTxtID_Code_ShokanHonShiten_Red(String txtID_Code_ShokanHonShiten_Red) {
        this.txtID_Code_ShokanHonShiten_Red = txtID_Code_ShokanHonShiten_Red;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getTxtID_Code_Organization_Red() {
        return txtID_Code_Organization_Red;
    }

    /**
     * 扱店を設定します。
     * @param txtID_Code_Organization_Red 扱店
     */
    public void setTxtID_Code_Organization_Red(String txtID_Code_Organization_Red) {
        this.txtID_Code_Organization_Red = txtID_Code_Organization_Red;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getTxtID_Code_Tenpo_Red() {
        return txtID_Code_Tenpo_Red;
    }

    /**
     * 店舗を設定します。
     * @param txtID_Code_Tenpo_Red 店舗
     */
    public void setTxtID_Code_Tenpo_Red(String txtID_Code_Tenpo_Red) {
        this.txtID_Code_Tenpo_Red = txtID_Code_Tenpo_Red;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getTxtID_Year_Red() {
        return txtID_Year_Red;
    }

    /**
     * 年度を設定します。
     * @param txtID_Year_Red 年度
     */
    public void setTxtID_Year_Red(String txtID_Year_Red) {
        this.txtID_Year_Red = txtID_Year_Red;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getTxtID_Code_HoshikiShikin_Red() {
        return txtID_Code_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_Code_HoshikiShikin_Red 方式資金
     */
    public void setTxtID_Code_HoshikiShikin_Red(String txtID_Code_HoshikiShikin_Red) {
        this.txtID_Code_HoshikiShikin_Red = txtID_Code_HoshikiShikin_Red;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getTxtID_ID_Ringi_Red() {
        return txtID_ID_Ringi_Red;
    }

    /**
     * 番号を設定します。
     * @param txtID_ID_Ringi_Red 番号
     */
    public void setTxtID_ID_Ringi_Red(String txtID_ID_Ringi_Red) {
        this.txtID_ID_Ringi_Red = txtID_ID_Ringi_Red;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch_Red() {
        return txtID_ID_RingiBranch_Red;
    }

    /**
     * 枝番を設定します。
     * @param txtID_ID_RingiBranch_Red 枝番
     */
    public void setTxtID_ID_RingiBranch_Red(String txtID_ID_RingiBranch_Red) {
        this.txtID_ID_RingiBranch_Red = txtID_ID_RingiBranch_Red;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getTxtID_Date_Nyukin_Red() {
        return txtID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     * @param txtID_Date_Nyukin_Red 入金日
     */
    public void setTxtID_Date_Nyukin_Red(String txtID_Date_Nyukin_Red) {
        this.txtID_Date_Nyukin_Red = txtID_Date_Nyukin_Red;
    }

    /**
     * 仮受金（一般口）受入額を取得します。
     * @return 仮受金（一般口）受入額
     */
    public String getTxtID_M_KariukeIppanUkeire_Red() {
        return txtID_M_KariukeIppanUkeire_Red;
    }

    /**
     * 仮受金（一般口）受入額を設定します。
     * @param txtID_M_KariukeIppanUkeire_Red 仮受金（一般口）受入額
     */
    public void setTxtID_M_KariukeIppanUkeire_Red(String txtID_M_KariukeIppanUkeire_Red) {
        this.txtID_M_KariukeIppanUkeire_Red = txtID_M_KariukeIppanUkeire_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getTxtID_Date_Jtkshori_Red() {
        return txtID_Date_Jtkshori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param txtID_Date_Jtkshori_Red 受託者勘定処理年月
     */
    public void setTxtID_Date_Jtkshori_Red(String txtID_Date_Jtkshori_Red) {
        this.txtID_Date_Jtkshori_Red = txtID_Date_Jtkshori_Red;
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getTxtID_Date_Sokin_Red() {
        return txtID_Date_Sokin_Red;
    }

    /**
     * 送金日を設定します。
     * @param txtID_Date_Sokin_Red 送金日
     */
    public void setTxtID_Date_Sokin_Red(String txtID_Date_Sokin_Red) {
        this.txtID_Date_Sokin_Red = txtID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getTxtID_Code_Sokin_Red() {
        return txtID_Code_Sokin_Red;
    }

    /**
     * 送金日番号を設定します。
     * @param txtID_Code_Sokin_Red 送金日番号
     */
    public void setTxtID_Code_Sokin_Red(String txtID_Code_Sokin_Red) {
        this.txtID_Code_Sokin_Red = txtID_Code_Sokin_Red;
    }

    /**
     * 受託者勘定処理年月（元号）を取得します。
     * @return 受託者勘定処理年月（元号）
     */
    public String getDrpID_Date_Jtkshori_Gengou_Red() {
        return drpID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 受託者勘定処理年月（元号）を設定します。
     * @param drpID_Date_Jtkshori_Gengou_Red 受託者勘定処理年月（元号）
     */
    public void setDrpID_Date_Jtkshori_Gengou_Red(String drpID_Date_Jtkshori_Gengou_Red) {
        this.drpID_Date_Jtkshori_Gengou_Red = drpID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 受託者勘定処理年月（年）を取得します。
     * @return 受託者勘定処理年月（年）
     */
    public String getTxtID_Date_Jtkshori_Year_Input_Red() {
        return txtID_Date_Jtkshori_Year_Input_Red;
    }

    /**
     * 受託者勘定処理年月（年）を設定します。
     * @param txtID_Date_Jtkshori_Year_Input_Red 受託者勘定処理年月（年）
     */
    public void setTxtID_Date_Jtkshori_Year_Input_Red(String txtID_Date_Jtkshori_Year_Input_Red) {
        this.txtID_Date_Jtkshori_Year_Input_Red = txtID_Date_Jtkshori_Year_Input_Red;
    }

    /**
     * 受託者勘定処理年月（月）を取得します。
     * @return 受託者勘定処理年月（月）
     */
    public String getDrpID_Date_Jtkshori_Month_Red() {
        return drpID_Date_Jtkshori_Month_Red;
    }

    /**
     * 受託者勘定処理年月（月）を設定します。
     * @param drpID_Date_Jtkshori_Month_Red 受託者勘定処理年月（月）
     */
    public void setDrpID_Date_Jtkshori_Month_Red(String drpID_Date_Jtkshori_Month_Red) {
        this.drpID_Date_Jtkshori_Month_Red = drpID_Date_Jtkshori_Month_Red;
    }

    /**
     * 顧客名(修正）を取得します。
     * @return 顧客名(修正）
     */
    public String getTxtID_Name_Customer() {
        return txtID_Name_Customer;
    }

    /**
     * 顧客名(修正）を設定します。
     * @param txtID_Name_Customer 顧客名(修正）
     */
    public void setTxtID_Name_Customer(String txtID_Name_Customer) {
        this.txtID_Name_Customer = txtID_Name_Customer;
    }

    /**
     * 扱店名(修正）を取得します。
     * @return 扱店名(修正）
     */
    public String getTxtID_Name_Organization() {
        return txtID_Name_Organization;
    }

    /**
     * 扱店名(修正）を設定します。
     * @param txtID_Name_Organization 扱店名(修正）
     */
    public void setTxtID_Name_Organization(String txtID_Name_Organization) {
        this.txtID_Name_Organization = txtID_Name_Organization;
    }

    /**
     * 公庫支店(修正）を取得します。
     * @return 公庫支店(修正）
     */
    public String getTxtID_Code_ShokanHonShiten() {
        return txtID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店(修正）を設定します。
     * @param txtID_Code_ShokanHonShiten 公庫支店(修正）
     */
    public void setTxtID_Code_ShokanHonShiten(String txtID_Code_ShokanHonShiten) {
        this.txtID_Code_ShokanHonShiten = txtID_Code_ShokanHonShiten;
    }

    /**
     * 扱店(修正）を取得します。
     * @return 扱店(修正）
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店(修正）を設定します。
     * @param txtID_Code_Organization 扱店(修正）
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗(修正）を取得します。
     * @return 店舗(修正）
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗(修正）を設定します。
     * @param txtID_Code_Tenpo 店舗(修正）
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度(修正）を取得します。
     * @return 年度(修正）
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度(修正）を設定します。
     * @param txtID_Year 年度(修正）
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金(修正）を取得します。
     * @return 方式資金(修正）
     */
    public String getTxtID_Code_HoshikiShikin() {
        return txtID_Code_HoshikiShikin;
    }

    /**
     * 方式資金(修正）を設定します。
     * @param txtID_Code_HoshikiShikin 方式資金(修正）
     */
    public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
        this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
    }

    /**
     * 番号(修正）を取得します。
     * @return 番号(修正）
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号(修正）を設定します。
     * @param txtID_ID_Ringi 番号(修正）
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番(修正）を取得します。
     * @return 枝番(修正）
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番(修正）を設定します。
     * @param txtID_ID_RingiBranch 枝番(修正）
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 入金日（元号）(修正）を取得します。
     * @return 入金日（元号）(修正）
     */
    public String getDrpID_Date_Nyukin_Gengou() {
        return drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日（元号）(修正）を設定します。
     * @param drpID_Date_Nyukin_Gengou 入金日（元号）(修正）
     */
    public void setDrpID_Date_Nyukin_Gengou(String drpID_Date_Nyukin_Gengou) {
        this.drpID_Date_Nyukin_Gengou = drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日(年)(修正）を取得します。
     * @return 入金日(年)(修正）
     */
    public String getTxtID_Date_Nyukin_Year_Input() {
        return txtID_Date_Nyukin_Year_Input;
    }

    /**
     * 入金日(年)(修正）を設定します。
     * @param txtID_Date_Nyukin_Year_Input 入金日(年)(修正）
     */
    public void setTxtID_Date_Nyukin_Year_Input(String txtID_Date_Nyukin_Year_Input) {
        this.txtID_Date_Nyukin_Year_Input = txtID_Date_Nyukin_Year_Input;
    }

    /**
     * 入金日（月）(修正）を取得します。
     * @return 入金日（月）(修正）
     */
    public String getDrpID_Date_Nyukin_Month() {
        return drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日（月）(修正）を設定します。
     * @param drpID_Date_Nyukin_Month 入金日（月）(修正）
     */
    public void setDrpID_Date_Nyukin_Month(String drpID_Date_Nyukin_Month) {
        this.drpID_Date_Nyukin_Month = drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日（日）(修正）を取得します。
     * @return 入金日（日）(修正）
     */
    public String getDrpID_Date_Nyukin_Day() {
        return drpID_Date_Nyukin_Day;
    }

    /**
     * 入金日（日）(修正）を設定します。
     * @param drpID_Date_Nyukin_Day 入金日（日）(修正）
     */
    public void setDrpID_Date_Nyukin_Day(String drpID_Date_Nyukin_Day) {
        this.drpID_Date_Nyukin_Day = drpID_Date_Nyukin_Day;
    }

    /**
     * 仮受金（一般口）受入額(修正）を取得します。
     * @return 仮受金（一般口）受入額(修正）
     */
    public String getTxtID_M_KariukeIppanUkeire() {
        return txtID_M_KariukeIppanUkeire;
    }

    /**
     * 仮受金（一般口）受入額(修正）を設定します。
     * @param txtID_M_KariukeIppanUkeire 仮受金（一般口）受入額(修正）
     */
    public void setTxtID_M_KariukeIppanUkeire(String txtID_M_KariukeIppanUkeire) {
        this.txtID_M_KariukeIppanUkeire = txtID_M_KariukeIppanUkeire;
    }

    /**
     * 受託者勘定処理年月（表示）(修正）を取得します。
     * @return 受託者勘定処理年月（表示）(修正）
     */
    public String getTxtID_Date_Jtkshori() {
        return txtID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月（表示）(修正）を設定します。
     * @param txtID_Date_Jtkshori 受託者勘定処理年月（表示）(修正）
     */
    public void setTxtID_Date_Jtkshori(String txtID_Date_Jtkshori) {
        this.txtID_Date_Jtkshori = txtID_Date_Jtkshori;
    }

    /**
     * 送金日（元号）(修正）を取得します。
     * @return 送金日（元号）(修正）
     */
    public String getDrpID_Date_Sokin_Gengou() {
        return drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金日（元号）(修正）を設定します。
     * @param drpID_Date_Sokin_Gengou 送金日（元号）(修正）
     */
    public void setDrpID_Date_Sokin_Gengou(String drpID_Date_Sokin_Gengou) {
        this.drpID_Date_Sokin_Gengou = drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金日（年）(修正）を取得します。
     * @return 送金日（年）(修正）
     */
    public String getTxtID_Date_Sokin_Year_Input() {
        return txtID_Date_Sokin_Year_Input;
    }

    /**
     * 送金日（年）(修正）を設定します。
     * @param txtID_Date_Sokin_Year_Input 送金日（年）(修正）
     */
    public void setTxtID_Date_Sokin_Year_Input(String txtID_Date_Sokin_Year_Input) {
        this.txtID_Date_Sokin_Year_Input = txtID_Date_Sokin_Year_Input;
    }

    /**
     * 送金日（月）(修正）を取得します。
     * @return 送金日（月）(修正）
     */
    public String getDrpID_Date_Sokin_Month() {
        return drpID_Date_Sokin_Month;
    }

    /**
     * 送金日（月）(修正）を設定します。
     * @param drpID_Date_Sokin_Month 送金日（月）(修正）
     */
    public void setDrpID_Date_Sokin_Month(String drpID_Date_Sokin_Month) {
        this.drpID_Date_Sokin_Month = drpID_Date_Sokin_Month;
    }

    /**
     * 送金日（日）(修正）を取得します。
     * @return 送金日（日）(修正）
     */
    public String getDrpID_Date_Sokin_Day() {
        return drpID_Date_Sokin_Day;
    }

    /**
     * 送金日（日）(修正）を設定します。
     * @param drpID_Date_Sokin_Day 送金日（日）(修正）
     */
    public void setDrpID_Date_Sokin_Day(String drpID_Date_Sokin_Day) {
        this.drpID_Date_Sokin_Day = drpID_Date_Sokin_Day;
    }

    /**
     * 送金日番号(修正）を取得します。
     * @return 送金日番号(修正）
     */
    public String getTxtID_Code_Sokin() {
        return txtID_Code_Sokin;
    }

    /**
     * 送金日番号(修正）を設定します。
     * @param txtID_Code_Sokin 送金日番号(修正）
     */
    public void setTxtID_Code_Sokin(String txtID_Code_Sokin) {
        this.txtID_Code_Sokin = txtID_Code_Sokin;
    }

    /**
     * 受託者勘定処理年月（元号）(修正）を取得します。
     * @return 受託者勘定処理年月（元号）(修正）
     */
    public String getDrpID_Date_Jtkshori_Gengou() {
        return drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月（元号）(修正）を設定します。
     * @param drpID_Date_Jtkshori_Gengou 受託者勘定処理年月（元号）(修正）
     */
    public void setDrpID_Date_Jtkshori_Gengou(String drpID_Date_Jtkshori_Gengou) {
        this.drpID_Date_Jtkshori_Gengou = drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月（年）(修正）を取得します。
     * @return 受託者勘定処理年月（年）(修正）
     */
    public String getTxtID_Date_Jtkshori_Year_Input() {
        return txtID_Date_Jtkshori_Year_Input;
    }

    /**
     * 受託者勘定処理年月（年）(修正）を設定します。
     * @param txtID_Date_Jtkshori_Year_Input 受託者勘定処理年月（年）(修正）
     */
    public void setTxtID_Date_Jtkshori_Year_Input(String txtID_Date_Jtkshori_Year_Input) {
        this.txtID_Date_Jtkshori_Year_Input = txtID_Date_Jtkshori_Year_Input;
    }

    /**
     * 受託者勘定処理年月（月）(修正）を取得します。
     * @return 受託者勘定処理年月（月）(修正）
     */
    public String getDrpID_Date_Jtkshori_Month() {
        return drpID_Date_Jtkshori_Month;
    }

    /**
     * 受託者勘定処理年月（月）(修正）を設定します。
     * @param drpID_Date_Jtkshori_Month 受託者勘定処理年月（月）(修正）
     */
    public void setDrpID_Date_Jtkshori_Month(String drpID_Date_Jtkshori_Month) {
        this.drpID_Date_Jtkshori_Month = drpID_Date_Jtkshori_Month;
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param Time_Report 報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        this.Time_Report = Time_Report;
    }

    /**
     * 報告書種別（値）を取得します。
     * @return 報告書種別（値）
     */
    public String getDataCode() {
        return DataCode;
    }

    /**
     * 報告書種別（値）を設定します。
     * @param DataCode 報告書種別（値）
     */
    public void setDataCode(String DataCode) {
        this.DataCode = DataCode;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return Status;
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return ID_History;
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        this.ID_History = ID_History;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return ID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        this.ID_Report = ID_Report;
    }

    /**
     * 最新更新日時を取得します。
     *
     * @return 最新更新日時
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新更新日時を設定します。
     * @param ID_Data_LastUpDate 最新更新日時
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 処理モードを取得します。
     * @return 処理モード
     */
    public String getProcessMode() {
        return processMode;
    }

    /**
     * 処理モードを設定します。
     * @param processMode 処理モード
     */
    public void setProcessMode(String processMode) {
        this.processMode = processMode;
    }

    /**
     * 処理種別を設定します。
     * @param ID_Type_Process 処理種別
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
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