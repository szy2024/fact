//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCommonComponents
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/06 | ○○　○              | 新規作成
// 1.1.0   | 2018/12/17 | 林　晃平              | 農林PN元号対応
// 4.0.0   | 2021/03/29 | 飯田　晶彦            | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.common;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
// [ADD] Ver 1.1.0 - START
import java.util.ArrayList;
// [ADD] Ver 1.1.0 - END
import java.util.Calendar;
import java.util.LinkedHashMap;
// [ADD] Ver 1.1.0 - START
import java.util.List;
// [ADD] Ver 1.1.0 - END
import java.util.regex.Matcher;
import java.util.regex.Pattern;



// [ADD] Ver 1.1.0 - START
import jp.go.jfc.partnernet.common.PNCommonCalendarInfo.PNCommonCalendarBorderInfo;
import jp.go.jfc.partnernet.common.PNCommonCalendarInfo.PNCommonCalendarGengoInfo;
// [ADD] Ver 1.1.0 - END
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
// [ADD] Ver 1.1.0 - START
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
// [ADD] Ver 1.1.0 - END
import jp.go.jfc.partnernet.pnfw.common.PNMessageUtils;
import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;
import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

import org.apache.commons.lang.StringUtils;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.exception.CFWReflectionException;

/**
 * <pre>
 * このクラスは共通部品クラスです。
 * </pre>
 *
 * @author 富士通)○○　○
 * @version 1.0.0
 */
public class PNCommonComponents {

// [ADD] Ver 1.1.0 - START
    /**
     * 元号基本情報リスト
     */
    private static final ArrayList<PNCommonCalendarGengoInfo> gengoInfoList;

    /**
     * 境界情報リスト
     */
    private static final ArrayList<PNCommonCalendarBorderInfo> borderInfoList;

    /**
     * 初期元号
     */
    private static final String initGengo;

    /**
     * 元号基本情報リストを取得します。
     *
     * @return 元号基本情報リスト
     */
    public static ArrayList<PNCommonCalendarGengoInfo> getGengoinfolist() {
        return gengoInfoList;
    }

    /**
     * 境界情報リストを取得します。
     *
     * @return 境界情報リスト
     */
    public static ArrayList<PNCommonCalendarBorderInfo> getBorderinfolist() {
        return borderInfoList;
    }

    /**
     * 初期元号を取得します。
     *
     * @return 初期元号
     */
    public static String getInitgengo() {
        return initGengo;
    }

    /**
     * スタティックイニシャライザ
     */
    static {
        // 元号情報XML読込
        PNCommonCalendarInfoXml readXml = new PNCommonCalendarInfoXml();
        PNCommonCalendarInfo info = readXml.readGengoInfo();

        // 元号基本情報を設定
        gengoInfoList = info.getGengoInfoList();
        // 境界情報を設定
        borderInfoList = info.getBorderInfoList();
        // 初期元号を設定
        initGengo = info.getInitGengo();
    }
// [ADD] Ver 1.1.0 - END

    /**
     *
     * <pre>
     * nullを0に変換する。
     * 数値がnullでない場合、そのままの値を返却する。
     * </pre>
     *
     * @param 数字
     * @return 数字
     */
    public static BigDecimal cnvNulltoZero(BigDecimal param) {
        if (param == null) {
            return BigDecimal.ZERO;
        }
        return param;
    }

    /**
     *
     * <pre>
     * Entity→DTO転記
     * </pre>
     *
     * @param dest 転記先のDTO
     * @param orig 転記元のEntity
     * @param arrayMapping プロパティのマッピング定義
     * @return
     * @throws CFWReflectionException
     */
    public static void copyPropertiesCustom(PNBaseDTO dest, PNBaseEntity orig, String[][] arrayMapping)
            throws CFWReflectionException {
        for (int i = 0; i < arrayMapping.length; i++) {
            String value = CFWBeanUtils.getProperty(orig, arrayMapping[i][1]);
            CFWBeanUtils.setProperty(dest, arrayMapping[i][0], value);
        }
    }

    /**
     *
     * <pre>
     * DTO→Entity転記
     * </pre>
     *
     * @param dest 転記先のEntity
     * @param orig 転記元のDTO
     * @param arrayMapping プロパティのマッピング定義
     * @return
     * @throws CFWReflectionException
     */
    public static void copyPropertiesCustom(PNBaseEntity dest, PNBaseDTO orig, String[][] arrayMapping)
            throws CFWReflectionException {
        for (int i = 0; i < arrayMapping.length; i++) {
            String value = CFWBeanUtils.getProperty(orig, arrayMapping[i][0]);
            CFWBeanUtils.setProperty(dest, arrayMapping[i][1], value);
        }
    }

    /**
     *
     * <pre>
     * 日付変換
     * 西暦日付（MMDD）を（MM.DD）形式に変換します。
     * 例）
     *   0701⇒.7.1
     * </pre>
     *
     * @param strMMDD 西暦日付（MMDD）
     * @return 日付（MM.DD）
     */
    public static String dateFmtAD_MMDD(String strMMDD) {
        if (null == strMMDD) {
            return "";
        }
        Pattern strPattern = Pattern.compile("^[0-9][0-9][0-9][0-9]$");
        Matcher match = strPattern.matcher(strMMDD);
        if (match.find()) {
            int month = Integer.parseInt(strMMDD.substring(0, 2));
            int day = Integer.parseInt(strMMDD.substring(2, 4));
            return PNCommonComponents.concatString(String.valueOf(month), ".", String.valueOf(day));
        }
        return "";
    }

    /**
     *
     * <pre>
     * システム日付(GYYMMDD)を取得します。
     * </pre>
     *
     * @return システム日付(GYYMMDD)
     */
    public static String getSysDateTimeDay() {

        // 日付書式パターン
        DateFormat dtFormat = new SimpleDateFormat(PNDateUtils.DATE_PATTERN_YYYYMMDD);

        // //////福井チーム修正　Start
        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        // 日付書式パターン
        String sysDateTimeDay = dtFormat.format(PNDateUtils.getSystemDate());
        String wareki = dateFmtAD_YYYYMMDD(sysDateTimeDay);
        // //////福井チーム修正 End

        return wareki;
    }

    /**
     *
     * <pre>
     * システム時間(HH:mm:ss)を取得します。
     * </pre>
     *
     * @return システム時間(HH:mm:ss)
     */
    public static String getSysDateTime() {

        // 日付書式パターン
        DateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");

        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String dateTime = dtFormat.format(PNDateUtils.getSystemDate());

        return dateTime;
    }

    /**
     * <pre>
     * 時刻を形式に従って変換する
     * </pre>
     * @param time String 時刻
     * @return String 変換した時刻データ
     */
    public static String timeFormatConvert(String time) {

        if (time == null || time.length() == 0) {
            return null;
        }

        String convertTime = null;

        String timeHour = time.substring(PNCommonConstants.TIME_HOUR_BEGIN_INDEX,
                PNCommonConstants.TIME_HOUR_END_INDEX);
        String timeMinute = time.substring(PNCommonConstants.TIME_MINUTE_BEGIN_INDEX,
                PNCommonConstants.TIME_MINUTE_END_INDEX);
        String timeSecond = time.substring(PNCommonConstants.TIME_SECOND_BEGIN_INDEX,
                PNCommonConstants.TIME_SECOND_END_INDEX);
        convertTime = timeHour + PNCommonConstants.TIME_SEPARATOR + timeMinute
                + PNCommonConstants.TIME_SEPARATOR + timeSecond;

        return convertTime;
    }

