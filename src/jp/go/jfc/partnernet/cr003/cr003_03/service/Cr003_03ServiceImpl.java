//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.service;

import java.math.BigDecimal;
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
import jp.go.jfc.partnernet.common.dao.GanjureportDAO;
import jp.go.jfc.partnernet.common.dao.GanjureportEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.cr001.common.Cr001Constants;
import jp.go.jfc.partnernet.cr003.cr003_03.dao.Cr003_03AringiDAO;
import jp.go.jfc.partnernet.cr003.cr003_03.dao.Cr003_03AringiEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはCr003_03のサービスクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr003_03ServiceImpl extends PNBaseService implements Cr003_03Service {

    /** cr003_03aringidao */
    @Autowired
    private Cr003_03AringiDAO cr003_03aringidao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** ganjureportdao */
    @Autowired
    private GanjureportDAO ganjureportdao;

    // 日付フォーマット
    private static final DateFormat dtFormat = new SimpleDateFormat(Cr001Constants.DATE_PATTERN_YYYY_MM_DD_E);

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr003_03ServiceのsetUpdateInputData
     *
     * @param inDto Cr003_03DTO
     * @return Cr003_03DTO
     */
    @Override
    public Cr003_03DTO setUpdateInputData(Cr003_03DTO inDto) {

        Cr003_03DTO outDto = new Cr003_03DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // DTOのリストにデータが存在しない場合、業務エラーとする。
        // 　エラーメッセージ：PTN001、DB007
        if (null == inDto.getMEISAI_AnkenLIST() || 0 == inDto.getMEISAI_AnkenLIST().size()) {
            // 　エラーメッセージ：DB007
            // メッセージを追加
            // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.ID_00_DB003, new String[0]));
            // outDto.setBizErrors(bizErrors);
            // return outDto;
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 報告年月日を取得
        String strDateRiport = pnCommonDBComponents.getPNBusinessDay(1);
        // 報告時刻分を取得
        String strTimeRiport = PNCommonComponents.getSysDateTime().replaceAll(":", "");

        // 　１．報告書履歴への追加処理

        // 　　　　報告書番号取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
        long idReport = 0L;
        // 「報告書番号保持」に設定する。
        // 　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、「報告書番号保持」を取得する。（最大番号＋１の番号を取得）
        String strID_Report = pnCommonDBComponents.getIdReportRh();
        if (null != strID_Report && 0 < strID_Report.trim().length()) {
            idReport = Long.parseLong(strID_Report);
        }
        // 　　　　履歴番号取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
        // 　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、「履歴番号保持」に設定する。（最大番号＋１の番号を取得）
        long idHistory = 0L;
        // 「履歴番号保持」に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        if (null != strID_History && 0 < strID_History.trim().length()) {
            idHistory = Long.parseLong(strID_History);
        }

        // 繰り返し処理の開始(更新データが無くなるまで繰り返す)
        for (Cr003_03M1DTO inM1Dto : inDto.getMEISAI_AnkenLIST()) {
            // 報告書履歴データ　件数取得
            long hitcount = 0L;

            // 　１．報告書履歴への追加処理
            // 　　　　　報告書履歴データの存在チェックをする。
            // 　　　　　　単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.countByCondition
            ReporthistoryEntity inEntity1 = new ReporthistoryEntity();
            inEntity1.setID_History(strID_History);
            hitcount = reporthistorydao.countByCondition(inEntity1);
            // 　　　１－２．取得した件数＞０の場合、業務エラーとする。
            if (0 < hitcount) {
                // 　　　　　エラーメッセージ：PTN001、DB004
                // メッセージを追加
                // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9020E, new String[0]));
                // outDto.setBizErrors(bizErrors);
                // return outDto;
                throw new PNServiceException(PNCommonMessageConstants.PM9020E);
            }

            // 　　　１－３．報告書履歴データの登録用引数を設定する。
            ReporthistoryEntity outEntity1 = setReportHistory(inM1Dto, strID_History, strID_Report,
                    strDateRiport, strTimeRiport);
            try {
                // reporthistorydao.insert(outEntity1);
                reporthistorydao.insert(outEntity1);

            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9020E);
            }

            // 　２．元利金受入充当報告書データへの追加処理
            // 　　　２－１．元利金受入充当報告書データの存在チェック
            // 　　　　　元利金受入充当報告書データの存在チェックをする。
            // 　　　　　　単テーブルアクセス定義「元利金受入充当報告書データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　GanjuReportDAO.countByCondition
            // GanjuReportEntity inEntity = new GanjuReportEntity();
            // long hitcount = ganjureportdao.countByCondition(inEntity);
            GanjureportEntity inEntity2 = new GanjureportEntity();
            inEntity2.setID_Report(strID_Report);
            hitcount = ganjureportdao.countByCondition(inEntity2);
            if (0 < hitcount) {
                // 　　　　　元利金受入充当報告書データの取得件数＞０の場合、業務エラーとし、以降の処理は行わない。
                // 　　　　　エラーメッセージ：PM9010E
                // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                // outDto.setBizErrors(bizErrors);
                // return outDto;
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }

            // 　　　２－２．元利金受入・充当報告書データの登録用引数を設定する。（設定する画面項目が空白の場合、"NULL"を設定する）
            GanjureportEntity outEntity2 = setGanjuReport(inM1Dto, strID_History, strID_Report,
                    strDateRiport, strTimeRiport);
            try {
                ganjureportdao.insert(outEntity2);

            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9020E);

            }

            // 　３．扱店別稟議データの更新
            // 　　　扱店別稟議データの存在チェックをする。
            // 　　　　複数テーブルアクセス定義「Cr003_03AringiDAO」を参照し、条件を設定する。　　　※ 債権管理番号 、 最終更新日時
            // 　　　　Cr003_03AringiDAO.countByCondition

            Cr003_03AringiEntity inEntity3 = new Cr003_03AringiEntity();
            // 債権管理番号　＝　画面の債権管理番号
            inEntity3.setCr003_03ID_Credit(inM1Dto.getID_ID_Credit());
            // 最新更新日時　＝　引数の更新日時
            inEntity3.setCr003_03Data_LastUpDate(inM1Dto.getID_Data_LastUpDate());
            hitcount = cr003_03aringidao.countByCondition(inEntity3);

            // 　　　　取得した件数＝０の場合、業務エラーとする。　
            // 　　　　　エラーメッセージ：PM9010E
            // 　　　　取得した件数＞１の場合、業務エラーとする。
            // 　　　　　エラーメッセージ：PM9010E

            if (0 >= hitcount) {
                // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                // outDto.setBizErrors(bizErrors);
                // return outDto;
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　取得した件数＞１(複数存在している場合)の場合、業務エラーとする。
            // 　　　　　エラーメッセージ：BA001、DB004
            if (1 < hitcount) {
                // メッセージを追加して継続
                // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                // outDto.setBizErrors(bizErrors);
                // return outDto;
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　扱店別稟議データの排他読込を行う。
            // 　　　　単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。　　※ 債権管理番号
            // 　　　　AringDAO.findByPrimaryKeyForUpdate
            try {
                AringiEntity inEntity4 = new AringiEntity();
                BigDecimal idCredit = new BigDecimal(String.valueOf(inM1Dto.getID_ID_Credit()));
                inEntity4.setID_Credit(idCredit);
                AringiEntity outEntity4 = aringidao.findByPrimaryKeyForUpdate(inEntity4);
                // 　　　扱店別稟議データの更新用引数を設定する。
                // 　　　　貸付金残高 = 画面の払込前残元金（円） - 画面の約定元金 (計算対象がNULL/空文字の場合は0として扱う)
                outEntity4.setM_KashitsukeZandaka(PNCommonComponents.cnvStrtoBig(
                        PNCommonComponents.cnvNulltoZero(inM1Dto.getID_M_KashitsukeZandaka())).subtract(
                        PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                                .getID_M_YakujoGankin()))));

                // 　　　　最新更新日時の設定
                // 　　　　　画面の報告年月日と画面の報告時分秒が空白以外の場合、画面の報告年月日と画面の報告時分秒⇒AringiEntity.最新更新日時
                // 　　　　　上記以外の場合、NULL値⇒AringiEntity.最新更新日時
                if (PNCommonConstants.LITERAL_BLANK.equals(inDto.getLblID_Date_Report())
                        && PNCommonConstants.LITERAL_BLANK.equals(cnvBlankToNulll(PNCommonComponents
                                .cnvNulltoBlank(inM1Dto.getID_Time_Report()).replaceAll(":", "")))) {
                    outEntity4.setData_LastUpDate(null);
                } else {
                    outEntity4.setData_LastUpDate(PNDateUtils.formatTimestamp(strDateRiport + strTimeRiport
                            + "000"));
                }
                // 　　　　単テーブルアクセス定義「扱店別稟議データ　更新処理」を参照し、引数を設定する。
                // 　　　　AringiDAO.update
                // AringiEntity inEntity = new AringiEntity();
                // 更新の実行
                aringidao.update(outEntity4);
            } catch (CFWForUpdateException fue) {
                // ロック時のリソースビジー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);

            } catch (CFWFindParameterException fpe) {
                // パラメータエラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);

            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }

            // 　４．請求データの更新処理（画面の約定利息（入力値）＞０　又は　約定元金（入力値）＞０の場合のみ行う。）
            // 　　　請求データの存在チェックをする。
            // 　　　　単テーブルアクセス定義「SeikyuDAO」を参照し、条件を設定する。

            if (0 < PNCommonComponents.cnvStrtoBig(
                    PNCommonComponents.cnvNulltoZero(inM1Dto.getID_M_YakujoRisoku())).doubleValue()
                    || 0 < PNCommonComponents.cnvStrtoBig(
                            PNCommonComponents.cnvNulltoZero(inM1Dto.getID_M_YakujoGankin())).doubleValue()) {

                SeikyuEntity inEntity5 = new SeikyuEntity();
                // 債権管理番号　＝　画面の債権管理番号
                inEntity5.setID_Credit(new BigDecimal(inM1Dto.getID_ID_Credit()));
                // 払込年月日　＝　画面の払込年月日
                // 西暦変換する！
                inEntity5.setDate_Haraikomi(inM1Dto.getID_Date_Haraikomi());

                // 　　　扱店別稟議データの排他読込を行う。
                // 　　　請求データの存在チェックをする。
                // 　　　　単テーブルアクセス定義「SeikyuDAO」を参照し、条件を設定する。
                // 　　　　SeikyuDAO.countByCondition
                hitcount = seikyudao.countByCondition(inEntity5);

                // 　　　　取得した件数＝０の場合、業務エラーとする。　
                // 　　　　　エラーメッセージ：PM9010E
                // 　　　　取得した件数＞１の場合、業務エラーとする。
                // 　　　　　エラーメッセージ：PM9010E
                if (0 == hitcount || 1 < hitcount) {
                    // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
                    // // outDto.setBizErrors(bizErrors);
                    // // return outDto;
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E);
                }

                // 　　　請求データの排他読込を行う。
                // 　　　　単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。

                try {
                    // SeikyuEntity inEntity6 = new SeikyuEntity();
                    //
                    // // 　　　請求データの更新用引数を設定する。
                    // // 債権管理番号　＝　画面の債権管理番号
                    // inEntity6.setID_Credit(new BigDecimal(inM1Dto.getID_ID_Credit()));
                    // // 払込年月日　＝　画面の払込年月日
                    // inEntity6.setDate_Haraikomi(inM1Dto.getID_Date_Haraikomi());

                    SeikyuEntity outEntity5 = seikyudao.findByPrimaryKeyForUpdate(inEntity5);
                    outEntity5 = setSeikyu(outEntity5, inM1Dto, strID_History, strID_Report, strDateRiport);

                    // 　　　請求データの更新用引数を設定する。
                    // 　　　　約定利息の設定
                    // 　　　　　SeikyuEntity.約定利息 = 画面の取得時の約定利息 - 画面の約定利息（入力値）　 (計算対象がNULL/空文字の場合は0として扱う)
                    // 　　　　約定元金の設定
                    // 　　　　　SeikyuEntity.約定元金 = 画面の取得時の約定元金 - 画面の約定元金（入力値）　 (計算対象がNULL/空文字の場合は0として扱う)
                    // 　　　　単テーブルアクセス定義「請求データ　更新処理」を参照し、引数を設定する。
                    // 　　　　SeikyuDAO.update

                    seikyudao.update(outEntity5);

                    // 　　　　排他エラーの場合、業務エラーとする。　
                    // 　　　　　エラーメッセージ：PM9010E
                } catch (CFWForUpdateException fue) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);

                } catch (CFWFindParameterException fpe) {
                    // パラメータエラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E);
                } catch (CFWDuplicateKeyException dke) {
                    // 主キー更新時の一意性制約エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E);
                }
            }

            // 「報告書番号保持」をカウントアップして「報告書番号保持」に設定する。
            idReport++;
            strID_Report = String.valueOf(idReport);
            // 「履歴番号保持」をカウントアップして「履歴番号保持」に設定する。
            idHistory++;
            strID_History = String.valueOf(idHistory);

        }
        // 繰り返し処理の終わり

        // エラー情報をControllerに返却
        outDto.setBizErrors(bizErrors);

        return outDto;
    }

    /**
     * 報告書履歴データ設定処理
     *
     * @param inM1Dto 画面情報
     * @param strID_History 履歴番号保持
     * @param strID_Report 報告書番号保持
     * @param strDateRiport 報告年月日
     * @param strTimeRiport 報告時刻分
     * @return 報告書履歴データ
     */
    private ReporthistoryEntity setReportHistory(Cr003_03M1DTO inM1Dto, String strID_History,
            String strID_Report, String strDateRiport, String strTimeRiport) {
        ReporthistoryEntity outEntity = new ReporthistoryEntity();
        // 　　　　　履歴番号の設定
        if (false == strID_History.equals(inM1Dto.getID_ID_History())) {
            // 　　　　　　画面の履歴番号と「履歴番号保持」が異なる場合
            // 　　　　　　　「履歴番号保持」を画面の履歴番号に設定する。
            inM1Dto.setID_ID_History(strID_History);
        }
        // 　　　　　　画面の履歴番号が空白の場合、NULL値⇒ReportHistoryEntity.履歴番号
        // 　　　　　　上記以外の場合、画面の履歴番号⇒ReportHistoryEntity.履歴番号
        outEntity.setID_History(cnvBlankToNulll(inM1Dto.getID_ID_History()));
        // 　　　　　報告書番号の設定
        // 　　　　　　画面の報告書番号と「報告書番号保持」が異なる場合
        if (false == strID_Report.equals(inM1Dto.getID_ID_Report())) {
            // 　　　　　　　「報告書番号保持」を画面の報告書番号に設定する。
            inM1Dto.setID_ID_Report(strID_Report);
        }
        // 　　　　　　画面の報告書番号が空白の場合、NULL値⇒ReportHistoryEntity.報告書番号
        // 　　　　　　上記以外の場合、画面の報告書番号⇒ReportHistoryEntity.報告書番号
        outEntity.setID_Report(cnvBlankToNulll(inM1Dto.getID_ID_Report()));
        // 　　　　　報告年月日の設定
        // 　　　　　　画面の報告年月日が空白の場合、NULL値⇒ReportHistoryEntity.報告年月日
        // 　　　　　　上記以外の場合、画面の報告年月日⇒ReportHistoryEntity.報告年月日
        outEntity.setDate_Report(cnvBlankToNulll(strDateRiport));
        // 　　　　　報告時分秒の設定
        // 　　　　　　システム時間⇒Cr001_02DTO.報告時分秒
        outEntity.setTime_Report(strTimeRiport);
        // 　　　　　ステータスの設定
        // 　　　　　　画面のステータスが空白の場合、NULL値⇒ReportHistoryEntity.ステータス
        // 　　　　　　上記以外の場合、画面のステータス⇒ReportHistoryEntity.ステータス
        BigDecimal status = null;
        if (null != inM1Dto.getID_Status()) {
            status = new BigDecimal(inM1Dto.getID_Status());
        }
        outEntity.setStatus(status);
        // InitControllerにて原本番号に空白を入れるためNULLが設定される。
        outEntity.setID_Master(cnvBlankToNulll(inM1Dto.getID_ID_Master()));
        // 　　　　　データコードの設定
        // 　　　　　　画面のデータコードが空白の場合、NULL値⇒ReportHistoryEntity.データコード
        // 　　　　　　上記以外の場合、画面のデータコード⇒ReportHistoryEntity.データコード
        outEntity.setDataCode(cnvBlankToNulll(inM1Dto.getID_DataCode()));
        // 　　　　　処理種別の設定
        // 　　　　　　画面の処理種別が空白の場合、NULL値⇒ReportHistoryEntity.処理種別
        // 　　　　　　上記以外の場合、画面の処理種別⇒ReportHistoryEntity.処理種別
        outEntity.setType_Process(cnvBlankToNulll(inM1Dto.getID_Type_Process()));
        // 　　　　　取消済フラグの設定
        // 　　　　　　画面の取消済フラグが空白の場合、NULL値⇒⇒ReportHistoryEntity.取消済フラグ
        // 　　　　　　上記以外の場合、画面の取消済フラグ⇒ReportHistoryEntity.取消済フラグ
        BigDecimal flgTorikesi = null;
        if (null != cnvBlankToNulll(inM1Dto.getID_Flag_Torikeshizumi())) {
            flgTorikesi = new BigDecimal(inM1Dto.getID_Flag_Torikeshizumi());
        }
        outEntity.setFlag_Torikeshizumi(flgTorikesi);
        // 　　　　　ユーザIDの設定
        // 　　　　　　画面のユーザIDが空白の場合、NULL値⇒ReportHistoryEntity.ユーザID
        // 　　　　　　上記以外の場合、画面のユーザID⇒ReportHistoryEntity.ユーザID
        outEntity.setUserID(cnvBlankToNulll(inM1Dto.getID_UserID()));
        // 　　　　　扱店名の設定
        // 　　　　　　画面の扱店名が空白の場合、NULL値⇒ReportHistoryEntity.扱店名
        // 　　　　　　上記以外の場合、画面の扱店名⇒ReportHistoryEntity.扱店名
        outEntity.setName_Organization(cnvBlankToNulll(inM1Dto.getID_Name_Organization()));
        // 　　　　　顧客名の設定
        // 　　　　　　画面の顧客名が空白の場合、NULL値⇒ReportHistoryEntity.顧客名
        // 　　　　　　上記以外の場合、画面の顧客名⇒ReportHistoryEntity.顧客名
        outEntity.setName_Customer(cnvBlankToNulll(inM1Dto.getID_Name_Customer()));
        // 　　　　　公庫支店の設定
        // 　　　　　　画面の公庫支店が空白の場合、NULL値⇒ReportHistoryEntity.公庫支店
        // 　　　　　　上記以外の場合、画面の公庫支店⇒ReportHistoryEntity.公庫支店
        outEntity.setCode_KoukoShiten(cnvBlankToNulll(inM1Dto.getID_Code_ShokanHonShiten()));
        // 　　　　　扱店の設定
        // 　　　　　　画面の扱店が空白の場合、NULL値⇒ReportHistoryEntity.扱店
        // 　　　　　　上記以外の場合、画面の扱店⇒ReportHistoryEntity.扱店
        outEntity.setCode_Organization(cnvBlankToNulll(inM1Dto.getID_Code_Organization()));
        // 　　　　　店舗の設定
        // 　　　　　　画面の店舗が空白の場合、NULL値⇒ReportHistoryEntity.店舗
        // 　　　　　　上記以外の場合、画面の店舗⇒ReportHistoryEntity.店舗
        outEntity.setCode_Tenpo(cnvBlankToNulll(inM1Dto.getID_Code_Tenpo()));
        // 　　　　　年度の設定
        // 　　　　　　画面の年度が空白の場合、NULL値⇒ReportHistoryEntity.年度
        // 　　　　　　上記以外の場合、西暦変換した画面の年度⇒ReportHistoryEntity.年度
        String seirekiYear = cnvBlankToNulll(inM1Dto.getID_Year());
        outEntity.setYear(seirekiYear);
        // 　　　　　方式資金の設定
        // 　　　　　　画面の方式資金が空白の場合、NULL値⇒ReportHistoryEntity.方式資金
        // 　　　　　　上記以外の場合、画面の方式資金⇒ReportHistoryEntity.方式資金
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inM1Dto.getID_Code_HoshikiShikin()));
        // 　　　　　番号の設定
        // 　　　　　　画面の番号が空白の場合、NULL値⇒ReportHistoryEntity.番号
        // 　　　　　　上記以外の場合、画面の番号⇒ReportHistoryEntity.番号
        outEntity.setID_Ringi(cnvBlankToNulll(inM1Dto.getID_ID_Ringi()));
        // 　　　　　枝番の設定
        // 　　　　　　画面の枝番が空白の場合、0値⇒ReportHistoryEntity.枝番
        // 　　　　　　上記以外の場合、画面の枝番⇒ReportHistoryEntity.枝番
        outEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoZero((inM1Dto.getID_ID_RingiBranch())));
        // 　　　　　エラーコードの設定
        // 　　　　　　画面のエラーコードが空白の場合、NULL値⇒ReportHistoryEntity.エラーコード
        // 　　　　　　上記以外の場合、画面のエラーコード⇒ReportHistoryEntity.エラーコード
        outEntity.setCode_Error(cnvBlankToNulll(inM1Dto.getID_Code_Error()));
        // 　　　　　エラーメッセージの設定
        // 　　　　　　画面のエラーメッセージが空白の場合、NULL値⇒ReportHistoryEntity.エラーメッセージ
        // 　　　　　　上記以外の場合、画面のエラーメッセージ⇒ReportHistoryEntity.エラーメッセージ
        outEntity.setErrorMessage(cnvBlankToNulll(inM1Dto.getID_ErrorMessage()));
        // 　　　　　債権管理番号の設定
        // 　　　　　　画面の債権管理番号が空白の場合、NULL値⇒ReportHistoryEntity.債権管理番号
        // 　　　　　　上記以外の場合、画面の債権管理番号⇒ReportHistoryEntity.債権管理番号
        BigDecimal idCredit = null;
        if (null != inM1Dto.getID_ID_Credit()) {
            idCredit = new BigDecimal(inM1Dto.getID_ID_Credit());
        }
        outEntity.setID_Credit(idCredit);
        // 　　　　　退避償還期限年月の設定
        // 　　　　　　画面の退避償還期限年月が空白の場合、NULL値⇒ReportHistoryEntity.退避償還期限年月
        // 　　　　　　上記以外の場合、画面の退避償還期限年月⇒ReportHistoryEntity.退避償還期限年月
        outEntity.setKeep_Date_ShokanKigen(cnvBlankToNulll(inM1Dto.getID_Keep_Date_ShokanKigen()));

        // 　　　　　退避貸付金残高の設定
        // 　　　　　　　　画面の退避貸付金残高⇒ReportHistoryEntity.'退避貸付金残高
        outEntity.setKeep_M_KashitsukeZan(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Keep_M_KashitsukeZan())));

        // 　　　　　退避約定元金の設定
        // 　　　　　　　　画面の退避約定元金⇒ReportHistoryEntity.退避約定元金
        outEntity.setKeep_M_YakujoGankin(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Keep_M_YakujoGankin())));

        // 　　　　　退避約定利息の設定
        // 　　　　　　　　画面の退避約定利息⇒ReportHistoryEntity.退避約定利息
        outEntity.setKeep_M_YakujoRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Keep_M_YakujoRisoku())));

        // 　　　　　元利金受入充当報告書の払込期日の設定
        // 　　　　　　　　画面の払込期日⇒ReportHistoryEntity.元利金受入充当報告書の払込期日
        outEntity.setKeep_Date_Haraikomi(cnvBlankToNulll(inM1Dto.getID_Date_Haraikomi()));

        // 　　　　　元利金受入充当報告書の控除利息の設定
        // 　　　　　　　　画面の控除利息（入力値）⇒ReportHistoryEntity.元利金受入充当報告書の控除利息
        outEntity.setKeep_M_KojoRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_KojoRisoku())));

        // 　　　　　請求データの任意繰償還利息の設定
        // 　　　　　　　　画面の請求データの任意繰償還利息⇒ReportHistoryEntity.請求データの任意繰償還利息
        outEntity.setKeep_Seikyu_M_NinKuriRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Seikyu_M_NinKuriRisoku())));

        // 　　　　　請求データの請求繰償還利息の設定
        // 　　　　　　　　画面の請求データの請求繰償還利息⇒ReportHistoryEntity.請求データの請求繰償還利息
        outEntity.setKeep_Seikyu_M_SeiKuriRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Seikyu_M_SeiKuriRisoku())));

        // 　　　　　請求データの請求繰償還元金の設定
        // 　　　　　　　　画面の請求データの請求繰償還元金⇒ReportHistoryEntity.請求データの請求繰償還元金
        outEntity.setKeep_Seikyu_M_SeiKuriGankin(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Seikyu_M_SeiKuriGankin())));

        outEntity.setKeep_Yakujo_M_SeiKuriRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_Yakujo_M_SeiKuriRisoku())));

        return outEntity;

    }

    /**
     * 貸付実行報告書データ設定処理
     *
     * @param inM1Dto 画面情報
     * @param strID_History 履歴番号保持
     * @param strID_Report 報告書番号保持
     * @param strDateRiport 報告年月日
     * @param strTimeRiport 報告時刻分
     * @return 貸付実行報告書データ
     */
    private GanjureportEntity setGanjuReport(Cr003_03M1DTO inM1Dto, String strID_History,
            String strID_Report, String strDateRiport, String strTimeRiport) {
        GanjureportEntity outEntity = new GanjureportEntity();

        // 　　　　　報告書番号の設定
        // 　　　　　　画面の報告書番号が空白の場合、NULL値⇒JikkoreportEntity.報告書番号
        // 　　　　　　上記以外の場合、画面の報告書番号⇒JikkoreportEntity.報告書番号
        outEntity.setID_Report(cnvBlankToNulll(strID_Report));
        // 　　　　　報告年月日の設定
        // 　　　　　　画面の報告年月日が空白の場合、NULL値⇒JikkoreportEntity.報告年月日
        // 　　　　　　上記以外の場合、画面の報告年月日⇒JikkoreportEntity.報告年月日
        outEntity.setDate_Report(cnvBlankToNulll(strDateRiport));
        // 　　　　　報告時分秒の設定
        // 　　　　　　画面の報告時分秒が空白の場合、NULL値⇒JikkoreportEntity.報告時分秒
        // 　　　　　　上記以外の場合、画面の報告時分秒⇒JikkoreportEntity.報告時分秒
        // 　　　　　報告時分秒の設定
        // 　　　　　　システム時間⇒Cr001_02DTO.報告時分秒
        outEntity.setTime_Report(strTimeRiport);
        // 　　　　　ユーザIDの設定
        // 　　　　　　画面のユーザIDが空白の場合、NULL値⇒JikkoreportEntity.ユーザID
        // 　　　　　　上記以外の場合、画面のユーザID⇒JikkoreportEntity.ユーザID
        outEntity.setUserID(cnvBlankToNulll(inM1Dto.getID_UserID()));
        // 　　　　　伝送番号の設定
        // 　　　　　　画面の伝送番号が空白の場合、NULL値⇒JikkoreportEntity.伝送番号
        // 　　　　　　上記以外の場合、画面の伝送番号⇒JikkoreportEntity.伝送番号
        outEntity.setID_Denso(cnvBlankToNulll(inM1Dto.getID_ID_Denso()));
        // 　　　　　データコードの設定
        // 　　　　　　画面のデータコードが空白の場合、NULL値⇒JikkoreportEntity.データコード
        // 　　　　　　上記以外の場合、画面のデータコード⇒JikkoreportEntity.データコード
        outEntity.setDataCode(cnvBlankToNulll(inM1Dto.getID_DataCode()));
        // 　　　　　公庫支店の設定
        // 　　　　　　画面の公庫支店が空白の場合、NULL値⇒JikkoreportEntity.公庫支店
        // 　　　　　　上記以外の場合、画面の公庫支店⇒JikkoreportEntity.公庫支店
        outEntity.setCode_KoukoShiten(cnvBlankToNulll(inM1Dto.getID_Code_ShokanHonShiten()));
        // 　　　　　扱店の設定
        // 　　　　　　画面の扱店が空白の場合、NULL値⇒JikkoreportEntity.扱店
        // 　　　　　　上記以外の場合、画面の扱店⇒JikkoreportEntity.扱店
        outEntity.setCode_Organization(cnvBlankToNulll(inM1Dto.getID_Code_Organization()));
        // 　　　　　店舗の設定
        // 　　　　　　画面の店舗が空白の場合、NULL値⇒JikkoreportEntity.店舗
        // 　　　　　　上記以外の場合、画面の店舗⇒JikkoreportEntity.店舗
        outEntity.setCode_Tenpo(cnvBlankToNulll(inM1Dto.getID_Code_Tenpo()));
        // 　　　　　年度の設定
        // 　　　　　　画面の年度が空白の場合、NULL値⇒JikkoreportEntity.年度
        // 　　　　　　上記以外の場合、西暦変換した画面の年度⇒JikkoreportEntity.年度
        outEntity.setYear(cnvBlankToNulll(inM1Dto.getID_Year()));
        // 　　　　　方式資金の設定
        // 　　　　　　画面の方式資金が空白の場合、NULL値⇒JikkoreportEntity.方式資金
        // 　　　　　　上記以外の場合、画面の方式資金⇒JikkoreportEntity.方式資金
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inM1Dto.getID_Code_HoshikiShikin()));
        // 　　　　　番号の設定
        // 　　　　　　画面の番号が空白の場合、NULL値⇒JikkoreportEntity.番号
        // 　　　　　　上記以外の場合、画面の番号⇒JikkoreportEntity.番号
        outEntity.setID_Ringi(cnvBlankToNulll(inM1Dto.getID_ID_Ringi()));
        // 　　　　　枝番の設定
        // 　　　　　　画面の枝番が空白の場合、0値⇒JikkoreportEntity.枝番
        // 　　　　　　上記以外の場合、画面の枝番⇒JikkoreportEntity.枝番
        if (0 != PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_ID_RingiBranch()).length()) {
            outEntity.setID_RingiBranch(inM1Dto.getID_ID_RingiBranch());
        } else {
            outEntity.setID_RingiBranch("0");
        }
        // 　　　　　貸付実行日の設定
        // 　　　　　　画面の貸付実行日（年）、画面の貸付実行日（月）、画面の貸付実行日（日）が空白の場合、NULL値⇒JikkoreportEntity.貸付実行日
        // 　　　　　　上記以外の場合、西暦変換した画面の貸付実行日（年）＋画面の貸付実行日（月）＋画面の貸付実行日（日）⇒JikkoreportEntity.貸付実行日
        outEntity.setDate_Kashitsukejikko(inM1Dto.getID_Date_Jikko());
        // 　　　　　貸付実行金額の設定
        // 　　　　　　画面の貸付実行金額が空白の場合、NULL値⇒JikkoreportEntity.貸付実行金額
        // 　　　　　　上記以外の場合、カンマを取り除いた画面の貸付実行金額⇒JikkoreportEntity.貸付実行金額
        outEntity.setM_Kashitsuke(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_Kashitsuke())));
        // 　　　　　資金使途の設定
        // 　　　　　　画面の資金使途が空白の場合、NULL値⇒JikkoreportEntity.資金使途
        // 　　　　　　上記以外の場合、画面の資金使途⇒JikkoreportEntity.資金使途
        outEntity.setCode_ShikinShito(cnvBlankToNulll(inM1Dto.getID_Code_ShikinShito()));
        // 　　　　事業別の設定
        // 　　　　　　画面の事業別が空白の場合、NULL値⇒JikkoreportEntity.事業別
        // 　　　　　　上記以外の場合、画面の事業別⇒JikkoreportEntity.事業別
        outEntity.setCode_Jigyobetsu(cnvBlankToNulll(inM1Dto.getID_Code_Jigyobetsu()));
        // 　　　　　利率の設定
        // 　　　　　　画面の利率が空白の場合、NULL値⇒JikkoreportEntity.利率
        // 　　　　　　上記以外の場合、１０００倍した画面の利率⇒JikkoreportEntity.利率
        outEntity.setRiritsu(new BigDecimal(cnvMultiply1000(cnvBlankToNulll(inM1Dto.getID_Riritsu()))));
        // 　　　　　特利区分コードの設定
        // 　　　　　　画面の特利区分コードが空白の場合、NULL値⇒JikkoreportEntity.特利区分コード
        // 　　　　　　上記以外の場合、画面の特利区分コード⇒JikkoreportEntity.特利区分コード
        outEntity.setCode_TokuriKubun(cnvBlankToNulll(inM1Dto.getID_Kubun_Tokuri()));
        // 　　　　　特利の設定
        // 　　　　　　画面の特利が空白の場合、NULL値⇒JikkoreportEntity.特利
        // 　　　　　　上記以外の場合、１０００倍した画面の特利⇒JikkoreportEntity.特利
        outEntity.setTokuri(new BigDecimal(cnvMultiply1000(cnvBlankToNulll(inM1Dto.getID_Tokuri()))));
        // 　　　　　償還方法の設定
        // 　　　　　　　　画面の償還方法⇒GanjuReportEntity.償還方法
        outEntity.setCode_Shokan(cnvBlankToNulll(inM1Dto.getID_Code_ShokanHouhou()));
        // 　　　　　据置期限（年月）の設定
        // 　　　　　　画面の据置期限（年月）が空白の場合、NULL値⇒JikkoreportEntity.据置期限（年月）
        // 　　　　　　上記以外の場合、西暦変換した画面の据置期限（年月）⇒JikkoreportEntity.据置期限（年月）
        outEntity.setDate_SueokiKigen(cnvBlankToNulll(inM1Dto.getID_Date_SueokiKigen()));
        // 　　　　　償還期限（年月）の設定
        // 　　　　　　画面の償還期限（年月）が空白の場合、NULL値⇒JikkoreportEntity.償還期限（年月）
        // 　　　　　　上記以外の場合、西暦変換した画面の償還期限（年月）⇒JikkoreportEntity.償還期限（年月）
        outEntity.setDate_ShokanKigen(cnvBlankToNulll(inM1Dto.getID_Date_ShokanKigen()));
        // 　　　　　元利金払込日の設定
        // 　　　　　　画面の元利金払込日が空白の場合、NULL値⇒JikkoreportEntity.元利金払込日
        // 　　　　　　上記以外の場合、画面の元利金払込日⇒JikkoreportEntity.元利金払込日

        if (0 == PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_Date_GanrikinHaraiKomi()).length()) {
            outEntity.setDate_GanrikinHaraikomi(null);
        } else {
            String[] date = PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_Date_GanrikinHaraiKomi()).trim()
                    .split("\\.");
            if (1 < date.length) {
                date[0] = String.format("%1$02d", Integer.parseInt(date[0]));
                date[1] = String.format("%1$02d", Integer.parseInt(date[1]));
            }
            outEntity.setDate_GanrikinHaraikomi(cnvBlankToNulll(PNCommonComponents.concatString(date[0],
                    date[1])));
        }

        // 　　　　　元利又は元金均等額の設定
        // 　　　　　　　　画面の元利又は元金均等額⇒GanjuReportEntity.元利又は元金均等額
        outEntity.setM_GankinKinto(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_Fukin())));
        // 　　　　　払込前残元金の設定
        // 　　　　　　　　画面の払込前残元金⇒GanjuReportEntity.払込前残元金
        outEntity.setM_kashitsukeZandaka(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_KashitsukeZandaka())));
        // 　　　　　払込期日の設定
        // 　　　　　　　　画面の払込期日を西暦に変換⇒GanjuReportEntity.払込期日
        outEntity.setDate_Haraikomi(cnvBlankToNulll(inM1Dto.getID_Date_Haraikomi()));
        // 　　　　　払込金額の設定
        // 　　　　　　　　画面の払込金額⇒GanjuReportEntity.払込金額
        outEntity.setM_Haraikomi(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_Haraikomi())));
        // 　　　　　控除利息の設定
        // 　　　　　　　　画面の控除利息⇒GanjuReportEntity.控除利息
        outEntity.setM_KojoRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_KojoRisoku())));
        // 　　　　　入金日の設定
        // 　　　　　　　　画面の入金日を西暦に変換⇒GanjuReportEntity.入金日
        outEntity.setDate_Nyukin(cnvBlankToNulll(PNCommonComponents.dateFmtJC_Gyymmdd(
                inM1Dto.getID_Date_Nyukin(), "")));
        // 　　　　　約定利息の設定
        // 　　　　　　　　画面の約定利息⇒GanjuReportEntity.約定利息
        outEntity.setM_YakujoRisoku(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_YakujoRisoku())));
        // 　　　　　約定元金の設定
        // 　　　　　　　　画面の約定元金⇒GanjuReportEntity.約定元金
        outEntity.setM_YakujoGankin(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_YakujoGankin())));
        // 　　　　　遅延損害金の設定
        // 　　　　　　　　画面の遅延損害金⇒GanjuReportEntity.遅延損害金
        outEntity.setM_ChienSongai(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_ChienSongai())));
        // 　　　　　違約金の設定
        // 　　　　　　　　画面の違約金⇒GanjuReportEntity.違約金
        outEntity.setM_Iyaku(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_M_Iyaku())));
        // 　　　　　違約金（利子軽減分）の設定
        // 　　　　　　　　画面の違約金（利子軽減分）⇒GanjuReportEntity.違約金（利子軽減分）
        outEntity.setM_IyakuRishikeigen(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_IyakuRishikeigen())));
        // 　　　　　仮受金からの充当額の設定
        // 　　　　　　　　画面の仮受金からの充当額⇒GanjuReportEntity.仮受金からの充当額
        outEntity.setM_KariukeIppanJuto(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_KariukeIppanJuto())));
        // 　　　　　差引払込額の設定
        // 　　　　　　　　画面の差引払込額⇒GanjuReportEntity.差引払込額
        outEntity.setM_SashihikiHaraikomi(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_SashihikiHaraikomi())));
        // 　　　　　払込後残元金の設定
        // 　　　　　　　　画面の払込後残元金⇒GanjuReportEntity.払込後残元金
        outEntity.setM_ZangankinAfterHaraikomi(PNCommonComponents.cnvStrtoBig(PNCommonComponents
                .cnvNulltoZero(inM1Dto.getID_M_ZangankinAfterHaraikomi())));
        // 　　　　　受託者勘定処理年月の設定
        // 　　　　　　画面の受託者勘定処理年月が空白の場合、NULL値⇒JikkoreportEntity.受託者勘定処理年月
        // 　　　　　　上記以外の場合、西暦変換した画面の受託者勘定処理年月(年)＋画面の受託者勘定処理年月(月)⇒JikkoreportEntity.受託者勘定処理年月
        if (0 == PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_Date_Jtkshori()).length()) {
            outEntity.setDate_Jtkshori(null);
        } else {
            outEntity.setDate_Jtkshori(cnvBlankToNulll(PNCommonComponents.dateFmtJC_Gyymm(
                    inM1Dto.getID_Date_Jtkshori(), "")));
        }
        // 　　　　　送金日の設定
        // 　　　　　　　　画面の送金日を西暦に変換⇒GanjuReportEntity.送金日
        if (0 == PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_Date_Sokin()).length()) {
            outEntity.setDate_Sokin(null);
        } else {
            outEntity.setDate_Sokin(cnvBlankToNulll(PNCommonComponents.dateFmtJC_Gyymmdd(
                    inM1Dto.getID_Date_Sokin(), "")));
        }
        // 　　　　　送金日番号の設定
        // 　　　　　　　　画面の送金日番号⇒GanjuReportEntity.送金日番号
        outEntity.setID_Sokinbi(cnvBlankToNulll(inM1Dto.getID_ID_Sokinbi()));

        // 　　　　　残高件数の設定
        // 　　　　　　　　画面の残高件数⇒GanjuReportEntity.残高件数
        outEntity.setCount_Zandaka(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                .getID_Count_Zandaka())));

        // 　　　　　顧客名の設定
        // 　　　　　　画面の顧客名が空白の場合、NULL値⇒JikkoreportEntity.顧客名
        // 　　　　　　上記以外の場合、画面の顧客名⇒JikkoreportEntity.顧客名
        outEntity.setName_Customer(cnvBlankToNulll(inM1Dto.getID_Name_Customer()));

        // 　　　　　扱店名の設定
        // 　　　　　　画面の扱店名が空白の場合、NULL値⇒JikkoreportEntity.扱店名
        // 　　　　　　上記以外の場合、画面の扱店名⇒JikkoreportEntity.扱店名
        outEntity.setName_Organization(cnvBlankToNulll(inM1Dto.getID_Name_Organization()));

        // 　　　　　元利金計の設定
        // 　　　　　　　　GanjuReportEntity.元利金計＝画面の遅延損害金＋画面の約定利息＋画面の約定元金 (計算対象がNULL/空文字の場合は0として扱う)
        BigDecimal ganrikinGoukei = PNCommonComponents
                .cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto.getID_M_ChienSongai()))
                .add(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                        .getID_M_YakujoRisoku())))
                .add(PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                        .getID_M_YakujoGankin())));
        outEntity.setM_GanrikinKei(ganrikinGoukei);

        return outEntity;
    }

    /**
     * 報告書履歴データ設定処理
     *
     * @param inM1Dto 画面情報
     * @param strID_History 履歴番号保持
     * @param strID_Report 報告書番号保持
     * @param strDateRiport 報告年月日
     * @return 報告書履歴データ
     */
    private SeikyuEntity setSeikyu(SeikyuEntity outEntity5, Cr003_03M1DTO inM1Dto, String strID_History,
            String strID_Report, String strDateRiport) {

        SeikyuEntity outEntity = outEntity5;

        // 　　　請求データの更新用引数を設定する。
        // 　　　　約定利息の設定
        // 　　　　　SeikyuEntity.約定利息 = 画面の取得時の約定利息 - 画面の約定利息（入力値）　 (計算対象がNULL/空文字の場合は0として扱う)
        BigDecimal yakujiyoRisoku = PNCommonComponents.cnvStrtoBig(
                PNCommonComponents.cnvNulltoZero(inM1Dto.getID_Keep_M_YakujoRisoku())).subtract(
                PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                        .getID_M_YakujoRisoku())));
        outEntity.setM_YakujoRisoku(yakujiyoRisoku);

        // 　　　　約定元金の設定
        // 　　　　　SeikyuEntity.約定元金 = 画面の取得時の約定元金 - 画面の約定元金（入力値）　 (計算対象がNULL/空文字の場合は0として扱う)
        // 　　　　単テーブルアクセス定義「請求データ　更新処理」を参照し、引数を設定する。
        BigDecimal yakujiyoGankin = PNCommonComponents.cnvStrtoBig(
                PNCommonComponents.cnvNulltoZero(inM1Dto.getID_Keep_M_YakujoGankin())).subtract(
                PNCommonComponents.cnvStrtoBig(PNCommonComponents.cnvNulltoZero(inM1Dto
                        .getID_M_YakujoGankin())));
        outEntity.setM_YakujoGankin(yakujiyoGankin);

        return outEntity;

    }

    /**
     * 和暦の日付部分文字列を連結して西暦８桁で返す。
     *
     * @param strDatePart 元号、年、月、日
     * @return strDatePartを最初の要素から順に連結した文字列を返す
     */

    private String cnvMultiply1000(String strValue) {
        // 戻り値初期値設定
        String ret = null;
        BigDecimal outMultiply = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        try {
            // 引数がnullの場合
            if (null == strValue) {
                // nullを返す。
                return ret;
            } else {
                // 引数がnull以外の場合
                // 引数をBigDecimalに変換
                outMultiply = new BigDecimal(strValue);
            }

            // 引数に1000を掛ける
            outMultiply = outMultiply.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE);
            if (null == outMultiply) {
                outMultiply = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
            }

        } catch (IllegalArgumentException ie) {
            // 例外発生時はnullを戻す。
            outMultiply = null;

        } catch (ArithmeticException ae) {
            // 例外発生時はnullを戻す。
            outMultiply = null;
        }
        // 戻り値返却
        ret = outMultiply.toString();

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

}