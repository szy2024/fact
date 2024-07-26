//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se011_01ResultsKariKeisanDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se011.se011_01.dao;

import java.util.List;

/**
 * <pre>
 * Se011_01ResultsKariKeisanDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se011_01ResultsKariKeisanDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se011_01ResultsKariKeisanDataEntity
     * @return long
     */
    long countByCondition(Se011_01ResultsKariKeisanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se011_01ResultsKariKeisanDataEntity
     * @return List&lt;Se011_01ResultsKariKeisanDataEntity&gt;
     */
    List<Se011_01ResultsKariKeisanDataEntity> findByCondition(Se011_01ResultsKariKeisanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se011_01ResultsKariKeisanDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se011_01ResultsKariKeisanDataEntity&gt;
     */
    List<Se011_01ResultsKariKeisanDataEntity> findByCondition(Se011_01ResultsKariKeisanDataEntity inEntity,
            int offset, int length);

}