//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se011_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se011.se011_01.web;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;
import jp.go.jfc.partnernet.se011.se011_01.service.Se011_01M1DTO;

//import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはSe011_01のFormクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se011_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージ */
    private String lblError;

    /** 元利金受入・充当報告書報告未了一覧 */
    private PNPagingTable<Se011_01M1DTO> Se011_01M1Table = new PNPagingTableSerial<Se011_01M1DTO>(
            "Se011_01M1Table");

    // private PNPagingTable<Se011_01M1DTO> Se011_01M1Table
    // = new PNPagingTableMemory<Se011_01M1DTO>("Se011_01M1Table");

    /**
     * 元利金受入・充当報告書報告未了一覧を取得します。
     * @return 元利金受入・充当報告書報告未了一覧
     */
    public PNPagingTable<Se011_01M1DTO> getSe011_01M1Table() {
        return Se011_01M1Table;
    }

    /**
     * 元利金受入・充当報告書報告未了一覧を設定します。
     * @param Se011_01M1Table 元利金受入・充当報告書報告未了一覧
     */
    public void setSe011_01M1Table(PNPagingTable<Se011_01M1DTO> Se011_01M1Table) {
        this.Se011_01M1Table = Se011_01M1Table;
    }

    /**
     * 元利金受入・充当報告書報告未了一覧テーブルレコードを取得します。
     * @return 元利金受入・充当報告書報告未了一覧テーブル
     */
    public List<Se011_01M1DTO> getSe011_01M1TableRecord() {
        return getSe011_01M1Table().getRecordList();
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * メッセージを設定します。
     * @param lblError メッセージ
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }
}