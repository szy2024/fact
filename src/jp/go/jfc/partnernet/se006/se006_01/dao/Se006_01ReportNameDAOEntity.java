//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_01ReportNameDAOEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/06 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_01ReportNameDAOのEntityクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_01ReportNameDAOEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 報告書種別区分を取得します。
     *
     * @return 報告書種別区分
     */
    public String getSyubetsuKbn_Report() {
        return (String)getValue("SyubetsuKbn_Report");
    }

    /**
     * 報告書種別区分を設定します。
     *
     * @param SyubetsuKbn_Report
     *            報告書種別区分
     */
    public void setSyubetsuKbn_Report(String SyubetsuKbn_Report) {
        setValue("SyubetsuKbn_Report", SyubetsuKbn_Report);
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
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getDataCode() {
        return (String)getValue("DataCode");
    }

    /**
     * データコードを設定します。
     *
     * @param DataCode
     *            データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * 報告書略称名を取得します。
     *
     * @return 報告書略称名
     */
    public String getRyakusyouName_Report() {
        return (String)getValue("RyakusyouName_Report");
    }

    /**
     * 報告書略称名を設定します。
     *
     * @param RyakusyouName_Report
     *            報告書略称名
     */
    public void setRyakusyouName_Report(String RyakusyouName_Report) {
        setValue("RyakusyouName_Report", RyakusyouName_Report);
    }

}