//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはCr003_01のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 元号 */
    private String drpID_Date_Haraikomi_Year;
    /** 年 */
    private String txtID_Date_Haraikomi;
    /** 月 */
    private String drpID_Date_Haraikomi_Month;
    /** 日 */
    private String drpID_Date_Haraikomi_Date;

    /**
     * 元号を取得します。
     * @return 元号
     */
    public String getDrpID_Date_Haraikomi_Year() {
        return drpID_Date_Haraikomi_Year;
    }

    /**
     * 元号を設定します。
     * @param drpID_Date_Haraikomi_Year 元号
     */
    public void setDrpID_Date_Haraikomi_Year(String drpID_Date_Haraikomi_Year) {
        this.drpID_Date_Haraikomi_Year = drpID_Date_Haraikomi_Year;
    }

    /**
     * 年を取得します。
     * @return 年
     */
    public String getTxtID_Date_Haraikomi() {
        return txtID_Date_Haraikomi;
    }

    /**
     * 年を設定します。
     * @param txtID_Date_Haraikomi 年
     */
    public void setTxtID_Date_Haraikomi(String txtID_Date_Haraikomi) {
        this.txtID_Date_Haraikomi = txtID_Date_Haraikomi;
    }

    /**
     * 月を取得します。
     * @return 月
     */
    public String getDrpID_Date_Haraikomi_Month() {
        return drpID_Date_Haraikomi_Month;
    }

    /**
     * 月を設定します。
     * @param drpID_Date_Haraikomi_Month 月
     */
    public void setDrpID_Date_Haraikomi_Month(String drpID_Date_Haraikomi_Month) {
        this.drpID_Date_Haraikomi_Month = drpID_Date_Haraikomi_Month;
    }

    /**
     * 日を取得します。
     * @return 日
     */
    public String getDrpID_Date_Haraikomi_Date() {
        return drpID_Date_Haraikomi_Date;
    }

    /**
     * 日を設定します。
     * @param drpID_Date_Haraikomi_Date 日
     */
    public void setDrpID_Date_Haraikomi_Date(String drpID_Date_Haraikomi_Date) {
        this.drpID_Date_Haraikomi_Date = drpID_Date_Haraikomi_Date;
    }

}