//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md008_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/04 | 乃村　賢司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md008.md008_02.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.md008.md008_02.service.Md008_02DTO;
import jp.go.jfc.partnernet.md008.md008_02.service.Md008_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;

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
 * このクラスはMd008_02の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 乃村　賢司
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md008_02Form")
@RequestMapping(value = "/Md008_02Create.form")
public class Md008_02CreateController extends Md008_02BaseController {

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents PNCommonDBComponents;

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /** Md008_02Service */
    @Autowired
    Md008_02Service md008_02service;

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
    public String executeAction(Model model, Md008_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 処理モード
        String processMode = form.getProcessMode();

        Md008_02DTO inMd008_02DTO = new Md008_02DTO();
        inMd008_02DTO = setValueFormToDto(form);

        // 処理モードが、処理完了：取消(1)の場合
        if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)) {
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ

            // Serviceの呼び出し
            md008_02service.updateDataProcEndDel(inMd008_02DTO);

        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)) {

            // 処理モードが、処理完了：修正(2)の場合
            // 　更正（赤）データの登録
            // 引数：更正（赤）データ、更正（黒）データ

            // Serviceの呼び出し
            md008_02service.updateDataProcEndMod(inMd008_02DTO);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {
            // 処理モードが、処理完了以外：取消(3)の場合
            // 　画面表示時に取得したレコードに対する取消処理
            // 引数：更正（赤）データ

            // Serviceの呼び出し
            md008_02service.updateDataNotProcEndDel(inMd008_02DTO);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {

            // 処理モードが、処理完了以外：修正(4)の場合
            // 　更正（黒）データの登録
            // 引数：更正（黒）データ

            // Serviceの呼び出し
            md008_02service.updateDataNotProcEndMod(inMd008_02DTO);

        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(processMode)) {
            // 処理モードが、処理完了以外：取消更正(赤)(5)の場合
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ

            // Serviceの呼び出し
            md008_02service.updateDataNotProcEndDelCalcel(inMd008_02DTO);

        }

        // メッセージに追加完了メッセージを設定する。
        // 　追加完了メッセージ：PM1060I
        addMessage(errors, PNCommonMessageConstants.PM1060I);

        // 画面にエラーメッセージが設定されていない場合、画面遷移を行う。
        // 　登録結果画面へ遷移する
        return success("Md008_03Init");

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
    public void displayControl(Model model, Md008_02Form form, HttpServletRequest request) {

    }

    /**
     * パラメータの設定
     *
     * @param form Md008_02Form
     * @return Md008_02DTO
     */
    private Md008_02DTO setValueFormToDto(Md008_02Form form) {
        Md008_02DTO outDto = new Md008_02DTO();

        // 報告年月日
        outDto.setLblID_Date_Report(form.getLblID_Date_Report());
        // 報告書番号
        outDto.setID_Report(form.getID_Report());
        // ステータス
        outDto.setID_Status(form.getID_Status());
        // 履歴番号
        outDto.setID_History(form.getID_History());
        // 処理種別
        outDto.setID_Type_Process(form.getID_Type_Process());
        // データコード
        outDto.setID_DataCode(form.getID_DataCode());
        // 処理モード
        outDto.setProcessMode(form.getProcessMode());

        // 顧客名
        outDto.setLblID_Name_Customer_Red(form.getLblID_Name_Customer_Red());
        // 扱店名
        outDto.setLblID_Name_Organization_Red(form.getLblID_Name_Organization_Red());
        // 公庫支店
        outDto.setLblID_Code_ShokanHonShiten_Red(form.getLblID_Code_ShokanHonShiten_Red());
        // 扱店
        outDto.setLblID_Code_Organization_Red(form.getLblID_Code_Organization_Red());
        // 店舗
        outDto.setLblID_Code_Tenpo_Red(form.getLblID_Code_Tenpo_Red());
        // 年度
        outDto.setLblID_Year_Red(form.getLblID_Year_Red());
        // 方式資金
        outDto.setLblID_Code_HoshikiShikin_Red(form.getLblID_Code_HoshikiShikin_Red());
        // 番号
        outDto.setLblID_ID_Ringi_Red(form.getLblID_ID_Ringi_Red());
        // 枝番
        outDto.setLblID_ID_RingiBranch_Red(form.getLblID_ID_RingiBranch_Red());
        // 入金日
        outDto.setLblID_Date_Nyukin_Red(form.getLblID_Date_Nyukin_Red());
        // 仮受金（一般口）受入額
        outDto.setLblID_M_KariukeIppanUkeire_Red(form.getLblID_M_KariukeIppanUkeire_Red());
        // 受託者勘定処理年月
        outDto.setLblID_Date_Jtkshori_Red(form.getLblID_Date_Jtkshori_Red());
        // 送金日
        outDto.setLblID_Date_Sokin_Red(form.getLblID_Date_Sokin_Red());
        // 送金日番号
        outDto.setLblID_Code_Sokin_Red(form.getLblID_Code_Sokin_Red());
        // 退避履歴番号
        outDto.setID_Keep_ID_History(form.getID_Keep_ID_History());
        // 報告書最新更新年月日
        outDto.setID_Data_LastUpDate(form.getID_Data_LastUpDate());

        // 顧客名（修正）
        outDto.setLblID_Name_Customer(form.getLblID_Name_Customer());
        // 扱店名（修正）
        outDto.setLblID_Name_Organization(form.getLblID_Name_Organization());
        // 公庫支店（修正）
        outDto.setLblID_Code_ShokanHonShiten(form.getLblID_Code_ShokanHonShiten());
        // 扱店（修正）
        outDto.setLblID_Code_Organization(form.getLblID_Code_Organization());
        // 店舗（修正）
        outDto.setLblID_Code_Tenpo(form.getLblID_Code_Tenpo());
        // 年度（修正）
        outDto.setLblID_Year(form.getLblID_Year());
        // 方式資金（修正）
        outDto.setLblID_Code_HoshikiShikin(form.getLblID_Code_HoshikiShikin());
        // 番号（修正）
        outDto.setLblID_ID_Ringi(form.getLblID_ID_Ringi());
        // 枝番（修正）
        outDto.setLblID_ID_RingiBranch(form.getLblID_ID_RingiBranch());
        // 入金日（修正）
        outDto.setLblID_Date_Nyukin(form.getLblID_Date_Nyukin());
        // 仮受金（一般口）受入額（修正）
        outDto.setLblID_M_KariukeIppanUkeire(form.getLblID_M_KariukeIppanUkeire());
        // 受託者勘定処理年月（修正）
        outDto.setLblID_Date_Jtkshori(form.getLblID_Date_Jtkshori());
        // 送金年月日（修正）
        outDto.setLblID_Date_Sokin(form.getLblID_Date_Sokin());
        // 送金日番号（修正）
        outDto.setLblID_Code_Sokin(form.getLblID_Code_Sokin());

        return outDto;
    }
}