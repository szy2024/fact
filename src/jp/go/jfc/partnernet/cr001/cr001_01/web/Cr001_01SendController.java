//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.cr001.common.Cr001Constants;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01DTO;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01M1DTO;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

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
 * このクラスはCr001_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr001_01Form")
@RequestMapping(value = "/Cr001_01Send.form")
public class Cr001_01SendController extends Cr001_01BaseController {

    /** Cr001_01Service */
    @Autowired
    Cr001_01Service cr001_01service;

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
    public String executeAction(Model model, Cr001_01Form form, Errors errors,
            HttpServletRequest request, HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 入力チェック
        Cr001_01DTO outDto = checkInput(form);
        // エラーリスト取得
        bizErrors.addAll(outDto.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // Formへの転記処理をここに実装
        // 取得した貸付実行報告書一覧をフォームに設定する。
        // CFWBeanUtils.copyProperties(form, outDto);
        // form.setMEISAI_LIST(outMeisaiList);
        setRequestNextScreen(request, outDto);
        // 　貸付実行報告書作成（入力結果画面）へ遷移する
        // 　　　画面の「選択」チェックボックスをチェックした貸付実行報告書を遷移パラメータに設定する。
        // 　　　return success("Cr001_02Init")
        return success(Cr001Constants.EVENT_ID_CR001_02INIT);
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
    public void displayControl(Model model, Cr001_01Form form,
            HttpServletRequest request) {

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request
     *            リクエスト情報
     * @param reportId
     *            報告書番号
     */
    private void setRequestNextScreen(HttpServletRequest request,
            Cr001_01DTO outDto) {
        addForwardParameter(request, "MEISAI_InputLIST",
                outDto.getMEISAI_LIST());
        addForwardParameter(request, "lblID_Date_Report",
                outDto.getTxtID_Date_Report());
    }

    /**
     * 入力チェック
     *
     * @param inM1Dto
     *            選択チェックボックスがチェックされた1明細
     * @param strLineInfo
     *            案件情報
     * @return LinkedList<PNMessageInfo> エラー情報
     */
    private Cr001_01DTO checkInput(Cr001_01Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 明細カウンタ
        int intLine = 0;
        // 案件情報
        String strLineInfo = "";

        // DTOの生成
        Cr001_01DTO outDto = new Cr001_01DTO();
        CFWBeanUtils.copyProperties(outDto, form);
        PNPagingTable<Cr001_01M1DTO> inM1DtoList = form.getCr001_01M1Table();
        List<Cr001_01M1DTO> inMeisaiList = inM1DtoList.getRecordList();
        List<Cr001_01M1DTO> outMeisaiList = new ArrayList<Cr001_01M1DTO>(
                inMeisaiList.size());

        // 選択案件数
        int selectCnt = 0;

        for (Cr001_01M1DTO inM1Dto : inMeisaiList) {
            intLine += 1;

            if (false == "1".equals(inM1Dto.getChkUpdate())) {
                continue;
            }
            strLineInfo = PNCommonComponents.concatString("(",
                    String.valueOf(intLine), "案件目)");

            // 選択案件数カウントアップ
            selectCnt++;

            // 選択チェックボックスがチェックされたもののみ、以下のチェックを行う。
            // 受託者勘定処理年月フラグ
            boolean flgDateJtkshori = true;
            // 貸付実行日フラグ
            boolean flgKashitsukejikko = true;
            // 資金交付額フラグ
            boolean flgSikinKofu = true;

            // 非表示呼応目を設定する
            // 　　"1"⇒貸付実行報告書作成済みフラグ
            // 　　報告書番号取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
            // 　　履歴番号取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
            // 　　システム時間⇒報告時分秒
            // 　　ログインユーザのユーザID⇒ユーザID
            // 　　""⇒伝送番号
            // 　　"90257010"⇒データコード
            // 　　"0"⇒貸付件数
            // 　　"1"⇒ステータス
            // 　　"00"⇒処理種別
            // 　　"0"⇒取消済フラグ
            // 　　""⇒エラーコード
            // 　　""⇒エラーメッセージ

            String errMsg = "";
            // 明細DTOのコピーを作成
            Cr001_01M1DTO m1Dto = new Cr001_01M1DTO();
            CFWBeanUtils.copyProperties(m1Dto, inM1Dto);
            // 報告書番号のチェック
            if (false == isAlreadyInput(inM1Dto.getID_ID_Report())) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "報告書番号（非表示）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 受託者勘定処理年月の年のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            // 受託者勘定処理年月フラグ
            flgDateJtkshori = isAlreadyInput(inM1Dto.getID_Date_Jtkshori_Nen());
            if (false == flgDateJtkshori) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        " 受託者勘定処理年月（年）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 受託者勘定処理年月の月のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            // 受託者勘定処理年月フラグ
            flgDateJtkshori = isAlreadyInput(inM1Dto
                    .getID_Date_JtkshoriTsuki_Candidate());
            if (false == flgDateJtkshori) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "受託者勘定処理年月（月）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 貸付実行日の年のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            // 貸付実行日のフラグ
            flgKashitsukejikko = isAlreadyInput(inM1Dto
                    .getID_Date_Kashitsukejikko_Nen());
            if (false == flgKashitsukejikko) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "貸付実行日（年）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 貸付実行日の月のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            flgKashitsukejikko = isAlreadyInput(inM1Dto
                    .getID_Date_KashitsukejikkoTsuki_Candidate());
            if (false == flgKashitsukejikko) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "貸付実行日（月）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 貸付実行日の日のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            flgKashitsukejikko = isAlreadyInput(inM1Dto
                    .getID_Date_KashitsukejikkoBi_Candidate());
            if (false == flgKashitsukejikko) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "貸付実行日（日）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 資金交付額（円）のチェック
            // 　空白の場合、エラーとする。
            // 　　メッセージ：CHK001
            flgSikinKofu = isAlreadyInput(inM1Dto.getID_M_SikinKofu());
            if (false == flgSikinKofu) {
                // 　空白の場合、エラーとする。
                // 　　メッセージ：CHK001
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "資金交付額（円）");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3120E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 受託者勘定処理年月チェック
// [UPD] Ver 3.0.0 - START
//            PNCheckDay testDay = new PNCheckDay(
//                    inM1Dto.getID_Date_Jtkshori_Gengo(),
//                    inM1Dto.getID_Date_Jtkshori_Nen(),
//                    inM1Dto.getID_Date_JtkshoriTsuki_Candidate(), "1",
//                    pnCommonDBComponents, bizErrors);
            PNCheckDay testDay = new PNCheckDay(
                    inM1Dto.getID_Date_Jtkshori_Gengo(),
                    inM1Dto.getID_Date_Jtkshori_Nen(),
                    inM1Dto.getID_Date_JtkshoriTsuki_Candidate(), "",
                    pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END
            // 受託者勘定処理年月のS64入力無効チェック
            // 　　メッセージ：PTN_JKSN_021
            errMsg = PNCommonComponents.concatString(strLineInfo,
                    "受託者勘定処理年月（年）");
            // 　S64の場合、エラーとする。
            testDay.addErrorS64(PNCommonMessageConstants.PM3291E,
                    new String[] { errMsg });
            if (0 < bizErrors.size()) {
                flgDateJtkshori = false;
                outDto.setBizErrors(bizErrors);
                break;
            }
            // 受託者勘定処理年月の有効日付チェック
            // 　　メッセージ：CHK001
            errMsg = PNCommonComponents.concatString(strLineInfo,
                    "受託者勘定処理年月は有効な年月");
            // 　有効な日付でない場合、エラーとする。
// [UPD] Ver 3.0.0 - START
//            testDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                    new String[] { errMsg });
            testDay.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                    new String[] { errMsg });
// [UPD] Ver 3.0.0 - END
            if (0 < bizErrors.size()) {
                flgDateJtkshori = false;
                outDto.setBizErrors(bizErrors);
                break;
            }

// [UPD] Ver 3.0.0 - START
//            String seirekiJtkdhori = PNCommonComponents.dateFmtJC_Gyymm(
//                    PNCommonComponents.concatString(inM1Dto
//                            .getID_Date_Jtkshori_Gengo(), String
//                            .format("%02d", Integer.parseInt(inM1Dto
//                                    .getID_Date_Jtkshori_Nen())), String
//                            .format("%02d", Integer.parseInt(inM1Dto
//                                    .getID_Date_JtkshoriTsuki_Candidate()))),
//                    "");
            String seirekiJtkdhori = testDay.getSeireki().substring(0, 6);
// [UPD] Ver 3.0.0 - END

            // 貸付実行日チェック
            testDay = new PNCheckDay(
                    inM1Dto.getID_Date_Kashitsukejikko_Gengo(),
                    inM1Dto.getID_Date_Kashitsukejikko_Nen(),
                    inM1Dto.getID_Date_KashitsukejikkoTsuki_Candidate(),
                    inM1Dto.getID_Date_KashitsukejikkoBi_Candidate(),
                    pnCommonDBComponents, bizErrors);
            // 貸付実行日のS64入力無効チェック
            // 　　メッセージ：PTN_JKSN_021
            errMsg = PNCommonComponents.concatString(strLineInfo, "貸付実行日（年）");
            // 　S64の場合、エラーとする。
            testDay.addErrorS64(PNCommonMessageConstants.PM3291E,
                    new String[] { errMsg });
            if (0 < bizErrors.size()) {
                flgKashitsukejikko = false;
                outDto.setBizErrors(bizErrors);
                break;
            }

            StringBuffer dateKashitsukejikko = null;
            String kashitsukejikkoYYYYMM = "";
            // 貸付実行日の有効日付チェック
            // 　　メッセージ：CHK001
            errMsg = PNCommonComponents
                    .concatString(strLineInfo, "貸付実行日は有効な日付");
            // 　有効な日付でない場合、エラーとする。
            testDay.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                    new String[] { errMsg });
            if (0 == bizErrors.size()) {
                // 貸付実行日を西暦に変換してチェックを行う。
                String seirekiKashitsukejikkoNen = PNCommonComponents
                        .dateFmtJC_Gyy(PNCommonComponents.concatString(
                                inM1Dto.getID_Date_Kashitsukejikko_Gengo(),
                                inM1Dto.getID_Date_Kashitsukejikko_Nen()));
                dateKashitsukejikko = new StringBuffer(
                        PNCommonComponents.concatString(
                                seirekiKashitsukejikkoNen,
                                String.format(
                                        "%02d",
                                        Integer.parseInt(inM1Dto
                                                .getID_Date_KashitsukejikkoTsuki_Candidate())),
                                String.format(
                                        "%02d",
                                        Integer.parseInt(inM1Dto
                                                .getID_Date_KashitsukejikkoBi_Candidate()))));
                kashitsukejikkoYYYYMM = PNCommonComponents.concatString(
                        seirekiKashitsukejikkoNen,
                        String.format("%02d", Integer.parseInt(inM1Dto
                                .getID_Date_KashitsukejikkoTsuki_Candidate())));
                // 　貸付実行日の年月日入力チェック
                if (8 != dateKashitsukejikko.length()) {
                    // 　　8桁でない場合、エラーとする。
                    // 　　　メッセージ：CHK001
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "貸付実行日");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { errMsg }, false));
                    flgKashitsukejikko = false;
                    outDto.setBizErrors(bizErrors);
                    break;
                }
            }
            else {
                flgKashitsukejikko = false;
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 　　２．土曜日、日曜日の場合、エラーとする。
            // 　　　　　メッセージ：PTN_JKSN_018
            // 　　３．土日以外の非営業日の場合、エラーとする。
            // 　　　　　メッセージ：PTN_JKSN_018
            errMsg = PNCommonComponents.concatString(strLineInfo, "非営業日です。");
            testDay.addErrorDayBusinessDay(PNCommonMessageConstants.PM3000E,
                    new String[] { errMsg });
            if (0 < bizErrors.size()) {
                flgKashitsukejikko = false;
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 資金交付額（円）のチェック
            String skinKofu = "";
            if (true == flgSikinKofu) {
                skinKofu = inM1Dto.getID_M_SikinKofu().replaceAll("[,]", "");
                if (false == PNStringChecker.isAllHalfNumber(skinKofu)
                        || 11 < skinKofu.length()) {
                    // 　１．数値でない場合または11桁数より大きい場合、エラーとする。
                    // 　　　　メッセージ：PTN_JKSN_008
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "資金交付額は数値１１桁以内");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3140E,
                            new String[] { errMsg }, false));
                    flgSikinKofu = false;
                    outDto.setBizErrors(bizErrors);
                    break;
                }
            }

            // 顧客名の存在チェック
            bizErrors.addAll(checkCodeCustomer(inM1Dto.getID_Code_Customer(),
                    inM1Dto.getID_Code_Organization(), strLineInfo));
            if (0 < bizErrors.size()) {
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 扱店名の存在チェック
            bizErrors.addAll(checkCodeOrganization(
                    inM1Dto.getID_Code_Organization(), strLineInfo));
            if (0 < bizErrors.size()) {
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 受託者勘定処理年月エラーチェック
            flgDateJtkshori = isAlreadyInput(seirekiJtkdhori);
            flgKashitsukejikko = isAlreadyInput(kashitsukejikkoYYYYMM);
            if (true == flgDateJtkshori && true == flgKashitsukejikko) {
                // 西暦に変換されているとき
                if (Integer.parseInt(seirekiJtkdhori) < Integer
                        .parseInt(kashitsukejikkoYYYYMM)) {
                    // 　１．受託者勘定処理年月 < 貸付実行日年月の場合、エラーとする。
                    // 　　　　メッセージ：PTN_JKSN_014
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "貸付実行日が受託者勘定処理年月");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3260E,
                            new String[] { errMsg }, false));
                    outDto.setBizErrors(bizErrors);
                    break;
                }
            }

            // 業務日付取得
            String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
            String nowYear = new StringBuffer(nowDate).substring(0, 4);
            String nowMonth = new StringBuffer(nowDate).substring(4, 6);
            String nowYYYYMM = PNCommonComponents.concatString(nowYear,
                    nowMonth);
            if (true == flgDateJtkshori
                    && Integer.parseInt(seirekiJtkdhori) > Integer
                            .parseInt(nowYYYYMM)) {
                // 　２．受託者勘定処理年月 > 業務日付の年月の場合、エラーとする。
                // 　　　　メッセージ：PTN_JKSN_002
                errMsg = PNCommonComponents.concatString(strLineInfo,
                        "受託者勘定処理年月が報告日");
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(
                        PNCommonMessageConstants.PM3260E,
                        new String[] { errMsg }, false));
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 営業日数取得
            int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(nowDate);
            if (true == flgDateJtkshori && pnCommonDBComponents.isKessanki()) {
                // ３－１．決算期（業務日付が4月または10月）の場合
                if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
                    // 業務日付が第1～4営業日の場合
                    if (PNCommonComponents.diffMonthYYYYMM(nowDate, dateKashitsukejikko.toString()) >= 2) {
                        // 貸付実行日が業務日付の前々月以前の場合
                        if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, seirekiJtkdhori) != 1) {
                            // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                            // メッセージ：PM3150E
                            // 引数：(n案件目)受託者勘定処理年月に報告日の前月の年月
                            errMsg = PNCommonComponents.concatString(strLineInfo,
                                    "受託者勘定処理年月に報告日の前月の年月");
                            // メッセージを追加して継続
                            bizErrors.add(new PNMessageInfo(
                                    PNCommonMessageConstants.PM3150E,
                                    new String[] { errMsg }, false));
                            outDto.setBizErrors(bizErrors);
                            break;
                        }
                    }
                    else {
                        // 上記以外の場合
                        if (!seirekiJtkdhori.equals(kashitsukejikkoYYYYMM)) {
                            // 受託者勘定処理年月が貸付実行日の年月と異なる場合エラーとする。
                            // メッセージ：PM3150E
                            // 引数：(n案件目)受託者勘定処理年月に貸付実行日の年月
                            errMsg = PNCommonComponents.concatString(strLineInfo,
                                    "受託者勘定処理年月に貸付実行日の年月");
                            // メッセージを追加して継続
                            bizErrors.add(new PNMessageInfo(
                                    PNCommonMessageConstants.PM3150E,
                                    new String[] { errMsg }, false));
                            outDto.setBizErrors(bizErrors);
                            break;
                        }
                    }
                }
                else {
                    // 上記以外の場合（業務日付が第5～最終営業日）
                    if (!seirekiJtkdhori.equals(nowYYYYMM)) {
                        // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                        // メッセージ：PM3150E
                        // 引数：(n案件目)受託者勘定処理年月に報告日の年月
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "受託者勘定処理年月に報告日の年月");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3150E,
                                new String[] { errMsg }, false));
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                }
            }
            else {
                // ３－２．通常期（３－１以外）の場合
                if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                    // 業務日付が第1～10営業日の場合
                    if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, seirekiJtkdhori) > 1) {
                        // 受託者勘定処理年月が業務日付の年月または
                        // 業務日付の前月の年月と異なる場合エラーとする。
                        // メッセージ：PM3150E
                        // 引数：(n案件目)受託者勘定処理年月に報告日の年月または報告日の前月の年月
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "受託者勘定処理年月に報告日の年月または報告日の前月の年月");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3150E,
                                new String[] { errMsg }, false));
                        outDto.setBizErrors(bizErrors);
                        break;
                    }

                }
                else {
                    // 上記以外の場合（業務日付が第11～最終営業日）かつ
                    if (!seirekiJtkdhori.equals(nowYYYYMM)) {
                        // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                        // メッセージ：PM3150E
                        // 引数：(n案件目)受託者勘定処理年月に報告日の年月
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "受託者勘定処理年月に報告日の年月");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3150E,
                                new String[] { errMsg }, false));
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                }
            }

            // 貸付実行日エラーチェック
            if (true == flgKashitsukejikko) {
                if (true == isAlreadyInput(inM1Dto.getID_Date_SueokiKigen())) {
                    String sueokiKigen = PNCommonComponents.dateFmtJC_Gyymm(
                            inM1Dto.getID_Date_SueokiKigen(), ".").replace(".",
                            "");
                    if (Integer.parseInt(kashitsukejikkoYYYYMM) > Integer
                            .parseInt(sueokiKigen)) {
                        // 　１．貸付実行日の年月 > 据置期限年月の場合、エラーとする。
                        // 　　　　メッセージ：PTN_JKSN_011
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "貸付実行日が据置期限");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3260E,
                                new String[] { errMsg }, false));
                        flgKashitsukejikko = false;
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                }
                if (true == isAlreadyInput(inM1Dto.getID_Date_KetteiKisan())) {
                    if (Integer.parseInt(dateKashitsukejikko.toString()) < Integer
                            .parseInt(inM1Dto.getID_Date_KetteiKisan())) {
                        // 　２．貸付実行日 < 決定起算年月日の場合、エラーとする。
                        // 　　　　メッセージ：PTN_JKSN_005
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "貸付実行日は決定起算年月以降の日付");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3140E,
                                new String[] { errMsg }, false));
                        flgKashitsukejikko = false;
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                }
                if (Integer.parseInt(dateKashitsukejikko.toString()) > Integer
                        .parseInt(nowDate)) {
                    // 　３．貸付実行日　> 業務日付の場合、エラーとする。
                    // 　　　　メッセージ：PTN_JKSN_006
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "貸付実行日が報告日");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3260E,
                            new String[] { errMsg }, false));
                    flgKashitsukejikko = false;
                    outDto.setBizErrors(bizErrors);
                    break;
                }
            }
            // 資金交付額エラーチェック
            if (true == flgSikinKofu) {
                if (false == isAlreadyInput(inM1Dto.getID_M_Kashitsuke())) {
                    // 貸付実行金額が空白の場合、エラーとする。
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "貸付実行金額");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { errMsg }, false));
                    outDto.setBizErrors(bizErrors);
                    break;
                }
                else {
                    BigDecimal bdMKasituke = new BigDecimal(inM1Dto
                            .getID_M_Kashitsuke().replaceAll("[,]", ""));
                    BigDecimal bdSkinKofu = new BigDecimal(skinKofu);
                    if (bdSkinKofu.doubleValue() > bdMKasituke.doubleValue()) {
                        // 　資金交付額 > 貸付実行金額の場合、エラーとする。
                        // 　　メッセージ：PTN_JKSN_013
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "資金交付額が貸付実行金額");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3180E,
                                new String[] { errMsg }, false));
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                    // 貸付受入金受入額のセット
                    // 　資金交付額フラグ＝Trueの場合　
                    // 　　貸付受入金受入額＝貸付実行金額－資金交付金額
                    m1Dto.setID_M_KashitsukeUkeire(bdMKasituke.subtract(
                            bdSkinKofu).toString());
                }
            }
            else {
                // 　資金交付額フラグ＝True以外の場合　
                // 　　空白⇒貸付受入金受入額
                m1Dto.setID_M_KashitsukeUkeire("");
            }

            // 利率エラーチェック(未入力の場合、チェックをしない)
            if (true == isAlreadyInput(inM1Dto.getID_Riritsu())) {
                // 整数部桁数
                int iSeisu = 2;
                // 小数部桁数
                int iSyousu = 3;
                if (false == PNCommonComponents.checkHalfNum(
                        inM1Dto.getID_Riritsu(), iSeisu, iSyousu, true, false)) {
                    // 　１．利率が半角数値でない場合、エラーとする。
                    // 　　　　メッセージ：PN_CR001_06_01
                    // 　２．「nn.nnn」（2桁.3桁）または「nn」（2桁）の半角数値でない場合、エラーとする。
                    // 　　　　メッセージ：PN_CR001_06_02
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "利率は99.999形式");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3140E,
                            new String[] { errMsg }, false));
                    outDto.setBizErrors(bizErrors);
                    break;
                }

                try {
                    // 整数部の取得
                    Double dblCheckValue = 0d;
                    dblCheckValue = Double.parseDouble(inM1Dto.getID_Riritsu());

                    String strCkhValue = "";
                    strCkhValue = String.valueOf(dblCheckValue.intValue());
                    // 入力した整数部の取得
                    String inpRitsu = inM1Dto.getID_Riritsu();
                    if (0 < inM1Dto.getID_Riritsu().indexOf(".")) {
                        String[] nums = inM1Dto.getID_Riritsu().split("\\.");
                        inpRitsu = nums[0];
                    }
                    // 　３．入力した整数部の桁数と取得できた整数部の桁数が異なる場合、エラーとする。
                    // 　　　　メッセージ：PN_CR001_06_02
                    if (strCkhValue.length() != inpRitsu.length()) {
                        errMsg = PNCommonComponents.concatString(strLineInfo,
                                "利率に無効な値が指定されています。");
                        // メッセージを追加して継続
                        bizErrors.add(new PNMessageInfo(
                                PNCommonMessageConstants.PM3000E,
                                new String[] { errMsg }, false));
                        outDto.setBizErrors(bizErrors);
                        break;
                    }
                    else {
                        if (0.001d > dblCheckValue || 99.999 < dblCheckValue) {
                            // 　４．0.001　<=　利率　<= 99.999でない場合、エラーとする。
                            // 　　　　メッセージ：PN_CR001_06_02
                            errMsg = PNCommonComponents.concatString(
                                    strLineInfo, "利率に無効な値が指定されています。");
                            // メッセージを追加して継続
                            bizErrors.add(new PNMessageInfo(
                                    PNCommonMessageConstants.PM3000E,
                                    new String[] { errMsg }, false));
                            outDto.setBizErrors(bizErrors);
                            break;
                        }
                    }
                }
                catch (NumberFormatException e) {
                    e = null;
                    errMsg = PNCommonComponents.concatString(strLineInfo,
                            "利率に無効な値が指定されています。");
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(
                            PNCommonMessageConstants.PM3000E,
                            new String[] { errMsg }, false));
                    outDto.setBizErrors(bizErrors);
                    break;
                }
            }

            // 画面のメッセージが設定されていない場合、画面遷移を行う。
            // 画面の「選択」チェックボックスをチェックした案件のみ利率、特利の再計算を行う。
            // DTOの生成
            Cr001_01DTO inDto = new Cr001_01DTO();
            // DTOへの転記処理をここに実装
            // 報告年月日
            inDto.setTxtID_Date_Report(outDto.getTxtID_Date_Report());
            // ステータス
            inDto.setLblError(outDto.getLblError());
            // 明細リスト
            List<Cr001_01M1DTO> m1LIST = new java.util.ArrayList<Cr001_01M1DTO>();
            m1LIST.add(m1Dto);
            inDto.setMEISAI_LIST(m1LIST);

            // Serviceの呼び出し
            outDto = cr001_01service.getRiritsuTokuri(inDto);
            bizErrors.addAll(outDto.getBizErrors());
            if (0 < bizErrors.size()) {
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 選択された明細を設定
            outMeisaiList.add(m1Dto);
        }

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            return outDto;
        }

        // 画面のメッセージが設定されている場合または１件も選択されていない場合、エラーと扱い画面遷移は行わない。
        // １件も選択されていない場合
        if (0 == selectCnt) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3160E,
                    new String[] { "更新対象の案件" }, false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }
        outDto.setMEISAI_LIST(outMeisaiList);

        return outDto;
    }

    /**
     * 顧客名の存在チェック
     *
     * @param strCodeCustomer
     *            貸付先コード
     * @param strCodeOrganization
     *            扱店コード
     * @return LinkedList<PNMessageInfo> エラー情報
     */
    private LinkedList<PNMessageInfo> checkCodeCustomer(String strCodeCustomer,
            String strCodeOrganization, String strLineInfo) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // Serviceの呼び出し用のDTO生成
        Cr001_01DTO outDto = new Cr001_01DTO();
        List<Cr001_01M1DTO> outM1DtoList = new ArrayList<Cr001_01M1DTO>();
        Cr001_01M1DTO outM1Dto = new Cr001_01M1DTO();

        // 検索条件のセット
        outM1Dto.setID_Code_Customer(strCodeCustomer);
        outM1Dto.setID_Code_Organization(strCodeOrganization);
        outM1Dto.setLblIndex(strLineInfo);
        outM1DtoList.add(outM1Dto);
        outDto.setMEISAI_LIST(outM1DtoList);
        // Serviceの呼び出し
        outDto = cr001_01service.getAcustomer(outDto);

        // エラー情報取得
        bizErrors.addAll(outDto.getBizErrors());

        return bizErrors;
    }

    /**
     * 扱店名の存在チェック
     *
     * @param strCodeOrganization
     *            扱店コード
     * @return LinkedList<PNMessageInfo> エラー情報
     */
    private LinkedList<PNMessageInfo> checkCodeOrganization(
            String strCodeOrganization, String strLineInfo) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // Serviceの呼び出し用のDTO生成
        Cr001_01DTO outDto = new Cr001_01DTO();
        List<Cr001_01M1DTO> outM1DtoList = new ArrayList<Cr001_01M1DTO>();
        Cr001_01M1DTO outM1Dto = new Cr001_01M1DTO();

        // 検索条件のセット
        outM1Dto.setID_Code_Organization(strCodeOrganization);
        outM1Dto.setLblIndex(strLineInfo);
        outM1DtoList.add(outM1Dto);
        outDto.setMEISAI_LIST(outM1DtoList);

        // Serviceの呼び出し
        outDto = cr001_01service.getTenpo(outDto);

        // エラー情報取得
        bizErrors.addAll(outDto.getBizErrors());

        return bizErrors;
    }

    /**
     *
     * <pre>
     * 入力済みかどうか判定する
     * </pre>
     *
     * @param strVal
     *            判定対象文字列
     * @return false:nullまたは空白 true:null以外かつ空白以外
     */
    private boolean isAlreadyInput(String strVal) {
        // 戻り値初期化
        boolean ret = true;

        // 引数のチェック
        if (null == strVal) {
            // 引数がnullの場合、戻り値にfalseを設定
            ret = false;
        }
        else {
            if (0 == strVal.trim().length()) {
                // 引数が未入力の場合、戻り値にfalseを設定
                ret = false;
            }
        }
        // 戻り値返却
        return ret;
    }
}