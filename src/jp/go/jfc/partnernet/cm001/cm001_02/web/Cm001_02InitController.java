//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cm001.common.Cm001Constants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.util.CFWRequestUtils;

/**
 * <pre>
 * このクラスはcm001_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
// @CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cm001_02Form")
@RequestMapping(value = "/Cm001_02Init.form")
public class Cm001_02InitController extends Cm001_02BaseController {
    /** Log */
    private static Log log = LogFactory.getLog(Cm001_02InitController.class);

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @throws Exception
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Cm001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        log.debug("@@@@Cm001_02InitController_executeAction");
        PNCommonInfo loginInfo2 = PNCommonInfoHolder.getCommonInfo();
        log.debug("loginInfo2=" + ToStringBuilder.reflectionToString(loginInfo2));

        // ・セッションパラメタ名　・・・　param.reason
        String reason = (String) CFWRequestUtils.getSessionAttribute(request, Cm001Constants.PROPERTY_REASON);
        if (null == reason) {
            reason = Cm001Constants.PASSWORD_CHANGE_REASON_CHANGE_PASSWORD;
        }
        // 破棄
        request.getSession().removeAttribute(Cm001Constants.PROPERTY_REASON);

        // メッセージの設定を行う。
        if (reason.equals(Cm001Constants.PASSWORD_CHANGE_REASON_CHANGE_PASSWORD)) {
            // ・セッションパラメタ　＝　"changepassword" の場合
            // 　PM1090I : パスワードを変更してください。
            addMessage(errors, PNCommonMessageConstants.PM1090I);
        } else if (reason.equals(Cm001Constants.PASSWORD_CHANGE_REASON_PASSWORD_EXPIRATION)) {
            // ・セッションパラメタ　＝　"passwordexpired" の場合
            // 　PM1100I : パスワードの有効期限が切れました。パスワードを変更してください。
            addMessage(errors, PNCommonMessageConstants.PM1100I);
            // ・キャンセルボタンを非表示にする
            form.setVisible(Cm001Constants.PROPERTY_BTNID_CANCEL, false);
        } else if (reason.equals(Cm001Constants.PASSWORD_CHANGE_REASON_FIRST_LOGON)) {
            // ・セッションパラメタ　＝　"firstlogon" の場合
            // 　PM1110I : 初回ログオン時にはパスワードの変更が必要です。パスワードを変更してください。
            addMessage(errors, PNCommonMessageConstants.PM1110I);
            // ・キャンセルボタンを非表示にする
            form.setVisible(Cm001Constants.PROPERTY_BTNID_CANCEL, false);
        }

        return MY_VIEW;
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
    public void displayControl(Model model, Cm001_02Form form, HttpServletRequest request) {

    }
}