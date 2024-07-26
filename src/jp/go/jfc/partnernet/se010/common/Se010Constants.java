//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/29 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.common;

/**
 * <pre>
 * このクラスはse010用定数クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010Constants {

	/** 繰上償還利息等計算シミュレーション（条件入力画面）初期表示コントローラ名 */
	public static final String EVENT_ID_SE010_01INIT = "Se010_01Init";
	/** 繰上償還利息等計算シミュレーション（照会結果画面）初期表示コントローラ名 */
	public static final String EVENT_ID_SE010_02INIT = "Se010_02Init";
	/** 繰上償還利息等計算シミュレーション（条件入力画面） 戻り表示コントローラ名 */
	public static final String EVENT_ID_SE010_01RETURN = "Se010_01Return";
	/** 受渡項目 繰上償還利息等計算結果エラー */
	public static final String ERROR_KURISHO = "se010_error_kurisho";

	/** 計算エラー */
	public static final String ERROR_CODE = "-1";
	/** 計算結果0 */
	public static final String CALC_ZERO = "0";

	/** 手数料計算あり */
	public static final String CALC_TESURYO = "1";
	/** 手数料計算なし */
	public static final String NOT_CALC_TESURYO = "0";

	/** 調整コードなし */
	public static final String NOT_CHOSEI = "0";
	/** 調整コード初回 */
	public static final String CHOSEI_FIRST = "1";
	/** 調整コード最終回 */
	public static final String CHOSEI_LAST = "2";

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
	public static final String PROPERTY_ID_RINGI = "txtID_ID_Ringi";
	/** 受渡項目 枝番 */
	public static final String PROPERTY_ID_RINGIBRANCH = "txtID_ID_RingiBranch";
	/** 受渡項目 繰上償還日(元号) */
	public static final String PROPERTY_KURIAGESHOKAN_WAREKI = "drpID_Date_KuriageShokan_Wareki";
	/** 受渡項目 繰上償還日(年) */
	public static final String PROPERTY_KURIAGESHOKAN_YEAR = "txtID_Date_KuriageShokan_Year";
	/** 受渡項目 繰上償還日(月) */
	public static final String PROPERTY_KURIAGESHOKAN_MONTH = "drpID_Date_KuriageShokan_Month";
	/** 受渡項目 繰上償還日(日) */
	public static final String PROPERTY_KURIAGESHOKAN_DATE = "drpID_Date_KuriageShokan_Date";
	/** 受渡項目 繰上償還額 */
	public static final String PROPERTY_M_KURIAGESHOKAN = "txtID_M_KuriageShokan";
	/** 受渡項目 繰償後第一回払込期日(元号) */
	public static final String PROPERTY_FIRSTHARAIKOMIAFTERKURIS_WAREKI = "drpID_Date_FirstHaraikomiAfterKuriS_Wareki";
	/** 受渡項目 繰償後第一回払込期日(年) */
	public static final String PROPERTY_FIRSTHARAIKOMIAFTERKURIS_YEAR = "txtID_Date_FirstHaraikomiAfterKuriS_Year";
	/** 受渡項目 繰償後第一回払込期日(月) */
	public static final String PROPERTY_FIRSTHARAIKOMIAFTERKURIS_MONTH = "drpID_Date_FirstHaraikomiAfterKuriS_Month";
	/** 受渡項目 繰償後第一回払込期日(日) */
	public static final String PROPERTY_FIRSTHARAIKOMIAFTERKURIS_DATE = "drpID_Date_FirstHaraikomiAfterKuriS_Date";
	/** 受渡項目 手数料計算 */
	public static final String PROPERTY_TESURYO = "radioID_Tesuryo";
	/** 受渡項目 繰償時利率 */
	public static final String PROPERTY_KURISHOJIRIRITSU = "txtID_KurishojiRiritsu";
	/** 受渡項目 繰償事由コード */
	public static final String PROPERTY_CODE_KURISHOJIYU = "drpID_Code_KurishoJiyu";
	/** 受渡項目 元金均等額 */
	public static final String PROPERTY_M_GANKINKINTO = "txtID_M_Gankinkinto";
	/** 受渡項目 元金不均等額 */
	public static final String PROPERTY_M_GANKINFUKINTO = "txtID_M_Gankinfukinto";
	/** 受渡項目 調整コード */
	public static final String PROPERTY_CODE_CHOSEI = "radioID_Code_Chosei";
	/** 受渡項目 免除対象額 */
	public static final String PROPERTY_M_MENJOTAISHO = "txtID_M_MenjoTaisho";
	/** 受渡項目 免除後元金均等額 */
	public static final String PROPERTY_M_MENJOGOGANKINKINTO = "txtID_M_MenjogoGankinkinto";
	/** 受渡項目 免除後元金不均等額 */
	public static final String PROPERTY_M_MENJOGOGANKINFUKINTO = "txtID_M_MenjogoGankinfukinto";
	/** 受渡項目 免除後調整コード */
	public static final String PROPERTY_CODE_CHOSEI_MENJOGO = "radioID_Code_Chosei_Menjogo";

}
