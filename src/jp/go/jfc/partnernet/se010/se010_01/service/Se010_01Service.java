//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.service;

/**
 * <pre>
 * このクラスはSe010_01のサービスインターフェースです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public interface Se010_01Service {

    /**
     * Se010_01ServiceのgetkoukoShitenCodeNameMap
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    Se010_01DTO getKoukoShitenCodeNameMap(Se010_01DTO inDto);

    /**
     * Se010_01ServiceのgetKurishoJiyuCodeMap
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    Se010_01DTO getKurishoJiyuCodeMap(Se010_01DTO inDto);

    /**
     * Se010_01ServiceのvalidateKurishoKeisan
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    Se010_01DTO validateKurishoKeisan(Se010_01DTO inDto);

}