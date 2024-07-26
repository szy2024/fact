//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr009_01のDTOクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr009_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店名 */
    private String txtID_Name_Organization;
    /** 公庫支店 */
    private String txtID_Code_ShokanHonShiten;
    /** 扱店 */
    private String txtID_Code_Organization;
    /** 店舗 */
    private String txtID_Code_Tenpo;
    /** 検索結果件数 */
    private int recCount;
    /** 受託者勘定処理年月設定モード */
    private String lblID_JtkshoriConfigMode;
    /** 業務日付（元号） */
    private String lblID_BizDate_Gengo;
    /** 業務日付（年） */
    private String lblID_BizDate_Nen;
    /** 業務日付（月） */
    private String lblID_BizDate_Tsuki;
    /** 前月業務日付（元号） */
    private String lblID_BizDate_PrevMonth_Gengo;
    /** 前月業務日付（年） */
    private String lblID_BizDate_PrevMonth_Nen;
    /** 前月業務日付（月） */
    private String lblID_BizDate_PrevMonth_Tsuki;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr009_01DTO() {
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
    public Cr009_01DTO(Cr009_01DTO orig) {
        super(orig);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getTxtID_Name_Organization() {
        return txtID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param txtID_Name_Organization 扱店名
     */
    public void setTxtID_Name_Organization(String txtID_Name_Organization) {
        this.txtID_Name_Organization = txtID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getTxtID_Code_ShokanHonShiten() {
        return txtID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param txtID_Code_ShokanHonShiten 公庫支店
     */
    public void setTxtID_Code_ShokanHonShiten(String txtID_Code_ShokanHonShiten) {
        this.txtID_Code_ShokanHonShiten = txtID_Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param txtID_Code_Organization 扱店
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param txtID_Code_Tenpo 店舗
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 検索結果件数を取得します。
     *
     * @return 検索結果件数
     */
    public int getRecCount() {
        return recCount;
    }

    /**
     * 検索結果件数を設定します。
     * @param recCount 検索結果件数
     */
    public void setRecCount(int recCount) {
        this.recCount = recCount;
    }

    /**
     * 受託者勘定処理年月設定モードを取得します。
     * @return 受託者勘定処理年月設定モード
     */
    public String getLblID_JtkshoriConfigMode() {
        return lblID_JtkshoriConfigMode;
    }

    /**
     * 受託者勘定処理年月設定モードを設定します。
     * @param lblID_JtkshoriConfigMode 受託者勘定処理年月設定モード
     */
    public void setLblID_JtkshoriConfigMode(String lblID_JtkshoriConfigMode) {
        this.lblID_JtkshoriConfigMode = lblID_JtkshoriConfigMode;
    }

    /**
     * 業務日付（元号）を取得します。
     * @return 業務日付（元号）
     */
    public String getLblID_BizDate_Gengo() {
        return lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（元号）を設定します。
     * @param lblID_BizDate_Gengo 業務日付（元号）
     */
    public void setLblID_BizDate_Gengo(String lblID_BizDate_Gengo) {
        this.lblID_BizDate_Gengo = lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（年）を取得します。
     * @return 業務日付（年）
     */
    public String getLblID_BizDate_Nen() {
        return lblID_BizDate_Nen;
    }

    /**
     * 業務日付（年）を設定します。
     * @param lblID_BizDate_Nen 業務日付（年）
     */
    public void setLblID_BizDate_Nen(String lblID_BizDate_Nen) {
        this.lblID_BizDate_Nen = lblID_BizDate_Nen;
    }

    /**
     * 業務日付（月）を取得します。
     * @return 業務日付（月）
     */
    public String getLblID_BizDate_Tsuki() {
        return lblID_BizDate_Tsuki;
    }

    /**
     * 業務日付（月）を設定します。
     * @param lblID_BizDate_Tsuki 業務日付（月）
     */
    public void setLblID_BizDate_Tsuki(String lblID_BizDate_Tsuki) {
        this.lblID_BizDate_Tsuki = lblID_BizDate_Tsuki;
    }

    /**
     * 前月業務日付（元号）を取得します。
     * @return 前月業務日付（元号）
     */
    public String getLblID_BizDate_PrevMonth_Gengo() {
        return lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（元号）を設定します。
     * @param lblID_BizDate_PrevMonth_Gengo 前月業務日付（元号）
     */
    public void setLblID_BizDate_PrevMonth_Gengo(String lblID_BizDate_PrevMonth_Gengo) {
        this.lblID_BizDate_PrevMonth_Gengo = lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（年）を取得します。
     * @return 前月業務日付（年）
     */
    public String getLblID_BizDate_PrevMonth_Nen() {
        return lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（年）を設定します。
     * @param lblID_BizDate_PrevMonth_Nen 前月業務日付（年）
     */
    public void setLblID_BizDate_PrevMonth_Nen(String lblID_BizDate_PrevMonth_Nen) {
        this.lblID_BizDate_PrevMonth_Nen = lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（月）を取得します。
     * @return 前月業務日付（月）
     */
    public String getLblID_BizDate_PrevMonth_Tsuki() {
        return lblID_BizDate_PrevMonth_Tsuki;
    }

    /**
     * 前月業務日付（月）を設定します。
     * @param lblID_BizDate_PrevMonth_Tsuki 前月業務日付（月）
     */
    public void setLblID_BizDate_PrevMonth_Tsuki(String lblID_BizDate_PrevMonth_Tsuki) {
        this.lblID_BizDate_PrevMonth_Tsuki = lblID_BizDate_PrevMonth_Tsuki;
    }

}