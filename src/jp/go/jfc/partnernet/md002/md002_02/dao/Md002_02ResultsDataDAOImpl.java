//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd002_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_02ResultsDataDAOImpl extends PNBaseDAO<Md002_02ResultsDataEntity> implements
        Md002_02ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md002_02ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataDAO#countByCondition(jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataEntity)
     */
    @Override
    public long countByCondition(Md002_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md002_02ResultsDataEntity
     * @return List&lt;Md002_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataEntity)
     */
    @Override
    public List<Md002_02ResultsDataEntity> findByCondition(Md002_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_02ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md002_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md002_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Md002_02ResultsDataEntity> findByCondition(Md002_02ResultsDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_02ResultsDataEntity.class, offset, length);
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
        sql.append("SELECT UkeireHaraidashiMDView.Date_Report");
        sql.append(",UkeireHaraidashiMDView.Name_Customer");
        sql.append(",UkeireHaraidashiMDView.Name_Organization");
        sql.append(",UkeireHaraidashiMDView.Code_KoukoShiten");
        sql.append(",UkeireHaraidashiMDView.Code_Organization");
        sql.append(",UkeireHaraidashiMDView.Code_Tenpo");
        sql.append(",UkeireHaraidashiMDView.Year");
        sql.append(",UkeireHaraidashiMDView.Code_HoshikiShikin");
        sql.append(",UkeireHaraidashiMDView.ID_Ringi");
        sql.append(",UkeireHaraidashiMDView.ID_RingiBranch");
        sql.append(",UkeireHaraidashiMDView.Code_ShikinShito");
        sql.append(",UkeireHaraidashiMDView.Code_Jigyobetsu");
        sql.append(",UkeireHaraidashiMDView.Riritsu");
        sql.append(",UkeireHaraidashiMDView.Code_TokuriKubun");
        sql.append(",UkeireHaraidashiMDView.Tokuri");
        sql.append(",UkeireHaraidashiMDView.Date_SueokiKigen");
        sql.append(",UkeireHaraidashiMDView.Date_ShokanKigen");
        sql.append(",UkeireHaraidashiMDView.Date_GanrikinHaraikomi");
        sql.append(",UkeireHaraidashiMDView.Date_Jikko");
        sql.append(",UkeireHaraidashiMDView.M_Kashitsuke");
        sql.append(",UkeireHaraidashiMDView.M_ShikinKofu");
        sql.append(",UkeireHaraidashiMDView.M_KashitsukeUkeire");
        sql.append(",UkeireHaraidashiMDView.Date_Jtkshori");
        sql.append(",UkeireHaraidashiMDView.Date_HaraidashiJuto");
        sql.append(",UkeireHaraidashiMDView.M_Haraidashi");
        sql.append(",UkeireHaraidashiMDView.M_Ganju");
        sql.append(",UkeireHaraidashiMDView.M_KashitsukeukeireZan");
        sql.append(",UkeireHaraidashiMDView.M_KashitsukeZandakaAfterGanju");
        sql.append(",UkeireHaraidashiMDView.Date_FirstYakujoAfterGanju");
        sql.append(",UkeireHaraidashiMDView.Code_KurishoJiyu");
        sql.append(",UkeireHaraidashiMDView.M_GankinKintoAfterGanju");
        sql.append(",UkeireHaraidashiMDView.M_GankinFukintoAfterGanju");
        sql.append(",UkeireHaraidashiMDView.Code_Chosei");
        sql.append(",UkeireHaraidashiMDView.ID_Report");
        sql.append(",UkeireHaraidashiMDView.Time_Report");
        sql.append(",UkeireHaraidashiMDView.UserID");
        sql.append(",UkeireHaraidashiMDView.ID_Denso");
        sql.append(",UkeireHaraidashiMDView.DataCode");
        sql.append(",UkeireHaraidashiMDView.M_Kei");
        sql.append(",UkeireHaraidashiMDView.ID_History");
        sql.append(",UkeireHaraidashiMDView.Status");
        sql.append(",UkeireHaraidashiMDView.Type_Process");
        sql.append(",UkeireHaraidashiMDView.Flag_Torikeshizumi");
        sql.append(",UkeireHaraidashiMDView.Code_Error");
        sql.append(",UkeireHaraidashiMDView.ErrorMessage");
        sql.append(",UkeireHaraidashiMDView.ID_Credit");
        sql.append(",UkeireHaraidashiMDView.Keep_M_Fukin");
        sql.append(",UkeireHaraidashiMDView.Keep_M_GankinFukinto");
        sql.append(",UkeireHaraidashiMDView.Keep_Kubun_GankinFukinto");
        sql.append(",UkeireHaraidashiMDView.Keep_M_KashitsukeZan");
        sql.append(",UkeireHaraidashiMDView.Keep_M_YakujoGankin");
        sql.append(",UkeireHaraidashiMDView.Keep_M_YakujoRisoku");
        sql.append(",UkeireHaraidashiMDView.Keep_Date_ShokanKigen");
        sql.append(",UkeireHaraidashiMDView.M_Fukin_Ringi");
        sql.append(",UkeireHaraidashiMDView.M_GankinFukinto_Ringi");
        sql.append(",UkeireHaraidashiMDView.Kubun_GankinFukintogaku_Ringi");
        sql.append(",UkeireHaraidashiMDView.M_KashitsukeZandaka_Ringi");
        sql.append(",UkeireHaraidashiMDView.Date_ShokanKigen_Ringi");
        sql.append(",UkeireHaraidashiMDView.Date_SaishinHenko_Ringi");
        sql.append(",UkeireHaraidashiMDView.Code_ShokanHouhou_Ringi");
        sql.append(",UkeireHaraidashiMDView.Date_TokuriYuko_Ringi");
        sql.append(",UkeireHaraidashiMDView.Kubun_JohenKianchu_Ringi");
        sql.append(",UkeireHaraidashiMDView.Keep_JohenKianchu");
        sql.append(",UkeireHaraidashiMDView.Code_Customer");
        sql.append(",UkeireHaraidashiMDView.Data_LastUpDate");
        sql.append(",UkeireHaraidashiMDView.Keep_ID_History");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_02ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md002_02ResultsDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　報告書番号　＝　指定された報告書番号
         */

        sql.append(" FROM ");
        sql.append(" UkeireHaraidashiMDView ");
        sql.whereEqual(" UkeireHaraidashiMDView.ID_Report", inEntity.getID_Report());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_02ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md002_02ResultsDataEntity inEntity) {
    }
}