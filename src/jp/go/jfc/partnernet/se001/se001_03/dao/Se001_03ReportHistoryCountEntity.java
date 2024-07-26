//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03getReportHistoryCountEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe001_03getReportHistoryCountDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se001_03ReportHistoryCountEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 検索要求債権管理番号を取得します。
     * @return 検索要求債権管理番号
     */
    public String getSe001_03_Req_ID_Credit() {
        return (String) getValue("Se001_03_Req_ID_Credit");
    }

    /**
     * 検索要求債権管理番号を設定します。
     * @param string 検索要求債権管理番号
     */
    public void setSe001_03_Req_ID_Credit(String string) {
        setValue("Se001_03_Req_ID_Credit", string);
    }

    /**
     * 報告書履歴件数を取得します。
     * @return 報告書履歴件数
     */
    public java.math.BigDecimal getSe001_03_Ans_ID_AllCount_ReportHistory() {
        return (java.math.BigDecimal) getValue("Se001_03_Ans_ID_AllCount_ReportHistory");
    }

    /**
     * 報告書履歴件数を設定します。
     * @param Se001_03_Ans_ID_AllCount_ReportHistory 報告書履歴件数
     */
    public void setSe001_03_Ans_ID_AllCount_ReportHistory(
            java.math.BigDecimal Se001_03_Ans_ID_AllCount_ReportHistory) {
        setValue("Se001_03_Ans_ID_AllCount_ReportHistory", Se001_03_Ans_ID_AllCount_ReportHistory);
    }

}