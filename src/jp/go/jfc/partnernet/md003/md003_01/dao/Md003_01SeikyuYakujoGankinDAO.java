//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_01SeikyuYakujoGankinDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/28 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_01.dao;

import java.util.List;

/**
 * <pre>
 * Md003_01SeikyuYakujoGankinDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md003_01SeikyuYakujoGankinDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md003_01SeikyuYakujoGankinEntity
     * @return long
     */
    long countByCondition(Md003_01SeikyuYakujoGankinEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md003_01SeikyuYakujoGankinEntity
     * @return List&lt;Md003_01SeikyuYakujoGankinEntity&gt;
     */
    List<Md003_01SeikyuYakujoGankinEntity> findByCondition(Md003_01SeikyuYakujoGankinEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md003_01SeikyuYakujoGankinEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md003_01SeikyuYakujoGankinEntity&gt;
     */
    List<Md003_01SeikyuYakujoGankinEntity> findByCondition(Md003_01SeikyuYakujoGankinEntity inEntity,
            int offset, int length);

}