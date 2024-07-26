//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_12Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_12.service;

/**
 * <pre>
 * このクラスはSe006_12のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_12Service {

    /**
     * Se006_12ServiceのgetDetailData
     *
     * @param inDto Se006_12DTO
     * @return Se006_12DTO
     */
    Se006_12DTO getDetailData(Se006_12DTO inDto);

}