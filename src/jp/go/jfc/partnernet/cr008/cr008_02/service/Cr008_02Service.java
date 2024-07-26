//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_02.service;

/**
 * <pre>
 * このクラスはCr008_02のサービスインターフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_02Service {

    /**
     * Cr008_02ServiceのgetResultData
     *
     * @param inDto Cr008_02DTO
     * @return Cr008_02DTO
     */
    Cr008_02DTO getResultData(Cr008_02DTO inDto);

}