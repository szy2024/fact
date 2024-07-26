//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_01.service;

/**
 * <pre>
 * このクラスはMd008_01のサービスインターフェースです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public interface Md008_01Service {

    /**
     * Md008_01ServiceのgetResultsData
     *
     * @param inDto Md008_01DTO
     * @return Md008_01DTO
     */
    Md008_01DTO getResultsData(Md008_01DTO inDto);

}