//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01YakujoData5DAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr002_01YakujoData5DAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr002_01YakujoData5DAOImpl extends PNBaseDAO<Cr002_01YakujoData5Entity> implements
        Cr002_01YakujoData5DAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr002_01YakujoData5Entity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5DAO#countByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5Entity)
     */
    @Override
    public long countByCondition(Cr002_01YakujoData5Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr002_01YakujoData5Entity
     * @return List&lt;Cr002_01YakujoData5Entity&gt;
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5DAO#findByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5Entity)
     */
    @Override
    public List<Cr002_01YakujoData5Entity> findByCondition(Cr002_01YakujoData5Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr002_01YakujoData5Entity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr002_01YakujoData5Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr002_01YakujoData5Entity&gt;
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5DAO#findByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01YakujoData5Entity,
     *      int, int)
     */
    @Override
    public List<Cr002_01YakujoData5Entity> findByCondition(Cr002_01YakujoData5Entity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr002_01YakujoData5Entity.class, offset, length);
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
        sql.append(" Yakujo.Date_Haraikomi");
        sql.append(" ,Yakujo.M_YakujoGankin");
        sql.append(" ,Yakujo.M_YakujoRisoku");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr002_01YakujoData5Entity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr002_01YakujoData5Entity inEntity) {

        /*
         * １．WHERE句の設定 　　債権管理番号　＝　入力引数の債権管理番号 　　かつ、払込年月日 >= 入力引数の払込年月
         * 
         * ２．その他 　　先頭１件のみ取得する
         */
        sql.append(" FROM");
        sql.append(" Yakujo");
        sql.append(" WHERE");
        sql.append(" Yakujo.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND Yakujo.Date_Haraikomi >= ?", inEntity.getDate_Haraikomi());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr002_01YakujoData5Entity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr002_01YakujoData5Entity inEntity) {
        if (!sql.orderBy(inEntity.getSortInfo())) {
            sql.append(" ORDER BY");
            sql.append(" Yakujo.Date_Haraikomi ASC");
        }
    }
}