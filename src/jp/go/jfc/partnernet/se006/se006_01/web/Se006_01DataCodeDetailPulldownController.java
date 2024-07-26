//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_01DataCodeDetailPulldownController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustAnytimeExecute;

/**
 * <pre>
 * このクラスはse006_01の実行・回収関係報告書詳細プルダウンコントローラークラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
@Controller
@SessionAttributes("se006_01Form")
@RequestMapping("/Se006_01DataCodeDetailPulldown.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CrustAnytimeExecute
public class Se006_01DataCodeDetailPulldownController extends Se006_01BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_01Form form, Errors errors,
            HttpServletRequest request, HttpServletResponse response) {

        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se006_01Form form, HttpServletRequest request) {

        // 選択された報告書種別に応じて表示制御を行う。
        if (PNCommonConstants.DATACODE_90257120.equals(form.getID_DataCode_Detail())
                || PNCommonConstants.DATACODE_90257121.equals(form.getID_DataCode_Detail())) {

            // Form.実行・回収関係報告書詳細 = "90257120"
            // （その他の受入充当報告書（留置期間利息・代弁遅延損害金）） または
            // Form.実行・回収関係報告書詳細 = "90257121"
            // （その他の受入充当報告書（留置期間利息・代弁遅延損害金） 赤） の場合

            // 非活性 ⇒ Form.融資番号(扱店)
            // 非活性 ⇒ Form.融資番号（店舗）
            // 非活性 ⇒ Form.融資番号（年度）
            // 非活性 ⇒ Form.融資番号（方式資金）
            // 非活性 ⇒ Form.融資番号（番号）
            // 非活性 ⇒ Form.融資番号（枝番）
            form.setProtect("ID_YN_Code_Organization", true);
            form.setProtect("ID_YN_Code_Tenpo", true);
            form.setProtect("ID_YN_Year", true);
            form.setProtect("ID_YN_Kubun_HoshikiShikin", true);
            form.setProtect("ID_YN_Ringi", true);
            form.setProtect("ID_YN_RingiBranch", true);

            // 入力値をクリア ⇒ Form.融資番号(扱店)
            // 入力値をクリア ⇒ Form.融資番号（店舗）
            // 入力値をクリア ⇒ Form.融資番号（年度）
            // 入力値をクリア ⇒ Form.融資番号（方式資金）
            // 入力値をクリア ⇒ Form.融資番号（番号）
            // 入力値をクリア ⇒ Form.融資番号（枝番）
            form.setID_YN_Code_Organization(PNCommonConstants.LITERAL_BLANK);
            form.setID_YN_Code_Tenpo(PNCommonConstants.LITERAL_BLANK);
            form.setID_YN_Year(PNCommonConstants.LITERAL_BLANK);
            form.setID_YN_Kubun_HoshikiShikin(PNCommonConstants.LITERAL_BLANK);
            form.setID_YN_Ringi(PNCommonConstants.LITERAL_BLANK);
            form.setID_YN_RingiBranch(PNCommonConstants.LITERAL_BLANK);

        }
        else {

            // 上記以外の場合
            // 活性 ⇒ Form.融資番号(扱店)
            // 活性 ⇒ Form.融資番号（店舗）
            // 活性 ⇒ Form.融資番号（年度）
            // 活性 ⇒ Form.融資番号（方式資金）
            // 活性 ⇒ Form.融資番号（番号）
            // 活性 ⇒ Form.融資番号（枝番）
            form.setProtect("ID_YN_Code_Organization", false);
            form.setProtect("ID_YN_Code_Tenpo", false);
            form.setProtect("ID_YN_Year", false);
            form.setProtect("ID_YN_Kubun_HoshikiShikin", false);
            form.setProtect("ID_YN_Ringi", false);
            form.setProtect("ID_YN_RingiBranch", false);

        }

    }
}