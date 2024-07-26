//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはMd008_02のDTOクラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class Md008_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 顧客名 */
    private String lblID_Name_Customer_Red;
    /** 扱店名 */
    private String lblID_Name_Organization_Red;
    /** 公庫支店 */
    private String lblID_Code_ShokanHonShiten_Red;
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
    /** 入金日 */
    private String lblID_Date_Nyukin_Red;
    /** 仮受金（一般口）受入額 */
    private String lblID_M_KariukeIppanUkeire_Red;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori_Red;
    /** 送金日 */
    private String lblID_Date_Sokin_Red;
    /** 送金日番号 */
    private String lblID_Code_Sokin_Red;
    /** ステータス */
    private String ID_Status;
    /** 履歴番号 */
    private String ID_History;
    /** 報告書番号 */
    private String ID_Report;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 報告書種別（値） */
    private String ID_DataCode;
    /** 処理モード */
    private String ProcessMode;
    /** 退避履歴番号 */
    private String ID_Keep_ID_History;
    /** 報告書最新更新年月日 */
    private String ID_Data_LastUpDate;
    /** 顧客名（修正） */
    private String lblID_Name_Customer;
    /** 扱店名（修正） */
    private String lblID_Name_Organization;
    /** 公庫支店（修正） */
    private String lblID_Code_ShokanHonShiten;
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
    /** 入金日（修正） */
    private String lblID_Date_Nyukin;
    /** 仮受金（一般口）受入額（修正） */
    private String lblID_M_KariukeIppanUkeire;
    /** 受託者勘定処理年月（修正） */
    private String lblID_Date_Jtkshori;
    /** 送金年月日（修正） */
    private String lblID_Date_Sokin;
    /** 送金日番号（修正） */
    private String lblID_Code_Sokin;
    /** 取得データ件数 */
    private int RecordCount;
    /** 更新日時 */
    private String updateDateTime;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md008_02DTO() {
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
    public Md008_02DTO(Md008_02DTO orig) {
        super(orig);
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
    public String getLblID_Code_ShokanHonShiten_Red() {
        return lblID_Code_ShokanHonShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_ShokanHonShiten_Red 公庫支店
     */
    public void setLblID_Code_ShokanHonShiten_Red(String lblID_Code_ShokanHonShiten_Red) {
        this.lblID_Code_ShokanHonShiten_Red = lblID_Code_ShokanHonShiten_Red;
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
    public String getLblID_Code_HoshikiShikin_Red() {
        return lblID_Code_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Code_HoshikiShikin_Red 方式資金
     */
    public void setLblID_Code_HoshikiShikin_Red(String lblID_Code_HoshikiShikin_Red) {
        this.lblID_Code_HoshikiShikin_Red = lblID_Code_HoshikiShikin_Red;
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
     * 仮受金（一般口）受入額を取得します。
     * @return 仮受金（一般口）受入額
     */
    public String getLblID_M_KariukeIppanUkeire_Red() {
        return lblID_M_KariukeIppanUkeire_Red;
    }

    /**
     * 仮受金（一般口）受入額を設定します。
     * @param lblID_M_KariukeIppanUkeire_Red 仮受金（一般口）受入額
     */
    public void setLblID_M_KariukeIppanUkeire_Red(String lblID_M_KariukeIppanUkeire_Red) {
        this.lblID_M_KariukeIppanUkeire_Red = lblID_M_KariukeIppanUkeire_Red;
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
     * 送金日を取得します。
     * @return 送金日
     */
    public String getLblID_Date_Sokin_Red() {
        return lblID_Date_Sokin_Red;
    }

    /**
     * 送金日を設定します。
     * @param lblID_Date_Sokin_Red 送金日
     */
    public void setLblID_Date_Sokin_Red(String lblID_Date_Sokin_Red) {
        this.lblID_Date_Sokin_Red = lblID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_Code_Sokin_Red() {
        return lblID_Code_Sokin_Red;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_Code_Sokin_Red 送金日番号
     */
    public void setLblID_Code_Sokin_Red(String lblID_Code_Sokin_Red) {
        this.lblID_Code_Sokin_Red = lblID_Code_Sokin_Red;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータスを設定します。
     * @param iD_Status ステータス
     */
    public void setID_Status(String iD_Status) {
        ID_Status = iD_Status;
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
     * @param iD_History 履歴番号
     */
    public void setID_History(String iD_History) {
        ID_History = iD_History;
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
     * @param iD_Report 報告書番号
     */
    public void setID_Report(String iD_Report) {
        ID_Report = iD_Report;
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
    }

    /**
     * 処理種別を設定します。
     * @param iD_Type_Process 処理種別
     */
    public void setID_Type_Process(String iD_Type_Process) {
        ID_Type_Process = iD_Type_Process;
    }

    /**
     * 報告書種別（値）を取得します。
     * @return 報告書種別（値）
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * 報告書種別（値）を設定します。
     * @param iD_DataCode 報告書種別（値）
     */
    public void setID_DataCode(String iD_DataCode) {
        ID_DataCode = iD_DataCode;
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
     * @param processMode 処理モード
     */
    public void setProcessMode(String processMode) {
        ProcessMode = processMode;
    }

    /**
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getID_Keep_ID_History() {
        return ID_Keep_ID_History;
    }

    /**
     * 退避履歴番号を設定します。
     * @param iD_Keep_ID_History 退避履歴番号
     */
    public void setID_Keep_ID_History(String iD_Keep_ID_History) {
        ID_Keep_ID_History = iD_Keep_ID_History;
    }

    /**
     * 報告書最新更新年月日を取得します。
     * @return 報告書最新更新年月日
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 報告書最新更新年月日を設定します。
     * @param iD_Data_LastUpDate 報告書最新更新年月日
     */
    public void setID_Data_LastUpDate(String iD_Data_LastUpDate) {
        ID_Data_LastUpDate = iD_Data_LastUpDate;
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
    public String getLblID_Code_ShokanHonShiten() {
        return lblID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店（修正）を設定します。
     * @param lblID_Code_ShokanHonShiten 公庫支店（修正）
     */
    public void setLblID_Code_ShokanHonShiten(String lblID_Code_ShokanHonShiten) {
        this.lblID_Code_ShokanHonShiten = lblID_Code_ShokanHonShiten;
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
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金（修正）を設定します。
     * @param lblID_Code_HoshikiShikin 方式資金（修正）
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
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
     * 仮受金（一般口）受入額（修正）を取得します。
     * @return 仮受金（一般口）受入額（修正）
     */
    public String getLblID_M_KariukeIppanUkeire() {
        return lblID_M_KariukeIppanUkeire;
    }

    /**
     * 仮受金（一般口）受入額（修正）を設定します。
     * @param lblID_M_KariukeIppanUkeire 仮受金（一般口）受入額（修正）
     */
    public void setLblID_M_KariukeIppanUkeire(String lblID_M_KariukeIppanUkeire) {
        this.lblID_M_KariukeIppanUkeire = lblID_M_KariukeIppanUkeire;
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
    public String getLblID_Code_Sokin() {
        return lblID_Code_Sokin;
    }

    /**
     * 送金日番号（修正）を設定します。
     * @param lblID_Code_Sokin 送金日番号（修正）
     */
    public void setLblID_Code_Sokin(String lblID_Code_Sokin) {
        this.lblID_Code_Sokin = lblID_Code_Sokin;
    }

    /**
     * 取得データ件数を取得します。
     * @return 取得データ件数
     */
    public int getRecordCount() {
        return RecordCount;
    }

    /**
     * 取得データ件数を設定します。
     * @param recordCount 取得データ件数
     */
    public void setRecordCount(int recordCount) {
        RecordCount = recordCount;
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public String getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * 更新日時を設定します。
     * @param updateDateTime 更新日時
     */
    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}