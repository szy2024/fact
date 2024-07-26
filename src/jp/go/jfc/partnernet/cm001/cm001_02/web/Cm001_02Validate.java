//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_02Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_02.web;

import javax.servlet.http.HttpServletRequest;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import com.fujitsu.crust.common.CFWPasswordUtil;
import com.fujitsu.crust.web.annotation.CrustValidationTarget;

/**
 * <pre>
 * このクラスは画面固有の入力チェッククラスです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cm001_02Validate extends PNBaseValidator {
    /** Log */
    private static Log log = LogFactory.getLog(Cm001_02Validate.class);

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cm001_02Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cm001_02InitController.class)
    public void initValidate(Cm001_02Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 更新ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Cm001_02Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Cm001_02UpdateController.class)
    public void updateValidate(Cm001_02Form form, Errors errors, Model model, HttpServletRequest request) {
        log.debug("@@@@updateValidate");

        // 古いパスワードをSHA-256でハッシュ化する
        // 　・画面.古いパスワード
        String srcOldPwhashValue = CFWPasswordUtil.createHashVal(form.getPassword());

        // セッションより共通情報（PNCommonInfo）を取得する。
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        log.debug("loginInfo=" + ToStringBuilder.reflectionToString(loginInfo));

        // 1. 古いパスワード相違
        // 古いパスワード（SHA-256でハッシュ化済み）　≠　セッション情報.パスワードの場合、エラーとする。
        if (!srcOldPwhashValue.equals(loginInfo.getPassword())) {
            // 　・メッセージ：PM3070E　「古いパスワードが誤りです。」
            addMessage(PNCommonMessageConstants.PM3070E, null);
        }

        // 2. 前回パスワードと同じ
        // 画面.古いパスワード　＝　画面.パスワードの場合、エラーとする。
        if (form.getPassword().equals(form.getPasswordNew())) {
            // 　・メッセージ：PM3040E　「前回と同じパスワードは使えません。」
            addMessage(PNCommonMessageConstants.PM3040E, null);
        }

        // 3. ユーザIDとパスワードが同じ
        // セッション情報.ユーザIDを小文字に変換する。
        // 画面.パスワードを小文字に変換する。
        String lcLogonID = loginInfo.getLogonID().toLowerCase();
        String lcPasswordNew = form.getPasswordNew().toLowerCase();
        // セッション情報.ユーザID（小文字変換後）　＝　画面.パスワード（小文字変換後）の場合、エラーとする。
        if (lcLogonID.equals(lcPasswordNew)) {
            // 　・メッセージ：PM3930E　「ユーザIDと同じパスワードは使えません。」
            addMessage(PNCommonMessageConstants.PM3930E, null);
        }

        // 4. パスワード最低文字数
        // 画面.パスワードの長さ　＜　システム設定値（パスワード最低長）の場合、エラーとする。
        String min_length = PNResourceBundle.getString(PNResourceBundle.APPLICATION_PROP,
                "password_min_length");
        if (form.getPasswordNew().length() < Integer.valueOf(min_length)) {
            StringBuffer sbMsg = new StringBuffer(255);
            sbMsg.append("新しいパスワードには");
            sbMsg.append(min_length);
            sbMsg.append("文字以上を");
            // 　・メッセージ：PM3110E　「新しいパスワードには{0}文字以上指定してください。」　※{0} ・・・ システム設定値（パスワード最低長）
            addMessage(PNCommonMessageConstants.PM3110E, new String[]{sbMsg.toString()}, false);
        }

        // 5. パスワード最大文字数
        // 画面.パスワードの長さ　＞　システム設定値（パスワード最大長）の場合、エラーとする。
        String max_length = PNResourceBundle.getString(PNResourceBundle.APPLICATION_PROP,
                "password_max_length");
        if (form.getPasswordNew().length() > Integer.valueOf(max_length)) {
            StringBuffer sbMsg = new StringBuffer(255);
            sbMsg.append("新しいパスワードには");
            sbMsg.append(max_length);
            sbMsg.append("文字以下を");
            // 　メッセージ：PM3110E　「新しいパスワードには{0}文字以下を指定してください。」　※{0} ・・・ システム設定値（パスワード最大長）
            addMessage(PNCommonMessageConstants.PM3110E, new String[]{sbMsg.toString()}, false);
        }
        //
        // 6. パスワード複雑度
        // 下記いずれかの文字が一つ以上含まれること。含まれない場合、エラーとする。
        // ・半角数字(0-9)
        // ・半角英字(a-zA-Z)
        if (form.getPasswordNew().matches("[0-9]+") || form.getPasswordNew().matches("[a-zA-Z]+")) {
            // 　・メッセージ：PM3060E　「新しいパスワードには半角英字と半角数字をそれぞれ一文字以上含めてください。」
            addMessage(PNCommonMessageConstants.PM3060E, null);
        }
        //
        // 7. パスワードの確認との相違
        // 画面.パスワード　≠　画面.パスワードの確認　の場合、エラーとする。
        if (!form.getPasswordNew().equals(form.getPasswordConfirm())) {
            // 　・メッセージ：PM3050E　「パスワードとパスワードの確認が異なります。」
            addMessage(PNCommonMessageConstants.PM3050E, null);
        }
    }
}