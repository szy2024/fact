//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd004_02のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** エラー */
    private String lblErr;
    /** メッセージ */
    private String lblMessage;
    /** コメント */
    private String lblComment;
    /** ヘッダー表示（上） */
    private String lblID_Head_Red;
    /** ヘッダー表示（上赤） */
    private String lblID_Head_Red2;
    /** 顧客名 */
    private String lblID_Name_Customer_Red;
    /** 扱店名 */
    private String lblID_Name_Organization_Red;
    /** 公庫支店 */
    private String lblID_Code_KoukoShiten_Red;
    /** 扱店 */
    private String lblID_Code_Organization_Red;
    /** 店舗 */
    private String lblID_Code_Tenpo_Red;
    /** 年度 */
    private String lblID_Year_Red;
    /** 方式資金 */
    private String lblID_Code_HoshikiShikin_Red;
    /** 番号 */
    private String lblID_ID_Ringi_Red;
    /** 枝番 */
    private String lblID_ID_RingiBranch_Red;
    /** 償還後第1回払込期日 */
    private String lblID_Date_FirstHaraikomiAfterKurisho_Red;
    /** 入金日 */
    private String lblID_Date_Nyukin_Red;
    /** 繰償事由コード */
    private String lblID_Code_Kurishojiyu_Red;
    /** 利息(円) */
    private String lblID_M_KurishoRisoku_Red;
    /** 元金(円) */
    private String lblID_M_KurishoGankin_Red;
    /** 控除利息(円) */
    private String lblID_M_KojoRisoku_Red;
    /** 繰上償還手数料(円) */
    private String lblID_M_KurishoCommission_Red;
    /** 仮受金からの充当額(円) */
    private String lblID_M_KariukeIppanJuto_Red;
    /** 送金額(円) */
    private String lblID_M_Sokin_Red;
    /** 繰償後残元金(円) */
    private String lblID_M_ZanGankinAfterKurisho_Red;
    /** 受託者勘定処理年月 */
    private String lblID_Date_JtkShori_Red;
    /** 送金日 */
    private String lblID_Date_Sokin_Red;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi_Red;
    /** 代弁履行後の作成 */
    private String chkID_ID_After_Daiibensai_Red;
    /** 払込期日① */
    private String lblID_Date_Haraikomi1_Red;
    /** 払込期日② */
    private String lblID_Date_Haraikomi2_Red;
    /** 払込期日③ */
    private String lblID_Date_Haraikomi3_Red;
    /** 払込期日④ */
    private String lblID_Date_Haraikomi4_Red;
    /** 払込元金(円)① */
    private String lblID_M_HaraikomiGankin1_Red;
    /** 払込元金(円)② */
    private String lblID_M_HaraikomiGankin2_Red;
    /** 払込元金(円)③ */
    private String lblID_M_HaraikomiGankin3_Red;
    /** 払込元金(円)④ */
    private String lblID_M_HaraikomiGankin4_Red;
    /** 繰償後元金均等額(円) */
    private String lblID_M_GankinKintoAfterKurisho_Red;
    /** 繰償後元金不均等額(円) */
    private String lblID_M_GankinFukintoAfterKurisho_Red;
    /** 調整コード */
    private String rdoID_Code_chosei_Red;
    /** ヘッダー表示（修正） */
    private String lblID_Head;
    /** 顧客名（修正） */
    private String lblID_Name_Customer;
    /** 扱店名（修正） */
    private String lblID_Name_Organization;
    /** 公庫支店（修正） */
    private String lblID_Code_KoukoShiten;
    /** 扱店（修正） */
    private String lblID_Code_Organization;
    /** 店舗（修正） */
    private String lblID_Code_Tenpo;
    /** 年度（修正） */
    private String lblID_Year;
    /** 方式資金（修正） */
    private String lblID_Code_HoshikiShikin;
    /** 番号（修正） */
    private String lblID_ID_Ringi;
    /** 枝番（修正） */
    private String lblID_ID_RingiBranch;
    /** 償還後第1回払込期日（修正） */
    private String lblID_Date_FirstHaraikomiAfterKurisho;
    /** 入金日（修正） */
    private String lblID_Date_Nyukin;
    /** 繰償事由コード（修正） */
    private String lblID_Code_Kurishojiyu;
    /** 利息(円)（修正） */
    private String lblID_M_KurishoRisoku;
    /** 元金(円)（修正） */
    private String lblID_M_KurishoGankin;
    /** 控除利息(円)（修正） */
    private String lblID_M_KojoRisoku;
    /** 繰上償還手数料(円)（修正） */
    private String lblID_M_KurishoCommission;
    /** 仮受金からの充当額(円)（修正） */
    private String lblID_M_KariukeIppanJuto;
    /** 送金額(円)（修正） */
    private String lblID_M_Sokin;
    /** 繰償後残元金(円)（修正） */
    private String lblID_M_ZanGankinAfterKurisho;
    /** 受託者勘定処理年月（修正） */
    private String lblID_Date_JtkShori;
    /** 送金日（修正） */
    private String lblID_Date_Sokin;
    /** 送金日番号（修正） */
    private String lblID_ID_Sokinbi;
    /** 代弁履行後の作成（修正） */
    private String chkID_ID_After_Daiibensai;
    /** 払込期日①（修正） */
    private String lblID_Date_Haraikomi1;
    /** 払込期日②（修正） */
    private String lblID_Date_Haraikomi2;
    /** 払込期日③（修正） */
    private String lblID_Date_Haraikomi3;
    /** 払込期日④（修正） */
    private String lblID_Date_Haraikomi4;
    /** 払込元金(円)①（修正） */
    private String lblID_M_HaraikomiGankin1;
    /** 払込元金(円)②（修正） */
    private String lblID_M_HaraikomiGankin2;
    /** 払込元金(円)③（修正） */
    private String lblID_M_HaraikomiGankin3;
    /** 払込元金(円)④（修正） */
    private String lblID_M_HaraikomiGankin4;
    /** 繰償後元金均等額(円)（修正） */
    private String lblID_M_GankinKintoAfterKurisho;
    /** 繰償後元金不均等額(円)（修正） */
    private String lblID_M_GankinFukintoAfterKurisho;
    /** 調整コード（修正） */
    private String rdoID_Code_chosei;
    /** 報告年月日 */
    private String txtID_Date_Report;
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
    /** 償還後第1回払込期日 */
    private String txtID_Date_FirstHaraikomiAfterKurisho_Red;
    /** 入金日 */
    private String txtID_Date_Nyukin_Red;
    /** 繰償事由コード */
    private String txtID_Code_Kurishojiyu_Red;
    /** 利息(円) */
    private String txtID_M_KurishoRisoku_Red;
    /** 元金(円) */
    private String txtID_M_KurishoGankin_Red;
    /** 控除利息(円) */
    private String txtID_M_KojoRisoku_Red;
    /** 繰上償還手数料(円) */
    private String txtID_M_KurishoCommission_Red;
    /** 仮受金からの充当額(円) */
    private String txtID_M_KariukeIppanJuto_Red;
    /** 送金額(円) */
    private String txtID_M_Sokin_Red;
    /** 繰償後残元金(円) */
    private String txtID_M_ZanGankinAfterKurisho_Red;
    /** 受託者勘定処理年月 */
    private String txtID_Date_JtkShori_Red;
    /** 送金日 */
    private String txtID_Date_Sokin_Red;
    /** 送金日番号 */
    private String txtID_ID_Sokinbi_Red;
    /** 払込期日① */
    private String txtID_Date_Haraikomi1_Red;
    /** 払込期日② */
    private String txtID_Date_Haraikomi2_Red;
    /** 払込期日③ */
    private String txtID_Date_Haraikomi3_Red;
    /** 払込期日④ */
    private String txtID_Date_Haraikomi4_Red;
    /** 払込元金① */
    private String txtID_M_HaraikomiGankin1_Red;
    /** 払込元金② */
    private String txtID_M_HaraikomiGankin2_Red;
    /** 払込元金③ */
    private String txtID_M_HaraikomiGankin3_Red;
    /** 払込元金④ */
    private String txtID_M_HaraikomiGankin4_Red;
    /** 繰償後元金均等額(円) */
    private String txtID_M_GankinKintoAfterKurisho_Red;
    /** 繰償後元金不均等額(円) */
    private String txtID_M_GankinFukintoAfterKurisho_Red;
    /** 受託者勘定処理年月(元号) */
    private String ID_Date_Jtkshori_Gengo_Red;
    /** 受託者勘定処理年月(年) */
    private String ID_Date_Jtkshori_Nen_Red;
    /** 受託者勘定処理年月(月) */
    private String drpID_Date_JtkshoriTsuki_Red;
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
    /** 償還後第1回払込期（元号）（修正） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    /** 償還後第1回払込期（年）（修正） */
    private String txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    /** 償還後第1回払込期（月）（修正） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    /** 償還後第1回払込期（日）（修正） */
    private String drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    /** 入金日(元号)（修正） */
    private String drpID_Date_Nyukin_Gengo;
    /** 入金日(年)（修正） */
    private String txtID_Date_Nyukin_Nen;
    /** 入金日(月)（修正） */
    private String drpID_Date_Nyukin_Tsuki;
    /** 入金日(日)（修正） */
    private String drpID_Date_Nyukin_Bi;
    /** 繰償事由コード（修正） */
    private String drpID_Code_Kurishojiyu;
    /** 利息(円)（修正） */
    private String txtID_M_KurishoRisoku;
    /** 元金(円)（修正） */
    private String txtID_M_KurishoGankin;
    /** 控除利息(円)（修正） */
    private String txtID_M_KojoRisoku;
    /** 繰上償還手数料(円)（修正） */
    private String txtID_M_KurishoCommission;
    /** 仮受金からの充当額(円)（修正） */
    private String txtID_M_KariukeIppanJuto;
    /** 送金額(円)（修正） */
    private String txtID_M_Sokin;
    /** 繰償後残元金(円)（修正） */
    private String txtID_M_ZanGankinAfterKurisho;
    /** 受託者勘定処理年月（修正） */
    private String txtID_Date_Jtkshori;
    /** 送金日(元号)（修正） */
    private String drpID_Date_Sokin_Gengo;
    /** 送金日(年)（修正） */
    private String txtID_Date_Sokin_Nen;
    /** 送金日(月)（修正） */
    private String drpID_Date_Sokin_Tsuki;
    /** 送金日(日)（修正） */
    private String drpID_Date_Sokin_Bi;
    /** 送金日番号（修正） */
    private String txtID_ID_Sokinbi;
    /** 払込期日①（元号）（修正） */
    private String drpID_Date_Haraikomi1_Gengo;
    /** 払込期日①（年）（修正） */
    private String txtID_Date_Haraikomi1_Nen;
    /** 払込期日①（月）（修正） */
    private String drpID_Date_Haraikomi1_Tsuki;
    /** 払込期日①（日）（修正） */
    private String drpID_Date_Haraikomi1_Bi;
    /** 払込期日②（元号）（修正） */
    private String drpID_Date_Haraikomi2_Gengo;
    /** 払込期日②（年）（修正） */
    private String txtID_Date_Haraikomi2_Nen;
    /** 払込期日②（月）（修正） */
    private String drpID_Date_Haraikomi2_Tsuki;
    /** 払込期日②（日）（修正） */
    private String drpID_Date_Haraikomi2_Bi;
    /** 払込期日③（元号）（修正） */
    private String drpID_Date_Haraikomi3_Gengo;
    /** 払込期日③（年）（修正） */
    private String txtID_Date_Haraikomi3_Nen;
    /** 払込期日③（月）（修正） */
    private String drpID_Date_Haraikomi3_Tsuki;
    /** 払込期日③（日）（修正） */
    private String drpID_Date_Haraikomi3_Bi;
    /** 払込期日④（元号）（修正） */
    private String drpID_Date_Haraikomi4_Gengo;
    /** 払込期日④（年）（修正） */
    private String txtID_Date_Haraikomi4_Nen;
    /** 払込期日④（月）（修正） */
    private String drpID_Date_Haraikomi4_Tsuki;
    /** 払込期日④（日）（修正） */
    private String drpID_Date_Haraikomi4_Bi;
    /** 払込元金①（修正） */
    private String txtID_M_HaraikomiGankin1;
    /** 払込元金②（修正） */
    private String txtID_M_HaraikomiGankin2;
    /** 払込元金③（修正） */
    private String txtID_M_HaraikomiGankin3;
    /** 払込元金④（修正） */
    private String txtID_M_HaraikomiGankin4;
    /** 繰償後元金均等額(円)（修正） */
    private String txtID_M_GankinKintoAfterKurisho;
    /** 繰償後元金不均等額(円)（修正） */
    private String txtID_M_GankinFukintoAfterKurisho;
    /** 受託者勘定処理年月(元号)（修正） */
    private String drpID_Date_Jtkshori_Gengo;
    /** 受託者勘定処理年月(年)（修正） */
    private String txtID_Date_Jtkshori_Nen;
    /** 受託者勘定処理年月(月)（修正） */
    private String drpID_Date_Jtkshori_Tsuki;
    /** 履歴番号 */
    private String ID_ID_History_Red;
    /** 処理種別 */
    private String ID_Type_Process_Red;
    /** 取消済フラグ */
    private String ID_Flag_Torikeshizumi_Red;
    /** エラーコード */
    private String ID_Code_Error_Red;
    /** エラーメッセージ */
    private String ID_ErrorMessage_Red;
    /** 債権管理番号 */
    private String ID_ID_Credit_Red;
    /** 退避賦金 */
    private String ID_Keep_M_Fukin_Red;
    /** 退避元金不均等額 */
    private String ID_Keep_M_GankinFukinto_Red;
    /** 退避元金不均等区分 */
    private String ID_Keep_Kubun_GankinFukinto_Red;
    /** 退避貸付残高 */
    private String ID_Keep_M_KashitsukeZan_Red;
    /** 退避約定元金 */
    private String ID_Keep_M_YakujoGankin_Red;
    /** 退避約定利息 */
    private String ID_Keep_M_YakujoRisoku_Red;
    /** 退避償還期限 */
    private String ID_Keep_Date_ShokanKigen_Red;
    /** 最終更新年月日 */
    private String ID_Data_LastUpDate_Red;
    /** 退避控除利息 */
    private String ID_Keep_M_KojoRisoku_Red;
    /** 退避払込期日 */
    private String ID_Keep_Date_Haraikomi_Red;
    /** 退避条変起案中区分 */
    private String ID_Keep_JohenKianchu_Red;
    /** 条変起案中区分・稟議データ */
    private String ID_Kubun_JohenKianchu_Red;
    /** 貸付実行日 */
    private String ID_Date_Jikko_Red;
    /** 償還方法 */
    private String ID_Code_ShokanHouhou_Red;
    /** 貸付残高 */
    private String ID_M_KashitsukeZandaka_aRingi_Red;
    /** 償還期限 */
    private String ID_Date_ShokanKigen_aRingi_Red;
    /** 賦金 */
    private String ID_M_Fukin_aRingi_Red;
    /** 元金不均等額 */
    private String ID_M_GankinFukinto_aRingi_Red;
    /** 元金不均等額区分 */
    private String ID_Kubun_GankinFukintogaku_aRingi_Red;
    /** 繰上償還手数料区分 */
    private String ID_Kubun_KurishoTesuryo_aRingi_Red;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi_aRingi_Red;
    /** 据置期限 */
    private String ID_Date_SueokiKigen_aRingi_Red;
    /** 特利有効期限 */
    private String ID_Date_TokuriYuko_aRingi_Red;
    /** 利率 */
    private String ID_Riritsu_aRingi_Red;
    /** 特利 */
    private String ID_Tokuri_aRingi_Red;
    /** ステータス */
    private String ID_Status_Red;
    /** 報告書番号 */
    private String ID_ID_Report_Red;
    /** 時刻 */
    private String ID_Time_Report_Red;
    /** ユーザＩＤ */
    private String ID_User_ID_Red;
    /** 伝送番号 */
    private String ID_ID_Denso_Red;
    /** データコード */
    private String ID_DataCode_Red;
    /** 退避履歴番号 */
    private String ID_Keep_ID_History_Red;
    /** 充当順序変更区分 */
    private String ID_Kubun_JutoJunjoHenko_Red;
    /** 履歴番号(修正) */
    private String ID_ID_History;
    /** 取消済フラグ(修正) */
    private String ID_Flag_Torikeshizumi;
    /** エラーコード(修正) */
    private String ID_Code_Error;
    /** エラーメッセージ(修正) */
    private String ID_ErrorMessage;
    /** 債権管理番号(修正) */
    private String ID_ID_Credit;
    /** 退避賦金(修正) */
    private String ID_Keep_M_Fukin;
    /** 退避元金不均等額(修正) */
    private String ID_Keep_M_GankinFukinto;
    /** 退避元金不均等区分(修正) */
    private String ID_Keep_Kubun_GankinFukinto;
    /** 退避貸付残高(修正) */
    private String ID_Keep_M_KashitsukeZan;
    /** 退避約定元金(修正) */
    private String ID_Keep_M_YakujoGankin;
    /** 退避約定利息(修正) */
    private String ID_Keep_M_YakujoRisoku;
    /** 退避償還期限(修正) */
    private String ID_Keep_Date_ShokanKigen;
    /** 最終更新年月日(修正) */
    private String ID_Data_LastUpDate;
    /** 退避控除利息(修正) */
    private String ID_Keep_M_KojoRisoku;
    /** 退避払込期日(修正) */
    private String ID_Keep_Date_Haraikomi;
    /** 退避条変起案中区分(修正) */
    private String ID_Keep_JohenKianchu;
    /** 条変起案中区分・稟議データ(修正) */
    private String ID_Kubun_JohenKianchu;
    /** 貸付実行日(修正) */
    private String ID_Date_Jikko;
    /** 償還方法(修正) */
    private String ID_Code_ShokanHouhou;
    /** 貸付残高(修正) */
    private String ID_M_KashitsukeZandaka_aRingi;
    /** 償還期限(修正) */
    private String ID_Date_ShokanKigen_aRingi;
    /** 賦金(修正) */
    private String ID_M_Fukin_aRingi;
    /** 元金不均等額(修正) */
    private String ID_M_GankinFukinto_aRingi;
    /** 元金不均等額区分(修正) */
    private String ID_Kubun_GankinFukintogaku_aRingi;
    /** 繰上償還手数料区分(修正) */
    private String ID_Kubun_KurishoTesuryo_aRingi;
    /** 元利金払込日(修正) */
    private String ID_Date_GanrikinHaraiKomi_aRingi;
    /** 据置期限(修正) */
    private String ID_Date_SueokiKigen_aRingi;
    /** 特利有効期限(修正) */
    private String ID_Date_TokuriYuko_aRingi;
    /** 利率(修正) */
    private String ID_Riritsu_aRingi;
    /** 特利(修正) */
    private String ID_Tokuri_aRingi;
    /** ステータス(修正) */
    private String ID_Status;
    /** 報告書番号(修正) */
    private String ID_ID_Report;
    /** 時刻(修正) */
    private String ID_Time_Report;
    /** ユーザＩＤ(修正) */
    private String ID_User_ID;
    /** 伝送番号(修正) */
    private String ID_ID_Denso;
    /** データコード(修正) */
    private String ID_DataCode;
    /** 退避履歴番号(修正) */
    private String ID_Keep_ID_History;
    /** 充当順序変更区分(修正) */
    private String ID_Kubun_JutoJunjoHenko;
    /** 受託者勘定処理年月(赤)（入力値連結） */
    private String ID_Date_Jtkshori_Red_Input;
    /** 償還後第1回払込期日(修正)（入力値連結） */
    private String ID_Date_FirstHaraikomiAfterKurisho_Input;
    /** 入金日(修正)（入力値連結） */
    private String ID_Date_Nyukin_Input;
    /** 送金日(修正)（入力値連結） */
    private String ID_Date_Sokin_Input;
    /** 払込期日①(修正)（入力値連結） */
    private String ID_Date_Haraikomi1_Input;
    /** 払込期日②(修正)（入力値連結） */
    private String ID_Date_Haraikomi2_Input;
    /** 払込期日③(修正)（入力値連結） */
    private String ID_Date_Haraikomi3_Input;
    /** 払込期日④(修正)（入力値連結） */
    private String ID_Date_Haraikomi4_Input;
    /** 受託者勘定処理年月(修正)（入力値連結） */
    private String ID_Date_Jtkshori_Input;
    /** 元金(DB取得値) */
    private String ID_M_KurishoGankin_Save;
    /** 繰償後残元金(DB取得値) */
    private String ID_M_ZanGankinAfterKurisho_Save;
    /** 償還後第1回払込期日(DB取得値) */
    private String ID_Date_FirstHaraikomiAfterKurisho_Save;
    /** 請求データ更新フラグ */
    private boolean flgSeikyuUpdate;
    /** 請求データ更新用約定元金 */
    private String ID_M_YakujoGankin_Seikyu;
    /** 請求データ更新用約定利息 */
    private String ID_M_YakujoRisoku_Seikyu;
    /** 請求データ更新用払込期日 */
    private String ID_Date_Haraikomi_Seikyu;
    /** 払出データ貸付受入金残高 */
    private String ID_M_KashitsukeUkeire;
    /** SAVEデータの条変起案中区分 */
    private String Save_ID_Kubun_JohenKianchu;
    /** SAVEデータの賦金 */
    private String Save_ID_M_Fukin;
    /** SAVEデータの元金不均等額 */
    private String Save_ID_M_GankinFukinto;
    /** SAVEデータの償還期限年月 */
    private String Save_ID_Date_ShokanKigen;
    /** SAVEデータの約定元金 */
    private String Save_ID_M_YakujoGankin;
    /** SAVEデータの約定利息 */
    private String Save_ID_M_YakujoRisoku;
    /** SAVEデータの調整コード */
    private String Save_ID_Code_Chosei;
    /** SAVEデータの貸付残高 */
    private String Save_ID_M_KashitsukeZan;
    /** 報告時分秒(非表示) */
    private String ID_Time_Report_H;
    /** 報告書番号(非表示) */
    private String ID_ID_Report_H;
    /** 処理種別 */
    private String ID_Type_Process;
    /** 報告書種別（値）(受渡) */
    private String ID_DataCode_H;
    /** ステータス(受渡) */
    private String ID_Status_H;
    /** 操作選択 */
    private String ID_SelectOperation;
    /** 処理種別(受渡) */
    private String ID_Type_Process_H;
    /** 赤データ入力領域 */
    private String redArea;
    /** 黒データ入力領域 */
    private String blackArea;

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
     * コメントを取得します。
     * @return コメント
     */
    public String getLblComment() {
        return lblComment;
    }

    /**
     * コメントを設定します。
     * @param lblComment コメント
     */
    public void setLblComment(String lblComment) {
        this.lblComment = lblComment;
    }

    /**
     * ヘッダー表示（上）を取得します。
     * @return ヘッダー表示（上）
     */
    public String getLblID_Head_Red() {
        return lblID_Head_Red;
    }

    /**
     * ヘッダー表示（上）を設定します。
     * @param lblID_Head_Red ヘッダー表示（上）
     */
    public void setLblID_Head_Red(String lblID_Head_Red) {
        this.lblID_Head_Red = lblID_Head_Red;
    }

    /**
     * ヘッダー表示（上赤）を取得します。
     * @return ヘッダー表示（上赤）
     */
    public String getLblID_Head_Red2() {
        return lblID_Head_Red2;
    }

    /**
     * ヘッダー表示（上赤）を設定します。
     * @param lblID_Head_Red2 ヘッダー表示（上赤）
     */
    public void setLblID_Head_Red2(String lblID_Head_Red2) {
        this.lblID_Head_Red2 = lblID_Head_Red2;
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getLblID_Name_Customer_Red() {
        return lblID_Name_Customer_Red;
    }

    /**
     * 顧客名を設定します。
     * @param lblID_Name_Customer_Red 顧客名
     */
    public void setLblID_Name_Customer_Red(String lblID_Name_Customer_Red) {
        this.lblID_Name_Customer_Red = lblID_Name_Customer_Red;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization_Red() {
        return lblID_Name_Organization_Red;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization_Red 扱店名
     */
    public void setLblID_Name_Organization_Red(String lblID_Name_Organization_Red) {
        this.lblID_Name_Organization_Red = lblID_Name_Organization_Red;
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getLblID_Code_KoukoShiten_Red() {
        return lblID_Code_KoukoShiten_Red;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_KoukoShiten_Red 公庫支店
     */
    public void setLblID_Code_KoukoShiten_Red(String lblID_Code_KoukoShiten_Red) {
        this.lblID_Code_KoukoShiten_Red = lblID_Code_KoukoShiten_Red;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization_Red() {
        return lblID_Code_Organization_Red;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization_Red 扱店
     */
    public void setLblID_Code_Organization_Red(String lblID_Code_Organization_Red) {
        this.lblID_Code_Organization_Red = lblID_Code_Organization_Red;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo_Red() {
        return lblID_Code_Tenpo_Red;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo_Red 店舗
     */
    public void setLblID_Code_Tenpo_Red(String lblID_Code_Tenpo_Red) {
        this.lblID_Code_Tenpo_Red = lblID_Code_Tenpo_Red;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getLblID_Year_Red() {
        return lblID_Year_Red;
    }

    /**
     * 年度を設定します。
     * @param lblID_Year_Red 年度
     */
    public void setLblID_Year_Red(String lblID_Year_Red) {
        this.lblID_Year_Red = lblID_Year_Red;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getLblID_Code_HoshikiShikin_Red() {
        return lblID_Code_HoshikiShikin_Red;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Code_HoshikiShikin_Red 方式資金
     */
    public void setLblID_Code_HoshikiShikin_Red(String lblID_Code_HoshikiShikin_Red) {
        this.lblID_Code_HoshikiShikin_Red = lblID_Code_HoshikiShikin_Red;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getLblID_ID_Ringi_Red() {
        return lblID_ID_Ringi_Red;
    }

    /**
     * 番号を設定します。
     * @param lblID_ID_Ringi_Red 番号
     */
    public void setLblID_ID_Ringi_Red(String lblID_ID_Ringi_Red) {
        this.lblID_ID_Ringi_Red = lblID_ID_Ringi_Red;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch_Red() {
        return lblID_ID_RingiBranch_Red;
    }

    /**
     * 枝番を設定します。
     * @param lblID_ID_RingiBranch_Red 枝番
     */
    public void setLblID_ID_RingiBranch_Red(String lblID_ID_RingiBranch_Red) {
        this.lblID_ID_RingiBranch_Red = lblID_ID_RingiBranch_Red;
    }

    /**
     * 償還後第1回払込期日を取得します。
     * @return 償還後第1回払込期日
     */
    public String getLblID_Date_FirstHaraikomiAfterKurisho_Red() {
        return lblID_Date_FirstHaraikomiAfterKurisho_Red;
    }

    /**
     * 償還後第1回払込期日を設定します。
     * @param lblID_Date_FirstHaraikomiAfterKurisho_Red 償還後第1回払込期日
     */
    public void setLblID_Date_FirstHaraikomiAfterKurisho_Red(String lblID_Date_FirstHaraikomiAfterKurisho_Red) {
        this.lblID_Date_FirstHaraikomiAfterKurisho_Red = lblID_Date_FirstHaraikomiAfterKurisho_Red;
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getLblID_Date_Nyukin_Red() {
        return lblID_Date_Nyukin_Red;
    }

    /**
     * 入金日を設定します。
     * @param lblID_Date_Nyukin_Red 入金日
     */
    public void setLblID_Date_Nyukin_Red(String lblID_Date_Nyukin_Red) {
        this.lblID_Date_Nyukin_Red = lblID_Date_Nyukin_Red;
    }

    /**
     * 繰償事由コードを取得します。
     * @return 繰償事由コード
     */
    public String getLblID_Code_Kurishojiyu_Red() {
        return lblID_Code_Kurishojiyu_Red;
    }

    /**
     * 繰償事由コードを設定します。
     * @param lblID_Code_Kurishojiyu_Red 繰償事由コード
     */
    public void setLblID_Code_Kurishojiyu_Red(String lblID_Code_Kurishojiyu_Red) {
        this.lblID_Code_Kurishojiyu_Red = lblID_Code_Kurishojiyu_Red;
    }

    /**
     * 利息(円)を取得します。
     * @return 利息(円)
     */
    public String getLblID_M_KurishoRisoku_Red() {
        return lblID_M_KurishoRisoku_Red;
    }

    /**
     * 利息(円)を設定します。
     * @param lblID_M_KurishoRisoku_Red 利息(円)
     */
    public void setLblID_M_KurishoRisoku_Red(String lblID_M_KurishoRisoku_Red) {
        this.lblID_M_KurishoRisoku_Red = lblID_M_KurishoRisoku_Red;
    }

    /**
     * 元金(円)を取得します。
     * @return 元金(円)
     */
    public String getLblID_M_KurishoGankin_Red() {
        return lblID_M_KurishoGankin_Red;
    }

    /**
     * 元金(円)を設定します。
     * @param lblID_M_KurishoGankin_Red 元金(円)
     */
    public void setLblID_M_KurishoGankin_Red(String lblID_M_KurishoGankin_Red) {
        this.lblID_M_KurishoGankin_Red = lblID_M_KurishoGankin_Red;
    }

    /**
     * 控除利息(円)を取得します。
     * @return 控除利息(円)
     */
    public String getLblID_M_KojoRisoku_Red() {
        return lblID_M_KojoRisoku_Red;
    }

    /**
     * 控除利息(円)を設定します。
     * @param lblID_M_KojoRisoku_Red 控除利息(円)
     */
    public void setLblID_M_KojoRisoku_Red(String lblID_M_KojoRisoku_Red) {
        this.lblID_M_KojoRisoku_Red = lblID_M_KojoRisoku_Red;
    }

    /**
     * 繰上償還手数料(円)を取得します。
     * @return 繰上償還手数料(円)
     */
    public String getLblID_M_KurishoCommission_Red() {
        return lblID_M_KurishoCommission_Red;
    }

    /**
     * 繰上償還手数料(円)を設定します。
     * @param lblID_M_KurishoCommission_Red 繰上償還手数料(円)
     */
    public void setLblID_M_KurishoCommission_Red(String lblID_M_KurishoCommission_Red) {
        this.lblID_M_KurishoCommission_Red = lblID_M_KurishoCommission_Red;
    }

    /**
     * 仮受金からの充当額(円)を取得します。
     * @return 仮受金からの充当額(円)
     */
    public String getLblID_M_KariukeIppanJuto_Red() {
        return lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金からの充当額(円)を設定します。
     * @param lblID_M_KariukeIppanJuto_Red 仮受金からの充当額(円)
     */
    public void setLblID_M_KariukeIppanJuto_Red(String lblID_M_KariukeIppanJuto_Red) {
        this.lblID_M_KariukeIppanJuto_Red = lblID_M_KariukeIppanJuto_Red;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public String getLblID_M_Sokin_Red() {
        return lblID_M_Sokin_Red;
    }

    /**
     * 送金額(円)を設定します。
     * @param lblID_M_Sokin_Red 送金額(円)
     */
    public void setLblID_M_Sokin_Red(String lblID_M_Sokin_Red) {
        this.lblID_M_Sokin_Red = lblID_M_Sokin_Red;
    }

    /**
     * 繰償後残元金(円)を取得します。
     * @return 繰償後残元金(円)
     */
    public String getLblID_M_ZanGankinAfterKurisho_Red() {
        return lblID_M_ZanGankinAfterKurisho_Red;
    }

    /**
     * 繰償後残元金(円)を設定します。
     * @param lblID_M_ZanGankinAfterKurisho_Red 繰償後残元金(円)
     */
    public void setLblID_M_ZanGankinAfterKurisho_Red(String lblID_M_ZanGankinAfterKurisho_Red) {
        this.lblID_M_ZanGankinAfterKurisho_Red = lblID_M_ZanGankinAfterKurisho_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_JtkShori_Red() {
        return lblID_Date_JtkShori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param lblID_Date_JtkShori_Red 受託者勘定処理年月
     */
    public void setLblID_Date_JtkShori_Red(String lblID_Date_JtkShori_Red) {
        this.lblID_Date_JtkShori_Red = lblID_Date_JtkShori_Red;
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getLblID_Date_Sokin_Red() {
        return lblID_Date_Sokin_Red;
    }

    /**
     * 送金日を設定します。
     * @param lblID_Date_Sokin_Red 送金日
     */
    public void setLblID_Date_Sokin_Red(String lblID_Date_Sokin_Red) {
        this.lblID_Date_Sokin_Red = lblID_Date_Sokin_Red;
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi_Red() {
        return lblID_ID_Sokinbi_Red;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_ID_Sokinbi_Red 送金日番号
     */
    public void setLblID_ID_Sokinbi_Red(String lblID_ID_Sokinbi_Red) {
        this.lblID_ID_Sokinbi_Red = lblID_ID_Sokinbi_Red;
    }

    /**
     * 代弁履行後の作成を取得します。
     * @return 代弁履行後の作成
     */
    public String getChkID_ID_After_Daiibensai_Red() {
        return chkID_ID_After_Daiibensai_Red;
    }

    /**
     * 代弁履行後の作成を設定します。
     * @param chkID_ID_After_Daiibensai_Red 代弁履行後の作成
     */
    public void setChkID_ID_After_Daiibensai_Red(String chkID_ID_After_Daiibensai_Red) {
        this.chkID_ID_After_Daiibensai_Red = chkID_ID_After_Daiibensai_Red;
    }

    /**
     * 払込期日①を取得します。
     * @return 払込期日①
     */
    public String getLblID_Date_Haraikomi1_Red() {
        return lblID_Date_Haraikomi1_Red;
    }

    /**
     * 払込期日①を設定します。
     * @param lblID_Date_Haraikomi1_Red 払込期日①
     */
    public void setLblID_Date_Haraikomi1_Red(String lblID_Date_Haraikomi1_Red) {
        this.lblID_Date_Haraikomi1_Red = lblID_Date_Haraikomi1_Red;
    }

    /**
     * 払込期日②を取得します。
     * @return 払込期日②
     */
    public String getLblID_Date_Haraikomi2_Red() {
        return lblID_Date_Haraikomi2_Red;
    }

    /**
     * 払込期日②を設定します。
     * @param lblID_Date_Haraikomi2_Red 払込期日②
     */
    public void setLblID_Date_Haraikomi2_Red(String lblID_Date_Haraikomi2_Red) {
        this.lblID_Date_Haraikomi2_Red = lblID_Date_Haraikomi2_Red;
    }

    /**
     * 払込期日③を取得します。
     * @return 払込期日③
     */
    public String getLblID_Date_Haraikomi3_Red() {
        return lblID_Date_Haraikomi3_Red;
    }

    /**
     * 払込期日③を設定します。
     * @param lblID_Date_Haraikomi3_Red 払込期日③
     */
    public void setLblID_Date_Haraikomi3_Red(String lblID_Date_Haraikomi3_Red) {
        this.lblID_Date_Haraikomi3_Red = lblID_Date_Haraikomi3_Red;
    }

    /**
     * 払込期日④を取得します。
     * @return 払込期日④
     */
    public String getLblID_Date_Haraikomi4_Red() {
        return lblID_Date_Haraikomi4_Red;
    }

    /**
     * 払込期日④を設定します。
     * @param lblID_Date_Haraikomi4_Red 払込期日④
     */
    public void setLblID_Date_Haraikomi4_Red(String lblID_Date_Haraikomi4_Red) {
        this.lblID_Date_Haraikomi4_Red = lblID_Date_Haraikomi4_Red;
    }

    /**
     * 払込元金(円)①を取得します。
     * @return 払込元金(円)①
     */
    public String getLblID_M_HaraikomiGankin1_Red() {
        return lblID_M_HaraikomiGankin1_Red;
    }

    /**
     * 払込元金(円)①を設定します。
     * @param lblID_M_HaraikomiGankin1_Red 払込元金(円)①
     */
    public void setLblID_M_HaraikomiGankin1_Red(String lblID_M_HaraikomiGankin1_Red) {
        this.lblID_M_HaraikomiGankin1_Red = lblID_M_HaraikomiGankin1_Red;
    }

    /**
     * 払込元金(円)②を取得します。
     * @return 払込元金(円)②
     */
    public String getLblID_M_HaraikomiGankin2_Red() {
        return lblID_M_HaraikomiGankin2_Red;
    }

    /**
     * 払込元金(円)②を設定します。
     * @param lblID_M_HaraikomiGankin2_Red 払込元金(円)②
     */
    public void setLblID_M_HaraikomiGankin2_Red(String lblID_M_HaraikomiGankin2_Red) {
        this.lblID_M_HaraikomiGankin2_Red = lblID_M_HaraikomiGankin2_Red;
    }

    /**
     * 払込元金(円)③を取得します。
     * @return 払込元金(円)③
     */
    public String getLblID_M_HaraikomiGankin3_Red() {
        return lblID_M_HaraikomiGankin3_Red;
    }

    /**
     * 払込元金(円)③を設定します。
     * @param lblID_M_HaraikomiGankin3_Red 払込元金(円)③
     */
    public void setLblID_M_HaraikomiGankin3_Red(String lblID_M_HaraikomiGankin3_Red) {
        this.lblID_M_HaraikomiGankin3_Red = lblID_M_HaraikomiGankin3_Red;
    }

    /**
     * 払込元金(円)④を取得します。
     * @return 払込元金(円)④
     */
    public String getLblID_M_HaraikomiGankin4_Red() {
        return lblID_M_HaraikomiGankin4_Red;
    }

    /**
     * 払込元金(円)④を設定します。
     * @param lblID_M_HaraikomiGankin4_Red 払込元金(円)④
     */
    public void setLblID_M_HaraikomiGankin4_Red(String lblID_M_HaraikomiGankin4_Red) {
        this.lblID_M_HaraikomiGankin4_Red = lblID_M_HaraikomiGankin4_Red;
    }

    /**
     * 繰償後元金均等額(円)を取得します。
     * @return 繰償後元金均等額(円)
     */
    public String getLblID_M_GankinKintoAfterKurisho_Red() {
        return lblID_M_GankinKintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金均等額(円)を設定します。
     * @param lblID_M_GankinKintoAfterKurisho_Red 繰償後元金均等額(円)
     */
    public void setLblID_M_GankinKintoAfterKurisho_Red(String lblID_M_GankinKintoAfterKurisho_Red) {
        this.lblID_M_GankinKintoAfterKurisho_Red = lblID_M_GankinKintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金不均等額(円)を取得します。
     * @return 繰償後元金不均等額(円)
     */
    public String getLblID_M_GankinFukintoAfterKurisho_Red() {
        return lblID_M_GankinFukintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金不均等額(円)を設定します。
     * @param lblID_M_GankinFukintoAfterKurisho_Red 繰償後元金不均等額(円)
     */
    public void setLblID_M_GankinFukintoAfterKurisho_Red(String lblID_M_GankinFukintoAfterKurisho_Red) {
        this.lblID_M_GankinFukintoAfterKurisho_Red = lblID_M_GankinFukintoAfterKurisho_Red;
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getRdoID_Code_chosei_Red() {
        return rdoID_Code_chosei_Red;
    }

    /**
     * 調整コードを設定します。
     * @param rdoID_Code_chosei_Red 調整コード
     */
    public void setRdoID_Code_chosei_Red(String rdoID_Code_chosei_Red) {
        this.rdoID_Code_chosei_Red = rdoID_Code_chosei_Red;
    }

    /**
     * ヘッダー表示（修正）を取得します。
     * @return ヘッダー表示（修正）
     */
    public String getLblID_Head() {
        return lblID_Head;
    }

    /**
     * ヘッダー表示（修正）を設定します。
     * @param lblID_Head ヘッダー表示（修正）
     */
    public void setLblID_Head(String lblID_Head) {
        this.lblID_Head = lblID_Head;
    }

    /**
     * 顧客名（修正）を取得します。
     * @return 顧客名（修正）
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名（修正）を設定します。
     * @param lblID_Name_Customer 顧客名（修正）
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }

    /**
     * 扱店名（修正）を取得します。
     * @return 扱店名（修正）
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名（修正）を設定します。
     * @param lblID_Name_Organization 扱店名（修正）
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 公庫支店（修正）を取得します。
     * @return 公庫支店（修正）
     */
    public String getLblID_Code_KoukoShiten() {
        return lblID_Code_KoukoShiten;
    }

    /**
     * 公庫支店（修正）を設定します。
     * @param lblID_Code_ShokanHonShiten 公庫支店（修正）
     */
    public void setLblID_Code_KoukoShiten(String lblID_Code_KoukoShiten) {
        this.lblID_Code_KoukoShiten = lblID_Code_KoukoShiten;
    }

    /**
     * 扱店（修正）を取得します。
     * @return 扱店（修正）
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店（修正）を設定します。
     * @param lblID_Code_Organization 扱店（修正）
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗（修正）を取得します。
     * @return 店舗（修正）
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗（修正）を設定します。
     * @param lblID_Code_Tenpo 店舗（修正）
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 年度（修正）を取得します。
     * @return 年度（修正）
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度（修正）を設定します。
     * @param lblID_Year 年度（修正）
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }

    /**
     * 方式資金（修正）を取得します。
     * @return 方式資金（修正）
     */
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金（修正）を設定します。
     * @param lblID_Code_HoshikiShikin 方式資金（修正）
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
    }

    /**
     * 番号（修正）を取得します。
     * @return 番号（修正）
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号（修正）を設定します。
     * @param lblID_ID_Ringi 番号（修正）
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }

    /**
     * 枝番（修正）を取得します。
     * @return 枝番（修正）
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番（修正）を設定します。
     * @param lblID_ID_RingiBranch 枝番（修正）
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }

    /**
     * 償還後第1回払込期日（修正）を取得します。
     * @return 償還後第1回払込期日（修正）
     */
    public String getLblID_Date_FirstHaraikomiAfterKurisho() {
        return lblID_Date_FirstHaraikomiAfterKurisho;
    }

    /**
     * 償還後第1回払込期日（修正）を設定します。
     * @param lblID_Date_FirstHaraikomiAfterKurisho 償還後第1回払込期日（修正）
     */
    public void setLblID_Date_FirstHaraikomiAfterKurisho(String lblID_Date_FirstHaraikomiAfterKurisho) {
        this.lblID_Date_FirstHaraikomiAfterKurisho = lblID_Date_FirstHaraikomiAfterKurisho;
    }

    /**
     * 入金日（修正）を取得します。
     * @return 入金日（修正）
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日（修正）を設定します。
     * @param lblID_Date_Nyukin 入金日（修正）
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }

    /**
     * 繰償事由コード（修正）を取得します。
     * @return 繰償事由コード（修正）
     */
    public String getLblID_Code_Kurishojiyu() {
        return lblID_Code_Kurishojiyu;
    }

    /**
     * 繰償事由コード（修正）を設定します。
     * @param lblID_Code_Kurishojiyu 繰償事由コード（修正）
     */
    public void setLblID_Code_Kurishojiyu(String lblID_Code_Kurishojiyu) {
        this.lblID_Code_Kurishojiyu = lblID_Code_Kurishojiyu;
    }

    /**
     * 利息(円)（修正）を取得します。
     * @return 利息(円)（修正）
     */
    public String getLblID_M_KurishoRisoku() {
        return lblID_M_KurishoRisoku;
    }

    /**
     * 利息(円)（修正）を設定します。
     * @param lblID_M_KurishoRisoku 利息(円)（修正）
     */
    public void setLblID_M_KurishoRisoku(String lblID_M_KurishoRisoku) {
        this.lblID_M_KurishoRisoku = lblID_M_KurishoRisoku;
    }

    /**
     * 元金(円)（修正）を取得します。
     * @return 元金(円)（修正）
     */
    public String getLblID_M_KurishoGankin() {
        return lblID_M_KurishoGankin;
    }

    /**
     * 元金(円)（修正）を設定します。
     * @param lblID_M_KurishoGankin 元金(円)（修正）
     */
    public void setLblID_M_KurishoGankin(String lblID_M_KurishoGankin) {
        this.lblID_M_KurishoGankin = lblID_M_KurishoGankin;
    }

    /**
     * 控除利息(円)（修正）を取得します。
     * @return 控除利息(円)（修正）
     */
    public String getLblID_M_KojoRisoku() {
        return lblID_M_KojoRisoku;
    }

    /**
     * 控除利息(円)（修正）を設定します。
     * @param lblID_M_KojoRisoku 控除利息(円)（修正）
     */
    public void setLblID_M_KojoRisoku(String lblID_M_KojoRisoku) {
        this.lblID_M_KojoRisoku = lblID_M_KojoRisoku;
    }

    /**
     * 繰上償還手数料(円)（修正）を取得します。
     * @return 繰上償還手数料(円)（修正）
     */
    public String getLblID_M_KurishoCommission() {
        return lblID_M_KurishoCommission;
    }

    /**
     * 繰上償還手数料(円)（修正）を設定します。
     * @param lblID_M_KurishoCommision 繰上償還手数料(円)（修正）
     */
    public void setLblID_M_KurishoCommission(String lblID_M_KurishoCommission) {
        this.lblID_M_KurishoCommission = lblID_M_KurishoCommission;
    }

    /**
     * 仮受金からの充当額(円)（修正）を取得します。
     * @return 仮受金からの充当額(円)（修正）
     */
    public String getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額(円)（修正）を設定します。
     * @param lblID_M_KariukeIppanJuto 仮受金からの充当額(円)（修正）
     */
    public void setLblID_M_KariukeIppanJuto(String lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }

    /**
     * 送金額(円)（修正）を取得します。
     * @return 送金額(円)（修正）
     */
    public String getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額(円)（修正）を設定します。
     * @param lblID_M_Sokin 送金額(円)（修正）
     */
    public void setLblID_M_Sokin(String lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
    }

    /**
     * 繰償後残元金(円)（修正）を取得します。
     * @return 繰償後残元金(円)（修正）
     */
    public String getLblID_M_ZanGankinAfterKurisho() {
        return lblID_M_ZanGankinAfterKurisho;
    }

    /**
     * 繰償後残元金(円)（修正）を設定します。
     * @param lblID_M_ZanGankinAfterKurisho 繰償後残元金(円)（修正）
     */
    public void setLblID_M_ZanGankinAfterKurisho(String lblID_M_ZanGankinAfterKurisho) {
        this.lblID_M_ZanGankinAfterKurisho = lblID_M_ZanGankinAfterKurisho;
    }

    /**
     * 受託者勘定処理年月（修正）を取得します。
     * @return 受託者勘定処理年月（修正）
     */
    public String getLblID_Date_JtkShori() {
        return lblID_Date_JtkShori;
    }

    /**
     * 受託者勘定処理年月（修正）を設定します。
     * @param lblID_Date_JtkShori 受託者勘定処理年月（修正）
     */
    public void setLblID_Date_JtkShori(String lblID_Date_JtkShori) {
        this.lblID_Date_JtkShori = lblID_Date_JtkShori;
    }

    /**
     * 送金日（修正）を取得します。
     * @return 送金日（修正）
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金日（修正）を設定します。
     * @param lblID_Date_Sokin 送金日（修正）
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }

    /**
     * 送金日番号（修正）を取得します。
     * @return 送金日番号（修正）
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号（修正）を設定します。
     * @param lblID_ID_Sokinbi 送金日番号（修正）
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
    }

    /**
     * 代弁履行後の作成（修正）を取得します。
     * @return 代弁履行後の作成（修正）
     */
    public String getChkID_ID_After_Daiibensai() {
        return chkID_ID_After_Daiibensai;
    }

    /**
     * 代弁履行後の作成（修正）を設定します。
     * @param chkID_ID_After_Daiibensai 代弁履行後の作成（修正）
     */
    public void setChkID_ID_After_Daiibensai(String chkID_ID_After_Daiibensai) {
        this.chkID_ID_After_Daiibensai = chkID_ID_After_Daiibensai;
    }

    /**
     * 払込期日①（修正）を取得します。
     * @return 払込期日①（修正）
     */
    public String getLblID_Date_Haraikomi1() {
        return lblID_Date_Haraikomi1;
    }

    /**
     * 払込期日①（修正）を設定します。
     * @param lblID_Date_Haraikomi1 払込期日①（修正）
     */
    public void setLblID_Date_Haraikomi1(String lblID_Date_Haraikomi1) {
        this.lblID_Date_Haraikomi1 = lblID_Date_Haraikomi1;
    }

    /**
     * 払込期日②（修正）を取得します。
     * @return 払込期日②（修正）
     */
    public String getLblID_Date_Haraikomi2() {
        return lblID_Date_Haraikomi2;
    }

    /**
     * 払込期日②（修正）を設定します。
     * @param lblID_Date_Haraikomi2 払込期日②（修正）
     */
    public void setLblID_Date_Haraikomi2(String lblID_Date_Haraikomi2) {
        this.lblID_Date_Haraikomi2 = lblID_Date_Haraikomi2;
    }

    /**
     * 払込期日③（修正）を取得します。
     * @return 払込期日③（修正）
     */
    public String getLblID_Date_Haraikomi3() {
        return lblID_Date_Haraikomi3;
    }

    /**
     * 払込期日③（修正）を設定します。
     * @param lblID_Date_Haraikomi3 払込期日③（修正）
     */
    public void setLblID_Date_Haraikomi3(String lblID_Date_Haraikomi3) {
        this.lblID_Date_Haraikomi3 = lblID_Date_Haraikomi3;
    }

    /**
     * 払込期日④（修正）を取得します。
     * @return 払込期日④（修正）
     */
    public String getLblID_Date_Haraikomi4() {
        return lblID_Date_Haraikomi4;
    }

    /**
     * 払込期日④（修正）を設定します。
     * @param lblID_Date_Haraikomi4 払込期日④（修正）
     */
    public void setLblID_Date_Haraikomi4(String lblID_Date_Haraikomi4) {
        this.lblID_Date_Haraikomi4 = lblID_Date_Haraikomi4;
    }

    /**
     * 払込元金(円)①（修正）を取得します。
     * @return 払込元金(円)①（修正）
     */
    public String getLblID_M_HaraikomiGankin1() {
        return lblID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金(円)①（修正）を設定します。
     * @param lblID_M_HaraikomiGankin1 払込元金(円)①（修正）
     */
    public void setLblID_M_HaraikomiGankin1(String lblID_M_HaraikomiGankin1) {
        this.lblID_M_HaraikomiGankin1 = lblID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金(円)②（修正）を取得します。
     * @return 払込元金(円)②（修正）
     */
    public String getLblID_M_HaraikomiGankin2() {
        return lblID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金(円)②（修正）を設定します。
     * @param lblID_M_HaraikomiGankin2 払込元金(円)②（修正）
     */
    public void setLblID_M_HaraikomiGankin2(String lblID_M_HaraikomiGankin2) {
        this.lblID_M_HaraikomiGankin2 = lblID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金(円)③（修正）を取得します。
     * @return 払込元金(円)③（修正）
     */
    public String getLblID_M_HaraikomiGankin3() {
        return lblID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金(円)③（修正）を設定します。
     * @param lblID_M_HaraikomiGankin3 払込元金(円)③（修正）
     */
    public void setLblID_M_HaraikomiGankin3(String lblID_M_HaraikomiGankin3) {
        this.lblID_M_HaraikomiGankin3 = lblID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金(円)④（修正）を取得します。
     * @return 払込元金(円)④（修正）
     */
    public String getLblID_M_HaraikomiGankin4() {
        return lblID_M_HaraikomiGankin4;
    }

    /**
     * 払込元金(円)④（修正）を設定します。
     * @param lblID_M_HaraikomiGankin4 払込元金(円)④（修正）
     */
    public void setLblID_M_HaraikomiGankin4(String lblID_M_HaraikomiGankin4) {
        this.lblID_M_HaraikomiGankin4 = lblID_M_HaraikomiGankin4;
    }

    /**
     * 繰償後元金均等額(円)（修正）を取得します。
     * @return 繰償後元金均等額(円)（修正）
     */
    public String getLblID_M_GankinKintoAfterKurisho() {
        return lblID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金均等額(円)（修正）を設定します。
     * @param lblID_M_GankinKintoAfterKurisho 繰償後元金均等額(円)（修正）
     */
    public void setLblID_M_GankinKintoAfterKurisho(String lblID_M_GankinKintoAfterKurisho) {
        this.lblID_M_GankinKintoAfterKurisho = lblID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額(円)（修正）を取得します。
     * @return 繰償後元金不均等額(円)（修正）
     */
    public String getLblID_M_GankinFukintoAfterKurisho() {
        return lblID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額(円)（修正）を設定します。
     * @param lblID_M_GankinFukintoAfterKurisho 繰償後元金不均等額(円)（修正）
     */
    public void setLblID_M_GankinFukintoAfterKurisho(String lblID_M_GankinFukintoAfterKurisho) {
        this.lblID_M_GankinFukintoAfterKurisho = lblID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 調整コード（修正）を取得します。
     * @return 調整コード（修正）
     */
    public String getRdoID_Code_chosei() {
        return rdoID_Code_chosei;
    }

    /**
     * 調整コード（修正）を設定します。
     * @param rdoID_Code_chosei 調整コード（修正）
     */
    public void setRdoID_Code_chosei(String rdoID_Code_chosei) {
        this.rdoID_Code_chosei = rdoID_Code_chosei;
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
     * 償還後第1回払込期日を取得します。
     * @return 償還後第1回払込期日
     */
    public String getTxtID_Date_FirstHaraikomiAfterKurisho_Red() {
        return txtID_Date_FirstHaraikomiAfterKurisho_Red;
    }

    /**
     * 償還後第1回払込期日を設定します。
     * @param txtID_Date_FirstHaraikomiAfterKurisho_Red 償還後第1回払込期日
     */
    public void setTxtID_Date_FirstHaraikomiAfterKurisho_Red(String txtID_Date_FirstHaraikomiAfterKurisho_Red) {
        this.txtID_Date_FirstHaraikomiAfterKurisho_Red = txtID_Date_FirstHaraikomiAfterKurisho_Red;
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
     * 繰償事由コードを取得します。
     * @return 繰償事由コード
     */
    public String getTxtID_Code_Kurishojiyu_Red() {
        return txtID_Code_Kurishojiyu_Red;
    }

    /**
     * 繰償事由コードを設定します。
     * @param txtID_Code_Kurishojiyu_Red 繰償事由コード
     */
    public void setTxtID_Code_Kurishojiyu_Red(String txtID_Code_Kurishojiyu_Red) {
        this.txtID_Code_Kurishojiyu_Red = txtID_Code_Kurishojiyu_Red;
    }

    /**
     * 利息(円)を取得します。
     * @return 利息(円)
     */
    public String getTxtID_M_KurishoRisoku_Red() {
        return txtID_M_KurishoRisoku_Red;
    }

    /**
     * 利息(円)を設定します。
     * @param txtID_M_KurishoRisoku_Red 利息(円)
     */
    public void setTxtID_M_KurishoRisoku_Red(String txtID_M_KurishoRisoku_Red) {
        this.txtID_M_KurishoRisoku_Red = txtID_M_KurishoRisoku_Red;
    }

    /**
     * 元金(円)を取得します。
     * @return 元金(円)
     */
    public String getTxtID_M_KurishoGankin_Red() {
        return txtID_M_KurishoGankin_Red;
    }

    /**
     * 元金(円)を設定します。
     * @param txtID_M_KurishoGankin_Red 元金(円)
     */
    public void setTxtID_M_KurishoGankin_Red(String txtID_M_KurishoGankin_Red) {
        this.txtID_M_KurishoGankin_Red = txtID_M_KurishoGankin_Red;
    }

    /**
     * 控除利息(円)を取得します。
     * @return 控除利息(円)
     */
    public String getTxtID_M_KojoRisoku_Red() {
        return txtID_M_KojoRisoku_Red;
    }

    /**
     * 控除利息(円)を設定します。
     * @param txtID_M_KojoRisoku_Red 控除利息(円)
     */
    public void setTxtID_M_KojoRisoku_Red(String txtID_M_KojoRisoku_Red) {
        this.txtID_M_KojoRisoku_Red = txtID_M_KojoRisoku_Red;
    }

    /**
     * 繰上償還手数料(円)を取得します。
     * @return 繰上償還手数料(円)
     */
    public String getTxtID_M_KurishoCommission_Red() {
        return txtID_M_KurishoCommission_Red;
    }

    /**
     * 繰上償還手数料(円)を設定します。
     * @param txtID_M_KurishoCommission_Red 繰上償還手数料(円)
     */
    public void setTxtID_M_KurishoCommission_Red(String txtID_M_KurishoCommission_Red) {
        this.txtID_M_KurishoCommission_Red = txtID_M_KurishoCommission_Red;
    }

    /**
     * 仮受金からの充当額(円)を取得します。
     * @return 仮受金からの充当額(円)
     */
    public String getTxtID_M_KariukeIppanJuto_Red() {
        return txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 仮受金からの充当額(円)を設定します。
     * @param txtID_M_KariukeIppanJuto_Red 仮受金からの充当額(円)
     */
    public void setTxtID_M_KariukeIppanJuto_Red(String txtID_M_KariukeIppanJuto_Red) {
        this.txtID_M_KariukeIppanJuto_Red = txtID_M_KariukeIppanJuto_Red;
    }

    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public String getTxtID_M_Sokin_Red() {
        return txtID_M_Sokin_Red;
    }

    /**
     * 送金額(円)を設定します。
     * @param txtID_M_Sokin_Red 送金額(円)
     */
    public void setTxtID_M_Sokin_Red(String txtID_M_Sokin_Red) {
        this.txtID_M_Sokin_Red = txtID_M_Sokin_Red;
    }

    /**
     * 繰償後残元金(円)を取得します。
     * @return 繰償後残元金(円)
     */
    public String getTxtID_M_ZanGankinAfterKurisho_Red() {
        return txtID_M_ZanGankinAfterKurisho_Red;
    }

    /**
     * 繰償後残元金(円)を設定します。
     * @param txtID_M_ZanGankinAfterKurisho_Red 繰償後残元金(円)
     */
    public void setTxtID_M_ZanGankinAfterKurisho_Red(String txtID_M_ZanGankinAfterKurisho_Red) {
        this.txtID_M_ZanGankinAfterKurisho_Red = txtID_M_ZanGankinAfterKurisho_Red;
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getTxtID_Date_JtkShori_Red() {
        return txtID_Date_JtkShori_Red;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param txtID_Date_JtkShori_Red 受託者勘定処理年月
     */
    public void setTxtID_Date_JtkShori_Red(String txtID_Date_JtkShori_Red) {
        this.txtID_Date_JtkShori_Red = txtID_Date_JtkShori_Red;
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
     * 払込期日①を取得します。
     * @return 払込期日①
     */
    public String getTxtID_Date_Haraikomi1_Red() {
        return txtID_Date_Haraikomi1_Red;
    }

    /**
     * 払込期日①を設定します。
     * @param txtID_Date_Haraikomi1_Red 払込期日①
     */
    public void setTxtID_Date_Haraikomi1_Red(String txtID_Date_Haraikomi1_Red) {
        this.txtID_Date_Haraikomi1_Red = txtID_Date_Haraikomi1_Red;
    }

    /**
     * 払込期日②を取得します。
     * @return 払込期日②
     */
    public String getTxtID_Date_Haraikomi2_Red() {
        return txtID_Date_Haraikomi2_Red;
    }

    /**
     * 払込期日②を設定します。
     * @param txtID_Date_Haraikomi2_Red 払込期日②
     */
    public void setTxtID_Date_Haraikomi2_Red(String txtID_Date_Haraikomi2_Red) {
        this.txtID_Date_Haraikomi2_Red = txtID_Date_Haraikomi2_Red;
    }

    /**
     * 払込期日③を取得します。
     * @return 払込期日③
     */
    public String getTxtID_Date_Haraikomi3_Red() {
        return txtID_Date_Haraikomi3_Red;
    }

    /**
     * 払込期日③を設定します。
     * @param txtID_Date_Haraikomi3_Red 払込期日③
     */
    public void setTxtID_Date_Haraikomi3_Red(String txtID_Date_Haraikomi3_Red) {
        this.txtID_Date_Haraikomi3_Red = txtID_Date_Haraikomi3_Red;
    }

    /**
     * 払込期日④を取得します。
     * @return 払込期日④
     */
    public String getTxtID_Date_Haraikomi4_Red() {
        return txtID_Date_Haraikomi4_Red;
    }

    /**
     * 払込期日④を設定します。
     * @param txtID_Date_Haraikomi4_Red 払込期日④
     */
    public void setTxtID_Date_Haraikomi4_Red(String txtID_Date_Haraikomi4_Red) {
        this.txtID_Date_Haraikomi4_Red = txtID_Date_Haraikomi4_Red;
    }

    /**
     * 払込元金①を取得します。
     * @return 払込元金①
     */
    public String getTxtID_M_HaraikomiGankin1_Red() {
        return txtID_M_HaraikomiGankin1_Red;
    }

    /**
     * 払込元金①を設定します。
     * @param txtID_M_HaraikomiGankin1_Red 払込元金①
     */
    public void setTxtID_M_HaraikomiGankin1_Red(String txtID_M_HaraikomiGankin1_Red) {
        this.txtID_M_HaraikomiGankin1_Red = txtID_M_HaraikomiGankin1_Red;
    }

    /**
     * 払込元金②を取得します。
     * @return 払込元金②
     */
    public String getTxtID_M_HaraikomiGankin2_Red() {
        return txtID_M_HaraikomiGankin2_Red;
    }

    /**
     * 払込元金②を設定します。
     * @param txtID_M_HaraikomiGankin2_Red 払込元金②
     */
    public void setTxtID_M_HaraikomiGankin2_Red(String txtID_M_HaraikomiGankin2_Red) {
        this.txtID_M_HaraikomiGankin2_Red = txtID_M_HaraikomiGankin2_Red;
    }

    /**
     * 払込元金③を取得します。
     * @return 払込元金③
     */
    public String getTxtID_M_HaraikomiGankin3_Red() {
        return txtID_M_HaraikomiGankin3_Red;
    }

    /**
     * 払込元金③を設定します。
     * @param txtID_M_HaraikomiGankin3_Red 払込元金③
     */
    public void setTxtID_M_HaraikomiGankin3_Red(String txtID_M_HaraikomiGankin3_Red) {
        this.txtID_M_HaraikomiGankin3_Red = txtID_M_HaraikomiGankin3_Red;
    }

    /**
     * 払込元金④を取得します。
     * @return 払込元金④
     */
    public String getTxtID_M_HaraikomiGankin4_Red() {
        return txtID_M_HaraikomiGankin4_Red;
    }

    /**
     * 払込元金④を設定します。
     * @param txtID_M_HaraikomiGankin4_Red 払込元金④
     */
    public void setTxtID_M_HaraikomiGankin4_Red(String txtID_M_HaraikomiGankin4_Red) {
        this.txtID_M_HaraikomiGankin4_Red = txtID_M_HaraikomiGankin4_Red;
    }

    /**
     * 繰償後元金均等額(円)を取得します。
     * @return 繰償後元金均等額(円)
     */
    public String getTxtID_M_GankinKintoAfterKurisho_Red() {
        return txtID_M_GankinKintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金均等額(円)を設定します。
     * @param txtID_M_GankinKintoAfterKurisho_Red 繰償後元金均等額(円)
     */
    public void setTxtID_M_GankinKintoAfterKurisho_Red(String txtID_M_GankinKintoAfterKurisho_Red) {
        this.txtID_M_GankinKintoAfterKurisho_Red = txtID_M_GankinKintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金不均等額(円)を取得します。
     * @return 繰償後元金不均等額(円)
     */
    public String getTxtID_M_GankinFukintoAfterKurisho_Red() {
        return txtID_M_GankinFukintoAfterKurisho_Red;
    }

    /**
     * 繰償後元金不均等額(円)を設定します。
     * @param txtID_M_GankinFukintoAfterKurisho_Red 繰償後元金不均等額(円)
     */
    public void setTxtID_M_GankinFukintoAfterKurisho_Red(String txtID_M_GankinFukintoAfterKurisho_Red) {
        this.txtID_M_GankinFukintoAfterKurisho_Red = txtID_M_GankinFukintoAfterKurisho_Red;
    }

    /**
     * 受託者勘定処理年月(元号)を取得します。
     * @return 受託者勘定処理年月(元号)
     */
    public String getID_Date_Jtkshori_Gengo_Red() {
        return ID_Date_Jtkshori_Gengo_Red;
    }

    /**
     * 受託者勘定処理年月(元号)を設定します。
     * @param ID_Date_Jtkshori_Gengo_Red 受託者勘定処理年月(元号)
     */
    public void setID_Date_Jtkshori_Gengo_Red(String ID_Date_Jtkshori_Gengo_Red) {
        this.ID_Date_Jtkshori_Gengo_Red = ID_Date_Jtkshori_Gengo_Red;
    }

    /**
     * 受託者勘定処理年月(年)を取得します。
     * @return 受託者勘定処理年月(年)
     */
    public String getID_Date_Jtkshori_Nen_Red() {
        return ID_Date_Jtkshori_Nen_Red;
    }

    /**
     * 受託者勘定処理年月(年)を設定します。
     * @param ID_Date_Jtkshori_Nen_Red 受託者勘定処理年月(年)
     */
    public void setID_Date_Jtkshori_Nen_Red(String ID_Date_Jtkshori_Nen_Red) {
        this.ID_Date_Jtkshori_Nen_Red = ID_Date_Jtkshori_Nen_Red;
    }

    /**
     * 受託者勘定処理年月(月)を取得します。
     * @return 受託者勘定処理年月(月)
     */
    public String getDrpID_Date_JtkshoriTsuki_Red() {
        return drpID_Date_JtkshoriTsuki_Red;
    }

    /**
     * 受託者勘定処理年月(月)を設定します。
     * @param drpID_Date_JtkshoriTsuki_Red 受託者勘定処理年月(月)
     */
    public void setDrpID_Date_JtkshoriTsuki_Red(String drpID_Date_JtkshoriTsuki_Red) {
        this.drpID_Date_JtkshoriTsuki_Red = drpID_Date_JtkshoriTsuki_Red;
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
     * 償還後第1回払込期（元号）（修正）を取得します。
     * @return 償還後第1回払込期（元号）（修正）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Gengo() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    }

    /**
     * 償還後第1回払込期（元号）（修正）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Gengo 償還後第1回払込期（元号）（修正）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Gengo(
            String drpID_Date_FirstHaraikomiAfterKurisho_Gengo) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Gengo = drpID_Date_FirstHaraikomiAfterKurisho_Gengo;
    }

    /**
     * 償還後第1回払込期（年）（修正）を取得します。
     * @return 償還後第1回払込期（年）（修正）
     */
    public String getTxtID_Date_FirstHaraikomiAfterKurisho_Nen() {
        return txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    }

    /**
     * 償還後第1回払込期（年）（修正）を設定します。
     * @param txtID_Date_FirstHaraikomiAfterKurisho_Nen 償還後第1回払込期（年）（修正）
     */
    public void setTxtID_Date_FirstHaraikomiAfterKurisho_Nen(String txtID_Date_FirstHaraikomiAfterKurisho_Nen) {
        this.txtID_Date_FirstHaraikomiAfterKurisho_Nen = txtID_Date_FirstHaraikomiAfterKurisho_Nen;
    }

    /**
     * 償還後第1回払込期（月）（修正）を取得します。
     * @return 償還後第1回払込期（月）（修正）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Tsuki() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    }

    /**
     * 償還後第1回払込期（月）（修正）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Tsuki 償還後第1回払込期（月）（修正）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Tsuki(
            String drpID_Date_FirstHaraikomiAfterKurisho_Tsuki) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Tsuki = drpID_Date_FirstHaraikomiAfterKurisho_Tsuki;
    }

    /**
     * 償還後第1回払込期（日）（修正）を取得します。
     * @return 償還後第1回払込期（日）（修正）
     */
    public String getDrpID_Date_FirstHaraikomiAfterKurisho_Bi() {
        return drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    }

    /**
     * 償還後第1回払込期（日）（修正）を設定します。
     * @param drpID_Date_FirstHaraikomiAfterKurisho_Bi 償還後第1回払込期（日）（修正）
     */
    public void setDrpID_Date_FirstHaraikomiAfterKurisho_Bi(String drpID_Date_FirstHaraikomiAfterKurisho_Bi) {
        this.drpID_Date_FirstHaraikomiAfterKurisho_Bi = drpID_Date_FirstHaraikomiAfterKurisho_Bi;
    }

    /**
     * 入金日(元号)（修正）を取得します。
     * @return 入金日(元号)（修正）
     */
    public String getDrpID_Date_Nyukin_Gengo() {
        return drpID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日(元号)（修正）を設定します。
     * @param drpID_Date_Nyukin_Gengo 入金日(元号)（修正）
     */
    public void setDrpID_Date_Nyukin_Gengo(String drpID_Date_Nyukin_Gengo) {
        this.drpID_Date_Nyukin_Gengo = drpID_Date_Nyukin_Gengo;
    }

    /**
     * 入金日(年)（修正）を取得します。
     * @return 入金日(年)（修正）
     */
    public String getTxtID_Date_Nyukin_Nen() {
        return txtID_Date_Nyukin_Nen;
    }

    /**
     * 入金日(年)（修正）を設定します。
     * @param txtID_Date_Nyukin_Nen 入金日(年)（修正）
     */
    public void setTxtID_Date_Nyukin_Nen(String txtID_Date_Nyukin_Nen) {
        this.txtID_Date_Nyukin_Nen = txtID_Date_Nyukin_Nen;
    }

    /**
     * 入金日(月)（修正）を取得します。
     * @return 入金日(月)（修正）
     */
    public String getDrpID_Date_Nyukin_Tsuki() {
        return drpID_Date_Nyukin_Tsuki;
    }

    /**
     * 入金日(月)（修正）を設定します。
     * @param drpID_Date_Nyukin_Tsuki 入金日(月)（修正）
     */
    public void setDrpID_Date_Nyukin_Tsuki(String drpID_Date_Nyukin_Tsuki) {
        this.drpID_Date_Nyukin_Tsuki = drpID_Date_Nyukin_Tsuki;
    }

    /**
     * 入金日(日)（修正）を取得します。
     * @return 入金日(日)（修正）
     */
    public String getDrpID_Date_Nyukin_Bi() {
        return drpID_Date_Nyukin_Bi;
    }

    /**
     * 入金日(日)（修正）を設定します。
     * @param drpID_Date_Nyukin_Bi 入金日(日)（修正）
     */
    public void setDrpID_Date_Nyukin_Bi(String drpID_Date_Nyukin_Bi) {
        this.drpID_Date_Nyukin_Bi = drpID_Date_Nyukin_Bi;
    }

    /**
     * 繰償事由コード（修正）を取得します。
     * @return 繰償事由コード（修正）
     */
    public String getDrpID_Code_Kurishojiyu() {
        return drpID_Code_Kurishojiyu;
    }

    /**
     * 繰償事由コード（修正）を設定します。
     * @param drpID_Code_Kurishojiyu 繰償事由コード（修正）
     */
    public void setDrpID_Code_Kurishojiyu(String drpID_Code_Kurishojiyu) {
        this.drpID_Code_Kurishojiyu = drpID_Code_Kurishojiyu;
    }

    /**
     * 利息(円)（修正）を取得します。
     * @return 利息(円)（修正）
     */
    public String getTxtID_M_KurishoRisoku() {
        return txtID_M_KurishoRisoku;
    }

    /**
     * 利息(円)（修正）を設定します。
     * @param txtID_M_KurishoRisoku 利息(円)（修正）
     */
    public void setTxtID_M_KurishoRisoku(String txtID_M_KurishoRisoku) {
        this.txtID_M_KurishoRisoku = txtID_M_KurishoRisoku;
    }

    /**
     * 元金(円)（修正）を取得します。
     * @return 元金(円)（修正）
     */
    public String getTxtID_M_KurishoGankin() {
        return txtID_M_KurishoGankin;
    }

    /**
     * 元金(円)（修正）を設定します。
     * @param txtID_M_KurishoGankin 元金(円)（修正）
     */
    public void setTxtID_M_KurishoGankin(String txtID_M_KurishoGankin) {
        this.txtID_M_KurishoGankin = txtID_M_KurishoGankin;
    }

    /**
     * 控除利息(円)（修正）を取得します。
     * @return 控除利息(円)（修正）
     */
    public String getTxtID_M_KojoRisoku() {
        return txtID_M_KojoRisoku;
    }

    /**
     * 控除利息(円)（修正）を設定します。
     * @param txtID_M_KojoRisoku 控除利息(円)（修正）
     */
    public void setTxtID_M_KojoRisoku(String txtID_M_KojoRisoku) {
        this.txtID_M_KojoRisoku = txtID_M_KojoRisoku;
    }

    /**
     * 繰上償還手数料(円)（修正）を取得します。
     * @return 繰上償還手数料(円)（修正）
     */
    public String getTxtID_M_KurishoCommission() {
        return txtID_M_KurishoCommission;
    }

    /**
     * 繰上償還手数料(円)（修正）を設定します。
     * @param txtID_M_KurishoCommission 繰上償還手数料(円)（修正）
     */
    public void setTxtID_M_KurishoCommission(String txtID_M_KurishoCommission) {
        this.txtID_M_KurishoCommission = txtID_M_KurishoCommission;
    }

    /**
     * 仮受金からの充当額(円)（修正）を取得します。
     * @return 仮受金からの充当額(円)（修正）
     */
    public String getTxtID_M_KariukeIppanJuto() {
        return txtID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額(円)（修正）を設定します。
     * @param txtID_M_KariukeIppanJuto 仮受金からの充当額(円)（修正）
     */
    public void setTxtID_M_KariukeIppanJuto(String txtID_M_KariukeIppanJuto) {
        this.txtID_M_KariukeIppanJuto = txtID_M_KariukeIppanJuto;
    }

    /**
     * 送金額(円)（修正）を取得します。
     * @return 送金額(円)（修正）
     */
    public String getTxtID_M_Sokin() {
        return txtID_M_Sokin;
    }

    /**
     * 送金額(円)（修正）を設定します。
     * @param txtID_M_Sokin 送金額(円)（修正）
     */
    public void setTxtID_M_Sokin(String txtID_M_Sokin) {
        this.txtID_M_Sokin = txtID_M_Sokin;
    }

    /**
     * 繰償後残元金(円)（修正）を取得します。
     * @return 繰償後残元金(円)（修正）
     */
    public String getTxtID_M_ZanGankinAfterKurisho() {
        return txtID_M_ZanGankinAfterKurisho;
    }

    /**
     * 繰償後残元金(円)（修正）を設定します。
     * @param txtID_M_ZanGankinAfterKurisho 繰償後残元金(円)（修正）
     */
    public void setTxtID_M_ZanGankinAfterKurisho(String txtID_M_ZanGankinAfterKurisho) {
        this.txtID_M_ZanGankinAfterKurisho = txtID_M_ZanGankinAfterKurisho;
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
     * 送金日(元号)（修正）を取得します。
     * @return 送金日(元号)（修正）
     */
    public String getDrpID_Date_Sokin_Gengo() {
        return drpID_Date_Sokin_Gengo;
    }

    /**
     * 送金日(元号)（修正）を設定します。
     * @param drpID_Date_Sokin_Gengo 送金日(元号)（修正）
     */
    public void setDrpID_Date_Sokin_Gengo(String drpID_Date_Sokin_Gengo) {
        this.drpID_Date_Sokin_Gengo = drpID_Date_Sokin_Gengo;
    }

    /**
     * 送金日(年)（修正）を取得します。
     * @return 送金日(年)（修正）
     */
    public String getTxtID_Date_Sokin_Nen() {
        return txtID_Date_Sokin_Nen;
    }

    /**
     * 送金日(年)（修正）を設定します。
     * @param txtID_Date_Sokin_Nen 送金日(年)（修正）
     */
    public void setTxtID_Date_Sokin_Nen(String txtID_Date_Sokin_Nen) {
        this.txtID_Date_Sokin_Nen = txtID_Date_Sokin_Nen;
    }

    /**
     * 送金日(月)（修正）を取得します。
     * @return 送金日(月)（修正）
     */
    public String getDrpID_Date_Sokin_Tsuki() {
        return drpID_Date_Sokin_Tsuki;
    }

    /**
     * 送金日(月)（修正）を設定します。
     * @param drpID_Date_Sokin_Tsuki 送金日(月)（修正）
     */
    public void setDrpID_Date_Sokin_Tsuki(String drpID_Date_Sokin_Tsuki) {
        this.drpID_Date_Sokin_Tsuki = drpID_Date_Sokin_Tsuki;
    }

    /**
     * 送金日(日)（修正）を取得します。
     * @return 送金日(日)（修正）
     */
    public String getDrpID_Date_Sokin_Bi() {
        return drpID_Date_Sokin_Bi;
    }

    /**
     * 送金日(日)（修正）を設定します。
     * @param drpID_Date_Sokin_Bi 送金日(日)（修正）
     */
    public void setDrpID_Date_Sokin_Bi(String drpID_Date_Sokin_Bi) {
        this.drpID_Date_Sokin_Bi = drpID_Date_Sokin_Bi;
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
     * 払込期日①（元号）（修正）を取得します。
     * @return 払込期日①（元号）（修正）
     */
    public String getDrpID_Date_Haraikomi1_Gengo() {
        return drpID_Date_Haraikomi1_Gengo;
    }

    /**
     * 払込期日①（元号）（修正）を設定します。
     * @param drpID_Date_Haraikomi1_Gengo 払込期日①（元号）（修正）
     */
    public void setDrpID_Date_Haraikomi1_Gengo(String drpID_Date_Haraikomi1_Gengo) {
        this.drpID_Date_Haraikomi1_Gengo = drpID_Date_Haraikomi1_Gengo;
    }

    /**
     * 払込期日①（年）（修正）を取得します。
     * @return 払込期日①（年）（修正）
     */
    public String getTxtID_Date_Haraikomi1_Nen() {
        return txtID_Date_Haraikomi1_Nen;
    }

    /**
     * 払込期日①（年）（修正）を設定します。
     * @param txtID_Date_Haraikomi1_Nen 払込期日①（年）（修正）
     */
    public void setTxtID_Date_Haraikomi1_Nen(String txtID_Date_Haraikomi1_Nen) {
        this.txtID_Date_Haraikomi1_Nen = txtID_Date_Haraikomi1_Nen;
    }

    /**
     * 払込期日①（月）（修正）を取得します。
     * @return 払込期日①（月）（修正）
     */
    public String getDrpID_Date_Haraikomi1_Tsuki() {
        return drpID_Date_Haraikomi1_Tsuki;
    }

    /**
     * 払込期日①（月）（修正）を設定します。
     * @param drpID_Date_Haraikomi1_Tsuki 払込期日①（月）（修正）
     */
    public void setDrpID_Date_Haraikomi1_Tsuki(String drpID_Date_Haraikomi1_Tsuki) {
        this.drpID_Date_Haraikomi1_Tsuki = drpID_Date_Haraikomi1_Tsuki;
    }

    /**
     * 払込期日①（日）（修正）を取得します。
     * @return 払込期日①（日）（修正）
     */
    public String getDrpID_Date_Haraikomi1_Bi() {
        return drpID_Date_Haraikomi1_Bi;
    }

    /**
     * 払込期日①（日）（修正）を設定します。
     * @param drpID_Date_Haraikomi1_Bi 払込期日①（日）（修正）
     */
    public void setDrpID_Date_Haraikomi1_Bi(String drpID_Date_Haraikomi1_Bi) {
        this.drpID_Date_Haraikomi1_Bi = drpID_Date_Haraikomi1_Bi;
    }

    /**
     * 払込期日②（元号）（修正）を取得します。
     * @return 払込期日②（元号）（修正）
     */
    public String getDrpID_Date_Haraikomi2_Gengo() {
        return drpID_Date_Haraikomi2_Gengo;
    }

    /**
     * 払込期日②（元号）（修正）を設定します。
     * @param drpID_Date_Haraikomi2_Gengo 払込期日②（元号）（修正）
     */
    public void setDrpID_Date_Haraikomi2_Gengo(String drpID_Date_Haraikomi2_Gengo) {
        this.drpID_Date_Haraikomi2_Gengo = drpID_Date_Haraikomi2_Gengo;
    }

    /**
     * 払込期日②（年）（修正）を取得します。
     * @return 払込期日②（年）（修正）
     */
    public String getTxtID_Date_Haraikomi2_Nen() {
        return txtID_Date_Haraikomi2_Nen;
    }

    /**
     * 払込期日②（年）（修正）を設定します。
     * @param txtID_Date_Haraikomi2_Nen 払込期日②（年）（修正）
     */
    public void setTxtID_Date_Haraikomi2_Nen(String txtID_Date_Haraikomi2_Nen) {
        this.txtID_Date_Haraikomi2_Nen = txtID_Date_Haraikomi2_Nen;
    }

    /**
     * 払込期日②（月）（修正）を取得します。
     * @return 払込期日②（月）（修正）
     */
    public String getDrpID_Date_Haraikomi2_Tsuki() {
        return drpID_Date_Haraikomi2_Tsuki;
    }

    /**
     * 払込期日②（月）（修正）を設定します。
     * @param drpID_Date_Haraikomi2_Tsuki 払込期日②（月）（修正）
     */
    public void setDrpID_Date_Haraikomi2_Tsuki(String drpID_Date_Haraikomi2_Tsuki) {
        this.drpID_Date_Haraikomi2_Tsuki = drpID_Date_Haraikomi2_Tsuki;
    }

    /**
     * 払込期日②（日）（修正）を取得します。
     * @return 払込期日②（日）（修正）
     */
    public String getDrpID_Date_Haraikomi2_Bi() {
        return drpID_Date_Haraikomi2_Bi;
    }

    /**
     * 払込期日②（日）（修正）を設定します。
     * @param drpID_Date_Haraikomi2_Bi 払込期日②（日）（修正）
     */
    public void setDrpID_Date_Haraikomi2_Bi(String drpID_Date_Haraikomi2_Bi) {
        this.drpID_Date_Haraikomi2_Bi = drpID_Date_Haraikomi2_Bi;
    }

    /**
     * 払込期日③（元号）（修正）を取得します。
     * @return 払込期日③（元号）（修正）
     */
    public String getDrpID_Date_Haraikomi3_Gengo() {
        return drpID_Date_Haraikomi3_Gengo;
    }

    /**
     * 払込期日③（元号）（修正）を設定します。
     * @param drpID_Date_Haraikomi3_Gengo 払込期日③（元号）（修正）
     */
    public void setDrpID_Date_Haraikomi3_Gengo(String drpID_Date_Haraikomi3_Gengo) {
        this.drpID_Date_Haraikomi3_Gengo = drpID_Date_Haraikomi3_Gengo;
    }

    /**
     * 払込期日③（年）（修正）を取得します。
     * @return 払込期日③（年）（修正）
     */
    public String getTxtID_Date_Haraikomi3_Nen() {
        return txtID_Date_Haraikomi3_Nen;
    }

    /**
     * 払込期日③（年）（修正）を設定します。
     * @param txtID_Date_Haraikomi3_Nen 払込期日③（年）（修正）
     */
    public void setTxtID_Date_Haraikomi3_Nen(String txtID_Date_Haraikomi3_Nen) {
        this.txtID_Date_Haraikomi3_Nen = txtID_Date_Haraikomi3_Nen;
    }

    /**
     * 払込期日③（月）（修正）を取得します。
     * @return 払込期日③（月）（修正）
     */
    public String getDrpID_Date_Haraikomi3_Tsuki() {
        return drpID_Date_Haraikomi3_Tsuki;
    }

    /**
     * 払込期日③（月）（修正）を設定します。
     * @param drpID_Date_Haraikomi3_Tsuki 払込期日③（月）（修正）
     */
    public void setDrpID_Date_Haraikomi3_Tsuki(String drpID_Date_Haraikomi3_Tsuki) {
        this.drpID_Date_Haraikomi3_Tsuki = drpID_Date_Haraikomi3_Tsuki;
    }

    /**
     * 払込期日③（日）（修正）を取得します。
     * @return 払込期日③（日）（修正）
     */
    public String getDrpID_Date_Haraikomi3_Bi() {
        return drpID_Date_Haraikomi3_Bi;
    }

    /**
     * 払込期日③（日）（修正）を設定します。
     * @param drpID_Date_Haraikomi3_Bi 払込期日③（日）（修正）
     */
    public void setDrpID_Date_Haraikomi3_Bi(String drpID_Date_Haraikomi3_Bi) {
        this.drpID_Date_Haraikomi3_Bi = drpID_Date_Haraikomi3_Bi;
    }

    /**
     * 払込期日④（元号）（修正）を取得します。
     * @return 払込期日④（元号）（修正）
     */
    public String getDrpID_Date_Haraikomi4_Gengo() {
        return drpID_Date_Haraikomi4_Gengo;
    }

    /**
     * 払込期日④（元号）（修正）を設定します。
     * @param drpID_Date_Haraikomi4_Gengo 払込期日④（元号）（修正）
     */
    public void setDrpID_Date_Haraikomi4_Gengo(String drpID_Date_Haraikomi4_Gengo) {
        this.drpID_Date_Haraikomi4_Gengo = drpID_Date_Haraikomi4_Gengo;
    }

    /**
     * 払込期日④（年）（修正）を取得します。
     * @return 払込期日④（年）（修正）
     */
    public String getTxtID_Date_Haraikomi4_Nen() {
        return txtID_Date_Haraikomi4_Nen;
    }

    /**
     * 払込期日④（年）（修正）を設定します。
     * @param txtID_Date_Haraikomi4_Nen 払込期日④（年）（修正）
     */
    public void setTxtID_Date_Haraikomi4_Nen(String txtID_Date_Haraikomi4_Nen) {
        this.txtID_Date_Haraikomi4_Nen = txtID_Date_Haraikomi4_Nen;
    }

    /**
     * 払込期日④（月）（修正）を取得します。
     * @return 払込期日④（月）（修正）
     */
    public String getDrpID_Date_Haraikomi4_Tsuki() {
        return drpID_Date_Haraikomi4_Tsuki;
    }

    /**
     * 払込期日④（月）（修正）を設定します。
     * @param drpID_Date_Haraikomi4_Tsuki 払込期日④（月）（修正）
     */
    public void setDrpID_Date_Haraikomi4_Tsuki(String drpID_Date_Haraikomi4_Tsuki) {
        this.drpID_Date_Haraikomi4_Tsuki = drpID_Date_Haraikomi4_Tsuki;
    }

    /**
     * 払込期日④（日）（修正）を取得します。
     * @return 払込期日④（日）（修正）
     */
    public String getDrpID_Date_Haraikomi4_Bi() {
        return drpID_Date_Haraikomi4_Bi;
    }

    /**
     * 払込期日④（日）（修正）を設定します。
     * @param drpID_Date_Haraikomi4_Bi 払込期日④（日）（修正）
     */
    public void setDrpID_Date_Haraikomi4_Bi(String drpID_Date_Haraikomi4_Bi) {
        this.drpID_Date_Haraikomi4_Bi = drpID_Date_Haraikomi4_Bi;
    }

    /**
     * 払込元金①（修正）を取得します。
     * @return 払込元金①（修正）
     */
    public String getTxtID_M_HaraikomiGankin1() {
        return txtID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金①（修正）を設定します。
     * @param txtID_M_HaraikomiGankin1 払込元金①（修正）
     */
    public void setTxtID_M_HaraikomiGankin1(String txtID_M_HaraikomiGankin1) {
        this.txtID_M_HaraikomiGankin1 = txtID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金②（修正）を取得します。
     * @return 払込元金②（修正）
     */
    public String getTxtID_M_HaraikomiGankin2() {
        return txtID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金②（修正）を設定します。
     * @param txtID_M_HaraikomiGankin2 払込元金②（修正）
     */
    public void setTxtID_M_HaraikomiGankin2(String txtID_M_HaraikomiGankin2) {
        this.txtID_M_HaraikomiGankin2 = txtID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金③（修正）を取得します。
     * @return 払込元金③（修正）
     */
    public String getTxtID_M_HaraikomiGankin3() {
        return txtID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金③（修正）を設定します。
     * @param txtID_M_HaraikomiGankin3 払込元金③（修正）
     */
    public void setTxtID_M_HaraikomiGankin3(String txtID_M_HaraikomiGankin3) {
        this.txtID_M_HaraikomiGankin3 = txtID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金④（修正）を取得します。
     * @return 払込元金④（修正）
     */
    public String getTxtID_M_HaraikomiGankin4() {
        return txtID_M_HaraikomiGankin4;
    }

    /**
     * 払込元金④（修正）を設定します。
     * @param txtID_M_HaraikomiGankin4 払込元金④（修正）
     */
    public void setTxtID_M_HaraikomiGankin4(String txtID_M_HaraikomiGankin4) {
        this.txtID_M_HaraikomiGankin4 = txtID_M_HaraikomiGankin4;
    }

    /**
     * 繰償後元金均等額(円)（修正）を取得します。
     * @return 繰償後元金均等額(円)（修正）
     */
    public String getTxtID_M_GankinKintoAfterKurisho() {
        return txtID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金均等額(円)（修正）を設定します。
     * @param txtID_M_GankinKintoAfterKurisho 繰償後元金均等額(円)（修正）
     */
    public void setTxtID_M_GankinKintoAfterKurisho(String txtID_M_GankinKintoAfterKurisho) {
        this.txtID_M_GankinKintoAfterKurisho = txtID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額(円)（修正）を取得します。
     * @return 繰償後元金不均等額(円)（修正）
     */
    public String getTxtID_M_GankinFukintoAfterKurisho() {
        return txtID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額(円)（修正）を設定します。
     * @param txtID_M_GankinFukintoAfterKurisho 繰償後元金不均等額(円)（修正）
     */
    public void setTxtID_M_GankinFukintoAfterKurisho(String txtID_M_GankinFukintoAfterKurisho) {
        this.txtID_M_GankinFukintoAfterKurisho = txtID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 受託者勘定処理年月(元号)（修正）を取得します。
     * @return 受託者勘定処理年月(元号)（修正）
     */
    public String getDrpID_Date_Jtkshori_Gengo() {
        return drpID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(元号)（修正）を設定します。
     * @param drpID_Date_Jtkshori_Gengo 受託者勘定処理年月(元号)（修正）
     */
    public void setDrpID_Date_Jtkshori_Gengo(String drpID_Date_Jtkshori_Gengo) {
        this.drpID_Date_Jtkshori_Gengo = drpID_Date_Jtkshori_Gengo;
    }

    /**
     * 受託者勘定処理年月(年)（修正）を取得します。
     * @return 受託者勘定処理年月(年)（修正）
     */
    public String getTxtID_Date_Jtkshori_Nen() {
        return txtID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(年)（修正）を設定します。
     * @param txtID_Date_Jtkshori_Nen 受託者勘定処理年月(年)（修正）
     */
    public void setTxtID_Date_Jtkshori_Nen(String txtID_Date_Jtkshori_Nen) {
        this.txtID_Date_Jtkshori_Nen = txtID_Date_Jtkshori_Nen;
    }

    /**
     * 受託者勘定処理年月(月)（修正）を取得します。
     * @return 受託者勘定処理年月(月)（修正）
     */
    public String getDrpID_Date_Jtkshori_Tsuki() {
        return drpID_Date_Jtkshori_Tsuki;
    }

    /**
     * 受託者勘定処理年月(月)（修正）を設定します。
     * @param drpID_Date_Jtkshori_Tsuki 受託者勘定処理年月(月)（修正）
     */
    public void setDrpID_Date_Jtkshori_Tsuki(String drpID_Date_Jtkshori_Tsuki) {
        this.drpID_Date_Jtkshori_Tsuki = drpID_Date_Jtkshori_Tsuki;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_ID_History_Red() {
        return ID_ID_History_Red;
    }

    /**
     * 履歴番号を設定します。
     * @param ID_ID_History_Red 履歴番号
     */
    public void setID_ID_History_Red(String ID_ID_History_Red) {
        this.ID_ID_History_Red = ID_ID_History_Red;
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getID_Type_Process_Red() {
        return ID_Type_Process_Red;
    }

    /**
     * 処理種別を設定します。
     * @param ID_Type_Process_Red 処理種別
     */
    public void setID_Type_Process_Red(String ID_Type_Process_Red) {
        this.ID_Type_Process_Red = ID_Type_Process_Red;
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public String getID_Flag_Torikeshizumi_Red() {
        return ID_Flag_Torikeshizumi_Red;
    }

    /**
     * 取消済フラグを設定します。
     * @param ID_Flag_Torikeshizumi_Red 取消済フラグ
     */
    public void setID_Flag_Torikeshizumi_Red(String ID_Flag_Torikeshizumi_Red) {
        this.ID_Flag_Torikeshizumi_Red = ID_Flag_Torikeshizumi_Red;
    }

    /**
     * エラーコードを取得します。
     * @return エラーコード
     */
    public String getID_Code_Error_Red() {
        return ID_Code_Error_Red;
    }

    /**
     * エラーコードを設定します。
     * @param ID_Code_Error_Red エラーコード
     */
    public void setID_Code_Error_Red(String ID_Code_Error_Red) {
        this.ID_Code_Error_Red = ID_Code_Error_Red;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getID_ErrorMessage_Red() {
        return ID_ErrorMessage_Red;
    }

    /**
     * エラーメッセージを設定します。
     * @param ID_ErrorMessage_Red エラーメッセージ
     */
    public void setID_ErrorMessage_Red(String ID_ErrorMessage_Red) {
        this.ID_ErrorMessage_Red = ID_ErrorMessage_Red;
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_ID_Credit_Red() {
        return ID_ID_Credit_Red;
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit_Red 債権管理番号
     */
    public void setID_ID_Credit_Red(String ID_ID_Credit_Red) {
        this.ID_ID_Credit_Red = ID_ID_Credit_Red;
    }

    /**
     * 退避賦金を取得します。
     * @return 退避賦金
     */
    public String getID_Keep_M_Fukin_Red() {
        return ID_Keep_M_Fukin_Red;
    }

    /**
     * 退避賦金を設定します。
     * @param ID_Keep_M_Fukin_Red 退避賦金
     */
    public void setID_Keep_M_Fukin_Red(String ID_Keep_M_Fukin_Red) {
        this.ID_Keep_M_Fukin_Red = ID_Keep_M_Fukin_Red;
    }

    /**
     * 退避元金不均等額を取得します。
     * @return 退避元金不均等額
     */
    public String getID_Keep_M_GankinFukinto_Red() {
        return ID_Keep_M_GankinFukinto_Red;
    }

    /**
     * 退避元金不均等額を設定します。
     * @param ID_Keep_M_GankinFukinto_Red 退避元金不均等額
     */
    public void setID_Keep_M_GankinFukinto_Red(String ID_Keep_M_GankinFukinto_Red) {
        this.ID_Keep_M_GankinFukinto_Red = ID_Keep_M_GankinFukinto_Red;
    }

    /**
     * 退避元金不均等区分を取得します。
     * @return 退避元金不均等区分
     */
    public String getID_Keep_Kubun_GankinFukinto_Red() {
        return ID_Keep_Kubun_GankinFukinto_Red;
    }

    /**
     * 退避元金不均等区分を設定します。
     * @param ID_Keep_Kubun_GankinFukinto_Red 退避元金不均等区分
     */
    public void setID_Keep_Kubun_GankinFukinto_Red(String ID_Keep_Kubun_GankinFukinto_Red) {
        this.ID_Keep_Kubun_GankinFukinto_Red = ID_Keep_Kubun_GankinFukinto_Red;
    }

    /**
     * 退避貸付残高を取得します。
     * @return 退避貸付残高
     */
    public String getID_Keep_M_KashitsukeZan_Red() {
        return ID_Keep_M_KashitsukeZan_Red;
    }

    /**
     * 退避貸付残高を設定します。
     * @param ID_Keep_M_KashitsukeZan_Red 退避貸付残高
     */
    public void setID_Keep_M_KashitsukeZan_Red(String ID_Keep_M_KashitsukeZan_Red) {
        this.ID_Keep_M_KashitsukeZan_Red = ID_Keep_M_KashitsukeZan_Red;
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public String getID_Keep_M_YakujoGankin_Red() {
        return ID_Keep_M_YakujoGankin_Red;
    }

    /**
     * 退避約定元金を設定します。
     * @param ID_Keep_M_YakujoGankin_Red 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin_Red(String ID_Keep_M_YakujoGankin_Red) {
        this.ID_Keep_M_YakujoGankin_Red = ID_Keep_M_YakujoGankin_Red;
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku_Red() {
        return ID_Keep_M_YakujoRisoku_Red;
    }

    /**
     * 退避約定利息を設定します。
     * @param ID_Keep_M_YakujoRisoku_Red 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku_Red(String ID_Keep_M_YakujoRisoku_Red) {
        this.ID_Keep_M_YakujoRisoku_Red = ID_Keep_M_YakujoRisoku_Red;
    }

    /**
     * 退避償還期限を取得します。
     * @return 退避償還期限
     */
    public String getID_Keep_Date_ShokanKigen_Red() {
        return ID_Keep_Date_ShokanKigen_Red;
    }

    /**
     * 退避償還期限を設定します。
     * @param ID_Keep_Date_ShokanKigen_Red 退避償還期限
     */
    public void setID_Keep_Date_ShokanKigen_Red(String ID_Keep_Date_ShokanKigen_Red) {
        this.ID_Keep_Date_ShokanKigen_Red = ID_Keep_Date_ShokanKigen_Red;
    }

    /**
     * 最終更新年月日を取得します。
     * @return 最終更新年月日
     */
    public String getID_Data_LastUpDate_Red() {
        return ID_Data_LastUpDate_Red;
    }

    /**
     * 最終更新年月日を設定します。
     * @param ID_Data_LastUpDate_Red 最終更新年月日
     */
    public void setID_Data_LastUpDate_Red(String ID_Data_LastUpDate_Red) {
        this.ID_Data_LastUpDate_Red = ID_Data_LastUpDate_Red;
    }

    /**
     * 退避控除利息を取得します。
     * @return 退避控除利息
     */
    public String getID_Keep_M_KojoRisoku_Red() {
        return ID_Keep_M_KojoRisoku_Red;
    }

    /**
     * 退避控除利息を設定します。
     * @param ID_Keep_M_KojoRisoku_Red 退避控除利息
     */
    public void setID_Keep_M_KojoRisoku_Red(String ID_Keep_M_KojoRisoku_Red) {
        this.ID_Keep_M_KojoRisoku_Red = ID_Keep_M_KojoRisoku_Red;
    }

    /**
     * 退避払込期日を取得します。
     * @return 退避払込期日
     */
    public String getID_Keep_Date_Haraikomi_Red() {
        return ID_Keep_Date_Haraikomi_Red;
    }

    /**
     * 退避払込期日を設定します。
     * @param ID_Keep_Date_Haraikomi_Red 退避払込期日
     */
    public void setID_Keep_Date_Haraikomi_Red(String ID_Keep_Date_Haraikomi_Red) {
        this.ID_Keep_Date_Haraikomi_Red = ID_Keep_Date_Haraikomi_Red;
    }

    /**
     * 退避条変起案中区分を取得します。
     * @return 退避条変起案中区分
     */
    public String getID_Keep_JohenKianchu_Red() {
        return ID_Keep_JohenKianchu_Red;
    }

    /**
     * 退避条変起案中区分を設定します。
     * @param ID_Keep_JohenKianchu_Red 退避条変起案中区分
     */
    public void setID_Keep_JohenKianchu_Red(String ID_Keep_JohenKianchu_Red) {
        this.ID_Keep_JohenKianchu_Red = ID_Keep_JohenKianchu_Red;
    }

    /**
     * 条変起案中区分・稟議データを取得します。
     * @return 条変起案中区分・稟議データ
     */
    public String getID_Kubun_JohenKianchu_Red() {
        return ID_Kubun_JohenKianchu_Red;
    }

    /**
     * 条変起案中区分・稟議データを設定します。
     * @param ID_Kubun_JohenKianchu_Red 条変起案中区分・稟議データ
     */
    public void setID_Kubun_JohenKianchu_Red(String ID_Kubun_JohenKianchu_Red) {
        this.ID_Kubun_JohenKianchu_Red = ID_Kubun_JohenKianchu_Red;
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Jikko_Red() {
        return ID_Date_Jikko_Red;
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Jikko_Red 貸付実行日
     */
    public void setID_Date_Jikko_Red(String ID_Date_Jikko_Red) {
        this.ID_Date_Jikko_Red = ID_Date_Jikko_Red;
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getID_Code_ShokanHouhou_Red() {
        return ID_Code_ShokanHouhou_Red;
    }

    /**
     * 償還方法を設定します。
     * @param ID_Code_ShokanHouhou_Red 償還方法
     */
    public void setID_Code_ShokanHouhou_Red(String ID_Code_ShokanHouhou_Red) {
        this.ID_Code_ShokanHouhou_Red = ID_Code_ShokanHouhou_Red;
    }

    /**
     * 貸付残高を取得します。
     * @return 貸付残高
     */
    public String getID_M_KashitsukeZandaka_aRingi_Red() {
        return ID_M_KashitsukeZandaka_aRingi_Red;
    }

    /**
     * 貸付残高を設定します。
     * @param ID_M_KashitsukeZandaka_aRingi_Red 貸付残高
     */
    public void setID_M_KashitsukeZandaka_aRingi_Red(String ID_M_KashitsukeZandaka_aRingi_Red) {
        this.ID_M_KashitsukeZandaka_aRingi_Red = ID_M_KashitsukeZandaka_aRingi_Red;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen_aRingi_Red() {
        return ID_Date_ShokanKigen_aRingi_Red;
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen_aRingi_Red 償還期限
     */
    public void setID_Date_ShokanKigen_aRingi_Red(String ID_Date_ShokanKigen_aRingi_Red) {
        this.ID_Date_ShokanKigen_aRingi_Red = ID_Date_ShokanKigen_aRingi_Red;
    }

    /**
     * 賦金を取得します。
     * @return 賦金
     */
    public String getID_M_Fukin_aRingi_Red() {
        return ID_M_Fukin_aRingi_Red;
    }

    /**
     * 賦金を設定します。
     * @param ID_M_Fukin_aRingi_Red 賦金
     */
    public void setID_M_Fukin_aRingi_Red(String ID_M_Fukin_aRingi_Red) {
        this.ID_M_Fukin_aRingi_Red = ID_M_Fukin_aRingi_Red;
    }

    /**
     * 元金不均等額を取得します。
     * @return 元金不均等額
     */
    public String getID_M_GankinFukinto_aRingi_Red() {
        return ID_M_GankinFukinto_aRingi_Red;
    }

    /**
     * 元金不均等額を設定します。
     * @param ID_M_GankinFukinto_aRingi_Red 元金不均等額
     */
    public void setID_M_GankinFukinto_aRingi_Red(String ID_M_GankinFukinto_aRingi_Red) {
        this.ID_M_GankinFukinto_aRingi_Red = ID_M_GankinFukinto_aRingi_Red;
    }

    /**
     * 元金不均等額区分を取得します。
     * @return 元金不均等額区分
     */
    public String getID_Kubun_GankinFukintogaku_aRingi_Red() {
        return ID_Kubun_GankinFukintogaku_aRingi_Red;
    }

    /**
     * 元金不均等額区分を設定します。
     * @param ID_Kubun_GankinFukintogaku_aRingi_Red 元金不均等額区分
     */
    public void setID_Kubun_GankinFukintogaku_aRingi_Red(String ID_Kubun_GankinFukintogaku_aRingi_Red) {
        this.ID_Kubun_GankinFukintogaku_aRingi_Red = ID_Kubun_GankinFukintogaku_aRingi_Red;
    }

    /**
     * 繰上償還手数料区分を取得します。
     * @return 繰上償還手数料区分
     */
    public String getID_Kubun_KurishoTesuryo_aRingi_Red() {
        return ID_Kubun_KurishoTesuryo_aRingi_Red;
    }

    /**
     * 繰上償還手数料区分を設定します。
     * @param ID_Kubun_KurishoTesuryo_aRingi_Red 繰上償還手数料区分
     */
    public void setID_Kubun_KurishoTesuryo_aRingi_Red(String ID_Kubun_KurishoTesuryo_aRingi_Red) {
        this.ID_Kubun_KurishoTesuryo_aRingi_Red = ID_Kubun_KurishoTesuryo_aRingi_Red;
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi_aRingi_Red() {
        return ID_Date_GanrikinHaraiKomi_aRingi_Red;
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraiKomi_aRingi_Red 元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi_aRingi_Red(String ID_Date_GanrikinHaraiKomi_aRingi_Red) {
        this.ID_Date_GanrikinHaraiKomi_aRingi_Red = ID_Date_GanrikinHaraiKomi_aRingi_Red;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen_aRingi_Red() {
        return ID_Date_SueokiKigen_aRingi_Red;
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen_aRingi_Red 据置期限
     */
    public void setID_Date_SueokiKigen_aRingi_Red(String ID_Date_SueokiKigen_aRingi_Red) {
        this.ID_Date_SueokiKigen_aRingi_Red = ID_Date_SueokiKigen_aRingi_Red;
    }

    /**
     * 特利有効期限を取得します。
     * @return 特利有効期限
     */
    public String getID_Date_TokuriYuko_aRingi_Red() {
        return ID_Date_TokuriYuko_aRingi_Red;
    }

    /**
     * 特利有効期限を設定します。
     * @param ID_Date_TokuriYuko_aRingi_Red 特利有効期限
     */
    public void setID_Date_TokuriYuko_aRingi_Red(String ID_Date_TokuriYuko_aRingi_Red) {
        this.ID_Date_TokuriYuko_aRingi_Red = ID_Date_TokuriYuko_aRingi_Red;
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getID_Riritsu_aRingi_Red() {
        return ID_Riritsu_aRingi_Red;
    }

    /**
     * 利率を設定します。
     * @param ID_Riritsu_aRingi_Red 利率
     */
    public void setID_Riritsu_aRingi_Red(String ID_Riritsu_aRingi_Red) {
        this.ID_Riritsu_aRingi_Red = ID_Riritsu_aRingi_Red;
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public String getID_Tokuri_aRingi_Red() {
        return ID_Tokuri_aRingi_Red;
    }

    /**
     * 特利を設定します。
     * @param ID_Tokuri_aRingi_Red 特利
     */
    public void setID_Tokuri_aRingi_Red(String ID_Tokuri_aRingi_Red) {
        this.ID_Tokuri_aRingi_Red = ID_Tokuri_aRingi_Red;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getID_Status_Red() {
        return ID_Status_Red;
    }

    /**
     * ステータスを設定します。
     * @param ID_Status_Red ステータス
     */
    public void setID_Status_Red(String ID_Status_Red) {
        this.ID_Status_Red = ID_Status_Red;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_ID_Report_Red() {
        return ID_ID_Report_Red;
    }

    /**
     * 報告書番号を設定します。
     * @param ID_ID_Report_Red 報告書番号
     */
    public void setID_ID_Report_Red(String ID_ID_Report_Red) {
        this.ID_ID_Report_Red = ID_ID_Report_Red;
    }

    /**
     * 時刻を取得します。
     * @return 時刻
     */
    public String getID_Time_Report_Red() {
        return ID_Time_Report_Red;
    }

    /**
     * 時刻を設定します。
     * @param ID_Time_Report_Red 時刻
     */
    public void setID_Time_Report_Red(String ID_Time_Report_Red) {
        this.ID_Time_Report_Red = ID_Time_Report_Red;
    }

    /**
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getID_User_ID_Red() {
        return ID_User_ID_Red;
    }

    /**
     * ユーザＩＤを設定します。
     * @param ID_User_ID_Red ユーザＩＤ
     */
    public void setID_User_ID_Red(String ID_User_ID_Red) {
        this.ID_User_ID_Red = ID_User_ID_Red;
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
     */
    public String getID_ID_Denso_Red() {
        return ID_ID_Denso_Red;
    }

    /**
     * 伝送番号を設定します。
     * @param ID_ID_Denso_Red 伝送番号
     */
    public void setID_ID_Denso_Red(String ID_ID_Denso_Red) {
        this.ID_ID_Denso_Red = ID_ID_Denso_Red;
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getID_DataCode_Red() {
        return ID_DataCode_Red;
    }

    /**
     * データコードを設定します。
     * @param ID_DataCode_Red データコード
     */
    public void setID_DataCode_Red(String ID_DataCode_Red) {
        this.ID_DataCode_Red = ID_DataCode_Red;
    }

    /**
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getID_Keep_ID_History_Red() {
        return ID_Keep_ID_History_Red;
    }

    /**
     * 退避履歴番号を設定します。
     * @param ID_Keep_ID_History_Red 退避履歴番号
     */
    public void setID_Keep_ID_History_Red(String ID_Keep_ID_History_Red) {
        this.ID_Keep_ID_History_Red = ID_Keep_ID_History_Red;
    }

    /**
     * 充当順序変更区分を取得します。
     * @return 充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko_Red() {
        return ID_Kubun_JutoJunjoHenko_Red;
    }

    /**
     * 充当順序変更区分を設定します。
     * @param ID_Kubun_JutoJunjoHenko_Red 充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko_Red(String ID_Kubun_JutoJunjoHenko_Red) {
        this.ID_Kubun_JutoJunjoHenko_Red = ID_Kubun_JutoJunjoHenko_Red;
    }

    /**
     * 履歴番号(修正)を取得します。
     * @return 履歴番号(修正)
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * 履歴番号(修正)を設定します。
     * @param ID_ID_History 履歴番号(修正)
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * 取消済フラグ(修正)を取得します。
     * @return 取消済フラグ(修正)
     */
    public String getID_Flag_Torikeshizumi() {
        return ID_Flag_Torikeshizumi;
    }

    /**
     * 取消済フラグ(修正)を設定します。
     * @param ID_Flag_Torikeshizumi 取消済フラグ(修正)
     */
    public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
        this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
    }

    /**
     * エラーコード(修正)を取得します。
     * @return エラーコード(修正)
     */
    public String getID_Code_Error() {
        return ID_Code_Error;
    }

    /**
     * エラーコード(修正)を設定します。
     * @param ID_Code_Error エラーコード(修正)
     */
    public void setID_Code_Error(String ID_Code_Error) {
        this.ID_Code_Error = ID_Code_Error;
    }

    /**
     * エラーメッセージ(修正)を取得します。
     * @return エラーメッセージ(修正)
     */
    public String getID_ErrorMessage() {
        return ID_ErrorMessage;
    }

    /**
     * エラーメッセージ(修正)を設定します。
     * @param ID_ErrorMessage エラーメッセージ(修正)
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        this.ID_ErrorMessage = ID_ErrorMessage;
    }

    /**
     * 債権管理番号(修正)を取得します。
     * @return 債権管理番号(修正)
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号(修正)を設定します。
     * @param ID_ID_Credit 債権管理番号(修正)
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 退避賦金(修正)を取得します。
     * @return 退避賦金(修正)
     */
    public String getID_Keep_M_Fukin() {
        return ID_Keep_M_Fukin;
    }

    /**
     * 退避賦金(修正)を設定します。
     * @param ID_Keep_M_Fukin 退避賦金(修正)
     */
    public void setID_Keep_M_Fukin(String ID_Keep_M_Fukin) {
        this.ID_Keep_M_Fukin = ID_Keep_M_Fukin;
    }

    /**
     * 退避元金不均等額(修正)を取得します。
     * @return 退避元金不均等額(修正)
     */
    public String getID_Keep_M_GankinFukinto() {
        return ID_Keep_M_GankinFukinto;
    }

    /**
     * 退避元金不均等額(修正)を設定します。
     * @param ID_Keep_M_GankinFukinto 退避元金不均等額(修正)
     */
    public void setID_Keep_M_GankinFukinto(String ID_Keep_M_GankinFukinto) {
        this.ID_Keep_M_GankinFukinto = ID_Keep_M_GankinFukinto;
    }

    /**
     * 退避元金不均等区分(修正)を取得します。
     * @return 退避元金不均等区分(修正)
     */
    public String getID_Keep_Kubun_GankinFukinto() {
        return ID_Keep_Kubun_GankinFukinto;
    }

    /**
     * 退避元金不均等区分(修正)を設定します。
     * @param ID_Keep_Kubun_GankinFukinto 退避元金不均等区分(修正)
     */
    public void setID_Keep_Kubun_GankinFukinto(String ID_Keep_Kubun_GankinFukinto) {
        this.ID_Keep_Kubun_GankinFukinto = ID_Keep_Kubun_GankinFukinto;
    }

    /**
     * 退避貸付残高(修正)を取得します。
     * @return 退避貸付残高(修正)
     */
    public String getID_Keep_M_KashitsukeZan() {
        return ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避貸付残高(修正)を設定します。
     * @param ID_Keep_M_KashitsukeZan 退避貸付残高(修正)
     */
    public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
        this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
    }

    /**
     * 退避約定元金(修正)を取得します。
     * @return 退避約定元金(修正)
     */
    public String getID_Keep_M_YakujoGankin() {
        return ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定元金(修正)を設定します。
     * @param ID_Keep_M_YakujoGankin 退避約定元金(修正)
     */
    public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
        this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
    }

    /**
     * 退避約定利息(修正)を取得します。
     * @return 退避約定利息(修正)
     */
    public String getID_Keep_M_YakujoRisoku() {
        return ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避約定利息(修正)を設定します。
     * @param ID_Keep_M_YakujoRisoku 退避約定利息(修正)
     */
    public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
        this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
    }

    /**
     * 退避償還期限(修正)を取得します。
     * @return 退避償還期限(修正)
     */
    public String getID_Keep_Date_ShokanKigen() {
        return ID_Keep_Date_ShokanKigen;
    }

    /**
     * 退避償還期限(修正)を設定します。
     * @param ID_Keep_Date_ShokanKigen 退避償還期限(修正)
     */
    public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
        this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
    }

    /**
     * 最終更新年月日(修正)を取得します。
     * @return 最終更新年月日(修正)
     */
    public String getID_Data_LastUpDate() {
        return ID_Data_LastUpDate;
    }

    /**
     * 最終更新年月日(修正)を設定します。
     * @param ID_Data_LastUpDate 最終更新年月日(修正)
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        this.ID_Data_LastUpDate = ID_Data_LastUpDate;
    }

    /**
     * 退避控除利息(修正)を取得します。
     * @return 退避控除利息(修正)
     */
    public String getID_Keep_M_KojoRisoku() {
        return ID_Keep_M_KojoRisoku;
    }

    /**
     * 退避控除利息(修正)を設定します。
     * @param ID_Keep_M_KojoRisoku 退避控除利息(修正)
     */
    public void setID_Keep_M_KojoRisoku(String ID_Keep_M_KojoRisoku) {
        this.ID_Keep_M_KojoRisoku = ID_Keep_M_KojoRisoku;
    }

    /**
     * 退避払込期日(修正)を取得します。
     * @return 退避払込期日(修正)
     */
    public String getID_Keep_Date_Haraikomi() {
        return ID_Keep_Date_Haraikomi;
    }

    /**
     * 退避払込期日(修正)を設定します。
     * @param ID_Keep_Date_Haraikomi 退避払込期日(修正)
     */
    public void setID_Keep_Date_Haraikomi(String ID_Keep_Date_Haraikomi) {
        this.ID_Keep_Date_Haraikomi = ID_Keep_Date_Haraikomi;
    }

    /**
     * 退避条変起案中区分(修正)を取得します。
     * @return 退避条変起案中区分(修正)
     */
    public String getID_Keep_JohenKianchu() {
        return ID_Keep_JohenKianchu;
    }

    /**
     * 退避条変起案中区分(修正)を設定します。
     * @param ID_Keep_JohenKianchu 退避条変起案中区分(修正)
     */
    public void setID_Keep_JohenKianchu(String ID_Keep_JohenKianchu) {
        this.ID_Keep_JohenKianchu = ID_Keep_JohenKianchu;
    }

    /**
     * 条変起案中区分・稟議データ(修正)を取得します。
     * @return 条変起案中区分・稟議データ(修正)
     */
    public String getID_Kubun_JohenKianchu() {
        return ID_Kubun_JohenKianchu;
    }

    /**
     * 条変起案中区分・稟議データ(修正)を設定します。
     * @param ID_Kubun_JohenKianchu 条変起案中区分・稟議データ(修正)
     */
    public void setID_Kubun_JohenKianchu(String ID_Kubun_JohenKianchu) {
        this.ID_Kubun_JohenKianchu = ID_Kubun_JohenKianchu;
    }

    /**
     * 貸付実行日(修正)を取得します。
     * @return 貸付実行日(修正)
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 貸付実行日(修正)を設定します。
     * @param ID_Date_Jikko 貸付実行日(修正)
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 償還方法(修正)を取得します。
     * @return 償還方法(修正)
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 償還方法(修正)を設定します。
     * @param ID_Code_ShokanHouhou 償還方法(修正)
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 貸付残高(修正)を取得します。
     * @return 貸付残高(修正)
     */
    public String getID_M_KashitsukeZandaka_aRingi() {
        return ID_M_KashitsukeZandaka_aRingi;
    }

    /**
     * 貸付残高(修正)を設定します。
     * @param ID_M_KashitsukeZandaka_aRingi 貸付残高(修正)
     */
    public void setID_M_KashitsukeZandaka_aRingi(String ID_M_KashitsukeZandaka_aRingi) {
        this.ID_M_KashitsukeZandaka_aRingi = ID_M_KashitsukeZandaka_aRingi;
    }

    /**
     * 償還期限(修正)を取得します。
     * @return 償還期限(修正)
     */
    public String getID_Date_ShokanKigen_aRingi() {
        return ID_Date_ShokanKigen_aRingi;
    }

    /**
     * 償還期限(修正)を設定します。
     * @param ID_Date_ShokanKigen_aRingi 償還期限(修正)
     */
    public void setID_Date_ShokanKigen_aRingi(String ID_Date_ShokanKigen_aRingi) {
        this.ID_Date_ShokanKigen_aRingi = ID_Date_ShokanKigen_aRingi;
    }

    /**
     * 賦金(修正)を取得します。
     * @return 賦金(修正)
     */
    public String getID_M_Fukin_aRingi() {
        return ID_M_Fukin_aRingi;
    }

    /**
     * 賦金(修正)を設定します。
     * @param ID_M_Fukin_aRingi 賦金(修正)
     */
    public void setID_M_Fukin_aRingi(String ID_M_Fukin_aRingi) {
        this.ID_M_Fukin_aRingi = ID_M_Fukin_aRingi;
    }

    /**
     * 元金不均等額(修正)を取得します。
     * @return 元金不均等額(修正)
     */
    public String getID_M_GankinFukinto_aRingi() {
        return ID_M_GankinFukinto_aRingi;
    }

    /**
     * 元金不均等額(修正)を設定します。
     * @param ID_M_GankinFukinto_aRingi 元金不均等額(修正)
     */
    public void setID_M_GankinFukinto_aRingi(String ID_M_GankinFukinto_aRingi) {
        this.ID_M_GankinFukinto_aRingi = ID_M_GankinFukinto_aRingi;
    }

    /**
     * 元金不均等額区分(修正)を取得します。
     * @return 元金不均等額区分(修正)
     */
    public String getID_Kubun_GankinFukintogaku_aRingi() {
        return ID_Kubun_GankinFukintogaku_aRingi;
    }

    /**
     * 元金不均等額区分(修正)を設定します。
     * @param ID_Kubun_GankinFukintogaku_aRingi 元金不均等額区分(修正)
     */
    public void setID_Kubun_GankinFukintogaku_aRingi(String ID_Kubun_GankinFukintogaku_aRingi) {
        this.ID_Kubun_GankinFukintogaku_aRingi = ID_Kubun_GankinFukintogaku_aRingi;
    }

    /**
     * 繰上償還手数料区分(修正)を取得します。
     * @return 繰上償還手数料区分(修正)
     */
    public String getID_Kubun_KurishoTesuryo_aRingi() {
        return ID_Kubun_KurishoTesuryo_aRingi;
    }

    /**
     * 繰上償還手数料区分(修正)を設定します。
     * @param ID_Kubun_KurishoTesuryo_aRingi 繰上償還手数料区分(修正)
     */
    public void setID_Kubun_KurishoTesuryo_aRingi(String ID_Kubun_KurishoTesuryo_aRingi) {
        this.ID_Kubun_KurishoTesuryo_aRingi = ID_Kubun_KurishoTesuryo_aRingi;
    }

    /**
     * 元利金払込日(修正)を取得します。
     * @return 元利金払込日(修正)
     */
    public String getID_Date_GanrikinHaraiKomi_aRingi() {
        return ID_Date_GanrikinHaraiKomi_aRingi;
    }

    /**
     * 元利金払込日(修正)を設定します。
     * @param ID_Date_GanrikinHaraiKomi_aRingi 元利金払込日(修正)
     */
    public void setID_Date_GanrikinHaraiKomi_aRingi(String ID_Date_GanrikinHaraiKomi_aRingi) {
        this.ID_Date_GanrikinHaraiKomi_aRingi = ID_Date_GanrikinHaraiKomi_aRingi;
    }

    /**
     * 据置期限(修正)を取得します。
     * @return 据置期限(修正)
     */
    public String getID_Date_SueokiKigen_aRingi() {
        return ID_Date_SueokiKigen_aRingi;
    }

    /**
     * 据置期限(修正)を設定します。
     * @param ID_Date_SueokiKigen_aRingi 据置期限(修正)
     */
    public void setID_Date_SueokiKigen_aRingi(String ID_Date_SueokiKigen_aRingi) {
        this.ID_Date_SueokiKigen_aRingi = ID_Date_SueokiKigen_aRingi;
    }

    /**
     * 特利有効期限(修正)を取得します。
     * @return 特利有効期限(修正)
     */
    public String getID_Date_TokuriYuko_aRingi() {
        return ID_Date_TokuriYuko_aRingi;
    }

    /**
     * 特利有効期限(修正)を設定します。
     * @param ID_Date_TokuriYuko_aRingi 特利有効期限(修正)
     */
    public void setID_Date_TokuriYuko_aRingi(String ID_Date_TokuriYuko_aRingi) {
        this.ID_Date_TokuriYuko_aRingi = ID_Date_TokuriYuko_aRingi;
    }

    /**
     * 利率(修正)を取得します。
     * @return 利率(修正)
     */
    public String getID_Riritsu_aRingi() {
        return ID_Riritsu_aRingi;
    }

    /**
     * 利率(修正)を設定します。
     * @param ID_Riritsu_aRingi 利率(修正)
     */
    public void setID_Riritsu_aRingi(String ID_Riritsu_aRingi) {
        this.ID_Riritsu_aRingi = ID_Riritsu_aRingi;
    }

    /**
     * 特利(修正)を取得します。
     * @return 特利(修正)
     */
    public String getID_Tokuri_aRingi() {
        return ID_Tokuri_aRingi;
    }

    /**
     * 特利(修正)を設定します。
     * @param ID_Tokuri_aRingi 特利(修正)
     */
    public void setID_Tokuri_aRingi(String ID_Tokuri_aRingi) {
        this.ID_Tokuri_aRingi = ID_Tokuri_aRingi;
    }

    /**
     * ステータス(修正)を取得します。
     * @return ステータス(修正)
     */
    public String getID_Status() {
        return ID_Status;
    }

    /**
     * ステータス(修正)を設定します。
     * @param ID_Status ステータス(修正)
     */
    public void setID_Status(String ID_Status) {
        this.ID_Status = ID_Status;
    }

    /**
     * 報告書番号(修正)を取得します。
     * @return 報告書番号(修正)
     */
    public String getID_ID_Report() {
        return ID_ID_Report;
    }

    /**
     * 報告書番号(修正)を設定します。
     * @param ID_ID_Report 報告書番号(修正)
     */
    public void setID_ID_Report(String ID_ID_Report) {
        this.ID_ID_Report = ID_ID_Report;
    }

    /**
     * 時刻(修正)を取得します。
     * @return 時刻(修正)
     */
    public String getID_Time_Report() {
        return ID_Time_Report;
    }

    /**
     * 時刻(修正)を設定します。
     * @param ID_Time_Report 時刻(修正)
     */
    public void setID_Time_Report(String ID_Time_Report) {
        this.ID_Time_Report = ID_Time_Report;
    }

    /**
     * ユーザＩＤ(修正)を取得します。
     * @return ユーザＩＤ(修正)
     */
    public String getID_User_ID() {
        return ID_User_ID;
    }

    /**
     * ユーザＩＤ(修正)を設定します。
     * @param ID_User_ID ユーザＩＤ(修正)
     */
    public void setID_User_ID(String ID_User_ID) {
        this.ID_User_ID = ID_User_ID;
    }

    /**
     * 伝送番号(修正)を取得します。
     * @return 伝送番号(修正)
     */
    public String getID_ID_Denso() {
        return ID_ID_Denso;
    }

    /**
     * 伝送番号(修正)を設定します。
     * @param ID_ID_Denso 伝送番号(修正)
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        this.ID_ID_Denso = ID_ID_Denso;
    }

    /**
     * データコード(修正)を取得します。
     * @return データコード(修正)
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコード(修正)を設定します。
     * @param ID_DataCode データコード(修正)
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 退避履歴番号(修正)を取得します。
     * @return 退避履歴番号(修正)
     */
    public String getID_Keep_ID_History() {
        return ID_Keep_ID_History;
    }

    /**
     * 退避履歴番号(修正)を設定します。
     * @param ID_Keep_ID_History 退避履歴番号(修正)
     */
    public void setID_Keep_ID_History(String ID_Keep_ID_History) {
        this.ID_Keep_ID_History = ID_Keep_ID_History;
    }

    /**
     * 充当順序変更区分(修正)を取得します。
     * @return 充当順序変更区分(修正)
     */
    public String getID_Kubun_JutoJunjoHenko() {
        return ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 充当順序変更区分(修正)を設定します。
     * @param ID_Kubun_JutoJunjoHenko 充当順序変更区分(修正)
     */
    public void setID_Kubun_JutoJunjoHenko(String ID_Kubun_JutoJunjoHenko) {
        this.ID_Kubun_JutoJunjoHenko = ID_Kubun_JutoJunjoHenko;
    }

    /**
     * 受託者勘定処理年月(赤)（入力値連結）を取得します。
     * @return 受託者勘定処理年月(赤)（入力値連結）
     */
    public String getID_Date_Jtkshori_Red_Input() {
        return ID_Date_Jtkshori_Red_Input;
    }

    /**
     * 受託者勘定処理年月(赤)（入力値連結）を設定します。
     * @param ID_Date_Jtkshori_Red_Input 受託者勘定処理年月(赤)（入力値連結）
     */
    public void setID_Date_Jtkshori_Red_Input(String ID_Date_Jtkshori_Red_Input) {
        this.ID_Date_Jtkshori_Red_Input = ID_Date_Jtkshori_Red_Input;
    }

    /**
     * 償還後第1回払込期日(修正)（入力値連結）を取得します。
     * @return 償還後第1回払込期日(修正)（入力値連結）
     */
    public String getID_Date_FirstHaraikomiAfterKurisho_Input() {
        return ID_Date_FirstHaraikomiAfterKurisho_Input;
    }

    /**
     * 償還後第1回払込期日(修正)（入力値連結）を設定します。
     * @param ID_Date_FirstHaraikomiAfterKurisho_Input 償還後第1回払込期日(修正)（入力値連結）
     */
    public void setID_Date_FirstHaraikomiAfterKurisho_Input(String ID_Date_FirstHaraikomiAfterKurisho_Input) {
        this.ID_Date_FirstHaraikomiAfterKurisho_Input = ID_Date_FirstHaraikomiAfterKurisho_Input;
    }

    /**
     * 入金日(修正)（入力値連結）を取得します。
     * @return 入金日(修正)（入力値連結）
     */
    public String getID_Date_Nyukin_Input() {
        return ID_Date_Nyukin_Input;
    }

    /**
     * 入金日(修正)（入力値連結）を設定します。
     * @param ID_Date_Nyukin_Input 入金日(修正)（入力値連結）
     */
    public void setID_Date_Nyukin_Input(String ID_Date_Nyukin_Input) {
        this.ID_Date_Nyukin_Input = ID_Date_Nyukin_Input;
    }

    /**
     * 送金日(修正)（入力値連結）を取得します。
     * @return 送金日(修正)（入力値連結）
     */
    public String getID_Date_Sokin_Input() {
        return ID_Date_Sokin_Input;
    }

    /**
     * 送金日(修正)（入力値連結）を設定します。
     * @param ID_Date_Sokin_Input 送金日(修正)（入力値連結）
     */
    public void setID_Date_Sokin_Input(String ID_Date_Sokin_Input) {
        this.ID_Date_Sokin_Input = ID_Date_Sokin_Input;
    }

    /**
     * 払込期日①(修正)（入力値連結）を取得します。
     * @return 払込期日①(修正)（入力値連結）
     */
    public String getID_Date_Haraikomi1_Input() {
        return ID_Date_Haraikomi1_Input;
    }

    /**
     * 払込期日①(修正)（入力値連結）を設定します。
     * @param ID_Date_Haraikomi1_Input 払込期日①(修正)（入力値連結）
     */
    public void setID_Date_Haraikomi1_Input(String ID_Date_Haraikomi1_Input) {
        this.ID_Date_Haraikomi1_Input = ID_Date_Haraikomi1_Input;
    }

    /**
     * 払込期日②(修正)（入力値連結）を取得します。
     * @return 払込期日②(修正)（入力値連結）
     */
    public String getID_Date_Haraikomi2_Input() {
        return ID_Date_Haraikomi2_Input;
    }

    /**
     * 払込期日②(修正)（入力値連結）を設定します。
     * @param ID_Date_Haraikomi2_Input 払込期日②(修正)（入力値連結）
     */
    public void setID_Date_Haraikomi2_Input(String ID_Date_Haraikomi2_Input) {
        this.ID_Date_Haraikomi2_Input = ID_Date_Haraikomi2_Input;
    }

    /**
     * 払込期日③(修正)（入力値連結）を取得します。
     * @return 払込期日③(修正)（入力値連結）
     */
    public String getID_Date_Haraikomi3_Input() {
        return ID_Date_Haraikomi3_Input;
    }

    /**
     * 払込期日③(修正)（入力値連結）を設定します。
     * @param ID_Date_Haraikomi3_Input 払込期日③(修正)（入力値連結）
     */
    public void setID_Date_Haraikomi3_Input(String ID_Date_Haraikomi3_Input) {
        this.ID_Date_Haraikomi3_Input = ID_Date_Haraikomi3_Input;
    }

    /**
     * 払込期日④(修正)（入力値連結）を取得します。
     * @return 払込期日④(修正)（入力値連結）
     */
    public String getID_Date_Haraikomi4_Input() {
        return ID_Date_Haraikomi4_Input;
    }

    /**
     * 払込期日④(修正)（入力値連結）を設定します。
     * @param ID_Date_Haraikomi4_Input 払込期日④(修正)（入力値連結）
     */
    public void setID_Date_Haraikomi4_Input(String ID_Date_Haraikomi4_Input) {
        this.ID_Date_Haraikomi4_Input = ID_Date_Haraikomi4_Input;
    }

    /**
     * 受託者勘定処理年月(修正)（入力値連結）を取得します。
     * @return 受託者勘定処理年月(修正)（入力値連結）
     */
    public String getID_Date_Jtkshori_Input() {
        return ID_Date_Jtkshori_Input;
    }

    /**
     * 受託者勘定処理年月(修正)（入力値連結）を設定します。
     * @param ID_Date_Jtkshori_Input 受託者勘定処理年月(修正)（入力値連結）
     */
    public void setID_Date_Jtkshori_Input(String ID_Date_Jtkshori_Input) {
        this.ID_Date_Jtkshori_Input = ID_Date_Jtkshori_Input;
    }

    /**
     * 元金(DB取得値)を取得します。
     * @return 元金(DB取得値)
     */
    public String getID_M_KurishoGankin_Save() {
        return ID_M_KurishoGankin_Save;
    }

    /**
     * 元金(DB取得値)を設定します。
     * @param ID_M_KurishoGankin_Save 元金(DB取得値)
     */
    public void setID_M_KurishoGankin_Save(String ID_M_KurishoGankin_Save) {
        this.ID_M_KurishoGankin_Save = ID_M_KurishoGankin_Save;
    }

    /**
     * 繰償後残元金(DB取得値)を取得します。
     * @return 繰償後残元金(DB取得値)
     */
    public String getID_M_ZanGankinAfterKurisho_Save() {
        return ID_M_ZanGankinAfterKurisho_Save;
    }

    /**
     * 繰償後残元金(DB取得値)を設定します。
     * @param ID_M_ZanGankinAfterKurisho_Save 繰償後残元金(DB取得値)
     */
    public void setID_M_ZanGankinAfterKurisho_Save(String ID_M_ZanGankinAfterKurisho_Save) {
        this.ID_M_ZanGankinAfterKurisho_Save = ID_M_ZanGankinAfterKurisho_Save;
    }

    /**
     * 償還後第1回払込期日(DB取得値)を取得します。
     * @return 償還後第1回払込期日(DB取得値)
     */
    public String getID_Date_FirstHaraikomiAfterKurisho_Save() {
        return ID_Date_FirstHaraikomiAfterKurisho_Save;
    }

    /**
     * 償還後第1回払込期日(DB取得値)を設定します。
     * @param ID_Date_FirstHaraikomiAfterKurisho_Save 償還後第1回払込期日(DB取得値)
     */
    public void setID_Date_FirstHaraikomiAfterKurisho_Save(String ID_Date_FirstHaraikomiAfterKurisho_Save) {
        this.ID_Date_FirstHaraikomiAfterKurisho_Save = ID_Date_FirstHaraikomiAfterKurisho_Save;
    }

    /**
     * 請求データ更新フラグを取得します。
     * @return 請求データ更新フラグ
     */
    public boolean getFlgSeikyuUpdate() {
        return flgSeikyuUpdate;
    }

    /**
     * 請求データ更新フラグを設定します。
     * @param flgSeikyuUpdate 請求データ更新フラグ
     */
    public void setFlgSeikyuUpdate(boolean flgSeikyuUpdate) {
        this.flgSeikyuUpdate = flgSeikyuUpdate;
    }

    /**
     * 請求データ更新用約定元金を取得します。
     * @return 請求データ更新用約定元金
     */
    public String getID_M_YakujoGankin_Seikyu() {
        return ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 請求データ更新用約定元金を設定します。
     * @param ID_M_YakujoGankin_Seikyu 請求データ更新用約定元金
     */
    public void setID_M_YakujoGankin_Seikyu(String ID_M_YakujoGankin_Seikyu) {
        this.ID_M_YakujoGankin_Seikyu = ID_M_YakujoGankin_Seikyu;
    }

    /**
     * 請求データ更新用約定利息を取得します。
     * @return 請求データ更新用約定利息
     */
    public String getID_M_YakujoRisoku_Seikyu() {
        return ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 請求データ更新用約定利息を設定します。
     * @param ID_M_YakujoRisoku_Seikyu 請求データ更新用約定利息
     */
    public void setID_M_YakujoRisoku_Seikyu(String ID_M_YakujoRisoku_Seikyu) {
        this.ID_M_YakujoRisoku_Seikyu = ID_M_YakujoRisoku_Seikyu;
    }

    /**
     * 請求データ更新用払込期日を取得します。
     * @return 請求データ更新用払込期日
     */
    public String getID_Date_Haraikomi_Seikyu() {
        return ID_Date_Haraikomi_Seikyu;
    }

    /**
     * 請求データ更新用払込期日を設定します。
     * @param ID_Date_Haraikomi_Seikyu 請求データ更新用払込期日
     */
    public void setID_Date_Haraikomi_Seikyu(String ID_Date_Haraikomi_Seikyu) {
        this.ID_Date_Haraikomi_Seikyu = ID_Date_Haraikomi_Seikyu;
    }

    /**
     * 払出データ貸付受入金残高を取得します。
     * @return 払出データ貸付受入金残高
     */
    public String getID_M_KashitsukeUkeire() {
        return ID_M_KashitsukeUkeire;
    }

    /**
     * 払出データ貸付受入金残高を設定します。
     * @param ID_M_KashitsukeUkeire 払出データ貸付受入金残高
     */
    public void setID_M_KashitsukeUkeire(String ID_M_KashitsukeUkeire) {
        this.ID_M_KashitsukeUkeire = ID_M_KashitsukeUkeire;
    }

    /**
     * SAVEデータの条変起案中区分を取得します。
     * @return SAVEデータの条変起案中区分
     */
    public String getSave_ID_Kubun_JohenKianchu() {
        return Save_ID_Kubun_JohenKianchu;
    }

    /**
     * SAVEデータの条変起案中区分を設定します。
     * @param Save_ID_Kubun_JohenKianchu SAVEデータの条変起案中区分
     */
    public void setSave_ID_Kubun_JohenKianchu(String Save_ID_Kubun_JohenKianchu) {
        this.Save_ID_Kubun_JohenKianchu = Save_ID_Kubun_JohenKianchu;
    }

    /**
     * SAVEデータの賦金を取得します。
     * @return SAVEデータの賦金
     */
    public String getSave_ID_M_Fukin() {
        return Save_ID_M_Fukin;
    }

    /**
     * SAVEデータの賦金を設定します。
     * @param Save_ID_M_Fukin SAVEデータの賦金
     */
    public void setSave_ID_M_Fukin(String Save_ID_M_Fukin) {
        this.Save_ID_M_Fukin = Save_ID_M_Fukin;
    }

    /**
     * SAVEデータの元金不均等額を取得します。
     * @return SAVEデータの元金不均等額
     */
    public String getSave_ID_M_GankinFukinto() {
        return Save_ID_M_GankinFukinto;
    }

    /**
     * SAVEデータの元金不均等額を設定します。
     * @param Save_ID_M_GankinFukinto SAVEデータの元金不均等額
     */
    public void setSave_ID_M_GankinFukinto(String Save_ID_M_GankinFukinto) {
        this.Save_ID_M_GankinFukinto = Save_ID_M_GankinFukinto;
    }

    /**
     * SAVEデータの償還期限年月を取得します。
     * @return SAVEデータの償還期限年月
     */
    public String getSave_ID_Date_ShokanKigen() {
        return Save_ID_Date_ShokanKigen;
    }

    /**
     * SAVEデータの償還期限年月を設定します。
     * @param Save_ID_Date_ShokanKigen SAVEデータの償還期限年月
     */
    public void setSave_ID_Date_ShokanKigen(String Save_ID_Date_ShokanKigen) {
        this.Save_ID_Date_ShokanKigen = Save_ID_Date_ShokanKigen;
    }

    /**
     * SAVEデータの約定元金を取得します。
     * @return SAVEデータの約定元金
     */
    public String getSave_ID_M_YakujoGankin() {
        return Save_ID_M_YakujoGankin;
    }

    /**
     * SAVEデータの約定元金を設定します。
     * @param Save_ID_M_YakujoGankin SAVEデータの約定元金
     */
    public void setSave_ID_M_YakujoGankin(String Save_ID_M_YakujoGankin) {
        this.Save_ID_M_YakujoGankin = Save_ID_M_YakujoGankin;
    }

    /**
     * SAVEデータの約定利息を取得します。
     * @return SAVEデータの約定利息
     */
    public String getSave_ID_M_YakujoRisoku() {
        return Save_ID_M_YakujoRisoku;
    }

    /**
     * SAVEデータの約定利息を設定します。
     * @param Save_ID_M_YakujoRisoku SAVEデータの約定利息
     */
    public void setSave_ID_M_YakujoRisoku(String Save_ID_M_YakujoRisoku) {
        this.Save_ID_M_YakujoRisoku = Save_ID_M_YakujoRisoku;
    }

    /**
     * SAVEデータの調整コードを取得します。
     * @return SAVEデータの調整コード
     */
    public String getSave_ID_Code_Chosei() {
        return Save_ID_Code_Chosei;
    }

    /**
     * SAVEデータの調整コードを設定します。
     * @param Save_ID_Code_Chosei SAVEデータの調整コード
     */
    public void setSave_ID_Code_Chosei(String Save_ID_Code_Chosei) {
        this.Save_ID_Code_Chosei = Save_ID_Code_Chosei;
    }

    /**
     * SAVEデータの貸付残高を取得します。
     * @return SAVEデータの貸付残高
     */
    public String getSave_ID_M_KashitsukeZan() {
        return Save_ID_M_KashitsukeZan;
    }

    /**
     * SAVEデータの貸付残高を設定します。
     * @param Save_ID_M_KashitsukeZan SAVEデータの貸付残高
     */
    public void setSave_ID_M_KashitsukeZan(String Save_ID_M_KashitsukeZan) {
        this.Save_ID_M_KashitsukeZan = Save_ID_M_KashitsukeZan;
    }

    /**
     * 報告時分秒(非表示)を取得します。
     * @return 報告時分秒(非表示)
     */
    public String getID_Time_Report_H() {
        return ID_Time_Report_H;
    }

    /**
     * 報告時分秒(非表示)を設定します。
     * @param ID_Time_Report_H 報告時分秒(非表示)
     */
    public void setID_Time_Report_H(String ID_Time_Report_H) {
        this.ID_Time_Report_H = ID_Time_Report_H;
    }

    /**
     * 報告書番号(非表示)を取得します。
     * @return 報告書番号(非表示)
     */
    public String getID_ID_Report_H() {
        return ID_ID_Report_H;
    }

    /**
     * 報告書番号(非表示)を設定します。
     * @param ID_ID_Report_H 報告書番号(非表示)
     */
    public void setID_ID_Report_H(String ID_ID_Report_H) {
        this.ID_ID_Report_H = ID_ID_Report_H;
    }

    /**
     * 赤データ入力領域を取得します。
     * @return 赤データ入力領域
     */
    public String getRedArea() {
        return redArea;
    }

    /**
     * 赤データ入力領域を設定します。
     * @param redArea 赤データ入力領域
     */
    public void setRedArea(String redArea) {
        this.redArea = redArea;
    }

    /**
     * 黒データ入力領域を取得します。
     * @return 黒データ入力領域
     */
    public String getBlackArea() {
        return blackArea;
    }

    /**
     * 黒データ入力領域を設定します。
     * @param blackArea 黒データ入力領域
     */
    public void setBlackArea(String blackArea) {
        this.blackArea = blackArea;
    }

    /**
     * 処理種別(受渡)を取得します。
     * @return 処理種別(受渡)
     */
    public String getID_Type_Process_H() {
        return ID_Type_Process_H;
    }

    /**
     * 処理種別(受渡)を設定します。
     * @param ID_Type_Process_H 処理種別(受渡)
     */
    public void setID_Type_Process_H(String iD_Type_Process_H) {
        this.ID_Type_Process_H = iD_Type_Process_H;
    }

    /**
     * 操作選択を取得します。
     * @return 操作選択
     */
    public String getID_SelectOperation() {
        return ID_SelectOperation;
    }

    /**
     * 操作選択を設定します。
     * @param ID_SelectOperation 操作選択
     */
    public void setID_SelectOperation(String iD_SelectOperation) {
        ID_SelectOperation = iD_SelectOperation;
    }

    /**
     * ステータス(受渡)を取得します。
     * @return ステータス(受渡)
     */
    public String getID_Status_H() {
        return ID_Status_H;
    }

    /**
     * ステータス(受渡)を設定します。
     * @param ID_Status_H ステータス(受渡)
     */
    public void setID_Status_H(String iD_Status_H) {
        ID_Status_H = iD_Status_H;
    }

    /**
     * 報告書種別（値）(受渡)を取得します。
     * @return 報告書種別（値）(受渡)
     */
    public String getID_DataCode_H() {
        return ID_DataCode_H;
    }

    /**
     * 報告書種別（値）(受渡)を設定します。
     * @param ID_DataCode_H 報告書種別（値）(受渡)
     */
    public void setID_DataCode_H(String iD_DataCode_H) {
        ID_DataCode_H = iD_DataCode_H;
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
     * @param ID_Type_Process_H 処理種別
     */
    public void setID_Type_Process(String iD_Type_Process) {
        this.ID_Type_Process = iD_Type_Process;
    }

}