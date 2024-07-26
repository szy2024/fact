//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはse012_02の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se012_02Form")
@RequestMapping(value = "/Se012_02Back.form")
public class Se012_02BackController extends Se012_02BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se012_02Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // se012_01（業務委託手数料通知（情報検索画面））へ遷移する。
        return success("Se012_01Return");
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se012_02Form form,
            HttpServletRequest request) {

    }
}