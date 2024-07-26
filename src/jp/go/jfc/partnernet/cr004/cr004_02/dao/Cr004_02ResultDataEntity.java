//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr004_02ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_02ResultDataEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 顧客名入力値を取得します。
	 * 
	 * @return 顧客名入力値
	 */
	public String getCr004_02_In_Name_Customer() {
		return (String) getValue("Cr004_02_In_Name_Customer");
	}

	/**
	 * 顧客名入力値を設定します。
	 * 
	 * @param Cr004_02_In_Name_Customer
	 *            顧客名入力値
	 */
	public void setCr004_02_In_Name_Customer(String Cr004_02_In_Name_Customer) {
		setValue("Cr004_02_In_Name_Customer", Cr004_02_In_Name_Customer);
	}

	/**
	 * ログインユーザ扱店コードを取得します。
	 * 
	 * @return ログインユーザ扱店コード
	 */
	public String getCr004_02_Code_Organization() {
		return (String) getValue("Cr004_02_Code_Organization");
	}

	/**
	 * ログインユーザ扱店コードを設定します。
	 * 
	 * @param Cr004_02_Code_Organization
	 *            ログインユーザ扱店コード
	 */
	public void setCr004_02_Code_Organization(String Cr004_02_Code_Organization) {
		setValue("Cr004_02_Code_Organization", Cr004_02_Code_Organization);
	}

	/**
	 * 貸付先名称を取得します。
	 * 
	 * @return 貸付先名称
	 */
	public String getName_Customer() {
		return (String) getValue("Name_Customer");
	}

	/**
	 * 貸付先名称を設定します。
	 * 
	 * @param Name_Customer
	 *            貸付先名称
	 */
	public void setName_Customer(String Name_Customer) {
		setValue("Name_Customer", Name_Customer);
	}

	/**
	 * 貸付先コードを取得します。
	 * 
	 * @return 貸付先コード
	 */
	public String getCode_Customer() {
		return (String) getValue("Code_Customer");
	}

	/**
	 * 貸付先コードを設定します。
	 * 
	 * @param Code_Customer
	 *            貸付先コード
	 */
	public void setCode_Customer(String Code_Customer) {
		setValue("Code_Customer", Code_Customer);
	}

	/**
	 * 補助住所を取得します。
	 * 
	 * @return 補助住所
	 */
	public String getAddr_Hojo() {
		return (String) getValue("Addr_Hojo");
	}

	/**
	 * 補助住所を設定します。
	 * 
	 * @param Addr_Hojo
	 *            補助住所
	 */
	public void setAddr_Hojo(String Addr_Hojo) {
		setValue("Addr_Hojo", Addr_Hojo);
	}

	/**
	 * 扱店コードを取得します。
	 * 
	 * @return 扱店コード
	 */
	public String getCode_Organization() {
		return (String) getValue("Code_Organization");
	}

	/**
	 * 扱店コードを設定します。
	 * 
	 * @param Code_Organization
	 *            扱店コード
	 */
	public void setCode_Organization(String Code_Organization) {
		setValue("Code_Organization", Code_Organization);
	}

	/**
	 * 郵便番号を取得します。
	 * 
	 * @return 郵便番号
	 */
	public String getID_Postcode() {
		return (String) getValue("ID_Postcode");
	}

	/**
	 * 郵便番号を設定します。
	 * 
	 * @param ID_Postcode
	 *            郵便番号
	 */
	public void setID_Postcode(String ID_Postcode) {
		setValue("ID_Postcode", ID_Postcode);
	}

	/**
	 * 都道府県名を取得します。
	 * 
	 * @return 都道府県名
	 */
	public String getName_Todofuken() {
		return (String) getValue("Name_Todofuken");
	}

	/**
	 * 都道府県名を設定します。
	 * 
	 * @param Name_Todofuken
	 *            都道府県名
	 */
	public void setName_Todofuken(String Name_Todofuken) {
		setValue("Name_Todofuken", Name_Todofuken);
	}

	/**
	 * 市区郡町村名を取得します。
	 * 
	 * @return 市区郡町村名
	 */
	public String getName_Shikugunchoson() {
		return (String) getValue("Name_Shikugunchoson");
	}

	/**
	 * 市区郡町村名を設定します。
	 * 
	 * @param Name_Shikugunchoson
	 *            市区郡町村名
	 */
	public void setName_Shikugunchoson(String Name_Shikugunchoson) {
		setValue("Name_Shikugunchoson", Name_Shikugunchoson);
	}

	/**
	 * 大字通称名を取得します。
	 * 
	 * @return 大字通称名
	 */
	public String getName_OazaTsusho() {
		return (String) getValue("Name_OazaTsusho");
	}

	/**
	 * 大字通称名を設定します。
	 * 
	 * @param Name_OazaTsusho
	 *            大字通称名
	 */
	public void setName_OazaTsusho(String Name_OazaTsusho) {
		setValue("Name_OazaTsusho", Name_OazaTsusho);
	}

	/**
	 * 字名丁目を取得します。
	 * 
	 * @return 字名丁目
	 */
	public String getName_AzameiChome() {
		return (String) getValue("Name_AzameiChome");
	}

	/**
	 * 字名丁目を設定します。
	 * 
	 * @param Name_AzameiChome
	 *            字名丁目
	 */
	public void setName_AzameiChome(String Name_AzameiChome) {
		setValue("Name_AzameiChome", Name_AzameiChome);
	}

}