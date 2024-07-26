//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCommonDBComponents
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/06 | ○○　○              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.common.dao.CommonKinriDAO;
import jp.go.jfc.partnernet.common.dao.CommonKinriEntity;
import jp.go.jfc.partnernet.common.dao.CommonMaxValueDAO;
import jp.go.jfc.partnernet.common.dao.CommonMaxValueEntity;
import jp.go.jfc.partnernet.common.dao.HieigyobiDAO;
import jp.go.jfc.partnernet.common.dao.HieigyobiEntity;
import jp.go.jfc.partnernet.common.dao.KessanbiDAO;
import jp.go.jfc.partnernet.common.dao.KessanbiEntity;
import jp.go.jfc.partnernet.common.dao.PNCOM09_HiEigyobiDAO;
import jp.go.jfc.partnernet.common.dao.PNCOM09_HiEigyobiEntity;
import jp.go.jfc.partnernet.common.dao.PnDateDAO;
import jp.go.jfc.partnernet.common.dao.PnDateEntity;
import jp.go.jfc.partnernet.common.dao.TokuriDAO;
import jp.go.jfc.partnernet.common.dao.TokuriEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.apache.commons.lang.StringUtils;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスは共通部品(DB参照)クラスです。
 * </pre>
 *
 * @author 富士通)○○　○
 * @version 1.0.0
 */
public class PNCommonDBComponents {

    /** hieigyobiDAO */
    @Autowired
    private HieigyobiDAO hieigyobiDAO = null;

    /** pndateDAO */
    @Autowired
    private PnDateDAO pndateDAO = null;

    /** kessanbiDAO */
    @Autowired
    private KessanbiDAO kessanbiDAO = null;

    /** tokuriDAO */
    @Autowired
    private TokuriDAO tokuriDAO = null;

    /** commonkinriDAO */
    @Autowired
    private CommonKinriDAO commonkinriDAO = null;

    /** commonMaxValueDAO */
    @Autowired
    private CommonMaxValueDAO commonMaxValueDAO = null;

    @Autowired
    PNCOM09_HiEigyobiDAO pncom09_HiEigyobiDAO = null;

    /**
     * 営業日算出
     *
     * <pre>
     * 基準日からスキップ日数を足した営業日を算出する。
     * ※非営業日は非営業日テーブルを使用する。
     * 戻り値：yyyyMMdd形式
     * </pre>
     *
     * @param strReferenceDate
     *            基準日
     * @param intSkipDays
     *            スキップ日数
     * @return String 算出営業日
     */
    public String getCalculateBusinessDay(String strReferenceDate,
            int intSkipDays) {
        // スキップ日数チェック
        if (intSkipDays == 0 || intSkipDays < -365 || intSkipDays > 365) {
            return null;
        }

        // 日付チェック
        if (!checkDate(strReferenceDate)) {
            return null;
        }

        // 営業日判定
        if (chkBusinessDay(strReferenceDate) != null) {
            // 営業日の場合、基準日を返却する
            return strReferenceDate;
        }

        // スキップ日数の絶対値を設定
        int intChkSkipAbsDays = Math.abs(intSkipDays);

        // 営業日カウンタの初期化
        int intEigyoDayCnt = 0;
        // 日付カウントアップの状態を取得
        int intDayCnt = 0;
        if (intSkipDays > 0) {
            intDayCnt = 1;
        }
        else {
            intDayCnt = -1;
        }

        // 指定日付をセット
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,
                Integer.parseInt(strReferenceDate.substring(0, 4)));
        calendar.set(Calendar.MONTH,
                Integer.parseInt(strReferenceDate.substring(4, 6)) - 1);
        calendar.set(Calendar.DAY_OF_MONTH,
                Integer.parseInt(strReferenceDate.substring(6, 8)));

        DateFormat dt = new SimpleDateFormat("yyyyMMdd");
        String strResult = null;

        // ループは最大365までとする。（365=1年）
        // 営業日判定処理で、データが取得できない場合
        // 無限ループになる可能性があるため
        // 現行の処理と同様にしています
        for (int i = 0; i < 365; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, intDayCnt);

            String businessDay = chkBusinessDay(dt.format(calendar.getTime()));
            if (businessDay != null) {
                // 営業日の場合、営業日カウンタをインクリメント
                intEigyoDayCnt++;
                // 返却用変数に取得した営業日をセット
                strResult = businessDay;
            }
            else {
                // 非営業日の場合、返却用変数をnullにする。
                strResult = null;
            }

