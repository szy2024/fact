//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.service;

/**
 * <pre>
 * このクラスはse008_02のサービスインターフェースです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public interface Se008_02Service {

	/**
	 * Se008_02ServiceのgetResultsData
	 *
	 * @param inDto
	 *            Se008_02DTO
	 * @return Se008_02DTO
	 */
	Se008_02DTO getResultsData(Se008_02DTO inDto);

	/**
	 * Se008_02ServiceのgetResultsKariKeisanData
	 *
	 * @param inDto
	 *            Se008_02DTO
	 * @return Se008_02DTO
	 */
	Se008_02DTO getResultsKariKeisanData(Se008_02DTO inDto);

}