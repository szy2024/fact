//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_08DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_08.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe006_08のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_08DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージ */
    private String lblMessage;
    /** 報告書番号 */
    private String lblID_Report;
    /** 報告年月日 */
    private String lblDate_Report;
    /** 報告時分秒 */
    private String lblTime_Report;
    /** 顧客名 */
    private String lblID_Name_Customer;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 公庫支店 */
    private String lblID_Code_ShokanHonShiten;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 年度 */
    private String lblID_Year;
    /** 方式資金 */
    private String lblID_Code_HoshikiShikin;
    /** 番号 */
    private String lblID_ID_Ringi;
    /** 枝番 */
    private String lblID_ID_RingiBranch;
    /** 償還後第1回払込期日 */
    private String lblID_Date_FirstHaraikomiAfterKurisho;
    /** 入金日 */
    private String lblID_Date_Nyukin;
    /** 繰償事由コード */
    private String lblID_Code_Kurishojiyu;
    /** 利息(円) */
    private java.math.BigDecimal lblID_M_KurishoRisoku;
    /** 元金(円) */
    private java.math.BigDecimal lblID_M_KurishoGankin;
    /** 控除利息(円) */
    private java.math.BigDecimal lblID_M_KojoRisoku;
    /** 繰上償還手数料(円) */
    private java.math.BigDecimal lblID_M_KurishoCommision;
    /** 仮受金からの充当額(円) */
    private java.math.BigDecimal lblID_M_KariukeIppanJuto;
    /** 送金額(円) */
    private java.math.BigDecimal lblID_M_Sokin;
    /** 繰償後残元金(円) */
    private java.math.BigDecimal lblID_M_ZanGankinAfterKurisho;
    /** 受託者勘定処理年月 */
    private String lblID_Date_JtkShori;
    /** 送金日 */
    private String lblID_Date_Sokin;
    /** 送金日番号 */
    private String lblID_ID_Sokinbi;
    /** 代弁履行後の作成 */
    private String chkID_ID_After_Daiibensai;
    /** 払込期日１ */
    private String lblID_Date_Haraikomi1;
    /** 払込元金１ */
    private java.math.BigDecimal lblID_M_HaraikomiGankin1;
    /** 払込期日２ */
    private String lblID_Date_Haraikomi2;
    /** 払込元金２ */
    private java.math.BigDecimal lblID_M_HaraikomiGankin2;
    /** 払込期日３ */
    private String lblID_Date_Haraikomi3;
    /** 払込元金３ */
    private java.math.BigDecimal lblID_M_HaraikomiGankin3;
    /** 払込期日４ */
    private String lblID_Date_Haraikomi4;
    /** 払込元金４ */
    private java.math.BigDecimal lblID_M_HaraikomiGankin4;
    /** 繰償後元金均等額(円) */
    private java.math.BigDecimal lblID_M_GankinKintoAfterKurisho;
    /** 繰償後元金不均等額(円) */
    private java.math.BigDecimal lblID_M_GankinFukintoAfterKurisho;
    /** 調整コード */
    private String rdoID_Code_chosei;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_08DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Se006_08DTO(Se006_08DTO orig) {
        super(orig);
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }
    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }
    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblDate_Report() {
        return lblDate_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblDate_Report 報告年月日
     */
    public void setLblDate_Report(String lblDate_Report) {
        this.lblDate_Report = lblDate_Report;
    }
    /**
     * 報告時分秒を取得します。
     * @return 報告時分秒
     */
    public String getLblTime_Report() {
        return lblTime_Report;
    }

    /**
     * 報告時分秒を設定します。
     * @param lblTime_Report 報告時分秒
     */
    public void setLblTime_Report(String lblTime_Report) {
        this.lblTime_Report = lblTime_Report;
    }
    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getLblID_Name_Customer() {
        return lblID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * @param lblID_Name_Customer 顧客名
     */
    public void setLblID_Name_Customer(String lblID_Name_Customer) {
        this.lblID_Name_Customer = lblID_Name_Customer;
    }
    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }
    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getLblID_Code_ShokanHonShiten() {
        return lblID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店を設定します。
     * @param lblID_Code_ShokanHonShiten 公庫支店
     */
    public void setLblID_Code_ShokanHonShiten(String lblID_Code_ShokanHonShiten) {
        this.lblID_Code_ShokanHonShiten = lblID_Code_ShokanHonShiten;
    }
    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization 扱店
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }
    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo 店舗
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }
    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getLblID_Year() {
        return lblID_Year;
    }

    /**
     * 年度を設定します。
     * @param lblID_Year 年度
     */
    public void setLblID_Year(String lblID_Year) {
        this.lblID_Year = lblID_Year;
    }
    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getLblID_Code_HoshikiShikin() {
        return lblID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * @param lblID_Code_HoshikiShikin 方式資金
     */
    public void setLblID_Code_HoshikiShikin(String lblID_Code_HoshikiShikin) {
        this.lblID_Code_HoshikiShikin = lblID_Code_HoshikiShikin;
    }
    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getLblID_ID_Ringi() {
        return lblID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param lblID_ID_Ringi 番号
     */
    public void setLblID_ID_Ringi(String lblID_ID_Ringi) {
        this.lblID_ID_Ringi = lblID_ID_Ringi;
    }
    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getLblID_ID_RingiBranch() {
        return lblID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param lblID_ID_RingiBranch 枝番
     */
    public void setLblID_ID_RingiBranch(String lblID_ID_RingiBranch) {
        this.lblID_ID_RingiBranch = lblID_ID_RingiBranch;
    }
    /**
     * 償還後第1回払込期日を取得します。
     * @return 償還後第1回払込期日
     */
    public String getLblID_Date_FirstHaraikomiAfterKurisho() {
        return lblID_Date_FirstHaraikomiAfterKurisho;
    }

    /**
     * 償還後第1回払込期日を設定します。
     * @param lblID_Date_FirstHaraikomiAfterKurisho 償還後第1回払込期日
     */
    public void setLblID_Date_FirstHaraikomiAfterKurisho(String lblID_Date_FirstHaraikomiAfterKurisho) {
        this.lblID_Date_FirstHaraikomiAfterKurisho = lblID_Date_FirstHaraikomiAfterKurisho;
    }
    /**
     * 入金日を取得します。
     * @return 入金日
     */
    public String getLblID_Date_Nyukin() {
        return lblID_Date_Nyukin;
    }

    /**
     * 入金日を設定します。
     * @param lblID_Date_Nyukin 入金日
     */
    public void setLblID_Date_Nyukin(String lblID_Date_Nyukin) {
        this.lblID_Date_Nyukin = lblID_Date_Nyukin;
    }
    /**
     * 繰償事由コードを取得します。
     * @return 繰償事由コード
     */
    public String getLblID_Code_Kurishojiyu() {
        return lblID_Code_Kurishojiyu;
    }

    /**
     * 繰償事由コードを設定します。
     * @param lblID_Code_Kurishojiyu 繰償事由コード
     */
    public void setLblID_Code_Kurishojiyu(String lblID_Code_Kurishojiyu) {
        this.lblID_Code_Kurishojiyu = lblID_Code_Kurishojiyu;
    }
    /**
     * 利息(円)を取得します。
     * @return 利息(円)
     */
    public java.math.BigDecimal getLblID_M_KurishoRisoku() {
        return lblID_M_KurishoRisoku;
    }

    /**
     * 利息(円)を設定します。
     * @param lblID_M_KurishoRisoku 利息(円)
     */
    public void setLblID_M_KurishoRisoku(java.math.BigDecimal lblID_M_KurishoRisoku) {
        this.lblID_M_KurishoRisoku = lblID_M_KurishoRisoku;
    }
    /**
     * 元金(円)を取得します。
     * @return 元金(円)
     */
    public java.math.BigDecimal getLblID_M_KurishoGankin() {
        return lblID_M_KurishoGankin;
    }

    /**
     * 元金(円)を設定します。
     * @param lblID_M_KurishoGankin 元金(円)
     */
    public void setLblID_M_KurishoGankin(java.math.BigDecimal lblID_M_KurishoGankin) {
        this.lblID_M_KurishoGankin = lblID_M_KurishoGankin;
    }
    /**
     * 控除利息(円)を取得します。
     * @return 控除利息(円)
     */
    public java.math.BigDecimal getLblID_M_KojoRisoku() {
        return lblID_M_KojoRisoku;
    }

    /**
     * 控除利息(円)を設定します。
     * @param lblID_M_KojoRisoku 控除利息(円)
     */
    public void setLblID_M_KojoRisoku(java.math.BigDecimal lblID_M_KojoRisoku) {
        this.lblID_M_KojoRisoku = lblID_M_KojoRisoku;
    }
    /**
     * 繰上償還手数料(円)を取得します。
     * @return 繰上償還手数料(円)
     */
    public java.math.BigDecimal getLblID_M_KurishoCommision() {
        return lblID_M_KurishoCommision;
    }

    /**
     * 繰上償還手数料(円)を設定します。
     * @param lblID_M_KurishoCommision 繰上償還手数料(円)
     */
    public void setLblID_M_KurishoCommision(java.math.BigDecimal lblID_M_KurishoCommision) {
        this.lblID_M_KurishoCommision = lblID_M_KurishoCommision;
    }
    /**
     * 仮受金からの充当額(円)を取得します。
     * @return 仮受金からの充当額(円)
     */
    public java.math.BigDecimal getLblID_M_KariukeIppanJuto() {
        return lblID_M_KariukeIppanJuto;
    }

    /**
     * 仮受金からの充当額(円)を設定します。
     * @param lblID_M_KariukeIppanJuto 仮受金からの充当額(円)
     */
    public void setLblID_M_KariukeIppanJuto(java.math.BigDecimal lblID_M_KariukeIppanJuto) {
        this.lblID_M_KariukeIppanJuto = lblID_M_KariukeIppanJuto;
    }
    /**
     * 送金額(円)を取得します。
     * @return 送金額(円)
     */
    public java.math.BigDecimal getLblID_M_Sokin() {
        return lblID_M_Sokin;
    }

    /**
     * 送金額(円)を設定します。
     * @param lblID_M_Sokin 送金額(円)
     */
    public void setLblID_M_Sokin(java.math.BigDecimal lblID_M_Sokin) {
        this.lblID_M_Sokin = lblID_M_Sokin;
    }
    /**
     * 繰償後残元金(円)を取得します。
     * @return 繰償後残元金(円)
     */
    public java.math.BigDecimal getLblID_M_ZanGankinAfterKurisho() {
        return lblID_M_ZanGankinAfterKurisho;
    }

    /**
     * 繰償後残元金(円)を設定します。
     * @param lblID_M_ZanGankinAfterKurisho 繰償後残元金(円)
     */
    public void setLblID_M_ZanGankinAfterKurisho(java.math.BigDecimal lblID_M_ZanGankinAfterKurisho) {
        this.lblID_M_ZanGankinAfterKurisho = lblID_M_ZanGankinAfterKurisho;
    }
    /**
     * 受託者勘定処理年月を取得します。
     * @return 受託者勘定処理年月
     */
    public String getLblID_Date_JtkShori() {
        return lblID_Date_JtkShori;
    }

    /**
     * 受託者勘定処理年月を設定します。
     * @param lblID_Date_JtkShori 受託者勘定処理年月
     */
    public void setLblID_Date_JtkShori(String lblID_Date_JtkShori) {
        this.lblID_Date_JtkShori = lblID_Date_JtkShori;
    }
    /**
     * 送金日を取得します。
     * @return 送金日
     */
    public String getLblID_Date_Sokin() {
        return lblID_Date_Sokin;
    }

    /**
     * 送金日を設定します。
     * @param lblID_Date_Sokin 送金日
     */
    public void setLblID_Date_Sokin(String lblID_Date_Sokin) {
        this.lblID_Date_Sokin = lblID_Date_Sokin;
    }
    /**
     * 送金日番号を取得します。
     * @return 送金日番号
     */
    public String getLblID_ID_Sokinbi() {
        return lblID_ID_Sokinbi;
    }

    /**
     * 送金日番号を設定します。
     * @param lblID_ID_Sokinbi 送金日番号
     */
    public void setLblID_ID_Sokinbi(String lblID_ID_Sokinbi) {
        this.lblID_ID_Sokinbi = lblID_ID_Sokinbi;
    }
    /**
     * 代弁履行後の作成を取得します。
     * @return 代弁履行後の作成
     */
    public String getChkID_ID_After_Daiibensai() {
        return chkID_ID_After_Daiibensai;
    }

    /**
     * 代弁履行後の作成を設定します。
     * @param chkID_ID_After_Daiibensai 代弁履行後の作成
     */
    public void setChkID_ID_After_Daiibensai(String chkID_ID_After_Daiibensai) {
        this.chkID_ID_After_Daiibensai = chkID_ID_After_Daiibensai;
    }
    /**
     * 払込期日１を取得します。
     * @return 払込期日１
     */
    public String getLblID_Date_Haraikomi1() {
        return lblID_Date_Haraikomi1;
    }

    /**
     * 払込期日１を設定します。
     * @param lblID_Date_Haraikomi1 払込期日１
     */
    public void setLblID_Date_Haraikomi1(String lblID_Date_Haraikomi1) {
        this.lblID_Date_Haraikomi1 = lblID_Date_Haraikomi1;
    }
    /**
     * 払込元金１を取得します。
     * @return 払込元金１
     */
    public java.math.BigDecimal getLblID_M_HaraikomiGankin1() {
        return lblID_M_HaraikomiGankin1;
    }

    /**
     * 払込元金１を設定します。
     * @param lblID_M_HaraikomiGankin1 払込元金１
     */
    public void setLblID_M_HaraikomiGankin1(java.math.BigDecimal lblID_M_HaraikomiGankin1) {
        this.lblID_M_HaraikomiGankin1 = lblID_M_HaraikomiGankin1;
    }
    /**
     * 払込期日２を取得します。
     * @return 払込期日２
     */
    public String getLblID_Date_Haraikomi2() {
        return lblID_Date_Haraikomi2;
    }

    /**
     * 払込期日２を設定します。
     * @param lblID_Date_Haraikomi2 払込期日２
     */
    public void setLblID_Date_Haraikomi2(String lblID_Date_Haraikomi2) {
        this.lblID_Date_Haraikomi2 = lblID_Date_Haraikomi2;
    }
    /**
     * 払込元金２を取得します。
     * @return 払込元金２
     */
    public java.math.BigDecimal getLblID_M_HaraikomiGankin2() {
        return lblID_M_HaraikomiGankin2;
    }

    /**
     * 払込元金２を設定します。
     * @param lblID_M_HaraikomiGankin2 払込元金２
     */
    public void setLblID_M_HaraikomiGankin2(java.math.BigDecimal lblID_M_HaraikomiGankin2) {
        this.lblID_M_HaraikomiGankin2 = lblID_M_HaraikomiGankin2;
    }
    /**
     * 払込期日３を取得します。
     * @return 払込期日３
     */
    public String getLblID_Date_Haraikomi3() {
        return lblID_Date_Haraikomi3;
    }

    /**
     * 払込期日３を設定します。
     * @param lblID_Date_Haraikomi3 払込期日３
     */
    public void setLblID_Date_Haraikomi3(String lblID_Date_Haraikomi3) {
        this.lblID_Date_Haraikomi3 = lblID_Date_Haraikomi3;
    }
    /**
     * 払込元金３を取得します。
     * @return 払込元金３
     */
    public java.math.BigDecimal getLblID_M_HaraikomiGankin3() {
        return lblID_M_HaraikomiGankin3;
    }

    /**
     * 払込元金３を設定します。
     * @param lblID_M_HaraikomiGankin3 払込元金３
     */
    public void setLblID_M_HaraikomiGankin3(java.math.BigDecimal lblID_M_HaraikomiGankin3) {
        this.lblID_M_HaraikomiGankin3 = lblID_M_HaraikomiGankin3;
    }
    /**
     * 払込期日４を取得します。
     * @return 払込期日４
     */
    public String getLblID_Date_Haraikomi4() {
        return lblID_Date_Haraikomi4;
    }

    /**
     * 払込期日４を設定します。
     * @param lblID_Date_Haraikomi4 払込期日４
     */
    public void setLblID_Date_Haraikomi4(String lblID_Date_Haraikomi4) {
        this.lblID_Date_Haraikomi4 = lblID_Date_Haraikomi4;
    }
    /**
     * 払込元金４を取得します。
     * @return 払込元金４
     */
    public java.math.BigDecimal getLblID_M_HaraikomiGankin4() {
        return lblID_M_HaraikomiGankin4;
    }

    /**
     * 払込元金４を設定します。
     * @param lblID_M_HaraikomiGankin4 払込元金４
     */
    public void setLblID_M_HaraikomiGankin4(java.math.BigDecimal lblID_M_HaraikomiGankin4) {
        this.lblID_M_HaraikomiGankin4 = lblID_M_HaraikomiGankin4;
    }
    /**
     * 繰償後元金均等額(円)を取得します。
     * @return 繰償後元金均等額(円)
     */
    public java.math.BigDecimal getLblID_M_GankinKintoAfterKurisho() {
        return lblID_M_GankinKintoAfterKurisho;
    }

    /**
     * 繰償後元金均等額(円)を設定します。
     * @param lblID_M_GankinKintoAfterKurisho 繰償後元金均等額(円)
     */
    public void setLblID_M_GankinKintoAfterKurisho(java.math.BigDecimal lblID_M_GankinKintoAfterKurisho) {
        this.lblID_M_GankinKintoAfterKurisho = lblID_M_GankinKintoAfterKurisho;
    }
    /**
     * 繰償後元金不均等額(円)を取得します。
     * @return 繰償後元金不均等額(円)
     */
    public java.math.BigDecimal getLblID_M_GankinFukintoAfterKurisho() {
        return lblID_M_GankinFukintoAfterKurisho;
    }

    /**
     * 繰償後元金不均等額(円)を設定します。
     * @param lblID_M_GankinFukintoAfterKurisho 繰償後元金不均等額(円)
     */
    public void setLblID_M_GankinFukintoAfterKurisho(java.math.BigDecimal lblID_M_GankinFukintoAfterKurisho) {
        this.lblID_M_GankinFukintoAfterKurisho = lblID_M_GankinFukintoAfterKurisho;
    }
    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getRdoID_Code_chosei() {
        return rdoID_Code_chosei;
    }

    /**
     * 調整コードを設定します。
     * @param rdoID_Code_chosei 調整コード
     */
    public void setRdoID_Code_chosei(String rdoID_Code_chosei) {
        this.rdoID_Code_chosei = rdoID_Code_chosei;
    }

}