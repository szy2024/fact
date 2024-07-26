//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.KariukeippanreportDAO;
import jp.go.jfc.partnernet.common.dao.KariukeippanreportEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.md008.common.Md008Constants;
import jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataDAO;
import jp.go.jfc.partnernet.md008.md008_02.dao.Md008_02ResultsDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
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
 * このクラスはMd008_02のサービスクラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
public class Md008_02ServiceImpl extends PNBaseService implements
		Md008_02Service {
	/** Log */
	private static Log log = LogFactory.getLog(Md008_02ServiceImpl.class);

	/** md008_02resultsdatadao */
	@Autowired
	private Md008_02ResultsDataDAO md008_02ResultsDataDao;

	/** reporthistorydao */
	@Autowired
	private ReporthistoryDAO reportHistoryDao;

	/** kariukeippanreportDao */
	@Autowired
	private KariukeippanreportDAO kariukeIppanReportDao;

	/** PNCommonDBComponents */
	@Autowired
	private PNCommonDBComponents pnCommonDBComponents;

	/**
	 * Md008_02ServiceのgetResultsData
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO getResultsData(Md008_02DTO inDto) {

		Md008_02DTO outDto = new Md008_02DTO();
		Md008_02ResultsDataEntity inEntity = new Md008_02ResultsDataEntity();

		// 受渡パラメータを取得する。
		// 一覧画面データの取得
		// DAOに検索条件を設定
		// ・DTO.報告書番号　　⇒　Md008_02ResultsDataEntity.報告書番号
		inEntity.setID_Report(inDto.getID_Report());
		// ・DTO.扱店　　　　　⇒　Md008_02ResultsDataEntity.扱店
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inEntity.setCode_Organization(pnCommonInfo.getCode_Organization());

		List<Md008_02ResultsDataEntity> outEntityList = md008_02ResultsDataDao
				.findByCondition(inEntity);

		// 検索結果のレコード件数を設定
		outDto.setRecordCount(outEntityList.size());

		// 取得した情報　＝　１件　の場合、データをセットする。
		if (PNCommonConstants.RECORD_COUNT_ONE == outEntityList.size()) {

			// Entity⇒DTOに転記
			Md008_02ResultsDataEntity dataEntity = outEntityList.get(0);

			// 　Md008_02ResultsDataEntity.顧客名⇒Md008_02DTO.顧客名
			outDto.setLblID_Name_Customer_Red(dataEntity.getName_Customer());
			// 　Md008_02ResultsDataEntity.扱店名⇒Md008_02DTO.扱店名
			outDto.setLblID_Name_Organization_Red(dataEntity
					.getName_Organization());
			// 　Md008_02ResultsDataEntity.公庫支店⇒Md008_02DTO.公庫支店
			outDto.setLblID_Code_ShokanHonShiten_Red(dataEntity
					.getCode_KoukoShiten());
			// 　Md008_02ResultsDataEntity.扱店⇒Md008_02DTO.扱店
			outDto.setLblID_Code_Organization_Red(dataEntity
					.getCode_Organization());
			// 　Md008_02ResultsDataEntity.店舗⇒Md008_02DTO.店舗
			outDto.setLblID_Code_Tenpo_Red(dataEntity.getCode_Tenpo());
			// 　Md008_02ResultsDataEntity.年度⇒Md008_02DTO.年度
			outDto.setLblID_Year_Red(PNCommonComponents
					.dateFmtAD_YYYY(dataEntity.getYear()));
			// 　Md008_02ResultsDataEntity.方式資金⇒Md008_02DTO.方式資金
			outDto.setLblID_Code_HoshikiShikin_Red(dataEntity
					.getCode_HoshikiShikin());
			// 　Md008_02ResultsDataEntity.番号⇒Md008_02DTO.番号
			outDto.setLblID_ID_Ringi_Red(dataEntity.getID_Ringi());
			// 　Md008_02ResultsDataEnity.枝番⇒Md008_02DTO.枝番
			String eda = dataEntity.getID_RingiBranch();
			outDto.setLblID_ID_RingiBranch_Red(eda
					.equals(Md008Constants.DISPLAY_EDA_CHEACK_ZERO) ? Md008Constants.DISPLAY_EDA_CHEACK_BLANK
					: eda);
			// 　Md008_02ResultsDataEntity.仮受金（一般口）受入額（修正）⇒Md008_02DTO.仮受金（一般口）受入額
			outDto.setLblID_M_KariukeIppanUkeire_Red(dataEntity
					.getM_KariukeIppanUkeire().toString());
			// 　Md008_02ResultsDataEntity.入金日⇒Md008_02DTO.入金日
			String dateNyukin = PNCommonComponents
					.dateFmtAD_YYYYMMDD(dataEntity.getDate_Nyukin());
			outDto.setLblID_Date_Nyukin_Red(dateNyukin);
			// 　Md008_02ResultsDataEntity.報告書番号⇒Md008_02DTO.報告書番号
			outDto.setID_Report(dataEntity.getID_Report());
			// 　Md008_02ResultsDataEntity.ユーザID⇒Md008_02DTO.ユーザID
			// 　Md008_02ResultsDataEntity.データコード⇒Md008_02DTO.データコード
			outDto.setID_DataCode(dataEntity.getDataCode());
			// 　Md008_02ResultsDataEntity.受託者勘定処理年月⇒Md008_02DTO.受託者勘定処理年月
			String dateJtkshori = PNCommonComponents
					.dateFmtAD_YYYYMM(dataEntity.getDate_Jtkshori());
			outDto.setLblID_Date_Jtkshori_Red(dateJtkshori);
			// 　Md008_02ResultsDataEntity.送金日⇒Md008_02DTO.送金日
			String dateSokin = PNCommonComponents.dateFmtAD_YYYYMMDD(dataEntity
					.getDate_Sokin());
			outDto.setLblID_Date_Sokin_Red(dateSokin);
			// 　・Md008_02ResultsDataEntity.送金日番号　　　　　　⇒　DTO.送金日番号
			outDto.setLblID_Code_Sokin_Red(dataEntity.getID_Sokinbi());
			// 　Md008_02ResultsDataEntity.履歴番号⇒Md008_02DTO.履歴番号
			outDto.setID_History(dataEntity.getID_History());
			// 　Md008_02ResultsDataEntity.ステータス⇒Md008_02DTO.ステータス
			outDto.setID_Status(dataEntity.getStatus());
			// 　Md008_02ResultsDataEntity.処理種別⇒Md008_02DTO.処理種別
			outDto.setID_Type_Process(dataEntity.getType_Process());
			// 　Md008_02ResultsDataEntity.取消済フラグ⇒Md008_02DTO.取消済フラグ

			// 　Md008_02ResultsDataEntity.報告書最新更新年月日⇒Md008_02DTO.報告書最新更新年月日
			outDto.setID_Data_LastUpDate(dataEntity.getData_LastUpDate());
			// 　・Md008_02ResultsDataEntity.退避履歴番号　　　　　⇒　DTO.退避履歴番号
			outDto.setID_Keep_ID_History(dataEntity.getKeep_ID_History());

			log.debug("更正(赤)取消の初期表示データ" + dataEntity.toString());
		}
		return outDto;
	}

	/**
	 * Md008_02ServiceのupdateDataNotProcEndDel 処理モード3
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO updateDataNotProcEndDel(Md008_02DTO inDto) {
		log.debug("-----------------------------------3:updateDataNotProcEndDel START -------------------------------------------------------");

		Md008_02DTO outDto = new Md008_02DTO();

		// 共通部品より業務日付を取得　　　　　⇒　業務日付
		String dateReport = pnCommonDBComponents
				.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

		// 共通部品よりシステム時間を取得　　　⇒　報告時分秒
		String timeReport = PNDateUtils
				.clearDateTimeSeparator(PNCommonComponents.getSysDateTime());

		// １．画面表示の対象となった履歴データのレコードを更新
		updateReporthistoryDelIDReport(inDto);

		// ２．仮受金（一般口）受入報告書の該当レコードの削除
		deleteKariukeIppanReport(inDto);

		// ３．画面表示時に取得したレコードに対する取消処理用の履歴新規作成
		// 　　履歴データの追加（更正（赤））
		ReporthistoryEntity inRHEntity_Red = new ReporthistoryEntity();

		// 　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		inRHEntity_Red = getPrimaryKey(inDto.getProcessMode());
		// 　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Red.setDate_Report(dateReport);
		// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Red.setTime_Report(timeReport);
		// 　2　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Red.setStatus(new BigDecimal(
				PNCommonConstants.STATUS_VALUE_2));
		// 　90257110　⇒　ReporthistoryEntity.データコード
		inRHEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257110);
		// 　10　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Red.setType_Process(PNCommonConstants.TYPE_PROCESS_10);
		// 　更正（赤）データのユーザID　⇒　ReporthistoryEntity.ユーザID
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inRHEntity_Red.setUserID(pnCommonInfo.getLogonID());
		// 　更正（赤）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Red.setName_Organization(inDto
				.getLblID_Name_Organization_Red());
		// 　更正（赤）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Red.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten_Red());
		// 　更正（赤）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Red.setCode_Organization(inDto
				.getLblID_Code_Organization_Red());
		// 　更正（赤）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
		// 　更正（赤）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year_Red()));
		// 　更正（赤）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Red.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin_Red());
		// 　更正（赤）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
		// 　更正（赤）データの枝番　⇒　ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
		inRHEntity_Red.setID_RingiBranch((PNCommonComponents
				.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red())));
		// 　1⇒ReporthistoryEntity.取消済フラグ
		inRHEntity_Red.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_1));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Red);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------3:updateDataNotProcEndDel END -------------------------------------------------------");

		return outDto;
	}

	/**
	 * Md008_02ServiceのupdateDataProcEndDel処理モード1
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO updateDataProcEndDel(Md008_02DTO inDto) {
		log.debug("-----------------------------------1:updateDataProcEndDel START -------------------------------------------------------");

		Md008_02DTO outDto = new Md008_02DTO();

		// 共通部品より業務日付を取得　　　　　⇒　業務日付
		String dateReport = pnCommonDBComponents
				.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

		// 共通部品よりシステム時間を取得　　　⇒　報告時分秒
		String timeReport = PNDateUtils
				.clearDateTimeSeparator(PNCommonComponents.getSysDateTime());

		// 業務日付 ＋ 報告時分秒 ＋ 000 　　　⇒　更新日時
		String updateDateTime = dateReport + timeReport + "000";

		// １．更正（赤）画面表示の対象となった履歴データのレコードを更新

		// 1　⇒　ReporthistoryEntity.取消済フラグ
		updateReporthistory(inDto, PNCommonConstants.FLAG_TORIKESHIZUMI_1);

		// ２．仮受金（一般口）受入報告書のレコードを更新
		// 更新日時　⇒　Md008_02DTO.更新日時
		inDto.setUpdateDateTime(updateDateTime);
		updateKariukeippanreport(inDto);

		// ３．画面表示時に取得したレコードに対する取消処理用の履歴、報告書新規作成
		// 　３－１．履歴データの追加（更正（赤））
		ReporthistoryEntity inRHEntity_Red = new ReporthistoryEntity();

		// 　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		inRHEntity_Red = getPrimaryKey(inDto.getProcessMode());

		// 　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Red.setDate_Report(dateReport);
		// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Red.setTime_Report(timeReport);
		// 　1　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Red.setStatus(new BigDecimal(
				PNCommonConstants.STATUS_VALUE_1));
		// 　90257111　⇒　ReporthistoryEntity.データコード
		inRHEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257111);
		// 　10　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Red.setType_Process(PNCommonConstants.TYPE_PROCESS_10);
		// 　更正（赤）データのユーザID　⇒　ReporthistoryEntity.ユーザID
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inRHEntity_Red.setUserID(pnCommonInfo.getLogonID());
		// 　更正（赤）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Red.setName_Organization(inDto
				.getLblID_Name_Organization_Red());
		// 　更正（赤）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Red.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten_Red());
		// 　更正（赤）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Red.setCode_Organization(inDto
				.getLblID_Code_Organization_Red());
		// 　更正（赤）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
		// 　更正（赤）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year_Red()));
		// 　更正（赤）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Red.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin_Red());
		// 　更正（赤）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
		// 　更正（赤）データの枝番　⇒　ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
		inRHEntity_Red.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto
				.getLblID_ID_RingiBranch_Red()));
		// 　更正（赤）データの退避履歴番号　⇒　ReporthistoryEntity.退避履歴番号
		inRHEntity_Red.setKeep_ID_History(inDto.getID_History());
		// 　0⇒ReporthistoryEntity.取消済フラグ
		inRHEntity_Red.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_0));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Red);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}

		// 　　　３－２．仮受金（一般口）受入報告書の追加（更正（赤））
		KariukeippanreportEntity inKIEntity_Red = new KariukeippanreportEntity();
		// 　　登録を行うデータの確認
		// 　　　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、条件を設定する。
		// 　　　　　上記で取得した報告書番号　⇒KariukeIppanReportEntity.報告書番号
		inKIEntity_Red.setID_Report(inRHEntity_Red.getID_Report());

		long hitCount_KI_Red = kariukeIppanReportDao
				.countByCondition(inKIEntity_Red);
		if (PNCommonConstants.RECORD_COUNT_ZERO < hitCount_KI_Red) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		} else {
			// 取得した件数＝０の場合、登録処理を行う。
			// 　仮受金（一般口）受入報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
			// 　業務日付　⇒　ReporthistoryEntity.報告年月日
			inKIEntity_Red.setDate_Report(dateReport);
			// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
			inKIEntity_Red.setTime_Report(timeReport);
			// 　更正（赤）データのユーザID　⇒　KariukeIppanReportEntity.ユーザID
			inKIEntity_Red.setUserID(pnCommonInfo.getLogonID());
			// 　90257111　⇒　KariukeIppanReportEntity.データコード
			inKIEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257111);
			// 　更正（赤）データの顧客名　⇒　KariukeIppanReportEntity.顧客名
			inKIEntity_Red.setName_Customer(inDto.getLblID_Name_Customer_Red());
			// 　更正（赤）データの公庫支店　⇒　KariukeIppanReportEntity.公庫支店
			inKIEntity_Red.setCode_KoukoShiten(inDto
					.getLblID_Code_ShokanHonShiten_Red());
			// 　更正（赤）データの扱店　⇒　KariukeIppanReportEntity.扱店
			inKIEntity_Red.setCode_Organization(inDto
					.getLblID_Code_Organization_Red());
			// 　更正（赤）データの店舗　⇒　KariukeIppanReportEntity.店舗
			inKIEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
			// 　西暦変換した更正（赤）データの年度　⇒　KariukeIppanReportEntity.年度
			inKIEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
					.getLblID_Year_Red()));
			// 　更正（赤）データの方式資金　⇒　KariukeIppanReportEntity.方式資金
			inKIEntity_Red.setCode_HoshikiShikin(inDto
					.getLblID_Code_HoshikiShikin_Red());
			// 　更正（赤）データの番号　⇒　KariukeIppanReportEntity.番号
			inKIEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
			// 　更正（赤）データの枝番　⇒　KariukeIppanReportEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
			inKIEntity_Red.setID_RingiBranch(PNCommonComponents
					.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
			// 　西暦変換した更正（赤）データの受託者勘定処理年月　⇒　KariukeIppanReportEntity.受託者勘定処理年月
			String dateJtkshoriRed = PNCommonComponents.dateFmtJC_Gyymm(
					inDto.getLblID_Date_Jtkshori_Red(), null);
			inKIEntity_Red.setDate_Jtkshori(dateJtkshoriRed);
			// 　西暦変換した更正（赤）データの送金日　⇒　KariukeIppanReportEntity.送金日
			String dateSokinRed = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Sokin_Red(), "");
			inKIEntity_Red.setDate_Sokin(dateSokinRed);
			// 　更正（赤）データの送金日番号　⇒　KariukeIppanReportEntity.送金日番号
			inKIEntity_Red.setID_Sokinbi(inDto.getLblID_Code_Sokin_Red());
			// 　西暦変換した更正（赤）データの入金日　⇒　KariukeIppanReportEntity.入金日
			String dateNyukinRed = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Nyukin_Red(), "");
			inKIEntity_Red.setDate_Nyukin(dateNyukinRed);
			// 　更正（赤）データの仮受金(一般口)受入額　⇒　KariukeIppanReportEntity.仮受金(一般口)受入額
			inKIEntity_Red.setM_KariukeIppanUkeire(PNCommonComponents
					.cnvStrtoBig(inDto.getLblID_M_KariukeIppanUkeire_Red()));
			// 　更正（赤）データの扱店名　⇒　KariukeIppanReportEntity.扱店名
			inKIEntity_Red.setName_Organization(inDto
					.getLblID_Name_Organization_Red());
			// 　更新日時　⇒　KariukeIppanReportEntity.最新更新日時
			inKIEntity_Red.setData_LastUpDate(PNDateUtils
					.formatTimestamp(updateDateTime));

			try {
				// 　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.3登録処理」を参照し、条件を設定する。
				kariukeIppanReportDao.insert(inKIEntity_Red);
			} catch (CFWDuplicateKeyException e) {
				log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
				throw new PNSystemException(e);
			}
		}
		log.debug("-----------------------------------1:updateDataProcEndDel END -------------------------------------------------------");
		return outDto;
	}

	/**
	 * Md008_02ServiceのupdateDataNotProcEndMod 処理モード4
	 * 
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO updateDataNotProcEndMod(Md008_02DTO inDto) {
		log.debug("-----------------------------------4:updateDataNotProcEndMod START -------------------------------------------------------");

		Md008_02DTO outDto = new Md008_02DTO();

		// 共通部品より業務日付を取得　　　　　⇒　業務日付
		String dateReport = pnCommonDBComponents
				.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

		// 共通部品よりシステム時間を取得　　　⇒　報告時分秒
		String timeReport = PNDateUtils
				.clearDateTimeSeparator(PNCommonComponents.getSysDateTime());

		// 業務日付 ＋ 報告時分秒 ＋ 000 　　　⇒　最新更新日時
		String updateDateTime = dateReport + timeReport + "000";

		// １．更正（黒）画面表示の対象となった履歴データのレコードを更新
		ReporthistoryEntity outEntity = updateReporthistoryDelIDReport(inDto);

		// ２．仮受金（一般口）受入報告書の該当レコードの削除
		deleteKariukeIppanReport(inDto);

		// ３．画面表示時に取得したレコードに対する取消処理用の履歴新規作成
		// 　３－１．履歴ﾃﾞｰﾀの追加（更正（黒））
		ReporthistoryEntity inRHEntity_Black = new ReporthistoryEntity();
		// 　　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		// 　　・報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
		inRHEntity_Black = getPrimaryKey(inDto.getProcessMode());

		// 　　　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Black.setDate_Report(dateReport);
		// 　　　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Black.setTime_Report(timeReport);
		// 　　　１．排他読込時に取得したステータス　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Black.setStatus(outEntity.getStatus());
		// 　　　１．排他読込時に取得したデータコード　⇒　ReporthistoryEntity.データコード
		inRHEntity_Black.setDataCode(outEntity.getDataCode());
		// 　　　20　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Black.setType_Process(PNCommonConstants.TYPE_PROCESS_20);
		// 　　　更正（黒）データのユーザID　⇒　ReporthistoryEntity.ユーザID
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inRHEntity_Black.setUserID(pnCommonInfo.getLogonID());
		// 　　　更正（黒）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Black.setName_Organization(inDto
				.getLblID_Name_Organization());
		// 　　　更正（黒）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Black.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten());
		// 　　　更正（黒）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Black.setCode_Organization(inDto
				.getLblID_Code_Organization());
		// 　　　更正（黒）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Black.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
		// 　　　更正（黒）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Black.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year()));
		// 　　　更正（黒）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Black.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin());
		// 　　　更正（黒）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Black.setID_Ringi(inDto.getLblID_ID_Ringi());
		// 　　　更正（黒）データの枝番　⇒　ReporthistoryEntity.枝番(更正（黒）データの枝番が空白の場合、0とする。)
		inRHEntity_Black.setID_RingiBranch(PNCommonComponents
				.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
		// 　　　NULL　⇒　ReporthistoryEntity.退避履歴番号
		inRHEntity_Black.setKeep_ID_History(null);
		// 　　　１．排他読込時に取得した取消済フラグ　⇒　ReporthistoryEntity.取消済フラグ
		inRHEntity_Black.setFlag_Torikeshizumi(outEntity
				.getFlag_Torikeshizumi());

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Black);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}

		// ３－２．仮受金（一般口）受入報告書の作成（更正（黒））
		KariukeippanreportEntity inKIEntity_Black = new KariukeippanreportEntity();
		// 登録を行うデータの確認
		// 　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、条件を設定する。
		// 　上記で取得した報告書番号　⇒KariukeIppanReportEntity.報告書番号
		inKIEntity_Black.setID_Report(inRHEntity_Black.getID_Report());

		long hitCount_KI_Black = kariukeIppanReportDao
				.countByCondition(inKIEntity_Black);
		if (PNCommonConstants.RECORD_COUNT_ZERO < hitCount_KI_Black) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		} else {
			// 　業務日付　⇒　KariukeIppanReportEntity.報告年月日
			inKIEntity_Black.setDate_Report(dateReport);
			// 　報告時分秒　⇒　KariukeIppanReportEntity.報告時分秒
			inKIEntity_Black.setTime_Report(timeReport);
			// 　更正（黒）データのユーザID　⇒　KariukeIppanReportEntity.ユーザID
			inKIEntity_Black.setUserID(pnCommonInfo.getLogonID());
			// 　90257110　⇒　KariukeIppanReportEntity.データコード
			inKIEntity_Black.setDataCode(PNCommonConstants.DATACODE_90257110);
			// 　修正データの顧客名　⇒　KariukeIppanReportEntity.顧客名
			inKIEntity_Black.setName_Customer(inDto.getLblID_Name_Customer());
			// 　修正データの公庫支店　⇒　KariukeIppanReportEntity.公庫支店
			inKIEntity_Black.setCode_KoukoShiten(inDto
					.getLblID_Code_ShokanHonShiten());
			// 　修正データの扱店　⇒　KariukeIppanReportEntity.扱店
			inKIEntity_Black.setCode_Organization(inDto
					.getLblID_Code_Organization());
			// 　修正データの店舗　⇒　KariukeIppanReportEntity.店舗
			inKIEntity_Black.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
			// 　西暦変換した修正データの年度　⇒　KariukeIppanReportEntity.年度
			inKIEntity_Black.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
					.getLblID_Year()));
			// 　修正データの方式資金　⇒　KariukeIppanReportEntity.方式資金
			inKIEntity_Black.setCode_HoshikiShikin(inDto
					.getLblID_Code_HoshikiShikin());
			// 　修正データの番号　⇒　KariukeIppanReportEntity.番号
			inKIEntity_Black.setID_Ringi(inDto.getLblID_ID_Ringi());
			// 　修正データの枝番　⇒　KariukeIppanReportEntity.枝番(修正データの枝番が空白の場合、0とする。)
			inKIEntity_Black.setID_RingiBranch(PNCommonComponents
					.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
			// 　西暦変換した修正データの受託者勘定処理年月　⇒　KariukeIppanReportEntity.受託者勘定処理年月
			String dateJtkshori = PNCommonComponents.dateFmtJC_Gyymm(
					inDto.getLblID_Date_Jtkshori(), null);
			inKIEntity_Black.setDate_Jtkshori(dateJtkshori);
			// 　西暦変換した修正データの送金日　⇒　KariukeIppanReportEntity.送金日
			String dateSokin = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Sokin(), "");
			inKIEntity_Black.setDate_Sokin(dateSokin);
			// 　修正データの送金日番号　⇒　KariukeIppanReportEntity.送金日番号
			inKIEntity_Black.setID_Sokinbi(inDto.getLblID_Code_Sokin());
			// 　西暦変換した修正データの入金日　⇒　KariukeIppanReportEntity.入金日
			String dateNyukin = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Nyukin(), "");
			inKIEntity_Black.setDate_Nyukin(dateNyukin);
			// 　修正データの仮受金(一般口)受入額　⇒　KariukeIppanReportEntity.仮受金(一般口)受入額
			inKIEntity_Black.setM_KariukeIppanUkeire(PNCommonComponents
					.cnvStrtoBig(inDto.getLblID_M_KariukeIppanUkeire()));
			// 　修正データの扱店名　⇒　KariukeIppanReportEntity.扱店名
			inKIEntity_Black.setName_Organization(inDto
					.getLblID_Name_Organization());
			// 　更新日時　⇒　KariukeIppanReportEntity.最新更新日時
			inKIEntity_Black.setData_LastUpDate(PNDateUtils
					.formatTimestamp(updateDateTime));

			try {
				// 　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.3登録処理」を参照し、条件を設定する。
				kariukeIppanReportDao.insert(inKIEntity_Black);
			} catch (CFWDuplicateKeyException e) {
				log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
				throw new PNSystemException(e);
			}
		}
		log.debug("-----------------------------------4:updateDataNotProcEndMod END -------------------------------------------------------");

		return outDto;
	}

	/**
	 * Md008_02ServiceのupdateDataProcEndMod処理モード2
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO updateDataProcEndMod(Md008_02DTO inDto) {
		log.debug("-----------------------------------2:updateDataProcEndMod START -------------------------------------------------------");

		Md008_02DTO outDto = new Md008_02DTO();

		// 共通部品より業務日付を取得　　　　　⇒　業務日付
		String dateReport = pnCommonDBComponents
				.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

		// 共通部品よりシステム時間を取得　　　⇒　報告時分秒
		String timeReport = PNDateUtils
				.clearDateTimeSeparator(PNCommonComponents.getSysDateTime());

		// 業務日付 ＋ 報告時分秒 ＋ 000 　　　⇒　更新日時
		String updateDateTime = dateReport + timeReport + "000";

		// １．更正（赤）画面表示の対象となった履歴データのレコードを更新
		// 1　⇒　ReporthistoryEntity.取消済フラグ
		ReporthistoryEntity rhEntity = updateReporthistory(inDto,
				PNCommonConstants.FLAG_TORIKESHIZUMI_1);

		// ２．仮受金（一般口）受入報告書のレコードを更新（更正赤）
		// 更新日時　⇒　更新日時
		inDto.setUpdateDateTime(updateDateTime);
		updateKariukeippanreport(inDto);

		// ３．履歴データの追加（更正赤）
		ReporthistoryEntity inRHEntity_Red = new ReporthistoryEntity();

		// 　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		// 　・報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
		inRHEntity_Red = getPrimaryKey(inDto.getProcessMode());

		// 　報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
		// 　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Red.setDate_Report(dateReport);
		// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Red.setTime_Report(timeReport);
		// 　1　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Red.setStatus(new BigDecimal(
				PNCommonConstants.STATUS_VALUE_1));
		// 　90257111　⇒　ReporthistoryEntity.データコード
		inRHEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257111);
		// 　10　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Red.setType_Process(PNCommonConstants.TYPE_PROCESS_10);
		// 　更正（赤）データのユーザID　⇒　ReporthistoryEntity.ユーザID
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inRHEntity_Red.setUserID(pnCommonInfo.getLogonID());
		// 　更正（赤）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Red.setName_Organization(inDto
				.getLblID_Name_Organization_Red());
		// 　更正（赤）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Red.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten_Red());
		// 　更正（赤）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Red.setCode_Organization(inDto
				.getLblID_Code_Organization_Red());
		// 　更正（赤）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
		// 　更正（赤）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year_Red()));
		// 　更正（赤）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Red.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin_Red());
		// 　更正（赤）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
		// 　更正（赤）データの枝番　⇒　ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
		inRHEntity_Red.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto
				.getLblID_ID_RingiBranch_Red()));
		// 　更正（赤）データの履歴番号　⇒　ReporthistoryEntity.退避履歴番号
		inRHEntity_Red.setKeep_ID_History(rhEntity.getID_History());
		// 　0　⇒　ReporthistoryEntity.取消済フラグ
		inRHEntity_Red.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_0));
		// 　単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、条件を設定する。

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Red);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}

		// 　４．仮受金（一般口）受入報告書の作成（更正赤）
		KariukeippanreportEntity inKIEntity_Red = new KariukeippanreportEntity();

		// 　　登録を行うデータの確認
		// 　　　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、条件を設定する。
		// 　　　　　上記で取得した報告書番号　⇒KariukeIppanReportEntity.報告書番号
		inKIEntity_Red.setID_Report(inRHEntity_Red.getID_Report());

		// 　　　KariukeIppanReportDAO.countByCondition
		long hitCount_KI_Red = kariukeIppanReportDao
				.countByCondition(inKIEntity_Red);
		if (PNCommonConstants.RECORD_COUNT_ZERO < hitCount_KI_Red) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		} else {
			// 取得した件数＝０の場合、登録処理を行う。
			// 　仮受金（一般口）受入報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
			// 　業務日付　⇒　ReporthistoryEntity.報告年月日
			inKIEntity_Red.setDate_Report(dateReport);
			// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
			inKIEntity_Red.setTime_Report(timeReport);
			// 　更正（赤）データのユーザID　⇒　KariukeIppanReportEntity.ユーザID
			inKIEntity_Red.setUserID(pnCommonInfo.getLogonID());
			// 　90257111　⇒　KariukeIppanReportEntity.データコード
			inKIEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257111);
			// 　更正（赤）データの顧客名　⇒　KariukeIppanReportEntity.顧客名
			inKIEntity_Red.setName_Customer(inDto.getLblID_Name_Customer_Red());
			// 　更正（赤）データの公庫支店　⇒　KariukeIppanReportEntity.公庫支店
			inKIEntity_Red.setCode_KoukoShiten(inDto
					.getLblID_Code_ShokanHonShiten_Red());
			// 　更正（赤）データの扱店　⇒　KariukeIppanReportEntity.扱店
			inKIEntity_Red.setCode_Organization(inDto
					.getLblID_Code_Organization_Red());
			// 　更正（赤）データの店舗　⇒　KariukeIppanReportEntity.店舗
			inKIEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
			// 　西暦変換した更正（赤）データの年度　⇒　KariukeIppanReportEntity.年度
			inKIEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
					.getLblID_Year_Red()));
			// 　更正（赤）データの方式資金　⇒　KariukeIppanReportEntity.方式資金
			inKIEntity_Red.setCode_HoshikiShikin(inDto
					.getLblID_Code_HoshikiShikin_Red());
			// 　更正（赤）データの番号　⇒　KariukeIppanReportEntity.番号
			inKIEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
			// 　更正（赤）データの枝番　⇒　KariukeIppanReportEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
			inKIEntity_Red.setID_RingiBranch(PNCommonComponents
					.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
			// 　西暦変換した更正（赤）データの受託者勘定処理年月　⇒　KariukeIppanReportEntity.受託者勘定処理年月
			String dateJtkshoriRed = PNCommonComponents.dateFmtJC_Gyymm(
					inDto.getLblID_Date_Jtkshori_Red(), null);
			inKIEntity_Red.setDate_Jtkshori(dateJtkshoriRed);
			// 　西暦変換した更正（赤）データの送金日　⇒　KariukeIppanReportEntity.送金日
			String dateSokinRed = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Sokin_Red(), "");
			inKIEntity_Red.setDate_Sokin(dateSokinRed);
			// 　更正（赤）データの送金日番号　⇒　KariukeIppanReportEntity.送金日番号
			inKIEntity_Red.setID_Sokinbi(inDto.getLblID_Code_Sokin_Red());
			// 　西暦変換した更正（赤）データの入金日　⇒　KariukeIppanReportEntity.入金日
			String dateNyukinRed = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Nyukin_Red(), "");
			inKIEntity_Red.setDate_Nyukin(dateNyukinRed);
			// 　更正（赤）データの仮受金(一般口)受入額　⇒　KariukeIppanReportEntity.仮受金(一般口)受入額
			inKIEntity_Red.setM_KariukeIppanUkeire(PNCommonComponents
					.cnvStrtoBig(inDto.getLblID_M_KariukeIppanUkeire_Red()));
			// 　更正（赤）データの扱店名　⇒　KariukeIppanReportEntity.扱店名
			inKIEntity_Red.setName_Organization(inDto
					.getLblID_Name_Organization_Red());
			// 　更新日時　⇒　KariukeIppanReportEntity.最新更新日時
			inKIEntity_Red.setData_LastUpDate(PNDateUtils
					.formatTimestamp(updateDateTime));

			try {
				// 　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.3登録処理」を参照し、条件を設定する。
				kariukeIppanReportDao.insert(inKIEntity_Red);
			} catch (CFWDuplicateKeyException e) {
				log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
				throw new PNSystemException(e);
			}
		}

		// 　５．履歴データの追加（更正（黒））
		ReporthistoryEntity inRHEntity_Black = new ReporthistoryEntity();
		// 　　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		// 　　・報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号を取得する。
		inRHEntity_Black = getPrimaryKey(inDto.getProcessMode());

		// ・繰返しから抜けた後、取得した件数＝０の場合、データの追加処理を行う。
		// 　報告書履歴データの登録用引数を設定する。(但し、更正（黒）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
		// 　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Black.setDate_Report(dateReport);
		// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Black.setTime_Report(timeReport);
		// 　1　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Black.setStatus(new BigDecimal(
				PNCommonConstants.STATUS_VALUE_1));
		// 　90257110　⇒　ReporthistoryEntity.データコード
		inRHEntity_Black.setDataCode(PNCommonConstants.DATACODE_90257110);
		// 　20　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Black.setType_Process(PNCommonConstants.TYPE_PROCESS_20);
		// 　ユーザID　⇒　ReporthistoryEntity.ユーザID
		inRHEntity_Black.setUserID(pnCommonInfo.getLogonID());
		// 　更正（黒）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Black.setName_Organization(inDto
				.getLblID_Name_Organization());
		// 　更正（黒）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Black.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten());
		// 　更正（黒）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Black.setCode_Organization(inDto
				.getLblID_Code_Organization());
		// 　更正（黒）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Black.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
		// 　更正（黒）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Black.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year()));
		// 　更正（黒）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Black.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin());
		// 　更正（黒）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Black.setID_Ringi(inDto.getLblID_ID_Ringi());
		// 　更正（黒）データの枝番　⇒　ReporthistoryEntity.枝番(更正（黒）データの枝番が空白の場合、0とする。)
		inRHEntity_Black.setID_RingiBranch(PNCommonComponents
				.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
		// 　NULL　⇒　ReporthistoryEntity.退避履歴番号
		inRHEntity_Black.setKeep_ID_History(null);
		// 　0　⇒　ReporthistoryEntity.取消済フラグ
		inRHEntity_Black.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_0));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Black);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}

		// 　６．仮受金（一般口）受入報告書の作成（更正（黒））

		KariukeippanreportEntity inKIEntity_Black = new KariukeippanreportEntity();
		// 　　登録を行うデータの確認
		// 　　　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、条件を設定する。
		// 　　　　　上記で取得した報告書番号　⇒KariukeIppanReportEntity.報告書番号
		inKIEntity_Black.setID_Report(inRHEntity_Black.getID_Report());

		// 　　　KariukeIppanReportDAO.countByCondition
		long hitCount_KI_Black = kariukeIppanReportDao
				.countByCondition(inKIEntity_Black);
		if (PNCommonConstants.RECORD_COUNT_ZERO < hitCount_KI_Black) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		} else {
			// 取得した件数＝０の場合、登録処理を行う。
			// 　仮受金（一般口）受入報告書データの更新用引数を設定する。(但し、更正（黒）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
			// 　業務日付　⇒　KariukeIppanReportEntity.報告年月日
			inKIEntity_Black.setDate_Report(dateReport);
			// 　報告時分秒　⇒　KariukeIppanReportEntity.報告時分秒
			inKIEntity_Black.setTime_Report(timeReport);
			// 　更正（黒）データのユーザID　⇒　KariukeIppanReportEntity.ユーザID
			inKIEntity_Black.setUserID(pnCommonInfo.getLogonID());
			// 　90257110　　⇒　KariukeIppanReportEntity.データコード
			inKIEntity_Black.setDataCode(PNCommonConstants.DATACODE_90257110);
			// 　更正（黒）データの顧客名　⇒　KariukeIppanReportEntity.顧客名
			inKIEntity_Black.setName_Customer(inDto.getLblID_Name_Customer());
			// 　更正（黒）データの公庫支店　⇒　KariukeIppanReportEntity.公庫支店
			inKIEntity_Black.setCode_KoukoShiten(inDto
					.getLblID_Code_ShokanHonShiten());
			// 　更正（黒）データの扱店　⇒　KariukeIppanReportEntity.扱店
			inKIEntity_Black.setCode_Organization(inDto
					.getLblID_Code_Organization());
			// 　更正（黒）データの店舗　⇒　KariukeIppanReportEntity.店舗
			inKIEntity_Black.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
			// 　西暦変換した更正（黒）データの年度　⇒　KariukeIppanReportEntity.年度
			inKIEntity_Black.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
					.getLblID_Year()));
			// 　更正（黒）データの方式資金　⇒　KariukeIppanReportEntity.方式資金
			inKIEntity_Black.setCode_HoshikiShikin(inDto
					.getLblID_Code_HoshikiShikin());
			// 　更正（黒）データの番号　⇒　KariukeIppanReportEntity.番号
			inKIEntity_Black.setID_Ringi(inDto.getLblID_ID_Ringi());
			// 　更正（黒）データの枝番　⇒　KariukeIppanReportEntity.枝番(更正（黒）データの枝番が空白の場合、0とする。)
			inKIEntity_Black.setID_RingiBranch(PNCommonComponents
					.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
			// 　西暦変換した更正（黒）データの受託者勘定処理年月　⇒　KariukeIppanReportEntity.受託者勘定処理年月
			String dateJtkshori = PNCommonComponents.dateFmtJC_Gyymm(
					inDto.getLblID_Date_Jtkshori(), null);
			inKIEntity_Black.setDate_Jtkshori(dateJtkshori);
			// 　西暦変換した更正（黒）データの送金日　⇒　KariukeIppanReportEntity.送金日
			String dateSokin = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Sokin(), "");
			inKIEntity_Black.setDate_Sokin(dateSokin);
			// 　更正（黒）データの送金日番号　⇒　KariukeIppanReportEntity.送金日番号
			inKIEntity_Black.setID_Sokinbi(inDto.getLblID_Code_Sokin());
			// 　西暦変換した更正（黒）データの入金日　⇒　KariukeIppanReportEntity.入金日
			String dateNyukin = PNCommonComponents.dateFmtJC_Gyymmdd(
					inDto.getLblID_Date_Nyukin(), "");
			inKIEntity_Black.setDate_Nyukin(dateNyukin);
			// 　更正（黒）データの仮受金(一般口)受入額　⇒　KariukeIppanReportEntity.仮受金(一般口)受入額
			inKIEntity_Black.setM_KariukeIppanUkeire(PNCommonComponents
					.cnvStrtoBig(inDto.getLblID_M_KariukeIppanUkeire()));
			// 　更正（黒）データの扱店名　⇒　KariukeIppanReportEntity.扱店名
			inKIEntity_Black.setName_Organization(inDto
					.getLblID_Name_Organization());
			// 　更新日時　⇒　KariukeIppanReportEntity.最新更新日時
			inKIEntity_Black.setData_LastUpDate(PNDateUtils
					.formatTimestamp(updateDateTime));

			try {
				// 　単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.3登録処理」を参照し、条件を設定する。
				kariukeIppanReportDao.insert(inKIEntity_Black);
			} catch (CFWDuplicateKeyException e) {
				log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
				throw new PNSystemException(e);
			}
		}
		log.debug("-----------------------------------2:updateDataProcEndMod END -------------------------------------------------------");

		return outDto;
	}

	/**
	 * Md008_02ServiceのupdateDataNotProcEndDelCalcel処理モード5
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return Md008_02DTO
	 */
	@Override
	public Md008_02DTO updateDataNotProcEndDelCalcel(Md008_02DTO inDto) {
		log.debug("-----------------------------------5:updateDataNotProcEndDelCalcel START -------------------------------------------------------");

		Md008_02DTO outDto = new Md008_02DTO();

		// 共通部品より業務日付を取得　　　　　⇒　業務日付
		String dateReport = pnCommonDBComponents
				.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

		// 共通部品よりシステム時間を取得　　　⇒　報告時分秒
		String timeReport = PNDateUtils
				.clearDateTimeSeparator(PNCommonComponents.getSysDateTime());

		// １．画面表示の対象となった履歴データのレコードを更新
		updateReporthistoryDelIDReport(inDto);

		// ２．更正（赤）の報告書を削除
		deleteKariukeIppanReport(inDto);

		// ３．更正（赤）データの復活処理
		// 　３－１．履歴データのレコードを更新
		// 0　⇒　ReporthistoryEntity.取消済フラグ
		updateReporthistory(inDto, PNCommonConstants.FLAG_TORIKESHIZUMI_0);

		// 　３－２．履歴ﾃﾞｰﾀの更新（更正（赤））
		ReporthistoryEntity inRHEntity_Red = new ReporthistoryEntity();

		// 　・履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号を取得する。
		inRHEntity_Red = getPrimaryKey(inDto.getProcessMode());

		// 　業務日付　⇒　ReporthistoryEntity.報告年月日
		inRHEntity_Red.setDate_Report(dateReport);
		// 　報告時分秒　⇒　ReporthistoryEntity.報告時分秒
		inRHEntity_Red.setTime_Report(timeReport);
		// 　2　⇒　ReporthistoryEntity.ステータス
		inRHEntity_Red.setStatus(new BigDecimal(
				PNCommonConstants.STATUS_VALUE_2));
		// 　90257111　⇒　ReporthistoryEntity.データコード
		inRHEntity_Red.setDataCode(PNCommonConstants.DATACODE_90257111);
		// 　10　⇒　ReporthistoryEntity.処理種別
		inRHEntity_Red.setType_Process(PNCommonConstants.TYPE_PROCESS_10);
		// 　更正（赤）データのユーザID　⇒　ReporthistoryEntity.ユーザID
		PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
		inRHEntity_Red.setUserID(pnCommonInfo.getLogonID());
		// 　更正（赤）データの扱店名　⇒　ReporthistoryEntity.扱店名
		inRHEntity_Red.setName_Organization(inDto
				.getLblID_Name_Organization_Red());
		// 　更正（赤）データの公庫支店　⇒　ReporthistoryEntity.公庫支店
		inRHEntity_Red.setCode_KoukoShiten(inDto
				.getLblID_Code_ShokanHonShiten_Red());
		// 　更正（赤）データの扱店　⇒　ReporthistoryEntity.扱店
		inRHEntity_Red.setCode_Organization(inDto
				.getLblID_Code_Organization_Red());
		// 　更正（赤）データの店舗　⇒　ReporthistoryEntity.店舗
		inRHEntity_Red.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
		// 　更正（赤）データの年度　⇒　ReporthistoryEntity.年度
		inRHEntity_Red.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto
				.getLblID_Year_Red()));
		// 　更正（赤）データの方式資金　⇒　ReporthistoryEntity.方式資金
		inRHEntity_Red.setCode_HoshikiShikin(inDto
				.getLblID_Code_HoshikiShikin_Red());
		// 　更正（赤）データの番号　⇒　ReporthistoryEntity.番号
		inRHEntity_Red.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
		// 　更正（赤）データの枝番　⇒　ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
		inRHEntity_Red.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto
				.getLblID_ID_RingiBranch_Red()));
		// 　NULL　⇒　ReporthistoryEntity.退避履歴番号
		inRHEntity_Red.setKeep_ID_History(null);
		// 　1　⇒　ReporthistoryEntity.取消済フラグ
		inRHEntity_Red.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_1));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.5登録処理」を参照し、登録を行う。
			reportHistoryDao.insert(inRHEntity_Red);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ挿入時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------5:updateDataNotProcEndDelCalcel END -------------------------------------------------------");

		return outDto;
	}

	/**
	 * 報告書履歴データ更新処理(報告書取消更新)
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @return ReporthistoryEntity
	 */
	private ReporthistoryEntity updateReporthistoryDelIDReport(Md008_02DTO inDto) {
		log.debug("-----------------------------------     updateReporthistoryDelIDReport START");

		ReporthistoryEntity inEntity = new ReporthistoryEntity();
		ReporthistoryEntity outEntity = new ReporthistoryEntity();

		// 履歴番号　⇒　ReporthistoryEntity.履歴番号
		inEntity.setID_History(inDto.getID_History());

		// 単テーブルアクセス定義「報告書履歴データ　No.1件数取得」を参照し、件数を取得する。
		long hitCount = reportHistoryDao.countByCondition(inEntity);

		// ■取得した件数　＝　０　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
			// 　　　　　エラーメッセージ：PM9010E　
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// 　　　　取得した件数＞１の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ONE < hitCount) {
			// 　　　　　エラーメッセージ：PM9990E　
			throw new PNServiceException(PNCommonMessageConstants.PM9990E);
		}

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.4排他読込」を参照し、排他制御を行う。
			outEntity = reportHistoryDao.findByPrimaryKeyForUpdate(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("報告書履歴データ排他読み込み時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWForUpdateException e) {
			// ■排他エラーの場合、業務エラーとする。
			// エラーメッセージ：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// 報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
		// 　NULL　⇒　ReporthistoryEntity.報告書番号
		inEntity.setID_Report(null);
		// 　1　⇒　ReporthistoryEntity.取消済フラグ
		inEntity.setFlag_Torikeshizumi(new BigDecimal(
				PNCommonConstants.FLAG_TORIKESHIZUMI_1));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.2更新処理(報告書番号)」を参照し、条件を設定する。
			reportHistoryDao.update(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("報告書履歴データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWDuplicateKeyException e) {
			log.error("報告書履歴データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------     updateReporthistoryDelIDReport END");
		return outEntity;
	}

	/**
	 * 仮受金（一般口）受入報告書データテーブル削除
	 *
	 * @param inDto
	 *            Md008_02DTO
	 */
	private void deleteKariukeIppanReport(Md008_02DTO inDto) {
		log.debug("-----------------------------------     deleteKariukeIppanReport START");

		KariukeippanreportEntity inEntity = new KariukeippanreportEntity();

		// ・報告書番号　⇒　KariukeIppanReportEntity.報告書番号
		inEntity.setID_Report(inDto.getID_Report());
		// ・報告書最新更新年月日　⇒　KariukeIppanReportEntity.最新更新年月日
		inEntity.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));

		// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、件数を取得する。
		long hitCount = kariukeIppanReportDao.countByCondition(inEntity);

		// ■取得した件数　＝　０　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
			// メッセージPM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// ■取得した件数　＞　１　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ONE < hitCount) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		try {
			// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.4排他読込」を参照し、排他制御を行う。
			kariukeIppanReportDao.findByPrimaryKeyForUpdate(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("仮受金（一般口）受入報告書データ排他読み込み時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWForUpdateException e) {
			// ■排他エラーの場合、業務エラーとする。
			// エラーメッセージ：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		try {
			// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.2削除処理」を参照し、削除を行う。
			kariukeIppanReportDao.delete(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("仮受金（一般口）受入報告書データ削除処理時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------     deleteKariukeIppanReport END");
	}

	/**
	 * 報告書履歴データ更新処理(取消済フラグ更新)
	 *
	 * @param inDto
	 *            Md008_02DTO
	 * @param torikesizumiFlag
	 *            String
	 * @return ReporthistoryEntity
	 */
	private ReporthistoryEntity updateReporthistory(Md008_02DTO inDto,
			String torikesizumiFlag) {
		log.debug("-----------------------------------     updateReporthistory START");

		ReporthistoryEntity inEntity = new ReporthistoryEntity();
		ReporthistoryEntity outEntity = new ReporthistoryEntity();

		if (PNCommonConstants.FLAG_TORIKESHIZUMI_0.equals(torikesizumiFlag)) {
			// ■更正（赤）取消データのレコード更新（復活）処理の場合
			// 退避履歴番号を設定する。
			inEntity.setID_History(inDto.getID_Keep_ID_History());
		} else {
			// ■更正（赤）取消データのレコード更新（復活）処理以外の場合
			// 更正（赤）データの履歴番号　⇒　ReporthistoryEntity.履歴番号
			inEntity.setID_History(inDto.getID_History());

			// 更正（赤）データのステータス　⇒　ReporthistoryEntity.ステータス
			inEntity.setStatus(new BigDecimal(inDto.getID_Status()));

			// 更正（赤）データの処理種別　⇒　ReporthistoryEntity.処理種別
			inEntity.setType_Process(inDto.getID_Type_Process());

			// 更正（赤）データのデータコード　⇒　ReporthistoryEntity.データコード
			inEntity.setDataCode(inDto.getID_DataCode());
		}

		// 単テーブルアクセス定義「報告書履歴データ　No.1件数取得」を参照し、件数を取得する。
		long hitCount = reportHistoryDao.countByCondition(inEntity);

		// ■取得した件数　＝　０　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
			// メッセージPM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// ■取得した件数　＞　１　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ONE < hitCount) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No.4排他読込」を参照し、排他制御を行う。
			outEntity = reportHistoryDao.findByPrimaryKeyForUpdate(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("報告書履歴データ排他読み込み時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWForUpdateException e) {
			// ■排他エラーの場合、業務エラーとする。
			// エラーメッセージ：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// 報告書履歴データを設定する。(但し、項目が空白の場合、Entity項目には”NULL”を設定する。)
		inEntity.setFlag_Torikeshizumi(new BigDecimal(torikesizumiFlag));

		try {
			// 単テーブルアクセス定義「報告書履歴データ　No2更新処理(更新処理(報告書取消更新)」を参照し、更新を行う。
			reportHistoryDao.update(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("報告書履歴データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWDuplicateKeyException e) {
			log.error("報告書履歴データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------     updateReporthistory END");
		return outEntity;
	}

	/**
	 * 仮受金（一般口）受入報告書データテーブル更新
	 *
	 * @param inDto
	 *            Md008_02DTO
	 */
	private void updateKariukeippanreport(Md008_02DTO inDto) {
		log.debug("-----------------------------------     updateKariukeippanreport START");

		KariukeippanreportEntity inEntity = new KariukeippanreportEntity();

		// ・報告書番号　⇒　KariukeIppanReportEntity.報告書番号
		inEntity.setID_Report(inDto.getID_Report());
		// ・報告書最新更新年月日　⇒　KariukeIppanReportEntity.最新更新年月日
		inEntity.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));

		// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.1件数取得」を参照し、件数を取得する。
		long hitCount = kariukeIppanReportDao.countByCondition(inEntity);

		// ■取得した件数　＝　０　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ZERO == hitCount) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// ■取得した件数　＞　１　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ONE < hitCount) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		try {
			// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.4排他読込」を参照し、排他制御を行う。
			kariukeIppanReportDao.findByPrimaryKeyForUpdate(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("仮受金（一般口）受入報告書データ排他読み込み時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWForUpdateException e) {
			// ■排他エラーの場合、業務エラーとする。
			// エラーメッセージ：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9010E);
		}

		// 報告書履歴データを設定する。(但し、項目が空白の場合、Entity項目には”NULL”を設定する。)
		// ・更新日時　⇒　ReporthistoryEntity.最新更新日時
		inEntity.setData_LastUpDate(PNDateUtils.formatTimestamp(inDto
				.getUpdateDateTime()));
		log.debug("最新更新日時[" + inEntity.getData_LastUpDate() + "]");
		try {
			// 単テーブルアクセス定義「仮受金（一般口）受入報告書データ　No.5更新処理」を参照し、更新を行う。
			kariukeIppanReportDao.update(inEntity);
		} catch (CFWFindParameterException e) {
			log.error("仮受金（一般口）受入報告書データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		} catch (CFWDuplicateKeyException e) {
			log.error("仮受金（一般口）受入報告書データ更新処理時にエラー発生", e);
			throw new PNSystemException(e);
		}
		log.debug("-----------------------------------     updateKariukeippanreport END");
	}

	/**
	 * 報告書履歴テーブル主キー取得
	 *
	 * @param processMode
	 *            String
	 * @return entity ReporthistoryEntity
	 */
	private ReporthistoryEntity getPrimaryKey(String processMode) {
		log.debug("-----------------------------------     getPrimaryKey START");
		ReporthistoryEntity outEntity = new ReporthistoryEntity();

		// 共通部品より履歴番号最大値を取得　　⇒　履歴番号最大値
		String nextIDHistory = pnCommonDBComponents.getIdHistoryRh();

		String nextIDReport = null;
		// ■処理モードが 処理完了以外：取消 、更正（赤）取消以外の場合
		if (!PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)
				&& !PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL
						.equals(processMode)) {
			// 共通部品より報告書番号最大値を取得　⇒　報告書番号最大値
			nextIDReport = pnCommonDBComponents.getIdReportRh();
		}

		outEntity.setID_Report(nextIDReport);
		outEntity.setID_History(nextIDHistory);

		// 件数
		long hitCount = PNCommonConstants.RECORD_COUNT_ZERO;

		// 単テーブルアクセス定義「報告書履歴データ　No.1件数取得」を参照し、件数を取得する。
		hitCount = reportHistoryDao.countByCondition(outEntity);

		// ■取得した件数　＞　０　の場合、業務エラーとする。
		if (PNCommonConstants.RECORD_COUNT_ZERO < hitCount) {
			// メッセージID：PM9010E
			throw new PNServiceException(PNCommonMessageConstants.PM9020E);
		}
		log.debug("-----------------------------------     getPrimaryKey END");

		return outEntity;
	}

	/**
	 * 日付文字列（西暦yyyyMMdd）と時刻文字（hh:mm:ss）からTimestampを返す。
	 *
	 * @param strDateTime
	 *            日付文字列（yyyyMMdd HH:mm:ss）
	 * @return Timestamp
	 */
	private Timestamp cnvTimeStamp(String strDateTime) {

		Timestamp ret = null;

		try {
			ret = new Timestamp(new SimpleDateFormat(
					Md008Constants.STR_DATE_LAST_UPDATE_FORMAT).parse(
					strDateTime).getTime());
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