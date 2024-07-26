//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_03GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_03.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはUt003_03GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut003_03GetResultDataDAOImpl extends PNBaseDAO<Ut003_03GetResultDataEntity> implements
        Ut003_03GetResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Ut003_03GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataDAO#countByCondition(jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataEntity)
     */
    @Override
    public long countByCondition(Ut003_03GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Ut003_03GetResultDataEntity
     * @return List&lt;Ut003_03GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataEntity)
     */
    @Override
    public List<Ut003_03GetResultDataEntity> findByCondition(Ut003_03GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut003_03GetResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Ut003_03GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut003_03GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Ut003_03GetResultDataEntity> findByCondition(Ut003_03GetResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut003_03GetResultDataEntity.class, offset, length);
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
        sql.append("   Kinrijyoho.DateTime_DocUpdate");
        sql.append(" , Kinrijyoho.ID_DocFileName AS ID_ID_DocFileName");
        sql.append(" , Kinrijyoho.ID_DocName");
        sql.append(" , Kinrijyoho.ID_Data");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut003_03GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Ut003_03GetResultDataEntity inEntity) {

        /*
         * ・検索開始日が設定されている場合 　検索開始日 <= 情報登録日付
         * 
         * ・検索終了日が設定されている場合 　検索終了日 >= 情報登録日付
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM Kinrijyoho ");
        if (!inEntity.getID_SearchStartDate().isEmpty()) {
            sql.where(" Kinrijyoho.DateTime_DocUpdate >= ?", inEntity.getID_SearchStartDate());
        }
        if (!inEntity.getID_SearchStartDate().isEmpty()) {
            sql.where(" Kinrijyoho.DateTime_DocUpdate <= ?", inEntity.getID_SearchEndDate());
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
     * @param inEntity Ut003_03GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Ut003_03GetResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        Map<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("Kinrijyoho.DateTime_DocUpdate", "DESC");
        orderMap.put("Kinrijyoho.ID_DocName", "ASC");
        sql.orderBy(orderMap);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}