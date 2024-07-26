//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01GetResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.dao;

import java.util.List;

/**
 * <pre>
 * Se005_01GetResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se005_01ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @return long
     */
    long countByCondition(Se005_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @return List&lt;Se005_01GetResultDataEntity&gt;
     */
    List<Se005_01ResultDataEntity> findByCondition(Se005_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se005_01GetResultDataEntity&gt;
     */
    List<Se005_01ResultDataEntity> findByCondition(Se005_01ResultDataEntity inEntity,
            int offset, int length);

}