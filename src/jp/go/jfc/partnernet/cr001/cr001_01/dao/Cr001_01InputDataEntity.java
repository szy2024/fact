//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01InputDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr001_01InputDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr001_01InputDataEntity extends PNBaseEntity {

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
    public String getCode_ShokanHonShiten() {
        return (String) getValue("Code_ShokanHonShiten");
    }

    /**
     * 公庫支店を設定します。
     * @param Code_ShokanHonShiten 公庫支店
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        setValue("Code_ShokanHonShiten", Code_ShokanHonShiten);
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
     * 資金使途を取得します。
     * @return 資金使途
     */
    public String getCode_ShikinShito() {
        return (String) getValue("Code_ShikinShito");
    }

    /**
     * 資金使途を設定します。
     * @param Code_ShikinShito 資金使途
     */
    public void setCode_ShikinShito(String Code_ShikinShito) {
        setValue("Code_ShikinShito", Code_ShikinShito);
    }

    /**
     * 事業別を取得します。
     * @return 事業別
     */
    public String getCode_Jigyobetsu() {
        return (String) getValue("Code_Jigyobetsu");
    }

    /**
     * 事業別を設定します。
     * @param Code_Jigyobetsu 事業別
     */
    public void setCode_Jigyobetsu(String Code_Jigyobetsu) {
        setValue("Code_Jigyobetsu", Code_Jigyobetsu);
    }

    /**
     * 利率（%）を取得します。
     * @return 利率（%）
     */
    public String getRiritsu() {
        return (String) getValue("Riritsu");
    }

    /**
     * 利率（%）を設定します。
     * @param Riritsu 利率（%）
     */
    public void setRiritsu(String Riritsu) {
        setValue("Riritsu", Riritsu);
    }

    /**
     * 特利区分を取得します。
     * @return 特利区分
     */
    public String getKubun_Tokuri() {
        return (String) getValue("Kubun_Tokuri");
    }

    /**
     * 特利区分を設定します。
     * @param Kubun_Tokuri 特利区分
     */
    public void setKubun_Tokuri(String Kubun_Tokuri) {
        setValue("Kubun_Tokuri", Kubun_Tokuri);
    }

    /**
     * 特利（%）を取得します。
     * @return 特利（%）
     */
    public String getTokuri() {
        return (String) getValue("Tokuri");
    }

    /**
     * 特利（%）を設定します。
     * @param Tokuri 特利（%）
     */
    public void setTokuri(String Tokuri) {
        setValue("Tokuri", Tokuri);
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getDate_SueokiKigen() {
        return (String) getValue("Date_SueokiKigen");
    }

    /**
     * 据置期限を設定します。
     * @param Date_SueokiKigen 据置期限
     */
    public void setDate_SueokiKigen(String Date_SueokiKigen) {
        setValue("Date_SueokiKigen", Date_SueokiKigen);
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getDate_ShokanKigen() {
        return (String) getValue("Date_ShokanKigen");
    }

    /**
     * 償還期限を設定します。
     * @param Date_ShokanKigen 償還期限
     */
    public void setDate_ShokanKigen(String Date_ShokanKigen) {
        setValue("Date_ShokanKigen", Date_ShokanKigen);
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getDate_GanrikinHaraiKomi() {
        return (String) getValue("Date_GanrikinHaraiKomi");
    }

    /**
     * 元利金払込日を設定します。
     * @param Date_GanrikinHaraiKomi 元利金払込日
     */
    public void setDate_GanrikinHaraiKomi(String Date_GanrikinHaraiKomi) {
        setValue("Date_GanrikinHaraiKomi", Date_GanrikinHaraiKomi);
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
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getDate_Kashitsukejikko() {
        return (String) getValue("Date_Kashitsukejikko");
    }

    /**
     * 貸付実行日を設定します。
     * @param Date_Kashitsukejikko 貸付実行日
     */
    public void setDate_Kashitsukejikko(String Date_Kashitsukejikko) {
        setValue("Date_Kashitsukejikko", Date_Kashitsukejikko);
    }

    /**
     * 貸付実行金額（円）を取得します。
     * @return 貸付実行金額（円）
     */
    public java.math.BigDecimal getM_Kashitsuke() {
        return (java.math.BigDecimal) getValue("M_Kashitsuke");
    }

    /**
     * 貸付実行金額（円）を設定します。
     * @param M_Kashitsuke 貸付実行金額（円）
     */
    public void setM_Kashitsuke(java.math.BigDecimal M_Kashitsuke) {
        setValue("M_Kashitsuke", M_Kashitsuke);
    }

    /**
     * 資金交付額（円）を取得します。
     * @return 資金交付額（円）
     */
    public java.math.BigDecimal getM_ShikinKofu() {
        return (java.math.BigDecimal) getValue("M_ShikinKofu");
    }

    /**
     * 資金交付額（円）を設定します。
     * @param M_ShikinKofu 資金交付額（円）
     */
    public void setM_ShikinKofu(java.math.BigDecimal M_ShikinKofu) {
        setValue("M_ShikinKofu", M_ShikinKofu);
    }

    /**
     * 貸付受入金受入額（円）を取得します。
     * @return 貸付受入金受入額（円）
     */
    public java.math.BigDecimal getM_KashitukeUkeire() {
        return (java.math.BigDecimal) getValue("M_KashitukeUkeire");
    }

    /**
     * 貸付受入金受入額（円）を設定します。
     * @param M_KashitukeUkeire 貸付受入金受入額（円）
     */
    public void setM_KashitukeUkeire(java.math.BigDecimal M_KashitukeUkeire) {
        setValue("M_KashitukeUkeire", M_KashitukeUkeire);
    }

    /**
     * 貸付実行報告書作成済みフラグを取得します。
     * @return 貸付実行報告書作成済みフラグ
     */
    public Integer getFlag_Kj() {
        return (Integer) getValue("Flag_Kj");
    }

    /**
     * 貸付実行報告書作成済みフラグを設定します。
     * @param Flag_Kj 貸付実行報告書作成済みフラグ
     */
    public void setFlag_Kj(Integer Flag_Kj) {
        setValue("Flag_Kj", Flag_Kj);
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
     * 貸付件数を取得します。
     * @return 貸付件数
     */
    public String getCount_Kashitsuke() {
        return (String) getValue("Count_Kashitsuke");
    }

    /**
     * 貸付件数を設定します。
     * @param Count_Kashitsuke 貸付件数
     */
    public void setCount_Kashitsuke(String Count_Kashitsuke) {
        setValue("Count_Kashitsuke", Count_Kashitsuke);
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
    public Integer getStatus() {
        return (Integer) getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(Integer Status) {
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
    public String getFlag_Torikeshizumi() {
        return (String) getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグを設定します。
     * @param Flag_Torikeshizumi 取消済フラグ
     */
    public void setFlag_Torikeshizumi(String Flag_Torikeshizumi) {
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
     * 貸付先コードを取得します。
     * @return 貸付先コード
     */
    public String getCode_Customer() {
        return (String) getValue("Code_Customer");
    }

    /**
     * 貸付先コードを設定します。
     * @param Code_Customer 貸付先コード
     */
    public void setCode_Customer(String Code_Customer) {
        setValue("Code_Customer", Code_Customer);
    }

    /**
     * 実行起算予定日を取得します。
     * @return 実行起算予定日
     */
    public String getDate_JuriKisan() {
        return (String) getValue("Date_JuriKisan");
    }

    /**
     * 実行起算予定日を設定します。
     * @param Date_JuriKisan 実行起算予定日
     */
    public void setDate_JuriKisan(String Date_JuriKisan) {
        setValue("Date_JuriKisan", Date_JuriKisan);
    }

    /**
     * 決定起算年月日を取得します。
     * @return 決定起算年月日
     */
    public String getDate_KetteiKisan() {
        return (String) getValue("Date_KetteiKisan");
    }

    /**
     * 決定起算年月日を設定します。
     * @param Date_KetteiKisan 決定起算年月日
     */
    public void setDate_KetteiKisan(String Date_KetteiKisan) {
        setValue("Date_KetteiKisan", Date_KetteiKisan);
    }

    /**
     * 最新データ更新日付を取得します。
     * @return 最新データ更新日付
     */
    public java.sql.Timestamp getData_LastUpDate() {
        return (java.sql.Timestamp) getValue("Data_LastUpDate");
    }

    /**
     * 最新データ更新日付を設定します。
     * @param Data_LastUpDate 最新データ更新日付
     */
    public void setData_LastUpDate(java.sql.Timestamp Data_LastUpDate) {
        setValue("Data_LastUpDate", Data_LastUpDate);
    }

    /**
     * 貸付実行予定日を取得します。
     * @return 貸付実行予定日
     */
    public String getDate_Jikko() {
        return (String) getValue("Date_Jikko");
    }

    /**
     * 貸付実行予定日を設定します。
     * @param Date_Jikko 貸付実行予定日
     */
    public void setDate_Jikko(String Date_Jikko) {
        setValue("Date_Jikko", Date_Jikko);
    }

}