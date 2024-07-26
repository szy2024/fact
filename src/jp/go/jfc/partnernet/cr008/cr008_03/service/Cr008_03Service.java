//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_03.service;

/**
 * <pre>
 * このクラスはcr008_03のサービスインターフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_03Service {

    /**
     * Cr008_03ServiceのgetResultData
     *
     * @param inDto Cr008_03DTO
     * @return Cr008_03DTO
     */
    Cr008_03DTO getResultData(Cr008_03DTO inDto);

}