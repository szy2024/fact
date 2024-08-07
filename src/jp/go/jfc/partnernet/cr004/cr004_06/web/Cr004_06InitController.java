//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_06InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_06.web;

import java.util.Map;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr004.common.Cr004Constants;
import jp.go.jfc.partnernet.cr004.cr004_04.web.Cr004_04SendController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはcr004_06の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr004_06Form")
@RequestMapping(value = "/Cr004_06Init.form")
public class Cr004_06InitController extends Cr004_06BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr004_04SendController.class);

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
    public String executeAction(Model model, Cr004_06Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡情報の完了画面メッセージ表示要フラグが表示要の場合、下記メッセージを画面の誘導メッセージエリアに表示する。
        // 　　メッセージ：払込案内が変更されています。内容をご確認ください。

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);
        // 　　・債権管理番号
        form.setFlgSeikyuUpdate((Boolean) paramMap.get(Cr004Constants.PROPERTY_FLG_SEIKYU_UPDATE));

        // ログ
        log.debug("-------Cr004_06 受け渡しパラメータ-------");
        log.debug("完了画面メッセージ表示要フラグ：" + form.getFlgSeikyuUpdate());
        log.debug("-----------------------------------");

        form.setLblNaviMessage("");

        if (form.getFlgSeikyuUpdate()) {
            form.setLblNaviMessage("払込案内が変更されています。内容をご確認ください。");
        }

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
    public void displayControl(Model model, Cr004_06Form form, HttpServletRequest request) {

    }
}