//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr011_01ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr011_01ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr011_01ResultDataDAOImpl extends
        PNBaseDAO<Cr011_01ResultDataEntity> implements Cr011_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr011_01ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr011_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr011_01ResultDataEntity
     * @return List&lt;Cr011_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataEntity)
     */
    @Override
    public List<Cr011_01ResultDataEntity> findByCondition(Cr011_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr011_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr011_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr011_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr011.cr011_01.dao.Cr011_01ResultDataEntity, int, int)
     */
    @Override
    public List<Cr011_01ResultDataEntity> findByCondition(Cr011_01ResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr011_01ResultDataEntity.class,
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
     * @param inEntity Cr011_01ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr011_01ResultDataEntity inEntity) {

        /*
        １．SELECT句の設定
            COUNT(1)
            ※件数を取得する。

        ２．FROM句の設定
            報告書取消・修正対象取得ビュー LEFT OUTER JOIN 資金交付依頼書（週間）報告書データ
            ON報告書取消・修正対象取得ビュー.報告書番号＝資金交付依頼書（週間）報告書データ.報告書番号

        ３．WHERE句の設定
            資金交付依頼書（週間）報告書データ.扱店コード ＝ 入力引数.扱店コードかつ
            資金交付依頼書（週間）報告書データ.指定交付日 ＝ 入力引数.指定交付日

        */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN ShikinkofuShukanReport SS ON ReportHistoryModView.ID_Report = SS.ID_Report");
        sql.append(" WHERE");
        sql.append(" SS.Code_Organization = ?", inEntity.getCode_Organization());
        sql.append(" AND SS.Date_Kofu = ?", inEntity.getDate_Kofu());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr011_01ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr011_01ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}