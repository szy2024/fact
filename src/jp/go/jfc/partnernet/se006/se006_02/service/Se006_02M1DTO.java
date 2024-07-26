//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse006_02のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 報告書種別 */
    private String lblID_RyakusyouName_Report;

    /** 履歴番号 */
    private String ID_ID_History;
    /** 報告年月日 */
    private String ID_Date_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** 扱店コード */
    private String ID_Code_Organization;
    /** 扱店名 */
    private String ID_Name_Organization;
    /** 融資番号 */
    private String ID_Yuushi_Number;
    /** 融資番号(公庫支店) */
    private String ID_YN_Code_ShokanHonShiten;
    /** 融資番号(扱店) */
    private String ID_YN_Code_Organization;
    /** 融資番号（店舗） */
    private String ID_YN_Code_Tenpo;
    /** 融資番号（年度） */
    private String ID_YN_Year;
    /** 融資番号（方式資金） */
    private String ID_YN_Kubun_HoshikiShikin;
    /** 融資番号（番号） */
    private String ID_YN_Ringi;
    /** 融資番号（枝番） */
    private String ID_YN_RingiBranch;
    /** 報告書種別 */
    private String ID_RyakusyouName_Report;
    /** 処理状況名称 */
    private String ID_RyakusyouName_Status;
    /** 処理状況 */
    private String ID_Status;
    /** データコード */
    private String ID_DataCode;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 処理種別 */
    private String ID_RyakusyouName_Process;
    /** 取消済 */
    private String ID_Flag_Torikeshizumi;
    /** 原本番号 */
    private String ID_ID_Master;
    /** エラーコード */
    private String ID_Code_Error;
    /** メッセージ */
    private String ID_ErrorMessage;
    /** 行番号 */
    private String Array_List_Index;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_02M1DTO() {
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
    public Se006_02M1DTO(Se006_02M1DTO orig) {
        super(orig);
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getlblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblid_name_organization
     *            扱店名
     */
    public void setlblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 報告書種別を取得します。
     *
     * @return 報告書種別
     */
    public String getlblID_RyakusyouName_Report() {
        return lblID_RyakusyouName_Report;
    }

    /**
     * 報告書種別を設定します。
     *
     * @param lblid_ryakusyouname_report
     *            報告書種別
     */
    public void setlblID_RyakusyouName_Report(String lblID_RyakusyouName_Report) {
        this.lblID_RyakusyouName_Report = lblID_RyakusyouName_Report;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param ID_ID_History 履歴番号
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getID_Date_Report() {
        return ID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param ID_Date_Report 報告年月日
     */
    public void setID_Date_Report(String ID_Date_Report) {
        this.ID_Date_Report = ID_Date_Report;
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param ID_Time_Report 報告時分秒
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     *
     * @param ID_Code_Organization 扱店コード
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getID_Name_Organization() {
        return ID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param ID_Name_Organization 扱店名
     */
    public void setID_Name_Organization(String ID_Name_Organization) {
        this.ID_Name_Organization = ID_Name_Organization;
    }

    /**
     * 融資番号を取得します。
     *
     * @return 融資番号
     */
    public String getID_Yuushi_Number() {
        return ID_Yuushi_Number;
    }

    /**
     * 融資番号を設定します。
     *
     * @param ID_Yuushi_Number 融資番号
     */
    public void setID_Yuushi_Number(String ID_Yuushi_Number) {
        this.ID_Yuushi_Number = ID_Yuushi_Number;
    }

    /**
     * 融資番号(公庫支店)を取得します。
     *
     * @return 融資番号(公庫支店)
     */
    public String getID_YN_Code_ShokanHonShiten() {
        return ID_YN_Code_ShokanHonShiten;
    }

    /**
     * 融資番号(公庫支店)を設定します。
     *
     * @param ID_Code_ShokanHonShiten 融資番号(公庫支店)
     */
    public void setID_YN_Code_ShokanHonShiten(String ID_YN_Code_ShokanHonShiten) {
        this.ID_YN_Code_ShokanHonShiten = ID_YN_Code_ShokanHonShiten;
    }

    /**
     * 融資番号(扱店)を取得します。
     *
     * @return 融資番号(扱店)
     */
    public String getID_YN_Code_Organization() {
        return ID_YN_Code_Organization;
    }

    /**
     * 融資番号(扱店)を設定します。
     *
     * @param ID_YN_Code_Organization 融資番号(扱店)
     */
    public void setID_YN_Code_Organization(String ID_YN_Code_Organization) {
        this.ID_YN_Code_Organization = ID_YN_Code_Organization;
    }

    /**
     * 融資番号（店舗）を取得します。
     *
     * @return 融資番号（店舗）
     */
    public String getID_YN_Code_Tenpo() {
        return ID_YN_Code_Tenpo;
    }

    /**
     * 融資番号（店舗）を設定します。
     *
     * @param ID_YN_Code_Tenpo 融資番号（店舗）
     */
    public void setID_YN_Code_Tenpo(String ID_YN_Code_Tenpo) {
        this.ID_YN_Code_Tenpo = ID_YN_Code_Tenpo;
    }

    /**
     * 融資番号（年度）を取得します。
     *
     * @return 融資番号（年度）
     */
    public String getID_YN_Year() {
        return ID_YN_Year;
    }

    /**
     * 融資番号（年度）を設定します。
     *
     * @param ID_Year 融資番号（年度）
     */
    public void setID_YN_Year(String ID_YN_Year) {
        this.ID_YN_Year = ID_YN_Year;
    }

    /**
     * 融資番号（方式資金）を取得します。
     *
     * @return 融資番号（方式資金）
     */
    public String getID_YN_Kubun_HoshikiShikin() {
        return ID_YN_Kubun_HoshikiShikin;
    }

    /**
     * 融資番号（方式資金）を設定します。
     *
     * @param ID_YN_Kubun_HoshikiShikin 融資番号（方式資金）
     */
    public void setID_YN_Kubun_HoshikiShikin(String ID_YN_Kubun_HoshikiShikin) {
        this.ID_YN_Kubun_HoshikiShikin = ID_YN_Kubun_HoshikiShikin;
    }

    /**
     * 融資番号（番号）を取得します。
     *
     * @return 融資番号（番号）
     */
    public String getID_YN_Ringi() {
        return ID_YN_Ringi;
    }

    /**
     * 融資番号（番号）を設定します。
     *
     * @param ID_YN_Ringi 融資番号（番号）
     */
    public void setID_YN_Ringi(String ID_YN_Ringi) {
        this.ID_YN_Ringi = ID_YN_Ringi;
    }

    /**
     * 融資番号（枝番）を取得します。
     *
     * @return 融資番号（枝番）
     */
    public String getID_YN_RingiBranch() {
        return ID_YN_RingiBranch;
    }

    /**
     * 融資番号（枝番）を設定します。
     *
     * @param ID_YN_RingiBranch 融資番号（枝番）
     */
    public void setID_YN_RingiBranch(String ID_YN_RingiBranch) {
        this.ID_YN_RingiBranch = ID_YN_RingiBranch;
    }

    /**
     * 報告書種別を取得します。
     *
     * @return 報告書種別
     */
    public String getID_RyakusyouName_Report() {
        return ID_RyakusyouName_Report;
    }

    /**
     * 報告書種別を設定します。
     *
     * @param ID_RyakusyouName_Report 報告書種別
     */
    public void setID_RyakusyouName_Report(String ID_RyakusyouName_Report) {
        this.ID_RyakusyouName_Report = ID_RyakusyouName_Report;
    }

    /**
     * 処理状況名称を取得します。
     *
     * @return 処理状況名称
     */
    public String getID_RyakusyouName_Status() {
        return ID_RyakusyouName_Status;
    }

    /**
     * 処理状況名称を設定します。
     *
     * @param ID_RyakusyouName_Status 処理状況名称
     */
    public void setID_RyakusyouName_Status(String ID_RyakusyouName_Status) {
        this.ID_RyakusyouName_Status = ID_RyakusyouName_Status;
    }

    /**
     * 処理状況を取得します。
     *
     * @return 処理状況
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * 処理状況を設定します。
     *
     * @param ID_Status 処理状況
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコードを設定します。
     *
     * @param ID_DataCode データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param ID_ID_Report 報告書番号
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 処理種別を取得します。
     *
     * @return 処理種別
     */
    public String getID_RyakusyouName_Process() {
        return ID_RyakusyouName_Process;
    }

    /**
     * 処理種別を設定します。
     *
     * @param ID_RyakusyouName_Process 処理種別
     */
    public void setID_RyakusyouName_Process(String ID_RyakusyouName_Process) {
        this.ID_RyakusyouName_Process = ID_RyakusyouName_Process;
    }

    /**
     * 取消済を取得します。
     *
     * @return 取消済
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済を設定します。
     *
     * @param ID_Flag_Torikeshizumi 取消済
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * 原本番号を取得します。
     *
     * @return 原本番号
     */
    public String getID_ID_Master() {
        return ID_ID_Master;
    }

    /**
     * 原本番号を設定します。
     *
     * @param ID_ID_Master 原本番号
     */
    public void setID_ID_Master(String ID_ID_Master) {
        this.ID_ID_Master = ID_ID_Master;
    }

    /**
     * エラーコードを取得します。
     *
     * @return エラーコード
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラーコードを設定します。
     *
     * @param ID_Code_Error エラーコード
     */
    public void setID_Code_Error(String ID_Code_Error) {
        this.ID_Code_Error = ID_Code_Error;
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    public String getID_ErrorMessage() {
        return ID_ErrorMessage;
    }

    /**
     * メッセージを設定します。
     *
     * @param ID_ErrorMessage メッセージ
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        this.ID_ErrorMessage = ID_ErrorMessage;
    }

    /**
     * 行番号を取得します。
     *
     * @return メッセージ
     */
    public String getArray_List_Index() {
        return Array_List_Index;
    }

    /**
     * 行番号を設定します。
     *
     * @param errormessage メッセージ
     */
    public void setArray_List_Index(String Array_List_Index) {
        this.Array_List_Index = Array_List_Index;
    }

}