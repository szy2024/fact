//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultKurishoJiyuDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.dao;

import java.util.List;

/**
 * <pre>
 * Cr004_04ResultKurishoJiyuDAOインタフェースです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public interface Cr004_04ResultKurishoJiyuDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr004_04ResultKurishoJiyuEntity
     * @return long
     */
    long countByCondition(Cr004_04ResultKurishoJiyuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr004_04ResultKurishoJiyuEntity
     * @return List&lt;Cr004_04ResultKurishoJiyuEntity&gt;
     */
    List<Cr004_04ResultKurishoJiyuEntity> findByCondition(Cr004_04ResultKurishoJiyuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr004_04ResultKurishoJiyuEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr004_04ResultKurishoJiyuEntity&gt;
     */
    List<Cr004_04ResultKurishoJiyuEntity> findByCondition(Cr004_04ResultKurishoJiyuEntity inEntity,
            int offset, int length);

}