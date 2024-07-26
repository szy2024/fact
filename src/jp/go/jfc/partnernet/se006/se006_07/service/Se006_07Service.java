//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_07Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_07.service;

/**
 * <pre>
 * このクラスはSe006_07のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_07Service {

    /**
     * Se006_07ServiceのgetDetailData
     *
     * @param inDto Se006_07DTO
     * @return Se006_07DTO
     */
    Se006_07DTO getDetailData(Se006_07DTO inDto);

}