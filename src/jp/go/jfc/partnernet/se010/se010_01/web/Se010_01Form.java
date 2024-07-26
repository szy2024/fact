//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

import java.util.LinkedHashMap;

/**
 * <pre>
 * このクラスはSe010_01のFormクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラーメッセージ */
    private String lblError;

    /** 公庫支店名プルダウンマップ */
    private LinkedHashMap<String, String> koukoShitenCodeNameMap;

    /** 繰償事由コードプルダウンマップ */
    private LinkedHashMap<String, String> kurishoJiyuCodeMap;

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
    private String radioID_Tesuryo;
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

    /**
     * エラーメッセージを取得します。
     *
     * @return エラーメッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーメッセージを設定します。
     *
     * @param lblError エラーメッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 公庫支店名プルダウンマップを取得します。
     *
     * @return 公庫支店名プルダウンマップ
     */
    public LinkedHashMap<String, String> getKoukoShitenCodeNameMap() {
        return koukoShitenCodeNameMap;
    }

    /**
     * 公庫支店名プルダウンマップを設定します。
     *
     * @param koukoShitenCodeNameMap 公庫支店名プルダウンマップ
     */
    public void setKoukoShitenCodeNameMap(LinkedHashMap<String, String> koukoShitenCodeNameMap) {
        this.koukoShitenCodeNameMap = koukoShitenCodeNameMap;
    }

    /**
     * 繰償事由コードプルダウンマップを取得します。
     *
     * @return 繰償事由コードプルダウンマップ
     */
    public LinkedHashMap<String, String> getKurishoJiyuCodeMap() {
        return kurishoJiyuCodeMap;
    }

    /**
     * 繰償事由コードプルダウンマップを設定します。
     *
     * @param koukoShitenCodeNameMap 繰償事由コードプルダウンマップ
     */
    public void setKurishoJiyuCodeMap(LinkedHashMap<String, String> kurishoJiyuCodeMap) {
        this.kurishoJiyuCodeMap = kurishoJiyuCodeMap;
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
     * 手数料計算を取得します。
     *
     * @return 手数料計算
     */
    public String getRadioID_Tesuryo() {
        return radioID_Tesuryo;
    }

    /**
     * 手数料計算を設定します。
     *
     * @param radioID_Tesuryo 手数料計算
     */
    public void setRadioID_Tesuryo(String radioID_Tesuryo) {
        this.radioID_Tesuryo = radioID_Tesuryo;
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
     * @param txtID_KurishojiRiritsu 繰償時利率
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
     * 調整コードを取得します。
     *
     * @return 調整コード
     */
    public String getRadioID_Code_Chosei() {
        return radioID_Code_Chosei;
    }

    /**
     * 調整コードを設定します。
     *
     * @param radioID_Code_Chosei 調整コード
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
     * 免除後調整コードを取得します。
     *
     * @return 免除後調整コード
     */
    public String getRadioID_Code_Chosei_Menjogo() {
        return radioID_Code_Chosei_Menjogo;
    }

    /**
     * 免除後調整コードを設定します。
     *
     * @param radioID_Code_Chosei_Menjogo 免除後調整コード
     */
    public void setRadioID_Code_Chosei_Menjogo(String radioID_Code_Chosei_Menjogo) {
        this.radioID_Code_Chosei_Menjogo = radioID_Code_Chosei_Menjogo;
    }
}