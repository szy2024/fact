//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_04GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_04.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr008_04GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_04GetResultDataDAOImpl extends PNBaseDAO<Cr008_04GetResultDataEntity> implements
        Cr008_04GetResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Cr008_04GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataDAO#countByCondition(jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataEntity)
     */
    @Override
    public long countByCondition(Cr008_04GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Cr008_04GetResultDataEntity
     * @return List&lt;Cr008_04GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataEntity)
     */
    @Override
    public List<Cr008_04GetResultDataEntity> findByCondition(Cr008_04GetResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr008_04GetResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Cr008_04GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr008_04GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Cr008_04GetResultDataEntity> findByCondition(Cr008_04GetResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Cr008_04GetResultDataEntity.class, offset, length);
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
        sql.append(" Name_Customer AS txtID_Name_Customer,");
        sql.append(" Name_Organization AS txtID_Name_Organization,");
        sql.append(" Code_ShokanHonShiten AS txtID_Code_ShokanHonShiten,");
        sql.append(" Code_Organization AS txtID_Code_Organization,");
        sql.append(" Code_Tenpo AS txtID_Code_Tenpo,");
        sql.append(" Year AS txtID_Year,");
        sql.append(" Code_HoshikiShikin AS txtID_Code_HoshikiShikin,");
        sql.append(" ID_Ringi AS txtID_ID_Ringi,");
        sql.append(" ID_RingiBranch AS txtID_ID_RingiBranch ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr008_04GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Cr008_04GetResultDataEntity inEntity) {

        // １．FROM句、WHERE句の設定
        // FROM句
        sql.append("FROM");
        sql.append(" KariukeIppanReportView A ");
        // WHERE句
        sql.append("WHERE");
        if (StringUtils.isEmpty(inEntity.getCr008_04_In_ID_Credit())) {
            /*
             * 　　債権管理番号がNULLの場合 　　　　所管本支店コード＝入力引数の公庫支店コード　かつ 　　　　扱店コード＝入力引数の扱店コード　かつ 　　　　店舗コード＝入力引数の店舗コード　かつ
             * 　　　　年度＝入力引数の年度　かつ 　　　　方式資金＝入力引数の方式資金　かつ 　　　　稟議番号＝入力引数の番号 　　　　稟議枝番号＝入力引数の枝番
             */
            sql.append(" A.Code_ShokanHonShiten = ?", inEntity.getCr008_04_In_Code_ShokanHonShiten());
            sql.append(" AND A.Code_Organization = ?", inEntity.getCr008_04_In_Code_Organization());
            sql.append(" AND A.Code_Tenpo = ?", inEntity.getCr008_04_In_Code_Tenpo());
            sql.append(" AND A.Year = ?", inEntity.getCr008_04_In_Year());
            sql.append(" AND A.Code_HoshikiShikin = ?", inEntity.getCr008_04_In_Kubun_HoshikiShikin());
            sql.append(" AND A.ID_Ringi = ?", inEntity.getCr008_04_In_ID_Ringi());
            sql.append(" AND A.ID_RingiBranch = ?", inEntity.getCr008_04_In_ID_RingiBranch());
        } else {
            /*
             * 　　債権管理番号がNULLでない場合 　　　　債権管理番号＝入力引数の債権管理番号
             */
            sql.append(" A.ID_Credit = ?", inEntity.getCr008_04_In_ID_Credit());
        }

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Cr008_04GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Cr008_04GetResultDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}