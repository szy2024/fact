//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM02_ReportHistoryEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/02 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはPNCOM02_ReportHistoryDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class PNCOM02_ReportHistoryEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public BigDecimal getID_Credit() {
        return (BigDecimal) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 元利金受入充当報告書の払込期日を取得します。
     * @return 元利金受入充当報告書の払込期日
     */
    public String getKeep_Date_Haraikomi() {
        return (String) getValue("Keep_Date_Haraikomi");
    }

    /**
     * 元利金受入充当報告書の払込期日を設定します。
     * @param Keep_Date_Haraikomi 元利金受入充当報告書の払込期日
     */
    public void setKeep_Date_Haraikomi(String Keep_Date_Haraikomi) {
        setValue("Keep_Date_Haraikomi", Keep_Date_Haraikomi);
    }

}