//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_01YakujoData3DAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd002_01YakujoData3DAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_01YakujoData3DAOImpl extends PNBaseDAO<Md002_01YakujoData3Entity> implements
        Md002_01YakujoData3DAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md002_01YakujoData3Entity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3DAO#countByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3Entity)
     */
    @Override
    public long countByCondition(Md002_01YakujoData3Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md002_01YakujoData3Entity
     * @return List&lt;Md002_01YakujoData3Entity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3DAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3Entity)
     */
    @Override
    public List<Md002_01YakujoData3Entity> findByCondition(Md002_01YakujoData3Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01YakujoData3Entity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md002_01YakujoData3Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md002_01YakujoData3Entity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3DAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01YakujoData3Entity,
     *      int, int)
     */
    @Override
    public List<Md002_01YakujoData3Entity> findByCondition(Md002_01YakujoData3Entity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01YakujoData3Entity.class, offset, length);
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
        sql.append("  MAX(Date_Haraikomi) As Date_Haraikomi");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01YakujoData3Entity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md002_01YakujoData3Entity inEntity) {

        /*
         * １．WHERE句の設定 　　債権管理番号　＝　入力引数の債権管理番号 　　かつ、払込年月日 ＜ 入力引数の払出元金充当日 　　かつ、約定期日区分 = '1'
         * 
         * ２．その他 　　払込年月日の最大レコードを取得する
         */

        sql.append(" FROM");
        sql.append(" Yakujo");
        sql.append(" WHERE");
        sql.append(" Yakujo.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND Yakujo.Date_Haraikomi < ?", inEntity.getDate_Haraikomi());
        sql.append(" AND Yakujo.Kubun_YakujoKijitsu = '1'");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01YakujoData3Entity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md002_01YakujoData3Entity inEntity) {
        if (!sql.orderBy(inEntity.getSortInfo())) {
            sql.append(" ORDER BY");
            sql.append(" Yakujo.Date_Haraikomi DESC");
        }
    }
}