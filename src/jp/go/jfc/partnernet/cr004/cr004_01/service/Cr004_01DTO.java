//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr004_01のDTOクラスです。
 * </pre>
 *
 * @author 佐藤 晃
 * @version 1.0.0
 */
public class Cr004_01DTO extends PNBaseDTO {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 公庫支店名プルダウンリスト */
	private java.util.LinkedHashMap<String, String> ShokanHonShitenLIST;

	/**
	 * <pre>
	 * コンストラクター。
	 * </pre>
	 *
	 */
	public Cr004_01DTO() {
		// Controller及びServiceでのインスタンス生成の為
	}

	/**
	 * <pre>
	 * コンストラクター。
	 * 引数のDTOの中身を取得しセットします。
	 * </pre>
	 *
	 * @param orig 設定元DTO
	 * @throws Exception
	 *             例外
	 */
	public Cr004_01DTO(Cr004_01DTO orig) {
		super(orig);
	}

	/**
	 * 公庫支店名プルダウンリストを取得します。
	 *
	 * @return 公庫支店名プルダウンリスト
	 */
	public java.util.LinkedHashMap<String, String> getShokanHonShitenLIST() {
		return ShokanHonShitenLIST;
	}

	/**
	 * 公庫支店名プルダウンリストを設定します。
	 *
	 * @param ShokanHonShitenLIST
	 *            公庫支店名プルダウンリスト
	 */
	public void setShokanHonShitenLIST(
			java.util.LinkedHashMap<String, String> ShokanHonShitenLIST) {
		this.ShokanHonShitenLIST = ShokanHonShitenLIST;
	}

}