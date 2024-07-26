//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_09DetailDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_09.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_09DetailDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_09DetailDataDAOImpl extends PNBaseDAO<Se006_09DetailDataEntity> implements
        Se006_09DetailDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se006_09DetailDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataDAO#countByCondition(jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataEntity)
     */
    @Override
    public long countByCondition(Se006_09DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se006_09DetailDataEntity
     * @return List&lt;Se006_09DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataEntity)
     */
    @Override
    public List<Se006_09DetailDataEntity> findByCondition(Se006_09DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_09DetailDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se006_09DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_09DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataEntity,
     *      int, int)
     */
    @Override
    public List<Se006_09DetailDataEntity> findByCondition(Se006_09DetailDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_09DetailDataEntity.class, offset, length);
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

        sql.append("SELECT");
        sql.append(" DaibensaiReport.ID_Report,");
        sql.append(" DaibensaiReport.Date_Report,");
        sql.append(" DaibensaiReport.Time_Report,");
        sql.append(" DaibensaiReport.UserID,");
        sql.append(" DaibensaiReport.ID_Denso,");
        sql.append(" DaibensaiReport.DataCode,");
        sql.append(" DaibensaiReport.Code_KoukoShiten,");
        sql.append(" DaibensaiReport.Code_Organization,");
        sql.append(" DaibensaiReport.Code_Tenpo,");
        sql.append(" DaibensaiReport.Date_Jtkshori,");
        sql.append(" DaibensaiReport.Date_Sokin,");
        sql.append(" DaibensaiReport.ID_Sokinbi,");
        sql.append(" DaibensaiReport.Year,");
        sql.append(" DaibensaiReport.Code_HoshikiShikin,");
        sql.append(" DaibensaiReport.ID_Ringi,");
        sql.append(" DaibensaiReport.ID_RingiBranch,");
        sql.append(" DaibensaiReport.Date_JutoTaisho,");
        sql.append(" DaibensaiReport.Date_DaibenkinHaraikomi,");
        sql.append(" DaibensaiReport.M_ChienSongai,");
        sql.append(" DaibensaiReport.M_Risoku,");
        sql.append(" DaibensaiReport.M_Gankin,");
        sql.append(" DaibensaiReport.M_Kei,");
        sql.append(" DaibensaiReport.M_KariukeIppanJuto,");
        sql.append(" DaibensaiReport.M_ZanGanAfterDaibenJuto,");
        sql.append(" DaibensaiReport.M_KurishoCommission,");
        sql.append(" DaibensaiReport.M_Sokin,");
        sql.append(" DaibensaiReport.Name_Organization,");
        sql.append(" DaibensaiReport.Name_Customer");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_09DetailDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_09DetailDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　報告書番号　＝　報告書履歴検索結果画面の指定した報告書番号
         */
        sql.append(" FROM DaibensaiReport ");
        sql.where("DaibensaiReport.ID_Report = ?", inEntity.getID_Report());

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_09DetailDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_09DetailDataEntity inEntity) {
    }
}