//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 小菱忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
// 4.0.0   | 2021/03/18 | 番場　千沙都          | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_01.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.calculation.PNKeisanKurishoRisoku;
import jp.go.jfc.partnernet.common.dao.KurishojiyuDAO;
import jp.go.jfc.partnernet.common.dao.KurishojiyuEntity;
import jp.go.jfc.partnernet.common.dao.NyukinhistoryDAO;
import jp.go.jfc.partnernet.common.dao.NyukinhistoryEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.common.dao.SelectharaidashimaxviewDAO;
import jp.go.jfc.partnernet.common.dao.SelectharaidashimaxviewEntity;
import jp.go.jfc.partnernet.common.dao.YakujoDAO;
import jp.go.jfc.partnernet.common.dao.YakujoEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01HaraidashiDataEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinHisSumDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinHisSumEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01NyukinhistoryCountEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData2DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData2Entity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData3DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData3Entity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData4DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01PreviousYakujoData4Entity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01ResultsDataDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01ResultsDataEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuCount2DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuCount2Entity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuCountDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuCountEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuDataDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01SeikyuDataEntity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01YakujoCount2DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01YakujoCount2Entity;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01YakujoCount3DAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01YakujoCountDAO;
import jp.go.jfc.partnernet.md004.md004_01.dao.Md004_01YakujoCountEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

/**
 * <pre>
 * このクラスはmd004_01のサービスクラスです。
 * </pre>
 *
 * @author 番場　千沙都
 * @version 4.0.0
 */
