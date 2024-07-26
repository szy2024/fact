//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.service;

/**
 * <pre>
 * このクラスはMd008_02のサービスインターフェースです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public interface Md008_02Service {

    /**
     * Md008_02ServiceのgetResultsData
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO getResultsData(Md008_02DTO inDto);

    /**
     * Md008_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO updateDataNotProcEndDel(Md008_02DTO inDto);

    /**
     * Md008_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO updateDataProcEndDel(Md008_02DTO inDto);

    /**
     * Md008_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO updateDataNotProcEndMod(Md008_02DTO inDto);

    /**
     * Md008_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO updateDataProcEndMod(Md008_02DTO inDto);

    /**
     * Md008_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md008_02DTO
     * @return Md008_02DTO
     */
    Md008_02DTO updateDataNotProcEndDelCalcel(Md008_02DTO inDto);

}