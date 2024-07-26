//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md000_02ResultsDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md000.md000_02.dao;

import java.util.List;

/**
 * <pre>
 * Md000_02ResultsDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Md000_02ResultsDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @return long
     */
    long countByCondition(Md000_02ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @return List&lt;Md000_02ResultsDataEntity&gt;
     */
    List<Md000_02ResultsDataEntity> findByCondition(Md000_02ResultsDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md000_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md000_02ResultsDataEntity&gt;
     */
    List<Md000_02ResultsDataEntity> findByCondition(Md000_02ResultsDataEntity inEntity,
            int offset, int length);

}