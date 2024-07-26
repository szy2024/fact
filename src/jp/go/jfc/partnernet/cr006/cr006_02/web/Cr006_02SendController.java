//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/01 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.web;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;
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
 * このクラスはcr006_02の送信コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr006_02Form")
@RequestMapping(value = "/Cr006_02Send.form")
public class Cr006_02SendController extends Cr006_02BaseController {

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    // private String strKei = null;
    // private String strSokin = null;
    // private String strTatekaeZanAfterUkeire = null;

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
    public String executeAction(Model model, Cr006_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        bizErrors = checkInput(form);

        // チェック結果判定
        // エラーメッセージが設定されているかどうかのチェックを行う
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 遷移パラメータに設定する。
        setTransitionPram(request, form);

        // 次画面を呼び出す。
        return success(Cr006Constants.EVENT_ID_CR006_03INIT);

    }

    private void setTransitionPram(HttpServletRequest request, Cr006_02Form form) throws Exception {

        /** 報告年月日 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_DATE_REPORT, form.getTxtID_Date_Report());
        /** 顧客名 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_NAME_CUSTOMER,
                form.getTxtID_Name_Customer());
        /** 扱店名 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_NAME_ORGANIZATION,
                form.getTxtID_Name_Organization());
        /** 公庫支店 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN,
                form.getTxtID_Code_KoukoShiten());
        /** 扱店 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_ORGANIZATION,
                form.getTxtID_Code_Organization());
        /** 店舗 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_TENPO, form.getTxtID_Code_Tenpo());
        /** 年度 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_YEAR, form.getTxtID_Year());
        /** 方式資金 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN,
                form.getTxtID_Code_HoshikiShikin());
        /** 番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_ID_RINGI, form.getTxtID_ID_Ringi());
        /** 枝番 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_ID_RINGIBRANCH,
                form.getTxtID_ID_RingiBranch());
        /** 入金日(年号) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_NYUKIN_GENGOU,
                form.getDrpID_Date_Nyukin_Gengou());
        /** 入金日(年) */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_DATE_NYUKIN_YEAR,
                form.getTxtID_Date_Nyukin_Year());
        /** 入金日(月) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_NYUKIN_MONTH,
                form.getDrpID_Date_Nyukin_Month());
        /** 入金日(日) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_NYUKIN_DAY,
                form.getDrpID_Date_Nyukin_Day());
        /** 立替金利息(円) */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_TATEKAERISOKU,
                form.getTxtID_M_TatekaeRisoku());
        /** 立替金（円） */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_TATEKAE, form.getTxtID_M_Tatekae());
        /** 仮受金(一般口)からの充当額（円） **/
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO,
                form.getTxtID_M_KariukeIppanJuto());
        /** 立替金の種類 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_TATEKAEKINSHURUI,
                form.getTxtID_Code_TatekaekinShurui());
        /** 公庫立替日 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_DATE_KOUKOTATEKAE,
                form.getTxtID_Date_KoukoTatekae());
        /** 計（円） */
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_KEI, form.getTxtID_M_Kei());
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_KEI, strKei);
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_KEI, form.getAns_M_Kei());
        /** 送金額（円） */
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_SOKIN, form.getTxtID_M_Sokin());
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_SOKIN, strSokin);
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_SOKIN, form.getAns_M_Sokin());
        /** 受入後立替金残高（円） */
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_TATEKAEZANAFTERUKEIRE,
        // form.getTxtID_M_TatekaeZanAfterUkeire());
        // addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_TATEKAEZANAFTERUKEIRE,
        // strTatekaeZanAfterUkeire);
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_M_TATEKAEZANAFTERUKEIRE,
                form.getAns_M_TatekaeZanAfterUkeire());
        /** 受託者勘定処理年月(年号) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_JTKSHORI_GENGOU,
                form.getDrpID_Date_Jtkshori_Gengou());
        /** 受託者勘定処理年月(年) */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_DATE_JTKSHORI_YEAR,
                form.getTxtID_Date_Jtkshori_Year());
        /** 受託者勘定処理年月(月) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_JTKSHORI_MONTH,
                form.getDrpID_Date_Jtkshori_Month());
        /** 送金年月日(年号) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_SOKIN_GENGOU,
                form.getDrpID_Date_Sokin_Gengou());
        /** 送金年月日(年) */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_DATE_SOKIN_YEAR,
                form.getTxtID_Date_Sokin_Year());
        /** 送金年月日(月) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_SOKIN_MONTH,
                form.getDrpID_Date_Sokin_Month());
        /** 送金年月日(日) */
        addForwardParameter(request, Cr006Constants.PROPERTY_DRPID_DATE_SOKIN_DAY,
                form.getDrpID_Date_Sokin_Day());
        /** 送金日番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_TXTID_CODE_SOKIN, form.getTxtID_Code_Sokin());
        /** 原本番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_MASTER, form.getID_ID_Master());
        /** ユーザID */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_USERID, form.getID_UserID());
        /** データコード */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATACODE, form.getID_DataCode());
        /** ステータス(非表示) */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_STATUS, form.getID_Status());
        /** 取消済フラグ */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_FLAG_TORIKESHIZUMI,
                form.getID_Flag_Torikeshizumi());
        /** 処理種別 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_TYPE_PROCESS, form.getID_Type_Process());
        /** 先行報告書の有無 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_PREVIOUS_REPORT, form.getID_Previous_Report());
        /** 先行報告書の種類 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_PREVIOUS_REPORTTYPE,
                form.getID_Previous_ReportType());
        /** 仮受仮払精算後残高（計算用） */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_M_KRBRIZNAFTERSISN,
                form.getID_M_KaribaraiZanAfterSeisan());
        /** 本支店コード */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_HONSHITEN, form.getID_Code_HonShiten());
        /** 仮受仮払番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_KRBRI, form.getID_ID_Karibarai());
        /** 入金日 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATE_NYUKIN, form.getID_Date_Nyukin());
        /** 受託者勘定処理年月 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATE_JTKSHORI, form.getID_Date_Jtkshori());
        /** 送金年月日 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATE_SOKIN, form.getID_Date_Sokin());
        /** 最新データ更新日付 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATA_LASTUPDATE, form.getID_Data_LastUpDate());
        /** 債権管理番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_CREDIT, form.getCr006_02_ID_ID_Credit());
        /** 報告書番号 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_REPORT, form.getID_ID_Report());
        /** 報告書時分秒 */
        addForwardParameter(request, Cr006Constants.PROPERTY_ID_TIME_REPORT, form.getID_Time_Report());

    }

    private List<PNMessageInfo> checkInput(Cr006_02Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 業務日付の取得
        String strGyomuDate = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        // オブジェクト生成
        // 入金日
        String strNyukin_G = form.getDrpID_Date_Nyukin_Gengou();
        String strNyukin_Y = form.getTxtID_Date_Nyukin_Year();
        String strNyukin_M = form.getDrpID_Date_Nyukin_Month();
        String strNyukin_D = form.getDrpID_Date_Nyukin_Day();
        PNCheckDay checkNyukinDate = new PNCheckDay(strNyukin_G, strNyukin_Y, strNyukin_M, strNyukin_D,
                pnCommonDBComponents, bizErrors);

        // 送金日
        String strSokin_G = form.getDrpID_Date_Sokin_Gengou();
        String strSokin_Y = form.getTxtID_Date_Sokin_Year();
        String strSokin_M = form.getDrpID_Date_Sokin_Month();
        String strSokin_D = form.getDrpID_Date_Sokin_Day();
        PNCheckDay checkSokinDate = new PNCheckDay(strSokin_G, strSokin_Y, strSokin_M, strSokin_D,
                pnCommonDBComponents, bizErrors);

        // 受託者勘定処理年月
        String strJutaku_G = form.getDrpID_Date_Jtkshori_Gengou();
        String strJutaku_Y = form.getTxtID_Date_Jtkshori_Year();
        String strJutaku_M = form.getDrpID_Date_Jtkshori_Month();
// [UPD] Ver 3.0.0 - START
//        PNCheckDay checkJutakuDate = new PNCheckDay(strJutaku_G, strJutaku_Y, strJutaku_M, "01",
//                pnCommonDBComponents, bizErrors);
        PNCheckDay checkJutakuDate = new PNCheckDay(strJutaku_G, strJutaku_Y, strJutaku_M, "",
                pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END

        // 必須チェック
        // 仮受金(一般口)からの充当額が０または未入力の場合
        if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto())))) {
            // 送金日の元号、年、月、日のいずれかが未入力の場合エラーとする。
            // エラーID：送金年月日、PM3120E
            checkSokinDate.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[] { "送金年月日" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }

            // 送金日番号が未入力の場合、エラーとする。
            if (PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(form
                    .getTxtID_Code_Sokin()))) {
                // エラーID：送金日番号、PM3120E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[] { "送金日番号" },
                        false));
                return bizErrors;
            }
        }
        // 仮受金(一般口)からの充当額が入力されている場合
        else {
            // 送金日の年、月、日のいずれかが入力済の場合エラーとする。
            // エラーID：送金年月日、PM3130E
            checkSokinDate.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E, new String[] { "送金年月日" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }

            // 送金日番号が入力されている場合、エラーとする。
            if (!PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(form
                    .getTxtID_Code_Sokin()))) {
                // エラーID：送金日番号、PM3130E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E, new String[] { "送金日番号" },
                        false));
                return bizErrors;
            }
        }
        // 送金日のチェック
        // 仮受金(一般口)からの充当額が０または未入力の場合
        if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto())))) {
            // 送金日の年号＋年がS64の場合、エラーとする。
            // エラーID：送金年月日の、PM3291E
            checkSokinDate.addErrorS64(PNCommonMessageConstants.PM3291E, new String[] { "送金年月日の" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }

            // チェック結果が正常の場合
            // 送金日（年号）（年）（月）（日）を連結し西暦変換（YYYYMMDD)できるかチェックを行う。（有効日付のチェック）
            // 西暦変換がエラーの場合
            // エラーID：送金日は有効日付、PM3140E
            checkSokinDate
                    .addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E, new String[] { "送金日は有効日付" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }

            // 西暦変換が正常の場合、変換した送金日をForm項目の送金日に設定する。
            form.setID_Date_Sokin(checkSokinDate.getSeireki());
        }
        else {
            form.setID_Date_Sokin(PNCommonConstants.LITERAL_BLANK);
        }

        // 受託者勘定処理年月のチェック （先行の受託者勘定処理年月(年)チェックが正常の場合のみ行う）⇒ここまで来たら単項目チェックOKとなっている

        // 受託者勘定処理年月の年号＋年がS64の場合、エラーとする。
        // エラーID：受託者勘定処理年月の、PM3291E
        checkJutakuDate.addErrorS64(PNCommonMessageConstants.PM3291E, new String[] { "受託者勘定処理年月の" });
        if (0 != bizErrors.size()) {
            return bizErrors;
        }

        // チェック結果が正常の場合
        // 受託者勘定処理年月（年号）（年）（月）を連結し西暦変換できるかチェックを行う。（有効日付のチェック）
        // 西暦変換がエラーの場合
        // エラーID：受託者勘定処理年月は有効日付、PM3140E
// [UPD] Ver 3.0.0 - START
//        checkJutakuDate.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                new String[] { "受託者勘定処理年月は有効日付" });
        checkJutakuDate.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                new String[] { "受託者勘定処理年月は有効日付" });