public class Md004_01ServiceImpl extends PNBaseService implements
		Md004_01Service {

	/** md004_01resultsdatadao */
	@Autowired
	private Md004_01ResultsDataDAO md004_01resultsdatadao;

	/** md004_01seikyucountdao */
	@Autowired
	private Md004_01SeikyuCountDAO md004_01seikyucountdao;

	/** yakujodao */
	@Autowired
	private YakujoDAO yakujodao;

	/** seikyudao */
	@Autowired
	private SeikyuDAO seikyudao;

	/** md004_01seikyucount2dao */
	@Autowired
	private Md004_01SeikyuCount2DAO md004_01seikyucount2dao;

	/** selectharaidashimaxviewdao */
	@Autowired
	private SelectharaidashimaxviewDAO selectharaidashimaxviewdao;

	/** md004_01yakujocountdao */
	@Autowired
	private Md004_01YakujoCountDAO md004_01yakujocountdao;

	/** md004_01yakujocount2dao */
	@Autowired
	private Md004_01YakujoCount2DAO md004_01yakujocount2dao;

	/** md004_01yakujocount3dao */
	@Autowired
	private Md004_01YakujoCount3DAO md004_01yakujocount3dao;

	/** md004_01previousyakujodata2dao */
	@Autowired
	private Md004_01PreviousYakujoData2DAO md004_01previousyakujodata2dao;

	/** md004_01previousyakujodata3dao */
	@Autowired
	private Md004_01PreviousYakujoData3DAO md004_01previousyakujodata3dao;

	/** md004_01previousyakujodata4dao */
	@Autowired
	private Md004_01PreviousYakujoData4DAO md004_01previousyakujodata4dao;

	/** nyukinhistorydao */
	@Autowired
	private NyukinhistoryDAO nyukinhistorydao;

	/** md004_01nyukinhistorycountdao */
	@Autowired
	private Md004_01NyukinhistoryCountDAO md004_01nyukinhistorycountdao;

	/** md004_01seikyudatadao */
	@Autowired
	private Md004_01SeikyuDataDAO md004_01seikyudatadao;

	/** md004_01nyukinhissumdao */
	@Autowired
	private Md004_01NyukinHisSumDAO md004_01nyukinhissumdao;

	/** md004_01haraidashidatadao */
	@Autowired
	private Md004_01HaraidashiDataDAO md004_01haraidashidatadao;

	/** pnCommonDBComponents */
	@Autowired
	PNCommonDBComponents pnCommonDBComponents;

	/** koukoshitendao */
	@Autowired
	private KurishojiyuDAO kurishojiyudao;

	/**
	 * Md004_01ServiceのgetResultsData
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO getResultsData(Md004_01DTO inDto) {

		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		bizErrors.clear();

		// DTO定義
		Md004_01DTO outDto = new Md004_01DTO();

		Md004_01ResultsDataEntity inEntity = new Md004_01ResultsDataEntity();

		// 報告書番号＝指定された報告書番号
		inEntity.setID_ID_Report(inDto.getID_ID_Report_H());

		KurishojiyuEntity inKurishojiyuEntity = new KurishojiyuEntity();
		// 繰償事由コードリストの作成
		LinkedHashMap<String, String> lhmKurishojiyuEntityList = new LinkedHashMap<String, String>();
		lhmKurishojiyuEntityList.put("", "");
		// 繰償事由テーブルDao呼び出し
		List<KurishojiyuEntity> outKurishojiyuEntityList = kurishojiyudao
				.findByCondition(inKurishojiyuEntity);
		for (KurishojiyuEntity outKurishojiyuEntity : outKurishojiyuEntityList) {
			// 繰償事由コードの設定
			lhmKurishojiyuEntityList.put(
					outKurishojiyuEntity.getCode_KurishoJiyu(),
					outKurishojiyuEntity.getCode_KurishoJiyu());
		}

		// 複数テーブルアクセス定義の「Md004_01ResultsDataDAO」を参照し、条件を設定する。
		List<Md004_01ResultsDataEntity> outEntityList = md004_01resultsdatadao
				.findByCondition(inEntity);

		// 取得したデータが２件以上の場合、業務エラーとする。
		// エラーメッセージ：PM9010E
		if (2 <= outEntityList.size()) {
			addError(outDto, PNCommonMessageConstants.PM9010E, new String[0]);
			return outDto;
		}

		// 取得したデータの件数＝０の場合、業務エラーとする。
		// エラーメッセージ：PM9060E
		if (0 == outEntityList.size()) {
			addError(outDto, PNCommonMessageConstants.PM9060E, new String[0]);
			return outDto;
		}

		outDto.setID_ID_Report(outEntityList.get(0).getID_ID_Report());

		// 繰償事由コードプルダウン引継
		outDto.setCODE_KURISHOJIYU_PULL_LIST(lhmKurishojiyuEntityList);

		// Md004_01ResultsDataEntity.顧客名⇒Md004_01DTO.顧客名
		outDto.setTxtID_Name_Customer(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Name_Customer()));
		// Md004_01ResultsDataEntity.扱店名⇒Md004_01DTO.扱店名(修正)
		outDto.setTxtID_Name_Organization(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Name_Organization()));
		// Md004_01ResultsDataEntity.公庫支店⇒Md004_01DTO.公庫支店(修正)
		outDto.setTxtID_Code_KoukoShiten(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_KoukoShiten()));
		// Md004_01ResultsDataEntity.扱店⇒Md004_01DTO.扱店(修正)
		outDto.setTxtID_Code_Organization(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Organization()));
		// Md004_01ResultsDataEntity.店舗⇒Md004_01DTO.店舗(修正)
		outDto.setTxtID_Code_Tenpo(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Tenpo()));
		// Md004_01ResultsDataEntity.年度⇒Md004_01DTO.年度(修正)
		outDto.setTxtID_Year(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_Year()));
		// Md004_01ResultsDataEntity.方式資金⇒Md004_01DTO.方式資金(修正)
		outDto.setTxtID_Code_HoshikiShikin(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_HoshikiShikin()));
		// Md004_01ResultsDataEntity.番号⇒Md004_01DTO.番号(修正)
		outDto.setTxtID_ID_Ringi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
		// Md004_01ResultsDataEntity.枝番⇒Md004_01DTO.枝番(修正)値が0の場合、空白を設定
		outDto.setTxtID_ID_RingiBranch(cnvZeroToBlank(outEntityList.get(0)
				.getID_ID_RingiBranch()));
		// 以下入力連結値は画面によって決定されるため初期表示では入れない。
		// //
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日（入力値連結）
		// outDto.setDate_FirstHaraikomiAfterKuris_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getDate_FirstHaraikomiAfterKuris()));
		// 繰償還後第１回払込期日を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日(元号)(修正)
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日(年)(修正)
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日(月)(修正)
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日(日)(修正)
		List<String> firstHaraikomiAfterKuris = parseSeireki(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getDate_FirstHaraikomiAfterKuris()));
		outDto.setDrpDate_FirstHaraikomiAfterKuris_Gengo(firstHaraikomiAfterKuris
				.get(0));
		outDto.setTxtDate_FirstHaraikomiAfterKuris_Nen(firstHaraikomiAfterKuris
				.get(1));
		outDto.setDrpDate_FirstHaraikomiAfterKuris_Tsuki(firstHaraikomiAfterKuris
				.get(2));
		outDto.setDrpDate_FirstHaraikomiAfterKuris_Bi(firstHaraikomiAfterKuris
				.get(3));
		// 以下入力連結値は画面によって決定されるため初期表示では入れない。
		// // Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日（入力値連結）
		// outDto.setID_Date_Nyukin_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Nyukin()));
		// 入金日を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日(元号)(修正)
		// Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日(年)(修正)
		// Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日(月)(修正)
		// Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日(日)(修正)
		List<String> date_Nyukin = parseSeireki(outEntityList.get(0)
				.getID_Date_Nyukin());
		outDto.setDrpID_Date_Nyukin_Gengo(date_Nyukin.get(0));
		outDto.setTxtID_Date_Nyukin_Nen(date_Nyukin.get(1));
		outDto.setDrpID_Date_Nyukin_Tsuki(date_Nyukin.get(2));
		outDto.setDrpID_Date_Nyukin_Bi(date_Nyukin.get(3));
		// Md004_01ResultsDataEntity.繰上償還事由コード⇒Md004_01DTO.繰上償還事由コード(修正)
		outDto.setDrpID_Code_Kurishojiyu(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_KurishoJiyu()));
		// Md004_01ResultsDataEntity.利息⇒Md004_01DTO.利息(円)(修正)
		outDto.setTxtID_M_KurishoRisoku(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoRisoku()));
		// Md004_01ResultsDataEntity.元金⇒Md004_01DTO.元金(円)(修正)
		outDto.setTxtID_M_KurishoGankin(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoGankin()));
		// Md004_01ResultsDataEntity.仮受金からの充当額⇒Md004_01DTO.仮受金からの充当額(円)(修正)
		if ("0".equals(PNCommonComponents.cnvNulltoZero(
				outEntityList.get(0).getID_M_KariukeIppanJuto()).toString())) {
			outDto.setTxtID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
		} else {
			outDto.setTxtID_M_KariukeIppanJuto(PNCommonComponents
					.cnvNulltoZero(
							outEntityList.get(0).getID_M_KariukeIppanJuto())
					.toString());
		}
		// Md004_01ResultsDataEntity.控除利息⇒Md004_01DTO.控除利息(円)(修正)
		outDto.setTxtID_M_KojoRisoku(cnvBigToStr(outEntityList.get(0)
				.getID_M_KojoRisoku()));
		// Md004_01ResultsDataEntity.送金額⇒Md004_01DTO.送金額(円)(修正)
		if ("0".equals(PNCommonComponents.cnvNulltoZero(
				outEntityList.get(0).getID_M_Sokin()).toString())) {
			outDto.setTxtID_M_Sokin(PNCommonConstants.LITERAL_BLANK);
		} else {
			outDto.setTxtID_M_Sokin(PNCommonComponents.cnvNulltoZero(
					outEntityList.get(0).getID_M_Sokin()).toString());
		}
		// Md004_01ResultsDataEntity.繰償後残元金⇒Md004_01DTO.繰償後残元金(円)(修正)
		outDto.setTxtID_M_ZanGankinAfterKurisho(cnvBigToStr(outEntityList
				.get(0).getID_M_ZanAfterKurisho()));
		// Md004_01ResultsDataEntity.繰上償還手数料⇒Md004_01DTO.繰上償還手数料(円)(修正)
		outDto.setTxtID_M_KurishoCommission(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoCommission()));

		// 以下入力連結値は画面によって決定されるため初期表示では入れない。
		// // Md004_01ResultsDataEntity.払込期日①⇒Md004_01DTO.払込期日①（入力値連結）
		// outDto.setID_Date_Haraikomi1_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Haraikomi1()));
		// // Md004_01ResultsDataEntity.払込期日②⇒Md004_01DTO.払込期日②（入力値連結）
		// outDto.setID_Date_Haraikomi2_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Haraikomi2()));
		// // Md004_01ResultsDataEntity.払込期日③⇒Md004_01DTO.払込期日③（入力値連結）
		// outDto.setID_Date_Haraikomi3_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Haraikomi3()));
		// // Md004_01ResultsDataEntity.払込期日④⇒Md004_01DTO.払込期日④（入力値連結）
		// outDto.setID_Date_Haraikomi4_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Haraikomi4()));

		// 払込期日①を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.払込期日１⇒Md004_01DTO.払込期日①(元号)(修正)
		// Md004_01ResultsDataEntity.払込期日１⇒Md004_01DTO.払込期日①(年)(修正)
		// Md004_01ResultsDataEntity.払込期日１⇒Md004_01DTO.払込期日①(月)(修正)
		// Md004_01ResultsDataEntity.払込期日１⇒Md004_01DTO.払込期日①(日)(修正)
		// Md004_01ResultsDataEntity.払込元金１⇒Md004_01DTO.払込元金①(修正)
		List<String> date_Haraikomi1 = parseSeireki(outEntityList.get(0)
				.getID_Date_Haraikomi1());
		outDto.setDrpID_Date_Haraikomi1_Gengo(date_Haraikomi1.get(0));
		outDto.setTxtID_Date_Haraikomi1_Nen(date_Haraikomi1.get(1));
		outDto.setDrpID_Date_Haraikomi1_Tsuki(date_Haraikomi1.get(2));
		outDto.setDrpID_Date_Haraikomi1_Bi(date_Haraikomi1.get(3));
		// 払込期日②を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.払込期日２⇒Md004_01DTO.払込期日②(元号)(修正)
		// Md004_01ResultsDataEntity.払込期日２⇒Md004_01DTO.払込期日②(年)(修正)
		// Md004_01ResultsDataEntity.払込期日２⇒Md004_01DTO.払込期日②(月)(修正)
		// Md004_01ResultsDataEntity.払込期日２⇒Md004_01DTO.払込期日②(日)(修正)
		// Md004_01ResultsDataEntity.払込元金２⇒Md004_01DTO.払込元金② (修正)
		List<String> date_Haraikomi2 = parseSeireki(outEntityList.get(0)
				.getID_Date_Haraikomi2());
		outDto.setDrpID_Date_Haraikomi2_Gengo(date_Haraikomi2.get(0));
		outDto.setTxtID_Date_Haraikomi2_Nen(date_Haraikomi2.get(1));
		outDto.setDrpID_Date_Haraikomi2_Tsuki(date_Haraikomi2.get(2));
		outDto.setDrpID_Date_Haraikomi2_Bi(date_Haraikomi2.get(3));
		// 払込期日③を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.払込期日３⇒Md004_01DTO.払込期日③ (元号)(修正)
		// Md004_01ResultsDataEntity.払込期日３⇒Md004_01DTO.払込期日③ (年)(修正)
		// Md004_01ResultsDataEntity.払込期日３⇒Md004_01DTO.払込期日③ (月)(修正)
		// Md004_01ResultsDataEntity.払込期日３⇒Md004_01DTO.払込期日③ (日)(修正)
		// Md004_01ResultsDataEntity.払込元金３⇒Md004_01DTO.払込元金③ (修正)
		List<String> date_Haraikomi3 = parseSeireki(outEntityList.get(0)
				.getID_Date_Haraikomi3());
		outDto.setDrpID_Date_Haraikomi3_Gengo(date_Haraikomi3.get(0));
		outDto.setTxtID_Date_Haraikomi3_Nen(date_Haraikomi3.get(1));
		outDto.setDrpID_Date_Haraikomi3_Tsuki(date_Haraikomi3.get(2));
		outDto.setDrpID_Date_Haraikomi3_Bi(date_Haraikomi3.get(3));
		// 払込期日④を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.払込期日４⇒Md004_01DTO.払込期日④(元号)(修正)
		// Md004_01ResultsDataEntity.払込期日４⇒Md004_01DTO.払込期日④(年)(修正)
		// Md004_01ResultsDataEntity.払込期日４⇒Md004_01DTO.払込期日④(月)(修正)
		// Md004_01ResultsDataEntity.払込期日４⇒Md004_01DTO.払込期日④(日)(修正)
		List<String> date_Haraikomi4 = parseSeireki(outEntityList.get(0)
				.getID_Date_Haraikomi4());
		outDto.setDrpID_Date_Haraikomi4_Gengo(date_Haraikomi4.get(0));
		outDto.setTxtID_Date_Haraikomi4_Nen(date_Haraikomi4.get(1));
		outDto.setDrpID_Date_Haraikomi4_Tsuki(date_Haraikomi4.get(2));
		outDto.setDrpID_Date_Haraikomi4_Bi(date_Haraikomi4.get(3));
		// Md004_01ResultsDataEntity.払込元金１⇒Md004_01DTO.払込元金①(修正)
		outDto.setTxtID_M_HaraikomiGankin1(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin1())));
		// Md004_01ResultsDataEntity.払込元金２⇒Md004_01DTO.払込元金②(修正)
		outDto.setTxtID_M_HaraikomiGankin2(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin2())));
		// Md004_01ResultsDataEntity.払込元金３⇒Md004_01DTO.払込元金③(修正)
		outDto.setTxtID_M_HaraikomiGankin3(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin3())));
		// Md004_01ResultsDataEntity.払込元金４⇒Md004_01DTO.払込元金④(修正)
		outDto.setTxtID_M_HaraikomiGankin4(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin4())));
		// Md004_01ResultsDataEntity.繰償後元金均等額⇒Md004_01DTO.繰償後元金均等額(円)(修正)
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents
				.cnvNulltoZero(outEntityList.get(0)
						.getID_M_GankinKintoAfterKurisho()))) {
			outDto.setTxtID_M_GankinKintoAfterKurisho((cnvBigToStr(outEntityList
					.get(0).getID_M_GankinKintoAfterKurisho())));
		} else {
			outDto.setTxtID_M_GankinKintoAfterKurisho("");
		}
		// Md004_01ResultsDataEntity.繰償後元金不均等額⇒Md004_01DTO.繰償後元金不均等額(円)(修正)
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents
				.cnvNulltoZero(outEntityList.get(0)
						.getID_M_GankinKintoAfterKurisho()))) {
			outDto.setTxtID_M_GankinFukintoAfterKurisho((cnvBigToStr(outEntityList
					.get(0).getID_M_GankinFukintoAfterKurisho())));
		} else {
			outDto.setTxtID_M_GankinFukintoAfterKurisho("");
		}
		// Md004_01ResultsDataEntity.調整コード⇒Md004_01DTO.調整コード(修正)
		outDto.setRdoID_Code_chosei(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Chosei()));
		// Md004_01ResultsDataEntity.受託者勘定処理年月⇒Md004_01DTO.受託者勘定処理年月(修正)
		outDto.setTxtID_Date_Jtkshori(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Jtkshori()));
		// 以下入力連結値は画面によって決定されるため初期表示では入れない。
		// // Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日（入力値連結）
		// outDto.setID_Date_Sokin_Input(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
		// .getID_Date_Sokin()));
		// 送金日を和暦変換し元号、年、月、日に分割して設定
		// Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日(元号)(修正)
		// Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日(年)(修正)
		// Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日(月)(修正)
		// Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日(日)(修正)
		List<String> date_Sokin = parseSeireki(outEntityList.get(0)
				.getID_Date_Sokin());
		outDto.setDrpID_Date_Sokin_Gengo(date_Sokin.get(0));
		outDto.setTxtID_Date_Sokin_Nen(date_Sokin.get(1));
		outDto.setDrpID_Date_Sokin_Tsuki(date_Sokin.get(2));
		outDto.setDrpID_Date_Sokin_Bi(date_Sokin.get(3));
		// Md004_01ResultsDataEntity.送金日番号⇒Md004_01DTO.送金日番号(修正)
		outDto.setTxtID_ID_Sokinbi(outEntityList.get(0).getID_ID_Sokinbi());
		// 初期元号⇒Md004_01DTO.受託者勘定処理年月(修正)(年)
		// 空文字⇒Md004_01DTO.受託者勘定処理年月(修正)(月)
		// 空文字⇒Md004_01DTO.受託者勘定処理年月(修正)(日)
// [UPD] Ver 2.0.0 - START
//		outDto.setDrpID_Date_Jtkshori_Gengo("H");
		outDto.setDrpID_Date_Jtkshori_Gengo(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
		outDto.setTxtID_Date_Jtkshori_Nen("");
		outDto.setDrpID_Date_Jtkshori_Tsuki("");
		// （非表示項目）
		// Md004_01ResultsDataEntity.履歴番号⇒Md004_01DTO.履歴番号(修正)
		outDto.setID_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_ID_History()));
		// Md004_01ResultsDataEntity.処理種別⇒Md004_01DTO.処理種別(修正)
		outDto.setID_Type_Process(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Type_Process()));
		// Md004_01ResultsDataEntity.取消済フラグ⇒Md004_01DTO.取消済フラグ(修正)
		outDto.setID_Flag_Torikeshizumi(cnvIntegerToStr(outEntityList.get(0)
				.getID_Flag_Torikeshizumi()));
		// Md004_01ResultsDataEntity.エラーコード⇒Md004_01DTO.エラーコード(修正)
		outDto.setID_Code_Error(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_Code_Error()));
		// Md004_01ResultsDataEntity.エラーメッセージ⇒Md004_01DTO.エラーメッセージ(修正)
		outDto.setID_ErrorMessage(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ErrorMessage()));
		// Md004_01ResultsDataEntity.債権管理番号⇒Md004_01DTO.債権管理番号(修正)
		outDto.setID_ID_Credit(cnvBigToStr(outEntityList.get(0)
				.getID_ID_Credit(), ""));
		// Md004_01ResultsDataEntity.退避賦金⇒Md004_01DTO.退避賦金(修正)
		outDto.setID_Keep_M_Fukin(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_Fukin(), ""));
		// Md004_01ResultsDataEntity.退避元金不均等額⇒Md004_01DTO.退避元金不均等額(修正)
		outDto.setID_Keep_M_GankinFukinto(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_GankinFukinto(), ""));
		// Md004_01ResultsDataEntity.退避元金不均等区分⇒Md004_01DTO.退避元金不均等区分(修正)
		outDto.setID_Keep_Kubun_GankinFukinto(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Kubun_GankinFukinto()));

		// 処理種別(受渡)が処理完了以外：修正の場合
		// 取得した繰償事由コードが空白以外の場合、貸付残高を再計算する。
		if (4 == Integer.parseInt(inDto.getID_Type_Process_H())
				&& 0 != getStrLength(outEntityList.get(0)
						.getID_Code_KurishoJiyu())) {
			// Md004_01DTO.退避貸付残高(修正)＝Md004_01ResultsDataEntity.元金＋Md004_01ResultsDataEntity.繰償後残元金
			outDto.setID_Keep_M_KashitsukeZan(PNCommonComponents
					.cnvNulltoZero(outEntityList.get(0).getID_M_KurishoGankin())
					.add(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
							.getID_M_ZanAfterKurisho())).toString());
		} else {
			// 上記以外の場合
			// Md004_01ResultsDataEntity.退避貸付残高⇒Md004_01DTO.退避貸付残高(修正)
			outDto.setID_Keep_M_KashitsukeZan(cnvBigToStr(outEntityList.get(0)
					.getID_Keep_M_KashitsukeZan(), ""));
		}

		// Md004_01ResultsDataEntity.退避約定元金⇒Md004_01DTO.退避約定元金(修正)
		outDto.setID_Keep_M_YakujoGankin(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_YakujoGankin(), ""));
		// Md004_01ResultsDataEntity.退避約定利息⇒Md004_01DTO.退避約定利息(修正)
		outDto.setID_Keep_M_YakujoRisoku(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_YakujoRisoku(), ""));
		// Md004_01ResultsDataEntity.退避償還期限⇒Md004_01DTO.退避償還期限(修正)
		outDto.setID_Keep_Date_ShokanKigen(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Date_ShokanKigen()));
		// Md004_01ResultsDataEntity.最終更新年月日⇒Md004_01DTO.最終更新年月日(修正)
		outDto.setID_Data_LastUpDate(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Data_LastUpDate()));
		// Md004_01ResultsDataEntity.退避控除利息⇒Md004_01DTO.退避控除利息(修正)
		outDto.setID_Keep_M_KojoRisoku(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_KojoRisoku(), ""));
		// Md004_01ResultsDataEntity退避払込期日⇒Md004_01DTO.退避払込期日(修正)
		outDto.setID_Keep_Date_Haraikomi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Date_Haraikomi()));
		// Md004_01ResultsDataEntity.退避条変起案中区分⇒Md004_01DTO.退避条変起案中区分(修正)
		outDto.setID_Keep_JohenKianchu(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Keep_JohenKianchu()));
		// Md004_01ResultsDataEntity.条変起案中区分・稟議データ⇒Md004_01DTO.条変起案中区分・稟議データ(修正)
		outDto.setID_Kubun_JohenKianchu(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Kubun_JohenKianchu()));
		// Md004_01ResultsDataEntity.貸付実行日⇒Md004_01DTO.貸付実行日(修正)
		outDto.setID_Date_Jikko(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_Date_Jikko()));
		// Md004_01ResultsDataEntity.償還方法⇒Md004_01DTO.償還方法(修正)
		outDto.setID_Code_ShokanHouhou(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_ShokanHouhou()));
		// Md004_01ResultsDataEntity.貸付残高⇒Md004_01DTO.貸付残高(修正)
		outDto.setID_M_KashitsukeZandaka_aRingi(cnvBigToStr(outEntityList
				.get(0).getID_M_KashitsukeZandaka()));
		// Md004_01ResultsDataEntity.償還期限⇒Md004_01DTO.償還期限(修正)
		outDto.setID_Date_ShokanKigen_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_ShokanKigen()));
		// Md004_01ResultsDataEntity.賦金⇒Md004_01DTO.賦金(修正)
		outDto.setID_M_Fukin_aRingi(cnvBigToStr(outEntityList.get(0)
				.getID_M_Fukin()));
		// Md004_01ResultsDataEntity.元金不均等額⇒Md004_01DTO.元金不均等額(修正)
		outDto.setID_M_GankinFukinto_aRingi(cnvBigToStr(outEntityList.get(0)
				.getID_M_GankinFukinto()));
		// Md004_01ResultsDataEntity.元金不均等額区分⇒Md004_01DTO.元金不均等額区分(修正)
		outDto.setID_Kubun_GankinFukintogaku_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Kubun_GankinFukintogaku()));
		// Md004_01ResultsDataEntity.繰上償還手数料区分⇒Md004_01DTO.繰上償還手数料区分(修正)
		outDto.setID_Kubun_KurishoTesuryo_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Kubun_KurishoTesuryo()));
		// Md004_01ResultsDataEntity.元利金払込日⇒Md004_01DTO.元利金払込日(修正)
		outDto.setID_Date_GanrikinHaraiKomi_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Date_GanrikinHaraiKomi()));
		// Md004_01ResultsDataEntity.据置期限⇒Md004_01DTO.据置期限(修正)
		outDto.setID_Date_SueokiKigen_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_SueokiKigen()));
		// Md004_01ResultsDataEntity.特利有効期限⇒Md004_01DTO.特利有効期限(修正)
		outDto.setID_Date_TokuriYuko_aRingi(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_TokuriYuko()));
		// Md004_01ResultsDataEntity.利率⇒Md004_01DTO.利率(修正)
		outDto.setID_Riritsu_aRingi(mathPercent1000(outEntityList.get(0)
				.getID_Riritsu()));
		// Md004_01ResultsDataEntity.特利⇒Md004_01DTO.特利(修正)
		outDto.setID_Tokuri_aRingi(mathPercent1000(outEntityList.get(0)
				.getID_Tokuri()));
		// Md004_01ResultsDataEntity.ステータス⇒Md004_01DTO.ステータス(修正)
		outDto.setID_Status(cnvIntegerToStr(outEntityList.get(0).getID_Status()));
		// Md004_01ResultsDataEntity.報告書番号⇒Md004_01DTO.報告書番号(修正)
		outDto.setID_ID_Report(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_ID_Report()));
		// Md004_01ResultsDataEntity.時刻⇒Md004_01DTO.時刻(修正)
		outDto.setID_Time_Report(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Time_Report()));
		// Md004_01ResultsDataEntity.ユーザＩＤ⇒Md004_01DTO.ユーザＩＤ(修正)
		outDto.setID_User_ID(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_User_ID()));
		// Md004_01ResultsDataEntity.伝送番号⇒Md004_01DTO.伝送番号(修正)
		outDto.setID_ID_Denso(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_ID_Denso()));
		// Md004_01ResultsDataEntity.データコード⇒Md004_01DTO.データコード(修正)
		outDto.setID_DataCode(PNCommonComponents.cnvNulltoBlank(outEntityList
				.get(0).getID_DataCode()));
		// Md004_01ResultsDataEntity.退避履歴番号⇒Md004_01DTO.退避履歴番号(修正)
		outDto.setID_Keep_ID_History(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Keep_ID_History()));
		// Md004_01ResultsDataEntity.充当順序変更区分⇒Md004_01DTO.充当順序変更区分(修正)
		outDto.setID_Kubun_JutoJunjoHenko(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Kubun_JutoJunjoHenko()));
		// 更正(赤)用画面情報の場合
		// （表示項目／入力項目）
		outDto.setID_ID_Report(outEntityList.get(0).getID_ID_Report());
		// Md004_01ResultsDataEntity.顧客名⇒Md004_01DTO.顧客名
		outDto.setTxtID_Name_Customer_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Name_Customer()));
		// Md004_01ResultsDataEntity.扱店名⇒Md004_01DTO.扱店名
		outDto.setTxtID_Name_Organization_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Name_Organization()));
		// Md004_01ResultsDataEntity.公庫支店⇒Md004_01DTO.公庫支店(修正)
		outDto.setTxtID_Code_KoukoShiten_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_KoukoShiten()));
		// Md004_01ResultsDataEntity.扱店⇒Md004_01DTO.扱店
		outDto.setTxtID_Code_Organization_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Organization()));
		// Md004_01ResultsDataEntity.店舗⇒Md004_01DTO.店舗
		outDto.setTxtID_Code_Tenpo_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Tenpo()));
		// Md004_01ResultsDataEntity.年度⇒Md004_01DTO.年度
		outDto.setTxtID_Year_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
		// Md004_01ResultsDataEntity.方式資金⇒Md004_01DTO.方式資金
		outDto.setTxtID_Code_HoshikiShikin_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_HoshikiShikin()));
		// Md004_01ResultsDataEntity.番号⇒Md004_01DTO.番号(修正)
		outDto.setTxtID_ID_Ringi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
		// Md004_01ResultsDataEntity.枝番⇒Md004_01DTO.枝番(修正)値が0の場合、空白を設定
		outDto.setTxtID_ID_RingiBranch_Red(cnvZeroToBlank(outEntityList.get(0)
				.getID_ID_RingiBranch()));
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.繰償還後第１回払込期日
		outDto.setTxtDate_FirstHaraikomiAfterKuris_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getDate_FirstHaraikomiAfterKuris()));
		// Md004_01ResultsDataEntity.入金日⇒Md004_01DTO.入金日
		outDto.setTxtID_Date_Nyukin_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Nyukin()));
		// Md004_01ResultsDataEntity.繰上償還事由コード⇒Md004_01DTO.繰上償還事由コード
		outDto.setTxtID_Code_Kurishojiyu_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_KurishoJiyu()));
		// Md004_01ResultsDataEntity.利息⇒Md004_01DTO.利息(円)
		outDto.setTxtID_M_KurishoRisoku_Red(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoRisoku()));
		// Md004_01ResultsDataEntity.元金⇒Md004_01DTO.元金(円)
		outDto.setTxtID_M_KurishoGankin_Red(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoGankin()));
		// Md004_01ResultsDataEntity.仮受金からの充当額⇒Md004_01DTO.仮受金からの充当額(円)
		if ("0".equals(PNCommonComponents.cnvNulltoZero(
				outEntityList.get(0).getID_M_KariukeIppanJuto()).toString())) {
			outDto.setTxtID_M_KariukeIppanJuto_Red(PNCommonConstants.LITERAL_BLANK);
		} else {
			outDto.setTxtID_M_KariukeIppanJuto_Red(PNCommonComponents
					.cnvNulltoZero(
							outEntityList.get(0).getID_M_KariukeIppanJuto())
					.toString());
		}
		// Md004_01ResultsDataEntity.控除利息⇒Md004_01DTO.控除利息(円)
		outDto.setTxtID_M_KojoRisoku_Red(cnvBigToStr(outEntityList.get(0)
				.getID_M_KojoRisoku()));
		// Md004_01ResultsDataEntity.送金額⇒Md004_01DTO.送金額(円)
		if ("0".equals(PNCommonComponents.cnvNulltoZero(
				outEntityList.get(0).getID_M_Sokin()).toString())) {
			outDto.setTxtID_M_Sokin_Red(PNCommonConstants.LITERAL_BLANK);
		} else {
			outDto.setTxtID_M_Sokin_Red(PNCommonComponents.cnvNulltoZero(
					outEntityList.get(0).getID_M_Sokin()).toString());
		}
		// Md004_01ResultsDataEntity.繰償後残元金⇒Md004_01DTO.繰償後残元金(円)
		outDto.setTxtID_M_ZanGankinAfterKurisho_Red(cnvBigToStr(outEntityList
				.get(0).getID_M_ZanAfterKurisho()));
		// Md004_01ResultsDataEntity.繰上償還手数料⇒Md004_01DTO.繰上償還手数料(円)
		outDto.setTxtID_M_KurishoCommission_Red(cnvBigToStr(outEntityList
				.get(0).getID_M_KurishoCommission()));
		// Md004_01ResultsDataEntity.払込期日１⇒Md004_01DTO.払込期日①
		outDto.setTxtID_Date_Haraikomi1_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Haraikomi1()));
		// Md004_01ResultsDataEntity.払込元金１⇒Md004_01DTO.払込元金①
		outDto.setTxtID_M_HaraikomiGankin1_Red(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin1())));
		// Md004_01ResultsDataEntity.払込期日２⇒Md004_01DTO.払込期日②
		outDto.setTxtID_Date_Haraikomi2_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Haraikomi2()));
		// Md004_01ResultsDataEntity.払込元金２⇒Md004_01DTO.払込元金②
		outDto.setTxtID_M_HaraikomiGankin2_Red(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin2())));
		// Md004_01ResultsDataEntity.払込期日３⇒Md004_01DTO.払込期日③
		outDto.setTxtID_Date_Haraikomi3_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Haraikomi3()));
		// Md004_01ResultsDataEntity.払込元金３⇒Md004_01DTO.払込元金③
		outDto.setTxtID_M_HaraikomiGankin3_Red(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin3())));
		// Md004_01ResultsDataEntity.払込期日４⇒Md004_01DTO.払込期日④
		outDto.setTxtID_Date_Haraikomi4_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Haraikomi4()));
		// Md004_01ResultsDataEntity.払込元金４⇒Md004_01DTO.払込元金④
		outDto.setTxtID_M_HaraikomiGankin4_Red(cnvZeroToBlank(cnvBigToStr(outEntityList
				.get(0).getID_M_HaraikomiGankin4())));
		// Md004_01ResultsDataEntity.繰償後元金均等額⇒Md004_01DTO.繰償後元金均等額(円)
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents
				.cnvNulltoZero(outEntityList.get(0)
						.getID_M_GankinKintoAfterKurisho()))) {
			outDto.setTxtID_M_GankinKintoAfterKurisho_Red((cnvBigToStr(outEntityList
					.get(0).getID_M_GankinKintoAfterKurisho())));
		} else {
			outDto.setTxtID_M_GankinKintoAfterKurisho_Red("");
		}
		// Md004_01ResultsDataEntity.繰償後元金不均等額⇒Md004_01DTO.繰償後元金不均等額(円)
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents
				.cnvNulltoZero(outEntityList.get(0)
						.getID_M_GankinKintoAfterKurisho()))) {
			outDto.setTxtID_M_GankinFukintoAfterKurisho_Red((cnvBigToStr(outEntityList
					.get(0).getID_M_GankinFukintoAfterKurisho())));
		} else {
			outDto.setTxtID_M_GankinFukintoAfterKurisho_Red("");
		}
		// Md004_01ResultsDataEntity.調整コード⇒Md004_01DTO.調整コード
		outDto.setRdoID_Code_chosei_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Chosei()));
		// Md004_01ResultsDataEntity.受託者勘定処理年月⇒Md004_01DTO.受託者勘定処理年月
		outDto.setTxtID_Date_JtkShori_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Jtkshori()));
		// Md004_01ResultsDataEntity.送金日⇒Md004_01DTO.送金日
		outDto.setTxtID_Date_Sokin_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Sokin()));
		// Md004_01ResultsDataEntity.送金日番号⇒Md004_01DTO.送金日番号
		outDto.setTxtID_ID_Sokinbi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_Sokinbi()));
		// 空文字⇒Md004_01DTO.受託者勘定処理年月(年)
// [UPD] Ver 2.0.0 - START
//		outDto.setDrpID_Date_Jtkshori_Gengo_Red("H");
		outDto.setDrpID_Date_Jtkshori_Gengo_Red(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
		// 空文字⇒Md004_01DTO.受託者勘定処理年月(月)
		outDto.setTxtID_Date_Jtkshori_Nen_Red("");

		// （非表示項目）
		// Md004_01ResultsDataEntity.履歴番号⇒Md004_01DTO.履歴番号
		outDto.setID_ID_History_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
		// Md004_01ResultsDataEntity.処理種別⇒Md004_01DTO.処理種別
		outDto.setID_Type_Process_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Type_Process()));
		// Md004_01ResultsDataEntity.取消済フラグ⇒Md004_01DTO.取消済フラグ
		outDto.setID_Flag_Torikeshizumi_Red(cnvIntegerToStr(outEntityList
				.get(0).getID_Flag_Torikeshizumi()));
		// Md004_01ResultsDataEntity.エラーコード⇒Md004_01DTO.エラーコード
		outDto.setID_Code_Error_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
		// Md004_01ResultsDataEntity.エラーメッセージ⇒Md004_01DTO.エラーメッセージ
		outDto.setID_ErrorMessage_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ErrorMessage()));
		// Md004_01ResultsDataEntity.債権管理番号⇒Md004_01DTO.債権管理番号
		outDto.setID_ID_Credit_Red(cnvBigToStr(outEntityList.get(0)
				.getID_ID_Credit(), ""));
		// Md004_01ResultsDataEntity.退避賦金⇒Md004_01DTO.退避賦金
		outDto.setID_Keep_M_Fukin_Red(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_Fukin(), ""));
		// Md004_01ResultsDataEntity.退避元金不均等額⇒Md004_01DTO.退避元金不均等額
		outDto.setID_Keep_M_GankinFukinto_Red(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_GankinFukinto(), ""));
		// Md004_01ResultsDataEntity.退避元金不均等区分⇒Md004_01DTO.退避元金不均等区分
		outDto.setID_Keep_Kubun_GankinFukinto_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Kubun_GankinFukinto()));
		// 処理種別(受渡)が処理完了以外：修正の場合
		// 取得した繰償事由コードが空白以外の場合、貸付残高を再計算する。
		if (4 == Integer.parseInt(inDto.getID_Type_Process_H())
				&& 0 != getStrLength(outEntityList.get(0)
						.getID_Code_KurishoJiyu())) {
			// Md004_01DTO.退避貸付残高(修正)＝Md004_01ResultsDataEntity.元金＋Md004_01ResultsDataEntity.繰償後残元金
			outDto.setID_Keep_M_KashitsukeZan_Red(PNCommonComponents
					.cnvNulltoZero(outEntityList.get(0).getID_M_KurishoGankin())
					.add(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
							.getID_M_ZanAfterKurisho())).toString());
		} else {
			// 上記以外の場合
			// Md004_01ResultsDataEntity.退避貸付残高⇒Md004_01DTO.退避貸付残高(修正)
			outDto.setID_Keep_M_KashitsukeZan_Red(cnvBigToStr(outEntityList
					.get(0).getID_Keep_M_KashitsukeZan(), ""));
		}

		// Md004_01ResultsDataEntity.退避約定元金⇒Md004_01DTO.退避約定元金
		outDto.setID_Keep_M_YakujoGankin_Red(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_YakujoGankin(), ""));
		// Md004_01ResultsDataEntity.退避約定利息⇒Md004_01DTO.退避約定利息
		outDto.setID_Keep_M_YakujoRisoku_Red(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_YakujoRisoku(), ""));
		// Md004_01ResultsDataEntity.退避償還期限⇒Md004_01DTO.退避償還期限
		outDto.setID_Keep_Date_ShokanKigen_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Date_ShokanKigen()));
		// Md004_01ResultsDataEntity.最終更新年月日⇒Md004_01DTO.最終更新年月日
		outDto.setID_Data_LastUpDate_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Data_LastUpDate()));
		// Md004_01ResultsDataEntity.退避控除利息⇒Md004_01DTO.退避控除利息
		outDto.setID_Keep_M_KojoRisoku_Red(cnvBigToStr(outEntityList.get(0)
				.getID_Keep_M_KojoRisoku(), ""));
		// Md004_01ResultsDataEntity退避払込期日⇒Md004_01DTO.退避払込期日
		outDto.setID_Keep_Date_Haraikomi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Keep_Date_Haraikomi()));
		// Md004_01ResultsDataEntity.退避条変起案中区分⇒Md004_01DTO.退避条変起案中区分
		outDto.setID_Keep_JohenKianchu_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Keep_JohenKianchu()));
		// Md004_01ResultsDataEntity.条変起案中区分・稟議データ⇒Md004_01DTO.条変起案中区分・稟議データ
		outDto.setID_Kubun_JohenKianchu_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Kubun_JohenKianchu()));
		// Md004_01ResultsDataEntity.貸付実行日⇒Md004_01DTO.貸付実行日
		outDto.setID_Date_Jikko_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_Jikko()));
		// Md004_01ResultsDataEntity.償還方法⇒Md004_01DTO.償還方法
		outDto.setID_Code_ShokanHouhou_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Code_ShokanHouhou()));
		// Md004_01ResultsDataEntity.貸付残高⇒Md004_01DTO.貸付残高
		outDto.setID_M_KashitsukeZandaka_aRingi_Red(cnvBigToStr(outEntityList
				.get(0).getID_M_KashitsukeZandaka()));
		// Md004_01ResultsDataEntity.償還期限⇒Md004_01DTO.償還期限
		outDto.setID_Date_ShokanKigen_aRingi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_ShokanKigen()));
		// Md004_01ResultsDataEntity.賦金⇒Md004_01DTO.賦金
		outDto.setID_M_Fukin_aRingi_Red(cnvBigToStr(outEntityList.get(0)
				.getID_M_Fukin()));
		// Md004_01ResultsDataEntity.元金不均等額⇒Md004_01DTO.元金不均等額
		outDto.setID_M_GankinFukinto_aRingi_Red(cnvBigToStr(outEntityList
				.get(0).getID_M_GankinFukinto()));
		// Md004_01ResultsDataEntity.元金不均等額区分⇒Md004_01DTO.元金不均等額区分
		outDto.setID_Kubun_GankinFukintogaku_aRingi_Red(outEntityList.get(0)
				.getID_Kubun_GankinFukintogaku());
		// Md004_01ResultsDataEntity.繰上償還手数料区分⇒Md004_01DTO.繰上償還手数料区分
		outDto.setID_Kubun_KurishoTesuryo_aRingi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Kubun_KurishoTesuryo()));
		// Md004_01ResultsDataEntity.元利金払込日⇒Md004_01DTO.元利金払込日
		outDto.setID_Date_GanrikinHaraiKomi_aRingi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Date_GanrikinHaraiKomi()));
		// Md004_01ResultsDataEntity.据置期限⇒Md004_01DTO.据置期限
		outDto.setID_Date_SueokiKigen_aRingi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_SueokiKigen()));
		// Md004_01ResultsDataEntity.特利有効期限⇒Md004_01DTO.特利有効期限
		outDto.setID_Date_TokuriYuko_aRingi_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Date_TokuriYuko()));
		// Md004_01ResultsDataEntity.利率⇒Md004_01DTO.利率
		outDto.setID_Riritsu_aRingi_Red(mathPercent1000(outEntityList.get(0)
				.getID_Riritsu()));
		// Md004_01ResultsDataEntity.特利⇒Md004_01DTO.特利
		outDto.setID_Tokuri_aRingi_Red(mathPercent1000(outEntityList.get(0)
				.getID_Tokuri()));
		// Md004_01ResultsDataEntity.ステータス⇒Md004_01DTO.ステータス
		outDto.setID_Status_Red(cnvIntegerToStr(outEntityList.get(0)
				.getID_Status()));
		// Md004_01ResultsDataEntity.報告書番号⇒Md004_01DTO.報告書番号
		outDto.setID_ID_Report_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
		// Md004_01ResultsDataEntity.時刻⇒Md004_01DTO.時刻
		outDto.setID_Time_Report_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Time_Report()));
		// Md004_01ResultsDataEntity.ユーザＩＤ⇒Md004_01DTO.ユーザＩＤ
		outDto.setID_User_ID_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_User_ID()));
		// Md004_01ResultsDataEntity.伝送番号⇒Md004_01DTO.伝送番号
		outDto.setID_ID_Denso_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
		// Md004_01ResultsDataEntity.データコード⇒Md004_01DTO.データコード
		outDto.setID_DataCode_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_DataCode()));
		// Md004_01ResultsDataEntity.退避履歴番号⇒Md004_01DTO.退避履歴番号
		outDto.setID_Keep_ID_History_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0).getID_Keep_ID_History()));
		// Md004_01ResultsDataEntity.充当順序変更区分⇒Md004_01DTO.充当順序変更区分
		outDto.setID_Kubun_JutoJunjoHenko_Red(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getID_Kubun_JutoJunjoHenko()));
		// 共通情報
		// （非表示項目）
		// Md004_01ResultsDataEntity.元金⇒Md004_01DTO.元金(DB取得値)
		outDto.setID_M_KurishoGankin_Save(cnvBigToStr(outEntityList.get(0)
				.getID_M_KurishoGankin()));
		// Md004_01ResultsDataEntity.繰償後残元金⇒Md004_01DTO.繰償後残元金(DB取得値)
		outDto.setID_M_ZanGankinAfterKurisho_Save(cnvBigToStr(outEntityList
				.get(0).getID_M_ZanAfterKurisho()));
		// Md004_01ResultsDataEntity.繰償還後第１回払込期日⇒Md004_01DTO.償還後第１回払込期日(DB取得値)
		outDto.setDate_FirstHaraikomiAfterKuris_Save(PNCommonComponents
				.cnvNulltoBlank(outEntityList.get(0)
						.getDate_FirstHaraikomiAfterKuris()));
		return outDto;
	}

	/**
	 * Md004_01ServiceのgetYakujo
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO getYakujo(Md004_01DTO inDto) {

		Md004_01DTO outDto = inDto;

		// 約定データ存在チェック

		// 約定データの件数取得の検索条件を設定
		// 単テーブルアクセス定義の「約定データ件数取得」を参照し、条件を設定する。
		// 債権管理番号＝約定データ検索パラメータ(債権管理番号）
		YakujoEntity serchEntity_YakujoEntity = new YakujoEntity();
		// 債権管理番号＝約定データ検索パラメータ(債権管理番号）
		serchEntity_YakujoEntity.setID_Credit(cnvStrToBig(inDto
				.getYakujoParam_ID_Credit()));
		// 払込期日＝約定データ検索パラメータ(払込期日）
		serchEntity_YakujoEntity.setDate_Haraikomi(PNCommonComponents
				.cnvNulltoBlank(inDto.getYakujoParam_Date_Haraikomi()));

		List<YakujoEntity> outEntityList_YakujoEntity = yakujodao
				.findByCondition(serchEntity_YakujoEntity);

		// 取得件数をＤＴＯ.約定データ検索結果(件数）へ設定
		outDto.setYakujoAns_Count(outEntityList_YakujoEntity.size());

		// 取得した件数＝1件の場合
		if (1 == outEntityList_YakujoEntity.size()) {
			// Entity⇒DTOに転記
			// YakujoEntity.払込年月日⇒Md004_01DTO.約定データ検索結果(払込期日)
			outDto.setYakujoAns_Date_Haraikomi(outEntityList_YakujoEntity
					.get(0).getDate_Haraikomi());
			// YakujoEntity.約定元金⇒Md004_01DTO.約定データ検索結果(約定元金）
			outDto.setYakujoAns_ID_M_YakujoGankin(cnvBigToStr(outEntityList_YakujoEntity
					.get(0).getM_YakujoGankin()));
			// YakujoEntity.約定利息⇒Md004_01DTO.約定データ検索結果(約定利息）
			outDto.setYakujoAns_ID_M_YakujoRisoku(cnvBigToStr(outEntityList_YakujoEntity
					.get(0).getM_YakujoRisoku()));
			// YakujoEntity.請求繰上償還利息⇒Md004_01DTO.約定データ検索結果(請求繰上償還利息)
			outDto.setYakujoAns_ID_M_SeiKuriRisoku(cnvBigToStr(outEntityList_YakujoEntity
					.get(0).getM_SeiKuriRisoku()));
		}

		return outDto;
	}

	/**
	 * Md004_01ServiceのcheckJutoJunjo
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO checkJutoJunjo(Md004_01DTO inDto) {

		// ########################################################################################
		// # 充当順序チェック
		// ########################################################################################
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		bizErrors.clear();

		Md004_01DTO outDto = inDto;

		// 判定用繰償還事由
		String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(inDto);

		// 入力元金⇒入力元金TMP（元金入力なしの場合０を設定）
		BigDecimal tmp_InputGankin = cnvStrToBig(inDto
				.getTxtID_M_KurishoGankin());
		// 入力利息⇒入力利息TMP（利息入力なしの場合０を設定）
		BigDecimal tmp_InputRisoku = cnvStrToBig(inDto
				.getTxtID_M_KurishoRisoku());

		// 約定元金TMP 初期化
		BigDecimal tmp_YakujoGankin = BigDecimal.ZERO;
		// 約定利息TMP 初期化
		BigDecimal tmp_YakujoRisoku = BigDecimal.ZERO;

		// 充当順序変更区分＝0の場合
		if ("0".equals(PNCommonComponents.cnvNulltoBlank(inDto
				.getID_Kubun_JutoJunjoHenko()))) {
			// (1)繰償後第１回払込期日より過去の請求データチェック
			// 複数テーブルアクセス定義の「Md004_01SeikyuCountDAO」を参照し、条件を設定する。
			// 債権管理番号＝債権管理番号
			// 払込年月日＝償還後第１回払込期日(DB取得値)
			// 請求データ データ取得
			long tmp_hitcount = this.getResult_SeikyuCount1(
					new Md004_01SeikyuCountEntity(), cnvStrToBig(inDto
							.getID_ID_Credit()), PNCommonComponents
							.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Save()));
			if (0 < tmp_hitcount) {
				// 取得件数＞０の場合、業務エラーとする
				// メッセージ：PM3850E※充当順序誤り
				this.addError(outDto, PNCommonMessageConstants.PM3850E,
						new String[0]);
				return outDto;
			}
			// 償還後第1回払込期(DB取得値)＜償還後第1回払込期(修正)（入力値連結）の場合、以下を行う
			if (cnvStrToInteger(inDto.getDate_FirstHaraikomiAfterKuris_Save()) < cnvStrToInteger(inDto
					.getDate_FirstHaraikomiAfterKuris_Input())) {
				// 退避約定元金＞０ または、退避約定利息＞0の場合、業務エラーとする。（値がNULL/空文字は0と扱う）
				if (0 < cnvStrToBig(inDto.getID_Keep_M_YakujoGankin())
						.doubleValue()
						|| 0 < cnvStrToBig(inDto.getID_Keep_M_YakujoRisoku())
								.doubleValue()) {
					// メッセージ：PM3850E※充当順序誤り
					this.addError(outDto, PNCommonMessageConstants.PM3850E,
							new String[0]);
					return outDto;
				}
			}

			// (2)繰償後第１回払込期日の請求データチェック
			// 単テーブルアクセス定義の「請求データ　データ取得」を参照し、条件を設定する。
			// 債権管理番号＝債権管理番号
			// 払込年月日＝償還後第1回払込期(修正)（入力値連結）
			// SeikyuDAO.findByCondition
			List<Md004_01SeikyuDataEntity> outEntityList_SeikyuEntity = this
					.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
							cnvStrToBig(inDto.getID_ID_Credit()),
							PNCommonComponents.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));
			// 請求データが取得できた場合、以下を行う
			if (0 < outEntityList_SeikyuEntity.size()) {

				// 償還後第1回払込期(DB取得値)＜ 取得した払込年月日の場合、以下を行う
				if (cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Save()) < cnvStrToInteger(outEntityList_SeikyuEntity
						.get(0).getDate_Haraikomi())) {
					// 取得した約定利息⇒約定利息TMP（値がNULL/空文字は0と扱う）
					tmp_YakujoRisoku = cnvNullToZeroBig(outEntityList_SeikyuEntity
							.get(0).getID_M_YakujoRisoku());
				} else {
					// 上記以外の場合、以下を行う
					// 退避約定利息(修正)⇒約定利息TMP（値がNULL/空文字は0と扱う）
					tmp_YakujoRisoku = cnvStrToBig(inDto
							.getID_Keep_M_YakujoRisoku());
				}

				// 繰償事由コード入力なしの場合
				if (0 == getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 入力元金TMP＞０の場合、エラーとする。
					if (0 < tmp_InputGankin.doubleValue()) {
						// メッセージ：PM3490E ※元金有額
						// 充当順序チェック処理を抜ける
						this.addError(outDto, PNCommonMessageConstants.PM3490E,
								new String[0]);
						return outDto;
					}
					// 上記以外の場合、以下を行う
					else {
						// 取得した任意繰上償還利息＋取得した請求繰上償還利息－入力利息TMP＜０の場合、エラーとする
						if (0 > cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_NinKuriRisoku()).add(
								cnvNullToZeroBig(
										outEntityList_SeikyuEntity.get(0)
												.getID_M_SeiKuriRisoku())
										.subtract(tmp_InputRisoku))
								.doubleValue()) {
							// メッセージ：利息≦任意繰上償還利息＋請求繰上償還利息、PM3140E
							// 充当順序チェック処理を抜ける
							this.addError(outDto,
									PNCommonMessageConstants.PM3140E,
									new String[] { "利息≦任意繰上償還利息＋請求繰上償還利息" });
							return outDto;
						}
					}
				}

				// 繰償事由コード入力ありの場合
				if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {

					// 繰償事由コードの上１桁＝２、４の場合
					if ("2".equals(hantei_KurishojiyuStr01)
							|| "4".equals(hantei_KurishojiyuStr01)) {
						// 取得した請求繰上償還元金≦０の場合、業務エラーとする
						if (0 >= cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriGankin()).doubleValue()) {
							// メッセージ：請求データ、PM3190E※請求データ取得エラー
							this.addError(outDto,
									PNCommonMessageConstants.PM3190E,
									new String[] { "請求データ" });
							return outDto;
						}

						// (取得した任意繰上償還利息 ＞
						// 0又は、約定利息TMP＞０又は、取得した請求繰上償還利息－入力利息TMP＞0)
						// かつ、入力元金TMP＞０の場合、業務エラーとする
						if ((0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_NinKuriRisoku()).doubleValue()
								|| 0 < cnvNullToZeroBig(tmp_YakujoRisoku)
										.doubleValue() || 0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_NinKuriRisoku()).subtract(
								tmp_InputRisoku).doubleValue())
								&& 0 < tmp_InputGankin.doubleValue()) {
							// メッセージ：PM3850E
							this.addError(outDto,
									PNCommonMessageConstants.PM3850E,
									new String[0]);
							return outDto;
						}

					}

					// 繰償事由コードの上１桁＝１，３，５，６の場合
					// （取得した請求繰上償還元金＞０又は、取得した請求繰上償還利息＞０）かつ、入力元金TMP＞０の場合、エラーとする
					if (Arrays.asList(new String[] { "1", "3", "5", "6" })
							.contains(hantei_KurishojiyuStr01)) {
						if ((0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriGankin()).doubleValue() || 0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriRisoku()).doubleValue())
								&& 0 < cnvNullToZeroBig(tmp_InputGankin)
										.doubleValue()) {
							// メッセージ：元金：繰償請求期日の報告書作成は不可能です。、PM3000E
							// 充当順序チェック処理を抜ける
							this.addError(outDto,
									PNCommonMessageConstants.PM3000E,
									new String[] { "元金：繰償請求期日の報告書作成は不可能です。" });
							return outDto;
						}
					}
				}
			}

			// 上記以外の場合、以下を行う(請求データなしの場合)
			if (0 == outEntityList_SeikyuEntity.size()) {
				// 繰償事由コードが空白以外の場合、以下を行う
				if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 繰償事由コードの上１桁＝２、４の場合、業務エラーとする。
					if ("2".equals(hantei_KurishojiyuStr01)
							|| "4".equals(hantei_KurishojiyuStr01)) {
						// メッセージ：請求データ、PM3190E ※請求データ取得エラー
						this.addError(outDto, PNCommonMessageConstants.PM3190E,
								new String[] { "請求データ" });
						return outDto;
					}
				}
				// 繰償事由コードが空白の場合
				if (0 == getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 入力元金TMP＞０の場合、エラーとする。
					if (0 < tmp_InputGankin.doubleValue()) {
						// メッセージ：PM3490E※元金有額
						// 充当順序チェック処理を抜ける
						this.addError(outDto, PNCommonMessageConstants.PM3490E,
								new String[0]);
						return outDto;
					}
				}
			}
		}

		// 充当順序区分＝1の場合
		if ("1".equals(PNCommonComponents.cnvNulltoBlank(inDto
				.getID_Kubun_JutoJunjoHenko()))) {
			// 貸付残高TMP
			BigDecimal tmp_KashitsukeZan = BigDecimal.ZERO;

			// 退避貸付金残高が空白の場合、貸付金残高⇒貸付残高TMP
			if (0 == getStrLength(inDto.getID_Keep_M_KashitsukeZan())) {
				tmp_KashitsukeZan = cnvStrToBig(inDto
						.getID_M_KashitsukeZandaka_aRingi());
			}
			// 退避貸付金残高が空白以外の場合、退避貸付金残高⇒貸付残高TMP
			else {
				tmp_KashitsukeZan = cnvStrToBig(inDto
						.getID_Keep_M_KashitsukeZan());
			}

			// (貸付残高TMP－入力元金TMP)＞０かつ、入力利息TMP＞０の場合、業務エラーとする。
			// メッセージ：PM3850E※充当順序誤り
			if (0 < tmp_KashitsukeZan.subtract(tmp_InputGankin).doubleValue()
					&& 0 < tmp_InputRisoku.doubleValue()) {
				this.addError(outDto, PNCommonMessageConstants.PM3850E,
						new String[0]);
				return outDto;
			}

			// (1) 繰償後第１回払込期日より過去の請求データチェック
			// 請求データ存在チェック
			// 複数テーブルアクセス定義の「Md004_01SeikyuCount2DAO」を参照し、条件を設定する。
			// 債権管理番号＝債権管理番号
			// 払込年月日＝償還後第１回払込期(DB取得値)※払込期日＜指定した払込期日を検索する
			// 請求データ データ取得
			long tmp_hitcount = this.getResult_SeikyuCount2(
					new Md004_01SeikyuCount2Entity(), cnvStrToBig(inDto
							.getID_ID_Credit()), PNCommonComponents
							.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));

			// 取得件数＞０の場合、業務エラーとする
			// メッセージ：PM3850E※充当順序誤り
			if (0 < tmp_hitcount) {
				this.addError(outDto, PNCommonMessageConstants.PM3850E,
						new String[0]);
				return outDto;
			}

			// 償還後第1回払込期(DB取得値)＜償還後第1回払込期(修正)（入力値連結）の場合、以下を行う
			if (cnvStrToInteger(inDto.getDate_FirstHaraikomiAfterKuris_Save()) < cnvStrToInteger(inDto
					.getDate_FirstHaraikomiAfterKuris_Input())) {
				// 退避約定元金＞０ または、退避約定利息＞0の場合、業務エラーとする。（値がNULL/空文字は0と扱う）
				if (0 < cnvStrToBig(inDto.getID_Keep_M_YakujoGankin())
						.doubleValue()
						|| 0 < cnvStrToBig(inDto.getID_Keep_M_YakujoRisoku())
								.doubleValue()) {
					// メッセージ：PM3850E※充当順序誤り
					this.addError(outDto, PNCommonMessageConstants.PM3850E,
							new String[0]);
					return outDto;
				}
			}

			// (2)繰償後第１回払込期日の請求データチェック
			// 請求データ存在チェック
			// 単テーブルアクセス定義の「請求データ　データ取得」を参照し、条件を設定する。
			// 債権管理番号＝債権管理番号
			// 払込年月日　＝償還後第1回払込期(修正)（入力値連結）
			List<Md004_01SeikyuDataEntity> outEntityList_SeikyuEntity = this
					.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
							cnvStrToBig(inDto.getID_ID_Credit()),
							PNCommonComponents.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));

			// 請求データが取得できた場合、以下を行う
			if (0 < outEntityList_SeikyuEntity.size()) {

				// 繰償事由コード入力なしの場合
				if (0 == getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 入力元金TMP＞０の場合、エラーとする。
					if (0 < tmp_InputGankin.doubleValue()) {
						// メッセージ：PM3490E ※元金有額
						// 充当順序チェック処理を抜ける
						this.addError(outDto, PNCommonMessageConstants.PM3490E,
								new String[0]);
						return outDto;
					}

					// 上記以外の場合、以下を行う
					else {
						// 取得した任意繰上償還利息＋取得した請求繰上償還利息－入力利息TMP＜０の場合、エラーとする。
						// メッセージ：利息≦任意繰上償還利息＋請求繰上償還利息、PM3140E
						// 充当順序チェック処理を抜ける
						if (0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_NinKuriRisoku())
								.add(cnvNullToZeroBig(outEntityList_SeikyuEntity
										.get(0).getID_M_SeiKuriRisoku()))
								.subtract(cnvNullToZeroBig(tmp_InputRisoku))
								.doubleValue()) {
							this.addError(outDto,
									PNCommonMessageConstants.PM3140E,
									new String[] { "利息≦任意繰上償還利息＋請求繰上償還利息" });
							return outDto;
						}
					}
				}
				// 上記以外の場合、以下を行う(繰償事由コード入力あり)

				// 繰償事由コードが空白以外の場合、以下を行う
				if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 繰償事由コードの上１桁＝２、４の場合、
					if ("2".equals(hantei_KurishojiyuStr01)
							|| "4".equals(hantei_KurishojiyuStr01)) {
						// 　取得した請求繰上償還元金≦０の場合、業務エラーとする
						if (0 >= cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriGankin()).doubleValue()) {
							// メッセージ：PM3850E
							this.addError(outDto,
									PNCommonMessageConstants.PM3850E,
									new String[0]);
							return outDto;
						}
						// 上記以外の場合、以下を行う
						else {
							// 取得した請求繰上償還元金－入力元金TMP＞０かつ、入力利息TMP＞０)の場合、業務エラーとする。
							// メッセージ：PM3850E
							// 入力元金TMP＞０の場合、エラーとする。
							if (0 < cnvNullToZeroBig(
									outEntityList_SeikyuEntity.get(0)
											.getID_M_SeiKuriGankin()).subtract(
									cnvNullToZeroBig(tmp_InputGankin))
									.doubleValue()
									&& 0 < cnvNullToZeroBig(tmp_InputRisoku)
											.doubleValue()) {
								// メッセージ：PM3490E※元金有額
								// 充当順序チェック処理を抜ける
								this.addError(outDto,
										PNCommonMessageConstants.PM3490E,
										new String[0]);
								return outDto;
							}
						}
					}
					// 繰償事由コードの上１桁＝１，３，５，６の場合
					// （取得した請求繰上償還元金＞０又は、取得した請求繰上償還利息＞０）かつ、入力元金TMP＞０の場合、エラーとする
					if (Arrays.asList(new String[] { "1", "3", "5", "6" })
							.contains(hantei_KurishojiyuStr01)) {
						if ((0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriGankin()).doubleValue() || 0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_SeiKuriRisoku()).doubleValue())
								&& 0 < cnvNullToZeroBig(tmp_InputGankin)
										.doubleValue()) {
							// メッセージ：元金：繰償請求期日の報告書作成は不可能です。、PM3000E
							// 充当順序チェック処理を抜ける
							// メッセージ：PM3850E
							this.addError(outDto,
									PNCommonMessageConstants.PM3000E,
									new String[] { "元金：繰償請求期日の報告書作成は不可能です。" });
							return outDto;
						}
					}
				}
				// 請求データが取得できない場合
				if (0 == outEntityList_SeikyuEntity.size()) {
					// 繰償事由コードが空白以外の場合、以下を行う
					// 繰償事由コードの上１桁＝２、４の場合、業務エラーとする。
					// メッセージ：請求データ、PM3190E ※請求データ取得エラー
					// 繰償事由コードが空白以外の場合、以下を行う
					if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
						// 繰償事由コードの上１桁＝２、４の場合、業務エラーとする。
						if ("2".equals(hantei_KurishojiyuStr01)
								|| "4".equals(hantei_KurishojiyuStr01)) {
							this.addError(outDto,
									PNCommonMessageConstants.PM3190E,
									new String[] { "請求データ" });
							return outDto;
						}
					}
					// 繰償事由コードが空白の場合
					else {
						// 入力元金TMP＞０の場合、エラーとする。
						// メッセージ：PM3490E※元金有額
						// 充当順序チェック処理を抜ける
						if (0 < tmp_InputGankin.doubleValue()) {
							this.addError(outDto,
									PNCommonMessageConstants.PM3490E,
									new String[0]);
							return outDto;
						}
					}
				}
			}
		}
		// 上記以外の場合、以下を行う (充当順序区分 0か1以外の場合)
		if (!"1".equals(PNCommonComponents.cnvNulltoBlank(inDto
				.getID_Kubun_JutoJunjoHenko()))
				&& !"0".equals(PNCommonComponents.cnvNulltoBlank(inDto
						.getID_Kubun_JutoJunjoHenko()))) {

			// 繰償事由コードが空白以外の場合
			if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
				// 繰償事由コードの上１桁＝１，３，５，６の場合
				if (Arrays.asList(new String[] { "1", "3", "5", "6" })
						.contains(hantei_KurishojiyuStr01)) {
					// 請求データ存在チェック
					// 複数テーブルアクセス定義の「Md004_01SeikyuCount2DAO」を参照し、条件を設定する。
					// 債権管理番号＝債権管理番号
					// 払込年月日＝償還後第１回払込期(入力値連結)※払込期日＜指定した払込期日を検索する
					long tmp_hitcount = this.getResult_SeikyuCount2(
							new Md004_01SeikyuCount2Entity(), cnvStrToBig(inDto
									.getID_ID_Credit()),
							PNCommonComponents.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));
					// 取得件数＞０の場合、業務エラーとする
					if (0 < tmp_hitcount) {
						// メッセージ：PM3850E※充当順序誤り
						this.addError(outDto, PNCommonMessageConstants.PM3850E,
								new String[0]);
						return outDto;
					}
				}
				// 償還後第１回払込期(DB取得値)<償還後第１回払込期(修正)（入力値連結）の場合、以下を行う
				if (cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Save()) < cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Input())) {
					// 退避約定元金＞０ または、退避約定利息＞0の場合、業務エラーとする。（値がNULL/空文字は0と扱う）
					if (0 < cnvStrToInteger(inDto.getID_Keep_M_YakujoGankin())
							&& 0 < cnvStrToInteger(inDto
									.getID_Keep_M_YakujoRisoku())) {
						// メッセージ：PM3850E※充当順序誤り
						this.addError(outDto, PNCommonMessageConstants.PM3850E,
								new String[0]);
						return outDto;
					}
				}
			}

			// (1)繰償後第１回払込期日の請求データチェック
			// 請求データ存在チェック
			// 単テーブルアクセス定義の「請求データ　データ取得」を参照し、条件を設定する。
			// 債権管理番号＝債権管理番号
			// 払込年月日　＝償還後第1回払込期(修正)（入力値連結）
			// SeikyuDAO.findByCondition
			List<Md004_01SeikyuDataEntity> outEntityList_SeikyuEntity = this
					.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
							cnvStrToBig(inDto.getID_ID_Credit()),
							PNCommonComponents.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));

			// 請求データが取得できた場合、以下を行う
			if (0 < outEntityList_SeikyuEntity.size()) {
				// 繰償事由コード入力なしの場合
				if (0 == getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					if (0 < tmp_InputGankin.doubleValue()) {
						// 入力元金TMP＞０の場合、エラーとする。
						// メッセージ：PM3490E※元金有額
						// 充当順序チェック処理を抜ける
						this.addError(outDto, PNCommonMessageConstants.PM3490E,
								new String[0]);
						return outDto;
					}
					// 上記以外の場合、以下を行う
					else {
						// 取得した任意繰上償還利息＋取得した請求繰上償還利息－入力利息TMP＜０の場合、エラーとする。
						if (0 < cnvNullToZeroBig(
								outEntityList_SeikyuEntity.get(0)
										.getID_M_NinKuriRisoku())
								.add(cnvNullToZeroBig(outEntityList_SeikyuEntity
										.get(0).getID_M_SeiKuriRisoku()))
								.subtract(cnvNullToZeroBig(tmp_InputRisoku))
								.doubleValue()) {
							// メッセージ：利息≦任意繰上償還利息＋請求繰上償還利息、PM3140E
							// 充当順序チェック処理を抜ける
							this.addError(outDto,
									PNCommonMessageConstants.PM3140E,
									new String[] { "利息≦任意繰上償還利息＋請求繰上償還利息" });
							return outDto;
						}
					}
				}
				// 繰償事由コードの上１桁＝１，３，５，６の場合
				// （取得した請求繰上償還元金＞０又は、取得した請求繰上償還利息＞０）かつ、入力元金TMP＞０の場合、エラーとする
				// メッセージ：元金：繰償請求期日の報告書作成は不可能です。、PM3000E
				// 充当順序チェック処理を抜ける
				// 繰償事由コードの上１桁＝１，３，５，６の場合
				if (Arrays.asList(new String[] { "1", "3", "5", "6" })
						.contains(hantei_KurishojiyuStr01)) {
					this.addError(outDto, PNCommonMessageConstants.PM3000E,
							new String[] { "繰償請求期日の報告書作成は不可能です。" });
					return outDto;
				}
			}
			// 上記以外の場合、以下を行う(請求データが取得出来ない場合、以下を行う)
			if (0 == outEntityList_SeikyuEntity.size()) {
				// 繰償事由コードが空白以外の場合、以下を行う
				if (0 != getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 繰償事由コードの上１桁＝２、４の場合、業務エラーとする。
					if ("2".equals(hantei_KurishojiyuStr01)
							|| "4".equals(hantei_KurishojiyuStr01)) {
						// メッセージ：請求データ、PM3190E※請求データ取得エラー
						this.addError(outDto, PNCommonMessageConstants.PM3190E,
								new String[] { "請求データ" });
						return outDto;
					}
				}
				if (0 == getStrLength(inDto.getDrpID_Code_Kurishojiyu())) {
					// 繰償事由コードが空白の場合
					if (0 < tmp_YakujoGankin.doubleValue()) {
						// 入力元金TMP＞０の場合、エラーとする。
						// メッセージ：PM3490E※元金有額
						// 充当順序チェック処理を抜ける
						this.addError(outDto, PNCommonMessageConstants.PM3490E,
								new String[0]);
						return outDto;
					}
				}
			}
		}
		return outDto;
	}

	/**
	 * Md004_01ServiceのgetSeikyu
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO getSeikyu(Md004_01DTO inDto) {

		Md004_01DTO outDto = inDto;

		// 請求データ存在チェック
		// 請求データの件数取得の検索条件を設定
		SeikyuEntity inEntity = new SeikyuEntity();
		// 単テーブルアクセス定義の「請求データ件数取得」を参照し、条件を設定する。
		// 債権管理番号＝請求データ検索パラメータ(債権管理番号）
		inEntity.setID_Credit(new BigDecimal(inDto.getSeikyuParam_ID_Credit()));
		// 払込期日＝請求データ検索パラメータ(払込期日）
		inEntity.setDate_Haraikomi(inDto.getSeikyuParam_Date_Haraikomi());
		// SeikyuDAO.findByCondition
		List<SeikyuEntity> outEntityList = seikyudao.findByCondition(inEntity);
		// 取得件数をＤＴＯに設定する
		// 取得件数⇒Md004_01DTO.請求データ検索結果(件数）
		outDto.setSeikyuAns_Count(outEntityList.size());
		// 取得した件数＝１件の場合、取得データをＤＴＯに設定する
		if (1 == outEntityList.size()) {
			// SeikyuEntity.約定元金⇒Md004_01DTO.請求データ検索結果(約定元金）
			outDto.setSeikyuAns_ID_M_YakujoGankin(cnvBigToStr(
					outEntityList.get(0).getM_YakujoGankin()).toString());
			// SeikyuEntity.約定利息⇒Md004_01DTO.請求データ検索結果(約定利息）
			outDto.setSeikyuAns_ID_M_YakujoRisoku(cnvBigToStr(
					outEntityList.get(0).getM_YakujoRisoku()).toString());
			// SeikyuEntity.払込期日⇒Md004_01DTO.請求データ検索結果(払込期日）
			outDto.setSeikyuParam_Date_Haraikomi(outEntityList.get(0)
					.getDate_Haraikomi());
			// SeikyuEntity.請求繰上償還元金⇒Md004_01DTO.請求データ検索結果(請求繰上償還元金）
			outDto.setSeikyuAns_ID_M_SeiKuriGankin(cnvBigToStr(outEntityList
					.get(0).getM_SeiKuriGankin()));
			// SeikyuEntity.請求繰上償還利息⇒Md004_01DTO.請求データ検索結果(請求繰上償還利息）
			outDto.setSeikyuAns_ID_M_SeiKuriRisoku(cnvBigToStr(outEntityList
					.get(0).getM_SeiKuriRisoku()));
		}
		return outDto;
	}

	/**
	 * Md004_01ServiceのgetSelectHaraidashiMaxView
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO getSelectHaraidashiMaxView(Md004_01DTO inDto) {

		Md004_01DTO outDto = inDto;
		// 払出データ存在チェック

		// 払出データの件数取得の検索条件を設定
		// 単テーブルアクセス定義の「直近払出データ取得ビュー件数取得」を参照し、条件を設定する。
		// 債権管理番号＝Md004_01DTO.直近払出データ取得ビュー検索パラメータ(債権管理番号）

		inDto.getSelectHaraidashiMaxViewParam_ID_Credit();

		SelectharaidashimaxviewEntity serchEntity_SelectharaidashimaxviewEntity = new SelectharaidashimaxviewEntity();
		serchEntity_SelectharaidashimaxviewEntity
				.setID_Credit(cnvStrToBig(inDto
						.getSelectHaraidashiMaxViewParam_ID_Credit()));
		List<SelectharaidashimaxviewEntity> outEntityList = selectharaidashimaxviewdao
				.findByCondition(serchEntity_SelectharaidashimaxviewEntity);

		// 取得件数をＤＴＯに設定する
		// 取得件数⇒Md004_01DTO.直近払出データ取得ビュー検索結果(件数）
		outDto.setSelectHaraidashiMaxViewAns_Count(outEntityList.size());

		// 取得した件数＝１件の場合

		if (1 == outEntityList.size()) {
			// Entity⇒DTOに転記
			// SelectharaidashimaxviewDAO.貸付受入金残高⇒Md004_01DTO.直近払出データ取得ビュー検索結果(貸付受入金残高）
			outDto.setSelectHaraidashiMaxViewAns_M_KashitsukeukeireZan(cnvBigToStr(
					outEntityList.get(0).getM_KashitsukeukeireZan(), ""));
		}
		return outDto;
	}

	/**
	 * Md004_01ServiceのcheckYakujo
	 *
	 * @param inDto
	 *            Md004_01DTO
	 * @return Md004_01DTO
	 */
	@Override
	public Md004_01DTO checkYakujo(Md004_01DTO inDto) {

		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		bizErrors.clear();

		Md004_01DTO outDto = inDto;

		// Md004_01DTO.入金日２⇒一時変数の入金２
		String tmp_NiyukinDay2 = inDto.getID_Date_Nyukin_Input();

		// false⇒一時変数の利息フラグ
		boolean tmp_flgRisoku = false;
		BigDecimal tmp_YakujoGankin = BigDecimal.ZERO;
		BigDecimal tmp_YakujoRisoku = BigDecimal.ZERO;

		// 約定データ存在チェック
		// 約定検索用変数の設定
		// 債権管理番号
		BigDecimal serchID_Credit = cnvStrToBig(inDto
				.getYakujoParam_ID_Credit());

		// 約定データの件数取得の検索条件を設定
		// 複数テーブルアクセス定義の「Md004_01YakujoCountDAO」を参照し、条件を設定する。
		// 単テーブルアクセス定義の「請求データ件数取得」を参照し、条件を設定する。
		// 債権管理番号＝請求データ検索パラメータ(債権管理番号）
		// 払込年月日：入金日(修正)（入力値連結）※払込年月日＜入金日(修正)（入力値連結）を検索
		long tmp_hitcount = this.getResult_YakujoCount(
				new Md004_01YakujoCountEntity(), serchID_Credit,
				inDto.getID_Date_Nyukin_Input());

		// 取得した件数＞1件の場合
		if (1 < tmp_hitcount) {
			// 前期約定日約定データ
			// 約定データを取得する
			// 複数テーブルアクセス定義の「Md004_01PreviousYakujoData2DAO」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 払込年月日：入金日(修正)（入力値連結）※払込年月日＜入金日(修正)（入力値連結）を検索
			// 先頭１件のみ取得
			// Md004_01PreviousYakujoData2DAO.findByCondition前期約定日約定データとして取得（払込年月日、約定元金、約定利息、請求繰上償還利息）
			List<Md004_01PreviousYakujoData2Entity> zenkiYakujoData = this
					.getResult_PreviousYakujoData2(
							new Md004_01PreviousYakujoData2Entity(),
							serchID_Credit, inDto.getID_Date_Nyukin_Input());
			// 前期約定日約定データ（払込期日）に対し、共通部品で営業日判定を行う。非営業日の場合、以下を行う
			if (null == pnCommonDBComponents.chkBusinessDay(zenkiYakujoData
					.get(0).getDate_Haraikomi())) {
				// 入金日(修正)（入力値連結）＝前期約定日約定データ（払込年月日）の翌営業日の場合、以下を行う
				// 前期約定日約定データ（払込期日）⇒一時変数の入金日２
				if (cnvStrToInteger(inDto.getID_Date_Nyukin_Input()) == cnvStrToInteger(getBusinessDayAgo(
						zenkiYakujoData.get(0).getDate_Haraikomi(), 1))) {
					tmp_NiyukinDay2 = zenkiYakujoData.get(0)
							.getDate_Haraikomi();
				}
			}
		}

		// 【１】入金日を含み、『調整入金日』以降の「直近の約定日」「２回目の約定日」を約定データから取得する。
		// 約定データ存在チェック
		// 複数テーブルアクセス定義の「Md004_01YakujoCount2DAO」を参照し、条件を設定する。
		// Md004_01YakujoCount2DAO.countByCondition
		// 債権管理番号：債権管理番号
		// 　　払込年月日：一時変数の入金日２　　　　　　※払込年月日≧一時変数の入金日２を検索

		// ※約定取得件数
		tmp_hitcount = this.getResult_YakujoCount2(
				new Md004_01YakujoCount2Entity(), serchID_Credit,
				tmp_NiyukinDay2);

		// 取得した件数＝０件の場合、業務エラーとする。
		if (0 == tmp_hitcount) {
			// エラーメッセージ：約定データ、PM3190E
			this.addError(outDto, PNCommonMessageConstants.PM3190E,
					new String[] { "約定データ" });
			return outDto;
		}

		// 上記のチェックでエラーとならなかった場合
		// 入金日直後の約定日データを取得
		// 約定データを取得する
		// 複数テーブルアクセス定義の「Md004_01PreviousYakujoData3DAO」を参照し、条件を設定する。
		// 債権管理番号：債権管理番号
		// 払込年月日：一時変数の入金日２ ※払込年月日≧一時変数の入金日２を検索
		// （以下はDAOで固定設定される条件）
		// 約定期日区分＝１
		// ソートキー：払込期日ASC
		// Md004_01PreviousYakujoData3DAO.findByCondition直後約定データとして取得（払込年月日、約定元金、約定利息、請求繰上償還利息）
		List<Md004_01PreviousYakujoData3Entity> chiyokugoYakujoData = this
				.getResult_PreviousYakujoData3(
						new Md004_01PreviousYakujoData3Entity(),
						serchID_Credit, tmp_NiyukinDay2);

		// 約定取得件数＞１の場合、以下を行う
		List<Md004_01PreviousYakujoData4Entity> jikaiYakujoData = new ArrayList<Md004_01PreviousYakujoData4Entity>();
		// 上記以外の場合、以下を行う
		if (1 < tmp_hitcount) {
			// 約定データを取得する
			// 複数テーブルアクセス定義の「Md004_01PreviousYakujoData4DAO」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 払込年月日：直後約定データの払込年月日※払込年月日＞直後約定データの払込年月日
			// 債権管理番号：債権管理番号
			// 払込年月日：直後約定データの払込年月日※払込年月日＞直後約定データの払込年月日
			// （以下はDAOで固定設定される条件）
			// 約定期日区分＝１
			// ソートキー：払込期日ASC
			// 次回約定日約定データとして取得（払込年月日、約定元金、約定利息、請求繰上償還利息）
			jikaiYakujoData = this.getResult_PreviousYakujoData4(
					new Md004_01PreviousYakujoData4Entity(), serchID_Credit,
					chiyokugoYakujoData.get(0).getDate_Haraikomi());
		} else {
			// "０"⇒次回約定日約定データの払込年月日
			Md004_01PreviousYakujoData4Entity tmpMd004_01PreviousYakujoData4Entity = new Md004_01PreviousYakujoData4Entity();
			tmpMd004_01PreviousYakujoData4Entity.setDate_Haraikomi("0");
			jikaiYakujoData.add(tmpMd004_01PreviousYakujoData4Entity);
		}

		// 年12回償還の場合のみ「次々回約定日」の取得
		List<Md004_01PreviousYakujoData4Entity> jikaijikaiYakujoData = new ArrayList<Md004_01PreviousYakujoData4Entity>();
		// 償還方法の下１桁＝Bの場合
		String hantei_ShokanHouhou02 = getHantei_ShokanHouhou02(inDto);
		if ("B".equals(hantei_ShokanHouhou02)) {
			// 約定取得件数＞２の場合、以下を行う※countByConditionの取得値
			// 次々回約定データとして取得（払込年月日、約定元金、約定利息、請求繰上償還利息）
			if (2 < tmp_hitcount) {
				// 約定データを取得する
				// 複数テーブルアクセス定義の「Md004_01PreviousYakujoData4DAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：次回約定データの払込年月日 ※払込年月日＞次回約定データの払込年月日
				// 先頭１件のみ取得
				jikaijikaiYakujoData = this.getResult_PreviousYakujoData4(
						new Md004_01PreviousYakujoData4Entity(),
						serchID_Credit, jikaiYakujoData.get(0)
								.getDate_Haraikomi());
			}
			// 上記以外の場合、以下を行う
			// "０"⇒次々回約定日約定データの払込年月日
			else {
				Md004_01PreviousYakujoData4Entity tmpMd004_01PreviousYakujoData4Entity_1 = new Md004_01PreviousYakujoData4Entity();
				tmpMd004_01PreviousYakujoData4Entity_1.setDate_Haraikomi("0");
				jikaijikaiYakujoData
						.add(tmpMd004_01PreviousYakujoData4Entity_1);
			}
		}

		// (償還方法の下１桁＝B、かつ、一時変数の入金日２＝直後約定データの払込年月日）、かつ、
		// (次々回約定データの払込年月日＜＞”０”かつ、償還後第1回払込期日(修正)（入力値連結）＝次々回約定データの払込年月日)の場合
		if ("B".equals(hantei_ShokanHouhou02)
				&& this.hanteiAll(
						cnvStrToInteger(tmp_NiyukinDay2) == cnvStrToInteger(chiyokugoYakujoData
								.get(0).getDate_Haraikomi()),
						0 != cnvStrToInteger(jikaijikaiYakujoData.get(0)
								.getDate_Haraikomi()),
						cnvStrToInteger(inDto
								.getDate_FirstHaraikomiAfterKuris_Input()) == cnvStrToInteger(jikaijikaiYakujoData
								.get(0).getDate_Haraikomi()))) {
			// ①入金履歴データの存在チェック―――――――――――――――――――――――――――――――――――――
			// 入金履歴データの件数取得の検索条件を設定
			// 複数テーブルアクセス定義の「Md004_01NyukinhistoryCountDAO」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 払込年月日：次々回約定データの払込年月日 ※払込年月日≧次々回約定データの払込年月日
			tmp_hitcount = this.getResult_NyukinhistoryCount(
					new Md004_01NyukinhistoryCountEntity(), serchID_Credit,
					jikaijikaiYakujoData.get(0).getDate_Haraikomi());
			// （以下はDAOで固定設定される条件）
			// 更正処理区分＝０
			// （約定元金＞０又は約定利息＞０）

			if (0 < tmp_hitcount) {
				// 取得した件数＞０の場合、エラーとする。※既に入金済
				// エラーメッセージ：PM3460E
				// エラーメッセージ：約定データ、PM3190E
				this.addError(outDto, PNCommonMessageConstants.PM3460E,
						new String[0]);
				return outDto;
			}

			// ②「直近の約定日」に対応する請求データの存在チェック――――――――――――――――――――――――――
			// 上記のチェックでエラーとならなかった場合
			// 請求データ データ取得
			// 検索条件と一致する請求データの約定元金、約定利息を取得
			// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
			// （以下はDAOで固定設定される条件）
			// 先頭１件のみ取得
			// ソートキー：払込期日ASC
			// Md004_01SeikyuDataDAO.findByCondition
			// 直後請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
			// 直後請求データ

			tmp_hitcount = this.getResult_SeikyuCount(new SeikyuEntity(),
					serchID_Credit, chiyokugoYakujoData.get(0)
							.getDate_Haraikomi());

			// 請求データが存在する場合（取得した件数＞０の場合）
			if (0 < tmp_hitcount) {
				List<Md004_01SeikyuDataEntity> chiyokugoSeikiyuData = this
						.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
								serchID_Credit, chiyokugoYakujoData.get(0)
										.getDate_Haraikomi());

				// 償還後第1回払込期日(DB取得値)＝直後請求データの払込年月日の場合
				// （※作成時に仮更新した請求データと同じ請求データを読み込んだ場合)
				if (cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(chiyokugoSeikiyuData
						.get(0).getDate_Haraikomi())) {
					// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoGankin())) {
						tmp_YakujoGankin = cnvStrToBig(inDto
								.getID_Keep_M_YakujoGankin());
					}
					// 退避約定元金が空白の場合、直後請求データの約定元金⇒一時変数の約定元金
					else {
						tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
								.get(0).getID_M_YakujoGankin());
					}
					// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoRisoku())) {
						tmp_YakujoRisoku = cnvStrToBig(inDto
								.getID_Keep_M_YakujoRisoku());
					}
					// 退避約定利息が空白の場合、直後請求データの約定利息⇒一時変数の約定利息
					else {
						tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
								.get(0).getID_M_YakujoRisoku());
					}
				}
				// 上記以外の場合、以下を行う
				else {
					// 直後請求データの約定元金⇒一時変数の約定元金
					tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
							.get(0).getID_M_YakujoGankin());
					// 直後請求データの約定利息⇒一時変数の約定利息
					tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
							.get(0).getID_M_YakujoRisoku());
				}
				// 一時変数の約定元金＜＞０または、一時変数の約定利息＜＞０の場合、エラーとする。
				// エラーメッセージ：入金日、PM3880E
				if (0 != tmp_YakujoGankin.doubleValue()
						|| 0 != tmp_YakujoRisoku.doubleValue()) {
					this.addError(outDto, PNCommonMessageConstants.PM3880E,
							new String[] { "入金日" });
					return outDto;
				}
			}
			// 請求データが存在しない場合（取得した件数＞０以外の場合）
			else {
				// 入金履歴データ存在チェック
				// 入金履歴データの件数取得の検索条件を設定
				// 単テーブルアクセス定義の「入金履歴データ件数取得」を参照し、条件を設定する。
				// （以下はDAOで固定設定される条件）
				// 更正処理区分＝０
				// 入金履歴データの件数取得の検索条件を設定
				// 複数テーブルアクセス定義の「Md004_01NyukinhistoryCountDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
				tmp_hitcount = this.getResult_NyukinhistoryCount(
						new Md004_01NyukinhistoryCountEntity(), serchID_Credit,
						chiyokugoYakujoData.get(0).getDate_Haraikomi());
				// 取得した件数＞０の場合
				if (0 < tmp_hitcount) {
					// 債権管理番号：債権管理番号
					// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 更正処理区分＝０
					// Md004_01NyukinHisSumDAO.findByCondition
					// 直後入金履歴データとして取得（約定元金計、約定利息計）
					List<Md004_01NyukinHisSumEntity> chiyokugoNiyukinHisData = this
							.getResult_NyukinHis(
									new Md004_01NyukinHisSumEntity(),
									serchID_Credit, chiyokugoYakujoData.get(0)
											.getDate_Haraikomi());
					// 約定元金・約定利息チェック
					// 直後入金履歴データの約定元金計＜＞直後約定データの約定元金または、
					// 直後入金履歴データの約定利息計＜＞直後約定データの約定利息の場合、エラーとする。
					if ((cnvNullToZeroBig(
							chiyokugoNiyukinHisData.get(0)
									.getM_YakujoGankinSum()).doubleValue() != cnvNullToZeroBig(
							chiyokugoYakujoData.get(0).getID_M_YakujoGankin())
							.doubleValue())
							|| (cnvNullToZeroBig(
									chiyokugoNiyukinHisData.get(0)
											.getM_YakujoRisokuSum())
									.doubleValue() != cnvNullToZeroBig(
									chiyokugoYakujoData.get(0)
											.getID_M_YakujoRisoku())
									.doubleValue())) {
						// エラーメッセージ：入金日、PM3190E
						this.addError(outDto, PNCommonMessageConstants.PM3880E,
								new String[] { "入金日" });
						return outDto;
					}
				}
				// 上記以外の場合、エラーとする。（取得した件数＞０以外の場合）
				else {
					// エラーメッセージ：入金履歴データ、PM3190E
					this.addError(outDto, PNCommonMessageConstants.PM3190E,
							new String[] { "入金履歴データ" });
					return outDto;
				}
			}

			// ③「次回約定日」に対応する請求データの存在チェック―――――――――――――――――――――――――――
			// 上記のチェックでエラーとならなかった場合
			// 請求データ存在チェック
			// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 払込年月日：次回約定データの払込年月日 ※払込年月日＝次回約定データの払込年月日
			// （以下はDAOで固定設定される条件）
			// 先頭１件のみ取得
			// ソートキー：払込期日ASC
			// Md004_01SeikyuDataDAO.findByCondition
			// 次回請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）

			// ■次回請求データ取得
			tmp_hitcount = this.getResult_SeikyuCount(new SeikyuEntity(),
					serchID_Credit, jikaiYakujoData.get(0).getDate_Haraikomi());

			// 請求データが存在する場合（取得した件数＞０の場合）
			if (0 < tmp_hitcount) {

				// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：次回約定データの払込年月日※払込年月日＝次回約定データの払込年月日
				// （以下はDAOで固定設定される条件）
				// 先頭１件のみ取得
				// ソートキー：払込期日　ASC
				// Md004_01SeikyuDataDAO.findByCondition
				// 次回請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
				List<Md004_01SeikyuDataEntity> jikaiSeikiyuData = this
						.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
								serchID_Credit, jikaiYakujoData.get(0)
										.getDate_Haraikomi());

				// 償還後第1回払込期日(DB取得値)＝次回請求データの払込年月日の場合
				// （※作成時に仮更新した請求データと同じ請求データを読み込んだ場合)
				BigDecimal tmp_YakujoGankin2 = BigDecimal.ZERO;
				BigDecimal tmp_YakujoRisoku2 = BigDecimal.ZERO;
				if (cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(jikaiSeikiyuData
						.get(0).getDate_Haraikomi())) {
					// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金２
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoGankin())) {
						tmp_YakujoGankin2 = cnvStrToBig(inDto
								.getID_Keep_M_YakujoGankin());
					}
					// 退避約定元金が空白の場合、次回請求データの約定元金⇒一時変数の約定元金２
					else {
						tmp_YakujoGankin2 = cnvNullToZeroBig(jikaiSeikiyuData
								.get(0).getID_M_YakujoGankin());
					}
					// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息２
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoRisoku())) {
						tmp_YakujoRisoku2 = cnvStrToBig(inDto
								.getID_Keep_M_YakujoRisoku());
					}
					// 退避約定利息が空白の場合、次回請求データの約定利息⇒一時変数の約定利息２
					else {
						tmp_YakujoRisoku2 = cnvNullToZeroBig(jikaiSeikiyuData
								.get(0).getID_M_YakujoRisoku());
					}
				}
				// 上記以外の場合、以下を行う
				else {
					// 次回請求データの約定元金⇒一時変数の約定元金２
					tmp_YakujoGankin2 = cnvNullToZeroBig(jikaiSeikiyuData
							.get(0).getID_M_YakujoGankin());
					// 次回請求データの約定利息⇒一時変数の約定利息２
					tmp_YakujoRisoku2 = cnvNullToZeroBig(jikaiSeikiyuData
							.get(0).getID_M_YakujoRisoku());
				}
				// 一時変数の約定元金＜＞０または、一時変数の約定利息＜＞０の場合、エラーとする。
				// エラーメッセージ：入金日、PM3880E
				if (0 != tmp_YakujoGankin2.doubleValue()
						|| 0 != tmp_YakujoRisoku2.doubleValue()) {
					this.addError(outDto, PNCommonMessageConstants.PM3880E,
							new String[] { "入金日" });
					return outDto;
				}
			}
			// 請求データが存在しない場合（取得した件数＞０以外の場合）
			else {
				// 入金履歴データ存在チェック
				// 入金履歴データの件数取得の検索条件を設定
				// 単テーブルアクセス定義の「入金履歴データ件数取得」を参照し、条件を設定する。
				// （以下はDAOで固定設定される条件）
				// 更正処理区分＝０
				// 入金履歴データの件数取得の検索条件を設定
				// 複数テーブルアクセス定義の「Md004_01NyukinhistoryCountDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：次回約定データの払込年月日 ※払込年月日＝次回約定データの払込年月日
				tmp_hitcount = this.getResult_NyukinhisCount(
						new NyukinhistoryEntity(), serchID_Credit,
						jikaiYakujoData.get(0).getDate_Haraikomi());
				// 取得した件数＞０の場合
				if (0 < tmp_hitcount) {
					// 債権管理番号：債権管理番号
					// 払込年月日：次回約定データの払込年月日 ※払込年月日＝次回約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 更正処理区分＝０
					// Md004_01NyukinHisSumDAO.findByCondition
					// 直後入金履歴データとして取得（約定元金計、約定利息計）
					List<Md004_01NyukinHisSumEntity> jikaiNiyukinHisData = this
							.getResult_NyukinHis(
									new Md004_01NyukinHisSumEntity(),
									serchID_Credit, jikaiYakujoData.get(0)
											.getDate_Haraikomi());
					// 約定元金・約定利息チェック
					// 次回入金履歴データの約定元金計＜＞次回約定データの約定元金または、
					// 次回入金履歴データの約定利息計＜＞次回約定データの約定利息の場合、エラーとする。
					if ((cnvNullToZeroBig(
							jikaiNiyukinHisData.get(0).getM_YakujoGankinSum())
							.doubleValue() != cnvNullToZeroBig(
							jikaiYakujoData.get(0).getID_M_YakujoGankin())
							.doubleValue())
							|| (cnvNullToZeroBig(
									jikaiNiyukinHisData.get(0)
											.getM_YakujoRisokuSum())
									.doubleValue() != cnvNullToZeroBig(
									jikaiYakujoData.get(0)
											.getID_M_YakujoRisoku())
									.doubleValue())) {
						this.addError(outDto, PNCommonMessageConstants.PM3880E,
								new String[] { "入金日" });
						return outDto;
					}
				} else {
					// 上記以外の場合、エラーとする。（取得した件数＞０以外の場合）
					// エラーメッセージ：入金履歴データ、PM3190E
					this.addError(outDto, PNCommonMessageConstants.PM3190E,
							new String[] { "入金履歴データ" });
					return outDto;
				}
			}
			// ④「次々回約定日」に対応する請求データの存在チェック――――――――――――――――――――――――――
			// 請求データ存在チェック
			// 請求データの件数取得の検索条件を設定
			// 単テーブルアクセス定義の「請求データ件数取得」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// 債権管理番号＝債権管理番号
			// 払込年月日：次々回約定データの払込年月日 ※払込年月日＝次々回約定データの払込年月日

			// 次々回請求データ

