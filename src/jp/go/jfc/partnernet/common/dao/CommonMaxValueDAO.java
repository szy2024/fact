//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : CommonMaxValueDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/18 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * CommonMaxValueDAOインタフェースです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public interface CommonMaxValueDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity CommonMaxValueEntity
     * @return long
     */
    long countByCondition(CommonMaxValueEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity CommonMaxValueEntity
     * @return List&lt;CommonMaxValueEntity&gt;
     */
    List<CommonMaxValueEntity> findByCondition(CommonMaxValueEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity CommonMaxValueEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;CommonMaxValueEntity&gt;
     */
    List<CommonMaxValueEntity> findByCondition(CommonMaxValueEntity inEntity, int offset, int length);

    /**
     * <pre>
     * 最大値を取得する為、決算日テーブルをロックします。
     * </pre>
     */
    CommonMaxValueEntity findKessanbiForUpdate(CommonMaxValueEntity inEntity)
            throws CFWFindParameterException, CFWForUpdateException;

}