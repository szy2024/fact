//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se015_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/24 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se015.se015_01.web;

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
 * @author 嶋田　美保
 * @version 2.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se015_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se015_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se015_01InitController.class)
    public void initValidate(Se015_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * Excel出力ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se015_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se015_01ExcelOutController.class)
    public void excelOutValidate(Se015_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

}