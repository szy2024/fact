//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se016_01ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/13 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se016.se016_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe016_01ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se016_01ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 表示開始年月日を取得します。
     *
     * @return 表示開始年月日
     */
    public String getDate_ShukeiStart() {
        return (String)getValue("Date_ShukeiStart");
    }

    /**
     * 表示開始年月日を設定します。
     *
     * @param Date_ShukeiStart 表示開始年月日
     */
    public void setDate_ShukeiStart(String Date_ShukeiStart) {
        setValue("Date_ShukeiStart", Date_ShukeiStart);
    }

    /**
     * 表示終了年月日を取得します。
     *
     * @return 表示終了年月日
     */
    public String getDate_ShukeiEnd() {
        return (String)getValue("Date_ShukeiEnd");
    }

    /**
     * 表示終了年月日を設定します。
     *
     * @param Date_ShukeiEnd 表示終了年月日
     */
    public void setDate_ShukeiEnd(String Date_ShukeiEnd) {
        setValue("Date_ShukeiEnd", Date_ShukeiEnd);
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店を設定します。
     *
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     *
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
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
     * @param Name_Organization 扱店名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
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
     * @param Date_Report 報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 表示ファイル名を取得します。
     *
     * @return 表示ファイル名
     */
    public String getDisp_DocName() {
        return (String)getValue("Disp_DocName");
    }

    /**
     * 表示ファイル名を設定します。
     *
     * @param Disp_DocName 表示ファイル名
     */
    public void setDisp_DocName(String Disp_DocName) {
        setValue("Disp_DocName", Disp_DocName);
    }

    /**
     * 添付ファイルを取得します。
     *
     * @return 添付ファイル
     */
    public String getDocName() {
        return (String)getValue("DocName");
    }

    /**
     * 添付ファイルを設定します。
     *
     * @param DocName 添付ファイル
     */
    public void setDocName(String DocName) {
        setValue("DocName", DocName);
    }

    /**
     * 添付ファイルアップロード先パスを取得します。
     *
     * @return 添付ファイルアップロード先パス
     */
    public String getFilePath() {
        return (String)getValue("FilePath");
    }

    /**
     * 添付ファイルアップロード先パスを設定します。
     *
     * @param FilePath 添付ファイルアップロード先パス
     */
    public void setFilePath(String FilePath) {
        setValue("FilePath", FilePath);
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     *
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

}