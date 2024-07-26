//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02SeikyuData1DAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr003_02SeikyuData1DAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_02SeikyuData1DAOImpl extends PNBaseDAO<Cr003_02SeikyuData1Entity> implements
        Cr003_02SeikyuData1DAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr003_02SeikyuData1Entity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1DAO#countByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1Entity)
     */
    @Override
    public long countByCondition(Cr003_02SeikyuData1Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr003_02SeikyuData1Entity
     * @return List&lt;Cr003_02SeikyuData1Entity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1DAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1Entity)
     */
    @Override
    public List<Cr003_02SeikyuData1Entity> findByCondition(Cr003_02SeikyuData1Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02SeikyuData1Entity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr003_02SeikyuData1Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr003_02SeikyuData1Entity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1DAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData1Entity,
     *      int, int)
     */
    @Override
    public List<Cr003_02SeikyuData1Entity> findByCondition(Cr003_02SeikyuData1Entity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02SeikyuData1Entity.class, offset, length);
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

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02SeikyuData1Entity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr003_02SeikyuData1Entity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　　債権管理番号＝入力引数の債権管理番号 　　　　払込年月日＝入力引数の払込期日
         */

        sql.append(" FROM Seikyu ");
        sql.whereEqual("ID_Credit", inEntity.getID_Credit());
        sql.whereEqual("Date_Haraikomi", inEntity.getDate_Haraikomi());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02SeikyuData1Entity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr003_02SeikyuData1Entity inEntity) {

    }
}