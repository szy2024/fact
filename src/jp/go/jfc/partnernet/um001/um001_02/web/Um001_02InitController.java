//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustAnytimeExecute;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはUm001_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("um001_02Form")
@RequestMapping(value = "/Um001_02Init.form")
@CrustAnytimeExecute
public class Um001_02InitController extends Um001_02BaseController {

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
    public String executeAction(Model model, Um001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // フォームを初期化する。
        // 　検索扱店　　　　　　　　 ：　空値
        form.setSrcCode_Organization("");

        // 　検索利用者ＩＤ　　　 　　：　空値
        form.setSrcLogonID("");

        // 　利用者一覧　　　　　 　 ：　初期化
        form.getUm001_02M1Table().reset();

        // 戻り値（画面遷移情報）に自画面を設定する。
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
    public void displayControl(Model model, Um001_02Form form, HttpServletRequest request) {

        // 利用者明細
        form.setVisible("um001_02M1Table", false);

        // 送信ボタン
        form.setVisible("btnSend", false);

    }
}