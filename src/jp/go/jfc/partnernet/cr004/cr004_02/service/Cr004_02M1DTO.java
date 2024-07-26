//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr004_02のDTOクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_02M1DTO extends PNBaseDTO {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 貸付先コード */
	private String ID_Code_Customer;
	/** 顧客名 */
	private String ID_Name_Customer;
	/** 扱店コード */
	private String ID_Code_Organization;
	/** 住所 */
	private String ID_CustomerAddress;

	/**
	 * <pre>
	 * コンストラクター。
	 * </pre>
	 *
	 */
	public Cr004_02M1DTO() {
		// Controller及びServiceでのインスタンス生成の為
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
	public Cr004_02M1DTO(Cr004_02M1DTO orig) {
		super(orig);
	}

	/**
	 * 貸付先コードを取得します。
	 *
	 * @return 貸付先コード
	 */
	public String getID_Code_Customer() {
		return ID_Code_Customer;
	}

	/**
	 * 貸付先コードを設定します。
	 *
	 * @param ID_Code_Customer
	 *            貸付先コード
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		this.ID_Code_Customer = ID_Code_Customer;
	}

	/**
	 * 顧客名を取得します。
	 *
	 * @return 顧客名
	 */
	public String getID_Name_Customer() {
		return ID_Name_Customer;
	}

	/**
	 * 顧客名を設定します。
	 *
	 * @param ID_Name_Customer
	 *            顧客名
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		this.ID_Name_Customer = ID_Name_Customer;
	}

	/**
	 * 扱店コードを取得します。
	 *
	 * @return 扱店コード
	 */
	public String getID_Code_Organization() {
		return ID_Code_Organization;
	}

	/**
	 * 扱店コードを設定します。
	 *
	 * @param ID_Code_Organization
	 *            扱店コード
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		this.ID_Code_Organization = ID_Code_Organization;
	}

	/**
	 * 住所を取得します。
	 *
	 * @return 住所
	 */
	public String getID_CustomerAddress() {
		return ID_CustomerAddress;
	}

	/**
	 * 住所を設定します。
	 *
	 * @param ID_CustomerAddress
	 *            住所
	 */
	public void setID_CustomerAddress(String ID_CustomerAddress) {
		this.ID_CustomerAddress = ID_CustomerAddress;
	}

}