//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md000_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.md000.md000_02.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはMd000_02のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md000_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 融資番号 */
    private String lblID_Yushi;
    /** 支店 */
    private String Code_ShokanHonShiten;
    /** 扱店 */
    private String Code_Organization;
    /** 店舗 */
    private String Code_Tenpo;
    /** 年度 */
    private String Year;
    /** 方式 */
    private String Kubun_Hoshiki;
    /** 資金 */
    private String Kubun_Shikin;
    /** 稟議番号 */
    private String ID_Ringi;
    /** 枝番 */
    private String ID_RingiBranch;
    /** データコード */
    private String ID_DataCode;
    /** 件数 */
    private int kensu;
    /** 検索タイプ */
    private String searchType;
    /** 明細リスト */
    private List<Md000_02M1DTO> MEISAI_LIST;
    /** 処理モード */
    private String processMode;
    /** リンクNo */
    private String link_No;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md000_02DTO() {
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
    public Md000_02DTO(Md000_02DTO orig) {
        super(orig);
    }

    /**
     * 融資番号を取得します。
     *
     * @return 融資番号
     */
    public String getLblID_Yushi() {
        return lblID_Yushi;
    }

    /**
     * 融資番号を設定します。
     *
     * @param lblID_Yushi 融資番号
     */
    public void setLblID_Yushi(String lblID_Yushi) {
        this.lblID_Yushi = lblID_Yushi;
    }

    /**
     * 支店を取得します。
     *
     * @return 支店
     */
    public String getCode_ShokanHonShiten() {
        return Code_ShokanHonShiten;
    }

    /**
     * 支店を設定します。
     *
     * @param Code_ShokanHonShiten 支店
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        this.Code_ShokanHonShiten = Code_ShokanHonShiten;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getCode_Organization() {
        return Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        this.Code_Organization = Code_Organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        this.Code_Tenpo = Code_Tenpo;
    }

    /**
     * 年度を取得します。
     *
     * @return 年度
     */
    public String getYear() {
        return Year;
    }

    /**
     * 年度を設定します。
     *
     * @param Year 年度
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     * 方式を取得します。
     *
     * @return 方式
     */
    public String getKubun_Hoshiki() {
        return Kubun_Hoshiki;
    }

    /**
     * 方式を設定します。
     *
     * @param Kubun_Hoshiki 方式
     */
    public void setKubun_Hoshiki(String Kubun_Hoshiki) {
        this.Kubun_Hoshiki = Kubun_Hoshiki;
    }

    /**
     * 資金を取得します。
     *
     * @return 資金
     */
    public String getKubun_Shikin() {
        return Kubun_Shikin;
    }

    /**
     * 資金を設定します。
     *
     * @param Kubun_Shikin 資金
     */
    public void setKubun_Shikin(String Kubun_Shikin) {
        this.Kubun_Shikin = Kubun_Shikin;
    }

    /**
     * 稟議番号を取得します。
     *
     * @return 稟議番号
     */
    public String getID_Ringi() {
        return ID_Ringi;
    }

    /**
     * 稟議番号を設定します。
     *
     * @param ID_Ringi 稟議番号
     */
    public void setID_Ringi(String ID_Ringi) {
        this.ID_Ringi = ID_Ringi;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public String getID_RingiBranch() {
        return ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     *
     * @param ID_RingiBranch 枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        this.ID_RingiBranch = ID_RingiBranch;
    }

    /**
     * データコードを取得します。
     * @return データコード
     */
    public String getID_DataCode() {
        return ID_DataCode;
    }

    /**
     * データコードを設定します。
     * @param DataDode データコード
     */
    public void setID_DataCode(String ID_DataCode) {
        this.ID_DataCode = ID_DataCode;
    }

    /**
     * 件数を取得します。
     *
     * @return 件数
     */
    public int getKensu() {
        return kensu;
    }

    /**
     * 件数を設定します。
     *
     * @param Kensu 件数
     */
    public void setKensu(int Kensu) {
        this.kensu = Kensu;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public List<Md000_02M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param MEISAI_LIST 明細リスト
     */
    public void setMEISAI_LIST(List<Md000_02M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }

    /**
     * 検索タイプを取得します。
     *
     * @return 検索タイプ
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * 検索タイプを設定します。
     *
     * @param SearchType 検索タイプ
     */
    public void setSearchType(String SearchType) {
        this.searchType = SearchType;
    }

    /**
     * 処理モードを取得します。
     *
     * @return 処理モード
     */
    public String getProcessMode() {
        return processMode;
    }

    /**
     * 処理モードを設定します。
     *
     * @param processMode 処理モード
     */
    public void setProcessMode(String processMode) {
        this.processMode = processMode;
    }

    /**
     * リンクNoを取得します。
     *
     * @return リンクNo
     */
    public String getLink_No() {
        return link_No;
    }

    /**
     * リンクNoを設定します。
     *
     * @param linkno リンクNo
     */
    public void setLink_No(String link_No) {
        this.link_No = link_No;
    }

}