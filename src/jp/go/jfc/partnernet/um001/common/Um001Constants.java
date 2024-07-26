//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 秋澤　修司            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.common;

/**
 * <pre>
 * このクラスはum001用定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Um001Constants {

    /** 初期設定日付 */
    public static final String INIT_TIMESTAMP = "19000101000000000";
    /** 日付パターン（HH:mm:ss） */
    public static final String DATE_PATTERN_HHMMSS = "HH:mm:ss";
    /** 遷移パラメータ：メッセージID */
    public static final String PROPERTY_MSG_ID = "messageId";
    /** 遷移パラメータ：削除件数 */
    public static final String PROPERTY_DEL_CNT = "deleteCount";
    /** 遷移パラメータ：更新件数 */
    public static final String PROPERTY_UPD_CNT = "updateCount";
    /** 遷移パラメータ：ログオンID */
    public static final String PROPERTY_LOGONID = "logonID";
    /** システム設定値：パスワード有効日数 */
    public static final String PROPERTY_VALID_DAYS = "password_default_valid_days";
    /** システム設定値：パスワード試行回数（最大） */
    public static final String PROPERTY_RETRY_CNT_MAX = "password_default_retry_cnt_max";

    /** ステータス：利用中 */
    public static final String STATUS_USE = "0";
    /** ステータス：ロック（試行回数オーバー） */
    public static final String STATUS_LOCK_OVER = "1";
    /** ステータス：利用開始前 */
    public static final String STATUS_USE_BEFORE = "2";
    /** ステータス：パスワード期限切れ */
    public static final String STATUS_EXPIRATION = "3";
    /** 年号：昭和 */
    public static final String GENGO_SHOWA = "S";
// [DEL] Ver 3.0.0 - START
//    /** 年号：平成 */
//    public static final String GENGO_HEISEI = "H";
// [DEL] Ver 3.0.0 - END
    /** 年：６４年 */
    public static final String YEAR_64 = "64";
    /** パスワード初回変更強制フラグ：強制する */
    public static final int FLAG_FORCECHGPWDFISTLOGON_1 = 1;
    /** パスワード定期変更強制フラグ：強制する */
    public static final int FLAG_FORCECHGPWDROUTINE_1 = 1;
    /** 初回ログオンフラグ：初回ログオン */
    public static final int FLAG_FIRSTLOGON_1 = 1;
    /** 操作選択オプション：削除 */
    public static final int OPT_DELETE = 1;
    /** 操作選択オプション：ロック解除 */
    public static final int OPT_LOCK_CLEAR = 2;

    /** 利用者登録画面：初期表示 */
    public static final String EVENT_ID_UM001_01INIT = "Um001_01Init";
    /** 利用者登録画面：戻る */
    public static final String EVENT_ID_UM001_01BACK = "Um001_01Back";
    /** 利用者状態一覧表示画面：アンカー */
    public static final String EVENT_ID_UM001_02ANCRE = "Um001_02Ancre";
    /** 利用者状態一覧表示画面：送信 */
    public static final String EVENT_ID_UM001_02SEND = "Um001_02Send";
    /** 利用者状態一覧表示画面：戻る */
    public static final String EVENT_ID_UM001_02BACK = "Um001_02Back";
    /** 利用者登録内容変更画面：初期表示 */
    public static final String EVENT_ID_UM001_03INIT = "Um001_03Init";
    /** 利用者登録内容変更画面：更新 */
    public static final String EVENT_ID_UM001_03UPDATE = "Um001_03Update";
    /** 利用者登録内容変更画面：戻る */
    public static final String EVENT_ID_UM001_03BACK = "Um001_03Back";

    /** 初期設定日付 */
    public static final String INIT_TIMESTAMP_WAREKI = "M33.1.1 00:00:00";
    /** 前回ログインなし時 */
    public static final String LAST_LOGON_TIMESTAMP_NONE = "なし";

    /** 農林中金（本店）店舗コード */
    public static final String TENPO_CODE_NOURINHONTEN = "958";
}
