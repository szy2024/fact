//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/15 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/01 | 林　晃平              | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_02.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;
import jp.go.jfc.partnernet.cr006.cr006_02.service.Cr006_02DTO;
import jp.go.jfc.partnernet.cr006.cr006_02.service.Cr006_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;

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
 * このクラスはcr006_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr006_02Form")
@RequestMapping(value = "/Cr006_02Init.form")
public class Cr006_02InitController extends Cr006_02BaseController {

    /** Cr006_02Service */
    @Autowired
    Cr006_02Service cr006_02service;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Cr006_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();
        // 画面項目(form)初期化
        clearScreen(form);
        // 画面項目表示
        form.setVisible(Cr006Constants.ID_PNL, true);
        form.setVisible(Cr006Constants.JSP_ITEM_BTNID_SEND, true);

        // ログイン権限取得
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        String strUserID = loginInfo.getLogonID();

        // 受渡パラメータを取得する。
        // Map<String, Object> mpIFPara = getForwardParameter(request);
        mappingForwardParameterToForm(request, form);

        // 初期表示データの取得
        // DTO定義
        Cr006_02DTO inDto = new Cr006_02DTO();
        // Form⇒DTOにデータを転記する。
        CFWBeanUtils.copyProperties(inDto, form);

        // 仮受仮払精算後残高（計算用）⇒受取_現在の立替金残高(円)を設定
        inDto.setID_M_KaribaraiZanAfterSeisan(form.getCr006_02_ID_M_KaribaraiZanAfterSeisan().replaceAll(
                Cr006Constants.LITERAL_COMMA, PNCommonConstants.LITERAL_BLANK));
        // 本支店コード⇒受取_本支店コードを設定
        inDto.setID_Code_HonShiten(form.getCr006_02_ID_Code_HonShiten2());
        // 仮受仮払番号⇒受取_仮受仮払番号を設定
        inDto.setID_ID_Karibarai(form.getCr006_02_ID_ID_Karibarai());

        // Serviceの呼び出し
        Cr006_02DTO outDto = cr006_02service.getInitData(inDto);

        // Cr006_02DTO.先行報告書の有無がFALSEの場合
        // if (false == outDto.getID_Previous_Report()) {
        // // メッセージを追加
        // String strMsg = PNCommonComponents.concatString("（先行する報告書(", outDto.getID_Previous_ReportType(),
        // ")が未完了のため選択できません。）");
        // bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E, new String[]{strMsg}, false));
        // // Formへの転記処理をここに実装
        // form.setLblMessage(strMsg);
        // // throw new PNServiceException(bizErrors);
        // }

        // Form項目の初期化
        CFWBeanUtils.copyProperties(form, outDto);

        // エラー有の場合自画面表示
        if (0 < outDto.getBizErrors().size()) {
            bizErrors.addAll(outDto.getBizErrors());
            form.setVisible(Cr006Constants.ID_PNL, false);
            form.setVisible(Cr006Constants.JSP_ITEM_BTNID_SEND, false);
            throw new PNServiceException(bizErrors);
        }

        // 公庫立替日：立替日
        form.setTxtID_Date_KoukoTatekae(form.getCr006_02_ID_Date_Karibarai());
        // ユーザID：ログオンユーザID
        form.setID_UserID(strUserID);
        // 伝送番号：空文字
        form.setID_ID_Denso("");
        // データコード："90257090"
        form.setID_DataCode(PNCommonConstants.DATACODE_90257090);
        // ステータス：1
        form.setID_Status("1");
        // 取消済フラグ：0
        form.setID_Flag_Torikeshizumi("0");
        // 処理種別："00"
        form.setID_Type_Process("00");
        // 原本番号：NULL
        form.setID_ID_Master(null);
        // 立替金（円）
        form.setTxtID_M_Tatekae(PNCommonConstants.LITERAL_BLANK);
        // 計（円）
        form.setTxtID_M_Kei(PNCommonConstants.LITERAL_BLANK);
        // 立替金利息(円)
        form.setTxtID_M_TatekaeRisoku(PNCommonConstants.LITERAL_BLANK);
        // 送金額（円）
        form.setTxtID_M_Sokin(PNCommonConstants.LITERAL_BLANK);

        // 自画面を呼び出す

