//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03getResuluDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.dao;

import java.util.List;

/**
 * <pre>
 * Se001_03getResuluDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se001_03ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se001_03getResultDataEntity
     * @return long
     */
    long countByCondition(Se001_03ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se001_03getResultDataEntity
     * @return List&lt;Se001_03getResultDataEntity&gt;
     */
    List<Se001_03ResultDataEntity> findByCondition(Se001_03ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se001_03getResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se001_03getResultDataEntity&gt;
     */
    List<Se001_03ResultDataEntity> findByCondition(Se001_03ResultDataEntity inEntity,
            int offset, int length);

}