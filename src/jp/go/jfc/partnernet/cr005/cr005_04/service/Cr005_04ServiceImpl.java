//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultDataDAO;
import jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultDataEntity;
import jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportDAO;
import jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportEntity;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはcr005_04のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Cr005_04ServiceImpl extends PNBaseService implements Cr005_04Service {

    /** cr005_04resultdatadao */
    @Autowired
    private Cr005_04ResultDataDAO cr005_04resultdatadao;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** cr005_04resultreportdao */
    @Autowired
    private Cr005_04ResultReportDAO cr005_04resultreportdao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Cr005_04ServiceのgetResultData
     *
     * @param inDto Cr005_04DTO
     * @return Cr005_04DTO
     */
    @Override
    public Cr005_04DTO getResultData(Cr005_04DTO inDto) {

        Cr005_04DTO outDto = new Cr005_04DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        boolean flgGetData = true;

        // 受渡情報の取得

        // 入力画面表示の検索条件を設定
        // 　複数テーブルアクセス定義の「Cr005_04ResultDataDAO」を参照し、条件を設定する。
        // 　※遷移元画面からの受渡情報をそのまま設定する
        // 　※　　遷移元画面がcr004_01の場合、債権管理番号はNULLとなっている。
        // 　※　　遷移元画面がcr004_03の場合、債権管理番号以外はNULLとなっている。
        // 　　・債権管理番号
        // 　　・公庫支店コード
        // 　　・扱店コード
        // 　　・店舗コード
        // 　　・年度
        // 　　・方式資金
        // 　　・番号
        // 　　・枝番
        // 　Cr005_04ResultDataDAO.findByCondition
        Cr005_04ResultDataEntity inEntity = new Cr005_04ResultDataEntity();
        inEntity.setCr005_04_ID_Credit(inDto.getCr005_04_ID_Credit());
        inEntity.setCr005_04_Code_ShokanHonShiten(inDto.getCr005_04_Code_ShokanHonShiten());
        inEntity.setCr005_04_Code_Organization(inDto.getCr005_04_Code_Organization());
        inEntity.setCr005_04_Code_Tenpo(inDto.getCr005_04_Code_Tenpo());

        String seirekiYear = "";
        if (null != inDto.getCr005_04_Year()) {
            seirekiYear = PNCommonComponents.dateFmtJC_Gyy(inDto.getCr005_04_Year());
        }
        inEntity.setCr005_04_Year(seirekiYear);
        inEntity.setCr005_04_Code_HoshikiShikin(inDto.getCr005_04_Code_HoshikiShikin());
        inEntity.setCr005_04_ID_Ringi(inDto.getCr005_04_ID_Ringi());

        inEntity.setCr005_04_ID_RingiBranch("0");
        if (null != inDto.getCr005_04_ID_RingiBranch()) {
            if (0 < inDto.getCr005_04_ID_RingiBranch().length()) {
                inEntity.setCr005_04_ID_RingiBranch(inDto.getCr005_04_ID_RingiBranch());
            }
        }
        List<Cr005_04ResultDataEntity> outEntityList = cr005_04resultdatadao.findByCondition(inEntity);

        int count = outEntityList.size();
        // 検索結果判定
        if (2 <= count) {
            // 　取得件数が２件以上の場合、業務エラーとする
            // 　　エラーメッセージ：PM9010E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        if (0 == count) {
            // 　取得件数が０件の場合、以下の項目をＤＴＯに設定し、以降の処理は行わない。
            // 　　・データ取得フラグにFalseを設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                    new String[] { "条件に一致するデータを取得できませんでした。" }, false));
            outDto.setBizErrors(bizErrors);
            flgGetData = false;
            return outDto;
        }

        // 検索結果を取得(Entity→DTOに設定)
        if (1 == count) {
            // 　取得件数が１件の場合、以下の項目をＤＴＯに設定する。
            // 　　・データ取得フラグにTrueを設定
            flgGetData = true;
            // 　　　　　----------表示項目----------
            Cr005_04ResultDataEntity outEntity = outEntityList.get(0);
            // 　　・貸付先名称を顧客名に設定
            outDto.setTxtID_Name_Customer(outEntity.getName_Customer());
            // 　　・金融機関名称を扱店名に設定
            outDto.setTxtID_Name_Organization(outEntity.getName_Organization());
            // 　　・所管本支店コードを公庫支店に設定
            outDto.setTxtID_Code_ShokanHonShiten(outEntity.getCode_ShokanHonShiten());
            // 　　・扱店コードを扱店に設定
            outDto.setTxtID_Code_Organization(outEntity.getCode_Organization());
            // 　　・店舗コードを店舗に設定
            outDto.setTxtID_Code_Tenpo(outEntity.getCode_Tenpo());
            // 　　・年度を年度に設定　　　　　 (和暦変換後、年の頭０を削除する。H05　→　H5)
            outDto.setTxtID_Year(outEntity.getYear());
            // 　　・方式区分と資金区分を連結し方式資金に設定
            StringBuilder sb = new StringBuilder(PNCommonComponents.cnvNulltoBlank(outEntity
                    .getKubun_Hoshiki()));
            sb.append(outEntity.getKubun_Shikin());
            outDto.setTxtID_Code_HoshikiShikin(sb.toString());
            // 　　・稟議番号を番号に設定
            outDto.setTxtID_ID_Ringi(outEntity.getID_Ringi());
            // 　　・稟議番号枝番を枝番に設定　　　　　　(値が０場合、空文字を設定）
            String ringiBranch = outEntity.getID_RingiBranch();
            if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(ringiBranch)) {
                ringiBranch = "";
            }
            outDto.setTxtID_ID_RingiBranch(ringiBranch);
            // 　　　　　----------非表示項目----------
            // 　　・償還期限年月を償還期限年月に設定
            outDto.setID_Date_ShokanKigen(outEntity.getDate_ShokanKigen());
            // 　　・最新更新日時を最新更新日時に設定
            outDto.setID_Data_LastUpDate(outEntity.getData_LastUpDate());
            // 　　・債権管理番号を債権管理番号に設定
            outDto.setID_Credit(outEntity.getID_Credit());
            // 　　・貸付金残高を貸付金残高に設定
            outDto.setID_M_KashitsukeZandaka(outEntity.getM_KashitsukeZandaka().toString());
        }

        // 先行する報告書の有無をチェックする
        // 　報告書履歴データのレコード有無をチェックする
        // 　単テーブルアクセス定義の「報告書履歴データ 単テーブルアクセスNo.1を参照し、条件を設定する。
        // 　※入力画面表示で取得したデータを設定する。
        boolean flgReport = true;
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        // 　　・公庫支店コード
        inEntity2.setCode_KoukoShiten(outDto.getTxtID_Code_ShokanHonShiten());
        // 　　・扱店コード
        inEntity2.setCode_Organization(outDto.getTxtID_Code_Organization());
        // 　　・店舗コード
        inEntity2.setCode_Tenpo(outDto.getTxtID_Code_Tenpo());
        // 　　・年度　　　　（西暦変換し設定）
        inEntity2.setYear(PNCommonComponents.dateFmtJC_Gyy(outDto.getTxtID_Year()));
        // 　　・方式資金
        inEntity2.setCode_HoshikiShikin(outDto.getTxtID_Code_HoshikiShikin());
        // 　　・番号
        inEntity2.setID_Ringi(outDto.getTxtID_ID_Ringi());
        // 　　・枝番　　　　（値が空文字の場合、０を設定）
        inEntity2.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(outDto.getTxtID_ID_RingiBranch()));
        // 　　・取消済フラグ：０を設定
        inEntity2.setFlag_Torikeshizumi(BigDecimal.ZERO);

        // 　ReportHistoryDAO.countByCondition
        long hitcount = reporthistorydao.countByCondition(inEntity2);

        // 　取得結果の判定
        if (0 == hitcount) {
            // 　　取得件数が０件の場合、先行する報告書の有無を無し（True)に設定する。
            flgReport = true;

        }
        if (1 <= hitcount) {
            // 　　取得件数が１件以上の場合、先行する報告書の有無を有り（False)に設定する。
            flgReport = false;

        }

        // 　先行する報告書有りの場合、先行する報告書名を取得する
        if (false == flgReport) {
            // 　　複数テーブルアクセス定義の「Cr005_04ResultReportDAO」を参照し、条件を設定する。
            Cr005_04ResultReportEntity inEntity3 = new Cr005_04ResultReportEntity();
            // 　　　・公庫支店コード
            inEntity3.setCr005_04_Code_KoukoShiten(outDto.getTxtID_Code_ShokanHonShiten());
            // 　　　・扱店コード
            inEntity3.setCr005_04_Code_Organization(outDto.getTxtID_Code_Organization());
            // 　　　・店舗コード
            inEntity3.setCr005_04_Code_Tenpo(outDto.getTxtID_Code_Tenpo());
            // 　　　・年度　　　　（西暦変換し設定）
            inEntity3.setCr005_04_Year(PNCommonComponents.dateFmtJC_Gyy(outDto.getTxtID_Year()));
            // 　　　・方式資金
            inEntity3.setCr005_04_Code_HoshikiShikin(outDto.getTxtID_Code_HoshikiShikin());
            // 　　　・番号
            inEntity3.setCr005_04_ID_Ringi(outDto.getTxtID_ID_Ringi());
            // 　　　・枝番　　　　（値が空文字の場合、０を設定）
            inEntity3.setCr005_04_ID_RingiBranch(PNCommonComponents.cnvNulltoZero(outDto
                    .getTxtID_ID_RingiBranch()));
            // 　　　・取消済フラグ：０を設定
            inEntity3.setCr005_04_Flag_Torikeshizumi(BigDecimal.ZERO);

            // 　　Cr005_04ResultReportDAO.findByCondition
            List<Cr005_04ResultReportEntity> outEntityList3 = cr005_04resultreportdao
                    .findByCondition(inEntity3);

            // 　　取得結果の判定
            int count3 = outEntityList3.size();

            if (0 == count3) {
                // 　　　取得件数が０件の場合、先行する報告書の有無を無し（True)に設定する。
                bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E,
                        new String[] { "条件に一致するデータを取得できませんでした。" }, false));
                outDto.setBizErrors(bizErrors);
                flgReport = true;
                return outDto;
            }
            if (1 <= count3) {
                // 　　　取得件数が１件以上の場合、以下を行う。
                Cr005_04ResultReportEntity outEntity3 = outEntityList3.get(0);
                if ("2".equals(outEntity3.getStatus())) {
                    // 　　　　取得データの「ステータス」が２の場合、先行する報告書名に、取得した報告書略称名を設定する。
                    outDto.setID_Previous_ReportType(outEntity3.getRyakusyouName_Report());
                } else {
                    // 　　　　取得データの「ステータス」が２以外の場合、以下を行う
                    String outDataCode = outEntity3.getDataCode();
                    if ((PNCommonConstants.DATACODE_90257070.equals(outDataCode))
                            || (PNCommonConstants.DATACODE_90257071.equals(outDataCode))
                            || (PNCommonConstants.DATACODE_90257110.equals(outDataCode))
                            || (PNCommonConstants.DATACODE_90257111.equals(outDataCode))) {
                        // 　　　　　　取得データの「データコード」が以下の場合、先行する報告書名に、取得した報告書略称名を設定する。
                        outDto.setID_Previous_ReportType(outEntity3.getRyakusyouName_Report());
                    } else {
                        // 　　　　　　取得データの「データコード」が以下以外の場合、先行する報告書の有無を無し（True)に設定する。
                        // 　　　　　　　　　　"90257070", "90257071", "90257110",
                        // "90257111"
                        flgReport = true;
                    }
                }
            }
        }

        outDto.setID_Previous_Report(flgReport);

        // 画面表示項目の初期化
        // 　　・充当対象払込期日（年号）（年）（月）（日）の設定
        // 　　　　　・充当対象払込期日（年号）に初期元号を設定
