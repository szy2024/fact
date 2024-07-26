//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.web;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.calculation.PNKeisanKoujorisoku;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se008.se008_02.service.Se008_02DTO;
import jp.go.jfc.partnernet.se008.se008_02.service.Se008_02M1DTO;
import jp.go.jfc.partnernet.se008.se008_02.service.Se008_02Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustAnytimeExecute;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

/**
 * <pre>
 * このクラスはse008_02の初期処理コントローラークラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se008_02Form")
@RequestMapping(value = "/Se008_02Init.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CrustAnytimeExecute
public class Se008_02InitController extends Se008_02BaseController {

    /** Se008_02Service */
    @Autowired
    Se008_02Service se008_02service;

    @Autowired
    PNKeisanKoujorisoku pnKeisanKoujorisoku;

    // 明細 id
    private static final String ID_MEISAI = "Results";
    /** 控除利息計算 データ不整合 */
    private static final BigDecimal ERROR_GET_KOUJORISOKU = new BigDecimal(-1);

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
    public String executeAction(Model model, Se008_02Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Form項目の初期化
        PNPagingTable<Se008_02M1DTO> se00802m1Table = form.getSe008_02M1Table();
        se00802m1Table.reset();

        // エラーリスト初期化
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        bizErrors.clear();

        // 受渡パラメータ.を取得する。
        mappingForwardParameterToForm(request, form);

        // 検索画面にて設定した「検索開始年月日」「検索終了年月日」⇒Formへデータの転記を行います。
        // 　「検索開始年月日」「検索終了年月日」を西暦変換してFormに設定する。
        // 遷移パラメータの取得（セッション→Form)
        // 検索開始年月日
        form.setID_SearchStartYear(PNCommonComponents.dateFmtJC_Gyy(form.getID_SearchStartYear()));
        // 検索終了年月日
        form.setID_SearchEndYear(PNCommonComponents.dateFmtJC_Gyy(form.getID_SearchEndYear()));

        // ０件の時に明細は枠を含め表示しない
        form.setVisible(ID_MEISAI, false);

        // 検索画面にて設定した「検索開始年月日」「検索終了年月日」を条件に、請求データを取得する。
        // DTOの生成
        Se008_02DTO inDto = new Se008_02DTO();
        // DTOへの転記処理をここに実装
        CFWBeanUtils.copyProperties(inDto, form);

        // Serviceの呼び出し
        Se008_02DTO outDto = se008_02service.getResultsData(inDto);

        // Formへの転記処理をここに実装
        CFWBeanUtils.copyProperties(form, outDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // エラー判定
        if (0 < bizErrors.size()) {
            // 画面非表示
            // エラー有の場合自画面表示（取得件数が０件の場合）
            throw new PNServiceException(bizErrors);
        }

        // 約定利息計
        BigDecimal yakujoRisokuKei = new BigDecimal("0.0");
        // 約定元金計
        BigDecimal yakujoGankinKei = new BigDecimal("0.0");
        // 請求繰上償還元金計
        BigDecimal seiKuriGankinKei = new BigDecimal("0.0");
        // 請求繰上償還利息計
        BigDecimal seiKuriRisokuKei = new BigDecimal("0.0");
        // 任意繰上償還利息計
        BigDecimal niniRisokuKei = new BigDecimal("0.0");
        // 控除利息計
        BigDecimal koujoRisokuKei = new BigDecimal("0.0");

        int recordCount = 0;
        // 画面表示項目の編集を行う。
        for (Se008_02M1DTO m1Dto : outDto.getMEISAI_LIST()) {
            recordCount++;
            // 債権管理番号、払込期日を引数として控除利息計算(共通部品)を呼ぶ。
            // 　控除利息を控除利息計算から取得する。
            BigDecimal koujoRisoku = pnKeisanKoujorisoku.getKoujorisoku(
                    Long.valueOf(m1Dto.getID_Credit().toString()), m1Dto.getID_Date_Haraikomi(),
                    m1Dto.getDate_Jikko(), m1Dto.getRiritsu().toString(), m1Dto.getTokuri().toString(),
                    m1Dto.getDate_TokuriYuko(), m1Dto.getCode_ShokanHouhou(), null, null, false);
            if (ERROR_GET_KOUJORISOKU.equals(koujoRisoku)) {
                // データ不整合
                throw new PNSystemException();
            }
            m1Dto.setID_M_KojoRisoku(koujoRisoku);
            // 合計額を計算する。
            // 　Se008_02DTO.約定利息をSe008_02DTO.約定利息計に加算する
            if (null != m1Dto.getID_M_YakujoRisoku()) {
                yakujoRisokuKei = yakujoRisokuKei.add(m1Dto.getID_M_YakujoRisoku());
            }
            // 　Se008_02DTO.約定元金をSe008_02DTO.約定元金計に加算する
            if (null != m1Dto.getID_M_YakujoGankin()) {
                yakujoGankinKei = yakujoGankinKei.add(m1Dto.getID_M_YakujoGankin());
            }
            // 　Se008_02DTO.請求繰上償還元金をSe008_02DTO.請求繰上償還元金計に加算する
            if (null != m1Dto.getID_M_SeiKuriGankin()) {
                seiKuriGankinKei = seiKuriGankinKei.add(m1Dto.getID_M_SeiKuriGankin());
            }
            // 　Se008_02DTO.請求繰上償還利息をSe008_02DTO.請求繰上償還利息計に加算する
            if (null != m1Dto.getID_M_SeiKuriRisoku()) {
                seiKuriRisokuKei = seiKuriRisokuKei.add(m1Dto.getID_M_SeiKuriRisoku());
            }
            // 　Se008_02DTO.任意繰上償還利息をSe008_02DTO.任意繰上償還利息計に加算する
            if (null != m1Dto.getID_M_NinKuriRisoku()) {
                niniRisokuKei = niniRisokuKei.add(m1Dto.getID_M_NinKuriRisoku());
            }
            // 　Se008_02DTO.控除利息をSe008_02DTO.控除利息計に加算する
            if (null != koujoRisoku) {
                koujoRisokuKei = koujoRisokuKei.add(koujoRisoku);
            }
            m1Dto.setTotalDisplayFlg("0");
            if (outDto.getMEISAI_LIST().size() == recordCount) {
                // 最終行に合計を表示する。
                m1Dto.setTotalDisplayFlg("1");
                m1Dto.setLblID_M_YakujoRisokuKEI(yakujoRisokuKei);
                m1Dto.setLblID_M_YakujoGankinKEI(yakujoGankinKei);
                m1Dto.setLblID_M_SeiKuriGankinKEI(seiKuriGankinKei);
                m1Dto.setLblID_M_SeiKuriRisokuKEI(seiKuriRisokuKei);
                m1Dto.setLblID_M_NiniRisokuKEI(niniRisokuKei);
                m1Dto.setLblID_M_KojoRisokuKEI(koujoRisokuKei);
            }
        }

        // Formへの転記処理をここに実装
        se00802m1Table.setRecordList(outDto.getMEISAI_LIST(), outDto.getMEISAI_LIST().size());
        se00802m1Table.setResultsPerPage(outDto.getMEISAI_LIST().size());
        form.setSe008_02M1Table(se00802m1Table);
        // 明細表示
        form.setVisible(ID_MEISAI, true);

        // 抽出した稟議情報が持つ債権管理番号が、報告書履歴データに存在するか確認をする
        for (Se008_02M1DTO m1Dto : outDto.getMEISAI_LIST()) {
            // 　抽出した稟議情報分、繰り返し実行する。
            outDto.setID_Credit(m1Dto.getID_Credit());
            outDto = se008_02service.getResultsKariKeisanData(outDto);
            // サービスで追加されたメッセージを追加
            bizErrors.addAll(outDto.getBizErrors());
            // 　　取得した件数＝０以外の場合、繰り返しから抜ける。
            // エラー判定
            if (0 < bizErrors.size()) {
                // エラー有の場合自画面表示（仮計算中メッセージ）
                throw new PNServiceException(bizErrors);
            }
        }

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
    public void displayControl(Model model, Se008_02Form form, HttpServletRequest request) {

    }
}