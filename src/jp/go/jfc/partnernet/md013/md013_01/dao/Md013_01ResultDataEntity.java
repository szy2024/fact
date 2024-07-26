//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md013_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md013.md013_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd013_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md013_01ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getId_history() {
        return (String)getValue("ID_History");
    }

    /**
     * 履歴番号を設定します。
     *
     * @param id_history
     *            履歴番号
     */
    public void setId_history(String id_history) {
        setValue("ID_History", id_history);
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getId_report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     *
     * @param id_report
     *            報告書番号
     */
    public void setId_report(String id_report) {
        setValue("ID_Report", id_report);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getDate_report() {
        return (String)getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     *
     * @param date_report
     *            報告年月日
     */
    public void setDate_report(String date_report) {
        setValue("Date_Report", date_report);
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getTime_report() {
        return (String)getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param time_report
     *            報告時分秒
     */
    public void setTime_report(String time_report) {
        setValue("Time_Report", time_report);
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店名
     */
    public String getName_organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 扱店名を設定します。
     *
     * @param name_organization
     *            扱店名
     */
    public void setName_organization(String name_organization) {
        setValue("Name_Organization", name_organization);
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getCode_organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店を設定します。
     *
     * @param code_organization
     *            扱店
     */
    public void setCode_organization(String code_organization) {
        setValue("Code_Organization", code_organization);
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getCode_tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     *
     * @param code_tenpo
     *            店舗
     */
    public void setCode_tenpo(String code_tenpo) {
        setValue("Code_Tenpo", code_tenpo);
    }

    /**
     * 表示ファイル名を取得します。
     *
     * @return 表示ファイル名
     */
    public String getDisp_docname() {
        return (String)getValue("Disp_DocName");
    }

    /**
     * 表示ファイル名を設定します。
     *
     * @param disp_docname
     *            表示ファイル名
     */
    public void setDisp_docname(String disp_docname) {
        setValue("Disp_DocName", disp_docname);
    }

    /**
     * 添付ファイルを取得します。
     *
     * @return 添付ファイル
     */
    public String getDocname() {
        return (String)getValue("DocName");
    }

    /**
     * 添付ファイルを設定します。
     *
     * @param docname
     *            添付ファイル
     */
    public void setDocname(String docname) {
        setValue("DocName", docname);
    }

    /**
     * 添付ファイルアップロード先パスを取得します。
     *
     * @return 添付ファイルアップロード先パス
     */
    public String getFilepath() {
        return (String)getValue("FilePath");
    }

    /**
     * 添付ファイルアップロード先パスを設定します。
     *
     * @param filepath
     *            添付ファイルアップロード先パス
     */
    public void setFilepath(String filepath) {
        setValue("FilePath", filepath);
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public java.sql.Timestamp getDatetime_update() {
        return (java.sql.Timestamp)getValue("DateTime_Update");
    }

    /**
     * 更新日時を設定します。
     *
     * @param datetime_update
     *            更新日時
     */
    public void setDatetime_update(java.sql.Timestamp datetime_update) {
        setValue("DateTime_Update", datetime_update);
    }

}