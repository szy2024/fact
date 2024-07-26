//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se006_17DownloadController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_17.web;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.se006.se006_17.service.Se006_17DTO;
import jp.go.jfc.partnernet.se006.se006_17.service.Se006_17Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <pre>
 * このクラスはse006_17のダウンロードボタンコントローラークラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se006_17Form")
@RequestMapping(value = "/Se006_17Download.form")
public class Se006_17DownloadController extends Se006_17BaseController {

    /** Se006_17Service */
    @Autowired
    Se006_17Service se006_17service;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Se006_17Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        /** Logger */
        final Log log = LogFactory.getLog(Se006_17DownloadController.class);

        // ■対象データの存在チェックを行う。
        // 　サービスを実行し、対象データの件数を取得する。
        Se006_17DTO inDTO = new Se006_17DTO();
        inDTO.setLblID_Report(form.getLblID_Report());

        // Serviceの呼び出し
        Se006_17DTO outDTO = se006_17service.getResultsData(inDTO);

        if (outDTO.getBizErrors().size() > 0) {
            // エラー件数 ＞ ０件の場合エラーとする。
            // 　PM9030E　他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        if (!outDTO.getLblID_Disp_DocName().equals(form.getLblID_Disp_DocName())) {
            // outDTO.表示ファイル名がform.表示ファイル名と異なる場合エラーとする。
            // 　PM9030E　他のユーザによってデータが更新されています。再検索を行ってください。
            throw new PNServiceException(PNCommonMessageConstants.PM9030E);
        }

        // 画面でクリックされたダウンロードボタンの行をリストから抽出して、ダウンロード機能を呼び出す。
        String filename = form.getLblID_UploadFilePath();

        // ■添付ファイルアップロード先パスのファイルの存在チェックを行う。
        File uploadFile = new File(filename);
        if (!uploadFile.exists()) {
            // 　添付ファイルアップロード先パスにファイルが存在しない場合、エラーとする。
            // 　　　PM9040E　ファイルが存在しません。
            throw new PNServiceException(PNCommonMessageConstants.PM9040E);
        }

        // ダウンロード機能を呼び出す。
        // 　添付ファイルアップロード先パスをダウンロード機能に受け渡す。
        List<String> fileList = new LinkedList<String>();
        fileList.add(filename);
        setFileDownload(request, fileList);

        log.info("ダウンロード元ファイル[" + filename + "]");

        // 自画面を表示する。
        return MY_VIEW;
    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Se006_17Form form,
            HttpServletRequest request) {

    }
}