//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_13InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_13.web;

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
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_13.service.Se006_13Service;
import jp.go.jfc.partnernet.se006.se006_13.service.Se006_13DTO;

/**
 * <pre>
 * このクラスはSe006_13の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_13Form")
@RequestMapping(value = "/Se006_13Init.form")
public class Se006_13InitController extends Se006_13BaseController {

    /** Se006_13Service */
    @Autowired
    Se006_13Service se006_13service;

    // 明細部id名
    private static final String SE006_13_DETAIL_ID_NAME = "se006_13Table";

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
    public String executeAction(Model model, Se006_13Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 遷移パラメータの取得（セッション→Form)
        String idReport = String.valueOf(getForwardParameter(request).get(Se006Constants.PROPERTY_ID_REPORT));
        form.setLblID_ID_Report(idReport);

        // ０件の時に明細は枠を含め表示しない
        form.setVisible(SE006_13_DETAIL_ID_NAME, false);

        // メッセージの初期化
        form.setLblMessage("");

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // １．表示前処理
        // Se006_13Service.getDetailData // DTOの生成
        Se006_13DTO inDTO = new Se006_13DTO();

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDTO, form);

        // Serviceの呼び出し
        Se006_13DTO outDTO = se006_13service.getDetailData(inDTO);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDTO.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDTO);
        form.setID_Date_Jtkshori(outDTO.getLblID_Date_Jtkshori());
        form.setID_Date_Sokin(outDTO.getLblID_Date_Sokin());
        form.setID_ID_Sokinbi(outDTO.getLblID_ID_Sokinbi());
        form.setVisible(SE006_13_DETAIL_ID_NAME, true);

        // 画面表示
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
    public void displayControl(Model model, Se006_13Form form, HttpServletRequest request) {

    }
}