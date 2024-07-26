//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr001_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr001_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** ステータス */
    private String lblError;
    /** 明細リスト */
    private java.util.List<Cr001_01M1DTO> MEISAI_LIST = new java.util.ArrayList<Cr001_01M1DTO>(
            0);
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
    public Cr001_01DTO() {
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
    public Cr001_01DTO(Cr001_01DTO orig) {
        super(orig);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getTxtID_Date_Report() {
        return txtID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param txtID_Date_Report
     *            報告年月日
     */
    public void setTxtID_Date_Report(String txtID_Date_Report) {
        this.txtID_Date_Report = txtID_Date_Report;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     *
     * @param lblError
     *            ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public java.util.List<Cr001_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param MEISAI_LIST
     *            明細リスト
     */
    public void setMEISAI_LIST(java.util.List<Cr001_01M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }

    /**
     * 受託者勘定処理年月設定モードを取得します。
     *
     * @return 受託者勘定処理年月設定モード
     */
    public String getLblID_JtkshoriConfigMode() {
        return lblID_JtkshoriConfigMode;
    }

    /**
     * 受託者勘定処理年月設定モードを設定します。
     *
     * @param lblID_JtkshoriConfigMode 受託者勘定処理年月設定モード
     */
    public void setLblID_JtkshoriConfigMode(String lblID_JtkshoriConfigMode) {
        this.lblID_JtkshoriConfigMode = lblID_JtkshoriConfigMode;
    }

    /**
     * 業務日付（元号）を取得します。
     *
     * @return 業務日付（元号）
     */
    public String getLblID_BizDate_Gengo() {
        return lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（元号）を設定します。
     *
     * @param lblID_BizDate_Gengo 業務日付（元号）
     */
    public void setLblID_BizDate_Gengo(String lblID_BizDate_Gengo) {
        this.lblID_BizDate_Gengo = lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（年）を取得します。
     *
     * @return 業務日付（年）
     */
    public String getLblID_BizDate_Nen() {
        return lblID_BizDate_Nen;
    }

    /**
     * 業務日付（年）を設定します。
     *
     * @param lblID_BizDate_Nen 業務日付（年）
     */
    public void setLblID_BizDate_Nen(String lblID_BizDate_Nen) {
        this.lblID_BizDate_Nen = lblID_BizDate_Nen;
    }

    /**
     * 業務日付（月）を取得します。
     *
     * @return 業務日付（月）
     */
    public String getLblID_BizDate_Tsuki() {
        return lblID_BizDate_Tsuki;
    }

    /**
     * 業務日付（月）を設定します。
     *
     * @param lblID_BizDate_Tsuki 業務日付（月）
     */
    public void setLblID_BizDate_Tsuki(String lblID_BizDate_Tsuki) {
        this.lblID_BizDate_Tsuki = lblID_BizDate_Tsuki;
    }

    /**
     * 前月業務日付（元号）を取得します。
     *
     * @return 前月業務日付（元号）
     */
    public String getLblID_BizDate_PrevMonth_Gengo() {
        return lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（元号）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Gengo 前月業務日付（元号）
     */
    public void setLblID_BizDate_PrevMonth_Gengo(String lblID_BizDate_PrevMonth_Gengo) {
        this.lblID_BizDate_PrevMonth_Gengo = lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（年）を取得します。
     *
     * @return 前月業務日付（年）
     */
    public String getLblID_BizDate_PrevMonth_Nen() {
        return lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（年）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Nen 前月業務日付（年）
     */
    public void setLblID_BizDate_PrevMonth_Nen(String lblID_BizDate_PrevMonth_Nen) {
        this.lblID_BizDate_PrevMonth_Nen = lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（月）を取得します。
     *
     * @return 前月業務日付（月）
     */
    public String getLblID_BizDate_PrevMonth_Tsuki() {
        return lblID_BizDate_PrevMonth_Tsuki;
    }

    /**
     * 前月業務日付（月）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Tsuki 前月業務日付（月）
     */
    public void setLblID_BizDate_PrevMonth_Tsuki(String lblID_BizDate_PrevMonth_Tsuki) {
        this.lblID_BizDate_PrevMonth_Tsuki = lblID_BizDate_PrevMonth_Tsuki;
    }
}