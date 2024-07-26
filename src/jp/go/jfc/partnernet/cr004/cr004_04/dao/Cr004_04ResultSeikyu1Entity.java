//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultSeikyu1Entity
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
 * このクラスはCr004_04ResultSeikyu1DAOのEntityクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultSeikyu1Entity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号指定を取得します。
     * @return 債権管理番号指定
     */
    public String getCr004_04_ID_Credit() {
        return (String) getValue("Cr004_04_ID_Credit");
    }

    /**
     * 債権管理番号指定を設定します。
     * @param Cr004_04_ID_Credit 債権管理番号指定
     */
    public void setCr004_04_ID_Credit(String Cr004_04_ID_Credit) {
        setValue("Cr004_04_ID_Credit", Cr004_04_ID_Credit);
    }

    /**
     * 払込年月日指定を取得します。
     * @return 払込年月日指定
     */
    public String getCr004_04_Date_Haraikomi() {
        return (String) getValue("Cr004_04_Date_Haraikomi");
    }

    /**
     * 払込年月日指定を設定します。
     * @param Cr004_04_Date_Haraikomi 払込年月日指定
     */
    public void setCr004_04_Date_Haraikomi(String Cr004_04_Date_Haraikomi) {
        setValue("Cr004_04_Date_Haraikomi", Cr004_04_Date_Haraikomi);
    }

}