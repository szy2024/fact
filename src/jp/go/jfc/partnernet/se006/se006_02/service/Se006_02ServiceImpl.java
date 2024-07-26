//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/09/20 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/19 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_02.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListDAO;
import jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02ReportListEntity;
import jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataDAO;
import jp.go.jfc.partnernet.se006.se006_02.dao.Se006_02TenpoNameResultDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse006_02のサービスクラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
public class Se006_02ServiceImpl extends PNBaseService implements Se006_02Service {

    /** se006_02reportlistdao */
    @Autowired
    private Se006_02ReportListDAO se006_02reportlistdao;

    /** se006_02tenponameresultdatadao */
    @Autowired
    private Se006_02TenpoNameResultDataDAO se006_02tenponameresultdatadao;

    /**
     * Se006_02ServiceのinitReportList
     *
     * @param inDto Se006_02DTO
     * @return Se006_02DTO
     */
    @Override
    public Se006_02DTO initReportList(Se006_02DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_02DTO outDto = new Se006_02DTO();
        Se006_02ReportListEntity inEntity = new Se006_02ReportListEntity();

        // DTO⇒Entityに転記
        CFWBeanUtils.copyProperties(inEntity, inDto);
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 検索条件を編集
        // ・検索開始日、検索終了日の設定
        // 　DTOより設定値を取得する。
        // 　①検索開始日の編集
        // 　　　検索開始年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付に変換する。
        StringBuilder search_start_date = new StringBuilder("");
        search_start_date.append(inDto.getSearch_Start_Year()).append(inDto.getSearch_Start_Month())
                .append(inDto.getSearch_Start_Date());
        inEntity.setSearch_Start_Date(search_start_date.toString());

        // 　②検索終了日の編集
        // 　　　検索終了年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付に変換する。
        StringBuilder search_end_date = new StringBuilder("");
        search_end_date.append(inDto.getSearch_End_Year()).append(inDto.getSearch_End_Month())
                .append(inDto.getSearch_End_Date());
        inEntity.setSearch_End_Date(search_end_date.toString());

        // ・取消フラグに"１"を設定
        // 　注意）　取消フラグ = "1"を検索するのではなく、取消フラグ ≠ "1"を検索する点に注意。
        inEntity.setTorikeshi_Flg(Se006Constants.TORIKESHI_FLG_ON);

        // ・金融機関名称の取得
        if (!(PNCommonConstants.LITERAL_BLANK.equals(inDto.getSearch_Code_Organization()))
                && !(Se006Constants.CODE_ORGANIZATION_9937.equals(inDto.getSearch_Code_Organization()))) {
            // ■検索条件に指定した扱店コードが ""以外の場合
            Se006_02TenpoNameResultDataEntity inEntity2 = new Se006_02TenpoNameResultDataEntity();
            inEntity2.setCode_Organization(inDto.getSearch_Code_Organization());
            List<Se006_02TenpoNameResultDataEntity> outEntityList2 =
                    se006_02tenponameresultdatadao.findByCondition(inEntity2);

            if (0 == outEntityList2.size()) {
                // エラー内容設定
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0], false));
                outDto.setBizErrors(bizErrors);
                return outDto;
            }
            // 結果EntityをDTOに転記
            for (Se006_02TenpoNameResultDataEntity outEntity : outEntityList2) {
                outDto.setlblID_Name_Organization(outEntity.getName_Organization());
            }
        }
        else {
            if (Se006Constants.CODE_ORGANIZATION_9937.equals(inDto.getSearch_Code_Organization())) {
                // ■検索条件に指定した扱店コードが"9937"(日本金融公庫)の場合
                outDto.setlblID_Name_Organization(Se006Constants.NAME_ORGANIZATION_9937);
            }
            else {
                // ■検索条件に指定した扱店コードが ""の場合
                outDto.setlblID_Name_Organization(PNCommonConstants.LITERAL_BLANK);
            }
        }

        // 検索条件に指定した報告書種別、実行・回収関係報告書に応じて追加条件を設定

        if (Se006Constants.DATACODE_DATAIL_KEY.equals(inDto.getSearch_DataCode())) {
            // Se006_02DTO.Search_DataCode＝"1"（実行・回収関係報告書）の場合
            if (Se006Constants.INIT_DATACODE_DETAIL.equals(inDto.getSearch_DataCode_Detail())) {
                // Se006_02DTO.Search_DataCode_Detail＝ ""の場合

                // 実行・回収関係報告書の報告書を条件として設定
                // "1"が渡される。
                inEntity.setDatacode(inDto.getSearch_DataCode());

            }
            else {
                // 上記以外の場合
                // 検索条件に指定した報告書種別の報告書を条件として設定
                // 報告書履歴データのデータコード＝Se006_02DTO.Search_DataCode_Detail
                inEntity.setDatacode(inDto.getSearch_DataCode_Detail());

            }
        }
        else if (!(Se006Constants.INIT_DATACODE.equals(inDto.getSearch_DataCode()))) {
            // Se006_02DTO.Search_DataCode　≠ ""（実行・回収関係報告書以外）の場合
            // 検索条件に指定した報告書種別の報告書を条件として設定
            // 報告書履歴データのデータコード＝Se006_02DTO.Search_DataCode
            inEntity.setDatacode(inDto.getSearch_DataCode());

        }
        else {
            // 上記以外の場合
            // 全ての報告書を対象とする
        }

        // 検索条件に指定した公庫支店コードに応じて追加条件を設定
        if (!(PNCommonConstants.LITERAL_BLANK.equals(inDto.getSearch_Shiten()))) {
            // Se006_02DTO.Search_Shiten　≠ ""の場合
            // 検索条件に指定した公庫支店コードを条件として設定
            // 報告書履歴データの公庫支店コード＝Se006_02DTO.Search_Shiten
            inEntity.setSearch_Shiten(inDto.getSearch_Shiten());
        }

        // 検索条件に指定した扱店コードに応じて追加条件を設定
        if (!(PNCommonConstants.LITERAL_BLANK.equals(inDto.getSearch_Code_Organization()))) {
            inEntity.setSearch_Code_Organization(inDto.getSearch_Code_Organization());
        }

        // 検索条件に指定した融資番号に応じて追加条件を設定
        if (!(PNCommonConstants.LITERAL_BLANK.equals(inDto.getSearch_YN_Code_Organization()))) {
            // Se006_02DTO.Search_Code_Organization　≠ ""の場合

            // 報告書履歴データの扱店コード＝Se006_02DTO.Search_Code_Organization
            // 報告書履歴データの店舗コード＝Se006_02DTO.Search_Code_Tenpo
            // 報告書履歴データの年度＝Se006_02DTO.Search_Year（西暦YYYYに変換）
            // 報告書履歴データの方式資金区分＝Se006_02DTO.Search_Kubun_HoshikiShikin
            // 報告書履歴データの稟議番号＝Se006_02DTO.Search_Ringi
            // 報告書履歴データの稟議番号枝番＝Se006_02DTO.Search_RingiBranch　※空白の場合は'0'を設定

            inEntity.setSearch_YN_Code_Organization(inDto.getSearch_YN_Code_Organization());
            inEntity.setSearch_YN_Code_Tenpo(inDto.getSearch_YN_Code_Tenpo());
            inEntity.setSearch_YN_Year(PNCommonComponents.dateFmtJC_Gyy(inDto.getSearch_YN_Year()));
            inEntity.setSearch_YN_Kubun_HoshikiShikin(inDto.getSearch_YN_Kubun_HoshikiShikin());
            inEntity.setSearch_YN_Ringi(inDto.getSearch_YN_Ringi());
            if (inDto.getSearch_YN_RingiBranch().isEmpty()) {
                inEntity.setSearch_YN_Ringibranch(PNCommonConstants.RINGI_BRANCH_VALUE_ZERO);
            }
            else {
                inEntity.setSearch_YN_Ringibranch(inDto.getSearch_YN_RingiBranch());
            }

        }

        // ・ソート条件の設定
        LinkedHashMap<String, String> mapSortInfo = new LinkedHashMap<String, String>();
        mapSortInfo.put("Code_KoukoShiten", "ASC");
        mapSortInfo.put("Code_Organization", "ASC");
        mapSortInfo.put("Code_Tenpo", "ASC");
        mapSortInfo.put("Year", "ASC");
        mapSortInfo.put("Code_HoshikiShikin", "ASC");
        mapSortInfo.put("ID_Ringi", "ASC");
        mapSortInfo.put("ID_RingiBranch", "ASC");
        mapSortInfo.put("Date_Report", "DESC");
        mapSortInfo.put("Time_Report", "DESC");
        mapSortInfo.put("ID_History", "DESC");
        inEntity.setSortInfo(mapSortInfo);

        // 検索用パラメータをEntityへ設定
        inEntity.setRoleCode(PNCommonInfoHolder.getCommonInfo().getRoleCode());
        List<Se006_02ReportListEntity> outEntityList = se006_02reportlistdao.findByCondition(inEntity);

        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 結果EntityをDTOに転記
        List<Se006_02M1DTO> reportHistoryList = new ArrayList<Se006_02M1DTO>(outEntityList.size());
        int i = 0;
        for (Se006_02ReportListEntity outEntity : outEntityList) {
            Se006_02M1DTO reportHistory = new Se006_02M1DTO();

            // エラーメッセージ
            reportHistory.setID_ErrorMessage((String)selectMessage(outEntity));

            // 履歴番号
            reportHistory.setID_ID_History(outEntity.getId_History());
            // 報告年月日
            reportHistory.setID_Date_Report(PNFormatUtils.formatDate(outEntity.getDate_Report()));
            // 報告時分秒
            reportHistory.setID_Time_Report(outEntity.getTime_Report());
            // 報告時分秒
            reportHistory.setID_Time_Report(PNCommonComponents.timeFormatConvert(outEntity.getTime_Report()));
            // 融資番号
            reportHistory.setID_Yuushi_Number((String)makeYuushiNumber(outEntity));
            // 公庫支店
            reportHistory.setID_YN_Code_ShokanHonShiten(outEntity.getCode_Koukoshiten());

            // 扱店コード
            reportHistory.setID_Code_Organization(outEntity.getCode_Organization());

            // 扱店名
            reportHistory.setID_Name_Organization(outEntity.getName_Organization());

            // 店舗コード
            reportHistory.setID_YN_Code_Tenpo(outEntity.getCode_Tenpo());
            // 年度
            reportHistory.setID_YN_Year(outEntity.getYear());
            // 方式資金
            reportHistory.setID_YN_Kubun_HoshikiShikin(outEntity.getCode_Hoshikishikin());
            // 稟議番号
            reportHistory.setID_YN_Ringi(outEntity.getId_Ringi());
            // 稟議枝番
            // 取得した枝番が０の場合、空文字を設定
            String outIDRingiBranch = outEntity.getId_Ringibranch();
            if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
                outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
            }
            // 報告書種別
            reportHistory.setID_RyakusyouName_Report(outEntity.getRyakusyouname_Report());
            // 処理状況名称
            reportHistory.setID_RyakusyouName_Status(outEntity.getRyakusyouname_Status());
            // 処理状況
            reportHistory.setID_Status(outEntity.getStatus());
            // データコード
            reportHistory.setID_DataCode(outEntity.getDatacode());
            // 報告書番号
            reportHistory.setID_ID_Report(outEntity.getId_Report());
            // 処理種別
            reportHistory.setID_RyakusyouName_Process(outEntity.getRyakusyouname_Process());
            // 取消済
            reportHistory.setID_Flag_Torikeshizumi(outEntity.getFlag_Torikeshizumi());
            // 原本番号
            reportHistory.setID_ID_Master(outEntity.getId_Master());

            // エラーコード
            reportHistory.setID_Code_Error((String)selectErrorCode(outEntity));

            // 行番号
            reportHistory.setArray_List_Index(Integer.toString(i++));
            reportHistoryList.add(reportHistory);
        }
        outDto.setReporthistorylist(reportHistoryList);

        return outDto;
    }

    /**
     * Se006_02ServiceのcountReportList
     *
     * @param inDto Se006_02DTO
     * @return Se006_02DTO
     */
    @Override
    public Se006_02DTO countReportList(Se006_02DTO inDto) {
        Se006_02DTO outDto = new Se006_02DTO();
        Se006_02ReportListEntity inEntity = new Se006_02ReportListEntity();

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        // DTO⇒Entityに転記
        CFWBeanUtils.copyProperties(inEntity, inDto);

        // 検索開始日、検索終了日を設定
        // DTOより設定値を取得する。
        // 検索開始日の編集
        // 検索開始年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付に変換する。
        StringBuilder search_start_date = new StringBuilder("");
        search_start_date.append(inDto.getSearch_Start_Year()).append(inDto.getSearch_Start_Month())
                .append(inDto.getSearch_Start_Date());
        inEntity.setSearch_Start_Date(search_start_date.toString());

        // 検索終了日の編集
        // 検索終了年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付に変換する。
        StringBuilder search_end_date = new StringBuilder("");
        search_end_date.append(inDto.getSearch_End_Year()).append(inDto.getSearch_End_Month())
                .append(inDto.getSearch_End_Date());

        inEntity.setSearch_End_Date(search_end_date.toString());

        long count = se006_02reportlistdao.countByCondition(inEntity);

        if (0 == count) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        outDto.setReporthistorylisthitcount(new Long(count).intValue());
        return outDto;
    }

    /**
     * エラーコード判定
     *
     * @param outEntity Se006_02ReportListEntity
     * @return エラーコード
     */
    private String selectErrorCode(Se006_02ReportListEntity outEntity) {

        int codError = Integer.parseInt(PNCommonComponents.cnvNulltoZero(outEntity.getCode_Error()));
        if (0 != codError) {
            return outEntity.getCode_Error();
        }
        else {
            return "00000";
        }
    }

    /**
     * エラーメッセージ生成
     *
     * @param outEntity Se006_02ReportListEntity
     * @return エラーメッセージ
     */
    private String selectMessage(Se006_02ReportListEntity outEntity) {

        int codError = Integer.parseInt(PNCommonComponents.cnvNulltoZero(outEntity.getCode_Error()));
        if (0 != codError) {
            return "メッセージ";
        }
        else {
            return null;
        }
    }

    /**
     * 融資番号生成
     *
     * @param outEntity Se006_02ReportListEntity
     * @return 融資番号
     */
    private String makeYuushiNumber(final Se006_02ReportListEntity outEntity) {

        StringBuilder strYuushiNumber = new StringBuilder("");

        if (PNCommonConstants.DATACODE_90257120.equals(outEntity.getDatacode())
                || PNCommonConstants.DATACODE_90257121.equals(outEntity.getDatacode())) {
            // 報告書が留置期間利息・代弁遅延損害金受入充当報告書の場合、支店コードと扱店コードを"-"にて連結する。
            if (null == outEntity.getCode_Koukoshiten() || null == outEntity.getCode_Organization()) {
                return "";
            }
            strYuushiNumber.append(outEntity.getCode_Koukoshiten());
            strYuushiNumber.append("-");
            strYuushiNumber.append(outEntity.getCode_Organization());

        }
        else if (PNCommonConstants.DATACODE_90257130.equals(outEntity.getDatacode())) {
            // 報告書が資金交付（月間）の場合、交付依頼年月をHz年mm月形式で設定。

            String date_KofuIraiResult = PNCommonConstants.LITERAL_BLANK;

            if (!(null == outEntity.getDate_KofuIrai())) {
// [UPD] Ver 3.0.0 - START
//                String date_KofuIraiYear =
//                        PNCommonComponents.dateFmtAD_YYYY(outEntity.getDate_KofuIrai().substring(0, 4));
//                String date_KofuIraiMonth = outEntity.getDate_KofuIrai().substring(4, 6);
//                date_KofuIraiResult = date_KofuIraiYear + "年" + date_KofuIraiMonth + "月";
                date_KofuIraiResult = PNCommonComponents.dateFmtJC_Kanzi_YYYYMM(outEntity.getDate_KofuIrai());
// [UPD] Ver 3.0.0 - END
            }

            strYuushiNumber.append(date_KofuIraiResult);

        }
        else if (PNCommonConstants.DATACODE_90257140.equals(outEntity.getDatacode())) {
            // 報告書が資金交付（週間）の場合、指定交付日をHz年mm月dd日形式で設定。

            String date_KofuResult = PNCommonConstants.LITERAL_BLANK;

            if (!(null == outEntity.getDate_Kofu())) {
// [UPD] Ver 3.0.0 - START
//                String date_KofuYear = PNCommonComponents.dateFmtAD_YYYY(outEntity.getDate_Kofu().substring(0, 4));
//                String date_KofuMonth = outEntity.getDate_Kofu().substring(4, 6);
//                String date_KofuDate = outEntity.getDate_Kofu().substring(6, 8);
//                date_KofuResult = date_KofuYear + "年" + date_KofuMonth + "月" + date_KofuDate + "日";
                date_KofuResult = PNCommonComponents.dateFmtJC_Kanzi_YYYYMMDD(outEntity.getDate_Kofu());
// [UPD] Ver 3.0.0 - END
            }

            strYuushiNumber.append(date_KofuResult);

        }
        else if (PNCommonConstants.DATACODE_90257150.equals(outEntity.getDatacode())) {
            // 報告書が包括委任の場合、至急チェック有無を設定。
            // 至急チェック有無は、至急の場合「至急」、　至急でない場合空白。
            if (PNCommonConstants.FLAG_SHIKYUHAKKO_ON.equals(outEntity.getFlag_ShikyuHakko())) {
                strYuushiNumber.append(Se006Constants.SHIKYUHAKKO_ON);
            }
            else {
                strYuushiNumber.append(Se006Constants.SHIKYUHAKKO_OFF);
            }

        }
        else if (PNCommonConstants.DATACODE_90257160.equals(outEntity.getDatacode())) {
            // 報告書が抵当権抹消の場合、発信日をHz年mm月dd日形式で設定。

            String date_ReportResult = PNCommonConstants.LITERAL_BLANK;

            if (!(null == outEntity.getSendDate_Report())) {
// [UPD] Ver 3.0.0 - START
//                String date_ReportYear =
//                        PNCommonComponents.dateFmtAD_YYYY(outEntity.getSendDate_Report().substring(0, 4));
//                String date_ReportMonth = outEntity.getSendDate_Report().substring(4, 6);
//                String date_ReportDate = outEntity.getSendDate_Report().substring(6, 8);
//                date_ReportResult = date_ReportYear + "年" + date_ReportMonth + "月" + date_ReportDate + "日";
                date_ReportResult = PNCommonComponents.dateFmtJC_Kanzi_YYYYMMDD(outEntity.getSendDate_Report());
// [UPD] Ver 3.0.0 - END
            }

            strYuushiNumber.append(date_ReportResult);

        }
        else {

            // 報告書が上記以外の場合、
            // 支店コード,扱店コード,店舗コード,年度,方式資金,稟議番号,稟議番号枝番の列を"-"にて連結する。
            if (null == outEntity.getCode_Koukoshiten() || null == outEntity.getCode_Organization()
                    || null == outEntity.getCode_Tenpo()) {
                return "";
            }
            if (null == outEntity.getYear() || null == outEntity.getCode_Hoshikishikin()
                    || null == outEntity.getId_Ringi()) {
                return "";
            }
            if (null == outEntity.getId_Ringibranch()) {
                return "";
            }

            strYuushiNumber.append(outEntity.getCode_Koukoshiten());
            strYuushiNumber.append("-");
            strYuushiNumber.append(outEntity.getCode_Organization());
            strYuushiNumber.append("-");
            strYuushiNumber.append(outEntity.getCode_Tenpo());
            strYuushiNumber.append("-");
            strYuushiNumber.append(PNCommonComponents.dateFmtAD_YYYY(outEntity.getYear()));
            strYuushiNumber.append("-");
            strYuushiNumber.append(outEntity.getCode_Hoshikishikin());
            strYuushiNumber.append("-");
            strYuushiNumber.append(outEntity.getId_Ringi());

            if (!"0".equals(outEntity.getId_Ringibranch())) {
                strYuushiNumber.append("-");
                strYuushiNumber.append(outEntity.getId_Ringibranch());
            }

        }

        return strYuushiNumber.toString();

    }
}