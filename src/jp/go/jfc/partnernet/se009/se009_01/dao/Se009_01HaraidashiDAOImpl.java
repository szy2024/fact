//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01HaraidashiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe009_01HaraidashiDAOの実装クラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01HaraidashiDAOImpl extends PNBaseDAO<Se009_01HaraidashiEntity> implements
        Se009_01HaraidashiDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se009_01HaraidashiEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiDAO#countByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiEntity)
     */
    @Override
    public long countByCondition(Se009_01HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se009_01HaraidashiEntity
     * @return List&lt;Se009_01HaraidashiEntity&gt;
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiDAO#findByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiEntity)
     */
    @Override
    public List<Se009_01HaraidashiEntity> findByCondition(Se009_01HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se009_01HaraidashiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se009_01HaraidashiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se009_01HaraidashiEntity&gt;
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiDAO#findByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01HaraidashiEntity,
     *      int, int)
     */
    @Override
    public List<Se009_01HaraidashiEntity> findByCondition(Se009_01HaraidashiEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se009_01HaraidashiEntity.class, offset, length);
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
        sql.append("SELECT");
        sql.append(" ID_Credit, ");
        sql.append(" M_KashitsukeukeireZan ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se009_01HaraidashiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se009_01HaraidashiEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 債権管理番号 = 入力された債権管理番号 払出充当年月日 <= 入力された払出充当年月日
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM Haraidashi ");
        sql.append(" WHERE ");
        sql.append("ID_Credit = ? ", inEntity.getID_Credit());
        sql.append(" AND ");
        sql.append("Date_HaraidashiJuto <= ? ", inEntity.getDate_HaraidashiJuto());
        sql.append(" AND ");
        sql.append("Kubun_KoseiShori = '0' ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se009_01HaraidashiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se009_01HaraidashiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append("CAST(ID_KeisuKanriShori AS NUMBER(11)) DESC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}