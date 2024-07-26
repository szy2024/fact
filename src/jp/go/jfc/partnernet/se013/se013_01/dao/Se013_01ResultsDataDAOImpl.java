//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.dao;

import java.util.List;

import org.hsqldb.lib.StringUtil;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe013_01ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se013_01ResultsDataDAOImpl extends PNBaseDAO<Se013_01ResultsDataEntity> implements Se013_01ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se013_01ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataDAO
     * #countByCondition(jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataEntity)
     */
    @Override
    public long countByCondition(Se013_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se013_01ResultsDataEntity
     * @return List&lt;Se013_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataEntity)
     */
    @Override
    public List<Se013_01ResultsDataEntity> findByCondition(Se013_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se013_01ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se013_01ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se013_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se013.se013_01.dao.Se013_01ResultsDataEntity, int, int)
     */
    @Override
    public List<Se013_01ResultsDataEntity> findByCondition(Se013_01ResultsDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se013_01ResultsDataEntity.class,
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
        sql.append("SELECT  ");
        sql.append("    RI.Code_Organization ");
        sql.append("    ,OName.Name_Organization ");
        sql.append("    ,RI.Date_Jyohoteikyo ");
        sql.append("    ,RI.Date_Taisho ");
        sql.append("    ,RI.Disp_Docname ");
        sql.append("    ,RI.Docname");
        sql.append("    ,RI.Filepath ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se013_01ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se013_01ResultsDataEntity inEntity) {

        /*
        LEFT JOIN 金融機関店舗データ KK ON (GI.扱店コード = KK.機関コード)
        WHERE GI.情報提供日 ≦ #{エンティティ.業務日付}
            AND GI.扱店コード = #{エンティティ.扱店コード}　※画面で指定された場合のみ
            AND GI.対象年月 ≧ #{エンティティ.検索開始年月}　※画面で指定された場合のみ
            AND GI.対象年月 ≦ #{エンティティ.検索終了年月}　※画面で指定された場合のみ
            AND KK.機関コード IS NOT NULL  ※未加盟店検索が未チェックの場合のみ
            AND KK.機関コード IS NULL  ※未加盟店検索がチェックの場合のみ
        */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // FROM句
        sql.append("FROM RishijoseiIndex RI ");
        sql.append("LEFT JOIN TenpoNameView OName ");
        sql.append("ON RI.Code_Organization = OName.Code_Organization ");

        // WHERE句
        // 情報提供日
        sql.append("WHERE RI.Date_JyohoTeikyo <= ? ", inEntity.getDate_business());
        // 検索開始年月
        sql.append("AND RI.Date_Taisho >= ? ", inEntity.getSearch_start_date());
        // 検索終了年月
        sql.append("AND RI.Date_Taisho <= ? ", inEntity.getSearch_end_date());
        // 未加盟店検索
        if (StringUtil.isEmpty(inEntity.getSearch_mikameiten())) {
            sql.append("AND EXISTS(SELECT * FROM PN_USER PU WHERE PU.Code_Organization = RI.Code_Organization) ");
        }
        else {
            sql.append("AND NOT EXISTS(SELECT * FROM PN_USER PU WHERE PU.Code_Organization = RI.Code_Organization) ");
        }
        // 扱店コード
        if (StringUtil.isEmpty(inEntity.getCode_organization()) == false) {
            sql.append("AND RI.Code_Organization = ? ", inEntity.getCode_organization());
        }
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se013_01ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se013_01ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("ORDER BY  ");
        sql.append("    RI.Code_Organization ASC");
        sql.append("    ,OName.Name_Organization ASC");
        sql.append("    ,RI.Date_Jyohoteikyo DESC");
        sql.append("    ,RI.Date_Taisho DESC");
        sql.append("    ,RI.Disp_Docname ASC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}