//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01PageingController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se005.se005_01.service.Se005_01DTO;
import jp.go.jfc.partnernet.se005.se005_01.service.Se005_01M1DTO;
import jp.go.jfc.partnernet.se005.se005_01.service.Se005_01Service;

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
 * このクラスはSe005_01のページングコントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se005_01Form")
@RequestMapping(value = "/Se005_01Pageing.form")
public class Se005_01PageingController extends Se005_01BaseController {

    /** Se005_01Service */
    @Autowired
    Se005_01Service se005_01service;

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
    public String executeAction(Model model, Se005_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        // 逐次検索の場合
        PNPagingTable<Se005_01M1DTO> se005_01m1Table = form.getSe005_01M1Table();

        //-- 2015/12/21 add start --石川 (障害票ITL2-0134対応)
        // エラーリスト
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // エラーリスト初期化
        bizErrors.clear();
        //-- 2015/12/21 add end --石川 (障害票ITL2-0134対応)

        // 検索ボタン押下時の検索条件を取得
        Se005_01DTO inDto = form.getBkSearchCondition();

        // サービスを実行し債権一覧を取得する。
        // 　　Se005_01Service.getResultData // DTOの生成
        // Se005_01DTO inSe005_01DTO = new Se005_01DTO();

        // Serviceの呼び出し
        // Se005_01DTO outSe005_01DTO = se005_01service.getResultData(inSe005_01DTO);

        Se005_01DTO outDto = se005_01service.getResultData(inDto);
        int hitcount = outDto.getID_AllCount();

        // DTOに改ページの検索位置を設定
        se005_01m1Table.setInDtoPreNextPaging(inDto);

        // １ページ分のデータを取得
        outDto = se005_01service.getResultData(inDto);

        // 結果をFormにセット
        se005_01m1Table.setPostPreNextPaging(outDto.getMEISAI_SaikenLIST(), hitcount);

        // 2015/12/21 add --石川 (障害票ITL2-0134対応)
        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // メッセージ出力
        //-- 2015/12/21 mod start --石川 (障害票ITL2-0134対応)
        if (0 != bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
        //-- 2015/12/21 mod end --石川 (障害票ITL2-0134対応)
        // 　検索結果が１件以上の場合
        // 　　取得した値を画面に設定する。

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
    public void displayControl(Model model, Se005_01Form form, HttpServletRequest request) {

    }
}