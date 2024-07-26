//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_02.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe004_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se004_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店コード入力値 */
    private String Se004_02Code_ShokanHonShiten;
    /** 扱店コード入力値 */
    private String Se004_02Code_Organization;
    /** 店舗コード入力値 */
    private String Se004_02Code_Tenpo;
    /** 年度入力値 */
    private String Se004_02Year;
    /** 方式資金入力値 */
    private String Se004_02Kubun_Hoshiki;
    /** 稟議番号入力値 */
    private String Se004_02ID_Ringi;
    /** 稟議番号枝番入力値 */
    private String Se004_02ID_RingiBranch;
    /** 払込情報 */
    private List<Se004_02M1DTO> MEISAI_HaraikomiLIST;
    /** エラーメッセージ */
    private String lblError;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se004_02DTO() {
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
    public Se004_02DTO(Se004_02DTO orig) {
        super(orig);
    }

    /**
     * 公庫支店コード入力値を取得します。
     * @return 公庫支店コード入力値
     */
    public String getSe004_02Code_ShokanHonShiten() {
        return Se004_02Code_ShokanHonShiten;
    }

    /**
     * 公庫支店コード入力値を設定します。
     * @param Se004_02Code_ShokanHonShiten 公庫支店コード入力値
     */
    public void setSe004_02Code_ShokanHonShiten(String Se004_02Code_ShokanHonShiten) {
        this.Se004_02Code_ShokanHonShiten = Se004_02Code_ShokanHonShiten;
    }

    /**
     * 扱店コード入力値を取得します。
     * @return 扱店コード入力値
     */
    public String getSe004_02Code_Organization() {
        return Se004_02Code_Organization;
    }

    /**
     * 扱店コード入力値を設定します。
     * @param Se004_02Code_Organization 扱店コード入力値
     */
    public void setSe004_02Code_Organization(String Se004_02Code_Organization) {
        this.Se004_02Code_Organization = Se004_02Code_Organization;
    }

    /**
     * 店舗コード入力値を取得します。
     * @return 店舗コード入力値
     */
    public String getSe004_02Code_Tenpo() {
        return Se004_02Code_Tenpo;
    }

    /**
     * 店舗コード入力値を設定します。
     * @param Se004_02Code_Tenpo 店舗コード入力値
     */
    public void setSe004_02Code_Tenpo(String Se004_02Code_Tenpo) {
        this.Se004_02Code_Tenpo = Se004_02Code_Tenpo;
    }

    /**
     * 年度入力値を取得します。
     * @return 年度入力値
     */
    public String getSe004_02Year() {
        return Se004_02Year;
    }

    /**
     * 年度入力値を設定します。
     * @param Se004_02Year 年度入力値
     */
    public void setSe004_02Year(String Se004_02Year) {
        this.Se004_02Year = Se004_02Year;
    }

    /**
     * 方式資金入力値を取得します。
     * @return 方式資金入力値
     */
    public String getSe004_02Kubun_Hoshiki() {
        return Se004_02Kubun_Hoshiki;
    }

    /**
     * 方式資金入力値を設定します。
     * @param Se004_02Kubun_Hoshiki 方式資金入力値
     */
    public void setSe004_02Kubun_Hoshiki(String Se004_02Kubun_Hoshiki) {
        this.Se004_02Kubun_Hoshiki = Se004_02Kubun_Hoshiki;
    }

    /**
     * 稟議番号入力値を取得します。
     * @return 稟議番号入力値
     */
    public String getSe004_02ID_Ringi() {
        return Se004_02ID_Ringi;
    }

    /**
     * 稟議番号入力値を設定します。
     * @param Se004_02ID_Ringi 稟議番号入力値
     */
    public void setSe004_02ID_Ringi(String Se004_02ID_Ringi) {
        this.Se004_02ID_Ringi = Se004_02ID_Ringi;
    }

    /**
     * 稟議番号枝番入力値を取得します。
     * @return 稟議番号枝番入力値
     */
    public String getSe004_02ID_RingiBranch() {
        return Se004_02ID_RingiBranch;
    }

    /**
     * 稟議番号枝番入力値を設定します。
     * @param Se004_02ID_RingiBranch 稟議番号枝番入力値
     */
    public void setSe004_02ID_RingiBranch(String Se004_02ID_RingiBranch) {
        this.Se004_02ID_RingiBranch = Se004_02ID_RingiBranch;
    }

    /**
     * 払込情報を取得します。
     * @return 払込情報
     */
    public List<Se004_02M1DTO> getMEISAI_HaraikomiLIST() {
        return MEISAI_HaraikomiLIST;
    }

    /**
     * 払込情報を設定します。
     * @param MEISAI_HaraikomiLIST 払込情報
     */
    public void setMEISAI_HaraikomiLIST(List<Se004_02M1DTO> MEISAI_HaraikomiLIST) {
        this.MEISAI_HaraikomiLIST = MEISAI_HaraikomiLIST;
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