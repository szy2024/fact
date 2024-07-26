//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはut003_02のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut003_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 情報登録日付 */
    private java.util.Date DateTime_DocUpdate;
    /** 文書番号 */
    private String ID_ID_DocNumber;
    /** 文書ファイル名 */
    private String ID_ID_DocFileName;
    /** 通知標題 */
    private String ID_DocName;
    /** データ番号 */
    private String ID_Data;
    /** 削除選択 */
    private Integer chkDelete;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut003_02M1DTO() {
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
    public Ut003_02M1DTO(Ut003_02M1DTO orig) {
        super(orig);
    }

    /**
     * 情報登録日付を取得します。
     * @return 情報登録日付
     */
    public java.util.Date getDateTime_DocUpdate() {
        return DateTime_DocUpdate;
    }

    /**
     * 情報登録日付を設定します。
     * @param DateTime_DocUpdate 情報登録日付
     */
    public void setDateTime_DocUpdate(java.util.Date DateTime_DocUpdate) {
        this.DateTime_DocUpdate = DateTime_DocUpdate;
    }

    /**
     * 文書番号を取得します。
     * @return 文書番号
     */
    public String getID_ID_DocNumber() {
        return ID_ID_DocNumber;
    }

    /**
     * 文書番号を設定します。
     * @param ID_ID_DocNumber 文書番号
     */
    public void setID_ID_DocNumber(String ID_ID_DocNumber) {
        this.ID_ID_DocNumber = ID_ID_DocNumber;
    }

    /**
     * 文書ファイル名を取得します。
     * @return 文書ファイル名
     */
    public String getID_ID_DocFileName() {
        return ID_ID_DocFileName;
    }

    /**
     * 文書ファイル名を設定します。
     * @param ID_ID_DocFileName 文書ファイル名
     */
    public void setID_ID_DocFileName(String ID_ID_DocFileName) {
        this.ID_ID_DocFileName = ID_ID_DocFileName;
    }

    /**
     * 通知標題を取得します。
     * @return 通知標題
     */
    public String getID_DocName() {
        return ID_DocName;
    }

    /**
     * 通知標題を設定します。
     * @param ID_DocName 通知標題
     */
    public void setID_DocName(String ID_DocName) {
        this.ID_DocName = ID_DocName;
    }

    /**
     * データ番号を取得します。
     * @return データ番号
     */
    public String getID_Data() {
        return ID_Data;
    }

    /**
     * データ番号を設定します。
     * @param ID_Data データ番号
     */
    public void setID_Data(String ID_Data) {
        this.ID_Data = ID_Data;
    }

    /**
     * 削除選択を設定します。
     *
     * @param chkDelete 選択
     */
    public Integer getChkDelete() {
        return chkDelete;
    }

    /**
     * 削除選択を設定します。
     *
     * @param chkDelete 選択
     */
    public void setChkDelete(Integer chkDelete) {
        this.chkDelete = chkDelete;
    }

}