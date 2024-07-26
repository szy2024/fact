//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.ut001.ut001_01.service.Ut001_01DTO;
import jp.go.jfc.partnernet.ut001.ut001_01.service.Ut001_01Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはUt001_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
// @CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut001_01Form")
@RequestMapping(value = "/Ut001_01Init.form")
public class Ut001_01InitController extends Ut001_01BaseController {

    /** Ut001_01Service */
    @Autowired
    Ut001_01Service ut001_01service;

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
    public String executeAction(Model model, Ut001_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // お知らせ（お知らせ照会結果画面）詳細内容を表示する

        // サービス呼び出しの処理
        // 　Ut001_01Service.detail // DTOの生成
        Ut001_01DTO inUt001_01DTO = new Ut001_01DTO();
        // Serviceの呼び出し
        Ut001_01DTO outUt001_01DTO = ut001_01service.detail(inUt001_01DTO);
        CFWBeanUtils.copyProperties(form, outUt001_01DTO);

        // 戻り値（画面遷移情報）に自画面を設定する。

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
    public void displayControl(Model model, Ut001_01Form form, HttpServletRequest request) {

    }
}