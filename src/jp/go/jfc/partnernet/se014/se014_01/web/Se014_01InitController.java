//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se014_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.web;

import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;

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
 * このクラスはse014_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se014_01Form")
@RequestMapping(value = "/Se014_01Init.form")
public class Se014_01InitController extends Se014_01BaseController {

    /** PNCommonDBComponents */
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
    public String executeAction(Model model, Se014_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // フォームを初期化する。
        // 業務日付取得（業務共通部品）より業務日付を取得
        Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));

        // 集計対象年月（年）_プルダウンリスト、集計対象年月日（年）_プルダウンリストの設定
        // 　　業務日付の１年前の年～業務日付の１年後の年のプルダウンリスト用データを作成する
        // 　　プルダウンリスト用データを以下のコントロールに設定する
// [UPD] Ver 3.0.0 - START
//        LinkedHashMap<String, Object> mpY = new LinkedHashMap<String, Object>();
//        for (int i = 1; i >= -1; i--) {
//            String srcYear = String.valueOf(calBizDate.get(Calendar.YEAR) - i);
//            mpY.put(srcYear, PNCommonComponents.dateFmtAD_YYYY(srcYear));
//        }
        // 業務日付の１年前の日付
        Calendar calFromDate = (Calendar)calBizDate.clone();
        calFromDate.add(Calendar.YEAR, -1);

        // 業務日付の１年後の日付
        Calendar calToDate = (Calendar)calBizDate.clone();
        calToDate.add(Calendar.YEAR, 1);

        LinkedHashMap<String, Object> mpY = PNCommonComponents.getWarekiList(
                PNCommonComponents.calToStr(calFromDate), PNCommonComponents.calToStr(calToDate));
// [UPD] Ver 3.0.0 - END
        form.setYg_shukeitaisho_year_pulldown_list(mpY);
        form.setYs_shukeitaisho_year_pulldown_list(mpY);

        // 集計対象年月（月）_プルダウンリスト、集計対象年月日（月）_プルダウンリストの設定
        // 　　1～12のプルダウンリスト用データを作成し、以下のコントロールに設定する
        LinkedHashMap<String, Object> mpM = new LinkedHashMap<String, Object>();
        for (int i = 1; i <= 12; i++) {
            mpM.put(Integer.toString(i), i);
        }
        form.setYg_shukeitaisho_month_pulldown_list(mpM);
        form.setYs_shukeitaisho_month_pulldown_list(mpM);

        // 集計対象年月日（日）_プルダウンリストの設定
        // 　　1～31のプルダウンリスト用データを作成し、以下のコントロールに設定する
        LinkedHashMap<String, Object> mpD = new LinkedHashMap<String, Object>();
        for (int i = 1; i <= 31; i++) {
            mpD.put(Integer.toString(i), i);
        }
        form.setYs_shukeitaisho_date_pulldown_list(mpD);

        // 集計対象年月（年）、集計対象年月日（年）の設定
        // 　　業務日付の年を初期値として設定する
// [UPD] Ver 3.0.0 - START
//        String strBizDateYear = String.valueOf(calBizDate.get(Calendar.YEAR));
        String strBizDateYear = PNCommonComponents.dateFmtAD_YYYYMMDD(
                PNCommonComponents.calToStr(calBizDate)).split("\\.")[0];
// [UPD] Ver 3.0.0 - END
        form.setDrpid_yg_shukeitaishoyear(strBizDateYear);
        form.setDrpid_ys_shukeitaishoyear(strBizDateYear);

        // 集計対象年月（月）、集計対象年月日（月）の設定
        // 　　業務日付の月を初期値として設定する
        String strBizDateMonth = String.valueOf(calBizDate.get(Calendar.MONTH) + 1);
        form.setDrpid_yg_shukeitaishomonth(strBizDateMonth);
        form.setDrpid_ys_shukeitaishomonth(strBizDateMonth);

        // 集計対象年月日（日）の設定
        // 　　業務日付の日を初期値として設定する
        String strBizDateDay = String.valueOf(calBizDate.get(Calendar.DAY_OF_MONTH));
        form.setDrpid_ys_shukeitaishodate(strBizDateDay);

        // 資金交付依頼ラジオボタンの設定
        // 　　空（未選択状態）を初期値として設定する。
        form.setRdoid_shikinkofu(null);

        // 自画面を表示する。
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se014_01Form form,
            HttpServletRequest request) {

    }
}