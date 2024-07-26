//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_01GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe007_01GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se007_01ResultDataDAOImpl extends PNBaseDAO<Se007_01ResultDataEntity> implements
        Se007_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se007_01GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataDAO#countByCondition(jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Se007_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se007_01GetResultDataEntity
     * @return List&lt;Se007_01GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataEntity)
     */
    @Override
    public List<Se007_01ResultDataEntity> findByCondition(Se007_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se007_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se007_01GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se007_01GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se003.Se007_01.dao.Se007_01ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Se007_01ResultDataEntity> findByCondition(Se007_01ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se007_01ResultDataEntity.class, offset, length);
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
        sql.append(" aRingi.Code_Noukyou ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se007_01GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se007_01ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　　所管本支店ｺｰﾄﾞ＝入力引数の公庫支店コード かつ 　　　　扱店コード＝入力引数の扱店コード　かつ 　　　　店舗コード＝入力引数の店舗コード　かつ
         * 　　　　年度＝入力引数の年度(西暦)　かつ 　　　　方式区分＝入力引数の方式区分　かつ 　　　　資金区分＝入力引数の資金区分　かつ 　　　　稟議番号＝入力引数の番号 　　　　
         */
        // FROM
        sql.append(" FROM ");
        sql.append(" aRingi ");
        // WHERE
        sql.where(" aRingi.Code_ShokanHonShiten = ? ", inEntity.getCode_ShokanHonShiten());
        sql.where(" aRingi.Code_Organization = ? ", inEntity.getCode_Organization());
        sql.where(" aRingi.Code_Tenpo = ? ", inEntity.getCode_Tenpo());
        sql.where(" aRingi.Year = ? ", inEntity.getYear());
        sql.where(" aRingi.Kubun_Hoshiki = ? ", inEntity.getKubun_Hoshiki());
        sql.where(" aRingi.Kubun_Shikin = ? ", inEntity.getKubun_Shikin());
        sql.where(" aRingi.ID_Ringi = ? ", inEntity.getID_Ringi());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se007_01GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se007_01ResultDataEntity inEntity) {
        sql.append(" ORDER BY ");
        sql.append(" aRingi.ID_Credit ASC ");
    }
}