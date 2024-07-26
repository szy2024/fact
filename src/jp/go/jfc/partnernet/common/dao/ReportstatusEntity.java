//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : ReportstatusEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNSingleTableEntity;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <pre>
 * 報告書ステータス種別テーブルのEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class ReportstatusEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(
            "Status"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
            "Status",
            "RyakusyouName_Status",
            "DateTime_Create",
            "ID_Create",
            "DateTime_Update",
            "ID_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public BigDecimal getStatus() {
        return (BigDecimal)getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param status ステータス
     */
    public void setStatus(BigDecimal Status) {
        setValue("Status", Status);
    }

    /**
     * ステータス略称名を取得します。
     * @return ステータス略称名
     */
    public String getRyakusyouName_Status() {
        return (String)getValue("RyakusyouName_Status");
    }

    /**
     * ステータス略称名を設定します。
     * @param ryakusyouname_status ステータス略称名
     */
    public void setRyakusyouName_Status(String RyakusyouName_Status) {
        setValue("RyakusyouName_Status", RyakusyouName_Status);
    }

    /**
     * 登録日時を取得します。
     * @return 登録日時
     */
    public Timestamp getDateTime_Create() {
        return (Timestamp)getValue("DateTime_Create");
    }

    /**
     * 登録日時を設定します。
     * @param datetime_create 登録日時
     */
    public void setDateTime_Create(Timestamp DateTime_Create) {
        setValue("DateTime_Create", DateTime_Create);
    }

    /**
     * 登録IDを取得します。
     * @return 登録ID
     */
    public String getID_Create() {
        return (String)getValue("ID_Create");
    }

    /**
     * 登録IDを設定します。
     * @param id_create 登録ID
     */
    public void setID_Create(String ID_Create) {
        setValue("ID_Create", ID_Create);
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public Timestamp getDateTime_Update() {
        return (Timestamp)getValue("DateTime_Update");
    }

    /**
     * 更新日時を設定します。
     * @param datetime_update 更新日時
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
    }

    /**
     * 更新IDを取得します。
     * @return 更新ID
     */
    public String getID_Update() {
        return (String)getValue("ID_Update");
    }

    /**
     * 更新IDを設定します。
     * @param id_update 更新ID
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
     * @see com.fujitsu.xcmfw.dao.entity.PNSingleTableEntity#getPrimaryKeys()
     */
    @Override
    public Set<String> getPrimaryKeys() {

        return PRIMARY_KEYS;
    }

}