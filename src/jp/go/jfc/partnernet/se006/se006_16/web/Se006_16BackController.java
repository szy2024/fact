//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_16BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.web;

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
 * このクラスはse006_16の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_16Form")
@RequestMapping(value = "/Se006_16Back.form")
public class Se006_16BackController extends Se006_16BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_16Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 報告書履歴検索結果画面(se006_02)へ戻る
        // 　　戻り値（画面遷移情報）に報告書情報照会（報告書履歴検索結果画面）を設定する。
        return success(Se006Constants.EVENT_ID_SE006_02RETURN);
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
    public void displayControl(Model model, Se006_16Form form,
            HttpServletRequest request) {

    }
}