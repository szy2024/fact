//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse012_01のDTOクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se012_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店 */
    private String lblid_code_organization;
    /** 扱店名 */
    private String lblid_name_organization;
    /** 店舗 */
    private String lblid_code_tenpo;
    /** 店舗名 */
    private String lblid_name_tenpo;
    /** 対象年月 */
    private String ancid_date_taisho;
    /** 情報提供日 */
    private String lblid_date_jyohoteikyo;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se012_01M1DTO() {
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
    public Se012_01M1DTO(Se012_01M1DTO orig) {
        super(orig);
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getLblid_code_organization() {
        return lblid_code_organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param lblid_code_organization
     *            扱店
     */
    public void setLblid_code_organization(String lblid_code_organization) {
        this.lblid_code_organization = lblid_code_organization;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getLblid_name_organization() {
        return lblid_name_organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblid_name_organization
     *            扱店名
     */
    public void setLblid_name_organization(String lblid_name_organization) {
        this.lblid_name_organization = lblid_name_organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getLblid_code_tenpo() {
        return lblid_code_tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param lblid_code_tenpo
     *            店舗
     */
    public void setLblid_code_tenpo(String lblid_code_tenpo) {
        this.lblid_code_tenpo = lblid_code_tenpo;
    }

    /**
     * 店舗名を取得します。
     *
     * @return 店舗名
     */
    public String getLblid_name_tenpo() {
        return lblid_name_tenpo;
    }

    /**
     * 店舗名を設定します。
     *
     * @param lblid_name_tenpo
     *            店舗名
     */
    public void setLblid_name_tenpo(String lblid_name_tenpo) {
        this.lblid_name_tenpo = lblid_name_tenpo;
    }

    /**
     * 対象年月を取得します。
     *
     * @return 対象年月
     */
    public String getAncid_date_taisho() {
        return ancid_date_taisho;
    }

    /**
     * 対象年月を設定します。
     *
     * @param ancid_date_taisho
     *            対象年月
     */
    public void setAncid_date_taisho(String ancid_date_taisho) {
        this.ancid_date_taisho = ancid_date_taisho;
    }

    /**
     * 情報提供日を取得します。
     *
     * @return 情報提供日
     */
    public String getLblid_date_jyohoteikyo() {
        return lblid_date_jyohoteikyo;
    }

    /**
     * 情報提供日を設定します。
     *
     * @param lblid_date_jyohoteikyo
     *            情報提供日
     */
    public void setLblid_date_jyohoteikyo(String lblid_date_jyohoteikyo) {
        this.lblid_date_jyohoteikyo = lblid_date_jyohoteikyo;
    }

}