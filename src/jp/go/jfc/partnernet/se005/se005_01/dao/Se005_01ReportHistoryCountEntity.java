//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01getReportHistoryCountEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe005_01getReportHistoryCountDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se005_01ReportHistoryCountEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 検索要求債権管理番号を取得します。
     * @return 検索要求債権管理番号
     */
    public String[] getSe005_01_Req_ID_Credit() {
        return (String[]) getValue("Se005_01_Req_ID_Credit");
    }

    /**
     * 検索要求債権管理番号を設定します。
     * @param Se005_01_Req_ID_Credit 検索要求債権管理番号
     */
    public void setSe005_01_Req_ID_Credit(String[] Se005_01_Req_ID_Credit) {
        setValue("Se005_01_Req_ID_Credit", Se005_01_Req_ID_Credit);
    }

    /**
     * 報告書履歴件数を取得します。
     * @return 報告書履歴件数
     */
    public Integer getSe005_01_Ans_ID_AllCount_ReportHistory() {
        return (Integer) getValue("Se005_01_Ans_ID_AllCount_ReportHistory");
    }

    /**
     * 報告書履歴件数を設定します。
     * @param Se005_01_Ans_ID_AllCount_ReportHistory 報告書履歴件数
     */
    public void setSe005_01_Ans_ID_AllCount_ReportHistory(Integer Se005_01_Ans_ID_AllCount_ReportHistory) {
        setValue("Se005_01_Ans_ID_AllCount_ReportHistory", Se005_01_Ans_ID_AllCount_ReportHistory);
    }

}