//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_02.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.cr008.cr008_02.service.Cr008_02DTO;
import jp.go.jfc.partnernet.cr008.cr008_02.service.Cr008_02M1DTO;
import jp.go.jfc.partnernet.cr008.cr008_02.service.Cr008_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr008_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr008_02Form")
@RequestMapping(value = "/Cr008_02Init.form")
public class Cr008_02InitController extends Cr008_02BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_02InitController.class);

    /** Cr008_02Service */
    @Autowired
    Cr008_02Service cr008_02service;

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
    public String executeAction(Model model, Cr008_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面項目を初期化
        // 顧客名（ヘッダ）初期化
        form.setLblSearchCustomer("");
        // 明細部初期化
        PNPagingTable<Cr008_02M1DTO> cr008_02m1Table = form.getCr008_02M1Table();
        cr008_02m1Table.reset();
        // 明細部を表示状態へ
        form.setVisible(Cr008Constants.PROPERTY_CUSTOMERLIST_AREA, true);

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);
        // 画面の顧客名（ヘッダ）に受渡パラメータの顧客名入力値を設定する。
        form.setLblSearchCustomer((String) paramMap.get(Cr008Constants.PROPERTY_NAME_CUSTOMER));

        // ログインユーザの扱店コードをセッション情報から取得する。
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();

        // セッション情報に値が設定されている場合、formに設定する
        if (null != loginInfo) {
            form.setCr008_02_Code_Organizaion(loginInfo.getCode_Organization());
        }

        // サービス起動パラメータ設定（受渡パラメータの顧客名入力値、ログインユーザの扱店コード）
        // サービスを実行し顧客情報データを取得する。
        // 　　Cr008_02Service.getResultData // DTOの生成
        Cr008_02DTO inCr008_02DTO = new Cr008_02DTO();
        // CFWBeanUtils.copyProperties(inCr008_02DTO, form);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        inCr008_02DTO.setLblSearchCustomer(form.getLblSearchCustomer());
        inCr008_02DTO.setCr008_02_Code_Organizaion(form.getCr008_02_Code_Organizaion());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Cr008_02DTO outCr008_02DTO = cr008_02service.getResultData(inCr008_02DTO);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        form.setID_AllCount(outCr008_02DTO.getMEISAI_LIST1().size());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 検索結果の判定
        if (0 == outCr008_02DTO.getMEISAI_LIST1().size()) {
            // 　検索結果が０件の場合
            // 　　メッセージ「該当データがありません。」を設定する。
            addMessage(errors, PNCommonMessageConstants.PM9060E);
            // 明細部を非表示にする
            form.setVisible(Cr008Constants.PROPERTY_CUSTOMERLIST_AREA, false);
        } else {
            // 　検索結果が１件以上の場合
            // 　　検索結果を取得する。
            // 　　取得した値を画面に設定する。
            form.getCr008_02M1Table().setRecordList(outCr008_02DTO.getMEISAI_LIST1(), form.getID_AllCount());

            // 1ページ当たりの表示件数にヒット件数を設定
            cr008_02m1Table.setResultsPerPage(form.getID_AllCount());

        }

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
    public void displayControl(Model model, Cr008_02Form form, HttpServletRequest request) {

    }
}