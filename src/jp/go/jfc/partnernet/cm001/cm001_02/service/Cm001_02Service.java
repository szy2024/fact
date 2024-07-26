//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_02.service;

/**
 * <pre>
 * このクラスはcm001_02のサービスインターフェースです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
public interface Cm001_02Service {

    /**
     * Cm001_02Serviceのupdate
     *
     * @param inDto Cm001_02DTO
     * @return Cm001_02DTO
     */
    Cm001_02DTO update(Cm001_02DTO inDto);

}