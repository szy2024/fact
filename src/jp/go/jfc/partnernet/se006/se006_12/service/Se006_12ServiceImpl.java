//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_12Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_12.service;

import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_12.dao.Se006_12DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_12.dao.Se006_12DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_12のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_12ServiceImpl extends PNBaseService implements Se006_12Service {

    /** se006_12detaildatadao */
    @Autowired
    private Se006_12DetailDataDAO se006_12detaildatadao;

    /**
     * Se006_12ServiceのgetDetailData
     *
     * @param inDto Se006_12DTO
     * @return Se006_12DTO
     */
    @Override
    public Se006_12DTO getDetailData(Se006_12DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_12DTO outDto = new Se006_12DTO();

        // １．表示前処理
        // 検索条件を設定
        // 複数テーブルアクセス定義の「Se006_12DetailDataDAO」を参照し、条件を設定する。
        // Se006_12DetailDataDAO.findByCondition
        Se006_12DetailDataEntity inEntity = new Se006_12DetailDataEntity();
        inEntity.setID_Report(inDto.getLblID_ID_Report());
        List<Se006_12DetailDataEntity> outEntityList = se006_12detaildatadao.findByCondition(inEntity);

        // 仮受金（一般口）受入報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　メッセージ：PM3570E
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // １．表示制御
        // Entity⇒DTOに転記
        Se006_12DetailDataEntity outEntity = outEntityList.get(0);
        // Se006_12DetailDataEntity.データコード　＝　"90257111"(取消時) のとき
        String outDataCode = outEntity.getDataCode();
        if (Se006Constants.DATACODE_90257111.equals(outDataCode)) {
            // '更正 赤'⇒Se006_12DTO.メッセージ
            outDto.setLblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
        }
        // Se006_12DetailDataEntity.報告書番号⇒Se006_12DTO.報告書番号
        outDto.setLblID_ID_Report(outEntity.getID_Report());
        // 西暦から和暦に変換して設定する
        // 　Se006_12DetailDataEntity.報告年月日⇒Se006_12DTO.報告年月日
        String outDateReport = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Report());
        outDto.setLblID_Date_Report(outDateReport);
        // Se006_12DetailDataEntity.報告時分秒⇒Se006_12DTO.報告時分秒
        String outTimeReport = PNCommonComponents.timeFormatConvert(outEntity.getTime_Report());
        outDto.setLblID_Time_Report(outTimeReport);
        // Se006_12DetailDataEntity.顧客名⇒Se006_12DTO.顧客名
        outDto.setLblID_Name_Customer(outEntity.getName_Customer());
        // Se006_12DetailDataEntity.扱店名⇒Se006_12DTO.扱店名
        outDto.setLblID_Name_Organization(outEntity.getName_Organization());
        // Se006_12DetailDataEntity.公庫支店コード⇒Se006_12DTO.公庫支店
        outDto.setLblID_Code_KoukoShiten(outEntity.getCode_KoukoShiten());
        // Se006_12DetailDataEntity.扱店コード⇒Se006_12DTO.扱店
        outDto.setLblID_Code_Organization(outEntity.getCode_Organization());
        // Se006_12DetailDataEntity.店舗コード⇒Se006_12DTO.店舗
        outDto.setLblID_Code_Tenpo(outEntity.getCode_Tenpo());
        // 西暦から和暦に変換して設定する
        // 　Se006_12DetailDataEntity.年度⇒Se006_12DTO.年度
        String outYear = PNCommonComponents.cnvNulltoBlank(outEntity.getYear());
        outDto.setLblID_Year(outYear);
        // Se006_12DetailDataEntity.方式資金⇒Se006_12DTO.方式資金
        outDto.setLblID_Code_HoshikiShikin(outEntity.getCode_HoshikiShikin());
        // Se006_12DetailDataEntity.稟議番号⇒Se006_12DTO.番号
        outDto.setLblID_ID_Ringi(outEntity.getID_Ringi());
        // Se006_12DetailDataEntity.稟議番号枝番⇒Se006_12DTO.枝番
        String outIDRingiBranch = outEntity.getID_RingiBranch();
        if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
            outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
        }
        outDto.setLblID_ID_RingiBranch(outIDRingiBranch);
        // 西暦から和暦に変換して設定する
        // 　Se006_12DetailDataEntity.入金日⇒Se006_12DTO.入金日
        String outDataNyukin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Nyukin());
        outDto.setLblID_Date_Nyukin(outDataNyukin);
        // Se006_12DetailDataEntity.仮受金（一般口）受入れ⇒Se006_12DTO.仮受金(一般口)受入額
        outDto.setLblID_M_KariukeIppanUkeire(outEntity.getM_KariukeIppanUkeire());
        // 西暦から和暦に変換して設定する
        // 　Se006_12DetailDataEntity.受託者勘定処理年月⇒Se006_12DTO.受託者勘定処理年月
        String outDataJtkshori = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Jtkshori());
        outDto.setLblID_Date_Jtkshori(outDataJtkshori);
        // 　Se006_12DetailDataEntity.送金日⇒Se006_12DTO.送金年月日
        String outDataSokin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Sokin());
        outDto.setLblID_Date_Sokin(outDataSokin);
        // Se006_12DetailDataEntity.送金日番号⇒Se006_12DTO.送金日番号
        outDto.setLblID_ID_Sokinbi(outEntity.getID_Sokinbi());

        return outDto;
    }
}