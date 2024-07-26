//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01KoukoShitenDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe004_01KoukoShitenDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se004_01KoukoShitenDAOImpl extends PNBaseDAO<Se004_01KoukoShitenEntity> implements
        Se004_01KoukoShitenDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se004_01KoukoShitenEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenDAO#countByCondition(jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenEntity)
     */
    @Override
    public long countByCondition(Se004_01KoukoShitenEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se004_01KoukoShitenEntity
     * @return List&lt;Se004_01KoukoShitenEntity
     * @see jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenDAO#findByCondition(jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenEntity)
     */
    @Override
    public List<Se004_01KoukoShitenEntity> findByCondition(Se004_01KoukoShitenEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se004_01KoukoShitenEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se004_01KoukoShitenEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se004_01KoukoShitenEntity
     * @see jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenDAO#findByCondition(jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenEntity,
     *      int, int)
     */
    @Override
    public List<Se004_01KoukoShitenEntity> findByCondition(Se004_01KoukoShitenEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se004_01KoukoShitenEntity.class, offset, length);
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
        sql.append("SELECT");
        sql.append("  A.Code_KoukoShiten");
        sql.append(", A.Name_KoukoShiten");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se004_01KoukoShitenEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se004_01KoukoShitenEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 なし
         */
        sql.append(" FROM ");
        sql.append(" KoukoShiten A");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se004_01KoukoShitenEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se004_01KoukoShitenEntity inEntity) {
        sql.append(" ORDER BY");
        sql.append(" A.Code_KoukoShiten");
    }
}