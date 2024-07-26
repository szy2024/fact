//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02ReporthistoryDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.dao;

import java.util.List;

/**
 * <pre>
 * Md004_02ReporthistoryDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md004_02ReporthistoryDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md004_02ReporthistoryEntity
     * @return long
     */
    long countByCondition(Md004_02ReporthistoryEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md004_02ReporthistoryEntity
     * @return List&lt;Md004_02ReporthistoryEntity&gt;
     */
    List<Md004_02ReporthistoryEntity> findByCondition(Md004_02ReporthistoryEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md004_02ReporthistoryEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_02ReporthistoryEntity&gt;
     */
    List<Md004_02ReporthistoryEntity> findByCondition(Md004_02ReporthistoryEntity inEntity,
            int offset, int length);

}