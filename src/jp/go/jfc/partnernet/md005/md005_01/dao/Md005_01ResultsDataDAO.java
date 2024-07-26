//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_01ResultsDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/30 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_01.dao;

import java.util.List;

/**
 * <pre>
 * Md005_01ResultsDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md005_01ResultsDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md005_01ResultsDataEntity
     * @return long
     */
    long countByCondition(Md005_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md005_01ResultsDataEntity
     * @return List&lt;Md005_01ResultsDataEntity&gt;
     */
    List<Md005_01ResultsDataEntity> findByCondition(Md005_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md005_01ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md005_01ResultsDataEntity&gt;
     */
    List<Md005_01ResultsDataEntity> findByCondition(Md005_01ResultsDataEntity inEntity,
            int offset, int length);

}