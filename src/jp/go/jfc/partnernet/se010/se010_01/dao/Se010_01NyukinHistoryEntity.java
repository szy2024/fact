//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01NyukinHistoryEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe010_01NyukinHistoryDAOのEntityクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01NyukinHistoryEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 繰償後第一回払込期日を取得します。
     * @return 繰償後第一回払込期日
     */
    public String getDate_Haraikomi() {
        return (String) getValue("Date_Haraikomi");
    }

    /**
     * 繰償後第一回払込期日を設定します。
     * @param Date_Haraikomi 繰償後第一回払込期日
     */
    public void setDate_Haraikomi(String Date_Haraikomi) {
        setValue("Date_Haraikomi", Date_Haraikomi);
    }

}