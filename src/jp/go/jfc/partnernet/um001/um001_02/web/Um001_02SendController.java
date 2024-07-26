//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.um001.common.Um001Constants;
import jp.go.jfc.partnernet.um001.um001_02.service.Um001_02DTO;
import jp.go.jfc.partnernet.um001.um001_02.service.Um001_02Service;

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
 * このクラスはUm001_02の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("um001_02Form")
@RequestMapping(value = "/Um001_02Send.form")
public class Um001_02SendController extends Um001_02BaseController {

    /** Um001_02Service */
    @Autowired
    Um001_02Service um001_02service;

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
    public String executeAction(Model model, Um001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        Um001_02DTO inDto = new Um001_02DTO();
        Um001_02DTO outDto = null;

        // サービス起動パラメータを設定する(Um001_02DTO)
        // ・form.利用者一覧　→　inDto
        inDto.setUserList(form.getUm001_02M1Table().getRecordList());

        // サービスを起動し、利用者情報の削除並びに更新を行う。
        // Um001_02Service.updateCurrentPage(inDto)
        outDto = um001_02service.updateCurrentPage(inDto);

        // 遷移後の自画面に削除・更新結果を表示する為、下記画面遷移パラメタを設定する。
        // ・遷移元画面ID（orgScreenId）　： um001_02
        // ・削除件数（deleteCount）　　　： DTO.削除件数
        // ・更新件数（updateCount）　　　： DTO.更新件数
        this.addForwardParameter(request, Um001Constants.PROPERTY_MSG_ID, PNCommonMessageConstants.PM1060I);
        this.addForwardParameter(request, Um001Constants.PROPERTY_DEL_CNT,
                Integer.toString(outDto.getDeleteCount()));
        this.addForwardParameter(request, Um001Constants.PROPERTY_UPD_CNT,
                Integer.toString(outDto.getUpdateCount()));

        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　success("Um001_02Send")
        return success(Um001Constants.EVENT_ID_UM001_02SEND);
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
    public void displayControl(Model model, Um001_02Form form, HttpServletRequest request) {

    }
}