    /**
     * <pre>
     * 1000で割った値を返す。
     * 小数点以下第３位まで（小数点以下第四位以降切り捨て）
     * 引数がnullの場合は"0.000"を返す。
     * 例外発生時はnullを返す。
     * </pre>
     * @param value String 値
     * @return outPercent String 1000で割った値
     */
    public static String mathPercent1000(String value) {

        // 戻り値初期値設定
        String outPercent = null;

        if (null != value && 0 < value.length()) {
            BigDecimal bPercent = null;
            try {
                bPercent = new BigDecimal(value);
                bPercent = mathPercent1000(bPercent);
                outPercent = bPercent.toString();
            }
            catch (NullPointerException e) {
                outPercent = null;
            }
        }
        // 戻り値返却
        return outPercent;
    }

    /**
     * <pre>
     * 1000で割った値を返す。
     * 小数点以下第３位まで（小数点以下第四位以降切り捨て）
     * 引数がnullの場合は"0.000"を返す。
     * 例外発生時はnullを返す。
     * </pre>
     * @param value BigDecimal 値
     * @return outPercent BigDecimal 1000で割った値
     */
    public static BigDecimal mathPercent1000(BigDecimal value) {

        // 戻り値初期値設定
        BigDecimal outPercent = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        try {
            // 引数がnull以外の場合
            if (null != value) {
                // 引数をBigDecimalに変換
                outPercent = value;
            }

            // 引数を1000で割る（小数点以下第四位以降切り捨て）
            outPercent = outPercent.divide(PNCommonConstants.BIGDECIMAL_1000_VALUE).setScale(
                    PNCommonConstants.LENGTH_3, BigDecimal.ROUND_DOWN);
            if (null == outPercent) {
                outPercent = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
            }

        }
        catch (IllegalArgumentException ie) {
            // 例外発生時はnullを戻す。
            outPercent = null;

        }
        catch (ArithmeticException ae) {
            // 例外発生時はnullを戻す。
            outPercent = null;
        }

        // 戻り値返却
        return outPercent;
    }

    /**
     *
     * <pre>
     * 引数で渡された日付が土日であるか否かのチェック処理
     * 非営業日でのチェックではありません。
     * ●引数チェックについて
     * ・引数の日付が8桁（yyyyMMdd）以外は null を返す
     * ・引数の日付が暦上日付でない場合は null を返す
     * ●その他
     * ・土曜日or日曜日 の場合、nullを返す
     * ・月曜日～金曜日 の場合、引数で渡された日付を返す
     * </pre>
     *
     * @param strDate 日付
     * @return String 判定営業日
     */
    public static String chkWeekEndHolidays(String strDate) {

        try {
            // 日付チェック
            if (!checkDate(strDate)) {
                return null;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(strDate.substring(0, 4)));
            calendar.set(Calendar.MONTH, Integer.parseInt(strDate.substring(4, 6)) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate.substring(6, 8)));

            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                return null;
            default:
                return strDate;
            }
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 西暦変換_年 (Gyy⇒YYYY変換)
     *
     * <pre>
     * 和暦年（H01/S64/h01/s64等)を西暦年に変換する。
     * ・元号は小文字も可とする
     * </pre>
     *
     * @param strGyy 和暦年
     * @return String 西暦年
     */
    public static String dateFmtJC_Gyy(String strGyy) {

// [DEL] Ver 1.1.0 - START
//        try {
//            String gyy = strGyy;
//            gyy = String.valueOf(gyy.charAt(0)).toUpperCase()
//                    + String.valueOf(Integer.parseInt(gyy.substring(1)));
//
//            String strDate = "";
//
//            if ("M1".equals(gyy)) {
//                strDate = "M1-09-08";
//            }
//            else if ("M45".equals(gyy) || "T1".equals(gyy)) {
//                strDate = "T1-07-30";
//            }
//            else if ("T15".equals(gyy) || "S1".equals(gyy)) {
//                strDate = "S1-12-25";
//            }
//            else if ("S64".equals(gyy) || "H1".equals(gyy)) {
//                strDate = "H1-01-08";
//            }
//            else {
//                strDate = gyy + "-01-01";
//            }
//
//            DateFormat jpFormat = new SimpleDateFormat("Gy-MM-dd", new Locale("ja", "JP", "JP"));
//            jpFormat.setLenient(false);
//
//            DateFormat format = new SimpleDateFormat("yyyy");
//            return format.format(jpFormat.parse(strDate));
//
//        }
//        catch (ParseException e) {
//            return "";
//        }
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
        try {

            String gyy = strGyy;
            gyy = String.valueOf(gyy.charAt(0)).toUpperCase()
                    + String.format("%2s", Integer.parseInt(gyy.substring(1))).replace(" ", "0");

            String retYear = "";

            // 元号年チェック
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 元号開始年(Gyy)
                String eraStart = info.getEraEn() + "01";
                // 元号終了年(Gyy)
                String eraEnd = info.getEraEn() + String.format("%2s", info.getEndEraYear()).replace(" ", "0");

                // 元号年の比較
                int startCompare = eraStart.compareTo(gyy);
                int endCompare = eraEnd.compareTo(gyy);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 西暦年
                    int year = Integer.parseInt(info.getStartYear()) + Integer.parseInt(gyy.substring(1)) - 1;
                    retYear = String.valueOf(year);

                    break;
                }
            }

            return retYear;

        } catch (Exception e) {
            return "";

        }
