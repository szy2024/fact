//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01SeikyuDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import java.util.List;

/**
 * <pre>
 * Se010_01SeikyuDAOインタフェースです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public interface Se010_01SeikyuDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se010_01SeikyuEntity
     * @return long
     */
    long countByCondition(Se010_01SeikyuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se010_01SeikyuEntity
     * @return List&lt;Se010_01SeikyuEntity&gt;
     */
    List<Se010_01SeikyuEntity> findByCondition(Se010_01SeikyuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se010_01SeikyuEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se010_01SeikyuEntity&gt;
     */
    List<Se010_01SeikyuEntity> findByCondition(Se010_01SeikyuEntity inEntity,
            int offset, int length);

}