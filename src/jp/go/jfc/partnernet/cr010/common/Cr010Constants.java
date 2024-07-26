//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr010Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/10 | 林　晃平              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr010.common;

/**
 * <pre>
 * このクラスはcr010用定数クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr010Constants {

    /** 資金交付依頼予定表（月間）登録（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_CR010_01INIT = "Cr010_01Init";

    /** 金額上限桁数 12桁 */
    public static final int MONEY_MAX_DIGIT = 12;

    /** 交付日（日）プルダウン初期値 */
    public static final String INIT_KOFUDATE = "";

    /** 登録期限時刻：12:00:00 */
    public static final String LIMIT_TIME_120000 = "12:00:00";
    /** 登録期限時刻：13:00:00 */
    public static final String LIMIT_TIME_130000 = "13:00:00";
}
