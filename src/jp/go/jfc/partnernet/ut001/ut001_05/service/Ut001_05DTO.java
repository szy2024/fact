//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_05DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_05.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはUt001_05のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_05DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 様式明細 */
    private java.util.List<Ut001_05M1DTO> YoshikiList;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut001_05DTO() {
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
    public Ut001_05DTO(Ut001_05DTO orig) {
        super(orig);
    }

    /**
     * 様式明細を取得します。
     * @return 様式明細
     */
    public java.util.List<Ut001_05M1DTO> getYoshikiList() {
        return YoshikiList;
    }

    /**
     * 様式明細を設定します。
     * @param YoshikiList 様式明細
     */
    public void setYoshikiList(java.util.List<Ut001_05M1DTO> YoshikiList) {
        this.YoshikiList = YoshikiList;
    }

}