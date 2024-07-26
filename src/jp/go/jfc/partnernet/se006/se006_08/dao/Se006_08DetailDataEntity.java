//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_08DetailDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_08.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_08DetailDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_08DetailDataEntity extends PNBaseEntity {
    
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
     * 仮受金からの充当を取得します。
     * @return 仮受金からの充当
     */
    public java.math.BigDecimal getM_KariukeIppanJuto() {
        return (java.math.BigDecimal) getValue("M_KariukeIppanJuto");
    }

    /**
     * 仮受金からの充当を設定します。
     * @param M_KariukeIppanJuto 仮受金からの充当
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
    public java.math.BigDecimal getM_ZanAfterKurisho() {
        return (java.math.BigDecimal) getValue("M_ZanAfterKurisho");
    }

    /**
     * 繰償後残元金を設定します。
     * @param M_ZanAfterKurisho 繰償後残元金
     */
    public void setM_ZanAfterKurisho(java.math.BigDecimal M_ZanAfterKurisho) {
        setValue("M_ZanAfterKurisho", M_ZanAfterKurisho);
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
     * 払込期日①を取得します。
     * @return 払込期日①
     */
    public String getDate_Haraikomi1() {
        return (String) getValue("Date_Haraikomi1");
    }

    /**
     * 払込期日①を設定します。
     * @param Date_Haraikomi1 払込期日①
     */
    public void setDate_Haraikomi1(String Date_Haraikomi1) {
        setValue("Date_Haraikomi1", Date_Haraikomi1);
    }

    /**
     * 払込元金①を取得します。
     * @return 払込元金①
     */
    public java.math.BigDecimal getM_HaraikomiGankin1() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin1");
    }

    /**
     * 払込元金①を設定します。
     * @param M_HaraikomiGankin1 払込元金①
     */
    public void setM_HaraikomiGankin1(java.math.BigDecimal M_HaraikomiGankin1) {
        setValue("M_HaraikomiGankin1", M_HaraikomiGankin1);
    }

    /**
     * 払込期日②を取得します。
     * @return 払込期日②
     */
    public String getDate_Haraikomi2() {
        return (String) getValue("Date_Haraikomi2");
    }

    /**
     * 払込期日②を設定します。
     * @param Date_Haraikomi2 払込期日②
     */
    public void setDate_Haraikomi2(String Date_Haraikomi2) {
        setValue("Date_Haraikomi2", Date_Haraikomi2);
    }

    /**
     * 払込元金②を取得します。
     * @return 払込元金②
     */
    public java.math.BigDecimal getM_HaraikomiGankin2() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin2");
    }

    /**
     * 払込元金②を設定します。
     * @param M_HaraikomiGankin2 払込元金②
     */
    public void setM_HaraikomiGankin2(java.math.BigDecimal M_HaraikomiGankin2) {
        setValue("M_HaraikomiGankin2", M_HaraikomiGankin2);
    }

    /**
     * 払込期日③を取得します。
     * @return 払込期日③
     */
    public String getDate_Haraikomi3() {
        return (String) getValue("Date_Haraikomi3");
    }

    /**
     * 払込期日③を設定します。
     * @param Date_Haraikomi3 払込期日③
     */
    public void setDate_Haraikomi3(String Date_Haraikomi3) {
        setValue("Date_Haraikomi3", Date_Haraikomi3);
    }

    /**
     * 払込元金③を取得します。
     * @return 払込元金③
     */
    public java.math.BigDecimal getM_HaraikomiGankin3() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin3");
    }

    /**
     * 払込元金③を設定します。
     * @param M_HaraikomiGankin3 払込元金③
     */
    public void setM_HaraikomiGankin3(java.math.BigDecimal M_HaraikomiGankin3) {
        setValue("M_HaraikomiGankin3", M_HaraikomiGankin3);
    }

    /**
     * 払込期日④を取得します。
     * @return 払込期日④
     */
    public String getDate_Haraikomi4() {
        return (String) getValue("Date_Haraikomi4");
    }

    /**
     * 払込期日④を設定します。
     * @param Date_Haraikomi4 払込期日④
     */
    public void setDate_Haraikomi4(String Date_Haraikomi4) {
        setValue("Date_Haraikomi4", Date_Haraikomi4);
    }

    /**
     * 払込元金④を取得します。
     * @return 払込元金④
     */
    public java.math.BigDecimal getM_HaraikomiGankin4() {
        return (java.math.BigDecimal) getValue("M_HaraikomiGankin4");
    }

    /**
     * 払込元金④を設定します。
     * @param M_HaraikomiGankin4 払込元金④
     */
    public void setM_HaraikomiGankin4(java.math.BigDecimal M_HaraikomiGankin4) {
        setValue("M_HaraikomiGankin4", M_HaraikomiGankin4);
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