//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PnUser
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 後　和男              | 新規作成
// 2.0.0   | 2017/11/13 | 林　晃平              | H29年追加開発案件対応
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
 * 利用者データの単テーブルDAO実装クラスです。
 * データーベースアクセス各種機能
 * （検索／追加／更新／削除機能）
 * を提供します。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class PnUserDAOImpl extends PNSingleTableDAO<PnUserEntity> implements PnUserDAO {

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
    public PnUserEntity findByPrimaryKey(PnUserEntity inEntity) throws
            CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" LogonID,");
        sql.append(" Name_Kanji,");
        sql.append(" Name_Kana,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Password,");
        sql.append(" RoleCode,");
        sql.append(" Date_UseStart,");
        sql.append(" Flag_ForceChgPwdFistLogon,");
        sql.append(" Flag_ForceChgPwdRoutine,");
        sql.append(" Flag_FirstLogon,");
        sql.append(" Num_PwdValidDays,");
        sql.append(" Num_PwdRetryCntMax,");
        sql.append(" Num_PwdRetryCnt,");
        sql.append(" DateTime_LastChgPwd,");
        sql.append(" DateTime_LastLogon,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" PN_User ");

        sql.where(" LogonID = ?", inEntity.getValue("LogonID"));

        return executeSingleResult(sql, PnUserEntity.class);
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
    public List<PnUserEntity> findByCondition(PnUserEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" LogonID,");
        sql.append(" Name_Kanji,");
        sql.append(" Name_Kana,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Password,");
        sql.append(" RoleCode,");
        sql.append(" Date_UseStart,");
        sql.append(" Flag_ForceChgPwdFistLogon,");
        sql.append(" Flag_ForceChgPwdRoutine,");
        sql.append(" Flag_FirstLogon,");
        sql.append(" Num_PwdValidDays,");
        sql.append(" Num_PwdRetryCntMax,");
        sql.append(" Num_PwdRetryCnt,");
        sql.append(" DateTime_LastChgPwd,");
        sql.append(" DateTime_LastLogon,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" PN_User ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, PnUserEntity.class);
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
    public List<PnUserEntity> findByCondition(PnUserEntity inEntity, int offset, int length) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" LogonID,");
        sql.append(" Name_Kanji,");
        sql.append(" Name_Kana,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Password,");
        sql.append(" RoleCode,");
        sql.append(" Date_UseStart,");
        sql.append(" Flag_ForceChgPwdFistLogon,");
        sql.append(" Flag_ForceChgPwdRoutine,");
        sql.append(" Flag_FirstLogon,");
        sql.append(" Num_PwdValidDays,");
        sql.append(" Num_PwdRetryCntMax,");
        sql.append(" Num_PwdRetryCnt,");
        sql.append(" DateTime_LastChgPwd,");
        sql.append(" DateTime_LastLogon,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" PN_User ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, PnUserEntity.class, offset, length);
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
    public long countByCondition(PnUserEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" COUNT(1) ");
        sql.append("FROM");
        sql.append(" PN_User ");

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
    public PnUserEntity findByPrimaryKeyForUpdate(PnUserEntity inEntity) throws
            CFWFindParameterException, CFWForUpdateException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" LogonID,");
        sql.append(" Name_Kanji,");
        sql.append(" Name_Kana,");
        sql.append(" Code_Organization,");
        sql.append(" Code_Tenpo,");
        sql.append(" Password,");
        sql.append(" RoleCode,");
        sql.append(" Date_UseStart,");
        sql.append(" Flag_ForceChgPwdFistLogon,");
        sql.append(" Flag_ForceChgPwdRoutine,");
        sql.append(" Flag_FirstLogon,");
        sql.append(" Num_PwdValidDays,");
        sql.append(" Num_PwdRetryCntMax,");
        sql.append(" Num_PwdRetryCnt,");
        sql.append(" DateTime_LastChgPwd,");
        sql.append(" DateTime_LastLogon,");
        sql.append(" DateTime_Create,");
        sql.append(" ID_Create,");
        sql.append(" DateTime_Update,");
        sql.append(" ID_Update ");

        sql.append("FROM");
        sql.append(" PN_User ");

        sql.where(" LogonID = ?", inEntity.getValue("LogonID"));

        sql.append("FOR UPDATE NOWAIT");
        return executeSingleResultForUpdate(sql, PnUserEntity.class);
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
    public int insert(PnUserEntity inEntity) throws CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("INSERT INTO PN_User ");
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
    public int update(PnUserEntity inEntity) throws CFWFindParameterException,
            CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("UPDATE");
        sql.append(" PN_User ");
        sql.append("SET ");
        setUpdateColumnValue(sql, inEntity);

        sql.where(" LogonID = ?", inEntity.getValue("LogonID"));

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
    public int delete(PnUserEntity inEntity) throws CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("DELETE FROM PN_User ");

        sql.where(" LogonID = ?", inEntity.getValue("LogonID"));

        return executeDelete(sql);
    }

}