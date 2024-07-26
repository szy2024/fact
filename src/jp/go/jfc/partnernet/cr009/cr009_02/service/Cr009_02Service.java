//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_02.service;

/**
 * <pre>
 * このクラスはCr009_02のサービスインターフェースです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public interface Cr009_02Service {

    /**
     * Cr009_02Serviceのregist
     *
     * @param inDto Cr009_02DTO
     * @return Cr009_02DTO
     */
    Cr009_02DTO regist(Cr009_02DTO inDto);

}