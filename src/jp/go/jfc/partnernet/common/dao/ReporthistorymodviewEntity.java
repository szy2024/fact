//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : ReporthistorymodviewEntity
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
 * 報告書取消・修正対象取得ビューのEntityです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class ReporthistorymodviewEntity extends PNSingleTableEntity {

    /** プライマリーキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of(

            );

    /** column list **/
    private static final String[] COLUMN_LIST = {
            "ID_History",
            "ID_Report",
            "Status",
            "DataCode",
            "Type_Process",
            "Flag_Torikeshizumi",
            "Date_Report",
            "Time_Report",
            "Code_KoukoShiten",
            "Code_Organization",
            "Code_Tenpo",
            "Year",
            "Code_HoshikiShikin",
            "ID_Ringi",
            "ID_RingiBranch",
            "ID_Credit",
            "DateTime_Update"

    };

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * ReportHistory.ID_Historyを取得します。
     * @return ReportHistory.ID_History
     */
    public String getID_History() {
        return (String)getValue("ID_History");
    }

    /**
     * ReportHistory.ID_Historyを設定します。
     * @param id_history ReportHistory.ID_History
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * ReportHistory.ID_Reportを取得します。
     * @return ReportHistory.ID_Report
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * ReportHistory.ID_Reportを設定します。
     * @param id_report ReportHistory.ID_Report
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * ReportHistory.Statusを取得します。
     * @return ReportHistory.Status
     */
    public BigDecimal getStatus() {
        return (BigDecimal)getValue("Status");
    }

    /**
     * ReportHistory.Statusを設定します。
     * @param status ReportHistory.Status
     */
    public void setStatus(BigDecimal Status) {
        setValue("Status", Status);
    }

    /**
     * ReportHistory.DataCodeを取得します。
     * @return ReportHistory.DataCode
     */
    public String getDataCode() {
        return (String)getValue("DataCode");
    }

    /**
     * ReportHistory.DataCodeを設定します。
     * @param datacode ReportHistory.DataCode
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * ReportHistory.Type_Processを取得します。
     * @return ReportHistory.Type_Process
     */
    public String getType_Process() {
        return (String)getValue("Type_Process");
    }

    /**
     * ReportHistory.Type_Processを設定します。
     * @param type_process ReportHistory.Type_Process
     */
    public void setType_Process(String Type_Process) {
        setValue("Type_Process", Type_Process);
    }

    /**
     * ReportHistory.Flag_Torikeshizumiを取得します。
     * @return ReportHistory.Flag_Torikeshizumi
     */
    public BigDecimal getFlag_Torikeshizumi() {
        return (BigDecimal)getValue("Flag_Torikeshizumi");
    }

    /**
     * ReportHistory.Flag_Torikeshizumiを設定します。
     * @param flag_torikeshizumi ReportHistory.Flag_Torikeshizumi
     */
    public void setFlag_Torikeshizumi(BigDecimal Flag_Torikeshizumi) {
        setValue("Flag_Torikeshizumi", Flag_Torikeshizumi);
    }

    /**
     * ReportHistory.Date_Reportを取得します。
     * @return ReportHistory.Date_Report
     */
    public String getDate_Report() {
        return (String)getValue("Date_Report");
    }

    /**
     * ReportHistory.Date_Reportを設定します。
     * @param date_report ReportHistory.Date_Report
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * ReportHistory.Time_Reportを取得します。
     * @return ReportHistory.Time_Report
     */
    public String getTime_Report() {
        return (String)getValue("Time_Report");
    }

    /**
     * ReportHistory.Time_Reportを設定します。
     * @param time_report ReportHistory.Time_Report
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * ReportHistory.Code_KoukoShitenを取得します。
     * @return ReportHistory.Code_KoukoShiten
     */
    public String getCode_KoukoShiten() {
        return (String)getValue("Code_KoukoShiten");
    }

    /**
     * ReportHistory.Code_KoukoShitenを設定します。
     * @param code_koukoshiten ReportHistory.Code_KoukoShiten
     */
    public void setCode_KoukoShiten(String Code_KoukoShiten) {
        setValue("Code_KoukoShiten", Code_KoukoShiten);
    }

    /**
     * ReportHistory.Code_Organizationを取得します。
     * @return ReportHistory.Code_Organization
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * ReportHistory.Code_Organizationを設定します。
     * @param code_organization ReportHistory.Code_Organization
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * ReportHistory.Code_Tenpoを取得します。
     * @return ReportHistory.Code_Tenpo
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * ReportHistory.Code_Tenpoを設定します。
     * @param code_tenpo ReportHistory.Code_Tenpo
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * ReportHistory.Yearを取得します。
     * @return ReportHistory.Year
     */
    public String getYear() {
        return (String)getValue("Year");
    }

    /**
     * ReportHistory.Yearを設定します。
     * @param year ReportHistory.Year
     */
    public void setYear(String Year) {
        setValue("Year", Year);
    }

    /**
     * ReportHistory.Code_HoshikiShikinを取得します。
     * @return ReportHistory.Code_HoshikiShikin
     */
    public String getCode_HoshikiShikin() {
        return (String)getValue("Code_HoshikiShikin");
    }

    /**
     * ReportHistory.Code_HoshikiShikinを設定します。
     * @param code_hoshikishikin ReportHistory.Code_HoshikiShikin
     */
    public void setCode_HoshikiShikin(String Code_HoshikiShikin) {
        setValue("Code_HoshikiShikin", Code_HoshikiShikin);
    }

    /**
     * ReportHistory.ID_Ringiを取得します。
     * @return ReportHistory.ID_Ringi
     */
    public String getID_Ringi() {
        return (String)getValue("ID_Ringi");
    }

    /**
     * ReportHistory.ID_Ringiを設定します。
     * @param id_ringi ReportHistory.ID_Ringi
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * ReportHistory.ID_RingiBranchを取得します。
     * @return ReportHistory.ID_RingiBranch
     */
    public String getID_RingiBranch() {
        return (String)getValue("ID_RingiBranch");
    }

    /**
     * ReportHistory.ID_RingiBranchを設定します。
     * @param id_ringibranch ReportHistory.ID_RingiBranch
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * ReportHistory.ID_Creditを取得します。
     * @return ReportHistory.ID_Credit
     */
    public BigDecimal getID_Credit() {
        return (BigDecimal)getValue("ID_Credit");
    }

    /**
     * ReportHistory.ID_Creditを設定します。
     * @param id_credit ReportHistory.ID_Credit
     */
    public void setID_Credit(BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * ReportHistory.DateTime_Updateを取得します。
     * @return ReportHistory.DateTime_Update
     */
    public Timestamp getDateTime_Update() {
        return (Timestamp)getValue("DateTime_Update");
    }

    /**
     * ReportHistory.DateTime_Updateを設定します。
     * @param datetime_update ReportHistory.DateTime_Update
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        setValue("DateTime_Update", DateTime_Update);
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