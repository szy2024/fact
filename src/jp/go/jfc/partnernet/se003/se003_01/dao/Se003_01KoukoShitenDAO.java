//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_01GetKoukoShitenDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_01.dao;

import java.util.List;

/**
 * <pre>
 * Se003_01GetKoukoShitenDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se003_01KoukoShitenDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se003_01GetKoukoShitenEntity
     * @return long
     */
    long countByCondition(Se003_01KoukoShitenEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se003_01GetKoukoShitenEntity
     * @return List&lt;Se003_01GetKoukoShitenEntity&gt;
     */
    List<Se003_01KoukoShitenEntity> findByCondition(Se003_01KoukoShitenEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se003_01GetKoukoShitenEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se003_01GetKoukoShitenEntity&gt;
     */
    List<Se003_01KoukoShitenEntity> findByCondition(Se003_01KoukoShitenEntity inEntity,
            int offset, int length);

}