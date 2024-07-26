//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se014_01KofuDateListDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.dao;

import java.util.List;

/**
 * <pre>
 * Se014_01KofuDateListDAOインタフェースです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public interface Se014_01KofuDateListDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se014_01KofuDateListEntity
     * @return long
     */
    long countByCondition(Se014_01KofuDateListEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se014_01KofuDateListEntity
     * @return List&lt;Se014_01KofuDateListEntity&gt;
     */
    List<Se014_01KofuDateListEntity> findByCondition(Se014_01KofuDateListEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se014_01KofuDateListEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se014_01KofuDateListEntity&gt;
     */
    List<Se014_01KofuDateListEntity> findByCondition(Se014_01KofuDateListEntity inEntity,
            int offset, int length);

}