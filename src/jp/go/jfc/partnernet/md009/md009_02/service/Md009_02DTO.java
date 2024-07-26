//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはMd009_02のDTOクラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public class Md009_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 扱店名 */
    private String lblID_Name_Organization_Red;
    /** 公庫支店 */
    private String lblID_Code_ShokanHonShiten_Red;
    /** 扱店 */
    private String lblID_Code_Organization_Red;
    /** 店舗 */
    private String lblID_Code_Tenpo_Red;
    /** 入金日 */
    private String lblID_Date_Nyukin_Red;
    /** 留置期間利息 */
    private String lblID_M_RyuchiKikanRisoku_Red;
    /** 代弁遅延損害金 */
    private String lblID_M_DaibenChienSongai_Red;
    /** 送金額 */
    private String lblID_M_Sokin_Red;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori_Red;
    /** 送金年月日 */
    private String lblID_Date_Sokin_Red;
    /** 送金日番号 */
    private String lblID_Code_Sokin_Red;
    /** 扱店名（修正） */
    private String lblID_Name_Organization;
    /** 公庫支店（修正） */
    private String lblID_Code_ShokanHonShiten;
    /** 扱店（修正） */
    private String lblID_Code_Organization;
    /** 店舗（修正） */
    private String lblID_Code_Tenpo;
    /** 入金日（修正） */
    private String lblID_Date_Nyukin;
    /** 留置期間利息（修正） */
    private String lblID_M_RyuchiKikanRisoku;
    /** 代弁遅延損害金（修正） */
    private String lblID_M_DaibenChienSongai;
    /** 送金額（修正） */
    private String lblID_M_Sokin;
    /** 受託者勘定処理年月（修正） */
    private String lblID_Date_Jtkshori;
    /** 送金年月日（修正） */
    private String lblID_Date_Sokin;
    /** 送金日番号（修正） */
    private String lblID_Code_Sokin;
    /** 報告書番号 */
    private String ID_Report;
    /** 履歴番号 */
    private String ID_History;
    /** ステータス */
    private String ID_Status;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 報告書種別（値） */
    private String ID_DataCode;
    /** 退避履歴番号 */
    private String ID_Keep_ID_History;
    /** 最新更新年月日 */
    private String ID_Data_LastUpDate;
    /** 処理モード */
    private String processMode;
    /** 検索結果件数 */
    private int recCount;
    /** 更新日時 */
    private String updateDateTime;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md009_02DTO() {
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
    public Md009_02DTO(Md009_02DTO orig) {
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
     * 留置期間利息を取得します。
     * @return 留置期間利息
     */
    public String getLblID_M_RyuchiKikanRisoku_Red() {
        return lblID_M_RyuchiKikanRisoku_Red;
    }

    /**
     * 留置期間利息を設定します。
     * @param lblID_M_RyuchiKikanRisoku_Red 留置期間利息
     */
    public void setLblID_M_RyuchiKikanRisoku_Red(String lblID_M_RyuchiKikanRisoku_Red) {
        this.lblID_M_RyuchiKikanRisoku_Red = lblID_M_RyuchiKikanRisoku_Red;
    }

    /**
     * 代弁遅延損害金を取得します。
     * @return 代弁遅延損害金
     */
    public String getLblID_M_DaibenChienSongai_Red() {
        return lblID_M_DaibenChienSongai_Red;
    }

    /**
     * 代弁遅延損害金を設定します。
     * @param lblID_M_DaibenChienSongai_Red 代弁遅延損害金
     */
    public void setLblID_M_DaibenChienSongai_Red(String lblID_M_DaibenChienSongai_Red) {
        this.lblID_M_DaibenChienSongai_Red = lblID_M_DaibenChienSongai_Red;
    }

    /**
     * 送金額を取得します。
     * @return 送金額
     */
    public String getLblID_M_Sokin_Red() {
        return lblID_M_Sokin_Red;
    }

    /**
     * 送金額を設定します。
     * @param lblID_M_Sokin_Red 送金額
     */
    public void setLblID_M_Sokin_Red(String lblID_M_Sokin_Red) {
        this.lblID_M_Sokin_Red = lblID_M_Sokin_Red;
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
     * 留置期間利息（修正）を取得します。
     * @return 留置期間利息（修正）
     */
    public String getLblID_M_RyuchiKikanRisoku() {
        return lblID_M_RyuchiKikanRisoku;
    }

    /**
     * 留置期間利息（修正）を設定します。
     * @param lblID_M_RyuchiKikanRisoku 留置期間利息（修正）
     */
    public void setLblID_M_RyuchiKikanRisoku(String lblID_M_RyuchiKikanRisoku) {
        this.lblID_M_RyuchiKikanRisoku = lblID_M_RyuchiKikanRisoku;
    }

    /**
     * 代弁遅延損害金（修正）を取得します。
     * @return 代弁遅延損害金（修正）
     */
    public String getLblID_M_DaibenChienSongai() {
        return lblID_M_DaibenChienSongai;
    }

    /**
     * 代弁遅延損害金（修正）を設定します。
     * @param lblID_M_DaibenChienSongai 代弁遅延損害金（修正）
     */
    public void setLblID_M_DaibenChienSongai(String lblID_M_DaibenChienSongai) {
        this.lblID_M_DaibenChienSongai = lblID_M_DaibenChienSongai;
    }

    /**
     * 送金額（修正）を取得します。
     * @return 送金額（修正）
     */
    public String getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額（修正）を設定します。
     * @param lblID_M_Sokin 送金額（修正）
     */
    public void setLblID_M_Sokin(String lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
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
     * 履歴番号を取得します。
     * @return 報告書番号
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータスを設定します。
     * @param ID_Status ステータス
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
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
     * @param ID_Type_Process 処理種別
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
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
     * @param ID_DataCode 報告書種別（値）
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
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
     * @param ID_Keep_ID_History 退避履歴番号
     */
    public void setID_Keep_ID_History(String ID_Keep_ID_History) {
        this.ID_Keep_ID_History = ID_Keep_ID_History;
    }

    /**
     * 最新更新年月日を取得します。
     * @return 報告書最新更新年月日
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新更新年月日を設定します。
     * @param ID_Data_LastUpDate 最新更新年月日
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
     * 検索結果件数を取得します。
     *
     * @return 検索結果件数
     */
    public int getRecCount() {
        return recCount;
    }

    /**
     * 検索結果件数を設定します。
     * @param recCount 検索結果件数
     */
    public void setRecCount(int recCount) {
        this.recCount = recCount;
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