//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_03BaseController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 松井　元気            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_03.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController;

/**
 * <pre>
 * このクラスはUm001_03の基底Controllerクラスです。
 * </pre>
 *
 * @author 松井　元気
 * @version 1.0.0
 */
public abstract class Um001_03BaseController extends PNNormalBaseController<Um001_03Form> {

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