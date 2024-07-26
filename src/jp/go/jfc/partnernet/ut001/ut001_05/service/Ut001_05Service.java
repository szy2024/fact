//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_05Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_05.service;

/**
 * <pre>
 * このクラスはUt001_05のサービスインターフェースです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public interface Ut001_05Service {

    /**
     * Ut001_05Serviceのresult
     *
     * @param inDto Ut001_05DTO
     * @return Ut001_05DTO
     */
    Ut001_05DTO result(Ut001_05DTO inDto);

}