//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_03M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはUt001_03のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_03M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 改定日 */
    private java.util.Date ID_DateTime_DocUpdate;
    /** 金利情報ファイル */
    private String ID_ID_DocName;
    /** 文書ファイル名 */
    private String ID_DocFileName;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut001_03M1DTO() {
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
    public Ut001_03M1DTO(Ut001_03M1DTO orig) {
        super(orig);
    }

    /**
     * 改定日を取得します。
     * @return 改定日
     */
    public java.util.Date getID_DateTime_DocUpdate() {
        return ID_DateTime_DocUpdate;
    }

    /**
     * 改定日を設定します。
     * @param ID_DateTime_DocUpdate 改定日
     */
    public void setID_DateTime_DocUpdate(java.util.Date ID_DateTime_DocUpdate) {
        this.ID_DateTime_DocUpdate = ID_DateTime_DocUpdate;
    }
    /**
     * 金利情報ファイルを取得します。
     * @return 金利情報ファイル
     */
    public String getID_ID_DocName() {
        return ID_ID_DocName;
    }

    /**
     * 金利情報ファイルを設定します。
     * @param ID_ID_DocName 金利情報ファイル
     */
    public void setID_ID_DocName(String ID_ID_DocName) {
        this.ID_ID_DocName = ID_ID_DocName;
    }
    /**
     * 文書ファイル名を取得します。
     * @return 文書ファイル名
     */
    public String getID_DocFileName() {
        return ID_DocFileName;
    }

    /**
     * 文書ファイル名を設定します。
     * @param ID_DocFileName 文書ファイル名
     */
    public void setID_DocFileName(String ID_DocFileName) {
        this.ID_DocFileName = ID_DocFileName;
    }

}