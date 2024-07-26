//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr010_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.service;

/**
 * <pre>
 * このクラスはCr010_01のサービスインターフェースです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public interface Cr010_01Service {

    /**
     * Cr010_01Serviceのregist
     *
     * @param inDto Cr010_01DTO
     * @return Cr010_01DTO
     */
    Cr010_01DTO regist(Cr010_01DTO inDto);

}