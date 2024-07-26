//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.se010.common.Se010Constants;

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
 * このクラスはSe010_02の戻り表示コントローラークラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se010_02form")
@RequestMapping(value = "/Se010_02Back.form")
public class Se010_02BackController extends Se010_02BaseController {

	/**
	 * <pre>
	 * 初期表示の処理を行います。
	 * </pre>
	 *
	 * {@inheritDoc}
	 *
	 * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
	 *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
	 *      org.springframework.validation.Errors,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String executeAction(Model model, Se010_02Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response) {

		// 繰上償還利息等計算シミュレーション（条件入力画面）へ遷移
		return success(Se010Constants.EVENT_ID_SE010_01RETURN);
	}

	/**
	 * <pre>
	 * 初期表示時の画面制御を行います。
	 * </pre>
	 *
	 * {@inheritDoc}
	 *
	 * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
	 *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void displayControl(Model model, Se010_02Form form,
			HttpServletRequest request) {

	}
}