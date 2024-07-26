//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_02DetailDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe007_02DetailDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se007_02DetailDataDAOImpl extends PNBaseDAO<Se007_02DetailDataEntity> implements
        Se007_02DetailDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se007_02DetailDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataDAO#countByCondition(jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataEntity)
     */
    @Override
    public long countByCondition(Se007_02DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se007_02DetailDataEntity
     * @return List&lt;Se007_02DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataEntity)
     */
    @Override
    public List<Se007_02DetailDataEntity> findByCondition(Se007_02DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se007_02DetailDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se007_02DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se007_02DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se007.se007_02.dao.Se007_02DetailDataEntity,
     *      int, int)
     */
    @Override
    public List<Se007_02DetailDataEntity> findByCondition(Se007_02DetailDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se007_02DetailDataEntity.class, offset, length);
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
        sql.append(" SELECT");
        sql.append(" ShokanNenjiView.Name_Customer");
        sql.append(" ,ShokanNenjiView.ID_Postcode");
        sql.append(" ,ShokanNenjiView.Name_Todofuken");
        sql.append(" ,ShokanNenjiView.Name_Shikugunchoson");
        sql.append(" ,ShokanNenjiView.Name_OazaTsusho");
        sql.append(" ,ShokanNenjiView.Name_AzameiChome");
        sql.append(" ,ShokanNenjiView.Addr_Hojo");
        sql.append(" ,ShokanNenjiView.Name_Organization");
        sql.append(" ,ShokanNenjiView.Name_KoukoShiten");
        sql.append(" ,ShokanNenjiView.Code_Organization");
        sql.append(" ,ShokanNenjiView.Code_Tenpo");
        sql.append(" ,ShokanNenjiView.Year");
        sql.append(" ,ShokanNenjiView.HoshikiShikin");
        sql.append(" ,ShokanNenjiView.ID_Ringi");
        sql.append(" ,ShokanNenjiView.ID_RingiBranch");
        sql.append(" ,ShokanNenjiView.Date_Jikko");
        sql.append(" ,ShokanNenjiView.M_Kashitsuke");
        sql.append(" ,ShokanNenjiView.Name_RyakuShikinShito");
        sql.append(" ,ShokanNenjiView.Riritsu");
        sql.append(" ,ShokanNenjiView.Kubun_Tokuri");
        sql.append(" ,ShokanNenjiView.Tokuri");
        sql.append(" ,ShokanNenjiView.Shihyoritsu");
        sql.append(" ,ShokanNenjiView.Date_SueokiKigen");
        sql.append(" ,ShokanNenjiView.Date_ShokanKigen");
        sql.append(" ,ShokanNenjiView.Date_GanrikinHaraiKomi");
        sql.append(" ,ShokanNenjiView.Code_ShokanHouhou");
        sql.append(" ,ShokanNenjiView.M_Fukin");
        sql.append(" ,ShokanNenjiView.RishiJoseiMaeTokuri");
        sql.append(" ,ShokanNenjiView.RishiJoseiMaeRiritsu");
        sql.append(" ,ShokanNenjiView.Code_TorihikiTeishi");
        sql.append(" ,ShokanNenjiView.ID_Credit");
        sql.append(" ,ShokanNenjiView.Date_Haraikomi");
        sql.append(" ,ShokanNenjiView.Code_ShokanHonShiten");
        sql.append(" ,ShokanNenjiView.M_KashitsukeZandaka");
        sql.append(" ,ShokanNenjiView.Kubun_JohenKianchu");
        sql.append(" ,ShokanNenjiView.Date_TokuriYuko");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se007_02DetailDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se007_02DetailDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　　所管本支店コード　＝　融資番号入力画面で指定した公庫支店コード 　　　扱店　＝　融資番号入力画面で指定した扱店コード
         * 　　　店舗　＝　融資番号入力画面で指定した店舗コード 　　　年度　＝　融資番号入力画面で指定した年度(西暦変換されたもの) 　　　番号　＝　融資番号入力画面で指定した番号
         * 　　　枝番　＝　融資番号入力画面で指定した枝番 　　　取引停止案件コードがNULLまた空白 　　　貸付実行日が空白以外 　１－１．ログインユーザによって以下の条件を追加する。　
         * 　　最初の１件のみ取得する。
         */

        sql.append(" FROM");
        sql.append(" ShokanNenjiView");
        sql.append(" WHERE");
        // 融資番号入力画面で指定した公庫支店コード
        sql.append(" ShokanNenjiView.Code_ShokanHonShiten = ?", inEntity.getCode_ShokanHonShiten());
        // 融資番号入力画面で指定した扱店コード
        sql.append(" AND ShokanNenjiView.Code_Organization = ?", inEntity.getCode_Organization());
        // 融資番号入力画面で指定した店舗コード
        sql.append(" AND ShokanNenjiView.Code_Tenpo = ?", inEntity.getCode_Tenpo());
        // 融資番号入力画面で指定した年度(西暦変換されたもの)
        sql.append(" AND ShokanNenjiView.Year = ?", inEntity.getYear());
        // 方式資金　＝　入力引数の方式区分＋入力引数の資金区分
        StringBuilder sbHosikiKubun = new StringBuilder(inEntity.getKubun_Hoshiki());
        sbHosikiKubun.append(inEntity.getKubun_Shikin());
        sql.append(" AND ShokanNenjiView.HoshikiShikin = ?", sbHosikiKubun.toString());
        // 融資番号入力画面で指定した番号
        sql.append(" AND ShokanNenjiView.ID_Ringi = ?", inEntity.getID_Ringi());
        // 融資番号入力画面で指定した枝番
        sql.append(" AND ShokanNenjiView.ID_RingiBranch = ?", inEntity.getID_RingiBranch());
        // 取引停止案件コードがNULLまた空白
        sql.append(" AND ((ShokanNenjiView.Code_TorihikiTeishi IS NULL) OR (LENGTH(ShokanNenjiView.Code_TorihikiTeishi) = 0)) ");
        // 貸付実行日が空白以外
        // sql.append(" AND ShokanNenjiView.Date_Jikko <> ''");
        sql.append(" AND ShokanNenjiView.Date_Jikko IS NOT NULL");
        sql.append(" AND rownum <= 1");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se007_02DetailDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se007_02DetailDataEntity inEntity) {
        if (!sql.orderBy(inEntity.getSortInfo())) {
            sql.append(" ORDER BY");
            sql.append(" ShokanNenjiView.Date_Haraikomi ASC");
        }
    }
}