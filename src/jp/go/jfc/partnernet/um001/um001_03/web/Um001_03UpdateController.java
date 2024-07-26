//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_03UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_03.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.um001.common.Um001Constants;
import jp.go.jfc.partnernet.um001.um001_03.service.Um001_03DTO;
import jp.go.jfc.partnernet.um001.um001_03.service.Um001_03Service;

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
 * このクラスはUm001_03の変更ボタンコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("um001_03Form")
@RequestMapping(value = "/Um001_03Update.form")
public class Um001_03UpdateController extends Um001_03BaseController {

    /** Um001_03Service */
    @Autowired
    Um001_03Service um001_03service;

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
    public String executeAction(Model model, Um001_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // サービス起動パラメータを設定（Um001_03DTO)
        // フォームの同名項目を設定する。

        // Um001_03Service.update // DTOの生成
        Um001_03DTO inUm001_03DTO = new Um001_03DTO();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inUm001_03DTO, form);
        inUm001_03DTO.setFlag_ForceChgPwdFistLogon(PNCommonComponents.cnvNulltoZero(form
                .getFlag_ForceChgPwdFistLogon()));
        inUm001_03DTO.setFlag_ForceChgPwdRoutine(PNCommonComponents.cnvNulltoZero(form
                .getFlag_ForceChgPwdRoutine()));
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        // Um001_03DTO outUm001_03DTO = um001_03service.update(inUm001_03DTO);
        Um001_03DTO outUm001_03DTO = um001_03service.update(inUm001_03DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outUm001_03DTO);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // サービスが正常の場合、利用者状態一覧表示画面に登録結果を表示する為、下記遷移パラメタを設定する。
        // 　"PM1040I"　→　遷移パラメタ.メッセージID
        this.addForwardParameter(request, Um001Constants.PROPERTY_MSG_ID, PNCommonMessageConstants.PM1040I);

        // 戻り値（画面遷移情報）に下記を設定する。
        // 　success("Um001_03Update")
        return success(Um001Constants.EVENT_ID_UM001_03UPDATE);

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
    public void displayControl(Model model, Um001_03Form form, HttpServletRequest request) {

    }
}