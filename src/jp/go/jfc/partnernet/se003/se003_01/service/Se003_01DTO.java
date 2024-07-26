//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_01.service;

import java.util.LinkedHashMap;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe003_01のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店名プルダウンリスト */
    // private java.util.LinkedHashMap ShokanHonShitenLIST;
    private LinkedHashMap<String, Object> ShokanHonShitenLIST = new LinkedHashMap<String, Object>();
    /** 公庫支店コード */
    private String drpID_Code_ShokanHonShiten;
    /** 扱店コード */
    private String txtID_Code_Organization;
    /** 店舗コード */
    private String txtID_Code_Tenpo;
    /** 年度 */
    private String txtID_Year;
    /** 方式資金 */
    private String txtID_Kubun_Hoshiki;
    /** 番号 */
    private String txtID_ID_Ringi;
    /** 枝番 */
    private String txtID_ID_RingiBranch;
    /** エラーメッセージ */
    private String lblError;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se003_01DTO() {
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
    public Se003_01DTO(Se003_01DTO orig) {
        super(orig);
    }

    /**
     * 公庫支店名プルダウンリストを取得します。
     * @return 公庫支店名プルダウンリスト
     */
    public LinkedHashMap<String, Object> getShokanHonShitenLIST() {
        return ShokanHonShitenLIST;
    }

    /**
     * 公庫支店名プルダウンリストを設定します。
     * @param ShokanHonShitenLIST 公庫支店名プルダウンリスト
     */
    public void setShokanHonShitenLIST(LinkedHashMap<String, Object> ShokanHonShitenLIST) {
        this.ShokanHonShitenLIST = ShokanHonShitenLIST;
    }

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getDrpID_Code_ShokanHonShiten() {
        return drpID_Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コードを設定します。
     * @param drpID_Code_ShokanHonShiten 公庫支店コード
     */
    public void setDrpID_Code_ShokanHonShiten(String drpID_Code_ShokanHonShiten) {
        this.drpID_Code_ShokanHonShiten = drpID_Code_ShokanHonShiten;
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getTxtID_Code_Organization() {
        return txtID_Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param txtID_Code_Organization 扱店コード
     */
    public void setTxtID_Code_Organization(String txtID_Code_Organization) {
        this.txtID_Code_Organization = txtID_Code_Organization;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getTxtID_Code_Tenpo() {
        return txtID_Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param txtID_Code_Tenpo 店舗コード
     */
    public void setTxtID_Code_Tenpo(String txtID_Code_Tenpo) {
        this.txtID_Code_Tenpo = txtID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getTxtID_Year() {
        return txtID_Year;
    }

    /**
     * 年度を設定します。
     * @param txtID_Year 年度
     */
    public void setTxtID_Year(String txtID_Year) {
        this.txtID_Year = txtID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getTxtID_Kubun_Hoshiki() {
        return txtID_Kubun_Hoshiki;
    }

    /**
     * 方式資金を設定します。
     * @param txtID_Kubun_Hoshiki 方式資金
     */
    public void setTxtID_Kubun_Hoshiki(String txtID_Kubun_Hoshiki) {
        this.txtID_Kubun_Hoshiki = txtID_Kubun_Hoshiki;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getTxtID_ID_Ringi() {
        return txtID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param txtID_ID_Ringi 番号
     */
    public void setTxtID_ID_Ringi(String txtID_ID_Ringi) {
        this.txtID_ID_Ringi = txtID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getTxtID_ID_RingiBranch() {
        return txtID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param txtID_ID_RingiBranch 枝番
     */
    public void setTxtID_ID_RingiBranch(String txtID_ID_RingiBranch) {
        this.txtID_ID_RingiBranch = txtID_ID_RingiBranch;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーメッセージを設定します。
     * @param lblError エラーメッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

}