//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : KanjocoopdoctypeEntity
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
import java.sql.Timestamp;

/**
 * <pre>
 * 勘定システム連携帳票種別のEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class KanjocoopdoctypeEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(
            "DocType"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
            "DocType",
            "FixedWording",
            "Kubun_KanjoCoopProcess",
            "DateTime_Create",
            "ID_Create",
            "DateTime_Update",
            "ID_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 帳票種別を取得します。
     * @return 帳票種別
     */
    public String getDocType() {
        return (String)getValue("DocType");
    }

    /**
     * 帳票種別を設定します。
     * @param doctype 帳票種別
     */
    public void setDocType(String DocType) {
        setValue("DocType", DocType);
    }

    /**
     * 固定文言を取得します。
     * @return 固定文言
     */
    public String getFixedWording() {
        return (String)getValue("FixedWording");
    }

    /**
     * 固定文言を設定します。
     * @param fixedwording 固定文言
     */
    public void setFixedWording(String FixedWording) {
        setValue("FixedWording", FixedWording);
    }

    /**
     * 勘定システム連携プロセス区分を取得します。
     * @return 勘定システム連携プロセス区分
     */
    public String getKubun_KanjoCoopProcess() {
        return (String)getValue("Kubun_KanjoCoopProcess");
    }

    /**
     * 勘定システム連携プロセス区分を設定します。
     * @param kubun_kanjocoopprocess 勘定システム連携プロセス区分
     */
    public void setKubun_KanjoCoopProcess(String Kubun_KanjoCoopProcess) {
        setValue("Kubun_KanjoCoopProcess", Kubun_KanjoCoopProcess);
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