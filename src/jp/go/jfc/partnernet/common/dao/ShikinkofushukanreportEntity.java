//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : ShikinkofushukanreportEntity
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
 * 資金交付依頼書（週間）報告書データのEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class ShikinkofushukanreportEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(
            "ID_Report"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
            "ID_Report",
            "Date_Report",
            "Time_Report",
            "UserID",
            "ID_Denso",
            "DataCode",
            "Code_Organization",
            "Code_Tenpo",
            "Date_Kofu",
            "M_Yotei",
            "M_Ganju_GaiSu",
            "M_ZanMikomi",
            "M_Biko",
            "DateTime_Create",
            "ID_Create",
            "DateTime_Update",
            "ID_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     * @param id_report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String)getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     * @param date_report 報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return (String)getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     * @param time_report 報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getUserID() {
        return (String)getValue("UserID");
    }

    /**
     * ユーザＩＤを設定します。
     * @param userid ユーザＩＤ
     */
    public void setUserID(String UserID) {
        setValue("UserID", UserID);
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
     */
    public String getID_Denso() {
        return (String)getValue("ID_Denso");
    }

    /**
     * 伝送番号を設定します。
     * @param id_denso 伝送番号
     */
    public void setID_Denso(String ID_Denso) {
        setValue("ID_Denso", ID_Denso);
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return (String)getValue("DataCode");
    }

    /**
     * データコードを設定します。
     * @param datacode データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
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
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param code_tenpo 店舗コード
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
     * @param date_kofu 指定交付日
     */
    public void setDate_Kofu(String Date_Kofu) {
        setValue("Date_Kofu", Date_Kofu);
    }

    /**
     * 依頼予定額を取得します。
     * @return 依頼予定額
     */
    public BigDecimal getM_Yotei() {
        return (BigDecimal)getValue("M_Yotei");
    }

    /**
     * 依頼予定額を設定します。
     * @param m_yotei 依頼予定額
     */
    public void setM_Yotei(BigDecimal M_Yotei) {
        setValue("M_Yotei", M_Yotei);
    }

    /**
     * 元金充当額（外数）を取得します。
     * @return 元金充当額（外数）
     */
    public BigDecimal getM_Ganju_GaiSu() {
        return (BigDecimal)getValue("M_Ganju_GaiSu");
    }

    /**
     * 元金充当額（外数）を設定します。
     * @param m_ganju_gaisu 元金充当額（外数）
     */
    public void setM_Ganju_GaiSu(BigDecimal M_Ganju_GaiSu) {
        setValue("M_Ganju_GaiSu", M_Ganju_GaiSu);
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を取得します。
     * @return 資金交付金残高見込額（指定交付日の前日現在）
     */
    public BigDecimal getM_ZanMikomi() {
        return (BigDecimal)getValue("M_ZanMikomi");
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を設定します。
     * @param m_zanmikomi 資金交付金残高見込額（指定交付日の前日現在）
     */
    public void setM_ZanMikomi(BigDecimal M_ZanMikomi) {
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
     * @param m_biko 備考
     */
    public void setM_Biko(String M_Biko) {
        setValue("M_Biko", M_Biko);
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