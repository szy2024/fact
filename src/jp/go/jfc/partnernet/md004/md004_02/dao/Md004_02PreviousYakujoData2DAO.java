//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02PreviousYakujoData2DAO
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
 * Md004_02PreviousYakujoData2DAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md004_02PreviousYakujoData2DAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md004_02PreviousYakujoData2Entity
     * @return long
     */
    long countByCondition(Md004_02PreviousYakujoData2Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md004_02PreviousYakujoData2Entity
     * @return List&lt;Md004_02PreviousYakujoData2Entity&gt;
     */
    List<Md004_02PreviousYakujoData2Entity> findByCondition(Md004_02PreviousYakujoData2Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md004_02PreviousYakujoData2Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md004_02PreviousYakujoData2Entity&gt;
     */
    List<Md004_02PreviousYakujoData2Entity> findByCondition(Md004_02PreviousYakujoData2Entity inEntity,
            int offset, int length);

}