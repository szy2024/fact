//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01YakujoData3DAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.dao;

import java.util.List;

/**
 * <pre>
 * Cr002_01YakujoData3DAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr002_01YakujoData3DAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr002_01YakujoData3Entity
     * @return long
     */
    long countByCondition(Cr002_01YakujoData3Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr002_01YakujoData3Entity
     * @return List&lt;Cr002_01YakujoData3Entity&gt;
     */
    List<Cr002_01YakujoData3Entity> findByCondition(Cr002_01YakujoData3Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr002_01YakujoData3Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr002_01YakujoData3Entity&gt;
     */
    List<Cr002_01YakujoData3Entity> findByCondition(Cr002_01YakujoData3Entity inEntity,
            int offset, int length);

}