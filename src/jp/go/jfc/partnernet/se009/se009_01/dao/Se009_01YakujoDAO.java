//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01YakujoDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import java.util.List;

/**
 * <pre>
 * Se009_01YakujoDAOインタフェースです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public interface Se009_01YakujoDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se009_01YakujoEntity
     * @return long
     */
    long countByCondition(Se009_01YakujoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se009_01YakujoEntity
     * @return List&lt;Se009_01YakujoEntity&gt;
     */
    List<Se009_01YakujoEntity> findByCondition(Se009_01YakujoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se009_01YakujoEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se009_01YakujoEntity&gt;
     */
    List<Se009_01YakujoEntity> findByCondition(Se009_01YakujoEntity inEntity,
            int offset, int length);

}