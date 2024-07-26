//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr013_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.service;

/**
 * <pre>
 * このクラスはcr013_01のサービスインターフェースです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public interface Cr013_01Service {

    /**
     * Cr013_01ServiceのgetInitDataメソッド
     *
     * @param inDto Cr013_01DTO
     * @return Cr013_01DTO
     */
    Cr013_01DTO getInitData(Cr013_01DTO inDto);

    /**
     * Cr013_01Serviceの登録メソッド
     *
     * @param inDto Cr013_01DTO
     * @return Cr013_01DTO
     */
    Cr013_01DTO regist(Cr013_01DTO inDto);

}