// [ADD] Ver 1.1.0 - END
    }

    /**
     * 西暦変換_年月 (Gyymm⇒YYYYMM変換)
     *
     * <pre>
     * 和暦年月を西暦年月に変換する
     * 　・元号は小文字も可とする
     * 　・第1引数に「.」がついていた場合も変換する
     * 　・年月の間に第2引数で指定した区切り文字を設定する
     * 　　不要な場合は空文字を指定する
     * </pre>
     *
     * @param strGyymm 和暦年月
     * @param strDelimiter 区切り文字
     * @return String 西暦年月
     */
    public static String dateFmtJC_Gyymm(String strGyymm, String strDelimiter) {

        try {
            String gyymm = strGyymm;
            String gengou = "";
            String yy = "";
            String mm = "";

            if (gyymm.indexOf(".") == -1) {
                gengou = String.valueOf(gyymm.charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(gyymm.substring(1, gyymm.length() - 2)));
                mm = strGyymm.substring(gyymm.length() - 2);

            }
            else {
                String[] tmp = gyymm.split("\\.");
                gengou = String.valueOf(tmp[0].charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(tmp[0].substring(1)));
                mm = tmp[1];

            }
// [ADD] Ver 1.1.0 - START
            yy = String.format("%2s", yy).replace(" ", "0");
            mm = String.format("%2s", mm).replace(" ", "0");
// [ADD] Ver 1.1.0 - END
            gyymm = gengou + yy + "-" + mm;

            String strDate = "";

// [DEL] Ver 1.1.0 - START
//            if ("M1-09".equals(gyymm)) {
//                strDate = "M1-09-08";
//            }
//            else if ("M45-07".equals(gyymm)) {
//                strDate = "T1-07-29";
//            }
//            else if ("T1-07".equals(gyymm)) {
//                strDate = "T1-07-30";
//            }
//            else if ("T15-12".equals(gyymm)) {
//                strDate = "T1-12-24";
//            }
//            else if ("S1-12".equals(gyymm)) {
//                strDate = "S1-12-25";
//            }
//            else if ("S64-01".equals(gyymm)) {
//                strDate = "S64-01-07";
//            }
//            else if ("H1-01".equals(gyymm)) {
//                strDate = "H1-01-08";
//            }
//            else {
//                strDate = gyymm + "-01";
//            }
//
//            String repDelimiter = strDelimiter != null ? strDelimiter : "";
//
//            DateFormat jpFormat = new SimpleDateFormat("Gy-MM-dd", new Locale("ja", "JP", "JP"));
//            jpFormat.setLenient(false);
//
//            DateFormat format = new SimpleDateFormat("yyyy" + repDelimiter + "MM");
//
//            return format.format(jpFormat.parse(strDate));
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
            // 元号年月チェック
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 元号開始年月(GyyMM)
                String eraStart = info.getEraEn() + "01" + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0");
                // 元号終了年月(GyyMM)
                String eraEnd = info.getEraEn() + String.format("%2s", info.getEndEraYear()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getEndMonth()).replace(" ", "0");

                // 元号年月の比較
                int startCompare = eraStart.compareTo(gyymm);
                int endCompare = eraEnd.compareTo(gyymm);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 西暦年
                    int year = Integer.parseInt(info.getStartYear()) + Integer.parseInt(yy) - 1;

                    // 区切り文字チェック
                    String repDelimiter = strDelimiter;
                    if (repDelimiter == null) {
                        repDelimiter = "";
                    }
                    strDate = String.valueOf(year) + repDelimiter + mm;

                    break;
                }
            }

            return strDate;
// [ADD] Ver 1.1.0 - END

        }
        catch (IllegalArgumentException ie) {
            return "";
        }
        catch (NullPointerException ne) {
            return "";
        }
// [UPD] Ver 1.1.0 - START
//        catch (ParseException pe) {
        catch (Exception e) {
// [UPD] Ver 1.1.0 - END
            return "";
        }
    }

// [ADD] Ver 1.1.0 - START
    /**
     * 西暦変換_年月 (Gyymm⇒YYYYMMDD変換)
     *
     * <pre>
     * 和暦年月を西暦年月日に変換する
     * 　・元号は小文字も可とする
     * 　・第1引数に「.」がついていた場合も変換する
     * 　・年月の間に第2引数で指定した区切り文字を設定する
     * 　　不要な場合は空文字を指定する
     * </pre>
     *
     * @param strGyymm 和暦年月
     * @param strDelimiter 区切り文字
     * @return String 西暦年月日
     */
    public static String dateFmtJC_GyymmToYYYYMMDD(String strGyymm, String strDelimiter) {

        try {
            String gyymm = strGyymm;
            String gengou = "";
            String yy = "";
            String mm = "";

            if (gyymm.indexOf(".") == -1) {
                gengou = String.valueOf(gyymm.charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(gyymm.substring(1, gyymm.length() - 2)));
                mm = strGyymm.substring(gyymm.length() - 2);

            }
            else {
                String[] tmp = gyymm.split("\\.");
                gengou = String.valueOf(tmp[0].charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(tmp[0].substring(1)));
                mm = tmp[1];

            }
            yy = String.format("%2s", yy).replace(" ", "0");
            mm = String.format("%2s", mm).replace(" ", "0");

            gyymm = gengou + yy + "-" + mm;
            String strDate = "";

            // 元号年月チェック
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 元号開始年月(GyyMM)
                String eraStart = info.getEraEn() + "01" + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0");
                // 元号終了年月(GyyMM)
                String eraEnd = info.getEraEn() + String.format("%2s", info.getEndEraYear()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getEndMonth()).replace(" ", "0");

                // 元号年月の比較
                int startCompare = eraStart.compareTo(gyymm);
                int endCompare = eraEnd.compareTo(gyymm);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 西暦年
                    int year = Integer.parseInt(info.getStartYear()) + Integer.parseInt(yy) - 1;

                    // 区切り文字チェック
                    String repDelimiter = strDelimiter;
                    if (repDelimiter == null) {
                        repDelimiter = "";
                    }
                    strDate = String.valueOf(year) + repDelimiter + mm;
                    if (startCompare == 0) {
                        // 変換対象の日付が元号開始年月の場合、日付を元号開始日で補完する
                        strDate += String.format("%2s", info.getStartDay()).replace(" ", "0");
                    }
                    else {
                        // 上記以外の場合、日付を1日で補完する
                        strDate += "01";
                    }

                    break;
                }
            }

            return strDate;

        }
        catch (IllegalArgumentException ie) {
            return "";
        }
        catch (NullPointerException ne) {
            return "";
        }
        catch (Exception e) {
            return "";
        }
    }
