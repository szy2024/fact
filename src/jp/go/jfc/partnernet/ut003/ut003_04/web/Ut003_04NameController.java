//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_04NameController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_04.web;

import java.util.LinkedList;
import java.util.List;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.ut003.common.Ut003Constants;
import jp.go.jfc.partnernet.ut003.ut003_04.service.Ut003_04M1DTO;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはut003_04の要領・マニュアル名アンカーコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_04Form")
@RequestMapping(value = "/Ut003_04Name.form")
public class Ut003_04NameController extends Ut003_04BaseController {

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
    public String executeAction(Model model, Ut003_04Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面でクリックされた行をリストから抽出して、ダウンロード機能を呼び出す。
        // 　文書ファイル名をダウンロード機能に受け渡す。
        int selectedIndex = Integer.parseInt(form.getSelectedIndex());
        Ut003_04M1DTO selectedData = form.getUt003_04M1TableRecord().get(selectedIndex);
        String filename = PNResourceBundle.getApplicationProperty(Ut003Constants.DOWNLOAD_PATH_YORYOMANUAL)
                + PNResourceBundle.getFileUtilsProperty(Ut003Constants.FILESEPARATOR_PROPERTY_NAME)
                + selectedData.getID_ID_DocFileName();
        List<String> fileList = new LinkedList<String>();
        fileList.add(filename);
        setFileDownload(request, fileList);

        // 戻り値（画面遷移情報）に自画面を設定する。
        // 　return MY_VIEW

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
    public void displayControl(Model model, Ut003_04Form form, HttpServletRequest request) {

    }
}