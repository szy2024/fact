//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_01Validate
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_01.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import jp.go.jfc.partnernet.pnfw.web.validation.PNBaseValidator;
import com.fujitsu.crust.web.annotation.CrustValidationTarget;

/**
 * <pre>
 * このクラスは画面固有の入力チェッククラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Ut001_01Validate extends PNBaseValidator {

    /**
     *
     * <pre>
     * 初期表示イベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Ut001_01Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Ut001_01InitController.class)
    public void initValidate(Ut001_01Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 通知・事務連絡の［詳細］ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Ut001_01Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Ut001_02GoTsuchiJimController.class)
    public void goTsuchiJimValidate(Ut001_01Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 金利改定情報の［詳細］ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Ut001_01Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Ut001_03GoKinrijyohoController.class)
    public void goKinrijyohoValidate(Ut001_01Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 要領・マニュアル／様式集の改訂情報の［要領・マニュアルの詳細］ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Ut001_01Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Ut001_04GoYoryoManualController.class)
    public void goYoryoManualValidate(Ut001_01Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }
    /**
     *
     * <pre>
     * 要領・マニュアル／様式集の改訂情報の［様式の詳細］ボタンイベント固有の入力チェックを行ないます。
     * </pre>
     *
     * @param form Ut001_01Form
	 * @param errors Errors
	 * @param model Model
	 * @param request HttpServletRequest
     */
    @CrustValidationTarget(Ut001_05GoYoushikiController.class)
    public void goYoushikiValidate(Ut001_01Form form,  Errors errors, Model model,
			HttpServletRequest request) {

    }

}