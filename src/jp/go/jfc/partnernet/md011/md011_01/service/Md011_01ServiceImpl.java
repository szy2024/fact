//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md011_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.ShikinkofushukanreportDAO;
import jp.go.jfc.partnernet.common.dao.ShikinkofushukanreportEntity;
import jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataDAO;
import jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01ResultDataEntity;
import jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01TenpoNameResultDataDAO;
import jp.go.jfc.partnernet.md011.md011_01.dao.Md011_01TenpoNameResultDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはmd011_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Md011_01ServiceImpl extends PNBaseService implements Md011_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Md011_01ServiceImpl.class);

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** shikinkofushukanreportdao */
    @Autowired
    private ShikinkofushukanreportDAO shikinkofushukanreportdao;

    /** md011_01tenponameresultdatadao */
    @Autowired
    private Md011_01TenpoNameResultDataDAO md011_01tenponameresultdatadao;

    /** md011_01resultdatadao */
    @Autowired
    private Md011_01ResultDataDAO md011_01resultdatadao;

    /** PNCommonDBComponents */
    @Autowired
    private PNCommonDBComponents pnCommonDBComponents;

    /**
     * Md011_01ServiceのgetResultsData
     *
     * @param inDto Md011_01DTO
     * @return Md011_01DTO
     */
    @Override
    public Md011_01DTO getResultsData(Md011_01DTO inDto) {

        Md011_01DTO outDto = new Md011_01DTO();
        Md011_01ResultDataEntity inEntity = new Md011_01ResultDataEntity();

        // 取消・修正対象データの取得
        // 取得条件の設定
        // DTO.報告書番号 ⇒ Md011_01ResultsDataEntity.報告書番号
        inEntity.setID_Report(inDto.getID_Report());

        List<Md011_01ResultDataEntity> outEntityList = md011_01resultdatadao.findByCondition(inEntity);

        // ■取得件数をDTOに設定する。
        // ・取得件数 ⇒DTO.取得件数
        int dataCount = 0;
        if (null != outEntityList) {
            dataCount = outEntityList.size();
        }
        outDto.setDataCount(dataCount);

        // 取得件数 ＞ ０件 の場合、取得した情報をDTOに設定する。
        if (dataCount > 0) {

            Md011_01ResultDataEntity outEntity = outEntityList.get(0);

            // Entity⇒DTOに転記
            // DTO.履歴番号
            outDto.setID_History(outEntity.getID_History());

            // DTO.報告書番号
            outDto.setID_Report(outEntity.getID_Report());

            // DTO.指定交付日
            outDto.setLblID_ShiteiKofu(outEntity.getDate_Kofu());

            // DTO.指定交付日（年）
// [UPD] Ver 3.0.0 - START
//            outDto.setDrpID_ShiteiKofuYear(String.valueOf(Integer.parseInt(outEntity.getDate_Kofu().substring(
//                    PNCommonConstants.DATE1_YEAR_BEGIN_INDEX, PNCommonConstants.DATE1_YEAR_END_INDEX))));
            outDto.setDrpID_ShiteiKofuYear(PNCommonComponents.dateFmtAD_YYYYMMDD(outEntity.getDate_Kofu()).split("\\.")[0]);
// [UPD] Ver 3.0.0 - END

            // DTO.指定交付日（月）
            outDto.setDrpID_ShiteiKofuMonth(String.valueOf(Integer.parseInt(outEntity.getDate_Kofu().substring(
                    PNCommonConstants.DATE1_MONTH_BEGIN_INDEX, PNCommonConstants.DATE1_MONTH_END_INDEX))));
            // DTO.指定交付日（日）
            outDto.setDrpID_ShiteiKofuDate(String.valueOf(Integer.parseInt(outEntity.getDate_Kofu().substring(
                    PNCommonConstants.DATE1_DAY_BEGIN_INDEX, PNCommonConstants.DATE1_DAY_END_INDEX))));
            List<Md011_01M1DTO> m1List = new ArrayList<Md011_01M1DTO>();
            Md011_01M1DTO m1Dto = new Md011_01M1DTO();

            // DTO.依頼予定額
            m1Dto.setTxtID_M_Yotei(outEntity.getM_Yotei());
            // DTO.資金交付金残高見込額（指定交付日の前日現在）
            m1Dto.setTxtID_M_ZanMikomi(outEntity.getM_ZanMikomi());
            // DTO.元金充当額（外数）
            m1Dto.setTxtID_M_Ganju_GaiSu(outEntity.getM_Ganju_GaiSu());
            // DTO.備考
            m1Dto.setTxtID_M_Biko(outEntity.getM_Biko());
            // DTO.更新日時
            m1Dto.setDateTime_Update(outEntity.getDateTime_Update());

            m1List.add(m1Dto);

            outDto.setMEISAI_LIST(m1List);

        }

        return outDto;

    }

    /**
     * Md011_01ServiceのupdateDataDel
     *
     * @param inDto Md011_01DTO
     * @return Md011_01DTO
     */
    @Override
    public Md011_01DTO updateDataDel(Md011_01DTO inDto) {

        Md011_01DTO outDto = new Md011_01DTO();

        // 共通部品より業務日付を取得
        String strDateReport = pnCommonDBComponents.getPNBusinessDay(1);
        if (!PNCommonComponents.checkDate(strDateReport)) {
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 共通部品よりシステム時間を取得
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // -----------------------------------------------------------------------------
        // （１）．金融機関名称の取得
        // -----------------------------------------------------------------------------
        // 取得条件の設定
        Md011_01TenpoNameResultDataEntity inTenpoNameEntity = new Md011_01TenpoNameResultDataEntity();

        // ・ログインユーザの扱店コード
        inTenpoNameEntity.setCode_Organization(
                PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        List<Md011_01TenpoNameResultDataEntity> outTenpoNameEntity =
                md011_01tenponameresultdatadao.findByCondition(inTenpoNameEntity);

        // ■取得した件数＝０の場合、業務エラーとする。
        // エラーメッセージ：PM9060E
        if (outTenpoNameEntity == null || outTenpoNameEntity.isEmpty()) {
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);

        }

        // 取得結果をDTOに設定
        String strNameOrg = outTenpoNameEntity.get(0).getName_Organization();

        // -----------------------------------------------------------------------------
        // （２）．楽観的排他
        // -----------------------------------------------------------------------------
        Md011_01M1DTO m1Dto = inDto.getMEISAI_LIST().get(0);

        ShikinkofushukanreportEntity inEntitySSG = new ShikinkofushukanreportEntity();

        // 単テーブルアクセス定義「資金交付依頼書（週間）報告書データNo.5件数取得」を実行し、件数を取得する。
        // 取得条件の設定
        // DTO.報告書番号 ⇒ ShikinkofushukanReportEntity.報告書番号
        inEntitySSG.setID_Report(inDto.getID_Report());
        // DTO.更新年月日 ⇒ ShikinkofushukanReportEntity.更新年月日
        inEntitySSG.setDateTime_Update(m1Dto.getDateTime_Update());

        long hitCountSKG = shikinkofushukanreportdao.countByCondition(inEntitySSG);

        // ■取得した件数 ≠ １ の場合、業務エラーとする。
        // エラーメッセージ：PM9030E
        if (hitCountSKG != 1) {
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // -----------------------------------------------------------------------------
        // （３）．資金交付依頼書（週間）報告書データの該当レコードの削除
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        try {
            shikinkofushukanreportdao.findByPrimaryKeyForUpdate(inEntitySSG);

        }
        catch (CFWFindParameterException e) {
            log.error("資金交付依頼書（週間）報告書データ排他読み込み時にエラー発生", e);
            throw new PNSystemException(e);

        }
        catch (CFWForUpdateException e) {
            // ■排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, e);

        }

        // 単テーブルアクセス定義「資金交付依頼書（週間）報告書データNo.7削除処理」を実行し、削除を行う。
        try {
            shikinkofushukanreportdao.delete(inEntitySSG);
        }
        catch (CFWFindParameterException e) {
            log.error("資金交付依頼書（週間）報告書データ削除時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // -----------------------------------------------------------------------------
        // （４）．報告書履歴データの更新
        // -----------------------------------------------------------------------------
        ReporthistoryEntity inEntityRH = new ReporthistoryEntity();

        // データの更新処理を行う。
        // 取得条件の設定
        inEntityRH.setID_History(inDto.getID_History());

        try {
            // 単テーブルアクセス定義「報告書履歴データNo.3排他読込」を実行し、排他制御を行う。
            reporthistorydao.findByPrimaryKeyForUpdate(inEntityRH);
        }
        catch (CFWFindParameterException e) {
            throw new PNSystemException(e);
        }
        catch (CFWForUpdateException e) {
            // ■排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, e);
        }

        // 単テーブルアクセス定義「報告書履歴データNo.3更新処理」を実行し、更新を行う。
        // 報告書履歴データを設定する。

        inEntityRH.setID_Report(null);
        inEntityRH.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1));

        try {
            reporthistorydao.update(inEntityRH);
        }
        catch (CFWFindParameterException e) {
            log.error("報告書履歴データ更新処理時にエラー発生", e);
            throw new PNSystemException(e);
        }
        catch (CFWDuplicateKeyException e) {
            log.error("報告書履歴データ更新処理時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // -----------------------------------------------------------------------------
        // （５）．報告書履歴データの登録
        // -----------------------------------------------------------------------------
        inEntityRH = new ReporthistoryEntity();

        // 共通部品より履歴番号最大値を取得
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        inEntityRH.setID_History(strID_History);

        // 単テーブルアクセス定義「報告書履歴データのNo1件数取得」を実行し、件数を取得する。
        long hitCount = reporthistorydao.countByCondition(inEntityRH);

        if (0 < hitCount) {
            // ■取得した件数＞０の場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // 報告書履歴データを設定する。
        inEntityRH = setReportHistory(inDto, strNameOrg, strID_History, strDateReport,
                strSysDateTime, PNCommonConstants.STATUS_VALUE_7, PNCommonConstants.TYPE_PROCESS_10);

        // 単テーブルアクセス定義「報告書履歴データNo.4登録処理」を実行し、登録を行う。
        try {
            reporthistorydao.insert(inEntityRH);
        }
        catch (CFWDuplicateKeyException e) {
            log.error("報告書履歴データ登録処理時にエラー発生", e);
            throw new PNSystemException(e);
        }

        return outDto;
    }

    /**
     * Md011_01ServiceのupdateDataMod
     *
     * @param inDto Md011_01DTO
     * @return Md011_01DTO
     */
    @Override
    public Md011_01DTO updateDataMod(Md011_01DTO inDto) {

        Md011_01DTO outDto = new Md011_01DTO();

        // 共通部品より業務日付を取得
        String strDateReport = pnCommonDBComponents.getPNBusinessDay(1);
        if (!PNCommonComponents.checkDate(strDateReport)) {
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }

        // 共通部品よりシステム時間を取得
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);

        // -----------------------------------------------------------------------------
        // （１）．金融機関名称の取得
        // -----------------------------------------------------------------------------
        // 取得条件の設定
        Md011_01TenpoNameResultDataEntity inTenpoNameEntity = new Md011_01TenpoNameResultDataEntity();

        // ・ログインユーザの扱店コード
        inTenpoNameEntity.setCode_Organization(
                PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        List<Md011_01TenpoNameResultDataEntity> outTenpoNameEntity =
                md011_01tenponameresultdatadao.findByCondition(inTenpoNameEntity);

        // ■取得した件数＝０の場合、業務エラーとする。
        // エラーメッセージ：PM9060E
        if (outTenpoNameEntity == null || outTenpoNameEntity.isEmpty()) {
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);

        }

        // 取得結果をDTOに設定
        String strNameOrg = outTenpoNameEntity.get(0).getName_Organization();

        // -----------------------------------------------------------------------------
        // （２）．指定交付日の重複チェック
        // -----------------------------------------------------------------------------
        // PM3960E : {0}のデータは既に登録済みの為、登録できません。
        // ※{0}･･･"指定交付日が" + 指定交付日（Hzz年MM月dd日）
        String[] msg = chkKofuDuplicate(inDto);
        if (!msg[0].isEmpty()) {
            throw new PNServiceException(PNCommonMessageConstants.PM3960E, msg, false);
        }

        // -----------------------------------------------------------------------------
        // （３）．楽観的排他
        // -----------------------------------------------------------------------------
        Md011_01M1DTO m1Dto = inDto.getMEISAI_LIST().get(0);

        ShikinkofushukanreportEntity inEntitySSG = new ShikinkofushukanreportEntity();

        // 取得条件の設定
        // DTO.報告書番号 ⇒ ShikinkofushukanReportEntity.報告書番号
        inEntitySSG.setID_Report(inDto.getID_Report());
        // DTO.更新年月日 ⇒ ShikinkofushukanReportEntity.更新年月日
        inEntitySSG.setDateTime_Update(m1Dto.getDateTime_Update());

        // 単テーブルアクセス定義「資金交付依頼書（週間）報告書データNo.5件数取得」を実行し、件数を取得する。
        long hitCountSKG = shikinkofushukanreportdao.countByCondition(inEntitySSG);

        if (hitCountSKG != 1) {
            // ■取得した件数 ≠ １ の場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // -----------------------------------------------------------------------------
        // （４）．資金交付依頼書（週間）報告書データの該当レコードの削除
        // -----------------------------------------------------------------------------
        // データの更新処理を行う。
        try {
            shikinkofushukanreportdao.findByPrimaryKeyForUpdate(inEntitySSG);

        }
        catch (CFWFindParameterException e) {
            log.error("資金交付依頼書（週間）報告書データ排他読み込み時にエラー発生", e);
            throw new PNSystemException(e);

        }
        catch (CFWForUpdateException e) {
            // ■排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, e);

        }

        // 資金交付依頼書（週間）報告書データを設定する。
        inEntitySSG = setShikinkofushukanreport(inDto, strDateReport, strSysDateTime, m1Dto);

        // 単テーブルアクセス定義「資金交付依頼書（週間）報告書データ　No.8更新処理」を実行し、更新を行う。
        try {
            shikinkofushukanreportdao.update(inEntitySSG);
        }
        catch (CFWFindParameterException e) {
            log.error("資金交付依頼書（週間）報告書データ更新時にエラー発生", e);
            throw new PNSystemException(e);
        }
        catch (CFWDuplicateKeyException e) {
            // ■排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E, e);
        }

        // -----------------------------------------------------------------------------
        // （５）．報告書履歴データの更新
        // -----------------------------------------------------------------------------
        ReporthistoryEntity inEntityRH = new ReporthistoryEntity();

        // データの更新処理を行う。
        // 取得条件の設定
        inEntityRH.setID_History(inDto.getID_History());

        try {
            // 単テーブルアクセス定義「報告書履歴データNo.3排他読込」を実行し、排他制御を行う。
            reporthistorydao.findByPrimaryKeyForUpdate(inEntityRH);
        }
        catch (CFWFindParameterException e) {
            throw new PNSystemException(e);
        }
        catch (CFWForUpdateException e) {
            // ■排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, e);
        }

        // 単テーブルアクセス定義「報告書履歴データNo.3更新処理」を実行し、更新を行う。
        // 報告書履歴データを設定する。

        inEntityRH.setID_Report(null);
        inEntityRH.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1));

        try {
            reporthistorydao.update(inEntityRH);
        }
        catch (CFWFindParameterException e) {
            log.error("報告書履歴データ更新処理時にエラー発生", e);
            throw new PNSystemException(e);
        }
        catch (CFWDuplicateKeyException e) {
            log.error("報告書履歴データ更新処理時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // -----------------------------------------------------------------------------
        // （６）．報告書履歴データの登録
        // -----------------------------------------------------------------------------
        inEntityRH = new ReporthistoryEntity();

        // 共通部品より履歴番号最大値を取得
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        inEntityRH.setID_History(strID_History);

        // 単テーブルアクセス定義「報告書履歴データのNo1件数取得」を実行し、件数を取得する。
        long hitCount = reporthistorydao.countByCondition(inEntityRH);

        if (0 < hitCount) {
            // ■取得した件数＞０の場合、業務エラーとする。
            // エラーメッセージ：PM9030E
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // 報告書履歴データを設定する。
        inEntityRH = setReportHistory(inDto, strNameOrg, strID_History, strDateReport,
                strSysDateTime, PNCommonConstants.STATUS_VALUE_6, PNCommonConstants.TYPE_PROCESS_20);

        // 単テーブルアクセス定義「報告書履歴データNo.4登録処理」を実行し、登録を行う。
        try {
            reporthistorydao.insert(inEntityRH);
        }
        catch (CFWDuplicateKeyException e) {
            log.error("報告書履歴データ登録処理時にエラー発生", e);
            throw new PNSystemException(e);
        }

        return outDto;
    }

    /**
     * 指定交付日重複チェック
     * 重複ありの場合メッセージを返却
     *
     * @param dateKogu 指定交付日（yyyyMMdd）
     * @return msg
     */
    private String[] chkKofuDuplicate(Md011_01DTO inDto) {

        String[] msg = new String[] { "" };

        // DTO.指定交付日（年）をyyyy形式に変換し、DTO.指定交付日（月）、DTO.指定交付日（日）と結合
        // 　⇒　指定交付日（yyyyMMdd）
        // 指定交付日が同一の報告書の件数を取得する。
        // 取得条件の設定
        Md011_01ResultDataEntity inEntity = new Md011_01ResultDataEntity();
        inEntity.setID_Report(inDto.getID_Report());
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        inEntity.setDate_Kofu(dateKofu(inDto));
        long hitcount = md011_01resultdatadao.countByCondition(inEntity);

        // ■取得した件数 ＞ ０ の場合、エラーとする。
        // ※{0}･･･"指定交付日が" + 指定交付日（Hzz年MM月dd日）
        if (hitcount > 0) {
            msg[0] = PNCommonComponents.concatString(
                    "指定交付日が"
                    , inDto.getDrpID_ShiteiKofuYear()
                    , "年"
                    , inDto.getDrpID_ShiteiKofuMonth()
                    , "月"
                    , inDto.getDrpID_ShiteiKofuDate()
                    , "日");

        }

        return msg;

    }

    /**
     * 報告書履歴データ設定処理
     *
     * @param inDto           画面情報
     * @param strNameOrg      扱店名
     * @param strID_History   履歴番号保持
     * @param strDateReport   報告年月日
     * @param strSysDateTime  報告時分秒
     * @param strStatus       ステータス
     * @param strType_Process 処理モード
     * @return 報告書履歴データ
     */
    private ReporthistoryEntity setReportHistory(Md011_01DTO inDto, String strNameOrg, String strID_History,
            String strDateReport, String strSysDateTime, String strStatus, String strType_Process) {
        ReporthistoryEntity inEntity = new ReporthistoryEntity();

        // 履歴番号最大値 ⇒ ReporthistoryEntity.履歴番号
        inEntity.setID_History(strID_History);

        // 報告書番号最大値 ⇒ ReporthistoryEntity.報告書番号
        inEntity.setID_Report(inDto.getID_Report());

        // 報告年月日（yyyyMMdd） ⇒ ReporthistoryEntity.報告年月日
        inEntity.setDate_Report(strDateReport);

        // 現在時刻（hhmmss） ⇒ ReporthistoryEntity.報告時分秒
        inEntity.setTime_Report(strSysDateTime);

        // 7（取消済み）/ 6（ステータス無し） ⇒ ReporthistoryEntity.ステータス
        inEntity.setStatus(new BigDecimal(strStatus));

        // 空文字 ⇒ ReporthistoryEntity.原本番号
        inEntity.setID_Master(PNCommonConstants.LITERAL_BLANK);

        // 90257130（資金交付依頼書（週間）） ⇒ ReporthistoryEntity.データコード
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257140);

        // "10"（削除）/ "20"（修正） ⇒ ReporthistoryEntity.処理種別
        inEntity.setType_Process(strType_Process);

        // 0（取消非対象） ⇒ ReporthistoryEntity.取消済みフラグ
        inEntity.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // ログインユーザのユーザID ⇒ ReporthistoryEntity.ユーザID
        inEntity.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());

        // DTO.扱店名 ⇒ ReporthistoryEntity.扱店名
        inEntity.setName_Organization(strNameOrg);

        // 空文字 ⇒ ReporthistoryEntity.顧客名
        inEntity.setName_Customer(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.公庫支店コード
        inEntity.setCode_KoukoShiten(PNCommonConstants.LITERAL_BLANK);

        // ログインユーザの扱店コード ⇒ ReporthistoryEntity.扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo()
                .getCode_Organization());

        // 空文字 ⇒ ReporthistoryEntity.店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo()
                .getCode_Tenpo());

        // 空文字 ⇒ ReporthistoryEntity.年度
        inEntity.setYear(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.方式資金
        inEntity.setCode_HoshikiShikin(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.稟議番号
        inEntity.setID_Ringi(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.稟議番号枝番
        inEntity.setID_RingiBranch(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.エラーコード
        inEntity.setCode_Error(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.エラーメッセージ
        inEntity.setErrorMessage(PNCommonConstants.LITERAL_BLANK);

        // null ⇒ ReporthistoryEntity.債権管理番号
        inEntity.setID_Credit(null);

        // "0" ⇒ ReporthistoryEntity.退避賦金
        inEntity.setKeep_M_Fukin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避元金不均等額
        inEntity.setKeep_M_GankinFukinto(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.退避元金不均等額区分
        inEntity.setKeep_Kubun_GankinFukinto(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.退避貸付金残高
        inEntity.setKeep_M_KashitsukeZan(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避約定元金
        inEntity.setKeep_M_YakujoGankin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避約定利息
        inEntity.setKeep_M_YakujoRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.退避償還期限年月
        inEntity.setKeep_Date_ShokanKigen(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.元利金受入充当報告書の控除利息
        inEntity.setKeep_M_KojoRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.元利金受入充当報告書の払込期日
        inEntity.setKeep_Date_Haraikomi(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.請求データの退避任意繰上償還利息
        inEntity.setKeep_Seikyu_M_NinKuriRisoku(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.請求データの退避請求繰上償還利息
        inEntity.setKeep_Seikyu_M_SeiKuriRisoku(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.請求データの退避請求繰上償還元金
        inEntity.setKeep_Seikyu_M_SeiKuriGankin(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.約定データの退避請求繰上償還利息
        inEntity.setKeep_Yakujo_M_SeiKuriRisoku(BigDecimal.ZERO);

        // 空文字 ⇒ ReporthistoryEntity.扱店別稟議データの退避条変起案中区分
        inEntity.setKeep_JohenKianchu(PNCommonConstants.LITERAL_BLANK);

        // 空文字 ⇒ ReporthistoryEntity.退避履歴番号
        inEntity.setKeep_ID_History(PNCommonConstants.LITERAL_BLANK);

        // "0" ⇒ ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        inEntity.setKeep_Flag_Kj(BigDecimal.ZERO);

        // "0" ⇒ ReporthistoryEntity.退避受入後立替金残高
        inEntity.setKeep_M_TatekaeZanAfterUkeire(BigDecimal.ZERO);

        return inEntity;
    }

    /**
     * 資金交付依頼書（週間）報告書データ設定処理
     *
     * @param inDto 画面情報
     * @param strID_Report 報告書番号保持
     * @param strDateReport 報告年月日
     * @param strSysDateTime 報告時分秒
     * @return 資金交付依頼書（週間）報告書データ
     */
    private ShikinkofushukanreportEntity setShikinkofushukanreport(Md011_01DTO inDto,
            String strDateReport, String strSysDateTime, Md011_01M1DTO m1Dto) {

        ShikinkofushukanreportEntity inEntity = new ShikinkofushukanreportEntity();

        // 報告書番号
        inEntity.setID_Report(inDto.getID_Report());

        // 報告年月日
        inEntity.setDate_Report(strDateReport);

        // 報告時分秒
        inEntity.setTime_Report(strSysDateTime);

        // ユーザＩＤ
        inEntity.setUserID(PNCommonInfoHolder.getCommonInfo().getLogonID());

        // 伝送番号
        inEntity.setID_Denso(PNCommonConstants.LITERAL_BLANK);

        // データコード 90257140（資金交付依頼書（週間）報告書）
        inEntity.setDataCode(PNCommonConstants.DATACODE_90257140);

        // 扱店コード
        inEntity.setCode_Organization(PNCommonInfoHolder.getCommonInfo()
                .getCode_Organization());

        // 店舗コード
        inEntity.setCode_Tenpo(PNCommonInfoHolder.getCommonInfo()
                .getCode_Tenpo());

        // 指定交付日
        inEntity.setDate_Kofu(dateKofu(inDto));

        // 依頼予定額
        inEntity.setM_Yotei(new BigDecimal(PNCommonComponents
                .cnvNulltoZero(m1Dto.getTxtID_M_Yotei())));

        // 資金交付金残高見込額（指定交付日の前日現在）
        inEntity.setM_ZanMikomi(new BigDecimal(PNCommonComponents
                .cnvNulltoZero(m1Dto.getTxtID_M_ZanMikomi())));

        // 元金充当額（外数）
        inEntity.setM_Ganju_GaiSu(new BigDecimal(PNCommonComponents
                .cnvNulltoZero(m1Dto.getTxtID_M_Ganju_GaiSu())));

        // 備考
        inEntity.setM_Biko(m1Dto.getTxtID_M_Biko());

        return inEntity;

    }

    /**
     * 画面情報を基に指定交付日をyyyyMMdd形式で返します。
     *
     * @param inDto 画面情報
     * @return 指定交付日（yyyyMMdd形式）
     */
    private String dateKofu(Md011_01DTO inDto) {

        StringBuilder sb = new StringBuilder("");

        // 指定交付日（年）
        sb.append(inDto.getDrpID_ShiteiKofuYear());

        // 指定交付日（月）
        sb.append(String.format("%02d", Integer.parseInt(
                inDto.getDrpID_ShiteiKofuMonth())));

        // 指定交付日（日）
        sb.append(String.format("%02d", Integer.parseInt(
                inDto.getDrpID_ShiteiKofuDate())));

// [UPD] Ver 3.0.0 - START
//        return sb.toString();
        return PNCommonComponents.dateFmtJC_Gyymmdd(sb.toString(), "");
// [UPD] Ver 3.0.0 - END

    }
}