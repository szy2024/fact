//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM02_HaraidashiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/02 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはPNCOM02_HaraidashiDAOの実装クラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class PNCOM02_HaraidashiDAOImpl extends PNBaseDAO<PNCOM02_HaraidashiEntity> implements
        PNCOM02_HaraidashiDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity PNCOM02_HaraidashiEntity
     * @return 該当件数
     */
    @Override
    public long countByCondition(PNCOM02_HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity PNCOM02_HaraidashiEntity
     * @return List&lt;PNCOM02_HaraidashiEntity&gt;
     */
    @Override
    public List<PNCOM02_HaraidashiEntity> findByCondition(PNCOM02_HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, PNCOM02_HaraidashiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity PNCOM02_HaraidashiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;PNCOM02_HaraidashiEntity&gt;
     */
    @Override
    public List<PNCOM02_HaraidashiEntity> findByCondition(PNCOM02_HaraidashiEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, PNCOM02_HaraidashiEntity.class, offset, length);
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
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("SELECT ");
        sql.append(" M_KashitsukeukeireZan, ");
        sql.append(" M_ZandakaSekisu, ");
        sql.append(" Date_HaraidashiJuto ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity PNCOM02_HaraidashiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, PNCOM02_HaraidashiEntity inEntity) {

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM Haraidashi ");
        sql.append(" WHERE ");
        sql.append("ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND ");
        sql.append("Kubun_KoseiShori = '0'");
        sql.append(" AND ");
        if ("1".equals(inEntity.getWhereMode())) {
            sql.append("Date_HaraidashiJuto > ?", inEntity.getDate_HaraidashiJuto_From());
            sql.append(" AND ");
            sql.append("Date_HaraidashiJuto <= ?", inEntity.getDate_HaraidashiJuto_To());
        } else if ("2".equals(inEntity.getWhereMode())) {
            sql.append("Date_HaraidashiJuto >= ?", inEntity.getDate_HaraidashiJuto_From());
            sql.append(" AND ");
            sql.append("Date_HaraidashiJuto <= ?", inEntity.getDate_HaraidashiJuto_To());
        } else if ("3".equals(inEntity.getWhereMode())) {
            sql.append("Date_HaraidashiJuto < ?", inEntity.getDate_HaraidashiJuto());
        } else if ("4".equals(inEntity.getWhereMode())) {
            sql.append("Date_HaraidashiJuto <= ?", inEntity.getDate_HaraidashiJuto());
        }
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity PNCOM02_HaraidashiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, PNCOM02_HaraidashiEntity inEntity) {

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        if ("2".equals(inEntity.getWhereMode())) {
            sql.append(" ORDER BY ");
            // sql.append("Date_HaraidashiJuto ASC");
            sql.append("CAST(ID_KeisuKanriShori AS NUMBER(11)) ASC");
        } else if ("3".equals(inEntity.getWhereMode()) || "4".equals(inEntity.getWhereMode())) {
            sql.append(" ORDER BY ");
            // sql.append("Date_HaraidashiJuto DESC");
            sql.append("CAST(ID_KeisuKanriShori AS NUMBER(11)) DESC");
        }
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}