//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_02.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.md001.common.Md001Constants;
import jp.go.jfc.partnernet.md001.md001_02.service.Md001_02DTO;
import jp.go.jfc.partnernet.md001.md001_02.service.Md001_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
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
 * このクラスはMd001_02の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md001_02Form")
@RequestMapping(value = "/Md001_02Create.form")
public class Md001_02CreateController extends Md001_02BaseController {

    /** Md001_02Service */
    @Autowired
    Md001_02Service md001_02service;

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    DateFormat df = new SimpleDateFormat(Md001Constants.STR_DATE_LAST_UPDATE_FORMAT);

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
    public String executeAction(Model model, Md001_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // DTOの生成
        Md001_02DTO inDto = new Md001_02DTO();
        Md001_02DTO outDto = new Md001_02DTO();
        // 現在の日付取得
        // String nowDate = PNCommonComponents.dateFmtJC_Gyymmdd(PNCommonComponents.getSysDateTimeDay(), "");
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime();
        form.setID_Time_Report(nowTime);
        String targetDateTime = df.format(PNDateUtils.toDate(nowDate+nowTime.replaceAll(":", ""), "yyyyMMddHHmmss"));

        if (Md001Constants.PROCESS_MODE_3.equals(form.getProcessMode())) {
            // 処理種別が、処理完了以外：取消(3)の場合
            // 　画面表示時に取得したレコードに対する取消処理
            // 　　　更正（赤）データの値を設定しなおす。
            // 　　　　空白⇒報告書番号
            form.setID_Report_Red("");
            // 　　　　１⇒取消済フラグ
            form.setID_Flag_Torikeshizumi_Red(Md001Constants.STR_ONE);
            // 　　　　０⇒貸付実行報告書作成済みフラグ
            form.setID_Flag_Kj_Red(Md001Constants.STR_ZERO);
            // 　　　　現在の日付⇒報告年月日
            form.setLblID_Date_Report(nowDate);
            // 　　　　現在の時刻⇒報告時分秒
            form.setID_Time_Report_Red(nowTime);
            // 　　　　退避償還期限年月⇒償還期限年月
            form.setLblID_Date_ShokanKigen_Red(form.getID_Keep_Date_ShokanKigen());
            // 最終更新日時をセット
            form.setID_Data_LastUpDate(targetDateTime);

            // 引数：更正（赤）データ
            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDto, form);

            // Serviceの呼び出し
            // Md001_02DTO outMd001_02DTO =
            // md001_02service.updateDataNotProcEndDel(inMd001_02DTO);
            outDto = md001_02service.updateDataNotProcEndDel(inDto);

            // エラー判定
            if (0 < outDto.getBizErrors().size()) {
                // エラー有の場合自画面表示
                bizErrors.addAll(outDto.getBizErrors());
                throw new PNServiceException(bizErrors);
            }

        } else if (Md001Constants.PROCESS_MODE_1.equals(form.getProcessMode())) {
            // 処理種別が、処理完了：取消(1)の場合
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 　　　更正（赤）データの値を設定しなおす。
            // 　　　　１⇒取消済フラグ
            form.setID_Flag_Torikeshizumi_Red(Md001Constants.STR_ONE);
            // 　　　　０⇒貸付実行報告書作成済みフラグ
            form.setID_Flag_Kj_Red(Md001Constants.STR_ZERO);
            // 　　　　現在の日付⇒報告年月日
            form.setLblID_Date_Report(nowDate);
            // 　　　　現在の時刻⇒報告時分秒
            form.setID_Time_Report_Red(nowTime);
            // 最終更新日時をセット
            form.setID_Data_LastUpDate(targetDateTime);
            // 引数：更正（赤）データ
            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDto, form);

