//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.web;

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
public class Se008_02Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期処理イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se008_02Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se008_02InitController.class)
    public void initValidate(Se008_02Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se008_02Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se008_02BackController.class)
    public void backValidate(Se008_02Form form, Errors errors, Model model, HttpServletRequest request) {

    }

}