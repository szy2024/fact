//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱忠雄              | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.web;

import java.math.BigDecimal;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.cr005.cr005_04.service.Cr005_04DTO;
import jp.go.jfc.partnernet.cr005.cr005_04.service.Cr005_04Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
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

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはcr005_04の送信コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_04Form")
@RequestMapping(value = "/Cr005_04Send.form")
public class Cr005_04SendController extends Cr005_04BaseController {

    /** Cr005_04Service */
    @Autowired
    Cr005_04Service cr005_04service;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

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
    public String executeAction(Model model, Cr005_04Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 遅延損害金がNULLまたはBLANKの場合、"0"を設定する。
        if (PNCommonConstants.LITERAL_BLANK == PNCommonComponents.cnvNulltoBlank(form
                .getTxtID_M_ChienSongai())) {
            form.setTxtID_M_ChienSongai(Cr005Constants.STR_ZERO);
        }
        // 利息(円)がNULLまたはBLANKの場合、"0"を設定する
        if (PNCommonConstants.LITERAL_BLANK == PNCommonComponents.cnvNulltoBlank(form.getTxtID_M_Risoku())) {
            form.setTxtID_M_Risoku(Cr005Constants.STR_ZERO);
        }
        // 繰上償還手数料(円)がNULLまたはBLANKの場合、"0"を設定する
        if (PNCommonConstants.LITERAL_BLANK == PNCommonComponents.cnvNulltoBlank(form
                .getTxtID_M_KurishoCommission())) {
            form.setTxtID_M_KurishoCommission(Cr005Constants.STR_ZERO);
        }
        // 元金(円)がNULLまたはBLANKの場合、"0"を設定する
        if (PNCommonConstants.LITERAL_BLANK == PNCommonComponents.cnvNulltoBlank(form.getTxtID_M_Gankin())) {
            form.setTxtID_M_Gankin(Cr005Constants.STR_ZERO);
        }
        // 仮受金(一般口)からの充当額(円)が"0"の場合、BLANKを設定する
        if (Cr005Constants.STR_ZERO == form.getTxtID_M_KariukeIppanJuto()) {
            form.setTxtID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
        }

        bizErrors = checkInput(form);

        // ３．項目チェックエラー判定
        if (0 < bizErrors.size()) {
            // 項目チェックエラー有りの場合、業務エラーとし、チェック処理を打ち切る。本処理迄の蓄積されたエラーメッセージ表示する。
            throw new PNServiceException(bizErrors);
        }

        // ４．チェック正常時の処理
        // 代位弁済金払込・充当報告書作成（入力結果画面）へ遷移する
        // 画面遷移パラメタ定義に従い遷移パラメータを設定する。
        setRequestNextScreen(request, form);

        // return success("Cr005_05Init")
        return success(Cr005Constants.EVENT_ID_CR005_05INIT);

        // return MY_VIEW;
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
    public void displayControl(Model model, Cr005_04Form form, HttpServletRequest request) {

    }

    // 次画面への引き渡し情報設定
    private void setRequestNextScreen(HttpServletRequest request, Cr005_04Form form) {
        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        PNCheckDay jutoTaisho = new PNCheckDay(form.getDrpID_Date_JutoTaishoGengou(),
                form.getTxtID_Date_JutoTaishoYear(), form.getDrpID_Date_JutoTaishoMonth(),
                form.getDrpID_Date_JutoTaishoDay(), pnCommonDBComponents, bizErrors);
        String seirekiJutoTaisho = jutoTaisho.getSeireki();

        PNCheckDay daibenkinHaraikomi = new PNCheckDay(form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                form.getTxtID_Date_DaibenkinHaraikomiYear(), form.getDrpID_Date_DaibenkinHaraikomiMonth(),
                form.getDrpID_Date_DaibenkinHaraikomiDay(), pnCommonDBComponents, bizErrors);
        String seirekiDaibenkinHaraikomi = daibenkinHaraikomi.getSeireki();

// [UPD] Ver 3.0.0 - START
//        PNCheckDay jtkshori = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
//                form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "01",
//                pnCommonDBComponents, bizErrors);
        PNCheckDay jtkshori = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
                form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "",
                pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END
        String seirekiJtkshori = jtkshori.getSeireki();

        PNCheckDay sokin = new PNCheckDay(form.getDrpID_Date_SokinGengou(), form.getTxtID_Date_SokinYear(),
                form.getDrpID_Date_SokinMonth(), form.getDrpID_Date_SokinDay(), pnCommonDBComponents,
                bizErrors);
        String seirekiSokin = sokin.getSeireki();

        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_DATE_REPORT, form.getTxtID_Date_Report());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_NAME_CUSTOMER,
                form.getTxtID_Name_Customer());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_NAME_ORGANIZATION,
                form.getTxtID_Name_Organization());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_CODE_SHOKANHONSHITEN,
                form.getTxtID_Code_ShokanHonShiten());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_CODE_TENPO, form.getTxtID_Code_Tenpo());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_YEAR, form.getTxtID_Year());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_KUBUN_HOSHIKISHIKIN,
                form.getTxtID_Code_HoshikiShikin());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_ID_RINGI, form.getTxtID_ID_Ringi());
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_ID_RINGIBRANCH,
                form.getTxtID_ID_RingiBranch());

        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_JUTOTAISHOGENGOU,
                form.getDrpID_Date_JutoTaishoGengou());
        addForwardParameter(request, Cr005Constants.PROPERTY_TXTID_DATE_JUTOTAISHOYEAR,
                form.getTxtID_Date_JutoTaishoYear());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_JUTOTAISHOMONTH,
                form.getDrpID_Date_JutoTaishoMonth());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_JUTOTAISHODAY,
                form.getDrpID_Date_JutoTaishoDay());

        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIGENGOU,
                form.getDrpID_Date_DaibenkinHaraikomiGengou());
        addForwardParameter(request, Cr005Constants.PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMIYEAR,
                form.getTxtID_Date_DaibenkinHaraikomiYear());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIMONTH,
                form.getDrpID_Date_DaibenkinHaraikomiMonth());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIDAY,
                form.getDrpID_Date_DaibenkinHaraikomiDay());

        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_CHIENSONGAI,
                cnvBlankToNulll(form.getTxtID_M_ChienSongai()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_RISOKU,
                cnvBlankToNulll(form.getTxtID_M_Risoku()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_KURISHOCOMMISSION,
                cnvBlankToNulll(form.getTxtID_M_KurishoCommission()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_GANKIN,
                cnvBlankToNulll(form.getTxtID_M_Gankin()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_KARIUKEIPPANJUTO,
                cnvBlankToNulll(form.getTxtID_M_KariukeIppanJuto()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_KEI,
                cnvBlankToNulll(form.getTxtID_M_Kei()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_SOKIN,
                cnvBlankToNulll(form.getTxtID_M_Sokin()));
        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_M_ZANGANAFTERDAIBENJUTO,
                cnvBlankToNulll(form.getTxtID_M_ZanGanAfterDaibenJuto()));

        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_JTKSHORIGENGOU,
                form.getDrpID_Date_JtkshoriGengou());
        addForwardParameter(request, Cr005Constants.PROPERTY_TXTID_DATE_JTKSHORIYEAR,
                form.getTxtID_Date_JtkshoriYear());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_JTKSHORIMONTH,
                form.getDrpID_Date_JtkshoriMonth());

        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_SOKINGENGOU,
                form.getDrpID_Date_SokinGengou());
        addForwardParameter(request, Cr005Constants.PROPERTY_TXTID_DATE_SOKINYEAR,
                form.getTxtID_Date_SokinYear());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_SOKINMONTH,
                form.getDrpID_Date_SokinMonth());
        addForwardParameter(request, Cr005Constants.PROPERTY_DRPID_DATE_SOKINDAY,
                form.getDrpID_Date_SokinDay());

        addForwardParameter(request, Cr005Constants.PROPERTY_LBLID_CODE_SOKIN, form.getTxtID_Code_Sokin());

        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATE_SHOKANKIGEN,
                form.getID_Date_ShokanKigen());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATA_LASTUPDATE, form.getID_Data_LastUpDate());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_CREDIT, form.getID_Credit());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_M_KASHITSUKEZANDAKA,
                form.getID_M_KashitsukeZandaka());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_PREVIOUS_REPORT, form.getID_Previous_Report());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_PREVIOUS_REPORTTYPE,
                form.getID_Previous_ReportType());

        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATE_JUTOTAISHO, seirekiJutoTaisho);
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMI,
                seirekiDaibenkinHaraikomi);
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATE_JTKSHORI, seirekiJtkshori);
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATE_SOKIN, seirekiSokin);

        addForwardParameter(request, Cr005Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU,
                form.getID_Keep_Seikyu_M_SeiKuriRisoku());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_KEEP_M_YAKUJORISOKU,
                form.getID_Keep_M_YakujoRisoku());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_M_SEIKURIRISOKU, form.getID_M_SeiKuriRisoku());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_M_YAKUJORISOKU, form.getID_M_YakujoRisoku());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN,
                form.getID_Keep_Seikyu_M_SeiKuriGankin());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_KEEP_M_YAKUJOGANKIN,
                form.getID_Keep_M_YakujoGankin());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_M_SEIKURIGANKIN, form.getID_M_SeiKuriGankin());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_M_YAKUJOGANKIN, form.getID_M_YakujoGankin());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_USERID, form.getID_UserID());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_ID_DENSO, form.getID_ID_Denso());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_DATACODE, form.getID_DataCode());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_STATUS, form.getID_Status());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_FLAG_TORIKESHIZUMI,
                form.getID_Flag_Torikeshizumi());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_TYPE_PROCESS, form.getID_Type_Process());
        addForwardParameter(request, Cr005Constants.PROPERTY_ID_TIME_REPORT, form.getID_Time_Report());
    }

    private LinkedList<PNMessageInfo> checkInput(Cr005_04Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // ワークフラグの初期化
        // ・項目チェックエラーを無し（True)で初期化する。
        boolean flgKomoku = true;
        // ・充当対象払込期日エラーを無し（True)で初期化する。
        // boolean flgJutoTaisho = true;
        // ・代弁金払込日エラーを無し（True)で初期化する。
        // boolean flgDaibenkinHaraikomi = true;
        // ・受託者勘定処理年月エラーを無し（True)で初期化する。
        // boolean flgJtkshori = true;
        // ・送金日エラーを無し(True)で初期化する
        boolean flgSokin = true;

        // 報告年月日
        form.setTxtID_Date_Report(pnCommonDBComponents.getPNBusinessDay(1));
        // 報告時分秒
        form.setID_Time_Report(PNCommonComponents.getSysDateTime().replaceAll("[:]",
                PNCommonConstants.LITERAL_BLANK));
        // 伝送番号
        form.setID_ID_Denso(PNCommonConstants.LITERAL_BLANK);
        // データコード
        form.setID_DataCode("90257070");
        // ステータス
        form.setID_Status("1");
        // 取消済みフラグ
        form.setID_Flag_Torikeshizumi("0");
        // 処理種別
        form.setID_Type_Process("00");
        // ユーザID
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        form.setID_UserID(commonInfo.getLogonID());

        // DTOの生成
        Cr005_04DTO inDto = new Cr005_04DTO();

        CFWBeanUtils.copyProperties(inDto, form);

        // 必須チェック
        if ("0".equals(form.getTxtID_M_KariukeIppanJuto())
                || PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_KariukeIppanJuto())) {
            // 仮受金(一般口)からの充当額が０又は、未入力の場合、以下を行う
            if (PNCommonConstants.LITERAL_BLANK.equals(form.getDrpID_Date_SokinGengou())
                    || PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_Date_SokinYear())
                    || PNCommonConstants.LITERAL_BLANK.equals(form.getDrpID_Date_SokinMonth())
                    || PNCommonConstants.LITERAL_BLANK.equals(form.getDrpID_Date_SokinDay())) {
                // 送金日の元号、年、月、日のいずれかが未入力の場合エラーとする
                // エラーメッセージ：送金年月日、PM3120E※項目チェックエラー、送金日エラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[] { "送金年月日" },
                        false));
                flgSokin = false;
                flgKomoku = false;
                return bizErrors;
            }
            if (PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_Code_Sokin())) {
                // 送金日番号が未入力の場合、エラーとする
                // エラーメッセージ：送金日番号、PM3120E※項目チェックエラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[] { "送金日番号" },
                        false));
                flgKomoku = false;
                return bizErrors;
            }
        } else {
            // 上記以外(else)の場合、以下を行う
            if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_Date_SokinYear())
                    & PNCommonConstants.LITERAL_BLANK.equals(form.getDrpID_Date_SokinMonth()) & PNCommonConstants.LITERAL_BLANK
                        .equals(form.getDrpID_Date_SokinDay()))) {
                // 送金日の年、月、日のいずれかが入力されている場合エラーとする
                // エラーメッセージ：送金年月日、PM3130E※項目チェックエラー、送金日エラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E, new String[] { "送金年月日" },
                        false));
                flgSokin = false;
                flgKomoku = false;
                return bizErrors;
            }
            if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_Code_Sokin()))) {
                // 送金日番号が入力されている場合、エラーとする
                // エラーメッセージ：送金日番号、PM3130E※項目チェックエラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E, new String[] { "送金日番号" },
                        false));
                flgKomoku = false;
                return bizErrors;
            }
        }

        // 必須チェック
        // 仮受金(一般口)からの充当額が０又は、未入力の場合、以下を行う
        // 送金日エラーが無し(True)の場合、以下を行う
        // 送金日（元号）＋送金日（年）の連結値が"S64"の場合、エラーとする
        // エラーメッセージ：送金年月日の、PM3291E※項目チェックエラー、送金日エラーをFalseとする。
        // 送金日エラー無し時、共通処理の和暦有効日付チェックにて送金日（元号）（年）（月）（日）をチェックする。
        // チェックエラーの場合、エラーとする。
        // エラーメッセージ：送金年月日は有効日付、PM3140E※項目チェックエラー、送金日エラーをFalseとする。
        // 送金日エラー無し時、以下を行う。
        // 共通処理の西暦変換_年月日にて送金日（元号）（年）（月）（日）を西暦変換し、送金日に設定する。
        PNCheckDay sokinday = new PNCheckDay(form.getDrpID_Date_SokinGengou(),
                form.getTxtID_Date_SokinYear(), form.getDrpID_Date_SokinMonth(),
                form.getDrpID_Date_SokinDay(), pnCommonDBComponents, bizErrors);

        if ("0".equals(form.getTxtID_M_KariukeIppanJuto())
                || PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_KariukeIppanJuto())) {
            if (true == flgSokin) {
                String sokinNendo = PNCommonComponents.concatString(new String[] {
                        form.getDrpID_Date_SokinGengou(), form.getTxtID_Date_SokinYear() });
                if ("S64".equals(sokinNendo) || "s64".equals(sokinNendo)) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3291E, new String[] { "送金年月日の" },
                            false));
                    flgKomoku = false;
                    return bizErrors;
                } else {
                    sokinday.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                            new String[] { "送金年月日は有効日付" });
                    if (0 != bizErrors.size()) {
                        flgKomoku = false;
                        return bizErrors;
                    }
                }

            }
        }
        // 受託者勘定処理年月エラーが無し(True)の場合、以下を行う
        // 受託者勘定処理年月（元号）＋受託者勘定処理年月（年）の連結値が"S64"の場合、エラーとする
        // エラーメッセージ：受託者勘定処理年月の、PM3291E※項目チェックエラー、受託者勘定処理年月エラーをFalseとする。
        // 受託者勘定処理年月エラー無し時、共通処理の和暦有効日付チェックにて受託者勘定処理年月（元号）（年）（月）＋"01"をチェックする。
        // チェックエラーの場合、エラーとする。
        // エラーメッセージ：受託者勘定処理年月は有効日付、PM3140E※項目チェックエラーをFalseとする。
        // 受託者勘定処理年月エラー無し時、以下を行う。
        // 共通処理の西暦変換_年月日にて受託者勘定処理年月（元号）（年）（月）を西暦変換し、受託者勘定処理年月に設定する。
        String jtkshoriNendo = PNCommonComponents.concatString(new String[] {
                form.getDrpID_Date_JtkshoriGengou(), form.getTxtID_Date_JtkshoriYear() });
        if ("S64".equals(jtkshoriNendo) || "s64".equals(jtkshoriNendo)) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3291E, new String[] { "受託者勘定処理年月の" },
                    false));
            flgKomoku = false;
            return bizErrors;
        } else {
// [UPD] Ver 3.0.0 - START
//            PNCheckDay jtkshoriDay = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
//                    form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "1",
//                    pnCommonDBComponents, bizErrors);
//            jtkshoriDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                    new String[] { "受託者勘定処理年月は有効日付" });
            PNCheckDay jtkshoriDay = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
                    form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "",
                    pnCommonDBComponents, bizErrors);
            jtkshoriDay.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                    new String[] { "受託者勘定処理年月は有効日付" });