            // Serviceの呼び出し
            // Md001_02DTO outMd001_02DTO =
            // md001_02service.updateDataProcEndDel(inMd001_02DTO);
            outDto = md001_02service.updateDataProcEndDel(inDto);
            // エラー判定
            if (0 < outDto.getBizErrors().size()) {
                // エラー有の場合自画面表示
                bizErrors.addAll(outDto.getBizErrors());
                throw new PNServiceException(bizErrors);
            }

        } else if (Md001Constants.PROCESS_MODE_4.equals(form.getProcessMode())) {
            // 処理種別が、処理完了以外：修正(4)の場合
            // 　更正（赤）データの登録
            // 　　　更正（赤）データの値を設定しなおす。
            // 　　　　空白⇒報告書番号
            form.setID_Report_Red("");
            // 　　　　１⇒取消済フラグ
            form.setID_Flag_Torikeshizumi_Red(Md001Constants.STR_ONE);
            // 　　　　現在の日付⇒報告年月日
            form.setLblID_Date_Report(nowDate);
            // 　　　　現在の時刻⇒報告時分秒
            form.setID_Time_Report_Red(nowTime);
            // 最終更新日時をセット
            form.setID_Data_LastUpDate(targetDateTime);
            // 引数：更正（赤）データ、修正データ
            // 　　　Md001_02Service.updateDataNotProcEndMod // DTOの生成
            // Md001_02DTO inMd001_02DTO = new Md001_02DTO();
            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDto, form);

            // Serviceの呼び出し
            // Md001_02DTO outMd001_02DTO =
            // md001_02service.updateDataNotProcEndMod(inMd001_02DTO);
            outDto = md001_02service.updateDataNotProcEndMod(inDto);
            // エラー判定
            if (0 < outDto.getBizErrors().size()) {
                // エラー有の場合自画面表示
                bizErrors.addAll(outDto.getBizErrors());
                throw new PNServiceException(bizErrors);
            }

        } else if (Md001Constants.PROCESS_MODE_2.equals(form.getProcessMode())) {
            // 処理種別が、処理完了：修正(2)の場合
            // 　更正（赤）データの登録
            // 　　　更正（赤）データの値を設定しなおす。
            // 　　　　１⇒取消済フラグ
            form.setID_Flag_Torikeshizumi_Red(Md001Constants.STR_ONE);
            // 　　　　０⇒貸付実行報告書作成済みフラグ
            form.setID_Flag_Kj_Red(Md001Constants.STR_ZERO);
            // 　　　　現在の日付⇒報告年月日
            form.setLblID_Date_Report(nowDate);
            // 　　　　現在の時刻⇒報告時分秒
            form.setID_Time_Report_Red(nowTime);
            // 　　　　退避償還期限年月⇒償還期限年月
            form.setLblID_Date_ShokanKigen_Red(form.getID_Keep_Date_ShokanKigen());
            // 最終更新日時をセット
            form.setID_Data_LastUpDate_Red(targetDateTime);
            // 引数：更正（赤）データ、修正データ
            // 　　　Md001_02Service.updateDataProcEndMod // DTOの生成
            // Md001_02DTO inMd001_02DTO = new Md001_02DTO();
            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDto, form);

            // Serviceの呼び出し
            // Md001_02DTO outMd001_02DTO =
            // md001_02service.updateDataProcEndMod(inMd001_02DTO);
            outDto = md001_02service.updateDataProcEndMod(inDto);
            // エラー判定
            if (0 < outDto.getBizErrors().size()) {
                // エラー有の場合自画面表示
                bizErrors.addAll(outDto.getBizErrors());
                throw new PNServiceException(bizErrors);
            }

        } else if (Md001Constants.PROCESS_MODE_5.equals(form.getProcessMode())) {
            // 処理種別が、処理完了以外：取消(更正赤)(5)の場合
            // 　画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 　　　更正（赤）データの値を設定しなおす。
            // 引数：更正（赤）データ
            // 　　　Md001_02Service.updateDataNotProcEndDelCalcel // DTOの生成
            // Md001_02DTO inMd001_02DTO = new Md001_02DTO();
            // DTOへの転記処理をここに実装
            CFWBeanUtils.copyProperties(inDto, form);

            // Serviceの呼び出し
            // Md001_02DTO outMd001_02DTO =
            // md001_02service.updateDataNotProcEndDelCalcel(inMd001_02DTO);
            outDto = md001_02service.updateDataNotProcEndDelCalcel(inDto);
            // エラー判定
            if (0 < outDto.getBizErrors().size()) {
                // エラー有の場合自画面表示
                bizErrors.addAll(outDto.getBizErrors());
                throw new PNServiceException(bizErrors);
            }

        }

        // メッセージに追加完了メッセージを設定する。
        // 　追加完了メッセージ：BA001, DB018

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);

        // 画面にエラーメッセージが設定されていない場合、画面遷移を行う。
        // 　登録結果画面へ遷移する
        // 　　return success("Md001_03Init")

        return success(Md001Constants.EVENT_ID_MD001_03INIT);
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
    public void displayControl(Model model, Md001_02Form form, HttpServletRequest request) {

    }
}