// [MOD] Ver 4.0.0 - START
//			tmp_hitcount = this.getResult_NyukinhisCount(
//					new NyukinhistoryEntity(), serchID_Credit,
//					jikaijikaiYakujoData.get(0).getDate_Haraikomi());
			tmp_hitcount = this.getResult_SeikyuCount(
					new SeikyuEntity(), serchID_Credit,
					jikaijikaiYakujoData.get(0).getDate_Haraikomi());
// [MOD] Ver 4.0.0 - END

			// SeikyuDAO.countByCondition
			// 請求データが存在する場合（取得した件数＞０の場合）
			if (0 < tmp_hitcount) {
				// 検索条件と一致する請求データの約定元金、約定利息を取得
				// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：次々回約定データの払込年月日 ※払込年月日＝次々回約定データの払込年月日
				// （以下はDAOで固定設定される条件）
				// 先頭１件のみ取得
				// ソートキー：払込期日　ASC
				// Md004_01SeikyuDataDAO.findByCondition
				// 次々回請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
				List<Md004_01SeikyuDataEntity> jikaijikaiSeikiyuData = this
						.getResult_SeikyuData(new Md004_01SeikyuDataEntity(),
								serchID_Credit, jikaijikaiYakujoData.get(0)
										.getDate_Haraikomi());

				// 償還後第1回払込期日(DB取得値)＝直後請求データの払込年月日の場合
				BigDecimal tmp_YakujoGankin3 = BigDecimal.ZERO;
				BigDecimal tmp_YakujoRisoku3 = BigDecimal.ZERO;
				// （※作成時に仮更新した請求データと同じ請求データを読み込んだ場合)
				if (cnvStrToInteger(inDto
						.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(jikaijikaiSeikiyuData
						.get(0).getDate_Haraikomi())) {
					// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金３
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoGankin())) {
						tmp_YakujoGankin3 = cnvStrToBig(inDto
								.getID_Keep_M_YakujoGankin());
					}
					// 退避約定元金が空白の場合、次々回請求データの約定元金⇒一時変数の約定元金３
					else {
						tmp_YakujoGankin3 = cnvNullToZeroBig(jikaijikaiSeikiyuData
								.get(0).getID_M_YakujoGankin());
					}
					// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息３
					if (0 != getStrLength(inDto.getID_Keep_M_YakujoRisoku())) {
						tmp_YakujoRisoku3 = cnvStrToBig(inDto
								.getID_Keep_M_YakujoRisoku());
					}
					// 退避約定利息が空白の場合、次々回請求データの約定利息⇒一時変数の約定利息３
					else {
						tmp_YakujoRisoku3 = cnvNullToZeroBig(jikaijikaiSeikiyuData
								.get(0).getID_M_YakujoRisoku());
					}
				}
				// 上記以外の場合、以下を行う
				else {
					// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息３
					tmp_YakujoGankin3 = cnvNullToZeroBig(jikaijikaiSeikiyuData
							.get(0).getID_M_YakujoGankin());
					// 退避約定利息が空白の場合、次々回請求データの約定利息⇒一時変数の約定利息３
					tmp_YakujoRisoku3 = cnvNullToZeroBig(jikaijikaiSeikiyuData
							.get(0).getID_M_YakujoRisoku());
				}
