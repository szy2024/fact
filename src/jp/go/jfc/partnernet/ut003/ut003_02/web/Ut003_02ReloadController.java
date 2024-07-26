//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_02ReloadController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_02.web;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

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

import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.ut003.ut003_02.service.Ut003_02DTO;
import jp.go.jfc.partnernet.ut003.ut003_02.service.Ut003_02M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_02.service.Ut003_02Service;

/**
 * <pre>
 * このクラスはut003_02の再表示ボタンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_02Form")
@RequestMapping(value = "/Ut003_02Reload.form")
public class Ut003_02ReloadController extends Ut003_02BaseController {

    /** Ut003_02Service */
    @Autowired
    Ut003_02Service ut003_02service;

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
    public String executeAction(Model model, Ut003_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // DTOの生成
        Ut003_02DTO inUt003_02DTO = new Ut003_02DTO();

        PNPagingTable<Ut003_02M1DTO> tsuchijimuList = form.getUt003_02M1Table();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inUt003_02DTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut003_02DTO outUt003_02DTO = ut003_02service.getHitCount(inUt003_02DTO);
        int hitCount = outUt003_02DTO.getTsuchijimuHitCount();
        tsuchijimuList.setInDtoInitPaging(inUt003_02DTO);
        outUt003_02DTO = ut003_02service.getResultData(inUt003_02DTO);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        tsuchijimuList.setPostPreNextPaging(outUt003_02DTO.getTsuchiJimuRenrakuList(), hitCount);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

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
    public void displayControl(Model model, Ut003_02Form form, HttpServletRequest request) {

    }
}