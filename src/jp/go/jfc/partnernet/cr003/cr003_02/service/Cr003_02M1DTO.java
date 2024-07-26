//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr003_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 案件 */
    private String ID_Anken_Index;
    /** 報告書作成不許可メッセージ */
    private String ID_Create_NG;
    /** 選択 */
    private String chkUpdate;
    /** 顧客名 */
    private String ID_Name_Customer;
    /** 扱店名 */
    private String ID_Name_Organization;
    /** 公庫支店コード */
    private String ID_Code_ShokanHonShiten;
    /** 扱店コード */
    private String ID_Code_Organization;
    /** 店舗コード */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Code_HoshikiShikin;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 貸付実行日 */
    private String ID_Date_Jikko;
    /** 貸付実行金額 */
    private String ID_M_Kashitsuke;
    /** 資金使途コード */
    private String ID_Code_ShikinShito;
    /** 事業別 */
    private String ID_Code_Jigyobetsu;
    /** 利率（％） */
    private String ID_Riritsu;
    /** 特利区分 */
    private String ID_Kubun_Tokuri;
    /** 特利（％） */
    private String ID_Tokuri;
    /** 償還方法 */
    private String ID_Code_ShokanHouhou;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 元利または元金均等額（円） */
    private String ID_M_Fukin;
    /** 払込前残元金（円） */
    private String ID_M_KashitsukeZandaka;
    /** 払込期日 */
    private String ID_Date_Haraikomi;
    /** 払込金額（円） */
    private String ID_M_Haraikomi;
    /** 控除利息（円） */
    private String ID_M_KojoRisoku;
    /** 差引払込金額（円） */
    private String ID_M_SashihikiHaraikomi;
    /** 払込後残元金（円） */
    private String ID_M_ZangankinAfterHaraikomi;
    /** 約定利息 */
    private String ID_M_YakujoRisoku;
    /** 約定元金 */
    private String ID_M_YakujoGankin;
    /** 遅延損害金（円） */
    private String ID_M_ChienSongai;
    /** 違約金（円） */
    private String ID_M_Iyaku;
    /** 違約金（利子軽減分）（円） */
    private String ID_M_IyakuRishikeigen;
    /** 仮受金からの充当額（円） */
    private String ID_M_KariukeIppanJuto;
    /** 入金日（元号） */
    private String ID_Date_Nyukin_Gengo;
    /** 入金日（年） */
    private String ID_Date_Nyukin_Nen;
    /** 入金日（月） */
    private String ID_Date_NyukinTsuki;
    /** 入金日（日） */
    private String ID_Date_NyukinBi;
    /** 受託者勘定処理年月(元号) */
    private String ID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月(年) */
    private String ID_Date_Jtkshori_Nen;
    /** 受託者勘定処理年月(月) */
    private String ID_Date_JtkshoriTsuki;
    /** 送金日（元号） */
    private String ID_Date_Sokin_Gengo;
    /** 送金日（年） */
    private String ID_Date_Sokin_Nen;
    /** 送金日（月） */
    private String ID_Date_SokinTsuki;
    /** 送金日（日） */
    private String ID_Date_SokinBi;
    /** 送金日番号 */
    private String ID_ID_Sokinbi;
    /** 代弁履行後の作成 */
    private String ckhAfter_Daibensai;
    /** 取得時の控除利息 */
    private String ID_Save_M_KojoRisoku;
    /** 入金日 */
    private String ID_Date_Nyukin;
    /** 取得時の約定利息 */
    private String ID_Save_M_YakujoRisoku;
    /** 取得時の約定元金 */
    private String ID_Save_M_YakujoGankin;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 送金日 */
    private String ID_Date_Sokin;
    /** 貸付実行報告書作成済フラグ */
    private String ID_Flag_Kj;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** ユーザＩＤ */
    private String ID_UserID;
    /** 伝送番号 */
    private String ID_ID_Denso;
    /** データコード */
    private String ID_DataCode;
    /** 残高件数 */
    private String ID_Count_Zandaka;
    /** 履歴番号 */
    private String ID_ID_History;
    /** ステータス */
    private String ID_Status;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 取消済みフラグ */
    private String ID_Flag_Torikeshizumi;
    /** エラー番号 */
    private String ID_Code_Error;
    /** エラーメッセージ */
    private String ID_ErrorMessage;
    /** 退避貸付金残高 */
    private String ID_Keep_M_KashitsukeZan;
    /** 退避約定元金 */
    private String ID_Keep_M_YakujoGankin;
    /** 退避約定利息 */
    private String ID_Keep_M_YakujoRisoku;
    /** 退避償還期限 */
    private String ID_Keep_Date_ShokanKigen;
    /** 原本番号 */
    private String ID_ID_Master;
    /** 電子署名付データ */
    private String ID_SignData;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 顧客コード */
    private String ID_Code_Customer;
    /** 特利有効年月日 */
    private String ID_Date_TokuriYuko;
    /** 元金不均等額 */
    private String ID_M_GankinFukinto;
    /** 元金不均等額区分 */
    private String ID_Kubun_GankinFukintoGaku;
    /** 充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko;
    /** 請求データの任意繰償還利息 */
    private String ID_Seikyu_M_NinKuriRisoku;
    /** 請求データの請求繰償還利息 */
    private String ID_Seikyu_M_SeiKuriRisoku;
    /** 請求データの請求繰償還元金 */
    private String ID_Seikyu_M_SeiKuriGankin;
    /** 約定データの請求繰償還利息 */
    private String ID_Yakujo_M_SeiKuriRisoku;
    /** 最新データ更新日付 */
    private String ID_Data_LastUpDate;
    /** 行番号 */
    private String Index;
    /** 先行報告書有無 */
    private String ID_Previous_Report;
    /** 先行報告書略称名 */
    private String ID_RyakusyouName_Report;
    /** 元利金充当状態 */
    private String ID_No_Need_Payment;

    /** 控除利息計算値 */
    private String Cal_ID_M_KojoRisoku;
    /** 貸付受入金残高取得値 */
    private String Cal_ID_KashitsukeUkeireZan;
    /** 受託者勘定処理年月（元号）（隠し項目） */
    private String hdnID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月（月）（隠し項目） */
    private String hdnID_Date_JtkshoriTsuki;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr003_02M1DTO() {
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
    public Cr003_02M1DTO(Cr003_02M1DTO orig) {
        super(orig);
    }

    /**
     * 案件を取得します。
     * @return 案件
     */
    public String getID_Anken_Index() {
        return ID_Anken_Index;
    }

    /**
     * 案件を設定します。
     * @param ID_Anken_Index 案件
     */
    public void setID_Anken_Index(String ID_Anken_Index) {
        this.ID_Anken_Index = ID_Anken_Index;
    }

    /**
     * 報告書作成不許可メッセージを取得します。
     * @return 報告書作成不許可メッセージ
     */
    public String getID_Create_NG() {
        return ID_Create_NG;
    }

    /**
     * 報告書作成不許可メッセージを設定します。
     * @param ID_Create_NG 報告書作成不許可メッセージ
     */
    public void setID_Create_NG(String ID_Create_NG) {
        this.ID_Create_NG = ID_Create_NG;
    }

    /**
     * 選択を取得します。
     * @return 選択
     */
    public String getChkUpdate() {
        return chkUpdate;
    }

    /**
     * 選択を設定します。
     * @param chkUpdate 選択
     */
    public void setChkUpdate(String chkUpdate) {
        this.chkUpdate = chkUpdate;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getID_Name_Customer() {
        return ID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param ID_Name_Customer 顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        this.ID_Name_Customer = ID_Name_Customer;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getID_Name_Organization() {
        return ID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param ID_Name_Organization 扱店名
     */
    public void setID_Name_Organization(String ID_Name_Organization) {
        this.ID_Name_Organization = ID_Name_Organization;
    }

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getID_Code_ShokanHonShiten() {
        return ID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コードを設定します。
     * @param ID_Code_ShokanHonShiten 公庫支店コード
     */
    public void setID_Code_ShokanHonShiten(String ID_Code_ShokanHonShiten) {
        this.ID_Code_ShokanHonShiten = ID_Code_ShokanHonShiten;
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param ID_Code_Organization 扱店コード
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param ID_Code_Tenpo 店舗コード
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getID_Code_HoshikiShikin() {
        return ID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param ID_Code_HoshikiShikin 方式資金
     */
    public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
        this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Jikko 貸付実行日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 貸付実行金額を取得します。
     * @return 貸付実行金額
     */
    public String getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付実行金額を設定します。
     * @param ID_M_Kashitsuke 貸付実行金額
     */
    public void setID_M_Kashitsuke(String ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 資金使途コードを取得します。
     * @return 資金使途コード
     */
    public String getID_Code_ShikinShito() {
        return ID_Code_ShikinShito;
    }

    /**
     * 資金使途コードを設定します。
     * @param ID_Code_ShikinShito 資金使途コード
     */
    public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
        this.ID_Code_ShikinShito = ID_Code_ShikinShito;
    }

    /**
     * 事業別を取得します。
     * @return 事業別
     */
    public String getID_Code_Jigyobetsu() {
        return ID_Code_Jigyobetsu;
    }

    /**
     * 事業別を設定します。
     * @param ID_Code_Jigyobetsu 事業別
     */
    public void setID_Code_Jigyobetsu(String ID_Code_Jigyobetsu) {
        this.ID_Code_Jigyobetsu = ID_Code_Jigyobetsu;
    }

    /**
     * 利率（％）を取得します。
     * @return 利率（％）
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率（％）を設定します。
     * @param ID_Riritsu 利率（％）
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
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
     * 特利（％）を取得します。
     * @return 特利（％）
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利（％）を設定します。
     * @param ID_Tokuri 特利（％）
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 償還方法を設定します。
     * @param ID_Code_ShokanHouhou 償還方法
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen 据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen 償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利または元金均等額（円）を取得します。
     * @return 元利または元金均等額（円）
     */
    public String getID_M_Fukin() {
        return ID_M_Fukin;
    }

    /**
     * 元利または元金均等額（円）を設定します。
     * @param ID_M_Fukin 元利または元金均等額（円）
     */
    public void setID_M_Fukin(String ID_M_Fukin) {
        this.ID_M_Fukin = ID_M_Fukin;
    }

    /**
     * 払込前残元金（円）を取得します。
     * @return 払込前残元金（円）
     */
    public String getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 払込前残元金（円）を設定します。
     * @param ID_M_KashitsukeZandaka 払込前残元金（円）
     */
    public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
        this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
    }

    /**
     * 払込期日を取得します。
     * @return 払込期日
     */
    public String getID_Date_Haraikomi() {
        return ID_Date_Haraikomi;
    }

    /**
     * 払込期日を設定します。
     * @param ID_Date_Haraikomi 払込期日
     */
    public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
        this.ID_Date_Haraikomi = ID_Date_Haraikomi;
    }

    /**
     * 払込金額（円）を取得します。
     * @return 払込金額（円）
     */
    public String getID_M_Haraikomi() {
        return ID_M_Haraikomi;
    }

    /**
     * 払込金額（円）を設定します。
     * @param ID_M_Haraikomi 払込金額（円）
     */
    public void setID_M_Haraikomi(String ID_M_Haraikomi) {
        this.ID_M_Haraikomi = ID_M_Haraikomi;
    }

    /**
     * 控除利息（円）を取得します。
     * @return 控除利息（円）
     */
    public String getID_M_KojoRisoku() {
        return ID_M_KojoRisoku;
    }

    /**
     * 控除利息（円）を設定します。
     * @param ID_M_KojoRisoku 控除利息（円）
     */
    public void setID_M_KojoRisoku(String ID_M_KojoRisoku) {
        this.ID_M_KojoRisoku = ID_M_KojoRisoku;
    }

    /**
     * 差引払込金額（円）を取得します。
     * @return 差引払込金額（円）
     */
    public String getID_M_SashihikiHaraikomi() {
        return ID_M_SashihikiHaraikomi;
    }

    /**
     * 差引払込金額（円）を設定します。
     * @param ID_M_SashihikiHaraikomi 差引払込金額（円）
     */
    public void setID_M_SashihikiHaraikomi(String ID_M_SashihikiHaraikomi) {
        this.ID_M_SashihikiHaraikomi = ID_M_SashihikiHaraikomi;
    }

    /**
     * 払込後残元金（円）を取得します。
     * @return 払込後残元金（円）
     */
    public String getID_M_ZangankinAfterHaraikomi() {
        return ID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 払込後残元金（円）を設定します。
     * @param ID_M_ZangankinAfterHaraikomi 払込後残元金（円）
     */
    public void setID_M_ZangankinAfterHaraikomi(String ID_M_ZangankinAfterHaraikomi) {
        this.ID_M_ZangankinAfterHaraikomi = ID_M_ZangankinAfterHaraikomi;
    }

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public String getID_M_YakujoRisoku() {
        return ID_M_YakujoRisoku;
    }

    /**
     * 約定利息を設定します。
     * @param ID_M_YakujoRisoku 約定利息
     */
    public void setID_M_YakujoRisoku(String ID_M_YakujoRisoku) {
        this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public String getID_M_YakujoGankin() {
        return ID_M_YakujoGankin;
    }

    /**
     * 約定元金を設定します。
     * @param ID_M_YakujoGankin 約定元金
     */
    public void setID_M_YakujoGankin(String ID_M_YakujoGankin) {
        this.ID_M_YakujoGankin = ID_M_YakujoGankin;
    }

    /**
     * 遅延損害金（円）を取得します。
     * @return 遅延損害金（円）
     */
    public String getID_M_ChienSongai() {
        return ID_M_ChienSongai;
    }

    /**
     * 遅延損害金（円）を設定します。
     * @param ID_M_ChienSongai 遅延損害金（円）
     */
    public void setID_M_ChienSongai(String ID_M_ChienSongai) {
        this.ID_M_ChienSongai = ID_M_ChienSongai;
    }

    /**
     * 違約金（円）を取得します。
     * @return 違約金（円）
     */
    public String getID_M_Iyaku() {
        return ID_M_Iyaku;
    }

    /**
     * 違約金（円）を設定します。
     * @param ID_M_Iyaku 違約金（円）
     */
    public void setID_M_Iyaku(String ID_M_Iyaku) {
        this.ID_M_Iyaku = ID_M_Iyaku;
    }

    /**
     * 違約金（利子軽減分）（円）を取得します。
     * @return 違約金（利子軽減分）（円）
     */
    public String getID_M_IyakuRishikeigen() {
        return ID_M_IyakuRishikeigen;
    }

    /**
     * 違約金（利子軽減分）（円）を設定します。
     * @param ID_M_IyakuRishikeigen 違約金（利子軽減分）（円）
     */
    public void setID_M_IyakuRishikeigen(String ID_M_IyakuRishikeigen) {
        this.ID_M_IyakuRishikeigen = ID_M_IyakuRishikeigen;
    }

    /**
     * 仮受金からの充当額（円）を取得します。
     * @return 仮受金からの充当額（円）
     */
    public String getID_M_KariukeIppanJuto() {
        return ID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額（円）を設定します。
     * @param ID_M_KariukeIppanJuto 仮受金からの充当額（円）
     */
    public void setID_M_KariukeIppanJuto(String ID_M_KariukeIppanJuto) {
        this.ID_M_KariukeIppanJuto = ID_M_KariukeIppanJuto;
    }

    /**
     * 入金日（元号）を取得します。
     * @return 入金日（元号）
     */
    public String getID_Date_Nyukin_Gengo() {
        return ID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日（元号）を設定します。
     * @param ID_Date_Nyukin_Gengo 入金日（元号）
     */
    public void setID_Date_Nyukin_Gengo(String ID_Date_Nyukin_Gengo) {
        this.ID_Date_Nyukin_Gengo = ID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日（年）を取得します。
     * @return 入金日（年）
     */
    public String getID_Date_Nyukin_Nen() {
        return ID_Date_Nyukin_Nen;
    }

    /**
     * 入金日（年）を設定します。
     * @param ID_Date_Nyukin_Nen 入金日（年）
     */
    public void setID_Date_Nyukin_Nen(String ID_Date_Nyukin_Nen) {
        this.ID_Date_Nyukin_Nen = ID_Date_Nyukin_Nen;
    }

    /**
     * 入金日（月）を取得します。
     * @return 入金日（月）
     */
    public String getID_Date_NyukinTsuki() {
        return ID_Date_NyukinTsuki;
    }

    /**
     * 入金日（月）を設定します。
     * @param ID_Date_NyukinTsuki 入金日（月）
     */
    public void setID_Date_NyukinTsuki(String ID_Date_NyukinTsuki) {
        this.ID_Date_NyukinTsuki = ID_Date_NyukinTsuki;
    }

    /**
     * 入金日（日）を取得します。
     * @return 入金日（日）
     */
    public String getID_Date_NyukinBi() {
        return ID_Date_NyukinBi;
    }

    /**
     * 入金日（日）を設定します。
     * @param ID_Date_NyukinBi 入金日（日）
     */
    public void setID_Date_NyukinBi(String ID_Date_NyukinBi) {
        this.ID_Date_NyukinBi = ID_Date_NyukinBi;
    }

    /**
     * 受託者勘定処理年月(元号)を取得します。
     * @return 受託者勘定処理年月(元号)
     */
    public String getID_Date_Jtkshori_Gengo() {
        return ID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(元号)を設定します。
     * @param ID_Date_Jtkshori_Gengo 受託者勘定処理年月(元号)
     */
    public void setID_Date_Jtkshori_Gengo(String ID_Date_Jtkshori_Gengo) {
        this.ID_Date_Jtkshori_Gengo = ID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(年)を取得します。
     * @return 受託者勘定処理年月(年)
     */
    public String getID_Date_Jtkshori_Nen() {
        return ID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(年)を設定します。
     * @param ID_Date_Jtkshori_Nen 受託者勘定処理年月(年)
     */
    public void setID_Date_Jtkshori_Nen(String ID_Date_Jtkshori_Nen) {
        this.ID_Date_Jtkshori_Nen = ID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(月)を取得します。
     * @return 受託者勘定処理年月(月)
     */
    public String getID_Date_JtkshoriTsuki() {
        return ID_Date_JtkshoriTsuki;
    }

    /**
     * 受託者勘定処理年月(月)を設定します。
     * @param ID_Date_JtkshoriTsuki 受託者勘定処理年月(月)
     */
    public void setID_Date_JtkshoriTsuki(String ID_Date_JtkshoriTsuki) {
        this.ID_Date_JtkshoriTsuki = ID_Date_JtkshoriTsuki;
    }

    /**
     * 送金日（元号）を取得します。
     * @return 送金日（元号）
     */
    public String getID_Date_Sokin_Gengo() {
        return ID_Date_Sokin_Gengo;
    }

    /**
     * 送金日（元号）を設定します。
     * @param ID_Date_Sokin_Gengo 送金日（元号）
     */
    public void setID_Date_Sokin_Gengo(String ID_Date_Sokin_Gengo) {
        this.ID_Date_Sokin_Gengo = ID_Date_Sokin_Gengo;
    }

    /**
     * 送金日（年）を取得します。
     * @return 送金日（年）
     */
    public String getID_Date_Sokin_Nen() {
        return ID_Date_Sokin_Nen;
    }

    /**
     * 送金日（年）を設定します。
     * @param ID_Date_Sokin_Nen 送金日（年）
     */
    public void setID_Date_Sokin_Nen(String ID_Date_Sokin_Nen) {
        this.ID_Date_Sokin_Nen = ID_Date_Sokin_Nen;
    }

    /**
     * 送金日（月）を取得します。
     * @return 送金日（月）
     */
    public String getID_Date_SokinTsuki() {
        return ID_Date_SokinTsuki;
    }

    /**
     * 送金日（月）を設定します。
     * @param ID_Date_SokinTsuki 送金日（月）
     */
    public void setID_Date_SokinTsuki(String ID_Date_SokinTsuki) {
        this.ID_Date_SokinTsuki = ID_Date_SokinTsuki;
    }

    /**
     * 送金日（日）を取得します。
     * @return 送金日（日）
     */
    public String getID_Date_SokinBi() {
        return ID_Date_SokinBi;
    }

    /**
     * 送金日（日）を設定します。
     * @param ID_Date_SokinBi 送金日（日）
     */
    public void setID_Date_SokinBi(String ID_Date_SokinBi) {
        this.ID_Date_SokinBi = ID_Date_SokinBi;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getID_ID_Sokinbi() {
        return ID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param ID_ID_Sokinbi 送金日番号
     */
    public void setID_ID_Sokinbi(String ID_ID_Sokinbi) {
        this.ID_ID_Sokinbi = ID_ID_Sokinbi;
    }

    /**
     * 代弁履行後の作成を取得します。
     * @return 代弁履行後の作成
     */
    public String getCkhAfter_Daibensai() {
        return ckhAfter_Daibensai;
    }

    /**
     * 代弁履行後の作成を設定します。
     * @param ckhAfter_Daibensai 代弁履行後の作成
     */
    public void setCkhAfter_Daibensai(String ckhAfter_Daibensai) {
        this.ckhAfter_Daibensai = ckhAfter_Daibensai;
    }

    /**
     * 取得時の控除利息を取得します。
     * @return 取得時の控除利息
     */
    public String getID_Save_M_KojoRisoku() {
        return ID_Save_M_KojoRisoku;
    }

    /**
     * 取得時の控除利息を設定します。
     * @param ID_Save_M_KojoRisoku 取得時の控除利息
     */
    public void setID_Save_M_KojoRisoku(String ID_Save_M_KojoRisoku) {
        this.ID_Save_M_KojoRisoku = ID_Save_M_KojoRisoku;
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
     * 取得時の約定利息を取得します。
     * @return 取得時の約定利息
     */
    public String getID_Save_M_YakujoRisoku() {
        return ID_Save_M_YakujoRisoku;
    }

    /**
     * 取得時の約定利息を設定します。
     * @param ID_Save_M_YakujoRisoku 取得時の約定利息
     */
    public void setID_Save_M_YakujoRisoku(String ID_Save_M_YakujoRisoku) {
        this.ID_Save_M_YakujoRisoku = ID_Save_M_YakujoRisoku;
    }

    /**
     * 取得時の約定元金を取得します。
     * @return 取得時の約定元金
     */
    public String getID_Save_M_YakujoGankin() {
        return ID_Save_M_YakujoGankin;
    }

    /**
     * 取得時の約定元金を設定します。
     * @param ID_Save_M_YakujoGankin 取得時の約定元金
     */
    public void setID_Save_M_YakujoGankin(String ID_Save_M_YakujoGankin) {
        this.ID_Save_M_YakujoGankin = ID_Save_M_YakujoGankin;
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
     * 貸付実行報告書作成済フラグを取得します。
     * @return 貸付実行報告書作成済フラグ
     */
    public String getID_Flag_Kj() {
        return ID_Flag_Kj;
    }

    /**
     * 貸付実行報告書作成済フラグを設定します。
     * @param ID_Flag_Kj 貸付実行報告書作成済フラグ
     */
    public void setID_Flag_Kj(String ID_Flag_Kj) {
        this.ID_Flag_Kj = ID_Flag_Kj;
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
     * 残高件数を取得します。
     * @return 残高件数
     */
    public String getID_Count_Zandaka() {
        return ID_Count_Zandaka;
    }

    /**
     * 残高件数を設定します。
     * @param ID_Count_Zandaka 残高件数
     */
    public void setID_Count_Zandaka(String ID_Count_Zandaka) {
        this.ID_Count_Zandaka = ID_Count_Zandaka;
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
     * 取消済みフラグを取得します。
     * @return 取消済みフラグ
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済みフラグを設定します。
     * @param ID_Flag_Torikeshizumi 取消済みフラグ
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * エラー番号を取得します。
     * @return エラー番号
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラー番号を設定します。
     * @param ID_Code_Error エラー番号
     */
    public void setID_Code_Error(String ID_Code_Error) {
        this.ID_Code_Error = ID_Code_Error;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getID_ErrorMessage() {
        return ID_ErrorMessage;
    }

    /**
     * エラーメッセージを設定します。
     * @param ID_ErrorMessage エラーメッセージ
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        this.ID_ErrorMessage = ID_ErrorMessage;
    }

    /**
     * 退避貸付金残高を取得します。
     * @return 退避貸付金残高
     */
    public String getID_Keep_M_KashitsukeZan() {
        return ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避貸付金残高を設定します。
     * @param ID_Keep_M_KashitsukeZan 退避貸付金残高
     */
    public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
        this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public String getID_Keep_M_YakujoGankin() {
        return ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定元金を設定します。
     * @param ID_Keep_M_YakujoGankin 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
        this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku() {
        return ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避約定利息を設定します。
     * @param ID_Keep_M_YakujoRisoku 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
        this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避償還期限を取得します。
     * @return 退避償還期限
     */
    public String getID_Keep_Date_ShokanKigen() {
        return ID_Keep_Date_ShokanKigen;
    }

    /**
     * 退避償還期限を設定します。
     * @param ID_Keep_Date_ShokanKigen 退避償還期限
     */
    public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
        this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
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
     * 電子署名付データを取得します。
     * @return 電子署名付データ
     */
    public String getID_SignData() {
        return ID_SignData;
    }

    /**
     * 電子署名付データを設定します。
     * @param ID_SignData 電子署名付データ
     */
    public void setID_SignData(String ID_SignData) {
        this.ID_SignData = ID_SignData;
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
     * 顧客コードを取得します。
     * @return 顧客コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 顧客コードを設定します。
     * @param ID_Code_Customer 顧客コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
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
    public String getID_Kubun_GankinFukintoGaku() {
        return ID_Kubun_GankinFukintoGaku;
    }

    /**
     * 元金不均等額区分を設定します。
     * @param ID_Kubun_GankinFukintoGaku 元金不均等額区分
     */
    public void setID_Kubun_GankinFukintoGaku(String ID_Kubun_GankinFukintoGaku) {
        this.ID_Kubun_GankinFukintoGaku = ID_Kubun_GankinFukintoGaku;
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
     * 請求データの任意繰償還利息を取得します。
     * @return 請求データの任意繰償還利息
     */
    public String getID_Seikyu_M_NinKuriRisoku() {
        return ID_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの任意繰償還利息を設定します。
     * @param ID_Seikyu_M_NinKuriRisoku 請求データの任意繰償還利息
     */
    public void setID_Seikyu_M_NinKuriRisoku(String ID_Seikyu_M_NinKuriRisoku) {
        this.ID_Seikyu_M_NinKuriRisoku = ID_Seikyu_M_NinKuriRisoku;
    }

    /**
     * 請求データの請求繰償還利息を取得します。
     * @return 請求データの請求繰償還利息
     */
    public String getID_Seikyu_M_SeiKuriRisoku() {
        return ID_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの請求繰償還利息を設定します。
     * @param ID_Seikyu_M_SeiKuriRisoku 請求データの請求繰償還利息
     */
    public void setID_Seikyu_M_SeiKuriRisoku(String ID_Seikyu_M_SeiKuriRisoku) {
        this.ID_Seikyu_M_SeiKuriRisoku = ID_Seikyu_M_SeiKuriRisoku;
    }

    /**
     * 請求データの請求繰償還元金を取得します。
     * @return 請求データの請求繰償還元金
     */
    public String getID_Seikyu_M_SeiKuriGankin() {
        return ID_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 請求データの請求繰償還元金を設定します。
     * @param ID_Seikyu_M_SeiKuriGankin 請求データの請求繰償還元金
     */
    public void setID_Seikyu_M_SeiKuriGankin(String ID_Seikyu_M_SeiKuriGankin) {
        this.ID_Seikyu_M_SeiKuriGankin = ID_Seikyu_M_SeiKuriGankin;
    }

    /**
     * 約定データの請求繰償還利息を取得します。
     * @return 約定データの請求繰償還利息
     */
    public String getID_Yakujo_M_SeiKuriRisoku() {
        return ID_Yakujo_M_SeiKuriRisoku;
    }

    /**
     * 約定データの請求繰償還利息を設定します。
     * @param ID_Yakujo_M_SeiKuriRisoku 約定データの請求繰償還利息
     */
    public void setID_Yakujo_M_SeiKuriRisoku(String ID_Yakujo_M_SeiKuriRisoku) {
        this.ID_Yakujo_M_SeiKuriRisoku = ID_Yakujo_M_SeiKuriRisoku;
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
     * 行番号を取得します。
     * @return 行番号
     */
    public String getIndex() {
        return Index;
    }

    /**
     * 行番号を設定します。
     * @param Index 行番号
     */
    public void setIndex(String Index) {
        this.Index = Index;
    }

    /**
     * 先行報告書有無を取得します。
     * @return 先行報告書有無
     */
    public String getID_Previous_Report() {
        return ID_Previous_Report;
    }

    /**
     * 先行報告書有無を設定します。
     * @param ID_Previous_Report 先行報告書有無
     */
    public void setID_Previous_Report(String ID_Previous_Report) {
        this.ID_Previous_Report = ID_Previous_Report;
    }

    /**
     * 先行報告書略称名を取得します。
     * @return 先行報告書略称名
     */
    public String getID_RyakusyouName_Report() {
        return ID_RyakusyouName_Report;
    }

    /**
     * 先行報告書略称名を設定します。
     * @param ID_RyakusyouName_Report 先行報告書略称名
     */
    public void setID_RyakusyouName_Report(String ID_RyakusyouName_Report) {
        this.ID_RyakusyouName_Report = ID_RyakusyouName_Report;
    }

    /**
     * 元利金充当状態を取得します。
     * @return 元利金充当状態
     */
    public String getID_No_Need_Payment() {
        return ID_No_Need_Payment;
    }

    /**
     * 元利金充当状態を設定します。
     * @param ID_No_Need_Payment 元利金充当状態
     */
    public void setID_No_Need_Payment(String ID_No_Need_Payment) {
        this.ID_No_Need_Payment = ID_No_Need_Payment;
    }

    /**
     * <pre>
     * 控除利息計算値を取得します。
     * </pre>
     *
     * @return cal_ID_M_KojoRisoku
     */
    public String getCal_ID_M_KojoRisoku() {
        return Cal_ID_M_KojoRisoku;
    }

    /**
     * <pre>
     * 控除利息計算値を設定します。
     * </pre>
     *
     * @param cal_ID_M_KojoRisoku cal_ID_M_KojoRisoku
     */
    public void setCal_ID_M_KojoRisoku(String cal_ID_M_KojoRisoku) {
        Cal_ID_M_KojoRisoku = cal_ID_M_KojoRisoku;
    }

    /**
     * <pre>
     * 貸付受入金残高取得値を取得します。
     * </pre>
     *
     * @return cal_ID_KashitsukeUkeireZan
     */
    public String getCal_ID_KashitsukeUkeireZan() {
        return Cal_ID_KashitsukeUkeireZan;
    }

    /**
     * <pre>
     * 貸付受入金残高取得値を設定します。
     * </pre>
     *
     * @param cal_ID_KashitsukeUkeireZan cal_ID_KashitsukeUkeireZan
     */
    public void setCal_ID_KashitsukeUkeireZan(String cal_ID_KashitsukeUkeireZan) {
        Cal_ID_KashitsukeUkeireZan = cal_ID_KashitsukeUkeireZan;
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
    public String getHdnID_Date_JtkshoriTsuki() {
        return hdnID_Date_JtkshoriTsuki;
    }

    /**
     * 受託者勘定処理年月（月）（隠し項目）を設定します。
     *
     * @param hdnID_Date_JtkshoriTsuki
     *            受託者勘定処理年月（月）（隠し項目）
     */
    public void setHdnID_Date_JtkshoriTsuki(
            String hdnID_Date_JtkshoriTsuki) {
        this.hdnID_Date_JtkshoriTsuki = hdnID_Date_JtkshoriTsuki;
        this.ID_Date_JtkshoriTsuki = hdnID_Date_JtkshoriTsuki;
    }
}