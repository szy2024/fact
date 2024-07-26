//==================================================================================================
// $Id: $
// Project Name :
// System Name  : サンプルソース
// Class Name   : DemoConstants.java
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2010/09/28 | 富士通)安納  理裕     | 新規作成
// 1.1.0   | 2018/12/17 | 富士通)林　晃平       | 農林PN元号対応
// 4.0.0   | 2020/11/27 | 三好　一功            | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.common;

import java.math.BigDecimal;

/**
 * <pre>
 * このクラスはサンプル用定数クラスです。
 * </pre>
 *
 * @author 富士通)
 * @version 1.0.0
 */
public class PNCommonConstants {

    /** 画面モード"登録"です */
    public static final String SCREEN_MODE_REGIST = "";

    /** 画面モード"修正"です */
    public static final String SCREEN_MODE_MODIFY = "1";

    /** 画面モード"参照"です */
    public static final String SCREEN_MODE_REFERENCE = "2";

    /** 年度初日 */
    public static final String NENDO_START_DAY_MMdd = "0401";

    /** ステータス（報告書データの状態）1:予約中 */
    public static final String STATUS_VALUE_1 = "1";

    /** ステータス（報告書データの状態）2:処理完了 */
    public static final String STATUS_VALUE_2 = "2";

    /** ステータス（報告書データの状態）3:エラー */
    public static final String STATUS_VALUE_3 = "3";

    /** ステータス（報告書データの状態）4:入金待ち */
    public static final String STATUS_VALUE_4 = "4";

    /** ステータス（報告書データの状態）5:条件変更待ち */
    public static final String STATUS_VALUE_5 = "5";

    /** ステータス（報告書データの状態）6:ステータス無し */
    public static final String STATUS_VALUE_6 = "6";

    /** ステータス（報告書データの状態）7:取消済み */
    public static final String STATUS_VALUE_7 = "7";

    /** 取消済フラグ（報告書の活性・非活性） 0:報告書取消非対象データ */
    public static final String FLAG_TORIKESHIZUMI_0 = "0";

    /** 取消済フラグ（報告書の活性・非活性） 1:報告書取消対象データ */
    public static final String FLAG_TORIKESHIZUMI_1 = "1";

    /** 処理モード 1 : 処理完了：取消 */
    public static final String PROCESSMODE_PROCEND_DEL = "1";

    /** 処理モード 2 : 処理完了：修正 */
    public static final String PROCESSMODE_PROCEND_MOD = "2";

    /** 処理モード 3 : 処理完了以外：取消 */
    public static final String PROCESSMODE_NOT_PROCEND_DEL = "3";

    /** 処理モード 4 : 処理完了以外：修正 */
    public static final String PROCESSMODE_NOT_PROCEND_MOD = "4";

    /** 処理モード 5 : 処理完了以外更正(赤）：取消 */
    public static final String PROCESSMODE_NOT_PROCEND_DEL_CANCEL = "5";

    /** 処理種別 : 作成 */
    public static final String TYPE_PROCESS_00 = "00";

    /** 処理種別 : 取消 */
    public static final String TYPE_PROCESS_10 = "10";

    /** 処理種別 : 取消（赤） */
    public static final String TYPE_PROCESS_11 = "11";

    /** 処理種別 : 修正 */
    public static final String TYPE_PROCESS_20 = "20";

    /** 元号終了インデックス */
    public static final int IDX_WAREKI_GENGO_END = 1;

    /** 元号のレングス */
    public static final int GANGOU_LENGTH = 1;

    /** 1月 */
    public static final String JANUARY = "01";

    /** 1日 */
    public static final String FIRST_DAY_OF_MONTH = "01";

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

    /** ボックス OFF */
    public static final String CHECKBOX_VALUE_OFF = "0";
    /** チェックボックス ON */
    public static final String CHECKBOX_VALUE_ON = "1";

    /** 半角スペース */
    public static final String HALF_CHAR_SPACE = " ";

    /** BigDecimal型 0（小数部なし） */
    public static final BigDecimal BIGDECIMAL_ZERO_VALUE = new BigDecimal("0");

    /** BigDecimal型 1000（小数部なし） */
    public static final BigDecimal BIGDECIMAL_1000_VALUE = new BigDecimal("1000");

    /** 小数部桁数 3桁 */
    public static final int LENGTH_3 = 3;

    /** スラッシュ */
    public static final String LITERAL_SLASH = "/";

    /** 区切り文字 "." */
    public static final String DELIMITER_DOT = ".";

    /** 稟議番号枝番（0） */
    public static final String RINGI_BRANCH_VALUE_ZERO = "0";

    /** 改行タグ */
    public static final String STR_BR = "<br />";

    /** 注意喚起メッセージ（ 本案件の利子助成対象期間は%s～%sです。） */
    public static final String ATTENTION_MESSAGE = "本案件の利子助成対象期間は%s～%sです。";

    /** HTMLスペース */
    public static final String STR_SPACE_NBSP = "&nbsp;";

    /*
     * 権限種別
     */
    /** 受託者 */
    public static final String ROLECODE_JUTAKUSHA = "10";
    /** 計数管理担当者 */
    public static final String ROLECODE_KEISUUKANRITANTOUSHA = "20";
    /** Ｈ方式受託者 */
    public static final String ROLECODE_HHOUSHIKIJUTAKUSHA = "30";
    /** 管理者 */
    public static final String ROLECODE_KANRISHA = "40";
    /** 地方機構 */
    public static final String ROLECODE_CHIHOUKIKOU = "50";
    /** 農林中金（本店） */
    public static final String ROLECODE_NOURINHONTEN = "60";
    /** 農林中金（支店） */
    public static final String ROLECODE_NOURINSHITEN = "61";
    /** 系統受託者 */
    public static final String ROLECODE_KEITOUJUTAKUSHA = "62";
    /** 系統Ｈ方式受託者 */
    public static final String ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA = "70";

