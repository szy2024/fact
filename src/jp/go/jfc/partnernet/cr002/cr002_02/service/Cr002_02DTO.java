//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_02.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr002_02のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr002_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** エラーメッセージ */
    private String lblError;
    /** 明細 */
    private java.util.List<Cr002_02M1DTO> Cr002_02MEISAI_AnkenLIST = new java.util.ArrayList<Cr002_02M1DTO>(0);
    /** 完了画面メッセージ表示要フラグ */
    private boolean flgSeikyuUpdate;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr002_02DTO() {
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
    public Cr002_02DTO(Cr002_02DTO orig) {
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
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * エラーメッセージを設定します。
     * @param lblError エラーメッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * 明細を取得します。
     * @return 明細
     */
    public java.util.List<Cr002_02M1DTO> getCr002_02MEISAI_AnkenLIST() {
        return Cr002_02MEISAI_AnkenLIST;
    }

    /**
     * 明細を設定します。
     * @param Cr002_02MEISAI_AnkenLIST 明細
     */
    public void setCr002_02MEISAI_AnkenLIST(java.util.List<Cr002_02M1DTO> Cr002_02MEISAI_AnkenLIST) {
        this.Cr002_02MEISAI_AnkenLIST = Cr002_02MEISAI_AnkenLIST;
    }

    /**
     * 完了画面メッセージ表示要フラグを取得します。
     * @return 完了画面メッセージ表示要フラグ
     */
    public boolean getFlgSeikyuUpdate() {
        return flgSeikyuUpdate;
    }

    /**
     * 完了画面メッセージ表示要フラグを設定します。
     * @param flgSeikyuUpdate 完了画面メッセージ表示要フラグ
     */
    public void setFlgSeikyuUpdate(boolean flgSeikyuUpdate) {
        this.flgSeikyuUpdate = flgSeikyuUpdate;
    }

}