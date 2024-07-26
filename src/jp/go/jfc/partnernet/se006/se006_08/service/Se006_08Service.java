//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_08Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_08.service;

/**
 * <pre>
 * このクラスはSe006_08のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_08Service {

    /**
     * Se006_08ServiceのgetDetailData
     *
     * @param inDto Se006_08DTO
     * @return Se006_08DTO
     */
    Se006_08DTO getDetailData(Se006_08DTO inDto);

}