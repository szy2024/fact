//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02GetNyukinHistoryDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.dao;

import java.util.List;

/**
 * <pre>
 * Se003_02GetNyukinHistoryDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se003_02NyukinHistoryDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se003_02GetNyukinHistoryDataEntity
     * @return long
     */
    long countByCondition(Se003_02NyukinHistoryDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se003_02GetNyukinHistoryDataEntity
     * @return List&lt;Se003_02GetNyukinHistoryDataEntity&gt;
     */
    List<Se003_02NyukinHistoryDataEntity> findByCondition(Se003_02NyukinHistoryDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se003_02GetNyukinHistoryDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se003_02GetNyukinHistoryDataEntity&gt;
     */
    List<Se003_02NyukinHistoryDataEntity> findByCondition(Se003_02NyukinHistoryDataEntity inEntity,
            int offset, int length);

}