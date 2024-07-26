//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 青本　信吉            | 新規作成
// 4.0.0   | 2020/11/30 | 番場　千沙都          | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_02.service;

/**
 * <pre>
 * このクラスはSe009_02のサービスインターフェースです。
 * </pre>
 *
 * @author 番場 千沙都
 * @version 4.0.0
 */

public interface Se009_02Service {

    /**
     * Se009_02ServiceのgetKoujorisoku
     *
     * @param inDto Se009_02DTO
     * @return Se009_02DTO
     */
    Se009_02DTO getKoujorisoku(Se009_02DTO inDto);

// [ADD] Ver 4.0.0 - START
	/**
	 * Se009_02ServiceのgetYakujorisoku
	 *
	 * @param inDto Se009_02DTO
	 * @return Se009_02DTO
	 */
	Se009_02DTO getYakujorisoku(Se009_02DTO inDto);
// [ADD] Ver 4.0.0 - END

}