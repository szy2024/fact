//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_01ResultsDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr009_01ResultsDataDAOインタフェースです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public interface Cr009_01ResultsDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr009_01ResultsDataEntity
     * @return long
     */
    long countByCondition(Cr009_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr009_01ResultsDataEntity
     * @return List&lt;Cr009_01ResultsDataEntity&gt;
     */
    List<Cr009_01ResultsDataEntity> findByCondition(Cr009_01ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr009_01ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr009_01ResultsDataEntity&gt;
     */
    List<Cr009_01ResultsDataEntity> findByCondition(Cr009_01ResultsDataEntity inEntity,
            int offset, int length);

}