//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_01.service;

/**
 * <pre>
 * このクラスはSe003_01のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se003_01Service {

    /**
     * Se003_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Se003_01DTO
     * @return Se003_01DTO
     */
    Se003_01DTO getSyokanHonShitenData(Se003_01DTO inDto);

    /**
     * Se003_01ServiceのgetResultData
     *
     * @param inDto Se003_01DTO
     * @return Se003_01DTO
     */
    Se003_01DTO getResultData(Se003_01DTO inDto);

}