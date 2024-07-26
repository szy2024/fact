//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_01.web;

import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

/**
 * <pre>
 * このクラスはUt001_01のFormクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** お知らせデータ（通知・事務連絡） */
    private String ID_TsuuchiNews;
    /** お知らせデータ（金利改定情報） */
    private String ID_KinriNews;
    /** お知らせデータ（要領・マニュアル/様式集の改定情報） */
    private String ID_YouryouNews;
    /** お知らせデータ（システム運用） */
    private String ID_UnyouNews;

    /**
     * お知らせデータ（通知・事務連絡）を取得します。
     * @return お知らせデータ（通知・事務連絡）
     */
    public String getID_TsuuchiNews() {
        return ID_TsuuchiNews;
    }

    /**
     * お知らせデータ（通知・事務連絡）を設定します。
     * @param ID_TsuuchiNews お知らせデータ（通知・事務連絡）
     */
    public void setID_TsuuchiNews(String ID_TsuuchiNews) {
        this.ID_TsuuchiNews = ID_TsuuchiNews;
    }
    /**
     * お知らせデータ（金利改定情報）を取得します。
     * @return お知らせデータ（金利改定情報）
     */
    public String getID_KinriNews() {
        return ID_KinriNews;
    }

    /**
     * お知らせデータ（金利改定情報）を設定します。
     * @param ID_KinriNews お知らせデータ（金利改定情報）
     */
    public void setID_KinriNews(String ID_KinriNews) {
        this.ID_KinriNews = ID_KinriNews;
    }
    /**
     * お知らせデータ（要領・マニュアル/様式集の改定情報）を取得します。
     * @return お知らせデータ（要領・マニュアル/様式集の改定情報）
     */
    public String getID_YouryouNews() {
        return ID_YouryouNews;
    }

    /**
     * お知らせデータ（要領・マニュアル/様式集の改定情報）を設定します。
     * @param ID_YouryouNews お知らせデータ（要領・マニュアル/様式集の改定情報）
     */
    public void setID_YouryouNews(String ID_YouryouNews) {
        this.ID_YouryouNews = ID_YouryouNews;
    }
    /**
     * お知らせデータ（システム運用）を取得します。
     * @return お知らせデータ（システム運用）
     */
    public String getID_UnyouNews() {
        return ID_UnyouNews;
    }

    /**
     * お知らせデータ（システム運用）を設定します。
     * @param ID_UnyouNews お知らせデータ（システム運用）
     */
    public void setID_UnyouNews(String ID_UnyouNews) {
        this.ID_UnyouNews = ID_UnyouNews;
    }

}