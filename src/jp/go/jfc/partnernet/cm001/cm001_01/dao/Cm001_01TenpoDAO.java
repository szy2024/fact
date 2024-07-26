//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_01TenpoDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_01.dao;

import java.util.List;

/**
 * <pre>
 * Cm001_01TenpoDAOインタフェースです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
public interface Cm001_01TenpoDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cm001_01TenpoEntity
     * @return long
     */
    long countByCondition(Cm001_01TenpoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cm001_01TenpoEntity
     * @return List&lt;Cm001_01TenpoEntity&gt;
     */
    List<Cm001_01TenpoEntity> findByCondition(Cm001_01TenpoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cm001_01TenpoEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cm001_01TenpoEntity&gt;
     */
    List<Cm001_01TenpoEntity> findByCondition(Cm001_01TenpoEntity inEntity,
            int offset, int length);

}