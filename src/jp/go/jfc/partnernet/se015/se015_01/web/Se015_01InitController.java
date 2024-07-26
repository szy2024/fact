//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se015_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/24 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se015.se015_01.web;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;

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
 * このクラスはse015_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se015_01Form")
@RequestMapping(value = "/Se015_01Init.form")
public class Se015_01InitController extends Se015_01BaseController {

    /** 定数として、一桁の数字に0を追加し二桁の数字として穴埋めする文字列を宣言 */
    private static final String FORMAT_DATE = "%1$02d";

// [DEL] Ver 3.0.0 - START
//    /** PNJpCalendarUtils */
//    @Autowired
//    PNJpCalendarUtils jpCalendarUtils;
// [DEL] Ver 3.0.0 - END

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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

        // フォームを初期化する。

        // 業務日付取得（業務共通部品）より業務日付を取得
        Calendar calBizDate =
                PNCommonComponents.strToCal(pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
        Date dtNow = calBizDate.getTime();

        // 集計開始年月日（年）_プルダウンリスト、集計終了年月日（年）_プルダウンリストの設定
        // 　　業務日付の２年前の年～業務日付の年のプルダウンリスト用データを作成する
        // 　　プルダウンリスト用データを集計開始年月日（年）、集計終了年月日（年）のコントロールに設定する
// [UPD] Ver 3.0.0 - START
//        LinkedHashMap<String, Object> mpY = new LinkedHashMap<String, Object>();
//        for (int i = 2; 0 <= i; i--) {
//            Date dtPasty = PNDateUtils.addYears(dtNow, -1 * i);
//            String[] dates = jpCalendarUtils.toJapaneseCalendar(dtPasty);
//            mpY.put(getYear(dtPasty), getYearWa(dates));
//        }
        // 業務日付の２年前の日付
        Calendar calFromDate = (Calendar)calBizDate.clone();
        calFromDate.add(Calendar.YEAR, -2);

        LinkedHashMap<String, Object> mpY = PNCommonComponents.getWarekiList(
                PNCommonComponents.calToStr(calFromDate), PNCommonComponents.calToStr(calBizDate));
// [UPD] Ver 3.0.0 - END

        // 集計開始年月日（月）_プルダウンリスト、集計終了年月日（月）_プルダウンリストの設定
        // 　　1～12のプルダウンリスト用データを作成し、
        // 　　集計開始年月日（月）、集計終了年月日（月）のコントロールに設定する
        LinkedHashMap<String, Object> mpM = new LinkedHashMap<String, Object>();
        for (int i = 1; 12 >= i; i++) {
            // 数字が一桁なら、二桁目に0を挿入
            mpM.put(String.format(FORMAT_DATE, i), Integer.toString(i));
        }

        // 集計開始年月日（日）_プルダウンリスト、集計終了年月日（日）_プルダウンリストの設定
        // 　　1～31のプルダウンリスト用データを作成し、
        // 　　集計開始年月日（日）、集計終了年月日（日）のコントロールに設定する
        LinkedHashMap<String, Object> mpD = new LinkedHashMap<String, Object>();
        for (int i = 1; 31 >= i; i++) {
            // 数字が一桁なら、二桁目に0を挿入
            mpD.put(String.format(FORMAT_DATE, i), Integer.toString(i));
        }

        // フォームに値をセット
        form.setDrpID_Date_ShukeiStartYear_PulldownList(mpY);
        form.setDrpID_Date_ShukeiStartMonth_PulldownList(mpM);
        form.setDrpID_Date_ShukeiStartDay_PulldownList(mpD);
        form.setDrpID_Date_ShukeiEndYear_PulldownList(mpY);
        form.setDrpID_Date_ShukeiEndMonth_PulldownList(mpM);
        form.setDrpID_Date_ShukeiEndDay_PulldownList(mpD);

        String strPastDate = PNFormatUtils.formatDate(dtNow).replace(PNCommonConstants.LITERAL_SLASH, "");

        // 集計開始年月日（年）、集計終了年月日（年）の設定
        // 　　業務日付の年を初期値として設定する
        // 集計開始年月日（月）、集計終了年月日（月）の設定
        // 　　業務日付の月を初期値として設定する
        // 集計開始年月日（日）、集計終了年月日（日）の設定
        // 　　業務日付の日を初期値として設定する
// [UPD] Ver 3.0.0 - START
//        form.setDrpID_Date_ShukeiStartYear(strPastDate.substring(0, 4));
        form.setDrpID_Date_ShukeiStartYear(
                PNCommonComponents.dateFmtAD_YYYYMMDD(strPastDate).split("\\.")[0]);
// [UPD] Ver 3.0.0 - END
        form.setDrpID_Date_ShukeiStartMonth(strPastDate.substring(4, 6));
        form.setDrpID_Date_ShukeiStartDay(strPastDate.substring(6, 8));

// [UPD] Ver 3.0.0 - START
//        form.setDrpID_Date_ShukeiEndYear(strPastDate.substring(0, 4));
        form.setDrpID_Date_ShukeiEndYear(
                PNCommonComponents.dateFmtAD_YYYYMMDD(strPastDate).split("\\.")[0]);
// [UPD] Ver 3.0.0 - END
        form.setDrpID_Date_ShukeiEndMonth(strPastDate.substring(4, 6));
        form.setDrpID_Date_ShukeiEndDay(strPastDate.substring(6, 8));

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
    public void displayControl(Model model, Se015_01Form form,
            HttpServletRequest request) {

    }

// [DEL] Ver 3.0.0 - START
//    /**\
//     * Date形式の引数が空白でないとき、24文字目から28文字目までを文字列として返す
//     *
//     * @param py 年
//     * @return 年
//     */
//    private String getYear(Date py) {
//        if (null == py) {
//            return "";
//        }
//        return new StringBuffer(py.toString()).substring(24, 28);
//    }
//
//    /**
//     * 文字配列の引数をが空白でないとき、StringBufferの形式に沿って、一文字目と三文字目を連結したものを返す
//     *
//     * @param pstr 和暦(年)
//     * @return 和暦(年)
//     */
//    private String getYearWa(String[] pstr) {
//        if (null == pstr) {
//            return "";
//        }
//        StringBuffer sb = new StringBuffer("");
//        sb.append(pstr[0]);
//        sb.append(pstr[2]);
//        return sb.toString();
//    }
// [DEL] Ver 3.0.0 - END

}