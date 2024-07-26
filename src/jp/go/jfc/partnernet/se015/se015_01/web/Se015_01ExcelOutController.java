//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se015_01ExcelOutController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/24 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se015.se015_01.web;

import java.io.File;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se015.se015_01.service.Se015_01DTO;
import jp.go.jfc.partnernet.se015.se015_01.service.Se015_01Service;

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
import org.hsqldb.lib.StringUtil;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse015_01のExcel出力ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se015_01Form")
@RequestMapping(value = "/Se015_01ExcelOut.form")
public class Se015_01ExcelOutController extends Se015_01BaseController {

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Se015_01Service */
    @Autowired
    Se015_01Service se015_01service;

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
    public String executeAction(Model model, Se015_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        /** Logger */
        final Log log = LogFactory.getLog(Se015_01ExcelOutController.class);

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // Formより画面に入力されたデータをDTOに設定（form→inDto)

        // 必須エラーチェック
        // ------------------------------------------------------------------------------
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiStartYear())) {
            // 　　集計開始年月日（年）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計開始年月日（年）" }, false));
        }
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiStartMonth())) {
            // 　　集計開始年月日（月）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計開始年月日（月）" }, false));
        }
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiStartDay())) {
            // 　　集計開始年月日（日）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計開始年月日（日）" }, false));
        }
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiEndYear())) {
            // 　　集計終了年月日（年）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計終了年月日（年）" }, false));
        }
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiEndMonth())) {
            // 　　集計終了年月日（月）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計終了年月日（月）" }, false));
        }
        if (StringUtil.isEmpty(form.getDrpID_Date_ShukeiEndDay())) {
            // 　　集計終了年月日（日）が入力されていない場合、エラーとする。
            // 　　　PM3120E　{0}が入力されていません。　※{0} ・・・【項目名】
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3120E,
                    new String[] { "集計終了年月日（日）" }, false));
        }

        // 属性エラーチェック
        if (bizErrors.size() == 0) {
// [DEL] Ver 3.0.0 - START
//            // 集計開始年月日（年）属性チェック
//            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiStartYear())
//            && form.getDrpID_Date_ShukeiStartYear().length() <= 4) == false) {
//                // 　入力された値が数字以外の場合、エラーとする。
//                // 　　メッセージ：集計開始年月日（年）は半角数字、PM3140E
//                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
//                        new String[] { "集計開始年月日（年）は半角数字4桁以下" }, false));
//            }
// [DEL] Ver 3.0.0 - END
            // 集計開始年月日（月）属性チェック
            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiStartMonth())
            && form.getDrpID_Date_ShukeiStartMonth().length() <= 2) == false) {
                // 　入力された値が数字以外の場合、エラーとする。
                // 　　メッセージ：集計開始年月日（月）は半角数字、PM3140E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計開始年月日（月）は半角数字2桁以下" }, false));
            }
            // 集計開始年月日（日）属性チェック
            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiStartDay())
            && form.getDrpID_Date_ShukeiStartDay().length() <= 2) == false) {
                // 　入力された値が数字以外の場合、エラーとする。
                // 　　メッセージ：集計開始年月日（日）は半角数字、PM3140E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計開始年月日（日）は半角数字2桁以下" }, false));
            }