// [ADD] Ver 4.0.0 - START
				// 対象債権の実行年月日が2022/4/1以降の場合、
				// 一時変数の約定元金３＜＞次々回約定データの約定元金の場合、エラーとする。
				// 対象債権の実行年月日が2022/4/1より前の場合、
				if (PNCommonComponents.parseInt(inDto.getID_Date_Jikko_Red())
						>= PNCommonComponents.parseInt(PNCommonConstants.BASE_DATE_DEDUCT_INTEREST)) {
					if (cnvNullToZeroBig(tmp_YakujoGankin3).doubleValue() != cnvNullToZeroBig(
							jikaijikaiYakujoData.get(0).getID_M_YakujoGankin())
							.doubleValue()) {
						// エラーメッセージ：入金日、PM3880E
						this.addError(outDto, PNCommonMessageConstants.PM3880E,
								new String[] { "入金日" });
						return outDto;
					}
				}
// [ADD] Ver 4.0.0 - END
				// 一時変数の約定元金３＜＞次々回約定データの約定元金または、
				// 一時変数の約定利息３＜＞次々回約定データの約定利息の場合、エラーとする。
// [MOD] Ver 4.0.0 - START
//				if (cnvNullToZeroBig(tmp_YakujoGankin3).doubleValue() != cnvNullToZeroBig(
//						jikaijikaiYakujoData.get(0).getID_M_YakujoGankin())
//						.doubleValue()
//						|| cnvNullToZeroBig(tmp_YakujoRisoku).doubleValue() != cnvNullToZeroBig(
//								jikaijikaiYakujoData.get(0)
//										.getID_M_YakujoRisoku()).doubleValue()) {
				else if (cnvNullToZeroBig(tmp_YakujoGankin3).doubleValue() != cnvNullToZeroBig(
						jikaijikaiYakujoData.get(0).getID_M_YakujoGankin())
						.doubleValue()
						|| cnvNullToZeroBig(tmp_YakujoRisoku3).doubleValue() != cnvNullToZeroBig(
								jikaijikaiYakujoData.get(0)
								.getID_M_YakujoRisoku()).doubleValue()) {
// [MOD] Ver 4.0.0 - END
					// エラーメッセージ：入金日、PM3880E
					this.addError(outDto, PNCommonMessageConstants.PM3880E,
							new String[] { "入金日" });
					return outDto;
// [MOD] Ver 4.0.0 - START
//				} else {
//					// 一時変数の約定元金３⇒DTO.請求データ更新用約定元金
//					outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin3));
//					// 一時変数の約定利息３⇒DTO.請求データ更新用約定利息
//					outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku3));
//					// 次々回請求データの払込年月日⇒DTO.請求データ更新用払込期日
//					// True⇒DTO.請求データ更新フラグ
//					outDto.setFlgSeikyuUpdate(true);
//				}
				}
					// 一時変数の約定元金３⇒DTO.請求データ更新用約定元金
					outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin3));
					// 一時変数の約定利息３⇒DTO.請求データ更新用約定利息
					outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku3));
					// 次々回請求データの払込年月日⇒DTO.請求データ更新用払込期日
					outDto.setID_Date_Haraikomi_Seikyu(jikaijikaiYakujoData
							.get(0).getDate_Haraikomi());
					// True⇒DTO.請求データ更新フラグ
					outDto.setFlgSeikyuUpdate(true);
