//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
// 2.0.0   | 2019/01/29 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.web;

import java.math.BigDecimal;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr008.cr008_01.web.Cr008_01CreateController;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se009.common.Se009Constants;
import jp.go.jfc.partnernet.se009.se009_01.service.Se009_01DTO;
import jp.go.jfc.partnernet.se009.se009_01.service.Se009_01Service;

import org.apache.commons.lang.StringUtils;
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
import com.fujitsu.crust.common.CFWStringChecker;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはSe009_01の送信コントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se009_01Form")
@RequestMapping(value = "/Se009_01Send.form")
public class Se009_01SendController extends Se009_01BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_01CreateController.class);

    /** Se009_01Service */
    @Autowired
    Se009_01Service se009_01service;

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
    public String executeAction(Model model, Se009_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 扱店コードチェック
        // 値チェック

        // 　③値チェック
        // 　　　扱店コードが9937以外でかつ扱店がログインユーザの扱店コードと一致しない場合、エラーとする。
        // 　　　（ログインユーザの権限種別＝受託者の場合実施する）
        // 　　　　メッセージ：PM3100E
        if (!Se009Constants.CODE_ORGANIZATION_NOUKYOU.equals(form.getTxtID_Code_Organization())) {
            PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
            String userCodeOrganization = loginInfo.getCode_Organization();
            String userRoleCode = loginInfo.getRoleCode();
            if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(userRoleCode)) {
                if (!form.getTxtID_Code_Organization().equals(userCodeOrganization)) {
                    addMessage(errors, PNCommonMessageConstants.PM3100E);
                    return MY_VIEW;
                }
            }
        }

        // 年度チェック
        // 　③値チェック

        // 　　　年度の先頭１文字目が元号基本情報リストに存在しない場合、エラーとする。
        // 　　　　メッセージ：PM3140E
        // 処理を省略するために元号を大文字にする
// [UPD] Ver 2.0.0 - START
//        String gengou = form.getTxtID_Year().substring(0, 1);
//        if (!Se009Constants.TARGET_YEAR_GENGOU.contains(gengou)) {
//            String errMessage = "年度の1文字目は[M][T][S][H][m][t][s][h]";
//            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
//            return MY_VIEW;
//        }
        if (false == PNCommonComponents.checkGengoAlphabet(form.getTxtID_Year().substring(0, 1), 0)) {
            String errMessage = "年度は半角英数字3桁";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }
// [UPD] Ver 2.0.0 - END

        // 　　　年度の２，３文字目が数字でない場合、エラーとする。
        // 　　　　メッセージ：PM3140E
        String yearNend = form.getTxtID_Year().substring(1);
        if ((Se009Constants.YEAR_00.equals(yearNend)) || (!CFWStringChecker.isAllHalfNumber(yearNend))) {
            String errMessage = "年度は半角英数字3桁";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }
// [UPD] Ver 2.0.0 - START
//        // 　　　年度がS64/s64の場合、エラーとする。
//        // 　　　　メッセージ：PM3290E
//        String yearGengou = form.getTxtID_Year().toUpperCase();
//        if (Se009Constants.YEAR_S64.equals(yearGengou)) {
//            addMessage(errors, PNCommonMessageConstants.PM3290E);
//            return MY_VIEW;
//        }
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        PNCommonComponents.checkGengoAppoint(form.getTxtID_Year(), 0, new String[]{""}, bizErrors);
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
// [UPD] Ver 2.0.0 - END

        // 年度の正確性をチェック(S65等の場合、エラーとする)
        String convertSeireki = PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year());
        if (StringUtils.isEmpty(convertSeireki)) {
            String errMessage = "年度は正しい元号と和暦";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }

        // 　　　資金払出または元金充当日(元号)がS/H/でない場合、エラーとする。
        // 　　　　メッセージ：PM3140E
        String warekiGengou = form.getID_SearchStartWareki();
        // if (!("S".equals(warekiGengou) || "H".equals(warekiGengou))) {
