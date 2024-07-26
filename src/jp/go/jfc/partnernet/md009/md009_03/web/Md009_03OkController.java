//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_03OkController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_03.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.md009.common.Md009Constants;

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
 * このクラスはMd009_03のOKボタンコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md009_03Form")
@RequestMapping(value = "/Md009_03Ok.form")
public class Md009_03OkController extends Md009_03BaseController {

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
    public String executeAction(Model model, Md009_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 戻り値（画面遷移情報）に報告書検索画面を設定する。
        // 　return success("Md000_02Init")
        return success(Md009Constants.EVENT_ID_MD000_02INIT);
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
    public void displayControl(Model model, Md009_03Form form, HttpServletRequest request) {

    }
}