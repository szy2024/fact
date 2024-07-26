//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
// 2.0.0   | 2019/01/29 | 坂　竜太              | 農林PN元号対応
// 4.0.0   | 2020/11/30 | 番場　千沙都          | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.se009.common;

import java.math.BigDecimal;

public class Se009Constants {

    /** 控除利息入力 戻り表示コントローラ名 */
    public static final String EVENT_ID_SE009_01RETURN = "Se009_01Return";
    /** 控除利息結果 初期表示コントローラ名 */
    public static final String EVENT_ID_SE009_02INIT = "Se009_02Init";
    /** 扱店コード:農協 */
    public static final String CODE_ORGANIZATION_NOUKYOU = "9937";
    /** 受渡項目 控除利息計算結果エラー */
    public static final String ERROR_KOUJORISOKU = "se009_error_koujorisoku";
    /** 控除利息計算エラー時の戻り値 */
    public static final BigDecimal ERROR_KOUJORISOKU_VALUE = new BigDecimal(-1);
	// [ADD] Ver 4.0.0 - START -
	/** 受渡項目 約定利息計算結果エラー */
	public static final String ERROR_YAKUJORISOKU = "se009_error_yakujorisoku";
	/** 約定利息計算エラー時の戻り値 */
	public static final BigDecimal ERROR_YAKUJORISOKU_VALUE = new BigDecimal(-1);
	// [ADD] Ver 4.0.0 - END -

    /** 年度の対象元号 */
    public static final String TARGET_YEAR_GENGOU = "MTSHmtsh";
// [DEL] Ver 2.0.0 - START
//    /** 資金払出または元金充当日の対象元号 */
//    public static final String TARGET_HARAIDASHIGANJU_GENGOU = "SHsh";
// [DEL] Ver 2.0.0 - END
    /** 年度の先頭２、３文字目 */
    public static final String YEAR_00 = "00";
// [DEL] Ver 2.0.0 - START
//    /** 年度 S64 */
//    public static final String YEAR_S64 = "S64";
//    public static final String YEAR_s64 = "s64";
//    /** 元号 昭和 */
//    public static final String GENGOU_SYOUWA = "昭和";
//    /** 元号 昭和 英文字 */
//    public static final String GENGOU_SYOUWA_EN = "S";
//    /** 元号 平成 */
//    public static final String GENGOU_HEISEI = "平成";
//    /** 元号 平成 英文字 */
//    public static final String GENGOU_HEISEI_EN = "H";
//
//    /** 年 */
//    public static final String YEAR = "年";
//    /** 月 */
//    public static final String MONTH = "月";
//    /** 日 */
//    public static final String DATE = "日";
// [DEL] Ver 2.0.0 - END

    /** 受渡項目 公庫支店コード */
    public static final String PROPERTY_CODE_SHOKANHONSHITEN = "drpID_Code_ShokanHonShiten";
    /** 受渡項目 扱店コード */
    public static final String PROPERTY_CODE_ORGANIZATION = "txtID_Code_Organization";
    /** 受渡項目 店舗コード */
    public static final String PROPERTY_CODE_TENPO = "txtID_Code_Tenpo";
    /** 受渡項目 年度 */
    public static final String PROPERTY_YEAR = "txtID_Year";
    /** 受渡項目 方式資金 */
    public static final String PROPERTY_HOSHIKISHIKIN = "txtID_HoshikiShikin";
    /** 受渡項目 番号 */
    public static final String PROPERTY_RINGI = "txtID_ID_Ringi";
    /** 受渡項目 枝番 */
    public static final String PROPERTY_RINGIBRANCH = "txtID_ID_RingiBranch";

    /** 受渡項目 資金払出または元金充当日(元号) */
    public static final String PROPERTY_ID_START_WAREKI = "ID_SearchStartWareki";
    /** 受渡項目 資金払出または元金充当日(年) */
    public static final String PROPERTY_ID_START_YEAR = "ID_SearchStartYear";
    /** 受渡項目 資金払出または元金充当日(月) */
    public static final String PROPERTY_ID_START_MONTH = "ID_SearchStartMonth";
    /** 受渡項目 資金払出または元金充当日(日) */
    public static final String PROPERTY_ID_START_DATE = "ID_SearchStartDate";
    /** 受渡項目 資金払出額 */
    public static final String PROPERTY_ID_HARAIDASHI = "txtID_M_Haraidashi";
    /** 受渡項目 元金充当額 */
    public static final String PROPERTY_ID_GANJU = "txtID_M_Ganju";

}
