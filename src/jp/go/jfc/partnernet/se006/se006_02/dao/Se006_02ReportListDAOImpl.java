//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02ReportListDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/01 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/19 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;
import jp.go.jfc.partnernet.se006.common.Se006Constants;

/**
 * <pre>
 * このクラスはSe006_02ReportListDAOの実装クラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se006_02ReportListDAOImpl extends PNBaseDAO<Se006_02ReportListEntity> implements Se006_02ReportListDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se006_02ReportListEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListDAO#
     *      countByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListEntity)
     */
    @Override
    public long countByCondition(Se006_02ReportListEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se006_02ReportListEntity
     * @return List&lt;Se006_02ReportListEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListEntity)
     */
    @Override
    public List<Se006_02ReportListEntity> findByCondition(Se006_02ReportListEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_02ReportListEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se006_02ReportListEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_02ReportListEntity&gt;
     * @see jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListDAO#
     *      findByCondition(jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListEntity, int, int)
     */
    @Override
    public List<Se006_02ReportListEntity> findByCondition(Se006_02ReportListEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se006_02ReportListEntity.class,
                offset, length);
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
        sql.append(" SELECT DISTINCT ");
        sql.append(" ReportHistory.ID_History, ");
        sql.append(" ReportHistory.Date_Report, ");
        sql.append(" ReportHistory.Time_Report, ");
        sql.append(" ReportHistory.Code_KoukoShiten, ");
        sql.append(" ReportHistory.Code_Organization, ");

        sql.append(" ReportHistory.Name_Organization, ");

        sql.append(" ReportHistory.Code_Tenpo, ");
        sql.append(" ReportHistory.Year, ");
        sql.append(" ReportHistory.Code_HoshikiShikin, ");
        sql.append(" ReportHistory.ID_Ringi, ");
        sql.append(" ReportHistory.ID_RingiBranch, ");
        sql.append(" SubTableName2.RyakusyouName_Report AS RyakusyouName_Report, ");
        sql.append(" SubTableName3.RyakusyouName_Status AS RyakusyouName_Status, ");
        sql.append(" SubTableName3.Status AS Status, ");
        sql.append(" ReportHistory.DataCode, ");
        sql.append(" ReportHistory.ID_Report, ");
        sql.append(" ReportHistory.Flag_Torikeshizumi, ");
        sql.append(" SubTableName6.RyakusyouName_Process AS RyakusyouName_Process, ");
        sql.append(" ReportHistory.ID_Master, ");
        sql.append(" ReportHistory.Code_Error, ");
        sql.append(" ReportHistory.ErrorMessage, ");
        sql.append(" SubTableName7.Date_KofuIrai AS Date_KofuIrai, ");
        sql.append(" SubTableName8.Date_Kofu AS Date_Kofu, ");
        sql.append(" SubTableName9.Flag_ShikyuHakko AS Flag_ShikyuHakko, ");
        sql.append(" SubTableName10.Date_Report AS SendDate_Report ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se006_02ReportListEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se006_02ReportListEntity inEntity) {

        /*
         * １．ＦＲＯＭ句、ＷＨＥＲＥ句の設定
         * 　（１）ＦＲＯＭ句
         * 　　　　報告書種別テーブル　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「データコード」 = 報告書種別テーブル「データコード」）
         * 　　　　報告書ステータス種別テーブル　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「ステータス」 = 報告書ステータス種別テーブル「ステータス」）
         * 　　　　報告書処理種別テーブル　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「処理種別」 = 報告書処理種別テーブル「処理種別」）
         * 　　　　資金交付依頼予定表（月間）報告書データ　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「報告書番号」 = 資金交付依頼予定表（月間）報告書データ「報告書番号」）
         * 　　　　資金交付依頼書（週間）報告書データ　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「報告書番号」 = 資金交付依頼書（週間）報告書データ「報告書番号」）
         * 　　　　包括委任状等の交付依頼報告書データ　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「報告書番号」 = 包括委任状等の交付依頼報告書データ「報告書番号」）
         * 　　　　（根）抵当権抹消に係る報告書データ　LEFT OUTER JOIN
         * 　　　　　（報告書履歴データ「報告書番号」 = （根）抵当権抹消に係る報告書データ「報告書番号」）
         * 
         * 　（２）ＷＨＥＲＥ句
         * 　　　　報告書履歴データ「報告年月日」＝（入力引数の検索開始日～入力引数の検索終了日）　かつ
         * 　　　　報告書履歴データ「取消済フラグ」＜＞取消フラグ　かつ
         * 　　　　入力引数の報告書種別＜＞""の場合
         * 　　　　　　　　報告書履歴データ「報告書種別」＝入力引数のデータコード　かつ
         * 　　　　入力引数の支店コード＜＞""の場合
         * 　　　　　　　　報告書履歴データ「公庫支店コード」＝入力引数の支店コード　かつ
         * 　　　　入力引数の扱店コード＜＞""の場合
         * 　　　　　　　　報告書履歴データ「扱店コード」＝入力引数の扱店コード　かつ
         * 　　　　　　　　報告書履歴データ「店舗コード」＝入力引数の店舗コード　かつ
         * 　　　　　　　　報告書履歴データ「年度」＝入力引数の年度　かつ
         * 　　　　　　　　報告書履歴データ「方式資金区分」＝入力引数の方式資金区分　かつ
         * 　　　　　　　　報告書履歴データ「番号」＝入力引数の番号　かつ
         * 　　　　　　　　報告書履歴データ「枝番」＝入力引数の枝番　かつ
         * 　　　　入力引数の権限種別＝"30"(Ｈ方式受託者)の場合
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257150"（包括委任）, "90257160"（（根）抵当権抹消））)
         * 　　　　入力引数の権限種別＝"50"(地方機構)の場合
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）)
         * 　　　　入力引数の権限種別＝"60"(農林中金（本店）)
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
         * 　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
         * 　　　　入力引数の権限種別＝"61"（農林中金（支店））の場合
         * 　　　　　　　　報告書履歴データ「店舗コード」＝ログインユーザの店舗コード　かつ
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
         * 　　　　入力引数の権限種別＝"62"(系統受託者)の場合
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
         * 　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
         * 　　　　入力引数の権限種別＝"70"(系統Ｈ方式受託者)の場合
         * 　　　　　　　　報告書履歴データ「報告書種別」
         * 　　　　　　　　　　　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
         * 　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" FROM REPORTHISTORY ");
        sql.append(" LEFT OUTER JOIN ReportName SubTableName2 ON  ");
        sql.append("  ReportHistory.DataCode = SubTableName2.DataCode ");
        sql.append(" LEFT OUTER JOIN ReportStatus SubTableName3 ON ");
        sql.append("  ReportHistory.Status = SubTableName3.Status ");
        sql.append(" LEFT OUTER JOIN ReportManage SubTableName6 ON ");
        sql.append("  ReportHistory.Type_Process = SubTableName6.Type_Process ");
        sql.append(" LEFT OUTER JOIN ShikinkofuGekkanReport SubTableName7 ON ");
        sql.append("  ReportHistory.ID_Report = SubTableName7.ID_Report ");
        sql.append(" LEFT OUTER JOIN ShikinkofuShukanReport SubTableName8 ON ");
        sql.append("  ReportHistory.ID_Report = SubTableName8.ID_Report ");
        sql.append(" LEFT OUTER JOIN HokatsuReport SubTableName9 ON ");
        sql.append("  ReportHistory.ID_Report = SubTableName9.ID_Report ");
        sql.append(" LEFT OUTER JOIN TeitokenReport SubTableName10 ON ");
        sql.append("  ReportHistory.ID_Report = SubTableName10.ID_Report ");

        sql.where(" ReportHistory.Date_Report BETWEEN ?", inEntity.getSearch_Start_Date());
        sql.append(" AND ?", inEntity.getSearch_End_Date());

        sql.where(" ReportHistory.Flag_Torikeshizumi <>  ?", inEntity.getTorikeshi_Flg());

        // 報告書履歴データ「報告書種別」＝入力引数のデータコード かつ
        if (!(null == inEntity.getSearch_DataCode()) && !(0 == inEntity.getSearch_DataCode().length())) {
            // 入力引数の報告書種別＜＞""の場合
            if (Se006Constants.DATACODE_DATAIL_KEY.equals(inEntity.getSearch_DataCode())
                    && (Se006Constants.INIT_DATACODE_DETAIL.equals(inEntity.getSearch_DataCode_Detail()))) {
                // 報告書種別＝"1"(実行・回収関係報告書) の場合 かつ
                // 実行・回収関係報告書詳細＝""の場合

                // 変数初期化
                String search_DataCode = "";
                // 報告書履歴データのデータコード＝"90257010"（貸付実行）～"90257121"（留置・代弁遅損（赤））
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257010 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257011 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257020 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257021 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257030 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257031 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257040 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257041 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257050 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257051 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257060 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257061 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257070 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257071 + "',";
                // search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257080 + "',";
                // search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257081 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257090 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257091 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257100 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257101 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257110 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257111 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257120 + "',";
                search_DataCode = search_DataCode + "'" + PNCommonConstants.DATACODE_90257121 + "'";
                sql.append(" AND ReportHistory.DataCode in ( " + search_DataCode + " )");
            }
            else if (!(Se006Constants.INIT_DATACODE_DETAIL.equals(inEntity.getSearch_DataCode_Detail()))) {
                // 実行・回収関係報告書詳細≠""の場合
                sql.append(" AND ReportHistory.DataCode = ?", inEntity.getSearch_DataCode_Detail());
            }
            else {
                // 報告書履歴データ「報告書種別」＝入力引数のデータコード かつ
                sql.append(" AND ReportHistory.DataCode = ?", inEntity.getSearch_DataCode());
            }
        }

        if (!(null == inEntity.getSearch_Shiten()) && !(0 == inEntity.getSearch_Shiten().length())) {
            // 入力引数の支店コード＜＞""の場合
            // 報告書履歴データ「公庫支店コード」＝入力引数の支店コード かつ
            sql.append(" AND ReportHistory.Code_KoukoShiten = ?", inEntity.getSearch_Shiten());
        }

        if (!(null == inEntity.getSearch_Code_Organization()) &&
                !(0 == inEntity.getSearch_Code_Organization().length())) {
            // 入力引数の扱店コード＜＞""の場合
            sql.append(" AND ReportHistory.Code_Organization = ?", inEntity.getSearch_Code_Organization());
        }

        if (!(null == inEntity.getSearch_YN_Code_Organization()) &&
                !(0 == inEntity.getSearch_YN_Code_Organization().length())) {
            // 入力引数の融資番号（扱店コード）＜＞""の場合
            // 報告書履歴データ「扱店コード」 ＝ 入力引数の融資番号（扱店コード） かつ
            // 報告書履歴データ「店舗コード」 ＝ 入力引数の融資番号（店舗コード） かつ
            // 報告書履歴データ「年度 」＝ 入力引数の融資番号（年度） かつ
            // 報告書履歴データ「方式資金区分」＝ 入力引数の融資番号（方式資金区分） かつ
            // 報告書履歴データ「番号」 ＝ 入力引数の融資番号（番号） かつ
            // 報告書履歴データ「枝番」 ＝ 入力引数の融資番号（枝番） かつ
            sql.append(" AND ReportHistory.Code_Organization = ?", inEntity.getSearch_YN_Code_Organization());
            sql.append(" AND ReportHistory.Code_Tenpo = ?", inEntity.getSearch_YN_Code_Tenpo());
            sql.append(" AND ReportHistory.Year = ?", inEntity.getSearch_YN_Year());
            sql.append(" AND ReportHistory.Code_HoshikiShikin = ?", inEntity.getSearch_YN_Kubun_HoshikiShikin());
            sql.append(" AND ReportHistory.ID_Ringi = ?", inEntity.getSearch_YN_Ringi());
            sql.append(" AND ReportHistory.ID_RingiBranch = ?", inEntity.getSearch_YN_Ringibranch());
        }

        // 入力引数の権限種別＝"30"(Ｈ方式受託者)の場合
        if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「報告書種別」　IN　("90257150"（包括委任）, "90257160"（（根）抵当権抹消））)
            sql.append(" AND ReportHistory.DataCode IN ('90257150', '90257160')");
        }

        // 入力引数の権限種別＝"50"(地方機構)の場合
        if (PNCommonConstants.ROLECODE_CHIHOUKIKOU.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「報告書種別」　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）)
            sql.append(" AND ReportHistory.DataCode IN ('90257130', '90257140')");
        }

        // 入力引数の権限種別＝"60"(農林中金（本店）)
        if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「報告書種別」　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
            // 　　　　　　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
            sql.append(" AND ReportHistory.DataCode IN ('90257130', '90257140','90257150','90257160')");
        }

        // 入力引数の権限種別＝"61"（農林中金（支店））の場合
        if (PNCommonConstants.ROLECODE_NOURINSHITEN.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「店舗コード」＝ログインユーザの店舗コード　かつ
            // 報告書履歴データ「報告書種別」　IN　("90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
            sql.append(" AND ReportHistory.Code_Tenpo = ?", PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());
            sql.append(" AND ReportHistory.DataCode IN ('90257150','90257160')");
        }

        // 入力引数の権限種別＝"62"(系統受託者)の場合
        if (PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「報告書種別」　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
            // 　　　　　　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
            sql.append(" AND ReportHistory.DataCode IN ('90257130', '90257140','90257150','90257160')");
        }

        // 入力引数の権限種別＝"70"(系統Ｈ方式受託者)の場合
        if (PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(inEntity.getRoleCode())) {
            // 報告書履歴データ「報告書種別」　IN　("90257130"（資金交付(月間)）, "90257140"（資金交付(週間)）
            // 　　　　　　　　　　　　　　　　　　 "90257150"（包括委任）, "90257160"（（根）抵当権抹消）））
            sql.append(" AND ReportHistory.DataCode IN ('90257130', '90257140','90257150','90257160')");
        }
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
     *            Se006_02ReportListEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se006_02ReportListEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.orderBy(inEntity.getSortInfo());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}