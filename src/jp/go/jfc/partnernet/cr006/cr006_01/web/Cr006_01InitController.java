//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01DTO;
import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01M1DTO;
import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

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
 * このクラスはCr006_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr006_01Form")
@RequestMapping(value = "/Cr006_01Init.form")
public class Cr006_01InitController extends Cr006_01BaseController {

    /** Cr006_01Service */
    @Autowired
    private Cr006_01Service cr006_01service;

    // 明細部id
    private static final String ID_MEISAI = "grdResults";
    // 作成ボタン
    private static final String ID_BUTTON_CREATE = "btnID_Create";

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
    public String executeAction(Model model, Cr006_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 明細部を非表示にする。
        form.setVisible(ID_MEISAI, false);
        form.setVisible(ID_BUTTON_CREATE, false);

        // Form項目の初期化を行う。
        PNPagingTable<Cr006_01M1DTO> cr006_01m1Table = form.getCr006_01M1Table();
        cr006_01m1Table.reset();

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 報告対象一覧の収集
        // DTOの生成
        Cr006_01DTO inDto = new Cr006_01DTO();

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDto, form);

        // Serviceの呼び出し
        Cr006_01DTO outDto = cr006_01service.getReportData(inDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // エラー判定
        // 取得結果の判定
        // 　取得件数が０の場合、何も行わない。
        if (0 == outDto.getReportList().size()) {
            return MY_VIEW;
        }

        // 　取得データがある場合、以下の処理を行う。
        // 1ページ当たりの表示件数をヒット件数に設定
        cr006_01m1Table.setResultsPerPage(outDto.getReportList().size());

        // Formへの転記処理をここに実装
        cr006_01m1Table.setRecordList(outDto.getReportList(), outDto.getReportList().size());
        CFWBeanUtils.copyProperties(form, outDto);

        // 更新結果で自画面を表示する
        // 明細表示
        form.setVisible(ID_MEISAI, true);
        form.setVisible(ID_BUTTON_CREATE, true);

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
    public void displayControl(Model model, Cr006_01Form form, HttpServletRequest request) {

    }
}