//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02SeikyuData3DAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.dao;

import java.util.List;

/**
 * <pre>
 * Cr003_02SeikyuData3DAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr003_02SeikyuData3DAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr003_02SeikyuData3Entity
     * @return long
     */
    long countByCondition(Cr003_02SeikyuData3Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr003_02SeikyuData3Entity
     * @return List&lt;Cr003_02SeikyuData3Entity&gt;
     */
    List<Cr003_02SeikyuData3Entity> findByCondition(Cr003_02SeikyuData3Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr003_02SeikyuData3Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr003_02SeikyuData3Entity&gt;
     */
    List<Cr003_02SeikyuData3Entity> findByCondition(Cr003_02SeikyuData3Entity inEntity,
            int offset, int length);

}