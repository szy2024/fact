//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_01HaraidashiDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_01.dao;

import java.util.List;

/**
 * <pre>
 * Md002_01HaraidashiDataDAOインタフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md002_01HaraidashiDataDAO {

    /**
     *
     * <pre>
     * 検索結果件数を取得します。
     * </pre>
     *
     * @param inEntity Md002_01HaraidashiDataEntity
     * @return long
     */
    long countByCondition(Md002_01HaraidashiDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity Md002_01HaraidashiDataEntity
     * @return List&lt;Md002_01HaraidashiDataEntity&gt;
     */
    List<Md002_01HaraidashiDataEntity> findByCondition(Md002_01HaraidashiDataEntity inEntity);

    /**
     *
     * <pre>
     * 条件検索をします。（逐次検索用）
     * </pre>
     *
     * @param inEntity Md002_01HaraidashiDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md002_01HaraidashiDataEntity&gt;
     */
    List<Md002_01HaraidashiDataEntity> findByCondition(Md002_01HaraidashiDataEntity inEntity,
            int offset, int length);

}