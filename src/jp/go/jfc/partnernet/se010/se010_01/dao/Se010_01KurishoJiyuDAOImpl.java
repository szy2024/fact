//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01KurishoJiyuDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe010_01KurishoJiyuDAOの実装クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01KurishoJiyuDAOImpl extends PNBaseDAO<Se010_01KurishoJiyuEntity> implements
        Se010_01KurishoJiyuDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se010_01KurishoJiyuEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuDAO#countByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuEntity)
     */
    @Override
    public long countByCondition(Se010_01KurishoJiyuEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se010_01KurishoJiyuEntity
     * @return List&lt;Se010_01KurishoJiyuEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuEntity)
     */
    @Override
    public List<Se010_01KurishoJiyuEntity> findByCondition(Se010_01KurishoJiyuEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01KurishoJiyuEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se010_01KurishoJiyuEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se010_01KurishoJiyuEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuEntity,
     *      int, int)
     */
    @Override
    public List<Se010_01KurishoJiyuEntity> findByCondition(Se010_01KurishoJiyuEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01KurishoJiyuEntity.class, offset, length);
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
        sql.append("SELECT  ");
        sql.append("  Code_KurishoJiyu, ");
        sql.append("  Name_KurishoJiyu  ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se010_01KurishoJiyuEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se010_01KurishoJiyuEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定
         */
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM ");
        sql.append("  KurishoJiyu ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se010_01KurishoJiyuEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se010_01KurishoJiyuEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("ORDER BY ");
        sql.append("  Code_KurishoJiyu ASC ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}