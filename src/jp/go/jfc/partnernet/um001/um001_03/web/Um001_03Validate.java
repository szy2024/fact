//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_03Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 松井　元気            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_03.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;
import jp.go.jfc.partnernet.um001.common.Um001Constants;

import com.fujitsu.crust.web.annotation.CrustValidationTarget;

/**
 * <pre>
 * このクラスは画面固有の入力チェッククラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Um001_03Validate extends PNBaseValidator {

    /** CFWJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Um001_03Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Um001_03InitController.class)
    public void initValidate(Um001_03Form form, Errors errors, Model model, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 変更ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Um001_03Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Um001_03UpdateController.class)
    public void updateValidate(Um001_03Form form, Errors errors, Model model, HttpServletRequest request) {

        // 利用開始日西暦変換
        int startMonth = Integer.parseInt(form.getDate_UseStartMonth());
        int startDay = Integer.parseInt(form.getDate_UseStartDate());
        String inGengo = form.getDate_UseStartGengo();
        String inYear = form.getDate_UseStartYear();
        String inMonth = PNFormatUtils.intFormat(startMonth, PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2);
        String inDay = PNFormatUtils.intFormat(startDay, PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2);
        String startDate = jpCalendarUtils.toSeireki(inGengo, inYear, inMonth, inDay);

        // パスワードとユーザIDが同じでないかチェック
        // 　・ユーザIDを小文字へ変換する。
        // 　・パスワードを小文字へ変換する。
        String lcLogonID = form.getLogonID().toLowerCase();
        String lcPasswordNew = form.getPassword().toLowerCase();
        // ユーザID（小文字変換後）　＝　パスワード（小文字変換後）の場合、エラーとする。
        if (lcLogonID.equals(lcPasswordNew)) {
            // 　・メッセージ：PM3930E　「ユーザIDと同じパスワードは使えません。」
            addMessage(PNCommonMessageConstants.PM3930E, null);
        }

        // パスワード有効日数 必須チェック
        if (Um001Constants.FLAG_FORCECHGPWDROUTINE_1 == PNCommonComponents.cnvNulltoZero(form
                .getFlag_ForceChgPwdRoutine()) && StringUtils.isEmpty(form.getNum_PwdValidDays())) {
            addMessage(PNCommonMessageConstants.PM3120E, new String[] { "パスワード有効日数に数値" }, false);
        }

        // パスワード複雑度チェック
        if (StringUtils.isNotEmpty(form.getPassword())
                && !(form.getPassword().matches(".*[a-zA-Z]+.*") && form.getPassword().matches(".*[0-9]+.*"))) {
            addMessage(PNCommonMessageConstants.PM3060E, null);
        }

        // Ｓ６４年チェック
        if (Um001Constants.GENGO_SHOWA.equals(form.getDate_UseStartGengo())
                && Um001Constants.YEAR_64.equals(form.getDate_UseStartYear())) {
            addMessage(PNCommonMessageConstants.PM3290E, null);
        }

        // 元号昭和年チェック
        if (Um001Constants.GENGO_SHOWA.equals(form.getDate_UseStartGengo())
                && 0 > Um001Constants.YEAR_64.compareTo(form.getDate_UseStartYear())) {
            addMessage(PNCommonMessageConstants.PM3230E, new String[] { "利用開始日" }, false);
        }

        // 利用開始日実在日チェック
        if (!(Um001Constants.GENGO_SHOWA.equals(form.getDate_UseStartGengo()) && 0 >= Um001Constants.YEAR_64
                .compareTo(form.getDate_UseStartYear())) && StringUtils.isEmpty(startDate)) {
            addMessage(PNCommonMessageConstants.PM3220E, new String[] { "利用開始日" }, false);
        }

        // パスワード確認チェック
        if (StringUtils.isNotEmpty(form.getPassword())
                && !form.getPassword().equals(form.getPasswordConfirm())) {
            addMessage(PNCommonMessageConstants.PM3020E, null);
        }

        // 店舗コード必須チェック
        // 権限種別が農林中金（支店） かつ 店舗コードが未入力の場合、エラーとする。
        if (PNCommonConstants.ROLECODE_NOURINSHITEN.equals(form.getRoleCode())
                && form.getCode_Tenpo().isEmpty()) {
            addMessage(PNCommonMessageConstants.PM3120E, new String[] { "店舗" }, false);
        }

        // 店舗コード不正チェック
        // 権限種別が農林中金（支店）以外 かつ 店舗コードが入力されている場合、エラーとする。
        if (!PNCommonConstants.ROLECODE_NOURINSHITEN.equals(form.getRoleCode())
                && !form.getCode_Tenpo().isEmpty()) {
            addMessage(PNCommonMessageConstants.PM3130E, new String[] { "店舗" }, false);
        }

    }

    /**
     *
     * <pre>
     * 戻るボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Um001_03Form
     * @param errors Errors
     * @param model Model
     * @param request HttpServletRequest
     */
    @CrustValidationTarget(Um001_03BackController.class)
    public void backValidate(Um001_03Form form, Errors errors, Model model, HttpServletRequest request) {

    }

}