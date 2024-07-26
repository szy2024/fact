//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/30 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_01.web;

import java.math.BigDecimal;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.md005.common.Md005Constants;
import jp.go.jfc.partnernet.md005.md005_01.service.Md005_01DTO;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
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
 * このクラスはmd005_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md005_01Form")
@RequestMapping(value = "/Md005_01Send.form")
public class Md005_01SendController extends Md005_01BaseController {

    /** pnCommonDBComponents */
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
    public String executeAction(Model model, Md005_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        Md005_01DTO outDto = new Md005_01DTO();
        CFWBeanUtils.copyProperties(outDto, form);

        // 入力チェック
        outDto = checkInput(outDto);
        bizErrors.addAll(outDto.getBizErrors());

        // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
        // 　　return MY_VIEW
        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 　画面のメッセージが設定されていない場合、画面遷移を行う。
        // 　　入力結果画面へ遷移する
        setRequestNextScreen(request, outDto);

        // 　　　画面に入力された項目を遷移パラメータに設定する。(画面遷移パラメタ定義参照)
        // 　　　return success("Md005_02Init")
        return success(Md005Constants.EVENT_ID_MD005_02INIT);
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
    public void displayControl(Model model, Md005_01Form form, HttpServletRequest request) {

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param Md005_01Form
     *
     */
    private void setRequestNextScreen(HttpServletRequest request, Md005_01DTO inDto) {
        // 報告年月日
        addForwardParameter(request, Md005Constants.PROPERTY_LBLID_DATE_REPORT, inDto.getLblID_Date_Report());
        // メッセージ
        addForwardParameter(request, Md005Constants.PROPERTY_LBLMESSAGE, inDto.getLblMessage());
        // 顧客名
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_NAME_CUSTOMER_RED,
                inDto.getTxtID_Name_Customer_Red());
        // 扱店名
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_NAME_ORGANIZATION_RED,
                inDto.getTxtID_Name_Organization_Red());
        // 公庫支店
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN_RED,
                inDto.getTxtID_Code_KoukoShiten_Red());
        // 扱店
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_ORGANIZATION_RED,
                inDto.getTxtID_Code_Organization_Red());
        // 店舗
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_TENPO_RED,
                inDto.getTxtID_Code_Tenpo_Red());
        // 年度
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_YEAR_RED, inDto.getTxtID_Year_Red());
        // 方式資金
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN_RED,
                inDto.getTxtID_Code_HoshikiShikin_Red());
        // 番号
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_RINGI_RED,
                inDto.getTxtID_ID_Ringi_Red());
        // 枝番
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_RINGIBRANCH_RED,
                inDto.getTxtID_ID_RingiBranch_Red());
        // 充当対象払込期日
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JUTOTAISHO_RED,
                inDto.getTxtID_Date_JutoTaisho_Red());
        // 代弁金払込日
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMI_RED,
                inDto.getTxtID_Date_DaibenkinHaraikomi_Red());
        // 遅延損害金(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_CHIENSONGAI_RED, inDto
                .getTxtID_M_ChienSongai_Red().replaceAll(",", ""));
        // 利息(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_RISOKU_RED, inDto
                .getTxtID_M_Risoku_Red().replaceAll(",", ""));
        // 繰上償還手数料(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KURISHOCOMMISSION_RED, inDto
                .getTxtID_M_KurishoCommission_Red().replaceAll(",", ""));
        // 元金(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_GANKIN_RED, inDto
                .getTxtID_M_Gankin_Red().replaceAll(",", ""));
        // 仮受金(一般口)からの充当額(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED, inDto
                .getTxtID_M_KariukeIppanJuto_Red().replaceAll(",", ""));
        // 計(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KEI_RED, inDto.getTxtID_M_Kei_Red()
                .replaceAll(",", ""));
        // 送金額(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_SOKIN_RED, inDto.getTxtID_M_Sokin_Red()
                .replaceAll(",", ""));
        // 代弁金充当後残元金(円)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_ZANGANAFTERDAIBENJUTO_RED, inDto
                .getTxtID_M_ZanGanAfterDaibenJuto_Red().replaceAll(",", ""));
        // 受託者勘定処理年月
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JTKSHORI_RED,
                inDto.getTxtID_Date_Jtkshori_Red());
        // 送金日
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_SOKIN_RED,
                inDto.getTxtID_Date_Sokin_Red());
        // 送金日番号
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_SOKINBI_RED,
                inDto.getTxtID_ID_Sokinbi_Red());
        // 受託者勘定処理年月(元号)
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JTKSHORIGENGOU_RED,
                inDto.getDrpID_Date_JtkshoriGengou_Red());
        // 受託者勘定処理年月(年)
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JTKSHORIYEAR_RED,
                inDto.getTxtID_Date_JtkshoriYear_Red());
        // 受託者勘定処理年月(月)
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JTKSHORIMONTH_RED,
                inDto.getDrpID_Date_JtkshoriMonth_Red());
        // 黒データ入力領域タイトル
        addForwardParameter(request, Md005Constants.PROPERTY_LBLID_HEAD, inDto.getLblID_Head());
        // 顧客名（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_NAME_CUSTOMER,
                inDto.getTxtID_Name_Customer());
        // 扱店名（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_NAME_ORGANIZATION,
                inDto.getTxtID_Name_Organization());
        // 公庫支店（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN,
                inDto.getTxtID_Code_KoukoShiten());
        // 扱店（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_ORGANIZATION,
                inDto.getTxtID_Code_Organization());
        // 店舗（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_TENPO, inDto.getTxtID_Code_Tenpo());
        // 年度（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_YEAR, inDto.getTxtID_Year());
        // 方式資金（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN,
                inDto.getTxtID_Code_HoshikiShikin());
        // 番号（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_RINGI, inDto.getTxtID_ID_Ringi());
        // 枝番（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_RINGIBRANCH,
                inDto.getTxtID_ID_RingiBranch());
        // 充当対象払込期日(元号)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JUTOTAISHOGENGOU,
                inDto.getDrpID_Date_JutoTaishoGengou());
        // 充当対象払込期日(年)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JUTOTAISHOYEAR,
                inDto.getTxtID_Date_JutoTaishoYear());
        // 充当対象払込期日(月)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JUTOTAISHOMONTH,
                inDto.getDrpID_Date_JutoTaishoMonth());
        // 充当対象払込期日(日)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JUTOTAISHODAY,
                inDto.getDrpID_Date_JutoTaishoDay());
        // 代弁金払込日(元号)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIGENGOU,
                inDto.getDrpID_Date_DaibenkinHaraikomiGengou());
        // 代弁金払込日(年)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_DAIBENKINHARAIKOMIYEAR,
                inDto.getTxtID_Date_DaibenkinHaraikomiYear());
        // 代弁金払込日(月)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIMONTH,
                inDto.getDrpID_Date_DaibenkinHaraikomiMonth());
        // 代弁金払込日(日)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_DAIBENKINHARAIKOMIDAY,
                inDto.getDrpID_Date_DaibenkinHaraikomiDay());
        // 遅延損害金(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_CHIENSONGAI, inDto
                .getTxtID_M_ChienSongai().replaceAll(",", ""));
        // 利息(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_RISOKU, inDto.getTxtID_M_Risoku()
                .replaceAll(",", ""));
        // 繰上償還手数料(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KURISHOCOMMISSION, inDto
                .getTxtID_M_KurishoCommission().replaceAll(",", ""));
        // 元金(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_GANKIN, inDto.getTxtID_M_Gankin()
                .replaceAll(",", ""));
        // 仮受金(一般口)からの充当額(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO, inDto
                .getTxtID_M_KariukeIppanJuto().replaceAll(",", ""));
        // 計(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_KEI,
                inDto.getTxtID_M_Kei().replaceAll(",", ""));
        // 送金額(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_SOKIN, inDto.getTxtID_M_Sokin()
                .replaceAll(",", ""));
        // 代弁金充当後残元金(円)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_M_ZANGANAFTERDAIBENJUTO, inDto
                .getTxtID_M_ZanGanAfterDaibenJuto().replaceAll(",", ""));
        // 受託者勘定処理年月（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JTKSHORI,
                inDto.getTxtID_Date_Jtkshori());
        // 送金日(元号)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_SOKINGENGOU,
                inDto.getDrpID_Date_SokinGengou());
        // 送金日(年)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_SOKINYEAR,
                inDto.getTxtID_Date_SokinYear());
        // 送金日(月)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_SOKINMONTH,
                inDto.getDrpID_Date_SokinMonth());
        // 送金日(日)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_SOKINDAY,
                inDto.getDrpID_Date_SokinDay());
        // 送金日番号（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_ID_SOKINBI, inDto.getTxtID_ID_Sokinbi());
        // 受託者勘定処理年月(元号)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JTKSHORIGENGOU,
                inDto.getDrpID_Date_JtkshoriGengou());
        // 受託者勘定処理年月(年)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_TXTID_DATE_JTKSHORIYEAR,
                inDto.getTxtID_Date_JtkshoriYear());
        // 受託者勘定処理年月(月)（修正）
        addForwardParameter(request, Md005Constants.PROPERTY_DRPID_DATE_JTKSHORIMONTH,
                inDto.getDrpID_Date_JtkshoriMonth());
        // 報告書番号
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_REPORT, inDto.getID_ID_Report());
        // 報告年月日A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_REPORT, inDto.getID_Date_Report());
        // 扱店名A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_NAME_ORGANIZATION,
                inDto.getID_Name_Organization());
        // 顧客名A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_NAME_CUSTOMER, inDto.getID_Name_Customer());
        // 公庫支店A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_KOUKOSHITEN,
                inDto.getID_Code_KoukoShiten());
        // 扱店A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_ORGANIZATION,
                inDto.getID_Code_Organization());
        // 店舗A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_TENPO, inDto.getID_Code_Tenpo());
        // 年度A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_YEAR, inDto.getID_Year());
        // 方式資金A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_HOSHIKISHIKIN,
                inDto.getID_Code_HoshikiShikin());
        // 番号A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_RINGI, inDto.getID_ID_Ringi());
        // 枝番A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_RINGIBRANCH, inDto.getID_ID_RingiBranch());
        // 充当対象払込期日A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHO,
                inDto.getID_Date_JutoTaisho());
        // 充当対象払込期日(元号)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHOGENGOU,
                inDto.getID_Date_JutoTaishoGengou());
        // 充当対象払込期日(西暦年)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHOYEAR,
                inDto.getID_Date_JutoTaishoYear());
        // 充当対象払込期日(月)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHOMONTH,
                inDto.getID_Date_JutoTaishoMonth());
        // 充当対象払込期日入力
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHOYEAR_INPUT,
                inDto.getID_Date_JutoTaishoYear_Input());
        // 充当対象払込期日(日)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JUTOTAISHODAY,
                inDto.getID_Date_JutoTaishoDay());
        // 代弁金払込日A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMI,
                inDto.getID_Date_DaibenkinHaraikomi());
        // 代弁金払込日(元号)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMIGENGOU,
                inDto.getID_Date_DaibenkinHaraikomiGengou());
        // 代位金払込日入力
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMIYEAR_INPUT,
                inDto.getID_Date_DaibenkinHaraikomiYear_Input());
        // 代弁金払込日(西暦年)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMIYEAR,
                inDto.getID_Date_DaibenkinHaraikomiYear());
        // 代弁金払込日(月)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMIMONTH,
                inDto.getID_Date_DaibenkinHaraikomiMonth());
        // 代弁金払込日(日)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_DAIBENKINHARAIKOMIDAY,
                inDto.getID_Date_DaibenkinHaraikomiDay());
        // 遅延損害金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_CHIENSONGAI, inDto.getID_M_ChienSongai());
        // 利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_RISOKU, inDto.getID_M_Risoku());
        // 元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_GANKIN, inDto.getID_M_Gankin());
        // 計
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_KEI, inDto.getID_M_Kei());
        // 仮受金(一般口)からの充当額
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_KARIUKEIPPANJUTO,
                inDto.getID_M_KariukeIppanJuto());
        // 代弁金充当後残元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_ZANGANAFTERDAIBENJUTO,
                inDto.getID_M_ZanGanAfterDaibenJuto());
        // 繰上償還手数料
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_KURISHOCOMMISSION,
                inDto.getID_M_KurishoCommission());
        // 送金額
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_SOKIN, inDto.getID_M_Sokin());
        // 送金日A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKIN, inDto.getID_Date_Sokin());
        // 送信日(年号)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKINGENGOU,
                inDto.getID_Date_SokinGengou());
        // 送信日(西暦年)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKINYEAR, inDto.getID_Date_SokinYear());
        // 送信日人力
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKINYEAR_INPUT,
                inDto.getID_Date_SokinYear_Input());
        // 送信日(月)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKINMONTH,
                inDto.getID_Date_SokinMonth());
        // 送信日(日)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SOKINDAY, inDto.getID_Date_SokinDay());
        // 送金日番号A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_SOKINBI, inDto.getID_ID_Sokinbi());
        // 受託者勘定処理年月A
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JTKSHORI, inDto.getID_Date_Jtkshori());
        // 受託者勘定処理年月入力
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JTKSHORIYEAR_INPUT,
                inDto.getID_Date_JtkshoriYear_Input());
        // 受託者勘定処理年月(元号)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JTKSHORIGENGOU,
                inDto.getID_Date_JtkshoriGengou());
        // 受託者勘定処理年月(年)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JTKSHORIYEAR,
                inDto.getID_Date_JtkshoriYear());
        // 受託者勘定処理年月(月)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_JTKSHORIMONTH,
                inDto.getID_Date_JtkshoriMonth());
        // M_貸付残高
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_KASHITSUKEZANDAKA,
                inDto.getID_M_KashitsukeZandaka());
        // 表示画面のヘッダ項目
        addForwardParameter(request, Md005Constants.PROPERTY_ID_INPUTHEAD, inDto.getID_InputHead());
        // 債権管理番号
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_CREDIT, inDto.getID_ID_Credit());
        // 請求繰償利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_SEIKURIRISOKU,
                inDto.getID_M_SeiKuriRisoku());
        // 請求繰償元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_SEIKURIGANKIN,
                inDto.getID_M_SeiKuriGankin());
        // 請求データに登録を行う請求繰償利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_SEIKYU_M_SEIKURIRISOKU,
                inDto.getID_Seikyu_M_SeiKuriRisoku());
        // 請求データに登録を行う請求繰償元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_SEIKYU_M_SEIKURIGANKIN,
                inDto.getID_Seikyu_M_SeiKuriGankin());
        // M_約定利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJORISOKU, inDto.getID_M_YakujoRisoku());
        // M_約定元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJOGANKIN, inDto.getID_M_YakujoGankin());
        // 退避貸付金残高（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_M_KASHITSUKEZAN,
                inDto.getID_Keep_M_KashitsukeZan());
        // 退避約定元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_M_YAKUJOGANKIN,
                inDto.getID_Keep_M_YakujoGankin());
        // 退避約定利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_M_YAKUJORISOKU,
                inDto.getID_Keep_M_YakujoRisoku());
        // 退避請求繰償利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU,
                inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        // 退避請求繰償元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN,
                inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        // 取消済みフラグ（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_FLAG_TORIKESHIZUMI,
                inDto.getID_Flag_Torikeshizumi());
        // 退避償還期限（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_DATE_SHOKANKIGEN,
                inDto.getID_Keep_Date_ShokanKigen());
        // 報告時分秒（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_TIME_REPORT, inDto.getID_Time_Report());
        // 取消用払出・債権管理番号
        addForwardParameter(request, Md005Constants.PROPERTY_ID_INS_ID_CREDIT, inDto.getID_Ins_ID_Credit());
        // 扱店別稟議データに登録を行う払込前残元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_KASHITSUKEZANDAKA_ARINGI,
                inDto.getID_M_KashitsukeZandaka_aRingi());
        // 扱店別稟議データに登録を行う償還期限
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SHOKANKIGEN_ARINGI,
                inDto.getID_Keep_Date_ShokanKigen());
        // 請求データに登録を行う約定利息
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJORISOKU_SEIKYU,
                inDto.getID_M_YakujoRisoku_Seikyu());
        // 請求データに登録を行う約定元金
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJOGANKIN_YAKUJO,
                inDto.getID_M_YakujoGankin_Yakujo());
        // 履歴番号（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_HISTORY, inDto.getID_ID_History());
        // ステータス（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_STATUS, inDto.getID_Status());
        // 処理種別
        addForwardParameter(request, Md005Constants.PROPERTY_ID_TYPE_PROCESS, inDto.getID_Type_Process());
        // データコード
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATACODE, inDto.getID_DataCode());
        // 扱店別稟議データの最新データ更新日付
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATA_LASTUPDATE,
                inDto.getID_Data_LastUpDate());
        // ユーザID（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_USER_ID, inDto.getID_User_ID());
        // 伝送番号（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ID_DENSO, inDto.getID_ID_Denso());
        // エラー番号（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_ERROR, inDto.getID_Code_Error());
        // エラーメッセージ（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ERRORMESSAGE, inDto.getID_ErrorMessage());
        // 顧客コード（非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_CODE_CUSTOMER, inDto.getID_Code_Customer());
        // 方式(非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KUBUN_HOSHIKI, inDto.getID_Kubun_Hoshiki());
        // 資金(非表示）
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KUBUN_SHIKIN, inDto.getID_Kubun_Shikin());
        // 償還期限年月(非表示)
        addForwardParameter(request, Md005Constants.PROPERTY_ID_DATE_SHOKANKIGEN,
                inDto.getID_Date_ShokanKigen());
        // 退避履歴番号
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_ID_HISTORY,
                inDto.getID_Keep_ID_History());
        // 退避実行済みフラグ
        addForwardParameter(request, Md005Constants.PROPERTY_ID_KEEP_FLAG_KJ, inDto.getID_Keep_Flag_Kj());
        // 扱店別稟議データより取得した実行済みフラグ
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ARINGI_FLAG_KJ, inDto.getID_aRingi_Flag_Kj());
        // 扱店別稟議データより取得した償還期限年月
        addForwardParameter(request, Md005Constants.PROPERTY_ID_ARINGI_DATE_SHOKANKIGEN,
                inDto.getID_aRingi_Date_ShokanKigen());
        // 報告書種別（値）(非表示)
        addForwardParameter(request, Md005Constants.PROPERTY_DATACODE, inDto.getID_DataCode());
        // 処理モード
        addForwardParameter(request, Md000Constants.PROPERTY_ID_REPORT_PROCESS_MODE, inDto.getProcessMode());
        // モードタイプ
        addForwardParameter(request, Md005Constants.PROPERTY_MODETYPE, inDto.getModeType());
        // 更正（赤）データの請求データ「約定元金」
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJOGANKIN_SEIKYU_RED,
                inDto.getID_M_YakujoGankin_Seikyu_Red());
        // 更正（赤）データの請求データ「約定利息」
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_YAKUJORISOKU_SEIKYU_RED,
                inDto.getID_M_YakujoRisoku_Seikyu_Red());
        // 更正（赤）データの請求データ「請求繰償元金」
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_SEIKURIGANKIN_SEIKYU_RED,
                inDto.getID_M_SeiKuriGankin_Seikyu_Red());
        // 更正（赤）データの請求データ「請求繰償利息」
        addForwardParameter(request, Md005Constants.PROPERTY_ID_M_SEIKURIRISOKU_SEIKYU_RED,
                inDto.getID_M_SeiKuriRisoku_Seikyu_Red());
    }

    /**
     * 入力チェック
     *
     * @param Md005_01Form
     * @return LinkedList<PNMessageInfo> エラー情報
     */
    private Md005_01DTO checkInput(Md005_01DTO inDto) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        String errMsg = "";

        // 業務日付取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // String nowYear = new StringBuffer(nowDate).substring(0, 4);
        // String nowMonth = new StringBuffer(nowDate).substring(4, 6);
        // String nowYYYYMM = PNCommonComponents.concatString(nowYear,
        // nowMonth);

        String[] checkTargets = new String[2];
        // 処理モードによりエンティティパラメータを設定する。
        if (Md005Constants.PROCESS_MODE_1.equals(inDto.getProcessMode())
                || Md005Constants.PROCESS_MODE_3.equals(inDto.getProcessMode())) {
            // １．処理モードが処理完了以外：取消,処理完了：取消の場合
            // エンティティパラメータ１に更正（赤）画面入力データ保持用エンティティを設定する。
            checkTargets[0] = Md005Constants.ENTITY_RED;
            // エンティティパラメータ２にnullを設定する。
            checkTargets[1] = null;
        } else if (Md005Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {
            // ２．処理モードが処理完了以外：修正の場合
            // エンティティパラメータ１にnullを設定する。
            checkTargets[0] = null;
            // エンティティパラメータ２に更正（黒）画面入力データ保持用エンティティを設定する。
            checkTargets[1] = Md005Constants.ENTITY_BLACK;
        } else if (Md005Constants.PROCESS_MODE_2.equals(inDto.getProcessMode())) {
            // ３．処理モードが処理完了：修正の場合
            // エンティティパラメータ１に更正（赤）画面入力データ保持用エンティティを設定する。
            checkTargets[0] = Md005Constants.ENTITY_RED;
            // エンティティパラメータ２に更正（黒）画面入力データ保持用エンティティを設定する。
            checkTargets[1] = Md005Constants.ENTITY_BLACK;
        } else {
            // ４．上記以外の場合、エラーとし、チェック処理を終了する。
            // エラーID：PM9990E
            // 項目名：入力エラーチェック
            errMsg = "入力エラーチェック";
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9990E, new String[]{errMsg}, false));
            // エラー有の場合自画面表示
            inDto.setBizErrors(bizErrors);
            return inDto;
        }

        // チェック終了フラグ
        boolean checkEndFlag = Md005Constants.CHECK_NOT_END;
        // 修正データチェック
        boolean checkModFlag = Md005Constants.MOD_DATA_NO_CHECK;
        // 以下の処理を２回繰り返す
        for (int i = 0; i < Md005Constants.CHECK_REPEAT; i++) {
            String checkPnl = "";
            if (0 == i) {
                // １．１回目の処理の場合
                if (null != checkTargets[0]) {
                    // （１）エンティティパラメータ１がnullでない場合
                    // エンティティをエンティティパラメータ１で更新する。
                    checkPnl = checkTargets[0];
                    // 修正データチェックフラグへチェックしないを設定する。
                    checkModFlag = Md005Constants.MOD_DATA_NO_CHECK;
                    // チェック終了フラグへチェック終了でないを設定する。
                    checkEndFlag = Md005Constants.CHECK_NOT_END;
                } else {
                    // （２）エンティティパラメータ１がnullの場合
                    // 修正データチェックフラグへ「チェックしない」を設定する。
                    checkModFlag = Md005Constants.MOD_DATA_NO_CHECK;
                    // チェック終了フラグへ「チェック終了」を設定する。
                    checkEndFlag = Md005Constants.CHECK_END;
                }
            } else {
                // ２．２回目の処理の場合
                if (null != checkTargets[1]) {
                    // エンティティパラメータ２がnullでない場合
                    // エンティティをエンティティパラメータ２で更新する。
                    checkPnl = checkTargets[1];
                    // 修正データチェックフラグへ「チェックする」を設定する。
                    checkModFlag = Md005Constants.MOD_DATA_CHECK;
                    // チェック終了フラグへ「チェック終了でない」を設定する。
                    checkEndFlag = Md005Constants.CHECK_NOT_END;
                } else {
                    // エンティティパラメータ２がnullの場合
                    // 修正データチェックフラグへ「チェックしない」を設定する。
                    checkModFlag = Md005Constants.MOD_DATA_NO_CHECK;
                    // チェック終了フラグへ「チェック終了」を設定する。
                    checkEndFlag = Md005Constants.CHECK_END;
                }
            }

            if (Md005Constants.CHECK_NOT_END == checkEndFlag) {
                // チェック終了フラグが「チェック終了でない」の場合
                // 送金日入力済みフラグ true:入力あり
                boolean isInputDateSokin = false;
                if (Md005Constants.MOD_DATA_CHECK == checkModFlag) {
                    // １．修正データチェックフラグが「チェックする」の場合
                    if (Md005Constants.ENTITY_BLACK.equals(checkPnl)) {
                        // 更正（黒）画面入力データをチェック
                        // 必須チェック
                        // （１）債権管理番号のチェック
                        if (false == isAlreadyInput(inDto.getID_ID_Credit())) {
                            // 債権管理番号の入力なしの場合、エラーとする。
                            // エラーID：PM3120E
                            // 項目名：債権管理番号
                            errMsg = "債権管理番号";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // 必須チェック
                        // （２）充当対象払込期日のチェック
                        if (false == isAlreadyInput(inDto.getDrpID_Date_JutoTaishoGengou())
                                || false == isAlreadyInput(inDto.getTxtID_Date_JutoTaishoYear())
                                || false == isAlreadyInput(inDto.getDrpID_Date_JutoTaishoMonth())
                                || false == isAlreadyInput(inDto.getDrpID_Date_JutoTaishoDay())) {
                            // 充当対象払込期日の年、月、日が全て指定されていない場合、エラーとする。
                            // エラーID：PM3120E
                            // 項目名：充当対象払込期日
                            errMsg = "充当対象払込期日";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // （３）代弁金払込日のチェック
                        if (false == isAlreadyInput(inDto.getDrpID_Date_DaibenkinHaraikomiGengou())
                                || false == isAlreadyInput(inDto.getTxtID_Date_DaibenkinHaraikomiYear())
                                || false == isAlreadyInput(inDto.getDrpID_Date_DaibenkinHaraikomiMonth())
                                || false == isAlreadyInput(inDto.getDrpID_Date_DaibenkinHaraikomiDay())) {
                            // 代弁金払込日の年、月、日が全て指定されていない場合、エラーとする。
                            // エラーID：PM3120E
                            // 項目名：代弁金払込日
                            errMsg = "代弁金払込日";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // （４）送金日のチェック
                        if (false == isAlreadyInput(inDto.getTxtID_M_KariukeIppanJuto())
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_KariukeIppanJuto())) {
                            // ①仮受金(一般口)からの充当額が０または未入力の場合
                            if (false == isAlreadyInput(inDto.getDrpID_Date_SokinGengou())
                                    || false == isAlreadyInput(inDto.getTxtID_Date_SokinYear())
                                    || false == isAlreadyInput(inDto.getDrpID_Date_SokinMonth())
                                    || false == isAlreadyInput(inDto.getDrpID_Date_SokinDay())) {
                                // ・送金日の元号、年、月、日が全て指定されていない場合、エラーとする。
                                // エラーID：PM3120E
                                // 項目名：送金日
                                errMsg = "送金日";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                            isInputDateSokin = true;
                            if (false == isAlreadyInput(inDto.getTxtID_ID_Sokinbi())) {
                                // ・送金日番号が未入力の場合、エラーとする。
                                // エラーID：PM3120E
                                // 項目名：送金日番号
                                errMsg = "送金日番号";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                        } else {
                            if (false == PNStringChecker.isAllHalfNumber(inDto.getTxtID_M_KariukeIppanJuto()
                                    .replaceAll(",", ""))) {
                                errMsg = "仮受金(一般口)からの充当額は半角数字";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                            // ②仮受金(一般口)からの充当額が入力されている場合
                            if (true == isAlreadyInput(inDto.getDrpID_Date_SokinGengou())
                                    || true == isAlreadyInput(inDto.getTxtID_Date_SokinYear())
                                    || true == isAlreadyInput(inDto.getDrpID_Date_SokinMonth())
                                    || true == isAlreadyInput(inDto.getDrpID_Date_SokinDay())) {
                                // ・送金日の元号、年、月、日が指定されている場合、エラーとする。
                                isInputDateSokin = true;
                                // エラーID：PM3320E
                                // 項目名：送金日
                                errMsg = "送金日";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3320E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                            isInputDateSokin = false;
                            if (true == isAlreadyInput(inDto.getTxtID_ID_Sokinbi())) {
                                // ・送金日番号が入力されている場合、エラーとする。
                                // エラーID：PM3440E
                                // 項目名：送金日番号
                                errMsg = "送金日番号";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3440E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                        }

                        // 入力桁数チェック
                        // （１）送金日のチェック
                        if (isInputDateSokin) {
                            PNCheckDay testSokinDay = new PNCheckDay(
                                    inDto.getDrpID_Date_SokinGengou(),
                                    String.format("%1$02d", Integer.parseInt(inDto.getTxtID_Date_SokinYear())),
                                    String.format("%1$02d",
                                            Integer.parseInt(inDto.getDrpID_Date_SokinMonth())), String
                                            .format("%1$02d",
                                                    Integer.parseInt(inDto.getDrpID_Date_SokinDay())),
                                    pnCommonDBComponents, bizErrors);
                            if (false == isAlreadyInput(inDto.getTxtID_M_KariukeIppanJuto())
                                    || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_KariukeIppanJuto())) {
                                // ①仮受金(一般口)からの充当額が０または未入力の場合
                                // 送金日の必須チェックがエラーでない場合
                                // 値がS64の場合はエラーとする
                                // エラーID：PM3290E
                                // 項目名：送金日
                                errMsg = "送金日";
                                testSokinDay.addErrorS64(PNCommonMessageConstants.PM3291E,
                                        new String[]{errMsg});
                                if (0 < bizErrors.size()) {
                                    // チェック結果がエラーの場合
                                    inDto.setBizErrors(bizErrors);
                                    break;
                                }
                                // チェック結果が正常の場合
                                // 共通処理の和暦有効日付チェックにて送金日（元号）（年）（月）（日）をチェックする。チェックエラーの場合、エラーとする。
                                // エラーID：PM3140E
                                // 項目名：送金日
                                errMsg = "送金日は有効な日付";
                                testSokinDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                                        new String[]{errMsg});
                                if (0 < bizErrors.size()) {
                                    // チェック結果がエラーの場合
                                    inDto.setBizErrors(bizErrors);
                                    break;
                                }
                            }
                        }
                        // （２）充当対象払込期日のチェック
                        // ①充当対象払込期日の必須チェックがエラーでない場合
                        PNCheckDay testJutoTaishoDay = new PNCheckDay(inDto.getDrpID_Date_JutoTaishoGengou(),
                                inDto.getTxtID_Date_JutoTaishoYear(), inDto.getDrpID_Date_JutoTaishoMonth(),
                                inDto.getDrpID_Date_JutoTaishoDay(), pnCommonDBComponents, bizErrors);
                        // 値がS64の場合はエラーとする
                        // エラーID：PM3290E
                        // 項目名：充当対象払込期日
                        errMsg = "充当対象払込期日";
                        testJutoTaishoDay.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{errMsg});
                        if (0 < bizErrors.size()) {
                            // チェック結果がエラーの場合
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // チェック結果が正常の場合
                        // 共通処理の和暦有効日付チェックにて充当対象払込期日（元号）（年）（月）（日）をチェックする。チェックエラーの場合、エラーとする。
                        // エラーID：PM3140E
                        // 項目名：充当対象払込期日
                        errMsg = "充当対象払込期日は有効な日付";
                        testJutoTaishoDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                                new String[]{errMsg});
                        if (0 < bizErrors.size()) {
                            // チェック結果がエラーの場合
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // （３）代弁金払込日のチェック
                        // ①代弁金払込日の必須チェック／入力チェックがエラーでない場合
                        PNCheckDay testDaibenkinDay = new PNCheckDay(
                                inDto.getDrpID_Date_DaibenkinHaraikomiGengou(),
                                inDto.getTxtID_Date_DaibenkinHaraikomiYear(),
                                inDto.getDrpID_Date_DaibenkinHaraikomiMonth(),
                                inDto.getDrpID_Date_DaibenkinHaraikomiDay(), pnCommonDBComponents, bizErrors);
                        // 値がS64の場合はエラーとする
                        // エラーID：PM3290E
                        // 項目名：代弁金払込日
                        errMsg = "代弁金払込日";
                        testDaibenkinDay.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{errMsg});
                        if (0 < bizErrors.size()) {
                            // チェック結果がエラーの場合
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // チェック結果が正常の場合
                        // 共通処理の和暦有効日付チェックにて代弁金払込日（元号）（年）（月）（日）をチェックする。チェックエラーの場合、エラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3140E
                        // 項目名：代弁金払込日
                        errMsg = "代弁金払込日は有効な日付";
                        testDaibenkinDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                                new String[]{errMsg});
                        if (0 < bizErrors.size()) {
                            // チェック結果がエラーの場合
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // 固有チェック
                        // 代弁金払込日を西暦に変換してチェックを行う。
                        String seirekiDaibenkinHaraikomiYYYY = PNCommonComponents
                                .dateFmtJC_Gyy(PNCommonComponents.concatString(inDto
                                        .getDrpID_Date_DaibenkinHaraikomiGengou(), String.format("%1$02d",
                                        Integer.parseInt(inDto.getTxtID_Date_DaibenkinHaraikomiYear()))));
                        String seirekiDaibenkinHaraikomi = PNCommonComponents.concatString(
                                seirekiDaibenkinHaraikomiYYYY,
                                String.format("%1$02d",
                                        Integer.parseInt(inDto.getDrpID_Date_DaibenkinHaraikomiMonth())),
                                String.format("%1$02d",
                                        Integer.parseInt(inDto.getDrpID_Date_DaibenkinHaraikomiDay())));
                        // （１）代弁金払込日のチェック
                        // ①代弁金払込日の必須チェック／入力桁数チェックがエラーでない場合
                        // 共通部品にて営業日チェックを行い、非営業日の場合はエラーとする。
                        // エラーID：PM3330E
                        // 項目名：代弁金払込日
                        errMsg = "代弁金払込日は";
                        testDaibenkinDay.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E,
                                new String[]{errMsg});
                        if (0 < bizErrors.size()) {
                            // チェック結果がエラーの場合
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // チェック結果が正常の場合
                        // 固有チェックがエラーでない場合
                        if (Integer.parseInt(seirekiDaibenkinHaraikomi) > Integer.parseInt(nowDate)) {
                            // 代弁金払込日＞業務日付の場合はエラーとする。
                            // チェック結果がエラーの場合
                            // エラーID：PM3260E
                            // 項目名：代弁金払込日
                            errMsg = "代弁金払込日が本日の日付";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // （２）充当対象払込期日のチェック
                        // ①充当対象払込期日の必須チェック／入力桁数チェックがエラーでない場合
                        // 充当対象払込期日の年、月、日が全て指定されている場合
                        // 充当対象払込期日を西暦に変換してチェックを行う。
                        String seirekiJutoTaishoYYYY = PNCommonComponents.dateFmtJC_Gyy(PNCommonComponents
                                .concatString(
                                        inDto.getDrpID_Date_JutoTaishoGengou(),
                                        String.format("%1$02d",
                                                Integer.parseInt(inDto.getTxtID_Date_JutoTaishoYear()))));
                        int seirekiJutoTaisho = Integer.parseInt(PNCommonComponents.concatString(
                                seirekiJutoTaishoYYYY, String.format("%1$02d",
                                        Integer.parseInt(inDto.getDrpID_Date_JutoTaishoMonth())), String
                                        .format("%1$02d",
                                                Integer.parseInt(inDto.getDrpID_Date_JutoTaishoDay()))));
                        if (seirekiJutoTaisho > Integer.parseInt(nowDate)) {
                            // 充当対象払込期日＞業務日付の場合はエラーとする。
                            // チェック結果がエラーの場合
                            // エラーID：PM3260E
                            // 項目名：充当対象払込期日
                            errMsg = "充当対象払込期日が本日の日付";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // （３）送金日のチェック
                        if (isInputDateSokin) {
                            PNCheckDay testSokinDay = new PNCheckDay(
                                    inDto.getDrpID_Date_SokinGengou(),
                                    String.format("%1$02d", Integer.parseInt(inDto.getTxtID_Date_SokinYear())),
                                    String.format("%1$02d",
                                            Integer.parseInt(inDto.getDrpID_Date_SokinMonth())), String
                                            .format("%1$02d",
                                                    Integer.parseInt(inDto.getDrpID_Date_SokinDay())),
                                    pnCommonDBComponents, bizErrors);
                            // ①送金日の必須チェック／入力桁数チェックがエラーでない場合
                            // 仮受金(一般口)からの充当額が０または未入力の場合
                            if (false == isAlreadyInput(inDto.getTxtID_M_KariukeIppanJuto())
                                    || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_KariukeIppanJuto())) {
                                // ①仮受金(一般口)からの充当額が０または未入力の場合
                                // 送金日の元号、年、月、日が全て指定されている場合
                                // エラーID：PM3330E
                                // 項目名：送金日
                                errMsg = "送金日は";
                                testSokinDay.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E,
                                        new String[]{errMsg});
                                if (0 < bizErrors.size()) {
                                    // チェック結果がエラーの場合
                                    inDto.setBizErrors(bizErrors);
                                    break;
                                }
                            }
                        }
                        // （４）元金のチェック
                        BigDecimal gankin = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_Gankin())) {
                            // 元金が入力されている場合、属性チェック
                            if (false == PNStringChecker.isAllHalfNumber(inDto.getTxtID_M_Gankin()
                                    .replaceAll(",", ""))) {
                                errMsg = "元金は半角数字";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                            // エラーでない場合
                            gankin = new BigDecimal(inDto.getTxtID_M_Gankin().replaceAll(",", ""));
                        }
                        // // 退避貸付金残高
                        BigDecimal keepMKashitsukeZan = BigDecimal.ZERO;
                        if (null != inDto.getKeep_M_KashitsukeZan()) {
                            keepMKashitsukeZan = inDto.getKeep_M_KashitsukeZan();
                        }
                        if (false == BigDecimal.ZERO.equals(gankin)) {
                            // ①元金が０でない場合
                            if (keepMKashitsukeZan.doubleValue() < gankin.doubleValue()) {
                                // 退避貸付金残高＜元金　の場合はエラーとする。
                                // チェック結果がエラーの場合
                                // エラーID：PM3180E
                                // 項目名：元金
                                errMsg = "元金が退避貸付金残高";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                        }

                        // （５）ここまでのチェックがエラーでない場合
                        // ①代位弁済金払込・充当報告書固有入力データの計算チェック
                        // 利息／元金／遅延損害金／繰上償還手数料のすべての項目が、"空欄"または"０円"の場合はエラーとする。
                        boolean risokuErrFlg = (false == isAlreadyInput(inDto.getTxtID_M_Risoku()))
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_Risoku());
                        boolean gankinErrFlg = (false == isAlreadyInput(inDto.getTxtID_M_Gankin()))
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_Gankin());
                        boolean chienSongaiErrFlg = (false == isAlreadyInput(inDto.getTxtID_M_ChienSongai()))
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_ChienSongai());
                        boolean kurishoCommissionErrFlg = (false == isAlreadyInput(inDto
                                .getTxtID_M_KurishoCommission()))
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_KurishoCommission());
                        if (risokuErrFlg && gankinErrFlg && chienSongaiErrFlg && kurishoCommissionErrFlg) {
                            // チェック結果がエラーの場合
                            // エラーID：PM3120E
                            // 項目名：利息，元金，遅延損害金，繰上償還手数料
                            errMsg = "利息，元金，遅延損害金，繰上償還手数料";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // チェック結果がエラーでない場合
                        // 属性チェック
                        if (false == PNStringChecker.isAllHalfNumber(inDto.getTxtID_M_Risoku().replaceAll(
                                ",", ""))) {
                            errMsg = "利息は半角数字";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        if (false == PNStringChecker.isAllHalfNumber(inDto.getTxtID_M_ChienSongai()
                                .replaceAll(",", ""))) {
                            errMsg = "遅延損害金は半角数字";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        if (false == PNStringChecker.isAllHalfNumber(inDto.getTxtID_M_KurishoCommission()
                                .replaceAll(",", ""))) {
                            errMsg = "繰上償還手数料は半角数字";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                        // チェック結果がエラーでない場合
                        // 利息
                        BigDecimal risoku = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_Risoku())) {
                            risoku = new BigDecimal(inDto.getTxtID_M_Risoku().replaceAll(",", ""));
                        }
                        // 元金
                        gankin = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_Gankin())) {
                            gankin = new BigDecimal(inDto.getTxtID_M_Gankin().replaceAll(",", ""));
                        }
                        // 遅延損害金
                        BigDecimal chienSongai = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_ChienSongai())) {
                            chienSongai = new BigDecimal(inDto.getTxtID_M_ChienSongai().replaceAll(",", ""));
                        }
                        // 繰上償還手数料
                        BigDecimal kurishoCommission = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_KurishoCommission())) {
                            kurishoCommission = new BigDecimal(inDto.getTxtID_M_KurishoCommission()
                                    .replaceAll(",", ""));
                        }
                        // 計を（利息＋元金＋遅延損害金＋繰上償還手数料）で更新する。
                        inDto.setTxtID_M_Kei(risoku.add(gankin).add(chienSongai).add(kurishoCommission)
                                .toString());
                        if (false == isAlreadyInput(inDto.getTxtID_M_KariukeIppanJuto())
                                || Md005Constants.STR_ZERO.equals(inDto.getTxtID_M_KariukeIppanJuto())) {
                            // 仮受金(一般口)からの充当額が０または未入力の場合
                            if (true == isAlreadyInput(inDto.getTxtID_ID_Sokinbi())) {
                                // 送金日番号が入力されている場合
                                // 送金額を計で更新する。
                                inDto.setTxtID_M_Sokin(inDto.getTxtID_M_Kei());
                            }
                        } else {
                            // 仮受金(一般口)からの充当額が入力されている場合
                            // 計－仮受金(一般口)からの充当額が０以外の場合はエラーとする。
                            BigDecimal kei = BigDecimal.ZERO;
                            if (true == isAlreadyInput(inDto.getTxtID_M_Kei())) {
                                kei = new BigDecimal(inDto.getTxtID_M_Kei().replaceAll(",", ""));
                            }
                            BigDecimal kariukeIppanJuto = new BigDecimal(inDto.getTxtID_M_KariukeIppanJuto()
                                    .replaceAll(",", ""));
                            if (false == BigDecimal.ZERO.equals(kei.subtract(kariukeIppanJuto))) {
                                // チェック結果がエラーの場合
                                // エラーID：PM3470E
                                // 項目名：仮受金(一般口)からの充当額
                                errMsg = "仮受金(一般口)からの充当額";
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3470E,
                                        new String[]{errMsg}, false));
                                inDto.setBizErrors(bizErrors);
                                break;
                            }
                            // チェック結果が正常の場合
                            // 送金額を空文字で更新する。
                            inDto.setTxtID_M_Sokin("");
                        }
                        BigDecimal bdZanGanAfterDaibenJuto = BigDecimal.ZERO;
                        if (true == isAlreadyInput(inDto.getTxtID_M_Gankin())) {
                            // 元金が入力されている場合
                            // 再計算のため、残高は退避してあった金額を使用
                            // 代位金充当後残元金を退避貸付金残高で更新する。
                            if (true == isAlreadyInput(inDto.getID_Keep_M_KashitsukeZan())) {
                                bdZanGanAfterDaibenJuto = new BigDecimal(inDto.getID_Keep_M_KashitsukeZan());
                            }
                        }
                        // 代位金充当後残元金を代位金充当後残元金－元金で更新する。
                        inDto.setTxtID_M_ZanGanAfterDaibenJuto(bdZanGanAfterDaibenJuto.subtract(gankin)
                                .toString());
                        // 扱店別稟議データに登録を行う払込前残元金を代位金充当後残元金で更新する。
                        inDto.setID_M_KashitsukeZandaka_aRingi(inDto.getTxtID_M_ZanGanAfterDaibenJuto());

                        // 処理モードが（処理完了以外：修正または処理完了：修正）かつ、修正データチェックフラグが「チェックする」の場合
                        if (Md005Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())
                                || Md005Constants.PROCESS_MODE_2.equals(inDto.getProcessMode())) {
                            // 代位弁済金払込・充当報告書固有入力データのDBチェック
                            // 修正データチェックフラグが「チェックする」の場合
                            // １．ここまでのチェックがエラーでない場合
                            if (false == BigDecimal.ZERO.equals(risoku)
                                    || false == BigDecimal.ZERO.equals(gankin)) {
                                // ①利息／元金のどちらかに０以外が入力されている場合
                                if (true == isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
                                    // 退避約定利息がある場合
                                    // 請求データの約定利息を請求データに登録を行う約定利息で更新する。
                                    inDto.setID_M_YakujoRisoku_Seikyu(inDto.getID_Keep_M_YakujoRisoku());
                                }
                                if (true == isAlreadyInput(inDto.getID_Keep_M_YakujoGankin())) {
                                    // 退避約定元金がある場合
                                    // 請求データの約定元金を請求データに登録を行う約定元金で更新する。
                                    inDto.setID_M_YakujoGankin_Yakujo(inDto.getID_Keep_M_YakujoGankin());
                                }
                                if (true == isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku())) {
                                    // 退避請求繰償利息がある場合
                                    // 請求データの請求繰償利息を請求データに登録を行う請求繰償利息で更新する。
                                    inDto.setID_Seikyu_M_SeiKuriRisoku(inDto
                                            .getID_Keep_Seikyu_M_SeiKuriRisoku());
                                }
                                if (true == isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin())) {
                                    // 退避請求繰償元金がある場合
                                    // 請求データの請求繰償元金を請求データに登録を行う請求繰償元金で更新する。
                                    inDto.setID_Seikyu_M_SeiKuriGankin(inDto
                                            .getID_Keep_Seikyu_M_SeiKuriGankin());
                                }
                                if (true == isAlreadyInput(inDto.getTxtID_M_Risoku())) {
                                    // 利息が入力されている場合
                                    BigDecimal yakujoRisokuSeikyu = BigDecimal.ZERO;
                                    if (true == isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                                        yakujoRisokuSeikyu = new BigDecimal(
                                                inDto.getID_M_YakujoRisoku_Seikyu());
                                    }
                                    // risoku = new BigDecimal(
                                    // inDto.getTxtID_M_Risoku());
                                    // 請求データの請求繰償利息
                                    BigDecimal seiKuriRisoku = BigDecimal.ZERO;
                                    if (true == isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                                        seiKuriRisoku = new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku());
                                    }
                                    if (0 < seiKuriRisoku.doubleValue()) {
                                        // 請求データの請求繰償利息が０より大きい場合
                                        if (risoku.doubleValue() > seiKuriRisoku.doubleValue()) {
                                            // 入力された利息が請求データの請求繰償利息より大きい場合
                                            if (risoku.subtract(seiKuriRisoku).doubleValue() > yakujoRisokuSeikyu
                                                    .doubleValue()) {
                                                // （入力された利息－請求データの請求繰償利息）＞請求データの約定利息の場合はエラーとする。
                                                // チェック結果がエラーの場合
                                                // エラーID：PM3180E
                                                // 項目名：利息
                                                errMsg = "利息－請求データの請求繰償利息の値が請求データの約定利息";
                                                bizErrors.add(new PNMessageInfo(
                                                        PNCommonMessageConstants.PM3180E,
                                                        new String[]{errMsg}, false));
                                                inDto.setBizErrors(bizErrors);
                                                break;
                                            }
                                            // チェック結果が正常の場合
                                            // 請求データに登録を行う約定利息を（請求データの約定利息－（入力された利息－請求データの請求繰償利息））で更新する。
                                            BigDecimal bdRisoku = risoku.subtract(seiKuriRisoku);
                                            inDto.setID_M_YakujoRisoku_Seikyu(yakujoRisokuSeikyu.subtract(
                                                    bdRisoku).toString());
                                            // 請求データに登録を行う請求繰償利息を'0'で更新する。
                                            inDto.setID_Seikyu_M_SeiKuriRisoku("0");
                                        } else {
                                            // 入力された利息が請求データの請求繰償利息より大きくない場合
                                            // 請求データに登録を行う約定利息を請求データの約定利息で更新する。
                                            inDto.setID_M_YakujoRisoku_Seikyu(inDto
                                                    .getID_Keep_M_YakujoRisoku());
                                            // 請求データに登録を行う請求繰償利息を（請求データの請求繰償利息－入力された利息）で更新する。
                                            inDto.setID_Seikyu_M_SeiKuriRisoku(seiKuriRisoku.subtract(risoku)
                                                    .toString());
                                        }
                                    } else {
                                        if (BigDecimal.ZERO.equals(seiKuriRisoku)) {
                                            // 請求データの請求繰償利息が０の場合
                                            BigDecimal keepMYakujoRisoku = BigDecimal.ZERO;
                                            if (true == isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
                                                keepMYakujoRisoku = new BigDecimal(
                                                        inDto.getID_Keep_M_YakujoRisoku());
                                            }
                                            if (risoku.doubleValue() > keepMYakujoRisoku.doubleValue()) {
                                                // 入力された利息＞請求データの約定利息の場合はエラーとする。
                                                // チェック結果がエラーの場合
                                                // エラーID：PM3180E
                                                // 項目名：利息
                                                errMsg = "利息が請求データの約定利息";
                                                bizErrors.add(new PNMessageInfo(
                                                        PNCommonMessageConstants.PM3180E,
                                                        new String[]{errMsg}, false));
                                                inDto.setBizErrors(bizErrors);
                                                break;
                                            }
                                            // チェック結果が正常の場合
                                            // 請求データに登録を行う約定利息を（請求データの約定利息－入力された利息－請求データの請求繰償利息）で更新する。
                                            inDto.setID_M_YakujoRisoku_Seikyu(keepMYakujoRisoku
                                                    .subtract(risoku).subtract(seiKuriRisoku).toString());
                                            // 請求データに登録を行う請求繰償利息を'0'で更新する。
                                            inDto.setID_Seikyu_M_SeiKuriRisoku("0");
                                        }
                                    }
                                }
                                if (true == isAlreadyInput(inDto.getTxtID_M_Gankin())) {
                                    // 元金が入力されている場合
                                    BigDecimal seiKuriGankin = BigDecimal.ZERO;
                                    if (true == isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                                        seiKuriGankin = new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin());
                                    }
                                    BigDecimal yakujoGankinYakujo = BigDecimal.ZERO;
                                    if (true == isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                                        yakujoGankinYakujo = new BigDecimal(
                                                inDto.getID_M_YakujoGankin_Yakujo());
                                    }
                                    if (0 < seiKuriGankin.doubleValue()) {
                                        // 請求データの請求繰償元金が０より大きい場合
                                        if (seiKuriGankin.doubleValue() < gankin.doubleValue()) {
                                            // 入力された元金が請求データの請求繰償元金より大きい場合
                                            if (gankin.subtract(seiKuriGankin).doubleValue() > yakujoGankinYakujo
                                                    .doubleValue()) {
                                                // (入力された元金－請求データの請求繰償元金)＞請求データの約定元金の場合はエラーとする。
                                                // チェック結果がエラーの場合
                                                // エラーID：PM3180E
                                                // 項目名：元金
                                                errMsg = "元金－請求データの請求繰償元金の値が請求データの約定元金";
                                                bizErrors.add(new PNMessageInfo(
                                                        PNCommonMessageConstants.PM3180E,
                                                        new String[]{errMsg}, false));
                                                inDto.setBizErrors(bizErrors);
                                                break;
                                            }
                                            // チェック結果が正常の場合
                                            // 請求データに登録を行う約定元金を（請求データの約定元金－（入力された元金－請求データの請求繰償元金））で更新する。
                                            BigDecimal bdGankin = gankin.subtract(seiKuriGankin);
                                            inDto.setID_M_YakujoGankin_Yakujo(yakujoGankinYakujo.subtract(
                                                    bdGankin).toString());
                                            // 請求データに登録を行う請求繰償元金を'0'で更新する。
                                            inDto.setID_Seikyu_M_SeiKuriGankin("0");
                                        } else {
                                            // 入力された元金が請求データの請求繰償元金以下場合
                                            // 請求データに登録を行う約定元金を請求データの約定元金で更新する。
                                            inDto.setID_M_YakujoGankin_Yakujo(yakujoGankinYakujo.toString());
                                            // 請求データに登録を行う請求繰償元金を（請求データの請求繰償元金－入力された元金）で更新する。
                                            inDto.setID_Seikyu_M_SeiKuriGankin(seiKuriGankin.subtract(gankin)
                                                    .toString());
                                        }
                                    } else {
                                        // 請求データの請求繰償元金が０の場合
                                        if (gankin.doubleValue() > yakujoGankinYakujo.doubleValue()) {
                                            // 入力された元金＞請求データの約定元金の場合はエラーとする。
                                            // チェック結果がエラーの場合
                                            // エラーID：PM3180E
                                            // 項目名：元金
                                            errMsg = "元金が請求データの約定元金";
                                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                                    new String[]{errMsg}, false));
                                            inDto.setBizErrors(bizErrors);
                                            break;
                                        }
                                        // チェック結果が正常の場合
                                        // 請求データに登録を行う約定元金を（請求データの約定元金－入力された元金）で更新する。
                                        inDto.setID_M_YakujoGankin_Yakujo(yakujoGankinYakujo.subtract(gankin)
                                                .toString());
                                        // 請求データに登録を行う請求繰償元金を'0'で更新する。
                                        inDto.setID_Seikyu_M_SeiKuriGankin("0");
                                    }
                                }
                            }
                        }
                    }
                }

                // 報告年月日の年月取得
                String dateReportYYYYMM = inDto.getLblID_Date_Report().substring(0, 6);
                // 受託者勘定処理年月(西暦)
                String seirekiJtkshoriYYYY = "";
                String seirekiJtkshori = "";
                // 代弁金払込日
                int dateDaibenkinHaraikomi = 99999999;
                int dateDaibenkinYYYYMM = 999999;
                // 送金日
                int dateSokin = 0;
                // 送金額入力フラグ(true:入力あり)
                boolean sokinInputFlg = false;
                // 受託者勘定処理年月チェック
                if (Md005Constants.ENTITY_RED.equals(checkPnl)) {
                    // 更正（赤）画面入力データをチェック
                    if (false == isAlreadyInput(inDto.getDrpID_Date_JtkshoriGengou_Red())
                            || false == isAlreadyInput(inDto.getTxtID_Date_JtkshoriYear_Red())
                            || false == isAlreadyInput(inDto.getDrpID_Date_JtkshoriMonth_Red())) {
                        // １．受託者勘定処理年月の年、月が全て指定されているかのチェックを行い、全て指定されていない場合はエラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3140E
                        // 項目名：受託者勘定処理年月
                        errMsg = "受託者勘定処理年月";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // ２．受託者勘定処理年月の年、月が指定されている場合
// [UPD] Ver 2.0.0 - START
//                    PNCheckDay testDaibenkinDay = new PNCheckDay(inDto.getDrpID_Date_JtkshoriGengou_Red(),
//                            inDto.getTxtID_Date_JtkshoriYear_Red(), inDto.getDrpID_Date_JtkshoriMonth_Red(),
//                            "1", pnCommonDBComponents, bizErrors);
                    PNCheckDay testDaibenkinDay = new PNCheckDay(inDto.getDrpID_Date_JtkshoriGengou_Red(),
                            inDto.getTxtID_Date_JtkshoriYear_Red(), inDto.getDrpID_Date_JtkshoriMonth_Red(),
                            "", pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END
                    // （１）S64が指定された場合はエラーとする。
                    // チェック結果がエラーの場合
                    // エラーID：PM3290E
                    // 項目名：受託者勘定処理年月
                    errMsg = "受託者勘定処理年月";
                    testDaibenkinDay.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{errMsg});
                    if (0 < bizErrors.size()) {
                        // チェック結果がエラーの場合
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // （２）ここまでのチェックがエラーでない場合
                    // 共通部品にて日付チェックを行い、有効日でない場合はエラーとする。
                    // チェック結果がエラーの場合 チェック結果がエラーの場合
                    // エラーID：PM3140E
                    // 項目名：受託者勘定処理年月
                    errMsg = "受託者勘定処理年月は有効な日付";
// [UPD] Ver 2.0.0 - START
//                    testDaibenkinDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                            new String[]{errMsg});
                    testDaibenkinDay.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                            new String[] { errMsg });
// [UPD] Ver 2.0.0 - END
                    if (0 < bizErrors.size()) {
                        // チェック結果がエラーの場合
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // （３）ここまでのチェックがエラーでない場合
                    // 受託者勘定処理年月を西暦変換
// [UPD] Ver 2.0.0 - START
//                    seirekiJtkshoriYYYY = PNCommonComponents
//                            .dateFmtJC_Gyy(PNCommonComponents.concatString(
//                                    inDto.getDrpID_Date_JtkshoriGengou_Red(),
//                                    String.format("%1$02d",
//                                            Integer.parseInt(inDto.getTxtID_Date_JtkshoriYear_Red()))));
//                    seirekiJtkshori = PNCommonComponents.concatString(seirekiJtkshoriYYYY, String.format(
//                            "%1$02d", Integer.parseInt(inDto.getDrpID_Date_JtkshoriMonth_Red())));
                    seirekiJtkshori = testDaibenkinDay.getSeireki().substring(0, 6);
// [UPD] Ver 2.0.0 - END
                    if (Integer.parseInt(seirekiJtkshori) > Integer.parseInt(dateReportYYYYMM)) {
                        // 受託者勘定処理年月＞報告日の場合はエラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3260E
                        // 項目名：受託者勘定処理年月
                        errMsg = "受託者勘定処理年月が報告日の年月";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // 代弁金払込日
                    if (isAlreadyInput(inDto.getTxtID_Date_DaibenkinHaraikomi_Red())) {
                        dateDaibenkinHaraikomi = Integer.parseInt(inDto
                                .getTxtID_Date_DaibenkinHaraikomi_Red());
                        dateDaibenkinYYYYMM = Integer.parseInt(inDto.getTxtID_Date_DaibenkinHaraikomi_Red()
                                .substring(0, 6));
                    }
                    // 送金日
                    if (isAlreadyInput(inDto.getTxtID_Date_Sokin_Red())) {
                        dateSokin = Integer.parseInt(inDto.getTxtID_Date_Sokin_Red());
                    }
                    // 送金額入力フラグ
                    sokinInputFlg = isAlreadyInput(inDto.getTxtID_M_Sokin_Red());
                } else {
                    // 更正（黒）画面入力データをチェック
                    if (false == isAlreadyInput(inDto.getDrpID_Date_JtkshoriGengou())
                            || false == isAlreadyInput(inDto.getTxtID_Date_JtkshoriYear())
                            || false == isAlreadyInput(inDto.getDrpID_Date_JtkshoriMonth())) {
                        // １．受託者勘定処理年月の年、月が全て指定されているかのチェックを行い、全て指定されていない場合はエラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3140E
                        // 項目名：受託者勘定処理年月
                        errMsg = "受託者勘定処理年月";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // ２．受託者勘定処理年月の年、月が指定されている場合
// [UPD] Ver 2.0.0 - START
//                    PNCheckDay testDaibenkinDay = new PNCheckDay(inDto.getDrpID_Date_JtkshoriGengou(),
//                            inDto.getTxtID_Date_JtkshoriYear(), inDto.getDrpID_Date_JtkshoriMonth(), "1",
//                            pnCommonDBComponents, bizErrors);
                    PNCheckDay testDaibenkinDay = new PNCheckDay(inDto.getDrpID_Date_JtkshoriGengou(),
                            inDto.getTxtID_Date_JtkshoriYear(), inDto.getDrpID_Date_JtkshoriMonth(), "",
                            pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END
                    // （１）S64が指定された場合はエラーとする。
                    // チェック結果がエラーの場合
                    // エラーID：PM3290E
                    // 項目名：受託者勘定処理年月
                    errMsg = "受託者勘定処理年月";
                    testDaibenkinDay.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{errMsg});
                    if (0 < bizErrors.size()) {
                        // チェック結果がエラーの場合
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // 項目名：受託者勘定処理年月
                    // （２）ここまでのチェックがエラーでない場合
                    // 共通部品にて日付チェックを行い、有効日でない場合はエラーとする。
                    // チェック結果がエラーの場合 チェック結果がエラーの場合
                    // エラーID：PM3140E
                    // 項目名：受託者勘定処理年月
                    errMsg = "受託者勘定処理年月は有効な日付";
// [UPD] Ver 2.0.0 - START
//                    testDaibenkinDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                    new String[]{errMsg});
                    testDaibenkinDay.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                            new String[] { errMsg });
// [UPD] Ver 2.0.0 - END
                    if (0 < bizErrors.size()) {
                        // チェック結果がエラーの場合
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // （３）ここまでのチェックがエラーでない場合
                    // 受託者勘定処理年月を西暦変換
// [UPD] Ver 2.0.0 - START
//                    seirekiJtkshoriYYYY = PNCommonComponents.dateFmtJC_Gyy(PNCommonComponents.concatString(
//                            inDto.getDrpID_Date_JtkshoriGengou(),
//                            String.format("%1$02d", Integer.parseInt(inDto.getTxtID_Date_JtkshoriYear()))));
//                    seirekiJtkshori = PNCommonComponents.concatString(seirekiJtkshoriYYYY,
//                            String.format("%1$02d", Integer.parseInt(inDto.getDrpID_Date_JtkshoriMonth())));
                    seirekiJtkshoriYYYY = testDaibenkinDay.getSeireki().substring(0, 4);
                    seirekiJtkshori = testDaibenkinDay.getSeireki().substring(0, 6);
// [UPD] Ver 2.0.0 - END
                    if (Integer.parseInt(seirekiJtkshori) > Integer.parseInt(dateReportYYYYMM)) {
                        // 受託者勘定処理年月＞報告日の場合はエラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3260E
                        // 項目名：受託者勘定処理年月
                        errMsg = "受託者勘定処理年月が報告日の年月";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // 代弁金払込日
                    String daibenkinHaraikomiYYYY = PNCommonComponents.dateFmtJC_Gyy(PNCommonComponents
                            .concatString(
                                    inDto.getDrpID_Date_DaibenkinHaraikomiGengou(),
                                    String.format("%1$02d",
                                            Integer.parseInt(inDto.getTxtID_Date_DaibenkinHaraikomiYear()))));
                    String daibenkinHaraikomi = PNCommonComponents.concatString(
                            daibenkinHaraikomiYYYY,
                            String.format("%1$02d",
                                    Integer.parseInt(inDto.getDrpID_Date_DaibenkinHaraikomiMonth())),
                            String.format("%1$02d",
                                    Integer.parseInt(inDto.getDrpID_Date_DaibenkinHaraikomiDay())));
                    if (isAlreadyInput(daibenkinHaraikomi)
                            && Md005Constants.LENGTH_8 == daibenkinHaraikomi.length()) {
                        dateDaibenkinHaraikomi = Integer.parseInt(daibenkinHaraikomi);
                        dateDaibenkinYYYYMM = Integer.parseInt(daibenkinHaraikomi.substring(0, 6));
                    }
                    // 送金日
                    String sokinYYYY = "";
                    String sokinBi = "";
                    if (isInputDateSokin) {
                        sokinYYYY = PNCommonComponents.dateFmtJC_Gyy(PNCommonComponents.concatString(
                                inDto.getDrpID_Date_SokinGengou(),
                                String.format("%1$02d", Integer.parseInt(inDto.getTxtID_Date_SokinYear()))));
                        sokinBi = PNCommonComponents.concatString(sokinYYYY,
                                String.format("%1$02d", Integer.parseInt(inDto.getDrpID_Date_SokinMonth())),
                                String.format("%1$02d", Integer.parseInt(inDto.getDrpID_Date_SokinDay())));
                    }
                    if (isAlreadyInput(sokinBi) && Md005Constants.LENGTH_8 == sokinBi.length()) {
                        dateSokin = Integer.parseInt(sokinBi);
                    }
                    // 送金額入力フラグ
                    sokinInputFlg = isAlreadyInput(inDto.getTxtID_M_Sokin());
                }

                // チェック結果が正常の場合
                if (Md005Constants.MOD_DATA_CHECK == checkModFlag) {
                    // 修正データチェックフラグが「チェックする」の場合
                    // 共通部品より年度末日の取得を行う。
                    String nendoMatsuBi = PNCommonComponents.getNendoMatsujitu(seirekiJtkshoriYYYY,
                            String.format("%1$02d", Integer.parseInt(inDto.getDrpID_Date_JtkshoriMonth())));
                    int nendoMatsu = Integer.parseInt(nendoMatsuBi.replaceAll("/", ""));
                    int nendoMatsuYYYYMM = Integer.parseInt(nendoMatsuBi.replaceAll("/", "").substring(0, 6));
                    // 以下の判定を行う
                    // 留置金フラグ（true:留意金である）
                    boolean isRyuuiKin = false;
                    if (sokinInputFlg && (dateDaibenkinHaraikomi <= nendoMatsu && dateSokin > nendoMatsu)) {
                        // ① 送金額が入力されている、かつ　
                        // ② 代弁金払込日 ＜＝ 年度末日 かつ 送金日 ＞ 年度末日であること。
                        // 正常の場合、留意金と判定する。
                        isRyuuiKin = true;
                    }
                    // 決算整理日付（共通部品）の取得を行う。
                    String kessanbi = pnCommonDBComponents.getKessanbi();
                    if (false == isAlreadyInput(kessanbi)) {
                        // 取得した決算整理日付の値が無い場合はエラーとする。
                        // チェック結果がエラーの場合
                        // 留置金でないと判定する。
                        isRyuuiKin = false;
                        // エラーID：PM3190E
                        // 項目名：受託者勘定処理年月
                        errMsg = "決算整理日付";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                    // チェック結果が正常の場合
                    if (nendoMatsu >= Integer.parseInt(nowDate)
                            || Integer.parseInt(nowDate) >= Integer.parseInt(kessanbi)) {
                        // 年度末日＞＝報告書作成日(業務日付) 　or　
                        // 報告書作成日(業務日付)＞＝決算整理日付の場合はエラーとする。
                        // チェック結果がエラーの場合
                        // 留置金でないと判定する。
                        isRyuuiKin = false;
                    }
                    if (isRyuuiKin) {
                        // 留意金の場合
                        if (Integer.parseInt(seirekiJtkshori) > dateDaibenkinYYYYMM) {
                            // 受託者勘定処理年月＞代弁金払込日年月の場合はエラーとする。
                            // チェック結果がエラーの場合
                            // エラーID：PM3260E
                            // 項目名：受託者勘定処理年月（留置金）
                            errMsg = "受託者勘定処理年月（留置金）";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                    } else {
                        // 留意金でない場合
                        if (Integer.parseInt(seirekiJtkshori) < dateDaibenkinYYYYMM) {
                            // 受託者勘定処理年月＜代弁金払込日年月の場合はエラーとする。
                            // チェック結果がエラーの場合
                            // エラーID：PM3140E
                            // 項目名：受託者勘定処理年月
                            errMsg = "受託者勘定処理年月は代弁金払込日以降";
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[]{errMsg}, false));
                            inDto.setBizErrors(bizErrors);
                            break;
                        }
                    }
                    if (Integer.parseInt(seirekiJtkshori) < nendoMatsuYYYYMM
                            && Integer.parseInt(inDto.getLblID_Date_Report()) > Integer.parseInt(kessanbi)) {
                        // 受託者勘定処理年月＜年度末以前　かつ 報告日＞本店決算整理日付の場合はエラーとする。
                        // チェック結果がエラーの場合
                        // エラーID：PM3810E
                        // 項目名：受託者勘定処理年月
                        errMsg = "受託者勘定処理年月";
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3810E,
                                new String[]{errMsg}, false));
                        inDto.setBizErrors(bizErrors);
                        break;
                    }
                }
                // （４）ここまでのチェックがエラーでない場合
                // 受託者勘定処理年月を受託者勘定処理年月(年)＋受託者勘定処理年月(月)で更新する。
                if (Md005Constants.ENTITY_RED.equals(checkPnl)) {
                    // 更正（赤）画面入力データをチェック
                    inDto.setTxtID_Date_Jtkshori_Red(seirekiJtkshori);
                } else {
                    inDto.setTxtID_Date_Jtkshori(seirekiJtkshori);
                }
            }
            // 繰り返しEnd
        }

        return inDto;
    }

    /**
     *
     * <pre>
     * 入力済みかどうか判定する
     * </pre>
     *
     * @param strVal 判定対象文字列
     * @return false:nullまたは空白 true:null以外かつ空白以外
     */
    private boolean isAlreadyInput(String strVal) {
        // 戻り値初期化
        boolean ret = true;

        // 引数のチェック
        if (null == strVal) {
            // 引数がnullの場合、戻り値にfalseを設定
            ret = false;
        } else if (0 == strVal.trim().length()) {
            // 引数が未入力の場合、戻り値にfalseを設定
            ret = false;
        }

        // 戻り値返却
        return ret;
    }

}