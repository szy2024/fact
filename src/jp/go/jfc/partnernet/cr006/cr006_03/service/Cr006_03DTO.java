//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_03DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_03.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr006_03のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr006_03DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** エラー */
    private String lblError;
    /** ステータス */
    private String lblMessage;
    /** 顧客名 */
    private String lblID_Name_Customer;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 公庫支店 */
    private String lblID_Code_KoukoShiten;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 年度 */
    private String lblID_Year;
    /** 方式資金 */
    private String lblID_Code_HoshikiShikin;
    /** 番号 */
    private String lblID_ID_Ringi;
    /** 枝番 */
    private String lblID_ID_RingiBranch;
    /** 入金日 */
    private String lblID_Date_Nyukin;
    /** 立替金利息(円) */
    private String lblID_M_TatekaeRisoku;
    /** 立替金(円) */
    private String lblID_M_Tatekae;
    /** 仮受金(一般口)からの充当額(円) */
    private String lblID_M_KariukeIppanJuto;
    /** 立替金の種類 */
    private String lblID_Code_TatekaekinShurui;
    /** 公庫立替日 */
    private String lblID_Date_KoukoTatekae;
    /** 計(円) */
    private String lblID_M_Kei;
    /** 送金額(円) */
    private String lblID_M_Sokin;
    /** 受入後立替金残高(円) */
    private String lblID_M_TatekaeZanAfterUkeire;
    /** 受託者勘定処理年月 */
    private String lblID_Date_Jtkshori;
    /** 送金年月日 */
    private String lblID_Date_Sokin;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi;
    /** 報告年月日 */
    private String txtID_Date_Report;
    /** 顧客名 */
    private String txtID_Name_Customer;
    /** 扱店名 */
    private String txtID_Name_Organization;
    /** 公庫支店 */
    private String txtID_Code_KoukoShiten;
    /** 扱店 */
    private String txtID_Code_Organization;
    /** 店舗 */
    private String txtID_Code_Tenpo;
    /** 年度 */
    private String txtID_Year;
    /** 方式資金 */
    private String txtID_Code_HoshikiShikin;
    /** 番号 */
    private String txtID_ID_Ringi;
    /** 枝番 */
    private String txtID_ID_RingiBranch;
    /** 入金日(年号) */
    private String drpID_Date_Nyukin_Gengou;
    /** 入金日(年) */
    private String txtID_Date_Nyukin_Year;
    /** 入金日(月) */
    private String drpID_Date_Nyukin_Month;
    /** 入金日(日) */
    private String drpID_Date_Nyukin_Day;
    /** 立替金利息(円) */
    private String txtID_M_TatekaeRisoku;
    /** 立替金（円） */
    private String txtID_M_Tatekae;
    /** 仮受金(一般口)からの充当額（円） */
    private String txtID_M_KariukeIppanJuto;
    /** 立替金の種類 */
    private String txtID_Code_TatekaekinShurui;
    /** 公庫立替日 */
    private String txtID_Date_KoukoTatekae;
    /** 計（円） */
    private String txtID_M_Kei;
    /** 送金額（円） */
    private String txtID_M_Sokin;
    /** 受入後立替金残高（円） */
    private String txtID_M_TatekaeZanAfterUkeire;
    /** 受託者勘定処理年月(年号) */
    private String drpID_Date_Jtkshori_Gengou;
    /** 受託者勘定処理年月(年) */
    private String txtID_Date_Jtkshori_Year;
    /** 受託者勘定処理年月(月) */
    private String drpID_Date_Jtkshori_Month;
    /** 送金年月日(年号) */
    private String drpID_Date_Sokin_Gengou;
    /** 送金年月日(年) */
    private String txtID_Date_Sokin_Year;
    /** 送金年月日(月) */
    private String drpID_Date_Sokin_Month;
    /** 送金年月日(日) */
    private String drpID_Date_Sokin_Day;
    /** 送金日番号 */
    private String txtID_Code_Sokin;
    /** 原本番号 */
    private String ID_ID_Master;
    /** ユーザID */
    private String ID_UserID;
    /** データコード */
    private String ID_DataCode;
    /** ステータス(非表示) */
    private String ID_Status;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 先行報告書の有無 */
    private boolean ID_Previous_Report;
    /** 先行報告書の種類 */
    private String ID_Previous_ReportType;
    /** 仮受仮払精算後残高（計算用） */
    private String ID_M_KaribaraiZanAfterSeisan;
    /** 本支店コード */
    private String ID_Code_HonShiten;
    /** 仮受仮払番号 */
    private String ID_ID_Karibarai;
    /** 入金日 */
    private String ID_Date_Nyukin;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 送金年月日 */
    private String ID_Date_Sokin;
    /** 最新データ更新日付 */
    private String ID_Data_LastUpDate;
    /** 履歴番号 */
    private String ID_ID_History;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** 債権管理番号 */
    private String ID_ID_Credit;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr006_03DTO() {
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
    public Cr006_03DTO(Cr006_03DTO orig) {
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
     * エラーを取得します。
     * @return エラー
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーを設定します。
     * @param lblError エラー
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * ステータスを設定します。
     * @param lblMessage ステータス
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param lblID_Name_Customer 顧客名
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getLblID_Code_KoukoShiten() {
        return lblID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_KoukoShiten 公庫支店
     */
    public void setLblID_Code_KoukoShiten(String lblID_Code_KoukoShiten) {
        this.lblID_Code_KoukoShiten = lblID_Code_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization 扱店
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo 店舗
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度を設定します。
     * @param lblID_Year 年度
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Code_HoshikiShikin 方式資金
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param lblID_ID_Ringi 番号
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param lblID_ID_RingiBranch 枝番
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日を設定します。
     * @param lblID_Date_Nyukin 入金日
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }

    /**
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public String getLblID_M_TatekaeRisoku() {
        return lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金利息(円)を設定します。
     * @param lblID_M_TatekaeRisoku 立替金利息(円)
     */
    public void setLblID_M_TatekaeRisoku(String lblID_M_TatekaeRisoku) {
        this.lblID_M_TatekaeRisoku = lblID_M_TatekaeRisoku;
    }

    /**
     * 立替金(円)を取得します。
     * @return 立替金(円)
     */
    public String getLblID_M_Tatekae() {
        return lblID_M_Tatekae;
    }

    /**
     * 立替金(円)を設定します。
     * @param lblID_M_Tatekae 立替金(円)
     */
    public void setLblID_M_Tatekae(String lblID_M_Tatekae) {
        this.lblID_M_Tatekae = lblID_M_Tatekae;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     * @return 仮受金(一般口)からの充当額(円)
     */
    public String getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     * @param lblID_M_KariukeIppanJuto 仮受金(一般口)からの充当額(円)
     */
    public void setLblID_M_KariukeIppanJuto(String lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }

    /**
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getLblID_Code_TatekaekinShurui() {
        return lblID_Code_TatekaekinShurui;
    }

    /**
     * 立替金の種類を設定します。
     * @param lblID_Code_TatekaekinShurui 立替金の種類
     */
    public void setLblID_Code_TatekaekinShurui(String lblID_Code_TatekaekinShurui) {
        this.lblID_Code_TatekaekinShurui = lblID_Code_TatekaekinShurui;
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getLblID_Date_KoukoTatekae() {
        return lblID_Date_KoukoTatekae;
    }

    /**
     * 公庫立替日を設定します。
     * @param lblID_Date_KoukoTatekae 公庫立替日
     */
    public void setLblID_Date_KoukoTatekae(String lblID_Date_KoukoTatekae) {
        this.lblID_Date_KoukoTatekae = lblID_Date_KoukoTatekae;
    }

    /**
     * 計(円)を取得します。
     * @return 計(円)
     */
    public String getLblID_M_Kei() {
        return lblID_M_Kei;
    }

    /**
     * 計(円)を設定します。
     * @param lblID_M_Kei 計(円)
     */
    public void setLblID_M_Kei(String lblID_M_Kei) {
        this.lblID_M_Kei = lblID_M_Kei;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public String getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額(円)を設定します。
     * @param lblID_M_Sokin 送金額(円)
     */
    public void setLblID_M_Sokin(String lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
    }

    /**
     * 受入後立替金残高(円)を取得します。
     * @return 受入後立替金残高(円)
     */
    public String getLblID_M_TatekaeZanAfterUkeire() {
        return lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受入後立替金残高(円)を設定します。
     * @param lblID_M_TatekaeZanAfterUkeire 受入後立替金残高(円)
     */
    public void setLblID_M_TatekaeZanAfterUkeire(String lblID_M_TatekaeZanAfterUkeire) {
        this.lblID_M_TatekaeZanAfterUkeire = lblID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_Jtkshori() {
        return lblID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param lblID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setLblID_Date_Jtkshori(String lblID_Date_Jtkshori) {
        this.lblID_Date_Jtkshori = lblID_Date_Jtkshori;
    }

    /**
     * 送金年月日を取得します。
     * @return 送金年月日
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金年月日を設定します。
     * @param lblID_Date_Sokin 送金年月日
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_ID_Sokinbi 送金日番号
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getTxtID_Date_Report() {
        return txtID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param txtID_Date_Report 報告年月日
     */
    public void setTxtID_Date_Report(String txtID_Date_Report) {
        this.txtID_Date_Report = txtID_Date_Report;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getTxtID_Name_Customer() {
        return txtID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param txtID_Name_Customer 顧客名
     */
    public void setTxtID_Name_Customer(String txtID_Name_Customer) {
        this.txtID_Name_Customer = txtID_Name_Customer;
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
    public String getTxtID_Code_KoukoShiten() {
        return txtID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param txtID_Code_KoukoShiten 公庫支店
     */
    public void setTxtID_Code_KoukoShiten(String txtID_Code_KoukoShiten) {
        this.txtID_Code_KoukoShiten = txtID_Code_KoukoShiten;
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
    public String getTxtID_Code_HoshikiShikin() {
        return txtID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_Code_HoshikiShikin 方式資金
     */
    public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
        this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
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
     * 入金日(年号)を取得します。
     * @return 入金日(年号)
     */
    public String getDrpID_Date_Nyukin_Gengou() {
        return drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日(年号)を設定します。
     * @param drpID_Date_Nyukin_Gengou 入金日(年号)
     */
    public void setDrpID_Date_Nyukin_Gengou(String drpID_Date_Nyukin_Gengou) {
        this.drpID_Date_Nyukin_Gengou = drpID_Date_Nyukin_Gengou;
    }

    /**
     * 入金日(年)を取得します。
     * @return 入金日(年)
     */
    public String getTxtID_Date_Nyukin_Year() {
        return txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日(年)を設定します。
     * @param txtID_Date_Nyukin_Year 入金日(年)
     */
    public void setTxtID_Date_Nyukin_Year(String txtID_Date_Nyukin_Year) {
        this.txtID_Date_Nyukin_Year = txtID_Date_Nyukin_Year;
    }

    /**
     * 入金日(月)を取得します。
     * @return 入金日(月)
     */
    public String getDrpID_Date_Nyukin_Month() {
        return drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日(月)を設定します。
     * @param drpID_Date_Nyukin_Month 入金日(月)
     */
    public void setDrpID_Date_Nyukin_Month(String drpID_Date_Nyukin_Month) {
        this.drpID_Date_Nyukin_Month = drpID_Date_Nyukin_Month;
    }

    /**
     * 入金日(日)を取得します。
     * @return 入金日(日)
     */
    public String getDrpID_Date_Nyukin_Day() {
        return drpID_Date_Nyukin_Day;
    }

    /**
     * 入金日(日)を設定します。
     * @param drpID_Date_Nyukin_Day 入金日(日)
     */
    public void setDrpID_Date_Nyukin_Day(String drpID_Date_Nyukin_Day) {
        this.drpID_Date_Nyukin_Day = drpID_Date_Nyukin_Day;
    }

    /**
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public String getTxtID_M_TatekaeRisoku() {
        return txtID_M_TatekaeRisoku;
    }

    /**
     * 立替金利息(円)を設定します。
     * @param txtID_M_TatekaeRisoku 立替金利息(円)
     */
    public void setTxtID_M_TatekaeRisoku(String txtID_M_TatekaeRisoku) {
        this.txtID_M_TatekaeRisoku = txtID_M_TatekaeRisoku;
    }

    /**
     * 立替金（円）を取得します。
     * @return 立替金（円）
     */
    public String getTxtID_M_Tatekae() {
        return txtID_M_Tatekae;
    }

    /**
     * 立替金（円）を設定します。
     * @param txtID_M_Tatekae 立替金（円）
     */
    public void setTxtID_M_Tatekae(String txtID_M_Tatekae) {
        this.txtID_M_Tatekae = txtID_M_Tatekae;
    }

    /**
     * 仮受金(一般口)からの充当額（円）を取得します。
     * @return 仮受金(一般口)からの充当額（円）
     */
    public String getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額（円）を設定します。
     * @param txtID_M_KariukeIppanJuto 仮受金(一般口)からの充当額（円）
     */
    public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getTxtID_Code_TatekaekinShurui() {
        return txtID_Code_TatekaekinShurui;
    }

    /**
     * 立替金の種類を設定します。
     * @param txtID_Code_TatekaekinShurui 立替金の種類
     */
    public void setTxtID_Code_TatekaekinShurui(String txtID_Code_TatekaekinShurui) {
        this.txtID_Code_TatekaekinShurui = txtID_Code_TatekaekinShurui;
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getTxtID_Date_KoukoTatekae() {
        return txtID_Date_KoukoTatekae;
    }

    /**
     * 公庫立替日を設定します。
     * @param txtID_Date_KoukoTatekae 公庫立替日
     */
    public void setTxtID_Date_KoukoTatekae(String txtID_Date_KoukoTatekae) {
        this.txtID_Date_KoukoTatekae = txtID_Date_KoukoTatekae;
    }

    /**
     * 計（円）を取得します。
     * @return 計（円）
     */
    public String getTxtID_M_Kei() {
        return txtID_M_Kei;
    }

    /**
     * 計（円）を設定します。
     * @param txtID_M_Kei 計（円）
     */
    public void setTxtID_M_Kei(String txtID_M_Kei) {
        this.txtID_M_Kei = txtID_M_Kei;
    }

    /**
     * 送金額（円）を取得します。
     * @return 送金額（円）
     */
    public String getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額（円）を設定します。
     * @param txtID_M_Sokin 送金額（円）
     */
    public void setTxtID_M_Sokin(String txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 受入後立替金残高（円）を取得します。
     * @return 受入後立替金残高（円）
     */
    public String getTxtID_M_TatekaeZanAfterUkeire() {
        return txtID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受入後立替金残高（円）を設定します。
     * @param txtID_M_TatekaeZanAfterUkeire 受入後立替金残高（円）
     */
    public void setTxtID_M_TatekaeZanAfterUkeire(String txtID_M_TatekaeZanAfterUkeire) {
        this.txtID_M_TatekaeZanAfterUkeire = txtID_M_TatekaeZanAfterUkeire;
    }

    /**
     * 受託者勘定処理年月(年号)を取得します。
     * @return 受託者勘定処理年月(年号)
     */
    public String getDrpID_Date_Jtkshori_Gengou() {
        return drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月(年号)を設定します。
     * @param drpID_Date_Jtkshori_Gengou 受託者勘定処理年月(年号)
     */
    public void setDrpID_Date_Jtkshori_Gengou(String drpID_Date_Jtkshori_Gengou) {
        this.drpID_Date_Jtkshori_Gengou = drpID_Date_Jtkshori_Gengou;
    }

    /**
     * 受託者勘定処理年月(年)を取得します。
     * @return 受託者勘定処理年月(年)
     */
    public String getTxtID_Date_Jtkshori_Year() {
        return txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月(年)を設定します。
     * @param txtID_Date_Jtkshori_Year 受託者勘定処理年月(年)
     */
    public void setTxtID_Date_Jtkshori_Year(String txtID_Date_Jtkshori_Year) {
        this.txtID_Date_Jtkshori_Year = txtID_Date_Jtkshori_Year;
    }

    /**
     * 受託者勘定処理年月(月)を取得します。
     * @return 受託者勘定処理年月(月)
     */
    public String getDrpID_Date_Jtkshori_Month() {
        return drpID_Date_Jtkshori_Month;
    }

    /**
     * 受託者勘定処理年月(月)を設定します。
     * @param drpID_Date_Jtkshori_Month 受託者勘定処理年月(月)
     */
    public void setDrpID_Date_Jtkshori_Month(String drpID_Date_Jtkshori_Month) {
        this.drpID_Date_Jtkshori_Month = drpID_Date_Jtkshori_Month;
    }

    /**
     * 送金年月日(年号)を取得します。
     * @return 送金年月日(年号)
     */
    public String getDrpID_Date_Sokin_Gengou() {
        return drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金年月日(年号)を設定します。
     * @param drpID_Date_Sokin_Gengou 送金年月日(年号)
     */
    public void setDrpID_Date_Sokin_Gengou(String drpID_Date_Sokin_Gengou) {
        this.drpID_Date_Sokin_Gengou = drpID_Date_Sokin_Gengou;
    }

    /**
     * 送金年月日(年)を取得します。
     * @return 送金年月日(年)
     */
    public String getTxtID_Date_Sokin_Year() {
        return txtID_Date_Sokin_Year;
    }

    /**
     * 送金年月日(年)を設定します。
     * @param txtID_Date_Sokin_Year 送金年月日(年)
     */
    public void setTxtID_Date_Sokin_Year(String txtID_Date_Sokin_Year) {
        this.txtID_Date_Sokin_Year = txtID_Date_Sokin_Year;
    }

    /**
     * 送金年月日(月)を取得します。
     * @return 送金年月日(月)
     */
    public String getDrpID_Date_Sokin_Month() {
        return drpID_Date_Sokin_Month;
    }

    /**
     * 送金年月日(月)を設定します。
     * @param drpID_Date_Sokin_Month 送金年月日(月)
     */
    public void setDrpID_Date_Sokin_Month(String drpID_Date_Sokin_Month) {
        this.drpID_Date_Sokin_Month = drpID_Date_Sokin_Month;
    }

    /**
     * 送金年月日(日)を取得します。
     * @return 送金年月日(日)
     */
    public String getDrpID_Date_Sokin_Day() {
        return drpID_Date_Sokin_Day;
    }

    /**
     * 送金年月日(日)を設定します。
     * @param drpID_Date_Sokin_Day 送金年月日(日)
     */
    public void setDrpID_Date_Sokin_Day(String drpID_Date_Sokin_Day) {
        this.drpID_Date_Sokin_Day = drpID_Date_Sokin_Day;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getTxtID_Code_Sokin() {
        return txtID_Code_Sokin;
    }

    /**
     * 送金日番号を設定します。
     * @param txtID_Code_Sokin 送金日番号
     */
    public void setTxtID_Code_Sokin(String txtID_Code_Sokin) {
        this.txtID_Code_Sokin = txtID_Code_Sokin;
    }

    /**
     * 原本番号を取得します。
     * @return 原本番号
     */
    public String getID_ID_Master() {
        return ID_ID_Master;
    }

    /**
     * 原本番号を設定します。
     * @param ID_ID_Master 原本番号
     */
    public void setID_ID_Master(String ID_ID_Master) {
        this.ID_ID_Master = ID_ID_Master;
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getID_UserID() {
        return ID_UserID;
    }

    /**
     * ユーザIDを設定します。
     * @param ID_UserID ユーザID
     */
    public void setID_UserID(String ID_UserID) {
        this.ID_UserID = ID_UserID;
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコードを設定します。
     * @param ID_DataCode データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * ステータス(非表示)を取得します。
     * @return ステータス(非表示)
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータス(非表示)を設定します。
     * @param ID_Status ステータス(非表示)
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済フラグを設定します。
     * @param ID_Flag_Torikeshizumi 取消済フラグ
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
    }

    /**
     * 処理種別を設定します。
     * @param ID_Type_Process 処理種別
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
    }

    /**
     * 先行報告書の有無を取得します。
     * @return 先行報告書の有無
     */
    public boolean getID_Previous_Report() {
        return ID_Previous_Report;
    }

    /**
     * 先行報告書の有無を設定します。
     * @param ID_Previous_Report 先行報告書の有無
     */
    public void setID_Previous_Report(boolean ID_Previous_Report) {
        this.ID_Previous_Report = ID_Previous_Report;
    }

    /**
     * 先行報告書の種類を取得します。
     * @return 先行報告書の種類
     */
    public String getID_Previous_ReportType() {
        return ID_Previous_ReportType;
    }

    /**
     * 先行報告書の種類を設定します。
     * @param ID_Previous_ReportType 先行報告書の種類
     */
    public void setID_Previous_ReportType(String ID_Previous_ReportType) {
        this.ID_Previous_ReportType = ID_Previous_ReportType;
    }

    /**
     * 仮受仮払精算後残高（計算用）を取得します。
     * @return 仮受仮払精算後残高（計算用）
     */
    public String getID_M_KaribaraiZanAfterSeisan() {
        return ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 仮受仮払精算後残高（計算用）を設定します。
     * @param ID_M_KaribaraiZanAfterSeisan 仮受仮払精算後残高（計算用）
     */
    public void setID_M_KaribaraiZanAfterSeisan(String ID_M_KaribaraiZanAfterSeisan) {
        this.ID_M_KaribaraiZanAfterSeisan = ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 本支店コードを取得します。
     * @return 本支店コード
     */
    public String getID_Code_HonShiten() {
        return ID_Code_HonShiten;
    }

    /**
     * 本支店コードを設定します。
     * @param ID_Code_HonShiten 本支店コード
     */
    public void setID_Code_HonShiten(String ID_Code_HonShiten) {
        this.ID_Code_HonShiten = ID_Code_HonShiten;
    }

    /**
     * 仮受仮払番号を取得します。
     * @return 仮受仮払番号
     */
    public String getID_ID_Karibarai() {
        return ID_ID_Karibarai;
    }

    /**
     * 仮受仮払番号を設定します。
     * @param ID_ID_Karibarai 仮受仮払番号
     */
    public void setID_ID_Karibarai(String ID_ID_Karibarai) {
        this.ID_ID_Karibarai = ID_ID_Karibarai;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getID_Date_Nyukin() {
        return ID_Date_Nyukin;
    }

    /**
     * 入金日を設定します。
     * @param ID_Date_Nyukin 入金日
     */
    public void setID_Date_Nyukin(String ID_Date_Nyukin) {
        this.ID_Date_Nyukin = ID_Date_Nyukin;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getID_Date_Jtkshori() {
        return ID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param ID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
        this.ID_Date_Jtkshori = ID_Date_Jtkshori;
    }

    /**
     * 送金年月日を取得します。
     * @return 送金年月日
     */
    public String getID_Date_Sokin() {
        return ID_Date_Sokin;
    }

    /**
     * 送金年月日を設定します。
     * @param ID_Date_Sokin 送金年月日
     */
    public void setID_Date_Sokin(String ID_Date_Sokin) {
        this.ID_Date_Sokin = ID_Date_Sokin;
    }

    /**
     * 最新データ更新日付を取得します。
     * @return 最新データ更新日付
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新データ更新日付を設定します。
     * @param ID_Data_LastUpDate 最新データ更新日付
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号を設定します。
     * @param ID_ID_History 履歴番号
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
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
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

}