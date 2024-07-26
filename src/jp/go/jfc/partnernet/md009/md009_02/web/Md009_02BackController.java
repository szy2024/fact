//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_02BackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.md009.common.Md009Constants;

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
 * このクラスはMd009_02の戻るボタンコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md009_02Form")
@RequestMapping(value = "/Md009_02Back.form")
public class Md009_02BackController extends Md009_02BaseController {

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
    public String executeAction(Model model, Md009_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 処理モード毎に、呼出元の画面へ遷移する。

        // 処理モードが　処理完了以外更正(赤）：取消(5)　の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(form.getProcessMode())) {
            // 　　戻り値（画面遷移情報）に報告書検索結果画面を設定する。
            // 　　 return success("Md000_02Return")
            return success(Md009Constants.EVENT_ID_MD000_02RETURN);
        }

        // 処理モードが　処理完了：取消(1)、　処理完了：修正(2)、　処理完了以外：取消(3)、　処理完了以外：修正(4)　の場合
        // 　　戻り値（画面遷移情報）に留置期間利息・代弁遅延損害金受入充当報告書取消・修正（入力画面）を設定する。
        // 　 return success("Md009_01Return")
        return success(Md009Constants.EVENT_ID_MD009_01RETURN);
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
    public void displayControl(Model model, Md009_02Form form, HttpServletRequest request) {

    }
}