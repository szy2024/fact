//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_06OkController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_06.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr008.common.Cr008Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * このクラスはcr008_06のOKボタンコントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_06Form")
@RequestMapping(value = "/Cr008_06Ok.form")
public class Cr008_06OkController extends Cr008_06BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_06OkController.class);

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
    public String executeAction(Model model, Cr008_06Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡パラメータを設定する（Formから取得）
        // 公庫支店コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_SHOKANHONSHITEN,
                form.getCr008_06_In_Code_ShokanHonShiten());
        // 扱店コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_ORGANIZATION,
                form.getCr008_06_In_Code_Organization());
        // 店舗コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_TENPO, form.getCr008_06_In_Code_Tenpo());
        // 年度
        addForwardParameter(request, Cr008Constants.PROPERTY_YEAR, form.getCr008_06_In_Year());
        // 方式資金
        addForwardParameter(request, Cr008Constants.PROPERTY_KUBUN_HOSHIKISHIKIN,
                form.getCr008_06_In_Kubun_HoshikiShikin());
        // 番号
        addForwardParameter(request, Cr008Constants.PROPERTY_RINGI, form.getCr008_06_In_ID_Ringi());
        // 枝番
        addForwardParameter(request, Cr008Constants.PROPERTY_RINGIBRANCH,
                form.getCr008_06_In_ID_RingiBranch());
        // 債権管理番号
        addForwardParameter(request, Cr008Constants.PROPERTY_ID_CREDIT, form.getCr008_06_In_ID_Credit());

        log.debug("--- 受渡パラメータ start ---");
        log.debug("公庫支店:" + form.getCr008_06_In_Code_ShokanHonShiten());
        log.debug("扱店コード:" + form.getCr008_06_In_Code_Organization());
        log.debug("店舗コード:" + form.getCr008_06_In_Code_Tenpo());
        log.debug("年度:" + form.getCr008_06_In_Year());
        log.debug("方式資金:" + form.getCr008_06_In_Kubun_HoshikiShikin());
        log.debug("番号:" + form.getCr008_06_In_ID_Ringi());
        log.debug("枝番:" + form.getCr008_06_In_ID_RingiBranch());
        log.debug("債権管理番号:" + form.getCr008_06_In_ID_Credit());
        log.debug("--- 受渡パラメータ end ---");

        // 仮受金（一般口）受入報告書作成（検索結果画面）へ遷移する
        return success(Cr008Constants.EVENT_ID_CR008_04INIT);

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
    public void displayControl(Model model, Cr008_06Form form, HttpServletRequest request) {

    }
}