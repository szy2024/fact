//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/14 | 橋本　亮              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md005.common;

public class Md005Constants {
	/** 代位弁済金払込・充当報告書取消・修正（入力画面）戻り表示コントローラ名 */
	public static final String EVENT_ID_MD005_01RETURN = "Md005_01Return";

	/** 代位弁済金払込・充当報告書取消・修正（入力確認画面）初期表示コントローラ名 */
	public static final String EVENT_ID_MD005_02INIT = "Md005_02Init";
	/** 代位弁済金払込・充当報告書取消・修正（入力結果画面）初期表示コントローラ名 */
	public static final String EVENT_ID_MD005_03INIT = "Md005_03Init";

	/** 報告書取消・修正（照会結果(詳細）画面）初期表示コントローラ名 */
	public static final String EVENT_ID_MD000_02INIT = "Md000_02Init";
	/** 報告書取消・修正（照会結果(詳細）画面）戻り表示コントローラ名 */
	public static final String EVENT_ID_MD000_02RETURN = "Md000_02Return";

	/** 遷移パラメータ(報告年月日 ) */
	public static final String PROPERTY_LBLID_DATE_REPORT = "lblID_Date_Report";
	/** 遷移パラメータ(メッセージ ) */
	public static final String PROPERTY_LBLMESSAGE = "lblMessage";
	/** 遷移パラメータ(赤データ入力領域タイトル ) */
	public static final String PROPERTY_LBLID_HEAD_RED = "lblID_Head_Red";
	/** 遷移パラメータ(赤データ入力領域タイトル（"赤"） ) */
	public static final String PROPERTY_LBLID_HEAD_RED2 = "lblID_Head_Red2";
	/** 遷移パラメータ(顧客名 ) */
	public static final String PROPERTY_TXTID_NAME_CUSTOMER_RED = "txtID_Name_Customer_Red";
	/** 遷移パラメータ(扱店名 ) */
	public static final String PROPERTY_TXTID_NAME_ORGANIZATION_RED = "txtID_Name_Organization_Red";
	/** 遷移パラメータ(公庫支店 ) */
	public static final String PROPERTY_TXTID_CODE_KOUKOSHITEN_RED = "txtID_Code_KoukoShiten_Red";
	/** 遷移パラメータ(扱店 ) */
	public static final String PROPERTY_TXTID_CODE_ORGANIZATION_RED = "txtID_Code_Organization_Red";
	/** 遷移パラメータ(店舗 ) */
	public static final String PROPERTY_TXTID_CODE_TENPO_RED = "txtID_Code_Tenpo_Red";
	/** 遷移パラメータ(年度 ) */
	public static final String PROPERTY_TXTID_YEAR_RED = "txtID_Year_Red";
	/** 遷移パラメータ(方式資金 ) */
	public static final String PROPERTY_TXTID_CODE_HOSHIKISHIKIN_RED = "txtID_Code_HoshikiShikin_Red";
	/** 遷移パラメータ(番号 ) */
	public static final String PROPERTY_TXTID_ID_RINGI_RED = "txtID_ID_Ringi_Red";
	/** 遷移パラメータ(枝番 ) */
	public static final String PROPERTY_TXTID_ID_RINGIBRANCH_RED = "txtID_ID_RingiBranch_Red";
	/** 遷移パラメータ(充当対象払込期日 ) */
	public static final String PROPERTY_TXTID_DATE_JUTOTAISHO_RED = "txtID_Date_JutoTaisho_Red";
	/** 遷移パラメータ(代弁金払込日 ) */
	public static final String PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMI_RED = "txtID_Date_DaibenkinHaraikomi_Red";
	/** 遷移パラメータ(遅延損害金(円) ) */
	public static final String PROPERTY_TXTID_M_CHIENSONGAI_RED = "txtID_M_ChienSongai_Red";
	/** 遷移パラメータ(利息(円) ) */
	public static final String PROPERTY_TXTID_M_RISOKU_RED = "txtID_M_Risoku_Red";
	/** 遷移パラメータ(繰上償還手数料(円) ) */
	public static final String PROPERTY_TXTID_M_KURISHOCOMMISSION_RED = "txtID_M_KurishoCommission_Red";
	/** 遷移パラメータ(元金(円) ) */
	public static final String PROPERTY_TXTID_M_GANKIN_RED = "txtID_M_Gankin_Red";
	/** 遷移パラメータ(仮受金(一般口)からの充当額(円) ) */
	public static final String PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED = "txtID_M_KariukeIppanJuto_Red";
	/** 遷移パラメータ(計(円) ) */
	public static final String PROPERTY_TXTID_M_KEI_RED = "txtID_M_Kei_Red";
	/** 遷移パラメータ(送金額(円) ) */
	public static final String PROPERTY_TXTID_M_SOKIN_RED = "txtID_M_Sokin_Red";
	/** 遷移パラメータ(代弁金充当後残元金(円) ) */
	public static final String PROPERTY_TXTID_M_ZANGANAFTERDAIBENJUTO_RED = "txtID_M_ZanGanAfterDaibenJuto_Red";
	/** 遷移パラメータ(受託者勘定処理年月 ) */
	public static final String PROPERTY_TXTID_DATE_JTKSHORI_RED = "txtID_Date_Jtkshori_Red";
	/** 遷移パラメータ(送金日 ) */
	public static final String PROPERTY_TXTID_DATE_SOKIN_RED = "txtID_Date_Sokin_Red";
	/** 遷移パラメータ(送金日番号 ) */
	public static final String PROPERTY_TXTID_ID_SOKINBI_RED = "txtID_ID_Sokinbi_Red";
	/** 遷移パラメータ(受託者勘定処理年月(元号) ) */
	public static final String PROPERTY_DRPID_DATE_JTKSHORIGENGOU_RED = "drpID_Date_JtkshoriGengou_Red";
	/** 遷移パラメータ(受託者勘定処理年月(年) ) */
	public static final String PROPERTY_TXTID_DATE_JTKSHORIYEAR_RED = "txtID_Date_JtkshoriYear_Red";
	/** 遷移パラメータ(受託者勘定処理年月(月) ) */
	public static final String PROPERTY_DRPID_DATE_JTKSHORIMONTH_RED = "drpID_Date_JtkshoriMonth_Red";
	/** 遷移パラメータ(黒データ入力領域タイトル ) */
	public static final String PROPERTY_LBLID_HEAD = "lblID_Head";
	/** 遷移パラメータ(顧客名（修正） ) */
	public static final String PROPERTY_TXTID_NAME_CUSTOMER = "txtID_Name_Customer";
	/** 遷移パラメータ(扱店名（修正） ) */
	public static final String PROPERTY_TXTID_NAME_ORGANIZATION = "txtID_Name_Organization";
	/** 遷移パラメータ(公庫支店（修正） ) */
	public static final String PROPERTY_TXTID_CODE_KOUKOSHITEN = "txtID_Code_KoukoShiten";
	/** 遷移パラメータ(扱店（修正） ) */
	public static final String PROPERTY_TXTID_CODE_ORGANIZATION = "txtID_Code_Organization";
	/** 遷移パラメータ(店舗（修正） ) */
	public static final String PROPERTY_TXTID_CODE_TENPO = "txtID_Code_Tenpo";
	/** 遷移パラメータ(年度（修正） ) */
	public static final String PROPERTY_TXTID_YEAR = "txtID_Year";
	/** 遷移パラメータ(方式資金（修正） ) */
	public static final String PROPERTY_TXTID_CODE_HOSHIKISHIKIN = "txtID_Code_HoshikiShikin";
	/** 遷移パラメータ(番号（修正） ) */
	public static final String PROPERTY_TXTID_ID_RINGI = "txtID_ID_Ringi";
	/** 遷移パラメータ(枝番（修正） ) */
	public static final String PROPERTY_TXTID_ID_RINGIBRANCH = "txtID_ID_RingiBranch";
	/** 遷移パラメータ(充当対象払込期日(元号)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_JUTOTAISHOGENGOU = "drpID_Date_JutoTaishoGengou";
	/** 遷移パラメータ(充当対象払込期日(年)（修正） ) */
	public static final String PROPERTY_TXTID_DATE_JUTOTAISHOYEAR = "txtID_Date_JutoTaishoYear";
	/** 遷移パラメータ(充当対象払込期日(月)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_JUTOTAISHOMONTH = "drpID_Date_JutoTaishoMonth";
	/** 遷移パラメータ(充当対象払込期日(日)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_JUTOTAISHODAY = "drpID_Date_JutoTaishoDay";
	/** 遷移パラメータ(代弁金払込日(元号)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIGENGOU = "drpID_Date_DaibenkinHaraikomiGengou";
	/** 遷移パラメータ(代弁金払込日(年)（修正） ) */
	public static final String PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMIYEAR = "txtID_Date_DaibenkinHaraikomiYear";
	/** 遷移パラメータ(代弁金払込日(月)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIMONTH = "drpID_Date_DaibenkinHaraikomiMonth";
	/** 遷移パラメータ(代弁金払込日(日)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIDAY = "drpID_Date_DaibenkinHaraikomiDay";
	/** 遷移パラメータ(遅延損害金(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_CHIENSONGAI = "txtID_M_ChienSongai";
	/** 遷移パラメータ(利息(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_RISOKU = "txtID_M_Risoku";
	/** 遷移パラメータ(繰上償還手数料(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_KURISHOCOMMISSION = "txtID_M_KurishoCommission";
	/** 遷移パラメータ(元金(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_GANKIN = "txtID_M_Gankin";
	/** 遷移パラメータ(仮受金(一般口)からの充当額(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_KARIUKEIPPANJUTO = "txtID_M_KariukeIppanJuto";
	/** 遷移パラメータ(計(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_KEI = "txtID_M_Kei";
	/** 遷移パラメータ(送金額(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_SOKIN = "txtID_M_Sokin";
	/** 遷移パラメータ(代弁金充当後残元金(円)（修正） ) */
	public static final String PROPERTY_TXTID_M_ZANGANAFTERDAIBENJUTO = "txtID_M_ZanGanAfterDaibenJuto";
	/** 遷移パラメータ(受託者勘定処理年月（修正） ) */
	public static final String PROPERTY_TXTID_DATE_JTKSHORI = "txtID_Date_Jtkshori";
	/** 遷移パラメータ(送金日(元号)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_SOKINGENGOU = "drpID_Date_SokinGengou";
	/** 遷移パラメータ(送金日(年)（修正） ) */
	public static final String PROPERTY_TXTID_DATE_SOKINYEAR = "txtID_Date_SokinYear";
	/** 遷移パラメータ(送金日(月)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_SOKINMONTH = "drpID_Date_SokinMonth";
	/** 遷移パラメータ(送金日(日)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_SOKINDAY = "drpID_Date_SokinDay";
	/** 遷移パラメータ(送金日番号（修正） ) */
	public static final String PROPERTY_TXTID_ID_SOKINBI = "txtID_ID_Sokinbi";
	/** 遷移パラメータ(受託者勘定処理年月(元号)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_JTKSHORIGENGOU = "drpID_Date_JtkshoriGengou";
	/** 遷移パラメータ(受託者勘定処理年月(年)（修正） ) */
	public static final String PROPERTY_TXTID_DATE_JTKSHORIYEAR = "txtID_Date_JtkshoriYear";
	/** 遷移パラメータ(受託者勘定処理年月(月)（修正） ) */
	public static final String PROPERTY_DRPID_DATE_JTKSHORIMONTH = "drpID_Date_JtkshoriMonth";
	/** 遷移パラメータ(報告書番号 ) */
	public static final String PROPERTY_ID_ID_REPORT = "ID_ID_Report";
	/** 遷移パラメータ(報告年月日A ) */
	public static final String PROPERTY_ID_DATE_REPORT = "ID_Date_Report";
	/** 遷移パラメータ(扱店名A ) */
	public static final String PROPERTY_ID_NAME_ORGANIZATION = "ID_Name_Organization";
	/** 遷移パラメータ(顧客名A ) */
	public static final String PROPERTY_ID_NAME_CUSTOMER = "ID_Name_Customer";
	/** 遷移パラメータ(公庫支店A ) */
	public static final String PROPERTY_ID_CODE_KOUKOSHITEN = "ID_Code_KoukoShiten";
	/** 遷移パラメータ(扱店A ) */
	public static final String PROPERTY_ID_CODE_ORGANIZATION = "ID_Code_Organization";
	/** 遷移パラメータ(店舗A ) */
	public static final String PROPERTY_ID_CODE_TENPO = "ID_Code_Tenpo";
	/** 遷移パラメータ(年度A ) */
	public static final String PROPERTY_ID_YEAR = "ID_Year";
	/** 遷移パラメータ(方式資金A ) */
	public static final String PROPERTY_ID_CODE_HOSHIKISHIKIN = "ID_Code_HoshikiShikin";
	/** 遷移パラメータ(番号A ) */
	public static final String PROPERTY_ID_ID_RINGI = "ID_ID_Ringi";
	/** 遷移パラメータ(枝番A ) */
	public static final String PROPERTY_ID_ID_RINGIBRANCH = "ID_ID_RingiBranch";
	/** 遷移パラメータ(充当対象払込期日A ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHO = "ID_Date_JutoTaisho";
	/** 遷移パラメータ(充当対象払込期日(元号) ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHOGENGOU = "ID_Date_JutoTaishoGengou";
	/** 遷移パラメータ(充当対象払込期日(西暦年) ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHOYEAR = "ID_Date_JutoTaishoYear";
	/** 遷移パラメータ(充当対象払込期日(月) ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHOMONTH = "ID_Date_JutoTaishoMonth";
	/** 遷移パラメータ(充当対象払込期日入力 ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHOYEAR_INPUT = "ID_Date_JutoTaishoYear_Input";
	/** 遷移パラメータ(充当対象払込期日(日) ) */
	public static final String PROPERTY_ID_DATE_JUTOTAISHODAY = "ID_Date_JutoTaishoDay";
	/** 遷移パラメータ(代弁金払込日A ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMI = "ID_Date_DaibenkinHaraikomi";
	/** 遷移パラメータ(代弁金払込日(元号) ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMIGENGOU = "ID_Date_DaibenkinHaraikomiGengou";
	/** 遷移パラメータ(代位金払込日入力 ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMIYEAR_INPUT = "ID_Date_DaibenkinHaraikomiYear_Input";
	/** 遷移パラメータ(代弁金払込日(西暦年) ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMIYEAR = "ID_Date_DaibenkinHaraikomiYear";
	/** 遷移パラメータ(代弁金払込日(月) ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMIMONTH = "ID_Date_DaibenkinHaraikomiMonth";
	/** 遷移パラメータ(代弁金払込日(日) ) */
	public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMIDAY = "ID_Date_DaibenkinHaraikomiDay";
	/** 遷移パラメータ(遅延損害金 ) */
	public static final String PROPERTY_ID_M_CHIENSONGAI = "ID_M_ChienSongai";
	/** 遷移パラメータ(利息 ) */
	public static final String PROPERTY_ID_M_RISOKU = "ID_M_Risoku";
	/** 遷移パラメータ(元金 ) */
	public static final String PROPERTY_ID_M_GANKIN = "ID_M_Gankin";
	/** 遷移パラメータ(計 ) */
	public static final String PROPERTY_ID_M_KEI = "ID_M_Kei";
	/** 遷移パラメータ(仮受金(一般口)からの充当額 ) */
	public static final String PROPERTY_ID_M_KARIUKEIPPANJUTO = "ID_M_KariukeIppanJuto";
	/** 遷移パラメータ(代弁金充当後残元金 ) */
	public static final String PROPERTY_ID_M_ZANGANAFTERDAIBENJUTO = "ID_M_ZanGanAfterDaibenJuto";
	/** 遷移パラメータ(繰上償還手数料 ) */
	public static final String PROPERTY_ID_M_KURISHOCOMMISSION = "ID_M_KurishoCommission";
	/** 遷移パラメータ(送金額 ) */
	public static final String PROPERTY_ID_M_SOKIN = "ID_M_Sokin";
	/** 遷移パラメータ(送金日A ) */
	public static final String PROPERTY_ID_DATE_SOKIN = "ID_Date_Sokin";
	/** 遷移パラメータ(送信日(年号) ) */
	public static final String PROPERTY_ID_DATE_SOKINGENGOU = "ID_Date_SokinGengou";
	/** 遷移パラメータ(送信日(西暦年) ) */
	public static final String PROPERTY_ID_DATE_SOKINYEAR = "ID_Date_SokinYear";
	/** 遷移パラメータ(送信日人力 ) */
	public static final String PROPERTY_ID_DATE_SOKINYEAR_INPUT = "ID_Date_SokinYear_Input";
	/** 遷移パラメータ(送信日(月) ) */
	public static final String PROPERTY_ID_DATE_SOKINMONTH = "ID_Date_SokinMonth";
	/** 遷移パラメータ(送信日(日) ) */
	public static final String PROPERTY_ID_DATE_SOKINDAY = "ID_Date_SokinDay";
	/** 遷移パラメータ(送金日番号A ) */
	public static final String PROPERTY_ID_ID_SOKINBI = "ID_ID_Sokinbi";
	/** 遷移パラメータ(受託者勘定処理年月A ) */
	public static final String PROPERTY_ID_DATE_JTKSHORI = "ID_Date_Jtkshori";
	/** 遷移パラメータ(受託者勘定処理年月入力 ) */
	public static final String PROPERTY_ID_DATE_JTKSHORIYEAR_INPUT = "ID_Date_JtkshoriYear_Input";
	/** 遷移パラメータ(受託者勘定処理年月(元号) ) */
	public static final String PROPERTY_ID_DATE_JTKSHORIGENGOU = "ID_Date_JtkshoriGengou";
	/** 遷移パラメータ(受託者勘定処理年月(年) ) */
	public static final String PROPERTY_ID_DATE_JTKSHORIYEAR = "ID_Date_JtkshoriYear";
	/** 遷移パラメータ(受託者勘定処理年月(月) ) */
	public static final String PROPERTY_ID_DATE_JTKSHORIMONTH = "ID_Date_JtkshoriMonth";
	/** 遷移パラメータ(M_貸付残高 ) */
	public static final String PROPERTY_ID_M_KASHITSUKEZANDAKA = "ID_M_KashitsukeZandaka";
	/** 遷移パラメータ(表示画面のヘッダ項目 ) */
	public static final String PROPERTY_ID_INPUTHEAD = "ID_InputHead";
	/** 遷移パラメータ(債権管理番号 ) */
	public static final String PROPERTY_ID_ID_CREDIT = "ID_ID_Credit";
	/** 遷移パラメータ(請求繰償利息 ) */
	public static final String PROPERTY_ID_M_SEIKURIRISOKU = "ID_M_SeiKuriRisoku";
	/** 遷移パラメータ(請求繰償元金 ) */
	public static final String PROPERTY_ID_M_SEIKURIGANKIN = "ID_M_SeiKuriGankin";
	/** 遷移パラメータ(請求データに登録を行う請求繰償利息 ) */
	public static final String PROPERTY_ID_SEIKYU_M_SEIKURIRISOKU = "ID_Seikyu_M_SeiKuriRisoku";
	/** 遷移パラメータ(請求データに登録を行う請求繰償元金 ) */
	public static final String PROPERTY_ID_SEIKYU_M_SEIKURIGANKIN = "ID_Seikyu_M_SeiKuriGankin";
	/** 遷移パラメータ(M_約定利息 ) */
	public static final String PROPERTY_ID_M_YAKUJORISOKU = "ID_M_YakujoRisoku";
	/** 遷移パラメータ(M_約定元金 ) */
	public static final String PROPERTY_ID_M_YAKUJOGANKIN = "ID_M_YakujoGankin";
	/** 遷移パラメータ(退避貸付金残高（非表示） ) */
	public static final String PROPERTY_ID_KEEP_M_KASHITSUKEZAN = "ID_Keep_M_KashitsukeZan";
	/** 遷移パラメータ(退避約定元金 ) */
	public static final String PROPERTY_ID_KEEP_M_YAKUJOGANKIN = "ID_Keep_M_YakujoGankin";
	/** 遷移パラメータ(退避約定利息 ) */
	public static final String PROPERTY_ID_KEEP_M_YAKUJORISOKU = "ID_Keep_M_YakujoRisoku";
	/** 遷移パラメータ(退避請求繰償利息 ) */
	public static final String PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU = "ID_Keep_Seikyu_M_SeiKuriRisoku";
	/** 遷移パラメータ(退避請求繰償元金 ) */
	public static final String PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN = "ID_Keep_Seikyu_M_SeiKuriGankin";
	/** 遷移パラメータ(取消済みフラグ（非表示） ) */
	public static final String PROPERTY_ID_FLAG_TORIKESHIZUMI = "ID_Flag_Torikeshizumi";
	/** 遷移パラメータ(退避償還期限（非表示） ) */
	public static final String PROPERTY_ID_KEEP_DATE_SHOKANKIGEN = "ID_Keep_Date_ShokanKigen";
	/** 遷移パラメータ(報告時分秒（非表示） ) */
	public static final String PROPERTY_ID_TIME_REPORT = "ID_Time_Report";
	/** 遷移パラメータ(原本番号 ) */
	public static final String PROPERTY_ID_ID_MASTER = "ID_ID_Master";
	/** 遷移パラメータ(電子署名付データ（非表示） ) */
	public static final String PROPERTY_ID_SIGNDATA = "ID_SignData";
	/** 遷移パラメータ(取消用払出・債権管理番号 ) */
	public static final String PROPERTY_ID_INS_ID_CREDIT = "ID_Ins_ID_Credit";
	/** 遷移パラメータ(扱店別稟議データに登録を行う払込前残元金 ) */
	public static final String PROPERTY_ID_M_KASHITSUKEZANDAKA_ARINGI = "ID_M_KashitsukeZandaka_aRingi";
	/** 遷移パラメータ(扱店別稟議データに登録を行う償還期限 ) */
	public static final String PROPERTY_ID_DATE_SHOKANKIGEN_ARINGI = "ID_Date_ShokanKigen_aRingi";
	/** 遷移パラメータ(請求データに登録を行う約定利息 ) */
	public static final String PROPERTY_ID_M_YAKUJORISOKU_SEIKYU = "ID_M_YakujoRisoku_Seikyu";
	/** 遷移パラメータ(請求データに登録を行う約定元金 ) */
	public static final String PROPERTY_ID_M_YAKUJOGANKIN_YAKUJO = "ID_M_YakujoGankin_Yakujo";
	/** 遷移パラメータ(履歴番号（非表示） ) */
	public static final String PROPERTY_ID_ID_HISTORY = "ID_ID_History";
	/** 遷移パラメータ(ステータス（非表示） ) */
	public static final String PROPERTY_ID_STATUS = "ID_Status";
	/** 遷移パラメータ(処理種別 ) */
	public static final String PROPERTY_ID_TYPE_PROCESS = "ID_Type_Process";
	/** 遷移パラメータ(データコード ) */
	public static final String PROPERTY_ID_DATACODE = "ID_DataCode";
	/** 遷移パラメータ(扱店別稟議データの最新データ更新日付 ) */
	public static final String PROPERTY_ID_DATA_LASTUPDATE = "ID_Data_LastUpDate";
	/** 遷移パラメータ(ユーザID（非表示） ) */
	public static final String PROPERTY_ID_USER_ID = "ID_User_ID";
	/** 遷移パラメータ(伝送番号（非表示） ) */
	public static final String PROPERTY_ID_ID_DENSO = "ID_ID_Denso";
	/** 遷移パラメータ(エラー番号（非表示） ) */
	public static final String PROPERTY_ID_CODE_ERROR = "ID_Code_Error";
	/** 遷移パラメータ(エラーメッセージ（非表示） ) */
	public static final String PROPERTY_ID_ERRORMESSAGE = "ID_ErrorMessage";
	/** 遷移パラメータ(顧客コード（非表示） ) */
	public static final String PROPERTY_ID_CODE_CUSTOMER = "ID_Code_Customer";
	/** 遷移パラメータ(方式(非表示） ) */
	public static final String PROPERTY_ID_KUBUN_HOSHIKI = "ID_Kubun_Hoshiki";
	/** 遷移パラメータ(資金(非表示） ) */
	public static final String PROPERTY_ID_KUBUN_SHIKIN = "ID_Kubun_Shikin";
	/** 遷移パラメータ(償還期限年月(非表示) ) */
	public static final String PROPERTY_ID_DATE_SHOKANKIGEN = "ID_Date_ShokanKigen";
	/** 遷移パラメータ(退避履歴番号 ) */
	public static final String PROPERTY_ID_KEEP_ID_HISTORY = "ID_Keep_ID_History";
	/** 遷移パラメータ(退避実行済みフラグ ) */
	public static final String PROPERTY_ID_KEEP_FLAG_KJ = "ID_Keep_Flag_Kj";
	/** 遷移パラメータ(扱店別稟議データより取得した実行済みフラグ ) */
	public static final String PROPERTY_ID_ARINGI_FLAG_KJ = "ID_aRingi_Flag_Kj";
	/** 遷移パラメータ(扱店別稟議データより取得した償還期限年月 ) */
	public static final String PROPERTY_ID_ARINGI_DATE_SHOKANKIGEN = "ID_aRingi_Date_ShokanKigen";
	/** 遷移パラメータ(報告書種別（値）(非表示) ) */
	public static final String PROPERTY_DATACODE = "dataCode";
	/** 遷移パラメータ(処理モード ) */
	public static final String PROPERTY_PROCESS_MODE = "process_Mode";
	/** 遷移パラメータ(モードタイプ ) */
	public static final String PROPERTY_MODETYPE = "modeType";
	/** 更正（赤）データの請求データ「約定元金」 */
	public static final String PROPERTY_ID_M_YAKUJOGANKIN_SEIKYU_RED = "ID_M_YakujoGankin_Seikyu_Red";
	/** 更正（赤）データの請求データ「約定利息」 */
	public static final String PROPERTY_ID_M_YAKUJORISOKU_SEIKYU_RED = "ID_M_YakujoRisoku_Seikyu_Red";
	/** 更正（赤）データの請求データ「請求繰償元金」 */
	public static final String PROPERTY_ID_M_SEIKURIGANKIN_SEIKYU_RED = "ID_M_SeiKuriGankin_Seikyu_Red";
	/** 更正（赤）データの請求データ「請求繰償利息」 */
	public static final String PROPERTY_ID_M_SEIKURIRISOKU_SEIKYU_RED = "ID_M_SeiKuriRisoku_Seikyu_Red";

