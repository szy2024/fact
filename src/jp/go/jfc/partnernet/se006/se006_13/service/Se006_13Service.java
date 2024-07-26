//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_13Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_13.service;

/**
 * <pre>
 * このクラスはSe006_13のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se006_13Service {

    /**
     * Se006_13ServiceのgetDetailData
     *
     * @param inDto Se006_13DTO
     * @return Se006_13DTO
     */
    Se006_13DTO getDetailData(Se006_13DTO inDto);

}