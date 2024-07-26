//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd008_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class Md008_02ResultsDataDAOImpl extends PNBaseDAO<Md008_02ResultsDataEntity> implements
        Md008_02ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md008_02ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataDAO#countByCondition(jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataEntity)
     */
    @Override
    public long countByCondition(Md008_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md008_02ResultsDataEntity
     * @return List&lt;Md008_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataEntity)
     */
    @Override
    public List<Md008_02ResultsDataEntity> findByCondition(Md008_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md008_02ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md008_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md008_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Md008_02ResultsDataEntity> findByCondition(Md008_02ResultsDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md008_02ResultsDataEntity.class, offset, length);
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
        sql.append(" SELECT");
        sql.append(" KARIUKEIPPANREPORTMODVIEW.NAME_CUSTOMER");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.NAME_ORGANIZATION");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.CODE_ORGANIZATION");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.CODE_KOUKOSHITEN");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.CODE_TENPO");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.YEAR");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.CODE_HOSHIKISHIKIN");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.ID_RINGI");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.ID_RINGIBRANCH");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.M_KARIUKEIPPANUKEIRE");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.ID_SOKINBI");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.DATE_JTKSHORI");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.DATE_SOKIN");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.DATE_NYUKIN");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.KEEP_ID_HISTORY");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.ID_HISTORY");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.TYPE_PROCESS");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.FLAG_TORIKESHIZUMI");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.ID_DENSO");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.STATUS");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.DATACODE");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.USERID");
        sql.append(" ,KARIUKEIPPANREPORTMODVIEW.DATA_LASTUPDATE");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md008_02ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md008_02ResultsDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　扱店　＝　ログインユーザの扱店コード 　　報告書番号　＝　指定された報告書番号
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" KARIUKEIPPANREPORTMODVIEW");
        sql.append(" WHERE KARIUKEIPPANREPORTMODVIEW.CODE_ORGANIZATION = ?", inEntity.getCode_Organization());
        sql.append(" AND KARIUKEIPPANREPORTMODVIEW.ID_REPORT = ?", inEntity.getID_Report());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md008_02ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md008_02ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}