//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_03.web;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;

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
 * このクラスはcr006_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr006_03Form")
@RequestMapping(value = "/Cr006_03Init.form")
public class Cr006_03InitController extends Cr006_03BaseController {

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
    public String executeAction(Model model, Cr006_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 遷移パラメータの取得
        mappingForwardParameterToForm(request, form);
        Map<String, Object> mpRequest = getForwardParameter(request);

        // 遷移パラメータの値を画面項目へ設定する。
        /** 報告年月日 */
        form.setLblID_Date_Report((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_DATE_REPORT));
        /** 顧客名 */
        form.setLblID_Name_Customer((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_NAME_CUSTOMER));
        /** 扱店名 */
        form.setLblID_Name_Organization((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_NAME_ORGANIZATION));
        /** 公庫支店 */
        form.setLblID_Code_KoukoShiten((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN));
        /** 扱店 */
        form.setLblID_Code_Organization((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_CODE_ORGANIZATION));
        /** 店舗 */
        form.setLblID_Code_Tenpo((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_CODE_TENPO));
        /** 年度 */
        form.setLblID_Year((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_YEAR));
        /** 方式資金 */
        form.setLblID_Code_HoshikiShikin((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN));
        /** 番号 */
        form.setLblID_ID_Ringi((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_ID_RINGI));
        /** 枝番 */
        form.setLblID_ID_RingiBranch((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_ID_RINGIBRANCH));
        /** 入金日 */
        form.setLblID_Date_Nyukin((String) mpRequest.get(Cr006Constants.PROPERTY_ID_DATE_NYUKIN));
        /** 立替金利息(円) */
        form.setLblID_M_TatekaeRisoku(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_TATEKAERISOKU)))));
        /** 立替金(円) */
        form.setLblID_M_Tatekae(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_TATEKAE)))));
        /** 仮受金(一般口)からの充当額(円) */
        if ("0".equals(PNCommonComponents.cnvNulltoZero((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO)))) {
            form.setLblID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_KariukeIppanJuto(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                    .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO)))));
        }
        /** 立替金の種類 */
        form.setLblID_Code_TatekaekinShurui((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_CODE_TATEKAEKINSHURUI));
        /** 公庫立替日 */
        form.setLblID_Date_KoukoTatekae((String) mpRequest
                .get(Cr006Constants.PROPERTY_TXTID_DATE_KOUKOTATEKAE));
        /** 計(円) */
        form.setLblID_M_Kei(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_KEI)))));
        /** 送金額(円) */
        form.setLblID_M_Sokin(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_SOKIN)))));
        /** 受入後立替金残高(円) */
        form.setLblID_M_TatekaeZanAfterUkeire(PNCommonUtils.addComma(new BigDecimal(PNCommonComponents
                .cnvNulltoZero((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_M_TATEKAEZANAFTERUKEIRE)))));
        /** 受託者勘定処理年月 */
        form.setLblID_Date_Jtkshori((String) mpRequest.get(Cr006Constants.PROPERTY_ID_DATE_JTKSHORI));
        /** 送金年月日 */
        form.setLblID_Date_Sokin((String) mpRequest.get(Cr006Constants.PROPERTY_ID_DATE_SOKIN));
        /** 送金日番号 */
        form.setLblID_ID_Sokinbi((String) mpRequest.get(Cr006Constants.PROPERTY_TXTID_CODE_SOKIN));
        /** 債権管理番号 */
        form.setID_ID_Credit((String) mpRequest.get(Cr006Constants.PROPERTY_ID_CREDIT));
        /** 報告書番号 */
        form.setID_ID_Report((String) mpRequest.get(Cr006Constants.PROPERTY_ID_ID_REPORT));
        /** 報告書時分秒 */
        form.setID_Time_Report((String) mpRequest.get(Cr006Constants.PROPERTY_ID_TIME_REPORT));

        // 自画面を呼び出す
        return MY_VIEW;
    }

    /**
     *
     * <pre>
     * cnvNulltoZero機能拡張
     * </pre>
     *
     * @param param
     * @return
     */
    private static String cnvZerotoBlank(String param) {
        if (null == param) {
            return "";
        } else if ("0".equals(param)) {
            return "";
        } else {
            return param;
        }
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
    public void displayControl(Model model, Cr006_03Form form, HttpServletRequest request) {

    }
}