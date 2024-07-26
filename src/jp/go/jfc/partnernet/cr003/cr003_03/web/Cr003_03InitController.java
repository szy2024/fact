//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/10 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_03.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonStringUtils;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.cr003.cr003_02.service.Cr003_02M1DTO;
import jp.go.jfc.partnernet.cr003.cr003_03.service.Cr003_03M1DTO;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;

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
 * このクラスはCr003_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr003_03Form")
@RequestMapping(value = "/Cr003_03Init.form")
public class Cr003_03InitController extends Cr003_03BaseController {

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
    public String executeAction(Model model, Cr003_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // 受渡パラメータ.を取得する。
        // 　※「案件」について、CR003_03の画面項目ＩＤに入直す。
        // 受渡情報の報告年月日を画面項目の報告年月日に設定
        mappingForwardParameterToForm(request, form);

        // 受渡パラメータ.の設定値変更
        form.setCr003_03M1TableRecord(editMeisai(form.getCr003_02MEISAI_AnkenLIST()));
        form.getCr003_03M1Table().setResultsPerPage(form.getCr003_02MEISAI_AnkenLIST().size());

        // 代弁履行後の作成チェックボックスを選択不可にする。
        for (int i = 0; i < form.getCr003_02MEISAI_AnkenLIST().size(); i++) {
            form.setProtect("cr003_03M1Table.recordList[" + i + "].ckhAfter_Daibensai", true);
        }

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
    public void displayControl(Model model, Cr003_03Form form, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 受渡パラメータ.の設定値変更。
     * </pre>
     *
     * @param meisaiList
     * @return
     */
    private List<Cr003_03M1DTO> editMeisai(List<Cr003_02M1DTO> meisaiList) {
        // 　全案件分処理する

        // 画面項目の設定
        // 　受渡情報の全明細リストに対し転送仕様に則ってデータ加工を行う。
        // 　※そのまま表示できる項目に対しては加工不要。

        // 権限種別を取得
        String loginUserID = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            loginUserID = commonInfo.getLogonID();
        }

        List<Cr003_03M1DTO> outList = new ArrayList<Cr003_03M1DTO>(0);

        for (Cr003_02M1DTO meisaiRec : meisaiList) {

            Cr003_03M1DTO outListRec = new Cr003_03M1DTO();

            // 以下UI画面項目転送より項目より追記
            // 案件 引渡情報の「案件］
            outListRec.setID_Anken_Index(meisaiRec.getID_Anken_Index());
            // 顧客名 引渡情報の「「顧客名」
            outListRec.setID_Name_Customer(meisaiRec.getID_Name_Customer());
            // 扱店名 引渡情報の「「扱店名」
            outListRec.setID_Name_Organization(meisaiRec.getID_Name_Organization());
            // 公庫支店コード 引渡情報の「「公庫支店」
            outListRec.setID_Code_ShokanHonShiten(meisaiRec.getID_Code_ShokanHonShiten());
            // 扱店コード 引渡情報の「扱店」
            outListRec.setID_Code_Organization(meisaiRec.getID_Code_Organization());
            // 店舗コード 引渡情報の「店舗」
            outListRec.setID_Code_Tenpo(meisaiRec.getID_Code_Tenpo());
            // 年度 引渡情報の「年度」　引渡情報は和暦(H15 / H1)なのでそのまま設定
            outListRec.setID_Year(meisaiRec.getID_Year());
            // 方式資金 引渡情報の「方式資金」
            outListRec.setID_Code_HoshikiShikin(meisaiRec.getID_Code_HoshikiShikin());
            // 番号 引渡情報の「番号」
            outListRec.setID_ID_Ringi(meisaiRec.getID_ID_Ringi());
            // 枝番 引渡情報の「枝番」　値が０の場合、空文字を設定
            outListRec.setID_ID_RingiBranch(meisaiRec.getID_ID_RingiBranch());
            // 貸付実行日 引渡情報の「貸付実行日」　引渡情報は和暦(H15.12.25 / H1.2.3)なのでそのまま設定
            outListRec.setID_Date_Jikko(meisaiRec.getID_Date_Jikko());
            // 貸付実行金額 引渡情報の「貸付実行金額」
            outListRec.setID_M_Kashitsuke(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_Kashitsuke()));
            // 資金使途コード 引渡情報の「資金使途」
            outListRec.setID_Code_ShikinShito(meisaiRec.getID_Code_ShikinShito());
            // 事業別 引渡情報の「事業別」
            outListRec.setID_Code_Jigyobetsu(meisaiRec.getID_Code_Jigyobetsu());
            // 利率（％）引渡情報の「利率（％）」　引渡情報は少数点編集値なのでそのまま設定
            outListRec.setID_Riritsu(meisaiRec.getID_Riritsu());
            // 特利区分 引渡情報の「特利区分」
            outListRec.setID_Kubun_Tokuri(meisaiRec.getID_Kubun_Tokuri());
            // 特利（％）引渡情報の「特利（％）」　引渡情報は少数点編集値なのでそのまま設定
            outListRec.setID_Tokuri(meisaiRec.getID_Tokuri());
            // 償還方法 引渡情報の「償還方法」
            outListRec.setID_Code_ShokanHouhou(meisaiRec.getID_Code_ShokanHouhou());
            // 据置期限 引渡情報の「据置期限」　引渡情報は和暦(H15.12 / H1.2)なのでそのまま設定
            outListRec.setID_Date_SueokiKigen(meisaiRec.getID_Date_SueokiKigen());
            // 償還期限 引渡情報の「償還期限」　引渡情報は和暦(H15.12 / H1.2)なのでそのまま設定
            outListRec.setID_Date_ShokanKigen(meisaiRec.getID_Date_ShokanKigen());
            // 元利金払込日 引渡情報の「元利金払込日」　引渡情報は月日(12.25 / 2.3)なのでそのまま設定
            outListRec.setID_Date_GanrikinHaraiKomi(meisaiRec.getID_Date_GanrikinHaraiKomi());
            // 元利または元金均等額（円） 引渡情報の「元利または元金均等額」
            outListRec.setID_M_Fukin(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_Fukin()));
            // 払込前残元金（円） 引渡情報の「払込前残元金」
            outListRec.setID_M_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(meisaiRec
                    .getID_M_KashitsukeZandaka()));
            // 払込期日 引渡情報の「払込期日」　引渡情報は和暦(H15.12.25 / H1.2.3)なのでそのまま設定
            outListRec.setID_Date_Haraikomi(meisaiRec.getID_Date_Haraikomi());
            // 引渡情報の「払込金額」
            // 　　約定利息（引渡情報）＋約定元金（引渡情報）を計算して設定
            // 　　※計算対象データの空文字は０として計算する
            outListRec.setID_M_Haraikomi((PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_YakujoRisoku())
                    .add(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_YakujoGankin()))).toString());
            // 控除利息（円）
            outListRec.setID_M_KojoRisoku(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_KojoRisoku()));
            // 差引払込金額（円）
            // 引渡情報の「差引払込金額」
            // 　　約定利息（引渡情報）＋約定元金（引渡情報）＋違約金＋
            // 　　違約金（利子軽減分）＋遅延損害金 - 控除利息（引渡情報）を
            // 　　計算し設定
            // 　　※計算対象データの空文字は０として計算する
            if ("0".equals(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_KariukeIppanJuto()))) {
                outListRec.setID_M_SashihikiHaraikomi((PNCommonUtils
                        .cnvBigStrMoney(meisaiRec.getID_M_YakujoRisoku())
                        .add(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_YakujoGankin()))
                        .add(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_Iyaku()))
                        .add(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_IyakuRishikeigen()))
                        .add(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_ChienSongai()))
                        .subtract(PNCommonUtils.cnvBigStrMoney(meisaiRec.getID_M_KojoRisoku()))).toString());
            }
            // 引渡情報の「払込後残元金」
            // 　　払込前残元金－約定元金（引渡情報）を計算し設定
            // 　　※計算対象データの空文字は０として計算する
            outListRec.setID_M_ZangankinAfterHaraikomi((PNCommonUtils.cnvBigStrMoney(meisaiRec
                    .getID_M_KashitsukeZandaka()).subtract(PNCommonUtils.cnvBigStrMoney(meisaiRec
                    .getID_M_YakujoGankin()))).toString());
            // 約定利息
            outListRec
                    .setID_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_YakujoRisoku()));
            // 約定元金
            outListRec
                    .setID_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_YakujoGankin()));
            // 遅延損害金（円）
            outListRec.setID_M_ChienSongai(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_ChienSongai()));
            // 違約金（円）
            outListRec.setID_M_Iyaku(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_Iyaku()));
            // 違約金（利子軽減分）（円）
            outListRec.setID_M_IyakuRishikeigen(PNCommonComponents.cnvNulltoZero(meisaiRec
                    .getID_M_IyakuRishikeigen()));
            // 仮受金からの充当額（円）
            if ("0".equals(PNCommonComponents.cnvNulltoZero(meisaiRec.getID_M_KariukeIppanJuto()))) {
                outListRec.setID_M_KariukeIppanJuto("");
            } else {
                outListRec.setID_M_KariukeIppanJuto(PNCommonComponents.cnvNulltoZero(meisaiRec
                        .getID_M_KariukeIppanJuto()));
            }
            // 送金日番号
            outListRec.setID_ID_Sokinbi(meisaiRec.getID_ID_Sokinbi());
            // 代弁履行後の作成
            outListRec.setCkhAfter_Daibensai(meisaiRec.getCkhAfter_Daibensai());
            // 入金日 引渡情報の「入金日」　引渡情報は和暦(H15.12.25 / H01.02.03)形式。年月日の頭０をサプレスして設定
            outListRec.setID_Date_Nyukin(castWarekiToFormat(meisaiRec.getID_Date_Nyukin_Gengo(),
                    meisaiRec.getID_Date_Nyukin_Nen(), meisaiRec.getID_Date_NyukinTsuki(),
                    meisaiRec.getID_Date_NyukinBi(), false));

            // 送金日 引渡情報の「送金日」　引渡情報は和暦(H15.12.25 / H01.02.03)形式。年月日の頭０をサプレスして設定
            // 年月日の頭０をサプレスして設定
            outListRec.setID_Date_Sokin(castWarekiToFormat(meisaiRec.getID_Date_Sokin_Gengo(),
                    meisaiRec.getID_Date_Sokin_Nen(), meisaiRec.getID_Date_SokinTsuki(),
                    meisaiRec.getID_Date_SokinBi(), true

            ));
            // 受託者勘定処理年月 引渡情報は和暦(H15.12 / H01.02)形式。年月の頭０をサプレスして設定
            outListRec.setID_Date_Jtkshori(castWarekiToFormat2(meisaiRec.getID_Date_Jtkshori_Gengo(),
                    meisaiRec.getID_Date_Jtkshori_Nen(), meisaiRec.getID_Date_JtkshoriTsuki(), "01", false));

            // 以下ＳＳに記載

            // 　　・ユーザＩＤにログインユーザＩＤを設定
            outListRec.setID_UserID(loginUserID);
            // 　　・伝送番号に空文字を設定
            outListRec.setID_ID_Denso("");
            // 　　・データコード設定
            // 　　　代弁履行後の作成フラグ（チェックボックス項目）がチェックされている場合、"90257040"を設定
            // 　　　代弁履行後の作成フラグ（チェックボックス項目）がチェックされていない場合、"90257030"を設定
            if ("1".equals(PNCommonComponents.cnvNulltoBlank(meisaiRec.getCkhAfter_Daibensai()))) {
                outListRec.setID_DataCode("90257040");
            } else {
                outListRec.setID_DataCode("90257030");
            }
            // 　　・残高件数に０を設定
            outListRec.setID_Count_Zandaka("0");
            // 　　・ステータスに”１”予約中　を設定
            outListRec.setID_Status("1");
            // 　　・処理種別に”００”を設定
            outListRec.setID_Type_Process("00");
            // 　　・取得済フラグに”０”（取消ではない）を設定
            outListRec.setID_Flag_Torikeshizumi("0");
            // 　　・エラー番号に空文字を設定
            outListRec.setID_Code_Error("");
            // 　　・エラーメッセージに空文字を設定
            outListRec.setID_ErrorMessage("");
            // 　　・電子署名付きデータに空文字を設定
            outListRec.setID_SignData("");
            // 　　・原本番号にNULLを設定 →サービスにてNULLを設定しています。
            outListRec.setID_ID_Master("");

            // 債権管理番号
            outListRec.setID_ID_Credit(meisaiRec.getID_ID_Credit());

            outListRec.setID_Flag_Kj(meisaiRec.getID_Flag_Kj());

            // 　　　　　退避償還期限年月の設定
            outListRec.setID_Keep_Date_ShokanKigen(meisaiRec.getID_Date_ShokanKigen());
            // 　　　　　退避貸付金残高の設定
            outListRec.setID_Keep_M_KashitsukeZan(meisaiRec.getID_Keep_M_KashitsukeZan());
            // 　　　　　退避約定元金の設定
            outListRec.setID_Keep_M_YakujoGankin(meisaiRec.getID_Keep_M_YakujoGankin());
            // 　　　　　退避約定利息の設定
            outListRec.setID_Keep_M_YakujoRisoku(meisaiRec.getID_Keep_M_YakujoRisoku());

            // 最終更新日時
            if (null != meisaiRec.getID_Data_LastUpDate() && !"".equals(meisaiRec.getID_Data_LastUpDate())) {
                outListRec.setID_Data_LastUpDate(new StringBuffer(meisaiRec.getID_Data_LastUpDate())
                        .substring(0, 10).replaceAll("-", ""));
            }

            // 　　　　　報告時分秒
            outListRec.setID_Time_Report(meisaiRec.getID_Time_Report());

            outList.add(outListRec);
        }

        return outList;

    }

    /**
     *
     * <pre>
     * 和暦に変換
     * </pre>
     *
     * @param gengo
     * @param year
     * @param month
     * @param day
     * @param noday
     * @return
     */
    private String castWarekiToFormat(String gengo, String year, String month, String day, boolean noday) {

        if (0 == PNCommonComponents.cnvNulltoBlank(gengo).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(year).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(month).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(day).length()) {
            return "";
        }

        // 一旦西暦変換
        String seireki = PNCommonComponents.dateFmtJC_Gyymmdd(
                PNCommonStringUtils.concatString(gengo, String.format("%02d", Integer.parseInt(year)),
                        String.format("%02d", Integer.parseInt(month)),
                        String.format("%02d", Integer.parseInt(day))), "");
        String wareki = PNCommonComponents.dateFmtAD_YYYYMMDD(seireki);
        return wareki;
    }

    /**
     *
     * <pre>
     * 和暦に変換2
     * </pre>
     *
     * @param gengo
     * @param year
     * @param month
     * @param day
     * @param noday
     * @return
     */
    private String castWarekiToFormat2(String gengo, String year, String month, String day, boolean noday) {

        if (0 == PNCommonComponents.cnvNulltoBlank(gengo).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(year).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(month).length()
                || 0 == PNCommonComponents.cnvNulltoBlank(day).length()) {
            return "";
        }

        // 一旦西暦変換
        return PNCommonStringUtils.concatString(gengo, String.valueOf(Integer.parseInt(year)), ".",
                String.valueOf(Integer.parseInt(month)));
    }

}