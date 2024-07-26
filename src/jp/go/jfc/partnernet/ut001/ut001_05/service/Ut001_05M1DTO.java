//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_05M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_05.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはUt001_05のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_05M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 様式番号 */
    private String ID_ID_FormatNumber;
    /** 様式名 */
    private String ID_ID_DocName;
    /** 文書ファイル名 */
    private String ID_DocFileName;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut001_05M1DTO() {
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
    public Ut001_05M1DTO(Ut001_05M1DTO orig) {
        super(orig);
    }

    /**
     * 様式番号を取得します。
     * @return 様式番号
     */
    public String getID_ID_FormatNumber() {
        return ID_ID_FormatNumber;
    }

    /**
     * 様式番号を設定します。
     * @param ID_ID_FormatNumber 様式番号
     */
    public void setID_ID_FormatNumber(String ID_ID_FormatNumber) {
        this.ID_ID_FormatNumber = ID_ID_FormatNumber;
    }
    /**
     * 様式名を取得します。
     * @return 様式名
     */
    public String getID_ID_DocName() {
        return ID_ID_DocName;
    }

    /**
     * 様式名を設定します。
     * @param ID_ID_DocName 様式名
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