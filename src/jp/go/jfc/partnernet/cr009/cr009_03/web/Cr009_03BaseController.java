//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr009_03BaseController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/01 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr009.cr009_03.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController;

/**
 * <pre>
 * このクラスはCr009_03の基底Controllerクラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public abstract class Cr009_03BaseController extends PNNormalBaseController<Cr009_03Form> {

    /**
     * 
     * <pre>
     * 画面個別にバインド処理をカスタマイズする為のメソッドです。
     * 基底Controllerの<code>@InitBinder</code>アノテーションが付与されたメソッドから呼び出されます。
     * </pre>
     * 
     * @param request HttpServletRequest
     * @param binder WebDataBinder
     */
    @Override
    protected void initBinderInternal(HttpServletRequest request, WebDataBinder binder) {
    }

}