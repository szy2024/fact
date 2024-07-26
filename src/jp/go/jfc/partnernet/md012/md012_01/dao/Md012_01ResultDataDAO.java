//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md012_01ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md012.md012_01.dao;

import java.util.List;

/**
 * <pre>
 * Md012_01ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public interface Md012_01ResultDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity
     *            Md012_01ResultDataEntity
     * @return long
     */
    long countByCondition(Md012_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity
     *            Md012_01ResultDataEntity
     * @return List&lt;Md012_01ResultDataEntity&gt;
     */
    List<Md012_01ResultDataEntity> findByCondition(Md012_01ResultDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity
     *            Md012_01ResultDataEntity
     * @param offset
     *            取得開始位置
     * @param length
     *            取得開始位置からの取得件数
     * @return List&lt;Md012_01ResultDataEntity&gt;
     */
    List<Md012_01ResultDataEntity> findByCondition(Md012_01ResultDataEntity inEntity, int offset, int length);

}