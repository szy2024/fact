//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_03AnchorController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/18 | 佐藤　晃              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_03.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr004.common.Cr004Constants;
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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはcr004_03の融資番号アンカーコントローラークラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr004_03Form")
@RequestMapping(value = "/Cr004_03Anchor.form")
public class Cr004_03AnchorController extends Cr004_03BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr004_03AnchorController.class);

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
    public String executeAction(Model model, Cr004_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        int selectedIndex = 0;
        try {
            selectedIndex = Integer.parseInt(form.getSelectedIndex());
        } catch (NumberFormatException e) {
            throw new PNSystemException(e);
        }

        // 受渡パラメータ.を取得する。
        // 　明細１の選択位置の債権管理番号を取得する。
        String codeYuushi = form.getCr004_03M1Table().getRecordList().get(selectedIndex).getID_ID_Credit();

        // 遷移パラメータの設定
        // 　債権管理番号を遷移パラメータへ設定する。
        addForwardParameter(request, Cr004Constants.PROPERTY_ID_CREDIT, codeYuushi);

        log.debug("--- 受渡パラメータ start ---");
        log.debug("selectedIndex:" + selectedIndex);
        log.debug("債権管理番号：" + codeYuushi);
        log.debug("--- 受渡パラメータ end ---");

        // 繰上償還受入・充当報告書作成（顧客名、融資番号入力画面）を呼出す。
        return success(Cr004Constants.EVENT_ID_CR004_04INIT);

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
    public void displayControl(Model model, Cr004_03Form form, HttpServletRequest request) {

    }
}