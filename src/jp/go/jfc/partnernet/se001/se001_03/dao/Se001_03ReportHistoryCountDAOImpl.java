//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03getReportHistoryCountDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe001_03getReportHistoryCountDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se001_03ReportHistoryCountDAOImpl extends PNBaseDAO<Se001_03ReportHistoryCountEntity> implements
        Se001_03ReportHistoryCountDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se001_03getReportHistoryCountEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountDAO#countByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountEntity)
     */
    @Override
    public long countByCondition(Se001_03ReportHistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se001_03getReportHistoryCountEntity
     * @return List&lt;Se001_03getReportHistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountDAO#findByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountEntity)
     */
    @Override
    public List<Se001_03ReportHistoryCountEntity> findByCondition(Se001_03ReportHistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se001_03ReportHistoryCountEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se001_03getReportHistoryCountEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se001_03getReportHistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountDAO#findByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ReportHistoryCountEntity,
     *      int, int)
     */
    @Override
    public List<Se001_03ReportHistoryCountEntity> findByCondition(Se001_03ReportHistoryCountEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se001_03ReportHistoryCountEntity.class, offset, length);
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
     * @param inEntity Se001_03getReportHistoryCountEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se001_03ReportHistoryCountEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 債権管理番号＝検索要求債権管理番号　かつ　ステータス＜＞２（処理完了）
         */

        sql.append("FROM ReportHistory ");
        sql.where("ID_Credit = ?", inEntity.getSe001_03_Req_ID_Credit());
        sql.where("Status <> 2");
        sql.where("Flag_Torikeshizumi <> 1");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se001_03getReportHistoryCountEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se001_03ReportHistoryCountEntity inEntity) {
    }
}