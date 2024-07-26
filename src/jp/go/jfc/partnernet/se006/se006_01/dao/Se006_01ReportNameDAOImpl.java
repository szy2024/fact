//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_01ReportNameDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/06 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe006_01ReportNameDAOの実装クラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_01ReportNameDAOImpl extends PNBaseDAO<Se006_01ReportNameDAOEntity> implements Se006_01ReportNameDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity
     *            Se006_01ReportNameDAOEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAO#
     *      countByCondition(jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAOEntity)
     */
    @Override
    public long countByCondition(Se006_01ReportNameDAOEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity
     *            Se006_01ReportNameDAOEntity
     * @return List&lt;Se006_01ReportNameDAOEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAOEntity)
     */
    @Override
    public List<Se006_01ReportNameDAOEntity> findByCondition(Se006_01ReportNameDAOEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_01ReportNameDAOEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity
     *            Se006_01ReportNameDAOEntity
     * @param offset
     *            取得開始位置
     * @param length
     *            取得開始位置からの取得件数
     * @return List&lt;Se006_01ReportNameDAOEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_01.dao.Se006_01ReportNameDAOEntity, int, int)
     */
    @Override
    public List<Se006_01ReportNameDAOEntity> findByCondition(Se006_01ReportNameDAOEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_01ReportNameDAOEntity.class, offset, length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
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
     * @param sql
     *            PNSqlBuilder
     */
    private void makeSqlSelect(PNSqlBuilder sql) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" SELECT ");
        sql.append(" ReportName.DataCode, ");
        sql.append(" ReportName.RyakusyouName_Report ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     * @param inEntity
     *            Se006_01ReportNameDAOEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_01ReportNameDAOEntity inEntity) {

        // １．ＦＲＯＭ句の設定
        // 　　報告書種別テーブル
        // ２．ＷＨＥＲＥ句の設定
        // 　　入力引数の報告書種別区分 ＝ "1"（実行・回収関係報告書以外）の場合

        // 　　　入力引数の権限種別 ＝ "50"（地方機構）の場合
        // 　　　　　データコード　＝　'90257130'（資金交付依頼予定表（月間）報告書） または
        // 　　　　　データコード　＝　'90257140'（資金交付依頼書（週間）報告書）

        // 　　　入力引数の権限種別 ＝ "30"（Ｈ方式受託者） または 入力引数の権限種別="61"（農林中金（支店）） の場合
        // 　　　　　データコード　＝　'90257150'（包括委任状等の交付依頼報告書）または
        // 　　　　　データコード　＝　'90257160'（（根）抵当権抹消に係る報告書）

        // 　　　上記以外の権限種別の場合
        // 　　　　　データコード　＝　'90257130'（資金交付依頼予定表（月間）報告書） または
        // 　　　　　データコード　＝　'90257140'（資金交付依頼書（週間）報告書） または
        // 　　　　　データコード　＝　'90257150'（包括委任状等の交付依頼報告書）または
        // 　　　　　データコード　＝　'90257160'（（根）抵当権抹消に係る報告書）

        // 　　入力引数の報告書種別区分 ＝ "0"（実行・回収関係報告書）の場合
        // 　　　　　データコード　≠　'90257130'（資金交付依頼予定表（月間）報告書） かつ
        // 　　　　　データコード　≠　'90257140'（資金交付依頼書（週間）報告書） かつ
        // 　　　　　データコード　≠　'90257150'（包括委任状等の交付依頼報告書） かつ
        // 　　　　　データコード　≠　'90257160'（（根）抵当権抹消に係る報告書）

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM REPORTNAME ");
        sql.append(" WHERE ");

        if (inEntity.getSyubetsuKbn_Report().equals(PNCommonConstants.SYUBETSUKBN_REPORT_1)) {
            // 入力引数の報告書種別区分 ＝ "1"（実行・回収関係報告書以外）の場合
            if (PNCommonConstants.ROLECODE_CHIHOUKIKOU.equals(inEntity.getRoleCode())) {
                // 入力引数の権限種別 ＝ "50"（地方機構）の場合
                sql.append(" ReportName.DataCode IN ( '90257130', '90257140') ");
            }
            else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(inEntity.getRoleCode()) ||
                    PNCommonConstants.ROLECODE_NOURINSHITEN.equals(inEntity.getRoleCode())) {
                // 入力引数の権限種別 ＝ "30"（Ｈ方式受託者） または 入力引数の権限種別="61"（農林中金（支店）） の場合
                sql.append(" ReportName.DataCode IN ( '90257150', '90257160') ");
            }
            else {
                // 上記以外の権限種別の場合
                sql.append(" ReportName.DataCode IN ( '90257130', '90257140' , '90257150', '90257160') ");
            }
        }
        else {
            // 入力引数の報告書種別区分 ＝ "0"（実行・回収関係報告書）の場合
            sql.append(" ReportName.DataCode NOT IN ( '90257130', '90257140' , '90257150', '90257160') ");
        }
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     * @param inEntity
     *            Se006_01ReportNameDAOEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_01ReportNameDAOEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY");
        sql.append("  ReportName.DataCode ASC");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}