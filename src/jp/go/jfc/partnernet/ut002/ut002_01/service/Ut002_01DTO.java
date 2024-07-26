//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut002_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut002.ut002_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはut002_01のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut002_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 通知種別 */
    private int drpID_ID_InfoType;
    /** 通知内容 */
    private String txtID_ID_InfoContents;
    /** 登録日付 */
    private java.util.Date DateTime_InfoUpdate;
    /** 更新日時 */
    private java.sql.Timestamp DateTime_Update;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut002_01DTO() {
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
    public Ut002_01DTO(Ut002_01DTO orig) {
        super(orig);
    }

    /**
     * 通知種別を取得します。
     * @return 通知種別
     */
    public int getDrpID_ID_InfoType() {
        return drpID_ID_InfoType;
    }

    /**
     * 通知種別を設定します。
     * @param drpID_ID_InfoType 通知種別
     */
    public void setDrpID_ID_InfoType(int drpID_ID_InfoType) {
        this.drpID_ID_InfoType = drpID_ID_InfoType;
    }

    /**
     * 通知内容を取得します。
     * @return 通知内容
     */
    public String getTxtID_ID_InfoContents() {
        return txtID_ID_InfoContents;
    }

    /**
     * 通知内容を設定します。
     * @param txtID_ID_InfoContents 通知内容
     */
    public void setTxtID_ID_InfoContents(String txtID_ID_InfoContents) {
        this.txtID_ID_InfoContents = txtID_ID_InfoContents;
    }

    /**
     * 登録日付を取得します。
     * @return 登録日付
     */
    public java.util.Date getDateTime_InfoUpdate() {
        return DateTime_InfoUpdate;
    }

    /**
     * 登録日付を設定します。
     * @param DateTime_InfoUpdate 登録日付
     */
    public void setDateTime_InfoUpdate(java.util.Date DateTime_InfoUpdate) {
        this.DateTime_InfoUpdate = DateTime_InfoUpdate;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public java.sql.Timestamp getDateTime_Update() {
        return DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(java.sql.Timestamp DateTime_Update) {
        this.DateTime_Update = DateTime_Update;
    }

}