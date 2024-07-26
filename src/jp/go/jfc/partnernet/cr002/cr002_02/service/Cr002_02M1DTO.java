//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

import org.springframework.format.annotation.NumberFormat;

/**
 * <pre>
 * このクラスはcr002_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr002_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 案件番号 */
    private String lblIndex;
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
    private String ID_Code_HoshikiShikin;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 資金使途 */
    private String ID_Code_ShikinShito;
    /** 事業別 */
    private String ID_Code_Jigyobetsu;
    /** 利率（％） */
    private java.math.BigDecimal ID_Riritsu;
    /** 特利区分 */
    private String ID_Kubun_Tokuri;
    /** 特利（％） */
    private java.math.BigDecimal ID_Tokuri;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 貸付実行日 */
    private String ID_Date_Jikko;
    /** 貸付実行金額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Kashitsuke;
    /** 資金交付額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_SikinKofu;
    /** 貸付受入金受入額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KashitukeUkeire;
    /** 貸付受入金残高 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KashitsukeUkeireZan;
    /** 受託者勘定処理年月 */
    private String ID_Date_Jtkshori;
    /** 払出元金充当日 */
    private String ID_Date_HaraidashiJuto;
    /** 資金払出額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Haraidashi;
    /** 元金充当額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_Ganju;
    /** 元金充当後貸付金残高 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KashitsukeZandakaAfterGanju;
    /** 元金充当後第１回約定日 */
    private String ID_Date_FirstYakujoAfterGanju;
    /** 繰償事由コード */
    private String ID_Code_KurishoJiyu;
    /** 元金充当後の元金均等額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_GankinKintoAfterGanju;
    /** 元金充当後の元金不均等額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_GankinFukintoAfterGanju;
    /** 調整コード */
    private String ID_Code_Chosei_Candidate;
    /** 報告書番号 */
    private String ID_ID_Report;
    /** 履歴番号 */
    private String ID_ID_History;
    /** 原本番号 */
    private String ID_ID_Master;
    /** 報告時分秒 */
    private String ID_Time_Report;
    /** ユーザID */
    private String ID_UserID;
    /** 伝送番号 */
    private String ID_ID_Denso;
    /** データコード */
    private String ID_DataCode;
    /** ステータス */
    private String ID_Status;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi;
    /** エラーコード */
    private String ID_Code_Error;
    /** エラーメッセージ */
    private String ID_ErrorMessage;
    /** 署名データファイル名 */
    private String ID_SignData;
    /** 債権管理番号 */
    private java.math.BigDecimal ID_ID_Credit;
    /** 最新変更日 */
    private String ID_Date_SaishinHenko;
    /** 合計 */
    private String ID_M_Kei;
    /** 退避賦金 */
    private java.math.BigDecimal ID_Keep_M_Fukin;
    /** 退避元金不均等額 */
    private java.math.BigDecimal ID_Keep_M_GankinFukinto;
    /** 退避元金不均等額区分 */
    private String ID_Keep_Kubun_GankinFukinto;
    /** 退避貸付金残高 */
    private java.math.BigDecimal ID_Keep_M_KashitsukeZan;
    /** 退避償還期限年月 */
    private String ID_Keep_Date_ShokanKigen;
    /** 稟議・賦金 */
    private java.math.BigDecimal ID_M_Fukin;
    /** 稟議・元金不均等額 */
    private java.math.BigDecimal ID_M_GankinFukinto;
    /** 稟議・元金不均等額区分 */
    private String ID_Kubun_GankinFukintogaku;
    /** 稟議・貸付金残高 */
    private java.math.BigDecimal ID_M_KashitsukeZandaka;
    /** 稟議・償還方法コード */
    private String ID_Code_ShokanHouhou;
    /** 稟議・特利有効期限 */
    private String ID_Date_TokuriYuko;
    /** ステータス値の保存 */
    private String ID_Preserve_Status;
    /** 退避・条変起案中区分 */
    private String ID_Keep_JohenKianchu;
    /** 最新データ更新日付 */
    private String ID_Data_LastUpDate;
    /** 顧客コード */
    private String ID_Code_Customer;
    /** 電子署名結果 */
    private String ID_Result_SignedData;
    /** 退避約定元金 */
    private java.math.BigDecimal ID_Keep_M_YakujoGankin;
    /** 退避約定利息 */
    private java.math.BigDecimal ID_Keep_M_YakujoRisoku;
    /** 更新フラグ */
    private boolean UpdateFlg;
    /** 新規追加行かどうかをあらわすフラグ */
    private boolean NewLineFlg;
    /** 更新状態 */
    private String DataUpFlg;
    /** 稟議・条変起案中区分 */
    private String ID_Kubun_JohenKianchu;
    /** 前回払出・更生処理区分 */
    private String ID_HDLas_Kubun_KoseiShori;
    /** 前回払出・払出累計額 */
    private java.math.BigDecimal ID_HDLas_M_HaraidashiRuikei;
    /** 前回払出・繰上償還額 */
    private java.math.BigDecimal ID_HDLas_M_Kurisho;
    /** 前回払出・繰上償還累計額 */
    private java.math.BigDecimal ID_HDLas_M_KurishoRuikei;
    /** 前回払出・払出充当年月日 */
    private String ID_HDLas_Date_HaraidashiJuto;
    /** 前回払出・貸付受入金残高 */
    private java.math.BigDecimal ID_HDLas_M_HaraidashiKashitsukeZan;
    /** 前回払出・払出額有無フラグ（true=有） */
    private boolean ID_HDLas_M_HaraidashiFlag;
    /** 前回払出・繰上償還額有無フラグ（true=有） */
    private boolean ID_HDLas_M_KurishoFlag;
    /** 更新用払出・更生処理区分 */
    private String ID_HDNew_Kubun_KoseiShori;
    /** 更新用払出・計数管理処理番号 */
    private String ID_HDNew_KeisuKanriShori;
    /** 更新用払出・払出額 */
    private java.math.BigDecimal ID_HDNew_M_Haraidashi;
    /** 更新用払出・払出累計額 */
    private java.math.BigDecimal ID_HDNew_M_HaraidashiRuikei;
    /** 更新用払出・繰上償還額 */
    private java.math.BigDecimal ID_HDNew_M_Kurisho;
    /** 更新用払出・繰上償還累計額 */
    private java.math.BigDecimal ID_HDNew_M_KurishoRuikei;
    /** 更新用払出・貸付受入金残高積数 */
    private java.math.BigDecimal ID_HDNew_M_ZandakaSekisu;
    /** 更新用払出・払出充当年月日 */
    private String ID_HDNew_Date_HaraidashiJuto;
    /** 更新用払出・貸付受入金残高 */
    private java.math.BigDecimal ID_HDNew_M_HaraidashiKashitsukeZan;
    /** 請求・約定元金 */
    private java.math.BigDecimal ID_M_YakujoGankin;
    /** 請求・約定利息 */
    private java.math.BigDecimal ID_M_YakujoRisoku;
    /** 請求・払込年月日 */
    private String ID_Date_Haraikomi;
    /** 請求データの各レコードを更新する場合のフラグ */
    private boolean flgSeikyuUp_Record;
    /** 請求・更新する払込年月日の保存 */
    private String ID_UP_Seikyu_Haraikomi;
    /** 約定・約定前残高 */
    private java.math.BigDecimal ID_M_ZandakaBeforeYakujo;
    /** 積数起算年月日 */
    private String ID_Date_SekisuKisanbi;
    /** 償還方法タイプ識別値 */
    private String Type_Shokan;
    /** 更新用賦金 */
    private java.math.BigDecimal ID_Up_M_Fukin;
    /** 更新用調整コード */
    private String ID_Up_Code_Chosei;
    /** 更新用元金均等額（元利均等償還の場合使用） */
    private java.math.BigDecimal ID_Up_M_GankinKinto;
    /** 更新用元金不均等額 */
    private java.math.BigDecimal ID_Up_M_GankinFukinto;
    /** 更新用約定元金（元利均等償還の場合使用） */
    private java.math.BigDecimal ID_Up_M_YakujoGankin;
    /** 更新用約定利息 */
    private java.math.BigDecimal ID_Up_M_YakujoRisoku;
    /** 賦金計算用・約定・約定元金 */
    private java.math.BigDecimal ID_M_YakujoGankin_Yakujo_Fukin;
    /** 賦金計算用・約定・約定利息 */
    private java.math.BigDecimal ID_M_YakujoRisoku_Yakujo_Fukin;
    /** 賦金計算用・約定・払込期日 */
    private String ID_Date_Haraikomi_Yakujo_Fukin;
    /** 賦金計算用・約定・請求繰上利息 */
    private java.math.BigDecimal ID_M_SeikuriRisoku_Yakujo_Fukin;
    /** 行番号 */
    private String Index;
    // /** 受託者勘定処理年月 */
    // private String ID_Date_Jtkshori;
    // /** 払出元金充当日 */
    // private String ID_Date_HaraidashiJuto;
    /** 繰上償還事由コード(DB取得時) */
    private String ID_Code_KurishoJiyu_Save;
    /** 調整コード(DB取得時) */
    private String ID_Code_Chosei;
    /** 報告年月日 */
    private String ID_Date_Report;
    /** 受託者勘定処理年月エラー */
    private boolean Error_Date_Jtkshori;
    /** 払出元金充当日エラー */
    private boolean Error_Date_HaraidashiJuto;
    /** 資金払出額エラー */
    private boolean Error_M_Haraidashi;
    /** 元金充当額エラー */
    private boolean Error_M_Ganju;
    /** 元金充当後元金均等額エラー */
    private boolean Error_M_GankinKintoAfterGanju;
    /** 元金充当後元金不均等額エラー */
    private boolean Error_M_GankinFukintoAfterGanju;
    /** 繰上償還事由コードエラー */
    private boolean Error_Code_KurishoJiyu;
    /** 調整コードエラー */
    private boolean Error_Code_Chosei;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr002_02M1DTO() {
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
    public Cr002_02M1DTO(Cr002_02M1DTO orig) {
        super(orig);
    }

    /**
     * 案件番号を取得します。
     * @return 案件番号
     */
    public String getLblIndex() {
        return lblIndex;
    }

    /**
     * 案件番号を設定します。
     * @param lblIndex 案件番号
     */
    public void setLblIndex(String lblIndex) {
        this.lblIndex = lblIndex;
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
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getID_Code_ShokanHonShiten() {
        return ID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param ID_Code_ShokanHonShiten 公庫支店
     */
    public void setID_Code_ShokanHonShiten(String ID_Code_ShokanHonShiten) {
        this.ID_Code_ShokanHonShiten = ID_Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param ID_Code_Tenpo 店舗
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
     * 資金使途を取得します。
     * @return 資金使途
     */
    public String getID_Code_ShikinShito() {
        return ID_Code_ShikinShito;
    }

    /**
     * 資金使途を設定します。
     * @param ID_Code_ShikinShito 資金使途
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
    public java.math.BigDecimal getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率（％）を設定します。
     * @param ID_Riritsu 利率（％）
     */
    public void setID_Riritsu(java.math.BigDecimal ID_Riritsu) {
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
    public java.math.BigDecimal getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利（％）を設定します。
     * @param ID_Tokuri 特利（％）
     */
    public void setID_Tokuri(java.math.BigDecimal ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
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
    public java.math.BigDecimal getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付実行金額を設定します。
     * @param ID_M_Kashitsuke 貸付実行金額
     */
    public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 資金交付額を取得します。
     * @return 資金交付額
     */
    public java.math.BigDecimal getID_M_SikinKofu() {
        return ID_M_SikinKofu;
    }

    /**
     * 資金交付額を設定します。
     * @param ID_M_SikinKofu 資金交付額
     */
    public void setID_M_SikinKofu(java.math.BigDecimal ID_M_SikinKofu) {
        this.ID_M_SikinKofu = ID_M_SikinKofu;
    }

    /**
     * 貸付受入金受入額を取得します。
     * @return 貸付受入金受入額
     */
    public java.math.BigDecimal getID_M_KashitukeUkeire() {
        return ID_M_KashitukeUkeire;
    }

    /**
     * 貸付受入金受入額を設定します。
     * @param ID_M_KashitukeUkeire 貸付受入金受入額
     */
    public void setID_M_KashitukeUkeire(java.math.BigDecimal ID_M_KashitukeUkeire) {
        this.ID_M_KashitukeUkeire = ID_M_KashitukeUkeire;
    }

    /**
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public java.math.BigDecimal getID_M_KashitsukeUkeireZan() {
        return ID_M_KashitsukeUkeireZan;
    }

    /**
     * 貸付受入金残高を設定します。
     * @param ID_M_KashitsukeUkeireZan 貸付受入金残高
     */
    public void setID_M_KashitsukeUkeireZan(java.math.BigDecimal ID_M_KashitsukeUkeireZan) {
        this.ID_M_KashitsukeUkeireZan = ID_M_KashitsukeUkeireZan;
    }

    // /**
    // * 受託者勘定処理年月を取得します。
    // * @return 受託者勘定処理年月
    // */
    // public String getID_Date_Jtkshori() {
    // return ID_Date_Jtkshori;
    // }
    //
    // /**
    // * 受託者勘定処理年月を設定します。
    // * @param ID_Date_Jtkshori 受託者勘定処理年月
    // */
    // public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
    // this.ID_Date_Jtkshori = ID_Date_Jtkshori;
    // }
    // /**
    // * 払出元金充当日を取得します。
    // * @return 払出元金充当日
    // */
    // public String getID_Date_HaraidashiJuto() {
    // return ID_Date_HaraidashiJuto;
    // }
    //
    // /**
    // * 払出元金充当日を設定します。
    // * @param ID_Date_HaraidashiJuto 払出元金充当日
    // */
    // public void setID_Date_HaraidashiJuto(String ID_Date_HaraidashiJuto) {
    // this.ID_Date_HaraidashiJuto = ID_Date_HaraidashiJuto;
    // }
    /**
     * 資金払出額を取得します。
     * @return 資金払出額
     */
    public java.math.BigDecimal getID_M_Haraidashi() {
        return ID_M_Haraidashi;
    }

    /**
     * 資金払出額を設定します。
     * @param ID_M_Haraidashi 資金払出額
     */
    public void setID_M_Haraidashi(java.math.BigDecimal ID_M_Haraidashi) {
        this.ID_M_Haraidashi = ID_M_Haraidashi;
    }

    /**
     * 元金充当額を取得します。
     * @return 元金充当額
     */
    public java.math.BigDecimal getID_M_Ganju() {
        return ID_M_Ganju;
    }

    /**
     * 元金充当額を設定します。
     * @param ID_M_Ganju 元金充当額
     */
    public void setID_M_Ganju(java.math.BigDecimal ID_M_Ganju) {
        this.ID_M_Ganju = ID_M_Ganju;
    }

    /**
     * 元金充当後貸付金残高を取得します。
     * @return 元金充当後貸付金残高
     */
    public java.math.BigDecimal getID_M_KashitsukeZandakaAfterGanju() {
        return ID_M_KashitsukeZandakaAfterGanju;
    }

    /**
     * 元金充当後貸付金残高を設定します。
     * @param ID_M_KashitsukeZandakaAfterGanju 元金充当後貸付金残高
     */
    public void setID_M_KashitsukeZandakaAfterGanju(java.math.BigDecimal ID_M_KashitsukeZandakaAfterGanju) {
        this.ID_M_KashitsukeZandakaAfterGanju = ID_M_KashitsukeZandakaAfterGanju;
    }

    /**
     * 元金充当後第１回約定日を取得します。
     * @return 元金充当後第１回約定日
     */
    public String getID_Date_FirstYakujoAfterGanju() {
        return ID_Date_FirstYakujoAfterGanju;
    }

    /**
     * 元金充当後第１回約定日を設定します。
     * @param ID_Date_FirstYakujoAfterGanju 元金充当後第１回約定日
     */
    public void setID_Date_FirstYakujoAfterGanju(String ID_Date_FirstYakujoAfterGanju) {
        this.ID_Date_FirstYakujoAfterGanju = ID_Date_FirstYakujoAfterGanju;
    }

    /**
     * 繰償事由コードを取得します。
     * @return 繰償事由コード
     */
    public String getID_Code_KurishoJiyu() {
        return ID_Code_KurishoJiyu;
    }

    /**
     * 繰償事由コードを設定します。
     * @param ID_Code_KurishoJiyu 繰償事由コード
     */
    public void setID_Code_KurishoJiyu(String ID_Code_KurishoJiyu) {
        this.ID_Code_KurishoJiyu = ID_Code_KurishoJiyu;
    }

    /**
     * 元金充当後の元金均等額を取得します。
     * @return 元金充当後の元金均等額
     */
    public java.math.BigDecimal getID_M_GankinKintoAfterGanju() {
        return ID_M_GankinKintoAfterGanju;
    }

    /**
     * 元金充当後の元金均等額を設定します。
     * @param ID_M_GankinKintoAfterGanju 元金充当後の元金均等額
     */
    public void setID_M_GankinKintoAfterGanju(java.math.BigDecimal ID_M_GankinKintoAfterGanju) {
        this.ID_M_GankinKintoAfterGanju = ID_M_GankinKintoAfterGanju;
    }

    /**
     * 元金充当後の元金不均等額を取得します。
     * @return 元金充当後の元金不均等額
     */
    public java.math.BigDecimal getID_M_GankinFukintoAfterGanju() {
        return ID_M_GankinFukintoAfterGanju;
    }

    /**
     * 元金充当後の元金不均等額を設定します。
     * @param ID_M_GankinFukintoAfterGanju 元金充当後の元金不均等額
     */
    public void setID_M_GankinFukintoAfterGanju(java.math.BigDecimal ID_M_GankinFukintoAfterGanju) {
        this.ID_M_GankinFukintoAfterGanju = ID_M_GankinFukintoAfterGanju;
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getID_Code_Chosei_Candidate() {
        return ID_Code_Chosei_Candidate;
    }

    /**
     * 調整コードを設定します。
     * @param ID_Code_Chosei_Candidate 調整コード
     */
    public void setID_Code_Chosei_Candidate(String ID_Code_Chosei_Candidate) {
        this.ID_Code_Chosei_Candidate = ID_Code_Chosei_Candidate;
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
     * エラーコードを取得します。
     * @return エラーコード
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラーコードを設定します。
     * @param ID_Code_Error エラーコード
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
     * 署名データファイル名を取得します。
     * @return 署名データファイル名
     */
    public String getID_SignData() {
        return ID_SignData;
    }

    /**
     * 署名データファイル名を設定します。
     * @param ID_SignData 署名データファイル名
     */
    public void setID_SignData(String ID_SignData) {
        this.ID_SignData = ID_SignData;
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(java.math.BigDecimal ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 最新変更日を取得します。
     * @return 最新変更日
     */
    public String getID_Date_SaishinHenko() {
        return ID_Date_SaishinHenko;
    }

    /**
     * 最新変更日を設定します。
     * @param ID_Date_SaishinHenko 最新変更日
     */
    public void setID_Date_SaishinHenko(String ID_Date_SaishinHenko) {
        this.ID_Date_SaishinHenko = ID_Date_SaishinHenko;
    }

    /**
     * 合計を取得します。
     * @return 合計
     */
    public String getID_M_Kei() {
        return ID_M_Kei;
    }

    /**
     * 合計を設定します。
     * @param ID_M_Kei 合計
     */
    public void setID_M_Kei(String ID_M_Kei) {
        this.ID_M_Kei = ID_M_Kei;
    }

    /**
     * 退避賦金を取得します。
     * @return 退避賦金
     */
    public java.math.BigDecimal getID_Keep_M_Fukin() {
        return ID_Keep_M_Fukin;
    }

    /**
     * 退避賦金を設定します。
     * @param ID_Keep_M_Fukin 退避賦金
     */
    public void setID_Keep_M_Fukin(java.math.BigDecimal ID_Keep_M_Fukin) {
        this.ID_Keep_M_Fukin = ID_Keep_M_Fukin;
    }

    /**
     * 退避元金不均等額を取得します。
     * @return 退避元金不均等額
     */
    public java.math.BigDecimal getID_Keep_M_GankinFukinto() {
        return ID_Keep_M_GankinFukinto;
    }

    /**
     * 退避元金不均等額を設定します。
     * @param ID_Keep_M_GankinFukinto 退避元金不均等額
     */
    public void setID_Keep_M_GankinFukinto(java.math.BigDecimal ID_Keep_M_GankinFukinto) {
        this.ID_Keep_M_GankinFukinto = ID_Keep_M_GankinFukinto;
    }

    /**
     * 退避元金不均等額区分を取得します。
     * @return 退避元金不均等額区分
     */
    public String getID_Keep_Kubun_GankinFukinto() {
        return ID_Keep_Kubun_GankinFukinto;
    }

    /**
     * 退避元金不均等額区分を設定します。
     * @param ID_Keep_Kubun_GankinFukinto 退避元金不均等額区分
     */
    public void setID_Keep_Kubun_GankinFukinto(String ID_Keep_Kubun_GankinFukinto) {
        this.ID_Keep_Kubun_GankinFukinto = ID_Keep_Kubun_GankinFukinto;
    }

    /**
     * 退避貸付金残高を取得します。
     * @return 退避貸付金残高
     */
    public java.math.BigDecimal getID_Keep_M_KashitsukeZan() {
        return ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避貸付金残高を設定します。
     * @param ID_Keep_M_KashitsukeZan 退避貸付金残高
     */
    public void setID_Keep_M_KashitsukeZan(java.math.BigDecimal ID_Keep_M_KashitsukeZan) {
        this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避償還期限年月を取得します。
     * @return 退避償還期限年月
     */
    public String getID_Keep_Date_ShokanKigen() {
        return ID_Keep_Date_ShokanKigen;
    }

    /**
     * 退避償還期限年月を設定します。
     * @param ID_Keep_Date_ShokanKigen 退避償還期限年月
     */
    public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
        this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
    }

    /**
     * 稟議・賦金を取得します。
     * @return 稟議・賦金
     */
    public java.math.BigDecimal getID_M_Fukin() {
        return ID_M_Fukin;
    }

    /**
     * 稟議・賦金を設定します。
     * @param ID_M_Fukin 稟議・賦金
     */
    public void setID_M_Fukin(java.math.BigDecimal ID_M_Fukin) {
        this.ID_M_Fukin = ID_M_Fukin;
    }

    /**
     * 稟議・元金不均等額を取得します。
     * @return 稟議・元金不均等額
     */
    public java.math.BigDecimal getID_M_GankinFukinto() {
        return ID_M_GankinFukinto;
    }

    /**
     * 稟議・元金不均等額を設定します。
     * @param ID_M_GankinFukinto 稟議・元金不均等額
     */
    public void setID_M_GankinFukinto(java.math.BigDecimal ID_M_GankinFukinto) {
        this.ID_M_GankinFukinto = ID_M_GankinFukinto;
    }

    /**
     * 稟議・元金不均等額区分を取得します。
     * @return 稟議・元金不均等額区分
     */
    public String getID_Kubun_GankinFukintogaku() {
        return ID_Kubun_GankinFukintogaku;
    }

    /**
     * 稟議・元金不均等額区分を設定します。
     * @param ID_Kubun_GankinFukintogaku 稟議・元金不均等額区分
     */
    public void setID_Kubun_GankinFukintogaku(String ID_Kubun_GankinFukintogaku) {
        this.ID_Kubun_GankinFukintogaku = ID_Kubun_GankinFukintogaku;
    }

    /**
     * 稟議・貸付金残高を取得します。
     * @return 稟議・貸付金残高
     */
    public java.math.BigDecimal getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 稟議・貸付金残高を設定します。
     * @param ID_M_KashitsukeZandaka 稟議・貸付金残高
     */
    public void setID_M_KashitsukeZandaka(java.math.BigDecimal ID_M_KashitsukeZandaka) {
        this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
    }

    /**
     * 稟議・償還方法コードを取得します。
     * @return 稟議・償還方法コード
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 稟議・償還方法コードを設定します。
     * @param ID_Code_ShokanHouhou 稟議・償還方法コード
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 稟議・特利有効期限を取得します。
     * @return 稟議・特利有効期限
     */
    public String getID_Date_TokuriYuko() {
        return ID_Date_TokuriYuko;
    }

    /**
     * 稟議・特利有効期限を設定します。
     * @param ID_Date_TokuriYuko 稟議・特利有効期限
     */
    public void setID_Date_TokuriYuko(String ID_Date_TokuriYuko) {
        this.ID_Date_TokuriYuko = ID_Date_TokuriYuko;
    }

    /**
     * ステータス値の保存を取得します。
     * @return ステータス値の保存
     */
    public String getID_Preserve_Status() {
        return ID_Preserve_Status;
    }

    /**
     * ステータス値の保存を設定します。
     * @param ID_Preserve_Status ステータス値の保存
     */
    public void setID_Preserve_Status(String ID_Preserve_Status) {
        this.ID_Preserve_Status = ID_Preserve_Status;
    }

    /**
     * 退避・条変起案中区分を取得します。
     * @return 退避・条変起案中区分
     */
    public String getID_Keep_JohenKianchu() {
        return ID_Keep_JohenKianchu;
    }

    /**
     * 退避・条変起案中区分を設定します。
     * @param ID_Keep_JohenKianchu 退避・条変起案中区分
     */
    public void setID_Keep_JohenKianchu(String ID_Keep_JohenKianchu) {
        this.ID_Keep_JohenKianchu = ID_Keep_JohenKianchu;
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
     * 電子署名結果を取得します。
     * @return 電子署名結果
     */
    public String getID_Result_SignedData() {
        return ID_Result_SignedData;
    }

    /**
     * 電子署名結果を設定します。
     * @param ID_Result_SignedData 電子署名結果
     */
    public void setID_Result_SignedData(String ID_Result_SignedData) {
        this.ID_Result_SignedData = ID_Result_SignedData;
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public java.math.BigDecimal getID_Keep_M_YakujoGankin() {
        return ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定元金を設定します。
     * @param ID_Keep_M_YakujoGankin 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin(java.math.BigDecimal ID_Keep_M_YakujoGankin) {
        this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public java.math.BigDecimal getID_Keep_M_YakujoRisoku() {
        return ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避約定利息を設定します。
     * @param ID_Keep_M_YakujoRisoku 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku(java.math.BigDecimal ID_Keep_M_YakujoRisoku) {
        this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
    }

    /**
     * 更新フラグを取得します。
     * @return 更新フラグ
     */
    public boolean getUpdateFlg() {
        return UpdateFlg;
    }

    /**
     * 更新フラグを設定します。
     * @param UpdateFlg 更新フラグ
     */
    public void setUpdateFlg(boolean UpdateFlg) {
        this.UpdateFlg = UpdateFlg;
    }

    /**
     * 新規追加行かどうかをあらわすフラグを取得します。
     * @return 新規追加行かどうかをあらわすフラグ
     */
    public boolean getNewLineFlg() {
        return NewLineFlg;
    }

    /**
     * 新規追加行かどうかをあらわすフラグを設定します。
     * @param NewLineFlg 新規追加行かどうかをあらわすフラグ
     */
    public void setNewLineFlg(boolean NewLineFlg) {
        this.NewLineFlg = NewLineFlg;
    }

    /**
     * 更新状態を取得します。
     * @return 更新状態
     */
    public String getDataUpFlg() {
        return DataUpFlg;
    }

    /**
     * 更新状態を設定します。
     * @param DataUpFlg 更新状態
     */
    public void setDataUpFlg(String DataUpFlg) {
        this.DataUpFlg = DataUpFlg;
    }

    /**
     * 稟議・条変起案中区分を取得します。
     * @return 稟議・条変起案中区分
     */
    public String getID_Kubun_JohenKianchu() {
        return ID_Kubun_JohenKianchu;
    }

    /**
     * 稟議・条変起案中区分を設定します。
     * @param ID_Kubun_JohenKianchu 稟議・条変起案中区分
     */
    public void setID_Kubun_JohenKianchu(String ID_Kubun_JohenKianchu) {
        this.ID_Kubun_JohenKianchu = ID_Kubun_JohenKianchu;
    }

    /**
     * 前回払出・更生処理区分を取得します。
     * @return 前回払出・更生処理区分
     */
    public String getID_HDLas_Kubun_KoseiShori() {
        return ID_HDLas_Kubun_KoseiShori;
    }

    /**
     * 前回払出・更生処理区分を設定します。
     * @param ID_HDLas_Kubun_KoseiShori 前回払出・更生処理区分
     */
    public void setID_HDLas_Kubun_KoseiShori(String ID_HDLas_Kubun_KoseiShori) {
        this.ID_HDLas_Kubun_KoseiShori = ID_HDLas_Kubun_KoseiShori;
    }

    /**
     * 前回払出・払出累計額を取得します。
     * @return 前回払出・払出累計額
     */
    public java.math.BigDecimal getID_HDLas_M_HaraidashiRuikei() {
        return ID_HDLas_M_HaraidashiRuikei;
    }

    /**
     * 前回払出・払出累計額を設定します。
     * @param ID_HDLas_M_HaraidashiRuikei 前回払出・払出累計額
     */
    public void setID_HDLas_M_HaraidashiRuikei(java.math.BigDecimal ID_HDLas_M_HaraidashiRuikei) {
        this.ID_HDLas_M_HaraidashiRuikei = ID_HDLas_M_HaraidashiRuikei;
    }

    /**
     * 前回払出・繰上償還額を取得します。
     * @return 前回払出・繰上償還額
     */
    public java.math.BigDecimal getID_HDLas_M_Kurisho() {
        return ID_HDLas_M_Kurisho;
    }

    /**
     * 前回払出・繰上償還額を設定します。
     * @param ID_HDLas_M_Kurisho 前回払出・繰上償還額
     */
    public void setID_HDLas_M_Kurisho(java.math.BigDecimal ID_HDLas_M_Kurisho) {
        this.ID_HDLas_M_Kurisho = ID_HDLas_M_Kurisho;
    }

    /**
     * 前回払出・繰上償還累計額を取得します。
     * @return 前回払出・繰上償還累計額
     */
    public java.math.BigDecimal getID_HDLas_M_KurishoRuikei() {
        return ID_HDLas_M_KurishoRuikei;
    }

    /**
     * 前回払出・繰上償還累計額を設定します。
     * @param ID_HDLas_M_KurishoRuikei 前回払出・繰上償還累計額
     */
    public void setID_HDLas_M_KurishoRuikei(java.math.BigDecimal ID_HDLas_M_KurishoRuikei) {
        this.ID_HDLas_M_KurishoRuikei = ID_HDLas_M_KurishoRuikei;
    }

    /**
     * 前回払出・払出充当年月日を取得します。
     * @return 前回払出・払出充当年月日
     */
    public String getID_HDLas_Date_HaraidashiJuto() {
        return ID_HDLas_Date_HaraidashiJuto;
    }

    /**
     * 前回払出・払出充当年月日を設定します。
     * @param ID_HDLas_Date_HaraidashiJuto 前回払出・払出充当年月日
     */
    public void setID_HDLas_Date_HaraidashiJuto(String ID_HDLas_Date_HaraidashiJuto) {
        this.ID_HDLas_Date_HaraidashiJuto = ID_HDLas_Date_HaraidashiJuto;
    }

    /**
     * 前回払出・貸付受入金残高を取得します。
     * @return 前回払出・貸付受入金残高
     */
    public java.math.BigDecimal getID_HDLas_M_HaraidashiKashitsukeZan() {
        return ID_HDLas_M_HaraidashiKashitsukeZan;
    }

    /**
     * 前回払出・貸付受入金残高を設定します。
     * @param ID_HDLas_M_HaraidashiKashitsukeZan 前回払出・貸付受入金残高
     */
    public void setID_HDLas_M_HaraidashiKashitsukeZan(java.math.BigDecimal ID_HDLas_M_HaraidashiKashitsukeZan) {
        this.ID_HDLas_M_HaraidashiKashitsukeZan = ID_HDLas_M_HaraidashiKashitsukeZan;
    }

    /**
     * 前回払出・払出額有無フラグ（true=有）を取得します。
     * @return 前回払出・払出額有無フラグ（true=有）
     */
    public boolean getID_HDLas_M_HaraidashiFlag() {
        return ID_HDLas_M_HaraidashiFlag;
    }

    /**
     * 前回払出・払出額有無フラグ（true=有）を設定します。
     * @param ID_HDLas_M_HaraidashiFlag 前回払出・払出額有無フラグ（true=有）
     */
    public void setID_HDLas_M_HaraidashiFlag(boolean ID_HDLas_M_HaraidashiFlag) {
        this.ID_HDLas_M_HaraidashiFlag = ID_HDLas_M_HaraidashiFlag;
    }

    /**
     * 前回払出・繰上償還額有無フラグ（true=有）を取得します。
     * @return 前回払出・繰上償還額有無フラグ（true=有）
     */
    public boolean getID_HDLas_M_KurishoFlag() {
        return ID_HDLas_M_KurishoFlag;
    }

    /**
     * 前回払出・繰上償還額有無フラグ（true=有）を設定します。
     * @param ID_HDLas_M_KurishoFlag 前回払出・繰上償還額有無フラグ（true=有）
     */
    public void setID_HDLas_M_KurishoFlag(boolean ID_HDLas_M_KurishoFlag) {
        this.ID_HDLas_M_KurishoFlag = ID_HDLas_M_KurishoFlag;
    }

    /**
     * 更新用払出・更生処理区分を取得します。
     * @return 更新用払出・更生処理区分
     */
    public String getID_HDNew_Kubun_KoseiShori() {
        return ID_HDNew_Kubun_KoseiShori;
    }

    /**
     * 更新用払出・更生処理区分を設定します。
     * @param ID_HDNew_Kubun_KoseiShori 更新用払出・更生処理区分
     */
    public void setID_HDNew_Kubun_KoseiShori(String ID_HDNew_Kubun_KoseiShori) {
        this.ID_HDNew_Kubun_KoseiShori = ID_HDNew_Kubun_KoseiShori;
    }

    /**
     * 更新用払出・計数管理処理番号を取得します。
     * @return 更新用払出・計数管理処理番号
     */
    public String getID_HDNew_KeisuKanriShori() {
        return ID_HDNew_KeisuKanriShori;
    }

    /**
     * 更新用払出・計数管理処理番号を設定します。
     * @param ID_HDNew_KeisuKanriShori 更新用払出・計数管理処理番号
     */
    public void setID_HDNew_KeisuKanriShori(String ID_HDNew_KeisuKanriShori) {
        this.ID_HDNew_KeisuKanriShori = ID_HDNew_KeisuKanriShori;
    }

    /**
     * 更新用払出・払出額を取得します。
     * @return 更新用払出・払出額
     */
    public java.math.BigDecimal getID_HDNew_M_Haraidashi() {
        return ID_HDNew_M_Haraidashi;
    }

    /**
     * 更新用払出・払出額を設定します。
     * @param ID_HDNew_M_Haraidashi 更新用払出・払出額
     */
    public void setID_HDNew_M_Haraidashi(java.math.BigDecimal ID_HDNew_M_Haraidashi) {
        this.ID_HDNew_M_Haraidashi = ID_HDNew_M_Haraidashi;
    }

    /**
     * 更新用払出・払出累計額を取得します。
     * @return 更新用払出・払出累計額
     */
    public java.math.BigDecimal getID_HDNew_M_HaraidashiRuikei() {
        return ID_HDNew_M_HaraidashiRuikei;
    }

    /**
     * 更新用払出・払出累計額を設定します。
     * @param ID_HDNew_M_HaraidashiRuikei 更新用払出・払出累計額
     */
    public void setID_HDNew_M_HaraidashiRuikei(java.math.BigDecimal ID_HDNew_M_HaraidashiRuikei) {
        this.ID_HDNew_M_HaraidashiRuikei = ID_HDNew_M_HaraidashiRuikei;
    }

    /**
     * 更新用払出・繰上償還額を取得します。
     * @return 更新用払出・繰上償還額
     */
    public java.math.BigDecimal getID_HDNew_M_Kurisho() {
        return ID_HDNew_M_Kurisho;
    }

    /**
     * 更新用払出・繰上償還額を設定します。
     * @param ID_HDNew_M_Kurisho 更新用払出・繰上償還額
     */
    public void setID_HDNew_M_Kurisho(java.math.BigDecimal ID_HDNew_M_Kurisho) {
        this.ID_HDNew_M_Kurisho = ID_HDNew_M_Kurisho;
    }

    /**
     * 更新用払出・繰上償還累計額を取得します。
     * @return 更新用払出・繰上償還累計額
     */
    public java.math.BigDecimal getID_HDNew_M_KurishoRuikei() {
        return ID_HDNew_M_KurishoRuikei;
    }

    /**
     * 更新用払出・繰上償還累計額を設定します。
     * @param ID_HDNew_M_KurishoRuikei 更新用払出・繰上償還累計額
     */
    public void setID_HDNew_M_KurishoRuikei(java.math.BigDecimal ID_HDNew_M_KurishoRuikei) {
        this.ID_HDNew_M_KurishoRuikei = ID_HDNew_M_KurishoRuikei;
    }

    /**
     * 更新用払出・貸付受入金残高積数を取得します。
     * @return 更新用払出・貸付受入金残高積数
     */
    public java.math.BigDecimal getID_HDNew_M_ZandakaSekisu() {
        return ID_HDNew_M_ZandakaSekisu;
    }

    /**
     * 更新用払出・貸付受入金残高積数を設定します。
     * @param ID_HDNew_M_ZandakaSekisu 更新用払出・貸付受入金残高積数
     */
    public void setID_HDNew_M_ZandakaSekisu(java.math.BigDecimal ID_HDNew_M_ZandakaSekisu) {
        this.ID_HDNew_M_ZandakaSekisu = ID_HDNew_M_ZandakaSekisu;
    }

    /**
     * 更新用払出・払出充当年月日を取得します。
     * @return 更新用払出・払出充当年月日
     */
    public String getID_HDNew_Date_HaraidashiJuto() {
        return ID_HDNew_Date_HaraidashiJuto;
    }

    /**
     * 更新用払出・払出充当年月日を設定します。
     * @param ID_HDNew_Date_HaraidashiJuto 更新用払出・払出充当年月日
     */
    public void setID_HDNew_Date_HaraidashiJuto(String ID_HDNew_Date_HaraidashiJuto) {
        this.ID_HDNew_Date_HaraidashiJuto = ID_HDNew_Date_HaraidashiJuto;
    }

    /**
     * 更新用払出・貸付受入金残高を取得します。
     * @return 更新用払出・貸付受入金残高
     */
    public java.math.BigDecimal getID_HDNew_M_HaraidashiKashitsukeZan() {
        return ID_HDNew_M_HaraidashiKashitsukeZan;
    }

    /**
     * 更新用払出・貸付受入金残高を設定します。
     * @param ID_HDNew_M_HaraidashiKashitsukeZan 更新用払出・貸付受入金残高
     */
    public void setID_HDNew_M_HaraidashiKashitsukeZan(java.math.BigDecimal ID_HDNew_M_HaraidashiKashitsukeZan) {
        this.ID_HDNew_M_HaraidashiKashitsukeZan = ID_HDNew_M_HaraidashiKashitsukeZan;
    }

    /**
     * 請求・約定元金を取得します。
     * @return 請求・約定元金
     */
    public java.math.BigDecimal getID_M_YakujoGankin() {
        return ID_M_YakujoGankin;
    }

    /**
     * 請求・約定元金を設定します。
     * @param ID_M_YakujoGankin 請求・約定元金
     */
    public void setID_M_YakujoGankin(java.math.BigDecimal ID_M_YakujoGankin) {
        this.ID_M_YakujoGankin = ID_M_YakujoGankin;
    }

    /**
     * 請求・約定利息を取得します。
     * @return 請求・約定利息
     */
    public java.math.BigDecimal getID_M_YakujoRisoku() {
        return ID_M_YakujoRisoku;
    }

    /**
     * 請求・約定利息を設定します。
     * @param ID_M_YakujoRisoku 請求・約定利息
     */
    public void setID_M_YakujoRisoku(java.math.BigDecimal ID_M_YakujoRisoku) {
        this.ID_M_YakujoRisoku = ID_M_YakujoRisoku;
    }

    /**
     * 請求・払込年月日を取得します。
     * @return 請求・払込年月日
     */
    public String getID_Date_Haraikomi() {
        return ID_Date_Haraikomi;
    }

    /**
     * 請求・払込年月日を設定します。
     * @param ID_Date_Haraikomi 請求・払込年月日
     */
    public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
        this.ID_Date_Haraikomi = ID_Date_Haraikomi;
    }

    /**
     * 請求データの各レコードを更新する場合のフラグを取得します。
     * @return 請求データの各レコードを更新する場合のフラグ
     */
    public boolean getFlgSeikyuUp_Record() {
        return flgSeikyuUp_Record;
    }

    /**
     * 請求データの各レコードを更新する場合のフラグを設定します。
     * @param flgSeikyuUp_Record 請求データの各レコードを更新する場合のフラグ
     */
    public void setFlgSeikyuUp_Record(boolean flgSeikyuUp_Record) {
        this.flgSeikyuUp_Record = flgSeikyuUp_Record;
    }

    /**
     * 請求・更新する払込年月日の保存を取得します。
     * @return 請求・更新する払込年月日の保存
     */
    public String getID_UP_Seikyu_Haraikomi() {
        return ID_UP_Seikyu_Haraikomi;
    }

    /**
     * 請求・更新する払込年月日の保存を設定します。
     * @param ID_UP_Seikyu_Haraikomi 請求・更新する払込年月日の保存
     */
    public void setID_UP_Seikyu_Haraikomi(String ID_UP_Seikyu_Haraikomi) {
        this.ID_UP_Seikyu_Haraikomi = ID_UP_Seikyu_Haraikomi;
    }

    /**
     * 約定・約定前残高を取得します。
     * @return 約定・約定前残高
     */
    public java.math.BigDecimal getID_M_ZandakaBeforeYakujo() {
        return ID_M_ZandakaBeforeYakujo;
    }

    /**
     * 約定・約定前残高を設定します。
     * @param ID_M_ZandakaBeforeYakujo 約定・約定前残高
     */
    public void setID_M_ZandakaBeforeYakujo(java.math.BigDecimal ID_M_ZandakaBeforeYakujo) {
        this.ID_M_ZandakaBeforeYakujo = ID_M_ZandakaBeforeYakujo;
    }

    /**
     * 積数起算年月日を取得します。
     * @return 積数起算年月日
     */
    public String getID_Date_SekisuKisanbi() {
        return ID_Date_SekisuKisanbi;
    }

    /**
     * 積数起算年月日を設定します。
     * @param ID_Date_SekisuKisanbi 積数起算年月日
     */
    public void setID_Date_SekisuKisanbi(String ID_Date_SekisuKisanbi) {
        this.ID_Date_SekisuKisanbi = ID_Date_SekisuKisanbi;
    }

    /**
     * 償還方法タイプ識別値を取得します。
     * @return 償還方法タイプ識別値
     */
    public String getType_Shokan() {
        return Type_Shokan;
    }

    /**
     * 償還方法タイプ識別値を設定します。
     * @param Type_Shokan 償還方法タイプ識別値
     */
    public void setType_Shokan(String Type_Shokan) {
        this.Type_Shokan = Type_Shokan;
    }

    /**
     * 更新用賦金を取得します。
     * @return 更新用賦金
     */
    public java.math.BigDecimal getID_Up_M_Fukin() {
        return ID_Up_M_Fukin;
    }

    /**
     * 更新用賦金を設定します。
     * @param ID_Up_M_Fukin 更新用賦金
     */
    public void setID_Up_M_Fukin(java.math.BigDecimal ID_Up_M_Fukin) {
        this.ID_Up_M_Fukin = ID_Up_M_Fukin;
    }

    /**
     * 更新用調整コードを取得します。
     * @return 更新用調整コード
     */
    public String getID_Up_Code_Chosei() {
        return ID_Up_Code_Chosei;
    }

    /**
     * 更新用調整コードを設定します。
     * @param ID_Up_Code_Chosei 更新用調整コード
     */
    public void setID_Up_Code_Chosei(String ID_Up_Code_Chosei) {
        this.ID_Up_Code_Chosei = ID_Up_Code_Chosei;
    }

    /**
     * 更新用元金均等額（元利均等償還の場合使用）を取得します。
     * @return 更新用元金均等額（元利均等償還の場合使用）
     */
    public java.math.BigDecimal getID_Up_M_GankinKinto() {
        return ID_Up_M_GankinKinto;
    }

    /**
     * 更新用元金均等額（元利均等償還の場合使用）を設定します。
     * @param ID_Up_M_GankinKinto 更新用元金均等額（元利均等償還の場合使用）
     */
    public void setID_Up_M_GankinKinto(java.math.BigDecimal ID_Up_M_GankinKinto) {
        this.ID_Up_M_GankinKinto = ID_Up_M_GankinKinto;
    }

    /**
     * 更新用元金不均等額を取得します。
     * @return 更新用元金不均等額
     */
    public java.math.BigDecimal getID_Up_M_GankinFukinto() {
        return ID_Up_M_GankinFukinto;
    }

    /**
     * 更新用元金不均等額を設定します。
     * @param ID_Up_M_GankinFukinto 更新用元金不均等額
     */
    public void setID_Up_M_GankinFukinto(java.math.BigDecimal ID_Up_M_GankinFukinto) {
        this.ID_Up_M_GankinFukinto = ID_Up_M_GankinFukinto;
    }

    /**
     * 更新用約定元金（元利均等償還の場合使用）を取得します。
     * @return 更新用約定元金（元利均等償還の場合使用）
     */
    public java.math.BigDecimal getID_Up_M_YakujoGankin() {
        return ID_Up_M_YakujoGankin;
    }

    /**
     * 更新用約定元金（元利均等償還の場合使用）を設定します。
     * @param ID_Up_M_YakujoGankin 更新用約定元金（元利均等償還の場合使用）
     */
    public void setID_Up_M_YakujoGankin(java.math.BigDecimal ID_Up_M_YakujoGankin) {
        this.ID_Up_M_YakujoGankin = ID_Up_M_YakujoGankin;
    }

    /**
     * 更新用約定利息を取得します。
     * @return 更新用約定利息
     */
    public java.math.BigDecimal getID_Up_M_YakujoRisoku() {
        return ID_Up_M_YakujoRisoku;
    }

    /**
     * 更新用約定利息を設定します。
     * @param ID_Up_M_YakujoRisoku 更新用約定利息
     */
    public void setID_Up_M_YakujoRisoku(java.math.BigDecimal ID_Up_M_YakujoRisoku) {
        this.ID_Up_M_YakujoRisoku = ID_Up_M_YakujoRisoku;
    }

    /**
     * 賦金計算用・約定・約定元金を取得します。
     * @return 賦金計算用・約定・約定元金
     */
    public java.math.BigDecimal getID_M_YakujoGankin_Yakujo_Fukin() {
        return ID_M_YakujoGankin_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・約定元金を設定します。
     * @param ID_M_YakujoGankin_Yakujo_Fukin 賦金計算用・約定・約定元金
     */
    public void setID_M_YakujoGankin_Yakujo_Fukin(java.math.BigDecimal ID_M_YakujoGankin_Yakujo_Fukin) {
        this.ID_M_YakujoGankin_Yakujo_Fukin = ID_M_YakujoGankin_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・約定利息を取得します。
     * @return 賦金計算用・約定・約定利息
     */
    public java.math.BigDecimal getID_M_YakujoRisoku_Yakujo_Fukin() {
        return ID_M_YakujoRisoku_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・約定利息を設定します。
     * @param ID_M_YakujoRisoku_Yakujo_Fukin 賦金計算用・約定・約定利息
     */
    public void setID_M_YakujoRisoku_Yakujo_Fukin(java.math.BigDecimal ID_M_YakujoRisoku_Yakujo_Fukin) {
        this.ID_M_YakujoRisoku_Yakujo_Fukin = ID_M_YakujoRisoku_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・払込期日を取得します。
     * @return 賦金計算用・約定・払込期日
     */
    public String getID_Date_Haraikomi_Yakujo_Fukin() {
        return ID_Date_Haraikomi_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・払込期日を設定します。
     * @param ID_Date_Haraikomi_Yakujo_Fukin 賦金計算用・約定・払込期日
     */
    public void setID_Date_Haraikomi_Yakujo_Fukin(String ID_Date_Haraikomi_Yakujo_Fukin) {
        this.ID_Date_Haraikomi_Yakujo_Fukin = ID_Date_Haraikomi_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・請求繰上利息を取得します。
     * @return 賦金計算用・約定・請求繰上利息
     */
    public java.math.BigDecimal getID_M_SeikuriRisoku_Yakujo_Fukin() {
        return ID_M_SeikuriRisoku_Yakujo_Fukin;
    }

    /**
     * 賦金計算用・約定・請求繰上利息を設定します。
     * @param ID_M_SeikuriRisoku_Yakujo_Fukin 賦金計算用・約定・請求繰上利息
     */
    public void setID_M_SeikuriRisoku_Yakujo_Fukin(java.math.BigDecimal ID_M_SeikuriRisoku_Yakujo_Fukin) {
        this.ID_M_SeikuriRisoku_Yakujo_Fukin = ID_M_SeikuriRisoku_Yakujo_Fukin;
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
     * 払出元金充当日を取得します。
     * @return 払出元金充当日
     */
    public String getID_Date_HaraidashiJuto() {
        return ID_Date_HaraidashiJuto;
    }

    /**
     * 払出元金充当日を設定します。
     * @param ID_Date_HaraidashiJuto 払出元金充当日
     */
    public void setID_Date_HaraidashiJuto(String ID_Date_HaraidashiJuto) {
        this.ID_Date_HaraidashiJuto = ID_Date_HaraidashiJuto;
    }

    /**
     * 繰上償還事由コード(DB取得時)を取得します。
     * @return 繰上償還事由コード(DB取得時)
     */
    public String getID_Code_KurishoJiyu_Save() {
        return ID_Code_KurishoJiyu_Save;
    }

    /**
     * 繰上償還事由コード(DB取得時)を設定します。
     * @param ID_Code_KurishoJiyu_Save 繰上償還事由コード(DB取得時)
     */
    public void setID_Code_KurishoJiyu_Save(String ID_Code_KurishoJiyu_Save) {
        this.ID_Code_KurishoJiyu_Save = ID_Code_KurishoJiyu_Save;
    }

    /**
     * 調整コード(DB取得時)を取得します。
     * @return 調整コード(DB取得時)
     */
    public String getID_Code_Chosei() {
        return ID_Code_Chosei;
    }

    /**
     * 調整コード(DB取得時)を設定します。
     * @param ID_Code_Chosei 調整コード(DB取得時)
     */
    public void setID_Code_Chosei(String ID_Code_Chosei) {
        this.ID_Code_Chosei = ID_Code_Chosei;
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
     * 受託者勘定処理年月エラーを取得します。
     * @return 受託者勘定処理年月エラー
     */
    public boolean getError_Date_Jtkshori() {
        return Error_Date_Jtkshori;
    }

    /**
     * 受託者勘定処理年月エラーを設定します。
     * @param Error_Date_Jtkshori 受託者勘定処理年月エラー
     */
    public void setError_Date_Jtkshori(boolean Error_Date_Jtkshori) {
        this.Error_Date_Jtkshori = Error_Date_Jtkshori;
    }

    /**
     * 払出元金充当日エラーを取得します。
     * @return 払出元金充当日エラー
     */
    public boolean getError_Date_HaraidashiJuto() {
        return Error_Date_HaraidashiJuto;
    }

    /**
     * 払出元金充当日エラーを設定します。
     * @param Error_Date_HaraidashiJuto 払出元金充当日エラー
     */
    public void setError_Date_HaraidashiJuto(boolean Error_Date_HaraidashiJuto) {
        this.Error_Date_HaraidashiJuto = Error_Date_HaraidashiJuto;
    }

    /**
     * 資金払出額エラーを取得します。
     * @return 資金払出額エラー
     */
    public boolean getError_M_Haraidashi() {
        return Error_M_Haraidashi;
    }

    /**
     * 資金払出額エラーを設定します。
     * @param Error_M_Haraidashi 資金払出額エラー
     */
    public void setError_M_Haraidashi(boolean Error_M_Haraidashi) {
        this.Error_M_Haraidashi = Error_M_Haraidashi;
    }

    /**
     * 元金充当額エラーを取得します。
     * @return 元金充当額エラー
     */
    public boolean getError_M_Ganju() {
        return Error_M_Ganju;
    }

    /**
     * 元金充当額エラーを設定します。
     * @param Error_M_Ganju 元金充当額エラー
     */
    public void setError_M_Ganju(boolean Error_M_Ganju) {
        this.Error_M_Ganju = Error_M_Ganju;
    }

    /**
     * 元金充当後元金均等額エラーを取得します。
     * @return 元金充当後元金均等額エラー
     */
    public boolean getError_M_GankinKintoAfterGanju() {
        return Error_M_GankinKintoAfterGanju;
    }

    /**
     * 元金充当後元金均等額エラーを設定します。
     * @param Error_M_GankinKintoAfterGanju 元金充当後元金均等額エラー
     */
    public void setError_M_GankinKintoAfterGanju(boolean Error_M_GankinKintoAfterGanju) {
        this.Error_M_GankinKintoAfterGanju = Error_M_GankinKintoAfterGanju;
    }

    /**
     * 元金充当後元金不均等額エラーを取得します。
     * @return 元金充当後元金不均等額エラー
     */
    public boolean getError_M_GankinFukintoAfterGanju() {
        return Error_M_GankinFukintoAfterGanju;
    }

    /**
     * 元金充当後元金不均等額エラーを設定します。
     * @param Error_M_GankinFukintoAfterGanju 元金充当後元金不均等額エラー
     */
    public void setError_M_GankinFukintoAfterGanju(boolean Error_M_GankinFukintoAfterGanju) {
        this.Error_M_GankinFukintoAfterGanju = Error_M_GankinFukintoAfterGanju;
    }

    /**
     * 繰上償還事由コードエラーを取得します。
     * @return 繰上償還事由コードエラー
     */
    public boolean getError_Code_KurishoJiyu() {
        return Error_Code_KurishoJiyu;
    }

    /**
     * 繰上償還事由コードエラーを設定します。
     * @param Error_Code_KurishoJiyu 繰上償還事由コードエラー
     */
    public void setError_Code_KurishoJiyu(boolean Error_Code_KurishoJiyu) {
        this.Error_Code_KurishoJiyu = Error_Code_KurishoJiyu;
    }

    /**
     * 調整コードエラーを取得します。
     * @return 調整コードエラー
     */
    public boolean getError_Code_Chosei() {
        return Error_Code_Chosei;
    }

    /**
     * 調整コードエラーを設定します。
     * @param Error_Code_Chosei 調整コードエラー
     */
    public void setError_Code_Chosei(boolean Error_Code_Chosei) {
        this.Error_Code_Chosei = Error_Code_Chosei;
    }

}