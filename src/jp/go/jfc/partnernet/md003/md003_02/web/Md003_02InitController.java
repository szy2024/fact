//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_02.web;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.md001.common.Md001Constants;
import jp.go.jfc.partnernet.md003.common.Md003Constants;
import jp.go.jfc.partnernet.md003.md003_02.service.Md003_02DTO;
import jp.go.jfc.partnernet.md003.md003_02.service.Md003_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNMessageUtils;

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
 * このクラスはmd003_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md003_02Form")
@RequestMapping(value = "/Md003_02Init.form")
public class Md003_02InitController extends Md003_02BaseController {

    /** Md003_02Service */
    @Autowired
    Md003_02Service md003_02service;
    /** PNCommonDBComponents */
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
    public String executeAction(Model model, Md003_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);
        setRequestScreen(form, paramMap);

        // DTOの生成
        Md003_02DTO outDto = new Md003_02DTO();

        // 画面の項目をDTO項目に設定する。
        CFWBeanUtils.copyProperties(outDto, form);

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // 画面に表示するメッセージの作成
        // 　　画面メッセージに、PM1010Iを設定する。
        form.setLblComment(PNMessageUtils.getString(PNCommonMessageConstants.PM1010I));

        // 処理モード */
        String processMode = form.getProcessMode();

        if (Md003Constants.PROCESS_MODE_5.equals(processMode)) {
            // 処理種別が処理完了以外：更正(赤)取消の場合
            // 　一覧画面データの取得をする。
            // 　　サービスを実行し、一覧画面データを取得する。
            // 　　　Md003_02Service.getResultsData // DTOの生成
            // Md003_02DTO inMd003_02DTO = new Md003_02DTO();
            Md003_02DTO inDto = new Md003_02DTO();
            // Serviceの呼び出し
            // Md003_02DTO outMd003_02DTO =
            // md003_02service.getResultsData(inMd003_02DTO);

            // 報告書番号
            inDto.setID_ID_Report((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_REPORT));
            Md003_02DTO outDto2 = md003_02service.getResultsData(inDto);
            CFWBeanUtils.copyProperties(form, outDto2);

            // 　　　取得したデータを初期データに格納する。
            form.setID_ID_Report_Pri(outDto2.getID_ID_Report_Red());
            form.setID_ID_Report_H(outDto2.getID_ID_Report_Red());
            form.setID_Keep_ID_History_Pri(outDto2.getID_Keep_ID_History_Red());

            // 処理モード
            form.setProcessMode(processMode);
        }

