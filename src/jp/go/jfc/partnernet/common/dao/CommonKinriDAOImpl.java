//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : CommonKinriDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCommonKinriDAOの実装クラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class CommonKinriDAOImpl extends PNBaseDAO<CommonKinriEntity> implements CommonKinriDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity CommonKinriEntity
     * @return 該当件数
     */
    @Override
    public long countByCondition(CommonKinriEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity CommonKinriEntity
     * @return List&lt;CommonKinriEntity&gt;
     */
    @Override
    public List<CommonKinriEntity> findByCondition(CommonKinriEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, CommonKinriEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity CommonKinriEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;CommonKinriEntity&gt;
     */
    @Override
    public List<CommonKinriEntity> findByCondition(CommonKinriEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, CommonKinriEntity.class, offset, length);
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
        sql.append(" Riritsu, ");
        sql.append(" RishiJoseiRitsu ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity CommonKinriEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, CommonKinriEntity inEntity) {

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM Kinri ");
        sql.append(" WHERE ");
        sql.append("Code_KinriKosho = ?", inEntity.getCode_KinriKosho());
        sql.append(" AND ");
        sql.append("Code_KinriKoshoSaimoku = ?", inEntity.getCode_KinriKoshoSaimoku());
        sql.append(" AND ");
        sql.append("Date_TekiyouStart <= ?", inEntity.getDate_TekiyouStart());
        sql.append(" AND ");
        sql.append("Date_TekiyouEnd >= ?", inEntity.getDate_TekiyouEnd());
        sql.append(" AND ");
        sql.append("Years_KashitsukeKikan = ?", inEntity.getYears_KashitsukeKikan());

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity CommonKinriEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, CommonKinriEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // sql.append(" ORDER BY ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}