// [UPD] Ver 3.0.0 - END
            if (0 != bizErrors.size()) {
                flgKomoku = false;
                return bizErrors;
            }
        }

        // 充当対象払込期日エラーが無し(True)の場合、以下を行う
        // 充当対象払込期日(元号）＋充当対象払込期日（年）の連結値が"S64"の場合、エラーとする
        // エラーメッセージ：充当対象払込期日の、PM3291E※項目チェックエラー、充当対象払込期日エラーをFalseとする。
        // 充当対象払込期日エラー無し時、共通処理の和暦有効日付チェックにて充当対象払込期日（元号）（年）（月）（日）をチェックする。
        // チェックエラーの場合、エラーとする。
        // エラーメッセージ：充当対象払込期日は有効日付、PM3140E※項目チェックエラーをFalseとする。
        // 充当対象払込期日エラー無し時、以下を行う。
        // 共通処理の西暦変換_年月日にて充当対象払込期日（元号）（年）（月）（日）を西暦変換し、充当対象払込期日に設定する。
        String jutoTaishoNendo = PNCommonComponents.concatString(new String[] {
                form.getDrpID_Date_JutoTaishoGengou(), form.getTxtID_Date_JutoTaishoYear() });
        if ("S64".equals(jutoTaishoNendo) || "s64".equals(jutoTaishoNendo)) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3291E, new String[] { "充当対象払込期日の" },
                    false));
            flgKomoku = false;
            return bizErrors;
        } else {
            PNCheckDay jutoTaishoDay = new PNCheckDay(form.getDrpID_Date_JutoTaishoGengou(),
                    form.getTxtID_Date_JutoTaishoYear(), form.getDrpID_Date_JutoTaishoMonth(),
                    form.getDrpID_Date_JutoTaishoDay(), pnCommonDBComponents, bizErrors);
            jutoTaishoDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                    new String[] { "充当対象払込期日は有効日付" });
            if (0 != bizErrors.size()) {
                flgKomoku = false;
                return bizErrors;
            }
        }

        // 代弁金払込日エラーが無し(True)の場合、以下を行う
        // 代弁金払込日（元号）＋代弁金払込日（年）の連結値が"S64"の場合、エラーとする
        // エラーメッセージ：代弁金払込日の、PM3291E※項目チェックエラー、代弁金払込日エラーをFalseとする。
        // 代弁金払込日エラー無し時、共通処理の和暦有効日付チェックにて代弁金払込日（元号）（年）（月）（日）をチェックする。
        // チェックエラーの場合、エラーとする。
        // エラーメッセージ：代弁金払込日は有効日付、PM3140E※項目チェックエラーをFalseとする。
        // 代弁金払込日エラー無し時、以下を行う。
        // 共通処理の西暦変換_年月日にて代弁金払込日（元号）（年）（月）（日）を西暦変換し、代弁金払込日に設定する。
        String daibenkinHaraikomiNendo = PNCommonComponents.concatString(new String[] {
                form.getDrpID_Date_DaibenkinHaraikomiGengou(), form.getTxtID_Date_DaibenkinHaraikomiYear() });
        if ("S64".equals(daibenkinHaraikomiNendo) || "s64".equals(daibenkinHaraikomiNendo)) {
            bizErrors
                    .add(new PNMessageInfo(PNCommonMessageConstants.PM3291E, new String[] { "代弁金払込日の" }, false));
            flgKomoku = false;
            return bizErrors;
        } else {
            PNCheckDay daibenkinHaraikomiDay = new PNCheckDay(form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                    form.getTxtID_Date_DaibenkinHaraikomiYear(),
                    form.getDrpID_Date_DaibenkinHaraikomiMonth(), form.getDrpID_Date_DaibenkinHaraikomiDay(),
                    pnCommonDBComponents, bizErrors);
            daibenkinHaraikomiDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                    new String[] { "代弁金払込日は有効日付" });
            if (0 != bizErrors.size()) {
                flgKomoku = false;
                return bizErrors;
            }
        }

        // １．入力データのチェックを行う※日付有効性チェック、金額について仮更新データの設定を行う
        // ワークフラグの初期化
        // ・元金エラーを無し(True)で初期化する
        boolean flggankin = true;
        // ・利息エラーを無し(True)で初期化する
        boolean flgrisoku = true;
        // ・代位金エラーを無し(True)で初期化する
        boolean flgDaibenJuto = true;

        // 業務日付を取得
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);

        // １．１．日付と金額の正当性チェックを行う
        // 代弁金払込日が空文字でない場合、以下を行う
        // 代弁金払込日に対し共通処理の非営業日チェックを行う。非営業日の場合、エラーとする
        // エラーメッセージ：代弁金払込日は、PM3331E※項目チェックエラー、代位金エラーをFalseとする。
        String dibenkinHaraikomi = PNCommonComponents.concatString(new String[] {
                form.getDrpID_Date_DaibenkinHaraikomiGengou(), form.getTxtID_Date_DaibenkinHaraikomiYear(),
                form.getDrpID_Date_DaibenkinHaraikomiMonth(), form.getDrpID_Date_DaibenkinHaraikomiDay() });
        if (!(PNCommonConstants.LITERAL_BLANK.equals(dibenkinHaraikomi))) {
            PNCheckDay daibenkinHaraikomiDay = new PNCheckDay(form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                    form.getTxtID_Date_DaibenkinHaraikomiYear(),
                    form.getDrpID_Date_DaibenkinHaraikomiMonth(), form.getDrpID_Date_DaibenkinHaraikomiDay(),
                    pnCommonDBComponents, bizErrors);
            daibenkinHaraikomiDay.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E,
                    new String[] { "代弁金払込日は" });
            if (0 != bizErrors.size()) {
                flgKomoku = false;
                flgDaibenJuto = false;
                return bizErrors;
            }
            // 　　　　　代位金エラーを無しかつ、代弁金払込日＞業務日付の場合、エラーとする
            // 　　　　　　　エラーメッセージ：代弁金払込日が報告日、PM3260E　　　　※項目チェックエラー、代位金エラーをFalseとする。
            String daibenkinHaraikomiDay_str = daibenkinHaraikomiDay.getSeireki();
            if (Integer.parseInt(daibenkinHaraikomiDay_str) > Integer.parseInt(pnBusinessDay)) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E, new String[] { "代弁金払込日が報告日" },
                        false));
                flgKomoku = false;
                flgDaibenJuto = false;
                return bizErrors;

            }
        }
        // 充当対象払込期日が空文字でいない場合、以下を行う
        // 充当対象払込期日＞業務日付の場合、エラーとする
        // エラーメッセージ：充当対象払込期日が報告日、PM3260E※項目チェックエラー、代位金エラーをFalseとする。

        PNCheckDay jutoTaisho = new PNCheckDay(form.getDrpID_Date_JutoTaishoGengou(),
                form.getTxtID_Date_JutoTaishoYear(), form.getDrpID_Date_JutoTaishoMonth(),
                form.getDrpID_Date_JutoTaishoDay(), pnCommonDBComponents, bizErrors);
        String seirekiJutoTaisho = jutoTaisho.getSeireki();
        if (!(PNCommonConstants.LITERAL_BLANK.equals(seirekiJutoTaisho))) {
            if (Integer.parseInt(seirekiJutoTaisho) > Integer.parseInt(pnBusinessDay)) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                        new String[] { "充当対象払込期日が報告日" }, false));
                flgKomoku = false;
                flgDaibenJuto = false;
                return bizErrors;
            }
        }

        // 留置金フラグを留置金でない(False)で初期化
        boolean flgIryu = false;
        if (!(PNCommonConstants.LITERAL_BLANK.equals(jtkshoriNendo))) {
            // 受託者勘定処理年月が空文字でない場合、以下を行う
// [UPD] Ver 3.0.0 - START
//            PNCheckDay jtkshori = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
//                    form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "1",
//                    pnCommonDBComponents, bizErrors);
            PNCheckDay jtkshori = new PNCheckDay(form.getDrpID_Date_JtkshoriGengou(),
                    form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "",
                    pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END
            String seirekijtkshori = jtkshori.getSeireki();
            if (Integer.parseInt(seirekijtkshori.substring(0, 6)) > Integer.parseInt(pnBusinessDay.substring(
                    0, 6))) {
                // 受託者勘定処理年月＞業務日付の年月の場合、エラーとする
                // エラーメッセージ：受託者勘定処理年月が報告日、PM3260E※項目チェックエラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                        new String[] { "受託者勘定処理年月が報告日" }, false));
                flgKomoku = false;
                return bizErrors;
            } else {
                // 上記以外(else)の場合、以下を行う
                // 共通処理の決算整理日付取得にて決算整理日付を取得し、決算整理日付ワークに設定する
                PNCheckDay daibenkinHaraikomiDay = new PNCheckDay(
                        form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                        form.getTxtID_Date_DaibenkinHaraikomiYear(),
                        form.getDrpID_Date_DaibenkinHaraikomiMonth(),
                        form.getDrpID_Date_DaibenkinHaraikomiDay(), pnCommonDBComponents, bizErrors);
                String nendoMatsu = null;
                if (3 >= Integer.parseInt(pnBusinessDay.substring(4, 6))) {
                    nendoMatsu = PNCommonComponents.concatString(
                            String.valueOf(Integer.parseInt(pnBusinessDay.substring(0, 4)) - 1), "0331");
                } else {
                    nendoMatsu = PNCommonComponents.concatString(
                            String.valueOf(Integer.parseInt(pnBusinessDay.substring(0, 4))), "0331");
                }
                String seirekisokin = sokinday.getSeireki();
                String seirekidibenkinHaraikomi = daibenkinHaraikomiDay.getSeireki();

                if (!(PNCommonConstants.LITERAL_BLANK.equals(seirekisokin))) {
                    // 送金日が空文字でない場合、以下を行う
                    if (!("0".equals(form.getTxtID_M_Sokin()))
                            && (Integer.parseInt(nendoMatsu) < Integer.parseInt(seirekisokin))
                            && (Integer.parseInt(nendoMatsu) >= Integer.parseInt(seirekidibenkinHaraikomi))) {
                        // 送金額(円)＜＞０かつ、年度末日ワーク＜送金日かつ、年度末≧代弁金払込日の場合、留置金フラグを留置金(True)に設定する
                        flgIryu = true;
                    }
                }
            }
            String nendoMatsu = null;
            if (3 >= Integer.parseInt(pnBusinessDay.substring(4, 6))) {
                nendoMatsu = PNCommonComponents.concatString(
                        String.valueOf(Integer.parseInt(pnBusinessDay.substring(0, 4)) - 1), "0331");
            } else {
                nendoMatsu = PNCommonComponents.concatString(
                        String.valueOf(Integer.parseInt(pnBusinessDay.substring(0, 4))), "0331");
            }
            // 共通処理の決算整理日付取得にて決算整理日付を取得し、決算整理日付ワークに設定する
            String kessanbi = pnCommonDBComponents.getKessanbi();
            if ((Integer.parseInt(nendoMatsu) >= Integer.parseInt(pnBusinessDay))
                    || (Integer.parseInt(pnBusinessDay) >= Integer.parseInt(kessanbi))) {
                flgIryu = false;
            }
            PNCheckDay daibenkinHaraikomiDay = new PNCheckDay(form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                    form.getTxtID_Date_DaibenkinHaraikomiYear(),
                    form.getDrpID_Date_DaibenkinHaraikomiMonth(), form.getDrpID_Date_DaibenkinHaraikomiDay(),
                    pnCommonDBComponents, bizErrors);
            String seirekidibenkinHaraikomi = daibenkinHaraikomiDay.getSeireki();

            if (true == flgIryu) {
                // 留置金フラグが留置金(True)の場合、以下を行う
                if (Integer.parseInt(seirekijtkshori.substring(0, 6)) > Integer
                        .parseInt(seirekidibenkinHaraikomi.substring(0, 6))) {
                    // 受託者勘定処理年月＞代弁金払込日の年月の場合、エラーとする
                    // エラーメッセージ：代弁金払込日は受託者勘定処理年月（留置金）以降の日付、PM3140E
                    // ※項目チェックエラーをFalseとする。
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { "代弁金払込日は受託者勘定処理年月（留置金）以降の日付" }, false));
                    flgKomoku = false;
                    return bizErrors;
                }
            } else {
                if (Integer.parseInt(seirekijtkshori.substring(0, 6)) < Integer
                        .parseInt(seirekidibenkinHaraikomi.substring(0, 6))) {
                    // 受託者勘定処理年月＜代弁金払込日の年月の場合、エラーとする
                    // エラーメッセージ：代弁金払込日が受託者勘定処理年月、PM3260E
                    // ※項目チェックエラーをFalseとする。
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                            new String[] { "代弁金払込日が受託者勘定処理年月" }, false));
                    flgKomoku = false;
                    return bizErrors;
                }
            }
            if (Integer.parseInt(seirekijtkshori.substring(0, 6)) < (Integer.parseInt(nendoMatsu.substring(0,
                    6))) && (Integer.parseInt(pnBusinessDay)) > Integer.parseInt(kessanbi)) {
                // 受託者勘定処理年月＜年度末日の年月かつ、業務日付＞決算整理日付の場合、エラーとする
                // エラーメッセージ：PM3810E※項目チェックエラーをFalseとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3810E, new String[] { null }, false));
                flgKomoku = false;
                return bizErrors;
            }

            // 業務日付（YYYYMM形式）
            String strGyomuYYYYMM = form.getTxtID_Date_Report().substring(
                    PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);

            // 受託者勘定処理年月（YYYYMM形式）
            // 受託者勘定処理年月
