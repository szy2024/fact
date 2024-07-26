//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe003_02GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02ResultDataDAOImpl extends PNBaseDAO<Se003_02ResultDataEntity> implements
        Se003_02ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se003_02GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataDAO#countByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataEntity)
     */
    @Override
    public long countByCondition(Se003_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se003_02GetResultDataEntity
     * @return List&lt;Se003_02GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataEntity)
     */
    @Override
    public List<Se003_02ResultDataEntity> findByCondition(Se003_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se003_02ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se003_02GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se003_02GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Se003_02ResultDataEntity> findByCondition(Se003_02ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se003_02ResultDataEntity.class, offset, length);
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
        sql.append(" SELECT ");
        sql.append(" A.Code_Organization, ");
        sql.append(" A.Code_Tenpo, ");
        sql.append(" A.Year, ");
        sql.append(" A.Kubun_Hoshiki, ");
        sql.append(" A.Kubun_Shikin, ");
        sql.append(" A.ID_Ringi, ");
        sql.append(" A.ID_RingiBranch, ");
        sql.append(" A.M_Kashitsuke, ");
        sql.append(" A.Kubun_KurishoTesuryo, ");
        sql.append(" A.Kubun_KinriSeidoSentaku, ");
        sql.append(" A.Riritsu, ");
        sql.append(" A.Kubun_Tokuri, ");
        sql.append(" A.Tokuri, ");
        sql.append(" A.Shihyoritsu, ");
        sql.append(" A.Date_SueokiKigen, ");
        sql.append(" A.Date_ShokanKigen, ");
        sql.append(" A.Date_GanrikinHaraiKomi, ");
        sql.append(" A.Code_ShokanHouhou, ");
        sql.append(" A.Kubun_GankinFukintogaku, ");
        sql.append(" A.M_Fukin, ");
        sql.append(" A.M_GankinFukinto, ");
        sql.append(" A.Date_KetteiKisan, ");
        sql.append(" A.Date_Jikko, ");
        sql.append(" A.M_KashitsukeZandaka, ");
        sql.append(" A.ID_Credit, ");
        sql.append(" A.Kubun_JohenKianchu, ");
        sql.append(" A.Date_TokuriYuko, ");
        sql.append(" B.Name_KoukoShiten, ");
        sql.append(" C.Name_ShikinShito ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se003_02GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se003_02ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　（１）ＦＲＯＭ句 　　　　公庫支店名テーブル　LEFT OUTER JOIN
         * 　　　　　　（扱店別稟議データ「所管本支店コード」＝公庫支店名テーブル「公庫支店コード」） 　　　　資金使途テーブル　LEFT OUTER JOIN
         * 　　　　　　（扱店別稟議データ「資金使途コード」＝資金使途テーブル「資金使途コード」） 　　　　金融機関名称取得（サブ）View　LEFT OUTER JOIN
         * 　　　　　　（扱店別稟議データ「扱店コード」＝金融機関店舗データ「機関コード」）
         * 
         * 　（２）ＷＨＥＲＥ句 　　　　所管本支店ｺｰﾄﾞ＝入力引数の入力公庫支店コード かつ 　　　　扱店コード＝入力引数の入力扱店コード　かつ 　　　　店舗コード＝入力引数の入力店舗コード　かつ
         * 　　　　年度＝入力引数の年度(西暦)　かつ 　　　　方式区分＝入力引数の方式区分　かつ 　　　　資金区分＝入力引数の資金区分　かつ 　　　　稟議番号＝入力引数の入力番号　かつ
         * 　　　　稟議番号枝番＝入力引数の入力枝番　かつ 　　　　実行年月日＝あり（NULL/空文字/０以外）　かつ 　　　　取引停止案件コード＝なし（NULL又は空文字）
         */
        // FROM
        sql.append(" FROM ");
        sql.append(" ARINGI A ");
        sql.append(" LEFT OUTER JOIN ");
        sql.append(" KOUKOSHITEN B ");
        sql.append(" ON A.CODE_SHOKANHONSHITEN = B.CODE_KOUKOSHITEN ");
        sql.append(" LEFT OUTER JOIN ");
        sql.append(" SHIKINSHITO C ");
        sql.append(" ON A.CODE_SHIKINSHITO = C.CODE_SHIKINSHITO ");
        sql.append(" LEFT OUTER JOIN ");
        sql.append(" TENPONAMEVIEW2 D ");
        sql.append(" ON A.CODE_ORGANIZATION = D.CODE_ORGANIZATION ");
        // WHERE
        sql.where(" A.CODE_SHOKANHONSHITEN = ? ", inEntity.getCode_ShokanHonShiten());
        sql.where(" A.CODE_ORGANIZATION = ? ", inEntity.getCode_Organization());
        sql.where(" A.CODE_TENPO = ? ", inEntity.getCode_Tenpo());
        sql.where(" A.YEAR = ? ", inEntity.getYear());
        sql.where(" A.KUBUN_HOSHIKI = ? ", inEntity.getKubun_Hoshiki());
        sql.where(" A.KUBUN_SHIKIN = ? ", inEntity.getKubun_Shikin());
        sql.where(" A.ID_RINGI = ? ", inEntity.getID_Ringi());
        sql.where(" A.ID_RINGIBRANCH = ? ", inEntity.getID_RingiBranch());
        sql.where(" NOT (A.DATE_JIKKO IS NULL OR LENGTH(TRIM(A.DATE_JIKKO)) = 0) AND A.DATE_JIKKO <> '0' ");
        sql.where(" (CODE_TORIHIKITEISHI IS NULL OR LENGTH(TRIM(CODE_TORIHIKITEISHI)) = 0)  ");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se003_02GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se003_02ResultDataEntity inEntity) {

    }
}