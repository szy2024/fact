//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : se016_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se016.se016_01.web;

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
public class Se016_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se016_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se016_01InitController.class)
    public void initValidate(Se016_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 検索ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se016_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se016_01SearchController.class)
    public void searchValidate(Se016_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * ダウンロードボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Se016_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Se016_01DownloadController.class)
    public void downloadValidate(Se016_01Form form, Errors errors, Model model,
            HttpServletRequest request) {

    }

}