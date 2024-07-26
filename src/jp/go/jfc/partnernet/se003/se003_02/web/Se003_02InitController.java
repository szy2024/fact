//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se003.se003_02.service.Se003_02DTO;
import jp.go.jfc.partnernet.se003.se003_02.service.Se003_02M1DTO;
import jp.go.jfc.partnernet.se003.se003_02.service.Se003_02M2DTO;
import jp.go.jfc.partnernet.se003.se003_02.service.Se003_02Service;

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
 * このクラスはSe003_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se003_02Form")
@RequestMapping(value = "/Se003_02Init.form")
public class Se003_02InitController extends Se003_02BaseController {

    /** Se003_02Service */
    @Autowired
    Se003_02Service se003_02service;

    // 明細部ID名
    private static final String SE003_02_DETAIL_ID_NAME = "se003_02Table";

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
    public String executeAction(Model model, Se003_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Form項目の初期化
        PNPagingTable<Se003_02M1DTO> se003_02M1Table = form.getSe003_02M1Table();
        se003_02M1Table.reset();
        PNPagingTable<Se003_02M2DTO> se003_02M2Table = form.getSe003_02M2Table();
        se003_02M2Table.reset();

        // メッセージ項目の初期化
        form.setLblError("");

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        form.setVisible(SE003_02_DETAIL_ID_NAME, true);
        form.setVisible("grdResults", true);
        form.setVisible("rptDetails_YakuteiNyukin", true);

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // サービス起動パラメータ設定（受渡パラメータの公庫支店コード、扱店コード、店舗コード、年度（和暦）、方式資金、番号、枝番）
        // サービスを実行し債権情報照会データを取得する。
        // DTOの生成
        Se003_02DTO inDTO = new Se003_02DTO();

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDTO, form);

        // Serviceの呼び出し
        Se003_02DTO outDTO = se003_02service.getResultData(inDTO);

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDTO);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDTO.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            form.setVisible(SE003_02_DETAIL_ID_NAME, false);
            // エラー有の場合自画面表示y
            throw new PNServiceException(bizErrors);
        }

        if (0 < outDTO.getMEISAI_HaraidashiLIST().size()) {
            // 　　取得した値を画面に設定する。
            se003_02M1Table.setRecordList(outDTO.getMEISAI_HaraidashiLIST(), outDTO
                    .getMEISAI_HaraidashiLIST().size());
            se003_02M1Table.setResultsPerPage(outDTO.getMEISAI_HaraidashiLIST().size());
            form.setSe003_02M1Table(se003_02M1Table);
        } else {
            // 払出情報が０件の場合、表示しない（明細０件対応）
            form.setVisible("grdResults", false);
        }

        if (0 < outDTO.getMEISAI_HaraikomiLIST().size()) {
            // 　　取得した値を画面に設定する。
            se003_02M2Table.setRecordList(outDTO.getMEISAI_HaraikomiLIST(), outDTO.getMEISAI_HaraikomiLIST()
                    .size());
            se003_02M2Table.setResultsPerPage(outDTO.getMEISAI_HaraikomiLIST().size());
            form.setSe003_02M2Table(se003_02M2Table);
        } else {
            // 払込情報が０件の場合、表示しない（明細０件対応）
            form.setVisible("rptDetails_YakuteiNyukin", false);
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
    public void displayControl(Model model, Se003_02Form form, HttpServletRequest request) {

    }
}