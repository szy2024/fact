//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/06 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_01.service;

/**
 * <pre>
 * このクラスはse006_01のサービスインターフェースです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public interface Se006_01Service {

    /**
     * Se006_01ServiceのgetInitData
     *
     * @param inDto
     *            Se006_01DTO
     * @return Se006_01DTO
     */
    Se006_01DTO getInitData(Se006_01DTO inDto);

}