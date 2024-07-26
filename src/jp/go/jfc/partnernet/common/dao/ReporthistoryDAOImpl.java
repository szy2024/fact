//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Reporthistory
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNSingleTableDAO;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * 報告書履歴データの単テーブルDAO実装クラスです。
 * データーベースアクセス各種機能
 * （検索／追加／更新／削除機能）
 * を提供します。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class ReporthistoryDAOImpl extends PNSingleTableDAO<ReporthistoryEntity> implements ReporthistoryDAO {

    /**
     * <pre>
     * プライマリキー検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（１件）
     * @throws CFWFindParameterException パラメーターが不正な時に発生
     */
    @Override
    public ReporthistoryEntity findByPrimaryKey(ReporthistoryEntity inEntity) throws
            CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_History,");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" Status,");
        sql.append(" ID_Master,");
        sql.append(" DataCode,");
        sql.append(" Type_Process,");
        sql.append(" Flag_Torikeshizumi,");
        sql.append(" UserID,");
        sql.append(" Name_Organization,");
        sql.append(" Name_Customer,");
        sql.append(" Code_KoukoShiten,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Year,");
        sql.append(" Code_HoshikiShikin,");
        sql.append(" ID_Ringi,");
        sql.append(" ID_RingiBranch,");
        sql.append(" Code_Error,");
        sql.append(" ErrorMessage,");
        sql.append(" ID_Credit,");
        sql.append(" Keep_M_Fukin,");
        sql.append(" Keep_M_GankinFukinto,");
        sql.append(" Keep_Kubun_GankinFukinto,");
        sql.append(" Keep_M_KashitsukeZan,");
        sql.append(" Keep_M_YakujoGankin,");
        sql.append(" Keep_M_YakujoRisoku,");
        sql.append(" Keep_Date_ShokanKigen,");
        sql.append(" Keep_M_KojoRisoku,");
        sql.append(" Keep_Date_Haraikomi,");
        sql.append(" Keep_Seikyu_M_NinKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriGankin,");
        sql.append(" Keep_Yakujo_M_SeiKuriRisoku,");
        sql.append(" Keep_JohenKianchu,");
        sql.append(" Keep_ID_History,");
        sql.append(" Keep_Flag_Kj,");
        sql.append(" Keep_M_TatekaeZanAfterUkeire,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ReportHistory ");

        sql.where(" ID_History = ?", inEntity.getValue("ID_History"));

        return executeSingleResult(sql, ReporthistoryEntity.class);
    }

    /**
     * <pre>
     * 条件検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（複数件）
     */
    @Override
    public List<ReporthistoryEntity> findByCondition(ReporthistoryEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_History,");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" Status,");
        sql.append(" ID_Master,");
        sql.append(" DataCode,");
        sql.append(" Type_Process,");
        sql.append(" Flag_Torikeshizumi,");
        sql.append(" UserID,");
        sql.append(" Name_Organization,");
        sql.append(" Name_Customer,");
        sql.append(" Code_KoukoShiten,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Year,");
        sql.append(" Code_HoshikiShikin,");
        sql.append(" ID_Ringi,");
        sql.append(" ID_RingiBranch,");
        sql.append(" Code_Error,");
        sql.append(" ErrorMessage,");
        sql.append(" ID_Credit,");
        sql.append(" Keep_M_Fukin,");
        sql.append(" Keep_M_GankinFukinto,");
        sql.append(" Keep_Kubun_GankinFukinto,");
        sql.append(" Keep_M_KashitsukeZan,");
        sql.append(" Keep_M_YakujoGankin,");
        sql.append(" Keep_M_YakujoRisoku,");
        sql.append(" Keep_Date_ShokanKigen,");
        sql.append(" Keep_M_KojoRisoku,");
        sql.append(" Keep_Date_Haraikomi,");
        sql.append(" Keep_Seikyu_M_NinKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriGankin,");
        sql.append(" Keep_Yakujo_M_SeiKuriRisoku,");
        sql.append(" Keep_JohenKianchu,");
        sql.append(" Keep_ID_History,");
        sql.append(" Keep_Flag_Kj,");
        sql.append(" Keep_M_TatekaeZanAfterUkeire,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ReportHistory ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, ReporthistoryEntity.class);
    }

    /**
     * <pre>
     * 条件検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得数
     * @return 検索結果（複数件）
     */
    @Override
    public List<ReporthistoryEntity> findByCondition(ReporthistoryEntity inEntity, int offset, int length) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_History,");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" Status,");
        sql.append(" ID_Master,");
        sql.append(" DataCode,");
        sql.append(" Type_Process,");
        sql.append(" Flag_Torikeshizumi,");
        sql.append(" UserID,");
        sql.append(" Name_Organization,");
        sql.append(" Name_Customer,");
        sql.append(" Code_KoukoShiten,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Year,");
        sql.append(" Code_HoshikiShikin,");
        sql.append(" ID_Ringi,");
        sql.append(" ID_RingiBranch,");
        sql.append(" Code_Error,");
        sql.append(" ErrorMessage,");
        sql.append(" ID_Credit,");
        sql.append(" Keep_M_Fukin,");
        sql.append(" Keep_M_GankinFukinto,");
        sql.append(" Keep_Kubun_GankinFukinto,");
        sql.append(" Keep_M_KashitsukeZan,");
        sql.append(" Keep_M_YakujoGankin,");
        sql.append(" Keep_M_YakujoRisoku,");
        sql.append(" Keep_Date_ShokanKigen,");
        sql.append(" Keep_M_KojoRisoku,");
        sql.append(" Keep_Date_Haraikomi,");
        sql.append(" Keep_Seikyu_M_NinKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriGankin,");
        sql.append(" Keep_Yakujo_M_SeiKuriRisoku,");
        sql.append(" Keep_JohenKianchu,");
        sql.append(" Keep_ID_History,");
        sql.append(" Keep_Flag_Kj,");
        sql.append(" Keep_M_TatekaeZanAfterUkeire,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ReportHistory ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, ReporthistoryEntity.class, offset, length);
    }

    /**
     * <pre>
     * 条件検索を実行し、結果件数を取得します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（ヒット件数）
     */
    @Override
    public long countByCondition(ReporthistoryEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" COUNT(1) ");
        sql.append("FROM");
        sql.append(" ReportHistory ");

        setSelectCondition(sql, inEntity);

        return executeCountResult(sql);
    }

    /**
     * <pre>
     * プライマリキー検索を実行します(FOR UPDATE付).
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（１件）
     * @throws CFWFindParameterException パラメーターが不正な時に発生
     * @throws CFWForUpdateException レコードがロックされている時に発生
     */
    @Override
    public ReporthistoryEntity findByPrimaryKeyForUpdate(ReporthistoryEntity inEntity) throws
            CFWFindParameterException, CFWForUpdateException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_History,");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" Status,");
        sql.append(" ID_Master,");
        sql.append(" DataCode,");
        sql.append(" Type_Process,");
        sql.append(" Flag_Torikeshizumi,");
        sql.append(" UserID,");
        sql.append(" Name_Organization,");
        sql.append(" Name_Customer,");
        sql.append(" Code_KoukoShiten,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Year,");
        sql.append(" Code_HoshikiShikin,");
        sql.append(" ID_Ringi,");
        sql.append(" ID_RingiBranch,");
        sql.append(" Code_Error,");
        sql.append(" ErrorMessage,");
        sql.append(" ID_Credit,");
        sql.append(" Keep_M_Fukin,");
        sql.append(" Keep_M_GankinFukinto,");
        sql.append(" Keep_Kubun_GankinFukinto,");
        sql.append(" Keep_M_KashitsukeZan,");
        sql.append(" Keep_M_YakujoGankin,");
        sql.append(" Keep_M_YakujoRisoku,");
        sql.append(" Keep_Date_ShokanKigen,");
        sql.append(" Keep_M_KojoRisoku,");
        sql.append(" Keep_Date_Haraikomi,");
        sql.append(" Keep_Seikyu_M_NinKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriRisoku,");
        sql.append(" Keep_Seikyu_M_SeiKuriGankin,");
        sql.append(" Keep_Yakujo_M_SeiKuriRisoku,");
        sql.append(" Keep_JohenKianchu,");
        sql.append(" Keep_ID_History,");
        sql.append(" Keep_Flag_Kj,");
        sql.append(" Keep_M_TatekaeZanAfterUkeire,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ReportHistory ");

        sql.where(" ID_History = ?", inEntity.getValue("ID_History"));

        sql.append("FOR UPDATE NOWAIT");
        return executeSingleResultForUpdate(sql, ReporthistoryEntity.class);
    }

    /**
     * <pre>
     * 登録処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（登録情報）
     * @return 登録結果件数
     * @throws CFWDuplicateKeyException プライマリーキーが重複しているときに発生
     */
    @Override
    public int insert(ReporthistoryEntity inEntity) throws CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("INSERT INTO ReportHistory ");
        sql.append("(");
        setInsertColumn(sql, inEntity);
        sql.append(") VALUES (");
        setInsertColumnValue(sql, inEntity);
        sql.append(")");

        return executeInsert(sql);
    }

    /**
     * <pre>
     * 更新処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（更新情報）
     * @return 更新結果件数
     * @throws CFWDuplicateKeyException プライマリーキーが重複しているときに発生
     * @throws CFWFindParameterException パラメーターが不正な時に発生
     */
    @Override
    public int update(ReporthistoryEntity inEntity) throws CFWFindParameterException,
            CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("UPDATE");
        sql.append(" ReportHistory ");
        sql.append("SET ");
        setUpdateColumnValue(sql, inEntity);

        sql.where(" ID_History = ?", inEntity.getValue("ID_History"));

        return executeUpdate(sql);
    }

    /**
     * <pre>
     * 削除処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（削除情報）
     * @return 削除結果件数
     * @throws CFWFindParameterException パラメーターが不正な時に発生
     */
    @Override
    public int delete(ReporthistoryEntity inEntity) throws CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("DELETE FROM ReportHistory ");

        sql.where(" ID_History = ?", inEntity.getValue("ID_History"));

        return executeDelete(sql);
    }

}