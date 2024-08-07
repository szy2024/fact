//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_02Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_02.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;
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
public class Md005_02Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md005_02Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md005_02InitController.class)
    public void initValidate(Md005_02Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 登録ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md005_02Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md005_02CreateController.class)
    public void createValidate(Md005_02Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md005_02Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md005_02BackController.class)
    public void backValidate(Md005_02Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}