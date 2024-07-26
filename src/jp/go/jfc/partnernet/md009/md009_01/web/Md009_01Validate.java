//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_01.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;

import com.fujitsu.crust.web.annotation.CrustValidationTarget;

/**
 * <pre>
 * このクラスは画面固有の入力チェッククラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Md009_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md009_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md009_01InitController.class)
    public void initValidate(Md009_01Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 送信ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md009_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md009_01SendController.class)
    public void sendValidate(Md009_01Form form, Errors errors, Model model, HttpServletRequest request) {

        // 処理モード
        String processMode = form.getProcessMode();
        // 更正(赤)タイトル
        String redAreaTitle = form.getRedAreaTitle();
        // 更正(黒)タイトル
        String blackAreaTitle = form.getBlackAreaTitle();
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)
                || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            redAreaTitle = redAreaTitle + " 赤";
        }

        // 処理モードが「処理完了：取消(1)」、「処理完了：修正(2)」、「処理完了以外：取消(3)」の場合
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)
                || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {

            // 更正(赤)受託者勘定処理年月 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Date_Jtkshori_Year_Input_Red())
                    || StringUtils.isEmpty(form.getDrpID_Date_Jtkshori_Month_Red())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{redAreaTitle + "受託者勘定処理年月"}, false);
            }

        }

        // 処理モードが　処理完了：修正(2)　処理完了以外：修正(4)　の場合
        if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {

            // 公庫支店 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Code_ShokanHonShiten())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{blackAreaTitle + "公庫支店"}, false);
            }

            // 入金日 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Date_Nyukin_Year_Input())
                    || StringUtils.isEmpty(form.getDrpID_Date_Nyukin_Month())
                    || StringUtils.isEmpty(form.getDrpID_Date_Nyukin_Day())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{blackAreaTitle + "入金日"}, false);
            }

            // 送金年月日 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Date_Sokin_Year_Input())
                    || StringUtils.isEmpty(form.getDrpID_Date_Sokin_Month())
                    || StringUtils.isEmpty(form.getDrpID_Date_Sokin_Day())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{blackAreaTitle + "送金年月日"}, false);
            }

            // 送金日番号 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Code_Sokin())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{blackAreaTitle + "送金日番号"}, false);
            }

            // 更正(黒)受託者勘定処理年月 必須チェック
            if (StringUtils.isEmpty(form.getTxtID_Date_Jtkshori_Year_Input())
                    || StringUtils.isEmpty(form.getDrpID_Date_Jtkshori_Month())) {
                addMessage(PNCommonMessageConstants.PM3120E, new String[]{blackAreaTitle + "受託者勘定処理年月"},
                        false);
            }

        }

    }

    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md009_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md009_01BackController.class)
    public void backValidate(Md009_01Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 戻り表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Md009_01Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Md009_01ReturnController.class)
    public void returnValidate(Md009_01Form form, Errors errors, Model model, HttpServletRequest request) {

    }

}