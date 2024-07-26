//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
// 2.0.0   | 2017/11/30 | 嶋田　美保            | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_04.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataDAO;
import jp.go.jfc.partnernet.cr008.cr008_04.dao.Cr008_04GetResultDataEntity;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはcr008_04のサービスクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Cr008_04ServiceImpl extends PNBaseService implements Cr008_04Service {

    /** cr008_04getresultdatadao */
    @Autowired
    private Cr008_04GetResultDataDAO cr008_04getresultdatadao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr008_04ServiceのgetResultData
     *
     * @param inDto Cr008_04DTO
     * @return Cr008_04DTO
     */
    @Override
    public Cr008_04DTO getResultData(Cr008_04DTO inDto) {

        Cr008_04DTO outDto = new Cr008_04DTO();
        Cr008_04GetResultDataEntity inEntity = new Cr008_04GetResultDataEntity();

        // 受渡情報の取得
        // 仮受金（一般口）受入報告書作成データの検索条件を設定
        // 　　複数テーブルアクセス定義の「Cr008_04GetResultsDataDAO」を参照し、条件を設定する。

        // 年度を和暦（Gyy）から西暦（YYYY）へ変換
        String convYear = "";
        if (!StringUtils.isEmpty(inDto.getCr008_04_In_Year())) {
            convYear = PNCommonComponents.dateFmtJC_Gyy(inDto.getCr008_04_In_Year());
        }
        inDto.setCr008_04_In_Year(convYear);

        // // DTO.枝番が空であるかチェック
        if (StringUtils.isEmpty(inDto.getCr008_04_In_ID_RingiBranch())) {
            // DTO.枝番が空の場合、0へ置き換える
            inDto.setCr008_04_In_ID_RingiBranch(Cr008Constants.RINGIBRANCH_NUM);
        }

        // 　　※遷移元画面からの受渡情報を設定する（DTO→Entity）
        // 　　　DTO.公庫支店入力値　→　Cr008_04GetResultDataEntity.公庫支店入力値
        // 　　　DTO.扱店入力値　→　Cr008_04GetResultDataEntity.扱店入力値
        // 　　　DTO.店舗コード　→　Cr008_04GetResultDataEntity.店舗入力値
        // 　　　DTO.年度を和暦（Gyy）から西暦（YYYY）へ変換　→　Cr008_04GetResultDataEntity.年度入力値
        // 　　　DTO.方式資金入力値　→　Cr008_04GetResultDataEntity.方式資金入力値
        // 　　　DTO.番号入力値　→　Cr008_04GetResultDataEntity.番号入力値
        // 　　　DTO.枝番入力値　→　Cr008_04GetResultDataEntity.枝番入力値
        // 　　　DTO.債権管理番号入力値　→　Cr008_04GetResultDataEntity.債権番号入力値
        CFWBeanUtils.copyProperties(inEntity, inDto);

        // 　　Cr008_04GetResultsDataDAO.findByCondition
        List<Cr008_04GetResultDataEntity> outEntity = new ArrayList<Cr008_04GetResultDataEntity>();

        outEntity = cr008_04getresultdatadao.findByCondition(inEntity);

        // 検索結果のレコード件数を設定
        outDto.setRecCount(outEntity.size());

        // 検索結果の判定
        if (PNCommonConstants.RECORD_COUNT_ONE == outEntity.size()) {
            // 　　取得結果が１件の場合、検索結果を取得（Entity→DTOに設定）
            // 　　　以下項目をDTOへ設定する。
            // 　　　Cr008_04GetResultDataEntity.貸付先名称　→　DTO.顧客名
            // 　　　Cr008_04GetResultDataEntity.金融機関名称　→　DTO.扱店名
            // 　　　Cr008_04GetResultDataEntity.所管本支店コード　→　DTO.公庫支店コード
            // 　　　Cr008_04GetResultDataEntity.扱店コード　→　DTO.扱店
            // 　　　Cr008_04GetResultDataEntity.店舗コード　→　DTO.店舗
            // 　　　Cr008_04GetResultDataEntity.年度を西暦（YYYY）から和暦（Gyy）へ変換　→　DTO.年度
            // 　　　Cr008_04GetResultDataEntity.方式資金　→　DTO.年度
            // 　　　Cr008_04GetResultDataEntity.番号　→　DTO.番号
            // 　　　Cr008_04GetResultDataEntity.枝番　→　DTO.枝番
            CFWBeanUtils.copyProperties(outDto, outEntity.get(Cr008Constants.INDEX_ZERO));
        }

        // 業務日付取得（共通部品）を呼び、業務日付を取得する。
        String bizDate = pnCommonDBComponents.getPNBusinessDay(1);

        // 業務日付の1月前の日付⇒前月業務日付
        Calendar calBizDate = PNCommonComponents.strToCal(bizDate);
        calBizDate.add(Calendar.MONTH, -1);
        String bizDatePrevMonth = PNCommonComponents.calToStr(calBizDate);

        String[] tmp1 = PNCommonComponents.dateFmtAD_YYYYMMDD(bizDate).split("\\.");
        String[] tmp2 = PNCommonComponents.dateFmtAD_YYYYMMDD(bizDatePrevMonth).split("\\.");

        // 営業日数取得（共通部品）を呼び、業務日付の営業日数を取得する。
        int ordinalBizDate = pnCommonDBComponents.calcOrdinalBizDate(bizDate);

        // 業務日付の元号⇒DTO.業務日付(元号)
        outDto.setLblID_BizDate_Gengo(tmp1[0].substring(0, 1));
        // 業務日付の年⇒DTO.業務日付(年)
        outDto.setLblID_BizDate_Nen(tmp1[0].substring(1));
        // 業務日付の月⇒DTO.業務日付(月)
        outDto.setLblID_BizDate_Tsuki(tmp1[1]);

        // 前月業務日付の元号⇒DTO.前月業務日付(元号)
        outDto.setLblID_BizDate_PrevMonth_Gengo(tmp2[0].substring(0, 1));
        // 前月業務日付の年⇒DTO.前月業務日付(年)
        outDto.setLblID_BizDate_PrevMonth_Nen(tmp2[0].substring(1));
        // 前月業務日付の月⇒DTO.前月業務日付(月)
        outDto.setLblID_BizDate_PrevMonth_Tsuki(tmp2[1]);

        boolean kessankiFlg = pnCommonDBComponents.isKessanki();
        if (kessankiFlg && 1 <= ordinalBizDate &&
                ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI) {
            // 決算期（業務日付が4、10月） かつ 第1～4営業日の場合
            // 　1⇒DTO.受託者勘定処理年月設定モード
            outDto.setLblID_JtkshoriConfigMode(PNCommonConstants.JTKSHORI_CONFIGMODE_1);

        }
        else if (kessankiFlg && PNCommonConstants.ORDINALBIZDATE_BORDER_KESSANKI < ordinalBizDate) {
            // 決算期（業務日付が4、10月） かつ 営業日数が第5営業日以上の場合
            // 　2⇒DTO.受託者勘定処理年月設定モード
            outDto.setLblID_JtkshoriConfigMode(PNCommonConstants.JTKSHORI_CONFIGMODE_2);

        }
        else if (!kessankiFlg && 1 <= ordinalBizDate &&
                ordinalBizDate <= PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI) {

            // 通常期（業務日付が4、10月以外） かつ 営業日数が第11営業日以上 の場合
            // 　3⇒DTO.受託者勘定処理年月設定モード
            outDto.setLblID_JtkshoriConfigMode(PNCommonConstants.JTKSHORI_CONFIGMODE_3);
        }
        else if (!kessankiFlg && PNCommonConstants.ORDINALBIZDATE_BORDER_TSUJOKI < ordinalBizDate) {
            // 通常期（業務日付が4、10月以外） かつ 第1～10営業日の場合
            // 　4⇒DTO.受託者勘定処理年月設定モード
            outDto.setLblID_JtkshoriConfigMode(PNCommonConstants.JTKSHORI_CONFIGMODE_4);

        }

        return outDto;
    }
}