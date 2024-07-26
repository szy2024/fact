//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/02/05 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.web;

import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01M1DTO;

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
 * このクラスはse013_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se013_01Form")
@RequestMapping(value = "/Se013_01Init.form")
public class Se013_01InitController extends Se013_01BaseController {

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
    public String executeAction(Model model, Se013_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // フォームを初期化する。
        PNPagingTable<Se013_01M1DTO> se013_01m1Table = form.getSe013_01M1Table();
        se013_01m1Table.reset();

        // ログインユーザの権限種別を判断し、検索扱店コードの設定を行う
        String roleCode = null;
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        // 権限種別　＝　計数管理担当者、管理者の場合
        if (roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA)) {
            // 　nullを設定
            form.setTxtid_srccode_organization(null);
        }
        else {
            // 上記以外（その他権限種別）の場合
            // 　ログインユーザの扱店コードを設定
            form.setTxtid_srccode_organization(commonInfo.getCode_Organization());
        }

        // 未加盟店検索の設定を行う
        form.setChkid_searchmikameiten(null);

        // 業務日付取得
        // 　業務日付取得（共通部品）を呼び出し、業務日付を取得する
        Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));

        // 業務日付の前月取得
        Calendar calBizDatePrevMonth = (Calendar)calBizDate.clone();
        calBizDatePrevMonth.add(Calendar.MONTH, -1);

        // 検索年プルダウンリスト作成
        // 　業務日付の年から2年前までのプルダウンリスト用データを作成
        LinkedHashMap<String, Object> mpY = new LinkedHashMap<String, Object>();
        mpY.put("", "");
// [UPD] Ver 3.0.0 - START
//        for (int i = 2; i >= 0; i--) {
//            String srcYear = String.valueOf(calBizDate.get(Calendar.YEAR) - i);
//            mpY.put(srcYear, PNCommonComponents.dateFmtAD_YYYY(srcYear));
//        }
        // 業務日付の２年前の日付
        Calendar calFromDate = (Calendar)calBizDate.clone();
        calFromDate.add(Calendar.YEAR, -2);

        mpY.putAll(PNCommonComponents.getWarekiList(
                PNCommonComponents.calToStr(calFromDate), PNCommonComponents.calToStr(calBizDate)));
// [UPD] Ver 3.0.0 - END

        // 検索月プルダウンリスト作成
        // 　１～１２までのプルダウンリスト用データを作成
        LinkedHashMap<String, Object> mpM = new LinkedHashMap<String, Object>();
        mpM.put("", "");
        for (int i = 1; i <= 12; i++) {
            mpM.put(Integer.toString(i), i);
        }

        // 検索開始年プルダウンリストの設定
        // 　作成した検索年プルダウンリストを設定
        form.setYm_searchstart_year_pulldown_list(mpY);

        // 検索開始月プルダウンリストの設定
        // 　作成した検索月プルダウンリストを設定
        form.setYm_searchstart_month_pulldown_list(mpM);

        // 検索終了年プルダウンリストの設定
        // 　作成した検索年プルダウンリストを設定
        form.setYm_searchend_year_pulldown_list(mpY);

        // 検索終了月プルダウンリストの設定
        // 　作成した検索月プルダウンリストを設定
        form.setYm_searchend_month_pulldown_list(mpM);

        // 検索開始年月（年）の設定
        // 　業務日付の前月の和暦年を設定
// [UPD] Ver 3.0.0 - START
//        form.setDrpid_searchstartym_year(String.valueOf(calBizDatePrevMonth
//                .get(Calendar.YEAR)));
        form.setDrpid_searchstartym_year(PNCommonComponents.dateFmtAD_YYYYMMDD(
                PNCommonComponents.calToStr(calBizDatePrevMonth)).split("\\.")[0]);
// [UPD] Ver 3.0.0 - END

        // 検索開始年月（月）の設定
        // 　業務日付の前月の月を設定
        form.setDrpid_searchstartym_month(String.valueOf(calBizDatePrevMonth
                .get(Calendar.MONTH) + 1));

        // 検索終了年月（年）の設定
        // 　業務日付の和暦年を設定
// [UPD] Ver 3.0.0 - START
//       form.setDrpid_searchendym_year(String.valueOf(calBizDate
//                .get(Calendar.YEAR)));
        form.setDrpid_searchendym_year(PNCommonComponents.dateFmtAD_YYYYMMDD(
                PNCommonComponents.calToStr(calBizDate)).split("\\.")[0]);
// [UPD] Ver 3.0.0 - END

        // 検索終了年月（月）の設定
        // 　業務日付の月を設定
        form.setDrpid_searchendym_month(String.valueOf(calBizDate
                .get(Calendar.MONTH) + 1));

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
    public void displayControl(Model model, Se013_01Form form,
            HttpServletRequest request) {

        String roleCode = null;
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        // 利子助成金受領一覧表帳票一覧
        form.setVisible("Se013_01M1Table", false);

        // ログインユーザーの権限種別を判断し、下記表示/非表示制御を行う。
        if (roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA)) {
            // 権限種別　＝　計数管理担当者、管理者の場合
            // 入力項目の制御を行わない
        }
        else {
            // 上記以外（その他権限種別）の場合
            // 検索扱店コード
            form.setProtect("txtid_srccode_organization", true);
            // 未加盟店検索
            form.setVisible("chkid_searchmikameiten", false);
        }

    }
}