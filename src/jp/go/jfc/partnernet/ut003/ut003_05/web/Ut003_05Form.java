//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_05Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_05.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05M1DTO;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05DTO;

/**
 * <pre>
 * このクラスはut003_05のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Ut003_05Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 様式集文書一覧 */
    private PNPagingTable<Ut003_05M1DTO> Ut003_05M1Table = new PNPagingTableSerial<Ut003_05M1DTO>(
            "Ut003_05M1Table");

    /** 削除チェックボックス */
    private String chkDelete;
    /** ファイル名 */
    private String ID_ID_DocFileName;
    /** 様式集文書一覧 */
    private List<Ut003_05M1DTO> YoshikiList;
// [ADD] Ver 2.0.0 - START
    /** 検索開始元号 */
    private String ID_SearchStartGengo;
// [ADD] Ver 2.0.0 - END
    /** 検索開始年（和暦） */
    private String ID_SearchStartYear;
    /** 検索開始月 */
    private String ID_SearchStartMonth;
    /** 検索開始日 */
    private String ID_SearchStartDate;
// [ADD] Ver 2.0.0 - START
    /** 検索終了元号 */
    private String ID_SearchEndGengo;
// [ADD] Ver 2.0.0 - END
    /** 検索終了年（和暦） */
    private String ID_SearchEndYear;
    /** 検索終了月 */
    private String ID_SearchEndMonth;
    /** 検索終了日 */
    private String ID_SearchEndDate;
    /** 検索結果表示領域 */
    private Ut003_05DTO SearchDataArea;
    /** 選択行番号 */
    private String selectedIndex;

    /**
     * 様式集文書一覧を取得します。
     * @return 様式集文書一覧
     */
    public PNPagingTable<Ut003_05M1DTO> getUt003_05M1Table() {
        return Ut003_05M1Table;
    }

    /**
     * 様式集文書一覧を設定します。
     * @param Ut003_05M1Table 様式集文書一覧
     */
    public void setUt003_05M1Table(PNPagingTable<Ut003_05M1DTO> Ut003_05M1Table) {
        this.Ut003_05M1Table = Ut003_05M1Table;
    }

    /**
     * 様式集文書一覧テーブルレコードを取得します。
     * @return 様式集文書一覧テーブル
     */
    public List<Ut003_05M1DTO> getUt003_05M1TableRecord() {
        return getUt003_05M1Table().getRecordList();
    }

    /**
     * 削除チェックボックスを取得します。
     * @return 削除チェックボックス
     */
    public String getChkDelete() {
        return chkDelete;
    }

    /**
     * 削除チェックボックスを設定します。
     * @param chkDelete 削除チェックボックス
     */
    public void setChkDelete(String chkDelete) {
        this.chkDelete = chkDelete;
    }

    /**
     * ファイル名を取得します。
     * @return ファイル名
     */
    public String getID_ID_DocFileName() {
        return ID_ID_DocFileName;
    }

    /**
     * ファイル名を設定します。
     * @param ID_ID_DocFileName ファイル名
     */
    public void setID_ID_DocFileName(String ID_ID_DocFileName) {
        this.ID_ID_DocFileName = ID_ID_DocFileName;
    }

    /**
     * 様式集文書一覧を取得します。
     * @return 様式集文書一覧
     */
    public List<Ut003_05M1DTO> getYoshikiList() {
        return YoshikiList;
    }

    /**
     * 様式集文書一覧を設定します。
     * @param YoshikiList 様式集文書一覧
     */
    public void setYoshikiList(List<Ut003_05M1DTO> YoshikiList) {
        this.YoshikiList = YoshikiList;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * 検索開始元号を取得します。
     * @return 検索開始元号
     */
    public String getID_SearchStartGengo() {
        return ID_SearchStartGengo;
    }

    /**
     * 検索開始元号を設定します。
     * @param ID_SearchStartGengo 検索開始元号
     */
    public void setID_SearchStartGengo(String ID_SearchStartGengo) {
        this.ID_SearchStartGengo = ID_SearchStartGengo;
    }
// [ADD] Ver 2.0.0 - END

    /**
     * 検索開始年（和暦）を取得します。
     * @return 検索開始年（和暦）
     */
    public String getID_SearchStartYear() {
        return ID_SearchStartYear;
    }

    /**
     * 検索開始年（和暦）を設定します。
     * @param ID_SearchStartYear 検索開始年（和暦）
     */
    public void setID_SearchStartYear(String ID_SearchStartYear) {
        this.ID_SearchStartYear = ID_SearchStartYear;
    }

    /**
     * 検索開始月を取得します。
     * @return 検索開始月
     */
    public String getID_SearchStartMonth() {
        return ID_SearchStartMonth;
    }

    /**
     * 検索開始月を設定します。
     * @param ID_SearchStartMonth 検索開始月
     */
    public void setID_SearchStartMonth(String ID_SearchStartMonth) {
        this.ID_SearchStartMonth = ID_SearchStartMonth;
    }

    /**
     * 検索開始日を取得します。
     * @return 検索開始日
     */
    public String getID_SearchStartDate() {
        return ID_SearchStartDate;
    }

    /**
     * 検索開始日を設定します。
     * @param ID_SearchStartDate 検索開始日
     */
    public void setID_SearchStartDate(String ID_SearchStartDate) {
        this.ID_SearchStartDate = ID_SearchStartDate;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * 検索終了元号を取得します。
     * @return 検索終了元号
     */
    public String getID_SearchEndGengo() {
        return ID_SearchEndGengo;
    }

    /**
     * 検索終了元号を設定します。
     * @param ID_SearchEndGengo 検索終了元号
     */
    public void setID_SearchEndGengo(String ID_SearchEndGengo) {
        this.ID_SearchEndGengo = ID_SearchEndGengo;
    }
// [ADD] Ver 2.0.0 - END

    /**
     * 検索終了年（和暦）を取得します。
     * @return 検索終了年（和暦）
     */
    public String getID_SearchEndYear() {
        return ID_SearchEndYear;
    }

    /**
     * 検索終了年（和暦）を設定します。
     * @param ID_SearchEndYear 検索終了年（和暦）
     */
    public void setID_SearchEndYear(String ID_SearchEndYear) {
        this.ID_SearchEndYear = ID_SearchEndYear;
    }

    /**
     * 検索終了月を取得します。
     * @return 検索終了月
     */
    public String getID_SearchEndMonth() {
        return ID_SearchEndMonth;
    }

    /**
     * 検索終了月を設定します。
     * @param ID_SearchEndMonth 検索終了月
     */
    public void setID_SearchEndMonth(String ID_SearchEndMonth) {
        this.ID_SearchEndMonth = ID_SearchEndMonth;
    }

    /**
     * 検索終了日を取得します。
     * @return 検索終了日
     */
    public String getID_SearchEndDate() {
        return ID_SearchEndDate;
    }

    /**
     * 検索終了日を設定します。
     * @param ID_SearchEndDate 検索終了日
     */
    public void setID_SearchEndDate(String ID_SearchEndDate) {
        this.ID_SearchEndDate = ID_SearchEndDate;
    }

    /**
     * 検索結果表示領域を取得します。
     * @return 検索結果表示領域
     */
    public Ut003_05DTO getSearchDataArea() {
        return SearchDataArea;
    }

    /**
     * 検索結果表示領域を設定します。
     * @param SearchDataArea 検索結果表示領域
     */
    public void setSearchDataArea(Ut003_05DTO SearchDataArea) {
        this.SearchDataArea = SearchDataArea;
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