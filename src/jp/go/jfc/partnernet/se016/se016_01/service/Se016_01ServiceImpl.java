//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se016_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/13 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se016.se016_01.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.dao.TeitokenreportDAO;
import jp.go.jfc.partnernet.common.dao.TeitokenreportEntity;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se016.se016_01.dao.Se016_01ResultsDataDAO;
import jp.go.jfc.partnernet.se016.se016_01.dao.Se016_01ResultsDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse016_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Se016_01ServiceImpl extends PNBaseService implements Se016_01Service {

    /** se016_01resultsdatadao */
    @Autowired
    private Se016_01ResultsDataDAO se016_01resultsdatadao;

    /** TeitokenreportDAO */
    @Autowired
    TeitokenreportDAO teitokenreportDAO;

    /**
     * Se016_01ServiceのcountResultsData
     *
     * @param inDto Se016_01DTO
     * @return Se016_01DTO
     */
    @Override
    public Se016_01DTO countResultsData(Se016_01DTO inDto) {

        Se016_01DTO outDto = new Se016_01DTO();
        Se016_01ResultsDataEntity inEntity = new Se016_01ResultsDataEntity();

        // 検索条件編集
        // 　DTOより設定値を取得する。
        CFWBeanUtils.copyProperties(inEntity, inDto);
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 　　表示開始年月日の編集
        // 　　　表示開始年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMMDD）に変換する。
        // 　　　 　DTO.表示開始年月日（年）　
        // 　　　+　DTO.表示開始年月日（月） 　
        // 　　　+　DTO.表示開始年月日（日）　→　表示開始年月日
        // 　　表示終了年月日の編集
        // 　　表示終了年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMMDD）に変換する。
        // 　　　DTO.表示終了年月日（年）　+　DTO.表示終了年月日（月）　+　DTO.表示終了年月日（日）　→　表示終了年月日

        // 表示データの検索該当件数を取得する
        // 　検索用パラメータをEntityへ設定
        // 　 DTO.検索扱店コード ⇒ Se016_01ResultDataEntity.扱店コード
        // 　　表示開始年月日 ⇒ Se016_01ResultDataEntity.表示開始年月日
        // 　　表示終了年月日 ⇒ Se016_01ResultDataEntity.表示終了年月日

        // 扱店コード
        inEntity.setCode_Organization(inDto.getTxtID_srcCode_Organization());

        // 表示開始年月日
// [UPD] Ver 3.0.0 - START
//        StringBuilder search_start_date = new StringBuilder("");
//        search_start_date.append(inDto.getDrpID_HyoziStartYear())
//                .append(inDto.getDrpID_HyoziStartMonth()).append(inDto.getDrpID_HyoziStartDay());
        String search_start_date = PNCommonComponents.dateFmtJC_Gyymmdd(
                PNCommonComponents.concatString(
                        inDto.getDrpID_HyoziStartYear(),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziStartMonth(), 2),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziStartDay(), 2)),
                "");
// [UPD] Ver 3.0.0 - END
        inEntity.setDate_ShukeiStart(search_start_date.toString());

        // 表示終了年月日
// [UPD] Ver 3.0.0 - START
//        StringBuilder search_end_date = new StringBuilder("");
//        search_end_date.append(inDto.getDrpID_HyoziEndYear())
//                .append(inDto.getDrpID_HyoziEndMonth()).append(inDto.getDrpID_HyoziEndDay());
        String search_end_date = PNCommonComponents.dateFmtJC_Gyymmdd(
                PNCommonComponents.concatString(
                        inDto.getDrpID_HyoziEndYear(),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziEndMonth(), 2),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziEndDay(), 2)),
                "");
