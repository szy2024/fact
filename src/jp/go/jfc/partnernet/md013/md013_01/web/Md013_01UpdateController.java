//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md013_01UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md013.md013_01.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md013.common.Md013Constants;
import jp.go.jfc.partnernet.md013.md013_01.service.Md013_01DTO;
import jp.go.jfc.partnernet.md013.md013_01.service.Md013_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

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
import org.springframework.web.multipart.MultipartFile;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはmd013_01の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 木村しのぶ
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md013_01Form")
@RequestMapping(value = "/Md013_01Update.form")
public class Md013_01UpdateController extends Md013_01BaseController {

    /** Md013_01Service */
    @Autowired
    Md013_01Service md013_01service;

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
    public String executeAction(Model model, Md013_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        /** Logger */
        final Log log = LogFactory.getLog(Md013_01UpdateController.class);

        // lblMessageIDをクリアする
        form.setLblMessageID(PNCommonConstants.LITERAL_BLANK);

        // Formより画面に入力されたデータをDTOに設定（form→inDto)
        Md013_01DTO inDto = new Md013_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        // ファイル選択確認
        MultipartFile fileUpload = inDto.getFileUpload();

        // アップロードフォルダパス
        StringBuilder sbUploadPath = new StringBuilder();

        // 受渡パラメータの操作選択が修正の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getLblID_ProcessMode())) {

            // 必須エラーチェック
            // ファイル名に入力されていない場合、エラーとする。
            // PM3120E{0}が入力されていません。※{0} ・・・【項目名】
            if (PNCommonConstants.LITERAL_BLANK.equals(fileUpload.getOriginalFilename())) {
                // ファイル未選択
                String[] strReplace = new String[] { "修正添付ファイル名" };
                throw new PNServiceException(PNCommonMessageConstants.PM3120E, strReplace, false);
            }

            // 拡張子チェック
            // 拡張子が pdf 以外の場合、エラーとする。
            if (!fileUpload.getOriginalFilename().toLowerCase().endsWith(Md013Constants.FILE_EXTENSION_PDF)) {
                throw new PNServiceException(PNCommonMessageConstants.ID_MSG_00017E);
            }

            try {
                String strDocName = fileUpload.getOriginalFilename();
                // 規定文字数エラーチェック
                byte[] arrSjis = null;
                // ファイル名に入力されてる文字数が256バイト以下ではない場合、エラーとする。
                // PM3180E{0}を超えています。※{0} ・・・修正添付ファイル名の文字数が【最大桁数】バイト
                arrSjis = strDocName.getBytes(Md013Constants.CHARACTER_ENCODING_MS932);
                if (arrSjis.length > Md013Constants.TXTID_ID_DOCNAME_MAX_BYTES) {
                    // ファイル名がSJISで256バイトを超えている。
                    StringBuffer sbMessage = new StringBuffer();
                    sbMessage.append("修正添付ファイル名の文字数が");
                    sbMessage.append(Md013Constants.TXTID_ID_DOCNAME_MAX_BYTES);
                    sbMessage.append(Md013Constants.REPLACE_STR_BYTE);
                    String[] strReplace = new String[] { sbMessage.toString() };
                    throw new PNServiceException(PNCommonMessageConstants.PM3180E, strReplace, false);
                }

                // 修正添付ファイル名を設定
                inDto.setLblID_DocName(strDocName);

                // アップロードファイル名を設定
                String fileName = strDocName;
                inDto.setLblID_UploadFilePath(fileName);

                // アップロードパスを編集する。
                // apprication.propertiesから保存先のパスを編集する。
                // アップロードファイルパスエラー
                String teitokenUploadPath =
                        PNResourceBundle.getApplicationProperty(Md013Constants.UPLOAD_PATH_TEITOKEN);
                String fileSeparator =
                        PNResourceBundle.getFileUtilsProperty(Md013Constants.FILESEPARATOR_PROPERTY_NAME);
                if (teitokenUploadPath.isEmpty() || fileSeparator.isEmpty()) {
                    // Web.configにアップロードフォルダのキーが記述されていないなど、
                    // アップロードフォルダのURLが取得できない場合、エラーとする。
                    // PM3190E{0}の取得に失敗しました。※{0} ・・・アップロード先
                    String[] strReplace = new String[] { "アップロード先" };
                    throw new PNServiceException(PNCommonMessageConstants.PM3190E, strReplace, false);
                }

                // 保存先の設定
                sbUploadPath.append(teitokenUploadPath);
                sbUploadPath.append(fileSeparator);
                sbUploadPath.append(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
                sbUploadPath.append(fileSeparator);
                if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(PNCommonInfoHolder.getCommonInfo().getRoleCode())
                        || PNCommonConstants.ROLECODE_NOURINSHITEN.equals(PNCommonInfoHolder.getCommonInfo()
                                .getRoleCode())) {
                    sbUploadPath.append(PNCommonInfoHolder.getCommonInfo().getCode_Tenpo());
                    sbUploadPath.append(fileSeparator);
                }

                // アップロードファイルを格納するディレクトリを作成する
                File uploadDir = new File(sbUploadPath.toString());
                // アップロードフォルダが存在しない場合
                if (!uploadDir.exists()) {
                    // フォルダを作成する。
                    uploadDir.mkdirs();
                }

                // アップロードフルパス規定文字数エラーチェック
                // アップロードフォルダパス＋アップロード対象ファイル名
                // （添付ファイルから取得）が256バイト以下でない場合、エラーとする。
                // PM3180E{0}を超えています。※{0} ・・・ファイル名がフルパスで256バイト
                String uploadPath = sbUploadPath.toString() + fileName;
                arrSjis = uploadPath.getBytes(Md013Constants.CHARACTER_ENCODING_MS932);
                if (arrSjis.length > Md013Constants.TXTID_ID_DOCNAME_MAX_BYTES) {
                    StringBuffer sbMessage = new StringBuffer();
                    sbMessage.append("ファイル名がフルパスで");
                    sbMessage.append(Md013Constants.TXTID_ID_DOCNAME_MAX_BYTES);
                    sbMessage.append(Md013Constants.REPLACE_STR_BYTE);
                    String[] strReplace = new String[] { sbMessage.toString() };
                    // 文書名がSJISで256バイトを超えている。
                    throw new PNServiceException(PNCommonMessageConstants.PM3180E, strReplace, false);
                }

                // ファイル存在チェックを行う。
                // アップロード先に添付ファイルと同名のファイルが既に存在する かつ
                // 添付ファイルのファイル名が登録済ファイル名と異なる場合
                // エラーメッセージ：PM3900E
                // 指定されたファイル名は既に存在しています。ファイル名を変えてアップロードしてください。
                File uploadFile = new File(uploadPath);
                if (uploadFile.exists() && !fileName.equalsIgnoreCase(form.getLblID_Regist_DocName())) {
                    throw new PNServiceException(PNCommonMessageConstants.PM3900E);
                }

                // 添付ファイルアップロード先パスを設定
                inDto.setLblID_UploadFilePath(uploadPath);

            }
            catch (UnsupportedEncodingException e) {
                log.error("入力チェックにてエラー発生", e);
                throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
            }
        }

