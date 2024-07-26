//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr011_01ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr011_01ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Cr011_01ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr011_01ResultDataEntity
     * @return long
     */
    long countByCondition(Cr011_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr011_01ResultDataEntity
     * @return List&lt;Cr011_01ResultDataEntity&gt;
     */
    List<Cr011_01ResultDataEntity> findByCondition(Cr011_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr011_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr011_01ResultDataEntity&gt;
     */
    List<Cr011_01ResultDataEntity> findByCondition(Cr011_01ResultDataEntity inEntity,
            int offset, int length);

}