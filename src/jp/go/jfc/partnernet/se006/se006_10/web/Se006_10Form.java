//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_10Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_10.web;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはSe006_10のFormクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_10Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ステータス */
    private String lblError;
    /** メッセージ */
    private String lblMessage;
    /** 報告書番号 */
    private String lblID_ID_Report;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 報告時分秒 */
    private String lblID_Time_Report;
    /** 顧客名 */
    private String lblID_Name_Customer;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 公庫支店 */
    private String lblID_Code_KoukoShiten;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 年度 */
    private String lblID_Year;
    /** 方式資金 */
    private String lblID_Code_HoshikiShikin;
    /** 番号 */
    private String lblID_ID_Ringi;
    /** 枝番 */
    private String lblID_ID_RingiBranch;
    /** 入金日 */
    private String lblID_Date_Nyukin;
    /** 立替金利息(円) */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_TatekaeRisoku;
    /** 立替金(円) */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_Tatekae;
    /** 仮受金(一般口)からの充当額 */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_KariukeIppanJuto;
    /** 立替金の種類 */
    private String lblID_Code_TatekaekinShurui;
    /** 公庫立替日 */
    private String lblID_Date_KoukoTatekae;
    /** 計(円) */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_Kei;
    /** 送金額(円) */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_Sokin;
    /** 受入後立替金残高(円) */
    @NumberFormat(pattern = "#,###")
    private BigDecimal lblID_M_TatekaeZanAfterUkeire;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori;
    /** 送金年月日 */
    private String lblID_Date_Sokin;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi;

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getLblID_ID_Report() {
        return lblID_ID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param lblID_ID_Report 報告書番号
     */
    public void setLblID_ID_Report(String lblID_ID_Report) {
        this.lblID_ID_Report = lblID_ID_Report;
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
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getLblID_Time_Report() {
        return lblID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param lblID_Time_Report 報告時分秒
     */
    public void setLblID_Time_Report(String lblID_Time_Report) {
        this.lblID_Time_Report = lblID_Time_Report;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param lblID_Name_Customer 顧客名
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getLblID_Code_KoukoShiten() {
        return lblID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_KoukoShiten 公庫支店
     */
    public void setLblID_Code_KoukoShiten(String lblID_Code_KoukoShiten) {
        this.lblID_Code_KoukoShiten = lblID_Code_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization 扱店
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo 店舗
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度を設定します。
     * @param lblID_Year 年度
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Code_HoshikiShikin 方式資金
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param lblID_ID_Ringi 番号
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param lblID_ID_RingiBranch 枝番
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日を設定します。
     * @param lblID_Date_Nyukin 入金日
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }

    /**
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public BigDecimal getLblID_M_TatekaeRisoku() {
        return lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金利息(円)を設定します。
     * @param lblID_M_TatekaeRisoku 立替金利息(円)
     */
    public void setLblID_M_TatekaeRisoku(BigDecimal lblID_M_TatekaeRisoku) {
        this.lblID_M_TatekaeRisoku = lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金(円)を取得します。
     * @return 立替金(円)
     */
    public BigDecimal getLblID_M_Tatekae() {
        return lblID_M_Tatekae;
    }

    /**
     * 立替金(円)を設定します。
     * @param lblID_M_Tatekae 立替金(円)
     */
    public void setLblID_M_Tatekae(BigDecimal lblID_M_Tatekae) {
        this.lblID_M_Tatekae = lblID_M_Tatekae;
    }

    /**
     * 仮受金(一般口)からの充当額を取得します。
     * @return 仮受金(一般口)からの充当額
     */
    public BigDecimal getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額を設定します。
     * @param lblID_M_KariukeIppanJuto 仮受金(一般口)からの充当額
     */
    public void setLblID_M_KariukeIppanJuto(BigDecimal lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }

    /**
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getLblID_Code_TatekaekinShurui() {
        return lblID_Code_TatekaekinShurui;
    }

    /**
     * 立替金の種類を設定します。
     * @param lblID_Code_TatekaekinShurui 立替金の種類
     */
    public void setLblID_Code_TatekaekinShurui(String lblID_Code_TatekaekinShurui) {
        this.lblID_Code_TatekaekinShurui = lblID_Code_TatekaekinShurui;
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getLblID_Date_KoukoTatekae() {
        return lblID_Date_KoukoTatekae;
    }

    /**
     * 公庫立替日を設定します。
     * @param lblID_Date_KoukoTatekae 公庫立替日
     */
    public void setLblID_Date_KoukoTatekae(String lblID_Date_KoukoTatekae) {
        this.lblID_Date_KoukoTatekae = lblID_Date_KoukoTatekae;
    }

    /**
     * 計(円)を取得します。
     * @return 計(円)
     */
    public BigDecimal getLblID_M_Kei() {
        return lblID_M_Kei;
    }

    /**
     * 計(円)を設定します。
     * @param lblID_M_Kei 計(円)
     */
    public void setLblID_M_Kei(BigDecimal lblID_M_Kei) {
        this.lblID_M_Kei = lblID_M_Kei;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public BigDecimal getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額(円)を設定します。
     * @param lblID_M_Sokin 送金額(円)
     */
    public void setLblID_M_Sokin(BigDecimal lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
    }

    /**
     * 受入後立替金残高(円)を取得します。
     * @return 受入後立替金残高(円)
     */
    public BigDecimal getLblID_M_TatekaeZanAfterUkeire() {
        return lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受入後立替金残高(円)を設定します。
     * @param lblID_M_TatekaeZanAfterUkeire 受入後立替金残高(円)
     */
    public void setLblID_M_TatekaeZanAfterUkeire(BigDecimal lblID_M_TatekaeZanAfterUkeire) {
        this.lblID_M_TatekaeZanAfterUkeire = lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_Jtkshori() {
        return lblID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param lblID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setLblID_Date_Jtkshori(String lblID_Date_Jtkshori) {
        this.lblID_Date_Jtkshori = lblID_Date_Jtkshori;
    }

    /**
     * 送金年月日を取得します。
     * @return 送金年月日
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金年月日を設定します。
     * @param lblID_Date_Sokin 送金年月日
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_ID_Sokinbi 送金日番号
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
    }

}