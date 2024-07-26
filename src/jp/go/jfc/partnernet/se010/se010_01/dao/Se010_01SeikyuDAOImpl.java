//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01SeikyuDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe010_01SeikyuDAOの実装クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01SeikyuDAOImpl extends PNBaseDAO<Se010_01SeikyuEntity> implements Se010_01SeikyuDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se010_01SeikyuEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuDAO#countByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuEntity)
     */
    @Override
    public long countByCondition(Se010_01SeikyuEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se010_01SeikyuEntity
     * @return List&lt;Se010_01SeikyuEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuEntity)
     */
    @Override
    public List<Se010_01SeikyuEntity> findByCondition(Se010_01SeikyuEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01SeikyuEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se010_01SeikyuEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se010_01SeikyuEntity&gt;
     * @see jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuEntity,
     *      int, int)
     */
    @Override
    public List<Se010_01SeikyuEntity> findByCondition(Se010_01SeikyuEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se010_01SeikyuEntity.class, offset, length);
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
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("SELECT");
        sql.append(" M_SeiKuriGankin ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se010_01SeikyuEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se010_01SeikyuEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　債権管理番号 = 稟議データから取得した債権管理番号
         * 
         * ２． WHERE句の追加設定 ・繰償後第一回払込期日Toが設定されている場合 　　　払込年月日 < 入力された繰償後第一回払込期日 ・繰償後第一回払込期日が設定されている場合 　　　払込年月日 =
         * 入力された繰償後第一回払込期日 　請求繰上償還元金 > '0' OR 請求繰上償還利息 > '0'
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM ");
        sql.append(" Seikyu ");
        sql.append("WHERE ");
        sql.append(" ID_Credit = ? ", inEntity.getID_Credit());
        if (!StringUtils.isEmpty(inEntity.getStrDate_KurishoTaishoTo())) {
            sql.append("AND ");
            sql.append(" Date_Haraikomi < ? ", inEntity.getStrDate_KurishoTaishoTo());
        } else if (!StringUtils.isEmpty(inEntity.getStrDate_KurishoTaisho())) {
            sql.append("AND ");
            sql.append(" Date_Haraikomi = ? ", inEntity.getStrDate_KurishoTaisho());
        }
        sql.append("AND ");
        sql.append(" M_SeiKuriGankin > 0 ");
        sql.append("AND ");
        sql.append(" M_SeiKuriRisoku > 0 ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se010_01SeikyuEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se010_01SeikyuEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}