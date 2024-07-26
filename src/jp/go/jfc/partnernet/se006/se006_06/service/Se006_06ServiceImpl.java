//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_06Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/23 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_06.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_06.dao.Se006_06DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_06のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_06ServiceImpl extends PNBaseService implements Se006_06Service {

	@Autowired
	PNJpCalendarUtils jpCalendarUtils;

	/** se006_06detaildatadao */
	@Autowired
	private Se006_06DetailDataDAO se006_06detaildatadao;

	/**
	 * Se006_06ServiceのgetDetailData
	 *
	 * @param inDto Se006_06DTO
	 * @return Se006_06DTO
	 */
	@Override
	public Se006_06DTO getDetailData(Se006_06DTO inDto) {

		Se006_06DTO outDto = new Se006_06DTO();

		/** エラーリスト */
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

		bizErrors.clear();

		// １．表示前処理
		// 検索条件を設定
		// 複数テーブルアクセス定義の「Se006_06DetailDataDAO」を参照し、条件を設定する。
		// Se006_06DetailDataDAO.findByCondition
		Se006_06DetailDataEntity inEntity = new Se006_06DetailDataEntity();
		inEntity.setID_Report(inDto.getID_ID_Report());
		List<Se006_06DetailDataEntity> outEntityList = se006_06detaildatadao.findByCondition(inEntity);

		// 貸付受入金払出・充当報告書データが存在しない場合
		// 　　処理を抜ける。
		if (0 == outEntityList.size()) {
			// エラー内容設定
			bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
			outDto.setBizErrors(bizErrors);
			return outDto;
		}

		// 貸付実行報告書データが存在しない場合
		// 　処理を抜ける。
		// １．表示制御
		// Entity⇒DTOに転記
		Se006_06DetailDataEntity outEntity = se006_06detaildatadao.findByCondition(inEntity).get(0);
		// Se006_06DetailDataEntity.報告書番号⇒Se006_06DTO.報告書番号
		outDto.setID_ID_Report(outEntity.getID_Report());
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.報告年月日⇒Se006_06DTO.報告年月日
		String outDateReport = outEntity.getDate_Report();
		outDto.setID_Date_Report(PNCommonComponents.cnvNulltoBlank(outDateReport));
		// Se006_06DetailDataEntity.報告時分秒⇒Se006_06DTO.報告時分秒
		String outTimeReport = outEntity.getTime_Report();
		outDto.setID_Time_Report(PNCommonComponents.timeFormatConvert(outTimeReport));
		// Se006_06DetailDataEntity.公庫支店コード⇒Se006_06DTO.公庫支店
		outDto.setID_Code_KoukoShiten(outEntity.getCode_KoukoShiten());
		// Se006_06DetailDataEntity.扱店コード⇒Se006_06DTO.扱店
		outDto.setID_Code_Organization(outEntity.getCode_Organization());
		// Se006_06DetailDataEntity.店舗コード⇒Se006_06DTO.店舗
		outDto.setID_Code_Tenpo(outEntity.getCode_Tenpo());
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.受託者勘定処理年月⇒Se006_06DTO.受託者勘定処理年月
		String outDateJtkshori = outEntity.getDate_Jtkshori();
		outDto.setID_Date_Jtkshori(PNCommonComponents.cnvNulltoBlank(outDateJtkshori));
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.年度⇒Se006_06DTO.年度
		String outYear = outEntity.getYear();
		outDto.setID_Year(PNCommonComponents.cnvNulltoBlank(outYear));
		// Se006_06DetailDataEntity.方式資金⇒Se006_06DTO.方式資金
		outDto.setID_Kubun_Hoshiki(outEntity.getCode_HoshikiShikin());
		// Se006_06DetailDataEntity.稟議番号⇒Se006_06DTO.番号
		outDto.setID_ID_Ringi(outEntity.getID_Ringi());
		// Se006_06DetailDataEntity.稟議番号枝番が0の場合、空白⇒Se006_06DTO.枝番
		// 　上記以外の場合、Se006_06DetailDataEntity.稟議番号枝番⇒Se006_06DTO.枝番
		String outIDRingiBranch = outEntity.getID_RingiBranch();
		if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
			outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
		}
		outDto.setID_ID_RingiBranch(outIDRingiBranch);
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.元金充当後第１回約定日⇒Se006_06DTO.元金充当後第１回約定日
		String outDateFirstYakujoAfterGanju = outEntity.getDate_FirstYakujoAfterGanju();
		outDto.setID_Date_FirstYakujoAfterGanju(PNCommonComponents
				.cnvNulltoBlank(outDateFirstYakujoAfterGanju));
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.払出・元金充当日⇒Se006_06DTO.払出・元金充当日
		String outDateHaraidashiJuto = outEntity.getDate_HaraidashiJuto();
		outDto.setID_Date_HaraidashiJuto(PNCommonComponents.cnvNulltoBlank(outDateHaraidashiJuto));
		// Se006_06DetailDataEntity.繰上償還事由コード⇒Se006_06DTO.繰上償還事由コード
		outDto.setID_Code_KurishoJiyu(outEntity.getCode_KurishoJiyu());
		// Se006_06DetailDataEntity.資金払出額⇒Se006_06DTO.資金払出額
		outDto.setID_M_Haraidashi(outEntity.getM_Haraidashi());
		// Se006_06DetailDataEntity.元金充当額⇒Se006_06DTO.元金充当額(貸付受入金からの繰上償還)
		outDto.setID_M_Ganju(outEntity.getM_Ganju());
		// Se006_06DetailDataEntity.貸付受入金残高⇒Se006_06DTO.貸付受入金残高
		outDto.setID_M_KashitsukeukeireZan(outEntity.getM_KashitsukeukeireZan());
		// Se006_06DetailDataEntity.元金充当後貸付金残高⇒Se006_06DTO.元金充当後貸付金残高
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero((outEntity.getM_Ganju())))) {
			outDto.setID_M_KashitsukeZandakaAfterGanju(outEntity.getM_KashitsukeZandakaAfterGanju());
		} else {
			outDto.setID_M_KashitsukeZandakaAfterGanju(null);
		}
		// Se006_06DetailDataEntity.元金充当後の元金均等額⇒Se006_06DTO.元金充当後の元金均等額
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity
				.getM_GankinKintoAfterGanju()))) {
			outDto.setID_M_GankinKintoAfterGanju(outEntity.getM_GankinKintoAfterGanju());
		} else {
			outDto.setID_M_GankinKintoAfterGanju(null);
		}
		// Se006_06DetailDataEntity.元金充当後の元金不均等額⇒Se006_06DTO.元金充当後の元金不均等額
		if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity
				.getM_GankinKintoAfterGanju()))) {
			outDto.setID_M_GankinFukintoAfterGanju(outEntity.getM_GankinFukintoAfterGanju());
		} else {
			outDto.setID_M_GankinFukintoAfterGanju(null);
		}
		// Se006_06DetailDataEntity.調整コード⇒Se006_06DTO.調整コード
		outDto.setRdoID_Code_Chosei(PNCommonComponents.cnvNulltoBlank(outEntity.getCode_Chosei()));
		// Se006_06DetailDataEntity.資金使途コード⇒Se006_06DTO.資金使途
		outDto.setID_Code_ShikinShito(outEntity.getCode_ShikinShito());
		// Se006_06DetailDataEntity.事業別コード⇒Se006_06DTO.事業別
		outDto.setID_Code_Jigyobetsu(outEntity.getCode_Jigyobetsu());
		// 利率を１０００で割り設定する
		// 　Se006_06DetailDataEntity.利率/1000⇒Se006_06DTO.利率
		outDto.setID_Riritsu(PNCommonComponents.mathPercent1000(outEntity.getRiritsu()));
		// Se006_06DetailDataEntity.特利区分コード⇒Se006_06DTO.特利コード
		outDto.setID_Kubun_Tokuri(outEntity.getCode_TokuriKubun());
		// 特利（利率）を１０００で割り設定する
		// 　Se006_06DetailDataEntity.特利（利率）⇒Se006_06DTO.特利
		outDto.setID_Tokuri(PNCommonComponents.mathPercent1000(outEntity.getTokuri()));
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.据置期限（年月）⇒Se006_06DTO.据置期限
		String outDataSueokiKigen = outEntity.getDate_SueokiKigen();
		outDto.setID_Date_SueokiKigen(PNCommonComponents.cnvNulltoBlank(outDataSueokiKigen));
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.償還期限（年月）⇒Se006_06DTO.償還期限
		String outDataShokanKigen = outEntity.getDate_ShokanKigen();
		outDto.setID_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outDataShokanKigen));
		// 西暦から和暦に変換して設定する // 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.元利金払込日⇒Se006_06DTO.元利金払込日
		String outDataGanrikinHaraikomi = outEntity.getDate_GanrikinHaraikomi();
		outDto.setID_Date_GanrikinHaraiKomi(PNCommonComponents.dateFmtAD_MMDD(outDataGanrikinHaraikomi));
		// 西暦から和暦に変換して設定する
		// 　Se006_06DetailDataEntity.貸付実行日⇒Se006_06DTO.貸付実行日
		String outDataJikko = outEntity.getDate_Jikko();
		outDto.setID_Date_Kashitsukejikko(PNCommonComponents.cnvNulltoBlank(outDataJikko));
		// Se006_06DetailDataEntity.貸付実行金額⇒Se006_06DTO.貸付実行金額
		outDto.setID_M_Kashitsuke(outEntity.getM_Kashitsuke());
		// Se006_06DetailDataEntity.資金交付額⇒Se006_06DTO.資金交付額
		outDto.setID_M_ShikinKofu(outEntity.getM_ShikinKofu());
		// Se006_06DetailDataEntity.貸付受入金受入額⇒Se006_06DTO.貸付受入金受入額
		outDto.setID_M_KashitsukeUkeire(outEntity.getM_KashitsukeUkeire());
		// Se006_06DetailDataEntity.扱店名⇒Se006_06DTO.扱店名
		outDto.setID_Name_Organization(outEntity.getName_Organization());
		// Se006_06DetailDataEntity.顧客名⇒Se006_06DTO.顧客名
		outDto.setID_Name_Customer(outEntity.getName_Customer());
		// Se006_06DetailDataEntity.データコードの下２桁　＝　２１のとき
		String dataCode = outEntity.getDataCode();
		if (null != dataCode
				&& dataCode.substring(dataCode.length() - Se006Constants.DATA_CODE_LENGTH).equals(
						Se006Constants.DATA_CODE_VALUE_21)) {
			// '更正 赤'⇒Se006_06DTO.メッセージ
			outDto.setLblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
		}

		return outDto;
	}
}