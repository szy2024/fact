//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;

import org.springframework.beans.factory.annotation.Autowired;
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
 * このクラスはmd006_02の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md006_02Form")
@RequestMapping(value = "/Md006_02Back.form")
public class Md006_02BackController extends Md006_02BaseController {

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
    public String executeAction(Model model, Md006_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 処理モード毎に、呼出元の画面へ遷移する。

        if (!form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL)) {
            // 　処理モードが、処理完了：取消(1)、処理完了：修正(2)、処理完了以外：取消(3)、処理完了以外：修正(4)の場合
            // 　　貸付実行報告書取消・修正（入力画面）へ遷移
            // 　　　　md006_01:貸付実行報告書取消・修正（入力画面）
            return success("Md006_01Return");
        } else {
            // 　処理モードが、処理完了以外：取消更正(赤)(5)の場合
            // 　　報告書検索結果画面へ遷移
            // 　　　md000_02:報告書検索結果画面
            return success("Md000_02Return");
        }
        // return MY_VIEW;
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
    public void displayControl(Model model, Md006_02Form form, HttpServletRequest request) {

    }
}