//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_05GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_05.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはUt003_05GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut003_05GetResultDataDAOImpl extends PNBaseDAO<Ut003_05GetResultDataEntity> implements
        Ut003_05GetResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Ut003_05GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataDAO#countByCondition(jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataEntity)
     */
    @Override
    public long countByCondition(Ut003_05GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Ut003_05GetResultDataEntity
     * @return List&lt;Ut003_05GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataEntity)
     */
    @Override
    public List<Ut003_05GetResultDataEntity> findByCondition(Ut003_05GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut003_05GetResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Ut003_05GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut003_05GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.ut003.ut003_05.dao.Ut003_05GetResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Ut003_05GetResultDataEntity> findByCondition(Ut003_05GetResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Ut003_05GetResultDataEntity.class, offset, length);
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
        sql.append("   Yoshiki.DateTime_DocUpdate");
        sql.append(" , Yoshiki.ID_DocFileName AS ID_ID_DocFileName");
        sql.append(" , Yoshiki.ID_FormatNumber");
        sql.append(" , Yoshiki.ID_DocName");
        sql.append(" , Yoshiki.ID_Data");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Ut003_05GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Ut003_05GetResultDataEntity inEntity) {

        /*
         * ・検索開始日が設定されている場合 　検索開始日 <= 情報登録日付
         * 
         * ・検索終了日が設定されている場合 　検索終了日 >= 情報登録日付
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM Yoshiki ");
        if (!inEntity.getID_SearchStartDate().isEmpty()) {
            sql.where(" Yoshiki.DateTime_DocUpdate >= ?", inEntity.getID_SearchStartDate());
        }
        if (!inEntity.getID_SearchStartDate().isEmpty()) {
            sql.where(" Yoshiki.DateTime_DocUpdate <= ?", inEntity.getID_SearchEndDate());
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
     * @param inEntity Ut003_05GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Ut003_05GetResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        Map<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("Yoshiki.DateTime_DocUpdate", "DESC");
        orderMap.put("Yoshiki.ID_FormatNumber", "ASC");
        orderMap.put("Yoshiki.ID_DocName", "ASC");
        sql.orderBy(orderMap);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}