// [UPD] Ver 2.0.0 - START
//        if (!Se009Constants.TARGET_HARAIDASHIGANJU_GENGOU.contains(warekiGengou)) {
//            String errMessage = "資金払出または元金充当日(元号)は[S][H][s][h]";
//            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
//            return MY_VIEW;
//        }
        if (false == PNCommonComponents.checkGengoAlphabet(warekiGengou, 1)) {
            String errMessage = "資金払出または元金充当日(元号)は有効な元号";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }
// [UPD] Ver 2.0.0 - END

        // 資金払出または元金充当日(元号・年・月・日)の実在日チェック
        // 資金払出または元金充当日が存在しない場合、エラーとする
        // メッセージ：PM3220E
        String searchStartGyy = form.getID_SearchStartWareki() + form.getID_SearchStartYear();
// [DEL] Ver 2.0.0 - START
//        String searchStartSeireki = PNCommonComponents.dateFmtJC_Gyy(searchStartGyy);
//        if (StringUtils.isEmpty(searchStartSeireki)) {
//            String errMessage = "資金払出または元金充当日";
//            addMessage(errors, PNCommonMessageConstants.PM3220E, new String[]{errMessage}, false);
//            return MY_VIEW;
//        }
// [DEL] Ver 2.0.0 - END

        // 資金払出または元金充当日(月)を取得し、1桁だったら2桁に0パディングする
        String searchStartMonth = form.getID_SearchStartMonth();
        if (StringUtils.isNotEmpty(searchStartMonth) && 1 == searchStartMonth.length()) {
            searchStartMonth = "0" + searchStartMonth;
        }

        // 資金払出または元金充当日(日)を取得し、1桁だったら2桁に0パディングする
        String searchStartDate = form.getID_SearchStartDate();
        if (StringUtils.isNotEmpty(searchStartDate) && 1 == searchStartDate.length()) {
            searchStartDate = "0" + searchStartDate;
        }

// [UPD] Ver 2.0.0 - START
//        String haraidashiGanjuDay = searchStartSeireki + searchStartMonth + searchStartDate;
        String haraidashiGanjuDay = PNCommonComponents.dateFmtJC_Gyymmdd(PNCommonComponents.concatString(
                searchStartGyy, searchStartMonth, searchStartDate), "");
