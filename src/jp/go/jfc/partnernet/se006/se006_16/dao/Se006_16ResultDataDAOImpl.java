//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_16ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_16ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
public class Se006_16ResultDataDAOImpl extends PNBaseDAO<Se006_16ResultDataEntity> implements Se006_16ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se006_16ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_16.dao.Se006_16ResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.se006.se006_16.dao.Se006_16ResultDataEntity)
     */
    @Override
    public long countByCondition(Se006_16ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se006_16ResultDataEntity
     * @return List&lt;Se006_16ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_16.dao.Se006_16ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_16.dao.Se006_16ResultDataEntity)
     */
    @Override
    public List<Se006_16ResultDataEntity> findByCondition(Se006_16ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_16ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se006_16ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_16ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_16.dao.Se006_17ResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_16.dao.Se006_16ResultDataEntity, int, int)
     */
    @Override
    public List<Se006_16ResultDataEntity> findByCondition(Se006_16ResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_16ResultDataEntity.class,
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

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_16ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_16ResultDataEntity inEntity) {

        /*
        １．FROM句の設定
        　　報告書取消・修正対象取得ビュー　LEFT　OUTER　JOIN　包括委任状等の交付依頼報告書データ
        　　　　ON　報告書取消・修正対象取得ビュー.報告書番号　＝　包括委任状等の交付依頼報告書データ.報告書番号

        ２．WHERE句の設定
        　　　　報告書番号 ＝ 入力引数.報告書番号

        */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN HokatsuReport ON ReportHistoryModView.ID_Report = HokatsuReport.ID_Report");
        sql.append(" WHERE");
        sql.append(" HokatsuReport.ID_Report = ?", inEntity.getID_Report());

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_16ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_16ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}