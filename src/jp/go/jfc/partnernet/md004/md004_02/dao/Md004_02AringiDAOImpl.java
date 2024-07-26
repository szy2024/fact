//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02AringiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd004_02AringiDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02AringiDAOImpl extends PNBaseDAO<Md004_02AringiEntity> implements Md004_02AringiDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md004_02AringiEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiDAO#countByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiEntity)
     */
    @Override
    public long countByCondition(Md004_02AringiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md004_02AringiEntity
     * @return List&lt;Md004_02AringiEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiEntity)
     */
    @Override
    public List<Md004_02AringiEntity> findByCondition(Md004_02AringiEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02AringiEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md004_02AringiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_02AringiEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02AringiEntity,
     *      int, int)
     */
    @Override
    public List<Md004_02AringiEntity> findByCondition(Md004_02AringiEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02AringiEntity.class, offset, length);
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
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_02AringiEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md004_02AringiEntity inEntity) {

        /*
         * １．WHERE句の設定 　　　①債権管理番号　＝　指定された債権管理番号 　　　②引数の更新日時が空白以外の場合、 　　　　　最新更新日時　＝　引数の更新日時 　　　　上記以外の場合
         * 　　　　　最新更新日時　IS　NULL
         */
        sql.whereEqual("ID_Credit", String.valueOf(inEntity.getID_Credit()));
        sql.where("Data_LastUpDate <> '' ");
        sql.where("Data_LastUpDate IS NULL ");

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_02AringiEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md004_02AringiEntity inEntity) {

    }
}