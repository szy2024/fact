//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr006_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ステータス */
    private String lblError;
    /** 報告書件数 */
    private int ReportHitCount;
    /** 報告書リスト */
    private List<Cr006_01M1DTO> ReportList = new ArrayList<Cr006_01M1DTO>(0);
    /** 貸付先コード */
    private String ID_Code_Customer;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 公庫支店 */
    private String ID_Code_KoukoShiten;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Code_HoshikiShikin;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr006_01DTO() {
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
    public Cr006_01DTO(Cr006_01DTO orig) {
        super(orig);
    }

    /**
     * ステータスを取得します。
     * 
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * 
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 報告書件数を取得します。
     * 
     * @return 報告書件数
     */
    public int getReportHitCount() {
        return ReportHitCount;
    }

    /**
     * 報告書件数を設定します。
     * 
     * @param ReportHitCount 報告書件数
     */
    public void setReportHitCount(int ReportHitCount) {
        this.ReportHitCount = ReportHitCount;
    }

    /**
     * 報告書リストを取得します。
     * 
     * @return 報告書リスト
     */
    public List<Cr006_01M1DTO> getReportList() {
        return ReportList;
    }

    /**
     * 報告書リストを設定します。
     * 
     * @param ReportList 報告書リスト
     */
    public void setReportList(List<Cr006_01M1DTO> ReportList) {
        this.ReportList = ReportList;
    }

    /**
     * 貸付先コードを取得します。
     * 
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 貸付先コードを設定します。
     * 
     * @param ID_Code_Customer 貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
    }

    /**
     * 債権管理番号を取得します。
     *
     * @return 債権管理番号
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     *
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 公庫支店を取得します。
     *
     * @return 公庫支店
     */
    public String getID_Code_KoukoShiten() {
        return ID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     *
     * @param ID_Code_KoukoShiten 公庫支店
     */
    public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
        this.ID_Code_KoukoShiten = ID_Code_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * 
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * 
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * 
     * @return 方式資金
     */
    public String getID_Code_HoshikiShikin() {
        return ID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * 
     * @param ID_Code_HoshikiShikin 方式資金
     */
    public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
        this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * 
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * 
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * 
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * 
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }
}