//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : ut001_05Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_05.web;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.ut001.ut001_05.service.Ut001_05M1DTO;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはUt001_05のFormクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class ut001_05Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 様式データ */
    private PNPagingTable<Ut001_05M1DTO> Ut001_05M1Table = new PNPagingTableSerial<Ut001_05M1DTO>(
            "Ut001_05M1Table");
    // private PNPagingTable<Ut001_05M1DTO> Ut001_05M1Table
    // = new PNPagingTableMemory<Ut001_05M1DTO>("Ut001_05M1Table");

    /** ステータス */
    private String lblErr;
    /** 様式明細 */
    private List<Ut001_05M1DTO> YoshikiList;
    /** 選択行番号 */
    private String selectedIndex;

    /**
     * 様式データを取得します。
     * @return 様式データ
     */
    public PNPagingTable<Ut001_05M1DTO> getUt001_05M1Table() {
        return Ut001_05M1Table;
    }

    /**
     * 様式データを設定します。
     * @param Ut001_05M1Table 様式データ
     */
    public void setUt001_05M1Table(PNPagingTable<Ut001_05M1DTO> Ut001_05M1Table) {
        this.Ut001_05M1Table = Ut001_05M1Table;
    }

    /**
     * 様式データテーブルレコードを取得します。
     * @return 様式データテーブル
     */
    public List<Ut001_05M1DTO> getUt001_05M1TableRecord() {
        return getUt001_05M1Table().getRecordList();
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * ステータスを設定します。
     * @param lblErr ステータス
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
    }

    /**
     * 様式明細を取得します。
     * @return 様式明細
     */
    public List<Ut001_05M1DTO> getYoshikiList() {
        return YoshikiList;
    }

    /**
     * 様式明細を設定します。
     * @param YoshikiList 様式明細
     */
    public void setYoshikiList(List<Ut001_05M1DTO> YoshikiList) {
        this.YoshikiList = YoshikiList;
    }

    /**
     * 選択行番号を取得します。
     * @return 選択行番号
     */
    public String getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * 選択行番号を設定します。
     * @param selectedIndex 選択行番号
     */
    public void setSelectedIndex(String selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}