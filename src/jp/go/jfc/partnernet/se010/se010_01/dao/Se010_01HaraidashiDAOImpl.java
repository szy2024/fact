//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01HaraidashiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe010_01HaraidashiDAOの実装クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01HaraidashiDAOImpl extends PNBaseDAO<Se010_01HaraidashiEntity> implements
        Se010_01HaraidashiDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se010_01HaraidashiEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiDAO#countByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiEntity)
     */
    @Override
    public long countByCondition(Se010_01HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se010_01HaraidashiEntity
     * @return List&lt;Se010_01HaraidashiEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiEntity)
     */
    @Override
    public List<Se010_01HaraidashiEntity> findByCondition(Se010_01HaraidashiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01HaraidashiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se010_01HaraidashiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se010_01HaraidashiEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiEntity,
     *      int, int)
     */
    @Override
    public List<Se010_01HaraidashiEntity> findByCondition(Se010_01HaraidashiEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01HaraidashiEntity.class, offset, length);
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
     * @param inEntity Se010_01HaraidashiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se010_01HaraidashiEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　債権管理番号 = 債権管理番号 　払出充当年月日 <= 入力された繰上償還日 　更正処理区分 = 0
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM Haraidashi ");
        sql.append(" WHERE ");
        sql.append("ID_Credit = ? ", inEntity.getID_Credit());
        sql.append(" AND ");
        sql.append("Date_HaraidashiJuto <= ? ", inEntity.getStrDateKuriageShokan());
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
     * @param inEntity Se010_01HaraidashiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se010_01HaraidashiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append("CAST(ID_KeisuKanriShori AS NUMBER(11)) DESC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}