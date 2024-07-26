//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut002_01ChangeIDInfoTypeController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut002.ut002_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.ut002.ut002_01.service.Ut002_01DTO;
import jp.go.jfc.partnernet.ut002.ut002_01.service.Ut002_01Service;

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
 * このクラスはut002_01の「通知種別」プルダウンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut002_01Form")
@RequestMapping(value = "/Ut002_01ChangeIDInfoType.form")
public class Ut002_01ChangeIDInfoTypeController extends Ut002_01BaseController {

    /** Ut002_01Service */
    @Autowired
    Ut002_01Service ut002_01service;

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
    public String executeAction(Model model, Ut002_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // お知らせを取得する。
        // Ut002_01Service.getNews
        Ut002_01DTO inDto = new Ut002_01DTO();
        if ("".equals(form.getDrpID_ID_InfoType())) {
            // 通知種別がブランクの場合
            form.setTxtID_ID_InfoContents("");
            form.setDateTime_InfoUpdate(null);
            form.setDateTime_Update(null);
        } else {
            // 通知種別がブランク以外の場合

            // ■サービス呼び出し
            inDto.setDrpID_ID_InfoType(Integer.parseInt(form.getDrpID_ID_InfoType()));
            Ut002_01DTO outDto = ut002_01service.getNews(inDto);
            form.setTxtID_ID_InfoContents(outDto.getTxtID_ID_InfoContents());
            form.setDateTime_InfoUpdate(outDto.getDateTime_InfoUpdate());
            form.setDateTime_Update(outDto.getDateTime_Update());
        }

        // 画面遷移情報に自画面を設定する。
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
    public void displayControl(Model model, Ut002_01Form form, HttpServletRequest request) {

    }
}