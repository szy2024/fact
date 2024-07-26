//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.cr005.cr005_04.service.Cr005_04DTO;
import jp.go.jfc.partnernet.cr005.cr005_04.service.Cr005_04Service;
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
 * このクラスはcr005_04の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_04Form")
@RequestMapping(value = "/Cr005_04Init.form")
public class Cr005_04InitController extends Cr005_04BaseController {

    /** Cr005_04Service */
    @Autowired
    Cr005_04Service cr005_04service;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

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
    public String executeAction(Model model, Cr005_04Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 画面項目を初期化
        clearScreen(form);

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 画面の表示制御
        form.setVisible("btnID_Send", false);
        form.setreport1("2");

        // サービスを実行し入力画面データを取得する。
        // 　サービス起動パラメータ設定
        // 　※受渡パラメータがＮＵＬＬの場合もそのまま設定する
        // 　※　　Cr005_01から遷移時は公庫支店コード～枝番
        // 　※　　Cr005_03から遷移時は債権管理番号
        // 　　・債権管理番号
        // 　　・公庫支店コード
        // 　　・扱店コード
        // 　　・店舗コード
        // 　　・年度
        // 　　・方式資金
        // 　　・番号
        // 　　・枝番
        // 　　Cr005_04Service.getResultData // DTOの生成
        // Cr005_04DTO inCr005_04DTO = new Cr005_04DTO();

        // DTOの生成
        Cr005_04DTO inDto = new Cr005_04DTO();

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDto, form);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        // Cr005_04DTO outCr005_04DTO =
        // cr005_04service.getResultData(inCr005_04DTO);
        Cr005_04DTO outDto = cr005_04service.getResultData(inDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // 検索結果の判定
        // 　検索結果が０件の場合、メッセージを表示する。(「lblError」に設定）
        // 　　メッセージ：「条件に一致するデータを取得できませんでした。」
        if (0 < bizErrors.size()) {
            // エラー有の場合自画面表示
            throw new PNServiceException(bizErrors);
        }

        // 画面の表示制御
        form.setVisible("btnID_Send", true);
        form.setreport1("1");

        // 　検索結果有りの場合
        // 　　検索結果を取得する。
        // 　　取得した値を画面に設定する。
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 　　報告書年月日に現在日付を設定する。　　（「yyyy年mm月dd日（ddd）」）
        // ・報告年月日：今日の日付けを　「yyyy年mm月dd日(X)」形式に変換し設定する。
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        form.setTxtID_Date_Report(cnvDateYYYYMMDD(pnBusinessDay));

        // 債権管理番号
        form.setCr005_04_ID_Credit(inDto.getCr005_04_ID_Credit());
        // 公庫支店コード
        form.setCr005_04_Code_ShokanHonShiten(inDto.getCr005_04_Code_ShokanHonShiten());
        // 扱店コード
        form.setCr005_04_Code_Organization(inDto.getCr005_04_Code_Organization());
        // 店舗コード
        form.setCr005_04_Code_Tenpo(inDto.getCr005_04_Code_Tenpo());
        // 年度
        form.setCr005_04_Year(inDto.getCr005_04_Year());
        // 方式資金
        form.setCr005_04_Code_HoshikiShikin(inDto.getCr005_04_Code_HoshikiShikin());
        // 番号
        form.setCr005_04_ID_Ringi(inDto.getCr005_04_ID_Ringi());
        // 枝番
        form.setCr005_04_ID_RingiBranch(inDto.getCr005_04_ID_RingiBranch());

        // return MY_VIEW

        return MY_VIEW;
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
    public void displayControl(Model model, Cr005_04Form form, HttpServletRequest request) {

        // 入力画面データが無い場合、送信ボタンを非表示に設定する。又、明細画面を非表示に設定する

        // 受託者勘定処理年月の活性制御を行う。
        if (PNCommonConstants.JTKSHORI_CONFIGMODE_1.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_2.equals(form.getLblID_JtkshoriConfigMode())
                || PNCommonConstants.JTKSHORI_CONFIGMODE_4.equals(form.getLblID_JtkshoriConfigMode())) {

            // 受託者勘定処理年月設定モード：1（決算期かつ第1～4営業日）または
            // 受託者勘定処理年月設定モード：2（決算期かつ第5～最終営業日）または
            // 受託者勘定処理年月設定モード：4（通常期かつ第11～最終営業日）の場合

            // 受託者勘定処理年月 非活性

            // 　受託者勘定処理年月（元号） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO, true);
            // 　受託者勘定処理年月（年） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN, true);
            // 　受託者勘定処理年月（月） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE, true);

        }
        else if (PNCommonConstants.JTKSHORI_CONFIGMODE_3.equals(form.getLblID_JtkshoriConfigMode())) {
            // 受託者勘定処理年月設定モード：3（通常期かつ第1～10営業日）の場合

            // 受託者勘定処理年月 活性

            // 　受託者勘定処理年月（元号） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORI_GENGO, false);
            // 　受託者勘定処理年月（年） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORI_NEN, false);
            // 　受託者勘定処理年月（月） 非活性
            form.setProtect(Cr005Constants.JSP_ITEM_ID_DATE_JTKSHORITSUKI_CANDIDATE, false);

        }

    }

    /**
     * 区切り文字("/"または"."または"-")入りの西暦日付をYYYYMMDDの形式で返す。
     *
     * @param strDate
     * @return nullの場合は空文字を返す。
     */
    private String cnvDateYYYYMMDD(String strDate) {
        String ret = PNCommonConstants.LITERAL_BLANK;
        if (0 < strDate.indexOf("/")) {
            ret = strDate.replaceAll("/", PNCommonConstants.LITERAL_BLANK);
        } else if (0 < strDate.indexOf(".")) {
            ret = strDate.replaceAll("\\.", PNCommonConstants.LITERAL_BLANK);
        } else if (0 < strDate.indexOf("-")) {
            ret = strDate.replaceAll("-", PNCommonConstants.LITERAL_BLANK);
        } else {
            ret = strDate;
        }

        return ret;
    }

    /**
     * <pre>
     * 画面項目を初期化する。
     * </pre>
     *
     */
    private void clearScreen(Cr005_04Form form) {

        // 債権管理番号（受渡情報)
        form.setCr005_04_ID_Credit(null);
        // 公庫支店コード（受渡情報)
        form.setCr005_04_Code_ShokanHonShiten(null);
        // 扱店コード（受渡情報)
        form.setCr005_04_Code_Organization(null);
        // 店舗コード（受渡情報)
        form.setCr005_04_Code_Tenpo(null);
        // 年度（受渡情報)
        form.setCr005_04_Year(null);
        // 方式資金（受渡情報)
        form.setCr005_04_Code_HoshikiShikin(null);
        // 番号（受渡情報)
        form.setCr005_04_ID_Ringi(null);
        // 枝番（受渡情報)
        form.setCr005_04_ID_RingiBranch(null);

        // 報告年月日
        form.setTxtID_Date_Report("");
        // ステータス
        form.setLblError("");
        // メッセージ
        form.setLblMessage("");
        // 債権管理番号表示
        form.setLblID_ID_Credit_Display("");
        // 顧客名
        form.setTxtID_Name_Customer("");
        // 扱店名
        form.setTxtID_Name_Organization("");
        // 公庫支店
        form.setTxtID_Code_ShokanHonShiten("");
        // 扱店
        form.setTxtID_Code_Organization("");
        // 店舗
        form.setTxtID_Code_Tenpo("");
        // 年度
        form.setTxtID_Year("");
        // 方式資金
        form.setTxtID_Code_HoshikiShikin("");
        // 番号
        form.setTxtID_ID_Ringi("");
        // 枝番
        form.setTxtID_ID_RingiBranch("");
        // 充当対象払込期日（元号）
        form.setDrpID_Date_JutoTaishoGengou("");
        // 充当対象払込期日（年）
        form.setTxtID_Date_JutoTaishoYear("");
        // 充当対象払込期日（月）
        form.setDrpID_Date_JutoTaishoMonth("");
        // 充当対象払込期日（日）
        form.setDrpID_Date_JutoTaishoDay("");
        // 代弁金払込日（元号）
        form.setDrpID_Date_DaibenkinHaraikomiGengou("");
        // 代弁金払込日（年）
        form.setTxtID_Date_DaibenkinHaraikomiYear("");
        // 代弁金払込日（月）
        form.setDrpID_Date_DaibenkinHaraikomiMonth("");
        // 代弁金払込日（日）
        form.setDrpID_Date_DaibenkinHaraikomiDay("");
        // 遅延損害金(円)
        form.setTxtID_M_ChienSongai("");
        // 利息(円)
        form.setTxtID_M_Risoku("");
        // 繰上償還手数料(円)
        form.setTxtID_M_KurishoCommission("");
        // 元金(円)
        form.setTxtID_M_Gankin("");
        // 仮受金(一般口)からの充当額(円)
        form.setTxtID_M_KariukeIppanJuto("");
        // 計(円)
        form.setTxtID_M_Kei("");
        // 送金額(円)
        form.setTxtID_M_Sokin("");
        // 代弁金充当後残元金(円)
        form.setTxtID_M_ZanGanAfterDaibenJuto("");
        // 受託者勘定処理年月（元号）
        form.setDrpID_Date_JtkshoriGengou("");
        // 受託者勘定処理年月（年）
        form.setTxtID_Date_JtkshoriYear("");
        // 受託者勘定処理年月（月）
        form.setDrpID_Date_JtkshoriMonth("");
        // 送金年月日（元号）
        form.setDrpID_Date_SokinGengou("");
        // 送金年月日（年）
        form.setTxtID_Date_SokinYear("");
        // 送金年月日（月）
        form.setDrpID_Date_SokinMonth("");
        // 送金年月日（日）
        form.setDrpID_Date_SokinDay("");
        // 送金日番号
        form.setTxtID_Code_Sokin("");

        // 償還期限年月
        form.setID_Date_ShokanKigen("");
        // 最新更新日時
        form.setID_Data_LastUpDate("");
        // 債権管理番号
        form.setID_Credit("");
        // 貸付金残高
        form.setID_M_KashitsukeZandaka("");
        // 先行する報告書の有無
        form.setID_Previous_Report(true);
        // 先行する報告書名
        form.setID_Previous_ReportType("");
        // 充当対象払込期日
        form.setID_Date_JutoTaisho("");
        // 代弁金払込日
        form.setID_Date_DaibenkinHaraikomi("");
        // 受託者勘定処理年月
        form.setID_Date_Jtkshori("");
        // 送金年月日
        form.setID_Date_Sokin("");
        // 退避請求繰上償還利息
        form.setID_Keep_Seikyu_M_SeiKuriRisoku("");
        // 退避約定利息
        form.setID_Keep_M_YakujoRisoku("");
        // 請求繰上償還利息・仮更新値
        form.setID_M_SeiKuriRisoku("");
        // 約定利息・仮更新値
        form.setID_M_YakujoRisoku("");
        // 退避請求繰上償還元金
        form.setID_Keep_Seikyu_M_SeiKuriGankin("");
        // 退避約定元金
        form.setID_Keep_M_YakujoGankin("");
        // 請求繰上償還元金・仮更新値
        form.setID_M_SeiKuriGankin("");
        // 約定元金・仮更新値
        form.setID_M_YakujoGankin("");
        // ユーザID
        form.setID_UserID("");
        // 伝送番号
        form.setID_ID_Denso("");
        // データコード
        form.setID_DataCode("");
        // ステータス
        form.setID_Status("");
        // 取消済フラグ
        form.setID_Flag_Torikeshizumi("");
        // 処理種別
        form.setID_Type_Process("");
        // 項目エラーフラグ
        form.setID_Error("");
        // 請求検索日付
        form.setID_Date_SearchSeikyu("");
        // 請求検索結果・取得件数
        form.setID_SeikyuCount("");
        // 請求検索結果・約定元金
        form.setID_M_YakujoGankin_SeikyuAns("");
        // 請求検索結果・約定利息
        form.setID_M_YakujoRisoku_SeikyuAns("");
        // 請求検索結果・請求繰上償還元金
        form.setID_M_SeiKuriGankin_SeikyuAns("");
        // 請求検索結果・請求繰上償還利息
        form.setID_M_SeiKuriRisoku_SeikyuAns("");
        // 報告時分秒
        form.setID_Time_Report("");
        // 報告書
        form.setreport1("");

    }
}
