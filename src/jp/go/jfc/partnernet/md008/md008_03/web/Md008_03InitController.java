//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_03.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはMd008_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md008_03Form")
@RequestMapping(value = "/Md008_03Init.form")
public class Md008_03InitController extends Md008_03BaseController {

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
    public String executeAction(Model model, Md008_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // return MY_VIEW

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
    public void displayControl(Model model, Md008_03Form form, HttpServletRequest request) {

    }
}