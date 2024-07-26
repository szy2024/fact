//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.web;

import static jp.go.jfc.partnernet.se010.common.Se010Constants.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.se010.se010_02.service.Se010_02DTO;
import jp.go.jfc.partnernet.se010.se010_02.service.Se010_02Service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * このクラスはSe010_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se010_02Form")
@RequestMapping(value = "/Se010_02Init.form")
public class Se010_02InitController extends Se010_02BaseController {

    /** Se010_02Service */
    @Autowired
    Se010_02Service se010_02service;

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
    public String executeAction(Model model, Se010_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡パラメータを取得する。
        Se010_02DTO inDto = getRequestPreviousScreen(request);

        // 　　Se010_02Service.getKurishoTesuryo // DTOの生成
        Se010_02DTO outDto = null;

        // サービスを実行し繰上償還利息を取得する。
        outDto = se010_02service.getKurishoRisoku(inDto);

        // エラー発生時
        if (!StringUtils.isEmpty(outDto.getID_Error())) {
            addForwardParameter(request, ERROR_KURISHO, outDto.getID_Error());
            return success(EVENT_ID_SE010_01RETURN);
        }

        // サービスを実行し繰上償還手数料を取得する。
        inDto.setID_strKurishoRisoku(outDto.getID_strKurishoRisoku());
        outDto = se010_02service.getKurishoTesuryo(inDto);

        // エラー発生時
        if (!StringUtils.isEmpty(outDto.getID_Error())) {
            addForwardParameter(request, ERROR_KURISHO, outDto.getID_Error());
            return success(EVENT_ID_SE010_01RETURN);
        }

        // 融資番号
        String yushiNo = inDto.getDrpID_Code_ShokanHonShiten() + "-" + inDto.getTxtID_Code_Organization()
                + "-" + inDto.getTxtID_Code_Tenpo() + "-" + inDto.getTxtID_Year().toUpperCase() + "-"
                + inDto.getTxtID_HoshikiShikin() + "-" + inDto.getTxtID_ID_Ringi();

        if (StringUtils.isNotEmpty(inDto.getTxtID_ID_RingiBranch())
                && !"0".equals(inDto.getTxtID_ID_RingiBranch())) {
            yushiNo = yushiNo + "-" + inDto.getTxtID_ID_RingiBranch();
        }
        form.setYushiNo(yushiNo);
        // 繰上償還日
        form.setDateKuriageShokan(PNCommonComponents.dateFmtJC_Gyy(inDto.getDrpID_Date_KuriageShokan_Wareki()
                + inDto.getTxtID_Date_KuriageShokan_Year())
                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Month()))
                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Date())));
        // 繰上償還額
        form.setKuriageShokan(inDto.getTxtID_M_KuriageShokan());
        // 繰償後第一回払込期日
        form.setDateKurishoTaishokijitsu(PNCommonComponents.dateFmtJC_Gyy(inDto
                .getDrpID_Date_FirstHaraikomiAfterKuriS_Wareki()
                + inDto.getTxtID_Date_FirstHaraikomiAfterKuriS_Year())
                + String.format("%02d",
                        Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Month()))
                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Date())));
        // 繰償時利率
        form.setKurishojiRiritsu(inDto.getTxtID_KurishojiRiritsu());
        // 繰償事由コード
        form.setKurishoJiyu(inDto.getDrpID_Code_KurishoJiyu());
        // 元金均等額
        form.setGankinkinto(inDto.getTxtID_M_Gankinkinto());
        // 元金不均等額
        form.setGankinfukinto(inDto.getTxtID_M_Gankinfukinto());
        // 調整コード
        form.setCodeChosei(inDto.getRadioID_Code_Chosei());
        // 免除対象額
        form.setMenjoTaisho(inDto.getTxtID_M_MenjoTaisho());
        // 免除後元金均等額
        form.setMenjogoGankinkinto(inDto.getTxtID_M_MenjogoGankinkinto());
        // 免除後元金不均等額
        form.setMenjogoGankinfukinto(inDto.getTxtID_M_MenjogoGankinfukinto());
        // 免除後調整コード
        form.setCodeChoseiMenjogo(inDto.getRadioID_Code_Chosei_Menjogo());

        // 繰上償還利息
        form.setKurishoRisoku(outDto.getID_strKurishoRisoku());

        // 繰上償還手数料
        form.setKurishoTesuryo(outDto.getID_strKurishoTesuryo());

        // 検索結果の判定
        // 　　シュミレーション結果を取得する。
        // 　　取得した値を画面に設定する。
        // 　　※データ無しの場合、サービスにてメッセージが設定されている。

        // return MY_VIEW

        return MY_VIEW;
    }

    /**
     * 前画面からの情報取得
     *
     * @param request
     * @return Se010_02DTO
     */
    private Se010_02DTO getRequestPreviousScreen(HttpServletRequest request) {
        Se010_02DTO dto = new Se010_02DTO();
        Map<String, Object> paramMap = getForwardParameter(request);

        dto.setDrpID_Code_ShokanHonShiten((String) paramMap.get(PROPERTY_CODE_SHOKANHONSHITEN));
        dto.setTxtID_Code_Organization((String) paramMap.get(PROPERTY_CODE_ORGANIZATION));
        dto.setTxtID_Code_Tenpo((String) paramMap.get(PROPERTY_CODE_TENPO));
        dto.setTxtID_Year((String) paramMap.get(PROPERTY_YEAR));
        dto.setTxtID_HoshikiShikin((String) paramMap.get(PROPERTY_HOSHIKISHIKIN));
        dto.setTxtID_ID_Ringi((String) paramMap.get(PROPERTY_ID_RINGI));
        dto.setTxtID_ID_RingiBranch((String) paramMap.get(PROPERTY_ID_RINGIBRANCH));

        dto.setDrpID_Date_KuriageShokan_Wareki((String) paramMap.get(PROPERTY_KURIAGESHOKAN_WAREKI));
        dto.setTxtID_Date_KuriageShokan_Year((String) paramMap.get(PROPERTY_KURIAGESHOKAN_YEAR));
        dto.setDrpID_Date_KuriageShokan_Month((String) paramMap.get(PROPERTY_KURIAGESHOKAN_MONTH));
        dto.setDrpID_Date_KuriageShokan_Date((String) paramMap.get(PROPERTY_KURIAGESHOKAN_DATE));
        dto.setTxtID_M_KuriageShokan((String) paramMap.get(PROPERTY_M_KURIAGESHOKAN));
        dto.setDrpID_Date_FirstHaraikomiAfterKuriS_Wareki((String) paramMap
                .get(PROPERTY_FIRSTHARAIKOMIAFTERKURIS_WAREKI));
        dto.setTxtID_Date_FirstHaraikomiAfterKuriS_Year((String) paramMap
                .get(PROPERTY_FIRSTHARAIKOMIAFTERKURIS_YEAR));
        dto.setDrpID_Date_FirstHaraikomiAfterKuriS_Month((String) paramMap
                .get(PROPERTY_FIRSTHARAIKOMIAFTERKURIS_MONTH));
        dto.setDrpID_Date_FirstHaraikomiAfterKuriS_Date((String) paramMap
                .get(PROPERTY_FIRSTHARAIKOMIAFTERKURIS_DATE));

        dto.setRadioID_TesuryoKeisan((String) paramMap.get(PROPERTY_TESURYO));
        dto.setTxtID_KurishojiRiritsu((String) paramMap.get(PROPERTY_KURISHOJIRIRITSU));
        dto.setDrpID_Code_KurishoJiyu((String) paramMap.get(PROPERTY_CODE_KURISHOJIYU));
        dto.setTxtID_M_Gankinkinto(StringUtils.trimToNull((String) paramMap.get(PROPERTY_M_GANKINKINTO)));
        dto.setTxtID_M_Gankinfukinto(StringUtils.trimToNull((String) paramMap.get(PROPERTY_M_GANKINFUKINTO)));
        dto.setRadioID_Code_Chosei((String) paramMap.get(PROPERTY_CODE_CHOSEI));
        dto.setTxtID_M_MenjoTaisho(StringUtils.trimToNull((String) paramMap.get(PROPERTY_M_MENJOTAISHO)));
        dto.setTxtID_M_MenjogoGankinkinto(StringUtils.trimToNull((String) paramMap
                .get(PROPERTY_M_MENJOGOGANKINKINTO)));
        dto.setTxtID_M_MenjogoGankinfukinto(StringUtils.trimToNull((String) paramMap
                .get(PROPERTY_M_MENJOGOGANKINFUKINTO)));
        dto.setRadioID_Code_Chosei_Menjogo((String) paramMap.get(PROPERTY_CODE_CHOSEI_MENJOGO));

        return dto;
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
    public void displayControl(Model model, Se010_02Form form, HttpServletRequest request) {

    }
}