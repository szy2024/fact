//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01YakujoDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe009_01YakujoDAOの実装クラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01YakujoDAOImpl extends PNBaseDAO<Se009_01YakujoEntity> implements Se009_01YakujoDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se009_01YakujoEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoDAO#countByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoEntity)
     */
    @Override
    public long countByCondition(Se009_01YakujoEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se009_01YakujoEntity
     * @return List&lt;Se009_01YakujoEntity&gt;
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoDAO#findByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoEntity)
     */
    @Override
    public List<Se009_01YakujoEntity> findByCondition(Se009_01YakujoEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se009_01YakujoEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se009_01YakujoEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se009_01YakujoEntity&gt;
     * @see jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoDAO#findByCondition(jp.go.jfc.partnernet.se009.se009_01.dao.Se009_01YakujoEntity,
     *      int, int)
     */
    @Override
    public List<Se009_01YakujoEntity> findByCondition(Se009_01YakujoEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se009_01YakujoEntity.class, offset, length);
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
        sql.append(" Date_Haraikomi, ");
        sql.append(" M_ZandakaBeforeYakujo ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se009_01YakujoEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se009_01YakujoEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　債権管理番号 = 入力された債権管理番号 　約定期日区分 = '1' 　払込年月日 > 入力された払込年月日
         * 
         * 2．ROWNUM句の設定 ROWNUM 1
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM ");
        sql.append(" Yakujo ");
        sql.append("WHERE ");
        sql.append(" ID_Credit = ? ", inEntity.getID_Credit());
        sql.append("AND ");
        sql.append(" Date_Haraikomi >= ? ", inEntity.getDate_Haraikomi());
        sql.append("AND ");
        sql.append(" Kubun_YakujoKijitsu  = '1' ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se009_01YakujoEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se009_01YakujoEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}