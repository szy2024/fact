//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_06Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_06.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr008_06のFormクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_06Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店コード */
    private String Cr008_06_In_Code_ShokanHonShiten;
    /** 扱店コード */
    private String Cr008_06_In_Code_Organization;
    /** 店舗コード */
    private String Cr008_06_In_Code_Tenpo;
    /** 年度 */
    private String Cr008_06_In_Year;
    /** 方式資金 */
    private String Cr008_06_In_Kubun_HoshikiShikin;
    /** 番号 */
    private String Cr008_06_In_ID_Ringi;
    /** 枝番 */
    private String Cr008_06_In_ID_RingiBranch;
    /** 債権管理番号 */
    private String Cr008_06_In_ID_Credit;

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getCr008_06_In_Code_ShokanHonShiten() {
        return Cr008_06_In_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コードを設定します。
     * @param Cr008_06_In_Code_ShokanHonShiten 公庫支店コード
     */
    public void setCr008_06_In_Code_ShokanHonShiten(String Cr008_06_In_Code_ShokanHonShiten) {
        this.Cr008_06_In_Code_ShokanHonShiten = Cr008_06_In_Code_ShokanHonShiten;
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCr008_06_In_Code_Organization() {
        return Cr008_06_In_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param Cr008_06_In_Code_Organization 扱店コード
     */
    public void setCr008_06_In_Code_Organization(String Cr008_06_In_Code_Organization) {
        this.Cr008_06_In_Code_Organization = Cr008_06_In_Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCr008_06_In_Code_Tenpo() {
        return Cr008_06_In_Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param Cr008_06_In_Code_Tenpo 店舗コード
     */
    public void setCr008_06_In_Code_Tenpo(String Cr008_06_In_Code_Tenpo) {
        this.Cr008_06_In_Code_Tenpo = Cr008_06_In_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getCr008_06_In_Year() {
        return Cr008_06_In_Year;
    }

    /**
     * 年度を設定します。
     * @param Cr008_06_In_Year 年度
     */
    public void setCr008_06_In_Year(String Cr008_06_In_Year) {
        this.Cr008_06_In_Year = Cr008_06_In_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getCr008_06_In_Kubun_HoshikiShikin() {
        return Cr008_06_In_Kubun_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param Cr008_06_In_Kubun_HoshikiShikin 方式資金
     */
    public void setCr008_06_In_Kubun_HoshikiShikin(String Cr008_06_In_Kubun_HoshikiShikin) {
        this.Cr008_06_In_Kubun_HoshikiShikin = Cr008_06_In_Kubun_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getCr008_06_In_ID_Ringi() {
        return Cr008_06_In_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param Cr008_06_In_ID_Ringi 番号
     */
    public void setCr008_06_In_ID_Ringi(String Cr008_06_In_ID_Ringi) {
        this.Cr008_06_In_ID_Ringi = Cr008_06_In_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getCr008_06_In_ID_RingiBranch() {
        return Cr008_06_In_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param Cr008_06_In_ID_RingiBranch 枝番
     */
    public void setCr008_06_In_ID_RingiBranch(String Cr008_06_In_ID_RingiBranch) {
        this.Cr008_06_In_ID_RingiBranch = Cr008_06_In_ID_RingiBranch;
    }

    /**
     * <pre>
     * 債権管理番号を取得します。
     * </pre>
     *
     * @return 債権管理番号
     */
    public String getCr008_06_In_ID_Credit() {
        return Cr008_06_In_ID_Credit;
    }

    /**
     * <pre>
     * 債権管理番号を設定します。
     * </pre>
     *
     * @param Cr008_06_In_ID_Credit 債権管理番号
     */
    public void setCr008_06_In_ID_Credit(String Cr008_06_In_ID_Credit) {
        this.Cr008_06_In_ID_Credit = Cr008_06_In_ID_Credit;
    }

}