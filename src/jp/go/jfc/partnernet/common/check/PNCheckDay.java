package jp.go.jfc.partnernet.common.check;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;

/**
 *
 * <h3>
 * 日付のチェックを行い、bizErrorsにエラーを追加するクラスです。</h3>
 *
 * <pre>
 * 【使い方】
 *     public class XXXX {
 *
 *         //業務日付取得のため下記を追記してください
 *         <b>
 *         {@literal @}Autowired
 *         PNCommonDBComponents pnCommonDBComponents;
 *         </b>
 *        {@literal @}Override
 *        public String executeAction(XXXXXX){
 *            // bizErrors作成
 *            List<PNMessageInfo> bizErrors = new ArrayList<PNMessageInfo>(0);
 *            bizErrors.clear();
 *
 *            //オブジェクト作成
 *            PNCheckDay testDay = new PNCheckDay("H","17","4","1", pnCommonDBComponents, bizErrors);
 *            //例：必須テスト
 *            testDay.addErrorDayEquiredDay(PNCommonMessageConstants.PM3000E, new String[]{"必須エラー"});
 *            if (0 != bizErrors.size() ) {
 *                throw new PNServiceException(bizErrors);
 *            }
 *            //オブジェクト解放
 *            testDay = null;
 *        }
 *     }
 * </pre>
 * @author 富士通)2010P10033-PC
 * @version 1.1.0
 */
public class PNCheckDay {

    /**
     * <p>
     * <h4>元号</h4>
     * </p>
     */
    private String gengo;
    /**
     * <p>
     * <h4>年</h4>
     * </p>
     */
    private String year;
    /**
     * <p>
     * <h4>月</h4>
     * </p>
     */
    private String month;
    /**
     * <p>
     * <h4>日</h4>
     * </p>
     */
    private String day;
    /**
     * <p>
     * <h4>西暦</h4>
     * </p>
     */
    private String seireki;
    /**
     * <p>
     * <h4>エラー内容</h4>
     * </p>
     */
    private List<PNMessageInfo> bizErrors;

    /**
     * <p>
     * <h4>DB接続用共通関数保持</h4>
     * </p>
     */
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * <p>
     * <h4>業務日付</h4>
     * </p>
     */
    private String nowDate;

