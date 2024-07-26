//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/08 | 宮郷　慎之介          | H29年追加開発案件対応
// 3.0.0   | 2019/01/29 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_01.web;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se007.common.Se007Constants;
import jp.go.jfc.partnernet.se007.se007_01.service.Se007_01DTO;
import jp.go.jfc.partnernet.se007.se007_01.service.Se007_01Service;

import org.apache.commons.lang3.StringUtils;
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
 * このクラスはse007_01の検索コントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se007_01Form")
@RequestMapping(value = "/Se007_01Search.form")
public class Se007_01SearchController extends Se007_01BaseController {

    /** Se007_01Service */
    @Autowired
    Se007_01Service se007_01service;

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
    public String executeAction(Model model, Se007_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        // 入力チェック
        List<PNMessageInfo> bizErrors = checkInput(form);
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }

        String roleCode = "";
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、権限情報を代入します
        if (null != loginInfo) {
            roleCode = loginInfo.getRoleCode();
        }
        // 扱店別稟議データの農協コードをチェック（入力された扱店が９９３７でかつログオンユーザ権限種別がH方式受託者又は受託者の場合実施する）
        if (0 == bizErrors.size()
                && Se007Constants.Code_Organization_9937.equals(form.getTxtID_Code_Organization())
                && (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                        || PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)
                        || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode))) {

            Se007_01DTO inDTO = new Se007_01DTO();

            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDTO, form);

            // Serviceの呼び出し
            Se007_01DTO outDto = new Se007_01DTO();
            outDto = se007_01service.getResultData(inDTO);

            // サービスで追加されたメッセージを追加
            bizErrors.addAll(outDto.getBizErrors());

        }

        // エラー判定
        if (0 < bizErrors.size()) {
            // // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }
        // 次画面への引き渡し情報設定
        setRequestNextScreen(request, form);
        return success(Se007Constants.EVENT_ID_SE007_02INIT);
    }

    // 次画面への引き渡し情報設定
    private void setRequestNextScreen(HttpServletRequest request, Se007_01Form form) {

        // 公庫支店名
        LinkedHashMap<String, String> lmap = form.getKOUKOSHITEN_CODE_PULLDOWN_LIST();
        addForwardParameter(request, Se007Constants.PROPERTY_NAME_KOUKOSHITEN,
                lmap.get(form.getDrpID_Code_ShokanHonShiten()));
        // 公庫支店コード
        addForwardParameter(request, Se007Constants.PROPERTY_KOUKOSHITEN,
                form.getDrpID_Code_ShokanHonShiten());
        // 扱店コード
        addForwardParameter(request, Se007Constants.PROPERTY_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());
        // 店舗コード
        addForwardParameter(request, Se007Constants.PROPERTY_CODE_TENPO, form.getTxtID_Code_Tenpo());
        // 年度
        addForwardParameter(request, Se007Constants.PROPERTY_YEAR, form.getTxtID_Year());
        // 方式資金
        addForwardParameter(request, Se007Constants.PROPERTY_HOSHIKISHIKIN, form.getTxtID_Hoshikishikin());
        // 番号
        addForwardParameter(request, Se007Constants.PROPERTY_ID_RINGI, form.getTxtID_ID_Ringi());
        // 枝番
        addForwardParameter(request, Se007Constants.PROPERTY_ID_RINGIBRANCH, form.getTxtID_ID_RingiBranch());
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
    public void displayControl(Model model, Se007_01Form form, HttpServletRequest request) {

    }

    /**
     * <pre>
     * 入力チェック
     * </pre>
     *
     * @param form Se007_01のフォームクラス
     * @return bizErrors エラー情報
     */
    private List<PNMessageInfo> checkInput(Se007_01Form form) {

        // エラーリストの初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // /////// 扱店コードチェック/////////
        String roleCode = "";
        // 権限種別を取得
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }
        // ログインユーザの権限種別＝受託者の場合実施
        if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            if (!PNCommonConstants.CODE_NOUKYOU_9937.equals(form.getTxtID_Code_Organization())
                    && !PNCommonComponents.cnvNulltoBlank(form.getTxtID_Code_Organization()).equals(
                            commonInfo.getCode_Organization())) {
                // 扱店コードが9937以外でかつ扱店がログインユーザの扱店コードと一致しない場合、エラーとする。
                // メッセージ：PM3100E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3100E, new String[] { null }, false));
                return bizErrors;
            }
        }

        // /////// 年度チェック/////////
        // ③値チェック
        // 年度の先頭１文字目が元号基本情報リストに存在しない場合、エラーとする。
        // 年度の２，３文字目が数字でない場合、エラーとする。
// [UPD] Ver 3.0.0 - START
//        List<String> list = Arrays.asList("M", "T", "S", "H", "m", "t", "s", "h");
//        if ((!list.contains(form.getTxtID_Year().substring(0, Se007Constants.INDEX_1_YEAR)))
//                || (!PNStringChecker.isAllHalfNumber(form.getTxtID_Year().substring(
//                        Se007Constants.INDEX_1_YEAR)))) {
        if (false == PNCommonComponents.checkGengoAlphabet(form.getTxtID_Year().substring(0, 1), 0)
                || (!PNStringChecker.isAllHalfNumber(form.getTxtID_Year().substring(
                        Se007Constants.INDEX_1_YEAR)))) {
// [UPD] Ver 3.0.0 - END
            // メッセージ：PM3140E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                    new String[] { "年度は半角英数字3桁Gyy形式" }, false));
            return bizErrors;
        }
// [UPD] Ver 3.0.0 - START
//        // 年度がS64/s64の場合、エラーとする。
//        if ("S64".equals(form.getTxtID_Year()) || "s64".equals(form.getTxtID_Year())) {
//            // メッセージ：PM3290E
//            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3290E, new String[] { null }, false));
//            return bizErrors;
//        }
        PNCommonComponents.checkGengoAppoint(form.getTxtID_Year(), 0, new String[]{""}, bizErrors);
        if (bizErrors.size() > 0 ) {
            return bizErrors;
        }
// [UPD] Ver 3.0.0 - END
// [ADD] Ver 3.0.0 - START
        // 年度にエラーがない場合、以下のチェックを行う
        // 年度が不正な場合、エラーとする。
        if (StringUtils.isEmpty(PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year()))) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                    new String[] { "年度は正しい元号と和暦" }, false));
            return bizErrors;
        }
// [ADD] Ver 3.0.0 - END
        return bizErrors;
    }
}