//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_05Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_05.service;

/**
 * <pre>
 * このクラスはut003_05のサービスインターフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut003_05Service {

    /**
     * Ut003_05ServiceのgetHitCount
     *
     * @param inDto Ut003_05DTO
     * @return Ut003_05DTO
     */
    Ut003_05DTO getHitCount(Ut003_05DTO inDto);

    /**
     * Ut003_05ServiceのgetResultData
     *
     * @param inDto Ut003_05DTO
     * @return Ut003_05DTO
     */
    Ut003_05DTO getResultData(Ut003_05DTO inDto);

    /**
     * Ut003_05Serviceのdelete
     *
     * @param inDto Ut003_05DTO
     * @return Ut003_05DTO
     */
    Ut003_05DTO delete(Ut003_05DTO inDto);

}