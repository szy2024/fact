//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_03DeleteController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_03.web;

import java.io.File;
import java.util.List;

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.ut003.common.Ut003Constants;
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03M1DTO;
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03Service;
import jp.go.jfc.partnernet.ut003.ut003_03.service.Ut003_03DTO;

/**
 * <pre>
 * このクラスはut003_03の削除ボタンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut003_03Form")
@RequestMapping(value = "/Ut003_03Delete.form")
public class Ut003_03DeleteController extends Ut003_03BaseController {

    /** Ut003_03Service */
    @Autowired
    Ut003_03Service ut003_03service;

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
    public String executeAction(Model model, Ut003_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 削除チェックボックスがチェックされたデータに対して下記処理を行う。

        // 　・データ番号をDTOに設定する。
        // 　・Ut003_03Service.delete
        // 　・画面でチェックされた文書ファイルを削除

        // 削除失敗時、エラーカウンタに1加算
        // 　メッセージ ：①エラーカウンタが０の時
        // 　　　　　　　　　　削除処理が完了しました。(PM1080I)
        // ②エラーカウンタが１以上の場合
        // 　　　　　　　　　　システムエラーが発生しました。日本政策金融公庫までご連絡ください。(PM9990E)
        int errorCount = 0;
        List<Ut003_03M1DTO> kinrijyohoList = form.getUt003_03M1Table().getRecordList();
        for (Ut003_03M1DTO kinrijyoho : kinrijyohoList) {

            if (null == kinrijyoho.getChkDelete()) {
                continue;
            }

            Ut003_03DTO inUt003_03DTO = new Ut003_03DTO();
            inUt003_03DTO.setKinriJyoho(kinrijyoho);
            ut003_03service.delete(inUt003_03DTO);

            String filename = PNResourceBundle
                    .getApplicationProperty(Ut003Constants.DOWNLOAD_PATH_KINRIJYOHO)
                    + PNResourceBundle.getFileUtilsProperty(Ut003Constants.FILESEPARATOR_PROPERTY_NAME)
                    + kinrijyoho.getID_ID_DocFileName();
            File file = new File(filename);
            if (!PNCommonComponents.deleteFile(file)) {
                errorCount++;
                continue;
            }

        }

        if (PNCommonConstants.RECORD_COUNT_ZERO == errorCount) {
            this.addForwardParameter(request, Ut003Constants.PROPERTY_MSG_ID,
                    PNCommonMessageConstants.PM1080I);
        }

        if (PNCommonConstants.RECORD_COUNT_ZERO < errorCount) {
            this.addForwardParameter(request, Ut003Constants.PROPERTY_MSG_ID,
                    PNCommonMessageConstants.PM9990E);
        }

        // 戻り値（画面遷移情報）に下記を設定する。
        // 　success("Ut003_03Pageing")

        return success(Ut003Constants.EVENT_ID_UT003_03PAGEING);
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
    public void displayControl(Model model, Ut003_03Form form, HttpServletRequest request) {

    }
}