//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd004_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 繰償還後第１回払込期日を取得します。
     * @return 繰償還後第１回払込期日
     */
    public String getDate_FirstHaraikomiAfterKuris() {
        return (String) getValue("Date_FirstHaraikomiAfterKuris");
    }

    /**
     * 繰償還後第１回払込期日を設定します。
     * @param Date_FirstHaraikomiAfterKuris 繰償還後第１回払込期日
     */
    public void setDate_FirstHaraikomiAfterKuris(String Date_FirstHaraikomiAfterKuris) {
        setValue("Date_FirstHaraikomiAfterKuris", Date_FirstHaraikomiAfterKuris);
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
     * 繰上償還事由コードを取得します。
     * @return 繰上償還事由コード
     */
    public String getID_Code_KurishoJiyu() {
        return (String) getValue("ID_Code_KurishoJiyu");
    }

    /**
     * 繰上償還事由コードを設定します。
     * @param ID_Code_KurishoJiyu 繰上償還事由コード
     */
    public void setID_Code_KurishoJiyu(String ID_Code_KurishoJiyu) {
        setValue("ID_Code_KurishoJiyu", ID_Code_KurishoJiyu);
    }

    /**
     * 利息を取得します。
     * @return 利息
     */
    public String getID_M_KurishoRisoku() {
        return (String) getValue("ID_M_KurishoRisoku");
    }

    /**
     * 利息を設定します。
     * @param ID_M_KurishoRisoku 利息
     */
    public void setID_M_KurishoRisoku(String ID_M_KurishoRisoku) {
        setValue("ID_M_KurishoRisoku", ID_M_KurishoRisoku);
    }

    /**
     * 元金を取得します。
     * @return 元金
     */
    public String getID_M_KurishoGankin() {
        return (String) getValue("ID_M_KurishoGankin");
    }

    /**
     * 元金を設定します。
     * @param ID_M_KurishoGankin 元金
     */
    public void setID_M_KurishoGankin(String ID_M_KurishoGankin) {
        setValue("ID_M_KurishoGankin", ID_M_KurishoGankin);
    }

    /**
     * 仮受金からの充当額を取得します。
     * @return 仮受金からの充当額
     */
    public String getID_M_KariukeIppanJuto() {
        return (String) getValue("ID_M_KariukeIppanJuto");
    }

    /**
     * 仮受金からの充当額を設定します。
     * @param ID_M_KariukeIppanJuto 仮受金からの充当額
     */
    public void setID_M_KariukeIppanJuto(String ID_M_KariukeIppanJuto) {
        setValue("ID_M_KariukeIppanJuto", ID_M_KariukeIppanJuto);
    }

    /**
     * 控除利息を取得します。
     * @return 控除利息
     */
    public String getID_M_KojoRisoku() {
        return (String) getValue("ID_M_KojoRisoku");
    }

    /**
     * 控除利息を設定します。
     * @param ID_M_KojoRisoku 控除利息
     */
    public void setID_M_KojoRisoku(String ID_M_KojoRisoku) {
        setValue("ID_M_KojoRisoku", ID_M_KojoRisoku);
    }

    /**
     * 送金額を取得します。
     * @return 送金額
     */
    public String getID_M_Sokin() {
        return (String) getValue("ID_M_Sokin");
    }

    /**
     * 送金額を設定します。
     * @param ID_M_Sokin 送金額
     */
    public void setID_M_Sokin(String ID_M_Sokin) {
        setValue("ID_M_Sokin", ID_M_Sokin);
    }

    /**
     * 繰償後残元金を取得します。
     * @return 繰償後残元金
     */
    public String getID_M_ZanGankinAfterKurisho() {
        return (String) getValue("ID_M_ZanGankinAfterKurisho");
    }

    /**
     * 繰償後残元金を設定します。
     * @param ID_M_ZanGankinAfterKurisho 繰償後残元金
     */
    public void setID_M_ZanGankinAfterKurisho(String ID_M_ZanGankinAfterKurisho) {
        setValue("ID_M_ZanGankinAfterKurisho", ID_M_ZanGankinAfterKurisho);
    }

    /**
     * 繰上償還手数料を取得します。
     * @return 繰上償還手数料
     */
    public String getID_M_KurishoCommission() {
        return (String) getValue("ID_M_KurishoCommission");
    }

    /**
     * 繰上償還手数料を設定します。
     * @param ID_M_KurishoCommission 繰上償還手数料
     */
    public void setID_M_KurishoCommission(String ID_M_KurishoCommission) {
        setValue("ID_M_KurishoCommission", ID_M_KurishoCommission);
    }

    /**
     * 払込期日１を取得します。
     * @return 払込期日１
     */
    public String getID_Date_Haraikomi1() {
        return (String) getValue("ID_Date_Haraikomi1");
    }

    /**
     * 払込期日１を設定します。
     * @param ID_Date_Haraikomi1 払込期日１
     */
    public void setID_Date_Haraikomi1(String ID_Date_Haraikomi1) {
        setValue("ID_Date_Haraikomi1", ID_Date_Haraikomi1);
    }

    /**
     * 払込元金１を取得します。
     * @return 払込元金１
     */
    public String getID_M_HaraikomiGankin1() {
        return (String) getValue("ID_M_HaraikomiGankin1");
    }

    /**
     * 払込元金１を設定します。
     * @param ID_M_HaraikomiGankin1 払込元金１
     */
    public void setID_M_HaraikomiGankin1(String ID_M_HaraikomiGankin1) {
        setValue("ID_M_HaraikomiGankin1", ID_M_HaraikomiGankin1);
    }

    /**
     * 払込期日２を取得します。
     * @return 払込期日２
     */
    public String getID_Date_Haraikomi2() {
        return (String) getValue("ID_Date_Haraikomi2");
    }

    /**
     * 払込期日２を設定します。
     * @param ID_Date_Haraikomi2 払込期日２
     */
    public void setID_Date_Haraikomi2(String ID_Date_Haraikomi2) {
        setValue("ID_Date_Haraikomi2", ID_Date_Haraikomi2);
    }

    /**
     * 払込元金２を取得します。
     * @return 払込元金２
     */
    public String getID_M_HaraikomiGankin2() {
        return (String) getValue("ID_M_HaraikomiGankin2");
    }

    /**
     * 払込元金２を設定します。
     * @param ID_M_HaraikomiGankin2 払込元金２
     */
    public void setID_M_HaraikomiGankin2(String ID_M_HaraikomiGankin2) {
        setValue("ID_M_HaraikomiGankin2", ID_M_HaraikomiGankin2);
    }

    /**
     * 払込期日３を取得します。
     * @return 払込期日３
     */
    public String getID_Date_Haraikomi3() {
        return (String) getValue("ID_Date_Haraikomi3");
    }

    /**
     * 払込期日３を設定します。
     * @param ID_Date_Haraikomi3 払込期日３
     */
    public void setID_Date_Haraikomi3(String ID_Date_Haraikomi3) {
        setValue("ID_Date_Haraikomi3", ID_Date_Haraikomi3);
    }

    /**
     * 払込元金３を取得します。
     * @return 払込元金３
     */
    public String getID_M_HaraikomiGankin3() {
        return (String) getValue("ID_M_HaraikomiGankin3");
    }

    /**
     * 払込元金３を設定します。
     * @param ID_M_HaraikomiGankin3 払込元金３
     */
    public void setID_M_HaraikomiGankin3(String ID_M_HaraikomiGankin3) {
        setValue("ID_M_HaraikomiGankin3", ID_M_HaraikomiGankin3);
    }

    /**
     * 払込期日４を取得します。
     * @return 払込期日４
     */
    public String getID_Date_Haraikomi4() {
        return (String) getValue("ID_Date_Haraikomi4");
    }

    /**
     * 払込期日４を設定します。
     * @param ID_Date_Haraikomi4 払込期日４
     */
    public void setID_Date_Haraikomi4(String ID_Date_Haraikomi4) {
        setValue("ID_Date_Haraikomi4", ID_Date_Haraikomi4);
    }

    /**
     * 払込元金４を取得します。
     * @return 払込元金４
     */
    public String getID_M_HaraikomiGankin4() {
        return (String) getValue("ID_M_HaraikomiGankin4");
    }

    /**
     * 払込元金４を設定します。
     * @param ID_M_HaraikomiGankin4 払込元金４
     */
    public void setID_M_HaraikomiGankin4(String ID_M_HaraikomiGankin4) {
        setValue("ID_M_HaraikomiGankin4", ID_M_HaraikomiGankin4);
    }

    /**
     * 繰償後元金均等額を取得します。
     * @return 繰償後元金均等額
     */
    public String getID_M_GankinKintoAfterKurisho() {
        return (String) getValue("ID_M_GankinKintoAfterKurisho");
    }

    /**
     * 繰償後元金均等額を設定します。
     * @param ID_M_GankinKintoAfterKurisho 繰償後元金均等額
     */
    public void setID_M_GankinKintoAfterKurisho(String ID_M_GankinKintoAfterKurisho) {
        setValue("ID_M_GankinKintoAfterKurisho", ID_M_GankinKintoAfterKurisho);
    }

    /**
     * 繰償後元金不均等額を取得します。
     * @return 繰償後元金不均等額
     */
    public String getID_M_GankinFukintoAfterKurisho() {
        return (String) getValue("ID_M_GankinFukintoAfterKurisho");
    }

    /**
     * 繰償後元金不均等額を設定します。
     * @param ID_M_GankinFukintoAfterKurisho 繰償後元金不均等額
     */
    public void setID_M_GankinFukintoAfterKurisho(String ID_M_GankinFukintoAfterKurisho) {
        setValue("ID_M_GankinFukintoAfterKurisho", ID_M_GankinFukintoAfterKurisho);
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getID_Code_Chosei() {
        return (String) getValue("ID_Code_Chosei");
    }

    /**
     * 調整コードを設定します。
     * @param ID_Code_Chosei 調整コード
     */
    public void setID_Code_Chosei(String ID_Code_Chosei) {
        setValue("ID_Code_Chosei", ID_Code_Chosei);
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
     * エラーコードを取得します。
     * @return エラーコード
     */
    public String getID_Code_Error() {
        return (String) getValue("ID_Code_Error");
    }

    /**
     * エラーコードを設定します。
     * @param ID_Code_Error エラーコード
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
     * 退避賦金を取得します。
     * @return 退避賦金
     */
    public String getID_Keep_M_Fukin() {
        return (String) getValue("ID_Keep_M_Fukin");
    }

    /**
     * 退避賦金を設定します。
     * @param ID_Keep_M_Fukin 退避賦金
     */
    public void setID_Keep_M_Fukin(String ID_Keep_M_Fukin) {
        setValue("ID_Keep_M_Fukin", ID_Keep_M_Fukin);
    }

    /**
     * 退避元金不均等額を取得します。
     * @return 退避元金不均等額
     */
    public String getID_Keep_M_GankinFukinto() {
        return (String) getValue("ID_Keep_M_GankinFukinto");
    }

    /**
     * 退避元金不均等額を設定します。
     * @param ID_Keep_M_GankinFukinto 退避元金不均等額
     */
    public void setID_Keep_M_GankinFukinto(String ID_Keep_M_GankinFukinto) {
        setValue("ID_Keep_M_GankinFukinto", ID_Keep_M_GankinFukinto);
    }

    /**
     * 退避元金不均等区分を取得します。
     * @return 退避元金不均等区分
     */
    public String getID_Keep_Kubun_GankinFukinto() {
        return (String) getValue("ID_Keep_Kubun_GankinFukinto");
    }

    /**
     * 退避元金不均等区分を設定します。
     * @param ID_Keep_Kubun_GankinFukinto 退避元金不均等区分
     */
    public void setID_Keep_Kubun_GankinFukinto(String ID_Keep_Kubun_GankinFukinto) {
        setValue("ID_Keep_Kubun_GankinFukinto", ID_Keep_Kubun_GankinFukinto);
    }

    /**
     * 退避貸付残高を取得します。
     * @return 退避貸付残高
     */
    public String getID_Keep_M_KashitsukeZan() {
        return (String) getValue("ID_Keep_M_KashitsukeZan");
    }

    /**
     * 退避貸付残高を設定します。
     * @param ID_Keep_M_KashitsukeZan 退避貸付残高
     */
    public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
        setValue("ID_Keep_M_KashitsukeZan", ID_Keep_M_KashitsukeZan);
    }

    /**
     * 退避約定元金を取得します。
     * @return 退避約定元金
     */
    public String getID_Keep_M_YakujoGankin() {
        return (String) getValue("ID_Keep_M_YakujoGankin");
    }

    /**
     * 退避約定元金を設定します。
     * @param ID_Keep_M_YakujoGankin 退避約定元金
     */
    public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
        setValue("ID_Keep_M_YakujoGankin", ID_Keep_M_YakujoGankin);
    }

    /**
     * 退避約定利息を取得します。
     * @return 退避約定利息
     */
    public String getID_Keep_M_YakujoRisoku() {
        return (String) getValue("ID_Keep_M_YakujoRisoku");
    }

    /**
     * 退避約定利息を設定します。
     * @param ID_Keep_M_YakujoRisoku 退避約定利息
     */
    public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
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
     * 最終更新年月日を取得します。
     * @return 最終更新年月日
     */
    public String getID_Data_LastUpDate() {
        return (String) getValue("ID_Data_LastUpDate");
    }

    /**
     * 最終更新年月日を設定します。
     * @param ID_Data_LastUpDate 最終更新年月日
     */
    public void setID_Data_LastUpDate(String ID_Data_LastUpDate) {
        setValue("ID_Data_LastUpDate", ID_Data_LastUpDate);
    }

    /**
     * 退避控除利息を取得します。
     * @return 退避控除利息
     */
    public String getID_Keep_M_KojoRisoku() {
        return (String) getValue("ID_Keep_M_KojoRisoku");
    }

    /**
     * 退避控除利息を設定します。
     * @param ID_Keep_M_KojoRisoku 退避控除利息
     */
    public void setID_Keep_M_KojoRisoku(String ID_Keep_M_KojoRisoku) {
        setValue("ID_Keep_M_KojoRisoku", ID_Keep_M_KojoRisoku);
    }

    /**
     * 退避払込期日を取得します。
     * @return 退避払込期日
     */
    public String getID_Keep_Date_Haraikomi() {
        return (String) getValue("ID_Keep_Date_Haraikomi");
    }

    /**
     * 退避払込期日を設定します。
     * @param ID_Keep_Date_Haraikomi 退避払込期日
     */
    public void setID_Keep_Date_Haraikomi(String ID_Keep_Date_Haraikomi) {
        setValue("ID_Keep_Date_Haraikomi", ID_Keep_Date_Haraikomi);
    }

    /**
     * 退避条変起案中区分を取得します。
     * @return 退避条変起案中区分
     */
    public String getID_Keep_JohenKianchu() {
        return (String) getValue("ID_Keep_JohenKianchu");
    }

    /**
     * 退避条変起案中区分を設定します。
     * @param ID_Keep_JohenKianchu 退避条変起案中区分
     */
    public void setID_Keep_JohenKianchu(String ID_Keep_JohenKianchu) {
        setValue("ID_Keep_JohenKianchu", ID_Keep_JohenKianchu);
    }

    /**
     * 条変起案中区分・稟議データを取得します。
     * @return 条変起案中区分・稟議データ
     */
    public String getID_Kubun_JohenKianchu() {
        return (String) getValue("ID_Kubun_JohenKianchu");
    }

    /**
     * 条変起案中区分・稟議データを設定します。
     * @param ID_Kubun_JohenKianchu 条変起案中区分・稟議データ
     */
    public void setID_Kubun_JohenKianchu(String ID_Kubun_JohenKianchu) {
        setValue("ID_Kubun_JohenKianchu", ID_Kubun_JohenKianchu);
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Jikko() {
        return (String) getValue("ID_Date_Jikko");
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Jikko 貸付実行日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        setValue("ID_Date_Jikko", ID_Date_Jikko);
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getID_Code_ShokanHouhou() {
        return (String) getValue("ID_Code_ShokanHouhou");
    }

    /**
     * 償還方法を設定します。
     * @param ID_Code_ShokanHouhou 償還方法
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        setValue("ID_Code_ShokanHouhou", ID_Code_ShokanHouhou);
    }

    /**
     * 貸付残高・稟議データを取得します。
     * @return 貸付残高・稟議データ
     */
    public String getID_M_KashitsukeZandaka() {
        return (String) getValue("ID_M_KashitsukeZandaka");
    }

    /**
     * 貸付残高・稟議データを設定します。
     * @param ID_M_KashitsukeZandaka 貸付残高・稟議データ
     */
    public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
        setValue("ID_M_KashitsukeZandaka", ID_M_KashitsukeZandaka);
    }

    /**
     * 償還期限・稟議データを取得します。
     * @return 償還期限・稟議データ
     */
    public String getID_Date_ShokanKigen() {
        return (String) getValue("ID_Date_ShokanKigen");
    }

    /**
     * 償還期限・稟議データを設定します。
     * @param ID_Date_ShokanKigen 償還期限・稟議データ
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        setValue("ID_Date_ShokanKigen", ID_Date_ShokanKigen);
    }

    /**
     * 賦金・稟議データを取得します。
     * @return 賦金・稟議データ
     */
    public String getID_M_Fukin() {
        return (String) getValue("ID_M_Fukin");
    }

    /**
     * 賦金・稟議データを設定します。
     * @param ID_M_Fukin 賦金・稟議データ
     */
    public void setID_M_Fukin(String ID_M_Fukin) {
        setValue("ID_M_Fukin", ID_M_Fukin);
    }

    /**
     * 元金不均等額・稟議データを取得します。
     * @return 元金不均等額・稟議データ
     */
    public String getID_M_GankinFukinto() {
        return (String) getValue("ID_M_GankinFukinto");
    }

    /**
     * 元金不均等額・稟議データを設定します。
     * @param ID_M_GankinFukinto 元金不均等額・稟議データ
     */
    public void setID_M_GankinFukinto(String ID_M_GankinFukinto) {
        setValue("ID_M_GankinFukinto", ID_M_GankinFukinto);
    }

    /**
     * 元金不均等額区分・稟議データを取得します。
     * @return 元金不均等額区分・稟議データ
     */
    public String getID_Kubun_GankinFukintogaku() {
        return (String) getValue("ID_Kubun_GankinFukintogaku");
    }

    /**
     * 元金不均等額区分・稟議データを設定します。
     * @param ID_Kubun_GankinFukintogaku 元金不均等額区分・稟議データ
     */
    public void setID_Kubun_GankinFukintogaku(String ID_Kubun_GankinFukintogaku) {
        setValue("ID_Kubun_GankinFukintogaku", ID_Kubun_GankinFukintogaku);
    }

    /**
     * 繰上償還手数料区分・稟議データを取得します。
     * @return 繰上償還手数料区分・稟議データ
     */
    public String getID_Kubun_KurishoTesuryo() {
        return (String) getValue("ID_Kubun_KurishoTesuryo");
    }

    /**
     * 繰上償還手数料区分・稟議データを設定します。
     * @param ID_Kubun_KurishoTesuryo 繰上償還手数料区分・稟議データ
     */
    public void setID_Kubun_KurishoTesuryo(String ID_Kubun_KurishoTesuryo) {
        setValue("ID_Kubun_KurishoTesuryo", ID_Kubun_KurishoTesuryo);
    }

    /**
     * 元利金払込日・稟議データを取得します。
     * @return 元利金払込日・稟議データ
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return (String) getValue("ID_Date_GanrikinHaraiKomi");
    }

    /**
     * 元利金払込日・稟議データを設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込日・稟議データ
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        setValue("ID_Date_GanrikinHaraiKomi", ID_Date_GanrikinHaraiKomi);
    }

    /**
     * 据置期限・稟議データを取得します。
     * @return 据置期限・稟議データ
     */
    public String getID_Date_SueokiKigen() {
        return (String) getValue("ID_Date_SueokiKigen");
    }

    /**
     * 据置期限・稟議データを設定します。
     * @param ID_Date_SueokiKigen 据置期限・稟議データ
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        setValue("ID_Date_SueokiKigen", ID_Date_SueokiKigen);
    }

    /**
     * 特利有効期限・稟議データを取得します。
     * @return 特利有効期限・稟議データ
     */
    public String getID_Date_TokuriYuko() {
        return (String) getValue("ID_Date_TokuriYuko");
    }

    /**
     * 特利有効期限・稟議データを設定します。
     * @param ID_Date_TokuriYuko 特利有効期限・稟議データ
     */
    public void setID_Date_TokuriYuko(String ID_Date_TokuriYuko) {
        setValue("ID_Date_TokuriYuko", ID_Date_TokuriYuko);
    }

    /**
     * 利率・稟議データを取得します。
     * @return 利率・稟議データ
     */
    public String getID_Riritsu() {
        return (String) getValue("ID_Riritsu");
    }

    /**
     * 利率・稟議データを設定します。
     * @param ID_Riritsu 利率・稟議データ
     */
    public void setID_Riritsu(String ID_Riritsu) {
        setValue("ID_Riritsu", ID_Riritsu);
    }

    /**
     * 特利・稟議データを取得します。
     * @return 特利・稟議データ
     */
    public String getID_Tokuri() {
        return (String) getValue("ID_Tokuri");
    }

    /**
     * 特利・稟議データを設定します。
     * @param ID_Tokuri 特利・稟議データ
     */
    public void setID_Tokuri(String ID_Tokuri) {
        setValue("ID_Tokuri", ID_Tokuri);
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
     * 報告書番号を取得します。
     * @return 報告書番号２
     */
    public String getID_ID_Report() {
        return (String) getValue("ID_ID_Report");
    }

    /**
     * 報告書番号を設定します。
     * @param ID_ID_Report 報告書番号２
     */
    public void setID_ID_Report(String ID_ID_Report) {
        setValue("ID_ID_Report", ID_ID_Report);
    }

    /**
     * 時刻を取得します。
     * @return 時刻
     */
    public String getID_Time_Report() {
        return (String) getValue("ID_Time_Report");
    }

    /**
     * 時刻を設定します。
     * @param ID_Time_Report 時刻
     */
    public void setID_Time_Report(String ID_Time_Report) {
        setValue("ID_Time_Report", ID_Time_Report);
    }

    /**
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getID_User_ID() {
        return (String) getValue("ID_User_ID");
    }

    /**
     * ユーザＩＤを設定します。
     * @param ID_User_ID ユーザＩＤ
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
     * 退避履歴番号を取得します。
     * @return 退避履歴番号
     */
    public String getID_Keep_ID_History() {
        return (String) getValue("ID_Keep_ID_History");
    }

    /**
     * 退避履歴番号を設定します。
     * @param ID_Keep_ID_History 退避履歴番号
     */
    public void setID_Keep_ID_History(String ID_Keep_ID_History) {
        setValue("ID_Keep_ID_History", ID_Keep_ID_History);
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

}