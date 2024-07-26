//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/02/04 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_01.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se012.common.Se012Constants;
import jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataDAO;
import jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataEntity;

import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはse012_01のサービスクラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
public class Se012_01ServiceImpl extends PNBaseService implements
        Se012_01Service {

    /** se012_01resultsdatadao */
    @Autowired
    private Se012_01ResultsDataDAO se012_01resultsdatadao;

    /** PNCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Se012_01ServiceのcountResultsData
     *
     * @param inDto
     *            Se012_01DTO
     * @return Se012_01DTO
     */
    @Override
    public Se012_01DTO countResultsData(Se012_01DTO inDto) {

        Se012_01DTO outDto = new Se012_01DTO();

        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();

        // 画面にて指定された検索条件に該当する総件数を取得する。
        // 　DAOへのパラメータに検索条件を設定（Se012_01ResultsDataEntity)
        Se012_01ResultsDataEntity inEntity = new Se012_01ResultsDataEntity();

        // 業務日付取得
        String strBizDate = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        if (StringUtil.isEmpty(inDto.getTxtid_srccode_organization()) == false) {
            // 　　・DTO.検索扱店コード → 扱店コード
            inEntity.setCode_organization(inDto.getTxtid_srccode_organization());
        }
        if (StringUtil.isEmpty(inDto.getTxtid_srccode_tenpo()) == false) {
            // 　　・DTO.検索店舗コード　→　店舗コード
            inEntity.setCode_tenpo(inDto.getTxtid_srccode_tenpo());
        }
        if (roleCode.equals(PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA)) {
            // ・ログインユーザ扱店　→　Ｈ金融機関コード
            inEntity.setCode_h_oraganization(PNCommonInfoHolder.getCommonInfo().getCode_Organization());
        }
        else if (roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA)) {
            if (StringUtil.isEmpty(inDto.getTxtid_srccode_organization()) == false
                    && inDto.getTxtid_srccode_organization().equals(Se012Constants.CODE_ORGANIZATION_9937) == false) {
                // ・DTO.検索扱店コード → Ｈ金融機関コード
                inEntity.setCode_h_oraganization(inDto.getTxtid_srccode_organization());
            }
        }

        if (StringUtil.isEmpty(inDto.getDrpid_searchstartym_year()) == false
                && StringUtil.isEmpty(inDto.getDrpid_searchstartym_month()) == false) {
            // 　　・西暦変換したDTO.検索開始年月（年）　+　DTO.検索開始年月（月）　→　検索開始年月
// [UPD] Ver 3.0.0 - START
//            inEntity.setSearch_start_date(PNCommonComponents.concatString(
//                    inDto.getDrpid_searchstartym_year(),
//                    String.format("%02d", Integer.parseInt(inDto.getDrpid_searchstartym_month()))));
          inEntity.setSearch_start_date(PNCommonComponents.dateFmtJC_Gyymm(PNCommonComponents.concatString(
                  inDto.getDrpid_searchstartym_year(),
                  PNFormatUtils.toZeroPadding(inDto.getDrpid_searchstartym_month(), 2)), ""));
// [UPD] Ver 3.0.0 - END
        }
        else {
            // 業務日付2年前年月を取得して設定
            Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                    .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
            calBizDate.add(Calendar.YEAR, -2);
            String strBizYMTowYearsAgo = PNCommonComponents.calToStr(calBizDate).substring(0, 6);
            inEntity.setSearch_start_date(strBizYMTowYearsAgo);
        }

        if (StringUtil.isEmpty(inDto.getDrpid_searchendym_year()) == false
                && StringUtil.isEmpty(inDto.getDrpid_searchendym_month()) == false) {
            // 　　・西暦変換したDTO.検索終了年月（年）　+　DTO.検索終了年月（月）　→　検索終了年月
// [UPD] Ver 3.0.0 - START
//            inEntity.setSearch_end_date(PNCommonComponents.concatString(
//                    inDto.getDrpid_searchendym_year(),
//                    String.format("%02d", Integer.parseInt(inDto.getDrpid_searchendym_month()))));
            inEntity.setSearch_end_date(PNCommonComponents.dateFmtJC_Gyymm(PNCommonComponents.concatString(
                    inDto.getDrpid_searchendym_year(),
                    PNFormatUtils.toZeroPadding(inDto.getDrpid_searchendym_month(), 2)), ""));
// [UPD] Ver 3.0.0 - END
        }
        else {
            // 業務日付年月取得して設定
            String strBizYM = strBizDate.substring(0, 6);
            inEntity.setSearch_end_date(strBizYM);
        }

        // 　　・業務日付
        inEntity.setDate_business(strBizDate);

        // 未加盟店検索
        inEntity.setSearch_mikameiten(inDto.getChkid_searchmikameiten());

        // 　DAOを呼び出し、画面で入力された検索キーの該当件数を取得する
        // 　Se012_01ResultsDataDAO.countByCondition(Entity)
        int hitCount = (int)se012_01resultsdatadao.countByCondition(inEntity);

        // ヒット件数の返却
        // 　DAO結果件数　→　DTO.検索結果該当件数
        outDto.setSearchcount(hitCount);

        // 　呼び出し元に復帰する
        return outDto;
    }

    /**
     * Se012_01ServiceのgetResultsData
     *
     * @param inDto
     *            Se012_01DTO
     * @return Se012_01DTO
     */
    @Override
    public Se012_01DTO getResultsData(Se012_01DTO inDto) {

        Se012_01DTO outDto = new Se012_01DTO();

        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();

        // 業務日付取得
        String strBizDate = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        // 検索条件に該当し、指定ページに表示する業務委託手数料通知対象年月一覧データを取得する。
        // 　DAOへのパラメータに検索条件を設定（Se012_01ResultsDataEntity)
        Se012_01ResultsDataEntity inEntity = new Se012_01ResultsDataEntity();

        if (StringUtil.isEmpty(inDto.getTxtid_srccode_organization()) == false) {
            // 　　・DTO.検索扱店コード → 扱店コード
            inEntity.setCode_organization(inDto.getTxtid_srccode_organization());
        }
        if (StringUtil.isEmpty(inDto.getTxtid_srccode_tenpo()) == false) {
            // 　　・DTO.検索店舗コード　→　店舗コード
            inEntity.setCode_tenpo(inDto.getTxtid_srccode_tenpo());
        }
        if (commonInfo.getRoleCode().equals(PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA)) {
            // ・ログインユーザ扱店　→　Ｈ金融機関コード
            inEntity.setCode_h_oraganization(commonInfo.getCode_Organization());
        }
        else if (commonInfo.getRoleCode().equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || commonInfo.getRoleCode().equals(PNCommonConstants.ROLECODE_KANRISHA)) {
            if (StringUtil.isEmpty(inDto.getTxtid_srccode_organization()) == false
                    && inDto.getTxtid_srccode_organization().equals(Se012Constants.CODE_ORGANIZATION_9937) == false) {
                // ・DTO.検索扱店コード → Ｈ金融機関コード
                inEntity.setCode_h_oraganization(inDto.getTxtid_srccode_organization());
            }
        }

        if (StringUtil.isEmpty(inDto.getDrpid_searchstartym_year()) == false
                && StringUtil.isEmpty(inDto.getDrpid_searchstartym_month()) == false) {
            // 　　・西暦変換したDTO.検索開始年月（年）　+　DTO.検索開始年月（月）　→　検索開始年月
// [UPD] Ver 3.0.0 - START
//            inEntity.setSearch_start_date(PNCommonComponents.concatString(
//                    inDto.getDrpid_searchstartym_year(),
//                    String.format("%02d", Integer.parseInt(inDto.getDrpid_searchstartym_month()))));
            inEntity.setSearch_start_date(PNCommonComponents.dateFmtJC_Gyymm(PNCommonComponents.concatString(
                    inDto.getDrpid_searchstartym_year(),
                    PNFormatUtils.toZeroPadding(inDto.getDrpid_searchstartym_month(), 2)), ""));
// [UPD] Ver 3.0.0 - END
        }
        else {
            // 業務日付2年前年月を取得して設定
            Calendar calBizDate = PNCommonComponents.strToCal(pnCommonDBComponents
                    .getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE));
            calBizDate.add(Calendar.YEAR, -2);
            String strBizYMTowYearsAgo = PNCommonComponents.calToStr(calBizDate).substring(0, 6);
            inEntity.setSearch_start_date(strBizYMTowYearsAgo);
        }

        if (StringUtil.isEmpty(inDto.getDrpid_searchendym_year()) == false
                && StringUtil.isEmpty(inDto.getDrpid_searchendym_month()) == false) {
            // 　　・西暦変換したDTO.検索終了年月（年）　+　DTO.検索終了年月（月）　→　検索終了年月
// [UPD] Ver 3.0.0 - START
//            inEntity.setSearch_end_date(PNCommonComponents.concatString(
//                    inDto.getDrpid_searchendym_year(),
//                    String.format("%02d", Integer.parseInt(inDto.getDrpid_searchendym_month()))));
            inEntity.setSearch_end_date(PNCommonComponents.dateFmtJC_Gyymm(PNCommonComponents.concatString(
                    inDto.getDrpid_searchendym_year(),
                    PNFormatUtils.toZeroPadding(inDto.getDrpid_searchendym_month(), 2)), ""));
// [UPD] Ver 3.0.0 - END
        }
        else {
            // 業務日付年月取得して設定
            String strBizYM = strBizDate.substring(0, 6);
            inEntity.setSearch_end_date(strBizYM);
        }

        // 　　・業務日付
        inEntity.setDate_business(strBizDate);

        // 未加盟店検索
        inEntity.setSearch_mikameiten(inDto.getChkid_searchmikameiten());

        // 　画面で入力された検索キーの該当データを取得する。
        // 　　・Se012_01ResultsDataDAO.findByCondition(Entity, オフセット, リミット)
        List<Se012_01ResultsDataEntity> resultEntityList =
                se012_01resultsdatadao.findByCondition(inEntity, inDto.getOffset(), inDto.getLength());

        // 検索結果を取得(Entity→DTOに設定)
        List<Se012_01M1DTO> resultDtoList = new ArrayList<Se012_01M1DTO>();
        // 　以下の項目を取得件数分設定する。
        for (Se012_01ResultsDataEntity resultEntity : resultEntityList) {

            Se012_01M1DTO resultDto = new Se012_01M1DTO();

            // 　　扱店コード：扱店コードを設定
            resultDto.setLblid_code_organization(resultEntity.getCode_organization());
            // 　　扱店名：扱店名を設定
            resultDto.setLblid_name_organization(resultEntity.getName_organization());
            // 　　店舗コード：店舗コードを設定
            resultDto.setLblid_code_tenpo(resultEntity.getCode_tenpo());
            // 　　店舗名：店舗名を設定
            resultDto.setLblid_name_tenpo(resultEntity.getName_tenpo());
            // 　　情報提供日：情報提供日をYYYY/MM/DD形式に編集して設定
            Calendar cal = PNCommonComponents.strToCal(resultEntity.getDate_jyohoteikyo());
            DateFormat frmt = new SimpleDateFormat("yyyy/M/d");
            resultDto.setLblid_date_jyohoteikyo(frmt.format(cal.getTime()));
            // 　　対象年月：対象年月を和暦変換(Gyy/MM形式)して設定
            String strDate_taisho = PNCommonComponents.dateFmtAD_YYYYMM(resultEntity.getDate_taisho());
            if (StringUtil.isEmpty(strDate_taisho) == false) {
                strDate_taisho = strDate_taisho.replace(".", "/");
            }
            resultDto.setAncid_date_taisho(strDate_taisho);

            resultDtoList.add(resultDto);
        }

        // 業務委託手数料通知対象年月一覧の返却
        // 　DAO結果リスト　→　DTO.業務委託手数料通知対象年月一覧
        outDto.setMeisai_list(resultDtoList);

        // 　呼び出し元に復帰する
        return outDto;
    }

}