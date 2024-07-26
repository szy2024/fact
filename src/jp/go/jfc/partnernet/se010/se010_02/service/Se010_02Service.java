//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.service;

/**
 * <pre>
 * このクラスはSe010_02のサービスインターフェースです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public interface Se010_02Service {

    /**
     * Se010_02ServiceのgetKurishoRisoku
     *
     * @param inDto Se010_02DTO
     * @return Se010_02DTO
     */
    Se010_02DTO getKurishoRisoku(Se010_02DTO inDto);

    /**
     * Se010_02ServiceのgetKurishoTesuryo
     *
     * @param inDto Se010_02DTO
     * @return Se010_02DTO
     */
    Se010_02DTO getKurishoTesuryo(Se010_02DTO inDto);

}