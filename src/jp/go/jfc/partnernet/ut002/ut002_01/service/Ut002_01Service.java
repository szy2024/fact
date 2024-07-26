//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut002_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut002.ut002_01.service;

/**
 * <pre>
 * このクラスはut002_01のサービスインターフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut002_01Service {

    /**
     * Ut002_01ServiceのgetNews
     *
     * @param inDto Ut002_01DTO
     * @return Ut002_01DTO
     */
    Ut002_01DTO getNews(Ut002_01DTO inDto);

    /**
     * Ut002_01ServiceのupdateNews
     *
     * @param inDto Ut002_01DTO
     * @return Ut002_01DTO
     */
    Ut002_01DTO updateNews(Ut002_01DTO inDto);

}