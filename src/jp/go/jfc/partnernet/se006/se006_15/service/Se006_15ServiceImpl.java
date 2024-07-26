//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_15Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/04 | 嶋田　美保            | H29年追加開発案件対応
// 3.0.0   | 2019/01/25 | 坂　竜太              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_15.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.se006.se006_15.dao.Se006_15ResultDataDAO;
import jp.go.jfc.partnernet.se006.se006_15.dao.Se006_15ResultDataEntity;

/**
 * <pre>
 * このクラスはse006_15のサービスクラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 3.0.0
 */
public class Se006_15ServiceImpl extends PNBaseService implements Se006_15Service {

    /** se006_15resultdatadao */
    @Autowired
    private Se006_15ResultDataDAO se006_15resultdatadao;

    /**
     * Se006_15ServiceのgetResultsData
     *
     * @param inDto Se006_15DTO
     * @return Se006_15DTO
     */
    @Override
    public Se006_15DTO getResultsData(Se006_15DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_15DTO outDto = new Se006_15DTO();

        // 取消・修正対象データの取得
        // 取得条件を設定
        // 　・DTO.報告書番号　⇒　Se006_15ResultDataEntity.報告書番号
        // 複数テーブルアクセス定義の「Se006_14ResultDataDAO」を実行し、条件を設定する。
        Se006_15ResultDataEntity inEntity = new Se006_15ResultDataEntity();
        inEntity.setID_Report(inDto.getLblID_Report());
        List<Se006_15ResultDataEntity> outEntityList = se006_15resultdatadao.findByCondition(inEntity);

        // 資金交付依頼予定表（月間）報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　PM3570E : 報告書が見つかりません。 ⇒ DTO.業務エラーリスト
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // Entity⇒DTOに転記
        Se006_15ResultDataEntity outEntity = outEntityList.get(0);

        List<Se006_15M1DTO> reportList = new ArrayList<Se006_15M1DTO>(outEntityList.size());
        Se006_15M1DTO report = new Se006_15M1DTO();

        // 西暦から和暦に変換して設定する
// [UPD] Ver 3.0.0 - START
//        String outDate_KofuYear = PNCommonComponents.dateFmtAD_YYYY(outEntity.getDate_Kofu().substring(0, 4));
        String outDate_KofuYear = PNCommonComponents.dateFmtAD_YYYYMMDD(outEntity.getDate_Kofu()).split("\\.")[0];
// [UPD] Ver 3.0.0 - END
        String outDate_KofuMonth = outEntity.getDate_Kofu().substring(4, 6);
        String outDate_KofuDate = outEntity.getDate_Kofu().substring(6, 8);
        outDto.setLblID_ShiteiKofu(outDate_KofuYear + "年" + outDate_KofuMonth + "月" + outDate_KofuDate + "日");

        report.setLblID_M_Yotei(outEntity.getM_Yotei());
        report.setLblID_M_Ganju_GaiSu(outEntity.getM_Ganju_Gaisu());
        report.setLblID_M_ZanMikomi(outEntity.getM_ZanMikomi());
        report.setLblID_M_Biko(outEntity.getM_Biko());
        reportList.add(report);
        outDto.setMeisai_list(reportList);

        return outDto;
    }

}