//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr003.common.Cr003Constants;

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
 * このクラスはCr003_02の戻るコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr003_02Form")
@RequestMapping(value = "/Cr003_02Back.form")
public class Cr003_02BackController extends Cr003_02BaseController {

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
    public String executeAction(Model model, Cr003_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 元利金受入・充当報告書作成(払込期日入力画面)へ遷移
        // 　return success("Cr003_01Return")
        return success(Cr003Constants.EVENT_ID_CR003_01RETURN);
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
    public void displayControl(Model model, Cr003_02Form form, HttpServletRequest request) {

    }
}