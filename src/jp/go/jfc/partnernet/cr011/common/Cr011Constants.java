//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr011Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/10 | 林　晃平              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr011.common;

/**
 * <pre>
 * このクラスはcr011用定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr011Constants {

    /** 資金交付依頼書（週間）登録（入力画面） 初期表示コントローラ名 */
    public static final String EVENT_ID_CR011_01INIT = "Cr011_01Init";

    /** 文字(0) */
    public static final String STR_ZERO = "0";

    /** 金額上限桁数 12桁 */
    public static final int MONEY_MAX_DIGIT = 12;

    /** 備考 最大バイト数 */
    public static final int BIKO_MAX_BYTES = 400;

    /** SJIS */
    public static final String CHARACTER_ENCODING_MS932 = "MS932";

    /** 登録期限時刻：12:00:00 */
    public static final String LIMIT_TIME_120000 = "12:00:00";
    /** 登録期限時刻：13:00:00 */
    public static final String LIMIT_TIME_130000 = "13:00:00";

}
