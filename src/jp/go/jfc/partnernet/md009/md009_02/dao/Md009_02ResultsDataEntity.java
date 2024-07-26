//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd009_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public class Md009_02ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getName_Organization() {
        return (String) getValue("Name_Organization  ");
    }

    /**
     * 扱店名を設定します。
     * @param Name_Organization 扱店名
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization  ", Name_Organization);
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getCode_KoukoShiten() {
        return (String) getValue("Code_KoukoShiten   ");
    }

    /**
     * 公庫支店を設定します。
     * @param Code_KoukoShiten 公庫支店
     */
    public void setCode_KoukoShiten(String Code_KoukoShiten) {
        setValue("Code_KoukoShiten   ", Code_KoukoShiten);
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getCode_Organization() {
        return (String) getValue("Code_Organization  ");
    }

    /**
     * 扱店を設定します。
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization  ", Code_Organization);
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return (String) getValue("Code_Tenpo         ");
    }

    /**
     * 店舗を設定します。
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo         ", Code_Tenpo);
    }

    /**
     * 留置期間利息を取得します。
     * @return 留置期間利息
     */
    public java.math.BigDecimal getM_RyuchiKikanRisoku() {
        return (java.math.BigDecimal) getValue("M_RyuchiKikanRisoku");
    }

    /**
     * 留置期間利息を設定します。
     * @param M_RyuchiKikanRisoku 留置期間利息
     */
    public void setM_RyuchiKikanRisoku(java.math.BigDecimal M_RyuchiKikanRisoku) {
        setValue("M_RyuchiKikanRisoku", M_RyuchiKikanRisoku);
    }

    /**
     * 代弁遅延損害金を取得します。
     * @return 代弁遅延損害金
     */
    public java.math.BigDecimal getM_DaibenChienSongai() {
        return (java.math.BigDecimal) getValue("M_DaibenChienSongai");
    }

    /**
     * 代弁遅延損害金を設定します。
     * @param M_DaibenChienSongai 代弁遅延損害金
     */
    public void setM_DaibenChienSongai(java.math.BigDecimal M_DaibenChienSongai) {
        setValue("M_DaibenChienSongai", M_DaibenChienSongai);
    }

    /**
     * 送金額を取得します。
     * @return 送金額
     */
    public java.math.BigDecimal getM_Sokin() {
        return (java.math.BigDecimal) getValue("M_Sokin            ");
    }

    /**
     * 送金額を設定します。
     * @param M_Sokin 送金額
     */
    public void setM_Sokin(java.math.BigDecimal M_Sokin) {
        setValue("M_Sokin            ", M_Sokin);
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getID_Sokinbi() {
        return (String) getValue("ID_Sokinbi         ");
    }

    /**
     * 送金日番号を設定します。
     * @param ID_Sokinbi 送金日番号
     */
    public void setID_Sokinbi(String ID_Sokinbi) {
        setValue("ID_Sokinbi         ", ID_Sokinbi);
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String) getValue("ID_Report          ");
    }

    /**
     * 報告書番号を設定します。
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report          ", ID_Report);
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getDataCode() {
        return (String) getValue("DataCode           ");
    }

    /**
     * データコードを設定します。
     * @param DataCode データコード
     */
    public void setDataCode(String DataCode) {
        setValue("DataCode           ", DataCode);
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getDate_Jtkshori() {
        return (String) getValue("Date_Jtkshori      ");
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param Date_Jtkshori 受託者勘定処理年月
     */
    public void setDate_Jtkshori(String Date_Jtkshori) {
        setValue("Date_Jtkshori      ", Date_Jtkshori);
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getDate_Sokin() {
        return (String) getValue("Date_Sokin         ");
    }

    /**
     * 送金日を設定します。
     * @param Date_Sokin 送金日
     */
    public void setDate_Sokin(String Date_Sokin) {
        setValue("Date_Sokin         ", Date_Sokin);
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getDate_Nyukin() {
        return (String) getValue("Date_Nyukin        ");
    }

    /**
     * 入金日を設定します。
     * @param Date_Nyukin 入金日
     */
    public void setDate_Nyukin(String Date_Nyukin) {
        setValue("Date_Nyukin        ", Date_Nyukin);
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return (String) getValue("ID_History         ");
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        setValue("ID_History         ", ID_History);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return (String) getValue("Status             ");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        setValue("Status             ", Status);
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getType_Process() {
        return (String) getValue("Type_Process       ");
    }

    /**
     * 処理種別を設定します。
     * @param Type_Process 処理種別
     */
    public void setType_Process(String Type_Process) {
        setValue("Type_Process       ", Type_Process);
    }

    /**
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getKeep_ID_History() {
        return (String) getValue("Keep_ID_History    ");
    }

    /**
     * 退避履歴番号を設定します。
     * @param Keep_ID_History 退避履歴番号
     */
    public void setKeep_ID_History(String Keep_ID_History) {
        setValue("Keep_ID_History    ", Keep_ID_History);
    }

    /**
     * 最新更新日付を取得します。
     * @return 最新更新日付
     */
    public String getData_LastUpDate() {
        return (String) getValue("Data_LastUpDate    ");
    }

    /**
     * 最新更新日付を設定します。
     * @param Keep_ID_History 最新更新日付
     */
    public void setData_LastUpDate(String Data_LastUpDate) {
        setValue("Data_LastUpDate    ", Data_LastUpDate);
    }

}