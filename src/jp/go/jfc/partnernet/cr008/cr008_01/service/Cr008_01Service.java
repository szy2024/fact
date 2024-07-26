//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_01.service;

/**
 * <pre>
 * このクラスはCr008_01のサービスインターフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_01Service {

    /**
     * Cr008_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Cr008_01DTO
     * @return Cr008_01DTO
     */
    Cr008_01DTO getSyokanHonShitenData(Cr008_01DTO inDto);

}