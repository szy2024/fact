//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_02Service
//
// <<Modification History>>
// Version | Date        | Updated By            | Content
// --------+-------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_02.service;

import java.math.BigDecimal;
import java.util.LinkedList;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AringiDAO;
import jp.go.jfc.partnernet.common.dao.AringiEntity;
import jp.go.jfc.partnernet.common.dao.JikkoreportDAO;
import jp.go.jfc.partnernet.common.dao.JikkoreportEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.cr001.common.Cr001Constants;
import jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiDAO;
import jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはCr001_02のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr001_02ServiceImpl extends PNBaseService implements Cr001_02Service {

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** jikkoreportdao */
    @Autowired
    private JikkoreportDAO jikkoreportdao;

    /** cr001_02aringidao */
    @Autowired
    private Cr001_02AringiDAO cr001_02aringidao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr001_02ServiceのsetUpdateInputData
     *
     * @param inDto Cr001_02DTO
     * @return Cr001_02DTO
     */
    @Override
    public Cr001_02DTO setUpdateInputData(Cr001_02DTO inDto) {

        Cr001_02DTO outDto = new Cr001_02DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // DTOのリストにデータが存在しない場合、業務エラーとする。
        if (null == inDto.getMEISAI_LIST() || 0 == inDto.getMEISAI_LIST().size()) {
            // 　エラーメッセージ：DB007
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }
        // 報告年月日を取得
        String strDateRiport = pnCommonDBComponents.getPNBusinessDay(1);
        // 報告時分秒を取得
        String strSysDateTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");

        // 　　　　報告書番号取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
        long idReport = 0L;
        // 「報告書番号保持」に設定する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();
        if (null != strID_Report && 0 < strID_Report.trim().length()) {
            idReport = Long.parseLong(strID_Report);
        }
        // 　　　　履歴番号取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
        long idHistory = 0L;
        // 「履歴番号保持」に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        if (null != strID_History && 0 < strID_History.trim().length()) {
            idHistory = Long.parseLong(strID_History);
        }

        // 繰り返し処理の開始(更新データが無くなるまで繰り返す)
        for (Cr001_02M1DTO inM1Dto : inDto.getMEISAI_LIST()) {
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
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9020E, new String[0]));
                outDto.setBizErrors(bizErrors);
                break;
            }

            // 　　　１－３．報告書履歴データの登録用引数を設定する。
            ReporthistoryEntity outEntity1 = setReportHistory(inM1Dto, strID_History, strID_Report,
                    strDateRiport, strSysDateTime);
            // 　　　　単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、引数を設定する。
            // 　　　　ReporthistoryDAO.insert
            // ReporthistoryEntity inEntity = new ReporthistoryEntity();
            try {
                reporthistorydao.insert(outEntity1);

            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9020E);
            }

            // 　２．貸付実行報告書への追加処理
            // 　　　貸付実行報告書データの存在チェックをする。
            // 　　　　単テーブルアクセス定義「貸付実行報告書　件数取得」を参照し、条件を設定する。
            // 　　　　JikkoreportDAO.countByCondition
            JikkoreportEntity inEntity2 = new JikkoreportEntity();
            inEntity2.setID_Report(strID_Report);
            hitcount = jikkoreportdao.countByCondition(inEntity2);
            if (0 < hitcount) {
                // 　　　　取得した件数＞０の場合、業務エラーとする。
                // 　　　　　エラーメッセージ：BA001、DB010
                // メッセージを追加して継続
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9020E, new String[0]));
                outDto.setBizErrors(bizErrors);
                return outDto;
            }
            // 貸付実行報告書データの登録用引数を設定する。
            JikkoreportEntity outEntity2 = setJikkoReport(inM1Dto, strID_History, strID_Report,
                    strDateRiport, strSysDateTime);
            // 　　　　単テーブルアクセス定義「貸付実行報告書　登録処理」を参照し、引数を設定する。
            // 　　　　JikkoreportrDAO.insert
            // JikkoreportEntity inEntity = new JikkoreportEntity();
            try {
                jikkoreportdao.insert(outEntity2);

            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9020E);
            }
            // 　３．扱店別稟議データの登録済削除フラグの更新
            // 　　　扱店別稟議データの存在チェックをする。
            // 　　　　複数テーブルアクセス定義「Cr001_02AringiDAO」を参照し、条件を設定する。
            // 　　　　Cr001_02AringiDAO.countByCondition
            Cr001_02AringiEntity inEntity3 = new Cr001_02AringiEntity();
            // 債権管理番号　＝　画面の債権管理番号
            inEntity3.setID_Credit(new BigDecimal(inM1Dto.getID_ID_Credit()));
            // 最新更新日時　＝　引数の更新日時
            inEntity3.setData_LastUpDate(inM1Dto.getID_Data_LastUpDate());
            hitcount = cr001_02aringidao.countByCondition(inEntity3);

            // 　　　　取得した件数＝０の場合、業務エラーとする。　
            // 　　　　　エラーメッセージ：PTN001、DB007
            if (0 == hitcount) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　取得した件数＞１(複数存在している場合)の場合、業務エラーとする。
            // 　　　　　エラーメッセージ：BA001、DB004
            if (1 < hitcount) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　扱店別稟議データの排他読込を行う。
            // 　　　　単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
            // 　　　　AringDAO.findByPrimaryKeyForUpdate
            try {
                AringiEntity inEntity4 = new AringiEntity();
                BigDecimal idCredit = new BigDecimal(String.valueOf(inM1Dto.getID_ID_Credit()));
                inEntity4.setID_Credit(idCredit);
                AringiEntity outEntity4 = aringidao.findByPrimaryKeyForUpdate(inEntity4);
                // 　　　扱店別稟議データの更新用引数を設定する。
                // 　　　　貸付実行報告書作成済みフラグの設定
                // 　　　　　画面の貸付実行報告書作成済みフラグが空白の場合、NULL値⇒AringiEntity.貸付実行報告書作成済みフラグ
                // 　　　　　上記以外の場合、画面の貸付実行報告書作成済みフラグ⇒AringiEntity.貸付実行報告書作成済みフラグ
                BigDecimal flgKj = new BigDecimal(String.valueOf(inM1Dto.getID_Flag_Kj()));
                outEntity4.setFlag_Kj(flgKj);
                // 　　　　最新更新日時の設定
                // 　　　　　画面の報告年月日と画面の報告時分秒が空白以外の場合、画面の報告年月日と画面の報告時分秒⇒AringiEntity.最新更新日時
                // 　　　　　上記以外の場合、NULL値⇒AringiEntity.最新更新日時
                if (PNCommonConstants.LITERAL_BLANK.equals(strDateRiport)
                        && PNCommonConstants.LITERAL_BLANK.equals(strSysDateTime)) {
                    outEntity4.setData_LastUpDate(null);
                } else {
                    outEntity4.setData_LastUpDate(PNDateUtils.formatTimestamp(strDateRiport + strSysDateTime
                            + "000"));
                }
                // 　　　　単テーブルアクセス定義「扱店別稟議データ　更新処理」を参照し、引数を設定する。
                // 　　　　AringiDAO.update
                // AringiEntity inEntity = new AringiEntity();
                // 更新の実行
                aringidao.update(outEntity4);
            } catch (CFWForUpdateException fue) {
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
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
     * @param strSysDateTime 報告時分秒
     * @return 報告書履歴データ
     */
    private ReporthistoryEntity setReportHistory(Cr001_02M1DTO inM1Dto, String strID_History,
            String strID_Report, String strDateRiport, String strSysDateTime) {
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
        outEntity.setDate_Report(strDateRiport);
        // 　　　　　報告時分秒の設定
        // 　　　　　　システム時間⇒Cr001_02DTO.報告時分秒
        outEntity.setTime_Report(strSysDateTime);
        // 　　　　　ステータスの設定
        // 　　　　　　画面のステータスが空白の場合、NULL値⇒ReportHistoryEntity.ステータス
        // 　　　　　　上記以外の場合、画面のステータス⇒ReportHistoryEntity.ステータス
        BigDecimal status = null;
        if (null != inM1Dto.getID_Status()) {
            status = new BigDecimal(inM1Dto.getID_Status());
        }
        outEntity.setStatus(status);
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
        if (PNCommonConstants.LITERAL_BLANK.equals(seirekiYear)) {
            seirekiYear = PNCommonComponents.dateFmtJC_Gyy(seirekiYear);
        }
        outEntity.setYear(cnvBlankToNulll(seirekiYear));
        // 　　　　　方式資金の設定
        // 　　　　　　画面の方式資金が空白の場合、NULL値⇒ReportHistoryEntity.方式資金
        // 　　　　　　上記以外の場合、画面の方式資金⇒ReportHistoryEntity.方式資金
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inM1Dto.getID_Code_Hoshiki_Shikin()));
        // 　　　　　番号の設定
        // 　　　　　　画面の番号が空白の場合、NULL値⇒ReportHistoryEntity.番号
        // 　　　　　　上記以外の場合、画面の番号⇒ReportHistoryEntity.番号
        outEntity.setID_Ringi(cnvBlankToNulll(inM1Dto.getID_ID_Ringi()));
        // 　　　　　枝番の設定
        // 　　　　　　画面の枝番が空白の場合、NULL値⇒ReportHistoryEntity.枝番
        // 　　　　　　上記以外の場合、画面の枝番⇒ReportHistoryEntity.枝番
        String idRingiBranch = cnvBlankToNulll(inM1Dto.getID_ID_RingiBranch());
        if (null == idRingiBranch) {
            idRingiBranch = Cr001Constants.CHAR_0;
        }
        outEntity.setID_RingiBranch(idRingiBranch);
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
        outEntity.setKeep_Date_ShokanKigen(cnvBlankToNulll(inM1Dto.getID_Date_ShokanKigen()));

        return outEntity;

    }

    /**
     * 貸付実行報告書データ設定処理
     *
     * @param inM1Dto 画面情報
     * @param strID_History 履歴番号保持
     * @param strID_Report 報告書番号保持
     * @param strDateRiport 報告年月日
     * @param strSysDateTime 報告時分秒
     * @return 貸付実行報告書データ
     */
    private JikkoreportEntity setJikkoReport(Cr001_02M1DTO inM1Dto, String strID_History,
            String strID_Report, String strDateRiport, String strSysDateTime) {
        JikkoreportEntity outEntity = new JikkoreportEntity();
        // 　　　　貸付実行報告書データの登録用引数を設定する。
        // 　　　　　報告書番号の設定
        // 　　　　　　画面の報告書番号が空白の場合、NULL値⇒JikkoreportEntity.報告書番号
        // 　　　　　　上記以外の場合、画面の報告書番号⇒JikkoreportEntity.報告書番号
        outEntity.setID_Report(cnvBlankToNulll(strID_Report));
        // 　　　　　報告年月日の設定
        // 　　　　　　画面の報告年月日が空白の場合、NULL値⇒JikkoreportEntity.報告年月日
        // 　　　　　　上記以外の場合、画面の報告年月日⇒JikkoreportEntity.報告年月日
        outEntity.setDate_Report(strDateRiport);
        // 　　　　　報告時分秒の設定
        // 　　　　　　画面の報告時分秒が空白の場合、NULL値⇒JikkoreportEntity.報告時分秒
        // 　　　　　　上記以外の場合、画面の報告時分秒⇒JikkoreportEntity.報告時分秒
        // 　　　　　報告時分秒の設定
        // 　　　　　　システム時間⇒Cr001_02DTO.報告時分秒
        outEntity.setTime_Report(strSysDateTime);
        // 　　　　　ユーザIDの設定
        // 　　　　　　画面のユーザIDが空白の場合、NULL値⇒JikkoreportEntity.ユーザID
        // 　　　　　　上記以外の場合、画面のユーザID⇒JikkoreportEntity.ユーザID
        outEntity.setUserID(cnvBlankToNulll(inM1Dto.getID_UserID()));
        // 　　　　　伝送番号の設定
        // 　　　　　　画面の伝送番号が空白の場合、NULL値⇒JikkoreportEntity.伝送番号
        // 　　　　　　上記以外の場合、画面の伝送番号⇒JikkoreportEntity.伝送番号
        outEntity.setID_Denso(cnvBlankToNulll(inM1Dto.getID_Denso()));
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
        // 　　　　　受託者勘定処理年月の設定
        // 　　　　　　画面の受託者勘定処理年月が空白の場合、NULL値⇒JikkoreportEntity.受託者勘定処理年月
        // 　　　　　　上記以外の場合、西暦変換した画面の受託者勘定処理年月(年)＋画面の受託者勘定処理年月(月)⇒JikkoreportEntity.受託者勘定処理年月
        outEntity.setDate_Jtkshori(inM1Dto.getID_Date_Jtkshori());
        // 　　　　　年度の設定
        // 　　　　　　画面の年度が空白の場合、NULL値⇒JikkoreportEntity.年度
        // 　　　　　　上記以外の場合、西暦変換した画面の年度⇒JikkoreportEntity.年度
        outEntity.setYear(cnvBlankToNulll(inM1Dto.getID_Year()));
        // 　　　　　方式資金の設定
        // 　　　　　　画面の方式資金が空白の場合、NULL値⇒JikkoreportEntity.方式資金
        // 　　　　　　上記以外の場合、画面の方式資金⇒JikkoreportEntity.方式資金
        outEntity.setCode_HoshikiShikin(cnvBlankToNulll(inM1Dto.getID_Code_Hoshiki_Shikin()));
        // 　　　　　番号の設定
        // 　　　　　　画面の番号が空白の場合、NULL値⇒JikkoreportEntity.番号
        // 　　　　　　上記以外の場合、画面の番号⇒JikkoreportEntity.番号
        outEntity.setID_Ringi(cnvBlankToNulll(inM1Dto.getID_ID_Ringi()));
        // 　　　　　枝番の設定
        // 　　　　　　画面の枝番が空白の場合、NULL値⇒JikkoreportEntity.枝番
        // 　　　　　　上記以外の場合、画面の枝番⇒JikkoreportEntity.枝番
        outEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inM1Dto.getID_ID_RingiBranch()));
        // 　　　　　貸付実行日の設定
        // 　　　　　　画面の貸付実行日（年）、画面の貸付実行日（月）、画面の貸付実行日（日）が空白の場合、NULL値⇒JikkoreportEntity.貸付実行日
        // 　　　　　　上記以外の場合、西暦変換した画面の貸付実行日（年）＋画面の貸付実行日（月）＋画面の貸付実行日（日）⇒JikkoreportEntity.貸付実行日
        outEntity.setDate_Kashitsukejikko(inM1Dto.getID_Date_Kashitsukejikko());
        // 　　　　　貸付実行金額の設定
        // 　　　　　　画面の貸付実行金額が空白の場合、NULL値⇒JikkoreportEntity.貸付実行金額
        // 　　　　　　上記以外の場合、カンマを取り除いた画面の貸付実行金額⇒JikkoreportEntity.貸付実行金額
        outEntity.setM_Kashitsuke(inM1Dto.getID_M_Kashitsuke());
        // 　　　　　資金使途の設定
        // 　　　　　　画面の資金使途が空白の場合、NULL値⇒JikkoreportEntity.資金使途
        // 　　　　　　上記以外の場合、画面の資金使途⇒JikkoreportEntity.資金使途
        outEntity.setCode_ShikinShito(cnvBlankToNulll(inM1Dto.getID_Code_ShikinShito()));
        // 　　　　事業別の設定
        // 　　　　　　画面の事業別が空白の場合、NULL値⇒JikkoreportEntity.事業別
        // 　　　　　　上記以外の場合、画面の事業別⇒JikkoreportEntity.事業別
        outEntity.setCode_Jigyobetsu(cnvBlankToNulll(inM1Dto.getID_Code_Jigyoubetsu()));
        // 　　　　　利率の設定
        // 　　　　　　画面の利率が空白の場合、NULL値⇒JikkoreportEntity.利率
        // 　　　　　　上記以外の場合、１０００倍した画面の利率⇒JikkoreportEntity.利率
        outEntity.setRiritsu(cnvMultiply1000(cnvBlankToNulll(inM1Dto.getID_Riritsu())));
        // 　　　　　特利区分コードの設定
        // 　　　　　　画面の特利区分コードが空白の場合、NULL値⇒JikkoreportEntity.特利区分コード
        // 　　　　　　上記以外の場合、画面の特利区分コード⇒JikkoreportEntity.特利区分コード
        outEntity.setCode_TokuriKubun(cnvBlankToNulll(inM1Dto.getID_Kubun_Tokuri()));
        // 　　　　　特利の設定
        // 　　　　　　画面の特利が空白の場合、NULL値⇒JikkoreportEntity.特利
        // 　　　　　　上記以外の場合、１０００倍した画面の特利⇒JikkoreportEntity.特利
        outEntity.setTokuri(cnvMultiply1000(cnvBlankToNulll(inM1Dto.getID_Tokuri())));
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
        String[] date = PNCommonComponents.cnvNulltoBlank(inM1Dto.getID_Date_GanrikinHaraiKomi())
                .split("\\.");
        if (1 < date.length) {
            date[0] = String.format("%1$02d", Integer.parseInt(date[0]));
            date[1] = String.format("%1$02d", Integer.parseInt(date[1]));
        }
        outEntity
                .setDate_GanrikinHaraikomi(cnvBlankToNulll(PNCommonComponents.concatString(date[0], date[1])));
        // 　　　　　資金交付額の設定
        // 　　　　　　画面の資金交付額が空白の場合、NULL値⇒JikkoreportEntity.資金交付額
        // 　　　　　　上記以外の場合、カンマを取り除いた画面の資金交付額⇒JikkoreportEntity.資金交付額
        outEntity.setM_ShikinKofu(inM1Dto.getID_M_SikinKofu());
        // 　　　　　貸付受入金受入額の設定
        // 　　　　　　画面の貸付受入金受入額が空白の場合、NULL値⇒JikkoreportEntity.貸付受入金受入額
        // 　　　　　　上記以外の場合、カンマを取り除いた画面の貸付受入金受入額⇒JikkoreportEntity.貸付受入金受入額
        outEntity.setM_KashitukeUkeire(inM1Dto.getID_M_KashitsukeUkeire());
        // 　　　　　貸付件数の設定
        // 　　　　　　画面の貸付件数が空白の場合、NULL値⇒JikkoreportEntity.貸付件数
        // 　　　　　　上記以外の場合、画面の貸付件数⇒JikkoreportEntity.貸付件数
        outEntity.setCount_Kashitsuke(PNCommonComponents.cnvNulltoZero(inM1Dto.getID_Count_Kashitsuke()));
        // 　　　　　顧客名の設定
        // 　　　　　　画面の顧客名が空白の場合、NULL値⇒JikkoreportEntity.顧客名
        // 　　　　　　上記以外の場合、画面の顧客名⇒JikkoreportEntity.顧客名
        outEntity.setName_Customer(cnvBlankToNulll(inM1Dto.getID_Name_Customer()));
        // 　　　　　扱店名の設定
        // 　　　　　　画面の扱店名が空白の場合、NULL値⇒JikkoreportEntity.扱店名
        // 　　　　　　上記以外の場合、画面の扱店名⇒JikkoreportEntity.扱店名
        outEntity.setName_Organization(cnvBlankToNulll(inM1Dto.getID_Name_Organization()));

        return outEntity;
    }

    /**
     * 利率、特利などを1000倍して整数部のみ返す
     *
     * @param strValue 利率、特利などの小数部を含む文字列
     * @return 1000倍した整数部
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
            outMultiply = outMultiply.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE).setScale(0,
                    BigDecimal.ROUND_UNNECESSARY);
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
        if (0 < strVal.length()) {
            // 引数の値が空白以外の場合、引数の値を返却
            ret = strVal;
        }

        return ret;
    }

}