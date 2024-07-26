//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_02.web;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.md003.common.Md003Constants;
import jp.go.jfc.partnernet.md003.md003_02.service.Md003_02DTO;
import jp.go.jfc.partnernet.md003.md003_02.service.Md003_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

import org.springframework.beans.factory.annotation.Autowired;
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
 * このクラスはmd003_02の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md003_02Form")
@RequestMapping(value = "/Md003_02Create.form")
public class Md003_02CreateController extends Md003_02BaseController {

	/** Md003_02Service */
	@Autowired
	Md003_02Service md003_02service;

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
	public String executeAction(Model model, Md003_02Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response) {

		// エラーリストの初期化
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		// DTOの生成
		Md003_02DTO inDto = new Md003_02DTO();
		Md003_02DTO outDto = new Md003_02DTO();

		if (Md003Constants.PROCESS_MODE_3.equals(form.getProcessMode())) {
			// 処理モードが、処理完了以外：取消の場合
			// 引数：更正（赤）データ
			// 　Md003_02Service.updateDataNotProcEndDel
			// DTOへの転記処理をここに実装
			CFWBeanUtils.copyProperties(inDto, form);
			// Serviceの呼び出し
			// Md003_02DTO outMd003_02DTO =
			// md003_02service.updateDataNotProcEndDel(inMd003_02DTO);
			outDto = md003_02service.updateDataNotProcEndDel(inDto);
			// エラー判定
			if (0 < outDto.getBizErrors().size()) {
				// エラー有の場合自画面表示
				bizErrors.addAll(outDto.getBizErrors());
				throw new PNServiceException(bizErrors);
			}

		} else if (Md003Constants.PROCESS_MODE_1.equals(form.getProcessMode())) {
			// 処理モードが、処理完了：取消の場合
			// 引数：更正（赤）データ
			// 　Md003_02Service.updateDataProcEndDel // DTOの生成
			// Md003_02DTO inMd003_02DTO = new Md003_02DTO();
			// DTOへの転記処理をここに実装
			CFWBeanUtils.copyProperties(inDto, form);
			// Serviceの呼び出し
			// Md003_02DTO outMd003_02DTO =
			// md003_02service.updateDataProcEndDel(inMd003_02DTO);
			outDto = md003_02service.updateDataProcEndDel(inDto);
			// エラー判定
			if (0 < outDto.getBizErrors().size()) {
				// エラー有の場合自画面表示
				bizErrors.addAll(outDto.getBizErrors());
				throw new PNServiceException(bizErrors);
			}

		} else if (Md003Constants.PROCESS_MODE_4.equals(form.getProcessMode())) {
			// 処理モードが、処理完了以外：修正の場合
			// 引数：更正（赤）データ、修正データ
			// 　　Md003_02Service.updateDataNotProcEndMod // DTOの生成
			// Md003_02DTO inMd003_02DTO = new Md003_02DTO();
			// DTOへの転記処理をここに実装
			CFWBeanUtils.copyProperties(inDto, form);
			// Serviceの呼び出し
			// Md003_02DTO outMd003_02DTO =
			// md003_02service.updateDataNotProcEndMod(inMd003_02DTO);
			outDto = md003_02service.updateDataNotProcEndMod(inDto);
			// エラー判定
			if (0 < outDto.getBizErrors().size()) {
				// エラー有の場合自画面表示
				bizErrors.addAll(outDto.getBizErrors());
				throw new PNServiceException(bizErrors);
			}

		} else if (Md003Constants.PROCESS_MODE_2.equals(form.getProcessMode())) {
			// 処理モードが処理完了：修正の場合
			// 引数：更正（赤）データ、修正データ
			// 　　Md003_02Service.updateDataProcEndMod // DTOの生成
			// Md003_02DTO inMd003_02DTO = new Md003_02DTO();
			// DTOへの転記処理をここに実装
			CFWBeanUtils.copyProperties(inDto, form);
			// Serviceの呼び出し
			// Md003_02DTO outMd003_02DTO =
			// md003_02service.updateDataProcEndMod(inMd003_02DTO);
			outDto = md003_02service.updateDataProcEndMod(inDto);
			// エラー判定
			if (0 < outDto.getBizErrors().size()) {
				// エラー有の場合自画面表示
				bizErrors.addAll(outDto.getBizErrors());
				throw new PNServiceException(bizErrors);
			}

		} else if (Md003Constants.PROCESS_MODE_5.equals(form.getProcessMode())) {
			// 処理モードが処理完了以外：取消(更正赤)の場合
			// 引数：更正（赤）データ
			// 　　Md003_02Service.updateDataProcEndDelCalcel
			// DTOへの転記処理をここに実装
			CFWBeanUtils.copyProperties(inDto, form);
			// Serviceの呼び出し
			// Md003_02DTO outMd003_02DTO =
			// md003_02service.updateDataNotProcEndDelCalcel(inMd003_02DTO);
			outDto = md003_02service.updateDataNotProcEndDelCalcel(inDto);
			// エラー判定
			if (0 < outDto.getBizErrors().size()) {
				// エラー有の場合自画面表示
				bizErrors.addAll(outDto.getBizErrors());
				throw new PNServiceException(bizErrors);
			}
		}

		// 画面にエラーメッセージが設定されていない場合、画面遷移を行う。
		CFWBeanUtils.copyProperties(form, outDto);
		// 　登録結果画面へ遷移する
		// 　　return success("Md003_03Init")
		return success(Md003Constants.EVENT_ID_MD003_03INIT);

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
	public void displayControl(Model model, Md003_02Form form,
			HttpServletRequest request) {

	}
}