//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_03Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_03.web;

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
public class Md004_03Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md004_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md004_03InitController.class)
    public void initValidate(Md004_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * OKボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md004_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md004_03OkController.class)
    public void okValidate(Md004_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}