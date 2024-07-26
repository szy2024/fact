//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md010_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md010.md010_01.service;

/**
 * <pre>
 * このクラスはmd010_01のサービスインターフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Md010_01Service {

    /**
     * Md010_01ServiceのgetResultsData
     *
     * @param inDto Md010_01DTO
     * @return Md010_01DTO
     */
    Md010_01DTO getResultsData(Md010_01DTO inDto);

    /**
     * Md010_01ServiceのupdateDataDel
     *
     * @param inDto Md010_01DTO
     * @return Md010_01DTO
     */
    Md010_01DTO updateDataDel(Md010_01DTO inDto);

    /**
     * Md010_01ServiceのupdateDataMod
     *
     * @param inDto Md010_01DTO
     * @return Md010_01DTO
     */
    Md010_01DTO updateDataMod(Md010_01DTO inDto);

}