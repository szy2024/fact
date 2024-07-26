//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.service;

/**
 * <pre>
 * このクラスはcr005_01のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr005_01Service {

    /**
     * Cr005_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Cr005_01DTO
     * @return Cr005_01DTO
     */
    Cr005_01DTO getSyokanHonShitenData(Cr005_01DTO inDto);

}