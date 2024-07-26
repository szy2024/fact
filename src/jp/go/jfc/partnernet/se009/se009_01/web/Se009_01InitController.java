//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
// 2.0.0   | 2017/11/08 | 宮郷　慎之介          | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.se009.common.Se009Constants;
import jp.go.jfc.partnernet.se009.se009_01.service.Se009_01DTO;
import jp.go.jfc.partnernet.se009.se009_01.service.Se009_01Service;

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
 * このクラスはSe009_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("se009_01Form")
@RequestMapping(value = "/Se009_01Init.form")
public class Se009_01InitController extends Se009_01BaseController {

    /** Se009_01Service */
    @Autowired
    Se009_01Service se009_01service;

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
    public String executeAction(Model model, Se009_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面の全項目をクリアする。
        form.setDrpID_Code_ShokanHonShiten(null);
        // 扱店コード
        form.setTxtID_Code_Organization(null);
        // 店舗コード
        form.setTxtID_Code_Tenpo(null);
        // 年度
        form.setTxtID_Year(null);
        // 方式資金
        form.setTxtID_HoshikiShikin(null);
        // 番号
        form.setTxtID_ID_Ringi(null);
        // 枝番
        form.setTxtID_ID_RingiBranch(null);
        // 資金払出または元金充当日(元号)
        form.setID_SearchStartWareki(null);
        // 資金払出または元金充当日(年)
        form.setID_SearchStartYear(null);
        // 資金払出または元金充当日(月)
        form.setID_SearchStartMonth(null);
        // 資金払出または元金充当日(日)
        form.setID_SearchStartDate(null);
        // 資金払出額
        form.setTxtID_M_Haraidashi(null);
        // 元金充当額
        form.setTxtID_M_Ganju(null);
        // エラーメッセージ
        // lblError;

        // 公庫支店プルダウンリストを取得する。
        // 　サービスを実行し公庫支店プルダウンデータを取得する。
        // Se009_01Service.getkoukoShitenCodeNameMap // DTOの生成
        Se009_01DTO inSe009_01DTO = new Se009_01DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Se009_01DTO outSe009_01DTO = se009_01service.getkoukoShitenCodeNameMap(inSe009_01DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        // 公庫支店プルダウンリストを画面に設定する。
        form.setKoukoShitenCodeNameMap(outSe009_01DTO.getKoukoShitenCodeNameMap());

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

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
    public void displayControl(Model model, Se009_01Form form, HttpServletRequest request) {

        // ログインユーザの権限種別により、画面の公庫支店名、扱店コードの入力可否及び初期値を設定する
        // 　①ユーザ権限＝計数管理担当者、管理者
        // 　　公庫支店名　　：入力可
        // 　　扱店コード　　　：入力可　初期値＝空白
        // 　②ユーザ権限＝H方式受託者
        // 　　公庫支店名　　：入力可
        // 　　扱店コード　　　：入力不可　初期値＝９９３７
        // 　③ユーザ権限＝受託者
        // 　　公庫支店名　　：入力可
        // 　　扱店コード　　　：入力可　初期値＝ログインユーザの扱店コード

        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        String roleCode = loginInfo.getRoleCode();

        if (PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)) {
            // 処理はしない
        }
        else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
            form.setTxtID_Code_Organization(Se009Constants.CODE_ORGANIZATION_NOUKYOU);
            form.setProtect("txtID_Code_Organization", true);
        }
        else if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            // form.setTxtID_Code_Organization(loginInfo.getCode_Organization());
            form.setTxtID_Code_Organization(loginInfo.getCode_Organization());
        }

    }
}