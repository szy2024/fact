//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.common;


/**
 * <pre>
 * このクラスはCr005の定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Cr005Constants {

    /** 初期表示コントローラ名 */
    public static final String EVENT_ID_CR005_01INIT = "Cr005_01Init";
    public static final String EVENT_ID_CR005_02INIT = "Cr005_02Init";
    public static final String EVENT_ID_CR005_03INIT = "Cr005_03Init";
    public static final String EVENT_ID_CR005_04INIT = "Cr005_04Init";
    public static final String EVENT_ID_CR005_05INIT = "Cr005_05Init";
    public static final String EVENT_ID_CR005_06INIT = "Cr005_06Init";

    /** 戻り表示コントローラ名 */
    public static final String EVENT_ID_CR005_01RETURN = "Cr005_01Return";
    public static final String EVENT_ID_CR005_02INITBACK = "Cr005_02Initback";
    public static final String EVENT_ID_CR005_03RETURN = "Cr005_03Return";
    public static final String EVENT_ID_CR005_04RETURN = "Cr005_04Return";

    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_LBLID_DATE_REPORT = "txtID_Date_Report";
    /** 遷移パラメータ(顧客名）) */
    public static final String PROPERTY_LBLID_NAME_CUSTOMER = "lblID_Name_Customer";
    /** 遷移パラメータ(扱店名) */
    public static final String PROPERTY_LBLID_NAME_ORGANIZATION = "lblID_Name_Organization";
    /** 遷移パラメータ(公庫支店) */
    public static final String PROPERTY_LBLID_CODE_SHOKANHONSHITEN = "lblID_Code_ShokanHonShiten";
    /** 遷移パラメータ(扱店) */
    public static final String PROPERTY_LBLID_CODE_ORGANIZATION = "lblID_Code_Organization";
    /** 遷移パラメータ(店舗) */
    public static final String PROPERTY_LBLID_CODE_TENPO = "lblID_Code_Tenpo";
    /** 遷移パラメータ(年度) */
    public static final String PROPERTY_LBLID_YEAR = "lblID_Year";
    /** 遷移パラメータ(方式資金) */
    public static final String PROPERTY_LBLID_KUBUN_HOSHIKISHIKIN = "lblID_Kubun_HoshikiShikin";
    /** 遷移パラメータ(番号) */
    public static final String PROPERTY_LBLID_ID_RINGI = "lblID_ID_Ringi";
    /** 遷移パラメータ(枝番) */
    public static final String PROPERTY_LBLID_ID_RINGIBRANCH = "lblID_ID_RingiBranch";
    /** 遷移パラメータ(充当対象払込期日（元号）) */
    public static final String PROPERTY_DRPID_DATE_JUTOTAISHOGENGOU = "drpID_Date_JutoTaishoGengou";
    /** 遷移パラメータ(充当対象払込期日（年）) */
    public static final String PROPERTY_TXTID_DATE_JUTOTAISHOYEAR = "txtID_Date_JutoTaishoYear";
    /** 遷移パラメータ(充当対象払込期日（月）) */
    public static final String PROPERTY_DRPID_DATE_JUTOTAISHOMONTH = "drpID_Date_JutoTaishoMonth";
    /** 遷移パラメータ(充当対象払込期日（日）) */
    public static final String PROPERTY_DRPID_DATE_JUTOTAISHODAY = "drpID_Date_JutoTaishoDay";
    /** 遷移パラメータ(代弁金払込日（元号）) */
    public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIGENGOU = "drpID_Date_DaibenkinHaraikomiGengou";
    /** 遷移パラメータ(代弁金払込日（年）) */
    public static final String PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMIYEAR = "txtID_Date_DaibenkinHaraikomiYear";
    /** 遷移パラメータ(代弁金払込日（月）) */
    public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIMONTH = "drpID_Date_DaibenkinHaraikomiMonth";
    /** 遷移パラメータ(代弁金払込日（日）) */
    public static final String PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIDAY = "drpID_Date_DaibenkinHaraikomiDay";
    /** 遷移パラメータ(遅延損害金(円)）) */
    public static final String PROPERTY_LBLID_M_CHIENSONGAI = "lblID_M_ChienSongai";
    /** 遷移パラメータ(利息(円)) */
    public static final String PROPERTY_LBLID_M_RISOKU = "lblID_M_Risoku";
    /** 遷移パラメータ(番号) */
    public static final String PROPERTY_LBLID_M_KURISHOCOMMISSION = "lblID_M_KurishoCommission";
    /** 遷移パラメータ(元金(円)) */
    public static final String PROPERTY_LBLID_M_GANKIN = "lblID_M_Gankin";
    /** 遷移パラメータ(仮受金(一般口)からの充当額(円)) */
    public static final String PROPERTY_LBLID_M_KARIUKEIPPANJUTO = "lblID_M_KariukeIppanJuto";
    /** 遷移パラメータ(計(円)) */
    public static final String PROPERTY_LBLID_M_KEI = "lblID_M_Kei";
    /** 遷移パラメータ(送金額(円)）) */
    public static final String PROPERTY_LBLID_M_SOKIN = "lblID_M_Sokin";
    /** 遷移パラメータ(代弁金充当後残元金(円)) */
    public static final String PROPERTY_LBLID_M_ZANGANAFTERDAIBENJUTO = "lblID_M_ZanGanAfterDaibenJuto";
    /** 遷移パラメータ(受託者勘定処理年月（元号）) */
    public static final String PROPERTY_DRPID_DATE_JTKSHORIGENGOU = "drpID_Date_JtkshoriGengou";
    /** 遷移パラメータ(受託者勘定処理年月（年）) */
    public static final String PROPERTY_TXTID_DATE_JTKSHORIYEAR = "txtID_Date_JtkshoriYear";
    /** 遷移パラメータ(受託者勘定処理年月（月）) */
    public static final String PROPERTY_DRPID_DATE_JTKSHORIMONTH = "drpID_Date_JtkshoriMonth";
    /** 遷移パラメータ(送金年月日（元号）) */
    public static final String PROPERTY_DRPID_DATE_SOKINGENGOU = "drpID_Date_SokinGengou";
    /** 遷移パラメータ(送金年月日（年）) */
    public static final String PROPERTY_TXTID_DATE_SOKINYEAR = "txtID_Date_SokinYear";
    /** 遷移パラメータ(送金年月日（月）) */
    public static final String PROPERTY_DRPID_DATE_SOKINMONTH = "drpID_Date_SokinMonth";
    /** 遷移パラメータ(送金年月日（日）) */
    public static final String PROPERTY_DRPID_DATE_SOKINDAY = "drpID_Date_SokinDay";
    /** 遷移パラメータ(送金日番号) */
    public static final String PROPERTY_LBLID_CODE_SOKIN = "lblID_Code_Sokin";
    /** 遷移パラメータ(債権管理番号（受渡情報)) */
    public static final String PROPERTY_CR005_04_ID_CREDIT = "Cr005_04_ID_Credit";
    /** 遷移パラメータ(公庫支店コード（受渡情報)) */
    public static final String PROPERTY_CR005_04_CODE_SHOKANHONSHITEN = "Cr005_04_Code_ShokanHonShiten";
    /** 遷移パラメータ(扱店コード（受渡情報)) */
    public static final String PROPERTY_CR005_04_CODE_ORGANIZATION = "Cr005_04_Code_Organization";
    /** 遷移パラメータ(店舗コード（受渡情報)) */
    public static final String PROPERTY_CR005_04_CODE_TENPO = "Cr005_04_Code_Tenpo";
    /** 遷移パラメータ(年度（受渡情報)) */
    public static final String PROPERTY_CR005_04_YEAR = "Cr005_04_Year";
    /** 遷移パラメータ(方式資金（受渡情報)）) */
    public static final String PROPERTY_CR005_04_CODE_HOSHIKISHIKIN = "Cr005_04_Code_HoshikiShikin";
    /** 遷移パラメータ(番号（受渡情報)) */
    public static final String PROPERTY_CR005_04_ID_RINGI = "Cr005_04_ID_Ringi";
    /** 遷移パラメータ(枝番（受渡情報)) */
    public static final String PROPERTY_CR005_04_ID_RINGIBRANCH = "Cr005_04_ID_RingiBranch";
    /** 遷移パラメータ(償還期限年月) */
    public static final String PROPERTY_ID_DATE_SHOKANKIGEN = "ID_Date_ShokanKigen";
    /** 遷移パラメータ(最新更新日時) */
    public static final String PROPERTY_ID_DATA_LASTUPDATE = "ID_Data_LastUpDate";
    /** 遷移パラメータ(債権管理番号) */
    public static final String PROPERTY_ID_CREDIT = "ID_Credit";
    /** 遷移パラメータ(貸付金残高) */
    public static final String PROPERTY_ID_M_KASHITSUKEZANDAKA = "ID_M_KashitsukeZandaka";
    /** 遷移パラメータ(先行する報告書の有無) */
    public static final String PROPERTY_ID_PREVIOUS_REPORT = "ID_Previous_Report";
    /** 遷移パラメータ(先行する報告書名) */
    public static final String PROPERTY_ID_PREVIOUS_REPORTTYPE = "ID_Previous_ReportType";
    /** 遷移パラメータ(充当対象払込期日) */
    public static final String PROPERTY_ID_DATE_JUTOTAISHO = "ID_Date_JutoTaisho";
    /** 遷移パラメータ(代弁金払込日) */
    public static final String PROPERTY_ID_DATE_DAIBENKINHARAIKOMI = "ID_Date_DaibenkinHaraikomi";
    /** 遷移パラメータ(受託者勘定処理年月) */
    public static final String PROPERTY_ID_DATE_JTKSHORI = "ID_Date_Jtkshori";
    /** 遷移パラメータ(送金年月日) */
    public static final String PROPERTY_ID_DATE_SOKIN = "ID_Date_Sokin";
    /** 遷移パラメータ(退避請求繰上償還利息) */
    public static final String PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU = "ID_Keep_Seikyu_M_SeiKuriRisoku";
    /** 遷移パラメータ(退避約定利息) */
    public static final String PROPERTY_ID_KEEP_M_YAKUJORISOKU = "ID_Keep_M_YakujoRisoku";
    /** 遷移パラメータ(請求繰上償還利息・仮更新値) */
    public static final String PROPERTY_ID_M_SEIKURIRISOKU = "ID_M_SeiKuriRisoku";
    /** 遷移パラメータ(約定利息・仮更新値) */
    public static final String PROPERTY_ID_M_YAKUJORISOKU = "ID_M_YakujoRisoku";
    /** 遷移パラメータ(退避請求繰上償還元金) */
    public static final String PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN = "ID_Keep_Seikyu_M_SeiKuriGankin";
    /** 遷移パラメータ(退避約定元金) */
    public static final String PROPERTY_ID_KEEP_M_YAKUJOGANKIN = "ID_Keep_M_YakujoGankin";
    /** 遷移パラメータ(請求繰上償還元金・仮更新値) */
    public static final String PROPERTY_ID_M_SEIKURIGANKIN = "ID_M_SeiKuriGankin";
    /** 遷移パラメータ(約定元金・仮更新値) */
    public static final String PROPERTY_ID_M_YAKUJOGANKIN = "ID_M_YakujoGankin";
    /** 遷移パラメータ(ユーザID) */
    public static final String PROPERTY_ID_USERID = "ID_UserID";
    /** 遷移パラメータ(伝送番号) */
    public static final String PROPERTY_ID_ID_DENSO = "ID_ID_Denso";
    /** 遷移パラメータ(データコード) */
    public static final String PROPERTY_ID_DATACODE = "ID_DataCode";
    /** 遷移パラメータ(ステータス) */
    public static final String PROPERTY_ID_STATUS = "ID_Status";
    /** 遷移パラメータ(取消済フラグ) */
    public static final String PROPERTY_ID_FLAG_TORIKESHIZUMI = "ID_Flag_Torikeshizumi";
    /** 遷移パラメータ(処理種別) */
    public static final String PROPERTY_ID_TYPE_PROCESS = "ID_Type_Process";
    /** 遷移パラメータ(項目エラーフラグ) */
    public static final String PROPERTY_ID_ERROR = "ID_Error";
    /** 遷移パラメータ(請求検索日付) */
    public static final String PROPERTY_ID_DATE_SEARCHSEIKYU = "ID_Date_SearchSeikyu";
    /** 遷移パラメータ(請求検索結果・取得件数) */
    public static final String PROPERTY_ID_SEIKYUCOUNT = "ID_SeikyuCount";
    /** 遷移パラメータ(請求検索結果・約定元金) */
    public static final String PROPERTY_ID_M_YAKUJOGANKIN_SEIKYUANS = "ID_M_YakujoGankin_SeikyuAns";
    /** 遷移パラメータ(請求検索結果・約定利息) */
    public static final String PROPERTY_ID_M_YAKUJORISOKU_SEIKYUANS = "ID_M_YakujoRisoku_SeikyuAns";
    /** 遷移パラメータ(請求検索結果・請求繰上償還元金) */
    public static final String PROPERTY_ID_M_SEIKURIGANKIN_SEIKYUANS = "ID_M_SeiKuriGankin_SeikyuAns";
    /** 遷移パラメータ(請求検索結果・請求繰上償還利息) */
    public static final String PROPERTY_ID_M_SEIKURIRISOKU_SEIKYUANS = "ID_M_SeiKuriRisoku_SeikyuAns";
    /** 遷移パラメータ(報告時分秒) */
    public static final String PROPERTY_ID_TIME_REPORT = "ID_Time_Report";

    /** 遷移パラメータ(顧客名入力値)(cr005_02) */
    public static final String PROPERTY_02_IN_NAME_CUSTOMER = "Cr005_02_In_Name_Customer";
    /** 遷移パラメータ(顧客名入力値)(cr005_03) */
    public static final String PROPERTY_03_IN_NAME_CUSTOMER = "Cr005_03_In_Name_Customer";
    /** 遷移パラメータ(貸付先コード入力値)(cr005_03) */
    public static final String PROPERTY_03_IN_CODE_CUSTOMER = "Cr005_03_In_Code_Customer";
    /** 遷移パラメータ(扱店コード入力値)(cr005_03) */
    public static final String PROPERTY_03_IN_CODE_ORGANIZATION = "Cr005_03_In_Code_Organization";
    /** 遷移パラメータ(住所入力値)(cr005_03) */
    public static final String PROPERTY_03_IN_ADDRESS = "Cr005_03_In_Address";

    /** 遷移パラメータ(債権管理番号（受渡情報)) */
    public static final String CR005_04_ID_CREDIT = "cr005_04_ID_Credit";
    /** 遷移パラメータ(公庫支店コード（受渡情報)) */
    public static final String CR005_04_CODE_SHOKANHONSHITEN = "cr005_04_Code_ShokanHonShiten";
    /** 遷移パラメータ(扱店コード（受渡情報)) */
    public static final String CR005_04_CODE_ORGANIZATION = "cr005_04_Code_Organization";
    /** 遷移パラメータ(店舗コード（受渡情報)) */
    public static final String PCR005_04_CODE_TENPO = "cr005_04_Code_Tenpo";
    /** 遷移パラメータ(年度（受渡情報)) */
    public static final String CR005_04_YEAR = "cr005_04_Year";
    /** 遷移パラメータ(方式資金（受渡情報)）) */
    public static final String CR005_04_CODE_HOSHIKISHIKIN = "cr005_04_Code_HoshikiShikin";
    /** 遷移パラメータ(番号（受渡情報)) */
    public static final String CR005_04_ID_RINGI = "cr005_04_ID_Ringi";
    /** 遷移パラメータ(枝番（受渡情報)) */
    public static final String CR005_04_ID_RINGIBRANCH = "cr005_04_ID_RingiBranch";

    /** 画面項目 公庫支店コード */
    public static final String TXT_CODE_SHOKANHONSHITEN = "txtID_Code_ShokanHonShiten";
    /** 画面項目 扱店コード */
    public static final String TXT_CODE_ORGANIZATION = "txtID_Code_Organization";
    /** 画面項目 店舗コード */
    public static final String TXT_CODE_TENPO = "txtID_Code_Tenpo";
    /** 画面項目 年度 */
    public static final String TXT_YEAR = "txtID_Year";
    /** 画面項目 方式資金 */
    public static final String TXT_CODE_HOSHIKISHIKIN = "txtID_Code_HoshikiShikin";
    /** 画面項目 番号 */
    public static final String TXT_RINGI = "txtID_ID_Ringi";
    /** 画面項目 枝番 */
    public static final String TXT_RINGIBRANCH = "txtID_ID_RingiBranch";
    /** 画面項目 顧客名 */
    public static final String TXT_NAME_CUSTOMER = "txtID_Name_Customer";

    /** 画面 表示／非表示エリア */
    public static final String PROPERTY_CUSTOMERLIST_AREA = "CustomerListArea";
    /** 融資検索結果 */
    public static final String PROPERTY_YUUSHILIST_AREA = "YuushiListArea";

    /** 年度1文字目のインデックス */
    public static final int INDEX_1_YEAR = 1;

