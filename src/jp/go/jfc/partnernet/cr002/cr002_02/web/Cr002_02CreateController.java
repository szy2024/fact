//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr002.common.Cr002Constants;
import jp.go.jfc.partnernet.cr002.cr002_02.service.Cr002_02DTO;
import jp.go.jfc.partnernet.cr002.cr002_02.service.Cr002_02Service;
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
 * このクラスはcr002_02の登録コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr002_02Form")
@RequestMapping(value = "/Cr002_02Create.form")
public class Cr002_02CreateController extends Cr002_02BaseController {

    /** Cr002_02Service */
    @Autowired
    Cr002_02Service cr002_02service;

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
    public String executeAction(Model model, Cr002_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        Cr002_02DTO inDto = new Cr002_02DTO();

        // DTOへの転記処理
        CFWBeanUtils.copyProperties(inDto, form);

        // 更新処理を行う
        // Serviceの呼び出し
        Cr002_02DTO outDto = cr002_02service.setUpdateInputData(inDto);

        // Formへの転記処理
        CFWBeanUtils.copyProperties(form, outDto);

        // 完了画面メッセージ表示要フラグを遷移パラメータに設定する。
        addForwardParameter(request, Cr002Constants.PROPERTY_FLG_SEIKYUUPDATE, form.getFlgSeikyuUpdate());

        // 元利金受入・充当報告書作成（登録結果画面）へ遷移する
        // 　return success("Cr002_03Init")
        return success(Cr002Constants.EVENT_ID_CR002_03INIT);
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
    public void displayControl(Model model, Cr002_02Form form, HttpServletRequest request) {

    }
}