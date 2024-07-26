//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se013_01SearchController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/14 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/02/05 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se013.se013_01.web;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se013.se013_01.common.Se013Constants;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01DTO;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01M1DTO;
import jp.go.jfc.partnernet.se013.se013_01.service.Se013_01Service;

import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse013_01の検索ボタンコントローラークラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se013_01Form")
@RequestMapping(value = "/Se013_01Search.form")
public class Se013_01SearchController extends Se013_01BaseController {

    /** Se013_01Service */
    @Autowired
    Se013_01Service se013_01service;

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

        // 利子助成金受領一覧表帳票一覧を初期化
        PNPagingTable<Se013_01M1DTO> se013_01m1Table = form.getSe013_01M1Table();
        se013_01m1Table.reset();

        // エラーチェック処理
        List<PNMessageInfo> bizErrors = checkInput(form);
        if (0 < bizErrors.size()) {
            // 　　form.利子助成金受領一覧表帳票一覧を初期化
            form.getSe013_01M1Table().reset();
            form.setVisible("Se013_01M1Table", false);
            throw new PNServiceException(bizErrors);
        }

        // 全体件数の取得
        // Formより画面に入力された検索条件をDTOに設定（form→inDto)
        Se013_01DTO inDto = new Se013_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        Se013_01DTO outDto = se013_01service.countResultsData(inDto);

        // ヒット件数のチェック
        int hitCount = outDto.getSearchcount();
        form.setSearchcount(hitCount);
        if (hitCount == PNCommonConstants.RECORD_COUNT_ZERO) {
            // outDto.該当件数　＝　0　の場合、下記エラー処理を行う。
            // 　form.利子助成金受領一覧表帳票一覧を初期化
            form.getSe013_01M1Table().reset();
            form.setVisible("Se013_01M1Table", false);
            // 　メッセージ：PM9060E 該当データがありません。
            // 　処理を終了し、自画面を表示する。
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }

        // 利子助成金受領一覧表帳票一覧のデータ取得
        // 明細の初期表示時にServiceクラスに渡すDTOの設定（利子助成金受領一覧表帳票一覧DTOにinDtoを設定する）
        se013_01m1Table.setInDtoInitPaging(inDto);

        // 利子助成金受領一覧表帳票一覧に表示する先頭ページのデータを取得する。
        outDto = se013_01service.getResultsData(inDto);

        // 取得した利子助成金受領一覧表帳票一覧をformにセットする。
        se013_01m1Table.setRecordList(outDto.getMeisai_list(), hitCount);
        form.setSe013_01M1Table(se013_01m1Table);

        // 検索条件の退避
        // inDto を form の退避エリアにセットする。
        form.setBksearchcondition(inDto);

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

        // 該当件数を判定し下記表示／非表示制御を行う。
        if (form.getSearchcount() > PNCommonConstants.RECORD_COUNT_ZERO) {
            // 利子助成金受領一覧表帳票一覧の件数　＞　０件　の場合
            // 利子助成金受領一覧表帳票一覧
            form.setVisible("Se013_01M1Table", true);
        }
        else {
            // 上記以外（利子助成金受領一覧表帳票一覧の件数　＝　０件）の場合
            // 利子助成金受領一覧表帳票一覧
            form.setVisible("Se013_01M1Table", false);
        }
    }

    /**
     * <pre>
     * 入力チェック
     * </pre>
     *
     * @param form Se013_01のフォームクラス
     * @return bizErrors エラー情報
     */
    private List<PNMessageInfo> checkInput(Se013_01Form form) {

        // エラーリストの初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 業務日付取得
        Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
        String strBizYM = PNCommonComponents.calToStr(calBizDate).substring(0, 6);
        calBizDate.add(Calendar.YEAR, -2);
        String strBizYMTowYearsAgo = PNCommonComponents.calToStr(calBizDate).substring(0, 6);

        // -----------------------検索扱店コード-----------------------
        if (StringUtil.isEmpty(form.getTxtid_srccode_organization()) == false) {
            if ((PNStringChecker.isAllHalfNumber(form.getTxtid_srccode_organization())
            && form.getTxtid_srccode_organization().length() == Se013Constants.CODE_ORGANIZATION_FULL_LENGTH)
                == false) {
                // 検索扱店コード 属性チェック
                // 　入力された値が半角数字4桁以外の場合、エラーとする。
                // 　　メッセージ：扱店コードは半角数字4桁、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "扱店コードは半角数字4桁" }, false));
            }

            // ログインユーザの権限種別を取得
            String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();
            // ログインユーザの扱店コードを取得
            String codeOrganization = PNCommonInfoHolder.getCommonInfo().getCode_Organization();
            // 検索扱店コード権限チェック
            if (PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                    || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)) {
                // 権限種別が計数管理担当者または管理者の場合、チェックなし。
            }
            else if (!form.getTxtid_srccode_organization().equals(codeOrganization)) {
                // その他権限種別の場合、入力された値がログインユーザの扱店コード以外の場合、エラーとする。
                // メッセージ：ログオンユーザの扱店コード、PM3120E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { "ログオンユーザの扱店コード" }, false));
            }

        }

        // -----------------------検索開始年月-----------------------
        // 検索開始年月文字列
        String searchStartYM = null;
        // 属性チェックOKフラグ
        boolean flgSYearAttributeCheck = true;
        boolean flgSMonthAttributeCheck = true;

