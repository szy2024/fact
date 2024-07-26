//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.ut001.ut001_03.service.Ut001_03DTO;
import jp.go.jfc.partnernet.ut001.ut001_03.service.Ut001_03Service;

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
 * このクラスはUt001_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut001_03Form")
@RequestMapping(value = "/Ut001_03Init.form")
public class Ut001_03InitController extends Ut001_03BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Ut001_03InitController.class);

    /** Ut001_03Service */
    @Autowired
    Ut001_03Service ut001_03service;

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
    public String executeAction(Model model, ut001_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // サービスの呼出し処理
        // Ut001_03Service.result // DTOの生成
        Ut001_03DTO inUt001_03DTO = new Ut001_03DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut001_03DTO outUt001_03DTO = ut001_03service.result(inUt001_03DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // DAOから取得した情報をFORMに設定する
        if (0 < outUt001_03DTO.getKinriJyohoList().size()) {
            form.getUt001_03M1Table().setResultsPerPage(outUt001_03DTO.getKinriJyohoList().size());
        }
        CFWBeanUtils.copyProperties(form, outUt001_03DTO);
        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　return MY_VIEW
        form.getUt001_03M1Table().setRecordList(outUt001_03DTO.getKinriJyohoList(),
                outUt001_03DTO.getKinriJyohoList().size());
        log.debug(outUt001_03DTO.getKinriJyohoList());

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
    public void displayControl(Model model, ut001_03Form form, HttpServletRequest request) {

    }
}