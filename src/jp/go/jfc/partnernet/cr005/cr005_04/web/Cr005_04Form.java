//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr005_04のFormクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr005_04Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** ステータス */
    private String lblError;
    /** メッセージ */
    private String lblMessage;
    /** 債権管理番号表示 */
    private String lblID_ID_Credit_Display;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 顧客名 */
    private String txtID_Name_Customer;
    /** 扱店名 */
    private String txtID_Name_Organization;
    /** 公庫支店 */
    private String txtID_Code_ShokanHonShiten;
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
    /** 充当対象払込期日（元号） */
    private String drpID_Date_JutoTaishoGengou;
    /** 充当対象払込期日（年） */
    private String txtID_Date_JutoTaishoYear;
    /** 充当対象払込期日（月） */
    private String drpID_Date_JutoTaishoMonth;
    /** 充当対象払込期日（日） */
    private String drpID_Date_JutoTaishoDay;
    /** 代弁金払込日（元号） */
    private String drpID_Date_DaibenkinHaraikomiGengou;
    /** 代弁金払込日（年） */
    private String txtID_Date_DaibenkinHaraikomiYear;
    /** 代弁金払込日（月） */
    private String drpID_Date_DaibenkinHaraikomiMonth;
    /** 代弁金払込日（日） */
    private String drpID_Date_DaibenkinHaraikomiDay;
    /** 遅延損害金(円) */
    private String txtID_M_ChienSongai;
    /** 利息(円) */
    private String txtID_M_Risoku;
    /** 繰上償還手数料(円) */
    private String txtID_M_KurishoCommission;
    /** 元金(円) */
    private String txtID_M_Gankin;
    /** 仮受金(一般口)からの充当額(円) */
    private String txtID_M_KariukeIppanJuto;
    /** 計(円) */
    private String txtID_M_Kei;
    /** 送金額(円) */
    private String txtID_M_Sokin;
    /** 代弁金充当後残元金(円) */
    private String txtID_M_ZanGanAfterDaibenJuto;
    /** 受託者勘定処理年月（元号） */
    private String drpID_Date_JtkshoriGengou;
    /** 受託者勘定処理年月（年） */
    private String txtID_Date_JtkshoriYear;
    /** 受託者勘定処理年月（月） */
    private String drpID_Date_JtkshoriMonth;
    /** 送金年月日（元号） */
    private String drpID_Date_SokinGengou;
    /** 送金年月日（年） */
    private String txtID_Date_SokinYear;
    /** 送金年月日（月） */
    private String drpID_Date_SokinMonth;
    /** 送金年月日（日） */
    private String drpID_Date_SokinDay;
    /** 送金日番号 */
    private String txtID_Code_Sokin;
    /** 債権管理番号（受渡情報) */
    private String Cr005_04_ID_Credit;
    /** 公庫支店コード（受渡情報) */
    private String Cr005_04_Code_ShokanHonShiten;
    /** 扱店コード（受渡情報) */
    private String Cr005_04_Code_Organization;
    /** 店舗コード（受渡情報) */
    private String Cr005_04_Code_Tenpo;
    /** 年度（受渡情報) */
    private String Cr005_04_Year;
    /** 方式資金（受渡情報) */
    private String Cr005_04_Code_HoshikiShikin;
    /** 番号（受渡情報) */
    private String Cr005_04_ID_Ringi;
    /** 枝番（受渡情報) */
    private String Cr005_04_ID_RingiBranch;
    /** 償還期限年月 */
    private String ID_Date_ShokanKigen;
    /** 最新更新日時 */
    private String ID_Data_LastUpDate;
    /** 債権管理番号 */
    private String ID_Credit;
    /** 貸付金残高 */
    private String ID_M_KashitsukeZandaka;
    /** 先行する報告書の有無 */
    private boolean ID_Previous_Report;
    /** 先行する報告書名 */
    private String ID_Previous_ReportType;
    /** 充当対象払込期日 */
    private String ID_Date_JutoTaisho;
    /** 代弁金払込日 */
    private String ID_Date_DaibenkinHaraikomi;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 送金年月日 */
    private String ID_Date_Sokin;
    /** 退避請求繰上償還利息 */
    private String ID_Keep_Seikyu_M_SeiKuriRisoku;
    /** 退避約定利息 */
    private String ID_Keep_M_YakujoRisoku;
    /** 請求繰上償還利息・仮更新値 */
    private String ID_M_SeiKuriRisoku;
    /** 約定利息・仮更新値 */
    private String ID_M_YakujoRisoku;
    /** 退避請求繰上償還元金 */
    private String ID_Keep_Seikyu_M_SeiKuriGankin;
    /** 退避約定元金 */
    private String ID_Keep_M_YakujoGankin;
    /** 請求繰上償還元金・仮更新値 */
    private String ID_M_SeiKuriGankin;
    /** 約定元金・仮更新値 */
    private String ID_M_YakujoGankin;
    /** ユーザID */
    private String ID_UserID;
    /** 伝送番号 */
    private String ID_ID_Denso;
    /** データコード */
    private String ID_DataCode;
    /** ステータス */
    private String ID_Status;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 項目エラーフラグ */
    private String ID_Error;
    /** 請求検索日付 */
    private String ID_Date_SearchSeikyu;
    /** 請求検索結果・取得件数 */
    private String ID_SeikyuCount;
    /** 請求検索結果・約定元金 */
    private String ID_M_YakujoGankin_SeikyuAns;
    /** 請求検索結果・約定利息 */
    private String ID_M_YakujoRisoku_SeikyuAns;
    /** 請求検索結果・請求繰上償還元金 */
    private String ID_M_SeiKuriGankin_SeikyuAns;
    /** 請求検索結果・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_SeikyuAns;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** 報告書 */
    private String report1;
    /** 受託者勘定処理年月（元号）（隠し項目） */
    private String hdnID_Date_JtkshoriGengou;
    /** 受託者勘定処理年月（月）（隠し項目） */
    private String hdnID_Date_JtkshoriMonth;
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
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     *
     * @param lblMessage
     *            メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 債権管理番号表示を取得します。
     *
     * @return メッセージ
     */
    public String getLblID_ID_Credit_Display() {
        return lblID_ID_Credit_Display;
    }

    /**
     * 債権管理番号表示を設定します。
     *
     * @param lblMessage
     *            メッセージ
     */
    public void setLblID_ID_Credit_Display(String lblID_ID_Credit_Display) {
        this.lblID_ID_Credit_Display = lblID_ID_Credit_Display;
    }

    /**
     * 債権管理番号を取得します。
     *
     * @return メッセージ
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     *
     * @param lblMessage
     *            メッセージ
     */
    public void setID_ID_Credit_Display(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 顧客名を取得します。
     *
     * @return 顧客名
     */
    public String getTxtID_Name_Customer() {
        return txtID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     *
     * @param txtID_Name_Customer
     *            顧客名
     */
    public void setTxtID_Name_Customer(String txtID_Name_Customer) {
        this.txtID_Name_Customer = txtID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getTxtID_Name_Organization() {
        return txtID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param txtID_Name_Organization
     *            扱店名
     */
    public void setTxtID_Name_Organization(String txtID_Name_Organization) {
        this.txtID_Name_Organization = txtID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     *
     * @return 公庫支店
     */
    public String getTxtID_Code_ShokanHonShiten() {
        return txtID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     *
     * @param txtID_Code_ShokanHonShiten
     *            公庫支店
     */
    public void setTxtID_Code_ShokanHonShiten(String txtID_Code_ShokanHonShiten) {
        this.txtID_Code_ShokanHonShiten = txtID_Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param txtID_Code_Organization
     *            扱店
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param txtID_Code_Tenpo
     *            店舗
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度を設定します。
     *
     * @param txtID_Year
     *            年度
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金を取得します。
     *
     * @return 方式資金
     */
    public String getTxtID_Code_HoshikiShikin() {
        return txtID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     *
     * @param txtID_Code_HoshikiShikin
     *            方式資金
     */
    public void setTxtID_Code_HoshikiShikin(String txtID_Code_HoshikiShikin) {
        this.txtID_Code_HoshikiShikin = txtID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     *
     * @return 番号
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     *
     * @param txtID_ID_Ringi
     *            番号
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     *
     * @param txtID_ID_RingiBranch
     *            枝番
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 充当対象払込期日（元号）を取得します。
     *
     * @return 充当対象払込期日（元号）
     */
    public String getDrpID_Date_JutoTaishoGengou() {
        return drpID_Date_JutoTaishoGengou;
    }

    /**
     * 充当対象払込期日（元号）を設定します。
     *
     * @param drpID_Date_JutoTaishoGengou
     *            充当対象払込期日（元号）
     */
    public void setDrpID_Date_JutoTaishoGengou(
            String drpID_Date_JutoTaishoGengou) {
        this.drpID_Date_JutoTaishoGengou = drpID_Date_JutoTaishoGengou;
    }

    /**
     * 充当対象払込期日（年）を取得します。
     *
     * @return 充当対象払込期日（年）
     */
    public String getTxtID_Date_JutoTaishoYear() {
        return txtID_Date_JutoTaishoYear;
    }

    /**
     * 充当対象払込期日（年）を設定します。
     *
     * @param txtID_Date_JutoTaishoYear
     *            充当対象払込期日（年）
     */
    public void setTxtID_Date_JutoTaishoYear(String txtID_Date_JutoTaishoYear) {
        this.txtID_Date_JutoTaishoYear = txtID_Date_JutoTaishoYear;
    }

    /**
     * 充当対象払込期日（月）を取得します。
     *
     * @return 充当対象払込期日（月）
     */
    public String getDrpID_Date_JutoTaishoMonth() {
        return drpID_Date_JutoTaishoMonth;
    }

    /**
     * 充当対象払込期日（月）を設定します。
     *
     * @param drpID_Date_JutoTaishoMonth
     *            充当対象払込期日（月）
     */
    public void setDrpID_Date_JutoTaishoMonth(String drpID_Date_JutoTaishoMonth) {
        this.drpID_Date_JutoTaishoMonth = drpID_Date_JutoTaishoMonth;
    }

    /**
     * 充当対象払込期日（日）を取得します。
     *
     * @return 充当対象払込期日（日）
     */
    public String getDrpID_Date_JutoTaishoDay() {
        return drpID_Date_JutoTaishoDay;
    }

    /**
     * 充当対象払込期日（日）を設定します。
     *
     * @param drpID_Date_JutoTaishoDay
     *            充当対象払込期日（日）
     */
    public void setDrpID_Date_JutoTaishoDay(String drpID_Date_JutoTaishoDay) {
        this.drpID_Date_JutoTaishoDay = drpID_Date_JutoTaishoDay;
    }

    /**
     * 代弁金払込日（元号）を取得します。
     *
     * @return 代弁金払込日（元号）
     */
    public String getDrpID_Date_DaibenkinHaraikomiGengou() {
        return drpID_Date_DaibenkinHaraikomiGengou;
    }

    /**
     * 代弁金払込日（元号）を設定します。
     *
     * @param drpID_Date_DaibenkinHaraikomiGengou
     *            代弁金払込日（元号）
     */
    public void setDrpID_Date_DaibenkinHaraikomiGengou(
            String drpID_Date_DaibenkinHaraikomiGengou) {
        this.drpID_Date_DaibenkinHaraikomiGengou = drpID_Date_DaibenkinHaraikomiGengou;
    }

    /**
     * 代弁金払込日（年）を取得します。
     *
     * @return 代弁金払込日（年）
     */
    public String getTxtID_Date_DaibenkinHaraikomiYear() {
        return txtID_Date_DaibenkinHaraikomiYear;
    }

    /**
     * 代弁金払込日（年）を設定します。
     *
     * @param txtID_Date_DaibenkinHaraikomiYear
     *            代弁金払込日（年）
     */
    public void setTxtID_Date_DaibenkinHaraikomiYear(
            String txtID_Date_DaibenkinHaraikomiYear) {
        this.txtID_Date_DaibenkinHaraikomiYear = txtID_Date_DaibenkinHaraikomiYear;
    }

    /**
     * 代弁金払込日（月）を取得します。
     *
     * @return 代弁金払込日（月）
     */
    public String getDrpID_Date_DaibenkinHaraikomiMonth() {
        return drpID_Date_DaibenkinHaraikomiMonth;
    }

    /**
     * 代弁金払込日（月）を設定します。
     *
     * @param drpID_Date_DaibenkinHaraikomiMonth
     *            代弁金払込日（月）
     */
    public void setDrpID_Date_DaibenkinHaraikomiMonth(
            String drpID_Date_DaibenkinHaraikomiMonth) {
        this.drpID_Date_DaibenkinHaraikomiMonth = drpID_Date_DaibenkinHaraikomiMonth;
    }

    /**
     * 代弁金払込日（日）を取得します。
     *
     * @return 代弁金払込日（日）
     */
    public String getDrpID_Date_DaibenkinHaraikomiDay() {
        return drpID_Date_DaibenkinHaraikomiDay;
    }

    /**
     * 代弁金払込日（日）を設定します。
     *
     * @param drpID_Date_DaibenkinHaraikomiDay
     *            代弁金払込日（日）
     */
    public void setDrpID_Date_DaibenkinHaraikomiDay(
            String drpID_Date_DaibenkinHaraikomiDay) {
        this.drpID_Date_DaibenkinHaraikomiDay = drpID_Date_DaibenkinHaraikomiDay;
    }

    /**
     * 遅延損害金(円)を取得します。
     *
     * @return 遅延損害金(円)
     */
    public String getTxtID_M_ChienSongai() {
        return txtID_M_ChienSongai;
    }

    /**
     * 遅延損害金(円)を設定します。
     *
     * @param txtID_M_ChienSongai
     *            遅延損害金(円)
     */
    public void setTxtID_M_ChienSongai(String txtID_M_ChienSongai) {
        this.txtID_M_ChienSongai = txtID_M_ChienSongai;
    }

    /**
     * 利息(円)を取得します。
     *
     * @return 利息(円)
     */
    public String getTxtID_M_Risoku() {
        return txtID_M_Risoku;
    }

    /**
     * 利息(円)を設定します。
     *
     * @param txtID_M_Risoku
     *            利息(円)
     */
    public void setTxtID_M_Risoku(String txtID_M_Risoku) {
        this.txtID_M_Risoku = txtID_M_Risoku;
    }

    /**
     * 繰上償還手数料(円)を取得します。
     *
     * @return 繰上償還手数料(円)
     */
    public String getTxtID_M_KurishoCommission() {
        return txtID_M_KurishoCommission;
    }

    /**
     * 繰上償還手数料(円)を設定します。
     *
     * @param txtID_M_KurishoCommission
     *            繰上償還手数料(円)
     */
    public void setTxtID_M_KurishoCommission(String txtID_M_KurishoCommission) {
        this.txtID_M_KurishoCommission = txtID_M_KurishoCommission;
    }

    /**
     * 元金(円)を取得します。
     *
     * @return 元金(円)
     */
    public String getTxtID_M_Gankin() {
        return txtID_M_Gankin;
    }

    /**
     * 元金(円)を設定します。
     *
     * @param txtID_M_Gankin
     *            元金(円)
     */
    public void setTxtID_M_Gankin(String txtID_M_Gankin) {
        this.txtID_M_Gankin = txtID_M_Gankin;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     *
     * @return 仮受金(一般口)からの充当額(円)
     */
    public String getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     *
     * @param txtID_M_KariukeIppanJuto
     *            仮受金(一般口)からの充当額(円)
     */
    public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 計(円)を取得します。
     *
     * @return 計(円)
     */
    public String getTxtID_M_Kei() {
        return txtID_M_Kei;
    }

    /**
     * 計(円)を設定します。
     *
     * @param txtID_M_Kei
     *            計(円)
     */
    public void setTxtID_M_Kei(String txtID_M_Kei) {
        this.txtID_M_Kei = txtID_M_Kei;
    }

    /**
     * 送金額(円)を取得します。
     *
     * @return 送金額(円)
     */
    public String getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額(円)を設定します。
     *
     * @param txtID_M_Sokin
     *            送金額(円)
     */
    public void setTxtID_M_Sokin(String txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 代弁金充当後残元金(円)を取得します。
     *
     * @return 代弁金充当後残元金(円)
     */
    public String getTxtID_M_ZanGanAfterDaibenJuto() {
        return txtID_M_ZanGanAfterDaibenJuto;
    }

    /**
     * 代弁金充当後残元金(円)を設定します。
     *
     * @param txtID_M_ZanGanAfterDaibenJuto
     *            代弁金充当後残元金(円)
     */
    public void setTxtID_M_ZanGanAfterDaibenJuto(
            String txtID_M_ZanGanAfterDaibenJuto) {
        this.txtID_M_ZanGanAfterDaibenJuto = txtID_M_ZanGanAfterDaibenJuto;
    }

    /**
     * 受託者勘定処理年月（元号）を取得します。
     *
     * @return 受託者勘定処理年月（元号）
     */
    public String getDrpID_Date_JtkshoriGengou() {
        return drpID_Date_JtkshoriGengou;
    }

    /**
     * 受託者勘定処理年月（元号）を設定します。
     *
     * @param drpID_Date_JtkshoriGengou
     *            受託者勘定処理年月（元号）
     */
    public void setDrpID_Date_JtkshoriGengou(String drpID_Date_JtkshoriGengou) {
        this.drpID_Date_JtkshoriGengou = drpID_Date_JtkshoriGengou;
    }

    /**
     * 受託者勘定処理年月（年）を取得します。
     *
     * @return 受託者勘定処理年月（年）
     */
    public String getTxtID_Date_JtkshoriYear() {
        return txtID_Date_JtkshoriYear;
    }

    /**
     * 受託者勘定処理年月（年）を設定します。
     *
     * @param txtID_Date_JtkshoriYear
     *            受託者勘定処理年月（年）
     */
    public void setTxtID_Date_JtkshoriYear(String txtID_Date_JtkshoriYear) {
        this.txtID_Date_JtkshoriYear = txtID_Date_JtkshoriYear;
    }

    /**
     * 受託者勘定処理年月（月）を取得します。
     *
     * @return 受託者勘定処理年月（月）
     */
    public String getDrpID_Date_JtkshoriMonth() {
        return drpID_Date_JtkshoriMonth;
    }

    /**
     * 受託者勘定処理年月（月）を設定します。
     *
     * @param drpID_Date_JtkshoriMonth
     *            受託者勘定処理年月（月）
     */
    public void setDrpID_Date_JtkshoriMonth(String drpID_Date_JtkshoriMonth) {
        this.drpID_Date_JtkshoriMonth = drpID_Date_JtkshoriMonth;
    }

    /**
     * 送金年月日（元号）を取得します。
     *
     * @return 送金年月日（元号）
     */
    public String getDrpID_Date_SokinGengou() {
        return drpID_Date_SokinGengou;
    }

    /**
     * 送金年月日（元号）を設定します。
     *
     * @param drpID_Date_SokinGengou
     *            送金年月日（元号）
     */
    public void setDrpID_Date_SokinGengou(String drpID_Date_SokinGengou) {
        this.drpID_Date_SokinGengou = drpID_Date_SokinGengou;
    }

    /**
     * 送金年月日（年）を取得します。
     *
     * @return 送金年月日（年）
     */
    public String getTxtID_Date_SokinYear() {
        return txtID_Date_SokinYear;
    }

    /**
     * 送金年月日（年）を設定します。
     *
     * @param txtID_Date_SokinYear
     *            送金年月日（年）
     */
    public void setTxtID_Date_SokinYear(String txtID_Date_SokinYear) {
        this.txtID_Date_SokinYear = txtID_Date_SokinYear;
    }

    /**
     * 送金年月日（月）を取得します。
     *
     * @return 送金年月日（月）
     */
    public String getDrpID_Date_SokinMonth() {
        return drpID_Date_SokinMonth;
    }

    /**
     * 送金年月日（月）を設定します。
     *
     * @param drpID_Date_SokinMonth
     *            送金年月日（月）
     */
    public void setDrpID_Date_SokinMonth(String drpID_Date_SokinMonth) {
        this.drpID_Date_SokinMonth = drpID_Date_SokinMonth;
    }

    /**
     * 送金年月日（日）を取得します。
     *
     * @return 送金年月日（日）
     */
    public String getDrpID_Date_SokinDay() {
        return drpID_Date_SokinDay;
    }

    /**
     * 送金年月日（日）を設定します。
     *
     * @param drpID_Date_SokinDay
     *            送金年月日（日）
     */
    public void setDrpID_Date_SokinDay(String drpID_Date_SokinDay) {
        this.drpID_Date_SokinDay = drpID_Date_SokinDay;
    }

    /**
     * 送金日番号を取得します。
     *
     * @return 送金日番号
     */
    public String getTxtID_Code_Sokin() {
        return txtID_Code_Sokin;
    }

    /**
     * 送金日番号を設定します。
     *
     * @param txtID_Code_Sokin
     *            送金日番号
     */
    public void setTxtID_Code_Sokin(String txtID_Code_Sokin) {
        this.txtID_Code_Sokin = txtID_Code_Sokin;
    }

    /**
     * 債権管理番号（受渡情報)を取得します。
     *
     * @return 債権管理番号（受渡情報)
     */
    public String getCr005_04_ID_Credit() {
        return Cr005_04_ID_Credit;
    }

    /**
     * 債権管理番号（受渡情報)を設定します。
     *
     * @param Cr005_04_ID_Credit
     *            債権管理番号（受渡情報)
     */
    public void setCr005_04_ID_Credit(String Cr005_04_ID_Credit) {
        this.Cr005_04_ID_Credit = Cr005_04_ID_Credit;
    }

    /**
     * 公庫支店コード（受渡情報)を取得します。
     *
     * @return 公庫支店コード（受渡情報)
     */
    public String getCr005_04_Code_ShokanHonShiten() {
        return Cr005_04_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コード（受渡情報)を設定します。
     *
     * @param Cr005_04_Code_ShokanHonShiten
     *            公庫支店コード（受渡情報)
     */
    public void setCr005_04_Code_ShokanHonShiten(
            String Cr005_04_Code_ShokanHonShiten) {
        this.Cr005_04_Code_ShokanHonShiten = Cr005_04_Code_ShokanHonShiten;
    }

    /**
     * 扱店コード（受渡情報)を取得します。
     *
     * @return 扱店コード（受渡情報)
     */
    public String getCr005_04_Code_Organization() {
        return Cr005_04_Code_Organization;
    }

    /**
     * 扱店コード（受渡情報)を設定します。
     *
     * @param Cr005_04_Code_Organization
     *            扱店コード（受渡情報)
     */
    public void setCr005_04_Code_Organization(String Cr005_04_Code_Organization) {
        this.Cr005_04_Code_Organization = Cr005_04_Code_Organization;
    }

    /**
     * 店舗コード（受渡情報)を取得します。
     *
     * @return 店舗コード（受渡情報)
     */
    public String getCr005_04_Code_Tenpo() {
        return Cr005_04_Code_Tenpo;
    }

    /**
     * 店舗コード（受渡情報)を設定します。
     *
     * @param Cr005_04_Code_Tenpo
     *            店舗コード（受渡情報)
     */
    public void setCr005_04_Code_Tenpo(String Cr005_04_Code_Tenpo) {
        this.Cr005_04_Code_Tenpo = Cr005_04_Code_Tenpo;
    }

    /**
     * 年度（受渡情報)を取得します。
     *
     * @return 年度（受渡情報)
     */
    public String getCr005_04_Year() {
        return Cr005_04_Year;
    }

    /**
     * 年度（受渡情報)を設定します。
     *
     * @param Cr005_04_Year
     *            年度（受渡情報)
     */
    public void setCr005_04_Year(String Cr005_04_Year) {
        this.Cr005_04_Year = Cr005_04_Year;
    }

    /**
     * 方式資金（受渡情報)を取得します。
     *
     * @return 方式資金（受渡情報)
     */
    public String getCr005_04_Code_HoshikiShikin() {
        return Cr005_04_Code_HoshikiShikin;
    }

    /**
     * 方式資金（受渡情報)を設定します。
     *
     * @param Cr005_04_Code_HoshikiShikin
     *            方式資金（受渡情報)
     */
    public void setCr005_04_Code_HoshikiShikin(
            String Cr005_04_Code_HoshikiShikin) {
        this.Cr005_04_Code_HoshikiShikin = Cr005_04_Code_HoshikiShikin;
    }

    /**
     * 番号（受渡情報)を取得します。
     *
     * @return 番号（受渡情報)
     */
    public String getCr005_04_ID_Ringi() {
        return Cr005_04_ID_Ringi;
    }

    /**
     * 番号（受渡情報)を設定します。
     *
     * @param Cr005_04_ID_Ringi
     *            番号（受渡情報)
     */
    public void setCr005_04_ID_Ringi(String Cr005_04_ID_Ringi) {
        this.Cr005_04_ID_Ringi = Cr005_04_ID_Ringi;
    }

    /**
     * 枝番（受渡情報)を取得します。
     *
     * @return 枝番（受渡情報)
     */
    public String getCr005_04_ID_RingiBranch() {
        return Cr005_04_ID_RingiBranch;
    }

    /**
     * 枝番（受渡情報)を設定します。
     *
     * @param Cr005_04_ID_RingiBranch
     *            枝番（受渡情報)
     */
    public void setCr005_04_ID_RingiBranch(String Cr005_04_ID_RingiBranch) {
        this.Cr005_04_ID_RingiBranch = Cr005_04_ID_RingiBranch;
    }

    /**
     * 償還期限年月を取得します。
     *
     * @return 償還期限年月
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限年月を設定します。
     *
     * @param ID_Date_ShokanKigen
     *            償還期限年月
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 最新更新日時を取得します。
     *
     * @return 最新更新日時
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最新更新日時を設定します。
     *
     * @param ID_Data_LastUpDate
     *            最新更新日時
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 債権管理番号を取得します。
     *
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     *
     * @param ID_Credit
     *            債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        this.ID_Credit = ID_Credit;
    }

    /**
     * 貸付金残高を取得します。
     *
     * @return 貸付金残高
     */
    public String getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 貸付金残高を設定します。
     *
     * @param ID_M_KashitsukeZandaka
     *            貸付金残高
     */
    public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
        this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
    }

    /**
     * 先行する報告書の有無を取得します。
     *
     * @return 先行する報告書の有無
     */
    public boolean getID_Previous_Report() {
        return ID_Previous_Report;
    }

    /**
     * 先行する報告書の有無を設定します。
     *
     * @param ID_Previous_Report
     *            先行する報告書の有無
     */
    public void setID_Previous_Report(boolean ID_Previous_Report) {
        this.ID_Previous_Report = ID_Previous_Report;
    }

    /**
     * 先行する報告書名を取得します。
     *
     * @return 先行する報告書名
     */
    public String getID_Previous_ReportType() {
        return ID_Previous_ReportType;
    }

    /**
     * 先行する報告書名を設定します。
     *
     * @param ID_Previous_ReportType
     *            先行する報告書名
     */
    public void setID_Previous_ReportType(String ID_Previous_ReportType) {
        this.ID_Previous_ReportType = ID_Previous_ReportType;
    }

    /**
     * 充当対象払込期日を取得します。
     *
     * @return 充当対象払込期日
     */
    public String getID_Date_JutoTaisho() {
        return ID_Date_JutoTaisho;
    }

    /**
     * 充当対象払込期日を設定します。
     *
     * @param ID_Date_JutoTaisho
     *            充当対象払込期日
     */
    public void setID_Date_JutoTaisho(String ID_Date_JutoTaisho) {
        this.ID_Date_JutoTaisho = ID_Date_JutoTaisho;
    }

    /**
     * 代弁金払込日を取得します。
     *
     * @return 代弁金払込日
     */
    public String getID_Date_DaibenkinHaraikomi() {
        return ID_Date_DaibenkinHaraikomi;
    }

    /**
     * 代弁金払込日を設定します。
     *
     * @param ID_Date_DaibenkinHaraikomi
     *            代弁金払込日
     */
    public void setID_Date_DaibenkinHaraikomi(String ID_Date_DaibenkinHaraikomi) {
        this.ID_Date_DaibenkinHaraikomi = ID_Date_DaibenkinHaraikomi;
    }

    /**
     * 受託者勘定処理年月を取得します。
     *
     * @return 受託者勘定処理年月
     */
    public String getID_Date_Jtkshori() {
        return ID_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     *
     * @param ID_Date_Jtkshori
     *            受託者勘定処理年月
     */
    public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
        this.ID_Date_Jtkshori = ID_Date_Jtkshori;
    }

    /**
     * 送金年月日を取得します。
     *
     * @return 送金年月日
     */
    public String getID_Date_Sokin() {
        return ID_Date_Sokin;
    }

    /**
     * 送金年月日を設定します。
     *
     * @param ID_Date_Sokin
     *            送金年月日
     */
    public void setID_Date_Sokin(String ID_Date_Sokin) {
        this.ID_Date_Sokin = ID_Date_Sokin;
    }

    /**
     * 退避請求繰上償還利息を取得します。
     *
     * @return 退避請求繰上償還利息
     */
    public String getID_Keep_Seikyu_M_SeiKuriRisoku() {
        return ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 退避請求繰上償還利息を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriRisoku
     *            退避請求繰上償還利息
     */
    public void setID_Keep_Seikyu_M_SeiKuriRisoku(
            String ID_Keep_Seikyu_M_SeiKuriRisoku) {
        this.ID_Keep_Seikyu_M_SeiKuriRisoku = ID_Keep_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 退避約定利息を取得します。
     *
     * @return 退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku() {
        return ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避約定利息を設定します。
     *
     * @param ID_Keep_M_YakujoRisoku
     *            退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
        this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
    }

    /**
     * 請求繰上償還利息・仮更新値を取得します。
     *
     * @return 請求繰上償還利息・仮更新値
     */
    public String getID_M_SeiKuriRisoku() {
        return ID_M_SeiKuriRisoku;
    }

    /**
     * 請求繰上償還利息・仮更新値を設定します。
     *
     * @param ID_M_SeiKuriRisoku
     *            請求繰上償還利息・仮更新値
     */
    public void setID_M_SeiKuriRisoku(String ID_M_SeiKuriRisoku) {
        this.ID_M_SeiKuriRisoku = ID_M_SeiKuriRisoku;
    }

    /**
     * 約定利息・仮更新値を取得します。
     *
     * @return 約定利息・仮更新値
     */
    public String getID_M_YakujoRisoku() {
        return ID_M_YakujoRisoku;
    }

    /**
     * 約定利息・仮更新値を設定します。
     *
     * @param ID_M_YakujoRisoku
     *            約定利息・仮更新値
     */
    public void setID_M_YakujoRisoku(String ID_M_YakujoRisoku) {
        this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
    }

    /**
     * 退避請求繰上償還元金を取得します。
     *
     * @return 退避請求繰上償還元金
     */
    public String getID_Keep_Seikyu_M_SeiKuriGankin() {
        return ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 退避請求繰上償還元金を設定します。
     *
     * @param ID_Keep_Seikyu_M_SeiKuriGankin
     *            退避請求繰上償還元金
     */
    public void setID_Keep_Seikyu_M_SeiKuriGankin(
            String ID_Keep_Seikyu_M_SeiKuriGankin) {
        this.ID_Keep_Seikyu_M_SeiKuriGankin = ID_Keep_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 退避約定元金を取得します。
     *
     * @return 退避約定元金
     */
    public String getID_Keep_M_YakujoGankin() {
        return ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定元金を設定します。
     *
     * @param ID_Keep_M_YakujoGankin
     *            退避約定元金
     */
    public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
        this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
    }

    /**
     * 請求繰上償還元金・仮更新値を取得します。
     *
     * @return 請求繰上償還元金・仮更新値
     */
    public String getID_M_SeiKuriGankin() {
        return ID_M_SeiKuriGankin;
    }

    /**
     * 請求繰上償還元金・仮更新値を設定します。
     *
     * @param ID_M_SeiKuriGankin
     *            請求繰上償還元金・仮更新値
     */
    public void setID_M_SeiKuriGankin(String ID_M_SeiKuriGankin) {
        this.ID_M_SeiKuriGankin = ID_M_SeiKuriGankin;
    }

    /**
     * 約定元金・仮更新値を取得します。
     *
     * @return 約定元金・仮更新値
     */
    public String getID_M_YakujoGankin() {
        return ID_M_YakujoGankin;
    }

    /**
     * 約定元金・仮更新値を設定します。
     *
     * @param ID_M_YakujoGankin
     *            約定元金・仮更新値
     */
    public void setID_M_YakujoGankin(String ID_M_YakujoGankin) {
        this.ID_M_YakujoGankin = ID_M_YakujoGankin;
    }

    /**
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public String getID_UserID() {
        return ID_UserID;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param ID_UserID
     *            ユーザID
     */
    public void setID_UserID(String ID_UserID) {
        this.ID_UserID = ID_UserID;
    }

    /**
     * 伝送番号を取得します。
     *
     * @return 伝送番号
     */
    public String getID_ID_Denso() {
        return ID_ID_Denso;
    }

    /**
     * 伝送番号を設定します。
     *
     * @param ID_ID_Denso
     *            伝送番号
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        this.ID_ID_Denso = ID_ID_Denso;
    }

    /**
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコードを設定します。
     *
     * @param ID_DataCode
     *            データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータスを設定します。
     *
     * @param ID_Status
     *            ステータス
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 取消済フラグを取得します。
     *
     * @return 取消済フラグ
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済フラグを設定します。
     *
     * @param ID_Flag_Torikeshizumi
     *            取消済フラグ
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * 処理種別を取得します。
     *
     * @return 処理種別
     */
    public String getID_Type_Process() {
        return ID_Type_Process;
    }

    /**
     * 処理種別を設定します。
     *
     * @param ID_Type_Process
     *            処理種別
     */
    public void setID_Type_Process(String ID_Type_Process) {
        this.ID_Type_Process = ID_Type_Process;
    }

    /**
     * 項目エラーフラグを取得します。
     *
     * @return 項目エラーフラグ
     */
    public String getID_Error() {
        return ID_Error;
    }

    /**
     * 項目エラーフラグを設定します。
     *
     * @param ID_Error
     *            項目エラーフラグ
     */
    public void setID_Error(String ID_Error) {
        this.ID_Error = ID_Error;
    }

    /**
     * 請求検索日付を取得します。
     *
     * @return 請求検索日付
     */
    public String getID_Date_SearchSeikyu() {
        return ID_Date_SearchSeikyu;
    }

    /**
     * 請求検索日付を設定します。
     *
     * @param ID_Date_SearchSeikyu
     *            請求検索日付
     */
    public void setID_Date_SearchSeikyu(String ID_Date_SearchSeikyu) {
        this.ID_Date_SearchSeikyu = ID_Date_SearchSeikyu;
    }

    /**
     * 請求検索結果・取得件数を取得します。
     *
     * @return 請求検索結果・取得件数
     */
    public String getID_SeikyuCount() {
        return ID_SeikyuCount;
    }

    /**
     * 請求検索結果・取得件数を設定します。
     *
     * @param ID_SeikyuCount
     *            請求検索結果・取得件数
     */
    public void setID_SeikyuCount(String ID_SeikyuCount) {
        this.ID_SeikyuCount = ID_SeikyuCount;
    }

    /**
     * 請求検索結果・約定元金を取得します。
     *
     * @return 請求検索結果・約定元金
     */
    public String getID_M_YakujoGankin_SeikyuAns() {
        return ID_M_YakujoGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・約定元金を設定します。
     *
     * @param ID_M_YakujoGankin_SeikyuAns
     *            請求検索結果・約定元金
     */
    public void setID_M_YakujoGankin_SeikyuAns(
            String ID_M_YakujoGankin_SeikyuAns) {
        this.ID_M_YakujoGankin_SeikyuAns = ID_M_YakujoGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・約定利息を取得します。
     *
     * @return 請求検索結果・約定利息
     */
    public String getID_M_YakujoRisoku_SeikyuAns() {
        return ID_M_YakujoRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・約定利息を設定します。
     *
     * @param ID_M_YakujoRisoku_SeikyuAns
     *            請求検索結果・約定利息
     */
    public void setID_M_YakujoRisoku_SeikyuAns(
            String ID_M_YakujoRisoku_SeikyuAns) {
        this.ID_M_YakujoRisoku_SeikyuAns = ID_M_YakujoRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還元金を取得します。
     *
     * @return 請求検索結果・請求繰上償還元金
     */
    public String getID_M_SeiKuriGankin_SeikyuAns() {
        return ID_M_SeiKuriGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還元金を設定します。
     *
     * @param ID_M_SeiKuriGankin_SeikyuAns
     *            請求検索結果・請求繰上償還元金
     */
    public void setID_M_SeiKuriGankin_SeikyuAns(
            String ID_M_SeiKuriGankin_SeikyuAns) {
        this.ID_M_SeiKuriGankin_SeikyuAns = ID_M_SeiKuriGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還利息を取得します。
     *
     * @return 請求検索結果・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_SeikyuAns() {
        return ID_M_SeiKuriRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還利息を設定します。
     *
     * @param ID_M_SeiKuriRisoku_SeikyuAns
     *            請求検索結果・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_SeikyuAns(
            String ID_M_SeiKuriRisoku_SeikyuAns) {
        this.ID_M_SeiKuriRisoku_SeikyuAns = ID_M_SeiKuriRisoku_SeikyuAns;
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param ID_Time_Report
     *            報告時分秒
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * 報告書を取得します。
     *
     * @return 報告書
     */
    public String getreport1() {
        return report1;
    }

    /**
     * 報告書を設定します。
     *
     * @param report1
     *            報告書
     */
    public void setreport1(String report1) {
        this.report1 = report1;
    }

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を取得します。
     *
     * @return 受託者勘定処理年月（元号）（隠し項目）
     */
    public String getHdnID_Date_JtkshoriGengou() {
        return hdnID_Date_JtkshoriGengou;
    }

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を設定します。
     *
     * @param hdnID_Date_JtkshoriGengou 受託者勘定処理年月（元号）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriGengou(String hdnID_Date_JtkshoriGengou) {
        this.hdnID_Date_JtkshoriGengou = hdnID_Date_JtkshoriGengou;
        this.drpID_Date_JtkshoriGengou = hdnID_Date_JtkshoriGengou;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を取得します。
     *
     * @return 受託者勘定処理年月（月）（隠し項目）
     */
    public String getHdnID_Date_JtkshoriMonth() {
        return hdnID_Date_JtkshoriMonth;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を設定します。
     *
     * @param hdnID_Date_JtkshoriMonth 受託者勘定処理年月（月）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriMonth(String hdnID_Date_JtkshoriMonth) {
        this.hdnID_Date_JtkshoriMonth = hdnID_Date_JtkshoriMonth;
        this.drpID_Date_JtkshoriMonth = hdnID_Date_JtkshoriMonth;
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