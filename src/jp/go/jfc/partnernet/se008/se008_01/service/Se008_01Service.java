//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_01.service;

/**
 * <pre>
 * このクラスはSe008_01のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se008_01Service {

    /**
     * Se008_01ServiceのinitForSearch
     *
     * @param inDto Se008_01DTO
     * @return Se008_01DTO
     */
    Se008_01DTO initForSearch(Se008_01DTO inDto);

}