//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_12DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_12.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe006_12のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_12DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
    /** 仮受金(一般口)受入額 */
    private java.math.BigDecimal lblID_M_KariukeIppanUkeire;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori;
    /** 送金年月日 */
    private String lblID_Date_Sokin;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_12DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Se006_12DTO(Se006_12DTO orig) {
        super(orig);
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
     * 仮受金(一般口)受入額を取得します。
     * @return 仮受金(一般口)受入額
     */
    public java.math.BigDecimal getLblID_M_KariukeIppanUkeire() {
        return lblID_M_KariukeIppanUkeire;
    }

    /**
     * 仮受金(一般口)受入額を設定します。
     * @param lblID_M_KariukeIppanUkeire 仮受金(一般口)受入額
     */
    public void setLblID_M_KariukeIppanUkeire(java.math.BigDecimal lblID_M_KariukeIppanUkeire) {
        this.lblID_M_KariukeIppanUkeire = lblID_M_KariukeIppanUkeire;
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