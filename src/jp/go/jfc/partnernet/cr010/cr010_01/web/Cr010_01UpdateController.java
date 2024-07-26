//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Cr010_01UpdateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/08/09 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.cr010.cr010_01.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr010.common.Cr010Constants;
import jp.go.jfc.partnernet.cr010.cr010_01.service.Cr010_01DTO;
import jp.go.jfc.partnernet.cr010.cr010_01.service.Cr010_01M1DTO;
import jp.go.jfc.partnernet.cr010.cr010_01.service.Cr010_01Service;
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
 * このクラスはcr010_01の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr010_01Form")
@RequestMapping(value = "/Cr010_01Update.form")
public class Cr010_01UpdateController extends Cr010_01BaseController {

    /** Cr010_01Service */
    @Autowired
    Cr010_01Service cr010_01service;

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
    public String executeAction(Model model, Cr010_01Form form,
            Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // Formより画面に入力されたデータをDTOに設定（form→inDto)
        Cr010_01DTO inDto = new Cr010_01DTO();
        CFWBeanUtils.copyProperties(inDto, form);
        inDto.setMEISAI_LIST(form.getCr010_01m1TableRecord());

        // 交付依頼年月（yyyyMM）
// [UPD] Ver 3.0.0 - START
//        String formKofuirai = PNCommonComponents.concatString(
//                PNCommonComponents.dateFmtJC_Gyy(form.getLblID_KofuIraiYear()),
//                form.getLblID_KofuIraiMonth());
        String formKofuirai = PNCommonComponents.dateFmtJC_Gyymm(
                PNCommonComponents.concatString(form.getLblID_KofuIraiYear(),
                        String.format("%02d", Integer.parseInt(form.getLblID_KofuIraiMonth()))), "");
// [UPD] Ver 3.0.0 - END

        // 明細行数分以下の処理を繰り返す
        // 必須エラーチェック
        // 同一行の交付日（日）、依頼予定額、元金充当額が全て入力されている明細行が存在しない場合、必須エラーとする。
        int emptyCnt = 0;
        for (Cr010_01M1DTO m1Dto : form.getCr010_01m1TableRecord()) {
            if (m1Dto.getDrpID_KofuDateDate().isEmpty()
                    && m1Dto.getTxtID_Irai().isEmpty()
                    && m1Dto.getTxtID_Ganju().isEmpty()) {
                emptyCnt++;
            }
        }
        if (emptyCnt == form.getCr010_01m1TableRecord().size()) {
            // PM3110E : {0}入力してください。※{0}･･･資金交付依頼は１件以上
            throw new PNServiceException(PNCommonMessageConstants.PM3110E,
                    new String[] { "資金交付依頼は１件以上" }, false);

        }

        // 明細行数分以下の処理を繰り返す
        for (Cr010_01M1DTO m1Dto : form.getCr010_01m1TableRecord()) {

            String kofu = m1Dto.getDrpID_KofuDateDate();
            String irai = m1Dto.getTxtID_Irai();
            String ganju = m1Dto.getTxtID_Ganju();

            // 全て未入力の場合continue
            if (kofu.isEmpty() && irai.isEmpty() && ganju.isEmpty()) {
                continue;
            }

            // 未入力エラーチェック
            // 同一行の交付日（日）、依頼予定額、元金充当額のいずれかが未入力の場合、未入力エラーとする。
            // PM3120E : {0}が入力されていません。※･･･【項目名】

            // 交付日以外が未入力の場合
            if (!kofu.isEmpty()) {
                if (irai.isEmpty()) {
                    throw new PNServiceException(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { "依頼予定額" }, false);
                }

                if (ganju.isEmpty()) {
                    throw new PNServiceException(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { "元金充当額（外数）" }, false);
                }
            }

            // 依頼予定額以外が未入力の場合
            if (!irai.isEmpty()) {
                if (kofu.isEmpty()) {
                    throw new PNServiceException(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { "交付日" }, false);
                }

            }

            // 元金充当額以外が未入力の場合
            if (!ganju.isEmpty()) {
                if (kofu.isEmpty()) {
                    throw new PNServiceException(
                            PNCommonMessageConstants.PM3120E,
                            new String[] { "交付日" }, false);
                }

            }

            // 属性桁数エラーチェック
            // 依頼予定額の属性が半角数字でない または 12桁より大きい場合、エラーとする。
            // PM3140E : {0}で入力してください。※{0} ・・・【項目名】は【属性】【桁数】以内
            if (!PNStringChecker.isAllHalfNumber(irai)
                    || Cr010Constants.MONEY_MAX_DIGIT < irai.length()) {
                throw new PNServiceException(PNCommonMessageConstants.PM3140E,
                        new String[] { "依頼予定額は半角数字12桁以内" }, false);
            }

            // 元金充当額の属性が半角数字でない または 12桁より大きい場合、エラーとする。
            // PM3140E : {0}で入力してください。※{0} ・・・【項目名】は【属性】【桁数】以内
            if (!PNStringChecker.isAllHalfNumber(ganju)
                    || Cr010Constants.MONEY_MAX_DIGIT < ganju.length()) {
                throw new PNServiceException(PNCommonMessageConstants.PM3140E,
                        new String[] { "元金充当額（外数）は半角数字12桁以内" }, false);
            }

            // 交付日有効エラーチェック
            // 選択された年月日が実在しない日付の場合、エラーとする。
            String dateKofu = PNCommonComponents.concatString(
                    formKofuirai,
                    String.format("%02d", Integer.parseInt(m1Dto.getDrpID_KofuDateDate())));
            // PM3220E : {0}に正しい日付を入力して下さい。※{0}・・・ 交付日
            if (!PNCommonComponents.checkDate(dateKofu)) {
                throw new PNServiceException(PNCommonMessageConstants.PM3220E,
                        new String[] { "交付日" }, false);
            }

        }

        // 明細行数分以下の処理を繰り返す
        // 交付日重複エラーチェック
        // 交付日（日）が入力されている かつ 交付日が重複している場合、重複エラーとする。
        // PM3300E : 日付の重複があります。
        Set<String> chkHash = new HashSet<String>();
        for (Cr010_01M1DTO m1Dto : form.getCr010_01m1TableRecord()) {
            if (!m1Dto.getDrpID_KofuDateDate().isEmpty()) {
                if (chkHash.contains(m1Dto.getDrpID_KofuDateDate())) {
                    throw new PNServiceException(PNCommonMessageConstants.PM3300E);
                }
                else {
                    chkHash.add(m1Dto.getDrpID_KofuDateDate());
                }
            }
        }

        // 登録期限エラーチェック
        // 13:00:00 ＜ システム時刻（HH:MM:SS）の場合（13:00を過ぎている場合）
        String sysTime = PNCommonComponents.getSysDateTime().replaceAll(
                PNCommonConstants.TIME_SEPARATOR, PNCommonConstants.LITERAL_BLANK);
        if (130000 < Integer.parseInt(sysTime)) {

            // 業務日付の翌営業日を取得
            String nextBizDate = pnCommonDBComponents.calcNextBizDate();

            // 取得した日付を入力として、資金交付依頼日取得（業務共通部品）を呼び出し、
            // 取得した日付を交付依頼年月に設定する。
            String chkKofuirai = pnCommonDBComponents.calcKofuDate(nextBizDate).substring(
                    PNCommonConstants.DATE1_YEAR_BEGIN_INDEX,
                    PNCommonConstants.DATE1_MONTH_END_INDEX);

            // 交付依頼年月 ＜ 取得した資金交付依頼日（yyyyMM）の場合、エラーとする。
            // PM3950E : 登録期限後の報告はできません。
            if (Integer.parseInt(formKofuirai) < Integer.parseInt(chkKofuirai)) {
                throw new PNServiceException(PNCommonMessageConstants.PM3950E);

            }

        }

        // サービスを実行し、登録処理を行う。
        cr010_01service.regist(inDto);

        // form.メッセージＩＤにPM1150Iを設定する。
        // PM1150I : データの登録が完了しました。
        form.setLblMessageID(PNCommonMessageConstants.PM1150I);

        // 戻り値（画面遷移情報）に自画面を設定する。
        return success(Cr010Constants.EVENT_ID_CR010_01INIT);

    }

    /**
     * <pre>
     * 初期表示時の画面制御を行います。
     * </pre>
     * {@inheritDoc}
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#displayControl(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void displayControl(Model model, Cr010_01Form form,
            HttpServletRequest request) {

    }
}