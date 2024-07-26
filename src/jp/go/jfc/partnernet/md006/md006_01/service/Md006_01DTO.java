//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 矢嶋　洋              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはmd006_01のDTOクラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
public class Md006_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 顧客名 */
    private String txtID_Name_Customer_Red;
    /** 扱店名 */
    private String txtID_Name_Organization_Red;
    /** 公庫支店 */
    private String txtID_Code_KoukoShiten_Red;
    /** 扱店 */
    private String txtID_Code_Organization_Red;
    /** 店舗 */
    private String txtID_Code_Tenpo_Red;
    /** 年度 */
    private String txtID_Year_Red;
    /** 方式資金 */
    private String txtID_Code_HoshikiShikin_Red;
    /** 番号 */
    private String txtID_ID_Ringi_Red;
    /** 枝番 */
    private String txtID_ID_RingiBranch_Red;
    /** 入金日 */
    private String txtID_Date_Nyukin_Red;
    /** 立替金利息(円) */
    private java.math.BigDecimal txtID_M_TatekaeRisoku_Red;
    /** 立替金(円) */
    private java.math.BigDecimal txtID_M_Tatekae_Red;
    /** 仮受金(一般口)からの充当額(円) */
    private java.math.BigDecimal txtID_M_KariukeIppanJuto_Red;
    /** 立替金の種類 */
    private String txtID_Code_TatekaekinShurui_Red;
    /** 公庫立替日 */
    private String txtID_Date_KoukoTatekae_Red;
    /** 計(円) */
    private java.math.BigDecimal txtID_M_Kei_Red;
    /** 送金額(円) */
    private java.math.BigDecimal txtID_M_Sokin_Red;
    /** 受入後立替金残高(円) */
    private java.math.BigDecimal txtID_M_TatekaeZanAfterUkeire_Red;
    /** 受託者勘定処理年月 */
    private String txtID_Date_Jtkshori_Red;
    /** 送金日 */
    private String txtID_Date_Sokin_Red;
    /** 送金日番号 */
    private String txtID_ID_Sokinbi_Red;
    /** 受託者勘定処理年月(元号) */
    private String drpID_Date_Jtkshori_Gengou_Red;
    /** 受託者勘定処理年月(年) */
    private String txtID_Date_Jtkshori_Year_Red;
    /** 受託者勘定処理年月(月) */
    private String drpID_Date_Jtkshori_Month_Red;
    /** 顧客名（修正） */
    private String txtID_Name_Customer;
    /** 扱店名（修正） */
    private String txtID_Name_Organization;
    /** 公庫支店（修正） */
    private String txtID_Code_KoukoShiten;
    /** 扱店（修正） */
    private String txtID_Code_Organization;
    /** 店舗（修正） */
    private String txtID_Code_Tenpo;
    /** 年度（修正） */
    private String txtID_Year;
    /** 方式資金（修正） */
    private String txtID_Code_HoshikiShikin;
    /** 番号（修正） */
    private String txtID_ID_Ringi;
    /** 枝番（修正） */
    private String txtID_ID_RingiBranch;
    /** 入金日(元号)（修正） */
    private String drpID_Date_Nyukin_Gengou;
    /** 入金日(年)（修正） */
    private String txtID_Date_Nyukin_Year;
    /** 入金日(月)（修正） */
    private String drpID_Date_Nyukin_Month;
    /** 入金日(日)（修正） */
    private String drpID_Date_Nyukin_Day;
    /** 立替金利息(円)（修正） */
    private java.math.BigDecimal txtID_M_TatekaeRisoku;
    /** 立替金(円)（修正） */
    private java.math.BigDecimal txtID_M_Tatekae;
    /** 仮受金(一般口)からの充当額(円)（修正） */
    private java.math.BigDecimal txtID_M_KariukeIppanJuto;
    /** 立替金の種類（修正） */
    private String txtID_Code_TatekaekinShurui;
    /** 公庫立替日（修正） */
    private String txtID_Date_KoukoTatekae;
    /** 計(円)（修正） */
    private java.math.BigDecimal txtID_M_Kei;
    /** 送金額(円)（修正） */
    private java.math.BigDecimal txtID_M_Sokin;
    /** 受入後立替金残高(円)（修正） */
    private java.math.BigDecimal txtID_M_TatekaeZanAfterUkeire;
    /** 受託者勘定処理年月（修正） */
    private String txtID_Date_Jtkshori;
    /** 送金日(元号)（修正）（修正） */
    private String drpID_Date_Sokin_Gengou;
    /** 送金日(年)（修正） */
    private String txtID_Date_Sokin_Year;
    /** 送金日(月)（修正） */
    private String drpID_Date_Sokin_Month;
    /** 送金日(日)（修正） */
    private String drpID_Date_Sokin_Day;
    /** 送金日番号（修正） */
    private String txtID_ID_Sokinbi;
    /** 受託者勘定処理年月(元号)（修正） */
    private String drpID_Date_Jtkshori_Gengou;
    /** 受託者勘定処理年月(年)（修正） */
    private String txtID_Date_Jtkshori_Year;
    /** 受託者勘定処理年月(月)（修正） */
    private String drpID_Date_Jtkshori_Month;
    /** 処理モード */
    private String processMode;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** 報告書種別（値） */
    private String ID_DataCode;
    /** ステータス */
    private java.math.BigDecimal ID_Status;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** ユーザーID */
    private String UserID;
    /** 伝送番号 */
    private String ID_Denso;
    /** データコード */
    private String DataCode;
    /** 履歴番号 */
    private String ID_History;
    /** 処理種別 */
    private String TypeProcess;
    /** 取消済フラグ */
    private java.math.BigDecimal Flag_Torikeshizumi;
    /** エラーコード */
    private String Code_Error;
    /** エラーメッセージ */
    private String ErrorMessage;
    /** 原本番号 */
    private String ID_Master;
    /** 債権管理番号 */
    private java.math.BigDecimal ID_Credit;
    /** 退避履歴番号 */
    private String Keep_ID_History;
    /** 退避貸付実行報告書作成済みフラグ */
    private java.math.BigDecimal Keep_Flag_Kj;
    /** 退避受入後立替金残高（修正） */
    private java.math.BigDecimal Keep_M_TatekaeZanAfterUkeire;
    /** 最新更新日時 */
    private java.util.Date Data_LastUpDate;
    /** 退避仮受仮払番号 */
    private String Keep_ID_Karibarai;
    /** 退避本支店コード */
    private String Keep_Code_HonShiten;
    /** 受入後立替金残高明細 */
    private java.math.BigDecimal ID_Meisai_M_KaribaraiZanAfterSeisan;
    /** 仮受仮払精算後残高 */
    private java.math.BigDecimal ID_M_KaribaraiZanAfterSeisan;
    /** 仮受仮払番号 */
    private String ID_Karibarai;
    /** 仮受仮払年月日 */
    private String Date_Karibarai;
    /** 取得データ件数 */
    private int RecordCount;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md006_01DTO() {
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
    public Md006_01DTO(Md006_01DTO orig) {
        super(orig);
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getTxtID_Name_Customer_Red() {
        return txtID_Name_Customer_Red;
    }

    /**
     * 顧客名を設定します。
     * @param txtID_Name_Customer_Red 顧客名
     */
    public void setTxtID_Name_Customer_Red(String txtID_Name_Customer_Red) {
        this.txtID_Name_Customer_Red = txtID_Name_Customer_Red;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getTxtID_Name_Organization_Red() {
        return txtID_Name_Organization_Red;
    }

    /**
     * 扱店名を設定します。
     * @param txtID_Name_Organization_Red 扱店名
     */
    public void setTxtID_Name_Organization_Red(String txtID_Name_Organization_Red) {
        this.txtID_Name_Organization_Red = txtID_Name_Organization_Red;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getTxtID_Code_KoukoShiten_Red() {
        return txtID_Code_KoukoShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     * @param txtID_Code_KoukoShiten_Red 公庫支店
     */
    public void setTxtID_Code_KoukoShiten_Red(String txtID_Code_KoukoShiten_Red) {
        this.txtID_Code_KoukoShiten_Red = txtID_Code_KoukoShiten_Red;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getTxtID_Code_Organization_Red() {
        return txtID_Code_Organization_Red;
    }

    /**
     * 扱店を設定します。
     * @param txtID_Code_Organization_Red 扱店
     */
    public void setTxtID_Code_Organization_Red(String txtID_Code_Organization_Red) {
        this.txtID_Code_Organization_Red = txtID_Code_Organization_Red;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getTxtID_Code_Tenpo_Red() {
        return txtID_Code_Tenpo_Red;
    }

    /**
     * 店舗を設定します。
     * @param txtID_Code_Tenpo_Red 店舗
     */
    public void setTxtID_Code_Tenpo_Red(String txtID_Code_Tenpo_Red) {
        this.txtID_Code_Tenpo_Red = txtID_Code_Tenpo_Red;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getTxtID_Year_Red() {
        return txtID_Year_Red;
    }

    /**
     * 年度を設定します。
     * @param txtID_Year_Red 年度
     */
    public void setTxtID_Year_Red(String txtID_Year_Red) {
        this.txtID_Year_Red = txtID_Year_Red;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getTxtID_Code_HoshikiShikin_Red() {
        return txtID_Code_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_Code_HoshikiShikin_Red 方式資金
     */
    public void setTxtID_Code_HoshikiShikin_Red(String txtID_Code_HoshikiShikin_Red) {
        this.txtID_Code_HoshikiShikin_Red = txtID_Code_HoshikiShikin_Red;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getTxtID_ID_Ringi_Red() {
        return txtID_ID_Ringi_Red;
    }

    /**
     * 番号を設定します。
     * @param txtID_ID_Ringi_Red 番号
     */
    public void setTxtID_ID_Ringi_Red(String txtID_ID_Ringi_Red) {
        this.txtID_ID_Ringi_Red = txtID_ID_Ringi_Red;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch_Red() {
        return txtID_ID_RingiBranch_Red;
    }

    /**
     * 枝番を設定します。
     * @param txtID_ID_RingiBranch_Red 枝番
     */
    public void setTxtID_ID_RingiBranch_Red(String txtID_ID_RingiBranch_Red) {
        this.txtID_ID_RingiBranch_Red = txtID_ID_RingiBranch_Red;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getTxtID_Date_Nyukin_Red() {
        return txtID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     * @param txtID_Date_Nyukin_Red 入金日
     */
    public void setTxtID_Date_Nyukin_Red(String txtID_Date_Nyukin_Red) {
        this.txtID_Date_Nyukin_Red = txtID_Date_Nyukin_Red;
    }

    /**
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public java.math.BigDecimal getTxtID_M_TatekaeRisoku_Red() {
        return txtID_M_TatekaeRisoku_Red;
    }

    /**
     * 立替金利息(円)を設定します。
     * @param txtID_M_TatekaeRisoku_Red 立替金利息(円)
     */
    public void setTxtID_M_TatekaeRisoku_Red(java.math.BigDecimal txtID_M_TatekaeRisoku_Red) {
        this.txtID_M_TatekaeRisoku_Red = txtID_M_TatekaeRisoku_Red;
    }

    /**
     * 立替金(円)を取得します。
     * @return 立替金(円)
     */
    public java.math.BigDecimal getTxtID_M_Tatekae_Red() {
        return txtID_M_Tatekae_Red;
    }

    /**
     * 立替金(円)を設定します。
     * @param txtID_M_Tatekae_Red 立替金(円)
     */
    public void setTxtID_M_Tatekae_Red(java.math.BigDecimal txtID_M_Tatekae_Red) {
        this.txtID_M_Tatekae_Red = txtID_M_Tatekae_Red;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     * @return 仮受金(一般口)からの充当額(円)
     */
    public java.math.BigDecimal getTxtID_M_KariukeIppanJuto_Red() {
        return txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     * @param txtID_M_KariukeIppanJuto_Red 仮受金(一般口)からの充当額(円)
     */
    public void setTxtID_M_KariukeIppanJuto_Red(java.math.BigDecimal txtID_M_KariukeIppanJuto_Red) {
        this.txtID_M_KariukeIppanJuto_Red = txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getTxtID_Code_TatekaekinShurui_Red() {
        return txtID_Code_TatekaekinShurui_Red;
    }

    /**
     * 立替金の種類を設定します。
     * @param txtID_Code_TatekaekinShurui_Red 立替金の種類
     */
    public void setTxtID_Code_TatekaekinShurui_Red(String txtID_Code_TatekaekinShurui_Red) {
        this.txtID_Code_TatekaekinShurui_Red = txtID_Code_TatekaekinShurui_Red;
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getTxtID_Date_KoukoTatekae_Red() {
        return txtID_Date_KoukoTatekae_Red;
    }

    /**
     * 公庫立替日を設定します。
     * @param txtID_Date_KoukoTatekae_Red 公庫立替日
     */
    public void setTxtID_Date_KoukoTatekae_Red(String txtID_Date_KoukoTatekae_Red) {
        this.txtID_Date_KoukoTatekae_Red = txtID_Date_KoukoTatekae_Red;
    }

    /**
     * 計(円)を取得します。
     * @return 計(円)
     */
    public java.math.BigDecimal getTxtID_M_Kei_Red() {
        return txtID_M_Kei_Red;
    }

    /**
     * 計(円)を設定します。
     * @param txtID_M_Kei_Red 計(円)
     */
    public void setTxtID_M_Kei_Red(java.math.BigDecimal txtID_M_Kei_Red) {
        this.txtID_M_Kei_Red = txtID_M_Kei_Red;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public java.math.BigDecimal getTxtID_M_Sokin_Red() {
        return txtID_M_Sokin_Red;
    }

    /**
     * 送金額(円)を設定します。
     * @param txtID_M_Sokin_Red 送金額(円)
     */
    public void setTxtID_M_Sokin_Red(java.math.BigDecimal txtID_M_Sokin_Red) {
        this.txtID_M_Sokin_Red = txtID_M_Sokin_Red;
    }

    /**
     * 受入後立替金残高(円)を取得します。
     * @return 受入後立替金残高(円)
     */
    public java.math.BigDecimal getTxtID_M_TatekaeZanAfterUkeire_Red() {
        return txtID_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 受入後立替金残高(円)を設定します。
     * @param txtID_M_TatekaeZanAfterUkeire_Red 受入後立替金残高(円)
     */
    public void setTxtID_M_TatekaeZanAfterUkeire_Red(java.math.BigDecimal txtID_M_TatekaeZanAfterUkeire_Red) {
        this.txtID_M_TatekaeZanAfterUkeire_Red = txtID_M_TatekaeZanAfterUkeire_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getTxtID_Date_Jtkshori_Red() {
        return txtID_Date_Jtkshori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param txtID_Date_Jtkshori_Red 受託者勘定処理年月
     */
    public void setTxtID_Date_Jtkshori_Red(String txtID_Date_Jtkshori_Red) {
        this.txtID_Date_Jtkshori_Red = txtID_Date_Jtkshori_Red;
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getTxtID_Date_Sokin_Red() {
        return txtID_Date_Sokin_Red;
    }

    /**
     * 送金日を設定します。
     * @param txtID_Date_Sokin_Red 送金日
     */
    public void setTxtID_Date_Sokin_Red(String txtID_Date_Sokin_Red) {
        this.txtID_Date_Sokin_Red = txtID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getTxtID_ID_Sokinbi_Red() {
        return txtID_ID_Sokinbi_Red;
    }

    /**
     * 送金日番号を設定します。
     * @param txtID_ID_Sokinbi_Red 送金日番号
     */
    public void setTxtID_ID_Sokinbi_Red(String txtID_ID_Sokinbi_Red) {
        this.txtID_ID_Sokinbi_Red = txtID_ID_Sokinbi_Red;
    }

    /**
     * 受託者勘定処理年月(元号)を取得します。
     * @return 受託者勘定処理年月(元号)
     */
    public String getDrpID_Date_Jtkshori_Gengou_Red() {
        return drpID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 受託者勘定処理年月(元号)を設定します。
     * @param drpID_Date_Jtkshori_Gengou_Red 受託者勘定処理年月(元号)
     */
    public void setDrpID_Date_Jtkshori_Gengou_Red(String drpID_Date_Jtkshori_Gengou_Red) {
        this.drpID_Date_Jtkshori_Gengou_Red = drpID_Date_Jtkshori_Gengou_Red;
    }

    /**
     * 受託者勘定処理年月(年)を取得します。
     * @return 受託者勘定処理年月(年)
     */
    public String getTxtID_Date_Jtkshori_Year_Red() {
        return txtID_Date_Jtkshori_Year_Red;
    }

    /**
     * 受託者勘定処理年月(年)を設定します。
     * @param txtID_Date_Jtkshori_Year_Red 受託者勘定処理年月(年)
     */
    public void setTxtID_Date_Jtkshori_Year_Red(String txtID_Date_Jtkshori_Year_Red) {
        this.txtID_Date_Jtkshori_Year_Red = txtID_Date_Jtkshori_Year_Red;
    }

    /**
     * 受託者勘定処理年月(月)を取得します。
     * @return 受託者勘定処理年月(月)
     */
    public String getDrpID_Date_Jtkshori_Month_Red() {
        return drpID_Date_Jtkshori_Month_Red;
    }

    /**
     * 受託者勘定処理年月(月)を設定します。
     * @param drpID_Date_Jtkshori_Month_Red 受託者勘定処理年月(月)
     */
    public void setDrpID_Date_Jtkshori_Month_Red(String drpID_Date_Jtkshori_Month_Red) {
        this.drpID_Date_Jtkshori_Month_Red = drpID_Date_Jtkshori_Month_Red;
    }

    /**
     * 顧客名（修正）を取得します。
     * @return 顧客名（修正）
     */
    public String getTxtID_Name_Customer() {
        return txtID_Name_Customer;
    }

    /**
     * 顧客名（修正）を設定します。
     * @param txtID_Name_Customer 顧客名（修正）
     */
    public void setTxtID_Name_Customer(String txtID_Name_Customer) {
        this.txtID_Name_Customer = txtID_Name_Customer;
    }

    /**
     * 扱店名（修正）を取得します。
     * @return 扱店名（修正）
     */
    public String getTxtID_Name_Organization() {
        return txtID_Name_Organization;
    }

    /**
     * 扱店名（修正）を設定します。
     * @param txtID_Name_Organization 扱店名（修正）
     */
    public void setTxtID_Name_Organization(String txtID_Name_Organization) {
        this.txtID_Name_Organization = txtID_Name_Organization;
    }

    /**
     * 公庫支店（修正）を取得します。
     * @return 公庫支店（修正）
     */
    public String getTxtID_Code_KoukoShiten() {
        return txtID_Code_KoukoShiten;
    }

    /**
     * 公庫支店（修正）を設定します。
     * @param txtID_Code_KoukoShiten 公庫支店（修正）
     */
    public void setTxtID_Code_KoukoShiten(String txtID_Code_KoukoShiten) {
        this.txtID_Code_KoukoShiten = txtID_Code_KoukoShiten;
    }

    /**
     * 扱店（修正）を取得します。
     * @return 扱店（修正）
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店（修正）を設定します。
     * @param txtID_Code_Organization 扱店（修正）
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗（修正）を取得します。
     * @return 店舗（修正）
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗（修正）を設定します。
     * @param txtID_Code_Tenpo 店舗（修正）
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度（修正）を取得します。
     * @return 年度（修正）
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度（修正）を設定します。
     * @param txtID_Year 年度（修正）
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金（修正）を取得します。
     * @return 方式資金（修正）
     */
    public String getTxtID_Code_HoshikiShikin() {
        return txtID_Code_HoshikiShikin;
    }

    /**
     * 方式資金（修正）を設定します。
     * @param txtID_Code_HoshikiShikin 方式資金（修正）
     */
    public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
        this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
    }

    /**
     * 番号（修正）を取得します。
     * @return 番号（修正）
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号（修正）を設定します。
     * @param txtID_ID_Ringi 番号（修正）
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番（修正）を取得します。
     * @return 枝番（修正）
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番（修正）を設定します。
     * @param txtID_ID_RingiBranch 枝番（修正）
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 入金日(元号)（修正）を取得します。
     * @return 入金日(元号)（修正）
     */
    public String getDrpID_Date_Nyukin_Gengou() {
        return drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日(元号)（修正）を設定します。
     * @param drpID_Date_Nyukin_Gengou 入金日(元号)（修正）
     */
    public void setDrpID_Date_Nyukin_Gengou(String drpID_Date_Nyukin_Gengou) {
        this.drpID_Date_Nyukin_Gengou = drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日(年)（修正）を取得します。
     * @return 入金日(年)（修正）
     */
    public String getTxtID_Date_Nyukin_Year() {
        return txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日(年)（修正）を設定します。
     * @param txtID_Date_Nyukin_Year 入金日(年)（修正）
     */
    public void setTxtID_Date_Nyukin_Year(String txtID_Date_Nyukin_Year) {
        this.txtID_Date_Nyukin_Year = txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日(月)（修正）を取得します。
     * @return 入金日(月)（修正）
     */
    public String getDrpID_Date_Nyukin_Month() {
        return drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日(月)（修正）を設定します。
     * @param drpID_Date_Nyukin_Month 入金日(月)（修正）
     */
    public void setDrpID_Date_Nyukin_Month(String drpID_Date_Nyukin_Month) {
        this.drpID_Date_Nyukin_Month = drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日(日)（修正）を取得します。
     * @return 入金日(日)（修正）
     */
    public String getDrpID_Date_Nyukin_Day() {
        return drpID_Date_Nyukin_Day;
    }

    /**
     * 入金日(日)（修正）を設定します。
     * @param drpID_Date_Nyukin_Day 入金日(日)（修正）
     */
    public void setDrpID_Date_Nyukin_Day(String drpID_Date_Nyukin_Day) {
        this.drpID_Date_Nyukin_Day = drpID_Date_Nyukin_Day;
    }

    /**
     * 立替金利息(円)（修正）を取得します。
     * @return 立替金利息(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_TatekaeRisoku() {
        return txtID_M_TatekaeRisoku;
    }

    /**
     * 立替金利息(円)（修正）を設定します。
     * @param txtID_M_TatekaeRisoku 立替金利息(円)（修正）
     */
    public void setTxtID_M_TatekaeRisoku(java.math.BigDecimal txtID_M_TatekaeRisoku) {
        this.txtID_M_TatekaeRisoku = txtID_M_TatekaeRisoku;
    }

    /**
     * 立替金(円)（修正）を取得します。
     * @return 立替金(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_Tatekae() {
        return txtID_M_Tatekae;
    }

    /**
     * 立替金(円)（修正）を設定します。
     * @param txtID_M_Tatekae 立替金(円)（修正）
     */
    public void setTxtID_M_Tatekae(java.math.BigDecimal txtID_M_Tatekae) {
        this.txtID_M_Tatekae = txtID_M_Tatekae;
    }

    /**
     * 仮受金(一般口)からの充当額(円)（修正）を取得します。
     * @return 仮受金(一般口)からの充当額(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額(円)（修正）を設定します。
     * @param txtID_M_KariukeIppanJuto 仮受金(一般口)からの充当額(円)（修正）
     */
    public void setTxtID_M_KariukeIppanJuto(java.math.BigDecimal txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 立替金の種類（修正）を取得します。
     * @return 立替金の種類（修正）
     */
    public String getTxtID_Code_TatekaekinShurui() {
        return txtID_Code_TatekaekinShurui;
    }

    /**
     * 立替金の種類（修正）を設定します。
     * @param txtID_Code_TatekaekinShurui 立替金の種類（修正）
     */
    public void setTxtID_Code_TatekaekinShurui(String txtID_Code_TatekaekinShurui) {
        this.txtID_Code_TatekaekinShurui = txtID_Code_TatekaekinShurui;
    }

    /**
     * 公庫立替日（修正）を取得します。
     * @return 公庫立替日（修正）
     */
    public String getTxtID_Date_KoukoTatekae() {
        return txtID_Date_KoukoTatekae;
    }

    /**
     * 公庫立替日（修正）を設定します。
     * @param txtID_Date_KoukoTatekae 公庫立替日（修正）
     */
    public void setTxtID_Date_KoukoTatekae(String txtID_Date_KoukoTatekae) {
        this.txtID_Date_KoukoTatekae = txtID_Date_KoukoTatekae;
    }

    /**
     * 計(円)（修正）を取得します。
     * @return 計(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_Kei() {
        return txtID_M_Kei;
    }

    /**
     * 計(円)（修正）を設定します。
     * @param txtID_M_Kei 計(円)（修正）
     */
    public void setTxtID_M_Kei(java.math.BigDecimal txtID_M_Kei) {
        this.txtID_M_Kei = txtID_M_Kei;
    }

    /**
     * 送金額(円)（修正）を取得します。
     * @return 送金額(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額(円)（修正）を設定します。
     * @param txtID_M_Sokin 送金額(円)（修正）
     */
    public void setTxtID_M_Sokin(java.math.BigDecimal txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 受入後立替金残高(円)（修正）を取得します。
     * @return 受入後立替金残高(円)（修正）
     */
    public java.math.BigDecimal getTxtID_M_TatekaeZanAfterUkeire() {
        return txtID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受入後立替金残高(円)（修正）を設定します。
     * @param txtID_M_TatekaeZanAfterUkeire 受入後立替金残高(円)（修正）
     */
    public void setTxtID_M_TatekaeZanAfterUkeire(java.math.BigDecimal txtID_M_TatekaeZanAfterUkeire) {
        this.txtID_M_TatekaeZanAfterUkeire = txtID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受託者勘定処理年月（修正）を取得します。
     * @return 受託者勘定処理年月（修正）
     */
    public String getTxtID_Date_Jtkshori() {
        return txtID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月（修正）を設定します。
     * @param txtID_Date_Jtkshori 受託者勘定処理年月（修正）
     */
    public void setTxtID_Date_Jtkshori(String txtID_Date_Jtkshori) {
        this.txtID_Date_Jtkshori = txtID_Date_Jtkshori;
    }

    /**
     * 送金日(元号)（修正）（修正）を取得します。
     * @return 送金日(元号)（修正）（修正）
     */
    public String getDrpID_Date_Sokin_Gengou() {
        return drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金日(元号)（修正）（修正）を設定します。
     * @param drpID_Date_Sokin_Gengou 送金日(元号)（修正）（修正）
     */
    public void setDrpID_Date_Sokin_Gengou(String drpID_Date_Sokin_Gengou) {
        this.drpID_Date_Sokin_Gengou = drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金日(年)（修正）を取得します。
     * @return 送金日(年)（修正）
     */
    public String getTxtID_Date_Sokin_Year() {
        return txtID_Date_Sokin_Year;
    }

    /**
     * 送金日(年)（修正）を設定します。
     * @param txtID_Date_Sokin_Year 送金日(年)（修正）
     */
    public void setTxtID_Date_Sokin_Year(String txtID_Date_Sokin_Year) {
        this.txtID_Date_Sokin_Year = txtID_Date_Sokin_Year;
    }

    /**
     * 送金日(月)（修正）を取得します。
     * @return 送金日(月)（修正）
     */
    public String getDrpID_Date_Sokin_Month() {
        return drpID_Date_Sokin_Month;
    }

    /**
     * 送金日(月)（修正）を設定します。
     * @param drpID_Date_Sokin_Month 送金日(月)（修正）
     */
    public void setDrpID_Date_Sokin_Month(String drpID_Date_Sokin_Month) {
        this.drpID_Date_Sokin_Month = drpID_Date_Sokin_Month;
    }

    /**
     * 送金日(日)（修正）を取得します。
     * @return 送金日(日)（修正）
     */
    public String getDrpID_Date_Sokin_Day() {
        return drpID_Date_Sokin_Day;
    }

    /**
     * 送金日(日)（修正）を設定します。
     * @param drpID_Date_Sokin_Day 送金日(日)（修正）
     */
    public void setDrpID_Date_Sokin_Day(String drpID_Date_Sokin_Day) {
        this.drpID_Date_Sokin_Day = drpID_Date_Sokin_Day;
    }

    /**
     * 送金日番号（修正）を取得します。
     * @return 送金日番号（修正）
     */
    public String getTxtID_ID_Sokinbi() {
        return txtID_ID_Sokinbi;
    }

    /**
     * 送金日番号（修正）を設定します。
     * @param txtID_ID_Sokinbi 送金日番号（修正）
     */
    public void setTxtID_ID_Sokinbi(String txtID_ID_Sokinbi) {
        this.txtID_ID_Sokinbi = txtID_ID_Sokinbi;
    }

    /**
     * 受託者勘定処理年月(元号)（修正）を取得します。
     * @return 受託者勘定処理年月(元号)（修正）
     */
    public String getDrpID_Date_Jtkshori_Gengou() {
        return drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月(元号)（修正）を設定します。
     * @param drpID_Date_Jtkshori_Gengou 受託者勘定処理年月(元号)（修正）
     */
    public void setDrpID_Date_Jtkshori_Gengou(String drpID_Date_Jtkshori_Gengou) {
        this.drpID_Date_Jtkshori_Gengou = drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月(年)（修正）を取得します。
     * @return 受託者勘定処理年月(年)（修正）
     */
    public String getTxtID_Date_Jtkshori_Year() {
        return txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月(年)（修正）を設定します。
     * @param txtID_Date_Jtkshori_Year 受託者勘定処理年月(年)（修正）
     */
    public void setTxtID_Date_Jtkshori_Year(String txtID_Date_Jtkshori_Year) {
        this.txtID_Date_Jtkshori_Year = txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月(月)（修正）を取得します。
     * @return 受託者勘定処理年月(月)（修正）
     */
    public String getDrpID_Date_Jtkshori_Month() {
        return drpID_Date_Jtkshori_Month;
    }

    /**
     * 受託者勘定処理年月(月)（修正）を設定します。
     * @param drpID_Date_Jtkshori_Month 受託者勘定処理年月(月)（修正）
     */
    public void setDrpID_Date_Jtkshori_Month(String drpID_Date_Jtkshori_Month) {
        this.drpID_Date_Jtkshori_Month = drpID_Date_Jtkshori_Month;
    }

    /**
     * 処理モードを取得します。
     * @return 処理モード
     */
    public String getProcessMode() {
        return processMode;
    }

    /**
     * 処理モードを設定します。
     * @param processMode 処理モード
     */
    public void setProcessMode(String processMode) {
        this.processMode = processMode;
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param ID_Time_Report 報告時分秒
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * 報告書種別（値）を取得します。
     * @return 報告書種別（値）
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * 報告書種別（値）を設定します。
     * @param ID_DataCode 報告書種別（値）
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public java.math.BigDecimal getID_Status() {
        return ID_Status;
    }

    /**
     * ステータスを設定します。
     * @param ID_Status ステータス
     */
    public void setID_Status(java.math.BigDecimal ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param ID_ID_Report 報告書番号
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * ユーザーIDを取得します。
     * @return ユーザーID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * ユーザーIDを設定します。
     * @param UserID ユーザーID
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
     */
    public String getID_Denso() {
        return ID_Denso;
    }

    /**
     * 伝送番号を設定します。
     * @param ID_Denso 伝送番号
     */
    public void setID_Denso(String ID_Denso) {
        this.ID_Denso = ID_Denso;
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return DataCode;
    }

    /**
     * データコードを設定します。
     * @param DataCode データコード
     */
    public void setDataCode(String DataCode) {
        this.DataCode = DataCode;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return ID_History;
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        this.ID_History = ID_History;
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getTypeProcess() {
        return TypeProcess;
    }

    /**
     * 処理種別を設定します。
     * @param TypeProcess 処理種別
     */
    public void setTypeProcess(String TypeProcess) {
        this.TypeProcess = TypeProcess;
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public java.math.BigDecimal getFlag_Torikeshizumi() {
        return Flag_Torikeshizumi;
    }

    /**
     * 取消済フラグを設定します。
     * @param Flag_Torikeshizumi 取消済フラグ
     */
    public void setFlag_Torikeshizumi(java.math.BigDecimal Flag_Torikeshizumi) {
        this.Flag_Torikeshizumi = Flag_Torikeshizumi;
    }

    /**
     * エラーコードを取得します。
     * @return エラーコード
     */
    public String getCode_Error() {
        return Code_Error;
    }

    /**
     * エラーコードを設定します。
     * @param Code_Error エラーコード
     */
    public void setCode_Error(String Code_Error) {
        this.Code_Error = Code_Error;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * エラーメッセージを設定します。
     * @param ErrorMessage エラーメッセージ
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 原本番号を取得します。
     * @return 原本番号
     */
    public String getID_Master() {
        return ID_Master;
    }

    /**
     * 原本番号を設定します。
     * @param ID_Master 原本番号
     */
    public void setID_Master(String ID_Master) {
        this.ID_Master = ID_Master;
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_Credit() {
        return ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(java.math.BigDecimal ID_Credit) {
        this.ID_Credit = ID_Credit;
    }

    /**
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getKeep_ID_History() {
        return Keep_ID_History;
    }

    /**
     * 退避履歴番号を設定します。
     * @param Keep_ID_History 退避履歴番号
     */
    public void setKeep_ID_History(String Keep_ID_History) {
        this.Keep_ID_History = Keep_ID_History;
    }

    /**
     * 退避貸付実行報告書作成済みフラグを取得します。
     * @return 退避貸付実行報告書作成済みフラグ
     */
    public java.math.BigDecimal getKeep_Flag_Kj() {
        return Keep_Flag_Kj;
    }

    /**
     * 退避貸付実行報告書作成済みフラグを設定します。
     * @param Keep_Flag_Kj 退避貸付実行報告書作成済みフラグ
     */
    public void setKeep_Flag_Kj(java.math.BigDecimal Keep_Flag_Kj) {
        this.Keep_Flag_Kj = Keep_Flag_Kj;
    }

    /**
     * 退避受入後立替金残高（修正）を取得します。
     * @return 退避受入後立替金残高（修正）
     */
    public java.math.BigDecimal getKeep_M_TatekaeZanAfterUkeire() {
        return Keep_M_TatekaeZanAfterUkeire;
    }

    /**
     * 退避受入後立替金残高（修正）を設定します。
     * @param Keep_M_TatekaeZanAfterUkeire 退避受入後立替金残高（修正）
     */
    public void setKeep_M_TatekaeZanAfterUkeire(java.math.BigDecimal Keep_M_TatekaeZanAfterUkeire) {
        this.Keep_M_TatekaeZanAfterUkeire = Keep_M_TatekaeZanAfterUkeire;
    }

    /**
     * 最新更新日時を取得します。
     * @return 最新更新日時
     */
    public java.util.Date getData_LastUpDate() {
        return Data_LastUpDate;
    }

    /**
     * 最新更新日時を設定します。
     * @param Data_LastUpDate 最新更新日時
     */
    public void setData_LastUpDate(java.util.Date Data_LastUpDate) {
        this.Data_LastUpDate = Data_LastUpDate;
    }

    /**
     * 退避仮受仮払番号を取得します。
     * @return 退避仮受仮払番号
     */
    public String getKeep_ID_Karibarai() {
        return Keep_ID_Karibarai;
    }

    /**
     * 退避仮受仮払番号を設定します。
     * @param Keep_ID_Karibarai 退避仮受仮払番号
     */
    public void setKeep_ID_Karibarai(String Keep_ID_Karibarai) {
        this.Keep_ID_Karibarai = Keep_ID_Karibarai;
    }

    /**
     * 退避本支店コードを取得します。
     * @return 退避本支店コード
     */
    public String getKeep_Code_HonShiten() {
        return Keep_Code_HonShiten;
    }

    /**
     * 退避本支店コードを設定します。
     * @param Keep_Code_HonShiten 退避本支店コード
     */
    public void setKeep_Code_HonShiten(String Keep_Code_HonShiten) {
        this.Keep_Code_HonShiten = Keep_Code_HonShiten;
    }

    /**
     * 受入後立替金残高明細を取得します。
     * @return 受入後立替金残高明細
     */
    public java.math.BigDecimal getID_Meisai_M_KaribaraiZanAfterSeisan() {
        return ID_Meisai_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 受入後立替金残高明細を設定します。
     * @param ID_Meisai_M_KaribaraiZanAfterSeisan 受入後立替金残高明細
     */
    public void setID_Meisai_M_KaribaraiZanAfterSeisan(
            java.math.BigDecimal ID_Meisai_M_KaribaraiZanAfterSeisan) {
        this.ID_Meisai_M_KaribaraiZanAfterSeisan = ID_Meisai_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 仮受仮払精算後残高を取得します。
     * @return 仮受仮払精算後残高
     */
    public java.math.BigDecimal getID_M_KaribaraiZanAfterSeisan() {
        return ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 仮受仮払精算後残高を設定します。
     * @param ID_M_KaribaraiZanAfterSeisan 仮受仮払精算後残高
     */
    public void setID_M_KaribaraiZanAfterSeisan(java.math.BigDecimal ID_M_KaribaraiZanAfterSeisan) {
        this.ID_M_KaribaraiZanAfterSeisan = ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 仮受仮払番号を取得します。
     * @return 仮受仮払番号
     */
    public String getID_Karibarai() {
        return ID_Karibarai;
    }

    /**
     * 仮受仮払番号を設定します。
     * @param ID_Karibarai 仮受仮払番号
     */
    public void setID_Karibarai(String ID_Karibarai) {
        this.ID_Karibarai = ID_Karibarai;
    }

    /**
     * 仮受仮払年月日を取得します。
     * @return 仮受仮払年月日
     */
    public String getDate_Karibarai() {
        return Date_Karibarai;
    }

    /**
     * 仮受仮払年月日を設定します。
     * @param Date_Karibarai 仮受仮払年月日
     */
    public void setDate_Karibarai(String Date_Karibarai) {
        this.Date_Karibarai = Date_Karibarai;
    }

    /**
     * 取得データ件数を取得します。
     * @return 取得データ件数
     */
    public int getRecordCount() {
        return RecordCount;
    }

    /**
     * 取得データ件数を設定します。
     * @param recordCount 取得データ件数
     */
    public void setRecordCount(int recordCount) {
        RecordCount = recordCount;
    }

}