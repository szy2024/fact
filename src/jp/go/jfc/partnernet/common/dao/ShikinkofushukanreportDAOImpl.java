//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Shikinkofushukanreport
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
 * 資金交付依頼書（週間）報告書データの単テーブルDAO実装クラスです。
 * データーベースアクセス各種機能
 * （検索／追加／更新／削除機能）
 * を提供します。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class ShikinkofushukanreportDAOImpl extends PNSingleTableDAO<ShikinkofushukanreportEntity>
        implements ShikinkofushukanreportDAO {

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
    public ShikinkofushukanreportEntity findByPrimaryKey(ShikinkofushukanreportEntity inEntity) throws
            CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" UserID,");
        sql.append(" ID_Denso,");
        sql.append(" DataCode,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Date_Kofu,");
        sql.append(" M_Yotei,");
        sql.append(" M_Ganju_GaiSu,");
        sql.append(" M_ZanMikomi,");
        sql.append(" M_Biko,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ShikinkofuShukanReport ");

        sql.where(" ID_Report = ?", inEntity.getValue("ID_Report"));

        return executeSingleResult(sql, ShikinkofushukanreportEntity.class);
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
    public List<ShikinkofushukanreportEntity> findByCondition(ShikinkofushukanreportEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" UserID,");
        sql.append(" ID_Denso,");
        sql.append(" DataCode,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Date_Kofu,");
        sql.append(" M_Yotei,");
        sql.append(" M_Ganju_GaiSu,");
        sql.append(" M_ZanMikomi,");
        sql.append(" M_Biko,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ShikinkofuShukanReport ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, ShikinkofushukanreportEntity.class);
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
    public List<ShikinkofushukanreportEntity> findByCondition(ShikinkofushukanreportEntity inEntity,
            int offset, int length) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" UserID,");
        sql.append(" ID_Denso,");
        sql.append(" DataCode,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Date_Kofu,");
        sql.append(" M_Yotei,");
        sql.append(" M_Ganju_GaiSu,");
        sql.append(" M_ZanMikomi,");
        sql.append(" M_Biko,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ShikinkofuShukanReport ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, ShikinkofushukanreportEntity.class, offset, length);
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
    public long countByCondition(ShikinkofushukanreportEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" COUNT(1) ");
        sql.append("FROM");
        sql.append(" ShikinkofuShukanReport ");

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
    public ShikinkofushukanreportEntity findByPrimaryKeyForUpdate(ShikinkofushukanreportEntity inEntity) throws
            CFWFindParameterException, CFWForUpdateException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" ID_Report,");
        sql.append(" Date_Report,");
        sql.append(" Time_Report,");
        sql.append(" UserID,");
        sql.append(" ID_Denso,");
        sql.append(" DataCode,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Date_Kofu,");
        sql.append(" M_Yotei,");
        sql.append(" M_Ganju_GaiSu,");
        sql.append(" M_ZanMikomi,");
        sql.append(" M_Biko,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" ShikinkofuShukanReport ");

        sql.where(" ID_Report = ?", inEntity.getValue("ID_Report"));

        sql.append("FOR UPDATE NOWAIT");
        return executeSingleResultForUpdate(sql, ShikinkofushukanreportEntity.class);
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
    public int insert(ShikinkofushukanreportEntity inEntity) throws CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("INSERT INTO ShikinkofuShukanReport ");
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
    public int update(ShikinkofushukanreportEntity inEntity) throws CFWFindParameterException,
            CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("UPDATE");
        sql.append(" ShikinkofuShukanReport ");
        sql.append("SET ");
        setUpdateColumnValue(sql, inEntity);

        sql.where(" ID_Report = ?", inEntity.getValue("ID_Report"));

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
    public int delete(ShikinkofushukanreportEntity inEntity) throws CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("DELETE FROM ShikinkofuShukanReport ");

        sql.where(" ID_Report = ?", inEntity.getValue("ID_Report"));

        return executeDelete(sql);
    }

}