//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_02TsuchiJimuEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはUt001_02TsuchiJimuDAOのEntityクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_02TsuchiJimuEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 文書番号を取得します。
     * @return 文書番号
     */
    public String getID_DocNumber() {
        return (String) getValue("ID_DocNumber");
    }

    /**
     * 文書番号を設定します。
     * @param ID_DocNumber 文書番号
     */
    public void setID_DocNumber(String ID_DocNumber) {
        setValue("ID_DocNumber", ID_DocNumber);
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
     * 文書ファイル名を取得します。
     * @return 文書ファイル名
     */
    public String getID_DocFileName() {
        return (String) getValue("ID_DocFileName");
    }

    /**
     * 文書ファイル名を設定します。
     * @param ID_DocFileName 文書ファイル名
     */
    public void setID_DocFileName(String ID_DocFileName) {
        setValue("ID_DocFileName", ID_DocFileName);
    }

}