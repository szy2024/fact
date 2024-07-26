package jp.go.jfc.partnernet.se008.common;

public class Se008Constants {

    /** 回収予定債権一覧（債権検索画面）初期表示コントローラ名 */
    public static final String EVENT_ID_SE008_01RETURN = "Se008_01Return";
    /** 回収予定債権一覧（照会結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_SE008_02INIT = "Se008_02Init";

    /** 検索開始年月日（年） */
    public static final String DECEMBER = "12";

    /** 検索開始年月日（年） */
    public static final String PROPERTY_SEAECH_START_YEAR = "ID_SearchStartYear";
    /** 検索開始年月日（月） */
    public static final String PROPERTY_SEAECH_START_MONTH = "ID_SearchStartMonth";
    /** 検索開始年月日（日） */
    public static final String PROPERTY_SEAECH_START_DATE = "ID_SearchStartDate";
    /** 検索終了年月日（年） */
    public static final String PROPERTY_SEAECH_END_YEAR = "ID_SearchEndYear";
    /** 検索終了年月日（月） */
    public static final String PROPERTY_SEAECH_END_MONTH = "ID_SearchEndMonth";
    /** 検索終了年月日（日） */
    public static final String PROPERTY_SEAECH_END_DATE = "ID_SearchEndDate";

    /** 明細リスト（se008_02M1Table） */
    public static final String PROPERTY_MEISAI_LIST = "se008_02M1Table";
    /** 約定利息計 */
    public static final String PROPERTY_YAKUJO_RISOKU_KEI = "lblID_M_YakujoRisokuKEI";
    /** 約定元金計 */
    public static final String PROPERTY_YAKUJO_GANKIN_KEI = "lblID_M_YakujoGankinKEI";
    /** 控除利息計 */
    public static final String PROPERTY_KOJO_RISOKU_KEI = "lblID_M_KojoRisokuKEI";
    /** 請求繰上償還元金計 */
    public static final String PROPERTY_SEIKURI_GANKIN_KEI = "lblID_M_SeiKuriGankinKEI";
    /** 請求繰上償還利息計 */
    public static final String PROPERTY_SEIKURI_RISOKU_KEI = "lblID_M_SeiKuriRisokuKEI";
    /** 任意繰上償還利息計 */
    public static final String PROPERTY_NINI_RISOKU_KEI = "lblID_M_NiniRisokuKEI";

    /** 稟議番号枝番 0 */
    public static final String DISPLAY_EDA_CHEACK_ZERO = "0";
    /** 稟議番号枝番 ブランク */
    public static final String DISPLAY_EDA_CHEACK_BLANK = "";
}
