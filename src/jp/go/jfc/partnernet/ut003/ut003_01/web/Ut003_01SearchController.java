//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_01.web;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.ut003.common.Ut003Constants;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはut003_01の検索ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_01form")
@RequestMapping(value = "/Ut003_01Search.form")
public class Ut003_01SearchController extends Ut003_01BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Ut003_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 遷移パラメータの設定
// [ADD] Ver 2.0.0 - START
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHSTARTGENGO, form.getID_SearchStartGengo());
// [ADD] Ver 2.0.0 - END
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHSTARTYEAR, form.getID_SearchStartYear());
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHSTARTMONTH,
                form.getID_SearchStartMonth());
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHSTARTDATE, form.getID_SearchStartDate());
// [ADD] Ver 2.0.0 - START
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHENDGENGO, form.getID_SearchEndGengo());
// [ADD] Ver 2.0.0 - END
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHENDYEAR, form.getID_SearchEndYear());
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHENDMONTH, form.getID_SearchEndMonth());
        addForwardParameter(request, Ut003Constants.PROPERTY_ID_SEARCHENDDATE, form.getID_SearchEndDate());

        // 文書種別が1:通知・事務連絡の場合
        // 文書ファイル削除（通知・事務連絡文書ファイル削除画面）へ遷移する
        // 　return success("Ut003_02Init")
        if (Ut003Constants.ID_INFOTYPE_TSUCHIJIMU.equals(form.getDrpID_ID_InfoType())) {
            return success(Ut003Constants.EVENT_ID_UT003_02INIT);
        }

        // 文書種別が2:金利改定情報の場合
        // 文書ファイル削除（金利情報文書ファイル削除画面）へ遷移する
        // 　return success("Ut003_03Init")
        if (Ut003Constants.ID_INFOTYPE_KINRIJYOHO.equals(form.getDrpID_ID_InfoType())) {
            return success(Ut003Constants.EVENT_ID_UT003_03INIT);
        }

        // 文書種別が3:要領・マニュアルの改正情報の場合
        // 文書ファイル削除（要領・マニュアル文書ファイル削除画面）へ遷移する
        // 　return success("Ut003_04Init")
        if (Ut003Constants.ID_INFOTYPE_YORYOMANUAL.equals(form.getDrpID_ID_InfoType())) {
            return success(Ut003Constants.EVENT_ID_UT003_04INIT);
        }

        // 文書種別が4:様式集の改正情報の場合
        // 文書ファイル削除（様式集文書ファイル削除画面）へ遷移する
        // 　return success("Ut003_05Init")
        if (Ut003Constants.ID_INFOTYPE_YOSHIKI.equals(form.getDrpID_ID_InfoType())) {
            return success(Ut003Constants.EVENT_ID_UT003_05INIT);
        }

        // 文書種別がブランクの場合
        // 　return MY_VIEW

        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Ut003_01Form form, HttpServletRequest request) {

    }
}