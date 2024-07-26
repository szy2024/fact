//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_02.service;

/**
 * <pre>
 * このクラスはmd003_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md003_02Service {

    /**
     * Md003_02ServiceのgetResultsData
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO getResultsData(Md003_02DTO inDto);

    /**
     * Md003_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO updateDataNotProcEndDel(Md003_02DTO inDto);

    /**
     * Md003_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO updateDataProcEndDel(Md003_02DTO inDto);

    /**
     * Md003_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO updateDataNotProcEndMod(Md003_02DTO inDto);

    /**
     * Md003_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO updateDataProcEndMod(Md003_02DTO inDto);

    /**
     * Md003_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md003_02DTO
     * @return Md003_02DTO
     */
    Md003_02DTO updateDataNotProcEndDelCalcel(Md003_02DTO inDto);

}