// [DEL] Ver 3.0.0 - START
//            // 集計終了年月日（年）属性チェック
//            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiEndYear())
//            && form.getDrpID_Date_ShukeiEndYear().length() <= 4) == false) {
//                // 　入力された値が数字以外の場合、エラーとする。
//                // 　　メッセージ：集計終了年月日（年）は半角数字、PM3140E
//                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
//                        new String[] { "集計終了年月日（年）は半角数字4桁以下" }, false));
//            }
// [DEL] Ver 3.0.0 - END
            // 集計終了年月日（月）属性チェック
            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiEndMonth())
            && form.getDrpID_Date_ShukeiEndMonth().length() <= 2) == false) {
                // 　入力された値が数字以外の場合、エラーとする。
                // 　　メッセージ：集計終了年月日（月）は半角数字、PM3140E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計終了年月日（月）は半角数字2桁以下" }, false));
            }
            // 集計終了年月日（日）属性チェック
            if ((PNStringChecker.isAllHalfNumber(form.getDrpID_Date_ShukeiEndDay())
            && form.getDrpID_Date_ShukeiEndDay().length() <= 2) == false) {
                // 　入力された値が数字以外の場合、エラーとする。
                // 　　メッセージ：集計終了年月日（日）は半角数字、PM3140E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計終了年月日（日）は半角数字2桁以下" }, false));
            }
        }

        // 有効日エラーチェック
        // ------------------------------------------------------------------------------
        if (bizErrors.size() == 0) {
            // 集計開始年月日有効エラー
            // 入力エラーがない場合、有効日チェックを行う。
// [UPD] Ver 3.0.0 - START
//            String startYear = String.format("%04d", Integer.parseInt(form.getDrpID_Date_ShukeiStartYear()));
//            String startMonth = String.format("%02d", Integer.parseInt(form.getDrpID_Date_ShukeiStartMonth()));
//            String startDay = String.format("%02d", Integer.parseInt(form.getDrpID_Date_ShukeiStartDay()));
//
//            String strShukeiStartDate = PNCommonComponents.concatString(startYear, startMonth, startDay);
            String strShukeiStartDate = PNCommonComponents.dateFmtJC_Gyymmdd(
                    PNCommonComponents.concatString(
                            form.getDrpID_Date_ShukeiStartYear(),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiStartMonth(), 2),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiStartDay(), 2)),
                    "");
// [UPD] Ver 3.0.0 - END
            if (PNCommonComponents.checkDate(strShukeiStartDate) == false) {
                // 　集計開始年月日の日付が有効な日付でない場合、集計開始年月日有効エラーとする。
                // 　　PM3140E : {0}で入力してください。　※{0} ・・・集計開始年月日は有効な日付
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "集計開始年月は有効な日付" }, false));
            }

            // 集計終了年月日有効エラー
            // 入力エラーがない場合、有効日チェックを行う。
// [UPD] Ver 3.0.0 - START
//            String endYear = String.format("%04d", Integer.parseInt(form.getDrpID_Date_ShukeiEndYear()));
//            String endMonth = String.format("%02d", Integer.parseInt(form.getDrpID_Date_ShukeiEndMonth()));
//            String endDay = String.format("%02d", Integer.parseInt(form.getDrpID_Date_ShukeiEndDay()));
//
//          String strShukeiEndDate = PNCommonComponents.concatString(endYear, endMonth, endDay);
            String strShukeiEndDate = PNCommonComponents.dateFmtJC_Gyymmdd(
                            PNCommonComponents.concatString(
                                    form.getDrpID_Date_ShukeiEndYear(),
                                    PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiEndMonth(), 2),
                                    PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiEndDay(), 2)),
                            "");
// [UPD] Ver 3.0.0 - END
            if (PNCommonComponents.checkDate(strShukeiEndDate) == false) {
                // 　集計終了年月日の日付が有効な日付でない場合、集計終了年月日有効エラーとする。
                // 　　PM3140E : {0}で入力してください。　※{0} ・・・集計終了年月日は有効な日付
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "集計終了年月日は有効な日付" }, false));
            }
        }

        // 指定範囲エラーチェック
        // ------------------------------------------------------------------------------
        if (bizErrors.size() == 0) {

            // 業務日付取得
            Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                    .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
            String strBizYMD = PNCommonComponents.calToStr(calBizDate);
            calBizDate.add(Calendar.YEAR, -2);
            String strBizYMDTwoYearsAgo = PNCommonComponents.calToStr(calBizDate);

// [UPD] Ver 3.0.0 - START
//            String startDate = PNCommonComponents.concatString(new String[] { form.getDrpID_Date_ShukeiStartYear(),
//                    form.getDrpID_Date_ShukeiStartMonth(), form.getDrpID_Date_ShukeiStartDay() });
//
//            String endDate = PNCommonComponents.concatString(new String[] { form.getDrpID_Date_ShukeiEndYear(),
//                    form.getDrpID_Date_ShukeiEndMonth(), form.getDrpID_Date_ShukeiEndDay() });
            String startDate = PNCommonComponents.dateFmtJC_Gyymmdd(
                    PNCommonComponents.concatString(
                            form.getDrpID_Date_ShukeiStartYear(),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiStartMonth(), 2),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiStartDay(), 2)),
                    "");

            String endDate = PNCommonComponents.dateFmtJC_Gyymmdd(
                    PNCommonComponents.concatString(
                            form.getDrpID_Date_ShukeiEndYear(),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiEndMonth(), 2),
                            PNFormatUtils.toZeroPadding(form.getDrpID_Date_ShukeiEndDay(), 2)),
                    "");
