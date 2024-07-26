//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_04Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
// 2.0.0   | 2017/11/30 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_04.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr008_04のFormクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr008_04Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** エラー */
    private String lblErr;
    /** ステータス */
    private String lblMessage;
    /** 顧客名 */
    private String txtID_Name_Customer;
    /** 扱店名 */
    private String txtID_Name_Organization;
    /** 公庫支店 */
    private String txtID_Code_ShokanHonShiten;
    /** 扱店 */
    private String txtID_Code_Organization;
    /** 店舗 */
    private String txtID_Code_Tenpo;
    /** 年度 */
    private String txtID_Year;
    /** 方式資金 */
    private String txtID_Code_HoshikiShikin;
    /** 番号 */
    private String txtID_ID_Ringi;
    /** 枝番 */
    private String txtID_ID_RingiBranch;
    /** 入金日（元号） */
    private String drpID_Date_Nyukin_Gengou;
    /** 入金日（年） */
    private String txtID_Date_Nyukin_Year;
    /** 入金日（月） */
    private String drpID_Date_Nyukin_Month;
    /** 入金日（日） */
    private String drpID_Date_Nyukin_Day;
    /** 仮受金（一般口）受入額 */
    private String txtID_M_KariukeIppanUkeire;
    /** 受託者勘定処理年月（元号） */
    private String drpID_Date_Jtkshori_Gengou;
    /** 受託者勘定処理年月（年） */
    private String txtID_Date_Jtkshori_Year;
    /** 受託者勘定処理年月（月） */
    private String drpID_Date_Jtkshori_Month;
    /** 送金年月日（元号） */
    private String drpID_Date_Sokin_Gengou;
    /** 送金年月日（年） */
    private String txtID_Date_Sokin_Year;
    /** 送金年月日（月） */
    private String drpID_Date_Sokin_Month;
    /** 送金年月日（日） */
    private String drpID_Date_Sokin_Day;
    /** 送金日番号 */
    private String txtID_Code_Sokin;
    /** 債権管理番号 */
    private String lblID_Credit;
    /** 公庫支店入力値 */
    private String Cr008_04_In_Code_ShokanHonShiten;
    /** 扱店入力値 */
    private String Cr008_04_In_Code_Organization;
    /** 店舗入力値 */
    private String Cr008_04_In_Code_Tenpo;
    /** 年度入力値 */
    private String Cr008_04_In_Year;
    /** 方式資金入力値 */
    private String Cr008_04_In_Kubun_HoshikiShikin;
    /** 番号入力値 */
    private String Cr008_04_In_ID_Ringi;
    /** 枝番入力値 */
    private String Cr008_04_In_ID_RingiBranch;
    /** 債権管理番号入力値 */
    private String Cr008_04_In_ID_Credit;
    /** 前画面ID */
    private String Cr008_04_PreScreenId;
    /** メッセージ領域 */
    private String infoArea;
    /** 編集領域 */
    private String editArea;

    /** 受託者勘定処理年月（元号）（隠し項目） */
    private String hdnID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月（月）（隠し項目） */
    private String hdnID_Date_JtkshoriTsuki_Candidate;
    /** 受託者勘定処理年月設定モード */
    private String lblID_JtkshoriConfigMode;
    /** 業務日付（元号） */
    private String lblID_BizDate_Gengo;
    /** 業務日付（年） */
    private String lblID_BizDate_Nen;
    /** 業務日付（月） */
    private String lblID_BizDate_Tsuki;
    /** 前月業務日付（元号） */
    private String lblID_BizDate_PrevMonth_Gengo;
    /** 前月業務日付（年） */
    private String lblID_BizDate_PrevMonth_Nen;
    /** 前月業務日付（月） */
    private String lblID_BizDate_PrevMonth_Tsuki;

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getTxtID_Date_Report() {
        return txtID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param txtID_Date_Report 報告年月日
     */
    public void setTxtID_Date_Report(String txtID_Date_Report) {
        this.txtID_Date_Report = txtID_Date_Report;
    }

    /**
     * エラーを取得します。
     * @return エラー
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * エラーを設定します。
     * @param lblErr エラー
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * ステータスを設定します。
     * @param lblMessage ステータス
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getTxtID_Name_Customer() {
        return txtID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param txtID_Name_Customer 顧客名
     */
    public void setTxtID_Name_Customer(String txtID_Name_Customer) {
        this.txtID_Name_Customer = txtID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getTxtID_Name_Organization() {
        return txtID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param txtID_Name_Organization 扱店名
     */
    public void setTxtID_Name_Organization(String txtID_Name_Organization) {
        this.txtID_Name_Organization = txtID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getTxtID_Code_ShokanHonShiten() {
        return txtID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param txtID_Code_ShokanHonShiten 公庫支店
     */
    public void setTxtID_Code_ShokanHonShiten(String txtID_Code_ShokanHonShiten) {
        this.txtID_Code_ShokanHonShiten = txtID_Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param txtID_Code_Organization 扱店
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param txtID_Code_Tenpo 店舗
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度を設定します。
     * @param txtID_Year 年度
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getTxtID_Code_HoshikiShikin() {
        return txtID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_Code_HoshikiShikin 方式資金
     */
    public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
        this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param txtID_ID_Ringi 番号
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param txtID_ID_RingiBranch 枝番
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 入金日（元号）を取得します。
     * @return 入金日（元号）
     */
    public String getDrpID_Date_Nyukin_Gengou() {
        return drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日（元号）を設定します。
     * @param drpID_Date_Nyukin_Gengou 入金日（元号）
     */
    public void setDrpID_Date_Nyukin_Gengou(String drpID_Date_Nyukin_Gengou) {
        this.drpID_Date_Nyukin_Gengou = drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日（年）を取得します。
     * @return 入金日（年）
     */
    public String getTxtID_Date_Nyukin_Year() {
        return txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日（年）を設定します。
     * @param txtID_Date_Nyukin_Year 入金日（年）
     */
    public void setTxtID_Date_Nyukin_Year(String txtID_Date_Nyukin_Year) {
        this.txtID_Date_Nyukin_Year = txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日（月）を取得します。
     * @return 入金日（月）
     */
    public String getDrpID_Date_Nyukin_Month() {
        return drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日（月）を設定します。
     * @param drpID_Date_Nyukin_Month 入金日（月）
     */
    public void setDrpID_Date_Nyukin_Month(String drpID_Date_Nyukin_Month) {
        this.drpID_Date_Nyukin_Month = drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日（日）を取得します。
     * @return 入金日（日）
     */
    public String getDrpID_Date_Nyukin_Day() {
        return drpID_Date_Nyukin_Day;
    }

    /**
     * 入金日（日）を設定します。
     * @param drpID_Date_Nyukin_Day 入金日（日）
     */
    public void setDrpID_Date_Nyukin_Day(String drpID_Date_Nyukin_Day) {
        this.drpID_Date_Nyukin_Day = drpID_Date_Nyukin_Day;
    }

    /**
     * 仮受金（一般口）受入額を取得します。
     * @return 仮受金（一般口）受入額
     */
    public String getTxtID_M_KariukeIppanUkeire() {
        return txtID_M_KariukeIppanUkeire;
    }

    /**
     * 仮受金（一般口）受入額を設定します。
     * @param txtID_M_KariukeIppanUkeire 仮受金（一般口）受入額
     */
    public void setTxtID_M_KariukeIppanUkeire(String txtID_M_KariukeIppanUkeire) {
        this.txtID_M_KariukeIppanUkeire = txtID_M_KariukeIppanUkeire;
    }

    /**
     * 受託者勘定処理年月（元号）を取得します。
     * @return 受託者勘定処理年月（元号）
     */
    public String getDrpID_Date_Jtkshori_Gengou() {
        return drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月（元号）を設定します。
     * @param drpID_Date_Jtkshori_Gengou 受託者勘定処理年月（元号）
     */
    public void setDrpID_Date_Jtkshori_Gengou(String drpID_Date_Jtkshori_Gengou) {
        this.drpID_Date_Jtkshori_Gengou = drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月（年）を取得します。
     * @return 受託者勘定処理年月（年）
     */
    public String getTxtID_Date_Jtkshori_Year() {
        return txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月（年）を設定します。
     * @param txtID_Date_Jtkshori_Year 受託者勘定処理年月（年）
     */
    public void setTxtID_Date_Jtkshori_Year(String txtID_Date_Jtkshori_Year) {
        this.txtID_Date_Jtkshori_Year = txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月（月）を取得します。
     * @return 受託者勘定処理年月（月）
     */
    public String getDrpID_Date_Jtkshori_Month() {
        return drpID_Date_Jtkshori_Month;
    }

    /**
     * 受託者勘定処理年月（月）を設定します。
     * @param drpID_Date_Jtkshori_Month 受託者勘定処理年月（月）
     */
    public void setDrpID_Date_Jtkshori_Month(String drpID_Date_Jtkshori_Month) {
        this.drpID_Date_Jtkshori_Month = drpID_Date_Jtkshori_Month;
    }

    /**
     * 送金年月日（元号）を取得します。
     * @return 送金年月日（元号）
     */
    public String getDrpID_Date_Sokin_Gengou() {
        return drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金年月日（元号）を設定します。
     * @param drpID_Date_Sokin_Gengou 送金年月日（元号）
     */
    public void setDrpID_Date_Sokin_Gengou(String drpID_Date_Sokin_Gengou) {
        this.drpID_Date_Sokin_Gengou = drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金年月日（年）を取得します。
     * @return 送金年月日（年）
     */
    public String getTxtID_Date_Sokin_Year() {
        return txtID_Date_Sokin_Year;
    }

    /**
     * 送金年月日（年）を設定します。
     * @param txtID_Date_Sokin_Year 送金年月日（年）
     */
    public void setTxtID_Date_Sokin_Year(String txtID_Date_Sokin_Year) {
        this.txtID_Date_Sokin_Year = txtID_Date_Sokin_Year;
    }

    /**
     * 送金年月日（月）を取得します。
     * @return 送金年月日（月）
     */
    public String getDrpID_Date_Sokin_Month() {
        return drpID_Date_Sokin_Month;
    }

    /**
     * 送金年月日（月）を設定します。
     * @param drpID_Date_Sokin_Month 送金年月日（月）
     */
    public void setDrpID_Date_Sokin_Month(String drpID_Date_Sokin_Month) {
        this.drpID_Date_Sokin_Month = drpID_Date_Sokin_Month;
    }

    /**
     * 送金年月日（日）を取得します。
     * @return 送金年月日（日）
     */
    public String getDrpID_Date_Sokin_Day() {
        return drpID_Date_Sokin_Day;
    }

    /**
     * 送金年月日（日）を設定します。
     * @param drpID_Date_Sokin_Day 送金年月日（日）
     */
    public void setDrpID_Date_Sokin_Day(String drpID_Date_Sokin_Day) {
        this.drpID_Date_Sokin_Day = drpID_Date_Sokin_Day;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getTxtID_Code_Sokin() {
        return txtID_Code_Sokin;
    }

    /**
     * 送金日番号を設定します。
     * @param txtID_Code_Sokin 送金日番号
     */
    public void setTxtID_Code_Sokin(String txtID_Code_Sokin) {
        this.txtID_Code_Sokin = txtID_Code_Sokin;
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getLblID_Credit() {
        return lblID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * @param lblID_Credit 債権管理番号
     */
    public void setLblID_Credit(String lblID_Credit) {
        this.lblID_Credit = lblID_Credit;
    }

    /**
     * 公庫支店入力値を取得します。
     * @return 公庫支店入力値
     */
    public String getCr008_04_In_Code_ShokanHonShiten() {
        return Cr008_04_In_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店入力値を設定します。
     * @param Cr008_04_In_Code_ShokanHonShiten 公庫支店入力値
     */
    public void setCr008_04_In_Code_ShokanHonShiten(String Cr008_04_In_Code_ShokanHonShiten) {
        this.Cr008_04_In_Code_ShokanHonShiten = Cr008_04_In_Code_ShokanHonShiten;
    }

    /**
     * 扱店入力値を取得します。
     * @return 扱店入力値
     */
    public String getCr008_04_In_Code_Organization() {
        return Cr008_04_In_Code_Organization;
    }

    /**
     * 扱店入力値を設定します。
     * @param Cr008_04_In_Code_Organization 扱店入力値
     */
    public void setCr008_04_In_Code_Organization(String Cr008_04_In_Code_Organization) {
        this.Cr008_04_In_Code_Organization = Cr008_04_In_Code_Organization;
    }

    /**
     * 店舗入力値を取得します。
     * @return 店舗入力値
     */
    public String getCr008_04_In_Code_Tenpo() {
        return Cr008_04_In_Code_Tenpo;
    }

    /**
     * 店舗入力値を設定します。
     * @param Cr008_04_In_Code_Tenpo 店舗入力値
     */
    public void setCr008_04_In_Code_Tenpo(String Cr008_04_In_Code_Tenpo) {
        this.Cr008_04_In_Code_Tenpo = Cr008_04_In_Code_Tenpo;
    }

    /**
     * 年度入力値を取得します。
     * @return 年度入力値
     */
    public String getCr008_04_In_Year() {
        return Cr008_04_In_Year;
    }

    /**
     * 年度入力値を設定します。
     * @param Cr008_04_In_Year 年度入力値
     */
    public void setCr008_04_In_Year(String Cr008_04_In_Year) {
        this.Cr008_04_In_Year = Cr008_04_In_Year;
    }

    /**
     * 方式資金入力値を取得します。
     * @return 方式資金入力値
     */
    public String getCr008_04_In_Kubun_HoshikiShikin() {
        return Cr008_04_In_Kubun_HoshikiShikin;
    }

    /**
     * 方式資金入力値を設定します。
     * @param Cr008_04_In_Kubun_HoshikiShikin 方式資金入力値
     */
    public void setCr008_04_In_Kubun_HoshikiShikin(String Cr008_04_In_Kubun_HoshikiShikin) {
        this.Cr008_04_In_Kubun_HoshikiShikin = Cr008_04_In_Kubun_HoshikiShikin;
    }

    /**
     * 番号入力値を取得します。
     * @return 番号入力値
     */
    public String getCr008_04_In_ID_Ringi() {
        return Cr008_04_In_ID_Ringi;
    }

    /**
     * 番号入力値を設定します。
     * @param Cr008_04_In_ID_Ringi 番号入力値
     */
    public void setCr008_04_In_ID_Ringi(String Cr008_04_In_ID_Ringi) {
        this.Cr008_04_In_ID_Ringi = Cr008_04_In_ID_Ringi;
    }

    /**
     * 枝番入力値を取得します。
     * @return 枝番入力値
     */
    public String getCr008_04_In_ID_RingiBranch() {
        return Cr008_04_In_ID_RingiBranch;
    }

    /**
     * 枝番入力値を設定します。
     * @param Cr008_04_In_ID_RingiBranch 枝番入力値
     */
    public void setCr008_04_In_ID_RingiBranch(String Cr008_04_In_ID_RingiBranch) {
        this.Cr008_04_In_ID_RingiBranch = Cr008_04_In_ID_RingiBranch;
    }

    /**
     * 債権管理番号入力値を取得します。
     * @return 債権管理番号入力値
     */
    public String getCr008_04_In_ID_Credit() {
        return Cr008_04_In_ID_Credit;
    }

    /**
     * 債権管理番号入力値を設定します。
     * @param Cr008_04_In_ID_Credit 債権管理番号入力値
     */
    public void setCr008_04_In_ID_Credit(String Cr008_04_In_ID_Credit) {
        this.Cr008_04_In_ID_Credit = Cr008_04_In_ID_Credit;
    }

    /**
     * 前画面IDを取得します。
     * @return 前画面ID
     */
    public String getCr008_04_PreScreenId() {
        return Cr008_04_PreScreenId;
    }

    /**
     * 前画面IDを設定します。
     * @param Cr008_04_PreScreenId 前画面ID
     */
    public void setCr008_04_PreScreenId(String Cr008_04_PreScreenId) {
        this.Cr008_04_PreScreenId = Cr008_04_PreScreenId;
    }

    /**
     * <pre>
     * メッセージ領域を取得します。
     * </pre>
     *
     * @return メッセージ領域
     */
    public String getInfoArea() {
        return infoArea;
    }

    /**
     * <pre>
     * メッセージ領域を設定します。
     * </pre>
     *
     * @param infoArea メッセージ領域
     */
    public void setInfoArea(String infoArea) {
        this.infoArea = infoArea;
    }

    /**
     * <pre>
     * 編集領域を取得します。
     * </pre>
     *
     * @return 編集領域
     */
    public String getEditArea() {
        return editArea;
    }

    /**
     * <pre>
     * 編集領域を設定します。
     * </pre>
     *
     * @param editArea 編集領域
     */
    public void setEditArea(String editArea) {
        this.editArea = editArea;
    }

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を取得します。
     * @return 受託者勘定処理年月（元号）（隠し項目）
     */
    public String getHdnID_Date_Jtkshori_Gengo() {
        return hdnID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を設定します。
     * @param hdnID_Date_Jtkshori_Gengo 受託者勘定処理年月（元号）（隠し項目）
     */
    public void setHdnID_Date_Jtkshori_Gengo(String hdnID_Date_Jtkshori_Gengo) {
        this.hdnID_Date_Jtkshori_Gengo = hdnID_Date_Jtkshori_Gengo;
        this.drpID_Date_Jtkshori_Gengou = hdnID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を取得します。
     * @return 受託者勘定処理年月（月）（隠し項目）
     */
    public String getHdnID_Date_JtkshoriTsuki_Candidate() {
        return hdnID_Date_JtkshoriTsuki_Candidate;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を設定します。
     * @param hdnID_Date_JtkshoriTsuki_Candidate 受託者勘定処理年月（月）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriTsuki_Candidate(String hdnID_Date_JtkshoriTsuki_Candidate) {
        this.hdnID_Date_JtkshoriTsuki_Candidate = hdnID_Date_JtkshoriTsuki_Candidate;
        this.drpID_Date_Jtkshori_Month = hdnID_Date_JtkshoriTsuki_Candidate;
    }

    /**
     * 受託者勘定処理年月設定モードを取得します。
     * @return 受託者勘定処理年月設定モード
     */
    public String getLblID_JtkshoriConfigMode() {
        return lblID_JtkshoriConfigMode;
    }

    /**
     * 受託者勘定処理年月設定モードを設定します。
     * @param lblID_JtkshoriConfigMode 受託者勘定処理年月設定モード
     */
    public void setLblID_JtkshoriConfigMode(String lblID_JtkshoriConfigMode) {
        this.lblID_JtkshoriConfigMode = lblID_JtkshoriConfigMode;
    }

    /**
     * 業務日付（元号）を取得します。
     * @return 業務日付（元号）
     */
    public String getLblID_BizDate_Gengo() {
        return lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（元号）を設定します。
     * @param lblID_BizDate_Gengo 業務日付（元号）
     */
    public void setLblID_BizDate_Gengo(String lblID_BizDate_Gengo) {
        this.lblID_BizDate_Gengo = lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（年）を取得します。
     * @return 業務日付（年）
     */
    public String getLblID_BizDate_Nen() {
        return lblID_BizDate_Nen;
    }

    /**
     * 業務日付（年）を設定します。
     * @param lblID_BizDate_Nen 業務日付（年）
     */
    public void setLblID_BizDate_Nen(String lblID_BizDate_Nen) {
        this.lblID_BizDate_Nen = lblID_BizDate_Nen;
    }

    /**
     * 業務日付（月）を取得します。
     * @return 業務日付（月）
     */
    public String getLblID_BizDate_Tsuki() {
        return lblID_BizDate_Tsuki;
    }

    /**
     * 業務日付（月）を設定します。
     * @param lblID_BizDate_Tsuki 業務日付（月）
     */
    public void setLblID_BizDate_Tsuki(String lblID_BizDate_Tsuki) {
        this.lblID_BizDate_Tsuki = lblID_BizDate_Tsuki;
    }

    /**
     * 前月業務日付（元号）を取得します。
     * @return 前月業務日付（元号）
     */
    public String getLblID_BizDate_PrevMonth_Gengo() {
        return lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（元号）を設定します。
     * @param lblID_BizDate_PrevMonth_Gengo 前月業務日付（元号）
     */
    public void setLblID_BizDate_PrevMonth_Gengo(String lblID_BizDate_PrevMonth_Gengo) {
        this.lblID_BizDate_PrevMonth_Gengo = lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（年）を取得します。
     * @return 前月業務日付（年）
     */
    public String getLblID_BizDate_PrevMonth_Nen() {
        return lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（年）を設定します。
     * @param lblID_BizDate_PrevMonth_Nen 前月業務日付（年）
     */
    public void setLblID_BizDate_PrevMonth_Nen(String lblID_BizDate_PrevMonth_Nen) {
        this.lblID_BizDate_PrevMonth_Nen = lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（月）を取得します。
     * @return 前月業務日付（月）
     */
    public String getLblID_BizDate_PrevMonth_Tsuki() {
        return lblID_BizDate_PrevMonth_Tsuki;
    }

    /**
     * 前月業務日付（月）を設定します。
     * @param lblID_BizDate_PrevMonth_Tsuki 前月業務日付（月）
     */
    public void setLblID_BizDate_PrevMonth_Tsuki(String lblID_BizDate_PrevMonth_Tsuki) {
        this.lblID_BizDate_PrevMonth_Tsuki = lblID_BizDate_PrevMonth_Tsuki;
    }

}