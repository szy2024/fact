//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_15BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/04 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_15.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.se006.common.Se006Constants;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはse006_15の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_15Form")
@RequestMapping(value = "/Se006_15Back.form")
public class Se006_15BackController extends Se006_15BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see com.fujitsu.xcmfw.web.control.XCMNormalBaseController#executeAction(org.springframework.ui.Model,
     *      com.fujitsu.xcmfw.web.form.XCMBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_15Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 報告書履歴検索結果画面(se006_02)へ戻る
        // 　se006_02：報告書情報照会（報告書履歴検索結果画面）
        // return success("Se006_02Return")
        return success(Se006Constants.EVENT_ID_SE006_02RETURN);

    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see com.fujitsu.xcmfw.web.control.XCMNormalBaseController#displayControl(org.springframework.ui.Model,
     *      com.fujitsu.xcmfw.web.form.XCMBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se006_15Form form,
            HttpServletRequest request) {

    }
}