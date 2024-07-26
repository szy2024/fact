//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.web;

import java.util.Map;

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

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.cr005.cr005_03.service.Cr005_03Service;
import jp.go.jfc.partnernet.cr005.cr005_03.service.Cr005_03DTO;
import jp.go.jfc.partnernet.cr005.common.Cr005Constants;
import jp.go.jfc.partnernet.cr005.cr005_03.service.Cr005_03M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;

/**
 * <pre>
 * このクラスはcr005_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes("cr005_03Form")
@RequestMapping(value = "/Cr005_03Init.form")
public class Cr005_03InitController extends Cr005_03BaseController {

    /** Cr005_03Service */
    @Autowired
    Cr005_03Service cr005_03service;

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
    public String executeAction(Model model, Cr005_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) {

        // 画面項目を初期化
        // 顧客名（ヘッダ）
        form.setLblSearchCustomer("");
        // 住所（ヘッダ）
        form.setLblSearchAddr("");
        // 明細部
        PNPagingTable<Cr005_03M1DTO> cr005_03m1Table = form.getCr005_03M1Table();
        cr005_03m1Table.reset();
        // 明細部を表示状態へ
        form.setVisible(Cr005Constants.PROPERTY_YUUSHILIST_AREA, true);

        // 受渡パラメータを取得し、Formへ設定する。
        Map<String, Object> paramMap = getForwardParameter(request);
        // 　受渡パラメータ.顧客名　→　画面表示 Form.顧客名（ヘッダ）を設定する。
        form.setLblSearchCustomer((String) paramMap.get(Cr005Constants.PROPERTY_03_IN_NAME_CUSTOMER));
        // 　受渡パラメータ.住所　→　画面表示 Form.住所（ヘッダ）を設定する。
        form.setLblSearchAddr((String) paramMap.get(Cr005Constants.PROPERTY_03_IN_ADDRESS));
        // 　受渡パラメータ.貸付先　→　Form.貸付先入力値を設定する。
        form.setCr005_03_In_Code_Customer((String) paramMap.get(Cr005Constants.PROPERTY_03_IN_CODE_CUSTOMER));
        // 　受渡パラメータ.扱店コード　→　Form.扱店コード入力値を設定する。
        form.setCr005_03_In_Code_Organization((String) paramMap
                .get(Cr005Constants.PROPERTY_03_IN_CODE_ORGANIZATION));

        // サービスを実行し融資債権一覧データを取得する。
        // 　サービス起動パラメータ設定（Form.貸付先入力値、ログインユーザの扱店コード）
        // 　　Cr005_03Service.getResultData // DTOの生成
        Cr005_03DTO inCr005_03DTO = new Cr005_03DTO();
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // DTOへの転記処理をここに実装
        inCr005_03DTO.setCr005_03_In_Code_Customer(form.getCr005_03_In_Code_Customer());
        inCr005_03DTO.setCr005_03_In_Code_Organization(form.getCr005_03_In_Code_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // Serviceの呼び出し
        Cr005_03DTO outCr005_03DTO = cr005_03service.getResultData(inCr005_03DTO);

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // Formへの転記処理をここに実装
        form.setID_AllCount(outCr005_03DTO.getMEISAI_LIST1().size());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============

        // 検索結果の判定
        if (0 == outCr005_03DTO.getMEISAI_LIST1().size()) {
            // 　検索結果が０件の場合
            // 　　メッセージ：PM9060E「該当データがありません。」
            addMessage(errors, PNCommonMessageConstants.PM9060E);
            // 明細部を非表示にする
            form.setVisible(Cr005Constants.PROPERTY_YUUSHILIST_AREA, false);
        } else {
            // 　検索結果が１件以上の場合
            // 　　検索結果を取得する。
            // 　　取得した値を画面に設定する。
            form.getCr005_03M1Table().setResultsPerPage(outCr005_03DTO.getMEISAI_LIST1().size());
            form.getCr005_03M1Table().setRecordList(outCr005_03DTO.getMEISAI_LIST1(), form.getID_AllCount());
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
    public void displayControl(Model model, Cr005_03Form form, HttpServletRequest request) {

    }
}