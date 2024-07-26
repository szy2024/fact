//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_04GetResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_04.dao;

import java.util.List;

/**
 * <pre>
 * Ut003_04GetResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut003_04GetResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Ut003_04GetResultDataEntity
     * @return long
     */
    long countByCondition(Ut003_04GetResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Ut003_04GetResultDataEntity
     * @return List&lt;Ut003_04GetResultDataEntity&gt;
     */
    List<Ut003_04GetResultDataEntity> findByCondition(Ut003_04GetResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Ut003_04GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut003_04GetResultDataEntity&gt;
     */
    List<Ut003_04GetResultDataEntity> findByCondition(Ut003_04GetResultDataEntity inEntity,
            int offset, int length);

}