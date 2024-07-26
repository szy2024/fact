//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_02.web;

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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.md006.md006_02.service.Md006_02Service;
import jp.go.jfc.partnernet.md006.md006_02.service.Md006_02DTO;

/**
 * <pre>
 * このクラスはmd006_02の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md006_02Form")
@RequestMapping(value = "/Md006_02Create.form")
public class Md006_02CreateController extends Md006_02BaseController {

    /** Md006_02Service */
    @Autowired
    Md006_02Service md006_02service;

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
    public String executeAction(Model model, Md006_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        Md006_02DTO inMd006_02DTO = new Md006_02DTO();

        if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_PROCEND_DEL)) {
            // 処理モードが、処理完了：取消(1)の場合
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ
            inMd006_02DTO = setUpdateData(form, true, false);
            // Serviceの呼び出し
            md006_02service.updateDataProcEndDel(inMd006_02DTO);
        } else if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_PROCEND_MOD)) {
            // 処理モードが、処理完了：修正(2)の場合
            // 　更正（赤）データの登録
            // 引数：更正（赤）データ、修正データ
            inMd006_02DTO = setUpdateData(form, true, true);
            // Serviceの呼び出し
            md006_02service.updateDataProcEndMod(inMd006_02DTO);
        } else if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL)) {
            // 処理モードが、処理完了以外：取消(3)の場合
            // 　画面表示時に取得したレコードに対する取消処理
            // 引数：更正（赤）データ
            inMd006_02DTO = setUpdateData(form, true, false);
            // Serviceの呼び出し
            md006_02service.updateDataNotProcEndDel(inMd006_02DTO);
        } else if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD)) {
            // 処理モードが、処理完了以外：修正(4)の場合
            // 　更正（黒）データの登録
            // 引数：更正（黒）データ
            inMd006_02DTO = setUpdateData(form, false, true);
            // Serviceの呼び出し
            md006_02service.updateDataNotProcEndMod(inMd006_02DTO);
        } else if (form.getProcessMode().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL)) {
            // 処理モードが、処理完了以外：取消更正(赤)(5)の場合
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ
            inMd006_02DTO = setUpdateData(form, true, false);
            // Serviceの呼び出し
            md006_02service.updateDataNotProcEndDelCalcel(inMd006_02DTO);
        }

        // メッセージに追加完了メッセージを設定する。
        // 　追加完了メッセージ：PM1060I

        // 画面にエラーメッセージが設定されていない場合、画面遷移を行う。
        // 　登録結果画面へ遷移する
        return success("Md006_03Init");

        // return MY_VIEW;
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
    public void displayControl(Model model, Md006_02Form form, HttpServletRequest request) {

    }

    private Md006_02DTO setUpdateData(Md006_02Form form, boolean redFlg, boolean blackFlg) {
        Md006_02DTO inDto = new Md006_02DTO();

        inDto.setLblID_ID_Report(form.getID_ID_Report());
        inDto.setLblID_Date_Report(form.getLblID_Date_Report());
        if (redFlg) {
            inDto.setLblID_Name_Customer_Red(form.getLblID_Name_Customer_Red());
            inDto.setLblID_Name_Organization_Red(form.getLblID_Name_Organization_Red());
            inDto.setLblID_Code_KoukoShiten_Red(form.getLblID_Code_KoukoShiten_Red());
            inDto.setLblID_Code_Organization_Red(form.getLblID_Code_Organization_Red());
            inDto.setLblID_Code_Tenpo_Red(form.getLblID_Code_Tenpo_Red());
            inDto.setLblID_Year_Red(form.getLblID_Year_Red());
            inDto.setLblID_Kubun_HoshikiShikin_Red(form.getLblID_Kubun_HoshikiShikin_Red());
            inDto.setLblID_ID_Ringi_Red(form.getLblID_ID_Ringi_Red());
            inDto.setLblID_ID_RingiBranch_Red(form.getLblID_ID_RingiBranch_Red());
            inDto.setLblID_Code_TatekaekinShurui_Red(form.getLblID_Code_TatekaekinShurui_Red());
            inDto.setLblID_Date_KoukoTatekae_Red(form.getLblID_Date_KoukoTatekae_Red());
            inDto.setLblID_Date_Nyukin_Red(form.getLblID_Date_Nyukin_Red());
            inDto.setLblID_M_TatekaeRisoku_Red(form.getLblID_M_TatekaeRisoku_Red());
            inDto.setLblID_M_Tatekae_Red(form.getLblID_M_Tatekae_Red());
            inDto.setLblID_M_Kei_Red(form.getLblID_M_Kei_Red());
            inDto.setLblID_M_KariukeIppanJuto_Red(form.getLblID_M_KariukeIppanJuto_Red());
            inDto.setLblID_M_Sokin_Red(form.getLblID_M_Sokin_Red());
            inDto.setLblID_M_TatekaeZanAfterUkeire_Red(form.getLblID_M_TatekaeZanAfterUkeire_Red());
            inDto.setLblID_Date_Jtkshori_Red(form.getLblID_Date_Jtkshori_Red());
            inDto.setLblID_Date_Sokin_Red(form.getLblID_Date_Sokin_Red());
            inDto.setLblID_ID_Sokinbi_Red(form.getLblID_ID_Sokinbi_Red());
            inDto.setID_ID_Denso_Red(form.getID_ID_Denso());
            inDto.setID_DataCode_Red(form.getID_DataCode());
            inDto.setID_ID_History_Red(form.getID_ID_History());
            inDto.setID_Status_Red(form.getID_Status());
            inDto.setID_Type_Process_Red(form.getID_Type_Process());
            inDto.setID_Flag_Torikeshizumi_Red(form.getID_Flag_Torikeshizumi());
            inDto.setID_ID_Credit_Red(form.getID_ID_Credit());
            inDto.setID_Keep_ID_History_Red(form.getID_Keep_ID_History());
            inDto.setID_Keep_Flag_Kj_Red(form.getID_Keep_Flag_Kj());
            inDto.setID_Keep_M_TatekaeZanAfterUkeire_Red(form.getID_Keep_M_TatekaeZanAfterUkeire());
            inDto.setID_Data_LastUpDate_Red(form.getID_Data_LastUpDate());
            inDto.setID_ID_Karibarai_Red(form.getID_ID_Karibarai());
            inDto.setID_Code_HonShiten_Red(form.getID_Code_HonShiten());
            inDto.setID_M_KaribaraiZanAfterSeisan_Red(form.getID_M_KaribaraiZanAfterSeisan_Red());
        }

        if (blackFlg) {
            inDto.setLblID_Name_Customer(form.getLblID_Name_Customer());
            inDto.setLblID_Name_Organization(form.getLblID_Name_Organization());
            inDto.setLblID_Code_KoukoShiten(form.getLblID_Code_KoukoShiten());
            inDto.setLblID_Code_Organization(form.getLblID_Code_Organization());
            inDto.setLblID_Code_Tenpo(form.getLblID_Code_Tenpo());
            inDto.setLblID_Year(form.getLblID_Year());
            inDto.setLblID_Kubun_HoshikiShikin(form.getLblID_Kubun_HoshikiShikin());
            inDto.setLblID_ID_Ringi(form.getLblID_ID_Ringi());
            inDto.setLblID_ID_RingiBranch(form.getLblID_ID_RingiBranch());
            inDto.setLblID_Code_TatekaekinShurui(form.getLblID_Code_TatekaekinShurui());
            inDto.setLblID_Date_KoukoTatekae(form.getLblID_Date_KoukoTatekae());
            inDto.setLblID_Date_Nyukin(form.getLblID_Date_Nyukin());
            inDto.setLblID_M_TatekaeRisoku(form.getLblID_M_TatekaeRisoku());
            inDto.setLblID_M_Tatekae(form.getLblID_M_Tatekae());
            inDto.setLblID_M_Kei(form.getLblID_M_Kei());
            inDto.setLblID_M_KariukeIppanJuto(form.getLblID_M_KariukeIppanJuto());
            inDto.setLblID_M_Sokin(form.getLblID_M_Sokin());
            inDto.setLblID_M_TatekaeZanAfterUkeire(form.getLblID_M_TatekaeZanAfterUkeire());
            inDto.setLblID_Date_Jtkshori(form.getLblID_Date_Jtkshori());
            inDto.setLblID_Date_Sokin(form.getLblID_Date_Sokin());
            inDto.setLblID_ID_Sokinbi(form.getLblID_ID_Sokinbi());
            inDto.setID_ID_Denso(form.getID_ID_Denso());
            inDto.setID_DataCode(form.getID_DataCode());
            inDto.setID_ID_History(form.getID_ID_History());
            inDto.setID_Status(form.getID_Status());
            inDto.setID_Type_Process(form.getID_Type_Process());
            inDto.setID_Flag_Torikeshizumi(form.getID_Flag_Torikeshizumi());
            inDto.setID_ID_Credit(form.getID_ID_Credit());
            inDto.setID_Keep_ID_History(form.getID_Keep_ID_History());
            inDto.setID_Keep_Flag_Kj(form.getID_Keep_Flag_Kj());
            inDto.setID_Keep_M_TatekaeZanAfterUkeire(form.getID_Keep_M_TatekaeZanAfterUkeire());
            inDto.setID_Data_LastUpDate(form.getID_Data_LastUpDate());
            inDto.setID_ID_Karibarai(form.getID_ID_Karibarai());
            inDto.setID_Code_HonShiten(form.getID_Code_HonShiten());
            inDto.setID_M_KaribaraiZanAfterSeisan(form.getID_M_KaribaraiZanAfterSeisan());
        }

        return inDto;
    }
}