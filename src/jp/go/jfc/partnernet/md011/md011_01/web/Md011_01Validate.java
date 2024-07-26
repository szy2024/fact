//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : md011_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.web;

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
 * @author 林　晃平
 * @version 2.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Md011_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md011_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md011_01InitController.class)
    public void initValidate(Md011_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 登録ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md011_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md011_01UpdateController.class)
    public void updateValidate(Md011_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md011_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md011_01BackController.class)
    public void backValidate(Md011_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 資金払出予定額変更イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md011_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md011_01ChangeYoteiController.class)
    public void changeYoteiValidate(Md011_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 元金充当額変更イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md011_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md011_01ChangeGanjuController.class)
    public void changeGanjuValidate(Md011_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

}