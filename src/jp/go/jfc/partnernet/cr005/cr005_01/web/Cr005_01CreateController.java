//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.web;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWStringChecker;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはcr005_01の作成コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_01Form")
@RequestMapping(value = "/Cr005_01Create.form")
public class Cr005_01CreateController extends Cr005_01BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr005_01CreateController.class);

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
    public String executeAction(Model model, Cr005_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 入力チェック
        // 年度　値チェック
        String inYear = form.getTxtID_Year();
        // 年度の２、３文字目を取得
        String inYearNen = inYear.substring(Cr005Constants.INDEX_1_YEAR);

        // 年度の先頭文字がM/T/S/H/m/t/s/hではない
        final String errMessageNum = "年度は年号記号1桁、年2桁のGyy形式";
// [UPD] Ver 2.0.0 - START
//        List<String> list = Arrays.asList("M", "T", "S", "H", "m", "t", "s", "h");
//        if (false == list.contains(form.getTxtID_Year().substring(0, 1))) {
        if (false == PNCommonComponents.checkGengoAlphabet(form.getTxtID_Year().substring(0, 1), 0)) {
// [UPD] Ver 2.0.0 - END
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessageNum}, false);
            // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
            return MY_VIEW;
        }

        // 年度の２、３文字目が半角数値でない場合、エラーとする
        if ((!CFWStringChecker.isAllHalfNumber(inYearNen))) {
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessageNum}, false);
            // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
            return MY_VIEW;
        }

        // 年度がS64またはs64の場合、エラーとする
// [UPD] Ver 2.0.0 - START
//        final String errMessageS64 = "年度に";
//        if ((inYear.equals(Cr005Constants.YEAR_S64)) || (inYear.equals(Cr005Constants.YEAR_s64))) {
//            addMessage(errors, PNCommonMessageConstants.PM3291E, new String[]{errMessageS64}, false);
//            // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
//            return MY_VIEW;
//        }
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        PNCommonComponents.checkGengoAppoint(inYear, 0, new String[] { "年度に" }, bizErrors);
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
// [UPD] Ver 2.0.0 - END

        // 年度の２、３文字目が00の場合、エラーとする
        final String errMessageZero = "年度は00以外";
        if ((inYearNen.equals(Cr005Constants.YEAR_00))) {
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessageZero}, false);
            // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
            return MY_VIEW;
        }

// [ADD] Ver 2.0.0 - START
        // 年度が不正な場合、エラーとする。
        if (StringUtils.isEmpty(PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year()))) {
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[] { "年度は正しい元号と和暦" }, false);
            // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
            return MY_VIEW;
        }
// [ADD] Ver 2.0.0 - END

        // 　画面のメッセージが設定されていない場合、画面遷移を行う。
        // 　　代位弁済金払込・充当報告書作成（入力画面）へ遷移する
        // 　　　画面に入力された公庫支店コード、扱店コード、店舗コード、年度、方式資金、番号、枝番を遷移パラメータに設定する。
        // 公庫支店コード
        addForwardParameter(request, Cr005Constants.CR005_04_CODE_SHOKANHONSHITEN,
                form.getDrpID_Code_ShokanHonShiten());
        // 扱店コード
        addForwardParameter(request, Cr005Constants.CR005_04_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());
        // 店舗コード
        addForwardParameter(request, Cr005Constants.PCR005_04_CODE_TENPO, form.getTxtID_Code_Tenpo());
        // 年度
        addForwardParameter(request, Cr005Constants.CR005_04_YEAR, form.getTxtID_Year());
        // 方式資金
        addForwardParameter(request, Cr005Constants.CR005_04_CODE_HOSHIKISHIKIN,
                form.getTxtID_Kubun_HoshikiShikin());
        // 番号
        addForwardParameter(request, Cr005Constants.CR005_04_ID_RINGI, form.getTxtID_ID_Ringi());
        // 枝番
        addForwardParameter(request, Cr005Constants.CR005_04_ID_RINGIBRANCH, form.getTxtID_ID_RingiBranch());

        log.debug("--- 受渡パラメータ start ---");
        log.debug("公庫支店:" + form.getDrpID_Code_ShokanHonShiten());
        log.debug("扱店:" + form.getTxtID_Code_Organization());
        log.debug("店舗:" + form.getTxtID_Code_Tenpo());
        log.debug("年度:" + form.getTxtID_Year());
        log.debug("方式資金:" + form.getTxtID_Kubun_HoshikiShikin());
        log.debug("番号:" + form.getTxtID_ID_Ringi());
        log.debug("枝番:" + form.getTxtID_ID_RingiBranch());
        log.debug("--- 受渡パラメータ end ---");

        return success(Cr005Constants.EVENT_ID_CR005_04INIT);
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
    public void displayControl(Model model, Cr005_01Form form, HttpServletRequest request) {

    }
}