//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se002_01UkeireZanDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se002.se002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe002_01UkeireZanDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se002_01UkeireZanDAOImpl extends PNBaseDAO<Se002_01UkeireZanEntity> implements
        Se002_01UkeireZanDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se002_01UkeireZanEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanDAO#countByCondition(jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanEntity)
     */
    @Override
    public long countByCondition(Se002_01UkeireZanEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se002_01UkeireZanEntity
     * @return List&lt;Se002_01UkeireZanEntity&gt;
     * @see jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanDAO#findByCondition(jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanEntity)
     */
    @Override
    public List<Se002_01UkeireZanEntity> findByCondition(Se002_01UkeireZanEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se002_01UkeireZanEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se002_01UkeireZanEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se002_01UkeireZanEntity&gt;
     * @see jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanDAO#findByCondition(jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanEntity,
     *      int, int)
     */
    @Override
    public List<Se002_01UkeireZanEntity> findByCondition(Se002_01UkeireZanEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se002_01UkeireZanEntity.class, offset, length);
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
        sql.append(" Haraidashi.ID_Credit");
        sql.append(" , Haraidashi.Date_HaraidashiJuto");
        sql.append(" , Haraidashi.M_KashitsukeukeireZan");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se002_01UkeireZanEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se002_01UkeireZanEntity inEntity) {

        /*
         * １．WHERE句の設定 　　更正処理区分　＝　0 　　払出充当年月日　＜＝　システムの本日日付
         */

        sql.append(" FROM");
        sql.append(" Haraidashi");
        sql.append(" WHERE");
        sql.append(" Haraidashi.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND Haraidashi.Kubun_KoseiShori = '0'");
        sql.append(" AND Haraidashi.Date_HaraidashiJuto <= ?", inEntity.getDate_HaraidashiJuto());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se002_01UkeireZanEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se002_01UkeireZanEntity inEntity) {
        sql.append(" ORDER BY Cast(ID_KeisuKanriShori As NUMBER) DESC");
    }
}