//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_02.service;

/**
 * <pre>
 * このクラスはse001_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Se001_02Service {

    /**
     * Se001_02ServiceのgetResultData
     *
     * @param inDto Se001_02DTO
     * @return Se001_02DTO
     */
    Se001_02DTO getResultData(Se001_02DTO inDto);

}