//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01M1DTO
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
public class Cr001_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 案件 */
    private String lblIndex;
    /** 選択 */
    private String chkUpdate;
    /** 顧客名 */
    private String ID_Name_Customer;
    /** 扱店名 */
    private String ID_Name_Organization;
    /** 公庫支店 */
    private String ID_Code_ShokanHonShiten;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Code_Hoshiki_Shikin;
    /** 番号 */
    private String ID_Ringi;
    /** 枝番 */
    private String ID_RingiBranch;
    /** 資金使途 */
    private String ID_Code_ShikinShito;
    /** 事業別 */
    private String ID_Code_Jigyoubetsu;
    /** 利率（％） */
    private String ID_Riritsu;
    /** 特利区分 */
    private String ID_Kubun_Tokuri;
    /** 特利（％） */
    private String ID_Tokuri;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 受託者勘定処理年月(元号) */
    private String ID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月(年) */
    private String ID_Date_Jtkshori_Nen;
    /** 受託者勘定処理年月(月) */
    private String ID_Date_JtkshoriTsuki_Candidate;
    /** 貸付実行日（元号） */
    private String ID_Date_Kashitsukejikko_Gengo;
    /** 貸付実行日（年） */
    private String ID_Date_Kashitsukejikko_Nen;
    /** 貸付実行日（月） */
    private String ID_Date_KashitsukejikkoTsuki_Candidate;
    /** 貸付実行日（日） */
    private String ID_Date_KashitsukejikkoBi_Candidate;
    /** 貸付実行金額(円) */
    private String ID_M_Kashitsuke;
    /** 資金交付額(円) */
    private String ID_M_SikinKofu;
    /** 貸付受入金受入額(円) */
    private String ID_M_KashitsukeUkeire;
    /** 貸付実行報告書作成済みフラグ */
    private String ID_Flag_Kj;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告年月日 */
    private String ID_Date_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** ユーザID */
    private String ID_UserID;
    /** 伝送番号 */
    private String ID_Denso;
    /** データコード */
    private String ID_DataCode;
    /** 履歴番号 */
    private String ID_ID_History;
    /** ステータス(非表示) */
    private String ID_Status;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi;
    /** エラーコード */
    private String ID_Code_Error;
    /** エラーメッセージ */
    private String ID_ErrorMessage;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 貸付先コード */
    private String ID_Code_Customer;
    /** 受理起算日(実行起算予定日) */
    private String ID_Date_JuriKisan;
    /** 決定起算年月日 */
    private String ID_Date_KetteiKisan;
    /** 貸付件数 */
    private String ID_Count_Kashitsuke;
    /** 最新データ更新日付 */
    private String Data_LastUpDate;
    /** 受託者勘定処理年月（元号）（隠し項目） */
    private String hdnID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月（月）（隠し項目） */
    private String hdnID_Date_JtkshoriTsuki_Candidate;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr001_01M1DTO() {
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
    public Cr001_01M1DTO(Cr001_01M1DTO orig) {
        super(orig);
    }

    /**
     * 案件を取得します。
     *
     * @return 案件
     */
    public String getLblIndex() {
        return lblIndex;
    }

    /**
     * 案件を設定します。
     *
     * @param lblIndex
     *            案件
     */
    public void setLblIndex(String lblIndex) {
        this.lblIndex = lblIndex;
    }

    /**
     * 選択を取得します。
     *
     * @return 選択
     */
    public String getChkUpdate() {
        return chkUpdate;
    }

    /**
     * 選択を設定します。
     *
     * @param chkUpdate
     *            選択
     */
    public void setChkUpdate(String chkUpdate) {
        this.chkUpdate = chkUpdate;
    }

    /**
     * 顧客名を取得します。
     *
     * @return 顧客名
     */
    public String getID_Name_Customer() {
        return ID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     *
     * @param ID_Name_Customer
     *            顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        this.ID_Name_Customer = ID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getID_Name_Organization() {
        return ID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param ID_Name_Organization
     *            扱店名
     */
    public void setID_Name_Organization(String ID_Name_Organization) {
        this.ID_Name_Organization = ID_Name_Organization;
    }

    /**
     * 公庫支店を取得します。
     *
     * @return 公庫支店
     */
    public String getID_Code_ShokanHonShiten() {
        return ID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     *
     * @param ID_Code_ShokanHonShiten
     *            公庫支店
     */
    public void setID_Code_ShokanHonShiten(String ID_Code_ShokanHonShiten) {
        this.ID_Code_ShokanHonShiten = ID_Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param ID_Code_Organization
     *            扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param ID_Code_Tenpo
     *            店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     *
     * @param ID_Year
     *            年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     *
     * @return 方式資金
     */
    public String getID_Code_Hoshiki_Shikin() {
        return ID_Code_Hoshiki_Shikin;
    }

    /**
     * 方式資金を設定します。
     *
     * @param ID_Code_Hoshiki_Shikin
     *            方式資金
     */
    public void setID_Code_Hoshiki_Shikin(String ID_Code_Hoshiki_Shikin) {
        this.ID_Code_Hoshiki_Shikin = ID_Code_Hoshiki_Shikin;
    }

    /**
     * 番号を取得します。
     *
     * @return 番号
     */
    public String getID_Ringi() {
        return ID_Ringi;
    }

    /**
     * 番号を設定します。
     *
     * @param ID_Ringi
     *            番号
     */
    public void setID_Ringi(String ID_Ringi) {
        this.ID_Ringi = ID_Ringi;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public String getID_RingiBranch() {
        return ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     *
     * @param ID_RingiBranch
     *            枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        this.ID_RingiBranch = ID_RingiBranch;
    }

    /**
     * 資金使途を取得します。
     *
     * @return 資金使途
     */
    public String getID_Code_ShikinShito() {
        return ID_Code_ShikinShito;
    }

    /**
     * 資金使途を設定します。
     *
     * @param ID_Code_ShikinShito
     *            資金使途
     */
    public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
        this.ID_Code_ShikinShito = ID_Code_ShikinShito;
    }

    /**
     * 事業別を取得します。
     *
     * @return 事業別
     */
    public String getID_Code_Jigyoubetsu() {
        return ID_Code_Jigyoubetsu;
    }

    /**
     * 事業別を設定します。
     *
     * @param ID_Code_Jigyoubetsu
     *            事業別
     */
    public void setID_Code_Jigyoubetsu(String ID_Code_Jigyoubetsu) {
        this.ID_Code_Jigyoubetsu = ID_Code_Jigyoubetsu;
    }

    /**
     * 利率（％）を取得します。
     *
     * @return 利率（％）
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率（％）を設定します。
     *
     * @param ID_Riritsu
     *            利率（％）
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
    }

    /**
     * 特利区分を取得します。
     *
     * @return 特利区分
     */
    public String getID_Kubun_Tokuri() {
        return ID_Kubun_Tokuri;
    }

    /**
     * 特利区分を設定します。
     *
     * @param ID_Kubun_Tokuri
     *            特利区分
     */
    public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
        this.ID_Kubun_Tokuri = ID_Kubun_Tokuri;
    }

    /**
     * 特利（％）を取得します。
     *
     * @return 特利（％）
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利（％）を設定します。
     *
     * @param ID_Tokuri
     *            特利（％）
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 据置期限を取得します。
     *
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     *
     * @param ID_Date_SueokiKigen
     *            据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     *
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     *
     * @param ID_Date_ShokanKigen
     *            償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日を取得します。
     *
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込日を設定します。
     *
     * @param ID_Date_GanrikinHaraiKomi
     *            元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 受託者勘定処理年月(元号)を取得します。
     *
     * @return 受託者勘定処理年月(元号)
     */
    public String getID_Date_Jtkshori_Gengo() {
        return ID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(元号)を設定します。
     *
     * @param ID_Date_Jtkshori_Gengo
     *            受託者勘定処理年月(元号)
     */
    public void setID_Date_Jtkshori_Gengo(String ID_Date_Jtkshori_Gengo) {
        this.ID_Date_Jtkshori_Gengo = ID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(年)を取得します。
     *
     * @return 受託者勘定処理年月(年)
     */
    public String getID_Date_Jtkshori_Nen() {
        return ID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(年)を設定します。
     *
     * @param ID_Date_Jtkshori_Nen
     *            受託者勘定処理年月(年)
     */
    public void setID_Date_Jtkshori_Nen(String ID_Date_Jtkshori_Nen) {
        this.ID_Date_Jtkshori_Nen = ID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(月)を取得します。
     *
     * @return 受託者勘定処理年月(月)
     */
    public String getID_Date_JtkshoriTsuki_Candidate() {
        return ID_Date_JtkshoriTsuki_Candidate;
    }

    /**
     * 受託者勘定処理年月(月)を設定します。
     *
     * @param ID_Date_JtkshoriTsuki_Candidate
     *            受託者勘定処理年月(月)
     */
    public void setID_Date_JtkshoriTsuki_Candidate(
            String ID_Date_JtkshoriTsuki_Candidate) {
        this.ID_Date_JtkshoriTsuki_Candidate = ID_Date_JtkshoriTsuki_Candidate;
    }

    /**
     * 貸付実行日（元号）を取得します。
     *
     * @return 貸付実行日（元号）
     */
    public String getID_Date_Kashitsukejikko_Gengo() {
        return ID_Date_Kashitsukejikko_Gengo;
    }

    /**
     * 貸付実行日（元号）を設定します。
     *
     * @param ID_Date_Kashitsukejikko_Gengo
     *            貸付実行日（元号）
     */
    public void setID_Date_Kashitsukejikko_Gengo(
            String ID_Date_Kashitsukejikko_Gengo) {
        this.ID_Date_Kashitsukejikko_Gengo = ID_Date_Kashitsukejikko_Gengo;
    }

    /**
     * 貸付実行日（年）を取得します。
     *
     * @return 貸付実行日（年）
     */
    public String getID_Date_Kashitsukejikko_Nen() {
        return ID_Date_Kashitsukejikko_Nen;
    }

    /**
     * 貸付実行日（年）を設定します。
     *
     * @param ID_Date_Kashitsukejikko_Nen
     *            貸付実行日（年）
     */
    public void setID_Date_Kashitsukejikko_Nen(
            String ID_Date_Kashitsukejikko_Nen) {
        this.ID_Date_Kashitsukejikko_Nen = ID_Date_Kashitsukejikko_Nen;
    }

    /**
     * 貸付実行日（月）を取得します。
     *
     * @return 貸付実行日（月）
     */
    public String getID_Date_KashitsukejikkoTsuki_Candidate() {
        return ID_Date_KashitsukejikkoTsuki_Candidate;
    }

    /**
     * 貸付実行日（月）を設定します。
     *
     * @param ID_Date_KashitsukejikkoTsuki_Candidate
     *            貸付実行日（月）
     */
    public void setID_Date_KashitsukejikkoTsuki_Candidate(
            String ID_Date_KashitsukejikkoTsuki_Candidate) {
        this.ID_Date_KashitsukejikkoTsuki_Candidate = ID_Date_KashitsukejikkoTsuki_Candidate;
    }

    /**
     * 貸付実行日（日）を取得します。
     *
     * @return 貸付実行日（日）
     */
    public String getID_Date_KashitsukejikkoBi_Candidate() {
        return ID_Date_KashitsukejikkoBi_Candidate;
    }

    /**
     * 貸付実行日（日）を設定します。
     *
     * @param ID_Date_KashitsukejikkoBi_Candidate
     *            貸付実行日（日）
     */
    public void setID_Date_KashitsukejikkoBi_Candidate(
            String ID_Date_KashitsukejikkoBi_Candidate) {
        this.ID_Date_KashitsukejikkoBi_Candidate = ID_Date_KashitsukejikkoBi_Candidate;
    }

    /**
     * 貸付実行金額(円)を取得します。
     *
     * @return 貸付実行金額(円)
     */
    public String getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付実行金額(円)を設定します。
     *
     * @param ID_M_Kashitsuke
     *            貸付実行金額(円)
     */
    public void setID_M_Kashitsuke(String ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 資金交付額(円)を取得します。
     *
     * @return 資金交付額(円)
     */
    public String getID_M_SikinKofu() {
        return ID_M_SikinKofu;
    }

    /**
     * 資金交付額(円)を設定します。
     *
     * @param ID_M_SikinKofu
     *            資金交付額(円)
     */
    public void setID_M_SikinKofu(String ID_M_SikinKofu) {
        this.ID_M_SikinKofu = ID_M_SikinKofu;
    }

    /**
     * 貸付受入金受入額(円)を取得します。
     *
     * @return 貸付受入金受入額(円)
     */
    public String getID_M_KashitsukeUkeire() {
        return ID_M_KashitsukeUkeire;
    }

    /**
     * 貸付受入金受入額(円)を設定します。
     *
     * @param ID_M_KashitsukeUkeire
     *            貸付受入金受入額(円)
     */
    public void setID_M_KashitsukeUkeire(String ID_M_KashitsukeUkeire) {
        this.ID_M_KashitsukeUkeire = ID_M_KashitsukeUkeire;
    }

    /**
     * 貸付実行報告書作成済みフラグを取得します。
     *
     * @return 貸付実行報告書作成済みフラグ
     */
    public String getID_Flag_Kj() {
        return ID_Flag_Kj;
    }

    /**
     * 貸付実行報告書作成済みフラグを設定します。
     *
     * @param ID_Flag_Kj
     *            貸付実行報告書作成済みフラグ
     */
    public void setID_Flag_Kj(String ID_Flag_Kj) {
        this.ID_Flag_Kj = ID_Flag_Kj;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param ID_ID_Report
     *            報告書番号
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getID_Date_Report() {
        return ID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param ID_Date_Report
     *            報告年月日
     */
    public void setID_Date_Report(String ID_Date_Report) {
        this.ID_Date_Report = ID_Date_Report;
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
    public String getID_Denso() {
        return ID_Denso;
    }

    /**
     * 伝送番号を設定します。
     *
     * @param ID_Denso
     *            伝送番号
     */
    public void setID_Denso(String ID_Denso) {
        this.ID_Denso = ID_Denso;
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
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param ID_ID_History
     *            履歴番号
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * ステータス(非表示)を取得します。
     *
     * @return ステータス(非表示)
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータス(非表示)を設定します。
     *
     * @param ID_Status
     *            ステータス(非表示)
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
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
     * エラーコードを取得します。
     *
     * @return エラーコード
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラーコードを設定します。
     *
     * @param ID_Code_Error
     *            エラーコード
     */
    public void setID_Code_Error(String ID_Code_Error) {
        this.ID_Code_Error = ID_Code_Error;
    }

    /**
     * エラーメッセージを取得します。
     *
     * @return エラーメッセージ
     */
    public String getID_ErrorMessage() {
        return ID_ErrorMessage;
    }

    /**
     * エラーメッセージを設定します。
     *
     * @param ID_ErrorMessage
     *            エラーメッセージ
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        this.ID_ErrorMessage = ID_ErrorMessage;
    }

    /**
     * 債権管理番号を取得します。
     *
     * @return 債権管理番号
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     *
     * @param ID_ID_Credit
     *            債権管理番号
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 貸付先コードを取得します。
     *
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 貸付先コードを設定します。
     *
     * @param ID_Code_Customer
     *            貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
    }

    /**
     * 受理起算日(実行起算予定日)を取得します。
     *
     * @return 受理起算日(実行起算予定日)
     */
    public String getID_Date_JuriKisan() {
        return ID_Date_JuriKisan;
    }

    /**
     * 受理起算日(実行起算予定日)を設定します。
     *
     * @param ID_Date_JuriKisan
     *            受理起算日(実行起算予定日)
     */
    public void setID_Date_JuriKisan(String ID_Date_JuriKisan) {
        this.ID_Date_JuriKisan = ID_Date_JuriKisan;
    }

    /**
     * 決定起算年月日を取得します。
     *
     * @return 決定起算年月日
     */
    public String getID_Date_KetteiKisan() {
        return ID_Date_KetteiKisan;
    }

    /**
     * 決定起算年月日を設定します。
     *
     * @param ID_Date_KetteiKisan
     *            決定起算年月日
     */
    public void setID_Date_KetteiKisan(String ID_Date_KetteiKisan) {
        this.ID_Date_KetteiKisan = ID_Date_KetteiKisan;
    }

    /**
     * 貸付件数を取得します。
     *
     * @return 貸付件数
     */
    public String getID_Count_Kashitsuke() {
        return ID_Count_Kashitsuke;
    }

    /**
     * 貸付件数を設定します。
     *
     * @param ID_Count_Kashitsuke
     *            貸付件数
     */
    public void setID_Count_Kashitsuke(String ID_Count_Kashitsuke) {
        this.ID_Count_Kashitsuke = ID_Count_Kashitsuke;
    }

    /**
     * 最新データ更新日付を取得します。
     *
     * @return 最新データ更新日付
     */
    public String getData_LastUpDate() {
        return Data_LastUpDate;
    }

    /**
     * 最新データ更新日付を設定します。
     *
     * @param Data_LastUpDate
     *            最新データ更新日付
     */
    public void setData_LastUpDate(String Data_LastUpDate) {
        this.Data_LastUpDate = Data_LastUpDate;
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
     * @param hdnID_Date_Jtkshori_Gengo
     *            受託者勘定処理年月（元号）（隠し項目）
     */
    public void setHdnID_Date_Jtkshori_Gengo(String hdnID_Date_Jtkshori_Gengo) {
        this.hdnID_Date_Jtkshori_Gengo = hdnID_Date_Jtkshori_Gengo;
        this.ID_Date_Jtkshori_Gengo = hdnID_Date_Jtkshori_Gengo;
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
     * @param hdnID_Date_JtkshoriTsuki_Candidate
     *            受託者勘定処理年月（月）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriTsuki_Candidate(
            String hdnID_Date_JtkshoriTsuki_Candidate) {
        this.hdnID_Date_JtkshoriTsuki_Candidate = hdnID_Date_JtkshoriTsuki_Candidate;
        this.ID_Date_JtkshoriTsuki_Candidate = hdnID_Date_JtkshoriTsuki_Candidate;
    }
}