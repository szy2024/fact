//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001Constants
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/14 | 小林　浩二            | 新規作成
// 2.0.0   | 2017/12/01 | 百々　諒馬            | 委託貸付報告等における機能改善
//==================================================================================================
package jp.go.jfc.partnernet.cr002.common;

/**
 * <pre>
 * このクラスはse001用定数クラスです。
 * </pre>
 *
 * @author 百々　諒馬)
 * @version 2.0.0
 */

public class Cr002Constants {

    /** 貸付受入金払出・充当報告書作成（入力画面）表示コントローラ名 */
    public static final String EVENT_ID_CR002_0INIT = "Cr002_01Init";
    /** 貸付受入金払出・充当報告書作成（入力画面）表示コントローラ名 */
    public static final String EVENT_ID_CR002_02INIT = "Cr002_02Init";
    /** 貸付受入金払出・充当報告書作成（登録結果画面）表示コントローラ名 */
    public static final String EVENT_ID_CR002_03INIT = "Cr002_03Init";
    /** 貸付受入金払出・充当報告書作成（入力画面）戻りコントローラ名 */
    public static final String EVENT_ID_CR002_01RETURN = "Cr002_01Return";
    /** 案件リスト **/
    public static final String MEISAI_ANKENLIST = "cr002_02MEISAI_AnkenLIST";
    /** プロパティ名称 報告年月日 */
    public static final String PROPERTY_ID_DATE_REPORT = "lblID_Date_Report";

    /** プロパティ名称 完了画面メッセージ表示要フラグ */
    public static final String PROPERTY_FLG_SEIKYUUPDATE = "flgSeikyuUpdate";

    /** 項目名：明細一覧 */
    public static final String JSP_ITEM_RECORDLIST = "cr002_01M1Table.recordList[";
    /** 項目名：受託者勘定処理年月（元号） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_GENGO = "].ID_Date_Jtkshori_Gengo";
    /** 項目名：受託者勘定処理年月（年） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORI_NEN = "].ID_Date_Jtkshori_Nen";
    /** 項目名：受託者勘定処理年月（月） */
    public static final String JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE = "].ID_Date_JtkshoriTsuki_Candidate";
}