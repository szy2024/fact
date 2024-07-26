//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.web;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

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

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.md004.md004_02.service.Md004_02DTO;
import jp.go.jfc.partnernet.md004.md004_02.service.Md004_02Service;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNMessageUtils;

/**
 * <pre>
 * このクラスはmd004_02の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md004_02Form")
@RequestMapping(value = "/Md004_02Init.form")
public class Md004_02InitController extends Md004_02BaseController {

    /** Md004_02Service */
    @Autowired
    Md004_02Service md004_02service;

    @Autowired
    PNCommonDBComponents PNCommonDBComponents;

    /**
     * <pre>
     * 初期表示の処理を行います。
     * </pre>
     *
     * {@inheritDoc}
     * @throws Exception
     * @see jp.go.jfc.partnernet.pnfw.web.control.PNNormalBaseController#executeAction(org.springframework.ui.Model,
     *      jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm, org.springframework.validation.Errors,
     *      javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String executeAction(Model model, Md004_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        bizErrors.clear();

        // DTOの生成
        Md004_02DTO inDto = new Md004_02DTO();

        // 受渡パラメータを取得する。

        // 処理種別を設定
        form.setID_Type_Process_H((String) getForwardParameter(request).get("ProcessMode"));

        // 画面に表示するメッセージの作成
        // 画面メッセージに、PM1010Iを設定する。
        form.setLblMessage(PNMessageUtils.getString(PNCommonMessageConstants.PM1010I));

        // 処理モードが処理完了以外：更正(赤)取消(5)の場合
        if ("5".equals(form.getID_Type_Process_H())) {
            // ・報告年月日（西暦） →画面．報告年月日
            form.setTxtID_Date_Report(PNCommonDBComponents
                    .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
            // ・報告時分秒→画面．報告時分秒
            form.setID_Time_Report_H((String) getForwardParameter(request).get("ID_Time_Report"));
            // ・報告書種別（値）→画面．報告書種別（値）
            form.setID_DataCode_H((String) getForwardParameter(request).get("ID_BizJoinItem_DataCode"));
            // ・ステータス→画面．ステータス※２：処理完了／２以外：処理完了以外
            form.setID_Status_H((String) getForwardParameter(request).get("ID_Status"));
            // ・報告書番号→画面．報告書番号
            form.setID_ID_Report_H((String) getForwardParameter(request).get("ID_ID_Report"));
        } else {
            // パラメータを取得
            // リクエスト⇒Formに転記
            mappingForwardParameterToForm(request, form);
        }

        // 画面の全項目をDTO項目から設定する。
        CFWBeanUtils.copyProperties(inDto, form);

        // 処理モードが処理完了以外：更正(赤)取消(5)の場合
        if ("5".equals(form.getID_Type_Process_H())) {
            // １．一覧画面データの取得をする。
            // （１）サービスを実行し、一覧画面データを取得する。
            Md004_02DTO outDto = new Md004_02DTO();
            outDto = md004_02service.getResultsData(inDto);
            // 取得したデータを初期データに格納する。
            CFWBeanUtils.copyProperties(form, outDto);

            // フォームのテキスト項目より各ラベル表示
            this.setLabel(form);
        }
        // 処理モードが処理完了以外：更正(赤)取消の場合
        else {
            // 画面構成
            // フォームのテキスト項目より各ラベル表示
            this.setLabel(form);
        }

        // 貸付金残高の再計算を行う
        // 処理モードが処理完了以外：修正、処理完了：修正の場合
        // 繰償事由コードが空白以外の場合、再計算を行う。
        // 初期データの貸付残高＝元金＋繰償後残元金
        if ("4".equals(form.getID_Type_Process_H()) && "2".equals(form.getID_Type_Process_H())) {
            if (0 != this.getStrLength(form.getDrpID_Code_Kurishojiyu())) {
                form.setID_Keep_M_KashitsukeZan(cnvStrToBig(form.getTxtID_M_KurishoGankin()).add(
                        cnvStrToBig(form.getTxtID_M_ZanGankinAfterKurisho())).toString());
            }
        }

        // 「戻る」ボタンメッセージの作成
        // 　処理モードが処理完了以外更正(赤)取消の場合
        // 　　戻るメッセージに「取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        // 　　戻るボタンのToolTipに、「取消・修正対象報告書の一覧画面へ戻る」を設定する。
        // 　処理モードが処理完了以外更正(赤)取消以外の場合
        // 　　戻るメッセージに「繰上償還受入・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。」を設定する。
        if (form.getID_Type_Process_H().equals(PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL_CANCEL)) {
            form.setLblMessage("取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。");
        } else {
            form.setLblMessage("繰上償還受入・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。");
        }

        return MY_VIEW;
    }

    /**
     *
     * <pre>
     * フォームのラベルを設定します
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void setLabel(Md004_02Form form) {
        // 入力内容より画面のラベルを生成

        // 報告年月日
        form.setLblID_Date_Report(form.getTxtID_Date_Report());
        // 顧客名
        form.setLblID_Name_Customer(form.getTxtID_Name_Customer());
        form.setLblID_Name_Customer_Red(form.getTxtID_Name_Customer_Red());
        // 扱店名
        form.setLblID_Name_Organization(form.getTxtID_Name_Organization());
        form.setLblID_Name_Organization_Red(form.getTxtID_Name_Organization_Red());
        // 公庫支店
        form.setLblID_Code_KoukoShiten(form.getTxtID_Code_KoukoShiten());
        form.setLblID_Code_KoukoShiten_Red(form.getTxtID_Code_KoukoShiten_Red());
        // 扱店
        form.setLblID_Code_Organization(form.getTxtID_Code_Organization());
        form.setLblID_Code_Organization_Red(form.getTxtID_Code_Organization_Red());
        // 店舗
        form.setLblID_Code_Tenpo(form.getTxtID_Code_Tenpo());
        form.setLblID_Code_Tenpo_Red(form.getTxtID_Code_Tenpo_Red());
        // 年度
        form.setLblID_Year(form.getTxtID_Year());
        form.setLblID_Year_Red(form.getTxtID_Year_Red());
        // 方式資金
        form.setLblID_Code_HoshikiShikin(form.getTxtID_Code_HoshikiShikin());
        form.setLblID_Code_HoshikiShikin_Red(form.getTxtID_Code_HoshikiShikin_Red());
        // 番号
        form.setLblID_ID_Ringi(form.getTxtID_ID_Ringi());
        form.setLblID_ID_Ringi_Red(form.getTxtID_ID_Ringi_Red());
        // 枝番
        form.setLblID_ID_RingiBranch(cnvZeroToBlank(form.getTxtID_ID_RingiBranch()));
        form.setLblID_ID_RingiBranch_Red(cnvZeroToBlank(form.getTxtID_ID_RingiBranch_Red()));
        // 償還後第1回払込期日
        form.setLblID_Date_FirstHaraikomiAfterKurisho(form.getID_Date_FirstHaraikomiAfterKurisho_Input());
        form.setLblID_Date_FirstHaraikomiAfterKurisho_Red(form.getTxtID_Date_FirstHaraikomiAfterKurisho_Red());
        // 入金日
        form.setLblID_Date_Nyukin(form.getID_Date_Nyukin_Input());
        form.setLblID_Date_Nyukin_Red(form.getTxtID_Date_Nyukin_Red());
        // 繰償事由コード
        form.setLblID_Code_Kurishojiyu(form.getDrpID_Code_Kurishojiyu());
        form.setLblID_Code_Kurishojiyu_Red(form.getTxtID_Code_Kurishojiyu_Red());
        // 利息
        form.setLblID_M_KurishoRisoku(getLblCommaZero(form.getTxtID_M_KurishoRisoku()));
        form.setLblID_M_KurishoRisoku_Red(getLblCommaZero(form.getTxtID_M_KurishoRisoku_Red()));
        // 元金
        form.setLblID_M_KurishoGankin(getLblCommaZero(form.getTxtID_M_KurishoGankin()));
        form.setLblID_M_KurishoGankin_Red(getLblCommaZero(form.getTxtID_M_KurishoGankin_Red()));
        // 控除利息
        form.setLblID_M_KojoRisoku(getLblCommaZero(form.getTxtID_M_KojoRisoku()));
        form.setLblID_M_KojoRisoku_Red(getLblCommaZero(form.getTxtID_M_KojoRisoku_Red()));
        // 繰償手数料
        form.setLblID_M_KurishoCommission(getLblCommaZero(form.getTxtID_M_KurishoCommission()));
        form.setLblID_M_KurishoCommission_Red(getLblCommaZero(form.getTxtID_M_KurishoCommission_Red()));
        // 仮受金からの充当額
        if ("0".equals(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto()))) {
            form.setLblID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_KariukeIppanJuto(getLblCommaZero(form.getTxtID_M_KariukeIppanJuto()));
        }
        if ("0".equals(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_KariukeIppanJuto_Red()))) {
            form.setLblID_M_KariukeIppanJuto_Red(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_KariukeIppanJuto_Red(getLblCommaZero(form.getTxtID_M_KariukeIppanJuto_Red()));
        }
        // 送金額
        if ("0".equals(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_Sokin()))) {
            form.setLblID_M_Sokin(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_Sokin(getLblCommaZero(form.getTxtID_M_Sokin()));
        }
        if ("0".equals(PNCommonComponents.cnvNulltoZero(form.getTxtID_M_Sokin_Red()))) {
            form.setLblID_M_Sokin_Red(PNCommonConstants.LITERAL_BLANK);
        } else {
            form.setLblID_M_Sokin_Red(getLblCommaZero(form.getTxtID_M_Sokin_Red()));
        }
        // 繰償後残元金
        form.setLblID_M_ZanGankinAfterKurisho(getLblCommaZero(form.getTxtID_M_ZanGankinAfterKurisho()));
        form.setLblID_M_ZanGankinAfterKurisho_Red(getLblCommaZero(form.getTxtID_M_ZanGankinAfterKurisho_Red()));
        // 送金日
        form.setLblID_Date_Sokin(form.getID_Date_Sokin_Input());
        form.setLblID_Date_Sokin_Red(form.getTxtID_Date_Sokin_Red());
        // 送金日番号
        form.setLblID_ID_Sokinbi(form.getTxtID_ID_Sokinbi());
        form.setLblID_ID_Sokinbi_Red(form.getTxtID_ID_Sokinbi_Red());
        // ※代弁履行後の作成は前画面のまま引き継ぎ
        // 払込期日１～４
        form.setLblID_Date_Haraikomi1(form.getID_Date_Haraikomi1_Input());
        form.setLblID_Date_Haraikomi1_Red(form.getTxtID_Date_Haraikomi1_Red());
        form.setLblID_Date_Haraikomi2(form.getID_Date_Haraikomi2_Input());
        form.setLblID_Date_Haraikomi2_Red(form.getTxtID_Date_Haraikomi2_Red());
        form.setLblID_Date_Haraikomi3(form.getID_Date_Haraikomi3_Input());
        form.setLblID_Date_Haraikomi3_Red(form.getTxtID_Date_Haraikomi3_Red());
        form.setLblID_Date_Haraikomi4(form.getID_Date_Haraikomi4_Input());
        form.setLblID_Date_Haraikomi4_Red(form.getTxtID_Date_Haraikomi4_Red());
        // 払込元金1～4
        form.setLblID_M_HaraikomiGankin1(getLblComma(form.getTxtID_M_HaraikomiGankin1()));
        form.setLblID_M_HaraikomiGankin1_Red(getLblComma(form.getTxtID_M_HaraikomiGankin1_Red()));
        form.setLblID_M_HaraikomiGankin2(getLblComma(form.getTxtID_M_HaraikomiGankin2()));
        form.setLblID_M_HaraikomiGankin2_Red(getLblComma(form.getTxtID_M_HaraikomiGankin2_Red()));
        form.setLblID_M_HaraikomiGankin3(getLblComma(form.getTxtID_M_HaraikomiGankin3()));
        form.setLblID_M_HaraikomiGankin3_Red(getLblComma(form.getTxtID_M_HaraikomiGankin3_Red()));
        form.setLblID_M_HaraikomiGankin4(getLblComma(form.getTxtID_M_HaraikomiGankin4()));
        form.setLblID_M_HaraikomiGankin4_Red(getLblComma(form.getTxtID_M_HaraikomiGankin4_Red()));
        // 繰償後元金均等額
        form.setLblID_M_GankinKintoAfterKurisho(getLblComma(form.getTxtID_M_GankinKintoAfterKurisho()));
        form.setLblID_M_GankinKintoAfterKurisho_Red(getLblComma(form.getTxtID_M_GankinKintoAfterKurisho_Red()));
        // 繰償後元金不均等額
        form.setLblID_M_GankinFukintoAfterKurisho(getLblComma(form.getTxtID_M_GankinFukintoAfterKurisho()));
        form.setLblID_M_GankinFukintoAfterKurisho_Red(getLblComma(form
                .getTxtID_M_GankinFukintoAfterKurisho_Red()));

        // 受託者勘定処理年月
        form.setLblID_Date_JtkShori(form.getID_Date_Jtkshori_Input());
        form.setLblID_Date_JtkShori_Red(form.getID_Date_Jtkshori_Red_Input());

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
    public void displayControl(Model model, Md004_02Form form, HttpServletRequest request) {
        // 受渡パラメータの処理モードにより画面表示タイプを決定する。

        // 処理モード判定用変数 定義
        int processMode = Integer.parseInt(PNCommonComponents.cnvNulltoZero(form.getID_Type_Process_H()));

        // 領域表示判定用変数 定義
        boolean redArea = false;
        boolean redArea2 = false;
        boolean blackArea = false;
        String lbl_Head_Red = "";
        String lbl_Head_Black = "";

        // 画面．処理モード毎に、画面項目表示／非表示設定を行う。
        switch (processMode) {
        // ・画面．処理モード ＝ 「１：処理完了・取消」の場合、下記設定を行う
        // 表示- 赤データ入力領域
        // 非表示- 黒データ入力領域
            case (1):
                redArea = true;
                blackArea = false;
                // パネル内のヘッダーに「更正」を設定
                lbl_Head_Red = "更正";
                // 赤は表示
                redArea2 = true;
                break;
            // ・画面．処理モード ＝ 「２：処理完了・修正」の場合、下記設定を行う
            // 表示- 赤データ入力領域
            // 表示- 黒データ入力領域
            case (2):
                redArea = true;
                blackArea = true;
                // パネル内のヘッダーに「更正」を設定
                lbl_Head_Red = "更正";
                // パネル内のヘッダーに「更正 黒」を設定
                lbl_Head_Black = "更正 黒";
                // 赤は表示
                redArea2 = true;
                break;
            // ・画面．処理モード ＝ 「３：処理完了以外・取消」の場合、下記設定を行う
            // 表示- 赤データ入力領域
            // 非表示- 黒データ入力領域
            case (3):
                redArea = true;
                blackArea = false;
                // パネル内のヘッダーに「取消内容」を設定
                lbl_Head_Red = "取消内容";
                // 赤は非表示
                redArea2 = false;
                break;
            // ・画面．処理モード ＝ 「４：処理完了以外・修正」の場合、下記設定を行う
            // 非表示- 赤データ入力領域
            // 表示- 黒データ入力領域
            case (4):
                redArea = false;
                blackArea = true;
                // パネル内のヘッダーに「修正内容 」を設定
                lbl_Head_Black = "修正内容";
                // 赤は表示
                redArea2 = true;
                break;
            case (5):
                redArea = true;
                blackArea = false;
                // パネル内のヘッダーに「取消内容」を設定
                lbl_Head_Red = "取消内容";
                // 赤は非表示
                redArea2 = false;
                // 代位弁済チェック項目設定
                if (0 != PNCommonComponents.cnvNulltoBlank(form.getTxtID_Code_HoshikiShikin_Red()).length()) {
                    if ("90257100".equals(PNCommonComponents.cnvNulltoBlank(form.getID_DataCode_H()))) {
                        form.setChkID_ID_After_Daiibensai_Red("1");
                    } else {
                        form.setChkID_ID_After_Daiibensai_Red(null);
                    }
                } else {
                    form.setChkID_ID_After_Daiibensai_Red(null);
                }

                break;
        }

        // 画面の表示・非表示を設定する。
        form.setRedArea(String.valueOf(redArea));
        form.setLblID_Head_Red2(String.valueOf(redArea2));// 赤ラベル
        form.setBlackArea(String.valueOf(blackArea));
        form.setLblID_Head_Red(lbl_Head_Red);
        form.setLblID_Head(lbl_Head_Black);

    }

    /**
     *
     * <pre>
     * ラベルコンマ表示用
     * </pre>
     *
     * @param param
     * @return
     */
    private String getLblComma(String param) {
        // 引数がnullの場合は空白を返す。
        if (null == param || 0 == param.length()) {
            return "";
        }
        try {
            return PNCommonUtils.addComma(new BigDecimal(param));
        } catch (NumberFormatException e) {
            return "";
        }
    }

    /**
     *
     * <pre>
     * ラベルコンマ表示用
     * </pre>
     *
     * @param param
     * @return
     */
    private String getLblCommaZero(String param) {
        // 引数がnullの場合は0を返す。
        if (null == param || 0 == param.length()) {
            return "0";
        }
        try {
            return PNCommonUtils.addComma(new BigDecimal(param));
        } catch (NumberFormatException e) {
            return "0";
        }
    }

    /**
     *
     * <pre>
     * String型をBigDecimal型に型に変換します。
     * 引数がnullの場合0を返します。
     * 引数が数字に変換できない場合は、nullを返します。
     * </pre>
     *
     * @param 文字列
     * @return 数字
     */
    private BigDecimal cnvStrToBig(String param) {
        // 引数がnullの場合は0を返す。
        if (null == param || 0 == param.length()) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(param);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

    /**
     *
     * <pre>
     * ０が渡されたときに空白にします。
     * </pre>
     *
     * @param param
     * @return
     */
    private String cnvZeroToBlank(String param) {
        if (null == param || 0 == param.length() || "0".equals(param)) {
            return "";
        }
        return param;
    }

    /**
     *
     * <pre>
     * 文字列の長さを返す。
     * </pre>
     *
     * @param param
     * @return
     */
    private int getStrLength(String param) {
        if (null == param) {
            return 0;
        }
        return PNCommonComponents.cnvNulltoBlank(param).length();
    }

}