// [DEL] Ver 3.0.0 - START
//    /** 年度の先頭１文字目 */
//    public static final List<String> LIST_GANGOU_KIGOU = Arrays
//            .asList("M", "T", "S", "H", "m", "t", "s", "h");
// [DEL] Ver 3.0.0 - END

    /** 年度の先頭２、３文字目 */
    public static final String YEAR_00 = "00";

// [DEL] Ver 3.0.0 - START
//    /** 年度 S64 */
//    public static final String YEAR_S64 = "S64";
//    public static final String YEAR_s64 = "s64";
// [DEL] Ver 3.0.0 - END

    /** 郵便番号前方桁数 */
    public static final int POST_LENGTH = 3;
    /** 郵便番号記号 */
    public static final String POST_MARK = "〒";

    /** 住所 初期容量 */
    public static final int ADDRESS_LENGTH = 500;

    /** ハイフン */
    public static final String STR_HYPHEN = "-";
    /** ゼロ値(String) */
    public static final String STR_ZERO = "0";

    /** 報告年月日（日付パターン） **/
    public static final String DATE_PATTERN_YYYY_MM_DD_E = "yyyy年MM月dd日(E)";

    /** 項目名：受託者勘定処理年月（元号） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_GENGO = "drpID_Date_JtkshoriGengou";
    /** 項目名：受託者勘定処理年月（年） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_NEN = "txtID_Date_JtkshoriYear";
    /** 項目名：受託者勘定処理年月（月） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE = "drpID_Date_JtkshoriMonth";
}
