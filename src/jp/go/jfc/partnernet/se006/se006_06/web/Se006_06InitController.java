//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_06InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/23 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_06.web;

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
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se006.se006_06.service.Se006_06Service;
import jp.go.jfc.partnernet.se006.se006_06.service.Se006_06DTO;

/**
 * <pre>
 * このクラスはSe006_06の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_06Form")
@RequestMapping(value = "/Se006_06Init.form")
public class Se006_06InitController extends Se006_06BaseController {

    /** Se006_06Service */
    @Autowired
    Se006_06Service se006_06service;

    // 明細部id名
    private static final String SE006_06_DETAIL_ID_NAME = "se006_06Table";

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
    public String executeAction(Model model, Se006_06Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 遷移パラメータの取得（セッション→Form)
        mappingForwardParameterToForm(request, form);

        // ０件の時に明細は枠を含め表示しない
        form.setVisible(SE006_06_DETAIL_ID_NAME, false);

        // メッセージの初期化
        form.setLblMessage("");

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // １．表示前処理
        // DTOの生成
        Se006_06DTO inDTO = new Se006_06DTO();
        CFWBeanUtils.copyProperties(inDTO, form);

        // Serviceの呼び出し
        Se006_06DTO outDTO = se006_06service.getDetailData(inDTO);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDTO.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 画面表示
        // 　Se006_06DTO.調整コードの値に該当するラジオボタンを選択状態にして表示する。
        CFWBeanUtils.copyProperties(form, outDTO);
        form.setVisible(SE006_06_DETAIL_ID_NAME, true);

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
    public void displayControl(Model model, Se006_06Form form, HttpServletRequest request) {

    }

}