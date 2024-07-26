//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_06Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/23 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_06.web;

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
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se006_06Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se006_06Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se006_06InitController.class)
    public void initValidate(Se006_06Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se006_06Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se006_06BackController.class)
    public void backValidate(Se006_06Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}