package jp.go.jfc.partnernet.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.common.CFWDateUtils;
import com.fujitsu.crust.common.CFWFormatUtils;
import com.fujitsu.crust.common.CFWJpCalendarUtils;
import com.fujitsu.crust.common.CFWMessageUtils;

public class PNCommonUtils {

    /**
     *
     * <pre>
     * HSQLDBか判定します。
     * </pre>
     *
     * @param dataSource
     * @return HSQLDBの場合true
     */
    public static boolean isHSQLDB(DataSource dataSource) {

        Connection conn = DataSourceUtils.getConnection(dataSource);

        try {
            return "HSQL Database Engine".equals(conn.getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            throw new PNSystemException();
        }
    }

    /**
     *
     * <pre>
     * 年を取得します。
     * </pre>
     *
     * @param py
     * @return 年
     */
    public static String getYear(Date py) {

        if (py == null) {
            return "";
        }
        return py.toString().substring(24, 28);
    }

    /**
     *
     * <pre>
     * 元号(イニシャル)＋年を取得します。
     * </pre>
     *
     * @param pstr
     * @return 元号＋年
     */
    public static String getYearWa(String[] pstr) {

        if (pstr == null || 3 > pstr.length) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(pstr[0]);
        sb.append(pstr[2]);
        return sb.toString();
    }

    /**
     *
     * <pre>
     * 元号(イニシャル)＋年を取得します。
     * </pre>
     *
     * @param pstr (Date)
     * @return 元号(イニシャル)＋年
     */
    public static String getYearWa(CFWJpCalendarUtils jpCalendarUtils, Date py) {

        if (null == py) {
            // 日付がnullの場合は空文字を返す
            return "";
        }

        // 日付書式パターン
        DateFormat dtFormat = new SimpleDateFormat(CFWDateUtils.DATE_PATTERN_YYYYMMDD);

        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String[] dates = jpCalendarUtils.toJapaneseCalendar(dtFormat.format(py));
        if (null == dates) {
            // 和暦年取得に失敗した場合は空文字を返す
            return "";
        }

        return getYearWa(dates);
    }

    /**
     *
     * <pre>
     * 元号(イニシャル)＋年を西暦年(4桁)に変換します。
     * 和暦年月日が不正日付の場合、空文字を返却します.
     * </pre>
     *
     * @param jpCalendarUtils 和暦日付共通ユーティリティクラス
     * @param str 元号(イニシャル)＋年
     * @return 西暦年(4桁)
     */
    public static String toSeireki(CFWJpCalendarUtils jpCalendarUtils, String str) {
        String outSeireki = "";
        if (null != str && PNCommonConstants.GANGOU_LENGTH < str.length()) {
            String inGengo = str.substring(0, PNCommonConstants.IDX_WAREKI_GENGO_END);
            String inYear = str.substring(PNCommonConstants.IDX_WAREKI_GENGO_END);
            outSeireki = jpCalendarUtils.toSeireki(inGengo, inYear, PNCommonConstants.JANUARY,
                    PNCommonConstants.FIRST_DAY_OF_MONTH);
            if (null != outSeireki && 0 < outSeireki.length()) {
                outSeireki = outSeireki.substring(0, PNCommonConstants.YEAR_LENGTH);
            }
        }
        return outSeireki;
    }

    /**
     *
     * <pre>
     * 西暦(YYYY)から和暦年（GYY）を取得する
     * </pre>
     *
     * pstrYYYY
     * @param
     * @return
     */
    public static String getYYYYtoGHH(CFWJpCalendarUtils jpCalendarUtils, String pstrYYYY) {

        if (null == pstrYYYY) {
            // 日付がnullの場合は空文字を返す
            return "";
        }

        // 月日編集
        String MMDD = PNCommonConstants.JANUARY + PNCommonConstants.FIRST_DAY_OF_MONTH;

        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String[] dates = jpCalendarUtils.toJapaneseCalendar(pstrYYYY + MMDD);
        if (null == dates) {
            // 和暦年取得に失敗した場合は空文字を返す
            return "";
        }

        return PNCommonUtils.getYearWa(dates);
    }

    /**
     *
     * <pre>
     * 西暦日付（YYYYMMDD）を和暦日付（GYY.MM.DD）に変換します。
     * 西暦日付（YYYYMM）を和暦日付（GYY.MM）に変換します。
     * 西暦日付が不正日付の場合、空文字を返却します.
     * 例）
     *   20150701⇒H27.7.1
     *   19881231⇒H1.12.31
     *   201507⇒H27.7
     * </pre>
     *
     * @param jpCalendarUtils 和暦日付共通ユーティリティクラス
     * @param str 西暦日付（YYYYMMDD）
     * @return 和暦日付（GYY.MM.DD）
     */
    public static String toWareki(CFWJpCalendarUtils jpCalendarUtils, String str) {
        String outWareki = "";
        if (null == str
                || (str.length() != PNCommonConstants.YEAR_MONTH_LENGTH && str.length() != PNCommonConstants.YEAR_MONTH_DAY_LENGTH)) {
            // 日付がnullの場合は空文字を返す
            return outWareki;
        }

        // 引数のレングスを退避
        int pramLength = str.length();
        if (pramLength == PNCommonConstants.YEAR_MONTH_LENGTH) {
            // 日が設定されていない場合は変換のために1日を付加する
            str = str + PNCommonConstants.FIRST_DAY_OF_MONTH;
        }
        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String[] dates = jpCalendarUtils.toJapaneseCalendar(str);
        if (null == dates) {
            // 和暦年取得に失敗した場合は空文字を返す
            return outWareki;
        }

        String strMM = String.valueOf(Integer.parseInt(str.substring(4, 6)));
        String strDD = String.valueOf(Integer.parseInt(str.substring(6)));

        if (pramLength == PNCommonConstants.YEAR_MONTH_LENGTH) {
            outWareki = PNCommonUtils.getYearWa(dates) + PNCommonConstants.DELIMITER_DOT + strMM;
        } else {
            outWareki = PNCommonUtils.getYearWa(dates) + PNCommonConstants.DELIMITER_DOT + strMM
                    + PNCommonConstants.DELIMITER_DOT + strDD;
        }

        return outWareki;
    }

    /**
     *
     * <pre>
     * 西暦日付（MMDD）を（MM.DD）形式に変換します。
     * 例）
     *   0701⇒.7.1
     * </pre>
     *
     * @param jpCalendarUtils 和暦日付共通ユーティリティクラス
     * @param str 西暦日付（YYYYMMDD）
     * @return 和暦日付（MM.DD）
     */
    public static String toDay(CFWJpCalendarUtils jpCalendarUtils, String str) {
        String day = "";
        if (null == str || str.length() != PNCommonConstants.MONTH_DAY_LENGTH) {
            // 日付がnullの場合は空文字を返す
            return day;
        }

        String strMM = String.valueOf(Integer.parseInt(str.substring(0, 2)));
        String strDD = String.valueOf(Integer.parseInt(str.substring(2, 4)));

        day = strMM + PNCommonConstants.DELIMITER_DOT + strDD;

        return day;
    }

    /**
     * 日付を形式に従って変換する
     *
     * @param jpCalendarUtils 和暦日付共通ユーティリティクラス
     * @param format String データ形式
     * @param date String 日付
     * @return String 変換した日付データ
     */
    public static String dateFormatConvert(CFWJpCalendarUtils jpCalendarUtils, int format, String date) {

        String convertDate = null;

        switch (format) {
            case PNCommonConstants.DATE_FORMAT_YEAR:
                // データ形式が「年」の場合
                if (date != null && date.length() == PNCommonConstants.YEAR_LENGTH) {
                    convertDate = getYYYYtoGHH(jpCalendarUtils, date);
                }
                break;

            case PNCommonConstants.DATE_FORMAT_YEAR_MONTH:
                // データ形式が「年月」の場合
                if (date != null && date.length() == PNCommonConstants.YEAR_MONTH_LENGTH) {
                    String dateYear = getYYYYtoGHH(jpCalendarUtils, date.substring(
                            PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_YEAR_END_INDEX));
                    String dateMonth = CFWFormatUtils.toZeroSuppress(date.substring(
                            PNCommonConstants.DATE1_MONTH_BEGIN_INDEX,
                            PNCommonConstants.DATE1_MONTH_END_INDEX));
                    convertDate = dateYear + PNCommonConstants.DATE_SEPARATOR + dateMonth;
                }
                break;

            case PNCommonConstants.DATE_FORMAT_YEAR_MONTH_DAY:
                // データ形式が「年月日」の場合
                if (date != null && date.length() == PNCommonConstants.YEAR_MONTH_DAY_LENGTH) {
                    String dateYear = getYYYYtoGHH(jpCalendarUtils, date.substring(
                            PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_YEAR_END_INDEX));
                    String dateMonth = CFWFormatUtils.toZeroSuppress(date.substring(
                            PNCommonConstants.DATE1_MONTH_BEGIN_INDEX,
                            PNCommonConstants.DATE1_MONTH_END_INDEX));
                    String dateDay = CFWFormatUtils.toZeroSuppress(date.substring(
                            PNCommonConstants.DATE1_DAY_BEGIN_INDEX, PNCommonConstants.DATE1_DAY_END_INDEX));
                    convertDate = dateYear + PNCommonConstants.DATE_SEPARATOR + dateMonth
                            + PNCommonConstants.DATE_SEPARATOR + dateDay;
                }
                break;

            case PNCommonConstants.DATE_FORMAT_MONTH_DAY:
                // データ形式が「月日」の場合
                if (date != null && date.length() == PNCommonConstants.MONTH_DAY_LENGTH) {
                    String dateMonth = CFWFormatUtils.toZeroSuppress(date.substring(
                            PNCommonConstants.DATE2_MONTH_BEGIN_INDEX,
                            PNCommonConstants.DATE2_MONTH_END_INDEX));
                    String dateDay = CFWFormatUtils.toZeroSuppress(date.substring(
                            PNCommonConstants.DATE2_DAY_BEGIN_INDEX, PNCommonConstants.DATE2_DAY_END_INDEX));
                    convertDate = dateMonth + PNCommonConstants.DATE_SEPARATOR + dateDay;
                }
                break;

        }

        return convertDate;
    }

    /**
     * 時刻を形式に従って変換する
     *
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
     *
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

        } catch (Exception e) {
            // 例外発生時はnullを戻す。
            outPercent = null;
        }

        // 戻り値返却
        return outPercent;
    }

    /**
     *
     * <pre>
     * BigDecimalのオブジェクトがnullの場合0を返します。
     * </pre>
     *
     * @param 数字
     * @return 数字
     */
    public static BigDecimal encNulltoZeroBig(BigDecimal param) {
        if (param == null) {
            return BigDecimal.ZERO;
        }
        return param;
    }

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
        } catch (Exception e) {
            // 例外発生時はnullを戻す。
            ret = null;
        }
        return ret;
    }

    /**
     *
     * <pre>
     * 西暦日付文字列を引数の区切り文字で区切った日付に編集します。
     * 西暦日付文字列が不正日付の場合、空文字を返却します。
     * </pre>
     *
     * @param str 西暦日付
     * @param zeroPad 月、日が2桁未満の場合に前ゼロ埋めする場合はtrue
     * @param delimiter 区切り文字
     * @return 編集後日付文字列
     */
    public static String dateFormat(String str, boolean zeroPad, String delimiter) {
        String ret = "";

        try {

            if (null == str
                    || (str.length() != PNCommonConstants.YEAR_MONTH_LENGTH && str.length() != PNCommonConstants.YEAR_MONTH_DAY_LENGTH)) {
                // 日付がnullの場合は空文字を返す
                return ret;
            }

            // 引数のレングスを退避
            int pramLength = str.length();
            if (pramLength == PNCommonConstants.YEAR_MONTH_LENGTH) {
                // 日が設定されていない場合は変換のために1日を付加する
                str = str + PNCommonConstants.FIRST_DAY_OF_MONTH;
            }

            String strYYYY = str.substring(0, 4);
            String strMM = str.substring(4, 6);

            if (zeroPad) {
                // ゼロパディングしない場合、前ゼロを除去
                strYYYY = String.valueOf(Integer.parseInt(strYYYY));
                strMM = String.valueOf(Integer.parseInt(strMM));
            }

            // 年と月を区切り文字で連結
            ret = strYYYY + delimiter + strMM;

            if (pramLength == PNCommonConstants.YEAR_MONTH_DAY_LENGTH) {
                // 西暦８桁の場合
                String strDD = str.substring(6);
                if (zeroPad) {
                    // ゼロパディングしない場合、前ゼロを除去
                    strDD = String.valueOf(Integer.parseInt(strDD));
                }
                // 年月と日を区切り文字で連結
                ret = ret + delimiter + strDD;
            }

        } catch (Exception e) {
            ret = "";
        }

        return ret;
    }

    /**
     *
     * <pre>
     * 注意喚起メッセージを編集して返します。
     * メッセージが取得できなかった場合、例外が発生した場合は空文字を返します。
     * </pre>
     *
     * @param headStr メッセージの先頭に付加する文字列
     * @param msgStr メッセージ文字列
     * @param flgBr メッセージの末尾に改行タグを付加する場合、true
     * @param strReplace メッセージに埋め込む置換文字列の配列
     * @return 編集後メッセージ
     */
    public static String editAttentionMessage(String headStr, String msgId, boolean flgBr, String[] strReplace) {

        String ret = "";
        try {

            StringBuffer sb = new StringBuffer();
            sb.append(headStr);
            String wkMsg = msgId;
            if (null != msgId && msgId.isEmpty() == false) {
                if (strReplace.length > 0) {
                    PNMessageInfo infoA = new PNMessageInfo(msgId, strReplace);
                    wkMsg = infoA.toString();
                } else {
                    wkMsg = CFWMessageUtils.getString(msgId);
                }
            }
            sb.append(wkMsg);
            if (flgBr) {
                sb.append(PNCommonConstants.STR_BR);
            }
            ret = sb.toString();

        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    /**
     *
     * <pre>
     * Entity→DTO転記
     * </pre>
     *
     * @param dest 転記先のDTO
     * @param orig 転記元のEntity
     * @return
     */
    public static void ToDto(Object dest, Object orig, String[][] arrayMapping) {

        for (int i = 0; i < arrayMapping.length; i++) {
            try {
                String value = CFWBeanUtils.getProperty(orig, arrayMapping[i][1]);

                CFWBeanUtils.setProperty(dest, arrayMapping[i][0], value);

            } catch (Exception e) {
            }
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
     */
    public static void ToEntity(Object dest, Object orig, String[][] arrayMapping) {

        for (int i = 0; i < arrayMapping.length; i++) {
            try {
                String value = CFWBeanUtils.getProperty(orig, arrayMapping[i][0]);

                CFWBeanUtils.setProperty(dest, arrayMapping[i][1], value);

            } catch (Exception e) {
            }
        }
    }

    /**
     *
     * <pre>
     * システム日付(YYYYMMDD)を取得します。
     * </pre>
     *
     * @param pstr (Date)
     * @return システム日付(YYYYMMDD)
     */
    public static String getSysDateTimeDay(CFWJpCalendarUtils jpCalendarUtils) {

        // 日付書式パターン
        DateFormat dtFormat = new SimpleDateFormat(CFWDateUtils.DATE_PATTERN_YYYYMMDD);

        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String wareki = PNCommonUtils
                .toWareki(jpCalendarUtils, dtFormat.format(CFWDateUtils.getSystemDate()));

        return wareki;
    }

    /**
     *
     * <pre>
     * システム時間(hh:mm:ss)を取得します。
     * </pre>
     *
     * @param pstr (Date)
     * @return システム時間(hh:mm:ss)
     */
    public static String getSysDateTime(CFWJpCalendarUtils jpCalendarUtils) {

        // 日付書式パターン
        DateFormat dtFormat = new SimpleDateFormat("hh:mm:ss");

        // 和暦年を取得（[0]=年号記号、[1]=年号、[2]=年）
        String dateTime = dtFormat.format(CFWDateUtils.getSystemDate());

        return dateTime;
    }

    /**
     *
     * <pre>
     * BigDecimal 合計計算用
     * </pre>
     *
     * @param param
     * @return
     */
    public static BigDecimal sum_BigDecimal(BigDecimal... param) {
        BigDecimal out_param = BigDecimal.ZERO;
        for (BigDecimal paramRec : param) {
            if (null != paramRec) {
                out_param = out_param.add(paramRec);
            }
        }
        return out_param;
    }

    /**
     *
     * <pre>
     * String型からコンマを抜いて計算したBigdecimalの値を返します。
     * </pre>
     *
     * @param param
     * @return
     */
    public static BigDecimal cnvBigStrMoney(String param) {
        if (null == param) {
            return BigDecimal.ZERO;
        }
        String tmpKeisan = "";
        tmpKeisan = PNCommonComponents.cnvNulltoZero(param);
        tmpKeisan = tmpKeisan.replaceAll(",", "");
        return new BigDecimal(tmpKeisan);

    }

    /**
     *
     * <pre>
     * cnvNulltoZero機能拡張
     * </pre>
     *
     * @param param
     * @return
     */
    public static String cnvNulltoZero(BigDecimal param) {
        if (null == param) {
            return "0";
        } else {
            return param.toString();
        }
    }

    /**
     * <pre>
     * カンマ編集を行います。
     * </pre>
     *
     */
    public static String addComma(BigDecimal param) {
        if (null == param || BigDecimal.ZERO.equals(param)) {
            return "0";
        }
        String result = new DecimalFormat("#,###").format(param);
        return result;
    }
}
