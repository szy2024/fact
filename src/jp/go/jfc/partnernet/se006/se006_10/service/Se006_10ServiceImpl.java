//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_10Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_10.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_10.dao.Se006_10DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_10.dao.Se006_10DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_10のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_10ServiceImpl extends PNBaseService implements Se006_10Service {

    /** se006_10detaildatadao */
    @Autowired
    private Se006_10DetailDataDAO se006_10detaildatadao;

    /**
     * Se006_10ServiceのgetDetailData
     *
     * @param inDto Se006_10DTO
     * @return Se006_10DTO
     */
    @Override
    public Se006_10DTO getDetailData(Se006_10DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_10DTO outDto = new Se006_10DTO();

        // １．表示前処理
        // 検索条件を設定
        // 複数テーブルアクセス定義の「Se006_10DetailDataDAO」を参照し、条件を設定する。
        // Se006_10DetailDataDAO.findByCondition
        Se006_10DetailDataEntity inEntity = new Se006_10DetailDataEntity();
        inEntity.setID_Report(inDto.getLblID_ID_Report());
        List<Se006_10DetailDataEntity> outEntityList = se006_10detaildatadao.findByCondition(inEntity);

        // 立替金受入充当報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　メッセージ：PM3570E
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // １．表示制御
        // Entity⇒DTOに転記
        Se006_10DetailDataEntity outEntity = outEntityList.get(0);
        // Se006_10DetailDataEntity.データコード　＝　"90257091"(立替金受入(赤)) のとき
        String dataCode = outEntity.getDataCode();
        if (Se006Constants.DATACODE_90257091.equals(dataCode)) {
            // '更正 赤'⇒Se006_10DTO.メッセージ
            outDto.setLblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
        }
        // Se006_10DetailDataEntity.報告書番号⇒Se006_10DTO.報告書番号
        outDto.setLblID_ID_Report(outEntity.getID_Report());
        // 西暦から和暦に変換して設定する
        // 　Se006_10DetailDataEntity.報告年月日⇒Se006_10DTO.報告年月日
        String outDateReport = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Report());
        outDto.setLblID_Date_Report(outDateReport);
        // Se006_10DetailDataEntity.報告時分秒⇒Se006_10DTO.報告時分秒
        String outTimeReport = PNCommonComponents.timeFormatConvert(outEntity.getTime_Report());
        outDto.setLblID_Time_Report(outTimeReport);
        // Se006_10DetailDataEntity.顧客名⇒Se006_10DTO.顧客名
        outDto.setLblID_Name_Customer(outEntity.getName_Customer());
        // Se006_10DetailDataEntity.扱店名⇒Se006_10DTO.扱店名
        outDto.setLblID_Name_Organization(outEntity.getName_Organization());
        // Se006_10DetailDataEntity.公庫支店コード⇒Se006_10DTO.公庫支店
        outDto.setLblID_Code_KoukoShiten(outEntity.getCode_KoukoShiten());
        // Se006_10DetailDataEntity.扱店コード⇒Se006_10DTO.扱店
        outDto.setLblID_Code_Organization(outEntity.getCode_Organization());
        // Se006_10DetailDataEntity.店舗コード⇒Se006_10DTO.店舗
        outDto.setLblID_Code_Tenpo(outEntity.getCode_Tenpo());
        // 西暦から和暦に変換して設定する
        // 　Se006_10DetailDataEntity.年度⇒Se006_10DTO.年度
        String outYear = PNCommonComponents.cnvNulltoBlank(outEntity.getYear());
        outDto.setLblID_Year(outYear);
        // Se006_10DetailDataEntity.方式資金⇒Se006_10DTO.方式資金
        outDto.setLblID_Code_HoshikiShikin(outEntity.getCode_HoshikiShikin());
        // Se006_10DetailDataEntity.稟議番号⇒Se006_10DTO.番号
        outDto.setLblID_ID_Ringi(outEntity.getID_Ringi());
        // Se006_10DetailDataEntity.稟議番号枝番⇒Se006_10DTO.枝番
        String outIDRingiBranch = outEntity.getID_RingiBranch();
        if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
            outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
        }
        outDto.setLblID_ID_RingiBranch(outIDRingiBranch);
        // 西暦から和暦に変換して設定する
        // 　Se006_10DetailDataEntity.入金日⇒Se006_10DTO.入金日
        String outDataNyukin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Nyukin());
        outDto.setLblID_Date_Nyukin(outDataNyukin);
        // Se006_10DetailDataEntity.立替金利息⇒Se006_10DTO.立替金利息(円)
        outDto.setLblID_M_TatekaeRisoku(outEntity.getM_TatekaeRisoku());
        // Se006_10DetailDataEntity.立替金⇒Se006_10DTO.立替金(円)
        outDto.setLblID_M_Tatekae(outEntity.getM_Tatekae());
        // Se006_10DetailDataEntity.仮受金（一般口）充当⇒Se006_10DTO.仮受金(一般口)からの充当額(円)
        if (0 == BigDecimal.ZERO
                .compareTo(PNCommonComponents.cnvNulltoZero(outEntity.getM_KariukeIppanJuto()))) {
            // 仮受金(一般口)からの充当額が０の場合、ブランク表示
            outDto.setLblID_M_KariukeIppanJuto(null);
        } else {
            outDto.setLblID_M_KariukeIppanJuto(PNCommonComponents.cnvNulltoZero(outEntity
                    .getM_KariukeIppanJuto()));
        }
        // Se006_10DetailDataEntity.立替金の種類の値により以下のように設定
        String outTatekaekinShurui = outEntity.getCode_TatekaekinShurui();
        if (Se006Constants.TATEKAEKIN_SHURUI_1.equals(outTatekaekinShurui)) {
            // 　１の場合、'1.訴訟費用'⇒Se006_10DTO.立替金の種類
            outDto.setLblID_Code_TatekaekinShurui("1.訴訟費用");
        } else if (Se006Constants.TATEKAEKIN_SHURUI_2.equals(outTatekaekinShurui)) {
            // 　２の場合、'2.保険料'⇒Se006_10DTO.立替金の種類
            outDto.setLblID_Code_TatekaekinShurui("2.保険料");
        } else if (Se006Constants.TATEKAEKIN_SHURUI_3.equals(outTatekaekinShurui)) {
            // 　３の場合、'3.求償権等'⇒Se006_10DTO.立替金の種類
            outDto.setLblID_Code_TatekaekinShurui("3.求償権等");
        }
        // 西暦から和暦に変換して設定する
        // 　Se006_10DetailDataEntity.公庫立替日⇒Se006_10DTO.公庫立替日
        String outDateKoukoTatekae = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_KoukoTatekae());
        outDto.setLblID_Date_KoukoTatekae(outDateKoukoTatekae);
        // Se006_10DetailDataEntity.計⇒Se006_10DTO.計(円)
        outDto.setLblID_M_Kei(outEntity.getM_Kei());
        // Se006_10DetailDataEntity.送金額⇒Se006_10DTO.送金額(円)
        outDto.setLblID_M_Sokin(outEntity.getM_Sokin());
        // Se006_10DetailDataEntity.受入後立替金残高⇒Se006_10DTO.受入後立替金残高(円)
        outDto.setLblID_M_TatekaeZanAfterUkeire(outEntity.getM_TatekaeZanAfterUkeire());
        // 西暦から和暦に変換して設定する
        // 　Se006_10DetailDataEntity.受託者勘定処理年月⇒Se006_10DTO.受託者勘定処理年月
        String outDataJtkshori = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Jtkshori());
        outDto.setLblID_Date_Jtkshori(outDataJtkshori);
        // 　Se006_10DetailDataEntity.送金日⇒Se006_10DTO.送金年月日
        String outDataSokin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Sokin());
        outDto.setLblID_Date_Sokin(outDataSokin);
        // Se006_10DetailDataEntity.送金日番号⇒Se006_10DTO.送金日番号
        outDto.setLblID_ID_Sokinbi(outEntity.getID_Sokinbi());

        return outDto;
    }

}