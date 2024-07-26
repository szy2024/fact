//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr003_02ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_02ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 払込期日を取得します。
     * @return 払込期日
     */
    public String getCr003_02Date_Haraikomi() {
        return (String) getValue("Cr003_02Date_Haraikomi");
    }

    /**
     * 払込期日を設定します。
     * @param Cr003_02Date_Haraikomi 払込期日
     */
    public void setCr003_02Date_Haraikomi(String Cr003_02Date_Haraikomi) {
        setValue("Cr003_02Date_Haraikomi", Cr003_02Date_Haraikomi);
    }

    /**
     * 検索条件を取得します。
     * @return 検索条件
     */
    public String getCr003_02Kind() {
        return (String) getValue("Cr003_02Kind");
    }

    /**
     * 検索条件を設定します。
     * @param Cr003_02Kind 検索条件
     */
    public void setCr003_02Kind(String Cr003_02Kind) {
        setValue("Cr003_02Kind", Cr003_02Kind);
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
     * 据置期限年月を取得します。
     * @return 据置期限年月
     */
    public String getDate_SueokiKigen() {
        return (String) getValue("Date_SueokiKigen");
    }

    /**
     * 据置期限年月を設定します。
     * @param Date_SueokiKigen 据置期限年月
     */
    public void setDate_SueokiKigen(String Date_SueokiKigen) {
        setValue("Date_SueokiKigen", Date_SueokiKigen);
    }

    /**
     * 償還期限年月を取得します。
     * @return 償還期限年月
     */
    public String getDate_ShokanKigen() {
        return (String) getValue("Date_ShokanKigen");
    }

    /**
     * 償還期限年月を設定します。
     * @param Date_ShokanKigen 償還期限年月
     */
    public void setDate_ShokanKigen(String Date_ShokanKigen) {
        setValue("Date_ShokanKigen", Date_ShokanKigen);
    }

    /**
     * 元利金払込月日を取得します。
     * @return 元利金払込月日
     */
    public String getDate_GanrikinHaraiKomi() {
        return (String) getValue("Date_GanrikinHaraiKomi");
    }

    /**
     * 元利金払込月日を設定します。
     * @param Date_GanrikinHaraiKomi 元利金払込月日
     */
    public void setDate_GanrikinHaraiKomi(String Date_GanrikinHaraiKomi) {
        setValue("Date_GanrikinHaraiKomi", Date_GanrikinHaraiKomi);
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
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return (String) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 金融機関名称を取得します。
     * @return 金融機関名称
     */
    public String getName_Organization() {
        return (String) getValue("Name_Organization");
    }

    /**
     * 金融機関名称を設定します。
     * @param Name_Organization 金融機関名称
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

    /**
     * 貸付先名称を取得します。
     * @return 貸付先名称
     */
    public String getName_Customer() {
        return (String) getValue("Name_Customer");
    }

    /**
     * 貸付先名称を設定します。
     * @param Name_Customer 貸付先名称
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
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
     * 貸付実行報告書作成済みフラグを取得します。
     * @return 貸付実行報告書作成済みフラグ
     */
    public java.math.BigDecimal getFlag_Kj() {
        return (java.math.BigDecimal) getValue("Flag_Kj");
    }

    /**
     * 貸付実行報告書作成済みフラグを設定します。
     * @param Flag_Kj 貸付実行報告書作成済みフラグ
     */
    public void setFlag_Kj(java.math.BigDecimal Flag_Kj) {
        setValue("Flag_Kj", Flag_Kj);
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
     * 実行年月日を取得します。
     * @return 実行年月日
     */
    public String getDate_Jikko() {
        return (String) getValue("Date_Jikko");
    }

    /**
     * 実行年月日を設定します。
     * @param Date_Jikko 実行年月日
     */
    public void setDate_Jikko(String Date_Jikko) {
        setValue("Date_Jikko", Date_Jikko);
    }

    /**
     * 賦金を取得します。
     * @return 賦金
     */
    public java.math.BigDecimal getM_Fukin() {
        return (java.math.BigDecimal) getValue("M_Fukin");
    }

    /**
     * 賦金を設定します。
     * @param M_Fukin 賦金
     */
    public void setM_Fukin(java.math.BigDecimal M_Fukin) {
        setValue("M_Fukin", M_Fukin);
    }

    /**
     * 貸付金残高を取得します。
     * @return 貸付金残高
     */
    public java.math.BigDecimal getM_KashitsukeZandaka() {
        return (java.math.BigDecimal) getValue("M_KashitsukeZandaka");
    }

    /**
     * 貸付金残高を設定します。
     * @param M_KashitsukeZandaka 貸付金残高
     */
    public void setM_KashitsukeZandaka(java.math.BigDecimal M_KashitsukeZandaka) {
        setValue("M_KashitsukeZandaka", M_KashitsukeZandaka);
    }

    /**
     * 償還方法コードを取得します。
     * @return 償還方法コード
     */
    public String getCode_ShokanHouhou() {
        return (String) getValue("Code_ShokanHouhou");
    }

    /**
     * 償還方法コードを設定します。
     * @param Code_ShokanHouhou 償還方法コード
     */
    public void setCode_ShokanHouhou(String Code_ShokanHouhou) {
        setValue("Code_ShokanHouhou", Code_ShokanHouhou);
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
     * 受託者勘定処理年月日を取得します。
     * @return 受託者勘定処理年月日
     */
    public String getDate_Jtkshori() {
        return (String) getValue("Date_Jtkshori");
    }

    /**
     * 受託者勘定処理年月日を設定します。
     * @param Date_Jtkshori 受託者勘定処理年月日
     */
    public void setDate_Jtkshori(String Date_Jtkshori) {
        setValue("Date_Jtkshori", Date_Jtkshori);
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
     * 違約金（利子軽減分）を取得します。
     * @return 違約金（利子軽減分）
     */
    public java.math.BigDecimal getM_IyakuRishikeigen() {
        return (java.math.BigDecimal) getValue("M_IyakuRishikeigen");
    }

    /**
     * 違約金（利子軽減分）を設定します。
     * @param M_IyakuRishikeigen 違約金（利子軽減分）
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
     * 取消済みフラグを取得します。
     * @return 取消済みフラグ
     */
    public java.math.BigDecimal getFlag_Torikeshizumi() {
        return (java.math.BigDecimal) getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済みフラグを設定します。
     * @param Flag_Torikeshizumi 取消済みフラグ
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
     * 退避約定利息を設定します。
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
     * 電子署名付データファイルパスを取得します。
     * @return 電子署名付データファイルパス
     */
    public String getSignData() {
        return (String) getValue("SignData");
    }

    /**
     * 電子署名付データファイルパスを設定します。
     * @param SignData 電子署名付データファイルパス
     */
    public void setSignData(String SignData) {
        setValue("SignData", SignData);
    }

    /**
     * 払込年月日を取得します。
     * @return 払込年月日
     */
    public String getDate_Haraikomi() {
        return (String) getValue("Date_Haraikomi");
    }

    /**
     * 払込年月日を設定します。
     * @param Date_Haraikomi 払込年月日
     */
    public void setDate_Haraikomi(String Date_Haraikomi) {
        setValue("Date_Haraikomi", Date_Haraikomi);
    }

    /**
     * 残高件数を取得します。
     * @return 残高件数
     */
    public java.math.BigDecimal getCount_Zandaka() {
        return (java.math.BigDecimal) getValue("Count_Zandaka");
    }

    /**
     * 残高件数を設定します。
     * @param Count_Zandaka 残高件数
     */
    public void setCount_Zandaka(java.math.BigDecimal Count_Zandaka) {
        setValue("Count_Zandaka", Count_Zandaka);
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
     * 特利有効年月日を取得します。
     * @return 特利有効年月日
     */
    public String getDate_TokuriYuko() {
        return (String) getValue("Date_TokuriYuko");
    }

    /**
     * 特利有効年月日を設定します。
     * @param Date_TokuriYuko 特利有効年月日
     */
    public void setDate_TokuriYuko(String Date_TokuriYuko) {
        setValue("Date_TokuriYuko", Date_TokuriYuko);
    }

    /**
     * 元金不均等額を取得します。
     * @return 元金不均等額
     */
    public java.math.BigDecimal getM_GankinFukinto() {
        return (java.math.BigDecimal) getValue("M_GankinFukinto");
    }

    /**
     * 元金不均等額を設定します。
     * @param M_GankinFukinto 元金不均等額
     */
    public void setM_GankinFukinto(java.math.BigDecimal M_GankinFukinto) {
        setValue("M_GankinFukinto", M_GankinFukinto);
    }

    /**
     * 元金不均等額区分を取得します。
     * @return 元金不均等額区分
     */
    public String getKubun_GankinFukintogaku() {
        return (String) getValue("Kubun_GankinFukintogaku");
    }

    /**
     * 元金不均等額区分を設定します。
     * @param Kubun_GankinFukintogaku 元金不均等額区分
     */
    public void setKubun_GankinFukintogaku(String Kubun_GankinFukintogaku) {
        setValue("Kubun_GankinFukintogaku", Kubun_GankinFukintogaku);
    }

    /**
     * 請求繰上償還利息（約定）を取得します。
     * @return 請求繰上償還利息（約定）
     */
    public java.math.BigDecimal getYakujo_M_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("Yakujo_M_SeiKuriRisoku");
    }

    /**
     * 請求繰上償還利息（約定）を設定します。
     * @param Yakujo_M_SeiKuriRisoku 請求繰上償還利息（約定）
     */
    public void setYakujo_M_SeiKuriRisoku(java.math.BigDecimal Yakujo_M_SeiKuriRisoku) {
        setValue("Yakujo_M_SeiKuriRisoku", Yakujo_M_SeiKuriRisoku);
    }

    /**
     * 請求繰上償還元金（請求）を取得します。
     * @return 請求繰上償還元金（請求）
     */
    public java.math.BigDecimal getSeikyu_M_SeiKuriGankin() {
        return (java.math.BigDecimal) getValue("Seikyu_M_SeiKuriGankin");
    }

    /**
     * 請求繰上償還元金（請求）を設定します。
     * @param Seikyu_M_SeiKuriGankin 請求繰上償還元金（請求）
     */
    public void setSeikyu_M_SeiKuriGankin(java.math.BigDecimal Seikyu_M_SeiKuriGankin) {
        setValue("Seikyu_M_SeiKuriGankin", Seikyu_M_SeiKuriGankin);
    }

    /**
     * 任意繰上償還利息（請求）を取得します。
     * @return 任意繰上償還利息（請求）
     */
    public java.math.BigDecimal getSeikyu_M_NinKuriRisoku() {
        return (java.math.BigDecimal) getValue("Seikyu_M_NinKuriRisoku");
    }

    /**
     * 任意繰上償還利息（請求）を設定します。
     * @param Seikyu_M_NinKuriRisoku 任意繰上償還利息（請求）
     */
    public void setSeikyu_M_NinKuriRisoku(java.math.BigDecimal Seikyu_M_NinKuriRisoku) {
        setValue("Seikyu_M_NinKuriRisoku", Seikyu_M_NinKuriRisoku);
    }

    /**
     * 請求繰上償還利息（請求）を取得します。
     * @return 請求繰上償還利息（請求）
     */
    public java.math.BigDecimal getSeikyu_M_SeiKuriRisoku() {
        return (java.math.BigDecimal) getValue("Seikyu_M_SeiKuriRisoku");
    }

    /**
     * 請求繰上償還利息（請求）を設定します。
     * @param Seikyu_M_SeiKuriRisoku 請求繰上償還利息（請求）
     */
    public void setSeikyu_M_SeiKuriRisoku(java.math.BigDecimal Seikyu_M_SeiKuriRisoku) {
        setValue("Seikyu_M_SeiKuriRisoku", Seikyu_M_SeiKuriRisoku);
    }

    /**
     * 充当順序変更区分を取得します。
     * @return 充当順序変更区分
     */
    public String getKubun_JutoJunjoHenko() {
        return (String) getValue("Kubun_JutoJunjoHenko");
    }

    /**
     * 充当順序変更区分を設定します。
     * @param Kubun_JutoJunjoHenko 充当順序変更区分
     */
    public void setKubun_JutoJunjoHenko(String Kubun_JutoJunjoHenko) {
        setValue("Kubun_JutoJunjoHenko", Kubun_JutoJunjoHenko);
    }

    /**
     * 最新更新日時を取得します。
     * @return 最新更新日時
     */
    public String getData_LastUpDate() {
        return (String) getValue("Data_LastUpDate");
    }

    /**
     * 最新更新日時を設定します。
     * @param Data_LastUpDate 最新更新日時
     */
    public void setData_LastUpDate(String Data_LastUpDate) {
        setValue("Data_LastUpDate", Data_LastUpDate);
    }

}