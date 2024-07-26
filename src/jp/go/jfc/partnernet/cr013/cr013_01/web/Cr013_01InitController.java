//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr013_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr013.cr013_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr013.common.Cr013Constants;
import jp.go.jfc.partnernet.cr013.cr013_01.service.Cr013_01DTO;
import jp.go.jfc.partnernet.cr013.cr013_01.service.Cr013_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
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
 * このクラスはcr013_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr013_01Form")
@RequestMapping(value = "/Cr013_01Init.form")
public class Cr013_01InitController extends Cr013_01BaseController {

// [DEL] Ver 3.0.0 - START
//    /** Log */
//    private static Log log = LogFactory.getLog(Cr013_01InitController.class);
// [DEL] Ver 3.0.0 - END

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Cr013_01Service */
    @Autowired
    Cr013_01Service cr013_01service;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Cr013_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        Cr013_01DTO inDto = new Cr013_01DTO();
        // フォームを初期化する。
        // メッセージを表示する。
        if (form.getLblMessageID() != null && !form.getLblMessageID().isEmpty()) {
            addMessage(errors, form.getLblMessageID(), new String[] { "" }, false);
            form.setLblMessageID(null);
        }
        // 発信者
        form.setLblID_Name_Organizat(PNCommonConstants.LITERAL_BLANK);
        // 発信日
        form.setLblID_SendDate_Report(PNCommonConstants.LITERAL_BLANK);
        // ファイル名
        form.setLblID_Disp_DocName(PNCommonConstants.LITERAL_BLANK);
        // 表示ファイル名
        form.setLblID_Disp_DocName(PNCommonConstants.LITERAL_BLANK);
        // アップロードファイル名
        form.setLblID_UpLoadNam(PNCommonConstants.LITERAL_BLANK);
        // 添付ファイルアップロード先パス
        form.setLblID_UpLoadFilePath(PNCommonConstants.LITERAL_BLANK);
        // 扱店
        form.setLblID_Code_Organization(PNCommonConstants.LITERAL_BLANK);
        // 店舗
        form.setLblID_Code_Tenpo(PNCommonConstants.LITERAL_BLANK);
        // 表示制御
        form.setFlgDisp(PNCommonConstants.LITERAL_BLANK);

        // 業務日付取得（業務共通部品）より業務日付を求め、「Gyy年mm月dd日」の形式に編集しformの発信日に設定する。
// [UPD] Ver 3.0.0 - START
//        form.setLblID_SendDate_Report(dateFmt(pnCommonDBComponents.getPNBusinessDay(1)));
        form.setLblID_SendDate_Report(
                PNCommonComponents.dateFmtJC_Kanzi_YYYYMMDD(pnCommonDBComponents.getPNBusinessDay(1)));
// [UPD] Ver 3.0.0 - END

        CFWBeanUtils.copyProperties(inDto, form);

        // 発信者名の設定
        Cr013_01DTO outDto = new Cr013_01DTO();
        outDto = cr013_01service.getInitData(inDto);
        if (0 == outDto.getDataCount().intValue()) {
            // ■取得件数が０件の場合、業務エラーとし、登録ボタン、編集領域を非表示にする。
            // 　　メッセージＩＤ：PM9060E　該当データがありません。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }
        else {
            // ■上記以外の場合、取得した発信者をformにセットする。
            // 発信者 ： outDto.発信者
            form.setLblID_Name_Organizat(outDto.getLblID_Name_Organizat());
            // 表示制御
            form.setFlgDisp(Cr013Constants.FLG_DISP_ON);
        }

        // ログインユーザの店舗コード　 ： outDto.店舗
        form.setLblID_Code_Tenpo(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());

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
    public void displayControl(Model model, Cr013_01Form form, HttpServletRequest request) {

        // 登録ボタン 非活性
        form.setProtect(Cr013Constants.PROPERTY_UPDATE_BTN, true);

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
//                , Cr013Constants.STR_YEAR
//                , dateDD
//                , Cr013Constants.STR_MONTH
//                , dateMM
//                , Cr013Constants.STR_DAY);
//
//        return outDate;
//
//    }
// [DEL] Ver 3.0.0 - END

}