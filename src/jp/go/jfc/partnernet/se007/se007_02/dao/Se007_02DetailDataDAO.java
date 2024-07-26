//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_02DetailDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_02.dao;

import java.util.List;

/**
 * <pre>
 * Se007_02DetailDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se007_02DetailDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se007_02DetailDataEntity
     * @return long
     */
    long countByCondition(Se007_02DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se007_02DetailDataEntity
     * @return List&lt;Se007_02DetailDataEntity&gt;
     */
    List<Se007_02DetailDataEntity> findByCondition(Se007_02DetailDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se007_02DetailDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se007_02DetailDataEntity&gt;
     */
    List<Se007_02DetailDataEntity> findByCondition(Se007_02DetailDataEntity inEntity,
            int offset, int length);

}