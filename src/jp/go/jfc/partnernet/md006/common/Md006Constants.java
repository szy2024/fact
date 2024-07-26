package jp.go.jfc.partnernet.md006.common;

public class Md006Constants {

    /** 立替金受入・充当報告書取消・修正（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD006_01INIT = "Md006_01Init";
    /** 立替金受入・充当報告書取消・修正（入力結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD006_02INIT = "Md006_02Init";
    /** 立替金受入・充当報告書取消・修正（登録結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD006_03INIT = "Md006_03Init";

    /** メッセージ領域 */
    public static final String PROPERTY_INFO_AREA = "infoArea";
    /** 編集領域 */
    public static final String PROPERTY_EDIT_AREA = "editArea";
    /** 送信ボタン */
    public static final String PROPERTY_SEND_BTN = "btnUpdate2";
    /** 登録ボタン */
    public static final String PROPERTY_UPDATE_BTN = "btnUpdate2";
    /** 赤データ入力領域 */
    public static final String FORM_NAME_REDAREA = "formRedArea";
    /** 黒データ入力領域 */
    public static final String FORM_NAME_BLACKAREA = "formBlackArea";

    /** 入力確認画面_メッセージ（処理完了以外更正(赤)取消） */
    public static final String LBLBACK_DELCANCEL = "取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。";
    /** 入力確認画面_メッセージ（処理完了以外更正(赤)取消以外） */
    public static final String LBLBACK_NORMAL = "立替金受入・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。";

    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_ID_REPORT_DATE_REPORT = "ID_Date_Report";
    /** 遷移パラメータ(報告時分秒) */
    public static final String PROPERTY_ID_REPORT_TIME_REPORT = "ID_Time_Report";
    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(ステータス) */
    public static final String PROPERTY_ID_REPORT_STATUS = "ID_Status";
    /** 遷移パラメータ(報告書種別(値)) */
    public static final String PROPERTY_ID_REPORT_BIZJOINITEM_DATACODE = "ID_BizJoinItem_DataCode";
    /** 遷移パラメータ(処理モード) */
    public static final String PROPERTY_ID_REPORT_PROCESS_MODE = "ProcessMode";

    /** 遷移パラメータ(処理モード") */
    public static final String PROPERTY_PROCESSMODE = "ProcessMode";
    /** 遷移パラメータ(報告時分秒) */
    public static final String PROPERTY_TIME_REPORT = "ID_Time_Report";
    /** 遷移パラメータ(報告書種別（値）) */
    public static final String PROPERTY_DATACODE = "ID_DataCode";
    /** 遷移パラメータ(ステータス) */
    public static final String PROPERTY_STATUS = "ID_Status";
    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(履歴番号) */
    public static final String PROPERTY_ID_HISTORY = "ID_ID_History";
    /** 遷移パラメータ(処理種別) */
    public static final String PROPERTY_TYPE_PROCESS = "ID_Type_Process";
    /** 遷移パラメータ(債権管理番号) */
    public static final String PROPERTY_ID_CREDIT = "ID_ID_Credit";
    /** 遷移パラメータ(債権管理番号) */
    public static final String PROPERTY_CODE_HONSHITEN = "ID_Code_HonShiten";

