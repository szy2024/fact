//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.service;

/**
 * <pre>
 * このクラスはCr003_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Cr003_02Service {

    /**
     * Cr003_02ServiceのgetResultData
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getResultData(Cr003_02DTO inDto);

    /**
     * Cr003_02ServiceのgetSeikyuData1
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getSeikyuData1(Cr003_02DTO inDto);

    /**
     * Cr003_02ServiceのgetSeikyuData2
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getSeikyuData2(Cr003_02DTO inDto);

    /**
     * Cr003_02ServiceのgetSeikyuData3
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getSeikyuData3(Cr003_02DTO inDto);

    /**
     * Cr003_02ServiceのgetCustomerData
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getCustomerData(Cr003_02DTO inDto);

    /**
     * Cr003_02ServiceのgetTenpoData
     *
     * @param inDto Cr003_02DTO
     * @return Cr003_02DTO
     */
    Cr003_02DTO getTenpoData(Cr003_02DTO inDto);

}