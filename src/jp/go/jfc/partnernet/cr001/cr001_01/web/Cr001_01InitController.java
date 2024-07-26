//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_01.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr001.common.Cr001Constants;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01DTO;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01M1DTO;
import jp.go.jfc.partnernet.cr001.cr001_01.service.Cr001_01Service;
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
 * このクラスはCr001_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr001_01Form")
@RequestMapping(value = "/Cr001_01Init.form")
public class Cr001_01InitController extends Cr001_01BaseController {

    /** Cr001_01Service */
    @Autowired
    Cr001_01Service cr001_01service;

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
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Cr001_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // １．表示前処理
        // Form項目の初期化
        PNPagingTable<Cr001_01M1DTO> cr001_01m1Table = form.getCr001_01M1Table();
        cr001_01m1Table.reset();
        // Cr001_01Service.getInputData
        // DTOの生成
        Cr001_01DTO inDto = new Cr001_01DTO();
        List<Cr001_01M1DTO> inM1DtoList = new ArrayList<Cr001_01M1DTO>(1);
        Cr001_01M1DTO inM1Dto = new Cr001_01M1DTO();

        // ログインユーザの扱店コードを取得する
        // 権限情報を取得します
        String codeOrganization = "";
        String codeUserID = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、扱店コードを代入します
        if (null != commonInfo) {
            codeOrganization = commonInfo.getCode_Organization();
            codeUserID = commonInfo.getLogonID();
        }

        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDto, form);
        // ログインユーザの扱店コードを設定する
        inM1Dto.setID_Code_Organization(codeOrganization);
        // ログインユーザのユーザIDを設定する
        inM1Dto.setID_UserID(codeUserID);
        inM1DtoList.add(inM1Dto);
        inDto.setMEISAI_LIST(inM1DtoList);
        // Serviceの呼び出し
        Cr001_01DTO outDto = cr001_01service.getInputData(inDto);

        // 取得した貸付実行報告書一覧をフォームに設定する。
        CFWBeanUtils.copyProperties(form, outDto);
        // Formへの転記処理をここに実装
        if (0 < outDto.getMEISAI_LIST().size()) {
            cr001_01m1Table.setResultsPerPage(outDto.getMEISAI_LIST().size());
        }
        cr001_01m1Table.setRecordList(outDto.getMEISAI_LIST(), outDto.getMEISAI_LIST().size());
        form.setCr001_01M1Table(cr001_01m1Table);
        form.setVisible(Cr001Constants.JSP_ITEM_ID_LBLDATAMSG2, true);
        form.setVisible(Cr001Constants.JSP_ITEM_ID_BTNUPDATE2, true);

        if (0 < outDto.getBizErrors().size()) {
            form.setVisible(Cr001Constants.JSP_ITEM_ID_LBLDATAMSG2, false);
            form.setVisible(Cr001Constants.JSP_ITEM_ID_BTNUPDATE2, false);
            // エラーリストの初期化
            LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
            bizErrors.addAll(outDto.getBizErrors());
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

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
    public void displayControl(Model model, Cr001_01Form form, HttpServletRequest request) {

        // 受託者勘定処理年月設定モード：1（決算期かつ第1～4営業日）または
        // 受託者勘定処理年月設定モード：2（決算期かつ第5～最終営業日）または
        // 受託者勘定処理年月設定モード：4（通常期かつ第11～最終営業日）の場合
        if (PNCommonConstants.JTKSHORI_CONFIGMODE_1.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_2.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_4.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月 非活性
            for (int i = 0; i < form.getCr001_01M1TableRecord().size(); i++) {
                String itemName = PNCommonComponents.concatString(
                        Cr001Constants.JSP_ITEM_RECORDLIST, String.valueOf(i));

                // 受託者勘定処理年月（元号） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO), true);
                // 受託者勘定処理年月（年） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN), true);
                // 受託者勘定処理年月（月） 非活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE), true);

            }

        }
        // 受託者勘定処理年月設定モード：3（通常期かつ第1～10営業日）の場合
        else if (PNCommonConstants.JTKSHORI_CONFIGMODE_3.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月 活性
            for (int i = 0; i < form.getCr001_01M1TableRecord().size(); i++) {
                String itemName = PNCommonComponents.concatString(
                        Cr001Constants.JSP_ITEM_RECORDLIST, String.valueOf(i));

                // 受託者勘定処理年月（元号） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO), false);
                // 受託者勘定処理年月（年） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN), false);
                // 受託者勘定処理年月（月） 活性
                form.setProtect(PNCommonComponents.concatString(
                        itemName, Cr001Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE), false);

            }

        }

    }

}
