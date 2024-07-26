//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_02InitController
//
// <<Modification History>>
// Version | Date        | Updated By            | Content
// --------+-------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_02.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01M1DTO;
import jp.go.jfc.partnernet.cr001.cr001_02.service.Cr001_02DTO;
import jp.go.jfc.partnernet.cr001.cr001_02.service.Cr001_02M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr001_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr001_02Form")
@RequestMapping(value = "/Cr001_02Init.form")
public class Cr001_02InitController extends Cr001_02BaseController {

	/**
	 * <pre>
	 * 初期表示の処理を行います。
	 * </pre>
	 *
	 * {@inheritDoc}
	 *
	 * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
	 *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
	 *      org.springframework.validation.Errors,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String executeAction(Model model, Cr001_02Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 受渡パラメータ.を取得する。
		Map<String, Object> paramMap = getForwardParameter(request);
		@SuppressWarnings("unchecked")
		List<Cr001_01M1DTO> inM1DtoList = (List<Cr001_01M1DTO>) paramMap
				.get("MEISAI_InputLIST");
		mappingForwardParameterToForm(request, form);

		// 貸付実行報告書作成（入力画面）で「選択」項目のチェックボックスにチェックがされている全ての案件の登録データの表示を行う。
		Cr001_02DTO outDto = new Cr001_02DTO();
		CFWBeanUtils.copyProperties(outDto, form);
		PNPagingTable<Cr001_02M1DTO> cr001_02m1Table = form
				.getCr001_02M1Table();
		List<Cr001_02M1DTO> outM1DtoList = new ArrayList<Cr001_02M1DTO>(0);

		// 入力画面で選択されたもののみを表示する
		// for (Cr001_01M1DTO inM1Dto : form.getMEISAI_InputLIST()) {
		for (Cr001_01M1DTO inM1Dto : inM1DtoList) {
			if ("1".equals(inM1Dto.getChkUpdate())) {
				Cr001_02M1DTO outM1Dto = new Cr001_02M1DTO();

				// 案件
				outM1Dto.setLblIndex(inM1Dto.getLblIndex());
				// 顧客名
				outM1Dto.setID_Name_Customer(inM1Dto.getID_Name_Customer());
				// 扱店名
				outM1Dto.setID_Name_Organization(inM1Dto
						.getID_Name_Organization());
				// 公庫支店
				outM1Dto.setID_Code_ShokanHonShiten(inM1Dto
						.getID_Code_ShokanHonShiten());
				// 扱店
				outM1Dto.setID_Code_Organization(inM1Dto
						.getID_Code_Organization());
				// 店舗
				outM1Dto.setID_Code_Tenpo(inM1Dto.getID_Code_Tenpo());
				// 年度
				outM1Dto.setID_Year(PNCommonComponents.dateFmtJC_Gyy(inM1Dto
						.getID_Year()));
				// 方式資金
				outM1Dto.setID_Code_Hoshiki_Shikin(inM1Dto
						.getID_Code_Hoshiki_Shikin());
				// 番号
				outM1Dto.setID_ID_Ringi(inM1Dto.getID_Ringi());
				// 枝番
				outM1Dto.setID_ID_RingiBranch(inM1Dto.getID_RingiBranch());
				// 資金使途
				outM1Dto.setID_Code_ShikinShito(inM1Dto
						.getID_Code_ShikinShito());
				// 事業別
				outM1Dto.setID_Code_Jigyoubetsu(inM1Dto
						.getID_Code_Jigyoubetsu());
				// 利率
				String riritsu = "";
				if (0 < inM1Dto.getID_Riritsu().length()) {
					BigDecimal bdRiritsu = new BigDecimal(
							inM1Dto.getID_Riritsu()).setScale(3,
							BigDecimal.ROUND_UNNECESSARY);
					riritsu = bdRiritsu.toString();
				}
				outM1Dto.setID_Riritsu(riritsu);
				// 特利区分
				outM1Dto.setID_Kubun_Tokuri(inM1Dto.getID_Kubun_Tokuri());
				// 特利
				outM1Dto.setID_Tokuri(inM1Dto.getID_Tokuri());
				// 据置期限
				String sueokiKigen = "";
				if (0 < inM1Dto.getID_Date_SueokiKigen().length()) {
					sueokiKigen = PNCommonComponents.dateFmtJC_Gyymm(
							inM1Dto.getID_Date_SueokiKigen(), ".").replaceAll(
							"\\.", "");
				}
				outM1Dto.setID_Date_SueokiKigen(sueokiKigen);
				// 償還期限
				String shokanKigen = "";
				if (0 < inM1Dto.getID_Date_ShokanKigen().length()) {
					shokanKigen = PNCommonComponents.dateFmtJC_Gyymm(
							inM1Dto.getID_Date_ShokanKigen(), ".").replaceAll(
							"\\.", "");
				}
				outM1Dto.setID_Date_ShokanKigen(shokanKigen);
				// 元利金払込日
				outM1Dto.setID_Date_GanrikinHaraiKomi(inM1Dto
						.getID_Date_GanrikinHaraiKomi());
				// 受託者勘定処理年月
				String dateJtkdhori = PNCommonComponents
						.dateFmtJC_Gyymm(
								PNCommonComponents
										.concatString(
												inM1Dto.getID_Date_Jtkshori_Gengo(),
												String.format(
														"%02d",
														Integer.parseInt(inM1Dto
																.getID_Date_Jtkshori_Nen())),
												String.format(
														"%02d",
														Integer.parseInt(inM1Dto
																.getID_Date_JtkshoriTsuki_Candidate()))),
								"");
				outM1Dto.setID_Date_Jtkshori(dateJtkdhori);
				// 貸付実行日
				String dateKashitsukejikko = PNCommonComponents
						.dateFmtJC_Gyymmdd(
								PNCommonComponents
										.concatString(
												inM1Dto.getID_Date_Kashitsukejikko_Gengo(),
												String.format(
														"%02d",
														Integer.parseInt(inM1Dto
																.getID_Date_Kashitsukejikko_Nen())),
												String.format(
														"%02d",
														Integer.parseInt(inM1Dto
																.getID_Date_KashitsukejikkoTsuki_Candidate())),
												String.format(
														"%02d",
														Integer.parseInt(inM1Dto
																.getID_Date_KashitsukejikkoBi_Candidate()))),
								"");
				outM1Dto.setID_Date_Kashitsukejikko(dateKashitsukejikko);
				// 貸付実行金額
				outM1Dto.setID_M_Kashitsuke(new BigDecimal(inM1Dto
						.getID_M_Kashitsuke().replaceAll(",", "")));
				// 資金交付額
				outM1Dto.setID_M_SikinKofu(new BigDecimal(inM1Dto
						.getID_M_SikinKofu().replaceAll(",", "")));
				// 貸付受入金受入額
				String strMKashitsukeUkeire = PNCommonComponents
						.cnvNulltoBlank(inM1Dto.getID_M_KashitsukeUkeire());
				if (false == PNCommonConstants.LITERAL_BLANK
						.equals(strMKashitsukeUkeire)) {
					outM1Dto.setID_M_KashitsukeUkeire(new BigDecimal(inM1Dto
							.getID_M_KashitsukeUkeire().replaceAll(",", "")));
				}
				// 貸付実行報告書作成済みフラグ
				outM1Dto.setID_Flag_Kj(Integer.parseInt(inM1Dto.getID_Flag_Kj()));
				// 報告書番号
				outM1Dto.setID_ID_Report(inM1Dto.getID_ID_Report());
				// 報告時分秒
				outM1Dto.setID_Time_Report(inM1Dto.getID_Time_Report());
				// ユーザID
				outM1Dto.setID_UserID(inM1Dto.getID_UserID());
				// 伝送番号
				outM1Dto.setID_Denso(inM1Dto.getID_Denso());
				// データコード
				outM1Dto.setID_DataCode(inM1Dto.getID_DataCode());
				// 履歴番号
				outM1Dto.setID_ID_History(inM1Dto.getID_ID_History());
				// ステータス
				outM1Dto.setID_Status(Integer.parseInt(inM1Dto.getID_Status()));
				// 処理種別
				outM1Dto.setID_Type_Process(inM1Dto.getID_Type_Process());
				// 取消済フラグ
				outM1Dto.setID_Flag_Torikeshizumi(inM1Dto
						.getID_Flag_Torikeshizumi());
				// エラーコード
				outM1Dto.setID_Code_Error(inM1Dto.getID_Code_Error());
				// エラーメッセージ
				outM1Dto.setID_ErrorMessage(inM1Dto.getID_ErrorMessage());
				// 債権管理番号
				outM1Dto.setID_ID_Credit(inM1Dto.getID_ID_Credit());
				// 最新データ更新日付
				outM1Dto.setID_Data_LastUpDate(inM1Dto.getData_LastUpDate());

				outM1DtoList.add(outM1Dto);
			}
		}
		outDto.setMEISAI_LIST(outM1DtoList);
		cr001_02m1Table.setResultsPerPage(outDto.getMEISAI_LIST().size());

		cr001_02m1Table.setRecordList(outDto.getMEISAI_LIST(), outDto
				.getMEISAI_LIST().size());
		form.setMEISAI_LIST(outDto.getMEISAI_LIST());
		form.setCr001_02M1Table(cr001_02m1Table);

		return MY_VIEW;
	}

	/**
	 * <pre>
	 * 初期表示時の画面制御を行います。
	 * </pre>
	 *
	 * {@inheritDoc}
	 *
	 * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
	 *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void displayControl(Model model, Cr001_02Form form,
			HttpServletRequest request) {

	}
}