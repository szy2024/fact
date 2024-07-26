//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.service;

import java.util.Date;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;
import jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiEntity;

/**
 * <pre>
 * このクラスはSe010_02のDTOクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 扱店コード */
    private String drpID_Code_ShokanHonShiten;
    /** 公庫支店コード */
    private String txtID_Code_Organization;
    /** 店舗コード */
    private String txtID_Code_Tenpo;
    /** 年度 */
    private String txtID_Year;
    /** 方式資金 */
    private String txtID_HoshikiShikin;
    /** 番号 */
    private String txtID_ID_Ringi;
    /** 枝番 */
    private String txtID_ID_RingiBranch;
    /** 繰上償還日(元号) */
    private String drpID_Date_KuriageShokan_Wareki;
    /** 繰上償還日(年) */
    private String txtID_Date_KuriageShokan_Year;
    /** 繰上償還日(月) */
    private String drpID_Date_KuriageShokan_Month;
    /** 繰上償還日(日) */
    private String drpID_Date_KuriageShokan_Date;
    /** 繰上償還額 */
    private String txtID_M_KuriageShokan;
    /** 繰償後第一回払込期日(元号) */
    private String drpID_Date_FirstHaraikomiAfterKuriS_Wareki;
    /** 繰償後第一回払込期日(年) */
    private String txtID_Date_FirstHaraikomiAfterKuriS_Year;
    /** 繰償後第一回払込期日(月) */
    private String drpID_Date_FirstHaraikomiAfterKuriS_Month;
    /** 繰償後第一回払込期日(日) */
    private String drpID_Date_FirstHaraikomiAfterKuriS_Date;
    /** 手数料計算 */
    private String radioID_TesuryoKeisan;
    /** 繰償時利率 */
    private String txtID_KurishojiRiritsu;
    /** 繰償事由コード */
    private String drpID_Code_KurishoJiyu;
    /** 元金均等額 */
    private String txtID_M_Gankinkinto;
    /** 元金不均等額 */
    private String txtID_M_Gankinfukinto;
    /** 調整コード */
    private String radioID_Code_Chosei;
    /** 免除対象額 */
    private String txtID_M_MenjoTaisho;
    /** 免除後元金均等額 */
    private String txtID_M_MenjogoGankinkinto;
    /** 免除後元金不均等額 */
    private String txtID_M_MenjogoGankinfukinto;
    /** 免除後調整コード */
    private String radioID_Code_Chosei_Menjogo;
    /** 繰上償還利息 */
    private String ID_strKurishoRisoku;
    /** 繰上償還手数料 */
    private String ID_strKurishoTesuryo;

    /** エラーメッセージID */
    private String ID_Error;

    /** 約定日 */
    private String yakujobi = null;
    /** 約定元金 */
    private long yakujogankin = 0;
    /** 約定利息 */
    private long yakujorisoku = 0;
    /** 約定前残高 */
    private long yakujozandaka = 0;

    /** 稟議データ */
    private java.util.List<Se010_02aRingiEntity> aRingList = new java.util.ArrayList<Se010_02aRingiEntity>();
    /** 起算日 */
    private Date kisanbi;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se010_02DTO() {
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
    public Se010_02DTO(Se010_02DTO orig) {
        super(orig);
    }

    /**
     * 扱店コードを取得します。
     *
     * @return 扱店コード
     */
    public String getDrpID_Code_ShokanHonShiten() {
        return drpID_Code_ShokanHonShiten;
    }

    /**
     * 扱店コードを設定します。
     *
     * @param drpID_Code_ShokanHonShiten 扱店コード
     */
    public void setDrpID_Code_ShokanHonShiten(String drpID_Code_ShokanHonShiten) {
        this.drpID_Code_ShokanHonShiten = drpID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コードを取得します。
     *
     * @return 公庫支店コード
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 公庫支店コードを設定します。
     *
     * @param txtID_Code_Organization 公庫支店コード
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     *
     * @return 店舗コード
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     *
     * @param txtID_Code_Tenpo 店舗コード
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度を設定します。
     *
     * @param txtID_Year 年度
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金を取得します。
     *
     * @return 方式資金
     */
    public String getTxtID_HoshikiShikin() {
        return txtID_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     *
     * @param txtID_HoshikiShikin 方式資金
     */
    public void setTxtID_HoshikiShikin(String txtID_HoshikiShikin) {
        this.txtID_HoshikiShikin = txtID_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     *
     * @return 番号
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     *
     * @param txtID_ID_Ringi 番号
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     *
     * @param txtID_ID_RingiBranch 枝番
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * 繰上償還日(元号)を取得します。
     *
     * @return 繰上償還日(元号)
     */
    public String getDrpID_Date_KuriageShokan_Wareki() {
        return drpID_Date_KuriageShokan_Wareki;
    }

    /**
     * 繰上償還日(元号)を設定します。
     *
     * @param drpID_Date_KuriageShokan_Wareki 繰上償還日(元号)
     */
    public void setDrpID_Date_KuriageShokan_Wareki(String drpID_Date_KuriageShokan_Wareki) {
        this.drpID_Date_KuriageShokan_Wareki = drpID_Date_KuriageShokan_Wareki;
    }

    /**
     * 繰上償還日(年)を取得します。
     *
     * @return 繰上償還日(年)
     */
    public String getTxtID_Date_KuriageShokan_Year() {
        return txtID_Date_KuriageShokan_Year;
    }

    /**
     * 繰上償還日(年)を設定します。
     *
     * @param txtID_Date_KuriageShokan_Year 繰上償還日(年)
     */
    public void setTxtID_Date_KuriageShokan_Year(String txtID_Date_KuriageShokan_Year) {
        this.txtID_Date_KuriageShokan_Year = txtID_Date_KuriageShokan_Year;
    }

    /**
     * 繰上償還日(月)を取得します。
     *
     * @return 繰上償還日(月)
     */
    public String getDrpID_Date_KuriageShokan_Month() {
        return drpID_Date_KuriageShokan_Month;
    }

    /**
     * 繰上償還日(月)を設定します。
     *
     * @param drpID_Date_KuriageShokan_Month 繰上償還日(月)
     */
    public void setDrpID_Date_KuriageShokan_Month(String drpID_Date_KuriageShokan_Month) {
        this.drpID_Date_KuriageShokan_Month = drpID_Date_KuriageShokan_Month;
    }

    /**
     * 繰上償還日(日)を取得します。
     *
     * @return 繰上償還日(日)
     */
    public String getDrpID_Date_KuriageShokan_Date() {
        return drpID_Date_KuriageShokan_Date;
    }

    /**
     * 繰上償還日(日)を設定します。
     *
     * @param drpID_Date_KuriageShokan_Date 繰上償還日(日)
     */
    public void setDrpID_Date_KuriageShokan_Date(String drpID_Date_KuriageShokan_Date) {
        this.drpID_Date_KuriageShokan_Date = drpID_Date_KuriageShokan_Date;
    }

    /**
     * 繰上償還額を取得します。
     *
     * @return 繰上償還額
     */
    public String getTxtID_M_KuriageShokan() {
        return txtID_M_KuriageShokan;
    }

    /**
     * 繰上償還額を設定します。
     *
     * @param txtID_M_KuriageShokan 繰上償還額
     */
    public void setTxtID_M_KuriageShokan(String txtID_M_KuriageShokan) {
        this.txtID_M_KuriageShokan = txtID_M_KuriageShokan;
    }

    /**
     * 繰償後第一回払込期日(元号)を取得します。
     *
     * @return 繰償後第一回払込期日(元号)
     */
    public String getDrpID_Date_FirstHaraikomiAfterKuriS_Wareki() {
        return drpID_Date_FirstHaraikomiAfterKuriS_Wareki;
    }

    /**
     * 繰償後第一回払込期日(元号)を設定します。
     *
     * @param drpID_Date_FirstHaraikomiAfterKuriS_Wareki 繰償後第一回払込期日(元号)
     */
    public void setDrpID_Date_FirstHaraikomiAfterKuriS_Wareki(
            String drpID_Date_FirstHaraikomiAfterKuriS_Wareki) {
        this.drpID_Date_FirstHaraikomiAfterKuriS_Wareki = drpID_Date_FirstHaraikomiAfterKuriS_Wareki;
    }

    /**
     * 繰償後第一回払込期日(年)を取得します。
     *
     * @return 繰償後第一回払込期日(年)
     */
    public String getTxtID_Date_FirstHaraikomiAfterKuriS_Year() {
        return txtID_Date_FirstHaraikomiAfterKuriS_Year;
    }

    /**
     * 繰償後第一回払込期日(年)を設定します。
     *
     * @param txtID_Date_FirstHaraikomiAfterKuriS_Year 繰償後第一回払込期日(年)
     */
    public void setTxtID_Date_FirstHaraikomiAfterKuriS_Year(String txtID_Date_FirstHaraikomiAfterKuriS_Year) {
        this.txtID_Date_FirstHaraikomiAfterKuriS_Year = txtID_Date_FirstHaraikomiAfterKuriS_Year;
    }

    /**
     * 繰償後第一回払込期日(月)を取得します。
     *
     * @return 繰償後第一回払込期日(月)
     */
    public String getDrpID_Date_FirstHaraikomiAfterKuriS_Month() {
        return drpID_Date_FirstHaraikomiAfterKuriS_Month;
    }

    /**
     * 繰償後第一回払込期日(月)を設定します。
     *
     * @param drpID_Date_FirstHaraikomiAfterKuriS_Month 繰償後第一回払込期日(月)
     */
    public void setDrpID_Date_FirstHaraikomiAfterKuriS_Month(String drpID_Date_FirstHaraikomiAfterKuriS_Month) {
        this.drpID_Date_FirstHaraikomiAfterKuriS_Month = drpID_Date_FirstHaraikomiAfterKuriS_Month;
    }

    /**
     * 繰償後第一回払込期日(日)を取得します。
     *
     * @return 繰償後第一回払込期日(日)
     */
    public String getDrpID_Date_FirstHaraikomiAfterKuriS_Date() {
        return drpID_Date_FirstHaraikomiAfterKuriS_Date;
    }

    /**
     * 繰償後第一回払込期日(日)を設定します。
     *
     * @param drpID_Date_FirstHaraikomiAfterKuriS_Date 繰償後第一回払込期日(日)
     */
    public void setDrpID_Date_FirstHaraikomiAfterKuriS_Date(String drpID_Date_FirstHaraikomiAfterKuriS_Date) {
        this.drpID_Date_FirstHaraikomiAfterKuriS_Date = drpID_Date_FirstHaraikomiAfterKuriS_Date;
    }

    /**
     * 手数料計算（あり）を取得します。
     *
     * @return 手数料計算（あり）
     */
    public String getRadioID_TesuryoKeisan() {
        return radioID_TesuryoKeisan;
    }

    /**
     * 手数料計算（あり）を設定します。
     *
     * @param radioID_TesuryoKeisan 手数料計算（あり）
     */
    public void setRadioID_TesuryoKeisan(String radioID_TesuryoKeisan) {
        this.radioID_TesuryoKeisan = radioID_TesuryoKeisan;
    }

    /**
     * 繰償時利率を取得します。
     *
     * @return 繰償時利率
     */
    public String getTxtID_KurishojiRiritsu() {
        return txtID_KurishojiRiritsu;
    }

    /**
     * 繰償時利率を設定します。
     *
     * @param KurishojiRiritsu 繰償時利率
     */
    public void setTxtID_KurishojiRiritsu(String txtID_KurishojiRiritsu) {
        this.txtID_KurishojiRiritsu = txtID_KurishojiRiritsu;
    }

    /**
     * 繰償事由コードを取得します。
     *
     * @return 繰償事由コード
     */
    public String getDrpID_Code_KurishoJiyu() {
        return drpID_Code_KurishoJiyu;
    }

    /**
     * 繰償事由コードを設定します。
     *
     * @param drpID_Code_KurishoJiyu 繰償事由コード
     */
    public void setDrpID_Code_KurishoJiyu(String drpID_Code_KurishoJiyu) {
        this.drpID_Code_KurishoJiyu = drpID_Code_KurishoJiyu;
    }

    /**
     * 元金均等額を取得します。
     *
     * @return 元金均等額
     */
    public String getTxtID_M_Gankinkinto() {
        return txtID_M_Gankinkinto;
    }

    /**
     * 元金均等額を設定します。
     *
     * @param txtID_M_Gankinkinto 元金均等額
     */
    public void setTxtID_M_Gankinkinto(String txtID_M_Gankinkinto) {
        this.txtID_M_Gankinkinto = txtID_M_Gankinkinto;
    }

    /**
     * 元金不均等額を取得します。
     *
     * @return 元金不均等額
     */
    public String getTxtID_M_Gankinfukinto() {
        return txtID_M_Gankinfukinto;
    }

    /**
     * 元金不均等額を設定します。
     *
     * @param txtID_M_Gankinfukinto 元金不均等額
     */
    public void setTxtID_M_Gankinfukinto(String txtID_M_Gankinfukinto) {
        this.txtID_M_Gankinfukinto = txtID_M_Gankinfukinto;
    }

    /**
     * 調整コード(初回)を取得します。
     *
     * @return 調整コード(初回)
     */
    public String getRadioID_Code_Chosei() {
        return radioID_Code_Chosei;
    }

    /**
     * 調整コード(初回)を設定します。
     *
     * @param radioID_Code_Chosei 調整コード(初回)
     */
    public void setRadioID_Code_Chosei(String radioID_Code_Chosei) {
        this.radioID_Code_Chosei = radioID_Code_Chosei;
    }

    /**
     * 免除対象額を取得します。
     *
     * @return 免除対象額
     */
    public String getTxtID_M_MenjoTaisho() {
        return txtID_M_MenjoTaisho;
    }

    /**
     * 免除対象額を設定します。
     *
     * @param txtID_M_MenjoTaisho 免除対象額
     */
    public void setTxtID_M_MenjoTaisho(String txtID_M_MenjoTaisho) {
        this.txtID_M_MenjoTaisho = txtID_M_MenjoTaisho;
    }

    /**
     * 免除後元金均等額を取得します。
     *
     * @return 免除後元金均等額
     */
    public String getTxtID_M_MenjogoGankinkinto() {
        return txtID_M_MenjogoGankinkinto;
    }

    /**
     * 免除後元金均等額を設定します。
     *
     * @param txtID_M_MenjogoGankinkinto 免除後元金均等額
     */
    public void setTxtID_M_MenjogoGankinkinto(String txtID_M_MenjogoGankinkinto) {
        this.txtID_M_MenjogoGankinkinto = txtID_M_MenjogoGankinkinto;
    }

    /**
     * 免除後元金不均等額を取得します。
     *
     * @return 免除後元金不均等額
     */
    public String getTxtID_M_MenjogoGankinfukinto() {
        return txtID_M_MenjogoGankinfukinto;
    }

    /**
     * 免除後元金不均等額を設定します。
     *
     * @param txtID_M_MenjogoGankinfukinto 免除後元金不均等額
     */
    public void setTxtID_M_MenjogoGankinfukinto(String txtID_M_MenjogoGankinfukinto) {
        this.txtID_M_MenjogoGankinfukinto = txtID_M_MenjogoGankinfukinto;
    }

    /**
     * 免除後調整コード(初回)を取得します。
     *
     * @return 免除後調整コード(初回)
     */
    public String getRadioID_Code_Chosei_Menjogo() {
        return radioID_Code_Chosei_Menjogo;
    }

    /**
     * 免除後調整コード(初回)を設定します。
     *
     * @param radioID_Code_Chosei_Menjogo 免除後調整コード(初回)
     */
    public void setRadioID_Code_Chosei_Menjogo(String radioID_Code_Chosei_Menjogo) {
        this.radioID_Code_Chosei_Menjogo = radioID_Code_Chosei_Menjogo;
    }

    /**
     * 繰上償還利息を取得します。
     *
     * @return 繰上償還利息
     */
    public String getID_strKurishoRisoku() {
        return ID_strKurishoRisoku;
    }

    /**
     * 繰上償還利息を設定します。
     *
     * @param ID_strKurishoRisoku 繰上償還利息
     */
    public void setID_strKurishoRisoku(String ID_strKurishoRisoku) {
        this.ID_strKurishoRisoku = ID_strKurishoRisoku;
    }

    /**
     * 繰上償還手数料を取得します。
     *
     * @return 繰上償還手数料
     */
    public String getID_strKurishoTesuryo() {
        return ID_strKurishoTesuryo;
    }

    /**
     * 繰上償還手数料を設定します。
     *
     * @param ID_strKurishoTesuryo 繰上償還手数料
     */
    public void setID_strKurishoTesuryo(String ID_strKurishoTesuryo) {
        this.ID_strKurishoTesuryo = ID_strKurishoTesuryo;
    }

    /**
     * 繰上償還日(YYYYMMDD)形式を取得します。
     */
    public String getStrDateKuriageShokan() {
        return PNCommonComponents.dateFmtJC_Gyy(this.getDrpID_Date_KuriageShokan_Wareki()
                + this.txtID_Date_KuriageShokan_Year)
                + String.format("%02d", Integer.parseInt(this.drpID_Date_KuriageShokan_Month))
                + String.format("%02d", Integer.parseInt(this.drpID_Date_KuriageShokan_Date));
    }

    /**
     * 繰償後第一回払込期日(YYYYMMDD)形式を取得します。
     */
    public String getStrDateFirstHaraikomiAfterKuriS() {
        return PNCommonComponents.dateFmtJC_Gyy(this.drpID_Date_FirstHaraikomiAfterKuriS_Wareki
                + this.txtID_Date_FirstHaraikomiAfterKuriS_Year)
                + String.format("%02d", Integer.parseInt(this.drpID_Date_FirstHaraikomiAfterKuriS_Month))
                + String.format("%02d", Integer.parseInt(this.drpID_Date_FirstHaraikomiAfterKuriS_Date));
    }

    /**
     * エラーメッセージIDを取得します。
     *
     * @return エラーメッセージID
     */
    public String getID_Error() {
        return ID_Error;
    }

    /**
     * エラーメッセージIDを設定します。
     *
     * @param ID_Error エラーメッセージID
     */
    public void setID_Error(String ID_Error) {
        this.ID_Error = ID_Error;
    }

    /**
     * 約定日を取得します。
     *
     * @return 約定日
     */
    public String getYakujobi() {
        return yakujobi;
    }

    /**
     * 約定日を設定します。
     *
     * @param yakujobi 約定日
     */
    public void setYakujobi(String yakujobi) {
        this.yakujobi = yakujobi;
    }

    /**
     * 約定元金を取得します。
     *
     * @return 約定元金
     */
    public long getYakujogankin() {
        return yakujogankin;
    }

    /**
     * 約定元金を設定します。
     *
     * @param yakujogankin 約定元金
     */
    public void setYakujogankin(long yakujogankin) {
        this.yakujogankin = yakujogankin;
    }

    /**
     * 約定利息を取得します。
     *
     * @return 約定利息
     */
    public long getYakujorisoku() {
        return yakujorisoku;
    }

    /**
     * 約定利息を設定します。
     *
     * @param yakujorisoku 約定利息
     */
    public void setYakujorisoku(long yakujorisoku) {
        this.yakujorisoku = yakujorisoku;
    }

    /**
     * 約定前残高を取得します。
     *
     * @return 約定前残高
     */
    public long getYakujozandaka() {
        return yakujozandaka;
    }

    /**
     * 約定前残高を設定します。
     *
     * @param yakujozandaka 約定前残高
     */
    public void setYakujozandaka(long yakujozandaka) {
        this.yakujozandaka = yakujozandaka;
    }

    /**
     * <pre>
     * 稟議データリストを取得します。
     * </pre>
     *
     * @return 稟議データリスト
     */
    public java.util.List<Se010_02aRingiEntity> getARingList() {
        return aRingList;
    }

    /**
     * <pre>
     * 稟議データリストを設定します。
     * </pre>
     *
     * @param aRingList 稟議データリスト
     */
    public void setARingList(java.util.List<Se010_02aRingiEntity> aRingList) {
        this.aRingList = aRingList;
    }

    /**
     * <pre>
     * 起算日を取得します。
     * </pre>
     *
     * @return 起算日
     */
    public Date getKisanbi() {
        return kisanbi;
    }

    /**
     * <pre>
     * 起算日を設定します。
     * </pre>
     *
     * @param kisanbi 起算日
     */
    public void setKisanbi(Date kisanbi) {
        this.kisanbi = kisanbi;
    }

}