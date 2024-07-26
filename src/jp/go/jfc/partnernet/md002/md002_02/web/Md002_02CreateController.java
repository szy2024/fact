//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_02CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_02.web;

import java.math.BigDecimal;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.md002.common.Md002Constants;
import jp.go.jfc.partnernet.md002.md002_02.service.Md002_02DTO;
import jp.go.jfc.partnernet.md002.md002_02.service.Md002_02Service;
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
 * このクラスはmd002_02の登録ボタンコントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md002_02Form")
@RequestMapping(value = "/Md002_02Create.form")
public class Md002_02CreateController extends Md002_02BaseController {

    /** Md002_02Service */
    @Autowired
    Md002_02Service md002_02service;

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
    public String executeAction(Model model, Md002_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // Type_Shokanの値により、更新するDBが異なる。
        // Type_Shokan　=　0　・・・　資金払出のみ
        // Type_Shokan　=　1　・・・　元利均等償還・期限固定
        // Type_Shokan　=　2　・・・　元利均等償還・期限短縮
        // Type_Shokan　=　3　・・・　元金均等償還・期限固定
        // Type_Shokan　=　4　・・・　元金均等償還・期限短縮
        // Type_Shokan　=　5　・・・　定期償還
        // Type_Shokan　=　6　・・・　特殊償還

        Md002_02DTO inDto = new Md002_02DTO();
        CFWBeanUtils.copyProperties(inDto, form);

        // 変数の初期化
        // ・False⇒請求データ更新判定フラグ
        inDto.setSeikyuShuseiUp(false);
        // ・"0"⇒稟議データ更新フラグ
        inDto.setRingiRedFlg("0");
        // ・0⇒退避更正処理区分
        inDto.setSaveProcMode(0);
        // ・"0"⇒取得償還方法コード
        inDto.setCharCode_ShokanHouhou("0");

        // 取消に関する情報
        // 扱店別稟議データ「償還方法コード」の取得
        // １．稟議・償還方法コード（非表示）⇒取得償還方法コード
        inDto.setCharCode_ShokanHouhou(inDto.getID_Code_ShokanHouhou_Ringi().substring(0, 1));
        BigDecimal bdM_Ganju = BigDecimal.ONE;
        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getProcess_Mode())
                || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(form.getProcess_Mode())) {
            bdM_Ganju = form.getLblID_M_Ganju();
        } else {
            bdM_Ganju = form.getLblID_M_Ganju_Red();
        }
        // ２．取消の対象となる報告書データの元金充当額＝"0"（払出のみの場合）の場合
        if (0 == BigDecimal.ZERO.compareTo(bdM_Ganju)) {
            // （１）"0"⇒取得償還方法コード
            inDto.setCharCode_ShokanHouhou("0");
        }
        // 修正に関する情報
        // １．償還方法タイプ識別値＜＞"0"の場合
        if (!"0".equals(inDto.getType_Shokan())) {
            // （１）True⇒請求データ更新判定フラグ
            inDto.setSeikyuShuseiUp(true);
        }

        // 処理モードによる処理振り分け

        Md002_02DTO outDto = null;

        if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(form.getProcess_Mode())) {
            // １．「処理完了以外：取消」の場合
            // （１）画面表示時に取得したレコードに対する取消処理
            // 引数：更正（赤）データ
            outDto = md002_02service.updateDataNotProcEndDel(inDto);
        } else if ((PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(form.getProcess_Mode()))) {
            // ２．「処理完了：取消」の場合
            // （１）画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ
            outDto = md002_02service.updateDataProcEndDel(inDto);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(form.getProcess_Mode())) {
            // ３．「処理完了以外：修正」の場合
            // （１）更正（赤）データの登録
            // 引数：更正（赤）データ、修正データ
            outDto = md002_02service.updateDataNotProcEndMod(inDto);
        } else if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(form.getProcess_Mode())) {
            // ４．「処理完了：修正」の場合
            // （１）更正（赤）データの登録
            // 引数：更正（赤）データ、修正データ
            outDto = md002_02service.updateDataProcEndMod(inDto);
        } else if (PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL.equals(form.getProcess_Mode())) {
            // ５．「処理完了以外：取消(更正赤)」の場合
            // （１）画面表示時に取得したﾚｺｰﾄﾞに対する取消処理
            // 引数：更正（赤）データ
            outDto = md002_02service.updateDataNotProcEndDelCalcel(inDto);

        }
        bizErrors.addAll(outDto.getBizErrors());
        if (0 < bizErrors.size()) {
            throw new PNServiceException(bizErrors);
        }

        // 完了画面メッセージ表示要フラグ
        boolean flgSeikyuUpdate = false;
        if (form.getFlgSeikyuUpTorikeshi() || form.getFlgSeikyuUpShusei()) {
            flgSeikyuUpdate = true;
        }
        // 完了画面メッセージ表示要フラグを遷移パラメータに設定する。
        addForwardParameter(request, Md002Constants.PROPERTY_FLG_SEIKYUUPDATE, flgSeikyuUpdate);

        // 画面にエラーメッセージが設定されていない場合、画面遷移を行う。
        // 　登録結果画面へ遷移する
        return success(Md002Constants.EVENT_ID_MD002_03INIT);
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
    public void displayControl(Model model, Md002_02Form form, HttpServletRequest request) {

    }
}