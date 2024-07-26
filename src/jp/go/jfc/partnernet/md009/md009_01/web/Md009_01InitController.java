//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md009.common.Md009Constants;
import jp.go.jfc.partnernet.md009.md009_01.service.Md009_01DTO;
import jp.go.jfc.partnernet.md009.md009_01.service.Md009_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

/**
 * <pre>
 * このクラスはMd009_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md009_01Form")
@RequestMapping(value = "/Md009_01Init.form")
public class Md009_01InitController extends Md009_01BaseController {

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Md009_01Service */
    @Autowired
    Md009_01Service md009_01service;

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
    public String executeAction(Model model, Md009_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        Md009_01DTO inDto = new Md009_01DTO();
        Md009_01DTO outDto = new Md009_01DTO();

        // 受渡パラメータを取得する。
        String ID_Report = (String) getForwardParameter(request).get(Md009Constants.PROPERTY_ID_REPORT);
        String processMode = (String) getForwardParameter(request).get(
                Md009Constants.PROPERTY_ID_PROCESS_MODE);

        // 画面の全項目をクリアする。
        clearScreen(form);

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
        }

        // サービスを実行し一覧画面データを取得する。
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inDto.setTxtID_Code_Organization(pnCommonInfo.getCode_Organization());
        inDto.setID_Report(ID_Report);
        inDto.setProcessMode(processMode);
        outDto = md009_01service.getResultsData(inDto);

        // 一覧画面データをformに設定する。
        CFWBeanUtils.copyProperties(form, outDto);

        // 報告年月日設定
        String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
        form.setLblID_Date_Report(dateFmtYYYYMMDDE(dateReport));

        // 検索結果の判定
        if (PNCommonConstants.RECORD_COUNT_ZERO == outDto.getRecCount()) {
            // 　取得件数が０件の場合、業務エラーとし、
            // 　メッセージ領域を非表示にする
            form.setVisible(Md009Constants.PROPERTY_INFO_AREA, false);
            // 　送信ボタンを非表示にする
            form.setVisible(Md009Constants.PROPERTY_SEND_BTN, false);
            // 　編集領域を非表示にする
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, false);
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
            // 　メッセージ：PM9060E「該当データがありません。 」
            throw new PNServiceException(PNCommonMessageConstants.PM9060E, new String[]{});
        }

        // 非表示項目設定
        form.setID_Report(outDto.getID_Report());
        form.setID_History(outDto.getID_History());
        form.setID_DataCode(outDto.getID_DataCode());
        form.setID_Status(outDto.getID_Status());
        form.setID_Type_Process(outDto.getID_Type_Process());
        form.setProcessMode(processMode);

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
    public void displayControl(Model model, Md009_01Form form, HttpServletRequest request) {

        String processMode = form.getProcessMode();

        // 送信ボタンを表示する
        form.setVisible(Md009Constants.PROPERTY_SEND_BTN, true);

        // 処理モード毎に、下記画面項目表示／非表示設定を行う。
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、　処理完了：取消(1)
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, true);
            // 　・ 黒データ入力領域　※非表示
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
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, true);
            form.setVisible(Md009Constants.FORM_HEAD_RED, false);
            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, false);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、　処理完了以外・修正(4)　の場合
            // 　・ 赤データ入力領域　※非表示
            form.setVisible(Md009Constants.FORM_NAME_REDAREA, false);
            form.setVisible(Md009Constants.FORM_HEAD_RED, false);
            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md009Constants.FORM_NAME_BLACKAREA, true);

        }

    }

    /**
     * <pre>
     * 画面の初期化を行います。
     * </pre>
     */
    private void clearScreen(Md009_01Form form) {
        form.setLblID_Date_Report("");
        form.setTxtID_Name_Organization_Red("");
        form.setTxtID_Code_ShokanHonShiten_Red("");
        form.setTxtID_Code_Organization_Red("");
        form.setTxtID_Code_Tenpo_Red("");
        form.setTxtID_Date_Nyukin_Red("");
        form.setTxtID_M_RyuchiKikanRisoku_Red("");
        form.setTxtID_M_DaibenChienSongai_Red("");
        form.setTxtID_M_Sokin_Red("");
        form.setTxtID_Date_Jtkshori_Red("");
        form.setTxtID_Date_Sokin_Red("");
        form.setTxtID_Code_Sokin_Red("");
        form.setDrpID_Date_Jtkshori_Gengou_Red("");
        form.setTxtID_Date_Jtkshori_Year_Input_Red("");
        form.setDrpID_Date_Jtkshori_Month_Red("");
        form.setTxtID_Name_Organization("");
        form.setTxtID_Code_ShokanHonShiten("");
        form.setTxtID_Code_Organization("");
        form.setTxtID_Code_Tenpo("");
        form.setDrpID_Date_Nyukin_Gengou("");
        form.setTxtID_Date_Nyukin_Year_Input("");
        form.setDrpID_Date_Nyukin_Month("");
        form.setDrpID_Date_Nyukin_Day("");
        form.setTxtID_M_RyuchiKikanRisoku("");
        form.setTxtID_M_DaibenChienSongai("");
        form.setTxtID_M_Sokin("");
        form.setTxtID_Date_Jtkshori("");
        form.setDrpID_Date_Sokin_Gengou("");
        form.setTxtID_Date_Sokin_Year_Input("");
        form.setDrpID_Date_Sokin_Month("");
        form.setDrpID_Date_Sokin_Day("");
        form.setTxtID_Code_Sokin("");
        form.setDrpID_Date_Jtkshori_Gengou("");
        form.setTxtID_Date_Jtkshori_Year_Input("");
        form.setDrpID_Date_Jtkshori_Month("");
        form.setID_Report("");
        form.setID_History("");
        form.setID_Status("");
        form.setID_Type_Process("");
        form.setID_DataCode("");
        form.setTime_Report("");
        form.setID_Data_LastUpDate("");
        form.setProcessMode("");
        form.setRedAreaTitle("");
        form.setBlackAreaTitle("");
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
}