    /**
     * <pre>
     * <h4>コンストラクタ</h4>
     * </pre>
     * @param gengo 元号
     * @param year 年
     * @param month 月
     * @param day 日
     * @param pnCommonDBComponents 【使い方】参照
     * @param bizErrors エラー配列
     */
    public PNCheckDay(String gengo, String year, String month, String day,
            PNCommonDBComponents pnCommonDBComponents, List<PNMessageInfo> bizErrors) {

        // エラー配列設定
        this.bizErrors = bizErrors;
        this.year = "";
        this.month = "";
        this.day = "";
        this.seireki = "";
        this.seireki = "";

        // 業務日付を設定
        if (null != pnCommonDBComponents) {
            this.pnCommonDBComponents = pnCommonDBComponents;
            this.nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        }

        if (0 != PNCommonComponents.cnvNulltoBlank(gengo).length()
                && 0 != PNCommonComponents.cnvNulltoBlank(year).length()
                && 0 != PNCommonComponents.cnvNulltoBlank(month).length()
                && 0 != PNCommonComponents.cnvNulltoBlank(day).length()) {

            Pattern strPattern = Pattern.compile("^[0-9]*$");
            // 年月日に数字以外が入力されている時。
            if (!strPattern.matcher(year).find() || !strPattern.matcher(month).find()
                    || !strPattern.matcher(day).find()) {
                this.gengo = gengo.toUpperCase();
                this.year = year;
                this.month = month;
                this.day = day;
                this.seireki = "";
                return;
            }

            // 元号・年・月・日
            this.gengo = gengo.toUpperCase();
            this.year = String.format("%02d", Integer.parseInt(year));
            this.month = String.format("%02d", Integer.parseInt(month));
            this.day = String.format("%02d", Integer.parseInt(day));

            StringBuffer strTemp = new StringBuffer();
            strTemp.append(this.gengo);
            strTemp.append(this.year);
            strTemp.append(this.month);
            strTemp.append(this.day);

// [DEL] Ver 1.1.0 - START
//            // H1.1.1～H1.1.7の場合にはS64に変換して西暦を求める。暫定対応
//            if ("H".equals(this.gengo) && "01".equals(this.year) && "01".equals(this.month)) {
//                if (8 > Integer.parseInt(day)) {
//                    strTemp.replace(0, 3, "S64");
//                }
//            }
// [DEL] Ver 1.1.0 - END

            this.seireki = PNCommonComponents.dateFmtJC_Gyymmdd(strTemp.toString(), "");
            strTemp = null;
        }
 // [ADD] Ver 1.1.0 - START
        else if (0 != PNCommonComponents.cnvNulltoBlank(gengo).length()
                && 0 != PNCommonComponents.cnvNulltoBlank(year).length()
                && 0 != PNCommonComponents.cnvNulltoBlank(month).length()
                && 0 == PNCommonComponents.cnvNulltoBlank(day).length()) {

            Pattern strPattern = Pattern.compile("^[0-9]*$");
            // 年月日に数字以外が入力されている時。
            if (!strPattern.matcher(year).find() || !strPattern.matcher(month).find()) {
                this.gengo = gengo.toUpperCase();
                this.year = year;
                this.month = month;
                this.day = day;
                this.seireki = "";
                return;
            }

            // 元号・年・月・日
            this.gengo = gengo.toUpperCase();
            this.year = String.format("%02d", Integer.parseInt(year));
            this.month = String.format("%02d", Integer.parseInt(month));
            this.day = "";

            StringBuffer strTemp = new StringBuffer();
            strTemp.append(this.gengo);
            strTemp.append(this.year);
            strTemp.append(this.month);
            this.seireki = PNCommonComponents.dateFmtJC_GyymmToYYYYMMDD(strTemp.toString(), "");

            strTemp = null;
// [ADD] Ver 1.1.0 - END
        } else {
            this.gengo = gengo.toUpperCase();
            this.year = PNCommonComponents.cnvNulltoBlank(year);
            this.month = PNCommonComponents.cnvNulltoBlank(month);
            this.day = PNCommonComponents.cnvNulltoBlank(day);
            this.seireki = "";
        }
    }

    /**
     * <pre>
     * <h4>コンストラクタ</h4>
     * </pre>
     * @param param 西暦<u>YYYYMMDD</u>または和暦<u>GYYMMDD</u>
     * @param pnCommonDBComponents 【使い方】参照
     * @param bizErrors エラー配列
     */
    public PNCheckDay(String param, PNCommonDBComponents pnCommonDBComponents, List<PNMessageInfo> bizErrors) {
        this.year = "";
        this.month = "";
        this.day = "";
        this.seireki = "";
        this.seireki = "";
        // 業務日付を設定
        if (null != pnCommonDBComponents) {
            this.pnCommonDBComponents = pnCommonDBComponents;
            this.nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        }
        // エラー配列設定
        this.bizErrors = bizErrors;

        // 和暦分解用Stringオブジェクト
        String[] wareki = new String[3];

        if (null == param) {
            // 入力がない場合は空白
            this.gengo = "";
            this.year = "";
            this.month = "";
            this.day = "";
            this.seireki = "";
        } else {
            // 正規表現チェック８桁数字YYYYMMDD
            Pattern strPattern = Pattern.compile("^[0-9]{8}$");
            Matcher strMatcher = strPattern.matcher(param);
            if (strMatcher.find()) {
                // 和暦に分解して設定
                if (0 == PNCommonComponents.dateFmtAD_YYYYMMDD(param).length()) {
                    // 和暦に分解できない場合
                    // 西暦のみを設定
                    this.gengo = "";
                    this.year = "";
                    this.month = "";
                    this.day = "";
                    this.seireki = param;
                } else {
                    wareki = PNCommonComponents.dateFmtAD_YYYYMMDD(param).split("\\.");
                    this.gengo = new StringBuffer(wareki[0]).substring(0, 1).toUpperCase();// 1文字目
                    this.year = new StringBuffer(wareki[0]).substring(1);// １文字以降
                    this.month = wareki[1];
                    this.day = wareki[2];
                    // 西暦を設定
                    this.seireki = param;
                }
            } else {
                // 和暦に変換出来るか確認
                this.seireki = PNCommonComponents.dateFmtJC_Gyymmdd(param.toString(), "");

                // 変換出来た場合、分解して設定
                if (0 != this.seireki.length()) {
                    wareki = PNCommonComponents.dateFmtAD_YYYYMMDD(this.seireki).split("\\.");
                    this.gengo = new StringBuffer(wareki[0]).substring(0, 1);// 1文字目
                    this.year = String.format("%02d",
                            Integer.parseInt(new StringBuffer(wareki[0]).substring(1)));// １文字以降
                    this.month = String.format("%02d", Integer.parseInt(wareki[1]));
                    this.day = String.format("%02d", Integer.parseInt(wareki[2]));
                } else {
                    this.gengo = "";
                    this.year = "";
                    this.month = "";
                    this.day = "";
                }
            }
        }

    }

