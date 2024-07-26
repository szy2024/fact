//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02TenpoNameResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/22 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_02TenpoNameResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_02TenpoNameResultDataDAOImpl extends PNBaseDAO<Se006_02TenpoNameResultDataEntity>
        implements Se006_02TenpoNameResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataEntity)
     */
    @Override
    public long countByCondition(Se006_02TenpoNameResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @return List&lt;Se006_02TenpoNameResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataEntity)
     */
    @Override
    public List<Se006_02TenpoNameResultDataEntity> findByCondition(Se006_02TenpoNameResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        return executeListResult(sql, Se006_02TenpoNameResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_02TenpoNameResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataEntity, int, int)
     */
    @Override
    public List<Se006_02TenpoNameResultDataEntity> findByCondition(Se006_02TenpoNameResultDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        return executeListResult(sql, Se006_02TenpoNameResultDataEntity.class, offset, length);
    }

    /**
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
     * <pre>
     * sqlのselect句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     */
    private void makeSqlSelect(PNSqlBuilder sql) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" SELECT ");
        sql.append(" TenpoNameView.Name_Organization ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_02TenpoNameResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_02TenpoNameResultDataEntity inEntity) {

        /*
         * １．ＦＲＯＭ句、ＷＨＥＲＥ句の設定
         * 　（１）ＦＲＯＭ句
         * 　　　　金融機関名称取得（メイン）View
         * 
         * 　（２）ＷＨＥＲＥ句
         * 　　　　金融機関名称取得（メイン）View.扱店コード ＝ 入力引数.扱店コード
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM TENPONAMEVIEW ");
        sql.where(" TenpoNameView.Code_Organization  =  ?", inEntity.getCode_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

}