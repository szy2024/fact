//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_03.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AringiDAO;
import jp.go.jfc.partnernet.common.dao.AringiEntity;
import jp.go.jfc.partnernet.common.dao.KanjomeisaiDAO;
import jp.go.jfc.partnernet.common.dao.KanjomeisaiEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.TatekaereportDAO;
import jp.go.jfc.partnernet.common.dao.TatekaereportEntity;
import jp.go.jfc.partnernet.cr001.common.Cr001Constants;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはcr006_03のサービスクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr006_03ServiceImpl extends PNBaseService implements Cr006_03Service {

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** kanjomeisaidao */
    @Autowired
    private KanjomeisaiDAO kanjomeisaidao;

    /** tatekaereportdao */
    @Autowired
    private TatekaereportDAO tatekaereportdao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    // 日付フォーマット
    private static final DateFormat dtFormat = new SimpleDateFormat(Cr001Constants.DATE_PATTERN_YYYY_MM_DD_E);

    /**
     * Cr006_03ServiceのsetUpdateInputData
     *
     * @param inDto Cr006_03DTO
     * @return Cr006_03DTO
     */
    @Override
    public Cr006_03DTO setUpdateInputData(Cr006_03DTO inDto) {

        Cr006_03DTO outDto = new Cr006_03DTO();
        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 画面の報告年月日を取得
        String strDateReport = cnvBlankToNulll(cnvDateYYYYMMDD(inDto.getLblID_Date_Report()));
        if (null == strDateReport) {
            strDateReport = pnCommonDBComponents.getPNBusinessDay(1);
        }
        // 報告書時分秒の取得
        // String strTimeReport =
        // PNCommonComponents.getSysDateTime().replaceAll(":", "");
        inDto.setID_Time_Report(PNCommonComponents.getSysDateTime());

        // 報告書履歴への追加処理を行う。（Ａ）
        // 報告書番号取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
        // 「報告書番号保持」に設定する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();

        // 履歴番号取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
        // 「履歴番号保持」に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();

        // 報告書履歴データ　件数取得
        long hitcount = 0L;
        // 報告書履歴への追加処理
        // 報告書履歴データの存在チェックをする。
        // 単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // ReporthistoryDAO.countByCondition
        ReporthistoryEntity inReporthistoryEntity = new ReporthistoryEntity();
        inReporthistoryEntity.setID_History(strID_History);
        hitcount = reporthistorydao.countByCondition(inReporthistoryEntity);
        // 取得した件数＞０の場合、業務エラーとする。
        if (0 < hitcount) {
            // エラーメッセージ：PTN001、DB004
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9020E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }
        // 報告書履歴データの登録用引数を設定する。
        ReporthistoryEntity outReporthistoryEntity = setReportHistory(inDto, strID_History, strID_Report,
                strDateReport);
        // 単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、引数を設定する。
        try {
            reporthistorydao.insert(outReporthistoryEntity);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // Cr006_03DTO.仮受仮払精算後残高（計算用）の空文字判定を行う。
        // 空文字の場合
        // 仮払金勘定明細データへの更新処理を行わない。
        String strKaribaraizanAfterSeisan = PNCommonComponents.cnvNulltoZero(inDto
                .getID_M_KaribaraiZanAfterSeisan());
        if (!Cr006Constants.LITERAL_CHAR_ZERO.equals(strKaribaraizanAfterSeisan)) {
            // 空文字以外の場合
            // 仮払金勘定明細データの更新
            outDto = updateKanjoMeisai(inDto);
            if (0 != outDto.getBizErrors().size()) {
                return outDto;
            }
        }

        // 立替金受入充当報告書データの追加処理を行う。
        outDto = insertTatekaeReport(inDto, strID_History, strID_Report, strDateReport);
        // 更新結果の判定を行う
        if (0 != outDto.getBizErrors().size()) {
            // 異常終了の場合、業務エラーとする
            return outDto;
        }

        // 扱店別稟議データの更新処理を行う。
        outDto = updateAringi(inDto, strDateReport);

        return outDto;
    }

    private Cr006_03DTO updateAringi(Cr006_03DTO inDto, String strDateReport) {
        Cr006_03DTO outDto = new Cr006_03DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 扱店別稟議データの更新処理を行う。
        AringiEntity inAringiEntity = new AringiEntity();
        AringiEntity outAringiEntity = new AringiEntity();

        // 扱店別稟議データの排他読込を行う。
        // 単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        try {
            // 債権管理番号
            BigDecimal idCredit = null;
            if (null != inDto.getID_ID_Credit()
                    && false == PNCommonConstants.LITERAL_BLANK.equals(inDto.getID_ID_Credit())) {
                idCredit = new BigDecimal(inDto.getID_ID_Credit());
            }
            inAringiEntity.setID_Credit(idCredit);

            Long hitCount = aringidao.countByCondition(inAringiEntity);
            if (0 != hitCount) {

                outAringiEntity = aringidao.findByPrimaryKeyForUpdate(inAringiEntity);

                if (null != outAringiEntity.getData_LastUpDate()
                        && !"".equals(outAringiEntity.getData_LastUpDate())) {

                    String strDateTimeDB = new SimpleDateFormat("yyyyMMddHHmmss").format(outAringiEntity
                            .getData_LastUpDate());
                    String strDateTimeDto = inDto.getID_Data_LastUpDate()
                            .replaceAll(PNCommonConstants.LITERAL_SLASH, PNCommonConstants.LITERAL_BLANK)
                            .replaceAll(" ", PNCommonConstants.LITERAL_BLANK)
                            .replaceAll(":", PNCommonConstants.LITERAL_BLANK);

                    if (!strDateTimeDB.equals(strDateTimeDto)) {
                        // 取得した最データの終更新日時がCr006_03DTO.最終データ更新日時と不一致の場合、業務エラーとする。
                        bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                        outDto.setBizErrors(bizErrors);
                        return outDto;
                    }
                }
            } else { // レコードが存在しない場合エラーとする。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                outDto.setBizErrors(bizErrors);
                return outDto;
            }

            // 扱店別稟議データの更新用引数を設定する。
            // 最新更新日時の設定
            // 画面の報告年月日と画面の報告時分秒が空白以外の場合、画面の報告年月日と画面の報告時分秒⇒AringiEntity.最新更新日時
            // 上記以外の場合、NULL値⇒AringiEntity.最新更新日時
            if (PNCommonConstants.LITERAL_BLANK.equals(strDateReport)
                    && PNCommonConstants.LITERAL_BLANK.equals(cnvBlankToNulll(inDto.getID_Time_Report()
                            .replaceAll(":", PNCommonConstants.LITERAL_BLANK)))) {
                outAringiEntity.setData_LastUpDate(null);
            } else {
                outAringiEntity.setData_LastUpDate(cnvTimeStamp(strDateReport, inDto.getID_Time_Report()));
            }
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理」を参照し、引数を設定する。
            // 更新の実行
            aringidao.update(outAringiEntity);

        } catch (CFWForUpdateException fue) {
            // リソースビジー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            // パラメータエラー
        } catch (CFWFindParameterException fpe) {
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }
        return outDto;
    }

    private Cr006_03DTO insertTatekaeReport(Cr006_03DTO inDto, String strID_History, String strID_Report,
            String strDateReport) {
        Cr006_03DTO outDto = new Cr006_03DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 立替金受入充当報告書データの追加処理を行う。
        TatekaereportEntity inTatekaereportEntity = new TatekaereportEntity();
        TatekaereportEntity outTatekaereportEntity = new TatekaereportEntity();

        // 抽出条件を設定する。
        // 報告書番号
        inTatekaereportEntity.setID_Report(strID_Report);

        // 立替金受入充当報告書データの存在チェックを行う。
        long lngTatekaeReportCount = 0L;
        lngTatekaeReportCount = tatekaereportdao.countByCondition(inTatekaereportEntity);
        if (0 != lngTatekaeReportCount) {
            // 件数＜＞０の場合
            // 対象データがすでに存在しているため、業務エラーとする。
            // エラーメッセージID：PM9010E
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 件数＝０の場合
        // 立替金受入充当報告書データをEntityへ設定する。（設定するDTO項目が空白の場合、NULLを設定する）
        outTatekaereportEntity = setTatekaeReportData(inDto, strID_Report, strDateReport);
        try {
            // 立替金受入充当報告書データの追加処理を行う。
            tatekaereportdao.insert(outTatekaereportEntity);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);

        }

        return outDto;
    }

    private TatekaereportEntity setTatekaeReportData(Cr006_03DTO inDto, String strID_Report,
            String strDateReport) {

        TatekaereportEntity outEntity = new TatekaereportEntity();

        // TatekaeReportEntity.報告書番号
        outEntity.setID_Report(cnvBlankToNulll(strID_Report));
        // TatekaeReportEntity.報告年月日
        outEntity.setDate_Report(cnvBlankToNulll(strDateReport));
        // TatekaeReportEntity.報告時分秒
        outEntity.setTime_Report(cnvBlankToNulll(inDto.getID_Time_Report().replaceAll(":", "")));
        // TatekaeReportEntity.ユーザＩＤ
        outEntity.setUserID(cnvBlankToNulll(inDto.getID_UserID()));
        // TatekaeReportEntity.データコード
        outEntity.setDataCode(cnvBlankToNulll(inDto.getID_DataCode()));
        // TatekaeReportEntity.公庫支店コード
        outEntity.setCode_KoukoShiten(cnvBlankToNulll(inDto.getTxtID_Code_KoukoShiten()));
        // TatekaeReportEntity.扱店コード
        outEntity.setCode_Organization(cnvBlankToNulll(inDto.getTxtID_Code_Organization()));
        // TatekaeReportEntity.店舗コード
        outEntity.setCode_Tenpo(cnvBlankToNulll(inDto.getTxtID_Code_Tenpo()));
        // TatekaeReportEntity.受託者勘定処理年月
        outEntity.setDate_Jtkshori(cnvBlankToNulll(inDto.getID_Date_Jtkshori()));
        // TatekaeReportEntity.送金日
        outEntity.setDate_Sokin(cnvBlankToNulll(inDto.getID_Date_Sokin()));
        // TatekaeReportEntity.送金日番号
        outEntity.setID_Sokinbi(cnvBlankToNulll(inDto.getTxtID_Code_Sokin()));
        // TatekaeReportEntity.年度
        outEntity.setYear(cnvBlankToNulll(inDto.getTxtID_Year()));
        // TatekaeReportEntity.方式資金
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inDto.getTxtID_Code_HoshikiShikin()));
        // TatekaeReportEntity.稟議番号
        outEntity.setID_Ringi(cnvBlankToNulll(inDto.getTxtID_ID_Ringi()));
        // TatekaeReportEntity.稟議番号枝番　（値が空白の場合、０を設定）
        outEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getTxtID_ID_RingiBranch()));
        // TatekaeReportEntity.立替金の種類
        outEntity.setCode_TatekaekinShurui(cnvBlankToNulll(inDto.getTxtID_Code_TatekaekinShurui()));
        // TatekaeReportEntity.公庫立替日
        outEntity.setDate_KoukoTatekae(cnvBlankToNulll(inDto.getTxtID_Date_KoukoTatekae()));
        // TatekaeReportEntity.入金日
        outEntity.setDate_Nyukin(cnvBlankToNulll(inDto.getID_Date_Nyukin()));
        // TatekaeReportEntity.立替金利息　　（カンマサプレスし設定）
        outEntity.setM_TatekaeRisoku(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto
                .getTxtID_M_TatekaeRisoku())));
        // TatekaeReportEntity.立替金　　　（カンマサプレスし設定）
        outEntity.setM_Tatekae(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto.getTxtID_M_Tatekae())));
        // TatekaeReportEntity.計　　　（カンマサプレスし設定）
        outEntity.setM_Kei(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto.getTxtID_M_Kei())));
        // TatekaeReportEntity.仮受金（一般口）からの充当　　　（カンマサプレスし設定）
        outEntity.setM_KariukeIppanJuto(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto
                .getTxtID_M_KariukeIppanJuto())));
        // TatekaeReportEntity.送金額　　　（カンマサプレスし設定）
        outEntity.setM_Sokin(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto.getTxtID_M_Sokin())));
        // TatekaeReportEntity.受入後立替金残高　　　（カンマサプレスし設定）
        outEntity.setM_TatekaeZanAfterUkeire(new BigDecimal(PNCommonComponents.cnvNulltoZero(inDto
                .getTxtID_M_TatekaeZanAfterUkeire())));
        // TatekaeReportEntity.扱店名
        outEntity.setName_Organization(cnvBlankToNulll(inDto.getTxtID_Name_Organization()));
        // TatekaeReportEntity.顧客名
        outEntity.setName_Customer(cnvBlankToNulll(inDto.getTxtID_Name_Customer()));
        // TatekaeReportEntity.退避本支店コード
        outEntity.setKeep_Code_HonShiten(cnvBlankToNulll(inDto.getID_Code_HonShiten()));
        // TatekaeReportEntity.退避仮受仮払番号
        outEntity.setKeep_ID_Karibarai(cnvBlankToNulll(inDto.getID_ID_Karibarai()));

        return outEntity;
    }

    private Cr006_03DTO updateKanjoMeisai(Cr006_03DTO inDto) {

        Cr006_03DTO outDto = new Cr006_03DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 仮払金勘定明細データへの更新処理を行う。
        KanjomeisaiEntity inKanjomeisaiEntity = new KanjomeisaiEntity();
        KanjomeisaiEntity outKanjomeisaiEntity = new KanjomeisaiEntity();

        // 仮払金勘定明細データの存在チェックを行う。
        // 抽出条件を設定する。
        // Cr006_03DTO.本支店コード
        inKanjomeisaiEntity.setCode_HonShiten(inDto.getID_Code_HonShiten());
        // Cr006_03DTO.仮受仮払番号
        inKanjomeisaiEntity.setID_Karibarai(inDto.getID_ID_Karibarai());
        // 対象データの件数の取得を行う。
        long lngKanjomeisaiCount = 0L;
        lngKanjomeisaiCount = kanjomeisaidao.countByCondition(inKanjomeisaiEntity);
        if (0 == lngKanjomeisaiCount) {
            // 件数＝０の場合
            // 対象データが存在していないため、業務エラーとする。
            // エラーメッセージID：PM9010E
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }
        if (1 < lngKanjomeisaiCount) {
            // 件数＞１の場合
            // 対象データが複数存在しているため、業務エラーとする。
            // エラーメッセージID：PM9010E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 仮払金勘定明細データをUPDATEの為に読込む。
        // Cr006_03DTO.本支店コード
        // Cr006_03DTO.仮受仮払番号
        try {
            // 仮払金勘定明細データの排他読込を行う。
            outKanjomeisaiEntity = kanjomeisaidao.findByPrimaryKeyForUpdate(inKanjomeisaiEntity);

            if (null == outKanjomeisaiEntity) {
                // 取得結果が排他エラーの場合、業務エラーとする。
                // エラーメッセージID：PM9010E
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                outDto.setBizErrors(bizErrors);
                return outDto;
            }

            // 仮払金勘定明細データへの更新処理を行う。
            // 更新データを設定する。
            // Cr006_03DTO.受入後立替金残高（円）をカンマサプレスし設定
            outKanjomeisaiEntity.setM_KaribaraiZanAfterSeisan(new BigDecimal(PNCommonComponents
                    .cnvNulltoZero(inDto.getTxtID_M_TatekaeZanAfterUkeire())));

            // 仮払金勘定明細データをUPDATE
            kanjomeisaidao.update(outKanjomeisaiEntity);

        } catch (CFWForUpdateException fue) {
            // リソースビジー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } catch (CFWFindParameterException fpe) {
            // パラメータエラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }
        return outDto;
    }

    private ReporthistoryEntity setReportHistory(Cr006_03DTO inDto, String strID_History,
            String strID_Report, String strDateReport) {

        ReporthistoryEntity outEntity = new ReporthistoryEntity();

        // 履歴番号の設定
        outEntity.setID_History(cnvBlankToNulll(strID_History));
        // 報告書番号の設定
        outEntity.setID_Report(cnvBlankToNulll(strID_Report));
        // 報告年月日の設定
        outEntity.setDate_Report(strDateReport);
        // 報告時分秒の設定
        outEntity.setTime_Report(inDto.getID_Time_Report().replaceAll(":", ""));
        // ステータスの設定
        BigDecimal status = null;
        if (null != inDto.getID_Status()) {
            status = new BigDecimal(inDto.getID_Status());
        }
        outEntity.setStatus(status);
        // データコードの設定
        outEntity.setDataCode(cnvBlankToNulll(inDto.getID_DataCode()));
        // 処理種別の設定
        outEntity.setType_Process(cnvBlankToNulll(inDto.getID_Type_Process()));
        // 取消済フラグの設定
        BigDecimal flgTorikesi = null;
        if (null != cnvBlankToNulll(inDto.getID_Flag_Torikeshizumi())) {
            flgTorikesi = new BigDecimal(inDto.getID_Flag_Torikeshizumi());
        }
        outEntity.setFlag_Torikeshizumi(flgTorikesi);
        // ユーザIDの設定
        outEntity.setUserID(cnvBlankToNulll(inDto.getID_UserID()));
        // 扱店名の設定
        outEntity.setName_Organization(cnvBlankToNulll(inDto.getLblID_Name_Organization()));
        // 顧客名の設定
        outEntity.setName_Customer(cnvBlankToNulll(inDto.getLblID_Name_Customer()));
        // 公庫支店の設定
        outEntity.setCode_KoukoShiten(cnvBlankToNulll(inDto.getLblID_Code_KoukoShiten()));
        // 扱店の設定
        outEntity.setCode_Organization(cnvBlankToNulll(inDto.getLblID_Code_Organization()));
        // 店舗の設定
        outEntity.setCode_Tenpo(cnvBlankToNulll(inDto.getLblID_Code_Tenpo()));
        // 年度の設定
        outEntity.setYear(cnvBlankToNulll(cnvBlankToNulll(inDto.getLblID_Year())));
        // 方式資金の設定
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inDto.getLblID_Code_HoshikiShikin()));
        // 番号の設定
        outEntity.setID_Ringi(cnvBlankToNulll(inDto.getLblID_ID_Ringi()));
        // 枝番の設定
        // 画面の枝番が空白の場合、NULL値⇒ReportHistoryEntity.枝番
        // 上記以外の場合、画面の枝番⇒ReportHistoryEntity.枝番
        String idRingiBranch = cnvBlankToNulll(inDto.getLblID_ID_RingiBranch());
        if (null == idRingiBranch) {
            idRingiBranch = Cr006Constants.LITERAL_CHAR_ZERO;
        }
        outEntity.setID_RingiBranch(idRingiBranch);
        // 債権管理番号の設定
        BigDecimal idCredit = null;
        if (null != inDto.getID_ID_Credit()
                && false == PNCommonConstants.LITERAL_BLANK.equals(inDto.getID_ID_Credit())) {
            idCredit = new BigDecimal(inDto.getID_ID_Credit());
        }
        outEntity.setID_Credit(idCredit);
        // 退避受入後立替金残高
        outEntity.setKeep_M_TatekaeZanAfterUkeire(new BigDecimal(inDto.getID_M_KaribaraiZanAfterSeisan()));

        return outEntity;

    }

    /**
     * 日付文字列yyyy年mm月dd日(X)をyyyyMMddの形式に変換する
     *
     * @param strDate 対象日付文字列
     * @return yyyyMMddの形式に変換した日付文字列。例外時は空文字を返す。
     */
    private String cnvDateYYYYMMDD(String strDate) {
        String ret = "";

        try {
            // ・報告年月日：「yyyyMMdd」形式から「yyyy年mm月dd日(X)」形式に変換し設定する。
            // 日付型に変換用
            dtFormat.setLenient(false);
            Date dateYYYYMMDD = dtFormat.parse(strDate);
            DateFormat cnvFormat = new SimpleDateFormat("yyyyMMdd");
            cnvFormat.setLenient(false);
            ret = cnvFormat.format(dateYYYYMMDD);

        } catch (IllegalArgumentException ie) {
            return "";
        } catch (NullPointerException ne) {
            return "";
        } catch (ParseException pe) {
            return "";
        }

        return ret;
    }

    /**
     *
     * <pre>
     * 引数の値が空白の場合、null値を返却し、空白以外の場合は受け取った値をそのまま返却
     * </pre>
     *
     * @param strVal 判定する値
     * @return
     */
    private String cnvBlankToNulll(String strVal) {

        // 引数の値が空白の場合、"NULL"を返却
        String ret = null;
        if (0 < strVal.trim().length()) {
            // 引数の値が空白以外の場合、引数の値を返却
            ret = strVal;
        }

        return ret;
    }

    /**
     * 日付文字列（西暦yyyyMMdd）と時刻文字（hh:mm:ss）からTimestampを返す。
     *
     * @param strDate 日付文字列（西暦yyyyMMdd）
     * @param strTime 時刻文字（hh:mm:ss）
     * @return Timestamp
     */
    private Timestamp cnvTimeStamp(String strDate, String strTime) {

        Timestamp ret = null;
        try {
            String strDateTime = PNCommonComponents.concatString(strDate, " ", strTime);
            ret = new Timestamp(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(strDateTime).getTime());

        } catch (IllegalArgumentException iae) {
            ret = null;
        } catch (NullPointerException npe) {
            ret = null;
        } catch (ParseException pe) {
            ret = null;
        }

        return ret;
    }
}