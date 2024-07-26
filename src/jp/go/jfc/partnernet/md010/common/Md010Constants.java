//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md010Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/10 | 林　晃平              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md010.common;

/**
 * <pre>
 * このクラスはmd010用定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md010Constants {

    /** 資金交付依頼予定表（月間）取消・修正（入力画面）：初期表示 */
    public static final String EVENT_ID_MD010_01INIT = "Md010_01Init";
    /** 報告書検索結果画面：初期表示 */
    public static final String EVENT_ID_MD000_02INIT = "Md000_02Init";
    /** 報告書検索結果画面：戻る */
    public static final String EVENT_ID_MD000_02RETURN = "Md000_02Return";

    /** 遷移パラメータ(報告書種別(値)) */
    public static final String PROPERTY_ID_BIZJOINITEM_DATACODE = "ID_BizJoinItem_DataCode";
    /** 遷移パラメータ(報告書種別) */
    public static final String PROPERTY_ID_DATACODE = "ID_DataCode";
    /** 遷移パラメータ(検索タイプ) */
    public static final String PROPERTY_ID_SEARCH_TYPE = "searchType";

    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(処理モード) */
    public static final String PROPERTY_ID_PROCESS_MODE = "ProcessMode";

    /** 検索タイプ：仮受金検索 */
    public static final String SEARCH_TYPE_KARIUKE = "2";

    /** 更新済フラグ：1（更新済） */
    public static final String FLAG_KOUSHINZUMI = "1";

    /** 金額上限桁数 12桁 */
    public static final int MONEY_MAX_DIGIT = 12;

    /** 交付日（日）プルダウン初期値 */
    public static final String INIT_KOFUDATE = "";

    /** 項目名：明細一覧 */
    public static final String ITEMNAME_RECORDLIST = "md010_01m1Table.recordList[";
    /** 項目名：交付日（日） */
    public static final String ITEMNAME_DRPID_KOFUDATE = "].drpID_KofuDateDate";
    /** 項目名：依頼予定額 */
    public static final String ITEMNAME_TXTID_IRAI = "].txtID_Irai";
    /** 項目名：元金充当額 */
    public static final String ITEMNAME_TXTID_GANJU = "].txtID_Ganju";
    /** 項目名：登録ボタン */
    public static final String ITEMNAME_BTNUPDATE2 = "btnUpdate2";

    /** 登録期限時刻：12:00:00 */
    public static final String LIMIT_TIME_120000 = "12:00:00";
    /** 登録期限時刻：13:00:00 */
    public static final String LIMIT_TIME_130000 = "13:00:00";
}
