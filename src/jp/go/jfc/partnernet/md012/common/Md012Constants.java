//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md012Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md012.common;

/**
 * <pre>
 * このクラスはmd012用定数クラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md012Constants {

    /** 報告書検索果画面：初期表示 */
    public static final String EVENT_ID_MD000_02INIT = "Md000_02Init";
    /** 報告書検索結果画面：戻る */
    public static final String EVENT_ID_MD000_02RETURN = "Md000_02Return";

    /** 包括委任状等の交付依頼登録（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD012_01INIT = "Md012_01Init";

    /** 数量下限 */
    public static final int INT_SURYO_MIN = 0;

    /** 数量上限 */
    public static final int INT_SURYO_MAX = 999;

    /** 検索タイプ：仮受金検索 */
    public static final String SEARCH_TYPE_KARIUKE = "2";

    /** 更新済フラグ：1（更新済） */
    public static final String FLAG_KOUSHINZUMI = "1";

    /** 報告日　フォーマット */
    public static final String STR_DATE_FORMAT = "yyyy年MM月dd日";

    /** 文字："年" */
    public static final String STR_YEAR = "年";

    /** 文字："月" */
    public static final String STR_MONTH = "月";

    /** 文字："日" */
    public static final String STR_DAY = "日";

    /** 登録ボタン */
    public static final String PROPERTY_UPDATE_BTN = "btnUpdate2";
    /** 明細部 */
    public static final String FORM_NAME_MD012_01M1TABLE = "md012_01M1Table";
    /** 報告日領域 */
    public static final String FORM_NAME_REPORT_DATE = "reportDate";
    /** 包括委任状数量 */
    public static final String FORM_NAME_SU_HOKATSUININ = "md012_01M1Table.recordList[0].txtID_Su_HokatsuInin";
    /** 現在事項一部証明書数量 */
    public static final String FORM_NAME_SU_GENZAIJIKO = "md012_01M1Table.recordList[0].txtID_Su_GenzaiJiko";
    /** 印鑑証明書数量 */
    public static final String FORM_NAME_SU_INKANSHOHMEI = "md012_01M1Table.recordList[0].txtID_Su_InkanShohmei";
    /** 変更抄本数量 */
    public static final String FORM_NAME_SU_HENKOSHOHON = "md012_01M1Table.recordList[0].txtID_Su_HenkoShohhon";
    /** 新閉鎖謄本数量 */
    public static final String FORM_NAME_SU_SINHEISA = "md012_01M1Table.recordList[0].txtID_Su_SinHeisa";
    /** 旧閉鎖抄本数量 */
    public static final String FORM_NAME_SU_KYUHEISA = "md012_01M1Table.recordList[0].txtID_Su_KyuHeisa";
    /** 閉鎖事項全部証明書数量 */
    public static final String FORM_NAME_SU_HEISAJIKO = "md012_01M1Table.recordList[0].txtID_Su_HeisaJiko";
    /** 至急発行チェックボックス */
    public static final String FORM_NAME_CHK_KYUHAKKO = "md012_01M1Table.recordList[0].chkID_ShikyuHakko";

    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_ID_REPORT_DATE_REPORT = "ID_Date_Report";
    /** 遷移パラメータ(報告時分秒) */
    public static final String PROPERTY_ID_REPORT_TIME_REPORT = "ID_Time_Report";
    /** 遷移パラメータ(報告書種別(値)) */
    public static final String PROPERTY_ID_BIZJOINITEM_DATACODE = "ID_BizJoinItem_DataCode";
    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(処理モード) 操作選択：取消＝3、修正=4 */
    public static final String PROPERTY_ID_PROCESS_MODE = "ProcessMode";

    /** 遷移パラメータ(公庫支店コード) */
    public static final String PROPERTY_KOUKOSHITEN = "code_ShokanHonShiten";
    /** 遷移パラメータ(扱店コード）) */
    public static final String PROPERTY_CODE_ORGANIZATION = "code_Organization";
    /** 遷移パラメータ(店舗コード) */
    public static final String PROPERTY_CODE_TENPO = "code_Tenpo";
    /** 遷移パラメータ(年度) */
    public static final String PROPERTY_YEAR = "year";
    /** 遷移パラメータ(方式資金) */
    public static final String PROPERTY_KUBUN_HOSHIKI = "kubun_Hoshiki";
    /** 遷移パラメータ(番号) */
    public static final String PROPERTY_ID_RINGI = "ID_Ringi";
    /** 遷移パラメータ(枝番）) */
    public static final String PROPERTY_ID_RINGIBRANCH = "ID_RingiBranch";
    /** 遷移パラメータ(報告書種別) */
    public static final String PROPERTY_ID_DATACODE = "ID_DataCode";
    /** 遷移パラメータ(検索タイプ) */
    public static final String PROPERTY_ID_SEARCH_TYPE = "searchType";

}
