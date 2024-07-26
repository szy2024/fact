//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_02AnchorController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
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
 * このクラスはCr008_02の顧客名アンカーコントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_02Form")
@RequestMapping(value = "/Cr008_02Anchor.form")
public class Cr008_02AnchorController extends Cr008_02BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_02AnchorController.class);

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
    public String executeAction(Model model, Cr008_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        int selectedIndex = 0;
        try {
            selectedIndex = Integer.parseInt(form.getSelectedIndex());
        } catch (NumberFormatException e) {
            throw new PNSystemException(e);
        }

        // 受渡パラメータを取得する。
        // 　明細１の顧客名選択位置の貸付先コード、顧客名、扱店コード、住所を取得する。
        String codeCustomer = form.getCr008_02M1Table().getRecordList().get(selectedIndex)
                .getID_Code_Customer();
        String nameCustomer = form.getCr008_02M1Table().getRecordList().get(selectedIndex)
                .getID_Name_Customer();
        String codeOrganization = form.getCr008_02M1Table().getRecordList().get(selectedIndex)
                .getID_Code_Organization();
        String customerAddress = form.getCr008_02M1Table().getRecordList().get(selectedIndex)
                .getID_CustomerAddress();

        // 住所の改行タグを半角スペースへ変換する
        if (0 != customerAddress.length() || null != customerAddress) {
            customerAddress = customerAddress.replace(PNCommonConstants.STR_BR,
                    PNCommonConstants.HALF_CHAR_SPACE);
        }

        // 遷移パラメータの設定
        // 　貸付先コード、顧客名、扱店コード、住所を遷移パラメータへ設定する。
        // 貸付先コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_CUSTOMER, codeCustomer);
        // 顧客名
        addForwardParameter(request, Cr008Constants.PROPERTY_NAME_CUSTOMER, nameCustomer);
        // 扱店コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_ORGANIZATION, codeOrganization);
        // 住所
        addForwardParameter(request, Cr008Constants.PROPERTY_ADDRESS, customerAddress);

        log.debug("--- 受渡パラメータ start ---");
        log.debug("貸付先コード:" + codeCustomer);
        log.debug("顧客名:" + nameCustomer);
        log.debug("扱店コード:" + codeOrganization);
        log.debug("住所:" + customerAddress);
        log.debug("--- 受渡パラメータ end ---");

        // 仮受金（一般口）受入報告書作成（融資番号検索結果画面）を呼出す。
        return success(Cr008Constants.EVENT_ID_CR008_03INIT);

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
    public void displayControl(Model model, Cr008_02Form form, HttpServletRequest request) {

    }
}