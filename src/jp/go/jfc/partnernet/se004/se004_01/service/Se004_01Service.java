//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.service;

/**
 * <pre>
 * このクラスはSe004_01のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se004_01Service {

    /**
     * Se004_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Se004_01DTO
     * @return Se004_01DTO
     */
    Se004_01DTO getSyokanHonShitenData(Se004_01DTO inDto);

    /**
     * Se004_01ServiceのgetResultData
     *
     * @param inDto Se004_01DTO
     * @return Se004_01DTO
     */
    Se004_01DTO getResultData(Se004_01DTO inDto);

}