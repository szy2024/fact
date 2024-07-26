package jp.go.jfc.partnernet.md009.common;

public class Md009Constants {

    /** 年を抜き出す開始位置 */
    public static final int DATE_PATTERN_YYYYMMDD_YEAR_FROM = 0;
    /** 年を抜き出す終了位置 */
    public static final int DATE_PATTERN_YYYYMMDD_YEAR_TO = 4;
    /** 月を抜き出す開始位置 */
    public static final int DATE_PATTERN_YYYYMMDD_MONTH_FROM = 4;
    /** 月を抜き出す終了位置 */
    public static final int DATE_PATTERN_YYYYMMDD_MONTH_TO = 6;

    /** 年号：昭和 */
    public static final String GENGO_SHOWA = "S";
    /** 年：６４年 */
    public static final String YEAR_64 = "64";

    /** パネル内のヘッダー表示切替 更正 */
    public static final String PANEL_HEADER_KOUSEI = "更正";
    /** パネル内のヘッダー表示切替 更正黒 */
    public static final String PANEL_HEADER_KOUSEI_BLACK = "更正 黒";
    /** パネル内のヘッダー表示切替 取消内容 */
    public static final String PANEL_HEADER_TORIKESHI = "取消内容";
    /** パネル内のヘッダー表示切替 修正内容 */
    public static final String PANEL_HEADER_SHUSEI = "修正内容";
    /** 戻りボタンの案内文（更正赤取消以外） */
    public static final String FORM_NAME_NAVI_MESSAGE_NOMAL = "留置期間利息・代弁遅延損害金受入充当報告書の取消・修正の入力画面へ戻る場合には<br>「戻る」ボタンを押してください。";
    /** 戻りボタンの案内文（更正赤取消） */
    public static final String FORM_NAME_NAVI_MESSAGE_DEL_CANCEL = "取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。";
    /** 処理モード */
    public static final String FORM_NAME_PROCCESNAME = "processMode";
    /** 赤データ入力領域 */
    public static final String FORM_NAME_REDAREA = "redArea";
    /** 黒データ入力領域 */
    public static final String FORM_NAME_BLACKAREA = "blackArea";
    /** 更正 赤 */
    public static final String FORM_HEAD_RED = "lblID_Head_Red2";

    /** 最新データ更新日付フォーマット形式 */
    public static final String STR_DATE_LAST_UPDATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 留置期間利息・代弁遅延損害金受入充当報告書取消修正(入力画面)：初期表示 */
    public static final String EVENT_ID_MD009_01INIT = "Md009_01Init";
    /** 留置期間利息・代弁遅延損害金受入充当報告書取消修正(入力画面)：戻る */
    public static final String EVENT_ID_MD009_01RETURN = "Md009_01Return";
    /** 留置期間利息・代弁遅延損害金受入充当報告書取消修正(入力結果画面)：初期表示 */
    public static final String EVENT_ID_MD009_02INIT = "Md009_02Init";
    /** 留置期間利息・代弁遅延損害金受入充当報告書取消修正(登録結果画面)：初期表示 */
    public static final String EVENT_ID_MD009_03INIT = "Md009_03Init";
    /** 報告書検索結果画面：初期表示 */
    public static final String EVENT_ID_MD000_02INIT = "Md000_02Init";
    /** 報告書検索結果画面：戻る */
    public static final String EVENT_ID_MD000_02RETURN = "Md000_02Return";

    /** メッセージ領域 */
    public static final String PROPERTY_INFO_AREA = "infoArea";
    /** 編集領域 */
    public static final String PROPERTY_EDIT_AREA = "editArea";
    /** 送信ボタン */
    public static final String PROPERTY_SEND_BTN = "btnID_Send";
    /** 登録ボタン */
    public static final String PROPERTY_UPDATE_BTN = "btnUpdate";

    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_ID_REPORT_DATE_REPORT = "ID_Date_Report";
    /** 遷移パラメータ(報告時分秒) */
    public static final String PROPERTY_ID_REPORT_TIME_REPORT = "ID_Time_Report";
    /** 遷移パラメータ(報告書種別(値)) */
    public static final String PROPERTY_ID_BIZJOINITEM_DATACODE = "ID_BizJoinItem_DataCode";
    /** 遷移パラメータ(ステータス) */
    public static final String PROPERTY_ID_STATUS = "ID_Status";
    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(履歴番号) */
    public static final String PROPERTY_ID_HISTORY = "ID_History";
    /** 遷移パラメータ(処理種別) */
    public static final String PROPERTY_ID_TYPE_PROCESS = "ID_Type_Process";
    /** 遷移パラメータ(退避履歴番号) */
    public static final String PROPERTY_ID_KEEP_HISTORY = "ID_Keep_ID_History";
    /** 遷移パラメータ(最新更新日時) */
    public static final String PROPERTY_ID_DATA_LASTUPDATE = "ID_Data_LastUpDate";
    /** 遷移パラメータ(処理モード) */
    public static final String PROPERTY_ID_PROCESS_MODE = "ProcessMode";