// [UPD] Ver 3.0.0 - START
//        outDto.setDrpID_Date_JutoTaishoGengou("H");
        outDto.setDrpID_Date_JutoTaishoGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        // 　　　　　・充当対象払込期日（年）に空文字を設定
        outDto.setTxtID_Date_JutoTaishoYear("");
        // 　　　　　・充当対象払込期日（月）に空文字を設定
        outDto.setDrpID_Date_JutoTaishoMonth("");
        // 　　　　　・充当対象払込期日（日）に空文字を設定
        outDto.setDrpID_Date_JutoTaishoDay("");

        // 　　・代弁金払込日（年号）（年）（月）（日）の設定
        // 　　　　　・代弁金払込日（年号）に初期元号を設定
// [UPD] Ver 3.0.0 - START
//        outDto.setDrpID_Date_DaibenkinHaraikomiGengou("H");
        outDto.setDrpID_Date_DaibenkinHaraikomiGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        // 　　　　　・代弁金払込日（年）に空文字を設定
        outDto.setTxtID_Date_DaibenkinHaraikomiYear("");
        // 　　　　　・代弁金払込日（月）に空文字を設定
        outDto.setDrpID_Date_DaibenkinHaraikomiMonth("");
        // 　　　　　・代弁金払込日（日）に空文字を設定
        outDto.setDrpID_Date_DaibenkinHaraikomiDay("");

        // 　　・受託者勘定処理年月（年号）（年）（月）の設定
        // 　　　　　・受託者勘定処理年月（年号）に初期元号を設定
