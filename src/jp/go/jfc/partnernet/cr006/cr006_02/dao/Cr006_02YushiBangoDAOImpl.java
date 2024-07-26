//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02YushiBangoDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/12/01 | 林　晃平              | 新規作成（委託貸付報告等における機能改善対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr006_02YushiBangoDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_02YushiBangoDAOImpl extends PNBaseDAO<Cr006_02YushiBangoEntity> implements Cr006_02YushiBangoDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr006_02YushiBangoEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoDAO#
     *      countByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoEntity)
     */
    @Override
    public long countByCondition(Cr006_02YushiBangoEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr006_02YushiBangoEntity
     * @return List&lt;Cr006_02YushiBangoEntity&gt;
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoEntity)
     */
    @Override
    public List<Cr006_02YushiBangoEntity> findByCondition(Cr006_02YushiBangoEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_02YushiBangoEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr006_02YushiBangoEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_02YushiBangoEntity&gt;
     * @see jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoDAO#
     *      findByCondition(jp.go.jfc.partnernet.cr006.cr006_02.dao.Cr006_02YushiBangoEntity, int, int)
     */
    @Override
    public List<Cr006_02YushiBangoEntity> findByCondition(Cr006_02YushiBangoEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr006_02YushiBangoEntity.class,
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
        sql.append("SELECT ");
        sql.append("ID_Credit ");
        sql.append(",Year ");
        sql.append(",Kubun_Hoshiki ");
        sql.append(",Kubun_Shikin ");
        sql.append(",ID_Ringi ");
        sql.append(",ID_RingiBranch ");
        sql.append(",Data_LastUpDate ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_02YushiBangoEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr006_02YushiBangoEntity inEntity) {

        /*
        １．WHERE句の設定
        　　扱店別稟議データ．貸付先コード ＝ 入力引数．貸付先コード かつ
        　　扱店別稟議データ．実行年月日 ＜＞ NULL かつ
        　　扱店別稟議データ．所管本支店コード ＝ 入力引数．公庫支店 かつ
        　　扱店別稟議データ．扱店コード ＝ 入力引数．扱店 かつ
        　　扱店別稟議データ．店舗コード ＝ 入力引数．店舗
        */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM ");
        sql.append(" aRingi ");
        sql.append(" WHERE ");
        sql.append(" Code_Customer = ? ", inEntity.getCode_Customer());
        sql.append(" AND aRingi.Date_Jikko IS NOT NULL ");
        sql.append(" AND aRingi.Code_Shokanhonshiten = ? ", inEntity.getCode_KoukoShiten());
        sql.append(" AND aRingi.Code_Organization = ? ", inEntity.getCode_Organization());
        sql.append(" AND aRingi.Code_Tenpo = ? ", inEntity.getCode_Tenpo());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr006_02YushiBangoEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr006_02YushiBangoEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY");
        sql.append(" aRingi.ID_Credit DESC ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}