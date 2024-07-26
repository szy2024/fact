//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_09Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_09.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_09.dao.Se006_09DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_09のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_09ServiceImpl extends PNBaseService implements Se006_09Service {

    /** se006_09detaildatadao */
    @Autowired
    private Se006_09DetailDataDAO se006_09detaildatadao;

    /**
     * Se006_09ServiceのgetDetailData
     *
     * @param inDto Se006_09DTO
     * @return Se006_09DTO
     */
    @Override
    public Se006_09DTO getDetailData(Se006_09DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_09DTO outDto = new Se006_09DTO();

        // １．表示前処理
        // 検索条件を設定
        // 複数テーブルアクセス定義の「Se006_09DetailDataDAO」を参照し、条件を設定する。
        Se006_09DetailDataEntity inEntity = new Se006_09DetailDataEntity();
        inEntity.setID_Report(inDto.getID_ID_Report());
        List<Se006_09DetailDataEntity> outEntityList = se006_09detaildatadao.findByCondition(inEntity);

        // 代位弁済金払込充当報告書データが存在しない場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　メッセージ：PM3570E
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // １．表示制御
        // Entity⇒DTOに転記
        Se006_09DetailDataEntity outEntity = se006_09detaildatadao.findByCondition(inEntity).get(0);
        // Se006_09DetailDataEntity.データコードの下２桁　＝　７１のとき
        String dataCode = outEntity.getDataCode();
        if (null != dataCode
                && Se006Constants.DATA_CODE_VALUE_71.equals(dataCode.substring(dataCode.length()
                        - Se006Constants.DATA_CODE_LENGTH))) {
            // '更正 赤'⇒Se006_09DTO.メッセージ
            outDto.setlblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
        }
        // Se006_09DetailDataEntity.報告書番号⇒Se006_09DTO.報告書番号
        outDto.setID_ID_Report(outEntity.getID_Report());
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.報告年月日⇒Se006_09DTO.報告年月日
        String outDateReport = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Report());
        outDto.setID_Date_Report(outDateReport);
        // Se006_09DetailDataEntity.報告時分秒⇒Se006_09DTO.報告時分秒
        String outTimeReport = PNCommonComponents.timeFormatConvert(outEntity.getTime_Report());
        outDto.setID_Time_Report(outTimeReport);
        // Se006_09DetailDataEntity.データコード⇒Se006_09DTO.データコード
        outDto.setID_DataCode(outEntity.getDataCode());
        // Se006_09DetailDataEntity.顧客名⇒Se006_09DTO.顧客名
        String outNameCustomer = outEntity.getName_Customer();
        outDto.setID_Name_Customer(outNameCustomer);
        // Se006_09DetailDataEntity.扱店名⇒Se006_09DTO.扱店名
        String outNameOrganization = outEntity.getName_Organization();
        outDto.setID_Name_Organization(outNameOrganization);
        // Se006_09DetailDataEntity.公庫支店コード⇒Se006_09DTO.公庫支店
        String outCodeKoukoShiten = outEntity.getCode_KoukoShiten();
        outDto.setID_Code_KoukoShiten(outCodeKoukoShiten);
        // Se006_09DetailDataEntity.扱店コード⇒Se006_09DTO.扱店
        String outCodeOrganization = outEntity.getCode_Organization();
        outDto.setID_Code_Organization(outCodeOrganization);
        // Se006_09DetailDataEntity.店舗コード⇒Se006_09DTO.店舗
        String outCodeTenpo = outEntity.getCode_Tenpo();
        outDto.setID_Code_Tenpo(outCodeTenpo);
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.年度⇒Se006_09DTO.年度
        String outYear = PNCommonComponents.cnvNulltoBlank(outEntity.getYear());
        outDto.setID_Year(outYear);
        // Se006_09DetailDataEntity.方式資金⇒Se006_09DTO.方式資金
        String outCodeHoshikiShikin = outEntity.getCode_HoshikiShikin();
        outDto.setID_Code_HoshikiShikin(outCodeHoshikiShikin);
        // Se006_09DetailDataEntity.稟議番号⇒Se006_09DTO.番号
        String outIDRingi = outEntity.getID_Ringi();
        outDto.setID_ID_Ringi(outIDRingi);
        // Se006_09DetailDataEntity.稟議番号枝番⇒Se006_09DTO.枝番
        // Se006_09DetailDataEntity.稟議番号枝番　＝　"0" のとき
        // 　空白⇒Se006_09DTO.枝番
        String outIDRingiBranch = outEntity.getID_RingiBranch();
        if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
            outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
        }
        outDto.setID_ID_RingiBranch(outIDRingiBranch);
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.充当対象払込期日⇒Se006_09DTO.充当対象払込期日
        String outDateJutoTaisho = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_JutoTaisho());
        outDto.setID_Date_JutoTaisho(outDateJutoTaisho);
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.代弁金払込日⇒Se006_09DTO.代弁金払込日
        String outDateDaibenkinHaraikomi = PNCommonComponents.cnvNulltoBlank(outEntity
                .getDate_DaibenkinHaraikomi());
        outDto.setID_Date_DaibenkinHaraikomi(outDateDaibenkinHaraikomi);
        // Se006_09DetailDataEntity.遅延損害金⇒Se006_09DTO.遅延損害金(円)
        BigDecimal outMChienSongai = outEntity.getM_ChienSongai();
        outDto.setID_M_ChienSongai(outMChienSongai);
        // Se006_09DetailDataEntity.利息⇒Se006_09DTO.利息(円)
        BigDecimal outMRisoku = outEntity.getM_Risoku();
        outDto.setID_M_Risoku(outMRisoku);
        // Se006_09DetailDataEntity.繰上償還手数料⇒Se006_09DTO.繰上償還手数料(円)
        BigDecimal outMKurishoCommission = outEntity.getM_KurishoCommission();
        outDto.setID_M_KurishoCommission(outMKurishoCommission);
        // Se006_09DetailDataEntity.元金⇒Se006_09DTO.元金(円)
        BigDecimal outMGankin = outEntity.getM_Gankin();
        outDto.setID_M_Gankin(outMGankin);

        // Se006_09DetailDataEntity.仮受金（一般口）からの充当⇒Se006_09DTO.仮受金(一般口)からの充当額(円)
        BigDecimal outMKariukeIppanJuto = outEntity.getM_KariukeIppanJuto();
        // outDto.setID_M_KariukeIppanJuto(outMKariukeIppanJuto);
        if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outMKariukeIppanJuto))) {
            outDto.setID_M_KariukeIppanJuto(null);
        } else {
            outDto.setID_M_KariukeIppanJuto(outMKariukeIppanJuto);
        }
        // Se006_09DetailDataEntity.計⇒Se006_09DTO.計(円)
        BigDecimal outMKei = outEntity.getM_Kei();
        outDto.setID_M_Kei(outMKei);
        // Se006_09DetailDataEntity.送金額⇒Se006_09DTO.送金額(円)
        BigDecimal outMSokin = outEntity.getM_Sokin();
        outDto.setID_M_Sokin(outMSokin);
        // Se006_09DetailDataEntity.代弁後残元金⇒Se006_09DTO.代弁金充当後残元金(円)
        BigDecimal outMZanGanAfterDaibenJuto = outEntity.getM_ZanGanAfterDaibenJuto();
        outDto.setID_M_ZanGanAfterDaibenJuto(outMZanGanAfterDaibenJuto);
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.受託者勘定処理年月⇒Se006_09DTO.受託者勘定処理年月
        String outDateJtkshori = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Jtkshori());
        outDto.setID_Date_Jtkshori(outDateJtkshori);
        // 西暦から和暦に変換して設定する
        // 　Se006_09DetailDataEntity.送金日⇒Se006_09DTO.送金日
        String outDateSokin = PNCommonComponents.cnvNulltoBlank(outEntity.getDate_Sokin());
        outDto.setID_Date_Sokin(outDateSokin);
        // Se006_09DetailDataEntity.送金日番号⇒Se006_09DTO.送金日番号
        String outIDSokinbi = outEntity.getID_Sokinbi();
        outDto.setID_ID_Sokinbi(outIDSokinbi);
        return outDto;
    }

}