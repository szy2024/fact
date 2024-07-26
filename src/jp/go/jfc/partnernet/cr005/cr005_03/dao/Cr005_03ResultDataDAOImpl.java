//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr005_03ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_03ResultDataDAOImpl extends PNBaseDAO<Cr005_03ResultDataEntity> implements
        Cr005_03ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr005_03ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataDAO#countByCondition(jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr005_03ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr005_03ResultDataEntity
     * @return List&lt;Cr005_03ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataEntity)
     */
    @Override
    public List<Cr005_03ResultDataEntity> findByCondition(Cr005_03ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr005_03ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr005_03ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr005_03ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_03.dao.Cr005_03ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr005_03ResultDataEntity> findByCondition(Cr005_03ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr005_03ResultDataEntity.class, offset, length);
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
        sql.append(" A.Code_ShokanHonShiten, ");
        sql.append(" A.Code_Organization,");
        sql.append(" A.Code_Tenpo,");
        sql.append(" A.Year,");
        sql.append(" A.Kubun_Hoshiki,");
        sql.append(" A.Kubun_Shikin,");
        sql.append(" A.ID_Ringi,");
        sql.append(" A.ID_RingiBranch,");
        sql.append(" A.Code_Customer,");
        sql.append(" A.Date_Jikko,");
        sql.append(" A.Code_TorihikiTeishi,");
        sql.append(" A.Kubun_JohenKianchu,");
        sql.append(" A.ID_Credit,");
        sql.append(" A.Name_Customer,");
        sql.append(" A.Name_Organization ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr005_03ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr005_03ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　　「貸付先コード」＝入力引数の貸付先コード入力値 かつ 　　　　「扱店コード」＝入力引数のログインユーザの扱店コード かつ 　　　　「実行年月日」≠
         * NULL　かつ　「実行年月日」≠０　かつ 　　　　（「取引停止案件コード」＝ NULL または スペース または 空文字）
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        sql.append("FROM");
        sql.append(" DaibensaiReportView A ");
        sql.append("WHERE");
        sql.append(" A.Code_Customer = ?", inEntity.getCr005_03_In_Code_Customer());
        sql.append(" AND A.Code_Organization = ?", inEntity.getCr005_03_Code_Organization());
        sql.append(" AND A.Date_Jikko IS NOT NULL");
        sql.append(" AND A.Date_Jikko <> 0");
        sql.append(" AND ( ");
        sql.append(" A.Code_TorihikiTeishi IS NULL ");
        sql.append(" OR A.Code_TorihikiTeishi = ' '");
        sql.append(" OR A.Code_TorihikiTeishi = ''");
        sql.append(" ) ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr005_03ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr005_03ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        sql.append("ORDER BY");
        sql.append(" A.Date_Jikko ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}