//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 小菱忠雄              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_01.web;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonStringUtils;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.common.check.PNCheckMoney;
import jp.go.jfc.partnernet.md004.common.Md004Constants;
import jp.go.jfc.partnernet.md004.md004_01.service.Md004_01DTO;
import jp.go.jfc.partnernet.md004.md004_01.service.Md004_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

/**
 * <pre>
 * このクラスはmd004_01の送信ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md004_01Form")
@RequestMapping(value = "/Md004_01Send.form")
public class Md004_01SendController extends Md004_01BaseController {

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** Md004_01Service */
    @Autowired
    Md004_01Service md004_01service;

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
    public String executeAction(Model model, Md004_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 入力画面のチェックを行い結果を取得する。
        Md004_01DTO outDto = checkInput(form, bizErrors);

        // 画面のメッセージが設定されている場合、エラーと扱い画面遷移は行わない。
        throwError(bizErrors);

        // 画面に入力された項目を遷移パラメータに設定する。(画面遷移パラメタ定義参照)
        setRequestNextScreen(request, outDto);

        // 画面のメッセージが設定されていない場合、画面遷移を行う。
        return success(Md004Constants.EVENT_ID_MD004_02INIT);

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
    public void displayControl(Model model, Md004_01Form form, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 入力内容チェック
     * </pre>
     *
     */
    private Md004_01DTO checkInput(Md004_01Form form, List<PNMessageInfo> bizErrors) {

        /** 返却用DTO */
        Md004_01DTO outDto = new Md004_01DTO();

        // フォームからDto転記
        CFWBeanUtils.copyProperties(outDto, form);

        // 報告年月日の名前が違うため受け渡し用に引継
        outDto.setTxtID_Date_Report(form.getID_Date_Report());

        // コード判定用変数をセットする。
        String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(outDto);

        // チェック用関数初期化
        checkObjCreate();

        // 更生 黒 ===============================================================
        if (Boolean.valueOf(outDto.getBlackArea())) {
            /** 償還後第1回払込期(修正) */
            PNCheckDay checkDate_FirstHaraikomiAfterKuris = new PNCheckDay(
                    outDto.getDrpDate_FirstHaraikomiAfterKuris_Gengo(),
                    outDto.getTxtDate_FirstHaraikomiAfterKuris_Nen(),
                    outDto.getDrpDate_FirstHaraikomiAfterKuris_Tsuki(),
                    outDto.getDrpDate_FirstHaraikomiAfterKuris_Bi(), pnCommonDBComponents, bizErrors);

            /** 入金日(修正) */
            PNCheckDay checkDate_Nyukin = new PNCheckDay(outDto.getDrpID_Date_Nyukin_Gengo(),
                    outDto.getTxtID_Date_Nyukin_Nen(), outDto.getDrpID_Date_Nyukin_Tsuki(),
                    outDto.getDrpID_Date_Nyukin_Bi(), pnCommonDBComponents, bizErrors);

            /** 受託者勘定処理年月(修正) */
// [UPD] Ver 2.0.0 - START
//            PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
//                    outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "01",
//                    pnCommonDBComponents, bizErrors);
            PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
                    outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "",
                    pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END

            // １－１．修正データのチェック（「処理完了以外：修正」、「処理完了：修正」の場合）
            // 繰償後第１回払込期日（修正）チェック

            // 繰償後第１回払込期日（元号）（年）（月）（日）のいずれかが未入力の場合、エラーとする。
            // メッセージ：繰償後第１回払込期日、PM3120E
            checkDate_FirstHaraikomiAfterKuris.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
                    new String[]{"繰償後第１回払込期日"});
            throwError(bizErrors);

            // 繰償後第１回払込期日（元号）（年）がS64の場合、エラーとする。
            // メッセージ：繰償後第１回払込期日に、PM3291E
            checkDate_FirstHaraikomiAfterKuris.addErrorS64(PNCommonMessageConstants.PM3291E,
                    new String[]{"繰償後第１回払込期日に"});
            throwError(bizErrors);

            // 共通処理の和暦有効日付チェックにて繰償後第１回払込期日（元号）（年）（月）（日）をチェックする。
            // 有効な日付でない場合、エラーとする。
            // メッセージ：繰償後第１回払込期日、PM3120E
            checkDate_FirstHaraikomiAfterKuris.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3220E,
                    new String[]{"繰償後第１回払込期日"});
            throwError(bizErrors);

            // 上記のチェックが正常の場合
            // 共通処理の西暦変換にて繰償後第１回払込期日を西暦変換しDTOに保持する。(償還後第1回払込期(修正)（入力値連結）)
            outDto.setDate_FirstHaraikomiAfterKuris_Input(checkDate_FirstHaraikomiAfterKuris.getSeireki());

            // 入金日（修正）チェック
            // 入金日（元号）（年）（月）（日）のいずれかが未入力の場合、エラーとする。
            // メッセージ：入金日、PM9990E
            checkDate_Nyukin.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[]{"入金日"});
            throwError(bizErrors);

            // 入金日（元号）（年）がS64の場合、エラーとする。
            // メッセージ：入金日に、PM3291E
            checkDate_Nyukin.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{"入金日に"});
            throwError(bizErrors);

            // 共通処理の和暦有効日付チェックにて入金日（元号）（年）（月）（日）をチェックする。
            // 有効な日付でない場合、エラーとする。
            // メッセージ：入金日、PM3120E
            checkDate_Nyukin.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3220E, new String[]{"入金日"});
            throwError(bizErrors);

            // 上記のチェックが正常の場合
            // 共通処理の営業日判定にて入金日をチェックする。非営業日の場合、エラーとする。
            // メッセージ：入金日が、PM3331E
            checkDate_Nyukin.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[]{"入金日は"});
            throwError(bizErrors);

            // 上記のチェックが正常の場合
            // 入金日＞業務日付の場合、エラーとする。
            // メッセージ：入金日が業務日付、PM3260E
            checkDate_Nyukin.addErrorDayOverToDay(PNCommonMessageConstants.PM3260E, new String[]{"入金日は業務日付"});
            throwError(bizErrors);

            // 入金日＜貸付実行日の場合、エラーとする。
            // メッセージ：入金日は貸付実行日より後の日付、PM3140E
            checkDate_Nyukin.addErrorDayUnderDay(
                    PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Jikko()),
                    PNCommonMessageConstants.PM3140E, new String[]{"入金日は貸付実行日より後の日付"});
            throwError(bizErrors);

            // 上記のチェックが正常の場合
            // 共通処理の西暦変換にて入金日を西暦変換しDTOに保持する。(入金日(修正)（入力値連結）)
            outDto.setID_Date_Nyukin_Input(checkDate_Nyukin.getSeireki());

            // 受託者勘定処理年月（修正）チェック
            // 受託者勘定処理年月（元号）（年）（月）のいずれかが未入力の場合、エラーとする。
            // メッセージ：受託者勘定処理年月、PM3120E
// [UPD] Ver 2.0.0 - START
//            checkDate_Jtkshori.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
//                    new String[]{"受託者勘定処理年月"});
//            throwError(bizErrors);
            checkDate_Jtkshori.addErrorDayRequiredMonth(PNCommonMessageConstants.PM3120E,
                    new String[] { "受託者勘定処理年月" });
            throwError(bizErrors);
// [UPD] Ver 2.0.0 - END

            // 受託者勘定処理年月（元号）（年）がS64の場合、エラーとする。
            // メッセージ：受託者勘定処理年月に、PM3291E
            checkDate_Jtkshori.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{"受託者勘定処理年月に"});
            throwError(bizErrors);

            // 共通処理の和暦有効日付チェックにて受託者勘定処理年月（元号）（年）（月）＋"01"をチェックする。
            // 有効な日付でない場合、エラーとする。
            // メッセージ：受託者勘定処理年月、PM3120E
// [UPD] Ver 2.0.0 - START
//            checkDate_Jtkshori.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3220E,
//                    new String[]{"受託者勘定処理年月"});
            checkDate_Jtkshori.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3220E,
                    new String[] { "受託者勘定処理年月" });
// [UPD] Ver 2.0.0 - END
            throwError(bizErrors);

            // 受託者勘定処理年月＞業務日付の年月の場合、エラーとする。
            // メッセージ：受託者勘定処理年月が業務日付、PM3260E
            checkDate_Jtkshori.addErrorDayOverMonthDay(pnCommonDBComponents.getPNBusinessDay(1),
                    PNCommonMessageConstants.PM3260E, new String[]{"受託者勘定処理年月が業務日付"});
            throwError(bizErrors);

            // 共通処理の西暦変換にて受託者勘定処理年月を西暦変換しDTOに保持する。(受託者勘定処理年月(修正)（入力値連結）)
            outDto.setID_Date_Jtkshori_Input(cnvYYYYMMDDtoYYYYMM(checkDate_Jtkshori.getSeireki()));

            // 各数字項目のチェック
            // 利息
            PNCheckMoney checkID_M_KurishoRisoku = new PNCheckMoney(outDto.getTxtID_M_KurishoRisoku(),
                    bizErrors);
            checkID_M_KurishoRisoku.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"利息は数字"});
            throwError(bizErrors);

            // 元金
            PNCheckMoney checkID_M_KurishoGankin = new PNCheckMoney(outDto.getTxtID_M_KurishoGankin(),
                    bizErrors);
            checkID_M_KurishoGankin.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"元金は数字"});
            throwError(bizErrors);

            // 控除利息
            PNCheckMoney checkID_M_KojoRisoku = new PNCheckMoney(outDto.getTxtID_M_KojoRisoku(), bizErrors);
            checkID_M_KojoRisoku.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"控除利息は数字"});
            throwError(bizErrors);

            // 繰上償還手数料
            PNCheckMoney checkID_M_KurishoCommission = new PNCheckMoney(
                    outDto.getTxtID_M_KurishoCommission(), bizErrors);
            checkID_M_KurishoCommission.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"繰上償還手数料は数字"});
            throwError(bizErrors);

            // 仮受金からの充当額
            PNCheckMoney checkID_M_KariukeIppanJuto = new PNCheckMoney(outDto.getTxtID_M_KariukeIppanJuto(),
                    bizErrors);
            checkID_M_KariukeIppanJuto.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"仮受金からの充当額は数字"});
            throwError(bizErrors);

            // 払込元金1
            PNCheckMoney checkID_M_HaraikomiGankin1 = new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin1(),
                    bizErrors);
            checkID_M_HaraikomiGankin1.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"払込元金(1)は数字"});
            throwError(bizErrors);

            // 払込元金2
            PNCheckMoney checkID_M_HaraikomiGankin2 = new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin2(),
                    bizErrors);
            checkID_M_HaraikomiGankin2.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"払込元金(2)は数字"});
            throwError(bizErrors);

            // 払込元金3
            PNCheckMoney checkID_M_HaraikomiGankin3 = new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin3(),
                    bizErrors);
            checkID_M_HaraikomiGankin3.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"払込元金(3)は数字"});
            throwError(bizErrors);

            // 払込元金4
            PNCheckMoney checkID_M_HaraikomiGankin4 = new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin4(),
                    bizErrors);
            checkID_M_HaraikomiGankin4.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"払込元金(4)は数字"});
            throwError(bizErrors);

            // 繰償後元金均等額
            PNCheckMoney checkID_M_GankinKintoAfterKurisho = new PNCheckMoney(
                    outDto.getTxtID_M_GankinKintoAfterKurisho(), bizErrors);
            checkID_M_GankinKintoAfterKurisho.addErrorMonneyEffectiveMoney(PNCommonMessageConstants.PM3140E,
                    new String[]{"繰償後元金均等額は数字"});
            throwError(bizErrors);

            // 繰償還元金不均等額
            PNCheckMoney checkID_M_GankinFukintoAfterKurisho = new PNCheckMoney(
                    outDto.getTxtID_M_GankinFukintoAfterKurisho(), bizErrors);
            checkID_M_GankinFukintoAfterKurisho.addErrorMonneyEffectiveMoney(
                    PNCommonMessageConstants.PM3140E, new String[]{"繰償還元金不均等額は数字"});
            throwError(bizErrors);

        }

        // 更生 赤 ===============================================================
        if (Boolean.valueOf(outDto.getRedArea())) {
            // １－２．更正(赤)データのチェック「処理完了以外：取消」、「処理完了：取消」、「処理完了：修正」の場合）
            // 受託者勘定処理年月（赤）チェック
            /** 受託者勘定処理年月(更生赤) */
// [UPD] Ver 2.0.0 - START
//            PNCheckDay checkDate_Jtkshori_Red = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo_Red(),
//                    outDto.getTxtID_Date_Jtkshori_Nen_Red(), outDto.getDrpID_Date_Jtkshori_Tsuki_Red(), "01",
//                    pnCommonDBComponents, bizErrors);
            PNCheckDay checkDate_Jtkshori_Red = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo_Red(),
                    outDto.getTxtID_Date_Jtkshori_Nen_Red(), outDto.getDrpID_Date_Jtkshori_Tsuki_Red(), "",
                    pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END

            // 受託者勘定処理年月（元号）（年）（月）のいずれかが未入力の場合、エラーとする。
            // メッセージ：受託者勘定処理年月、PM3120E
// [UPD] Ver 2.0.0 - START
//            checkDate_Jtkshori_Red.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
//                    new String[]{"受託者勘定処理年月"});
            checkDate_Jtkshori_Red.addErrorDayRequiredMonth(PNCommonMessageConstants.PM3120E,
                    new String[]{"受託者勘定処理年月"});
// [UPD] Ver 2.0.0 - END
            throwError(bizErrors);

            // 受託者勘定処理年月（元号）（年）がS64の場合、エラーとする。
            // メッセージ：受託者勘定処理年月に、PM3291E
            checkDate_Jtkshori_Red.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{"受託者勘定処理年月に"});
            throwError(bizErrors);

            // 共通処理の和暦有効日付チェックにて受託者勘定処理年月（元号）（年）（月）＋"01"をチェックする。
            // 有効な日付でない場合、エラーとする。
            // メッセージ：受託者勘定処理年月、PM3120E
// [UPD] Ver 2.0.0 - START
//            checkDate_Jtkshori_Red.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3220E,
//                    new String[]{"受託者勘定処理年月"});
            checkDate_Jtkshori_Red.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3220E,
                    new String[]{"受託者勘定処理年月"});
