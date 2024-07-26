//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/11/08 | 林　晃平              | H29年追加開発案件対応
// 3.0.0   | 2019/01/17 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.web;

import java.util.LinkedList;

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
import jp.go.jfc.partnernet.se004.common.Se004Constants;
import jp.go.jfc.partnernet.se004.se004_01.service.Se004_01DTO;
import jp.go.jfc.partnernet.se004.se004_01.service.Se004_01Service;

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
 * このクラスはSe004_01の検索ボタンチェックコントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se004_01Form")
@RequestMapping(value = "/Se004_01Search.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se004_01SearchController extends Se004_01BaseController {

    /** Se004_01Service */
    @Autowired
    Se004_01Service se004_01service;

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
    public String executeAction(Model model, Se004_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、権限情報を代入します
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }
        // 　サービス起動パラメータ設定（画面に入力された公庫支店コード、扱店コード、店舗コード、年度、方式資金、番号、枝番）
        // DTOの生成
        Se004_01DTO inDto = new Se004_01DTO();

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDto, form);
        inDto.setTxtID_Kubun_Hoshiki(form.getTxtID_Expr1());

        // 入力チェックで追加されたメッセージを追加
        bizErrors.addAll(checkInput(form));

        // 扱店別稟議データの農協コードをチェック（入力された扱店が９９３７でかつログオンユーザ権限種別がH方式受託者又は受託者の場合実施する）
        if (0 == bizErrors.size()
                && form.getTxtID_Code_Organization().equals(Se004Constants.Code_Organization_9937)
                && (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                        || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)
                        || PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode))) {

            // Serviceの呼び出し
            Se004_01DTO outDto = new Se004_01DTO();
            outDto = se004_01service.getResultData(inDto);

            // サービスで追加されたメッセージを追加
            bizErrors.addAll(outDto.getBizErrors());
        }

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 検索結果の判定
        // 　画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
        // 　画面のメッセージが設定されていばい場合、画面遷移を行う。
        // 　　払込案内（照会結果画面）へ遷移する

        // 　　　画面に入力された公庫支店コード、扱店コード、店舗コード、年度、方式資金、番号、枝番を遷移パラメータに設定する。
        form.setSe004_02Code_ShokanHonShiten(form.getDrpID_Code_ShokanHonShiten());
        form.setSe004_02Code_Organization(form.getTxtID_Code_Organization());
        form.setSe004_02Code_Tenpo(form.getTxtID_Code_Tenpo());
        form.setSe004_02Year(form.getTxtID_Year());
        form.setSe004_02Kubun_Hoshiki(form.getTxtID_Expr1());
        form.setSe004_02ID_Ringi(form.getTxtID_ID_Ringi());
        form.setSe004_02ID_RingiBranch(form.getTxtID_ID_RingiBranch());

        // 　画面のメッセージが設定されていない場合、画面遷移を行う。
        // 　　払込案内（照会結果画面）へ遷移する
        // 　　　画面に入力された公庫支店コード、扱店コード、店舗コード、年度、方式資金、番号、枝番を遷移パラメータに設定する。
        setRequestNextScreen(request, form);

        // 　　　return success("Se004_02Init")
        return success(Se004Constants.EVENT_ID_SE004_02INIT);
    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form Se003_01Form
     */
    private void setRequestNextScreen(HttpServletRequest request, Se004_01Form form) {

        addForwardParameter(request, Se004Constants.PROPERTY_CODE_SHOKANHONSHITEN,
                form.getSe004_02Code_ShokanHonShiten());
        addForwardParameter(request, Se004Constants.PROPERTY_CODE_ORGANIZATION,
                form.getSe004_02Code_Organization());
        addForwardParameter(request, Se004Constants.PROPERTY_CODE_TENPO, form.getSe004_02Code_Tenpo());
        addForwardParameter(request, Se004Constants.PROPERTY_YEAR, form.getSe004_02Year());
        addForwardParameter(request, Se004Constants.PROPERTY_KUBUN_HOSHIKI, form.getSe004_02Kubun_Hoshiki());
        addForwardParameter(request, Se004Constants.PROPERTY_ID_RINGI, form.getSe004_02ID_Ringi());
        addForwardParameter(request, Se004Constants.PROPERTY_ID_RINGIBRANCH, form.getSe004_02ID_RingiBranch());
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
    public void displayControl(Model model, Se004_01Form form, HttpServletRequest request) {

    }

    /**
     * 業務固有の入力チェック
     *
     * @param form 入力画面情報
     * @return エラーリストを設定したDTO
     */
    private LinkedList<PNMessageInfo> checkInput(Se004_01Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // ①扱店コードチェック
        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、権限情報を代入します
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        // ログインユーザの権限種別＝受託者の場合実施する
        // 扱店コードが9937以外＆ログインユーザと扱店コードが一致しない
        if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)
                && (false == PNCommonComponents.cnvNulltoBlank(form.getTxtID_Code_Organization()).equals(
                        PNCommonConstants.CODE_NOUKYOU_9937) && false == PNCommonComponents.cnvNulltoBlank(
                        form.getTxtID_Code_Organization()).equals(commonInfo.getCode_Organization()))) {
            // 　　　メッセージ：ID_PN_SE004_007
            // メッセージを追加して継続
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3100E, new String[0], false));
            return bizErrors;
        }

        // ③年度チェック
        // 値チェック
// [UPD] Ver 3.0.0 - START
//        // 年度の先頭文字がM/T/S/H/m/t/s/hではない
//        List<String> list = Arrays.asList("M", "T", "S", "H", "m", "t", "s", "h");
//        if (false == list.contains(form.getTxtID_Year().substring(0, 1))) {
        // 年度の先頭文字が元号基本情報リストに存在しない
        if (false == PNCommonComponents.checkGengoAlphabet(form.getTxtID_Year().substring(0, 1), 0)) {
// [UPD] Ver 3.0.0 - END
            // 　　　メッセージ：ID_PN_SE004_001
            // メッセージを追加して継続
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                    new String[] { "年度は半角英数字3桁Gyy形式" }, false));
            return bizErrors;
        }
        // 年度の2,3文字目が数字ではない
        if (false == PNStringChecker.isNumeric(PNCommonComponents.cnvNulltoBlank(form.getTxtID_Year()
                .substring(1)))) {
            // 　　　メッセージ：ID_PN_SE004_001
            // メッセージを追加して継続
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                    new String[] { "年度は半角英数字3桁Gyy形式" }, false));
            return bizErrors;
        }
// [UPD] Ver 3.0.0 - START
//        // 年度がS64/s64の場合
//        if (form.getTxtID_Year().equals("S64") || form.getTxtID_Year().equals("s64")) {
//            // 　　　メッセージ：ID_PN_SE004_004
//            // メッセージを追加して継続
//            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3290E, new String[0], false));
//            return bizErrors;
//        }
        PNCommonComponents.checkGengoAppoint(form.getTxtID_Year(), 0, new String[] { "" }, bizErrors);
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