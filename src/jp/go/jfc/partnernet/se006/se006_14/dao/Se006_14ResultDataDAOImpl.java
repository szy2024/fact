//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_14ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/03 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_14.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_14ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_14ResultDataDAOImpl extends PNBaseDAO<Se006_14ResultDataEntity> implements Se006_14ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se006_14ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataEntity)
     */
    @Override
    public long countByCondition(Se006_14ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se006_14ResultDataEntity
     * @return List&lt;Se006_14ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataEntity)
     */
    @Override
    public List<Se006_14ResultDataEntity> findByCondition(Se006_14ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_14ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se006_14ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_14ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_14.dao.Se006_14ResultDataEntity, int, int)
     */
    @Override
    public List<Se006_14ResultDataEntity> findByCondition(Se006_14ResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_14ResultDataEntity.class, offset, length);
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
        sql.append(" SELECT ");
        sql.append(" RG.Date_KofuIrai, ");
        sql.append(" RG.Date_Kofu, ");
        sql.append(" RG.M_Irai_ShikinKofu, ");
        sql.append(" RG.M_Ganju ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_14ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_14ResultDataEntity inEntity) {

        /*
         * １．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　資金交付依頼予定表（月間）報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　資金交付依頼予定表（月間）報告書データ.報告書番号
         * 
         * ２．WHERE句の設定
         * 　　　　報告書番号 ＝ 入力引数.報告書番号
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM ReportHistoryModView RH ");
        sql.append(" LEFT OUTER JOIN ShikinkofuGekkanReport RG ON  ");
        sql.append("  RH.ID_Report = RG.ID_Report ");

        sql.where(" RG.ID_Report = ?", inEntity.getID_Report());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_14ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_14ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        Map<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("RG.ID_Edaban", "ASC");
        sql.orderBy(orderMap);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}