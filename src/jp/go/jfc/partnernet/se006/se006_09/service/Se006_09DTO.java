//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_09DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_09.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe006_09のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_09DTO extends PNBaseDTO {

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
    private String ID_Code_HoshikiShikin;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 充当対象払込期日 */
    private String ID_Date_JutoTaisho;
    /** 代弁金払込日 */
    private String ID_Date_DaibenkinHaraikomi;
    /** 遅延損害金(円) */
    private java.math.BigDecimal ID_M_ChienSongai;
    /** 利息(円) */
    private java.math.BigDecimal ID_M_Risoku;
    /** 繰上償還手数料(円) */
    private java.math.BigDecimal ID_M_KurishoCommission;
    /** 元金(円) */
    private java.math.BigDecimal ID_M_Gankin;
    /** 仮受金(一般口)からの充当額(円) */
    private java.math.BigDecimal ID_M_KariukeIppanJuto;
    /** 計(円) */
    private java.math.BigDecimal ID_M_Kei;
    /** 送金額(円) */
    private java.math.BigDecimal ID_M_Sokin;
    /** 代弁金充当後残元金(円) */
    private java.math.BigDecimal ID_M_ZanGanAfterDaibenJuto;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 送金日 */
    private String ID_Date_Sokin;
    /** 送金日番号 */
    private String ID_ID_Sokinbi;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_09DTO() {
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
    public Se006_09DTO(Se006_09DTO orig) {
        super(orig);
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getlblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setlblMessage(String lblMessage) {
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
    public String getID_Code_HoshikiShikin() {
        return ID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param ID_Code_HoshikiShikin 方式資金
     */
    public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
        this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
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
     * 充当対象払込期日を取得します。
     * @return 充当対象払込期日
     */
    public String getID_Date_JutoTaisho() {
        return ID_Date_JutoTaisho;
    }

    /**
     * 充当対象払込期日を設定します。
     * @param ID_Date_JutoTaisho 充当対象払込期日
     */
    public void setID_Date_JutoTaisho(String ID_Date_JutoTaisho) {
        this.ID_Date_JutoTaisho = ID_Date_JutoTaisho;
    }

    /**
     * 代弁金払込日を取得します。
     * @return 代弁金払込日
     */
    public String getID_Date_DaibenkinHaraikomi() {
        return ID_Date_DaibenkinHaraikomi;
    }

    /**
     * 代弁金払込日を設定します。
     * @param ID_Date_DaibenkinHaraikomi 代弁金払込日
     */
    public void setID_Date_DaibenkinHaraikomi(String ID_Date_DaibenkinHaraikomi) {
        this.ID_Date_DaibenkinHaraikomi = ID_Date_DaibenkinHaraikomi;
    }

    /**
     * 遅延損害金(円)を取得します。
     * @return 遅延損害金(円)
     */
    public java.math.BigDecimal getID_M_ChienSongai() {
        return ID_M_ChienSongai;
    }

    /**
     * 遅延損害金(円)を設定します。
     * @param ID_M_ChienSongai 遅延損害金(円)
     */
    public void setID_M_ChienSongai(java.math.BigDecimal ID_M_ChienSongai) {
        this.ID_M_ChienSongai = ID_M_ChienSongai;
    }

    /**
     * 利息(円)を取得します。
     * @return 利息(円)
     */
    public java.math.BigDecimal getID_M_Risoku() {
        return ID_M_Risoku;
    }

    /**
     * 利息(円)を設定します。
     * @param ID_M_Risoku 利息(円)
     */
    public void setID_M_Risoku(java.math.BigDecimal ID_M_Risoku) {
        this.ID_M_Risoku = ID_M_Risoku;
    }

    /**
     * 繰上償還手数料(円)を取得します。
     * @return 繰上償還手数料(円)
     */
    public java.math.BigDecimal getID_M_KurishoCommission() {
        return ID_M_KurishoCommission;
    }

    /**
     * 繰上償還手数料(円)を設定します。
     * @param ID_M_KurishoCommission 繰上償還手数料(円)
     */
    public void setID_M_KurishoCommission(java.math.BigDecimal ID_M_KurishoCommission) {
        this.ID_M_KurishoCommission = ID_M_KurishoCommission;
    }

    /**
     * 元金(円)を取得します。
     * @return 元金(円)
     */
    public java.math.BigDecimal getID_M_Gankin() {
        return ID_M_Gankin;
    }

    /**
     * 元金(円)を設定します。
     * @param ID_M_Gankin 元金(円)
     */
    public void setID_M_Gankin(java.math.BigDecimal ID_M_Gankin) {
        this.ID_M_Gankin = ID_M_Gankin;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     * @return 仮受金(一般口)からの充当額(円)
     */
    public java.math.BigDecimal getID_M_KariukeIppanJuto() {
        return ID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     * @param ID_M_KariukeIppanJuto 仮受金(一般口)からの充当額(円)
     */
    public void setID_M_KariukeIppanJuto(java.math.BigDecimal ID_M_KariukeIppanJuto) {
        this.ID_M_KariukeIppanJuto = ID_M_KariukeIppanJuto;
    }

    /**
     * 計(円)を取得します。
     * @return 計(円)
     */
    public java.math.BigDecimal getID_M_Kei() {
        return ID_M_Kei;
    }

    /**
     * 計(円)を設定します。
     * @param ID_M_Kei 計(円)
     */
    public void setID_M_Kei(java.math.BigDecimal ID_M_Kei) {
        this.ID_M_Kei = ID_M_Kei;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public java.math.BigDecimal getID_M_Sokin() {
        return ID_M_Sokin;
    }

    /**
     * 送金額(円)を設定します。
     * @param ID_M_Sokin 送金額(円)
     */
    public void setID_M_Sokin(java.math.BigDecimal ID_M_Sokin) {
        this.ID_M_Sokin = ID_M_Sokin;
    }

    /**
     * 代弁金充当後残元金(円)を取得します。
     * @return 代弁金充当後残元金(円)
     */
    public java.math.BigDecimal getID_M_ZanGanAfterDaibenJuto() {
        return ID_M_ZanGanAfterDaibenJuto;
    }

    /**
     * 代弁金充当後残元金(円)を設定します。
     * @param ID_M_ZanGanAfterDaibenJuto 代弁金充当後残元金(円)
     */
    public void setID_M_ZanGanAfterDaibenJuto(java.math.BigDecimal ID_M_ZanGanAfterDaibenJuto) {
        this.ID_M_ZanGanAfterDaibenJuto = ID_M_ZanGanAfterDaibenJuto;
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
     * 送金日を取得します。
     * @return 送金日
     */
    public String getID_Date_Sokin() {
        return ID_Date_Sokin;
    }

    /**
     * 送金日を設定します。
     * @param ID_Date_Sokin 送金日
     */
    public void setID_Date_Sokin(String ID_Date_Sokin) {
        this.ID_Date_Sokin = ID_Date_Sokin;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getID_ID_Sokinbi() {
        return ID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param ID_ID_Sokinbi 送金日番号
     */
    public void setID_ID_Sokinbi(String ID_ID_Sokinbi) {
        this.ID_ID_Sokinbi = ID_ID_Sokinbi;
    }

}