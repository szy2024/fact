//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_05Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_05.web;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはse006_05のFormクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_05Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージ */
    private String lblMessage;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告年月日 */
    private String ID_Date_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** データコード */
    private String ID_DataCode;
    /** 顧客名 */
    private String ID_Name_Customer;
    /** 扱店名 */
    private String ID_Name_Organization;
    /** 公庫支店 */
    private String ID_Code_KoukoShiten;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Kubun_Hoshiki;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 資金使途 */
    private String ID_Code_ShikinShito;
    /** 事業別 */
    private String ID_Code_Jigyobetsu;
    /** 利率 */
    private String ID_Riritsu;
    /** 特利コード */
    private String ID_Kubun_Tokuri;
    /** 特利 */
    private String ID_Tokuri;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 貸付実行日 */
    private String ID_Date_Kashitsukejikko;
    /** 貸付実行金額 */
    @NumberFormat(pattern = "#,###")
    private BigDecimal ID_M_Kashitsuke;
    /** 資金交付額 */
    @NumberFormat(pattern = "#,###")
    private BigDecimal ID_M_ShikinKofu;
    /** 貸付受入金受入額 */
    @NumberFormat(pattern = "#,###")
    private BigDecimal ID_M_KashitsukeUkeire;

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
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param ID_ID_Report 報告書番号
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getID_Date_Report() {
        return ID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param ID_Date_Report 報告年月日
     */
    public void setID_Date_Report(String ID_Date_Report) {
        this.ID_Date_Report = ID_Date_Report;
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param ID_Time_Report 報告時分秒
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコードを設定します。
     * @param ID_DataCode データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getID_Name_Customer() {
        return ID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param ID_Name_Customer 顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        this.ID_Name_Customer = ID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getID_Name_Organization() {
        return ID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param ID_Name_Organization 扱店名
     */
    public void setID_Name_Organization(String ID_Name_Organization) {
        this.ID_Name_Organization = ID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getID_Code_KoukoShiten() {
        return ID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param ID_Code_KoukoShiten 公庫支店
     */
    public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
        this.ID_Code_KoukoShiten = ID_Code_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getID_Kubun_Hoshiki() {
        return ID_Kubun_Hoshiki;
    }

    /**
     * 方式資金を設定します。
     * @param ID_Kubun_Hoshiki 方式資金
     */
    public void setID_Kubun_Hoshiki(String ID_Kubun_Hoshiki) {
        this.ID_Kubun_Hoshiki = ID_Kubun_Hoshiki;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 資金使途を取得します。
     * @return 資金使途
     */
    public String getID_Code_ShikinShito() {
        return ID_Code_ShikinShito;
    }

    /**
     * 資金使途を設定します。
     * @param ID_Name_ShikinShito 資金使途
     */
    public void setID_Code_ShikinShito(String ID_Name_ShikinShito) {
        this.ID_Code_ShikinShito = ID_Name_ShikinShito;
    }

    /**
     * 事業別を取得します。
     * @return 事業別
     */
    public String getID_Code_Jigyobetsu() {
        return ID_Code_Jigyobetsu;
    }

    /**
     * 事業別を設定します。
     * @param ID_Code_Jigyobetsu 事業別
     */
    public void setID_Code_Jigyobetsu(String ID_Code_Jigyobetsu) {
        this.ID_Code_Jigyobetsu = ID_Code_Jigyobetsu;
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率を設定します。
     * @param ID_Riritsu 利率
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
    }

    /**
     * 特利コードを取得します。
     * @return 特利コード
     */
    public String getID_Kubun_Tokuri() {
        return ID_Kubun_Tokuri;
    }

    /**
     * 特利コードを設定します。
     * @param ID_Kubun_Tokuri 特利コード
     */
    public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
        this.ID_Kubun_Tokuri = ID_Kubun_Tokuri;
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利を設定します。
     * @param ID_Tokuri 特利
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen 据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen 償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getID_Date_Jtkshori() {
        return ID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param ID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
        this.ID_Date_Jtkshori = ID_Date_Jtkshori;
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Kashitsukejikko() {
        return ID_Date_Kashitsukejikko;
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Kashitsukejikko 貸付実行日
     */
    public void setID_Date_Kashitsukejikko(String ID_Date_Kashitsukejikko) {
        this.ID_Date_Kashitsukejikko = ID_Date_Kashitsukejikko;
    }

    /**
     * 貸付実行金額を取得します。
     * @return 貸付実行金額
     */
    public BigDecimal getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付実行金額を設定します。
     * @param ID_M_Kashitsuke 貸付実行金額
     */
    public void setID_M_Kashitsuke(BigDecimal ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 資金交付額を取得します。
     * @return 資金交付額
     */
    public BigDecimal getID_M_ShikinKofu() {
        return ID_M_ShikinKofu;
    }

    /**
     * 資金交付額を設定します。
     * @param ID_M_ShikinKofu 資金交付額
     */
    public void setID_M_ShikinKofu(BigDecimal ID_M_ShikinKofu) {
        this.ID_M_ShikinKofu = ID_M_ShikinKofu;
    }

    /**
     * 貸付受入金受入額を取得します。
     * @return 貸付受入金受入額
     */
    public BigDecimal getID_M_KashitsukeUkeire() {
        return ID_M_KashitsukeUkeire;
    }

    /**
     * 貸付受入金受入額を設定します。
     * @param ID_M_KashitsukeUkeire 貸付受入金受入額
     */
    public void setID_M_KashitsukeUkeire(BigDecimal ID_M_KashitsukeUkeire) {
        this.ID_M_KashitsukeUkeire = ID_M_KashitsukeUkeire;
    }

}