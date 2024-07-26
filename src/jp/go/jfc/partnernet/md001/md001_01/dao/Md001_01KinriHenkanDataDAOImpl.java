//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01KinriHenkanDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd001_01KinriHenkanDataDAOの実装クラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Md001_01KinriHenkanDataDAOImpl extends PNBaseDAO<Md001_01KinriHenkanDataEntity> implements
        Md001_01KinriHenkanDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Md001_01KinriHenkanDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataDAO#countByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataEntity)
     */
    @Override
    public long countByCondition(Md001_01KinriHenkanDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Md001_01KinriHenkanDataEntity
     * @return List&lt;Md001_01KinriHenkanDataEntity&gt;
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataDAO#findByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataEntity)
     */
    @Override
    public List<Md001_01KinriHenkanDataEntity> findByCondition(Md001_01KinriHenkanDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md001_01KinriHenkanDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Md001_01KinriHenkanDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md001_01KinriHenkanDataEntity&gt;
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataDAO#findByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataEntity,
     *      int, int)
     */
    @Override
    public List<Md001_01KinriHenkanDataEntity> findByCondition(Md001_01KinriHenkanDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md001_01KinriHenkanDataEntity.class, offset, length);
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
        sql.append("  KH.Code_KinriKoshoSaimoku");
        sql.append(", KH.Code_KinriKosho");
        sql.append(", KH.Date_JuriStart");
        sql.append(", KH.Date_JuriEnd");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md001_01KinriHenkanDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md001_01KinriHenkanDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　資金使途コード　＝　画面の資金使途 　　かつ、事業別コード　＝　画面の事業別
         * 　　かつ、（受理開始年月日　＜＝　画面の受理起算日　AND　受理終了年月日　＞＝　画面の受理起算日） 　　かつ、借入主体コード　＝　 　　(SELECT 借入主体コード 　　　
         * FROM　扱店別顧客データ 　　 WHERE　貸付先コード　＝　画面の貸付先ｺｰﾄﾞ) 　　または、借入主体コード　＝　’999’
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" KinriHenkan KH");
        sql.append(" WHERE ");
        sql.append("(KH.Code_ShikinShito = ?)", inEntity.getCode_ShikinShito());
        sql.append(" AND ");
        sql.append("(KH.Code_Jigyoubetsu = ?)", inEntity.getCode_Jigyoubetsu());
        sql.append(" AND ");
        sql.append("(KH.Date_JuriStart <= ?", inEntity.getDate_JuriStart());
        sql.append(" AND KH.Date_JuriEnd >= ?)", inEntity.getDate_JuriStart());
        sql.append(" AND ");
        sql.append("(KH.Code_KariireShutai = ");
        sql.append("(SELECT DISTINCT AC.Code_KariireShutai ");
        sql.append(" FROM ");
        sql.append(" Acustomer AC");
        sql.append(" WHERE ");
        sql.append(" (AC.Code_Customer = ?)", inEntity.getCode_Customer());
        sql.append(")");
        sql.append("OR KH.Code_KariireShutai = '999')");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md001_01KinriHenkanDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md001_01KinriHenkanDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}