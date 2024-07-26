//==================================================================================================
// $Id: $
// Project Name :
// System Name  : サンプルソース
// Class Name   : M001UserInfoTblDAOImpl.java
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2010/10/05 | 富士通)安納  理裕     | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNSingleTableDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * ユーザ情報テーブルの単テーブルDAOです。
 * </pre>
 *
 * @author 富士通)
 * @version 1.0.0
 */
public class M001UserInfoTblDAOImpl extends PNSingleTableDAO<M001UserInfoTblEntity> implements
        M001UserInfoTblDAO {

    /**
     * <pre>
     * プライマリキー検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（１件）
     * @throws CFWFindParameterException CFWFindParameterException
     */
    @Override
    public M001UserInfoTblEntity findByPrimaryKey(M001UserInfoTblEntity inEntity)
            throws CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" USER_ID,");
        sql.append(" PASSWORD,");
        sql.append(" USER_NAME,");
        sql.append(" COMPANY_NAME,");
        sql.append(" CREATE_ID,");
        sql.append(" CREATE_DATE,");
        sql.append(" UPDATE_ID,");
        sql.append(" UPDATE_DATE ");

        sql.append("FROM");
        sql.append(" USER_INFO_TBL ");

        sql.where(" USER_ID = ?", inEntity.getValue("USER_ID"));

        return executeSingleResult(sql, M001UserInfoTblEntity.class);
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
    public List<M001UserInfoTblEntity> findByCondition(M001UserInfoTblEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" USER_ID,");
        sql.append(" PASSWORD,");
        sql.append(" USER_NAME,");
        sql.append(" COMPANY_NAME,");
        sql.append(" CREATE_ID,");
        sql.append(" CREATE_DATE,");
        sql.append(" UPDATE_ID,");
        sql.append(" UPDATE_DATE ");

        sql.append("FROM");
        sql.append(" USER_INFO_TBL ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return executeListResult(sql, M001UserInfoTblEntity.class);
    }

    /**
     * <pre>
     * 条件検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（ヒット件数）
     */
    @Override
    public long countByCondition(M001UserInfoTblEntity inEntity) {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" COUNT(*) ");

        sql.append("FROM");
        sql.append(" USER_INFO_TBL ");

        setSelectCondition(sql, inEntity);

        sql.orderBy(inEntity.getSortInfo());

        return ((Integer) executeScaleResult(sql)).longValue();
    }

    /**
     * <pre>
     * プライマリキー検索を実行します(FOR UPDATE付).
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（１件）
     * @throws CFWFindParameterException CFWFindParameterException
     * @throws CFWForUpdateException CFWForUpdateException
     */
    @Override
    public M001UserInfoTblEntity findByPrimaryKeyForUpdate(M001UserInfoTblEntity inEntity)
            throws CFWFindParameterException, CFWForUpdateException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("SELECT");
        sql.append(" USER_ID,");
        sql.append(" PASSWORD,");
        sql.append(" USER_NAME,");
        sql.append(" COMPANY_NAME,");
        sql.append(" CREATE_ID,");
        sql.append(" CREATE_DATE,");
        sql.append(" UPDATE_ID,");
        sql.append(" UPDATE_DATE ");

        sql.append("FROM");
        sql.append(" USER_INFO_TBL ");

        sql.where(" USER_ID = ?", inEntity.getValue("USER_ID"));

        sql.append("FOR UPDATE");

        return executeSingleResultForUpdate(sql, M001UserInfoTblEntity.class);
    }

    /**
     * <pre>
     * 登録処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（登録情報）
     * @return 登録結果件数
     * @throws CFWDuplicateKeyException CFWDuplicateKeyException
     */
    @Override
    public int insert(M001UserInfoTblEntity inEntity) throws CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("INSERT INTO USER_INFO_TBL ");
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
     * @throws CFWDuplicateKeyException CFWDuplicateKeyException
     * @throws CFWFindParameterException CFWFindParameterException
     */
    @Override
    public int update(M001UserInfoTblEntity inEntity) throws CFWFindParameterException,
            CFWDuplicateKeyException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("UPDATE");
        sql.append(" USER_INFO_TBL ");
        sql.append("SET ");
        setUpdateColumnValue(sql, inEntity);

        sql.where(" USER_ID = ?", inEntity.getValue("USER_ID"));

        return executeUpdate(sql);
    }

    /**
     * <pre>
     * 削除処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（削除情報）
     * @return 削除結果件数
     * @throws CFWFindParameterException CFWFindParameterException
     */
    @Override
    public int delete(M001UserInfoTblEntity inEntity) throws CFWFindParameterException {

        PNSqlBuilder sql = new PNSqlBuilder();
        sql.append("DELETE FROM USER_INFO_TBL ");

        sql.where(" USER_ID = ?", inEntity.getValue("USER_ID"));

        return executeDelete(sql);
    }

}
