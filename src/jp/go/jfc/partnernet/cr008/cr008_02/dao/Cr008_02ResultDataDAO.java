//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_02ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_02.dao;

import java.util.List;

/**
 * <pre>
 * Cr008_02ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_02ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr008_02ResultDataEntity
     * @return long
     */
    long countByCondition(Cr008_02ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr008_02ResultDataEntity
     * @return List&lt;Cr008_02ResultDataEntity&gt;
     */
    List<Cr008_02ResultDataEntity> findByCondition(Cr008_02ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr008_02ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr008_02ResultDataEntity&gt;
     */
    List<Cr008_02ResultDataEntity> findByCondition(Cr008_02ResultDataEntity inEntity,
            int offset, int length);

}