// [ADD] Ver 1.1.0 - END

    /**
     * 西暦変換_年月日 (Gyymmdd⇒YYYYMMDD変換)
     *
     * <pre>
     * 和暦年月を西暦年月に変換する
     * 　・元号は小文字も可とする
     * 　・第1引数に「.」がついていた場合も変換する
     * 　・年月の間に第2引数で指定した区切り文字を設定する
     * 　　不要な場合は空文字を指定する
     * </pre>
     *
     * @param strGyymmdd 和暦年月日
     * @param strDelimiter 区切り文字
     * @return String 西暦年月
     */
    public static String dateFmtJC_Gyymmdd(String strGyymmdd, String strDelimiter) {

        try {
            String gyymmdd = strGyymmdd;
            String gengou = "";
            String yy = "";
            String mm = "";
            String dd = "";

            if (gyymmdd.indexOf(".") == -1) {
                gengou = String.valueOf(gyymmdd.charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(gyymmdd.substring(1, gyymmdd.length() - 4)));
                mm = gyymmdd.substring(gyymmdd.length() - 4, gyymmdd.length() - 2);
                dd = gyymmdd.substring(gyymmdd.length() - 2);

            }
            else {
                String[] tmp = gyymmdd.split("\\.");
                gengou = String.valueOf(tmp[0].charAt(0)).toUpperCase();
                yy = String.valueOf(Integer.parseInt(tmp[0].substring(1)));
                mm = tmp[1];
                dd = tmp[2];

            }
// [ADD] Ver 1.1.0 - START
            yy = String.format("%2s", yy).replace(" ", "0");
            mm = String.format("%2s", mm).replace(" ", "0");
            dd = String.format("%2s", dd).replace(" ", "0");
// [ADD] Ver 1.1.0 - END
            gyymmdd = gengou + yy + "-" + mm + "-" + dd;

// [UPD] Ver 1.1.0 - START
//            String strDate = gyymmdd;
            String strDate = "";
// [UPD] Ver 1.1.0 - END

            String repDelimiter = strDelimiter != null ? strDelimiter : "";

// [UPD] Ver 1.1.0 - START
//            DateFormat jpFormat = new SimpleDateFormat("Gy-MM-dd", new Locale("ja", "JP", "JP"));
//            jpFormat.setLenient(false);
//
//            DateFormat format = new SimpleDateFormat("yyyy" + repDelimiter + "MM" + repDelimiter + "dd");
//
//            return format.format(jpFormat.parse(strDate));

            // 元号年月チェック
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 元号開始年月日(GyyMMdd)
                String eraStart = info.getEraEn() + "01" + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getStartDay()).replace(" ", "0");
                // 元号終了年月日(GyyMMdd)
                String eraEnd = info.getEraEn() + String.format("%2s", info.getEndEraYear()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getEndMonth()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getEndDay()).replace(" ", "0");

                // 元号年月日の比較
                int startCompare = eraStart.compareTo(gyymmdd);
                int endCompare = eraEnd.compareTo(gyymmdd);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 西暦年
                    int year = Integer.parseInt(info.getStartYear()) + Integer.parseInt(yy) - 1;
                    strDate = String.valueOf(year) + repDelimiter + mm + repDelimiter + dd;

                    break;
                }
            }

            return strDate;
// [UPD] Ver 1.1.0 - END
        }
        catch (IllegalArgumentException ie) {
            return "";
        }
        catch (NullPointerException ne) {
            return "";
        }
// [UPD] Ver 1.1.0 - START
//        catch (ParseException pe) {
        catch (Exception e) {
// [UPD] Ver 1.1.0 - END
            return "";
        }
    }

    /**
     * 和暦変換_年 (YYYY⇒Gyy変換)
     *
     * <pre>
     * 西暦年（1868/2015)を和暦年に変換する。
     * </pre>
     *
     * @param strYYYY 西暦年
     * @return String 和暦年
     */
    public static String dateFmtAD_YYYY(String strYYYY) {

// [DEL] Ver 1.1.0 - START
//        try {
//            String strDate = "";
//
//            if ("1868".equals(strYYYY)) {
//                strDate = "1868-09-08";
//            }
//            else if ("1912".equals(strYYYY)) {
//                strDate = "1912-07-30";
//            }
//            else if ("1926".equals(strYYYY)) {
//                strDate = "1926-12-25";
//            }
//            else if ("1989".equals(strYYYY)) {
//                strDate = "1989-01-08";
//            }
//            else {
//                strDate = strYYYY + "-01-01";
//            }
//
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            format.setLenient(false);
//
//            // DateFormat jpFormat = new SimpleDateFormat("Gyy", new
//            // Locale("ja", "JP", "JP"));
//            DateFormat jpFormat = new SimpleDateFormat("Gy", new Locale("ja", "JP", "JP"));
//            return jpFormat.format(format.parse(strDate));
//
//        }
//        catch (ParseException e) {
//            return "";
//        }
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
        try {

            String eraYear = "";

            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 西暦開始年
                String startYear = info.getStartYear();
                // 西暦終了年
                String endYear = info.getEndYear();

                // 西暦年の比較
                int startCompare = startYear.compareTo(strYYYY);
                int endCompare = endYear.compareTo(strYYYY);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 和暦年
                    int year = Integer.parseInt(strYYYY) - Integer.parseInt(startYear) + 1;
                    // 元号＋和暦年
                    eraYear = info.getEraEn() + String.valueOf(year);

                }
            }

            return convertGengoYear(eraYear);

        } catch (Exception e) {
            return "";
        }
// [ADD] Ver 1.1.0 - END
    }

    /**
     * 和暦変換_年月 (YYYYMM⇒Gyy.mm変換)
     *
     * <pre>
     * 西暦年月を和暦年月に変換する。
     * 　・元号は大文字に変換する
     * 　・第1引数に「/」がついていた場合も変換する
     * </pre>
     *
     * @param strYYYYMM 西暦年月
     * @return String 和暦年月
     */
    public static String dateFmtAD_YYYYMM(String strYYYYMM) {

        try {
            String stryymm = strYYYYMM;
            if (stryymm.indexOf("/") == -1) {
                String yy = stryymm.substring(0, stryymm.length() - 2);
                String mm = stryymm.substring(stryymm.length() - 2);
                stryymm = yy + "-" + mm;
            }
            else {
// [UPD] Ver 1.1.0 - START
//                stryymm = stryymm.replaceAll("\\/", "-");
                stryymm = strYYYYMM.split("\\/")[0] + "-"
                        + String.format("%2s", strYYYYMM.split("\\/")[1]).replace(" ", "0");
// [UPD] Ver 1.1.0 - END
            }

            String strDate = "";

// [DEL] Ver 1.1.0 - START
//            if ("1868-09".equals(stryymm)) {
//                strDate = "1868-09-08";
//            }
//            else if ("1912-07".equals(stryymm)) {
//                strDate = "1912-07-30";
//            }
//            else if ("1926-12".equals(stryymm)) {
//                strDate = "1926-12-25";
//            }
//            else if ("1989-01".equals(stryymm)) {
//                strDate = "1989-01-08";
//            }
//            else {
//                strDate = stryymm + "-01";
//            }
//
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            format.setLenient(false);
//
//            // DateFormat jpFormat = new SimpleDateFormat("Gyy.MM", new
//            // Locale("ja", "JP", "JP"));
//            DateFormat jpFormat = new SimpleDateFormat("Gy.M", new Locale("ja", "JP", "JP"));
//
//            return jpFormat.format(format.parse(strDate));
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 西暦開始年月
                String startYM = info.getStartYear() + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0");
                // 西暦終了年月
                String endYM = info.getEndYear() + "-" + String.format("%2s", info.getEndMonth()).replace(" ", "0");

                // 西暦年の比較
                int startCompare = startYM.compareTo(stryymm);
                int endCompare = endYM.compareTo(stryymm);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 和暦年
                    int year = Integer.parseInt(stryymm.substring(0, 4)) - Integer.parseInt(info.getStartYear()) + 1;
                    // 元号＋和暦年月
                    strDate = info.getEraEn() + String.valueOf(year) + "."
                            + zeroSuppressLeft(stryymm.substring(stryymm.length() - 2));
                }
            }

            return strDate;
// [ADD] Ver 1.1.0 - END

        }
        catch (IllegalArgumentException ie) {
            return "";
        }
        catch (NullPointerException ne) {
            return "";
        }
