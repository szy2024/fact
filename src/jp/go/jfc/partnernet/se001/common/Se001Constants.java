//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/14 | 小林　浩二            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * このクラスはse001用定数クラスです。
 * </pre>
 *
 * @author 富士通)
 * @version 1.0.0
 */

public class Se001Constants {

    /** 顧客情報照会（顧客名検索画面）表示コントローラ名 */
    public static final String EVENT_ID_SE001_01INIT = "Se001_01Init";

    /** 顧客情報照会（顧客候補検索結果画面）表示コントローラ名 */
    public static final String EVENT_ID_SE001_02INIT = "Se001_02Init";

    /** 顧客情報照会（顧客情報照会（照会結果画面））表示コントローラ名 */
    public static final String EVENT_ID_SE001_03INIT = "Se001_03Init";

    /** 顧客情報照会（顧客名検索画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_SE001_01RETURN = "Se001_01ReturnController";

    /** 顧客情報照会（顧客候補検索結果画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_SE001_02RETURN = "Se001_02ReturnController";

    /** 顧客情報照会（顧客情報照会（照会結果画面））戻り表示コントローラ名 */
    public static final String EVENT_ID_SE001_03RETURN = "Se001_03ReturnController";

    /** 遷移パラメータ(顧客名入力値) */
    public static final String PROPERTY_IN_NAME_CUSTOMER = "se001_02_In_Name_Customer";

    /** 遷移パラメータ(扱店コード選択値) */
    public static final String PROPERTY_IN_CODE_ORGANIZATION = "se001_03_In_Code_Organization";

    /** 遷移パラメータ(貸付先コード選択値) */
    public static final String PROPERTY_IN_CODE_CUSTOMER = "se001_03_In_Code_Customer";

    /** 明細テーブル */
    public static final String PROPERTY_02M1_TABLE = "se001_02M1Table";
    public static final String PROPERTY_03M1_TABLE = "se001_03M1Table";

    /** 郵便番号マーク〒 */
    public static final String STR_POSTAL_MARK = "〒";

    /** 郵便番号半角ハイフン */
    public static final String STR_POSTAL_SEPARATOR = "-";

    /** 文字：1 */
    public static final String CHAR_1 = "1";
    /** 0桁 */
    public static final int LENGTH_0 = 0;
    /** 2桁 */
    public static final int LENGTH_2 = 2;
    /** 3桁 */
    public static final int LENGTH_3 = 3;
    /** 4桁 */
    public static final int LENGTH_4 = 4;
    /** 5桁 */
    public static final int LENGTH_5 = 5;
    /** 20桁 */
    public static final int LENGTH_20 = 20;

    /** 昭和64年 */
    public static final String S_64 = "S64";
    /** 扱店コード:9937 */
    public static final String CODE_ORGANIZATION_9937 = "9937";
    /** 注意喚起メッセージ① インデックス */
    public static final int INDEXLBLATTENTIONMESSAGE_1 = 0;
    /** 注意喚起メッセージ② インデックス */
    public static final int INDEXLBLATTENTIONMESSAGE_2 = 1;
    /** 注意喚起メッセージ③ インデックス */
    public static final int INDEXLBLATTENTIONMESSAGE_3 = 2;
    /** 注意喚起メッセージ④ インデックス */
    public static final int INDEXLBLATTENTIONMESSAGE_4 = 3;
    /** 注意喚起メッセージ⑤ インデックス */
    public static final String KUBUN_TOKURI_8 = "8";
    /** 注意喚起メッセージ⑥ インデックス */
    public static final String KUBUN_TOKURI_9 = "9";
    /** 利息計算用 */
    public static final java.math.BigDecimal RISOKU_1000 = new BigDecimal("1000.0");
    /** 年度2文字目のインデックス */
    public static final int INDEX_1_YEAR = 1;
    /** 方式資金の上２桁目のインデックス */
    public static final int INDEX_1_HOSHIKISHIKIN = 1;
    /** 方式資金の上３桁目のインデックス */
    public static final int INDEX_2_HOSHIKISHIKIN = 2;
    /** 償還方法コード２桁目のインデックス */
    public static final int INDEX_1_SHOKANHOUHOU = 1;
    /** 年度の先頭１文字目 */
    public static final List<String> LIST_GANGOU_KIGOU = Arrays
            .asList("M", "T", "S", "H", "m", "t", "s", "h");
    /** 日付の開始インデックス */
    public static final int INDEX_DAY_START = 2;

}