    /** 遷移パラメータ(仮受仮払番号) */
    public static final String PROPERTY_ID_KARIBARAI = "ID_ID_Karibarai";
    /** 遷移パラメータ(仮受仮払年月日 */
    public static final String PROPERTY_DATE_KARIBARAI = "ID_Date_Karibarai";
    /** 遷移パラメータ(最新更新日時 */
    public static final String PROPERTY_DATA_LASTUPDATE = "ID_Data_LastUpDate";
    /** 遷移パラメータ(退避受入後立替金残高（修正）) */
    public static final String PROPERTY_KEEP_M_TATEKAEZANAFTERUKEIRE = "ID_Keep_M_TatekaeZanAfterUkeire";
    /** 遷移パラメータ(仮受仮払精算後残高) */
    public static final String PROPERTY_M_KARIBARAIZANAFTERSEISAN = "ID_M_KaribaraiZanAfterSeisan";

    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_DATE_REPORT = "lblID_Date_Report";
    /** 遷移パラメータ(顧客名) */
    public static final String PROPERTY_NAME_CUSTOMER_RED = "lblID_Name_Customer_Red";
    /** 遷移パラメータ(扱店名) */
    public static final String PROPERTY_NAME_ORGANIZATION_RED = "lblID_Name_Organization_Red";
    /** 遷移パラメータ(公庫支店) */
    public static final String PROPERTY_CODE_KOUKOSHITEN_RED = "lblID_Code_KoukoShiten_Red";
    /** 遷移パラメータ(扱店) */
    public static final String PROPERTY_CODE_ORGANIZATION_RED = "lblID_Code_Organization_Red";
    /** 遷移パラメータ(店舗) */
    public static final String PROPERTY_CODE_TENPO_RED = "lblID_Code_Tenpo_Red";
    /** 遷移パラメータ(年度) */
    public static final String PROPERTY_YEAR_RED = "lblID_Year_Red";
    /** 遷移パラメータ(方式資金) */
    public static final String PROPERTY_CODE_HOSHIKISHIKIN_RED = "lblID_Kubun_HoshikiShikin_Red";
    /** 遷移パラメータ(番号) */
    public static final String PROPERTY_ID_RINGI_RED = "lblID_ID_Ringi_Red";
    /** 遷移パラメータ(枝番) */
    public static final String PROPERTY_ID_RINGIBRANCH_RED = "lblID_ID_RingiBranch_Red";
    /** 遷移パラメータ(入金日) */
    public static final String PROPERTY_DATE_NYUKIN_RED = "lblID_Date_Nyukin_Red";
    /** 遷移パラメータ(立替金利息(円)) */
    public static final String PROPERTY_M_TATEKAERISOKU_RED = "lblID_M_TatekaeRisoku_Red";
    /** 遷移パラメータ(立替金(円)) */
    public static final String PROPERTY_M_TATEKAE_RED = "lblID_M_Tatekae_Red";
    /** 遷移パラメータ(仮受金(一般口)からの充当額(円)) */
    public static final String PROPERTY_M_KARIUKEIPPANJUTO_RED = "lblID_M_KariukeIppanJuto_Red";
    /** 遷移パラメータ(立替金の種類) */
    public static final String PROPERTY_CODE_TATEKAEKINSHURUI_RED = "lblID_Code_TatekaekinShurui_Red";
    /** 遷移パラメータ(公庫立替日) */
    public static final String PROPERTY_DATE_KOUKOTATEKAE_RED = "lblID_Date_KoukoTatekae_Red";
    /** 遷移パラメータ(計(円)) */
    public static final String PROPERTY_M_KEI_RED = "lblID_M_Kei_Red";
    /** 遷移パラメータ(送金額(円)) */
    public static final String PROPERTY_M_SOKIN_RED = "lblID_M_Sokin_Red";
    /** 遷移パラメータ(受入後立替金残高(円)) */
    public static final String PROPERTY_M_TATEKAEZANAFTERUKEIRE_RED = "lblID_M_TatekaeZanAfterUkeire_Red";

    /** 遷移パラメータ(受託者勘定処理年月) */
    public static final String PROPERTY_DATE_JTKSHORI_RED = "lblID_Date_Jtkshori_Red";
    /** 遷移パラメータ(送金日) */
    public static final String PROPERTY_DATE_SOKIN_RED = "lblID_Date_Sokin_Red";
    /** 遷移パラメータ(送金日番号) */
    public static final String PROPERTY_ID_SOKINBI_RED = "lblID_ID_Sokinbi_Red";
    /** 遷移パラメータ(受託者勘定処理年月(元号)) */
    public static final String PROPERTY_DATE_JTKSHORI_GENGOU_RED = "ID_Date_Jtkshori_Gengou_Red";
    /** 遷移パラメータ(受託者勘定処理年月(年)) */
    public static final String PROPERTY_DATE_JTKSHORI_YEAR_RED = "ID_Date_Jtkshori_Year_Red";
    /** 遷移パラメータ(受託者勘定処理年月(月)) */
    public static final String PROPERTY_DATE_JTKSHORI_MONTH_RED = "ID_Date_Jtkshori_Month_Red";

