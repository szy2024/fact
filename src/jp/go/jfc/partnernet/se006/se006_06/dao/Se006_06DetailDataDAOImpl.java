//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_06DetailDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/23 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_06.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_06DetailDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_06DetailDataDAOImpl extends PNBaseDAO<Se006_06DetailDataEntity> implements
        Se006_06DetailDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se006_06DetailDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataDAO#countByCondition(jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataEntity)
     */
    @Override
    public long countByCondition(Se006_06DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se006_06DetailDataEntity
     * @return List&lt;Se006_06DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataEntity)
     */
    @Override
    public List<Se006_06DetailDataEntity> findByCondition(Se006_06DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_06DetailDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se006_06DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_06DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataEntity,
     *      int, int)
     */
    @Override
    public List<Se006_06DetailDataEntity> findByCondition(Se006_06DetailDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_06DetailDataEntity.class, offset, length);
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
        sql.append(" UkeireReport.ID_Report,");
        sql.append(" UkeireReport.Date_Report,");
        sql.append(" UkeireReport.Time_Report,");
        sql.append(" UkeireReport.UserID,");
        sql.append(" UkeireReport.ID_Denso,");
        sql.append(" UkeireReport.DataCode,");
        sql.append(" UkeireReport.Code_KoukoShiten,");
        sql.append(" UkeireReport.Code_Organization,");
        sql.append(" UkeireReport.Code_Tenpo,");
        sql.append(" UkeireReport.Date_Jtkshori,");
        sql.append(" UkeireReport.Year,");
        sql.append(" UkeireReport.Code_HoshikiShikin,");
        sql.append(" UkeireReport.ID_Ringi,");
        sql.append(" UkeireReport.ID_RingiBranch,");
        sql.append(" UkeireReport.Date_FirstYakujoAfterGanju,");
        sql.append(" UkeireReport.Date_HaraidashiJuto,");
        sql.append(" UkeireReport.Code_KurishoJiyu,");
        sql.append(" UkeireReport.M_Haraidashi,");
        sql.append(" UkeireReport.M_Ganju,");
        sql.append(" UkeireReport.M_Kei,");
        sql.append(" UkeireReport.M_KashitsukeukeireZan,");
        sql.append(" UkeireReport.M_KashitsukeZandakaAfterGanju,");
        sql.append(" UkeireReport.M_GankinKintoAfterGanju,");
        sql.append(" UkeireReport.M_GankinFukintoAfterGanju,");
        sql.append(" UkeireReport.Code_Chosei,");
        sql.append(" UkeireReport.Code_ShikinShito,");
        sql.append(" UkeireReport.Code_Jigyobetsu,");
        sql.append(" UkeireReport.Riritsu,");
        sql.append(" UkeireReport.Code_TokuriKubun,");
        sql.append(" UkeireReport.Tokuri,");
        sql.append(" UkeireReport.Date_SueokiKigen,");
        sql.append(" UkeireReport.Date_ShokanKigen,");
        sql.append(" UkeireReport.Date_GanrikinHaraikomi,");
        sql.append(" UkeireReport.Date_Jikko,");
        sql.append(" UkeireReport.M_Kashitsuke,");
        sql.append(" UkeireReport.M_ShikinKofu,");
        sql.append(" UkeireReport.M_KashitsukeUkeire,");
        sql.append(" UkeireReport.Name_Organization,");
        sql.append(" UkeireReport.Name_Customer");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_06DetailDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_06DetailDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　報告書番号　＝　報告書履歴検索結果画面の指定した報告書番号
         */
        sql.append(" FROM UkeireReport ");
        sql.where("UkeireReport.ID_Report = ?", inEntity.getID_Report());

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_06DetailDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_06DetailDataEntity inEntity) {
    }
}