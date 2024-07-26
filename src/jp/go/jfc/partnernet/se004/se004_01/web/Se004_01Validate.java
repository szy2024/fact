//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.web;

import javax.servlet.http.HttpServletRequest;

import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import com.fujitsu.crust.web.annotation.CrustValidationTarget;

/**
 * <pre>
 * このクラスは画面固有の入力チェッククラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se004_01Validate extends PNBaseValidator {

	/**
	 *
	 * <pre>
	 * 初期表示イベント固有の入力チェックを行ないます。
	 * </pre>
	 *
	 * @param form
	 *            Se004_01Form
	 * @param errors
	 *            Errors
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 */
	@CrustValidationTarget(Se004_01InitController.class)
	public void initValidate(Se004_01Form form, Errors errors, Model model,
			HttpServletRequest request) {

	}

	/**
	 *
	 * <pre>
	 * 検索ボタンチェックイベント固有の入力チェックを行ないます。
	 * </pre>
	 *
	 * @param form
	 *            Se004_01Form
	 * @param errors
	 *            Errors
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 */
	@CrustValidationTarget(Se004_01SearchController.class)
	public void searchValidate(Se004_01Form form, Errors errors, Model model,
			HttpServletRequest request) {

	}

	/**
	 *
	 * <pre>
	 * 戻り表示イベント固有の入力チェックを行ないます。
	 * </pre>
	 *
	 * @param form
	 *            Se004_01Form
	 * @param errors
	 *            Errors
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 */
	@CrustValidationTarget(Se004_01ReturnController.class)
	public void returnValidate(Se004_01Form form, Errors errors, Model model,
			HttpServletRequest request) {

	}

}