//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2019/01/29 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_01.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.se008.common.Se008Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustAnytimeExecute;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはSe008_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se008_01Form")
@RequestMapping(value = "/Se008_01Init.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CrustAnytimeExecute
public class Se008_01InitController extends Se008_01BaseController {

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    // 日付フォーマット
    private static final DateFormat dtFormat = new SimpleDateFormat(PNDateUtils.DATE_PATTERN_YYYYMMDD);

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
    public String executeAction(Model model, Se008_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 業務日付取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        String nowMonth = new StringBuffer(nowDate).substring(4, 6);
        String nowDay = new StringBuffer(nowDate).substring(6, 8);
        Date dtNow = cnvStringToDate(nowDate);
        // 翌月取得
        Date dtNext = PNDateUtils.addMonths(dtNow, 1);
        String nextDate = dtFormat.format(dtNext);
        String nextMonth = new StringBuffer(nextDate).substring(4, 6);

// [UPD] Ver 2.0.0 - START
//        // 年リスト
//        LinkedHashMap<String, Object> mpY = new LinkedHashMap<String, Object>();
//
//        // 和暦年取得用
//        String warekiY = "";
//        for (int i = 0; 2 > i; i++) {
//            // 年加算
//            Date dtY = PNDateUtils.addYears(dtNow, i);
//            String year = new StringBuffer(dtY.toString()).substring(24, 28);
//            // 和暦年取得
//            warekiY = PNCommonComponents.dateFmtAD_YYYY(year);
//            // 年リストに追加
//            mpY.put(warekiY, warekiY);
//            // 現在月が12月以外の場合
//            if (!Se008Constants.DECEMBER.equals(new StringBuffer(nowDate).substring(4, 6))) {
//                // 繰り返し処理終了
//                break;
//            }
//        }
        String fromDate = new SimpleDateFormat("yyyyMMdd").format(dtNow);
        String toDate = "";
        if (!Se008Constants.DECEMBER.equals(new StringBuffer(nowDate).substring(4, 6))) {
            // 現在月が12月以外の場合
            toDate = new SimpleDateFormat("yyyyMMdd").format(dtNext);
        }
        else {
            // 現在月が12月の場合
            toDate = new SimpleDateFormat("yyyyMMdd").format(PNDateUtils.addYears(dtNow, 1));
        }

        LinkedHashMap<String, Object> mpY = PNCommonComponents.getWarekiList(fromDate, toDate);
// [UPD] Ver 2.0.0 - END

        // 検索開始年リスト
        form.setSearchStartYear_PulldownList(mpY);
        // 検索終了年リスト
        form.setSearchEndYear_PulldownList(mpY);

        // 月リスト
        LinkedHashMap<String, Object> mpM = new LinkedHashMap<String, Object>();
        // 当月
        mpM.put(nowMonth, nowMonth);
        // 検索開始月リスト
        form.setSearchStartMonth_PulldownList(mpM);

        // 月リストに翌月追加
        mpM.put(nextMonth, nextMonth);
        // 検索終了月リスト
        form.setSearchEndMonth_PulldownList(mpM);

        // 和暦年取得
// [DEL] Ver 2.0.0 - START
//        String year = new StringBuffer(dtNow.toString()).substring(24, 28);
//        warekiY = PNCommonComponents.dateFmtAD_YYYY(year);
// [DEL] Ver 2.0.0 - END
        // 検索開始年月日【年】
// [UPD] Ver 2.0.0 - START
//        form.setSearchStartYear(warekiY);
        form.setSearchStartYear(PNCommonComponents.dateFmtAD_YYYYMMDD(fromDate).split("\\.")[0]);
// [UPD] Ver 2.0.0 - END
        // 検索開始年月日【月】
        form.setSearchStartMonth(nowMonth);
        // 検索開始年月日【日】
        form.setSearchStartDate(nowDay);

        // 和暦年取得
// [DEL] Ver 2.0.0 - START
//        year = new StringBuffer(dtNext.toString()).substring(24, 28);
//        warekiY = PNCommonComponents.dateFmtAD_YYYY(year);
// [DEL] Ver 2.0.0 - END
        // 検索終了年月日【年】
// [UPD] Ver 2.0.0 - START
//        form.setSearchEndYear(warekiY);
        form.setSearchEndYear(PNCommonComponents.dateFmtAD_YYYYMMDD(toDate).split("\\.")[0]);
// [UPD] Ver 2.0.0 - END
        // 検索終了年月日【月】
        form.setSearchEndMonth(nextMonth);
        // 翌月月末日を取得
        int[] iLastDate = PNDateUtils.getLastDateByDate(dtNext);
        // 検索終了年月日【日】
        form.setSearchEndDate(String.valueOf(iLastDate[2]));

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
    public void displayControl(Model model, Se008_01Form form, HttpServletRequest request) {

    }

    /**
     * 文字列を Date オブジェクトにして返します。 Date オブジェクトとして有効でない場合は null を返します。
     *
     * @param strDate 日付を表す文字列
     * @return 日付を表す文字列の Date オブジェクト
     */
    private Date cnvStringToDate(String strDate) {
        Date ret = null;

        try {
            // 日付値を返す
            ret = dtFormat.parse(strDate);
        } catch (ParseException e) {
            // 例外の場合、null返却
            ret = null;
        }

        return ret;
    }
}