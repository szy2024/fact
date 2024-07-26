//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_02.service;

/**
 * <pre>
 * このクラスはse012_02のサービスインターフェースです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public interface Se012_02Service {

    /**
     * Se012_02ServiceのgetGyomuitakuIndexData
     *
     * @param inDto Se012_02DTO
     * @return Se012_02DTO
     */
    Se012_02DTO getGyomuitakuIndexData(Se012_02DTO inDto);

}