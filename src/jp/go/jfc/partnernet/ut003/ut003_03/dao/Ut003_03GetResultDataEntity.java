//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_03GetResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_03.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはUt003_03GetResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut003_03GetResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 検索開始日を取得します。
     * @return 検索開始日
     */
    public String getID_SearchStartDate() {
        return (String) getValue("ID_SearchStartDate");
    }

    /**
     * 検索開始日を設定します。
     * @param ID_SearchStartDate 検索開始日
     */
    public void setID_SearchStartDate(String ID_SearchStartDate) {
        setValue("ID_SearchStartDate", ID_SearchStartDate);
    }

    /**
     * 検索終了日を取得します。
     * @return 検索終了日
     */
    public String getID_SearchEndDate() {
        return (String) getValue("ID_SearchEndDate");
    }

    /**
     * 検索終了日を設定します。
     * @param ID_SearchEndDate 検索終了日
     */
    public void setID_SearchEndDate(String ID_SearchEndDate) {
        setValue("ID_SearchEndDate", ID_SearchEndDate);
    }

    /**
     * 情報登録日付を取得します。
     * @return 情報登録日付
     */
    public java.sql.Date getDateTime_DocUpdate() {
        return (java.sql.Date) getValue("DateTime_DocUpdate");
    }

    /**
     * 情報登録日付を設定します。
     * @param DateTime_DocUpdate 情報登録日付
     */
    public void setDateTime_DocUpdate(java.sql.Date DateTime_DocUpdate) {
        setValue("DateTime_DocUpdate", DateTime_DocUpdate);
    }

    /**
     * 文書ファイル名を取得します。
     * @return 文書ファイル名
     */
    public String getID_ID_DocFileName() {
        return (String) getValue("ID_ID_DocFileName");
    }

    /**
     * 文書ファイル名を設定します。
     * @param ID_ID_DocFileName 文書ファイル名
     */
    public void setID_ID_DocFileName(String ID_ID_DocFileName) {
        setValue("ID_ID_DocFileName", ID_ID_DocFileName);
    }

    /**
     * 通知標題を取得します。
     * @return 通知標題
     */
    public String getID_DocName() {
        return (String) getValue("ID_DocName");
    }

    /**
     * 通知標題を設定します。
     * @param ID_DocName 通知標題
     */
    public void setID_DocName(String ID_DocName) {
        setValue("ID_DocName", ID_DocName);
    }

    /**
     * データ番号を取得します。
     * @return データ番号
     */
    public String getID_Data() {
        return (String) getValue("ID_Data");
    }

    /**
     * データ番号を設定します。
     * @param ID_Data データ番号
     */
    public void setID_Data(String ID_Data) {
        setValue("ID_Data", ID_Data);
    }

}