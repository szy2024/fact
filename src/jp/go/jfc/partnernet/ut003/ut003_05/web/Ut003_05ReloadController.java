//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_05ReloadController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_05.web;

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
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05Service;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05DTO;

/**
 * <pre>
 * このクラスはut003_05の再表示ボタンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_05Form")
@RequestMapping(value = "/Ut003_05Reload.form")
public class Ut003_05ReloadController extends Ut003_05BaseController {

    /** Ut003_05Service */
    @Autowired
    Ut003_05Service ut003_05service;

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
    public String executeAction(Model model, Ut003_05Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // DTOの生成
        Ut003_05DTO inUt003_05DTO = new Ut003_05DTO();

        PNPagingTable<Ut003_05M1DTO> yoshikiList = form.getUt003_05M1Table();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inUt003_05DTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut003_05DTO outUt003_05DTO = ut003_05service.getHitCount(inUt003_05DTO);
        int hitCount = outUt003_05DTO.getYoshikisyuHitCount();
        yoshikiList.setInDtoInitPaging(inUt003_05DTO);
        outUt003_05DTO = ut003_05service.getResultData(inUt003_05DTO);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        yoshikiList.setPostPreNextPaging(outUt003_05DTO.getYoshikiList(), hitCount);
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
    public void displayControl(Model model, Ut003_05Form form, HttpServletRequest request) {

    }
}