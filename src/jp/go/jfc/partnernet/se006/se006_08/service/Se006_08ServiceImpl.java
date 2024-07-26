//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_08Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_08.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_08.dao.Se006_08DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_08.dao.Se006_08DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_08のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_08ServiceImpl extends PNBaseService implements Se006_08Service {

	/** se006_08detaildatadao */
	@Autowired
	private Se006_08DetailDataDAO se006_08detaildatadao;

	/**
	 * Se006_08ServiceのgetDetailData
	 *
	 * @param inDto Se006_08DTO
	 * @return Se006_08DTO
	 */
	@Override
	public Se006_08DTO getDetailData(Se006_08DTO inDto) {

		/** エラーリスト */
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

		// エラーリスト初期化
		bizErrors.clear();

		Se006_08DTO outDto = new Se006_08DTO();

		// １．表示前処理
		// 検索条件を設定
		// 複数テーブルアクセス定義の「Se006_08DetailDataDAO」を参照し、条件を設定する。
		Se006_08DetailDataEntity inEntity = new Se006_08DetailDataEntity();
		inEntity.setID_Report(inDto.getLblID_Report());
		List<Se006_08DetailDataEntity> outEntityList = se006_08detaildatadao.findByCondition(inEntity);

		// 繰上償還報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
		// 　メッセージ：PN_SE006_005
		if (0 == outEntityList.size()) {
			// エラー内容設定
			bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
			outDto.setBizErrors(bizErrors);
			return outDto;
		}

		// １．表示制御
		// Entity⇒DTOに転記
		Se006_08DetailDataEntity outEntity = se006_08detaildatadao.findByCondition(inEntity).get(0);
		// Se006_08DetailDataEntity.データコード　＝　"90257051" または "90257061" または "90257101" のとき
		String outDataCode = outEntity.getDataCode();
		if (Se006Constants.DATACODE_90257051.equals(outDataCode)
				|| Se006Constants.DATACODE_90257061.equals(outDataCode)
				|| Se006Constants.DATACODE_90257101.equals(outDataCode)) {
			// '更正 赤'⇒Se006_08DTO.メッセージ
			outDto.setLblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
		}
		// Se006_08DetailDataEntity.報告書番号⇒Se006_08DTO.報告書番号
		outDto.setLblID_Report(outEntity.getID_Report());
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.報告年月日⇒Se006_08DTO.報告年月日
		String outDateReport = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Report());
		outDto.setLblDate_Report(outDateReport);
		// Se006_08DetailDataEntity.報告時分秒⇒Se006_08DTO.報告時分秒
		String outTimeReport = PNCommonComponents.timeFormatConvert(outEntity.getTime_Report());
		outDto.setLblTime_Report(outTimeReport);
		// Se006_08DetailDataEntity.顧客名⇒Se006_08DTO.顧客名
		String outNameCustomer = outEntity.getName_Customer();
		outDto.setLblID_Name_Customer(outNameCustomer);
		// Se006_08DetailDataEntity.扱店名⇒Se006_08DTO.扱店名
		String outNameOrganization = outEntity.getName_Organization();
		outDto.setLblID_Name_Organization(outNameOrganization);
		// Se006_08DetailDataEntity.公庫支店コード⇒Se006_08DTO.公庫支店
		String outCodeKoukoShiten = outEntity.getCode_KoukoShiten();
		outDto.setLblID_Code_ShokanHonShiten(outCodeKoukoShiten);
		// Se006_08DetailDataEntity.扱店コード⇒Se006_08DTO.扱店
		String outCodeOrganization = outEntity.getCode_Organization();
		outDto.setLblID_Code_Organization(outCodeOrganization);
		// Se006_08DetailDataEntity.店舗コード⇒Se006_08DTO.店舗
		String outCodeTenpo = outEntity.getCode_Tenpo();
		outDto.setLblID_Code_Tenpo(outCodeTenpo);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.年度⇒Se006_08DTO.年度
		String outYear = PNCommonComponents.cnvNulltoBlank(outEntity.getYear());
		outDto.setLblID_Year(outYear);
		// Se006_08DetailDataEntity.方式資金⇒Se006_08DTO.方式資金
		String outCodeHoshikiShikin = outEntity.getCode_HoshikiShikin();
		outDto.setLblID_Code_HoshikiShikin(outCodeHoshikiShikin);
		// Se006_08DetailDataEntity.稟議番号⇒Se006_08DTO.番号
		String outIDRingi = outEntity.getID_Ringi();
		outDto.setLblID_ID_Ringi(outIDRingi);
		// Se006_08DetailDataEntity.稟議番号枝番⇒Se006_08DTO.枝番
		// Se006_08DetailDataEntity.稟議番号枝番　＝　"0" のとき
		// 　空白⇒Se006_08DTO.枝番
		String outIDRingiBranch = outEntity.getID_RingiBranch();
		if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
			outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
		}
		outDto.setLblID_ID_RingiBranch(outIDRingiBranch);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.繰償後第１回払込日⇒Se006_08DTO.償還後第1回払込期日
		String outDateFirstHaraikomiAfterKuriS = PNCommonComponents.cnvNulltoBlank(outEntity
				.getDate_FirstHaraikomiAfterKuriS());
		outDto.setLblID_Date_FirstHaraikomiAfterKurisho(outDateFirstHaraikomiAfterKuriS);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.入金日⇒Se006_08DTO.入金日
		String outDateNyukin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Nyukin());
		outDto.setLblID_Date_Nyukin(outDateNyukin);
		// Se006_08DetailDataEntity.繰上償還事由コード⇒Se006_08DTO.繰償事由コード
		String outCodeKurishojiyu = outEntity.getCode_Kurishojiyu();
		outDto.setLblID_Code_Kurishojiyu(outCodeKurishojiyu);
		// Se006_08DetailDataEntity.利息⇒Se006_08DTO.利息(円)
		BigDecimal outMKurishoRisoku = outEntity.getM_KurishoRisoku();
		outDto.setLblID_M_KurishoRisoku(outMKurishoRisoku);
		// Se006_08DetailDataEntity.元金⇒Se006_08DTO.元金(円)
		BigDecimal outMKurishoGankin = outEntity.getM_KurishoGankin();
		outDto.setLblID_M_KurishoGankin(outMKurishoGankin);
		// Se006_08DetailDataEntity.控除利息⇒Se006_08DTO.控除利息(円)
		BigDecimal outMKojoRisoku = outEntity.getM_KojoRisoku();
		outDto.setLblID_M_KojoRisoku(PNCommonComponents.cnvNulltoZero(outMKojoRisoku));
		// Se006_08DetailDataEntity.繰上償還手数料⇒Se006_08DTO.繰上償還手数料(円)
		BigDecimal outMKurishoCommission = outEntity.getM_KurishoCommission();
		outDto.setLblID_M_KurishoCommision(PNCommonComponents.cnvNulltoZero(outMKurishoCommission));
		// Se006_08DetailDataEntity.仮受金からの充当⇒Se006_08DTO.仮受金からの充当額(円)
		BigDecimal outMKariukeIppanJuto = outEntity.getM_KariukeIppanJuto();
		if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outMKariukeIppanJuto))) {
			outDto.setLblID_M_KariukeIppanJuto(null);
		} else {
			outDto.setLblID_M_KariukeIppanJuto(outMKariukeIppanJuto);
		}
		// Se006_08DetailDataEntity.送金額⇒Se006_08DTO.送金額(円)
		BigDecimal outMSokin = outEntity.getM_Sokin();
		outDto.setLblID_M_Sokin(outMSokin);
		// Se006_08DetailDataEntity.繰償後残元金⇒Se006_08DTO.繰償後残元金(円)
		BigDecimal outMZanAfterKurisho = outEntity.getM_ZanAfterKurisho();
		outDto.setLblID_M_ZanGankinAfterKurisho(outMZanAfterKurisho);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.受託者勘定処理年月⇒Se006_08DTO.受託者勘定処理年月
		String outDateJtkshori = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Jtkshori());
		outDto.setLblID_Date_JtkShori(outDateJtkshori);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.送金日⇒Se006_08DTO.送金日
		String outDateSokin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Sokin());
		outDto.setLblID_Date_Sokin(outDateSokin);
		// Se006_08DetailDataEntity.送金日番号⇒Se006_08DTO.送金日番号
		String outIDSokinbi = outEntity.getID_Sokinbi();
		outDto.setLblID_ID_Sokinbi(outIDSokinbi);
		// Se006.08DetailDataEntity.データコード　＝　"90257100" または "90257101"のとき
		if (Se006Constants.DATACODE_90257100.equals(outDataCode)
				|| Se006Constants.DATACODE_90257101.equals(outDataCode)) {
			// '1'⇒Se006_08DTO.代弁履行後の作成
			outDto.setChkID_ID_After_Daiibensai(Se006Constants.AFTER_DAIBENSAI);
		}
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.払込期日①⇒Se006_08DTO.払込期日１
		String outDateHaraikomi1 = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Haraikomi1());
		outDto.setLblID_Date_Haraikomi1(outDateHaraikomi1);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.払込期日②⇒Se006_08DTO.払込期日２
		String outDateHaraikomi2 = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Haraikomi2());
		outDto.setLblID_Date_Haraikomi2(outDateHaraikomi2);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.払込期日③⇒Se006_08DTO.払込期日３
		String outDateHaraikomi3 = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Haraikomi3());
		outDto.setLblID_Date_Haraikomi3(outDateHaraikomi3);
		// 西暦から和暦に変換して設定する
		// 　Se006_08DetailDataEntity.払込期日④⇒Se006_08DTO.払込期日４
		String outDateHaraikomi4 = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Haraikomi4());
		outDto.setLblID_Date_Haraikomi4(outDateHaraikomi4);
		// Se006_08DetailDataEntity.払込元金①⇒Se006_08DTO.払込元金１
		BigDecimal outMHaraikomiGankin1 = outEntity.getM_HaraikomiGankin1();
		outDto.setLblID_M_HaraikomiGankin1(outMHaraikomiGankin1);
		// Se006_08DetailDataEntity.払込元金②⇒Se006_08DTO.払込元金２
		BigDecimal outMHaraikomiGankin2 = outEntity.getM_HaraikomiGankin2();
		outDto.setLblID_M_HaraikomiGankin2(outMHaraikomiGankin2);
		// Se006_08DetailDataEntity.払込元金③⇒Se006_08DTO.払込元金３
		BigDecimal outMHaraikomiGankin3 = outEntity.getM_HaraikomiGankin3();
		outDto.setLblID_M_HaraikomiGankin3(outMHaraikomiGankin3);
		// Se006_08DetailDataEntity.払込元金④⇒Se006_08DTO.払込元金４
		BigDecimal outMHaraikomiGankin4 = outEntity.getM_HaraikomiGankin4();
		outDto.setLblID_M_HaraikomiGankin4(outMHaraikomiGankin4);
		// Se006_08DetailDataEntity.繰償後元金均等額⇒Se006_08DTO.繰償後元金均等額(円)
		BigDecimal outMGankinKintoAfterKurisho = outEntity.getM_GankinKintoAfterKurisho();
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outMGankinKintoAfterKurisho))) {
			outDto.setLblID_M_GankinKintoAfterKurisho(outMGankinKintoAfterKurisho);
		} else {
			outDto.setLblID_M_GankinKintoAfterKurisho(null);
		}
		// Se006_08DetailDataEntity.繰償後元金不均等額⇒Se006_08DTO.繰償後元金不均等額(円)
		BigDecimal outMGankinFukintoAfterKurisho = outEntity.getM_GankinFukintoAfterKurisho();
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outMGankinKintoAfterKurisho))) {
			outDto.setLblID_M_GankinFukintoAfterKurisho(outMGankinFukintoAfterKurisho);
		} else {
			outDto.setLblID_M_GankinFukintoAfterKurisho(null);
		}
		// Se006_08DetailDataEntity.調整コードの値により以下のように設定
		// 　１の場合、Se006_08DTO.調整コードの「初回」を「ON」
		// 　２の場合、Se006_08DTO.調整コードの「最終回」を「ON」
		// 　NULLの場合、Se006_08DTO.調整コードの「なし」を「ON」
		outDto.setRdoID_Code_chosei(PNCommonComponents.cnvNulltoBlank(outEntity.getCode_chosei()));

		return outDto;
	}

}