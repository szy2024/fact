//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_01HaraidashiDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd002_01HaraidashiDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_01HaraidashiDataDAOImpl extends PNBaseDAO<Md002_01HaraidashiDataEntity> implements
        Md002_01HaraidashiDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md002_01HaraidashiDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataDAO#countByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataEntity)
     */
    @Override
    public long countByCondition(Md002_01HaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md002_01HaraidashiDataEntity
     * @return List&lt;Md002_01HaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataEntity)
     */
    @Override
    public List<Md002_01HaraidashiDataEntity> findByCondition(Md002_01HaraidashiDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01HaraidashiDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md002_01HaraidashiDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md002_01HaraidashiDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01HaraidashiDataEntity,
     *      int, int)
     */
    @Override
    public List<Md002_01HaraidashiDataEntity> findByCondition(Md002_01HaraidashiDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01HaraidashiDataEntity.class, offset, length);
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
        sql.append(" Haraidashi.ID_Credit");
        sql.append(" ,Haraidashi.ID_KeisuKanriShori");
        sql.append(" ,Haraidashi.M_Haraidashi");
        sql.append(" ,Haraidashi.M_HaraidashiRuikei");
        sql.append(" ,Haraidashi.M_Kurisho");
        sql.append(" ,Haraidashi.M_KurishoRuikei");
        sql.append(" ,Haraidashi.Kubun_KoseiShori");
        sql.append(" ,Haraidashi.M_ZandakaSekisu");
        sql.append(" ,Haraidashi.Date_HaraidashiJuto");
        sql.append(" ,Haraidashi.M_KashitsukeukeireZan");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01HaraidashiDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md002_01HaraidashiDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　債権管理番号　＝　入力引数の債権管理番号 　　かつ、更正処理区分　＝　'0' 　　かつ、計数管理処理番号　＜＞ 入力引数の計数管理処理番号
         * 
         * ２．その他 　　先頭１レコードのみ取得する
         */
        sql.append(" FROM ");
        sql.append(" Haraidashi ");
        sql.append(" WHERE ");
        sql.append(" Haraidashi.ID_Credit = ?", inEntity.getID_Credit());
        sql.append(" AND Haraidashi.Kubun_KoseiShori = '0'");
        sql.append(" AND Haraidashi.ID_KeisuKanriShori <> ?", inEntity.getID_KeisuKanriShori());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01HaraidashiDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md002_01HaraidashiDataEntity inEntity) {
        if (!sql.orderBy(inEntity.getSortInfo())) {
            sql.append(" ORDER BY");
            sql.append(" Haraidashi.ID_KeisuKanriShori DESC");
        }
    }
}