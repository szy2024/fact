//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.cr003.cr003_02.service.Cr003_02M1DTO;
import jp.go.jfc.partnernet.cr003.cr003_03.service.Cr003_03M1DTO;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;

/**
 * <pre>
 * このクラスはCr003_03のFormクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_03Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 案件 */
    private PNPagingTable<Cr003_03M1DTO> Cr003_03M1Table = new PNPagingTableSerial<Cr003_03M1DTO>(
            "Cr003_03M1Table");
    // private PNPagingTable<Cr003_03M1DTO> Cr003_03M1Table
    // = new PNPagingTableMemory<Cr003_03M1DTO>("Cr003_03M1Table");

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** ステータス */
    private String lblError;
    /** 報告年月日(受渡) */
    private String Cr003_03ID_Date_Report;
    /** 入力結果画面明細 */
    private List<Cr003_02M1DTO> Cr003_02MEISAI_AnkenLIST;

    /**
     * 案件を取得します。
     * @return 案件
     */
    public PNPagingTable<Cr003_03M1DTO> getCr003_03M1Table() {
        return Cr003_03M1Table;
    }

    /**
     * 案件を設定します。
     * @param Cr003_03M1Table 案件
     */
    public void setCr003_03M1Table(PNPagingTable<Cr003_03M1DTO> Cr003_03M1Table) {
        this.Cr003_03M1Table = Cr003_03M1Table;
    }

    /**
     * 案件テーブルレコードを取得します。
     * @return 案件テーブル
     */
    public List<Cr003_03M1DTO> getCr003_03M1TableRecord() {
        return getCr003_03M1Table().getRecordList();
    }

    /**
     * 案件テーブルレコードを取得します。
     * @return 案件テーブル
     */
    public void setCr003_03M1TableRecord(List<Cr003_03M1DTO> rec) {
        this.Cr003_03M1Table.setRecordList(rec, rec.size());
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
     * 報告年月日(受渡)を取得します。
     * @return 報告年月日(受渡)
     */
    public String getCr003_03ID_Date_Report() {
        return Cr003_03ID_Date_Report;
    }

    /**
     * 報告年月日(受渡)を設定します。
     * @param Cr003_03ID_Date_Report 報告年月日(受渡)
     */
    public void setCr003_03ID_Date_Report(String Cr003_03ID_Date_Report) {
        this.Cr003_03ID_Date_Report = Cr003_03ID_Date_Report;
    }

    /**
     * 入力結果画面明細を取得します。
     * @return 入力結果画面明細
     */
    public List<Cr003_02M1DTO> getCr003_02MEISAI_AnkenLIST() {
        return Cr003_02MEISAI_AnkenLIST;
    }

    /**
     * 入力結果画面明細を設定します。
     * @param Cr003_03MEISAI_AnkenLIST 入力結果画面明細
     */
    public void setCr003_02MEISAI_AnkenLIST(List<Cr003_02M1DTO> Cr003_03MEISAI_AnkenLIST) {
        this.Cr003_02MEISAI_AnkenLIST = Cr003_03MEISAI_AnkenLIST;
    }

}