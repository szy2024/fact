//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01KinriHenkanDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr001_01KinriHenkanDataDAOインタフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Cr001_01KinriHenkanDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr001_01KinriHenkanDataEntity
     * @return long
     */
    long countByCondition(Cr001_01KinriHenkanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr001_01KinriHenkanDataEntity
     * @return List&lt;Cr001_01KinriHenkanDataEntity&gt;
     */
    List<Cr001_01KinriHenkanDataEntity> findByCondition(Cr001_01KinriHenkanDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr001_01KinriHenkanDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr001_01KinriHenkanDataEntity&gt;
     */
    List<Cr001_01KinriHenkanDataEntity> findByCondition(Cr001_01KinriHenkanDataEntity inEntity,
            int offset, int length);

}