        return MY_VIEW;
    }

    /**
     * <pre>
     * 画面項目を初期化する。
     * </pre>
     *
     */
    private void clearScreen(Cr006_02Form form) {
        /** 報告年月日 */
        form.setTxtID_Date_Report("");
        /** ステータス */
        form.setLblError("");
        /** メッセージ */
        form.setLblMessage("");
        /** 顧客名 */
        form.setTxtID_Name_Customer("");
        /** 扱店名 */
        form.setTxtID_Name_Organization("");
        /** 公庫支店 */
        form.setTxtID_Code_KoukoShiten("");
        /** 扱店 */
        form.setTxtID_Code_Organization("");
        /** 店舗 */
        form.setTxtID_Code_Tenpo("");
        /** 年度 */
        form.setTxtID_Year("");
        /** 方式資金 */
        form.setTxtID_Code_HoshikiShikin("");
        /** 番号 */
        form.setTxtID_ID_Ringi("");
        /** 枝番 */
        form.setTxtID_ID_RingiBranch("");
        /** 入金日(年号) */
// [UPD] Ver 3.0.0 - START
//        form.setDrpID_Date_Nyukin_Gengou("H");
      form.setDrpID_Date_Nyukin_Gengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        /** 入金日(年) */
        form.setTxtID_Date_Nyukin_Year("");
        /** 入金日(月) */
        form.setDrpID_Date_Nyukin_Month("");
        /** 入金日(日) */
        form.setDrpID_Date_Nyukin_Day("");
        /** 立替金利息(円) */
        form.setTxtID_M_TatekaeRisoku("");
        /** 立替金（円） */
        form.setTxtID_M_Tatekae("");
        /** 仮受金(一般口)からの充当額（円） */
        form.setTxtID_M_KariukeIppanJuto("");
        /** 立替金の種類 */
        form.setTxtID_Code_TatekaekinShurui("");
        /** 公庫立替日 */
        form.setTxtID_Date_KoukoTatekae("");
        /** 計（円） */
        form.setTxtID_M_Kei("");
        /** 送金額（円） */
        form.setTxtID_M_Sokin("");
        /** 受入後立替金残高（円） */
        form.setTxtID_M_TatekaeZanAfterUkeire("");
        /** 受託者勘定処理年月(年号) */
// [UPD] Ver 3.0.0 - START
//        form.setDrpID_Date_Jtkshori_Gengou("H");
        form.setDrpID_Date_Jtkshori_Gengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        /** 受託者勘定処理年月(年) */
        form.setTxtID_Date_Jtkshori_Year("");
        /** 受託者勘定処理年月(月) */
        form.setDrpID_Date_Jtkshori_Month("");
        /** 送金年月日(年号) */
// [UPD] Ver 3.0.0 - START
//      form.setDrpID_Date_Sokin_Gengou("H");
      form.setDrpID_Date_Sokin_Gengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        /** 送金年月日(年) */
        form.setTxtID_Date_Sokin_Year("");
        /** 送金年月日(月) */
        form.setDrpID_Date_Sokin_Month("");
        /** 送金年月日(日) */
        form.setDrpID_Date_Sokin_Day("");
        /** 送金日番号 */
        form.setTxtID_Code_Sokin("");
        /** 原本番号 */
        form.setID_ID_Master("");
        /** ユーザID */
        form.setID_UserID("");
        /** データコード */
        form.setID_DataCode("");
        /** ステータス(非表示) */
        form.setID_Status("");
        /** 取消済フラグ */
        form.setID_Flag_Torikeshizumi("");
        /** 処理種別 */
        form.setID_Type_Process("");
        /** 先行報告書の有無 */
        form.setID_Previous_Report(false);
        /** 先行報告書の種類 */
        form.setID_Previous_ReportType("");
        /** 仮受仮払精算後残高（計算用） */
        form.setID_M_KaribaraiZanAfterSeisan("");
        /** 本支店コード */
        form.setID_Code_HonShiten("");
        /** 仮受仮払番号 */
        form.setID_ID_Karibarai("");
        /** 入金日 */
        form.setID_Date_Nyukin("");
        /** 受託者勘定処理年月 */
        form.setID_Date_Jtkshori("");
        /** 送金年月日 */
        form.setID_Date_Sokin("");
        /** 最新データ更新日付 */
        form.setID_Data_LastUpDate("");
        /** 伝送番号 */
        form.setID_ID_Denso("");

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
    public void displayControl(Model model, Cr006_02Form form, HttpServletRequest request) {

        // 受託者勘定処理年月設定モード：1（決算期かつ第1～4営業日）または
        // 受託者勘定処理年月設定モード：2（決算期かつ第5～最終営業日）または
        // 受託者勘定処理年月設定モード：4（通常期かつ第11～最終営業日）の場合
        if (PNCommonConstants.JTKSHORI_CONFIGMODE_1.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_2.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_4.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月（元号） 非活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGOU, true);
            // 受託者勘定処理年月（年） 非活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_YEAR, true);
            // 受託者勘定処理年月（月） 非活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_MONTH, true);

        }
        // 受託者勘定処理年月設定モード：3（通常期かつ第1～10営業日）の場合
        else if (PNCommonConstants.JTKSHORI_CONFIGMODE_3.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月（元号） 活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGOU, false);
            // 受託者勘定処理年月（年） 活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_YEAR, false);
            // 受託者勘定処理年月（月） 活性
            form.setProtect(Cr006Constants.JSP_ITEM_ID_DATE_JTKSHORI_MONTH, false);

        }

    }

}