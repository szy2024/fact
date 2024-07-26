//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_04InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_04.web;

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

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.ut003.ut003_04.service.Ut003_04M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_04.service.Ut003_04Service;
import jp.go.jfc.partnernet.ut003.ut003_04.service.Ut003_04DTO;

/**
 * <pre>
 * このクラスはut003_04の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_04Form")
@RequestMapping(value = "/Ut003_04Init.form")
public class Ut003_04InitController extends Ut003_04BaseController {

    /** Ut003_04Service */
    @Autowired
    Ut003_04Service ut003_04service;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @throws Exception
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Ut003_04Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 受渡パラメータを取得する。
        mappingForwardParameterToForm(request, form);
        form.getUt003_04M1Table().reset();

        // サービス起動パラメータ設定（検索開始/終了年月日の値）
        PNPagingTable<Ut003_04M1DTO> yoryomanualList = form.getUt003_04M1Table();

        // 全体件数を取得する。
        // Formより画面に検索開始/終了年月日の検索条件をDTOに設定（form→inDto)
        // 　Ut003_04Service.getHitCount // DTOの生成
        Ut003_04DTO inUt003_04DTO = new Ut003_04DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inUt003_04DTO, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Ut003_04DTO outUt003_04DTO = ut003_04service.getHitCount(inUt003_04DTO);
        int hitCount = outUt003_04DTO.getYoryomanualHitCount();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // サービスを実行し表示データを取得する。
        // 　Ut003_04Service.getResultData // DTOの生成
        // Ut003_04DTO inUt003_04DTO = new Ut003_04DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        yoryomanualList.setInDtoInitPaging(inUt003_04DTO);
        outUt003_04DTO = ut003_04service.getResultData(inUt003_04DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        yoryomanualList.setPostPreNextPaging(outUt003_04DTO.getYoryoManualList(), hitCount);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 検索結果の判定
        // 　検索結果が０件の場合
        // 　　メッセージ：該当データがありません。（PM9060E）
        // 　検索結果が１件以上の場合
        // 　　検索結果を取得する。
        // 　　取得した値を画面に設定する。
        if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
            // データなしの場合、非表示設定を行う。
            // 　削除ボタン、再表示ボタン、全選択ボタン、全解除ボタン、ページングアンド明細表示エリアの内容を非表示。
            form.setVisible("btnUpdate", false);
            form.setVisible("btnReload", false);
            form.setVisible("btnDeleteAllCheck", false);
            form.setVisible("btnDeleteAllDelete", false);
            form.setVisible("Ut003_04M1Table", false);
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        form.setUt003_04M1Table(yoryomanualList);

        // 検索条件の退避
        // inDto を form の退避エリアにセットする。
        form.setSearchDataArea(inUt003_04DTO);

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
    public void displayControl(Model model, Ut003_04Form form, HttpServletRequest request) {

        // 該当ｎ件時の表示制御
        // 　画面に削除ボタン、再表示ボタン、全選択ボタン、全解除ボタン、ページングアンド明細表示エリアの内容を表示。
        form.setVisible("btnUpdate", true);
        form.setVisible("btnReload", true);
        form.setVisible("btnDeleteAllCheck", true);
        form.setVisible("btnDeleteAllDelete", true);
        form.setVisible("Ut003_04M1Table", true);

    }
}