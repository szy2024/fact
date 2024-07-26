//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr003_02ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_02ResultDataDAOImpl extends PNBaseDAO<Cr003_02ResultDataEntity> implements
        Cr003_02ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr003_02ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataDAO#countByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr003_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr003_02ResultDataEntity
     * @return List&lt;Cr003_02ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataEntity)
     */
    @Override
    public List<Cr003_02ResultDataEntity> findByCondition(Cr003_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr003_02ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr003_02ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr003_02ResultDataEntity> findByCondition(Cr003_02ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02ResultDataEntity.class, offset, length);
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
        sql.append("SELECT ");
        sql.append("GanjuReportView.Code_ShokanHonShiten,");
        sql.append("GanjuReportView.Code_Organization,");
        sql.append("GanjuReportView.Code_Tenpo,");
        sql.append("GanjuReportView.Year,");
        sql.append("GanjuReportView.Code_HoshikiShikin,");
        sql.append("GanjuReportView.ID_Ringi,");
        sql.append("GanjuReportView.Code_ShikinShito,");
        sql.append("GanjuReportView.Riritsu,");
        sql.append("GanjuReportView.Kubun_Tokuri,");
        sql.append("GanjuReportView.Tokuri,");
        sql.append("GanjuReportView.Date_SueokiKigen,");
        sql.append("GanjuReportView.Date_ShokanKigen,");
        sql.append("GanjuReportView.Date_GanrikinHaraiKomi,");
        sql.append("GanjuReportView.M_Kashitsuke,");
        sql.append("GanjuReportView.ID_Credit,");
        sql.append("GanjuReportView.Name_Organization,");
        sql.append("GanjuReportView.Name_Customer,");
        sql.append("GanjuReportView.ID_RingiBranch,");
        sql.append("GanjuReportView.Code_Jigyobetsu,");
        sql.append("GanjuReportView.Flag_Kj,");
        sql.append("GanjuReportView.Code_Customer,");
        sql.append("GanjuReportView.Date_Jikko,");
        sql.append("GanjuReportView.M_Fukin,");
        sql.append("GanjuReportView.M_KashitsukeZandaka,");
        sql.append("GanjuReportView.Code_ShokanHouhou,");
        sql.append("GanjuReportView.Count_KashitsukeZandaka,");
        sql.append("GanjuReportView.ID_Report,");
        sql.append("GanjuReportView.Date_Report,");
        sql.append("GanjuReportView.Time_Report,");
        sql.append("GanjuReportView.UserID,");
        sql.append("GanjuReportView.ID_Denso,");
        sql.append("GanjuReportView.DataCode,");
        sql.append("GanjuReportView.Date_Jtkshori,");
        sql.append("GanjuReportView.Date_Nyukin,");
        sql.append("GanjuReportView.M_ChienSongai,");
        sql.append("GanjuReportView.M_Haraikomi,");
        sql.append("GanjuReportView.M_KojoRisoku,");
        sql.append("GanjuReportView.M_Iyaku,");
        sql.append("GanjuReportView.M_IyakuRishikeigen,");
        sql.append("GanjuReportView.M_KariukeIppanJuto,");
        sql.append("GanjuReportView.M_SashihikiHaraikomi,");
        sql.append("GanjuReportView.M_ZangankinAfterHaraikomi,");
        sql.append("GanjuReportView.Date_Sokin,");
        sql.append("GanjuReportView.ID_Sokinbi,");
        sql.append("GanjuReportView.ID_History,");
        sql.append("GanjuReportView.Status,");
        sql.append("GanjuReportView.Type_Process,");
        sql.append("GanjuReportView.Flag_Torikeshizumi,");
        sql.append("GanjuReportView.Code_Error,");
        sql.append("GanjuReportView.ErrorMessage,");
        sql.append("GanjuReportView.Keep_M_Fukin,");
        sql.append("GanjuReportView.Keep_M_GankinFukinto,");
        sql.append("GanjuReportView.Keep_Kubun_GankinFukinto,");
        sql.append("GanjuReportView.Keep_M_KashitsukeZan,");
        sql.append("GanjuReportView.Keep_M_YakujoGankin,");
        sql.append("GanjuReportView.Keep_M_YakujoRisoku,");
        sql.append("GanjuReportView.Keep_Date_ShokanKigen,");
        sql.append("GanjuReportView.ID_Master,");
        sql.append("GanjuReportView.SignData,");
        sql.append("GanjuReportView.DateTime_LastDataTeikyou,");
        sql.append("GanjuReportView.DateTime_LastDataTorikomi,");
        sql.append("GanjuReportView.Date_Haraikomi,");
        sql.append("GanjuReportView.Count_Zandaka,");
        sql.append("GanjuReportView.M_YakujoGankin,");
        sql.append("GanjuReportView.M_YakujoRisoku,");
        sql.append("GanjuReportView.Date_TokuriYuko,");
        sql.append("GanjuReportView.M_GankinFukinto,");
        sql.append("GanjuReportView.Kubun_GankinFukintogaku,");
        sql.append("GanjuReportView.Yakujo_M_SeiKuriRisoku,");
        sql.append("GanjuReportView.Seikyu_M_SeiKuriGankin,");
        sql.append("GanjuReportView.Seikyu_M_NinKuriRisoku,");
        sql.append("GanjuReportView.Seikyu_M_SeiKuriRisoku,");
        sql.append("GanjuReportView.Kubun_JutoJunjoHenko,");
        sql.append("GanjuReportView.Data_LastUpDate ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr003_02ResultDataEntity inEntity) {
        sql.append("FROM GanjuReportView ");

        // ログインユーザーの扱店コードを取得
        String strOrganization = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            strOrganization = commonInfo.getCode_Organization();
        }
        /*
         * １．FROM句、WHERE句の設定 　　入力引数の検索条件によりwhere句を切り替える
         */
        // 　　（１）入力引数の検索条件が”１”（約定元金、約定利息が有額のデータ）の場合
        if ("1".equals(inEntity.getCr003_02Kind())) {
            // 払込年月日＝入力引数の払込期日　かつ 　　　　　（約定元金＞０　又は　約定利息＞０）
            sql.append("WHERE GanjuReportView.Date_Haraikomi = ? AND ", inEntity.getCr003_02Date_Haraikomi());
            sql.append("(GanjuReportView.M_YakujoGankin > 0 OR GanjuReportView.M_YakujoRisoku > 0)");
        }

        // 　　（２）入力引数の検索条件が”2”（約定元金、約定利息が０のデータ）の場合 　　　　　
        if ("2".equals(inEntity.getCr003_02Kind())) {
            // 払込年月日＝入力引数の払込期日　かつ 　　　　　（約定元金＝ＮＵＬＬ　又は　約定元金＝０）　かつ
            // 　　　　　（約定利息＝ＮＵＬＬ　又は　約定利息＝０）
            sql.append("WHERE GanjuReportView.Date_Haraikomi = ? AND ", inEntity.getCr003_02Date_Haraikomi());
            sql.append("(GanjuReportView.M_YakujoGankin IS NULL OR GanjuReportView.M_YakujoGankin = 0) AND ");
            sql.append("(GanjuReportView.M_YakujoRisoku IS NULL OR GanjuReportView.M_YakujoRisoku = 0)");
        }
        sql.append(" AND GanjuReportView.Code_Organization = ? ", strOrganization);

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr003_02ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append(" GanjuReportView.Code_ShokanHonShiten ASC ,");
        sql.append(" GanjuReportView.Code_Organization ASC ,");
        sql.append(" GanjuReportView.Code_Tenpo ASC ,");
        sql.append(" GanjuReportView.Year ASC ,");
        sql.append(" CAST(GanjuReportView.ID_Ringi AS int) ASC ,");
        sql.append(" CAST(GanjuReportView.ID_RingiBranch AS int) ASC ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}