	/** モードタイプ：生成・作成 */
	public static final String MODE_TYPE_CREATE = "1";
	/** モードタイプ：更新・変更 */
	public static final String MODE_TYPE_UPDATE = "2";
	/** モードタイプ：複写 */
	public static final String MODE_TYPE_COPY = "3";

	/** 処理モード：処理完了：取消 */
	public static final String PROCESS_MODE_1 = "1";
	/** 処理モード：処理完了：修正 */
	public static final String PROCESS_MODE_2 = "2";
	/** 処理モード：処理完了以外：取消 */
	public static final String PROCESS_MODE_3 = "3";
	/** 処理モード：処理完了以外：修正 */
	public static final String PROCESS_MODE_4 = "4";
	/** 処理モード：処理完了以外：更正(赤)取消 */
	public static final String PROCESS_MODE_5 = "5";

	/** 画面．赤データ入力領域タイトル「赤」を表示 */
	public static final String RED_VISIBLE = "Visible";
	/** 画面．データ入力領域タイトル：取消内容 */
	public static final String STR_CANCEL = "取消内容";
	/** 画面．データ入力領域タイトル：更正 */
	public static final String STR_MOD = "更正";
	/** 画面．データ入力領域タイトル：修正内容 */
	public static final String STR_UPD = "修正内容 ";
	/** 画面．データ入力領域タイトル：黒 */
	public static final String STR_BLACK = " 黒";

