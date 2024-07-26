//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/14 | 木村　しのぶ            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.common;

public class Md002Constants {

    /** 貸付受入金払出・充当報告書取消・修正（入力画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD002_01INIT = "Md002_01Init";
    /** 貸付受入金払出・充当報告書取消・修正（入力結果画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_MD002_01RETURN = "Md002_01Return";
    /** 貸付受入金払出・充当報告書取消・修正（入力結果画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD002_02INIT = "Md002_02Init";
    /** 貸付受入金払出・充当報告書取消・修正（登録結果画面））初期表示コントローラ名 */
    public static final String EVENT_ID_MD002_03INIT = "Md002_03Init";
    /** 報告書取消・修正（照会結果(詳細）画面）戻り表示コントローラ名 */
    public static final String EVENT_ID_MD000_02RETURN = "Md000_02Return";
    /** 報告書取消・修正（照会結果(詳細）画面）初期表示コントローラ名 */
    public static final String EVENT_ID_MD000_02INIT = "Md000_02Init";
    /** 遷移パラメータ(報告年月日) */
    public static final String PROPERTY_ID_REPORT_DATE_REPORT = "ID_Date_Report";
    /** 遷移パラメータ(報告書番号) */
    public static final String PROPERTY_ID_REPORT_ID_REPORT = "ID_ID_Report";
    /** 遷移パラメータ(処理モード) */
    public static final String PROPERTY_ID_REPORT_PROCESS_MODE = "ProcessMode";
    /** 遷移パラメータ(ステータス) */
    public static final String PROPERTY_ID_STATUS = "ID_Status";
    /** 遷移パラメータ(MD002_02DTO) */
    public static final String PROPERTY_MD002_02DTO = "Md002_02DTO";
    /** 赤データ入力領域 */
    public static final String FORM_NAME_REDAREA = "redArea";
    /** 黒データ入力領域 */
    public static final String FORM_NAME_BLACKAREA = "blackArea";
    /** 更正 赤 */
    public static final String FORM_HEAD_RED = "lblID_Head_Red2";
    /** 赤表示 */
    public static final String RED_VISIBLE = "Visible";
    /** 文字：0 */
    public static final String STR_ZERO = "0";
    /** モードタイプ：生成・作成 */
    public static final String MODE_TYPE_CREATE = "1";
    /** モードタイプ：更新・変更 */
    public static final String MODE_TYPE_UPDATE = "2";
    /** 赤領域 */
    public static final String ID_RED_AREA = "formRedArea";
    /** 黒領域 */
    public static final String ID_BLACK_AREA = "formBlackArea";
    /** パネル内のヘッダー表示切替 更正 */
    public static final String PANEL_HEADER_KOUSEI = "更正";
    /** パネル内のヘッダー表示切替 更正黒 */
    public static final String PANEL_HEADER_KOUSEI_BLACK = "更正 黒";
    /** パネル内のヘッダー表示切替 取消内容 */
    public static final String PANEL_HEADER_TORIKESHI = "取消内容";
    /** パネル内のヘッダー表示切替 修正内容 */
    public static final String PANEL_HEADER_SHUSEI = "修正内容";
    /** エラー追加情報:(取消内容) */
    public static final String ERR_ADD_INFO_TORIKESHI = "取消内容：";
    /** エラー追加情報:(更正赤) */
    public static final String ERR_ADD_INFO_KOUSEI_RED = "更正 赤：";
    /** エラー追加情報:(修正内容) */
    public static final String ERR_ADD_INFO_SHUSEI = "修正内容：";
    /** エラー追加情報:(更正黒) */
    public static final String ERR_ADD_INFO_KOUSEI_BLACK = "更正 黒：";
    /** プロパティ名称 完了画面メッセージ表示要フラグ */
    public static final String PROPERTY_FLG_SEIKYUUPDATE = "flgSeikyuUpdate";
}
