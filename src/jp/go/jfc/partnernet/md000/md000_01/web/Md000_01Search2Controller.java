//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md000_01Search2Controller
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.md000.md000_01.web;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

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
 * このクラスはMd000_01の検索ボタン２コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md000_01Form")
@RequestMapping(value = "/Md000_01Search2.form")
public class Md000_01Search2Controller extends Md000_01BaseController {

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
    public String executeAction(Model model, Md000_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 入力チェックで追加されたメッセージを追加
        bizErrors.addAll(checkInput(form));

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 報告書種別
        addForwardParameter(request, Md000Constants.PROPERTY_ID_DATACODE,
                form.getDrpID_DataCode());

        // 検索タイプ
        addForwardParameter(request, Md000Constants.PROPERTY_ID_SEARCH_TYPE,
                Md000Constants.SEARCH_TYPE_KARIUKE);

        // 　　報告書検索結果画面へ遷移する
        // 　　　return success("Md000_02Init")
        return success(Md000Constants.EVENT_ID_MD000_02INIT);
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
    public void displayControl(Model model, Md000_01Form form, HttpServletRequest request) {

    }

    /**
     * 業務固有の入力チェック
     *
     * @param form 入力画面情報
     * @return エラーリストを設定したDTO
     */
    private LinkedList<PNMessageInfo> checkInput(Md000_01Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 報告書種別選択権限チェック
        // ログインユーザの権限種別では選択できない報告書種別が選択されている場合エラーとする

        // 報告書種別プルダウンリストの選択値取得
        String dataCode = form.getDrpID_DataCode();

        // 報告書種別プルダウンリストの選択値が空行以外の場合
        if (!PNCommonConstants.LITERAL_BLANK.equals(dataCode)) {

            // ログオンユーザの権限種別取得
            String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();

            // 権限種別 ＝ 10:受託者の場合
            // 90257110仮受金受入・一般口
            // 90257120留置期間利息・代弁遅延損害金
            // 90257130資金交付依頼予定表（月間）
            // 90257140資金交付依頼書（週間）
            // 90257150包括委任状等交付依頼書
            // 90257160（根）抵当権抹消に係る報告
            // 以外の場合エラーとする。
            if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
                if (!(PNCommonConstants.DATACODE_90257110.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257120.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257130.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257140.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257150.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257160.equals(dataCode))) {

                    // メッセージ：PM3170E{0}："無効な報告書種別"
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3170E,
                            new String[] { "無効な報告書種別" }, false));

                }

                // 権限種別 ＝ 30:Ｈ方式受託者 または 61:農林中央金庫（支店） の場合
                // 90257150包括委任状等交付依頼書
                // 90257160（根）抵当権抹消に係る報告
                // 以外の場合エラーとする。
            }
            else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                    || PNCommonConstants.ROLECODE_NOURINSHITEN.equals(roleCode)) {
                if (!(PNCommonConstants.DATACODE_90257150.equals(dataCode)
                || PNCommonConstants.DATACODE_90257160.equals(dataCode))) {

                    // メッセージ：PM3170E{0}："無効な報告書種別"
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3170E,
                            new String[] { "無効な報告書種別" }, false));
                }

                // 権限種別 ＝ 50:地方機構 の場合
                // 90257130資金交付依頼予定表（月間）
                // 90257140資金交付依頼書（週間）
                // 以外の場合エラーとする。
            }
            else if (PNCommonConstants.ROLECODE_CHIHOUKIKOU.equals(roleCode)) {
                if (!(PNCommonConstants.DATACODE_90257130.equals(dataCode)
                || PNCommonConstants.DATACODE_90257140.equals(dataCode))) {

                    // メッセージ：PM3170E{0}："無効な報告書種別"
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3170E,
                            new String[] { "無効な報告書種別" }, false));
                }

                // 権限種別 ＝ 60:農林中央金庫（本店） または 62:系統受託者 または 70:系統Ｈ方式受託者 の場合
                // 90257130資金交付依頼予定表（月間）
                // 90257140資金交付依頼書（週間）
                // 90257150包括委任状等交付依頼書
                // 90257160（根）抵当権抹消に係る報告
                // 以外の場合エラーとする。
            }
            else if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(roleCode)
                    || PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA.equals(roleCode)
                    || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
                if (!(PNCommonConstants.DATACODE_90257130.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257140.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257150.equals(dataCode)
                        || PNCommonConstants.DATACODE_90257160.equals(dataCode))) {

                    // メッセージ：PM3170E{0}："無効な報告書種別"
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3170E,
                            new String[] { "無効な報告書種別" }, false));
                }

            }
            else {
                // 上記以外の場合
                // チェックなし

            }

        }

        return bizErrors;

    }
}