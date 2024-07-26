//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04ResultReportDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.dao;

import java.util.List;

/**
 * <pre>
 * Cr005_04ResultReportDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr005_04ResultReportDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr005_04ResultReportEntity
     * @return long
     */
    long countByCondition(Cr005_04ResultReportEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr005_04ResultReportEntity
     * @return List&lt;Cr005_04ResultReportEntity&gt;
     */
    List<Cr005_04ResultReportEntity> findByCondition(Cr005_04ResultReportEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr005_04ResultReportEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr005_04ResultReportEntity&gt;
     */
    List<Cr005_04ResultReportEntity> findByCondition(Cr005_04ResultReportEntity inEntity,
            int offset, int length);

}