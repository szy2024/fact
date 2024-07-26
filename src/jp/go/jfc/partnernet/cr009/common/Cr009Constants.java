//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr009.common;

/**
 * <pre>
 * このクラスはCr009の定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Cr009Constants {

    /** 日付パターン（HH:mm:ss） */
    public static final String DATE_PATTERN_HHMMSS = "HHmmss";
    /** 日付パターン（YYYY年MM月DD日(E) */
    public static final String DATE_PATTERN_YYYY_MM_DD_E = "yyyy年MM月dd日(E)";
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
// [DEL] Ver 3.0.0 - START
//    /** 年号：平成 */
//    public static final String GENGO_HEISEI = "H";
// [DEL] Ver 3.0.0 - END
    /** 年：６４年 */
    public static final String YEAR_64 = "64";

    /** 画面 表示／非表示エリア */
    /** 顧客名検索結果 */
    public static final String PROPERTY_CUSTOMERLIST_AREA = "CustomerListArea";
    /** 融資検索結果 */
    public static final String PROPERTY_YUUSHILIST_AREA = "YuushiListArea";
    /** メッセージ領域 */
    public static final String PROPERTY_INFO_AREA = "infoArea";
    /** 編集領域 */
    public static final String PROPERTY_EDIT_AREA = "editArea";
    /** 送信ボタン */
    public static final String PROPERTY_SEND_BTN = "btnID_Send";

    /** 遷移パラメータ(扱店名) */
    public static final String PROPERTY_ID_NAME_ORGANIZATION = "ID_Name_Organization";
    /** 遷移パラメータ(公庫支店) */
    public static final String PROPERTY_ID_CODE_SHOKANHONSHITEN = "ID_Code_Shokanhonshiten";
    /** 遷移パラメータ(扱店) */
    public static final String PROPERTY_ID_CODE_ORGANIZATION = "ID_Code_Organization";
    /** 遷移パラメータ(店舗) */
    public static final String PROPERTY_ID_CODE_TENPO = "ID_Code_Tenpo";
    /** 遷移パラメータ(入金日（元号）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_GENGOU = "ID_Date_Nyukin_Gengou";
    /** 遷移パラメータ(入金日（年）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_YEAR_INPUT = "ID_Date_Nyukin_Year_Input";
    /** 遷移パラメータ(入金日（月）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_MONTH = "ID_Date_Nyukin_Month";
    /** 遷移パラメータ(入金日（日）) */
    public static final String PROPERTY_ID_DATE_NYUKIN_DAY = "ID_Date_Nyukin_Day";
    /** 遷移パラメータ(留置期間利息) */
    public static final String PROPERTY_ID_M_RYUCHIKIKANRISOKU = "ID_M_Ryuchikikanrisoku";
    /** 遷移パラメータ(代弁遅延損害金) */
    public static final String PROPERTY_ID_M_DAIBENCHIENSONGAI = "ID_M_Daibenchiensongai";
    /** 遷移パラメータ(送金額) */
    public static final String PROPERTY_ID_M_SOKIN = "ID_M_Sokin";
    /** 遷移パラメータ(受託者勘定処理年月) */
    public static final String PROPERTY_ID_DATE_JTKSHORI = "ID_Date_Jtkshori";
    /** 遷移パラメータ(送金年月日（元号）) */
    public static final String PROPERTY_ID_DATE_SOKIN_GENGOU = "ID_Date_Sokin_Gengou";
    /** 遷移パラメータ(送金年月日（年）) */
    public static final String PROPERTY_ID_DATE_SOKIN_YEAR_INPUT = "ID_Date_Sokin_Year_Input";
    /** 遷移パラメータ(送金年月日（月）) */
    public static final String PROPERTY_ID_DATE_SOKIN_MONTH = "ID_Date_Sokin_Month";
    /** 遷移パラメータ(送金年月日（日）) */
    public static final String PROPERTY_ID_DATE_SOKIN_DAY = "ID_Date_Sokin_Day";
    /** 遷移パラメータ(送金日番号) */
    public static final String PROPERTY_ID_CODE_SOKIN = "ID_Code_Sokin";
    /** 遷移パラメータ(受託者勘定処理年月（元号）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_GENGOU = "ID_Date_Jtkshori_Gengou";
    /** 遷移パラメータ(受託者勘定処理年月（年）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT = "ID_Date_Jtkshori_Year_Input";
    /** 遷移パラメータ(受託者勘定処理年月（月）) */
    public static final String PROPERTY_ID_DATE_JTKSHORI_MONTH = "ID_Date_Jtkshori_Month";

    /** 留置期間利息・代弁遅延損害金受入充当報告書作成（入力画面）：初期表示 */
    public static final String EVENT_ID_CR009_01INIT = "Cr009_01Init";
    /** 留置期間利息・代弁遅延損害金受入充当報告書作成（入力画面）：戻る */
    public static final String EVENT_ID_CR009_01RETURN = "Cr009_01Return";
    /** 留置期間利息・代弁遅延損害金受入充当報告書作成（入力結果画面）：初期表示 */
    public static final String EVENT_ID_CR009_02INIT = "Cr009_02Init";
    /** 留置期間利息・代弁遅延損害金受入充当報告書作成（登録結果画面）：初期表示 */
    public static final String EVENT_ID_CR009_03INIT = "Cr009_03Init";

    /** 項目名：受託者勘定処理年月（元号） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_GENGO = "drpID_Date_Jtkshori_Gengou";
    /** 項目名：受託者勘定処理年月（年） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_NEN = "txtID_Date_Jtkshori_Year_Input";
    /** 項目名：受託者勘定処理年月（月） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE = "drpID_Date_Jtkshori_Month";
}
