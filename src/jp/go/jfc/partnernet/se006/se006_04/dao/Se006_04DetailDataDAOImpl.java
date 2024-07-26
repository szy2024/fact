//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_04DetailDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/01 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_04.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_04DetailDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_04DetailDataDAOImpl extends PNBaseDAO<Se006_04DetailDataEntity> implements
        Se006_04DetailDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se006_04DetailDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataDAO#countByCondition(jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataEntity)
     */
    @Override
    public long countByCondition(Se006_04DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se006_04DetailDataEntity
     * @return List&lt;Se006_04DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataEntity)
     */
    @Override
    public List<Se006_04DetailDataEntity> findByCondition(Se006_04DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_04DetailDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se006_04DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_04DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataEntity,
     *      int, int)
     */
    @Override
    public List<Se006_04DetailDataEntity> findByCondition(Se006_04DetailDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_04DetailDataEntity.class, offset, length);
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

        // 複数テーブルアクセス参照
        sql.append("SELECT");
        sql.append(" ReportHistory.ErrorMessage ");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_04DetailDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_04DetailDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　　履歴番号　＝　報告書履歴検索結果画面で指定した履歴番号
         */
        sql.append("FROM");
        sql.append(" ReportHistory ");
        sql.where(" ReportHistory.ID_History = ? ", inEntity.getID_History());

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_04DetailDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_04DetailDataEntity inEntity) {

    }
}