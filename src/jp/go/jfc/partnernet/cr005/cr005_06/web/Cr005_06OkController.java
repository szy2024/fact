//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_06OkController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_06.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr005.common.Cr005Constants;

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
 * このクラスはcr005_06のOKコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_06Form")
@RequestMapping(value = "/Cr005_06Ok.form")
public class Cr005_06OkController extends Cr005_06BaseController {

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
	public String executeAction(Model model, Cr005_06Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response) {

		// cr005_01(代位弁済金払込・充当報告書作成（顧客名、融資番号入力画面）)へ遷移する。

		// return success("Cr005_01Return")

		return success(Cr005Constants.EVENT_ID_CR005_01RETURN);
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
	public void displayControl(Model model, Cr005_06Form form,
			HttpServletRequest request) {

	}
}