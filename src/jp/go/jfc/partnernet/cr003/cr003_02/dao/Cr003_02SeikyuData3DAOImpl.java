//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02SeikyuData3DAOImpl
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
 * このクラスはCr003_02SeikyuData3DAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_02SeikyuData3DAOImpl extends PNBaseDAO<Cr003_02SeikyuData3Entity> implements
        Cr003_02SeikyuData3DAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr003_02SeikyuData3Entity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3DAO#countByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3Entity)
     */
    @Override
    public long countByCondition(Cr003_02SeikyuData3Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr003_02SeikyuData3Entity
     * @return List&lt;Cr003_02SeikyuData3Entity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3DAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3Entity)
     */
    @Override
    public List<Cr003_02SeikyuData3Entity> findByCondition(Cr003_02SeikyuData3Entity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02SeikyuData3Entity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr003_02SeikyuData3Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr003_02SeikyuData3Entity&gt;
     * @see jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3DAO#findByCondition(jp.go.jfc.partnernet.cr003.cr003_02.dao.Cr003_02SeikyuData3Entity,
     *      int, int)
     */
    @Override
    public List<Cr003_02SeikyuData3Entity> findByCondition(Cr003_02SeikyuData3Entity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr003_02SeikyuData3Entity.class, offset, length);
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
        sql.append(" Seikyu.ID_Credit,");
        sql.append(" Seikyu.Date_Haraikomi,");
        sql.append(" Seikyu.M_YakujoGankin ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02SeikyuData3Entity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr003_02SeikyuData3Entity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　（１）Ｆｒｏｍ句（抽出した請求データが複数件存在する場合、払込年月日が最大のレコードを取得する） 　　　　 FROM (SELECT ID_Credit,
         * MAX(Date_Haraikomi) AS Max_Date_Haraikomi 　　　　 FROM Seikyu　　　　「（２）ＷＨＥＲＥ句」 　　　GROUP BY ID_Credit)
         * Tmp INNER JOIN 　　　　 Seikyu ON Tmp.ID_Credit = Seikyu.ID_Credit 　　　　 AND Tmp.Max_Date_Haraikomi =
         * Seikyu.Date_Haraikomi
         * 
         * 　　（２）ＷＨＥＲＥ句 　　　　債権管理番号＝入力引数の債権管理番号　かつ 　　　　払込年月日<入力引数の払込期日
         */
        sql.append("FROM (SELECT ID_Credit, MAX(Date_Haraikomi) AS Max_Date_Haraikomi ");
        sql.append("FROM Seikyu WHERE Seikyu.ID_Credit = ? AND ", inEntity.getID_Credit());
        sql.append("Seikyu.Date_Haraikomi < ?  ", inEntity.getDate_Haraikomi());
        sql.append("GROUP BY ID_Credit) Tmp INNER JOIN ");
        sql.append("Seikyu ON Tmp.ID_Credit = Seikyu.ID_Credit ");
        sql.append("AND Tmp.Max_Date_Haraikomi = Seikyu.Date_Haraikomi ");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr003_02SeikyuData3Entity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr003_02SeikyuData3Entity inEntity) {
    }
}