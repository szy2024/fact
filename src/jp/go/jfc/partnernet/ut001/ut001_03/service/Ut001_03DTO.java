//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_03DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはUt001_03のDTOクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_03DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 金利情報一覧 */
    private java.util.List<Ut001_03M1DTO> KinriJyohoList;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut001_03DTO() {
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
    public Ut001_03DTO(Ut001_03DTO orig) {
        super(orig);
    }

    /**
     * 金利情報一覧を取得します。
     * @return 金利情報一覧
     */
    public java.util.List<Ut001_03M1DTO> getKinriJyohoList() {
        return KinriJyohoList;
    }

    /**
     * 金利情報一覧を設定します。
     * @param KinriJyohoList 金利情報一覧
     */
    public void setKinriJyohoList(java.util.List<Ut001_03M1DTO> KinriJyohoList) {
        this.KinriJyohoList = KinriJyohoList;
    }

}