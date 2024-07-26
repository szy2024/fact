//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe003_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店コード入力値 */
    private String Se003_02Code_ShokanHonShiten;
    /** 扱店コード入力値 */
    private String Se003_02Code_Organization;
    /** 店舗コード入力値 */
    private String Se003_02Code_Tenpo;
    /** 年度入力値 */
    private String Se003_02Year;
    /** 方式資金入力値 */
    private String Se003_02Kubun_Hoshiki;
    /** 番号入力値 */
    private String Se003_02ID_Ringi;
    /** 枝番入力値 */
    private String Se003_02ID_RingiBranch;
    /** 公庫支店名 */
    private String ID_ID_Name_KoukoShiten;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Kubun_Hoshiki;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 貸付金額 */
    private java.math.BigDecimal ID_M_Kashitsuke;
    /** 資金使途名 */
    private String ID_Name_ShikinShito;
    /** 繰償手数料 */
    private String ID_Kubun_KurishoTesuryo;
    /** 金利制度の選択 */
    private String ID_Kubun_KinriSeidoSentaku;
    /** 利率 */
    private String ID_Riritsu;
    /** 特利コード */
    private String ID_Kubun_Tokuri;
    /** 特利 */
    private String ID_Tokuri;
    /** 指標率 */
    private String ID_Shihyoritsu;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 償還方法コード */
    private String ID_Code_ShokanHouhou;
    /** 元金不均等額区分 */
    private String ID_Kubun_GankinFukintogaku;
    /** 元利又は元金均等額 */
    private java.math.BigDecimal ID_M_Fukin;
    /** 元金不均等額 */
    private java.math.BigDecimal ID_M_GankinFukinto;
    /** 貸付決定日 */
    private String ID_Date_KetteiKisan;
    /** 貸付実行日 */
    private String ID_Date_Jikko;
    /** 貸付実行額 */
    private java.math.BigDecimal ID_M_KashitsukeJikko;
    /** 貸付金現在残高 */
    private java.math.BigDecimal ID_M_KashitsukeZandaka;
    /** 払出情報 */
    private java.util.List<Se003_02M1DTO> MEISAI_HaraidashiLIST = new java.util.ArrayList<Se003_02M1DTO>(0);
    /** 払込情報 */
    private java.util.List<Se003_02M2DTO> MEISAI_HaraikomiLIST = new java.util.ArrayList<Se003_02M2DTO>(0);
    /** メッセージ */
    private String lblError;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se003_02DTO() {
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
    public Se003_02DTO(Se003_02DTO orig) {
        super(orig);
    }

    /**
     * 公庫支店コード入力値を取得します。
     * @return 公庫支店コード入力値
     */
    public String getSe003_02Code_ShokanHonShiten() {
        return Se003_02Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コード入力値を設定します。
     * @param Se003_02Code_ShokanHonShiten 公庫支店コード入力値
     */
    public void setSe003_02Code_ShokanHonShiten(String Se003_02Code_ShokanHonShiten) {
        this.Se003_02Code_ShokanHonShiten = Se003_02Code_ShokanHonShiten;
    }

    /**
     * 扱店コード入力値を取得します。
     * @return 扱店コード入力値
     */
    public String getSe003_02Code_Organization() {
        return Se003_02Code_Organization;
    }

    /**
     * 扱店コード入力値を設定します。
     * @param Se003_02Code_Organization 扱店コード入力値
     */
    public void setSe003_02Code_Organization(String Se003_02Code_Organization) {
        this.Se003_02Code_Organization = Se003_02Code_Organization;
    }

    /**
     * 店舗コード入力値を取得します。
     * @return 店舗コード入力値
     */
    public String getSe003_02Code_Tenpo() {
        return Se003_02Code_Tenpo;
    }

    /**
     * 店舗コード入力値を設定します。
     * @param Se003_02Code_Tenpo 店舗コード入力値
     */
    public void setSe003_02Code_Tenpo(String Se003_02Code_Tenpo) {
        this.Se003_02Code_Tenpo = Se003_02Code_Tenpo;
    }

    /**
     * 年度入力値を取得します。
     * @return 年度入力値
     */
    public String getSe003_02Year() {
        return Se003_02Year;
    }

    /**
     * 年度入力値を設定します。
     * @param Se003_02Year 年度入力値
     */
    public void setSe003_02Year(String Se003_02Year) {
        this.Se003_02Year = Se003_02Year;
    }

    /**
     * 方式資金入力値を取得します。
     * @return 方式資金入力値
     */
    public String getSe003_02Kubun_Hoshiki() {
        return Se003_02Kubun_Hoshiki;
    }

    /**
     * 方式資金入力値を設定します。
     * @param Se003_02Kubun_Hoshiki 方式資金入力値
     */
    public void setSe003_02Kubun_Hoshiki(String Se003_02Kubun_Hoshiki) {
        this.Se003_02Kubun_Hoshiki = Se003_02Kubun_Hoshiki;
    }

    /**
     * 番号入力値を取得します。
     * @return 番号入力値
     */
    public String getSe003_02ID_Ringi() {
        return Se003_02ID_Ringi;
    }

    /**
     * 番号入力値を設定します。
     * @param Se003_02ID_Ringi 番号入力値
     */
    public void setSe003_02ID_Ringi(String Se003_02ID_Ringi) {
        this.Se003_02ID_Ringi = Se003_02ID_Ringi;
    }

    /**
     * 枝番入力値を取得します。
     * @return 枝番入力値
     */
    public String getSe003_02ID_RingiBranch() {
        return Se003_02ID_RingiBranch;
    }

    /**
     * 枝番入力値を設定します。
     * @param Se003_02ID_RingiBranch 枝番入力値
     */
    public void setSe003_02ID_RingiBranch(String Se003_02ID_RingiBranch) {
        this.Se003_02ID_RingiBranch = Se003_02ID_RingiBranch;
    }

    /**
     * 公庫支店名を取得します。
     * @return 公庫支店名
     */
    public String getID_ID_Name_KoukoShiten() {
        return ID_ID_Name_KoukoShiten;
    }

    /**
     * 公庫支店名を設定します。
     * @param ID_ID_Name_KoukoShiten 公庫支店名
     */
    public void setID_ID_Name_KoukoShiten(String ID_ID_Name_KoukoShiten) {
        this.ID_ID_Name_KoukoShiten = ID_ID_Name_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getID_Kubun_Hoshiki() {
        return ID_Kubun_Hoshiki;
    }

    /**
     * 方式資金を設定します。
     * @param ID_Kubun_Hoshiki 方式資金
     */
    public void setID_Kubun_Hoshiki(String ID_Kubun_Hoshiki) {
        this.ID_Kubun_Hoshiki = ID_Kubun_Hoshiki;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 貸付金額を取得します。
     * @return 貸付金額
     */
    public java.math.BigDecimal getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付金額を設定します。
     * @param ID_M_Kashitsuke 貸付金額
     */
    public void setID_M_Kashitsuke(java.math.BigDecimal ID_M_Kashitsuke) {
        this.ID_M_Kashitsuke = ID_M_Kashitsuke;
    }

    /**
     * 資金使途名を取得します。
     * @return 資金使途名
     */
    public String getID_Name_ShikinShito() {
        return ID_Name_ShikinShito;
    }

    /**
     * 資金使途名を設定します。
     * @param ID_Name_ShikinShito 資金使途名
     */
    public void setID_Name_ShikinShito(String ID_Name_ShikinShito) {
        this.ID_Name_ShikinShito = ID_Name_ShikinShito;
    }

    /**
     * 繰償手数料を取得します。
     * @return 繰償手数料
     */
    public String getID_Kubun_KurishoTesuryo() {
        return ID_Kubun_KurishoTesuryo;
    }

    /**
     * 繰償手数料を設定します。
     * @param ID_Kubun_KurishoTesuryo 繰償手数料
     */
    public void setID_Kubun_KurishoTesuryo(String ID_Kubun_KurishoTesuryo) {
        this.ID_Kubun_KurishoTesuryo = ID_Kubun_KurishoTesuryo;
    }

    /**
     * 金利制度の選択を取得します。
     * @return 金利制度の選択
     */
    public String getID_Kubun_KinriSeidoSentaku() {
        return ID_Kubun_KinriSeidoSentaku;
    }

    /**
     * 金利制度の選択を設定します。
     * @param ID_Kubun_KinriSeidoSentaku 金利制度の選択
     */
    public void setID_Kubun_KinriSeidoSentaku(String ID_Kubun_KinriSeidoSentaku) {
        this.ID_Kubun_KinriSeidoSentaku = ID_Kubun_KinriSeidoSentaku;
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率を設定します。
     * @param ID_Riritsu 利率
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
    }

    /**
     * 特利コードを取得します。
     * @return 特利コード
     */
    public String getID_Kubun_Tokuri() {
        return ID_Kubun_Tokuri;
    }

    /**
     * 特利コードを設定します。
     * @param ID_Kubun_Tokuri 特利コード
     */
    public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
        this.ID_Kubun_Tokuri = ID_Kubun_Tokuri;
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利を設定します。
     * @param ID_Tokuri 特利
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 指標率を取得します。
     * @return 指標率
     */
    public String getID_Shihyoritsu() {
        return ID_Shihyoritsu;
    }

    /**
     * 指標率を設定します。
     * @param ID_Shihyoritsu 指標率
     */
    public void setID_Shihyoritsu(String ID_Shihyoritsu) {
        this.ID_Shihyoritsu = ID_Shihyoritsu;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen 据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen 償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 償還方法コードを取得します。
     * @return 償還方法コード
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 償還方法コードを設定します。
     * @param ID_Code_ShokanHouhou 償還方法コード
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 元金不均等額区分を取得します。
     * @return 元金不均等額区分
     */
    public String getID_Kubun_GankinFukintogaku() {
        return ID_Kubun_GankinFukintogaku;
    }

    /**
     * 元金不均等額区分を設定します。
     * @param ID_Kubun_GankinFukintogaku 元金不均等額区分
     */
    public void setID_Kubun_GankinFukintogaku(String ID_Kubun_GankinFukintogaku) {
        this.ID_Kubun_GankinFukintogaku = ID_Kubun_GankinFukintogaku;
    }

    /**
     * 元利又は元金均等額を取得します。
     * @return 元利又は元金均等額
     */
    public java.math.BigDecimal getID_M_Fukin() {
        return ID_M_Fukin;
    }

    /**
     * 元利又は元金均等額を設定します。
     * @param ID_M_Fukin 元利又は元金均等額
     */
    public void setID_M_Fukin(java.math.BigDecimal ID_M_Fukin) {
        this.ID_M_Fukin = ID_M_Fukin;
    }

    /**
     * 元金不均等額を取得します。
     * @return 元金不均等額
     */
    public java.math.BigDecimal getID_M_GankinFukinto() {
        return ID_M_GankinFukinto;
    }

    /**
     * 元金不均等額を設定します。
     * @param ID_M_GankinFukinto 元金不均等額
     */
    public void setID_M_GankinFukinto(java.math.BigDecimal ID_M_GankinFukinto) {
        this.ID_M_GankinFukinto = ID_M_GankinFukinto;
    }

    /**
     * 貸付決定日を取得します。
     * @return 貸付決定日
     */
    public String getID_Date_KetteiKisan() {
        return ID_Date_KetteiKisan;
    }

    /**
     * 貸付決定日を設定します。
     * @param ID_Date_KetteiKisan 貸付決定日
     */
    public void setID_Date_KetteiKisan(String ID_Date_KetteiKisan) {
        this.ID_Date_KetteiKisan = ID_Date_KetteiKisan;
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Jikko 貸付実行日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 貸付実行額を取得します。
     * @return 貸付実行額
     */
    public java.math.BigDecimal getID_M_KashitsukeJikko() {
        return ID_M_KashitsukeJikko;
    }

    /**
     * 貸付実行額を設定します。
     * @param ID_M_KashitsukeJikko 貸付実行額
     */
    public void setID_M_KashitsukeJikko(java.math.BigDecimal ID_M_KashitsukeJikko) {
        this.ID_M_KashitsukeJikko = ID_M_KashitsukeJikko;
    }

    /**
     * 貸付金現在残高を取得します。
     * @return 貸付金現在残高
     */
    public java.math.BigDecimal getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 貸付金現在残高を設定します。
     * @param ID_M_KashitsukeZandaka 貸付金現在残高
     */
    public void setID_M_KashitsukeZandaka(java.math.BigDecimal ID_M_KashitsukeZandaka) {
        this.ID_M_KashitsukeZandaka = ID_M_KashitsukeZandaka;
    }

    /**
     * 払出情報を取得します。
     * @return 払出情報
     */
    public java.util.List<Se003_02M1DTO> getMEISAI_HaraidashiLIST() {
        return MEISAI_HaraidashiLIST;
    }

    /**
     * 払出情報を設定します。
     * @param MEISAI_HaraidashiLIST 払出情報
     */
    public void setMEISAI_HaraidashiLIST(java.util.List<Se003_02M1DTO> MEISAI_HaraidashiLIST) {
        this.MEISAI_HaraidashiLIST = MEISAI_HaraidashiLIST;
    }

    /**
     * 払込情報を取得します。
     * @return 払込情報
     */
    public java.util.List<Se003_02M2DTO> getMEISAI_HaraikomiLIST() {
        return MEISAI_HaraikomiLIST;
    }

    /**
     * 払込情報を設定します。
     * @param MEISAI_HaraikomiLIST 払込情報
     */
    public void setMEISAI_HaraikomiLIST(java.util.List<Se003_02M2DTO> MEISAI_HaraikomiLIST) {
        this.MEISAI_HaraikomiLIST = MEISAI_HaraikomiLIST;
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * メッセージを設定します。
     * @param lblError メッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

}