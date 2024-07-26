//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe005_01のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se005_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 債権一覧 */
    private List<Se005_01M1DTO> MEISAI_SaikenLIST;

    /** 全件数 */
    private int ID_AllCount;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se005_01DTO() {
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
    public Se005_01DTO(Se005_01DTO orig) {
        super(orig);
    }

    /**
     * 債権一覧を取得します。
     * @return 債権一覧
     */
    public List<Se005_01M1DTO> getMEISAI_SaikenLIST() {
        return MEISAI_SaikenLIST;
    }

    /**
     * 債権一覧を設定します。
     * @param MEISAI_SaikenLIST 債権一覧
     */
    public void setMEISAI_SaikenLIST(List<Se005_01M1DTO> MEISAI_SaikenLIST) {
        this.MEISAI_SaikenLIST = MEISAI_SaikenLIST;
    }

    /**
     * 全件数を取得します。
     * @return 全件数
     */
    public int getID_AllCount() {
        return ID_AllCount;
    }

    /**
     * 全件数を設定します。
     * @param ID_AllCount 全件数
     */
    public void setID_AllCount(int ID_AllCount) {
        this.ID_AllCount = ID_AllCount;
    }

}