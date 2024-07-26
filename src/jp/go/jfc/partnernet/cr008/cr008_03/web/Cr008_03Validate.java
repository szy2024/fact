//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_03Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_03.web;

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
 * @author 石川　真理
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cr008_03Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr008_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr008_03InitController.class)
    public void initValidate(Cr008_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 融資番号アンカーイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr008_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr008_03AnchorController.class)
    public void anchorValidate(Cr008_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr008_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr008_03BackController.class)
    public void backValidate(Cr008_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 戻り表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr008_03Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr008_03InitBackController.class)
    public void initbackValidate(Cr008_03Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}