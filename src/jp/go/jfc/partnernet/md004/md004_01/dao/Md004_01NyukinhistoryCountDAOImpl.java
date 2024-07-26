//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01NyukinhistoryCountDAOImpl
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
 * このクラスはMd004_01NyukinhistoryCountDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_01NyukinhistoryCountDAOImpl extends PNBaseDAO<Md004_01NyukinhistoryCountEntity> implements
        Md004_01NyukinhistoryCountDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md004_01NyukinhistoryCountEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountDAO#countByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountEntity)
     */
    @Override
    public long countByCondition(Md004_01NyukinhistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md004_01NyukinhistoryCountEntity
     * @return List&lt;Md004_01NyukinhistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountEntity)
     */
    @Override
    public List<Md004_01NyukinhistoryCountEntity> findByCondition(Md004_01NyukinhistoryCountEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_01NyukinhistoryCountEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md004_01NyukinhistoryCountEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_01NyukinhistoryCountEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountEntity,
     *      int, int)
     */
    @Override
    public List<Md004_01NyukinhistoryCountEntity> findByCondition(Md004_01NyukinhistoryCountEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_01NyukinhistoryCountEntity.class, offset, length);
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
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_01NyukinhistoryCountEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md004_01NyukinhistoryCountEntity inEntity) {

        /*
         * １．WHERE句の設定 　　債権管理番号 = 指定した債権管理番号 　　払込年月日 >= 一時変数の次々回払込年月日 　　更正処理区分＝０ 　　(約定元金＝０ または、約定利息＝０)
         */

        sql.append(" FROM ");
        sql.append(" NyukinHistory");
        sql.append(" WHERE ");
        sql.append(" NyukinHistory.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND NyukinHistory.Date_Haraikomi >= ?", inEntity.getDate_Haraikomi());
        sql.append(" AND NyukinHistory.Kubun_Koseishori = '0'");
        sql.append(" AND (M_YakujoGankin > 0 OR M_YakujoRisoku > 0)");
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_01NyukinhistoryCountEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md004_01NyukinhistoryCountEntity inEntity) {
    }
}