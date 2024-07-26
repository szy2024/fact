//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01HaraidashiDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd004_01HaraidashiDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_01HaraidashiDataDAOImpl extends PNBaseDAO<Md004_01HaraidashiDataEntity> implements
        Md004_01HaraidashiDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md004_01HaraidashiDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataDAO#countByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataEntity)
     */
    @Override
    public long countByCondition(Md004_01HaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md004_01HaraidashiDataEntity
     * @return List&lt;Md004_01HaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataEntity)
     */
    @Override
    public List<Md004_01HaraidashiDataEntity> findByCondition(Md004_01HaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_01HaraidashiDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md004_01HaraidashiDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_01HaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataEntity,
     *      int, int)
     */
    @Override
    public List<Md004_01HaraidashiDataEntity> findByCondition(Md004_01HaraidashiDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_01HaraidashiDataEntity.class, offset, length);
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
        sql.append(" M_KashitsukeukeireZan AS ID_M_KashitsukeukeireZan ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_01HaraidashiDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md004_01HaraidashiDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　ID_Credit = 指定した債権管理番号
         */
        sql.append(" FROM ");
        sql.append(" SelectHaraidashiMaxView ");
        sql.append(" WHERE ");
        sql.append(" ID_Credit = ?", inEntity.getID_Credit());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_01HaraidashiDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md004_01HaraidashiDataEntity inEntity) {
    }
}