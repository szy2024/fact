//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_16InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_16.service.Se006_16DTO;
import jp.go.jfc.partnernet.se006.se006_16.service.Se006_16Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse006_16の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_16Form")
@RequestMapping(value = "/Se006_16Init.form")
public class Se006_16InitController extends Se006_16BaseController {

    /** Se006_16Service */
    @Autowired
    Se006_16Service se006_16service;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_16Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡パラメータを取得する。
        String idReport = String.valueOf(getForwardParameter(request).get(Se006Constants.PROPERTY_ID_REPORT));
        form.setLblID_Report(idReport);

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // サービスを実行し画面データを取得する。
        // 　Se006_16Service.getResultsData		// DTOの生成
        Se006_16DTO inDTO = new Se006_16DTO();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        CFWBeanUtils.copyProperties(inDTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Se006_16DTO outDTO = se006_16service.getResultsData(inDTO);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDTO.getBizErrors());

        // 業務エラーリストの件数を設定
        form.setLblID_BizErrorCount(bizErrors.size());

        // DTO.業務エラーリストの件数 ＞ ０の場合、業務エラーとして自画面表示
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDTO);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 　DTO項目をformに設定する。
        form.getSe006_16m1Table().setRecordList(outDTO.getMEISAI_LIST(), outDTO.getMEISAI_LIST().size());

        // 自画面を表示する。
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se006_16Form form,
            HttpServletRequest request) {
    }
}