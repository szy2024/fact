//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.um001.um001_02.service.Um001_02DTO;
import jp.go.jfc.partnernet.um001.um001_02.service.Um001_02M1DTO;
import jp.go.jfc.partnernet.um001.um001_02.service.Um001_02Service;

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
 * このクラスはUm001_02の検索ボタンコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("um001_02Form")
@RequestMapping(value = "/Um001_02Search.form")
public class Um001_02SearchController extends Um001_02BaseController {

    /** Um001_02Service */
    @Autowired
    Um001_02Service um001_02service;

    /** PNJpCalendarUtils */
    @Autowired
    private PNJpCalendarUtils pNJpCalendarUtils;

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
    public String executeAction(Model model, Um001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 利用者一覧を初期化
        PNPagingTable<Um001_02M1DTO> um001_02M1DTO = form.getUm001_02M1Table();
        um001_02M1DTO.reset();

        // 全体件数の取得
        // Formより画面に入力された検索条件をDTOに設定（form→inDto)
        Um001_02DTO inDto = new Um001_02DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        // Um001_02Service.countUserList(inDto)
        Um001_02DTO outDto = um001_02service.countUserList(inDto);

        // ヒット件数のチェック
        // outDto.該当件数　＝　0　の場合、下記エラー処理を行う。

        // 　メッセージＩＤ　・・・　PM9060E : 該当データがありません。
        // 　業務エラー発生
        // 　form.利用者一覧を初期化
        // 　戻り値（画面遷移情報）に次画面を設定し、処理を終了する。
        int hitCount = outDto.getUserListHitCount();
        if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
            // 利用者一覧の件数　＝　０件　の場合
            // ・利用者一覧
            // ・送信ボタン
            form.setVisible("um001_02M1Table", false);
            form.setVisible("btnSend", false);
            addMessage(errors, PNCommonMessageConstants.PM9060E);
            form.getUm001_02M1Table().reset();
            return MY_VIEW;
        }

        // 利用者一覧に表示する先頭ページのデータを取得する。
        // Um001_02Service.findByContition(inDto)
        um001_02M1DTO.setInDtoInitPaging(inDto);

        // 取得した利用者一覧をformにセットする。
        outDto = um001_02service.getUserList(inDto);

        um001_02M1DTO.setRecordList(outDto.getUserList(), hitCount);

        // 検索条件の退避
        // inDto を form の退避エリアにセットする。
        form.setUm001_02M1Table(um001_02M1DTO);
        form.setBkSearchCondition(inDto);

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
    public void displayControl(Model model, Um001_02Form form, HttpServletRequest request) {

        // 該当件数を判定し下記表示／非表示制御を行う。
        // 利用者一覧の件数　＞　０件　の場合
        // ・利用者一覧
        // ・送信ボタン
        if (PNCommonConstants.RECORD_COUNT_ZERO < form.getUm001_02M1Table().getRecordList().size()) {
            // 利用者一覧の明細の内、ステータス　＝　「ロック（試行回数オーバー）」の行の操作選択（「ロック解除」オプション）
            Um001_02M1DTO row = null;
            String name = null;
            for (int i = 0; i < form.getUm001_02M1Table().getRecordList().size(); i++) {
                row = form.getUm001_02M1Table().getRecordList().get(i);
                name = "recordList[" + i + "].optoperation2";
                if ("1".equals(row.getStatus())) {
                    form.setProtect(name, false);
                } else {
                    form.setProtect(name, true);
                }
            }
            form.setVisible("um001_02M1Table", true);
            form.setVisible("btnSend", true);
        }

    }
}