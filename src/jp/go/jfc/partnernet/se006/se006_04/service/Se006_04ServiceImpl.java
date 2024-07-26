//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/01 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_04.service;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_04.dao.Se006_04DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_04のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_04ServiceImpl extends PNBaseService implements Se006_04Service {

    /** se006_04detaildatadao */
    @Autowired
    private Se006_04DetailDataDAO se006_04detaildatadao;

    /**
     * Se006_04ServiceのgetDetailData
     *
     * @param inDto Se006_04DTO
     * @return Se006_04DTO
     */
    @Override
    public Se006_04DTO getDetailData(Se006_04DTO inDto) throws IllegalAccessException,
            InvocationTargetException {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_04DTO outDto = new Se006_04DTO();

        // １．表示前処理
        // 検索条件を設定
        // 複数テーブルアクセス定義の「Se006_04DetailDataDAO」を参照し、条件を設定する。
        Se006_04DetailDataEntity inEntity = new Se006_04DetailDataEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        List<Se006_04DetailDataEntity> outEntityList = se006_04detaildatadao.findByCondition(inEntity);

        // 報告書履歴データが存在しない場合
        if (0 == outEntityList.size()) {
            // メッセージID：PM3570E
            // 処理を抜ける。
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // １．表示制御
        // Entity⇒DTOに転記
        Se006_04DetailDataEntity outEntity = se006_04detaildatadao.findByCondition(inEntity).get(0);

        // Se006_04DetailDataEntity.エラーメッセージ⇒Se006_04DTO.エラーメッセージ
        outDto.setLblErrorMsg(outEntity.getErrorMessage());
        return outDto;
    }

}