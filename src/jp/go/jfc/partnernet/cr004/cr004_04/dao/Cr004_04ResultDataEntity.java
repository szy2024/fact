//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr004_04ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultDataEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号指定を取得します。
     * @return 債権管理番号指定
     */
    public String getCr004_04_ID_Credit() {
        return (String) getValue("Cr004_04_ID_Credit");
    }

    /**
     * 債権管理番号指定を設定します。
     * @param Cr004_04_ID_Credit 債権管理番号指定
     */
    public void setCr004_04_ID_Credit(String Cr004_04_ID_Credit) {
        setValue("Cr004_04_ID_Credit", Cr004_04_ID_Credit);
    }

    /**
     * 公庫支店コード指定を取得します。
     * @return 公庫支店コード指定
     */
    public String getCr004_04_Code_ShokanHonShiten() {
        return (String) getValue("Cr004_04_Code_ShokanHonShiten");
    }

    /**
     * 公庫支店コード指定を設定します。
     * @param Cr004_04_Code_ShokanHonShiten 公庫支店コード指定
     */
    public void setCr004_04_Code_ShokanHonShiten(String Cr004_04_Code_ShokanHonShiten) {
        setValue("Cr004_04_Code_ShokanHonShiten", Cr004_04_Code_ShokanHonShiten);
    }

    /**
     * 扱店コード指定を取得します。
     * @return 扱店コード指定
     */
    public String getCr004_04_Code_Organization() {
        return (String) getValue("Cr004_04_Code_Organization");
    }

    /**
     * 扱店コード指定を設定します。
     * @param Cr004_04_Code_Organization 扱店コード指定
     */
    public void setCr004_04_Code_Organization(String Cr004_04_Code_Organization) {
        setValue("Cr004_04_Code_Organization", Cr004_04_Code_Organization);
    }

    /**
     * 店舗コード指定を取得します。
     * @return 店舗コード指定
     */
    public String getCr004_04_Code_Tenpo() {
        return (String) getValue("Cr004_04_Code_Tenpo");
    }

    /**
     * 店舗コード指定を設定します。
     * @param Cr004_04_Code_Tenpo 店舗コード指定
     */
    public void setCr004_04_Code_Tenpo(String Cr004_04_Code_Tenpo) {
        setValue("Cr004_04_Code_Tenpo", Cr004_04_Code_Tenpo);
    }

    /**
     * 年度指定を取得します。
     * @return 年度指定
     */
    public String getCr004_04_Year() {
        return (String) getValue("Cr004_04_Year");
    }

    /**
     * 年度指定を設定します。
     * @param Cr004_04_Year 年度指定
     */
    public void setCr004_04_Year(String Cr004_04_Year) {
        setValue("Cr004_04_Year", Cr004_04_Year);
    }

    /**
     * 方式資金指定を取得します。
     * @return 方式資金指定
     */
    public String getCr004_04_Code_HoshikiShikin() {
        return (String) getValue("Cr004_04_Code_HoshikiShikin");
    }

    /**
     * 方式資金指定を設定します。
     * @param Cr004_04_Code_HoshikiShikin 方式資金指定
     */
    public void setCr004_04_Code_HoshikiShikin(String Cr004_04_Code_HoshikiShikin) {
        setValue("Cr004_04_Code_HoshikiShikin", Cr004_04_Code_HoshikiShikin);
    }

    /**
     * 番号指定を取得します。
     * @return 番号指定
     */
    public String getCr004_04_ID_Ringi() {
        return (String) getValue("Cr004_04_ID_Ringi");
    }

    /**
     * 番号指定を設定します。
     * @param Cr004_04_ID_Ringi 番号指定
     */
    public void setCr004_04_ID_Ringi(String Cr004_04_ID_Ringi) {
        setValue("Cr004_04_ID_Ringi", Cr004_04_ID_Ringi);
    }

    /**
     * 枝番指定を取得します。
     * @return 枝番指定
     */
    public String getCr004_04_ID_RingiBranch() {
        return (String) getValue("Cr004_04_ID_RingiBranch");
    }

    /**
     * 枝番指定を設定します。
     * @param Cr004_04_ID_RingiBranch 枝番指定
     */
    public void setCr004_04_ID_RingiBranch(String Cr004_04_ID_RingiBranch) {
        setValue("Cr004_04_ID_RingiBranch", Cr004_04_ID_RingiBranch);
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
     * 繰償後第１回払込日を取得します。
     * @return 繰償後第１回払込日
     */
    public String getDate_FirstHaraikomiAfterKuriS() {
        return (String) getValue("Date_FirstHaraikomiAfterKuriS");
    }

    /**
     * 繰償後第１回払込日を設定します。
     * @param Date_FirstHaraikomiAfterKuriS 繰償後第１回払込日
     */
    public void setDate_FirstHaraikomiAfterKuriS(String Date_FirstHaraikomiAfterKuriS) {
        setValue("Date_FirstHaraikomiAfterKuriS", Date_FirstHaraikomiAfterKuriS);
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
     * 繰上償還事由コードを取得します。
     * @return 繰上償還事由コード
     */
    public String getCode_Kurishojiyu() {
        return (String) getValue("Code_Kurishojiyu");
    }

    /**
     * 繰上償還事由コードを設定します。
     * @param Code_Kurishojiyu 繰上償還事由コード
     */
    public void setCode_Kurishojiyu(String Code_Kurishojiyu) {
        setValue("Code_Kurishojiyu", Code_Kurishojiyu);
    }

    /**
     * 利息を取得します。
     * @return 利息
     */
    public java.math.BigDecimal getM_KurishoRisoku() {
        return (java.math.BigDecimal) getValue("M_KurishoRisoku");
    }

    /**
     * 利息を設定します。
     * @param M_KurishoRisoku 利息
     */
    public void setM_KurishoRisoku(java.math.BigDecimal M_KurishoRisoku) {
        setValue("M_KurishoRisoku", M_KurishoRisoku);
    }

    /**
     * 元金を取得します。
     * @return 元金
     */
    public java.math.BigDecimal getM_KurishoGankin() {
        return (java.math.BigDecimal) getValue("M_KurishoGankin");
    }

    /**
     * 元金を設定します。
     * @param M_KurishoGankin 元金
     */
    public void setM_KurishoGankin(java.math.BigDecimal M_KurishoGankin) {
        setValue("M_KurishoGankin", M_KurishoGankin);
    }

    /**
     * 借受金からの充当額を取得します。
     * @return 借受金からの充当額
     */
    public java.math.BigDecimal getM_KariukeIppanJuto() {
        return (java.math.BigDecimal) getValue("M_KariukeIppanJuto");
    }

    /**
     * 借受金からの充当額を設定します。
     * @param M_KariukeIppanJuto 借受金からの充当額
     */
    public void setM_KariukeIppanJuto(java.math.BigDecimal M_KariukeIppanJuto) {
        setValue("M_KariukeIppanJuto", M_KariukeIppanJuto);
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
     * 送金額を取得します。
     * @return 送金額
     */
    public java.math.BigDecimal getM_Sokin() {
        return (java.math.BigDecimal) getValue("M_Sokin");
    }

    /**
     * 送金額を設定します。
     * @param M_Sokin 送金額
     */
    public void setM_Sokin(java.math.BigDecimal M_Sokin) {
        setValue("M_Sokin", M_Sokin);
    }

    /**
     * 繰償後残元金を取得します。
     * @return 繰償後残元金
     */
    public java.math.BigDecimal getM_ZanGankinAfterKurisho() {
        return (java.math.BigDecimal) getValue("M_ZanGankinAfterKurisho");
    }

    /**
     * 繰償後残元金を設定します。
     * @param M_ZanGankinAfterKurisho 繰償後残元金
     */
    public void setM_ZanGankinAfterKurisho(java.math.BigDecimal M_ZanGankinAfterKurisho) {
        setValue("M_ZanGankinAfterKurisho", M_ZanGankinAfterKurisho);
    }

    /**
     * 繰上償還手数料を取得します。
     * @return 繰上償還手数料
     */
    public java.math.BigDecimal getM_KurishoCommission() {
        return (java.math.BigDecimal) getValue("M_KurishoCommission");
    }

    /**
     * 繰上償還手数料を設定します。
     * @param M_KurishoCommission 繰上償還手数料
     */
    public void setM_KurishoCommission(java.math.BigDecimal M_KurishoCommission) {
        setValue("M_KurishoCommission", M_KurishoCommission);
    }

    /**
     * 払込期日１を取得します。
     * @return 払込期日１
     */
    public String getDate_Haraikomi1() {
        return (String) getValue("Date_Haraikomi1");
    }

    /**
     * 払込期日１を設定します。
     * @param Date_Haraikomi1 払込期日１
     */
    public void setDate_Haraikomi1(String Date_Haraikomi1) {
        setValue("Date_Haraikomi1", Date_Haraikomi1);
    }

    /**
     * 払込元金１を取得します。
     * @return 払込元金１
     */
    public java.math.BigDecimal getM_HaraikomiGankin1() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin1");
    }

    /**
     * 払込元金１を設定します。
     * @param M_HaraikomiGankin1 払込元金１
     */
    public void setM_HaraikomiGankin1(java.math.BigDecimal M_HaraikomiGankin1) {
        setValue("M_HaraikomiGankin1", M_HaraikomiGankin1);
    }

    /**
     * 払込期日２を取得します。
     * @return 払込期日２
     */
    public String getDate_Haraikomi2() {
        return (String) getValue("Date_Haraikomi2");
    }

    /**
     * 払込期日２を設定します。
     * @param Date_Haraikomi2 払込期日２
     */
    public void setDate_Haraikomi2(String Date_Haraikomi2) {
        setValue("Date_Haraikomi2", Date_Haraikomi2);
    }

    /**
     * 払込元金２を取得します。
     * @return 払込元金２
     */
    public java.math.BigDecimal getM_HaraikomiGankin2() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin2");
    }

    /**
     * 払込元金２を設定します。
     * @param M_HaraikomiGankin2 払込元金２
     */
    public void setM_HaraikomiGankin2(java.math.BigDecimal M_HaraikomiGankin2) {
        setValue("M_HaraikomiGankin2", M_HaraikomiGankin2);
    }

    /**
     * 払込期日３を取得します。
     * @return 払込期日３
     */
    public String getDate_Haraikomi3() {
        return (String) getValue("Date_Haraikomi3");
    }

    /**
     * 払込期日３を設定します。
     * @param Date_Haraikomi3 払込期日３
     */
    public void setDate_Haraikomi3(String Date_Haraikomi3) {
        setValue("Date_Haraikomi3", Date_Haraikomi3);
    }

    /**
     * 払込元金３を取得します。
     * @return 払込元金３
     */
    public java.math.BigDecimal getM_HaraikomiGankin3() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin3");
    }

    /**
     * 払込元金３を設定します。
     * @param M_HaraikomiGankin3 払込元金３
     */
    public void setM_HaraikomiGankin3(java.math.BigDecimal M_HaraikomiGankin3) {
        setValue("M_HaraikomiGankin3", M_HaraikomiGankin3);
    }

    /**
     * 払込期日４を取得します。
     * @return 払込期日４
     */
    public String getDate_Haraikomi4() {
        return (String) getValue("Date_Haraikomi4");
    }

    /**
     * 払込期日４を設定します。
     * @param Date_Haraikomi4 払込期日４
     */
    public void setDate_Haraikomi4(String Date_Haraikomi4) {
        setValue("Date_Haraikomi4", Date_Haraikomi4);
    }

    /**
     * 払込元金４を取得します。
     * @return 払込元金４
     */
    public java.math.BigDecimal getM_HaraikomiGankin4() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin4");
    }

    /**
     * 払込元金４を設定します。
     * @param M_HaraikomiGankin4 払込元金４
     */
    public void setM_HaraikomiGankin4(java.math.BigDecimal M_HaraikomiGankin4) {
        setValue("M_HaraikomiGankin4", M_HaraikomiGankin4);
    }

    /**
     * 繰償後元金均等額を取得します。
     * @return 繰償後元金均等額
     */
    public java.math.BigDecimal getM_GankinKintoAfterKurisho() {
        return (java.math.BigDecimal) getValue("M_GankinKintoAfterKurisho");
    }

    /**
     * 繰償後元金均等額を設定します。
     * @param M_GankinKintoAfterKurisho 繰償後元金均等額
     */
    public void setM_GankinKintoAfterKurisho(java.math.BigDecimal M_GankinKintoAfterKurisho) {
        setValue("M_GankinKintoAfterKurisho", M_GankinKintoAfterKurisho);
    }

    /**
     * 繰償後元金不均等額を取得します。
     * @return 繰償後元金不均等額
     */
    public java.math.BigDecimal getM_GankinFukintoAfterKurisho() {
        return (java.math.BigDecimal) getValue("M_GankinFukintoAfterKurisho");
    }

    /**
     * 繰償後元金不均等額を設定します。
     * @param M_GankinFukintoAfterKurisho 繰償後元金不均等額
     */
    public void setM_GankinFukintoAfterKurisho(java.math.BigDecimal M_GankinFukintoAfterKurisho) {
        setValue("M_GankinFukintoAfterKurisho", M_GankinFukintoAfterKurisho);
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getCode_chosei() {
        return (String) getValue("Code_chosei");
    }

    /**
     * 調整コードを設定します。
     * @param Code_chosei 調整コード
     */
    public void setCode_chosei(String Code_chosei) {
        setValue("Code_chosei", Code_chosei);
    }

    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getDate_JtkShori() {
        return (String) getValue("Date_JtkShori");
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param Date_JtkShori 受託者勘定処理年月
     */
    public void setDate_JtkShori(String Date_JtkShori) {
        setValue("Date_JtkShori", Date_JtkShori);
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
     * 代位弁済後の返済を取得します。
     * @return 代位弁済後の返済
     */
    public String getID_After_Daiibensai_Red() {
        return (String) getValue("ID_After_Daiibensai_Red");
    }

    /**
     * 代位弁済後の返済を設定します。
     * @param ID_After_Daiibensai_Red 代位弁済後の返済
     */
    public void setID_After_Daiibensai_Red(String ID_After_Daiibensai_Red) {
        setValue("ID_After_Daiibensai_Red", ID_After_Daiibensai_Red);
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
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getUserID() {
        return (String) getValue("UserID");
    }

    /**
     * ユーザＩＤを設定します。
     * @param UserID ユーザＩＤ
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

    /**
     * 住所コードを取得します。
     * @return 住所コード
     */
    public String getCode_Jusho() {
        return (String) getValue("Code_Jusho");
    }

    /**
     * 住所コードを設定します。
     * @param Code_Jusho 住所コード
     */
    public void setCode_Jusho(String Code_Jusho) {
        setValue("Code_Jusho", Code_Jusho);
    }

    /**
     * 繰上償還手数料区分を取得します。
     * @return 繰上償還手数料区分
     */
    public String getKubun_KurishoTesuryo() {
        return (String) getValue("Kubun_KurishoTesuryo");
    }

    /**
     * 繰上償還手数料区分を設定します。
     * @param Kubun_KurishoTesuryo 繰上償還手数料区分
     */
    public void setKubun_KurishoTesuryo(String Kubun_KurishoTesuryo) {
        setValue("Kubun_KurishoTesuryo", Kubun_KurishoTesuryo);
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
     * 退避償還期限年月を取得します。
     * @return 退避償還期限年月
     */
    public String getDate_ShokanKigen() {
        return (String) getValue("Date_ShokanKigen");
    }

    /**
     * 退避償還期限年月を設定します。
     * @param Date_ShokanKigen 退避償還期限年月
     */
    public void setDate_ShokanKigen(String Date_ShokanKigen) {
        setValue("Date_ShokanKigen", Date_ShokanKigen);
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
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public java.math.BigDecimal getM_KashitsukeUkeire() {
        return (java.math.BigDecimal) getValue("M_KashitsukeUkeire");
    }

    /**
     * 貸付受入金残高を設定します。
     * @param M_KashitsukeUkeire 貸付受入金残高
     */
    public void setM_KashitsukeUkeire(java.math.BigDecimal M_KashitsukeUkeire) {
        setValue("M_KashitsukeUkeire", M_KashitsukeUkeire);
    }

    /**
     * 計数管理処理番号を取得します。
     * @return 計数管理処理番号
     */
    public String getID_KeisuKanriShori() {
        return (String) getValue("ID_KeisuKanriShori");
    }

    /**
     * 計数管理処理番号を設定します。
     * @param ID_KeisuKanriShori 計数管理処理番号
     */
    public void setID_KeisuKanriShori(String ID_KeisuKanriShori) {
        setValue("ID_KeisuKanriShori", ID_KeisuKanriShori);
    }

    /**
     * 本決算整理期間を取得します。
     * @return 本決算整理期間
     */
    public String getDate_KessanSeiri() {
        return (String) getValue("Date_KessanSeiri");
    }

    /**
     * 本決算整理期間を設定します。
     * @param Date_KessanSeiri 本決算整理期間
     */
    public void setDate_KessanSeiri(String Date_KessanSeiri) {
        setValue("Date_KessanSeiri", Date_KessanSeiri);
    }

    /**
     * 約定元金・請求を取得します。
     * @return 約定元金・請求
     */
    public java.math.BigDecimal getM_YakujoGankin_Seikyu() {
        return (java.math.BigDecimal) getValue("M_YakujoGankin_Seikyu");
    }

    /**
     * 約定元金・請求を設定します。
     * @param M_YakujoGankin_Seikyu 約定元金・請求
     */
    public void setM_YakujoGankin_Seikyu(java.math.BigDecimal M_YakujoGankin_Seikyu) {
        setValue("M_YakujoGankin_Seikyu", M_YakujoGankin_Seikyu);
    }

    /**
     * 約定利息・請求を取得します。
     * @return 約定利息・請求
     */
    public java.math.BigDecimal getM_YakujoRisoku_Seikyu() {
        return (java.math.BigDecimal) getValue("M_YakujoRisoku_Seikyu");
    }

    /**
     * 約定利息・請求を設定します。
     * @param M_YakujoRisoku_Seikyu 約定利息・請求
     */
    public void setM_YakujoRisoku_Seikyu(java.math.BigDecimal M_YakujoRisoku_Seikyu) {
        setValue("M_YakujoRisoku_Seikyu", M_YakujoRisoku_Seikyu);
    }

    /**
     * 約定元金・約定を取得します。
     * @return 約定元金・約定
     */
    public java.math.BigDecimal getM_YakujoGankin_Yakujo() {
        return (java.math.BigDecimal) getValue("M_YakujoGankin_Yakujo");
    }

    /**
     * 約定元金・約定を設定します。
     * @param M_YakujoGankin_Yakujo 約定元金・約定
     */
    public void setM_YakujoGankin_Yakujo(java.math.BigDecimal M_YakujoGankin_Yakujo) {
        setValue("M_YakujoGankin_Yakujo", M_YakujoGankin_Yakujo);
    }

    /**
     * 約定利息・約定を取得します。
     * @return 約定利息・約定
     */
    public java.math.BigDecimal getM_YakujoRisoku_Yakujo() {
        return (java.math.BigDecimal) getValue("M_YakujoRisoku_Yakujo");
    }

    /**
     * 約定利息・約定を設定します。
     * @param M_YakujoRisoku_Yakujo 約定利息・約定
     */
    public void setM_YakujoRisoku_Yakujo(java.math.BigDecimal M_YakujoRisoku_Yakujo) {
        setValue("M_YakujoRisoku_Yakujo", M_YakujoRisoku_Yakujo);
    }

    /**
     * 請求繰上償還元金・請求を取得します。
     * @return 請求繰上償還元金・請求
     */
    public java.math.BigDecimal getM_SeiKuriGankin_Seikyu() {
        return (java.math.BigDecimal) getValue("M_SeiKuriGankin_Seikyu");
    }

    /**
     * 請求繰上償還元金・請求を設定します。
     * @param M_SeiKuriGankin_Seikyu 請求繰上償還元金・請求
     */
    public void setM_SeiKuriGankin_Seikyu(java.math.BigDecimal M_SeiKuriGankin_Seikyu) {
        setValue("M_SeiKuriGankin_Seikyu", M_SeiKuriGankin_Seikyu);
    }

    /**
     * 請求繰上償還利息・請求を取得します。
     * @return 請求繰上償還利息・請求
     */
    public java.math.BigDecimal getM_SeiKuriRisoku_Seikyu() {
        return (java.math.BigDecimal) getValue("M_SeiKuriRisoku_Seikyu");
    }

    /**
     * 請求繰上償還利息・請求を設定します。
     * @param M_SeiKuriRisoku_Seikyu 請求繰上償還利息・請求
     */
    public void setM_SeiKuriRisoku_Seikyu(java.math.BigDecimal M_SeiKuriRisoku_Seikyu) {
        setValue("M_SeiKuriRisoku_Seikyu", M_SeiKuriRisoku_Seikyu);
    }

    /**
     * 任意繰上償還利息・約定を取得します。
     * @return 任意繰上償還利息・約定
     */
    public java.math.BigDecimal getM_NinKuriRisoku_Yakujo() {
        return (java.math.BigDecimal) getValue("M_NinKuriRisoku_Yakujo");
    }

    /**
     * 任意繰上償還利息・約定を設定します。
     * @param M_NinKuriRisoku_Yakujo 任意繰上償還利息・約定
     */
    public void setM_NinKuriRisoku_Yakujo(java.math.BigDecimal M_NinKuriRisoku_Yakujo) {
        setValue("M_NinKuriRisoku_Yakujo", M_NinKuriRisoku_Yakujo);
    }

    /**
     * 任意繰上償還元金計・入金を取得します。
     * @return 任意繰上償還元金計・入金
     */
    public java.math.BigDecimal getM_NinKuriGankinKei_Nyukin() {
        return (java.math.BigDecimal) getValue("M_NinKuriGankinKei_Nyukin");
    }

    /**
     * 任意繰上償還元金計・入金を設定します。
     * @param M_NinKuriGankinKei_Nyukin 任意繰上償還元金計・入金
     */
    public void setM_NinKuriGankinKei_Nyukin(java.math.BigDecimal M_NinKuriGankinKei_Nyukin) {
        setValue("M_NinKuriGankinKei_Nyukin", M_NinKuriGankinKei_Nyukin);
    }

    /**
     * 任意繰上償還利息計・入金を取得します。
     * @return 任意繰上償還利息計・入金
     */
    public java.math.BigDecimal getM_NinKuriRisokuKei_Nyukin() {
        return (java.math.BigDecimal) getValue("M_NinKuriRisokuKei_Nyukin");
    }

    /**
     * 任意繰上償還利息計・入金を設定します。
     * @param M_NinKuriRisokuKei_Nyukin 任意繰上償還利息計・入金
     */
    public void setM_NinKuriRisokuKei_Nyukin(java.math.BigDecimal M_NinKuriRisokuKei_Nyukin) {
        setValue("M_NinKuriRisokuKei_Nyukin", M_NinKuriRisokuKei_Nyukin);
    }

    /**
     * 条変起案中区分を取得します。
     * @return 条変起案中区分
     */
    public String getKubun_JohenKianchu() {
        return (String) getValue("Kubun_JohenKianchu");
    }

    /**
     * 条変起案中区分を設定します。
     * @param Kubun_JohenKianchu 条変起案中区分
     */
    public void setKubun_JohenKianchu(String Kubun_JohenKianchu) {
        setValue("Kubun_JohenKianchu", Kubun_JohenKianchu);
    }

    /**
     * 最新変更年月日を取得します。
     * @return 最新変更年月日
     */
    public String getDate_SaishinHenko() {
        return (String) getValue("Date_SaishinHenko");
    }

    /**
     * 最新変更年月日を設定します。
     * @param Date_SaishinHenko 最新変更年月日
     */
    public void setDate_SaishinHenko(String Date_SaishinHenko) {
        setValue("Date_SaishinHenko", Date_SaishinHenko);
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

}