// [UPD] Ver 3.0.0 - END
        inEntity.setDate_ShukeiEnd(search_end_date.toString());

        // 　Se016_01ResultsDataDAO.countByCondition(Entity)
        int hitcount = (int)se016_01resultsdatadao.countByCondition(inEntity);

        // ヒット件数の返却
        // 　DAO結果件数　→　DTO.検索結果該当件数
        outDto.setSearchCount(hitcount);

        // 　呼び出し元に復帰する
        return outDto;
    }

    /**
     * Se016_01ServiceのgetResultsData
     *
     * @param inDto Se016_01DTO
     * @return Se016_01DTO
     */
    @Override
    public Se016_01DTO getResultsData(Se016_01DTO inDto) {

        Se016_01DTO outDto = new Se016_01DTO();
        Se016_01ResultsDataEntity inEntity = new Se016_01ResultsDataEntity();

        // 検索条件に該当し、指定ページに表示する（根）抵当権抹消に係る報告一覧データを取得する。
        // 　※ページ位置はフレームワークにて自動で設定される
        // 検索条件編集
        // 　DTOより設定値を取得する。
        CFWBeanUtils.copyProperties(inEntity, inDto);
        CFWBeanUtils.copyProperties(outDto, inDto);

        // 　　表示開始年月日の編集
        // 　　表示開始年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMMDD）に変換する。
        // 　　　表示開始年月日（年） Se016_01DTO.drpID_HyoziStartYear
        // 　　　表示開始年月日（月） Se016_01DTO.drpID_HyoziStartMonth
        // 　　　表示開始年月日（日） Se016_01DTO.drpID_HyoziStartDay
        // 　　表示終了年月日の編集
        // 　　表示終了年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMMDD）に変換する。
        // 　　　表示終了年月日（年） Se016_01DTO.drpID_HyoziEndYear
        // 　　　表示終了年月日（月） Se016_01DTO.drpID_HyoziEndMonth
        // 　　　表示終了年月日（日） Se016_01DTO.drpID_HyoziEndDay

        // 　表示データの抽出
        // 　　検索用パラメータをEntityへ設定
        // 　　 DTO.検索扱店コード ⇒ Se016_01ResultDataEntity.扱店コード
        // 　　　表示開始年月日 ⇒ Se016_01ResultDataEntity.HyoziStart
        // 　　　表示終了年月日 ⇒ Se016_01ResultDataEntity.HyoziEnd

        // 扱店コード
        inEntity.setCode_Organization(inDto.getTxtID_srcCode_Organization());

        // 表示開始年月日
// [UPD] Ver 3.0.0 - START
//        StringBuilder search_start_date = new StringBuilder("");
//        search_start_date.append(inDto.getDrpID_HyoziStartYear())
//                .append(inDto.getDrpID_HyoziStartMonth()).append(inDto.getDrpID_HyoziStartDay());
        String search_start_date = PNCommonComponents.dateFmtJC_Gyymmdd(
                PNCommonComponents.concatString(
                        inDto.getDrpID_HyoziStartYear(),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziStartMonth(), 2),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziStartDay(), 2)),
                "");
// [UPD] Ver 3.0.0 - END
        inEntity.setDate_ShukeiStart(search_start_date.toString());

        // 表示終了年月日
// [UPD] Ver 3.0.0 - START
//        StringBuilder search_end_date = new StringBuilder("");
//        search_end_date.append(inDto.getDrpID_HyoziEndYear())
//                .append(inDto.getDrpID_HyoziEndMonth()).append(inDto.getDrpID_HyoziEndDay());
        String search_end_date = PNCommonComponents.dateFmtJC_Gyymmdd(
                PNCommonComponents.concatString(
                        inDto.getDrpID_HyoziEndYear(),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziEndMonth(), 2),
                        PNFormatUtils.toZeroPadding(inDto.getDrpID_HyoziEndDay(), 2)),
                "");
