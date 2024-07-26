//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.md005.common.Md005Constants;

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
 * このクラスはmd005_02の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md005_02Form")
@RequestMapping(value = "/Md005_02Back.form")
public class Md005_02BackController extends Md005_02BaseController {

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
	public String executeAction(Model model, Md005_02Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response) {

		// 遷移画面を変更する。
		if (Md000Constants.PROCESS_MODE_5.equals(form.getProcessMode())) {
			// 　処理モードが処理完了以外：取消(5)(更正(赤))の場合
			// 　　報告書検索結果画面へ遷移
			// 　　報告書検索結果画面を呼出す。
			// 　　　md000_02:報告書検索結果画面
			return success(Md005Constants.EVENT_ID_MD000_02INIT);
		} else {
			// 　処理モードが上記以外の場合
			// 代位弁済金払込・充当報告書取消・修正（入力画面）へ遷移
			// 代位弁済金払込・充当報告書取消・修正（入力画面）を呼出す。
			// 　　md005_01:代位弁済金払込・充当報告書取消・修正（入力画面）
			return success(Md005Constants.EVENT_ID_MD005_01RETURN);
		}
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
	public void displayControl(Model model, Md005_02Form form,
			HttpServletRequest request) {

	}
}