//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md013_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村しのぶ            | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md013.md013_01.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md013.common.Md013Constants;
import jp.go.jfc.partnernet.md013.md013_01.service.Md013_01DTO;
import jp.go.jfc.partnernet.md013.md013_01.service.Md013_01Service;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはmd013_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md013_01Form")
@RequestMapping(value = "/Md013_01Init.form")
public class Md013_01InitController extends Md013_01BaseController {

// [DEL] Ver 3.0.0 - START
//    /** Log */
//    private static Log log = LogFactory.getLog(Md013_01InitController.class);
// [DEL] Ver 3.0.0 - END

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Md013_01Service */
    @Autowired
    Md013_01Service md013_01service;

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
    public String executeAction(Model model, Md013_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 遷移パラメータが設定されている場合（初期表示の時）
        if (!getForwardParameter(request).isEmpty()) {

            // formの情報を初期化
            clearForm(form);

            // 遷移パラメータをformに設定
            setRequestScreen(request, form);

        }

        // メッセージを表示する。
        if (form.getLblMessageID() != null && !form.getLblMessageID().isEmpty()) {
            addMessage(errors, form.getLblMessageID(), new String[] { "" }, false);
            form.setLblMessageID(null);

        }

        // 取消済フラグが1以外（初期表示）または処理モードが修正の場合
        if (!Md013Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getLblID_ProcessMode())) {

            Md013_01DTO inDto = new Md013_01DTO();
            Md013_01DTO outDto = new Md013_01DTO();

            // form項目をDTOに設定する。
            inDto.setLblID_Report(form.getLblID_Report());
            inDto.setLblID_ProcessMode(form.getLblID_ProcessMode());

            // サービスを実行し画面データを取得する。
            outDto = md013_01service.getResultsData(inDto);

            // ■取得件数が０件の場合、業務エラーとし、登録ボタン、編集領域を非表示にする。
            if (0 == outDto.getDataCount()) {

                // 処理モードに空白設定
                form.setLblID_ProcessMode(PNCommonConstants.LITERAL_BLANK);

                // メッセージＩＤ：PM9060E該当データがありません。
                throw new PNServiceException(PNCommonMessageConstants.PM9060E);

            }

            // DTO項目をformに設定する。
            // 発信者 ： outDto.発信者
            form.setLblID_SendName_Organization(outDto.getLblID_SendName_Organization());

            // 発信日 ： 修正の場合、業務日付(Gyy年mm月dd日)。
            //           取消の場合、outDto.報告年月日(Gyy年mm月dd日)
            form.setLblID_SendDate_Report(getDateReport(form.getLblID_ProcessMode(), outDto));

            // 　　報告年月日 ： outDto.報告年月日
            form.setLblID_Date_Report(outDto.getLblID_Date_Report());

            // 表示ファイル名 ： outDto.表示ファイル名
            form.setLblID_Disp_DocName(outDto.getLblID_Disp_DocName());

            // 添付ファイルアップロード先パス ： outDto.添付ファイルアップロード先パス
            form.setLblID_UploadFilePath(outDto.getLblID_UploadFilePath());

            // 扱店名 ： outDto.扱店名
            form.setLblID_Name_Organization(outDto.getLblID_Name_Organization());

            // 扱店 ： outDto.扱店コード
            form.setLblID_Code_Organization(outDto.getLblID_Code_Organization());

            // 店舗 ： outDto.店舗コード
            form.setLblID_Code_Tenpo(outDto.getLblID_Code_Tenpo());

            // 履歴番号 ： outDto.履歴番号
            form.setLblID_History(outDto.getLblID_History());

            // 更新日時 ： outDto.更新日時
            form.setLblID_DateTime_Update(outDto.getLblID_DateTime_Update());

            // 添付ファイルアップロード先パス ： outDto.退避添付ファイルアップロード先パス
            form.setLblID_KeepUploadFilePath(outDto.getLblID_KeepUploadFilePath());

            // 登録済みファイル名
            form.setLblID_Regist_DocName(outDto.getLblID_Regist_DocName());

        }

