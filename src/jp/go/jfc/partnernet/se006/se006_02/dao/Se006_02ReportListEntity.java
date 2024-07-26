//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02ReportListEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/19 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_02ReportListDAOのEntityクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_02ReportListEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getlblID_Name_Organization() {
        return (String)getValue("lblID_Name_Organization");
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblID_Name_Organization 扱店名
     */
    public void setlblID_Name_Organization(String lblID_Name_Organization) {
        setValue("lblID_Name_Organization", lblID_Name_Organization);
    }

    /**
     * 報告書種別(名称)を取得します。
     *
     * @return
     */
    public String getlblID_RyakusyouName_Report() {
        return (String)getValue("lblID_RyakusyouName_Report");
    }

    /**
     * 報告書種別(名称)を設定します。
     *
     * @param lblID_RyakusyouName_Report 報告書種別(名称)
     */
    public void setlblID_RyakusyouName_Report(String lblID_RyakusyouName_Report) {
        setValue("lblID_RyakusyouName_Report", lblID_RyakusyouName_Report);
    }

    /**
     * 報告書種別を取得します。
     *
     * @return 報告書種別
     */
    public String getSearch_DataCode() {
        return (String)getValue("Search_DataCode");
    }

    /**
     * 報告書種別を設定します。
     *
     * @param Search_DataCode
     *            報告書種別
     */
    public void setSearch_DataCode(String Search_DataCode) {
        setValue("Search_DataCode", Search_DataCode);
    }

    /**
     * 実行・回収関係報告書詳細を取得します。
     *
     * @return 実行・回収関係報告書詳細
     */
    public String getSearch_DataCode_Detail() {
        return (String)getValue("Search_DataCode_Detail");
    }

    /**
     * 実行・回収関係報告書詳細を設定します。
     *
     * @param Search_DataCode_Detail
     *            実行・回収関係報告書詳細
     */
    public void setSearch_DataCode_Detail(String Search_DataCode_Detail) {
        setValue("Search_DataCode_Detail", Search_DataCode_Detail);
    }

    /**
     * 支店を取得します。
     *
     * @return 支店
     */
    public String getSearch_Shiten() {
        return (String)getValue("Search_Shiten");
    }

    /**
     * 支店を設定します。
     *
     * @param Search_Shiten
     *            支店
     */
    public void setSearch_Shiten(String Search_Shiten) {
        setValue("Search_Shiten", Search_Shiten);
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getSearch_Code_Organization() {
        return (String)getValue("Search_Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     *
     * @param Search_Shiten
     *            扱店コード
     */
    public void setSearch_Code_Organization(String Search_Code_Organization) {
        setValue("Search_Code_Organization", Search_Code_Organization);
    }

    /**
     * 検索開始日を取得します。
     *
     * @return 検索開始日
     */
    public String getSearch_Start_Date() {
        return (String)getValue("Search_Start_Date");
    }

    /**
     * 検索開始日を設定します。
     *
     * @param Search_Start_Date
     *            検索開始日
     */
    public void setSearch_Start_Date(String Search_Start_Date) {
        setValue("Search_Start_Date", Search_Start_Date);
    }

    /**
     * 検索終了日を取得します。
     *
     * @return 検索終了日
     */
    public String getSearch_End_Date() {
        return (String)getValue("Search_End_Date");
    }

    /**
     * 検索終了日を設定します。
     *
     * @param Search_End_Date
     *            検索終了日
     */
    public void setSearch_End_Date(String Search_End_Date) {
        setValue("Search_End_Date", Search_End_Date);
    }

    /**
     * 取消フラグを取得します。
     *
     * @return 取消フラグ
     */
    public String getTorikeshi_Flg() {
        return (String)getValue("Torikeshi_Flg");
    }

    /**
     * 取消フラグを設定します。
     *
     * @param Torikeshi_Flg
     *            取消フラグ
     */
    public void setTorikeshi_Flg(String Torikeshi_Flg) {
        setValue("Torikeshi_Flg", Torikeshi_Flg);
    }

    /**
     * 権限種別を取得します。
     *
     * @return 権限種別
     */
    public String getRoleCode() {
        return (String)getValue("RoleCode");
    }

    /**
     * 権限種別を設定します。
     *
     * @param RoleCode
     *            権限種別
     */
    public void setRoleCode(String RoleCode) {
        setValue("RoleCode", RoleCode);
    }

    /**
     * 融資番号（扱店コード）を取得します。
     *
     * @return 融資番号（扱店コード）
     */
    public String getSearch_YN_Code_Organization() {
        return (String)getValue("Search_YN_Code_Organization");
    }

    /**
     * 融資番号（扱店コード）を設定します。
     *
     * @param Search_YN_Code_Organization
     *            融資番号（扱店コード）
     */
    public void setSearch_YN_Code_Organization(String Search_YN_Code_Organization) {
        setValue("Search_YN_Code_Organization", Search_YN_Code_Organization);
    }

    /**
     * 融資番号（店舗コード）を取得します。
     *
     * @return 融資番号（店舗コード）
     */
    public String getSearch_YN_Code_Tenpo() {
        return (String)getValue("Search_YN_Code_Tenpo");
    }

    /**
     * 融資番号（店舗コード）を設定します。
     *
     * @param Search_YN_Code_Tenpo
     *            融資番号（店舗コード）
     */
    public void setSearch_YN_Code_Tenpo(String Search_YN_Code_Tenpo) {
        setValue("Search_YN_Code_Tenpo", Search_YN_Code_Tenpo);
    }

    /**
     * 融資番号（年度）を取得します。
     *
     * @return 融資番号（年度）
     */
    public String getSearch_YN_Year() {
        return (String)getValue("Search_YN_Year");
    }

    /**
     * 融資番号（年度）を設定します。
     *
     * @param Search_YN_Year
     *            融資番号（年度）
     */
    public void setSearch_YN_Year(String Search_YN_Year) {
        setValue("Search_YN_Year", Search_YN_Year);
    }

    /**
     * 融資番号（方式資金）を取得します。
     *
     * @return 融資番号（方式資金）
     */
    public String getSearch_YN_Kubun_HoshikiShikin() {
        return (String)getValue("Search_YN_Kubun_HoshikiShikin");
    }

    /**
     * 融資番号（方式資金）を設定します。
     *
     * @param Search_YN_Code_Hoshikishikin
     *            融資番号（方式資金）
     */
    public void setSearch_YN_Kubun_HoshikiShikin(String Search_YN_Kubun_HoshikiShikin) {
        setValue("Search_YN_Kubun_HoshikiShikin", Search_YN_Kubun_HoshikiShikin);
    }

    /**
     * 融資番号（稟議番号）を取得します。
     *
     * @return 融資番号（稟議番号）
     */
    public String getSearch_YN_Ringi() {
        return (String)getValue("Search_YN_Ringi");
    }

    /**
     * 融資番号（稟議番号）を設定します。
     *
     * @param Search_YN_Ringi
     *            融資番号（稟議番号）
     */
    public void setSearch_YN_Ringi(String Search_YN_Ringi) {
        setValue("Search_YN_Ringi", Search_YN_Ringi);
    }

    /**
     * 融資番号（稟議番号枝番）を取得します。
     *
     * @return 融資番号（稟議番号枝番）
     */
    public String getSearch_YN_Ringibranch() {
        return (String)getValue("Search_YN_Ringibranch");
    }

    /**
     * 融資番号（稟議番号枝番）を設定します。
     *
     * @param Search_YN_Ringibranch
     *            融資番号（稟議番号枝番）
     */
    public void setSearch_YN_Ringibranch(String Search_YN_Ringibranch) {
        setValue("Search_YN_Ringibranch", Search_YN_Ringibranch);
    }

    /**
     * ソート条件を取得します。
     *
     * @return ソート条件
     */
    public String getOrder_Param() {
        return (String)getValue("Order_Param");
    }

    /**
     * ソート条件を設定します。
     *
     * @param Order_Param
     *            ソート条件
     */
    public void setOrder_Param(String Order_Param) {
        setValue("Order_Param", Order_Param);
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getId_History() {
        return (String)getValue("Id_History");
    }

    /**
     * 履歴番号を設定します。
     *
     * @param Id_History
     *            履歴番号
     */
    public void setId_History(String Id_History) {
        setValue("Id_History", Id_History);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String)getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     *
     * @param Date_Report
     *            報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return (String)getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param Time_Report
     *            報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * 支店コードを取得します。
     *
     * @return 支店コード
     */
    public String getCode_Koukoshiten() {
        return (String)getValue("Code_Koukoshiten");
    }

    /**
     * 支店コードを設定します。
     *
     * @param Code_Koukoshiten
     *            支店コード
     */
    public void setCode_Koukoshiten(String Code_Koukoshiten) {
        setValue("Code_Koukoshiten", Code_Koukoshiten);
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     *
     * @param Code_Organization
     *            扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getName_Organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 扱店名を設定します。
     *
     * @param Name_Organization
     *            扱店名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

    /**
     * 店舗コードを取得します。
     *
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     *
     * @param Code_Tenpo
     *            店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getYear() {
        return (String)getValue("Year");
    }

    /**
     * 年度を設定します。
     *
     * @param Year
     *            年度
     */
    public void setYear(String Year) {
        setValue("Year", Year);
    }

    /**
     * 方式資金を取得します。
     *
     * @return 方式資金
     */
    public String getCode_Hoshikishikin() {
        return (String)getValue("Code_Hoshikishikin");
    }

    /**
     * 方式資金を設定します。
     *
     * @param Code_Hoshikishikin
     *            方式資金
     */
    public void setCode_Hoshikishikin(String Code_Hoshikishikin) {
        setValue("Code_Hoshikishikin", Code_Hoshikishikin);
    }

    /**
     * 稟議番号を取得します。
     *
     * @return 稟議番号
     */
    public String getId_Ringi() {
        return (String)getValue("Id_Ringi");
    }

    /**
     * 稟議番号を設定します。
     *
     * @param Id_Ringi
     *            稟議番号
     */
    public void setId_Ringi(String Id_Ringi) {
        setValue("Id_Ringi", Id_Ringi);
    }

    /**
     * 稟議番号枝番を取得します。
     *
     * @return 稟議番号枝番
     */
    public String getId_Ringibranch() {
        return (String)getValue("Id_Ringibranch");
    }

    /**
     * 稟議番号枝番を設定します。
     *
     * @param Id_Ringibranch
     *            稟議番号枝番
     */
    public void setId_Ringibranch(String Id_Ringibranch) {
        setValue("Id_Ringibranch", Id_Ringibranch);
    }

    /**
     * 報告書略称名を取得します。
     *
     * @return 報告書略称名
     */
    public String getRyakusyouname_Report() {
        return (String)getValue("Ryakusyouname_Report");
    }

    /**
     * 報告書略称名を設定します。
     *
     * @param Ryakusyouname_Report
     *            報告書略称名
     */
    public void setRyakusyouname_Report(String Ryakusyouname_Report) {
        setValue("Ryakusyouname_Report", Ryakusyouname_Report);
    }

    /**
     * ステータス略称名を取得します。
     *
     * @return ステータス略称名
     */
    public String getRyakusyouname_Status() {
        return (String)getValue("Ryakusyouname_Status");
    }

    /**
     * ステータス略称名を設定します。
     *
     * @param Ryakusyouname_Status ステータス略称名
     */
    public void setRyakusyouname_Status(String Ryakusyouname_Status) {
        setValue("Ryakusyouname_Status", Ryakusyouname_Status);
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getStatus() {
        return (String)getValue("Status");
    }

    /**
     * ステータスを設定します。
     *
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        setValue("Status", Status);
    }

    /**
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getDatacode() {
        return (String)getValue("Datacode");
    }

    /**
     * データコードを設定します。
     *
     * @param Datacode
     *            データコード
     */
    public void setDatacode(String Datacode) {
        setValue("Datacode", Datacode);
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getId_Report() {
        return (String)getValue("Id_Report");
    }

    /**
     * 報告書番号を設定します。
     *
     * @param Id_Report
     *            報告書番号
     */
    public void setId_Report(String Id_Report) {
        setValue("Id_Report", Id_Report);
    }

    /**
     * 取消済フラグを取得します。
     *
     * @return 取消済フラグ
     */
    public String getFlag_Torikeshizumi() {
        return (String)getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグを設定します。
     *
     * @param Flag_Torikeshizumi
     *            取消済フラグ
     */
    public void setFlag_Torikeshizumi(String Flag_Torikeshizumi) {
        setValue("Flag_Torikeshizumi", Flag_Torikeshizumi);
    }

    /**
     * 処理種別名略称を取得します。
     *
     * @return 処理種別名略称
     */
    public String getRyakusyouname_Process() {
        return (String)getValue("Ryakusyouname_Process");
    }

    /**
     * 処理種別名略称を設定します。
     *
     * @param Ryakusyouname_Process
     *            処理種別名略称
     */
    public void setRyakusyouname_Process(String Ryakusyouname_Process) {
        setValue("Ryakusyouname_Process", Ryakusyouname_Process);
    }

    /**
     * 原本番号を取得します。
     *
     * @return 原本番号
     */
    public String getId_Master() {
        return (String)getValue("Id_Master");
    }

    /**
     * 原本番号を設定します。
     *
     * @param Id_Master
     *            原本番号
     */
    public void setId_Master(String Id_Master) {
        setValue("Id_Master", Id_Master);
    }

    /**
     * エラーコードを取得します。
     *
     * @return エラーコード
     */
    public String getCode_Error() {
        return (String)getValue("Code_Error");
    }

    /**
     * エラーコードを設定します。
     *
     * @param Code_Error
     *            エラーコード
     */
    public void setCode_Error(String Code_Error) {
        setValue("Code_Error", Code_Error);
    }

    /**
     * エラーメッセージを取得します。
     *
     * @return エラーメッセージ
     */
    public String getErrormessage() {
        return (String)getValue("Errormessage");
    }

    /**
     * エラーメッセージを設定します。
     *
     * @param Errormessage
     *            エラーメッセージ
     */
    public void setErrormessage(String Errormessage) {
        setValue("Errormessage", Errormessage);
    }

    /**
     * 交付依頼年月を取得します。
     *
     * @return 交付依頼年月
     */
    public String getDate_KofuIrai() {
        return (String)getValue("Date_KofuIrai");
    }

    /**
     * 交付依頼年月を設定します。
     *
     * @param Date_KofuIrai
     *            交付依頼年月
     */
    public void setDate_KofuIrai(String Date_KofuIrai) {
        setValue("Date_KofuIrai", Date_KofuIrai);
    }

    /**
     * 指定交付日を取得します。
     *
     * @return 指定交付日
     */
    public String getDate_Kofu() {
        return (String)getValue("Date_Kofu");
    }

    /**
     * 指定交付日を設定します。
     *
     * @param Date_Kofu
     *            指定交付日
     */
    public void setDate_Kofu(String Date_Kofu) {
        setValue("Date_Kofu", Date_Kofu);
    }

    /**
     * 至急発行フラグを取得します。
     *
     * @return 至急発行フラグ
     */
    public String getFlag_ShikyuHakko() {
        return (String)getValue("Flag_ShikyuHakko");
    }

    /**
     * 至急発行フラグを設定します。
     *
     * @param Flag_ShikyuHakko
     *            至急発行フラグ
     */
    public void setFlag_ShikyuHakko(String Flag_ShikyuHakko) {
        setValue("Flag_ShikyuHakko", Flag_ShikyuHakko);
    }

    /**
     * 発信日を取得します。
     *
     * @return 発信日
     */
    public String getSendDate_Report() {
        return (String)getValue("SendDate_Report");
    }

    /**
     * 発信日を設定します。
     *
     * @param SendDate_Report
     *            発信日
     */
    public void setSendDate_Report(String SendDate_Report) {
        setValue("SendDate_Report", SendDate_Report);
    }

}