    /**
     * <pre>
     * <h4>必須入力チェック</h4>
     * </pre>
     * @return boolean 元号・年・月・日が入力されている場合はtrue
     */
    private boolean checkRequired() {
        if (0 == this.year.length() || 0 == this.month.length() || 0 == this.day.length()) {
            return false;
        } else {
            return true;
        }
    }
// [ADD] Ver 1.1.0 - START

    /**
     * <pre>
     * <h4>必須入力チェック</h4>
     * </pre>
     * @return boolean 元号・年・月が入力されている場合はtrue
     */
    private boolean checkRequiredMonth() {
        if (0 == this.year.length() || 0 == this.month.length()) {
            return false;
        } else {
            return true;
        }
    }

// [ADD] Ver 1.1.0 - END
    /**
     *
     * <h4>有効日付チェック(コンストラクタで入力された西暦)</h4>
     *
     * @return boolean 有効日の場合はtrue
     */
    private boolean checkEffectiveDay() {
        // 入力が無い場合はエラー処理しない
        if (0 == this.seireki.length()) {
            return false;
        }
        // S64の場合はfalse
        if ("S".equals(this.gengo) && "64".equals(this.year)) {
            return false;
        }
        // 有効日付以外はfalse
        if (!PNCommonComponents.checkDate(this.seireki)) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * <h4>有効日付チェック 引数有西暦</h4>
     * </pre>
     * @param seireki 西暦
     * @return boolean 有効日の場合はtrue
     */
    private boolean checkEffectiveDay(String seireki) {

        // 未入力時はfalse
        if (null == seireki) {
            return false;
        }

        // 正規表現チェック
        Pattern strPattern = Pattern.compile("^[0-9]{8}$");
        Matcher strMatcher = strPattern.matcher(seireki);
        if (!strMatcher.find()) {
            strMatcher = null;
            strPattern = null;
            return false;
        }
        strMatcher = null;
        strPattern = null;

        // 有効日付以外はfalse
        if (!PNCommonComponents.checkDate(seireki)) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * <h4>西暦YYYYMMDDを返します</h4>
     * </pre>
     * @return 日付文字列西暦YYYYMMDD
     */
    public String getSeireki() {
        return this.seireki;
    }

    /**
     * <pre>
     * <h4>西暦YYYYMMを返します</h4>
     * </pre>
     * @return 日付文字列西暦YYYYMM
     */
    private String getYearMonth(String seireki) {

        if (null == seireki) {
            return "";
        }

        if (0 == seireki.length()) {
            return "";
        }
        // 正規表現チェック
        Pattern strPattern = Pattern.compile("^[0-9]{8}$");
        Matcher strMatcher = strPattern.matcher(seireki);
        if (!strMatcher.find()) {
            strMatcher = null;
            strPattern = null;
            return "";
        }
        return seireki.substring(0, 6);
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 必須項目</h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayRequiredDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 入力が無い場合はエラー処理
        if (!this.checkRequired()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }
// [ADD] Ver 1.1.0 - START

    /**
     * <pre>
     * <h4>日付エラー追加処理 必須項目</h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayRequiredMonth(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 入力が無い場合はエラー処理
        if (!this.checkRequiredMonth()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

// [ADD] Ver 1.1.0 - END
    /**
     * <pre>
     * <h4>日付エラー追加処理 入力されている場合</h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayNotRequiredDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 入力されている場合
        if (0 != this.year.length() || 0 != this.month.length() || 0 != this.day.length()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 年数字チェック</h4>
     * <small>年が数字では無い場合エラーを追加する。</small>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayYear(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 入力が無い場合はエラー処理しない
        if ("".equals(this.month)) {
            return;
        }

        if (null == this.year) {
            return;
        }

        if (!PNStringChecker.isNumeric(this.year)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 有効日付 </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayEffectiveDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 空白有の場合は処理しない。
        if (!checkRequired()) {
            return;
        }

        // 西暦に変換が出来ない場合。
        if (null == seireki || 0 == seireki.length()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
            return;
        }
        // 有効日付チェック
        if (!PNCommonComponents.checkDate(this.seireki)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
        }
    }
// [ADD] Ver 1.1.0 - START
    /**
     * <pre>
     * <h4>日付エラー追加処理 有効日付 </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayEffectiveMonth(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 空白有の場合は処理しない。
        if (!checkRequiredMonth()) {
            return;
        }

        // 西暦に変換が出来ない場合。
        if (null == seireki || 0 == seireki.length()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
            return;
        }
        // 有効日付チェック
        StringBuilder strGyymm = new StringBuilder();
        strGyymm.append(this.gengo).append(this.year).append(this.month);
        if (0 == PNCommonComponents.dateFmtJC_Gyymm(strGyymm.toString(), "").length()) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
        }
    }
// [ADD] Ver 1.1.0 - End

    /**
     * <pre>
     * <h4>日付エラー追加処理 昭和64年である </h4>
     * <small>※注意：西暦でコンストラクタを作成した場合、和暦変換出来ない場合はスルーしてしまいます！</small>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorS64(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        if ("S".equals(gengo) && "64".equals(year)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));
        }
    }

// [ADD] Ver 1.1.0 - START
    /**
     * <pre>
     * <h4>日付エラー追加処理 元号指定チェック(S64, G01) </h4>
     * <small>※注意：西暦でコンストラクタを作成した場合、和暦変換出来ない場合はスルーしてしまいます！</small>
     * </pre>
     *
     * @param messageId
     *            bizErrors追加時のメッセージID
     * @param parameter
     *            bizErrors追加時のメッセージパラメーター
     */
    public void addErrorGengoAppoint(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // 元号指定チェック
        PNCommonComponents.checkGengoAppoint(gengo + year, 1, parameter, bizErrors);
    }
// [ADD] Ver 1.1.0 - END

    /**
     * <pre>
     * <h4>日付エラー追加処理 営業日判定 </h4>
     * <small><u>営業日では無い場合</u>に追加</small>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayBusinessDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        if (null == PNCommonComponents.chkWeekEndHolidays(this.seireki)
                || null == pnCommonDBComponents.chkBusinessDay(this.seireki)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 今日の日付より後 (西暦(コンストラクタ)> 業務日付 の場合エラー) </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayOverToDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }

        // 西暦(コンストラクタ)> 業務日付 の場合エラー
        if (Integer.parseInt(this.seireki) > Integer.parseInt(this.nowDate)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 今日の日付より前 (西暦(コンストラクタ)< 業務日付 の場合エラー) </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayUnderToDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }

        // 西暦(コンストラクタ)< 業務日付 の場合エラー
        if (Integer.parseInt(this.seireki) < Integer.parseInt(this.nowDate)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 今日の日付より後 (西暦(コンストラクタ)> 業務日付 の場合エラー)(月で比較) </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時のメッセージパラメーター
     */
    public void addErrorDayOverMonthToDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }

        // 西暦(コンストラクタ)> 業務日付 の場合エラー
        if (Integer.parseInt(getYearMonth(this.seireki)) > Integer.parseInt(getYearMonth(this.nowDate))) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 今日の日付より前 (西暦(コンストラクタ)< 業務日付 の場合エラー)(月で比較) </h4>
     * </pre>
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayUnderMonthToDay(String messageId, String[] parameter) {

        // エラー処理
        if (null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }

        // 西暦(コンストラクタ)< 業務日付 の場合エラー
        if (Integer.parseInt(getYearMonth(this.seireki)) < Integer.parseInt(getYearMonth(this.nowDate))) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の日付より後(西暦(コンストラクタ) > 指定日(第一引数)) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayOverDay(String seireki, String messageId, String[] parameter) {

        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(this.seireki) > Integer.parseInt(seireki)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の日付より前(西暦(コンストラクタ) < 指定日(第一引数) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayUnderDay(String seireki, String messageId, String[] parameter) {

        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(this.seireki) < Integer.parseInt(seireki)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の月より後(西暦(コンストラクタ) > 指定日（月で比較）) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayOverMonthDay(String seireki, String messageId, String[] parameter) {

        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(getYearMonth(this.seireki)) > Integer.parseInt(getYearMonth(seireki))) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の月より前(西暦(コンストラクタ) < 指定日（月で比較）) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayUnderMonthDay(String seireki, String messageId, String[] parameter) {

        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(getYearMonth(this.seireki)) < Integer.parseInt(getYearMonth(seireki))) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定された日の月末日より後(西暦(コンストラクタ) > 指定日の月末) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayOverEndMonthDay(String seireki, String messageId, String[] parameter) {

        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        int[] iLastDay = PNDateUtils.getLastDateByString(seireki);
        String lastDate = PNCommonComponents.concatString(new String[]{String.valueOf(iLastDay[0]),
                PNFormatUtils.intFormat(iLastDay[1], PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2),
                PNFormatUtils.intFormat(iLastDay[2], PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2)});
        if (Integer.parseInt(this.seireki) > Integer.parseInt(lastDate)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の日付である時(西暦(コンストラクタ) = 指定日(第一引数) </h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayEqualsDay(String seireki, String messageId, String[] parameter) {
        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(this.seireki) == Integer.parseInt(seireki)) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     * <pre>
     * <h4>日付エラー追加処理 指定の日付である時(西暦(コンストラクタ) = 指定日(第一引数) 月で比較</h4>
     * </pre>
     * @param seireki 指定日YYYYMMDD
     * @param messageId bizErrors追加時のメッセージID
     * @param parameter bizErrors追加時の、メッセージパラメーター
     */
    public void addErrorDayEqualsMonthDay(String seireki, String messageId, String[] parameter) {
        // エラー処理
        if (null == seireki || null == messageId || null == parameter) {
            throw new IllegalArgumentException();
        }

        // コンストラクタ入力日付が有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay()) {
            return;
        }
        // 有効日付ではない場合エラー処理しない
        if (!this.checkEffectiveDay(seireki)) {
            return;
        }

        if (Integer.parseInt(getYearMonth(this.seireki)) == Integer.parseInt(getYearMonth(seireki))) {
            bizErrors.add(new PNMessageInfo(messageId, parameter, false));

        }
    }

    /**
     *
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer tmpStr = new StringBuffer("");
        tmpStr.append("元号='");
        tmpStr.append(this.gengo);
        tmpStr.append("',年='");
        tmpStr.append(this.year);
        tmpStr.append("',月='");
        tmpStr.append(this.month);
        tmpStr.append("',日='");
        tmpStr.append(this.day);
        tmpStr.append("',西暦='");
        tmpStr.append(this.seireki);
        tmpStr.append("',業務日付=''");
        tmpStr.append(this.nowDate);
        tmpStr.append("'");
        return tmpStr.toString();
    }
}
