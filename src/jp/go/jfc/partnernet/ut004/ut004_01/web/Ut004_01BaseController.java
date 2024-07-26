//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut004_01BaseController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut004.ut004_01.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController;

/**
 * <pre>
 * このクラスはut004_01の基底Controllerクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public abstract class Ut004_01BaseController extends PNNormalBaseController<Ut004_01Form> {

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