//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.service;

/**
 * <pre>
 * このクラスはmd004_02のサービスインターフェースです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public interface Md004_02Service {

    /**
     * Md004_02ServiceのgetResultsData
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO getResultsData(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのgetKeisanEdit
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO getKeisanEdit(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO updateDataNotProcEndDel(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO updateDataProcEndDel(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO updateDataNotProcEndMod(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO updateDataProcEndMod(Md004_02DTO inDto);

    /**
     * Md004_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md004_02DTO
     * @return Md004_02DTO
     */
    Md004_02DTO updateDataNotProcEndDelCalcel(Md004_02DTO inDto);

}