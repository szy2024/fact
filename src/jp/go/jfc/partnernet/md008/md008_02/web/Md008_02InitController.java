//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md008.common.Md008Constants;
import jp.go.jfc.partnernet.md008.md008_02.service.Md008_02DTO;
import jp.go.jfc.partnernet.md008.md008_02.service.Md008_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

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

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはMd008_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md008_02Form")
@RequestMapping(value = "/Md008_02Init.form")
public class Md008_02InitController extends Md008_02BaseController {
    /** Log */
    private static Log log = LogFactory.getLog(Md008_02InitController.class);

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;
    /** Md008_02Service */
    @Autowired
    Md008_02Service md008_02service;

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
    public String executeAction(Model model, Md008_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        log.debug("@@@@Md008_02InitController");

        // 受渡パラメータを取得する。
        setRequestScreen(request, form);
        String processMode = form.getProcessMode();
        log.debug("----------------------------------------------------------------------------------------");
        log.debug("processMode[" + processMode + "]");
        log.debug("----------------------------------------------------------------------------------------");

        // 処理モードが処理完了以外：更正(赤)取消の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            // 表示領域初期化
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, true);
            // 取消内容タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, true);
            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, true);
            // 　メッセージ領域を表示にする
            form.setVisible(Md008Constants.PROPERTY_INFO_AREA, true);
            // 　送信ボタンを表示にする
            form.setVisible(Md008Constants.PROPERTY_UPDATE_BTN, true);
            // 　編集領域を表示にする
            form.setVisible(Md008Constants.PROPERTY_EDIT_AREA, true);

            // 　復活データを取得をする。
            // DTOの生成
            Md008_02DTO inMd008_02DTO = new Md008_02DTO();

            Map<String, Object> paramMap = getForwardParameter(request);

            // 報告年月日
            inMd008_02DTO.setLblID_Date_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_DATE_REPORT));
            // ステータス
            inMd008_02DTO.setID_Status((String) paramMap.get(Md008Constants.PROPERTY_ID_STATUS));
            // 報告書番号
            inMd008_02DTO.setID_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_ID_REPORT));
            // 処理モード
            inMd008_02DTO.setProcessMode(processMode);

            // Serviceの呼び出し
            // 　　サービスを実行し、一覧画面データを取得する。
            Md008_02DTO outMd008_02DTO = md008_02service.getResultsData(inMd008_02DTO);

            // 検索結果の判定
            if (PNCommonConstants.RECORD_COUNT_ZERO == outMd008_02DTO.getRecordCount()) {
                // 　取得件数が０件の場合、業務エラーとし、
                // 　メッセージ領域を非表示にする
                form.setVisible(Md008Constants.PROPERTY_INFO_AREA, false);
                // 　登録ボタンを非表示にする
                form.setVisible(Md008Constants.PROPERTY_UPDATE_BTN, false);
                // 　編集領域を非表示にする
                form.setVisible(Md008Constants.PROPERTY_EDIT_AREA, false);
                // 　メッセージ：PM9060E「該当データがありません。 」
                throw new PNServiceException(PNCommonMessageConstants.PM9060E);
            } else {
                // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
                CFWBeanUtils.copyProperties(form, outMd008_02DTO);
                // Formへの転記処理をここに実装
                // 報告年月日
                String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
                form.setLblID_Date_Report(dateFmtYYYYMMDDE(dateReport));
                // 報告書番号
                form.setID_Report((String) getForwardParameter(request).get(
                        Md008Constants.PROPERTY_ID_ID_REPORT));
                // ステータス
                form.setID_Status((String) getForwardParameter(request)
                        .get(Md008Constants.PROPERTY_ID_STATUS));
                // 処理モード
                form.setProcessMode((String) getForwardParameter(request).get(
                        Md008Constants.PROPERTY_PROCESSMODE));
                // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
            }
        }

        // 画面メッセージ、戻るメッセージ、戻るボタンのToolTipを画面に設定する。

        // return MY_VIEW
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
    public void displayControl(Model model, Md008_02Form form, HttpServletRequest request) {
        String processMode = form.getProcessMode();
        form.setVisible(Md008Constants.FORM_NAME_PROCCESNAME, false);

        // 処理モード毎に、下記画面項目表示／非表示設定を行う。
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、処理完了：取消(1)
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, true);
            // 取消内容タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, false);

            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, false);

            // 「戻る」ボタンメッセージの作成
            form.setNaviMessage(Md008Constants.FORM_NAME_NAVI_MESSAGE_NOMAL);

        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、　処理完了・取消(2)　の場合
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, true);
            // 取消内容タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, false);

            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, true);
            form.setBlackAreaTitle(Md008Constants.PANEL_HEADER_KOUSEI_BLACK);
            // 「戻る」ボタンメッセージの作成
            form.setNaviMessage(Md008Constants.FORM_NAME_NAVI_MESSAGE_NOMAL);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、、処理完了以外：取消(3)
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, false);
            // 取消内容タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, true);

            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, false);

            // 「戻る」ボタンメッセージの作成
            form.setNaviMessage(Md008Constants.FORM_NAME_NAVI_MESSAGE_NOMAL);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、処理完了以外・修正(4)の場合
            // 　・ 赤データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, false);
            // 更正赤タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, false);
            // 取消内容タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, false);

            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, true);
            form.setBlackAreaTitle(Md008Constants.PANEL_HEADER_SHUSEI);
            // 「戻る」ボタンメッセージの作成
            form.setNaviMessage(Md008Constants.FORM_NAME_NAVI_MESSAGE_NOMAL);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            // 処理モードが、処理完了以外：更正（赤）取消(5)
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, false);
            // 取消内容タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, true);

            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, false);
            // 「戻る」ボタンメッセージの作成
            form.setNaviMessage(Md008Constants.FORM_NAME_NAVI_MESSAGE_DEL_CANCEL);

        }

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form Md008_02Form
     */
    private void setRequestScreen(HttpServletRequest request, Md008_02Form form) {

        // 処理モード
        form.setProcessMode((String) getForwardParameter(request).get(Md008Constants.PROPERTY_PROCESSMODE));

        // 報告年月日
        form.setLblID_Date_Report((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_REPORT));
        // 報告書番号
        form.setID_Report((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_REPORT));
        // ステータス
        form.setID_Status((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_STATUS));
        // 履歴番号
        form.setID_History((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_HISTORY));
        // 処理種別
        form.setID_Type_Process((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_TYPE_PROCESS));
        // 報告書種別（値）
        form.setID_DataCode((String) getForwardParameter(request).get(Md008Constants.PROPERTY_DATACODE));
        // 最新更新日付
        form.setID_Data_LastUpDate((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATA_LASTUPDATE));

        // 顧客名
        form.setLblID_Name_Customer_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_NAME_CUSTOMER_RED));
        // 扱店名
        form.setLblID_Name_Organization_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_NAME_ORGANIZATION_RED));
        // 公庫支店
        form.setLblID_Code_ShokanHonShiten_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_SHOKANHONSHITEN_RED));
        // 扱店
        form.setLblID_Code_Organization_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_ORGANIZATION_RED));
        // 店舗
        form.setLblID_Code_Tenpo_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_TENPO_RED));
        // 年度
        form.setLblID_Year_Red((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_YEAR_RED));
        // 方式資金
        form.setLblID_Code_HoshikiShikin_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_HOSHIKISHIKIN_RED));
        // 番号
        form.setLblID_ID_Ringi_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_ID_RINGI_RED));
        // 枝番
        form.setLblID_ID_RingiBranch_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_ID_RINGIBRANCH_RED));
        // 入金日
        form.setLblID_Date_Nyukin_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN_RED));
        // 仮受金（一般口）受入額
        form.setLblID_M_KariukeIppanUkeire_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_M_KARIUKEIPPANUKEIRE_RED));
        // 受託者勘定処理年月
        form.setLblID_Date_Jtkshori_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_RED));
        // 受託者勘定処理年月（元号）
        form.setDrpID_Date_Jtkshori_Gengou_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU_RED));
        // 受託者勘定処理年月（年）
        form.setTxtID_Date_Jtkshori_Year_Input_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT_RED));
        // 受託者勘定処理年月（月）
        form.setDrpID_Date_Jtkshori_Month_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH_RED));
        // 送金日
        form.setLblID_Date_Sokin_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN_RED));
        // 送金日番号
        form.setLblID_Code_Sokin_Red((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_SOKIN_RED));

        // 顧客名（修正）
        form.setLblID_Name_Customer((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_NAME_CUSTOMER));
        // 扱店名（修正）
        form.setLblID_Name_Organization((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_NAME_ORGANIZATION));
        // 公庫支店（修正）
        form.setLblID_Code_ShokanHonShiten((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_SHOKANHONSHITEN));
        // 扱店（修正）
        form.setLblID_Code_Organization((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_ORGANIZATION));
        // 店舗（修正）
        form.setLblID_Code_Tenpo((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_TENPO));
        // 年度（修正）
        form.setLblID_Year((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_YEAR));
        // 方式資金（修正）
        form.setLblID_Code_HoshikiShikin((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_HOSHIKISHIKIN));
        // 番号（修正）
        form.setLblID_ID_Ringi((String) getForwardParameter(request).get(Md008Constants.PROPERTY_ID_ID_RINGI));
        // 枝番（修正）
        form.setLblID_ID_RingiBranch((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_ID_RINGIBRANCH));
        // 入金日（修正）
        form.setLblID_Date_Nyukin((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN));
        // 入金日（元号）（修正）
        form.setDrpID_Date_Nyukin_Gengou((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN_GENGOU));
        // 入金日(年)（修正）
        form.setTxtID_Date_Nyukin_Year_Input((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN_YEAR_INPUT));
        // 入金日（月）（修正）
        form.setDrpID_Date_Nyukin_Month((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN_MONTH));
        // 入金日（日）（修正）
        form.setDrpID_Date_Nyukin_Day((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_NYUKIN_DAY));
        // 仮受金（一般口）受入額（修正）
        form.setLblID_M_KariukeIppanUkeire((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_M_KARIUKEIPPANUKEIRE));
        // 受託者勘定処理年月（修正）
        form.setLblID_Date_Jtkshori((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI));
        // 受託者勘定処理年月（元号）（修正）
        form.setDrpID_Date_Jtkshori_Gengou((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU));
        // 受託者勘定処理年月（年）（修正）
        form.setTxtID_Date_Jtkshori_Year_Input((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT));
        // 受託者勘定処理年月（月）（修正）
        form.setDrpID_Date_Jtkshori_Month((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH));
        // 送金年月日（修正）
        form.setLblID_Date_Sokin((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN));
        // 送金日（元号）（修正）
        form.setDrpID_Date_Sokin_Gengou((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN_GENGOU));
        // 送金日（年）（修正）
        form.setTxtID_Date_Sokin_Year_Input((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN_YEAR_INPUT));
        // 送金日（月）（修正）
        form.setDrpID_Date_Sokin_Month((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN_MONTH));
        // 送金日（日）（修正）
        form.setDrpID_Date_Sokin_Day((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_DATE_SOKIN_DAY));
        // 送金日番号（修正）
        form.setLblID_Code_Sokin((String) getForwardParameter(request).get(
                Md008Constants.PROPERTY_ID_CODE_SOKIN));

    }

    /**
     * <pre>
     * 報告年月日のフォーマットを YYYY年MM月DD日(E)に変更する。
     * </pre>
     * @param param String
     * @return String
     */
    private String dateFmtYYYYMMDDE(String param) {
        DateFormat dtFormat = new SimpleDateFormat(PNCommonConstants.DATE_PATTERN_YYYY_MM_DD_E);
        String dateReport = dtFormat.format(PNDateUtils.toDate(PNDateUtils.clearDateTimeSeparator(param),
                PNDateUtils.DATE_PATTERN_YYYYMMDD));

        return dateReport;
    }

}