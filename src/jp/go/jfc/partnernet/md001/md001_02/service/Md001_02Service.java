//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_02.service;

/**
 * <pre>
 * このクラスはMd001_02のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Md001_02Service {

    /**
     * Md001_02ServiceのgetResultsData
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO getResultsData(Md001_02DTO inDto);

    /**
     * Md001_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO updateDataNotProcEndDel(Md001_02DTO inDto);

    /**
     * Md001_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO updateDataProcEndDel(Md001_02DTO inDto);

    /**
     * Md001_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO updateDataNotProcEndMod(Md001_02DTO inDto);

    /**
     * Md001_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO updateDataProcEndMod(Md001_02DTO inDto);

    /**
     * Md001_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md001_02DTO
     * @return Md001_02DTO
     */
    Md001_02DTO updateDataNotProcEndDelCalcel(Md001_02DTO inDto);

}