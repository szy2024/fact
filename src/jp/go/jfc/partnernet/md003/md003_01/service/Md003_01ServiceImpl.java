//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md003_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/28 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md003.md003_01.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AcustomerDAO;
import jp.go.jfc.partnernet.common.dao.AcustomerEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.common.dao.TenpoDAO;
import jp.go.jfc.partnernet.common.dao.TenpoEntity;
import jp.go.jfc.partnernet.common.dao.YakujoDAO;
import jp.go.jfc.partnernet.common.dao.YakujoEntity;
import jp.go.jfc.partnernet.md003.common.Md003Constants;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01ResultsDataDAO;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01ResultsDataEntity;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01SeikyuCountDAO;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01SeikyuCountEntity;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01SeikyuYakujoGankinDAO;
import jp.go.jfc.partnernet.md003.md003_01.dao.Md003_01SeikyuYakujoGankinEntity;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWFindParameterException;

/**
 * <pre>
 * このクラスはmd003_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md003_01ServiceImpl extends PNBaseService implements Md003_01Service {

    /** md003_01resultsdatadao */
    @Autowired
    private Md003_01ResultsDataDAO md003_01resultsdatadao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** yakujodao */
    @Autowired
    private YakujoDAO yakujodao;

    /** md003_01seikyuyakujogankindao */
    @Autowired
    private Md003_01SeikyuYakujoGankinDAO md003_01seikyuyakujogankindao;

    /** md003_01seikyuseikyucountdao */
    @Autowired
    private Md003_01SeikyuCountDAO md003_01seikyucountdao;

    /** acustomerdao */
    @Autowired
    private AcustomerDAO acustomerdao;

    /** tenpodao */
    @Autowired
    private TenpoDAO tenpodao;

    /**
     * Md003_01ServiceのgetResultsData
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getResultsData(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 受渡情報の取得

        // 一覧画面データの取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Md003_01ResultsDataDAO」を参照し、条件を設定する。
        // 　Md003_01ResultsDataDAO.findByCondition
        Md003_01ResultsDataEntity inEntity = new Md003_01ResultsDataEntity();
        inEntity.setID_Report(inDto.getID_ID_Report());

        List<Md003_01ResultsDataEntity> outEntityList = md003_01resultsdatadao.findByCondition(inEntity);

        long count = md003_01resultsdatadao.countByCondition(inEntity);
        // 　取得したデータが２件以上の場合、業務エラーとする。
        // 　　エラーメッセージ：PM9010E
        // 　取得したデータの件数＝０の場合、業務エラーとする。
        // 　　エラーメッセージ：PM9060E
        if (0 == count) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0]));
        } else if (1 < count) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
        }
        // エラー判定
        if (0 < bizErrors.size()) {
            // エラーがある場合はエラー情報をコントローラーに返す
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // Entity⇒DTOに転記
        // 受渡情報の処理モードにより、画面情報の設定項目が決まる。
        if (Md003Constants.PROCESS_MODE_2.equals(inDto.getProcessMode())
                || Md003Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {

            // 　更正(黒)用画面情報の場合
            // 　　Md003_01Entity.報告年月日⇒Md003_01DTO.報告年月日
            outDto.setID_Date_Report(outEntityList.get(0).getID_Date_Report());
            // 　　Md003_01Entity.顧客名⇒Md003_01DTO.顧客名(修正)
            outDto.setTxtID_Name_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Name_Customer()));
            // 　　Md003_01Entity.扱店名⇒Md003_01DTO.扱店名(修正)
            outDto.setTxtID_Name_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Name_Organization()));
            // 　　Md003_01Entity.公庫支店⇒Md003_01DTO.公庫支店(修正)
            outDto.setTxtID_Code_KoukoShiten(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_KoukoShiten()));
            // 　　Md003_01Entity.扱店⇒Md003_01DTO.扱店(修正)
            outDto.setTxtID_Code_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_Organization()));
            // 　　Md003_01Entity.店舗⇒Md003_01DTO.店舗(修正)
            outDto.setTxtID_Code_Tenpo(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_Tenpo()));
            // 　　和暦に変換して設定する
            // 　　　Md003_01Entity.年度⇒Md003_01DTO.年度(修正)
            outDto.setTxtID_Year(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
            // 　　Md003_01Entity.方式資金⇒Md003_01DTO.方式資金(修正)
            outDto.setTxtID_Code_HoshikiShikin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_HoshikiShikin()));
            // 　　Md003_01Entity.番号⇒Md003_01DTO.番号(修正)
            outDto.setTxtID_ID_Ringi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
            // 　　Md003_01Entity.枝番が0の場合、空白⇒Md003_01DTO.枝番(修正)
            // 　　　上記以外の場合、Md003_01Entity.枝番⇒Md003_01DTO.枝番(修正)
            String ringiBranch = "";
            if (false == "0".equals(outEntityList.get(0).getID_ID_RingiBranch())) {
                ringiBranch = outEntityList.get(0).getID_ID_RingiBranch();
            }
            outDto.setTxtID_ID_RingiBranch(ringiBranch);
            // 　　和暦に変換して設定する
            // 　　　Md003_01Entity.貸付実行日⇒Md003_01DTO.貸付実行日(修正)
            outDto.setTxtID_Date_kashitsukeJikko(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_kashitsukeJikko()));
            // 　　Md003_01Entity.貸付金額⇒Md003_01DTO.貸付金額(修正)
            outDto.setTxtID_M_Kashitsuke(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_Kashitsuke()).toString());
            // 資金使途
            outDto.setTxtID_Code_ShikinShito(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_ShikinShito()));
            // 事業別
            outDto.setTxtID_Code_Jigyobetsu(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_Jigyobetsu()));
            // 　　１０００で割った値を設定する
            // 　　　Md003_01Entity.利率(%)⇒Md003_01DTO.利率(%)(修正)
            outDto.setTxtID_Riritsu(PNCommonComponents.mathPercent1000(outEntityList.get(0).getID_Riritsu()));
            // 　　Md003_01Entity.特利区分⇒Md003_01DTO.特利区分(修正)
            outDto.setTxtID_Kubun_Tokuri(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_TokuriKubun()));
            // 　　１０００で割った値を設定する
            // 　　　Md003_01Entity.特利(%)⇒Md003_01DTO.特利(%)(修正)
            outDto.setTxtID_Tokuri(PNCommonComponents.mathPercent1000(outEntityList.get(0).getID_Tokuri()));
            // 　　Md003_01Entity.償還方法⇒Md003_01DTO.償還方法(修正)
            outDto.setTxtID_Code_Shokan(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_Shokan()));
            // 　　和暦に変換して設定する
            // 　　　Md003_01Entity.据置期限⇒Md003_01DTO.据置期限(修正)
            outDto.setTxtID_Date_SueokiKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_SueokiKigen()));
            // 　　　Md003_01Entity.償還期限⇒Md003_01DTO.償還期限(修正)
            outDto.setTxtID_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_ShokanKigen()));
            // 　　Md003_01Entity.元利金払込日⇒Md003_01DTO.元利金払込日(修正)
            outDto.setTxtID_Date_GanrikinHaraikomi(PNCommonComponents.dateFmtAD_MMDD(outEntityList.get(0)
                    .getID_Date_GanrikinHaraikomi()));
            // 　　Md003_01Entity.元利又は元金均等額⇒Md003_01DTO.元利又は元金均等額(円)(修正)
            outDto.setTxtID_M_GankinKinto(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_GankinKinto()).toString());
            // 　　Md003_01Entity.払込前残元金⇒Md003_01DTO.払込前残元金 (円)(修正)
            outDto.setTxtID_M_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_KashitsukeZandaka()).toString());
            // 　　和暦に変換して設定する
            // 　　　Md003_01Entity.払込期日⇒Md003_01DTO.払込期日(修正)
            outDto.setTxtID_Date_Haraikomi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_Haraikomi()));
            // 　　Md003_01Entity.払込額⇒Md003_01DTO.払込額(円)(修正)
            outDto.setTxtID_M_Haraikomi(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_Haraikomi()).toString());
            // 　　Md003_01Entity.控除利息⇒Md003_01DTO.控除利息(円)(修正)
            outDto.setTxtID_M_KojoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_KojoRisoku()).toString());
            // 入力の控除利息
            outDto.setID_Input_M_KojoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_KojoRisoku()).toString());

// [ADD] Ver 2.0.0 - START
            // 　　　初期元号⇒Md003_01DTO.入金日(元号)(修正)
            outDto.setID_Date_Nyukin_Gengo(PNCommonComponents.getInitgengo());
            // 　　　空文字⇒Md003_01DTO.入金日(年)(修正)
            outDto.setID_Date_Nyukin_Nen(null);
            // 　　　空文字⇒Md003_01DTO.入金日(月)(修正)
            outDto.setDrpID_Date_NyukinTsuki(null);
            // 　　　空文字⇒Md003_01DTO.入金日(日)(修正)
            outDto.setDrpID_Date_NyukinBi(null);
// [ADD] Ver 2.0.0 - END
            // 　　元号、年、月、日に分割し、和暦に変換して設定する
            StringBuffer sbDate_Nyukin = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList
                    .get(0).getID_Date_Nyukin()));
            if (8 == sbDate_Nyukin.length()) {
                String warekiNyukin = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                        .dateFmtAD_YYYYMMDD(sbDate_Nyukin.toString()));
                if (0 < warekiNyukin.length()) {
                    String[] tmp = warekiNyukin.split("\\.");
                    if (0 < tmp.length) {
                        // 　　　Md003_01Entity.入金日⇒Md003_01DTO.入金日(元号)(修正)
                        outDto.setID_Date_Nyukin_Gengo(tmp[0].substring(0, 1));
                        // 　　　Md003_01Entity.入金日⇒Md003_01DTO.入金日(年)(修正)
                        outDto.setID_Date_Nyukin_Nen(tmp[0].substring(1));
                        // 　　　Md003_01Entity.入金日⇒Md003_01DTO.入金日(月)(修正)
                        outDto.setDrpID_Date_NyukinTsuki(tmp[1]);
                        // 　　　Md003_01Entity.入金日⇒Md003_01DTO.入金日(日)(修正)
                        outDto.setDrpID_Date_NyukinBi(tmp[2]);
                    }
                }
            }
            // 　　Md003_01Entity.約定利息⇒Md003_01DTO.約定利息(円)(修正)
            outDto.setTxtID_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoRisoku()).toString());
            // 入力の約定利息
            outDto.setID_Input_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoRisoku()).toString());
            // 約定利息　ＤＢ取得値
            outDto.setID_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoRisoku()).toString());
            // 　　Md003_01Entity.約定元金⇒Md003_01DTO.約定元金(円)(修正)
            outDto.setTxtID_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoGankin()).toString());
            // 入力の約定元金
            outDto.setID_Input_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoGankin()).toString());
            // 約定元金　ＤＢ取得値
            outDto.setID_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_YakujoGankin()).toString());
            // 　　Md003_01Entity.遅延損害金⇒Md003_01DTO.遅延損害金(円)(修正)
            outDto.setTxtID_M_ChienSongai(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_ChienSongai()).toString());
            // 　　Md003_01Entity.違約金⇒Md003_01DTO.違約金(円)(修正)
            outDto.setTxtID_M_Iyaku(PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_Iyaku())
                    .toString());
            // 　　Md003_01Entity.違約金（利子軽減分）⇒Md003_01DTO.違約金（利子軽減分）(円)(修正)
            outDto.setTxtID_M_IyakuRishikeigen(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_IyakuRishikeigen()).toString());
            // 　　Md003_01Entity.仮受金からの充当額⇒Md003_01DTO.仮受金からの充当額(円)(修正)
            if ("0".equals(PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_KariukeIppanJuto())
                    .toString())) {
                outDto.setTxtID_M_KariukeIppanJuto(PNCommonConstants.LITERAL_BLANK);
            } else {
                outDto.setTxtID_M_KariukeIppanJuto(PNCommonComponents.cnvNulltoZero(
                        outEntityList.get(0).getID_M_KariukeIppanJuto()).toString());
            }
            // 　　Md003_01Entity.差引払込額⇒Md003_01DTO.差引払込額(円)(修正)
            outDto.setTxtID_M_SashihikiHaraikomi(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_SashihikiHaraikomi()).toString());
            // 　　Md003_01Entity.払込後残元金⇒Md003_01DTO.払込後残元金(円)(修正)
            outDto.setTxtID_M_ZangankinAfterHaraikomi(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_ZangankinAfterHaraikomi()).toString());
            // 　　和暦に変換して設定する
            // 　　　Md003_01Entity.受託者勘定処理年月⇒Md003_01DTO.受託者勘定処理年月(修正)
            outDto.setTxtID_Date_Jtkshori(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_Jtkshori()));
// [ADD] Ver 2.0.0 - START
            // 　　　初期元号⇒Md003_01DTO.送金日(元号)(修正)
            outDto.setID_Date_Sokin_Gengo(PNCommonComponents.getInitgengo());
            // 　　　空文字⇒Md003_01DTO.送金日(年)(修正)
            outDto.setID_Date_Sokin_Nen(null);
            // 　　　空文字⇒Md003_01DTO.送金日(月)(修正)
            outDto.setDrpID_Date_SokinTsuki(null);
            // 　　　空文字⇒Md003_01DTO.送金日(日)(修正)
            outDto.setDrpID_Date_SokinBi(null);
// [ADD] Ver 2.0.0 - END
            // 　　元号、年、月、日に分割し、和暦に変換して設定する
            StringBuffer sbDate_Sokin = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(
                    0).getID_Date_Sokin()));
            if (8 == sbDate_Sokin.length()) {
                String warekiSokin = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                        .dateFmtAD_YYYYMMDD(sbDate_Sokin.toString()));
                if (0 < warekiSokin.length()) {
                    String[] tmp = warekiSokin.split("\\.");
                    if (0 < tmp.length) {
                        // 　　　Md003_01Entity.送金日⇒Md003_01DTO.送金日(元号)(修正)
                        outDto.setID_Date_Sokin_Gengo(tmp[0].substring(0, 1));
                        // 　　　Md003_01Entity.送金日⇒Md003_01DTO.送金日(年)(修正)
                        outDto.setID_Date_Sokin_Nen(tmp[0].substring(1));
                        // 　　　Md003_01Entity.送金日⇒Md003_01DTO.送金日(月)(修正)
                        outDto.setDrpID_Date_SokinTsuki(tmp[1]);
                        // 　　　Md003_01Entity.送金日⇒Md003_01DTO.送金日(日)(修正)
                        outDto.setDrpID_Date_SokinBi(tmp[2]);
                    }
                }
            }
            // 　　Md003_01Entity.送金日番号⇒Md003_01DTO.送金日番号(修正)
            outDto.setTxtID_ID_Sokinbi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_ID_Sokinbi()));
            // 　　Md003_01Entity.報告書番号⇒Md003_01DTO.報告書番号(修正)
            outDto.setID_ID_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
            // 　　Md003_01Entity.報告時分秒⇒Md003_01DTO.報告時分秒(修正)
            outDto.setID_Time_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Time_Report()));
            // 　　Md003_01Entity.ユーザID⇒Md003_01DTO.ユーザID(修正)
            outDto.setID_User_ID(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_User_ID()));
            // 　　Md003_01Entity.伝送番号⇒Md003_01DTO.伝送番号(修正)
            outDto.setID_ID_Denso(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
            // 　　Md003_01Entity.データコード⇒Md003_01DTO.データコード(修正)
            outDto.setID_DataCode(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_DataCode()));
            // 　　Md003_01Entity.残高件数⇒Md003_01DTO.残高件数(修正)
            outDto.setID_Count_Zandaka(outEntityList.get(0).getID_Count_Zandaka().toString());
            // 　　Md003_01Entity.履歴番号⇒Md003_01DTO.履歴番号(修正)
            outDto.setID_ID_History(PNCommonComponents
                    .cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
            // 　　Md003_01Entity.ステータス⇒Md003_01DTO.ステータス(修正)
            outDto.setID_Status(outEntityList.get(0).getID_Status().toString());
            // 　　Md003_01Entity.処理種別⇒Md003_01DTO.処理種別(修正)
            outDto.setID_Type_Process(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Type_Process()));
            // 　　Md003_01Entity.取消済フラグ⇒Md003_01DTO.取消済フラグ(修正)
            outDto.setID_Flag_Torikeshizumi(outEntityList.get(0).getID_Flag_Torikeshizumi().toString());
            // 　　Md003_01Entity.エラー番号⇒Md003_01DTO.エラー番号(修正)
            outDto.setID_Code_Error(PNCommonComponents
                    .cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
            // 　　Md003_01Entity.エラーメッセージ⇒Md003_01DTO.エラーメッセージ(修正)
            outDto.setID_ErrorMessage(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_ErrorMessage()));
            // 　　Md003_01Entity.退避貸付金残高⇒Md003_01DTO.退避貸付金残高(修正)
            outDto.setID_Keep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_Keep_M_KashitsukeZan()).toString());
            // 　　Md003_01Entity.退避約定元金⇒Md003_01DTO.退避約定元金(修正)
            outDto.setID_Keep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_Keep_M_YakujoGankin()).toString());
            // 　　Md003_01Entity.退避約定利息⇒Md003_01DTO.退避約定利息(修正)
            outDto.setID_Keep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_Keep_M_YakujoRisoku()).toString());
            // 　　Md003_01Entity.退避償還期限⇒Md003_01DTO.退避償還期限(修正)
            outDto.setID_Keep_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_Date_ShokanKigen()));
            // 　　Md003_01Entity.債権管理番号⇒Md003_01DTO.債権管理番号(修正)
            if (null != outEntityList.get(0).getID_ID_Credit()) {
                outDto.setID_ID_Credit(outEntityList.get(0).getID_ID_Credit().toString());
            } else {
                outDto.setID_ID_Credit(PNCommonConstants.LITERAL_BLANK);
            }

            // 　　Md003_01Entity.顧客コード⇒Md003_01DTO.顧客コード(修正)
            outDto.setID_Code_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Code_Customer()));
            // 　　Md003_01Entity.充当順序変更区分⇒Md003_01DTO.充当順序変更区分(修正)
            outDto.setID_Kubun_JutoJunjoHenko(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getKubun_JutoJunjoHenko()));
            // 　　Md003_01Entity.請求データの退避任意繰償還利息⇒Md003_01DTO.請求データの退避任意繰償還利息(修正)
            outDto.setID_Keep_Seikyu_M_NinKuriRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getKeep_Seikyu_M_NinKuriRisoku()).toString());
            // 　　Md003_01Entity.請求データの退避請求繰償還利息⇒Md003_01DTO.請求データの退避請求繰償還利息(修正)
            outDto.setID_Keep_Seikyu_M_SeiKuriRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getKeep_Seikyu_M_SeiKuriRisoku()).toString());
            // 　　Md003_01Entity.請求データの退避請求繰償還元金⇒Md003_01DTO.請求データの退避請求繰償還元金(修正)
            outDto.setID_Keep_Seikyu_M_SeiKuriGankin(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getKeep_Seikyu_M_SeiKuriGankin()).toString());
            // 　　Md003_01Entity.約定データの退避請求繰償還利息⇒Md003_01DTO.約定データの退避請求繰償還利息(修正)
            outDto.setID_Keep_Yakujo_M_SeiKuriRisoku(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getKeep_Yakujo_M_SeiKuriRisoku()).toString());
            // 　　Md003_01Entity.元利金計⇒Md003_01DTO.元利金計(修正)
            outDto.setID_M_GanrikinKei(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getM_GanrikinKei()).toString());
            // 　　Md003_01Entity.最新データ更新日付⇒Md003_01DTO.最新データ更新日付(修正)
            String dateLastUpdate = "";
            if (null != outEntityList.get(0).getData_LastUpDate()) {
                dateLastUpdate = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getData_LastUpDate()
                        .toString());
            }
            outDto.setID_Data_LastUpDate(dateLastUpdate);

            // 　　Md003_01Entity.退避履歴番号⇒Md003_01DTO.退避履歴番号(修正)
            outDto.setID_Keep_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getKeep_ID_History()));
            // 　　Md003_01Entity.扱店別稟議データより取得した償還期限年月⇒Md003_01DTO.扱店別稟議データの償還期限年月(修正)
            outDto.setID_Date_ShokanKigen_aRingi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getARingi_Date_ShokanKigen()));
            // 　　Md003_01Entity.扱店別稟議データより取得した貸付残高⇒Md003_01DTO.扱店別稟議データの貸付残高(修正)
            outDto.setID_M_KashitsukeZandaka_aRingi(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getARingi_M_KashitsukeZandaka()).toString());
            // 　　Md003_01Entity.データコード＝９０２５７０４０、９０２５７０４１の場合
            // 　　　True⇒Md003_01DTO.代弁履行後の作成（修正）
            // 　　Md003_01Entity.データコード＝９０２５７０４０、９０２５７０４１以外の場合
            // 　　　False⇒Md003_01DTO.代弁履行後の作成（修正）
            String dataCode = outEntityList.get(0).getID_DataCode();
            if ((PNCommonConstants.DATACODE_90257040.equals(dataCode))
                    || (PNCommonConstants.DATACODE_90257041.equals(dataCode))) {
                outDto.setCkhAfter_Daibensai("1");
            } else {
                outDto.setCkhAfter_Daibensai("0");
            }

// [ADD] Ver 2.0.0 - START
            // 　　　初期元号⇒Md003_01DTO.受託者勘定処理年月（元号）（修正）
            outDto.setID_Date_Jtkshori_Gengo(PNCommonComponents.getInitgengo());
            // 　　　空文字⇒Md003_01DTO.受託者勘定処理年月（年）（修正）
            outDto.setID_Date_Jtkshori_Nen(null);
            // 　　　空文字⇒Md003_01DTO.受託者勘定処理年月（月）（修正）
            outDto.setDrpID_Date_JtkshoriTsuki(null);

// [ADD] Ver 2.0.0 - END
        }

        // 　更正(赤)用画面情報の場合
        // 　　Md003_01Entity.報告年月日⇒Md003_01DTO.報告年月日
        outDto.setID_Date_Report_Red(outEntityList.get(0).getID_Date_Report());
        // 　　Md003_01Entity.顧客名⇒Md003_01DTO.顧客名
        outDto.setTxtID_Name_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        // 　　Md003_01Entity.扱店名⇒Md003_01DTO.扱店名
        outDto.setTxtID_Name_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        // 　　Md003_01Entity.公庫支店⇒Md003_01DTO.公庫支店
        outDto.setTxtID_Code_KoukoShiten_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        // 　　Md003_01Entity.扱店⇒Md003_01DTO.扱店
        outDto.setTxtID_Code_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        // 　　Md003_01Entity.店舗⇒Md003_01DTO.店舗
        outDto.setTxtID_Code_Tenpo_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Tenpo()));
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.年度⇒Md003_01DTO.年度
        outDto.setTxtID_Year_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        // 　　Md003_01Entity.方式資金⇒Md003_01DTO.方式資金
        outDto.setTxtID_Code_HoshikiShikin_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        // 　　Md003_01Entity.番号⇒Md003_01DTO.番号
        outDto.setTxtID_ID_Ringi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        // 　　Md003_01Entity.枝番が0の場合、空白⇒Md003_01DTO.枝番
        // 　　　上記以外の場合、Md003_01Entity.枝番⇒Md003_01DTO.枝番
        String ringiBranch = "";
        if (false == "0".equals(outEntityList.get(0).getID_ID_RingiBranch())) {
            ringiBranch = outEntityList.get(0).getID_ID_RingiBranch();
        }
        outDto.setTxtID_ID_RingiBranch_Red(ringiBranch);
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.貸付実行日⇒Md003_01DTO.貸付実行日
        outDto.setTxtID_Date_KashitsukeJikko_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_kashitsukeJikko()));
        // 　　Md003_01Entity.貸付金額⇒Md003_01DTO.貸付金額
        outDto.setTxtID_M_Kashitsuke_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_Kashitsuke()).toString());
        // 資金使途
        outDto.setTxtID_Code_ShikinShito_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_ShikinShito()));
        // 事業別
        outDto.setTxtID_Code_Jigyobetsu_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Jigyobetsu()));
        // 　　１０００で割った値を設定する
        // 　　　Md003_01Entity.利率(%)⇒Md003_01DTO.利率(%)
        outDto.setTxtID_Riritsu_Red(PNCommonComponents.mathPercent1000(outEntityList.get(0).getID_Riritsu()));
        // 　　Md003_01Entity.特利区分⇒Md003_01DTO.特利区分
        outDto.setTxtID_Code_TokuriKubun_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_TokuriKubun()));
        // 　　１０００で割った値を設定する
        // 　　　Md003_01Entity.特利(%)⇒Md003_01DTO.特利(%)
        outDto.setTxtID_Tokuri_Red(PNCommonComponents.mathPercent1000(outEntityList.get(0).getID_Tokuri()));
        // 　　Md003_01Entity.償還方法⇒Md003_01DTO.償還方法
        outDto.setTxtID_Code_Shokan_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Shokan()));
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.据置期限⇒Md003_01DTO.据置期限
        outDto.setTxtID_Date_SueokiKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_SueokiKigen()));
        // 　　　Md003_01Entity.償還期限⇒Md003_01DTO.償還期限
        outDto.setTxtID_Date_ShokanKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_ShokanKigen()));
        // 　　Md003_01Entity.元利金払込日⇒Md003_01DTO.元利金払込日
        outDto.setTxtID_Date_GanrikinHaraikomi_Red(PNCommonComponents.dateFmtAD_MMDD(outEntityList.get(0)
                .getID_Date_GanrikinHaraikomi()));
        // 　　Md003_01Entity.元利又は元金均等額⇒Md003_01DTO.元利又は元金均等額(円)
        outDto.setTxtID_M_GankinKinto_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_GankinKinto()).toString());
        // 　　Md003_01Entity.払込前残元金⇒Md003_01DTO.払込前残元金 (円)
        outDto.setTxtID_M_KashitsukeZandaka_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_KashitsukeZandaka()).toString());
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.払込期日⇒Md003_01DTO.払込期日
        outDto.setTxtID_Date_Haraikomi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Haraikomi()));
        // 　　Md003_01Entity.払込額⇒Md003_01DTO.払込額(円)
        outDto.setTxtID_M_Haraikomi_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_Haraikomi()).toString());
        // 　　Md003_01Entity.控除利息⇒Md003_01DTO.控除利息(円)
        outDto.setTxtID_M_KojoRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_KojoRisoku()).toString());
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.入金日⇒Md003_01DTO.入金日
        outDto.setTxtID_Date_Nyukin_Red(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                .getID_Date_Nyukin()));
        // 　　Md003_01Entity.約定利息⇒Md003_01DTO.約定利息(円)
        outDto.setTxtID_M_YakujoRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_YakujoRisoku()).toString());
        // 　　Md003_01Entity.約定元金⇒Md003_01DTO.約定元金(円)
        outDto.setTxtID_M_YakujoGankin_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_YakujoGankin()).toString());
        // 　　Md003_01Entity.遅延損害金⇒Md003_01DTO.遅延損害金(円)
        outDto.setTxtID_M_ChienSongai_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_ChienSongai()).toString());
        // 　　Md003_01Entity.違約金⇒Md003_01DTO.違約金(円)
        outDto.setTxtID_M_Iyaku_Red(PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_Iyaku())
                .toString());
        // 　　Md003_01Entity.違約金（利子軽減分）⇒Md003_01DTO.違約金（利子軽減分）(円)
        outDto.setTxtID_M_IyakuRishikeigen_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_IyakuRishikeigen()).toString());
        // 　　Md003_01Entity.仮受金からの充当額⇒Md003_01DTO.仮受金からの充当額(円)
        if ("0".equals(PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_KariukeIppanJuto())
                .toString())) {
            outDto.setTxtID_M_KariukeIppanJuto_Red(PNCommonConstants.LITERAL_BLANK);
        } else {
            outDto.setTxtID_M_KariukeIppanJuto_Red(PNCommonComponents.cnvNulltoZero(
                    outEntityList.get(0).getID_M_KariukeIppanJuto()).toString());

        }
        // 　　Md003_01Entity.差引払込額⇒Md003_01DTO.差引払込額(円)
        outDto.setTxtID_M_SashihikiHaraikomi_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_SashihikiHaraikomi()).toString());
        // 　　Md003_01Entity.払込後残元金⇒Md003_01DTO.払込後残元金(円)
        outDto.setTxtID_M_ZangankinAfterHaraikomi_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_ZangankinAfterHaraikomi()).toString());
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.受託者勘定処理年月⇒Md003_01DTO.受託者勘定処理年月
        outDto.setTxtID_Date_Jtkshori_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Jtkshori()));
        // 　　和暦に変換して設定する
        // 　　　Md003_01Entity.送金日⇒Md003_01DTO.送金日
        outDto.setTxtID_Date_Sokin_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Sokin()));
        // 　　Md003_01Entity.送金日番号⇒Md003_01DTO.送金日番号
        outDto.setTxtID_ID_Sokinbi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_ID_Sokinbi()));
// [ADD] Ver 2.0.0 - START
        // 　　　初期元号⇒Md003_01DTO.受託者勘定処理年月（元号）
        outDto.setID_Date_Jtkshori_Gengo_Red(PNCommonComponents.getInitgengo());
        // 　　　空文字⇒Md003_01DTO.受託者勘定処理年月（年）
        outDto.setID_Date_Jtkshori_Nen_Red(null);
        // 　　　空文字⇒Md003_01DTO.受託者勘定処理年月（月）
        outDto.setDrpID_Date_JtkshoriTsuki_Red(null);
// [ADD] Ver 2.0.0 - END

        // 　　Md003_01Entity.報告書番号⇒Md003_01DTO.報告書番号
        outDto.setID_ID_Report_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
        // 　　Md003_01Entity.報告時分秒⇒Md003_01DTO.報告時分秒
        outDto.setID_Time_Report_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Time_Report()));
        // 　　Md003_01Entity.ユーザID⇒Md003_01DTO.ユーザID
        outDto.setID_User_ID_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_User_ID()));
        // 　　Md003_01Entity.伝送番号⇒Md003_01DTO.伝送番号
        outDto.setID_ID_Denso_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
        // 　　Md003_01Entity.データコード⇒Md003_01DTO.データコード
        outDto.setID_DataCode_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_DataCode()));
        // 　　Md003_01Entity.残高件数⇒Md003_01DTO.残高件数
        outDto.setID_Count_Zandaka_Red(outEntityList.get(0).getID_Count_Zandaka().toString());
        // 　　Md003_01Entity.履歴番号⇒Md003_01DTO.履歴番号
        outDto.setID_ID_History_Red(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
        // 　　Md003_01Entity.ステータス⇒Md003_01DTO.ステータス
        if (null != outEntityList.get(0).getID_Status()) {
            outDto.setID_Status_Red(outEntityList.get(0).getID_Status().toString());
        } else {
            outDto.setID_Status_Red(PNCommonConstants.LITERAL_BLANK);
        }

        // 　　Md003_01Entity.処理種別⇒Md003_01DTO.処理種別
        outDto.setID_Type_Process_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Type_Process()));
        // 　　Md003_01Entity.取消済フラグ⇒Md003_01DTO.取消済フラグ
        outDto.setID_Flag_Torikeshizumi_Red(outEntityList.get(0).getID_Flag_Torikeshizumi().toString());
        // 　　Md003_01Entity.エラー番号⇒Md003_01DTO.エラー番号
        outDto.setID_Code_Error_Red(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
        // 　　Md003_01Entity.エラーメッセージ⇒Md003_01DTO.エラーメッセージ
        outDto.setID_ErrorMessage_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_ErrorMessage()));
        // 　　Md003_01Entity.退避貸付金残高⇒Md003_01DTO.退避貸付金残高
        outDto.setID_Keep_M_KashitsukeZan_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_Keep_M_KashitsukeZan()).toString());
        // 　　Md003_01Entity.退避約定元金⇒Md003_01DTO.退避約定元金
        outDto.setID_Keep_M_YakujoGankin_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_Keep_M_YakujoGankin()).toString());
        // 　　Md003_01Entity.退避約定利息⇒Md003_01DTO.退避約定利息
        outDto.setID_Keep_M_YakujoRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_Keep_M_YakujoRisoku()).toString());
        // 　　Md003_01Entity.退避償還期限⇒Md003_01DTO.退避償還期限
        outDto.setID_Keep_Date_ShokanKigen_Red(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                .getID_Keep_Date_ShokanKigen()));
        // 　　Md003_01Entity.債権管理番号⇒Md003_01DTO.債権管理番号
        if (null != outEntityList.get(0).getID_ID_Credit()) {
            outDto.setID_ID_Credit_Red(outEntityList.get(0).getID_ID_Credit().toString());
        } else {
            outDto.setID_ID_Credit_Red(PNCommonConstants.LITERAL_BLANK);
        }

        // 　　Md003_01Entity.顧客コード⇒Md003_01DTO.顧客コード
        outDto.setID_Code_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Customer()));
        // 　　Md003_01Entity.充当順序変更区分⇒Md003_01DTO.充当順序変更区分
        outDto.setID_Kubun_JutoJunjoHenko_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getKubun_JutoJunjoHenko()));
        // 　　Md003_01Entity.請求データの退避任意繰償還利息⇒Md003_01DTO.請求データの退避任意繰償還利息
        outDto.setID_Keep_Seikyu_M_NinKuriRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getKeep_Seikyu_M_NinKuriRisoku()).toString());
        // 　　Md003_01Entity.請求データの退避請求繰償還利息⇒Md003_01DTO.請求データの退避請求繰償還利息
        outDto.setID_Keep_Seikyu_M_NinKuriRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getKeep_Seikyu_M_SeiKuriRisoku()).toString());
        // 　　Md003_01Entity.請求データの退避請求繰償還元金⇒Md003_01DTO.請求データの退避請求繰償還元金
        outDto.setID_Keep_Seikyu_M_SeiKuriGankin_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getKeep_Seikyu_M_SeiKuriGankin()).toString());
        // 　　Md003_01Entity.約定データの退避請求繰償還利息⇒Md003_01DTO.約定データの退避請求繰償還利息
        outDto.setID_Keep_Yakujo_M_SeiKuriRisoku_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getKeep_Yakujo_M_SeiKuriRisoku()).toString());
        // 　　Md003_01Entity.元利金計⇒Md003_01DTO.元利金計
        outDto.setID_M_GanrikinKei_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getM_GanrikinKei()).toString());
        // 　　Md003_01Entity.最新データ更新日付⇒Md003_01DTO.最新データ更新日付
        String lastUpdate = "";
        if (null != outEntityList.get(0).getData_LastUpDate()) {
            lastUpdate = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getData_LastUpDate()
                    .toString());
        }
        outDto.setID_Data_LastUpDate_Red(lastUpdate);
        // 　　Md003_01Entity.退避履歴番号⇒Md003_01DTO.退避履歴番号
        outDto.setID_Keep_ID_History_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getKeep_ID_History()));
        // 　　Md003_01Entity.扱店別稟議データより取得した償還期限年月⇒Md003_01DTO.扱店別稟議データの償還期限年月
        outDto.setID_Date_ShokanKigen_aRingi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getARingi_Date_ShokanKigen()));
        // 　　Md003_01Entity.扱店別稟議データより取得した貸付残高⇒Md003_01DTO.扱店別稟議データの貸付残高
        outDto.setID_M_KashitsukeZandaka_aRingi_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getARingi_M_KashitsukeZandaka()).toString());
        // 　　Md003_01Entity.データコード＝９０２５７０４０、９０２５７０４１の場合
        // 　　　True⇒Md003_01DTO.代弁履行後の作成
        // 　　Md003_01Entity.データコード＝９０２５７０４０、９０２５７０４１以外の場合
        // 　　　False⇒Md003_01DTO.代弁履行後の作成
        String dataCode = outEntityList.get(0).getID_DataCode();
        if ((PNCommonConstants.DATACODE_90257040.equals(dataCode))
                || (PNCommonConstants.DATACODE_90257041.equals(dataCode))) {
            outDto.setCkhAfter_Daibensai_Red("1");
        } else {
            outDto.setCkhAfter_Daibensai_Red("0");
        }

        return outDto;
    }

    /**
     * Md003_01ServiceのgetNewSeikyuData
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getNewSeikyuData(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // 受渡情報の取得

        // 請求データの取得の検索条件を設定
        // 　単テーブルアクセス定義の「請求データ　データ取得」を参照し、条件を設定する。
        // 　SeikyuDAO.findByPrimaryKey
        SeikyuEntity inEntity = new SeikyuEntity();
        BigDecimal bID_ID_Credit = new BigDecimal(inDto.getID_ID_Credit());
        inEntity.setID_Credit(bID_ID_Credit);
        inEntity.setDate_Haraikomi(inDto.getTxtID_Date_Haraikomi());

        try {
            SeikyuEntity outEntity = seikyudao.findByPrimaryKey(inEntity);
            // Entity⇒DTOに転記
            if (null == outEntity) {
                outDto.setNew_M_YakujoRisoku(PNCommonConstants.LITERAL_BLANK);
                outDto.setNew_M_YakujoGankin(PNCommonConstants.LITERAL_BLANK);
                outDto.setNew_M_Seikyu_NinKuriRisoku(PNCommonConstants.LITERAL_BLANK);
                outDto.setNew_M_Seikyu_SeiKuriRisoku(PNCommonConstants.LITERAL_BLANK);
                outDto.setNew_M_Seikyu_SeiKuriGankin(PNCommonConstants.LITERAL_BLANK);
            } else {
                // 　　SeikyuEntity.約定利息⇒Md004_01DTO.最新の請求データの約定利息
                outDto.setNew_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(outEntity.getM_YakujoRisoku())
                        .toString());
                // 　　SeikyuEntity.約定元金⇒Md004_01DTO.最新の請求データの約定元金
                outDto.setNew_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(outEntity.getM_YakujoGankin())
                        .toString());
                // 　　SeikyuEntity任意繰償利息⇒Md004_01DTO.最新の請求データの任意繰償還利息
                outDto.setNew_M_Seikyu_NinKuriRisoku(PNCommonComponents.cnvNulltoZero(
                        outEntity.getM_NinKuriRisoku()).toString());
                // 　　SeikyuEntity.請求繰償利息⇒Md004_01DTO.最新の請求データの請求繰償還利息
                outDto.setNew_M_Seikyu_SeiKuriRisoku(PNCommonComponents.cnvNulltoZero(
                        outEntity.getM_SeiKuriRisoku()).toString());
                // 　　SeikyuEntity.請求繰償元金⇒Md004_01DTO.最新の請求データの請求繰償還元金
                outDto.setNew_M_Seikyu_SeiKuriGankin(PNCommonComponents.cnvNulltoZero(
                        outEntity.getM_SeiKuriGankin()).toString());
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        }

        return outDto;
    }

    /**
     * Md003_01ServiceのgetYakujoMSeiKuriRisoku
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getYakujoMSeiKuriRisoku(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 受渡情報の取得

        // 約定データ存在チェック

        // 約定データの件数取得の検索条件を設定
        // 　単テーブルアクセス定義の「約定データ　件数取得」を参照し、条件を設定する。
        // 　　YakujoDAO.countByCondition
        YakujoEntity inEntity = new YakujoEntity();
        BigDecimal bID_ID_Credit = new BigDecimal(inDto.getID_ID_Credit());
        inEntity.setID_Credit(bID_ID_Credit);
        inEntity.setDate_Haraikomi(inDto.getTxtID_Date_Haraikomi());

        long hitcount = yakujodao.countByCondition(inEntity);

        // 　取得した件数＞1件の場合、システムエラーとする。
        // 　　メッセージ：PM9990E
        if (1 < hitcount) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9990E, new String[]{null}, false));
            // エラー情報をControllerに返却
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 約定データの取得の検索条件を設定
        // 　単テーブルアクセス定義の「約定データ　データ取得」を参照し、条件を設定する。
        // 　　YakujoDAO.findByPrimaryKey
        YakujoEntity inEntity2 = new YakujoEntity();
        inEntity2.setID_Credit(bID_ID_Credit);
        inEntity2.setDate_Haraikomi(inDto.getTxtID_Date_Haraikomi());
        try {
            YakujoEntity outEntity = yakujodao.findByPrimaryKey(inEntity2);
            // Entity⇒DTOに転記
            if (null == outEntity) {
                outDto.setID_Keep_Yakujo_M_SeiKuriRisoku(PNCommonConstants.LITERAL_BLANK);
                outDto.setID_Keep_Yakujo_M_SeiKuriRisoku_Red(PNCommonConstants.LITERAL_BLANK);
            } else {
                outDto.setID_Keep_Yakujo_M_SeiKuriRisoku(PNCommonComponents.cnvNulltoZero(
                        outEntity.getM_SeiKuriRisoku()).toString());

                outDto.setID_Keep_Yakujo_M_SeiKuriRisoku_Red(PNCommonComponents.cnvNulltoZero(
                        outEntity.getM_SeiKuriRisoku()).toString());
            }

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        }

        return outDto;
    }

    /**
     * Md003_01ServiceのgetSeikyu
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getSeikyu(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // 請求データ存在チェック

        // 請求データの件数取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Md003_01SeikyuCountDAO」を参照し、条件を設定する。
        // 　　Md003_01SeikyuCountDAO.countByCondition
        long hitcount = 0L;
        Md003_01SeikyuCountEntity inEntity = new Md003_01SeikyuCountEntity();
        BigDecimal bID_ID_Credit = new BigDecimal(inDto.getID_ID_Credit());
        inEntity.setID_Credit(bID_ID_Credit);
        inEntity.setDate_Haraikomi(inDto.getTxtID_Date_Haraikomi());
        hitcount = md003_01seikyucountdao.countByCondition(inEntity);

        // Entity⇒DTOに転記
        // 　　取得した件数⇒Md003_01DTO.件数
        outDto.setKensu(String.valueOf(hitcount));

        return outDto;
    }

    /**
     * Md003_01ServiceのgetSeikyuYakujoGankin
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getSeikyuYakujoGankin(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // 請求データより約定元金の値を取得

        // 請求データ取得の検索条件を設定
        // 　複数テーブルアクセス定義の「SeikyuCountDAO」を参照し、条件を設定する。
        // 　　Md003_01SeikyuYakujoGankinDAO.findByCondition
        Md003_01SeikyuYakujoGankinEntity inEntity = new Md003_01SeikyuYakujoGankinEntity();
        BigDecimal bID_ID_Credit = new BigDecimal(inDto.getID_ID_Credit());
        inEntity.setID_Credit(bID_ID_Credit);
        inEntity.setDate_Haraikomi(inDto.getTxtID_Date_Haraikomi());
        List<Md003_01SeikyuYakujoGankinEntity> outEntityList = md003_01seikyuyakujogankindao
                .findByCondition(inEntity);

        // Entity⇒DTOに転記
        // 　　Md003_01SeikyuYakujoGankinEntity.約定元金⇒Md003_01DTO.約定元金
        if (0 == outEntityList.size()) {
            outDto.setID_M_YakujoGankin_Seikyu(PNCommonConstants.LITERAL_BLANK);
        } else {
            outDto.setID_M_YakujoGankin_Seikyu(PNCommonComponents.cnvNulltoZero(outEntityList.get(0)
                    .getM_YakujoGankin().toString()));
        }

        return outDto;
    }

    /**
     * Md003_01ServiceのgetAcustomer
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getAcustomer(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // 扱店別顧客データ存在チェック

        // 扱店別顧客データの件数取得の検索条件を設定
        // 　単テーブルアクセス定義の「扱店別顧客データ　件数取得」を参照し、条件を設定する。
        // 　　AcustomerDAO.countByCondition
        AcustomerEntity inEntity = new AcustomerEntity();
        inEntity.setCode_Customer(inDto.getID_Code_Customer());
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());

        int hitcount = new BigDecimal(acustomerdao.countByCondition(inEntity)).intValue();

        // Entity⇒DTOに転記
        // 　　取得した件数⇒Md003_01DTO.件数
        outDto.setLength(hitcount);

        return outDto;
    }

    /**
     * Md003_01ServiceのgetTenpo
     *
     * @param inDto Md003_01DTO
     * @return Md003_01DTO
     */
    @Override
    public Md003_01DTO getTenpo(Md003_01DTO inDto) {

        Md003_01DTO outDto = new Md003_01DTO();

        // 金融機関店舗データ存在チェック

        // 金融機関店舗データの件数取得の検索条件を設定
        // 　単テーブルアクセス定義の「金融機関店舗データ　件数取得」を参照し、条件を設定する。
        // 　　TenpoDAO.countByCondition
        TenpoEntity inEntity = new TenpoEntity();
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());
        int hitcount = new BigDecimal(tenpodao.countByCondition(inEntity)).intValue();

        // Entity⇒DTOに転記
        // 　　取得した件数⇒Md003_01DTO.件数
        outDto.setLength(hitcount);

        return outDto;
    }

}