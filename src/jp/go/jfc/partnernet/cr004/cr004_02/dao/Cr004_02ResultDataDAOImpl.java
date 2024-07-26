//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02ResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.dao;

import java.util.List;

import com.fujitsu.crust.dao.CFWDAOConstants;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr004_02ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_02ResultDataDAOImpl extends PNBaseDAO<Cr004_02ResultDataEntity> implements
        Cr004_02ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Cr004_02ResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataDAO#countByCondition(jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataEntity)
     */
    @Override
    public long countByCondition(Cr004_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Cr004_02ResultDataEntity
     * @return List&lt;Cr004_02ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataEntity)
     */
    @Override
    public List<Cr004_02ResultDataEntity> findByCondition(Cr004_02ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr004_02ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Cr004_02ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr004_02ResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr004_02ResultDataEntity> findByCondition(Cr004_02ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr004_02ResultDataEntity.class, offset, length);
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
        sql.append("SELECT DISTINCT");
        sql.append(" A.Name_Customer,");
        sql.append(" A.Code_Customer,");
        sql.append(" A.Addr_Hojo,");
        sql.append(" A.Code_Organization,");
        sql.append(" TRIM(A.ID_Postcode) AS ID_Postcode,");
        sql.append(" A.Name_Todofuken,");
        sql.append(" A.Name_Shikugunchoson,");
        sql.append(" A.Name_OazaTsusho,");
        sql.append(" A.Name_AzameiChome ");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr004_02ResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr004_02ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　　　貸付先名称(Name_Cunstomer)≒入力引数の顧客名入力値（部分一致するものを抽出） かつ
         * 　　　　扱店コード(Code_Organization)＝入力引数のログインユーザの扱店コード
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============

        sql.append("FROM");
        sql.append(" DaibensaiReportView A ");
        sql.whereEqual("A.Code_Organization", inEntity.getCr004_02_Code_Organization());
        sql.whereLike("A.Name_Customer", inEntity.getCr004_02_In_Name_Customer(),
                CFWDAOConstants.LikePattern.Partial);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr004_02ResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr004_02ResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append(" A.Code_Customer,");
        sql.append(" A.Name_Customer ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}