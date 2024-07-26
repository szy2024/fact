//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import java.util.LinkedHashMap;

/**
 * <pre>
 * このクラスはSe009_01のFormクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店コード */
    private String drpID_Code_ShokanHonShiten;
    /** 扱店コード */
    private String txtID_Code_Organization;
    /** 店舗コード */
    private String txtID_Code_Tenpo;
    /** 年度 */
    private String txtID_Year;
    /** 方式資金 */
    private String txtID_HoshikiShikin;
    /** 番号 */
    private String txtID_ID_Ringi;
    /** 枝番 */
    private String txtID_ID_RingiBranch;
    /** 資金払出または元金充当日(元号) */
    private String ID_SearchStartWareki;
    /** 資金払出または元金充当日(年) */
    private String ID_SearchStartYear;
    /** 資金払出または元金充当日(月) */
    private String ID_SearchStartMonth;
    /** 資金払出または元金充当日(日) */
    private String ID_SearchStartDate;
    /** 資金払出額 */
    private String txtID_M_Haraidashi;
    /** 元金充当額 */
    private String txtID_M_Ganju;
    /** エラーメッセージ */
    private String lblError;
    /** 公庫支店名プルダウンマップ */
    private LinkedHashMap<String, String> koukoShitenCodeNameMap;

    // /** 扱店コード */
    // private String drpID_Code_ShokanHonShiten;
    // /** 公庫支店コード */
    // private String txtID_Code_Organization;
    // /** 店舗コード */
    // private String txtID_Code_Tenpo;
    // /** 年度 */
    // private String txtID_Year;
    // /** 方式資金 */
    // private String txtID_HoshikiShikin;
    // /** 番号 */
    // private String txtID_ID_Ringi;
    // /** 枝番 */
    // private String txtID_ID_RingiBranch;
    // /** 資金払出または元金充当日(元号) */
    // private String ID_SearchStartWareki;
    // /** 資金払出または元金充当日(年) */
    // private String ID_SearchStartYear;
    // /** 資金払出または元金充当日(月) */
    // private String ID_SearchStartMonth;
    // /** 資金払出または元金充当日(日) */
    // private String ID_SearchStartDate;
    // /** 資金払出額 */
    // private String txtID_M_Haraidashi;
    // /** 元金充当額 */
    // private String txtID_M_Ganju;

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getDrpID_Code_ShokanHonShiten() {
        return drpID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コードを設定します。
     * @param drpID_Code_ShokanHonShiten 公庫支店コード
     */
    public void setDrpID_Code_ShokanHonShiten(String drpID_Code_ShokanHonShiten) {
        this.drpID_Code_ShokanHonShiten = drpID_Code_ShokanHonShiten;
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param txtID_Code_Organization 扱店コード
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param txtID_Code_Tenpo 店舗コード
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度を設定します。
     * @param txtID_Year 年度
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getTxtID_HoshikiShikin() {
        return txtID_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_HoshikiShikin 方式資金
     */
    public void setTxtID_HoshikiShikin(String txtID_HoshikiShikin) {
        this.txtID_HoshikiShikin = txtID_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param txtID_ID_Ringi 番号
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param txtID_ID_RingiBranch 枝番
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 資金払出または元金充当日(元号)を取得します。
     * @return 資金払出または元金充当日(元号)
     */
    public String getID_SearchStartWareki() {
        return ID_SearchStartWareki;
    }

    /**
     * 資金払出または元金充当日(元号)を設定します。
     * @param ID_SearchStartWareki 資金払出または元金充当日(元号)
     */
    public void setID_SearchStartWareki(String ID_SearchStartWareki) {
        this.ID_SearchStartWareki = ID_SearchStartWareki;
    }

    /**
     * 資金払出または元金充当日(年)を取得します。
     * @return 資金払出または元金充当日(年)
     */
    public String getID_SearchStartYear() {
        return ID_SearchStartYear;
    }

    /**
     * 資金払出または元金充当日(年)を設定します。
     * @param ID_SearchStartYear 資金払出または元金充当日(年)
     */
    public void setID_SearchStartYear(String ID_SearchStartYear) {
        this.ID_SearchStartYear = ID_SearchStartYear;
    }

    /**
     * 資金払出または元金充当日(月)を取得します。
     * @return 資金払出または元金充当日(月)
     */
    public String getID_SearchStartMonth() {
        return ID_SearchStartMonth;
    }

    /**
     * 資金払出または元金充当日(月)を設定します。
     * @param ID_SearchStartMonth 資金払出または元金充当日(月)
     */
    public void setID_SearchStartMonth(String ID_SearchStartMonth) {
        this.ID_SearchStartMonth = ID_SearchStartMonth;
    }

    /**
     * 資金払出または元金充当日(日)を取得します。
     * @return 資金払出または元金充当日(日)
     */
    public String getID_SearchStartDate() {
        return ID_SearchStartDate;
    }

    /**
     * 資金払出または元金充当日(日)を設定します。
     * @param ID_SearchStartDate 資金払出または元金充当日(日)
     */
    public void setID_SearchStartDate(String ID_SearchStartDate) {
        this.ID_SearchStartDate = ID_SearchStartDate;
    }

    /**
     * 資金払出額を取得します。
     * @return 資金払出額
     */
    public String getTxtID_M_Haraidashi() {
        return txtID_M_Haraidashi;
    }

    /**
     * 資金払出額を設定します。
     * @param txtID_M_Haraidashi 資金払出額
     */
    public void setTxtID_M_Haraidashi(String txtID_M_Haraidashi) {
        this.txtID_M_Haraidashi = txtID_M_Haraidashi;
    }

    /**
     * 元金充当額を取得します。
     * @return 元金充当額
     */
    public String getTxtID_M_Ganju() {
        return txtID_M_Ganju;
    }

    /**
     * 元金充当額を設定します。
     * @param txtID_M_Ganju 元金充当額
     */
    public void setTxtID_M_Ganju(String txtID_M_Ganju) {
        this.txtID_M_Ganju = txtID_M_Ganju;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーメッセージを設定します。
     * @param lblError エラーメッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 公庫支店名プルダウンマップを取得します。
     * @return 公庫支店名プルダウンマップ
     */
    public LinkedHashMap<String, String> getKoukoShitenCodeNameMap() {
        return koukoShitenCodeNameMap;
    }

    /**
     * 公庫支店名プルダウンマップを設定します。
     * @param koukoShitenCodeNameMap 公庫支店名プルダウンマップ
     */
    public void setKoukoShitenCodeNameMap(LinkedHashMap<String, String> koukoShitenCodeNameMap) {
        this.koukoShitenCodeNameMap = koukoShitenCodeNameMap;
    }

    // /**
    // * 扱店コードを取得します。
    // * @return 扱店コード
    // */
    // public String getDrpID_Code_ShokanHonShiten() {
    // return drpID_Code_ShokanHonShiten;
    // }
    //
    // /**
    // * 扱店コードを設定します。
    // * @param drpID_Code_ShokanHonShiten 扱店コード
    // */
    // public void setDrpID_Code_ShokanHonShiten(String drpID_Code_ShokanHonShiten) {
    // this.drpID_Code_ShokanHonShiten = drpID_Code_ShokanHonShiten;
    // }
    //
    // /**
    // * 公庫支店コードを取得します。
    // * @return 公庫支店コード
    // */
    // public String getTxtID_Code_Organization() {
    // return txtID_Code_Organization;
    // }
    //
    // /**
    // * 公庫支店コードを設定します。
    // * @param txtID_Code_Organization 公庫支店コード
    // */
    // public void setTxtID_Code_Organization(String txtID_Code_Organization) {
    // this.txtID_Code_Organization = txtID_Code_Organization;
    // }
    //
    // /**
    // * 店舗コードを取得します。
    // * @return 店舗コード
    // */
    // public String getTxtID_Code_Tenpo() {
    // return txtID_Code_Tenpo;
    // }
    //
    // /**
    // * 店舗コードを設定します。
    // * @param txtID_Code_Tenpo 店舗コード
    // */
    // public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
    // this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    // }
    //
    // /**
    // * 年度を取得します。
    // * @return 年度
    // */
    // public String getTxtID_Year() {
    // return txtID_Year;
    // }
    //
    // /**
    // * 年度を設定します。
    // * @param txtID_Year 年度
    // */
    // public void setTxtID_Year(String txtID_Year) {
    // this.txtID_Year = txtID_Year;
    // }
    //
    // /**
    // * 方式資金を取得します。
    // * @return 方式資金
    // */
    // public String getTxtID_HoshikiShikin() {
    // return txtID_HoshikiShikin;
    // }
    //
    // /**
    // * 方式資金を設定します。
    // * @param txtID_HoshikiShikin 方式資金
    // */
    // public void setTxtID_HoshikiShikin(String txtID_HoshikiShikin) {
    // this.txtID_HoshikiShikin = txtID_HoshikiShikin;
    // }
    //
    // /**
    // * 番号を取得します。
    // * @return 番号
    // */
    // public String getTxtID_ID_Ringi() {
    // return txtID_ID_Ringi;
    // }
    //
    // /**
    // * 番号を設定します。
    // * @param txtID_ID_Ringi 番号
    // */
    // public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
    // this.txtID_ID_Ringi = txtID_ID_Ringi;
    // }
    //
    // /**
    // * 枝番を取得します。
    // * @return 枝番
    // */
    // public String getTxtID_ID_RingiBranch() {
    // return txtID_ID_RingiBranch;
    // }
    //
    // /**
    // * 枝番を設定します。
    // * @param txtID_ID_RingiBranch 枝番
    // */
    // public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
    // this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    // }
    //
    // /**
    // * 資金払出または元金充当日(元号)を取得します。
    // * @return 資金払出または元金充当日(元号)
    // */
    // public String getID_SearchStartWareki() {
    // return ID_SearchStartWareki;
    // }
    //
    // /**
    // * 資金払出または元金充当日(元号)を設定します。
    // * @param ID_SearchStartWareki 資金払出または元金充当日(元号)
    // */
    // public void setID_SearchStartWareki(String ID_SearchStartWareki) {
    // this.ID_SearchStartWareki = ID_SearchStartWareki;
    // }
    //
    // /**
    // * 資金払出または元金充当日(年)を取得します。
    // * @return 資金払出または元金充当日(年)
    // */
    // public String getID_SearchStartYear() {
    // return ID_SearchStartYear;
    // }
    //
    // /**
    // * 資金払出または元金充当日(年)を設定します。
    // * @param ID_SearchStartYear 資金払出または元金充当日(年)
    // */
    // public void setID_SearchStartYear(String ID_SearchStartYear) {
    // this.ID_SearchStartYear = ID_SearchStartYear;
    // }
    //
    // /**
    // * 資金払出または元金充当日(月)を取得します。
    // * @return 資金払出または元金充当日(月)
    // */
    // public String getID_SearchStartMonth() {
    // return ID_SearchStartMonth;
    // }
    //
    // /**
    // * 資金払出または元金充当日(月)を設定します。
    // * @param ID_SearchStartMonth 資金払出または元金充当日(月)
    // */
    // public void setID_SearchStartMonth(String ID_SearchStartMonth) {
    // this.ID_SearchStartMonth = ID_SearchStartMonth;
    // }
    //
    // /**
    // * 資金払出または元金充当日(日)を取得します。
    // * @return 資金払出または元金充当日(日)
    // */
    // public String getID_SearchStartDate() {
    // return ID_SearchStartDate;
    // }
    //
    // /**
    // * 資金払出または元金充当日(日)を設定します。
    // * @param ID_SearchStartDate 資金払出または元金充当日(日)
    // */
    // public void setID_SearchStartDate(String ID_SearchStartDate) {
    // this.ID_SearchStartDate = ID_SearchStartDate;
    // }
    //
    // /**
    // * 資金払出額を取得します。
    // * @return 資金払出額
    // */
    // public String getTxtID_M_Haraidashi() {
    // return txtID_M_Haraidashi;
    // }
    //
    // /**
    // * 資金払出額を設定します。
    // * @param txtID_M_Haraidashi 資金払出額
    // */
    // public void setTxtID_M_Haraidashi(String txtID_M_Haraidashi) {
    // this.txtID_M_Haraidashi = txtID_M_Haraidashi;
    // }
    //
    // /**
    // * 元金充当額を取得します。
    // * @return 元金充当額
    // */
    // public String getTxtID_M_Ganju() {
    // return txtID_M_Ganju;
    // }
    //
    // /**
    // * 元金充当額を設定します。
    // * @param txtID_M_Ganju 元金充当額
    // */
    // public void setTxtID_M_Ganju(String txtID_M_Ganju) {
    // this.txtID_M_Ganju = txtID_M_Ganju;
    // }

}