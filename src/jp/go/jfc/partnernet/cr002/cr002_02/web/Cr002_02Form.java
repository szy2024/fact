//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_02.web;

import java.util.List;

import jp.go.jfc.partnernet.cr002.cr002_02.service.Cr002_02M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはcr002_02のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr002_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告書データ */
    private PNPagingTable<Cr002_02M1DTO> cr002_02M1Table = new PNPagingTableSerial<Cr002_02M1DTO>(
            "cr002_02M1Table");
    // private PNPagingTable<Cr002_02M1DTO> cr002_02M1Table
    // = new PNPagingTableMemory<Cr002_02M1DTO>("cr002_02M1Table");

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** エラーメッセージ */
    private String lblError;
    /** メッセージ */
    private String lblMessage;
    /** 明細 */
    private List<Cr002_02M1DTO> Cr002_02MEISAI_AnkenLIST;
    /** 完了画面メッセージ表示要フラグ */
    private boolean flgSeikyuUpdate;

    /**
     * 報告書データを取得します。
     * @return 報告書データ
     */
    public PNPagingTable<Cr002_02M1DTO> getCr002_02M1Table() {
        return cr002_02M1Table;
    }

    /**
     * 報告書データを設定します。
     * @param cr002_02M1Table 報告書データ
     */
    public void setCr002_02M1Table(PNPagingTable<Cr002_02M1DTO> cr002_02M1Table) {
        this.cr002_02M1Table = cr002_02M1Table;
    }

    /**
     * 報告書データテーブルレコードを取得します。
     * @return 報告書データテーブル
     */
    public List<Cr002_02M1DTO> getCr002_02M1TableRecord() {
        return getCr002_02M1Table().getRecordList();
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
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 明細を取得します。
     * @return 明細
     */
    public List<Cr002_02M1DTO> getCr002_02MEISAI_AnkenLIST() {
        return Cr002_02MEISAI_AnkenLIST;
    }

    /**
     * 明細を設定します。
     * @param Cr002_02MEISAI_AnkenLIST 明細
     */
    public void setCr002_02MEISAI_AnkenLIST(List<Cr002_02M1DTO> Cr002_02MEISAI_AnkenLIST) {
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