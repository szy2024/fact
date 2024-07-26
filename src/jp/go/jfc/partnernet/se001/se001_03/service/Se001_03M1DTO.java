//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe001_03のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se001_03M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ステータス */
    private String lblStatus;
    /** 公庫支店名 */
    private String lblID_Name_KoukoShiten;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 年度 */
    private String lblID_Year;
    /** 方式資金 */
    private String lblID_Hoshiki_Shikin;
    /** 番号 */
    private String lblID_ID_Ringi;
    /** 枝番 */
    private String lblID_ID_RingiBranch;
    /** 実行日 */
    private String lblID_Date_Jikko;
    /** 貸付金額（円） */
    private String lblID_M_Kashitsuke;
    /** 資金使途名 */
    private String lblID_Name_ShikinShito;
    /** 繰償手数料 */
    private String lblID_Kubun_KurishoTesuryo;
    /** 金利制度 */
    private String lblID_Kubun_KinriSeidoSentaku;
    /** 利率（%） */
    private String lblID_Riritsu;
    /** 特利コード */
    private String lblID_Kubun_Tokuri;
    /** 特利（%） */
    private String lblID_Tokuri;
    /** 指標率 */
    private String lblID_Shihyoritsu;
    /** 据置期限 */
    private String lblID_Date_SueokiKigen;
    /** 償還期限 */
    private String lblID_Date_ShokanKigen;
    /** 払込日 */
    private String lblID_Date_GanrikinHaraiKomi;
    /** 償還方法 */
    private String lblID_Code_ShokanHouhou;
    /** 元利金又は元金均等額（円） */
    private String lblID_M_Fukin;
    /** 貸付金残高（円） */
    private String lblID_M_KashitsukeZandaka;
    /** 充当順序変更 */
    private String lblID_Kubun_JutoJunjoHenko;

    /** 延滞明細テーブル */
    private List<Se001_03M2DTO> Tbl_se001_03M2DTO;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se001_03M1DTO() {
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
    public Se001_03M1DTO(Se001_03M1DTO orig) {
        super(orig);
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblStatus() {
        return lblStatus;
    }

    /**
     * ステータスを設定します。
     * @param lblStatus ステータス
     */
    public void setLblStatus(String lblStatus) {
        this.lblStatus = lblStatus;
    }

    /**
     * 公庫支店名を取得します。
     * @return 公庫支店名
     */
    public String getLblID_Name_KoukoShiten() {
        return lblID_Name_KoukoShiten;
    }

    /**
     * 公庫支店名を設定します。
     * @param lblID_Name_KoukoShiten 公庫支店名
     */
    public void setLblID_Name_KoukoShiten(String lblID_Name_KoukoShiten) {
        this.lblID_Name_KoukoShiten = lblID_Name_KoukoShiten;
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
    public String getLblID_Hoshiki_Shikin() {
        return lblID_Hoshiki_Shikin;
    }

    /**
     * 方式資金を設定します。
     * @param string 方式資金
     */
    public void setLblID_Hoshiki_Shikin(String string) {
        this.lblID_Hoshiki_Shikin = string;
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
     * @param string 番号
     */
    public void setLblID_ID_Ringi(String string) {
        this.lblID_ID_Ringi = string;
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
     * @param string 枝番
     */
    public void setLblID_ID_RingiBranch(String string) {
        this.lblID_ID_RingiBranch = string;
    }

    /**
     * 実行日を取得します。
     * @return 実行日
     */
    public String getLblID_Date_Jikko() {
        return lblID_Date_Jikko;
    }

    /**
     * 実行日を設定します。
     * @param lblID_Date_Jikko 実行日
     */
    public void setLblID_Date_Jikko(String lblID_Date_Jikko) {
        this.lblID_Date_Jikko = lblID_Date_Jikko;
    }

    /**
     * 貸付金額（円）を取得します。
     * @return 貸付金額（円）
     */
    public String getLblID_M_Kashitsuke() {
        return lblID_M_Kashitsuke;
    }

    /**
     * 貸付金額（円）を設定します。
     * @param string 貸付金額（円）
     */
    public void setLblID_M_Kashitsuke(String string) {
        this.lblID_M_Kashitsuke = string;
    }

    /**
     * 資金使途名を取得します。
     * @return 資金使途名
     */
    public String getLblID_Name_ShikinShito() {
        return lblID_Name_ShikinShito;
    }

    /**
     * 資金使途名を設定します。
     * @param lblID_Name_ShikinShito 資金使途名
     */
    public void setLblID_Name_ShikinShito(String lblID_Name_ShikinShito) {
        this.lblID_Name_ShikinShito = lblID_Name_ShikinShito;
    }

    /**
     * 繰償手数料を取得します。
     * @return 繰償手数料
     */
    public String getLblID_Kubun_KurishoTesuryo() {
        return lblID_Kubun_KurishoTesuryo;
    }

    /**
     * 繰償手数料を設定します。
     * @param string 繰償手数料
     */
    public void setLblID_Kubun_KurishoTesuryo(String string) {
        this.lblID_Kubun_KurishoTesuryo = string;
    }

    /**
     * 金利制度を取得します。
     * @return 金利制度
     */
    public String getLblID_Kubun_KinriSeidoSentaku() {
        return lblID_Kubun_KinriSeidoSentaku;
    }

    /**
     * 金利制度を設定します。
     * @param lblID_Kubun_KinriSeidoSentaku 金利制度
     */
    public void setLblID_Kubun_KinriSeidoSentaku(String lblID_Kubun_KinriSeidoSentaku) {
        this.lblID_Kubun_KinriSeidoSentaku = lblID_Kubun_KinriSeidoSentaku;
    }

    /**
     * 利率（%）を取得します。
     * @return 利率（%）
     */
    public String getLblID_Riritsu() {
        return lblID_Riritsu;
    }

    /**
     * 利率（%）を設定します。
     * @param string 利率（%）
     */
    public void setLblID_Riritsu(String string) {
        this.lblID_Riritsu = string;
    }

    /**
     * 特利コードを取得します。
     * @return 特利コード
     */
    public String getLblID_Kubun_Tokuri() {
        return lblID_Kubun_Tokuri;
    }

    /**
     * 特利コードを設定します。
     * @param string 特利コード
     */
    public void setLblID_Kubun_Tokuri(String string) {
        this.lblID_Kubun_Tokuri = string;
    }

    /**
     * 特利（%）を取得します。
     * @return 特利（%）
     */
    public String getLblID_Tokuri() {
        return lblID_Tokuri;
    }

    /**
     * 特利（%）を設定します。
     * @param string 特利（%）
     */
    public void setLblID_Tokuri(String string) {
        this.lblID_Tokuri = string;
    }

    /**
     * 指標率を取得します。
     * @return 指標率
     */
    public String getLblID_Shihyoritsu() {
        return lblID_Shihyoritsu;
    }

    /**
     * 指標率を設定します。
     * @param string 指標率
     */
    public void setLblID_Shihyoritsu(String string) {
        this.lblID_Shihyoritsu = string;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getLblID_Date_SueokiKigen() {
        return lblID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     * @param lblID_Date_SueokiKigen 据置期限
     */
    public void setLblID_Date_SueokiKigen(String lblID_Date_SueokiKigen) {
        this.lblID_Date_SueokiKigen = lblID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getLblID_Date_ShokanKigen() {
        return lblID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     * @param lblID_Date_ShokanKigen 償還期限
     */
    public void setLblID_Date_ShokanKigen(String lblID_Date_ShokanKigen) {
        this.lblID_Date_ShokanKigen = lblID_Date_ShokanKigen;
    }

    /**
     * 払込日を取得します。
     * @return 払込日
     */
    public String getLblID_Date_GanrikinHaraiKomi() {
        return lblID_Date_GanrikinHaraiKomi;
    }

    /**
     * 払込日を設定します。
     * @param lblID_Date_GanrikinHaraiKomi 払込日
     */
    public void setLblID_Date_GanrikinHaraiKomi(String lblID_Date_GanrikinHaraiKomi) {
        this.lblID_Date_GanrikinHaraiKomi = lblID_Date_GanrikinHaraiKomi;
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getLblID_Code_ShokanHouhou() {
        return lblID_Code_ShokanHouhou;
    }

    /**
     * 償還方法を設定します。
     * @param lblID_Code_ShokanHouhou 償還方法
     */
    public void setLblID_Code_ShokanHouhou(String lblID_Code_ShokanHouhou) {
        this.lblID_Code_ShokanHouhou = lblID_Code_ShokanHouhou;
    }

    /**
     * 元利金又は元金均等額（円）を取得します。
     * @return 元利金又は元金均等額（円）
     */
    public String getLblID_M_Fukin() {
        return lblID_M_Fukin;
    }

    /**
     * 元利金又は元金均等額（円）を設定します。
     * @param string 元利金又は元金均等額（円）
     */
    public void setLblID_M_Fukin(String string) {
        this.lblID_M_Fukin = string;
    }

    /**
     * 貸付金残高（円）を取得します。
     * @return 貸付金残高（円）
     */
    public String getLblID_M_KashitsukeZandaka() {
        return lblID_M_KashitsukeZandaka;
    }

    /**
     * 貸付金残高（円）を設定します。
     * @param string 貸付金残高（円）
     */
    public void setLblID_M_KashitsukeZandaka(String string) {
        this.lblID_M_KashitsukeZandaka = string;
    }

    /**
     * 充当順序変更を取得します。
     * @return 充当順序変更
     */
    public String getLblID_Kubun_JutoJunjoHenko() {
        return lblID_Kubun_JutoJunjoHenko;
    }

    /**
     * 充当順序変更を設定します。
     * @param string 充当順序変更
     */
    public void setLblID_Kubun_JutoJunjoHenko(String string) {
        this.lblID_Kubun_JutoJunjoHenko = string;
    }

    /**
     * 延滞明細テーブル を取得します。
     * @return 延滞明細テーブル
     */
    public List<Se001_03M2DTO> getTable_se001_03M2DTO() {
        return Tbl_se001_03M2DTO;
    }

    /**
     * 延滞明細テーブル を設定します。
     * @param Tbl_se001_03M2DTO 延滞テーブル
     */
    public void setTbl_se001_03M2DTO(List<Se001_03M2DTO> Tbl_se001_03M2DTO) {
        this.Tbl_se001_03M2DTO = Tbl_se001_03M2DTO;
    }

}