// [UPD] Ver 2.0.0 - END
        if (!PNCommonComponents.checkDate(haraidashiGanjuDay)) {
            String errMessage = "資金払出または元金充当日";
            addMessage(errors, PNCommonMessageConstants.PM3220E, new String[]{errMessage}, false);
            return MY_VIEW;
        }

        // 資金払出額

        // 資金払出額が11桁を超える場合、エラーとする。
        // validation.xml longRangeで対応
        // メッセージ：PM3140E

        // 元金充当額
        // 元金充当額が11桁を超える場合、エラーとする。
        // validation.xml longRangeで対応
        // メッセージ：PM3140E

        // 資金払出額、元金充当額の相関チェック
        // 資金払出額、元金充当額の値が両方とも０の場合、エラーとする
        // メッセージ：PM3140E
        if (0 == PNCommonConstants.BIGDECIMAL_ZERO_VALUE.compareTo(new BigDecimal(form
                .getTxtID_M_Haraidashi()))
                && 0 == PNCommonConstants.BIGDECIMAL_ZERO_VALUE.compareTo(new BigDecimal(form
                        .getTxtID_M_Ganju()))) {

            String errMessage = "資金払出額と元金充当額のどちらかを有額";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }

        // 画面入力値を取得する

        // Se009_01DTOに画面入力項目をセットする

        Se009_01DTO inDto = new Se009_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        inDto.setCode_Organization(loginInfo.getCode_Organization());
        inDto.setRoleCode(loginInfo.getRoleCode());
        // 元号付和暦を西暦に変換してセットする
        inDto.setTxtID_Year(PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year()));

        // 枝番が空の場合、「0」をセットする。
        if (StringUtils.isEmpty(form.getTxtID_ID_RingiBranch())) {
            inDto.setTxtID_ID_RingiBranch("0");
        }

        // DB整合性チェック
        se009_01service.validateKojoKeisan(inDto);

        // 次画面への引き渡し情報を設定する
        this.setRequestNextScreen(request, form);
        // 画面遷移を行う

        return success(Se009Constants.EVENT_ID_SE009_02INIT);
    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestNextScreen(HttpServletRequest request, Se009_01Form form) {

        // 公庫支店コード
        addForwardParameter(request, Se009Constants.PROPERTY_CODE_SHOKANHONSHITEN,
                form.getDrpID_Code_ShokanHonShiten());
        // 扱店コード
        addForwardParameter(request, Se009Constants.PROPERTY_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());
        // 店舗コード
        addForwardParameter(request, Se009Constants.PROPERTY_CODE_TENPO, form.getTxtID_Code_Tenpo());
        // 年度
        addForwardParameter(request, Se009Constants.PROPERTY_YEAR, form.getTxtID_Year());
        // 方式資金
        addForwardParameter(request, Se009Constants.PROPERTY_HOSHIKISHIKIN, form.getTxtID_HoshikiShikin());
        // 番号
        addForwardParameter(request, Se009Constants.PROPERTY_RINGI, form.getTxtID_ID_Ringi());
        // 枝番
        addForwardParameter(request, Se009Constants.PROPERTY_RINGIBRANCH, form.getTxtID_ID_RingiBranch());
        // 資金払出または元金充当日(元号)
        addForwardParameter(request, Se009Constants.PROPERTY_ID_START_WAREKI, form.getID_SearchStartWareki());
        // 資金払出または元金充当日(年)
        addForwardParameter(request, Se009Constants.PROPERTY_ID_START_YEAR, form.getID_SearchStartYear());
        // 資金払出または元金充当日(月)
        addForwardParameter(request, Se009Constants.PROPERTY_ID_START_MONTH, form.getID_SearchStartMonth());
        // 資金払出または元金充当日(日)
        addForwardParameter(request, Se009Constants.PROPERTY_ID_START_DATE, form.getID_SearchStartDate());
        // 資金払出額
        addForwardParameter(request, Se009Constants.PROPERTY_ID_HARAIDASHI, form.getTxtID_M_Haraidashi());
        // 元金充当額
        addForwardParameter(request, Se009Constants.PROPERTY_ID_GANJU, form.getTxtID_M_Ganju());

        if (log.isDebugEnabled()) {
            log.debug("遷移パラメータ");
            log.debug("公庫支店コード：" + form.getDrpID_Code_ShokanHonShiten());
            log.debug("扱店コード：" + form.getTxtID_Code_Organization());
            log.debug("店舗コード：" + form.getTxtID_Code_Tenpo());
            log.debug("年度：" + form.getTxtID_Year());
            log.debug("方式資金：" + form.getTxtID_HoshikiShikin());
            log.debug("番号：" + form.getTxtID_ID_Ringi());
            log.debug("枝番：" + form.getTxtID_ID_RingiBranch());
            log.debug("資金払出または元金充当日(元号)：" + form.getID_SearchStartWareki());
            log.debug("資金払出または元金充当日(年)：" + form.getID_SearchStartYear());
            log.debug("資金払出または元金充当日(月)：" + form.getID_SearchStartMonth());
            log.debug("資金払出または元金充当日(日)：" + form.getID_SearchStartDate());
            log.debug("資金払出額：" + form.getTxtID_M_Haraidashi());
            log.debug("元金充当額：" + form.getTxtID_M_Ganju());
        }
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
    public void displayControl(Model model, Se009_01Form form, HttpServletRequest request) {

    }
}