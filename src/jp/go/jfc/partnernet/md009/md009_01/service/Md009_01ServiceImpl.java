//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md009_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 松井　元気            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md009.md009_01.service;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.md009.md009_01.dao.Md009_01ResultsDataDAO;
import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.KoukoshitenDAO;
import jp.go.jfc.partnernet.common.dao.TenpoDAO;
import jp.go.jfc.partnernet.md009.md009_01.dao.Md009_01ResultsDataEntity;
import jp.go.jfc.partnernet.common.dao.KoukoshitenEntity;
import jp.go.jfc.partnernet.common.dao.TenpoEntity;

/**
 * <pre>
 * このクラスはMd009_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md009_01ServiceImpl extends PNBaseService implements Md009_01Service {

    /** md009_01resultsdatadao */
    @Autowired
    private Md009_01ResultsDataDAO md009_01resultsdatadao;

    /** koukoshitendao */
    @Autowired
    private KoukoshitenDAO koukoshitendao;

    /** tenpodao */
    @Autowired
    private TenpoDAO tenpodao;

    /** CFWJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /**
     * Md009_01ServiceのgetResultsData
     *
     * @param inDto Md009_01DTO
     * @return Md009_01DTO
     */
    @Override
    public Md009_01DTO getResultsData(Md009_01DTO inDto) {

        Md009_01DTO outDto = new Md009_01DTO();
        Md009_01ResultsDataEntity inEntity = new Md009_01ResultsDataEntity();

        String processMode = inDto.getProcessMode();

        // 留置期間利息・代弁遅延損害金受入充当報告書データの取得
        // DAOへのパラメータに検索条件を設定（Md009_01ResultsDataEntity)
        // ・DTO.報告書番号　⇒　Md009_01ResultsDataEntity.報告書番号
        inEntity.setID_Report(inDto.getID_Report());
        // ・DTO.扱店　　　　⇒　Md009_01ResultsDataEntity.機関コード
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());

        // 複数テーブルアクセス定義の「Md009_01ResultsDataDAO」を実行し、留置期間利息・代弁遅延損害金受入充当報告書データを取得する。
        List<Md009_01ResultsDataEntity> outEntity = md009_01resultsdatadao.findByCondition(inEntity);

        // 検索結果のレコード件数を設定
        outDto.setRecCount(outEntity.size());

        if (PNCommonConstants.RECORD_COUNT_ONE == outEntity.size()) {
            // EntityよりDTOに設定（Entity→outDto)
            // 更正(赤)用画面情報の場合
            Md009_01ResultsDataEntity dataEntity = outEntity.get(0);
            if (PNCommonConstants.PROCESSMODE_PROCEND_DEL.equals(processMode)
                    || PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)
                    || PNCommonConstants.PROCESSMODE_NOT_PROCEND_DEL.equals(processMode)) {

                // 入金日を和暦に変換して設定する。
                String warekiNyukinRed = PNCommonComponents.dateFmtAD_YYYYMMDD(dataEntity.getDate_Nyukin());

                // 受託者勘定処理年月を和暦に変換して設定する。
                String warekitkshoriRed = PNCommonComponents.dateFmtAD_YYYYMM(dataEntity.getDate_Jtkshori());

                // 送金日を和暦に変換して設定する。
                String warekiSokinRed = PNCommonComponents.dateFmtAD_YYYYMMDD(dataEntity.getDate_Sokin());

                // ・Md009_01ResultsDataEntity.扱店名　　　　　　　　⇒　DTO.扱店名
                outDto.setTxtID_Name_Organization_Red(dataEntity.getName_Organization());
                // ・Md009_01ResultsDataEntity.公庫支店　　　　　　　⇒　DTO.公庫支店
                outDto.setTxtID_Code_ShokanHonShiten_Red(dataEntity.getCode_ShokanHonShiten());
                // ・Md009_01ResultsDataEntity.扱店　　　　　　　　　⇒　DTO.扱店
                outDto.setTxtID_Code_Organization_Red(dataEntity.getCode_Organization());
                // ・Md009_01ResultsDataEntity.店舗　　　　　　　　　⇒　DTO.店舗
                outDto.setTxtID_Code_Tenpo_Red(dataEntity.getCode_Tenpo());
                // ・Md009_01ResultsDataEntity.入金日　　　　　　　　⇒　DTO.入金日
                outDto.setTxtID_Date_Nyukin_Red(warekiNyukinRed);
                // ・Md009_01ResultsDataEntity.留置期間利息　　　　　⇒　DTO.留置期間利息
                outDto.setTxtID_M_RyuchiKikanRisoku_Red(dataEntity.getM_RyuchiKikanRisoku());
                // ・Md009_01ResultsDataEntity.代弁遅延損害金　　　　⇒　DTO.代弁遅延損害金
                outDto.setTxtID_M_DaibenChienSongai_Red(dataEntity.getM_DaibenChienSongai());
                // ・Md009_01ResultsDataEntity.送金額　　　　　　　　⇒　DTO.送金額
                outDto.setTxtID_M_Sokin_Red(dataEntity.getM_Sokin());
                // ・Md009_01ResultsDataEntity.受託者勘定処理年月　　⇒　DTO.受託者勘定処理年月
                outDto.setTxtID_Date_Jtkshori_Red(warekitkshoriRed);
                // ・Md009_01ResultsDataEntity.送金日　　　　　　　　⇒　DTO.送金日
                outDto.setTxtID_Date_Sokin_Red(warekiSokinRed);
                // ・Md009_01ResultsDataEntity.送金日番号　　　　　　⇒　DTO.送金日番号
                outDto.setTxtID_Code_Sokin_Red(dataEntity.getID_Sokinbi());
// [ADD] Ver 2.0.0 - START
                // ・初期元号　　　　　　⇒　DTO.受託者勘定処理年月（元号）
                outDto.setDrpID_Date_Jtkshori_Gengou_Red(PNCommonComponents.getInitgengo());
// [ADD] Ver 2.0.0 - END
            }

            // 更正(黒)用画面情報の場合
            if (PNCommonConstants.PROCESSMODE_PROCEND_MOD.equals(processMode)
                    || PNCommonConstants.PROCESSMODE_NOT_PROCEND_MOD.equals(processMode)) {

                // 入金日を和暦に変換して設定する。
                String[] warekiNyukin = jpCalendarUtils.toWareki(dataEntity.getDate_Nyukin());

                // 受託者勘定処理年月を和暦に変換して設定する。
                String warekitkshori = PNCommonComponents.dateFmtAD_YYYYMM(dataEntity.getDate_Jtkshori());

                // 送金日を和暦に変換して設定する。
                String[] warekiSokin = jpCalendarUtils.toWareki(dataEntity.getDate_Sokin());

                // ・Md009_01ResultsDataEntity.扱店名　　　　　　　　⇒　DTO.扱店名（修正）
                outDto.setTxtID_Name_Organization(dataEntity.getName_Organization());
                // ・Md009_01ResultsDataEntity.公庫支店　　　　　　　⇒　DTO.公庫支店（修正）
                outDto.setTxtID_Code_ShokanHonShiten(dataEntity.getCode_ShokanHonShiten());
                // ・Md009_01ResultsDataEntity.扱店　　　　　　　　　⇒　DTO.扱店（修正）
                outDto.setTxtID_Code_Organization(dataEntity.getCode_Organization());
                // ・Md009_01ResultsDataEntity.店舗　　　　　　　　　⇒　DTO.店舗（修正）
                outDto.setTxtID_Code_Tenpo(dataEntity.getCode_Tenpo());
                // ・Md009_01ResultsDataEntity.入金日　　　　　　　　⇒　DTO.入金日（元号）（修正）
                outDto.setDrpID_Date_Nyukin_Gengou(warekiNyukin[0]);
                // ・Md009_01ResultsDataEntity.入金日　　　　　　　　⇒　DTO.入金日（年）（修正）
                outDto.setTxtID_Date_Nyukin_Year_Input(warekiNyukin[1]);
                // ・Md009_01ResultsDataEntity.入金日　　　　　　　　⇒　DTO.入金日（月）（修正）
                outDto.setDrpID_Date_Nyukin_Month(PNFormatUtils.toZeroSuppress(warekiNyukin[2]));
                // ・Md009_01ResultsDataEntity.入金日　　　　　　　　⇒　DTO.入金日（日）（修正）
                outDto.setDrpID_Date_Nyukin_Day(PNFormatUtils.toZeroSuppress(warekiNyukin[3]));
                // ・Md009_01ResultsDataEntity.留置期間利息　　　　　⇒　DTO.留置期間利息（修正）
                outDto.setTxtID_M_RyuchiKikanRisoku(dataEntity.getM_RyuchiKikanRisoku());
                // ・Md009_01ResultsDataEntity.代弁遅延損害金　　　　⇒　DTO.代弁遅延損害金（修正）
                outDto.setTxtID_M_DaibenChienSongai(dataEntity.getM_DaibenChienSongai());
                // ・Md009_01ResultsDataEntity.送金額　　　　　　　　⇒　DTO.送金額（修正）
                outDto.setTxtID_M_Sokin(dataEntity.getM_Sokin());
                // ・Md009_01ResultsDataEntity.受託者勘定処理年月　　⇒　DTO.受託者勘定処理年月（修正）
                outDto.setTxtID_Date_Jtkshori(warekitkshori);
                // ・Md009_01ResultsDataEntity.送金日　　　　　　　　⇒　DTO.送金日（元号）（修正）
                outDto.setDrpID_Date_Sokin_Gengou(warekiSokin[0]);
                // ・Md009_01ResultsDataEntity.送金日　　　　　　　　⇒　DTO.送金日（年）（修正）
                outDto.setTxtID_Date_Sokin_Year_Input(warekiSokin[1]);
                // ・Md009_01ResultsDataEntity.送金日　　　　　　　　⇒　DTO.送金日（月）（修正）
                outDto.setDrpID_Date_Sokin_Month(PNFormatUtils.toZeroSuppress(warekiSokin[2]));
                // ・Md009_01ResultsDataEntity.送金日　　　　　　　　⇒　DTO.送金日（日）（修正）
                outDto.setDrpID_Date_Sokin_Day(PNFormatUtils.toZeroSuppress(warekiSokin[3]));
                // ・Md009_01ResultsDataEntity.送金日番号　　　　　　⇒　DTO.送金日番号（修正）
                outDto.setTxtID_Code_Sokin(dataEntity.getID_Sokinbi());
// [ADD] Ver 2.0.0 - START
                // ・初期元号　　　　　　⇒　DTO.受託者勘定処理年月（元号）（修正）
                outDto.setDrpID_Date_Jtkshori_Gengou(PNCommonComponents.getInitgengo());
// [ADD] Ver 2.0.0 - END

            }

            outDto.setID_Report(dataEntity.getID_Report());
            outDto.setID_History(dataEntity.getID_History());
            outDto.setID_Status(dataEntity.getStatus());
            outDto.setID_DataCode(dataEntity.getDataCode());
            outDto.setID_Type_Process(dataEntity.getType_Process());
            outDto.setID_Data_LastUpDate(dataEntity.getData_LastUpDate());
        }

        return outDto;
    }

    /**
     * Md009_01ServiceのgetKoukoShiten
     *
     * @param inDto Md009_01DTO
     * @return Md009_01DTO
     */
    @Override
    public Md009_01DTO getKoukoShiten(Md009_01DTO inDto) {

        Md009_01DTO outDto = new Md009_01DTO();

        // 公庫支店の存在チェック
        // DAOへのパラメータに検索条件を設定
        // ・DTO.公庫支店 ⇒ KoukoshitenEntity.公庫支店コード
        // KoukoShitenEntity inEntity = new KoukoShitenEntity();
        KoukoshitenEntity inEntity = new KoukoshitenEntity();
        inEntity.setCode_KoukoShiten(inDto.getTxtID_Code_ShokanHonShiten());

        // 単テーブルアクセス定義の「公庫支店名テーブルのNo3.　公庫支店件数取得」を参照し、件数を取得する。
        // KoukoshitenDAO.countByCondition
        // long hitcount = koukoshitendao.countByCondition(inEntity);
        long hitCount = koukoshitendao.countByCondition(inEntity);

        // ■取得件数　＜　1　の場合
        if (PNCommonConstants.RECORD_COUNT_ONE > hitCount) {
            throw new PNServiceException(PNCommonMessageConstants.PM9061E, new String[]{"公庫支店の"}, false);
        }

        return outDto;
    }

    /**
     * Md009_01ServiceのgetTenpo
     *
     * @param inDto Md009_01DTO
     * @return Md009_01DTO
     */
    @Override
    public Md009_01DTO getTenpo(Md009_01DTO inDto) {

        Md009_01DTO outDto = new Md009_01DTO();

        // 店舗の存在チェック
        // DAOへのパラメータに検索条件を設定
        // TenpoEntity inEntity = new TenpoEntity();
        // ・DTO.店舗 ⇒ TenpoEntity.店舗コード
        // ・ログインユーザの扱点 ⇒ TenpoEntity.扱店
        TenpoEntity inEntity = new TenpoEntity();
        inEntity.setCode_Tenpo(inDto.getTxtID_Code_Tenpo());
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity.setCode_Organization(pnCommonInfo.getCode_Organization());

        // 単テーブルアクセス定義の「金融機関店舗データのNo2. 店舗件数取得」を実行し、件数を取得する。
        // TenpoDAO.countByCondition
        // long hitcount = tenpodao.countByCondition(inEntity);
        long hitCount = tenpodao.countByCondition(inEntity);

        // ■取得件数　＜　1　の場合
        if (PNCommonConstants.RECORD_COUNT_ONE > hitCount) {
            throw new PNServiceException(PNCommonMessageConstants.PM9061E, new String[]{"店舗の"}, false);
        }

        return outDto;
    }

}