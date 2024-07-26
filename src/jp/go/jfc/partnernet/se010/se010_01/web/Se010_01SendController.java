//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
// 2.0.0   | 2019/01/30 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.web;

import static jp.go.jfc.partnernet.se010.common.Se010Constants.*;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se010.se010_01.service.Se010_01DTO;
import jp.go.jfc.partnernet.se010.se010_01.service.Se010_01Service;

import org.apache.commons.lang.StringUtils;
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
 * このクラスはSe010_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se010_01Form")
@RequestMapping(value = "/Se010_01Send.form")
public class Se010_01SendController extends Se010_01BaseController {

    /** Se010_01Service */
    @Autowired
    Se010_01Service se010_01service;

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
    public String executeAction(Model model, Se010_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 扱店コード
        // 　　　扱店コードが9937以外でかつ扱店がログインユーザの扱店コードと一致しない場合、エラーとする。
        // 　　　（ログインユーザの権限種別＝受託者の場合実施する）
        // 　　　　メッセージ：PM3140E
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        if (!PNCommonConstants.CODE_NOUKYOU_9937.equals(form.getTxtID_Code_Organization())) {
            // ログインユーザの権限種別＝受託者の場合
            if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(loginInfo.getRoleCode())) {
                if (!form.getTxtID_Code_Organization().equals(loginInfo.getCode_Organization())) {
                    addMessage(errors, PNCommonMessageConstants.PM3100E, null, false);
                    return MY_VIEW;
                }
            }
        }

        // 店舗コードチェック

        // 年度チェック
        // 　③値チェック
        // 　　　年度の先頭１文字目がM/T/S/H/m/t/s/hでない場合、エラーとする。
        // 　　　年度の２，３文字目が数字でない場合、エラーとする。
        // 　　　　メッセージ：PM3140E
// [UPD] Ver 2.0.0 - START
//        if (!form.getTxtID_Year().matches("^[M|T|S|H|m|t|s|h]+[0-9]{1,2}$")) {
//            String[] errMessage = {"年度は半角英数字3桁Gyy形式"};
//            addMessage(errors, PNCommonMessageConstants.PM3140E, errMessage, false);
//            return MY_VIEW;
//        }
        if (false == PNCommonComponents.checkGengoAlphabet(form.getTxtID_Year().substring(0, 1), 0)) {
            String errMessage = "年度は半角英数字3桁Gyy形式";
            addMessage(errors, PNCommonMessageConstants.PM3140E, new String[]{errMessage}, false);
            return MY_VIEW;
        }
// [UPD] Ver 2.0.0 - END

