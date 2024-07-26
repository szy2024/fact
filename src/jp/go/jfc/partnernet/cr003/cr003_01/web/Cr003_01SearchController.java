//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_01.web;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonStringUtils;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.cr003.common.Cr003Constants;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr003_01の検索コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr003_01Form")
@RequestMapping(value = "/Cr003_01Search.form")
public class Cr003_01SearchController extends Cr003_01BaseController {

    @Autowired
    private PNJpCalendarUtils jpCalendarUtils;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** エラーリスト */
    List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

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
    public String executeAction(Model model, Cr003_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 入力内容チェック
        checkInput(form);

        // エラー判定
        if (0 < this.bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(this.bizErrors);
        }

        // 元利金受入・充当報告書作成(入力画面)へ遷移する
        // 　払込期日を遷移パラメータに設定する。
        // 元号＋年度を編集
        StringBuilder sb = new StringBuilder("");
        sb.append(form.getDrpID_Date_Haraikomi_Year());
        sb.append(form.getTxtID_Date_Haraikomi());
        String warekiYear = sb.toString();

        // 元号＋年度＋月＋日をYYYYMMDD形式に編集
        StringBuilder sb2 = new StringBuilder("");
        // 元号＋年度→西暦に編集
        sb2.append(PNCommonComponents.dateFmtJC_Gyy(warekiYear));
        sb2.append((String.format("%02d", Integer.parseInt(form.getDrpID_Date_Haraikomi_Month()))));
        sb2.append((String.format("%02d", Integer.parseInt(form.getDrpID_Date_Haraikomi_Date()))));
        addForwardParameter(request, Cr003Constants.PROPERTY_DATE_HARAIKOMI, sb2.toString());

        // 　return success("Cr003_02Init")
        return success(Cr003Constants.EVENT_ID_CR003_02INIT);
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
    public void displayControl(Model model, Cr003_01Form form, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 入力内容チェック
     * </pre>
     *
     * @param form
     */
    private void checkInput(Cr003_01Form form) {
        // 元号は、M,T,S,Hのいずれかであることをチェックする。
        // 　メッセージID：PM3140E 【払込日】
// [UPD] Ver 2.0.0 - START
//        if (false == checkGengo(form.getDrpID_Date_Haraikomi_Year())) {
        if (false == PNCommonComponents.checkGengoAlphabet(form.getDrpID_Date_Haraikomi_Year(), 0)) {
// [UPD] Ver 2.0.0 - END
            this.addError(PNCommonMessageConstants.PM3140E, new String[]{"払込日"});
            return;
        }

        // 年が入力されていることをチェックする。
        // 　メッセージID：PM3120E 【払込日】
        if (0 == PNCommonComponents.cnvNulltoBlank(form.getTxtID_Date_Haraikomi()).length()) {
            this.addError(PNCommonMessageConstants.PM3120E, new String[]{"払込日"});
            return;
        }

        // 年に数字が入力されていること
        Pattern strPattern = Pattern.compile("^[0-9]*$");
        if (!strPattern.matcher(form.getTxtID_Date_Haraikomi()).find()) {
            this.addError(PNCommonMessageConstants.PM3140E, new String[]{"払込年は数字"});
            return;
        }

        // 元号＋年の連結値が”Ｓ６４”でないことをチェックする。
        // 　メッセージID：PM3290E 【払込日】
        if ("S64".equals(PNCommonStringUtils.concatString(
                PNCommonComponents.cnvNulltoBlank(form.getDrpID_Date_Haraikomi_Year()),
                PNCommonComponents.cnvNulltoBlank(form.getTxtID_Date_Haraikomi())))) {
            this.addError(PNCommonMessageConstants.PM3290E, new String[]{"払込日"});
            return;
        }

        //
        // 入力された元号＋年＋月＋日が有効な日付であることをチェックする。
        // 　メッセージID：PM3140E 【払込日】
        PNCheckDay checkDay = new PNCheckDay(form.getDrpID_Date_Haraikomi_Year(),
                form.getTxtID_Date_Haraikomi(), form.getDrpID_Date_Haraikomi_Month(),
                form.getDrpID_Date_Haraikomi_Date(), this.pnCommonDBComponents, this.bizErrors);
        checkDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E, new String[]{"払込日は有効な日付"});
        if (0 < this.bizErrors.size()) {
            return;
        }

        // 入力された元号＋年＋月＋日　≦　（サーバ日付＋１ヶ月－１日）であることをチェックする。
        // 　メッセージID：PM3140E 【払込日】
        if (0 != getGiyomoDayAgo().length()) {
            if (Integer.parseInt(checkDay.getSeireki()) > Integer.parseInt(this.getGiyomoDayAgo())) {
                this.addError(
                        PNCommonMessageConstants.PM3140E,
                        new String[]{MessageFormat.format("払込日は{0}以前",
                                PNCommonComponents.dateFmtAD_YYYYMMDD(this.getGiyomoDayAgo()))});
                return;
            }
        }
        checkDay = null;
    }

// [DEL] Ver 2.0.0 - START
//    /**
//     *
//     * <pre>
//     * 元号チェック
//     * 元号は、M,T,S,Hのいずれかであることをチェックする。
//     * </pre>
//     *
//     * @param param
//     * @return
//     */
//    private boolean checkGengo(String param) {
//
//        if (null == param) {
//            return false;
//        }
//
//        if ("M".equals(param)) {
//            return true;
//        }
//        if ("T".equals(param)) {
//            return true;
//        }
//        if ("H".equals(param)) {
//            return true;
//        }
//        if ("S".equals(param)) {
//            return true;
//        }
//        return false;
//    }
 // [DEL] Ver 2.0.0 - END

    /**
     *
     * <pre>
     * （サーバ日付＋１ヶ月－１日）を算出
     * </pre>
     *
     * @return
     */
    private String getGiyomoDayAgo() {
        String giyomuDay = this.pnCommonDBComponents.getPNBusinessDay(1);
        // 業務日付が取れない場合は空白を返す。
        if (0 == PNCommonComponents.cnvNulltoBlank(giyomuDay).length()) {
            return "";
        }
        DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();

        int str_yyyy = Integer.parseInt(new StringBuffer(giyomuDay).substring(0, 4));
        int str_MM = Integer.parseInt(new StringBuffer(giyomuDay).substring(4, 6));
        int str_dd = Integer.parseInt(new StringBuffer(giyomuDay).substring(6, 8));
        cal.set(Calendar.YEAR, str_yyyy);
        // 注意：月は、0-11で表されるため-1した値にする
        cal.set(Calendar.MONTH, str_MM - 1);
        cal.set(Calendar.DATE, str_dd);

        // １ヶ月加算
        cal.add(Calendar.MONTH, 1);

        // １日を減算
        cal.add(Calendar.DATE, -1);
        // 計算された日付を返す。
        return dateformat.format(cal.getTime());
    }

    /**
     *
     * <pre>
     * 画面別エラーの追記
     * </pre>
     *
     * @param messageId
     * @param parameter
     */
    private void addError(String messageId, String[] parameter) {
        bizErrors.add(new PNMessageInfo(messageId, parameter, false));
    }

}