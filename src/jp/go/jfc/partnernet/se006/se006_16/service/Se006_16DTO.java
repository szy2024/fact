//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se006_16DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse006_16のDTOクラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
public class Se006_16DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 明細リスト */
    private List<Se006_16M1DTO> MEISAI_LIST = new ArrayList<Se006_16M1DTO>();
    /** データ取得件数 */
    private int dataCount;
    /** 報告書番号 */
    private String lblID_Report;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_16DTO() {
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
    public Se006_16DTO(Se006_16DTO orig) {
        super(orig);
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public java.util.List<Se006_16M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param meisai_List
     *            明細リスト
     */
    public void setMEISAI_LIST(java.util.List<Se006_16M1DTO> meisai_List) {
        MEISAI_LIST = meisai_List;
    }

    /**
     * データ取得件数を取得します。
     *
     * @return データ取得件数
     */
    public int getDataCount() {
        return dataCount;
    }

    /**
     * データ取得件数を設定します。
     *
     * @param dataCount
     *            データ取得件数
     */
    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }

}