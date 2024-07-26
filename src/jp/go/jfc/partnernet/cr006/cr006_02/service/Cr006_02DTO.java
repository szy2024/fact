//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/01 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr006_02のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** ステータス */
    private String lblError;
    /** メッセージ */
    private String lblMessage;
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
    /** 受取_顧客名 */
    private String Cr006_02_ID_Name_Customer;
    /** 受取_立替日 */
    private String Cr006_02_ID_Date_Karibarai;
    /** 受取_立替金の種類 */
    private String Cr006_02_ID_Code_KanjoKamoku;
    /** 受取_公庫立替金額(円) */
    private String Cr006_02_ID_M_ToshoKaribarai;
    /** 受取_現在の立替金残高(円) */
    private String Cr006_02_ID_M_KaribaraiZanAfterSeisan;
    /** 受取_債権管理番号 */
    private String Cr006_02_ID_ID_Credit;
    /** 受取_公庫支店 */
    private String Cr006_02_ID_Code_KoukoShiten;
    /** 受取_扱店 */
    private String Cr006_02_ID_Code_Organization;
    /** 受取_店舗 */
    private String Cr006_02_ID_Code_Tenpo;
    /** 受取_年度 */
    private String Cr006_02_ID_Year;
    /** 受取_方式資金 */
    private String Cr006_02_ID_Code_HoshikiShikin;
    /** 受取_番号 */
    private String Cr006_02_ID_ID_Ringi;
    /** 受取_枝番 */
    private String Cr006_02_ID_ID_RingiBranch;
    /** 受取_本支店コード */
    private String Cr006_02_ID_Code_HonShiten2;
    /** 受取_仮受仮払番号 */
    private String Cr006_02_ID_ID_Karibarai;
    /** 受取_仮受仮払勘定科目コード */
    private String Cr006_02_Code_KanjoKamoku;
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
    /** 伝送番号 */
    private String ID_ID_Denso;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** 貸付先コード */
    private String ID_Code_Customer;
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
    public Cr006_02DTO() {
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
    public Cr006_02DTO(Cr006_02DTO orig) {
        super(orig);
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
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
     * @param drpID_Date_ Nyukin_Month 入金日(月)
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
     * @param drpID_Date_ Nyukin_Day 入金日(日)
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
     * 受取_顧客名を取得します。
     * @return 受取_顧客名
     */
    public String getCr006_02_ID_Name_Customer() {
        return Cr006_02_ID_Name_Customer;
    }

    /**
     * 受取_顧客名を設定します。
     * @param Cr006_02_ID_Name_Customer 受取_顧客名
     */
    public void setCr006_02_ID_Name_Customer(String Cr006_02_ID_Name_Customer) {
        this.Cr006_02_ID_Name_Customer = Cr006_02_ID_Name_Customer;
    }

    /**
     * 受取_立替日を取得します。
     * @return 受取_立替日
     */
    public String getCr006_02_ID_Date_Karibarai() {
        return Cr006_02_ID_Date_Karibarai;
    }

    /**
     * 受取_立替日を設定します。
     * @param Cr006_02_ID_Date_Karibarai 受取_立替日
     */
    public void setCr006_02_ID_Date_Karibarai(String Cr006_02_ID_Date_Karibarai) {
        this.Cr006_02_ID_Date_Karibarai = Cr006_02_ID_Date_Karibarai;
    }

    /**
     * 受取_立替金の種類を取得します。
     * @return 受取_立替金の種類
     */
    public String getCr006_02_ID_Code_KanjoKamoku() {
        return Cr006_02_ID_Code_KanjoKamoku;
    }

    /**
     * 受取_立替金の種類を設定します。
     * @param Cr006_02_ID_Code_KanjoKamoku 受取_立替金の種類
     */
    public void setCr006_02_ID_Code_KanjoKamoku(String Cr006_02_ID_Code_KanjoKamoku) {
        this.Cr006_02_ID_Code_KanjoKamoku = Cr006_02_ID_Code_KanjoKamoku;
    }

    /**
     * 受取_公庫立替金額(円)を取得します。
     * @return 受取_公庫立替金額(円)
     */
    public String getCr006_02_ID_M_ToshoKaribarai() {
        return Cr006_02_ID_M_ToshoKaribarai;
    }

    /**
     * 受取_公庫立替金額(円)を設定します。
     * @param Cr006_02_ID_M_ToshoKaribarai 受取_公庫立替金額(円)
     */
    public void setCr006_02_ID_M_ToshoKaribarai(String Cr006_02_ID_M_ToshoKaribarai) {
        this.Cr006_02_ID_M_ToshoKaribarai = Cr006_02_ID_M_ToshoKaribarai;
    }

    /**
     * 受取_現在の立替金残高(円)を取得します。
     * @return 受取_現在の立替金残高(円)
     */
    public String getCr006_02_ID_M_KaribaraiZanAfterSeisan() {
        return Cr006_02_ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 受取_現在の立替金残高(円)を設定します。
     * @param Cr006_02_ID_M_KaribaraiZanAfterSeisan 受取_現在の立替金残高(円)
     */
    public void setCr006_02_ID_M_KaribaraiZanAfterSeisan(String Cr006_02_ID_M_KaribaraiZanAfterSeisan) {
        this.Cr006_02_ID_M_KaribaraiZanAfterSeisan = Cr006_02_ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 受取_債権管理番号を取得します。
     * @return 受取_債権管理番号
     */
    public String getCr006_02_ID_ID_Credit() {
        return Cr006_02_ID_ID_Credit;
    }

    /**
     * 受取_債権管理番号を設定します。
     * @param Cr006_02_ID_ID_Credit 受取_債権管理番号
     */
    public void setCr006_02_ID_ID_Credit(String Cr006_02_ID_ID_Credit) {
        this.Cr006_02_ID_ID_Credit = Cr006_02_ID_ID_Credit;
    }

    /**
     * 受取_公庫支店を取得します。
     * @return 受取_公庫支店
     */
    public String getCr006_02_ID_Code_KoukoShiten() {
        return Cr006_02_ID_Code_KoukoShiten;
    }

    /**
     * 受取_公庫支店を設定します。
     * @param Cr006_02_ID_Code_KoukoShiten 受取_公庫支店
     */
    public void setCr006_02_ID_Code_KoukoShiten(String Cr006_02_ID_Code_KoukoShiten) {
        this.Cr006_02_ID_Code_KoukoShiten = Cr006_02_ID_Code_KoukoShiten;
    }

    /**
     * 受取_扱店を取得します。
     * @return 受取_扱店
     */
    public String getCr006_02_ID_Code_Organization() {
        return Cr006_02_ID_Code_Organization;
    }

    /**
     * 受取_扱店を設定します。
     * @param Cr006_02_ID_Code_Organization 受取_扱店
     */
    public void setCr006_02_ID_Code_Organization(String Cr006_02_ID_Code_Organization) {
        this.Cr006_02_ID_Code_Organization = Cr006_02_ID_Code_Organization;
    }

    /**
     * 受取_店舗を取得します。
     * @return 受取_店舗
     */
    public String getCr006_02_ID_Code_Tenpo() {
        return Cr006_02_ID_Code_Tenpo;
    }

    /**
     * 受取_店舗を設定します。
     * @param Cr006_02_ID_Code_Tenpo 受取_店舗
     */
    public void setCr006_02_ID_Code_Tenpo(String Cr006_02_ID_Code_Tenpo) {
        this.Cr006_02_ID_Code_Tenpo = Cr006_02_ID_Code_Tenpo;
    }

    /**
     * 受取_年度を取得します。
     * @return 受取_年度
     */
    public String getCr006_02_ID_Year() {
        return Cr006_02_ID_Year;
    }

    /**
     * 受取_年度を設定します。
     * @param Cr006_02_ID_Year 受取_年度
     */
    public void setCr006_02_ID_Year(String Cr006_02_ID_Year) {
        this.Cr006_02_ID_Year = Cr006_02_ID_Year;
    }

    /**
     * 受取_方式資金を取得します。
     * @return 受取_方式資金
     */
    public String getCr006_02_ID_Code_HoshikiShikin() {
        return Cr006_02_ID_Code_HoshikiShikin;
    }

    /**
     * 受取_方式資金を設定します。
     * @param Cr006_02_ID_Code_HoshikiShikin 受取_方式資金
     */
    public void setCr006_02_ID_Code_HoshikiShikin(String Cr006_02_ID_Code_HoshikiShikin) {
        this.Cr006_02_ID_Code_HoshikiShikin = Cr006_02_ID_Code_HoshikiShikin;
    }

    /**
     * 受取_番号を取得します。
     * @return 受取_番号
     */
    public String getCr006_02_ID_ID_Ringi() {
        return Cr006_02_ID_ID_Ringi;
    }

    /**
     * 受取_番号を設定します。
     * @param Cr006_02_ID_ID_Ringi 受取_番号
     */
    public void setCr006_02_ID_ID_Ringi(String Cr006_02_ID_ID_Ringi) {
        this.Cr006_02_ID_ID_Ringi = Cr006_02_ID_ID_Ringi;
    }

    /**
     * 受取_枝番を取得します。
     * @return 受取_枝番
     */
    public String getCr006_02_ID_ID_RingiBranch() {
        return Cr006_02_ID_ID_RingiBranch;
    }

    /**
     * 受取_枝番を設定します。
     * @param Cr006_02_ID_ID_RingiBranch 受取_枝番
     */
    public void setCr006_02_ID_ID_RingiBranch(String Cr006_02_ID_ID_RingiBranch) {
        this.Cr006_02_ID_ID_RingiBranch = Cr006_02_ID_ID_RingiBranch;
    }

    /**
     * 受取_本支店コードを取得します。
     * @return 受取_本支店コード
     */
    public String getCr006_02_ID_Code_HonShiten2() {
        return Cr006_02_ID_Code_HonShiten2;
    }

    /**
     * 受取_本支店コードを設定します。
     * @param Cr006_02_ID_Code_HonShiten2 受取_本支店コード
     */
    public void setCr006_02_ID_Code_HonShiten2(String Cr006_02_ID_Code_HonShiten2) {
        this.Cr006_02_ID_Code_HonShiten2 = Cr006_02_ID_Code_HonShiten2;
    }

    /**
     * 受取_仮受仮払番号を取得します。
     * @return 受取_仮受仮払番号
     */
    public String getCr006_02_ID_ID_Karibarai() {
        return Cr006_02_ID_ID_Karibarai;
    }

    /**
     * 受取_仮受仮払番号を設定します。
     * @param Cr006_02_ID_ID_Karibarai 受取_仮受仮払番号
     */
    public void setCr006_02_ID_ID_Karibarai(String Cr006_02_ID_ID_Karibarai) {
        this.Cr006_02_ID_ID_Karibarai = Cr006_02_ID_ID_Karibarai;
    }

    /**
     * 受取_仮受仮払勘定科目コードを取得します。
     * @return 受取_仮受仮払勘定科目コード
     */
    public String getCr006_02_Code_KanjoKamoku() {
        return Cr006_02_Code_KanjoKamoku;
    }

    /**
     * 受取_仮受仮払勘定科目コードを設定します。
     * @param Cr006_02_Code_KanjoKamoku 受取_仮受仮払勘定科目コード
     */
    public void setCr006_02_Code_KanjoKamoku(String Cr006_02_Code_KanjoKamoku) {
        this.Cr006_02_Code_KanjoKamoku = Cr006_02_Code_KanjoKamoku;
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
     * 伝送番号を取得します。
     * @return 送金年月日
     */
    public String getID_ID_Denso() {
        return ID_ID_Denso;
    }

    /**
     * 伝送番号を設定します。
     * @param ID_ID_Denso 伝送番号
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        this.ID_ID_Denso = ID_ID_Denso;
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
     * 貸付先コードを取得します。
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 貸付先コードを設定します。
     * @param ID_Code_Customer 貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
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