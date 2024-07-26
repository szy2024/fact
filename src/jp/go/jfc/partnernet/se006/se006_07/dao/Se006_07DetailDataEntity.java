//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_07DetailDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_07.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_07DetailDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_07DetailDataEntity extends PNBaseEntity {
    
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
     * 払込期日を取得します。
     * @return 払込期日
     */
    public String getDate_Haraikomi() {
        return (String) getValue("Date_Haraikomi");
    }

    /**
     * 払込期日を設定します。
     * @param Date_Haraikomi 払込期日
     */
    public void setDate_Haraikomi(String Date_Haraikomi) {
        setValue("Date_Haraikomi", Date_Haraikomi);
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
     * 遅延損害金を取得します。
     * @return 遅延損害金
     */
    public java.math.BigDecimal getM_ChienSongai() {
        return (java.math.BigDecimal) getValue("M_ChienSongai");
    }

    /**
     * 遅延損害金を設定します。
     * @param M_ChienSongai 遅延損害金
     */
    public void setM_ChienSongai(java.math.BigDecimal M_ChienSongai) {
        setValue("M_ChienSongai", M_ChienSongai);
    }

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public java.math.BigDecimal getM_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("M_YakujoRisoku");
    }

    /**
     * 約定利息を設定します。
     * @param M_YakujoRisoku 約定利息
     */
    public void setM_YakujoRisoku(java.math.BigDecimal M_YakujoRisoku) {
        setValue("M_YakujoRisoku", M_YakujoRisoku);
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getM_YakujoGankin() {
        return (java.math.BigDecimal) getValue("M_YakujoGankin");
    }

    /**
     * 約定元金を設定します。
     * @param M_YakujoGankin 約定元金
     */
    public void setM_YakujoGankin(java.math.BigDecimal M_YakujoGankin) {
        setValue("M_YakujoGankin", M_YakujoGankin);
    }

    /**
     * 払込金額を取得します。
     * @return 払込金額
     */
    public java.math.BigDecimal getM_Haraikomi() {
        return (java.math.BigDecimal) getValue("M_Haraikomi");
    }

    /**
     * 払込金額を設定します。
     * @param M_Haraikomi 払込金額
     */
    public void setM_Haraikomi(java.math.BigDecimal M_Haraikomi) {
        setValue("M_Haraikomi", M_Haraikomi);
    }

    /**
     * 控除利息を取得します。
     * @return 控除利息
     */
    public java.math.BigDecimal getM_KojoRisoku() {
        return (java.math.BigDecimal) getValue("M_KojoRisoku");
    }

    /**
     * 控除利息を設定します。
     * @param M_KojoRisoku 控除利息
     */
    public void setM_KojoRisoku(java.math.BigDecimal M_KojoRisoku) {
        setValue("M_KojoRisoku", M_KojoRisoku);
    }

    /**
     * 違約金を取得します。
     * @return 違約金
     */
    public java.math.BigDecimal getM_Iyaku() {
        return (java.math.BigDecimal) getValue("M_Iyaku");
    }

    /**
     * 違約金を設定します。
     * @param M_Iyaku 違約金
     */
    public void setM_Iyaku(java.math.BigDecimal M_Iyaku) {
        setValue("M_Iyaku", M_Iyaku);
    }

    /**
     * 違約金（利子軽減分）（基金れい入金）を取得します。
     * @return 違約金（利子軽減分）（基金れい入金）
     */
    public java.math.BigDecimal getM_IyakuRishikeigen() {
        return (java.math.BigDecimal) getValue("M_IyakuRishikeigen");
    }

    /**
     * 違約金（利子軽減分）（基金れい入金）を設定します。
     * @param M_IyakuRishikeigen 違約金（利子軽減分）（基金れい入金）
     */
    public void setM_IyakuRishikeigen(java.math.BigDecimal M_IyakuRishikeigen) {
        setValue("M_IyakuRishikeigen", M_IyakuRishikeigen);
    }

    /**
     * 仮受金（一般口）からの充当を取得します。
     * @return 仮受金（一般口）からの充当
     */
    public java.math.BigDecimal getM_KariukeIppanJuto() {
        return (java.math.BigDecimal) getValue("M_KariukeIppanJuto");
    }

    /**
     * 仮受金（一般口）からの充当を設定します。
     * @param M_KariukeIppanJuto 仮受金（一般口）からの充当
     */
    public void setM_KariukeIppanJuto(java.math.BigDecimal M_KariukeIppanJuto) {
        setValue("M_KariukeIppanJuto", M_KariukeIppanJuto);
    }

    /**
     * 差引払込額を取得します。
     * @return 差引払込額
     */
    public java.math.BigDecimal getM_SashihikiHaraikomi() {
        return (java.math.BigDecimal) getValue("M_SashihikiHaraikomi");
    }

    /**
     * 差引払込額を設定します。
     * @param M_SashihikiHaraikomi 差引払込額
     */
    public void setM_SashihikiHaraikomi(java.math.BigDecimal M_SashihikiHaraikomi) {
        setValue("M_SashihikiHaraikomi", M_SashihikiHaraikomi);
    }

    /**
     * 払込後残元金を取得します。
     * @return 払込後残元金
     */
    public java.math.BigDecimal getM_ZangankinAfterHaraikomi() {
        return (java.math.BigDecimal) getValue("M_ZangankinAfterHaraikomi");
    }

    /**
     * 払込後残元金を設定します。
     * @param M_ZangankinAfterHaraikomi 払込後残元金
     */
    public void setM_ZangankinAfterHaraikomi(java.math.BigDecimal M_ZangankinAfterHaraikomi) {
        setValue("M_ZangankinAfterHaraikomi", M_ZangankinAfterHaraikomi);
    }

    /**
     * 貸付実行年月日を取得します。
     * @return 貸付実行年月日
     */
    public String getDate_kashitsukeJikko() {
        return (String) getValue("Date_kashitsukeJikko");
    }

    /**
     * 貸付実行年月日を設定します。
     * @param Date_kashitsukeJikko 貸付実行年月日
     */
    public void setDate_kashitsukeJikko(String Date_kashitsukeJikko) {
        setValue("Date_kashitsukeJikko", Date_kashitsukeJikko);
    }

    /**
     * 貸付金額を取得します。
     * @return 貸付金額
     */
    public java.math.BigDecimal getM_Kashitsuke() {
        return (java.math.BigDecimal) getValue("M_Kashitsuke");
    }

    /**
     * 貸付金額を設定します。
     * @param M_Kashitsuke 貸付金額
     */
    public void setM_Kashitsuke(java.math.BigDecimal M_Kashitsuke) {
        setValue("M_Kashitsuke", M_Kashitsuke);
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
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getCode_Shokan() {
        return (String) getValue("Code_Shokan");
    }

    /**
     * 償還方法を設定します。
     * @param Code_Shokan 償還方法
     */
    public void setCode_Shokan(String Code_Shokan) {
        setValue("Code_Shokan", Code_Shokan);
    }

    /**
     * 元利又は元金均等額を取得します。
     * @return 元利又は元金均等額
     */
    public java.math.BigDecimal getM_GankinKinto() {
        return (java.math.BigDecimal) getValue("M_GankinKinto");
    }

    /**
     * 元利又は元金均等額を設定します。
     * @param M_GankinKinto 元利又は元金均等額
     */
    public void setM_GankinKinto(java.math.BigDecimal M_GankinKinto) {
        setValue("M_GankinKinto", M_GankinKinto);
    }

    /**
     * 残高件数を取得します。
     * @return 残高件数
     */
    public String getCount_Zandaka() {
        return (String) getValue("Count_Zandaka");
    }

    /**
     * 残高件数を設定します。
     * @param Count_Zandaka 残高件数
     */
    public void setCount_Zandaka(String Count_Zandaka) {
        setValue("Count_Zandaka", Count_Zandaka);
    }

    /**
     * 払込前残元金を取得します。
     * @return 払込前残元金
     */
    public java.math.BigDecimal getM_KashitsukeZandaka() {
        return (java.math.BigDecimal) getValue("M_KashitsukeZandaka");
    }

    /**
     * 払込前残元金を設定します。
     * @param M_KashitsukeZandaka 払込前残元金
     */
    public void setM_KashitsukeZandaka(java.math.BigDecimal M_KashitsukeZandaka) {
        setValue("M_KashitsukeZandaka", M_KashitsukeZandaka);
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