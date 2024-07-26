//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse008_02のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_02DTO extends PNBaseDTO {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 検索開始年月日（年） */
	private String ID_SearchStartYear;
	/** 検索開始年月日（月） */
	private String ID_SearchStartMonth;
	/** 検索開始年月日（日） */
	private String ID_SearchStartDate;
	/** 検索終了年月日（年） */
	private String ID_SearchEndYear;
	/** 検索終了年月日（月） */
	private String ID_SearchEndMonth;
	/** 検索終了年月日（日） */
	private String ID_SearchEndDate;
	/** 債権管理番号 */
	private java.math.BigDecimal ID_Credit;
	/** 明細リスト */
	private List<Se008_02M1DTO> MEISAI_LIST;

	/**
	 * <pre>
	 * コンストラクター。
	 * </pre>
	 *
	 */
	public Se008_02DTO() {
		// Controller及びServiceでのインスタンス生成の為
		super();
	}

	/**
	 * <pre>
	 * コンストラクター。
	 * 引数のDTOの中身を取得しセットします。
	 * </pre>
	 *
	 * @param orig
	 *            設定元DTO
	 * @throws Exception
	 *             例外
	 */
	public Se008_02DTO(Se008_02DTO orig) {
		super(orig);
	}

	/**
	 * 検索開始年月日（年）を取得します。
	 *
	 * @return 検索開始年月日（年）
	 */
	public String getID_SearchStartYear() {
		return ID_SearchStartYear;
	}

	/**
	 * 検索開始年月日（年）を設定します。
	 *
	 * @param ID_SearchStartYear
	 *            検索開始年月日（年）
	 */
	public void setID_SearchStartYear(String ID_SearchStartYear) {
		this.ID_SearchStartYear = ID_SearchStartYear;
	}

	/**
	 * 検索開始年月日（月）を取得します。
	 *
	 * @return 検索開始年月日（月）
	 */
	public String getID_SearchStartMonth() {
		return ID_SearchStartMonth;
	}

	/**
	 * 検索開始年月日（月）を設定します。
	 *
	 * @param ID_SearchStartMonth
	 *            検索開始年月日（月）
	 */
	public void setID_SearchStartMonth(String ID_SearchStartMonth) {
		this.ID_SearchStartMonth = ID_SearchStartMonth;
	}

	/**
	 * 検索開始年月日（日）を取得します。
	 *
	 * @return 検索開始年月日（日）
	 */
	public String getID_SearchStartDate() {
		return ID_SearchStartDate;
	}

	/**
	 * 検索開始年月日（日）を設定します。
	 *
	 * @param ID_SearchStartDate
	 *            検索開始年月日（日）
	 */
	public void setID_SearchStartDate(String ID_SearchStartDate) {
		this.ID_SearchStartDate = ID_SearchStartDate;
	}

	/**
	 * 検索終了年月日（年）を取得します。
	 *
	 * @return 検索終了年月日（年）
	 */
	public String getID_SearchEndYear() {
		return ID_SearchEndYear;
	}

	/**
	 * 検索終了年月日（年）を設定します。
	 *
	 * @param ID_SearchEndYear
	 *            検索終了年月日（年）
	 */
	public void setID_SearchEndYear(String ID_SearchEndYear) {
		this.ID_SearchEndYear = ID_SearchEndYear;
	}

	/**
	 * 検索終了年月日（月）を取得します。
	 *
	 * @return 検索終了年月日（月）
	 */
	public String getID_SearchEndMonth() {
		return ID_SearchEndMonth;
	}

	/**
	 * 検索終了年月日（月）を設定します。
	 *
	 * @param ID_SearchEndMonth
	 *            検索終了年月日（月）
	 */
	public void setID_SearchEndMonth(String ID_SearchEndMonth) {
		this.ID_SearchEndMonth = ID_SearchEndMonth;
	}

	/**
	 * 検索終了年月日（日）を取得します。
	 *
	 * @return 検索終了年月日（日）
	 */
	public String getID_SearchEndDate() {
		return ID_SearchEndDate;
	}

	/**
	 * 検索終了年月日（日）を設定します。
	 *
	 * @param ID_SearchEndDate
	 *            検索終了年月日（日）
	 */
	public void setID_SearchEndDate(String ID_SearchEndDate) {
		this.ID_SearchEndDate = ID_SearchEndDate;
	}

	/**
	 * 債権管理番号を取得します。
	 *
	 * @return 債権管理番号
	 */
	public java.math.BigDecimal getID_Credit() {
		return ID_Credit;
	}

	/**
	 * 債権管理番号を設定します。
	 *
	 * @param ID_Credit
	 *            債権管理番号
	 */
	public void setID_Credit(java.math.BigDecimal ID_Credit) {
		this.ID_Credit = ID_Credit;
	}

	/**
	 * 明細リストを取得します。
	 *
	 * @return 明細リスト
	 */
	public List<Se008_02M1DTO> getMEISAI_LIST() {
		return MEISAI_LIST;
	}

	/**
	 * 明細リストを設定します。
	 *
	 * @param MEISAI_LIST
	 *            明細リスト
	 */
	public void setMEISAI_LIST(List<Se008_02M1DTO> MEISAI_LIST) {
		this.MEISAI_LIST = MEISAI_LIST;
	}
}