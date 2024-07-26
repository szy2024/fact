//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_02.service;

import jp.go.jfc.partnernet.md009.md009_02.service.Md009_02ServiceImpl;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;

import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.cr009.common.Cr009Constants;
import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.KariukesonotareportDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.KariukesonotareportEntity;

/**
 * <pre>
 * このクラスはCr009_02のサービスクラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public class Cr009_02ServiceImpl extends PNBaseService implements Cr009_02Service {

    /** Log */
    private static Log log = LogFactory.getLog(Md009_02ServiceImpl.class);

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** kariukesonotareportdao */
    @Autowired
    private KariukesonotareportDAO kariukesonotareportdao;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /** PNJpCalendarUtils */
    @Autowired
    private PNJpCalendarUtils jpCalendarUtils;

    /**
     * Cr009_02Serviceのregist
     *
     * @param inDto Cr009_02DTO
     * @return Cr009_02DTO
     */
    @Override
    public Cr009_02DTO regist(Cr009_02DTO inDto) {

        Cr009_02DTO outDto = new Cr009_02DTO();
        ReporthistoryEntity inEntityRH = new ReporthistoryEntity();

        // 報告書履歴データの登録

        // 履歴番号最大値
        String nextIDHistory = pnCommonDBComponents.getIdHistoryRh();
        // 報告書番号最大値
        String nextIDReport = pnCommonDBComponents.getIdReportRh();

        // 追加を行うデータの確認
        // 　　単テーブルアクセス定義「報告書履歴データのNo1.件数取得」を参照し、件数を取得する。
        // 　　　　ReporthistoryDAO.countByCondition
        inEntityRH.setID_History(nextIDHistory);
        long hitCountRH = reporthistorydao.countByCondition(inEntityRH);

        // 　　■取得した件数　＞　０　の場合
        if (0 < hitCountRH) {
            // 　　メッセージID：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[]{});
        }

        // DTO.報告年月日を"YYYYMMDD"形式に変換 ⇒ 報告年月日(YYYYMMDD)
        String dateReport = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        // 現在時刻を"HHMMSS"形式で取得 ⇒ 現在時刻(HHMMSS)
        String dateTime = PNFormatUtils.formatDate(PNDateUtils.getSystemDate(),
                Cr009Constants.DATE_PATTERN_HHMMSS);

        // ログインユーザ情報
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();

        // 報告書履歴データの登録内容の編集
        // 　・履歴番号最大値 ⇒ ReporthistoryEntity.履歴番号
        // 　・報告書番号最大値　 ⇒ ReporthistoryEntity.報告書番号
        // 　・報告年月日(YYYYMMDD) ⇒ ReporthistoryEntity.報告年月日
        // 　・現在時刻(HHMMSS) ⇒ ReporthistoryEntity.現在時刻
        // 　・1（予約中） ⇒ ReporthistoryEntity.ステータス
        // 　・90257120（留置期間利息・代弁遅延損害金受入充当報告書） ⇒ ReporthistoryEntity.データコード
        // 　・00（作成） ⇒ ReporthistoryEntity.処理種別
        // 　・0（取消非対象） ⇒ ReporthistoryEntity.取消済みフラグ
        // 　・ログインユーザのユーザID ⇒ ReporthistoryEntity.ユーザID
        // 　・DTO.扱店名 ⇒ ReporthistoryEntity.扱店名
        // 　・DTO.公庫支店 ⇒ ReporthistoryEntity.公庫支店コード
        // 　・DTO.扱店 ⇒ ReporthistoryEntity.扱店コード
        // 　・DTO.店舗 ⇒ ReporthistoryEntity.店舗コード
        inEntityRH.setID_History(nextIDHistory);
        inEntityRH.setID_Report(nextIDReport);
        inEntityRH.setDate_Report(dateReport);
        inEntityRH.setTime_Report(dateTime);
        inEntityRH.setStatus(PNCommonUtils.cnvStrtoBig(PNCommonConstants.STATUS_VALUE_1));
        inEntityRH.setDataCode(PNCommonConstants.DATACODE_90257120);
        inEntityRH.setType_Process(PNCommonConstants.TYPE_PROCESS_00);
        inEntityRH.setFlag_Torikeshizumi(PNCommonUtils.cnvStrtoBig(PNCommonConstants.FLAG_TORIKESHIZUMI_0));
        inEntityRH.setUserID(pnCommonInfo.getLogonID());
        inEntityRH.setName_Organization(inDto.getLblID_Name_Organization());
        inEntityRH.setCode_KoukoShiten(inDto.getLblID_Code_ShokanHonShiten());
        inEntityRH.setCode_Organization(inDto.getLblID_Code_Organization());
        inEntityRH.setCode_Tenpo(inDto.getLblID_Code_Tenpo());

        // 単テーブルアクセス定義の「報告書履歴データのNo2.登録処理」を実行し、報告書データを新規登録する。
        // 　　ReporthistoryDAO.insert
        try {
            reporthistorydao.insert(inEntityRH);
        } catch (CFWDuplicateKeyException e) {
            log.error("報告書履歴データ登録処理時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // 留置期間利息・代弁遅延損害金受入報告書データの登録
        // 留置期間利息・代弁遅延損害金受入報告書データの登録内容の編集
        // 　・受託者勘定処理年月（元号）＋（年）＋（月）を西暦変換 ⇒ 受託者勘定処理年月(西暦)
        // 　・送金年月日（元号）＋（年）＋（月）＋（日）を西暦変換 ⇒ 送金年月日(西暦)
        // 　・入金日（元号）＋（年）＋（月）＋（日）を西暦変換 ⇒ 入金日(西暦)
        String dateJtkshori = PNCommonComponents.dateFmtJC_Gyymm(inDto.getLblID_Date_Jtkshori(), "");
        String dateSokin = PNCommonComponents.dateFmtJC_Gyymmdd(inDto.getLblID_Date_Sokin(), "");
        String dateNyukin = PNCommonComponents.dateFmtJC_Gyymmdd(inDto.getLblID_Date_Nyukin(), "");

        // 　・履歴登録時に採番された報告書番号最大値 ⇒ KariukesonotareportEntity.報告書番号
        // 　・報告年月日(YYYYMMDD) ⇒ KariukesonotareportEntity.報告年月日
        // 　・現在時刻(HHMMSS) ⇒ KariukesonotareportEntity.現在時刻
        // 　・ログインユーザのユーザID ⇒ KariukesonotareportEntity.ユーザID
        // 　・90257120（留置期間利息・代弁遅延損害金受入充当報告書） ⇒ KariukesonotareportEntity.データコード
        // 　・DTO.扱店 ⇒ KariukesonotareportEntity.扱店コード
        // 　・DTO.公庫支店 ⇒ KariukesonotareportEntity.公庫支店コード
        // 　・DTO.店舗 ⇒ KariukesonotareportEntity.店舗コード
        // 　・受託者勘定処理年月(西暦) ⇒ KariukesonotareportEntity.受託者勘定処理年月
        // 　・送金年月日(西暦) ⇒ KariukesonotareportEntity.送金年月日
        // 　・DTO.送金日番号 ⇒ KariukesonotareportEntity.送金日番号
        // 　・入金日(西暦) ⇒ KariukesonotareportEntity.入金日
        // 　・DTO.留置期間利息 ⇒ KariukesonotareportEntity.留置期間利息
        // 　・DTO.代弁遅延損害金 ⇒ KariukesonotareportEntity.代弁遅延損害金
        // 　・DTO.送金額 ⇒ KariukesonotareportEntity.送金額
        // 　・DTO.扱店名 ⇒ KariukesonotareportEntity.扱店名
        KariukesonotareportEntity inEntityKSR = new KariukesonotareportEntity();

        inEntityKSR.setID_Report(nextIDReport);
        inEntityKSR.setDate_Report(dateReport);
        inEntityKSR.setTime_Report(dateTime);
        inEntityKSR.setUserID(pnCommonInfo.getLogonID());
        inEntityKSR.setDataCode(PNCommonConstants.DATACODE_90257120);
        inEntityKSR.setCode_KoukoShiten(inDto.getLblID_Code_ShokanHonShiten());
        inEntityKSR.setCode_Organization(inDto.getLblID_Code_Organization());
        inEntityKSR.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
        inEntityKSR.setDate_Jtkshori(dateJtkshori);
        inEntityKSR.setDate_Sokin(dateSokin);
        inEntityKSR.setID_Sokinbi(inDto.getLblID_Code_Sokin());
        inEntityKSR.setDate_Nyukin(dateNyukin);
        inEntityKSR
                .setM_RyuchiKikanRisoku(PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_RyuchiKikanRisoku()));
        inEntityKSR
                .setM_DaibenChienSongai(PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_DaibenChienSongai()));
        inEntityKSR.setM_Sokin(PNCommonUtils.cnvBigStrMoney(inDto.getLblID_M_Sokin()));
        inEntityKSR.setName_Organization(inDto.getLblID_Name_Organization());

        // 単テーブルアクセス定義「留置期間利息・代弁遅延損害金受入報告書データのNo3.件数取得」を参照し、件数を取得する。
        // 　　KariukesonotareportDAO.countByCondition
        long hitCountKSR = kariukesonotareportdao.countByCondition(inEntityKSR);

        // ■取得した件数　＝　０　の場合
        // 　　単テーブルアクセス定義の「留置期間利息・代弁遅延損害金受入報告書データのNo4.登録処理」を実行し、報告書データを新規登録する。
        // 　　　　KariukesonotareportDAO.insert
        if (0 == hitCountKSR) {
            try {
                kariukesonotareportdao.insert(inEntityKSR);
            } catch (CFWDuplicateKeyException e) {
                log.error("留置期間利息・代弁遅延損害金受入報告書データ登録処理時にエラー発生", e);
                throw new PNSystemException(e);
            }
        }

        // ■取得した件数　≧　１　の場合、エラーとする。
        // 　　メッセージID：PM9010E
        if (1 <= hitCountKSR) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }

        return outDto;
    }
}