// [UPD] Ver 1.1.0 - START
//        catch (ParseException pe) {
        catch (Exception e) {
// [UPD] Ver 1.1.0 - END
            return "";
        }
    }

    /**
     * 和暦変換_年 (YYYYMMDD⇒Gyy.mm.dd変換)
     *
     * <pre>
     * 西暦年月日を和暦年月日に変換する。
     * 　・元号は大文字に変換する
     * 　・第1引数に「/」がついていた場合も変換する
     *
     * </pre>
     *
     * @param strYYYYMMDD
     * @return String 和暦年月日
     */
    public static String dateFmtAD_YYYYMMDD(String strYYYYMMDD) {

        try {
            String strDate = "";

            if (strYYYYMMDD.indexOf("/") == -1) {
                String yy = strYYYYMMDD.substring(0, 4);
                String mm = strYYYYMMDD.substring(strYYYYMMDD.length() - 4, strYYYYMMDD.length() - 2);
                String dd = strYYYYMMDD.substring(strYYYYMMDD.length() - 2);
                strDate = yy + "-" + mm + "-" + dd;
            }
            else {
// [UPD] Ver 1.1.0 - START
//                strDate = strYYYYMMDD.replaceAll("\\/", "-");
                strDate = strYYYYMMDD.split("\\/")[0] + "-"
                        + String.format("%2s", strYYYYMMDD.split("\\/")[1]).replace(" ", "0") + "-"
                        + String.format("%2s", strYYYYMMDD.split("\\/")[2]).replace(" ", "0");
// [UPD] Ver 1.1.0 - START
            }

// [DEL] Ver 1.1.0 - START
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            format.setLenient(false);
//
//            // DateFormat jpFormat = new SimpleDateFormat("Gyy.MM.dd", new
//            // Locale("ja", "JP", "JP"));
//            DateFormat jpFormat = new SimpleDateFormat("Gy.M.d", new Locale("ja", "JP", "JP"));
//
//            return jpFormat.format(format.parse(strDate));
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 西暦開始年月日
                String startYMD = info.getStartYear() + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getStartDay()).replace(" ", "0");
                // 西暦終了年月日
                String endYMD = info.getEndYear() + "-" + String.format("%2s", info.getEndMonth()).replace(" ", "0")
                        + "-" + String.format("%2s", info.getEndDay()).replace(" ", "0");

                // 西暦年の比較
                int startCompare = startYMD.compareTo(strDate);
                int endCompare = endYMD.compareTo(strDate);

                if (startCompare <= 0 && endCompare >= 0) {

                    // 和暦年
                    int year = Integer.parseInt(strDate.substring(0, 4)) - Integer.parseInt(info.getStartYear()) + 1;
                    // 元号＋和暦年月日
                    String mm = strDate.substring(strDate.length() - 5, strDate.length() - 3);
                    String dd = strDate.substring(strDate.length() - 2);
                    strDate = info.getEraEn() + String.valueOf(year) + "." + zeroSuppressLeft(mm) + "."
                            + zeroSuppressLeft(dd);

                    break;
                }
            }

            return strDate;
// [ADD] Ver 1.1.0 - END

        }
        catch (IllegalArgumentException ie) {
            return "";
        }
        catch (NullPointerException ne) {
            return "";
        }
