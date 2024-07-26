//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはCr009_01のFormクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr009_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 扱店名 */
    private String txtID_Name_Organization;
    /** 公庫支店 */
    private String txtID_Code_ShokanHonShiten;
    /** 扱店 */
    private String txtID_Code_Organization;
    /** 店舗 */
    private String txtID_Code_Tenpo;
    /** 入金日（元号） */
    private String drpID_Date_Nyukin_Gengou;
    /** 入金日（年） */
    private String txtID_Date_Nyukin_Year_Input;
    /** 入金日（月） */
    private String drpID_Date_Nyukin_Month;
    /** 入金日（日） */
    private String drpID_Date_Nyukin_Day;
    /** 留置期間利息 */
    private String txtID_M_RyuchiKikanRisoku;
    /** 代弁遅延損害金 */
    private String txtID_M_DaibenChienSongai;
    /** 送金額 */
    private String txtID_M_Sokin;
    /** 受託者勘定処理年月 */
    private String txtID_Date_Jtkshori;
    /** 受託者勘定処理年月（元号） */
    private String drpID_Date_Jtkshori_Gengou;
    /** 受託者勘定処理年月（年） */
    private String txtID_Date_Jtkshori_Year_Input;
    /** 受託者勘定処理年月（月） */
    private String drpID_Date_Jtkshori_Month;
    /** 送金年月日（元号） */
    private String drpID_Date_Sokin_Gengou;
    /** 送金年月日（年） */
    private String txtID_Date_Sokin_Year_Input;
    /** 送金年月日（月） */
    private String drpID_Date_Sokin_Month;
    /** 送金年月日（日） */
    private String drpID_Date_Sokin_Day;
    /** 送金日番号 */
    private String txtID_Code_Sokin;
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
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @return 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
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
    public String getTxtID_Date_Nyukin_Year_Input() {
        return txtID_Date_Nyukin_Year_Input;
    }

    /**
     * 入金日（年）を設定します。
     * @param txtID_Date_Nyukin_Year_Input 入金日（年）
     */
    public void setTxtID_Date_Nyukin_Year_Input(String txtID_Date_Nyukin_Year_Input) {
        this.txtID_Date_Nyukin_Year_Input = txtID_Date_Nyukin_Year_Input;
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
     * 留置期間利息を取得します。
     * @return 留置期間利息
     */
    public String getTxtID_M_RyuchiKikanRisoku() {
        return txtID_M_RyuchiKikanRisoku;
    }

    /**
     * 留置期間利息を設定します。
     * @param txtID_M_RyuchiKikanRisoku 留置期間利息
     */
    public void setTxtID_M_RyuchiKikanRisoku(String txtID_M_RyuchiKikanRisoku) {
        this.txtID_M_RyuchiKikanRisoku = txtID_M_RyuchiKikanRisoku;
    }

    /**
     * 代弁遅延損害金を取得します。
     * @return 代弁遅延損害金
     */
    public String getTxtID_M_DaibenChienSongai() {
        return txtID_M_DaibenChienSongai;
    }

    /**
     * 代弁遅延損害金を設定します。
     * @param txtID_M_DaibenChienSongai 代弁遅延損害金
     */
    public void setTxtID_M_DaibenChienSongai(String txtID_M_DaibenChienSongai) {
        this.txtID_M_DaibenChienSongai = txtID_M_DaibenChienSongai;
    }

    /**
     * 送金額を取得します。
     * @return 送金額
     */
    public String getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額を設定します。
     * @param txtID_M_Sokin 送金額
     */
    public void setTxtID_M_Sokin(String txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getTxtID_Date_Jtkshori() {
        return txtID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param txtID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setTxtID_Date_Jtkshori(String txtID_Date_Jtkshori) {
        this.txtID_Date_Jtkshori = txtID_Date_Jtkshori;
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
    public String getTxtID_Date_Jtkshori_Year_Input() {
        return txtID_Date_Jtkshori_Year_Input;
    }

    /**
     * 受託者勘定処理年月（年）を設定します。
     * @param txtID_Date_Jtkshori_Year_Input 受託者勘定処理年月（年）
     */
    public void setTxtID_Date_Jtkshori_Year_Input(String txtID_Date_Jtkshori_Year_Input) {
        this.txtID_Date_Jtkshori_Year_Input = txtID_Date_Jtkshori_Year_Input;
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
    public String getTxtID_Date_Sokin_Year_Input() {
        return txtID_Date_Sokin_Year_Input;
    }

    /**
     * 送金年月日（年）を設定します。
     * @param txtID_Date_Sokin_Year_Input 送金年月日（年）
     */
    public void setTxtID_Date_Sokin_Year_Input(String txtID_Date_Sokin_Year_Input) {
        this.txtID_Date_Sokin_Year_Input = txtID_Date_Sokin_Year_Input;
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