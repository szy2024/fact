//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultReportEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr004_04ResultReportDAOのEntityクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultReportEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 公庫支店コード指定を取得します。
     * @return 公庫支店コード指定
     */
    public String getCr004_04_Code_KoukoShiten() {
        return (String) getValue("Cr004_04_Code_KoukoShiten");
    }

    /**
     * 公庫支店コード指定を設定します。
     * @param Cr004_04_Code_KoukoShiten 公庫支店コード指定
     */
    public void setCr004_04_Code_KoukoShiten(String Cr004_04_Code_KoukoShiten) {
        setValue("Cr004_04_Code_KoukoShiten", Cr004_04_Code_KoukoShiten);
    }

    /**
     * 扱店コード指定を取得します。
     * @return 扱店コード指定
     */
    public String getCr004_04_Code_Organization() {
        return (String) getValue("Cr004_04_Code_Organization");
    }

    /**
     * 扱店コード指定を設定します。
     * @param Cr004_04_Code_Organization 扱店コード指定
     */
    public void setCr004_04_Code_Organization(String Cr004_04_Code_Organization) {
        setValue("Cr004_04_Code_Organization", Cr004_04_Code_Organization);
    }

    /**
     * 店舗コード指定を取得します。
     * @return 店舗コード指定
     */
    public String getCr004_04_Code_Tenpo() {
        return (String) getValue("Cr004_04_Code_Tenpo");
    }

    /**
     * 店舗コード指定を設定します。
     * @param Cr004_04_Code_Tenpo 店舗コード指定
     */
    public void setCr004_04_Code_Tenpo(String Cr004_04_Code_Tenpo) {
        setValue("Cr004_04_Code_Tenpo", Cr004_04_Code_Tenpo);
    }

    /**
     * 年度指定を取得します。
     * @return 年度指定
     */
    public String getCr004_04_Year() {
        return (String) getValue("Cr004_04_Year");
    }

    /**
     * 年度指定を設定します。
     * @param Cr004_04_Year 年度指定
     */
    public void setCr004_04_Year(String Cr004_04_Year) {
        setValue("Cr004_04_Year", Cr004_04_Year);
    }

    /**
     * 方式資金指定を取得します。
     * @return 方式資金指定
     */
    public String getCr004_04_Code_HoshikiShikin() {
        return (String) getValue("Cr004_04_Code_HoshikiShikin");
    }

    /**
     * 方式資金指定を設定します。
     * @param Cr004_04_Code_HoshikiShikin 方式資金指定
     */
    public void setCr004_04_Code_HoshikiShikin(String Cr004_04_Code_HoshikiShikin) {
        setValue("Cr004_04_Code_HoshikiShikin", Cr004_04_Code_HoshikiShikin);
    }

    /**
     * 番号指定を取得します。
     * @return 番号指定
     */
    public String getCr004_04_ID_Ringi() {
        return (String) getValue("Cr004_04_ID_Ringi");
    }

    /**
     * 番号指定を設定します。
     * @param Cr004_04_ID_Ringi 番号指定
     */
    public void setCr004_04_ID_Ringi(String Cr004_04_ID_Ringi) {
        setValue("Cr004_04_ID_Ringi", Cr004_04_ID_Ringi);
    }

    /**
     * 枝番指定を取得します。
     * @return 枝番指定
     */
    public String getCr004_04_ID_RingiBranch() {
        return (String) getValue("Cr004_04_ID_RingiBranch");
    }

    /**
     * 枝番指定を設定します。
     * @param Cr004_04_ID_RingiBranch 枝番指定
     */
    public void setCr004_04_ID_RingiBranch(String Cr004_04_ID_RingiBranch) {
        setValue("Cr004_04_ID_RingiBranch", Cr004_04_ID_RingiBranch);
    }

    /**
     * 取消済フラグ指定を取得します。
     * @return 取消済フラグ指定
     */
    public String getCr004_04_Flag_Torikeshizumi() {
        return (String) getValue("Cr004_04_Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグ指定を設定します。
     * @param Cr004_04_Flag_Torikeshizumi 取消済フラグ指定
     */
    public void setCr004_04_Flag_Torikeshizumi(String Cr004_04_Flag_Torikeshizumi) {
        setValue("Cr004_04_Flag_Torikeshizumi", Cr004_04_Flag_Torikeshizumi);
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return (String) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String) getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     * @param Date_Report 報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return (String) getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     * @param Time_Report 報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return (String) getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        setValue("Status", Status);
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return (String) getValue("DataCode");
    }

    /**
     * データコードを設定します。
     * @param DataCode データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * 報告書略称名を取得します。
     * @return 報告書略称名
     */
    public String getRyakusyouName_Report() {
        return (String) getValue("RyakusyouName_Report");
    }

    /**
     * 報告書略称名を設定します。
     * @param RyakusyouName_Report 報告書略称名
     */
    public void setRyakusyouName_Report(String RyakusyouName_Report) {
        setValue("RyakusyouName_Report", RyakusyouName_Report);
    }

}