//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02CopyController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.check.PNCheckDay;
import jp.go.jfc.partnernet.cr003.cr003_02.service.Cr003_02M1DTO;
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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr003_02の一括コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr003_02Form")
@RequestMapping(value = "/Cr003_02Copy.form")
public class Cr003_02CopyController extends Cr003_02BaseController {

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** エラーリスト */
    LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

    /** 決算日 */
    private String kessanbi;

    /** 業務日付 */
    private String nowDate;

    /** 業務日付より１か月前 */
    private String oneMonthAgo;

    /** 業務日付から算出した年度初日 */
    private String businessYearFirstDay;

    /** 業務日付から算出した年度末日 */
    private String businessYearLastDay;

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
    public String executeAction(Model model, Cr003_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 一括部で入力された入金日、受託者勘定処理年月、送金日、送金日番号を、全案件に設定する。
        // 但し、以下の条件に合致する案件には設定しない。
        // 　先行報告書の有り　又は
        // 　（（約定利息未入力　又は　約定利息＝０）　かつ　（約定元金未入力　又は　約定元金＝０））

        // エラーリスト初期化
        bizErrors.clear();

        // エラー確認
        checkInput(form);

        // エラー判定
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            form.setErrCount(String.valueOf(PNCommonComponents.cnvNulltoZero(this.bizErrors.size())));
            form.setErrFromCopy(true);
            throw new PNServiceException(bizErrors);
        }
        else {
            form.setErrCount("0");
            form.setErrFromCopy(true);
        }

        List<Cr003_02M1DTO> m1Table = form.getCr003_02M1TableRecord();
        for (Cr003_02M1DTO m1TableRec : m1Table) {
            // 更新結果で自画面を表示する
            if ("true".equals(m1TableRec.getID_Previous_Report())
                    || ("0".equals(PNCommonComponents.cnvNulltoZero(m1TableRec.getID_M_YakujoRisoku())) && "0"
                            .equals(PNCommonComponents.cnvNulltoZero(m1TableRec.getID_M_YakujoGankin())))) {
                continue;
            }
            // 選択チェックボックス
            m1TableRec.setChkUpdate("1");
            // 入金日（年）
            m1TableRec.setID_Date_Nyukin_Gengo(form.getDropdownlist1());
            m1TableRec.setID_Date_Nyukin_Nen(form.getTextbox1());
            // 入金日（月）
            m1TableRec.setID_Date_NyukinTsuki(form.getDropdownlist2());
            // 入金日（日）
            m1TableRec.setID_Date_NyukinBi(form.getDropdownlist3());
            // 受託者勘定年月(年)
            m1TableRec.setID_Date_Jtkshori_Gengo(form.getDropdownlist4());
            m1TableRec.setHdnID_Date_Jtkshori_Gengo(form.getDropdownlist4());
            m1TableRec.setID_Date_Jtkshori_Nen(form.getTextbox2());
            // 受託者勘定年月(月)
            m1TableRec.setID_Date_JtkshoriTsuki(form.getDropdownlist5());
            m1TableRec.setHdnID_Date_JtkshoriTsuki(form.getDropdownlist5());
            // 送金日(年)
            m1TableRec.setID_Date_Sokin_Gengo(form.getDropdownlist6());
            m1TableRec.setID_Date_Sokin_Nen(form.getTextbox3());
            // 送金日(月)
            m1TableRec.setID_Date_SokinTsuki(form.getDropdownlist7());
            // 送金日(日)
            m1TableRec.setID_Date_SokinBi(form.getDropdownlist8());
            // 送金日番号
            m1TableRec.setID_ID_Sokinbi(form.getID_Soshin_Copy());
        }

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
    public void displayControl(Model model, Cr003_02Form form, HttpServletRequest request) {
    }

