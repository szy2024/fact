//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01KoukoShitenDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr005_01KoukoShitenDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_01KoukoShitenDAOImpl extends PNBaseDAO<Cr005_01KoukoShitenEntity> implements
        Cr005_01KoukoShitenDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr005_01KoukoShitenEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenDAO#countByCondition(jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenEntity)
     */
    @Override
    public long countByCondition(Cr005_01KoukoShitenEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr005_01KoukoShitenEntity
     * @return List&lt;Cr005_01KoukoShitenEntity&gt;
     * @see jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenEntity)
     */
    @Override
    public List<Cr005_01KoukoShitenEntity> findByCondition(Cr005_01KoukoShitenEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr005_01KoukoShitenEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr005_01KoukoShitenEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr005_01KoukoShitenEntity&gt;
     * @see jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenEntity,
     *      int, int)
     */
    @Override
    public List<Cr005_01KoukoShitenEntity> findByCondition(Cr005_01KoukoShitenEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr005_01KoukoShitenEntity.class, offset, length);
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

        sql.append(" SELECT  ");
        sql.append(" Code_KoukoShiten, ");
        sql.append(" Name_KoukoShiten ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr005_01KoukoShitenEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr005_01KoukoShitenEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 なし
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        // FROM
        sql.append(" FROM ");
        sql.append(" KoukoShiten ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr005_01KoukoShitenEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr005_01KoukoShitenEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        sql.append(" ORDER BY ");
        sql.append(" Code_KoukoShiten ASC ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}