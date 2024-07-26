//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_01InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/24 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_01.web;

import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.md004.md004_01.service.Md004_01DTO;
import jp.go.jfc.partnernet.md004.md004_01.service.Md004_01Service;
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
 * このクラスはmd004_01の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("md004_01Form")
@RequestMapping(value = "/Md004_01Init.form")
public class Md004_01InitController extends Md004_01BaseController {

    /** Md004_01Service */
    @Autowired
    Md004_01Service md004_01service;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Md004_01Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラークリア
        bizErrors.clear();

        // DTO定義
        Md004_01DTO inDto = new Md004_01DTO();
        Md004_01DTO outDto = new Md004_01DTO();

        // 検索項目設定
        // 項目ＩＤが重複しているので、重複した受渡情報を移動させる。
        setSerchItem(inDto, request);

        // サービスを実行し一覧画面データを取得する。
        // Serviceの呼び出し
        outDto = md004_01service.getResultsData(inDto);

        // エラー判定
        bizErrors.addAll(outDto.getBizErrors());
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 検索項目を引き継ぎ
        setSerch(outDto, inDto);

        // フォームへ転記
        setForm(form, outDto);

        // 画面表示
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
    public void displayControl(Model model, Md004_01Form form, HttpServletRequest request) {
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
            default:
                break;
        }

        // 画面の表示・非表示を設定する。
        form.setRedArea(String.valueOf(redArea));
        form.setLblID_Head_Red2(String.valueOf(redArea2));// 赤ラベル
        form.setBlackArea(String.valueOf(blackArea));
        form.setLblID_Head_Red(lbl_Head_Red);
        form.setLblID_Head(lbl_Head_Black);

        // 代弁履行後の作成チェックボックス の初期化
        form.setChkID_ID_After_Daiibensai(null);
        form.setChkID_ID_After_Daiibensai_Red(null);
        form.setProtect("chkID_ID_After_Daiibensai", false);

        // ・画面．処理モード＝「３：処理完了以外・取消」または、「１：処理完了・取消」または、　「２：処理完了・修正」　の場合
        // ・画面．処理モード＝「４：処理完了以外・修正」または「２：処理完了・修正」の場合
        if (1 <= processMode && 4 >= processMode) {
            // 　代位弁済後のチェックを設定する。
            // 　　方式資金が設定されている場合
            if (0 != PNCommonComponents.cnvNulltoBlank(form.getTxtID_Code_HoshikiShikin()).length()) {
                // 　　　データコードが「９０２５７１００」の場合、代位弁済後のチェックをTrueにする。
                // 　　　上記以外の場合、代位弁済後のチェックをFalseにする。
                if ("90257100".equals(PNCommonComponents.cnvNulltoBlank(form.getID_DataCode()))) {
                    form.setChkID_ID_After_Daiibensai("1");
                    form.setChkID_ID_After_Daiibensai_Red("1");
                } else {
                    form.setChkID_ID_After_Daiibensai(null);
                    form.setChkID_ID_After_Daiibensai_Red(null);
                }
            } else {
                // 　　方式資金が設定されていない場合
                // 　　　代位弁済後のチェックを非活性とし、Falseにする。
                form.setChkID_ID_After_Daiibensai(null);
                form.setChkID_ID_After_Daiibensai_Red(null);
                form.setProtect("chkID_ID_After_Daiibensai", true);
            }
        }
    }

    /**
     *
     * <pre>
     * 検索項目設定
     * </pre>
     *
     * @param paramMap
     */
    private void setSerchItem(Md004_01DTO inDto, HttpServletRequest request) {
        // 受渡パラメータを取得する。
        Map<String, Object> paramMap = getForwardParameter(request);

        // 項目ＩＤが重複しているので、重複した受渡情報を移動させる。

        // ・Form.処理種別(修正)⇒Form.処理種別(受渡)
        inDto.setID_Type_Process_H((String) paramMap.get("ProcessMode"));

        // ・Form.ステータス(修正)⇒Form.ステータス(受渡)
        inDto.setID_Status_H((String) paramMap.get("ID_Status"));

        // ・Form.報告書番号(修正)⇒Form.報告書番号(受渡)
        inDto.setID_ID_Report_H((String) paramMap.get("ID_ID_Report"));

        // ・Form.時刻(修正)⇒Form.報告時分秒(受渡)
        inDto.setID_Time_Report_H((String) paramMap.get("ID_Time_Report"));

        // ・Form.報告書種別(修正)⇒Form.報告書種別(受渡)
        inDto.setID_DataCode_H((String) paramMap.get("ID_BizJoinItem_DataCode"));
    }

    /**
     *
     * <pre>
     * 検索項目引継
     * </pre>
     *
     * @param outDto
     * @param inDto
     */
    private void setSerch(Md004_01DTO outDto, Md004_01DTO inDto) {
        outDto.setID_Type_Process_H(inDto.getID_Type_Process_H());
        outDto.setID_Status_H(inDto.getID_Status_H());
        outDto.setID_ID_Report_H(inDto.getID_ID_Report_H());
        outDto.setID_Time_Report_H(inDto.getID_Time_Report_H());
        outDto.setID_DataCode_H(inDto.getID_DataCode_H());
    }

    /**
     *
     * <pre>
     * フォームへの転記処理
     * </pre>
     *
     * @param form
     * @param inDto
     */
    private void setForm(Md004_01Form form, Md004_01DTO inDto) {

        // Dtoからフォームへ転記
        CFWBeanUtils.copyProperties(form, inDto);

        // ■報告年月日
        // 画面の報告年月日に業務日付＋現在日時を設定　　（yyyy年MM月dd日（ddd）　形式）
        // 形式変換はjspファイルのfmtタグで対応

        // 　・報告年月日（西暦）　　 →　画面．報告年月日
        form.setID_Date_Report(pnCommonDBComponents.getPNBusinessDay(1));

    }

}