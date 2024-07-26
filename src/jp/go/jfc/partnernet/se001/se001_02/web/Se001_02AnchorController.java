//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_02AnchorController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_02.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.se001.common.Se001Constants;
import jp.go.jfc.partnernet.se001.se001_02.service.Se001_02M1DTO;

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
 * このクラスはse001_02の顧客名コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se001_02Form")
@RequestMapping(value = "/Se001_02Anchor.form")
public class Se001_02AnchorController extends Se001_02BaseController {

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
    public String executeAction(Model model, Se001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        // 選択履歴番号の取得
        int index = Integer.parseInt(form.getLinkno());

        List<Se001_02M1DTO> reportList = form.getSe001_02M1TableRecord();

        // 受渡パラメータ.を取得する。
        // 　明細１の顧客名選択位置の扱店コード、貸付先コードを取得する。
        String out_organaization = reportList.get(index).getID_Code_Organization();
        String out_codecustomer = reportList.get(index).getSe001_02_Ans_Code_Customer();

        // 遷移パラメータの設定
        // 　扱店コード、貸付先コードを遷移パラメータへ設定する。
        addForwardParameter(request, Se001Constants.PROPERTY_IN_CODE_ORGANIZATION, out_organaization);
        addForwardParameter(request, Se001Constants.PROPERTY_IN_CODE_CUSTOMER, out_codecustomer);

        // 顧客情報照会（照会結果画面）を呼出す。
        return success(Se001Constants.EVENT_ID_SE001_03INIT);
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
    public void displayControl(Model model, Se001_02Form form, HttpServletRequest request) {

    }

}