        // 自画面を表示する。
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
    public void displayControl(Model model, Md013_01Form form,
            HttpServletRequest request) {

        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(form.getLblID_ProcessMode())) {
            // 受渡パラメータの操作選択が取消の場合
            // 登録ボタン ※活性
            form.setProtect(Md013Constants.PROPERTY_UPDATE_BTN, false);
            // 添付ファイル ※非活性
            form.setProtect(Md013Constants.FORM_NAME_SU_HOKATSUININ, true);
            // ダウンロードボタン ※活性
            form.setProtect(Md013Constants.PROPERTY_DOWNLOAD_BTN, false);

            // 更新後の場合
            if (Md013Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())) {
                // 登録ボタン※非活性
                form.setProtect(Md013Constants.PROPERTY_UPDATE_BTN, true);
                // ダウンロードボタン※非活性
                form.setProtect(Md013Constants.PROPERTY_DOWNLOAD_BTN, true);
            }
        }
        else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getLblID_ProcessMode())) {

            // 受渡パラメータの操作選択が修正の場合
            // 登録ボタン ※非活性
            form.setProtect(Md013Constants.PROPERTY_UPDATE_BTN, true);
            // 添付ファイル ※活性
            form.setProtect(Md013Constants.FORM_NAME_SU_HOKATSUININ, false);
            // ダウンロードボタン ※活性
            form.setProtect(Md013Constants.PROPERTY_DOWNLOAD_BTN, false);
        }
    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestScreen(HttpServletRequest request, Md013_01Form form) {

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        // -----------------------------------------------------------------------------
        // 非表示項目
        // -----------------------------------------------------------------------------

        // 報告書番号
        form.setLblID_Report((String)paramMap.get(Md013Constants.PROPERTY_REPORT));

        // 操作選択(処理モード)
        form.setLblID_ProcessMode((String)paramMap.get(Md013Constants.PROPERTY_PROCESS_MODE));

    }

    /**
     * form情報の初期化
     *
     * @param form
     */
    private void clearForm(Md013_01Form form) {

        // 発信日
        form.setLblID_SendDate_Report(PNCommonConstants.LITERAL_BLANK);
        // 発信者
        form.setLblID_SendName_Organization(PNCommonConstants.LITERAL_BLANK);
        // 登録済みファイル名
        form.setLblID_Regist_DocName(PNCommonConstants.LITERAL_BLANK);
        // 修正添付ファイル名
        form.setLblID_DocName(PNCommonConstants.LITERAL_BLANK);

        // 扱店名
        form.setLblID_Name_Organization(PNCommonConstants.LITERAL_BLANK);
        // 扱店コード
        form.setLblID_Code_Organization(PNCommonConstants.LITERAL_BLANK);
        // 店舗コード
        form.setLblID_Code_Tenpo(PNCommonConstants.LITERAL_BLANK);

        // 更新済フラグ
        form.setLblID_Flag_Koushinzumi(null);

    }

// [DEL] Ver 3.0.0 - START
//    /**
//     * <pre>
//     * yyymmdd形式の日付をGyy年mm月dd日形式の日付に変換します。
//     * </pre>
//     *
//     * @param String inDate
//     * @return String outDate
//     */
//    public String dateFmt(String inDate) {
//
//        // 日付形式チェック
//        if (!PNCommonComponents.checkDate(inDate)) {
//            log.error("不正な日付が指定されています");
//            throw new PNSystemException();
//        }
//
//        // yyyymmdd ⇒ Gyy
//        String dateGyy = PNCommonComponents.dateFmtAD_YYYY(inDate.substring(
//                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX,
//                PNCommonConstants.DATE1_YEAR_END_INDEX));
//
//        // yyyymmdd ⇒ mm
//        String dateDD = inDate.substring(
//                PNCommonConstants.DATE1_MONTH_BEGIN_INDEX,
//                PNCommonConstants.DATE1_MONTH_END_INDEX);
//
//        // yyyymmdd ⇒ dd
//        String dateMM = inDate.substring(
//                PNCommonConstants.DATE1_DAY_BEGIN_INDEX,
//                PNCommonConstants.DATE1_DAY_END_INDEX);
//
//        // Gyy + 年 + mm + 月 + dd +日
//        String outDate = PNCommonComponents.concatString(
//                dateGyy
//                , Md013Constants.STR_YEAR
//                , dateDD
//                , Md013Constants.STR_MONTH
//                , dateMM
//                , Md013Constants.STR_DAY);
//
//        return outDate;
//
//    }
// [DEL] Ver 3.0.0 - END

    /**
     * 処理モード、画面表示時刻に応じて報告書年月日を取得
     *
     * @param processMode
     * @return strDate 報告書年月日(Gyy年mm月dd日形式)
     */
    public String getDateReport(String processMode, Md013_01DTO outDto) {

        String strDate = "";

        // 取消の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {

            // 報告年月日 ： outDto.報告年月日
// [UPD] Ver 3.0.0 - START
//            strDate = dateFmt(outDto.getLblID_Date_Report());
            strDate = PNCommonComponents.dateFmtJC_Kanzi_YYYYMMDD(outDto.getLblID_Date_Report());
// [UPD] Ver 3.0.0 - END
        }
        // 上記以外（修正）の場合
        else {
// [UPD] Ver 3.0.0 - START
//            strDate = dateFmt(pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
            strDate = PNCommonComponents.dateFmtJC_Kanzi_YYYYMMDD(
                    pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
// [UPD] Ver 3.0.0 - END
            if (strDate.isEmpty()) {
                throw new PNSystemException(PNCommonMessageConstants.PM9990E);
            }
        }

        return strDate;

    }

}