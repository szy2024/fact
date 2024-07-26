//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_02.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md008.common.Md008Constants;
import jp.go.jfc.partnernet.md009.common.Md009Constants;
import jp.go.jfc.partnernet.md009.md009_02.service.Md009_02DTO;
import jp.go.jfc.partnernet.md009.md009_02.service.Md009_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

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
 * このクラスはMd009_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md009_02Form")
@RequestMapping(value = "/Md009_02Init.form")
public class Md009_02InitController extends Md009_02BaseController {

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /** Md009_02Service */
    @Autowired
    Md009_02Service md009_02service;

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
    public String executeAction(Model model, Md009_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面の全項目をクリアする。
        clearScreen(form);

        // 受渡パラメータを取得する。
        setRequestScreen(request, form);

        // 処理モード
        String processMode = (String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_PROCESS_MODE);

        // 処理モードが処理完了以外更正(赤）：取消(5)の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {

            // 一覧画面データを取得する。
            Md009_02DTO inMd009_02DTO = new Md009_02DTO();
            // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
            CFWBeanUtils.copyProperties(inMd009_02DTO, form);
            // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

            // Serviceの呼び出し
            Md009_02DTO outMd009_02DTO = md009_02service.getResultsData(inMd009_02DTO);

            // キャプションに「取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
            form.setCaption(Md009Constants.FORM_NAME_NAVI_MESSAGE_DEL_CANCEL);

            // 検索結果の判定
            if (PNCommonConstants.RECORD_COUNT_ZERO == outMd009_02DTO.getRecCount()) {
                // 　取得件数が０件の場合、業務エラーとし、
                // 　メッセージ領域を非表示にする
                form.setVisible(Md009Constants.PROPERTY_INFO_AREA, false);
                // 　送信ボタンを非表示にする
                form.setVisible(Md009Constants.PROPERTY_UPDATE_BTN, false);
                // 　編集領域を非表示にする
                form.setVisible(Md009Constants.FORM_NAME_REDAREA, false);
                form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
                // 報告年月日設定
                String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
                form.setLblID_Date_Report(dateFmtYYYYMMDDE(dateReport));
                // 　メッセージ：PM9060E「該当データがありません。 」
                throw new PNServiceException(PNCommonMessageConstants.PM9060E);
            }

            // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
            CFWBeanUtils.copyProperties(form, outMd009_02DTO);
            // 更正（赤）留置期間利息
            form.setLblID_M_RyuchiKikanRisoku_Red(PNStringChecker.toComma(outMd009_02DTO
                    .getLblID_M_RyuchiKikanRisoku_Red()));
            // 更正（赤）代弁遅延損害金
            form.setLblID_M_DaibenChienSongai_Red(PNStringChecker.toComma(outMd009_02DTO
                    .getLblID_M_DaibenChienSongai_Red()));
            // 更正（赤）送金額
            form.setLblID_M_Sokin_Red(PNStringChecker.toComma(outMd009_02DTO.getLblID_M_Sokin_Red()));
            // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

            // 処理モード
            form.setProcessMode((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_PROCESS_MODE));

        } else {

            // キャプションに「留置期間利息・代弁遅延損害金受入充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
            form.setCaption(Md009Constants.FORM_NAME_NAVI_MESSAGE_NOMAL);

        }

        // 報告年月日設定
        String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
        form.setLblID_Date_Report(dateFmtYYYYMMDDE(dateReport));

