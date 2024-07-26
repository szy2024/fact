//==================================================================================================
// $Id: $
// Project Name :
// System Name  : サンプルソース
// Class Name   : M001UserInfoTblDAO.java
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2010/10/05 | 富士通)安納  理裕     | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

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
public interface M001UserInfoTblDAO {

    /**
     * <pre>
     * プライマリキー検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（１件）
     * @throws CFWFindParameterException CFWFindParameterException
     */
    M001UserInfoTblEntity findByPrimaryKey(M001UserInfoTblEntity inEntity) throws CFWFindParameterException;

    /**
     * <pre>
     * 条件検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（複数件）
     */
    List<M001UserInfoTblEntity> findByCondition(M001UserInfoTblEntity inEntity);

    /**
     * <pre>
     * 条件検索を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（検索条件）
     * @return 検索結果（ヒット件数）
     */
    long countByCondition(M001UserInfoTblEntity inEntity);

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
    M001UserInfoTblEntity findByPrimaryKeyForUpdate(M001UserInfoTblEntity inEntity) throws
        CFWFindParameterException, CFWForUpdateException;

    /**
     * <pre>
     * 登録処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（登録情報）
     * @return 登録結果件数
     * @throws CFWDuplicateKeyException CFWDuplicateKeyException
     */
    int insert(M001UserInfoTblEntity inEntity) throws CFWDuplicateKeyException;

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
    int update(M001UserInfoTblEntity inEntity) throws CFWFindParameterException, CFWDuplicateKeyException;

    /**
     * <pre>
     * 削除処理を実行します.
     * </pre>
     *
     * @param inEntity 上りEntity（削除情報）
     * @return 削除結果件数
     * @throws CFWFindParameterException CFWFindParameterException
     */
    int delete(M001UserInfoTblEntity inEntity) throws CFWFindParameterException;
}
