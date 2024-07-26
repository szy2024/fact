//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02ResultsKariKeisanDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.dao;

import java.util.List;

/**
 * <pre>
 * Se008_02ResultsKariKeisanDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se008_02ResultsKariKeisanDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Se008_02ResultsKariKeisanDataEntity
     * @return long
     */
    long countByCondition(Se008_02ResultsKariKeisanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Se008_02ResultsKariKeisanDataEntity
     * @return List&lt;Se008_02ResultsKariKeisanDataEntity&gt;
     */
    List<Se008_02ResultsKariKeisanDataEntity> findByCondition(Se008_02ResultsKariKeisanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Se008_02ResultsKariKeisanDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se008_02ResultsKariKeisanDataEntity&gt;
     */
    List<Se008_02ResultsKariKeisanDataEntity> findByCondition(Se008_02ResultsKariKeisanDataEntity inEntity,
            int offset, int length);

}