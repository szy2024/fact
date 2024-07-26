//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_02.web;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはmd002_02のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_02Form extends PNBaseForm {

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
	/** 資金使途 */
	private String lblID_Code_ShikinShito_Red;
	/** 事業別 */
	private String lblID_Code_Jigyobetsu_Red;
	/** 利率（％） */
	private java.math.BigDecimal lblID_Riritsu_Red;
	/** 特利区分 */
	private String lblID_Code_TokuriKubun_Red;
	/** 特利（％） */
	private java.math.BigDecimal lblID_Tokuri_Red;
	/** 据置期限 */
	private String lblID_Date_SueokiKigen_Red;
	/** 償還期限 */
	private String lblID_Date_ShokanKigen_Red;
	/** 元利金払込日 */
	private String lblID_Date_GanrikinHaraikomi_Red;
	/** 貸付実行日 */
	private String lblID_Date_Jikko_Red;
	/** 貸付実行金額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Kashitsuke_Red;
	/** 貸付実行時の資金交付額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_ShikinKofu_Red;
	/** 貸付実行時の貸付受入金受入額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeUkeire_Red;
	/** 貸付受入金残高(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeukeireZan_Red;
	/** 受託者勘定処理年月 */
	private String lblID_Date_Jtkshori_Red;
	/** 払出・元金充当日 */
	private String lblID_Date_HaraidashiJuto_Red;
	/** 資金払出額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Haraidashi_Red;
	/** 元金充当額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Ganju_Red;
	/** 元金充当後貸付金残高(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeZandakaAfterGanju_Red;
	/** 元金充当後第１回約定日 */
	private String lblID_Date_FirstYakujoAfterGanju_Red;
	/** 繰償事由コード */
	private String lblID_Code_KurishoJiyu_Red;
	/** 元金充当後の元金均等額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_GankinKintoAfterGanju_Red;
	/** 元金充当後の元金不均等額(円) */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_GankinFukintoAfterGanju_Red;
	/** 調整コード */
	private String rdoID_Code_Chosei_Red;
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
	/** 資金使途（修正） */
	private String lblID_Code_ShikinShito;
	/** 事業別（修正） */
	private String lblID_Code_Jigyobetsu;
	/** 利率（％）（修正） */
	private java.math.BigDecimal lblID_Riritsu;
	/** 特利区分（修正） */
	private String lblID_Kubun_Tokuri;
	/** 特利（％）（修正） */
	private java.math.BigDecimal lblID_Tokuri;
	/** 据置期限（修正） */
	private String lblID_Date_SueokiKigen;
	/** 償還期限（修正） */
	private String lblID_Date_ShokanKigen;
	/** 元利金払込日（修正） */
	private String lblID_Date_GanrikinHaraikomi;
	/** 貸付実行日（修正） */
	private String lblID_Date_Jikko;
	/** 貸付実行金額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Kashitsuke;
	/** 貸付実行時の資金交付額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_ShikinKofu;
	/** 貸付実行時の貸付受入金受入額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeUkeire;
	/** 貸付受入金残高(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeukeireZan;
	/** 受託者勘定処理年月（修正） */
	private String lblID_Date_Jtkshori;
	/** 払出・元金充当日（修正） */
	private String lblID_Date_HaraidashiJuto;
	/** 資金払出額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Haraidashi;
	/** 元金充当額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_Ganju;
	/** 元金充当後貸付金残高(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_KashitsukeZandakaAfterGanju;
	/** 元金充当後第１回約定日（修正） */
	private String lblID_Date_FirstYakujoAfterGanju;
	/** 繰償事由コード（修正） */
	private String lblID_Code_KurishoJiyu;
	/** 元金充当後の元金均等額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_GankinKintoAfterGanju;
	/** 元金充当後の元金不均等額(円)（修正） */
	@NumberFormat(pattern = "#,###")
	private java.math.BigDecimal lblID_M_GankinFukintoAfterGanju;
	/** 調整コード（修正） */
	private String rdoID_Code_Chosei;
	/** 報告年月日Ａ */
	private String ID_Date_Report;
	/** 顧客名Ａ */
	private String ID_Name_Customer;
	/** 扱店名Ａ */
	private String ID_Name_Organization;
	/** 公庫支店Ａ */
	private String ID_Code_KoukoShiten;
	/** 扱店Ａ */
	private String ID_Code_Organization;
	/** 店舗Ａ */
	private String ID_Code_Tenpo;
	/** 年度Ａ */
	private String ID_Year;
	/** 方式資金Ａ */
	private String ID_Code_HoshikiShikin;
	/** 番号Ａ */
	private String ID_ID_Ringi;
	/** 枝番Ａ */
	private String ID_ID_RingiBranch;
	/** 資金使途Ａ */
	private String ID_Code_ShikinShito;
	/** 事業別Ａ */
	private String ID_Code_Jigyobetsu;
	/** 利率 */
	private java.math.BigDecimal ID_Riritsu;
	/** 特利区分Ａ */
	private String ID_Code_TokuriKubun;
	/** 特利 */
	private java.math.BigDecimal ID_Tokuri;
	/** 据置期限Ａ */
	private String ID_Date_SueokiKigen;
	/** 償還期限Ａ */
	private String ID_Date_ShokanKigen;
	/** 元利金払込期日 */
	private String ID_Date_GanrikinHaraikomi;
	/** 貸付実行日Ａ */
	private String ID_Date_Jikko;
	/** 貸付実行額金額 */
	private java.math.BigDecimal ID_M_Kashitsuke;
	/** 資金交付額 */
	private java.math.BigDecimal ID_M_ShikinKofu;
	/** 貸付受入金受入額 */
	private java.math.BigDecimal ID_M_KashitsukeUkeire;
	/** 受託者勘定処理年月（DB取得および登録値） */
	private String ID_Date_Jtkshori;
	/** 受託者勘定処理年月（入力された年、月） */
	private String ID_Date_Jtkshori_Input;
	/** 受託者勘定処理年月（元号+年） */
	private String mstrID_Date_Jtkshori_Nen;
	/** 受託者勘定処理年月（年） */
	private String ID_Date_Jtkshori_Nen_Input;
	/** 受託者勘定処理年月（元号の値） */
	private String ID_Date_Jtkshori_Gengo_Value;
	/** 受託者勘定処理年月（元号の表示テキスト） */
	private String ID_Date_Jtkshori_Gengo_Text;
	/** 受託者勘定処理年月（月の表示テキスト） */
	private String ID_Date_JtkshoriTsuki_Text;
	/** 受託者勘定処理年月（月の値） */
	private String ID_Date_JtkshoriTsuki_Value;
	/** 払出・元金充当日（年、月、日） */
	private String ID_Date_HaraidashiJuto;
	/** 払出・元金充当日（元号+年） */
	private String ID_Date_HaraidashiJuto_NenA;
	/** 払出・元金充当日（年） */
	private String ID_Date_HaraidashiJuto_NenInput;
	/** 払出・元金充当日（元号の値） */
	private String ID_Date_HaraidashiJuto_Gengo_Value;
	/** 払出・元金充当日（元号の表示テキスト） */
	private String ID_Date_HaraidashiJuto_Gengo_Text;
	/** 払出・元金充当日の月のText値 */
	private String ID_Date_HaraidashiJutoTsuki_Text;
	/** 払出・元金充当日の日のText値 */
	private String ID_Date_HaraidashiJutoBi_Text;
	/** 払出・元金充当日の月の値 */
	private String ID_Date_HaraidashiJutoTsuki_Value;
	/** 払出・元金充当日の日の値 */
	private String ID_Date_HaraidashiJutoBi_Value;
	/** 資金払出額 */
	private String ID_M_Haraidashi;
	/** 元金充当額 */
	private java.math.BigDecimal ID_M_Ganju;
	/** 貸付受入金残高 */
	private java.math.BigDecimal ID_M_KashitsukeukeireZan;
	/** 元金充当後貸付金残高 */
	private java.math.BigDecimal ID_M_KashitsukeZandakaAfterGanju;
	/** 元金充当後第１回約定日Ａ */
	private String ID_Date_FirstYakujoAfterGanju;
	/** 繰上償還事由コード */
	private String ID_Code_KurishoJiyu;
	/** 繰上償還事由コードのText値 */
	private String ID_Code_KurishoJiyu_Text;
	/** 元金充当後の元金均等額 */
	private java.math.BigDecimal ID_M_GankinKintoAfterGanju;
	/** 元金充当後の元金不均等額 */
	private java.math.BigDecimal ID_M_GankinFukintoAfterGanju;
	/** 調整コードＡ */
	private String ID_Code_Chosei;
	/** 調整コードのText値 */
	private String ID_Code_Chosei_Text;
	/** 報告書番号（非表示） */
	private String ID_ID_Report;
	/** 報告時分秒（非表示） */
	private String ID_Time_Report;
	/** ユーザID（非表示） */
	private String ID_UserID;
	/** 伝送番号（非表示） */
	private String ID_ID_Denso;
	/** データコード（非表示） */
	private String ID_Data_Code;
	/** 合計（非表示）（修正） */
	private java.math.BigDecimal ID_M_Kei;
	/** 合計（非表示） */
	private java.math.BigDecimal ID_M_Kei_Red;
	/** 報告書履歴番号（非表示） */
	private String ID_ID_History;
	/** ステータス（非表示） */
	private String ID_Status;
	/** 処理種別（非表示） */
	private String ID_Type_Process;
	/** 取消済みフラグ（非表示） */
	private String ID_Flag_Torikeshizumi;
	/** エラーコード（非表示） */
	private String ID_Code_Error;
	/** エラーメッセージ（非表示） */
	private String ID_ErrorMessage;
	/** 債権管理番号（非表示） */
	private String ID_ID_Credit;
	/** 顧客コード（非表示） */
	private String ID_Code_Customer;
	/** 退避賦金（非表示） */
	private java.math.BigDecimal ID_Keep_M_Fukin;
	/** 退避元金不均等（非表示） */
	private java.math.BigDecimal ID_Keep_M_GankinFukinto;
	/** 退避元金不均等区分（非表示） */
	private String ID_Keep_Kubun_GankinFukinto;
	/** 退避貸付金残高（非表示） */
	private java.math.BigDecimal ID_Keep_M_KashitsukeZan;
	/** 退避約定元金（非表示） */
	private java.math.BigDecimal ID_Keep_M_YakujoGankin;
	/** 退避約定利息（非表示） */
	private java.math.BigDecimal ID_Keep_M_YakujoRisoku;
	/** 退避償還期限年月（非表示） */
	private String ID_Keep_Date_ShokanKigen;
	/** 退避条変起案中区分（非表示） */
	private String ID_Keep_JohenKianchu;
	/** 更新用賦金（非表示） */
	private java.math.BigDecimal ID_Up_M_Fukin;
	/** 更新用元金不均等（非表示） */
	private java.math.BigDecimal ID_Up_M_GankinFukinto;
	/** 更新用元金不均等区分（非表示） */
	private String ID_Up_Kubun_GankinFukinto;
	/** 更新用貸付金残高（非表示） */
	private java.math.BigDecimal ID_Up_M_KashitsukeZan;
	/** 更新用約定元金（非表示） */
	private java.math.BigDecimal ID_Up_M_YakujoGankin;
	/** 更新用約定利息（非表示） */
	private java.math.BigDecimal ID_Up_M_YakujoRisoku;
	/** 更新用償還期限年月（非表示） */
	private String ID_Up_Date_ShokanKigen;
	/** 更新用条変起案中区分（非表示） */
	private String ID_Up_Kubun_JohenKianchu;
	/** 原本番号（非表示） */
	private String ID_ID_Master;
	/** 署名付きデータ（非表示） */
	private String ID_SignData;
	/** 報告書履歴番号UP（非表示） */
	private String ID_Up_ID_History;
	/** 表示画面のヘッダ項目 */
	private String ID_InputHead;
	/** 稟議・賦金（非表示） */
	private java.math.BigDecimal ID_M_Fukin_Ringi;
	/** 稟議・元金不均等（非表示） */
	private java.math.BigDecimal ID_M_GankinFukinto_Ringi;
	/** 稟議・元金不均等区分（非表示） */
	private String ID_Kubun_GankinFukinto_Ringi;
	/** 稟議・貸付金残高（非表示） */
	private java.math.BigDecimal ID_M_KashitsukeZan_Ringi;
	/** 稟議・償還期限年月（非表示） */
	private String ID_Date_ShokanKigen_Ringi;
	/** 稟議・最新変更変月日（非表示） */
	private String ID_Date_SaishiHenko_Ringi;
	/** 稟議・償還方法コード（非表示） */
	private String ID_Code_ShokanHouhou_Ringi;
	/** 稟議・特利有効期限（非表示） */
	private String ID_Date_TokuriYuko_Ringi;
	/** 稟議・条変起案中区分（非表示） */
	private String ID_Kubun_JohenKianchu_Ringi;
	/** 償還方法タイプ識別値 （DB更新時の受渡し領域） */
	private String Type_Shokan;
	/** 前回払出・債権管理番号 */
	private java.math.BigDecimal ID_HDLas_ID_Credit;
	/** 前回払出・計数管理処理番号 */
	private String ID_HDLas_KeisuKanriShori;
	/** 更新用払出・払出額 */
	private java.math.BigDecimal ID_HDLas_M_Haraidashi;
	/** 前回払出・払出累計額 */
	private java.math.BigDecimal ID_HDLas_M_HaraidashiRuikei;
	/** 前回払出・繰上償還額 */
	private java.math.BigDecimal ID_HDLas_M_Kurisho;
	/** 前回払出・繰上償還累計額 */
	private java.math.BigDecimal ID_HDLas_M_KurishoRuikei;
	/** 前回払出・更生処理区分 */
	private String ID_HDLas_Kubun_KoseiShori;
	/** 前回払出・貸付受入金残高積数 */
	private java.math.BigDecimal ID_HDLas_M_ZandakaSekisu;
	/** 前回払出・払出充当年月日 */
	private String ID_HDLas_Date_HaraidashiJuto;
	/** 前回払出・貸付受入金残高 */
	private java.math.BigDecimal ID_HDLas_M_HaraidashiKashitsukeZan;
	/** 前回払出・払出額有無フラグ（true=有） */
	private String ID_HDLas_M_HaraidashiFlag;
	/** 前回払出・繰上償還額有無フラグ（true=有） */
	private String ID_HDLas_M_KurishoFlag;
	/** 取消用払出・債権管理番号 */
	private java.math.BigDecimal ID_HDDel1_ID_Credit;
	/** 取消用払出・計数管理処理番号 */
	private String ID_HDDel1_KeisuKanriShori;
	/** 取消用払出・払出額 */
	private java.math.BigDecimal ID_HDDel1_M_Haraidashi;
	/** 取消用払出・払出累計額 */
	private java.math.BigDecimal ID_HDDel1_M_HaraidashiRuikei;
	/** 取消用払出・繰上償還額 */
	private java.math.BigDecimal ID_HDDel1_M_Kurisho;
	/** 取消用払出・繰上償還累計額 */
	private java.math.BigDecimal ID_HDDel1_M_KurishoRuikei;
	/** 取消用払出・更生処理区分 */
	private String ID_HDDel1_Kubun_KoseiShori;
	/** 取消用払出・貸付受入金残高積数 */
	private java.math.BigDecimal ID_HDDel1_M_ZandakaSekisu;
	/** 取消用払出・払出充当年月日 */
	private String ID_HDDel1_Date_HaraidashiJuto;
	/** 取消用払出・貸付受入金残高 */
	private java.math.BigDecimal ID_HDDel1_M_HaraidashiKashitsukeZan;
	/** Insert用払出・債権管理番号 */
	private java.math.BigDecimal ID_Ins_ID_Credit;
	/** Insert用払出・計数管理処理番号 */
	private String ID_Ins_KeisuKanriShori;
	/** Insert用払出・払出額 */
	private java.math.BigDecimal ID_Ins_M_Haraidashi;
	/** Insert用払出・払出累計額 */
	private java.math.BigDecimal ID_Ins_M_HaraidashiRuikei;
	/** Insert用払出・繰上償還額 */
	private java.math.BigDecimal ID_Ins_M_Kurisho;
	/** Insert用払出・繰上償還累計額 */
	private java.math.BigDecimal ID_Ins_M_KurishoRuikei;
	/** Insert用払出・更生処理区分 */
	private String ID_Ins_Kubun_KoseiShori;
	/** Insert用払出・貸付受入金残高積数 */
	private java.math.BigDecimal ID_Ins_M_ZandakaSekisu;
	/** Insert用払出・払出充当年月日 */
	private String ID_Ins_Date_HaraidashiJuto;
	/** Insert用払出・貸付受入金残高 */
	private java.math.BigDecimal ID_Ins_M_HaraidashiKashitsukeZan;
	/** 修正用払出・債権管理番号 */
	private java.math.BigDecimal ID_HDNew0_ID_Credit;
	/** 修正用払出・計数管理処理番号 */
	private String ID_HDNew0_KeisuKanriShori;
	/** 修正用払出・払出額 */
	private java.math.BigDecimal ID_HDNew_M_Haraidashi;
	/** 修正用払出・払出累計額 */
	private java.math.BigDecimal ID_HDNew0_M_HaraidashiRuikei;
	/** 修正用払出・繰上償還額 */
	private java.math.BigDecimal ID_HDNew0_M_Kurisho;
	/** 修正用払出・繰上償還累計額 */
	private java.math.BigDecimal ID_HDNew0_M_KurishoRuikei;
	/** 修正用払出・更生処理区分 */
	private String ID_HDNew0_Kubun_KoseiShori;
	/** 修正用払出・貸付受入金残高積数 */
	private java.math.BigDecimal ID_HDNew0_M_ZandakaSekisu;
	/** 修正用払出・払出充当年月日 */
	private String ID_HDNew0_Date_HaraidashiJuto;
	/** 修正用払出・貸付受入金残高 */
	private java.math.BigDecimal ID_HDNew0_M_HaraidashiKashitsukeZan;
	/** 次回約定データ・約定前残高 */
	private java.math.BigDecimal ID_YJNxt_M_ZandakaBeforeYakujo;
	/** 次回約定データ・約定元金 */
	private java.math.BigDecimal ID_YJNxt_M_YakujoGankin;
	/** 次回約定データ・約定利息 */
	private java.math.BigDecimal ID_YJNxt_M_YakujoRisoku;
	/** Key債権管理番号 */
	private java.math.BigDecimal Key_ID_Credit;
	/** Key計数管理処理番号 */
	private String Key_ID_KeisuKanriShori;
	/** 計算結果用賦金 */
	private java.math.BigDecimal ID_Rst_M_Fukin;
	/** 計算結果調整コード */
	private String ID_Rst_Code_Chosei;
	/** 計算結果用元金均等額 */
	private java.math.BigDecimal ID_Rst_M_GankinKinto;
	/** 計算結果用元金不均等額 */
	private java.math.BigDecimal ID_Rst_M_GankinFukinto;
	/** 計算約定元金（非表示） */
	private java.math.BigDecimal ID_Rst_M_YakujoGankin;
	/** 計算約定利息（非表示） */
	private java.math.BigDecimal ID_Rst_M_YakujoRisoku;
	/** 請求データ更新用・Key:払込年月日　領域 */
	private String ID_Key_Date_Haraikomi_SeikyuUp;
	/** 賦金計算用・約定・約定元金 */
	private java.math.BigDecimal ID_M_YakujoGankin_Yakujo_Fukin;
	/** 賦金計算用・約定・約定利息 */
	private java.math.BigDecimal ID_M_YakujoRisoku_Yakujo_Fukin;
	/** 賦金計算用・約定・払込期日 */
	private String ID_Date_Haraikomi_Yakujo_Fukin;
	/** 賦金計算用・約定・請求繰上利息 */
	private java.math.BigDecimal ID_M_SeikuriRisoku_Yakujo_Fukin;
	/** 扱店別稟議データの最新データ更新日付 */
	private String ID_Data_LastUpDate;
	/** 退避履歴番号 */
	private String ID_Keep_ID_History;
	/** 保存・取消１用払出・債権管理番号 */
	private java.math.BigDecimal ID_HDDel1_Keep_ID_Credit;
	/** 保存・取消１用払出・計数管理処理番号 */
	private String ID_HDDel1_Keep_ID_KeisuKanriShori;
	/** 保存・取消１用払出・払出額 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_Haraidashi;
	/** 保存・取消１用払出・払出累計額 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_HaraidashiRuikei;
	/** 保存・取消１用払出・繰上償還額 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_Kurisho;
	/** 保存・取消１用払出・繰上償還累計額 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_KurishoRuikei;
	/** 保存・取消１用払出・更生処理区分 */
	private String ID_HDDel1_Keep_Kubun_KoseiShori;
	/** 保存・取消１用払出・貸付受入金残高積数 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_ZandakaSekisu;
	/** 保存・取消１用払出・払出充当年月日 */
	private String ID_HDDel1_Keep_Date_HaraidashiJuto;
	/** 保存・取消１用払出・貸付受入金残高 */
	private java.math.BigDecimal ID_HDDel1_Keep_M_HaraidashiKashitsukeZan;
	/** 報告書種別（値）(非表示) */
	private String DataCode;
	/** 処理モード */
	private String Process_Mode;
	/** 請求データ更新判定フラグ */
	boolean seikyuShuseiUp;
	String ringiRedFlg;
	int saveProcMode;
	String charCode_ShokanHouhou;
	/** 請求・払込年月日（非表示） */
	private String ID_Key_Date_Haraikomi_Seikyu_Shusei;
	/** 請求データを取消更新する場合のフラグ */
	private boolean flgSeikyuUpShusei;
	/** 請求データを修正更新する場合のフラグ */
	private boolean flgSeikyuUpTorikeshi;
	/** セット条変起案中区分 */
	private String ID_Set_Kubun_JohenKianchu;
	/** 請求_取消用・払込年月日 */
	private String ID_Key_Date_Haraikomi_Seikyu_Torikeshi;
	/** 請求　取消用・約定元金 */
	private java.math.BigDecimal ID_M_YakujoGankin_Seikyu_Torikeshi;
	/** 請求　取消用・約定利息 */
	private java.math.BigDecimal ID_M_YakujoRisoku_Seikyu_Torikeshi;
	/** モードタイプ */
	private String ModeType;
	/** 赤データ入力域 */
	private String Red_Area;
	/** 黒データ入力域 */
	private String Brack_Area;
	/** 赤データ入力領域タイトル（"赤"） */
	private String lblID_Head_Red2;

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
	 * 資金使途を取得します。
	 * @return 資金使途
	 */
	public String getLblID_Code_ShikinShito_Red() {
		return lblID_Code_ShikinShito_Red;
	}

	/**
	 * 資金使途を設定します。
	 * @param lblID_Code_ShikinShito_Red 資金使途
	 */
	public void setLblID_Code_ShikinShito_Red(String lblID_Code_ShikinShito_Red) {
		this.lblID_Code_ShikinShito_Red = lblID_Code_ShikinShito_Red;
	}

	/**
	 * 事業別を取得します。
	 * @return 事業別
	 */
	public String getLblID_Code_Jigyobetsu_Red() {
		return lblID_Code_Jigyobetsu_Red;
	}

	/**
	 * 事業別を設定します。
	 * @param lblID_Code_Jigyobetsu_Red 事業別
	 */
	public void setLblID_Code_Jigyobetsu_Red(String lblID_Code_Jigyobetsu_Red) {
		this.lblID_Code_Jigyobetsu_Red = lblID_Code_Jigyobetsu_Red;
	}

	/**
	 * 利率（％）を取得します。
	 * @return 利率（％）
	 */
	public java.math.BigDecimal getLblID_Riritsu_Red() {
		return lblID_Riritsu_Red;
	}

	/**
	 * 利率（％）を設定します。
	 * @param lblID_Riritsu_Red 利率（％）
	 */
	public void setLblID_Riritsu_Red(java.math.BigDecimal lblID_Riritsu_Red) {
		this.lblID_Riritsu_Red = lblID_Riritsu_Red;
	}

	/**
	 * 特利区分を取得します。
	 * @return 特利区分
	 */
	public String getLblID_Code_TokuriKubun_Red() {
		return lblID_Code_TokuriKubun_Red;
	}

	/**
	 * 特利区分を設定します。
	 * @param lblID_Code_TokuriKubun_Red 特利区分
	 */
	public void setLblID_Code_TokuriKubun_Red(String lblID_Code_TokuriKubun_Red) {
		this.lblID_Code_TokuriKubun_Red = lblID_Code_TokuriKubun_Red;
	}

	/**
	 * 特利（％）を取得します。
	 * @return 特利（％）
	 */
	public java.math.BigDecimal getLblID_Tokuri_Red() {
		return lblID_Tokuri_Red;
	}

	/**
	 * 特利（％）を設定します。
	 * @param lblID_Tokuri_Red 特利（％）
	 */
	public void setLblID_Tokuri_Red(java.math.BigDecimal lblID_Tokuri_Red) {
		this.lblID_Tokuri_Red = lblID_Tokuri_Red;
	}

	/**
	 * 据置期限を取得します。
	 * @return 据置期限
	 */
	public String getLblID_Date_SueokiKigen_Red() {
		return lblID_Date_SueokiKigen_Red;
	}

	/**
	 * 据置期限を設定します。
	 * @param lblID_Date_SueokiKigen_Red 据置期限
	 */
	public void setLblID_Date_SueokiKigen_Red(String lblID_Date_SueokiKigen_Red) {
		this.lblID_Date_SueokiKigen_Red = lblID_Date_SueokiKigen_Red;
	}

	/**
	 * 償還期限を取得します。
	 * @return 償還期限
	 */
	public String getLblID_Date_ShokanKigen_Red() {
		return lblID_Date_ShokanKigen_Red;
	}

	/**
	 * 償還期限を設定します。
	 * @param lblID_Date_ShokanKigen_Red 償還期限
	 */
	public void setLblID_Date_ShokanKigen_Red(String lblID_Date_ShokanKigen_Red) {
		this.lblID_Date_ShokanKigen_Red = lblID_Date_ShokanKigen_Red;
	}

	/**
	 * 元利金払込日を取得します。
	 * @return 元利金払込日
	 */
	public String getLblID_Date_GanrikinHaraikomi_Red() {
		return lblID_Date_GanrikinHaraikomi_Red;
	}

	/**
	 * 元利金払込日を設定します。
	 * @param lblID_Date_GanrikinHaraikomi_Red 元利金払込日
	 */
	public void setLblID_Date_GanrikinHaraikomi_Red(String lblID_Date_GanrikinHaraikomi_Red) {
		this.lblID_Date_GanrikinHaraikomi_Red = lblID_Date_GanrikinHaraikomi_Red;
	}

	/**
	 * 貸付実行日を取得します。
	 * @return 貸付実行日
	 */
	public String getLblID_Date_Jikko_Red() {
		return lblID_Date_Jikko_Red;
	}

	/**
	 * 貸付実行日を設定します。
	 * @param lblID_Date_Jikko_Red 貸付実行日
	 */
	public void setLblID_Date_Jikko_Red(String lblID_Date_Jikko_Red) {
		this.lblID_Date_Jikko_Red = lblID_Date_Jikko_Red;
	}

	/**
	 * 貸付実行金額(円)を取得します。
	 * @return 貸付実行金額(円)
	 */
	public java.math.BigDecimal getLblID_M_Kashitsuke_Red() {
		return lblID_M_Kashitsuke_Red;
	}

	/**
	 * 貸付実行金額(円)を設定します。
	 * @param lblID_M_Kashitsuke_Red 貸付実行金額(円)
	 */
	public void setLblID_M_Kashitsuke_Red(java.math.BigDecimal lblID_M_Kashitsuke_Red) {
		this.lblID_M_Kashitsuke_Red = lblID_M_Kashitsuke_Red;
	}

	/**
	 * 貸付実行時の資金交付額(円)を取得します。
	 * @return 貸付実行時の資金交付額(円)
	 */
	public java.math.BigDecimal getLblID_M_ShikinKofu_Red() {
		return lblID_M_ShikinKofu_Red;
	}

	/**
	 * 貸付実行時の資金交付額(円)を設定します。
	 * @param lblID_M_ShikinKofu_Red 貸付実行時の資金交付額(円)
	 */
	public void setLblID_M_ShikinKofu_Red(java.math.BigDecimal lblID_M_ShikinKofu_Red) {
		this.lblID_M_ShikinKofu_Red = lblID_M_ShikinKofu_Red;
	}

	/**
	 * 貸付実行時の貸付受入金受入額(円)を取得します。
	 * @return 貸付実行時の貸付受入金受入額(円)
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeUkeire_Red() {
		return lblID_M_KashitsukeUkeire_Red;
	}

	/**
	 * 貸付実行時の貸付受入金受入額(円)を設定します。
	 * @param lblID_M_KashitsukeUkeire_Red 貸付実行時の貸付受入金受入額(円)
	 */
	public void setLblID_M_KashitsukeUkeire_Red(java.math.BigDecimal lblID_M_KashitsukeUkeire_Red) {
		this.lblID_M_KashitsukeUkeire_Red = lblID_M_KashitsukeUkeire_Red;
	}

	/**
	 * 貸付受入金残高(円)を取得します。
	 * @return 貸付受入金残高(円)
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeukeireZan_Red() {
		return lblID_M_KashitsukeukeireZan_Red;
	}

	/**
	 * 貸付受入金残高(円)を設定します。
	 * @param lblID_M_KashitsukeukeireZan_Red 貸付受入金残高(円)
	 */
	public void setLblID_M_KashitsukeukeireZan_Red(java.math.BigDecimal lblID_M_KashitsukeukeireZan_Red) {
		this.lblID_M_KashitsukeukeireZan_Red = lblID_M_KashitsukeukeireZan_Red;
	}

	/**
	 * 受託者勘定処理年月を取得します。
	 * @return 受託者勘定処理年月
	 */
	public String getLblID_Date_Jtkshori_Red() {
		return lblID_Date_Jtkshori_Red;
	}

	/**
	 * 受託者勘定処理年月を設定します。
	 * @param lblID_Date_Jtkshori_Red 受託者勘定処理年月
	 */
	public void setLblID_Date_Jtkshori_Red(String lblID_Date_Jtkshori_Red) {
		this.lblID_Date_Jtkshori_Red = lblID_Date_Jtkshori_Red;
	}

	/**
	 * 払出・元金充当日を取得します。
	 * @return 払出・元金充当日
	 */
	public String getLblID_Date_HaraidashiJuto_Red() {
		return lblID_Date_HaraidashiJuto_Red;
	}

	/**
	 * 払出・元金充当日を設定します。
	 * @param lblID_Date_HaraidashiJuto_Red 払出・元金充当日
	 */
	public void setLblID_Date_HaraidashiJuto_Red(String lblID_Date_HaraidashiJuto_Red) {
		this.lblID_Date_HaraidashiJuto_Red = lblID_Date_HaraidashiJuto_Red;
	}

	/**
	 * 資金払出額(円)を取得します。
	 * @return 資金払出額(円)
	 */
	public java.math.BigDecimal getLblID_M_Haraidashi_Red() {
		return lblID_M_Haraidashi_Red;
	}

	/**
	 * 資金払出額(円)を設定します。
	 * @param lblID_M_Haraidashi_Red 資金払出額(円)
	 */
	public void setLblID_M_Haraidashi_Red(java.math.BigDecimal lblID_M_Haraidashi_Red) {
		this.lblID_M_Haraidashi_Red = lblID_M_Haraidashi_Red;
	}

	/**
	 * 元金充当額(円)を取得します。
	 * @return 元金充当額(円)
	 */
	public java.math.BigDecimal getLblID_M_Ganju_Red() {
		return lblID_M_Ganju_Red;
	}

	/**
	 * 元金充当額(円)を設定します。
	 * @param lblID_M_Ganju_Red 元金充当額(円)
	 */
	public void setLblID_M_Ganju_Red(java.math.BigDecimal lblID_M_Ganju_Red) {
		this.lblID_M_Ganju_Red = lblID_M_Ganju_Red;
	}

	/**
	 * 元金充当後貸付金残高(円)を取得します。
	 * @return 元金充当後貸付金残高(円)
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeZandakaAfterGanju_Red() {
		return lblID_M_KashitsukeZandakaAfterGanju_Red;
	}

	/**
	 * 元金充当後貸付金残高(円)を設定します。
	 * @param lblID_M_KashitsukeZandakaAfterGanju_Red 元金充当後貸付金残高(円)
	 */
	public void setLblID_M_KashitsukeZandakaAfterGanju_Red(
			java.math.BigDecimal lblID_M_KashitsukeZandakaAfterGanju_Red) {
		this.lblID_M_KashitsukeZandakaAfterGanju_Red = lblID_M_KashitsukeZandakaAfterGanju_Red;
	}

	/**
	 * 元金充当後第１回約定日を取得します。
	 * @return 元金充当後第１回約定日
	 */
	public String getLblID_Date_FirstYakujoAfterGanju_Red() {
		return lblID_Date_FirstYakujoAfterGanju_Red;
	}

	/**
	 * 元金充当後第１回約定日を設定します。
	 * @param lblID_Date_FirstYakujoAfterGanju_Red 元金充当後第１回約定日
	 */
	public void setLblID_Date_FirstYakujoAfterGanju_Red(String lblID_Date_FirstYakujoAfterGanju_Red) {
		this.lblID_Date_FirstYakujoAfterGanju_Red = lblID_Date_FirstYakujoAfterGanju_Red;
	}

	/**
	 * 繰償事由コードを取得します。
	 * @return 繰償事由コード
	 */
	public String getLblID_Code_KurishoJiyu_Red() {
		return lblID_Code_KurishoJiyu_Red;
	}

	/**
	 * 繰償事由コードを設定します。
	 * @param lblID_Code_KurishoJiyu_Red 繰償事由コード
	 */
	public void setLblID_Code_KurishoJiyu_Red(String lblID_Code_KurishoJiyu_Red) {
		this.lblID_Code_KurishoJiyu_Red = lblID_Code_KurishoJiyu_Red;
	}

	/**
	 * 元金充当後の元金均等額(円)を取得します。
	 * @return 元金充当後の元金均等額(円)
	 */
	public java.math.BigDecimal getLblID_M_GankinKintoAfterGanju_Red() {
		return lblID_M_GankinKintoAfterGanju_Red;
	}

	/**
	 * 元金充当後の元金均等額(円)を設定します。
	 * @param lblID_M_GankinKintoAfterGanju_Red 元金充当後の元金均等額(円)
	 */
	public void setLblID_M_GankinKintoAfterGanju_Red(java.math.BigDecimal lblID_M_GankinKintoAfterGanju_Red) {
		this.lblID_M_GankinKintoAfterGanju_Red = lblID_M_GankinKintoAfterGanju_Red;
	}

	/**
	 * 元金充当後の元金不均等額(円)を取得します。
	 * @return 元金充当後の元金不均等額(円)
	 */
	public java.math.BigDecimal getLblID_M_GankinFukintoAfterGanju_Red() {
		return lblID_M_GankinFukintoAfterGanju_Red;
	}

	/**
	 * 元金充当後の元金不均等額(円)を設定します。
	 * @param lblID_M_GankinFukintoAfterGanju_Red 元金充当後の元金不均等額(円)
	 */
	public void setLblID_M_GankinFukintoAfterGanju_Red(
			java.math.BigDecimal lblID_M_GankinFukintoAfterGanju_Red) {
		this.lblID_M_GankinFukintoAfterGanju_Red = lblID_M_GankinFukintoAfterGanju_Red;
	}

	/**
	 * 調整コードを取得します。
	 * @return 調整コード
	 */
	public String getRdoID_Code_Chosei_Red() {
		return rdoID_Code_Chosei_Red;
	}

	/**
	 * 調整コードを設定します。
	 * @param rdoID_Code_Chosei_Red 調整コード
	 */
	public void setRdoID_Code_Chosei_Red(String rdoID_Code_Chosei_Red) {
		this.rdoID_Code_Chosei_Red = rdoID_Code_Chosei_Red;
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
	 * @param lblID_Code_KoukoShiten 公庫支店（修正）
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
	 * 資金使途（修正）を取得します。
	 * @return 資金使途（修正）
	 */
	public String getLblID_Code_ShikinShito() {
		return lblID_Code_ShikinShito;
	}

	/**
	 * 資金使途（修正）を設定します。
	 * @param lblID_Code_ShikinShito 資金使途（修正）
	 */
	public void setLblID_Code_ShikinShito(String lblID_Code_ShikinShito) {
		this.lblID_Code_ShikinShito = lblID_Code_ShikinShito;
	}

	/**
	 * 事業別（修正）を取得します。
	 * @return 事業別（修正）
	 */
	public String getLblID_Code_Jigyobetsu() {
		return lblID_Code_Jigyobetsu;
	}

	/**
	 * 事業別（修正）を設定します。
	 * @param lblID_Code_Jigyobetsu 事業別（修正）
	 */
	public void setLblID_Code_Jigyobetsu(String lblID_Code_Jigyobetsu) {
		this.lblID_Code_Jigyobetsu = lblID_Code_Jigyobetsu;
	}

	/**
	 * 利率（％）（修正）を取得します。
	 * @return 利率（％）（修正）
	 */
	public java.math.BigDecimal getLblID_Riritsu() {
		return lblID_Riritsu;
	}

	/**
	 * 利率（％）（修正）を設定します。
	 * @param lblID_Riritsu 利率（％）（修正）
	 */
	public void setLblID_Riritsu(java.math.BigDecimal lblID_Riritsu) {
		this.lblID_Riritsu = lblID_Riritsu;
	}

	/**
	 * 特利区分（修正）を取得します。
	 * @return 特利区分（修正）
	 */
	public String getLblID_Kubun_Tokuri() {
		return lblID_Kubun_Tokuri;
	}

	/**
	 * 特利区分（修正）を設定します。
	 * @param lblID_Kubun_Tokuri 特利区分（修正）
	 */
	public void setLblID_Kubun_Tokuri(String lblID_Kubun_Tokuri) {
		this.lblID_Kubun_Tokuri = lblID_Kubun_Tokuri;
	}

	/**
	 * 特利（％）（修正）を取得します。
	 * @return 特利（％）（修正）
	 */
	public java.math.BigDecimal getLblID_Tokuri() {
		return lblID_Tokuri;
	}

	/**
	 * 特利（％）（修正）を設定します。
	 * @param lblID_Tokuri 特利（％）（修正）
	 */
	public void setLblID_Tokuri(java.math.BigDecimal lblID_Tokuri) {
		this.lblID_Tokuri = lblID_Tokuri;
	}

	/**
	 * 据置期限（修正）を取得します。
	 * @return 据置期限（修正）
	 */
	public String getLblID_Date_SueokiKigen() {
		return lblID_Date_SueokiKigen;
	}

	/**
	 * 据置期限（修正）を設定します。
	 * @param lblID_Date_SueokiKigen 据置期限（修正）
	 */
	public void setLblID_Date_SueokiKigen(String lblID_Date_SueokiKigen) {
		this.lblID_Date_SueokiKigen = lblID_Date_SueokiKigen;
	}

	/**
	 * 償還期限（修正）を取得します。
	 * @return 償還期限（修正）
	 */
	public String getLblID_Date_ShokanKigen() {
		return lblID_Date_ShokanKigen;
	}

	/**
	 * 償還期限（修正）を設定します。
	 * @param lblID_Date_ShokanKigen 償還期限（修正）
	 */
	public void setLblID_Date_ShokanKigen(String lblID_Date_ShokanKigen) {
		this.lblID_Date_ShokanKigen = lblID_Date_ShokanKigen;
	}

	/**
	 * 元利金払込日（修正）を取得します。
	 * @return 元利金払込日（修正）
	 */
	public String getLblID_Date_GanrikinHaraikomi() {
		return lblID_Date_GanrikinHaraikomi;
	}

	/**
	 * 元利金払込日（修正）を設定します。
	 * @param lblID_Date_GanrikinHaraikomi 元利金払込日（修正）
	 */
	public void setLblID_Date_GanrikinHaraikomi(String lblID_Date_GanrikinHaraikomi) {
		this.lblID_Date_GanrikinHaraikomi = lblID_Date_GanrikinHaraikomi;
	}

	/**
	 * 貸付実行日（修正）を取得します。
	 * @return 貸付実行日（修正）
	 */
	public String getLblID_Date_Jikko() {
		return lblID_Date_Jikko;
	}

	/**
	 * 貸付実行日（修正）を設定します。
	 * @param lblID_Date_Jikko 貸付実行日（修正）
	 */
	public void setLblID_Date_Jikko(String lblID_Date_Jikko) {
		this.lblID_Date_Jikko = lblID_Date_Jikko;
	}

	/**
	 * 貸付実行金額(円)（修正）を取得します。
	 * @return 貸付実行金額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_Kashitsuke() {
		return lblID_M_Kashitsuke;
	}

	/**
	 * 貸付実行金額(円)（修正）を設定します。
	 * @param lblID_M_Kashitsuke 貸付実行金額(円)（修正）
	 */
	public void setLblID_M_Kashitsuke(java.math.BigDecimal lblID_M_Kashitsuke) {
		this.lblID_M_Kashitsuke = lblID_M_Kashitsuke;
	}

	/**
	 * 貸付実行時の資金交付額(円)（修正）を取得します。
	 * @return 貸付実行時の資金交付額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_ShikinKofu() {
		return lblID_M_ShikinKofu;
	}

	/**
	 * 貸付実行時の資金交付額(円)（修正）を設定します。
	 * @param lblID_M_ShikinKofu 貸付実行時の資金交付額(円)（修正）
	 */
	public void setLblID_M_ShikinKofu(java.math.BigDecimal lblID_M_ShikinKofu) {
		this.lblID_M_ShikinKofu = lblID_M_ShikinKofu;
	}

	/**
	 * 貸付実行時の貸付受入金受入額(円)（修正）を取得します。
	 * @return 貸付実行時の貸付受入金受入額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeUkeire() {
		return lblID_M_KashitsukeUkeire;
	}

	/**
	 * 貸付実行時の貸付受入金受入額(円)（修正）を設定します。
	 * @param lblID_M_KashitsukeUkeire 貸付実行時の貸付受入金受入額(円)（修正）
	 */
	public void setLblID_M_KashitsukeUkeire(java.math.BigDecimal lblID_M_KashitsukeUkeire) {
		this.lblID_M_KashitsukeUkeire = lblID_M_KashitsukeUkeire;
	}

	/**
	 * 貸付受入金残高(円)（修正）を取得します。
	 * @return 貸付受入金残高(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeukeireZan() {
		return lblID_M_KashitsukeukeireZan;
	}

	/**
	 * 貸付受入金残高(円)（修正）を設定します。
	 * @param lblID_M_KashitsukeukeireZan 貸付受入金残高(円)（修正）
	 */
	public void setLblID_M_KashitsukeukeireZan(java.math.BigDecimal lblID_M_KashitsukeukeireZan) {
		this.lblID_M_KashitsukeukeireZan = lblID_M_KashitsukeukeireZan;
	}

	/**
	 * 受託者勘定処理年月（修正）を取得します。
	 * @return 受託者勘定処理年月（修正）
	 */
	public String getLblID_Date_Jtkshori() {
		return lblID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月（修正）を設定します。
	 * @param lblID_Date_Jtkshori 受託者勘定処理年月（修正）
	 */
	public void setLblID_Date_Jtkshori(String lblID_Date_Jtkshori) {
		this.lblID_Date_Jtkshori = lblID_Date_Jtkshori;
	}

	/**
	 * 払出・元金充当日（修正）を取得します。
	 * @return 払出・元金充当日（修正）
	 */
	public String getLblID_Date_HaraidashiJuto() {
		return lblID_Date_HaraidashiJuto;
	}

	/**
	 * 払出・元金充当日（修正）を設定します。
	 * @param lblID_Date_HaraidashiJuto 払出・元金充当日（修正）
	 */
	public void setLblID_Date_HaraidashiJuto(String lblID_Date_HaraidashiJuto) {
		this.lblID_Date_HaraidashiJuto = lblID_Date_HaraidashiJuto;
	}

	/**
	 * 資金払出額(円)（修正）を取得します。
	 * @return 資金払出額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_Haraidashi() {
		return lblID_M_Haraidashi;
	}

	/**
	 * 資金払出額(円)（修正）を設定します。
	 * @param lblID_M_Haraidashi 資金払出額(円)（修正）
	 */
	public void setLblID_M_Haraidashi(java.math.BigDecimal lblID_M_Haraidashi) {
		this.lblID_M_Haraidashi = lblID_M_Haraidashi;
	}

	/**
	 * 元金充当額(円)（修正）を取得します。
	 * @return 元金充当額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_Ganju() {
		return lblID_M_Ganju;
	}

	/**
	 * 元金充当額(円)（修正）を設定します。
	 * @param lblID_M_Ganju 元金充当額(円)（修正）
	 */
	public void setLblID_M_Ganju(java.math.BigDecimal lblID_M_Ganju) {
		this.lblID_M_Ganju = lblID_M_Ganju;
	}

	/**
	 * 元金充当後貸付金残高(円)（修正）を取得します。
	 * @return 元金充当後貸付金残高(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_KashitsukeZandakaAfterGanju() {
		return lblID_M_KashitsukeZandakaAfterGanju;
	}

	/**
	 * 元金充当後貸付金残高(円)（修正）を設定します。
	 * @param lblID_M_KashitsukeZandakaAfterGanju 元金充当後貸付金残高(円)（修正）
	 */
	public void setLblID_M_KashitsukeZandakaAfterGanju(
			java.math.BigDecimal lblID_M_KashitsukeZandakaAfterGanju) {
		this.lblID_M_KashitsukeZandakaAfterGanju = lblID_M_KashitsukeZandakaAfterGanju;
	}

	/**
	 * 元金充当後第１回約定日（修正）を取得します。
	 * @return 元金充当後第１回約定日（修正）
	 */
	public String getLblID_Date_FirstYakujoAfterGanju() {
		return lblID_Date_FirstYakujoAfterGanju;
	}

	/**
	 * 元金充当後第１回約定日（修正）を設定します。
	 * @param lblID_Date_FirstYakujoAfterGanju 元金充当後第１回約定日（修正）
	 */
	public void setLblID_Date_FirstYakujoAfterGanju(String lblID_Date_FirstYakujoAfterGanju) {
		this.lblID_Date_FirstYakujoAfterGanju = lblID_Date_FirstYakujoAfterGanju;
	}

	/**
	 * 繰償事由コード（修正）を取得します。
	 * @return 繰償事由コード（修正）
	 */
	public String getLblID_Code_KurishoJiyu() {
		return lblID_Code_KurishoJiyu;
	}

	/**
	 * 繰償事由コード（修正）を設定します。
	 * @param lblID_Code_KurishoJiyu 繰償事由コード（修正）
	 */
	public void setLblID_Code_KurishoJiyu(String lblID_Code_KurishoJiyu) {
		this.lblID_Code_KurishoJiyu = lblID_Code_KurishoJiyu;
	}

	/**
	 * 元金充当後の元金均等額(円)（修正）を取得します。
	 * @return 元金充当後の元金均等額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_GankinKintoAfterGanju() {
		return lblID_M_GankinKintoAfterGanju;
	}

	/**
	 * 元金充当後の元金均等額(円)（修正）を設定します。
	 * @param lblID_M_GankinKintoAfterGanju 元金充当後の元金均等額(円)（修正）
	 */
	public void setLblID_M_GankinKintoAfterGanju(java.math.BigDecimal lblID_M_GankinKintoAfterGanju) {
		this.lblID_M_GankinKintoAfterGanju = lblID_M_GankinKintoAfterGanju;
	}

	/**
	 * 元金充当後の元金不均等額(円)（修正）を取得します。
	 * @return 元金充当後の元金不均等額(円)（修正）
	 */
	public java.math.BigDecimal getLblID_M_GankinFukintoAfterGanju() {
		return lblID_M_GankinFukintoAfterGanju;
	}

	/**
	 * 元金充当後の元金不均等額(円)（修正）を設定します。
	 * @param lblID_M_GankinFukintoAfterGanju 元金充当後の元金不均等額(円)（修正）
	 */
	public void setLblID_M_GankinFukintoAfterGanju(java.math.BigDecimal lblID_M_GankinFukintoAfterGanju) {
		this.lblID_M_GankinFukintoAfterGanju = lblID_M_GankinFukintoAfterGanju;
	}

	/**
	 * 調整コード（修正）を取得します。
	 * @return 調整コード（修正）
	 */
	public String getRdoID_Code_Chosei() {
		return rdoID_Code_Chosei;
	}

	/**
	 * 調整コード（修正）を設定します。
	 * @param rdoID_Code_Chosei 調整コード（修正）
	 */
	public void setRdoID_Code_Chosei(String rdoID_Code_Chosei) {
		this.rdoID_Code_Chosei = rdoID_Code_Chosei;
	}

	/**
	 * 報告年月日Ａを取得します。
	 * @return 報告年月日Ａ
	 */
	public String getID_Date_Report() {
		return ID_Date_Report;
	}

	/**
	 * 報告年月日Ａを設定します。
	 * @param ID_Date_Report 報告年月日Ａ
	 */
	public void setID_Date_Report(String ID_Date_Report) {
		this.ID_Date_Report = ID_Date_Report;
	}

	/**
	 * 顧客名Ａを取得します。
	 * @return 顧客名Ａ
	 */
	public String getID_Name_Customer() {
		return ID_Name_Customer;
	}

	/**
	 * 顧客名Ａを設定します。
	 * @param ID_Name_Customer 顧客名Ａ
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		this.ID_Name_Customer = ID_Name_Customer;
	}

	/**
	 * 扱店名Ａを取得します。
	 * @return 扱店名Ａ
	 */
	public String getID_Name_Organization() {
		return ID_Name_Organization;
	}

	/**
	 * 扱店名Ａを設定します。
	 * @param ID_Name_Organization 扱店名Ａ
	 */
	public void setID_Name_Organization(String ID_Name_Organization) {
		this.ID_Name_Organization = ID_Name_Organization;
	}

	/**
	 * 公庫支店Ａを取得します。
	 * @return 公庫支店Ａ
	 */
	public String getID_Code_KoukoShiten() {
		return ID_Code_KoukoShiten;
	}

	/**
	 * 公庫支店Ａを設定します。
	 * @param ID_Code_KoukoShiten 公庫支店Ａ
	 */
	public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
		this.ID_Code_KoukoShiten = ID_Code_KoukoShiten;
	}

	/**
	 * 扱店Ａを取得します。
	 * @return 扱店Ａ
	 */
	public String getID_Code_Organization() {
		return ID_Code_Organization;
	}

	/**
	 * 扱店Ａを設定します。
	 * @param ID_Code_Organization 扱店Ａ
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		this.ID_Code_Organization = ID_Code_Organization;
	}

	/**
	 * 店舗Ａを取得します。
	 * @return 店舗Ａ
	 */
	public String getID_Code_Tenpo() {
		return ID_Code_Tenpo;
	}

	/**
	 * 店舗Ａを設定します。
	 * @param ID_Code_Tenpo 店舗Ａ
	 */
	public void setID_Code_Tenpo(String ID_Code_Tenpo) {
		this.ID_Code_Tenpo = ID_Code_Tenpo;
	}

	/**
	 * 年度Ａを取得します。
	 * @return 年度Ａ
	 */
	public String getID_Year() {
		return ID_Year;
	}

	/**
	 * 年度Ａを設定します。
	 * @param ID_Year 年度Ａ
	 */
	public void setID_Year(String ID_Year) {
		this.ID_Year = ID_Year;
	}

	/**
	 * 方式資金Ａを取得します。
	 * @return 方式資金Ａ
	 */
	public String getID_Code_HoshikiShikin() {
		return ID_Code_HoshikiShikin;
	}

	/**
	 * 方式資金Ａを設定します。
	 * @param ID_Code_HoshikiShikin 方式資金Ａ
	 */
	public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
		this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
	}

	/**
	 * 番号Ａを取得します。
	 * @return 番号Ａ
	 */
	public String getID_ID_Ringi() {
		return ID_ID_Ringi;
	}

	/**
	 * 番号Ａを設定します。
	 * @param ID_ID_Ringi 番号Ａ
	 */
	public void setID_ID_Ringi(String ID_ID_Ringi) {
		this.ID_ID_Ringi = ID_ID_Ringi;
	}

	/**
	 * 枝番Ａを取得します。
	 * @return 枝番Ａ
	 */
	public String getID_ID_RingiBranch() {
		return ID_ID_RingiBranch;
	}

	/**
	 * 枝番Ａを設定します。
	 * @param ID_ID_RingiBranch 枝番Ａ
	 */
	public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
		this.ID_ID_RingiBranch = ID_ID_RingiBranch;
	}

	/**
	 * 資金使途Ａを取得します。
	 * @return 資金使途Ａ
	 */
	public String getID_Code_ShikinShito() {
		return ID_Code_ShikinShito;
	}

	/**
	 * 資金使途Ａを設定します。
	 * @param ID_Code_ShikinShito 資金使途Ａ
	 */
	public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
		this.ID_Code_ShikinShito = ID_Code_ShikinShito;
	}

	/**
	 * 事業別Ａを取得します。
	 * @return 事業別Ａ
	 */
	public String getID_Code_Jigyobetsu() {
		return ID_Code_Jigyobetsu;
	}

	/**
	 * 事業別Ａを設定します。
	 * @param ID_Code_Jigyobetsu 事業別Ａ
	 */
	public void setID_Code_Jigyobetsu(String ID_Code_Jigyobetsu) {
		this.ID_Code_Jigyobetsu = ID_Code_Jigyobetsu;
	}

	/**
	 * 利率を取得します。
	 * @return 利率
	 */
	public java.math.BigDecimal getID_Riritsu() {
		return ID_Riritsu;
	}

	/**
	 * 利率を設定します。
	 * @param ID_Riritsu 利率
	 */
	public void setID_Riritsu(java.math.BigDecimal ID_Riritsu) {
		this.ID_Riritsu = ID_Riritsu;
	}

	/**
	 * 特利区分Ａを取得します。
	 * @return 特利区分Ａ
	 */
	public String getID_Code_TokuriKubun() {
		return ID_Code_TokuriKubun;
	}

	/**
	 * 特利区分Ａを設定します。
	 * @param ID_Code_TokuriKubun 特利区分Ａ
	 */
	public void setID_Code_TokuriKubun(String ID_Code_TokuriKubun) {
		this.ID_Code_TokuriKubun = ID_Code_TokuriKubun;
	}

	/**
	 * 特利を取得します。
	 * @return 特利
	 */
	public java.math.BigDecimal getID_Tokuri() {
		return ID_Tokuri;
	}

	/**
	 * 特利を設定します。
	 * @param ID_Tokuri 特利
	 */
	public void setID_Tokuri(java.math.BigDecimal ID_Tokuri) {
		this.ID_Tokuri = ID_Tokuri;
	}

	/**
	 * 据置期限Ａを取得します。
	 * @return 据置期限Ａ
	 */
	public String getID_Date_SueokiKigen() {
		return ID_Date_SueokiKigen;
	}

	/**
	 * 据置期限Ａを設定します。
	 * @param ID_Date_SueokiKigen 据置期限Ａ
	 */
	public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
		this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
	}

	/**
	 * 償還期限Ａを取得します。
	 * @return 償還期限Ａ
	 */
	public String getID_Date_ShokanKigen() {
		return ID_Date_ShokanKigen;
	}

	/**
	 * 償還期限Ａを設定します。
	 * @param ID_Date_ShokanKigen 償還期限Ａ
	 */
	public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
		this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
	}

	/**
	 * 元利金払込期日を取得します。
	 * @return 元利金払込期日
	 */
	public String getID_Date_GanrikinHaraikomi() {
		return ID_Date_GanrikinHaraikomi;
	}

	/**
	 * 元利金払込期日を設定します。
	 * @param ID_Date_GanrikinHaraikomi 元利金払込期日
	 */
	public void setID_Date_GanrikinHaraikomi(String ID_Date_GanrikinHaraikomi) {
		this.ID_Date_GanrikinHaraikomi = ID_Date_GanrikinHaraikomi;
	}

	/**
	 * 貸付実行日Ａを取得します。
	 * @return 貸付実行日Ａ
	 */
	public String getID_Date_Jikko() {
		return ID_Date_Jikko;
	}

	/**
	 * 貸付実行日Ａを設定します。
	 * @param ID_Date_Jikko 貸付実行日Ａ
	 */
	public void setID_Date_Jikko(String ID_Date_Jikko) {
		this.ID_Date_Jikko = ID_Date_Jikko;
	}

	/**
	 * 貸付実行額金額を取得します。
	 * @return 貸付実行額金額
	 */
	public java.math.BigDecimal getID_M_Kashitsuke() {
		return ID_M_Kashitsuke;
	}

	/**
	 * 貸付実行額金額を設定します。
	 * @param ID_M_Kashitsuke 貸付実行額金額
	 */
	public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
		this.ID_M_Kashitsuke = ID_M_Kashitsuke;
	}

	/**
	 * 資金交付額を取得します。
	 * @return 資金交付額
	 */
	public java.math.BigDecimal getID_M_ShikinKofu() {
		return ID_M_ShikinKofu;
	}

	/**
	 * 資金交付額を設定します。
	 * @param ID_M_ShikinKofu 資金交付額
	 */
	public void setID_M_ShikinKofu(java.math.BigDecimal ID_M_ShikinKofu) {
		this.ID_M_ShikinKofu = ID_M_ShikinKofu;
	}

	/**
	 * 貸付受入金受入額を取得します。
	 * @return 貸付受入金受入額
	 */
	public java.math.BigDecimal getID_M_KashitsukeUkeire() {
		return ID_M_KashitsukeUkeire;
	}

	/**
	 * 貸付受入金受入額を設定します。
	 * @param ID_M_KashitsukeUkeire 貸付受入金受入額
	 */
	public void setID_M_KashitsukeUkeire(java.math.BigDecimal ID_M_KashitsukeUkeire) {
		this.ID_M_KashitsukeUkeire = ID_M_KashitsukeUkeire;
	}

	/**
	 * 受託者勘定処理年月（DB取得および登録値）を取得します。
	 * @return 受託者勘定処理年月（DB取得および登録値）
	 */
	public String getID_Date_Jtkshori() {
		return ID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月（DB取得および登録値）を設定します。
	 * @param ID_Date_Jtkshori 受託者勘定処理年月（DB取得および登録値）
	 */
	public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
		this.ID_Date_Jtkshori = ID_Date_Jtkshori;
	}

	/**
	 * 受託者勘定処理年月（入力された年、月）を取得します。
	 * @return 受託者勘定処理年月（入力された年、月）
	 */
	public String getID_Date_Jtkshori_Input() {
		return ID_Date_Jtkshori_Input;
	}

	/**
	 * 受託者勘定処理年月（入力された年、月）を設定します。
	 * @param ID_Date_Jtkshori_Input 受託者勘定処理年月（入力された年、月）
	 */
	public void setID_Date_Jtkshori_Input(String ID_Date_Jtkshori_Input) {
		this.ID_Date_Jtkshori_Input = ID_Date_Jtkshori_Input;
	}

	/**
	 * 受託者勘定処理年月（元号+年）を取得します。
	 * @return 受託者勘定処理年月（元号+年）
	 */
	public String getMstrID_Date_Jtkshori_Nen() {
		return mstrID_Date_Jtkshori_Nen;
	}

	/**
	 * 受託者勘定処理年月（元号+年）を設定します。
	 * @param mstrID_Date_Jtkshori_Nen 受託者勘定処理年月（元号+年）
	 */
	public void setMstrID_Date_Jtkshori_Nen(String mstrID_Date_Jtkshori_Nen) {
		this.mstrID_Date_Jtkshori_Nen = mstrID_Date_Jtkshori_Nen;
	}

	/**
	 * 受託者勘定処理年月（年）を取得します。
	 * @return 受託者勘定処理年月（年）
	 */
	public String getID_Date_Jtkshori_Nen_Input() {
		return ID_Date_Jtkshori_Nen_Input;
	}

	/**
	 * 受託者勘定処理年月（年）を設定します。
	 * @param ID_Date_Jtkshori_Nen_Input 受託者勘定処理年月（年）
	 */
	public void setID_Date_Jtkshori_Nen_Input(String ID_Date_Jtkshori_Nen_Input) {
		this.ID_Date_Jtkshori_Nen_Input = ID_Date_Jtkshori_Nen_Input;
	}

	/**
	 * 受託者勘定処理年月（元号の値）を取得します。
	 * @return 受託者勘定処理年月（元号の値）
	 */
	public String getID_Date_Jtkshori_Gengo_Value() {
		return ID_Date_Jtkshori_Gengo_Value;
	}

	/**
	 * 受託者勘定処理年月（元号の値）を設定します。
	 * @param ID_Date_Jtkshori_Gengo_Value 受託者勘定処理年月（元号の値）
	 */
	public void setID_Date_Jtkshori_Gengo_Value(String ID_Date_Jtkshori_Gengo_Value) {
		this.ID_Date_Jtkshori_Gengo_Value = ID_Date_Jtkshori_Gengo_Value;
	}

	/**
	 * 受託者勘定処理年月（元号の表示テキスト）を取得します。
	 * @return 受託者勘定処理年月（元号の表示テキスト）
	 */
	public String getID_Date_Jtkshori_Gengo_Text() {
		return ID_Date_Jtkshori_Gengo_Text;
	}

	/**
	 * 受託者勘定処理年月（元号の表示テキスト）を設定します。
	 * @param ID_Date_Jtkshori_Gengo_Text 受託者勘定処理年月（元号の表示テキスト）
	 */
	public void setID_Date_Jtkshori_Gengo_Text(String ID_Date_Jtkshori_Gengo_Text) {
		this.ID_Date_Jtkshori_Gengo_Text = ID_Date_Jtkshori_Gengo_Text;
	}

	/**
	 * 受託者勘定処理年月（月の表示テキスト）を取得します。
	 * @return 受託者勘定処理年月（月の表示テキスト）
	 */
	public String getID_Date_JtkshoriTsuki_Text() {
		return ID_Date_JtkshoriTsuki_Text;
	}

	/**
	 * 受託者勘定処理年月（月の表示テキスト）を設定します。
	 * @param ID_Date_JtkshoriTsuki_Text 受託者勘定処理年月（月の表示テキスト）
	 */
	public void setID_Date_JtkshoriTsuki_Text(String ID_Date_JtkshoriTsuki_Text) {
		this.ID_Date_JtkshoriTsuki_Text = ID_Date_JtkshoriTsuki_Text;
	}

	/**
	 * 受託者勘定処理年月（月の値）を取得します。
	 * @return 受託者勘定処理年月（月の値）
	 */
	public String getID_Date_JtkshoriTsuki_Value() {
		return ID_Date_JtkshoriTsuki_Value;
	}

	/**
	 * 受託者勘定処理年月（月の値）を設定します。
	 * @param ID_Date_JtkshoriTsuki_Value 受託者勘定処理年月（月の値）
	 */
	public void setID_Date_JtkshoriTsuki_Value(String ID_Date_JtkshoriTsuki_Value) {
		this.ID_Date_JtkshoriTsuki_Value = ID_Date_JtkshoriTsuki_Value;
	}

	/**
	 * 払出・元金充当日（年、月、日）を取得します。
	 * @return 払出・元金充当日（年、月、日）
	 */
	public String getID_Date_HaraidashiJuto() {
		return ID_Date_HaraidashiJuto;
	}

	/**
	 * 払出・元金充当日（年、月、日）を設定します。
	 * @param ID_Date_HaraidashiJuto 払出・元金充当日（年、月、日）
	 */
	public void setID_Date_HaraidashiJuto(String ID_Date_HaraidashiJuto) {
		this.ID_Date_HaraidashiJuto = ID_Date_HaraidashiJuto;
	}

	/**
	 * 払出・元金充当日（元号+年）を取得します。
	 * @return 払出・元金充当日（元号+年）
	 */
	public String getID_Date_HaraidashiJuto_NenA() {
		return ID_Date_HaraidashiJuto_NenA;
	}

	/**
	 * 払出・元金充当日（元号+年）を設定します。
	 * @param ID_Date_HaraidashiJuto_NenA 払出・元金充当日（元号+年）
	 */
	public void setID_Date_HaraidashiJuto_NenA(String ID_Date_HaraidashiJuto_NenA) {
		this.ID_Date_HaraidashiJuto_NenA = ID_Date_HaraidashiJuto_NenA;
	}

	/**
	 * 払出・元金充当日（年）を取得します。
	 * @return 払出・元金充当日（年）
	 */
	public String getID_Date_HaraidashiJuto_NenInput() {
		return ID_Date_HaraidashiJuto_NenInput;
	}

	/**
	 * 払出・元金充当日（年）を設定します。
	 * @param ID_Date_HaraidashiJuto_NenInput 払出・元金充当日（年）
	 */
	public void setID_Date_HaraidashiJuto_NenInput(String ID_Date_HaraidashiJuto_NenInput) {
		this.ID_Date_HaraidashiJuto_NenInput = ID_Date_HaraidashiJuto_NenInput;
	}

	/**
	 * 払出・元金充当日（元号の値）を取得します。
	 * @return 払出・元金充当日（元号の値）
	 */
	public String getID_Date_HaraidashiJuto_Gengo_Value() {
		return ID_Date_HaraidashiJuto_Gengo_Value;
	}

	/**
	 * 払出・元金充当日（元号の値）を設定します。
	 * @param ID_Date_HaraidashiJuto_Gengo_Value 払出・元金充当日（元号の値）
	 */
	public void setID_Date_HaraidashiJuto_Gengo_Value(String ID_Date_HaraidashiJuto_Gengo_Value) {
		this.ID_Date_HaraidashiJuto_Gengo_Value = ID_Date_HaraidashiJuto_Gengo_Value;
	}

	/**
	 * 払出・元金充当日（元号の表示テキスト）を取得します。
	 * @return 払出・元金充当日（元号の表示テキスト）
	 */
	public String getID_Date_HaraidashiJuto_Gengo_Text() {
		return ID_Date_HaraidashiJuto_Gengo_Text;
	}

	/**
	 * 払出・元金充当日（元号の表示テキスト）を設定します。
	 * @param ID_Date_HaraidashiJuto_Gengo_Text 払出・元金充当日（元号の表示テキスト）
	 */
	public void setID_Date_HaraidashiJuto_Gengo_Text(String ID_Date_HaraidashiJuto_Gengo_Text) {
		this.ID_Date_HaraidashiJuto_Gengo_Text = ID_Date_HaraidashiJuto_Gengo_Text;
	}

	/**
	 * 払出・元金充当日の月のText値を取得します。
	 * @return 払出・元金充当日の月のText値
	 */
	public String getID_Date_HaraidashiJutoTsuki_Text() {
		return ID_Date_HaraidashiJutoTsuki_Text;
	}

	/**
	 * 払出・元金充当日の月のText値を設定します。
	 * @param ID_Date_HaraidashiJutoTsuki_Text 払出・元金充当日の月のText値
	 */
	public void setID_Date_HaraidashiJutoTsuki_Text(String ID_Date_HaraidashiJutoTsuki_Text) {
		this.ID_Date_HaraidashiJutoTsuki_Text = ID_Date_HaraidashiJutoTsuki_Text;
	}

	/**
	 * 払出・元金充当日の日のText値を取得します。
	 * @return 払出・元金充当日の日のText値
	 */
	public String getID_Date_HaraidashiJutoBi_Text() {
		return ID_Date_HaraidashiJutoBi_Text;
	}

	/**
	 * 払出・元金充当日の日のText値を設定します。
	 * @param ID_Date_HaraidashiJutoBi_Text 払出・元金充当日の日のText値
	 */
	public void setID_Date_HaraidashiJutoBi_Text(String ID_Date_HaraidashiJutoBi_Text) {
		this.ID_Date_HaraidashiJutoBi_Text = ID_Date_HaraidashiJutoBi_Text;
	}

	/**
	 * 払出・元金充当日の月の値を取得します。
	 * @return 払出・元金充当日の月の値
	 */
	public String getID_Date_HaraidashiJutoTsuki_Value() {
		return ID_Date_HaraidashiJutoTsuki_Value;
	}

	/**
	 * 払出・元金充当日の月の値を設定します。
	 * @param ID_Date_HaraidashiJutoTsuki_Value 払出・元金充当日の月の値
	 */
	public void setID_Date_HaraidashiJutoTsuki_Value(String ID_Date_HaraidashiJutoTsuki_Value) {
		this.ID_Date_HaraidashiJutoTsuki_Value = ID_Date_HaraidashiJutoTsuki_Value;
	}

	/**
	 * 払出・元金充当日の日の値を取得します。
	 * @return 払出・元金充当日の日の値
	 */
	public String getID_Date_HaraidashiJutoBi_Value() {
		return ID_Date_HaraidashiJutoBi_Value;
	}

	/**
	 * 払出・元金充当日の日の値を設定します。
	 * @param ID_Date_HaraidashiJutoBi_Value 払出・元金充当日の日の値
	 */
	public void setID_Date_HaraidashiJutoBi_Value(String ID_Date_HaraidashiJutoBi_Value) {
		this.ID_Date_HaraidashiJutoBi_Value = ID_Date_HaraidashiJutoBi_Value;
	}

	/**
	 * 資金払出額を取得します。
	 * @return 資金払出額
	 */
	public String getID_M_Haraidashi() {
		return ID_M_Haraidashi;
	}

	/**
	 * 資金払出額を設定します。
	 * @param ID_M_Haraidashi 資金払出額
	 */
	public void setID_M_Haraidashi(String ID_M_Haraidashi) {
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
	 * 貸付受入金残高を取得します。
	 * @return 貸付受入金残高
	 */
	public java.math.BigDecimal getID_M_KashitsukeukeireZan() {
		return ID_M_KashitsukeukeireZan;
	}

	/**
	 * 貸付受入金残高を設定します。
	 * @param ID_M_KashitsukeukeireZan 貸付受入金残高
	 */
	public void setID_M_KashitsukeukeireZan(java.math.BigDecimal ID_M_KashitsukeukeireZan) {
		this.ID_M_KashitsukeukeireZan = ID_M_KashitsukeukeireZan;
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
	 * 元金充当後第１回約定日Ａを取得します。
	 * @return 元金充当後第１回約定日Ａ
	 */
	public String getID_Date_FirstYakujoAfterGanju() {
		return ID_Date_FirstYakujoAfterGanju;
	}

	/**
	 * 元金充当後第１回約定日Ａを設定します。
	 * @param ID_Date_FirstYakujoAfterGanju 元金充当後第１回約定日Ａ
	 */
	public void setID_Date_FirstYakujoAfterGanju(String ID_Date_FirstYakujoAfterGanju) {
		this.ID_Date_FirstYakujoAfterGanju = ID_Date_FirstYakujoAfterGanju;
	}

	/**
	 * 繰上償還事由コードを取得します。
	 * @return 繰上償還事由コード
	 */
	public String getID_Code_KurishoJiyu() {
		return ID_Code_KurishoJiyu;
	}

	/**
	 * 繰上償還事由コードを設定します。
	 * @param ID_Code_KurishoJiyu 繰上償還事由コード
	 */
	public void setID_Code_KurishoJiyu(String ID_Code_KurishoJiyu) {
		this.ID_Code_KurishoJiyu = ID_Code_KurishoJiyu;
	}

	/**
	 * 繰上償還事由コードのText値を取得します。
	 * @return 繰上償還事由コードのText値
	 */
	public String getID_Code_KurishoJiyu_Text() {
		return ID_Code_KurishoJiyu_Text;
	}

	/**
	 * 繰上償還事由コードのText値を設定します。
	 * @param ID_Code_KurishoJiyu_Text 繰上償還事由コードのText値
	 */
	public void setID_Code_KurishoJiyu_Text(String ID_Code_KurishoJiyu_Text) {
		this.ID_Code_KurishoJiyu_Text = ID_Code_KurishoJiyu_Text;
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
	 * 調整コードＡを取得します。
	 * @return 調整コードＡ
	 */
	public String getID_Code_Chosei() {
		return ID_Code_Chosei;
	}

	/**
	 * 調整コードＡを設定します。
	 * @param ID_Code_Chosei 調整コードＡ
	 */
	public void setID_Code_Chosei(String ID_Code_Chosei) {
		this.ID_Code_Chosei = ID_Code_Chosei;
	}

	/**
	 * 調整コードのText値を取得します。
	 * @return 調整コードのText値
	 */
	public String getID_Code_Chosei_Text() {
		return ID_Code_Chosei_Text;
	}

	/**
	 * 調整コードのText値を設定します。
	 * @param ID_Code_Chosei_Text 調整コードのText値
	 */
	public void setID_Code_Chosei_Text(String ID_Code_Chosei_Text) {
		this.ID_Code_Chosei_Text = ID_Code_Chosei_Text;
	}

	/**
	 * 報告書番号（非表示）を取得します。
	 * @return 報告書番号（非表示）
	 */
	public String getID_ID_Report() {
		return ID_ID_Report;
	}

	/**
	 * 報告書番号（非表示）を設定します。
	 * @param ID_ID_Report 報告書番号（非表示）
	 */
	public void setID_ID_Report(String ID_ID_Report) {
		this.ID_ID_Report = ID_ID_Report;
	}

	/**
	 * 報告時分秒（非表示）を取得します。
	 * @return 報告時分秒（非表示）
	 */
	public String getID_Time_Report() {
		return ID_Time_Report;
	}

	/**
	 * 報告時分秒（非表示）を設定します。
	 * @param ID_Time_Report 報告時分秒（非表示）
	 */
	public void setID_Time_Report(String ID_Time_Report) {
		this.ID_Time_Report = ID_Time_Report;
	}

	/**
	 * ユーザID（非表示）を取得します。
	 * @return ユーザID（非表示）
	 */
	public String getID_UserID() {
		return ID_UserID;
	}

	/**
	 * ユーザID（非表示）を設定します。
	 * @param ID_UserID ユーザID（非表示）
	 */
	public void setID_UserID(String ID_UserID) {
		this.ID_UserID = ID_UserID;
	}

	/**
	 * 伝送番号（非表示）を取得します。
	 * @return 伝送番号（非表示）
	 */
	public String getID_ID_Denso() {
		return ID_ID_Denso;
	}

	/**
	 * 伝送番号（非表示）を設定します。
	 * @param ID_ID_Denso 伝送番号（非表示）
	 */
	public void setID_ID_Denso(String ID_ID_Denso) {
		this.ID_ID_Denso = ID_ID_Denso;
	}

	/**
	 * データコード（非表示）を取得します。
	 * @return データコード（非表示）
	 */
	public String getID_Data_Code() {
		return ID_Data_Code;
	}

	/**
	 * データコード（非表示）を設定します。
	 * @param ID_Data_Code データコード（非表示）
	 */
	public void setID_Data_Code(String ID_Data_Code) {
		this.ID_Data_Code = ID_Data_Code;
	}

	/**
	 * 合計（非表示）（修正） を取得します。
	 * @return 合計（非表示）（修正）
	 */
	public java.math.BigDecimal getID_M_Kei() {
		return ID_M_Kei;
	}

	/**
	 * 合計（非表示）（修正） を設定します。
	 * @param ID_M_Kei 合計（非表示）（修正）
	 */
	public void setID_M_Kei(java.math.BigDecimal ID_M_Kei) {
		this.ID_M_Kei = ID_M_Kei;
	}

	/**
	 * 合計（非表示） を取得します。
	 * @return 合計（非表示）
	 */
	public java.math.BigDecimal getID_M_Kei_Red() {
		return ID_M_Kei_Red;
	}

	/**
	 * 合計（非表示） を設定します。
	 * @param ID_M_Kei 合計（非表示）
	 */
	public void setID_M_Kei_Red(java.math.BigDecimal ID_M_Kei_Red) {
		this.ID_M_Kei_Red = ID_M_Kei_Red;
	}

	/**
	 * 報告書履歴番号（非表示）を取得します。
	 * @return 報告書履歴番号（非表示）
	 */
	public String getID_ID_History() {
		return ID_ID_History;
	}

	/**
	 * 報告書履歴番号（非表示）を設定します。
	 * @param ID_ID_History 報告書履歴番号（非表示）
	 */
	public void setID_ID_History(String ID_ID_History) {
		this.ID_ID_History = ID_ID_History;
	}

	/**
	 * ステータス（非表示）を取得します。
	 * @return ステータス（非表示）
	 */
	public String getID_Status() {
		return ID_Status;
	}

	/**
	 * ステータス（非表示）を設定します。
	 * @param ID_Status ステータス（非表示）
	 */
	public void setID_Status(String ID_Status) {
		this.ID_Status = ID_Status;
	}

	/**
	 * 処理種別（非表示）を取得します。
	 * @return 処理種別（非表示）
	 */
	public String getID_Type_Process() {
		return ID_Type_Process;
	}

	/**
	 * 処理種別（非表示）を設定します。
	 * @param ID_Type_Process 処理種別（非表示）
	 */
	public void setID_Type_Process(String ID_Type_Process) {
		this.ID_Type_Process = ID_Type_Process;
	}

	/**
	 * 取消済みフラグ（非表示）を取得します。
	 * @return 取消済みフラグ（非表示）
	 */
	public String getID_Flag_Torikeshizumi() {
		return ID_Flag_Torikeshizumi;
	}

	/**
	 * 取消済みフラグ（非表示）を設定します。
	 * @param ID_Flag_Torikeshizumi 取消済みフラグ（非表示）
	 */
	public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
		this.ID_Flag_Torikeshizumi = ID_Flag_Torikeshizumi;
	}

	/**
	 * エラーコード（非表示）を取得します。
	 * @return エラーコード（非表示）
	 */
	public String getID_Code_Error() {
		return ID_Code_Error;
	}

	/**
	 * エラーコード（非表示）を設定します。
	 * @param ID_Code_Error エラーコード（非表示）
	 */
	public void setID_Code_Error(String ID_Code_Error) {
		this.ID_Code_Error = ID_Code_Error;
	}

	/**
	 * エラーメッセージ（非表示）を取得します。
	 * @return エラーメッセージ（非表示）
	 */
	public String getID_ErrorMessage() {
		return ID_ErrorMessage;
	}

	/**
	 * エラーメッセージ（非表示）を設定します。
	 * @param ID_ErrorMessage エラーメッセージ（非表示）
	 */
	public void setID_ErrorMessage(String ID_ErrorMessage) {
		this.ID_ErrorMessage = ID_ErrorMessage;
	}

	/**
	 * 債権管理番号（非表示）を取得します。
	 * @return 債権管理番号（非表示）
	 */
	public String getID_ID_Credit() {
		return ID_ID_Credit;
	}

	/**
	 * 債権管理番号（非表示）を設定します。
	 * @param ID_ID_Credit 債権管理番号（非表示）
	 */
	public void setID_ID_Credit(String ID_ID_Credit) {
		this.ID_ID_Credit = ID_ID_Credit;
	}

	/**
	 * 顧客コード（非表示）を取得します。
	 * @return 顧客コード（非表示）
	 */
	public String getID_Code_Customer() {
		return ID_Code_Customer;
	}

	/**
	 * 顧客コード（非表示）を設定します。
	 * @param ID_Code_Customer 顧客コード（非表示）
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		this.ID_Code_Customer = ID_Code_Customer;
	}

	/**
	 * 退避賦金（非表示）を取得します。
	 * @return 退避賦金（非表示）
	 */
	public java.math.BigDecimal getID_Keep_M_Fukin() {
		return ID_Keep_M_Fukin;
	}

	/**
	 * 退避賦金（非表示）を設定します。
	 * @param ID_Keep_M_Fukin 退避賦金（非表示）
	 */
	public void setID_Keep_M_Fukin(java.math.BigDecimal ID_Keep_M_Fukin) {
		this.ID_Keep_M_Fukin = ID_Keep_M_Fukin;
	}

	/**
	 * 退避元金不均等（非表示）を取得します。
	 * @return 退避元金不均等（非表示）
	 */
	public java.math.BigDecimal getID_Keep_M_GankinFukinto() {
		return ID_Keep_M_GankinFukinto;
	}

	/**
	 * 退避元金不均等（非表示）を設定します。
	 * @param ID_Keep_M_GankinFukinto 退避元金不均等（非表示）
	 */
	public void setID_Keep_M_GankinFukinto(java.math.BigDecimal ID_Keep_M_GankinFukinto) {
		this.ID_Keep_M_GankinFukinto = ID_Keep_M_GankinFukinto;
	}

	/**
	 * 退避元金不均等区分（非表示）を取得します。
	 * @return 退避元金不均等区分（非表示）
	 */
	public String getID_Keep_Kubun_GankinFukinto() {
		return ID_Keep_Kubun_GankinFukinto;
	}

	/**
	 * 退避元金不均等区分（非表示）を設定します。
	 * @param ID_Keep_Kubun_GankinFukinto 退避元金不均等区分（非表示）
	 */
	public void setID_Keep_Kubun_GankinFukinto(String ID_Keep_Kubun_GankinFukinto) {
		this.ID_Keep_Kubun_GankinFukinto = ID_Keep_Kubun_GankinFukinto;
	}

	/**
	 * 退避貸付金残高（非表示）を取得します。
	 * @return 退避貸付金残高（非表示）
	 */
	public java.math.BigDecimal getID_Keep_M_KashitsukeZan() {
		return ID_Keep_M_KashitsukeZan;
	}

	/**
	 * 退避貸付金残高（非表示）を設定します。
	 * @param ID_Keep_M_KashitsukeZan 退避貸付金残高（非表示）
	 */
	public void setID_Keep_M_KashitsukeZan(java.math.BigDecimal ID_Keep_M_KashitsukeZan) {
		this.ID_Keep_M_KashitsukeZan = ID_Keep_M_KashitsukeZan;
	}

	/**
	 * 退避約定元金（非表示）を取得します。
	 * @return 退避約定元金（非表示）
	 */
	public java.math.BigDecimal getID_Keep_M_YakujoGankin() {
		return ID_Keep_M_YakujoGankin;
	}

	/**
	 * 退避約定元金（非表示）を設定します。
	 * @param ID_Keep_M_YakujoGankin 退避約定元金（非表示）
	 */
	public void setID_Keep_M_YakujoGankin(java.math.BigDecimal ID_Keep_M_YakujoGankin) {
		this.ID_Keep_M_YakujoGankin = ID_Keep_M_YakujoGankin;
	}

	/**
	 * 退避約定利息（非表示）を取得します。
	 * @return 退避約定利息（非表示）
	 */
	public java.math.BigDecimal getID_Keep_M_YakujoRisoku() {
		return ID_Keep_M_YakujoRisoku;
	}

	/**
	 * 退避約定利息（非表示）を設定します。
	 * @param ID_Keep_M_YakujoRisoku 退避約定利息（非表示）
	 */
	public void setID_Keep_M_YakujoRisoku(java.math.BigDecimal ID_Keep_M_YakujoRisoku) {
		this.ID_Keep_M_YakujoRisoku = ID_Keep_M_YakujoRisoku;
	}

	/**
	 * 退避償還期限年月（非表示）を取得します。
	 * @return 退避償還期限年月（非表示）
	 */
	public String getID_Keep_Date_ShokanKigen() {
		return ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 退避償還期限年月（非表示）を設定します。
	 * @param ID_Keep_Date_ShokanKigen 退避償還期限年月（非表示）
	 */
	public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
		this.ID_Keep_Date_ShokanKigen = ID_Keep_Date_ShokanKigen;
	}

	/**
	 * 退避条変起案中区分（非表示）を取得します。
	 * @return 退避条変起案中区分（非表示）
	 */
	public String getID_Keep_JohenKianchu() {
		return ID_Keep_JohenKianchu;
	}

	/**
	 * 退避条変起案中区分（非表示）を設定します。
	 * @param ID_Keep_JohenKianchu 退避条変起案中区分（非表示）
	 */
	public void setID_Keep_JohenKianchu(String ID_Keep_JohenKianchu) {
		this.ID_Keep_JohenKianchu = ID_Keep_JohenKianchu;
	}

	/**
	 * 更新用賦金（非表示）を取得します。
	 * @return 更新用賦金（非表示）
	 */
	public java.math.BigDecimal getID_Up_M_Fukin() {
		return ID_Up_M_Fukin;
	}

	/**
	 * 更新用賦金（非表示）を設定します。
	 * @param ID_Up_M_Fukin 更新用賦金（非表示）
	 */
	public void setID_Up_M_Fukin(java.math.BigDecimal ID_Up_M_Fukin) {
		this.ID_Up_M_Fukin = ID_Up_M_Fukin;
	}

	/**
	 * 更新用元金不均等（非表示）を取得します。
	 * @return 更新用元金不均等（非表示）
	 */
	public java.math.BigDecimal getID_Up_M_GankinFukinto() {
		return ID_Up_M_GankinFukinto;
	}

	/**
	 * 更新用元金不均等（非表示）を設定します。
	 * @param ID_Up_M_GankinFukinto 更新用元金不均等（非表示）
	 */
	public void setID_Up_M_GankinFukinto(java.math.BigDecimal ID_Up_M_GankinFukinto) {
		this.ID_Up_M_GankinFukinto = ID_Up_M_GankinFukinto;
	}

	/**
	 * 更新用元金不均等区分（非表示）を取得します。
	 * @return 更新用元金不均等区分（非表示）
	 */
	public String getID_Up_Kubun_GankinFukinto() {
		return ID_Up_Kubun_GankinFukinto;
	}

	/**
	 * 更新用元金不均等区分（非表示）を設定します。
	 * @param ID_Up_Kubun_GankinFukinto 更新用元金不均等区分（非表示）
	 */
	public void setID_Up_Kubun_GankinFukinto(String ID_Up_Kubun_GankinFukinto) {
		this.ID_Up_Kubun_GankinFukinto = ID_Up_Kubun_GankinFukinto;
	}

	/**
	 * 更新用貸付金残高（非表示）を取得します。
	 * @return 更新用貸付金残高（非表示）
	 */
	public java.math.BigDecimal getID_Up_M_KashitsukeZan() {
		return ID_Up_M_KashitsukeZan;
	}

	/**
	 * 更新用貸付金残高（非表示）を設定します。
	 * @param ID_Up_M_KashitsukeZan 更新用貸付金残高（非表示）
	 */
	public void setID_Up_M_KashitsukeZan(java.math.BigDecimal ID_Up_M_KashitsukeZan) {
		this.ID_Up_M_KashitsukeZan = ID_Up_M_KashitsukeZan;
	}

	/**
	 * 更新用約定元金（非表示）を取得します。
	 * @return 更新用約定元金（非表示）
	 */
	public java.math.BigDecimal getID_Up_M_YakujoGankin() {
		return ID_Up_M_YakujoGankin;
	}

	/**
	 * 更新用約定元金（非表示）を設定します。
	 * @param ID_Up_M_YakujoGankin 更新用約定元金（非表示）
	 */
	public void setID_Up_M_YakujoGankin(java.math.BigDecimal ID_Up_M_YakujoGankin) {
		this.ID_Up_M_YakujoGankin = ID_Up_M_YakujoGankin;
	}

	/**
	 * 更新用約定利息（非表示）を取得します。
	 * @return 更新用約定利息（非表示）
	 */
	public java.math.BigDecimal getID_Up_M_YakujoRisoku() {
		return ID_Up_M_YakujoRisoku;
	}

	/**
	 * 更新用約定利息（非表示）を設定します。
	 * @param ID_Up_M_YakujoRisoku 更新用約定利息（非表示）
	 */
	public void setID_Up_M_YakujoRisoku(java.math.BigDecimal ID_Up_M_YakujoRisoku) {
		this.ID_Up_M_YakujoRisoku = ID_Up_M_YakujoRisoku;
	}

	/**
	 * 更新用償還期限年月（非表示）を取得します。
	 * @return 更新用償還期限年月（非表示）
	 */
	public String getID_Up_Date_ShokanKigen() {
		return ID_Up_Date_ShokanKigen;
	}

	/**
	 * 更新用償還期限年月（非表示）を設定します。
	 * @param ID_Up_Date_ShokanKigen 更新用償還期限年月（非表示）
	 */
	public void setID_Up_Date_ShokanKigen(String ID_Up_Date_ShokanKigen) {
		this.ID_Up_Date_ShokanKigen = ID_Up_Date_ShokanKigen;
	}

	/**
	 * 更新用条変起案中区分（非表示）を取得します。
	 * @return 更新用条変起案中区分（非表示）
	 */
	public String getID_Up_Kubun_JohenKianchu() {
		return ID_Up_Kubun_JohenKianchu;
	}

	/**
	 * 更新用条変起案中区分（非表示）を設定します。
	 * @param ID_Up_Kubun_JohenKianchu 更新用条変起案中区分（非表示）
	 */
	public void setID_Up_Kubun_JohenKianchu(String ID_Up_Kubun_JohenKianchu) {
		this.ID_Up_Kubun_JohenKianchu = ID_Up_Kubun_JohenKianchu;
	}

	/**
	 * 原本番号（非表示）を取得します。
	 * @return 原本番号（非表示）
	 */
	public String getID_ID_Master() {
		return ID_ID_Master;
	}

	/**
	 * 原本番号（非表示）を設定します。
	 * @param ID_ID_Master 原本番号（非表示）
	 */
	public void setID_ID_Master(String ID_ID_Master) {
		this.ID_ID_Master = ID_ID_Master;
	}

	/**
	 * 署名付きデータ（非表示）を取得します。
	 * @return 署名付きデータ（非表示）
	 */
	public String getID_SignData() {
		return ID_SignData;
	}

	/**
	 * 署名付きデータ（非表示）を設定します。
	 * @param ID_SignData 署名付きデータ（非表示）
	 */
	public void setID_SignData(String ID_SignData) {
		this.ID_SignData = ID_SignData;
	}

	/**
	 * 報告書履歴番号UP（非表示）を取得します。
	 * @return 報告書履歴番号UP（非表示）
	 */
	public String getID_Up_ID_History() {
		return ID_Up_ID_History;
	}

	/**
	 * 報告書履歴番号UP（非表示）を設定します。
	 * @param ID_Up_ID_History 報告書履歴番号UP（非表示）
	 */
	public void setID_Up_ID_History(String ID_Up_ID_History) {
		this.ID_Up_ID_History = ID_Up_ID_History;
	}

	/**
	 * 表示画面のヘッダ項目を取得します。
	 * @return 表示画面のヘッダ項目
	 */
	public String getID_InputHead() {
		return ID_InputHead;
	}

	/**
	 * 表示画面のヘッダ項目を設定します。
	 * @param ID_InputHead 表示画面のヘッダ項目
	 */
	public void setID_InputHead(String ID_InputHead) {
		this.ID_InputHead = ID_InputHead;
	}

	/**
	 * 稟議・賦金（非表示）を取得します。
	 * @return 稟議・賦金（非表示）
	 */
	public java.math.BigDecimal getID_M_Fukin_Ringi() {
		return ID_M_Fukin_Ringi;
	}

	/**
	 * 稟議・賦金（非表示）を設定します。
	 * @param ID_M_Fukin_Ringi 稟議・賦金（非表示）
	 */
	public void setID_M_Fukin_Ringi(java.math.BigDecimal ID_M_Fukin_Ringi) {
		this.ID_M_Fukin_Ringi = ID_M_Fukin_Ringi;
	}

	/**
	 * 稟議・元金不均等（非表示）を取得します。
	 * @return 稟議・元金不均等（非表示）
	 */
	public java.math.BigDecimal getID_M_GankinFukinto_Ringi() {
		return ID_M_GankinFukinto_Ringi;
	}

	/**
	 * 稟議・元金不均等（非表示）を設定します。
	 * @param ID_M_GankinFukinto_Ringi 稟議・元金不均等（非表示）
	 */
	public void setID_M_GankinFukinto_Ringi(java.math.BigDecimal ID_M_GankinFukinto_Ringi) {
		this.ID_M_GankinFukinto_Ringi = ID_M_GankinFukinto_Ringi;
	}

	/**
	 * 稟議・元金不均等区分（非表示）を取得します。
	 * @return 稟議・元金不均等区分（非表示）
	 */
	public String getID_Kubun_GankinFukinto_Ringi() {
		return ID_Kubun_GankinFukinto_Ringi;
	}

	/**
	 * 稟議・元金不均等区分（非表示）を設定します。
	 * @param ID_Kubun_GankinFukinto_Ringi 稟議・元金不均等区分（非表示）
	 */
	public void setID_Kubun_GankinFukinto_Ringi(String ID_Kubun_GankinFukinto_Ringi) {
		this.ID_Kubun_GankinFukinto_Ringi = ID_Kubun_GankinFukinto_Ringi;
	}

	/**
	 * 稟議・貸付金残高（非表示）を取得します。
	 * @return 稟議・貸付金残高（非表示）
	 */
	public java.math.BigDecimal getID_M_KashitsukeZan_Ringi() {
		return ID_M_KashitsukeZan_Ringi;
	}

	/**
	 * 稟議・貸付金残高（非表示）を設定します。
	 * @param ID_M_KashitsukeZan_Ringi 稟議・貸付金残高（非表示）
	 */
	public void setID_M_KashitsukeZan_Ringi(java.math.BigDecimal ID_M_KashitsukeZan_Ringi) {
		this.ID_M_KashitsukeZan_Ringi = ID_M_KashitsukeZan_Ringi;
	}

	/**
	 * 稟議・償還期限年月（非表示）を取得します。
	 * @return 稟議・償還期限年月（非表示）
	 */
	public String getID_Date_ShokanKigen_Ringi() {
		return ID_Date_ShokanKigen_Ringi;
	}

	/**
	 * 稟議・償還期限年月（非表示）を設定します。
	 * @param ID_Date_ShokanKigen_Ringi 稟議・償還期限年月（非表示）
	 */
	public void setID_Date_ShokanKigen_Ringi(String ID_Date_ShokanKigen_Ringi) {
		this.ID_Date_ShokanKigen_Ringi = ID_Date_ShokanKigen_Ringi;
	}

	/**
	 * 稟議・最新変更変月日（非表示）を取得します。
	 * @return 稟議・最新変更変月日（非表示）
	 */
	public String getID_Date_SaishiHenko_Ringi() {
		return ID_Date_SaishiHenko_Ringi;
	}

	/**
	 * 稟議・最新変更変月日（非表示）を設定します。
	 * @param ID_Date_SaishiHenko_Ringi 稟議・最新変更変月日（非表示）
	 */
	public void setID_Date_SaishiHenko_Ringi(String ID_Date_SaishiHenko_Ringi) {
		this.ID_Date_SaishiHenko_Ringi = ID_Date_SaishiHenko_Ringi;
	}

	/**
	 * 稟議・償還方法コード（非表示）を取得します。
	 * @return 稟議・償還方法コード（非表示）
	 */
	public String getID_Code_ShokanHouhou_Ringi() {
		return ID_Code_ShokanHouhou_Ringi;
	}

	/**
	 * 稟議・償還方法コード（非表示）を設定します。
	 * @param ID_Code_ShokanHouhou_Ringi 稟議・償還方法コード（非表示）
	 */
	public void setID_Code_ShokanHouhou_Ringi(String ID_Code_ShokanHouhou_Ringi) {
		this.ID_Code_ShokanHouhou_Ringi = ID_Code_ShokanHouhou_Ringi;
	}

	/**
	 * 稟議・特利有効期限（非表示）を取得します。
	 * @return 稟議・特利有効期限（非表示）
	 */
	public String getID_Date_TokuriYuko_Ringi() {
		return ID_Date_TokuriYuko_Ringi;
	}

	/**
	 * 稟議・特利有効期限（非表示）を設定します。
	 * @param ID_Date_TokuriYuko_Ringi 稟議・特利有効期限（非表示）
	 */
	public void setID_Date_TokuriYuko_Ringi(String ID_Date_TokuriYuko_Ringi) {
		this.ID_Date_TokuriYuko_Ringi = ID_Date_TokuriYuko_Ringi;
	}

	/**
	 * 稟議・条変起案中区分（非表示）を取得します。
	 * @return 稟議・条変起案中区分（非表示）
	 */
	public String getID_Kubun_JohenKianchu_Ringi() {
		return ID_Kubun_JohenKianchu_Ringi;
	}

	/**
	 * 稟議・条変起案中区分（非表示）を設定します。
	 * @param ID_Kubun_JohenKianchu_Ringi 稟議・条変起案中区分（非表示）
	 */
	public void setID_Kubun_JohenKianchu_Ringi(String ID_Kubun_JohenKianchu_Ringi) {
		this.ID_Kubun_JohenKianchu_Ringi = ID_Kubun_JohenKianchu_Ringi;
	}

	/**
	 * 償還方法タイプ識別値 （DB更新時の受渡し領域）を取得します。
	 * @return 償還方法タイプ識別値 （DB更新時の受渡し領域）
	 */
	public String getType_Shokan() {
		return Type_Shokan;
	}

	/**
	 * 償還方法タイプ識別値 （DB更新時の受渡し領域）を設定します。
	 * @param Type_Shokan 償還方法タイプ識別値 （DB更新時の受渡し領域）
	 */
	public void setType_Shokan(String Type_Shokan) {
		this.Type_Shokan = Type_Shokan;
	}

	/**
	 * 前回払出・債権管理番号を取得します。
	 * @return 前回払出・債権管理番号
	 */
	public java.math.BigDecimal getID_HDLas_ID_Credit() {
		return ID_HDLas_ID_Credit;
	}

	/**
	 * 前回払出・債権管理番号を設定します。
	 * @param ID_HDLas_ID_Credit 前回払出・債権管理番号
	 */
	public void setID_HDLas_ID_Credit(java.math.BigDecimal ID_HDLas_ID_Credit) {
		this.ID_HDLas_ID_Credit = ID_HDLas_ID_Credit;
	}

	/**
	 * 前回払出・計数管理処理番号を取得します。
	 * @return 前回払出・計数管理処理番号
	 */
	public String getID_HDLas_KeisuKanriShori() {
		return ID_HDLas_KeisuKanriShori;
	}

	/**
	 * 前回払出・計数管理処理番号を設定します。
	 * @param ID_HDLas_KeisuKanriShori 前回払出・計数管理処理番号
	 */
	public void setID_HDLas_KeisuKanriShori(String ID_HDLas_KeisuKanriShori) {
		this.ID_HDLas_KeisuKanriShori = ID_HDLas_KeisuKanriShori;
	}

	/**
	 * 更新用払出・払出額を取得します。
	 * @return 更新用払出・払出額
	 */
	public java.math.BigDecimal getID_HDLas_M_Haraidashi() {
		return ID_HDLas_M_Haraidashi;
	}

	/**
	 * 更新用払出・払出額を設定します。
	 * @param ID_HDLas_M_Haraidashi 更新用払出・払出額
	 */
	public void setID_HDLas_M_Haraidashi(java.math.BigDecimal ID_HDLas_M_Haraidashi) {
		this.ID_HDLas_M_Haraidashi = ID_HDLas_M_Haraidashi;
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
	 * 前回払出・貸付受入金残高積数を取得します。
	 * @return 前回払出・貸付受入金残高積数
	 */
	public java.math.BigDecimal getID_HDLas_M_ZandakaSekisu() {
		return ID_HDLas_M_ZandakaSekisu;
	}

	/**
	 * 前回払出・貸付受入金残高積数を設定します。
	 * @param ID_HDLas_M_ZandakaSekisu 前回払出・貸付受入金残高積数
	 */
	public void setID_HDLas_M_ZandakaSekisu(java.math.BigDecimal ID_HDLas_M_ZandakaSekisu) {
		this.ID_HDLas_M_ZandakaSekisu = ID_HDLas_M_ZandakaSekisu;
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
	public String getID_HDLas_M_HaraidashiFlag() {
		return ID_HDLas_M_HaraidashiFlag;
	}

	/**
	 * 前回払出・払出額有無フラグ（true=有）を設定します。
	 * @param ID_HDLas_M_HaraidashiFlag 前回払出・払出額有無フラグ（true=有）
	 */
	public void setID_HDLas_M_HaraidashiFlag(String ID_HDLas_M_HaraidashiFlag) {
		this.ID_HDLas_M_HaraidashiFlag = ID_HDLas_M_HaraidashiFlag;
	}

	/**
	 * 前回払出・繰上償還額有無フラグ（true=有）を取得します。
	 * @return 前回払出・繰上償還額有無フラグ（true=有）
	 */
	public String getID_HDLas_M_KurishoFlag() {
		return ID_HDLas_M_KurishoFlag;
	}

	/**
	 * 前回払出・繰上償還額有無フラグ（true=有）を設定します。
	 * @param ID_HDLas_M_KurishoFlag 前回払出・繰上償還額有無フラグ（true=有）
	 */
	public void setID_HDLas_M_KurishoFlag(String ID_HDLas_M_KurishoFlag) {
		this.ID_HDLas_M_KurishoFlag = ID_HDLas_M_KurishoFlag;
	}

	/**
	 * 取消用払出・債権管理番号を取得します。
	 * @return 取消用払出・債権管理番号
	 */
	public java.math.BigDecimal getID_HDDel1_ID_Credit() {
		return ID_HDDel1_ID_Credit;
	}

	/**
	 * 取消用払出・債権管理番号を設定します。
	 * @param ID_HDDel1_ID_Credit 取消用払出・債権管理番号
	 */
	public void setID_HDDel1_ID_Credit(java.math.BigDecimal ID_HDDel1_ID_Credit) {
		this.ID_HDDel1_ID_Credit = ID_HDDel1_ID_Credit;
	}

	/**
	 * 取消用払出・計数管理処理番号を取得します。
	 * @return 取消用払出・計数管理処理番号
	 */
	public String getID_HDDel1_KeisuKanriShori() {
		return ID_HDDel1_KeisuKanriShori;
	}

	/**
	 * 取消用払出・計数管理処理番号を設定します。
	 * @param ID_HDDel1_KeisuKanriShori 取消用払出・計数管理処理番号
	 */
	public void setID_HDDel1_KeisuKanriShori(String ID_HDDel1_KeisuKanriShori) {
		this.ID_HDDel1_KeisuKanriShori = ID_HDDel1_KeisuKanriShori;
	}

	/**
	 * 取消用払出・払出額を取得します。
	 * @return 取消用払出・払出額
	 */
	public java.math.BigDecimal getID_HDDel1_M_Haraidashi() {
		return ID_HDDel1_M_Haraidashi;
	}

	/**
	 * 取消用払出・払出額を設定します。
	 * @param ID_HDDel1_M_Haraidashi 取消用払出・払出額
	 */
	public void setID_HDDel1_M_Haraidashi(java.math.BigDecimal ID_HDDel1_M_Haraidashi) {
		this.ID_HDDel1_M_Haraidashi = ID_HDDel1_M_Haraidashi;
	}

	/**
	 * 取消用払出・払出累計額を取得します。
	 * @return 取消用払出・払出累計額
	 */
	public java.math.BigDecimal getID_HDDel1_M_HaraidashiRuikei() {
		return ID_HDDel1_M_HaraidashiRuikei;
	}

	/**
	 * 取消用払出・払出累計額を設定します。
	 * @param ID_HDDel1_M_HaraidashiRuikei 取消用払出・払出累計額
	 */
	public void setID_HDDel1_M_HaraidashiRuikei(java.math.BigDecimal ID_HDDel1_M_HaraidashiRuikei) {
		this.ID_HDDel1_M_HaraidashiRuikei = ID_HDDel1_M_HaraidashiRuikei;
	}

	/**
	 * 取消用払出・繰上償還額を取得します。
	 * @return 取消用払出・繰上償還額
	 */
	public java.math.BigDecimal getID_HDDel1_M_Kurisho() {
		return ID_HDDel1_M_Kurisho;
	}

	/**
	 * 取消用払出・繰上償還額を設定します。
	 * @param ID_HDDel1_M_Kurisho 取消用払出・繰上償還額
	 */
	public void setID_HDDel1_M_Kurisho(java.math.BigDecimal ID_HDDel1_M_Kurisho) {
		this.ID_HDDel1_M_Kurisho = ID_HDDel1_M_Kurisho;
	}

	/**
	 * 取消用払出・繰上償還累計額を取得します。
	 * @return 取消用払出・繰上償還累計額
	 */
	public java.math.BigDecimal getID_HDDel1_M_KurishoRuikei() {
		return ID_HDDel1_M_KurishoRuikei;
	}

	/**
	 * 取消用払出・繰上償還累計額を設定します。
	 * @param ID_HDDel1_M_KurishoRuikei 取消用払出・繰上償還累計額
	 */
	public void setID_HDDel1_M_KurishoRuikei(java.math.BigDecimal ID_HDDel1_M_KurishoRuikei) {
		this.ID_HDDel1_M_KurishoRuikei = ID_HDDel1_M_KurishoRuikei;
	}

	/**
	 * 取消用払出・更生処理区分を取得します。
	 * @return 取消用払出・更生処理区分
	 */
	public String getID_HDDel1_Kubun_KoseiShori() {
		return ID_HDDel1_Kubun_KoseiShori;
	}

	/**
	 * 取消用払出・更生処理区分を設定します。
	 * @param ID_HDDel1_Kubun_KoseiShori 取消用払出・更生処理区分
	 */
	public void setID_HDDel1_Kubun_KoseiShori(String ID_HDDel1_Kubun_KoseiShori) {
		this.ID_HDDel1_Kubun_KoseiShori = ID_HDDel1_Kubun_KoseiShori;
	}

	/**
	 * 取消用払出・貸付受入金残高積数を取得します。
	 * @return 取消用払出・貸付受入金残高積数
	 */
	public java.math.BigDecimal getID_HDDel1_M_ZandakaSekisu() {
		return ID_HDDel1_M_ZandakaSekisu;
	}

	/**
	 * 取消用払出・貸付受入金残高積数を設定します。
	 * @param ID_HDDel1_M_ZandakaSekisu 取消用払出・貸付受入金残高積数
	 */
	public void setID_HDDel1_M_ZandakaSekisu(java.math.BigDecimal ID_HDDel1_M_ZandakaSekisu) {
		this.ID_HDDel1_M_ZandakaSekisu = ID_HDDel1_M_ZandakaSekisu;
	}

	/**
	 * 取消用払出・払出充当年月日を取得します。
	 * @return 取消用払出・払出充当年月日
	 */
	public String getID_HDDel1_Date_HaraidashiJuto() {
		return ID_HDDel1_Date_HaraidashiJuto;
	}

	/**
	 * 取消用払出・払出充当年月日を設定します。
	 * @param ID_HDDel1_Date_HaraidashiJuto 取消用払出・払出充当年月日
	 */
	public void setID_HDDel1_Date_HaraidashiJuto(String ID_HDDel1_Date_HaraidashiJuto) {
		this.ID_HDDel1_Date_HaraidashiJuto = ID_HDDel1_Date_HaraidashiJuto;
	}

	/**
	 * 取消用払出・貸付受入金残高を取得します。
	 * @return 取消用払出・貸付受入金残高
	 */
	public java.math.BigDecimal getID_HDDel1_M_HaraidashiKashitsukeZan() {
		return ID_HDDel1_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 取消用払出・貸付受入金残高を設定します。
	 * @param ID_HDDel1_M_HaraidashiKashitsukeZan 取消用払出・貸付受入金残高
	 */
	public void setID_HDDel1_M_HaraidashiKashitsukeZan(
			java.math.BigDecimal ID_HDDel1_M_HaraidashiKashitsukeZan) {
		this.ID_HDDel1_M_HaraidashiKashitsukeZan = ID_HDDel1_M_HaraidashiKashitsukeZan;
	}

	/**
	 * Insert用払出・債権管理番号を取得します。
	 * @return Insert用払出・債権管理番号
	 */
	public java.math.BigDecimal getID_Ins_ID_Credit() {
		return ID_Ins_ID_Credit;
	}

	/**
	 * Insert用払出・債権管理番号を設定します。
	 * @param ID_Ins_ID_Credit Insert用払出・債権管理番号
	 */
	public void setID_Ins_ID_Credit(java.math.BigDecimal ID_Ins_ID_Credit) {
		this.ID_Ins_ID_Credit = ID_Ins_ID_Credit;
	}

	/**
	 * Insert用払出・計数管理処理番号を取得します。
	 * @return Insert用払出・計数管理処理番号
	 */
	public String getID_Ins_KeisuKanriShori() {
		return ID_Ins_KeisuKanriShori;
	}

	/**
	 * Insert用払出・計数管理処理番号を設定します。
	 * @param ID_Ins_KeisuKanriShori Insert用払出・計数管理処理番号
	 */
	public void setID_Ins_KeisuKanriShori(String ID_Ins_KeisuKanriShori) {
		this.ID_Ins_KeisuKanriShori = ID_Ins_KeisuKanriShori;
	}

	/**
	 * Insert用払出・払出額を取得します。
	 * @return Insert用払出・払出額
	 */
	public java.math.BigDecimal getID_Ins_M_Haraidashi() {
		return ID_Ins_M_Haraidashi;
	}

	/**
	 * Insert用払出・払出額を設定します。
	 * @param ID_Ins_M_Haraidashi Insert用払出・払出額
	 */
	public void setID_Ins_M_Haraidashi(java.math.BigDecimal ID_Ins_M_Haraidashi) {
		this.ID_Ins_M_Haraidashi = ID_Ins_M_Haraidashi;
	}

	/**
	 * Insert用払出・払出累計額を取得します。
	 * @return Insert用払出・払出累計額
	 */
	public java.math.BigDecimal getID_Ins_M_HaraidashiRuikei() {
		return ID_Ins_M_HaraidashiRuikei;
	}

	/**
	 * Insert用払出・払出累計額を設定します。
	 * @param ID_Ins_M_HaraidashiRuikei Insert用払出・払出累計額
	 */
	public void setID_Ins_M_HaraidashiRuikei(java.math.BigDecimal ID_Ins_M_HaraidashiRuikei) {
		this.ID_Ins_M_HaraidashiRuikei = ID_Ins_M_HaraidashiRuikei;
	}

	/**
	 * Insert用払出・繰上償還額を取得します。
	 * @return Insert用払出・繰上償還額
	 */
	public java.math.BigDecimal getID_Ins_M_Kurisho() {
		return ID_Ins_M_Kurisho;
	}

	/**
	 * Insert用払出・繰上償還額を設定します。
	 * @param ID_Ins_M_Kurisho Insert用払出・繰上償還額
	 */
	public void setID_Ins_M_Kurisho(java.math.BigDecimal ID_Ins_M_Kurisho) {
		this.ID_Ins_M_Kurisho = ID_Ins_M_Kurisho;
	}

	/**
	 * Insert用払出・繰上償還累計額を取得します。
	 * @return Insert用払出・繰上償還累計額
	 */
	public java.math.BigDecimal getID_Ins_M_KurishoRuikei() {
		return ID_Ins_M_KurishoRuikei;
	}

	/**
	 * Insert用払出・繰上償還累計額を設定します。
	 * @param ID_Ins_M_KurishoRuikei Insert用払出・繰上償還累計額
	 */
	public void setID_Ins_M_KurishoRuikei(java.math.BigDecimal ID_Ins_M_KurishoRuikei) {
		this.ID_Ins_M_KurishoRuikei = ID_Ins_M_KurishoRuikei;
	}

	/**
	 * Insert用払出・更生処理区分を取得します。
	 * @return Insert用払出・更生処理区分
	 */
	public String getID_Ins_Kubun_KoseiShori() {
		return ID_Ins_Kubun_KoseiShori;
	}

	/**
	 * Insert用払出・更生処理区分を設定します。
	 * @param ID_Ins_Kubun_KoseiShori Insert用払出・更生処理区分
	 */
	public void setID_Ins_Kubun_KoseiShori(String ID_Ins_Kubun_KoseiShori) {
		this.ID_Ins_Kubun_KoseiShori = ID_Ins_Kubun_KoseiShori;
	}

	/**
	 * Insert用払出・貸付受入金残高積数を取得します。
	 * @return Insert用払出・貸付受入金残高積数
	 */
	public java.math.BigDecimal getID_Ins_M_ZandakaSekisu() {
		return ID_Ins_M_ZandakaSekisu;
	}

	/**
	 * Insert用払出・貸付受入金残高積数を設定します。
	 * @param ID_Ins_M_ZandakaSekisu Insert用払出・貸付受入金残高積数
	 */
	public void setID_Ins_M_ZandakaSekisu(java.math.BigDecimal ID_Ins_M_ZandakaSekisu) {
		this.ID_Ins_M_ZandakaSekisu = ID_Ins_M_ZandakaSekisu;
	}

	/**
	 * Insert用払出・払出充当年月日を取得します。
	 * @return Insert用払出・払出充当年月日
	 */
	public String getID_Ins_Date_HaraidashiJuto() {
		return ID_Ins_Date_HaraidashiJuto;
	}

	/**
	 * Insert用払出・払出充当年月日を設定します。
	 * @param ID_Ins_Date_HaraidashiJuto Insert用払出・払出充当年月日
	 */
	public void setID_Ins_Date_HaraidashiJuto(String ID_Ins_Date_HaraidashiJuto) {
		this.ID_Ins_Date_HaraidashiJuto = ID_Ins_Date_HaraidashiJuto;
	}

	/**
	 * Insert用払出・貸付受入金残高を取得します。
	 * @return Insert用払出・貸付受入金残高
	 */
	public java.math.BigDecimal getID_Ins_M_HaraidashiKashitsukeZan() {
		return ID_Ins_M_HaraidashiKashitsukeZan;
	}

	/**
	 * Insert用払出・貸付受入金残高を設定します。
	 * @param ID_Ins_M_HaraidashiKashitsukeZan Insert用払出・貸付受入金残高
	 */
	public void setID_Ins_M_HaraidashiKashitsukeZan(java.math.BigDecimal ID_Ins_M_HaraidashiKashitsukeZan) {
		this.ID_Ins_M_HaraidashiKashitsukeZan = ID_Ins_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 修正用払出・債権管理番号を取得します。
	 * @return 修正用払出・債権管理番号
	 */
	public java.math.BigDecimal getID_HDNew0_ID_Credit() {
		return ID_HDNew0_ID_Credit;
	}

	/**
	 * 修正用払出・債権管理番号を設定します。
	 * @param ID_HDNew0_ID_Credit 修正用払出・債権管理番号
	 */
	public void setID_HDNew0_ID_Credit(java.math.BigDecimal ID_HDNew0_ID_Credit) {
		this.ID_HDNew0_ID_Credit = ID_HDNew0_ID_Credit;
	}

	/**
	 * 修正用払出・計数管理処理番号を取得します。
	 * @return 修正用払出・計数管理処理番号
	 */
	public String getID_HDNew0_KeisuKanriShori() {
		return ID_HDNew0_KeisuKanriShori;
	}

	/**
	 * 修正用払出・計数管理処理番号を設定します。
	 * @param ID_HDNew0_KeisuKanriShori 修正用払出・計数管理処理番号
	 */
	public void setID_HDNew0_KeisuKanriShori(String ID_HDNew0_KeisuKanriShori) {
		this.ID_HDNew0_KeisuKanriShori = ID_HDNew0_KeisuKanriShori;
	}

	/**
	 * 修正用払出・払出額を取得します。
	 * @return 修正用払出・払出額
	 */
	public java.math.BigDecimal getID_HDNew_M_Haraidashi() {
		return ID_HDNew_M_Haraidashi;
	}

	/**
	 * 修正用払出・払出額を設定します。
	 * @param ID_HDNew_M_Haraidashi 修正用払出・払出額
	 */
	public void setID_HDNew_M_Haraidashi(java.math.BigDecimal ID_HDNew_M_Haraidashi) {
		this.ID_HDNew_M_Haraidashi = ID_HDNew_M_Haraidashi;
	}

	/**
	 * 修正用払出・払出累計額を取得します。
	 * @return 修正用払出・払出累計額
	 */
	public java.math.BigDecimal getID_HDNew0_M_HaraidashiRuikei() {
		return ID_HDNew0_M_HaraidashiRuikei;
	}

	/**
	 * 修正用払出・払出累計額を設定します。
	 * @param ID_HDNew0_M_HaraidashiRuikei 修正用払出・払出累計額
	 */
	public void setID_HDNew0_M_HaraidashiRuikei(java.math.BigDecimal ID_HDNew0_M_HaraidashiRuikei) {
		this.ID_HDNew0_M_HaraidashiRuikei = ID_HDNew0_M_HaraidashiRuikei;
	}

	/**
	 * 修正用払出・繰上償還額を取得します。
	 * @return 修正用払出・繰上償還額
	 */
	public java.math.BigDecimal getID_HDNew0_M_Kurisho() {
		return ID_HDNew0_M_Kurisho;
	}

	/**
	 * 修正用払出・繰上償還額を設定します。
	 * @param ID_HDNew0_M_Kurisho 修正用払出・繰上償還額
	 */
	public void setID_HDNew0_M_Kurisho(java.math.BigDecimal ID_HDNew0_M_Kurisho) {
		this.ID_HDNew0_M_Kurisho = ID_HDNew0_M_Kurisho;
	}

	/**
	 * 修正用払出・繰上償還累計額を取得します。
	 * @return 修正用払出・繰上償還累計額
	 */
	public java.math.BigDecimal getID_HDNew0_M_KurishoRuikei() {
		return ID_HDNew0_M_KurishoRuikei;
	}

	/**
	 * 修正用払出・繰上償還累計額を設定します。
	 * @param ID_HDNew0_M_KurishoRuikei 修正用払出・繰上償還累計額
	 */
	public void setID_HDNew0_M_KurishoRuikei(java.math.BigDecimal ID_HDNew0_M_KurishoRuikei) {
		this.ID_HDNew0_M_KurishoRuikei = ID_HDNew0_M_KurishoRuikei;
	}

	/**
	 * 修正用払出・更生処理区分を取得します。
	 * @return 修正用払出・更生処理区分
	 */
	public String getID_HDNew0_Kubun_KoseiShori() {
		return ID_HDNew0_Kubun_KoseiShori;
	}

	/**
	 * 修正用払出・更生処理区分を設定します。
	 * @param ID_HDNew0_Kubun_KoseiShori 修正用払出・更生処理区分
	 */
	public void setID_HDNew0_Kubun_KoseiShori(String ID_HDNew0_Kubun_KoseiShori) {
		this.ID_HDNew0_Kubun_KoseiShori = ID_HDNew0_Kubun_KoseiShori;
	}

	/**
	 * 修正用払出・貸付受入金残高積数を取得します。
	 * @return 修正用払出・貸付受入金残高積数
	 */
	public java.math.BigDecimal getID_HDNew0_M_ZandakaSekisu() {
		return ID_HDNew0_M_ZandakaSekisu;
	}

	/**
	 * 修正用払出・貸付受入金残高積数を設定します。
	 * @param ID_HDNew0_M_ZandakaSekisu 修正用払出・貸付受入金残高積数
	 */
	public void setID_HDNew0_M_ZandakaSekisu(java.math.BigDecimal ID_HDNew0_M_ZandakaSekisu) {
		this.ID_HDNew0_M_ZandakaSekisu = ID_HDNew0_M_ZandakaSekisu;
	}

	/**
	 * 修正用払出・払出充当年月日を取得します。
	 * @return 修正用払出・払出充当年月日
	 */
	public String getID_HDNew0_Date_HaraidashiJuto() {
		return ID_HDNew0_Date_HaraidashiJuto;
	}

	/**
	 * 修正用払出・払出充当年月日を設定します。
	 * @param ID_HDNew0_Date_HaraidashiJuto 修正用払出・払出充当年月日
	 */
	public void setID_HDNew0_Date_HaraidashiJuto(String ID_HDNew0_Date_HaraidashiJuto) {
		this.ID_HDNew0_Date_HaraidashiJuto = ID_HDNew0_Date_HaraidashiJuto;
	}

	/**
	 * 修正用払出・貸付受入金残高を取得します。
	 * @return 修正用払出・貸付受入金残高
	 */
	public java.math.BigDecimal getID_HDNew0_M_HaraidashiKashitsukeZan() {
		return ID_HDNew0_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 修正用払出・貸付受入金残高を設定します。
	 * @param ID_HDNew0_M_HaraidashiKashitsukeZan 修正用払出・貸付受入金残高
	 */
	public void setID_HDNew0_M_HaraidashiKashitsukeZan(
			java.math.BigDecimal ID_HDNew0_M_HaraidashiKashitsukeZan) {
		this.ID_HDNew0_M_HaraidashiKashitsukeZan = ID_HDNew0_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 次回約定データ・約定前残高を取得します。
	 * @return 次回約定データ・約定前残高
	 */
	public java.math.BigDecimal getID_YJNxt_M_ZandakaBeforeYakujo() {
		return ID_YJNxt_M_ZandakaBeforeYakujo;
	}

	/**
	 * 次回約定データ・約定前残高を設定します。
	 * @param ID_YJNxt_M_ZandakaBeforeYakujo 次回約定データ・約定前残高
	 */
	public void setID_YJNxt_M_ZandakaBeforeYakujo(java.math.BigDecimal ID_YJNxt_M_ZandakaBeforeYakujo) {
		this.ID_YJNxt_M_ZandakaBeforeYakujo = ID_YJNxt_M_ZandakaBeforeYakujo;
	}

	/**
	 * 次回約定データ・約定元金を取得します。
	 * @return 次回約定データ・約定元金
	 */
	public java.math.BigDecimal getID_YJNxt_M_YakujoGankin() {
		return ID_YJNxt_M_YakujoGankin;
	}

	/**
	 * 次回約定データ・約定元金を設定します。
	 * @param ID_YJNxt_M_YakujoGankin 次回約定データ・約定元金
	 */
	public void setID_YJNxt_M_YakujoGankin(java.math.BigDecimal ID_YJNxt_M_YakujoGankin) {
		this.ID_YJNxt_M_YakujoGankin = ID_YJNxt_M_YakujoGankin;
	}

	/**
	 * 次回約定データ・約定利息を取得します。
	 * @return 次回約定データ・約定利息
	 */
	public java.math.BigDecimal getID_YJNxt_M_YakujoRisoku() {
		return ID_YJNxt_M_YakujoRisoku;
	}

	/**
	 * 次回約定データ・約定利息を設定します。
	 * @param ID_YJNxt_M_YakujoRisoku 次回約定データ・約定利息
	 */
	public void setID_YJNxt_M_YakujoRisoku(java.math.BigDecimal ID_YJNxt_M_YakujoRisoku) {
		this.ID_YJNxt_M_YakujoRisoku = ID_YJNxt_M_YakujoRisoku;
	}

	/**
	 * Key債権管理番号を取得します。
	 * @return Key債権管理番号
	 */
	public java.math.BigDecimal getKey_ID_Credit() {
		return Key_ID_Credit;
	}

	/**
	 * Key債権管理番号を設定します。
	 * @param Key_ID_Credit Key債権管理番号
	 */
	public void setKey_ID_Credit(java.math.BigDecimal Key_ID_Credit) {
		this.Key_ID_Credit = Key_ID_Credit;
	}

	/**
	 * Key計数管理処理番号を取得します。
	 * @return Key計数管理処理番号
	 */
	public String getKey_ID_KeisuKanriShori() {
		return Key_ID_KeisuKanriShori;
	}

	/**
	 * Key計数管理処理番号を設定します。
	 * @param Key_ID_KeisuKanriShori Key計数管理処理番号
	 */
	public void setKey_ID_KeisuKanriShori(String Key_ID_KeisuKanriShori) {
		this.Key_ID_KeisuKanriShori = Key_ID_KeisuKanriShori;
	}

	/**
	 * 計算結果用賦金を取得します。
	 * @return 計算結果用賦金
	 */
	public java.math.BigDecimal getID_Rst_M_Fukin() {
		return ID_Rst_M_Fukin;
	}

	/**
	 * 計算結果用賦金を設定します。
	 * @param ID_Rst_M_Fukin 計算結果用賦金
	 */
	public void setID_Rst_M_Fukin(java.math.BigDecimal ID_Rst_M_Fukin) {
		this.ID_Rst_M_Fukin = ID_Rst_M_Fukin;
	}

	/**
	 * 計算結果調整コードを取得します。
	 * @return 計算結果調整コード
	 */
	public String getID_Rst_Code_Chosei() {
		return ID_Rst_Code_Chosei;
	}

	/**
	 * 計算結果調整コードを設定します。
	 * @param ID_Rst_Code_Chosei 計算結果調整コード
	 */
	public void setID_Rst_Code_Chosei(String ID_Rst_Code_Chosei) {
		this.ID_Rst_Code_Chosei = ID_Rst_Code_Chosei;
	}

	/**
	 * 計算結果用元金均等額を取得します。
	 * @return 計算結果用元金均等額
	 */
	public java.math.BigDecimal getID_Rst_M_GankinKinto() {
		return ID_Rst_M_GankinKinto;
	}

	/**
	 * 計算結果用元金均等額を設定します。
	 * @param ID_Rst_M_GankinKinto 計算結果用元金均等額
	 */
	public void setID_Rst_M_GankinKinto(java.math.BigDecimal ID_Rst_M_GankinKinto) {
		this.ID_Rst_M_GankinKinto = ID_Rst_M_GankinKinto;
	}

	/**
	 * 計算結果用元金不均等額を取得します。
	 * @return 計算結果用元金不均等額
	 */
	public java.math.BigDecimal getID_Rst_M_GankinFukinto() {
		return ID_Rst_M_GankinFukinto;
	}

	/**
	 * 計算結果用元金不均等額を設定します。
	 * @param ID_Rst_M_GankinFukinto 計算結果用元金不均等額
	 */
	public void setID_Rst_M_GankinFukinto(java.math.BigDecimal ID_Rst_M_GankinFukinto) {
		this.ID_Rst_M_GankinFukinto = ID_Rst_M_GankinFukinto;
	}

	/**
	 * 計算約定元金（非表示）を取得します。
	 * @return 計算約定元金（非表示）
	 */
	public java.math.BigDecimal getID_Rst_M_YakujoGankin() {
		return ID_Rst_M_YakujoGankin;
	}

	/**
	 * 計算約定元金（非表示）を設定します。
	 * @param ID_Rst_M_YakujoGankin 計算約定元金（非表示）
	 */
	public void setID_Rst_M_YakujoGankin(java.math.BigDecimal ID_Rst_M_YakujoGankin) {
		this.ID_Rst_M_YakujoGankin = ID_Rst_M_YakujoGankin;
	}

	/**
	 * 計算約定利息（非表示）を取得します。
	 * @return 計算約定利息（非表示）
	 */
	public java.math.BigDecimal getID_Rst_M_YakujoRisoku() {
		return ID_Rst_M_YakujoRisoku;
	}

	/**
	 * 計算約定利息（非表示）を設定します。
	 * @param ID_Rst_M_YakujoRisoku 計算約定利息（非表示）
	 */
	public void setID_Rst_M_YakujoRisoku(java.math.BigDecimal ID_Rst_M_YakujoRisoku) {
		this.ID_Rst_M_YakujoRisoku = ID_Rst_M_YakujoRisoku;
	}

	/**
	 * 請求データ更新用・Key:払込年月日　領域を取得します。
	 * @return 請求データ更新用・Key:払込年月日　領域
	 */
	public String getID_Key_Date_Haraikomi_SeikyuUp() {
		return ID_Key_Date_Haraikomi_SeikyuUp;
	}

	/**
	 * 請求データ更新用・Key:払込年月日　領域を設定します。
	 * @param ID_Key_Date_Haraikomi_SeikyuUp 請求データ更新用・Key:払込年月日　領域
	 */
	public void setID_Key_Date_Haraikomi_SeikyuUp(String ID_Key_Date_Haraikomi_SeikyuUp) {
		this.ID_Key_Date_Haraikomi_SeikyuUp = ID_Key_Date_Haraikomi_SeikyuUp;
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
	 * 扱店別稟議データの最新データ更新日付を取得します。
	 * @return 扱店別稟議データの最新データ更新日付
	 */
	public String getID_Data_LastUpDate() {
		return ID_Data_LastUpDate;
	}

	/**
	 * 扱店別稟議データの最新データ更新日付を設定します。
	 * @param ID_Data_LastUpDate 扱店別稟議データの最新データ更新日付
	 */
	public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
		this.ID_Data_LastUpDate = ID_Data_LastUpDate;
	}

	/**
	 * 退避履歴番号を取得します。
	 * @return 退避履歴番号
	 */
	public String getID_Keep_ID_History() {
		return ID_Keep_ID_History;
	}

	/**
	 * 退避履歴番号を設定します。
	 * @param ID_Keep_ID_History 退避履歴番号
	 */
	public void setID_Keep_ID_History(String ID_Keep_ID_History) {
		this.ID_Keep_ID_History = ID_Keep_ID_History;
	}

	/**
	 * 保存・取消１用払出・債権管理番号を取得します。
	 * @return 保存・取消１用払出・債権管理番号
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_ID_Credit() {
		return ID_HDDel1_Keep_ID_Credit;
	}

	/**
	 * 保存・取消１用払出・債権管理番号を設定します。
	 * @param ID_HDDel1_Keep_ID_Credit 保存・取消１用払出・債権管理番号
	 */
	public void setID_HDDel1_Keep_ID_Credit(java.math.BigDecimal ID_HDDel1_Keep_ID_Credit) {
		this.ID_HDDel1_Keep_ID_Credit = ID_HDDel1_Keep_ID_Credit;
	}

	/**
	 * 保存・取消１用払出・計数管理処理番号を取得します。
	 * @return 保存・取消１用払出・計数管理処理番号
	 */
	public String getID_HDDel1_Keep_ID_KeisuKanriShori() {
		return ID_HDDel1_Keep_ID_KeisuKanriShori;
	}

	/**
	 * 保存・取消１用払出・計数管理処理番号を設定します。
	 * @param ID_HDDel1_Keep_ID_KeisuKanriShori 保存・取消１用払出・計数管理処理番号
	 */
	public void setID_HDDel1_Keep_ID_KeisuKanriShori(String ID_HDDel1_Keep_ID_KeisuKanriShori) {
		this.ID_HDDel1_Keep_ID_KeisuKanriShori = ID_HDDel1_Keep_ID_KeisuKanriShori;
	}

	/**
	 * 保存・取消１用払出・払出額を取得します。
	 * @return 保存・取消１用払出・払出額
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_Haraidashi() {
		return ID_HDDel1_Keep_M_Haraidashi;
	}

	/**
	 * 保存・取消１用払出・払出額を設定します。
	 * @param ID_HDDel1_Keep_M_Haraidashi 保存・取消１用払出・払出額
	 */
	public void setID_HDDel1_Keep_M_Haraidashi(java.math.BigDecimal ID_HDDel1_Keep_M_Haraidashi) {
		this.ID_HDDel1_Keep_M_Haraidashi = ID_HDDel1_Keep_M_Haraidashi;
	}

	/**
	 * 保存・取消１用払出・払出累計額を取得します。
	 * @return 保存・取消１用払出・払出累計額
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_HaraidashiRuikei() {
		return ID_HDDel1_Keep_M_HaraidashiRuikei;
	}

	/**
	 * 保存・取消１用払出・払出累計額を設定します。
	 * @param ID_HDDel1_Keep_M_HaraidashiRuikei 保存・取消１用払出・払出累計額
	 */
	public void setID_HDDel1_Keep_M_HaraidashiRuikei(java.math.BigDecimal ID_HDDel1_Keep_M_HaraidashiRuikei) {
		this.ID_HDDel1_Keep_M_HaraidashiRuikei = ID_HDDel1_Keep_M_HaraidashiRuikei;
	}

	/**
	 * 保存・取消１用払出・繰上償還額を取得します。
	 * @return 保存・取消１用払出・繰上償還額
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_Kurisho() {
		return ID_HDDel1_Keep_M_Kurisho;
	}

	/**
	 * 保存・取消１用払出・繰上償還額を設定します。
	 * @param ID_HDDel1_Keep_M_Kurisho 保存・取消１用払出・繰上償還額
	 */
	public void setID_HDDel1_Keep_M_Kurisho(java.math.BigDecimal ID_HDDel1_Keep_M_Kurisho) {
		this.ID_HDDel1_Keep_M_Kurisho = ID_HDDel1_Keep_M_Kurisho;
	}

	/**
	 * 保存・取消１用払出・繰上償還累計額を取得します。
	 * @return 保存・取消１用払出・繰上償還累計額
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_KurishoRuikei() {
		return ID_HDDel1_Keep_M_KurishoRuikei;
	}

	/**
	 * 保存・取消１用払出・繰上償還累計額を設定します。
	 * @param ID_HDDel1_Keep_M_KurishoRuikei 保存・取消１用払出・繰上償還累計額
	 */
	public void setID_HDDel1_Keep_M_KurishoRuikei(java.math.BigDecimal ID_HDDel1_Keep_M_KurishoRuikei) {
		this.ID_HDDel1_Keep_M_KurishoRuikei = ID_HDDel1_Keep_M_KurishoRuikei;
	}

	/**
	 * 保存・取消１用払出・更生処理区分を取得します。
	 * @return 保存・取消１用払出・更生処理区分
	 */
	public String getID_HDDel1_Keep_Kubun_KoseiShori() {
		return ID_HDDel1_Keep_Kubun_KoseiShori;
	}

	/**
	 * 保存・取消１用払出・更生処理区分を設定します。
	 * @param ID_HDDel1_Keep_Kubun_KoseiShori 保存・取消１用払出・更生処理区分
	 */
	public void setID_HDDel1_Keep_Kubun_KoseiShori(String ID_HDDel1_Keep_Kubun_KoseiShori) {
		this.ID_HDDel1_Keep_Kubun_KoseiShori = ID_HDDel1_Keep_Kubun_KoseiShori;
	}

	/**
	 * 保存・取消１用払出・貸付受入金残高積数を取得します。
	 * @return 保存・取消１用払出・貸付受入金残高積数
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_ZandakaSekisu() {
		return ID_HDDel1_Keep_M_ZandakaSekisu;
	}

	/**
	 * 保存・取消１用払出・貸付受入金残高積数を設定します。
	 * @param ID_HDDel1_Keep_M_ZandakaSekisu 保存・取消１用払出・貸付受入金残高積数
	 */
	public void setID_HDDel1_Keep_M_ZandakaSekisu(java.math.BigDecimal ID_HDDel1_Keep_M_ZandakaSekisu) {
		this.ID_HDDel1_Keep_M_ZandakaSekisu = ID_HDDel1_Keep_M_ZandakaSekisu;
	}

	/**
	 * 保存・取消１用払出・払出充当年月日を取得します。
	 * @return 保存・取消１用払出・払出充当年月日
	 */
	public String getID_HDDel1_Keep_Date_HaraidashiJuto() {
		return ID_HDDel1_Keep_Date_HaraidashiJuto;
	}

	/**
	 * 保存・取消１用払出・払出充当年月日を設定します。
	 * @param ID_HDDel1_Keep_Date_HaraidashiJuto 保存・取消１用払出・払出充当年月日
	 */
	public void setID_HDDel1_Keep_Date_HaraidashiJuto(String ID_HDDel1_Keep_Date_HaraidashiJuto) {
		this.ID_HDDel1_Keep_Date_HaraidashiJuto = ID_HDDel1_Keep_Date_HaraidashiJuto;
	}

	/**
	 * 保存・取消１用払出・貸付受入金残高を取得します。
	 * @return 保存・取消１用払出・貸付受入金残高
	 */
	public java.math.BigDecimal getID_HDDel1_Keep_M_HaraidashiKashitsukeZan() {
		return ID_HDDel1_Keep_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 保存・取消１用払出・貸付受入金残高を設定します。
	 * @param ID_HDDel1_Keep_M_HaraidashiKashitsukeZan 保存・取消１用払出・貸付受入金残高
	 */
	public void setID_HDDel1_Keep_M_HaraidashiKashitsukeZan(
			java.math.BigDecimal ID_HDDel1_Keep_M_HaraidashiKashitsukeZan) {
		this.ID_HDDel1_Keep_M_HaraidashiKashitsukeZan = ID_HDDel1_Keep_M_HaraidashiKashitsukeZan;
	}

	/**
	 * 報告書種別（値）(非表示)を取得します。
	 * @return 報告書種別（値）(非表示)
	 */
	public String getDataCode() {
		return DataCode;
	}

	/**
	 * 報告書種別（値）(非表示)を設定します。
	 * @param DataCode 報告書種別（値）(非表示)
	 */
	public void setDataCode(String DataCode) {
		this.DataCode = DataCode;
	}

	/**
	 * 処理モードを取得します。
	 * @return 処理モード
	 */
	public String getProcess_Mode() {
		return Process_Mode;
	}

	/**
	 * 処理モードを設定します。
	 * @param Process_Mode 処理モード
	 */
	public void setProcess_Mode(String Process_Mode) {
		this.Process_Mode = Process_Mode;
	}

	/**
	 * モードタイプを取得します。
	 * @return モードタイプ
	 */
	public String getModeType() {
		return ModeType;
	}

	/**
	 * モードタイプを設定します。
	 * @param ModeType モードタイプ
	 */
	public void setModeType(String ModeType) {
		this.ModeType = ModeType;
	}

	/**
	 * 赤データ入力域を取得します。
	 * @return 赤データ入力域
	 */
	public String getRed_Area() {
		return Red_Area;
	}

	/**
	 * 赤データ入力域を設定します。
	 * @param Red_Area 赤データ入力域
	 */
	public void setRed_Area(String Red_Area) {
		this.Red_Area = Red_Area;
	}

	/**
	 * 黒データ入力域を取得します。
	 * @return 黒データ入力域
	 */
	public String getBrack_Area() {
		return Brack_Area;
	}

	/**
	 * 黒データ入力域を設定します。
	 * @param Brack_Area 黒データ入力域
	 */
	public void setBrack_Area(String Brack_Area) {
		this.Brack_Area = Brack_Area;
	}

	/**
	 * 赤データ入力領域タイトル（"赤"） を取得します。
	 *
	 * @return 赤データ入力領域タイトル（"赤"）
	 */
	public String getLblID_Head_Red2() {
		return lblID_Head_Red2;
	}

	/**
	 * 赤データ入力領域タイトル（"赤"） を設定します。
	 *
	 * @param lblID_Head_Red2 赤データ入力領域タイトル（"赤"）
	 */
	public void setLblID_Head_Red2(String lblID_Head_Red2) {
		this.lblID_Head_Red2 = lblID_Head_Red2;
	}

	/**
	 * 請求データを取消更新する場合のフラグを取得します。
	 * @return 請求データを取消更新する場合のフラグ（true=有）
	 */
	public boolean getFlgSeikyuUpShusei() {
		return flgSeikyuUpShusei;
	}

	/**
	 * 請求データを取消更新する場合のフラグを設定します。
	 * @param flgSeikyuUpShusei 請求データを取消更新する場合のフラグ（true=有）
	 */
	public void setFlgSeikyuUpShusei(boolean flgSeikyuUpShusei) {
		this.flgSeikyuUpShusei = flgSeikyuUpShusei;
	}

	/**
	 * 請求データを取消更新する場合のフラグを取得します。
	 * @return 請求データを取消更新する場合のフラグ（true=有）
	 */
	public boolean getFlgSeikyuUpTorikeshi() {
		return flgSeikyuUpTorikeshi;
	}

	/**
	 * 請求データを取消更新する場合のフラグを設定します。
	 * @param flgSeikyuUpShusei 請求データを取消更新する場合のフラグ（true=有）
	 */
	public void setFlgSeikyuUpTorikeshi(boolean flgSeikyuUpTorikeshi) {
		this.flgSeikyuUpTorikeshi = flgSeikyuUpTorikeshi;
	}

	/**
	 * セット条変起案中区分を取得します。
	 * @return ID_Set_Kubun_JohenKianchu セット条変起案中区分
	 */
	public String getID_Set_Kubun_JohenKianchu() {
		return ID_Set_Kubun_JohenKianchu;
	}

	/**
	 * セット条変起案中区分を設定します。
	 * @param ID_Set_Kubun_JohenKianchu セット条変起案中区分
	 */
	public void setID_Set_Kubun_JohenKianchu(String ID_Set_Kubun_JohenKianchu) {
		this.ID_Set_Kubun_JohenKianchu = ID_Set_Kubun_JohenKianchu;
	}

	/**
	 * 請求・払込年月日（非表示）を取得します。
	 * @return setID_Key_Date_Haraikomi_Seikyu_Shusei セット条変起案中区分
	 */
	public String getID_Key_Date_Haraikomi_Seikyu_Shusei() {
		return ID_Key_Date_Haraikomi_Seikyu_Shusei;
	}

	/**
	 * 請求・払込年月日（非表示）を設定します。
	 * @param setID_Key_Date_Haraikomi_Seikyu_Shusei 請求・払込年月日（非表示）
	 */
	public void setID_Key_Date_Haraikomi_Seikyu_Shusei(String ID_Key_Date_Haraikomi_Seikyu_Shusei) {
		this.ID_Key_Date_Haraikomi_Seikyu_Shusei = ID_Key_Date_Haraikomi_Seikyu_Shusei;
	}

	/**
	 * 請求_取消用・払込年月日を取得します。
	 * @return setID_Key_Date_Haraikomi_Seikyu_Shusei セット条変起案中区分
	 */
	public String getID_Key_Date_Haraikomi_Seikyu_Torikeshi() {
		return ID_Key_Date_Haraikomi_Seikyu_Torikeshi;
	}

	/**
	 * 請求_取消用・払込年月日を設定します。
	 * @param setID_Key_Date_Haraikomi_Seikyu_Shusei ｙ（非表示）
	 */
	public void setID_Key_Date_Haraikomi_Seikyu_Torikeshi(String ID_Key_Date_Haraikomi_Seikyu_Torikeshi) {
		this.ID_Key_Date_Haraikomi_Seikyu_Torikeshi = ID_Key_Date_Haraikomi_Seikyu_Torikeshi;
	}

	/**
	 * 請求 取消用・約定元金 （非表示）を取得します。
	 * @return 請求 取消用・約定元金 （非表示）
	 */
	public java.math.BigDecimal getID_M_YakujoGankin_Seikyu_Torikeshi() {
		return ID_M_YakujoGankin_Seikyu_Torikeshi;
	}

	/**
	 * 請求 取消用・約定元金 （非表示）を設定します。
	 * @param ID_M_YakujoGankin_Seikyu_Torikeshi 請求　取消用・約定元金 （非表示）
	 */
	public void setID_M_YakujoGankin_Seikyu_Torikeshi(java.math.BigDecimal ID_M_YakujoGankin_Seikyu_Torikeshi) {
		this.ID_M_YakujoGankin_Seikyu_Torikeshi = ID_M_YakujoGankin_Seikyu_Torikeshi;
	}

	/**
	 * 請求　取消用・約定利息 （非表示）を取得します。
	 * @return 請求　取消用・約定利息（非表示）
	 */
	public java.math.BigDecimal getID_M_YakujoRisoku_Seikyu_Torikeshi() {
		return ID_M_YakujoRisoku_Seikyu_Torikeshi;
	}

	/**
	 * 請求　取消用・約定利息 （非表示）を設定します。
	 * @param ID_M_YakujoRisoku_Seikyu_Torikeshi 請求　取消用・約定利息 （非表示）
	 */
	public void setID_M_YakujoRisoku_Seikyu_Torikeshi(java.math.BigDecimal ID_M_YakujoRisoku_Seikyu_Torikeshi) {
		this.ID_M_YakujoRisoku_Seikyu_Torikeshi = ID_M_YakujoRisoku_Seikyu_Torikeshi;
	}

}