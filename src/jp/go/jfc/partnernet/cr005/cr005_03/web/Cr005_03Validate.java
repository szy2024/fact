//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.web;

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
public class Cr005_03Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr005_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr005_03InitController.class)
    public void initValidate(Cr005_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 債権管理番号アンカーイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr005_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr005_03AnchorController.class)
    public void anchorValidate(Cr005_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻るイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr005_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr005_03BackController.class)
    public void backValidate(Cr005_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻り表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr005_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr005_03ReturnController.class)
    public void returnValidate(Cr005_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}