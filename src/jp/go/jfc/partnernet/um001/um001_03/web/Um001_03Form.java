//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_03Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 松井　元気            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_03.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはUm001_03のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Um001_03Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店コード */
    private String Code_Organization;
    /** 店舗 */
    private String Code_Tenpo;
    /** 利用者ID */
    private String LogonID;
    /** ステータス */
    private String status;
    /** 初回ログオンフラグ名 */
    private String Name_FirstLogon;
    /** 最終ログオン日時 */
    private java.util.Date DateTime_LastLogon;
    /** 最終ログオン日時(String) */
    private String ID_DateTime_LastLogon;
    /** 利用者名（漢字） */
    private String Name_Kanji;
    /** 利用者名（カナ） */
    private String Name_Kana;
    /** パスワード */
    private String Password;
    /** パスワードの確認 */
    private String PasswordConfirm;
    /** 権限種別 */
    private String RoleCode;
    /** 利用開始日（元号） */
    private String Date_UseStartGengo;
    /** 利用開始日（年） */
    private String Date_UseStartYear;
    /** 利用開始日（月） */
    private String Date_UseStartMonth;
    /** 利用開始日（日） */
    private String Date_UseStartDate;
    /** パスワード初回変更強制フラグ */
    private Integer Flag_ForceChgPwdFistLogon;
    /** パスワード定期変更強制フラグ */
    private Integer Flag_ForceChgPwdRoutine;
    /** パスワード有効日数 */
    private String Num_PwdValidDays;
    /** パスワード変更日時 */
    private java.util.Date DateTime_LastChgPwd;
    /** パスワード変更日時(String) */
    private String ID_DateTime_LastChgPwd;
    /** パスワード試行回数（最大） */
    private String Num_PwdRetryCntMax;
    /** パスワード試行回数 */
    private String Num_PwdRetryCnt;
    /** 登録者ID */
    private String ID_Create;
    /** 登録日時 */
    private java.util.Date DateTime_Create;
    /** 更新者ID */
    private String ID_Update;
    /** 更新日時 */
    private java.util.Date DateTime_Update;
    /** 初回ログオンフラグ */
    private Integer Flag_FirstLogon;
    /** 利用者存在フラグ */
    private boolean userExists;

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
     * 店舗を取得します。
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        this.Code_Tenpo = Code_Tenpo;
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return status;
    }

    /**
     * ステータスを設定します。
     * @param status ステータス
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 初回ログオンフラグ名を取得します。
     * @return 初回ログオンフラグ名
     */
    public String getName_FirstLogon() {
        return Name_FirstLogon;
    }

    /**
     * 初回ログオンフラグ名を設定します。
     * @param Name_FirstLogon 初回ログオンフラグ名
     */
    public void setName_FirstLogon(String Name_FirstLogon) {
        this.Name_FirstLogon = Name_FirstLogon;
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
     * 最終ログオン日時(String)を取得します。
     * @return 最終ログオン日時(String)
     */
    public String getID_DateTime_LastLogon() {
        return ID_DateTime_LastLogon;
    }

    /**
     * 最終ログオン日時(String)を設定します。
     * @param DateTime_LastLogon 最終ログオン日時(String)
     */
    public void setID_DateTime_LastLogon(String ID_DateTime_LastLogon) {
        this.ID_DateTime_LastLogon = ID_DateTime_LastLogon;
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
     * 利用者名（カナ）を取得します。
     * @return 利用者名（カナ）
     */
    public String getName_Kana() {
        return Name_Kana;
    }

    /**
     * 利用者名（カナ）を設定します。
     * @param Name_Kana 利用者名（カナ）
     */
    public void setName_Kana(String Name_Kana) {
        this.Name_Kana = Name_Kana;
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
     * パスワードの確認を取得します。
     * @return パスワードの確認
     */
    public String getPasswordConfirm() {
        return PasswordConfirm;
    }

    /**
     * パスワードの確認を設定します。
     * @param PasswordConfirm パスワードの確認
     */
    public void setPasswordConfirm(String PasswordConfirm) {
        this.PasswordConfirm = PasswordConfirm;
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
     * 利用開始日（元号）を取得します。
     * @return 利用開始日（元号）
     */
    public String getDate_UseStartGengo() {
        return Date_UseStartGengo;
    }

    /**
     * 利用開始日（元号）を設定します。
     * @param Date_UseStartGengo 利用開始日（元号）
     */
    public void setDate_UseStartGengo(String Date_UseStartGengo) {
        this.Date_UseStartGengo = Date_UseStartGengo;
    }

    /**
     * 利用開始日（年）を取得します。
     * @return 利用開始日（年）
     */
    public String getDate_UseStartYear() {
        return Date_UseStartYear;
    }

    /**
     * 利用開始日（年）を設定します。
     * @param Date_UseStartYear 利用開始日（年）
     */
    public void setDate_UseStartYear(String Date_UseStartYear) {
        this.Date_UseStartYear = Date_UseStartYear;
    }

    /**
     * 利用開始日（月）を取得します。
     * @return 利用開始日（月）
     */
    public String getDate_UseStartMonth() {
        return Date_UseStartMonth;
    }

    /**
     * 利用開始日（月）を設定します。
     * @param Date_UseStartMonth 利用開始日（月）
     */
    public void setDate_UseStartMonth(String Date_UseStartMonth) {
        this.Date_UseStartMonth = Date_UseStartMonth;
    }

    /**
     * 利用開始日（日）を取得します。
     * @return 利用開始日（日）
     */
    public String getDate_UseStartDate() {
        return Date_UseStartDate;
    }

    /**
     * 利用開始日（日）を設定します。
     * @param Date_UseStartDate 利用開始日（日）
     */
    public void setDate_UseStartDate(String Date_UseStartDate) {
        this.Date_UseStartDate = Date_UseStartDate;
    }

    /**
     * パスワード初回変更強制フラグを取得します。
     * @return パスワード初回変更強制フラグ
     */
    public Integer getFlag_ForceChgPwdFistLogon() {
        return Flag_ForceChgPwdFistLogon;
    }

    /**
     * パスワード初回変更強制フラグを設定します。
     * @param Flag_ForceChgPwdFistLogon パスワード初回変更強制フラグ
     */
    public void setFlag_ForceChgPwdFistLogon(Integer Flag_ForceChgPwdFistLogon) {
        this.Flag_ForceChgPwdFistLogon = Flag_ForceChgPwdFistLogon;
    }

    /**
     * パスワード定期変更強制フラグを取得します。
     * @return パスワード定期変更強制フラグ
     */
    public Integer getFlag_ForceChgPwdRoutine() {
        return Flag_ForceChgPwdRoutine;
    }

    /**
     * パスワード定期変更強制フラグを設定します。
     * @param Flag_ForceChgPwdRoutine パスワード定期変更強制フラグ
     */
    public void setFlag_ForceChgPwdRoutine(Integer Flag_ForceChgPwdRoutine) {
        this.Flag_ForceChgPwdRoutine = Flag_ForceChgPwdRoutine;
    }

    /**
     * パスワード有効日数を取得します。
     * @return パスワード有効日数
     */
    public String getNum_PwdValidDays() {
        return Num_PwdValidDays;
    }

    /**
     * パスワード有効日数を設定します。
     * @param Num_PwdValidDays パスワード有効日数
     */
    public void setNum_PwdValidDays(String Num_PwdValidDays) {
        this.Num_PwdValidDays = Num_PwdValidDays;
    }

    /**
     * パスワード変更日時を取得します。
     * @return パスワード変更日時
     */
    public java.util.Date getDateTime_LastChgPwd() {
        return DateTime_LastChgPwd;
    }

    /**
     * パスワード変更日時を設定します。
     * @param DateTime_LastChgPwd パスワード変更日時
     */
    public void setDateTime_LastChgPwd(java.util.Date DateTime_LastChgPwd) {
        this.DateTime_LastChgPwd = DateTime_LastChgPwd;
    }

    /**
     * パスワード変更日時(String)を取得します。
     * @return パスワード変更日時(String)
     */
    public String getID_DateTime_LastChgPwd() {
        return ID_DateTime_LastChgPwd;
    }

    /**
     * パスワード変更日時(String)を設定します。
     * @param ID_DateTime_LastChgPwd パスワード変更日時(String)
     */
    public void setID_DateTime_LastChgPwd(String ID_DateTime_LastChgPwd) {
        this.ID_DateTime_LastChgPwd = ID_DateTime_LastChgPwd;
    }

    /**
     * パスワード試行回数（最大）を取得します。
     * @return パスワード試行回数（最大）
     */
    public String getNum_PwdRetryCntMax() {
        return Num_PwdRetryCntMax;
    }

    /**
     * パスワード試行回数（最大）を設定します。
     * @param Num_PwdRetryCntMax パスワード試行回数（最大）
     */
    public void setNum_PwdRetryCntMax(String Num_PwdRetryCntMax) {
        this.Num_PwdRetryCntMax = Num_PwdRetryCntMax;
    }

    /**
     * パスワード試行回数を取得します。
     * @return パスワード試行回数
     */
    public String getNum_PwdRetryCnt() {
        return Num_PwdRetryCnt;
    }

    /**
     * パスワード試行回数を設定します。
     * @param Num_PwdRetryCnt パスワード試行回数
     */
    public void setNum_PwdRetryCnt(String Num_PwdRetryCnt) {
        this.Num_PwdRetryCnt = Num_PwdRetryCnt;
    }

    /**
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getID_Create() {
        return ID_Create;
    }

    /**
     * 登録者IDを設定します。
     * @param ID_Create 登録者ID
     */
    public void setID_Create(String ID_Create) {
        this.ID_Create = ID_Create;
    }

    /**
     * 登録日時を取得します。
     * @return 登録日時
     */
    public java.util.Date getDateTime_Create() {
        return DateTime_Create;
    }

    /**
     * 登録日時を設定します。
     * @param DateTime_Create 登録日時
     */
    public void setDateTime_Create(java.util.Date DateTime_Create) {
        this.DateTime_Create = DateTime_Create;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getID_Update() {
        return ID_Update;
    }

    /**
     * 更新者IDを設定します。
     * @param ID_Update 更新者ID
     */
    public void setID_Update(String ID_Update) {
        this.ID_Update = ID_Update;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public java.util.Date getDateTime_Update() {
        return DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(java.util.Date DateTime_Update) {
        this.DateTime_Update = DateTime_Update;
    }

    /**
     * 初回ログオンフラグを取得します。
     * @return 初回ログオンフラグ
     */
    public Integer getFlag_FirstLogon() {
        return Flag_FirstLogon;
    }

    /**
     * 初回ログオンフラグを設定します。
     * @param Flag_FirstLogon 初回ログオンフラグ
     */
    public void setFlag_FirstLogon(Integer Flag_FirstLogon) {
        this.Flag_FirstLogon = Flag_FirstLogon;
    }

    /**
     * 利用者存在フラグを取得します。
     * @return 利用者存在フラグ
     */
    public boolean getUserExists() {
        return userExists;
    }

    /**
     * 利用者存在フラグを設定します。
     * @param userExists 利用者存在フラグ
     */
    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }

}