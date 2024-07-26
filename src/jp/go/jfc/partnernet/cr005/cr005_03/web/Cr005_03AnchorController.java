//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03AnchorController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.web;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.cr008.cr008_03.web.Cr008_03AnchorController;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはcr005_03の債権管理番号アンカーコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_03Form")
@RequestMapping(value = "/Cr005_03Anchor.form")
public class Cr005_03AnchorController extends Cr005_03BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_03AnchorController.class);

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
    public String executeAction(Model model, Cr005_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        int selectedIndex = 0;
        try {
            selectedIndex = Integer.parseInt(form.getSelectedIndex());
        } catch (NumberFormatException e) {
            throw new PNSystemException(e);
        }

        // 受渡パラメータ.を取得する。
        // 　明細１の選択位置の債権管理番号を取得する。
        String codeYuushi = form.getCr005_03M1Table().getRecordList().get(selectedIndex).getID_ID_Credit();

        // 遷移パラメータの設定
        // 　債権管理番号を遷移パラメータへ設定する。
        addForwardParameter(request, Cr005Constants.CR005_04_ID_CREDIT, codeYuushi);

        log.debug("--- 受渡パラメータ start ---");
        log.debug("selectedIndex:" + selectedIndex);
        log.debug("債権管理番号：" + codeYuushi);
        log.debug("--- 受渡パラメータ end ---");

        // 代位弁済金払込・充当報告書作成（入力画面）を呼出す。
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
    public void displayControl(Model model, Cr005_03Form form, HttpServletRequest request) {

    }
}