//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
// 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcm001_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cm001_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 発生元イベント名 */
    private String eventName;
    /** 利用者ID */
    private String LogonID;
    /** パスワード */
    private String Password;
    /** 利用者名（漢字） */
    private String Name_Kanji;
    /** 扱店コード */
    private String Code_Organization;
    /** 店舗コード */
    private String Code_Tenpo;
    /** 扱店名 */
    private String Name_Organization;
    /** 権限種別 */
    private String RoleCode;
    /** 最終ログオン日時 */
    private java.util.Date DateTime_LastLogon;
    /** 最終ログオン日時(今回) */
    private java.util.Date DateTime_NewLastLogon;
    /** パスワード（ハッシュ済み） */
    private String PasswordHashed;
    /** 次画面名 */
    private String nextScreenName;
    /** パスワード変更理由 */
    private String reason;
    /** パスワード有効期限 */
    private String PasswordValidMsg;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cm001_01DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Cm001_01DTO(Cm001_01DTO orig) {
        super(orig);
    }

    /**
     * 発生元イベント名を取得します。
     * @return 発生元イベント名
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 発生元イベント名を設定します。
     * @param eventName 発生元イベント名
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 利用者IDを取得します。
     * @return 利用者ID
     */
    public String getLogonID() {
        return LogonID;
    }

    /**
     * 利用者IDを設定します。
     * @param LogonID 利用者ID
     */
    public void setLogonID(String LogonID) {
        this.LogonID = LogonID;
    }

    /**
     * パスワードを取得します。
     * @return パスワード
     */
    public String getPassword() {
        return Password;
    }

    /**
     * パスワードを設定します。
     * @param Password パスワード
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * 利用者名（漢字）を取得します。
     * @return 利用者名（漢字）
     */
    public String getName_Kanji() {
        return Name_Kanji;
    }

    /**
     * 利用者名（漢字）を設定します。
     * @param Name_Kanji 利用者名（漢字）
     */
    public void setName_Kanji(String Name_Kanji) {
        this.Name_Kanji = Name_Kanji;
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param Code_Organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        this.Code_Organization = Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        this.Code_Tenpo = Code_Tenpo;
    }
    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_Organization() {
        return Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param Name_Organization 扱店名
     */
    public void setName_Organization(String Name_Organization) {
        this.Name_Organization = Name_Organization;
    }

    /**
     * 権限種別を取得します。
     * @return 権限種別
     */
    public String getRoleCode() {
        return RoleCode;
    }

    /**
     * 権限種別を設定します。
     * @param RoleCode 権限種別
     */
    public void setRoleCode(String RoleCode) {
        this.RoleCode = RoleCode;
    }

    /**
     * 最終ログオン日時を取得します。
     * @return 最終ログオン日時
     */
    public java.util.Date getDateTime_LastLogon() {
        return DateTime_LastLogon;
    }

    /**
     * 最終ログオン日時を設定します。
     * @param DateTime_LastLogon 最終ログオン日時
     */
    public void setDateTime_LastLogon(java.util.Date DateTime_LastLogon) {
        this.DateTime_LastLogon = DateTime_LastLogon;
    }

    /**
     * 最終ログオン日時(今回)を取得します。
     * @return 最終ログオン日時(今回)
     */
    public java.util.Date getDateTime_NewLastLogon() {
        return DateTime_NewLastLogon;
    }

    /**
     * 最終ログオン日時(今回)を設定します。
     * @param DateTime_NewLastLogon 最終ログオン日時(今回)
     */
    public void setDateTime_NewLastLogon(java.util.Date DateTime_NewLastLogon) {
        this.DateTime_NewLastLogon = DateTime_NewLastLogon;
    }

    /**
     * パスワード（ハッシュ済み）を取得します。
     * @return パスワード（ハッシュ済み）
     */
    public String getPasswordHashed() {
        return PasswordHashed;
    }

    /**
     * パスワード（ハッシュ済み）を設定します。
     * @param PasswordHashed パスワード（ハッシュ済み）
     */
    public void setPasswordHashed(String PasswordHashed) {
        this.PasswordHashed = PasswordHashed;
    }

    /**
     * 次画面名を取得します。
     * @return 次画面名
     */
    public String getNextScreenName() {
        return nextScreenName;
    }

    /**
     * 次画面名を設定します。
     * @param nextScreenName 次画面名
     */
    public void setNextScreenName(String nextScreenName) {
        this.nextScreenName = nextScreenName;
    }

    /**
     * パスワード変更理由を取得します。
     * @return パスワード変更理由
     */
    public String getReason() {
        return reason;
    }

    /**
     * パスワード変更理由を設定します。
     * @param reason パスワード変更理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * パスワード有効期限メッセージを取得します。
     * @return パスワード有効期限メッセージ
     */
    public String getPasswordValidMsg() {
        return PasswordValidMsg;
    }

    /**
     * パスワード有効期限メッセージを設定します。
     * @param PasswordValiMsg パスワード有効期限メッセージ
     */
    public void setPasswordValidMsg(String PasswordValidMsg) {
        this.PasswordValidMsg = PasswordValidMsg;
    }

}