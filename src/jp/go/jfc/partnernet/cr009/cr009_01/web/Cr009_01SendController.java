//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_01.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr009.common.Cr009Constants;
import jp.go.jfc.partnernet.cr009.cr009_01.service.Cr009_01DTO;
import jp.go.jfc.partnernet.cr009.cr009_01.service.Cr009_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

import org.apache.commons.lang3.StringUtils;
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
 * このクラスはCr009_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr009_01Form")
@RequestMapping(value = "/Cr009_01Send.form")
public class Cr009_01SendController extends Cr009_01BaseController {

    /** Cr009_01Service */
    @Autowired
    Cr009_01Service cr009_01service;

    /** PNJpCalendarUtils */
    @Autowired
    private PNJpCalendarUtils jpCalendarUtils;

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Cr009_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 共通関数を使用し、報告日を取得する。
        String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        // 入金日
        String dateNyukin = jpCalendarUtils.toSeireki(form.getDrpID_Date_Nyukin_Gengou(),
                form.getTxtID_Date_Nyukin_Year_Input(),
                PNFormatUtils.toZeroPadding(form.getDrpID_Date_Nyukin_Month(), 2),
                PNFormatUtils.toZeroPadding(form.getDrpID_Date_Nyukin_Day(), 2));

        // 送金日
        String dateSokin = jpCalendarUtils.toSeireki(form.getDrpID_Date_Sokin_Gengou(),
                form.getTxtID_Date_Sokin_Year_Input(),
                PNFormatUtils.toZeroPadding(form.getDrpID_Date_Sokin_Month(), 2),
                PNFormatUtils.toZeroPadding(form.getDrpID_Date_Sokin_Day(), 2));

        // 受託処理年月
// [UPD] Ver 3.0.0 - START
//        String dateJtkshori = jpCalendarUtils.toSeireki(form.getDrpID_Date_Jtkshori_Gengou(),
//                form.getTxtID_Date_Jtkshori_Year_Input(),
//                CFWFormatUtils.toZeroPadding(form.getDrpID_Date_Jtkshori_Month(), 2),
//                PNCommonConstants.FIRST_DAY_OF_MONTH);
        String dateJtkshori = PNCommonComponents.dateFmtJC_GyymmToYYYYMMDD(
                PNCommonComponents.concatString(
                        form.getDrpID_Date_Jtkshori_Gengou(),
                        form.getTxtID_Date_Jtkshori_Year_Input(),
                        PNFormatUtils.toZeroPadding(form.getDrpID_Date_Jtkshori_Month(), 2)),
                "");
// [UPD] Ver 3.0.0 - END

        // 留置金フラグ
        boolean isRyuchiKin = false;

        // Formより画面に入力されたデータをDTOに設定（form→inDto)
        Cr009_01DTO inDto = new Cr009_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        // -------------------------------------------------------------------------------------
        // 公庫支店の存在チェック
        // -------------------------------------------------------------------------------------
        cr009_01service.getKoukoShiten(inDto);

        // -------------------------------------------------------------------------------------
        // 店舗の存在チェック
        // -------------------------------------------------------------------------------------
        // ■店舗が入力されている場合、存在チェックを行う。
        if (!StringUtils.isEmpty(form.getTxtID_Code_Tenpo())) {
            cr009_01service.getTenpo(inDto);
        }

        // -------------------------------------------------------------------------------------
        // 入金日エラーチェック
        // -------------------------------------------------------------------------------------
        // ■入金日の元号+年がS64の場合、エラーとする。
        if (Cr009Constants.GENGO_SHOWA.equals(form.getDrpID_Date_Nyukin_Gengou())
                && Cr009Constants.YEAR_64.equals(form.getTxtID_Date_Nyukin_Year_Input())) {

            // メッセージID：PM3290E【入金日(年)】
            throw new PNServiceException(PNCommonMessageConstants.PM3291E, new String[] { "入金日(年)には" }, false);

            // ■入金日(年)(西暦変換)+入金日(月)＋入金日(日)が8桁でない場合、エラーとする。
            // ■入金日(年)(西暦変換)+入金日(月)＋入金日(日)が有効な日付でない場合、エラーとする。
        } else if (!PNCommonComponents.checkDate(dateNyukin)) {

            // メッセージID：PM3140E【入金日】
            throw new PNServiceException(PNCommonMessageConstants.PM3220E, new String[] { "入金日" }, false);

            // ■報告日 < 入金日の場合、エラーとする。
        } else if (0 < dateNyukin.compareTo(dateReport)) {

            // メッセージID：PM3260E【入金日】
            throw new PNServiceException(PNCommonMessageConstants.PM3260E, new String[] { "入金日が報告日" }, false);

            // ■入金日が共通関数の営業日判定にて非営業日であった場合、エラーとする。
        } else if (null == pnCommonDBComponents.chkBusinessDay(dateNyukin)) {

            // メッセージID：PM3330E
            throw new PNServiceException(PNCommonMessageConstants.PM3331E, new String[] { "入金日が" }, false);

        }