            if (intEigyoDayCnt == intChkSkipAbsDays) {
                // 営業日カウンタとスキップ日数が同じの場合、処理を抜ける
                break;
            }
        }
        return strResult;
    }

    /**
     * 営業日判定
     *
     * <pre>
     * 引数で渡された日付が営業日であるか否かのチェック処理
     * ●引数チェックについて
     * ・引数の日付が8桁（yyyyMMdd）以外は引数エラーとする。
     * ・引数の日付が暦上日付でない場合エラーとする。
     * ●その他
     * ・戻り値が”Nothign”の場合、メソッドのCall側は引数で渡した日付が「非営業日」とする。
     * ・引数で渡された日付がDB中に存在しない＝”営業日”となる。
     * </pre>
     *
     * @param strDate
     *            日付
     * @return String 判定営業日
     */
    public String chkBusinessDay(String strDate) {

        try {
            // 日付チェック
            if (!checkDate(strDate)) {
                return null;
            }

            HieigyobiEntity paramHieigyobiEntity = new HieigyobiEntity();
            paramHieigyobiEntity.setDate_HiEigyo(strDate);

            HieigyobiEntity entity = hieigyobiDAO
                    .findByPrimaryKey(paramHieigyobiEntity);
            if (entity == null) {
                // データが取得できない場合は、営業日として strDate を返す
                return strDate;
            }
            // データが取得できた場合は、非営業日として null を返す
            return null;

        }
        catch (Exception e) {
            // 例外発生時は握りつぶし、nullを返す(現行と同様)
            return null;
        }
    }

    /**
     * 報告書履歴データの報告書番号最大値取得
     *
     * <pre>
     * 報告履歴データの報告書番号の最大値を取得し、１加算して報告書番号を返す。
     * 報告書番号(西暦(年)2桁＋内部連番7桁)
     * </pre>
     *
     * @return String 報告書番号
     */
    public String getIdReportRh() {
        return getNewIDValue(null, "ID_Report", "ReportHistory", null);
    }

    /**
     * 報告書履歴データの履歴番号最大値取得
     *
     * <pre>
     * 報告履歴データの履歴番号の最大値を取得し、１加算して履歴番号を返す。
     * 履歴番号(西暦(年)2桁＋内部連番7桁)
     * </pre>
     *
     * @return String 履歴番号
     */
    public String getIdHistoryRh() {
        return getNewIDValue(null, "ID_History", "ReportHistory", null);
    }

    /**
     * 利率取得
     *
     * <pre>
     * 利率を取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param intEntityIndex
     *            エンティティ配列番号
     * @param strCompDate
     *            比較対象日付
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @return BigDecimal 利率
     */
    public BigDecimal getRiritsuData(LinkedHashMap<String, String> DataEntity,
            Integer intEntityIndex, String strCompDate,
            String strKashitsukeKikanYear) {

        try {
            CommonKinriEntity entity = getKinriEntity(DataEntity,
                    strKashitsukeKikanYear, strCompDate);
            if (entity == null) {
                return null;
            }
            return entity.getRiritsu();
        }
        catch (PNSystemException e) {
            // throw new PNSystemException("利率(" + (intEntityIndex + 1) +
            // "案件目)");
            // 例外発生時はnullを返すようにする
            return null;
        }
    }

    /**
     * 利子助成率取得取得
     *
     * <pre>
     * 利子助成率取得を取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param intEntityIndex
     *            エンティティ配列番号
     * @param strCompDate
     *            比較対象日付
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @return BigDecimal 利子助成率取得
     */
    public BigDecimal getJoseiRiritsuData(
            LinkedHashMap<String, String> DataEntity, Integer intEntityIndex,
            String strCompDate, String strKashitsukeKikanYear) {

        try {
            CommonKinriEntity entity = getKinriEntity(DataEntity,
                    strKashitsukeKikanYear, strCompDate);
            if (entity == null) {
                return null;
            }
            return entity.getRishiJoseiRitsu();
        }
        catch (PNSystemException e) {
            // throw new PNSystemException("利子助成率(" + (intEntityIndex + 1) +
            // "案件目)");
            // 例外発生時はnullを返すようにする
            return null;
        }
    }

    /**
     * 据置中利子助成率取得
     *
     * <pre>
     * 据置中利子助成率を取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param intEntityIndex
     *            エンティティ配列番号
     * @param strCompDate
     *            比較対象日付
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @return BigDecimal 据置中利子助成率
     */
    public BigDecimal getSueokiChuJoseiRitsu(
            LinkedHashMap<String, String> DataEntity, Integer intEntityIndex,
            String strCompDate, String strKashitsukeKikanYear) {

        try {
            TokuriEntity entity = getTokuriEntity(DataEntity,
                    strKashitsukeKikanYear, strCompDate);
            if (entity == null) {
                return null;
            }
            return entity.getSueokiChuJoseiRitsu();
        }
        catch (PNSystemException e) {
            // throw new PNSystemException("特利(" + (intEntityIndex + 1) +
            // "案件目)");
            // 例外発生時はnullを返すようにする
            return null;
        }

    }

    /**
     * 実行後３年特利取得取得
     *
     * <pre>
     * 実行後３年特利を取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param intEntityIndex
     *            エンティティ配列番号
     * @param strCompDate
     *            比較対象日付
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @return BigDecimal 実行後３年特利
     */
    public BigDecimal getThreeYearsTokuri(
            LinkedHashMap<String, String> DataEntity, Integer intEntityIndex,
            String strCompDate, String strKashitsukeKikanYear) {

        try {
            TokuriEntity entity = getTokuriEntity(DataEntity,
                    strKashitsukeKikanYear, strCompDate);
            if (entity == null) {
                return null;
            }
            return entity.getThreeYearsTokuri();
        }
        catch (PNSystemException e) {
            // throw new PNSystemException("特利(" + (intEntityIndex + 1) +
            // "案件目)");
            // 例外発生時はnullを返すようにする
            return null;
        }

    }

    /**
     * 据置中特利取得
     *
     * <pre>
     * 据置中特利を取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param intEntityIndex
     *            エンティティ配列番号
     * @param strCompDate
     *            比較対象日付
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @return BigDecimal 据置中特利
     */
    public BigDecimal getSueokiChuTokuri(
            LinkedHashMap<String, String> DataEntity, Integer intEntityIndex,
            String strCompDate, String strKashitsukeKikanYear) {

        try {
            TokuriEntity entity = getTokuriEntity(DataEntity,
                    strKashitsukeKikanYear, strCompDate);
            if (entity == null) {
                return null;
            }
            return entity.getSueokiChuTokuri();
        }
        catch (PNSystemException e) {
            // throw new PNSystemException("特利(" + (intEntityIndex + 1) +
            // "案件目)");
            // 例外発生時はnullを返すようにする
            return null;
        }

    }

    /**
     * 実行日と決定起算日の２点間の利率取得
     *
     * <pre>
     * 実行日と決定起算日の２点間の利率を比較し、低い方を出力する。
     * </pre>
     *
     * @param DataEntityHikaku
     * @param Code_KinriKosho
     * @param Code_KinriKoshoSaimoku
     * @param Date_JikkoHikaku
     * @param Date_KetteiKisanHikaku
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @param intEntityIndex
     * @return BigDecimal 利率
     */
    public BigDecimal getNitenkanHikakuRiritsu(
            LinkedHashMap<String, String> DataEntityHikaku,
            String Code_KinriKosho, String Code_KinriKoshoSaimoku,
            String Date_JikkoHikaku, String Date_KetteiKisanHikaku,
            String strKashitsukeKikanYear, Integer intEntityIndex) {
        BigDecimal minRiritsuValue = BigDecimal.ZERO;

        try {
            LinkedHashMap<String, String> copyDataEntityHikaku = new LinkedHashMap<String, String>();
            copyDataEntityHikaku.putAll(DataEntityHikaku);

            // 金利呼称細目コード変換前の、実行時の金利情報を取得
            CommonKinriEntity dateJikkoKinriBefore = getKinriEntity(
                    copyDataEntityHikaku, strKashitsukeKikanYear,
                    Date_JikkoHikaku);
            if (dateJikkoKinriBefore == null) {
                return null;
            }

            // 金利呼称細目コード変換前の、決定時の金利情報を取得
            CommonKinriEntity dateKetteiKisanKinriBefore = getKinriEntity(
                    copyDataEntityHikaku, strKashitsukeKikanYear,
                    Date_KetteiKisanHikaku);
            if (dateKetteiKisanKinriBefore == null) {
                return null;
            }

            // 引数の金利呼称細目コードを設定。
            copyDataEntityHikaku.put("Code_KinriKoshoSaimoku",
                    Code_KinriKoshoSaimoku);

            // 入力された貸付実行日を比較対象の日付として利率および利子助成率を取得する。
            CommonKinriEntity dateJikkoKinri = getKinriEntity(
                    copyDataEntityHikaku, strKashitsukeKikanYear,
                    Date_JikkoHikaku);
            if (dateJikkoKinri == null) {
                return null;
            }

            // 扱店別稟議データの決定起算日を比較対象の日付として利率および利子助成率を取得する。
            CommonKinriEntity dateKetteiKisanKinri = getKinriEntity(
                    copyDataEntityHikaku, strKashitsukeKikanYear,
                    Date_KetteiKisanHikaku);
            if (dateKetteiKisanKinri == null) {
                return null;
            }

            // （実行日の利率-利子助成率）> (決定起算日の利率-利子助成率）
            BigDecimal jikkou = dateJikkoKinri.getRiritsu().subtract(
                    dateJikkoKinri.getRishiJoseiRitsu());
            BigDecimal ketteikisann = dateKetteiKisanKinri.getRiritsu()
                    .subtract(dateKetteiKisanKinri.getRishiJoseiRitsu());
            if (jikkou.compareTo(ketteikisann) > 0) {
                // 決定起算日より求めた利率を採用
                minRiritsuValue = dateKetteiKisanKinriBefore.getRiritsu();
            }
            else {
                // 貸付実行日より求めた利率を採用
                minRiritsuValue = dateJikkoKinriBefore.getRiritsu();
            }
        }
        catch (PNSystemException e) {
            // 例外発生時はnullを返すようにする
            return null;
        }

        return minRiritsuValue;
    }

    /**
     * 本店決算整理日付取得
     *
     * <pre>
     * 戻り値：日付（西暦"yyyyMMdd"形式）
     *          ⇒本店決算整理日付
     *        Nothing
     *          ⇒本店決算整理日付の取得エラーまたは
     *           　DBエラー（参照、接続エラー等）
     *
     * </pre>
     *
     * @return String 本店決算整理日付
     * @throws CFWFindParameterException
     */
    public String getKessanbi() {
        try {
            String strRetDate = null;

            KessanbiEntity paramKessanbiEntity = new KessanbiEntity();
            paramKessanbiEntity.setID_Kessan("KESSAN1");

            KessanbiEntity entity = kessanbiDAO
                    .findByPrimaryKey(paramKessanbiEntity);
            if (entity != null) {
                strRetDate = entity.getDate_Kessanbi();
            }
            return strRetDate;
        }
        catch (CFWFindParameterException e) {
            return null;
        }
    }

    /**
     * 業務日付取得
     *
     * <pre>
     * 業務日付データ（テーブル）から業務日付を取得する。
     *
     * 戻り値：業務日付　（西暦 YYYYMMDD）
     * </pre>
     *
     * @param intOnBatLFG
     *            1：Online業務日付を取得 2：Bat業務日付を取得
     * @return String strPNBusinessDay
     */
    public String getPNBusinessDay(Integer intOnBatFLG) {

        String strPNBusinessDay = "";

        if (intOnBatFLG.intValue() == PNCommonConstants.KUBUN_PN_ONLINE
                || intOnBatFLG.intValue() == PNCommonConstants.KUBUN_PN_BAT) {
            try {
                PnDateEntity param = new PnDateEntity();
                param.setSystem_ID("PN");
                PnDateEntity result = pndateDAO.findByPrimaryKey(param);

                if (result != null) {
                    if (intOnBatFLG.intValue() == PNCommonConstants.KUBUN_PN_ONLINE) {
                        strPNBusinessDay = result.getDate_PN_Online_Today();
                    }
                    else if (intOnBatFLG.intValue() == PNCommonConstants.KUBUN_PN_BAT) {
                        strPNBusinessDay = result.getDate_PN_Bat_Today();

                    }
                }
            }
            catch (CFWFindParameterException e) {
                throw new PNSystemException(e);
            }
        }

        return strPNBusinessDay;
    }

    /**
     * 最新のIDを取得する。
     *
     * <pre>
     * 引数で渡されたテーブルの項目名に対する最新のID(DBの最大値+１)の値を取得する。
     * エラーが発生した場合、エラーをThrowする。
     * このメソッドの予備元ではSqlClient.SqlException、ExceptionクラスをChacthできるようにしておくこと。
     * このメソッドは、履歴番号、原本番号、報告書番号の最新のID取得に対してのみ有効。
     * また、トランザクションを開始した後に最新のIDの取得処理を行う場合もあるため、
     * 引数にトランザクションを開始しているSQLオブジェクトのコマンドオブジェクトを使用できるようにする。
     * </pre>
     *
     * @param strCurrentID
     *            現在のID値
     * @param strTargetItemName
     *            項目名
     * @param strTargetTableName
     *            テーブル名
     * @param strWhere
     *            抽出条件
     * @return String 引数で渡されたテーブルの項目名に対する最新のID(DBの最大値+１)の値
     */
    public String getNewIDValue(String strCurrentID, String strTargetItemName,
            String strTargetTableName, String strWhere) {

        String tmpId = "";
        String whereString = strWhere;
        if (StringUtil.isEmpty(strCurrentID)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(PNDateUtils.getSystemDate());
            String yy = String.valueOf(cal.get(Calendar.YEAR)).substring(2);

            if (StringUtil.isEmpty(whereString)) {
                whereString = strTargetItemName + " LIKE '" + yy + "%'";
            }
            else {
                whereString = whereString + " AND " + strTargetItemName
                        + " LIKE '" + yy + "%'";
            }
            tmpId = getMaxValueData(strTargetItemName, strTargetTableName,
                    whereString);

            if (StringUtil.isEmpty(tmpId)) {
                tmpId = yy + "0000000";
            }
        }
        else {
            tmpId = strCurrentID.trim();
        }
        long newId = Long.parseLong(tmpId.substring(2)) + 1;
        return tmpId.substring(0, 2)
                + String.format("%0" + (tmpId.length() - 2) + "d", newId);
    }

    /**
     * DB項目の最大値取得
     *
     * <pre>
     * 引数で渡されたテーブルより引数で渡されたDB項目の最大値を取得する。
     * </pre>
     *
     * @param strTargetItemName
     *            項目名
     * @param strTargetTableName
     *            テーブル名
     * @param strWhere
     *            条件文
     * @return
     */
    public String getMaxValueData(String strTargetItemName,
            String strTargetTableName, String strWhere) {

        // 報告書番号最大値を担保する為、本店決算整理期日テーブルを排他(NOWAITではない)して読み込む
        CommonMaxValueEntity kessanInEntity = new CommonMaxValueEntity();
        kessanInEntity.setID_Kessan(PNCommonConstants.KESSANBI_KEY_KESSAN1);
        try {
            commonMaxValueDAO.findKessanbiForUpdate(kessanInEntity);
        }
        catch (CFWFindParameterException e) {
            throw new PNSystemException(e);
        }
        catch (CFWForUpdateException e) {
            throw new PNSystemException(e);
        }

        CommonMaxValueEntity inEntity = new CommonMaxValueEntity();

        inEntity.setTargetColumnName(strTargetItemName);
        inEntity.setTargetTableName(strTargetTableName);
        inEntity.setWhereString(strWhere);

        List<CommonMaxValueEntity> entityList = commonMaxValueDAO
                .findByCondition(inEntity);
        if (entityList == null || entityList.size() != 1) {
            // 取得データが1件ではない場合、エラーとする
            throw new PNSystemException();
        }
        return entityList.get(0).getMaxValue();
    }

    /**
     * 特利データを取得する。
     *
     * <pre>
     * 貸付期間別特利テーブルからデータを取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @param strCompDate
     *            比較対象日付
     * @return
     * @throws PNSystemException
     */
    private TokuriEntity getTokuriEntity(
            LinkedHashMap<String, String> DataEntity,
            String strKashitsukeKikanYear, String strCompDate)
            throws PNSystemException {

        TokuriEntity retEntity = null;

        String strKinriKoshoSaimokuCode = DataEntity
                .get("Code_KinriKoshoSaimoku");
        String strKinriKoshoCode = DataEntity.get("Code_KinriKosho");
        BigDecimal strYears = null;
        if (!StringUtils.isEmpty(strKashitsukeKikanYear)) {
            strYears = new BigDecimal(strKashitsukeKikanYear);

        }
        String compDate = strCompDate;

        // 空、nullは0に指定する。
        if (compDate == null || "".equals(compDate)) {
            compDate = "0";
        }

        try {
            int iCompDate = Integer.parseInt(compDate);

            TokuriEntity param = new TokuriEntity();
            param.setCode_KinriKosho(strKinriKoshoCode);
            param.setCode_KinriKoshoSaimoku(strKinriKoshoSaimokuCode);
            param.setYears_KashitsukeKikan(strYears);

            List<TokuriEntity> result = tokuriDAO.findByCondition(param);

            String strYearTmp = "99";
            if (result != null) {
                Iterator<TokuriEntity> iterator = result.iterator();
                while (iterator.hasNext()) {
                    TokuriEntity row = iterator.next();
                    String strTokuriStart = row.getDate_TokuriStart();
                    String strTokuriEnd = row.getDate_TokuriEnd();

                    // 空、nullは0に指定する。
                    if (strTokuriStart == null || "".equals(strTokuriStart)) {
                        strTokuriStart = "0";
                    }
                    if (strTokuriEnd == null || "".equals(strTokuriEnd)) {
                        strTokuriEnd = "0";
                    }
                    int iTokuriStart = Integer.parseInt(strTokuriStart);
                    int iTokuriEnd = Integer.parseInt(strTokuriEnd);

                    // 計算により取得した貸付期間年数（.ID_Date_KashitsukeKikanYear）を持つレコードが存在するか？
                    // 存在した場合、計算で取得した貸付期間年数を使用し該当レコードの抽出を行う
                    // 存在しない場合、貸付期間年数='99'として該当レコードの抽出を行う
                    if (iTokuriStart <= iCompDate && iTokuriEnd >= iCompDate) {
                        retEntity = row;
                        break;
                    }
                }
            }

            if (retEntity == null) {

                param.setYears_KashitsukeKikan(new BigDecimal(strYearTmp));

                result = tokuriDAO.findByCondition(param);
                if (result != null) {
                    Iterator<TokuriEntity> iterator = result.iterator();
                    while (iterator.hasNext()) {
                        TokuriEntity row = iterator.next();
                        String strTokuriStart = row.getDate_TokuriStart();
                        String strTokuriEnd = row.getDate_TokuriEnd();

                        // 空、nullは0に指定する。
                        if (strTokuriStart == null || "".equals(strTokuriStart)) {
                            strTokuriStart = "0";
                        }
                        if (strTokuriEnd == null || "".equals(strTokuriEnd)) {
                            strTokuriEnd = "0";
                        }
                        int iTokuriStart = Integer.parseInt(strTokuriStart);
                        int iTokuriEnd = Integer.parseInt(strTokuriEnd);

                        if (iTokuriStart <= iCompDate
                                && iTokuriEnd >= iCompDate) {
                            retEntity = row;
                            break;
                        }
                    }
                }
            }

        }
        catch (PNSystemException pe) {
            throw new PNSystemException(pe);
        }
        catch (NumberFormatException ne) {
            throw new PNSystemException(ne);
        }
        return retEntity;
    }

    /**
     * 金利データを取得する。
     *
     * <pre>
     * 貸付期間別金利テーブルからデータを取得する。
     * </pre>
     *
     * @param DataEntity
     *            画面入力項目
     * @param strKashitsukeKikanYear
     *            貸付期間年数
     * @param strCompDate
     *            比較対象日付
     * @return KinriEntity 金利エンティティ
     * @throws PNSystemException
     */
    private CommonKinriEntity getKinriEntity(
            LinkedHashMap<String, String> DataEntity,
            String strKashitsukeKikanYear, String strCompDate)
            throws PNSystemException {

        CommonKinriEntity inEntity = new CommonKinriEntity();
        inEntity.setCode_KinriKosho(DataEntity.get("Code_KinriKosho"));
        inEntity.setCode_KinriKoshoSaimoku(DataEntity
                .get("Code_KinriKoshoSaimoku"));
        inEntity.setDate_TekiyouStart(strCompDate);
        inEntity.setDate_TekiyouEnd(strCompDate);
        BigDecimal strYears = new BigDecimal(99);
        if (StringUtils.isNotEmpty(strKashitsukeKikanYear)) {
            strYears = new BigDecimal(strKashitsukeKikanYear);
        }
        inEntity.setYears_KashitsukeKikan(strYears);

        long count = commonkinriDAO.countByCondition(inEntity);
        if (count == 0) {
            // 該当レコードがない場合、貸付期間年数に99をセット
            inEntity.setYears_KashitsukeKikan(new BigDecimal(99));
        }

        List<CommonKinriEntity> entityList = commonkinriDAO
                .findByCondition(inEntity);
        if (entityList != null && entityList.size() == 1) {
            return entityList.get(0);
        }
        // 取得データが1件ではない場合、エラーとする
        throw new PNSystemException();
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
     * @param strDate
     *            チェック対象日付 YYYYMMDD
     * @return
     */
    private boolean checkDate(String strDate) {
        if (StringUtils.isEmpty(strDate) || strDate.length() != 8) {
            return false;
        }

        try {
            // 日付が正しいかチェックする。
            DateFormat dt = new SimpleDateFormat("yyyyMMdd");
            dt.setLenient(false);
            dt.parse(strDate);
        }
        catch (ParseException e) {
            // 例外発生時は握りつぶし、falseを返す
            return false;
        }

        return true;
    }

    /**
     *
     * <pre>
     * 業務日付をpatternの文字列でフォーマットした文字列を返します。
     * </pre>
     *
     * @param format
     *            フォーマット文字列
     * @return
     */
    public String getToDayFormat(String pattern) {

        StringBuffer tmpDate = new StringBuffer("");
        StringBuffer inDate = new StringBuffer(this.getPNBusinessDay(1));
        DateFormat dtFormat = new SimpleDateFormat(pattern);
        tmpDate.append(inDate.substring(0, 4));
        tmpDate.append("/");
        tmpDate.append(inDate.substring(4, 6));
        tmpDate.append("/");
        tmpDate.append(inDate.substring(6, 8));

        try {
            Date toDay = DateFormat.getDateInstance().parse(tmpDate.toString());
            return dtFormat.format(toDay);
        }
        catch (ParseException e) {
            return "";
        }

    }

    /**
     *
     * <pre>
     * 基準日から非営業日を除いた指定日数後の営業日を取得する。
     * </pre>
     *
     * @param baseDate 基準日
     * @param n 指定日数
     * @param maxDate 上限日
     * @return bizDate 営業日
     */
    public String calcBizDate(String baseDate, int n, String maxDate) {

        // 基準日の有効日付チェック
        // チェック結果がfalse（日付無効）の場合、以降の処理を行わず、空を返す。
        if (!checkDate(baseDate)) {
            return "";

        }

        // カレンダーオブジェクトに基準日を設定
        Calendar calBaseDate = PNCommonComponents.strToCal(baseDate);

        // ｎ＝０の場合、以降の処理を行わず、基準日を営業日として返す。
        if (n == 0) {
            return baseDate;

        }

        // 上限日 ≠ 空の場合
        Calendar calMaxDate = null;
        if (!StringUtils.isEmpty(maxDate)) {

            // 上限日の有効日付チェック
            // 共通部品の有効日付チェックを呼び出し、上限日の有効日付チェックを行う。
            // チェック結果がfalse（日付無効）の場合、以降の処理を行わず、空を返す。
            if (!checkDate(maxDate)) {
                return "";

            }

            // カレンダーオブジェクトに上限日を設定
            calMaxDate = PNCommonComponents.strToCal(maxDate);

            // 基準日、日数、上限日の相関チェック
            // ０ ＜ ｎかつ上限日 ＜ 基準日の場合
            // 以降の処理を行わず、空を返す。
            if (0 < n && calMaxDate.compareTo(calBaseDate) < 0) {
                return "";

            }

            // ｎ ＜ ０かつ基準日 ＜ 上限日 の場合
            // 以降の処理を行わず、空を返す。
            if (n < 0 && 0 < calMaxDate.compareTo(calBaseDate)) {
                return "";

            }

        }

        // 非営業日リストの取得
        PNCOM09_HiEigyobiEntity inEntity = new PNCOM09_HiEigyobiEntity();

        // 検索条件の編集
        // 基準日
        inEntity.setBaseDate(baseDate);
        // 上限日
        inEntity.setMaxDate(maxDate);

        // 上限日 ＝ 空の場合
        if (StringUtils.isEmpty(maxDate)) {

            // ０ ＜ ｎ の場合
            if (0 < n) {
                inEntity.setWhereMode(1);

                // ｎ ＜ ０ の場合
            }
            else if (n < 0) {
                inEntity.setWhereMode(2);

            }

            // 上記以外の場合
        }
        else {

            // ０ ＜ ｎ の場合
            if (0 < n) {
                inEntity.setWhereMode(3);

                // ｎ ＜ ０ の場合
            }
            else if (n < 0) {
                inEntity.setWhereMode(4);

            }

        }

        List<PNCOM09_HiEigyobiEntity> outEntity = pncom09_HiEigyobiDAO
                .findByCondition(inEntity);

        // 取得件数がnullの場合、以降の処理を行わず、空を返す
        if (outEntity == null) {
            return "";

        }

        // カウンタの設定
        // 営業日カウントを０で初期化
        // 非営業日カウントを０で初期化
        int bizDateCnt = 0;
        int hiEigyobiCnt = 0;

        // 営業日を基準日で初期化
        Calendar calBizDate = (Calendar)calBaseDate.clone();

        // 営業日カウント ＜ ｎの絶対値の間、以下の処理を繰り返す。
        while (bizDateCnt < Math.abs(n)) {

            // 営業日をインクリメント
            if (0 < n) {

                // 営業日＝営業日＋１日
                calBizDate.add(Calendar.DATE, 1);

            }
            else {

                // 営業日＝営業日－１日
                calBizDate.add(Calendar.DATE, -1);

            }

            // 基準日が営業日、非営業日のいずれか判断し、カウンタをインクリメントする
            // 非営業日カウント ＜ 非営業日リストの件数かつ基準日＝非営業日リスト[非営業日カウント] の場合
            if (hiEigyobiCnt < outEntity.size()
                    && PNCommonComponents.calToStr(calBizDate).equals(
                            outEntity.get(hiEigyobiCnt).getDate_HiEigyo())) {

                // 非営業日カウント ＝ 非営業日カウント＋１
                hiEigyobiCnt++;

                // 上記以外の場合
            }
            else {
                // 営業日カウント ＝ 営業日カウント＋１
                bizDateCnt++;

            }

        }

        return PNCommonComponents.calToStr(calBizDate);

    }

    /**
     *
     * <pre>
     * 業務日付の翌営業日を取得する。
     * （翌営業日は営業日の1ヵ月以内であること）
     * </pre>
     *
     * @return nextBizDate 翌営業日
     */
    public String calcNextBizDate() {

        // 業務日付取得
        Calendar calBizDate = PNCommonComponents.strToCal(getPNBusinessDay(1));
        String baseDate = new SimpleDateFormat("yyyyMMdd").format(calBizDate.getTime());

        // 業務日付の１ヵ月後の日付を上限日とする
        calBizDate.add(Calendar.MONTH, 1);
        String maxDate = new SimpleDateFormat("yyyyMMdd").format(calBizDate.getTime());

        // 翌営業日を取得
        String nextBizDate = calcBizDate(baseDate, 1, maxDate);

        return nextBizDate;

    }

    /**
     *
     * <pre>
     * 基準日をもとに資金交付依頼日を取得する。
     * 基準日が登録期限内の場合、基準日の翌月の1日を資金交付依頼日とする。
     * 基準日が登録期限外の場合、基準日の翌々月1日を資金交付依頼日とする。
     * 登録期限は、毎月25日（25日が非営業日の場合はその前営業日）の2営業日前。
     * </pre>
     *
     * @param baseDate 基準日
     *
     * @return kofuDate 資金交付依頼日（yyyyMMdd）
     *
     */
    public String calcKofuDate(String baseDate) {

        // 基準日の有効日付チェック
        // チェック結果がfalse（日付無効）の場合、以降の処理を行わず、空を返す。
        if (!checkDate(baseDate)) {
            return "";

        }

        // 基準日の２営業日後の日付（日付１）取得
        // 共通部品の営業日計算を呼び出し、基準日の２営業日後の日付を取得 ⇒ 日付１
        Calendar calTmp = PNCommonComponents.strToCal(baseDate);
        calTmp.add(Calendar.MONTH, 1);
        String maxDate = PNCommonComponents.calToStr(calTmp);

        Calendar calDate1 = PNCommonComponents.strToCal(calcBizDate(baseDate, 2, maxDate));

        // 基準日の月の25日の日付（日付２）を取得
        // 基準日のyyyyMM + "25" ⇒ 日付２
        Calendar calDate2 = PNCommonComponents.strToCal(baseDate.substring(0, 6).concat("25"));

        // 以下ループ
        // 日付２以前の直近の営業日（日付３）を取得
        Calendar calDate3 = (Calendar)calDate2.clone();
        do {
            // 日付２ ⇒ 日付３
            calDate3 = (Calendar)calDate2.clone();

            // 日付３が非営業日の間、以下ループ
            // 日付３ － １日　⇒　日付３
            while (chkBusinessDay(PNCommonComponents.calToStr(calDate3)) == null) {
                calDate3.add(Calendar.DATE, -1);
            }

            // 日付２の翌月の日付を日付２に設定
            calDate2.add(Calendar.MONTH, 1);

            // 日付１ ≦ 日付３ の場合ループを抜ける。
        } while (calDate3.compareTo(calDate1) < 0);

        // 日付３の翌月の１日の日付を資金交付依頼日として返す。
        calDate3.add(Calendar.MONTH, 1);
        calDate3.set(Calendar.DAY_OF_MONTH, 1);

        return PNCommonComponents.calToStr(calDate3);

    }

    /**
     * <pre>
     * 基準日をもとに指定交付日を取得する。
     * 指定交付日は、毎週水曜日（水曜日が非営業日の場合はその翌営業日）の日付である。
     * </pre>
     * @param baseDate 基準日
     *
     * @return 指定交付日（yyyyMMdd）
     *
     */
    public String calcShiteikofuDate(String baseDate) {

        // 基準日の有効日付チェック
        // チェック結果がfalse（日付無効）の場合、以降の処理を行わず、空を返す。
        if (!checkDate(baseDate)) {
            return "";

        }

        // 基準日以前の直近の水曜日の日付を取得する
        // 基準日をコピー
        Calendar calWedDate = PNCommonComponents.strToCal(baseDate);

        // 基準日の曜日(日～土：1～7)取得
        int dow = PNCommonComponents.strToCal(baseDate).get(Calendar.DAY_OF_WEEK);

        // 基準日から曜日の差分を引く（基準日が木曜の場合、(5 + 3) % 7 = 1 → 基準日の１日前が直近の水曜日 ）
        calWedDate.add(Calendar.DATE, -1 * ((dow + 3) % 7));

        // 上記日付以降の直近の営業日を取得
        Calendar calLatestDate = (Calendar)calWedDate.clone();
        while (chkBusinessDay(PNCommonComponents.calToStr(calLatestDate)) == null) {
            calLatestDate.add(Calendar.DATE, 1);

        }

        return PNCommonComponents.calToStr(calLatestDate);

    }

    /**
     * <pre>
     * 基準日が第何営業日かを計算する。
     * </pre>
     */
    public int calcOrdinalBizDate(String baseDate) {

        // 基準日の有効日付チェック
        // チェック結果がfalse（日付無効）の場合、以降の処理を行わず、空を返す。
        if (!checkDate(baseDate)) {
            return 0;

        }

        // 非営業日リストの取得
        PNCOM09_HiEigyobiEntity inEntity = new PNCOM09_HiEigyobiEntity();

        // 検索条件の編集
        inEntity.setBaseDate(PNCommonComponents.concatString(
                baseDate.substring(PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX),
                "01"));
        inEntity.setMaxDate(baseDate);
        inEntity.setWhereMode(3);

        List<PNCOM09_HiEigyobiEntity> outEntity = pncom09_HiEigyobiDAO
                .findByCondition(inEntity);

        // 取得件数がnullの場合、以降の処理を行わず、0を返す
        if (outEntity == null) {
            return 0;

        }

        // 基準日の日数
        String baseDateDay = baseDate.substring(
                PNCommonConstants.DATE1_DAY_BEGIN_INDEX, PNCommonConstants.DATE1_DAY_END_INDEX);

        // 営業日数 = 基準日の日にち - 非営業日リストの件数
        return Integer.parseInt(baseDateDay) - outEntity.size();

    }

    /**
     * <pre>
     * 決算期か通常期かを判定する。
     * </pre>
     */
    public boolean isKessanki() {

        // 業務日付取得
        String bizDate = getPNBusinessDay(1);

        // 業務日付の月取得
        String bizDateMonth = bizDate.substring(
                PNCommonConstants.DATE1_MONTH_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX);

        // 4月 または 10月 の場合決算期
        if (Integer.parseInt(bizDateMonth) == PNCommonConstants.KESSANKI_MONTH_1
                || Integer.parseInt(bizDateMonth) == PNCommonConstants.KESSANKI_MONTH_2) {
            return true;

        }
        // 上記以外（4月、10月以外）の場合通常期
        else {
            return false;

        }

    }
}
