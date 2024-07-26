//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md000_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md000.md000_02.service;

/**
 * <pre>
 * このクラスはMd000_02のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Md000_02Service {

    /**
     * Md000_02ServiceのgetResultsData
     *
     * @param inDto Md000_02DTO
     * @return Md000_02DTO
     */
    Md000_02DTO getResultsData(Md000_02DTO inDto);

    // /**
    // * Md000_02ServiceのgetResultData
    // *
    // * @param inDto Se001_02DTO
    // * @return Se001_02DTO
    // */
    // Se001_02DTO getResultData(Se001_02DTO inDto);
}