    /** 遷移パラメータ(顧客名（修正）) */
    public static final String PROPERTY_NAME_CUSTOMER = "lblID_Name_Customer";
    /** 遷移パラメータ(扱店名（修正）) */
    public static final String PROPERTY_NAME_ORGANIZATION = "lblID_Name_Organization";
    /** 遷移パラメータ(公庫支店（修正）) */
    public static final String PROPERTY_CODE_KOUKOSHITEN = "lblID_Code_KoukoShiten";
    /** 遷移パラメータ(扱店（修正）) */
    public static final String PROPERTY_CODE_ORGANIZATION = "lblID_Code_Organization";
    /** 遷移パラメータ(店舗（修正）) */
    public static final String PROPERTY_CODE_TENPO = "lblID_Code_Tenpo";
    /** 遷移パラメータ(年度（修正）) */
    public static final String PROPERTY_YEAR = "lblID_Year";
    /** 遷移パラメータ(方式資金（修正）) */
    public static final String PROPERTY_CODE_HOSHIKISHIKIN = "lblID_Kubun_HoshikiShikin";
    /** 遷移パラメータ(番号（修正）) */
    public static final String PROPERTY_ID_RINGI = "lblID_ID_Ringi";
    /** 遷移パラメータ(枝番（修正）) */
    public static final String PROPERTY_ID_RINGIBRANCH = "lblID_ID_RingiBranch";
    /** 遷移パラメータ(入金日(元号)（修正）) */
    public static final String PROPERTY_DATE_NYUKIN_GENGOU = "ID_Date_Nyukin_Gengou";
    /** 遷移パラメータ(入金日(年)（修正）) */
    public static final String PROPERTY_DATE_NYUKIN_YEAR = "ID_Date_Nyukin_Year";
    /** 遷移パラメータ(入金日(月)（修正）) */
    public static final String PROPERTY_DATE_NYUKIN_MONTH = "ID_Date_Nyukin_Month";
    /** 遷移パラメータ(入金日(日)（修正）) */
    public static final String PROPERTY_DATE_NYUKIN_DAY = "ID_Date_Nyukin_Day";
    /** 遷移パラメータ(立替金利息(円)（修正）) */
    public static final String PROPERTY_M_TATEKAERISOKU = "lblID_M_TatekaeRisoku";
    /** 遷移パラメータ(立替金(円)（修正）) */
    public static final String PROPERTY_M_TATEKAE = "lblID_M_Tatekae";
    /** 遷移パラメータ(仮受金(一般口)からの充当額(円)（修正）) */
    public static final String PROPERTY_M_KARIUKEIPPANJUTO = "lblID_M_KariukeIppanJuto";
    /** 遷移パラメータ(立替金の種類（修正）) */
    public static final String PROPERTY_CODE_TATEKAEKINSHURUI = "lblID_Code_TatekaekinShurui";
    /** 遷移パラメータ(公庫立替日（修正）) */
    public static final String PROPERTY_DATE_KOUKOTATEKAE = "lblID_Date_KoukoTatekae";
    /** 遷移パラメータ(計(円)（修正）) */
    public static final String PROPERTY_M_KEI = "lblID_M_Kei";
    /** 遷移パラメータ(送金額(円)（修正）) */
    public static final String PROPERTY_M_SOKIN = "lblID_M_Sokin";
    /** 遷移パラメータ(受入後立替金残高(円)（修正）) */
    public static final String PROPERTY_M_TATEKAEZANAFTERUKEIRE = "lblID_M_TatekaeZanAfterUkeire";
    /** 遷移パラメータ(受託者勘定処理年月（修正）) */
    public static final String PROPERTY_DATE_JTKSHORI = "lblID_Date_Jtkshori";
    /** 遷移パラメータ(送金日(元号)（修正）) */
    public static final String PROPERTY_DATE_SOKIN_GENGOU = "ID_Date_Sokin_Gengou";
    /** 遷移パラメータ(送金日(年)（修正）) */
    public static final String PROPERTY_DATE_SOKIN_YEAR = "ID_Date_Sokin_Year";
    /** 遷移パラメータ(送金日(月)（修正）) */
    public static final String PROPERTY_DATE_SOKIN_MONTH = "ID_Date_Sokin_Month";
    /** 遷移パラメータ(送金日(日)（修正）) */
    public static final String PROPERTY_DATE_SOKIN_DAY = "ID_Date_Sokin_Day";
    /** 遷移パラメータ(送金日番号（修正）) */
    public static final String PROPERTY_ID_SOKINBI = "lblID_ID_Sokinbi";
    /** 遷移パラメータ(受託者勘定処理年月(元号)（修正）) */
    public static final String PROPERTY_DATE_JTKSHORI_GENGOU = "ID_Date_Jtkshori_Gengou";
    /** 遷移パラメータ(受託者勘定処理年月(年)（修正）) */
    public static final String PROPERTY_DATE_JTKSHORI_YEAR = "ID_Date_Jtkshori_Year";
    /** 遷移パラメータ(受託者勘定処理年月(月)（修正）) */
    public static final String PROPERTY_DATE_JTKSHORI_MONTH = "ID_Date_Jtkshori_Month";

}