// [MOD] Ver 4.0.0 - END
			}
			// ⑤繰償利息情報の設定
			// 上記のチェックでエラーとならなかった場合
			// True⇒一時変数の利息フラグ
			tmp_flgRisoku = true;
		}
		// 上記以外の場合、以下を行う
		else {
			// 償還後第1回払込期日(修正)（入力値連結）＝直後約定データの払込年月日の場合
			if (cnvStrToInteger(inDto.getDate_FirstHaraikomiAfterKuris_Input()) == cnvStrToInteger(chiyokugoYakujoData
					.get(0).getDate_Haraikomi())) {
				// 償還後第1回払込期日(修正)（入力値連結）＝直後約定データの払込年月日の場合
				// ※【２】入力された「繰償後第１回払込期日」＝「直近の約定日」の場合
				// ①入金履歴データの存在チェック―――――――――――――――――――――――――――――
				// 入金履歴データ存在チェック
				// 入金履歴データの件数取得の検索条件を設定
				// 複数テーブルアクセス定義の「Md004_01NyukinhistoryCountDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：直後約定データの払込年月日※払込年月日≧直後約定データの払込年月日
				// （以下はDAOで固定設定される条件）
				// 更正処理区分＝０
				// （約定元金＞０又は約定利息＞０）
				// Md004_01NyukinhistoryCountDAO.countByCondition
				// 取得した件数＞０の場合、エラーとする。
				// エラーメッセージ：PM3460E
				if (0 < this.getResult_NyukinhistoryCount(
						new Md004_01NyukinhistoryCountEntity(), serchID_Credit,
						chiyokugoYakujoData.get(0).getDate_Haraikomi())) {
					// 取得した件数＞０の場合、エラーとする。
					// エラーメッセージ：PM3460E
					this.addError(outDto, PNCommonMessageConstants.PM3460E,
							new String[0]);
					return outDto;
				}

				// ②請求データの存在チェック―――――――――――――――――――――――――――――――
				// 上記のチェックでエラーとならなかった場合
				// 請求データの件数取得の検索条件を設定
				// 単テーブルアクセス定義の「請求データ 件数取得」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
				// SeikyuDAO.countByCondition
				// 検索条件と一致する請求データの約定元金、約定利息を取得
				// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
				// （以下はDAOで固定設定される条件）
				// 先頭１件のみ取得
				// ソートキー：払込期日 ASC
				// Md004_01SeikyuDataDAO.findByCondition
				// 直後請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
				tmp_hitcount = this.getResult_SeikyuCount(new SeikyuEntity(),
						serchID_Credit, chiyokugoYakujoData.get(0)
								.getDate_Haraikomi());

				// 請求データが存在する場合
				// 取得した件数＞０の場合
				if (0 < tmp_hitcount) {
					//
					// 検索条件と一致する請求データの約定元金、約定利息を取得
					// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 先頭１件のみ取得
					// ソートキー：払込期日　ASC
					// Md004_01SeikyuDataDAO.findByCondition
					// 直後請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
					List<Md004_01SeikyuDataEntity> chiyokugoSeikiyuData = this
							.getResult_SeikyuData(
									new Md004_01SeikyuDataEntity(),
									serchID_Credit, chiyokugoYakujoData.get(0)
											.getDate_Haraikomi());

					// 償還後第1回払込期日(DB取得値)＝直後請求データの払込年月日の場合
					if (cnvStrToInteger(inDto
							.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(chiyokugoSeikiyuData
							.get(0).getDate_Haraikomi())) {
						// ※作成時に仮更新した請求データと同じ請求データを読み込んだ場合
						// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金
						if (0 != getStrLength(inDto.getID_Keep_M_YakujoGankin())) {
							tmp_YakujoGankin = cnvStrToBig(inDto
									.getID_Keep_M_YakujoGankin());
						} else {
							// 退避約定元金が空白の場合、直後請求データの約定元金⇒一時変数の約定元金
							tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
									.get(0).getID_M_YakujoGankin());
						}
						// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息
						if (0 != getStrLength(inDto.getID_Keep_M_YakujoRisoku())) {
							tmp_YakujoRisoku = cnvStrToBig(inDto
									.getID_Keep_M_YakujoRisoku());
						}
						// 退避約定利息が空白の場合、直後請求データの約定利息⇒一時変数の約定利息
						else {
							tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
									.get(0).getID_M_YakujoRisoku());
						}
					}
					// 上記以外の場合、以下を行う
					else {
						// 直後請求データの約定元金⇒一時変数の約定元金
						tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
								.get(0).getID_M_YakujoGankin());
						// 直後請求データの約定利息⇒一時変数の約定利息
						tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
								.get(0).getID_M_YakujoRisoku());
					}
