//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/28 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_01.service;

/**
 * <pre>
 * このクラスはmd003_01のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md003_01Service {

    /**
     * Md003_01ServiceのgetResultsData
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getResultsData(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetNewSeikyuData
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getNewSeikyuData(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetYakujoMSeiKuriRisoku
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getYakujoMSeiKuriRisoku(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetSeikyu
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getSeikyu(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetSeikyuYakujoGankin
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getSeikyuYakujoGankin(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetAcustomer
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getAcustomer(Md003_01DTO inDto);

    /**
     * Md003_01ServiceのgetTenpo
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    Md003_01DTO getTenpo(Md003_01DTO inDto);

}