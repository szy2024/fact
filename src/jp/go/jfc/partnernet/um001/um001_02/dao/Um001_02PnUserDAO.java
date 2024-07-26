//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02PnUserDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.dao;

import java.util.List;

/**
 * <pre>
 * Um001_02PnUserDAOインタフェースです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public interface Um001_02PnUserDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Um001_02PnUserEntity
     * @return long
     */
    long countByCondition(Um001_02PnUserEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Um001_02PnUserEntity
     * @return List&lt;Um001_02PnUserEntity&gt;
     */
    List<Um001_02PnUserEntity> findByCondition(Um001_02PnUserEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Um001_02PnUserEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Um001_02PnUserEntity&gt;
     */
    List<Um001_02PnUserEntity> findByCondition(Um001_02PnUserEntity inEntity,
            int offset, int length);

}