// [DEL] Ver 3.0.0 - START
//        // 検索開始年属性チェック
//        if (StringUtil.isEmpty(form.getDrpid_searchstartym_year()) == false) {
//            if ((PNStringChecker.isAllHalfNumber(form.getDrpid_searchstartym_year())
//            && form.getDrpid_searchstartym_year().length() <= Se013Constants.SEARCH_YEAR_MAX_LENGTH)
//                == false) {
//                // 　入力された値が半角数字4桁以下でない場合、エラーとする。
//                // 　　メッセージ：検索開始年月（年）は半角数字4桁以下、PM3140E
//                bizErrors.add(new PNMessageInfo(
//                        PNCommonMessageConstants.PM3140E,
//                        new String[] { "検索開始年月（年）は半角数字4桁以下" }, false));
//                // フラグを下す
//                flgSYearAttributeCheck = false;
//            }
//        }
// [DEL] Ver 3.0.0 - END

        // 検索開始月属性チェック
        if (StringUtil.isEmpty(form.getDrpid_searchstartym_month()) == false) {
            if ((PNStringChecker.isAllHalfNumber(form.getDrpid_searchstartym_month())
            && form.getDrpid_searchstartym_month().length() <= Se013Constants.SEARCH_MONTH_MAX_LENGTH)
                == false) {
                // 　入力された値が半角数字2桁以下でない場合、エラーとする。
                // 　　メッセージ：検索開始年月（月）は半角数字2桁以下、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索開始年月（月）は半角数字2桁以下" }, false));
                // フラグを下す
                flgSMonthAttributeCheck = false;
            }
        }

        // 検索開始年月が属性チェックでエラーならば他のチェックを行わない
        if (flgSYearAttributeCheck && flgSMonthAttributeCheck) {

            // 検索開始年月有効性チェック
            if (((StringUtil.isEmpty(form.getDrpid_searchstartym_year()))
                    && (!StringUtil.isEmpty(form.getDrpid_searchstartym_month())))
                    || ((!StringUtil.isEmpty(form.getDrpid_searchstartym_year()))
                    && (StringUtil.isEmpty(form.getDrpid_searchstartym_month())))) {
                // 　検索開始年月の（年）、（月）いずれかが未入力の場合、エラーとする。
                // 　　メッセージ：検索開始年月は有効な年月、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索開始年月は有効な年月" }, false));
            }

            // 検索開始年月を作成
            if ((!StringUtil.isEmpty(form.getDrpid_searchstartym_year()))
                    && (!StringUtil.isEmpty(form.getDrpid_searchstartym_month()))) {

// [UPD] Ver 3.0.0 - START
//               String strSearchStart = PNCommonComponents.concatString(
//                        form.getDrpid_searchstartym_year()
//                        , String.format("%02d", Integer.parseInt(form.getDrpid_searchstartym_month()))
//                        , String.format("%02d", 1));
                String strSearchStart = PNCommonComponents.dateFmtJC_GyymmToYYYYMMDD(
                        PNCommonComponents.concatString(
                                form.getDrpid_searchstartym_year(),
                                PNFormatUtils.toZeroPadding(form.getDrpid_searchstartym_month(), 2)), "");
// [UPD] Ver 3.0.0 - END

                // 検索開始年月有効性チェック
                if (PNCommonComponents.checkDate(strSearchStart)) {

                    searchStartYM = strSearchStart.substring(0, 6);
                }
                else {
                    // 　入力された検索開始年月が有効でない場合、エラーとする。
                    // 　　メッセージ：検索開始年月は有効な年月、PM3140E
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3140E,
                            new String[] { "検索開始年月は有効な年月" }, false));
                }
            }

            // 検索開始年月指定エラー
            if (StringUtil.isEmpty(searchStartYM) == false
                    && (Integer.parseInt(searchStartYM) > Integer.parseInt(strBizYM)
                    || Integer.parseInt(searchStartYM) < Integer.parseInt(strBizYMTowYearsAgo))) {
                // 検索開始年月＞ 業務日付年月　または
                // 検索開始年月＜ 業務日付の２年前の年月の場合、エラーとする。
                // 　　メッセージ：検索開始年月は２年前～業務日付の年月、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索開始年月は２年前～業務日付の年月" }, false));
            }
        }

        // -----------------------検索終了年月-----------------------
        // 検索開始年月文字列
        String searchEndYM = null;
        // 属性チェックOKフラグ
        boolean flgEYearAttributeCheck = true;
        boolean flgEMonthAttributeCheck = true;

