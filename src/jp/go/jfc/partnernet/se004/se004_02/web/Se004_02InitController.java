//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_02.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se004.se004_02.service.Se004_02DTO;
import jp.go.jfc.partnernet.se004.se004_02.service.Se004_02M1DTO;
import jp.go.jfc.partnernet.se004.se004_02.service.Se004_02Service;

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
 * このクラスはSe004_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se004_02Form")
@RequestMapping(value = "/Se004_02Init.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Se004_02InitController extends Se004_02BaseController {

    /** Se004_02Service */
    @Autowired
    Se004_02Service se004_02service;

    // 明細部ID
    private static final String ID_MEISAI = "se004_02Table";

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se004_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Form項目の初期化
        PNPagingTable<Se004_02M1DTO> se004_02m1Table = form.getSe004_02M1Table();
        se004_02m1Table.reset();

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // ０件の時に明細は枠を含め表示しない
        form.setVisible(ID_MEISAI, true);

        // サービス起動パラメータ設定（受渡パラメータの公庫支店コード、扱店コード、店舗コード、年度（和暦）、方式資金、番号、枝番）
        Se004_02DTO inDto = new Se004_02DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        // サービスを実行し債権情報照会データを取得する。
        // Serviceの呼び出し
        Se004_02DTO outDto = se004_02service.getResultData(inDto);

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            form.setVisible(ID_MEISAI, false);
            // // エラー有の場合自画面表示（取得件数が０件の場合）
            throw new PNServiceException(bizErrors);
        } else {
            // 取得した値を画面に設定する。
            se004_02m1Table.setRecordList(outDto.getMEISAI_HaraikomiLIST(), outDto.getMEISAI_HaraikomiLIST()
                    .size());
            se004_02m1Table.setResultsPerPage(outDto.getMEISAI_HaraikomiLIST().size());
            form.setSe004_02M1Table(se004_02m1Table);
        }

        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se004_02Form form, HttpServletRequest request) {

    }
}