// [ADD] Ver 4.0.0 - START
					// 対象債権の実行年月日が2022/4/1以降の場合、
					// 一時変数の約定元金＜＞直後約定データの約定元金の場合、エラーとする。
					if(PNCommonComponents.parseInt(inDto.getID_Date_Jikko_Red())
							>= PNCommonComponents.parseInt(PNCommonConstants.BASE_DATE_DEDUCT_INTEREST)) {
						if (cnvNullToZeroBig(tmp_YakujoGankin).doubleValue() != cnvNullToZeroBig(
								chiyokugoYakujoData.get(0).getID_M_YakujoGankin())
								.doubleValue()) {
							// エラーメッセージ：入金日、PM3880E
							this.addError(outDto, PNCommonMessageConstants.PM3880E,
									new String[] { "入金日" });
							return outDto;
						}
					}
// [ADD] Ver 4.0.0 - END
					// 一時変数の約定元金＜＞直後約定データの約定元金または、
					// 一時変数の約定利息＜＞直後約定データの約定利息の場合、エラーとする。
// [MOD] Ver 4.0.0 - START
//					if (cnvNullToZeroBig(tmp_YakujoGankin).doubleValue() != cnvNullToZeroBig(
//							chiyokugoYakujoData.get(0).getID_M_YakujoGankin())
//							.doubleValue()
//							|| cnvNullToZeroBig(tmp_YakujoRisoku).doubleValue() != cnvNullToZeroBig(
//									chiyokugoYakujoData.get(0)
//											.getID_M_YakujoRisoku())
//									.doubleValue()) {

					else if (cnvNullToZeroBig(tmp_YakujoGankin).doubleValue() != cnvNullToZeroBig(
								chiyokugoYakujoData.get(0).getID_M_YakujoGankin())
								.doubleValue()
								|| cnvNullToZeroBig(tmp_YakujoRisoku).doubleValue() != cnvNullToZeroBig(
										chiyokugoYakujoData.get(0)
												.getID_M_YakujoRisoku())
										.doubleValue()) {
// [MOD] Ver 4.0.0 - END
							// エラーメッセージ：入金日、PM3880E
							this.addError(outDto, PNCommonMessageConstants.PM3880E,
									new String[] { "入金日" });
							return outDto;
// [MOD] Ver 4.0.0 - START
//					} else {
//						// 上記以外の場合
//						// 一時変数の約定元金⇒DTO.請求データ更新用約定元金
//						outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin));
//						// 一時変数の約定利息⇒DTO.請求データ更新用約定利息
//						outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku));
//						// 直後請求データの払込年月日⇒DTO.請求データ更新用払込期日
//						outDto.setID_Date_Haraikomi_Seikyu(chiyokugoSeikiyuData
//								.get(0).getDate_Haraikomi());
//						// True⇒DTO.請求データ更新フラグ
//						outDto.setFlgSeikyuUpdate(true);
//					}
					}
							// 上記以外の場合
							// 一時変数の約定元金⇒DTO.請求データ更新用約定元金
							outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin));
							// 一時変数の約定利息⇒DTO.請求データ更新用約定利息
							outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku));
							// 直後請求データの払込年月日⇒DTO.請求データ更新用払込期日
							outDto.setID_Date_Haraikomi_Seikyu(chiyokugoSeikiyuData
									.get(0).getDate_Haraikomi());
							// True⇒DTO.請求データ更新フラグ
							outDto.setFlgSeikyuUpdate(true);
