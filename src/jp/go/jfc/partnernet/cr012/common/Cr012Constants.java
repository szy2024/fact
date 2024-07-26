//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.common;

/**
 * <pre>
 * Cr012の定数クラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Cr012Constants {
    /** 前画面ID */
    public static final String PRESRCEENID_CR012_01 = "cr012_01";

    /** 包括委任状等の交付依頼登録（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR012_01INIT = "Cr012_01Init";

    /** 数量下限 */
    public static final int INT_SURYO_MIN = 0;

    /** 数量上限 */
    public static final int INT_SURYO_MAX = 999;

    /** 包括委任状等の交付依頼登録報告日制御時刻 */
    public static final int INT_TIME_LIMIT = 170000;

    /** 報告日　フォーマット */
    public static final String STR_DATE_FORMAT = "yyyy年MM月dd日";

    /** 文字："年" */
    public static final String STR_YEAR = "年";

    /** 文字："月" */
    public static final String STR_MONTH = "月";

    /** 文字："日" */
    public static final String STR_DAY = "日";

}
