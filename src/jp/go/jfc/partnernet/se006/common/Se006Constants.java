//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se006Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2017/10/06 | 百々　諒馬            | 新規作成
//==================================================================================================

package jp.go.jfc.partnernet.se006.common;

/**
 * <pre>
 * このクラスはSe006用定数クラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
public class Se006Constants {

    /** 貸付実行報告書データコード */
    public static final String DATACODE_90257010 = "90257010";
    public static final String DATACODE_90257011 = "90257011";
    /** 貸付受入金払出・充当報告書データコード */
    public static final String DATACODE_90257020 = "90257020";
    public static final String DATACODE_90257021 = "90257021";
    /** 元利金受入充当報告書データコード */
    public static final String DATACODE_90257030 = "90257030";
    public static final String DATACODE_90257031 = "90257031";
    public static final String DATACODE_90257040 = "90257040";
    public static final String DATACODE_90257041 = "90257041";
    /** 繰上償還報告書データコード */
    public static final String DATACODE_90257050 = "90257050";
    public static final String DATACODE_90257051 = "90257051";
    public static final String DATACODE_90257060 = "90257060";
    public static final String DATACODE_90257061 = "90257061";
    public static final String DATACODE_90257100 = "90257100";
    public static final String DATACODE_90257101 = "90257101";
    /** 立替金受入充当報告書データコード */
    public static final String DATACODE_90257090 = "90257090";
    public static final String DATACODE_90257091 = "90257091";
    /** 代位弁済金払込充当報告書データコード */
    public static final String DATACODE_90257070 = "90257070";
    public static final String DATACODE_90257071 = "90257071";
    /** 仮受金（一般口）受入報告書データコード */
    public static final String DATACODE_90257110 = "90257110";
    public static final String DATACODE_90257111 = "90257111";
    /** 留置期間利息・代弁遅延損害金受入報告書データコード */
    public static final String DATACODE_90257120 = "90257120";
    public static final String DATACODE_90257121 = "90257121";

    /** 報告書履歴検索画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_01RETURN = "Se006_01Return";
    /** 報告書履歴検索結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_02INIT = "Se006_02Init";
    /** 報告書履歴検索結果画面戻り表示コントローラ名 */
    public static final String EVENT_ID_SE006_02RETURN = "Se006_02Return";
    /** 報告書内容照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_04INIT = "Se006_04Init";
    /** 貸付実行報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_05INIT = "Se006_05Init";
    /** 貸付受入金払出・充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_06INIT = "Se006_06Init";
    /** 元利金受入・充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_07INIT = "Se006_07Init";
    /** 繰上償還受入・充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_08INIT = "Se006_08Init";
    /** 代位弁済金払込・充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_09INIT = "Se006_09Init";
    /** 立替金受入・充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_10INIT = "Se006_10Init";
    /** 仮受金（一般口）受入報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_12INIT = "Se006_12Init";
    /** 留置期間利息・代弁遅延損害金受入充当報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_13INIT = "Se006_13Init";
    /** 資金交付依頼書（月間）報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_14INIT = "Se006_14Init";
    /** 資金交付依頼書（週間）報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_15INIT = "Se006_15Init";
    /** 包括委任状等の交付依頼報告書照会結果画面初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_16INIT = "Se006_16Init";
    /** （根）抵当権抹消に係る報告書照会結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_SE006_17INIT = "Se006_17Init";

    /** 検索条件_報告書種別 */
    public static final String PROPERTY_SEARCH_DATACODE = "search_DataCode";
    /** 検索条件_実行・回収関係報告書詳細 */
    public static final String PROPERTY_SEARCH_DATACODE_DETAIL = "search_DataCode_Detail";
    /** 検索開始年月日（年） */
    public static final String PROPERTY_SEARCH_START_YEAR = "search_Start_Year";
    /** 検索開始年月日（月） */
    public static final String PROPERTY_SEARCH_START_MONTH = "search_Start_Month";
    /** 検索開始年月日（日） */
    public static final String PROPERTY_SEARCH_START_DATE = "search_Start_Date";
    /** 検索終了年月日（年） */
    public static final String PROPERTY_SEARCH_END_YEAR = "search_End_Year";
    /** 検索終了年月日（月） */
    public static final String PROPERTY_SEARCH_END_MONTH = "search_End_Month";
    /** 検索終了年月日（日） */
    public static final String PROPERTY_SEARCH_END_DATE = "search_End_Date";
    /** 検索条件_支店 */
    public static final String PROPERTY_SEARCH_SHITEN = "search_Shiten";
    /** 検索条件_扱店コード */
    public static final String PROPERTY_SEARCH_CODE_ORGANIZATION = "search_Code_Organization";
    /** 検索条件_融資番号(扱店) */
    public static final String PROPERTY_SEARCH_YN_CODE_ORGANIZATION = "search_YN_Code_Organization";
    /** 検索条件_融資番号（店舗） */
    public static final String PROPERTY_SEARCH_YN_CODE_TENPO = "search_YN_Code_Tenpo";
    /** 検索条件_融資番号（年度） */
    public static final String PROPERTY_SEARCH_YN_YEAR = "search_YN_Year";
    /** 検索条件_融資番号（方式資金） */
    public static final String PROPERTY_SEARCH_YN_KUBUN_HOSHIKISHIKIN = "search_YN_Kubun_HoshikiShikin";
    /** 検索条件_融資番号（番号） */
    public static final String PROPERTY_SEARCH_YN_RINGI = "search_YN_Ringi";
    /** 検索条件_融資番号（枝番） */
    public static final String PROPERTY_SEARCH_YN_RINGIBRANCH = "search_YN_RingiBranch";
    /** 報告書番号 */
    public static final String PROPERTY_ID_REPORT = "ID_ID_Report";
    /** 履歴番号 */
    public static final String PROPERTY_ID_HISTORY = "ID_ID_History";

    /** 扱店名 */
    public static final String PROPERTY_NAME_ORGANIZATION = "lblID_Name_Organization";
    /** 報告書種別 */
    public static final String PROPERTY_RYAKUSYOUNAME_REPORT = "lblID_RyakusyouName_Report";

    /** 取消フラグON */
    public static final String TORIKESHI_FLG_ON = "1";
    /** 取消フラグOFF */
    public static final String TORIKESHI_FLG_OFF = "0";

    /** 日付データ形式 年 */
    public static final int DATE_FORMAT_YEAR = 1;
    /** 日付データ形式 年月 */
    public static final int DATE_FORMAT_YEAR_MONTH = 2;
    /** 日付データ形式 年月日 */
    public static final int DATE_FORMAT_YEAR_MONTH_DAY = 3;
    /** 日付データ形式 月日 */
    public static final int DATE_FORMAT_MONTH_DAY = 4;
    /** 年 桁数 */
    public static final int YEAR_LENGTH = 4;
    /** 年月 桁数 */
    public static final int YEAR_MONTH_LENGTH = 6;
    /** 年月日 桁数 */
    public static final int YEAR_MONTH_DAY_LENGTH = 8;
    /** 月日 桁数 */
    public static final int MONTH_DAY_LENGTH = 4;
    /** 年／年月／年月日用 年 開始インデックス */
    public static final int DATE1_YEAR_BEGIN_INDEX = 0;
    /** 年／年月／年月日用 年 終了インデックス */
    public static final int DATE1_YEAR_END_INDEX = 4;
    /** 年／年月／年月日用 月 開始インデックス */
    public static final int DATE1_MONTH_BEGIN_INDEX = 4;
    /** 年／年月／年月日用 月 終了インデックス */
    public static final int DATE1_MONTH_END_INDEX = 6;
    /** 年／年月／年月日用 日 開始インデックス */
    public static final int DATE1_DAY_BEGIN_INDEX = 6;
    /** 年／年月／年月日用 日 終了インデックス */
    public static final int DATE1_DAY_END_INDEX = 8;
    /** 月日用 月 開始インデックス */
    public static final int DATE2_MONTH_BEGIN_INDEX = 0;
    /** 月日用 月 終了インデックス */
    public static final int DATE2_MONTH_END_INDEX = 2;
    /** 月日用 日 開始インデックス */
    public static final int DATE2_DAY_BEGIN_INDEX = 2;
    /** 月日用 日 終了インデックス */
    public static final int DATE2_DAY_END_INDEX = 4;
    /** 日付区切り文字 */
    public static final String DATE_SEPARATOR = ".";

    /** 時刻 時 開始インデックス */
    public static final int TIME_HOUR_BEGIN_INDEX = 0;
    /** 時刻 時 終了インデックス */
    public static final int TIME_HOUR_END_INDEX = 2;
    /** 時刻 分 開始インデックス */
    public static final int TIME_MINUTE_BEGIN_INDEX = 2;
    /** 時刻 分 終了インデックス */
    public static final int TIME_MINUTE_END_INDEX = 4;
    /** 時刻 秒 開始インデックス */
    public static final int TIME_SECOND_BEGIN_INDEX = 4;
    /** 時刻 秒 終了インデックス */
    public static final int TIME_SECOND_END_INDEX = 6;
    /** 時刻区切り文字 */
    public static final String TIME_SEPARATOR = ":";

    /** 小数計算用 */
    public static final int DECIMAL = 1000;
    /** 小数桁数 3桁 */
    public static final int DECIMAL_LENGTH_3 = 3;

    /** 代弁履行後の作成 */
    public static final String AFTER_DAIBENSAI = "1";

    /** メッセージ文言（更正 赤） */
    public static final String MESSAGE_KOSEI_AKA = "更正 赤";

    /** データコード比較 桁数 */
    public static final int DATA_CODE_LENGTH = 2;

    /** データコード比較 値:11 */
    public static final String DATA_CODE_VALUE_11 = "11";
    /** データコード比較 値:21 */
    public static final String DATA_CODE_VALUE_21 = "21";
    /** データコード比較 値:31 */
    public static final String DATA_CODE_VALUE_31 = "31";
    /** データコード比較 値:40 */
    public static final String DATA_CODE_VALUE_40 = "40";
    /** データコード比較 値:41 */
    public static final String DATA_CODE_VALUE_41 = "41";
    /** データコード比較 値:71 */
    public static final String DATA_CODE_VALUE_71 = "71";

    /** 立替金の種類 値:1 */
    public static final String TATEKAEKIN_SHURUI_1 = "1";
    /** 立替金の種類 値:2 */
    public static final String TATEKAEKIN_SHURUI_2 = "2";
    /** 立替金の種類 値:3 */
    public static final String TATEKAEKIN_SHURUI_3 = "3";

    public static final String ATR_PROPERTY = "property";

    /** 文字(0) */
    public static final String STR_ZERO = "0";

    /** 包括委任 至急発行チェックなし */
    public static final String SHIKYUHAKKO_OFF = "";
    /** 包括委任 至急発行チェックあり */
    public static final String SHIKYUHAKKO_ON = "至急";

    /** 文字："年" */
    public static final String STR_YEAR = "年";
    /** 文字："月" */
    public static final String STR_MONTH = "月";
    /** 文字："日" */
    public static final String STR_DAY = "日";

    /** 公庫支店コード初期値 */
    public static final String INIT_CODE_SHOKANHONSHITEN = "";
    /** 報告書種別プルダウン初期値 */
    public static final String INIT_DATACODE = "";
    /** 報告書種別プルダウン 実行・回収関係報告書詳細 KEY */
    public static final String DATACODE_DATAIL_KEY = "1";
    /** 報告書種別プルダウン 実行・回収関係報告書 VAL */
    public static final String DATACODE_DATAIL_VAL = "実行・回収関係報告書";

    /** 実行・回収関係報告書詳細プルダウン初期値 */
    public static final String INIT_DATACODE_DETAIL = "";

    /** 扱店名称(9937) */
    public static final String NAME_ORGANIZATION_9937 = "日本政策金融公庫";

    /** 扱店コード(9937) */
    public static final String CODE_ORGANIZATION_9937 = "9937";

    /** 明細表示モード(ON) */
    public static final String DISP_DETAIL_OFF = "";
    /** 明細表示モード(OFF) */
    public static final String DISP_DETAIL_ON = "1";
}
