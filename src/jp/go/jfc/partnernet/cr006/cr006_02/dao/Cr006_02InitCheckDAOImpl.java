//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02InitCheckDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr006_02InitCheckDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr006_02InitCheckDAOImpl extends PNBaseDAO<Cr006_02InitCheckEntity> implements
        Cr006_02InitCheckDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr006_02InitCheckEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckDAO#countByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckEntity)
     */
    @Override
    public long countByCondition(Cr006_02InitCheckEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr006_02InitCheckEntity
     * @return List&lt;Cr006_02InitCheckEntity&gt;
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckDAO#findByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckEntity)
     */
    @Override
    public List<Cr006_02InitCheckEntity> findByCondition(Cr006_02InitCheckEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_02InitCheckEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr006_02InitCheckEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_02InitCheckEntity&gt;
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckDAO#findByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02InitCheckEntity,
     *      int, int)
     */
    @Override
    public List<Cr006_02InitCheckEntity> findByCondition(Cr006_02InitCheckEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_02InitCheckEntity.class, offset, length);
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
        sql.append("SELECT ");
        sql.append("ReportHistory.ID_Credit ");
        sql.append(",ReportHistory.Date_Report ");
        sql.append(",ReportHistory.Time_Report ");
        sql.append(",ReportHistory.Status ");
        sql.append(",ReportHistory.DataCode ");
        sql.append(",ReportName.RyakusyouName_Report ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_02InitCheckEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr006_02InitCheckEntity inEntity) {

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM ");
        sql.append(" ReportHistory ");
        sql.append(" LEFT OUTER JOIN  ReportName ON ");
        sql.append(" ReportHistory.DataCode =  ReportName.DataCode ");
        sql.whereEqual("ID_Credit", inEntity.getID_Credit());
        sql.whereEqual("Code_KoukoShiten", inEntity.getCr006_02_Code_KoukoShiten());
        sql.whereEqual("Code_Organization", inEntity.getCr006_02_Code_Organization());
        sql.whereEqual("Code_Tenpo", inEntity.getCr006_02_Code_Tenpo());
        sql.whereEqual("Year", inEntity.getCr006_02_Year());
        sql.whereEqual("Code_HoshikiShikin", inEntity.getCr006_02_Code_HoshikiShikin());
        sql.whereEqual("ID_Ringi", inEntity.getCr006_02_ID_Ringi());
        sql.whereEqual("ID_RingiBranch", inEntity.getCr006_02_ID_RingiBranch());
        sql.whereEqual("Flag_Torikeshizumi", "0");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_02InitCheckEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr006_02InitCheckEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        sql.append(" ORDER BY ");
        sql.append(" ReportHistory.Date_Report DESC ");
        sql.append(" ,ReportHistory.Time_Report DESC ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}