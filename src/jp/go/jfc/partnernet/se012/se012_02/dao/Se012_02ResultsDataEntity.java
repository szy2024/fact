//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe012_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se012_02ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param code_tenpo 店舗コード
     */
    public void setCode_tenpo(String code_tenpo) {
        setValue("Code_Tenpo", code_tenpo);
    }

    /**
     * H金融機関コードを取得します。
     * @return H金融機関コード
     */
    public String getCode_h_oraganization() {
        return (String)getValue("Code_H_Oraganization");
    }

    /**
     * H金融機関コードを設定します。
     * @param code_h_oraganization H金融機関コード
     */
    public void setCode_h_oraganization(String code_h_oraganization) {
        setValue("Code_H_Oraganization", code_h_oraganization);
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