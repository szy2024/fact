//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_07InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_07.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se006.se006_07.service.Se006_07DTO;
import jp.go.jfc.partnernet.se006.se006_07.service.Se006_07Service;

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
 * このクラスはSe006_07の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se006_07Form")
@RequestMapping(value = "/Se006_07Init.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se006_07InitController extends Se006_07BaseController {

    /** Se006_07Service */
    @Autowired
    Se006_07Service se006_07service;

    // 明細部id名
    private static final String SE006_07_DETAIL_ID_NAME = "se006_07Table";

    // 代弁履行後の作成オブジェクト名
    private static final String SE006_07_CKHAFTER_DAIBENSAI = "ckhAfter_Daibensai";

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
    public String executeAction(Model model, Se006_07Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // １．表示前処理

        // 遷移パラメータの取得（セッション→Form)
        mappingForwardParameterToForm(request, form);

        // ０件の時に明細は枠を含め表示しない
        form.setVisible(SE006_07_DETAIL_ID_NAME, false);

        // メッセージの初期化
        form.setLblMessage("");

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // Se006_07Service.getDetailData // DTOの生成
        Se006_07DTO inDto = new Se006_07DTO();

        // DTOへの転記
        CFWBeanUtils.copyProperties(inDto, form);

        // Serviceの呼び出し
        Se006_07DTO outDto = se006_07service.getDetailData(inDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 画面表示

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);

        form.setVisible(SE006_07_DETAIL_ID_NAME, true);

        // 　Se006_07DTO.代弁履行後の作成の値が’1’の場合、チェックして表示する。
        // formの値が"1"であれば、チェックオンになるので、コーディングしないが
        // レイアウト上非活性なので、非活性の処理をここでコーディング
        form.setProtect(SE006_07_CKHAFTER_DAIBENSAI, true);

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
    public void displayControl(Model model, Se006_07Form form, HttpServletRequest request) {

    }
}