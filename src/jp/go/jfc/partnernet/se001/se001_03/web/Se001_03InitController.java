//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03InitController
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.web;

import java.util.LinkedList;
import java.util.List;

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

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.web.annotation.CrustAnytimeExecute;
import com.fujitsu.crust.web.annotation.CrustTokenCheck;

import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.se001.common.Se001Constants;
import jp.go.jfc.partnernet.se001.se001_03.service.Se001_03DTO;
import jp.go.jfc.partnernet.se001.se001_03.service.Se001_03M1DTO;
import jp.go.jfc.partnernet.se001.se001_03.service.Se001_03Service;

/**
 * <pre>
 * このクラスはSe001_03の初期表示コントローラークラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
@CrustTokenCheck
@Controller
@SessionAttributes("se001_03Form")
@RequestMapping("/Se001_03Init.form")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CrustAnytimeExecute
public class Se001_03InitController extends Se001_03BaseController {

    /** Se001_03Service */
    @Autowired
    Se001_03Service se001_03service;

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
    public String executeAction(Model model, Se001_03Form form, Errors errors, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /** 明細テーブル */
        PNPagingTable<Se001_03M1DTO> se001_03m1Table;

        /** エラーリスト */
        List<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        /** 検索用DTO */
        Se001_03DTO inDto = new Se001_03DTO();

        /** 結果表示用DTO */
        Se001_03DTO outDto = new Se001_03DTO();

        // 受渡パラメータを取得する。
        mappingForwardParameterToForm(request, form);

        // フォームの初期化
        initForm(form);

        // 案件リストテーブル初期化
        se001_03m1Table = form.getSe001_03M1Table();
        se001_03m1Table.reset();

        // 明細テーブルを非表示にする
        form.setVisible(Se001Constants.PROPERTY_03M1_TABLE, false);

        // エラーリスト初期化
        bizErrors.clear();

        // 検索項目・検索結果項目初期化
        inDto = new Se001_03DTO();
        outDto = new Se001_03DTO();

        // サービス起動パラメータ設定（受渡しパラメータの貸付先コード、扱店コード）
        CFWBeanUtils.copyProperties(inDto, form);

        // サービスを実行し顧客データを取得する。(Serviceの呼び出し)
        outDto = se001_03service.getResultData(inDto);

        // サービスで追加されたメッセージを追加
        bizErrors.addAll(outDto.getBizErrors());

        // 取得した値を画面に設定する。
        // エラー判定
        if (0 < bizErrors.size()) {
            // エラーメッセージ：PM9060E（サービスにて対応）
            throw new PNServiceException(bizErrors);
        }

        // 取得した値を画面に設定する。
        // 顧客名
        form.setLblID_Name_Customer(outDto.getLblID_Name_Customer());

        // 住所
        form.setLblCustomerAddress1(outDto.getLblCustomerAddress1());
        form.setLblCustomerAddress2(outDto.getLblCustomerAddress2());
        form.setLblCustomerAddress3(outDto.getLblCustomerAddress3());

        // 扱店名(金融機関名)
        form.setLblID_Name_Organization(outDto.getLblID_Name_Organization());

        // ■ステータス
        form.setLblStatus(outDto.getLblStatus());

        // 案件リスト設定
        if (0 < outDto.getMEISAI_AnkenLIST().size()) {
            se001_03m1Table.setResultsPerPage(outDto.getMEISAI_AnkenLIST().size());
        }
        se001_03m1Table.setRecordList(outDto.getMEISAI_AnkenLIST(), outDto.getMEISAI_AnkenLIST().size());

        // 明細テーブルをフォームに転記
        form.setSe001_03M1Table(se001_03m1Table);

        // 明細テーブル表示
        form.setVisible(Se001Constants.PROPERTY_03M1_TABLE, true);

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
    public void displayControl(Model model, Se001_03Form form, HttpServletRequest request) {

    }

    /**
     *
     * <pre>
     * 項目初期化(フォーム・エラーリスト)
     * </pre>
     *
     * @param form
     */
    private void initForm(Se001_03Form form) {

        // 明細テーブル初期化
        // 表示項目初期化
        form.setLblCustomerAddress1("");
        form.setLblCustomerAddress2("");
        form.setLblCustomerAddress3("");
        form.setLblID_Name_Customer("");
        form.setLblID_Name_Organization("");
        form.setLblStatus("");

    }

}