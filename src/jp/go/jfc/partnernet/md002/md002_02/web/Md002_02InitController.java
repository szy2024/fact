//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_02.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.md002.common.Md002Constants;
import jp.go.jfc.partnernet.md002.md002_02.service.Md002_02DTO;
import jp.go.jfc.partnernet.md002.md002_02.service.Md002_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNMessageUtils;
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
 * このクラスはmd002_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md002_02Form")
@RequestMapping(value = "/Md002_02Init.form")
public class Md002_02InitController extends Md002_02BaseController {

    /** Md002_02Service */
    @Autowired
    Md002_02Service md002_02service;
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;
    /** 画面の登録ボタン名 */
    public static final String JSP_ITEM_ID_BTNUPDATE2 = "btnUpdate2";

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
    public String executeAction(Model model, Md002_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // 受渡パラメータを取得する。
        // １．DTO項目に設定する。

        // 画面の全項目をクリアする。
        clearScreen(form);

        form.setVisible(Md002Constants.ID_RED_AREA, false);
        form.setVisible(Md002Constants.ID_BLACK_AREA, false);
        form.setVisible(JSP_ITEM_ID_BTNUPDATE2, false);
        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        String processMode = (String) paramMap.get(Md002Constants.PROPERTY_ID_REPORT_PROCESS_MODE);
        // 報告書番号
        String iD_Report = (String) paramMap.get(Md002Constants.PROPERTY_ID_REPORT_ID_REPORT);

        Md002_02DTO outDto = null;
        if (!Md000Constants.PROCESS_MODE_5.equals(processMode)) {
            outDto = (Md002_02DTO) paramMap.get(Md002Constants.PROPERTY_MD002_02DTO);
            outDto.setProcess_Mode(processMode);
            outDto.setID_ID_Report(iD_Report);
            CFWBeanUtils.copyProperties(form, outDto);
        }

        String message = null;
        // １．モードタイプが、変更の場合
        if (!Md002Constants.MODE_TYPE_CREATE.equals(form.getModeType())) {
            // 画面メッセージに、PM1010Iを設定する。
            message = PNMessageUtils.getString(PNCommonMessageConstants.PM1010I);
        } else {
            // ２．モードタイプが、複写または作成の場合
            // 画面メッセージに、PM1020Iを設定する。
            message = PNMessageUtils.getString(PNCommonMessageConstants.PM1020I);
        }

        // 処理モードが処理完了以外：更正(赤)取消の場合
        if (Md000Constants.PROCESS_MODE_5.equals(processMode)) {
            Md002_02DTO inDto = new Md002_02DTO();
            inDto.setID_ID_Report(iD_Report);
            // １．一覧画面データの取得をする。
            // （１）サービスを実行し、一覧画面データを取得する。
            outDto = md002_02service.getResultsData(inDto);
            bizErrors.addAll(outDto.getBizErrors());
            if (0 < bizErrors.size()) {
                // データ未検出時は、サービス処理で業務エラーとなる
                throw new PNServiceException(bizErrors);
            }
            // 取得したデータを初期データに格納する。
            outDto.setProcess_Mode(processMode);
            CFWBeanUtils.copyProperties(form, outDto);

            // ２．復活用の払出データの読み出し（定期償還・特殊償還は除く）
            // 稟議・償還方法コード（非表示）＜＞"3" または 稟議・償還方法コード（非表示）＜＞"9" の場合
            String code_ShokanHouhou = "";
            if (null != form.getID_Code_ShokanHouhou_Ringi()) {
                code_ShokanHouhou = form.getID_Code_ShokanHouhou_Ringi().substring(0, 1);
            }
            if (!"3".equals(code_ShokanHouhou) && !"9".equals(code_ShokanHouhou)) {
                // ①サービスを実行し、払出データを取得する。
                Md002_02DTO outDto2 = md002_02service.GetRevivHaraidashiData(outDto);
                // エラー判定
                if (0 < outDto2.getBizErrors().size()) {
                    // エラーリスト設定
                    bizErrors.addAll(outDto2.getBizErrors());
                    // エラー有の場合自画面表示
                    throw new PNServiceException(bizErrors);
                }
                form.setID_HDDel1_Keep_ID_Credit(outDto2.getID_HDDel1_Keep_ID_Credit());
                form.setID_HDDel1_Keep_ID_KeisuKanriShori(outDto2.getID_HDDel1_Keep_ID_KeisuKanriShori());
                form.setID_HDDel1_Keep_M_Haraidashi(outDto2.getID_HDDel1_Keep_M_Haraidashi());
                form.setID_HDDel1_Keep_M_HaraidashiRuikei(outDto2.getID_HDDel1_Keep_M_HaraidashiRuikei());
                form.setID_HDDel1_Keep_M_Kurisho(outDto2.getID_HDDel1_Keep_M_Kurisho());
                form.setID_HDDel1_Keep_M_KurishoRuikei(outDto2.getID_HDDel1_Keep_M_KurishoRuikei());
                form.setID_HDDel1_Keep_Kubun_KoseiShori(outDto2.getID_HDDel1_Keep_Kubun_KoseiShori());
                form.setID_HDDel1_Keep_M_ZandakaSekisu(outDto2.getID_HDDel1_Keep_M_ZandakaSekisu());
                form.setID_HDDel1_Keep_Date_HaraidashiJuto(outDto2.getID_HDDel1_Keep_Date_HaraidashiJuto());
                form.setID_HDDel1_Keep_M_HaraidashiKashitsukeZan(outDto2
                        .getID_HDDel1_Keep_M_HaraidashiKashitsukeZan());
            }

            // ３．復活レコードの履歴データ用に履歴番号、原本IDを取得する。

            // ４．更正（赤）データの初期値を設定する。
            // ・２⇒ステータス
            form.setID_Status("2");
            // ・１０⇒処理種別
            form.setID_Type_Process("10");
            // ・１⇒取消済フラグ
            form.setID_Flag_Torikeshizumi("1");

        }

        // 「戻る」ボタンメッセージの作成
        // １．処理モードが処理完了以外更正(赤)取消の場合
        // 戻るメッセージに「取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        // 戻るボタンのToolTipに、「取消・修正対象報告書の一覧画面へ戻る」を設定する。
        // ２．処理もーどが処理完了以外更正(赤)取消以外の場合
        // 戻るメッセージに「貸付受入金払出・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        // JSPで実施

        // 受渡パラメータの処理モードにより画面表示タイプを決定する。
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            form.setRed_Area(Md002Constants.PANEL_HEADER_TORIKESHI);
            form.setLblID_Head_Red2("");
        } else if ((PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode))) {
            form.setRed_Area(Md002Constants.PANEL_HEADER_KOUSEI);
            form.setLblID_Head_Red2(Md002Constants.RED_VISIBLE);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {
            form.setBrack_Area(Md002Constants.PANEL_HEADER_SHUSEI);
            form.setLblID_Head_Red2("");
        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {
            form.setRed_Area(Md002Constants.PANEL_HEADER_KOUSEI);
            form.setLblID_Head_Red2(Md002Constants.RED_VISIBLE);
            form.setBrack_Area(Md002Constants.PANEL_HEADER_KOUSEI_BLACK);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            // ・画面．処理モードが「５：処理完了以外・更正（赤）取消」の場合　※黒データ入力領域は非表示
            // 　-　「取消内容」　　 　→　画面．赤データ入力領域タイトル
            form.setRed_Area(Md002Constants.PANEL_HEADER_TORIKESHI);
            form.setLblID_Head_Red2("");
        }
        // 画面表示タイプが修正画面の場合
        // 　　１．DTO項目(修正)を画面に表示する。
        // 画面表示タイプが取消画面の場合
        // 　　１．DTO項目を画面に表示する。
        // 画面メッセージ、戻るメッセージ、戻るボタンのToolTipを画面に設定する。
        form.setLblComment(message);
        // 報告年月日にシステム日付を表示
        form.setLblID_Date_Report(pnCommonDBComponents.getPNBusinessDay(1));
        // 登録ボタン表示
        form.setVisible(JSP_ITEM_ID_BTNUPDATE2, true);

        return MY_VIEW;
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
    public void displayControl(Model model, Md002_02Form form, HttpServletRequest request) {

        // 画面項目制御仕様を参照
        // 　　処理モード毎に、画面項目表示／非表示設定を行う。
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(form.getProcess_Mode())) {
            form.setVisible(Md002Constants.ID_RED_AREA, true);
            form.setVisible(Md002Constants.ID_BLACK_AREA, false);
        } else if ((PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(form.getProcess_Mode()))) {
            form.setVisible(Md002Constants.ID_RED_AREA, true);
            form.setVisible(Md002Constants.ID_BLACK_AREA, false);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getProcess_Mode())) {
            form.setVisible(Md002Constants.ID_RED_AREA, false);
            form.setVisible(Md002Constants.ID_BLACK_AREA, true);
        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(form.getProcess_Mode())) {
            form.setVisible(Md002Constants.ID_RED_AREA, true);
            form.setVisible(Md002Constants.ID_BLACK_AREA, true);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(form.getProcess_Mode())) {
            // ・画面．処理モードが「５：処理完了以外・更正（赤）取消」の場合　※黒データ入力領域は非表示
            form.setVisible(Md002Constants.ID_RED_AREA, true);
            form.setVisible(Md002Constants.ID_BLACK_AREA, false);
        }
    }

    /**
     * <pre>
     * 画面の初期化を行います。
     * </pre>
     */
    private void clearScreen(Md002_02Form form) {
        form.setLblID_Date_Report(null);
        form.setLblErr(null);
        form.setLblMessage(null);
        form.setLblComment(null);
        form.setLblID_Name_Customer_Red(null);
        form.setLblID_Name_Organization_Red(null);
        form.setLblID_Code_KoukoShiten_Red(null);
        form.setLblID_Code_Organization_Red(null);
        form.setLblID_Code_Tenpo_Red(null);
        form.setLblID_Year_Red(null);
        form.setLblID_Code_HoshikiShikin_Red(null);
        form.setLblID_ID_Ringi_Red(null);
        form.setLblID_ID_RingiBranch_Red(null);
        form.setLblID_Code_ShikinShito_Red(null);
        form.setLblID_Code_Jigyobetsu_Red(null);
        form.setLblID_Riritsu_Red(null);
        form.setLblID_Code_TokuriKubun_Red(null);
        form.setLblID_Tokuri_Red(null);
        form.setLblID_Date_SueokiKigen_Red(null);
        form.setLblID_Date_ShokanKigen_Red(null);
        form.setLblID_Date_GanrikinHaraikomi_Red(null);
        form.setLblID_Date_Jikko_Red(null);
        form.setLblID_M_Kashitsuke_Red(null);
        form.setLblID_M_ShikinKofu_Red(null);
        form.setLblID_M_KashitsukeUkeire_Red(null);
        form.setLblID_M_KashitsukeukeireZan_Red(null);
        form.setLblID_Date_Jtkshori_Red(null);
        form.setLblID_Date_HaraidashiJuto_Red(null);
        form.setLblID_M_Haraidashi_Red(null);
        form.setLblID_M_Ganju_Red(null);
        form.setLblID_M_KashitsukeZandakaAfterGanju_Red(null);
        form.setLblID_Date_FirstYakujoAfterGanju_Red(null);
        form.setLblID_Code_KurishoJiyu_Red(null);
        form.setLblID_M_GankinKintoAfterGanju_Red(null);
        form.setLblID_M_GankinFukintoAfterGanju_Red(null);
        form.setRdoID_Code_Chosei_Red(null);
        form.setLblID_Name_Customer(null);
        form.setLblID_Name_Organization(null);
        form.setLblID_Code_KoukoShiten(null);
        form.setLblID_Code_Organization(null);
        form.setLblID_Code_Tenpo(null);
        form.setLblID_Year(null);
        form.setLblID_Code_HoshikiShikin(null);
        form.setLblID_ID_Ringi(null);
        form.setLblID_ID_RingiBranch(null);
        form.setLblID_Code_ShikinShito(null);
        form.setLblID_Code_Jigyobetsu(null);
        form.setLblID_Riritsu(null);
        form.setLblID_Kubun_Tokuri(null);
        form.setLblID_Tokuri(null);
        form.setLblID_Date_SueokiKigen(null);
        form.setLblID_Date_ShokanKigen(null);
        form.setLblID_Date_GanrikinHaraikomi(null);
        form.setLblID_Date_Jikko(null);
        form.setLblID_M_Kashitsuke(null);
        form.setLblID_M_ShikinKofu(null);
        form.setLblID_M_KashitsukeUkeire(null);
        form.setLblID_M_KashitsukeukeireZan(null);
        form.setLblID_Date_Jtkshori(null);
        form.setLblID_Date_HaraidashiJuto(null);
        form.setLblID_M_Haraidashi(null);
        form.setLblID_M_Ganju(null);
        form.setLblID_M_KashitsukeZandakaAfterGanju(null);
        form.setLblID_Date_FirstYakujoAfterGanju(null);
        form.setLblID_Code_KurishoJiyu(null);
        form.setLblID_M_GankinKintoAfterGanju(null);
        form.setLblID_M_GankinFukintoAfterGanju(null);
        form.setRdoID_Code_Chosei(null);

    }
}