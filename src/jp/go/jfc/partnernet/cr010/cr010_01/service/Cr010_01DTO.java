//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : cr010_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr010_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr010_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 交付依頼年月（年） */
    private String lblID_KofuIraiYear;
    /** 交付依頼年月（月） */
    private String lblID_KofuIraiMonth;
    /** 明細リスト */
    private java.util.List<Cr010_01M1DTO> MEISAI_LIST = new java.util.ArrayList<Cr010_01M1DTO>(6);

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr010_01DTO() {
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
    public Cr010_01DTO(Cr010_01DTO orig) {
        super(orig);
    }

    /**
     * 交付依頼年月（年）を取得します。
     * @return 交付依頼年月（年）
     */
    public String getLblID_KofuIraiYear() {
        return lblID_KofuIraiYear;
    }

    /**
     * 交付依頼年月（年）を設定します。
     * @param lblID_KofuIraiYear 交付依頼年月（年）
     */
    public void setLblID_KofuIraiYear(String lblID_KofuIraiYear) {
        this.lblID_KofuIraiYear = lblID_KofuIraiYear;
    }

    /**
     * 交付依頼年月（月）を取得します。
     * @return 交付依頼年月（月）
     */
    public String getLblID_KofuIraiMonth() {
        return lblID_KofuIraiMonth;
    }

    /**
     * 交付依頼年月（月）を設定します。
     * @param lblID_KofuIraiMonth 交付依頼年月（月）
     */
    public void setLblID_KofuIraiMonth(String lblID_KofuIraiMonth) {
        this.lblID_KofuIraiMonth = lblID_KofuIraiMonth;
    }

    /**
     * 明細リストを取得します。
     * @return 明細リスト
     */
    public java.util.List<Cr010_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     * @param MEISAI_LIST 明細リスト
     */
    public void setMEISAI_LIST(java.util.List<Cr010_01M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }
}