	/** 画面．赤データ入力領域タイトル ラベル名 */
	public static final String LBL_HEAD_RED2_NAME = "lblID_Head_Red";
	/** 画面．黒データ入力領域タイトル ラベル名 */
	public static final String LBL_HEAD_NAME = "lblID_Head";
	/** 赤データ入力領域 */
	public static final String ID_PNL_RED = "pnl_Red";
	/** 黒データ入力領域 */
	public static final String ID_PNL_MOD = "pnl_Mod";
	/** データ入力領域 */
	public static final String ID_PNL = "pnl";
	/** 画面の送信ボタン名 */
	public static final String ITEM_ID_BTNUPDATE2 = "btnUpdate2";

	/** 文字：0 */
	public static final String STR_ZERO = "0";
	/** 文字：1 */
	public static final String STR_ONE = "1";

	/** 2桁 */
	public static final int LENGTH_2 = 2;
	/** 6桁 */
	public static final int LENGTH_6 = 6;
	/** 8桁 */
	public static final int LENGTH_8 = 8;

// [DEL] Ver 2.0.0 - START
//	/** 平成の先頭１文字目 */
//	public static final String NENGOU_HEISEI = "H";
// [DEL] Ver 2.0.0 - END

	/** エンティティパラメータ１取得用のマップキー */
	public static final String ENTITY_RED = "Red";
	/** エンティティパラメータ２取得用のマップキー */
	public static final String ENTITY_BLACK = "Black";

	/** 入力チェック繰り返し回数 */
	public static final int CHECK_REPEAT = 2;

	/** チェック終了フラグ：チェック終了でない */
	public static final boolean CHECK_NOT_END = false;
	/** チェック終了フラグ：チェック終了 */
	public static final boolean CHECK_END = true;

	/** 修正データチェックフラグ：チェックしない */
	public static final boolean MOD_DATA_NO_CHECK = false;
	/** 修正データチェックフラグ：チェックする */
	public static final boolean MOD_DATA_CHECK = true;

	/** 最新データ更新日付フォーマット形式 */
	public static final String STR_DATE_LAST_UPDATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

}
