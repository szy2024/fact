//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_05ResultYakujo1DAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_05.dao;

import java.util.List;

/**
 * <pre>
 * Cr004_05ResultYakujo1DAOインタフェースです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public interface Cr004_05ResultYakujo1DAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr004_05ResultYakujo1Entity
     * @return long
     */
    long countByCondition(Cr004_05ResultYakujo1Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr004_05ResultYakujo1Entity
     * @return List&lt;Cr004_05ResultYakujo1Entity&gt;
     */
    List<Cr004_05ResultYakujo1Entity> findByCondition(Cr004_05ResultYakujo1Entity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr004_05ResultYakujo1Entity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr004_05ResultYakujo1Entity&gt;
     */
    List<Cr004_05ResultYakujo1Entity> findByCondition(Cr004_05ResultYakujo1Entity inEntity,
            int offset, int length);

}