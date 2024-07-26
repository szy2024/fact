//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : cr010_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.web;

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
 * @author 林　晃平
 * @version 2.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cr010_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr010_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr010_01InitController.class)
    public void initValidate(Cr010_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 登録ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr010_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr010_01UpdateController.class)
    public void updateValidate(Cr010_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 依頼予定額変更イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr010_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr010_01ChangeIraiController.class)
    public void changeIraiValidate(Cr010_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 元金充当額変更イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cr010_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cr010_01ChangeGanjuController.class)
    public void changeGanjuValidate(Cr010_01Form form, Errors errors,
            Model model, HttpServletRequest request) {

    }

}