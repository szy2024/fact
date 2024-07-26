//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_13DetailDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_13.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_13DetailDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_13DetailDataDAOImpl extends PNBaseDAO<Se006_13DetailDataEntity> implements
        Se006_13DetailDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se006_13DetailDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataDAO#countByCondition(jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataEntity)
     */
    @Override
    public long countByCondition(Se006_13DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se006_13DetailDataEntity
     * @return List&lt;Se006_13DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataEntity)
     */
    @Override
    public List<Se006_13DetailDataEntity> findByCondition(Se006_13DetailDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_13DetailDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se006_13DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_13DetailDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataDAO#findByCondition(jp.go.jfc.partnernet.se006.se006_13.dao.Se006_13DetailDataEntity,
     *      int, int)
     */
    @Override
    public List<Se006_13DetailDataEntity> findByCondition(Se006_13DetailDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_13DetailDataEntity.class, offset, length);
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
        sql.append(" ID_Report, ");
        sql.append(" Date_Report, ");
        sql.append(" Time_Report, ");
        sql.append(" DataCode, ");
        sql.append(" Name_Organization, ");
        sql.append(" Code_KoukoShiten, ");
        sql.append(" Code_Organization, ");
        sql.append(" Code_Tenpo, ");
        sql.append(" Date_Nyukin, ");
        sql.append(" M_RyuchikikanRisoku, ");
        sql.append(" M_DaibenChienSongai, ");
        sql.append(" M_Sokin, ");
        sql.append(" Date_Jtkshori, ");
        sql.append(" Date_Sokin, ");
        sql.append(" ID_Sokinbi ");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_13DetailDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_13DetailDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　報告書番号　＝　報告書履歴検索結果画面の指定した報告書番号
         */

        sql.append(" FROM KariukeSonotaReport ");
        sql.where(" ID_Report = ? ", inEntity.getID_Report());

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_13DetailDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_13DetailDataEntity inEntity) {

    }
}