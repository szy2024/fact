//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md010_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md010.md010_01.dao;

import java.sql.Timestamp;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd010_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md010_01ResultDataEntity extends PNBaseEntity {

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
     * 交付依頼年月を取得します。
     * @return 交付依頼年月
     */
    public String getDate_KofuIrai() {
        return (String)getValue("Date_KofuIrai");
    }

    /**
     * 交付依頼年月を設定します。
     * @param Date_KofuIrai 交付依頼年月
     */
    public void setDate_KofuIrai(String Date_KofuIrai) {
        setValue("Date_KofuIrai", Date_KofuIrai);
    }

    /**
     * 交付日を取得します。
     * @return 交付日
     */
    public String getDate_Kofu() {
        return (String)getValue("Date_Kofu");
    }

    /**
     * 交付日を設定します。
     * @param Date_Kofu 交付日
     */
    public void setDate_Kofu(String Date_Kofu) {
        setValue("Date_Kofu", Date_Kofu);
    }

    /**
     * 依頼資金交付予定額を取得します。
     * @return 依頼資金交付予定額
     */
    public String getM_Irai_ShikinKofu() {
        return (String)getValue("M_Irai_ShikinKofu");
    }

    /**
     * 依頼資金交付予定額を設定します。
     * @param M_Irai_ShikinKofu 依頼資金交付予定額
     */
    public void setM_Irai_ShikinKofu(String M_Irai_ShikinKofu) {
        setValue("M_Irai_ShikinKofu", M_Irai_ShikinKofu);
    }

    /**
     * 元金充当額を取得します。
     * @return 元金充当額
     */
    public String getM_Ganju() {
        return (String)getValue("M_Ganju");
    }

    /**
     * 元金充当額を設定します。
     * @param M_Ganju 元金充当額
     */
    public void setM_Ganju(String M_Ganju) {
        setValue("M_Ganju", M_Ganju);
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
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
    }

}