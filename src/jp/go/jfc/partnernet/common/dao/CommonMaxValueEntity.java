//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : CommonMaxValueEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/18 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCommonMaxValueDAOのEntityクラスです。
 * </pre>
 *
 * @author堀　大輔
 * @version 1.0.0
 */
public class CommonMaxValueEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 対象テーブル名を取得します。
     *
     * @return targetTableName 対象テーブル名
     */
    public String getTargetTableName() {
        return (String) getValue("targetTableName");
    }

    /**
     * 対象テーブル名を設定します。
     *
     * @param targetTableName 対象テーブル名
     */
    public void setTargetTableName(String targetTableName) {
        setValue("targetTableName", targetTableName);
    }

    /**
     * 対象カラム名を取得します。
     *
     * @return targetColumnName 対象カラム名
     */
    public String getTargetColumnName() {
        return (String) getValue("targetColumnName");
    }

    /**
     * 対象カラム名を設定します。
     *
     * @param targetColumnName 対象カラム名
     */
    public void setTargetColumnName(String targetColumnName) {
        setValue("targetColumnName", targetColumnName);
    }

    /**
     * 検索条件を取得します。
     *
     * @return whereString 検索条件
     */
    public String getWhereString() {
        return (String) getValue("whereString");
    }

    /**
     * 検索条件を設定します。
     *
     * @param whereString 検索条件
     */
    public void setWhereString(String whereString) {
        setValue("whereString", whereString);
    }

    /**
     * 検索結果（最大値）を取得します。
     *
     * @return MaxValue 検索結果（最大値）
     */
    public String getMaxValue() {
        return (String) getValue("MaxValue");
    }

    /**
     * 検索結果（最大値）を設定します。
     *
     * @param MaxValue 検索結果（最大値）
     */
    public void setMaxValue(String MaxValue) {
        setValue("MaxValue", MaxValue);
    }

    /**
     * 決算IDを取得します。
     *
     * @return getID_Kessan 決算ID
     */
    public String getID_Kessan() {
        return (String) getValue("ID_Kessan");
    }

    /**
     * 決算IDを設定します。
     * @param setID_Kessan 決算ID
     */
    public void setID_Kessan(String ID_Kessan) {
        setValue("ID_Kessan", ID_Kessan);
    }

    /**
     * 決算日を取得します。
     *
     * @return getID_Kessan 決算日
     */
    public String getDate_Kessanbi() {
        return (String) getValue("Date_Kessanbi");
    }

    /**
     * 決算日を設定します。
     * @param setDate_Kessanbi 決算日
     */
    public void setDate_Kessanbi(String Date_Kessanbi) {
        setValue("Date_Kessanbi", Date_Kessanbi);
    }

}