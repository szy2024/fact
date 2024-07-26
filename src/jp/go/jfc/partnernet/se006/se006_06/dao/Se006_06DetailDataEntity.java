//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_06DetailDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/23 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_06.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_06DetailDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_06DetailDataEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getCode_KoukoShiten() {
        return (String) getValue("Code_KoukoShiten");
    }

    /**
     * 公庫支店コードを設定します。
     * @param Code_KoukoShiten 公庫支店コード
     */
    public void setCode_KoukoShiten(String Code_KoukoShiten) {
        setValue("Code_KoukoShiten", Code_KoukoShiten);
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
    public java.math.BigDecimal getM_Ganju () {
        return (java.math.BigDecimal) getValue("M_Ganju ");
    }

    /**
     * 元金充当額を設定します。
     * @param M_Ganju  元金充当額
     */
    public void setM_Ganju (java.math.BigDecimal M_Ganju ) {
        setValue("M_Ganju ", M_Ganju );
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
    public String getCode_Jigyobetsu () {
        return (String) getValue("Code_Jigyobetsu ");
    }

    /**
     * 事業別コードを設定します。
     * @param Code_Jigyobetsu  事業別コード
     */
    public void setCode_Jigyobetsu (String Code_Jigyobetsu ) {
        setValue("Code_Jigyobetsu ", Code_Jigyobetsu );
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
     * 特利区分コードを取得します。
     * @return 特利区分コード
     */
    public String getCode_TokuriKubun() {
        return (String) getValue("Code_TokuriKubun");
    }

    /**
     * 特利区分コードを設定します。
     * @param Code_TokuriKubun 特利区分コード
     */
    public void setCode_TokuriKubun(String Code_TokuriKubun) {
        setValue("Code_TokuriKubun", Code_TokuriKubun);
    }

    /**
     * 特利（利率）を取得します。
     * @return 特利（利率）
     */
    public java.math.BigDecimal getTokuri() {
        return (java.math.BigDecimal) getValue("Tokuri");
    }

    /**
     * 特利（利率）を設定します。
     * @param Tokuri 特利（利率）
     */
    public void setTokuri(java.math.BigDecimal Tokuri) {
        setValue("Tokuri", Tokuri);
    }

    /**
     * 据置期限（年月）を取得します。
     * @return 据置期限（年月）
     */
    public String getDate_SueokiKigen() {
        return (String) getValue("Date_SueokiKigen");
    }

    /**
     * 据置期限（年月）を設定します。
     * @param Date_SueokiKigen 据置期限（年月）
     */
    public void setDate_SueokiKigen(String Date_SueokiKigen) {
        setValue("Date_SueokiKigen", Date_SueokiKigen);
    }

    /**
     * 償還期限（年月）を取得します。
     * @return 償還期限（年月）
     */
    public String getDate_ShokanKigen() {
        return (String) getValue("Date_ShokanKigen");
    }

    /**
     * 償還期限（年月）を設定します。
     * @param Date_ShokanKigen 償還期限（年月）
     */
    public void setDate_ShokanKigen(String Date_ShokanKigen) {
        setValue("Date_ShokanKigen", Date_ShokanKigen);
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getDate_GanrikinHaraikomi() {
        return (String) getValue("Date_GanrikinHaraikomi");
    }

    /**
     * 元利金払込日を設定します。
     * @param Date_GanrikinHaraikomi 元利金払込日
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

}