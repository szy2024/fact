//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03AringiDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.dao;

import java.util.List;

/**
 * <pre>
 * Cr003_03AringiDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr003_03AringiDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr003_03AringiEntity
     * @return long
     */
    long countByCondition(Cr003_03AringiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr003_03AringiEntity
     * @return List&lt;Cr003_03AringiEntity&gt;
     */
    List<Cr003_03AringiEntity> findByCondition(Cr003_03AringiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr003_03AringiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr003_03AringiEntity&gt;
     */
    List<Cr003_03AringiEntity> findByCondition(Cr003_03AringiEntity inEntity,
            int offset, int length);

}