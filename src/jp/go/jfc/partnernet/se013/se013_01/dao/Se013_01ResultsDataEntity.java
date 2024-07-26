//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe013_01ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se013_01ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 検索開始年月を取得します。
     * @return 検索開始年月
     */
    public String getSearch_start_date() {
        return (String)getValue("SEARCH_START_DATE");
    }

    /**
     * 検索開始年月を設定します。
     * @param search_start_date 検索開始年月
     */
    public void setSearch_start_date(String search_start_date) {
        setValue("SEARCH_START_DATE", search_start_date);
    }

    /**
     * 検索終了年月を取得します。
     * @return 検索終了年月
     */
    public String getSearch_end_date() {
        return (String)getValue("SEARCH_END_DATE");
    }

    /**
     * 検索終了年月を設定します。
     * @param search_end_date 検索終了年月
     */
    public void setSearch_end_date(String search_end_date) {
        setValue("SEARCH_END_DATE", search_end_date);
    }

    /**
     * 未加盟店検索を取得します。
     *
     * @return 未加盟店検索
     */
    public String getSearch_mikameiten() {
        return (String)getValue("SEARCH_MIKAMEITEN");
    }

    /**
     * 未加盟店検索を設定します。
     *
     * @param search_mikameiten
     *            未加盟店検索
     */
    public void setSearch_mikameiten(String search_mikameiten) {
        setValue("SEARCH_MIKAMEITEN", search_mikameiten);
    }

    /**
     * 業務日付を取得します。
     *
     * @return 業務日付
     */
    public String getDate_business() {
        return (String)getValue("Date_Business");
    }

    /**
     * 業務日付を設定します。
     *
     * @param date_business
     *            業務日付
     */
    public void setDate_business(String date_business) {
        setValue("Date_Business", date_business);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     * @param code_organization 扱店コード
     */
    public void setCode_organization(String code_organization) {
        setValue("Code_Organization", code_organization);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 扱店名を設定します。
     * @param name_organization 扱店名
     */
    public void setName_organization(String name_organization) {
        setValue("Name_Organization", name_organization);
    }

    /**
     * 対象年月を取得します。
     * @return 対象年月
     */
    public String getDate_taisho() {
        return (String)getValue("Date_Taisho");
    }

    /**
     * 対象年月を設定します。
     * @param date_taisho 対象年月
     */
    public void setDate_taisho(String date_taisho) {
        setValue("Date_Taisho", date_taisho);
    }

    /**
     * 情報提供日を取得します。
     * @return 情報提供日
     */
    public String getDate_jyohoteikyo() {
        return (String)getValue("Date_JyohoTeikyo");
    }

    /**
     * 情報提供日を設定します。
     * @param date_jyohoteikyo 情報提供日
     */
    public void setDate_jyohoteikyo(String date_jyohoteikyo) {
        setValue("Date_JyohoTeikyo", date_jyohoteikyo);
    }

    /**
     * 表示ファイル名を取得します。
     * @return 表示ファイル名
     */
    public String getDisp_docname() {
        return (String)getValue("Disp_DocName");
    }

    /**
     * 表示ファイル名を設定します。
     * @param disp_docname 表示ファイル名
     */
    public void setDisp_docname(String disp_docname) {
        setValue("Disp_DocName", disp_docname);
    }

    /**
     * ファイル名を取得します。
     * @return ファイル名
     */
    public String getDocname() {
        return (String)getValue("DocName");
    }

    /**
     * ファイル名を設定します。
     * @param docname ファイル名
     */
    public void setDocname(String docname) {
        setValue("DocName", docname);
    }

    /**
     * ファイルパスを取得します。
     * @return ファイルパス
     */
    public String getFilepath() {
        return (String)getValue("FilePath");
    }

    /**
     * ファイルパスを設定します。
     * @param filepath ファイルパス
     */
    public void setFilepath(String filepath) {
        setValue("FilePath", filepath);
    }

    /**
     * 帳票種別を取得します。
     * @return 帳票種別
     */
    public String getDoctype() {
        return (String)getValue("DocType");
    }

    /**
     * 帳票種別を設定します。
     * @param doctype 帳票種別
     */
    public void setDoctype(String doctype) {
        setValue("DocType", doctype);
    }

}