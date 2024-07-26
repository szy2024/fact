//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.service;

/**
 * <pre>
 * このクラスはcr005_03のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr005_03Service {

    /**
     * Cr005_03ServiceのgetResultData
     *
     * @param inDto Cr005_03DTO
     * @return Cr005_03DTO
     */
    Cr005_03DTO getResultData(Cr005_03DTO inDto);

}