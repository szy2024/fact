//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se002_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se002.se002_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe002_01のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se002_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 明細リスト１ */
    private java.util.List<Se002_01M1DTO> MEISAI_LIST1 = new java.util.ArrayList<Se002_01M1DTO>(0);
    /** 明細リスト２ */
    private java.util.List<Se002_01M2DTO> MEISAI_LIST2 = new java.util.ArrayList<Se002_01M2DTO>(0);
    /** 実行未了件数 */
    private int J_Kensu;
    /** 払出未了件数 */
    private int H_Kensu;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se002_01DTO() {
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
    public Se002_01DTO(Se002_01DTO orig) {
        super(orig);
    }

    /**
     * 明細リスト１を取得します。
     * @return 明細リスト１
     */
    public java.util.List<Se002_01M1DTO> getMEISAI_LIST1() {
        return MEISAI_LIST1;
    }

    /**
     * 明細リスト１を設定します。
     * @param MEISAI_LIST1 明細リスト１
     */
    public void setMEISAI_LIST1(java.util.List<Se002_01M1DTO> MEISAI_LIST1) {
        this.MEISAI_LIST1 = MEISAI_LIST1;
    }

    /**
     * 明細リスト２を取得します。
     * @return 明細リスト２
     */
    public java.util.List<Se002_01M2DTO> getMEISAI_LIST2() {
        return MEISAI_LIST2;
    }

    /**
     * 明細リスト２を設定します。
     * @param MEISAI_LIST2 明細リスト２
     */
    public void setMEISAI_LIST2(java.util.List<Se002_01M2DTO> MEISAI_LIST2) {
        this.MEISAI_LIST2 = MEISAI_LIST2;
    }

    /**
     * 実行未了件数を取得します。
     * @return 実行未了件数
     */
    public int getJ_Kensu() {
        return J_Kensu;
    }

    /**
     * 実行未了件数を設定します。
     * @param J_Kensu 実行未了件数
     */
    public void setJ_Kensu(int J_Kensu) {
        this.J_Kensu = J_Kensu;
    }

    /**
     * 払出未了件数を取得します。
     * @return 払出未了件数
     */
    public int getH_Kensu() {
        return H_Kensu;
    }

    /**
     * 払出未了件数を設定します。
     * @param H_Kensu 払出未了件数
     */
    public void setH_Kensu(int H_Kensu) {
        this.H_Kensu = H_Kensu;
    }

}