        // 受渡パラメータの処理モードにより画面表示タイプを決定する。
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)) {
            form.setRedAreaTitle(Md009Constants.PANEL_HEADER_KOUSEI);
        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            form.setRedAreaTitle(Md009Constants.PANEL_HEADER_KOUSEI);
            form.setBlackAreaTitle(Md009Constants.PANEL_HEADER_KOUSEI_BLACK);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            form.setRedAreaTitle(Md009Constants.PANEL_HEADER_TORIKESHI);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            form.setBlackAreaTitle(Md009Constants.PANEL_HEADER_SHUSEI);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            form.setRedAreaTitle(Md009Constants.PANEL_HEADER_TORIKESHI);
        }

        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　return MY_VIWE
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
    public void displayControl(Model model, Md009_02Form form, HttpServletRequest request) {

        String processMode = form.getProcessMode();
        form.setVisible(Md008Constants.FORM_NAME_PROCCESNAME, false);

        // 処理モード毎に、下記画面項目表示／非表示設定を行う。
        // 処理モードが、　処理完了：取消(1)
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)) {
            // ・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, true);
            // ・ 黒データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、　処理完了・修正(2)　の場合
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, true);
            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, true);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、　処理完了以外・取消(3)　の場合
            // ・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, false);
            // ・ 黒データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、　処理完了以外・修正(4)　の場合
            // ・ 赤データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, false);
            form.setVisible(Md009Constants.FORM_HEAD_RED, false);
            // ・ 黒データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, true);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            // 処理モードが、　処理完了以外更正(赤）：取消(5)　の場合
            // ・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, false);
            // ・ 黒データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
        }

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestScreen(HttpServletRequest request, Md009_02Form form) {

        // -----------------------------------------------------------------------------
        // 非表示項目
        // -----------------------------------------------------------------------------

        // 報告書番号
        form.setID_Report((String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_REPORT));

        // 履歴番号
        form.setID_History((String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_HISTORY));

        // ステータス
        form.setID_Status((String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_STATUS));

        // 処理種別
        form.setID_Type_Process((String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_TYPE_PROCESS));

        // 報告書種別(値)
        form.setID_DataCode((String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_BIZJOINITEM_DATACODE));

        // 最新更新日付
        form.setID_Data_LastUpDate((String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_DATA_LASTUPDATE));

        // 処理モード
        form.setProcessMode((String) getForwardParameter(request)
                .get(Md009Constants.PROPERTY_ID_PROCESS_MODE));

        String processMode = (String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_PROCESS_MODE);

        // -----------------------------------------------------------------------------
        // 更正（赤）
        // -----------------------------------------------------------------------------

        // DTO項目を画面項目に設定する。
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)
                || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 更正（赤）扱店名
            form.setLblID_Name_Organization_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_NAME_ORGANIZATION_RED));

            // 更正（赤）公庫支店
            form.setLblID_Code_ShokanHonShiten_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_SHOKANHONSHITEN_RED));

            // 更正（赤）扱店
            form.setLblID_Code_Organization_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_ORGANIZATION_RED));

            // 更正（赤）店舗
            form.setLblID_Code_Tenpo_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_TENPO_RED));

            // 更正（赤）入金日
            form.setLblID_Date_Nyukin_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_DATE_NYUKIN_RED));

            // 更正（赤）留置期間利息
            form.setLblID_M_RyuchiKikanRisoku_Red(PNStringChecker.toComma(((String) getForwardParameter(
                    request).get(Md009Constants.PROPERTY_ID_M_RYUCHIKIKANRISOKU_RED))));

            // 更正（赤）代弁遅延損害金
            form.setLblID_M_DaibenChienSongai_Red(PNStringChecker.toComma((String) getForwardParameter(
                    request).get(Md009Constants.PROPERTY_ID_M_DAIBENCHIENSONGAI_RED)));

            // 更正（赤）送金額
            form.setLblID_M_Sokin_Red(PNStringChecker.toComma((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_M_SOKIN_RED)));

            // 更正（赤）受託者勘定処理年月
// [UPD] Ver 2.0.0 - START
//            String warekiJtkshoriRed = PNCommonComponents.dateFmtAD_YYYYMM(jpCalendarUtils.toSeireki(
//                    (String) getForwardParameter(request).get(
//                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU_RED),
//                    (String) getForwardParameter(request).get(
//                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT_RED),
//                    (String) getForwardParameter(request).get(
//                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH_RED),
//                    PNCommonConstants.FIRST_DAY_OF_MONTH).substring(0, 6));
            String warekiJtkshoriRed = dateFmtGyymm(
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU_RED),
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT_RED),
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH_RED));
// [UPD] Ver 2.0.0 - END
            form.setLblID_Date_Jtkshori_Red(warekiJtkshoriRed);

            // 更正（赤）送金年月日
            form.setLblID_Date_Sokin_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_DATE_SOKIN_RED));

            // 更正（赤）送金日番号
            form.setLblID_Code_Sokin_Red((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_SOKIN_RED));
        }

        // -----------------------------------------------------------------------------
        // 更正（黒）
        // -----------------------------------------------------------------------------

        // 画面表示タイプが更正(黒)画面の場合
        // DTO項目(修正)を画面項目に設定する。
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)
                || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            // 更正（黒）扱店名
            form.setLblID_Name_Organization((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_NAME_ORGANIZATION));

            // 更正（黒）公庫支店
            form.setLblID_Code_ShokanHonShiten((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_SHOKANHONSHITEN));

            // 更正（黒）扱店
            form.setLblID_Code_Organization((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_ORGANIZATION));

            // 更正（黒）店舗
            form.setLblID_Code_Tenpo((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_TENPO));

            // 更正（黒）入金日
            String warekiNyukin = PNCommonComponents.dateFmtAD_YYYYMMDD(jpCalendarUtils.toSeireki(
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_NYUKIN_GENGOU),
                    (String) getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_NYUKIN_YEAR_INPUT),
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_NYUKIN_MONTH),
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_NYUKIN_DAY)));
            form.setLblID_Date_Nyukin(warekiNyukin);

            // 更正（黒）留置期間利息
            form.setLblID_M_RyuchiKikanRisoku(PNStringChecker.toComma((String) getForwardParameter(request)
                    .get(Md009Constants.PROPERTY_ID_M_RYUCHIKIKANRISOKU)));

            // 更正（黒）代弁遅延損害金
            form.setLblID_M_DaibenChienSongai(PNStringChecker.toComma((String) getForwardParameter(request)
                    .get(Md009Constants.PROPERTY_ID_M_DAIBENCHIENSONGAI)));

            // 更正（黒）送金額
            form.setLblID_M_Sokin(PNStringChecker.toComma((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_M_SOKIN)));

            // 更正（黒）受託者処理年月
