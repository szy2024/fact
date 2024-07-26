//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02InitBackController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr004.common.Cr004Constants;
import jp.go.jfc.partnernet.cr004.cr004_02.service.Cr004_02DTO;
import jp.go.jfc.partnernet.cr004.cr004_02.service.Cr004_02M1DTO;
import jp.go.jfc.partnernet.cr004.cr004_02.service.Cr004_02Service;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

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
 * このクラスはCr004_02の戻り表示コントローラークラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr004_02Form")
@RequestMapping(value = "/Cr004_02Initback.form")
public class Cr004_02InitBackController extends Cr004_02BaseController {

    /** Cr004_02Service */
    @Autowired
    Cr004_02Service cr004_02service;

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
    public String executeAction(Model model, Cr004_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面項目を初期化
        // 顧客名（ヘッダ）は初期化しない
        // 明細部初期化
        PNPagingTable<Cr004_02M1DTO> cr004_02m1Table = form.getCr004_02M1Table();
        cr004_02m1Table.reset();
        // 明細部を表示状態へ
        form.setVisible(Cr004Constants.PROPERTY_CUSTOMERLIST_AREA, true);

        // サービス起動パラメータ設定（受渡パラメータの顧客名入力値、ログインユーザの扱店コード）
        // サービスを実行し顧客情報データを取得する。
        // 　　Cr004_02Service.getResultData // DTOの生成
        Cr004_02DTO inCr004_02DTO = new Cr004_02DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装

        inCr004_02DTO.setLblSearchCustomer(form.getLblSearchCustomer());
        inCr004_02DTO.setCr004_02_Code_Organizaion(form.getCr004_02_Code_Organizaion());

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Cr004_02DTO outCr004_02DTO = cr004_02service.getResultData(inCr004_02DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        form.setID_AllCount(outCr004_02DTO.getMEISAI_LIST1().size());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 検索結果の判定
        if (0 == outCr004_02DTO.getMEISAI_LIST1().size()) {
            // 　検索結果が０件の場合
            // 　　メッセージ「該当データがありません。」を設定する。
            addMessage(errors, PNCommonMessageConstants.PM9060E);
            // 明細部を非表示にする
            form.setVisible(Cr004Constants.PROPERTY_CUSTOMERLIST_AREA, false);
        } else {
            // 　検索結果が１件以上の場合
            // 　　検索結果を取得する。
            // 　　取得した値を画面に設定する。
            form.getCr004_02M1Table().setRecordList(outCr004_02DTO.getMEISAI_LIST1(), form.getID_AllCount());

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
    public void displayControl(Model model, Cr004_02Form form, HttpServletRequest request) {

    }
}