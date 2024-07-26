//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02YakujoCountDAOImpl
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
 * このクラスはMd004_02YakujoCountDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02YakujoCountDAOImpl extends PNBaseDAO<Md004_02YakujoCountEntity> implements
        Md004_02YakujoCountDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md004_02YakujoCountEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountDAO#countByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountEntity)
     */
    @Override
    public long countByCondition(Md004_02YakujoCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md004_02YakujoCountEntity
     * @return List&lt;Md004_02YakujoCountEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountEntity)
     */
    @Override
    public List<Md004_02YakujoCountEntity> findByCondition(Md004_02YakujoCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02YakujoCountEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md004_02YakujoCountEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_02YakujoCountEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02YakujoCountEntity,
     *      int, int)
     */
    @Override
    public List<Md004_02YakujoCountEntity> findByCondition(Md004_02YakujoCountEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02YakujoCountEntity.class, offset, length);
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
     * @param inEntity Md004_02YakujoCountEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md004_02YakujoCountEntity inEntity) {

        /*
         * １．WHERE句の設定 　　　債権管理番号 ＝ 指定された債権管理番号 　　　払込年月日 ＜ 払込年月日 　　　約定期日区分 ＝ ’１’
         * 
         * ２．その他 　　件数を取得する。
         */

        /*
         * １．WHERE句の設定 　　債権管理番号 = 指定した債権管理番号 　　払込年月日 ＜ 指定した入金月日 　　約定期日区分＝’１’ 　
         */
        sql.append("FROM Yakujo ");
        sql.whereEqual("ID_Credit", inEntity.getID_Credit().toString());
        sql.append(" AND Date_Haraikomi < ? ", inEntity.getDate_Haraikomi());
        sql.whereEqual("Kubun_Yakujokijitsu", "1");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_02YakujoCountEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md004_02YakujoCountEntity inEntity) {
    }
}