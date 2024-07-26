//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md010_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md010.md010_01.web;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md010.common.Md010Constants;
import jp.go.jfc.partnernet.md010.md010_01.service.Md010_01DTO;
import jp.go.jfc.partnernet.md010.md010_01.service.Md010_01M1DTO;
import jp.go.jfc.partnernet.md010.md010_01.service.Md010_01Service;
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
 * このクラスはmd010_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md010_01Form")
@RequestMapping(value = "/Md010_01Init.form")
public class Md010_01InitController extends Md010_01BaseController {

    /** Md010_01Service */
    @Autowired
    Md010_01Service md010_01service;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Md010_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 遷移パラメータが設定されている場合
        if (!getForwardParameter(request).isEmpty()) {

            // formの情報を初期化
            clearForm(form);

            // 遷移パラメータをformに設定
            setRequestScreen(request, form);

        }

        // メッセージＩＤが設定されている場合、メッセージを表示する。
        if (form.getLblMessageID() != null && !form.getLblMessageID().isEmpty()) {
            addMessage(errors, form.getLblMessageID(), new String[] { "" }, false);
            form.setLblMessageID(null);

        }

        // 初期表示 または 処理モードが修正の場合
        if (!Md010Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getProcessMode())) {

            Md010_01DTO inDto = new Md010_01DTO();
            Md010_01DTO outDto = new Md010_01DTO();

            // form項目をDTOに設定する。
            inDto.setID_Report(form.getID_Report());

            // サービスを実行し画面データを取得する。
            outDto = md010_01service.getResultsData(inDto);

            // 取得件数が０件の場合、エラーメッセージを表示し、戻るボタン以外を非表示にする。
            if (outDto.getDataCount() == 0) {

                // 処理モードに空白設定
                form.setProcessMode(PNCommonConstants.LITERAL_BLANK);

                // PM9060E : 該当データがありません。
                throw new PNServiceException(PNCommonMessageConstants.PM9060E);

            }

            // DTO項目をformに設定する。
            // DTO.履歴番号 ⇒ form.履歴番号
            form.setID_History(outDto.getID_History());

            // DTO.交付依頼年月（年）⇒ form.交付依頼年月（年）
            form.setLblID_KofuIraiYear(outDto.getLblID_KofuIraiYear());

            // DTO.交付依頼年月（月）⇒ form.交付依頼年月（月）
            form.setLblID_KofuIraiMonth(outDto.getLblID_KofuIraiMonth());

            // 交付日（日）_プルダウンリストの設定
            // 交付依頼年月の最終日を取得する。（交付依頼年月が201702の場合、最終日は28）
            // 先頭空白、1～最終日のプルダウンリスト用データを作成。
            LinkedHashMap<String, Object> mpD = new LinkedHashMap<String, Object>();
            mpD.put(Md010Constants.INIT_KOFUDATE, Md010Constants.INIT_KOFUDATE);
            for (int i = 1; i <= getLastDate(outDto); i++) {
                mpD.put(Integer.toString(i), i);
            }

            // 明細行数分以下の処理を繰り返す
            List<Md010_01M1DTO> m1List = outDto.getMEISAI_LIST();
            for (Md010_01M1DTO m1Dto : m1List) {

                // プルダウンリスト用データ ⇒ form.交付日（日）_プルダウンリスト
                m1Dto.setKOFU_DATE_PULLDOWN(mpD);

            }

            form.getMd010_01m1Table().setRecordList(m1List, m1List.size());

            // 更新可否フラグの設定
            form.setLblID_Flag_Updatable(isUpdatable(outDto));

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
    public void displayControl(Model model, Md010_01Form form,
            HttpServletRequest request) {

        String processMode = form.getProcessMode();
        String itemName = "";

        // 受渡パラメータの操作選択が取消の場合、非活性制御
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            for (int i = 0; i < 6; i++) {

                itemName = PNCommonComponents.concatString(
                        Md010Constants.ITEMNAME_RECORDLIST, String.valueOf(i));

                // 交付日（日）非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_DRPID_KOFUDATE), true);

                // 依頼予定額 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_TXTID_IRAI), true);

                // 元金充当額
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_TXTID_GANJU), true);

            }

            // 登録後表示 の場合、登録ボタン非活性
            if (Md010Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())) {
                form.setProtect(Md010Constants.ITEMNAME_BTNUPDATE2, true);
            }
            // 上記以外 の場合、登録ボタン活性
            else {
                form.setProtect(Md010Constants.ITEMNAME_BTNUPDATE2, false);
            }

        }
        else {
            for (int i = 0; i < 6; i++) {

                itemName = PNCommonComponents.concatString(
                        Md010Constants.ITEMNAME_RECORDLIST, String.valueOf(i));

                // 交付日（日）活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_DRPID_KOFUDATE), false);

                // 依頼予定額 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_TXTID_IRAI), false);

                // 元金充当額 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Md010Constants.ITEMNAME_TXTID_GANJU), false);

            }

            // 登録ボタン活性
            form.setProtect(Md010Constants.ITEMNAME_BTNUPDATE2, false);

        }

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestScreen(HttpServletRequest request, Md010_01Form form) {

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        // 報告書履歴番号
        form.setID_Report((String)paramMap.get(Md010Constants.PROPERTY_ID_REPORT));

        // 操作選択(処理モード)
        form.setProcessMode((String)getForwardParameter(request).get(Md010Constants.PROPERTY_ID_PROCESS_MODE));

    }

    /**
     * form情報の初期化
     *
     * @param form
     */
    private void clearForm(Md010_01Form form) {

        // 更新済フラグ
        form.setLblID_Flag_Koushinzumi(null);

    }

    /**
     * 交付依頼年月の最終日を取得
     *
     * @param outDto
     */
    private int getLastDate(Md010_01DTO outDto) {

        String kofuirai = PNCommonComponents.concatString(
                PNCommonComponents.dateFmtJC_Gyy(outDto.getLblID_KofuIraiYear())
                , outDto.getLblID_KofuIraiMonth()
                , "01");
        return PNCommonComponents.strToCal(kofuirai).getActualMaximum(Calendar.DATE);

    }

    /**
     * 初期表示時の時間、対象データの交付依頼年月を基に登録期限を判定し
     * 更新可否を返す
     *
     * @param outDto
     * @return 更新可（true） 更新不可（false）
     */
    private boolean isUpdatable(Md010_01DTO outDto) {

        // 基準日
        String strBizDate = "";

        // システム時刻（HH:MM:SS） ≦ 12:00:00 の場合（午前の場合）
        if (Md010Constants.LIMIT_TIME_120000.compareTo(PNCommonComponents.getSysDateTime()) >= 0) {

            // 業務日付取得（業務共通部品）より業務日付を取得
            strBizDate = pnCommonDBComponents.getPNBusinessDay(1);

        }
        // 上記以外の場合（午後の場合）
        else {

            // 業務日付の翌営業日を取得
            strBizDate = (pnCommonDBComponents.calcNextBizDate());

        }

        // 業務日付が取得できなかった場合エラーとする
        if (!PNCommonComponents.checkDate(strBizDate)) {
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 取得した日付を入力として、資金交付依頼日取得（業務共通部品）を呼び出し、資金交付依頼日を取得する。
        String kofuirai = pnCommonDBComponents.calcKofuDate(strBizDate);

        // 取得した資金交付依頼日のyyyyMM と DTO.交付依頼年月が等しい場合
        if (kofuirai.substring(PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX).
                equals(outDto.getLblID_KofuIrai())) {

            // form.更新可否フラグに true （更新可）を設定する。
            return true;

        }
        // 上記以外の場合
        else {
            // form.更新可否フラグに false （更新不可）を設定する。
            return false;

        }

    }
}