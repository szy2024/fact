//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.web;

import java.util.List;

import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはCr001_01のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr001_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 貸付実行報告書一覧 */
    private PNPagingTable<Cr001_01M1DTO> Cr001_01M1Table = new PNPagingTableSerial<Cr001_01M1DTO>(
            "Cr001_01M1Table");
    // private PNPagingTable<Cr001_01M1DTO> Cr001_01M1Table
    // = new PNPagingTableMemory<Cr001_01M1DTO>("Cr001_01M1Table");

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** ステータス */
    private String lblError;
    /** ステータス2 */
    private String lblMessage;
    /** 明細リスト */
    private List<Cr001_01M1DTO> MEISAI_LIST;
    /** greetingメッセージ1行目 */
    private String lblDataMsg = "登録予定案件の一覧です。今回報告する案件の「選択」チェックボックスをチェックし、<br>必要な項目を入力したうえで「送信」ボタンを押してください。";
    /** greetingメッセージ空行 */
    private String lblBR = "";
    /** greetingメッセージ2行目 */
    private String lblDataMsg2 = "なお、「利率」については、貸付実行日をもとに自動計算するため入力の必要はありません。<br>自動計算の利率を採用しない場合のみ入力してください。";
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
     * 貸付実行報告書一覧を取得します。
     *
     * @return 貸付実行報告書一覧
     */
    public PNPagingTable<Cr001_01M1DTO> getCr001_01M1Table() {
        return Cr001_01M1Table;
    }

    /**
     * 貸付実行報告書一覧を設定します。
     *
     * @param Cr001_01M1Table 貸付実行報告書一覧
     */
    public void setCr001_01M1Table(PNPagingTable<Cr001_01M1DTO> Cr001_01M1Table) {
        this.Cr001_01M1Table = Cr001_01M1Table;
    }

    /**
     * 貸付実行報告書一覧テーブルレコードを取得します。
     *
     * @return 貸付実行報告書一覧テーブル
     */
    public List<Cr001_01M1DTO> getCr001_01M1TableRecord() {
        return getCr001_01M1Table().getRecordList();
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
     * @param txtID_Date_Report 報告年月日
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
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * ステータス2を取得します。
     *
     * @return ステータス2
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * ステータス2を設定します。
     *
     * @param lblError ステータス2
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public List<Cr001_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param MEISAI_LIST 明細リスト
     */
    public void setMEISAI_LIST(List<Cr001_01M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }

    /**
     * greetingメッセージ1行目を取得します。
     *
     * @return greetingメッセージ1行目
     */
    public String getLblDataMsg() {
        return lblDataMsg;
    }

    /**
     * greetingメッセージ1行目を設定します。
     *
     * @param lblDataMsg greetingメッセージ1行目
     */
    public void setLblDataMsg(String lblDataMsg) {
        this.lblDataMsg = lblDataMsg;
    }

    /**
     * greetingメッセージ空行を取得します。
     *
     * @return greetingメッセージ空行
     */
    public String getLblBR() {
        return lblBR;
    }

    /**
     * greetingメッセージ空行を設定します。
     *
     * @param lblBR greetingメッセージ空行
     */
    public void setLblBR(String lblBR) {
        this.lblBR = lblBR;
    }

    /**
     * greetingメッセージ2行目を取得します。
     *
     * @return greetingメッセージ2行目
     */
    public String getLblDataMsg2() {
        return lblDataMsg2;
    }

    /**
     * greetingメッセージ2行目を設定します。
     *
     * @param lblDataMsg2 greetingメッセージ2行目
     */
    public void setLblDataMsg2(String lblDataMsg2) {
        this.lblDataMsg2 = lblDataMsg2;
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