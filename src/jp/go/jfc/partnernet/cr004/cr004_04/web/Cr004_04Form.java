//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃              | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import java.util.List;

/**
 * <pre>
 * このクラスはcr004_04のFormクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr004_04Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String txtID_Date_Report;
    /** エラー */
    private String lblErr;
    /** ステータス */
    private String lblMessage;
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
    /** 繰償後第１回払込日（元号） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    /** 繰償後第１回払込日（年） */
    private String txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    /** 繰償後第１回払込日（月） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    /** 繰償後第１回払込日（日） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    /** 入金日（元号） */
    private String drpID_Date_Nyukin_Gengo;
    /** 入金日（年） */
    private String txtID_Date_Nyukin_Nen;
    /** 入金日（月） */
    private String drpID_Date_Nyukin_Tsuki;
    /** 入金日（日） */
    private String drpID_Date_Nyukin_Bi;
    /** 繰上償還事由コード */
    private String drpID_Code_Kurishojiyu;
    /** 利息 */
    private String txtID_M_KurishoRisoku;
    /** 元金 */
    private String txtID_M_KurishoGankin;
    /** 控除利息 */
    private String txtID_M_KojoRisoku;
    /** 繰上償還手数料 */
    private String txtID_M_KurishoCommision;
    /** 借受金からの充当額 */
    private String txtID_M_KariukeIppanJuto;
    /** 送金額 */
    private String txtID_M_Sokin;
    /** 繰償後残元金 */
    private String txtID_M_ZanGankinAfterKurisho;
    /** 受託者勘定処理年月（元号） */
    private String drpID_Date_JtkShori_Gengo;
    /** 受託者勘定処理年月（年） */
    private String txtID_Date_JtkShori_Nen;
    /** 受託者勘定処理年月（月） */
    private String drpID_Date_JtkShori_Tsuki;
    /** 送金日（元号） */
    private String drpID_Date_Sokin_Gengo;
    /** 送金日（年） */
    private String txtID_Date_Sokin_Nen;
    /** 送金日（月） */
    private String drpID_Date_Sokin_Tsuki;
    /** 送金日（日） */
    private String drpID_Date_Sokin_Bi;
    /** 送金日番号 */
    private String txtID_ID_Sokinbi;
    /** 代弁履行後の返済 */
    private String chkID_ID_After_Daiibensai;
    /** 払込期日①（元号） */
    private String drpID_Date_Haraikomi1_Gengo;
    /** 払込期日①（年） */
    private String txtID_Date_Haraikomi1_Nen;
    /** 払込期日①（月） */
    private String drpID_Date_Haraikomi1_Tsuki;
    /** 払込期日①（日） */
    private String drpID_Date_Haraikomi1_Bi;
    /** 払込元金① */
    private String txtID_M_HaraikomiGankin1;
    /** 払込期日②（元号） */
    private String drpID_Date_Haraikomi2_Gengo;
    /** 払込期日②（年） */
    private String txtID_Date_Haraikomi2_Nen;
    /** 払込期日②（月） */
    private String drpID_Date_Haraikomi2_Tsuki;
    /** 払込期日②（日） */
    private String drpID_Date_Haraikomi2_Bi;
    /** 払込元金② */
    private String txtID_M_HaraikomiGankin2;
    /** 払込期日③（元号） */
    private String drpID_Date_Haraikomi3_Gengo;
    /** 払込期日③（年） */
    private String txtID_Date_Haraikomi3_Nen;
    /** 払込期日③（月） */
    private String drpID_Date_Haraikomi3_Tsuki;
    /** 払込期日③（日） */
    private String drpID_Date_Haraikomi3_Bi;
    /** 払込元金③ */
    private String txtID_M_HaraikomiGankin3;
    /** 払込期日④（元号） */
    private String drpID_Date_Haraikomi4_Gengo;
    /** 払込期日④（年） */
    private String txtID_Date_Haraikomi4_Nen;
    /** 払込期日④（月） */
    private String drpID_Date_Haraikomi4_Tsuki;
    /** 払込期日④（日） */
    private String drpID_Date_Haraikomi4_Bi;
    /** 払込元金④ */
    private String txtID_M_HaraikomiGankin4;
    /** 繰償後元金均等額 */
    private String txtID_M_GankinKintoAfterKurisho;
    /** 繰償後元金不均等額 */
    private String txtID_M_GankinFukintoAfterKurisho;
    /** 調整コード */
    private String rdoID_Code_chosei;
    /** 繰償後第１回払込期日 */
    private String ID_Date_FirstHaraikomiAfterKurisho;
    /** 入金日 */
    private String ID_Date_Nyukin;
    /** 払込期日１ */
    private String ID_Date_Haraikomi1;
    /** 払込期日２ */
    private String ID_Date_Haraikomi2;
    /** 払込期日３ */
    private String ID_Date_Haraikomi3;
    /** 払込期日４ */
    private String ID_Date_Haraikomi4;
    /** 受託者勘定処理年月 */
    private String ID_Date_JtkShori;
    /** 送金日 */
    private String ID_Date_Sokin;
    /** 退避・代弁履行後の返済 */
    private String ID_ID_After_Daiibensai;
    /** 報告書履歴番号 */
    private String ID_ID_History;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告年月日 */
    private String ID_Date_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** ステータス */
    private String ID_Status;
    /** 原本番号 */
    private String ID_ID_Master;
    /** データコード */
    private String ID_DataCode;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi;
    /** ユーザＩＤ */
    private String ID_UserID;
    /** 伝送番号 */
    private String ID_ID_Denso;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 貸付先コード */
    private String ID_Code_Customer;
    /** 稟議・最新更新日時 */
    private String ID_Data_LastUpDate;
    /** 住所コード */
    private String ID_Code_Jusho;
    /** 繰上償還手数料区分 */
    private String ID_Kubun_KurishoTesuryo;
    /** 償還方法コード */
    private String ID_Code_ShokanHouhou;
    /** 賦金 */
    private String ID_M_Fukin;
    /** 元金不均等額 */
    private String ID_M_GankinFukinto;
    /** 元金不均等額区分 */
    private String ID_Kubun_GankinFukintogaku;
    /** 貸付金残高 */
    private String ID_M_KashitsukeZandaka;
    /** 据置期限年月 */
    private String ID_Date_SueokiKigen;
    /** 退避償還期限年月 */
    private String ID_Date_ShokanKigen;
    /** 特利 */
    private String ID_Tokuri;
    /** 利率 */
    private String ID_Riritsu;
    /** 特利有効年月日 */
    private String ID_Date_TokuriYuko;
    /** 実行年月日 */
    private String ID_Date_Jikko;
    /** 元利金払込月日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 貸付受入金残高 */
    private String ID_M_KashitsukeUkeire;
    /** 計数管理処理番号 */
    private String ID_ID_KeisuKanriShori;
    /** 本決算整理期間 */
    private String ID_Date_KessanSeiri;
    /** 約定元金・請求 */
    private String ID_M_YakujoGankin_Seikyu;
    /** 約定利息・請求 */
    private String ID_M_YakujoRisoku_Seikyu;
    /** 約定元金・約定 */
    private String ID_M_YakujoGankin_Yakujo;
    /** 約定利息・約定 */
    private String ID_M_YakujoRisoku_Yakujo;
    /** 請求繰上償還元金・請求 */
    private String ID_M_SeiKuriGankin_Seikyu;
    /** 請求繰上償還利息・請求 */
    private String ID_M_SeiKuriRisoku_Seikyu;
    /** 任意繰上償還利息・約定 */
    private String ID_M_NinKuriRisoku_Yakujo;
    /** 任意繰上償還元金計・入金 */
    private String ID_M_NinKuriGankinKei_Nyukin;
    /** 任意繰上償還利息計・入金 */
    private String ID_M_NinKuriRisokuKei_Nyukin;
    /** 条変起案中区分 */
    private String ID_Kubun_JohenKianchu;
    /** 最新変更年月日 */
    private String ID_Date_SaishinHenko;
    /** 充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko;
    /** 特利区分 */
    private String ID_Kubun_Tokuri;
    /** 先行する報告書の有無 */
    private boolean ID_Previous_Report;
    /** 先行する報告書名 */
    private String ID_Previous_ReportType;
    /** 繰上償還事由コードリスト */
    private List ID_Code_Kurishojiyu_List;
    /** データ取得フラグ */
    private boolean ID_DataGetFlg;
    /** 債権管理番号（受渡情報) */
    private String Cr004_04_ID_Credit;
    /** 公庫支店コード（受渡情報) */
    private String Cr004_04_Code_ShokanHonShiten;
    /** 扱店コード（受渡情報) */
    private String Cr004_04_Code_Organization;
    /** 店舗コード（受渡情報) */
    private String Cr004_04_Code_Tenpo;
    /** 年度（受渡情報) */
    private String Cr004_04_Year;
    /** 方式資金（受渡情報) */
    private String Cr004_04_Code_HoshikiShikin;
    /** 番号（受渡情報) */
    private String Cr004_04_ID_Ringi;
    /** 枝番（受渡情報) */
    private String Cr004_04_ID_RingiBranch;
    /** 請求データ更新要否フラグ */
    private String ID_SeikyunashiKurisho;
    /** 約定データ取得件数 */
    private String YakujoCount;
    /** 請求データ取得件数 */
    private String SeikyuCount;
    /** 約定検索日付 */
    private String ID_Date_SearchYakujo;
    /** 約定検索条件 */
    private String ID_Kind_SearchYakujo;
    /** 約定検索結果・払込年月日 */
    private String ID_Date_Haraikomi_YakujoAns;
    /** 約定検索結果・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_YakujoAns;
    /** 約定検索結果・約定元金 */
    private String ID_M_YakujoGankin_YakujoAns;
    /** 約定検索結果・約定利息 */
    private String ID_M_YakujoRisoku_YakujoAns;
    /** 請求検索日付 */
    private String ID_Date_SearchSeikyu;
    /** 請求検索結果・払込年月日 */
    private String ID_Date_Haraikomi_SeikyuAns;
    /** 請求検索結果・約定元金 */
    private String ID_M_YakujoGankin_SeikyuAns;
    /** 請求検索結果・約定利息 */
    private String ID_M_YakujoRisoku_SeikyuAns;
    /** 請求検索結果・請求繰上償還元金 */
    private String ID_M_SeiKuriGankin_SeikyuAns;
    /** 請求検索結果・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_SeikyuAns;
    /** 請求検索結果・任意繰上償還利息 */
    private String ID_M_NinKuriRisoku_SeikyuAns;
    /** 入金履歴検索日付 */
    private String ID_Date_SearchNyukinHistory;
    /** 入金履歴データ取得件数 */
    private String NyukinHistoryCount;
    /** 入金履歴検索結果・約定元金（合計） */
    private String ID_M_YakujoGankinKei_NyukinHistory;
    /** 入金履歴検索結果・約定利息（合計） */
    private String ID_M_YakujoRisokuKei_NyukinHistory;
    /** 発生エラー番号 */
    private String errorNo;
    /** 入金日直前・払込年月日 */
    private String ID_Date_Haraikomi_before;
    /** 入金日直前・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_before;
    /** 入金日直前・約定元金 */
    private String ID_M_YakujoGankin_before;
    /** 入金日直前・約定利息 */
    private String ID_M_YakujoRisoku_before;
    /** 入金日直後・払込年月日 */
    private String ID_Date_Haraikomi_after;
    /** 入金日直後・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_after;
    /** 入金日直後・約定元金 */
    private String ID_M_YakujoGankin_after;
    /** 入金日直後・約定利息 */
    private String ID_M_YakujoRisoku_after;
    /** 次回・払込年月日 */
    private String ID_Date_Haraikomi_next;
    /** 次回・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_next;
    /** 次回・約定元金 */
    private String ID_M_YakujoGankin_next;
    /** 次回・約定利息 */
    private String ID_M_YakujoRisoku_next;
    /** 次々回・払込年月日 */
    private String ID_Date_Haraikomi_next_next;
    /** 次々回・請求繰上償還利息 */
    private String ID_M_SeiKuriRisoku_next_next;
    /** 次々回・約定元金 */
    private String ID_M_YakujoGankin_next_next;
    /** 次々回・約定利息 */
    private String ID_M_YakujoRisoku_next_next;
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
    /** 受託者勘定処理年月（元号）（隠し項目） */
    private String hdnID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月（月）（隠し項目） */
    private String hdnID_Date_JtkshoriTsuki_Candidate;

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
     * エラーを取得します。
     * @return エラー
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * エラーを設定します。
     * @param lblErr エラー
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
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
     * 繰償後第１回払込日（元号）を取得します。
     * @return 繰償後第１回払込日（元号）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Gengo() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    }

    /**
     * 繰償後第１回払込日（元号）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Gengo 繰償後第１回払込日（元号）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Gengo(String drpID_Date_FirstHaraikomiAfterKurisho_Gengo) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Gengo = drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    }

    /**
     * 繰償後第１回払込日（年）を取得します。
     * @return 繰償後第１回払込日（年）
     */
    public String getTxtID_Date_FirstHaraikomiAfterKurisho_Nen() {
        return txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    }

    /**
     * 繰償後第１回払込日（年）を設定します。
     * @param txtID_Date_FirstHaraikomiAfterKurisho_Nen 繰償後第１回払込日（年）
     */
    public void setTxtID_Date_FirstHaraikomiAfterKurisho_Nen(String txtID_Date_FirstHaraikomiAfterKurisho_Nen) {
        this.txtID_Date_FirstHaraikomiAfterKurisho_Nen = txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    }

    /**
     * 繰償後第１回払込日（月）を取得します。
     * @return 繰償後第１回払込日（月）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Tsuki() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    }

    /**
     * 繰償後第１回払込日（月）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Tsuki 繰償後第１回払込日（月）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Tsuki(String drpID_Date_FirstHaraikomiAfterKurisho_Tsuki) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Tsuki = drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    }

    /**
     * 繰償後第１回払込日（日）を取得します。
     * @return 繰償後第１回払込日（日）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Bi() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    }

    /**
     * 繰償後第１回払込日（日）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Bi 繰償後第１回払込日（日）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Bi(String drpID_Date_FirstHaraikomiAfterKurisho_Bi) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Bi = drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    }

    /**
     * 入金日（元号）を取得します。
     * @return 入金日（元号）
     */
    public String getDrpID_Date_Nyukin_Gengo() {
        return drpID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日（元号）を設定します。
     * @param drpID_Date_Nyukin_Gengo 入金日（元号）
     */
    public void setDrpID_Date_Nyukin_Gengo(String drpID_Date_Nyukin_Gengo) {
        this.drpID_Date_Nyukin_Gengo = drpID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日（年）を取得します。
     * @return 入金日（年）
     */
    public String getTxtID_Date_Nyukin_Nen() {
        return txtID_Date_Nyukin_Nen;
    }

    /**
     * 入金日（年）を設定します。
     * @param txtID_Date_Nyukin_Nen 入金日（年）
     */
    public void setTxtID_Date_Nyukin_Nen(String txtID_Date_Nyukin_Nen) {
        this.txtID_Date_Nyukin_Nen = txtID_Date_Nyukin_Nen;
    }

    /**
     * 入金日（月）を取得します。
     * @return 入金日（月）
     */
    public String getDrpID_Date_Nyukin_Tsuki() {
        return drpID_Date_Nyukin_Tsuki;
    }

    /**
     * 入金日（月）を設定します。
     * @param drpID_Date_Nyukin_Tsuki 入金日（月）
     */
    public void setDrpID_Date_Nyukin_Tsuki(String drpID_Date_Nyukin_Tsuki) {
        this.drpID_Date_Nyukin_Tsuki = drpID_Date_Nyukin_Tsuki;
    }

    /**
     * 入金日（日）を取得します。
     * @return 入金日（日）
     */
    public String getDrpID_Date_Nyukin_Bi() {
        return drpID_Date_Nyukin_Bi;
    }

    /**
     * 入金日（日）を設定します。
     * @param drpID_Date_Nyukin_Bi 入金日（日）
     */
    public void setDrpID_Date_Nyukin_Bi(String drpID_Date_Nyukin_Bi) {
        this.drpID_Date_Nyukin_Bi = drpID_Date_Nyukin_Bi;
    }

    /**
     * 繰上償還事由コードを取得します。
     * @return 繰上償還事由コード
     */
    public String getDrpID_Code_Kurishojiyu() {
        return drpID_Code_Kurishojiyu;
    }

    /**
     * 繰上償還事由コードを設定します。
     * @param drpID_Code_Kurishojiyu 繰上償還事由コード
     */
    public void setDrpID_Code_Kurishojiyu(String drpID_Code_Kurishojiyu) {
        this.drpID_Code_Kurishojiyu = drpID_Code_Kurishojiyu;
    }

    /**
     * 利息を取得します。
     * @return 利息
     */
    public String getTxtID_M_KurishoRisoku() {
        return txtID_M_KurishoRisoku;
    }

    /**
     * 利息を設定します。
     * @param txtID_M_KurishoRisoku 利息
     */
    public void setTxtID_M_KurishoRisoku(String txtID_M_KurishoRisoku) {
        this.txtID_M_KurishoRisoku = txtID_M_KurishoRisoku;
    }

    /**
     * 元金を取得します。
     * @return 元金
     */
    public String getTxtID_M_KurishoGankin() {
        return txtID_M_KurishoGankin;
    }

    /**
     * 元金を設定します。
     * @param txtID_M_KurishoGankin 元金
     */
    public void setTxtID_M_KurishoGankin(String txtID_M_KurishoGankin) {
        this.txtID_M_KurishoGankin = txtID_M_KurishoGankin;
    }

    /**
     * 控除利息を取得します。
     * @return 控除利息
     */
    public String getTxtID_M_KojoRisoku() {
        return txtID_M_KojoRisoku;
    }

    /**
     * 控除利息を設定します。
     * @param txtID_M_KojoRisoku 控除利息
     */
    public void setTxtID_M_KojoRisoku(String txtID_M_KojoRisoku) {
        this.txtID_M_KojoRisoku = txtID_M_KojoRisoku;
    }

    /**
     * 繰上償還手数料を取得します。
     * @return 繰上償還手数料
     */
    public String getTxtID_M_KurishoCommision() {
        return txtID_M_KurishoCommision;
    }

    /**
     * 繰上償還手数料を設定します。
     * @param txtID_M_KurishoCommision 繰上償還手数料
     */
    public void setTxtID_M_KurishoCommision(String txtID_M_KurishoCommision) {
        this.txtID_M_KurishoCommision = txtID_M_KurishoCommision;
    }

    /**
     * 借受金からの充当額を取得します。
     * @return 借受金からの充当額
     */
    public String getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 借受金からの充当額を設定します。
     * @param txtID_M_KariukeIppanJuto 借受金からの充当額
     */
    public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 送金額を取得します。
     * @return 送金額
     */
    public String getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額を設定します。
     * @param txtID_M_Sokin 送金額
     */
    public void setTxtID_M_Sokin(String txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 繰償後残元金を取得します。
     * @return 繰償後残元金
     */
    public String getTxtID_M_ZanGankinAfterKurisho() {
        return txtID_M_ZanGankinAfterKurisho;
    }

    /**
     * 繰償後残元金を設定します。
     * @param txtID_M_ZanGankinAfterKurisho 繰償後残元金
     */
    public void setTxtID_M_ZanGankinAfterKurisho(String txtID_M_ZanGankinAfterKurisho) {
        this.txtID_M_ZanGankinAfterKurisho = txtID_M_ZanGankinAfterKurisho;
    }

    /**
     * 受託者勘定処理年月（元号）を取得します。
     * @return 受託者勘定処理年月（元号）
     */
    public String getDrpID_Date_JtkShori_Gengo() {
        return drpID_Date_JtkShori_Gengo;
    }

    /**
     * 受託者勘定処理年月（元号）を設定します。
     * @param drpID_Date_JtkShori_Gengo 受託者勘定処理年月（元号）
     */
    public void setDrpID_Date_JtkShori_Gengo(String drpID_Date_JtkShori_Gengo) {
        this.drpID_Date_JtkShori_Gengo = drpID_Date_JtkShori_Gengo;
    }

    /**
     * 受託者勘定処理年月（年）を取得します。
     * @return 受託者勘定処理年月（年）
     */
    public String getTxtID_Date_JtkShori_Nen() {
        return txtID_Date_JtkShori_Nen;
    }

    /**
     * 受託者勘定処理年月（年）を設定します。
     * @param txtID_Date_JtkShori_Nen 受託者勘定処理年月（年）
     */
    public void setTxtID_Date_JtkShori_Nen(String txtID_Date_JtkShori_Nen) {
        this.txtID_Date_JtkShori_Nen = txtID_Date_JtkShori_Nen;
    }

    /**
     * 受託者勘定処理年月（月）を取得します。
     * @return 受託者勘定処理年月（月）
     */
    public String getDrpID_Date_JtkShori_Tsuki() {
        return drpID_Date_JtkShori_Tsuki;
    }

    /**
     * 受託者勘定処理年月（月）を設定します。
     * @param drpID_Date_JtkShori_Tsuki 受託者勘定処理年月（月）
     */
    public void setDrpID_Date_JtkShori_Tsuki(String drpID_Date_JtkShori_Tsuki) {
        this.drpID_Date_JtkShori_Tsuki = drpID_Date_JtkShori_Tsuki;
    }

    /**
     * 送金日（元号）を取得します。
     * @return 送金日（元号）
     */
    public String getDrpID_Date_Sokin_Gengo() {
        return drpID_Date_Sokin_Gengo;
    }

    /**
     * 送金日（元号）を設定します。
     * @param drpID_Date_Sokin_Gengo 送金日（元号）
     */
    public void setDrpID_Date_Sokin_Gengo(String drpID_Date_Sokin_Gengo) {
        this.drpID_Date_Sokin_Gengo = drpID_Date_Sokin_Gengo;
    }

    /**
     * 送金日（年）を取得します。
     * @return 送金日（年）
     */
    public String getTxtID_Date_Sokin_Nen() {
        return txtID_Date_Sokin_Nen;
    }

    /**
     * 送金日（年）を設定します。
     * @param txtID_Date_Sokin_Nen 送金日（年）
     */
    public void setTxtID_Date_Sokin_Nen(String txtID_Date_Sokin_Nen) {
        this.txtID_Date_Sokin_Nen = txtID_Date_Sokin_Nen;
    }

    /**
     * 送金日（月）を取得します。
     * @return 送金日（月）
     */
    public String getDrpID_Date_Sokin_Tsuki() {
        return drpID_Date_Sokin_Tsuki;
    }

    /**
     * 送金日（月）を設定します。
     * @param drpID_Date_Sokin_Tsuki 送金日（月）
     */
    public void setDrpID_Date_Sokin_Tsuki(String drpID_Date_Sokin_Tsuki) {
        this.drpID_Date_Sokin_Tsuki = drpID_Date_Sokin_Tsuki;
    }

    /**
     * 送金日（日）を取得します。
     * @return 送金日（日）
     */
    public String getDrpID_Date_Sokin_Bi() {
        return drpID_Date_Sokin_Bi;
    }

    /**
     * 送金日（日）を設定します。
     * @param drpID_Date_Sokin_Bi 送金日（日）
     */
    public void setDrpID_Date_Sokin_Bi(String drpID_Date_Sokin_Bi) {
        this.drpID_Date_Sokin_Bi = drpID_Date_Sokin_Bi;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getTxtID_ID_Sokinbi() {
        return txtID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param txtID_ID_Sokinbi 送金日番号
     */
    public void setTxtID_ID_Sokinbi(String txtID_ID_Sokinbi) {
        this.txtID_ID_Sokinbi = txtID_ID_Sokinbi;
    }

    /**
     * 代弁履行後の返済を取得します。
     * @return 代弁履行後の返済
     */
    public String getChkID_ID_After_Daiibensai() {
        return chkID_ID_After_Daiibensai;
    }

    /**
     * 代弁履行後の返済を設定します。
     * @param chkID_ID_After_Daiibensai 代弁履行後の返済
     */
    public void setChkID_ID_After_Daiibensai(String chkID_ID_After_Daiibensai) {
        this.chkID_ID_After_Daiibensai = chkID_ID_After_Daiibensai;
    }

    /**
     * 払込期日①（元号）を取得します。
     * @return 払込期日①（元号）
     */
    public String getDrpID_Date_Haraikomi1_Gengo() {
        return drpID_Date_Haraikomi1_Gengo;
    }

    /**
     * 払込期日①（元号）を設定します。
     * @param drpID_Date_Haraikomi1_Gengo 払込期日①（元号）
     */
    public void setDrpID_Date_Haraikomi1_Gengo(String drpID_Date_Haraikomi1_Gengo) {
        this.drpID_Date_Haraikomi1_Gengo = drpID_Date_Haraikomi1_Gengo;
    }

    /**
     * 払込期日①（年）を取得します。
     * @return 払込期日①（年）
     */
    public String getTxtID_Date_Haraikomi1_Nen() {
        return txtID_Date_Haraikomi1_Nen;
    }

    /**
     * 払込期日①（年）を設定します。
     * @param txtID_Date_Haraikomi1_Nen 払込期日①（年）
     */
    public void setTxtID_Date_Haraikomi1_Nen(String txtID_Date_Haraikomi1_Nen) {
        this.txtID_Date_Haraikomi1_Nen = txtID_Date_Haraikomi1_Nen;
    }

    /**
     * 払込期日①（月）を取得します。
     * @return 払込期日①（月）
     */
    public String getDrpID_Date_Haraikomi1_Tsuki() {
        return drpID_Date_Haraikomi1_Tsuki;
    }

    /**
     * 払込期日①（月）を設定します。
     * @param drpID_Date_Haraikomi1_Tsuki 払込期日①（月）
     */
    public void setDrpID_Date_Haraikomi1_Tsuki(String drpID_Date_Haraikomi1_Tsuki) {
        this.drpID_Date_Haraikomi1_Tsuki = drpID_Date_Haraikomi1_Tsuki;
    }

    /**
     * 払込期日①（日）を取得します。
     * @return 払込期日①（日）
     */
    public String getDrpID_Date_Haraikomi1_Bi() {
        return drpID_Date_Haraikomi1_Bi;
    }

    /**
     * 払込期日①（日）を設定します。
     * @param drpID_Date_Haraikomi1_Bi 払込期日①（日）
     */
    public void setDrpID_Date_Haraikomi1_Bi(String drpID_Date_Haraikomi1_Bi) {
        this.drpID_Date_Haraikomi1_Bi = drpID_Date_Haraikomi1_Bi;
    }

    /**
     * 払込元金①を取得します。
     * @return 払込元金①
     */
    public String getTxtID_M_HaraikomiGankin1() {
        return txtID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金①を設定します。
     * @param txtID_M_HaraikomiGankin1 払込元金①
     */
    public void setTxtID_M_HaraikomiGankin1(String txtID_M_HaraikomiGankin1) {
        this.txtID_M_HaraikomiGankin1 = txtID_M_HaraikomiGankin1;
    }

    /**
     * 払込期日②（元号）を取得します。
     * @return 払込期日②（元号）
     */
    public String getDrpID_Date_Haraikomi2_Gengo() {
        return drpID_Date_Haraikomi2_Gengo;
    }

    /**
     * 払込期日②（元号）を設定します。
     * @param drpID_Date_Haraikomi2_Gengo 払込期日②（元号）
     */
    public void setDrpID_Date_Haraikomi2_Gengo(String drpID_Date_Haraikomi2_Gengo) {
        this.drpID_Date_Haraikomi2_Gengo = drpID_Date_Haraikomi2_Gengo;
    }

    /**
     * 払込期日②（年）を取得します。
     * @return 払込期日②（年）
     */
    public String getTxtID_Date_Haraikomi2_Nen() {
        return txtID_Date_Haraikomi2_Nen;
    }

    /**
     * 払込期日②（年）を設定します。
     * @param txtID_Date_Haraikomi2_Nen 払込期日②（年）
     */
    public void setTxtID_Date_Haraikomi2_Nen(String txtID_Date_Haraikomi2_Nen) {
        this.txtID_Date_Haraikomi2_Nen = txtID_Date_Haraikomi2_Nen;
    }

    /**
     * 払込期日②（月）を取得します。
     * @return 払込期日②（月）
     */
    public String getDrpID_Date_Haraikomi2_Tsuki() {
        return drpID_Date_Haraikomi2_Tsuki;
    }

    /**
     * 払込期日②（月）を設定します。
     * @param drpID_Date_Haraikomi2_Tsuki 払込期日②（月）
     */
    public void setDrpID_Date_Haraikomi2_Tsuki(String drpID_Date_Haraikomi2_Tsuki) {
        this.drpID_Date_Haraikomi2_Tsuki = drpID_Date_Haraikomi2_Tsuki;
    }

    /**
     * 払込期日②（日）を取得します。
     * @return 払込期日②（日）
     */
    public String getDrpID_Date_Haraikomi2_Bi() {
        return drpID_Date_Haraikomi2_Bi;
    }

    /**
     * 払込期日②（日）を設定します。
     * @param drpID_Date_Haraikomi2_Bi 払込期日②（日）
     */
    public void setDrpID_Date_Haraikomi2_Bi(String drpID_Date_Haraikomi2_Bi) {
        this.drpID_Date_Haraikomi2_Bi = drpID_Date_Haraikomi2_Bi;
    }

    /**
     * 払込元金②を取得します。
     * @return 払込元金②
     */
    public String getTxtID_M_HaraikomiGankin2() {
        return txtID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金②を設定します。
     * @param txtID_M_HaraikomiGankin2 払込元金②
     */
    public void setTxtID_M_HaraikomiGankin2(String txtID_M_HaraikomiGankin2) {
        this.txtID_M_HaraikomiGankin2 = txtID_M_HaraikomiGankin2;
    }

    /**
     * 払込期日③（元号）を取得します。
     * @return 払込期日③（元号）
     */
    public String getDrpID_Date_Haraikomi3_Gengo() {
        return drpID_Date_Haraikomi3_Gengo;
    }

    /**
     * 払込期日③（元号）を設定します。
     * @param drpID_Date_Haraikomi3_Gengo 払込期日③（元号）
     */
    public void setDrpID_Date_Haraikomi3_Gengo(String drpID_Date_Haraikomi3_Gengo) {
        this.drpID_Date_Haraikomi3_Gengo = drpID_Date_Haraikomi3_Gengo;
    }

    /**
     * 払込期日③（年）を取得します。
     * @return 払込期日③（年）
     */
    public String getTxtID_Date_Haraikomi3_Nen() {
        return txtID_Date_Haraikomi3_Nen;
    }

    /**
     * 払込期日③（年）を設定します。
     * @param txtID_Date_Haraikomi3_Nen 払込期日③（年）
     */
    public void setTxtID_Date_Haraikomi3_Nen(String txtID_Date_Haraikomi3_Nen) {
        this.txtID_Date_Haraikomi3_Nen = txtID_Date_Haraikomi3_Nen;
    }

    /**
     * 払込期日③（月）を取得します。
     * @return 払込期日③（月）
     */
    public String getDrpID_Date_Haraikomi3_Tsuki() {
        return drpID_Date_Haraikomi3_Tsuki;
    }

    /**
     * 払込期日③（月）を設定します。
     * @param drpID_Date_Haraikomi3_Tsuki 払込期日③（月）
     */
    public void setDrpID_Date_Haraikomi3_Tsuki(String drpID_Date_Haraikomi3_Tsuki) {
        this.drpID_Date_Haraikomi3_Tsuki = drpID_Date_Haraikomi3_Tsuki;
    }

    /**
     * 払込期日③（日）を取得します。
     * @return 払込期日③（日）
     */
    public String getDrpID_Date_Haraikomi3_Bi() {
        return drpID_Date_Haraikomi3_Bi;
    }

    /**
     * 払込期日③（日）を設定します。
     * @param drpID_Date_Haraikomi3_Bi 払込期日③（日）
     */
    public void setDrpID_Date_Haraikomi3_Bi(String drpID_Date_Haraikomi3_Bi) {
        this.drpID_Date_Haraikomi3_Bi = drpID_Date_Haraikomi3_Bi;
    }

    /**
     * 払込元金③を取得します。
     * @return 払込元金③
     */
    public String getTxtID_M_HaraikomiGankin3() {
        return txtID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金③を設定します。
     * @param txtID_M_HaraikomiGankin3 払込元金③
     */
    public void setTxtID_M_HaraikomiGankin3(String txtID_M_HaraikomiGankin3) {
        this.txtID_M_HaraikomiGankin3 = txtID_M_HaraikomiGankin3;
    }

    /**
     * 払込期日④（元号）を取得します。
     * @return 払込期日④（元号）
     */
    public String getDrpID_Date_Haraikomi4_Gengo() {
        return drpID_Date_Haraikomi4_Gengo;
    }

    /**
     * 払込期日④（元号）を設定します。
     * @param drpID_Date_Haraikomi4_Gengo 払込期日④（元号）
     */
    public void setDrpID_Date_Haraikomi4_Gengo(String drpID_Date_Haraikomi4_Gengo) {
        this.drpID_Date_Haraikomi4_Gengo = drpID_Date_Haraikomi4_Gengo;
    }

    /**
     * 払込期日④（年）を取得します。
     * @return 払込期日④（年）
     */
    public String getTxtID_Date_Haraikomi4_Nen() {
        return txtID_Date_Haraikomi4_Nen;
    }

    /**
     * 払込期日④（年）を設定します。
     * @param txtID_Date_Haraikomi4_Nen 払込期日④（年）
     */
    public void setTxtID_Date_Haraikomi4_Nen(String txtID_Date_Haraikomi4_Nen) {
        this.txtID_Date_Haraikomi4_Nen = txtID_Date_Haraikomi4_Nen;
    }

    /**
     * 払込期日④（月）を取得します。
     * @return 払込期日④（月）
     */
    public String getDrpID_Date_Haraikomi4_Tsuki() {
        return drpID_Date_Haraikomi4_Tsuki;
    }

    /**
     * 払込期日④（月）を設定します。
     * @param drpID_Date_Haraikomi4_Tsuki 払込期日④（月）
     */
    public void setDrpID_Date_Haraikomi4_Tsuki(String drpID_Date_Haraikomi4_Tsuki) {
        this.drpID_Date_Haraikomi4_Tsuki = drpID_Date_Haraikomi4_Tsuki;
    }

    /**
     * 払込期日④（日）を取得します。
     * @return 払込期日④（日）
     */
    public String getDrpID_Date_Haraikomi4_Bi() {
        return drpID_Date_Haraikomi4_Bi;
    }

    /**
     * 払込期日④（日）を設定します。
     * @param drpID_Date_Haraikomi4_Bi 払込期日④（日）
     */
    public void setDrpID_Date_Haraikomi4_Bi(String drpID_Date_Haraikomi4_Bi) {
        this.drpID_Date_Haraikomi4_Bi = drpID_Date_Haraikomi4_Bi;
    }

    /**
     * 払込元金④を取得します。
     * @return 払込元金④
     */
    public String getTxtID_M_HaraikomiGankin4() {
        return txtID_M_HaraikomiGankin4;
    }

    /**
     * 払込元金④を設定します。
     * @param txtID_M_HaraikomiGankin4 払込元金④
     */
    public void setTxtID_M_HaraikomiGankin4(String txtID_M_HaraikomiGankin4) {
        this.txtID_M_HaraikomiGankin4 = txtID_M_HaraikomiGankin4;
    }

    /**
     * 繰償後元金均等額を取得します。
     * @return 繰償後元金均等額
     */
    public String getTxtID_M_GankinKintoAfterKurisho() {
        return txtID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金均等額を設定します。
     * @param txtID_M_GankinKintoAfterKurisho 繰償後元金均等額
     */
    public void setTxtID_M_GankinKintoAfterKurisho(String txtID_M_GankinKintoAfterKurisho) {
        this.txtID_M_GankinKintoAfterKurisho = txtID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額を取得します。
     * @return 繰償後元金不均等額
     */
    public String getTxtID_M_GankinFukintoAfterKurisho() {
        return txtID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額を設定します。
     * @param txtID_M_GankinFukintoAfterKurisho 繰償後元金不均等額
     */
    public void setTxtID_M_GankinFukintoAfterKurisho(String txtID_M_GankinFukintoAfterKurisho) {
        this.txtID_M_GankinFukintoAfterKurisho = txtID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getRdoID_Code_chosei() {
        return rdoID_Code_chosei;
    }

    /**
     * 調整コードを設定します。
     * @param rdoID_Code_chosei 調整コード
     */
    public void setRdoID_Code_chosei(String rdoID_Code_chosei) {
        this.rdoID_Code_chosei = rdoID_Code_chosei;
    }

    /**
     * 繰償後第１回払込期日を取得します。
     * @return 繰償後第１回払込期日
     */
    public String getID_Date_FirstHaraikomiAfterKurisho() {
        return ID_Date_FirstHaraikomiAfterKurisho;
    }

    /**
     * 繰償後第１回払込期日を設定します。
     * @param ID_Date_FirstHaraikomiAfterKurisho 繰償後第１回払込期日
     */
    public void setID_Date_FirstHaraikomiAfterKurisho(String ID_Date_FirstHaraikomiAfterKurisho) {
        this.ID_Date_FirstHaraikomiAfterKurisho = ID_Date_FirstHaraikomiAfterKurisho;
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
     * 払込期日１を取得します。
     * @return 払込期日１
     */
    public String getID_Date_Haraikomi1() {
        return ID_Date_Haraikomi1;
    }

    /**
     * 払込期日１を設定します。
     * @param ID_Date_Haraikomi1 払込期日１
     */
    public void setID_Date_Haraikomi1(String ID_Date_Haraikomi1) {
        this.ID_Date_Haraikomi1 = ID_Date_Haraikomi1;
    }

    /**
     * 払込期日２を取得します。
     * @return 払込期日２
     */
    public String getID_Date_Haraikomi2() {
        return ID_Date_Haraikomi2;
    }

    /**
     * 払込期日２を設定します。
     * @param ID_Date_Haraikomi2 払込期日２
     */
    public void setID_Date_Haraikomi2(String ID_Date_Haraikomi2) {
        this.ID_Date_Haraikomi2 = ID_Date_Haraikomi2;
    }

    /**
     * 払込期日３を取得します。
     * @return 払込期日３
     */
    public String getID_Date_Haraikomi3() {
        return ID_Date_Haraikomi3;
    }

    /**
     * 払込期日３を設定します。
     * @param ID_Date_Haraikomi3 払込期日３
     */
    public void setID_Date_Haraikomi3(String ID_Date_Haraikomi3) {
        this.ID_Date_Haraikomi3 = ID_Date_Haraikomi3;
    }

    /**
     * 払込期日４を取得します。
     * @return 払込期日４
     */
    public String getID_Date_Haraikomi4() {
        return ID_Date_Haraikomi4;
    }

    /**
     * 払込期日４を設定します。
     * @param ID_Date_Haraikomi4 払込期日４
     */
    public void setID_Date_Haraikomi4(String ID_Date_Haraikomi4) {
        this.ID_Date_Haraikomi4 = ID_Date_Haraikomi4;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getID_Date_JtkShori() {
        return ID_Date_JtkShori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param ID_Date_JtkShori 受託者勘定処理年月
     */
    public void setID_Date_JtkShori(String ID_Date_JtkShori) {
        this.ID_Date_JtkShori = ID_Date_JtkShori;
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getID_Date_Sokin() {
        return ID_Date_Sokin;
    }

    /**
     * 送金日を設定します。
     * @param ID_Date_Sokin 送金日
     */
    public void setID_Date_Sokin(String ID_Date_Sokin) {
        this.ID_Date_Sokin = ID_Date_Sokin;
    }

    /**
     * 退避・代弁履行後の返済を取得します。
     * @return 退避・代弁履行後の返済
     */
    public String getID_ID_After_Daiibensai() {
        return ID_ID_After_Daiibensai;
    }

    /**
     * 退避・代弁履行後の返済を設定します。
     * @param ID_ID_After_Daiibensai 退避・代弁履行後の返済
     */
    public void setID_ID_After_Daiibensai(String ID_ID_After_Daiibensai) {
        this.ID_ID_After_Daiibensai = ID_ID_After_Daiibensai;
    }

    /**
     * 報告書履歴番号を取得します。
     * @return 報告書履歴番号
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 報告書履歴番号を設定します。
     * @param ID_ID_History 報告書履歴番号
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
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getID_Date_Report() {
        return ID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param ID_Date_Report 報告年月日
     */
    public void setID_Date_Report(String ID_Date_Report) {
        this.ID_Date_Report = ID_Date_Report;
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータスを設定します。
     * @param ID_Status ステータス
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
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
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getID_UserID() {
        return ID_UserID;
    }

    /**
     * ユーザＩＤを設定します。
     * @param ID_UserID ユーザＩＤ
     */
    public void setID_UserID(String ID_UserID) {
        this.ID_UserID = ID_UserID;
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
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
     * 稟議・最新更新日時を取得します。
     * @return 稟議・最新更新日時
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 稟議・最新更新日時を設定します。
     * @param ID_Data_LastUpDate 稟議・最新更新日時
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 住所コードを取得します。
     * @return 住所コード
     */
    public String getID_Code_Jusho() {
        return ID_Code_Jusho;
    }

    /**
     * 住所コードを設定します。
     * @param ID_Code_Jusho 住所コード
     */
    public void setID_Code_Jusho(String ID_Code_Jusho) {
        this.ID_Code_Jusho = ID_Code_Jusho;
    }

    /**
     * 繰上償還手数料区分を取得します。
     * @return 繰上償還手数料区分
     */
    public String getID_Kubun_KurishoTesuryo() {
        return ID_Kubun_KurishoTesuryo;
    }

    /**
     * 繰上償還手数料区分を設定します。
     * @param ID_Kubun_KurishoTesuryo 繰上償還手数料区分
     */
    public void setID_Kubun_KurishoTesuryo(String ID_Kubun_KurishoTesuryo) {
        this.ID_Kubun_KurishoTesuryo = ID_Kubun_KurishoTesuryo;
    }

    /**
     * 償還方法コードを取得します。
     * @return 償還方法コード
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 償還方法コードを設定します。
     * @param ID_Code_ShokanHouhou 償還方法コード
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 賦金を取得します。
     * @return 賦金
     */
    public String getID_M_Fukin() {
        return ID_M_Fukin;
    }

    /**
     * 賦金を設定します。
     * @param ID_M_Fukin 賦金
     */
    public void setID_M_Fukin(String ID_M_Fukin) {
        this.ID_M_Fukin = ID_M_Fukin;
    }

    /**
     * 元金不均等額を取得します。
     * @return 元金不均等額
     */
    public String getID_M_GankinFukinto() {
        return ID_M_GankinFukinto;
    }

    /**
     * 元金不均等額を設定します。
     * @param ID_M_GankinFukinto 元金不均等額
     */
    public void setID_M_GankinFukinto(String ID_M_GankinFukinto) {
        this.ID_M_GankinFukinto = ID_M_GankinFukinto;
    }

    /**
     * 元金不均等額区分を取得します。
     * @return 元金不均等額区分
     */
    public String getID_Kubun_GankinFukintogaku() {
        return ID_Kubun_GankinFukintogaku;
    }

    /**
     * 元金不均等額区分を設定します。
     * @param ID_Kubun_GankinFukintogaku 元金不均等額区分
     */
    public void setID_Kubun_GankinFukintogaku(String ID_Kubun_GankinFukintogaku) {
        this.ID_Kubun_GankinFukintogaku = ID_Kubun_GankinFukintogaku;
    }

    /**
     * 貸付金残高を取得します。
     * @return 貸付金残高
     */
    public String getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 貸付金残高を設定します。
     * @param ID_M_KashitsukeZandaka 貸付金残高
     */
    public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
        this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
    }

    /**
     * 据置期限年月を取得します。
     * @return 据置期限年月
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限年月を設定します。
     * @param ID_Date_SueokiKigen 据置期限年月
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 退避償還期限年月を取得します。
     * @return 退避償還期限年月
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 退避償還期限年月を設定します。
     * @param ID_Date_ShokanKigen 退避償還期限年月
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利を設定します。
     * @param ID_Tokuri 特利
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率を設定します。
     * @param ID_Riritsu 利率
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
    }

    /**
     * 特利有効年月日を取得します。
     * @return 特利有効年月日
     */
    public String getID_Date_TokuriYuko() {
        return ID_Date_TokuriYuko;
    }

    /**
     * 特利有効年月日を設定します。
     * @param ID_Date_TokuriYuko 特利有効年月日
     */
    public void setID_Date_TokuriYuko(String ID_Date_TokuriYuko) {
        this.ID_Date_TokuriYuko = ID_Date_TokuriYuko;
    }

    /**
     * 実行年月日を取得します。
     * @return 実行年月日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 実行年月日を設定します。
     * @param ID_Date_Jikko 実行年月日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 元利金払込月日を取得します。
     * @return 元利金払込月日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込月日を設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込月日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public String getID_M_KashitsukeUkeire() {
        return ID_M_KashitsukeUkeire;
    }

    /**
     * 貸付受入金残高を設定します。
     * @param ID_M_KashitsukeUkeire 貸付受入金残高
     */
    public void setID_M_KashitsukeUkeire(String ID_M_KashitsukeUkeire) {
        this.ID_M_KashitsukeUkeire = ID_M_KashitsukeUkeire;
    }

    /**
     * 計数管理処理番号を取得します。
     * @return 計数管理処理番号
     */
    public String getID_ID_KeisuKanriShori() {
        return ID_ID_KeisuKanriShori;
    }

    /**
     * 計数管理処理番号を設定します。
     * @param ID_ID_KeisuKanriShori 計数管理処理番号
     */
    public void setID_ID_KeisuKanriShori(String ID_ID_KeisuKanriShori) {
        this.ID_ID_KeisuKanriShori = ID_ID_KeisuKanriShori;
    }

    /**
     * 本決算整理期間を取得します。
     * @return 本決算整理期間
     */
    public String getID_Date_KessanSeiri() {
        return ID_Date_KessanSeiri;
    }

    /**
     * 本決算整理期間を設定します。
     * @param ID_Date_KessanSeiri 本決算整理期間
     */
    public void setID_Date_KessanSeiri(String ID_Date_KessanSeiri) {
        this.ID_Date_KessanSeiri = ID_Date_KessanSeiri;
    }

    /**
     * 約定元金・請求を取得します。
     * @return 約定元金・請求
     */
    public String getID_M_YakujoGankin_Seikyu() {
        return ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 約定元金・請求を設定します。
     * @param ID_M_YakujoGankin_Seikyu 約定元金・請求
     */
    public void setID_M_YakujoGankin_Seikyu(String ID_M_YakujoGankin_Seikyu) {
        this.ID_M_YakujoGankin_Seikyu = ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 約定利息・請求を取得します。
     * @return 約定利息・請求
     */
    public String getID_M_YakujoRisoku_Seikyu() {
        return ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 約定利息・請求を設定します。
     * @param ID_M_YakujoRisoku_Seikyu 約定利息・請求
     */
    public void setID_M_YakujoRisoku_Seikyu(String ID_M_YakujoRisoku_Seikyu) {
        this.ID_M_YakujoRisoku_Seikyu = ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 約定元金・約定を取得します。
     * @return 約定元金・約定
     */
    public String getID_M_YakujoGankin_Yakujo() {
        return ID_M_YakujoGankin_Yakujo;
    }

    /**
     * 約定元金・約定を設定します。
     * @param ID_M_YakujoGankin_Yakujo 約定元金・約定
     */
    public void setID_M_YakujoGankin_Yakujo(String ID_M_YakujoGankin_Yakujo) {
        this.ID_M_YakujoGankin_Yakujo = ID_M_YakujoGankin_Yakujo;
    }

    /**
     * 約定利息・約定を取得します。
     * @return 約定利息・約定
     */
    public String getID_M_YakujoRisoku_Yakujo() {
        return ID_M_YakujoRisoku_Yakujo;
    }

    /**
     * 約定利息・約定を設定します。
     * @param ID_M_YakujoRisoku_Yakujo 約定利息・約定
     */
    public void setID_M_YakujoRisoku_Yakujo(String ID_M_YakujoRisoku_Yakujo) {
        this.ID_M_YakujoRisoku_Yakujo = ID_M_YakujoRisoku_Yakujo;
    }

    /**
     * 請求繰上償還元金・請求を取得します。
     * @return 請求繰上償還元金・請求
     */
    public String getID_M_SeiKuriGankin_Seikyu() {
        return ID_M_SeiKuriGankin_Seikyu;
    }

    /**
     * 請求繰上償還元金・請求を設定します。
     * @param ID_M_SeiKuriGankin_Seikyu 請求繰上償還元金・請求
     */
    public void setID_M_SeiKuriGankin_Seikyu(String ID_M_SeiKuriGankin_Seikyu) {
        this.ID_M_SeiKuriGankin_Seikyu = ID_M_SeiKuriGankin_Seikyu;
    }

    /**
     * 請求繰上償還利息・請求を取得します。
     * @return 請求繰上償還利息・請求
     */
    public String getID_M_SeiKuriRisoku_Seikyu() {
        return ID_M_SeiKuriRisoku_Seikyu;
    }

    /**
     * 請求繰上償還利息・請求を設定します。
     * @param ID_M_SeiKuriRisoku_Seikyu 請求繰上償還利息・請求
     */
    public void setID_M_SeiKuriRisoku_Seikyu(String ID_M_SeiKuriRisoku_Seikyu) {
        this.ID_M_SeiKuriRisoku_Seikyu = ID_M_SeiKuriRisoku_Seikyu;
    }

    /**
     * 任意繰上償還利息・約定を取得します。
     * @return 任意繰上償還利息・約定
     */
    public String getID_M_NinKuriRisoku_Yakujo() {
        return ID_M_NinKuriRisoku_Yakujo;
    }

    /**
     * 任意繰上償還利息・約定を設定します。
     * @param ID_M_NinKuriRisoku_Yakujo 任意繰上償還利息・約定
     */
    public void setID_M_NinKuriRisoku_Yakujo(String ID_M_NinKuriRisoku_Yakujo) {
        this.ID_M_NinKuriRisoku_Yakujo = ID_M_NinKuriRisoku_Yakujo;
    }

    /**
     * 任意繰上償還元金計・入金を取得します。
     * @return 任意繰上償還元金計・入金
     */
    public String getID_M_NinKuriGankinKei_Nyukin() {
        return ID_M_NinKuriGankinKei_Nyukin;
    }

    /**
     * 任意繰上償還元金計・入金を設定します。
     * @param ID_M_NinKuriGankinKei_Nyukin 任意繰上償還元金計・入金
     */
    public void setID_M_NinKuriGankinKei_Nyukin(String ID_M_NinKuriGankinKei_Nyukin) {
        this.ID_M_NinKuriGankinKei_Nyukin = ID_M_NinKuriGankinKei_Nyukin;
    }

    /**
     * 任意繰上償還利息計・入金を取得します。
     * @return 任意繰上償還利息計・入金
     */
    public String getID_M_NinKuriRisokuKei_Nyukin() {
        return ID_M_NinKuriRisokuKei_Nyukin;
    }

    /**
     * 任意繰上償還利息計・入金を設定します。
     * @param ID_M_NinKuriRisokuKei_Nyukin 任意繰上償還利息計・入金
     */
    public void setID_M_NinKuriRisokuKei_Nyukin(String ID_M_NinKuriRisokuKei_Nyukin) {
        this.ID_M_NinKuriRisokuKei_Nyukin = ID_M_NinKuriRisokuKei_Nyukin;
    }

    /**
     * 条変起案中区分を取得します。
     * @return 条変起案中区分
     */
    public String getID_Kubun_JohenKianchu() {
        return ID_Kubun_JohenKianchu;
    }

    /**
     * 条変起案中区分を設定します。
     * @param ID_Kubun_JohenKianchu 条変起案中区分
     */
    public void setID_Kubun_JohenKianchu(String ID_Kubun_JohenKianchu) {
        this.ID_Kubun_JohenKianchu = ID_Kubun_JohenKianchu;
    }

    /**
     * 最新変更年月日を取得します。
     * @return 最新変更年月日
     */
    public String getID_Date_SaishinHenko() {
        return ID_Date_SaishinHenko;
    }

    /**
     * 最新変更年月日を設定します。
     * @param ID_Date_SaishinHenko 最新変更年月日
     */
    public void setID_Date_SaishinHenko(String ID_Date_SaishinHenko) {
        this.ID_Date_SaishinHenko = ID_Date_SaishinHenko;
    }

    /**
     * 充当順序変更区分を取得します。
     * @return 充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko() {
        return ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 充当順序変更区分を設定します。
     * @param ID_Kubun_JutoJunjoHenko 充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko(String ID_Kubun_JutoJunjoHenko) {
        this.ID_Kubun_JutoJunjoHenko = ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 特利区分を取得します。
     * @return 特利区分
     */
    public String getID_Kubun_Tokuri() {
        return ID_Kubun_Tokuri;
    }

    /**
     * 特利区分を設定します。
     * @param ID_Kubun_Tokuri 特利区分
     */
    public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
        this.ID_Kubun_Tokuri = ID_Kubun_Tokuri;
    }

    /**
     * 先行する報告書の有無を取得します。
     * @return 先行する報告書の有無
     */
    public boolean getID_Previous_Report() {
        return ID_Previous_Report;
    }

    /**
     * 先行する報告書の有無を設定します。
     * @param ID_Previous_Report 先行する報告書の有無
     */
    public void setID_Previous_Report(boolean ID_Previous_Report) {
        this.ID_Previous_Report = ID_Previous_Report;
    }

    /**
     * 先行する報告書名を取得します。
     * @return 先行する報告書名
     */
    public String getID_Previous_ReportType() {
        return ID_Previous_ReportType;
    }

    /**
     * 先行する報告書名を設定します。
     * @param ID_Previous_ReportType 先行する報告書名
     */
    public void setID_Previous_ReportType(String ID_Previous_ReportType) {
        this.ID_Previous_ReportType = ID_Previous_ReportType;
    }

    /**
     * 繰上償還事由コードリストを取得します。
     * @return 繰上償還事由コードリスト
     */
    public List getID_Code_Kurishojiyu_List() {
        return ID_Code_Kurishojiyu_List;
    }

    /**
     * 繰上償還事由コードリストを設定します。
     * @param ID_Code_Kurishojiyu_List 繰上償還事由コードリスト
     */
    public void setID_Code_Kurishojiyu_List(List ID_Code_Kurishojiyu_List) {
        this.ID_Code_Kurishojiyu_List = ID_Code_Kurishojiyu_List;
    }

    /**
     * データ取得フラグを取得します。
     * @return データ取得フラグ
     */
    public boolean getID_DataGetFlg() {
        return ID_DataGetFlg;
    }

    /**
     * データ取得フラグを設定します。
     * @param ID_DataGetFlg データ取得フラグ
     */
    public void setID_DataGetFlg(boolean ID_DataGetFlg) {
        this.ID_DataGetFlg = ID_DataGetFlg;
    }

    /**
     * 債権管理番号（受渡情報)を取得します。
     * @return 債権管理番号（受渡情報)
     */
    public String getCr004_04_ID_Credit() {
        return Cr004_04_ID_Credit;
    }

    /**
     * 債権管理番号（受渡情報)を設定します。
     * @param Cr004_04_ID_Credit 債権管理番号（受渡情報)
     */
    public void setCr004_04_ID_Credit(String Cr004_04_ID_Credit) {
        this.Cr004_04_ID_Credit = Cr004_04_ID_Credit;
    }

    /**
     * 公庫支店コード（受渡情報)を取得します。
     * @return 公庫支店コード（受渡情報)
     */
    public String getCr004_04_Code_ShokanHonShiten() {
        return Cr004_04_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コード（受渡情報)を設定します。
     * @param Cr004_04_Code_ShokanHonShiten 公庫支店コード（受渡情報)
     */
    public void setCr004_04_Code_ShokanHonShiten(String Cr004_04_Code_ShokanHonShiten) {
        this.Cr004_04_Code_ShokanHonShiten = Cr004_04_Code_ShokanHonShiten;
    }

    /**
     * 扱店コード（受渡情報)を取得します。
     * @return 扱店コード（受渡情報)
     */
    public String getCr004_04_Code_Organization() {
        return Cr004_04_Code_Organization;
    }

    /**
     * 扱店コード（受渡情報)を設定します。
     * @param Cr004_04_Code_Organization 扱店コード（受渡情報)
     */
    public void setCr004_04_Code_Organization(String Cr004_04_Code_Organization) {
        this.Cr004_04_Code_Organization = Cr004_04_Code_Organization;
    }

    /**
     * 店舗コード（受渡情報)を取得します。
     * @return 店舗コード（受渡情報)
     */
    public String getCr004_04_Code_Tenpo() {
        return Cr004_04_Code_Tenpo;
    }

    /**
     * 店舗コード（受渡情報)を設定します。
     * @param Cr004_04_Code_Tenpo 店舗コード（受渡情報)
     */
    public void setCr004_04_Code_Tenpo(String Cr004_04_Code_Tenpo) {
        this.Cr004_04_Code_Tenpo = Cr004_04_Code_Tenpo;
    }

    /**
     * 年度（受渡情報)を取得します。
     * @return 年度（受渡情報)
     */
    public String getCr004_04_Year() {
        return Cr004_04_Year;
    }

    /**
     * 年度（受渡情報)を設定します。
     * @param Cr004_04_Year 年度（受渡情報)
     */
    public void setCr004_04_Year(String Cr004_04_Year) {
        this.Cr004_04_Year = Cr004_04_Year;
    }

    /**
     * 方式資金（受渡情報)を取得します。
     * @return 方式資金（受渡情報)
     */
    public String getCr004_04_Code_HoshikiShikin() {
        return Cr004_04_Code_HoshikiShikin;
    }

    /**
     * 方式資金（受渡情報)を設定します。
     * @param Cr004_04_Code_HoshikiShikin 方式資金（受渡情報)
     */
    public void setCr004_04_Code_HoshikiShikin(String Cr004_04_Code_HoshikiShikin) {
        this.Cr004_04_Code_HoshikiShikin = Cr004_04_Code_HoshikiShikin;
    }

    /**
     * 番号（受渡情報)を取得します。
     * @return 番号（受渡情報)
     */
    public String getCr004_04_ID_Ringi() {
        return Cr004_04_ID_Ringi;
    }

    /**
     * 番号（受渡情報)を設定します。
     * @param Cr004_04_ID_Ringi 番号（受渡情報)
     */
    public void setCr004_04_ID_Ringi(String Cr004_04_ID_Ringi) {
        this.Cr004_04_ID_Ringi = Cr004_04_ID_Ringi;
    }

    /**
     * 枝番（受渡情報)を取得します。
     * @return 枝番（受渡情報)
     */
    public String getCr004_04_ID_RingiBranch() {
        return Cr004_04_ID_RingiBranch;
    }

    /**
     * 枝番（受渡情報)を設定します。
     * @param Cr004_04_ID_RingiBranch 枝番（受渡情報)
     */
    public void setCr004_04_ID_RingiBranch(String Cr004_04_ID_RingiBranch) {
        this.Cr004_04_ID_RingiBranch = Cr004_04_ID_RingiBranch;
    }

    /**
     * 請求データ更新要否フラグを取得します。
     * @return 請求データ更新要否フラグ
     */
    public String getID_SeikyunashiKurisho() {
        return ID_SeikyunashiKurisho;
    }

    /**
     * 請求データ更新要否フラグを設定します。
     * @param ID_SeikyunashiKurisho 請求データ更新要否フラグ
     */
    public void setID_SeikyunashiKurisho(String ID_SeikyunashiKurisho) {
        this.ID_SeikyunashiKurisho = ID_SeikyunashiKurisho;
    }

    /**
     * 約定データ取得件数を取得します。
     * @return 約定データ取得件数
     */
    public String getYakujoCount() {
        return YakujoCount;
    }

    /**
     * 約定データ取得件数を設定します。
     * @param YakujoCount 約定データ取得件数
     */
    public void setYakujoCount(String YakujoCount) {
        this.YakujoCount = YakujoCount;
    }

    /**
     * 請求データ取得件数を取得します。
     * @return 請求データ取得件数
     */
    public String getSeikyuCount() {
        return SeikyuCount;
    }

    /**
     * 請求データ取得件数を設定します。
     * @param SeikyuCount 請求データ取得件数
     */
    public void setSeikyuCount(String SeikyuCount) {
        this.SeikyuCount = SeikyuCount;
    }

    /**
     * 約定検索日付を取得します。
     * @return 約定検索日付
     */
    public String getID_Date_SearchYakujo() {
        return ID_Date_SearchYakujo;
    }

    /**
     * 約定検索日付を設定します。
     * @param ID_Date_SearchYakujo 約定検索日付
     */
    public void setID_Date_SearchYakujo(String ID_Date_SearchYakujo) {
        this.ID_Date_SearchYakujo = ID_Date_SearchYakujo;
    }

    /**
     * 約定検索条件を取得します。
     * @return 約定検索条件
     */
    public String getID_Kind_SearchYakujo() {
        return ID_Kind_SearchYakujo;
    }

    /**
     * 約定検索条件を設定します。
     * @param ID_Kind_SearchYakujo 約定検索条件
     */
    public void setID_Kind_SearchYakujo(String ID_Kind_SearchYakujo) {
        this.ID_Kind_SearchYakujo = ID_Kind_SearchYakujo;
    }

    /**
     * 約定検索結果・払込年月日を取得します。
     * @return 約定検索結果・払込年月日
     */
    public String getID_Date_Haraikomi_YakujoAns() {
        return ID_Date_Haraikomi_YakujoAns;
    }

    /**
     * 約定検索結果・払込年月日を設定します。
     * @param ID_Date_Haraikomi_YakujoAns 約定検索結果・払込年月日
     */
    public void setID_Date_Haraikomi_YakujoAns(String ID_Date_Haraikomi_YakujoAns) {
        this.ID_Date_Haraikomi_YakujoAns = ID_Date_Haraikomi_YakujoAns;
    }

    /**
     * 約定検索結果・請求繰上償還利息を取得します。
     * @return 約定検索結果・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_YakujoAns() {
        return ID_M_SeiKuriRisoku_YakujoAns;
    }

    /**
     * 約定検索結果・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_YakujoAns 約定検索結果・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_YakujoAns(String ID_M_SeiKuriRisoku_YakujoAns) {
        this.ID_M_SeiKuriRisoku_YakujoAns = ID_M_SeiKuriRisoku_YakujoAns;
    }

    /**
     * 約定検索結果・約定元金を取得します。
     * @return 約定検索結果・約定元金
     */
    public String getID_M_YakujoGankin_YakujoAns() {
        return ID_M_YakujoGankin_YakujoAns;
    }

    /**
     * 約定検索結果・約定元金を設定します。
     * @param ID_M_YakujoGankin_YakujoAns 約定検索結果・約定元金
     */
    public void setID_M_YakujoGankin_YakujoAns(String ID_M_YakujoGankin_YakujoAns) {
        this.ID_M_YakujoGankin_YakujoAns = ID_M_YakujoGankin_YakujoAns;
    }

    /**
     * 約定検索結果・約定利息を取得します。
     * @return 約定検索結果・約定利息
     */
    public String getID_M_YakujoRisoku_YakujoAns() {
        return ID_M_YakujoRisoku_YakujoAns;
    }

    /**
     * 約定検索結果・約定利息を設定します。
     * @param ID_M_YakujoRisoku_YakujoAns 約定検索結果・約定利息
     */
    public void setID_M_YakujoRisoku_YakujoAns(String ID_M_YakujoRisoku_YakujoAns) {
        this.ID_M_YakujoRisoku_YakujoAns = ID_M_YakujoRisoku_YakujoAns;
    }

    /**
     * 請求検索日付を取得します。
     * @return 請求検索日付
     */
    public String getID_Date_SearchSeikyu() {
        return ID_Date_SearchSeikyu;
    }

    /**
     * 請求検索日付を設定します。
     * @param ID_Date_SearchSeikyu 請求検索日付
     */
    public void setID_Date_SearchSeikyu(String ID_Date_SearchSeikyu) {
        this.ID_Date_SearchSeikyu = ID_Date_SearchSeikyu;
    }

    /**
     * 請求検索結果・払込年月日を取得します。
     * @return 請求検索結果・払込年月日
     */
    public String getID_Date_Haraikomi_SeikyuAns() {
        return ID_Date_Haraikomi_SeikyuAns;
    }

    /**
     * 請求検索結果・払込年月日を設定します。
     * @param ID_Date_Haraikomi_SeikyuAns 請求検索結果・払込年月日
     */
    public void setID_Date_Haraikomi_SeikyuAns(String ID_Date_Haraikomi_SeikyuAns) {
        this.ID_Date_Haraikomi_SeikyuAns = ID_Date_Haraikomi_SeikyuAns;
    }

    /**
     * 請求検索結果・約定元金を取得します。
     * @return 請求検索結果・約定元金
     */
    public String getID_M_YakujoGankin_SeikyuAns() {
        return ID_M_YakujoGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・約定元金を設定します。
     * @param ID_M_YakujoGankin_SeikyuAns 請求検索結果・約定元金
     */
    public void setID_M_YakujoGankin_SeikyuAns(String ID_M_YakujoGankin_SeikyuAns) {
        this.ID_M_YakujoGankin_SeikyuAns = ID_M_YakujoGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・約定利息を取得します。
     * @return 請求検索結果・約定利息
     */
    public String getID_M_YakujoRisoku_SeikyuAns() {
        return ID_M_YakujoRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・約定利息を設定します。
     * @param ID_M_YakujoRisoku_SeikyuAns 請求検索結果・約定利息
     */
    public void setID_M_YakujoRisoku_SeikyuAns(String ID_M_YakujoRisoku_SeikyuAns) {
        this.ID_M_YakujoRisoku_SeikyuAns = ID_M_YakujoRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還元金を取得します。
     * @return 請求検索結果・請求繰上償還元金
     */
    public String getID_M_SeiKuriGankin_SeikyuAns() {
        return ID_M_SeiKuriGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還元金を設定します。
     * @param ID_M_SeiKuriGankin_SeikyuAns 請求検索結果・請求繰上償還元金
     */
    public void setID_M_SeiKuriGankin_SeikyuAns(String ID_M_SeiKuriGankin_SeikyuAns) {
        this.ID_M_SeiKuriGankin_SeikyuAns = ID_M_SeiKuriGankin_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還利息を取得します。
     * @return 請求検索結果・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_SeikyuAns() {
        return ID_M_SeiKuriRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_SeikyuAns 請求検索結果・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_SeikyuAns(String ID_M_SeiKuriRisoku_SeikyuAns) {
        this.ID_M_SeiKuriRisoku_SeikyuAns = ID_M_SeiKuriRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・任意繰上償還利息を取得します。
     * @return 請求検索結果・任意繰上償還利息
     */
    public String getID_M_NinKuriRisoku_SeikyuAns() {
        return ID_M_NinKuriRisoku_SeikyuAns;
    }

    /**
     * 請求検索結果・任意繰上償還利息を設定します。
     * @param ID_M_NinKuriRisoku_SeikyuAns 請求検索結果・任意繰上償還利息
     */
    public void setID_M_NinKuriRisoku_SeikyuAns(String ID_M_NinKuriRisoku_SeikyuAns) {
        this.ID_M_NinKuriRisoku_SeikyuAns = ID_M_NinKuriRisoku_SeikyuAns;
    }

    /**
     * 入金履歴検索日付を取得します。
     * @return 入金履歴検索日付
     */
    public String getID_Date_SearchNyukinHistory() {
        return ID_Date_SearchNyukinHistory;
    }

    /**
     * 入金履歴検索日付を設定します。
     * @param ID_Date_SearchNyukinHistory 入金履歴検索日付
     */
    public void setID_Date_SearchNyukinHistory(String ID_Date_SearchNyukinHistory) {
        this.ID_Date_SearchNyukinHistory = ID_Date_SearchNyukinHistory;
    }

    /**
     * 入金履歴データ取得件数を取得します。
     * @return 入金履歴データ取得件数
     */
    public String getNyukinHistoryCount() {
        return NyukinHistoryCount;
    }

    /**
     * 入金履歴データ取得件数を設定します。
     * @param NyukinHistoryCount 入金履歴データ取得件数
     */
    public void setNyukinHistoryCount(String NyukinHistoryCount) {
        this.NyukinHistoryCount = NyukinHistoryCount;
    }

    /**
     * 入金履歴検索結果・約定元金（合計）を取得します。
     * @return 入金履歴検索結果・約定元金（合計）
     */
    public String getID_M_YakujoGankinKei_NyukinHistory() {
        return ID_M_YakujoGankinKei_NyukinHistory;
    }

    /**
     * 入金履歴検索結果・約定元金（合計）を設定します。
     * @param ID_M_YakujoGankinKei_NyukinHistory 入金履歴検索結果・約定元金（合計）
     */
    public void setID_M_YakujoGankinKei_NyukinHistory(String ID_M_YakujoGankinKei_NyukinHistory) {
        this.ID_M_YakujoGankinKei_NyukinHistory = ID_M_YakujoGankinKei_NyukinHistory;
    }

    /**
     * 入金履歴検索結果・約定利息（合計）を取得します。
     * @return 入金履歴検索結果・約定利息（合計）
     */
    public String getID_M_YakujoRisokuKei_NyukinHistory() {
        return ID_M_YakujoRisokuKei_NyukinHistory;
    }

    /**
     * 入金履歴検索結果・約定利息（合計）を設定します。
     * @param ID_M_YakujoRisokuKei_NyukinHistory 入金履歴検索結果・約定利息（合計）
     */
    public void setID_M_YakujoRisokuKei_NyukinHistory(String ID_M_YakujoRisokuKei_NyukinHistory) {
        this.ID_M_YakujoRisokuKei_NyukinHistory = ID_M_YakujoRisokuKei_NyukinHistory;
    }

    /**
     * 発生エラー番号を取得します。
     * @return 発生エラー番号
     */
    public String getErrorNo() {
        return errorNo;
    }

    /**
     * 発生エラー番号を設定します。
     * @param errorNo 発生エラー番号
     */
    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo;
    }

    /**
     * 入金日直前・払込年月日を取得します。
     * @return 入金日直前・払込年月日
     */
    public String getID_Date_Haraikomi_before() {
        return ID_Date_Haraikomi_before;
    }

    /**
     * 入金日直前・払込年月日を設定します。
     * @param ID_Date_Haraikomi_before 入金日直前・払込年月日
     */
    public void setID_Date_Haraikomi_before(String ID_Date_Haraikomi_before) {
        this.ID_Date_Haraikomi_before = ID_Date_Haraikomi_before;
    }

    /**
     * 入金日直前・請求繰上償還利息を取得します。
     * @return 入金日直前・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_before() {
        return ID_M_SeiKuriRisoku_before;
    }

    /**
     * 入金日直前・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_before 入金日直前・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_before(String ID_M_SeiKuriRisoku_before) {
        this.ID_M_SeiKuriRisoku_before = ID_M_SeiKuriRisoku_before;
    }

    /**
     * 入金日直前・約定元金を取得します。
     * @return 入金日直前・約定元金
     */
    public String getID_M_YakujoGankin_before() {
        return ID_M_YakujoGankin_before;
    }

    /**
     * 入金日直前・約定元金を設定します。
     * @param ID_M_YakujoGankin_before 入金日直前・約定元金
     */
    public void setID_M_YakujoGankin_before(String ID_M_YakujoGankin_before) {
        this.ID_M_YakujoGankin_before = ID_M_YakujoGankin_before;
    }

    /**
     * 入金日直前・約定利息を取得します。
     * @return 入金日直前・約定利息
     */
    public String getID_M_YakujoRisoku_before() {
        return ID_M_YakujoRisoku_before;
    }

    /**
     * 入金日直前・約定利息を設定します。
     * @param ID_M_YakujoRisoku_before 入金日直前・約定利息
     */
    public void setID_M_YakujoRisoku_before(String ID_M_YakujoRisoku_before) {
        this.ID_M_YakujoRisoku_before = ID_M_YakujoRisoku_before;
    }

    /**
     * 入金日直後・払込年月日を取得します。
     * @return 入金日直後・払込年月日
     */
    public String getID_Date_Haraikomi_after() {
        return ID_Date_Haraikomi_after;
    }

    /**
     * 入金日直後・払込年月日を設定します。
     * @param ID_Date_Haraikomi_after 入金日直後・払込年月日
     */
    public void setID_Date_Haraikomi_after(String ID_Date_Haraikomi_after) {
        this.ID_Date_Haraikomi_after = ID_Date_Haraikomi_after;
    }

    /**
     * 入金日直後・請求繰上償還利息を取得します。
     * @return 入金日直後・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_after() {
        return ID_M_SeiKuriRisoku_after;
    }

    /**
     * 入金日直後・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_after 入金日直後・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_after(String ID_M_SeiKuriRisoku_after) {
        this.ID_M_SeiKuriRisoku_after = ID_M_SeiKuriRisoku_after;
    }

    /**
     * 入金日直後・約定元金を取得します。
     * @return 入金日直後・約定元金
     */
    public String getID_M_YakujoGankin_after() {
        return ID_M_YakujoGankin_after;
    }

    /**
     * 入金日直後・約定元金を設定します。
     * @param ID_M_YakujoGankin_after 入金日直後・約定元金
     */
    public void setID_M_YakujoGankin_after(String ID_M_YakujoGankin_after) {
        this.ID_M_YakujoGankin_after = ID_M_YakujoGankin_after;
    }

    /**
     * 入金日直後・約定利息を取得します。
     * @return 入金日直後・約定利息
     */
    public String getID_M_YakujoRisoku_after() {
        return ID_M_YakujoRisoku_after;
    }

    /**
     * 入金日直後・約定利息を設定します。
     * @param ID_M_YakujoRisoku_after 入金日直後・約定利息
     */
    public void setID_M_YakujoRisoku_after(String ID_M_YakujoRisoku_after) {
        this.ID_M_YakujoRisoku_after = ID_M_YakujoRisoku_after;
    }

    /**
     * 次回・払込年月日を取得します。
     * @return 次回・払込年月日
     */
    public String getID_Date_Haraikomi_next() {
        return ID_Date_Haraikomi_next;
    }

    /**
     * 次回・払込年月日を設定します。
     * @param ID_Date_Haraikomi_next 次回・払込年月日
     */
    public void setID_Date_Haraikomi_next(String ID_Date_Haraikomi_next) {
        this.ID_Date_Haraikomi_next = ID_Date_Haraikomi_next;
    }

    /**
     * 次回・請求繰上償還利息を取得します。
     * @return 次回・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_next() {
        return ID_M_SeiKuriRisoku_next;
    }

    /**
     * 次回・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_next 次回・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_next(String ID_M_SeiKuriRisoku_next) {
        this.ID_M_SeiKuriRisoku_next = ID_M_SeiKuriRisoku_next;
    }

    /**
     * 次回・約定元金を取得します。
     * @return 次回・約定元金
     */
    public String getID_M_YakujoGankin_next() {
        return ID_M_YakujoGankin_next;
    }

    /**
     * 次回・約定元金を設定します。
     * @param ID_M_YakujoGankin_next 次回・約定元金
     */
    public void setID_M_YakujoGankin_next(String ID_M_YakujoGankin_next) {
        this.ID_M_YakujoGankin_next = ID_M_YakujoGankin_next;
    }

    /**
     * 次回・約定利息を取得します。
     * @return 次回・約定利息
     */
    public String getID_M_YakujoRisoku_next() {
        return ID_M_YakujoRisoku_next;
    }

    /**
     * 次回・約定利息を設定します。
     * @param ID_M_YakujoRisoku_next 次回・約定利息
     */
    public void setID_M_YakujoRisoku_next(String ID_M_YakujoRisoku_next) {
        this.ID_M_YakujoRisoku_next = ID_M_YakujoRisoku_next;
    }

    /**
     * 次々回・払込年月日を取得します。
     * @return 次々回・払込年月日
     */
    public String getID_Date_Haraikomi_next_next() {
        return ID_Date_Haraikomi_next_next;
    }

    /**
     * 次々回・払込年月日を設定します。
     * @param ID_Date_Haraikomi_next_next 次々回・払込年月日
     */
    public void setID_Date_Haraikomi_next_next(String ID_Date_Haraikomi_next_next) {
        this.ID_Date_Haraikomi_next_next = ID_Date_Haraikomi_next_next;
    }

    /**
     * 次々回・請求繰上償還利息を取得します。
     * @return 次々回・請求繰上償還利息
     */
    public String getID_M_SeiKuriRisoku_next_next() {
        return ID_M_SeiKuriRisoku_next_next;
    }

    /**
     * 次々回・請求繰上償還利息を設定します。
     * @param ID_M_SeiKuriRisoku_next_next 次々回・請求繰上償還利息
     */
    public void setID_M_SeiKuriRisoku_next_next(String ID_M_SeiKuriRisoku_next_next) {
        this.ID_M_SeiKuriRisoku_next_next = ID_M_SeiKuriRisoku_next_next;
    }

    /**
     * 次々回・約定元金を取得します。
     * @return 次々回・約定元金
     */
    public String getID_M_YakujoGankin_next_next() {
        return ID_M_YakujoGankin_next_next;
    }

    /**
     * 次々回・約定元金を設定します。
     * @param ID_M_YakujoGankin_next_next 次々回・約定元金
     */
    public void setID_M_YakujoGankin_next_next(String ID_M_YakujoGankin_next_next) {
        this.ID_M_YakujoGankin_next_next = ID_M_YakujoGankin_next_next;
    }

    /**
     * 次々回・約定利息を取得します。
     * @return 次々回・約定利息
     */
    public String getID_M_YakujoRisoku_next_next() {
        return ID_M_YakujoRisoku_next_next;
    }

    /**
     * 次々回・約定利息を設定します。
     * @param ID_M_YakujoRisoku_next_next 次々回・約定利息
     */
    public void setID_M_YakujoRisoku_next_next(String ID_M_YakujoRisoku_next_next) {
        this.ID_M_YakujoRisoku_next_next = ID_M_YakujoRisoku_next_next;
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

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を取得します。
     *
     * @return 受託者勘定処理年月（元号）（隠し項目）
     */
    public String getHdnID_Date_Jtkshori_Gengo() {
        return hdnID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月（元号）（隠し項目）を設定します。
     *
     * @param hdnID_Date_Jtkshori_Gengo 受託者勘定処理年月（元号）（隠し項目）
     */
    public void setHdnID_Date_Jtkshori_Gengo(String hdnID_Date_Jtkshori_Gengo) {
        this.hdnID_Date_Jtkshori_Gengo = hdnID_Date_Jtkshori_Gengo;
        this.drpID_Date_JtkShori_Gengo = hdnID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を取得します。
     *
     * @return 受託者勘定処理年月（月）（隠し項目）
     */
    public String getHdnID_Date_JtkshoriTsuki_Candidate() {
        return hdnID_Date_JtkshoriTsuki_Candidate;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を設定します。
     *
     * @param hdnID_Date_JtkshoriTsuki_Candidate 受託者勘定処理年月（月）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriTsuki_Candidate(String hdnID_Date_JtkshoriTsuki_Candidate) {
        this.hdnID_Date_JtkshoriTsuki_Candidate = hdnID_Date_JtkshoriTsuki_Candidate;
        this.drpID_Date_JtkShori_Tsuki = hdnID_Date_JtkshoriTsuki_Candidate;
    }
}