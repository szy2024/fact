//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md012_01ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md012.md012_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd012_01ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md012_01ResultDataDAOImpl extends PNBaseDAO<Md012_01ResultDataEntity> implements Md012_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Md012_01ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Md012_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere2(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Md012_01ResultDataEntity
     * @return List&lt;Md012_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataEntity)
     */
    @Override
    public List<Md012_01ResultDataEntity> findByCondition(Md012_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md012_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Md012_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md012_01ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md012.md012_01.dao.Md012_01ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Md012_01ResultDataEntity> findByCondition(Md012_01ResultDataEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md012_01ResultDataEntity.class, offset, length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
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
        // 履歴番号
        sql.append(" ReportHistoryModView.ID_History ");
        // 報告書番号
        sql.append(", HokatsuReport.ID_Report ");
        // 報告年月日
        sql.append(", HokatsuReport.Date_Report ");
        // 扱店コード
        sql.append(", HokatsuReport.Code_Organization ");
        // 店舗コード
        sql.append(", HokatsuReport.Code_Tenpo ");
        // 包括委任状数量
        sql.append(", HokatsuReport.Su_HokatsuInin ");
        // 現在事項一部証明書数量
        sql.append(", HokatsuReport.Su_GenzaiJiko ");
        // 印鑑証明書数量
        sql.append(", HokatsuReport.Su_InkanShohmei ");
        // 変更抄本数量
        sql.append(", HokatsuReport.Su_HenkoShohhon ");
        // 新閉鎖謄本数量
        sql.append(", HokatsuReport.Su_SinHeisa ");
        // 旧閉鎖抄本数量
        sql.append(", HokatsuReport.Su_KyuHeisa ");
        // 閉鎖事項全部証明書数量
        sql.append(", HokatsuReport.Su_HeisaJiko ");
        // 至急発行フラグ
        sql.append(", HokatsuReport.Flag_ShikyuHakko ");
        // 更新日時
        sql.append(", HokatsuReport.DateTime_Update ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md012_01ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md012_01ResultDataEntity inEntity) {

        /*
         * １．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　包括委任状等の交付依頼報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　包括委任状等の交付依頼報告書データ.報告書番号
         *
         * ２．WHERE句の設定
         * 　　　　報告書番号 ＝ 入力引数.報告書番号
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN HokatsuReport ON ReportHistoryModView.ID_Report = HokatsuReport.ID_Report");
        sql.append(" WHERE");
        sql.append(" HokatsuReport.ID_Report = ?", inEntity.getId_report());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md012_01ResultDataEntity
     */
    private void makeSqlWhere2(PNSqlBuilder sql, Md012_01ResultDataEntity inEntity) {

        /*
         * １．SELECT句の設定
         * 　　Count(1) 　　※件数を取得する。
         *
         * ２．FROM句の設定
         * 　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　包括委任状等の交付依頼報告書データ
         * 　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　包括委任状等の交付依頼報告書データ.報告書番号
         *
         * ３．WHERE句の設定
         * 　　　　報告書取消・修正対象取得ビュー.報告書番号 ＜＞ 入力引数．報告書番号 かつ
         * 　　　　報告書取消・修正対象取得ビュー.報告年月日 ＝ 入力引数.報告年月日 かつ
         * 　　　　報告書取消・修正対象取得ビュー.扱店コード ＝ 入力引数.扱店
         * □利用者の権限種別＝農林中金（本店）または利用者の権限種別＝農林中金（支店）の場合
         * 　 かつ 報告書取消・修正対象取得ビュー.店舗コード ＝ 入力引数.店舗
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN HokatsuReport HK ON ReportHistoryModView.ID_Report = HK.ID_Report");
        sql.append(" WHERE");
        sql.append(" HK.ID_Report <> ?", inEntity.getId_report());
        sql.append(" AND HK.Date_Report = ?", inEntity.getDate_report());
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
     * @param sql PNSqlBuilder
     * @param inEntity Md012_01ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md012_01ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}