//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut002_01UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut002.ut002_01.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.ut002.common.Ut002Constants;
import jp.go.jfc.partnernet.ut002.ut002_01.service.Ut002_01DTO;
import jp.go.jfc.partnernet.ut002.ut002_01.service.Ut002_01Service;

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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはut002_01の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("ut002_01Form")
@RequestMapping(value = "/Ut002_01Update.form")
public class Ut002_01UpdateController extends Ut002_01BaseController {

    /** Logger */
    private final Log log = LogFactory.getLog(Ut002_01UpdateController.class);

    /** Ut002_01Service */
    @Autowired
    Ut002_01Service ut002_01service;

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
    public String executeAction(Model model, Ut002_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 入力チェック
        try {

            byte[] arrSjis = form.getTxtID_ID_InfoContents()
                    .getBytes(Ut002Constants.CHARACTER_ENCODING_MS932);
            if (arrSjis.length > Ut002Constants.INFO_CONTENTS_MAX_BYTES) {
                // SJISで4000バイトを超えている。
                throw new PNServiceException(PNCommonMessageConstants.PM3180E,
                        new String[]{"お知らせ内容に入力された文字数が" + Ut002Constants.INFO_CONTENTS_MAX_BYTES + "バイト"},
                        false);
            }

        } catch (UnsupportedEncodingException e) {
            log.error("入力チェックにてエラー発生", e);
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
        }

        // 入力チェック後入力値をお知らせデータに登録または更新する。
        Ut002_01DTO inDto = new Ut002_01DTO();
        inDto.setDrpID_ID_InfoType(Integer.parseInt(form.getDrpID_ID_InfoType()));
        inDto.setTxtID_ID_InfoContents(form.getTxtID_ID_InfoContents());
        inDto.setDateTime_InfoUpdate(form.getDateTime_InfoUpdate());
        inDto.setDateTime_Update(form.getDateTime_Update());

        // ■サービス呼び出し
        Ut002_01DTO outDto = ut002_01service.updateNews(inDto);
        form.setTxtID_ID_InfoContents(outDto.getTxtID_ID_InfoContents());
        this.addMessage(errors, PNCommonMessageConstants.PM1060I, new String[]{""}, false);
        // 画面遷移情報に自画面を設定する。
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
    public void displayControl(Model model, Ut002_01Form form, HttpServletRequest request) {

    }
}