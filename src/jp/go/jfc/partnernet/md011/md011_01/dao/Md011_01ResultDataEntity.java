//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md011_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd011_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md011_01ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return (String)getValue("ID_History");
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_Organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 扱店名を設定します。
     * @param Name_Organization 扱店名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
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
     * @param Code_Organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 指定交付日を取得します。
     * @return 指定交付日
     */
    public String getDate_Kofu() {
        return (String)getValue("Date_Kofu");
    }

    /**
     * 指定交付日を設定します。
     * @param Date_Kofu 指定交付日
     */
    public void setDate_Kofu(String Date_Kofu) {
        setValue("Date_Kofu", Date_Kofu);
    }

    /**
     * 依頼予定額を取得します。
     * @return 依頼予定額
     */
    public String getM_Yotei() {
        return (String)getValue("M_Yotei");
    }

    /**
     * 依頼予定額を設定します。
     * @param M_Yotei 依頼予定額
     */
    public void setM_Yotei(String M_Yotei) {
        setValue("M_Yotei", M_Yotei);
    }

    /**
     * 元金充当額（外数）を取得します。
     * @return 元金充当額（外数）
     */
    public String getM_Ganju_GaiSu() {
        return (String)getValue("M_Ganju_GaiSu");
    }

    /**
     * 元金充当額（外数）を設定します。
     * @param M_Ganju_GaiSu 元金充当額（外数）
     */
    public void setM_Ganju_GaiSu(String M_Ganju_GaiSu) {
        setValue("M_Ganju_GaiSu", M_Ganju_GaiSu);
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を取得します。
     * @return 資金交付金残高見込額（指定交付日の前日現在）
     */
    public String getM_ZanMikomi() {
        return (String)getValue("M_ZanMikomi");
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を設定します。
     * @param M_ZanMikomi 資金交付金残高見込額（指定交付日の前日現在）
     */
    public void setM_ZanMikomi(String M_ZanMikomi) {
        setValue("M_ZanMikomi", M_ZanMikomi);
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getM_Biko() {
        return (String)getValue("M_Biko");
    }

    /**
     * 備考を設定します。
     * @param M_Biko 備考
     */
    public void setM_Biko(String M_Biko) {
        setValue("M_Biko", M_Biko);
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public java.sql.Timestamp getDateTime_Update() {
        return (java.sql.Timestamp)getValue("DateTime_Update");
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(java.sql.Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
    }

}