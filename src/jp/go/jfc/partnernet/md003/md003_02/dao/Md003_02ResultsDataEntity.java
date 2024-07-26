//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd003_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md003_02ResultsDataEntity extends PNBaseEntity {
    
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
    public String getID_Date_Report() {
        return (String) getValue("ID_Date_Report");
    }

    /**
     * 報告年月日を設定します。
     * @param ID_Date_Report 報告年月日
     */
    public void setID_Date_Report(String ID_Date_Report) {
        setValue("ID_Date_Report", ID_Date_Report);
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getID_Name_Customer() {
        return (String) getValue("ID_Name_Customer");
    }

    /**
     * 顧客名を設定します。
     * @param ID_Name_Customer 顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        setValue("ID_Name_Customer", ID_Name_Customer);
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getID_Name_Organization() {
        return (String) getValue("ID_Name_Organization");
    }

    /**
     * 扱店名を設定します。
     * @param ID_Name_Organization 扱店名
     */
    public void setID_Name_Organization(String ID_Name_Organization) {
        setValue("ID_Name_Organization", ID_Name_Organization);
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getID_Code_KoukoShiten() {
        return (String) getValue("ID_Code_KoukoShiten");
    }

    /**
     * 公庫支店を設定します。
     * @param ID_Code_KoukoShiten 公庫支店
     */
    public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
        setValue("ID_Code_KoukoShiten", ID_Code_KoukoShiten);
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return (String) getValue("ID_Code_Organization");
    }

    /**
     * 扱店を設定します。
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        setValue("ID_Code_Organization", ID_Code_Organization);
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return (String) getValue("ID_Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        setValue("ID_Code_Tenpo", ID_Code_Tenpo);
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getID_Year() {
        return (String) getValue("ID_Year");
    }

    /**
     * 年度を設定します。
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        setValue("ID_Year", ID_Year);
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getID_Code_HoshikiShikin() {
        return (String) getValue("ID_Code_HoshikiShikin");
    }

    /**
     * 方式資金を設定します。
     * @param ID_Code_HoshikiShikin 方式資金
     */
    public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
        setValue("ID_Code_HoshikiShikin", ID_Code_HoshikiShikin);
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return (String) getValue("ID_ID_Ringi");
    }

    /**
     * 番号を設定します。
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        setValue("ID_ID_Ringi", ID_ID_Ringi);
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return (String) getValue("ID_ID_RingiBranch");
    }

    /**
     * 枝番を設定します。
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        setValue("ID_ID_RingiBranch", ID_ID_RingiBranch);
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_kashitsukeJikko() {
        return (String) getValue("ID_Date_kashitsukeJikko");
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_kashitsukeJikko 貸付実行日
     */
    public void setID_Date_kashitsukeJikko(String ID_Date_kashitsukeJikko) {
        setValue("ID_Date_kashitsukeJikko", ID_Date_kashitsukeJikko);
    }

    /**
     * 貸付金額を取得します。
     * @return 貸付金額
     */
    public java.math.BigDecimal getID_M_Kashitsuke() {
        return (java.math.BigDecimal) getValue("ID_M_Kashitsuke");
    }

    /**
     * 貸付金額を設定します。
     * @param ID_M_Kashitsuke 貸付金額
     */
    public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
        setValue("ID_M_Kashitsuke", ID_M_Kashitsuke);
    }

    /**
     * 資金使途を取得します。
     * @return 資金使途
     */
    public String getID_Code_ShikinShito() {
        return (String) getValue("ID_Code_ShikinShito");
    }

    /**
     * 資金使途を設定します。
     * @param ID_Code_ShikinShito 資金使途
     */
    public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
        setValue("ID_Code_ShikinShito", ID_Code_ShikinShito);
    }

    /**
     * 事業別を取得します。
     * @return 事業別
     */
    public String getID_Code_Jigyobetsu() {
        return (String) getValue("ID_Code_Jigyobetsu");
    }

    /**
     * 事業別を設定します。
     * @param ID_Code_Jigyobetsu 事業別
     */
    public void setID_Code_Jigyobetsu(String ID_Code_Jigyobetsu) {
        setValue("ID_Code_Jigyobetsu", ID_Code_Jigyobetsu);
    }

    /**
     * 利率(%)を取得します。
     * @return 利率(%)
     */
    public String getID_Riritsu() {
        return (String) getValue("ID_Riritsu");
    }

    /**
     * 利率(%)を設定します。
     * @param ID_Riritsu 利率(%)
     */
    public void setID_Riritsu(String ID_Riritsu) {
        setValue("ID_Riritsu", ID_Riritsu);
    }

    /**
     * 特利区分を取得します。
     * @return 特利区分
     */
    public String getID_Code_TokuriKubun() {
        return (String) getValue("ID_Code_TokuriKubun");
    }

    /**
     * 特利区分を設定します。
     * @param ID_Code_TokuriKubun 特利区分
     */
    public void setID_Code_TokuriKubun(String ID_Code_TokuriKubun) {
        setValue("ID_Code_TokuriKubun", ID_Code_TokuriKubun);
    }

    /**
     * 特利(%)を取得します。
     * @return 特利(%)
     */
    public String getID_Tokuri() {
        return (String) getValue("ID_Tokuri");
    }

    /**
     * 特利(%)を設定します。
     * @param ID_Tokuri 特利(%)
     */
    public void setID_Tokuri(String ID_Tokuri) {
        setValue("ID_Tokuri", ID_Tokuri);
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getID_Code_Shokan() {
        return (String) getValue("ID_Code_Shokan");
    }

    /**
     * 償還方法を設定します。
     * @param ID_Code_Shokan 償還方法
     */
    public void setID_Code_Shokan(String ID_Code_Shokan) {
        setValue("ID_Code_Shokan", ID_Code_Shokan);
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return (String) getValue("ID_Date_SueokiKigen");
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen 据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        setValue("ID_Date_SueokiKigen", ID_Date_SueokiKigen);
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return (String) getValue("ID_Date_ShokanKigen");
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen 償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        setValue("ID_Date_ShokanKigen", ID_Date_ShokanKigen);
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraikomi() {
        return (String) getValue("ID_Date_GanrikinHaraikomi");
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraikomi 元利金払込日
     */
    public void setID_Date_GanrikinHaraikomi(String ID_Date_GanrikinHaraikomi) {
        setValue("ID_Date_GanrikinHaraikomi", ID_Date_GanrikinHaraikomi);
    }

    /**
     * 元利又は元金均等額を取得します。
     * @return 元利又は元金均等額
     */
    public java.math.BigDecimal getID_M_GankinKinto() {
        return (java.math.BigDecimal) getValue("ID_M_GankinKinto");
    }

    /**
     * 元利又は元金均等額を設定します。
     * @param ID_M_GankinKinto 元利又は元金均等額
     */
    public void setID_M_GankinKinto(java.math.BigDecimal ID_M_GankinKinto) {
        setValue("ID_M_GankinKinto", ID_M_GankinKinto);
    }

    /**
     * 払込前残元金を取得します。
     * @return 払込前残元金
     */
    public java.math.BigDecimal getID_M_KashitsukeZandaka() {
        return (java.math.BigDecimal) getValue("ID_M_KashitsukeZandaka");
    }

    /**
     * 払込前残元金を設定します。
     * @param ID_M_KashitsukeZandaka 払込前残元金
     */
    public void setID_M_KashitsukeZandaka(java.math.BigDecimal ID_M_KashitsukeZandaka) {
        setValue("ID_M_KashitsukeZandaka", ID_M_KashitsukeZandaka);
    }

    /**
     * 払込期日を取得します。
     * @return 払込期日
     */
    public String getID_Date_Haraikomi() {
        return (String) getValue("ID_Date_Haraikomi");
    }

    /**
     * 払込期日を設定します。
     * @param ID_Date_Haraikomi 払込期日
     */
    public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
        setValue("ID_Date_Haraikomi", ID_Date_Haraikomi);
    }

    /**
     * 払込額を取得します。
     * @return 払込額
     */
    public java.math.BigDecimal getID_M_Haraikomi() {
        return (java.math.BigDecimal) getValue("ID_M_Haraikomi");
    }

    /**
     * 払込額を設定します。
     * @param ID_M_Haraikomi 払込額
     */
    public void setID_M_Haraikomi(java.math.BigDecimal ID_M_Haraikomi) {
        setValue("ID_M_Haraikomi", ID_M_Haraikomi);
    }

    /**
     * 控除利息を取得します。
     * @return 控除利息
     */
    public java.math.BigDecimal getID_M_KojoRisoku() {
        return (java.math.BigDecimal) getValue("ID_M_KojoRisoku");
    }

    /**
     * 控除利息を設定します。
     * @param ID_M_KojoRisoku 控除利息
     */
    public void setID_M_KojoRisoku(java.math.BigDecimal ID_M_KojoRisoku) {
        setValue("ID_M_KojoRisoku", ID_M_KojoRisoku);
    }

    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getID_Date_Nyukin() {
        return (String) getValue("ID_Date_Nyukin");
    }

    /**
     * 入金日を設定します。
     * @param ID_Date_Nyukin 入金日
     */
    public void setID_Date_Nyukin(String ID_Date_Nyukin) {
        setValue("ID_Date_Nyukin", ID_Date_Nyukin);
    }

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public java.math.BigDecimal getID_M_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("ID_M_YakujoRisoku");
    }

    /**
     * 約定利息を設定します。
     * @param ID_M_YakujoRisoku 約定利息
     */
    public void setID_M_YakujoRisoku(java.math.BigDecimal ID_M_YakujoRisoku) {
        setValue("ID_M_YakujoRisoku", ID_M_YakujoRisoku);
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getID_M_YakujoGankin() {
        return (java.math.BigDecimal) getValue("ID_M_YakujoGankin");
    }

    /**
     * 約定元金を設定します。
     * @param ID_M_YakujoGankin 約定元金
     */
    public void setID_M_YakujoGankin(java.math.BigDecimal ID_M_YakujoGankin) {
        setValue("ID_M_YakujoGankin", ID_M_YakujoGankin);
    }

    /**
     * 遅延損害金を取得します。
     * @return 遅延損害金
     */
    public java.math.BigDecimal getID_M_ChienSongai() {
        return (java.math.BigDecimal) getValue("ID_M_ChienSongai");
    }

    /**
     * 遅延損害金を設定します。
     * @param ID_M_ChienSongai 遅延損害金
     */
    public void setID_M_ChienSongai(java.math.BigDecimal ID_M_ChienSongai) {
        setValue("ID_M_ChienSongai", ID_M_ChienSongai);
    }

    /**
     * 違約金を取得します。
     * @return 違約金
     */
    public java.math.BigDecimal getID_M_Iyaku() {
        return (java.math.BigDecimal) getValue("ID_M_Iyaku");
    }

    /**
     * 違約金を設定します。
     * @param ID_M_Iyaku 違約金
     */
    public void setID_M_Iyaku(java.math.BigDecimal ID_M_Iyaku) {
        setValue("ID_M_Iyaku", ID_M_Iyaku);
    }

    /**
     * 違約金（利子軽減分）を取得します。
     * @return 違約金（利子軽減分）
     */
    public java.math.BigDecimal getID_M_IyakuRishikeigen() {
        return (java.math.BigDecimal) getValue("ID_M_IyakuRishikeigen");
    }

    /**
     * 違約金（利子軽減分）を設定します。
     * @param ID_M_IyakuRishikeigen 違約金（利子軽減分）
     */
    public void setID_M_IyakuRishikeigen(java.math.BigDecimal ID_M_IyakuRishikeigen) {
        setValue("ID_M_IyakuRishikeigen", ID_M_IyakuRishikeigen);
    }

    /**
     * 仮受金からの充当額を取得します。
     * @return 仮受金からの充当額
     */
    public java.math.BigDecimal getID_M_KariukeIppanJuto() {
        return (java.math.BigDecimal) getValue("ID_M_KariukeIppanJuto");
    }

    /**
     * 仮受金からの充当額を設定します。
     * @param ID_M_KariukeIppanJuto 仮受金からの充当額
     */
    public void setID_M_KariukeIppanJuto(java.math.BigDecimal ID_M_KariukeIppanJuto) {
        setValue("ID_M_KariukeIppanJuto", ID_M_KariukeIppanJuto);
    }

    /**
     * 差引払込額を取得します。
     * @return 差引払込額
     */
    public java.math.BigDecimal getID_M_SashihikiHaraikomi() {
        return (java.math.BigDecimal) getValue("ID_M_SashihikiHaraikomi");
    }

    /**
     * 差引払込額を設定します。
     * @param ID_M_SashihikiHaraikomi 差引払込額
     */
    public void setID_M_SashihikiHaraikomi(java.math.BigDecimal ID_M_SashihikiHaraikomi) {
        setValue("ID_M_SashihikiHaraikomi", ID_M_SashihikiHaraikomi);
    }

    /**
     * 払込後残元金を取得します。
     * @return 払込後残元金
     */
    public java.math.BigDecimal getID_M_ZangankinAfterHaraikomi() {
        return (java.math.BigDecimal) getValue("ID_M_ZangankinAfterHaraikomi");
    }

    /**
     * 払込後残元金を設定します。
     * @param ID_M_ZangankinAfterHaraikomi 払込後残元金
     */
    public void setID_M_ZangankinAfterHaraikomi(java.math.BigDecimal ID_M_ZangankinAfterHaraikomi) {
        setValue("ID_M_ZangankinAfterHaraikomi", ID_M_ZangankinAfterHaraikomi);
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getID_Date_Jtkshori() {
        return (String) getValue("ID_Date_Jtkshori");
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param ID_Date_Jtkshori 受託者勘定処理年月
     */
    public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
        setValue("ID_Date_Jtkshori", ID_Date_Jtkshori);
    }

    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getID_Date_Sokin() {
        return (String) getValue("ID_Date_Sokin");
    }

    /**
     * 送金日を設定します。
     * @param ID_Date_Sokin 送金日
     */
    public void setID_Date_Sokin(String ID_Date_Sokin) {
        setValue("ID_Date_Sokin", ID_Date_Sokin);
    }

    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getID_ID_Sokinbi() {
        return (String) getValue("ID_ID_Sokinbi");
    }

    /**
     * 送金日番号を設定します。
     * @param ID_ID_Sokinbi 送金日番号
     */
    public void setID_ID_Sokinbi(String ID_ID_Sokinbi) {
        setValue("ID_ID_Sokinbi", ID_ID_Sokinbi);
    }

    /**
     * 報告書番号２を取得します。
     * @return 報告書番号２
     */
    public String getID_ID_Report() {
        return (String) getValue("ID_ID_Report");
    }

    /**
     * 報告書番号２を設定します。
     * @param ID_ID_Report 報告書番号２
     */
    public void setID_ID_Report(String ID_ID_Report) {
        setValue("ID_ID_Report", ID_ID_Report);
    }

    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getID_Time_Report() {
        return (String) getValue("ID_Time_Report");
    }

    /**
     * 報告時分秒を設定します。
     * @param ID_Time_Report 報告時分秒
     */
    public void setID_Time_Report(String ID_Time_Report) {
        setValue("ID_Time_Report", ID_Time_Report);
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getID_User_ID() {
        return (String) getValue("ID_User_ID");
    }

    /**
     * ユーザIDを設定します。
     * @param ID_User_ID ユーザID
     */
    public void setID_User_ID(String ID_User_ID) {
        setValue("ID_User_ID", ID_User_ID);
    }

    /**
     * 伝送番号を取得します。
     * @return 伝送番号
     */
    public String getID_ID_Denso() {
        return (String) getValue("ID_ID_Denso");
    }

    /**
     * 伝送番号を設定します。
     * @param ID_ID_Denso 伝送番号
     */
    public void setID_ID_Denso(String ID_ID_Denso) {
        setValue("ID_ID_Denso", ID_ID_Denso);
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getID_DataCode() {
        return (String) getValue("ID_DataCode");
    }

    /**
     * データコードを設定します。
     * @param ID_DataCode データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        setValue("ID_DataCode", ID_DataCode);
    }

    /**
     * 残高件数を取得します。
     * @return 残高件数
     */
    public Integer getID_Count_Zandaka() {
        return (Integer) getValue("ID_Count_Zandaka");
    }

    /**
     * 残高件数を設定します。
     * @param ID_Count_Zandaka 残高件数
     */
    public void setID_Count_Zandaka(Integer ID_Count_Zandaka) {
        setValue("ID_Count_Zandaka", ID_Count_Zandaka);
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_ID_History() {
        return (String) getValue("ID_ID_History");
    }

    /**
     * 履歴番号を設定します。
     * @param ID_ID_History 履歴番号
     */
    public void setID_ID_History(String ID_ID_History) {
        setValue("ID_ID_History", ID_ID_History);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public Integer getID_Status() {
        return (Integer) getValue("ID_Status");
    }

    /**
     * ステータスを設定します。
     * @param ID_Status ステータス
     */
    public void setID_Status(Integer ID_Status) {
        setValue("ID_Status", ID_Status);
    }

    /**
     * 処理種別を取得します。
     * @return 処理種別
     */
    public String getID_Type_Process() {
        return (String) getValue("ID_Type_Process");
    }

    /**
     * 処理種別を設定します。
     * @param ID_Type_Process 処理種別
     */
    public void setID_Type_Process(String ID_Type_Process) {
        setValue("ID_Type_Process", ID_Type_Process);
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public Integer getID_Flag_Torikeshizumi() {
        return (Integer) getValue("ID_Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグを設定します。
     * @param ID_Flag_Torikeshizumi 取消済フラグ
     */
    public void setID_Flag_Torikeshizumi(Integer ID_Flag_Torikeshizumi) {
        setValue("ID_Flag_Torikeshizumi", ID_Flag_Torikeshizumi);
    }

    /**
     * エラー番号を取得します。
     * @return エラー番号
     */
    public String getID_Code_Error() {
        return (String) getValue("ID_Code_Error");
    }

    /**
     * エラー番号を設定します。
     * @param ID_Code_Error エラー番号
     */
    public void setID_Code_Error(String ID_Code_Error) {
        setValue("ID_Code_Error", ID_Code_Error);
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getID_ErrorMessage() {
        return (String) getValue("ID_ErrorMessage");
    }

    /**
     * エラーメッセージを設定します。
     * @param ID_ErrorMessage エラーメッセージ
     */
    public void setID_ErrorMessage(String ID_ErrorMessage) {
        setValue("ID_ErrorMessage", ID_ErrorMessage);
    }

    /**
     * 退避貸付金残高を取得します。
     * @return 退避貸付金残高
     */
    public java.math.BigDecimal getID_Keep_M_KashitsukeZan() {
        return (java.math.BigDecimal) getValue("ID_Keep_M_KashitsukeZan");
    }

    /**
     * 退避貸付金残高を設定します。
     * @param ID_Keep_M_KashitsukeZan 退避貸付金残高
     */
    public void setID_Keep_M_KashitsukeZan(java.math.BigDecimal ID_Keep_M_KashitsukeZan) {
        setValue("ID_Keep_M_KashitsukeZan", ID_Keep_M_KashitsukeZan);
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public java.math.BigDecimal getID_Keep_M_YakujoGankin() {
        return (java.math.BigDecimal) getValue("ID_Keep_M_YakujoGankin");
    }

    /**
     * 退避約定元金を設定します。
     * @param ID_Keep_M_YakujoGankin 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin(java.math.BigDecimal ID_Keep_M_YakujoGankin) {
        setValue("ID_Keep_M_YakujoGankin", ID_Keep_M_YakujoGankin);
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public java.math.BigDecimal getID_Keep_M_YakujoRisoku() {
        return (java.math.BigDecimal) getValue("ID_Keep_M_YakujoRisoku");
    }

    /**
     * 退避約定利息を設定します。
     * @param ID_Keep_M_YakujoRisoku 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku(java.math.BigDecimal ID_Keep_M_YakujoRisoku) {
        setValue("ID_Keep_M_YakujoRisoku", ID_Keep_M_YakujoRisoku);
    }

    /**
     * 退避償還期限を取得します。
     * @return 退避償還期限
     */
    public String getID_Keep_Date_ShokanKigen() {
        return (String) getValue("ID_Keep_Date_ShokanKigen");
    }

    /**
     * 退避償還期限を設定します。
     * @param ID_Keep_Date_ShokanKigen 退避償還期限
     */
    public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
        setValue("ID_Keep_Date_ShokanKigen", ID_Keep_Date_ShokanKigen);
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_ID_Credit() {
        return (java.math.BigDecimal) getValue("ID_ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(java.math.BigDecimal ID_ID_Credit) {
        setValue("ID_ID_Credit", ID_ID_Credit);
    }

    /**
     * 顧客コードを取得します。
     * @return 顧客コード
     */
    public String getID_Code_Customer() {
        return (String) getValue("ID_Code_Customer");
    }

    /**
     * 顧客コードを設定します。
     * @param ID_Code_Customer 顧客コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        setValue("ID_Code_Customer", ID_Code_Customer);
    }

    /**
     * 充当順序変更区分を取得します。
     * @return 充当順序変更区分
     */
    public String getID_Kubun_JutoJunjoHenko() {
        return (String) getValue("ID_Kubun_JutoJunjoHenko");
    }

    /**
     * 充当順序変更区分を設定します。
     * @param ID_Kubun_JutoJunjoHenko 充当順序変更区分
     */
    public void setID_Kubun_JutoJunjoHenko(String ID_Kubun_JutoJunjoHenko) {
        setValue("ID_Kubun_JutoJunjoHenko", ID_Kubun_JutoJunjoHenko);
    }

    /**
     * 請求データの退避任意繰償還利息を取得します。
     * @return 請求データの退避任意繰償還利息
     */
    public java.math.BigDecimal getKeep_Seikyu_M_NinKuriRisoku() {
        return (java.math.BigDecimal) getValue("Keep_Seikyu_M_NinKuriRisoku");
    }

    /**
     * 請求データの退避任意繰償還利息を設定します。
     * @param Keep_Seikyu_M_NinKuriRisoku 請求データの退避任意繰償還利息
     */
    public void setKeep_Seikyu_M_NinKuriRisoku(java.math.BigDecimal Keep_Seikyu_M_NinKuriRisoku) {
        setValue("Keep_Seikyu_M_NinKuriRisoku", Keep_Seikyu_M_NinKuriRisoku);
    }

    /**
     * 請求データの退避請求繰償還利息を取得します。
     * @return 請求データの退避請求繰償還利息
     */
    public java.math.BigDecimal getKeep_Seikyu_M_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("Keep_Seikyu_M_SeiKuriRisoku");
    }

    /**
     * 請求データの退避請求繰償還利息を設定します。
     * @param Keep_Seikyu_M_SeiKuriRisoku 請求データの退避請求繰償還利息
     */
    public void setKeep_Seikyu_M_SeiKuriRisoku(java.math.BigDecimal Keep_Seikyu_M_SeiKuriRisoku) {
        setValue("Keep_Seikyu_M_SeiKuriRisoku", Keep_Seikyu_M_SeiKuriRisoku);
    }

    /**
     * 請求データの退避請求繰償還元金を取得します。
     * @return 請求データの退避請求繰償還元金
     */
    public java.math.BigDecimal getKeep_Seikyu_M_SeiKuriGankin() {
        return (java.math.BigDecimal) getValue("Keep_Seikyu_M_SeiKuriGankin");
    }

    /**
     * 請求データの退避請求繰償還元金を設定します。
     * @param Keep_Seikyu_M_SeiKuriGankin 請求データの退避請求繰償還元金
     */
    public void setKeep_Seikyu_M_SeiKuriGankin(java.math.BigDecimal Keep_Seikyu_M_SeiKuriGankin) {
        setValue("Keep_Seikyu_M_SeiKuriGankin", Keep_Seikyu_M_SeiKuriGankin);
    }

    /**
     * 約定データの退避請求繰償還利息を取得します。
     * @return 約定データの退避請求繰償還利息
     */
    public java.math.BigDecimal getKeep_Yakujo_M_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("Keep_Yakujo_M_SeiKuriRisoku");
    }

    /**
     * 約定データの退避請求繰償還利息を設定します。
     * @param Keep_Yakujo_M_SeiKuriRisoku 約定データの退避請求繰償還利息
     */
    public void setKeep_Yakujo_M_SeiKuriRisoku(java.math.BigDecimal Keep_Yakujo_M_SeiKuriRisoku) {
        setValue("Keep_Yakujo_M_SeiKuriRisoku", Keep_Yakujo_M_SeiKuriRisoku);
    }

    /**
     * 元利金計を取得します。
     * @return 元利金計
     */
    public java.math.BigDecimal getM_GanrikinKei() {
        return (java.math.BigDecimal) getValue("M_GanrikinKei");
    }

    /**
     * 元利金計を設定します。
     * @param M_GanrikinKei 元利金計
     */
    public void setM_GanrikinKei(java.math.BigDecimal M_GanrikinKei) {
        setValue("M_GanrikinKei", M_GanrikinKei);
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
     * 扱店別稟議データより取得した償還期限年月を取得します。
     * @return 扱店別稟議データより取得した償還期限年月
     */
    public String getARingi_Date_ShokanKigen() {
        return (String) getValue("aRingi_Date_ShokanKigen");
    }

    /**
     * 扱店別稟議データより取得した償還期限年月を設定します。
     * @param aRingi_Date_ShokanKigen 扱店別稟議データより取得した償還期限年月
     */
    public void setARingi_Date_ShokanKigen(String aRingi_Date_ShokanKigen) {
        setValue("aRingi_Date_ShokanKigen", aRingi_Date_ShokanKigen);
    }

    /**
     * 扱店別稟議データより取得した貸付残高を取得します。
     * @return 扱店別稟議データより取得した貸付残高
     */
    public java.math.BigDecimal getARingi_M_KashitsukeZandaka() {
        return (java.math.BigDecimal) getValue("aRingi_M_KashitsukeZandaka");
    }

    /**
     * 扱店別稟議データより取得した貸付残高を設定します。
     * @param aRingi_M_KashitsukeZandaka 扱店別稟議データより取得した貸付残高
     */
    public void setARingi_M_KashitsukeZandaka(java.math.BigDecimal aRingi_M_KashitsukeZandaka) {
        setValue("aRingi_M_KashitsukeZandaka", aRingi_M_KashitsukeZandaka);
    }

}