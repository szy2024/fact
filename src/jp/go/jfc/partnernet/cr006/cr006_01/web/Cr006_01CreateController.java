//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01CreateController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;
import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01DTO;
import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01M1DTO;
import jp.go.jfc.partnernet.cr006.cr006_01.service.Cr006_01Service;
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

import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはCr006_01の作成コントローラークラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr006_01Form")
@RequestMapping(value = "/Cr006_01Create.form")
public class Cr006_01CreateController extends Cr006_01BaseController {

    /** Cr006_01Service */
    @Autowired
    private Cr006_01Service cr006_01service;

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
    public String executeAction(Model model, Cr006_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 入力チェック
        bizErrors.addAll(checkInput(form));

        // エラー判定
        if (0 < bizErrors.size()) {
            // // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 立替金受入・充当報告書作成（入力画面）への引き渡し情報を設定する。
        // 画面遷移パラメタ定義参照。
        setRequestNextScreen(request, form);

        // 画面遷移を行う。
        return success(Cr006Constants.EVENT_ID_CR006_02INIT);
    }

    /**
     * 業務固有の入力チェック
     *
     * @param form 入力画面情報
     * @return エラーリストを設定したDTO
     */
    private LinkedList<PNMessageInfo> checkInput(Cr006_01Form form) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // ログイン権限情報取得
        String roleCode = "";
        PNCommonInfo loginInfo = PNCommonInfoHolder.getCommonInfo();
        // ログイン権限情報がある場合、権限情報を代入します
        if (null != loginInfo) {
            roleCode = loginInfo.getRoleCode();
        }

        // ログインユーザの権限種別＝受託者の場合実施する
        if (!PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3100E, new String[] {}, false));
            return bizErrors;

        }

        int iCount = 0;
        List<Cr006_01M1DTO> ReportListTable = form.getCr006_01M1TableRecord();
        for (Cr006_01M1DTO m1TableRec : ReportListTable) {
            if ("1".equals(m1TableRec.getID_ChkSelect())) {
                iCount++;
            }
            // 複数選択の場合はエラー
            if (1 < iCount) {
                // メッセージを追加
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3170E, new String[] { "複数の報告対象" },
                        false));
                return bizErrors;
            }
            // 融資番号チェック
            if ("1".equals(m1TableRec.getID_ChkSelect())) {

                // 立替金受入・充当報告書作成ビューから取得した融資番号チェック
                if (!checkYushiBango1(m1TableRec)) {
                    // 立替金受入・充当報告書作成ビューの公庫支店コード、扱店コード、店舗のいずれかが
                    // null、ブランクまたは0の場合、エラーとする。
                    bizErrors.add(
                            new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                            new String[] {
                                "立替金に対応する融資番号が登録されていないため、公庫による追加処理が必要です。" },
                            false));
                    bizErrors.add(
                            new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                            new String[] {
                                "恐れ入りますが、日本政策金融公庫サービスデスクまでご連絡ください。" },
                            false));
                    return bizErrors;

                }

                if (!checkYushiBango2(m1TableRec)) {
                    // 立替金受入・充当報告書作成ビューの年度、方式資金、番号のいずれかがnull、ブランクまたは0の場合、
                    // 扱店別稟議データから融資番号取得
                    Cr006_01DTO inDto = new Cr006_01DTO();
                    // 貸付先コード
                    inDto.setID_Code_Customer(m1TableRec.getID_Code_Customer());
                    // 公庫支店
                    inDto.setID_Code_KoukoShiten(m1TableRec.getID_Code_KoukoShiten());
                    // 扱店
                    inDto.setID_Code_Organization(m1TableRec.getID_Code_Organization());
                    // 店舗
                    inDto.setID_Code_Tenpo(m1TableRec.getID_Code_Tenpo());
                    Cr006_01DTO outDto = cr006_01service.getYushiBango(inDto);

                    // 取得データ件数が１件以上の場合
                    if (outDto != null) {

                        // DTO.年度 ⇒ M1DTO.年度
                        m1TableRec.setID_Year(outDto.getID_Year());
                        // DTO.方式資金 ⇒ M1DTO.方式資金
                        m1TableRec.setID_Code_HoshikiShikin(outDto.getID_Code_HoshikiShikin());
                        // DTO.番号 ⇒ M1DTO.番号
                        m1TableRec.setID_ID_Ringi(outDto.getID_ID_Ringi());
                        // DTO.枝番 ⇒ M1DTO.枝番
                        m1TableRec.setID_ID_RingiBranch(outDto.getID_ID_RingiBranch());

                    }

                    // 扱店別稟議データから取得した融資番号チェック
                    if (outDto == null || !checkYushiBango2(m1TableRec)) {
                        // 取得データ件数が０件 または 扱店別稟議データの年度、方式資金、番号の
                        // いずれかがnull、ブランクまたは0の場合、エラーとする。
                        bizErrors.add(
                                new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                                new String[] {
                                    "立替金に対応する融資番号が登録されていないため、公庫による追加処理が必要です。" },
                                false));
                        bizErrors.add(
                                new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                                new String[] {
                                    "恐れ入りますが、日本政策金融公庫サービスデスクまでご連絡ください。" },
                                false));
                        return bizErrors;

                    }
                }
            }
        }
        // 未選択の場合はエラー
        if (0 == iCount) {
            // メッセージを追加
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3160E, new String[] { "報告対象" }, false));
            return bizErrors;
        }

        return bizErrors;

    }

    /**
     * 遷移パラメータの設定
     *
     * @param request リクエスト情報
     * @param form Se003_01Form
     */
    private void setRequestNextScreen(HttpServletRequest request, Cr006_01Form form) {

        // 入力データの各種チェックを案件分全て行う。
        List<Cr006_01M1DTO> ReportListTable = form.getCr006_01M1TableRecord();
        for (Cr006_01M1DTO m1TableRec : ReportListTable) {
            if ("1".equals(m1TableRec.getID_ChkSelect())) {
                // 受取_顧客名
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_NAME_CUSTOMER,
                        m1TableRec.getID_Name_Customer());
                // 受取_立替日
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_DATE_KARIBARAI,
                        m1TableRec.getID_Date_Karibarai());
                // 受取_立替金の種類
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_KANJOKAMOKU,
                        m1TableRec.getID_Code_KanjoKamoku());
                // 受取_公庫立替金額(円)
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_M_TOSHOKARIBARAI,
                        m1TableRec.getID_M_ToshoKaribarai());
                // 受取_現在の立替金残高(円)
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_M_KARIBARAIZANAFTERSEISAN,
                        m1TableRec.getID_M_KaribaraiZanAfterSeisan());
                // 受取_債権管理番号
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_CREDIT,
                        m1TableRec.getID_ID_Credit());
                // 受取_公庫支店
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_KOUKOSHITEN,
                        m1TableRec.getID_Code_KoukoShiten());
                // 受取_扱店
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_ORGANIZATION,
                        m1TableRec.getID_Code_Organization());
                // 受取_店舗
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_TENPO,
                        m1TableRec.getID_Code_Tenpo());
                // 受取_年度
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_YEAR, m1TableRec.getID_Year());
                // 受取_方式資金
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_HOSHIKISHIKIN,
                        m1TableRec.getID_Code_HoshikiShikin());
                // 受取_番号
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_RINGI, m1TableRec.getID_ID_Ringi());
                // 受取_枝番
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_RINGIBRANCH,
                        m1TableRec.getID_ID_RingiBranch());
                // 受取_本支店コード
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_CODE_HONSHITEN2,
                        m1TableRec.getID_Code_HonShiten());
                // 受取_仮受仮払番号
                addForwardParameter(request, Cr006Constants.PROPERTY_ID_ID_KARIBARAI,
                        m1TableRec.getID_ID_Karibarai());
                // 受取_仮受仮払勘定科目コード
                addForwardParameter(request, Cr006Constants.PROPERTY_CODE_KANJOKAMOKU,
                        m1TableRec.getCode_KanjoKamoku());

            }
        }

    }

    /**
     * 融資番号のNull、ブランクチェック
     *
     * @param chkParam 融資番号の各項目
     * @return 融資番号ブランク：false 融資番号データあり：true
     */
    private boolean checkYushiBango(String chkParam) {

        // nullまたは空文字
        if (PNCommonConstants.LITERAL_BLANK.equals(PNCommonComponents.cnvNulltoBlank(chkParam))
                || Cr006Constants.LITERAL_CHAR_ZERO.equals(chkParam)) {
            return false;

        }
        return true;
    }

    /**
     * 融資番号チェック１
     * 公庫支店コード、扱店コード、店舗の未入力チェックを行う。
     *
     * @param m1TableRec 明細情報
     * @return 融資番号ブランク：false 融資番号データあり：true
     */
    private boolean checkYushiBango1(Cr006_01M1DTO m1TableRec) {

        // 公庫支店コード
        if (!checkYushiBango(m1TableRec.getID_Code_KoukoShiten())) {
            return false;
        }
        // 扱店コード
        if (!checkYushiBango(m1TableRec.getID_Code_Organization())) {
            return false;
        }
        // 店舗
        if (!checkYushiBango(m1TableRec.getID_Code_Tenpo())) {
            return false;
        }

        return true;

    }

    /**
     * 融資番号チェック２
     * 年度、方式資金、番号の未入力チェックを行う。
     *
     * @param m1TableRec 明細情報
     * @return 融資番号ブランク：false 融資番号データあり：true
     */
    private boolean checkYushiBango2(Cr006_01M1DTO m1TableRec) {

        // 年度
        if (!checkYushiBango(m1TableRec.getID_Year())) {
            return false;
        }
        // 方式資金
        if (!checkYushiBango(m1TableRec.getID_Code_HoshikiShikin())) {
            return false;
        }
        // 番号
        if (!checkYushiBango(m1TableRec.getID_ID_Ringi())) {
            return false;
        }

        return true;

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
    public void displayControl(Model model, Cr006_01Form form, HttpServletRequest request) {

    }
}