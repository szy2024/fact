//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02GetYakujoDataDAOImpl
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
 * このクラスはSe003_02GetYakujoDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02YakujoDataDAOImpl extends PNBaseDAO<Se003_02YakujoDataEntity> implements
        Se003_02YakujoDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se003_02GetYakujoDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataDAO#countByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataEntity)
     */
    @Override
    public long countByCondition(Se003_02YakujoDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se003_02GetYakujoDataEntity
     * @return List&lt;Se003_02GetYakujoDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataDAO#findByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataEntity)
     */
    @Override
    public List<Se003_02YakujoDataEntity> findByCondition(Se003_02YakujoDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se003_02YakujoDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se003_02GetYakujoDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se003_02GetYakujoDataEntity&gt;
     * @see jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataDAO#findByCondition(jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataEntity,
     *      int, int)
     */
    @Override
    public List<Se003_02YakujoDataEntity> findByCondition(Se003_02YakujoDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se003_02YakujoDataEntity.class, offset, length);
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
        sql.append(" Yakujo.Date_Haraikomi, ");
        sql.append(" Yakujo.M_YakujoGankin, ");
        sql.append(" Yakujo.M_YakujoRisoku, ");
        sql.append(" NVL( Yakujo.M_SeiKuriGankin , 0 ) + NVL( Yakujo.M_NinKuriGankin , 0 ) AS M_KurishoGankin_Kei, ");
        sql.append(" NVL( Yakujo.M_SeiKuriRisoku , 0 ) + NVL( Yakujo.M_NinKuriRisoku , 0 ) AS M_KurishoRisoku_Kei, ");
        sql.append(" Yakujo.M_RishiJosei, ");
        sql.append(" Yakujo.M_ZandakaBeforeYakujo, ");
        sql.append(" Yakujo.ID_Credit ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se003_02GetYakujoDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se003_02YakujoDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　債権管理番号＝入力引数の債権管理番号
         * 
         * ※１　繰償元金計に以下の演算結果を設定する。尚、演算に際し、各カラムの値ＮＵＬＬは０として演算する様、ＮＶＬ式を使用する。
         * 　　　　請求繰上償還元金(M_SeiKuriGankin)＋任意繰上償還元金(M_NinKuriGankin)
         * 
         * ※２　繰償利息計に以下の演算結果を設定する。尚、演算に際し、各カラムの値ＮＵＬＬは０として演算する様、ＮＶＬ式を使用する。
         * 　　　　請求繰上償還利息(M_SeiKuriRisoku)＋任意繰上償還利息(M_NinKuriRisoku)
         */
        // FROM
        sql.append(" FROM ");
        sql.append(" Yakujo ");
        // WHERE
        sql.where(" Yakujo.ID_Credit = ? ", inEntity.getID_Credit());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se003_02GetYakujoDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se003_02YakujoDataEntity inEntity) {
        sql.append(" ORDER BY ");
        sql.append(" Yakujo.Date_Haraikomi ASC ");
    }
}