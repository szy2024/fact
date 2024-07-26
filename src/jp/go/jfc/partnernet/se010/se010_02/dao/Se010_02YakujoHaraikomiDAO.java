//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02YakujoHaraikomiDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.dao;

import java.util.List;

/**
 * <pre>
 * Se010_02YakujoHaraikomiDAOインタフェースです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public interface Se010_02YakujoHaraikomiDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se010_02YakujoHaraikomiEntity
     * @return long
     */
    long countByCondition(Se010_02YakujoHaraikomiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se010_02YakujoHaraikomiEntity
     * @return List&lt;Se010_02YakujoHaraikomiEntity&gt;
     */
    List<Se010_02YakujoHaraikomiEntity> findByCondition(Se010_02YakujoHaraikomiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se010_02YakujoHaraikomiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se010_02YakujoHaraikomiEntity&gt;
     */
    List<Se010_02YakujoHaraikomiEntity> findByCondition(Se010_02YakujoHaraikomiEntity inEntity, int offset,
            int length);

}