//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_04.service;

/**
 * <pre>
 * このクラスはcr008_04のサービスインターフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_04Service {

    /**
     * Cr008_04ServiceのgetResultData
     *
     * @param inDto Cr008_04DTO
     * @return Cr008_04DTO
     */
    Cr008_04DTO getResultData(Cr008_04DTO inDto);

}