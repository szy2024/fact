//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : HokatsureportEntity
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
 * 包括委任状等の交付依頼報告書データのEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class HokatsureportEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of("ID_Report"

            );

    /** column list **/
    private static final String[] COLUMN_LIST = { "ID_Report", "Date_Report", "Time_Report", "UserID", "ID_Denso",
            "DataCode", "Code_Organization", "Code_Tenpo", "Su_HokatsuInin", "Su_GenzaiJiko", "Su_InkanShohmei",
            "Su_HenkoShohhon", "Su_SinHeisa", "Su_KyuHeisa", "Su_HeisaJiko", "Flag_ShikyuHakko", "DateTime_Create",
            "ID_Create", "DateTime_Update", "ID_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     *
     * @param id_report
     *            報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String)getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     *
     * @param date_report
     *            報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return (String)getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param time_report
     *            報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * ユーザＩＤを取得します。
     *
     * @return ユーザＩＤ
     */
    public String getUserID() {
        return (String)getValue("UserID");
    }

    /**
     * ユーザＩＤを設定します。
     *
     * @param userid
     *            ユーザＩＤ
     */
    public void setUserID(String UserID) {
        setValue("UserID", UserID);
    }

    /**
     * 伝送番号を取得します。
     *
     * @return 伝送番号
     */
    public String getID_Denso() {
        return (String)getValue("ID_Denso");
    }

    /**
     * 伝送番号を設定します。
     *
     * @param id_denso
     *            伝送番号
     */
    public void setID_Denso(String ID_Denso) {
        setValue("ID_Denso", ID_Denso);
    }

    /**
     * データコードを取得します。
     *
     * @return データコード
     */
    public String getDataCode() {
        return (String)getValue("DataCode");
    }

    /**
     * データコードを設定します。
     *
     * @param datacode
     *            データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     *
     * @param code_organization
     *            扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗コードを取得します。
     *
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     *
     * @param code_tenpo
     *            店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 包括委任状数量を取得します。
     *
     * @return 包括委任状数量
     */
    public BigDecimal getSu_HokatsuInin() {
        return (BigDecimal)getValue("Su_HokatsuInin");
    }

    /**
     * 包括委任状数量を設定します。
     *
     * @param su_hokatsuinin
     *            包括委任状数量
     */
    public void setSu_HokatsuInin(BigDecimal Su_HokatsuInin) {
        setValue("Su_HokatsuInin", Su_HokatsuInin);
    }

    /**
     * 現在事項一部証明書数量を取得します。
     *
     * @return 現在事項一部証明書数量
     */
    public BigDecimal getSu_GenzaiJiko() {
        return (BigDecimal)getValue("Su_GenzaiJiko");
    }

    /**
     * 現在事項一部証明書数量を設定します。
     *
     * @param su_genzaijiko
     *            現在事項一部証明書数量
     */
    public void setSu_GenzaiJiko(BigDecimal Su_GenzaiJiko) {
        setValue("Su_GenzaiJiko", Su_GenzaiJiko);
    }

    /**
     * 印鑑証明書数量を取得します。
     *
     * @return 印鑑証明書数量
     */
    public BigDecimal getSu_InkanShohmei() {
        return (BigDecimal)getValue("Su_InkanShohmei");
    }

    /**
     * 印鑑証明書数量を設定します。
     *
     * @param su_inkanshohmei
     *            印鑑証明書数量
     */
    public void setSu_InkanShohmei(BigDecimal Su_InkanShohmei) {
        setValue("Su_InkanShohmei", Su_InkanShohmei);
    }

    /**
     * 変更抄本数量を取得します。
     *
     * @return 変更抄本数量
     */
    public BigDecimal getSu_HenkoShohhon() {
        return (BigDecimal)getValue("Su_HenkoShohhon");
    }

    /**
     * 変更抄本数量を設定します。
     *
     * @param su_henkoshohhon
     *            変更抄本数量
     */
    public void setSu_HenkoShohhon(BigDecimal Su_HenkoShohhon) {
        setValue("Su_HenkoShohhon", Su_HenkoShohhon);
    }

    /**
     * 新閉鎖謄本数量を取得します。
     *
     * @return 新閉鎖謄本数量
     */
    public BigDecimal getSu_SinHeisa() {
        return (BigDecimal)getValue("Su_SinHeisa");
    }

    /**
     * 新閉鎖謄本数量を設定します。
     *
     * @param su_sinheisa
     *            新閉鎖謄本数量
     */
    public void setSu_SinHeisa(BigDecimal Su_SinHeisa) {
        setValue("Su_SinHeisa", Su_SinHeisa);
    }

    /**
     * 旧閉鎖抄本数量を取得します。
     *
     * @return 旧閉鎖抄本数量
     */
    public BigDecimal getSu_KyuHeisa() {
        return (BigDecimal)getValue("Su_KyuHeisa");
    }

    /**
     * 旧閉鎖抄本数量を設定します。
     *
     * @param su_kyuheisa
     *            旧閉鎖抄本数量
     */
    public void setSu_KyuHeisa(BigDecimal Su_KyuHeisa) {
        setValue("Su_KyuHeisa", Su_KyuHeisa);
    }

    /**
     * 閉鎖事項全部証明書数量を取得します。
     *
     * @return 閉鎖事項全部証明書数量
     */
    public BigDecimal getSu_HeisaJiko() {
        return (BigDecimal)getValue("Su_HeisaJiko");
    }

    /**
     * 閉鎖事項全部証明書数量を設定します。
     *
     * @param su_heisajiko
     *            閉鎖事項全部証明書数量
     */
    public void setSu_HeisaJiko(BigDecimal Su_HeisaJiko) {
        setValue("Su_HeisaJiko", Su_HeisaJiko);
    }

    /**
     * 至急発行フラグを取得します。
     *
     * @return 至急発行フラグ
     */
    public BigDecimal getFlag_ShikyuHakko() {
        return (BigDecimal)getValue("Flag_ShikyuHakko");
    }

    /**
     * 至急発行フラグを設定します。
     *
     * @param flag_shikyuhakko
     *            至急発行フラグ
     */
    public void setFlag_ShikyuHakko(BigDecimal Flag_ShikyuHakko) {
        setValue("Flag_ShikyuHakko", Flag_ShikyuHakko);
    }

    /**
     * 登録日時を取得します。
     *
     * @return 登録日時
     */
    public Timestamp getDateTime_Create() {
        return (Timestamp)getValue("DateTime_Create");
    }

    /**
     * 登録日時を設定します。
     *
     * @param datetime_create
     *            登録日時
     */
    public void setDateTime_Create(Timestamp DateTime_Create) {
        setValue("DateTime_Create", DateTime_Create);
    }

    /**
     * 登録IDを取得します。
     *
     * @return 登録ID
     */
    public String getID_Create() {
        return (String)getValue("ID_Create");
    }

    /**
     * 登録IDを設定します。
     *
     * @param id_create
     *            登録ID
     */
    public void setID_Create(String ID_Create) {
        setValue("ID_Create", ID_Create);
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public Timestamp getDateTime_Update() {
        return (Timestamp)getValue("DateTime_Update");
    }

    /**
     * 更新日時を設定します。
     *
     * @param datetime_update
     *            更新日時
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
    }

    /**
     * 更新IDを取得します。
     *
     * @return 更新ID
     */
    public String getID_Update() {
        return (String)getValue("ID_Update");
    }

    /**
     * 更新IDを設定します。
     *
     * @param id_update
     *            更新ID
     */
    public void setID_Update(String ID_Update) {
        setValue("ID_Update", ID_Update);
    }

    /**
     * column list is returned.
     *
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
     *
     * @see com.fujitsu.xcmfw.dao.entity.PNSingleTableEntity#getPrimaryKeys()
     */
    @Override
    public Set<String> getPrimaryKeys() {

        return PRIMARY_KEYS;
    }

}