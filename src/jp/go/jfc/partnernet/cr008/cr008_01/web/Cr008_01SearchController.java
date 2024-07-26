//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr008.common.Cr008Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr008_01の検索ボタンコントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_01Form")
@RequestMapping(value = "/Cr008_01Search.form")
public class Cr008_01SearchController extends Cr008_01BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_01SearchController.class);

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Cr008_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
        // 　　return MY_VIEW

        // 仮受金（一般口）受入報告書作成（顧客名検索結果画面）へ遷移する
        // 　顧客名入力値を遷移パラメータに設定する。
        addForwardParameter(request, Cr008Constants.PROPERTY_NAME_CUSTOMER, form.getTxtID_Name_Customer());

        log.debug("--- 受渡パラメータ start ---");
        log.debug("顧客名:" + form.getTxtID_Name_Customer());
        log.debug("--- 受渡パラメータ end ---");

        return success("Cr008_02Init");

    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Cr008_01Form form, HttpServletRequest request) {

    }
}