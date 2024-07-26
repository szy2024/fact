//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01getReportHistoryCountDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe005_01getReportHistoryCountDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se005_01ReportHistoryCountDAOImpl extends PNBaseDAO<Se005_01ReportHistoryCountEntity> implements
        Se005_01ReportHistoryCountDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se005_01getReportHistoryCountEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountDAO#countByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountEntity)
     */
    @Override
    public long countByCondition(Se005_01ReportHistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se005_01getReportHistoryCountEntity
     * @return List&lt;Se005_01getReportHistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountDAO#findByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountEntity)
     */
    @Override
    public List<Se005_01ReportHistoryCountEntity> findByCondition(Se005_01ReportHistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se005_01ReportHistoryCountEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se005_01getReportHistoryCountEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se005_01getReportHistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountDAO#findByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ReportHistoryCountEntity,
     *      int, int)
     */
    @Override
    public List<Se005_01ReportHistoryCountEntity> findByCondition(Se005_01ReportHistoryCountEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se005_01ReportHistoryCountEntity.class, offset, length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     */
    private void makeSqlSelectCount(PNSqlBuilder sql) {
        sql.append("SELECT");
        sql.append(" COUNT(1) ");
    }

    /**
     *
     * <pre>
     * sqlのselect句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     */
    private void makeSqlSelect(PNSqlBuilder sql) {

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se005_01getReportHistoryCountEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se005_01ReportHistoryCountEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 債権管理番号＝入力引数の検索要求債権管理番号　かつ　ステータス＜＞２（処理完了）
         * 
         * 　※検索要求債権管理番号は複数件指定されるため、IN句を使用しOR条件で抽出する。
         */

        sql.append("FROM ReportHistory ");
        sql.whereIn("ID_Credit", inEntity.getSe005_01_Req_ID_Credit());
        sql.where("Status <> 2");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se005_01getReportHistoryCountEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se005_01ReportHistoryCountEntity inEntity) {
    }
}