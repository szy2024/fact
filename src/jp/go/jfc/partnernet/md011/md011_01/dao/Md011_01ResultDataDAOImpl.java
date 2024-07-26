//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md011_01ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd011_01ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md011_01ResultDataDAOImpl extends PNBaseDAO<Md011_01ResultDataEntity> implements Md011_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md011_01ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Md011_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhereCount(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md011_01ResultDataEntity
     * @return List&lt;Md011_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataEntity)
     */
    @Override
    public List<Md011_01ResultDataEntity> findByCondition(Md011_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md011_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md011_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md011_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataEntity, int, int)
     */
    @Override
    public List<Md011_01ResultDataEntity> findByCondition(Md011_01ResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md011_01ResultDataEntity.class,
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
        sql.append("SELECT");
        sql.append(" RH.ID_History,");
        sql.append(" RH.ID_Report,");
        sql.append(" RH.Code_Organization,");
        sql.append(" RH.Code_Tenpo,");
        sql.append(" SS.Date_Kofu,");
        sql.append(" SS.M_Yotei,");
        sql.append(" SS.M_Ganju_GaiSu,");
        sql.append(" SS.M_ZanMikomi,");
        sql.append(" SS.M_Biko,");
        sql.append(" SS.DateTime_Update");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md011_01ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md011_01ResultDataEntity inEntity) {

        /*
         * １．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　資金交付依頼書（週間）報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　資金交付依頼書（週間）報告書データ.報告書番号

         * ２．WHERE句の設定
         * 　　・初期表示時のデータ取得の場合（findByCondition）
         * 　　　　報告書番号 ＝ 入力引数.報告書番号
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView RH");
        sql.append(" LEFT OUTER JOIN ShikinkofuShukanReport SS ON RH.ID_Report = SS.ID_Report");
        sql.append(" WHERE");
        sql.append(" SS.ID_Report = ?", inEntity.getID_Report());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md011_01ResultDataEntity
     */
    private void makeSqlWhereCount(PNSqlBuilder sql, Md011_01ResultDataEntity inEntity) {

        /*
         * １．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　資金交付依頼書（週間）報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　資金交付依頼書（週間）報告書データ.報告書番号

         * ２．WHERE句の設定
         * 　　　　報告書番号 ≠ 入力引数.報告書番号 かつ
         * 　　　　扱店コード ＝ 入力引数.扱店コード かつ
         * 　　　　指定交付日 ＝ 入力引数.指定交付日
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView RH");
        sql.append(" LEFT OUTER JOIN ShikinkofuShukanReport SS ON RH.ID_Report = SS.ID_Report");
        sql.append(" WHERE");
        sql.append(" SS.ID_Report <> ?", inEntity.getID_Report());
        sql.append(" AND SS.Code_Organization = ?", inEntity.getCode_Organization());
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
     * @param inEntity Md011_01ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md011_01ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}