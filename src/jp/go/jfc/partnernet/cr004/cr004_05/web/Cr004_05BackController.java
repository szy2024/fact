//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_05BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_05.web;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

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
 * このクラスはcr004_05の戻るコントローラークラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr004_05Form")
@RequestMapping(value = "/Cr004_05Back.form")
public class Cr004_05BackController extends Cr004_05BaseController {

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
    public String executeAction(Model model, Cr004_05Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 繰上償還受入・充当報告書作成（入力画面)へ遷移
        // 　return success("Cr004_04Return")

        return success("Cr004_04Return");
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
    public void displayControl(Model model, Cr004_05Form form, HttpServletRequest request) {

    }
}