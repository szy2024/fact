//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_02.service;

/**
 * <pre>
 * このクラスはSe004_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se004_02Service {

    /**
     * Se004_02ServiceのGetResultData
     *
     * @param inDto Se004_02DTO
     * @return Se004_02DTO
     */
    Se004_02DTO getResultData(Se004_02DTO inDto);

}