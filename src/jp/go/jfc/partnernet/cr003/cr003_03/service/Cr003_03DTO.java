//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr003_03のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_03DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** ステータス */
    private String lblError;
    /** 明細 */
    private java.util.List<Cr003_03M1DTO> MEISAI_AnkenLIST = new java.util.ArrayList<Cr003_03M1DTO>(0);

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr003_03DTO() {
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
    public Cr003_03DTO(Cr003_03DTO orig) {
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
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 明細を取得します。
     * @return 明細
     */
    public java.util.List<Cr003_03M1DTO> getMEISAI_AnkenLIST() {
        return MEISAI_AnkenLIST;
    }

    /**
     * 明細を設定します。
     * @param MEISAI_AnkenLIST 明細
     */
    public void setMEISAI_AnkenLIST(java.util.List<Cr003_03M1DTO> MEISAI_AnkenLIST) {
        this.MEISAI_AnkenLIST = MEISAI_AnkenLIST;
    }

}