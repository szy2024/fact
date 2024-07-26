//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : ut001_03Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.web;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.ut001.ut001_03.service.Ut001_03M1DTO;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはUt001_03のFormクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class ut001_03Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 金利情報一覧 */
    private PNPagingTable<Ut001_03M1DTO> Ut001_03M1Table = new PNPagingTableSerial<Ut001_03M1DTO>(
            "Ut001_03M1Table");
    // private PNPagingTable<Ut001_03M1DTO> Ut001_03M1Table
    // = new PNPagingTableMemory<Ut001_03M1DTO>("Ut001_03M1Table");

    /** ステータス */
    private String lblErr;
    /** 金利情報一覧 */
    private List<Ut001_03M1DTO> KinriJyohoList;
    /** 選択行番号 */
    private String selectedIndex;

    /**
     * 金利情報一覧を取得します。
     * @return 金利情報一覧
     */
    public PNPagingTable<Ut001_03M1DTO> getUt001_03M1Table() {
        return Ut001_03M1Table;
    }

    /**
     * 金利情報一覧を設定します。
     * @param Ut001_03M1Table 金利情報一覧
     */
    public void setUt001_03M1Table(PNPagingTable<Ut001_03M1DTO> Ut001_03M1Table) {
        this.Ut001_03M1Table = Ut001_03M1Table;
    }

    /**
     * 金利情報一覧テーブルレコードを取得します。
     * @return 金利情報一覧テーブル
     */
    public List<Ut001_03M1DTO> getUt001_03M1TableRecord() {
        return getUt001_03M1Table().getRecordList();
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
     * 金利情報一覧を取得します。
     * @return 金利情報一覧
     */
    public List<Ut001_03M1DTO> getKinriJyohoList() {
        return KinriJyohoList;
    }

    /**
     * 金利情報一覧を設定します。
     * @param KinriJyohoList 金利情報一覧
     */
    public void setKinriJyohoList(List<Ut001_03M1DTO> KinriJyohoList) {
        this.KinriJyohoList = KinriJyohoList;
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