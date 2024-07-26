//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : se013_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse013_01のDTOクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se013_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店 */
    private String lblid_code_organization;
    /** 扱店名 */
    private String lblid_name_organization;
    /** 情報提供日 */
    private String lblid_date_jyohoteikyo;
    /** 対象年月 */
    private String lblid_date_taisho;
    /** 表示ファイル名 */
    private String lblid_disp_docname;
    /** ファイル名 */
    private String lblid_docname;
    /** ファイルパス */
    private String lblid_filepath;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se013_01M1DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Se013_01M1DTO(Se013_01M1DTO orig) {
        super(orig);
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblid_code_organization() {
        return lblid_code_organization;
    }

    /**
     * 扱店を設定します。
     * @param lblid_code_organization 扱店
     */
    public void setLblid_code_organization(String lblid_code_organization) {
        this.lblid_code_organization = lblid_code_organization;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblid_name_organization() {
        return lblid_name_organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblid_name_organization 扱店名
     */
    public void setLblid_name_organization(String lblid_name_organization) {
        this.lblid_name_organization = lblid_name_organization;
    }

    /**
     * 情報提供日を取得します。
     * @return 情報提供日
     */
    public String getLblid_date_jyohoteikyo() {
        return lblid_date_jyohoteikyo;
    }

    /**
     * 情報提供日を設定します。
     * @param lblid_date_jyohoteikyo 情報提供日
     */
    public void setLblid_date_jyohoteikyo(String lblid_date_jyohoteikyo) {
        this.lblid_date_jyohoteikyo = lblid_date_jyohoteikyo;
    }

    /**
     * 対象年月を取得します。
     * @return 対象年月
     */
    public String getLblid_date_taisho() {
        return lblid_date_taisho;
    }

    /**
     * 対象年月を設定します。
     * @param lblid_date_taisho 対象年月
     */
    public void setLblid_date_taisho(String lblid_date_taisho) {
        this.lblid_date_taisho = lblid_date_taisho;
    }

    /**
     * 表示ファイル名を取得します。
     * @return 表示ファイル名
     */
    public String getLblid_disp_docname() {
        return lblid_disp_docname;
    }

    /**
     * 表示ファイル名を設定します。
     * @param lblid_disp_docname 表示ファイル名
     */
    public void setLblid_disp_docname(String lblid_disp_docname) {
        this.lblid_disp_docname = lblid_disp_docname;
    }

    /**
     * ファイル名を取得します。
     * @return ファイル名
     */
    public String getLblid_docname() {
        return lblid_docname;
    }

    /**
     * ファイル名を設定します。
     * @param lblid_docname ファイル名
     */
    public void setLblid_docname(String lblid_docname) {
        this.lblid_docname = lblid_docname;
    }

    /**
     * ファイルパスを取得します。
     * @return ファイルパス
     */
    public String getLblid_filepath() {
        return lblid_filepath;
    }

    /**
     * ファイルパスを設定します。
     * @param lblid_filepath ファイルパス
     */
    public void setLblid_filepath(String lblid_filepath) {
        this.lblid_filepath = lblid_filepath;
    }

}