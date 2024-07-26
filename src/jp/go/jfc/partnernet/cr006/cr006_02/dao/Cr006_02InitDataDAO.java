//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02InitDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.dao;

import java.util.List;

/**
 * <pre>
 * Cr006_02InitDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr006_02InitDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr006_02InitDataEntity
     * @return long
     */
    long countByCondition(Cr006_02InitDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr006_02InitDataEntity
     * @return List&lt;Cr006_02InitDataEntity&gt;
     */
    List<Cr006_02InitDataEntity> findByCondition(Cr006_02InitDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr006_02InitDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_02InitDataEntity&gt;
     */
    List<Cr006_02InitDataEntity> findByCondition(Cr006_02InitDataEntity inEntity,
            int offset, int length);

}