//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01InputDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr001_01InputDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr001_01InputDataDAOImpl extends PNBaseDAO<Cr001_01InputDataEntity> implements
        Cr001_01InputDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr001_01InputDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataDAO#countByCondition(jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataEntity)
     */
    @Override
    public long countByCondition(Cr001_01InputDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr001_01InputDataEntity
     * @return List&lt;Cr001_01InputDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataDAO#findByCondition(jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataEntity)
     */
    @Override
    public List<Cr001_01InputDataEntity> findByCondition(Cr001_01InputDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr001_01InputDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr001_01InputDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr001_01InputDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataDAO#findByCondition(jp.go.jfc.partnernet.cr001.cr001_01.dao.Cr001_01InputDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr001_01InputDataEntity> findByCondition(Cr001_01InputDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr001_01InputDataEntity.class, offset, length);
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
        sql.append(" Date_Report");
        sql.append(" , Name_Customer");
        sql.append(" , Name_Organization");
        sql.append(" , Code_ShokanHonShiten");
        sql.append(" , Code_Organization");
        sql.append(" , Code_Tenpo");
        sql.append(" , Year");
        sql.append(" , Code_HoshikiShikin");
        sql.append(" , ID_Ringi");
        sql.append(" , ID_RingiBranch");
        sql.append(" , Code_ShikinShito");
        sql.append(" , Code_Jigyobetsu");
        sql.append(" , Riritsu");
        sql.append(" , Kubun_Tokuri");
        sql.append(" , Tokuri");
        sql.append(" , Date_SueokiKigen");
        sql.append(" , Date_ShokanKigen");
        sql.append(" , Date_GanrikinHaraiKomi");
        sql.append(" , Date_Jtkshori");
        sql.append(" , Date_Kashitsukejikko");
        sql.append(" , M_Kashitsuke");
        sql.append(" , M_ShikinKofu");
        sql.append(" , M_KashitukeUkeire");
        sql.append(" , Flag_Kj");
        sql.append(" , ID_Report");
        sql.append(" , Time_Report");
        sql.append(" , UserID");
        sql.append(" , ID_Denso");
        sql.append(" , DataCode");
        sql.append(" , Count_Kashitsuke");
        sql.append(" , ID_History");
        sql.append(" , Status");
        sql.append(" , Type_Process");
        sql.append(" , Flag_Torikeshizumi");
        sql.append(" , Code_Error");
        sql.append(" , ErrorMessage");
        sql.append(" , ID_Credit");
        sql.append(" , Code_Customer");
        sql.append(" , Date_JuriKisan");
        sql.append(" , Date_KetteiKisan");
        sql.append(" , Data_LastUpDate");
        sql.append(" , Date_Jikko");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr001_01InputDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr001_01InputDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　貸付実行報告書作成ビュー.扱店　＝　ログインユーザの扱店コード　
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM");
        sql.append(" KashitukeJikkoView ");
        sql.append(" WHERE ");
        sql.append(" Code_Organization = ?", inEntity.getCode_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr001_01InputDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr001_01InputDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY");
        sql.append(" Date_Jikko");
        sql.append(" , Code_ShokanHonShiten");
        sql.append(" , Code_Organization");
        sql.append(" , Code_Tenpo");
        sql.append(" , Year");
        sql.append(" , CAST(ID_Ringi AS int)");
        sql.append(" , CAST(ID_RingiBranch AS int)");

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}