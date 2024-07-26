//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.service;

/**
 * <pre>
 * このクラスはUm001_02のサービスインターフェースです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public interface Um001_02Service {

    /**
     * Um001_02ServiceのcountUserList
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    Um001_02DTO countUserList(Um001_02DTO inDto);

    /**
     * Um001_02ServiceのgetUserList
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    Um001_02DTO getUserList(Um001_02DTO inDto);

    /**
     * Um001_02ServiceのupdateCurrentPage
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    Um001_02DTO updateCurrentPage(Um001_02DTO inDto);

}