        // 「戻る」ボタンメッセージの作成
        // 　処理モードが処理完了以外：更正(赤)取消の場合
        // 　　戻るメッセージに「取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        // 　　戻るボタンのToolTipに、「元利金受入・充当報告書の取消・修正の入力画面へ戻る」を設定する。
        // 　処理モードが処理完了以外：更正(赤)取消以外の場合
        // 　　戻るメッセージに「繰上償還受入・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        if (Md003Constants.PROCESS_MODE_5.equals(processMode)) {
            form.setVisible("lblBack_Normal", true);
            form.setVisible("lblBack_DelCancel", false);
        } else {
            form.setVisible("lblBack_Normal", false);
            form.setVisible("lblBack_DelCancel", true);
        }

        // 受渡パラメータの処理モードにより画面表示タイプを決定する。

        // 画面表示タイプが修正画面の場合
        // 　DTO項目(修正)を黒データ入力領域に設定する。
        // 画面表示タイプが取消画面の場合
        // 　DTO項目を 赤データ入力領域に設定する。

        // 受渡パラメータの処理種別により画面表示タイプを決定する。
        if (Md003Constants.PROCESS_MODE_1.equals(processMode)) {
            // 処理モード(値)が処理完了：取消(1)の場合
            // パネル内のヘッダーに「更正」を設定
            form.setLblID_Head_Red(Md003Constants.STR_MOD);
        }
        if (Md003Constants.PROCESS_MODE_3.equals(processMode)
                || Md003Constants.PROCESS_MODE_5.equals(processMode)) {
            // 処理モード(値)が処理完了：処理完了以外：取消(3)または処理完了以外：更正（赤）取消(5)の場合
            // パネル内のヘッダーに「取消内容」を設定
            form.setLblID_Head_Red(Md003Constants.STR_CANCEL);
        }
        if (Md003Constants.PROCESS_MODE_2.equals(processMode)) {
            // 処理モード(値)が処理完了：修正(2)の場合
            // パネル内のヘッダーに「更正」を設定
            form.setLblID_Head_Red(Md003Constants.STR_MOD);
            // パネル内のヘッダーに「更正 黒」を設定
            form.setLblID_Head(PNCommonComponents.concatString(Md003Constants.STR_MOD,
                    Md003Constants.STR_BLACK));
        }
        if (Md003Constants.PROCESS_MODE_4.equals(processMode)) {
            // 処理モード(値)が処理完了：修正(2)または処理完了以外：修正(4)の場合
            // パネル内のヘッダーに「修正内容 」を設定
            form.setLblID_Head(Md003Constants.STR_UPD);
        }

        // 代弁履行後の作成のチェックボックスの設定
        // 処理モード(値)が処理完了：修正(2)または処理完了以外：修正(4)の場合
        // 受け渡された代弁履行後の作成のチェックとする。
        if (Md003Constants.PROCESS_MODE_2.equals(processMode)
                || Md003Constants.PROCESS_MODE_4.equals(processMode)) {
            form.setCkhAfter_Daibensai(outDto.getCkhAfter_Daibensai());
        } else {
            // 処理モード(値)が処理完了：取消(1)または処理完了：修正(2)または処理完了以外：取消(3)または処理完了以外：更正（赤）取消(5)の場合
            // 受け渡されたデータコードが"90257041”または"90257041"の場合、代弁履行後の作成のチェックを有効とする。
            String dataCode = outDto.getID_DataCode_Red();
            if (PNCommonConstants.DATACODE_90257040.equals(dataCode)
                    || PNCommonConstants.DATACODE_90257041.equals(dataCode)) {
                form.setCkhAfter_Daibensai_Red("1");
            } else {
                form.setCkhAfter_Daibensai_Red("0");
            }
        }

        // 画面メッセージ、戻るメッセージ、戻るボタンのToolTipを画面に設定する。

        // return MY_VIEW

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
    public void displayControl(Model model, Md003_02Form form, HttpServletRequest request) {

        // 処理モード
        String processMode = form.getProcessMode();
        // 画面．処理モード毎に、画面項目表示／非表示設定を行う。
        if (Md003Constants.PROCESS_MODE_1.equals(processMode)) {
            // ・画面．処理モード　＝　「１：処理完了・取消」　の場合、下記設定を行う
            // 　・ 赤データ入力領域　※表示
            // 赤データ入力領域表示設定
            form.setVisible(Md003Constants.ID_PNL_RED, true);
            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md003Constants.ID_PNL_MOD, false);
            // 赤は表示
            form.setLblID_Head_Red2(Md003Constants.RED_VISIBLE);
        }

        if (Md003Constants.PROCESS_MODE_2.equals(processMode)) {
            // ・画面．処理モード　＝　「２：処理完了・修正」　の場合、下記設定を行う
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md003Constants.ID_PNL_RED, true);
            // 赤は表示
            form.setLblID_Head_Red2(Md003Constants.RED_VISIBLE);
            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md003Constants.ID_PNL_MOD, true);
        }

        if (Md003Constants.PROCESS_MODE_3.equals(processMode)) {
            // ・画面．処理モード　＝　「３：処理完了以外・取消」　の場合、下記設定を行う
            // 　・ 赤データ入力領域　※表示
            form.setVisible(Md003Constants.ID_PNL_RED, true);
            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md003Constants.ID_PNL_MOD, false);
            // 赤は非表示
            form.setLblID_Head_Red2(PNCommonConstants.LITERAL_BLANK);
        }

        if (Md003Constants.PROCESS_MODE_4.equals(processMode)) {
            // ・画面．処理モード　＝　「４：処理完了以外・修正」　の場合、下記設定を行う
            // 　・ 赤データ入力領域　※非表示
            form.setVisible(Md003Constants.ID_PNL_RED, false);
            // 赤は非表示
            form.setLblID_Head_Red2(PNCommonConstants.LITERAL_BLANK);
            // 　・ 黒データ入力領域　※表示
            form.setVisible(Md003Constants.ID_PNL_MOD, true);
        }

        if (Md003Constants.PROCESS_MODE_5.equals(processMode)) {
            // ・画面．処理モード　＝　「５：処理完了以外・更正（赤）取消」　の場合、下記設定を行う
            // 　・ 赤データ入力領域　※表示
            // 赤データ入力領域表示設定
            form.setVisible(Md003Constants.ID_PNL_RED, true);
            // 　・ 黒データ入力領域　※非表示
            form.setVisible(Md003Constants.ID_PNL_MOD, false);
            // 赤は非表示
            form.setLblID_Head_Red2(PNCommonConstants.LITERAL_BLANK);
        }

    }

    /**
     * <pre>
     * 画面の初期化を行います。
     * </pre>
     */
    private void setRequestScreen(Md003_02Form form, Map<String, Object> paramMap) {

        // 処理モード
        form.setProcessMode((String) paramMap.get(Md003Constants.PROPERTY_PROCESSMODE));

        // 最新の請求データの約定利息
        form.setNew_M_YakujoRisoku((String) paramMap.get(Md003Constants.PROPERTY_NEW_M_YAKUJORISOKU));
        // 最新の請求データの約定元金
        form.setNew_M_YakujoGankin((String) paramMap.get(Md003Constants.PROPERTY_NEW_M_YAKUJOGANKIN));
        // 最新の請求データの任意繰償還利息
        form.setNew_M_Seikyu_NinKuriRisoku((String) paramMap
                .get(Md003Constants.PROPERTY_NEW_M_SEIKYU_NINKURIRISOKU));
        // 最新の請求データの請求繰償還利息
        form.setNew_M_Seikyu_SeiKuriRisoku((String) paramMap
                .get(Md003Constants.PROPERTY_NEW_M_SEIKYU_SEIKURIRISOKU));
        // 最新の請求データの請求繰償還元金
        form.setNew_M_Seikyu_SeiKuriGankin((String) paramMap
                .get(Md003Constants.PROPERTY_NEW_M_SEIKYU_SEIKURIGANKIN));

        // 修正データ
        if (Md003Constants.PROCESS_MODE_2.equals(paramMap.get(Md003Constants.PROPERTY_PROCESSMODE))
                || Md003Constants.PROCESS_MODE_4.equals(paramMap.get(Md003Constants.PROPERTY_PROCESSMODE))) {

            // 報告年月日
            form.setLblID_Date_Report((String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_REPORT_RED));
            // メッセージ
            form.setLblMessage((String) paramMap.get(Md003Constants.PROPERTY_ID_ERRORMESSAGE_RED));
            // 顧客名
            form.setLblID_Name_Customer_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_NAME_CUSTOMER_RED));
            // 扱店名
            form.setLblID_Name_Organization_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_NAME_ORGANIZATION_RED));
            // 公庫支店
            form.setLblID_Code_KoukoShiten_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN_RED));
            // 扱店
            form.setLblID_Code_Organization_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_ORGANIZATION_RED));
            // 店舗
            form.setLblID_Code_Tenpo_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_CODE_TENPO_RED));
            // 年度
            form.setLblID_Year_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_YEAR_RED));
            // 方式資金
            form.setLblID_Code_HoshikiShikin_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN_RED));
            // 番号
            form.setLblID_ID_Ringi_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_RINGI_RED));
            // 枝番
            form.setLblID_ID_RingiBranch_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_ID_RINGIBRANCH_RED));
            // 貸付実行日
            form.setLblID_Date_Kashitsukejikko_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_KASHITSUKEJIKKO_RED));
            // 貸付金額
            form.setLblID_M_Kashitsuke_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKE_RED));
            // 資金使途
            form.setLblID_Code_ShikinShito_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_SHIKINSHITO_RED));
            // 事業別
            form.setLblID_Code_Jigyobetsu_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_JIGYOBETSU_RED));
            // 利率（％）
            form.setLblID_Riritsu_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_RIRITSU_RED));
            // 特利区分
            form.setLblID_Kubun_Tokuri_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_TOKURIKUBUN_RED));
            // 特利（％）
            form.setLblID_Tokuri_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_TOKURI_RED));
            // 償還方法
            form.setLblID_Code_Shokan_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_SHOKAN_RED));
            // 据置期限
            form.setLblID_Date_SueokiKigen_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_SUEOKIKIGEN_RED));
            // 償還期限
            form.setLblID_Date_ShokanKigen_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_SHOKANKIGEN_RED));
            // 元利金払込日
            form.setLblID_Date_GanrikinHaraiKomi_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_GANRIKINHARAIKOMI_RED));
            // 元利又は元金均等額(円)
            form.setLblID_M_GankinKinto_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_GANKINKINTO_RED));
            // 払込前残元金(円)
            form.setLblID_M_KashitsukeZandaka_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKEZANDAKA_RED));
            // 払込期日
            form.setLblID_Date_Haraikomi_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_HARAIKOMI_RED));
            // 払込金額(円)
            form.setLblID_M_Haraikomi_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_HARAIKOMI_RED));
            // 控除利息(円)
            form.setLblID_M_KojoRisoku_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KOJORISOKU_RED));
            // 差引払込額(円)
            form.setLblID_M_SashihikiHaraikomi_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_SASHIHIKIHARAIKOMI_RED));
            // 払込後残元金(円)
            form.setLblID_M_ZangankinAfterHaraikomi_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_ZANGANKINAFTERHARAIKOMI_RED));
            // 約定利息(円)
            form.setLblID_M_YakujoRisoku_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_YAKUJORISOKU_RED));
            // 約定元金(円)
            form.setLblID_M_YakujoGankin_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_YAKUJOGANKIN_RED));
            // 遅延損害金(円)
            form.setLblID_M_ChienSongai_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_CHIENSONGAI_RED));
            // 違約金(円)
            form.setLblID_M_Iyaku_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_IYAKU_RED));
            // 違約金(利子軽減分)(円)
            form.setLblID_M_IyakuRishikeigen_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_IYAKURISHIKEIGEN_RED));
            // 仮受金からの充当額(円)
            form.setLblID_M_KariukeIppanJuto_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED));
            if ("0".equals(PNCommonComponents.cnvNulltoZero((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED)))) {
                form.setLblID_M_KariukeIppanJuto_Red(PNCommonConstants.LITERAL_BLANK);
            } else {
                form.setLblID_M_KariukeIppanJuto_Red(PNCommonUtils.addComma(new BigDecimal((String) paramMap
                        .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED))));
            }
            // 入金日
            form.setLblID_Date_Nyukin_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_NYUKIN_RED));
            // 受託者勘定処理年月
            form.setLblID_Date_Jtkshori_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_JTKSHORI_RED));

            String jtkdhoriGengoRed = (String) paramMap
                    .get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_GENGO_RED);
            String jtkdhoriNenRed = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_NEN_RED);
            String jtkdhoriTsukiRed = (String) paramMap
                    .get(Md003Constants.PROPERTY_DRPID_DATE_JTKSHORITSUKI_RED);
            String seirekiJtkdhoriRedYYYYMM = "";
            if (null != jtkdhoriGengoRed && 0 < jtkdhoriGengoRed.length() && null != jtkdhoriNenRed
                    && 0 < jtkdhoriNenRed.length() && null != jtkdhoriTsukiRed
                    && 0 < jtkdhoriTsukiRed.length()) {
                seirekiJtkdhoriRedYYYYMM = PNCommonComponents.dateFmtJC_Gyymm(
                        PNCommonComponents.concatString(jtkdhoriGengoRed,
                                String.format("%1$02d", Integer.parseInt(jtkdhoriNenRed)),
                                String.format("%1$02d", Integer.parseInt(jtkdhoriTsukiRed))), "");
            }
            if (0 < seirekiJtkdhoriRedYYYYMM.length()) {
                form.setLblID_Date_Jtkshori_Red(seirekiJtkdhoriRedYYYYMM);
            }

            // 送金日
            form.setLblID_Date_Sokin_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_DATE_SOKIN_RED));
            // 送金日番号
            form.setLblID_ID_Sokinbi_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_SOKINBI_RED));

            // 顧客名（修正）
            form.setLblID_Name_Customer((String) paramMap.get(Md003Constants.PROPERTY_TXTID_NAME_CUSTOMER));
            // 扱店名（修正）
            form.setLblID_Name_Organization((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_NAME_ORGANIZATION));
            // 公庫支店（修正）
            form.setLblID_Code_KoukoShiten((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN));
            // 扱店（修正）
            form.setLblID_Code_Organization((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_ORGANIZATION));
            // 店舗（修正）
            form.setLblID_Code_Tenpo((String) paramMap.get(Md003Constants.PROPERTY_TXTID_CODE_TENPO));
            // 年度（修正）
            form.setLblID_Year((String) paramMap.get(Md003Constants.PROPERTY_TXTID_YEAR));
            // 方式資金（修正）
            form.setLblID_Code_HoshikiShikin((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN));
            // 番号（修正）
            form.setLblID_ID_Ringi((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_RINGI));
            // 枝番（修正）
            form.setLblID_ID_RingiBranch((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_RINGIBRANCH));
            // 貸付実行日（修正）
            form.setLblID_Date_Kashitsukejikko((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_KASHITSUKEJIKKO));
            // 貸付実行金額（修正）
            form.setLblID_M_Kashitsuke((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKE));
            // 資金使途（修正）
            form.setLblID_Code_ShikinShito((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_SHIKINSHITO));
            // 事業別（修正）
            form.setLblID_Code_Jigyobetsu((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_CODE_JIGYOBETSU));
            // 利率（％）（修正）
            form.setLblID_Riritsu((String) paramMap.get(Md003Constants.PROPERTY_TXTID_RIRITSU));
            // 特利区分（修正）
            form.setLblID_Code_TokuriKubun((String) paramMap.get(Md003Constants.PROPERTY_TXTID_KUBUN_TOKURI));
            // 特利（％）（修正）
            form.setLblID_Tokuri((String) paramMap.get(Md003Constants.PROPERTY_TXTID_TOKURI));
            // 償還方法（修正）
            form.setLblID_Code_Shokan((String) paramMap.get(Md003Constants.PROPERTY_TXTID_CODE_SHOKAN));
            // 据置期限（修正）
            form.setLblID_Date_SueokiKigen((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_SUEOKIKIGEN));
            // 償還期限（修正）
            form.setLblID_Date_ShokanKigen((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_SHOKANKIGEN));

            // 元利金払込日（修正）
            form.setLblID_Date_GanrikinHaraikomi((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_GANRIKINHARAIKOMI));
            // 元利又は元金均等額(円)（修正）
            form.setLblID_M_GankinKinto((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_GANKINKINTO));
            // 払込前残元金(円)（修正）
            form.setLblID_M_KashitsukeZandaka((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKEZANDAKA));
            // 払込期日（修正）
            form.setLblID_Date_Haraikomi((String) paramMap.get(Md003Constants.PROPERTY_TXTID_DATE_HARAIKOMI));
            // 払込金額(円)（修正）
            form.setLblID_M_Haraikomi((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_HARAIKOMI));
            // 控除利息(円)（修正）
            form.setLblID_M_KojoRisoku((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_KOJORISOKU));
            // 差引払込額(円)（修正）
            form.setLblID_M_SashihikiHaraikomi((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_SASHIHIKIHARAIKOMI));
            // 払込後残元金(円)（修正）
            form.setLblID_M_ZangankinAfterHaraikomi((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_ZANGANKINAFTERHARAIKOMI));
            // 約定利息(円)（修正）
            form.setLblID_M_YakujoRisoku((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_YAKUJORISOKU));
            // 約定元金(円)（修正）
            form.setLblID_M_YakujoGankin((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_YAKUJOGANKIN));
            // 遅延損害金(円)（修正）
            form.setLblID_M_ChienSongai((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_CHIENSONGAI));
            // 違約金(円)（修正）
            form.setLblID_M_Iyaku((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_IYAKU));
            // 違約金(利子軽減分)(円)（修正）
            form.setLblID_M_IyakuRishikeigen((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_IYAKURISHIKEIGEN));
            // 仮受金からの充当額(円)（修正）
            // 当項目は、計算項目につき、カンマ編集はJAVA側にて実施
            if ("0".equals(PNCommonComponents.cnvNulltoZero((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO)))) {
                form.setLblID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
            } else {
                form.setLblID_M_KariukeIppanJuto(PNCommonUtils.addComma(new BigDecimal((String) paramMap
                        .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO))));
            }
            // 入金日（修正）
            String nyukinGengo = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_NYUKIN_GENGO);
            String nyukinNen = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_NYUKIN_NEN);
            String nyukinTsuki = (String) paramMap.get(Md003Constants.PROPERTY_DRPID_DATE_NYUKINTSUKI);
            String nyukinBi = (String) paramMap.get(Md003Constants.PROPERTY_DRPID_DATE_NYUKINBI);
            String seirekinyukinYYYYMM = "";
            if (null != nyukinGengo && 0 < nyukinGengo.length() && null != nyukinNen
                    && 0 < nyukinNen.length() && null != nyukinTsuki && 0 < nyukinTsuki.length()
                    && null != nyukinBi && 0 < nyukinBi.length()) {
                seirekinyukinYYYYMM = PNCommonComponents.dateFmtJC_Gyymmdd(
                        PNCommonComponents.concatString(nyukinGengo,
                                String.format("%1$02d", Integer.parseInt(nyukinNen)),
                                String.format("%1$02d", Integer.parseInt(nyukinTsuki)),
                                String.format("%1$02d", Integer.parseInt(nyukinBi))), "");
            }
            if (0 < seirekinyukinYYYYMM.length()) {
                form.setLblID_Date_Nyukin(seirekinyukinYYYYMM);
            }
            // 受託者勘定処理年月（修正）
            form.setLblID_Date_Jtkshori((String) paramMap.get(Md003Constants.PROPERTY_TXTID_DATE_JTKSHORI));

            String jtkdhoriGengo = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_GENGO);
            String jtkdhoriNen = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_NEN);
            String jtkdhoriTsuki = (String) paramMap.get(Md003Constants.PROPERTY_DRPID_DATE_JTKSHORITSUKI);
            String seirekiJtkdhoriYYYYMM = "";
            if (null != jtkdhoriGengo && 0 < jtkdhoriGengo.length() && null != jtkdhoriNen
                    && 0 < jtkdhoriNen.length() && null != jtkdhoriTsuki && 0 < jtkdhoriTsuki.length()) {
                seirekiJtkdhoriYYYYMM = PNCommonComponents.dateFmtJC_Gyymm(
                        PNCommonComponents.concatString(jtkdhoriGengo,
                                String.format("%1$02d", Integer.parseInt(jtkdhoriNen)),
                                String.format("%1$02d", Integer.parseInt(jtkdhoriTsuki))), "");
            }
            if (0 < seirekiJtkdhoriYYYYMM.length()) {
                form.setLblID_Date_Jtkshori(seirekiJtkdhoriYYYYMM);
            }

            // 送金日（修正）
            String sokinGengo = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_SOKIN_GENGO);
            String sokinNen = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_SOKIN_NEN);
            String sokinTsuki = (String) paramMap.get(Md003Constants.PROPERTY_DRPID_DATE_SOKINTSUKI);
            String sokinBi = (String) paramMap.get(Md003Constants.PROPERTY_DRPID_DATE_SOKINBI);
            String seirekisokinYYYYMM = "";
            if (null != sokinGengo && 0 < sokinGengo.length() && null != sokinNen && 0 < sokinNen.length()
                    && null != sokinTsuki && 0 < sokinTsuki.length() && null != sokinBi
                    && 0 < sokinBi.length()) {
                seirekisokinYYYYMM = PNCommonComponents.dateFmtJC_Gyymmdd(
                        PNCommonComponents.concatString(sokinGengo,
                                String.format("%1$02d", Integer.parseInt(sokinNen)),
                                String.format("%1$02d", Integer.parseInt(sokinTsuki)),
                                String.format("%1$02d", Integer.parseInt(sokinBi))), "");
            }
            if (0 < seirekisokinYYYYMM.length()) {
                form.setLblID_Date_Sokin(seirekisokinYYYYMM);
            }

            // 送金日番号（修正）
            form.setLblID_ID_Sokinbi((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_SOKINBI));

            // 報告書番号(非表示)
            form.setID_ID_Report_H((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_REPORT));
            // 処理モード */
            form.setProcessMode((String) paramMap.get(Md003Constants.PROPERTY_PROCESSMODE));

            // 退避約定元金(修正)
            form.setID_Keep_M_YakujoGankin((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_M_YAKUJOGANKIN));
            // 退避約定利息(修正)
            form.setID_Keep_M_YakujoRisoku((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_M_YAKUJORISOKU));
            // データコード
            form.setID_DataCode((String) paramMap.get(Md003Constants.PROPERTY_ID_DATACODE));
            // 残高件数
            form.setID_Count_Zandaka((String) paramMap.get(Md003Constants.PROPERTY_ID_COUNT_ZANDAKA));
            // ステータス
            form.setID_Status((String) paramMap.get(Md003Constants.PROPERTY_ID_STATUS));
            // 処理種別
            form.setID_Type_Process((String) paramMap.get(Md003Constants.PROPERTY_ID_TYPE_PROCESS));
            // 取消済フラグ
            form.setID_Flag_Torikeshizumi((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_FLAG_TORIKESHIZUMI));
            // エラー番号
            form.setID_Code_Error((String) paramMap.get(Md003Constants.PROPERTY_ID_CODE_ERROR));
            // エラーメッセージ
            form.setID_ErrorMessage((String) paramMap.get(Md003Constants.PROPERTY_ID_ERRORMESSAGE));
            // 退避貸付金残高
            form.setID_Keep_M_KashitsukeZan((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_M_KASHITSUKEZAN));
            // 退避償還期限
            form.setID_Keep_Date_ShokanKigen((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_DATE_SHOKANKIGEN));
            // 債権管理番号
            form.setID_ID_Credit((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_CREDIT));
            // 顧客コード
            form.setID_Code_Customer((String) paramMap.get(Md003Constants.PROPERTY_ID_CODE_CUSTOMER));
            // 扱店別稟議データの貸付残高
            form.setID_M_KashitsukeZandaka_aRingi((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_M_KASHITSUKEZANDAKA_ARINGI));
            // 扱店別稟議データの償還期限
            form.setID_Date_ShokanKigen_aRingi((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_DATE_SHOKANKIGEN_ARINGI));
            // 請求データの約定元金
            form.setID_M_YakujoGankin_Seikyu((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_M_YAKUJOGANKIN_SEIKYU));
            // 請求データの約定利息
            form.setID_M_YakujoRisoku_Seikyu((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_M_YAKUJORISOKU_SEIKYU));
            // 充当順序変更区分
            form.setID_Kubun_JutoJunjoHenko((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KUBUN_JUTOJUNJOHENKO));
            // 請求データの退避任意繰上償還利息
            form.setID_Keep_Seikyu_M_NinKuriRisoku((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_NINKURIRISOKU));
            // 請求データの退避請求繰上償還利息
            form.setID_Keep_Seikyu_M_SeiKuriRisoku((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU));
            // 請求データの退避請求繰上償還元金
            form.setID_Keep_Seikyu_M_SeiKuriGankin((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN));
            // 約定データの退避請求繰上償還利息
            form.setID_Keep_Yakujo_M_SeiKuriRisoku((String) paramMap
                    .get(Md003Constants.PROPERTY_ID_KEEP_YAKUJO_M_SEIKURIRISOKU));
            // 最新データ更新日付
            form.setID_Data_LastUpDate((String) paramMap.get(Md003Constants.PROPERTY_ID_DATA_LASTUPDATE));
            // 退避履歴番号
            form.setID_Keep_ID_History((String) paramMap.get(Md003Constants.PROPERTY_ID_KEEP_ID_HISTORY));
            // 報告年月日
            form.setLblID_Date_Report((String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_REPORT));
            // 報告年月日
            form.setID_Date_Report((String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_REPORT));

            // ユーザID
            form.setID_User_ID((String) paramMap.get(Md003Constants.PROPERTY_ID_USER_ID));
            // 伝送番号
            form.setID_ID_Denso((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_DENSO));
            // 元利金計
            form.setID_M_GanrikinKei((String) paramMap.get(Md003Constants.PROPERTY_ID_M_GANRIKINKEI));

        }

        // 更正(赤)データの場合
        // 履歴番号
        form.setID_ID_History_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_HISTORY_RED));
        // データコード
        form.setID_DataCode_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_DATACODE_RED));
        // 残高件数
        form.setID_Count_Zandaka_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_COUNT_ZANDAKA_RED));
        // ステータス
        form.setID_Status_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_STATUS_RED));
        // 処理種別
        form.setID_Type_Process_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_TYPE_PROCESS_RED));
        // 取消済フラグ
        form.setID_Flag_Torikeshizumi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_FLAG_TORIKESHIZUMI_RED));
        // エラー番号
        form.setID_Code_Error_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_CODE_ERROR_RED));
        // エラーメッセージ
        form.setID_ErrorMessage_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_ERRORMESSAGE_RED));
        // 退避貸付金残高
        form.setID_Keep_M_KashitsukeZan_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_M_KASHITSUKEZAN_RED));
        // 退避償還期限
        form.setID_Keep_Date_ShokanKigen_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_DATE_SHOKANKIGEN_RED));
        // 債権管理番号
        form.setID_ID_Credit_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_CREDIT_RED));
        // 顧客コード
        form.setID_Code_Customer_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_CODE_CUSTOMER_RED));
        // 扱店別稟議データの貸付残高
        form.setID_M_KashitsukeZandaka_aRingi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_M_KASHITSUKEZANDAKA_ARINGI_RED));
        // 扱店別稟議データの償還期限
        form.setID_Date_ShokanKigen_aRingi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_DATE_SHOKANKIGEN_ARINGI_RED));
        // 請求データの約定元金
        form.setID_M_YakujoGankin_Seikyu_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_M_YAKUJOGANKIN_SEIKYU_RED));
        // 請求データの約定利息
        form.setID_M_YakujoRisoku_Seikyu_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_M_YAKUJORISOKU_SEIKYU_RED));
        // 充当順序変更区分
        form.setID_Kubun_JutoJunjoHenko_RED((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KUBUN_JUTOJUNJOHENKO_RED));
        // 請求データの退避任意繰上償還利息
        form.setID_Keep_Seikyu_M_NinKuriRisoku_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_NINKURIRISOKU_RED));
        // 請求データの退避請求繰上償還利息
        form.setID_Keep_Seikyu_M_SeiKuriRisoku_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIRISOKU_RED));
        // 請求データの退避請求繰上償還元金
        form.setID_Keep_Seikyu_M_SeiKuriGankin_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_SEIKYU_M_SEIKURIGANKIN_RED));
        // 約定データの退避請求繰上償還利息
        form.setID_Keep_Yakujo_M_SeiKuriRisoku_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_YAKUJO_M_SEIKURIRISOKU_RED));
        // 最新データ更新日付
        form.setID_Data_LastUpDate_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_DATA_LASTUPDATE_RED));
        // 退避履歴番号
        form.setID_Keep_ID_History_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_KEEP_ID_HISTORY_RED));

        // 報告年月日
        form.setLblID_Date_Report((String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_REPORT_RED));
        // メッセージ
        form.setLblMessage((String) paramMap.get(Md003Constants.PROPERTY_ID_ERRORMESSAGE_RED));
        // 顧客名
        form.setLblID_Name_Customer_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_NAME_CUSTOMER_RED));
        // 扱店名
        form.setLblID_Name_Organization_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_NAME_ORGANIZATION_RED));
        // 公庫支店
        form.setLblID_Code_KoukoShiten_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_KOUKOSHITEN_RED));
        // 扱店
        form.setLblID_Code_Organization_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_ORGANIZATION_RED));
        // 店舗
        form.setLblID_Code_Tenpo_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_CODE_TENPO_RED));
        // 年度
        form.setLblID_Year_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_YEAR_RED));
        // 方式資金
        form.setLblID_Code_HoshikiShikin_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_HOSHIKISHIKIN_RED));
        // 番号
        form.setLblID_ID_Ringi_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_RINGI_RED));
        // 枝番
        form.setLblID_ID_RingiBranch_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_ID_RINGIBRANCH_RED));
        // 貸付実行日
        form.setLblID_Date_Kashitsukejikko_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_DATE_KASHITSUKEJIKKO_RED));
        // 貸付金額
        form.setLblID_M_Kashitsuke_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKE_RED));
        // 資金使途
        form.setLblID_Code_ShikinShito_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_SHIKINSHITO_RED));
        // 事業別
        form.setLblID_Code_Jigyobetsu_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_JIGYOBETSU_RED));
        // 利率（％）
        form.setLblID_Riritsu_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_RIRITSU_RED));
        // 特利区分
        form.setLblID_Kubun_Tokuri_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_CODE_TOKURIKUBUN_RED));
        // 特利（％）
        form.setLblID_Tokuri_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_TOKURI_RED));
        // 償還方法
        form.setLblID_Code_Shokan_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_CODE_SHOKAN_RED));
        // 据置期限
        form.setLblID_Date_SueokiKigen_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_DATE_SUEOKIKIGEN_RED));
        // 償還期限
        form.setLblID_Date_ShokanKigen_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_DATE_SHOKANKIGEN_RED));
        // 元利金払込日
        form.setLblID_Date_GanrikinHaraiKomi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_DATE_GANRIKINHARAIKOMI_RED));
        // 元利又は元金均等額(円)
        form.setLblID_M_GankinKinto_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_GANKINKINTO_RED));
        // 払込前残元金(円)
        form.setLblID_M_KashitsukeZandaka_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_KASHITSUKEZANDAKA_RED));
        // 払込期日
        form.setLblID_Date_Haraikomi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_DATE_HARAIKOMI_RED));
        // 払込金額(円)
        form.setLblID_M_Haraikomi_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_HARAIKOMI_RED));
        // 控除利息(円)
        form.setLblID_M_KojoRisoku_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_KOJORISOKU_RED));
        // 差引払込額(円)
        form.setLblID_M_SashihikiHaraikomi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_SASHIHIKIHARAIKOMI_RED));
        // 払込後残元金(円)
        form.setLblID_M_ZangankinAfterHaraikomi_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_ZANGANKINAFTERHARAIKOMI_RED));
        // 約定利息(円)
        form.setLblID_M_YakujoRisoku_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_YAKUJORISOKU_RED));
        // 約定元金(円)
        form.setLblID_M_YakujoGankin_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_YAKUJOGANKIN_RED));
        // 遅延損害金(円)
        form.setLblID_M_ChienSongai_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_CHIENSONGAI_RED));
        // 違約金(円)
        form.setLblID_M_Iyaku_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_M_IYAKU_RED));
        // 違約金(利子軽減分)(円)
        form.setLblID_M_IyakuRishikeigen_Red((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_IYAKURISHIKEIGEN_RED));
        // 仮受金からの充当額(円)
        // 当項目のカンマ編集はJAVA側にて実施
        if ("0".equals(PNCommonComponents.cnvNulltoZero((String) paramMap
                .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED)))) {
            form.setLblID_M_KariukeIppanJuto_Red(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_KariukeIppanJuto_Red(PNCommonUtils.addComma(new BigDecimal((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_M_KARIUKEIPPANJUTO_RED))));
        }

        // 入金日
        form.setLblID_Date_Nyukin_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_DATE_NYUKIN_RED));

        // 受託者勘定処理年月
        if (Md003Constants.PROCESS_MODE_1.equals(paramMap.get(Md003Constants.PROPERTY_PROCESSMODE))
                || Md003Constants.PROCESS_MODE_3.equals(paramMap.get(Md003Constants.PROPERTY_PROCESSMODE))) {

            form.setLblID_Date_Jtkshori_Red((String) paramMap
                    .get(Md003Constants.PROPERTY_TXTID_DATE_JTKSHORI_RED));
            String jtkdhoriGengoRed = (String) paramMap
                    .get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_GENGO_RED);
            String jtkdhoriNenRed = (String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_JTKSHORI_NEN_RED);
            String jtkdhoriTsukiRed = (String) paramMap
                    .get(Md003Constants.PROPERTY_DRPID_DATE_JTKSHORITSUKI_RED);
            String seirekiJtkdhoriRedYYYYMM = "";
            if (null != jtkdhoriGengoRed && 0 < jtkdhoriGengoRed.length() && null != jtkdhoriNenRed
                    && 0 < jtkdhoriNenRed.length() && null != jtkdhoriTsukiRed
                    && 0 < jtkdhoriTsukiRed.length()) {
                seirekiJtkdhoriRedYYYYMM = PNCommonComponents.dateFmtJC_Gyymm(
                        PNCommonComponents.concatString(jtkdhoriGengoRed,
                                String.format("%1$02d", Integer.parseInt(jtkdhoriNenRed)),
                                String.format("%1$02d", Integer.parseInt(jtkdhoriTsukiRed))), "");
            }

            if (0 < seirekiJtkdhoriRedYYYYMM.length()) {
                form.setLblID_Date_Jtkshori_Red(seirekiJtkdhoriRedYYYYMM);
            }
        }

        // 送金日
        form.setLblID_Date_Sokin_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_DATE_SOKIN_RED));
        // 送金日番号
        form.setLblID_ID_Sokinbi_Red((String) paramMap.get(Md003Constants.PROPERTY_TXTID_ID_SOKINBI_RED));
        // 退避約定元金 */
        form.setID_Keep_M_YakujoGankin_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_M_YAKUJOGANKIN_RED));
        // 退避約定利息 */
        form.setID_Keep_M_YakujoRisoku_Red((String) paramMap
                .get(Md003Constants.PROPERTY_ID_KEEP_M_YAKUJORISOKU_RED));

        // モードタイプ
        form.setModeType((String) paramMap.get(Md003Constants.PROPERTY_MODETYPE));
        // 元利金計
        form.setID_M_GanrikinKei_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_M_GANRIKINKEI_RED));
        // 報告書番号
        form.setID_ID_Report_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_REPORT_RED));
        // 報告書番号
        form.setID_ID_Report_H((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_REPORT_H));
        // 報告年月日
        form.setID_Date_Report_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_DATE_REPORT_RED));
        // ユーザID
        form.setID_User_ID_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_USER_ID_RED));
        // 伝送番号
        form.setID_ID_Denso_Red((String) paramMap.get(Md003Constants.PROPERTY_ID_ID_DENSO_RED));
    }

}