//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm002_02Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/29 | 石川　真理            | 新規作成
// 2.0.0   | 2019/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.cm002.cm002_02.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはCm002_02のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cm002_02Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 貸付実行報告書アンカー */
    private String ancrcr00101;
    /** 貸付受入金払出・充当報告書アンカー */
    private String ancrcr00201;
    /** 元利金受入・充当報告書アンカー */
    private String ancrcr00301;
    /** 繰上償還受入・充当報告書アンカー */
    private String ancrcr00401;
    /** 代位弁済金払込・充当報告書アンカー */
    private String ancrcr00501;
    /** 立替金受入・充当報告書アンカー */
    private String ancrcr00601;
    /** 仮受金（一般口）受入報告書アンカー */
    private String ancrcr00801;
    /** 留置期間利息・代弁遅延損害金受入充当報告書アンカー */
    private String ancrcr00901;
    /** 資金交付依頼予定表（月間）アンカー */
    private String ancrcr01001;
    /** 資金交付依頼書（週間）アンカー */
    private String ancrcr01101;
    /** 包括委任状等の交付依頼アンカー */
    private String ancrcr01201;
    /** （根）抵当権抹消に係る報告アンカー */
    private String ancrcr01301;

    /**
     * 貸付実行報告書アンカーを取得します。
     * @return 貸付実行報告書アンカー
     */
    public String getAncrcr00101() {
        return ancrcr00101;
    }

    /**
     * 貸付実行報告書アンカーを設定します。
     * @param ancrcr00101 貸付実行報告書アンカー
     */
    public void setAncrcr00101(String ancrcr00101) {
        this.ancrcr00101 = ancrcr00101;
    }
    /**
     * 貸付受入金払出・充当報告書アンカーを取得します。
     * @return 貸付受入金払出・充当報告書アンカー
     */
    public String getAncrcr00201() {
        return ancrcr00201;
    }

    /**
     * 貸付受入金払出・充当報告書アンカーを設定します。
     * @param ancrcr00201 貸付受入金払出・充当報告書アンカー
     */
    public void setAncrcr00201(String ancrcr00201) {
        this.ancrcr00201 = ancrcr00201;
    }
    /**
     * 元利金受入・充当報告書アンカーを取得します。
     * @return 元利金受入・充当報告書アンカー
     */
    public String getAncrcr00301() {
        return ancrcr00301;
    }

    /**
     * 元利金受入・充当報告書アンカーを設定します。
     * @param ancrcr00301 元利金受入・充当報告書アンカー
     */
    public void setAncrcr00301(String ancrcr00301) {
        this.ancrcr00301 = ancrcr00301;
    }
    /**
     * 繰上償還受入・充当報告書アンカーを取得します。
     * @return 繰上償還受入・充当報告書アンカー
     */
    public String getAncrcr00401() {
        return ancrcr00401;
    }

    /**
     * 繰上償還受入・充当報告書アンカーを設定します。
     * @param ancrcr00401 繰上償還受入・充当報告書アンカー
     */
    public void setAncrcr00401(String ancrcr00401) {
        this.ancrcr00401 = ancrcr00401;
    }
    /**
     * 代位弁済金払込・充当報告書アンカーを取得します。
     * @return 代位弁済金払込・充当報告書アンカー
     */
    public String getAncrcr00501() {
        return ancrcr00501;
    }

    /**
     * 代位弁済金払込・充当報告書アンカーを設定します。
     * @param ancrcr00501 代位弁済金払込・充当報告書アンカー
     */
    public void setAncrcr00501(String ancrcr00501) {
        this.ancrcr00501 = ancrcr00501;
    }
    /**
     * 立替金受入・充当報告書アンカーを取得します。
     * @return 立替金受入・充当報告書アンカー
     */
    public String getAncrcr00601() {
        return ancrcr00601;
    }

    /**
     * 立替金受入・充当報告書アンカーを設定します。
     * @param ancrcr00601 立替金受入・充当報告書アンカー
     */
    public void setAncrcr00601(String ancrcr00601) {
        this.ancrcr00601 = ancrcr00601;
    }
    /**
     * 仮受金（一般口）受入報告書アンカーを取得します。
     * @return 仮受金（一般口）受入報告書アンカー
     */
    public String getAncrcr00801() {
        return ancrcr00801;
    }

    /**
     * 仮受金（一般口）受入報告書アンカーを設定します。
     * @param ancrcr00801 仮受金（一般口）受入報告書アンカー
     */
    public void setAncrcr00801(String ancrcr00801) {
        this.ancrcr00801 = ancrcr00801;
    }
    /**
     * 留置期間利息・代弁遅延損害金受入充当報告書アンカーを取得します。
     * @return 留置期間利息・代弁遅延損害金受入充当報告書アンカー
     */
    public String getAncrcr00901() {
        return ancrcr00901;
    }

    /**
     * 留置期間利息・代弁遅延損害金受入充当報告書アンカーを設定します。
     * @param ancrcr00901 留置期間利息・代弁遅延損害金受入充当報告書アンカー
     */
    public void setAncrcr00901(String ancrcr00901) {
        this.ancrcr00901 = ancrcr00901;
    }


    /**
     * 資金交付依頼予定表（月間）アンカーを取得します。
     * @return 資金交付依頼予定表（月間）アンカー
     */
    public String getAncrcr01001() {
        return ancrcr01001;
    }

    /**
     * 資金交付依頼予定表（月間）アンカーを設定します。
     * @param ancrcr01001 資金交付依頼予定表（月間）アンカー
     */
    public void setAncrcr01001(String ancrcr01001) {
        this.ancrcr01001 = ancrcr01001;
    }

    /**
     * 資金交付依頼書（週間）アンカーを取得します。
     * @return 資金交付依頼書（週間）アンカー
     */
    public String getAncrcr01101() {
        return ancrcr01101;
    }

    /**
     * 資金交付依頼書（週間）アンカーを設定します。
     * @param ancrcr01101 資金交付依頼書（週間）アンカー
     */
    public void setAncrcr01101(String ancrcr01101) {
        this.ancrcr01101 = ancrcr01101;
    }

    /**
     * 包括委任状等の交付依頼アンカーを取得します。
     * @return 包括委任状等の交付依頼アンカー
     */
    public String getAncrcr01201() {
        return ancrcr01201;
    }

    /**
     * 包括委任状等の交付依頼アンカーを設定します。
     * @param ancrcr01201 包括委任状等の交付依頼アンカー
     */
    public void setAncrcr01201(String ancrcr01201) {
        this.ancrcr01201 = ancrcr01201;
    }

    /**
     * （根）抵当権抹消に係る報告アンカーを取得します。
     * @return （根）抵当権抹消に係る報告アンカー
     */
    public String getAncrcr01301() {
        return ancrcr01301;
    }

    /**
     * （根）抵当権抹消に係る報告アンカーを設定します。
     * @param ancrcr01301 （根）抵当権抹消に係る報告アンカー
     */
    public void setAncrcr01301(String ancrcr01301) {
        this.ancrcr01301 = ancrcr01301;
    }
}