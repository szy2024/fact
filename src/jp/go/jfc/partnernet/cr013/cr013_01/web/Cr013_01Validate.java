//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : cr013_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.web;

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
 * @author 木村　しのぶ
 * @version 2.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cr013_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form
     *            Cr013_01Form
     * @param errors
     *            Errors
     * @param model
     *            Model
     * @param request
     *            HttpServletRequest
     */
    @CrustValidationTarget(Cr013_01InitController.class)
    public void initValidate(Cr013_01Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 登録ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form
     *            Cr013_01Form
     * @param errors
     *            Errors
     * @param model
     *            Model
     * @param request
     *            HttpServletRequest
     */
    @CrustValidationTarget(Cr013_01UpdateController.class)
    public void updateValidate(Cr013_01Form form, Errors errors, Model model, HttpServletRequest request) {

    }

}