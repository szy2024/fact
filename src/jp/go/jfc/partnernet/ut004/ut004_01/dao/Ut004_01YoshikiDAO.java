//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut004_01YoshikiDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut004.ut004_01.dao;

import java.util.List;

/**
 * <pre>
 * Ut004_01YoshikiDAOインタフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut004_01YoshikiDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Ut004_01YoshikiEntity
     * @return long
     */
    long countByCondition(Ut004_01YoshikiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Ut004_01YoshikiEntity
     * @return List&lt;Ut004_01YoshikiEntity&gt;
     */
    List<Ut004_01YoshikiEntity> findByCondition(Ut004_01YoshikiEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Ut004_01YoshikiEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut004_01YoshikiEntity&gt;
     */
    List<Ut004_01YoshikiEntity> findByCondition(Ut004_01YoshikiEntity inEntity, int offset, int length);

}