//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはUm001_02のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Um001_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店コード */
    private String Code_Organization;
    /** 店舗コード */
    private String Code_Tenpo;
    /** 利用者ID */
    private String LogonID;
    /** 利用者名（漢字） */
    private String Name_Kanji;
    /** 権限種別名 */
    private String Name_Role;
    /** 利用開始日 */
    private java.util.Date Date_UseStart;
    /** 登録日時 */
    private java.util.Date DateTime_Create;
    /** 更新日時 */
    private java.util.Date DateTime_Update;
    /** ステータス */
    private String Status;
    /** 操作選択オプション */
    private Integer OptOperation;
    /** 権限種別 */
    private String RoleCode;
    /** ステータスコード */
    private String StatusCode;
    /** ステータス名 */
    private String StatusName;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Um001_02M1DTO() {
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
    public Um001_02M1DTO(Um001_02M1DTO orig) {
        super(orig);
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
     * 権限種別名を取得します。
     * @return 権限種別名
     */
    public String getName_Role() {
        return Name_Role;
    }

    /**
     * 権限種別名を設定します。
     * @param Name_Role 権限種別名
     */
    public void setName_Role(String Name_Role) {
        this.Name_Role = Name_Role;
    }

    /**
     * 利用開始日を取得します。
     * @return 利用開始日
     */
    public java.util.Date getDate_UseStart() {
        return Date_UseStart;
    }

    /**
     * 利用開始日を設定します。
     * @param Date_UseStart 利用開始日
     */
    public void setDate_UseStart(java.util.Date Date_UseStart) {
        this.Date_UseStart = Date_UseStart;
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return Status;
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * 操作選択オプションを取得します。
     * @return 操作選択オプション
     */
    public Integer getOptOperation() {
        return OptOperation;
    }

    /**
     * 操作選択オプションを設定します。
     * @param OptOperation 操作選択オプション
     */
    public void setOptOperation(Integer OptOperation) {
        this.OptOperation = OptOperation;
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
     * ステータスコードを取得します。
     * @return ステータスコード
     */
    public String getStatusCode() {
        return StatusCode;
    }

    /**
     * ステータスコードを設定します。
     * @param StatusCode ステータスコード
     */
    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    /**
     * <pre>
     * ステータス名を取得します。
     * </pre>
     *
     * @return StatusName
     */
    public String getStatusName() {
        return StatusName;
    }

    /**
     * <pre>
     * ステータス名を設定します。
     * </pre>
     *
     * @param statusName ステータス名
     */
    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }

}