// [MOD] Ver 4.0.0 - END
				}
			}
			// 上記以外の場合 (償還後第1回払込期日(修正)（入力値連結）＝直後約定データの払込年月日でない場合)
			else {
				// 次回約定データの払込年月日が０以外、かつ、償還後第1回払込期日(修正)（入力値連結）＝次回約定データの払込年月日の場合
				// ※【３】入力された「繰償後第１回払込期日」＝「２回目の約定日」の場合
				if (!"0".equals(PNCommonComponents
						.cnvNulltoZero(jikaiYakujoData.get(0)
								.getDate_Haraikomi()))
						&& cnvStrToInteger(inDto
								.getDate_FirstHaraikomiAfterKuris_Input()) == cnvStrToInteger(jikaiYakujoData
								.get(0).getDate_Haraikomi())) {

					// ①入金履歴データの存在チェック
					// 入金履歴データ存在チェック
					// 入金履歴データの件数取得の検索条件を設定
					// 複数テーブルアクセス定義の「Md004_01NyukinhistoryCountDAO」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：次回約定データの払込年月日※払込年月日≧次回約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 更正処理区分＝０
					// （約定元金＞０又は約定利息＞０）
					// Md004_01NyukinhistoryCountDAO.countByCondition
					if (0 < this.getResult_NyukinhistoryCount(
							new Md004_01NyukinhistoryCountEntity(),
							serchID_Credit, jikaiYakujoData.get(0)
									.getDate_Haraikomi())) {
						// 取得した件数＞０の場合、エラーとする。※既に入金済の場合
						// エラーメッセージ：PM3460E
						this.addError(outDto, PNCommonMessageConstants.PM3460E,
								new String[0]);
						return outDto;
					}

					// ②「直近の約定日」に対応する請求データの存在チェック――――――――――――――
					// 上記のチェックでエラーとならなかった場合
					// 請求データ存在チェック
					// 請求データの件数取得の検索条件を設定
					// 単テーブルアクセス定義の「請求データ件数取得」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：直後約定データの払込年月日※払込年月日＝直後約定データの払込年月日
					// SeikyuDAO.countByCondition
					// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：直後約定データの払込年月日※払込年月日＝直後約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 先頭１件のみ取得
					// ソートキー：払込期日ASC
					// Md004_01SeikyuDataDAO.findByCondition
					// 直後請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
					tmp_hitcount = this.getResult_SeikyuCount(
							new SeikyuEntity(), serchID_Credit,
							chiyokugoYakujoData.get(0).getDate_Haraikomi());

					// 請求データが存在する場合（取得した件数＞０の場合）
					if (0 < tmp_hitcount) {
						// 検索条件と一致する請求データの約定元金、約定利息を取得
						// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
						// 債権管理番号：債権管理番号
						// 払込年月日：直後約定データの払込年月日 ※払込年月日＝直後約定データの払込年月日
						// Md004_01SeikyuDataDAO.findByCondition
						// 直後請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
						List<Md004_01SeikyuDataEntity> chiyokugoSeikiyuData = this
								.getResult_SeikyuData(
										new Md004_01SeikyuDataEntity(),
										serchID_Credit, chiyokugoYakujoData
												.get(0).getDate_Haraikomi());

						// 償還後第1回払込期日(DB取得値)＝直後請求データの払込年月日の場合
						if (cnvStrToInteger(inDto
								.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(chiyokugoSeikiyuData
								.get(0).getDate_Haraikomi())) {
							// ※作成時に仮更新した請求データと同じ請求データを読み込んだ場合
							// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金
							if (0 != getStrLength(inDto
									.getID_Keep_M_YakujoGankin())) {
								tmp_YakujoGankin = cnvStrToBig(inDto
										.getID_Keep_M_YakujoGankin());
							}
							// 退避約定元金が空白の場合、直後請求データの約定元金⇒一時変数の約定元金
							else {
								tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
										.get(0).getID_M_YakujoGankin());
							}
							// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息
							if (0 != getStrLength(inDto
									.getID_Keep_M_YakujoRisoku())) {
								tmp_YakujoRisoku = cnvStrToBig(inDto
										.getID_Keep_M_YakujoRisoku());
							}
							// 退避約定利息が空白の場合、直後請求データの約定利息⇒一時変数の約定利息
							else {
								tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
										.get(0).getID_M_YakujoRisoku());
							}
						}
						// 上記以外の場合、以下を行う
						else {
							// 直後請求データの約定元金⇒一時変数の約定元金
							tmp_YakujoGankin = cnvNullToZeroBig(chiyokugoSeikiyuData
									.get(0).getID_M_YakujoGankin());
							// 直後請求データの約定利息⇒一時変数の約定利息
							tmp_YakujoRisoku = cnvNullToZeroBig(chiyokugoSeikiyuData
									.get(0).getID_M_YakujoRisoku());
						}
						// 一時変数の約定元金＜＞０または、一時変数の約定利息＜＞０の場合、エラーとする。
						if (0 != cnvNullToZeroBig(tmp_YakujoGankin)
								.doubleValue()
								|| 0 != cnvNullToZeroBig(tmp_YakujoRisoku)
										.doubleValue()) {
							// エラーメッセージ：入金日、PM3880E
							this.addError(outDto,
									PNCommonMessageConstants.PM3880E,
									new String[] { "入金日" });
							return outDto;
						}
					}
					// 請求データが存在しない場合
					else {
						// 入金履歴データ存在チェック
						// 入金履歴データの件数取得の検索条件を設定
						// 単テーブルアクセス定義の「入金履歴データ件数取得」を参照し、条件を設定する。
						// 債権管理番号：債権管理番号
						// 払込年月日：直後約定データの払込年月日※払込年月日＝直後約定データの払込年月日
						// （以下はDAOで固定設定される条件）
						// 更正処理区分＝０
						// NyukinhistoryDAO.countByCondition

						tmp_hitcount = this.getResult_NyukinhistoryCount(
								new Md004_01NyukinhistoryCountEntity(),
								serchID_Credit, chiyokugoYakujoData.get(0)
										.getDate_Haraikomi());
						// 取得件数＞０の場合
						// 検索条件と一致する入金履歴データの約定元金合計、約定利息合計を取得

						if (0 < tmp_hitcount) {
							List<Md004_01NyukinHisSumEntity> chiyokugoNiyukinHisData = this
									.getResult_NyukinHis(
											new Md004_01NyukinHisSumEntity(),
											serchID_Credit, chiyokugoYakujoData
													.get(0).getDate_Haraikomi());
							// 直後入金履歴データの約定元金計＜＞直後約定データの約定元金または、
							// 直後入金履歴データの約定利息計＜＞直後約定データの約定利息の場合、エラーとする。
							if ((cnvNullToZeroBig(
									chiyokugoNiyukinHisData.get(0)
											.getM_YakujoGankinSum())
									.doubleValue() != cnvNullToZeroBig(
									chiyokugoYakujoData.get(0)
											.getID_M_YakujoGankin())
									.doubleValue())
									|| (cnvNullToZeroBig(
											chiyokugoNiyukinHisData.get(0)
													.getM_YakujoRisokuSum())
											.doubleValue() != cnvNullToZeroBig(
											chiyokugoYakujoData.get(0)
													.getID_M_YakujoRisoku())
											.doubleValue())) {
								// エラーメッセージ：入金日、PM3880E
								this.addError(outDto,
										PNCommonMessageConstants.PM3880E,
										new String[] { "入金日" });
								return outDto;
							}
						}
						// /上記以外の場合、エラーとする。（取得した件数＞０以外の場合）
						else {
							this.addError(outDto,
									PNCommonMessageConstants.PM3190E,
									new String[] { "入金履歴データ" });
							return outDto;
						}
					}

					// ③請求データの存在チェック２――――――――――――――――――――――――――
					// 上記のチェックでエラーとならなかった場合
					// 請求データが存在する場合(取得した件数＞０の場合)
					// 検索条件と一致する請求データの約定元金、約定利息を取得
					// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：次回約定データの払込年月日※払込年月日＝次回約定データの払込年月日
					// （以下はDAOで固定設定される条件）
					// 先頭１件のみ取得
					// ソートキー：払込期日ASC
					// Md004_01SeikyuDataDAO.findByCondition
					// 次回請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）

					tmp_hitcount = this.getResult_SeikyuCount(
							new SeikyuEntity(), serchID_Credit, jikaiYakujoData
									.get(0).getDate_Haraikomi());

					if (0 < tmp_hitcount) {
						// 請求データが存在する場合(取得した件数＞０の場合)
						// 検索条件と一致する請求データの約定元金、約定利息を取得
						// 複数テーブルアクセス定義の「Md004_01SeikyuDataDAO」を参照し、条件を設定する。
						// 債権管理番号：債権管理番号
						// 払込年月日：次回約定データの払込年月日 ※払込年月日＝次回約定データの払込年月日
						// （以下はDAOで固定設定される条件）
						// 先頭１件のみ取得
						// ソートキー：払込期日　ASC
						// Md004_01SeikyuDataDAO.findByCondition
						// 次回請求データとして取得（払込年月日、約定元金、約定利息、請求繰上償還元金、請求繰上償還利息、任意繰上償還利息）
						List<Md004_01SeikyuDataEntity> jikaiSeikiyuData = this
								.getResult_SeikyuData(
										new Md004_01SeikyuDataEntity(),
										serchID_Credit, jikaiYakujoData.get(0)
												.getDate_Haraikomi());
						BigDecimal tmp_YakujoGankin2 = BigDecimal.ZERO;
						BigDecimal tmp_YakujoRisoku2 = BigDecimal.ZERO;
						// 償還後第1回払込期日(DB取得値)＝直後請求データの払込年月日の場合
						if (cnvStrToInteger(inDto
								.getDate_FirstHaraikomiAfterKuris_Save()) == cnvStrToInteger(jikaiSeikiyuData
								.get(0).getDate_Haraikomi())) {
							// ※作成時に仮更新した請求データと同じ請求データを読み込んだ場合
							// 退避約定元金が空白以外の場合、退避約定元金⇒一時変数の約定元金２
							if (0 != getStrLength(inDto
									.getID_Keep_M_YakujoGankin())) {
								tmp_YakujoGankin2 = cnvStrToBig(inDto
										.getID_Keep_M_YakujoGankin());
							}
							// 退避約定元金が空白の場合、直後請求データの約定元金⇒一時変数の約定元金2
							else {
								tmp_YakujoGankin2 = cnvNullToZeroBig(jikaiSeikiyuData
										.get(0).getID_M_YakujoGankin());
							}
							// 退避約定利息が空白以外の場合、退避約定利息⇒一時変数の約定利息2
							if (0 != getStrLength(inDto
									.getID_Keep_M_YakujoRisoku())) {
								tmp_YakujoRisoku2 = cnvStrToBig(inDto
										.getID_Keep_M_YakujoRisoku());
							}
							// 退避約定利息が空白の場合、直後請求データの約定利息⇒一時変数の約定利息2
							else {
								tmp_YakujoRisoku2 = cnvNullToZeroBig(jikaiSeikiyuData
										.get(0).getID_M_YakujoRisoku());
							}
						}
						// 上記以外の場合、以下を行う
						else {
							// 直後請求データの約定元金⇒一時変数の約定元金2
							tmp_YakujoGankin2 = cnvNullToZeroBig(jikaiSeikiyuData
									.get(0).getID_M_YakujoGankin());
							// 直後請求データの約定利息⇒一時変数の約定利息2
							tmp_YakujoRisoku2 = cnvNullToZeroBig(jikaiSeikiyuData
									.get(0).getID_M_YakujoRisoku());
						}

// [ADD] Ver 4.0.0 - START
						// 対象債権の実行年月日が2022/4/1以降の場合、
						// 一時変数の約定元金２＜＞次回約定データの約定元金の場合、エラーとする。
						if(PNCommonComponents.parseInt(inDto.getID_Date_Jikko_Red())
								>= PNCommonComponents.parseInt(PNCommonConstants.BASE_DATE_DEDUCT_INTEREST)){
							if ((cnvNullToZeroBig(tmp_YakujoGankin2).doubleValue() != cnvNullToZeroBig(
									jikaiYakujoData.get(0).getID_M_YakujoGankin())
									.doubleValue())) {
								// エラーメッセージ：入金日、PM3880E
								this.addError(outDto,
										PNCommonMessageConstants.PM3880E,
										new String[] { "入金日" });
								return outDto;
							}
						}
// [ADD] Ver 4.0.0 - END
						// 一時変数の約定元金２＜＞次回約定データの約定元金または、
						// 一時変数の約定利息２＜＞次回約定データの.約定利息の場合、エラーとする。
// [MOD] Ver 4.0.0 - START
//						if ((cnvNullToZeroBig(tmp_YakujoGankin2).doubleValue() != cnvNullToZeroBig(
//								jikaiYakujoData.get(0).getID_M_YakujoGankin())
//								.doubleValue())
//								|| (cnvNullToZeroBig(tmp_YakujoRisoku2)
//										.doubleValue() != cnvNullToZeroBig(
//										jikaiYakujoData.get(0)
//												.getID_M_YakujoRisoku())
//										.doubleValue())) {

						else if ((cnvNullToZeroBig(tmp_YakujoGankin2).doubleValue() != cnvNullToZeroBig(
								jikaiYakujoData.get(0).getID_M_YakujoGankin())
								.doubleValue())
								|| (cnvNullToZeroBig(tmp_YakujoRisoku2)
										.doubleValue() != cnvNullToZeroBig(
										jikaiYakujoData.get(0)
												.getID_M_YakujoRisoku())
										.doubleValue())) {
// [MOD] Ver 4.0.0 - END
							// エラーメッセージ：入金日、PM3880E
							this.addError(outDto,
									PNCommonMessageConstants.PM3880E,
									new String[] { "入金日" });
							return outDto;
						}
// [MOD] Ver 4.0.0 - START
//						// 上記以外の場合
//						else {
//							// 一時変数の約定元金２⇒DTO.請求データ更新用約定元金
//							// 一時変数の約定利息２⇒DTO.請求データ更新用約定利息
//							// 次回請求データの払込年月日⇒DTO.請求データ更新用払込期日
//							// True⇒請求データ有無フラグ
//							outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin2));
//							outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku2));
//							outDto.setID_Date_Haraikomi_Seikyu(jikaiSeikiyuData
//									.get(0).getDate_Haraikomi());
//							outDto.setFlgSeikyuUpdate(true);
//						}
						// 一時変数の約定元金２⇒DTO.請求データ更新用約定元金
						// 一時変数の約定利息２⇒DTO.請求データ更新用約定利息
						// 次回請求データの払込年月日⇒DTO.請求データ更新用払込期日
						// True⇒請求データ有無フラグ
						outDto.setID_M_YakujoGankin_Seikyu(cnvBigToStr(tmp_YakujoGankin2));
						outDto.setID_M_YakujoRisoku_Seikyu(cnvBigToStr(tmp_YakujoRisoku2));
						outDto.setID_Date_Haraikomi_Seikyu(jikaiSeikiyuData
								.get(0).getDate_Haraikomi());
						outDto.setFlgSeikyuUpdate(true);
// [MOD] Ver 4.0.0 - END
					}

					// ④１ヶ月以内入金日チェック
					// 上記のチェックでエラーとならなかった場合
					// 直後約定データの払込年月日の１ヶ月前⇒１ヶ月前払込年月日TMP領域
					// １ヶ月前払込年月日TMP領域＞入金日(修正)（入力値連結）の場合、エラーとする。
					// エラーメッセージ：PM3890E
					String tmpOneMonthago = "";
					tmpOneMonthago = getDayMonthAgo(chiyokugoYakujoData.get(0)
							.getDate_Haraikomi(), -1);
					if (cnvStrToInteger(tmpOneMonthago) > cnvStrToInteger(inDto
							.getID_Date_Nyukin_Input())) {
						// エラーメッセージ：PM3890E
						this.addError(outDto, PNCommonMessageConstants.PM3890E,
								new String[] { "入金日" });
						return outDto;
					}
					// ⑤繰償利息情報の設定
					// 上記のチェックでエラーとならなかった場合
					else {
						// True⇒一時変数の利息フラグ
						tmp_flgRisoku = true;
					}
				}
				// 上記以外の場合、エラーとする
				else {
					// ※【４】入力された「繰償後第１回払込期日」≠「直近の約定日」and≠「２回目の約定日」の場合、「繰償後第１回払込期日エラー」とする。
					// エラーメッセージ：繰償後第１回払込期日、PM3880E
					// エラーメッセージ：入金日、PM3880E
					this.addError(outDto, PNCommonMessageConstants.PM3880E,
							new String[] { "入金日" });
					return outDto;
				}
			}
		}

		// 利息チェック
		// 一時変数の利息フラグ＝Falseの場合
		if (!tmp_flgRisoku) {
			// 一時変数の償還利息＝０
			BigDecimal tmpKurishoRisoku = BigDecimal.ZERO;

			// 利率＝０以外、かつ、元金が空白以外の場合
			if (0 != BigDecimal.ZERO.compareTo(cnvStrToBig(inDto
					.getID_Riritsu_aRingi()))
					&& 0 != getStrLength(inDto.getTxtID_M_KurishoGankin())) {

				// 約定データ存在チェック
				// 約定データの件数取得の検索条件を設定
				// 複数テーブルアクセス定義の「Md004_01YakujoCount3DAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// 払込年月日：償還後第1回払込期日(修正)（入力値連結）※払込年月日＜償還後第1回払込期日(修正)（入力値連結）
				// （以下はDAOで固定設定される条件）
				// 約定期日区分＝１
				// Md004_01PreviousYakujoData2DAO.countByCondition
				tmp_hitcount = getResult_YakujoCount(
						new Md004_01YakujoCountEntity(), serchID_Credit,
						PNCommonComponents.cnvNulltoBlank(inDto
								.getDate_FirstHaraikomiAfterKuris_Input()));

				List<Md004_01PreviousYakujoData2Entity> shiyoukanAfterHaraikomiYakujoData = new ArrayList<Md004_01PreviousYakujoData2Entity>();
				// 取得した件数＞０の場合
				if (0 < tmp_hitcount) {
					// 検索条件と一致する約定データの約定元金、約定利息を取得
					// 複数テーブルアクセス定義の「Md004_01PreviousYakujoData2DAO」を参照し、条件を設定する。
					// 債権管理番号：債権管理番号
					// 払込年月日：償還後第1回払込期日(修正)（入力値連結）※払込年月日＜償還後第1回払込期日(修正)（入力値連結）
					// （以下はDAOで固定設定される条件）
					// 約定期日区分＝１
					// ソートキー：払込期日　DESC
					// 先頭１件のみ取得
					// Md004_01PreviousYakujoData2DAO.findByCondition
					// 償還後第1回払込期日約定データとして取得（払込年月日、約定元金、約定利息、請求繰上償還利息）
					shiyoukanAfterHaraikomiYakujoData = getResult_PreviousYakujoData2(
							new Md004_01PreviousYakujoData2Entity(),
							serchID_Credit,
							PNCommonComponents.cnvNulltoBlank(inDto
									.getDate_FirstHaraikomiAfterKuris_Input()));
				}

				// 繰償利息を求める
				// == 引数の設定 ==
				// ◇繰上償還額(報告書の「(繰上償還)元金」)
				// 引数の繰上償還額＝元金
				BigDecimal payBackAmount = cnvStrToBig(inDto
						.getTxtID_M_KurishoGankin());
				// ◇起算日(報告書の「入金日」(含む)の直前の約定日の翌日。
				// 引数の起算日
				Date reckoningBaseDate = null;
				// 取得したデータの件数＝０の場合
				// 引数の起算日＝貸付実行日
				if (0 == tmp_hitcount) {
					reckoningBaseDate = PNDateUtils.toDate(
							inDto.getID_Date_Jikko(), "yyyyMMdd");
				}
				// 取得したデータの件数＝０以外の場合
				else {
					// 引数の起算日＝償還後第1回払込期日約定データの払込年月日の翌日
					reckoningBaseDate = PNDateUtils.toDate(
							getDayDayAgo(
									shiyoukanAfterHaraikomiYakujoData.get(0)
											.getDate_Haraikomi(), 1),
							"yyyyMMdd");
				}
				// ◇精算日(報告書の「入金日」)
				Date settleDay = null;
				// 引数の精算日＝入金日(修正)（入力値連結）
				settleDay = PNDateUtils.toDate(inDto.getID_Date_Nyukin_Input(),
						"yyyyMMdd");
				// ◇利率(扱店別稟議データの値)
				// 引数の利率＝利率(修正)
				String interestRateK = cnvStrToBig(inDto.getID_Riritsu_aRingi())
						.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE)
						.setScale(0, BigDecimal.ROUND_DOWN).toString();
				// ◇特利(扱店別稟議データの値)
				// 引数の特利＝特利(修正)
				String specialInterestRateK = cnvStrToBig(
						inDto.getID_Tokuri_aRingi())
						.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE)
						.setScale(0, BigDecimal.ROUND_DOWN).toString();
				// ◇特利有効期限(扱店別稟議データの値。設定されていない場合には、設定なし)
				Date specialPeriod = null;
				// 特利有効期限が空白以外の場合
				if (0 != PNCommonComponents.cnvNulltoBlank(
						inDto.getID_Date_TokuriYuko_aRingi()).length()) {
					// 引数の特利有効期限＝特利有効期限(修正)
					specialPeriod = PNDateUtils.toDate(
							inDto.getID_Date_TokuriYuko_aRingi(), "yyyyMMdd");
				} else {
					// 特利有効期限が空白の場合
					// 引数の特利有効期限＝null
					specialPeriod = null;
				}
				// ◇償還方法コード(扱店別稟議データの値)
				// 引数の償還方法＝償還方法(修正)
				String yearlyRepaymentCode = PNCommonComponents
						.cnvNulltoBlank(inDto.getID_Code_ShokanHouhou());
				// 引数：繰上償還額・起算日・精算日・利率・特利・特利有効年月日・償還方法コード
				// 繰上償還利息計算(共通部品)から、繰償利息を求める。⇒一時変数の償還利息
				tmpKurishoRisoku = PNKeisanKurishoRisoku.getKurishoRisoku(
						payBackAmount, reckoningBaseDate, settleDay,
						interestRateK, specialInterestRateK, specialPeriod,
						yearlyRepaymentCode);
			}
			if (0 > tmpKurishoRisoku.doubleValue()) {
				this.addError(outDto, PNCommonMessageConstants.PM3200E,
						new String[] { "繰上償還利息の計算に失敗し、利息" });
				return outDto;
			}
			// 一時変数の償還利息＜０以外の場合
			else {
				BigDecimal tmpRisoku = BigDecimal.ZERO;
				// 利息(円)（修正）が空白の場合
				if (0 == getStrLength(inDto.getTxtID_M_KurishoRisoku())) {
					// ０⇒一時変数の利息
					tmpRisoku = BigDecimal.ZERO;
				}
				// 上記以外の場合、
				else {
					// 利息(円)（修正）⇒一時変数の利息
					tmpRisoku = cnvStrToBig(inDto.getTxtID_M_KurishoRisoku());
				}
				// 一時変数の償還利息＜一時変数の利息の場合、エラーとする。
				if (tmpKurishoRisoku.doubleValue() < tmpRisoku.doubleValue()) {
					// エラーメッセージ：利息が元金から算出された金額、PM3180E
					this.addError(outDto, PNCommonMessageConstants.PM3180E,
							new String[] { "利息が元金から算出された金額" });
					return outDto;
				}
			}
		}
		// 利息フラグ＝Trueの場合
		// 利息(円)（修正）＜＞空文字かつ、利息(円)（修正）＜＞０の場合、エラーとする。
		// エラーメッセージ：PM3480E
		if (tmp_flgRisoku) {
			if (0 != cnvStrToBig(inDto.getTxtID_M_KurishoRisoku())
					.doubleValue()) {
				// エラーメッセージ：PM3480E
				this.addError(outDto, PNCommonMessageConstants.PM3480E,
						new String[0]);
				return outDto;
			}
		}

		// 元金チェック
		// 元金(円)（修正）＝０の場合、エラーとする。
		if (0 == cnvStrToBig(inDto.getTxtID_M_KurishoGankin()).doubleValue()) {
			// メッセージ：元金が、PM3210E
			this.addError(outDto, PNCommonMessageConstants.PM3210E,
					new String[] { "元金" });
			return outDto;
		}
		// 上記のチェックでエラーとならなかった場合
		else {
			// 払出データ存在チェック
			// 約定データの件数取得の検索条件を設定
			// 単テーブルアクセス定義の「直近払出データ取得ビュー件数取得」を参照し、条件を設定する。
			// 債権管理番号：債権管理番号
			// SelectharaidashimaxviewDAO.countByCondition
			// 払出データ
			List<Md004_01HaraidashiDataEntity> haraidashiData = new ArrayList<Md004_01HaraidashiDataEntity>();
			// 取得した件数＝１の場合
			if (1 == this.getResult_Selectharaidashimaxview(
					new SelectharaidashimaxviewEntity(), serchID_Credit)) {
				// 払出データ取得
				// 複数テーブルアクセス定義の「Md004_01HaraidashiDataDAO」を参照し、条件を設定する。
				// 債権管理番号：債権管理番号
				// Md004_01HaraidashiDataDAO.findByCondition※払出データとして取得（貸付受入金残高）
				haraidashiData = this.getResult_HaraidashiData(
						new Md004_01HaraidashiDataEntity(), serchID_Credit);

				outDto.setID_M_KashitsukeUkeire(cnvBigToStr(haraidashiData.get(
						0).getID_M_KashitsukeukeireZan()));
			}
			// 取得した件数＝１件以外の場合、エラーとする。
			// 　　 エラーメッセージ：払出データ、PM3190E
			else {
				this.addError(outDto, PNCommonMessageConstants.PM3190E,
						new String[] { "払出データ" });
				return outDto;
			}

			// 一時変数の差額
			BigDecimal tmpSagaku = BigDecimal.ZERO;

			if (0 != getStrLength(inDto.getID_M_KashitsukeZandaka_aRingi())) {
				// 退避貸付残高(修正)が空白以外の場合、一時変数の差額＝退避貸付残高(修正)－払出データの貸付受入金残高
				tmpSagaku = cnvStrToBig(inDto.getID_Keep_M_KashitsukeZan())
						.subtract(
								haraidashiData.get(0)
										.getID_M_KashitsukeukeireZan());
			} else {
				// 退避貸付残高(修正)が空白の場合、一時変数の差額＝貸付残高(修正)－払出データの貸付受入金残高
				tmpSagaku = cnvStrToBig(
						inDto.getID_M_KashitsukeZandaka_aRingi()).subtract(
						haraidashiData.get(0).getID_M_KashitsukeukeireZan());
			}

			if (tmpSagaku.doubleValue() < cnvStrToBig(
					inDto.getTxtID_M_KurishoGankin()).doubleValue()) {
				// 一時変数の差額＜元金(円)（修正）の場合、エラーとする。
				// エラーメッセージ：貸付金残高－貸付受入金残高≧元金、PM3140E
				this.addError(outDto, PNCommonMessageConstants.PM3140E,
						new String[] { "貸付金残高－貸付受入金残高≧元金" });
				return outDto;
			}
		}
		// 一時変数の貸付残高
		BigDecimal tmp_KashitukeZan = BigDecimal.ZERO;
		//
		// 繰償事由コードチェック
		// 退避貸付残高(修正)が空白以外の場合、一時変数の貸付残高＝退避貸付残高(修正)
		if (0 != getStrLength(inDto.getID_M_KashitsukeZandaka_aRingi())) {
			tmp_KashitukeZan = cnvStrToBig(inDto.getID_Keep_M_KashitsukeZan());
		} else {
			// 退避貸付残高が空白の場合、一時変数の貸付残高＝貸付残高(修正)
			tmp_KashitukeZan = cnvStrToBig(inDto
					.getID_M_KashitsukeZandaka_aRingi());
		}

		String hantei_KurishojiyuStr01 = getHantei_KurishojiyuStr01(inDto);
		// 一時変数の貸付残高＝元金(円)（修正）かつ、償還方法コードの上１桁＜＞３の場合
		String hantei_ShokanHouhou01 = getHantei_ShokanHouhou01(inDto);
		if (tmp_KashitukeZan.doubleValue() == cnvStrToBig(
				inDto.getTxtID_M_KurishoGankin()).doubleValue()
				&& !"3".equals(hantei_ShokanHouhou01)) {
			// 繰償事由コードの上１桁＜＞３かつ、繰償事由コードの上１桁＜＞６の場合、エラーとする。
			if (!"3".equals(hantei_KurishojiyuStr01)
					&& !"6".equals(hantei_KurishojiyuStr01)) {
				// エラーメッセージ：繰償事由コードは期限短縮、PM3140E
				this.addError(outDto, PNCommonMessageConstants.PM3140E,
						new String[] { "繰償事由コードは期限短縮" });
				return outDto;
			}
		}

		// 償還方法コードの上１桁＝３かつ、一時変数の貸付残高＜＞元金(円)（修正）の場合
		if ("3".equals(hantei_ShokanHouhou01)
				&& tmp_KashitukeZan.doubleValue() != cnvStrToBig(
						inDto.getTxtID_M_KurishoGankin()).doubleValue()) {
			// 繰償事由コードの上１桁＜＞１かつ，繰償事由コードの上１桁＜＞５の場合、エラーとする。
			if (!"1".equals(hantei_KurishojiyuStr01)
					&& !"5".equals(hantei_KurishojiyuStr01)) {
				this.addError(outDto, PNCommonMessageConstants.PM3140E,
						new String[] { "繰償事由コードは期限固定" });
				return outDto;
			}
		}

		return outDto;
	}

	/**
	 *
	 * <pre>
	 * 画面別エラーの追記
	 * </pre>
	 *
	 * @param messageId
	 * @param parameter
	 */
	private void addError(Md004_01DTO inDto, String messageId,
			String[] parameter) {
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		bizErrors.add(new PNMessageInfo(messageId, parameter, false));
		inDto.setBizErrors(bizErrors);
	}

	/**
	 *
	 * <pre>
	 * ０が渡されたときに空白にします。
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	private String cnvZeroToBlank(String param) {
		if (null == param || 0 == param.length() || "0".equals(param)) {
			return "";
		}
		return param;
	}

	/**
	 *
	 * <pre>
	 * 分解用西暦登録
	 * </pre>
	 *
	 * @param seireki
	 */
	private List<String> parseSeireki(String param) {
		List<String> parseSeireki = new ArrayList<String>();
// [UPD] Ver 2.0.0 - START
//		String parseGengo = "";
		String parseGengo = PNCommonComponents.getInitgengo();
// [UPD] Ver 2.0.0 - END
		String parseYear = "";
		String parseMonth = "";
		String parseDay = "";
		if (null != param) {
			// 和暦分解用Stringオブジェクト
			String[] wareki = new String[3];
			// 正規表現チェック８桁数字YYYYMMDD
			Pattern strPattern = Pattern.compile("^[0-9]{8}$");
			Matcher strMatcher = strPattern.matcher(param);
			if (strMatcher.find()) {
				// 和暦に分解して設定
				if (0 != PNCommonComponents.dateFmtAD_YYYYMMDD(param).length()) {
					wareki = PNCommonComponents.dateFmtAD_YYYYMMDD(param)
							.split("\\.");
					parseGengo = new StringBuffer(wareki[0]).substring(0, 1)
							.toUpperCase();
					parseYear = new StringBuffer(wareki[0]).substring(1);
					parseMonth = wareki[1];
					parseDay = wareki[2];
				}
			}
		}
		parseSeireki.add(parseGengo);
		parseSeireki.add(parseYear);
		parseSeireki.add(parseMonth);
		parseSeireki.add(parseDay);
		return parseSeireki;

	}

	/**
	 *
	 * <pre>
	 * BigDecimal型をString型に型変換します。
	 * 引数がnullの場合0を返します。
	 * 引数が数字に変換できない場合は、nullを返します。
	 * </pre>
	 *
	 * @param 数字
	 * @return 文字列
	 */
	private String cnvBigToStr(BigDecimal param) {
		// 引数がnullの場合は0を返す。
		if (null == param) {
			return "0";
		}
		// 引数をBigdecimalに変換
		return param.toString();
	}

	/**
	 *
	 * <pre>
	 * BigDecimal型をString型に型変換します。
	 * 引数がnullの場合第二引数returnparamを返します。
	 * </pre>
	 *
	 * @param 数字
	 * @return 文字列
	 */
	private String cnvBigToStr(BigDecimal param, String returnparam) {
		// 引数がnullの場合は0を返す。
		if (null == param) {
			return returnparam;
		}
		// 引数をBigdecimalに変換
		return param.toString();
	}

	/**
	 *
	 * <pre>
	 * Integer型をString型に型変換します。
	 * 引数がnullの場合0を返します。
	 * 引数が数字に変換できない場合は、nullを返します。
	 * </pre>
	 *
	 * @param 数字
	 * @return 文字列
	 */
	private String cnvIntegerToStr(Integer param) {
		// 引数がnullの場合は0を返す。
		if (null == param) {
			return "0";
		}
		// 引数をBigdecimalに変換
		return param.toString();
	}

	/**
	 *
	 * <pre>
	 * String型をint型に型変換します。
	 * 引数がnullの場合0を返します。
	 * 引数が数字に変換できない場合は、nullを返します。
	 * </pre>
	 *
	 * @param 文字列
	 * @return 数字
	 */
	private int cnvStrToInteger(String param) {
		// 引数がnullの場合は0を返す。
		if (null == param || 0 == param.length()) {
			return 0;
		}
		try {
			return Integer.parseInt(param);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 *
	 * <pre>
	 * String型をBigDecimal型に型に変換します。
	 * 引数がnullの場合0を返します。
	 * 引数が数字に変換できない場合は、nullを返します。
	 * </pre>
	 *
	 * @param 文字列
	 * @return 数字
	 */
	private BigDecimal cnvStrToBig(String param) {
		// 引数がnullの場合は0を返す。
		if (null == param || 0 == param.length()) {
			return BigDecimal.ZERO;
		}
		try {
			return new BigDecimal(param);
		} catch (NumberFormatException e) {
			return BigDecimal.ZERO;
		}
	}

	/**
	 *
	 * <pre>
	 * BigDecimal型がnullの場合０を返します。
	 * 引数がnullの場合0を返します。
	 * 引数が数字に変換できない場合は、nullを返します。
	 * </pre>
	 *
	 * @param 数字
	 * @return 数字
	 */
	private BigDecimal cnvNullToZeroBig(BigDecimal param) {
		// 引数がnullの場合は0を返す。
		if (null == param) {
			return BigDecimal.ZERO;
		}
		return param;
	}

	/**
	 *
	 * <pre>
	 * 判定用繰償事由コード(1バイト目)を取得します。
	 * </pre>
	 *
	 */
	private String getHantei_KurishojiyuStr01(Md004_01DTO inDto) {
		if (null == inDto.getDrpID_Code_Kurishojiyu()
				|| 2 != inDto.getDrpID_Code_Kurishojiyu().length()) {
			return "";
		}
		return new StringBuffer(inDto.getDrpID_Code_Kurishojiyu()).substring(0,
				1);
	}

	/**
	 *
	 * <pre>
	 * 判定用償還方法コード(1バイト目)を設定します。
	 * </pre>
	 *
	 */
	private String getHantei_ShokanHouhou01(Md004_01DTO inDto) {
		if (null == inDto.getID_Code_ShokanHouhou()
				|| 2 != inDto.getID_Code_ShokanHouhou().length()) {
			return "";
		}
		return new StringBuffer(inDto.getID_Code_ShokanHouhou())
				.substring(0, 1);
	}

	/**
	 *
	 * <pre>
	 * 判定用償還方法コード(2バイト目)を設定します。
	 * </pre>
	 *
	 */
	private String getHantei_ShokanHouhou02(Md004_01DTO inDto) {
		if (null == inDto.getID_Code_ShokanHouhou()
				|| 2 != inDto.getID_Code_ShokanHouhou().length()) {
			return "";
		}
		return new StringBuffer(inDto.getID_Code_ShokanHouhou()).substring(1);
	}

	/**
	 *
	 * <pre>
	 * mathPercent1000機能拡張
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	private String mathPercent1000(String param) {
		if (null == param) {
			return "0";
		} else {
			if (NumberUtils.isNumber(param)) {
				return PNCommonComponents.mathPercent1000(new BigDecimal(param)
						.toString());
			} else {
				return "0";
			}
		}
	}

	/**
	 *
	 * <pre>
	 * 日付から換算してparam営業日後の日付を取得します。
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	public String getBusinessDayAgo(String nowDate, int param) {

		Calendar calendar;

		if (null == nowDate) {
			return "";
		}

		Pattern strPattern = Pattern.compile("^[0-9]{8}$");
		Matcher strMatcher = strPattern.matcher(nowDate);
		if (!strMatcher.find()) {
			return "";
		}

		String strResult = null;
		SimpleDateFormat formatday = new SimpleDateFormat("yyyyMMdd");

		// スキップ日数の絶対値を設定
		int intChkSkipAbsDays = Math.abs(param);
		// 営業日カウンタの初期化
		int intEigyoDayCnt = 0;
		// 日付カウントアップの状態を取得
		int intDayCnt = 0;
		if (0 < param) {
			intDayCnt = 1;
		} else {
			intDayCnt = -1;
		}
		calendar = Calendar.getInstance();
		// String nowDate = pnCommonDBComponents.getPNBusinessDay(1);

		calendar.set(Calendar.YEAR,
				Integer.parseInt(new StringBuffer(nowDate).substring(0, 4)));
		calendar.set(Calendar.MONTH,
				Integer.parseInt(new StringBuffer(nowDate).substring(4, 6)) - 1);
		calendar.set(Calendar.DAY_OF_MONTH,
				Integer.parseInt(new StringBuffer(nowDate).substring(6, 8)));
		for (int i = 0; 365 > i; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, intDayCnt);
			String businessDay = pnCommonDBComponents.chkBusinessDay(formatday
					.format(calendar.getTime()));
			if (null != businessDay) {
				// 営業日の場合、営業日カウンタをインクリメント
				intEigyoDayCnt++;
				// 返却用変数に取得した営業日をセット
				strResult = businessDay;
			} else {
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
	 *
	 * <pre>
	 * dayからMonthago月後を返却
	 * </pre>
	 *
	 * @param day
	 * @param Monthago
	 * @return
	 */
	private String getDayMonthAgo(String day, int Monthago) {
		DateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
		Date dtNow = null;
		try {
			dtNow = new SimpleDateFormat("yyyyMMdd").parse(day);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtNow);
			cal.add(Calendar.MONTH, Monthago);
			return dtFormat.format(cal.getTime());
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 *
	 * <pre>
	 * dayからDayago日後を返却
	 * </pre>
	 *
	 * @param day
	 * @param Monthago
	 * @return
	 */
	private String getDayDayAgo(String day, int Dayago) {
		DateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
		Date dtNow = null;
		try {
			dtNow = new SimpleDateFormat("yyyyMMdd").parse(day);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtNow);
			cal.add(Calendar.DATE, Dayago);
			return dtFormat.format(cal.getTime());
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 *
	 * <pre>
	 * 文字列の長さを返す。
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	private int getStrLength(String param) {
		if (null == param) {
			return 0;
		}
		return PNCommonComponents.cnvNulltoBlank(param).length();
	}

	/**
	 *
	 * <pre>
	 * 複数if文対応
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	public boolean hanteiAll(boolean... param) {
		for (boolean bool : param) {
			if (!bool) {
				return false;
			}
		}

		return true;
	}

	// ########################################################################
	// # DAO呼出し用関数郡
	// ########################################################################

	/**
	 *
	 * <pre>
	 * 払出データの取得 Md004_01HaraidashiData
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01HaraidashiDataEntity> getResult_HaraidashiData(
			Md004_01HaraidashiDataEntity entity, BigDecimal idCredit) {
		entity.setID_Credit(idCredit);
		List<Md004_01HaraidashiDataEntity> outList = md004_01haraidashidatadao
				.findByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 払出データ存在チェック件数の取得 Selectharaidashimaxview
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_Selectharaidashimaxview(
			SelectharaidashimaxviewEntity entity, BigDecimal idCredit) {
		entity.setID_Credit(idCredit);
		long outList = selectharaidashimaxviewdao.countByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 入金履歴データ件数の取得 Nyukinhistory
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_NyukinhisCount(NyukinhistoryEntity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		long outList = nyukinhistorydao.countByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 入金履歴データ合計の取得 Md004_01NyukinHis
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01NyukinHisSumEntity> getResult_NyukinHis(
			Md004_01NyukinHisSumEntity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		List<Md004_01NyukinHisSumEntity> outList = md004_01nyukinhissumdao
				.findByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 請求データ件数取得 SeikyuCount 単テーブル
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_SeikyuCount(SeikyuEntity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return seikyudao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 請求データ件数取得 SeikyuCount
	 *  (約定元金＞０ または、約定利息＞０ または、任意繰上償還利息＞０ または、請求繰上償還利息＞０ または、請求繰上償還元金＞０)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_SeikyuCount1(Md004_01SeikyuCountEntity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return md004_01seikyucountdao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 請求データの取得 Md004_01SeikyuData 複数テーブル
	 * 条件なし
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01SeikyuDataEntity> getResult_SeikyuData(
			Md004_01SeikyuDataEntity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		List<Md004_01SeikyuDataEntity> outList = md004_01seikyudatadao
				.findByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 請求データ件数取得 SeikyuCount
	 * (約定元金＞０ または、請求繰上償還元金＞０)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_SeikyuCount2(Md004_01SeikyuCount2Entity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return md004_01seikyucount2dao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 入金履歴件数取得 Md004_01NyukinhistoryCount
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_NyukinhistoryCount(
			Md004_01NyukinhistoryCountEntity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return md004_01nyukinhistorycountdao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 約定データの件数取得 Md004_01YakujoCount
	 * (払込年月日 < 指定された指定された払込年月日)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_YakujoCount(Md004_01YakujoCountEntity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return md004_01yakujocountdao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 約定データの件数取得 Md004_01YakujoCount2
	 * (払込年月日＞＝指定された払込年月日)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private long getResult_YakujoCount2(Md004_01YakujoCount2Entity entity,
			BigDecimal idCredit, String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		return md004_01yakujocount2dao.countByCondition(entity);
	}

	/**
	 *
	 * <pre>
	 * 約定データの件数取得 Md004_01YakujoCount3
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 *            (払込年月日 ＜ 指定された払込年月)
	 * @return
	 */
	// yakujocountと同一機能のため未使用
	// private long getResult_YakujoCount3(Md004_01YakujoCount3Entity entity,
	// BigDecimal idCredit,
	// String haraikomibi) {
	// entity.setID_Credit(idCredit);
	// entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
	// return md004_01yakujocount3dao.countByCondition(entity);
	// }

	/**
	 *
	 * <pre>
	 * 約定データの取得 Md004_01PreviousYakujoData2
	 * (払込年月日 ＜ 指定した払込年月日)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01PreviousYakujoData2Entity> getResult_PreviousYakujoData2(
			Md004_01PreviousYakujoData2Entity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		List<Md004_01PreviousYakujoData2Entity> outList = md004_01previousyakujodata2dao
				.findByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 * 約定データの取得 Md004_01PreviousYakujoData3
	 * (払込年月日 >= 指定した払込年月日)
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01PreviousYakujoData3Entity> getResult_PreviousYakujoData3(
			Md004_01PreviousYakujoData3Entity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		List<Md004_01PreviousYakujoData3Entity> outList = md004_01previousyakujodata3dao
				.findByCondition(entity);
		return outList;
	}

	/**
	 *
	 * <pre>
	 *  約定データの取得 Md004_01PreviousYakujoData4
	 * 払込年月日 > 指定した払込年月日
	 *
	 * </pre>
	 *
	 * @param entity
	 * @param idCredit
	 * @param haraikomibi
	 * @return
	 */
	private List<Md004_01PreviousYakujoData4Entity> getResult_PreviousYakujoData4(
			Md004_01PreviousYakujoData4Entity entity, BigDecimal idCredit,
			String haraikomibi) {
		entity.setID_Credit(idCredit);
		entity.setDate_Haraikomi(PNCommonComponents.cnvNulltoBlank(haraikomibi));
		List<Md004_01PreviousYakujoData4Entity> outList = md004_01previousyakujodata4dao
				.findByCondition(entity);
		return outList;
	}
}