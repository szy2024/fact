//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_05SendController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_05.web;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.cr005.cr005_05.service.Cr005_05DTO;
import jp.go.jfc.partnernet.cr005.cr005_05.service.Cr005_05Service;
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
 * このクラスはcr005_05の登録コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_05Form")
@RequestMapping(value = "/Cr005_05Send.form")
public class Cr005_05SendController extends Cr005_05BaseController {

	/** Cr005_05Service */
	@Autowired
	Cr005_05Service cr005_05service;

	@Autowired
	PNCommonDBComponents pnCommonDBComponents;

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
	public String executeAction(Model model, Cr005_05Form form, Errors errors,
			HttpServletRequest request, HttpServletResponse response) {

		// ＤＢ登録・更新を行う
		// 　　サービス起動パラメータ設定（画面項目、Form項目一式)
		// 　　　Cr005_05Service.setUpdateInputData // DTOの生成
		// 　　　Cr005_05DTO inCr005_05DTO = new Cr005_05DTO();

		// エラーリストの初期化
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
		// DTOの生成
		Cr005_05DTO inDto = new Cr005_05DTO();
		Cr005_05DTO outDto = new Cr005_05DTO();
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		// DTOへの転記処理をここに実装
		CFWBeanUtils.copyProperties(inDto, form);
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

		// Serviceの呼び出し
		outDto = cr005_05service.setUpdateInputData(inDto);

		// エラー判定
		bizErrors = outDto.getBizErrors();
		if (0 < bizErrors.size()) {
			// エラー有の場合自画面表示
			throw new PNServiceException(bizErrors);
		}

		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		// Formへの転記処理をここに実装
		CFWBeanUtils.copyProperties(form, outDto);
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

		// エラー発生時は画面遷移しない

		// 代位弁済金払込・充当報告書作成（登録結果画面）へ遷移する
		// 　return success("Cr005_06Init")
		return success(Cr005Constants.EVENT_ID_CR005_06INIT);

		// return MY_VIEW;
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
	public void displayControl(Model model, Cr005_05Form form,
			HttpServletRequest request) {

	}
}