// [ADD] Ver 1.1.0 - START
//        catch (ParseException pe) {
        catch (Exception e) {
// [ADD] Ver 1.1.0 - END
            return "";
        }
    }

    /**
     * メッセージ取得（置換文字列あり）
     *
     * <pre>
     * 引数のメッセージIDで取得したメッセージをの所定の位置の文字を、引数の置換文字列で置換する。
     * 例）
     * 取得したメッセージ："本案件の利子助成対象期間は{0}～{1}です。"
     * 置換文字列（String配列）：["H27.7.17","H27.10.31"]
     * ↓
     * 戻り値："本案件の利子助成対象期間はH27.7.17～H27.10.31です。"
     * </pre>
     *
     * @param messageId メッセージID
     * @param parameters 置換文字列
     * @return String メッセージ文字列
     */
    public static String getMsg(String messageId, String[] parameters) {

        String strMsg = PNMessageUtils.getString(messageId);

        if (parameters != null && parameters.length != 0) {
            for (int i = 0; i < parameters.length; i++) {
                strMsg = strMsg.replaceAll("\\{" + i + "\\}", parameters[i]);
            }
        }

        return strMsg;
    }

    /**
     * nullをブランク文字列に変換する
     *
     * <pre>
     * nullをブランク文字列に変換する。
     * 文字列がnullでない場合、そのままの値を返却する。
     * </pre>
     *
     * @param strMoji
     * @return String 文字列
     */
    public static String cnvNulltoBlank(String strMoji) {
        return strMoji == null ? "" : strMoji;
    }

    /**
     * nullを0に変換する
     *
     * <pre>
     * nullを0に変換する。
     * 数値がnullでない場合、そのままの値を返却する。
     * </pre>
     *
     * @param intSuchi 数値
     * @return
     */
    public static int cnvNulltoZero(Integer intSuchi) {
        return intSuchi == null ? 0 : intSuchi;
    }

    /**
     * 事業別コードチェック
     *
     * <pre>
     * １，２文字目が半角英数または半角カナ以外※１の場合エラー
     * ※１：ここでの半角カナには濁音、半濁音、長音、撥音を含まないものとする。
     * </pre>
     *
     * @param strMoji
     * @return boolean チェック結果
     */
    public static boolean chkJigyobetsuCd(String strMoji) {

        try {
            // NULLチェック
            if (strMoji == null) {
                return false;
            }
            // 桁数チェック
            if (strMoji.length() != 2) {
                return false;
            }
            // 正規表現チェック
            Pattern pattern = Pattern.compile("^[0-9A-Za-zｱ-ｿﾀ-ﾖﾜｦﾝ]+$");
            Matcher matcher = pattern.matcher(strMoji);
            if (!matcher.find()) {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 有効日付チェック
     *
     * <pre>
     * 引数の日付が8桁の場合、
     * 引数の日付が有効であるかのチェックを行う。
     *
     * 20150229→NG
     * 20150230→NG
     * 20150817→OK
     * </pre>
     *
     * @param strDate チェック対象日付 YYYYMMDD
     * @return
     */
    public static boolean checkDate(String strDate) {

        try {
            if (StringUtils.isEmpty(strDate) || strDate.length() != 8) {
                return false;
            }

            // 日付が正しいかチェックする。
            DateFormat dt = new SimpleDateFormat("yyyyMMdd");
            dt.setLenient(false);
            dt.parse(strDate);

        }
        catch (Exception e) {
            // 例外発生時は握りつぶし、falseを返す
            return false;
        }
        return true;
    }

    /**
     * 1ヶ月以内チェック
     *
     * <pre>
     * 引数の日付が8桁の場合、
     * 1か月以内の日付であるかチェックを行う。
     *
     * 引数日付　≦　（サーバ日付＋１ヶ月－１日）
     * </pre>
     *
     * @param strDate
     * @return
     */
    public static boolean checkWithinOneMonth(String strDate) {

        try {
            if (!checkDate(strDate)) {
                return false;
            }
            int targetDate = Integer.parseInt(strDate);

            DateFormat dt = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            int today = Integer.parseInt(dt.format(calendar.getTime()));

            calendar.add(Calendar.MONTH, 1);

            int nextMonthDate = Integer.parseInt(dt.format(calendar.getTime()));

            if (targetDate >= today && targetDate < nextMonthDate) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    // //////////////////////福井チーム追加 Start
    /**
     *
     * <pre>
     * String型をBigDecimal型に型変換します。
     * 引数がnullの場合0を返します。
     * 引数が数字に変換できない場合は、nullを返します。
     * </pre>
     *
     * @param 文字列
     * @return 数字
     */
    public static BigDecimal cnvStrtoBig(String param) {
        // 戻り値準備
        BigDecimal ret = null;
        // 引数がnulの場合は0を返す。
        if (param == null) {
            return BigDecimal.ZERO;
        }
        try {
            // 引数をBigdecimalに変換
            ret = new BigDecimal(param);
        }
        catch (Exception e) {
            // 例外発生時はnullを戻す。
            ret = null;
        }
        return ret;
    }

    /**
     *
     * <pre>
     * 引数のString配列を結合します。
     * </pre>
     *
     * @param 文字列配列
     * @return 結合文字列
     */
    public static String concatString(String... param) {

        StringBuffer sb = new StringBuffer();
        for (String str : param) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     *
     * <pre>
     * 引数のStringオブジェクトがNULL又は空の場合、'0'の文字列を返します。
     * </pre>
     *
     * @param 文字列
     * @return 文字列
     */
    public static String cnvNulltoZero(String param) {
        if (param == null || param.length() == 0) {
            param = "0";
        }
        return param;
    }

    // //////////////////////福井チーム追加 End

    /**
     * 時間変換
     *
     * <pre>
     * 時刻を形式に従って変換する
     * </pre>
     * @param time Timestamp 変換対象時刻
     * @return String 変換した時刻データ
     */
    public static String timeFormatConvert(Timestamp time) {

        if (time == null) {
            return null;
        }

        String convertTime = null;
        convertTime = new SimpleDateFormat("HH:mm:ss").format(time);

        String timeHour = convertTime.substring(PNCommonConstants.TIME_HOUR_BEGIN_INDEX,
                PNCommonConstants.TIME_HOUR_END_INDEX);
        String timeMinute = convertTime.substring(PNCommonConstants.TIME_MINUTE_BEGIN_INDEX + 1,
                PNCommonConstants.TIME_MINUTE_END_INDEX + 1);
        String timeSecond = convertTime.substring(PNCommonConstants.TIME_SECOND_BEGIN_INDEX + 2,
                PNCommonConstants.TIME_SECOND_END_INDEX + 2);
        convertTime = timeHour + PNCommonConstants.TIME_SEPARATOR + timeMinute
                + PNCommonConstants.TIME_SEPARATOR + timeSecond;

        return convertTime;
    }

    /**
     * 半角数値チェック
     *
     * <pre>
     * 引数の文字列が引数の整数部桁数、小数部桁数、小数部省略可否、マイナス可否で指定した形式、値であるかの判定を行う。
     * </pre>
     *
     * @param strCheck String チェック対象の文字列
     * @param seisu int 整数部桁数
     * @param syousu int 小数部桁数
     * @param syouryaku boolean 小数部省略可否
     * @param minus boolean マイナス可否
     * @return boolean 判定結果
     */
    public static boolean checkHalfNum(String strCheck, int seisu, int syousu, boolean syouryaku,
            boolean minus) {

        boolean checkResult = true;

        String strSeisu = "";
        String strSyousu = "";

        try {
            // 整数部と小数部に分割
            String[] suchi = strCheck.replace("-", "").replace(".", ":").split(":");

            // 分割結果がない場合、整数部のみ
            if (suchi.length < 2) {
                strSeisu = strCheck.replace("-", "");
            }
            else {
                strSeisu = suchi[0];
                strSyousu = suchi[1];
            }

            // 整数桁桁数チェック
            if (strSeisu.length() > seisu) {
                checkResult = false;
                return checkResult;
            }

            // 小数桁桁数チェック
            if (strSyousu.length() > syousu) {
                checkResult = false;
                return checkResult;
            }

            // 小数部省略可否チェック
            if (syouryaku == false) {
                if (strSyousu.length() < 1) {
                    checkResult = false;
                    return checkResult;
                }
            }

            // マイナス可否チェック
            if (minus == false) {
                double dval = Double.parseDouble(strCheck);
                if (dval < 0) {
                    checkResult = false;
                    return checkResult;
                }
            }
        }
        catch (Exception e) {
            return false;
        }

        return checkResult;
    }

    /**
     * 年度末日算出
     *
     * <pre>
     * 基準月が、１，２，３月の場合、基準年から－１した３/３１とする。
     * 上記以外は、基準年の３／３１とする。
     * </pre>
     *
     * @param strYear 基準年
     * @param strMonth 基準月
     * @return yyyy/MM/dd形式
     */
    public static String getNendoMatsujitu(String strYear, String strMonth) {

        String result = "";
        try {
            int year = Integer.parseInt(strYear);
            int month = Integer.parseInt(strMonth);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            if (1 <= month && 3 >= month) {
                cal.add(Calendar.YEAR, -1);
            }
            result = String.valueOf(cal.get(Calendar.YEAR)) + "/03/31";
        }
        catch (Exception e) {
        }
        return result;
    }

    /**
     * 年度初日算出
     *
     * <pre>
     * 基準月が、１，２，３月の場合、基準年から－１した４/１とする。
     * 上記以外は、基準年の４／１とする。
     * </pre>
     *
     * @param strYear 基準年
     * @param strMonth 基準月
     * @return yyyy/MM/dd形式
     */
    public static String getNendoHajime(String strYear, String strMonth) {

        String result = "";
        try {
            int year = Integer.parseInt(strYear);
            int month = Integer.parseInt(strMonth);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            if (1 <= month && 3 >= month) {
                cal.add(Calendar.YEAR, -1);
            }
            result = String.valueOf(cal.get(Calendar.YEAR)) + "/04/01";
        }
        catch (Exception e) {
        }
        return result;

    }

    /**
     * ファイル削除
     *
     * <pre>
     * ファイルを削除します。
     * </pre>
     *
     * @param file ファイル
     * @return 削除結果 true:正常 false:異常
     */
    public static boolean deleteFile(final File file) {

        if (!file.exists()) {
            return false;
        }
        return file.delete();

    }

    /**
     * 日付比較
     *
     * <pre>
     * 二つの日付を比較した結果を返却する。
     * true : 等しい。(両方nullも含む)
     * false : 等しくない。(いずれかがnullも含む)
     * ミリ秒を比較対象外とする。
     * </pre>
     *
     * @param date1 比較対象の日付 フォーマット(yyyy-MM-dd HH:mm:ss) String型
     * @param date2 比較先の日付 フォーマット(yyyy-MM-dd HH:mm:ss) String型
     *
     * @return boolean
     */
    public static boolean diffDate(String date1, String date2) {

        if (date1 == null && date2 == null) {
            return true;
        }

        if (date1 == null || date2 == null) {
            return false;
        }

        return diffDateImpl(date1, date2);

    }

    /**
     * 日付比較
     *
     * <pre>
     * 二つの日付を比較した結果を返却する。
     * true : 等しい。(両方nullも含む)
     * false : 等しくない。(いずれかがnullも含む)
     * ミリ秒を比較対象外とする。
     * </pre>
     *
     * @param date1 比較対象の日付 フォーマット(yyyy-MM-dd HH:mm:ss) String型
     * @param date2 比較先の日付 フォーマット(yyyy-MM-dd HH:mm:ss) TimeStamp型
     *
     * @return boolean
     */
    public static boolean diffDate(String date1, java.sql.Timestamp date2) {

        if (date1 == null && date2 == null) {
            return true;
        }

        if (date1 == null || date2 == null) {
            return false;
        }

        try {

            String date2Str = date2.toString();
            return diffDateImpl(date1, date2Str);

        }
        catch (Exception e) {
            // あえてParseExceptionではなく、Exceptionでcatchする
            // 握りつぶしてfalseを返す
        }

        return false;
    }

    /**
     * 資金使途名を指定の長さで返却する。 文字列が最大値以上(15文字)の場合、指定の長さ(15文字)で返却します。
     *
     *
     * @param shikinShitoName
     * @return
     */
    public static String cutNameShikinShito(String shikinShitoName) {
        return cutString(shikinShitoName, 15, true);
    }

    /**
     * 指定文字列を指定の長さで返却する。 文字列が最大値以上の場合、指定の長さで返却します。
     *
     * @param shikinShitoName
     * @return
     */
    public static String cutString(String str, int length, boolean isBlank) {
        if (StringUtils.isEmpty(str)) {
            if (isBlank) {
                return cnvNulltoBlank(str);
            }
            return str;
        }
        if (str.length() > length) {
            return str.substring(0, length);
        }
        return str;
    }

    /**
     * 日付比較（実装）
     *
     * <pre>
     * diffDateから呼び出される
     * 二つの日付を比較した結果を返却する。
     * true : 等しい。(両方nullも含む)
     * false : 等しくない。(いずれかがnullも含む)
     * ミリ秒を比較対象外とする。
     * </pre>
     *
     *
     * @return boolean
     */
    private static boolean diffDateImpl(String date1, String date2) {

        String[] split = date1.split("\\.");
        String value = split[0];

        String[] split2 = date2.toString().split("\\.");
        String value2 = split2[0];

        if (value.equals(value2)) {
            return true;
        }

        return false;
    }

    /**
     * <pre>
     * String形式の日付（yyyyMMdd）をCalendarオブジェクトに変換します。
     * HH:MM:SSは00:00:00
     * </pre>
     *
     * @return Calendar
     */
    public static Calendar strToCal(String str) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(str.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.parseInt(str.substring(4, 6)) - 1);
        cal.set(Calendar.DATE, Integer.parseInt(str.substring(6, 8)));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;

    }

    /**
     * <pre>
     * Calendar形式の日付（YYYYMMDD）をStringオブジェクトに変換します。
     * </pre>
     *
     * @return String yyyyMMdd形式
     */
    public static String calToStr(Calendar cal) {
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());

    }

    /**
     * 和暦変換(漢字区切り)_年月 (YYYYMM⇒Gy年M月変換)
     * @param strYYYYMM
     * @return String Gy年M月
     */
    public static String dateFmtJC_Kanzi_YYYYMM(String strYYYYMM) {
// [UPD] Ver 1.1.0 - START
//        String strDD = String.format("%02d", 1);
//        SimpleDateFormat sdf = new SimpleDateFormat("Gy年M月", new Locale("ja", "JP", "JP"));
//        Calendar cal = strToCal(concatString(strYYYYMM, strDD));
//        return sdf.format(cal.getTime());
        String convGyM = dateFmtAD_YYYYMM(strYYYYMM);
        String[] arr = convGyM.split("\\.");
        return concatString(arr[0], "年", arr[1], "月");
// [UPD] Ver 1.1.0 - END
    }

 // [ADD] Ver 1.1.0 - START
    /**
     * 和暦変換(漢字区切り)_年月日 (YYYYMMDD⇒Gy年M月D日変換)
     * @param strYYYYMMDD
     * @return String Gy年M月D日
     */
    public static String dateFmtJC_Kanzi_YYYYMMDD(String strYYYYMMDD) {
        String convGyMD = dateFmtAD_YYYYMMDD(strYYYYMMDD);
        String[] arr = convGyMD.split("\\.");
        return concatString(arr[0], "年", arr[1], "月", arr[2], "日");
    }
 // [ADD] Ver 1.1.0 - END

    /**
     * 和暦変換(スラッシュ区切り)_年月日 (YYYYMMDD⇒Gy/M/d月変換)
     * @param strYYYYMMDD
     * @return String Gy/M/d
     */
    public static String dateFmtJC_Slash_YYYYMMDD(String strYYYYMMDD) {
// [DEL] Ver 1.1.0 - START
//        SimpleDateFormat sdf = new SimpleDateFormat("Gy/M/d", new Locale("ja", "JP", "JP"));
//        Calendar cal = strToCal(concatString(strYYYYMMDD));
//        return sdf.format(cal.getTime());
// [DEL] Ver 1.1.0 - END
// [ADD] Ver 1.1.0 - START
        String convGyMd = dateFmtAD_YYYYMMDD(strYYYYMMDD);
        convGyMd = convGyMd.replace(".", "/");
        return convGyMd;
// [ADD] Ver 1.1.0 - END
    }

    /**
     * 日付間の差分月数を返す
     * @param date1（YYYYMM形式）
     * @param date2（YYYYMM形式）
     * @return String 差分月数
     */
    public static int diffMonthYYYYMM(String date1, String date2) {

        int date1_YYYY = Integer.parseInt(date1.substring(
                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_YEAR_END_INDEX));
        int date1_MM = Integer.parseInt(date1.substring(
                PNCommonConstants.DATE1_MONTH_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX));
        int date2_YYYY = Integer.parseInt(date2.substring(
                PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_YEAR_END_INDEX));
        int date2_MM = Integer.parseInt(date2.substring(
                PNCommonConstants.DATE1_MONTH_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX));

        return (date1_YYYY - date2_YYYY) * 12 + date1_MM - date2_MM;

    }
// [ADD] Ver 1.1.0 - START
    /**
     * 元号指定チェック
     *
     * <pre>
     * 元号年(Gyy)の項目に対してのみ実施してください。
     * 元号年月(GyyMM)や元号年月日(GyyMMdd)には使用しないでください。
     * </pre>
     *
     * @param data
     *            元号年(Gyy)
     * @param mode
     *            モード(0:大文字・小文字、1:大文字のみ)
     * @param parameter
     *            メッセージ置換文言
     * @param bizErrors
     *            エラー情報
     */
    public static void checkGengoAppoint(String data, int mode, String[] parameter, List<PNMessageInfo> bizErrors) {

        // 引数チェック
        if (null == parameter || data == null) {
            throw new IllegalArgumentException();
        }

        // 元号と和暦年
        String gengo = data.substring(0, 1);
        String year = String.format("%02d", Integer.parseInt(data.substring(1)));

        // 小文字を大文字に変換する
        if (mode == 0) {
            gengo = gengo.toUpperCase();
        }

        // 元号＋年を比較する
        for (PNCommonCalendarBorderInfo info : borderInfoList) {

            // 境界値を取得
            String borderGengo = info.getEra();
            String borderYear = info.getYear();

            // 境界値をチェック
            if (borderGengo.equals(gengo) && borderYear.equals(year)) {

                // エラーメッセージのパラメータ追加
                String[] errMsg = { parameter[0], borderGengo + borderYear, info.getConv() };
                // エラー追加
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3292E, errMsg, false));
                break;
            }
        }

        return;
    }

    /**
     * 元号指定変換
     * <pre>
     * システム的に使用しない元号年を使用できる元号年に変換します。
     * </pre
     * @param data チェック文字列(Gyy)
     * @return ret 変換後元号年
     */
    public static String convertGengoYear(String data) {

        // 復帰値
        String ret = data;

        // 元号と和暦年
        String eraYear = data.substring(0, 1) + String.format("%02d", Integer.parseInt(data.substring(1)));

        // 元号＋年を比較する
        for (PNCommonCalendarBorderInfo info : borderInfoList) {

            // 境界値を取得(Gyy)
            String border = info.getEra() + info.getYear();

            // 境界値をチェック
            if (border.equals(eraYear)) {

                ret = (info.getConv()).substring(0, 1) + String.valueOf(Integer.parseInt((info.getConv()).substring(1)));
                break;
            }
        }

        return ret;
    }

    /**
     * 元号チェック
     *
     * @param data
     *            元号アルファベット
     * @param mode
     *            モード(0:大文字・小文字、1:大文字のみ)
     * @return boolean チェック結果(true:OK, false:NG)
     */
    public static boolean checkGengoAlphabet(String data, int mode) {

        // 戻り値
        boolean ret = false;

        // 引数チェック
        if (data == null) {
            throw new IllegalArgumentException();
        }

        // 小文字を大文字に変換する
        if (mode == 0) {
            data = data.toUpperCase();
        }

        // 元号アルファベットと比較する
        for (PNCommonCalendarGengoInfo info : gengoInfoList) {

            // 元号アルファベットチェック
            String eraEn = info.getEraEn();
            if (eraEn.equals(data)) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    /**
     * 文字列の頭の"0"を取り除きます
     *
     * @param data
     *            文字列
     * @return String ゼロサプレス後文字列
     */
    public static String zeroSuppressLeft(String data) {

        return data.replaceFirst("^0+", "");

    }

    /**
     * 指定日付範囲内の和暦（年）のリストを返却します
     *
     * @param inFromDate
     *            開始日（YYYYMMDD）
     * @param inToDate
     *            終了日（YYYYMMDD）
     * @return LinkedHashMap<String, String> 和暦（年）
     */
    public static LinkedHashMap<String, Object> getWarekiList(String inFromDate, String inToDate) {

        LinkedHashMap<String, Object> mapY = new LinkedHashMap<String, Object>();
        try {
            String fromDate = "";
            if (inFromDate.indexOf("/") == -1) {
                String fromYY = inFromDate.substring(0, 4);
                String fromMM = inFromDate.substring(inFromDate.length() - 4, inFromDate.length() - 2);
                String fromDD = inFromDate.substring(inFromDate.length() - 2);
                fromDate = fromYY + "-" + fromMM + "-" + fromDD;

            }
            else {
                fromDate = inFromDate.replaceAll("\\/", "-");
            }

            String toDate = "";
            if (inToDate.indexOf("/") == -1) {
                String toYY = inToDate.substring(0, 4);
                String toMM = inToDate.substring(inToDate.length() - 4, inToDate.length() - 2);
                String toDD = inToDate.substring(inToDate.length() - 2);
                toDate = toYY + "-" + toMM + "-" + toDD;

            }
            else {
                toDate = inToDate.replaceAll("\\/", "-");
            }

            for (PNCommonCalendarGengoInfo info : gengoInfoList) {

                // 西暦開始年月日
                String startYMD = info.getStartYear() + "-"
                        + String.format("%2s", info.getStartMonth()).replace(" ", "0") + "-"
                        + String.format("%2s", info.getStartDay()).replace(" ", "0");
                // 西暦終了年月日
                String endYMD = info.getEndYear() + "-" + String.format("%2s", info.getEndMonth()).replace(" ", "0")
                        + "-" + String.format("%2s", info.getEndDay()).replace(" ", "0");

                // 西暦年の比較
                int startFromCompare = startYMD.compareTo(fromDate);
                int endFromCompare = endYMD.compareTo(fromDate);
                int startToCompare = startYMD.compareTo(toDate);
                int endToCompare = endYMD.compareTo(toDate);

                if (startFromCompare <= 0 && endFromCompare >= 0 ||
                        startFromCompare > 0 && startToCompare < 0 ||
                        startToCompare <= 0 && endToCompare >= 0) {

                    // 和暦開始年
                    int fromYear = 0;
                    if (startFromCompare <= 0 && endFromCompare >= 0) {
                        fromYear = Integer.parseInt(fromDate.substring(0, 4)) - Integer.parseInt(info.getStartYear()) + 1;
                    }
                    else {
                        fromYear = 1;
                    }

                    // 和暦終了年
                    int endYear = 0;
                    if (startToCompare <= 0 && endToCompare >= 0) {
                        endYear = Integer.parseInt(toDate.substring(0, 4)) - Integer.parseInt(info.getStartYear()) + 1;
                    }
                    else {
                        endYear = Integer.parseInt(info.getEndYear()) - Integer.parseInt(info.getStartYear()) + 1;
                    }

                    // 和暦開始年～和暦終了年をリストに追加
                    for (int i = fromYear; i <= endYear; i++) {
                        String value = info.getEraEn() + String.valueOf(i);
                        mapY.put(value, value);
                    }
                }
            }

            return mapY;

        }
        catch (IllegalArgumentException ie) {
            return mapY;
        }
        catch (NullPointerException ne) {
            return mapY;
        }
        catch (Exception e) {
            return mapY;
        }
    }
// [ADD] Ver 1.1.0 - END
// [ADD] Ver 4.0.0 - START
	/**
	 * 数値変換
	 * <pre>
	 * String型の数字をint型に変換します。
	 * 数字以外が混入もしくはNULL/BLANKの場合は0を返します。
	 * </pre
	 * @param str 文字列
	 * @return ret 変換後数値
	 */
	public static int parseInt(String str) {
		int ret = 0;
		if (StringUtils.isNotEmpty(str) && StringUtils.isNumeric(str)) {
			ret = Integer.parseInt(str);
		}
		return ret;
	}
// [ADD] Ver 4.0.0 - END
}