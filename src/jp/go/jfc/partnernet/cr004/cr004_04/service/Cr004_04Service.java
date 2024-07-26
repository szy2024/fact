//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.service;

/**
 * <pre>
 * このクラスはcr004_04のサービスインターフェースです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public interface Cr004_04Service {

    /**
     * Cr004_04ServiceのgetResultData
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getResultData(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのcheckJutoJunjo
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO checkJutoJunjo(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetSeikyuData
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getSeikyuData(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetYakujoData
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getYakujoData(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetNyukinHistoryCount
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getNyukinHistoryCount(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetNyukinHistoryData
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getNyukinHistoryData(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetYakujoPKCount
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getYakujoPKCount(Cr004_04DTO inDto);

    /**
     * Cr004_04ServiceのgetYakujoPKData
     *
     * @param inDto Cr004_04DTO
     * @return Cr004_04DTO
     */
    Cr004_04DTO getYakujoPKData(Cr004_04DTO inDto);

}