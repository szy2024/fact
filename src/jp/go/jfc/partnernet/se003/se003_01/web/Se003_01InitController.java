//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/11/08 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_01.web;

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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.se003.se003_01.service.Se003_01Service;
import jp.go.jfc.partnernet.se003.se003_01.service.Se003_01DTO;
import jp.go.jfc.partnernet.se003.common.Se003Constants;

/**
 * <pre>
 * このクラスはSe003_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se003_01Form")
@RequestMapping(value = "/Se003_01Init.form")
public class Se003_01InitController extends Se003_01BaseController {

    /** Se003_01Service */
    @Autowired
    Se003_01Service se003_01service;

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
    public String executeAction(Model model, Se003_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面の全項目をクリアする。
        form.setDrpID_Code_ShokanHonShiten(""); // 公庫支店コード
        form.setTxtID_Code_Organization(""); // 扱店コード
        form.setTxtID_Code_Tenpo(""); // 店舗コード
        form.setTxtID_Year(""); // 年度
        form.setTxtID_Kubun_Hoshiki(""); // 方式資金
        form.setTxtID_ID_Ringi(""); // 番号
        form.setTxtID_ID_RingiBranch(""); // 枝番

        // ログインユーザの権限種別により、画面の公庫支店名、扱店名の入力可否及び初期値を設定する
        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、権限情報を代入します
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        // 　①ユーザ権限＝計数管理担当者、管理者
        if (PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)) {
            // 　　公庫支店コード：入力可　初期値＝空白
            form.setProtect(Se003Constants.DRP_CODE_SHOKANHONSHITEN, false);
            // 　　扱店コード　　　：入力可　初期値＝空白
            form.setProtect(Se003Constants.TXT_CODE_ORGANIZATION, false);

            // 　②ユーザ権限＝H方式受託者
        }
        else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
            // 　　公庫支店コード：入力可　初期値＝空白
            form.setProtect(Se003Constants.DRP_CODE_SHOKANHONSHITEN, false);
            // 　　扱店コード　　　：入力不可　初期値＝９９３７
            form.setProtect(Se003Constants.TXT_CODE_ORGANIZATION, true);
            form.setTxtID_Code_Organization(Se003Constants.Code_Organization_9937);

            // 　③ユーザ権限＝受託者
        }
        else if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            // 　　公庫支店コード：入力可　初期値＝空白
            form.setProtect(Se003Constants.DRP_CODE_SHOKANHONSHITEN, false);
            // 　　扱店コード　　　：入力可　初期値＝ログインユーザの扱店コード
            form.setProtect(Se003Constants.TXT_CODE_ORGANIZATION, false);
            form.setTxtID_Code_Organization(commonInfo.getCode_Organization());
        }

        // 公庫支店プルダウンリストを取得する。
        // 　サービスを実行し公庫支店プルダウンデータを取得する。
        // 　Se003_01Service.getSyokanHonShitenList 　　
        Se003_01DTO inDto = new Se003_01DTO();
        Se003_01DTO outDto = se003_01service.getSyokanHonShitenData(inDto);

        // 公庫支店プルダウンリストを画面に設定する。
        form.setShokanHonShitenLIST(outDto.getShokanHonShitenLIST());

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
    public void displayControl(Model model, Se003_01Form form, HttpServletRequest request) {

    }
}