// [UPD] Ver 2.0.0 - END
            throwError(bizErrors);

            // 受託者勘定処理年月＞業務日付の年月の場合、エラーとする。
            // メッセージ：受託者勘定処理年月が業務日付、PM3260E
            checkDate_Jtkshori_Red.addErrorDayOverMonthDay(pnCommonDBComponents.getPNBusinessDay(1),
                    PNCommonMessageConstants.PM3260E, new String[]{"受託者勘定処理年月が業務日付"});
            throwError(bizErrors);

            // 受託者勘定処理年月＜ 貸付実行日の場合エラーとする。
            // メッセージ：受託者勘定処理年月<貸付実行日、PM3140E
            checkDate_Jtkshori_Red.addErrorDayUnderMonthDay(
                    PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Jikko_Red()),
                    PNCommonMessageConstants.PM3140E, new String[]{"受託者勘定処理年月は貸付実行日以降の年月"});
            throwError(bizErrors);

            // 上記のチェックが正常の場合
            // 共通処理の西暦変換にて受託者勘定処理年月を西暦変換しDTOに保持する。(受託者勘定処理年月(赤)（入力値連結）)
            // （元号＋年＋月＋"01"で変換し、保持エリアには年月のみ格納）
            outDto.setID_Date_Jtkshori_Red_Input(cnvYYYYMMDDtoYYYYMM(checkDate_Jtkshori_Red.getSeireki()));
        }

        // １－３．エラー処理
        // 上記チェックでエラーとなった場合、エラーメッセージを表示し、以降の処理は行わない
        // ２．繰上償還受入充当報告書固有入力データのチェックを行う。

        // Form.請求データ更新フラグ＝False(無し）を初期設定
        outDto.setFlgSeikyuUpdate(false);

        // （１）更正(赤)データ処理
        // 処理モード、繰償事由コード、条変起案中区分により、各々のチェック処理を行う

        // 判定用コードを定義
        // 処理モード
        int decisionProsessMode = PNCommonComponents.cnvStrtoBig(outDto.getID_Type_Process_H()).intValue();

        // 条変起案中区分
        int decisionjohenKianchu = Integer.valueOf(PNCommonComponents.cnvNulltoZero(outDto
                .getID_Kubun_JohenKianchu()));

        // 処理モード(値):処理完了以外：取消(3)===============================================
        if (3 == decisionProsessMode) {
            // チェック画面:更正(赤)
            if (Boolean.valueOf(outDto.getRedArea())) {
                // （１）更正(赤)データ処理
                editPatternRed(outDto);
            }
        }

        // 処理モード(値):処理完了：取消(1)=================================================
        if (1 == decisionProsessMode) {
            // チェック画面:更正(赤)
            if (Boolean.valueOf(outDto.getRedArea())) {
                // （１）更正(赤)データ処理
                editPatternRed(outDto);
            }
        }

        // 処理モード(値):処理完了以外：修正(4)==============================================
        if (4 == decisionProsessMode) {
            // チェック画面:修正
            if (Boolean.valueOf(outDto.getBlackArea())) {
                // 繰償事由コード1文字目:空文字----------------------------------------------------------------------------------
                if (0 == hantei_KurishojiyuStr01.length()) {
                    // 条変起案中区分:9
                    if (9 == decisionjohenKianchu) {
                        // （２）修正データチェック処理①
                        editPattern1(outDto, bizErrors);
                        // （８）修正データチェック処理⑦
                        editPattern7(outDto, bizErrors);
                    }
                    // 条変起案中区分:9以外
                    if (9 != decisionjohenKianchu) {
                        // （３）修正データチェック処理②
                        this.editPattern2(outDto, bizErrors);
                        // （９）修正データチェック処理⑧
                        editPattern8(outDto, bizErrors);
                    }
                }
                // 繰償事由コード1文字目:2又は4--------------------------------------------------------------------------------
                else if ("2".equals(hantei_KurishojiyuStr01) || "4".equals(hantei_KurishojiyuStr01)) {
                    // 条変起案中区分:9
                    if (9 == decisionjohenKianchu) {
                        // （４）修正データチェック処理③
                        editPattern3(outDto, bizErrors);
                        // （８）修正データチェック処理⑦
                        editPattern7(outDto, bizErrors);
                    }
                    // 条変起案中区分:9以外bizErrors
                    if (9 != decisionjohenKianchu) {
                        // （５）修正データチェック処理④
                        editPattern4(outDto, bizErrors);
                        // （９）修正データチェック処理⑧
                        editPattern8(outDto, bizErrors);
                    }
                }
                // 2、4以外-----------------------------------------------------------------------------------------------------
                else {
                    // 条変起案中区分:9
                    if (9 == decisionjohenKianchu) {
                        // （６）修正データチェック処理⑤
                        editPattern5(outDto, bizErrors);
                        // （８）修正データチェック処理⑦
                        editPattern7(outDto, bizErrors);
                    }
                    // 条変起案中区分:9以外
                    if (9 != decisionjohenKianchu) {
                        // （７）修正データチェック処理⑥
                        editPattern6(outDto, bizErrors);
                        // （９）修正データチェック処理⑧
                        editPattern8(outDto, bizErrors);
                    }
                }
            }
        }
        // 処理完了：修正(2)========================================================
        if (2 == decisionProsessMode) {
            // 繰償事由コード1文字目:空文字----------------------------------------------------------------------------------
            if (0 == hantei_KurishojiyuStr01.length()) {
                // （１）更正(赤)データ処理
                editPatternRed(outDto);
                // （２）修正データチェック処理①
                editPattern1(outDto, bizErrors);
                // （８）修正データチェック処理⑦
                editPattern7(outDto, bizErrors);
            }
            // 繰償事由コード1文字目:2又は4--------------------------------------------------------------------------------
            else if ("2".equals(hantei_KurishojiyuStr01) || "4".equals(hantei_KurishojiyuStr01)) {
                // （１）更正(赤)データ処理
                editPatternRed(outDto);
                // （４）修正データチェック処理③
                editPattern3(outDto, bizErrors);
                // （８）修正データチェック処理⑦
                editPattern7(outDto, bizErrors);
            }
            // 2、4以外-----------------------------------------------------------------------------------------------------
            else {
                // （１）更正(赤)データ処理
                editPatternRed(outDto);
                // （６）修正データチェック処理⑤
                editPattern5(outDto, bizErrors);
                // （８）修正データチェック処理⑦
                editPattern7(outDto, bizErrors);
            }
        }
        return outDto;
    }

    // ###########################################################################
    // # チェック処理
    // ###########################################################################

    /**
     *
     * <pre>
     *  （１）更正（赤）データ処理
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPatternRed(Md004_01DTO outDto) {
        // 請求データを検索し、請求データの存在をチェックする。
        // サービスを実行し、請求データの存在チェックをする。
        // 検索用DTO定義

        // 請求データ検索パラメータ(債権管理番号）：取得した債権管理番号
        outDto.setSeikyuParam_ID_Credit(outDto.getID_ID_Credit_Red());
        // 請求データ検索パラメータ(払込期日）：償還後第1回払込期日（入力値連結）
        outDto.setSeikyuParam_Date_Haraikomi(outDto.getTxtDate_FirstHaraikomiAfterKuris_Red());
        // Md004_01Service.getSeikyu
        outDto = md004_01service.getSeikyu(outDto);
        // 請求データ検索結果(件数）＝１の場合、以下を行う
        if (1 == outDto.getSeikyuAns_Count()) {
            // Form.請求データ更新フラグ＝True(有）を設定
            outDto.setFlgSeikyuUpdate(true);
            // Form.請求データ更新用約定元金＝請求データ検索結果(約定元金）
            outDto.setID_M_YakujoGankin_Seikyu(outDto.getSeikyuAns_ID_M_YakujoGankin());
            // Form.請求データ更新用約定利息＝請求データ検索結果(約定利息）
            outDto.setID_M_YakujoRisoku_Seikyu(outDto.getSeikyuAns_ID_M_YakujoRisoku());
            // Form.請求データ更新用払込期日＝償還後第1回払込期日(修正)（入力値連結）
            outDto.setID_Date_Haraikomi_Seikyu(outDto.getDate_FirstHaraikomiAfterKuris_Input());
        }
    }

    /**
     *
     * <pre>
     * （２）修正データチェック処理①
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern1(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝空文字かつ条変起案中区分＝９
        // ・処理モード＝「処理完了：修正(4)」かつ繰償事由コード＝空文字

        // 元金入力有かつ、0以外の場合、エラーとする。
        // メッセージ：PM3490E※元金有額エラー
        /** 元金(修正) */
        PNCheckMoney checkGankin = new PNCheckMoney(outDto.getTxtID_M_KurishoGankin(), bizErrors);
        if (0 != cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            checkGankin.addErrorMonneyNotEqualsMonney("0", PNCommonMessageConstants.PM3490E, new String[0]);
            throwError(bizErrors);
        }
        // 利息入力無または、0の場合、以下を行う
        if (0 == cnvStrToBig(PNCommonComponents.cnvNulltoZero(outDto.getTxtID_M_KurishoRisoku()))
                .doubleValue()) {
            /** 繰上償還手数料(修正) */
            PNCheckMoney checkKurishoCommission = new PNCheckMoney(outDto.getTxtID_M_KurishoCommission(),
                    bizErrors);
            // 繰上償還手数料入力無又は、0の場合、エラーとする。
            // メッセージ：利息、繰上償還手数料のいずれも、PM3210E
            checkKurishoCommission.addErrorMonneyRequiredMoney(PNCommonMessageConstants.PM3210E,
                    new String[]{"利息、繰上償還手数料のいずれも"});
            throwError(bizErrors);
            checkKurishoCommission.addErrorMonneyEqualsMonney("0", PNCommonMessageConstants.PM3210E,
                    new String[]{"利息、繰上償還手数料のいずれも"});
            throwError(bizErrors);
        }
    }

    /**
     *
     * <pre>
     * （３）修正データチェック処理②
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern2(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝空文字かつ条変起案中区分＝９以外

        // 充当順序チェック
        // サービスを実行し、充当順序チェックを行う。
        // Md004_01Service.checkJutoJunjo
        outDto = md004_01service.checkJutoJunjo(outDto);

        // 充当順序チェックでメッセージ編集時、以降の処理は行わない
        bizErrors.addAll(outDto.getBizErrors());
        throwError(bizErrors);

        // 約定データ存在チェック
        // サービスを実行し、約定データの存在チェックをする。

        // 約定データ検索パラメータ(債権管理番号）＝債権管理番号
        outDto.setYakujoParam_ID_Credit(outDto.getID_ID_Credit());

        // 約定データ検索パラメータ(払込期日)＝償還後第1回払込期日(修正)（入力値連結）※一致する約定データを検索
        outDto.setYakujoParam_Date_Haraikomi(outDto.getDate_FirstHaraikomiAfterKuris_Input());

        // Md004_01Service.getYakujo
        outDto = md004_01service.getYakujo(outDto);

        // 取得件数が１でない場合、エラーとする。
        // メッセージ：約定データ、PM3190E※約定データ取得エラー
        // エラーメッセージを表示し、以降の処理は行わない
        if (1 != outDto.getYakujoAns_Count()) {
            addError(bizErrors, PNCommonMessageConstants.PM3190E, new String[]{"約定データ"});
            throwError(bizErrors);
        }
        // 利息入力有りかつ、０以外の場合、以下を行う
        // 無処理
        // 上記以外の場合、以下を行う
        if (0 == cnvStrToBig(outDto.getTxtID_M_KurishoRisoku()).doubleValue()) {
            // 繰上償還手数料が空白または、０の場合、エラーとする。
            // メッセージ：利息、繰上償還手数料、PM3210E
            if (0 == PNCommonComponents.cnvNulltoBlank(outDto.getTxtID_M_KurishoCommission()).length()) {
                addError(bizErrors, PNCommonMessageConstants.PM3210E, new String[]{"利息、繰上償還手数料"});
                throwError(bizErrors);
            }
        }
    }

    /**
     *
     * <pre>
     * （４）修正データチェック処理③
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern3(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝2又は4かつ条変起案中区分＝９
        // ・処理モード＝「処理完了：修正(4)」かつ繰償事由コード＝2又は4

        // 元金入力有の場合、以下を行う
        // 元金入力値≦０の場合、エラーとする。
        // メッセージ：元金、PM3210E
        // 元金入力無しの場合、以下を行う
        // メッセージ：元金、PM3210E
        if (0 >= cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            addError(bizErrors, PNCommonMessageConstants.PM3210E, new String[]{"元金"});
            throwError(bizErrors);
        }
    }

    /**
     *
     * <pre>
     * （５）修正データチェック処理④
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern4(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝2又は4かつ条変起案中区分＝９以外
        //
        // 充当順序チェック
        // サービスを実行し、充当順序チェックを行う。
        // Md004_01Service.checkJutoJunjo
        outDto = md004_01service.checkJutoJunjo(outDto);

        // 充当順序チェックでメッセージ編集時、以降の処理は行わない
        bizErrors.addAll(outDto.getBizErrors());
        throwError(bizErrors);

        // 請求データ検索パラメータ(債権管理番号）：取得した債権管理番号
        outDto.setSeikyuParam_ID_Credit(outDto.getID_ID_Credit());
        // 請求データ検索パラメータ(払込期日）：償還後第1回払込期日(修正)（入力値連結）
        outDto.setSeikyuParam_Date_Haraikomi(outDto.getDate_FirstHaraikomiAfterKuris_Input());
        // Md004_01Service.getSeikyu
        outDto = md004_01service.getSeikyu(outDto);

        // 利息入力有の場合、以下を行う
        if (0 != getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
            // 入力利息＞請求データ検索結果(請求繰上償還利息）の場合、エラーとする
            if (cnvStrToBig(outDto.getTxtID_M_KurishoRisoku()).doubleValue() > cnvStrToBig(
                    outDto.getSeikyuAns_ID_M_SeiKuriRisoku()).doubleValue()) {
                // メッセージ：利息が請求額、PM3180E
                addError(bizErrors, PNCommonMessageConstants.PM3180E, new String[]{"利息が請求額"});
                throwError(bizErrors);
            }
        }

        if (0 != getStrLength(outDto.getTxtID_M_KurishoGankin())) {
            // 元金入力有の場合、以下を行う
            // 元金入力値≦０の場合、エラーとする。
            // メッセージ：元金、PM3210E
            if (0 >= cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
                addError(bizErrors, PNCommonMessageConstants.PM3210E, new String[]{"元金"});
                throwError(bizErrors);
            }

            // 上記以外の場合、以下を行う
            // 入力元金＞請求データ検索結果(請求繰上償還元金）の場合、エラーとする
            // メッセージ：元金が請求額、PM3180E
            if (cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue() > cnvStrToBig(
                    outDto.getSeikyuAns_ID_M_SeiKuriGankin()).doubleValue()) {
                addError(bizErrors, PNCommonMessageConstants.PM3180E, new String[]{"元金が請求額"});
                throwError(bizErrors);
            }
        } else {
            // 元金入力無しの場合、以下を行う
            // メッセージ：元金、PM3210E
            addError(bizErrors, PNCommonMessageConstants.PM3210E, new String[]{"元金"});
            throwError(bizErrors);
        }
    }

    /**
     *
     * <pre>
     * （６）修正データチェック処理⑤
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern5(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝2、4以外かつ条変起案中区分＝９
        // ・処理モード＝「処理完了：修正(4)」かつ繰償事由コード＝2、4以外

        // 検索用DTO定義

        // 償還後第1回払込期日(修正)（入力値連結） ＜ 入金日(修正)（入力値連結）の場合、エラーとする。
        // メッセージ：入金日は償還後第1回払込期日以前、PM3140E
        if (cnvStrToBig(outDto.getDate_FirstHaraikomiAfterKuris_Input()).doubleValue() < cnvStrToBig(
                outDto.getID_Date_Nyukin_Input()).doubleValue()) {
            addError(bizErrors, PNCommonMessageConstants.PM3140E, new String[]{"入金日は償還後第1回払込期日以前"});
            throwError(bizErrors);
        }

        if (0 == getStrLength(outDto.getTxtID_M_KurishoGankin())) {
            // 元金入力無しの場合、エラーとする
            // メッセージ：元金、PM3120E
            addError(bizErrors, PNCommonMessageConstants.PM3120E, new String[]{"元金"});
            throwError(bizErrors);
        }
        // 上記以外の場合、以下を行う
        else {
            if (0 >= cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
                // 元金入力値≦０の場合、エラーとする。
                // メッセージ：元金、PM3210E
                addError(bizErrors, PNCommonMessageConstants.PM3210E, new String[]{"元金"});
                throwError(bizErrors);
            }
        }

        // 上記の全チェックが正常の場合、以下を行う

        // 払出データ存在チェック
        // サービスを実行し、払出データの存在チェックをする。
        // 直近払出データ取得ビュー検索パラメータ(債権管理番号）＝債権管理番号
        outDto.setSelectHaraidashiMaxViewParam_ID_Credit(outDto.getID_ID_Credit());
        outDto = md004_01service.getSelectHaraidashiMaxView(outDto);

        if (1 != outDto.getSelectHaraidashiMaxViewAns_Count()) {
            // 取得件数が１件でない場合、業務エラーとする
            // エラーメッセージ：払出データ、PM3190E
            addError(bizErrors, PNCommonMessageConstants.PM3190E, new String[]{"払出データ"});
            throwError(bizErrors);
        }

        // 直近払出データ取得ビュー検索結果(貸付受入金残高） ⇒ Form.払出データ貸付受入金残高
        outDto.setID_M_KashitsukeUkeire(outDto.getSelectHaraidashiMaxViewAns_M_KashitsukeukeireZan());

        // 退避貸付残高が空白以外の場合、以下を行う

        // 一時変数の差額
        BigDecimal tmpSagaku = BigDecimal.ZERO;

        if (0 != getStrLength(outDto.getID_Keep_M_KashitsukeZan())) {
            // 一時変数の差額＝退避貸付残高－Md004_01DTO.直近払出データ取得ビュー検索結果(貸付受入金残高
            tmpSagaku = cnvStrToBig(outDto.getID_Keep_M_KashitsukeZan()).subtract(
                    cnvStrToBig(outDto.getSelectHaraidashiMaxViewAns_M_KashitsukeukeireZan()));
        } else {
            // 上記以外の場合、以下を行う
            // 一時変数の差額＝貸付残高－Md004_01DTO.直近払出データ取得ビュー検索結果(貸付受入金残高
            tmpSagaku = cnvStrToBig(outDto.getID_M_KashitsukeZandaka_aRingi()).subtract(
                    cnvStrToBig(outDto.getSelectHaraidashiMaxViewAns_M_KashitsukeukeireZan()));
        }

        // 一時変数の差額＜入力元金の場合、エラーとする。
        // メッセージ：元金は貸付金残高－貸付受入金残高以下、PM3140E
        if (tmpSagaku.doubleValue() < cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            addError(bizErrors, PNCommonMessageConstants.PM3140E, new String[]{"元金は貸付金残高－貸付受入金残高以下"});
            throwError(bizErrors);
        }

        // 一時変数の貸付残高
        BigDecimal tmpKashitukezandaka = BigDecimal.ZERO;

        // 退避貸付残高が空白以外の場合、一時変数の貸付残高＝退避貸付残高
        if (0 != getStrLength(outDto.getID_Keep_M_KashitsukeZan())) {
            tmpKashitukezandaka = cnvStrToBig(outDto.getID_Keep_M_KashitsukeZan());
        }
        // 退避貸付残高が空白の場合、一時変数の貸付残高＝貸付残高
        else {
            tmpKashitukezandaka = cnvStrToBig(outDto.getID_M_KashitsukeZandaka_aRingi());
        }

        String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(outDto);
        String hantei_ShokanHouhou01 = getHantei_ShokanHouhou01(outDto);
        // 一時変数の貸付残高＝入力元金、かつ、償還方法コードの上１桁＜＞３の場合、以下を行う
        if (tmpKashitukezandaka.doubleValue() == cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()
                && !"3".equals(hantei_ShokanHouhou01)) {
            if (!"3".equals(hantei_KurishojiyuStr01) && !"6".equals(hantei_KurishojiyuStr01)) {
                // 繰償事由コードの上１桁＜＞３かつ、繰償事由コード＜＞６の場合、エラーとする。
                // メッセージ：繰償事由コードは期限短縮、PM3140E
                addError(bizErrors, PNCommonMessageConstants.PM3140E, new String[]{"繰償事由コードは期限短縮"});
                throwError(bizErrors);
            }
        }

        // 償還方法コードの上１桁＝３かつ、一時変数の貸付残高＜＞入力元金の場合、以下を行う
        // 繰償事由コードの上１桁＜＞１かつ、繰償事由コード＜＞５の場合、エラーとする。
        // メッセージ：繰償事由コードは期限固定、PM3140E
        if ("3".equals(hantei_ShokanHouhou01)
                && tmpKashitukezandaka.doubleValue() != cnvStrToBig(outDto.getTxtID_M_KurishoGankin())
                        .doubleValue()) {
            if (!"1".equals(hantei_KurishojiyuStr01) && !"5".equals(hantei_KurishojiyuStr01)) {
                addError(bizErrors, PNCommonMessageConstants.PM3140E, new String[]{"繰償事由コードは期限固定"});
                throwError(bizErrors);
            }
        }
    }

    /**
     *
     * <pre>
     *     （７）修正データチェック処理⑥
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern6(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ繰償事由コード＝2、4以外かつ条変起案中区分＝９以外

        // 償還後第1回払込期日(修正)（入力値連結） ＜ 入金日(修正)（入力値連結）の場合、エラーとする。
        // メッセージ：入金日は償還後第1回払込期日以前、PM3140E
        if (cnvStrToBig(outDto.getDate_FirstHaraikomiAfterKuris_Input()).doubleValue() < cnvStrToBig(
                outDto.getID_Date_Nyukin_Input()).doubleValue()) {
            addError(bizErrors, PNCommonMessageConstants.PM3140E, new String[]{"入金日は償還後第1回払込期日以前"});
            throwError(bizErrors);
        }

        // 充当順序チェック
        // サービスを実行し、充当順序チェックを行う。
        // Md004_01Service.checkJutoJunjo
        outDto = md004_01service.checkJutoJunjo(outDto);

        // 充当順序チェックでメッセージ編集時、以降の処理は行わない
        bizErrors.addAll(outDto.getBizErrors());
        throwError(bizErrors);

        //
        // サービスを実行し、約定データ・請求データのチェックを行う。
        //
        // 検索項目のセット
        // 約定データ存在チェック

        // サービスを実行し、約定データの存在チェックをする。

        // 約定データ検索パラメータ(債権管理番号）＝債権管理番号
        outDto.setYakujoParam_ID_Credit(outDto.getID_ID_Credit());

        // 約定データ検索パラメータ(払込期日)＝償還後第1回払込期日(修正)（入力値連結）※一致する約定データを検索
        outDto.setYakujoParam_Date_Haraikomi(outDto.getDate_FirstHaraikomiAfterKuris_Input());

        outDto = md004_01service.checkYakujo(outDto);

        // 約定データ・請求データのチェックでメッセージ編集時、以降の処理は行わない
        bizErrors.addAll(outDto.getBizErrors());
        throwError(bizErrors);

    }

    /**
     *
     * <pre>
     *       （８）修正データチェック処理⑦
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern7(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」かつ条変起案中区分＝９
        // ・処理モード＝「処理完了：修正(4)」

        // 入金日(修正)
        PNCheckDay checkDate_Nyukin = new PNCheckDay(outDto.getDrpID_Date_Nyukin_Gengo(),
                outDto.getTxtID_Date_Nyukin_Nen(), outDto.getDrpID_Date_Nyukin_Tsuki(),
                outDto.getDrpID_Date_Nyukin_Bi(), pnCommonDBComponents, bizErrors);

        // 送金日(修正)
        PNCheckDay checkDate_Sokin = new PNCheckDay(outDto.getDrpID_Date_Sokin_Gengo(),
                outDto.getTxtID_Date_Sokin_Nen(), outDto.getDrpID_Date_Sokin_Tsuki(),
                outDto.getDrpID_Date_Sokin_Bi(), pnCommonDBComponents, bizErrors);

        // 受託者勘定処理年月(修正)
// [UPD] Ver 2.0.0 - START
//        PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
//                outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "01",
//                pnCommonDBComponents, bizErrors);
        PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
                outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "",
                pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END

        // 一時変数の元金
        BigDecimal tmpGankin = BigDecimal.ZERO;
        // 一時変数の利息
        BigDecimal tmpRisoku = BigDecimal.ZERO;
        // 一時変数の繰上償還手数料
        BigDecimal tmpKurishoCommission = BigDecimal.ZERO;
        // 一時変数の控除利息
        BigDecimal tmpKojoRisoku = BigDecimal.ZERO;
        String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(outDto);
        String hantei_ShokanHouhou01 = getHantei_ShokanHouhou01(outDto);
        // 代弁履行後の作成チェック
        // 代弁履行後の作成の入力ありの場合、以下を行う
        // 繰賞事由コードが空白以外の場合、以下を行う
        // 繰賞事由コードの上１桁＝2以外 かつ、
        // 繰賞事由コードの上１桁＝4以外の場合、エラーとする。
        // メッセージ：代弁履行後の作成は、PM3280E
        if (null != outDto.getChkID_ID_After_Daiibensai()) {
            if (!"2".equals(hantei_KurishojiyuStr01) && !"4".equals(hantei_KurishojiyuStr01)) {
                addError(bizErrors, PNCommonMessageConstants.PM3280E, new String[]{"代弁履行後の作成は"});
                throwError(bizErrors);
            }
        }
        // 控除利息チェック
        // 控除利息の入力有かつ、0以外の場合、以下を行う
        if (0 != getStrLength(outDto.getTxtID_M_KojoRisoku())
                && 0 != cnvStrToBig(outDto.getTxtID_M_KojoRisoku()).doubleValue()) {
            if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                // 入力利息が空白の場合、０⇒一時変数の利息
                tmpRisoku = BigDecimal.ZERO;
            } else {
                // 入力利息が空白以外の場合、利息⇒一時変数の利息
                tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
            }

            if (cnvStrToBig(outDto.getTxtID_M_KojoRisoku()).doubleValue() > tmpRisoku.doubleValue()) {
                // 控除利息(円) ＞一時変数の利息の場合、エラーとする。
                // メッセージ：控除利息が利息、PM3180E
                addError(bizErrors, PNCommonMessageConstants.PM3180E, new String[]{"控除利息が利息"});
                throwError(bizErrors);
            }
        }

        // 繰上償還手数料チェック
        if ("0".equals(outDto.getID_Kubun_KurishoTesuryo_aRingi())) {
            // 繰上償還手数料区分＝0の場合
            if (0 != getStrLength(outDto.getTxtID_M_KurishoCommission())
                    && 0 != cnvStrToBig(outDto.getTxtID_M_KurishoCommission()).doubleValue()) {
                // 繰上償還手数料の入力あり、0以外の場合、エラーとする。
                // メッセージ：繰上償還手数料、PM3130E
                addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰上償還手数料"});
                throwError(bizErrors);
            }
        }

        // 仮受金からの充当額チェック
        // 仮受金からの充当額の入力あり、0以外の場合
        // 仮受金からの充当額(円)＞０の場合
        if (0 != getStrLength(outDto.getTxtID_M_KariukeIppanJuto())
                && 0 != cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {

            if (0 < cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
                if (0 == getStrLength(outDto.getTxtID_M_KurishoGankin())) {
                    // 入力元金が空白の場合、０⇒一時変数の元金
                    tmpGankin = BigDecimal.ZERO;
                } else {
                    // 入力元金が空白以外の場合、入力元金⇒一時変数の元金
                    tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());
                }

                if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                    // 入力利息が空白の場合、０⇒一時変数の利息
                    tmpRisoku = BigDecimal.ZERO;
                } else {
                    // 入力利息が空白以外の場合、入力利息⇒一時変数の利息
                    tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
                }

                if (0 == getStrLength(outDto.getTxtID_M_KurishoCommission())) {
                    // 繰上償還手数料(円)が空白の場合、０⇒一時変数の繰上償還手数料
                    tmpKurishoCommission = BigDecimal.ZERO;
                } else {
                    // 繰上償還手数料(円)が空白以外の場合、繰上償還手数料(円)⇒一時変数の繰上償還手数料
                    tmpKurishoCommission = cnvStrToBig(outDto.getTxtID_M_KurishoCommission());
                }

                if (0 == getStrLength(outDto.getTxtID_M_KojoRisoku())) {
                    // 控除利息(円)が空白の場合、０⇒一時変数の控除利息
                    tmpKojoRisoku = BigDecimal.ZERO;
                } else {
                    // 控除利息(円)が空白以外の場合、控除利息(円)⇒一時変数の控除利息
                    tmpKojoRisoku = cnvStrToBig(outDto.getTxtID_M_KojoRisoku());
                }
                // 一時変数の差額＝一時変数の元金＋一時変数の利息＋一時変数の繰上償還手数料－一時変数の控除利息
                BigDecimal tmpSagaku = tmpGankin.add(tmpRisoku).add(tmpKurishoCommission)
                        .subtract(tmpKojoRisoku);

                // 一時変数の差額＝仮受金からの充当額
                // 以外の場合、エラーとする。
                // メッセージ：PM3410E
                if (tmpSagaku.doubleValue() != cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto())
                        .doubleValue()) {
                    addError(bizErrors, PNCommonMessageConstants.PM3410E, new String[]{null});
                    throwError(bizErrors);
                }
            }
        }

        // 送金日チェック
        // 仮受金からの充当額の入力なし または、0の場合
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            // 送金日（元号）（年）がS64の場合、エラーとする。
            // メッセージ：送金日に、PM3290E
            checkDate_Sokin.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{"送金日に"});
            throwError(bizErrors);

            // 送金日（元号）（年）（月）（日）が全て入力されている場合、以下を行う
            // 共通処理の和暦有効日付チェックにて（元号）（年）（月）（日）をチェックする。有効な日付でない場合、エラーとする。
            // メッセージ：送金日を有効な日付、PM3140E
            checkDate_Sokin.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                    new String[]{"送金日を有効な日付"});
            throwError(bizErrors);

            // 上記以外の場合、エラーとする (入力なし)
            // メッセージ：送金日、PM3120E
            checkDate_Sokin.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[]{"送金日"});
            throwError(bizErrors);

            // 上記のチェックでエラーとならなかった場合
            // 共通処理の西暦変換にて送金日を西暦変換しDTOに保持する。(送金日(修正)（入力値連結）)
            outDto.setID_Date_Sokin_Input(checkDate_Sokin.getSeireki());

            // 送金日に対し共通処理の営業日判定を行い、非営業日の場合、エラーとする。
            // メッセージ：送金日が、PM3331E
            checkDate_Sokin.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[]{"送金日は"});
            throwError(bizErrors);
            checkDate_Nyukin.addErrorDayOverDay(checkDate_Sokin.getSeireki(),
                    PNCommonMessageConstants.PM3140E, new String[]{"送金日は入金日以降"});
            throwError(bizErrors);
        }
        // 上記以外の場合、以下を行う
        else {
            // 仮受金からの充当額 ＞ 0の場合
            if (0 < cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
                // 送金日（年）（月）（日）のいずれかが入力されている場合、エラーとする。
                // メッセージ：送金日、PM3130E
                checkDate_Sokin.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E,
                        new String[]{"送金日"});
                throwError(bizErrors);
            }
        }

        // 送金日番号チェック
        // 仮受金からの充当額の入力なし または、0の場合、以下を行う
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            // 送信日番号の入力がない場合、エラーとする。
            if (0 == getStrLength(outDto.getTxtID_ID_Sokinbi())) {
                // メッセージ：送金日番号、PM3120E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[]{"送金日番号"},
                        false));
                throwError(bizErrors);
            }
        } else {
            // 上記以外の場合、以下を行う
            // 仮受金からの充当額 ＞ 0の場合
            // 送信日番号の入力ありの場合、エラーとする。
            // メッセージ：送金日番号、PM3130E
            if (0 != getStrLength(outDto.getTxtID_ID_Sokinbi())) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E, new String[]{"送金日番号"},
                        false));
                throwError(bizErrors);
            }
        }

        // 送金額算出
        // 上記のチェックでエラーとならなかった場合、以下を行う
        // 仮受金からの充当額の入力なし、または0の場合、以下を行う
        // 仮受金からの充当額の入力なし または、0の場合
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {

            if (0 == getStrLength(outDto.getTxtID_M_KurishoGankin())) {
                // 入力元金が空白の場合、０⇒一時変数の元金
                tmpGankin = BigDecimal.ZERO;
            } else {
                // 入力元金が空白以外の場合、入力元金⇒一時変数の元金
                tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                // 入力利息が空白の場合、０⇒一時変数の利息
                tmpRisoku = BigDecimal.ZERO;
            } else {
                // 入力利息が空白以外の場合、入力利息⇒一時変数の利息
                tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoCommission())) {
                // 繰上償還手数料(円)が空白の場合、０⇒一時変数の繰上償還手数料
                tmpKurishoCommission = BigDecimal.ZERO;
            } else {
                // 繰上償還手数料(円)が空白以外の場合、繰上償還手数料(円)⇒一時変数の繰上償還手数料
                tmpKurishoCommission = cnvStrToBig(outDto.getTxtID_M_KurishoCommission());
            }

            BigDecimal tmpKariukeIppanJuto = BigDecimal.ZERO;
            if (0 == getStrLength(outDto.getTxtID_M_KariukeIppanJuto())) {
                // 仮受金からの充当額が空白の場合、０⇒一時変数の仮受金からの充当額
                tmpKariukeIppanJuto = BigDecimal.ZERO;
            } else {
                // 仮受金からの充当額が空白以外の場合、仮受金からの充当額⇒一時変数の仮受金からの充当額
                tmpKariukeIppanJuto = cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KojoRisoku())) {
                // 控除利息(円)が空白の場合、０⇒一時変数の控除利息
                tmpKojoRisoku = BigDecimal.ZERO;
            } else {
                // 控除利息(円)が空白以外の場合、控除利息(円)⇒一時変数の控除利息
                tmpKojoRisoku = cnvStrToBig(outDto.getTxtID_M_KojoRisoku());
            }

            // 一時変数の送金額＝一時変数の元金＋一時変数の利息＋一時変数の繰上償還手数料
            // －一時変数の仮受金からの充当額－一時変数の控除利息
            BigDecimal tmpSokingaku = tmpGankin.add(tmpRisoku).add(tmpKurishoCommission)
                    .subtract(tmpKariukeIppanJuto).subtract(tmpKojoRisoku);

            // 一時変数の送金額＜＝ 0の場合、エラーとする。
            // メッセージ：送金額、PM3430E
            if (0 >= tmpSokingaku.doubleValue()) {
                addError(bizErrors, PNCommonMessageConstants.PM3430E, new String[]{"送金額"});
                throwError(bizErrors);
            }
            // 上記以外の場合
            // 一時変数の送金額⇒送金額(円)
            outDto.setTxtID_M_Sokin(cnvBigToStr(tmpSokingaku));
        } else {
            // 仮受金からの充当額に入力がある場合
            // 空白⇒送金額(円)
            outDto.setTxtID_M_Sokin("");
        }

        // 繰償後残元金算出
        // 上記のチェックでエラーとならなかった場合
        // 元金(DB取得値)があり、０でない場合
        BigDecimal tmpBeforeKashitukeZan = BigDecimal.ZERO;
        if (0 != cnvStrToBig(outDto.getID_M_KurishoGankin_Save()).doubleValue()) {
            // 一時変数の報告書作成前の貸付金残高＝繰償後残元金(DB取得値)＋元金(DB取得値)
            tmpBeforeKashitukeZan = cnvStrToBig(outDto.getTxtID_M_ZanGankinAfterKurisho()).add(
                    cnvStrToBig(outDto.getID_M_KurishoGankin_Save()));
        } else {
            // 元金(DB取得値)がなし、または０の場合
            // 一時変数の報告書作成前の貸付金残高＝繰償後残元金(DB取得値)
            tmpBeforeKashitukeZan = cnvStrToBig(outDto.getTxtID_M_ZanGankinAfterKurisho());
        }

        // 繰償後残元金の算出
        // 入力元金があり、０でない場合
        BigDecimal tmpAfterKurishoGankin = BigDecimal.ZERO;
        if (0 != cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            // 一時変数の繰償後残元金＝一時変数の報告書作成前の貸付金残高－入力元金
            tmpAfterKurishoGankin = tmpBeforeKashitukeZan.subtract(cnvStrToBig(outDto
                    .getTxtID_M_KurishoGankin()));
        }
        // 入力元金がなし、または０の場合
        else {
            // 一時変数の報告書作成前の貸付金残高⇒一時変数の繰償後残元金
            tmpAfterKurishoGankin = tmpBeforeKashitukeZan;
        }

        // 一時変数の繰償後残元金⇒繰償後残元金
        outDto.setTxtID_M_ZanGankinAfterKurisho(cnvBigToStr(tmpAfterKurishoGankin));
        // 一時変数の繰償後残元金⇒繰償後残元金算出値SAVE
        outDto.setSave_ID_M_KashitsukeZan(cnvBigToStr(tmpAfterKurishoGankin));

        // 受託者勘定処理年月のチェック
        // False⇒留置金対象外フラグ
        boolean flgNotRiyuchiKin = false;

        // ①回収未調整金（仮受金）からの充当の場合 対象外とする
        // 仮受金からの充当額に入力あり、仮受金からの充当額＞０の場合、True⇒留置金対象外フラグ
        if (0 < cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            flgNotRiyuchiKin = true;
        }

        // ②送金額（直前で算出されている）が≦０の場合 対象外とする
        // 送金額に入力あり、送金額＜＝０の場合、True⇒留置金対象外フラグ
        if (0 != getStrLength(outDto.getTxtID_M_Sokin())) {
            if (0 >= cnvStrToBig(outDto.getTxtID_M_Sokin()).doubleValue()) {
                flgNotRiyuchiKin = true;
            }
        }

        String toDay = pnCommonDBComponents.getPNBusinessDay(1);

        // ③決算整理期間を超えている場合 対象外とする
        // 年度末日の取得
        // 年度末日算出(共通部品)より、年度末日を取得する。
        String nendoMatsubi = PNCommonComponents.getNendoMatsujitu(
                pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(0, 4),
                pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(4, 6))
                .replace("/", "");

        String kessanbi = "";
        if (!flgNotRiyuchiKin) {
            // 決算整理日付の取得
            kessanbi = pnCommonDBComponents.getKessanbi();

            // 決算整理日付の取得エラー
            // 決算整理期限の取得ができない場合、エラーとする。
            // メッセージ：決算整理日付、PM3190E
            if (0 == getStrLength(kessanbi)) {
                addError(bizErrors, PNCommonMessageConstants.PM3190E, new String[]{"決算整理日付"});
                throwError(bizErrors);
            }
            // 決算整理日付の取得できた場合
            else {
                // 年度末日 ＜ 報告書作成日(システム日付) ＜ 決算整理日付 であること

                // 年度末日＞＝システム日付、または、システム日付＞＝決算整理日の場合、True⇒留置金対象外フラグ
                if (cnvStrToInteger(nendoMatsubi) >= cnvStrToInteger(toDay)
                        || cnvStrToInteger(toDay) >= cnvStrToInteger(kessanbi)) {
                    flgNotRiyuchiKin = true;
                }
            }
        }

        // ④入金日＞年度末日の場合 対象外とする
        // 留置金対象外フラグがFalseの場合
        // 入金日＞年度末日の場合、True⇒留置金対象外フラグ
        if (!flgNotRiyuchiKin) {
            if (cnvStrToInteger(checkDate_Nyukin.getSeireki()) > cnvStrToInteger(nendoMatsubi)) {
                flgNotRiyuchiKin = true;
            }
        }

        // ⑤年度末日＞送金日の場合 対象外とする
        // 留置金対象外フラグがFalseの場合
        // 年度末日＞＝送金日の場合、True⇒留置金対象外フラグ
        if (!flgNotRiyuchiKin) {
            if (cnvStrToInteger(nendoMatsubi) >= cnvStrToInteger(checkDate_Sokin.getSeireki())) {
                flgNotRiyuchiKin = true;
            }
        }

        // ⑥受託者勘定処理年月のチェック
        // 留置金対象外フラグがTrueの場合
        if (flgNotRiyuchiKin) {
            // 入金日以前エラー
            // 受託者処理勘定年月 ＜ 入金日（年月）の場合、エラーとする。
            // メッセージ：受託者勘定処理年月は入金日以降の日付、PM3140E
            checkDate_Jtkshori.addErrorDayUnderMonthDay(checkDate_Nyukin.getSeireki(),
                    PNCommonMessageConstants.PM3140E, new String[]{"受託者勘定処理年月は入金日以降の日付"});
            throwError(bizErrors);
        } else {
            // 留置金対象外フラグがFalseの場合
            //
            // 入金日以降エラー
            // 受託者処理勘定年月 ＞ 入金日(年月)の場合、エラーとする。
            // メッセージ：受託者勘定処理年月（留置金）が入金日、PM3260E
            checkDate_Jtkshori.addErrorDayOverMonthDay(checkDate_Nyukin.getSeireki(),
                    PNCommonMessageConstants.PM3260E, new String[]{"受託者勘定処理年月（留置金）が入金日"});
            throwError(bizErrors);
        }

        // 本店決算整理日とサーバで取得した処理日の比較チェック
        // 決算整理日＜システム日付の場合
        if (0 != kessanbi.length() && cnvStrToInteger(kessanbi) < cnvStrToInteger(toDay)) {
            // 本年度期初日を求める
            // 年度初日算出(共通部品)より、本年度期初日を取得する。
            String nendoHajime = PNCommonComponents.getNendoHajime(
                    pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(0, 4),
                    pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(4, 6))
                    .replace("/", "");
            //
            // 公庫決算終了エラー
            // 受託者処理勘定年月 ＜ 本年度期初日の場合、エラーとする。
            // メッセージ：PM3810E
            checkDate_Jtkshori.addErrorDayUnderMonthDay(nendoHajime, PNCommonMessageConstants.PM3810E,
                    new String[0]);
            throwError(bizErrors);
        }

        // メッセージ用ループインデックス初期化
        int loop_index = 1;
        // 一時変数払込元金合計初期化
        outDto.setTmpSumHaraikomiGankin(BigDecimal.ZERO);

        // 元金が空白以外の場合、元金⇒一時変数の元金
        // 元金が空白の場合、０⇒一時変数の元金
        tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());

        outDto.setID_Date_Haraikomi1_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi1_Gengo(),
                        outDto.getTxtID_Date_Haraikomi1_Nen(), outDto.getDrpID_Date_Haraikomi1_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi1_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin1(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 2;
        outDto.setID_Date_Haraikomi2_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi2_Gengo(),
                        outDto.getTxtID_Date_Haraikomi2_Nen(), outDto.getDrpID_Date_Haraikomi2_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi2_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin2(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 3;
        outDto.setID_Date_Haraikomi3_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi3_Gengo(),
                        outDto.getTxtID_Date_Haraikomi3_Nen(), outDto.getDrpID_Date_Haraikomi3_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi3_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin3(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 4;
        outDto.setID_Date_Haraikomi4_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi4_Gengo(),
                        outDto.getTxtID_Date_Haraikomi4_Nen(), outDto.getDrpID_Date_Haraikomi4_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi4_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin4(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        // 払込期日１～４、払込元金１～４のチェック（各項目の相関チェック）
        // 上記のチェックでエラーとならなかった場合

        if ("3".equals(hantei_ShokanHouhou01)) {
            // 繰償事由コードの入力ありの場合
            if (0 != getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
                // 繰償事由コードの上1桁＝2以外 かつ繰償事由コードの上1桁＝4以外の場合
                if (!"2".equals(hantei_KurishojiyuStr01) && !"4".equals(hantei_KurishojiyuStr01)) {
                    // 繰償後残元金＞０のとき
                    if (0 < tmpAfterKurishoGankin.doubleValue()) {
                        // 払込期日①～④(修正)（入力値連結）が全て空文字の場合、エラーとする。
                        if (0 == PNCommonStringUtils.concatString(
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi1_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi2_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi3_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi4_Input()))
                                .length()) {
                            // メッセージ：払込期日１～４、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"払込期日１～４"});
                            throwError(bizErrors);
                        }

                        // 払込期日重複エラー

                        // 払込期日１～４が重複した場合、エラーとする。
                        // ※払込期日①が空文字以外の場合、払込期日①と払込期日②～④のいずれかが一致している場合、エラー
                        // ※払込期日②が空文字以外の場合、払込期日②と払込期日①、③、④のいずれかが一致している場合、エラー
                        // ※払込期日③が空文字以外の場合、払込期日③と払込期日①、②、④のいずれかが一致している場合、エラー
                        // ※払込期日④が空文字以外の場合、払込期日④と払込期日①～③のいずれかが一致している場合、エラー
                        ArrayList<String> tmpStrList = new ArrayList<String>(4);
                        tmpStrList.add(outDto.getID_Date_Haraikomi1_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi2_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi3_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi4_Input());
                        // メッセージ：払込期日１～４、PM3301E
                        if (overlapCheck(tmpStrList)) {
                            this.addError(bizErrors, PNCommonMessageConstants.PM3301E,
                                    new String[]{"払込期日１～４"});
                            throwError(bizErrors);
                        }

                        // 払込元金のチェック
                        // 払込元金１～４の合計を求め、
                        BigDecimal sum_GetTxtID_M_HaraikomiGankin1 = cnvStrToBig(
                                outDto.getTxtID_M_HaraikomiGankin1())
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin2()))
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin3()))
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin4()));
                        // その合計値が繰償後残元金と等しくない場合、エラーとする。
                        if (sum_GetTxtID_M_HaraikomiGankin1.doubleValue() != cnvStrToBig(
                                outDto.getTxtID_M_ZanGankinAfterKurisho()).doubleValue()) {
                            // メッセージ：払込元金１～４の合計は繰上償還後の貸付金残高と同額、PM3140E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                    new String[]{"払込元金１～４の合計は繰上償還後の貸付金残高と同額"});
                            throwError(bizErrors);
                        }
                    }
                }
            }
        }
        // 繰償後元金均等額・繰償後元金不均等額・調整コードのチェック
        // 繰償事由コード入力なしの場合
        if (0 == getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
            // 繰償後元金均等額の入力ありの場合、エラーとする。
            if (0 != getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                // メッセージ：繰償後元金均等額、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金均等額"});
                throwError(bizErrors);
            }

            // 繰償後元金不均等額の入力ありの場合、エラーとする。
            if (0 != PNCommonComponents.cnvNulltoBlank(outDto.getTxtID_M_GankinFukintoAfterKurisho())
                    .length()) {
                // メッセージ：繰償後元金不均等額、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金不均等額"});
                throwError(bizErrors);
            }

            // 調整コード入力チェック
            // 調整コードの入力ありの場合、エラーとする。
            if (0 != PNCommonComponents.cnvNulltoBlank(outDto.getRdoID_Code_chosei()).length()) {
                // メッセージ：調整コード、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                throwError(bizErrors);
            }

        }
        // 繰償事由コード入力ありの場合
        else {

            // 償還方法コードの上1桁＝1、3、9の場合
            if (Arrays.asList(new String[]{"1", "3", "9"}).contains(hantei_ShokanHouhou01)) {
                // 繰償後元金均等額の入力ありの場合、エラーとする。
                if (0 != getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                    // メッセージ：繰償後元金均等額、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金均等額"});
                    throwError(bizErrors);
                }

                // 繰償後元金不均等額の入力ありの場合、エラーとする。
                if (0 != getStrLength(outDto.getTxtID_M_GankinFukintoAfterKurisho())) {
                    // メッセージ：繰償後元金不均等額、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金不均等額"});
                    throwError(bizErrors);
                }
                // 調整コード入力チェック
                // 調整コードの入力ありの場合、エラーとする。
                if (0 != PNCommonComponents.cnvNulltoBlank(outDto.getRdoID_Code_chosei()).length()) {
                    // メッセージ：調整コード、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                    throwError(bizErrors);
                }
            }

            // 償還方法コードの上1桁＝2の場合
            if ("2".equals(hantei_ShokanHouhou01)) {
                // 元金が空白の場合、０⇒一時変数の元金
                // 元金が空白以外の場合、元金⇒一時変数の元金
                tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());

                // 繰償事由コードの入力ありの場合
                if (0 != getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
                    // (繰償事由コードの上1桁＝1 または、繰償事由コードの上1桁＝5) かつ、一時変数の元金 ＞ 0の場合、以下を行う
                    if (Arrays.asList(new String[]{"1", "5"}).contains(hantei_KurishojiyuStr01)
                            && 0 < tmpGankin.doubleValue()) {

                        // 繰償後元金均等額の入力なしの場合、エラーとする。
                        if (0 == getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                            // メッセージ：繰償後元金均等額、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"繰償後元金均等額"});
                            throwError(bizErrors);
                        }

                        // 繰償後元金不均等額の入力なしの場合、エラーとする。
                        if (0 == getStrLength(outDto.getTxtID_M_GankinFukintoAfterKurisho())) {
                            // メッセージ：繰償後元金不均等額、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"繰償後元金不均等額"});
                            throwError(bizErrors);
                        }
                        // 繰償後元金不均等額の入力ありの場合
                        else {
                            // 繰償後元金不均等額＝0の場合
                            if (0 == cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho()).doubleValue()) {
                                // 調整コードの入力ありの場合、エラーとする。
                                if (0 != getStrLength(outDto.getRdoID_Code_chosei())) {
                                    // メッセージ：調整コードは「なし」、PM3140E
                                    this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                            new String[]{"調整コードは「なし」"});
                                    throwError(bizErrors);
                                }
                            }

                            else {
                                // 調整コードの入力なしの場合、エラーとする。
                                if (0 == PNCommonComponents.cnvNulltoBlank(outDto.getRdoID_Code_chosei())
                                        .length()) {
                                    // メッセージ：調整コードは「初回」または「最終回」、PM3140E
                                    this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                            new String[]{"調整コードは「初回」または「最終回」"});
                                    throwError(bizErrors);
                                }
                            }
                        }
                    }
                    // 上記以外の場合、以下を行う
                    else {
                        // 繰償後元金均等額の入力ありの場合、エラーとする。
                        if (0 < cnvStrToBig(outDto.getTxtID_M_GankinKintoAfterKurisho()).doubleValue()) {
                            // メッセージ：繰償後元金均等額、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E,
                                    new String[]{"繰償後元金均等額"});
                            throwError(bizErrors);
                        }

                        // 繰償後元金不均等額の入力ありの場合、エラーとする。
                        if (0 < cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho()).doubleValue()) {
                            // メッセージ：繰償後元金不均等額、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E,
                                    new String[]{"繰償後元金不均等額"});
                            throwError(bizErrors);
                        }
                        // 調整コード入力チェック
                        // 調整コードの入力ありの場合、エラーとする。
                        if (0 != PNCommonComponents.cnvNulltoBlank(outDto.getRdoID_Code_chosei()).length()) {
                            // メッセージ：調整コード、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                            throwError(bizErrors);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * <pre>
     *  （９）修正データチェック処理⑧
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void editPattern8(Md004_01DTO outDto, List<PNMessageInfo> bizErrors) {
        // ※実施条件は以下
        // ・処理モード＝「処理完了以外：修正(2)」　かつ　条変起案中区分＝９以外

        BigDecimal tmpGankin = BigDecimal.ZERO;

        // 入金日(修正)
        PNCheckDay checkDate_Nyukin = new PNCheckDay(outDto.getDrpID_Date_Nyukin_Gengo(),
                outDto.getTxtID_Date_Nyukin_Nen(), outDto.getDrpID_Date_Nyukin_Tsuki(),
                outDto.getDrpID_Date_Nyukin_Bi(), pnCommonDBComponents, bizErrors);

        // 送金日(修正)
        PNCheckDay checkDate_Sokin = new PNCheckDay(outDto.getDrpID_Date_Sokin_Gengo(),
                outDto.getTxtID_Date_Sokin_Nen(), outDto.getDrpID_Date_Sokin_Tsuki(),
                outDto.getDrpID_Date_Sokin_Bi(), pnCommonDBComponents, bizErrors);

        // 受託者勘定処理年月(修正)
// [UPD] Ver 2.0.0 - START
//        PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
//                outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "01",
//                pnCommonDBComponents, bizErrors);
        PNCheckDay checkDate_Jtkshori = new PNCheckDay(outDto.getDrpID_Date_Jtkshori_Gengo(),
                outDto.getTxtID_Date_Jtkshori_Nen(), outDto.getDrpID_Date_Jtkshori_Tsuki(), "",
                pnCommonDBComponents, bizErrors);
// [UPD] Ver 2.0.0 - END

        // 一時変数の利息
        BigDecimal tmpRisoku = BigDecimal.ZERO;
        // 一時変数の繰上償還手数料
        BigDecimal tmpKurishoCommission = BigDecimal.ZERO;
        // 一時変数の控除利息
        BigDecimal tmpKojoRisoku = BigDecimal.ZERO;
        String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(outDto);
        // 代弁履行後の作成チェック
        // 代弁履行後の作成の入力ありの場合
        // 繰償事由コードの入力ありの場合
        // 繰償事由コードの上1桁＝2以外 かつ、
        // 繰償事由コードの上1桁＝4以外の場合、エラーとする。
        // メッセージ：代弁履行後の作成は、PM3280E

        if (null != outDto.getChkID_ID_After_Daiibensai()) {
            if (!"2".equals(hantei_KurishojiyuStr01) && !"4".equals(hantei_KurishojiyuStr01)) {
                addError(bizErrors, PNCommonMessageConstants.PM3280E, new String[]{"代弁履行後の作成は"});
                throwError(bizErrors);
            }
        }

        // 控除利息チェック
        // 控除利息の入力有かつ、0以外の場合、以下を行う
        if (0 != getStrLength(outDto.getTxtID_M_KojoRisoku())
                && 0 != cnvStrToBig(outDto.getTxtID_M_KojoRisoku()).doubleValue()) {
            if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                // 入力利息が空白の場合、０⇒一時変数の利息
                tmpRisoku = BigDecimal.ZERO;
            } else {
                // 入力利息が空白以外の場合、利息⇒一時変数の利息
                tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
            }

            if (cnvStrToBig(outDto.getTxtID_M_KojoRisoku()).doubleValue() > tmpRisoku.doubleValue()) {
                // 控除利息(円) ＞一時変数の利息の場合、エラーとする。
                // メッセージ：控除利息が利息、PM3180E
                addError(bizErrors, PNCommonMessageConstants.PM3180E, new String[]{"控除利息が利息"});
                throwError(bizErrors);
            }
        }

        // 繰上償還手数料チェック
        if ("0".equals(outDto.getID_Kubun_KurishoTesuryo_aRingi())) {
            // 繰上償還手数料区分＝0の場合
            if (0 != getStrLength(outDto.getTxtID_M_KurishoCommission())
                    && 0 != cnvStrToBig(outDto.getTxtID_M_KurishoCommission()).doubleValue()) {
                // 繰上償還手数料の入力あり、0以外の場合、エラーとする。
                // メッセージ：繰上償還手数料、PM3130E
                addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰上償還手数料"});
                throwError(bizErrors);
            }
        }

        // 仮受金からの充当額チェック
        // 仮受金からの充当額の入力あり、0以外の場合
        // 仮受金からの充当額(円)＞０の場合
        if (0 != getStrLength(outDto.getTxtID_M_KariukeIppanJuto())
                && 0 != cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {

            if (0 == getStrLength(outDto.getTxtID_M_KurishoGankin())) {
                // 入力元金が空白の場合、０⇒一時変数の元金
                tmpGankin = BigDecimal.ZERO;
            } else {
                // 入力元金が空白以外の場合、入力元金⇒一時変数の元金
                tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                // 入力利息が空白の場合、０⇒一時変数の利息
                tmpRisoku = BigDecimal.ZERO;
            } else {
                // 入力利息が空白以外の場合、入力利息⇒一時変数の利息
                tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoCommission())) {
                // 繰上償還手数料(円)が空白の場合、０⇒一時変数の繰上償還手数料
                tmpKurishoCommission = BigDecimal.ZERO;
            } else {
                // 繰上償還手数料(円)が空白以外の場合、繰上償還手数料(円)⇒一時変数の繰上償還手数料
                tmpKurishoCommission = cnvStrToBig(outDto.getTxtID_M_KurishoCommission());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KojoRisoku())) {
                // 控除利息(円)が空白の場合、０⇒一時変数の控除利息
                tmpKojoRisoku = BigDecimal.ZERO;
            } else {
                // 控除利息(円)が空白以外の場合、控除利息(円)⇒一時変数の控除利息
                tmpKojoRisoku = cnvStrToBig(outDto.getTxtID_M_KojoRisoku());
            }

            // 一時変数の差額＝一時変数の元金＋一時変数の利息＋一時変数の繰上償還手数料－一時変数の控除利息
            BigDecimal tmpSagaku = tmpGankin.add(tmpRisoku).add(tmpKurishoCommission).subtract(tmpKojoRisoku);

            // 一時変数の差額＝仮受金からの充当額
            // 以外の場合、エラーとする。
            // メッセージ：PM3410E
            if (tmpSagaku.doubleValue() != cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
                addError(bizErrors, PNCommonMessageConstants.PM3410E, new String[]{null});
                throwError(bizErrors);
            }
        }

        // 送金日チェック
        // 仮受金からの充当額の入力なし または、0の場合
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            // 送金日（元号）（年）がS64の場合、エラーとする。
            // メッセージ：送金日、PM3290E
            checkDate_Sokin.addErrorS64(PNCommonMessageConstants.PM3291E, new String[]{"送金日に"});
            throwError(bizErrors);

            // 送金日（元号）（年）（月）（日）が全て入力されている場合、以下を行う
            // 共通処理の和暦有効日付チェックにて（元号）（年）（月）（日）をチェックする。有効な日付でない場合、エラーとする。
            // メッセージ：送金日を有効な日付、PM3140E
            checkDate_Sokin.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                    new String[]{"送金日を有効な日付"});
            throwError(bizErrors);

            // 上記以外の場合、エラーとする (入力なし)
            // メッセージ：送金日、PM3120E
            checkDate_Sokin.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[]{"送金日"});
            throwError(bizErrors);

            // 上記のチェックでエラーとならなかった場合
            // 共通処理の西暦変換にて送金日を西暦変換しDTOに保持する。(送金日(修正)（入力値連結）)
            outDto.setID_Date_Sokin_Input(checkDate_Sokin.getSeireki());

            // 送金日に対し共通処理の営業日判定を行い、非営業日の場合、エラーとする。
            // メッセージ：送金日が、PM3331E
            checkDate_Sokin.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[]{"送金日は"});
            throwError(bizErrors);

            checkDate_Nyukin.addErrorDayOverDay(checkDate_Sokin.getSeireki(),
                    PNCommonMessageConstants.PM3140E, new String[]{"送金日は入金日以降"});
            throwError(bizErrors);
        }
        // 上記以外の場合、以下を行う
        else {
            // 仮受金からの充当額 ＞ 0の場合
            if (0 < cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
                // 送金日（年）（月）（日）のいずれかが入力されている場合、エラーとする。
                // メッセージ：送金日、PM3130E
                checkDate_Sokin.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E,
                        new String[]{"送金日"});
                throwError(bizErrors);
            }
        }

        // 送金日番号チェック
        // 仮受金からの充当額の入力なし または、0の場合、以下を行う
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            // 送信日番号の入力がない場合、エラーとする。
            // メッセージ：送金日番号、PM3120E
            if (0 == getStrLength(outDto.getTxtID_ID_Sokinbi())) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3120E, new String[]{"送金日番号"},
                        false));
                throwError(bizErrors);
            }
        }
        // 上記以外の場合、以下を行う
        // 仮受金からの充当額 ＞ 0の場合
        else {

            // 送信日番号の入力ありの場合、エラーとする。
            // メッセージ：送金日番号、PM3130E
            if (0 != getStrLength(outDto.getTxtID_ID_Sokinbi())) {
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3130E, new String[]{"送金日番号"},
                        false));
                throwError(bizErrors);
            }
        }

        // 送金額算出
        // 上記のチェックでエラーとならなかった場合、以下を行う
        // 仮受金からの充当額の入力なし、または0の場合、以下を行う
        // 仮受金からの充当額の入力なし または、0の場合
        if (0 == cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {

            if (0 == getStrLength(outDto.getTxtID_M_KurishoGankin())) {
                // 入力元金が空白の場合、０⇒一時変数の元金
                tmpGankin = BigDecimal.ZERO;
            } else {
                // 入力元金が空白以外の場合、入力元金⇒一時変数の元金
                tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoRisoku())) {
                // 入力利息が空白の場合、０⇒一時変数の利息
                tmpRisoku = BigDecimal.ZERO;
            } else {
                // 入力利息が空白以外の場合、入力利息⇒一時変数の利息
                tmpRisoku = cnvStrToBig(outDto.getTxtID_M_KurishoRisoku());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KurishoCommission())) {
                // 繰上償還手数料(円)が空白の場合、０⇒一時変数の繰上償還手数料
                tmpKurishoCommission = BigDecimal.ZERO;
            } else {
                // 繰上償還手数料(円)が空白以外の場合、繰上償還手数料(円)⇒一時変数の繰上償還手数料
                tmpKurishoCommission = cnvStrToBig(outDto.getTxtID_M_KurishoCommission());
            }

            BigDecimal tmpKariukeIppanJuto = BigDecimal.ZERO;
            if (0 == getStrLength(outDto.getTxtID_M_KariukeIppanJuto())) {
                // 仮受金からの充当額が空白の場合、０⇒一時変数の仮受金からの充当額
                tmpKariukeIppanJuto = BigDecimal.ZERO;
            } else {
                // 仮受金からの充当額が空白以外の場合、仮受金からの充当額⇒一時変数の仮受金からの充当額
                tmpKariukeIppanJuto = cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto());
            }

            if (0 == getStrLength(outDto.getTxtID_M_KojoRisoku())) {
                // 控除利息(円)が空白の場合、０⇒一時変数の控除利息
                tmpKojoRisoku = BigDecimal.ZERO;
            } else {
                // 控除利息(円)が空白以外の場合、控除利息(円)⇒一時変数の控除利息
                tmpKojoRisoku = cnvStrToBig(outDto.getTxtID_M_KojoRisoku());
            }

            // 一時変数の送金額＝一時変数の元金＋一時変数の利息＋一時変数の繰上償還手数料
            // －一時変数の仮受金からの充当額－一時変数の控除利息
            BigDecimal tmpSokingaku = tmpGankin.add(tmpRisoku).add(tmpKurishoCommission)
                    .subtract(tmpKariukeIppanJuto).subtract(tmpKojoRisoku);

            // 一時変数の送金額＜＝ 0の場合、エラーとする。
            // メッセージ：送金額、PM3430E
            if (0 >= tmpSokingaku.doubleValue()) {
                addError(bizErrors, PNCommonMessageConstants.PM3430E, new String[]{"送金額"});
                throwError(bizErrors);
            }
            // 上記以外の場合
            // 一時変数の送金額⇒送金額(円)
            outDto.setTxtID_M_Sokin(cnvBigToStr(tmpSokingaku));
        } else {
            // 仮受金からの充当額に入力がある場合
            // 空白⇒送金額(円)
            outDto.setTxtID_M_Sokin("");
        }

        // 繰償後残元金算出
        // 上記のチェックでエラーとならなかった場合
        // 元金(DB取得値)があり、０でない場合
        BigDecimal tmpBeforeKashitukeZan = BigDecimal.ZERO;
        if (0 != cnvStrToBig(outDto.getID_M_KurishoGankin_Save()).doubleValue()) {
            // 一時変数の報告書作成前の貸付金残高＝繰償後残元金(DB取得値)＋元金(DB取得値)
            tmpBeforeKashitukeZan = cnvStrToBig(outDto.getID_M_ZanGankinAfterKurisho_Save()).add(
                    cnvStrToBig(outDto.getID_M_KurishoGankin_Save()));
        } else {
            // 元金(DB取得値)がなし、または０の場合
            // 一時変数の報告書作成前の貸付金残高＝繰償後残元金(DB取得値)
            tmpBeforeKashitukeZan = cnvStrToBig(outDto.getID_M_ZanGankinAfterKurisho_Save());
        }

        // 繰償後残元金の算出
        // 入力元金があり、０でない場合
        BigDecimal tmpAfterKurishoGankin = BigDecimal.ZERO;
        if (0 != cnvStrToBig(outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            // 一時変数の繰償後残元金＝一時変数の報告書作成前の貸付金残高－入力元金
            tmpAfterKurishoGankin = tmpBeforeKashitukeZan.subtract(cnvStrToBig(outDto
                    .getTxtID_M_KurishoGankin()));
        }
        // 入力元金がなし、または０の場合
        else {
            // 一時変数の報告書作成前の貸付金残高⇒一時変数の繰償後残元金
            tmpAfterKurishoGankin = tmpBeforeKashitukeZan;
        }
        // 一時変数の繰償後残元金⇒繰償後残元金
        outDto.setTxtID_M_ZanGankinAfterKurisho(cnvBigToStr(tmpAfterKurishoGankin));
        // 一時変数の繰償後残元金⇒繰償後残元金算出値SAVE
        outDto.setSave_ID_M_KashitsukeZan(cnvBigToStr(tmpAfterKurishoGankin));

        // 受託者勘定処理年月のチェック
        // False⇒留置金対象外フラグ
        boolean flgNotRiyuchiKin = false;

        // ①回収未調整金（仮受金）からの充当の場合 対象外とする
        // 仮受金からの充当額に入力あり、仮受金からの充当額＞０の場合、True⇒留置金対象外フラグ
        if (0 < cnvStrToBig(outDto.getTxtID_M_KariukeIppanJuto()).doubleValue()) {
            flgNotRiyuchiKin = true;
        }

        // ②送金額（直前で算出されている）が≦０の場合 対象外とする
        if (0 != getStrLength(outDto.getTxtID_M_Sokin())) {
            // 送金額に入力あり、送金額＜＝０の場合、True⇒留置金対象外フラグ
            if (0 >= cnvStrToBig(outDto.getTxtID_M_Sokin()).doubleValue()) {
                flgNotRiyuchiKin = true;
            }
        }

        String toDay = pnCommonDBComponents.getPNBusinessDay(1);

        // ③決算整理期間を超えている場合 対象外とする
        // 年度末日の取得
        // 年度末日算出(共通部品)より、年度末日を取得する。
        String nendoMatsubi = PNCommonComponents.getNendoMatsujitu(
                pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(0, 4),
                pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(4, 6))
                .replace("/", "");

        String kessanbi = "";

        // 留置金対象外フラグがfalseの場合
        if (!flgNotRiyuchiKin) {

            kessanbi = PNCommonComponents.cnvNulltoBlank(pnCommonDBComponents.getKessanbi());

            // 決算整理日付の取得エラー
            // 決算整理期限の取得ができない場合、エラーとする。
            // メッセージ：決算整理日付、PM3190E
            if (0 == getStrLength(kessanbi)) {
                addError(bizErrors, PNCommonMessageConstants.PM3190E, new String[]{"決算整理日付"});
                throwError(bizErrors);
            }
            // 決算整理日付の取得できた場合
            else {
                // 年度末日 >= 報告書作成日(システム日付) >= 決算整理日付 であること
                if (cnvStrToInteger(nendoMatsubi) >= cnvStrToInteger(toDay)
                        || cnvStrToInteger(toDay) >= cnvStrToInteger(kessanbi)) {
                    flgNotRiyuchiKin = true;
                }
            }
        }

        // ④入金日＞年度末日の場合 対象外とする
        // 留置金対象外フラグがFalseの場合
        // 入金日＞年度末日の場合、True⇒留置金対象外フラグ
        if (!flgNotRiyuchiKin) {
            if (cnvStrToInteger(checkDate_Nyukin.getSeireki()) > cnvStrToInteger(nendoMatsubi)) {
                flgNotRiyuchiKin = true;
            }
        }

        // ⑤年度末日＞送金日の場合 対象外とする
        // 留置金対象外フラグがFalseの場合
        // 年度末日＞＝送金日の場合、True⇒留置金対象外フラグ
        if (!flgNotRiyuchiKin) {
            if (cnvStrToInteger(nendoMatsubi) >= cnvStrToInteger(checkDate_Sokin.getSeireki())) {
                flgNotRiyuchiKin = true;
            }
        }

        // ⑥受託者勘定処理年月のチェック
        // 留置金対象外フラグがTrueの場合
        if (flgNotRiyuchiKin) {
            // 入金日以前エラー
            // 受託者処理勘定年月 ＜ 入金日（年月）の場合、エラーとする。
            // メッセージ：受託者勘定処理年月は入金日以降の日付、PM3140E
            checkDate_Jtkshori.addErrorDayUnderMonthDay(checkDate_Nyukin.getSeireki(),
                    PNCommonMessageConstants.PM3140E, new String[]{"受託者勘定処理年月は入金日以降の日付"});
            throwError(bizErrors);
        } else {
            // 留置金対象外フラグがFalseの場合
            //
            // 入金日以降エラー
            // 受託者処理勘定年月 ＞ 入金日(年月)の場合、エラーとする。
            // メッセージ：受託者勘定処理年月（留置金）が入金日、PM3260E
            checkDate_Jtkshori.addErrorDayOverMonthDay(checkDate_Nyukin.getSeireki(),
                    PNCommonMessageConstants.PM3260E, new String[]{"受託者勘定処理年月（留置金）が入金日"});
            throwError(bizErrors);
        }

        // 本店決算整理日とサーバで取得した処理日の比較チェック
        if (0 != kessanbi.length() && cnvStrToInteger(toDay) > cnvStrToInteger(kessanbi)) {
            // 本年度期初日を求める
            // 年度初日算出(共通部品)より、本年度期初日を取得する。
            String nendoHajime = PNCommonComponents.getNendoHajime(
                    pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(0, 4),
                    pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE).substring(4, 6))
                    .replace("/", "");
            //
            // 公庫決算終了エラー
            // 受託者処理勘定年月 ＜ 本年度期初日の場合、エラーとする。
            // メッセージ：PM3810E
            checkDate_Jtkshori.addErrorDayUnderMonthDay(nendoHajime, PNCommonMessageConstants.PM3810E,
                    new String[0]);
            throwError(bizErrors);
        }

        // メッセージ用ループインデックス初期化
        int loop_index = 1;
        // 一時変数払込元金合計初期化
        outDto.setTmpSumHaraikomiGankin(BigDecimal.ZERO);

        // 払込期日１～４、払込元金１～４のチェック（各項目の単体チェック）★本処理は、（９）修正データチェック処理⑧でも実施する。

        // 元金が空白以外の場合、元金⇒一時変数の元金
        // 元金が空白の場合、０⇒一時変数の元金
        tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());

        outDto.setID_Date_Haraikomi1_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi1_Gengo(),
                        outDto.getTxtID_Date_Haraikomi1_Nen(), outDto.getDrpID_Date_Haraikomi1_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi1_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin1(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 2;
        outDto.setID_Date_Haraikomi2_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi2_Gengo(),
                        outDto.getTxtID_Date_Haraikomi2_Nen(), outDto.getDrpID_Date_Haraikomi2_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi2_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin2(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 3;
        outDto.setID_Date_Haraikomi3_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi3_Gengo(),
                        outDto.getTxtID_Date_Haraikomi3_Nen(), outDto.getDrpID_Date_Haraikomi3_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi3_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin3(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        loop_index = 4;
        outDto.setID_Date_Haraikomi4_Input(loop_HaraikomiDateGankinCheck(
                new PNCheckDay(outDto.getDrpID_Date_Haraikomi4_Gengo(),
                        outDto.getTxtID_Date_Haraikomi4_Nen(), outDto.getDrpID_Date_Haraikomi4_Tsuki(),
                        outDto.getDrpID_Date_Haraikomi4_Bi(), pnCommonDBComponents, bizErrors),
                new PNCheckMoney(outDto.getTxtID_M_HaraikomiGankin4(), bizErrors), loop_index,
                checkDate_Nyukin, bizErrors, outDto));

        // 払込期日１～４、払込元金１～４のチェック（各項目の相関チェック）
        // 上記のチェックでエラーとならなかった場合
        String hantei_ShokanHouhou01 = getHantei_ShokanHouhou01(outDto);
        if ("3".equals(hantei_ShokanHouhou01)) {
            // 繰償事由コードの入力ありの場合
            if (0 != getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
                // 繰償事由コードの上1桁＝2以外 かつ繰償事由コードの上1桁＝4以外の場合
                if (!"2".equals(hantei_KurishojiyuStr01) && !"4".equals(hantei_KurishojiyuStr01)) {
                    if (0 < tmpAfterKurishoGankin.doubleValue()) {
                        // 払込期日①～④(修正)（入力値連結）が全て空文字の場合、エラーとする。
                        if (0 == PNCommonStringUtils.concatString(
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi1_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi2_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi3_Input()),
                                PNCommonComponents.cnvNulltoBlank(outDto.getID_Date_Haraikomi4_Input()))
                                .length()) {
                            // メッセージ：払込期日１～４、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"払込期日１～４"});
                            throwError(bizErrors);
                        }
                        // 払込期日重複エラー

                        // 払込期日１～４が重複した場合、エラーとする。
                        // ※払込期日①が空文字以外の場合、払込期日①と払込期日②～④のいずれかが一致している場合、エラー
                        // ※払込期日②が空文字以外の場合、払込期日②と払込期日①、③、④のいずれかが一致している場合、エラー
                        // ※払込期日③が空文字以外の場合、払込期日③と払込期日①、②、④のいずれかが一致している場合、エラー
                        // ※払込期日④が空文字以外の場合、払込期日④と払込期日①～③のいずれかが一致している場合、エラー

                        ArrayList<String> tmpStrList = new ArrayList<String>(4);
                        tmpStrList.add(outDto.getID_Date_Haraikomi1_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi2_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi3_Input());
                        tmpStrList.add(outDto.getID_Date_Haraikomi4_Input());
                        // メッセージ：払込期日１～４、PM3301E
                        if (overlapCheck(tmpStrList)) {
                            this.addError(bizErrors, PNCommonMessageConstants.PM3301E,
                                    new String[]{"払込期日１～４"});
                            throwError(bizErrors);
                        }

                        // 払込元金のチェック
                        // 払込元金１～４の合計を求め、
                        BigDecimal sum_GetTxtID_M_HaraikomiGankin1 = cnvStrToBig(
                                outDto.getTxtID_M_HaraikomiGankin1())
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin2()))
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin3()))
                                .add(cnvStrToBig(outDto.getTxtID_M_HaraikomiGankin4()));
                        // その合計値が繰償後残元金と等しくない場合、エラーとする。
                        if (sum_GetTxtID_M_HaraikomiGankin1.doubleValue() != cnvStrToBig(
                                outDto.getTxtID_M_ZanGankinAfterKurisho()).doubleValue()) {
                            // メッセージ：払込元金１～４の合計は繰上償還後の貸付金残高と同額、PM3140E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                    new String[]{"払込元金１～４の合計は繰上償還後の貸付金残高と同額"});
                            throwError(bizErrors);
                        }
                    }
                }
            }
        }
        // 繰償後元金均等額・繰償後元金不均等額・調整コードのチェック
        // 繰償事由コード入力なしの場合
        if (0 == getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
            // 繰償後元金均等額の入力ありの場合、エラーとする。
            if (0 != getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                // メッセージ：繰償後元金均等額、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金均等額"});
                throwError(bizErrors);
            }

            // 繰償後元金不均等額の入力ありの場合、エラーとする。
            if (0 != getStrLength(outDto.getTxtID_M_GankinFukintoAfterKurisho())) {
                // メッセージ：繰償後元金不均等額、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金不均等額"});
                throwError(bizErrors);
            }

            // 調整コード入力チェック
            // 調整コードの入力ありの場合、エラーとする。
            if (0 != getStrLength(outDto.getRdoID_Code_chosei())) {
                // メッセージ：調整コード、PM3130E
                this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                throwError(bizErrors);
            }

        }
        // 繰償事由コード入力ありの場合
        else {
            // 償還方法コードの上1桁＝1、3、9の場合
            if (Arrays.asList(new String[]{"1", "3", "9"}).contains(hantei_ShokanHouhou01)) {
                // 繰償後元金均等額の入力ありの場合、エラーとする。
                if (0 != getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                    // メッセージ：繰償後元金均等額、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金均等額"});
                    throwError(bizErrors);
                }

                // 繰償後元金不均等額の入力ありの場合、エラーとする。
                if (0 != getStrLength(outDto.getTxtID_M_GankinFukintoAfterKurisho())) {
                    // メッセージ：繰償後元金不均等額、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"繰償後元金不均等額"});
                    throwError(bizErrors);
                }
                // 調整コード入力チェック
                // 調整コードの入力ありの場合、エラーとする。
                if (0 != getStrLength(outDto.getRdoID_Code_chosei())) {
                    // メッセージ：調整コード、PM3130E
                    this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                    throwError(bizErrors);
                }
            }
            // 償還方法コードの上1桁＝2の場合
            if ("2".equals(hantei_ShokanHouhou01)) {
                // 元金が空白の場合、０⇒一時変数の元金
                // 元金が空白以外の場合、元金⇒一時変数の元金
                tmpGankin = cnvStrToBig(outDto.getTxtID_M_KurishoGankin());

                // 繰償事由コードの入力ありの場合
                if (0 != getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
                    // (繰償事由コードの上1桁＝1 または、繰償事由コードの上1桁＝5) かつ、一時変数の元金 ＞ 0の場合、以下を行う
                    if (("1".equals(hantei_KurishojiyuStr01) || "5".equals(hantei_KurishojiyuStr01))
                            && 0 < tmpGankin.doubleValue()) {

                        // 繰償後元金均等額の入力なしの場合、エラーとする。
                        if (0 == getStrLength(outDto.getTxtID_M_GankinKintoAfterKurisho())) {
                            // メッセージ：繰償後元金均等額、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"繰償後元金均等額"});
                            throwError(bizErrors);
                        }

                        // 繰償後元金不均等額の入力なしの場合、エラーとする。
                        if (0 == getStrLength(outDto.getTxtID_M_GankinFukintoAfterKurisho())) {
                            // メッセージ：繰償後元金不均等額、PM3120E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3120E,
                                    new String[]{"繰償後元金不均等額"});
                            throwError(bizErrors);
                        }

                        // 一時変数の貸付残高
                        BigDecimal tmpKashitukeZan = BigDecimal.ZERO;
                        // 繰償後元金均等額の入力チェック及び繰償後元金不均等額の入力チェックでエラーとならなかった場合
                        // 退避貸付残高が空白以外の場合、退避貸付残高⇒一時変数の貸付残高
                        // 退避貸付残高が空白の場合、貸付残高⇒一時変数の貸付残高
                        if (0 != getStrLength(outDto.getID_Keep_M_KashitsukeZan())) {
                            tmpKashitukeZan = cnvStrToBig(outDto.getID_Keep_M_KashitsukeZan());
                        } else {
                            tmpKashitukeZan = cnvStrToBig(outDto.getID_M_KashitsukeZandaka_aRingi());
                        }

                        BigDecimal tmpGankinFukintou = BigDecimal.ZERO;
                        // 退避元金不均等額が空白以外の場合、退避元金不均等額⇒一時変数の元金不均等額
                        if (0 != getStrLength(outDto.getID_Keep_M_GankinFukinto())) {
                            tmpGankinFukintou = cnvStrToBig(outDto.getID_Keep_M_GankinFukinto());
                        }
                        // 退避元金不均等額が空白の場合、元金不均等額⇒一時変数の元金不均等額
                        else {
                            tmpGankinFukintou = cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho());
                        }
                        BigDecimal tmpFukin = BigDecimal.ZERO;
                        // 退避賦金が空白以外の場合、退避賦金⇒一時変数の賦金
                        if (0 != getStrLength(outDto.getID_Keep_M_Fukin())) {
                            tmpFukin = cnvStrToBig(outDto.getID_Keep_M_Fukin());
                        }
                        // 退避賦金が空白の場合、賦金⇒一時変数の賦金
                        else {
                            tmpFukin = cnvStrToBig(outDto.getID_M_Fukin_aRingi());
                        }

                        // 償還回数＝０
                        BigDecimal countShiyoukan = BigDecimal.ZERO;

                        // 退避元金不均等区分＝１の場合
                        if ("1".equals(PNCommonComponents.cnvNulltoBlank(outDto
                                .getID_Keep_Kubun_GankinFukinto()))) {

                            // 約定データ存在チェック
                            // サービスを実行し、約定データの存在チェックをする。
                            // 約定データ検索パラメータ(債権管理番号）＝債権管理番号
                            outDto.setYakujoParam_ID_Credit(outDto.getID_ID_Credit());

                            // 約定データ検索パラメータ(払込期日)＝償還後第1回払込期日(修正)（入力値連結）※一致する約定データを検索
                            outDto.setYakujoParam_Date_Haraikomi(outDto
                                    .getDate_FirstHaraikomiAfterKuris_Input());

                            // Md004_01Service.getYakujo
                            outDto = md004_01service.getYakujo(outDto);

                            // 取得件数が１件の場合、以下を行う
                            if (1 == outDto.getYakujoAns_Count()) {
                                // 一時変数の元金不均等額＝約定データ検索結果(約定元金）又は、約定データ検索結果(約定元金）＝０の場合、以下を行う
                                if (tmpGankinFukintou.doubleValue() == cnvStrToBig(
                                        outDto.getYakujoAns_ID_M_YakujoGankin()).doubleValue()
                                        || 0 == cnvStrToBig(outDto.getYakujoAns_ID_M_YakujoGankin())
                                                .doubleValue()) {
                                    countShiyoukan = tmpKashitukeZan.subtract(tmpGankinFukintou).divide(
                                            tmpFukin, 0, BigDecimal.ROUND_DOWN);
                                    countShiyoukan = countShiyoukan.add(BigDecimal.ONE);
                                }
                                // 上記以外の場合、以下を行う
                                else {
                                    countShiyoukan = tmpKashitukeZan.divide(tmpFukin, 0,
                                            BigDecimal.ROUND_DOWN);
                                }
                            }
                        }
                        // 退避元金不均等区分＝１以外の場合、以下を行う
                        else {
                            // 償還回数＝(一時変数の貸付残高－一時変数の元金不均等額)／一時変数の賦金　　　　※除算は端数切捨て
                            countShiyoukan = tmpKashitukeZan.subtract(tmpGankinFukintou).divide(tmpFukin, 0,
                                    BigDecimal.ROUND_DOWN);
                            if (0 < tmpGankinFukintou.doubleValue()) {
                                countShiyoukan = countShiyoukan.add(BigDecimal.ONE);
                            }
                        }

                        BigDecimal keisanKashitukezan = BigDecimal.ZERO;
                        if (0 < cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho()).doubleValue()) {
                            // 計算した貸付残高＝繰償後元金均等額×(償還回数－１)＋元金＋繰償後元金不均等額
                            keisanKashitukezan = cnvStrToBig(outDto.getTxtID_M_GankinKintoAfterKurisho())
                                    .multiply(countShiyoukan.subtract(BigDecimal.ONE)).add(
                                            cnvStrToBig(outDto.getTxtID_M_KurishoGankin())
                                                    .add(cnvStrToBig(outDto
                                                            .getTxtID_M_GankinFukintoAfterKurisho())));
                        }
                        // 0の場合
                        else if (0 == cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho())
                                .doubleValue()) {
                            // 計算した貸付残高＝繰償後元金均等額×償還回数＋元金
                            keisanKashitukezan = cnvStrToBig(outDto.getTxtID_M_GankinKintoAfterKurisho())
                                    .multiply(countShiyoukan).add(
                                            cnvStrToBig(outDto.getTxtID_M_KurishoGankin()));
                        }

                        if (keisanKashitukezan.doubleValue() != tmpKashitukeZan.doubleValue()) {
                            // メッセージ：繰償後元金均等額、繰償後元金不均等額の、PM3870E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3870E,
                                    new String[]{"繰償後元金均等額、繰償後元金不均等額の"});
                            throwError(bizErrors);
                        }

                        // 調整コードのチェック
                        // 繰償後元金不均等額の入力ありの場合
                        // 繰償後元金不均等額＝0の場合
                        if (0 == cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho()).doubleValue()) {
                            // 調整コードの入力ありの場合、エラーとする。
                            if (0 != getStrLength(outDto.getRdoID_Code_chosei())) {
                                // メッセージ：調整コードは「なし」、PM3140E
                                this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                        new String[]{"調整コードは「なし」"});
                                throwError(bizErrors);
                            }
                        }

                        else {
                            // 調整コードの入力なしの場合、エラーとする。
                            if (0 == getStrLength(outDto.getRdoID_Code_chosei())) {
                                // メッセージ：調整コードは「初回」または「最終回」、PM3140E
                                this.addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                        new String[]{"調整コードは「初回」または「最終回」"});
                                throwError(bizErrors);
                            }
                        }
                    }
                    // 上記以外の場合、以下を行う
                    else {
                        // 繰償後元金均等額の入力ありの場合、エラーとする。
                        if (0 < cnvStrToBig(outDto.getTxtID_M_GankinKintoAfterKurisho()).doubleValue()) {
                            // メッセージ：繰償後元金均等額、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E,
                                    new String[]{"繰償後元金均等額"});
                            throwError(bizErrors);
                        }

                        // 繰償後元金不均等額の入力ありの場合、エラーとする。
                        if (0 < cnvStrToBig(outDto.getTxtID_M_GankinFukintoAfterKurisho()).doubleValue()) {
                            // メッセージ：繰償後元金不均等額、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E,
                                    new String[]{"繰償後元金不均等額"});
                            throwError(bizErrors);
                        }
                        // 調整コード入力チェック
                        // 調整コードの入力ありの場合、エラーとする。
                        if (0 != getStrLength(outDto.getRdoID_Code_chosei())) {
                            // メッセージ：調整コード、PM3130E
                            this.addError(bizErrors, PNCommonMessageConstants.PM3130E, new String[]{"調整コード"});
                            throwError(bizErrors);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * <pre>
     *      払込期日１～４、払込元金１～４のチェック（各項目の単体チェック）　　　★本処理は、（９）修正データチェック処理⑧でも実施する。
     * </pre>
     *
     * @param haraikomi
     * @param haraikomiGankin
     * @param renketuSeirekiDto 成功した場合の入力連結値 outDtoの連結値を参照設定する。
     */

    private String loop_HaraikomiDateGankinCheck(PNCheckDay check_Haraikomi, PNCheckMoney haraikomi_Gankin,
            int loop_index, PNCheckDay checkDate_Nyukin, List<PNMessageInfo> bizErrors, Md004_01DTO outDto) {
        String renketu_SeirekiDto = "";
        // 共通処理の西暦変換にて払込期日ｎを西暦変換しDTOに保持する。(払込期日ｎ(修正)（入力値連結）)
        renketu_SeirekiDto = check_Haraikomi.getSeireki();
        // チェックする貸付残高を抽出
        // 報告書履歴でーたの退避貸付残高が空文字以外の時退避貸付残高とする。
        // 空文字の場合、稟議データの貸付残高とする。
        String checkM_KashitsukeZan = "";
        if (0 != getStrLength(outDto.getID_Keep_M_KashitsukeZan())) {
            // '退避貸付残高が空白以外の場合、退避貸付残高⇒一時変数の貸付残高
            checkM_KashitsukeZan = outDto.getID_Keep_M_KashitsukeZan();
        } else {
            // 退避貸付残高が空白の場合、貸付残高⇒一時変数の貸付残高
            checkM_KashitsukeZan = outDto.getID_M_KashitsukeZandaka_aRingi();
        }
        String hantei_ShokanHouhou01 = getHantei_ShokanHouhou01(outDto);
        // 償還方法の上１桁＝3 かつ、貸付残高＝元金以外の場合
        if ("3".equals(hantei_ShokanHouhou01)
                && cnvStrToBig(checkM_KashitsukeZan).doubleValue() != cnvStrToBig(
                        outDto.getTxtID_M_KurishoGankin()).doubleValue()) {
            // 繰償事由コードの入力ありの場合
            if (0 != getStrLength(outDto.getDrpID_Code_Kurishojiyu())) {
                // 繰償事由コードの上1桁＝2以外 かつ繰償事由コードの上1桁＝4以外の場合
                String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(outDto);
                if (!"2".equals(hantei_KurishojiyuStr01) && !"4".equals(hantei_KurishojiyuStr01)) {

// [ADD] Ver 2.0.0 - START
                    if (0 != check_Haraikomi.getSeireki().length()) {
                        check_Haraikomi.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
                                new String[]{MessageFormat.format("払込期日（{0}）", String.valueOf(loop_index))});
                        throwError(bizErrors);
                    }
// [ADD] Ver 2.0.0 - END

                    // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は有効日付"、PM3140E
                    check_Haraikomi.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
                            new String[]{MessageFormat.format("払込期日（{0}）は有効日付", String.valueOf(loop_index))});
                    throwError(bizErrors);

                    // 払込期日ｎ年号指定エラー
                    // 払込期日ｎ（年）（月）にS64と入力した場合、エラーとする。
                    check_Haraikomi.addErrorS64(PNCommonMessageConstants.PM3291E,
                            new String[]{MessageFormat.format("払込期日（{0}）に", String.valueOf(loop_index))});
                    throwError(bizErrors);

                    // 払込期日ｎ ＜＝ 入金日の場合、エラーとする。
                    // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は入金日後"、PM3140E
                    check_Haraikomi.addErrorDayUnderDay(checkDate_Nyukin.getSeireki(),
                            PNCommonMessageConstants.PM3140E,
                            new String[]{MessageFormat.format("払込期日（{0}）は入金日後", String.valueOf(loop_index))});
                    throwError(bizErrors);
                    check_Haraikomi.addErrorDayEqualsDay(checkDate_Nyukin.getSeireki(),
                            PNCommonMessageConstants.PM3140E,
                            new String[]{MessageFormat.format("払込期日（{0}）は入金日後", String.valueOf(loop_index))});
                    throwError(bizErrors);

                    // 払込期日ｎ償還期限年月以降エラー
                    // 償還期限年月 ＜ 払込期日ｎの年月の場合、エラーとする。
                    // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は償還期限年月以前"、PM3140E
                    if (0 != getStrLength(check_Haraikomi.getSeireki())) {
                        check_Haraikomi.addErrorDayOverMonthDay(
                                PNCommonComponents.cnvNulltoBlank(PNCommonComponents.concatString(
                                        outDto.getID_Date_ShokanKigen_aRingi(), "01")),
                                PNCommonMessageConstants.PM3140E,
                                new String[]{MessageFormat.format("払込期日（{0}）は償還期限年月以前",
                                        String.valueOf(loop_index))});
                        throwError(bizErrors);
                    }

                    // 上記のチェックでエラーとならなかった場合
                    // 償還方法コードの下１桁による判定
                    String hantei_ShokanHouhou02 = getHantei_ShokanHouhou02(outDto);
                    // 払込期日ｎ(修正)（入力値連結）が空文字以外の場合かつ償還方法コードの下１桁＝1の場合
                    if (0 != getStrLength(check_Haraikomi.getSeireki()) && "1".equals(hantei_ShokanHouhou02)) {
                        if (!outDto.getID_Date_GanrikinHaraiKomi_aRingi().equals(
                                new StringBuffer(check_Haraikomi.getSeireki()).substring(4))) {
                            // 元利金払込日＝払込期日ｎ(月日)以外の場合、エラーとする。
                            // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は元利金払込日"、PM3140E
                            addError(
                                    bizErrors,
                                    PNCommonMessageConstants.PM3140E,
                                    new String[]{MessageFormat.format("払込期日（{0}）は元利金払込日",
                                            String.valueOf(loop_index))});
                            throwError(bizErrors);
                        }
                    }

                    // 元利金払込日＝払込期日ｎ(月日)以外
                    // かつ、元利金払込日の６ヶ月後（月日）＝払込期日ｎ(月日)以外の場合、エラーとする。
                    // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は元利金払込日または、元利金払込日６ヶ月後"、PM3140E

                    // 払込期日ｎ(修正)（入力値連結）が空文字以外の場合かつ償還方法コードの下１桁＝2の場合
                    if (0 != getStrLength(check_Haraikomi.getSeireki()) && "2".equals(hantei_ShokanHouhou02)) {
                        // 元利金払込日の６ヵ月後をもとめる　(業務日付の年＋元利金払込日を連結し６か月後の年月日を求める）
                        String tmp6ago = this.getDayMonthAgo(PNCommonStringUtils.concatString(
                                new StringBuffer(pnCommonDBComponents.getPNBusinessDay(1)).substring(0, 4),
                                outDto.getID_Date_GanrikinHaraiKomi_aRingi()), 6);

                        // 元利金払込日＝払込期日ｎ(月日)以外
                        // かつ、元利金払込日の６ヶ月後（月日）＝払込期日ｎ(月日)以外の場合、エラーとする。
                        if (!outDto.getID_Date_GanrikinHaraiKomi_aRingi().equals(
                                new StringBuffer(check_Haraikomi.getSeireki()).substring(4))
                                && !new StringBuffer(tmp6ago).substring(4).equals(
                                        new StringBuffer(check_Haraikomi.getSeireki()).substring(4))) {

                            // メッセージ："払込期日（" & 払込期日番号（1～4） & "）は元利金払込日または、元利金払込日６ヶ月後"、PM3140E
                            addError(bizErrors, PNCommonMessageConstants.PM3140E,
                                    new String[]{MessageFormat.format("払込期日（{0}）は元利金払込日または、元利金払込日６ヶ月後",
                                            String.valueOf(loop_index))});
                            throwError(bizErrors);
                        }
                    }

                    // 払込期日ｎ(修正)（入力値連結）が空文字以外の場合、以下を行う
                    if (0 != getStrLength(check_Haraikomi.getSeireki())) {
                        // 払込元金ｎの入力なし または、0の場合、エラーとする。
                        // メッセージ："払込元金（" & 払込元金番号（1～4） & "）"、PM3210E
                        haraikomi_Gankin.addErrorMonneyRequiredMoney(PNCommonMessageConstants.PM3210E,
                                new String[]{MessageFormat.format("払込元金（{0}）", String.valueOf(loop_index))});
                        throwError(bizErrors);
                        haraikomi_Gankin.addErrorMonneyEqualsMonney("0", PNCommonMessageConstants.PM3210E,
                                new String[]{MessageFormat.format("払込元金（{0}）", String.valueOf(loop_index))});
                        throwError(bizErrors);

                        // 一時変数の払込元金合計＝一時変数の払込元金合計＋払込元金ｎ
                        outDto.setTmpSumHaraikomiGankin(outDto.getTmpSumHaraikomiGankin().add(
                                haraikomi_Gankin.getMoneyBig()));

                        // 上記以外の場合、以下を行う
                    } else {
                        // 払込元金ｎの入力あり、かつ０以外の場合
                        if (0 != BigDecimal.ZERO.compareTo(haraikomi_Gankin.getMoneyBig())) {
                            // 払込元金(n)までの足し込みをする。
                            outDto.setTmpSumHaraikomiGankin(outDto.getTmpSumHaraikomiGankin().add(
                                    haraikomi_Gankin.getMoneyBig()));
                            // 繰償後残元金＞＝一時変数の払込元金合計の場合、エラーとする。
                            // メッセージ："払込期日（" & 払込期日番号（1～4） & "）"、PM3120E
                            // 上記以外の場合、エラーとする
                            // メッセージ："払込元金（" & 払込元金番号（1～4） & "）"、PM3130E
                            if (this.cnvStrToBig(outDto.getTxtID_M_ZanGankinAfterKurisho()).doubleValue() >= outDto
                                    .getTmpSumHaraikomiGankin().doubleValue()) {
                                addError(
                                        bizErrors,
                                        PNCommonMessageConstants.PM3120E,
                                        new String[]{MessageFormat.format("払込期日（{0}）",
                                                String.valueOf(loop_index))});
                                throwError(bizErrors);
                            } else {
                                addError(
                                        bizErrors,
                                        PNCommonMessageConstants.PM3130E,
                                        new String[]{MessageFormat.format("払込元金（{0}）",
                                                String.valueOf(loop_index))});
                                throwError(bizErrors);
                            }
                        }
                    }
                }
                // 上記以外の場合、以下を行う(繰償事由コードの上1桁＝2又は4の場合）
                if ("2".equals(hantei_KurishojiyuStr01) || "4".equals(hantei_KurishojiyuStr01)) {

                    // 上記以外の場合、以下を行う(繰償事由コードの上1桁＝2又は4の場合）
                    // 払込期日のチェック
                    // 払込期日ｎ（年）（月）（日）のいずれかに入力ありの場合、エラーとする。
                    // メッセージ："払込期日（" & 払込期日番号（1～4） & "）"、PM3130E

                    check_Haraikomi.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E,
                            new String[]{MessageFormat.format("払込期日（{0}）", String.valueOf(loop_index))});
                    throwError(bizErrors);

                    // 払込元金のチェック
                    // 払込元金ｎの入力ありの場合、エラーとする。
                    // メッセージ："払込元金（" & 払込元金番号（1～4） & "）"、PM3130E
                    haraikomi_Gankin.addErrorMonneyNotRequiredMoney(PNCommonMessageConstants.PM3130E,
                            new String[]{MessageFormat.format("払込元金（{0}））", String.valueOf(loop_index))});
                    throwError(bizErrors);
                }
            } else {
                // 繰償事由コードの入力なしの場合
                // 払込期日のチェック
                // 払込期日ｎ（年）（月）（日）のいずれかに入力ありの場合、エラーとする。
                // メッセージ："払込期日（" & 払込期日番号（1～4） & "）"、PM3130E
                check_Haraikomi.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E,
                        new String[]{MessageFormat.format("払込期日（{0}）", String.valueOf(loop_index))});
                throwError(bizErrors);

                // 払込元金のチェック
                // 払込元金ｎの入力ありの場合、エラーとする。
                // メッセージ："払込元金（" & 払込元金番号（1～4） & "）"、PM3130E
                haraikomi_Gankin.addErrorMonneyNotRequiredMoney(PNCommonMessageConstants.PM3130E,
                        new String[]{MessageFormat.format("払込元金（{0}）", String.valueOf(loop_index))});
                throwError(bizErrors);
            }
        }
        if (!"3".equals(hantei_ShokanHouhou01)) {
            // 償還方法の上１桁＝3以外の場合
            // 払込期日のチェック
            // 払込期日ｎ（年）（月）（日）のいずれかに入力ありの場合、エラーとする。
            // メッセージ："払込期日（" & 払込期日番号（1～4） & "）"、PM3130E
            check_Haraikomi.addErrorDayNotRequiredDay(PNCommonMessageConstants.PM3130E,
                    new String[]{MessageFormat.format("払込期日（{0}）", String.valueOf(loop_index))});
            throwError(bizErrors);

            // 払込元金のチェック
            // 払込元金ｎの入力ありの場合、エラーとする。
            // メッセージ："払込元金（" & 払込元金番号（1～4） & "）"、PM3130E
            haraikomi_Gankin.addErrorMonneyNotRequiredMoney(PNCommonMessageConstants.PM3130E,
                    new String[]{MessageFormat.format("払込元金（{0}）", String.valueOf(loop_index))});
            throwError(bizErrors);
        }
        return renketu_SeirekiDto;
    }

    /**
     *
     * <pre>
     * 重複チェック
     * </pre>
     *
     * @param checkList
     * @return
     */
    public Boolean overlapCheck(List<String> checkList) {
        Boolean result = false;
        Set<String> checkHash = new HashSet<String>();
        for (String str : checkList) {
            if (null != str && 0 != getStrLength(str)) {
                if (checkHash.contains(str)) {
                    // 重複があればtrueをセットし終了
                    result = true;
                    break;
                } else {
                    // 重複しなければハッシュセットへ追加
                    checkHash.add(str);
                }
            }
        }
        return result;
    }

    /**
     *
     * <pre>
     * 画面別エラーの追記
     * </pre>
     *
     * @param messageId
     * @param parameter
     */
    private void addError(List<PNMessageInfo> bizErrors, String messageId, String[] parameter) {
        bizErrors.add(new PNMessageInfo(messageId, parameter, false));
    }

    /**
     *
     * <pre>
     * エラーを投げる
     * </pre>
     */
    private void throwError(List<PNMessageInfo> bizErrors) {
        // エラー判定
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }
    }

    /**
     *
     * <pre>
     * チェック用オブジェクト作成
     * </pre>
     *
     */
    private void checkObjCreate() {

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param reportId 報告書番号
     */
    private void setRequestNextScreen(HttpServletRequest request, Md004_01DTO outDto) {

        // 次画面への遷移パラメータを設定
        addForwardParameter(request, Md004Constants.ID_TYPE_PROCESS_H, outDto.getID_Type_Process_H());
        addForwardParameter(request, Md004Constants.ID_STATUS_H, outDto.getID_Status_H());
        addForwardParameter(request, Md004Constants.ID_ID_REPORT_H, outDto.getID_ID_Report_H());
        addForwardParameter(request, Md004Constants.ID_TIME_REPORT_H, outDto.getID_Time_Report_H());
        addForwardParameter(request, Md004Constants.ID_DATACODE_H, outDto.getID_DataCode_H());

        // 顧客名
        addForwardParameter(request, Md004Constants.TXTID_NAME_CUSTOMER, outDto.getTxtID_Name_Customer());
        addForwardParameter(request, Md004Constants.TXTID_NAME_CUSTOMER_RED,
                outDto.getTxtID_Name_Customer_Red());
        // 扱店名
        addForwardParameter(request, Md004Constants.TXTID_NAME_ORGANIZATION,
                outDto.getTxtID_Name_Organization());
        addForwardParameter(request, Md004Constants.TXTID_NAME_ORGANIZATION_RED,
                outDto.getTxtID_Name_Organization_Red());

        // 公庫支店
        addForwardParameter(request, Md004Constants.TXTID_CODE_KOUKOSHITEN,
                outDto.getTxtID_Code_KoukoShiten());
        addForwardParameter(request, Md004Constants.TXTID_CODE_KOUKOSHITEN_RED,
                outDto.getTxtID_Code_KoukoShiten_Red());

        // 扱店
        addForwardParameter(request, Md004Constants.TXTID_CODE_ORGANIZATION,
                outDto.getTxtID_Code_Organization());
        addForwardParameter(request, Md004Constants.TXTID_CODE_ORGANIZATION_RED,
                outDto.getTxtID_Code_Organization_Red());

        // 店舗
        addForwardParameter(request, Md004Constants.TXTID_CODE_TENPO, outDto.getTxtID_Code_Tenpo());
        addForwardParameter(request, Md004Constants.TXTID_CODE_TENPO_RED, outDto.getTxtID_Code_Tenpo_Red());
        // 年度
        addForwardParameter(request, Md004Constants.TXTID_YEAR, outDto.getTxtID_Year());
        addForwardParameter(request, Md004Constants.TXTID_YEAR_RED, outDto.getTxtID_Year_Red());
        // 方式資金
        addForwardParameter(request, Md004Constants.TXTID_CODE_HOSHIKISHIKIN,
                outDto.getTxtID_Code_HoshikiShikin());
        addForwardParameter(request, Md004Constants.TXTID_CODE_HOSHIKISHIKIN_RED,
                outDto.getTxtID_Code_HoshikiShikin_Red());

        // 番号
        addForwardParameter(request, Md004Constants.TXTID_ID_RINGI, outDto.getTxtID_ID_Ringi());
        addForwardParameter(request, Md004Constants.TXTID_ID_RINGI_RED, outDto.getTxtID_ID_Ringi_Red());
        // 枝番
        addForwardParameter(request, Md004Constants.TXTID_ID_RINGIBRANCH, outDto.getTxtID_ID_RingiBranch());
        addForwardParameter(request, Md004Constants.TXTID_ID_RINGIBRANCH_RED,
                outDto.getTxtID_ID_RingiBranch_Red());
        // 繰償還後第1回払込期日
        addForwardParameter(request, Md004Constants.ID_DATE_FIRSTHARAIKOMIAFTERKURISHO_INPUT,
                outDto.getDate_FirstHaraikomiAfterKuris_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_FIRSTHARAIKOMIAFTERKURISHO_GENGO,
                outDto.getDrpDate_FirstHaraikomiAfterKuris_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_FIRSTHARAIKOMIAFTERKURISHO_NEN,
                outDto.getTxtDate_FirstHaraikomiAfterKuris_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_FIRSTHARAIKOMIAFTERKURISHO_TSUKI,
                outDto.getDrpDate_FirstHaraikomiAfterKuris_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_FIRSTHARAIKOMIAFTERKURISHO_BI,
                outDto.getDrpDate_FirstHaraikomiAfterKuris_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_FIRSTHARAIKOMIAFTERKURISHO_RED,
                outDto.getTxtDate_FirstHaraikomiAfterKuris_Red());

        // 入金日
        addForwardParameter(request, Md004Constants.ID_DATE_NYUKIN_INPUT, outDto.getID_Date_Nyukin_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_NYUKIN_GENGO,
                outDto.getDrpID_Date_Nyukin_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_NYUKIN_NEN, outDto.getTxtID_Date_Nyukin_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_NYUKIN_TSUKI,
                outDto.getDrpID_Date_Nyukin_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_NYUKIN_BI, outDto.getDrpID_Date_Nyukin_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_NYUKIN_RED, outDto.getTxtID_Date_Nyukin_Red());
        // 繰償還事由コード
        addForwardParameter(request, Md004Constants.DRPID_CODE_KURISHOJIYU,
                outDto.getDrpID_Code_Kurishojiyu());
        addForwardParameter(request, Md004Constants.TXTID_CODE_KURISHOJIYU_RED,
                outDto.getTxtID_Code_Kurishojiyu_Red());

        // 利息
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHORISOKU, outDto.getTxtID_M_KurishoRisoku());
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHORISOKU_RED,
                outDto.getTxtID_M_KurishoRisoku_Red());
        // 元金
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHOGANKIN, outDto.getTxtID_M_KurishoGankin());
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHOGANKIN_RED,
                outDto.getTxtID_M_KurishoGankin_Red());
        // 控除利息
        addForwardParameter(request, Md004Constants.TXTID_M_KOJORISOKU, outDto.getTxtID_M_KojoRisoku());
        addForwardParameter(request, Md004Constants.TXTID_M_KOJORISOKU_RED,
                outDto.getTxtID_M_KojoRisoku_Red());
        // 繰上償還手数料
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHOCOMMISSION,
                outDto.getTxtID_M_KurishoCommission());
        addForwardParameter(request, Md004Constants.TXTID_M_KURISHOCOMMISSION_RED,
                outDto.getTxtID_M_KurishoCommission_Red());

        // 仮受金からの充当額
        addForwardParameter(request, Md004Constants.TXTID_M_KARIUKEIPPANJUTO,
                outDto.getTxtID_M_KariukeIppanJuto());
        addForwardParameter(request, Md004Constants.TXTID_M_KARIUKEIPPANJUTO_RED,
                outDto.getTxtID_M_KariukeIppanJuto_Red());

        // 送金額
        addForwardParameter(request, Md004Constants.TXTID_M_SOKIN, outDto.getTxtID_M_Sokin());
        addForwardParameter(request, Md004Constants.TXTID_M_SOKIN_RED, outDto.getTxtID_M_Sokin_Red());
        // 繰償後残元金
        addForwardParameter(request, Md004Constants.TXTID_M_ZANGANKINAFTERKURISHO,
                outDto.getTxtID_M_ZanGankinAfterKurisho());
        addForwardParameter(request, Md004Constants.TXTID_M_ZANGANKINAFTERKURISHO_RED,
                outDto.getTxtID_M_ZanGankinAfterKurisho_Red());

        // 送金日
        addForwardParameter(request, Md004Constants.ID_DATE_SOKIN_INPUT, outDto.getID_Date_Sokin_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_SOKIN_GENGO,
                outDto.getDrpID_Date_Sokin_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_SOKIN_NEN, outDto.getTxtID_Date_Sokin_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_SOKIN_TSUKI,
                outDto.getDrpID_Date_Sokin_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_SOKIN_BI, outDto.getDrpID_Date_Sokin_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_SOKIN_RED, outDto.getTxtID_Date_Sokin_Red());
        // 送金日番号
        addForwardParameter(request, Md004Constants.TXTID_ID_SOKINBI, outDto.getTxtID_ID_Sokinbi());
        addForwardParameter(request, Md004Constants.TXTID_ID_SOKINBI_RED, outDto.getTxtID_ID_Sokinbi_Red());
        // 代弁履行後の作成
        addForwardParameter(request, Md004Constants.CHKID_ID_AFTER_DAIIBENSAI,
                outDto.getChkID_ID_After_Daiibensai());
        addForwardParameter(request, Md004Constants.CHKID_ID_AFTER_DAIIBENSAI_RED,
                outDto.getChkID_ID_After_Daiibensai_Red());

        // 払込期日1～４
        addForwardParameter(request, Md004Constants.ID_DATE_HARAIKOMI1_INPUT,
                outDto.getID_Date_Haraikomi1_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI1_GENGO,
                outDto.getDrpID_Date_Haraikomi1_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI1_NEN,
                outDto.getTxtID_Date_Haraikomi1_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI1_TSUKI,
                outDto.getDrpID_Date_Haraikomi1_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI1_BI,
                outDto.getDrpID_Date_Haraikomi1_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI1_RED,
                outDto.getTxtID_Date_Haraikomi1_Red());

        addForwardParameter(request, Md004Constants.ID_DATE_HARAIKOMI2_INPUT,
                outDto.getID_Date_Haraikomi2_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI2_GENGO,
                outDto.getDrpID_Date_Haraikomi2_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI2_NEN,
                outDto.getTxtID_Date_Haraikomi2_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI2_TSUKI,
                outDto.getDrpID_Date_Haraikomi2_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI2_BI,
                outDto.getDrpID_Date_Haraikomi2_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI2_RED,
                outDto.getTxtID_Date_Haraikomi2_Red());

        addForwardParameter(request, Md004Constants.ID_DATE_HARAIKOMI3_INPUT,
                outDto.getID_Date_Haraikomi3_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI3_GENGO,
                outDto.getDrpID_Date_Haraikomi3_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI3_NEN,
                outDto.getTxtID_Date_Haraikomi3_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI3_TSUKI,
                outDto.getDrpID_Date_Haraikomi3_Tsuki());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI3_BI,
                outDto.getDrpID_Date_Haraikomi3_Bi());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI3_RED,
                outDto.getTxtID_Date_Haraikomi3_Red());

        addForwardParameter(request, Md004Constants.ID_DATE_HARAIKOMI4_INPUT,
                outDto.getID_Date_Haraikomi4_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI4_BI,
                outDto.getDrpID_Date_Haraikomi4_Bi());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI4_GENGO,
                outDto.getDrpID_Date_Haraikomi4_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI4_NEN,
                outDto.getTxtID_Date_Haraikomi4_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_HARAIKOMI4_TSUKI,
                outDto.getDrpID_Date_Haraikomi4_Tsuki());
        addForwardParameter(request, Md004Constants.TXTID_DATE_HARAIKOMI4_RED,
                outDto.getTxtID_Date_Haraikomi4_Red());
        // 払込元金1～4
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN1,
                outDto.getTxtID_M_HaraikomiGankin1());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN1_RED,
                outDto.getTxtID_M_HaraikomiGankin1_Red());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN2,
                outDto.getTxtID_M_HaraikomiGankin2());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN2_RED,
                outDto.getTxtID_M_HaraikomiGankin2_Red());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN3,
                outDto.getTxtID_M_HaraikomiGankin3());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN3_RED,
                outDto.getTxtID_M_HaraikomiGankin3_Red());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN4,
                outDto.getTxtID_M_HaraikomiGankin4());
        addForwardParameter(request, Md004Constants.TXTID_M_HARAIKOMIGANKIN4_RED,
                outDto.getTxtID_M_HaraikomiGankin4_Red());

        // 繰償後元金均等額
        addForwardParameter(request, Md004Constants.TXTID_M_GANKINKINTOAFTERKURISHO,
                outDto.getTxtID_M_GankinKintoAfterKurisho());

        addForwardParameter(request, Md004Constants.TXTID_M_GANKINKINTOAFTERKURISHO_RED,
                outDto.getTxtID_M_GankinKintoAfterKurisho_Red());

        // 繰償後元金不均等額
        addForwardParameter(request, Md004Constants.TXTID_M_GANKINFUKINTOAFTERKURISHO,
                outDto.getTxtID_M_GankinFukintoAfterKurisho());

        addForwardParameter(request, Md004Constants.TXTID_M_GANKINFUKINTOAFTERKURISHO_RED,
                outDto.getTxtID_M_GankinFukintoAfterKurisho_Red());

        // 受託者処理年月
        addForwardParameter(request, Md004Constants.ID_DATE_JTKSHORI_INPUT,
                outDto.getID_Date_Jtkshori_Input());
        addForwardParameter(request, Md004Constants.DRPID_DATE_JTKSHORI_GENGO,
                outDto.getDrpID_Date_Jtkshori_Gengo());
        addForwardParameter(request, Md004Constants.TXTID_DATE_JTKSHORI_NEN,
                outDto.getTxtID_Date_Jtkshori_Nen());
        addForwardParameter(request, Md004Constants.DRPID_DATE_JTKSHORI_TSUKI,
                outDto.getDrpID_Date_Jtkshori_Tsuki());
        addForwardParameter(request, Md004Constants.ID_DATE_JTKSHORI_RED_INPUT,
                outDto.getID_Date_Jtkshori_Red_Input());
        addForwardParameter(request, Md004Constants.ID_DATE_JTKSHORI_GENGO_RED,
                outDto.getDrpID_Date_Jtkshori_Gengo_Red());
        addForwardParameter(request, Md004Constants.ID_DATE_JTKSHORI_NEN_RED,
                outDto.getTxtID_Date_Jtkshori_Nen_Red());
        addForwardParameter(request, Md004Constants.DRPID_DATE_JTKSHORITSUKI_RED,
                outDto.getDrpID_Date_Jtkshori_Tsuki_Red());

        // 調整コード
        addForwardParameter(request, Md004Constants.RDOID_CODE_CHOSEI, outDto.getRdoID_Code_chosei());
        addForwardParameter(request, Md004Constants.RDOID_CODE_CHOSEI_RED, outDto.getRdoID_Code_chosei_Red());

        // 受託者処理年月上部プレビュー部分
        addForwardParameter(request, Md004Constants.TXTID_DATE_JTKSHORI, outDto.getTxtID_Date_Jtkshori());
        addForwardParameter(request, Md004Constants.TXTID_DATE_JTKSHORI_RED,
                outDto.getTxtID_Date_JtkShori_Red());
        addForwardParameter(request, Md004Constants.ID_CODE_ERROR, outDto.getID_Code_Error());
        addForwardParameter(request, Md004Constants.ID_CODE_ERROR_RED, outDto.getID_Code_Error_Red());

        // 償還方法
        addForwardParameter(request, Md004Constants.ID_CODE_SHOKANHOUHOU, outDto.getID_Code_ShokanHouhou());
        addForwardParameter(request, Md004Constants.ID_CODE_SHOKANHOUHOU_RED,
                outDto.getID_Code_ShokanHouhou_Red());
        addForwardParameter(request, Md004Constants.ID_DATA_LASTUPDATE, outDto.getID_Data_LastUpDate());
        addForwardParameter(request, Md004Constants.ID_DATA_LASTUPDATE_RED,
                outDto.getID_Data_LastUpDate_Red());

        addForwardParameter(request, Md004Constants.ID_DATACODE, outDto.getID_DataCode());
        addForwardParameter(request, Md004Constants.ID_DATACODE_RED, outDto.getID_DataCode_Red());
        addForwardParameter(request, Md004Constants.ID_DATE_FIRSTHARAIKOMIAFTERKURISHO_SAVE,
                outDto.getDate_FirstHaraikomiAfterKuris_Input());

        // <以下非表示項目>
        // 稟議データ
        addForwardParameter(request, Md004Constants.ID_DATE_GANRIKINHARAIKOMI_ARINGI,
                outDto.getID_Date_GanrikinHaraiKomi_aRingi());
        addForwardParameter(request, Md004Constants.ID_DATE_GANRIKINHARAIKOMI_ARINGI_RED,
                outDto.getID_Date_GanrikinHaraiKomi_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_DATE_SHOKANKIGEN_ARINGI,
                outDto.getID_Date_ShokanKigen_aRingi());
        addForwardParameter(request, Md004Constants.ID_DATE_SHOKANKIGEN_ARINGI_RED,
                outDto.getID_Date_ShokanKigen_aRingi_Red());

        addForwardParameter(request, Md004Constants.ID_DATE_SUEOKIKIGEN_ARINGI,
                outDto.getID_Date_SueokiKigen_aRingi());
        addForwardParameter(request, Md004Constants.ID_DATE_SUEOKIKIGEN_ARINGI_RED,
                outDto.getID_Date_SueokiKigen_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_DATE_TOKURIYUKO_ARINGI,
                outDto.getID_Date_TokuriYuko_aRingi());
        addForwardParameter(request, Md004Constants.ID_DATE_TOKURIYUKO_ARINGI_RED,
                outDto.getID_Date_TokuriYuko_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_DATE_JIKKO, outDto.getID_Date_Jikko());
        addForwardParameter(request, Md004Constants.ID_DATE_JIKKO_RED, outDto.getID_Date_Jikko_Red());
        addForwardParameter(request, Md004Constants.ID_M_FUKIN_ARINGI, outDto.getID_M_Fukin_aRingi());
        addForwardParameter(request, Md004Constants.ID_M_FUKIN_ARINGI_RED, outDto.getID_M_Fukin_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_M_GANKINFUKINTO_ARINGI,
                outDto.getID_M_GankinFukinto_aRingi());
        addForwardParameter(request, Md004Constants.ID_M_GANKINFUKINTO_ARINGI_RED,
                outDto.getID_M_GankinFukinto_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_KUBUN_GANKINFUKINTOGAKU_ARINGI,
                outDto.getID_Kubun_GankinFukintogaku_aRingi());
        addForwardParameter(request, Md004Constants.ID_KUBUN_GANKINFUKINTOGAKU_ARINGI_RED,
                outDto.getID_Kubun_GankinFukintogaku_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_KUBUN_KURISHOTESURYO_ARINGI,
                outDto.getID_Kubun_KurishoTesuryo_aRingi());
        addForwardParameter(request, Md004Constants.ID_KUBUN_KURISHOTESURYO_ARINGI_RED,
                outDto.getID_Kubun_KurishoTesuryo_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_M_KASHITSUKEZANDAKA_ARINGI,
                outDto.getID_M_KashitsukeZandaka_aRingi());
        addForwardParameter(request, Md004Constants.ID_M_KASHITSUKEZANDAKA_ARINGI_RED,
                outDto.getID_M_KashitsukeZandaka_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_RIRITSU_ARINGI, outDto.getID_Riritsu_aRingi());
        addForwardParameter(request, Md004Constants.ID_RIRITSU_ARINGI_RED, outDto.getID_Riritsu_aRingi_Red());
        addForwardParameter(request, Md004Constants.ID_TOKURI_ARINGI, outDto.getID_Tokuri_aRingi());
        addForwardParameter(request, Md004Constants.ID_TOKURI_ARINGI_RED, outDto.getID_Tokuri_aRingi_Red());

        // 取消済みフラグ
        addForwardParameter(request, Md004Constants.ID_FLAG_TORIKESHIZUMI, outDto.getID_Flag_Torikeshizumi());
        addForwardParameter(request, Md004Constants.ID_FLAG_TORIKESHIZUMI_RED,
                outDto.getID_Flag_Torikeshizumi_Red());

        // 債権者番号
        addForwardParameter(request, Md004Constants.ID_ID_CREDIT, outDto.getID_ID_Credit());
        addForwardParameter(request, Md004Constants.ID_ID_CREDIT_RED, outDto.getID_ID_Credit_Red());

        // 伝送番号
        addForwardParameter(request, Md004Constants.ID_ID_DENSO, outDto.getID_ID_Denso());
        addForwardParameter(request, Md004Constants.ID_ID_DENSO_RED, outDto.getID_ID_Denso_Red());

        // 履歴番号
        addForwardParameter(request, Md004Constants.ID_ID_HISTORY, outDto.getID_ID_History());
        addForwardParameter(request, Md004Constants.ID_ID_HISTORY_RED, outDto.getID_ID_History_Red());

        // 報告書番号
        addForwardParameter(request, Md004Constants.ID_ID_REPORT, outDto.getID_ID_Report());
        addForwardParameter(request, Md004Constants.ID_ID_REPORT_RED, outDto.getID_ID_Report_Red());

        // KEEP領域
        addForwardParameter(request, Md004Constants.ID_KEEP_DATE_HARAIKOMI,
                outDto.getID_Keep_Date_Haraikomi());
        addForwardParameter(request, Md004Constants.ID_KEEP_DATE_HARAIKOMI_RED,
                outDto.getID_Keep_Date_Haraikomi_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_DATE_SHOKANKIGEN,
                outDto.getID_Keep_Date_ShokanKigen());
        addForwardParameter(request, Md004Constants.ID_KEEP_DATE_SHOKANKIGEN_RED,
                outDto.getID_Keep_Date_ShokanKigen_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_ID_HISTORY, outDto.getID_Keep_ID_History());
        addForwardParameter(request, Md004Constants.ID_KEEP_ID_HISTORY_RED,
                outDto.getID_Keep_ID_History_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_JOHENKIANCHU, outDto.getID_Keep_JohenKianchu());
        addForwardParameter(request, Md004Constants.ID_KEEP_JOHENKIANCHU_RED,
                outDto.getID_Keep_JohenKianchu_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_KUBUN_GANKINFUKINTO,
                outDto.getID_Keep_Kubun_GankinFukinto());
        addForwardParameter(request, Md004Constants.ID_KEEP_KUBUN_GANKINFUKINTO_RED,
                outDto.getID_Keep_Kubun_GankinFukinto_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_FUKIN, outDto.getID_Keep_M_Fukin());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_FUKIN_RED, outDto.getID_Keep_M_Fukin_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_GANKINFUKINTO,
                outDto.getID_Keep_M_GankinFukinto());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_GANKINFUKINTO_RED,
                outDto.getID_Keep_M_GankinFukinto_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_KASHITSUKEZAN,
                outDto.getID_Keep_M_KashitsukeZan());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_KASHITSUKEZAN_RED,
                outDto.getID_Keep_M_KashitsukeZan_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_KOJORISOKU, outDto.getID_Keep_M_KojoRisoku());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_KOJORISOKU_RED,
                outDto.getID_Keep_M_KojoRisoku_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_YAKUJOGANKIN,
                outDto.getID_Keep_M_YakujoGankin());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_YAKUJOGANKIN_RED,
                outDto.getID_Keep_M_YakujoGankin_Red());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_YAKUJORISOKU,
                outDto.getID_Keep_M_YakujoRisoku());
        addForwardParameter(request, Md004Constants.ID_KEEP_M_YAKUJORISOKU_RED,
                outDto.getID_Keep_M_YakujoRisoku_Red());

        // 条変起案中区分
        addForwardParameter(request, Md004Constants.ID_KUBUN_JOHENKIANCHU, outDto.getID_Kubun_JohenKianchu());
        addForwardParameter(request, Md004Constants.ID_KUBUN_JOHENKIANCHU_RED,
                outDto.getID_Kubun_JohenKianchu_Red());

        // 充当順序変更区分
        addForwardParameter(request, Md004Constants.ID_KUBUN_JUTOJUNJOHENKO,
                outDto.getID_Kubun_JutoJunjoHenko());
        addForwardParameter(request, Md004Constants.ID_KUBUN_JUTOJUNJOHENKO_RED,
                outDto.getID_Kubun_JutoJunjoHenko_Red());

        // 請求テーブル更新用データ
        addForwardParameter(request, Md004Constants.FLGSEIKYUUPDATE, outDto.getFlgSeikyuUpdate());
        addForwardParameter(request, Md004Constants.ID_DATE_HARAIKOMI_SEIKYU,
                outDto.getID_Date_Haraikomi_Seikyu());
        addForwardParameter(request, Md004Constants.ID_M_YAKUJOGANKIN_SEIKYU,
                outDto.getID_M_YakujoGankin_Seikyu());
        addForwardParameter(request, Md004Constants.ID_M_YAKUJORISOKU_SEIKYU,
                outDto.getID_M_YakujoRisoku_Seikyu());

        // 払出データからのデータ
        addForwardParameter(request, Md004Constants.ID_M_KASHITSUKEUKEIRE, outDto.getID_M_KashitsukeUkeire());
        addForwardParameter(request, Md004Constants.ID_M_KURISHOGANKIN_SAVE,
                outDto.getID_M_KurishoGankin_Save());
        addForwardParameter(request, Md004Constants.ID_M_ZANGANKINAFTERKURISHO_SAVE,
                outDto.getID_M_ZanGankinAfterKurisho_Save());

        // ステータス
        addForwardParameter(request, Md004Constants.ID_STATUS, outDto.getID_Status());
        addForwardParameter(request, Md004Constants.ID_STATUS_RED, outDto.getID_Status_Red());

        addForwardParameter(request, Md004Constants.ID_TIME_REPORT, outDto.getID_Time_Report());
        addForwardParameter(request, Md004Constants.ID_TIME_REPORT_H, outDto.getID_Time_Report_H());
        addForwardParameter(request, Md004Constants.ID_TIME_REPORT_RED, outDto.getID_Time_Report_Red());

        // 処理種別
        addForwardParameter(request, Md004Constants.ID_TYPE_PROCESS, outDto.getID_Type_Process());
        addForwardParameter(request, Md004Constants.ID_TYPE_PROCESS_RED, outDto.getID_Type_Process_Red());
        addForwardParameter(request, Md004Constants.ID_USER_ID, outDto.getID_User_ID());
        addForwardParameter(request, Md004Constants.ID_USER_ID_RED, outDto.getID_User_ID_Red());

        // 報告年月日
        addForwardParameter(request, Md004Constants.TXTID_DATE_REPORT, outDto.getTxtID_Date_Report());
        // 繰償後残元金算出値SAVE
        addForwardParameter(request, Md004Constants.SAVE_ID_M_KASHITSUKEZAN,
                outDto.getSave_ID_M_KashitsukeZan());
    }

    /**
     *
     * <pre>
     * BigDecimal型をString型に型変換します。
     * 引数がnullの場合0を返します。
     * 引数が数字に変換できない場合は、nullを返します。
     * </pre>
     *
     * @param 数字
     * @return 文字列
     */
    private String cnvBigToStr(BigDecimal param) {
        // 引数がnullの場合は0を返す。
        if (null == param) {
            return "0";
        }
        // 引数をBigdecimalに変換
        return param.toString();
    }

    /**
     *
     * <pre>
     * String型をInteger型に型変換します。
     * 引数がnullの場合0を返します。
     * 引数が数字に変換できない場合は、nullを返します。
     * </pre>
     *
     * @param 文字列
     * @return 数字
     */
    private Integer cnvStrToInteger(String param) {
        // 引数がnullの場合は0を返す。
        if (null == param || 0 == param.length()) {
            return 0;
        }
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     *
     * <pre>
     * String型をBigDecimal型に型に変換します。
     * 引数がnullの場合0を返します。
     * 引数が数字に変換できない場合は、0を返します。
     * </pre>
     *
     * @param 文字列
     * @return 数字
     */
    private BigDecimal cnvStrToBig(String param) {
        // 引数がnullの場合は0を返す。
        if (null == param || 0 == param.length()) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(param);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

    /**
     *
     * <pre>
     * 判定用繰償事由コード(1バイト目)を取得します。
     * </pre>
     *
     */
    private String getHantei_KurishojiyuStr01(Md004_01DTO outDto) {
        if (null == outDto.getDrpID_Code_Kurishojiyu() || 2 != outDto.getDrpID_Code_Kurishojiyu().length()) {
            return "";
        }
        return new StringBuffer(outDto.getDrpID_Code_Kurishojiyu()).substring(0, 1);
    }

    /**
     *
     * <pre>
     * 判定用償還方法コード(1バイト目)を設定します。
     * </pre>
     *
     */
    private String getHantei_ShokanHouhou01(Md004_01DTO outDto) {
        if (null == outDto.getID_Code_ShokanHouhou() || 2 != outDto.getID_Code_ShokanHouhou().length()) {
            return "";
        }
        return new StringBuffer(outDto.getID_Code_ShokanHouhou()).substring(0, 1);
    }

    /**
     *
     * <pre>
     * 判定用償還方法コード(2バイト目)を設定します。
     * </pre>
     *
     */
    private String getHantei_ShokanHouhou02(Md004_01DTO outDto) {
        if (null == outDto.getID_Code_ShokanHouhou() || 2 != outDto.getID_Code_ShokanHouhou().length()) {
            return "";
        }
        return new StringBuffer(outDto.getID_Code_ShokanHouhou()).substring(1);
    }

    /**
     *
     * <pre>
     * dayからMonthago月後を返却
     * </pre>
     *
     * @param day
     * @param Monthago
     * @return
     */
    private String getDayMonthAgo(String day, int Monthago) {
        DateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Date dtNow = null;
        try {
            dtNow = new SimpleDateFormat("yyyyMMdd").parse(day);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtNow);
            cal.add(Calendar.MONTH, Monthago);
            return dtFormat.format(cal.getTime());
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     *
     * <pre>
     * 年月日から年月を取得
     * </pre>
     *
     * @param param
     * @return
     */
    private String cnvYYYYMMDDtoYYYYMM(String param) {
        if (null == param) {
            return "";
        }
        // 正規表現チェック８桁数字YYYYMMDD
        Pattern strPattern = Pattern.compile("^[0-9]{8}$");
        Matcher strMatcher = strPattern.matcher(param);
        if (strMatcher.find()) {
            return new StringBuffer(param).substring(0, 6);
        }
        return "";
    }

    /**
     *
     * <pre>
     * 文字列の長さを返す。
     * </pre>
     *
     * @param param
     * @return
     */
    private int getStrLength(String param) {
        if (null == param) {
            return 0;
        }
        return PNCommonComponents.cnvNulltoBlank(param).length();
    }

}