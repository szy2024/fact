//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_01TatekaeReportModViewEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 矢嶋　洋              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd006_01TatekaeReportModViewDAOのEntityクラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
public class Md006_01TatekaeReportModViewEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String) getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     * @param Date_Report 報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getName_Organization() {
        return (String) getValue("Name_Organization");
    }

    /**
     * 顧客名を設定します。
     * @param Name_Organization 顧客名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_Customer() {
        return (String) getValue("Name_Customer");
    }

    /**
     * 扱店名を設定します。
     * @param Name_Customer 扱店名
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
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
     * 立替金の種類を取得します。
     * @return 立替金の種類
     */
    public String getCode_TatekaekinShurui() {
        return (String) getValue("Code_TatekaekinShurui");
    }

    /**
     * 立替金の種類を設定します。
     * @param Code_TatekaekinShurui 立替金の種類
     */
    public void setCode_TatekaekinShurui(String Code_TatekaekinShurui) {
        setValue("Code_TatekaekinShurui", Code_TatekaekinShurui);
    }

    /**
     * 公庫立替日を取得します。
     * @return 公庫立替日
     */
    public String getDate_KoukoTatekae() {
        return (String) getValue("Date_KoukoTatekae");
    }

    /**
     * 公庫立替日を設定します。
     * @param Date_KoukoTatekae 公庫立替日
     */
    public void setDate_KoukoTatekae(String Date_KoukoTatekae) {
        setValue("Date_KoukoTatekae", Date_KoukoTatekae);
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
     * 立替金利息(円)を取得します。
     * @return 立替金利息(円)
     */
    public java.math.BigDecimal getM_TatekaeRisoku() {
        return (java.math.BigDecimal) getValue("M_TatekaeRisoku");
    }

    /**
     * 立替金利息(円)を設定します。
     * @param M_TatekaeRisoku 立替金利息(円)
     */
    public void setM_TatekaeRisoku(java.math.BigDecimal M_TatekaeRisoku) {
        setValue("M_TatekaeRisoku", M_TatekaeRisoku);
    }

    /**
     * 立替金（円）を取得します。
     * @return 立替金（円）
     */
    public java.math.BigDecimal getM_Tatekae() {
        return (java.math.BigDecimal) getValue("M_Tatekae");
    }

    /**
     * 立替金（円）を設定します。
     * @param M_Tatekae 立替金（円）
     */
    public void setM_Tatekae(java.math.BigDecimal M_Tatekae) {
        setValue("M_Tatekae", M_Tatekae);
    }

    /**
     * 計（円）を取得します。
     * @return 計（円）
     */
    public java.math.BigDecimal getM_Kei() {
        return (java.math.BigDecimal) getValue("M_Kei");
    }

    /**
     * 計（円）を設定します。
     * @param M_Kei 計（円）
     */
    public void setM_Kei(java.math.BigDecimal M_Kei) {
        setValue("M_Kei", M_Kei);
    }

    /**
     * 仮受金(一般口)からの充当額(円)を取得します。
     * @return 仮受金(一般口)からの充当額(円)
     */
    public java.math.BigDecimal getM_KariukeIppanJuto() {
        return (java.math.BigDecimal) getValue("M_KariukeIppanJuto");
    }

    /**
     * 仮受金(一般口)からの充当額(円)を設定します。
     * @param M_KariukeIppanJuto 仮受金(一般口)からの充当額(円)
     */
    public void setM_KariukeIppanJuto(java.math.BigDecimal M_KariukeIppanJuto) {
        setValue("M_KariukeIppanJuto", M_KariukeIppanJuto);
    }

    /**
     * 送金額（円）を取得します。
     * @return 送金額（円）
     */
    public java.math.BigDecimal getM_Sokin() {
        return (java.math.BigDecimal) getValue("M_Sokin");
    }

    /**
     * 送金額（円）を設定します。
     * @param M_Sokin 送金額（円）
     */
    public void setM_Sokin(java.math.BigDecimal M_Sokin) {
        setValue("M_Sokin", M_Sokin);
    }

    /**
     * 受入後立替金残高(円)を取得します。
     * @return 受入後立替金残高(円)
     */
    public java.math.BigDecimal getM_TatekaeZanAfterUkeire() {
        return (java.math.BigDecimal) getValue("M_TatekaeZanAfterUkeire");
    }

    /**
     * 受入後立替金残高(円)を設定します。
     * @param M_TatekaeZanAfterUkeire 受入後立替金残高(円)
     */
    public void setM_TatekaeZanAfterUkeire(java.math.BigDecimal M_TatekaeZanAfterUkeire) {
        setValue("M_TatekaeZanAfterUkeire", M_TatekaeZanAfterUkeire);
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
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getTime_Report() {
        return (String) getValue("Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     * @param Time_Report 報告時分秒
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserID() {
        return (String) getValue("UserID");
    }

    /**
     * ユーザIDを設定します。
     * @param UserID ユーザID
     */
    public void setUserID(String UserID) {
        setValue("UserID", UserID);
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
     */
    public String getID_Denso() {
        return (String) getValue("ID_Denso");
    }

    /**
     * 伝送番号を設定します。
     * @param ID_Denso 伝送番号
     */
    public void setID_Denso(String ID_Denso) {
        setValue("ID_Denso", ID_Denso);
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return (String) getValue("DataCode");
    }

    /**
     * データコードを設定します。
     * @param DataCode データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode", DataCode);
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return (String) getValue("ID_History");
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public java.math.BigDecimal getStatus() {
        return (java.math.BigDecimal) getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(java.math.BigDecimal Status) {
        setValue("Status", Status);
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getType_Process() {
        return (String) getValue("Type_Process");
    }

    /**
     * 処理種別を設定します。
     * @param Type_Process 処理種別
     */
    public void setType_Process(String Type_Process) {
        setValue("Type_Process", Type_Process);
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public java.math.BigDecimal getFlag_Torikeshizumi() {
        return (java.math.BigDecimal) getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグを設定します。
     * @param Flag_Torikeshizumi 取消済フラグ
     */
    public void setFlag_Torikeshizumi(java.math.BigDecimal Flag_Torikeshizumi) {
        setValue("Flag_Torikeshizumi", Flag_Torikeshizumi);
    }

    /**
     * エラーコードを取得します。
     * @return エラーコード
     */
    public String getCode_Error() {
        return (String) getValue("Code_Error");
    }

    /**
     * エラーコードを設定します。
     * @param Code_Error エラーコード
     */
    public void setCode_Error(String Code_Error) {
        setValue("Code_Error", Code_Error);
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getErrorMessage() {
        return (String) getValue("ErrorMessage");
    }

    /**
     * エラーメッセージを設定します。
     * @param ErrorMessage エラーメッセージ
     */
    public void setErrorMessage(String ErrorMessage) {
        setValue("ErrorMessage", ErrorMessage);
    }

    /**
     * 原本番号を取得します。
     * @return 原本番号
     */
    public String getID_Master() {
        return (String) getValue("ID_Master");
    }

    /**
     * 原本番号を設定します。
     * @param ID_Master 原本番号
     */
    public void setID_Master(String ID_Master) {
        setValue("ID_Master", ID_Master);
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_Credit() {
        return (java.math.BigDecimal) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(java.math.BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
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
     * 退避貸付実行報告書作成済みフラグを取得します。
     * @return 退避貸付実行報告書作成済みフラグ
     */
    public java.math.BigDecimal getKeep_Flag_Kj() {
        return (java.math.BigDecimal) getValue("Keep_Flag_Kj");
    }

    /**
     * 退避貸付実行報告書作成済みフラグを設定します。
     * @param Keep_Flag_Kj 退避貸付実行報告書作成済みフラグ
     */
    public void setKeep_Flag_Kj(java.math.BigDecimal Keep_Flag_Kj) {
        setValue("Keep_Flag_Kj", Keep_Flag_Kj);
    }

    /**
     * 退避受入後立替金残高を取得します。
     * @return 退避受入後立替金残高
     */
    public java.math.BigDecimal getKeep_M_TatekaeZanAfterUkeire() {
        return (java.math.BigDecimal) getValue("Keep_M_TatekaeZanAfterUkeire");
    }

    /**
     * 退避受入後立替金残高を設定します。
     * @param Keep_M_TatekaeZanAfterUkeire 退避受入後立替金残高
     */
    public void setKeep_M_TatekaeZanAfterUkeire(java.math.BigDecimal Keep_M_TatekaeZanAfterUkeire) {
        setValue("Keep_M_TatekaeZanAfterUkeire", Keep_M_TatekaeZanAfterUkeire);
    }

    /**
     * 最新更新日時を取得します。
     * @return 最新更新日時
     */
    public java.sql.Timestamp getData_LastUpDate() {
        return (java.sql.Timestamp) getValue("Data_LastUpDate");
    }

    /**
     * 最新更新日時を設定します。
     * @param Data_LastUpDate 最新更新日時
     */
    public void setData_LastUpDate(java.sql.Timestamp Data_LastUpDate) {
        setValue("Data_LastUpDate", Data_LastUpDate);
    }

    /**
     * 退避仮受仮払番号を取得します。
     * @return 退避仮受仮払番号
     */
    public String getKeep_ID_Karibarai() {
        return (String) getValue("Keep_ID_Karibarai");
    }

    /**
     * 退避仮受仮払番号を設定します。
     * @param Keep_ID_Karibarai 退避仮受仮払番号
     */
    public void setKeep_ID_Karibarai(String Keep_ID_Karibarai) {
        setValue("Keep_ID_Karibarai", Keep_ID_Karibarai);
    }

    /**
     * 退避本支店コードを取得します。
     * @return 退避本支店コード
     */
    public String getKeep_Code_HonShiten() {
        return (String) getValue("Keep_Code_HonShiten");
    }

    /**
     * 退避本支店コードを設定します。
     * @param Keep_Code_HonShiten 退避本支店コード
     */
    public void setKeep_Code_HonShiten(String Keep_Code_HonShiten) {
        setValue("Keep_Code_HonShiten", Keep_Code_HonShiten);
    }

}