//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr010_01TenpoNameResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr010_01TenpoNameResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr010_01TenpoNameResultDataDAOImpl extends PNBaseDAO<Cr010_01TenpoNameResultDataEntity>
        implements Cr010_01TenpoNameResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataEntity)
     */
    @Override
    public long countByCondition(Cr010_01TenpoNameResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @return List&lt;Cr010_01TenpoNameResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataEntity)
     */
    @Override
    public List<Cr010_01TenpoNameResultDataEntity> findByCondition(Cr010_01TenpoNameResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr010_01TenpoNameResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr011_01TenpoNameResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr010.cr010_01.dao.Cr010_01TenpoNameResultDataEntity, int, int)
     */
    @Override
    public List<Cr010_01TenpoNameResultDataEntity> findByCondition(Cr010_01TenpoNameResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr010_01TenpoNameResultDataEntity.class,
                offset, length);
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
        sql.append(" SELECT ");
        sql.append(" Name_Organization ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr010_01TenpoNameResultDataEntity inEntity) {

        /*
         * １．WHERE句の設定
         *　　金融機関名称取得（メイン）View.扱店コード ＝ 入力引数.扱店コード
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM ");
        sql.append(" TenpoNameView ");
        sql.append(" WHERE ");
        sql.append(" Code_Organization = ? ", inEntity.getCode_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr010_01TenpoNameResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}