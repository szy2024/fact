package jp.go.jfc.partnernet.common.web.intercept;

/**
 * <pre>
 * このクラスはHeaderInfoInterceptの定数クラスです。
 * </pre>
 *
 * @author
 * @version 1.0.0
 */
public class HeaderInfoConstants {

    /** ヘッダーメニューボタン お知らせ */
    public static final String HEADER_BTN_MENU_INFO = "btnMenuInfo";

    /** ヘッダーメニューボタン 報告書作成 */
    public static final String HEADER_BTN_MENU_CREATE = "btnMenuCreate";

    /** ヘッダーメニューボタン 報告書取消・修正 */
    public static final String HEADER_BTN_MENU_UPDATE = "btnMenuUpdate";

    /** ヘッダーメニューボタン 照会 */
    public static final String HEADER_BTN_MENU_INQUIRY = "btnMenuInquiry";

    /** ヘッダーメニューボタン システム運用 */
    public static final String HEADER_BTN_MENU_SYSMAN = "btnMenuSysman";

    /** 日付パターン（HH:mm:ss） */
    public static final String DATE_PATTERN_HHMMSS = " HH:mm:ss";

    /** 表示フラグ */
    public static final String VISIBLE_FLG_ON = "1";

    /** 配列要素 */
    public static final int MENU_DISP_INDEX_0 = 0;
    public static final int MENU_DISP_INDEX_1 = 1;
    public static final int MENU_DISP_INDEX_2 = 2;
    public static final int MENU_DISP_INDEX_3 = 3;
    public static final int MENU_DISP_INDEX_4 = 4;

    /** 区切り文字（カンマ） */
    public static final String DELIMITER_COMMA = ",";

    /** application.propertiesID メニュー制御情報 */
    public static final String PROPERTY_ROLE_ID_10 = "menu_role_10";
    public static final String PROPERTY_ROLE_ID_20 = "menu_role_20";
    public static final String PROPERTY_ROLE_ID_30 = "menu_role_30";
    public static final String PROPERTY_ROLE_ID_40 = "menu_role_40";

    /** application.propertiesID メニュー自画面情報 */
    public static final String PROPERTY_MENUSCREEN_ID_10 = "menu_screen_id_10";
    public static final String PROPERTY_MENUSCREEN_ID_20 = "menu_screen_id_20";
    public static final String PROPERTY_MENUSCREEN_ID_30 = "menu_screen_id_30";
    public static final String PROPERTY_MENUSCREEN_ID_40 = "menu_screen_id_40";
    public static final String PROPERTY_MENUSCREEN_ID_50 = "menu_screen_id_50";

    /** ボタンカラー オレンジ */
    public static final String PROPERTY_COLOR_ORANGE = "#FF9933";
    /** ボタンカラー 青 */
    public static final String PROPERTY_COLOR_BLUE = "#3399FF";
    /** 初期設定日付 */
    public static final String INIT_TIMESTAMP = "M33.1.1 00:00:00";
    /** 前回ログインなし時 */
    public static final String LAST_LOGON_TIMESTAMP_NONE = "なし";

