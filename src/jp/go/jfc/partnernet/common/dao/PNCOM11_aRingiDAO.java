//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCOM11_aRingiDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
//4.0.0   | 2020/11/30 | 番場　千沙都          | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.List;

/**
 * <pre>
 * PNCOM11_aRingiDAOインタフェースです。
 * </pre>
 *
 * @author 番場　千沙都
 * @version 4.0.0
 */
public interface PNCOM11_aRingiDAO {

    /**
     *
     * <pre>
     * 条件検索をします。（一括検索用）
     * </pre>
     *
     * @param inEntity PNCOM11_aRingiEntity
     * @return List&lt;PNCOM11_aRingiEntity&gt;
     */
    List<PNCOM11_aRingiEntity> findByCondition(PNCOM11_aRingiEntity inEntity);


}