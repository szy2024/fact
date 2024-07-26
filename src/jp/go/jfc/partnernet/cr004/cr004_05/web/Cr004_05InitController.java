//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_05InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_05.web;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはcr004_05の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr004_05Form")
@RequestMapping(value = "/Cr004_05Init.form")
public class Cr004_05InitController extends Cr004_05BaseController {

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
    public String executeAction(Model model, Cr004_05Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // 受渡パラメータにて画面項目を更新
        // 　　画面項目に対し、画面項目転送仕様（初期表示）に従って受渡情報を設定する。
        // 　　※そのまま表示できる項目に対しては加工不要。

        // 報告年月日設定
        form.setLblID_Date_Report(form.getLblID_Date_Report());

        // 償還後第1回払込期日
        form.setLblID_Date_FirstHaraikomiAfterKurisho(PNCommonComponents.dateFmtAD_YYYYMMDD(form
                .getLblID_Date_FirstHaraikomiAfterKurisho()));

        // 入金日
        form.setLblID_Date_Nyukin(PNCommonComponents.dateFmtAD_YYYYMMDD(form.getLblID_Date_Nyukin()));

        // 受託者勘定処理年月
        form.setLblID_Date_JtkShori(PNCommonComponents.dateFmtAD_YYYYMM(form.getLblID_Date_JtkShori()));

        // 送金日
        if (!StringUtils.isEmpty(form.getLblID_Date_Sokin())) {
            form.setLblID_Date_Sokin(PNCommonComponents.dateFmtAD_YYYYMMDD(form.getLblID_Date_Sokin()));
        }

        // 払込期日①
        if (!StringUtils.isEmpty(form.getLblID_Date_Haraikomi1())) {
            form.setLblID_Date_Haraikomi1(PNCommonComponents.dateFmtAD_YYYYMMDD(form
                    .getLblID_Date_Haraikomi1()));
        }

        // 払込期日②
        if (!StringUtils.isEmpty(form.getLblID_Date_Haraikomi2())) {
            form.setLblID_Date_Haraikomi2(PNCommonComponents.dateFmtAD_YYYYMMDD(form
                    .getLblID_Date_Haraikomi2()));
        }

        // 払込期日③
        if (!StringUtils.isEmpty(form.getLblID_Date_Haraikomi3())) {
            form.setLblID_Date_Haraikomi3(PNCommonComponents.dateFmtAD_YYYYMMDD(form
                    .getLblID_Date_Haraikomi3()));
        }

        // 払込期日④
        if (!StringUtils.isEmpty(form.getLblID_Date_Haraikomi4())) {
            form.setLblID_Date_Haraikomi4(PNCommonComponents.dateFmtAD_YYYYMMDD(form
                    .getLblID_Date_Haraikomi4()));
        }

        // 利息(円)
        if (!StringUtils.isEmpty(form.getLblID_M_KurishoRisoku())) {
            form.setLblID_M_KurishoRisoku(PNStringChecker.toComma(form.getLblID_M_KurishoRisoku()));
        }

        // 元金(円)
        if (!StringUtils.isEmpty(form.getLblID_M_KurishoGankin())) {
            form.setLblID_M_KurishoGankin(PNStringChecker.toComma(form.getLblID_M_KurishoGankin()));
        }

        // 控除利息(円)
        if (!StringUtils.isEmpty(form.getLblID_M_KojoRisoku())) {
            form.setLblID_M_KojoRisoku(PNStringChecker.toComma(form.getLblID_M_KojoRisoku()));
        } else {
            form.setLblID_M_KojoRisoku("0");
        }

        // 繰上償還手数料(円)
        if (!StringUtils.isEmpty(form.getLblID_M_KurishoCommision())) {
            form.setLblID_M_KurishoCommision(PNStringChecker.toComma(form.getLblID_M_KurishoCommision()));
        } else {
            form.setLblID_M_KurishoCommision("0");
        }

        // 仮受金からの充当額(円)
        if ("0".equals(PNCommonComponents.cnvNulltoZero(form.getLblID_M_KariukeIppanJuto()))) {
            form.setLblID_M_KariukeIppanJuto("");
        } else {
            if (!StringUtils.isEmpty(form.getLblID_M_KariukeIppanJuto())) {
                form.setLblID_M_KariukeIppanJuto(PNStringChecker.toComma(form.getLblID_M_KariukeIppanJuto()));
            }
        }

        // 送金額(円)
        if (!StringUtils.isEmpty(form.getLblID_M_Sokin())) {
            form.setLblID_M_Sokin(PNStringChecker.toComma(form.getLblID_M_Sokin()));
        }

        // 繰償後残元金(円)
        if (!StringUtils.isEmpty(form.getLblID_M_ZanGankinAfterKurisho())) {
            form.setLblID_M_ZanGankinAfterKurisho(PNStringChecker.toComma(form
                    .getLblID_M_ZanGankinAfterKurisho()));
        }

        // 払込元金(円)①
        if (!StringUtils.isEmpty(form.getLblID_M_HaraikomiGankin1())) {
            form.setLblID_M_HaraikomiGankin1(PNStringChecker.toComma(form.getLblID_M_HaraikomiGankin1()));
        }

        // 払込元金(円)②
        if (!StringUtils.isEmpty(form.getLblID_M_HaraikomiGankin2())) {
            form.setLblID_M_HaraikomiGankin2(PNStringChecker.toComma(form.getLblID_M_HaraikomiGankin2()));
        }

        // 払込元金(円)③
        if (!StringUtils.isEmpty(form.getLblID_M_HaraikomiGankin3())) {
            form.setLblID_M_HaraikomiGankin3(PNStringChecker.toComma(form.getLblID_M_HaraikomiGankin3()));
        }

        // 払込元金(円)④
        if (!StringUtils.isEmpty(form.getLblID_M_HaraikomiGankin4())) {
            form.setLblID_M_HaraikomiGankin4(PNStringChecker.toComma(form.getLblID_M_HaraikomiGankin4()));
        }

        // return MY_VIEW

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
    public void displayControl(Model model, Cr004_05Form form, HttpServletRequest request) {

    }

}