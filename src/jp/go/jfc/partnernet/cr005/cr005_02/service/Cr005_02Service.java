//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_02.service;

/**
 * <pre>
 * このクラスはcr005_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr005_02Service {

    /**
     * Cr005_02ServiceのgetResultData
     *
     * @param inDto Cr005_02DTO
     * @return Cr005_02DTO
     */
    Cr005_02DTO getResultData(Cr005_02DTO inDto);

}