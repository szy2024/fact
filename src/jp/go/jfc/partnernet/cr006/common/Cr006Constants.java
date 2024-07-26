//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/01 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.common;

/**
 * <pre>
 * このクラスはCr006の定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Cr006Constants {

    /** 立替金受入・充当報告書作成（融資番号選択画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR006_01INIT = "Cr006_01Init";

    /** 立替金受入・充当報告書作成（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR006_02INIT = "Cr006_02Init";

    /** 立替金受入・充当報告書作成（入力結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR006_03INIT = "Cr006_03Init";

    /** 立替金受入・充当報告書作成（入力結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR006_04INIT = "Cr006_04Init";

    /** 立替金受入・充当報告書作成（入力結果画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_CR006_01RETURN = "Cr006_01Return";

    /** 立替金受入・充当報告書作成（入力結果画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_CR006_02RETURN = "Cr006_02Return";

    /** 受取_顧客名 */
    public static final String PROPERTY_ID_NAME_CUSTOMER = "cr006_02_ID_Name_Customer";
    /** 受取_立替日 */
    public static final String PROPERTY_ID_DATE_KARIBARAI = "cr006_02_ID_Date_Karibarai";
    /** 受取_立替金の種類 */
    public static final String PROPERTY_ID_CODE_KANJOKAMOKU = "cr006_02_ID_Code_KanjoKamoku";
    /** 受取_公庫立替金額(円) */
    public static final String PROPERTY_ID_M_TOSHOKARIBARAI = "cr006_02_ID_M_ToshoKaribarai";
    /** 受取_現在の立替金残高(円) */
    public static final String PROPERTY_ID_M_KARIBARAIZANAFTERSEISAN = "cr006_02_ID_M_KaribaraiZanAfterSeisan";
    /** 受取_債権管理番号 */
    public static final String PROPERTY_ID_ID_CREDIT = "cr006_02_ID_ID_Credit";
    /** 受取_公庫支店 */
    public static final String PROPERTY_ID_CODE_KOUKOSHITEN = "cr006_02_ID_Code_KoukoShiten";
    /** 受取_扱店 */
    public static final String PROPERTY_ID_CODE_ORGANIZATION = "cr006_02_ID_Code_Organization";
    /** 受取_店舗 */
    public static final String PROPERTY_ID_CODE_TENPO = "cr006_02_ID_Code_Tenpo";
    /** 受取_年度 */
    public static final String PROPERTY_ID_YEAR = "cr006_02_ID_Year";
    /** 受取_方式資金 */
    public static final String PROPERTY_ID_CODE_HOSHIKISHIKIN = "cr006_02_ID_Code_HoshikiShikin";
    /** 受取_番号 */
    public static final String PROPERTY_ID_ID_RINGI = "cr006_02_ID_ID_Ringi";
    /** 受取_枝番 */
    public static final String PROPERTY_ID_ID_RINGIBRANCH = "cr006_02_ID_ID_RingiBranch";
    /** 受取_本支店コード */
    public static final String PROPERTY_ID_CODE_HONSHITEN2 = "cr006_02_ID_Code_HonShiten2";
    /** 受取_仮受仮払番号 */
    public static final String PROPERTY_ID_ID_KARIBARAI = "cr006_02_ID_ID_Karibarai";
    /** 受取_仮受仮払勘定科目コード */
    public static final String PROPERTY_CODE_KANJOKAMOKU = "cr006_02_Code_KanjoKamoku";

    /** 仮受仮払勘定科目コード */
    public static final String CODE_KANJOKAMOKU_108010101 = "108010101";
    public static final String CODE_KANJOKAMOKU_108010103 = "108010103";
    public static final String CODE_KANJOKAMOKU_108010105 = "108010105";
    public static final String CODE_KANJOKAMOKU_108010106 = "108010106";
    public static final String CODE_KANJOKAMOKU_108010108 = "108010108";
    public static final String CODE_KANJOKAMOKU_108010110 = "108010110";
    public static final String CODE_KANJOKAMOKU_108010201 = "108010201";
    public static final String CODE_KANJOKAMOKU_108010301 = "108010301";

