//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut004_01YoshikiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut004.ut004_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはUt004_01YoshikiDAOの実装クラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut004_01YoshikiDAOImpl extends PNBaseDAO<Ut004_01YoshikiEntity> implements Ut004_01YoshikiDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Ut004_01YoshikiEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiDAO#countByCondition(jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiEntity)
     */
    @Override
    public long countByCondition(Ut004_01YoshikiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Ut004_01YoshikiEntity
     * @return List&lt;Ut004_01YoshikiEntity&gt;
     * @see jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiDAO#findByCondition(jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiEntity)
     */
    @Override
    public List<Ut004_01YoshikiEntity> findByCondition(Ut004_01YoshikiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut004_01YoshikiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Ut004_01YoshikiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut004_01YoshikiEntity&gt;
     * @see jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiDAO#findByCondition(jp.go.jfc.partnernet.ut004.ut004_01.dao.Ut004_01YoshikiEntity,
     *      int, int)
     */
    @Override
    public List<Ut004_01YoshikiEntity> findByCondition(Ut004_01YoshikiEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut004_01YoshikiEntity.class, offset, length);
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
        sql.append("SELECT NVL(MAX(ID_Data) + 1, 1) AS ID_Data_New");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut004_01YoshikiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Ut004_01YoshikiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM Yoshiki ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut004_01YoshikiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Ut004_01YoshikiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}