//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr011_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.service;

/**
 * <pre>
 * このクラスはcr011_01のサービスインターフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Cr011_01Service {

    /**
     * Cr011_01Serviceのregist
     *
     * @param inDto Cr011_01DTO
     * @return Cr011_01DTO
     */
    Cr011_01DTO regist(Cr011_01DTO inDto);

}