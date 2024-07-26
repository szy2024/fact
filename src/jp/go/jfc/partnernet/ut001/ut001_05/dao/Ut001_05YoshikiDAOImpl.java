//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_05YoshikiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_05.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはUt001_05YoshikiDAOの実装クラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_05YoshikiDAOImpl extends PNBaseDAO<Ut001_05YoshikiEntity> implements Ut001_05YoshikiDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Ut001_05YoshikiEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiDAO#countByCondition(jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiEntity)
     */
    @Override
    public long countByCondition(Ut001_05YoshikiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Ut001_05YoshikiEntity
     * @return List&lt;Ut001_05YoshikiEntity&gt;
     * @see jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiDAO#findByCondition(jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiEntity)
     */
    @Override
    public List<Ut001_05YoshikiEntity> findByCondition(Ut001_05YoshikiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut001_05YoshikiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Ut001_05YoshikiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut001_05YoshikiEntity&gt;
     * @see jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiDAO#findByCondition(jp.go.jfc.partnernet.ut001.ut001_05.dao.Ut001_05YoshikiEntity,
     *      int, int)
     */
    @Override
    public List<Ut001_05YoshikiEntity> findByCondition(Ut001_05YoshikiEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut001_05YoshikiEntity.class, offset, length);
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
        sql.append("SELECT ID_FormatNumber AS ID_ID_FormatNumber,");
        sql.append("ID_DocName,");
        sql.append("ID_DocFileName");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut001_05YoshikiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Ut001_05YoshikiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" from Yoshiki ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut001_05YoshikiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Ut001_05YoshikiEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append(" ID_FormatNumber ASC,");
        sql.append(" ID_DocName ASC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}