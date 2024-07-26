//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr012_01ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr012_01ResultDataDAOImpl extends PNBaseDAO<Cr012_01ResultDataEntity> implements Cr012_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity
     *            Cr012_01ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr012_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity
     *            Cr012_01ResultDataEntity
     * @return List&lt;Cr012_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataEntity)
     */
    @Override
    public List<Cr012_01ResultDataEntity> findByCondition(Cr012_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr012_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity
     *            Cr012_01ResultDataEntity
     * @param offset
     *            取得開始位置
     * @param length
     *            取得開始位置からの取得件数
     * @return List&lt;Cr012_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr012.cr012_01.dao.Cr012_01ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr012_01ResultDataEntity> findByCondition(Cr012_01ResultDataEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr012_01ResultDataEntity.class, offset, length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql
     *            XCMSqlBuilder
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
     * @param sql
     *            XCMSqlBuilder
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
     * @param sql
     *            XCMSqlBuilder
     * @param inEntity
     *            Cr012_01ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr012_01ResultDataEntity inEntity) {

        // １．SELECT句の設定 　　Count(1) 　　※件数を取得する。
        //
        // ２．FROM句の設定
        // 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　包括委任状等の交付依頼報告書データ
        // 　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　包括委任状等の交付依頼報告書データ.報告書番号
        //
        // ３．WHERE句の設定
        // 　　　　報告書取消・修正対象取得ビュー.報告年月日 ＝ 入力引数.報告年月日
        // 　　　　AND　報告書取消・修正対象取得ビュー.扱店コード ＝ 入力引数.扱店
        //
        // □利用者の権限種別＝農林中金（本店）または利用者の権限種別＝農林中金（支店）の場合
        // 　　　　AND 　報告書取消・修正対象取得ビュー.店舗コード ＝ 入力引数.店舗

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN HokatsuReport HK ON ReportHistoryModView.ID_Report = HK.ID_Report");
        sql.append(" WHERE");
        sql.append(" HK.Date_Report = ?", inEntity.getDate_report());
        sql.append(" AND HK.Code_Organization = ?", inEntity.getCode_organization());
        if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(inEntity.getRolecode())
                || PNCommonConstants.ROLECODE_NOURINSHITEN.equals(inEntity.getRolecode())) {
            sql.append(" AND HK.Code_Tenpo = ?", inEntity.getCode_tenpo());
        }
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql
     *            XCMSqlBuilder
     * @param inEntity
     *            Cr012_01ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr012_01ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}