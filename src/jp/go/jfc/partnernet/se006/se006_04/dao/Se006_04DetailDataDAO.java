//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_04DetailDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/01 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_04.dao;

import java.util.List;

/**
 * <pre>
 * Se006_04DetailDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_04DetailDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se006_04DetailDataEntity
     * @return long
     */
    long countByCondition(Se006_04DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se006_04DetailDataEntity
     * @return List&lt;Se006_04DetailDataEntity&gt;
     */
    List<Se006_04DetailDataEntity> findByCondition(Se006_04DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se006_04DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_04DetailDataEntity&gt;
     */
    List<Se006_04DetailDataEntity> findByCondition(Se006_04DetailDataEntity inEntity,
            int offset, int length);

}