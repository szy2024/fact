//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.common;

public class Ut003Constants {

    /** 通知・事務連絡 */
    public static final String ID_INFOTYPE_TSUCHIJIMU = "1";
    /** 金利改定情報 */
    public static final String ID_INFOTYPE_KINRIJYOHO = "2";
    /** 要領・マニュアルの改定情報 */
    public static final String ID_INFOTYPE_YORYOMANUAL = "3";
    /** 様式集の改正情報 */
    public static final String ID_INFOTYPE_YOSHIKI = "4";

    /** FileUtil ファイルセパレータ */
    public static final String FILESEPARATOR_PROPERTY_NAME = "separateCharacter.path";
    /** 通知・事務連絡 */
    public static final String DOWNLOAD_PATH_TSUCHIJIMU = "download.path.TsuchiJimu";
    /** 金利改定情報 */
    public static final String DOWNLOAD_PATH_KINRIJYOHO = "download.path.KinriJyoho";
    /** 要領・マニュアルの改正情報 */
    public static final String DOWNLOAD_PATH_YORYOMANUAL = "download.path.YoryoManual";
    /** 様式集の改正情報 */
    public static final String DOWNLOAD_PATH_YOSHIKI = "download.path.Yoshiki";

// [DEL] Ver 2.0.0 - START
//    /** 年号：平成 */
//    public static final String GENGO_HEISEI = "H";
// [DEL] Ver 2.0.0 - END

    /** 文書ファイル削除（削除文書検索画面 ）：戻る */
    public static final String EVENT_ID_UT003_01BACK = "Ut003_01Back";
    /** 文書ファイル削除（通知・事務連絡文書ファイル削除画面）：初期表示 */
    public static final String EVENT_ID_UT003_02INIT = "Ut003_02Init";
    /** 文書ファイル削除（通知・事務連絡文書ファイル削除画面）：ページング */
    public static final String EVENT_ID_UT003_02PAGEING = "Ut003_02Pageing";
    /** 文書ファイル削除（金利情報文書ファイル削除画面）：初期表示 */
    public static final String EVENT_ID_UT003_03INIT = "Ut003_03Init";
    /** 文書ファイル削除（金利情報文書ファイル削除画面）：ページング */
    public static final String EVENT_ID_UT003_03PAGEING = "Ut003_03Pageing";
    /** 文書ファイル削除（要領・マニュアル文書ファイル削除画面）：初期表示 */
    public static final String EVENT_ID_UT003_04INIT = "Ut003_04Init";
    /** 文書ファイル削除（要領・マニュアル文書ファイル削除画面）：ページング */
    public static final String EVENT_ID_UT003_04PAGEING = "Ut003_04Pageing";
    /** 文書ファイル削除（様式集文書ファイル削除画面）：初期表示 */
    public static final String EVENT_ID_UT003_05INIT = "Ut003_05Init";
    /** 文書ファイル削除（様式集文書ファイル削除画面）：ページング */
    public static final String EVENT_ID_UT003_05PAGEING = "Ut003_05Pageing";

// [ADD] Ver 2.0.0 - START
    /** 遷移パラメータ(検索開始元号) */
    public static final String PROPERTY_ID_SEARCHSTARTGENGO = "ID_SearchStartGengo";
// [ADD] Ver 2.0.0 - END
    /** 遷移パラメータ(検索開始年（和暦）) */
    public static final String PROPERTY_ID_SEARCHSTARTYEAR = "ID_SearchStartYear";
    /** 遷移パラメータ(検索開始月) */
    public static final String PROPERTY_ID_SEARCHSTARTMONTH = "ID_SearchStartMonth";
    /** 遷移パラメータ(検索開始日) */
    public static final String PROPERTY_ID_SEARCHSTARTDATE = "ID_SearchStartDate";
// [ADD] Ver 2.0.0 - START
    /** 遷移パラメータ(検索終了元号) */
    public static final String PROPERTY_ID_SEARCHENDGENGO = "ID_SearchEndGengo";
// [ADD] Ver 2.0.0 - END
    /** 遷移パラメータ(検索終了年（和暦）) */
    public static final String PROPERTY_ID_SEARCHENDYEAR = "ID_SearchEndYear";
    /** 遷移パラメータ(検索終了月) */
    public static final String PROPERTY_ID_SEARCHENDMONTH = "ID_SearchEndMonth";
    /** 遷移パラメータ(検索終了日) */
    public static final String PROPERTY_ID_SEARCHENDDATE = "ID_SearchEndDate";
    /** 遷移パラメータ：メッセージID */
    public static final String PROPERTY_MSG_ID = "messageId";
}
