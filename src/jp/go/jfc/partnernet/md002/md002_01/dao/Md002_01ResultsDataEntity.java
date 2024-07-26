//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_01ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd002_01ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_01ResultsDataEntity extends PNBaseEntity {

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
     * 利率を取得します。
     * @return 利率
     */
    public java.math.BigDecimal getRiritsu() {
        return (java.math.BigDecimal) getValue("Riritsu");
    }

    /**
     * 利率を設定します。
     * @param Riritsu 利率
     */
    public void setRiritsu(java.math.BigDecimal Riritsu) {
        setValue("Riritsu", Riritsu);
    }

    /**
     * 特利区分を取得します。
     * @return 特利区分
     */
    public String getCode_TokuriKubun() {
        return (String) getValue("Code_TokuriKubun");
    }

    /**
     * 特利区分を設定します。
     * @param Code_TokuriKubun 特利区分
     */
    public void setCode_TokuriKubun(String Code_TokuriKubun) {
        setValue("Code_TokuriKubun", Code_TokuriKubun);
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public java.math.BigDecimal getTokuri() {
        return (java.math.BigDecimal) getValue("Tokuri");
    }

    /**
     * 特利を設定します。
     * @param Tokuri 特利
     */
    public void setTokuri(java.math.BigDecimal Tokuri) {
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
     * 元利金払込期日を取得します。
     * @return 元利金払込期日
     */
    public String getDate_GanrikinHaraikomi() {
        return (String) getValue("Date_GanrikinHaraikomi");
    }

    /**
     * 元利金払込期日を設定します。
     * @param Date_GanrikinHaraikomi 元利金払込期日
     */
    public void setDate_GanrikinHaraikomi(String Date_GanrikinHaraikomi) {
        setValue("Date_GanrikinHaraikomi", Date_GanrikinHaraikomi);
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getDate_Jikko() {
        return (String) getValue("Date_Jikko");
    }

    /**
     * 貸付実行日を設定します。
     * @param Date_Jikko 貸付実行日
     */
    public void setDate_Jikko(String Date_Jikko) {
        setValue("Date_Jikko", Date_Jikko);
    }

    /**
     * 貸付実行額金額を取得します。
     * @return 貸付実行額金額
     */
    public java.math.BigDecimal getM_Kashitsuke() {
        return (java.math.BigDecimal) getValue("M_Kashitsuke");
    }

    /**
     * 貸付実行額金額を設定します。
     * @param M_Kashitsuke 貸付実行額金額
     */
    public void setM_Kashitsuke(java.math.BigDecimal M_Kashitsuke) {
        setValue("M_Kashitsuke", M_Kashitsuke);
    }

    /**
     * 資金交付額を取得します。
     * @return 資金交付額
     */
    public java.math.BigDecimal getM_ShikinKofu() {
        return (java.math.BigDecimal) getValue("M_ShikinKofu");
    }

    /**
     * 資金交付額を設定します。
     * @param M_ShikinKofu 資金交付額
     */
    public void setM_ShikinKofu(java.math.BigDecimal M_ShikinKofu) {
        setValue("M_ShikinKofu", M_ShikinKofu);
    }

    /**
     * 貸付受入金受入額を取得します。
     * @return 貸付受入金受入額
     */
    public java.math.BigDecimal getM_KashitsukeUkeire() {
        return (java.math.BigDecimal) getValue("M_KashitsukeUkeire");
    }

    /**
     * 貸付受入金受入額を設定します。
     * @param M_KashitsukeUkeire 貸付受入金受入額
     */
    public void setM_KashitsukeUkeire(java.math.BigDecimal M_KashitsukeUkeire) {
        setValue("M_KashitsukeUkeire", M_KashitsukeUkeire);
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
     * 払出・元金充当日を取得します。
     * @return 払出・元金充当日
     */
    public String getDate_HaraidashiJuto() {
        return (String) getValue("Date_HaraidashiJuto");
    }

    /**
     * 払出・元金充当日を設定します。
     * @param Date_HaraidashiJuto 払出・元金充当日
     */
    public void setDate_HaraidashiJuto(String Date_HaraidashiJuto) {
        setValue("Date_HaraidashiJuto", Date_HaraidashiJuto);
    }

    /**
     * 資金払出額を取得します。
     * @return 資金払出額
     */
    public java.math.BigDecimal getM_Haraidashi() {
        return (java.math.BigDecimal) getValue("M_Haraidashi");
    }

    /**
     * 資金払出額を設定します。
     * @param M_Haraidashi 資金払出額
     */
    public void setM_Haraidashi(java.math.BigDecimal M_Haraidashi) {
        setValue("M_Haraidashi", M_Haraidashi);
    }

    /**
     * 元金充当額を取得します。
     * @return 元金充当額
     */
    public java.math.BigDecimal getM_Ganju() {
        return (java.math.BigDecimal) getValue("M_Ganju");
    }

    /**
     * 元金充当額を設定します。
     * @param M_Ganju 元金充当額
     */
    public void setM_Ganju(java.math.BigDecimal M_Ganju) {
        setValue("M_Ganju", M_Ganju);
    }

    /**
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public java.math.BigDecimal getM_KashitsukeukeireZan() {
        return (java.math.BigDecimal) getValue("M_KashitsukeukeireZan");
    }

    /**
     * 貸付受入金残高を設定します。
     * @param M_KashitsukeukeireZan 貸付受入金残高
     */
    public void setM_KashitsukeukeireZan(java.math.BigDecimal M_KashitsukeukeireZan) {
        setValue("M_KashitsukeukeireZan", M_KashitsukeukeireZan);
    }

    /**
     * 元金充当後貸付金残高を取得します。
     * @return 元金充当後貸付金残高
     */
    public java.math.BigDecimal getM_KashitsukeZandakaAfterGanju() {
        return (java.math.BigDecimal) getValue("M_KashitsukeZandakaAfterGanju");
    }

    /**
     * 元金充当後貸付金残高を設定します。
     * @param M_KashitsukeZandakaAfterGanju 元金充当後貸付金残高
     */
    public void setM_KashitsukeZandakaAfterGanju(java.math.BigDecimal M_KashitsukeZandakaAfterGanju) {
        setValue("M_KashitsukeZandakaAfterGanju", M_KashitsukeZandakaAfterGanju);
    }

    /**
     * 元金充当後第１回約定日を取得します。
     * @return 元金充当後第１回約定日
     */
    public String getDate_FirstYakujoAfterGanju() {
        return (String) getValue("Date_FirstYakujoAfterGanju");
    }

    /**
     * 元金充当後第１回約定日を設定します。
     * @param Date_FirstYakujoAfterGanju 元金充当後第１回約定日
     */
    public void setDate_FirstYakujoAfterGanju(String Date_FirstYakujoAfterGanju) {
        setValue("Date_FirstYakujoAfterGanju", Date_FirstYakujoAfterGanju);
    }

    /**
     * 繰上償還事由コードを取得します。
     * @return 繰上償還事由コード
     */
    public String getCode_KurishoJiyu() {
        return (String) getValue("Code_KurishoJiyu");
    }

    /**
     * 繰上償還事由コードを設定します。
     * @param Code_KurishoJiyu 繰上償還事由コード
     */
    public void setCode_KurishoJiyu(String Code_KurishoJiyu) {
        setValue("Code_KurishoJiyu", Code_KurishoJiyu);
    }

    /**
     * 元金充当後の元金均等額を取得します。
     * @return 元金充当後の元金均等額
     */
    public java.math.BigDecimal getM_GankinKintoAfterGanju() {
        return (java.math.BigDecimal) getValue("M_GankinKintoAfterGanju");
    }

    /**
     * 元金充当後の元金均等額を設定します。
     * @param M_GankinKintoAfterGanju 元金充当後の元金均等額
     */
    public void setM_GankinKintoAfterGanju(java.math.BigDecimal M_GankinKintoAfterGanju) {
        setValue("M_GankinKintoAfterGanju", M_GankinKintoAfterGanju);
    }

    /**
     * 元金充当後の元金不均等額を取得します。
     * @return 元金充当後の元金不均等額
     */
    public java.math.BigDecimal getM_GankinFukintoAfterGanju() {
        return (java.math.BigDecimal) getValue("M_GankinFukintoAfterGanju");
    }

    /**
     * 元金充当後の元金不均等額を設定します。
     * @param M_GankinFukintoAfterGanju 元金充当後の元金不均等額
     */
    public void setM_GankinFukintoAfterGanju(java.math.BigDecimal M_GankinFukintoAfterGanju) {
        setValue("M_GankinFukintoAfterGanju", M_GankinFukintoAfterGanju);
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getCode_Chosei() {
        return (String) getValue("Code_Chosei");
    }

    /**
     * 調整コードを設定します。
     * @param Code_Chosei 調整コード
     */
    public void setCode_Chosei(String Code_Chosei) {
        setValue("Code_Chosei", Code_Chosei);
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
     * 報告時分秒（非表示）を取得します。
     * @return 報告時分秒（非表示）
     */
    public String getTime_Report() {
        return (String) getValue("Time_Report");
    }

    /**
     * 報告時分秒（非表示）を設定します。
     * @param Time_Report 報告時分秒（非表示）
     */
    public void setTime_Report(String Time_Report) {
        setValue("Time_Report", Time_Report);
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
     * 合計（非表示）を取得します。
     * @return 合計（非表示）
     */
    public java.math.BigDecimal getM_Kei() {
        return (java.math.BigDecimal) getValue("M_Kei");
    }

    /**
     * 合計（非表示）を設定します。
     * @param M_Kei 合計（非表示）
     */
    public void setM_Kei(java.math.BigDecimal M_Kei) {
        setValue("M_Kei", M_Kei);
    }

    /**
     * 報告書履歴番号（非表示）を取得します。
     * @return 報告書履歴番号（非表示）
     */
    public String getID_History() {
        return (String) getValue("ID_History");
    }

    /**
     * 報告書履歴番号（非表示）を設定します。
     * @param ID_History 報告書履歴番号（非表示）
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * ステータス（非表示）を取得します。
     * @return ステータス（非表示）
     */
    public String getStatus() {
        return (String) getValue("Status");
    }

    /**
     * ステータス（非表示）を設定します。
     * @param Status ステータス（非表示）
     */
    public void setStatus(String Status) {
        setValue("Status", Status);
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
     * エラーコード（非表示）を取得します。
     * @return エラーコード（非表示）
     */
    public String getCode_Error() {
        return (String) getValue("Code_Error");
    }

    /**
     * エラーコード（非表示）を設定します。
     * @param Code_Error エラーコード（非表示）
     */
    public void setCode_Error(String Code_Error) {
        setValue("Code_Error", Code_Error);
    }

    /**
     * エラーメッセージ（非表示）を取得します。
     * @return エラーメッセージ（非表示）
     */
    public String getErrorMessage() {
        return (String) getValue("ErrorMessage");
    }

    /**
     * エラーメッセージ（非表示）を設定します。
     * @param ErrorMessage エラーメッセージ（非表示）
     */
    public void setErrorMessage(String ErrorMessage) {
        setValue("ErrorMessage", ErrorMessage);
    }

    /**
     * 債権管理番号（非表示）を取得します。
     * @return 債権管理番号（非表示）
     */
    public java.math.BigDecimal getID_Credit() {
        return (java.math.BigDecimal) getValue("ID_Credit");
    }

    /**
     * 債権管理番号（非表示）を設定します。
     * @param ID_Credit 債権管理番号（非表示）
     */
    public void setID_Credit(java.math.BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 退避賦金（非表示）を取得します。
     * @return 退避賦金（非表示）
     */
    public java.math.BigDecimal getKeep_M_Fukin() {
        return (java.math.BigDecimal) getValue("Keep_M_Fukin");
    }

    /**
     * 退避賦金（非表示）を設定します。
     * @param Keep_M_Fukin 退避賦金（非表示）
     */
    public void setKeep_M_Fukin(java.math.BigDecimal Keep_M_Fukin) {
        setValue("Keep_M_Fukin", Keep_M_Fukin);
    }

    /**
     * 退避元金不均等（非表示）を取得します。
     * @return 退避元金不均等（非表示）
     */
    public java.math.BigDecimal getKeep_M_GankinFukinto() {
        return (java.math.BigDecimal) getValue("Keep_M_GankinFukinto");
    }

    /**
     * 退避元金不均等（非表示）を設定します。
     * @param Keep_M_GankinFukinto 退避元金不均等（非表示）
     */
    public void setKeep_M_GankinFukinto(java.math.BigDecimal Keep_M_GankinFukinto) {
        setValue("Keep_M_GankinFukinto", Keep_M_GankinFukinto);
    }

    /**
     * 退避元金不均等区分（非表示）を取得します。
     * @return 退避元金不均等区分（非表示）
     */
    public String getKeep_Kubun_GankinFukinto() {
        return (String) getValue("Keep_Kubun_GankinFukinto");
    }

    /**
     * 退避元金不均等区分（非表示）を設定します。
     * @param Keep_Kubun_GankinFukinto 退避元金不均等区分（非表示）
     */
    public void setKeep_Kubun_GankinFukinto(String Keep_Kubun_GankinFukinto) {
        setValue("Keep_Kubun_GankinFukinto", Keep_Kubun_GankinFukinto);
    }

    /**
     * 退避貸付金残高（非表示）を取得します。
     * @return 退避貸付金残高（非表示）
     */
    public java.math.BigDecimal getKeep_M_KashitsukeZan() {
        return (java.math.BigDecimal) getValue("Keep_M_KashitsukeZan");
    }

    /**
     * 退避貸付金残高（非表示）を設定します。
     * @param Keep_M_KashitsukeZan 退避貸付金残高（非表示）
     */
    public void setKeep_M_KashitsukeZan(java.math.BigDecimal Keep_M_KashitsukeZan) {
        setValue("Keep_M_KashitsukeZan", Keep_M_KashitsukeZan);
    }

    /**
     * 退避約定元金（非表示）を取得します。
     * @return 退避約定元金（非表示）
     */
    public java.math.BigDecimal getKeep_M_YakujoGankin() {
        return (java.math.BigDecimal) getValue("Keep_M_YakujoGankin");
    }

    /**
     * 退避約定元金（非表示）を設定します。
     * @param Keep_M_YakujoGankin 退避約定元金（非表示）
     */
    public void setKeep_M_YakujoGankin(java.math.BigDecimal Keep_M_YakujoGankin) {
        setValue("Keep_M_YakujoGankin", Keep_M_YakujoGankin);
    }

    /**
     * 退避約定利息（非表示）を取得します。
     * @return 退避約定利息（非表示）
     */
    public java.math.BigDecimal getKeep_M_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("Keep_M_YakujoRisoku");
    }

    /**
     * 退避約定利息（非表示）を設定します。
     * @param Keep_M_YakujoRisoku 退避約定利息（非表示）
     */
    public void setKeep_M_YakujoRisoku(java.math.BigDecimal Keep_M_YakujoRisoku) {
        setValue("Keep_M_YakujoRisoku", Keep_M_YakujoRisoku);
    }

    /**
     * 退避償還期限年月（非表示）を取得します。
     * @return 退避償還期限年月（非表示）
     */
    public String getKeep_Date_ShokanKigen() {
        return (String) getValue("Keep_Date_ShokanKigen");
    }

    /**
     * 退避償還期限年月（非表示）を設定します。
     * @param Keep_Date_ShokanKigen 退避償還期限年月（非表示）
     */
    public void setKeep_Date_ShokanKigen(String Keep_Date_ShokanKigen) {
        setValue("Keep_Date_ShokanKigen", Keep_Date_ShokanKigen);
    }

    /**
     * 稟議・賦金（非表示）を取得します。
     * @return 稟議・賦金（非表示）
     */
    public java.math.BigDecimal getM_Fukin_Ringi() {
        return (java.math.BigDecimal) getValue("M_Fukin_Ringi");
    }

    /**
     * 稟議・賦金（非表示）を設定します。
     * @param M_Fukin_Ringi 稟議・賦金（非表示）
     */
    public void setM_Fukin_Ringi(java.math.BigDecimal M_Fukin_Ringi) {
        setValue("M_Fukin_Ringi", M_Fukin_Ringi);
    }

    /**
     * 稟議・元金不均等（非表示）を取得します。
     * @return 稟議・元金不均等（非表示）
     */
    public java.math.BigDecimal getM_GankinFukinto_Ringi() {
        return (java.math.BigDecimal) getValue("M_GankinFukinto_Ringi");
    }

    /**
     * 稟議・元金不均等（非表示）を設定します。
     * @param M_GankinFukinto_Ringi 稟議・元金不均等（非表示）
     */
    public void setM_GankinFukinto_Ringi(java.math.BigDecimal M_GankinFukinto_Ringi) {
        setValue("M_GankinFukinto_Ringi", M_GankinFukinto_Ringi);
    }

    /**
     * 稟議・元金不均等区分（非表示）を取得します。
     * @return 稟議・元金不均等区分（非表示）
     */
    public String getKubun_GankinFukintogaku_Ringi() {
        return (String) getValue("Kubun_GankinFukintogaku_Ringi");
    }

    /**
     * 稟議・元金不均等区分（非表示）を設定します。
     * @param Kubun_GankinFukinto_Ringi 稟議・元金不均等区分（非表示）
     */
    public void setKubun_GankinFukintogaku_Ringi(String Kubun_GankinFukintogaku_Ringi) {
        setValue("Kubun_GankinFukintogaku_Ringi", Kubun_GankinFukintogaku_Ringi);
    }

    /**
     * 稟議・貸付金残高（非表示）を取得します。
     * @return 稟議・貸付金残高（非表示）
     */
    public java.math.BigDecimal getM_KashitsukeZandaka_Ringi() {
        return (java.math.BigDecimal) getValue("M_KashitsukeZandaka_Ringi");
    }

    /**
     * 稟議・貸付金残高（非表示）を設定します。
     * @param M_KashitsukeZan_Ringi 稟議・貸付金残高（非表示）
     */
    public void setM_KashitsukeZandaka_Ringi(java.math.BigDecimal M_KashitsukeZandaka_Ringi) {
        setValue("M_KashitsukeZandaka_Ringi", M_KashitsukeZandaka_Ringi);
    }

    /**
     * 稟議・償還期限年月（非表示）を取得します。
     * @return 稟議・償還期限年月（非表示）
     */
    public String getDate_ShokanKigen_Ringi() {
        return (String) getValue("Date_ShokanKigen_Ringi");
    }

    /**
     * 稟議・償還期限年月（非表示）を設定します。
     * @param Date_ShokanKigen_Ringi 稟議・償還期限年月（非表示）
     */
    public void setDate_ShokanKigen_Ringi(String Date_ShokanKigen_Ringi) {
        setValue("Date_ShokanKigen_Ringi", Date_ShokanKigen_Ringi);
    }

    /**
     * 稟議・最新変更年月日（非表示）を取得します。
     * @return 稟議・最新変更年月日（非表示）
     */
    public String getDate_SaishinHenko_Ringi() {
        return (String) getValue("Date_SaishinHenko_Ringi");
    }

    /**
     * 稟議・最新変更年月日（非表示）を設定します。
     * @param Date_SaishinHenko_Ringi 稟議・最新変更年月日（非表示）
     */
    public void setDate_SaishinHenko_Ringi(String Date_SaishinHenko_Ringi) {
        setValue("Date_SaishinHenko_Ringi", Date_SaishinHenko_Ringi);
    }

    /**
     * 稟議・償還方法コード（非表示）を取得します。
     * @return 稟議・償還方法コード（非表示）
     */
    public String getCode_ShokanHouhou_Ringi() {
        return (String) getValue("Code_ShokanHouhou_Ringi");
    }

    /**
     * 稟議・償還方法コード（非表示）を設定します。
     * @param Code_ShokanHouhou_Ringi 稟議・償還方法コード（非表示）
     */
    public void setCode_ShokanHouhou_Ringi(String Code_ShokanHouhou_Ringi) {
        setValue("Code_ShokanHouhou_Ringi", Code_ShokanHouhou_Ringi);
    }

    /**
     * 稟議・特利有効期限（非表示）を取得します。
     * @return 稟議・特利有効期限（非表示）
     */
    public String getDate_TokuriYuko_Ringi() {
        return (String) getValue("Date_TokuriYuko_Ringi");
    }

    /**
     * 稟議・特利有効期限（非表示）を設定します。
     * @param Date_TokuriYuko_Ringi 稟議・特利有効期限（非表示）
     */
    public void setDate_TokuriYuko_Ringi(String Date_TokuriYuko_Ringi) {
        setValue("Date_TokuriYuko_Ringi", Date_TokuriYuko_Ringi);
    }

    /**
     * 稟議・条変起案中区分（非表示）を取得します。
     * @return 稟議・条変起案中区分（非表示）
     */
    public String getKubun_JohenKianchu_Ringi() {
        return (String) getValue("Kubun_JohenKianchu_Ringi");
    }

    /**
     * 稟議・条変起案中区分（非表示）を設定します。
     * @param Kubun_JohenKianchu_Ringi 稟議・条変起案中区分（非表示）
     */
    public void setKubun_JohenKianchu_Ringi(String Kubun_JohenKianchu_Ringi) {
        setValue("Kubun_JohenKianchu_Ringi", Kubun_JohenKianchu_Ringi);
    }

    /**
     * 退避条変起案中区分（非表示）を取得します。
     * @return 退避条変起案中区分（非表示）
     */
    public String getKeep_JohenKianchu() {
        return (String) getValue("Keep_JohenKianchu");
    }

    /**
     * 退避条変起案中区分（非表示）を設定します。
     * @param Keep_JohenKianchu 退避条変起案中区分（非表示）
     */
    public void setKeep_JohenKianchu(String Keep_JohenKianchu) {
        setValue("Keep_JohenKianchu", Keep_JohenKianchu);
    }

    /**
     * 顧客コード（非表示）を取得します。
     * @return 顧客コード（非表示）
     */
    public String getCode_Customer() {
        return (String) getValue("Code_Customer");
    }

    /**
     * 顧客コード（非表示）を設定します。
     * @param Code_Customer 顧客コード（非表示）
     */
    public void setCode_Customer(String Code_Customer) {
        setValue("Code_Customer", Code_Customer);
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

    /**
     * 退避履歴番号（非表示）を取得します。
     * @return 退避履歴番号（非表示）
     */
    public String getKeep_ID_History() {
        return (String) getValue("Keep_ID_History");
    }

    /**
     * 退避履歴番号（非表示）を設定します。
     * @param Keep_ID_History 退避履歴番号（非表示）
     */
    public void setKeep_ID_History(String Keep_ID_History) {
        setValue("Keep_ID_History", Keep_ID_History);
    }

}