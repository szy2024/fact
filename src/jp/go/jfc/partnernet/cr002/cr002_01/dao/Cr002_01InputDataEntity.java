//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01InputDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/25 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr002_01InputDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr002_01InputDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 所管本支店コードを取得します。
     * @return 所管本支店コード
     */
    public String getCode_ShokanHonShiten() {
        return (String) getValue("Code_ShokanHonShiten");
    }

    /**
     * 所管本支店コードを設定します。
     * @param Code_ShokanHonShiten 所管本支店コード
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        setValue("Code_ShokanHonShiten", Code_ShokanHonShiten);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String) getValue("Code_Organization");
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
        return (String) getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
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
     * 稟議番号を取得します。
     * @return 稟議番号
     */
    public String getID_Ringi() {
        return (String) getValue("ID_Ringi");
    }

    /**
     * 稟議番号を設定します。
     * @param ID_Ringi 稟議番号
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * 稟議番号枝番を取得します。
     * @return 稟議番号枝番
     */
    public String getID_RingiBranch() {
        return (String) getValue("ID_RingiBranch");
    }

    /**
     * 稟議番号枝番を設定します。
     * @param ID_RingiBranch 稟議番号枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * 顧客コードを取得します。
     * @return 顧客コード
     */
    public String getCode_Customer() {
        return (String) getValue("Code_Customer");
    }

    /**
     * 顧客コードを設定します。
     * @param Code_Customer 顧客コード
     */
    public void setCode_Customer(String Code_Customer) {
        setValue("Code_Customer", Code_Customer);
    }

    /**
     * 資金使途コードを取得します。
     * @return 資金使途コード
     */
    public String getCode_ShikinShito() {
        return (String) getValue("Code_ShikinShito");
    }

    /**
     * 資金使途コードを設定します。
     * @param Code_ShikinShito 資金使途コード
     */
    public void setCode_ShikinShito(String Code_ShikinShito) {
        setValue("Code_ShikinShito", Code_ShikinShito);
    }

    /**
     * 事業別コードを取得します。
     * @return 事業別コード
     */
    public String getCode_Jigyobetsu() {
        return (String) getValue("Code_Jigyobetsu");
    }

    /**
     * 事業別コードを設定します。
     * @param Code_Jigyobetsu 事業別コード
     */
    public void setCode_Jigyobetsu(String Code_Jigyobetsu) {
        setValue("Code_Jigyobetsu", Code_Jigyobetsu);
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
     * 特利を取得します。
     * @return 特利
     */
    public String getTokuri() {
        return (String) getValue("Tokuri");
    }

    /**
     * 特利を設定します。
     * @param Tokuri 特利
     */
    public void setTokuri(String Tokuri) {
        setValue("Tokuri", Tokuri);
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getRiritsu() {
        return (String) getValue("Riritsu");
    }

    /**
     * 利率を設定します。
     * @param Riritsu 利率
     */
    public void setRiritsu(String Riritsu) {
        setValue("Riritsu", Riritsu);
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
     * 貸付実行金額を取得します。
     * @return 貸付実行金額
     */
    public java.math.BigDecimal getM_Kashitsuke() {
        return (java.math.BigDecimal) getValue("M_Kashitsuke");
    }

    /**
     * 貸付実行金額を設定します。
     * @param M_Kashitsuke 貸付実行金額
     */
    public void setM_Kashitsuke(java.math.BigDecimal M_Kashitsuke) {
        setValue("M_Kashitsuke", M_Kashitsuke);
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
     * 払出元金充当日を取得します。
     * @return 払出元金充当日
     */
    public String getDate_HaraidashiJuto() {
        return (String) getValue("Date_HaraidashiJuto");
    }

    /**
     * 払出元金充当日を設定します。
     * @param Date_HaraidashiJuto 払出元金充当日
     */
    public void setDate_HaraidashiJuto(String Date_HaraidashiJuto) {
        setValue("Date_HaraidashiJuto", Date_HaraidashiJuto);
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
     * 合計を取得します。
     * @return 合計
     */
    public java.math.BigDecimal getM_Kei() {
        return (java.math.BigDecimal) getValue("M_Kei");
    }

    /**
     * 合計を設定します。
     * @param M_Kei 合計
     */
    public void setM_Kei(java.math.BigDecimal M_Kei) {
        setValue("M_Kei", M_Kei);
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
     * 元金充当後元金均等額を取得します。
     * @return 元金充当後元金均等額
     */
    public java.math.BigDecimal getM_GankinKintoAfterGanju() {
        return (java.math.BigDecimal) getValue("M_GankinKintoAfterGanju");
    }

    /**
     * 元金充当後元金均等額を設定します。
     * @param M_GankinKintoAfterGanju 元金充当後元金均等額
     */
    public void setM_GankinKintoAfterGanju(java.math.BigDecimal M_GankinKintoAfterGanju) {
        setValue("M_GankinKintoAfterGanju", M_GankinKintoAfterGanju);
    }

    /**
     * 元金充当後元金不均等額を取得します。
     * @return 元金充当後元金不均等額
     */
    public java.math.BigDecimal getM_GankinFukintoAfterGanju() {
        return (java.math.BigDecimal) getValue("M_GankinFukintoAfterGanju");
    }

    /**
     * 元金充当後元金不均等額を設定します。
     * @param M_GankinFukintoAfterGanju 元金充当後元金不均等額
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
     * 署名データファイル名を取得します。
     * @return 署名データファイル名
     */
    public String getSignData() {
        return (String) getValue("SignData");
    }

    /**
     * 署名データファイル名を設定します。
     * @param SignData 署名データファイル名
     */
    public void setSignData(String SignData) {
        setValue("SignData", SignData);
    }

    /**
     * 電子署名結果を取得します。
     * @return 電子署名結果
     */
    public java.math.BigDecimal getResult_SignedData() {
        return (java.math.BigDecimal) getValue("Result_SignedData");
    }

    /**
     * 電子署名結果を設定します。
     * @param Result_SignedData 電子署名結果
     */
    public void setResult_SignedData(java.math.BigDecimal Result_SignedData) {
        setValue("Result_SignedData", Result_SignedData);
    }

    /**
     * 履歴報告書番号を取得します。
     * @return 履歴報告書番号
     */
    public String getID_Report() {
        return (String) getValue("ID_Report");
    }

    /**
     * 履歴報告書番号を設定します。
     * @param ID_Report 履歴報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getStatus() {
        return (String) getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(String Status) {
        setValue("Status", Status);
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
     * 退避賦金を取得します。
     * @return 退避賦金
     */
    public java.math.BigDecimal getKeep_M_Fukin() {
        return (java.math.BigDecimal) getValue("Keep_M_Fukin");
    }

    /**
     * 退避賦金を設定します。
     * @param Keep_M_Fukin 退避賦金
     */
    public void setKeep_M_Fukin(java.math.BigDecimal Keep_M_Fukin) {
        setValue("Keep_M_Fukin", Keep_M_Fukin);
    }

    /**
     * 退避元金不均等額を取得します。
     * @return 退避元金不均等額
     */
    public java.math.BigDecimal getKeep_M_GankinFukinto() {
        return (java.math.BigDecimal) getValue("Keep_M_GankinFukinto");
    }

    /**
     * 退避元金不均等額を設定します。
     * @param Keep_M_GankinFukinto 退避元金不均等額
     */
    public void setKeep_M_GankinFukinto(java.math.BigDecimal Keep_M_GankinFukinto) {
        setValue("Keep_M_GankinFukinto", Keep_M_GankinFukinto);
    }

    /**
     * 退避元金不均等額区分を取得します。
     * @return 退避元金不均等額区分
     */
    public String getKeep_Kubun_GankinFukinto() {
        return (String) getValue("Keep_Kubun_GankinFukinto");
    }

    /**
     * 退避元金不均等額区分を設定します。
     * @param Keep_Kubun_GankinFukinto 退避元金不均等額区分
     */
    public void setKeep_Kubun_GankinFukinto(String Keep_Kubun_GankinFukinto) {
        setValue("Keep_Kubun_GankinFukinto", Keep_Kubun_GankinFukinto);
    }

    /**
     * 退避貸付金残高を取得します。
     * @return 退避貸付金残高
     */
    public java.math.BigDecimal getKeep_M_KashitsukeZan() {
        return (java.math.BigDecimal) getValue("Keep_M_KashitsukeZan");
    }

    /**
     * 退避貸付金残高を設定します。
     * @param Keep_M_KashitsukeZan 退避貸付金残高
     */
    public void setKeep_M_KashitsukeZan(java.math.BigDecimal Keep_M_KashitsukeZan) {
        setValue("Keep_M_KashitsukeZan", Keep_M_KashitsukeZan);
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public java.math.BigDecimal getKeep_M_YakujoGankin() {
        return (java.math.BigDecimal) getValue("Keep_M_YakujoGankin");
    }

    /**
     * 退避約定元金を設定します。
     * @param Keep_M_YakujoGankin 退避約定元金
     */
    public void setKeep_M_YakujoGankin(java.math.BigDecimal Keep_M_YakujoGankin) {
        setValue("Keep_M_YakujoGankin", Keep_M_YakujoGankin);
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public java.math.BigDecimal getKeep_M_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("Keep_M_YakujoRisoku");
    }

    /**
     * 退避・条変起案中区分 退避約定利息を設定します。
     * @param Keep_M_YakujoRisoku 退避約定利息
     */
    public void setKeep_M_YakujoRisoku(java.math.BigDecimal Keep_M_YakujoRisoku) {
        setValue("Keep_M_YakujoRisoku", Keep_M_YakujoRisoku);
    }

    /**
     * 退避償還期限年月を取得します。
     * @return 退避償還期限年月
     */
    public String getKeep_Date_ShokanKigen() {
        return (String) getValue("Keep_Date_ShokanKigen");
    }

    /**
     * 退避償還期限年月を設定します。
     * @param Keep_Date_ShokanKigen 退避償還期限年月
     */
    public void setKeep_Date_ShokanKigen(String Keep_Date_ShokanKigen) {
        setValue("Keep_Date_ShokanKigen", Keep_Date_ShokanKigen);
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
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public java.math.BigDecimal getM_KashitsukeUkeireZan() {
        return (java.math.BigDecimal) getValue("M_KashitsukeUkeireZan");
    }

    /**
     * 貸付受入金残高を設定します。
     * @param M_KashitsukeUkeireZan 貸付受入金残高
     */
    public void setM_KashitsukeUkeireZan(java.math.BigDecimal M_KashitsukeUkeireZan) {
        setValue("M_KashitsukeUkeireZan", M_KashitsukeUkeireZan);
    }

    /**
     * 稟議・最新変更年月日を取得します。
     * @return 稟議・最新変更年月日
     */
    public String getDate_SaishinHenko() {
        return (String) getValue("Date_SaishinHenko");
    }

    /**
     * 稟議・最新変更年月日を設定します。
     * @param Date_SaishinHenko 稟議・最新変更年月日
     */
    public void setDate_SaishinHenko(String Date_SaishinHenko) {
        setValue("Date_SaishinHenko", Date_SaishinHenko);
    }

    /**
     * 稟議・賦金を取得します。
     * @return 稟議・賦金
     */
    public java.math.BigDecimal getM_Fukin() {
        return (java.math.BigDecimal) getValue("M_Fukin");
    }

    /**
     * 稟議・賦金を設定します。
     * @param M_Fukin 稟議・賦金
     */
    public void setM_Fukin(java.math.BigDecimal M_Fukin) {
        setValue("M_Fukin", M_Fukin);
    }

    /**
     * 稟議・元金不均等額を取得します。
     * @return 稟議・元金不均等額
     */
    public java.math.BigDecimal getM_GankinFukinto() {
        return (java.math.BigDecimal) getValue("M_GankinFukinto");
    }

    /**
     * 稟議・元金不均等額を設定します。
     * @param M_GankinFukinto 稟議・元金不均等額
     */
    public void setM_GankinFukinto(java.math.BigDecimal M_GankinFukinto) {
        setValue("M_GankinFukinto", M_GankinFukinto);
    }

    /**
     * 稟議・元金不均等額区分を取得します。
     * @return 稟議・元金不均等額区分
     */
    public String getKubun_GankinFukintogaku() {
        return (String) getValue("Kubun_GankinFukintogaku");
    }

    /**
     * 稟議・元金不均等額区分を設定します。
     * @param Kubun_GankinFukintogaku 稟議・元金不均等額区分
     */
    public void setKubun_GankinFukintogaku(String Kubun_GankinFukintogaku) {
        setValue("Kubun_GankinFukintogaku", Kubun_GankinFukintogaku);
    }

    /**
     * 稟議・貸付金残高を取得します。
     * @return 稟議・貸付金残高
     */
    public java.math.BigDecimal getM_KashitsukeZandaka() {
        return (java.math.BigDecimal) getValue("M_KashitsukeZandaka");
    }

    /**
     * 稟議・貸付金残高を設定します。
     * @param M_KashitsukeZandaka 稟議・貸付金残高
     */
    public void setM_KashitsukeZandaka(java.math.BigDecimal M_KashitsukeZandaka) {
        setValue("M_KashitsukeZandaka", M_KashitsukeZandaka);
    }

    /**
     * 稟議・償還方法コードを取得します。
     * @return 稟議・償還方法コード
     */
    public String getCode_ShokanHouhou() {
        return (String) getValue("Code_ShokanHouhou");
    }

    /**
     * 稟議・償還方法コードを設定します。
     * @param Code_ShokanHouhou 稟議・償還方法コード
     */
    public void setCode_ShokanHouhou(String Code_ShokanHouhou) {
        setValue("Code_ShokanHouhou", Code_ShokanHouhou);
    }

    /**
     * 稟議・特利有効期限を取得します。
     * @return 稟議・特利有効期限
     */
    public String getDate_TokuriYuko() {
        return (String) getValue("Date_TokuriYuko");
    }

    /**
     * 稟議・特利有効期限を設定します。
     * @param Date_TokuriYuko 稟議・特利有効期限
     */
    public void setDate_TokuriYuko(String Date_TokuriYuko) {
        setValue("Date_TokuriYuko", Date_TokuriYuko);
    }

    /**
     * 稟議・条変起案中区分を取得します。
     * @return 稟議・条変起案中区分
     */
    public String getKubun_JohenKianchu() {
        return (String) getValue("Kubun_JohenKianchu");
    }

    /**
     * 稟議・条変起案中区分を設定します。
     * @param Kubun_JohenKianchu 稟議・条変起案中区分
     */
    public void setKubun_JohenKianchu(String Kubun_JohenKianchu) {
        setValue("Kubun_JohenKianchu", Kubun_JohenKianchu);
    }

    /**
     * 退避条変起案中区分を取得します。
     * @return 退避条変起案中区分
     */
    public String getKeep_JohenKianchu() {
        return (String) getValue("Keep_JohenKianchu");
    }

    /**
     * 退避条変起案中区分を設定します。
     * @param Keep_JohenKianchu 退避条変起案中区分
     */
    public void setKeep_JohenKianchu(String Keep_JohenKianchu) {
        setValue("Keep_JohenKianchu", Keep_JohenKianchu);
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

}