//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.web;

import java.util.LinkedList;

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

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr003.common.Cr003Constants;
import jp.go.jfc.partnernet.cr003.cr003_03.service.Cr003_03Service;
import jp.go.jfc.partnernet.cr003.cr003_03.service.Cr003_03DTO;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

/**
 * <pre>
 * このクラスはCr003_03の登録コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr003_03Form")
@RequestMapping(value = "/Cr003_03Send.form")
public class Cr003_03SendController extends Cr003_03BaseController {

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Cr003_03Service */
    @Autowired
    Cr003_03Service cr003_03service;

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
    public String executeAction(Model model, Cr003_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        // 更新処理を行う。
        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // ＤＢ登録・更新を行う
        // 　　サービス起動パラメータ設定（明細、報告年月日）
        // 　　　Cr003_03Service.setUpdateInputData // DTOの生成
        // Cr003_03DTO inCr003_03DTO = new Cr003_03DTO();

        // DTOの生成
        Cr003_03DTO inDto = new Cr003_03DTO();
        Cr003_03DTO outDto = new Cr003_03DTO();

        // 報告日設定
        inDto.setLblID_Date_Report(form.getLblID_Date_Report());

        // テーブル作成
        inDto.setMEISAI_AnkenLIST(form.getCr003_03M1TableRecord());

        // Serviceの呼び出し
        // Cr003_03DTO outCr003_03DTO = cr003_03service.setUpdateInputData(inCr003_03DTO);

        // Serviceの呼び出し
        outDto = cr003_03service.setUpdateInputData(inDto);
        // エラー発生時は画面遷移しない
        // エラー判定

        bizErrors = outDto.getBizErrors();
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }
        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);
        // 元利金受入・充当報告書作成（登録結果画面）へ遷移する
        return success(Cr003Constants.EVENT_ID_CR003_04INIT);

        // return MY_VIEW;
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
    public void displayControl(Model model, Cr003_03Form form, HttpServletRequest request) {

    }
}