//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr012.common.Cr012Constants;
import jp.go.jfc.partnernet.cr012.cr012_01.service.Cr012_01M1DTO;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;

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
 * このクラスはcr012_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr012_01Form")
@RequestMapping(value = "/Cr012_01Init.form")
public class Cr012_01InitController extends Cr012_01BaseController {

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     *
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm,org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Cr012_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // フォームを初期化する。
        // メッセージを表示する。
        if (form.getLblMessageID() != null && !form.getLblMessageID().isEmpty()) {
            addMessage(errors, form.getLblMessageID(), new String[] { "" }, false);
            form.setLblMessageID(null);
        }
        // 報告年月日
        form.setLblID_Date_Report(PNCommonConstants.LITERAL_BLANK);
        List<Cr012_01M1DTO> m1List = new ArrayList<Cr012_01M1DTO>();
        Cr012_01M1DTO m1Dto = new Cr012_01M1DTO();

        // 包括委任状数量
        m1Dto.setTxtID_Su_HokatsuInin(PNCommonConstants.LITERAL_BLANK);
        // 現在事項一部証明書数量
        m1Dto.setTxtID_Su_GenzaiJiko(PNCommonConstants.LITERAL_BLANK);
        // 印鑑証明書数量
        m1Dto.setTxtID_Su_InkanShohmei(PNCommonConstants.LITERAL_BLANK);
        // 変更抄本数量
        m1Dto.setTxtID_Su_HenkoShohhon(PNCommonConstants.LITERAL_BLANK);
        // 新閉鎖謄本数量
        m1Dto.setTxtID_Su_SinHeisa(PNCommonConstants.LITERAL_BLANK);
        // 旧閉鎖抄本数量
        m1Dto.setTxtID_Su_KyuHeisa(PNCommonConstants.LITERAL_BLANK);
        // 閉鎖事項全部証明書数量
        m1Dto.setTxtID_Su_HeisaJiko(PNCommonConstants.LITERAL_BLANK);
        // 至急発行チェックボックス
        m1Dto.setChkID_ShikyuHakko(null);

        m1List.add(m1Dto);
        form.setMeisai_list(m1List);
        form.getCr012_01M1Table().setRecordList(m1List, m1List.size());

        // 扱店名
        form.setLblID_Code_Organization(PNCommonConstants.LITERAL_BLANK);
        // 扱店
        form.setLblID_Name_Organization(PNCommonConstants.LITERAL_BLANK);
        // 店舗
        form.setLblID_Code_Tenpo(PNCommonConstants.LITERAL_BLANK);

        // 業務日付取得（業務共通部品）より業務日付を求め、「yyyy年mm月dd日」の形式に編集しformの報告日に設定する。
        String strDate = pnCommonDBComponents.getToDayFormat(Cr012Constants.STR_DATE_FORMAT);
        if (strDate.isEmpty()) {
            throw new PNSystemException(PNCommonMessageConstants.PM9990E);
        }
        form.setLblID_Date_Report(strDate);

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
    public void displayControl(Model model, Cr012_01Form form, HttpServletRequest request) {
    }
}