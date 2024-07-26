//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_01.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md008.common.Md008Constants;
import jp.go.jfc.partnernet.md008.md008_01.service.Md008_01DTO;
import jp.go.jfc.partnernet.md008.md008_01.service.Md008_01Service;
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
 * このクラスはMd008_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md008_01Form")
@RequestMapping(value = "/Md008_01Init.form")
public class Md008_01InitController extends Md008_01BaseController {

    /** Log */
    private static Log log = LogFactory.getLog(Md008_01InitController.class);

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;
    /** Md008_01Service */
    @Autowired
    Md008_01Service md008_01service;

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
    public String executeAction(Model model, Md008_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        log.debug("@@@@md008_01InitController");

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        Md008_01DTO inDTO = new Md008_01DTO();

        // 報告年月日
        inDTO.setLblID_Date_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_DATE_REPORT));
        // 報告時分秒
        // inDTO.setLblID_Time_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_REPORT_TIME_REPORT));
        // ステータス
        inDTO.setStatus((String) paramMap.get(Md008Constants.PROPERTY_ID_STATUS));
        // 報告書番号
        inDTO.setID_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_ID_REPORT));
        // 処理モード
        String processMode = (String) paramMap.get(Md008Constants.PROPERTY_PROCESSMODE);
        inDTO.setProcessMode(processMode);
        log.debug("----------------------------------------------------------------------------------------");
        log.debug("processMode[" + processMode + "]");
        log.debug("----------------------------------------------------------------------------------------");

        // 画面の全項目をクリアする。
        clearScreen(form);

        // 　　サービスを実行し一覧画面データを取得する。
        Md008_01DTO outDTO = md008_01service.getResultsData(inDTO);

        // 検索結果の判定
        if (PNCommonConstants.RECORD_COUNT_ZERO == outDTO.getRecordCount()) {
            // 　取得件数が０件の場合、業務エラーとし、
            // 　メッセージ領域を非表示にする
            form.setVisible(Md008Constants.PROPERTY_INFO_AREA, false);
            // 　送信ボタンを非表示にする
            form.setVisible(Md008Constants.PROPERTY_SEND_BTN, false);
            // 　編集領域を非表示にする
            form.setVisible(Md008Constants.PROPERTY_EDIT_AREA, false);
            // 　メッセージ：PM9060E「該当データがありません。 」
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        } else {

            CFWBeanUtils.copyProperties(form, outDTO);
            // 報告年月日
            String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);
            form.setLblID_Date_Report(dateFmtYYYYMMDDE(dateReport));
            // 報告書番号
            form.setID_Report((String) paramMap.get(Md008Constants.PROPERTY_ID_ID_REPORT));
            // データコード
            form.setDataCode(outDTO.getID_DataCode());
            // 処理モード
            form.setProcessMode(processMode);
            // return MY_VIEW
        }
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
    public void displayControl(Model model, Md008_01Form form, HttpServletRequest request) {

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
            form.setBlackAreaTitle(null);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、処理完了以外：取消(3)
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, false);
            // 取消内容タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, true);

            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, false);
            form.setBlackAreaTitle(null);

        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、　処理完了・修正(2)　の場合
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, true);
            // 更正赤タイトル　※表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, true);
            // 取消内容タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, false);

            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, true);
            form.setBlackAreaTitle(Md008Constants.PANEL_HEADER_KOUSEI_BLACK);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            // 処理モードが、処理完了以外・修正(4)の場合
            // 　・ 赤データ入力領域　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREA, false);
            // 更正赤タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED1, false);
            // 取消内容タイトル　※非表示
            form.setVisible(Md008Constants.FORM_NAME_REDAREATITLERED2, false);

            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md008Constants.FORM_NAME_BLACKAREA, true);
            form.setBlackAreaTitle(Md008Constants.PANEL_HEADER_SHUSEI);

        }

    }

    /**
     * <pre>
     * 画面の初期化を行います。
     * </pre>
     * @param form Md008_01Form
     */
    private void clearScreen(Md008_01Form form) {
        form.setLblID_Date_Report("");
        form.setTxtID_Name_Customer_Red("");
        form.setTxtID_Name_Organization_Red("");
        form.setTxtID_Code_ShokanHonShiten_Red("");
        form.setTxtID_Code_Organization_Red("");
        form.setTxtID_Code_Tenpo_Red("");
        form.setTxtID_Year_Red("");
        form.setTxtID_Code_HoshikiShikin_Red("");
        form.setTxtID_ID_Ringi_Red("");
        form.setTxtID_ID_RingiBranch_Red("");
        form.setTxtID_Date_Nyukin_Red("");
        form.setTxtID_M_KariukeIppanUkeire_Red("");
        form.setTxtID_Date_Jtkshori_Red("");
        form.setTxtID_Date_Sokin_Red("");
        form.setTxtID_Code_Sokin_Red("");
        form.setDrpID_Date_Jtkshori_Gengou_Red("");
        form.setTxtID_Date_Jtkshori_Year_Input_Red("");
        form.setDrpID_Date_Jtkshori_Month_Red("");
        form.setTxtID_Name_Customer("");
        form.setTxtID_Name_Organization("");
        form.setTxtID_Code_ShokanHonShiten("");
        form.setTxtID_Code_Organization("");
        form.setTxtID_Code_Tenpo("");
        form.setTxtID_Year("");
        form.setTxtID_Code_HoshikiShikin("");
        form.setTxtID_ID_Ringi("");
        form.setTxtID_ID_RingiBranch("");
        form.setDrpID_Date_Nyukin_Gengou("");
        form.setTxtID_Date_Nyukin_Year_Input("");
        form.setDrpID_Date_Nyukin_Month("");
        form.setDrpID_Date_Nyukin_Day("");
        form.setTxtID_M_KariukeIppanUkeire("");
        form.setTxtID_Date_Jtkshori("");
        form.setDrpID_Date_Sokin_Gengou("");
        form.setTxtID_Date_Sokin_Year_Input("");
        form.setDrpID_Date_Sokin_Month("");
        form.setDrpID_Date_Sokin_Day("");
        form.setTxtID_Code_Sokin("");
        form.setDrpID_Date_Jtkshori_Gengou("");
        form.setTxtID_Date_Jtkshori_Year_Input("");
        form.setDrpID_Date_Jtkshori_Month("");
        form.setTime_Report("");
        form.setID_Data_LastUpDate("");
        form.setDataCode("");
        form.setStatus("");
        form.setID_History("");
        form.setID_Report("");
        form.setRedAreaTitle("");
        form.setRedArea("");
        form.setBlackAreaTitle("");
        form.setBlackArea("");
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
        form.setVisible(Md008Constants.PROPERTY_SEND_BTN, true);
        // 　編集領域を表示にする
        form.setVisible(Md008Constants.PROPERTY_EDIT_AREA, true);
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