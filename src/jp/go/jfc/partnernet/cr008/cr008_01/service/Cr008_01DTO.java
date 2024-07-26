//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr008_01のDTOクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 公庫支店名プルダウンリスト */
    private java.util.LinkedHashMap<String, String> ShokanHonShitenLIST;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr008_01DTO() {
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
    public Cr008_01DTO(Cr008_01DTO orig) {
        super(orig);
    }

    /**
     * 公庫支店名プルダウンリストを取得します。
     * @return 公庫支店名プルダウンリスト
     */
    public java.util.LinkedHashMap<String, String> getShokanHonShitenLIST() {
        return ShokanHonShitenLIST;
    }

    /**
     * 公庫支店名プルダウンリストを設定します。
     * @param ShokanHonShitenLIST 公庫支店名プルダウンリスト
     */
    public void setShokanHonShitenLIST(java.util.LinkedHashMap<String, String> ShokanHonShitenLIST) {
        this.ShokanHonShitenLIST = ShokanHonShitenLIST;
    }

}