// [DEL] Ver 3.0.0 - START
//    /** ドロップダウンリスト選択項目（”H"：平成） */
//    public static final String LITERAL_HEISEI = "H";
// [DEL] Ver 3.0.0 - END

    /** ゼロサプレス時の引数 */
    public static final String LITERAL_ZERO_SAPLES = "^0+";

    /** リテラル カンマ */
    public static final String LITERAL_COMMA = ",";
    /** リテラル カンマ */
    public static final String LITERAL_SLASH = "/";
    /** 文字：0 */
    public static final String LITERAL_CHAR_ZERO = "0";

    /** 報告年月日（日付パターン） **/
    public static final String DATE_PATTERN_YYYY_MM_DD_E = "yyyy年MM月dd日(E)";

    /** cr006_03への遷移パラメータ定義 */
    /** 報告年月日 */
    public static final String PROPERTY_TXTID_DATE_REPORT = "txtID_Date_Report";
    /** 顧客名 */
    public static final String PROPERTY_TXTID_NAME_CUSTOMER = "txtID_Name_Customer";
    /** 扱店名 */
    public static final String PROPERTY_TXTID_NAME_ORGANIZATION = "txtID_Name_Organization";
    /** 公庫支店 */
    public static final String PROPERTY_TXTID_CODE_KOUKOSHITEN = "txtID_Code_KoukoShiten";
    /** 扱店 */
    public static final String PROPERTY_TXTID_CODE_ORGANIZATION = "txtID_Code_Organization";
    /** 店舗 */
    public static final String PROPERTY_TXTID_CODE_TENPO = "txtID_Code_Tenpo";
    /** 年度 */
    public static final String PROPERTY_TXTID_YEAR = "txtID_Year";
    /** 方式資金 */
    public static final String PROPERTY_TXTID_CODE_HOSHIKISHIKIN = "txtID_Code_HoshikiShikin";
    /** 番号 */
    public static final String PROPERTY_TXTID_ID_RINGI = "txtID_ID_Ringi";
    /** 枝番 */
    public static final String PROPERTY_TXTID_ID_RINGIBRANCH = "txtID_ID_RingiBranch";
    /** 入金日(年号) */
    public static final String PROPERTY_DRPID_DATE_NYUKIN_GENGOU = "drpID_Date_Nyukin_Gengou";
    /** 入金日(年) */
    public static final String PROPERTY_TXTID_DATE_NYUKIN_YEAR = "txtID_Date_Nyukin_Year";
    /** 入金日(月) */
    public static final String PROPERTY_DRPID_DATE_NYUKIN_MONTH = "drpID_Date_Nyukin_Month";
    /** 入金日(日) */
    public static final String PROPERTY_DRPID_DATE_NYUKIN_DAY = "drpID_Date_Nyukin_Day";
    /** 立替金利息(円) */
    public static final String PROPERTY_TXTID_M_TATEKAERISOKU = "txtID_M_TatekaeRisoku";
    /** 立替金（円） */
    public static final String PROPERTY_TXTID_M_TATEKAE = "txtID_M_Tatekae";
    /** 仮受金(一般口)からの充当額（円） */
    public static final String PROPERTY_TXTID_M_KARIUKEIPPANJUTO = "txtID_M_KariukeIppanJuto";
    /** 立替金の種類 */
    public static final String PROPERTY_TXTID_CODE_TATEKAEKINSHURUI = "txtID_Code_TatekaekinShurui";
    /** 公庫立替日 */
    public static final String PROPERTY_TXTID_DATE_KOUKOTATEKAE = "txtID_Date_KoukoTatekae";
    /** 計（円） */
    public static final String PROPERTY_TXTID_M_KEI = "txtID_M_Kei";
    /** 送金額（円） */
    public static final String PROPERTY_TXTID_M_SOKIN = "txtID_M_Sokin";
    /** 受入後立替金残高（円） */
    public static final String PROPERTY_TXTID_M_TATEKAEZANAFTERUKEIRE = "txtID_M_TatekaeZanAfterUkeire";
    /** 受託者勘定処理年月(年号) */
    public static final String PROPERTY_DRPID_DATE_JTKSHORI_GENGOU = "drpID_Date_Jtkshori_Gengou";
    /** 受託者勘定処理年月(年) */
    public static final String PROPERTY_TXTID_DATE_JTKSHORI_YEAR = "txtID_Date_Jtkshori_Year";
    /** 受託者勘定処理年月(月) */
    public static final String PROPERTY_DRPID_DATE_JTKSHORI_MONTH = "drpID_Date_Jtkshori_Month";
    /** 送金年月日(年号) */
    public static final String PROPERTY_DRPID_DATE_SOKIN_GENGOU = "drpID_Date_Sokin_Gengou";
    /** 送金年月日(年) */
    public static final String PROPERTY_TXTID_DATE_SOKIN_YEAR = "txtID_Date_Sokin_Year";
    /** 送金年月日(月) */
    public static final String PROPERTY_DRPID_DATE_SOKIN_MONTH = "drpID_Date_Sokin_Month";
    /** 送金年月日(日) */
    public static final String PROPERTY_DRPID_DATE_SOKIN_DAY = "drpID_Date_Sokin_Day";
    /** 送金日番号 */
    public static final String PROPERTY_TXTID_CODE_SOKIN = "txtID_Code_Sokin";
    /** 原本番号 */
    public static final String PROPERTY_ID_ID_MASTER = "ID_ID_Master";
    /** ユーザID */
    public static final String PROPERTY_ID_USERID = "ID_UserID";
    /** データコード */
    public static final String PROPERTY_ID_DATACODE = "ID_DataCode";
    /** ステータス(非表示) */
    public static final String PROPERTY_ID_STATUS = "ID_Status";
    /** 取消済フラグ */
    public static final String PROPERTY_ID_FLAG_TORIKESHIZUMI = "ID_Flag_Torikeshizumi";
    /** 処理種別 */
    public static final String PROPERTY_ID_TYPE_PROCESS = "ID_Type_Process";
    /** 先行報告書の有無 */
    public static final String PROPERTY_ID_PREVIOUS_REPORT = "ID_Previous_Report";
    /** 先行報告書の種類 */
    public static final String PROPERTY_ID_PREVIOUS_REPORTTYPE = "ID_Previous_ReportType";
    /** 仮受仮払精算後残高（計算用） */
    public static final String PROPERTY_ID_M_KRBRIZNAFTERSISN = "ID_M_KaribaraiZanAfterSeisan";
    /** 本支店コード */
    public static final String PROPERTY_ID_CODE_HONSHITEN = "ID_Code_HonShiten";
    /** 仮受仮払番号 */
    public static final String PROPERTY_ID_ID_KRBRI = "ID_ID_Karibarai";
    /** 入金日 */
    public static final String PROPERTY_ID_DATE_NYUKIN = "ID_Date_Nyukin";
    /** 受託者勘定処理年月 */
    public static final String PROPERTY_ID_DATE_JTKSHORI = "ID_Date_Jtkshori";
    /** 送金年月日 */
    public static final String PROPERTY_ID_DATE_SOKIN = "ID_Date_Sokin";
    /** 最新データ更新日付 */
    public static final String PROPERTY_ID_DATA_LASTUPDATE = "ID_Data_LastUpDate";
    /** 債権管理番号 */
    public static final String PROPERTY_ID_CREDIT = "ID_ID_Credit";
    /** 報告書番号 */
    public static final String PROPERTY_ID_ID_REPORT = "ID_ID_Report";
    /** 報告時分秒 */
    public static final String PROPERTY_ID_TIME_REPORT = "ID_Time_Report";

    /** データ入力領域 */
    public static final String ID_PNL = "pnl";
    /** 項目名：送信ボタン名 */
    public static final String JSP_ITEM_BTNID_SEND = "btnID_Send";
    /** 項目名：受託者勘定処理年月（元号） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_GENGOU = "drpID_Date_Jtkshori_Gengou";
    /** 項目名：受託者勘定処理年月（年） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_YEAR = "txtID_Date_Jtkshori_Year";
    /** 項目名：受託者勘定処理年月（月） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_MONTH = "drpID_Date_Jtkshori_Month";

}