// [DEL] Ver 3.0.0 - START
//        // 検索終了年属性チェック
//        if (StringUtil.isEmpty(form.getDrpid_searchendym_year()) == false) {
//            if ((PNStringChecker.isAllHalfNumber(form.getDrpid_searchendym_year())
//            && form.getDrpid_searchendym_year().length() <= Se013Constants.SEARCH_YEAR_MAX_LENGTH)
//                == false) {
//                // 　入力された値が半角数字4桁以下でない場合、エラーとする。
//                // 　　メッセージ：検索終了年月（年）は半角数字4桁以下、PM3140E
//                bizErrors.add(new PNMessageInfo(
//                        PNCommonMessageConstants.PM3140E,
//                        new String[] { "検索終了年月（年）は半角数字4桁以下" }, false));
//                // フラグを下す
//                flgEYearAttributeCheck = false;
//            }
//        }
// [DEL] Ver 3.0.0 - END

        // 検索終了月属性チェック
        if (StringUtil.isEmpty(form.getDrpid_searchendym_month()) == false) {
            if ((PNStringChecker.isAllHalfNumber(form.getDrpid_searchendym_month())
            && form.getDrpid_searchendym_month().length() <= Se013Constants.SEARCH_MONTH_MAX_LENGTH)
                == false) {
                // 　入力された値が半角数字2桁以下でない場合、エラーとする。
                // 　　メッセージ：検索終了年月（月）は半角数字2桁以下、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索終了年月（月）は半角数字2桁以下" }, false));
                // フラグを下す
                flgEMonthAttributeCheck = false;
            }
        }

        // 検索終了年月が属性チェックでエラーならば他のチェックを行わない
        if (flgEYearAttributeCheck && flgEMonthAttributeCheck) {

            // 検索終了年月有効性チェック
            if (((StringUtil.isEmpty(form.getDrpid_searchendym_year()))
                    && (!StringUtil.isEmpty(form.getDrpid_searchendym_month())))
                    || ((!StringUtil.isEmpty(form.getDrpid_searchendym_year()))
                    && (StringUtil.isEmpty(form.getDrpid_searchendym_month())))) {
                // 　検索終了年月の（年）、（月）いずれかが未入力の場合、エラーとする。
                // 　　メッセージ：検索終了年月は有効な年月、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索終了年月は有効な年月" }, false));
            }

            // 検索終了年月を作成
            if ((!StringUtil.isEmpty(form.getDrpid_searchendym_year()))
                    && (!StringUtil.isEmpty(form.getDrpid_searchendym_month()))) {

// [UPD] Ver 3.0.0 - START
//                String strSearchEnd = PNCommonComponents.concatString(
//                        form.getDrpid_searchendym_year()
//                        , String.format("%02d", Integer.parseInt(form.getDrpid_searchendym_month()))
//                        , String.format("%02d", 1));
                String strSearchEnd = PNCommonComponents.dateFmtJC_GyymmToYYYYMMDD(
                        PNCommonComponents.concatString(
                                form.getDrpid_searchendym_year(),
                                PNFormatUtils.toZeroPadding(form.getDrpid_searchendym_month(), 2)), "");
// [UPD] Ver 3.0.0 - END

                // 検索開始年月有効性チェック
                if (PNCommonComponents.checkDate(strSearchEnd)) {

                    searchEndYM = strSearchEnd.substring(0, 6);
                }
                else {
                    // 　入力された検索終了年月が有効でない場合、エラーとする。
                    // 　　メッセージ：検索終了年月は有効な年月、PM3140E
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3140E,
                            new String[] { "検索終了年月は有効な年月" }, false));
                }
            }

            // 検索終了年月指定エラー
            if (StringUtil.isEmpty(searchEndYM) == false
                    && (Integer.parseInt(searchEndYM) > Integer.parseInt(strBizYM)
                    || Integer.parseInt(searchEndYM) < Integer.parseInt(strBizYMTowYearsAgo))) {
                // 検索終了年月＞ 業務日付年月　または
                // 検索終了年月＜ 業務日付の２年前の年月の場合、エラーとする。
                // 　　メッセージ：検索終了年月は２年前～業務日付の年月、PM3140E
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3140E,
                        new String[] { "検索終了年月は２年前～業務日付の年月" }, false));
            }
        }

        // -----------------------検索開始終了年月相関-----------------------
        // 検索年月範囲指定チェック
        if ((StringUtil.isEmpty(searchStartYM) == false)
                && (StringUtil.isEmpty(searchEndYM) == false)
                && (Integer.parseInt(searchStartYM) > Integer.parseInt(searchEndYM))) {
            // 　検索開始年月＞検索終了年月の場合、エラーとする。
            // 　　メッセージ：検索開始年月、検索終了年月は指定可能な期間、PM3140E
            bizErrors.add(new PNMessageInfo(
                    PNCommonMessageConstants.PM3140E,
                    new String[] { "検索開始年月、検索終了年月は指定可能な期間" }, false));
        }

        return bizErrors;

    }
}