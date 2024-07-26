//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_17Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/25 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_17.service;

import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.se006.se006_17.dao.Se006_17ResultDataDAO;
import jp.go.jfc.partnernet.se006.se006_17.dao.Se006_17ResultDataEntity;

/**
 * <pre>
 * このクラスはse006_17のサービスクラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
public class Se006_17ServiceImpl extends PNBaseService implements Se006_17Service {

    /** se006_17resultdatadao */
    @Autowired
    private Se006_17ResultDataDAO se006_17resultdatadao;

    /**
     * Se006_17ServiceのgetResultsData
     *
     * @param inDto Se006_17DTO
     * @return Se006_17DTO
     */
    @Override
    public Se006_17DTO getResultsData(Se006_17DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_17DTO outDto = new Se006_17DTO();

        // 取消・修正対象データの取得
        // 取得条件を設定
        // 　・DTO.報告書番号　⇒　Se006_17ResultDataEntity.報告書番号
        Se006_17ResultDataEntity inEntity = new Se006_17ResultDataEntity();
        inEntity.setID_Report(inDto.getLblID_Report());
        List<Se006_17ResultDataEntity> outEntityList = se006_17resultdatadao.findByCondition(inEntity);

        // （根）抵当権抹消に係る報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　PM3570E : 報告書が見つかりません。 ⇒ DTO.業務エラーリスト
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 取得した情報　＞　０件　の場合、取得した情報をDTOに設定する。
        // Entity⇒DTOに転記
        Se006_17ResultDataEntity outEntity = outEntityList.get(0);

        outDto.setLblID_Name_Organization(outEntity.getName_Organization());

        // 西暦から和暦に変換して設定する
// [UPD] Ver 3.0.0 - START
//        String outDate_ReportYear = PNCommonComponents.dateFmtAD_YYYY(outEntity.getDate_Report().substring(0, 4));
        String outDate_ReportYear = PNCommonComponents.dateFmtAD_YYYYMMDD(outEntity.getDate_Report()).split("\\.")[0];
// [UPD] Ver 3.0.0 - END
        String outDate_ReportMonth = outEntity.getDate_Report().substring(4, 6);
        String outDate_ReportDate = outEntity.getDate_Report().substring(6, 8);
        outDto.setLblID_SendDate_Report(outDate_ReportYear + "年"
                + outDate_ReportMonth + "月"
                + outDate_ReportDate + "日");

        outDto.setLblID_DocName(outEntity.getDocName());
        outDto.setLblID_Disp_DocName(outEntity.getDisp_DocName());
        outDto.setLblID_UploadFilePath(outEntity.getFilePath());
        outDto.setLblID_Report(outEntity.getID_Report());

        return outDto;
    }

}