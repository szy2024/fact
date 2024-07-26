//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_06Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_06.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはcr004_06のFormクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_06Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** エラーメッセージ */
    private String lblErr;
    /** メッセージ */
    private String lblMessage;
    /** 誘導メッセージ */
    private String lblNaviMessage;
    /** 完了画面メッセージ表示要フラグ */
    private boolean flgSeikyuUpdate;

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getLblErr() {
        return lblErr;
    }

    /**
     * エラーメッセージを設定します。
     * @param lblErr エラーメッセージ
     */
    public void setLblErr(String lblErr) {
        this.lblErr = lblErr;
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
     * 誘導メッセージを取得します。
     * @return 誘導メッセージ
     */
    public String getLblNaviMessage() {
        return lblNaviMessage;
    }

    /**
     * 誘導メッセージを設定します。
     * @param lblNaviMessage 誘導メッセージ
     */
    public void setLblNaviMessage(String lblNaviMessage) {
        this.lblNaviMessage = lblNaviMessage;
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