//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_01ChangePasswordController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
// 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cm001.cm001_01.service.Cm001_01DTO;
import jp.go.jfc.partnernet.cm001.cm001_01.service.Cm001_01Service;
import jp.go.jfc.partnernet.cm001.common.Cm001Constants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;

import org.apache.commons.lang.builder.ToStringBuilder;
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
 * このクラスはcm001_01のパスワード変更ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cm001_01Form")
@RequestMapping(value = "/Cm001_01ChangePassword.form")
public class Cm001_01ChangePasswordController extends Cm001_01BaseController {
    /** Log */
    private static Log log = LogFactory.getLog(Cm001_01ChangePasswordController.class);

    /** Cm001_01Service */
    @Autowired
    Cm001_01Service cm001_01service;

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
    public String executeAction(Model model, Cm001_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        log.debug("@@@@Cm001_01ChangePasswordController");

        // 画面入力項目をCm001_01DTOに設定する。
        Cm001_01DTO inDTO = new Cm001_01DTO();
        // ・"changePassword"　→　発生元イベント名
        inDTO.setEventName(Cm001Constants.EVENT_NAME_CHANGEPW);
        // ・画面.利用者ID → 利用者ID
        inDTO.setLogonID(form.getLogonID());
        // ・画面.パスワード　→　パスワード（入力）
        inDTO.setPassword(form.getPassword());

        // logon
        Cm001_01DTO outDTO = cm001_01service.logon(inDTO);

        // 利用者情報をセッションに保存する。

        // セッションを無効化する。
        request.getSession().invalidate();

        // セッションを初期化する。
        request.getSession(true);
        log.debug("ログイン成功");

        // セッションに PNUserSessionInfo を設定する。
        // ・保存キー　・・・　pnUserSessionInfo
        PNCommonInfo loginInfo = new PNCommonInfo();

        // 　・DTO.利用者ID　→　利用者ID
        loginInfo.setLogonID(outDTO.getLogonID());
        // 　・DTO.パスワード　→　パスワード　※SHA-256でハッシュ済み
        loginInfo.setPassword(outDTO.getPassword());
        // 　・DTO.利用者名（漢字）　→　利用者名（漢字）
        loginInfo.setName_Kanji(outDTO.getName_Kanji());
        // 　・DTO.扱店コード　→　扱店コード
        loginInfo.setCode_Organization(outDTO.getCode_Organization());
        // 　・DTO.店舗コード　→　店舗コード
        loginInfo.setCode_Tenpo(outDTO.getCode_Tenpo());
        // 　・DTO.扱店名　→　扱店名
        loginInfo.setName_Organization(outDTO.getName_Organization());
        // 　・DTO.権限種別　→　権限種別
        loginInfo.setRoleCode(outDTO.getRoleCode());
        // 　・DTO.最終ログオン日時　→　最終ログオン日時
        loginInfo.setDateTime_LastLogon(outDTO.getDateTime_LastLogon());
        // 　・DTO.最終ログオン日時(今回)　→　最終ログオン日時(今回)
        loginInfo.setDateTime_NewLastLogon(outDTO.getDateTime_NewLastLogon());
        // 　・DTO.パスワード有効期限メッセージ　→　パスワード有効期限メッセージ
        loginInfo.setPasswordValidMsg(outDTO.getPasswordValidMsg());

        CFWRequestUtils.setSessionAttribute(request, PNCommonInfo.SESSION_COMMON_INFO_KEY, loginInfo);
        PNCommonInfoHolder.setCommonInfo(loginInfo);

        log.debug("<-------------------------------------------------------->");
        log.debug("利用者ID[" + loginInfo.getLogonID() + "]");
        log.debug("パスワード（ハッシュ済み）[" + loginInfo.getPassword() + "]");
        log.debug("利用者名（漢字）[" + loginInfo.getName_Kanji() + "]");
        log.debug("扱店コード[" + loginInfo.getCode_Organization() + "]");
        log.debug("店舗コード[" + loginInfo.getCode_Tenpo() + "]");
        log.debug("扱店名[" + loginInfo.getName_Organization() + "]");
        log.debug("権限種別[" + loginInfo.getRoleCode() + "]");
        log.debug("最終ログオン日時[" + loginInfo.getDateTime_LastLogon() + "]");
        log.debug("最終ログオン日時(今回)[" + loginInfo.getDateTime_NewLastLogon() + "]");
        log.debug("<-------------------------------------------------------->");

        PNCommonInfo loginInfo2 = PNCommonInfoHolder.getCommonInfo();
        log.debug("loginInfo2=" + ToStringBuilder.reflectionToString(loginInfo2));

        // 遷移先画面を決定し、遷移パラメタの設定を行う。

        // 　DTO.パスワード変更時遷移理由　→　reason
        // 次画面への引き渡し情報設定
        setRequestNextScreen(request, outDTO);

        // return MY_VIEW;
        return success(Cm001Constants.EVENT_ID_CM001_01CHANGEPASSWORD);
    }

    /**
     * <pre>
     * 次画面への引き渡し情報設定
     * </pre>
     *
     * @param request
     * @param prmDTO
     */
    private void setRequestNextScreen(HttpServletRequest request, Cm001_01DTO prmDTO) {
        // パスワード変更事由
        CFWRequestUtils.setSessionAttribute(request, Cm001Constants.PROPERTY_REASON, prmDTO.getReason());

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
    public void displayControl(Model model, Cm001_01Form form, HttpServletRequest request) {

    }
}