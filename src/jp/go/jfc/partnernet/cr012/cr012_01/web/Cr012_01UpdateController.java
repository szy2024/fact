//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr012_01UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr012.cr012_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr012.common.Cr012Constants;
import jp.go.jfc.partnernet.cr012.cr012_01.service.Cr012_01DTO;
import jp.go.jfc.partnernet.cr012.cr012_01.service.Cr012_01M1DTO;
import jp.go.jfc.partnernet.cr012.cr012_01.service.Cr012_01Service;
import jp.go.jfc.partnernet.pnfw.common.PNStringChecker;
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

/**
 * <pre>
 * このクラスはcr012_01の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr012_01Form")
@RequestMapping(value = "/Cr012_01Update.form")
public class Cr012_01UpdateController extends Cr012_01BaseController {

    /** Cr012_01Service */
    @Autowired
    Cr012_01Service cr012_01service;

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

        // lblMessageIDをクリアする
        form.setLblMessageID(PNCommonConstants.LITERAL_BLANK);

        // Formより画面に入力されたデータをDTOに設定（form→inDto)
        Cr012_01DTO inDto = new Cr012_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        Cr012_01M1DTO m1Dto = form.getCr012_01M1Table().getRecordList().get(0);

        int intSu_total = 0;
        // 属性桁数エラーチェック
        // 　包括委任状数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Hokatsuinin = 0;
        String strSu_Hokatsuinin = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_HokatsuInin());
        if (3 < strSu_Hokatsuinin.length() || !PNStringChecker.isAllHalfNumber(strSu_Hokatsuinin)) {
            String[] strReplace = new String[] { "包括委任状数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Hokatsuinin = Integer.parseInt(strSu_Hokatsuinin);
            intSu_total += intSu_Hokatsuinin;
        }
        // 　現在事項一部証明書数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Genzaijiko = 0;
        String strSu_Genzaijiko = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_GenzaiJiko());
        if (3 < strSu_Genzaijiko.length() || !PNStringChecker.isAllHalfNumber(strSu_Genzaijiko)) {
            String[] strReplace = new String[] { "現在事項一部証明書数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Genzaijiko = Integer.parseInt(strSu_Genzaijiko);
            intSu_total += intSu_Genzaijiko;
        }
        // 　印鑑証明書数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Inkanshohmei = 0;
        String strSu_Inkanshohmei = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_InkanShohmei());
        if (3 < strSu_Inkanshohmei.length() || !PNStringChecker.isAllHalfNumber(strSu_Inkanshohmei)) {
            String[] strReplace = new String[] { "印鑑証明書数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Inkanshohmei = Integer.parseInt(strSu_Inkanshohmei);
            intSu_total += intSu_Inkanshohmei;
        }
        // 　変更抄本数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Henkoshohhon = 0;
        String strSu_Henkoshohhon = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_HenkoShohhon());
        if (3 < strSu_Henkoshohhon.length() || !PNStringChecker.isAllHalfNumber(strSu_Henkoshohhon)) {
            String[] strReplace = new String[] { "変更抄本数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Henkoshohhon = Integer.parseInt(strSu_Henkoshohhon);
            intSu_total += intSu_Henkoshohhon;
        }
        // 　新閉鎖謄本数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Sinheisa = 0;
        String strSu_Sinheisa = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_SinHeisa());
        if (3 < strSu_Sinheisa.length() || !PNStringChecker.isAllHalfNumber(strSu_Sinheisa)) {
            String[] strReplace = new String[] { "新閉鎖謄本数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Sinheisa = Integer.parseInt(strSu_Sinheisa);
            intSu_total += intSu_Sinheisa;
        }
        // 　旧閉鎖抄本数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Kyuheisa = 0;
        String strSu_Kyuheisa = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_KyuHeisa());
        if (3 < strSu_Kyuheisa.length() || !PNStringChecker.isAllHalfNumber(strSu_Kyuheisa)) {
            String[] strReplace = new String[] { "旧閉鎖抄本数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Kyuheisa = Integer.parseInt(strSu_Kyuheisa);
            intSu_total += intSu_Kyuheisa;
        }
        // 　閉鎖事項全部証明書数量に半角数字以外または3桁より大きい場合、属性エラーとする。
        // 　　PM3140E　{0}で入力してください。　※{0} ・・・【項目名】は【属性】【桁数】以内
        int intSu_Heisajiko = 0;
        String strSu_Heisajiko = PNCommonComponents.cnvNulltoZero(m1Dto.getTxtID_Su_HeisaJiko());
        if (3 < strSu_Heisajiko.length() || !PNStringChecker.isAllHalfNumber(strSu_Heisajiko)) {
            String[] strReplace = new String[] { "閉鎖事項全部証明書数量は半角数字3桁以内" };
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
        }
        else {
            intSu_Heisajiko = Integer.parseInt(strSu_Heisajiko);
            intSu_total += intSu_Heisajiko;
        }

        // 至急発行チェックボックス
        String flg_Shikyuhakk = m1Dto.getChkID_ShikyuHakko();
        if (null == flg_Shikyuhakk) {
            // 至急発行のチェックがnullの場合は"0"を設定する。
            flg_Shikyuhakk = PNCommonConstants.CHECKBOX_VALUE_OFF;
        }
        else {
            // 至急発行のチェックがnull以外の場合は"1"を設定する。
            flg_Shikyuhakk = PNCommonConstants.CHECKBOX_VALUE_ON;
        }
        m1Dto.setChkID_ShikyuHakko(flg_Shikyuhakk);

        if (PNCommonConstants.CHECKBOX_VALUE_ON.equals(flg_Shikyuhakk)) {
            // 至急発行通数上限エラーチェック
            // 　　■至急発行のチェックが"1"(ON)の場合
            // 　　　　■包括委任状数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【包括委任状数量】
            if (3 < intSu_Hokatsuinin) {
                String[] strReplace = new String[] { "包括委任状数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■現在事項一部証明書数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【現在事項一部証明書数量】
            if (3 < intSu_Genzaijiko) {
                String[] strReplace = new String[] { "現在事項一部証明書数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■印鑑証明書数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【印鑑証明書数量】
            if (3 < intSu_Inkanshohmei) {
                String[] strReplace = new String[] { "印鑑証明書数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■変更抄本数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【変更抄本数量】
            if (3 < intSu_Henkoshohhon) {
                String[] strReplace = new String[] { "変更抄本数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■新閉鎖謄本数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【新閉鎖謄本数量】
            if (3 < intSu_Sinheisa) {
                String[] strReplace = new String[] { "新閉鎖謄本数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■旧閉鎖抄本数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【旧閉鎖抄本数量】
            if (3 < intSu_Kyuheisa) {
                String[] strReplace = new String[] { "旧閉鎖抄本数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
            // 　　　　■閉鎖事項全部証明書数量が3を超えている場合、エラーとする。
            // 　　　　　　メッセージID：PM3140E【閉鎖事項全部証明書数量】
            if (3 < intSu_Heisajiko) {
                String[] strReplace = new String[] { "閉鎖事項全部証明書数量は至急発行の場合３通以内" };
                throw new PNServiceException(PNCommonMessageConstants.PM3140E, strReplace, false);
            }
        }

        // 未入力エラーチェック
        // 　包括委任状数量、現在事項一部証明書数量、印鑑証明書数量、変更抄本数量、
        // 新閉鎖謄本数量、旧閉鎖抄本数量、閉鎖事項全部証明書数量の合計が 0の場合、
        // エラーとする。（※未入力の場合は0として計算する）
        // 　　メッセージID：PM3120E　{0}が入力されていません。　※{0} ・・・【数量】
        if (0 == intSu_total) {
            String[] strReplace = new String[] { "数量" };
            throw new PNServiceException(PNCommonMessageConstants.PM3120E, strReplace, false);
        }

        // DTOに明細セット
        inDto.setMEISAI_LIST(form.getCr012_01M1TableRecord());

        // エラーチェックでエラーがない場合、サービスを実行し、登録処理を行う。
        cr012_01service.regist(inDto);

        // form.メッセージＩＤにPM1150Iを設定する。
        // PM1150I : データの登録が完了しました。
        form.setLblMessageID(PNCommonMessageConstants.PM1150I);

        // 戻り値（画面遷移情報）に自画面を設定する。
        return success(Cr012Constants.EVENT_ID_CR012_01INIT);
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