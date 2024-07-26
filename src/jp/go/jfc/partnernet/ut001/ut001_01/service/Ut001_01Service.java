//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_01.service;

/**
 * <pre>
 * このクラスはUt001_01のサービスインターフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut001_01Service {

    /**
     * Ut001_01Serviceのdetail
     *
     * @param inDto Ut001_01DTO
     * @return Ut001_01DTO
     */
    Ut001_01DTO detail(Ut001_01DTO inDto);

}