        // 　　　年度がS64/s64の場合、エラーとする。
        // 　　　　メッセージ：PM3290E
// [UPD] Ver 2.0.0 - START
//        if (form.getTxtID_Year().equalsIgnoreCase("S64")) {
//            addMessage(errors, PNCommonMessageConstants.PM3290E, null, false);
//            return MY_VIEW;
//        }
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        PNCommonComponents.checkGengoAppoint(form.getTxtID_Year(), 0, new String[]{""}, bizErrors);
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
// [UPD] Ver 2.0.0 - END
        if (StringUtils.isEmpty(PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year()))) {
// [UPD] Ver 2.0.0 - START
//            String[] errMessage = {"年度は半角英数字3桁Gyy形式"};
            String[] errMessage = {"年度は正しい元号と和暦"};
// [UPD] Ver 2.0.0 - END
            addMessage(errors, PNCommonMessageConstants.PM3140E, errMessage, false);
            return MY_VIEW;
        }

        // 手数料計算ありの場合
        if (CALC_TESURYO.equals(form.getRadioID_Tesuryo())) {
            // 繰償時利率
            // 　①必須チェック
            // 　　　繰償時利率が未入力の場合、エラーとする。
            // 　　　　メッセージ：PM3120E
            if (StringUtils.isEmpty(form.getTxtID_KurishojiRiritsu())) {
                String[] key = {PROPERTY_KURISHOJIRIRITSU};
                addMessage(errors, PNCommonMessageConstants.PM3120E, key);
                return MY_VIEW;
            }

            // 　②値チェック
            // 　　　繰償時利率が数字でない場合、エラーとする。
            // 　　　繰償時利率がマイナスの場合、エラーとする。
            // 　　　　メッセージ：PM3140E
            // 　③数値チェック
            // 　　　繰償時利率が数値でない場合、エラーとする。
            // 　　　　メッセージ：PM3140E
            // 　④数値範囲チェック
            // 　　　繰償時利率が「nn.nnn」（2桁.3桁）または「nn」（2桁）の半角数値でない場合、エラーとする。
            // 　　　繰償時利率が数字の場合、0.001から99.999の範囲外の場合、エラーとする。
            // 　　　　メッセージ：PM3140E
            // マイナスチェックは次で行う
            if (!PNCommonComponents.checkHalfNum(form.getTxtID_KurishojiRiritsu(), 2, 3, true, true)) {
                String[] errMessage = {"繰償時利率は99.999形式"};
                addMessage(errors, PNCommonMessageConstants.PM3140E, errMessage, false);
                return MY_VIEW;

            }

            // 元金均等額
            // 元金不均等額
            // 免除対象額
            // 免除後元金均等額
            // 免除後元金不均等額

            // 繰償事由コード
            // 　①必須チェック
            // 　　　繰償事由コードが未入力の場合、エラーとする。
            // 　　　　メッセージ：PM3160E
            if (StringUtils.isEmpty(form.getDrpID_Code_KurishoJiyu())) {
                String[] key = {PROPERTY_CODE_KURISHOJIYU};
                addMessage(errors, PNCommonMessageConstants.PM3160E, key);
                return MY_VIEW;
            }
        }
        // 手数料計算なしの場合
        else {
            // 繰償時利率
            // 　①必須チェック
            // 　　繰償時利率が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_KurishojiRiritsu())) {
                String[] key = {PROPERTY_KURISHOJIRIRITSU};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 繰償事由コード
            // 　①必須チェック
            // 　　　繰償事由コードが入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getDrpID_Code_KurishoJiyu())) {
                String[] key = {PROPERTY_CODE_KURISHOJIYU};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 元金均等額
            // 　①必須チェック
            // 　　　元金均等額が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_M_Gankinkinto())) {
                String[] key = {PROPERTY_M_GANKINKINTO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 元金不均等額
            // 　①必須チェック
            // 　　　元金不均等額が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_M_Gankinfukinto())) {
                String[] key = {PROPERTY_M_GANKINFUKINTO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 元金不均等額の調整コード
            // 　①必須チェック
            // 　　　初回・最終回のいずれかが選択されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getRadioID_Code_Chosei())
                    && !NOT_CHOSEI.equals(form.getRadioID_Code_Chosei())) {
                String[] key = {PROPERTY_CODE_CHOSEI};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 免除対象額
            // 　①必須チェック
            // 　　　免除対象額が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_M_MenjoTaisho())) {
                String[] key = {PROPERTY_M_MENJOTAISHO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 免除後元金均等額
            // 　①必須チェック
            // 　　　免除後元金均等額が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_M_MenjogoGankinkinto())) {
                String[] key = {PROPERTY_M_MENJOGOGANKINKINTO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 免除後元金不均等額
            // 　①必須チェック
            // 　　　免除後元金不均等額が入力されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getTxtID_M_MenjogoGankinfukinto())) {
                String[] key = {PROPERTY_M_MENJOGOGANKINFUKINTO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }

            // 免除後元金不均等額の調整コード
            // 　①必須チェック
            // 　　　初回・最終回のいずれかが選択されている場合、エラーとする。
            // 　　　　メッセージ：PM3130E
            if (!StringUtils.isEmpty(form.getRadioID_Code_Chosei_Menjogo())
                    && !NOT_CHOSEI.equals(form.getRadioID_Code_Chosei_Menjogo())) {
                String[] key = {PROPERTY_CODE_CHOSEI_MENJOGO};
                addMessage(errors, PNCommonMessageConstants.PM3130E, key);
                return MY_VIEW;
            }
        }

        Se010_01DTO inDto = new Se010_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);
        // セッションから利用者の扱店コード、権限種別を取得し、Se010_01DTOにセットする。
        inDto.setUser_Code_Organization(loginInfo.getCode_Organization());
        inDto.setUser_RoleId(loginInfo.getRoleCode());
        // 元号付和暦を西暦に変換してセットする
        inDto.setTxtID_Year(PNCommonComponents.dateFmtJC_Gyy(form.getTxtID_Year()));

        // 枝番が空の場合、「0」をセットする。
        if (StringUtils.isEmpty(form.getTxtID_ID_RingiBranch())) {
            inDto.setTxtID_ID_RingiBranch("0");
        }

        // Serviceの呼び出し
        se010_01service.validateKurishoKeisan(inDto);

        // 次画面への引き渡し情報を設定する
        setRequestNextScreen(request, form);

        // 画面遷移を行う
        return success(EVENT_ID_SE010_02INIT);
    }

    /**
     * 次画面への引き渡し情報設定
     *
     * @param request
     * @param form
     */
    private void setRequestNextScreen(HttpServletRequest request, Se010_01Form form) {

        // 公庫支店コード
        addForwardParameter(request, PROPERTY_CODE_SHOKANHONSHITEN, form.getDrpID_Code_ShokanHonShiten());
        // 扱店コード
        addForwardParameter(request, PROPERTY_CODE_ORGANIZATION, form.getTxtID_Code_Organization());
        // 店舗コード
        addForwardParameter(request, PROPERTY_CODE_TENPO, form.getTxtID_Code_Tenpo());
        // 年度
        addForwardParameter(request, PROPERTY_YEAR, form.getTxtID_Year());
        // 方式資金
        addForwardParameter(request, PROPERTY_HOSHIKISHIKIN, form.getTxtID_HoshikiShikin());
        // 番号
        addForwardParameter(request, PROPERTY_ID_RINGI, form.getTxtID_ID_Ringi());
        // 枝番
        addForwardParameter(request, PROPERTY_ID_RINGIBRANCH, form.getTxtID_ID_RingiBranch());
        // 繰上償還日(元号)
        addForwardParameter(request, PROPERTY_KURIAGESHOKAN_WAREKI, form.getDrpID_Date_KuriageShokan_Wareki());
        // 繰上償還日(年)
        addForwardParameter(request, PROPERTY_KURIAGESHOKAN_YEAR, form.getTxtID_Date_KuriageShokan_Year());
        // 繰上償還日(月)
        addForwardParameter(request, PROPERTY_KURIAGESHOKAN_MONTH, form.getDrpID_Date_KuriageShokan_Month());
        // 繰上償還日(日)
        addForwardParameter(request, PROPERTY_KURIAGESHOKAN_DATE, form.getDrpID_Date_KuriageShokan_Date());
        // 繰上償還額
        addForwardParameter(request, PROPERTY_M_KURIAGESHOKAN, form.getTxtID_M_KuriageShokan());
        // 繰償後第一回払込期日(元号)
        addForwardParameter(request, PROPERTY_FIRSTHARAIKOMIAFTERKURIS_WAREKI,
                form.getDrpID_Date_FirstHaraikomiAfterKuriS_Wareki());
        // 繰償後第一回払込期日(年)
        addForwardParameter(request, PROPERTY_FIRSTHARAIKOMIAFTERKURIS_YEAR,
                form.getTxtID_Date_FirstHaraikomiAfterKuriS_Year());
        // 繰償後第一回払込期日(月)
        addForwardParameter(request, PROPERTY_FIRSTHARAIKOMIAFTERKURIS_MONTH,
                form.getDrpID_Date_FirstHaraikomiAfterKuriS_Month());
        // 繰償後第一回払込期日(日)
        addForwardParameter(request, PROPERTY_FIRSTHARAIKOMIAFTERKURIS_DATE,
                form.getDrpID_Date_FirstHaraikomiAfterKuriS_Date());
        // 手数料計算
        addForwardParameter(request, PROPERTY_TESURYO, form.getRadioID_Tesuryo());
        // 繰償時利率
        addForwardParameter(request, PROPERTY_KURISHOJIRIRITSU, form.getTxtID_KurishojiRiritsu());
        // 繰償事由コード
        addForwardParameter(request, PROPERTY_CODE_KURISHOJIYU, form.getDrpID_Code_KurishoJiyu());
        // 元金均等額
        addForwardParameter(request, PROPERTY_M_GANKINKINTO, form.getTxtID_M_Gankinkinto());
        // 元金不均等額
        addForwardParameter(request, PROPERTY_M_GANKINFUKINTO, form.getTxtID_M_Gankinfukinto());
        // 調整コード
        addForwardParameter(request, PROPERTY_CODE_CHOSEI, form.getRadioID_Code_Chosei());
        // 免除対象額
        addForwardParameter(request, PROPERTY_M_MENJOTAISHO, form.getTxtID_M_MenjoTaisho());
        // 免除後元金均等額
        addForwardParameter(request, PROPERTY_M_MENJOGOGANKINKINTO, form.getTxtID_M_MenjogoGankinkinto());
        // 免除後元金不均等額
        addForwardParameter(request, PROPERTY_M_MENJOGOGANKINFUKINTO, form.getTxtID_M_MenjogoGankinfukinto());
        // 免除後調整コード
        addForwardParameter(request, PROPERTY_CODE_CHOSEI_MENJOGO, form.getRadioID_Code_Chosei_Menjogo());

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
    public void displayControl(Model model, Se010_01Form form, HttpServletRequest request) {

    }
}