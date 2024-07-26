//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_02ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_02.dao;

import java.util.List;

/**
 * <pre>
 * Se004_02ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se004_02ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @return long
     */
    long countByCondition(Se004_02ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @return List&lt;Se004_02GetResultDataEntity&gt;
     */
    List<Se004_02ResultDataEntity> findByCondition(Se004_02ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se004_02GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se004_02GetResultDataEntity&gt;
     */
    List<Se004_02ResultDataEntity> findByCondition(Se004_02ResultDataEntity inEntity, int offset, int length);

}