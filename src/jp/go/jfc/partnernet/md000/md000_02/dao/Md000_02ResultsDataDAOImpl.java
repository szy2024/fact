//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md000_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.md000.md000_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd000_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md000_02ResultsDataDAOImpl extends PNBaseDAO<Md000_02ResultsDataEntity> implements
        Md000_02ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataDAO#
     *      countByCondition(jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataEntity)
     */
    @Override
    public long countByCondition(Md000_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @return List&lt;Md000_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataEntity)
     */
    @Override
    public List<Md000_02ResultsDataEntity> findByCondition(Md000_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md000_02ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md000_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataDAO#
     *      findByCondition(jp.go.jfc.partnernet.md000.md000_02.dao.Md000_02ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Md000_02ResultsDataEntity> findByCondition(Md000_02ResultsDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md000_02ResultsDataEntity.class, offset, length);
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
        sql.append(" SELECT");
        sql.append(" ReportHistoryModView.Date_Report");
        sql.append(" , ReportHistoryModView.Time_Report");
        sql.append(" , SubTableName1.RyakusyouName_Report AS BizJoinItem1");
        sql.append(" , ReportHistoryModView.DataCode");
        sql.append(" , SubTableName2.RyakusyouName_Status AS BizJoinItem2");
        sql.append(" , ReportHistoryModView.Status");
        sql.append(" , ReportHistoryModView.ID_Report");
        sql.append(" , ReportHistoryModView.Type_Process");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md000_02ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md000_02ResultsDataEntity inEntity) {

        /*
         * １．FROM句の設定
         *   報告書取消・修正対象取得ビュー LEFT OUTER JOIN 報告書種別データ ON 報告書取消・修正対象取得ビュー
         * .データコード ＝ 報告書種別データ.データコード
         *   報告書取消・修正対象取得ビュー LEFT OUTER JOIN 報告書ステータス種別テーブル
         *  ON 報告書取消・修正対象取得ビュー.ステータス ＝ 報告書ステータス種別テーブル.ステータス
         *
         * ２．WHERE句の設定
         *   ①検索タイプが融資番号の場合
         *     支店＝指定された支店
         *     扱店＝指定された扱店
         *     店舗＝指定された店舗
         *     年度＝指定された年度(西暦変換されたもの)
         *     方式資金＝指定された方式＋指定された資金
         *     稟議番号＝指定された番号
         *     枝番＝指定された枝番(空白の場合、０とする)
         *     データコード＜＞９０２５７０８０
         *     データコード＜＞９０２５７０８１
         *     データコード＜＞９０２５７１１０
         *     データコード＜＞９０２５７１１１
         *
         *   ②検索タイプが仮受金（一般口）受入の場合
         *     扱店＝ログインユーザの扱店、かつ、
         *    （1）ログインユーザの権限種別が"30"（Ｈ方式受託者）の場合
         *      データコードが、９０２５７１５０ または、９０２５７１６０ かつ、
         *    （2）ログインユーザの権限種別が"50"（地方機構）
         *      データコードが、９０２５７１３０ または、９０２５７１４０ かつ、
         *    （3）ログインユーザの権限種別が"60"（農林中金（本店））の場合
         *      店舗＝ログインユーザの扱店、かつ、
         *      データコードが、９０２５７１３０ または、９０２５７１４０ または、
         *      データコードが、９０２５７１５０ または、９０２５７１６０ かつ、
         *    （4）ログインユーザの権限種別が"61"（農林中金（支店））の場合
         *      店舗＝ログインユーザの扱店、かつ、
         *      データコードが、９０２５７１５０ または、９０２５７１６０ かつ、
         *    （5）ログインユーザの権限種別が"62"（系統受託者）または "70"（系統Ｈ方式受託者）の場合
         *      データコードが、９０２５７１３０ または、９０２５７１４０ または、
         *      データコードが、９０２５７１５０ または、９０２５７１６０ かつ、
         *     債権管理番号がNULL、かつ、
         *    （1） 指定されたデータコード ＝ ９０２５７１１０の場合
         *      データコードが、９０２５７１１０ または、９０２５７１１１
         *    （2） 指定されたデータコード ＝ ９０２５７１２０の場合
         *      ９０２５７１２０ または、９０２５７１２１
         *    （3） 指定されたデータコード ＝ ９０２５７１３０の場合
         *      データコードが、９０２５７１３０
         *    （4） 指定されたデータコード ＝ ９０２５７１４０の場合
         *      データコードが、９０２５７１４０
         *    （5） 指定されたデータコード ＝ ９０２５７１５０の場合
         *      データコードが、９０２５７１５０
         *    （6） 上記以外の場合
         *      データコードが、９０２５７１１０ または、９０２５７１１１
         *      または、９０２５７１２０ または、９０２５７１２１ または、９０２５７１３０または、
         *      ９０２５７１４０または、 ９０２５７１５０または、 ９０２５７１６０
         *
         */

        sql.append(" FROM");
        sql.append(" ReportHistoryModView");
        sql.append(" LEFT OUTER JOIN ReportName SubTableName1 ON ReportHistoryModView.DataCode = SubTableName1.DataCode");
        sql.append(" LEFT OUTER JOIN ReportStatus SubTableName2 ON ReportHistoryModView.Status = SubTableName2.Status");
        sql.append(" WHERE");

        if (Md000Constants.SEARCH_TYPE_YUSIHI.equals(inEntity.getSearchType())) {
            // 融資番号のとき
            sql.append(" ReportHistoryModView.Code_KoukoShiten = ?", inEntity.getCode_KoukoShiten());
            sql.append(" AND ReportHistoryModView.Code_Organization = ?", inEntity.getCode_Organization());
            sql.append(" AND ReportHistoryModView.Code_Tenpo = ?", inEntity.getCode_Tenpo());
            sql.append(" AND ReportHistoryModView.Year = ?", inEntity.getYear());
            sql.append(" AND ReportHistoryModView.Code_HoshikiShikin = ?", inEntity.getCode_HoshikiShikin());
            sql.append(" AND ReportHistoryModView.ID_Ringi = ?", inEntity.getID_Ringi());
            sql.append(" AND ReportHistoryModView.ID_RingiBranch = ?", inEntity.getID_RingiBranch());
            sql.append(" AND ReportHistoryModView.DataCode <> '90257080'");
            sql.append(" AND ReportHistoryModView.DataCode <> '90257081'");
            sql.append(" AND ReportHistoryModView.DataCode <> '90257110'");
            sql.append(" AND ReportHistoryModView.DataCode <> '90257111'");
        }
        else {
            // 融資番号検索ではない場合
            sql.append(" ReportHistoryModView.Code_Organization = ?", inEntity.getCode_Organization());
            if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(inEntity.getRoleCode())) {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257150', '90257160')");

            }
            else if (PNCommonConstants.ROLECODE_CHIHOUKIKOU.equals(inEntity.getRoleCode())) {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257130', '90257140')");

            }
            else if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(inEntity.getRoleCode())) {
                sql.append(" AND ReportHistoryModView.Code_Tenpo = ?", inEntity.getCode_Tenpo());
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257130', '90257140', '90257150', '90257160')");

            }
            else if (PNCommonConstants.ROLECODE_NOURINSHITEN.equals(inEntity.getRoleCode())) {
                sql.append(" AND ReportHistoryModView.Code_Tenpo = ?", inEntity.getCode_Tenpo());
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257150', '90257160')");

            }
            else if (PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA.equals(inEntity.getRoleCode())
                    || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(inEntity.getRoleCode())) {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257130', '90257140', '90257150', '90257160')");

            }
            sql.append(" AND ReportHistoryModView.ID_Credit IS NULL");
            if (PNCommonConstants.DATACODE_90257110.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257110', '90257111')");
            }
            else if (PNCommonConstants.DATACODE_90257120.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257120', '90257121')");
            }
            else if (PNCommonConstants.DATACODE_90257130.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode = '90257130'");
            }
            else if (PNCommonConstants.DATACODE_90257140.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode = '90257140'");
            }
            else if (PNCommonConstants.DATACODE_90257150.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode = '90257150'");
            }
            else if (PNCommonConstants.DATACODE_90257160.equals(inEntity.getDataCode())) {
                sql.append(" AND ReportHistoryModView.DataCode = '90257160'");
            }
            else {
                sql.append(" AND ReportHistoryModView.DataCode IN ('90257110', '90257111', '90257120',");
                sql.append("  '90257121','90257130', '90257140', '90257150', '90257160')");
            }
        }
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md000_02ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md000_02ResultsDataEntity inEntity) {
        if (!sql.orderBy(inEntity.getSortInfo())) {
            sql.append(" ORDER BY");
            sql.append(" ReportHistoryModView.ID_History DESC");
        }
    }
}