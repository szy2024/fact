//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_13DetailDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_13.dao;

import java.util.List;

/**
 * <pre>
 * Se006_13DetailDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_13DetailDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se006_13DetailDataEntity
     * @return long
     */
    long countByCondition(Se006_13DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se006_13DetailDataEntity
     * @return List&lt;Se006_13DetailDataEntity&gt;
     */
    List<Se006_13DetailDataEntity> findByCondition(Se006_13DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se006_13DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_13DetailDataEntity&gt;
     */
    List<Se006_13DetailDataEntity> findByCondition(Se006_13DetailDataEntity inEntity,
            int offset, int length);

}