//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_02UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cm001.cm001_02.service.Cm001_02DTO;
import jp.go.jfc.partnernet.cm001.cm001_02.service.Cm001_02Service;
import jp.go.jfc.partnernet.cm001.common.Cm001Constants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;
import com.fujitsu.crust.web.util.CFWRequestUtils;

/**
 * <pre>
 * このクラスはcm001_02の更新ボタンコントローラークラスです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cm001_02Form")
@RequestMapping(value = "/Cm001_02Update.form")
public class Cm001_02UpdateController extends Cm001_02BaseController {
    /** Log */
    private static Log log = LogFactory.getLog(Cm001_02InitController.class);

    /** Cm001_02Service */
    @Autowired
    Cm001_02Service cm001_02service;

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
    public String executeAction(Model model, Cm001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        log.debug("@@@@Cm001_02UpdateController");

        // セッションより共通情報（PNCommonInfo）を取得する。
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();

        // サービスへの受け渡し項目をCm001_02DTOに設定する。
        Cm001_02DTO inDTO = new Cm001_02DTO();
        // ・セッション共通情報（PNCommonInfo）.利用者ID(LogonID)　→　DTO.利用者ID
        inDTO.setLogonID(loginInfo.getLogonID());
        // ・画面.パスワード　→　DTO.パスワード
        inDTO.setPasswordNew(form.getPasswordNew());

        // update
        Cm001_02DTO outDTO = cm001_02service.update(inDTO);

        // 共通情報（PNCommonInfo）を更新する。
        // ・DTO.パスワード　→　パスワード　※SHA-256でハッシュ済み
        loginInfo.setPassword(outDTO.getPasswordNew());
        // ・DTO.パスワード有効期限メッセージ　→　パスワード有効期限メッセージ
        loginInfo.setPasswordValidMsg(outDTO.getPasswordValidMsg());
        log.debug("<-------------------------------------------------------->");
        log.debug("利用者ID[" + loginInfo.getLogonID() + "]");
        log.debug("パスワード（ハッシュ済み）[" + loginInfo.getPassword() + "]");
        log.debug("利用者名（漢字）[" + loginInfo.getName_Kanji() + "]");
        log.debug("扱店コード[" + loginInfo.getCode_Organization() + "]");
        log.debug("扱店名[" + loginInfo.getName_Organization() + "]");
        log.debug("権限種別[" + loginInfo.getRoleCode() + "]");
        log.debug("最終ログオン日時[" + loginInfo.getDateTime_LastLogon() + "]");
        log.debug("<-------------------------------------------------------->");

        // セッションに共通情報（PNCommonInfo）を登録する。
        CFWRequestUtils.setSessionAttribute(request, PNCommonInfo.SESSION_COMMON_INFO_KEY, loginInfo);
        PNCommonInfoHolder.setCommonInfo(loginInfo);

        // 遷移先画面IDを設定する。
        // ・遷移先画面ID ・・・ Success(Ut001_01Init)　※お知らせ（お知らせ結果表示）画面初期表示
        return success(Cm001Constants.EVENT_ID_UT001_01INIT);
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