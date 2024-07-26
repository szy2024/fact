//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se014_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.service;

/**
 * <pre>
 * このクラスはse014_01のサービスインターフェースです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public interface Se014_01Service {

    /**
     * Se014_01ServiceのexcelOut
     *
     * @param inDto Se014_01DTO
     * @return Se014_01DTO
     */
    Se014_01DTO excelOut(Se014_01DTO inDto);

}