// [UPD] Ver 3.0.0 - END
        inEntity.setDate_ShukeiEnd(search_end_date.toString());

        // ・ソート条件の設定
        LinkedHashMap<String, String> mapSortInfo = new LinkedHashMap<String, String>();
        mapSortInfo.put("Code_Organization", "ASC");
        mapSortInfo.put("Date_Report", "DESC");
        mapSortInfo.put("ID_Report", "DESC");
        inEntity.setSortInfo(mapSortInfo);

        List<Se016_01ResultsDataEntity> resultEntityList = se016_01resultsdatadao.findByCondition(inEntity);

        // 検索結果を取得
        // Entityの件数　＞　0　の場合
        if (resultEntityList.size() > 0) {

            // 結果EntityをDTOに転記
            // 　表示用のデータコレクションを作成する。
            // 　明細部設定
            // 　　Entityの件数分ループ
            // 　　　・Se016_01ResultDataEntity.扱店コード　　　　　　　　　　 ⇒　M1DTO.扱店コード
            // 　　　・Se016_01ResultDataEntity.扱店名　　　　　　　　　　　　 ⇒　M1DTO.扱店名
            // 　　　・Se016_01ResultDataEntity.報告年月日　　　　　　　　　　 ⇒　M1DTO.報告日
            // 　　　・Se016_01ResultDataEntity.表示ファイル名　　　　　　　　 ⇒　M1DTO.ファイル名
            // 　　　・Se016_01ResultDataEntity.添付ファイル　　　　　　　　　 ⇒　M1DTO.添付ファイル
            // 　　　・Se016_01ResultDataEntity.添付ファイルアップロード先パス ⇒　M1DTO.添付ファイルアップロード先パス
            // 　　　・Se016_01ResultDataEntity.店舗コード　　　　　　　　　　 ⇒　M1DTO.店舗コード

            List<Se016_01M1DTO> reportList = new ArrayList<Se016_01M1DTO>(resultEntityList.size());
            for (Se016_01ResultsDataEntity outEntity : resultEntityList) {

                Se016_01M1DTO report = new Se016_01M1DTO();

                // 扱店
                report.setLblID_Code_Organization(outEntity.getCode_Organization());
                // 扱店名
                report.setLblID_Name_Organization(outEntity.getName_Organization());
                // 報告年月日
                StringBuilder date_Report = new StringBuilder("");
                date_Report.append(outEntity.getDate_Report().substring(0, 4)).append("/")
                        .append(outEntity.getDate_Report().substring(4, 6)).append("/")
                        .append(outEntity.getDate_Report().substring(6, 8));
                report.setLblID_Date_Report(date_Report.toString());
                // 表示ファイル名
                report.setLblID_Disp_DocName(outEntity.getDisp_DocName());
                // ファイル名
                report.setLblID_DocName(outEntity.getDocName());
                // 添付ファイルアップロード先パス
                report.setLblID_UploadFilePath(outEntity.getFilePath());
                // 店舗
                report.setLblID_Code_Tenpo(outEntity.getCode_Tenpo());
                // 報告書番号
                report.setLblID_Report(outEntity.getID_Report());

                reportList.add(report);
            }
            // （根）抵当権抹消に係る報告一覧データの返却
            // 　作成した表示用データコレクション　⇒　DTO.明細リスト
            outDto.setMeisai_list(reportList);
        }

        // 　呼出し元に復帰する
        return outDto;
    }

    /**
     * Se016_01ServiceのchkResultsData
     *
     * @param inDto Se016_01DTO, SearchIDReport String
     * @return List<TeitokenreportEntity>
     */
    @Override
    public List<TeitokenreportEntity> chkResultsData(Se016_01DTO inDto, String SearchIDReport) {

        TeitokenreportEntity inEntity = new TeitokenreportEntity();
        CFWBeanUtils.copyProperties(inEntity, inDto);
        inEntity.setID_Report(SearchIDReport);

        List<TeitokenreportEntity> outEntityList = teitokenreportDAO.findByCondition(inEntity);

        // 　呼出し元に復帰する
        return outEntityList;
    }

}