        // アップロード済みファイル削除
        // 添付ファイルアップロード先パスのファイルの存在チェックを行う。
        // 添付ファイルアップロード先パスにファイルが存在する場合、ファイルの削除を行う。
        // 削除失敗時、エラーとする。
        // メッセージ：システムエラーが発生しました。日本政策金融公庫までご連絡ください。(PM9990E)
        String uploadZumiPath = form.getLblID_KeepUploadFilePath();
        File uploadZumiFile = new File(uploadZumiPath);
        if (uploadZumiFile.exists()) {
            // アップロード済みファイルが存在する場合、削除
            if (!this.deleteFile(uploadZumiFile, false)) {
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }
        }

        // 受渡パラメータの操作選択が修正の場合
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getLblID_ProcessMode())) {

            // アップロード機能を呼び出す。
            try {

                // アップロード機能呼出し
                File uploadfilePath = this.writeUploadFile(fileUpload, sbUploadPath.toString());
                log.debug("filePath=" + uploadfilePath.getPath());

            }
            catch (IOException e) {
                log.error("ファイルアップロードに失敗しました");
                throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
            }

            // サービスを実行し、修正処理を行う。
            md013_01service.updateDataMod(inDto);

            // メッセージＩＤ：PM1160I データの修正が完了しました。
            form.setLblMessageID(PNCommonMessageConstants.PM1160I);

        }
        else {

            // 上記以外（受渡パラメータの操作選択が取消）の場合、サービスを実行し削除処理を行う。
            md013_01service.updateDataDel(inDto);

            // メッセージＩＤ：PM1170I データの取消が完了しました。
            form.setLblMessageID(PNCommonMessageConstants.PM1170I);

        }

        // 更新済フラグに1（更新済）を設定
        form.setLblID_Flag_Koushinzumi(Md013Constants.FLAG_KOUSHINZUMI);

        // 戻り値（画面遷移情報）に自画面を設定する。
        return success(Md013Constants.EVENT_ID_MD013_01INIT);
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
    public void displayControl(Model model, Md013_01Form form, HttpServletRequest request) {

    }
}