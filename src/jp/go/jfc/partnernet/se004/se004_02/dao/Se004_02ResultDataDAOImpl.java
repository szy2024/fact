//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_02ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/17 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe004_02ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 2.0.0
 */
public class Se004_02ResultDataDAOImpl extends PNBaseDAO<Se004_02ResultDataEntity> implements
        Se004_02ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataDAO#countByCondition(jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataEntity)
     */
    @Override
    public long countByCondition(Se004_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @return List&lt;Se004_02GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataEntity)
     */
    @Override
    public List<Se004_02ResultDataEntity> findByCondition(Se004_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se004_02ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se004_02GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se004.se004_02.dao.Se004_02ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Se004_02ResultDataEntity> findByCondition(Se004_02ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se004_02ResultDataEntity.class, offset, length);
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
        sql.append("  A.ID_Credit ");
        sql.append(", A.Code_Organization ");
        sql.append(", A.Year ");
        sql.append(", A.Expr1 ");
        sql.append(", A.ID_Ringi ");
        sql.append(", A.ID_RingiBranch ");
        sql.append(", A.Date_Jikko ");
        sql.append(", A.M_Kashitsuke ");
        sql.append(", A.Riritsu ");
        sql.append(", A.Kubun_Tokuri ");
        sql.append(", A.Tokuri ");
        sql.append(", A.Date_SueokiKigen ");
        sql.append(", A.Date_ShokanKigen ");
        sql.append(", A.Date_GanrikinHaraiKomi ");
        sql.append(", A.Code_ShokanHouhou ");
        sql.append(", A.M_Fukin ");
        sql.append(", A.M_KashitsukeZandaka ");
        sql.append(", A.Code_Tenpo ");
        sql.append(", A.Code_ShokanHonShiten ");
        sql.append(", A.Date_TokuriYuko ");
        sql.append(", A.Shihyoritsu ");
        sql.append(", A.Date_Haraikomi ");
        sql.append(", A.M_YakujoRisoku ");
        sql.append(", A.M_YakujoGankin ");
        sql.append(", A.M_Chiensongai_Kei ");
        sql.append(", A.Name_Todofuken ");
        sql.append(", A.Name_Shikugunchoson ");
        sql.append(", A.Name_OazaTsusho ");
        sql.append(", A.Name_AzameiChome ");
        sql.append(", A.Name_Customer ");
        sql.append(", A.Name_KoukoShiten ");
        sql.append(", A.Name_ShikinShito ");
        sql.append(", A.Name_Organization ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se004_02GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se004_02ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　　所管本支店ｺｰﾄﾞ＝入力引数の入力公庫支店コード かつ 　　　　扱店コード＝入力引数の入力扱店コード　かつ
         * 　　　　店舗コード＝入力引数の入力店舗コード　かつ 　　　　年度＝入力引数の年度(西暦)　かつ 　　　　方式区分＝入力引数の方式区分　かつ 　　　　資金区分＝入力引数の資金区分　かつ
         * 　　　　稟議番号＝入力引数の入力番号　かつ 　　　　稟議番号枝番＝入力引数の入力枝番　
         */
        sql.append(" FROM ");
        sql.append("  HARAIKOMIANNAI A ");
// [UPD] Ver 2.0.0 - START
//        sql.append("WHERE ");
//        sql.append("    A.Code_ShokanHonShiten = ? ", inEntity.getCode_ShokanHonShiten());
//        sql.append("AND A.Code_Organization = ? ", inEntity.getCode_Organization());
//        sql.append("AND A.Code_Tenpo = ? ", inEntity.getCode_Tenpo());
//        sql.append("AND A.Year = ? ", inEntity.getYear());
//        sql.append("AND A.Kubun_Hoshiki = ? ", inEntity.getKubun_Hoshiki());
//        sql.append("AND A.Kubun_Shikin = ? ", inEntity.getKubun_Shikin());
//        sql.append("AND A.ID_Ringi = ? ", inEntity.getID_Ringi());
//        sql.append("AND A.ID_RingiBranch = ? ", inEntity.getID_RingiBranch());
        sql.where(" A.Code_ShokanHonShiten = ? ", inEntity.getCode_ShokanHonShiten());
        sql.where(" A.Code_Organization = ? ", inEntity.getCode_Organization());
        sql.where(" A.Code_Tenpo = ? ", inEntity.getCode_Tenpo());
        sql.where(" A.Year = ? ", inEntity.getYear());
        sql.where(" A.Kubun_Hoshiki = ? ", inEntity.getKubun_Hoshiki());
        sql.where(" A.Kubun_Shikin = ? ", inEntity.getKubun_Shikin());
        sql.where(" A.ID_Ringi = ? ", inEntity.getID_Ringi());
        sql.where(" A.ID_RingiBranch = ? ", inEntity.getID_RingiBranch());
// [UPD] Ver 2.0.0 - END
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se004_02GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se004_02ResultDataEntity inEntity) {
        sql.append(" ORDER BY");
        sql.append("  A.ID_Credit DESC");
        sql.append(", A.Date_Haraikomi ASC");
    }
}