        // -------------------------------------------------------------------------------------
        // 送金日エラーチェック
        // -------------------------------------------------------------------------------------
        // ■送金日の元号+年がS64の場合、エラーとする。
        if (Cr009Constants.GENGO_SHOWA.equals(form.getDrpID_Date_Sokin_Gengou())
                && Cr009Constants.YEAR_64.equals(form.getTxtID_Date_Sokin_Year_Input())) {

            // メッセージID：PM3290E【送金年月日(年)】
            throw new PNServiceException(PNCommonMessageConstants.PM3291E, new String[] { "送金年月日（年）には" }, false);

            // ■送金日(年)(西暦変換)+送金日(月)＋送金日(日)が8桁でない場合、エラーとする。
            // ■送金日(年)(西暦変換)+送金日(月)＋送金日(日)が有効な日付でない場合、エラーとする。
        } else if (!PNCommonComponents.checkDate(dateSokin)) {

            // メッセージID：PM3140E【送金年月日】
            throw new PNServiceException(PNCommonMessageConstants.PM3220E, new String[] { "送金年月日" }, false);

            // ■送金日が共通関数の営業日判定にて非営業日であった場合、エラーとする。
        } else if (null == pnCommonDBComponents.chkBusinessDay(dateSokin)) {

            // メッセージID：PM3330E
            throw new PNServiceException(PNCommonMessageConstants.PM3331E, new String[] { "送金年月日が" }, false);

        }

