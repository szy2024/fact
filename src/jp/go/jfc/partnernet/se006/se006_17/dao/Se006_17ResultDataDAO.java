//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_17ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_17.dao;

import java.util.List;

/**
 * <pre>
 * Se006_17ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public interface Se006_17ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se006_17ResultDataEntity
     * @return long
     */
    long countByCondition(Se006_17ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se006_17ResultDataEntity
     * @return List&lt;Se006_17ResultDataEntity&gt;
     */
    List<Se006_17ResultDataEntity> findByCondition(Se006_17ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se006_17ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_17ResultDataEntity&gt;
     */
    List<Se006_17ResultDataEntity> findByCondition(Se006_17ResultDataEntity inEntity,
            int offset, int length);

}