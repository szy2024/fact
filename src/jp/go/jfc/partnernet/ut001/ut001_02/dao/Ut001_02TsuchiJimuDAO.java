//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_02TsuchiJimuDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_02.dao;

import java.util.List;

/**
 * <pre>
 * Ut001_02TsuchiJimuDAOインタフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut001_02TsuchiJimuDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Ut001_02TsuchiJimuEntity
     * @return long
     */
    long countByCondition(Ut001_02TsuchiJimuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Ut001_02TsuchiJimuEntity
     * @return List&lt;Ut001_02TsuchiJimuEntity&gt;
     */
    List<Ut001_02TsuchiJimuEntity> findByCondition(Ut001_02TsuchiJimuEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Ut001_02TsuchiJimuEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Ut001_02TsuchiJimuEntity&gt;
     */
    List<Ut001_02TsuchiJimuEntity> findByCondition(Ut001_02TsuchiJimuEntity inEntity,
            int offset, int length);

}