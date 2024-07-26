//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01ReportDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr006_01ReportDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Cr006_01ReportDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr006_01ReportDataEntity
     * @return long
     */
    long countByCondition(Cr006_01ReportDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr006_01ReportDataEntity
     * @return List&lt;Cr006_01ReportDataEntity&gt;
     */
    List<Cr006_01ReportDataEntity> findByCondition(Cr006_01ReportDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr006_01ReportDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_01ReportDataEntity&gt;
     */
    List<Cr006_01ReportDataEntity> findByCondition(Cr006_01ReportDataEntity inEntity, int offset, int length);

}