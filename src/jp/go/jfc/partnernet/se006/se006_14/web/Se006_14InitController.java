//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se006_14InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/03 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_14.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_14.service.Se006_14M1DTO;
import jp.go.jfc.partnernet.se006.se006_14.service.Se006_14Service;
import jp.go.jfc.partnernet.se006.se006_14.service.Se006_14DTO;

/**
 * <pre>
 * このクラスはse006_14の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_14Form")
@RequestMapping(value = "/Se006_14Init.form")
public class Se006_14InitController extends Se006_14BaseController {

    /** Se006_14Service */
    @Autowired
    Se006_14Service se006_14service;

    // 明細部id名
    // private static final String SE006_14_DETAIL_ID_NAME = "se006_14m1Table";

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see com.fujitsu.xcmfw.web.control.XCMNormalBaseController#executeAction(org.springframework.ui.Model,
     *      com.fujitsu.xcmfw.web.form.XCMBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_14Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡パラメータを取得する。
        String idReport = String.valueOf(getForwardParameter(request).get(Se006Constants.PROPERTY_ID_REPORT));
        form.setLblID_Report(idReport);

        // メッセージの初期化
        form.setLblError("");

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // フォームを初期化する。
        PNPagingTable<Se006_14M1DTO> se006_14m1Table = form.getSe006_14m1Table();

        // サービスを実行し画面データを取得する。
        // 　Se006_14Service.getResultsData // DTOの生成
        Se006_14DTO inDTO = new Se006_14DTO();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Se006_14DTO outDTO = se006_14service.getResultsData(inDTO);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDTO.getBizErrors());

        // エラー件数取得
        form.setLblID_BizErrorCount(bizErrors.size());

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装

        // 　DTO項目をformに設定する。
        form.setLblID_KofuIraiYear(outDTO.getLblID_KofuIraiYear());
        form.setLblID_KofuIraiMonth(outDTO.getLblID_KofuIraiMonth());
        se006_14m1Table.setResultsPerPage(outDTO.getMeisai_list().size());
        se006_14m1Table.setRecordList(outDTO.getMeisai_list(), outDTO.getMeisai_list().size());
        CFWBeanUtils.copyProperties(form, outDTO);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 自画面を表示する。
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see com.fujitsu.xcmfw.web.control.XCMNormalBaseController#displayControl(org.springframework.ui.Model,
     *      com.fujitsu.xcmfw.web.form.XCMBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se006_14Form form,
            HttpServletRequest request) {

    }
}