// [UPD] Ver 3.0.0 - END

            // 集計開始年月日指定エラー
            if (Integer.parseInt(startDate) > Integer.parseInt(strBizYMD)
                    || Integer.parseInt(startDate) < Integer.parseInt(strBizYMDTwoYearsAgo)) {
                // 　集計開始年月日＞ 業務日付　または
                // 　集計開始年月日＜ 業務日付の２年前の日付の場合、集計開始年月日指定エラーとする。
                // 　　PM3140E : {0}で入力してください。　※{0} ・・・集計開始年月日は２年前～業務日付の年月日
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計開始年月日は２年前～業務日付の年月日" }, false));
            }
            // 集計終了年月日指定エラー
            if (Integer.parseInt(endDate) > Integer.parseInt(strBizYMD)
                    || Integer.parseInt(endDate) < Integer.parseInt(strBizYMDTwoYearsAgo)) {
                // 　集計終了年月日＞ 業務日付　または
                // 　集計終了年月日＜ 業務日付の２年前の日付の場合、集計終了年月日指定エラーとする。
                // 　　PM3140E : {0}で入力してください。　※{0} ・・・集計終了年月日は２年前～業務日付の年月日
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計終了年月日は２年前～業務日付の年月日" }, false));
            }
            // 集計年月日範囲指定エラー
            if (Integer.parseInt(startDate) > Integer.parseInt(endDate)) {
                // 　集計開始年月日＞集計終了年月日の場合、集計年月日範囲指定エラーとする。
                // 　　PM3140E : {0}で入力してください。　※{0} ・・・集計開始年月日、集計終了年月日は指定可能な期間
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                        new String[] { "集計開始年月日、集計終了年月日は指定可能な期間" }, false));
            }
        }

        // 画面のメッセージが設定されていない場合、サービスを実行し、登録処理を行う。
        if (bizErrors.size() > 0) {
            // エラーメッセージ表示
            throw new PNServiceException(bizErrors);
        }
        else {

            Se015_01DTO inDto = new Se015_01DTO();
            CFWBeanUtils.copyProperties(inDto, form);

            // サービスを実行し、Excel出力処理を行う。
            Se015_01DTO outDto = se015_01service.excelOut(inDto);

            // ファイルパス取得
            String strFilePath = outDto.getDownload_FilePath();

            // ダウンロードするファイルの存在チェック
            File file = new File(strFilePath);
            if (file.exists() == false) {
                // 　ファイルが存在しなかった場合、メッセージを表示する。
                // 　メッセージ：PM9040E（ファイルが存在しません。）
                throw new PNServiceException(PNCommonMessageConstants.PM9040E);
            }

            // ファイルをダウンロード(ダウンロード後にファイルを削除)
            setFileDownload(request, strFilePath, true);

            log.info("ダウンロード元ファイル[" + strFilePath + "]");
        }

        // 戻り値（画面遷移情報）に自画面を設定する。
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
    public void displayControl(Model model, Se015_01Form form,
            HttpServletRequest request) {

    }
}