    /* 権限チェック用画面IDプレフィックス */
    /** レベル１：報告書作成画面系(cr*) */
    public static final String SCREEN_CATE_L1_CR = "cr";
    /** レベル１：報告書取消・修正画面系(md*) */
    public static final String SCREEN_CATE_L1_MD = "md";
    /** レベル１：照会画面系(se*) */
    public static final String SCREEN_CATE_L1_SE = "se";
    /** レベル１：ログオン・メニュー系(cm*) */
    public static final String SCREEN_CATE_L1_CM = "cm";
    /** レベル１：利用者メンテナンス画面系(um*) */
    public static final String SCREEN_CATE_L1_UM = "um";
    /** レベル１：お知らせ画面系、通知文書登録画面系、文書削除・登録画面系(ut*) */
    public static final String SCREEN_CATE_L1_UT = "ut";
    /** レベル２：顧客情報照会画面系(se001*) */
    public static final String SCREEN_CATE_L2_SE001 = "se001";
    /** レベル２：実行未了・払出未了案件一覧画面系(se002*) */
    public static final String SCREEN_CATE_L2_SE002 = "se002";
    /** レベル２：債権情報照会画面(se003*) */
    public static final String SCREEN_CATE_L2_SE003 = "se003";
    /** レベル２：払込案内画面系(se004*) */
    public static final String SCREEN_CATE_L2_SE004 = "se004";
    /** レベル２：債権一覧画面系(se005*) */
    public static final String SCREEN_CATE_L2_SE005 = "se005";
    /** レベル２：報告書情報照会画面系(se006*) */
    public static final String SCREEN_CATE_L2_SE006 = "se006";
    /** レベル２：償還予定表画面系(se007*) */
    public static final String SCREEN_CATE_L2_SE007 = "se007";
    /** レベル２：回収予定債権一覧画面系(se008*) */
    public static final String SCREEN_CATE_L2_SE008 = "se008";
    /** レベル２：控除利息計算シミュレーション画面系(se009*) */
    public static final String SCREEN_CATE_L2_SE009 = "se009";
    /** レベル２：繰上償還利息計算シミュレーション画面系(se010*) */
    public static final String SCREEN_CATE_L2_SE010 = "se010";
    /** レベル２：元利金受入・充当報告書報告未了一覧画面系(se011*) */
    public static final String SCREEN_CATE_L2_SE011 = "se011";
    /** レベル２：ログオン画面系(cm001*) */
    public static final String SCREEN_CATE_L2_CM001 = "cm001";
    /** レベル２：メニュー画面系(cm002*) */
    public static final String SCREEN_CATE_L2_CM002 = "cm002";
    /** レベル２：貸付実行報告書作成画面系（cr001*） */
    public static final String SCREEN_CATE_L2_CR001 = "cr001";
    /** レベル２：貸付受入金払出・充当報告書作成画面系（cr002*） */
    public static final String SCREEN_CATE_L2_CR002 = "cr002";
    /** レベル２：元利金受入・充当報告書作成画面系（cr003*） */
    public static final String SCREEN_CATE_L2_CR003 = "cr003";
    /** レベル２：繰上償還受入・充当報告書作成画面系（cr004*） */
    public static final String SCREEN_CATE_L2_CR004 = "cr004";
    /** レベル２：代位弁済金払込・充当報告書作成画面系（cr005*） */
    public static final String SCREEN_CATE_L2_CR005 = "cr005";
    /** レベル２：立替金受入・充当報告書作成画面系（cr006*） */
    public static final String SCREEN_CATE_L2_CR006 = "cr006";
    /** レベル２：仮受金（一般口）受入報告書作成画面系（cr008*） */
    public static final String SCREEN_CATE_L2_CR008 = "cr008";
    /** レベル２：留置期間利息・代弁遅延損害金受入充当報告書作成画面系（cr009*） */
    public static final String SCREEN_CATE_L2_CR009 = "cr009";
    /** レベル２：資金交付依頼予定表（月間）登録画面系（cr010*） */
    public static final String SCREEN_CATE_L2_CR010 = "cr010";
    /** レベル２：資金交付依頼書（週間）登録画面系（cr011*） */
    public static final String SCREEN_CATE_L2_CR011 = "cr011";
    /** レベル２：包括委任状等の交付依頼登録画面系（cr012*） */
    public static final String SCREEN_CATE_L2_CR012 = "cr012";
    /** レベル２：（根）抵当権抹消に係る報告登録画面系（cr013*） */
    public static final String SCREEN_CATE_L2_CR013 = "cr013";
    /** レベル２：報告書検索画面系（md000*） */
    public static final String SCREEN_CATE_L2_MD000 = "md000";
    /** レベル２：貸付実行報告書取消・修正画面系（md001*） */
    public static final String SCREEN_CATE_L2_MD001 = "md001";
    /** レベル２：貸付受入金払出・充当報告書取消・修正画面系（md002*） */
    public static final String SCREEN_CATE_L2_MD002 = "md002";
    /** レベル２：元利金受入・充当報告書取消・修正画面系（md003*） */
    public static final String SCREEN_CATE_L2_MD003 = "md003";
    /** レベル２：繰上償還受入・充当報告書取消・修正画面系（md004*） */
    public static final String SCREEN_CATE_L2_MD004 = "md004";
    /** レベル２：代位弁済金払込・充当報告書取消・修正画面系（md005*） */
    public static final String SCREEN_CATE_L2_MD005 = "md005";
    /** レベル２：立替金受入・充当報告書取消・修正画面系（md006*） */
    public static final String SCREEN_CATE_L2_MD006 = "md006";
    /** レベル２：仮受金（一般口）受入報告書取消・修正画面系（md008*） */
    public static final String SCREEN_CATE_L2_MD008 = "md008";
    /** レベル２：留置期間利息・代弁遅延損害金受入充当報告書取消・修正画面系（md009*） */
    public static final String SCREEN_CATE_L2_MD009 = "md009";
    /** レベル２：資金交付依頼予定表（月間）取消・修正画面系（md010*） */
    public static final String SCREEN_CATE_L2_MD010 = "md010";
    /** レベル２：資金交付依頼書（週間）取消・修正画面系（md011*） */
    public static final String SCREEN_CATE_L2_MD011 = "md011";
    /** レベル２：包括委任状等の交付依頼取消・修正画面系（md012*） */
    public static final String SCREEN_CATE_L2_MD012 = "md012";
    /** レベル２：（根）抵当権抹消に係る報告取消・修正画面系（md013*） */
    public static final String SCREEN_CATE_L2_MD013 = "md013";
    /** レベル２：お知らせ画面系(ut001*) */
    public static final String SCREEN_CATE_L2_UT001 = "ut001";
    /** レベル２：通知内容登録画面系(ut002*) */
    public static final String SCREEN_CATE_L2_UT002 = "ut002";
    /** レベル２：文書ファイル削除画面系(ut003*) */
    public static final String SCREEN_CATE_L2_UT003 = "ut003";
    /** レベル２：文書ファイル登録画面系(ut004*) */
    public static final String SCREEN_CATE_L2_UT004 = "ut004";
    /** 報告書作成メニュー画面(cm002_02) */
    public static final String SCREEN_ID_CM002_02 = "cm002_02";
    /** システム運用メニュー画面(cm002_04) */
    public static final String SCREEN_ID_CM002_04 = "cm002_04";
    /** 報告書情報照会（報告書履歴検索画面）(se006_01) */
    public static final String SCREEN_ID_SE006_01 = "se006_01";
    /** 報告書情報照会（報告書履歴検索結果画面）(se006_02) */
    public static final String SCREEN_ID_SE006_02 = "se006_02";
    /** 報告書情報照会（報告書内容照会結果画面）(se006_04) */
    public static final String SCREEN_ID_SE006_04 = "se006_04";
    /** 報告書情報照会（貸付実行報告書照会結果画面）(se006_05) */
    public static final String SCREEN_ID_SE006_05 = "se006_05";
    /** 報告書情報照会（貸付受入金払出・充当報告書照会結果画面）(se006_06) */
    public static final String SCREEN_ID_SE006_06 = "se006_06";
    /** 報告書情報照会（元利金受入・充当報告書照会結果画面）(se006_07) */
    public static final String SCREEN_ID_SE006_07 = "se006_07";
    /** 報告書情報照会（繰上償還受入・充当報告書照会結果画面(se006_08）) */
    public static final String SCREEN_ID_SE006_08 = "se006_08";
    /** 報告書情報照会（代位弁済金払込・充当報告書照会結果画面）(se006_09) */
    public static final String SCREEN_ID_SE006_09 = "se006_09";
    /** 報告書情報照会（立替金受入・充当報告書照会結果画面）(se006_10) */
    public static final String SCREEN_ID_SE006_10 = "se006_10";
    /** 報告書情報照会（仮受金（一般口）受入報告書照会結果画面）(se006_12) */
    public static final String SCREEN_ID_SE006_12 = "se006_12";
    /** 報告書情報照会（留置期間利息・代弁遅延損害金受入充当報告書照会結果画面）(se006_13) */
    public static final String SCREEN_ID_SE006_13 = "se006_13";
    /** 報告書情報照会（資金交付依頼予定表（月間）画面）(se006_14) */
    public static final String SCREEN_ID_SE006_14 = "se006_14";
    /** 報告書情報照会（資金交付依頼書（週間）画面）(se006_15) */
    public static final String SCREEN_ID_SE006_15 = "se006_15";
    /** 報告書情報照会（包括委任状等の交付依頼画面）(se006_16) */
    public static final String SCREEN_ID_SE006_16 = "se006_16";
    /** 報告書情報照会（（根）抵当権抹消に係る報告画面）(se006_17) */
    public static final String SCREEN_ID_SE006_17 = "se006_17";

    /** システムエラーメッセージ(unauthorized access) */
    public static final String MESSAGE_UNAUTORIZED_ACCESS = "unauthorized access";
    /** システムエラーメッセージ(未実装の画面IDが指定されました) */
    public static final String MESSAGE_UNDIFINED_SCREEN_ID = "未実装の画面IDが指定されました";
}
