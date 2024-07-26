//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01ResultsDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.dao;

import java.util.List;

/**
 * <pre>
 * Se013_01ResultsDataDAOインタフェースです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public interface Se013_01ResultsDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se013_01ResultsDataEntity
     * @return long
     */
    long countByCondition(Se013_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se013_01ResultsDataEntity
     * @return List&lt;Se013_01ResultsDataEntity&gt;
     */
    List<Se013_01ResultsDataEntity> findByCondition(Se013_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se013_01ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se013_01ResultsDataEntity&gt;
     */
    List<Se013_01ResultsDataEntity> findByCondition(Se013_01ResultsDataEntity inEntity,
            int offset, int length);

}