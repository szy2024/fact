//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : RishijoseiindexEntity
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
 * 利子助成金受領一覧表情報インデックスのEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class RishijoseiindexEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(
            "ID_Data"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
            "ID_Data",
            "Code_Organization",
            "Date_Taisho",
            "Date_JyohoTeikyo",
            "Disp_DocName",
            "DocName",
            "FilePath",
            "DocType",
            "DateTime_Create",
            "ID_Create",
            "DateTime_Update",
            "ID_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * データ番号を取得します。
     * @return データ番号
     */
    public BigDecimal getID_Data() {
        return (BigDecimal)getValue("ID_Data");
    }

    /**
     * データ番号を設定します。
     * @param id_data データ番号
     */
    public void setID_Data(BigDecimal ID_Data) {
        setValue("ID_Data", ID_Data);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     * @param code_organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 対象年月を取得します。
     * @return 対象年月
     */
    public String getDate_Taisho() {
        return (String)getValue("Date_Taisho");
    }

    /**
     * 対象年月を設定します。
     * @param date_taisho 対象年月
     */
    public void setDate_Taisho(String Date_Taisho) {
        setValue("Date_Taisho", Date_Taisho);
    }

    /**
     * 情報提供日を取得します。
     * @return 情報提供日
     */
    public String getDate_JyohoTeikyo() {
        return (String)getValue("Date_JyohoTeikyo");
    }

    /**
     * 情報提供日を設定します。
     * @param date_jyohoteikyo 情報提供日
     */
    public void setDate_JyohoTeikyo(String Date_JyohoTeikyo) {
        setValue("Date_JyohoTeikyo", Date_JyohoTeikyo);
    }

    /**
     * 表示ファイル名を取得します。
     * @return 表示ファイル名
     */
    public String getDisp_DocName() {
        return (String)getValue("Disp_DocName");
    }

    /**
     * 表示ファイル名を設定します。
     * @param disp_docname 表示ファイル名
     */
    public void setDisp_DocName(String Disp_DocName) {
        setValue("Disp_DocName", Disp_DocName);
    }

    /**
     * ファイル名を取得します。
     * @return ファイル名
     */
    public String getDocName() {
        return (String)getValue("DocName");
    }

    /**
     * ファイル名を設定します。
     * @param docname ファイル名
     */
    public void setDocName(String DocName) {
        setValue("DocName", DocName);
    }

    /**
     * ファイルパスを取得します。
     * @return ファイルパス
     */
    public String getFilePath() {
        return (String)getValue("FilePath");
    }

    /**
     * ファイルパスを設定します。
     * @param filepath ファイルパス
     */
    public void setFilePath(String FilePath) {
        setValue("FilePath", FilePath);
    }

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