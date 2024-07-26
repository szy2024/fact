//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr013_01TenpoNameResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr013_01TenpoNameResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr013_01TenpoNameResultDataEntity extends PNBaseEntity {

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
     * 金融機関名称を取得します。
     *
     * @return 金融機関名称
     */
    public String getName_organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 金融機関名称を設定します。
     *
     * @param name_organization
     *            金融機関名称
     */
    public void setName_organization(String name_organization) {
        setValue("Name_Organization", name_organization);
    }

}