// [UPD] Ver 3.0.0 - START
//            String strJutaku = jpCalendarUtils.toSeireki(form.getDrpID_Date_JtkshoriGengou(),
//                    form.getTxtID_Date_JtkshoriYear(), form.getDrpID_Date_JtkshoriMonth(), "01");
//            String strJutakuDate = strJutaku.substring(
//                    PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);
            String strJutakuDate =seirekijtkshori.substring(
                    PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);
// [UPD] Ver 3.0.0 - END

            // 営業日取得
            int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(form.getTxtID_Date_Report());

            if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.
                    cnvStrtoBig(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto())))) {
                // 仮受金(一般口)からの充当額(円)＝０又は未入力の場合
                if (pnCommonDBComponents.isKessanki()) {
                    // 決算期（業務日付が4月、10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
                        // 業務日付が第1～4営業日の場合

                        // 代弁金払込日（YYYYMM形式）
                        String strDaibenkinHaraikomi =
                                jpCalendarUtils.toSeireki(form.getDrpID_Date_DaibenkinHaraikomiGengou(),
                                        form.getTxtID_Date_DaibenkinHaraikomiYear(),
                                        form.getDrpID_Date_DaibenkinHaraikomiMonth(),
                                        form.getDrpID_Date_DaibenkinHaraikomiDay());
                        String strDaibenkinHaraikomiYYYYMM = strDaibenkinHaraikomi.substring(
                                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);

                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strDaibenkinHaraikomiYYYYMM) >= 2) {
                            // 代弁金払込日が業務日付の前々月以前の場合
                            if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) != 1) {
                                // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                                // エラーメッセージ：受託者勘定処理年月に報告日の前月の年月をPM3110E
                                // ※項目チェックエラーをFalseとする。
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に報告日の前月の年月を" }, false));
                                flgKomoku = false;
                                return bizErrors;
                            }
                        }
                        else {
                            // 上記以外の場合
                            if (!strJutakuDate.equals(strDaibenkinHaraikomiYYYYMM)) {
                                // 受託者勘定処理年月が代弁金払込日の年月と異なる場合エラーとする。
                                // エラーメッセージ：受託者勘定処理年月に代弁金払込日の年月をPM3110E
                                // ※項目チェックエラーをFalseとする。
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に代弁金払込日の年月を" }, false));
                                flgKomoku = false;
                                return bizErrors;
                            }
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第5～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                }
                else {
                    // 通常期（決算期以外の月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // 業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) > 1) {
                            // 受託者勘定処理年月が業務日付の年月または業務日付の前月の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月または報告日の前月の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月または報告日の前月の年月を" },
                                    false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第11～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                }
            }
            else {
                // 仮受金(一般口)からの充当額(円)＜＞０の場合
                if (pnCommonDBComponents.isKessanki()) {
                    // 決算期（業務日付が4月、10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
                        // 業務日付が第1～4営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) != 1) {
                            // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の前月の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の前月の年月を" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第5～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                }
                else {
                    // 通常期（決算期以外の月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // 業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) > 1) {
                            // 受託者勘定処理年月が業務日付の年月または業務日付の前月の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月または報告日の前月の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月または報告日の前月の年月を" },
                                    false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第11～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーメッセージ：受託者勘定処理年月に報告日の年月をPM3110E
                            // ※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                }
            }

            // 送金日＜＞空文字の場合、以下を行う
            // 送金日に対し共通処理の非営業日チェックを行う。非営業日の場合、エラーとする
            // エラーメッセージ：送金年月日は、PM3331E※項目チェックエラー、代位金エラーをFalseとする。
            if (!(PNCommonConstants.LITERAL_BLANK.equals(sokinday.getSeireki()))) {
                sokinday.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[] { "送金年月日は" });
                if (0 != bizErrors.size()) {
                    flgKomoku = false;
                    flgDaibenJuto = false;
                    return bizErrors;
                }
            }
            if (true == flgKomoku) {
                // 項目エラー無しの場合、以下を行う
                if (PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_Risoku())) {
                    // 利息(円)＝空文字の場合、以下を行う
                    // 利息エラーをFalseとする
                    flgrisoku = false;
                }
                if (PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_Gankin())) {
                    // 元金(円)＝空文字の場合、以下を行う
                    // 元金エラーをFalseとする
                    flggankin = false;
                }
                if (true == flggankin) {
                    // 元金エラー無しの場合、以下を行う
                    if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_Gankin()))) {
                        BigDecimal bdGankin = new BigDecimal(form.getTxtID_M_Gankin());
                        BigDecimal bdKashitsukeZandaka = BigDecimal.ZERO;
                        if (0 < bdGankin.compareTo(BigDecimal.ZERO)) {
                            // 元金(円)＜＞空文字かつ、元金＞０の場合、以下を行う
                            if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getID_M_KashitsukeZandaka()))) {
                                bdKashitsukeZandaka = new BigDecimal(form.getID_M_KashitsukeZandaka());
                            }
                        }
                        if (0 < bdGankin.compareTo(bdKashitsukeZandaka)) {
                            // 貸付金残高＜元金(円)の場合、エラーとする。※貸付金残高がＮＵＬＬ／空文字の場合、０と扱う
                            // エラーメッセージ：元金が貸付金残高、PM3180E※項目チェックエラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                    new String[] { "元金が貸付金残高" }, false));
                            flgKomoku = false;
                            return bizErrors;
                        }
                    }
                }
                if ((true == flggankin) && (true == flgrisoku)) {
                    // 元金エラー無しかつ、利息エラー無しの場合、以下を行う
                    BigDecimal bdRisoku = new BigDecimal(form.getTxtID_M_Risoku());
                    BigDecimal bdGankin = new BigDecimal(form.getTxtID_M_Gankin());
                    if (0 < bdRisoku.compareTo(BigDecimal.ZERO) || 0 < bdGankin.compareTo(BigDecimal.ZERO)) {
                        // 利息（円）＞０又は、元金（円）＞０の場合、以下を行う
                        // サービスを実行し請求データ取得を行う。
                        // ・請求検索日付：充当対象払込期日
                        // Cr005_04Service.getSeikyuData // DTOの生成
                        inDto.setID_Date_SearchSeikyu(seirekiJutoTaisho);
                        Cr005_04DTO outDto = cr005_04service.getSeikyuData(inDto);
                        if (0 == outDto.getID_SeikyuCount()) {
                            // 請求データ取得件数が０の場合、エラーとする
                            // エラーメッセージ：PM3310E※項目チェックエラー、利息エラー、元金エラーをFalseとする。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3310E,
                                    new String[] { null }, false));
                            flgKomoku = false;
                            flgrisoku = false;
                            flggankin = false;
                            return bizErrors;
                        } else {
                            // 上記以外(else)の場合、以下を行う
                            // 請求検索結果・約定元金を数値に変換し約定元金ワークに設定※空文字は０とする
                            String strYakujoGankinSeikyuAns = PNCommonComponents.cnvNulltoZero(outDto
                                    .getID_M_YakujoGankin_SeikyuAns());
                            BigDecimal bdYakujoGankin_SeikyuAns = new BigDecimal(strYakujoGankinSeikyuAns);
                            // 請求検索結果・約定利息を数値に変換し約定利息ワークに設定※空文字は０とする
                            String strYakujoRisokuSeikyuAns = PNCommonComponents.cnvNulltoZero(outDto
                                    .getID_M_YakujoRisoku_SeikyuAns());
                            BigDecimal bdYakujoRisoku_SeikyuAns = new BigDecimal(strYakujoRisokuSeikyuAns);
                            // 請求検索結果・請求繰上償還元金を数値に変換し請求繰上償還元金ワークに設定※空文字は０とする
                            String strSeiKuriGankinSeikyuAns = PNCommonComponents.cnvNulltoZero(outDto
                                    .getID_M_SeiKuriGankin_SeikyuAns());
                            BigDecimal bdSeiKuriGankin_SeikyuAns = new BigDecimal(strSeiKuriGankinSeikyuAns);
                            // 請求検索結果・請求繰上償還利息を数値に変換し請求繰上償還利息ワークに設定※空文字は０とする
                            String strSeiKuriRisokuSeikyuAns = PNCommonComponents.cnvNulltoZero(outDto
                                    .getID_M_SeiKuriRisoku_SeikyuAns());
                            BigDecimal bdSeiKuriRisoku_SeikyuAns = new BigDecimal(strSeiKuriRisokuSeikyuAns);
                            if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_Risoku()))) {
                                // 利息（円）＜＞空文字の場合、以下を行う
                                if (0 < bdSeiKuriRisoku_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                    // 請求繰上償還利息ワーク＞０の場合、以下を行う
                                    if (0 < bdRisoku.compareTo(bdSeiKuriRisoku_SeikyuAns)) {
                                        // 利息（円）＞請求繰上償還利息ワークの場合、以下を行う
                                        BigDecimal bdSabun = bdRisoku.subtract(bdSeiKuriRisoku_SeikyuAns);
                                        if (0 < bdSabun.compareTo(bdYakujoRisoku_SeikyuAns)) {
                                            // 利息（円）－請求繰上償還利息ワーク＞約定利息ワークの場合、エラーとする
                                            // エラーメッセージ：利息が請求額、PM3180E※項目チェックエラー、利息エラーをFalseとする。
                                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                                    new String[] { "利息が請求額" }, false));
                                            flgKomoku = false;
                                            flgrisoku = false;
                                            return bizErrors;
                                        } else {
                                            // 上記以外(else)の場合、以下を行う
                                            // 退避請求繰上償還利息に、請求検索結果・請求繰上償還利息を設定
                                            form.setID_Keep_Seikyu_M_SeiKuriRisoku(strSeiKuriRisokuSeikyuAns);
                                            // 退避約定利息に、請求検索結果・約定利息を設定
                                            form.setID_Keep_M_YakujoRisoku(strYakujoRisokuSeikyuAns);
                                            // 請求繰上償還利息・仮更新値に、０を設定
                                            form.setID_M_SeiKuriRisoku("0");
                                            // 約定利息・仮更新値に、約定利息ワーク－（利息（円）－請求繰上償還利息ワーク）を設定
                                            BigDecimal bdKariRisoku = bdYakujoRisoku_SeikyuAns
                                                    .subtract(bdSabun);
                                            form.setID_M_YakujoRisoku(bdKariRisoku.toString());
                                        }
                                    } else {
                                        // 上記以外(else)の場合、以下を行う
                                        // 退避請求繰上償還利息に、請求検索結果・請求繰上償還利息を設定
                                        form.setID_Keep_Seikyu_M_SeiKuriRisoku(strSeiKuriRisokuSeikyuAns);
                                        // 退避約定利息に、請求検索結果・約定利息を設定
                                        form.setID_Keep_M_YakujoRisoku(strYakujoRisokuSeikyuAns);
                                        // 請求繰上償還利息・仮更新値に、請求繰上償還利息ワーク－利息（円）を設定
                                        BigDecimal bdKariRisoku = bdSeiKuriRisoku_SeikyuAns
                                                .subtract(bdRisoku);
                                        form.setID_M_SeiKuriRisoku(bdKariRisoku.toString());
                                        // 約定利息・仮更新値に、約定利息ワークを設定
                                        form.setID_M_YakujoRisoku(strYakujoRisokuSeikyuAns);

                                    }
                                } else {
                                    // 上記以外(else)の場合、以下を行う
                                    if (0 < bdRisoku.compareTo(bdYakujoRisoku_SeikyuAns)) {
                                        // 利息（円）＞約定利息ワークの場合、エラーとする
                                        // エラーメッセージ：利息が請求額、PM3180E※項目チェックエラー、利息エラーをFalseとする。
                                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                                new String[] { "利息が請求額" }, false));
                                        flgKomoku = false;
                                        flgrisoku = false;
                                        return bizErrors;
                                    } else {
                                        // 上記以外(else)の場合、以下を行う
                                        // 退避請求繰上償還利息に、０を設定
                                        form.setID_Keep_Seikyu_M_SeiKuriRisoku("0");
                                        // 退避約定利息に、請求検索結果・約定利息を設定
                                        form.setID_Keep_M_YakujoRisoku(strYakujoRisokuSeikyuAns);
                                        // 請求繰上償還利息・仮更新値に、０を設定
                                        form.setID_M_SeiKuriRisoku("0");
                                        // 約定利息・仮更新値に、約定利息ワーク－利息（円）を設定
                                        form.setID_M_YakujoRisoku(bdYakujoRisoku_SeikyuAns.subtract(bdRisoku)
                                                .toString());

                                    }
                                }
                            } else {
                                // 上記以外(else)の場合、以下を行う
                                if (0 < bdSeiKuriRisoku_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                    // 請求利息ワーク＞０の場合、退避請求繰上償還利息に、請求検索結果・請求繰上償還利息を設定
                                    form.setID_Keep_Seikyu_M_SeiKuriRisoku(strSeiKuriRisokuSeikyuAns);
                                }

                                if (0 == bdSeiKuriRisoku_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                    // 請求利息ワーク＝０の場合、退避請求繰上償還利息に、０を設定
                                    form.setID_Keep_Seikyu_M_SeiKuriRisoku("0");
                                }
                                // 退避約定利息に、請求検索結果・約定利息を退避
                                form.setID_Keep_M_YakujoRisoku(strYakujoRisokuSeikyuAns);
                                // 請求繰上償還利息・仮更新値に、請求繰上償還利息ワークを設定
                                form.setID_M_SeiKuriRisoku(strSeiKuriRisokuSeikyuAns);
                                // 約定利息・仮更新値に，約定利息ワークを設定
                                form.setID_M_YakujoRisoku(strYakujoRisokuSeikyuAns);
                            }

                            if (!(PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_Gankin()))) {
                                if (0 < bdGankin.compareTo(BigDecimal.ZERO)) {
                                    // 元金（円）＜＞空文字かつ、元金（円）＞０の場合、以下を行う
                                    if (0 < bdSeiKuriGankin_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                        // 請求繰上償還元金ワーク＞０の場合、以下を行う
                                        if (0 < bdGankin.compareTo(bdSeiKuriGankin_SeikyuAns)) {
                                            // 元金（円）＞請求繰上償還元金ワークの場合、以下を行う
                                            BigDecimal bdSabunganki = bdGankin
                                                    .subtract(bdSeiKuriGankin_SeikyuAns);
                                            if (0 < bdSabunganki.compareTo(bdYakujoGankin_SeikyuAns)) {
                                                // 元金（円）－請求繰上償還元金ワーク＞約定元金ワークの場合、エラーとする。
                                                // エラーメッセージ：元金が請求額、PM3180E※項目チェックエラー、元金エラーをFalseとする。
                                                bizErrors.add(new PNMessageInfo(
                                                        PNCommonMessageConstants.PM3180E,
                                                        new String[] { "元金が請求額" }, false));
                                                flgKomoku = false;
                                                flggankin = false;
                                                return bizErrors;
                                            } else {
                                                // 上記以外(else)の場合、以下を行う
                                                // 退避請求繰上償還元金に、請求検索結果・請求繰上償還元金を退避
                                                form.setID_Keep_Seikyu_M_SeiKuriGankin(strSeiKuriGankinSeikyuAns);
                                                // 退避約定元金に、請求検索結果・約定元金を退避
                                                form.setID_Keep_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                                // 請求繰上償還元金・仮更新値に、０を設定
                                                form.setID_M_SeiKuriGankin("0");
                                                // 約定元金・仮更新値に、約定元金ワーク－（元金（円）－請求繰上償還元金ワーク）を設定
                                                BigDecimal bdSabunKarigankin = bdYakujoGankin_SeikyuAns
                                                        .subtract(bdSabunganki);
                                                form.setID_M_YakujoGankin(bdSabunKarigankin.toString());
                                            }
                                        } else {
                                            // 上記以外(else)の場合、以下を行う
                                            // 退避請求繰上償還元金に、請求検索結果・請求繰上償還元金を設定
                                            form.setID_Keep_Seikyu_M_SeiKuriGankin(strSeiKuriGankinSeikyuAns);
                                            // 退避約定元金に、請求検索結果・約定元金を設定
                                            form.setID_Keep_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                            // 請求繰上償還元金・仮更新値に、請求繰上償還元金ワーク－元金（円）を設定
                                            BigDecimal bdSabunKarigankin = bdSeiKuriGankin_SeikyuAns
                                                    .subtract(bdGankin);
                                            form.setID_M_SeiKuriGankin(bdSabunKarigankin.toString());
                                            // 約定元金・仮更新値に、約定元金ワークを設定
                                            form.setID_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                        }
                                    } else {
                                        // 上記以外(else)の場合、以下を行う
                                        if (0 < bdGankin.compareTo(bdYakujoGankin_SeikyuAns)) {
                                            // 元金（円）＞約定元金ワークの場合、エラーとする
                                            // エラーメッセージ：元金が請求額、PM3180E※項目チェックエラー、元金エラーをFalseとする。
                                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                                    new String[] { "元金が請求額" }, false));
                                            flgKomoku = false;
                                            flggankin = false;
                                            return bizErrors;
                                        } else {
                                            // 上記以外(else)の場合、以下を行う
                                            // 退避請求繰上償還元金に、０を設定
                                            form.setID_Keep_Seikyu_M_SeiKuriGankin("0");
                                            // 退避約定元金に、請求検索結果・約定元金を設定
                                            form.setID_Keep_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                            // 請求繰上償還元金・仮更新値に、０を設定
                                            form.setID_M_SeiKuriGankin("0");
                                            // 約定元金・仮更新値に、約定元金ワーク－元金（円）を設定
                                            BigDecimal bdSabunKarigankin = bdYakujoGankin_SeikyuAns
                                                    .subtract(bdGankin);
                                            form.setID_M_YakujoGankin(bdSabunKarigankin.toString());
                                        }
                                    }
                                } else {
                                    // 上記以外(else)の場合、以下を行う
                                    if (0 < bdSeiKuriGankin_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                        // 請求元金ワーク＞０の場合、退避請求繰上償還元金に、請求検索結果・請求繰上償還元金を設定
                                        form.setID_Keep_Seikyu_M_SeiKuriGankin(strSeiKuriGankinSeikyuAns);
                                    }
                                    if (0 == bdSeiKuriGankin_SeikyuAns.compareTo(BigDecimal.ZERO)) {
                                        // 請求元金ワーク＝０の場合、退避請求繰上償還元金に、０を設定
                                        form.setID_Keep_Seikyu_M_SeiKuriGankin("0");
                                    }
                                    // 退避約定元金に、請求検索結果・約定元金を退避
                                    form.setID_Keep_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                    // 請求繰上償還元金・仮更新値に、請求繰上償還元金ワークを設定
                                    form.setID_M_SeiKuriGankin(strSeiKuriGankinSeikyuAns);
                                    // 約定元金・仮更新値に，約定元金ワークを設定
                                    form.setID_M_YakujoGankin(strYakujoGankinSeikyuAns);
                                }
                            }
                        }
                    }
                }
            }
        }

        // ２．金額の整合性チェックを行う※入力された金額合計チェック、更新される残高の計算を行う
        if (true == flgKomoku) {
            // 項目エラー無しの場合、以下を行う
            // Stringデータのワークエリア展開対象データが空文字の場合、０を設定する
            // ・遅延損害金ワークに遅延損害金(円)を設定
            BigDecimal bChienSongai = new BigDecimal(PNCommonComponents.cnvNulltoZero(form
                    .getTxtID_M_ChienSongai().replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            // ・利息ワークに利息(円)を設定
            BigDecimal bRisoku = new BigDecimal(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_Risoku()
                    .replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            // ・繰上償還手数料ワークに繰上償還手数料(円)を設定
            BigDecimal bKurishoCommission = new BigDecimal(PNCommonComponents.cnvNulltoZero(form
                    .getTxtID_M_KurishoCommission().replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            // ・元金ワークに元金（円）を設定
            BigDecimal bGankin = new BigDecimal(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_Gankin()
                    .replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            // ・仮受金(一般口)からの充当額ワークに仮受金(一般口)からの充当額(円)を設定
            BigDecimal bKariukeIppanJuto = new BigDecimal(PNCommonComponents.cnvNulltoZero(form
                    .getTxtID_M_KariukeIppanJuto().replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            // 合計ワーク＝利息ワーク＋元金ワーク＋遅延損害金ワーク＋繰上償還手数料ワーク
            // 合計ワーク＝０の場合、エラーとする
            // エラーメッセージ：元金，利息，遅延損害金，繰上償還手数料のいずれかを０以上、PM3140E※項目チェックエラーをFalseとする。
            BigDecimal bGokei = PNCommonUtils.sum_BigDecimal(bRisoku, bGankin, bChienSongai,
                    bKurishoCommission);
            if (0 == BigDecimal.ZERO.compareTo(bGokei)) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                        new String[] { "元金，利息，遅延損害金，繰上償還手数料のいずれか" }, false));
                flgKomoku = false;
                return bizErrors;
            }

            // 仮受金(一般口)からの充当額(円)＝空文字又は、仮受金(一般口)からの充当額ワーク＝０の場合、以下を行う
            if (PNCommonConstants.LITERAL_BLANK.equals(form.getTxtID_M_KariukeIppanJuto())
                    || 0 == BigDecimal.ZERO.compareTo(bKariukeIppanJuto)) {
                // 送金額（円）＝合計ワーク
                form.setTxtID_M_Sokin(bGokei.toString());

            } else {
                // 上記以外(else)の場合、以下を行う
                if (0 != BigDecimal.ZERO.compareTo(bGokei.subtract(bKariukeIppanJuto))) {
                    // 合計ワーク－仮受金(一般口)からの充当額ワーク＜＞０の場合、エラーとする
                    // エラーメッセージ：PM3470E※項目チェックエラーをFalseとする。
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3470E, new String[] { null },
                            false));
                    flgKomoku = false;
                    // 送金額（円）＝空文字設定
                    form.setTxtID_M_Sokin("0");
                    return bizErrors;
                }
            }
            if (true == flgKomoku)
                // 項目エラー無しの場合、以下を行う
                // 計（円）＝合計ワーク
                form.setTxtID_M_Kei(bGokei.toString());
            // 代弁金充当後残元金(円)＝貸付金残高－元金（円）（計算値が空文字の場合、０と扱う）
            BigDecimal bKashitsukeZandaka = new BigDecimal(PNCommonComponents.cnvNulltoZero(form
                    .getID_M_KashitsukeZandaka().replaceAll("[,]", PNCommonConstants.LITERAL_BLANK)));
            form.setTxtID_M_ZanGanAfterDaibenJuto(bKashitsukeZandaka.subtract(bGankin).toString());
        }

        return bizErrors;
    }

    /**
     *
     * <pre>
     * 引数の値が空白の場合、null値を返却し、空白以外の場合は受け取った値をそのまま返却
     * </pre>
     *
     * @param strVal 判定する値
     * @return
     */
    private String cnvBlankToNulll(String strVal) {

        // 引数の値が空白の場合、"NULL"を返却
        String ret = null;
        if (0 < strVal.trim().length()) {
            // 引数の値が空白以外の場合、引数の値を返却
            ret = strVal;
        }

        return ret;
    }

}