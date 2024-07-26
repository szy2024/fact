//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01KoukoShitenDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr005_01KoukoShitenDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr005_01KoukoShitenDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr005_01KoukoShitenEntity
     * @return long
     */
    long countByCondition(Cr005_01KoukoShitenEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr005_01KoukoShitenEntity
     * @return List&lt;Cr005_01KoukoShitenEntity&gt;
     */
    List<Cr005_01KoukoShitenEntity> findByCondition(Cr005_01KoukoShitenEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr005_01KoukoShitenEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr005_01KoukoShitenEntity&gt;
     */
    List<Cr005_01KoukoShitenEntity> findByCondition(Cr005_01KoukoShitenEntity inEntity,
            int offset, int length);

}