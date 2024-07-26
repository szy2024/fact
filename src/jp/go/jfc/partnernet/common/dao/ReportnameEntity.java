//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : ReportnameEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 後　和男            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNSingleTableEntity;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.sql.Timestamp;

/**
 * <pre>
 * 報告書種別テーブルのEntityです。
 * </pre>
 *
 * @author 後　和男
 * @version 1.0.0
 */
public class ReportnameEntity extends PNSingleTableEntity {
    
        /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(
            "DataCode"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
        "DataCode",
        "RyakusyouName_Report",
        "DateTime_Create",
        "ID_Create",
        "DateTime_Update",
        "ID_Update"

    };
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return (String) getValue("DataCode");
    }

    /**
     * データコードを設定します。
     * @param DataCode データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }
    /**
     * 報告書略称名を取得します。
     * @return 報告書略称名
     */
    public String getRyakusyouName_Report() {
        return (String) getValue("RyakusyouName_Report");
    }

    /**
     * 報告書略称名を設定します。
     * @param RyakusyouName_Report 報告書略称名
     */
    public void setRyakusyouName_Report(String RyakusyouName_Report) {
        setValue("RyakusyouName_Report", RyakusyouName_Report);
    }
    /**
     * 登録日時を取得します。
     * @return 登録日時
     */
    public Timestamp getDateTime_Create() {
        return (Timestamp) getValue("DateTime_Create");
    }

    /**
     * 登録日時を設定します。
     * @param DateTime_Create 登録日時
     */
    public void setDateTime_Create(Timestamp DateTime_Create) {
        setValue("DateTime_Create", DateTime_Create);
    }
    /**
     * 登録IDを取得します。
     * @return 登録ID
     */
    public String getID_Create() {
        return (String) getValue("ID_Create");
    }

    /**
     * 登録IDを設定します。
     * @param ID_Create 登録ID
     */
    public void setID_Create(String ID_Create) {
        setValue("ID_Create", ID_Create);
    }
    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public Timestamp getDateTime_Update() {
        return (Timestamp) getValue("DateTime_Update");
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
    }
    /**
     * 更新IDを取得します。
     * @return 更新ID
     */
    public String getID_Update() {
        return (String) getValue("ID_Update");
    }

    /**
     * 更新IDを設定します。
     * @param ID_Update 更新ID
     */
    public void setID_Update(String ID_Update) {
        setValue("ID_Update", ID_Update);
    }

    /**
     * column list is returned.
     * @return column list
     */
    public String[] getColumnList() {
        String[] columnListCp = new String[COLUMN_LIST.length];
        System.arraycopy(COLUMN_LIST, 0, columnListCp, 0, COLUMN_LIST.length);
        return columnListCp;
    }

    /**
     * 
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.dao.entity.PNSingleTableEntity#getPrimaryKeys()
     */
    @Override
    public Set<String> getPrimaryKeys() {

        return PRIMARY_KEYS;
    }

}