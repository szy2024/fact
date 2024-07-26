//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr002_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/25 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/12/01 | 百々　諒馬            | 委託貸付報告等における機能改善
//==================================================================================================
package jp.go.jfc.partnernet.cr002.cr002_01.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr002.common.Cr002Constants;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01DTO;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01M1DTO;
import jp.go.jfc.partnernet.cr002.cr002_01.service.Cr002_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr002_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr002_01Form")
@RequestMapping(value = "/Cr002_01Init.form")
public class Cr002_01InitController extends Cr002_01BaseController {

    /** Cr002_01Service */
    @Autowired
    Cr002_01Service cr002_01service;

    /** 画面の送信ボタン名 */
    public static final String JSP_ITEM_ID_BTNUPDATE2 = "btnUpdate2";
    /** 明細ID */
    public static final String ID_MEISAI = "cr002_01M1Table";

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
    public String executeAction(Model model, Cr002_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        
        // 表示項目の取得
        // Cr002_01DTO inCr002_01DTO = new Cr002_01DTO();
        Cr002_01DTO inCr002_01DTO = new Cr002_01DTO();
        PNPagingTable<Cr002_01M1DTO> m1DTO = form.getCr002_01M1Table();
        m1DTO.reset();
        // 送信ボタン非表示
        form.setVisible(JSP_ITEM_ID_BTNUPDATE2, false);
        // 明細非表示
        form.setVisible(ID_MEISAI, false);

        // Serviceの呼び出し
        // Cr002_01DTO outCr002_01DTO = cr002_01service.getInputData(inCr002_01DTO);
        Cr002_01DTO outCr002_01DTO = cr002_01service.getInputData(inCr002_01DTO);

        // 取得した貸付受入金払出・充当報告書一覧が０件の場合
        if (0 == outCr002_01DTO.getResultData_Kensu()) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E, new String[] { "該当案件はありません。" },
                    false));
            throw new PNServiceException(bizErrors);
        }

        form.setTxtID_Date_Report(outCr002_01DTO.getTxtID_Date_Report());
        // 受託者勘定処理年月設定モード
        form.setLblID_JtkshoriConfigMode(outCr002_01DTO.getLblID_JtkshoriConfigMode());
        // 業務日付（元号）
        form.setLblID_BizDate_Gengo(outCr002_01DTO.getLblID_BizDate_Gengo());
        // 業務日付（年）
        form.setLblID_BizDate_Nen(outCr002_01DTO.getLblID_BizDate_Nen());
        // 業務日付（月）
        form.setLblID_BizDate_Tsuki(outCr002_01DTO.getLblID_BizDate_Tsuki());
        // 前月業務日付（元号）
        form.setLblID_BizDate_PrevMonth_Gengo(outCr002_01DTO.getLblID_BizDate_PrevMonth_Gengo());
        // 前月業務日付（年）
        form.setLblID_BizDate_PrevMonth_Nen(outCr002_01DTO.getLblID_BizDate_PrevMonth_Nen());
        // 前月業務日付（月）
        form.setLblID_BizDate_PrevMonth_Tsuki(outCr002_01DTO.getLblID_BizDate_PrevMonth_Tsuki());
        // 取得した貸付受入金払出・充当報告書一覧をフォームに設定する。
        m1DTO.setResultsPerPage(outCr002_01DTO.getMEISAI_LIST().size());
        m1DTO.setRecordList(outCr002_01DTO.getMEISAI_LIST(), outCr002_01DTO.getMEISAI_LIST().size());
        form.setCODE_KURISHOJIYU_PULLDOWN_LIST(outCr002_01DTO.getCODE_KURISHOJIYU_PULLDOWN_LIST());
        // 送信ボタン表示
        form.setVisible(JSP_ITEM_ID_BTNUPDATE2, true);
        // 明細表示
        form.setVisible(ID_MEISAI, true);

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
    public void displayControl(Model model, Cr002_01Form form, HttpServletRequest request) {

        // 表示した全案件に対し、チェックボックスの入力可否を設定する。
        // （１）「選択」チェックボックス
        // メッセージ２に表示データがある場合、「選択」チェックボックスを入力不可に設定する。
        int rowindex = 0;
        PNPagingTable<Cr002_01M1DTO> m1DTO = form.getCr002_01M1Table();
        List<Cr002_01M1DTO> m1TableList = m1DTO.getRecordList();
        for (Cr002_01M1DTO m1Table : m1TableList) {
            if (null != (m1Table.getID_Create_NG()) && 0 < m1Table.getID_Create_NG().length()) {
                form.setProtect("cr002_01M1Table.recordList[" + rowindex + "].chkUpdate", true);
            }
            else {
                form.setProtect("cr002_01M1Table.recordList[" + rowindex + "].chkUpdate", false);
            }
            rowindex++;
        }
        // 受託者勘定処理年月設定モード：1（決算期かつ第1～4営業日）または
        // 受託者勘定処理年月設定モード：2（決算期かつ第5～最終営業日）または
        // 受託者勘定処理年月設定モード：4（通常期かつ第11～最終営業日）の場合
        if (PNCommonConstants.JTKSHORI_CONFIGMODE_1.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_2.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_4.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月 非活性
            for (int i = 0; i < form.getCr002_01M1TableRecord().size(); i++) {
                String itemName = PNCommonComponents.concatString(
                        Cr002Constants.JSP_ITEM_RECORDLIST, String.valueOf(i));

                // 受託者勘定処理年月（元号） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO), true);
                // 受託者勘定処理年月（年） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN), true);
                // 受託者勘定処理年月（月） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE), true);

            }

        }
        // 受託者勘定処理年月設定モード：3（通常期かつ第1～10営業日）の場合
        else if (PNCommonConstants.JTKSHORI_CONFIGMODE_3.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月 活性
            for (int i = 0; i < form.getCr002_01M1TableRecord().size(); i++) {
                String itemName = PNCommonComponents.concatString(
                        Cr002Constants.JSP_ITEM_RECORDLIST, String.valueOf(i));

                // 受託者勘定処理年月（元号） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO), false);
                // 受託者勘定処理年月（年） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN), false);
                // 受託者勘定処理年月（月） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr002Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE), false);

            }

        }

    }
}