    /**
     *
     * <pre>
     * 入力内容のチェックを行う。
     * </pre>
     *
     * @param form
     */
    private void checkInput(Cr003_02Form form) {

        // 判定日付をセットする。
        this.setDays(form);

        // ●一括入力入金日 チェック用オブジェクト
        PNCheckDay checkNiyukin = new PNCheckDay(form.getDropdownlist1().toUpperCase(), form.getTextbox1(),
                form.getDropdownlist2(), form.getDropdownlist3(), pnCommonDBComponents, bizErrors);

        // ●一括入力受託者勘定処理年月 チェック用オブジェクト
// [UPD] Ver 3.0.0 - START
//        PNCheckDay checkJyutaku = new PNCheckDay(form.getDropdownlist4().toUpperCase(), form.getTextbox2(),
//                form.getDropdownlist5(), "01", pnCommonDBComponents, bizErrors);
        PNCheckDay checkJyutaku = new PNCheckDay(form.getDropdownlist4().toUpperCase(), form.getTextbox2(),
                form.getDropdownlist5(), "", pnCommonDBComponents, bizErrors);
// [UPD] Ver 3.0.0 - END

        // ●一括入力送金日 チェック用オブジェクト
        PNCheckDay checkSokin = new PNCheckDay(form.getDropdownlist6().toUpperCase(), form.getTextbox3(),
                form.getDropdownlist7(), form.getDropdownlist8(), pnCommonDBComponents, bizErrors);

        // ■コメント入力データの各種チェックを行う。
        // エラーメッセージ表示時、以下のフォーマットで表示する。
        // 　　入金日コントロールで必須エラー時、「入金日：必須項目に値が入力されていません。」
        // 　　※先頭の固定文言(「入金日」)はメッセージ欄の【】内文言を付加する。
        // 　　チェックでエラーが発生した場合、メッセージを蓄積し後続のチェックを継続する。チェック終了後、発生エラー毎に改行して一括表示する。
        //
        // ■単項目チェック一括入力入金日チェック
        // 　①必須チェック
        // 　　　一括入力入金日（年）、（月）、（日）のいずれかが未入力の場合、エラーとする。
        // 　　　　メッセージ：CHK001 【入金日】
        checkNiyukin.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[] { "入金日：入金日" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　②数値チェック（一括入力入金日（年）に入力がある場合のみチェックする）
        // 　　　一括入力入金日（年）が数字でない場合、エラーとする。
        // 　　　　メッセージ：PN_NKIN_000 【入金日】
        checkNiyukin.addErrorDayYear(PNCommonMessageConstants.PM3140E, new String[] { "入金日：一括入力入金日（年）は数字" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　①必須チェック
        // 　　　一括入力受託者勘定処理年月(年)、（月）のいずれかが未入力の場合、エラーとする。
        // 　　　　メッセージ：CHK001 【受託者勘定処理年月】
// [UPD] Ver 3.0.0 - START
//        checkJyutaku.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E,
//                new String[] { "受託者勘定処理年月：受託者勘定処理年月" });
        checkJyutaku.addErrorDayRequiredMonth(PNCommonMessageConstants.PM3120E,
                new String[] { "受託者勘定処理年月：受託者勘定処理年月" });
// [UPD] Ver 3.0.0 - END
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　②数値チェック（一括入力受託者勘定処理年月(年)に入力がある場合のみチェックする）
        // 　　　一括入力受託者勘定処理年月(年)が数字でない場合、エラーとする。
        // 　　　　メッセージ：PN_JKSN_000 【受託者勘定処理年月】
        checkJyutaku.addErrorDayYear(PNCommonMessageConstants.PM3140E,
                new String[] { "受託者勘定処理年月：一括入力受託者勘定処理年月(年)は数字" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // ■単項目チェック一括入力送金日チェック
        // 　①必須チェック
        // 　　　一括入力送金日（年）、（月）、（日）のいずれかが未入力の場合、エラーとする。
        // 　　　　メッセージ：CHK001 【送金日】
        checkSokin.addErrorDayRequiredDay(PNCommonMessageConstants.PM3120E, new String[] { "送金日：送金日" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　②数値チェック（一括入力送金日（年）に入力がある場合のみチェックする）
        // 　　　一括入力送金日(年)が数字でない場合、エラーとする。
        // 　　　　メッセージ：PN_SKNB_000 【送金日】
        checkSokin.addErrorDayYear(PNCommonMessageConstants.PM3140E, new String[] { "送金日：送金日は数字" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // ■単項目チェック一括入力送金日番号チェック
        // 　①必須チェック
        // 　　　一括入力送金日番号が未入力の場合、エラーとする。
        // 　　　　メッセージ：CHK001 【送金日番号】
        if (PNStringChecker.checkDigit(PNCommonComponents.cnvNulltoBlank(form.getID_Soshin_Copy()), 0)) {
            this.addError(PNCommonMessageConstants.PM3120E, new String[] { "送金日番号：送金日番号" });
            return;
        }

        // 　②数値チェック（一括入力送金日番号に入力がある場合のみチェックする）
        // 　　　一括入力送金日番号が数字でない場合、エラーとする。
        // 　　　　メッセージ：PTN_JKSN_008 【送金日番号】
        // 　③値チェック（一括入力送金日番号に入力があり、②チェックが正常の場合のみチェックする）
        // 　　　一括入力送金日番号＜１の場合、エラーとする。
        // 　　　　メッセージ：PN_SKBB_000 【送金日番号】
        //
        if (false == PNStringChecker.isNumeric(PNCommonComponents.cnvNulltoBlank(form.getID_Soshin_Copy()))) {
            this.addError(PNCommonMessageConstants.PM3140E, new String[] { "送金日番号：送金日番号は数字" });
            return;
        }
        else {
            if (1 > Integer.parseInt(PNCommonComponents.cnvNulltoZero(form.getID_Soshin_Copy()))) {
                this.addError(PNCommonMessageConstants.PM3140E, new String[] { "送金日番号：送金日番号は１以上" });
                return;
            }
        }

        // ■相関チェック一括入力入金日についてチェックを行う
        // 　※一括入力入金日：一括入力入金日（元号）、一括入力入金日（年）、一括入力入金日（月）、一括入力入金日（日）の
        // 　　　　　　　　　　連結値を西暦に変換した値。
        // 　１．営業日エラー
        // 　　一括入力入金日が有効でない場合エラーとする（月の末日以内でない場合エラーとする）
        // 　　　　メッセージ：PM3220E【入金日】
        checkNiyukin.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E, new String[] { "入金日：入金日は有効な日付" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　２．営業日エラー
        // 　　一括入力入金日が非営業日の場合エラーとする
        // 　　　　メッセージ：PM3331E 【入金日】
        checkNiyukin.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[] { "入金日：入金日は" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　３．報告日エラー
        // 　　・一括入力入金日＞システム日付の場合エラーとする
        // 　　　　メッセージ：PM3260E 【入金日】
        checkNiyukin.addErrorDayOverToDay(PNCommonMessageConstants.PM3260E, new String[] { "入金日：入金日が本日" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // ■相関チェック一括入力受託者勘定処理年月についてチェックを行う
        // 　※一括入力入力受託者勘定処理年月：一括入力入力受託者勘定処理年月（元号）、一括入力入力受託者勘定処理年月（年）、一括入力入力受託者勘定処理年月（月）の
        // 　　　　　　　　　　連結値を西暦に変換した値。
        // 　１．受託者勘定処理年月日付不正エラー
        // 　　一括入力受託者勘定処理年月が有効でない場合エラーとする
        // 　　　　メッセージ：PM3220E【受託者勘定処理年月】
// [UPD] Ver 3.0.0 - START
//        checkJyutaku.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E,
//                new String[] { "受託者勘定処理年月：受託者勘定処理年月は有効な日付" });
        checkJyutaku.addErrorDayEffectiveMonth(PNCommonMessageConstants.PM3140E,
                new String[] { "受託者勘定処理年月：受託者勘定処理年月は有効な日付" });
// [UPD] Ver 3.0.0 - END
        if (0 != this.bizErrors.size()) {
            return;
        }

        // ■相関チェック一括入力送金日、一括入力送金日番号についてチェックを行う
        // 　一括入力送金日を事前に編集する
        // 　　　・一括入力送金日（元号）、一括入力送金日（年）、一括入力送金日（月）、一括入力送金日（日）の連結値を西暦に変換した値。
        // 　１．送金日日付不正エラー
        // 　　入力した一括入力送金日（日）が有効日付でない場合エラーとする（一括入力送金日（日）が一括入力送金日年月の月末日より大きい場合）
        // 　有効な日付でない場合、エラーとする。
        // 　　　　メッセージ：PM3220E 【送金日】

        checkSokin.addErrorDayEffectiveDay(PNCommonMessageConstants.PM3140E, new String[] { "送金日：送金日は有効な日付" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　２．送金日日付エラー
        // 　　入金日＞送金日の場合エラーとする
        // 　　　　メッセージ：PM3260E 【送金日】
        checkSokin.addErrorDayUnderDay(checkNiyukin.getSeireki(), PNCommonMessageConstants.PM3120E,
                new String[] { "送金日：送金日に入金日以降の日付" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　３．送金日営業日エラー
        // 　　一括入力送金日が非営業日の場合エラーとする
        // 　　　　メッセージ：PM3331E 【送金日】
        checkSokin.addErrorDayBusinessDay(PNCommonMessageConstants.PM3331E, new String[] { "送金日：送金日は" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　４．送金日番号エラー
        // 　　一括入力送金日番号＜１の場合エラーとする
        // 　　　　メッセージ：PM3140E 【送金日番号】
        //
        if (1 > Integer.parseInt(PNCommonComponents.cnvNulltoZero(form.getID_Soshin_Copy()))) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3140E, new String[] { "送金日：送金日番号は1以上" },
                    false));
        }
        if (0 != this.bizErrors.size()) {
            return;
        }

        // ■相関チェック受託者勘定処理年月についてチェックを行う
        // 　事前に共通処理にて本店決算整理日付を取得する
        // 　一括入力受託者勘定処理年月を事前に編集する
        // 　　　・一括入力受託者勘定処理年月（元号）、一括入力受託者勘定処理年月（年）、一括入力受託者勘定処理年月（月）
        // 　　　　の連結値を西暦に変換した値。
        // 　１．受託者勘定処理日エラー1
        // 　　一括入力受託者勘定処理年月＞報告日（本日日付）の場合エラーとする
        // 　　　　メッセージ：PM3260E 【受託者勘定処理年月】
        checkJyutaku.addErrorDayOverToDay(PNCommonMessageConstants.PM3260E,
                new String[] { "受託者勘定処理年月：受託者勘定処理年月が報告日" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　２．本店決算整理日付取得エラー
        // 　　本店決算整理日付が取得できない場合エラーとする
        // 　　　　メッセージ：PM3190E 【受託者勘定処理年月（留置金）】
        if (null == this.kessanbi) {
            this.addError(PNCommonMessageConstants.PM3190E, new String[] { "受託者勘定処理年月（留置金）：本店決算整理日付" });
            return;
        }

        // 　３．留置金か否かにて受託者勘定処理年月をチェックする
        // 　　３．１．留置金か否かの判定
        // 　　３．２．受託者勘定処理日エラー2
        // 　　　留置金の場合、一括入力受託者勘定処理年月＞一括入力入金日の年月の場合エラーとする
        // 　　　　メッセージ：PM3140E 【入金日】
        if (this.isRyuchikin(checkNiyukin, checkSokin)) {
            checkJyutaku.addErrorDayOverMonthDay(checkNiyukin.getSeireki(), PNCommonMessageConstants.PM3140E,
                    new String[] { "入金日：入金日は受託者勘定処理年月（留置金）以降の日付" });
        }
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　　３．３．受託者勘定処理日エラー3
        // 　　　留置金でない場合、一括入力受託者勘定処理年月＜一括入力入金日の年月の場合エラーとする
        // 　　　　メッセージ：PM3260E 【入金日】
        if (!this.isRyuchikin(checkNiyukin, checkSokin)) {
            checkJyutaku.addErrorDayUnderMonthDay(checkNiyukin.getSeireki(),
                    PNCommonMessageConstants.PM3260E,
                    new String[] { "入金日：入金日が受託者勘定処理年月" });
        }
        if (0 != this.bizErrors.size()) {
            return;
        }

        // 　４．年度初日と受託者勘定処理年月をチェックする
        // 　　本店決算整理日付＜報告日（本日日付）の場合のみ実施する
        // 　　４．１．年度初日の編集
        // 　　　今年の４／１を年度初日とする。但し、今日が１，２，３月の場合、前年の４／１を年度初日とする。
        // setDays()似て実施済
        if (Integer.parseInt(this.kessanbi) < Integer.parseInt(this.nowDate)) {
            // 　　４．２．受託者勘定処理日エラー4
            // 　　　一括入力受託者勘定処理年月＜年度初日の年月の場合エラーとする
            // 　　　　メッセージ：PM3810E 【受託者勘定処理年月】
            checkJyutaku.addErrorDayUnderMonthDay(businessYearFirstDay, PNCommonMessageConstants.PM3810E,
                    new String[] { "受託者勘定処理年月：受託者勘定処理年月" });
            if (0 != this.bizErrors.size()) {
                return;
            }
        }

        // ■相関チェック払込期間エラー
        // 　　(一括入力入金日＜払込期日入力画面の「払込期日」の１か月前)の場合エラーとする
        // 　　　　メッセージ：PM3140E 【入金日】
        checkNiyukin.addErrorDayUnderDay(oneMonthAgo, PNCommonMessageConstants.PM3140E,
                new String[] { "入金日：入金日は払込期日入力画面の「払込期日」の１か月前 より後" });
        if (0 != this.bizErrors.size()) {
            return;
        }

        checkNiyukin = null;
        checkJyutaku = null;
        checkSokin = null;
    }

    /**
     *
     * <pre>
     * 判定日付を設定する
     * </pre>
     *
     */
    private void setDays(Cr003_02Form form) {
        // 決算日
        this.kessanbi = pnCommonDBComponents.getKessanbi();

        // 業務日付
        this.nowDate = pnCommonDBComponents.getPNBusinessDay(1);

        // 払込期日の一か月前

        String haraikomiDay = form.getCr003_02Date_Haraikomi();

        DateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Date dtNow = null;
        try {
            dtNow = new SimpleDateFormat("yyyyMMdd").parse(haraikomiDay);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtNow);
        cal.add(Calendar.MONTH, -1);
        this.oneMonthAgo = dtFormat.format(cal.getTime());
        dtNow = null;
        dtFormat = null;

        // 年度末日を設定
        // ※今年の３／３１を年度末日とする。但し、今日が１，２，３月の場合、前年の３／３１を年度末日とする。
        this.businessYearLastDay = "";
        if (3 >= Integer.parseInt(this.nowDate.substring(4, 6))) {
            this.businessYearLastDay = PNCommonComponents.concatString(
                    String.valueOf(Integer.parseInt(this.nowDate.substring(0, 4)) - 1), "0331");
        }
        else {
            this.businessYearLastDay = PNCommonComponents.concatString(
                    String.valueOf(Integer.parseInt(this.nowDate.substring(0, 4))), "0331");
        }

        // 年度初日を設定
        // 　　　今年の４／１を年度初日とする。但し、今日が１，２，３月の場合、前年の４／１を年度初日とする。
        this.businessYearFirstDay = "";
        if (3 >= Integer.parseInt(this.nowDate.substring(4, 6))) {
            this.businessYearFirstDay = PNCommonComponents.concatString(
                    String.valueOf(Integer.parseInt(this.nowDate.substring(0, 4)) - 1), "0401");
        }
        else {
            this.businessYearFirstDay = PNCommonComponents.concatString(
                    String.valueOf(Integer.parseInt(this.nowDate.substring(0, 4))), "0401");
        }
    }

    /**
     *
     * <pre>
     * 留置金か否かを判定します。
     * </pre>
     *
     * @param Niyukin
     * @param Sokin
     * @return
     */
    private boolean isRyuchikin(PNCheckDay Niyukin, PNCheckDay Sokin) {

        // 　　　・年度末日（※）≧システム日付の場合、留置金でない
        if (Integer.parseInt(businessYearLastDay) >= Integer.parseInt(this.nowDate)) {
            return false;
        }

        // 　　　・本店決算整理日付≦システム日付の場合、留置金でない
        if (Integer.parseInt(this.kessanbi) <= Integer.parseInt(this.nowDate)) {
            return false;
        }

        // 　　　・一括入力入金日>年度末日（※）の場合、留置金でない
        if (!PNCommonConstants.LITERAL_BLANK.equals(Niyukin.getSeireki())
                && Integer.parseInt(Niyukin.getSeireki()) > Integer.parseInt(businessYearLastDay)) {
            return false;
        }

        // 　　　・一括入力送金日が未入力の場合、留置金でない
        if (PNCommonConstants.LITERAL_BLANK.equals(Sokin.getSeireki())) {
            return false;
        }

        // 　　　・一括入力送金日≦年度末日（※）の場合、留置金でない
        // ※今年の３／３１を年度末日とする。但し、今日が１，２，３月の場合、前年の３／３１を年度末日とする。
        if (Integer.parseInt(Sokin.getSeireki()) <= Integer.parseInt(businessYearLastDay)) {
            return false;
        }

        return true;

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
    private void addError(String messageId, String[] parameter) {
        bizErrors.add(new PNMessageInfo(messageId, parameter, false));
    }

}