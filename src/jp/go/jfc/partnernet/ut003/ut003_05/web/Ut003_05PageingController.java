//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_05PageingController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_05.web;

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

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.ut003.common.Ut003Constants;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05Service;
import jp.go.jfc.partnernet.ut003.ut003_05.service.Ut003_05DTO;

/**
 * <pre>
 * このクラスはut003_05のページングコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_05Form")
@RequestMapping(value = "/Ut003_05Pageing.form")
public class Ut003_05PageingController extends Ut003_05BaseController {

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

        // 削除完了メッセージ
        if (null != getForwardParameter(request).get(Ut003Constants.PROPERTY_MSG_ID)) {
            addMessage(errors, (String) getForwardParameter(request).get(Ut003Constants.PROPERTY_MSG_ID),
                    new String[]{""}, false);
        }

        // サービス起動パラメータ設定（受渡パラメータの検索開始/終了年月日の値）
        PNPagingTable<Ut003_05M1DTO> yoshikiList = form.getUt003_05M1Table();

        // 全体件数の取得
        // form退避していた検索条件を取得しDTOに設定する。（form.退避エリア　→　inDto）
        // 　Ut003_05Service.getHitCount // DTOの生成
        Ut003_05DTO inUt003_05DTO = new Ut003_05DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        inUt003_05DTO = form.getSearchDataArea();
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut003_05DTO outUt003_05DTO = ut003_05service.getHitCount(inUt003_05DTO);
        int hitCount = outUt003_05DTO.getYoshikisyuHitCount();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // サービスを実行し通知標題データを取得する。
        // 　　Ut003_05Service.getResultData // DTOの生成
        // Ut003_05DTO inUt003_05DTO = new Ut003_05DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        // Ut003_05DTO outUt003_05DTO = ut003_05service.getResultData(inUt003_05DTO);
        yoshikiList.setInDtoInitPaging(inUt003_05DTO);
        outUt003_05DTO = ut003_05service.getResultData(inUt003_05DTO);
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        yoshikiList.setPostPreNextPaging(outUt003_05DTO.getYoshikiList(), hitCount);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 検索結果の判定
        // 　検索結果が０件の場合
        // 　　メッセージ：該当データがありません。（PM9060E）
        // 　検索結果が１件以上の場合
        // 　　取得した値を画面に設定する。
        if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
            // データなしの場合、非表示設定を行う。
            // 　削除ボタン、再表示ボタン、全選択ボタン、全解除ボタン、ページングアンド明細表示エリアの内容を非表示。
            form.setVisible("btnUpdate", false);
            form.setVisible("btnReload", false);
            form.setVisible("btnDeleteAllCheck", false);
            form.setVisible("btnDeleteAllDelete", false);
            form.setVisible("Ut003_05M1Table", false);
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        form.setUt003_05M1Table(yoshikiList);

        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　return MY_VIEW

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

        // 該当ｎ件時の表示制御
        // 　画面に削除ボタン、再表示ボタン、全選択ボタン、全解除ボタン、ページングアンド明細表示エリアの内容を表示。
        form.setVisible("btnUpdate", true);
        form.setVisible("btnReload", true);
        form.setVisible("btnDeleteAllCheck", true);
        form.setVisible("btnDeleteAllDelete", true);
        form.setVisible("Ut003_05M1Table", true);

    }
}