// [UPD] Ver 2.0.0 - START
//            String warekiJtkshori = PNCommonComponents.dateFmtAD_YYYYMM(jpCalendarUtils
//                    .toSeireki(
//                            (String) getForwardParameter(request).get(
//                                    Md009Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU),
//                            (String) getForwardParameter(request).get(
//                                    Md009Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT),
//                            (String) getForwardParameter(request).get(
//                                    Md009Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH),
//                            PNCommonConstants.FIRST_DAY_OF_MONTH).substring(0, 6));
            String warekiJtkshori = dateFmtGyymm(
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU),
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT),
                    (String)getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH));
// [UPD] Ver 2.0.0 - END
            form.setLblID_Date_Jtkshori(warekiJtkshori);

            // 更正（黒）送金年月日
            String warekiSokin = PNCommonComponents.dateFmtAD_YYYYMMDD(jpCalendarUtils.toSeireki(
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_SOKIN_GENGOU),
                    (String) getForwardParameter(request).get(
                            Md009Constants.PROPERTY_ID_DATE_SOKIN_YEAR_INPUT),
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_SOKIN_MONTH),
                    (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_DATE_SOKIN_DAY)));
            form.setLblID_Date_Sokin(warekiSokin);

            // 更正（黒）送金番号
            form.setLblID_Code_Sokin((String) getForwardParameter(request).get(
                    Md009Constants.PROPERTY_ID_CODE_SOKIN));
        }

    }

    /**
     * <pre>
     * 画面の初期化を行います。
     * </pre>
     */
    private void clearScreen(Md009_02Form form) {
        form.setLblID_Date_Report("");
        form.setLblID_Name_Organization_Red("");
        form.setLblID_Code_ShokanHonShiten_Red("");
        form.setLblID_Code_Organization_Red("");
        form.setLblID_Code_Tenpo_Red("");
        form.setLblID_Date_Nyukin_Red("");
        form.setLblID_M_RyuchiKikanRisoku_Red("");
        form.setLblID_M_DaibenChienSongai_Red("");
        form.setLblID_M_Sokin_Red("");
        form.setLblID_Date_Jtkshori_Red("");
        form.setLblID_Date_Sokin_Red("");
        form.setLblID_Code_Sokin_Red("");
        form.setLblID_Name_Organization("");
        form.setLblID_Code_ShokanHonShiten("");
        form.setLblID_Code_Organization("");
        form.setLblID_Code_Tenpo("");
        form.setLblID_Date_Nyukin("");
        form.setLblID_M_RyuchiKikanRisoku("");
        form.setLblID_M_DaibenChienSongai("");
        form.setLblID_M_Sokin("");
        form.setLblID_Date_Jtkshori("");
        form.setLblID_Date_Sokin("");
        form.setLblID_Code_Sokin("");
        form.setLblID_Date_Jtkshori_Gengou_Red("");
        form.setLblID_Date_Jtkshori_Year_Input_Red("");
        form.setLblID_Date_Jtkshori_Month_Red("");
        form.setLblID_Date_Nyukin_Gengou("");
        form.setLblID_Date_Nyukin_Year_Input("");
        form.setLblID_Date_Nyukin_Month("");
        form.setLblID_Date_Nyukin_Day("");
        form.setLblID_Date_Jtkshori_Gengou("");
        form.setLblID_Date_Jtkshori_Year_Input("");
        form.setLblID_Date_Jtkshori_Month("");
        form.setLblID_Date_Sokin_Gengou("");
        form.setLblID_Date_Sokin_Year_Input("");
        form.setLblID_Date_Sokin_Month("");
        form.setLblID_Date_Sokin_Day("");
        form.setID_Report("");
        form.setID_History("");
        form.setID_Status("");
        form.setID_Type_Process("");
        form.setID_DataCode("");
        form.setID_Keep_ID_History("");
        form.setID_Data_LastUpDate("");
        form.setProcessMode("");
        form.setRedAreaTitle("");
        form.setBlackAreaTitle("");
        form.setCaption("");
    }

    /**
     * <pre>
     * 報告年月日のフォーマットを YYYY年MM月DD日(E)に変更する。
     * </pre>
     */
    private String dateFmtYYYYMMDDE(String param) {
        DateFormat dtFormat = new SimpleDateFormat(PNCommonConstants.DATE_PATTERN_YYYY_MM_DD_E);
        String dateReport = dtFormat.format(PNDateUtils.toDate(PNDateUtils.clearDateTimeSeparator(param),
                PNDateUtils.DATE_PATTERN_YYYYMMDD));

        return dateReport;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * <pre>
     * 年月のフォーマットを Gyy.mmに変更する。
     * </pre>
     */
    private String dateFmtGyymm(String gengo, String year, String month) {
        String date = PNCommonComponents.concatString(
                gengo,
                PNFormatUtils.toZeroSuppress(year),
                PNCommonConstants.DELIMITER_DOT,
                PNFormatUtils.toZeroSuppress(month));

        return date;
    }
// [ADD] Ver 2.0.0 - END

}