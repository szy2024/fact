//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_05CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_05.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.cr008.cr008_05.service.Cr008_05DTO;
import jp.go.jfc.partnernet.cr008.cr008_05.service.Cr008_05Service;

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

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはcr008_05の登録コントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_05Form")
@RequestMapping(value = "/Cr008_05Create.form")
public class Cr008_05CreateController extends Cr008_05BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_05CreateController.class);

    /** Cr008_05Service */
    @Autowired
    Cr008_05Service cr008_05service;

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Cr008_05Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 報告書履歴データ、仮受金（一般口）受入報告書データの登録
        // 　サービスを実行し、報告書履歴データ、仮受金（一般口）受入報告書データを登録する
        // 　Cr008_05Service.insertReport // DTOの生成
        Cr008_05DTO inCr008_05DTO = new Cr008_05DTO();

        // 　form.公庫支店コード　　→　DTO.公庫支店
        // 　form.扱店コード　→　DTO.扱店
        // 　form.店舗コード　　→　DTO.店舗
        // 　form.年度　　→　DTO.年度
        // 　form.方式資金　　→　　DTO.方式資金
        // 　form.番号　　→　DTO.番号
        // 　form.枝番　　→　DTO.枝番
        // 　form.入金日　　→　DTO.入金日
        // 　form.仮受金（一般口）受入額　　→　DTO.仮受金（一般口）受入額
        // 　form.受託者勘定処理年月　　→　　DTO.受託者勘定処理年月
        // 　form.送金年月日　　→　　DTO.送金年月日
        // 　form.送金日番号　　→　　DTO.送金日番号
        // 　form.顧客名　　→　　DTO.顧客名
        // 　form.扱店名　　→　　DTO.扱店名
        CFWBeanUtils.copyProperties(inCr008_05DTO, form);

        // Serviceの呼び出し
        cr008_05service.insertReport(inCr008_05DTO);

        // 受渡パラメータを設定する
        // 公庫支店
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_SHOKANHONSHITEN,
                form.getLblID_Code_KoukoShiten());
        // 扱店コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_ORGANIZATION,
                form.getLblID_Code_Organization());
        // 店舗コード
        addForwardParameter(request, Cr008Constants.PROPERTY_CODE_TENPO, form.getLblID_Code_Tenpo());
        // 年度
        addForwardParameter(request, Cr008Constants.PROPERTY_YEAR, form.getLblID_Year());
        // 方式資金
        addForwardParameter(request, Cr008Constants.PROPERTY_KUBUN_HOSHIKISHIKIN,
                form.getLblID_Code_HoshikiShikin());
        // 番号
        addForwardParameter(request, Cr008Constants.PROPERTY_RINGI, form.getLblID_ID_Ringi());
        // 枝番
        addForwardParameter(request, Cr008Constants.PROPERTY_RINGIBRANCH, form.getLblID_ID_RingiBranch());
        // 債権管理番号
        addForwardParameter(request, Cr008Constants.PROPERTY_ID_CREDIT, form.getID_Credit());

        log.debug("--- 受渡パラメータ start ---");
        log.debug("公庫支店:" + form.getLblID_Code_KoukoShiten());
        log.debug("扱店コード:" + form.getLblID_Code_Organization());
        log.debug("店舗コード:" + form.getLblID_Code_Tenpo());
        log.debug("年度:" + form.getLblID_Year());
        log.debug("方式資金:" + form.getLblID_Code_HoshikiShikin());
        log.debug("番号:" + form.getLblID_ID_Ringi());
        log.debug("枝番:" + form.getLblID_ID_RingiBranch());
        log.debug("債権管理番号:" + form.getID_Credit());
        log.debug("--- 受渡パラメータ end ---");

        // 仮受金（一般口）受入報告書作成（登録結果画面）へ遷移する
        return success(Cr008Constants.EVENT_ID_CR008_06INIT);

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
    public void displayControl(Model model, Cr008_05Form form, HttpServletRequest request) {

    }
}