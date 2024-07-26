//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.ut001.ut001_02.service.Ut001_02DTO;
import jp.go.jfc.partnernet.ut001.ut001_02.service.Ut001_02Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * このクラスはUt001_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut001_02Form")
@RequestMapping(value = "/Ut001_02Init.form")
public class Ut001_02InitController extends Ut001_02BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Ut001_02InitController.class);

    /** Ut001_02Service */
    @Autowired
    Ut001_02Service ut001_02service;

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
    public String executeAction(Model model, ut001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // サービスの呼び出し処理
        // 　Ut001_02Service.result // DTOの生成
        Ut001_02DTO inUt001_02DTO = new Ut001_02DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut001_02DTO outUt001_02DTO = ut001_02service.result(inUt001_02DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 　DAOから取得した情報をFORMに設定する
        if (0 < outUt001_02DTO.getTsuchiJimuList().size()) {
            form.getUt001_02M1Table().setResultsPerPage(outUt001_02DTO.getTsuchiJimuList().size());
        }
        CFWBeanUtils.copyProperties(form, outUt001_02DTO);
        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　return MY_VIEW

        // form.setTsuchiJimuList(outUt001_02DTO.getTsuchiJimuList());
        form.getUt001_02M1Table().setRecordList(outUt001_02DTO.getTsuchiJimuList(),
                outUt001_02DTO.getTsuchiJimuList().size());
        log.debug(outUt001_02DTO.getTsuchiJimuList());

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
    public void displayControl(Model model, ut001_02Form form, HttpServletRequest request) {

    }
}