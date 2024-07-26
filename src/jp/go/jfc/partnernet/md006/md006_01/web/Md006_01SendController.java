//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/10 | 矢嶋　洋              | 新規作成
//.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(.equals(
package jp.go.jfc.partnernet.md006.md006_01.web;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.md006.common.Md006Constants;

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
 * このクラスはmd006_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md006_01Form")
@RequestMapping(value = "/Md006_01Send.form")
public class Md006_01SendController extends Md006_01BaseController {

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
    public String executeAction(Model model, Md006_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 上記まででエラーが発生していない場合（エラー有りフラグ＝なし（false）の場合）、画面受渡パラメタを設定後、次画面に遷移する。
        // ・画面遷移パラメタを設定する。
        // 　- 報告年月日
        addForwardParameter(request, Md006Constants.PROPERTY_DATE_REPORT, form.getLblID_Date_Report());

        // 　- 画面．処理モードが「２：処理完了・修正」もしくは「４：処理完了以外・修正」の場合、以下黒データ入力領域から設定する。
        if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_PROCEND_MOD)
                || form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD)) {
            // 　　・ 画面．顧客名（修正）　→　受渡パラメタ．顧客名（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_NAME_CUSTOMER, form.getTxtID_Name_Customer());
            // 　　・ 画面．扱店名（修正）　→　受渡パラメタ．扱店名（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_NAME_ORGANIZATION,
                    form.getTxtID_Name_Organization());
            // 　　・ 画面．公庫支店（修正）　→　受渡パラメタ．公庫支店（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_KOUKOSHITEN,
                    form.getTxtID_Code_KoukoShiten());
            // 　　・ 画面．扱店（修正）　→　受渡パラメタ．扱店（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_ORGANIZATION,
                    form.getTxtID_Code_Organization());
            // 　　・ 画面．店舗（修正）　→　受渡パラメタ．店舗（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_TENPO, form.getTxtID_Code_Tenpo());
            // 　　・ 画面．年度（修正）　→　受渡パラメタ．年度（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_YEAR, form.getTxtID_Year());
            // 　　・ 画面．方式資金（修正）　→　受渡パラメタ．方式資金（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_HOSHIKISHIKIN,
                    form.getTxtID_Code_HoshikiShikin());
            // 　　・ 画面．番号（修正）　→　受渡パラメタ．番号（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_ID_RINGI, form.getTxtID_ID_Ringi());
            // 　　・ 画面．枝番（修正）　→　受渡パラメタ．枝番（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_ID_RINGIBRANCH,
                    form.getTxtID_ID_RingiBranch());
            // 　　・ 画面．送金日（元号）（修正）　→　受渡パラメタ．送金日（元号）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_NYUKIN_GENGOU,
                    form.getDrpID_Date_Nyukin_Gengou());
            // 　　・ 画面．送金日（年）（修正）　→　受渡パラメタ．送金日（年）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_NYUKIN_YEAR,
                    form.getTxtID_Date_Nyukin_Year());
            // 　　・ 画面．送金日（月）（修正）　→　受渡パラメタ．送金日（月）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_NYUKIN_MONTH,
                    form.getDrpID_Date_Nyukin_Month());
            // 　　・ 画面．送金日（日）（修正）　→　受渡パラメタ．送金日（日）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_NYUKIN_DAY,
                    form.getDrpID_Date_Nyukin_Day());
            // 　　・ 画面．立替金利息(円)（修正）　→　受渡パラメタ．立替金利息(円)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAERISOKU,
                    form.getTxtID_M_TatekaeRisoku());
            // 　　・ 画面．立替金(円)（修正）　→　受渡パラメタ．立替金(円)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAE, form.getTxtID_M_Tatekae());
            // 　　・ 画面．仮受金(一般口)からの充当額(円)（修正）　→　受渡パラメタ．仮受金(一般口)からの充当額
            addForwardParameter(request, Md006Constants.PROPERTY_M_KARIUKEIPPANJUTO,
                    form.getTxtID_M_KariukeIppanJuto());
            // 　　・ 画面．立替金の種類（修正）　→　受渡パラメタ．立替金の種類（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_TATEKAEKINSHURUI,
                    form.getTxtID_Code_TatekaekinShurui());
            // 　　・ 画面．公庫立替日（修正）　→　受渡パラメタ．公庫立替日（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_KOUKOTATEKAE,
                    form.getTxtID_Date_KoukoTatekae());
            // 　　・ 画面．計(円)（修正）　→　受渡パラメタ．計(円)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_M_KEI, form.getTxtID_M_Kei());
            // 　　・ 画面．送金額(円)（修正）　→　受渡パラメタ．送金額(円)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_M_SOKIN, form.getTxtID_M_Sokin());
            // 　　・ 画面．受入後立替金残高(円)（修正）　→　受渡パラメタ．受入後立替金残高(円)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAEZANAFTERUKEIRE,
                    form.getTxtID_M_TatekaeZanAfterUkeire());
            // 　　・ 画面．受託者勘定処理年月（修正）　→　受渡パラメタ．受託者勘定処理年月（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI, form.getTxtID_Date_Jtkshori());
            // 　　・ 画面．送金日（元号）（修正）　→　受渡パラメタ．送金日（元号）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_SOKIN_GENGOU,
                    form.getDrpID_Date_Sokin_Gengou());
            // 　　・ 画面．送金日（年）（修正）　→　受渡パラメタ．送金日（年）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_SOKIN_YEAR,
                    form.getTxtID_Date_Sokin_Year());
            // 　　・ 画面．送金日（月）（修正）　→　受渡パラメタ．送金日（月）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_SOKIN_MONTH,
                    form.getDrpID_Date_Sokin_Month());
            // 　　・ 画面．送金日（日）（修正）　→　受渡パラメタ．送金日（日）（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_SOKIN_DAY,
                    form.getDrpID_Date_Sokin_Day());
            // 　　・ 画面．送金日番号（修正）　→　受渡パラメタ．送金日番号（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_ID_SOKINBI, form.getTxtID_ID_Sokinbi());
            // 　　・ 画面．受託者勘定処理年月(元号)（修正）　→　受渡パラメタ．受託者勘定処理年月(元号)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_GENGOU,
                    form.getDrpID_Date_Jtkshori_Gengou());
            // 　　・ 画面．受託者勘定処理年月(年)（修正）　→　受渡パラメタ．受託者勘定処理年月(年)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_YEAR,
                    form.getTxtID_Date_Jtkshori_Year());
            // 　　・ 画面．受託者勘定処理年月(月)（修正）　→　受渡パラメタ．受託者勘定処理年月(月)（修正）
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_MONTH,
                    form.getDrpID_Date_Jtkshori_Month());

        }

        // 　- 画面．処理モードが「１：処理完了・取消」もしくは「２：処理完了・修正」もしくは「３：処理完了以外・取消」もしくは「５：処理完了以外・更正（赤）取消」の場合、
        if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_PROCEND_DEL)
                || form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_PROCEND_MOD)
                || form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL)
                || form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL)) {
            // 　 以下赤データ入力領域から設定する。　
            // 　　・ 画面．顧客名　→　受渡パラメタ．顧客名
            addForwardParameter(request, Md006Constants.PROPERTY_NAME_CUSTOMER_RED,
                    form.getTxtID_Name_Customer_Red());
            // 　　・ 画面．扱店名　→　受渡パラメタ．扱店名
            addForwardParameter(request, Md006Constants.PROPERTY_NAME_ORGANIZATION_RED,
                    form.getTxtID_Name_Organization_Red());
            // 　　・ 画面．公庫支店　→　受渡パラメタ．公庫支店
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_KOUKOSHITEN_RED,
                    form.getTxtID_Code_KoukoShiten_Red());
            // 　　・ 画面．扱店　→　受渡パラメタ．扱店
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_ORGANIZATION_RED,
                    form.getTxtID_Code_Organization_Red());
            // 　　・ 画面．店舗　→　受渡パラメタ．店舗
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_TENPO_RED,
                    form.getTxtID_Code_Tenpo_Red());
            // 　　・ 画面．顧客名　→　受渡パラメタ．顧客名
            addForwardParameter(request, Md006Constants.PROPERTY_YEAR_RED, form.getTxtID_Year_Red());
            // 　　・ 画面．方式資金　→　受渡パラメタ．方式資金
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_HOSHIKISHIKIN_RED,
                    form.getTxtID_Code_HoshikiShikin_Red());
            // 　　・ 画面．番号　→　受渡パラメタ．番号
            addForwardParameter(request, Md006Constants.PROPERTY_ID_RINGI_RED, form.getTxtID_ID_Ringi_Red());
            // 　　・ 画面．枝番　→　受渡パラメタ．枝番
            addForwardParameter(request, Md006Constants.PROPERTY_ID_RINGIBRANCH_RED,
                    form.getTxtID_ID_RingiBranch_Red());
            // 　　・ 画面．送金日　→　受渡パラメタ．送金日
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_NYUKIN_RED,
                    form.getTxtID_Date_Nyukin_Red());
            // 　　・ 画面．立替金利息(円)　→　受渡パラメタ．立替金利息(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAERISOKU_RED,
                    form.getTxtID_M_TatekaeRisoku_Red());
            // 　　・ 画面．立替金(円)　→　受渡パラメタ．立替金(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAE_RED, form.getTxtID_M_Tatekae_Red());
            // 　　・ 画面．仮受金(一般口)からの充当額(円)　→　受渡パラメタ．仮受金(一般口)からの充当額(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_KARIUKEIPPANJUTO_RED,
                    form.getTxtID_M_KariukeIppanJuto_Red());
            // 　　・ 画面．立替金の種類　→　受渡パラメタ．立替金の種類
            addForwardParameter(request, Md006Constants.PROPERTY_CODE_TATEKAEKINSHURUI_RED,
                    form.getTxtID_Code_TatekaekinShurui_Red());
            // 　　・ 画面．公庫立替日　→　受渡パラメタ．公庫立替日
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_KOUKOTATEKAE_RED,
                    form.getTxtID_Date_KoukoTatekae_Red());
            // 　　・ 画面．計(円)　→　受渡パラメタ．計(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_KEI_RED, form.getTxtID_M_Kei_Red());
            // 　　・ 画面．送金額(円)　→　受渡パラメタ．送金額(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_SOKIN_RED, form.getTxtID_M_Sokin_Red());
            // 　　・ 画面．受入後立替金残高(円)　→　受渡パラメタ．受入後立替金残高(円)
            addForwardParameter(request, Md006Constants.PROPERTY_M_TATEKAEZANAFTERUKEIRE_RED,
                    form.getTxtID_M_TatekaeZanAfterUkeire_Red());
            // 　　・ 画面．受託者勘定処理年月　→　受渡パラメタ．受託者勘定処理年月
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_RED,
                    form.getTxtID_Date_Jtkshori_Red());
            // 　　・ 画面．送金日　→　受渡パラメタ．送金日
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_SOKIN_RED,
                    form.getTxtID_Date_Sokin_Red());
            // 　　・ 画面．送金日番号　→　受渡パラメタ．送金日番号
            addForwardParameter(request, Md006Constants.PROPERTY_ID_SOKINBI_RED,
                    form.getTxtID_ID_Sokinbi_Red());
            // 　　・ 画面．受託者勘定処理年月(元号)　→　受渡パラメタ．受託者勘定処理年月(元号)
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_GENGOU_RED,
                    form.getDrpID_Date_Jtkshori_Gengou_Red());
            // 　　・ 画面．受託者勘定処理年月(年)　→　受渡パラメタ．受託者勘定処理年月(年)
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_YEAR_RED,
                    form.getTxtID_Date_Jtkshori_Year_Red());
            // 　　・ 画面．受託者勘定処理年月(月)　→　受渡パラメタ．受託者勘定処理年月(月)
            addForwardParameter(request, Md006Constants.PROPERTY_DATE_JTKSHORI_MONTH_RED,
                    form.getDrpID_Date_Jtkshori_Month_Red());

        }

        // 　（以下、非表示項目）
        // 　- 報告時分秒
        addForwardParameter(request, Md006Constants.PROPERTY_TIME_REPORT, form.getID_Time_Report());
        // 　- 報告書種別（値）
        addForwardParameter(request, Md006Constants.PROPERTY_DATACODE, form.getID_DataCode());
        // 　- ステータス
        if (null != form.getID_Status()) {
            addForwardParameter(request, Md006Constants.PROPERTY_STATUS, form.getID_Status().toString());
        }
        // 　- 報告書番号
        addForwardParameter(request, Md006Constants.PROPERTY_ID_REPORT, form.getID_ID_Report());
        // 　- 処理モード
        addForwardParameter(request, Md006Constants.PROPERTY_PROCESSMODE, form.getProcessMode());
        // 　- 履歴番号
        addForwardParameter(request, Md006Constants.PROPERTY_ID_HISTORY, form.getID_History());
        // 　- 処理種別
        addForwardParameter(request, Md006Constants.PROPERTY_TYPE_PROCESS, form.getTypeProcess());
        // 　- 債務管理番号
        if (null != form.getID_Credit()) {
            addForwardParameter(request, Md006Constants.PROPERTY_ID_CREDIT, form.getID_Credit().toString());
        }
        // 　- 本支店コード
        addForwardParameter(request, Md006Constants.PROPERTY_CODE_HONSHITEN, form.getKeep_Code_HonShiten());
        // 　- 仮受仮払番号
        addForwardParameter(request, Md006Constants.PROPERTY_ID_KARIBARAI, form.getKeep_ID_Karibarai());
        // 　- 仮受仮払年月日
        addForwardParameter(request, Md006Constants.PROPERTY_DATE_KARIBARAI, form.getDate_Karibarai());
        // 　- 最新更新日時
        if (null != form.getData_LastUpDate()) {
            addForwardParameter(request, Md006Constants.PROPERTY_DATA_LASTUPDATE, form.getData_LastUpDate()
                    .toString());
        }
        // 　　・ 画面．退避受入後立替金残高（修正）　→　受渡パラメタ．退避受入後立替金残高（修正）
        if (null != form.getKeep_M_TatekaeZanAfterUkeire()) {
            addForwardParameter(request, Md006Constants.PROPERTY_KEEP_M_TATEKAEZANAFTERUKEIRE, form
                    .getKeep_M_TatekaeZanAfterUkeire().toString());
        }

        // 　- 仮受仮払精算後残高
        if (null != form.getID_M_KaribaraiZanAfterSeisan()) {
            addForwardParameter(request, Md006Constants.PROPERTY_M_KARIBARAIZANAFTERSEISAN, form
                    .getID_M_KaribaraiZanAfterSeisan().toString());
        }

        // 遷移先情報を設定する。
        return success("Md006_02Init");
        // return MY_VIEW;
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
    public void displayControl(Model model, Md006_01Form form, HttpServletRequest request) {

    }
}