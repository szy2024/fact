//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01LastHaraidashiDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/25 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr002_01FirstHaraidashiDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr002_01FirstHaraidashiDataDAOImpl extends PNBaseDAO<Cr002_01FirstHaraidashiDataEntity>
        implements Cr002_01FirstHaraidashiDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr002_01FirstHaraidashiDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataDAO#countByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataEntity)
     */
    @Override
    public long countByCondition(Cr002_01FirstHaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr002_01FirstHaraidashiDataEntity
     * @return List&lt;Cr002_01FirstHaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataEntity)
     */
    @Override
    public List<Cr002_01FirstHaraidashiDataEntity> findByCondition(Cr002_01FirstHaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr002_01FirstHaraidashiDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr002_01FirstHaraidashiDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr002_01FirstHaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.cr002.cr002_01.dao.Cr002_01FirstHaraidashiDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr002_01FirstHaraidashiDataEntity> findByCondition(
            Cr002_01FirstHaraidashiDataEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr002_01FirstHaraidashiDataEntity.class, offset, length);
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
        sql.append("  h.M_KashitsukeukeireZan");
        sql.append(" ,h.M_Haraidashi");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr002_01FirstHaraidashiDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr002_01FirstHaraidashiDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　債権管理番号　＝　入力引数の債権管理番号 　　かつ、更正処理区分　＝　'0'
         * 
         * ２．その他 　　先頭１レコードのみ取得する
         */

        sql.append(" FROM");
        sql.append(" Haraidashi h");
        sql.append(" WHERE");
        sql.append(" h.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND h.Date_HaraidashiJuto = ?", inEntity.getDate_HaraidashiJuto());
        sql.append(" AND h.Kubun_KoseiShori = '0' ");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr002_01FirstHaraidashiDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr002_01FirstHaraidashiDataEntity inEntity) {
        sql.append(" ORDER BY");
        sql.append(" Cast(h.ID_KeisuKanriShori as NUMBER) ASC");
    }
}