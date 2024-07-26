//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr010_01TenpoNameResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr010_01TenpoNameResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Cr010_01TenpoNameResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @return long
     */
    long countByCondition(Cr010_01TenpoNameResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @return List&lt;Cr010_01TenpoNameResultDataEntity&gt;
     */
    List<Cr010_01TenpoNameResultDataEntity> findByCondition(Cr010_01TenpoNameResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr010_01TenpoNameResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr010_01TenpoNameResultDataEntity&gt;
     */
    List<Cr010_01TenpoNameResultDataEntity> findByCondition(Cr010_01TenpoNameResultDataEntity inEntity,
            int offset, int length);

}