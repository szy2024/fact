//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01ReportDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr006_01ReportDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_01ReportDataDAOImpl extends PNBaseDAO<Cr006_01ReportDataEntity> implements
        Cr006_01ReportDataDAO {

    /**
     * 検索結果件数を取得します。
     * 
     * @param inEntity Cr006_01ReportDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataDAO
     *      #countByCondition(jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataEntity)
     */
    @Override
    public long countByCondition(Cr006_01ReportDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * 
     * @param inEntity Cr006_01ReportDataEntity
     * @return List&lt;Cr006_01ReportDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataDAO
     *      #findByCondition(jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataEntity)
     */
    @Override
    public List<Cr006_01ReportDataEntity> findByCondition(Cr006_01ReportDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_01ReportDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * 
     * @param inEntity Cr006_01ReportDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_01ReportDataEntity&gt;d
     * @see jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataDAO
     *      #findByCondition(jp.go.jfc.partnernet.cr006.Cr006_01.dao.Cr006_01ReportDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr006_01ReportDataEntity> findByCondition(Cr006_01ReportDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_01ReportDataEntity.class, offset, length);
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
        sql.append(" Name_Customer");
        sql.append(" ,Date_Karibarai");
        sql.append(" ,Code_KanjoKamoku");
        sql.append(" ,M_ToshoKaribarai");
        sql.append(" ,M_KaribaraiZanAfterSeisan");
        sql.append(" ,Code_ShokanHonShiten");
        sql.append(" ,Code_Organization");
        sql.append(" ,Code_Tenpo");
        sql.append(" ,Year");
        sql.append(" ,Kubun_Hoshiki");
        sql.append(" ,Kubun_Shikin");
        sql.append(" ,ID_Ringi");
        sql.append(" ,ID_RingiBranch");
        sql.append(" ,Code_Customer AS ID_Code_Customer");
        sql.append(" ,ID_Credit");
        sql.append(" ,Code_HonShiten");
        sql.append(" ,ID_Karibarai");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_01ReportDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr006_01ReportDataEntity inEntity) {

        /*
         * １．WHERE句の設定 扱店コード＝入力引数の扱店コード
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" TatekaeReportView ");
        sql.whereEqual("Code_Organization", inEntity.getCode_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_01ReportDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr006_01ReportDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY");
        sql.append(" ID_Karibarai ASC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}