    /*
     * 特利区分コード
     */
    /** 据置期間中特利適用：1 */
    public static final String KUBUN_TOKURI_SUEOKI = "1";
    /** 貸付後３年特利適用：3 */
    public static final String KUBUN_TOKURI_KASITUKEGO_3YERAS = "3";
    /** 貸付後１８年利子助成適用：8 */
    public static final String KUBUN_TOKURI_KASITUKEGO_18YERAS = "8";
    /** 貸付後５年利子助成適用：9 */
    public static final String KUBUN_TOKURI_KASITUKEGO_5YERAS = "9";

    /*
     * オンラインバッチ区分()
     */
    /** オンライン：1 */
    public static final int KUBUN_PN_ONLINE = 1;
    /** バッチ：2 */
    public static final int KUBUN_PN_BAT = 2;

    /** 報告書履歴データ 履歴番号内部連番最大値 */
    public static final int REPORTHISTORY_HISTORY_MAX_VALUE = 9999999;

    /** 報告書履歴データ 報告書番号内部連番最大値 */
    public static final int REPORTHISTORY_REPORT_MAX_VALUE = 9999999;

    /** 報告年月日の表示フォーマット */
    public static final String DATE_PATTERN_YYYY_MM_DD_E = "yyyy年MM月dd日(E)";

    /*
     * 償還方法の種類:照会方法コードの１桁目
     */
    /** ：1 */
    public static final String CODE_SHOKAN_HOUHOU_1 = "1";

    /** 農協コード:9937 */
    public static final String CODE_NOUKYOU_9937 = "9937";

    /*
     * 未完結区分
     */
    /** 未完結区分：2 */
    public static final String KUBUN_MIKANKETSU_2 = "2";
    /** 未完結区分：3 */
    public static final String KUBUN_MIKANKETSU_3 = "3";

    /*
     * データコード
     */
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
    /** 資金交付依頼予定表（月間）データコード */
    public static final String DATACODE_90257130 = "90257130";
    /** 資金交付依頼書（週間） */
    public static final String DATACODE_90257140 = "90257140";
    /** 包括委任状等の交付依頼 */
    public static final String DATACODE_90257150 = "90257150";
    /** （根）抵当権抹消に係る報告書 */
    public static final String DATACODE_90257160 = "90257160";
    /** 属性(TRUE) */
    public static final String ATR_TRUE = "true";
    /** 属性(FALSE) */
    public static final String ATR_FALSE = "false";

    /*
     * 報告書種別区分
     */
    /** 実行・回収関係報告書：0 */
    public static final String SYUBETSUKBN_REPORT_0 = "0";
    /** 実行・回収関係報告書以外：1 */
    public static final String SYUBETSUKBN_REPORT_1 = "1";

    /*
     * レコード件数
     */
    /** レコード件数 0件 */
    public static final int RECORD_COUNT_ZERO = 0;
    /** レコード件数 1件 */
    public static final int RECORD_COUNT_ONE = 1;

    /** 空文字(リテラル) */
    public static final String LITERAL_BLANK = "";

    /*
     * 報告書番号、報告書履歴番号最大値取得時のロック用
     */
    /** 決算日テーブルキー値 : KESSAN1 */
    public static final String KESSANBI_KEY_KESSAN1 = "KESSAN1";

    /*
     * 包括委任 至急発行チェック有無
     */
    /** 至急発行チェックあり : 1 */
    public static final String FLAG_SHIKYUHAKKO_ON = "1";
    /** 至急発行チェックなし : 0 */
    public static final String FLAG_SHIKYUHAKKO_OFF = "0";

    /*
     * 決算期月
     */
    /** 決算期月1 : 4月 */
    public static final int KESSANKI_MONTH_1 = 4;
    /** 決算期月2 : 10月 */
    public static final int KESSANKI_MONTH_2 = 10;

    /*
     * 決算期・通常期 営業日数境界日
     */
    /** 決算期 営業日数境界日 : 4日 */
    public static final int ORDINALBIZDATE_BORDER_KESSANKI = 4;
    /** 通常期 営業日数境界日 : 10日 */
    public static final int ORDINALBIZDATE_BORDER_TSUJOKI = 10;

    /*
     * 受託者勘定処理年月設定モード
     */
    /** 受託者勘定処理年月設定モード：1（決算期かつ第1～4営業日） **/
    public static final String JTKSHORI_CONFIGMODE_1 = "1";
    /** 受託者勘定処理年月設定モード：2（決算期かつ第5～最終営業日） **/
    public static final String JTKSHORI_CONFIGMODE_2 = "2";
    /** 受託者勘定処理年月設定モード：3（通常期かつ第1～10営業日） **/
    public static final String JTKSHORI_CONFIGMODE_3 = "3";
    /** 受託者勘定処理年月設定モード：4（通常期かつ第11～最終営業日） **/
    public static final String JTKSHORI_CONFIGMODE_4 = "4";

// [ADD] Ver 1.1.0 - START
    /*
     * アプリケーションスコープキー
     */
    /**
     * 元号情報
     */
    public static final String APPKEY_CALENDARINFO = "calendarInfo";
// [ADD] Ver 1.1.0 - END

// [ADD] Ver 4.0.0 - START
    /** 控除利息計算基準日 */
	public static final String BASE_DATE_DEDUCT_INTEREST = "20220401";
// [ADD] Ver 4.0.0 - END
}
