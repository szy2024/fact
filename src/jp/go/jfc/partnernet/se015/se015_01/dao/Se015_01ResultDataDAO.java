//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se015_01ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/24 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se015.se015_01.dao;

import java.util.List;

/**
 * <pre>
 * Se015_01ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public interface Se015_01ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se015_01ResultDataEntity
     * @return long
     */
    long countByCondition(Se015_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se015_01ResultDataEntity
     * @return List&lt;Se015_01ResultDataEntity&gt;
     */
    List<Se015_01ResultDataEntity> findByCondition(Se015_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se015_01ResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se015_01ResultDataEntity&gt;
     */
    List<Se015_01ResultDataEntity> findByCondition(Se015_01ResultDataEntity inEntity,
            int offset, int length);

}