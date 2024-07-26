//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md011_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.web;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md011.common.Md011Constants;
import jp.go.jfc.partnernet.md011.md011_01.service.Md011_01DTO;
import jp.go.jfc.partnernet.md011.md011_01.service.Md011_01Service;
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
 * このクラスはmd011_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md011_01Form")
@RequestMapping(value = "/Md011_01Init.form")
public class Md011_01InitController extends Md011_01BaseController {

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Md011_01Service */
    @Autowired
    Md011_01Service md011_01service;

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
    public String executeAction(Model model, Md011_01Form form,
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

        // 取消済フラグが1以外（初期表示）または処理モードが修正の場合
        if (!Md011Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())
                || PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getProcessMode())) {

            Md011_01DTO inDto = new Md011_01DTO();
            Md011_01DTO outDto = new Md011_01DTO();

            // form項目をDTOに設定する。
            inDto.setID_Report(form.getID_Report());

            // サービスを実行し画面データを取得する。
            outDto = md011_01service.getResultsData(inDto);

            // 取得件数が０件の場合、エラーメッセージを表示し、戻るボタン以外を非表示にする。
            if (outDto.getDataCount() == 0) {

                // 処理モードに空白設定
                form.setProcessMode(PNCommonConstants.LITERAL_BLANK);

                // PM9060E : 該当データがありません。
                throw new PNServiceException(PNCommonMessageConstants.PM9060E);

            }

            // DTO.履歴番号         ⇒  form.履歴番号
            form.setID_History(outDto.getID_History());

            // DTO.報告書番号       ⇒  form.報告書番号
            form.setID_Report(outDto.getID_Report());

            // DTO.扱店名           ⇒  form.扱店名
            form.setLblID_Name_Organization(outDto.getLblID_Name_Organization());

            // DTO.扱店コード       ⇒  form.扱店コード
            form.setLblID_Code_Organization(outDto.getLblID_Code_Organization());

            // DTO.指定交付日（年） ⇒  form.指定交付日（年）
            form.setDrpID_ShiteiKofuYear(outDto.getDrpID_ShiteiKofuYear());

            // DTO.指定交付日（月） ⇒  form.指定交付日（月）
            form.setDrpID_ShiteiKofuMonth(outDto.getDrpID_ShiteiKofuMonth());

            // DTO.指定交付日（日） ⇒  form.指定交付日（日）
            form.setDrpID_ShiteiKofuDate(outDto.getDrpID_ShiteiKofuDate());

            // DTO.更新日時         ⇒  form.更新日時
            form.setLblID_DateTime_Update(outDto.getLblID_DateTime_Update());

            // 業務日付取得（業務共通部品）より業務日付を取得
            String strBizDate = pnCommonDBComponents.getPNBusinessDay(1);
            if (!PNCommonComponents.checkDate(strBizDate)) {
                throw new PNSystemException(PNCommonMessageConstants.PM9990E);
            }
            Calendar calBizDate = PNCommonComponents.strToCal(strBizDate);

            // 指定交付日（年）_プルダウンリストの設定
            // 業務日付の年～業務日付の１年後の年のプルダウンリスト用データを作成する
            // プルダウンリスト用データを以下のコントロールに設定する
// [UPD] Ver 3.0.0 - START
//            LinkedHashMap<String, Object> mpY = new LinkedHashMap<String, Object>();
//            for (int n = 0; n <= 1; n++) {
//                String kofuYear = String.valueOf(calBizDate.get(Calendar.YEAR) + n);
//                mpY.put(kofuYear, PNCommonComponents.dateFmtAD_YYYY(kofuYear));
//
//            }
            // 業務日付の１年後
            calBizDate.add(Calendar.YEAR, 1);
            String toDate = PNCommonComponents.calToStr(calBizDate);

            LinkedHashMap<String, Object> mpY = PNCommonComponents.getWarekiList(strBizDate, toDate);
// [UPD] Ver 3.0.0 - END
            form.setSHITEIKOHU_YEAR_PULLDOWN_LIST(mpY);

            // 指定交付日（月）_プルダウンリストの設定
            // 1～12のプルダウンリスト用データを作成し、以下のコントロールに設定する
            LinkedHashMap<String, Object> mpM = new LinkedHashMap<String, Object>();
            for (int i = 1; i <= 12; i++) {
                mpM.put(Integer.toString(i), i);

            }
            form.setSHITEIKOHU_MONTH_PULLDOWN_LIST(mpM);

            // 指定交付日（日）_プルダウンリストの設定
            // 1～31のプルダウンリスト用データを作成し、以下のコントロールに設定する
            LinkedHashMap<String, Object> mpD = new LinkedHashMap<String, Object>();
            for (int i = 1; i <= 31; i++) {
                mpD.put(Integer.toString(i), i);

            }
            form.setSHITEIKOHU_DATE_PULLDOWN_LIST(mpD);

            form.getMd011_01m1Table().setRecordList(outDto.getMEISAI_LIST(), outDto.getMEISAI_LIST().size());

            // 退避指定交付日の設定
            form.setLblID_Keep_ShiteiKofu(outDto.getLblID_ShiteiKofu());

            // 初期表示時刻の設定
            form.setLblID_InitDispTime(PNCommonComponents.getSysDateTime());

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
    public void displayControl(Model model, Md011_01Form form,
            HttpServletRequest request) {

        String processMode = form.getProcessMode();

        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 受渡パラメータの操作選択が取消の場合、非活性制御
            // 指定交付日（年）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUYEAR, true);
            // 指定交付日（月）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUMONTH, true);
            // 指定交付日（日）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUDATE, true);
            // 資金払出予定額
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_YOTEI, true);
            // 資金交付金残高見込額（指定交付日の前日現在）
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_ZANMIKOMI, true);
            // 元金充当額(外数）
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_GANJU_GAISU, true);
            // 備考
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_BIKO, true);

            // 登録後表示 の場合、登録ボタン非活性
            if (Md011Constants.FLAG_KOUSHINZUMI.equals(form.getLblID_Flag_Koushinzumi())) {
                form.setProtect(Md011Constants.ITEMNAME_BTNUPDATE2, true);
            }
            // 上記以外 の場合、登録ボタン活性
            else {
                form.setProtect(Md011Constants.ITEMNAME_BTNUPDATE2, false);
            }

        }
        else {
            // 受渡パラメータの操作選択が修正の場合
            // 遷移元が資金交付依頼書（週間）取消・修正（入力画面）の場合
            // 指定交付日（年）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUYEAR, false);
            // 指定交付日（月）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUMONTH, false);
            // 指定交付日（日）
            form.setProtect(Md011Constants.ITEMNAME_DRPID_SHITEIKOFUDATE, false);
            // 資金払出予定額
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_YOTEI, false);
            // 資金交付金残高見込額（指定交付日の前日現在）
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_ZANMIKOMI, false);
            // 元金充当額(外数）
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_GANJU_GAISU, false);
            // 備考
            form.setProtect(Md011Constants.ITEMNAME_TXTID_M_BIKO, false);
            // 登録ボタン活性
            form.setProtect(Md011Constants.ITEMNAME_BTNUPDATE2, false);
        }

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestScreen(HttpServletRequest request, Md011_01Form form) {

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        // 報告書番号
        form.setID_Report((String)paramMap.get(Md011Constants.PROPERTY_ID_REPORT));

        // 操作選択(処理モード)
        form.setProcessMode((String)paramMap.get(Md011Constants.PROPERTY_ID_PROCESS_MODE));

    }

    /**
     * form情報の初期化
     *
     * @param form
     */
    private void clearForm(Md011_01Form form) {

        // 更新済フラグ
        form.setLblID_Flag_Koushinzumi(null);

    }

}