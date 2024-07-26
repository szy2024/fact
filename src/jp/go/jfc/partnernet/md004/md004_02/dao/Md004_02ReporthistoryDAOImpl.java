//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02ReporthistoryDAOImpl
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
 * このクラスはMd004_02ReporthistoryDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02ReporthistoryDAOImpl extends PNBaseDAO<Md004_02ReporthistoryEntity> implements
        Md004_02ReporthistoryDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md004_02ReporthistoryEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryDAO#countByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryEntity)
     */
    @Override
    public long countByCondition(Md004_02ReporthistoryEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md004_02ReporthistoryEntity
     * @return List&lt;Md004_02ReporthistoryEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryEntity)
     */
    @Override
    public List<Md004_02ReporthistoryEntity> findByCondition(Md004_02ReporthistoryEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02ReporthistoryEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md004_02ReporthistoryEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_02ReporthistoryEntity&gt;
     * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryDAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02ReporthistoryEntity,
     *      int, int)
     */
    @Override
    public List<Md004_02ReporthistoryEntity> findByCondition(Md004_02ReporthistoryEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md004_02ReporthistoryEntity.class, offset, length);
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
     * @param inEntity Md004_02ReporthistoryEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md004_02ReporthistoryEntity inEntity) {

        /*
         * １．WHERE句の設定 　　　①履歴番号　＝　指定された履歴番号 　　　②引数のステータスが空白以外の場合、 　　　　　ステータス　＝　引数のステータス 　　　　上記以外の場合
         * 　　　　　ステータス　IS　NULL 　　　③引数の処理種別が空白以外の場合、 　　　　　処理種別　＝　引数の処理種別 　　　　上記以外の場合 　　　　　処理種別　IS　NULL
         * 　　　②引数のデータコードが空白以外の場合、 　　　　　データコード　＝　引数のデータコード 　　　　上記以外の場合 　　　　　データコード　IS　NULL
         */

        sql.whereEqual("History", inEntity.getID_History());
        sql.whereEqual("Status", inEntity.getStatus().toString());
        // 　　　③引数の処理種別が空白以外の場合、
        // 　　　　　処理種別　＝　引数の処理種別
        // 　　　　上記以外の場合
        // 　　　　　処理種別　IS　NULL
        if (null != inEntity.getType_Process() || 0 != inEntity.getType_Process().length()) {
            sql.whereEqual("Type_Process ", inEntity.getType_Process());
        } else {
            sql.where("Type_Process  IS NULL");
        }
        // 　　　②引数のデータコードが空白以外の場合、
        // 　　　　　データコード　＝　引数のデータコード
        // 　　　　上記以外の場合
        // 　　　　　データコード　IS　NULL
        if (null != inEntity.getDataCode() || 0 != inEntity.getDataCode().length()) {
            sql.whereEqual("DataCode ", inEntity.getDataCode());
        } else {
            sql.where("DataCode  IS NULL");
        }
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md004_02ReporthistoryEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md004_02ReporthistoryEntity inEntity) {
    }
}