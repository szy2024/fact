//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : cr011_01BaseController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr011.cr011_01.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController;

/**
 * <pre>
 * このクラスはcr011_01の基底Controllerクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public abstract class Cr011_01BaseController extends PNNormalBaseController<Cr011_01Form> {

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