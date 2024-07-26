//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/25 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/12/01 | 百々　諒馬            | 委託貸付報告等における機能改善
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.web;

import java.math.BigDecimal;
import java.text.MessageFormat;
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
import jp.go.jfc.partnernet.common.check.PNCheckMoney;
import jp.go.jfc.partnernet.cr002.common.Cr002Constants;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01DTO;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01M1DTO;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01Service;
import jp.go.jfc.partnernet.cr002.cr002_02.service.Cr002_02M1DTO;
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
 * このクラスはCr002_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr002_01Form")
@RequestMapping(value = "/Cr002_01Send.form")
public class Cr002_01SendController extends Cr002_01BaseController {

    /** Cr002_01Service */
    @Autowired
    Cr002_01Service cr002_01service;
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
    public String executeAction(Model model, Cr002_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {
        /** エラーリスト */
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // // // 入力データの各種チェックを案件分全て行う。
        Cr002_01DTO outCr002_01Dto = checkInput(form);
        bizErrors.addAll(outCr002_01Dto.getBizErrors());
        // エラーメッセージが設定されている場合、エラーとして扱い画面遷移は行わない。
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
        // エラーメッセージが設定されていない場合、画面遷移を行う。
        // 更新用データ取得と設定を行う。
        Cr002_01DTO inCr002_01Dto2 = new Cr002_01DTO();
        CFWBeanUtils.copyProperties(inCr002_01Dto2, outCr002_01Dto);
        // Serviceの呼び出し
        Cr002_01DTO outDtoUpdate = cr002_01service.getUpdateData(inCr002_01Dto2);
        bizErrors.addAll(outDtoUpdate.getBizErrors());
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }

        // 貸付受入金払出・充当報告書作成（入力結果画面）へ遷移する
        // 画面の「選択」チェックボックスをチェックした貸付受入金払出・充当報告書を抽出する。
        setRequestNextScreen(request, outDtoUpdate);

        return success(Cr002Constants.EVENT_ID_CR002_02INIT);
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
    public void displayControl(Model model, Cr002_01Form form, HttpServletRequest request) {

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param Cr002_01DTO DTO
     */
    private void setRequestNextScreen(HttpServletRequest request, Cr002_01DTO inDto) {
        List<Cr002_01M1DTO> updateList1 = inDto.getMEISAI_LIST();

        // 抽出したリストを遷移パラメータに設定する。
        // 遷移パラメーター設定
        List<Cr002_02M1DTO> updateList2 = new ArrayList<Cr002_02M1DTO>(updateList1.size());
        for (Cr002_01M1DTO inCr002_01M1DTO : updateList1) {
            Cr002_02M1DTO outCr002_02M1DTO = new Cr002_02M1DTO();
            if ("1".equals(inCr002_01M1DTO.getChkUpdate())) {
                CFWBeanUtils.copyProperties(outCr002_02M1DTO, inCr002_01M1DTO);
                // IDが異なるものをマッピングさせて設定
                // 調整コード(DB取得時)
                outCr002_02M1DTO.setID_Code_Chosei(inCr002_01M1DTO.getID_Code_Chosei_Save());
                // 調整コード
                outCr002_02M1DTO.setID_Code_Chosei_Candidate(inCr002_01M1DTO.getID_Code_Chosei());
                // 前回払出・貸付受入金残高
                outCr002_02M1DTO.setID_HDLas_M_HaraidashiKashitsukeZan(inCr002_01M1DTO
                        .getID_HDLas_M_KashitsukeukeireZan());
                outCr002_02M1DTO.setID_M_KashitukeUkeire(inCr002_01M1DTO.getID_M_KashitsukeUkeire());

                // 貸付受入金残高(プロパティ名のuが大文字/小文字で異なる)
                outCr002_02M1DTO.setID_M_KashitsukeUkeireZan(inCr002_01M1DTO.getID_M_KashitsukeukeireZan());
                // 資金交付額
                outCr002_02M1DTO.setID_M_SikinKofu(inCr002_01M1DTO.getID_M_ShikinKofu());
                updateList2.add(outCr002_02M1DTO);
            }
        }

        addForwardParameter(request, Cr002Constants.PROPERTY_ID_DATE_REPORT, inDto.getTxtID_Date_Report());
        addForwardParameter(request, Cr002Constants.MEISAI_ANKENLIST, updateList2);
    }

    /**
     * 入力チェック
     *
     * @param form formクラス
     * @return Cr002_01DTO
     */
    private Cr002_01DTO checkInput(Cr002_01Form form) {

        Cr002_01DTO outDTO = new Cr002_01DTO();
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        CFWBeanUtils.copyProperties(outDTO, form);
        PNPagingTable<Cr002_01M1DTO> cr002_01M1DTO = form.getCr002_01M1Table();
        List<Cr002_01M1DTO> inM1DtoList = cr002_01M1DTO.getRecordList();

        boolean bSelecct = false;
        // 選択チェックボックスに１つもチェックがない場合、エラーとする。
        for (Cr002_01M1DTO m1Dto : inM1DtoList) {
            // 選択チェックボックス
            if ("1".equals(m1Dto.getChkUpdate())) {
                bSelecct = true;
                break;
            }
        }

        if (!bSelecct) {
            bizErrors
                    .add(new PNMessageInfo(PNCommonMessageConstants.PM3160E, new String[] { "更新対象の案件" }, false));
            outDTO.setBizErrors(bizErrors);
            return outDTO;
        }

        int i = 1;
        List<Cr002_01M1DTO> newM1DtoList = new ArrayList<Cr002_01M1DTO>(inM1DtoList.size());
        for (Cr002_01M1DTO inM1Dto : inM1DtoList) {
            // 明細DTOのコピーを作成
            Cr002_01M1DTO m1Dto = new Cr002_01M1DTO();
            CFWBeanUtils.copyProperties(m1Dto, inM1Dto);
            // ※単項目及び相関チェックは、選択チェックボックスがチェックされている案件のみ行う。
            if ("1".equals(m1Dto.getChkUpdate())) {

                // エラーメッセージ表示時、以下のフォーマットで表示する。
                // ３案件目の報告書番号コントロールで必須エラー時、「報告書番号(3案件目)：必須項目に値が入力されていません。」
                // ※先頭の固定文言(「報告書番号」)はメッセージ欄の【】内文言を付加する。
                // ※先頭の「(ｎ案件目)」はチェックしている案件処理番号を編集して付加する。
                // チェックでエラーが発生した場合、メッセージを蓄積し後続のチェックを継続する。チェック終了後、発生エラー毎に改行して一括表示する。

                // Form項目の受託者勘定処理年月エラーをTrue（エラー無し）で初期化する。
                // Form項目の払出元金充当日エラーをTrue（エラー無し）で初期化する。
                // Form項目の資金払出額エラーをTrue（エラー無し）で初期化する。
                // Form項目の元金充当額エラーをTrue（エラー無し）で初期化する。
                // Form項目の元金充当後元金均等額エラーをTrue（エラー無し）で初期化する。
                // Form項目の元金充当後元金不均等額エラーをTrue（エラー無し）で初期化する。
                // Form項目の繰上償還事由コードをTrue（エラー無し）で初期化する。
                // Form項目の調整コードエラーをTrue（エラー無し）で初期化する。

                //
                // *******************************************************************
                // キー入力チェック
                // *******************************************************************
                // 報告書番号のチェック
                // １．空白の場合、エラーとする。
                // ST-0110
                // このタイミングでは報告書番号チェックは不要。
                // 報告書履歴作成時に別途報告書番号を取得するため。

                // 事業別エラーチェック(未入力の場合、チェックをしない)
                // １．半角英数字カナでない場合、エラーとする。

                if (!isEmpty(m1Dto.getID_Code_Jigyobetsu())) {
                    if (!isHalfAlphakana(m1Dto.getID_Code_Jigyobetsu())) {
                        // メッセージ：PM3140E
                        bizErrors
                                .add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                        new String[] { MessageFormat.format("{0}案件目：事業別コードは半角英数字カナ２文字",
                                                numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    else {
                        // ２．2桁でない場合、エラーとする。
                        if (2 != m1Dto.getID_Code_Jigyobetsu().length()) {
                            // メッセージ：PM3140E
                            // エラーメッセージ(共通)：【半角英数字カナ２文字】で入力してください。
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[] { MessageFormat.format("{0}案件目：事業別コードは半角英数字カナ２文字",
                                            numToZenNum(i)) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                }

                // *******************************************************************
                // 必須・条件入力チェック
                // *******************************************************************
                // 受託者勘定処理年月チェッククラス
// [UPD] Ver 3.0.0 - START
//                PNCheckDay date_Jtkshori = new PNCheckDay(m1Dto.getID_Date_Jtkshori_Gengo(),
//                        m1Dto.getID_Date_Jtkshori_Nen(), m1Dto.getID_Date_JtkshoriTsuki_Candidate(), "01",
//                        pnCommonDBComponents, bizErrors);
                PNCheckDay date_Jtkshori = new PNCheckDay(m1Dto.getID_Date_Jtkshori_Gengo(),
                        m1Dto.getID_Date_Jtkshori_Nen(), m1Dto.getID_Date_JtkshoriTsuki_Candidate(), "",
                        pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END

                // 受託者勘定処理年月の年、月のチェック
                // １．年、月のいずれかが空白の場合、エラーとする。
                // メッセージ：PM3120E 【受託者勘定処理年月（月）】 ※受託者勘定処理年月エラーをFalseとする。
// [UPD] Ver 3.0.0 - START
//                date_Jtkshori.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
//                        new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月", numToZenNum(i)) });
                date_Jtkshori.addErrorDayRequiredMonth(PNCommonMessageConstants.PM3120E,
                        new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月", numToZenNum(i)) });
// [UPD] Ver 3.0.0 - END
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 払出元金充当日チェッククラス
                PNCheckDay date_HaraidashiJuto = new PNCheckDay(m1Dto.getID_Date_HaraidashiJuto_Gengo(),
                        m1Dto.getID_Date_HaraidashiJuto_Nen(),
                        m1Dto.getID_Date_HaraidashiJutoTsuki_Candidate(),
                        m1Dto.getID_Date_HaraidashiJutoBi_Candidate(), pnCommonDBComponents, bizErrors);

                // 払出元金充当日の年、月、日のチェック
                // １．年、月、日のいずれかが空白の場合、エラーとする。
                // メッセージ：PM3120E　【払出元金充当日（月）】　　　※払出元金充当日エラーをFalseとする。
                date_HaraidashiJuto.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
                        new String[] { MessageFormat.format("{0}案件目：払出元金充当日", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 資金払出額(円)のチェック
                PNCheckMoney haraidashi = new PNCheckMoney(m1Dto.getID_M_Haraidashi(), bizErrors);

                // １．空白の場合、エラーとする。
                // メッセージ：PM3120E　【資金払出額】　　※資金払出額エラーをFalseにする。
                haraidashi.addErrorMonneyRequiredMoney(PNCommonMessageConstants.PM3120E,
                        new String[] { MessageFormat.format("{0}案件目：資金払出額", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ２．入力値が整数値(0～9)以外の場合、エラーとする。
                // メッセージ：PM3140E　【資金払出額（円）】　　※資金払出額エラーをFalseにする。
                if (!PNStringChecker.isAllHalfNumber(m1Dto.getID_M_Haraidashi())) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { MessageFormat.format("{0}案件目：資金払出額は半角数字11桁以下", numToZenNum(i)) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ３．11桁より大きい場合、エラーとする。
                // メッセージ：PM3180E　【資金払出額】　　※資金払出額エラーをFalseにする。
                haraidashi.addErrorMonneyOverLength(11, PNCommonMessageConstants.PM3180E,
                        new String[] { MessageFormat.format("{0}案件目：資金払出額が１１文字", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 元金充当額(円)のチェック
                PNCheckMoney ganju = new PNCheckMoney(m1Dto.getID_M_Ganju(), bizErrors);
                // １．空白の場合、エラーとする。
                // メッセージ：PM3120E　【元金充当額】　　※元金充当額エラーをFalseにする
                ganju.addErrorMonneyRequiredMoney(PNCommonMessageConstants.PM3120E,
                        new String[] { MessageFormat.format("{0}案件目：元金充当額", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ２．入力値が整数値(0～9)以外の場合、エラーとする。
                // メッセージ：PM3140E　【元金充当額（円）】　　※元金充当額エラーをFalseにする
                if (!PNStringChecker.isAllHalfNumber(m1Dto.getID_M_Ganju())) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { MessageFormat.format("{0}案件目：元金充当額は半角数字11桁以下", numToZenNum(i)) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ３．11桁より大きい場合、エラーとする。
                // メッセージ：PM3180E　【元金充当額】　　※元金充当額エラーをFalseにする
                ganju.addErrorMonneyOverLength(11, PNCommonMessageConstants.PM3180E,
                        new String[] { MessageFormat.format("{0}案件目：元金充当額が１１文字", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // *******************************************************************
                // 画面固有チェック
                // *******************************************************************
                // 資金払出額と元金充当額チェック
                // ※資金払出額エラー無しかつ、元金充当額チェックエラー無しのみ実施する。
                // １．資金払出額(円)＝０かつ元金充当額(円)＝０の場合、エラーとする。
                // メッセージ：PM3120E　【資金払出額，元金充当額】　　※資金払出額エラー、元金充当額チェックエラーをFalseにする。
                if (0 == BigDecimal.ZERO
                        .compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Haraidashi()))
                        && 0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                                .getID_M_Ganju()))) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                            new String[] { MessageFormat.format("{0}案件目：資金払出額、元金充当額のどちらにも金額", numToZenNum(i)) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // 繰上償還コードチェック
                // １．元金充当額エラー無しかつ、元金充当額(円)＞０かつ，繰上償還コードが未入力の場合、エラーとする。
                if ((0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju())) && isEmpty(m1Dto
                        .getID_Code_KurishoJiyu()))) {
                    // メッセージ：PM3120E　【繰上償還事由コード】　　※繰上償還事由コードエラーをFalseにする
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                            new String[] { MessageFormat.format("{0}案件目：繰上償還事由コード", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ２．元金充当額エラー無しかつ、元金充当額(円)≦０かつ、繰上償還コードが入力ありの場合、エラーとする。
                if (0 <= (BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju())))
                        && !isEmpty(m1Dto.getID_Code_KurishoJiyu())) {
                    // メッセージ：PM3130E　【繰上償還事由コード】　　※繰上償還事由コードエラーをFalseにする
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E,
                            new String[] { MessageFormat.format("{0}案件目：元金充当額の金額入力があり、繰上償還事由コード",
                                    numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // 償還方法タイプ識別値を0で初期化
                m1Dto.setType_Shokan("0");
                // ３．元金充当額エラー無しかつ、繰上償還事由コードエラー無しかつ、元金充当額(円)＞０の場合
                if (0 > (BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju())))) {
                    // 稟議・償還方法コード値と繰上償還事由コード(DB取得時)の値にてForm定義の償還方法タイプ識別値を設定する
                    String stTypeShokan = getTypeShokan(m1Dto.getID_Code_ShokanHouhou(),
                            m1Dto.getID_Code_KurishoJiyu());
                    m1Dto.setType_Shokan(stTypeShokan);
                    if ("7".equals(m1Dto.getType_Shokan())) {
                        // メッセージ：PM3140E　【繰上償還事由コード】
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：繰上償還事由コードは償還方法と繰上償還方法を正しい組み合わせ",
                                        numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    else if ("8".equals(m1Dto.getType_Shokan())) {
                        // メッセージ：PM3190E　【繰上償還事由コード】
                        bizErrors
                                .add(new PNMessageInfo(
                                        PNCommonMessageConstants.PM3190E,
                                        new String[] { MessageFormat.format("{0}案件目：繰上償還事由コード", numToZenNum(i)) },
                                        false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }

                    // ３．１．償還方法タイプ識別値が３の場合、以下のチェックを行う
                    if ("3".equals(m1Dto.getType_Shokan())) {
                        // ①　元金充当後の元金均等額が空白の場合、エラーとする。
                        if (isEmpty(m1Dto.getID_M_GankinKintoAfterGanju())) {
                            // メッセージ：PM3120E　【元金充当後元金均等額】 　　　　　※元金充当後元金均等額エラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[] { MessageFormat.format("{0}案件目：元金充当後元金均等額", numToZenNum(i)) },
                                    false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                        // ②元金充当後の元金不均等額が空白の場合、エラーとする。
                        if (isEmpty(m1Dto.getID_M_GankinFukintoAfterGanju())) {
                            // メッセージ：PM3120E　【元金充当後元金不均等額】　　　　※元金充当後元金不均等額エラーをFalaeにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E,
                                    new String[] { MessageFormat.format("{0}案件目：元金充当後元金不均等額", numToZenNum(i)) },
                                    false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                    else {
                        // ３．２．償還方法タイプ識別値が３でない場合、以下のチェックを行う　
                        // ①元金充当後の元金均等額が入力されている場合、エラーとする。
                        // 0の場合は未入力とみなす。
                        if (!"0".equals(m1Dto.getID_M_GankinKintoAfterGanju())) {
                            if (!isEmpty(m1Dto.getID_M_GankinKintoAfterGanju())) {
                                // メッセージ：PM3130E　【元金充当後元金均等額】　　　　　※元金充当後元金均等額エラーをFalseにする
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E,
                                        new String[] { MessageFormat
                                                .format("{0}案件目：元金充当後元金均等額", numToZenNum(i)) }, false));
                                outDTO.setBizErrors(bizErrors);
                                return outDTO;
                            }
                        }
                        // ②元金充当後の元金不均等額が入力されている場合、エラーとする。
                        // 0の場合は未入力とみなす。
                        if (!"0".equals(m1Dto.getID_M_GankinKintoAfterGanju())) {
                            if (!isEmpty(m1Dto.getID_M_GankinFukintoAfterGanju())) {
                                // メッセージ：PM3130E　【元金充当後元金不均等額】　　　　※元金充当後元金不均等額エラーをFalaeにする
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E,
                                        new String[] { MessageFormat.format("{0}案件目：元金充当後元金不均等額",
                                                numToZenNum(i)) }, false));
                                outDTO.setBizErrors(bizErrors);
                                return outDTO;
                            }
                        }
                        // ③調整コードが入力されている場合、エラーとする。
                        if (!isEmpty(m1Dto.getID_Code_Chosei())) {
                            // メッセージ：PM3140E　【調整コード】　　　　　※調整コードエラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[] { MessageFormat.format("{0}案件目：調整コードは「なし」", numToZenNum(i)) },
                                    false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }

                }

                // *******************************************************************
                // 入力内容チェック
                // *******************************************************************
                // 受託者勘定処理年月の日付のチェック　　※受託者勘定処理年月エラー無しの場合のみ実施する
                // １．受託者勘定処理年月（元号）＋受託者勘定処理年月（年）が”S64"の場合、エラーとする。
                // メッセージ：PM3291E　【受託者勘定処理年月】　　　　　※受託者勘定処理年月エラーをFalseにする
                date_Jtkshori.addErrorS64(PNCommonMessageConstants.PM3291E,
                        new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月に", numToZenNum(i)) });
                if (0 < bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ２．「１．」のチェックがＯＫの場合、事前に受託者勘定処理年月を編集する。
                // チェック後に保持する

                // ３．「１．」のチェックがＯＫでかつ、受託者勘定処理年月が6桁でない場合、エラーとする。
                // ４．「１．」「３．」のチェックがＯＫでかつ、受託者勘定処理年月が有効な日付でない場合、エラーとする。
                // メッセージ：PM3140E　【受託者勘定処理年月】　　　　　※受託者勘定処理年月エラーをFalseにする
// [UPD] Ver 3.0.0 - START
//                date_Jtkshori.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                        new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月は有効日付", numToZenNum(i)) });
                date_Jtkshori.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                        new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月は有効日付", numToZenNum(i)) });
// [UPD] Ver 3.0.0 - END
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 受託者勘定処理年月　=　受託者勘定処理年月（元号）と受託者勘定処理年月（年）と受託者勘定処理年月（月）を連結し西暦変換 (YYYYMM)
                m1Dto.setID_Date_Jtkshori(date_Jtkshori.getSeireki().substring(0, 6));
                // 業務日付取得
                String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
                String nowYear = new StringBuffer(nowDate).substring(0, 4);
                String nowMonth = new StringBuffer(nowDate).substring(4, 6);
                String nowYYYYMM = PNCommonComponents.concatString(nowYear, nowMonth);

                // 営業日数取得
                int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(nowDate);

                // 受託者勘定処理年月を西暦に変換
// [UPD] Ver 3.0.0 - START
//                String seirekiJtkdhori = PNCommonComponents.dateFmtJC_Gyymm(
//                        PNCommonComponents.concatString(
//                                inM1Dto.getID_Date_Jtkshori_Gengo(),
//                                String.format("%02d", Integer.parseInt(
//                                        inM1Dto.getID_Date_Jtkshori_Nen())),
//                                String.format("%02d", Integer.parseInt(
//                                        inM1Dto.getID_Date_JtkshoriTsuki_Candidate()))), "");
                String seirekiJtkdhori = date_Jtkshori.getSeireki().substring(0, 6);
// [UPD] Ver 3.0.0 - END

                if (pnCommonDBComponents.isKessanki()) {
                    // ５－１．決算期（業務日付4月または10月）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {

                        // 払出元金充当日を西暦に変換
                        String seireki_HaraidashiJuto = PNCommonComponents.dateFmtJC_Gyymm(
                                PNCommonComponents.concatString(
                                        inM1Dto.getID_Date_HaraidashiJuto_Gengo(),
                                        String.format("%02d", Integer.parseInt(
                                                inM1Dto.getID_Date_HaraidashiJuto_Nen())),
                                        String.format("%02d", Integer.parseInt(
                                                inM1Dto.getID_Date_HaraidashiJutoTsuki_Candidate()))), "");

                        // 業務日付が第1～4営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(nowDate, seireki_HaraidashiJuto) >= 2) {
                            // 払出元金充当日が業務日付の前々月以前の場合
                            if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, seirekiJtkdhori) != 1) {
                                // 受託者勘定処理年月が業務日付の前月の年月と異なる場合エラーとする。
                                // メッセージ：{0}案件目：受託者勘定処理年月に報告日の前月の年月、PM3150E※受託者勘定処理年月エラーをFalseにする
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                        new String[] { MessageFormat.format(
                                                "{0}案件目：受託者勘定処理年月に報告日の前月の年月",
                                                numToZenNum(i)) }, false));
                                outDTO.setBizErrors(bizErrors);
                                return outDTO;
                            }
                        }
                        else {
                            // 上記以外の場合
                            if (!seirekiJtkdhori.equals(seireki_HaraidashiJuto)) {
                                // 受託者勘定処理年月が払出元金充当日の年月と異なる場合エラーとする。
                                // メッセージ：{0}案件目：受託者勘定処理年月に払出元金充当日の年月、PM3150E※受託者勘定処理年月エラーをFalseにする
                                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                        new String[] { MessageFormat.format(
                                                "{0}案件目：受託者勘定処理年月に払出元金充当日の年月",
                                                numToZenNum(i)) }, false));
                                outDTO.setBizErrors(bizErrors);
                                return outDTO;
                            }
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第5～最終営業日）
                        if (!seirekiJtkdhori.equals(nowYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // メッセージ：{0}案件目：受託者勘定処理年月に報告日の年月、PM3150E※受託者勘定処理年月エラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                    new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月に報告日の年月",
                                            numToZenNum(i)) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                }
                else {
                    // ５－２．通常期（５－１以外）の場合
                    if (1 <= ordinalBizDate && ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {
                        // 業務日付が第1～10営業日の場合
                        if (PNCommonComponents.diffMonthYYYYMM(nowYYYYMM, seirekiJtkdhori) > 1) {
                            // 受託者勘定処理年月が業務日付の年月または、業務日付の前月の年月と異なる場合エラーとする。
                            // メッセージ：{0}案件目：受託者勘定処理年月に報告日の年月または報告日の前月の年月を、PM3150E ※受託者勘定処理年月エラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                    new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月に報告日の年月または報告日の前月の年月",
                                            numToZenNum(i)) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                    else {
                        // 上記以外の場合（業務日付が第11～最終営業日）
                        if (!seirekiJtkdhori.equals(nowYYYYMM)) {
                            // 受託者勘定処理年月が業務日付の年月と異なる場合エラーとする。
                            // メッセージ：{0}案件目：受託者勘定処理年月に報告日の年月、PM3150E※受託者勘定処理年月エラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                    new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月に報告日の年月",
                                            numToZenNum(i)) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                }

                // 払出元金充当日の日付のチェック１　※払出元金充当日エラー無しの場合のみ実施する。
                // １．受託者勘定処理年月（元号）＋受託者勘定処理年月（年）が”S64"の場合、エラーとする。
                date_HaraidashiJuto.addErrorS64(PNCommonMessageConstants.PM3291E,
                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日に", numToZenNum(i)) });
                if (0 < bizErrors.size()) {
                    // メッセージ：PM3291E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ２．「１．」のチェックがＯＫの場合、払出元金充当日を編集する。
                // チェック後に保持する

                // ３．「１．」のチェックがＯＫでかつ。払出元金充当日が8桁でない場合、エラーとする。
                // ４．「１．」「３．」のチェックがＯＫでかつ、払出元金充当日が有効な日付でない場合、エラーとする。
                // メッセージ：PM3140E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                date_HaraidashiJuto.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は有効日付", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 払出元金充当日　=　払出元金充当日（元号）と払出元金充当日（年）と払出元金充当日（月）と払出元金充当日（日）を連結し西暦変換 (YYYYMMDD)
                String date_HaraidashiJutoSeireki = date_HaraidashiJuto.getSeireki();
                m1Dto.setID_Date_HaraidashiJuto(date_HaraidashiJutoSeireki);

                // 払出元金充当日の日付のチェック２　※払出元金充当日エラー無しの場合のみ実施する。
                // １．払出元金充当日の年月日が存在しない場合、エラーとする。
                // ※払出元金充当日年月の最終日付＜払出元金充当日の日付でない事をチェックする。
                // メッセージ：PM3120E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                date_HaraidashiJuto.addErrorDayOverEndMonthDay(m1Dto.getID_Date_HaraidashiJuto(),
                        PNCommonMessageConstants.PM3120E,
                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                else {
                    // ２．「１．」のチェックがＯＫでかつ、払出元金充当日が非営業日（土日含む）の場合、エラーとする。(共通部品にてチェック）
                    // メッセージ：PM3331E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                    date_HaraidashiJuto.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は", numToZenNum(i)) });
                    if (0 != bizErrors.size()) {
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                }

                // 元金充当額(円)＞０かつ、償還方法タイプ識別値が３の場合、以下のチェックを行う。　　　　　※元金充当額エラー無しの場合のみ実施する。
                if ("3".equals(m1Dto.getType_Shokan())
                        && (0 > (BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                                .getID_M_Ganju()))))) {

                    // １．元金充当後元金均等額エラー無しかつ、元金充当後元金均等額(円)が整数値(0～9)以外の場合、エラーとする。
                    if (!PNStringChecker.isAllHalfNumber(m1Dto.getID_M_GankinKintoAfterGanju())) {
                        // メッセージ：PM3140E　【元金充当後元金均等額（円）】　　　　　※元金充当後元金均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後元金均等額（円）は半角数値11桁以下",
                                        numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ２．元金充当後元金不均等額エラー無しかつ、元金充当後元金不均等額(円)が整数値(0～9)以外の場合、エラーとする。
                    if (!PNStringChecker.isAllHalfNumber(m1Dto.getID_M_GankinFukintoAfterGanju())) {
                        // メッセージ：PM3140E　【元金充当後元金不均等額（円）】　　　※元金充当後元金不均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後元金不均等額（円）は半角数値11桁以下",
                                        numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // *******************************************************************
                    // 桁数チェック
                    // *******************************************************************
                    // ３．元金充当後元金均等額(円)の桁数が11桁より大きい場合、エラーとする。
                    if (11 < (PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_GankinKintoAfterGanju())
                            .precision())) {
                        // メッセージ：PM3180E　「元金充当後元金均等額」　　　　　※元金充当後元金均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後元金均等額が１１文字", numToZenNum(i)) },
                                false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ４．元金充当後元金不均等額(円)の桁数が11桁より大きい場合、エラーとする。
                    if (11 < (PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_GankinFukintoAfterGanju())
                            .precision())) {
                        // メッセージ：PM3180E　「元金充当後元金不均等額」　　　　※元金充当後元金不均等額エラーをFalseにする
                        bizErrors
                                .add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                        new String[] { MessageFormat.format("{0}案件目：元金充当後元金不均等額が１１文字",
                                                numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                }

                // *******************************************************************
                // 貸付受入金払出充当報告書　画面固有の入力チェック
                // *******************************************************************
                // 顧客名の存在チェック
                // サービスを実行し、扱店別顧客データの存在チェックをする。
                Cr002_01M1DTO outAcustomerDto = cr002_01service.getAcustomer(m1Dto);
                // データ無しの場合、エラーとする。
                if (0 == outAcustomerDto.getResultData_Kensu()) {
                    // エラーメッセージ：PM9061E 【顧客名】
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9061E,
                            new String[] { MessageFormat.format("{0}案件目：顧客名の", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 扱店名の存在チェック
                // サービスを実行し、金融機関店舗データの存在チェックをする。
                Cr002_01M1DTO outTenpo = cr002_01service.getTenpo(m1Dto);
                // データ無しの場合、エラーとする。
                if (0 == outTenpo.getResultData_Kensu()) {
                    // エラーメッセージ：PM9061E　【扱店名】
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9061E,
                            new String[] { MessageFormat.format("{0}案件目：扱店の", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 受託者勘定処理年月と払出元金充当日の相関のチェック　※受託者勘定処理年月エラー無しかつ、払出元金充当日エラー無しのみチェックする
                // １．受託者勘定処理年月 < 払出元金充当日の年月の場合、エラーとする
                // メッセージ：PM3260E　【受託者勘定処理年月】
                if (0 > m1Dto.getID_Date_Jtkshori().compareTo(
                        m1Dto.getID_Date_HaraidashiJuto().substring(0, 6))) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3260E,
                            new String[] { MessageFormat
                                    .format("{0}案件目：払出元金充当日が受託者勘定処理年月", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ２．受託者勘定処理年月 > 報告日（今日の年月）の場合、エラーとする。
                // メッセージ：PM3260E　【受託者勘定処理年月】
                if (0 < m1Dto.getID_Date_Jtkshori().compareTo(outDTO.getTxtID_Date_Report().substring(0, 6))) {
                    bizErrors
                            .add(new PNMessageInfo(
                                    PNCommonMessageConstants.PM3260E,
                                    new String[] { MessageFormat.format("{0}案件目：受託者勘定処理年月が報告日", numToZenNum(i)) },
                                    false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // 払出元金充当日の相関チェック　　　※払出元金充当日エラー無しのみチェックする
                // １．貸付実行日に値が無い場合、エラーとする。
                // メッセージ：PM3200E　【払出・元金充当日】
                if (isEmpty(m1Dto.getID_Date_Jikko())) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は貸付実行日が存在しないため比較",
                                    numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ２．「１．」のチェックがＯＫでかつ、払出元金充当日 < 貸付実行日の場合、エラーとする。
                // メッセージ：PM3150E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                date_HaraidashiJuto.addErrorDayUnderDay(m1Dto.getID_Date_Jikko(),
                        PNCommonMessageConstants.PM3150E,
                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は貸付実行日以降の日付", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ３．「１．」のチェックがＯＫでかつ、払出・元金充当日 = 貸付実行日かつ、資金払出額エラー無しかつ、元金充当額エラー無しかつ
                // （資金払出額（入力値）　＜＞　０　又は　元金充当額（入力値）　＝　０）の場合、エラーとする
                // メッセージ：PM3150E　【払出・元金充当日】　　　　　※払出元金充当日エラーをFalseにする
                if (0 == m1Dto.getID_Date_HaraidashiJuto().compareTo(m1Dto.getID_Date_Jikko())) {
                    if (0 != BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_Haraidashi()))
                            || 0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                                    .getID_M_Ganju()))) {
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は貸付実行日以降の日付",
                                        numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }

                }

                // 最新変更年月日のチェック
                // １．最新変更年月日に値が無い場合、エラーとする。
                // メッセージ：PM3200E　【払出・元金充当日】
                if (isEmpty(m1Dto.getID_Date_SaishinHenko())) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は最新変更年月日が存在しないため比較",
                                    numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // 最新変更年月日チェック正常時、以下のチェックを行う

                // 払出・元金充当日と最新変更年月日のチェック
                // ３案件目でエラー時、「払出・元金充当日(3案件目)[最新変更年月日：xxxx]：最新変更年月日以降の日付が指定されていません。」
                // ※「(ｎ案件目)」はチェックしている案件処理番号を編集して付加する。

                // ※[最新変更年月日：xxxx]のxxxxは、最新変更日を和暦に変換(GEE/MM/DD)に変換し、年、月、日の頭０をサプレスして編集する（H01/02/03→H1.2.3)
                // １．払出・元金充当日 < 最新変更年月日の場合、エラーとする。
                if (0 > m1Dto.getID_Date_HaraidashiJuto().compareTo(m1Dto.getID_Date_SaishinHenko())) {
                    // メッセージ：PM3150E
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は最新変更年月日以降の日付[{1}]",
                                    numToZenNum(i),
                                    PNCommonComponents.dateFmtAD_YYYYMMDD(m1Dto.getID_Date_SaishinHenko())) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ２．払出・元金充当日 = 最新変更年月日かつ、貸付実行日 <> 最新変更年月日の場合、エラーとする。
                if ((0 == m1Dto.getID_Date_HaraidashiJuto().compareTo(m1Dto.getID_Date_SaishinHenko()))
                        && (0 != m1Dto.getID_Date_Jikko().compareTo(m1Dto.getID_Date_SaishinHenko()))) {
                    // メッセージ：PM3150E
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は最新変更年月日以降の日付[{1}]",
                                    numToZenNum(i),
                                    PNCommonComponents.dateFmtAD_YYYYMMDD(m1Dto.getID_Date_SaishinHenko())) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ３．払出・元金充当日 = 最新変更年月日かつ、貸付実行日 ＝ 最新変更年月日かつ、資金払出額エラー無しかつ、元金充当額エラー無しかつ、
                // （資金払出額（入力値）　＜＞　０　又は　元金充当額（入力値）　＝　０）の場合、エラーとする
                // メッセージ：PM3150E
                if ((0 == m1Dto.getID_Date_HaraidashiJuto().compareTo(m1Dto.getID_Date_SaishinHenko()))
                        && (0 == m1Dto.getID_Date_Jikko().compareTo(m1Dto.getID_Date_SaishinHenko()))) {
                    if (0 != BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_Haraidashi()))
                            || 0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                                    .getID_M_Ganju()))) {
                        // メッセージ：PM3150E
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3150E,
                                new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は最新変更年月日以降の日付[{1}]",
                                        numToZenNum(i), PNCommonComponents.dateFmtAD_YYYYMMDD(m1Dto
                                                .getID_Date_SaishinHenko())) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                }
                // 入金履歴データに債権管理番号一致かつ、払込年月日＝払出元金充当日のデータが存在するかチェック。
                // ※但し、充当処理コード＝31、32、34、44はチェック対象外とする。
                // サービスを実行し、入金履歴データの存在チェックをする。
                // Cr002_01Service.getNyukinHistory // DTOの生成

                // Cr002_01M1DTOの呼び出し
                Cr002_01M1DTO outNyukinHistoryDto = cr002_01service.getNyukinHistory(m1Dto);

                // データ無し以外の場合、エラーとする。
                // エラーメッセージ：PM3401E　【払出・元金充当日】
                if (0 < outNyukinHistoryDto.getResultData_Kensu()) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3401E,
                            new String[] { MessageFormat.format("{0}案件目：", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 払出元金充当日と 報告日のチェック。
                // １．払出元金充当日 > 報告日（今日の日付）合、エラーとする。
                // メッセージ：PM3260E　【払出・元金充当日】
                date_HaraidashiJuto.addErrorDayOverToDay(PNCommonMessageConstants.PM3260E,
                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日が報告日", numToZenNum(i)) });
                if (0 != bizErrors.size()) {
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // 払出・元金充当日と償還期限年月のチェック
                // １．償還期限年月に値が無い場合、エラーとする。
                // メッセージ：PM3200E　【払出・元金充当日】
                if (isEmpty(m1Dto.getID_Keep_Date_ShokanKigen())) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                            new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は償還期限年月が存在しないため比較",
                                    numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ２．払出・元金充当日 > 償還期限年月の場合、エラーとする。
                // メッセージ：PM3140E　【払出・元金充当日】
                String yearMonthHaraidashiJuto = m1Dto.getID_Date_HaraidashiJuto().substring(0, 6);

                if (0 < yearMonthHaraidashiJuto.compareTo(m1Dto.getID_Keep_Date_ShokanKigen())) {
                    bizErrors
                            .add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                    new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は償還期限年月以前の日付",
                                            numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // 請求データの存在チェック　※元金充当額エラー無しの場合のみ実施する。
                // １．元金充当額＞０円の場合、チェックを行う
                if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()))) {
                    // 請求データに対して、債権管理番号一致かつ、払込年月日＜払出元金充当日のデータが存在するかチェック。
                    // サービスを実行し、請求データの存在チェックをする。
                    // Serviceの呼び出し
                    Cr002_01M1DTO cr002_01M1DTO4 = cr002_01service.getSeikyu(m1Dto);

                    if (0 < cr002_01M1DTO4.getResultData_Kensu()) {
                        // データ有りの場合、エラーとする。
                        // エラーメッセージ：PM3761E　【払出・元金充当日】
                        bizErrors
                                .add(new PNMessageInfo(
                                        PNCommonMessageConstants.PM3761E,
                                        new String[] { MessageFormat.format("{0}案件目：払出・元金充当日は", numToZenNum(i)) },
                                        false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                }
                // *******************************************************************
                // 金額の正当性チェック
                // *******************************************************************
                // １．資金払出額、元金充当額が貸付受入金残高を超えていないかどうかのチェック
                // 前回の払出データの読み込み
                // サービスを実行し、払出データを読み込む。　（先頭1件のみ取得）
                // Serviceの呼び出し
                Cr002_01M1DTO outLastHaraidashDto = cr002_01service.getLastHaraidashi(m1Dto);
                if (0 == outLastHaraidashDto.getResultData_Kensu()) {
                    // 取得したデータ件数が0件の場合、業務エラーとする。
                    // エラーメッセージ：PM9990E
                    // エラーメッセージ：PM3190E
                    bizErrors
                            .add(new PNMessageInfo(PNCommonMessageConstants.PM9990E, new String[] { "" }, false));
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E,
                            new String[] { MessageFormat.format("{0}案件目：払出データ", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ・前回払出・払出累計額：払出累計額
                m1Dto.setID_HDLas_M_HaraidashiRuikei(outLastHaraidashDto.getID_HDLas_M_HaraidashiRuikei());
                // ・前回払出・繰上償還累計額：繰上償還累計額
                m1Dto.setID_HDLas_M_KurishoRuikei(outLastHaraidashDto.getID_HDLas_M_KurishoRuikei());
                // ・前回払出・繰上償還額：繰上償還額
                m1Dto.setID_HDLas_M_Kurisho(outLastHaraidashDto.getID_HDLas_M_Kurisho());
                // ・前回払出・払出充当年月日：払出充当年月日
                m1Dto.setID_HDLas_Date_HaraidashiJuto(outLastHaraidashDto.getID_HDLas_Date_HaraidashiJuto());
                // ・前回払出・貸付受入金残高：貸付受入金残高
                m1Dto.setID_HDLas_M_KashitsukeukeireZan(outLastHaraidashDto
                        .getID_HDLas_M_KashitsukeukeireZan());
                // ・前回払出・払出額有無フラグ：
                m1Dto.setID_HDLas_M_HaraidashiFlag(outLastHaraidashDto.getID_HDLas_M_HaraidashiFlag());
                // ・前回払出・繰上償還額有無フラグ：
                m1Dto.setID_HDLas_M_KurishoFlag(outLastHaraidashDto.getID_HDLas_M_KurishoFlag());

                // 取得結果の判定
                // 取得正常かつ、元金充当額エラー無しかつ、資金払出額エラー無しの場合、以下をチェックする
                // ①前回払出・貸付受入金残高がNULLの場合、エラーとする
                // メッセージ：PM3190E
                if (null == m1Dto.getID_HDLas_M_KashitsukeukeireZan()) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E,
                            new String[] { MessageFormat.format("{0}案件目：払出データ", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ②前回払出・貸付受入金残高＜資金払出額（入力値）の場合、エラーとする。
                // メッセージ：PM3140E　【資金払出額】　　　　　※資金払出額エラーをFalseにする

                BigDecimal hDLas_M_KashitsukeukeireZan = m1Dto.getID_HDLas_M_KashitsukeukeireZan();

                if (0 > hDLas_M_KashitsukeukeireZan.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                        .getID_M_Haraidashi()))) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { MessageFormat.format("{0}案件目：資金払出額は貸付受入金残高より小さい値", numToZenNum(i)) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ③前回払出・貸付受入金残高＜元金充当額（入力値）の場合、エラーとする。
                // メッセージ：PM3140E　「元金充当額」　　　　　※元金充当額エラーをFalseにする
                if (0 > hDLas_M_KashitsukeukeireZan.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                        .getID_M_Ganju()))) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { MessageFormat.format("{0}案件目：元金充当額は貸付受入金残高より小さい値", numToZenNum(i)) },
                            false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }
                // ④前回払出・貸付受入金残高　－　資金払出額　－　元金充当額　＜　０の場合、エラーとする
                // メッセージ：PM3140E　【資金払出額，元金充当額】　　　　　※資金払出額エラー、元金充当額エラーをFalseにする

                // 前回払出・貸付受入金残高　－　資金払出額　－　元金充当額
                BigDecimal sagaku = hDLas_M_KashitsukeukeireZan.subtract(PNCommonComponents.cnvStrtoBig(m1Dto
                        .getID_M_Haraidashi()));
                sagaku = sagaku.subtract(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()));

                if (0 < BigDecimal.ZERO.compareTo(sagaku)) {
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                            new String[] { MessageFormat.format("{0}案件目：資金払出額、元金充当額は貸付受入金残高を越えない金額",
                                    numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ２．元金充当額チェック
                // 払出元金充当日エラー無しかつ、元金充当額エラー無しかつ、資金払出額エラー無しの場合、実施する
                // 約定データの読み込み
                // サービスを実行し、約定データを読み込む。

                // Serviceの呼び出し
                Cr002_01M1DTO outNextYakujoDto = cr002_01service.getNextYakujo(m1Dto);

                // 取得したデータ件数が0件の場合、業務エラーとする。
                if (0 == outNextYakujoDto.getResultData_Kensu()) {
                    // エラーメッセージ：PM3190E
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E,
                            new String[] { MessageFormat.format("{0}案件目：約定データ", numToZenNum(i)) }, false));
                    outDTO.setBizErrors(bizErrors);
                    return outDTO;
                }

                // ・約定・約定前残高：約定前残高
                m1Dto.setID_M_ZandakaBeforeYakujo(outNextYakujoDto.getID_M_ZandakaBeforeYakujo());
                // ・請求・払込年月日：元金充当後第１回約定日
                m1Dto.setID_Date_FirstYakujoAfterGanju(outNextYakujoDto.getID_Date_FirstYakujoAfterGanju());
                // ・請求・約定元金：約定元金
                m1Dto.setID_M_YakujoGankin(outNextYakujoDto.getID_M_YakujoGankin());
                // ・請求・約定利息：約定利息
                m1Dto.setID_M_YakujoRisoku(outNextYakujoDto.getID_M_YakujoRisoku());

                // 取得結果の判定
                // 取得正常かつ、元金充当額＞０の場合、以下をチェックする
                if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()))) {
                    // ①約定・約定前残高がＮＵＬＬの場合、エラーとする
                    if (null == outNextYakujoDto.getID_M_ZandakaBeforeYakujo()) {
                        // メッセージ：PM3200E　【元金充当額】　　　　　※元金充当額エラーにFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当額は約定前残高を取得できないため比較の確認",
                                        numToZenNum(i)) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ②元金充当額＞約定・約定前残高の場合、エラーとする
                    // メッセージ：PM3180E　【元金充当額】　　　　　※元金充当額エラーにFalseにする
                    // ※本場合、案件目の後ろに約定前残高を出力する
                    // 例）「元金充当額(3案件目)[約定前残高：9999999999]：約定前残高を越えています。」
                    if (0 < (PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()).compareTo(outNextYakujoDto
                            .getID_M_ZandakaBeforeYakujo()))) {
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3180E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当額は[約定前残高：{1}]", numToZenNum(i),
                                        m1Dto.getID_M_ZandakaBeforeYakujo().toString()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ③元金充当後第１回約定日がＮＵＬＬの場合、エラーとする
                    if (null == outNextYakujoDto.getID_Date_FirstYakujoAfterGanju()) {
                        // メッセージ：PM3190E　【元金充当後の第１回約定日】
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3190E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後の第１回約定日", numToZenNum(i),
                                        m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }

                }

                // ３．繰上償還事由コードチェック
                // 繰上償還事由コードエラー無しかつ、元金充当額＞０の場合、実施する
                if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()))) {
                    // ①元金充当額＝稟議・貸付金残高かつ、繰償事由コード先頭１文字が　３，４，６のいずれでもない場合、エラーとする
                    String codeKurishoJiyu = "";
                    if (!isEmpty(m1Dto.getID_Code_KurishoJiyu())) {
                        codeKurishoJiyu = m1Dto.getID_Code_KurishoJiyu().substring(0, 1);
                    }
                    if (0 == PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()).compareTo(
                            m1Dto.getID_M_KashitsukeZandaka())) {
                        if (!"3".equals(codeKurishoJiyu) && !"4".equals(codeKurishoJiyu)
                                && !"6".equals(codeKurishoJiyu)) {
                            // メッセージ：PM3821E　【繰上償還事由コード】
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3821E,
                                    new String[] { MessageFormat.format("{0}案件目：繰上償還事由コードに", numToZenNum(i),
                                            m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }

                    String codeShokanHouhou = m1Dto.getID_Code_ShokanHouhou().substring(0, 1);
                    // ①元金充当額＜＞稟議・貸付金残高かつ、稟議・償還方法コード先頭１文字が３かつ、繰償事由コード先頭１文字が　１，２，５のいずれでもない場合、エラーとする
                    if (0 != PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()).compareTo(
                            m1Dto.getID_M_KashitsukeZandaka())) {
                        if ("3".equals(codeShokanHouhou)
                                && (!"1".equals(codeKurishoJiyu) && !"2".equals(codeKurishoJiyu) && !"5"
                                        .equals(codeKurishoJiyu))) {
                            // メッセージ：PM3832E　【繰上償還事由コード】
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3831E,
                                    new String[] { MessageFormat.format("{0}案件目：繰上償還事由コードに", numToZenNum(i),
                                            m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;
                        }
                    }
                }
                // ４．元金均等償還・期限固定時のチェック
                // 元金充当額エラー無しかつ、元金充当額＞０かつ、償還方法タイプ識別値＝３の場合、チェックを行う
                if ("3".equals(m1Dto.getType_Shokan())
                        && 0 > BigDecimal.ZERO
                                .compareTo(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()))) {
                    BigDecimal tmpCount_Shokan = BigDecimal.ZERO;

                    // ①元金充当後元金均等額エラー無しかつ、元金充当後の元金均等額＜＝０の場合、エラーとする
                    if (0 <= BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinKintoAfterGanju()))) {
                        // メッセージ：PM3140E　【元金充当後の元金均等額】　　　　　※元金充当後元金均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後の元金均等額は半角数値0より大きい値",
                                        numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ②元金充当後元金不均等額エラー無しかつ、元金充当後の元金不均等額＜０の場合、エラーとする
                    if (0 < BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinFukintoAfterGanju()))) {
                        // メッセージ：PM3140E　【元金充当後の元金不均等額】　　　　※元金充当後元金不均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：元金充当後の元金不均等額は半角数値0以上",
                                        numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ③元金充当後元金不均等額エラー無しかつ、元金充当後の元金不均等額＞０かつ、調整コード＝空文字の場合、エラーとする
                    if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinFukintoAfterGanju())) && (isEmpty(m1Dto.getID_Code_Chosei()))) {
                        // メッセージ：PM3140E　【調整コード】　　　　　※調整コードエラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：調整コードは「初回」または「最終回」",
                                        numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // 入力値の正当性チェック　（元金充当後元金均等額エラー無しかつ、元金充当後元金不均等額エラー無しの場合、チェックを行う）
                    // １．稟議・元金不均等額区分＝１の場合、以下を行う
                    if ("1".equals(m1Dto.getID_Kubun_GankinFukintogaku())) {
                        // 約定データの読み込み
                        // サービスを実行し、約定データの有無をチェックする。=
                        Cr002_01M1DTO outYakujoDto = cr002_01service.getYakujo(m1Dto);

                        // 取得結果の判定
                        if (0 != outYakujoDto.getResultData_Kensu()) {
                            // 約定データが存在する場合、約定データの読み込む
                            // サービスを実行し、約定データを読み込む。
                            // Serviceの呼び出し
                            Cr002_01M1DTO outPreviousYakujoDto = cr002_01service.getPreviousYakujo(m1Dto);

                            // ・賦金計算用・約定・払込期日：払込年月日
                            m1Dto.setID_Date_Haraikomi_Yakujo_Fukin(outPreviousYakujoDto
                                    .getID_Date_Haraikomi_Yakujo_Fukin());
                            // ・賦金計算用・約定・約定元金：約定元金
                            m1Dto.setID_M_YakujoGankin_Yakujo_Fukin(outPreviousYakujoDto
                                    .getID_M_YakujoGankin_Yakujo_Fukin());
                            // ・賦金計算用・約定・約定利息：約定利息
                            m1Dto.setID_M_YakujoRisoku_Yakujo_Fukin(outPreviousYakujoDto
                                    .getID_M_YakujoRisoku_Yakujo_Fukin());
                            // ・賦金計算用・約定・請求繰上利息：請求繰上償還利息
                            m1Dto.setID_M_SeikuriRisoku_Yakujo_Fukin(outPreviousYakujoDto
                                    .getID_M_SeikuriRisoku_Yakujo_Fukin());

                            // 取得結果の判定
                            // （１）稟議・元金不均等額＝賦金計算用・約定・約定元金　又は　賦金計算用・約定・約定元金＝０の場合、以下をチェックする
                            if (0 == m1Dto.getID_M_GankinFukinto().compareTo(
                                    m1Dto.getID_M_YakujoGankin_Yakujo_Fukin())
                                    || 0 == BigDecimal.ZERO.compareTo(m1Dto
                                            .getID_M_YakujoGankin_Yakujo_Fukin())) {
                                // 計算値　＝　(稟議・貸付金残高－稟議・元金不均等額) を 稟議・賦金で割った余り
                                BigDecimal keisan = m1Dto.getID_M_KashitsukeZandaka().subtract(
                                        m1Dto.getID_M_GankinFukinto());
                                keisan = keisan.remainder(m1Dto.getID_M_Fukin());
                                // ①計算値が０でない場合、エラーとする
                                if (0 != BigDecimal.ZERO.compareTo(keisan)) {
                                    // メッセージ：PM3200E　【充当後の元金均等額・不均等額】
                                    // ※元金充当後元金均等額エラー、元金充当後元金不均等額エラー、調整コードエラーをFalseにする
                                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                                            new String[] { MessageFormat.format("{0}案件目：充当後の元金均等額・不均等額",
                                                    numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) },
                                            false));
                                    outDTO.setBizErrors(bizErrors);
                                    return outDTO;

                                }
                                else {
                                    // ②計算値が０の場合、以下を計算する
                                    // 償還回数計算値＝（稟議・貸付金残高－稟議・元金不均等額）÷稟議・賦金

                                    tmpCount_Shokan = m1Dto.getID_M_KashitsukeZandaka().subtract(
                                            m1Dto.getID_M_GankinFukinto());

                                    tmpCount_Shokan = tmpCount_Shokan.divide(m1Dto.getID_M_Fukin(), 0,
                                            BigDecimal.ROUND_DOWN);
                                    if (0 > BigDecimal.ZERO.compareTo(m1Dto.getID_M_GankinFukinto())) {
                                        // 稟議・元金不均等額＞０の場合、償還回数計算値＝償還回数計算値＋１　　　　※償還回数に不均等額分の１回を追加する。
                                        tmpCount_Shokan = tmpCount_Shokan.add(BigDecimal.ONE);
                                    }
                                }
                            }
                            else {
                                // （２）（１）以外の場合、以下をチェックする
                                // 計算値　＝　稟議・貸付金残高 を 稟議・賦金で割った余り
                                BigDecimal keisan = m1Dto.getID_M_KashitsukeZandaka().remainder(
                                        m1Dto.getID_M_Fukin());
                                // ①計算値が０でない場合、エラーとする
                                if (0 != BigDecimal.ZERO.compareTo(keisan)) {
                                    // メッセージ：PM3200E　【充当後の元金均等額・不均等額】
                                    // ※元金充当後元金均等額エラー、元金充当後元金不均等額エラー、調整コードエラーをFalseにする
                                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                                            new String[] { MessageFormat.format("{0}案件目：充当後の元金均等額・不均等額",
                                                    numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) },
                                            false));
                                    outDTO.setBizErrors(bizErrors);
                                    return outDTO;

                                }
                                else {
                                    // ※元金充当後元金均等額エラー、元金充当後元金不均等額エラー、調整コードエラーをFalseにする
                                    // ②計算値が０の場合、以下を計算する
                                    // 償還回数計算値＝稟議・貸付金残高÷稟議・賦金

                                    tmpCount_Shokan = m1Dto.getID_M_KashitsukeZandaka().divide(
                                            m1Dto.getID_M_Fukin(), 0, BigDecimal.ROUND_DOWN);
                                }
                            }
                        }
                    }
                    else {
                        // ２．稟議・元金不均等額区分＜＞１の場合、以下を行う
                        // 計算値　＝　(稟議・貸付金残高－稟議・元金不均等額) を 稟議・賦金で割った余り
                        BigDecimal keisan = m1Dto.getID_M_KashitsukeZandaka().subtract(
                                m1Dto.getID_M_GankinFukinto());
                        keisan = keisan.remainder(m1Dto.getID_M_Fukin());
                        if (0 != BigDecimal.ZERO.compareTo(keisan)) {
                            // ①計算値が０でない場合、エラーとする
                            // メッセージ：PM3200E　【充当後の元金均等額・不均等額】
                            // ※元金充当後元金均等額エラー、元金充当後元金不均等額エラー、調整コードエラーをFalseにする
                            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3200E,
                                    new String[] { MessageFormat.format("{0}案件目：充当後の元金均等額・不均等額",
                                            numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                            outDTO.setBizErrors(bizErrors);
                            return outDTO;

                        }
                        else {
                            // ①計算値が０の場合、以下を行う
                            // 償還回数計算値＝（稟議・貸付金残高－稟議・元金不均等額）÷稟議・賦金
                            // 稟議・元金不均等額＞０の場合、償還回数計算値＝償還回数計算値＋１　　　　※償還回数に不均等額分の１回を追加する。

                            tmpCount_Shokan = m1Dto.getID_M_KashitsukeZandaka().subtract(
                                    m1Dto.getID_M_GankinFukinto());
                            tmpCount_Shokan = tmpCount_Shokan.divide(m1Dto.getID_M_Fukin(), 0,
                                    BigDecimal.ROUND_DOWN);
                            if (0 > BigDecimal.ZERO.compareTo(m1Dto.getID_M_GankinFukinto())) {
                                tmpCount_Shokan = tmpCount_Shokan.add(BigDecimal.ONE);
                            }
                        }
                    }

                    // ここまでのチェック処理でエラーが無い場合、以下を行う。
                    // １．元金充当後の元金不均等額＞０
                    BigDecimal keisan3 = BigDecimal.ZERO;
                    if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinFukintoAfterGanju()))) {
                        // 貸付金残高計算値＝元金充当後の元金均等額＊（償還回数計算値－１）　＋　元金充当額　＋　元金充当後の元金不均等額
                        keisan3 = keisan3.add(PNCommonComponents.cnvStrtoBig(m1Dto
                                .getID_M_GankinKintoAfterGanju()));
                        keisan3 = keisan3.multiply(tmpCount_Shokan.subtract(BigDecimal.ONE));
                        keisan3 = keisan3.add(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()));
                        keisan3 = keisan3.add(PNCommonComponents.cnvStrtoBig(m1Dto
                                .getID_M_GankinFukintoAfterGanju()));
                    }
                    else {
                        // ２．「１．」以外の場合
                        // 貸付金残高計算値＝元金充当後の元金均等額＊償還回数計算値　＋　元金充当額
                        keisan3 = keisan3.add(PNCommonComponents.cnvStrtoBig(m1Dto
                                .getID_M_GankinKintoAfterGanju()));
                        keisan3 = keisan3.multiply(tmpCount_Shokan);
                        keisan3 = keisan3.add(PNCommonComponents.cnvStrtoBig(m1Dto.getID_M_Ganju()));
                    }
                    // ３．稟議・貸付金残高＜＞貸付金残高計算値の場合、エラーとする
                    if (0 != m1Dto.getID_M_KashitsukeZandaka().compareTo(keisan3)) {
                        // メッセージ：PM3140E　【充当後の元金均等額・不均等額】
                        // ※元金充当後元金均等額エラー、元金充当後元金不均等額エラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：充当後の元金均等額・不均等額は正しい金額",
                                        numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ４．「３．」のチェックがＯＫでかつ、調整コードエラー無しの場合、以下をチェックする
                    // ①元金充当後の元金不均等額＝０かつ、調整コード＜＞空文字の場合、エラーとする
                    if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinFukintoAfterGanju())) && !isEmpty(m1Dto.getID_Code_Chosei())) {
                        // メッセージ：PM3140E　【調整コード】　　　　　※調整コードエラーをFalseにする
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：調整コードは「なし」", numToZenNum(i),
                                        m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                    // ②元金充当後の元金不均等額＜＞０かつ、調整コード＝空文字の場合、エラーとする
                    // メッセージ：PM3140E　【調整コード】　　　　　※調整コードエラーをFalseにする
                    if (0 != BigDecimal.ZERO.compareTo(PNCommonComponents.cnvStrtoBig(m1Dto
                            .getID_M_GankinFukintoAfterGanju())) && isEmpty(m1Dto.getID_Code_Chosei())) {
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E,
                                new String[] { MessageFormat.format("{0}案件目：調整コードは「初回」または「最終回」",
                                        numToZenNum(i), m1Dto.getID_M_ZandakaBeforeYakujo()) }, false));
                        outDTO.setBizErrors(bizErrors);
                        return outDTO;
                    }
                }

                // 元金充当がない場合に約定前残高、元金充当後第１回約定日のクリア
                if ("0".equals(PNCommonComponents.cnvNulltoZero(m1Dto.getID_M_Ganju()))) {

                    // 約定前残高
                    m1Dto.setID_M_ZandakaBeforeYakujo(null);
                    // 元金充当後第１回約定日
                    m1Dto.setID_Date_FirstYakujoAfterGanju(null);
                }
            }
            i = i + 1;
            // 全項目のループEnd
            // 明細リストに追加
            newM1DtoList.add(m1Dto);
            outDTO.setMEISAI_LIST(newM1DtoList);
        }
        return outDTO;
    }

    /**
     *
     * <pre>
     * 繰上償還事由コード取得
     * </pre>
     *
     * @param code_ShokanHouhou 稟議・償還方法コード
     * @param code_KurishoJiyu_Save 繰上償還事由コード(DB取得時)
     * @return String 償還方法タイプ識別値
     */
    private String getTypeShokan(String code_ShokanHouhou, String code_KurishoJiyu) {

        String codeKurishoJiyu = "";
        int indexCodeShokanHouhou = 4;
        int indexCodeKurishoJiyu = 6;

        if (!isEmpty(code_ShokanHouhou)) {
            String code1 = code_ShokanHouhou.substring(0, 1);
            if ("1".equals(code1)) {
                indexCodeShokanHouhou = 0;
            }
            else if ("2".equals(code1)) {
                indexCodeShokanHouhou = 1;
            }
            else if ("3".equals(code1)) {
                indexCodeShokanHouhou = 2;
            }
            if ("9".equals(code1)) {
                indexCodeShokanHouhou = 3;
            }
        }

        String code2 = "";
        if (!isEmpty(code_KurishoJiyu)) {
            code2 = code_KurishoJiyu.substring(0, 1);
        }

        String reg = "^[1-6]";
        if (code2.matches(reg)) {
            indexCodeKurishoJiyu = Integer.valueOf(code2) - 1;
        }

        String[][] syoukan = { { "1", "1", "2", "2", "1", "2", "7" }, { "3", "3", "4", "4", "3", "4", "7" },
                { "5", "5", "5", "5", "5", "5", "5" }, { "6", "6", "6", "6", "6", "6", "6" },
                { "8", "8", "8", "8", "8", "8", "8" } };
        codeKurishoJiyu = syoukan[indexCodeShokanHouhou][indexCodeKurishoJiyu];
        return codeKurishoJiyu;
    }

    /**
     *
     * <pre>
     * 半角カナチェック
     * </pre>
     *
     * @param value 入力値
     * @return boolean 半角カナ入力:true/半角カナ入力でない:false
     */
    private boolean isHalfAlphakana(String value) {

        if (null == value) {
            return false;
        }
        String reg = "^[0-9A-Za-zｱ-ｿﾀ-ﾛﾜｦﾝ]+$";
        if (!value.matches(reg)) {
            return false;
        }

        return true;

    }

    /**
     *
     * <pre>
     * 未入力判定
     * </pre>
     *
     * @param value 入力値
     * @return boolean 未入力:true/入力済:false
     */
    private boolean isEmpty(String value) {

        if (null == value || 0 == value.length()) {

            return true;
        }

        return false;
    }

    /**
     * 数字→全角数字変換
     *
     * @param num 変換対象数字
     *
     * @return 変換後文字列
     */
    public static String numToZenNum(int num) {

        String s = String.valueOf(num);
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if ('0' <= c && '9' >= c) {

                sb.setCharAt(i, (char)(c - '0' + '０'));
            }
        }

        return sb.toString();
    }
}