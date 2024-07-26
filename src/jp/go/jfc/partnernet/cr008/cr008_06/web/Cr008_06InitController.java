//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_06InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_06.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.cr008.cr008_05.web.Cr008_05CreateController;

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

/**
 * <pre>
 * このクラスはcr008_06の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_06Form")
@RequestMapping(value = "/Cr008_06Init.form")
public class Cr008_06InitController extends Cr008_06BaseController {

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

        // 受渡パラメタを取得し、Formへ設定する
        Map<String, Object> paramMap = getForwardParameter(request);

        form.setCr008_06_In_Code_ShokanHonShiten((String) paramMap
                .get(Cr008Constants.PROPERTY_CODE_SHOKANHONSHITEN));
        // 　・受渡パラメタ.扱店コード　　→　　form.扱店入力値
        form.setCr008_06_In_Code_Organization((String) paramMap
                .get(Cr008Constants.PROPERTY_CODE_ORGANIZATION));
        // 　・受渡パラメタ.店舗コード　　→　　form.店舗入力値
        form.setCr008_06_In_Code_Tenpo((String) paramMap.get(Cr008Constants.PROPERTY_CODE_TENPO));
        // 　・受渡パラメタ.年度　　→　　form.年度入力値
        form.setCr008_06_In_Year((String) paramMap.get(Cr008Constants.PROPERTY_YEAR));
        // 　・受渡パラメタ.方式資金　　→　　form.方式資金入力値
        form.setCr008_06_In_Kubun_HoshikiShikin((String) paramMap
                .get(Cr008Constants.PROPERTY_KUBUN_HOSHIKISHIKIN));
        // 　・受渡パラメタ.番号　　→　　form.番号入力値
        form.setCr008_06_In_ID_Ringi((String) paramMap.get(Cr008Constants.PROPERTY_RINGI));
        // 　・受渡パラメタ.枝番　　→　　form.枝番入力値
        form.setCr008_06_In_ID_RingiBranch((String) paramMap.get(Cr008Constants.PROPERTY_RINGIBRANCH));
        // 　・受渡パラメタ.債権管理番号　　→　　form.債権管理番号入力値
        form.setCr008_06_In_ID_Credit((String) paramMap.get(Cr008Constants.PROPERTY_ID_CREDIT));

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
    public void displayControl(Model model, Cr008_06Form form, HttpServletRequest request) {

    }
}