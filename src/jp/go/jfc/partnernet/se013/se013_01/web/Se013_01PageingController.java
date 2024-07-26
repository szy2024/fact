//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01PageingController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.web;

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
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01M1DTO;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01Service;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01DTO;

/**
 * <pre>
 * このクラスはse013_01のページングコントローラークラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se013_01Form")
@RequestMapping(value = "/Se013_01Pageing.form")
public class Se013_01PageingController extends Se013_01BaseController {

    /** Se013_01Service */
    @Autowired
    Se013_01Service se013_01service;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se013_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        PNPagingTable<Se013_01M1DTO> se013_01m1Table = form.getSe013_01M1Table();

        // 全体件数の取得
        // Formより画面に入力された検索条件をDTOに設定（form→inDto)
        Se013_01DTO inDto = form.getBksearchcondition();

        Se013_01DTO outDto = se013_01service.countResultsData(inDto);

        // ヒット件数のチェック
        int hitCount = outDto.getSearchcount();
        form.setSearchcount(hitCount);
        if (hitCount == PNCommonConstants.RECORD_COUNT_ZERO) {
            // outDto.該当件数　＝　0　の場合、下記エラー処理を行う。
            // 　form.利子助成金受領一覧表帳票一覧を初期化
            form.getSe013_01M1Table().reset();
            form.setVisible("Se013_01M1Table", false);
            // 　メッセージ：PM9060E 該当データがありません。
            // 　処理を終了し、自画面を表示する。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }

        // 利子助成金受領一覧表帳票一覧のデータ取得
        // 明細の初期表示時にServiceクラスに渡すDTOの設定（利子助成金受領一覧表帳票一覧DTOにinDtoを設定する）
        se013_01m1Table.setInDtoInitPaging(inDto);

        // 利子助成金受領一覧表帳票一覧に表示する移動先ページのデータを取得する。
        outDto = se013_01service.getResultsData(inDto);

        // ＪＳＰに渡すＤＴＯの設定
        // 利子助成金受領一覧表帳票一覧.setPostPreNextPaging
        se013_01m1Table.setPostPreNextPaging(outDto.getMeisai_list(), hitCount);

        // 取得した利子助成金受領一覧表帳票一覧をformにセットする。
        form.setSe013_01M1Table(se013_01m1Table);

        // 検索条件の退避
        // inDto を form の退避エリアにセットする。
        form.setBksearchcondition(inDto);

        // 自画面を表示する。
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se013_01Form form,
            HttpServletRequest request) {

        // 該当件数を判定し下記表示／非表示制御を行う。
        if (form.getSearchcount() > PNCommonConstants.RECORD_COUNT_ZERO) {
            // 利子助成金受領一覧表帳票一覧の件数　＞　０件　の場合
            // 利子助成金受領一覧表帳票一覧
            form.setVisible("Se013_01M1Table", true);
        }
        else {
            // 上記以外（利子助成金受領一覧表帳票一覧の件数　＝　０件）の場合
            // 利子助成金受領一覧表帳票一覧
            form.setVisible("Se013_01M1Table", false);
        }

    }
}