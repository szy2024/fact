//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm002_04Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/29 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm002.cm002_04.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはCm002_04のFormクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cm002_04Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 通知内容登録アンカー */
    private String ancrut00201;
    /** 文章ファイル削除アンカー */
    private String ancrut00301;
    /** 文章ファイル登録アンカー */
    private String ancrut00401;
    /** 利用者登録画面アンカー */
    private String ancrum00101;
    /** 利用者状態一覧表示画面アンカー */
    private String ancrum00102;

    /**
     * 通知内容登録アンカーを取得します。
     * @return 通知内容登録アンカー
     */
    public String getAncrut00201() {
        return ancrut00201;
    }

    /**
     * 通知内容登録アンカーを設定します。
     * @param ancrut00201 通知内容登録アンカー
     */
    public void setAncrut00201(String ancrut00201) {
        this.ancrut00201 = ancrut00201;
    }
    /**
     * 文章ファイル削除アンカーを取得します。
     * @return 文章ファイル削除アンカー
     */
    public String getAncrut00301() {
        return ancrut00301;
    }

    /**
     * 文章ファイル削除アンカーを設定します。
     * @param ancrut00301 文章ファイル削除アンカー
     */
    public void setAncrut00301(String ancrut00301) {
        this.ancrut00301 = ancrut00301;
    }
    /**
     * 文章ファイル登録アンカーを取得します。
     * @return 文章ファイル登録アンカー
     */
    public String getAncrut00401() {
        return ancrut00401;
    }

    /**
     * 文章ファイル登録アンカーを設定します。
     * @param ancrut00401 文章ファイル登録アンカー
     */
    public void setAncrut00401(String ancrut00401) {
        this.ancrut00401 = ancrut00401;
    }
    /**
     * 利用者登録画面アンカーを取得します。
     * @return 利用者登録画面アンカー
     */
    public String getAncrum00101() {
        return ancrum00101;
    }

    /**
     * 利用者登録画面アンカーを設定します。
     * @param ancrum00101 利用者登録画面アンカー
     */
    public void setAncrum00101(String ancrum00101) {
        this.ancrum00101 = ancrum00101;
    }
    /**
     * 利用者状態一覧表示画面アンカーを取得します。
     * @return 利用者状態一覧表示画面アンカー
     */
    public String getAncrum00102() {
        return ancrum00102;
    }

    /**
     * 利用者状態一覧表示画面アンカーを設定します。
     * @param ancrum00102 利用者状態一覧表示画面アンカー
     */
    public void setAncrum00102(String ancrum00102) {
        this.ancrum00102 = ancrum00102;
    }

}