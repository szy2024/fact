//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02BaseController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController;

/**
 * <pre>
 * このクラスはCr004_02の基底Controllerクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public abstract class Cr004_02BaseController extends
		PNNormalBaseController<Cr004_02Form> {

	/**
	 *
	 * <pre>
	 * 画面個別にバインド処理をカスタマイズする為のメソッドです。
	 * 基底Controllerの<code>@InitBinder</code>アノテーションが付与されたメソッドから呼び出されます。
	 * </pre>
	 *
	 * @param request
	 *            HttpServletRequest
	 * @param binder
	 *            WebDataBinder
	 */
	@Override
	protected void initBinderInternal(HttpServletRequest request,
			WebDataBinder binder) {
	}

}