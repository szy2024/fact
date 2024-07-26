//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd008_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class Md008_02ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getCode_Organization() {
        return (String) getValue("Code_Organization");
    }

    /**
     * 扱店を設定します。
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String) getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getName_Customer() {
        return (String) getValue("Name_Customer");
    }

    /**
     * 顧客名を設定します。
     * @param Name_Customer 顧客名
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_Organization() {
        return (String) getValue("Name_Organization");
    }

    /**
     * 扱店名を設定します。
     * @param Name_Organization 扱店名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getCode_KoukoShiten() {
        return (String) getValue("Code_KoukoShiten");
    }

    /**
     * 公庫支店を設定します。
     * @param Code_KoukoShiten 公庫支店
     */
    public void setCode_KoukoShiten(String Code_KoukoShiten) {
        setValue("Code_KoukoShiten", Code_KoukoShiten);
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return (String) getValue("Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getYear() {
        return (String) getValue("Year");
    }

    /**
     * 年度を設定します。
     * @param Year 年度
     */
    public void setYear(String Year) {
        setValue("Year", Year);
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getCode_HoshikiShikin() {
        return (String) getValue("Code_HoshikiShikin");
    }

    /**
     * 方式資金を設定します。
     * @param Code_HoshikiShikin 方式資金
     */
    public void setCode_HoshikiShikin(String Code_HoshikiShikin) {
        setValue("Code_HoshikiShikin", Code_HoshikiShikin);
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_Ringi() {
        return (String) getValue("ID_Ringi");
    }

    /**
     * 番号を設定します。
     * @param ID_Ringi 番号
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_RingiBranch() {
        return (String) getValue("ID_RingiBranch");
    }

    /**
     * 枝番を設定します。
     * @param ID_RingiBranch 枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * 仮受金(一般口)受入額を取得します。
     * @return 仮受金(一般口)受入額
     */
    public java.math.BigDecimal getM_KariukeIppanUkeire() {
        return (java.math.BigDecimal) getValue("M_KariukeIppanUkeire");
    }

    /**
     * 仮受金(一般口)受入額を設定します。
     * @param M_KariukeIppanUkeire 仮受金(一般口)受入額
     */
    public void setM_KariukeIppanUkeire(java.math.BigDecimal M_KariukeIppanUkeire) {
        setValue("M_KariukeIppanUkeire", M_KariukeIppanUkeire);
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getID_Sokinbi() {
        return (String) getValue("ID_Sokinbi");
    }

    /**
     * 送金日番号を設定します。
     * @param ID_Sokinbi 送金日番号
     */
    public void setID_Sokinbi(String ID_Sokinbi) {
        setValue("ID_Sokinbi", ID_Sokinbi);
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getDate_Jtkshori() {
        return (String) getValue("Date_Jtkshori");
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param Date_Jtkshori 受託者勘定処理年月
     */
    public void setDate_Jtkshori(String Date_Jtkshori) {
        setValue("Date_Jtkshori", Date_Jtkshori);
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getDate_Sokin() {
        return (String) getValue("Date_Sokin");
    }

    /**
     * 送金日を設定します。
     * @param Date_Sokin 送金日
     */
    public void setDate_Sokin(String Date_Sokin) {
        setValue("Date_Sokin", Date_Sokin);
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getDate_Nyukin() {
        return (String) getValue("Date_Nyukin");
    }

    /**
     * 入金日を設定します。
     * @param Date_Nyukin 入金日
     */
    public void setDate_Nyukin(String Date_Nyukin) {
        setValue("Date_Nyukin", Date_Nyukin);
    }

    /**
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getKeep_ID_History() {
        return (String) getValue("Keep_ID_History");
    }

    /**
     * 退避履歴番号を設定します。
     * @param Keep_ID_History 退避履歴番号
     */
    public void setKeep_ID_History(String Keep_ID_History) {
        setValue("Keep_ID_History", Keep_ID_History);
    }

    /**
     * 履歴番号（非表示）を取得します。
     * @return 履歴番号（非表示）
     */
    public String getID_History() {
        return (String) getValue("ID_History");
    }

    /**
     * 履歴番号（非表示）を設定します。
     * @param ID_History 履歴番号（非表示）
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * 処理種別（非表示）を取得します。
     * @return 処理種別（非表示）
     */
    public String getType_Process() {
        return (String) getValue("Type_Process");
    }

    /**
     * 処理種別（非表示）を設定します。
     * @param Type_Process 処理種別（非表示）
     */
    public void setType_Process(String Type_Process) {
        setValue("Type_Process", Type_Process);
    }

    /**
     * 取消済みフラグ（非表示）を取得します。
     * @return 取消済みフラグ（非表示）
     */
    public String getFlag_Torikeshizumi() {
        return (String) getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済みフラグ（非表示）を設定します。
     * @param Flag_Torikeshizumi 取消済みフラグ（非表示）
     */
    public void setFlag_Torikeshizumi(String Flag_Torikeshizumi) {
        setValue("Flag_Torikeshizumi", Flag_Torikeshizumi);
    }

    /**
     * 伝送番号（非表示）を取得します。
     * @return 伝送番号（非表示）
     */
    public String getID_Denso() {
        return (String) getValue("ID_Denso");
    }

    /**
     * 伝送番号（非表示）を設定します。
     * @param ID_Denso 伝送番号（非表示）
     */
    public void setID_Denso(String ID_Denso) {
        setValue("ID_Denso", ID_Denso);
    }

    /**
     * ステータス（値）（非表示）を取得します。
     * @return ステータス（値）（非表示）
     */
    public String getStatus() {
        return (String) getValue("Status");
    }

    /**
     * ステータス（値）（非表示）を設定します。
     * @param Status ステータス（値）（非表示）
     */
    public void setStatus(String Status) {
        setValue("Status", Status);
    }

    /**
     * データコード（非表示）を取得します。
     * @return データコード（非表示）
     */
    public String getDataCode() {
        return (String) getValue("DataCode");
    }

    /**
     * データコード（非表示）を設定します。
     * @param DataCode データコード（非表示）
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * ユーザID（非表示）を取得します。
     * @return ユーザID（非表示）
     */
    public String getUserID() {
        return (String) getValue("UserID");
    }

    /**
     * ユーザID（非表示）を設定します。
     * @param UserID ユーザID（非表示）
     */
    public void setUserID(String UserID) {
        setValue("UserID", UserID);
    }

    /**
     * 最新データ更新日付（非表示）を取得します。
     * @return 最新データ更新日付（非表示）
     */
    public String getData_LastUpDate() {
        return (String) getValue("Data_LastUpDate");
    }

    /**
     * 最新データ更新日付（非表示）を設定します。
     * @param Data_LastUpDate 最新データ更新日付（非表示）
     */
    public void setData_LastUpDate(String Data_LastUpDate) {
        setValue("Data_LastUpDate", Data_LastUpDate);
    }

}