// [UPD] Ver 3.0.0 - END
        if (0 != bizErrors.size()) {
            return bizErrors;
        }
        // 西暦変換が正常の場合、変換した受託者勘定処理年月をForm項目の受託者勘定処理年月に設定する。（年月のみ）
        form.setID_Date_Jtkshori(checkJutakuDate.getSeireki().substring(0, 6));

        // 入金日のチェック （先行の入金日（年）チェックが正常の場合のみ行う）⇒ここまで来たら単項目チェックOKとなっている
        // 入金日の年号＋年がS64の場合、エラーとする。
        // エラーID：入金日の、PM3291E
        checkNyukinDate.addErrorS64(PNCommonMessageConstants.PM3291E, new String[] { "入金日の" });
        if (0 != bizErrors.size()) {
            return bizErrors;
        }

        // チェック結果が正常の場合
        // 入金日（年号）（年）（月）（日）を連結し西暦変換（YYYYMMDD)できるかチェックを行う。（有効日付のチェック）
        // 西暦変換がエラーの場合
        // エラーID：入金日は有効日付、PM3140E
        checkNyukinDate.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E, new String[] { "入金日は有効日付" });
        if (0 != bizErrors.size()) {
            return bizErrors;
        }

        // 西暦変換が正常の場合、変換した入金日をForm項目の入金日に設定する。
        form.setID_Date_Nyukin(checkNyukinDate.getSeireki());

        // 相関チェック
        // 入金日取得
        String strNyukin = form.getID_Date_Nyukin();
        String strKokoTatekae = form.getTxtID_Date_KoukoTatekae();
        // 入金日のチェック （Form項目の入金日が空文字でない場合のみ行う）
        if (!PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(strNyukin))) {
            // 共通処理にて入金日の営業日チェックを行い、非営業日の場合、エラーとする。
            checkNyukinDate.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[] { "入金日が" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }
            // チェック結果が正常の場合
            // 入金日＞業務日付の場合、エラーとする。
            if (Integer.parseInt(strGyomuDate) < Integer.parseInt(strNyukin)) {
                // エラーID：入金日が報告日、PM3260E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E, new String[] { "入金日が報告日" },
                        false));
                return bizErrors;
            }
        }

        // チェック結果が正常の場合
        // 入金日<公庫立替日の場合、エラーとする。
        if (Integer.parseInt(strNyukin) < Integer.parseInt(strKokoTatekae)) {
            // エラーID：入金日＜公庫立替日、PM3140E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E, new String[] { "公庫立替日<入金日" },
                    false));
            return bizErrors;
        }

        // 受託者勘定処理年月のチェック　（Form項目の受託者勘定処理年月が空文字でない場合のみ行う）
        String strJutakuDate = form.getID_Date_Jtkshori();
        String strNyukinDate = form.getID_Date_Nyukin();
        String strGyomuYYYYMM = strGyomuDate.substring(0, 6);
        Boolean blRyuchikinFlg = false;
        if (!PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(strJutakuDate))) {
            // 受託者勘定処理年月 > 業務日付（年月）の場合、エラーとする
            if (Integer.parseInt(strGyomuYYYYMM) < Integer.parseInt(strJutakuDate)) {
                // エラーID：受託者勘定処理年月が報告日、PM3260E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                        new String[] { "受託者勘定処理年月が報告日" }, false));
                return bizErrors;
            }
            // チェック結果が正常の場合
            // 共通処理にて業務日付の年度末日を取得する。
            String strGyomuNendomatsu = PNCommonComponents.getNendoMatsujitu(strGyomuYYYYMM.substring(0, 4),
                    strGyomuYYYYMM.substring(4)).replaceAll(Cr006Constants.LITERAL_SLASH, "");
            // 留置金フラグの初期化(=False)を行う。
            blRyuchikinFlg = false;

            // Form項目の送金日が空文字でない場合、以下のチェックを行う。
            String strSokinDate = form.getID_Date_Sokin();
            if (!PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(strSokinDate))) {
                // ①送金額が入力されていること。
                // ②入金日 ＜＝ 年度末日 かつ 送金日 ＞ 年度末日であること。
                if (0 != BigDecimal.ZERO.compareTo(PNCommonUtils.cnvBigStrMoney(form.getTxtID_M_Sokin()))
                        && Integer.parseInt(strNyukinDate) <= Integer.parseInt(strGyomuNendomatsu)
                        && Integer.parseInt(strGyomuNendomatsu) < Integer.parseInt(strSokinDate)) {
                    // 正常の場合、留置金フラグをTrueに設定する。
                    blRyuchikinFlg = true;
                }

                // 共通処理を使用し、決算整理日付を取得する。
                String strKessanDate = pnCommonDBComponents.getKessanbi();
                // 決算整理日付が取得できない場合、エラーとする。
                if (PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(strKessanDate))) {
                    // エラーID：決算整理日付、PM3190E
                    // 留置金フラグをFalseに設定する。
                    blRyuchikinFlg = false;
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E, new String[] { "決算整理日付" },
                            false));
                    return bizErrors;
                }

                // 決算整理日付が取得できた場合、以下を行う
                else {
                    // 年度末日≧業務日付又は、業務日付≧決算整理日付の場合、留置金フラグをFalseに設定する。
                    if (Integer.parseInt(strGyomuDate) <= Integer.parseInt(strGyomuNendomatsu)
                            || Integer.parseInt(strKessanDate) <= Integer.parseInt(strGyomuDate)) {
                        // 留置金フラグをFalseに設定する。
                        blRyuchikinFlg = false;
                    }
                }

                // 留置金フラグがTrueの場合、以下をチェックする。
                String strJutakuYYYYMMDD = checkJutakuDate.getSeireki();
                if (blRyuchikinFlg) {
                    // 受託者勘定処理年月+"01"＞入金日の場合、エラーとする
                    if (Integer.parseInt(strNyukinDate) < Integer.parseInt(strJutakuYYYYMMDD)) {
                        // エラーID：入金日は受託者勘定処理年月（留置金）以降の日付、PM3140E
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { "入金日は受託者勘定処理年月（留置金）以降の日付" }, false));
                        return bizErrors;
                    }
                }

                // 留置金フラグがFalseの場合、以下をチェックする。
                else {
                    // 受託者勘定処理年月＜入金日(年月)の場合、エラーとする。
                    if (Integer.parseInt(strJutakuDate) < Integer.parseInt(strNyukinDate.substring(0, 6))) {
                        // エラーID：受託者勘定処理年月＜入金日、PM3140E
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                new String[] { "入金日が受託者勘定処理年月" }, false));
                        return bizErrors;
                    }
                }

                // 決算整理日付が取得できた場合、以下をチェックする。
                if (!PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(strKessanDate))) {
                    // 業務日付＞本店決算整理日付かつ、受託者勘定処理年月＋"01"＜年度末日の場合、エラーとする。
                    if (Integer.parseInt(strKessanDate) < Integer.parseInt(strGyomuDate)
                            && Integer.parseInt(strJutakuYYYYMMDD) < Integer.parseInt(strGyomuNendomatsu)) {
                        // エラーID：PM3810E
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3810E, new String[] { "" },
                                false));
                        return bizErrors;
                    }
                }
            }

            int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(strGyomuDate);

            if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                    .cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto())))) {
                // 仮受金(一般口)からの充当額（円）が０または未入力の場合
                if (pnCommonDBComponents.isKessanki()) {
                    // 決算期（業務日付が4月または10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {

                        // 入金日（YYYYMM形式）
                        String strNyukinDateYYYYMM = strNyukinDate.substring(
                                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);

                        // 業務日付が第1～4営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strNyukinDateYYYYMM) >= 2) {
                            // 貸付実行日が業務日付の前々月以前の場合
                            if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) != 1) {
                                // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                                // エラーID：受託者勘定処理年月に報告日の前月の年月を、PM3110E
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に報告日の前月の年月を" }, false));
                                return bizErrors;
                            }
                        }
                        else {
                            // 上記以外の場合
                            if (!strJutakuDate.equals(strNyukinDateYYYYMM)) {
                                // 受託者勘定処理年月が貸付実行日の年月と異なる場合エラーとする。
                                // エラーID：受託者勘定処理年月に入金日の年月を、PM3110E
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                        new String[] { "受託者勘定処理年月に入金日の年月を" }, false));
                                return bizErrors;
                            }
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第5～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            return bizErrors;
                        }
                    }
                }
                else {
                    // 通常期（決算期以外の月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // 業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) > 1) {
                            // 受託者勘定処理年月が業務日付の年月または
                            // 業務日付の前月の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月または報告日の前月の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月または報告日の前月の年月を" },
                                    false));
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第11～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            return bizErrors;
                        }
                    }
                }
            }
            else {
                // 仮受金(一般口)からの充当額（円）＜＞０の場合
                if (pnCommonDBComponents.isKessanki()) {
                    // 決算期（業務日付が4月、10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
                        // 業務日付が第1～4営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) != 1) {
                            // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の前月の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の前月の年月を" }, false));
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第5～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            return bizErrors;
                        }
                    }
                }
                else {
                    // 通常期（決算期以外の月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // 業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(strGyomuYYYYMM, strJutakuDate) > 1) {
                            // 受託者勘定処理年月が業務日付の年月または
                            // 業務日付の前月の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月または報告日の前月の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月または報告日の前月の年月を" },
                                    false));
                            return bizErrors;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第11～最終営業日）
                        if (!strJutakuDate.equals(strGyomuYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // エラーID：受託者勘定処理年月に報告日の年月を、PM3110E
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3110E,
                                    new String[] { "受託者勘定処理年月に報告日の年月を" }, false));
                            return bizErrors;
                        }
                    }
                }
            }
        }

        // 送金日チェック　（Form項目の送金日が空文字以外でかつ、（仮受金からの充当額が空文字又は”０”の場合のみ行う）
        if (!PNCommonConstants.LITERAL_BLANK
                .equals(PNCommonComponents.cnvNulltoBlank(form.getID_Date_Sokin()))
                || 0 == BigDecimal.ZERO.compareTo(PNCommonUtils.cnvBigStrMoney(form
                        .getTxtID_M_KariukeIppanJuto()))) {

            // 共通処理にて送金日の営業日チェックを行い、非営業日の場合、エラーとする。
            // エラーID：送金日が、PM3331E
            checkSokinDate.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[] { "送金日が" });
            if (0 != bizErrors.size()) {
                return bizErrors;
            }
        }

        // 立替金チェック　（立替金が空文字でない場合のみ行う）
        BigDecimal bdTatekae = PNCommonUtils.cnvBigStrMoney(form.getTxtID_M_Tatekae());
        BigDecimal bdKrukKrbriSisnZndk = PNCommonUtils.cnvBigStrMoney(form.getID_M_KaribaraiZanAfterSeisan());
        if (0 != BigDecimal.ZERO.compareTo(bdTatekae)) {

            // 立替金＞仮受仮払精算後残高の場合、エラーとする。（仮受仮払精算後残高がＮＵＬＬ／空文字の場合０と扱う）
            if (0 < bdTatekae.compareTo(bdKrukKrbriSisnZndk)) {
                // エラーID：立替金が仮受仮払精算後残高、PM3180E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                        new String[] { "立替金が仮受仮払精算後残高" }, false));
                return bizErrors;
            }
        }

        // 先行の立替金利息、立替金のチェックがエラーでなかった場合、以下のチェックを行う。

        // 立替金利息＞０又は、立替金＞０の場合、以下のチェックを行う。
        BigDecimal bdTatekaeRisoku = PNCommonUtils.cnvBigStrMoney(form.getTxtID_M_TatekaeRisoku());
        if (0 > BigDecimal.ZERO.compareTo(bdTatekaeRisoku) || 0 > BigDecimal.ZERO.compareTo(bdTatekae)) {
            // ①計算対象の取得
            // ・仮受仮払精算後残高の取得（仮受仮払精算後残高が空文字の場合、０を設定）
            // ・立替金の取得（立替金が空文字の場合、０を設定）
            // ・立替金利息の取得（立替金利息が空文字の場合、０を設定）
            BigDecimal bdUkirgTtkeZndk = bdKrukKrbriSisnZndk.subtract(bdTatekae);
            BigDecimal bdKei = PNCommonComponents.cnvNulltoZero(bdTatekae).add(bdTatekaeRisoku);
            // ②計算（Form項目の更新）
            // ・「受入後立替金残高」＝仮受仮払精算後残高－立替金
            // ・「計」 ＝立替金＋立替金利息
            // form.setTxtID_M_TatekaeZanAfterUkeire(bdUkirgTtkeZndk.toString());
            // strTatekaeZanAfterUkeire = bdUkirgTtkeZndk.toString();
            form.setAns_M_TatekaeZanAfterUkeire(bdUkirgTtkeZndk.toString());
            // form.setTxtID_M_Kei(bdKei.toString());
            // strKei = bdKei.toString();
            form.setAns_M_Kei(bdKei.toString());

            // ③チェック
            // 仮受金(一般口)からの充当額が空文字又は０の場合
            if (PNCommonConstants.LITERAL_BLANK.equals(PNCommonUtils.cnvBigStrMoney(
                    form.getTxtID_M_KariukeIppanJuto()).toString())
                    || 0 == BigDecimal.ZERO.compareTo(PNCommonUtils.cnvBigStrMoney(form
                            .getTxtID_M_KariukeIppanJuto()))) {
                // Form項目の「送金額」に「計」を設定。
                // form.setTxtID_M_Sokin(bdKei.toString());
                // strSokin = bdKei.toString();
                form.setAns_M_Sokin(bdKei.toString());
            }
            // 仮受金(一般口)からの充当額が１以上の値の場合、以下のチェックを行う
            if (0 < PNCommonUtils.cnvBigStrMoney(form.getTxtID_M_KariukeIppanJuto())
                    .compareTo(BigDecimal.ONE)) {
                // 「計」と仮受金(一般口)からの充当額が同額でない場合、エラーとする。
                if (0 != bdKei.compareTo(PNCommonUtils.cnvBigStrMoney(form.getTxtID_M_KariukeIppanJuto()))) {
                    // エラーID：仮受金(一般口)からの充当額が、PM3471E
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3471E,
                            new String[] { "仮受金(一般口)からの充当額が" }, false));
                    return bizErrors;
                }
            }
        }

        // 立替金利息＝０かつ、立替金＝０の場合、エラーとする。
        else if (0 == bdTatekaeRisoku.compareTo(BigDecimal.ZERO) && 0 == bdTatekae.compareTo(BigDecimal.ZERO)) {
            // エラーID：立替金利息，立替金、PM3120E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[] { "立替金利息，立替金" },
                    false));
            return bizErrors;
        }

        return bizErrors;
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
    public void displayControl(Model model, Cr006_02Form form, HttpServletRequest request) {

    }
}