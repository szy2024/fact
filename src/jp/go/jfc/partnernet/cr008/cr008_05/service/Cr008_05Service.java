//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_05Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_05.service;

/**
 * <pre>
 * このクラスはcr008_05のサービスインターフェースです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public interface Cr008_05Service {

    /**
     * Cr008_05ServiceのinsertReport
     *
     * @param inDto Cr008_05DTO
     * @return Cr008_05DTO
     */
    Cr008_05DTO insertReport(Cr008_05DTO inDto);

}