        // -------------------------------------------------------------------------------------
        // 留置期間利息金、代弁遅延損害金エラーチェック
        // -------------------------------------------------------------------------------------
        // ■留置期間利息金が0または未入力 かつ 代弁遅延損害金入力が0または未入力 の場合、エラーとする。
        BigDecimal M_RyuchiKikanRisoku = PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(form
                .getTxtID_M_RyuchiKikanRisoku()));
        BigDecimal M_DaibenChienSongai = PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(form
                .getTxtID_M_DaibenChienSongai()));
        if (BigDecimal.ZERO.equals(M_RyuchiKikanRisoku) && BigDecimal.ZERO.equals(M_DaibenChienSongai)) {
            // メッセージID：PM3120E【留置期間利息，代弁遅延損害金】
            throw new PNServiceException(PNCommonMessageConstants.PM3120E, new String[] { "留置期間利息，代弁遅延損害金" },
                    false);
        }
        // 送金額を設定する。
        BigDecimal M_Sokin = M_RyuchiKikanRisoku.add(M_DaibenChienSongai);
        form.setTxtID_M_Sokin(M_Sokin.toString());

        // -------------------------------------------------------------------------------------
        // 受託者勘定処理年月エラーチェック
        // -------------------------------------------------------------------------------------
        // ■受託者勘定処理年月の元号+年がS64の場合、エラーとする。
        if (Cr009Constants.GENGO_SHOWA.equals(form.getDrpID_Date_Jtkshori_Gengou())
                && Cr009Constants.YEAR_64.equals(form.getTxtID_Date_Jtkshori_Year_Input())) {

            // メッセージID：PM3290E【受託者勘定処理年月(年)】
            throw new PNServiceException(PNCommonMessageConstants.PM3291E, new String[] { "受託者勘定処理年月(年)には" },
                    false);

            // ■受託者勘定処理年月(年)(西暦変換)+受託者勘定処理年月(月)が6桁でない場合、エラーとする。
            // ■受託者勘定処理年月(年)(西暦変換)+受託者勘定処理年月(月)＋"01"が有効な日付でない場合、エラーとする。
        } else if (!PNCommonComponents.checkDate(dateJtkshori)) {

            // メッセージID：PM3220E【受託者勘定処理年月】
            throw new PNServiceException(PNCommonMessageConstants.PM3220E, new String[] { "受託者勘定処理年月" }, false);

            // ■受託者勘定処理年月が報告日の翌月以降の場合、エラーとする。
        } else if (0 < dateJtkshori.substring(0, 6).compareTo(dateReport.substring(0, 6))) {

            // メッセージID：PM3260E【報告日】
            throw new PNServiceException(PNCommonMessageConstants.PM3260E, new String[] { "受託者勘定処理年月が報告日" },
                    false);

            // ■留置金のチェック（受託者勘定処理年月・入金日・送金日が全てチェックが正常だった場合のみチェックを行なう）
        } else {

            // 共通関数を使用し、年度末日を取得する。
            String dateNendoMatsujitu = PNDateUtils.clearDateTimeSeparator(PNCommonComponents
                    .getNendoMatsujitu(dateReport.substring(Cr009Constants.DATE_PATTERN_YYYYMMDD_YEAR_FROM,
                            Cr009Constants.DATE_PATTERN_YYYYMMDD_YEAR_TO), dateReport.substring(
                            Cr009Constants.DATE_PATTERN_YYYYMMDD_MONTH_FROM,
                            Cr009Constants.DATE_PATTERN_YYYYMMDD_MONTH_TO)));

            // 共通関数を使用し、本店決実行整理日付を取得する。
            String dateKessanbi = pnCommonDBComponents.getKessanbi();

            // ■本店決算整理日付が存在しない場合、エラーとする。
            if (StringUtils.isEmpty(dateKessanbi)) {

                // メッセージID：PM3190E【本店決算整理日付】
                throw new PNServiceException(PNCommonMessageConstants.PM3190E, new String[] { "本店決算整理日付" },
                        false);

            }

            // ■送金額が存在する かつ 年度末日 ≧ 入金日 かつ 年度末日 < 送金日の場合
            if (null != form.getTxtID_M_Sokin() && 0 >= dateNyukin.compareTo(dateNendoMatsujitu)
                    && 0 < dateSokin.compareTo(dateNendoMatsujitu)) {
                // 留置金フラグをONにする。
                isRyuchiKin = true;
            }

            // ■年度末日 >= 報告書作成日(システム日付) または 報告書作成日 ≧ 決算整理日付 の場合
            if (0 >= dateReport.compareTo(dateNendoMatsujitu)
                    || 0 >= dateKessanbi.compareTo(dateReport)) {
                // 留置金フラグをOFFにする。
                isRyuchiKin = false;
            }

            // ■留置金フラグがON かつ 受託者勘定処理年月 > 入金日 の場合、エラーとする。
            if (isRyuchiKin && 0 > dateNyukin.compareTo(dateJtkshori)) {

                // メッセージID：PM3140E【受託者勘定処理年月】
                throw new PNServiceException(PNCommonMessageConstants.PM3140E,
                        new String[] { "入金日は受託者勘定処理年月(留置金)以降の日付" }, false);

                // ■留置金フラグがOFF かつ 入金日の年月 > 受託者勘定処理年月 の場合、エラーとする。
            } else if (!isRyuchiKin && 0 > dateJtkshori.substring(0, 6).compareTo(dateNyukin.substring(0, 6))) {

                // メッセージID：PM3260E【受託者勘定処理年月】
                throw new PNServiceException(PNCommonMessageConstants.PM3260E,
                        new String[] { "入金日が受託者勘定処理年月" },
                        false);

                // ■ 月年度末日 > 受託者勘定処理年 かつ 報告日 > 本店決算整理日付の場合、エラーとする。
            } else if (0 > dateJtkshori.compareTo(dateNendoMatsujitu)
                    && 0 > dateKessanbi.compareTo(dateReport)) {

                // メッセージID：PM3810E
                throw new PNServiceException(PNCommonMessageConstants.PM3810E, new String[] {});

            }
            else {
                // 上記のチェックでエラーとならなかった場合

                // 営業日数取得
                int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(dateReport);

                // 業務日付(YYYYMM)
                String nowYear = new StringBuffer(dateReport).substring(0, 4);
                String nowMonth = new StringBuffer(dateReport).substring(4, 6);
                String nowYYYYMM = PNCommonComponents.concatString(nowYear, nowMonth);

                // 受託者勘定処理年月(YYYYMM)
                String jtkshoriYear = new StringBuffer(dateJtkshori).substring(0, 4);
                String jtkshoriMonth = new StringBuffer(dateJtkshori).substring(4, 6);
                String jtkshoriYYYYMM = PNCommonComponents.concatString(jtkshoriYear, jtkshoriMonth);

                if (pnCommonDBComponents.isKessanki()) {
                    // ■決算期（業務日付が4月または10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
                        // ■業務日付が第1～4営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(dateReport, dateNyukin) >= 2) {
                            // ■入金日が業務日付の前々月以前の場合
                            if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, jtkshoriYYYYMM) != 1) {
                                // ■受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                                // メッセージ：PM3110E【受託者勘定処理年月に報告日の前月の年月を】
                                throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に報告日の前月の年月を" }, false);
                            }
                        }
                        else {
                            // ■上記以外の場合
                            // 入金日(YYYYMM)
                            String nyukinYear = new StringBuffer(dateNyukin).substring(0, 4);
                            String nyukinMonth = new StringBuffer(dateNyukin).substring(4, 6);
                            String nyukinYYYYMM = PNCommonComponents.concatString(nyukinYear, nyukinMonth);
                            if (!jtkshoriYYYYMM.equals(nyukinYYYYMM)) {
                                // ■受託者勘定処理年月が入金日の年月と異なる場合エラーとする。
                                // メッセージ：PM3110E【受託者勘定処理年月に入金日の年月を】
                                throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に入金日の年月を" }, false);
                            }
                        }
                    }
                    else {
                        // ■上記以外の場合（業務日付が第5～最終営業日）
                        if (!jtkshoriYYYYMM.equals(nowYYYYMM)) {
                            // ■受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // メッセージ：PM3110E【受託者勘定処理年月に報告日の年月を】
                            throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false);
                        }
                    }
                }
                else {
                    // ■通常期の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // ■業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, jtkshoriYYYYMM) > 1) {
                            // ■受託者勘定処理年月が業務日付の年月または
                            // 　業務日付の前月の年月と異なる場合エラーとする
                            // メッセージ：PM3110E【受託者勘定処理年月に報告日の年月または報告日の前月の年月を】
                            throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月または報告日の前月の年月を" },
                                    false);
                        }
                    }
                    else {
                        // ■上記以外の場合（業務日付が第11～最終営業日）
                        if (!jtkshoriYYYYMM.equals(nowYYYYMM)) {
                            // ■受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // メッセージ：PM3110E【受託者勘定処理年月に報告日の年月を】
                            throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false);
                        }
                    }
                }
            }
        }

        // 遷移パラメータの設定
        // 次画面への引き渡し情報設定
        setRequestNextScreen(request, form);

        // 戻り値（画面遷移情報）に下記を設定する。
        // success("Cr009_02Init")
        return success(Cr009Constants.EVENT_ID_CR009_02INIT);

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
    public void displayControl(Model model, Cr009_01Form form, HttpServletRequest request) {

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form
     */
    private void setRequestNextScreen(HttpServletRequest request, Cr009_01Form form) {

        // 扱店名
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_NAME_ORGANIZATION,
                form.getTxtID_Name_Organization());

        // 公庫支店
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_CODE_SHOKANHONSHITEN,
                form.getTxtID_Code_ShokanHonShiten());

        // 扱店
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());

        // 店舗
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_CODE_TENPO, form.getTxtID_Code_Tenpo());

        // 入金日（元号）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_NYUKIN_GENGOU,
                form.getDrpID_Date_Nyukin_Gengou());

        // 入金日（年）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_NYUKIN_YEAR_INPUT,
                form.getTxtID_Date_Nyukin_Year_Input());

        // 入金日（月）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_NYUKIN_MONTH,
                form.getDrpID_Date_Nyukin_Month());

        // 入金日（日）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_NYUKIN_DAY,
                form.getDrpID_Date_Nyukin_Day());

        // 留置期間利息
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_M_RYUCHIKIKANRISOKU,
                form.getTxtID_M_RyuchiKikanRisoku());

        // 代弁遅延損害金
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_M_DAIBENCHIENSONGAI,
                form.getTxtID_M_DaibenChienSongai());

        // 送金額計
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_M_SOKIN, form.getTxtID_M_Sokin());

        // 受託者勘定処理年月
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_JTKSHORI, form.getTxtID_Date_Jtkshori());

        // 受託者勘定処理年月（元号）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_JTKSHORI_GENGOU,
                form.getDrpID_Date_Jtkshori_Gengou());

        // 受託者勘定処理年月（年）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_JTKSHORI_YEAR_INPUT,
                form.getTxtID_Date_Jtkshori_Year_Input());

        // 受託者勘定処理年月（月）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_JTKSHORI_MONTH,
                form.getDrpID_Date_Jtkshori_Month());

        // 送金年月日（元号）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_SOKIN_GENGOU,
                form.getDrpID_Date_Sokin_Gengou());

        // 送金年月日（年）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_SOKIN_YEAR_INPUT,
                form.getTxtID_Date_Sokin_Year_Input());

        // 送金年月日（月）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_SOKIN_MONTH,
                form.getDrpID_Date_Sokin_Month());

        // 送金年月日（日）
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_DATE_SOKIN_DAY,
                form.getDrpID_Date_Sokin_Day());

        // 送金日番号
        addForwardParameter(request, Cr009Constants.PROPERTY_ID_CODE_SOKIN, form.getTxtID_Code_Sokin());
    }
}