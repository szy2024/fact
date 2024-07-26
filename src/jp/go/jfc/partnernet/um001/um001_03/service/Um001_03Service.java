//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_03.service;

/**
 * <pre>
 * このクラスはUm001_03のサービスインターフェースです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public interface Um001_03Service {

    /**
     * Um001_03ServiceのgetUserInfo
     *
     * @param inDto Um001_03DTO
     * @return Um001_03DTO
     */
    Um001_03DTO getUserInfo(Um001_03DTO inDto);

    /**
     * Um001_03Serviceのupdate
     *
     * @param inDto Um001_03DTO
     * @return Um001_03DTO
     */
    Um001_03DTO update(Um001_03DTO inDto);

}