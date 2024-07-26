//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02YushiBangoDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/12/01 | 林　晃平              | 新規作成（委託貸付報告等における機能改善対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.dao;

import java.util.List;

/**
 * <pre>
 * Cr006_02YushiBangoDAOインタフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Cr006_02YushiBangoDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Cr006_02YushiBangoEntity
     * @return long
     */
    long countByCondition(Cr006_02YushiBangoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Cr006_02YushiBangoEntity
     * @return List&lt;Cr006_02YushiBangoEntity&gt;
     */
    List<Cr006_02YushiBangoEntity> findByCondition(Cr006_02YushiBangoEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Cr006_02YushiBangoEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Cr006_02YushiBangoEntity&gt;
     */
    List<Cr006_02YushiBangoEntity> findByCondition(Cr006_02YushiBangoEntity inEntity,
            int offset, int length);

}