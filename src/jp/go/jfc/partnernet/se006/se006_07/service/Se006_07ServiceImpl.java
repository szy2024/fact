//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_07Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/17 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_07.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se006.common.Se006Constants;
import jp.go.jfc.partnernet.se006.se006_07.dao.Se006_07DetailDataDAO;
import jp.go.jfc.partnernet.se006.se006_07.dao.Se006_07DetailDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe006_07のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_07ServiceImpl extends PNBaseService implements Se006_07Service {

    /** se006_07detaildatadao */
    @Autowired
    private Se006_07DetailDataDAO se006_07detaildatadao;

    /**
     * Se006_07ServiceのgetDetailData
     *
     * @param inDto Se006_07DTO
     * @return Se006_07DTO
     */
    @Override
    public Se006_07DTO getDetailData(Se006_07DTO inDto) {

        /** エラーリスト */
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // エラーリスト初期化
        bizErrors.clear();

        Se006_07DTO outDto = new Se006_07DTO();

        // １．表示前処理
        // 検索条件を設定
        // 複数テーブルアクセス定義の「Se006_07DetailDataDAO」を参照し、条件を設定する。
        // Se006_07DetailDataDAO.findByCondition
        Se006_07DetailDataEntity inEntity = new Se006_07DetailDataEntity();
        inEntity.setID_Report(inDto.getID_ID_Report());
        List<Se006_07DetailDataEntity> outEntityList = se006_07detaildatadao.findByCondition(inEntity);

        // 元利金受入充当報告書データが存在しない場合
        // 　処理を抜ける。
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3570E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }
        // １．表示制御
        // Entity⇒DTOに転記
        Se006_07DetailDataEntity outEntity = se006_07detaildatadao.findByCondition(inEntity).get(0);
        // Se006_07DetailDataEntity.報告書番号⇒Se006_07DTO.報告書番号
        outDto.setID_ID_Report(outEntity.getID_Report());
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.報告年月日⇒Se006_07DTO.報告年月日
        String outDataReport = outEntity.getDate_Report();
        outDto.setID_Date_Report(PNCommonComponents.cnvNulltoBlank(outDataReport));
        // Se006_07DetailDataEntity.報告時分秒⇒Se006_07DTO.報告時分秒
        String outTimeReport = outEntity.getTime_Report();
        outDto.setID_Time_Report(PNCommonComponents.timeFormatConvert(outTimeReport));
        // Se006_07DetailDataEntity.顧客名⇒Se006_07DTO.顧客名
        outDto.setID_Name_Customer(outEntity.getName_Customer());
        // Se006_07DetailDataEntity.扱店名⇒Se006_07DTO.扱店名
        outDto.setID_Name_Organization(outEntity.getName_Organization());
        // Se006_07DetailDataEntity.公庫支店コード⇒Se006_07DTO.公庫支店
        outDto.setID_Code_KoukoShiten(outEntity.getCode_KoukoShiten());
        // Se006_07DetailDataEntity.扱店コード⇒Se006_07DTO.扱店
        outDto.setID_Code_Organization(outEntity.getCode_Organization());
        // Se006_07DetailDataEntity.店舗コード⇒Se006_07DTO.店舗
        outDto.setID_Code_Tenpo(outEntity.getCode_Tenpo());
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.年度⇒Se006_07DTO.年度
        String outYear = outEntity.getYear();
        outDto.setID_Year(PNCommonComponents.cnvNulltoBlank(outYear));
        // Se006_07DetailDataEntity.方式資金⇒Se006_07DTO.方式資金
        outDto.setID_Kubun_Hoshiki(outEntity.getCode_HoshikiShikin());
        // Se006_07DetailDataEntity.稟議番号⇒Se006_07DTO.番号
        outDto.setID_ID_Ringi(outEntity.getID_Ringi());
        // Se006_07DetailDataEntity.稟議番号枝番⇒Se006_07DTO.枝番
        String outIDRingiBranch = outEntity.getID_RingiBranch();
        if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(outIDRingiBranch)) {
            outIDRingiBranch = PNCommonConstants.HALF_CHAR_SPACE;
        }
        outDto.setID_ID_RingiBranch(outIDRingiBranch);
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.貸付実行年月日⇒Se006_07DTO.貸付実行日
        String outDataJikko = outEntity.getDate_kashitsukeJikko();
        outDto.setID_Date_Kashitsukejikko(PNCommonComponents.cnvNulltoBlank(outDataJikko));
        // Se006_07DetailDataEntity.貸付金額⇒Se006_07DTO.貸付実行金額
        outDto.setID_M_Kashitsuke(outEntity.getM_Kashitsuke());
        // Se006_07DetailDataEntity.資金使途コード⇒Se006_07DTO.資金使途
        outDto.setID_Code_ShikinShito(outEntity.getCode_ShikinShito());
        // Se006_07DetailDataEntity.事業別コード⇒Se006_07DTO.事業別
        outDto.setID_Code_Jigyobetsu(outEntity.getCode_Jigyobetsu());
        // 利率を１０００で割り設定する
        // 　Se006_07DetailDataEntity.利率⇒Se006_07DTO.利率
        outDto.setID_Riritsu(PNCommonComponents.mathPercent1000(outEntity.getRiritsu()));
        // Se006_07DetailDataEntity.特利区分コード⇒Se006_07DTO.特利区分
        outDto.setID_Kubun_Tokuri(outEntity.getCode_TokuriKubun());
        // 特利（利率）を１０００で割り設定する
        // 　Se006_07DetailDataEntity.特利（利率）⇒Se006_07DTO.特利
        outDto.setID_Tokuri(PNCommonComponents.mathPercent1000(outEntity.getTokuri()));
        // Se006_07DetailDataEntity.償還方法⇒Se006_07DTO.償還方法
        outDto.setID_Code_Shokan(outEntity.getCode_Shokan());
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.据置期限（年月）⇒Se006_07DTO.据置期限
        String outDataSueokiKigen = outEntity.getDate_SueokiKigen();
        outDto.setID_Date_SueokiKigen(PNCommonComponents.cnvNulltoBlank(outDataSueokiKigen));
        // 　Se006_07DetailDataEntity.償還期限（年月）⇒Se006_07DTO.償還期限
        String outDataShokanKigen = outEntity.getDate_ShokanKigen();
        outDto.setID_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outDataShokanKigen));
        // 　Se006_07DetailDataEntity.元利金払込日⇒Se006_07DTO.元利金払込日
        String outDataGanrikinHaraikomi = outEntity.getDate_GanrikinHaraikomi();
        outDto.setID_Date_GanrikinHaraiKomi(PNCommonComponents.dateFmtAD_MMDD(outDataGanrikinHaraikomi));
        // Se006_07DetailDataEntity.元利又は元金均等額⇒Se006_07DTO.元利又は元金均等額
        outDto.setID_M_GankinKinto(outEntity.getM_GankinKinto());
        // Se006_07DetailDataEntity.払込前残元金⇒Se006_07DTO.払込前残元金
        outDto.setID_M_KashitsukeZandaka(outEntity.getM_KashitsukeZandaka());
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.払込期日⇒Se006_07DTO.払込期日
        String outDataHaraikomi = outEntity.getDate_Haraikomi();
        outDto.setID_Date_Haraikomi(PNCommonComponents.cnvNulltoBlank(outDataHaraikomi));
        // Se006_07DetailDataEntity.払込金額⇒Se006_07DTO.払込金額
        outDto.setID_M_Haraikomi(outEntity.getM_Haraikomi());
        // Se006_07DetailDataEntity.控除利息⇒Se006_07DTO.控除利息
        outDto.setID_M_KojoRisoku(outEntity.getM_KojoRisoku());
        // Se006_07DetailDataEntity.差引払込額⇒Se006_07DTO.差引払込額
        outDto.setID_M_SashihikiHaraikomi(outEntity.getM_SashihikiHaraikomi());
        // Se006_07DetailDataEntity.払込後残元金⇒Se006_07DTO.払込後残元金
        outDto.setID_M_ZangankinAfterHaraikomi(outEntity.getM_ZangankinAfterHaraikomi());
        // Se006_07DetailDataEntity.約定利息⇒Se006_07DTO.約定利息
        outDto.setID_M_YakujoRisoku(outEntity.getM_YakujoRisoku());
        // Se006_07DetailDataEntity.約定元金⇒Se006_07DTO.約定元金
        outDto.setID_M_YakujoGankin(outEntity.getM_YakujoGankin());
        // Se006_07DetailDataEntity.遅延損害金⇒Se006_07DTO.遅延損害金
        outDto.setID_M_ChienSongai(outEntity.getM_ChienSongai());
        // Se006_07DetailDataEntity.違約金⇒Se006_07DTO.違約金
        outDto.setID_M_Iyaku(outEntity.getM_Iyaku());
        // Se006_07DetailDataEntity.違約金(利子軽減分)(基金れい入金)⇒Se006_07DTO.違約金(利子軽減分)(基金れい入金)
        outDto.setID_M_IyakuRishikeigen(outEntity.getM_IyakuRishikeigen());
        // Se006_07DetailDataEntity.借受金(一般口)からの充当額⇒Se006_07DTO.借受金(一般口)からの充当額
        if (0 == BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                .getM_KariukeIppanJuto()))) {
            outDto.setID_M_KariukeIppanJuto(null);
        } else {
            outDto.setID_M_KariukeIppanJuto(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                    .getM_KariukeIppanJuto()));
        }
        // 西暦から和暦に変換して設定する
        // 　Se006_07DetailDataEntity.入金日⇒Se006_07DTO.入金日
        String outDateNyukin = outEntity.getDate_Nyukin();
        outDto.setID_Date_Nyukin(PNCommonComponents.cnvNulltoBlank(outDateNyukin));
        // 　Se006_07DetailDataEntity.受託者勘定処理年月⇒Se006_07DTO.受託者勘定処理年月
        String outDateJtkshori = outEntity.getDate_Jtkshori();
        outDto.setID_Date_Jtkshori(PNCommonComponents.cnvNulltoBlank(outDateJtkshori));
        // 　Se006_07DetailDataEntity.送金日⇒Se006_07DTO.送金日
        String outDateSokin = outEntity.getDate_Sokin();
        outDto.setID_Date_Sokin(PNCommonComponents.cnvNulltoBlank(outDateSokin));
        // Se006_07DetailDataEntity.送金日番号⇒Se006_07DTO.送金日番号
        outDto.setID_ID_Sokinbi(outEntity.getID_Sokinbi());
        // 初期値'0'⇒Se006_07DTO.代弁履行後の作成
        outDto.setCkhAfter_Daibensai(PNCommonConstants.CHECKBOX_VALUE_OFF);
        // データコードの判定
        // Se006_07DetailDataEntity.データコードの下２桁取得
        int dataCodeLength = outEntity.getDataCode().length();
        String dataCode = outEntity.getDataCode().substring(dataCodeLength - Se006Constants.DATA_CODE_LENGTH);
        // Se006_07DetailDataEntity.データコードの下２桁　＝　４０または、４１のとき
        if (dataCode.equals(Se006Constants.DATA_CODE_VALUE_40)
                || dataCode.equals(Se006Constants.DATA_CODE_VALUE_41)) {
            // '1'⇒Se006_07DTO.代弁履行後の作成
            outDto.setCkhAfter_Daibensai(PNCommonConstants.CHECKBOX_VALUE_ON);
        }

        // Se006_07DetailDataEntity.データコードの下２桁　＝　３１または、４１のとき
        if (dataCode.equals(Se006Constants.DATA_CODE_VALUE_31)
                || dataCode.equals(Se006Constants.DATA_CODE_VALUE_41)) {
            // '更正 赤'⇒Se006_07DTO.メッセージ
            outDto.setLblMessage(Se006Constants.MESSAGE_KOSEI_AKA);
        }

        return outDto;
    }
}