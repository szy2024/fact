//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr010_01ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr010_01ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr010_01ResultDataDAOImpl extends PNBaseDAO<Cr010_01ResultDataEntity> implements Cr010_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr010_01ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr010_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr010_01ResultDataEntity
     * @return List&lt;Cr010_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataEntity)
     */
    @Override
    public List<Cr010_01ResultDataEntity> findByCondition(Cr010_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr010_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr010_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr010_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01ResultDataEntity,int, int)
     */
    @Override
    public List<Cr010_01ResultDataEntity> findByCondition(Cr010_01ResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr010_01ResultDataEntity.class,
                offset, length);
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
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr010_01ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr010_01ResultDataEntity inEntity) {

        /*
         * １．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　資金交付依頼予定表（月間）報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　資金交付依頼予定表（月間）報告書データ.報告書番号
         *
         * ２．WHERE句の設定
         * 　　　　資金交付依頼予定表（月間）報告書データ.扱店コード ＝ 入力引数.扱店コード　かつ
         * 　　　　資金交付依頼予定表（月間）報告書データ.交付依頼年月 ＝ 入力引数.交付依頼年月
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN ShikinkofuGekkanReport SG ON ReportHistoryModView.ID_Report = SG.ID_Report");
        sql.append(" WHERE");
        sql.append(" SG.Code_Organization = ?", inEntity.getCode_Organization());
        sql.append(" AND SG.Date_KofuIrai = ?", inEntity.getDate_KofuIrai());

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr010_01ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr010_01ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}