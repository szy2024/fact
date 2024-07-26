//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_05InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_05.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr005.cr005_05.service.Cr005_05DTO;
import jp.go.jfc.partnernet.cr005.cr005_05.service.Cr005_05Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;

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
 * このクラスはcr005_05の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_05Form")
@RequestMapping(value = "/Cr005_05Init.form")
public class Cr005_05InitController extends Cr005_05BaseController {

    /** Cr005_05Service */
    @Autowired
    Cr005_05Service cr005_05service;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Cr005_05Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // サービスを実行し案件データを取得する。
        // DTOの生成
        Cr005_05DTO outDto = new Cr005_05DTO();

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(outDto, form);
        // 受渡パラメータにて画面項目を更新
        // 　　画面項目に対し、画面項目転送仕様（初期表示）に従って受渡情報を設定する。
        // CFWBeanUtils.copyProperties(form, inDto);
        // 報告年月日
        form.setLblID_Date_Report(outDto.getTxtID_Date_Report());
        // 充当対象払込期日
        form.setLblID_Date_JutoTaisho(PNCommonComponents.dateFmtAD_YYYYMMDD(outDto.getID_Date_JutoTaisho()));
        // 代弁金払込日
        form.setLblID_Date_DaibenkinHaraikomi(PNCommonComponents.dateFmtAD_YYYYMMDD(outDto
                .getID_Date_DaibenkinHaraikomi()));
        // 受託者勘定処理年月
        form.setLblID_Date_Jtkshori(PNCommonComponents.dateFmtAD_YYYYMM(outDto.getID_Date_Jtkshori()
                .substring(0, 6)));
        // 送金年月日
        String sokin = outDto.getID_Date_Sokin();
        if ((PNCommonConstants.LITERAL_BLANK.equals(sokin)) || (null == sokin)) {
            form.setLblID_Date_Sokin("");
        } else {
            form.setLblID_Date_Sokin(PNCommonComponents.dateFmtAD_YYYYMMDD(outDto.getID_Date_Sokin()));
        }
        // 仮受金(一般口)からの充当額(円)
        // Start Mod by R.Hashimoto 2015/12/18 ST-0155
        String kariukeIppanJuto = outDto.getLblID_M_KariukeIppanJuto();
        if ("0".equals(PNCommonComponents.cnvNulltoZero(kariukeIppanJuto))) {
            form.setLblID_M_KariukeIppanJuto(null);
        } else {
            form.setLblID_M_KariukeIppanJuto(kariukeIppanJuto);
        }
        // End Mod by R.Hashimoto 2015/12/18 ST-0155

        // return MY_VIEW

        return MY_VIEW;
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
    public void displayControl(Model model, Cr005_05Form form, HttpServletRequest request) {

    }
}