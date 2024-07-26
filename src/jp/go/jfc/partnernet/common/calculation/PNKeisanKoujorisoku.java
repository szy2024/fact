//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNKeisanKoujorisoku
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 青本　信吉            | 新規作成
// 4.0.0   | 2020/11/27 | 三好　一功            | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.common.calculation;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.PNCOM02_HaraidashiDAO;
import jp.go.jfc.partnernet.common.dao.PNCOM02_HaraidashiEntity;
import jp.go.jfc.partnernet.common.dao.PNCOM02_ReportHistoryDAO;
import jp.go.jfc.partnernet.common.dao.PNCOM02_ReportHistoryEntity;
import jp.go.jfc.partnernet.common.dao.PNCOM02_YakujoDAO;
import jp.go.jfc.partnernet.common.dao.PNCOM02_YakujoEntity;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PNKeisanKoujorisoku {
    /** Log */
    private static Log log = LogFactory.getLog(PNKeisanKoujorisoku.class);

    /** 控除利息エラー時の戻り値 */
    private static final BigDecimal RETRUN_ERROR = new BigDecimal(-1);

    /** 貸付受入金のデフォルト値 */
    private static final BigDecimal DEFAULT_VALUE_KASHITUKEUKEIREKIN = new BigDecimal(-1);

    /** 積数Aデータ「貸付受入金残高」のkey */
    private static final String M_KASHITSUKEUKEIREZAN = "M_KashitsukeukeireZan";
    /** 積数Aデータ「貸付受入金残高積数」のkey */
    private static final String M_ZANDAKASEKISU_RUIKEI = "M_ZandakaSekisu_Ruikei";
    /** 積数Aデータ「払出充当年月日」のkey */
    private static final String DATE_HARAIDASHIJUTO = "Date_HaraidashiJuto";

    /** 切捨て数（小数18位） */
    private static final int ROUND_DOWN_NUM = 17;

    /** pncom02_HaraidashiDAO */
    @Autowired
    private PNCOM02_HaraidashiDAO pncom02_HaraidashiDAO = null;

    /** pncom02_ReportHistoryDAO */
    @Autowired
    private PNCOM02_ReportHistoryDAO pncom02_ReportHistoryDAO = null;

    /** pncom02_YakujoDAO */
    @Autowired
    private PNCOM02_YakujoDAO pncom02_YakujoDAO = null;

    /**
     *
     *
     * <pre>
     * 控除利息計算を行う
     *
     * </pre>
     *
     * @param ID_Credit 稟議データ「債権管理番号」
     * @param Date_Haraikomi se009：画面入力値 「資金払出または元金充当日」 se004, se008：請求データの「払込年月日」 se007：約定データ 「払込年月日」
     *        cr003：画面入力値 「払込期日」
     * @param Date_Jikko 稟議データ「実行年月日」
     * @param Riritsu 稟議データ「利率」
     * @param Tokuri 稟議データ「特利」
     * @param Date_TokuriYuko 稟議データ「特利有効年月日」
     * @param Code_ShokanHouhou se009：null se004, se007, se008, cr003：稟議データ「償還方法コード」
     * @param ID_M_Gankinjuto se009：画面入力値「元金充当額」 se004, se007, se008, cr003：null
     * @param ID_M_ShikinHaraidashi se009：画面入力値「資金払出額」 se004, se007, se008, cr003：null
     * @param isSimulation 「シミュレーション判断」 se009：true se004, se007, se008, cr003：false
     * @return 計算した控除利息額 (エラー時 -1を返します)
     */
    public BigDecimal getKoujorisoku(long ID_Credit, String Date_Haraikomi, String Date_Jikko,
            String Riritsu, String Tokuri, String Date_TokuriYuko, String Code_ShokanHouhou,
            String ID_M_Gankinjuto, String ID_M_ShikinHaraidashi, boolean isSimulation) {

// [ADD] Ver 4.0.0 - START
		// 稟議データ「実行年月日」が控除利息計算基準日（2022年04月01日）以降の場合
		if (PNCommonConstants.BASE_DATE_DEDUCT_INTEREST
				.compareTo(Date_Jikko) <= 0) {
			// 控除利息計算を行わず、控除利息額を「0」として返却する
			return PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
		}
// [ADD] Ver 4.0.0 - END

        // 控除利息計算を行うか判断をする
        boolean judgeCalculation = judgeCalculation(ID_Credit, Date_Haraikomi, isSimulation);
        if (!judgeCalculation) {
            // 控除利息計算を行わず、控除利息額を「0」として返却する
            return PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
        }

        // 起算日を取得する
        String kisanbi = getKisanbi(ID_Credit, Date_Haraikomi, Date_Jikko);
        // 精算日を設定する
        String seisanbi = Date_Haraikomi;

        // 控除利息計算の計算方法が「利息計算単位期間」か判断する
        boolean judgeUnitPeriodCalculation = false;
        try {
            judgeUnitPeriodCalculation = judgeUnitPeriodCalculation(ID_Credit, kisanbi, seisanbi, Date_Jikko,
                    Riritsu, Tokuri, Date_TokuriYuko, Code_ShokanHouhou, isSimulation);
        } catch (PNSystemException e) {
            log.error("judgeUnitPeriodCalculation(控除利息計算の計算方法判断) でエラーが発生しました。" + e);
            return RETRUN_ERROR;
        }

        if (judgeUnitPeriodCalculation) {
            // 利息計算単位期間による控除利息計算を行う

            try {
                return calcKoujorisokuUnitPeriod(ID_Credit, Riritsu, Tokuri, Date_TokuriYuko,
                        Code_ShokanHouhou, kisanbi, Date_Haraikomi);
            } catch (PNSystemException e) {
                log.error("calcKoujorisokuUnitPeriod(利息計算単位期間による控除利息計算) でエラーが発生しました。" + e);
                return RETRUN_ERROR;
            }

        } else {
            // 積数による控除利息計算を行う

            // 積数Aの計算を行う
            HashMap<String, Object> sekisuuAData = null;
            try {
                sekisuuAData = getSekisuuAData(ID_Credit, kisanbi, seisanbi, isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuAData(積数A計算) でエラーが発生しました。" + e);
                return RETRUN_ERROR;
            }

            // 積数Aで取得した「貸付受入金残高積数」の累計を設定
            BigDecimal sekisuuAZandaka = (BigDecimal) sekisuuAData.get(M_ZANDAKASEKISU_RUIKEI);
            // 積数Aで取得した「貸付受入金残高」を設定
            BigDecimal M_KashitsukeukeireZan = (BigDecimal) sekisuuAData.get(M_KASHITSUKEUKEIREZAN);
            // 積数Aで取得した「払出充当年月日」を設定
            // 中身は払出データの期間内指定(FROM～TO)のデータがある場合、「払出充当年月日」
            // データがない場合、getSekisuuADataで使用した「kisanbi」が格納されている
            String Date_HaraidashiJuto = (String) sekisuuAData.get(DATE_HARAIDASHIJUTO);

            // 積数Bの貸付受入金残高を取得する
            BigDecimal sekisuuBZandaka = null;
            try {
                sekisuuBZandaka = getSekisuuB(ID_Credit, Date_Haraikomi, Date_Jikko, Riritsu, Tokuri,
                        Date_TokuriYuko, ID_M_Gankinjuto, M_KashitsukeukeireZan, Date_HaraidashiJuto,
                        isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuB(積数B計算) でエラーが発生しました。" + e);
                return RETRUN_ERROR;
            }

            // 積数C計算用の貸付受入金残高を取得する
            BigDecimal calcSekisuuCZandaka = getZandakaC(ID_M_Gankinjuto, ID_M_ShikinHaraidashi,
                    M_KashitsukeukeireZan, isSimulation);

            // 積数Cの貸付受入金残高を取得する
            BigDecimal sekisuuCZandaka = null;
            try {
                sekisuuCZandaka = getSekisuuC(ID_Credit, Date_Haraikomi, Riritsu, Tokuri, Date_TokuriYuko,
                        Date_HaraidashiJuto, calcSekisuuCZandaka, isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuC(積数C計算) でエラーが発生しました。" + e);
                return RETRUN_ERROR;
            }

            // 積数による控除利息計算を行う
            return calcKoujorisokuSekisuu(sekisuuAZandaka, sekisuuBZandaka, sekisuuCZandaka);
        }
    }

    /**
     *
     *
     * <pre>
     * 控除利息計算を行い、
     * 控除利息額と対象の貸付受入金のリストを返却します。
     * 
     * 戻り値が違うだけで、処理の内容は「getKoujorisoku」と同じです。
     * </pre>
     *
     * @param ID_Credit 稟議データ「債権管理番号」
     * @param Date_Haraikomi se009：画面入力値 「資金払出または元金充当日」 se004, se008：請求データの「払込年月日」 se007：約定データ 「払込年月日」
     *        cr003：画面入力値 「払込期日」
     * @param Date_Jikko 稟議データ「実行年月日」
     * @param Riritsu 稟議データ「利率」
     * @param Tokuri 稟議データ「特利」
     * @param Date_TokuriYuko 稟議データ「特利有効年月日」
     * @param Code_ShokanHouhou se009：null se004, se007, se008, cr003：稟議データ「償還方法コード」
     * @param ID_M_Gankinjuto se009：画面入力値「元金充当額」 se004, se007, se008, cr003：null
     * @param ID_M_ShikinHaraidashi se009：画面入力値「資金払出額」 se004, se007, se008, cr003：null
     * @param isSimulation 「シミュレーション判断」 se009：true se004, se007, se008, cr003：false
     * @return List<BigDecimal> 計算した控除利息額（エラー時 -1）、控除利息計算対象の貸付受入金残高（初期値 -1）
     *
     */
    public List<BigDecimal> getKoujorisokuAndKashitukeUkeireZanList(long ID_Credit, String Date_Haraikomi,
            String Date_Jikko, String Riritsu, String Tokuri, String Date_TokuriYuko,
            String Code_ShokanHouhou, String ID_M_Gankinjuto, String ID_M_ShikinHaraidashi,
            boolean isSimulation) {

        // リストの中身は下記の通り
        // 1, 控除利息額
        // 2, 控除利息計算対象の貸付受入金残高
        BigDecimal targetKashitukeUkeireZan = DEFAULT_VALUE_KASHITUKEUKEIREKIN;
        List<BigDecimal> koujoKashitukeUkeireList = new ArrayList<BigDecimal>(2);

// [ADD] Ver 4.0.0 - START
		// 稟議データ「実行年月日」が控除利息計算基準日（2022年04月01日）以降の場合
		if (PNCommonConstants.BASE_DATE_DEDUCT_INTEREST
				.compareTo(Date_Jikko) <= 0) {
			// 控除利息計算を行わず、控除利息額を「0」として返却する
			koujoKashitukeUkeireList
					.add(PNCommonConstants.BIGDECIMAL_ZERO_VALUE);
			koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
			return koujoKashitukeUkeireList;
		}
// [ADD] Ver 4.0.0 - END

        // 控除利息計算を行うか判断をする
        boolean judgeCalculation = judgeCalculation(ID_Credit, Date_Haraikomi, isSimulation);
        if (!judgeCalculation) {
            // 控除利息計算を行わず、下記の値にセットして返却する
            // 控除利息額「0」
            // 貸付受入金「-1」
            koujoKashitukeUkeireList.add(PNCommonConstants.BIGDECIMAL_ZERO_VALUE);
            koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
            return koujoKashitukeUkeireList;
        }

        // 起算日を取得する
        String kisanbi = getKisanbi(ID_Credit, Date_Haraikomi, Date_Jikko);
        // 精算日を設定する
        String seisanbi = Date_Haraikomi;

        // 控除利息計算の計算方法が「利息計算単位期間」か判断する
        boolean judgeUnitPeriodCalculation = false;
        try {
            judgeUnitPeriodCalculation = judgeUnitPeriodCalculation(ID_Credit, kisanbi, seisanbi, Date_Jikko,
                    Riritsu, Tokuri, Date_TokuriYuko, Code_ShokanHouhou, isSimulation);
        } catch (PNSystemException e) {
            log.error("judgeUnitPeriodCalculation(控除利息計算の計算方法判断) でエラーが発生しました。" + e);
            koujoKashitukeUkeireList.add(RETRUN_ERROR);
            koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
            return koujoKashitukeUkeireList;
        }

        if (judgeUnitPeriodCalculation) {
            // 利息計算単位期間による控除利息計算を行う

            // 内部でPNSystemExceptionをcatchしているので
            // ここでは囲まない
            return calcKoujorisokuUnitPeriodAndKashitukeUkeireZanList(ID_Credit, Riritsu, Tokuri,
                    Date_TokuriYuko, Code_ShokanHouhou, kisanbi, Date_Haraikomi);

        } else {
            // 積数による控除利息計算を行う

            // 積数Aの計算を行う
            HashMap<String, Object> sekisuuAData = null;
            try {
                sekisuuAData = getSekisuuAData(ID_Credit, kisanbi, seisanbi, isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuAData(積数A計算) でエラーが発生しました。" + e);
                koujoKashitukeUkeireList.add(RETRUN_ERROR);
                koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
                return koujoKashitukeUkeireList;
            }

            // 積数Aで取得した「貸付受入金残高積数」の累計を設定
            BigDecimal sekisuuAZandaka = (BigDecimal) sekisuuAData.get(M_ZANDAKASEKISU_RUIKEI);
            // 積数Aで取得した「貸付受入金残高」を設定
            BigDecimal M_KashitsukeukeireZan = (BigDecimal) sekisuuAData.get(M_KASHITSUKEUKEIREZAN);
            // 積数Aで取得した「払出充当年月日」を設定
            // 中身は払出データの期間内指定(FROM～TO)のデータがある場合、「払出充当年月日」
            // データがない場合、getSekisuuADataで使用した「kisanbi」が格納されている
            String Date_HaraidashiJuto = (String) sekisuuAData.get(DATE_HARAIDASHIJUTO);

            // 対象の貸付受入金額をセット
            targetKashitukeUkeireZan = M_KashitsukeukeireZan;

            // 積数Bの貸付受入金残高を取得する
            BigDecimal sekisuuBZandaka = null;
            try {
                sekisuuBZandaka = getSekisuuB(ID_Credit, Date_Haraikomi, Date_Jikko, Riritsu, Tokuri,
                        Date_TokuriYuko, ID_M_Gankinjuto, M_KashitsukeukeireZan, Date_HaraidashiJuto,
                        isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuB(積数B計算) でエラーが発生しました。" + e);
                koujoKashitukeUkeireList.add(RETRUN_ERROR);
                koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
                return koujoKashitukeUkeireList;
            }

            // 積数C計算用の貸付受入金残高を取得する
            BigDecimal calcSekisuuCZandaka = getZandakaC(ID_M_Gankinjuto, ID_M_ShikinHaraidashi,
                    M_KashitsukeukeireZan, isSimulation);

            // 積数Cの貸付受入金残高を取得する
            BigDecimal sekisuuCZandaka = null;
            try {
                sekisuuCZandaka = getSekisuuC(ID_Credit, Date_Haraikomi, Riritsu, Tokuri, Date_TokuriYuko,
                        Date_HaraidashiJuto, calcSekisuuCZandaka, isSimulation);
            } catch (PNSystemException e) {
                log.error("getSekisuuC(積数C計算) でエラーが発生しました。" + e);
                koujoKashitukeUkeireList.add(RETRUN_ERROR);
                koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
                return koujoKashitukeUkeireList;
            }

            // 積数による控除利息計算を行う
            BigDecimal koujorisokuSekisuu = calcKoujorisokuSekisuu(sekisuuAZandaka, sekisuuBZandaka,
                    sekisuuCZandaka);

            koujoKashitukeUkeireList.add(koujorisokuSekisuu);
            koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
            return koujoKashitukeUkeireList;
        }
    }

    /**
     *
     * <pre>
     * 控除利息計算を行うか判断をする。
     * </pre>
     *
     * @param ID_Credit 「債権管理番号」
     * @param Date_Haraikomi「払込年月日」
     * @param isSimulation 「シミュレーション判断」
     * @return true: 控除利息計算を行う, false:控除利息計算を行わない
     */
    private boolean judgeCalculation(long ID_Credit, String Date_Haraikomi, boolean isSimulation) {

        if (isSimulation) {
            // シミュレーションの場合、条件問わず控除利息計算を行う
            return true;
        }

        // 約定データ カウント
        PNCOM02_YakujoEntity entity = new PNCOM02_YakujoEntity();
        entity.setID_Credit(new BigDecimal(ID_Credit));
        entity.setDate_Haraikomi(Date_Haraikomi);
        entity.setWhereMode("1");

        long yakujoCount = pncom02_YakujoDAO.countByCondition(entity);
        if (0 == yakujoCount) {
            // 約定データがない場合、控除利息計算を行わない
            return false;
        }

        // 報告書履歴 カウント
        PNCOM02_ReportHistoryEntity reportEntity = new PNCOM02_ReportHistoryEntity();
        reportEntity.setID_Credit(new BigDecimal(ID_Credit));
        reportEntity.setKeep_Date_Haraikomi(Date_Haraikomi);

        long reportCount = pncom02_ReportHistoryDAO.countByCondition(reportEntity);
        if (0 < reportCount) {
            // 既に登録されている報告書があった場合、控除利息計算を行わない
            return false;
        }
        return true;
    }

    /**
     *
     * <pre>
     * 起算日を取得する。
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param Date_Haraikomi「払込年月日」
     * @param Date_Jikko「実行年月日」
     * @return 起算日
     */
    private String getKisanbi(long ID_Credit, String Date_Haraikomi, String Date_Jikko) {

        String kisanbi = null;

        // 指定条件の約定データを取得する
        PNCOM02_YakujoEntity entity = new PNCOM02_YakujoEntity();
        entity.setID_Credit(new BigDecimal(ID_Credit));
        entity.setDate_Haraikomi(Date_Haraikomi);
        entity.setWhereMode("2");

        List<PNCOM02_YakujoEntity> yakujolList = pncom02_YakujoDAO.findByCondition(entity, 0, 1);
        if (null != yakujolList && 0 != yakujolList.size()) {
            // 約定データが存在する場合

            // 起算日に「払込年月日」+1日をセット
            String dateHaraikomi = yakujolList.get(0).getDate_Haraikomi();
            kisanbi = addDay(dateHaraikomi, 1);
        } else {
            // 約定データが存在しない場合

            // 起算日に「実行年月日」をセット
            kisanbi = Date_Jikko;
        }
        return kisanbi;
    }

    /**
     *
     * <pre>
     * 控除利息計算の計算方法が「利息計算単位期間」か判断する
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param kisanbi「起算日」
     * @param seisanbi「精算日」
     * @param Date_Jikko 「実行年月日」
     * @param Riritsu 稟議データ「利率」
     * @param Tokuri 稟議データ「特利」
     * @param Date_TokuriYuko 稟議データ「特利有効年月日」
     * @param Code_ShokanHouhou「償還方法コード」
     * @param isSimulation「シミュレーション判断」
     * @return true:「利息計算単位期間計算」, false「積数計算」
     */
    private boolean judgeUnitPeriodCalculation(long ID_Credit, String kisanbi, String seisanbi,
            String Date_Jikko, String Riritsu, String Tokuri, String Date_TokuriYuko,
            String Code_ShokanHouhou, boolean isSimulation) throws PNSystemException {

        if (isSimulation) {
            // シミュレーションの場合、条件問わず控除利息計算「積数計算」を行う
            return false;
        }

        // 払出データを取得する
        PNCOM02_HaraidashiEntity haraidashi = new PNCOM02_HaraidashiEntity();
        haraidashi.setID_Credit(new BigDecimal(ID_Credit));
        haraidashi.setDate_HaraidashiJuto_From(kisanbi);
        haraidashi.setDate_HaraidashiJuto_To(seisanbi);
        haraidashi.setWhereMode("1");

        long haraidashiCount = pncom02_HaraidashiDAO.countByCondition(haraidashi);
        // if (haraidashiCount > 0) {
        // 払出データがある場合、控除利息計算「積数計算」を行う
        if (0 < haraidashiCount) {
            return false;
        }

        // 償還方法コードが不正の場合、エラーを投げる
        if (StringUtils.isEmpty(Code_ShokanHouhou) || 2 != Code_ShokanHouhou.length()) {
            log.error("償還方法コードが不正. 償還方法コード[" + Code_ShokanHouhou + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 償還方法コードの上1桁が9の場合、控除利息計算「積数計算」を行う
        if ("9".equals(Code_ShokanHouhou.substring(0, 1))) {
            return false;
        }

        // 特利が利用される場合、控除利息計算「積数計算」を行う
        if (StringUtils.isNotEmpty(Date_TokuriYuko) && StringUtils.isNotEmpty(Tokuri)) {
            if (Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                if (Integer.parseInt(Date_TokuriYuko) >= Integer.parseInt(kisanbi)
                // && Integer.parseInt(Date_TokuriYuko) <= Integer.parseInt(seisanbi)) {
                        && Integer.parseInt(Date_TokuriYuko) < Integer.parseInt(seisanbi)) {
                    return false;
                }
            }
        }

        // 「起算日」と「実行日」が異なる場合、控除利息計算「利息計算単位期間計算」を行う
        if (Integer.parseInt(kisanbi) != Integer.parseInt(Date_Jikko)) {
            return true;
        }

        // 償還方法コードに対応する、月数を取得する
        int shokanHouhouMonth = 12 / getShokanHouhouMonth(Code_ShokanHouhou);

        // 約定払込期日 = 「精算日」 - 「約定期間月数」
        String preDateHaraikomi = addMonth(seisanbi, -shokanHouhouMonth);

        // 上記で求めた約定払込期日の翌日を取得
        preDateHaraikomi = addDay(preDateHaraikomi, 1);

        // 「実行年月日」と「約定払込期日」が同日の場合、控除利息計算「利息計算単位期間計算」を行う
        if (Integer.parseInt(Date_Jikko) == Integer.parseInt(preDateHaraikomi)) {
            return true;
        }

        // 上記以外の場合、控除利息計算「積数計算」を行う
        return false;
    }

    /**
     *
     * <pre>
     * 積数Aの計算結果と以降の計算(積数B,積数C)で必要なデータを取得する。
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param kisanbi「起算日」
     * @param seisanbi「精算日」
     * @param isSimulation「シミュレーション判断」
     * @return 積数Aの計算データマップ
     */
    private HashMap<String, Object> getSekisuuAData(long ID_Credit, String kisanbi, String seisanbi,
            boolean isSimulation) throws PNSystemException {

        BigDecimal kashitukeUkeireZan = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
        BigDecimal zandakaSekisuuRuikei = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
        String dateHaraikomiJuto = null;
        HashMap<String, Object> dataMap = new HashMap<String, Object>(3 * 4 / 3);

        // 払出データを取得する
        PNCOM02_HaraidashiEntity haraidashi = new PNCOM02_HaraidashiEntity();
        haraidashi.setID_Credit(new BigDecimal(ID_Credit));
        haraidashi.setDate_HaraidashiJuto_From(kisanbi);
        haraidashi.setDate_HaraidashiJuto_To(seisanbi);
        haraidashi.setWhereMode("2");

        List<PNCOM02_HaraidashiEntity> haraidashiList = pncom02_HaraidashiDAO.findByCondition(haraidashi);
        // if (haraidashiList != null && haraidashiList.size() != 0) {
        if (null != haraidashiList && 0 != haraidashiList.size()) {
            // 指定範囲の払出データを取得出来た場合

            for (PNCOM02_HaraidashiEntity entity : haraidashiList) {
                kashitukeUkeireZan = entity.getM_KashitsukeukeireZan();
                dateHaraikomiJuto = entity.getDate_HaraidashiJuto();
                // 「貸付受入金残高積数」は累計をしていく
                zandakaSekisuuRuikei = zandakaSekisuuRuikei.add(entity.getM_ZandakaSekisu());
            }

            // 積数Aの計算結果をセット
            dataMap.put(M_KASHITSUKEUKEIREZAN, kashitukeUkeireZan);
            dataMap.put(M_ZANDAKASEKISU_RUIKEI, zandakaSekisuuRuikei);
            dataMap.put(DATE_HARAIDASHIJUTO, dateHaraikomiJuto);

        } else {

            // 払出データを取得する
            haraidashi.setID_Credit(new BigDecimal(ID_Credit));
            haraidashi.setDate_HaraidashiJuto(kisanbi);
            haraidashi.setDate_HaraidashiJuto_From(null);
            haraidashi.setDate_HaraidashiJuto_To(null);
            haraidashi.setWhereMode("3");

            haraidashiList = pncom02_HaraidashiDAO.findByCondition(haraidashi, 0, 1);
            if (null != haraidashiList && 0 != haraidashiList.size()) {

                PNCOM02_HaraidashiEntity entity = haraidashiList.get(0);
                kashitukeUkeireZan = entity.getM_KashitsukeukeireZan();
                dateHaraikomiJuto = entity.getDate_HaraidashiJuto();
                // 「貸付受入金残高積数」は0をセットする。
                zandakaSekisuuRuikei = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

                // 積数Aの計算結果をセット
                dataMap.put(M_KASHITSUKEUKEIREZAN, kashitukeUkeireZan);
                dataMap.put(M_ZANDAKASEKISU_RUIKEI, zandakaSekisuuRuikei);
                if (isSimulation) {
                    // シミュレーションの場合、「払出充当年月日」をセット
                    dataMap.put(DATE_HARAIDASHIJUTO, dateHaraikomiJuto);
                } else {
                    // シミュレーションではない場合、引数の「起算日」をセット
                    dataMap.put(DATE_HARAIDASHIJUTO, kisanbi);
                }

            } else {
                // 払出は必ず1回以上行われているため
                // 払出データが無い = システムエラー
                log.error("該当の払出データが存在しません。債権管理番号[" + ID_Credit + "]");
                throw new PNSystemException(PNCommonMessageConstants.PM9990E);
            }

        }

        log.debug("積数Aの計算結果データ：" + dataMap.toString());
        return dataMap;
    }

    /**
     *
     * <pre>
     * 積数Bの積数残高計算を行う
     * シミュレーション判断が「false」の場合、new BigDecimal("0")を返す
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param Date_Haraikomi「払込年月日」
     * @param Date_Jikko「実行年月日」
     * @param Riritsu「利率」
     * @param Tokuri「特利」
     * @param Date_TokuriYuko「特利有効期限」
     * @param ID_M_Gankinjuto「元金充当額」
     * @param M_KashitsukeukeireZan「貸付受入金残高」(積数Aの計算で取得)
     * @param Date_HaraidashiJuto「払出充当年月日」(積数Aの計算で取得)
     * @param isSimulation「シミュレーション判断」
     * @return 積数Cの積数残高計算額
     */
    private BigDecimal getSekisuuB(long ID_Credit, String Date_Haraikomi, String Date_Jikko, String Riritsu,
            String Tokuri, String Date_TokuriYuko, String ID_M_Gankinjuto, BigDecimal M_KashitsukeukeireZan,
            String Date_HaraidashiJuto, boolean isSimulation) throws PNSystemException {

        // シミュレーションのみ計算を行うので
        // シミュレーションではない場合、BigDecimal("0")を返す
        if (!isSimulation) {
            return PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
        }

        // //////////////////
        // // 積数計算1
        // //////////////////

        String kisanbi1 = null;
        // 約定データ払込年月日格納用の変数
        String yakujo_Date_Haraikomi = null;

        // 指定条件の約定データを取得する
        PNCOM02_YakujoEntity entity = new PNCOM02_YakujoEntity();
        entity.setID_Credit(new BigDecimal(ID_Credit));
        entity.setDate_Haraikomi(Date_Haraikomi);
        entity.setWhereMode("2");

        List<PNCOM02_YakujoEntity> yakujolList = pncom02_YakujoDAO.findByCondition(entity, 0, 1);

        // 積数1計算用の起算日を設定する
        // if (yakujolList != null && yakujolList.size() != 0) {
        if (null != yakujolList && 0 != yakujolList.size()) {
            // 約定データが存在する場合

            yakujo_Date_Haraikomi = yakujolList.get(0).getDate_Haraikomi();
            if (Integer.parseInt(yakujo_Date_Haraikomi) < Integer.parseInt(Date_HaraidashiJuto)) {
                // 前回払出充当日を設定
                kisanbi1 = Date_HaraidashiJuto;
            } else {
                // 前回約定日の翌日を設定
                kisanbi1 = addDay(yakujo_Date_Haraikomi, 1);
            }
        } else {
            // 約定データが存在しない場合

            // 前回払出充当日を設定
            kisanbi1 = Date_HaraidashiJuto;
        }

        // 積数1計算用の精算日を設定する
        String seisanbi1 = addDay(Date_Haraikomi, -1);

        // 積数1を計算する
        BigDecimal sekisuu1 = getSekisuu(Riritsu, Tokuri, Date_TokuriYuko, kisanbi1, seisanbi1,
                M_KashitsukeukeireZan);

        // //////////////////
        // // 積数計算2
        // //////////////////

        BigDecimal sekisuu2 = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
        BigDecimal Gankinjuto = new BigDecimal(ID_M_Gankinjuto);
        // if (Integer.parseInt(ID_M_Gankinjuto) > 0) {
        if (0 < Gankinjuto.compareTo(PNCommonConstants.BIGDECIMAL_ZERO_VALUE)) {
            // 「元金充当額」の値が「1」以上の場合

            // 積数1計算用の起算日を設定する
            String kisanbi2 = null;
            if (StringUtils.isNotEmpty(yakujo_Date_Haraikomi)) {
                // 約定データが存在する場合

                // 前回約定日の翌日を設定
                kisanbi2 = addDay(yakujo_Date_Haraikomi, 1);
            } else {
                // 約定データが存在しない場合

                // 実行年月日を設定する。
                kisanbi2 = Date_Jikko;
            }

            // 積数1計算用の精算日を設定する
            String seisanbi2 = addDay(Date_Haraikomi, -1);

            // 積数2を計算する
            sekisuu2 = getSekisuu(Riritsu, Tokuri, Date_TokuriYuko, kisanbi2, seisanbi2, Gankinjuto);
        }

        log.debug("積数1の計算結果[" + sekisuu1 + "] 積数2の計算結果[" + sekisuu2 + "] 積数B(積数1-積数2)の計算結果["
                + sekisuu1.subtract(sekisuu2) + "]");

        // 積数1の積数残高 - 積数2の積数残高
        return sekisuu1.subtract(sekisuu2);
    }

    /**
     *
     * <pre>
     * 積数Cの積数残高計算を行う
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param Date_Haraikomi「払込年月日」
     * @param Riritsu「利率」
     * @param Tokuri「特利」
     * @param Date_TokuriYuko「特利有効期限」
     * @param kisanbi「起算日」(getKisanbi()で求めたもの)
     * @param calcSekisuuCZandaka「貸付受入金残高」(積数C用)
     * @param isSimulation
     * @return
     */
    private BigDecimal getSekisuuC(long ID_Credit, String Date_Haraikomi, String Riritsu, String Tokuri,
            String Date_TokuriYuko, String kisanbi, BigDecimal calcSekisuuCZandaka, boolean isSimulation)
            throws PNSystemException {

        String targetKisanbi = null;
        String targetSeisanbi = null;
        if (isSimulation) {
            // シミュレーションの場合

            // 起算日に払込年月日(画面入力値)をセット
            targetKisanbi = Date_Haraikomi;

            // 指定条件(直近未来)の約定データを取得する
            PNCOM02_YakujoEntity entity = new PNCOM02_YakujoEntity();
            entity.setID_Credit(new BigDecimal(ID_Credit));
            entity.setDate_Haraikomi(Date_Haraikomi);
            entity.setWhereMode("3");

            List<PNCOM02_YakujoEntity> yakujolList = pncom02_YakujoDAO.findByCondition(entity, 0, 1);
            if (null == yakujolList || 0 == yakujolList.size()) {
                // 既にチェック済みなのでほぼあり得ないが
                // 約定データが取得できない場合、システムエラーとする
                log.error("指定払込年月日以前の約定データが存在しない。債権管理番号[" + ID_Credit + "] 払込年月日[" + Date_Haraikomi + "]");
                throw new PNSystemException(PNCommonMessageConstants.PM9990E);
            }
            // 精算日に上記で取得した約定データの「払込年月日」をセット
            targetSeisanbi = yakujolList.get(0).getDate_Haraikomi();

        } else {
            // シミュレーションではない場合

            // 起算日に積数A計算時に取得した「払出充当年月日」をセット
            targetKisanbi = kisanbi;

            // 精算日に引数の「払込年月日」をセット
            targetSeisanbi = Date_Haraikomi;
        }

        // 積数計算を行い、計算額を返却する
        BigDecimal sekisuu = getSekisuu(Riritsu, Tokuri, Date_TokuriYuko, targetKisanbi, targetSeisanbi,
                calcSekisuuCZandaka);
        log.debug("積数Cの計算結果[" + sekisuu + "]");
        return sekisuu;
    }

    /**
     *
     * <pre>
     * 積数残高を計算する。
     * 積数残高の計算処理は業務共通部品の貸付受入金残高積数計算で行う
     * </pre>
     *
     * @param Riritsu「利率」
     * @param Tokuri「特利」
     * @param Date_TokuriYuko「特利有効期限」
     * @param kisanbi「起算日」
     * @param seisanbi「精算日」
     * @param M_KashitsukeukeireZan 指定の「貸付受入金残高」
     * @return 計算した積数残高
     */
    private BigDecimal getSekisuu(String Riritsu, String Tokuri, String Date_TokuriYuko, String kisanbi,
            String seisanbi, BigDecimal M_KashitsukeukeireZan) throws PNSystemException {

        BigDecimal sekisuu = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        // 貸付受入金残高が「1」以上の場合、積数計算を行う
        if (0 < M_KashitsukeukeireZan.compareTo(PNCommonConstants.BIGDECIMAL_ZERO_VALUE)) {

            if (StringUtils.isEmpty(Date_TokuriYuko)) {
                // 積数計算 パターン1
                // 特利有効日付がない場合

                // 積数を計算する
                sekisuu = calcSekisuu(kisanbi, seisanbi, Riritsu, M_KashitsukeukeireZan);

            } else {

                if (Integer.parseInt(Date_TokuriYuko) >= Integer.parseInt(kisanbi)
                        && Integer.parseInt(Date_TokuriYuko) <= Integer.parseInt(seisanbi)) {

                    if (Integer.parseInt(Date_TokuriYuko) == Integer.parseInt(seisanbi)) {
                        // 積数計算 パターン2
                        // 特利有効期限と精算日が同日の場合

                        String targetRiritu = Riritsu;
                        if (Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                            targetRiritu = Tokuri;
                        }

                        // 積数を計算する
                        sekisuu = calcSekisuu(kisanbi, seisanbi, targetRiritu, M_KashitsukeukeireZan);

                    } else {
                        // 積数計算 パターン3
                        // 起算日と精算日の間に特利有効期限がある場合

                        // 起算日から特利有効期限までの積数を求める

                        String targetRiritu = Riritsu;
                        if (Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                            targetRiritu = Tokuri;
                        }

                        // 積数1の計算(起算日から特利有効期限まで)
                        BigDecimal sekisuu1 = calcSekisuu(kisanbi, Date_TokuriYuko, targetRiritu,
                                M_KashitsukeukeireZan);

                        // 起算日(特利有効期限+1)から精算日までの積数を求める
                        String sekisuu2Kisanbi = addDay(Date_TokuriYuko, 1);

                        // 積数2の計算(特利有効期限+1日から精算日まで)
                        BigDecimal sekisuu2 = calcSekisuu(sekisuu2Kisanbi, seisanbi, Riritsu,
                                M_KashitsukeukeireZan);

                        // 積数1と積数2の合計
                        sekisuu = sekisuu1.add(sekisuu2);
                    }

                } else {
                    // 積数計算 パターン4
                    // 特利有効期限が起算日より前の日付の場合 or
                    // 特利有効期限が精算日より後の日付の場合

                    String targetRiritu = Riritsu;
                    if (Integer.parseInt(Date_TokuriYuko) < Integer.parseInt(kisanbi)) {
                        // 特利有効期限が起算日より前の日付である場合
                        targetRiritu = Riritsu;
                    } else if (Integer.parseInt(Date_TokuriYuko) > Integer.parseInt(seisanbi)) {
                        // 特利有効期限が精算日より後の日付である場合
                        if (Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                            targetRiritu = Tokuri;
                        }
                    }

                    // 積数を計算する
                    sekisuu = calcSekisuu(kisanbi, seisanbi, targetRiritu, M_KashitsukeukeireZan);

                }
            }
        }

        return sekisuu;
    }

    /**
     *
     * <pre>
     * 積数C計算用の貸付受入金残高を取得する。
     * </pre>
     *
     * @param ID_M_Gankinjuto「元金充当額」
     * @param ID_M_ShikinHaraidashi「資金払出額」
     * @param M_KashitsukeukeireZan「貸付受入金残高」
     * @param isSimulation
     * @return 積数C用の貸付受入金残高
     */
    private BigDecimal getZandakaC(String ID_M_Gankinjuto, String ID_M_ShikinHaraidashi,
            BigDecimal M_KashitsukeukeireZan, boolean isSimulation) {

        if (!isSimulation) {
            return M_KashitsukeukeireZan;
        }

        BigDecimal gankinjuto = new BigDecimal(ID_M_Gankinjuto);
        BigDecimal shikinHaraidashi = new BigDecimal(ID_M_ShikinHaraidashi);

        // 「貸付受入金残高」 - (「元金充当額」 + 「資金払出額」)
        return M_KashitsukeukeireZan.subtract(gankinjuto).subtract(shikinHaraidashi);
    }

    /**
     *
     * <pre>
     * 引数の金額を使用して、控除利息計算(積数)を行う
     * </pre>
     *
     * @param sekisuuA 積数Aで計算した積数残高
     * @param sekisuuB 積数Bで計算した積数残高
     * @param sekisuuC 積数Cで計算した積数残高
     * @return 控除利息額(積数)
     */
    private BigDecimal calcKoujorisokuSekisuu(BigDecimal sekisuuAZandaka, BigDecimal sekisuuBZandaka,
            BigDecimal sekisuuCZandaka) {

        // 各積数残高を足す
        BigDecimal sekisuu = sekisuuAZandaka.add(sekisuuBZandaka).add(sekisuuCZandaka);
        // 365日(1年)で割る(小数点18で切り捨て)
        sekisuu = sekisuu.divide(new BigDecimal("365"), ROUND_DOWN_NUM, BigDecimal.ROUND_DOWN);
        // 100(パーセント)で割る(切り捨て)
        sekisuu = sekisuu.divide(new BigDecimal("100"), 0, BigDecimal.ROUND_DOWN);

        log.debug("控除利息計算額(積数)[" + sekisuu + "]");
        return sekisuu;
    }

    /**
     *
     * <pre>
     * 控除利息計算を「利息計算単位期間」で計算する
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param Riritsu「利率」
     * @param Tokuri「特利」
     * @param Date_TokuriYuko「特利有効期限」
     * @param Code_ShokanHouhou「償還方法コード」
     * @param kisanbi「起算日」
     * @param Date_Haraikomi「払込年月日」
     * @return 控除利息額(利息計算単位期間)
     */
    private BigDecimal calcKoujorisokuUnitPeriod(long ID_Credit, String Riritsu, String Tokuri,
            String Date_TokuriYuko, String Code_ShokanHouhou, String kisanbi, String Date_Haraikomi)
            throws PNSystemException {

        BigDecimal UnitPeriod = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        // 払出データを取得する
        PNCOM02_HaraidashiEntity haraidashi = new PNCOM02_HaraidashiEntity();
        haraidashi.setID_Credit(new BigDecimal(ID_Credit));
        haraidashi.setDate_HaraidashiJuto(kisanbi);
        haraidashi.setWhereMode("4");

        List<PNCOM02_HaraidashiEntity> haraidashiList = pncom02_HaraidashiDAO.findByCondition(haraidashi, 0,
                1);
        // if (haraidashiList != null && haraidashiList.size() != 0) {
        if (null != haraidashiList && 0 != haraidashiList.size()) {

            // 取得した「貸付受入金残高」が1以上の場合、控除利息計算を行う
            BigDecimal M_KashitsukeukeireZan = haraidashiList.get(0).getM_KashitsukeukeireZan();
            if (0 < M_KashitsukeukeireZan.compareTo(PNCommonConstants.BIGDECIMAL_ZERO_VALUE)) {

                String targetRiritu = Riritsu;

                // 「払込年月日」<=「特利有効年月日」かつ 「特利」<「利率」の場合
                // 利率には特利を設定する。
                if (StringUtils.isNotEmpty(Date_TokuriYuko)) {
                    // if (Integer.parseInt(Date_Haraikomi) < Integer.parseInt(Date_TokuriYuko)
                    if (Integer.parseInt(Date_Haraikomi) <= Integer.parseInt(Date_TokuriYuko)
                            && Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                        targetRiritu = Tokuri;
                    }
                }

                // 償還方法コードに対応する、月数を取得する
                BigDecimal bShokanHouhouMonth = new BigDecimal(getShokanHouhouMonth(Code_ShokanHouhou));

                // 利率を設定する(利率を100000で割って小数点第18桁切り捨てにする)
                BigDecimal bTargetRiritu = new BigDecimal(targetRiritu);
                bTargetRiritu = bTargetRiritu.divide(new BigDecimal(100000));

                // 控除利息計算「利息計算単位期間」を行う
                UnitPeriod = M_KashitsukeukeireZan.multiply(bTargetRiritu).divide(bShokanHouhouMonth, 0,
                        BigDecimal.ROUND_DOWN);

            }
        }

        log.debug("控除利息計算額(利息計算単位期間)[" + UnitPeriod + "]");
        return UnitPeriod;
    }

    /**
     *
     * <pre>
     * 控除利息計算を「利息計算単位期間」で計算し、
     * 控除利息額と対象の貸付受入金のリストを返却します。
     * 
     * 戻り値が異なるだけで、処理の内容は「calcKoujorisokuUnitPeriod」と同じです。
     * </pre>
     *
     * @param ID_Credit「債権管理番号」
     * @param Riritsu「利率」
     * @param Tokuri「特利」
     * @param Date_TokuriYuko「特利有効期限」
     * @param Code_ShokanHouhou「償還方法コード」
     * @param kisanbi「起算日」
     * @param Date_Haraikomi「払込年月日」
     * @return List<BigDecimal> 計算した控除利息額（エラー時 -1）、控除利息計算対象の貸付受入金残高（初期値 -1）
     */
    private List<BigDecimal> calcKoujorisokuUnitPeriodAndKashitukeUkeireZanList(long ID_Credit,
            String Riritsu, String Tokuri, String Date_TokuriYuko, String Code_ShokanHouhou, String kisanbi,
            String Date_Haraikomi) {

        BigDecimal targetKashitukeUkeireZan = DEFAULT_VALUE_KASHITUKEUKEIREKIN;
        List<BigDecimal> koujoKashitukeUkeireList = new ArrayList<BigDecimal>(2);

        BigDecimal UnitPeriod = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        // 払出データを取得する
        PNCOM02_HaraidashiEntity haraidashi = new PNCOM02_HaraidashiEntity();
        haraidashi.setID_Credit(new BigDecimal(ID_Credit));
        haraidashi.setDate_HaraidashiJuto(kisanbi);
        haraidashi.setWhereMode("4");

        List<PNCOM02_HaraidashiEntity> haraidashiList = pncom02_HaraidashiDAO.findByCondition(haraidashi, 0,
                1);
        // if (haraidashiList != null && haraidashiList.size() != 0) {
        if (null != haraidashiList && 0 != haraidashiList.size()) {

            // 取得した「貸付受入金残高」が1以上の場合、控除利息計算を行う
            BigDecimal M_KashitsukeukeireZan = haraidashiList.get(0).getM_KashitsukeukeireZan();
            // 控除利息計算対象の「貸付受入金」をセットする。
            targetKashitukeUkeireZan = M_KashitsukeukeireZan;
            if (0 < M_KashitsukeukeireZan.compareTo(PNCommonConstants.BIGDECIMAL_ZERO_VALUE)) {

                String targetRiritu = Riritsu;

                // 「払込年月日」<=「特利有効年月日」かつ 「特利」<「利率」の場合
                // 利率には特利を設定する。
                if (StringUtils.isNotEmpty(Date_TokuriYuko)) {
                    // if (Integer.parseInt(Date_Haraikomi) < Integer.parseInt(Date_TokuriYuko)
                    if (Integer.parseInt(Date_Haraikomi) <= Integer.parseInt(Date_TokuriYuko)
                            && Integer.parseInt(Tokuri) < Integer.parseInt(Riritsu)) {
                        targetRiritu = Tokuri;
                    }
                }

                // 償還方法コードに対応する、月数を取得する
                BigDecimal bShokanHouhouMonth = null;
                try {
                    // 貸付受入金は、取得した時点のものを返すので
                    // ここでは明示的にcatchする。
                    bShokanHouhouMonth = new BigDecimal(getShokanHouhouMonth(Code_ShokanHouhou));
                } catch (PNSystemException e) {
                    log.error("calcKoujorisokuUnitPeriod(利息計算単位期間による控除利息計算) でエラーが発生しました。" + e);
                    koujoKashitukeUkeireList.add(RETRUN_ERROR);
                    koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
                    return koujoKashitukeUkeireList;
                }

                // 利率を設定する(利率を100000で割って小数点第18桁切り捨てにする)
                BigDecimal bTargetRiritu = new BigDecimal(targetRiritu);
                bTargetRiritu = bTargetRiritu.divide(new BigDecimal(100000));

                // 控除利息計算「利息計算単位期間」を行う
                UnitPeriod = M_KashitsukeukeireZan.multiply(bTargetRiritu).divide(bShokanHouhouMonth, 0,
                        BigDecimal.ROUND_DOWN);

            }
        }

        log.debug("控除利息計算額(利息計算単位期間)[" + UnitPeriod + "]");
        log.debug("控除利息計対象の貸付受入金(利息計算単位期間)[" + targetKashitukeUkeireZan + "]");

        koujoKashitukeUkeireList.add(UnitPeriod);
        koujoKashitukeUkeireList.add(targetKashitukeUkeireZan);
        return koujoKashitukeUkeireList;
    }

    /**
     *
     * <pre>
     * 積数残高を計算する
     * 積数残高がマイナス値の場合、PNSystemExceptionを投げる
     * </pre>
     *
     * @param kisanbi 「起算日」
     * @param seisanbi「精算日」
     * @param riritsu 「利率」
     * @param zandaka 「積数残高」
     * @return
     */
    private BigDecimal calcSekisuu(String kisanbi, String seisanbi, String riritsu, BigDecimal zandaka)
            throws PNSystemException {

        BigDecimal sekisuu = PNKeisanSekisu.getSekisu(kisanbi, seisanbi, riritsu, zandaka);
        if (0 > sekisuu.compareTo(PNCommonConstants.BIGDECIMAL_ZERO_VALUE)) {
            // 積数残高がマイナス値の場合、エラーを投げる
            log.error("積数残高計算でマイナス値 計算した積数[" + sekisuu + "] 起算日[" + kisanbi + "] 精算日[" + seisanbi + "] 利率["
                    + riritsu + "] 積数残高[" + zandaka + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }
        return sekisuu;
    }

    /**
     *
     * <pre>
     * 償還方法コードの下一桁から
     * 「利息計算単位期間」の月数を取得する。
     *
     * </pre>
     *
     * @param Code_ShokanHouhou
     * @return
     * @throws PNSystemException
     */
    private int getShokanHouhouMonth(String Code_ShokanHouhou) throws PNSystemException {

        if (StringUtils.isEmpty(Code_ShokanHouhou) || 2 != Code_ShokanHouhou.length()) {
            // 償還方法コードが不正の場合、エラーを投げる
            log.error("償還方法コードが不正です 償還方法コード[" + Code_ShokanHouhou + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        int shokanHouhouNum = 0;
        String shokanHouhou = Code_ShokanHouhou.substring(1);
        // if (shokanHouhou.equals("1")) {
        if ("1".equals(shokanHouhou)) {
            // 12ヶ月
            shokanHouhouNum = 1;
        } else if ("2".equals(shokanHouhou)) {
            // 6ヶ月
            shokanHouhouNum = 2;
        } else if ("4".equals(shokanHouhou)) {
            // 3ヶ月
            shokanHouhouNum = 4;
        } else if ("6".equals(shokanHouhou)) {
            shokanHouhouNum = 6;
            // } else if (shokanHouhou.equals("B")) {
        } else if ("B".equals(shokanHouhou)) {
            // 1ヶ月
            shokanHouhouNum = 12;
        } else {
            // 償還方法コードの下一桁が不正の場合、エラーを投げる
            log.error("償還方法コードが不正です 償還方法コード[" + Code_ShokanHouhou + "]");
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }
        return shokanHouhouNum;
    }

    /**
     *
     * <pre>
     * 指定の日付に日数を足して返却をします
     * </pre>
     *
     * @param yyyyMMdd 日付
     * @param day 足し算する日数
     * @return 日数を換算した日付
     */
    private String addDay(String yyyyMMdd, int day) {
        DateFormat dt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = convertCalendar(yyyyMMdd);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return dt.format(calendar.getTime());
    }

    /**
     *
     * <pre>
     * 指定の日付に月を足して返却をします
     * </pre>
     *
     * @param yyyyMMdd 日付
     * @param month 足し算する月
     * @return 月を換算した日付
     */
    private String addMonth(String yyyyMMdd, int month) {
        DateFormat dt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = convertCalendar(yyyyMMdd);
        calendar.add(Calendar.MONTH, month);
        return dt.format(calendar.getTime());
    }

    /**
     *
     * <pre>
     * 指定の日付をカレンダーにして返します。
     * </pre>
     *
     * @param yyyyMMdd
     * @return
     */
    private Calendar convertCalendar(String yyyyMMdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(yyyyMMdd.substring(0, 4)));
        calendar.set(Calendar.MONTH, Integer.parseInt(yyyyMMdd.substring(4, 6)) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(yyyyMMdd.substring(6, 8)));
        return calendar;
    }

}
