//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr012_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr012_01ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 権限種別を取得します。
     *
     * @return 権限種別
     */
    public String getRolecode() {
        return (String)getValue("RoleCode");
    }

    /**
     * 権限種別を設定します。
     *
     * @param rolecode
     *            権限種別
     */
    public void setRolecode(String rolecode) {
        setValue("RoleCode", rolecode);
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

}