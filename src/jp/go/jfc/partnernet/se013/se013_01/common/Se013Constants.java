//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.common;

/**
 * このクラスはSe012のConstantsクラスです。
 * @author 宮郷　慎之介
 *
 */
public class Se013Constants {

    /** 扱店コード 桁数 */
    public static final int CODE_ORGANIZATION_FULL_LENGTH = 4;
    /** 検索年 最大桁数 */
    public static final int SEARCH_YEAR_MAX_LENGTH = 4;
    /** 検索月 最大桁数 */
    public static final int SEARCH_MONTH_MAX_LENGTH = 2;

    /** 農林中金扱店コード */
    public static final String Code_Organization_3000 = "3000";

    /** 農林中金（本店）店舗コード */
    public static final String CODE_TENPO_NOURINCHUKIN_HONTEN = "958";

    /** 扱店コード */
    public static final String LBLID_CODE_ORGANIZATION = "lblid_code_organization";
    /** 扱店名 */
    public static final String LBLID_NAME_ORGANIZATION = "lblid_name_organization";
    /** 店舗コード */
    public static final String LBLID_CODE_TENPO = "lblid_code_tenpo";
    /** 店舗名 */
    public static final String LBLID_NAME_TENPO = "lblid_name_tenpo";
    /** 情報提供日 */
    public static final String LBLID_DATE_JYOHOTEIKYO = "lblid_date_jyohoteikyo";
    /** 対象年月 */
    public static final String LBLID_DATE_TAISHO = "lblid_date_taisho";
    /** 検索条件_検索扱店コード */
    public static final String LBLID_KEEP_SRCCODE_ORGANIZATION = "lblid_keep_srccode_organization";

    /** Ｃ・Ｄ方式モード */
    public static final String SQL_ROLE_MODE_CDHOUSHIKI = "0";
    /** Ｈ方式受託店モード */
    public static final String SQL_ROLE_MODE_HHOUSHIKI = "1";
    /** 農林中金モード */
    public static final String SQL_ROLE_MODE_NOURIN = "2";
}
