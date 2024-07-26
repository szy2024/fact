package jp.go.jfc.partnernet.common.calculation;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <pre>
 * このクラスは貸付受入金残高積数算出クラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class PNKeisanSekisu {
    /** Log */
    private static Log log = LogFactory.getLog(PNKeisanSekisu.class);

    /** エラー時の戻り値 */
    private static final BigDecimal RETRUN_ERROR = BigDecimal.valueOf(-1);
    /** 1日の時間（ミリ秒） */
    private static final long ON_DATE_TIME = 1000 * 60 * 60 * 24;
    /** 小数点以下有効桁数0ケタ */
    private static final int LENGTH_0 = 0;

    /**
     * 貸付受入金残高積数
     *
     * <pre>
     * 貸付受入金残高積数計算を行う。引数の精算日 - 起算日がマイナスになるかどうかの判定は呼出元で行うこと。
     * </pre>
     *
     * @param kisanbi 起算日
     * @param seisanbi 精算日(今回の払込期日)
     * @param riritsu 年利率(利率もしくは特利)　1000倍した値が設定されている。計算で使用する際は1000で割った数値を利用する。
     * @param zandaka 貸付受入金残高
     * @return BigDecimal 貸付受入金残高積数計算結果（エラー時 -1）
     */
    public static BigDecimal getSekisu(String kisanbi, String seisanbi, String riritsu, BigDecimal zandaka) {

        BigDecimal ret = RETRUN_ERROR;
        // 1(1)・パラメータチェックを行う。
        // ローカルメソッドparamCheck()を呼び出す。引数は貸付金残高、年利率
        // paramCheck()の戻り値がfalseの場合は当メソッドにて-1を返却し処理終了する。
        if (!paramCheck(riritsu, zandaka)) {
            return RETRUN_ERROR;
        }

        // 1(2)・年利率（%）を求める。
        // 引数の年利率を数値変換し、1000で割った年利率（%）を求める。数値変換にて例外が発生した場合(共通関数よりnullが返却)は
        // -1を返却し処理終了する。
        BigDecimal workDec = PNCommonComponents.mathPercent1000(PNCommonUtils.cnvStrtoBig(riritsu));
        log.debug("年利率（%）変換 変換前[" + riritsu + "]　変換後[" + workDec + "]");
        if (null == workDec) {
            return RETRUN_ERROR;
        }

        // 1(3)・経過日数を求める。
        // 精算日、起算日日付型に変換する。日付変換にて例外が発生した場合は-1を返却し処理終了する。
        // 経過日数 = 精算日 - 起算日 + 1　で求める。
        long keika = 0;
        try {
            Date dateKisanbi = DateUtils.truncate(
                    PNDateUtils.toDate(kisanbi, PNDateUtils.DATE_PATTERN_YYYYMMDD), Calendar.DAY_OF_MONTH);
            Date dateSeisanbi = DateUtils.truncate(
                    PNDateUtils.toDate(seisanbi, PNDateUtils.DATE_PATTERN_YYYYMMDD), Calendar.DAY_OF_MONTH);
            keika = (dateSeisanbi.getTime() - dateKisanbi.getTime()) / ON_DATE_TIME + 1;
        } catch (IllegalArgumentException e) {
            log.debug("経過日数算出で例外発生 起算日[" + kisanbi + "]　精算日[" + seisanbi + "] 経過日数[" + keika + "]");
            return RETRUN_ERROR;
        }
        // ;
        // 上記の結果が0未満の場合は、-1を返却し処理終了する。
        if (0 > keika) {
            log.debug("経過日数算出結果（エラー） 起算日[" + kisanbi + "]　精算日[" + seisanbi + "] 経過日数[" + keika + "]");
            return RETRUN_ERROR;
        }
        log.debug("経過日数算出結果（正常） 起算日[" + kisanbi + "]　精算日[" + seisanbi + "] 経過日数[" + keika + "]");

        // 2(1)・貸付受入金残高積数を求める。
        // 貸付受入金残高積数 = 残高 × 1(3)で求めた経過日数 × 年利率（%）
        ret = zandaka.multiply(BigDecimal.valueOf(keika).multiply(workDec));
        log.debug("貸付受入金残高積数結果（切捨前）[" + ret + "]");

        // 上記で求めた貸付受入金残高積数を小数点以下を切り捨てる。　※BigDecimalのsetScale（）にて切り捨てる
        ret = ret.setScale(LENGTH_0, BigDecimal.ROUND_DOWN);

        log.debug("貸付受入金残高積数結果（切捨前）[" + ret + "]　年利率（%）[" + workDec + "] 経過日数[" + keika + "]");

        return ret;
    }

    /**
     *
     * <pre>
     * 呼び出し時のパラメータのチェックを行う
     * </pre>
     *
     * @param riritsu 年利率（x1000）
     * @param zandaka 貸付受入金残高
     * @return true=正常，false=エラー
     */
    private static boolean paramCheck(String riritsu, BigDecimal zandaka) {
        boolean ret = true;

        if (null == riritsu || null == zandaka) {
            ret = false;
        }
        // 1(1) 貸付金残高が0未満の場合エラーとする。
        if (ret && 0 < BigDecimal.ZERO.compareTo(zandaka)) {
            ret = false;
        }
        if (ret) {
            // 1(2) 利率が0未満の場合エラーとする。
            try {
                int rate = Integer.parseInt(riritsu);
                if (0 > rate) {
                    ret = false;
                }
            } catch (Exception e) {
                log.debug("パラメータチェックで例外発生：年利率[" + riritsu + "]");
                ret = false;
            }
        }
        log.debug("パラメータチェック結果ret[" + ret + "]：年利率[" + riritsu + "] 貸付受入金残高[" + zandaka + "]");
        return ret;
    }
}
