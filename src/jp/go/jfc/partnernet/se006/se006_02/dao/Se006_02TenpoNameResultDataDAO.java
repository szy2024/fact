//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02TenpoNameResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/22 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.dao;

import java.util.List;

/**
 * <pre>
 * Se006_02TenpoNameResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public interface Se006_02TenpoNameResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @return long
     */
    long countByCondition(Se006_02TenpoNameResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @return List&lt;Se006_02TenpoNameResultDataEntity&gt;
     */
    List<Se006_02TenpoNameResultDataEntity> findByCondition(Se006_02TenpoNameResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se006_02TenpoNameResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se006_02TenpoNameResultDataEntity&gt;
     */
    List<Se006_02TenpoNameResultDataEntity> findByCondition(Se006_02TenpoNameResultDataEntity inEntity,
            int offset, int length);

}