//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02PagingController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.um001.common.Um001Constants;
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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはUm001_02のページングコントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("um001_02Form")
@RequestMapping(value = "/Um001_02Paging.form")
public class Um001_02PagingController extends Um001_02BaseController {

    /** Um001_02Serivce */
    @Autowired
    Um001_02Service um001_02Service;

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

        PNPagingTable<Um001_02M1DTO> userList = form.getUm001_02M1Table();

        // 　- 遷移元画面ID　＝　未設定（null）の場合はメッセージを表示しない。
        if (null != getForwardParameter(request).get(Um001Constants.PROPERTY_MSG_ID)) {

            // 当画面への遷移パラメタを受け取り、内容により情報メッセージを表示する。
            String messageId = (String) getForwardParameter(request).get(Um001Constants.PROPERTY_MSG_ID);

            if (PNCommonMessageConstants.PM1060I.equals(messageId)) {

                // 当画面の削除・更新結果メッセージ
                String deleteCount = (String) getForwardParameter(request).get(
                        Um001Constants.PROPERTY_DEL_CNT);
                String updateCount = (String) getForwardParameter(request).get(
                        Um001Constants.PROPERTY_UPD_CNT);
                addMessage(errors, PNCommonMessageConstants.PM1060I, new String[]{"削除：" + deleteCount
                        + "件／更新：" + updateCount + "件"}, false);

            } else if (PNCommonMessageConstants.PM1040I.equals(messageId)) {

                // 登録内容変更画面の登録成功時の結果メッセージ
                addMessage(errors, PNCommonMessageConstants.PM1040I, new String[]{""}, false);

            } else if (PNCommonMessageConstants.PM9030E.equals(messageId)) {

                // 登録内容変更画面の該当データ削除済みメッセージ
                addMessage(errors, PNCommonMessageConstants.PM9030E);

            }

        }

        // formから利用者一覧を取得

        // 全体件数の取得
        // form退避していた検索条件を取得しDTOに設定する。（form.退避エリア　→　inDto）
        Um001_02DTO inDto = form.getBkSearchCondition();

        // um001_02Service.countUserList(inDto)
        Um001_02DTO outDto = um001_02Service.countUserList(inDto);

        // DTOに改ページの検索位置を設定（利用者一覧DTOにinDtoを設定する）
        int hitCount = outDto.getUserListHitCount();

        // 利用者一覧の移動先ページのデータを取得。
        // um001_02Service.getUserList(inDto)
        userList.setInDtoInitPaging(inDto);
        outDto = um001_02Service.getUserList(inDto);
        userList.setPostPreNextPaging(outDto.getUserList(), hitCount);

        // 取得した利用者一覧をformにセットする。
        form.setUm001_02M1Table(userList);

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

        // 利用者一覧の明細の内、ステータス　＝　「ロック（試行回数オーバー）」の行の操作選択（「ロック解除」オプション）
        Um001_02M1DTO row = null;
        String name = null;
        for (int i = 0; i < form.getUm001_02M1Table().getRecordList().size(); i++) {
            row = form.getUm001_02M1Table().getRecordList().get(i);
            name = "recordList[" + i + "].optoperation2";
            if (Um001Constants.STATUS_LOCK_OVER.equals(row.getStatus())) {
                form.setProtect(name, false);
            } else {
                form.setProtect(name, true);
            }
        }

    }
}