// [UPD] Ver 3.0.0 - START
//        outDto.setDrpID_Date_JtkshoriGengou("H");
        outDto.setDrpID_Date_JtkshoriGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        // 　　　　　・受託者勘定処理年月（年）に空文字を設定
        outDto.setTxtID_Date_JtkshoriYear("");
        // 　　　　　・受託者勘定処理年月（月）に空文字を設定
        outDto.setDrpID_Date_JtkshoriMonth("");

        // 　　・送金日（年号）（年）（月）（日）の設定
        // 　　　　　・送金日（年号）に初期元号を設定
// [UPD] Ver 3.0.0 - START
//        outDto.setDrpID_Date_SokinGengou("H");
        outDto.setDrpID_Date_SokinGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 3.0.0 - END
        // 　　　　　・送金日（年）に空文字を設定
        outDto.setTxtID_Date_SokinYear("");
        // 　　　　　・送金日（月）に空文字を設定
        outDto.setDrpID_Date_SokinMonth("");
        // 　　　　　・送金日（日）に空文字を設定
        outDto.setDrpID_Date_SokinDay("");

        outDto.setTxtID_M_Kei("");

        outDto.setTxtID_M_Sokin("");

        outDto.setTxtID_M_ZanGanAfterDaibenJuto("");

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

    /**
     * Cr005_04ServiceのgetSeikyuData
     *
     * @param inDto Cr005_04DTO
     * @return Cr005_04DTO
     */
    @Override
    public Cr005_04DTO getSeikyuData(Cr005_04DTO inDto) {

        Cr005_04DTO outDto = new Cr005_04DTO();

        // サービスを実行し請求データ取得を行う。
        // 　単テーブルアクセス定義の「請求データ 単テーブルアクセスNo.1」を参照し、条件を設定する。
        // 　　　　　・債権管理番号：債権管理番号
        // 　　　　　・払込年月日：請求検索日付
        // 　　SeikyuDAO.findByCondition
        SeikyuEntity inEntity = new SeikyuEntity();
        BigDecimal bCredit = new BigDecimal(inDto.getID_Credit());
        inEntity.setID_Credit(bCredit);
        inEntity.setDate_Haraikomi(inDto.getID_Date_SearchSeikyu());
        List<SeikyuEntity> outEntityList = seikyudao.findByCondition(inEntity);

        // 取得件数をＤＴＯの請求検索結果・取得件数に設定する。
        int count = outEntityList.size();
        outDto.setID_SeikyuCount(count);

        if (1 == count) {
            // 取得した請求データ件数が１件の場合、以下の処理を行う。
            // 　　　　検索結果を取得(Entity→DTOに設定)
            SeikyuEntity outEntity = outEntityList.get(0);
            // 　　　　　・約定元金を請求検索結果・約定元金へ設定
            outDto.setID_M_YakujoGankin_SeikyuAns(outEntity.getM_YakujoGankin().toString());
            // 　　　　　・約定利息を請求検索結果・約定利息へ設定
            outDto.setID_M_YakujoRisoku_SeikyuAns(outEntity.getM_YakujoRisoku().toString());
            // 　　　　　・請求繰上償還元金を請求検索結果・請求繰上償還元金へ設定
            outDto.setID_M_SeiKuriGankin_SeikyuAns(outEntity.getM_SeiKuriGankin().toString());
            // 　　　　　・請求繰上償還利息を請求検索結果・請求繰上償還利息へ設定
            outDto.setID_M_SeiKuriRisoku_SeikyuAns(outEntity.getM_SeiKuriRisoku().toString());
        }

        return outDto;
    }

}