    /** 遷移パラメータ(扱店名) */
    public static final String PROPERTY_ID_NAME_ORGANIZATION_RED = "ID_Name_Organization_Red";
    /** 遷移パラメータ(公庫支店) */
    public static final String PROPERTY_ID_CODE_SHOKANHONSHITEN_RED = "ID_Code_Shokanhonshiten_Red";
    /** 遷移パラメータ(扱店) */
    public static final String PROPERTY_ID_CODE_ORGANIZATION_RED = "ID_Code_Organization_Red";
    /** 遷移パラメータ(店舗) */
    public static final String PROPERTY_ID_CODE_TENPO_RED = "ID_Code_Tenpo_Red";
    /** 遷移パラメータ(入金日) */
    public static final String PROPERTY_ID_DATE_NYUKIN_RED = "ID_Date_Nyukin_Red";
    /** 遷移パラメータ(留置期間利息) */
    public static final String PROPERTY_ID_M_RYUCHIKIKANRISOKU_RED = "ID_M_Ryuchikikanrisoku_Red";
    /** 遷移パラメータ(代弁遅延損害金) */
    public static final String PROPERTY_ID_M_DAIBENCHIENSONGAI_RED = "ID_M_Daibenchiensongai_Red";
    /** 遷移パラメータ(送金額) */
    public static final String PROPERTY_ID_M_SOKIN_RED = "ID_M_Sokin_Red";
    /** 遷移パラメータ(受託者勘定処理年月) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_RED = "ID_Date_Jtkshori_Red";
    /** 遷移パラメータ(送金年月日) */
    public static final String PROPERTY_ID_DATE_SOKIN_RED = "ID_Date_Sokin_Red";
    /** 遷移パラメータ(送金日番号) */
    public static final String PROPERTY_ID_CODE_SOKIN_RED = "ID_Code_Sokin_Red";
    /** 遷移パラメータ(受託者勘定処理年月（元号）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_GENGOU_RED = "ID_Date_Jtkshori_Gengou_Red";
    /** 遷移パラメータ(受託者勘定処理年月（年）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT_RED = "ID_Date_Jtkshori_Year_Input_Red";
    /** 遷移パラメータ(受託者勘定処理年月（月）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_MONTH_RED = "ID_Date_Jtkshori_Month_Red";
    /** 遷移パラメータ(扱店名（修正）) */
    public static final String PROPERTY_ID_NAME_ORGANIZATION = "ID_Name_Organization";
    /** 遷移パラメータ(公庫支店（修正）) */
    public static final String PROPERTY_ID_CODE_SHOKANHONSHITEN = "ID_Code_Shokanhonshiten";
    /** 遷移パラメータ(扱店（修正）) */
    public static final String PROPERTY_ID_CODE_ORGANIZATION = "ID_Code_Organization";
    /** 遷移パラメータ(店舗（修正）) */
    public static final String PROPERTY_ID_CODE_TENPO = "ID_Code_Tenpo";
    /** 遷移パラメータ(入金日（元号）（修正）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_GENGOU = "ID_Date_Nyukin_Gengou";
    /** 遷移パラメータ(入金日（年）（修正）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_YEAR_INPUT = "ID_Date_Nyukin_Year_Input";
    /** 遷移パラメータ(入金日（月）（修正）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_MONTH = "ID_Date_Nyukin_Month";
    /** 遷移パラメータ(入金日（日）（修正）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_DAY = "ID_Date_Nyukin_Day";
    /** 遷移パラメータ(留置期間利息（修正）) */
    public static final String PROPERTY_ID_M_RYUCHIKIKANRISOKU = "ID_M_Ryuchikikanrisoku";
    /** 遷移パラメータ(代弁遅延損害金（修正）) */
    public static final String PROPERTY_ID_M_DAIBENCHIENSONGAI = "ID_M_Daibenchiensongai";
    /** 遷移パラメータ(送金額（修正）) */
    public static final String PROPERTY_ID_M_SOKIN = "ID_M_Sokin";
    /** 遷移パラメータ(受託者勘定処理年月（修正）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI = "ID_Date_Jtkshori";
    /** 遷移パラメータ(送金年月日（元号）（修正）) */
    public static final String PROPERTY_ID_DATE_SOKIN_GENGOU = "ID_Date_Sokin_Gengou";
    /** 遷移パラメータ(送金年月日（年）（修正）) */
    public static final String PROPERTY_ID_DATE_SOKIN_YEAR_INPUT = "ID_Date_Sokin_Year_Input";
    /** 遷移パラメータ(送金年月日（月）（修正）) */
    public static final String PROPERTY_ID_DATE_SOKIN_MONTH = "ID_Date_Sokin_Month";
    /** 遷移パラメータ(送金年月日（日）（修正）) */
    public static final String PROPERTY_ID_DATE_SOKIN_DAY = "ID_Date_Sokin_Day";
    /** 遷移パラメータ(送金日番号（修正）) */
    public static final String PROPERTY_ID_CODE_SOKIN = "ID_Code_Sokin";
    /** 遷移パラメータ(受託者勘定処理年月（元号）（修正）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_GENGOU = "ID_Date_Jtkshori_Gengou";
    /** 遷移パラメータ(受託者勘定処理年月（年）（修正）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT = "ID_Date_Jtkshori_Year_Input";
    /** 遷移パラメータ(受託者勘定処理年月（月）（修正）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_MONTH = "ID_Date_Jtkshori_Month";

}
