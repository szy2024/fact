//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_03ReloadController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_03.web;

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
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03Service;
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03DTO;

/**
 * <pre>
 * このクラスはut003_03の再表示ボタンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_03Form")
@RequestMapping(value = "/Ut003_03Reload.form")
public class Ut003_03ReloadController extends Ut003_03BaseController {

    /** Ut003_03Service */
    @Autowired
    Ut003_03Service ut003_03service;

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
    public String executeAction(Model model, Ut003_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // DTOの生成
        Ut003_03DTO inUt003_03DTO = new Ut003_03DTO();

        PNPagingTable<Ut003_03M1DTO> kinrijyohoList = form.getUt003_03M1Table();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inUt003_03DTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut003_03DTO outUt003_03DTO = ut003_03service.getHitCount(inUt003_03DTO);
        int hitCount = outUt003_03DTO.getKinrijyohoHitCount();
        kinrijyohoList.setInDtoInitPaging(inUt003_03DTO);
        outUt003_03DTO = ut003_03service.getResultData(inUt003_03DTO);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        kinrijyohoList.setPostPreNextPaging(outUt003_03DTO.getKinriJyohoList(), hitCount);
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
    public void displayControl(Model model, Ut003_03Form form, HttpServletRequest request) {

    }
}