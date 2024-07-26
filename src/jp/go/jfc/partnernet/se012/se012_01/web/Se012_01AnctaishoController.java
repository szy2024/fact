//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_01AnctaishoController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.se012.common.Se012Constants;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはse012_01の対象年月アンカーコントローラークラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se012_01Form")
@RequestMapping(value = "/Se012_01Anctaisho.form")
public class Se012_01AnctaishoController extends Se012_01BaseController {

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
     *      org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     *
     */
    @Override
    public String executeAction(Model model, Se012_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        int selectedIndex = 0;
        try {
            selectedIndex = Integer.parseInt(form.getSelectedindex());
        }
        catch (NumberFormatException e) {
            throw new PNSystemException(e);
        }

        // 受け渡し情報の設定
        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（扱店コード）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_CODE_ORGANIZATION,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getLblid_code_organization());

        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（扱店名）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_NAME_ORGANIZATION,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getLblid_name_organization());

        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（店舗コード）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_CODE_TENPO,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getLblid_code_tenpo());

        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（店舗名）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_NAME_TENPO,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getLblid_name_tenpo());

        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（情報提供日）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_DATE_JYOHOTEIKYO,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getLblid_date_jyohoteikyo());

        // 選択行番号行位置の業務委託手数料通知対象年月一覧の扱店コードを受け渡し情報（対象年月）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_DATE_TAISHO,
                form.getSe012_01M1Table().getRecordList().get(selectedIndex).getAncid_date_taisho());

        // 業務委託手数料通知対象年月一覧検索時の検索扱店コードを受け渡し情報（検索条件_検索扱店コード）に設定する。
        addForwardParameter(request,
                Se012Constants.LBLID_KEEP_SRCCODE_ORGANIZATION,
                form.getBksearchcondition().getTxtid_srccode_organization());

        // 戻り値（画面遷移情報）に遷移先を設定する。
        return success("Se012_02Init");
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se012_01Form form,
            HttpServletRequest request) {

    }
}