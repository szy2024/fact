//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 青本　信吉            | 新規作成
// 4.0.0   | 2020/11/30 | 番場　千沙都          | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_02.web;

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

import jp.go.jfc.partnernet.se009.common.Se009Constants;

/**
 * <pre>
 * このクラスはSe009_02の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 番場　千沙都
 * @version 4.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se009_02Form")
@RequestMapping(value = "/Se009_02Back.form")
public class Se009_02BackController extends Se009_02BaseController {

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
    public String executeAction(Model model, Se009_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 控除利息計算シミュレーション（条件入力画面）へ遷移

        addForwardParameter(request, Se009Constants.ERROR_KOUJORISOKU, false);
// [ADD] Ver 4.0.0 - START
		addForwardParameter(request, Se009Constants.ERROR_YAKUJORISOKU, false);
// [ADD] Ver 4.0.0 - END
        return success(Se009Constants.EVENT_ID_SE009_01RETURN);

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
    public void displayControl(Model model, Se009_02Form form, HttpServletRequest request) {

    }
}