//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_03AncrDocNameController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.ut001.common.Ut001Constants;
import jp.go.jfc.partnernet.ut001.ut001_03.service.Ut001_03M1DTO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはUt001_03の「金利情報ファイル」アンカーコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut001_03Form")
@RequestMapping(value = "/Ut001_03AncrDocName.form")
public class Ut001_03AncrDocNameController extends Ut001_03BaseController {

    /** Logger */
    private final Log log = LogFactory.getLog(Ut001_03AncrDocNameController.class);

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, ut001_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面でクリックされた行をリストから抽出して、ダウンロード機能を呼び出す。

        int selectedIndex = Integer.parseInt(form.getSelectedIndex());
        Ut001_03M1DTO selectedData = form.getUt001_03M1TableRecord().get(selectedIndex);
        log.debug("selectedData.getID_ID_DocName     = " + selectedData.getID_ID_DocName());
        log.debug("selectedData.getID_DocFileName = " + selectedData.getID_DocFileName());
        log.debug("selectedData.getID_DateTime_DocUpdate = " + selectedData.getID_DateTime_DocUpdate());

        String filename = PNResourceBundle.getApplicationProperty(Ut001Constants.DOWNLOAD_PATH_KINRIJYOHO)
                + PNResourceBundle.getFileUtilsProperty(Ut001Constants.FILESEPARATOR_PROPERTY_NAME)
                + selectedData.getID_DocFileName();
        log.debug("filenam = " + filename);
        List<String> fileList = new LinkedList<String>();
        fileList.add(filename);

        setFileDownload(request, fileList);
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, ut001_03Form form, HttpServletRequest request) {

    }
}