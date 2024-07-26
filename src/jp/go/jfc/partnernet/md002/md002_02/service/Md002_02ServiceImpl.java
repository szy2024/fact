//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_02.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AringiDAO;
import jp.go.jfc.partnernet.common.dao.AringiEntity;
import jp.go.jfc.partnernet.common.dao.HaraidashiDAO;
import jp.go.jfc.partnernet.common.dao.HaraidashiEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.common.dao.UkeirereportDAO;
import jp.go.jfc.partnernet.common.dao.UkeirereportEntity;
import jp.go.jfc.partnernet.md002.common.Md002Constants;
import jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataDAO;
import jp.go.jfc.partnernet.md002.md002_02.dao.Md002_02ResultsDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはmd002_02のサービスクラスです。
 * </pre>
 *
 * 取得償還方法コード
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_02ServiceImpl extends PNBaseService implements Md002_02Service {

    /** md002_02resultsdatadao */
    @Autowired
    private Md002_02ResultsDataDAO md002_02resultsdatadao;

    /** haraidashidao */
    @Autowired
    private HaraidashiDAO haraidashidao;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** ukeirereportdao */
    @Autowired
    private UkeirereportDAO ukeirereportdao;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Md002_02ServiceのgetResultsData
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO getResultsData(Md002_02DTO inDto) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        Md002_02DTO outDto = new Md002_02DTO();

        // 受渡パラメータを取得する。
        // 一覧画面データの取得
        // １．複数テーブルアクセス定義の「Md002_01ResultsDataDAO」を参照し、条件を設定する。
        Md002_02ResultsDataEntity inEntity = new Md002_02ResultsDataEntity();
        inEntity.setID_Report(inDto.getID_ID_Report());
        List<Md002_02ResultsDataEntity> outEntityList = md002_02resultsdatadao.findByCondition(inEntity);

        // ２．取得した情報＝０件の場合、業務エラーとする。
        if (0 == outEntityList.size()) {
            // エラーメッセージ：PM9060E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[]{null}, false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        } else if (1 < outEntityList.size()) {
            // ３．取得した情報＞１件の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[]{null}, false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        Md002_02ResultsDataEntity outEntity = outEntityList.get(0);
        // Entity⇒DTOに転記
        // ・Md002_02ResultsDataEntity.顧客名⇒Md002_02DTO.顧客名
        outDto.setLblID_Name_Customer_Red(outEntity.getName_Customer());
        // ・Md002_02ResultsDataEntity.扱店名⇒Md002_02DTO.扱店名
        outDto.setLblID_Name_Organization_Red(outEntity.getName_Organization());
        // ・Md002_02ResultsDataEntity.公庫支店⇒Md002_02DTO.公庫支店
        outDto.setLblID_Code_KoukoShiten_Red(outEntity.getCode_KoukoShiten());
        // ・Md002_02ResultsDataEntity.扱店⇒Md002_02DTO.扱店
        outDto.setLblID_Code_Organization_Red(outEntity.getCode_Organization());
        // ・Md002_02ResultsDataEntity.店舗⇒Md002_02DTO.店舗
        outDto.setLblID_Code_Tenpo_Red(outEntity.getCode_Tenpo());
        // ・Md002_02ResultsDataEntity.年度⇒Md002_02DTO.年度
        outDto.setLblID_Year_Red(outEntity.getYear());
        // ・Md002_02ResultsDataEntity.方式資金⇒Md002_02DTO.方式資金
        outDto.setLblID_Code_HoshikiShikin_Red(outEntity.getCode_HoshikiShikin());
        // ・Md002_02ResultsDataEntity.番号⇒Md002_02DTO.番号
        outDto.setLblID_ID_Ringi_Red(outEntity.getID_Ringi());
        // ・Md002_02ResultsDataEntity.枝番⇒Md002_02DTO.枝番
        String ringiBranch = "";
        if (!Md002Constants.STR_ZERO.equals(outEntity.getID_RingiBranch())) {
            ringiBranch = outEntity.getID_RingiBranch();
        }
        outDto.setLblID_ID_RingiBranch_Red(ringiBranch);
        // ・Md002_02ResultsDataEntity.資金使途⇒Md002_02DTO.資金使途
        outDto.setLblID_Code_ShikinShito_Red(outEntity.getCode_ShikinShito());
        // ・Md002_02ResultsDataEntity.事業別⇒Md002_02DTO.事業別
        outDto.setLblID_Code_Jigyobetsu_Red(outEntity.getCode_Jigyobetsu());
        // ・Md002_02ResultsDataEntity.利率⇒Md002_02DTO.利率
        outDto.setLblID_Riritsu_Red(PNCommonComponents.mathPercent1000(outEntity.getRiritsu()));
        // ・Md002_02ResultsDataEntity.特利区分⇒Md002_02DTO.特利区分
        outDto.setLblID_Code_TokuriKubun_Red(outEntity.getCode_TokuriKubun());
        // ・Md002_02ResultsDataEntity.特利⇒Md002_02DTO.特利
        outDto.setLblID_Tokuri_Red(PNCommonComponents.mathPercent1000(outEntity.getTokuri()));
        // ・Md002_02ResultsDataEntity.据置期限⇒Md002_02DTO.据置期限
        outDto.setLblID_Date_SueokiKigen_Red(outEntity.getDate_SueokiKigen());
        // ・Md002_02ResultsDataEntity.償還期限⇒Md002_02DTO.償還期限
        outDto.setLblID_Date_ShokanKigen_Red(outEntity.getDate_ShokanKigen());
        // ・Md002_02ResultsDataEntity.元利金払込期日⇒Md002_02DTO.元利金払込期日
        outDto.setLblID_Date_GanrikinHaraikomi_Red(PNCommonComponents.dateFmtAD_MMDD(outEntity
                .getDate_GanrikinHaraikomi()));
        // ・Md002_02ResultsDataEntity.貸付実行日⇒Md002_02DTO.貸付実行日
        outDto.setLblID_Date_Jikko_Red(outEntity.getDate_Jikko());
        // ・Md002_02ResultsDataEntity.貸付実行額金額⇒Md002_02DTO.貸付実行額金額
        outDto.setLblID_M_Kashitsuke_Red(outEntity.getM_Kashitsuke());
        // ・Md002_02ResultsDataEntity.資金交付額⇒Md002_02DTO.資金交付額
        outDto.setLblID_M_ShikinKofu_Red(outEntity.getM_ShikinKofu());
        // ・Md002_02ResultsDataEntity.貸付受入金受入額⇒Md002_02DTO.貸付受入金受入額
        outDto.setLblID_M_KashitsukeUkeire_Red(outEntity.getM_KashitsukeUkeire());
        // ・Md002_02ResultsDataEntity.受託者勘定処理年月⇒Md002_02DTO.受託者勘定処理年月
        outDto.setLblID_Date_Jtkshori_Red(outEntity.getDate_Jtkshori());
        // ・Md002_02ResultsDataEntity.払出・元金充当日⇒Md002_02DTO.払出　　・元金充当日
        outDto.setLblID_Date_HaraidashiJuto_Red(outEntity.getDate_HaraidashiJuto());
        // ・Md002_02ResultsDataEntity.資金払出額⇒Md002_02DTO.資金払出額
        outDto.setLblID_M_Haraidashi_Red(outEntity.getM_Haraidashi());
        // ・Md002_02ResultsDataEntity.元金充当額⇒Md002_02DTO.元金充当額
        outDto.setLblID_M_Ganju_Red(outEntity.getM_Ganju());
        // ・Md002_02ResultsDataEntity.貸付受入金残高⇒Md002_02DTO.貸付受入金残高
        outDto.setLblID_M_KashitsukeukeireZan_Red(outEntity.getM_KashitsukeukeireZan());
        // ・Md002_02ResultsDataEntity.元金充当後貸付金残高⇒Md002_02DTO.元金充当後貸付金残高
        if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity.getM_Ganju()))) {
            outDto.setLblID_M_KashitsukeZandakaAfterGanju_Red(outEntity.getM_KashitsukeZandakaAfterGanju());
        } else {
            outDto.setLblID_M_KashitsukeZandakaAfterGanju_Red(null);
        }
        // ・Md002_02ResultsDataEntity.元金充当後第１回約定日⇒Md002_02DTO.元金充当後第１回約定日
        outDto.setLblID_Date_FirstYakujoAfterGanju_Red(outEntity.getDate_FirstYakujoAfterGanju());
        // ・Md002_02ResultsDataEntity.繰上償還事由コード⇒Md002_02DTO.繰上償還事由コード
        outDto.setLblID_Code_KurishoJiyu_Red(outEntity.getCode_KurishoJiyu());
        // ・Md002_02ResultsDataEntity.元金充当後の元金均等額⇒Md002_02DTO.元金充当後の元金均等額
        if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity
                .getM_GankinKintoAfterGanju()))) {
            outDto.setLblID_M_GankinKintoAfterGanju_Red(outEntity.getM_GankinKintoAfterGanju());
        } else {
            outDto.setLblID_M_GankinKintoAfterGanju_Red(null);
        }
        // ・Md002_02ResultsDataEntity.元金充当後の元金不均等額⇒Md002_02DTO.元金充当後の元金不均等額
        if (0 > BigDecimal.ZERO.compareTo(PNCommonComponents.cnvNulltoZero(outEntity
                .getM_GankinKintoAfterGanju()))) {
            outDto.setLblID_M_GankinFukintoAfterGanju_Red(outEntity.getM_GankinFukintoAfterGanju());
        } else {
            outDto.setLblID_M_GankinFukintoAfterGanju_Red(null);
        }
        // ・Md002_02ResultsDataEntity.調整コード⇒Md002_02DTO.調整コード
        outDto.setRdoID_Code_Chosei_Red(PNCommonComponents.cnvNulltoBlank(outEntity.getCode_Chosei()));
        // ・Md002_02ResultsDataEntity.報告書番号（非表示）⇒Md002_02DTO.報告書番号（非表示）
        outDto.setID_ID_Report(outEntity.getID_Report());
        // ・Md002_02ResultsDataEntity.報告時分秒（非表示）⇒Md002_02DTO.報告時分秒（非表示）
        outDto.setID_Time_Report(outEntity.getTime_Report());
        // ・Md002_02ResultsDataEntity.ユーザID（非表示）⇒Md002_02DTO.ユーザID（非表示）
        outDto.setID_UserID(outEntity.getUserID());
        // ・Md002_02ResultsDataEntity.伝送番号（非表示）⇒Md002_02DTO.伝送番号（非表示）
        outDto.setID_ID_Denso(outEntity.getID_Denso());
        // ・Md002_02ResultsDataEntity.データコード（非表示）⇒Md002_02DTO.データコード（非表示）
        outDto.setID_Data_Code(outEntity.getDataCode());
        // ・Md002_02ResultsDataEntity.合計（非表示）⇒Md002_02DTO.合計（非表示）
        outDto.setID_M_Kei_Red(outEntity.getM_Kei());
        // ・Md002_02ResultsDataEntity.報告書履歴番号（非表示）⇒Md002_02DTO.報告書履歴番号（非表示）
        outDto.setID_ID_History(outEntity.getID_History());
        // ・Md002_02ResultsDataEntity.ステータス（非表示）⇒Md002_02DTO.ステータス（非表示）
        outDto.setID_Status(outEntity.getStatus());
        // ・Md002_02ResultsDataEntity.処理種別（非表示）⇒Md002_02DTO.処理種別（非表示）
        outDto.setID_Type_Process(outEntity.getType_Process());
        // ・Md002_02ResultsDataEntity.取消済みフラグ（非表示）⇒Md002_02DTO.取消済みフラグ（非表示）
        outDto.setID_Flag_Torikeshizumi(outEntity.getFlag_Torikeshizumi());
        // ・Md002_02ResultsDataEntity.エラーコード（非表示）⇒Md002_02DTO.エラーコード（非表示）
        outDto.setID_Code_Error(outEntity.getCode_Error());
        // ・Md002_02ResultsDataEntity.エラーメッセージ（非表示）⇒Md002_02DTO.エラーメッセージ（非表示）
        outDto.setID_ErrorMessage(outEntity.getErrorMessage());
        // ・Md002_02ResultsDataEntity.債権管理番号（非表示）⇒Md002_02DTO.債権管理番号（非表示）
        outDto.setID_ID_Credit(outEntity.getID_Credit());
        // ・Md002_02ResultsDataEntity.退避賦金（非表示）⇒Md002_02DTO.退避賦金（非表示）
        outDto.setID_Keep_M_Fukin(outEntity.getKeep_M_Fukin());
        // ・Md002_02ResultsDataEntity.退避元金不均等（非表示）⇒Md002_02DTO.退避元金不均等（非表示）
        outDto.setID_Keep_M_GankinFukinto(outEntity.getKeep_M_GankinFukinto());
        // ・Md002_02ResultsDataEntity.退避元金不均等区分（非表示）⇒Md002_02DTO.退避元金不均等区分（非表示）
        outDto.setID_Keep_Kubun_GankinFukinto(outEntity.getKeep_Kubun_GankinFukinto());
        // ・Md002_02ResultsDataEntity.退避貸付金残高（非表示）⇒Md002_02DTO.退避貸付金残高（非表示）
        outDto.setID_Keep_M_KashitsukeZan(outEntity.getKeep_M_KashitsukeZan());
        // ・Md002_02ResultsDataEntity.退避約定元金（非表示）⇒Md002_02DTO.退避約定元金（非表示）
        outDto.setID_Keep_M_YakujoGankin(outEntity.getKeep_M_YakujoGankin());
        // ・Md002_02ResultsDataEntity.退避約定利息（非表示）⇒Md002_02DTO.退避約定利息（非表示）
        outDto.setID_Keep_M_YakujoRisoku(outEntity.getKeep_M_YakujoRisoku());
        // ・Md002_02ResultsDataEntity.退避償還期限年月（非表示）⇒Md002_02DTO.退避償還期限年月（非表示）
        outDto.setID_Keep_Date_ShokanKigen(outEntity.getKeep_Date_ShokanKigen());
        // ・Md002_02ResultsDataEntity.稟議・賦金（非表示）⇒Md002_02DTO.稟議　　・賦金（非表示）
        outDto.setID_M_Fukin_Ringi(outEntity.getM_Fukin_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・元金不均等（非表示）⇒Md002_02DTO.稟議・元金不均等（非表示）
        outDto.setID_M_GankinFukinto_Ringi(outEntity.getM_GankinFukinto_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・元金不均等区分（非表示）⇒Md002_02DTO.稟議・元金不均等区分（非表示）
        outDto.setID_Kubun_GankinFukinto_Ringi(outEntity.getKubun_GankinFukinto_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・貸付金残高（非表示）⇒Md002_02DTO.稟議・貸付金残高（非表示）
        outDto.setID_M_KashitsukeZan_Ringi(outEntity.getM_KashitsukeZan_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・償還期限年月（非表示）⇒Md002_02DTO.稟議・償還期限年月（非表示）
        outDto.setID_Date_ShokanKigen_Ringi(outEntity.getDate_ShokanKigen_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・最新変更年月日（非表示）⇒Md002_02DTO.稟議・最新変更年月日（非表示）
        outDto.setID_Data_LastUpDate(outEntity.getData_LastUpDate());
        // ・Md002_02ResultsDataEntity.稟議・償還方法コード（非表示）⇒Md002_02DTO.稟議・償還方法コード（非表示）
        outDto.setID_Code_ShokanHouhou_Ringi(outEntity.getCode_ShokanHouhou_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・特利有効期限（非表示）⇒Md002_02DTO.稟議・特利有効期限（非表示）
        outDto.setID_Date_TokuriYuko_Ringi(outEntity.getDate_TokuriYuko_Ringi());
        // ・Md002_02ResultsDataEntity.稟議・条変起案中区分（非表示）⇒Md002_02DTO.稟議・条変起案中区分（非表示）
        outDto.setID_Kubun_JohenKianchu_Ringi(outEntity.getKubun_JohenKianchu_Ringi());
        // ・Md002_02ResultsDataEntity.退避条変起案中区分（非表示）⇒Md002_02DTO.退避条変起案中区分（非表示）
        outDto.setID_Keep_JohenKianchu(outEntity.getKeep_JohenKianchu());
        // ・Md002_02ResultsDataEntity.顧客コード（非表示）⇒Md002_02DTO.顧客コード（非表示）
        outDto.setID_Code_Customer(outEntity.getCode_Customer());
        // ・Md002_02ResultsDataEntity.最新データ更新日付（非表示）⇒Md002_02DTO.最新データ更新日付（非表示）
        outDto.setID_Data_LastUpDate(outEntity.getData_LastUpDate());
        // ・Md002_02ResultsDataEntity.退避履歴番号（非表示）⇒Md002_02DTO.退避履歴番号（非表示）
        outDto.setID_Keep_ID_History(outEntity.getKeep_ID_History());
        return outDto;
    }

    /**
     * Md002_02ServiceのGetRevivHaraidashiData
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO GetRevivHaraidashiData(Md002_02DTO inDto) {

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        Md002_02DTO outDto = new Md002_02DTO();

        // 払出データの存在チェック

        // 払出データの件数取得の検索条件を設定
        // １．単テーブルアクセス定義の「払出データ　復活用対象の払出テーブル存在チェック」を参照し、条件を設定する。
        HaraidashiEntity inEntity = new HaraidashiEntity();
        // 債権管理番号
        inEntity.setID_Credit(inDto.getID_ID_Credit());
        // 払出額
        inEntity.setM_Haraidashi(inDto.getLblID_M_Haraidashi_Red());
        // 繰上償還額
        inEntity.setM_Kurisho(inDto.getLblID_M_Ganju_Red());
        // 更正処理区分
        inEntity.setKubun_KoseiShori("1");
        // 払出充当年月日
        inEntity.setDate_HaraidashiJuto(inDto.getLblID_Date_HaraidashiJuto_Red());
        // 貸付受入金残高
        long hitcount = haraidashidao.countByCondition(inEntity);

        // ２．取得した件数＝１件の場合
        if (1 == hitcount) {
            // （１）払出データが存在する場合、払出データを取得する

            // ①単テーブルアクセス定義の「払出データ　復活用対象の払出テーブル読込」を参照し、条件を設定する。
            List<HaraidashiEntity> outEntityList = haraidashidao.findByCondition(inEntity);
            HaraidashiEntity outEntity = outEntityList.get(0);
            outDto.setID_HDDel1_Keep_ID_Credit(outEntity.getID_Credit());
            outDto.setID_HDDel1_Keep_ID_KeisuKanriShori(outEntity.getID_KeisuKanriShori());
            outDto.setID_HDDel1_Keep_M_Haraidashi(outEntity.getM_Haraidashi());
            outDto.setID_HDDel1_Keep_M_HaraidashiRuikei(outEntity.getM_HaraidashiRuikei());
            outDto.setID_HDDel1_Keep_M_Kurisho(outEntity.getM_Kurisho());
            outDto.setID_HDDel1_Keep_M_KurishoRuikei(outEntity.getM_KurishoRuikei());
            outDto.setID_HDDel1_Keep_Kubun_KoseiShori(outEntity.getKubun_KoseiShori());
            outDto.setID_HDDel1_Keep_M_ZandakaSekisu(outEntity.getM_ZandakaSekisu());
            outDto.setID_HDDel1_Keep_Date_HaraidashiJuto(outEntity.getDate_HaraidashiJuto());
            outDto.setID_HDDel1_Keep_M_HaraidashiKashitsukeZan(outEntity.getM_KashitsukeukeireZan());

        } else if (0 == hitcount) {
            // ②取得データが１件もない場合、エラーとし以降の処理を抜ける。
            // エラーメッセージ：PM9060E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[]{null}, false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        } else if (1 < hitcount) {
            // ③取得データが２件以上の場合、エラーとし以降の処理を抜ける。
            // エラーメッセージ：PM9010E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[]{null}, false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        return outDto;
    }

    /**
     * Md002_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO updateDataNotProcEndDel(Md002_02DTO inDto) {

        Md002_02DTO outDto = new Md002_02DTO();

        // 取消：処理完了以外の更新処理。
        // ＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // １．報告書履歴データのレコードを更新　　※画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        inDto.setID_Flag_Torikeshizumi(BigDecimal.ONE);
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        long hitcount = reporthistorydao.countByCondition(inEntity);

        if (1 != hitcount) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity1 = new ReporthistoryEntity();
        inEntity1.setID_History(inDto.getID_ID_History());
        ReporthistoryEntity outEntity1 = null;
        try {
            outEntity1 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity1);

            if (null == outEntity1) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        // ①取消：処理完了以外（更正（赤））の場合
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        inEntity2.setID_History(inDto.getID_ID_History());

        // （１）更正（赤）データの値を設定しなおす。
        // ①""⇒更正（赤）データの報告書番号
        // ②"1"⇒更正（赤）データの取消済フラグ
        // ②取消：処理完了以外（更正（赤））以外の場合
        // （ａ）更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity2.setID_Report("");
        // （ｂ）更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity2.setFlag_Torikeshizumi(BigDecimal.ONE);

        // 報告書履歴データを更新をする。
        // （８）単テーブルアクセス定義「報告書履歴データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
        try {
            reporthistorydao.update(inEntity2);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ２．扱店別稟議データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの貸付金残高、償還期限年月をデータ取得時の値で更新
        // （１）更正（赤）データの値を設定しなおす。
        // ①扱店別稟議データ「条変起案中区分」＝”９”の場合
        if ("9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
            // （ａ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
        } else {
            // ②扱店別稟議データ「条変起案中区分」＝”９”以外の場合
            // （ａ）取得償還方法コード＝"1"の場合　　（元利均等償還）
            if ("1".equals(inDto.getCharCode_ShokanHouhou())) {
                // 更新用項目を設定する。（但し、退避用項目が空白の場合、更新用項目には"NULL"を設定する）
                // （ⅰ）退避賦金（非表示）⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
                // （ⅱ）退避元金不均等（非表示）⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
                // （ⅲ）退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
                // （ⅳ）退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
                // （Ⅴ）退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
                // （Ⅵ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            } else if ("2".equals(inDto.getCharCode_ShokanHouhou())) {
                // （ｂ）取得償還方法コード＝"2"（元金均等償還）
                // 更新用項目を設定する。
                // （ⅰ）退避賦金（非表示）⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
                // （ⅱ）退避元金不均等（非表示）⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
                // （ⅲ）退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
                // （ⅳ）退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
                // （Ⅴ）退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
                // （Ⅵ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            } else if ("3".equals(inDto.getCharCode_ShokanHouhou())
                    || "9".equals(inDto.getCharCode_ShokanHouhou())) {
                // （ｃ）取得償還方法コード＝"3" or "9"（定期償還・特殊償還）
                // 更新用項目を設定する。
                // （ⅰ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            }
        }
        // ④償還方法タイプ識別値 （DB更新時の受渡し領域）⇒更正（赤）データの償還方法タイプ識別値
        // ⑤現在の日付⇒報告年月日
        // 業務日付を取得
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        inDto.setID_Date_Report(pnBusinessDay);
        // ⑥現在の時刻⇒報告時分秒（非表示）
        inDto.setID_Time_Report(PNCommonComponents.getSysDateTime());
        // ⑦"1"⇒稟議データ更新フラグ
        inDto.setRingiRedFlg("1");

        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        AringiEntity inEntity3 = new AringiEntity();
        inEntity3.setID_Credit(inDto.getID_ID_Credit());
        inEntity3.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        long hitcount3 = aringidao.countByCondition(inEntity3);

        // （３）取得した件数＝０の場合、業務エラーとする。
        if (1 != hitcount3) {
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 扱店別稟議データを排他読込をする。
        // （５）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        AringiEntity inEntity4 = new AringiEntity();
        inEntity4.setID_Credit(inDto.getID_ID_Credit());
        try {
            AringiEntity outEntity4 = aringidao.findByPrimaryKeyForUpdate(inEntity4);

            if (null == outEntity4) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);

        }

        // （７）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        AringiEntity inEntity5 = new AringiEntity();
        inEntity5.setID_Credit(inDto.getID_ID_Credit());
        // ①償還タイプ＝"5" or "6"（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }

            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Keep_JohenKianchu()));
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else {
            // ③上記①② 以外の場合
            // （ａ）元金不均等額区分の設定
            // 更新用元金不均等区分（非表示）⇒aRingiEntity.元金不均等額区分
            inEntity5.setKubun_GankinFukintogaku(inDto.getID_Up_Kubun_GankinFukinto());
            // （ｂ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // （ｃ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            if (null != cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu())) {
                inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
            }
            // （ｄ）賦金の設定
            // 更新用賦金（非表示）⇒aRingiEntity.賦金
            if (null != inDto.getID_Up_M_Fukin()) {
                inEntity5.setM_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
            }
            // （ｅ）元金不均等額の設定
            // 更新用元金不均等（非表示）⇒aRingiEntity.元金不均等額
            if (null != inDto.getID_Up_M_GankinFukinto()) {
                inEntity5.setM_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_GankinFukinto()));
            }
            // （ｆ）貸付金残高の設定
            // 更新用貸付金残高（非表示）⇒aRingiEntity.貸付金残高
            if (null != inDto.getID_Up_M_KashitsukeZan()) {
                inEntity5.setM_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_KashitsukeZan()));
            }
            // （ｇ）償還期限年月の設定
            // 更新用償還期限年月（非表示）⇒aRingiEntity.償還期限年月
            if (null != cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen())) {
                inEntity5.setDate_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
            }
        }
        // 扱店別稟議データを更新をする。
        // （８）償還タイプの判定
        // ①償還タイプ＝"5" or "6"の場合
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(定期償還・特殊償還)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆修正)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else {
            // ③上記①②以外の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆取消)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // ３．請求データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        // （１）取得償還方法コード＝"1" or "2"の場合　　（元利均等償還・元金均等償還　の場合（払出のみは除く））
        if ("1".equals(inDto.getCharCode_ShokanHouhou()) || "2".equals(inDto.getCharCode_ShokanHouhou())) {
            // ①稟議・条変起案中区分（非表示）＜＞"9"の場合
            if (!"9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
                // （ａ）請求データを修正更新する場合のフラグ＝Ture の場合
                if (inDto.getFlgSeikyuUpTorikeshi()) {

                    // （ⅰ）更正（赤）データの値を設定しなおす。
                    // (ｱ)退避約定元金（非表示）＜＞"" AND 退避約定利息（非表示）＜＞"" の場合
                    if (null != inDto.getID_Keep_M_YakujoGankin()
                            && null != inDto.getID_Keep_M_YakujoRisoku()) {
                        // ・退避約定元金（非表示）⇒更新用約定元金（非表示）
                        inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                        // ・退避約定利息（非表示）⇒更新用約定利息（非表示）
                        inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                        // ・請求_取消用・払込年月日⇒請求データ更新用・Key:払込年月日_領域
                        inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto
                                .getID_Key_Date_Haraikomi_Seikyu_Torikeshi());
                    }
                    // 更新を行うデータの確認
                    // （ⅱ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                    SeikyuEntity inEntity6 = new SeikyuEntity();
                    inEntity6.setID_Credit(inDto.getID_ID_Credit());
                    inEntity6.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    long hitcount6 = seikyudao.countByCondition(inEntity6);
                    if (1 != hitcount6) {
                        // （ⅲ）取得した件数＝０の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        // （Ⅴ）取得した件数＞１の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                    }

                    // 請求データを排他読込をする。
                    // （Ⅵ）単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。

                    SeikyuEntity inEntity7 = new SeikyuEntity();
                    inEntity7.setID_Credit(inDto.getID_ID_Credit());
                    inEntity7.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    try {
                        SeikyuEntity outEntity7 = seikyudao.findByPrimaryKeyForUpdate(inEntity7);
                        //
                        if (null == outEntity7) {
                            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                        }
                        // // すでに更新されているかチェック処理を記述
                        //
                    } catch (CFWFindParameterException fpe) {
                        // // 検索条件値エラー
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        //
                    } catch (CFWForUpdateException fue) {
                        // （Ⅶ）)排他エラーの場合、業務エラーとする。
                        // エラーメッセージ：PTN001,DB007
                        // // 排他エラー
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                    }

                    // （Ⅷ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    SeikyuEntity inEntity8 = new SeikyuEntity();
                    inEntity8.setID_Credit(inDto.getID_ID_Credit());
                    inEntity8.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    // （ｱ）約定利息の設定
                    // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                    inEntity8.setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoRisoku()));
                    // （ｲ）約定元金の設定
                    // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                    inEntity8.setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoGankin()));
                    // 請求データを更新をする。
                    // Ⅸ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    try {
                        seikyudao.update(inEntity8);
                    } catch (CFWFindParameterException fpe) {
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        // 主キー更新時の一意性制約エラー
                    } catch (CFWDuplicateKeyException dke) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                    }
                }
            }
        }

        // ４．払出データの削除　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞを削除
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合
        List<String> checkList = Arrays.asList("0", "1", "2");
        if (checkList.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_Keep_ID_KeisuKanriShori());
            // 削除を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity9 = new HaraidashiEntity();
            inEntity9.setID_Credit(inDto.getKey_ID_Credit());
            inEntity9.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount9 = haraidashidao.countByCondition(inEntity9);
            if (1 != hitcount9) {
                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB009
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB004
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

            }

            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity10 = new HaraidashiEntity();
            inEntity10.setID_Credit(inDto.getKey_ID_Credit());
            inEntity10.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                HaraidashiEntity outEntity10 = haraidashidao.findByPrimaryKeyForUpdate(inEntity10);

                if (null == outEntity10) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PTN001,DB007
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }

            // 払出データを削除する。
            // ⑦単テーブルアクセス定義「払出データ　削除処理」を参照し、条件を設定する。
            HaraidashiEntity inEntity11 = new HaraidashiEntity();
            inEntity11.setID_Credit(inDto.getKey_ID_Credit());
            inEntity11.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                haraidashidao.delete(inEntity11);
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

            }
        }

        // ５．貸付受入金払出・充当報告書の該当レコードの削除　　※画面表示の対象となったﾚｺｰﾄﾞを削除
        // （１）更正（赤）データの値を設定しなおす。
        // ①報告書番号（非表示）⇒更正（赤）データの報告書番号
        // 削除を行うデータの確認
        // （２）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity12 = new UkeirereportEntity();
        inEntity12.setID_Report(inDto.getID_ID_Report());
        long hitcount12 = ukeirereportdao.countByCondition(inEntity12);
        if (1 != hitcount12) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

        }

        // 貸付受入金払出・充当報告書データを排他読込をする。
        // （５）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　排他読込」を参照し、条件を設定する。
        UkeirereportEntity inEntity13 = new UkeirereportEntity();
        inEntity13.setID_Report(inDto.getID_ID_Report());
        try {
            UkeirereportEntity outEntity13 = ukeirereportdao.findByPrimaryKeyForUpdate(inEntity13);

            if (null == outEntity13) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            //
        }

        // 貸付受入金払出・充当報告書データを削除する。
        // （７）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　削除処理」を参照し、条件を設定する。
        UkeirereportEntity inEntity14 = new UkeirereportEntity();
        inEntity14.setID_Report(inDto.getID_ID_Report());
        try {
            ukeirereportdao.delete(inEntity14);
        } catch (CFWFindParameterException fpe) {
            // // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // 取消内容のﾃﾞｰﾀに対するﾚｺｰﾄﾞの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う

        // ６．報告書履歴データの追加（取消用）
        // （１）取消前の稟議・請求（約定）の値を退避領域に入れる
        // ①""⇒更新用賦金（非表示）
        inDto.setID_Up_M_Fukin(null);
        // ②""⇒更新用元金不均等（非表示）
        inDto.setID_Up_M_GankinFukinto(null);
        // ③""⇒更新用元金不均等区分（非表示）
        inDto.setID_Up_Kubun_GankinFukinto("");
        // ④""⇒更新用貸付金残高（非表示）
        inDto.setID_Up_M_KashitsukeZan(null);
        // ⑤""⇒更新用償還期限年月（非表示）
        inDto.setID_Up_Date_ShokanKigen("");
        // ⑥""⇒更新用約定利息（非表示）
        inDto.setID_Up_M_YakujoRisoku(null);
        // ⑦""⇒更新用約定元金（非表示）
        inDto.setID_Up_M_YakujoGankin(null);
        // ⑧""⇒更新用条変起案中区分（非表示）
        inDto.setID_Up_Kubun_JohenKianchu("");

        // （ａ）履歴番号の再取得および登録値として再設定する。
        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String newID_History = pnCommonDBComponents.getIdHistoryRh();
        // （ｂ）処理モードが処理完了以外：削除以外の場合

        // （３）報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
        // ①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity inEntity15 = new ReporthistoryEntity();
        // ・更正（赤）データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity15.setID_History(cnvBlankToNull(newID_History));
        // ・更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity15.setID_Report("");
        // ・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity15.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity15.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・更正（赤）データのステータス⇒ReporthistoryEntity.ステータス
        inEntity15.setStatus(new BigDecimal("2"));
        // ・更正（赤）データのデータコード⇒ReporthistoryEntity.データコード
        inEntity15.setDataCode(inDto.getID_Data_Code());
        // ・更正（赤）データの処理種別⇒ReporthistoryEntity.処理種別
        inEntity15.setType_Process("10");
        // ・更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity15.setFlag_Torikeshizumi(BigDecimal.ONE);
        // ・更正（赤）データのユーザID⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity15.setUserID(pnCommonInfo.getLogonID());
        // ・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity15.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity15.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity15.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        inEntity15.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        inEntity15.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒ReporthistoryEntity.年度
        inEntity15.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity15.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒ReporthistoryEntity.番号
        inEntity15.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        inEntity15.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
        // ・更正（赤）データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity15.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・更正（赤）データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity15.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        // ・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity15.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity15.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity15
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity15.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity15
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity15.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity15.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity15.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity15.setKeep_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        // ・NULL⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity15.setKeep_ID_History(null);
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。

        try {
            reporthistorydao.insert(inEntity15);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        return outDto;
    }

    /**
     * Md002_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO updateDataProcEndDel(Md002_02DTO inDto) {

        Md002_02DTO outDto = new Md002_02DTO();

        // 取消：処理完了の更新処理。
        // 　＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // １．報告書履歴データのレコードを更新　　※画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        // （１）更正（赤）データの値を設定しなおす。
        // ①"1"⇒更正（赤）データの取消済フラグ
        inDto.setID_Flag_Torikeshizumi(BigDecimal.ONE);
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        long hitcount = reporthistorydao.countByCondition(inEntity);

        if (1 != hitcount) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity1 = new ReporthistoryEntity();
        inEntity1.setID_History(inDto.getID_ID_History());
        try {
            ReporthistoryEntity outEntity1 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity1);

            if (null == outEntity1) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        inEntity2.setID_History(inDto.getID_ID_History());
        // ②取消：処理完了以外（更正（赤））以外の場合
        // （ａ）更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity2.setID_Report(cnvBlankToNull(inDto.getID_ID_Report()));
        // （ｂ）更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity2.setFlag_Torikeshizumi(inDto.getID_Flag_Torikeshizumi());

        // 報告書履歴データを更新をする。
        // （８）単テーブルアクセス定義「報告書履歴データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
        try {
            reporthistorydao.update(inEntity2);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }
        // ２．扱店別稟議データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの貸付金残高、償還期限年月をデータ取得時の値で更新
        // （１）更正（赤）データの値を設定しなおす。
        // ①取得償還方法コード＝"1"の場合　　（元利均等償還）
        if ("1".equals(inDto.getCharCode_ShokanHouhou())) {
            // （ａ）""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // （ｂ）""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // （ｃ）""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(null);
            // （ｄ）""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // （ｅ）""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
            // （ｆ）"9"⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu("9");
        } else if ("2".equals(inDto.getCharCode_ShokanHouhou())
                || "0".equals(inDto.getCharCode_ShokanHouhou())) {
            // ②取得償還方法コード＝"0" or "2"の場合　　（払出のみ、元金均等償還）
            // （ａ）退避賦金（非表示）⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
            // （ｂ）退避元金不均等（非表示）⇒更新用元金不均等（非表示
            inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
            // （ｃ）退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
            // （ｄ）退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
            // （ｅ）退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
            // （ｆ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            // ③取得償還方法コード＝"3" or "9"の場合　　（定期償還・特殊償還）
        } else if ("3".equals(inDto.getCharCode_ShokanHouhou())
                || "9".equals(inDto.getCharCode_ShokanHouhou())) {
            // （ａ）"9"⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu("9");
        }
        // ④償還方法タイプ識別値 （DB更新時の受渡し領域）⇒更正（赤）データの償還方法タイプ識別値
        // ⑤現在の日付⇒更正（赤）データの報告年月日
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        inDto.setID_Date_Report(pnBusinessDay);
        // ⑥現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(PNCommonComponents.getSysDateTime());
        // ⑦"1"⇒稟議データ更新フラグ
        // 更新を行うデータの確認
        inDto.setRingiRedFlg("1");
        // （２）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        AringiEntity inEntity3 = new AringiEntity();
        inEntity3.setID_Credit(inDto.getID_ID_Credit());
        inEntity3.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        long hitcount3 = aringidao.countByCondition(inEntity3);

        if (1 != hitcount3) {
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 扱店別稟議データを排他読込をする。
        // （５）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        AringiEntity inEntity4 = new AringiEntity();
        inEntity4.setID_Credit(inDto.getID_ID_Credit());
        try {
            AringiEntity outEntity4 = aringidao.findByPrimaryKeyForUpdate(inEntity4);

            if (null == outEntity4) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);

        }
        // （７）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        AringiEntity inEntity5 = new AringiEntity();
        inEntity5.setID_Credit(inDto.getID_ID_Credit());
        // ①償還タイプ＝"5" or "6"（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else {
            // ③上記①② 以外の場合
            // （ａ）元金不均等額区分の設定
            // 更新用元金不均等区分（非表示）⇒aRingiEntity.元金不均等額区分
            inEntity5.setKubun_GankinFukintogaku(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
            // （ｂ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity5.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｃ）条変起案中区分の設定
            if (null != cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu())) {
                // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
                inEntity5.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
            }
            // （ｄ）賦金の設定
            if (null != inDto.getID_Up_M_Fukin()) {
                // 更新用賦金（非表示）⇒aRingiEntity.賦金
                inEntity5.setM_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
            }
            // （ｅ）元金不均等額の設定
            if (null != inDto.getID_Up_M_GankinFukinto()) {
                // 更新用元金不均等（非表示）⇒aRingiEntity.元金不均等額
                inEntity5.setM_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_GankinFukinto()));
            }
            // （ｆ）貸付金残高の設定
            if (null != inDto.getID_Up_M_KashitsukeZan()) {
                // 更新用貸付金残高（非表示）⇒aRingiEntity.貸付金残高
                inEntity5.setM_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_KashitsukeZan()));
            }
            // （ｇ）償還期限年月の設定
            if (null != cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen())) {
                // 更新用償還期限年月（非表示）⇒aRingiEntity.償還期限年月
                inEntity5.setDate_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
            }
        }

        // 扱店別稟議データを更新をする。
        // （８）償還タイプの判定
        // ①償還タイプ＝"5" or "6"の場合
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(定期償還・特殊償還)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆修正)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else {
            // ③上記①②以外の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆取消)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity5);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // ３．請求データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        // （１）取得償還方法コード＝"0" or "2"の場合　　（払出のみ、元金均等償還の場合のみ）
        if ("0".equals(inDto.getCharCode_ShokanHouhou()) || "2".equals(inDto.getCharCode_ShokanHouhou())) {

            // ①請求データを修正更新する場合のフラグ＝Ture の場合
            if (inDto.getFlgSeikyuUpTorikeshi()) {

                // （ａ）更正（赤）データの値を設定しなおす。
                // （ⅰ）退避約定元金（非表示）⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                // （ⅱ）退避約定利息（非表示）⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                // （ⅲ）請求_取消用・払込年月日⇒請求データ更新用・Key:払込年月日_領域
                inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getID_Key_Date_Haraikomi_Seikyu_Torikeshi());
                // 更新を行うデータの確認
                // （ｂ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                SeikyuEntity inEntity6 = new SeikyuEntity();
                inEntity6.setID_Credit(inDto.getID_ID_Credit());
                inEntity6.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                long hitcount6 = seikyudao.countByCondition(inEntity6);
                if (1 != hitcount6) {
                    // （ｃ）取得した件数＝０の場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB011
                    // （ｅ）取得した件数＞１の場合、業務エラーとする。
                    // エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                }

                SeikyuEntity inEntity7 = new SeikyuEntity();
                inEntity7.setID_Credit(inDto.getID_ID_Credit());
                inEntity7.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                try {
                    SeikyuEntity outEntity7 = seikyudao.findByPrimaryKeyForUpdate(inEntity7);
                    //
                    if (null == outEntity7) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // // すでに更新されているかチェック処理を記述
                    //
                } catch (CFWFindParameterException fpe) {
                    // // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    //
                } catch (CFWForUpdateException fue) {
                    // （ｇ）)排他エラーの場合、業務エラーとする。
                    // エラーメッセージ：PM9010E
                    // // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                }

                // （ｈ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                SeikyuEntity inEntity8 = new SeikyuEntity();
                inEntity8.setID_Credit(inDto.getID_ID_Credit());
                inEntity8.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                // （ⅰ）約定利息の設定
                // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                inEntity8
                        .setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
                // （ⅱ）約定元金の設定
                // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                inEntity8
                        .setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
                // 請求データを更新をする。
                // （ｉ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                try {
                    seikyudao.update(inEntity8);
                } catch (CFWFindParameterException fpe) {
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    // 主キー更新時の一意性制約エラー
                } catch (CFWDuplicateKeyException dke) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                }

            }
        }
        // ４．払出データの更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞを更新
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合
        List<String> checkList = Arrays.asList("0", "1", "2");
        if (checkList.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_Keep_ID_KeisuKanriShori());
            // 更新を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity9 = new HaraidashiEntity();
            inEntity9.setID_Credit(inDto.getKey_ID_Credit());
            inEntity9.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount9 = haraidashidao.countByCondition(inEntity9);
            if (1 != hitcount9) {

                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：PM9010E
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

            }
            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity10 = new HaraidashiEntity();
            inEntity10.setID_Credit(inDto.getKey_ID_Credit());
            inEntity10.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                HaraidashiEntity outEntity10 = haraidashidao.findByPrimaryKeyForUpdate(inEntity10);

                if (null == outEntity10) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PM9010E
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }
            // }

            // ⑦払出データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
            HaraidashiEntity inEntity11 = new HaraidashiEntity();
            inEntity11.setID_Credit(inDto.getKey_ID_Credit());
            inEntity11.setID_KeisuKanriShori(cnvBlankToNull(inDto.getKey_ID_KeisuKanriShori()));

            // （ａ）更正処理区分の設定
            // "1"⇒更正処理区分
            inEntity11.setKubun_KoseiShori("1");

            // ⑧単テーブルアクセス定義「払出データ　更新処理」を参照し、条件を設定する。
            // HaraidashiDAO.updata
            try {
                haraidashidao.update(inEntity11);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // 取消内容のﾃﾞｰﾀに対するﾚｺｰﾄﾞの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う

        // ５．履歴データの追加　　**現在のＤＢの値を退避領域に設定
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　（払出のみ、元利均等償還・元金均等償還）
        List<String> checkList2 = Arrays.asList("0", "1", "2");
        if (checkList2.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①稟議・賦金（非表示）⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_M_Fukin_Ringi());
            // ②稟議・元金不均等（非表示）⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(inDto.getID_M_GankinFukinto_Ringi());
            // ③稟議・元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Kubun_GankinFukinto_Ringi());
            // ④稟議・貸付金残高（非表示）⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getID_M_KashitsukeZan_Ringi());
            // ⑤稟議・償還期限年月（非表示）⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Date_ShokanKigen_Ringi());
            // ⑥稟議・条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu_Ringi());
            // ⑦請求_取消用・約定利息＝"" ＡＮＤ 請求_取消用・約定元金＝"" の場合
            if (null == inDto.getID_M_YakujoRisoku_Seikyu_Torikeshi()
                    && null == inDto.getID_M_YakujoGankin_Seikyu_Torikeshi()) {
                // （ａ）""⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(null);
                // （ｂ）""⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(null);
            } else {
                // ⑧（請求_取消用・約定利息＝"" ＡＮＤ 請求_取消用・約定元金＝""） 以外の場合
                // （ａ）請求_取消用・約定利息⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_M_YakujoRisoku_Seikyu_Torikeshi());
                // （ｂ）請求_取消用・約定元金⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_M_YakujoGankin_Seikyu_Torikeshi());
            }
            // ⑨報告書履歴番号（非表示）⇒報告書履歴番号（非表示）
            inDto.setID_ID_History(inDto.getID_ID_History());
        } else if ("3".equals(inDto.getCharCode_ShokanHouhou())
                || "9".equals(inDto.getCharCode_ShokanHouhou())) {
            // （２）取得償還方法コード＝"3" or "9"の場合　　（定期償還、特殊償還）
            // ①""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // ②""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // ③""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto("");
            // ④""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ⑤""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
            // ⑥""⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(null);
            // ⑦""⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(null);
            // ⑧稟議・条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu_Ringi());
            // ⑨報告書履歴番号（非表示）⇒報告書履歴番号（非表示）
            inDto.setID_ID_History(inDto.getID_ID_History());
        }

        // ②取得した件数＞０の場合
        // （ａ）履歴番号の再取得および登録値として再設定する。
        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        // （ｂ）処理モードが処理完了以外：削除以外の場合
        // 報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
        // 報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、「報告書番号保持」を取得する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();

        // （４）取得した件数＝０の場合、データの追加処理を行う。
        // ①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity inEntity12 = new ReporthistoryEntity();
        // ・更正（赤）データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity12.setID_History(cnvBlankToNull(strID_History));
        // ・更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity12.setID_Report(cnvBlankToNull(strID_Report));
        // ・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity12.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity12.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・更正（赤）データのステータス⇒ReporthistoryEntity.ステータス
        inEntity12.setStatus(BigDecimal.ONE);
        // ・更正（赤）データのデータコード⇒ReporthistoryEntity.データコード
        inEntity12.setDataCode("90257021");
        // ・更正（赤）データの処理種別⇒ReporthistoryEntity.処理種別
        inEntity12.setType_Process("10");
        // ・更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity12.setFlag_Torikeshizumi(BigDecimal.ZERO);
        // ・更正（赤）データのユーザID⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity12.setUserID(pnCommonInfo.getLogonID());
        // ・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity12.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity12.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity12.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        inEntity12.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        inEntity12.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒ReporthistoryEntity.年度
        inEntity12.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity12.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒ReporthistoryEntity.番号
        inEntity12.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        inEntity12.setID_RingiBranch(PNCommonComponents.cnvNulltoZero((inDto.getLblID_ID_RingiBranch_Red())));
        // ・更正（赤）データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity12.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・更正（赤）データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity12.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        // ・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity12.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity12.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity12
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity12.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity12
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity12.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity12.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity12.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity12.setKeep_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        // ・報告書履歴番号（非表示）⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity12.setKeep_ID_History(cnvBlankToNull(inDto.getID_ID_History()));
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        try {
            reporthistorydao.insert(inEntity12);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ６．貸付受入金払出・充当報告書データの追加（更正（赤））
        // 追加を行うデータの確認
        // （１）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity13 = new UkeirereportEntity();
        inEntity13.setID_Report(strID_Report);

        long hitcount13 = ukeirereportdao.countByCondition(inEntity13);
        if (0 < hitcount13) {
            // （２）取得した件数＞＝１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

        }

        // （３）貸付受入金払出・充当報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        UkeirereportEntity inEntity9 = new UkeirereportEntity();

        // ・更正（赤）データの扱店名⇒UkeireReportEntity.扱店名
        inEntity9.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒UkeireReportEntity.顧客名
        inEntity9.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの貸付実行日⇒UkeireReportEntity.貸付実行日
        inEntity9.setDate_Jikko(inDto.getLblID_Date_Jikko_Red());
        // ・更正（赤）データの公庫支店⇒UkeireReportEntity.公庫支店コード
        inEntity9.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒UkeireReportEntity.扱店コード
        inEntity9.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒UkeireReportEntity.店舗コード
        inEntity9.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒getLblID_Year_Red.年度
        inEntity9.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.方式資金
        inEntity9.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒UkeireReportEntity.稟議番号
        inEntity9.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒UkeireReportEntity.稟議番号枝番
        inEntity9.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
        // ・更正（赤）データの資金使途⇒UkeireReportEntity.資金使途コード
        inEntity9.setCode_ShikinShito(cnvBlankToNull(inDto.getLblID_Code_ShikinShito_Red()));
        // ・更正（赤）データの事業別⇒UkeireReportEntity.事業別コード
        inEntity9.setCode_Jigyobetsu(cnvBlankToNull(inDto.getLblID_Code_Jigyobetsu_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.特利区分
        inEntity9.setCode_TokuriKubun(cnvBlankToNull(inDto.getLblID_Code_TokuriKubun_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.特利
        inEntity9.setTokuri(cnvMultiply1000(inDto.getLblID_Tokuri_Red()));
        // ・更正（赤）データの利率⇒UkeireReportEntity.利率
        inEntity9.setRiritsu(cnvMultiply1000(inDto.getLblID_Riritsu_Red()));
        // ・更正（赤）データの償還期限⇒UkeireReportEntity.償還期限
        inEntity9.setDate_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen_Red()));
        // ・更正（赤）データの据置期限⇒UkeireReportEntity.据置期限
        inEntity9.setDate_SueokiKigen(cnvBlankToNull(inDto.getLblID_Date_SueokiKigen_Red()));
        // ・更正（赤）データの元利金払込期日⇒UkeireReportEntity.元利金払込日
        String[] date = PNCommonComponents.cnvNulltoBlank(inDto.getLblID_Date_GanrikinHaraikomi_Red()).split(
                "\\.");
        if (1 < date.length) {
            date[0] = String.format("%1$02d", Integer.parseInt(date[0]));
            date[1] = String.format("%1$02d", Integer.parseInt(date[1]));
        }
        inEntity9
                .setDate_GanrikinHaraikomi(cnvBlankToNull(PNCommonComponents.concatString(date[0], date[1])));
        // ・更正（赤）データの貸付実行額金額⇒UkeireReportEntity.貸付実行金額
        inEntity9.setM_Kashitsuke(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Kashitsuke_Red()));
        // ・更正（赤）データの伝送番号（非表示）⇒UkeireReportEntity.伝送番号
        inEntity9.setID_Denso(cnvBlankToNull(inDto.getID_ID_Denso()));
        // ・西暦に変換した更正（赤）データの受託者勘定処理年月⇒UkeireReportEntity.受託者勘定処理年月
        inEntity9.setDate_Jtkshori(cnvBlankToNull(inDto.getLblID_Date_Jtkshori_Red()));
        // ・西暦に変換した更正（赤）データの元金充当後第１回約定日⇒UkeireReportEntity.元金充当後第１回約定日
        inEntity9.setDate_FirstYakujoAfterGanju(cnvBlankToNull(inDto
                .getLblID_Date_FirstYakujoAfterGanju_Red()));
        // ・西暦に変換した更正（赤）データの払出・元金充当日⇒UkeireReportEntity.払出元金充当日
        inEntity9.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getLblID_Date_HaraidashiJuto_Red()));
        // ・更正（赤）データの繰上償還事由コード⇒UkeireReportEntity.繰上償還事由コード
        inEntity9.setCode_KurishoJiyu(cnvBlankToNull(inDto.getLblID_Code_KurishoJiyu_Red()));
        // ・更正（赤）データの元金充当額⇒UkeireReportEntity.元金充当額
        inEntity9.setM_Ganju(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Ganju_Red()));
        // ・更正（赤）データの合計（非表示）⇒UkeireReportEntity.合計
        inEntity9.setM_Kei(PNCommonComponents.cnvNulltoZero(inDto.getID_M_Kei_Red()));
        // ・更正（赤）データの元金充当後貸付金残高⇒UkeireReportEntity.元金充当後貸付金残高
        inEntity9.setM_KashitsukeZandakaAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeZandakaAfterGanju_Red()));
        // ・更正（赤）データの元金充当後の元金均等額⇒UkeireReportEntity.元金充当後元金均等額
        inEntity9.setM_GankinKintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinKintoAfterGanju_Red()));
        // ・更正（赤）データの元金充当後の元金不均等額⇒UkeireReportEntity.元金充当後元金不均等額
        inEntity9.setM_GankinFukintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinFukintoAfterGanju_Red()));
        // ・更正（赤）データの調整コード⇒UkeireReportEntity.調整コード
        inEntity9.setCode_Chosei(cnvBlankToNull(inDto.getRdoID_Code_Chosei_Red()));
        // ・更正（赤）データの報告書番号（非表示）⇒UkeireReportEntity.報告書番号
        inEntity9.setID_Report(cnvBlankToNull(strID_Report));
        // ・更正（赤）データの報告年月日⇒UkeireReportEntity.報告年月日
        inEntity9.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・更正（赤）データの報告時分秒（非表示）⇒UkeireReportEntity.報告時分秒
        inEntity9.setTime_Report(cnvBlankToNull(inDto.getID_Time_Report().replaceAll(":", "")));
        // ・更正（赤）データのユーザID（非表示）⇒UkeireReportEntity.ユーザID
        inEntity9.setUserID(pnCommonInfo.getLogonID());
        // ・9025702⇒UkeireReportEntity.データコード
        inEntity9.setDataCode("90257021");
        // ・更正（赤）データの貸付受入金受入額⇒UkeireReportEntity.貸付受入金受入額
        inEntity9.setM_KashitsukeUkeire(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeUkeire_Red()));
        // ・更正（赤）データの資金交付額⇒UkeireReportEntity.資金交付額
        inEntity9.setM_ShikinKofu(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_ShikinKofu_Red()));
        // ・更正（赤）データの資金払出額⇒UkeireReportEntity.資金払出額
        inEntity9.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Haraidashi_Red()));
        // ・更正（赤）データの貸付受入金残高⇒UkeireReportEntity.貸付受入金残高
        inEntity9.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeukeireZan_Red()));
        // 貸付受入金払出・充当報告書データを追加する。
        // （４）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　登録処理」を参照し、条件を設定する。
        // UkeireReportDAO.insert
        try {
            ukeirereportdao.insert(inEntity9);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ７．払出データの追加（更正（赤））　　※ 画面表示の対象となった案件の更正赤用のﾚｺｰﾄﾞのを追加
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　（払出のみ、元利均等償還・元金均等償還）
        List<String> checkList3 = Arrays.asList("0", "1", "2");
        if (checkList3.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①追加する値を設定
            // （ａ）保存・取消１用・払出データ項目の取消用払出・債権管理番号⇒取消用払出・債権管理番号
            inDto.setID_HDDel1_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）"99999990001"⇒取消用払出・計数管理処理番号
            inDto.setID_HDDel1_KeisuKanriShori("99999990001");
            // （ｃ）保存・取消１用・払出データ項目の取消用払出・払出充当年月日⇒取消用払出・払出充当年月日
            inDto.setID_HDDel1_Date_HaraidashiJuto(inDto.getID_HDDel1_Keep_Date_HaraidashiJuto());

            // （ｄ）０－保存・取消１用・払出データ項目の取消用払出・払出額⇒取消用払出・払出額
            inDto.setID_HDDel1_M_Haraidashi(BigDecimal.ZERO.subtract(inDto.getID_HDDel1_Keep_M_Haraidashi()));

            // （ｅ）０－保存・取消１用・払出データ項目の取消用払出・繰上償還額⇒取消用払出・繰上償還額
            inDto.setID_HDDel1_M_Kurisho(BigDecimal.ZERO.subtract(inDto.getID_HDDel1_Keep_M_Kurisho()));

            // （ｆ）保存・取消１用・払出データ項目の取消用払出・貸付受入金残高
            // ＋保存・取消１用・払出データ項目の取消用払出・払出額
            // ＋保存・取消１用・払出データ項目の取消用払出・繰上償還額
            // ⇒取消用払出・貸付受入金残高
            inDto.setID_HDDel1_M_HaraidashiKashitsukeZan(inDto.getID_HDDel1_Keep_M_HaraidashiKashitsukeZan()
                    .add(inDto.getID_HDDel1_Keep_M_Haraidashi().add(inDto.getID_HDDel1_Keep_M_Kurisho())));

            // （ｇ）保存・取消１用・払出データ項目の取消用払出・払出累計額
            // －保存・取消１用・払出データ項目の取消用払出・払出額
            // ⇒取消用払出・払出累計額
            inDto.setID_HDDel1_M_HaraidashiRuikei(inDto.getID_HDDel1_Keep_M_HaraidashiRuikei().subtract(
                    inDto.getID_HDDel1_Keep_M_Haraidashi()));

            // （ｈ）保存・取消１用・払出データ項目の取消用払出・繰上償還累計額
            // －保存・取消１用・払出データ項目の取消用払出・繰上償還額
            // ⇒取消用払出・繰上償還累計額
            inDto.setID_HDDel1_M_KurishoRuikei(inDto.getID_HDDel1_Keep_M_KurishoRuikei().subtract(
                    inDto.getID_HDDel1_Keep_M_Kurisho()));

            // （ｉ）"2"⇒取消用払出・更生処理区分
            inDto.setID_HDDel1_Kubun_KoseiShori("2");

            // （ｊ）０ －保存・取消１用・払出データ項目の取消用払出・貸付受入金残高積数⇒取消用払出・貸付受入金残高積数
            inDto.setID_HDDel1_M_ZandakaSekisu(BigDecimal.ZERO.subtract(inDto
                    .getID_HDDel1_Keep_M_ZandakaSekisu()));

            // （ｋ）保存・取消１用・払出データ項目の取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());

            // （ｌ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_KeisuKanriShori());
            // 追加を行うデータの確認
            // （１）単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity11 = new HaraidashiEntity();
            // 債権管理番号
            inEntity11.setID_Credit(inDto.getID_ID_Credit());
            // 計数管理処理番号
            inEntity11.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount4 = haraidashidao.countByCondition(inEntity11);

            if (0 < hitcount4) {
                // （２）取得した件数＞＝１の場合、業務エラーとする。
                // エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            HaraidashiEntity inEntity14 = new HaraidashiEntity();
            // （３）払出データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // ①追加する値を設定
            // （ａ）更正（赤）データの債権管理番号（非表示）⇒HaraidashiEntity.債権管理番号
            inEntity14.setID_Credit(inDto.getID_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒HaraidashiEntity.計数管理処理番号
            inEntity14.setID_KeisuKanriShori(cnvBlankToNull(inDto.getID_HDDel1_KeisuKanriShori()));
            // （ｃ）取消用払出・払出額⇒HaraidashiEntity.払出額
            inEntity14.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getID_HDDel1_M_Haraidashi()));
            // （ｄ）取消用払出・払出累計額⇒HaraidashiEntity.払出累計額
            inEntity14.setM_HaraidashiRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_HaraidashiRuikei()));
            // （ｅ）取消用払出・繰上償還額⇒HaraidashiEntity.繰上償還額
            inEntity14.setM_Kurisho(PNCommonComponents.cnvNulltoZero(inDto.getID_HDDel1_M_Kurisho()));
            // （ｆ）取消用払出・繰上償還累計額⇒HaraidashiEntity.繰上償還累計額
            inEntity14.setM_KurishoRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_KurishoRuikei()));
            // （ｇ）取消用払出・更生処理区分⇒HaraidashiEntity.更正処理区分
            inEntity14.setKubun_KoseiShori(inDto.getID_HDDel1_Kubun_KoseiShori());
            // （ｈ）取消用払出・貸付受入金残高積数⇒HaraidashiEntity.貸付受入金残高積数
            inEntity14.setM_ZandakaSekisu(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_ZandakaSekisu()));
            // （ｉ）取消用払出・払出充当年月日⇒HaraidashiEntity.払出充当年月日
            inEntity14.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getID_HDDel1_Date_HaraidashiJuto()));
            // （ｊ）取消用払出・貸付受入金残高⇒HaraidashiEntity.貸付受入金残高
            inEntity14.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_HaraidashiKashitsukeZan()));
            // 払出データを追加する。
            // （４）単テーブルアクセス定義「払出データ　登録処理」を参照し、条件を設定する。
            try {
                haraidashidao.insert(inEntity14);
            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }

        }

        return outDto;
    }

    /**
     * Md002_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO updateDataNotProcEndMod(Md002_02DTO inDto) {

        Md002_02DTO outDto = new Md002_02DTO();

        // 修正：処理完了以外の更新処理。
        // 　＜取得したﾚｺｰﾄﾞに対する取消処理＞

        // １．報告書履歴データのレコードを更新　　※更正（赤）画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        // （１）更正（赤）データの値を設定しなおす。
        // ③現在の日付⇒更正（赤）データの報告年月日
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        inDto.setID_Date_Report(pnBusinessDay);
        // ④現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(PNCommonComponents.getSysDateTime());
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        long hitcount = reporthistorydao.countByCondition(inEntity);

        if (1 != hitcount) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PTN001,DB007
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB004
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity1 = new ReporthistoryEntity();
        inEntity1.setID_History(inDto.getID_ID_History());
        try {
            ReporthistoryEntity outEntity1 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity1);

            if (null == outEntity1) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        inEntity2.setID_History(inDto.getID_ID_History());
        // ①取消：処理完了以外（更正（赤））の場合
        // ②取消：処理完了以外（更正（赤））以外の場合
        // ①""⇒更正（赤）データの報告書番号（非表示）
        // ②"1"⇒更正（赤）データの取消済みフラグ（非表示）
        // （ａ）更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity2.setID_Report("");
        // （ｂ）更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity2.setFlag_Torikeshizumi(BigDecimal.ONE);
        // 報告書履歴データを更新をする。
        try {
            reporthistorydao.update(inEntity2);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ２．貸付受入金払出・充当報告書の該当レコードの削除
        // （１）更正（赤）データの値を設定しなおす。
        // ①報告書番号（非表示）⇒更正（赤）データの報告書番号
        // 削除を行うデータの確認
        // （２）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity3 = new UkeirereportEntity();
        inEntity3.setID_Report(inDto.getID_ID_Report());
        long hitcount3 = ukeirereportdao.countByCondition(inEntity3);
        if (1 != hitcount3) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB009
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB004
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 貸付受入金払出・充当報告書データを排他読込をする。
        // （５）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　排他読込」を参照し、条件を設定する。
        try {
            UkeirereportEntity outEntity4 = ukeirereportdao.findByPrimaryKeyForUpdate(inEntity3);

            if (null == outEntity4) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PTN001,DB007
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            //
        }

        // 貸付受入金払出・充当報告書データを削除する。
        // （７）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　削除処理」を参照し、条件を設定する。
        UkeirereportEntity inEntity4 = new UkeirereportEntity();
        inEntity4.setID_Report(inDto.getID_ID_Report());
        try {
            ukeirereportdao.delete(inEntity4);
        } catch (CFWFindParameterException fpe) {
            // // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // ４．請求データのレコードﾞを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　　（払出のみ・元利均等償還・元金均等償還）
        List<String> checkList = Arrays.asList("0", "1", "2");
        if (checkList.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①稟議・条変起案中区分（非表示）＜＞"9"の場合
            if (!"9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
                // （ａ）請求データを修正更新する場合のフラグ＝Ture の場合
                if (inDto.getFlgSeikyuUpTorikeshi()) {
                    // （ⅰ）更正（赤）データの値を設定しなおす。
                    // (ｱ)退避約定元金（非表示）⇒更新用約定元金（非表示）
                    inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                    // (ｲ)退避約定利息（非表示）⇒更新用約定利息（非表示）
                    inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                    // (ｳ)請求_取消用・払込年月日⇒請求データ更新用・Key:払込年月日_領域
                    inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getID_Key_Date_Haraikomi_Seikyu_Torikeshi());
                    // 更新を行うデータの確認
                    // （ⅱ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                    SeikyuEntity inEntity8 = new SeikyuEntity();
                    inEntity8.setID_Credit(inDto.getID_ID_Credit());
                    inEntity8.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    long hitcount8 = seikyudao.countByCondition(inEntity8);
                    if (1 != hitcount8) {
                        // （ⅲ）取得した件数＝０の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        // （Ⅴ）取得した件数＞１の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                    }
                    SeikyuEntity inEntity9 = new SeikyuEntity();
                    inEntity9.setID_Credit(inDto.getID_ID_Credit());
                    inEntity9.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    try {
                        SeikyuEntity outEntity9 = seikyudao.findByPrimaryKeyForUpdate(inEntity9);
                        //
                        if (null == outEntity9) {
                            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                        }
                        // // すでに更新されているかチェック処理を記述
                        //
                    } catch (CFWFindParameterException fpe) {
                        // // 検索条件値エラー
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        //
                    } catch (CFWForUpdateException fue) {
                        // （Ⅶ）)排他エラーの場合、業務エラーとする。
                        // エラーメッセージ：PTN001,DB007
                        // // 排他エラー
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                    }
                    //
                    // （Ⅷ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    SeikyuEntity inEntity10 = new SeikyuEntity();
                    inEntity10.setID_Credit(inDto.getID_ID_Credit());
                    inEntity10.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    // （ｱ）約定利息の設定
                    // 　　更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                    inEntity10.setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoRisoku()));
                    // （ｲ）約定元金の設定
                    // 　　更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                    inEntity10.setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoGankin()));
                    // 請求データを更新をする。
                    // （Ⅸ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    try {
                        seikyudao.update(inEntity10);
                    } catch (CFWFindParameterException fpe) {
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        // 主キー更新時の一意性制約エラー
                    } catch (CFWDuplicateKeyException dke) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                    }
                }
            }
        }

        // ５．払出データの削除　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞを削除
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合
        List<String> checkList2 = Arrays.asList("0", "1", "2");
        if (checkList2.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_Keep_ID_KeisuKanriShori());
            // 削除を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity11 = new HaraidashiEntity();
            inEntity11.setID_Credit(inDto.getKey_ID_Credit());
            inEntity11.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount11 = haraidashidao.countByCondition(inEntity11);
            if (1 != hitcount11) {
                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB009
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB004
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

            }
            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity12 = new HaraidashiEntity();
            inEntity12.setID_Credit(inDto.getKey_ID_Credit());
            inEntity12.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {

                HaraidashiEntity outEntity12 = haraidashidao.findByPrimaryKeyForUpdate(inEntity12);

                if (null == outEntity12) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PTN001,DB007
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }
            // 払出データを削除する。
            // ⑦単テーブルアクセス定義「払出データ　削除処理」を参照し、条件を設定する。
            HaraidashiEntity inEntity13 = new HaraidashiEntity();
            inEntity13.setID_Credit(inDto.getKey_ID_Credit());
            inEntity13.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                haraidashidao.delete(inEntity13);
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

            }
        }

        // ◇◆◇◆◇-- 修正データの登録 --◇◆◇◆◇　　※ここからは修正データの処理

        // ６．報告書履歴データの追加
        // （１）稟議・条変起案中区分（非表示）＝"9"の場合
        if ("9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
            // ①""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // ②""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // ③""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(null);
            // ④""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ⑤""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
            // ⑥""⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(null);
            // ⑦""⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(null);
            // ⑧退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
        } else {
            // （２）稟議・条変起案中区分（非表示）＝"9"以外の場合
            // ①償還方法タイプ識別値＝"0" or "1" or "2" or "3" or "4"の場合
            List<String> checkList3 = Arrays.asList("0", "1", "2", "3", "4");
            if (checkList3.contains(inDto.getType_Shokan())) {
                // （ａ）退避賦金（非表示）⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
                // （ｂ）退避元金不均等（非表示）⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
                // （ｃ）退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
                // （ｄ）退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
                // （ｅ）退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
                // （ｆ）退避約定利息（非表示）⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                // （ｇ）退避約定元金（非表示）⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                // （ｈ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            }
            // ②償還方法タイプ識別値＝"5" or "6"の場合
            if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
                // （ａ）""⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(null);
                // （ｂ）""⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(null);
                // （ｃ）""⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto("");
                // （ｄ）""⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(null);
                // （ｅ）""⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen("");
                // （ｆ）""⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(null);
                // （ｇ）""⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(null);
                // （ｈ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            }
        }

        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        // （ｂ）処理モードが処理完了以外：削除以外の場合
        // 報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();

        // ①報告書履歴データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity inEntity14 = new ReporthistoryEntity();
        // ・修正データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity14.setID_History(cnvBlankToNull(strID_History));
        // ・修正データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity14.setID_Report(cnvBlankToNull(strID_Report));
        // ・修正データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity14.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity14.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・修正データのステータス⇒ReporthistoryEntity.ステータス
        BigDecimal status = null;
        if (null != inDto.getID_Status()) {
            status = new BigDecimal(inDto.getID_Status());
        }
        inEntity14.setStatus(status);
        // ・修正データのデータコード⇒ReporthistoryEntity.データコード
        inEntity14.setDataCode(cnvBlankToNull(inDto.getID_Data_Code()));
        // ・20⇒ReporthistoryEntity.処理種別
        inEntity14.setType_Process("20");
        // ・修正データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity14.setFlag_Torikeshizumi(inDto.getID_Flag_Torikeshizumi());
        // ・修正データのユーザID⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity14.setUserID(pnCommonInfo.getLogonID());
        // ・修正データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity14.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization()));
        // ・修正データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity14.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer()));
        // ・修正データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity14.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten()));
        // ・修正データの扱店⇒ReporthistoryEntity.扱店
        inEntity14.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization()));
        // ・修正データの店舗⇒ReporthistoryEntity.店舗
        inEntity14.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo()));
        // ・修正データの年度⇒ReporthistoryEntity.年度
        inEntity14.setYear(cnvBlankToNull(inDto.getLblID_Year()));
        // ・修正データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity14.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin()));
        // ・修正データの番号⇒ReporthistoryEntity.番号
        inEntity14.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi()));
        // ・修正データの枝番⇒ReporthistoryEntity.枝番(修正データの枝番が空白の場合、0とする。)
        inEntity14.setID_RingiBranch(PNCommonComponents.cnvNulltoZero((inDto.getLblID_ID_RingiBranch())));
        // ・修正データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity14.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・修正データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity14.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        // ・修正データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity14.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity14.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity14
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity14.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity14
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity14.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity14.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity14.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity14.setKeep_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        // ・NULL⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity14.setKeep_ID_History(null);
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        try {
            reporthistorydao.insert(inEntity14);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ７．貸付受入金払出・充当報告書データの追加（修正）
        // 追加を行うデータの確認
        // （１）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity15 = new UkeirereportEntity();
        inEntity15.setID_Report(strID_History);
        long hitcount15 = ukeirereportdao.countByCondition(inEntity15);
        if (0 < hitcount15) {
            // （２）取得した件数＞＝１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB010
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // （３）貸付受入金払出・充当報告書データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        UkeirereportEntity inEntity16 = new UkeirereportEntity();
        // ・修正データの扱店名⇒UkeireReportEntity.扱店名
        inEntity16.setName_Organization(inDto.getLblID_Name_Organization());
        // ・修正データの顧客名⇒UkeireReportEntity.顧客名
        inEntity16.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer()));
        // ・修正データの貸付実行日⇒UkeireReportEntity.貸付実行日
        inEntity16.setDate_Jikko(inDto.getLblID_Date_Jikko());
        // ・修正データの公庫支店⇒UkeireReportEntity.公庫支店コード
        inEntity16.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten()));
        // ・修正データの扱店⇒UkeireReportEntity.扱店コード
        inEntity16.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization()));
        // ・修正データの店舗⇒UkeireReportEntity.店舗コード
        inEntity16.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo()));
        // ・修正データの年度⇒UkeireReportEntity.年度
        inEntity16.setYear(cnvBlankToNull(inDto.getLblID_Year()));
        // ・修正データの⇒UkeireReportEntity.方式資金
        inEntity16.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin()));
        // ・修正データの番号⇒UkeireReportEntity.稟議番号
        inEntity16.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi()));
        // ・修正データの枝番⇒UkeireReportEntity.稟議番号枝番
        inEntity16.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
        // ・修正データの資金使途⇒UkeireReportEntity.資金使途コード
        inEntity16.setCode_ShikinShito(cnvBlankToNull(inDto.getLblID_Code_ShikinShito()));
        // ・修正データの事業別⇒UkeireReportEntity.事業別コード
        inEntity16.setCode_Jigyobetsu(cnvBlankToNull(inDto.getLblID_Code_Jigyobetsu()));
        // ・修正データの⇒UkeireReportEntity.特利区分
        inEntity16.setCode_TokuriKubun(cnvBlankToNull(inDto.getLblID_Kubun_Tokuri()));
        // ・修正データの⇒UkeireReportEntity.特利
        inEntity16.setTokuri(cnvMultiply1000(inDto.getLblID_Tokuri()));
        // ・修正データの利率⇒UkeireReportEntity.利率
        inEntity16.setRiritsu(cnvMultiply1000(inDto.getLblID_Riritsu()));
        // ・修正データの償還期限⇒UkeireReportEntity.償還期限
        inEntity16.setDate_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen()));
        // ・修正データの据置期限⇒UkeireReportEntity.据置期限
        inEntity16.setDate_SueokiKigen(cnvBlankToNull(inDto.getLblID_Date_SueokiKigen()));
        // ・修正データの元利金払込期日⇒UkeireReportEntity.元利金払込日
        String[] date = PNCommonComponents.cnvNulltoBlank(inDto.getLblID_Date_GanrikinHaraikomi()).split(
                "\\.");
        if (1 < date.length) {
            date[0] = String.format("%1$02d", Integer.parseInt(date[0]));
            date[1] = String.format("%1$02d", Integer.parseInt(date[1]));
        }
        inEntity16
                .setDate_GanrikinHaraikomi(cnvBlankToNull(PNCommonComponents.concatString(date[0], date[1])));
        // ・修正データの貸付実行額金額⇒UkeireReportEntity.貸付実行金額
        inEntity16.setM_Kashitsuke(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Kashitsuke()));
        // ・修正データの伝送番号（非表示）⇒UkeireReportEntity.伝送番号
        inEntity16.setID_Denso(cnvBlankToNull(inDto.getID_ID_Denso()));
        // ・西暦に変換した修正データの受託者勘定処理年月⇒UkeireReportEntity.受託者勘定処理年月
        inEntity16.setDate_Jtkshori(cnvBlankToNull(inDto.getLblID_Date_Jtkshori()));
        // ・西暦に変換した修正データの元金充当後第１回約定日⇒UkeireReportEntity.元金充当後第１回約定日
        inEntity16.setDate_FirstYakujoAfterGanju(cnvBlankToNull(inDto.getLblID_Date_FirstYakujoAfterGanju()));
        // ・西暦に変換した修正データの払出・元金充当日⇒UkeireReportEntity.払出元金充当日
        inEntity16.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getLblID_Date_HaraidashiJuto()));
        // ・修正データの繰上償還事由コード⇒UkeireReportEntity.繰上償還事由コード
        inEntity16.setCode_KurishoJiyu(cnvBlankToNull(inDto.getLblID_Code_KurishoJiyu()));
        // ・修正データの元金充当額⇒UkeireReportEntity.元金充当額
        inEntity16.setM_Ganju(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Ganju()));
        // ・修正データの合計（非表示）⇒UkeireReportEntity.合計
        inEntity16.setM_Kei(PNCommonComponents.cnvNulltoZero(inDto.getID_M_Kei()));
        // ・修正データの元金充当後貸付金残高⇒UkeireReportEntity.元金充当後貸付金残高
        inEntity16.setM_KashitsukeZandakaAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeZandakaAfterGanju()));
        // ・修正データの元金充当後の元金均等額⇒UkeireReportEntity.元金充当後元金均等額
        inEntity16.setM_GankinKintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinKintoAfterGanju()));
        // ・修正データの元金充当後の元金不均等額⇒UkeireReportEntity.元金充当後元金不均等額
        inEntity16.setM_GankinFukintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinFukintoAfterGanju()));
        // ・修正データの調整コード⇒UkeireReportEntity.調整コード
        inEntity16.setCode_Chosei(cnvBlankToNull(inDto.getRdoID_Code_Chosei()));
        // ・修正データの報告書番号（非表示）⇒UkeireReportEntity.報告書番号
        inEntity16.setID_Report(cnvBlankToNull(strID_Report));
        // ・修正データの報告年月日⇒UkeireReportEntity.報告年月日
        inEntity16.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・修正データの報告時分秒（非表示）⇒UkeireReportEntity.報告時分秒
        inEntity16.setTime_Report(cnvBlankToNull(inDto.getID_Time_Report().replaceAll(":", "")));
        // ・修正データのユーザID（非表示）⇒UkeireReportEntity.ユーザID
        inEntity16.setUserID(cnvBlankToNull(pnCommonInfo.getLogonID()));
        // ・修正データのデータコード（非表示）⇒UkeireReportEntity.データコード
        inEntity16.setDataCode(cnvBlankToNull(inDto.getID_Data_Code()));
        // ・修正データの貸付受入金受入額⇒UkeireReportEntity.貸付受入金受入額
        inEntity16.setM_KashitsukeUkeire(inDto.getLblID_M_KashitsukeUkeire());
        // ・修正データの資金交付額⇒UkeireReportEntity.資金交付額
        inEntity16.setM_ShikinKofu(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_ShikinKofu()));
        // ・修正データの資金払出額⇒UkeireReportEntity.資金払出額
        inEntity16.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Haraidashi()));
        // ・修正データの貸付受入金残高⇒UkeireReportEntity.貸付受入金残高
        inEntity16.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeukeireZan()));
        // 貸付受入金払出・充当報告書データを追加する。
        // （４）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　登録処理」を参照し、条件を設定する。
        // UkeireReportDAO.insert
        // UkeireReportEntity inEntity = new UkeireReportEntity();
        try {
            ukeirereportdao.insert(inEntity16);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ８．扱店別稟議データのレコードを更新
        // （１）稟議・条変起案中区分（非表示）＝"9"の場合
        if ("9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
            // ①セット条変起案中区分⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Set_Kubun_JohenKianchu());
        } else {
            // （２）稟議・条変起案中区分（非表示）＝"9"以外の場合
            // ①償還方法タイプ識別値＝"1" or "2"の場合
            if ("1".equals(inDto.getType_Shokan()) || "2".equals(inDto.getType_Shokan())) {
                // （ａ）計算結果用賦金⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(inDto.getID_Rst_M_Fukin());
                // （ｂ）計算結果用元金不均等額⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(inDto.getID_Rst_M_GankinFukinto());
                // （ｃ）計算結果調整コード⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Rst_Code_Chosei());
                // （ｄ）元金充当後貸付金残高⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(inDto.getLblID_M_KashitsukeZandakaAfterGanju());
                // （ｅ）修正データの償還期限⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen()));
            }
            // ②償還方法タイプ識別値＝"0" or "3" or "4"の場合
            List<String> checkList4 = Arrays.asList("0", "3", "4");
            if (checkList4.contains(inDto.getType_Shokan())) {
                // （ａ）計算結果用元金均等額⇒更新用賦金（非表示）
                inDto.setID_Up_M_Fukin(inDto.getID_Rst_M_GankinKinto());
                // （ｂ）計算結果用元金不均等額⇒更新用元金不均等（非表示）
                inDto.setID_Up_M_GankinFukinto(inDto.getID_Rst_M_GankinFukinto());
                // （ｃ）計算結果調整コード⇒更新用元金不均等区分（非表示）
                inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Rst_Code_Chosei());
                // （ｄ）元金充当後貸付金残高⇒更新用貸付金残高（非表示）
                inDto.setID_Up_M_KashitsukeZan(inDto.getLblID_M_KashitsukeZandakaAfterGanju());
                // （ｅ）修正データの償還期限⇒更新用償還期限年月（非表示）
                inDto.setID_Up_Date_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen()));
            }
            if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
                // ③償還方法タイプ識別値＝"5" or "6"の場合
                // （ａ）セット条変起案中区分⇒更新用条変起案中区分（非表示）
                inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Set_Kubun_JohenKianchu());
            }
            // ④償還方法タイプ識別値 （DB更新時の受渡し領域）⇒修正データの償還方法タイプ識別値
            // ⑤"0"⇒稟議データ更新フラグ
            inDto.setRingiRedFlg("0");
        }
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        AringiEntity inEntity17 = new AringiEntity();
        inEntity17.setID_Credit(inDto.getID_ID_Credit());
        inEntity17.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        long hitcount17 = aringidao.countByCondition(inEntity17);

        if (1 != hitcount17) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 扱店別稟議データを排他読込をする。
        // （５）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        AringiEntity inEntity18 = new AringiEntity();
        inEntity18.setID_Credit(inDto.getID_ID_Credit());
        try {
            AringiEntity outEntity18 = aringidao.findByPrimaryKeyForUpdate(inEntity18);

            if (null == outEntity18) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);

        }

        // （７）扱店別稟議データの更新用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        AringiEntity inEntity19 = new AringiEntity();
        inEntity19.setID_Credit(inDto.getID_ID_Credit());
        // ①償還タイプ＝"5" or "6"（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 修正データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity19.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity19.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity19.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 修正データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity19.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity19.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity19.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else {
            // ③上記①② 以外の場合
            // （ａ）元金不均等額区分の設定
            // 更新用元金不均等区分（非表示）⇒aRingiEntity.元金不均等額区分
            inEntity19.setKubun_GankinFukintogaku(inDto.getID_Up_Kubun_GankinFukinto());
            // （ｂ）最新更新日時の設定
            // 修正データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                inEntity19.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity19.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // （ｃ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            if (null != cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu())) {
                inEntity19.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
            }
            // （ｄ）賦金の設定
            // 更新用賦金（非表示）⇒aRingiEntity.賦金
            if (null != inDto.getID_Up_M_Fukin()) {
                inEntity19.setM_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
            }
            // （ｅ）元金不均等額の設定
            // 更新用元金不均等（非表示）⇒aRingiEntity.元金不均等額
            if (null != inDto.getID_Up_M_GankinFukinto()) {
                inEntity19.setM_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_GankinFukinto()));
            }
            // （ｆ）貸付金残高の設定
            // 更新用貸付金残高（非表示）⇒aRingiEntity.貸付金残高
            if (null != inDto.getID_Up_M_KashitsukeZan()) {
                inEntity19.setM_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_KashitsukeZan()));
            }
            // （ｇ）償還期限年月の設定
            // 更新用償還期限年月（非表示）⇒aRingiEntity.償還期限年月
            if (null != cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen())) {
                inEntity19.setDate_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
            }
        }
        // 扱店別稟議データを更新をする。
        // （８）償還タイプの判定
        // ①償還タイプ＝"5" or "6"の場合
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(定期償還・特殊償還)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity19);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }

            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // 単テーブルアクセス定義「扱店別稟議　更新処理(資金払出のみ＆修正)」を参照し、条件を設定する。
            // AringiDAO.updata
            try {
                aringidao.update(inEntity19);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else {
            // ③上記①②以外の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆取消)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity19);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // ９．請求データのレコードﾞを更新
        // （１）取得償還方法コード＝"0" or "1" or "2" or "3" or "4"の場合　　（定期償還・特殊償還　以外）
        List<String> checkList5 = Arrays.asList("0", "1", "2", "3", "4");
        if (checkList5.contains(inDto.getType_Shokan())) {
            // ①稟議・条変起案中区分（非表示）＜＞"9"の場合
            if (!"9".equals(inDto.getID_Kubun_JohenKianchu_Ringi())) {
                // （ａ）請求データ更新判定フラグ＝Ｔｕｒｅ ＡＮＤ 請求データを取消更新する場合のフラグ＝Ｔｕｒｅ の場合
                if (inDto.getSeikyuShuseiUp() && inDto.getFlgSeikyuUpShusei()) {
                    // （ⅰ）修正データの値を設定しなおす。
                    // ・計算約定利息（非表示）⇒更新用約定利息（非表示）
                    inDto.setID_Up_M_YakujoRisoku(inDto.getID_Rst_M_YakujoRisoku());
                    // ・計算約定元金（非表示）⇒更新用約定元金（非表示）
                    inDto.setID_Up_M_YakujoGankin(inDto.getID_Rst_M_YakujoGankin());
                    // ・請求・払込年月日（非表示）⇒請求データ更新用・Key:払込年月日_領域
                    inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getID_Key_Date_Haraikomi_Seikyu_Shusei());
                    // 更新を行うデータの確認
                    // （ⅱ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                    SeikyuEntity inEntity20 = new SeikyuEntity();
                    inEntity20.setID_Credit(inDto.getID_ID_Credit());
                    inEntity20.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    long hitcount20 = seikyudao.countByCondition(inEntity20);
                    if (1 != hitcount20) {
                        // （ⅲ）取得した件数＝０の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        // （Ⅴ）取得した件数＞１の場合、業務エラーとする。
                        // エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                    }

                    // 請求データを排他読込をする。
                    // （Ⅵ）単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                    SeikyuEntity inEntity21 = new SeikyuEntity();
                    inEntity21.setID_Credit(inDto.getID_ID_Credit());
                    inEntity21.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    try {
                        SeikyuEntity outEntity21 = seikyudao.findByPrimaryKeyForUpdate(inEntity21);
                        //
                        if (null == outEntity21) {
                            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                        }
                        // // すでに更新されているかチェック処理を記述
                        //
                    } catch (CFWFindParameterException fpe) {
                        // // 検索条件値エラー
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        //
                    } catch (CFWForUpdateException fue) {
                        // （Ⅶ）)排他エラーの場合、業務エラーとする。
                        // エラーメッセージ：PTN001,DB007
                        // // 排他エラー
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                    }

                    // （Ⅷ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    SeikyuEntity inEntity22 = new SeikyuEntity();
                    inEntity22.setID_Credit(inDto.getID_ID_Credit());
                    inEntity22.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                    // （ｱ）約定利息の設定
                    // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                    inEntity22.setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoRisoku()));
                    // （ｲ）約定元金の設定
                    // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                    inEntity22.setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto
                            .getID_Up_M_YakujoGankin()));
                    // 請求データを更新をする。
                    // （Ⅸ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    try {
                        seikyudao.update(inEntity22);
                        // 検索条件値エラー
                    } catch (CFWFindParameterException fpe) {
                        throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                        // 主キー更新時の一意性制約エラー
                    } catch (CFWDuplicateKeyException dke) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                    }
                }
            }
        }

        // １０．払出データの追加（修正）　　※修正画面表示の対象となった案件用のﾚｺｰﾄﾞのを追加　（新規作成時と同様の追加となる）
        // （１）取得償還方法コード＝"0" or "1" or "2" or "3" or "4"の場合　　（定期償還・特殊償還　以外）
        List<String> checkList6 = Arrays.asList("0", "1", "2", "3", "4");
        if (checkList6.contains(inDto.getType_Shokan())) {
            // ①追加する値を設定
            // （ａ）修正用・払出データ項目の修正用払出・債権管理番号⇒取消用払出・債権管理番号
            inDto.setID_Ins_ID_Credit(inDto.getID_HDNew0_ID_Credit());
            // （ｂ）修正用・払出データ項目の修正用払出・計数管理処理番号⇒取消用払出・計数管理処理番号
            inDto.setID_Ins_KeisuKanriShori(inDto.getID_HDNew0_KeisuKanriShori());
            // （ｃ）修正用・払出データ項目の修正用払出・払出充当年月日⇒取消用払出・払出充当年月日
            inDto.setID_Ins_Date_HaraidashiJuto(inDto.getID_HDNew0_Date_HaraidashiJuto());
            // （ｄ）修正用・払出データ項目の修正用払出・払出額⇒取消用払出・払出額
            inDto.setID_Ins_M_Haraidashi(inDto.getID_HDNew_M_Haraidashi());
            // （ｅ）修正用・払出データ項目の修正用払出・繰上償還額⇒取消用払出・繰上償還額
            inDto.setID_Ins_M_Kurisho(inDto.getID_HDNew0_M_Kurisho());
            // （ｆ）修正用・払出データ項目の修正用払出・貸付受入金残高⇒取消用払出・貸付受入金残高
            inDto.setID_Ins_M_HaraidashiKashitsukeZan(inDto.getID_HDNew0_M_HaraidashiKashitsukeZan());
            // （ｇ）修正用・払出データ項目の修正用払出・払出累計額⇒取消用払出・払出累計額
            inDto.setID_Ins_M_HaraidashiRuikei(inDto.getID_HDNew0_M_HaraidashiRuikei());
            // （ｈ）修正用・払出データ項目の修正用払出・繰上償還累計額⇒取消用払出・繰上償還累計額
            inDto.setID_Ins_M_KurishoRuikei(inDto.getID_HDNew0_M_KurishoRuikei());
            // （ｉ）修正用・払出データ項目の修正用払出・更生処理区分⇒取消用払出・更生処理区分
            inDto.setID_Ins_Kubun_KoseiShori(inDto.getID_HDNew0_Kubun_KoseiShori());
            // （ｊ）修正用・払出データ項目の修正用払出・貸付受入金残高積数⇒取消用払出・貸付受入金残高積数
            inDto.setID_Ins_M_ZandakaSekisu(inDto.getID_HDNew0_M_ZandakaSekisu());
            // （ｋ）修正用・払出データ項目の修正用払出・債権管理番号⇒Key債権管理番号
            inDto.setID_Ins_ID_Credit(inDto.getID_HDNew0_ID_Credit());
            // （ｌ）修正用・払出データ項目の修正用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDNew0_KeisuKanriShori());
            // 追加を行うデータの確認
            // （１）単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity23 = new HaraidashiEntity();
            inEntity23.setID_Credit(inDto.getKey_ID_Credit());
            inEntity23.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount23 = haraidashidao.countByCondition(inEntity23);
            if (0 < hitcount23) {
                // （２）取得した件数＞＝１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB010
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            HaraidashiEntity inEntity24 = new HaraidashiEntity();
            // （３）払出データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // ①追加する値を設定
            // （ａ）修正データの債権管理番号（非表示）⇒HaraidashiEntity.債権管理番号
            inEntity24.setID_Credit(inDto.getID_Ins_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒HaraidashiEntity.計数管理処理番号
            inEntity24.setID_KeisuKanriShori(cnvBlankToNull(inDto.getID_Ins_KeisuKanriShori()));
            // （ｃ）取消用払出・払出額⇒HaraidashiEntity.払出額
            inEntity24.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_Haraidashi()));
            // （ｄ）取消用払出・払出累計額⇒HaraidashiEntity.払出累計額
            inEntity24.setM_HaraidashiRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_Ins_M_HaraidashiRuikei()));
            // （ｅ）取消用払出・上償還額⇒HaraidashiEntity.繰上償還額
            inEntity24.setM_Kurisho(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_Kurisho()));
            // （ｆ）取消用払出・繰上償還累計額⇒HaraidashiEntity.繰上償還累計額
            inEntity24
                    .setM_KurishoRuikei(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_KurishoRuikei()));
            // （ｇ）取消用払出・更生処理区分⇒HaraidashiEntity.更正処理区分
            inEntity24.setKubun_KoseiShori(cnvBlankToNull(inDto.getID_Ins_Kubun_KoseiShori()));
            // （ｈ）取消用払出・貸付受入金残高積数⇒HaraidashiEntity.貸付受入金残高積数
            inEntity24
                    .setM_ZandakaSekisu(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_ZandakaSekisu()));
            // （ｉ）取消用払出・払出充当年月日⇒HaraidashiEntity.払出充当年月日
            inEntity24.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getID_Ins_Date_HaraidashiJuto()));
            // （ｊ）取消用払出・貸付受入金残高⇒HaraidashiEntity.貸付受入金残高
            inEntity24.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_Ins_M_HaraidashiKashitsukeZan()));
            // 払出データを追加する。
            // （４）単テーブルアクセス定義「払出データ　登録処理」を参照し、条件を設定する。
            try {
                haraidashidao.insert(inEntity24);
            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }

        }

        return outDto;
    }

    /**
     * Md002_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO updateDataProcEndMod(Md002_02DTO inDto) {

        Md002_02DTO outDto = new Md002_02DTO();

        // 修正：処理完了の更新処理。
        // 　＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // １．報告書履歴データのレコードを更新　　※画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        // （１）更正（赤）データの値を設定しなおす。
        // ①"1"⇒更正（赤）データの取消済みフラグ（非表示）
        // ②現在の日付⇒更正（赤）データの報告年月日
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        inDto.setID_Date_Report(pnBusinessDay);
        // ③現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(PNCommonComponents.getSysDateTime());
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        long hitcount = reporthistorydao.countByCondition(inEntity);
        if (1 != hitcount) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PTN001,DB007
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB004
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        inEntity2.setID_History(inDto.getID_ID_History());
        try {
            ReporthistoryEntity outEntity1 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity2);

            if (null == outEntity1) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }
        // }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        ReporthistoryEntity inEntity3 = new ReporthistoryEntity();
        inEntity3.setID_History(inDto.getID_ID_History());
        // ②取消：処理完了以外（更正（赤））以外の場合
        // （ａ）更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity3.setID_Report(cnvBlankToNull(inDto.getID_ID_Report()));
        // （ｂ）更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity3.setFlag_Torikeshizumi(BigDecimal.ONE);
        // 報告書履歴データを更新をする。
        // （８）単テーブルアクセス定義「報告書履歴データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
        try {
            reporthistorydao.update(inEntity3);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // // ３．請求データのレコードﾞを更新
        // // （１）取得償還方法コード＝"0" or "2"の場合　　（払出のみ、元金均等償還）
        if ("0".equals(inDto.getCharCode_ShokanHouhou()) || "2".equals(inDto.getCharCode_ShokanHouhou())) {
            // ①請求データを修正更新する場合のフラグ＝Ture の場合
            if (inDto.getFlgSeikyuUpTorikeshi()) {
                // （ａ）更正（赤）データの値を設定しなおす。
                // （ⅰ）退避約定元金（非表示）⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                // （ⅱ）退避約定利息（非表示）⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                // （ⅲ）請求_取消用・払込年月日⇒請求データ更新用・Key:払込年月日_領域
                inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getID_Key_Date_Haraikomi_Seikyu_Torikeshi());
                // 更新を行うデータの確認
                // （ｂ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                SeikyuEntity inEntity7 = new SeikyuEntity();
                inEntity7.setID_Credit(inDto.getID_ID_Credit());
                inEntity7.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                long hitcount7 = seikyudao.countByCondition(inEntity7);
                if (1 != hitcount7) {
                    // （ｃ）取得した件数＝０の場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB011
                    // （ｄ）取得した件数＞１の場合、業務エラーとする。
                    // エラーメッセージ：BA001,DB004
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                }

                // 請求データを排他読込をする。
                // （ｅ）単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                SeikyuEntity inEntity8 = new SeikyuEntity();
                inEntity8.setID_Credit(inDto.getID_ID_Credit());
                inEntity8.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                try {
                    SeikyuEntity outEntity8 = seikyudao.findByPrimaryKeyForUpdate(inEntity8);
                    //
                    if (null == outEntity8) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // // すでに更新されているかチェック処理を記述
                    //
                } catch (CFWFindParameterException fpe) {
                    // // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    //
                } catch (CFWForUpdateException fue) {
                    // （ｆ）)排他エラーの場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB007
                    // // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                }

                // （ｇ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                SeikyuEntity inEntity9 = new SeikyuEntity();
                inEntity9.setID_Credit(inDto.getID_ID_Credit());
                inEntity9.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                // （ⅰ）約定利息の設定
                // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                inEntity9
                        .setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
                // （ⅱ）約定元金の設定
                // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                inEntity9
                        .setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
                // 請求データを更新をする。
                // （ｈ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                try {
                    seikyudao.update(inEntity9);
                } catch (CFWFindParameterException fpe) {
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    // 主キー更新時の一意性制約エラー
                } catch (CFWDuplicateKeyException dke) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                }
            }
        }
        // ４．払出データの更新
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合
        List<String> checkList = Arrays.asList("0", "1", "2");
        if (checkList.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_Keep_ID_KeisuKanriShori());
            // 更新を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity10 = new HaraidashiEntity();
            inEntity10.setID_Credit(inDto.getKey_ID_Credit());
            inEntity10.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount10 = haraidashidao.countByCondition(inEntity10);
            if (1 != hitcount10) {

                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB011
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB004
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

            }
            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity11 = new HaraidashiEntity();
            inEntity11.setID_Credit(inDto.getKey_ID_Credit());
            inEntity11.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {

                HaraidashiEntity outEntity11 = haraidashidao.findByPrimaryKeyForUpdate(inEntity11);

                if (null == outEntity11) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PTN001,DB007
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }
            // }

            // ⑦払出データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
            HaraidashiEntity inEntity12 = new HaraidashiEntity();
            inEntity12.setID_Credit(inDto.getKey_ID_Credit());
            inEntity12.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            // 払出データを更新する。
            // ⑧単テーブルアクセス定義「払出データ　更新処理」を参照し、条件を設定する。
            inEntity12.setKubun_KoseiShori("1");
            try {
                haraidashidao.update(inEntity12);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // 取消内容のﾃﾞｰﾀに対するﾚｺｰﾄﾞの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う

        // ５．履歴データの追加
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　（元利均等償還・元金均等償還）
        List<String> checkList2 = Arrays.asList("0", "1", "2");
        if (checkList2.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①稟議・賦金（非表示）⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_M_Fukin_Ringi());
            // ②稟議・元金不均等（非表示）⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(inDto.getID_M_GankinFukinto_Ringi());
            // ③稟議・元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Kubun_GankinFukinto_Ringi());
            // ④稟議・貸付金残高（非表示）⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getID_M_KashitsukeZan_Ringi());
            // ⑤稟議・償還期限年月（非表示）⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Date_ShokanKigen_Ringi());
            // ⑥稟議・条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu_Ringi());
            // ⑦請求_取消用・約定利息＝"" ＡＮＤ 請求_取消用・約定元金＝"" の場合
            if (null == inDto.getID_M_YakujoRisoku_Seikyu_Torikeshi()
                    && null == inDto.getID_M_YakujoGankin_Seikyu_Torikeshi()) {
                // （ａ）""⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(null);
                // （ｂ）""⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(null);
            } else {
                // ⑧（請求_取消用・約定利息＝"" ＡＮＤ 請求_取消用・約定元金＝""） 以外の場合
                // （ａ）請求_取消用・約定利息⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_M_YakujoRisoku_Seikyu_Torikeshi());
                // （ｂ）請求_取消用・約定元金⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_M_YakujoGankin_Seikyu_Torikeshi());
            }
            // ⑨報告書履歴番号（非表示）⇒報告書履歴番号（非表示）
            inDto.setID_ID_History(inDto.getID_ID_History());
            // （２）取得償還方法コード＝"3" or "9"の場合　　（定期償還、特殊償還）
        } else if ("3".equals(inDto.getCharCode_ShokanHouhou())
                || "9".equals(inDto.getCharCode_ShokanHouhou())) {
            // ①""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // ②""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // ③""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ④""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ⑤""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
            // ⑥""⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(null);
            // ⑦""⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(null);
            // ⑧稟議・条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Kubun_JohenKianchu_Ringi());
            // ⑨報告書履歴番号（非表示）⇒報告書履歴番号（非表示）
            inDto.setID_ID_History(inDto.getID_ID_History());
        }
        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();
        // （ｂ）処理モードが処理完了以外：削除以外の場合
        // 報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();
        // （４）取得した件数＝０の場合、データの追加処理を行う。
        // ①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity inEntity13 = new ReporthistoryEntity();
        // ・更正（赤）データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity13.setID_History(cnvBlankToNull(strID_History));
        // ・更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity13.setID_Report(cnvBlankToNull(strID_Report));
        // ・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity13.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity13.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・更正（赤）データのステータス⇒ReporthistoryEntity.ステータス
        inEntity13.setStatus(BigDecimal.ONE);
        // ・90257021⇒ReporthistoryEntity.データコード
        inEntity13.setDataCode("90257021");
        // ・10⇒ReporthistoryEntity.処理種別
        inEntity13.setType_Process("10");
        // ・0⇒ReporthistoryEntity.取消済フラグ
        inEntity13.setFlag_Torikeshizumi(BigDecimal.ZERO);
        // ・更正（赤）データのユーザID⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity13.setUserID(pnCommonInfo.getLogonID());
        // ・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity13.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity13.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity13.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        inEntity13.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        inEntity13.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒ReporthistoryEntity.年度
        inEntity13.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity13.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒ReporthistoryEntity.番号
        inEntity13.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        inEntity13.setID_RingiBranch(PNCommonComponents.cnvNulltoZero((inDto.getLblID_ID_RingiBranch_Red())));
        // ・更正（赤）データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity13.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・更正（赤）データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity13.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        // ・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity13.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity13.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity13
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity13.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity13
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity13.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity13.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity13.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity13.setKeep_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        // ・報告書履歴番号（非表示）⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity13.setKeep_ID_History(cnvBlankToNull(inDto.getID_ID_History()));
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        try {
            reporthistorydao.insert(inEntity13);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ６．貸付受入金払出・充当報告書データの追加
        // 追加を行うデータの確認
        // （１）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        // UkeireReportDAO.countByCondition
        UkeirereportEntity inEntity14 = new UkeirereportEntity();
        inEntity14.setID_Report(strID_Report);
        long hitcount14 = ukeirereportdao.countByCondition(inEntity14);
        if (0 < hitcount14) {
            // （２）取得した件数＞＝１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB010
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // （３）貸付受入金払出・充当報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        UkeirereportEntity inEntity15 = new UkeirereportEntity();
        // ・更正（赤）データの扱店名⇒UkeireReportEntity.扱店名
        inEntity15.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒UkeireReportEntity.顧客名
        inEntity15.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの貸付実行日⇒UkeireReportEntity.貸付実行日
        inEntity15.setDate_Jikko(inDto.getLblID_Date_Jikko_Red());
        // ・更正（赤）データの公庫支店⇒UkeireReportEntity.公庫支店コード
        inEntity15.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒UkeireReportEntity.扱店コード
        inEntity15.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒UkeireReportEntity.店舗コード
        inEntity15.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒UkeireReportEntity.年度
        inEntity15.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.方式資金
        inEntity15.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒UkeireReportEntity.稟議番号
        inEntity15.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒UkeireReportEntity.稟議番号枝番
        inEntity15.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
        // ・更正（赤）データの資金使途⇒UkeireReportEntity.資金使途コード
        inEntity15.setCode_ShikinShito(cnvBlankToNull(inDto.getLblID_Code_ShikinShito_Red()));
        // ・更正（赤）データの事業別⇒UkeireReportEntity.事業別コード
        inEntity15.setCode_Jigyobetsu(cnvBlankToNull(inDto.getLblID_Code_Jigyobetsu_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.特利区分
        inEntity15.setCode_TokuriKubun(cnvBlankToNull(inDto.getLblID_Code_TokuriKubun_Red()));
        // ・更正（赤）データの⇒UkeireReportEntity.特利
        inEntity15.setTokuri(cnvMultiply1000(inDto.getLblID_Tokuri_Red()));
        // ・更正（赤）データの利率⇒UkeireReportEntity.利率
        inEntity15.setRiritsu(cnvMultiply1000(inDto.getLblID_Riritsu_Red()));
        // ・更正（赤）データの償還期限⇒UkeireReportEntity.償還期限
        inEntity15.setDate_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen_Red()));
        // ・更正（赤）データの据置期限⇒UkeireReportEntity.据置期限
        inEntity15.setDate_SueokiKigen(cnvBlankToNull(inDto.getLblID_Date_SueokiKigen_Red()));
        // ・更正（赤）データの元利金払込期日⇒UkeireReportEntity.元利金払込日
        String[] date = PNCommonComponents.cnvNulltoBlank(inDto.getLblID_Date_GanrikinHaraikomi_Red()).split(
                "\\.");
        if (1 < date.length) {
            date[0] = String.format("%1$02d", Integer.parseInt(date[0]));
            date[1] = String.format("%1$02d", Integer.parseInt(date[1]));
        }
        inEntity15
                .setDate_GanrikinHaraikomi(cnvBlankToNull(PNCommonComponents.concatString(date[0], date[1])));
        // ・更正（赤）データの貸付実行額金額⇒UkeireReportEntity.貸付実行金額
        inEntity15.setM_Kashitsuke(inDto.getLblID_M_Kashitsuke_Red());
        // ・更正（赤）データの伝送番号（非表示）⇒UkeireReportEntity.伝送番号
        inEntity15.setID_Denso(cnvBlankToNull(inDto.getID_ID_Denso()));
        // ・西暦に変換した更正（赤）データの受託者勘定処理年月⇒UkeireReportEntity.受託者勘定処理年月
        inEntity15.setDate_Jtkshori(cnvBlankToNull(inDto.getLblID_Date_Jtkshori_Red()));
        // ・西暦に変換した更正（赤）データの元金充当後第１回約定日⇒UkeireReportEntity.元金充当後第１回約定日
        inEntity15.setDate_FirstYakujoAfterGanju(cnvBlankToNull(inDto
                .getLblID_Date_FirstYakujoAfterGanju_Red()));
        // ・西暦に変換した更正（赤）データの払出・元金充当日⇒UkeireReportEntity.払出元金充当日
        inEntity15.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getLblID_Date_HaraidashiJuto_Red()));
        // ・更正（赤）データの繰上償還事由コード⇒UkeireReportEntity.繰上償還事由コード
        inEntity15.setCode_KurishoJiyu(cnvBlankToNull(inDto.getLblID_Code_KurishoJiyu_Red()));
        // ・更正（赤）データの元金充当額⇒UkeireReportEntity.元金充当額
        inEntity15.setM_Ganju(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Ganju_Red()));
        // ・更正（赤）データの合計（非表示）⇒UkeireReportEntity.合計
        inEntity15.setM_Kei(PNCommonComponents.cnvNulltoZero(inDto.getID_M_Kei_Red()));
        // ・更正（赤）データの元金充当後貸付金残高⇒UkeireReportEntity.元金充当後貸付金残高
        inEntity15.setM_KashitsukeZandakaAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeZandakaAfterGanju_Red()));
        // ・更正（赤）データの元金充当後の元金均等額⇒UkeireReportEntity.元金充当後元金均等額
        inEntity15.setM_GankinKintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinKintoAfterGanju_Red()));
        // ・更正（赤）データの元金充当後の元金不均等額⇒UkeireReportEntity.元金充当後元金不均等額
        inEntity15.setM_GankinFukintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinFukintoAfterGanju_Red()));
        // ・更正（赤）データの調整コード⇒UkeireReportEntity.調整コード
        inEntity15.setCode_Chosei(cnvBlankToNull(inDto.getRdoID_Code_Chosei_Red()));
        // ・更正（赤）データの報告書番号（非表示）⇒UkeireReportEntity.報告書番号
        inEntity15.setID_Report(cnvBlankToNull(strID_Report));
        // ・更正（赤）データの報告年月日⇒UkeireReportEntity.報告年月日
        inEntity15.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・更正（赤）データの報告時分秒（非表示）⇒UkeireReportEntity.報告時分秒
        inEntity15.setTime_Report(cnvBlankToNull(inDto.getID_Time_Report().replaceAll(":", "")));
        // ・更正（赤）データのユーザID（非表示）⇒UkeireReportEntity.ユーザID
        inEntity15.setUserID(cnvBlankToNull(pnCommonInfo.getLogonID()));
        // ・90257021⇒UkeireReportEntity.データコード
        inEntity15.setDataCode("90257021");
        // ・更正（赤）データの貸付受入金受入額⇒UkeireReportEntity.貸付受入金受入額
        inEntity15.setM_KashitsukeUkeire(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeUkeire_Red()));
        // ・更正（赤）データの資金交付額⇒UkeireReportEntity.資金交付額
        inEntity15.setM_ShikinKofu(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_ShikinKofu_Red()));
        // ・更正（赤）データの資金払出額⇒UkeireReportEntity.資金払出額
        inEntity15.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Haraidashi_Red()));
        // ・更正（赤）データの貸付受入金残高⇒UkeireReportEntity.貸付受入金残高
        inEntity15.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeukeireZan_Red()));
        // 貸付受入金払出・充当報告書データを追加する。
        // （４）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　登録処理」を参照し、条件を設定する。
        try {
            ukeirereportdao.insert(inEntity15);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ７．払出データの追加　　※画面表示の対象となった案件の更正赤用のﾚｺｰﾄﾞのを追加
        // ※ 画面表示の対象となった案件の更正赤用のﾚｺｰﾄﾞのを追加
        // 更正処理区分に「２」を設定する
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　（払出のみ、元利均等償還・元金均等償還）
        List<String> checkList3 = Arrays.asList("0", "1", "2");
        if (checkList3.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①追加する値を設定
            // （ｂ）"99999990001"⇒取消用払出・計数管理処理番号
            inDto.setID_HDDel1_KeisuKanriShori("99999990001");
            // （ｃ）保存・取消１用・払出データ項目の取消用払出・払出充当年月日⇒取消用払出・払出充当年月日
            inDto.setID_HDDel1_Date_HaraidashiJuto(inDto.getID_HDDel1_Keep_Date_HaraidashiJuto());

            // （ｄ）０－保存・取消１用・払出データ項目の取消用払出・払出額⇒取消用払出・払出額
            inDto.setID_HDDel1_M_Haraidashi(BigDecimal.ZERO.subtract(inDto.getID_HDDel1_Keep_M_Haraidashi()));

            // （ｅ）０－保存・取消１用・払出データ項目の取消用払出・繰上償還額⇒取消用払出・繰上償還累計額
            inDto.setID_HDDel1_M_Kurisho(BigDecimal.ZERO.subtract(inDto.getID_HDDel1_Keep_M_Kurisho()));

            // （ｆ）保存・取消１用・払出データ項目の取消用払出・貸付受入金残高
            // ＋保存・取消１用・払出データ項目の取消用払出・払出額
            // ＋保存・取消１用・払出データ項目の取消用払出・繰上償還額
            // ⇒取消用払出・貸付受入金残高
            inDto.setID_HDDel1_M_HaraidashiKashitsukeZan(inDto.getID_HDDel1_Keep_M_HaraidashiKashitsukeZan()
                    .add(inDto.getID_HDDel1_Keep_M_Haraidashi()).add(inDto.getID_HDDel1_Keep_M_Kurisho()));

            // （ｇ）保存・取消１用・払出データ項目の取消用払出・払出累計額
            // －保存・取消１用・払出データ項目の取消用払出・払出額
            // ⇒取消用払出・払出累計額
            inDto.setID_HDDel1_M_HaraidashiRuikei(inDto.getID_HDDel1_Keep_M_HaraidashiRuikei().subtract(
                    inDto.getID_HDDel1_Keep_M_Haraidashi()));

            // （ｈ）保存・取消１用・払出データ項目の取消用払出・繰上償還累計額
            // －保存・取消１用・払出データ項目の取消用払出・繰上償還額
            // ⇒取消用払出・繰上償還累計額
            inDto.setID_HDDel1_M_KurishoRuikei(inDto.getID_HDDel1_Keep_M_KurishoRuikei().subtract(
                    inDto.getID_HDDel1_Keep_M_Kurisho()));

            // （ｉ）"2"⇒取消用払出・更生処理区分
            inDto.setID_HDDel1_Kubun_KoseiShori("2");

            // （ｊ）０－保存・取消１用・払出データ項目の取消用払出・貸付受入金残高積数⇒取消用払出・貸付受入金残高積数
            inDto.setID_HDDel1_M_ZandakaSekisu(BigDecimal.ZERO.subtract(inDto
                    .getID_HDDel1_Keep_M_ZandakaSekisu()));

            // （ｋ）保存・取消１用・払出データ項目の取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｌ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_KeisuKanriShori());

            // 追加を行うデータの確認
            // （１）単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity16 = new HaraidashiEntity();
            // 債権管理番号
            inEntity16.setID_Credit(inDto.getID_ID_Credit());
            // 計数管理処理番号
            inEntity16.setID_KeisuKanriShori(inDto.getID_HDDel1_KeisuKanriShori());
            long hitcount16 = haraidashidao.countByCondition(inEntity16);

            if (0 < hitcount16) {
                // （２）取得した件数＞＝１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB010
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

            // （３）払出データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // ①追加する値を設定
            HaraidashiEntity inEntity17 = new HaraidashiEntity();
            // （ａ）更正（赤）データの債権管理番号（非表示）⇒HaraidashiEntity.債権管理番号
            inEntity17.setID_Credit(inDto.getID_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒HaraidashiEntity.計数管理処理番号
            inEntity17.setID_KeisuKanriShori(cnvBlankToNull(inDto.getID_HDDel1_KeisuKanriShori()));
            // （ｃ）取消用払出・払出額⇒HaraidashiEntity.払出額
            inEntity17.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getID_HDDel1_M_Haraidashi()));
            // （ｄ）取消用払出・払出累計額⇒HaraidashiEntity.払出累計額
            inEntity17.setM_HaraidashiRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_HaraidashiRuikei()));
            // （ｅ）取消用払出・繰上償還額⇒HaraidashiEntity.繰上償還額
            inEntity17.setM_Kurisho(PNCommonComponents.cnvNulltoZero(inDto.getID_HDDel1_M_Kurisho()));
            // （ｆ）取消用払出・繰上償還累計額⇒HaraidashiEntity.繰上償還累計額
            inEntity17.setM_KurishoRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_KurishoRuikei()));
            // （ｇ）取消用払出・更生処理区分⇒HaraidashiEntity.更正処理区分
            inEntity17.setKubun_KoseiShori(cnvBlankToNull(inDto.getID_HDDel1_Kubun_KoseiShori()));
            // （ｈ）取消用払出・貸付受入金残高積数⇒HaraidashiEntity.貸付受入金残高積数
            inEntity17.setM_ZandakaSekisu(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_ZandakaSekisu()));
            // （ｉ）取消用払出・払出充当年月日⇒HaraidashiEntity.払出充当年月日
            inEntity17.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getID_HDDel1_Date_HaraidashiJuto()));
            // （ｊ）取消用払出・貸付受入金残高⇒HaraidashiEntity.貸付受入金残高
            inEntity17.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_HDDel1_M_HaraidashiKashitsukeZan()));
            // 払出データを追加する。
            // （４）単テーブルアクセス定義「払出データ　登録処理」を参照し、条件を設定する。
            try {
                haraidashidao.insert(inEntity17);
            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // 　修正データの登録　　※ここからは修正データの処理
        // ８．報告書履歴データの追加
        // （１）償還方法タイプ識別値＝"1" or "2"の場合　　（元利均等償還）
        if ("1".equals(inDto.getType_Shokan()) || "2".equals(inDto.getType_Shokan())) {
            // ①""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // ②""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // ③""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto("");
            // ④""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ⑤""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
            // ⑥""⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(null);
            // ⑦""⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(null);
            // ⑧"9"⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu("9");
        }
        // （２）償還方法タイプ識別値＝"0" or "3" or "4"の場合　　（払出のみ、元金均等償還）
        List<String> checkList4 = Arrays.asList("0", "3", "4");
        if (checkList4.contains(inDto.getType_Shokan())) {
            // ①退避賦金（非表示）⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
            // ②退避元金不均等（非表示）⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
            // ③退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
            // ④退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
            // ⑤退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
            // ⑥退避約定利息（非表示）⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
            // ⑦退避約定元金（非表示）⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
            // ⑧退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
        }
        // （３）償還方法タイプ識別値＝"5" or "6"　　（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // ①""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // ②""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // ③""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto("");
            // ④""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // ⑤""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
            // ⑥""⇒更新用約定利息（非表示）
            inDto.setID_Up_M_YakujoRisoku(null);
            // ⑦""⇒更新用約定元金（非表示）
            inDto.setID_Up_M_YakujoGankin(null);
            // ⑧9⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu("9");
        }

        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History2 = pnCommonDBComponents.getIdHistoryRh();
        // （ｂ）処理モードが処理完了以外：削除以外の場合
        // 報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、報告書番号に設定する。
        String strID_Report2 = pnCommonDBComponents.getIdReportRh();

        ReporthistoryEntity inEntity18 = new ReporthistoryEntity();
        // （５）取得した件数＝０の場合、データの追加処理を行う。
        // ①報告書履歴データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        // ・修正データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity18.setID_History(cnvBlankToNull(strID_History2));
        // ・修正データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity18.setID_Report(cnvBlankToNull(strID_Report2));
        // ・修正データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity18.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity18.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・1⇒ReporthistoryEntity.ステータス
        inEntity18.setStatus(BigDecimal.ONE);
        // ・修正データのデータコード⇒ReporthistoryEntity.データコード
        inEntity18.setDataCode(cnvBlankToNull(inDto.getID_Data_Code()));
        // ・20⇒ReporthistoryEntity.処理種別
        inEntity18.setType_Process("20");
        // ・修正データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity18.setFlag_Torikeshizumi(inDto.getID_Flag_Torikeshizumi());
        // ・修正データのユーザID⇒ReporthistoryEntity.ユーザID
        pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity18.setUserID(pnCommonInfo.getLogonID());
        // ・修正データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity18.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization()));
        // ・修正データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity18.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer()));
        // ・修正データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity18.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten()));
        // ・修正データの扱店⇒ReporthistoryEntity.扱店
        inEntity18.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization()));
        // ・修正データの店舗⇒ReporthistoryEntity.店舗
        inEntity18.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo()));
        // ・修正データの年度⇒ReporthistoryEntity.年度
        inEntity18.setYear(cnvBlankToNull(inDto.getLblID_Year()));
        // ・修正データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity18.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin()));
        // ・修正データの番号⇒ReporthistoryEntity.番号
        inEntity18.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi()));
        // ・修正データの枝番⇒ReporthistoryEntity.枝番(修正データの枝番が空白の場合、0とする。)
        inEntity18.setID_RingiBranch(PNCommonComponents.cnvNulltoZero((inDto.getLblID_ID_RingiBranch())));
        // ・修正データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity18.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・修正データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity18.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        inEntity18.setID_Credit(inDto.getID_ID_Credit());
        // ・修正データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity18.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity18.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity18
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity18.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity18
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity18.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity18.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity18.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity18.setKeep_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        // ・NULL⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity18.setKeep_ID_History(null);
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        try {
            reporthistorydao.insert(inEntity18);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ９．貸付受入金払出・充当報告書の作成（修正）
        // 追加を行うデータの確認
        // （１）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity19 = new UkeirereportEntity();
        inEntity19.setID_Report(strID_Report2);
        long hitcount19 = ukeirereportdao.countByCondition(inEntity19);
        if (0 < hitcount19) {
            // （２）取得した件数＞＝１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB010
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // （３）貸付受入金払出・充当報告書データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        UkeirereportEntity inEntity20 = new UkeirereportEntity();
        // ・修正データの扱店名⇒UkeireReportEntity.扱店名
        inEntity20.setName_Organization(inDto.getLblID_Name_Organization());
        // ・修正データの顧客名⇒UkeireReportEntity.顧客名
        inEntity20.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer()));
        // ・修正データの貸付実行日⇒UkeireReportEntity.貸付実行日
        inEntity20.setDate_Jikko(inDto.getLblID_Date_Jikko());
        // ・修正データの公庫支店⇒UkeireReportEntity.公庫支店コード
        inEntity20.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten()));
        // ・修正データの扱店⇒UkeireReportEntity.扱店コード
        inEntity20.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization()));
        // ・修正データの店舗⇒UkeireReportEntity.店舗コード
        inEntity20.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo()));
        // ・修正データの年度⇒UkeireReportEntity.年度
        inEntity20.setYear(cnvBlankToNull(inDto.getLblID_Year()));
        // ・修正データの⇒UkeireReportEntity.方式資金
        inEntity20.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin()));
        // ・修正データの番号⇒UkeireReportEntity.稟議番号
        inEntity20.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi()));
        // ・修正データの枝番⇒UkeireReportEntity.稟議番号枝番
        inEntity20.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));
        // ・修正データの資金使途⇒UkeireReportEntity.資金使途コード
        inEntity20.setCode_ShikinShito(cnvBlankToNull(inDto.getLblID_Code_ShikinShito()));
        // ・修正データの事業別⇒UkeireReportEntity.事業別コード
        inEntity20.setCode_Jigyobetsu(cnvBlankToNull(inDto.getLblID_Code_Jigyobetsu()));
        // ・修正データの⇒UkeireReportEntity.特利区分
        inEntity20.setCode_TokuriKubun(cnvBlankToNull(inDto.getLblID_Kubun_Tokuri()));
        // ・修正データの⇒UkeireReportEntity.特利
        inEntity20.setTokuri(cnvMultiply1000(inDto.getLblID_Tokuri()));
        // ・修正データの利率⇒UkeireReportEntity.利率
        inEntity20.setRiritsu(cnvMultiply1000(inDto.getLblID_Riritsu()));
        // ・修正データの償還期限⇒UkeireReportEntity.償還期限
        inEntity20.setDate_ShokanKigen(cnvBlankToNull(inDto.getLblID_Date_ShokanKigen()));
        // ・修正データの据置期限⇒UkeireReportEntity.据置期限
        inEntity20.setDate_SueokiKigen(cnvBlankToNull(inDto.getLblID_Date_SueokiKigen()));
        // ・修正データの元利金払込期日⇒UkeireReportEntity.元利金払込日
        String[] date2 = PNCommonComponents.cnvNulltoBlank(inDto.getLblID_Date_GanrikinHaraikomi()).split(
                "\\.");
        if (1 < date.length) {
            date2[0] = String.format("%1$02d", Integer.parseInt(date[0]));
            date2[1] = String.format("%1$02d", Integer.parseInt(date[1]));
        }
        inEntity20.setDate_GanrikinHaraikomi(cnvBlankToNull(PNCommonComponents.concatString(date2[0],
                date2[1])));
        // ・修正データの貸付実行額金額⇒UkeireReportEntity.貸付実行金額
        inEntity20.setM_Kashitsuke(inDto.getLblID_M_Kashitsuke());
        // ・修正データの伝送番号（非表示）⇒UkeireReportEntity.伝送番号
        inEntity20.setID_Denso(cnvBlankToNull(inDto.getID_ID_Denso()));
        // ・西暦に変換した修正データの受託者勘定処理年月⇒UkeireReportEntity.受託者勘定処理年月
        inEntity20.setDate_Jtkshori(cnvBlankToNull(inDto.getLblID_Date_Jtkshori()));
        // ・西暦に変換した修正データの元金充当後第１回約定日⇒UkeireReportEntity.元金充当後第１回約定日
        inEntity20.setDate_FirstYakujoAfterGanju(cnvBlankToNull(inDto.getLblID_Date_FirstYakujoAfterGanju()));
        // ・西暦に変換した修正データの払出・元金充当日⇒UkeireReportEntity.払出元金充当日
        inEntity20.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getLblID_Date_HaraidashiJuto()));
        // ・修正データの繰上償還事由コード⇒UkeireReportEntity.繰上償還事由コード
        inEntity20.setCode_KurishoJiyu(cnvBlankToNull(inDto.getLblID_Code_KurishoJiyu()));
        // ・修正データの元金充当額⇒UkeireReportEntity.元金充当額
        inEntity20.setM_Ganju(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Ganju()));
        // ・修正データの合計（非表示）⇒UkeireReportEntity.合計
        inEntity20.setM_Kei(PNCommonComponents.cnvNulltoZero(inDto.getID_M_Kei()));
        // ・修正データの元金充当後貸付金残高⇒UkeireReportEntity.元金充当後貸付金残高
        inEntity20.setM_KashitsukeZandakaAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeZandakaAfterGanju()));
        // ・修正データの元金充当後の元金均等額⇒UkeireReportEntity.元金充当後元金均等額
        inEntity20.setM_GankinKintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinKintoAfterGanju()));
        // ・修正データの元金充当後の元金不均等額⇒UkeireReportEntity.元金充当後元金不均等額
        inEntity20.setM_GankinFukintoAfterGanju(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_GankinFukintoAfterGanju()));
        // ・修正データの調整コード⇒UkeireReportEntity.調整コード
        inEntity20.setCode_Chosei(cnvBlankToNull(inDto.getRdoID_Code_Chosei()));
        // ・修正データの報告書番号（非表示）⇒UkeireReportEntity.報告書番号
        inEntity20.setID_Report(cnvBlankToNull(strID_Report2));
        // ・修正データの報告年月日⇒UkeireReportEntity.報告年月日
        inEntity20.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・修正データの報告時分秒（非表示）⇒UkeireReportEntity.報告時分秒
        inEntity20.setTime_Report(cnvBlankToNull(inDto.getID_Time_Report().replaceAll(":", "")));
        // ・修正データのユーザID（非表示）⇒UkeireReportEntity.ユーザID
        inEntity20.setUserID(cnvBlankToNull(pnCommonInfo.getLogonID()));
        // ・修正データのデータコード（非表示）⇒UkeireReportEntity.データコード
        inEntity20.setDataCode(cnvBlankToNull(inDto.getID_Data_Code()));
        // ・修正データの貸付受入金受入額⇒UkeireReportEntity.貸付受入金受入額
        inEntity20
                .setM_KashitsukeUkeire(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_KashitsukeUkeire()));
        // ・修正データの資金交付額⇒UkeireReportEntity.資金交付額
        inEntity20.setM_ShikinKofu(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_ShikinKofu()));
        // ・修正データの資金払出額⇒UkeireReportEntity.資金払出額
        inEntity20.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getLblID_M_Haraidashi()));
        // ・修正データの貸付受入金残高⇒UkeireReportEntity.貸付受入金残高
        inEntity20.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                .getLblID_M_KashitsukeukeireZan()));
        // 貸付受入金払出・充当報告書データを追加する。
        // （４）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　登録処理」を参照し、条件を設定する。
        // UkeireReportDAO.insert
        try {
            ukeirereportdao.insert(inEntity20);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }
        // }

        // １０．扱店別稟議データのレコードを更新
        // （１）修正データの値を設定しなおす。
        // ①取得償還方法コード＝"0" or "3" or "4"の場合　　（払出のみ、元金均等償還）
        List<String> checkList5 = Arrays.asList("0", "3", "4");
        if (checkList5.contains(inDto.getType_Shokan())) {
            // （ａ）計算結果用元金均等額⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_Rst_M_GankinKinto());
            // （ｂ）計算結果用元金不均等額⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(inDto.getID_Rst_M_GankinFukinto());
            // （ｃ）計算結果調整コード⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Rst_Code_Chosei());
            // （ｄ）元金充当後貸付金残高⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getLblID_M_KashitsukeZandakaAfterGanju());
            // （ｅ）償還期限⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getLblID_Date_ShokanKigen());
        }
        // ②取得償還方法コード＝"1" or "2" or "5" or "6"の場合
        List<String> checkList6 = Arrays.asList("1", "2", "5", "6");
        if (checkList6.contains(inDto.getType_Shokan())) {
            // （ａ）""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // （ｂ）""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // （ｃ）""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto("");
            // （ｄ）""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // （ｅ）""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
        }
        // ③償還方法タイプ識別値 （DB更新時の受渡し領域）⇒更正（赤）データの償還方法タイプ識別値
        // ④"0"⇒稟議データ更新フラグ
        inDto.setRingiRedFlg("0");
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        AringiEntity inEntity21 = new AringiEntity();
        inEntity21.setID_Credit(inDto.getID_ID_Credit());
        inEntity21.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        long hitcount21 = aringidao.countByCondition(inEntity21);

        if (1 != hitcount21) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PTN001,DB007
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：BA001,DB004
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 扱店別稟議データを排他読込をする。
        // （５）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        AringiEntity inEntity23 = new AringiEntity();
        inEntity23.setID_Credit(inDto.getID_ID_Credit());
        try {
            AringiEntity outEntity23 = aringidao.findByPrimaryKeyForUpdate(inEntity23);

            if (null == outEntity23) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PTN001,DB007
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);

        }
        // }

        // （７）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        AringiEntity inEntity24 = new AringiEntity();
        inEntity24.setID_Credit(inDto.getID_ID_Credit());
        // ①償還タイプ＝"5" or "6"（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // （ａ）最新更新日時の設定

            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity24.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(null);

            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity24.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else {
            // ③上記①② 以外の場合
            // （ａ）元金不均等額区分の設定
            // 更新用元金不均等区分（非表示）⇒aRingiEntity.元金不均等額区分
            inEntity24.setKubun_GankinFukintogaku(inDto.getID_Up_Kubun_GankinFukinto());
            // （ｂ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity24.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // （ｃ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            if (null != cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu())) {
                inEntity24.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
            }
            // （ｄ）賦金の設定
            // 更新用賦金（非表示）⇒aRingiEntity.賦金
            if (null != inDto.getID_Up_M_Fukin()) {
                inEntity24.setM_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
            }
            // （ｅ）元金不均等額の設定
            // 更新用元金不均等（非表示）⇒aRingiEntity.元金不均等額
            if (null != inDto.getID_Up_M_GankinFukinto()) {
                inEntity24.setM_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_GankinFukinto()));
            }
            // （ｆ）貸付金残高の設定
            // 更新用貸付金残高（非表示）⇒aRingiEntity.貸付金残高
            if (null != inDto.getID_Up_M_KashitsukeZan()) {
                inEntity24.setM_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_KashitsukeZan()));
            }
            // （ｇ）償還期限年月の設定
            // 更新用償還期限年月（非表示）⇒aRingiEntity.償還期限年月
            if (null != cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen())) {
                inEntity24.setDate_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
            }
        }
        // 扱店別稟議データを更新をする。
        // （８）償還タイプの判定
        // ①償還タイプ＝"5" or "6"の場合
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(定期償還・特殊償還)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity24);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆修正)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity24);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else {
            // ③上記①②以外の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆取消)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity24);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // １１．請求データのレコードﾞを更新
        // （１）取得償還方法コード＝"0" or "3" or "4"の場合　　（払出のみ、元金均等償還　以外）
        List<String> checkList7 = Arrays.asList("0", "3", "4");
        if (checkList7.contains(inDto.getType_Shokan())) {
            // ①請求データ更新判定フラグ＝Ｔｕｒｅ ＡＮＤ 請求データを取消更新する場合のフラグ＝Ｔｕｒｅ の場合
            if (inDto.getSeikyuShuseiUp() && inDto.getFlgSeikyuUpShusei()) {
                // （ａ）修正データの値を設定しなおす。
                // （ⅰ）計算約定利息（非表示）⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_Rst_M_YakujoRisoku());
                // （ⅱ）計算約定元金（非表示）⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_Rst_M_YakujoGankin());
                // （ⅲ）請求・払込年月日（非表示）⇒請求データ更新用・Key:払込年月日_領域
                inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getID_Key_Date_Haraikomi_Seikyu_Shusei());
                // 更新を行うデータの確認
                // （ｂ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                SeikyuEntity inEntity25 = new SeikyuEntity();
                inEntity25.setID_Credit(inDto.getID_ID_Credit());
                inEntity25.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                long hitcount25 = seikyudao.countByCondition(inEntity25);
                if (1 != hitcount25) {
                    // （ｃ）取得した件数＝０の場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB011
                    // （ｄ）取得した件数＞１の場合、業務エラーとする。
                    // エラーメッセージ：BA001,DB004
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                }

                // 請求データを排他読込をする。
                // （ｅ）単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                SeikyuEntity inEntity26 = new SeikyuEntity();
                inEntity26.setID_Credit(inDto.getID_ID_Credit());
                inEntity26.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                try {
                    SeikyuEntity outEntity26 = seikyudao.findByPrimaryKeyForUpdate(inEntity26);
                    //
                    if (null == outEntity26) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // // すでに更新されているかチェック処理を記述
                    //
                } catch (CFWFindParameterException fpe) {
                    // // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    //
                } catch (CFWForUpdateException fue) {
                    // （ｆ）)排他エラーの場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB007
                    // // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                }

                // （ｇ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                SeikyuEntity inEntity27 = new SeikyuEntity();
                inEntity27.setID_Credit(inDto.getID_ID_Credit());
                inEntity27.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                // （ⅰ）約定利息の設定
                // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                inEntity27
                        .setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
                // （ⅱ）約定元金の設定
                // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                inEntity27
                        .setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
                // 請求データを更新をする。
                // （ｈ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                try {
                    seikyudao.update(inEntity27);
                    // 検索条件値エラー
                } catch (CFWFindParameterException fpe) {
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    // 主キー更新時の一意性制約エラー
                } catch (CFWDuplicateKeyException dke) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                }
            }
        }
        // １２．払出データの追加
        // （１）取得償還方法コード＝"0" or "1" or "2" or "3" or "4"の場合
        List<String> checkList8 = Arrays.asList("0", "1", "2", "3", "4");
        if (checkList8.contains(inDto.getType_Shokan())) {
            // ①追加する値を設定
            // （ａ）修正用・払出データ項目の修正用払出・債権管理番号⇒修正用払出・債権管理番号
            inDto.setID_Ins_ID_Credit(inDto.getID_HDNew0_ID_Credit());
            // （ｂ）修正用・払出データ項目の修正用払出・計数管理処理番号⇒取消用払出・計数管理処理番号
            inDto.setID_Ins_KeisuKanriShori(inDto.getID_HDNew0_KeisuKanriShori());
            // （ｃ）修正用・払出データ項目の修正用払出・払出充当年月日⇒取消用払出・払出充当年月日
            inDto.setID_Ins_Date_HaraidashiJuto(inDto.getID_HDNew0_Date_HaraidashiJuto());
            // （ｄ）修正用・払出データ項目の修正用払出・払出額⇒取消用払出・払出額
            inDto.setID_Ins_M_Haraidashi(inDto.getID_HDNew_M_Haraidashi());
            // （ｅ）修正用・払出データ項目の修正用払出・繰上償還額⇒取消用払出・繰上償還額
            inDto.setID_Ins_M_Kurisho(inDto.getID_HDNew0_M_Kurisho());
            // （ｆ）修正用・払出データ項目の修正用払出・貸付受入金残高⇒取消用払出・貸付受入金残高
            inDto.setID_Ins_M_HaraidashiKashitsukeZan(inDto.getID_HDNew0_M_HaraidashiKashitsukeZan());
            // （ｇ）修正用・払出データ項目の修正用払出・払出累計額⇒取消用払出・払出累計額
            inDto.setID_Ins_M_HaraidashiRuikei(inDto.getID_HDNew0_M_HaraidashiRuikei());
            // （ｈ）修正用・払出データ項目の修正用払出・繰上償還累計額⇒取消用払出・繰上償還累計額
            inDto.setID_Ins_M_KurishoRuikei(inDto.getID_HDNew0_M_KurishoRuikei());
            // （ｉ）修正用・払出データ項目の修正用払出・更生処理区分⇒取消用払出・更生処理区分
            inDto.setID_Ins_Kubun_KoseiShori(inDto.getID_HDNew0_Kubun_KoseiShori());
            // （ｊ）修正用・払出データ項目の修正用払出・貸付受入金残高積数⇒取消用払出・貸付受入金残高積数
            inDto.setID_Ins_M_ZandakaSekisu(inDto.getID_HDNew0_M_ZandakaSekisu());
            // （ｋ）修正用・払出データ項目の修正用払出・債権管理番号⇒Key債権管理番号
            inDto.setID_Ins_ID_Credit(inDto.getID_HDNew0_ID_Credit());
            // （ｌ）修正用・払出データ項目の修正用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDNew0_KeisuKanriShori());
            // 追加を行うデータの確認
            // （１）単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity28 = new HaraidashiEntity();
            inEntity28.setID_Credit(inDto.getKey_ID_Credit());
            inEntity28.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount28 = haraidashidao.countByCondition(inEntity28);
            if (0 < hitcount28) {
                // （２）取得した件数＞＝１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB010
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

            // （３）払出データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // ①追加する値を設定
            HaraidashiEntity inEntity29 = new HaraidashiEntity();
            // （ａ）修正データの債権管理番号（非表示）⇒HaraidashiEntity.債権管理番号
            inEntity29.setID_Credit(inDto.getID_Ins_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒HaraidashiEntity.計数管理処理番号
            inEntity29.setID_KeisuKanriShori(cnvBlankToNull(inDto.getID_Ins_KeisuKanriShori()));
            // （ｃ）取消用払出・払出額⇒HaraidashiEntity.払出額
            inEntity29.setM_Haraidashi(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_Haraidashi()));
            // （ｄ）取消用払出・払出累計額⇒HaraidashiEntity.払出累計額
            inEntity29.setM_HaraidashiRuikei(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_Ins_M_HaraidashiRuikei()));
            // （ｅ）取消用払出・繰上償還額⇒HaraidashiEntity.繰上償還額
            inEntity29.setM_Kurisho(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_Kurisho()));
            // （ｆ）取消用払出・繰上償還累計額⇒HaraidashiEntity.繰上償還累計額
            inEntity29
                    .setM_KurishoRuikei(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_KurishoRuikei()));
            // （ｇ）取消用払出・更生処理区分⇒HaraidashiEntity.更正処理区分
            inEntity29.setKubun_KoseiShori(cnvBlankToNull(inDto.getID_Ins_Kubun_KoseiShori()));
            // （ｈ）取消用払出・貸付受入金残高積数⇒HaraidashiEntity.貸付受入金残高積数
            inEntity29
                    .setM_ZandakaSekisu(PNCommonComponents.cnvNulltoZero(inDto.getID_Ins_M_ZandakaSekisu()));
            // （ｉ）取消用払出・払出充当年月日⇒HaraidashiEntity.払出充当年月日
            inEntity29.setDate_HaraidashiJuto(cnvBlankToNull(inDto.getID_Ins_Date_HaraidashiJuto()));
            // （ｊ）取消用払出・貸付受入金残高⇒HaraidashiEntity.貸付受入金残高
            inEntity29.setM_KashitsukeukeireZan(PNCommonComponents.cnvNulltoZero(inDto
                    .getID_Ins_M_HaraidashiKashitsukeZan()));
            // 払出データを追加する。
            // （４）単テーブルアクセス定義「払出データ　登録処理」を参照し、条件を設定する。
            try {
                haraidashidao.insert(inEntity29);
            } catch (CFWDuplicateKeyException dke) {
                // 主キー更新時の一意性制約エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }
        return outDto;
    }

    /**
     * Md002_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md002_02DTO
     * @return Md002_02DTO
     */
    @Override
    public Md002_02DTO updateDataNotProcEndDelCalcel(Md002_02DTO inDto) {

        Md002_02DTO outDto = new Md002_02DTO();

        // 更正（赤）：処理完了以外の更新処理。
        // 　＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // １．報告書履歴データのレコードを更新
        // （１）更正（赤）データの値を設定しなおす。
        // ③現在の日付⇒更正（赤）データの報告年月日
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);
        inDto.setID_Date_Report(pnBusinessDay);
        // ④現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        String sysDateTime = PNCommonComponents.getSysDateTime();
        inDto.setID_Time_Report(sysDateTime);
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        inEntity.setID_History(inDto.getID_ID_History());
        long hitcount = reporthistorydao.countByCondition(inEntity);
        if (1 != hitcount) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity1 = new ReporthistoryEntity();
        inEntity1.setID_History(inDto.getID_ID_History());
        try {
            ReporthistoryEntity outEntity1 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity1);

            if (null == outEntity1) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }
        // }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        ReporthistoryEntity inEntity2 = new ReporthistoryEntity();
        inEntity2.setID_History(inDto.getID_ID_History());
        // ①取消：処理完了以外（更正（赤））の場合
        // ①""⇒更正（赤）データの報告書番号（非表示）
        // ②"1"⇒更正（赤）データの取消済みフラグ（非表示）
        // （ａ）取消済みフラグ（非表示）＝０ の場合
        // （ｂ）取消済みフラグ（非表示）＝０ 以外の場合
        // （ⅰ）更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
        inEntity2.setID_Report("");
        // （ⅱ）更正（赤）データの取消済フvラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity2.setFlag_Torikeshizumi(BigDecimal.ONE);

        // 報告書履歴データを更新をする。
        // （８）単テーブルアクセス定義「処理完了以外：取消（更正（赤））&取消済みフラグ=0以外)」を参照し、条件を設定する。
        try {
            reporthistorydao.update(inEntity2);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ２．貸付受入金払出・充当報告書の該当レコードの削除
        // （１）更正（赤）データの値を設定しなおす。
        // ①報告書番号（非表示）⇒更正（赤）データの報告書番号
        // 削除を行うデータの確認
        // （２）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　件数取得」を参照し、条件を設定する。
        UkeirereportEntity inEntity3 = new UkeirereportEntity();
        inEntity3.setID_Report(inDto.getID_ID_Report());
        long hitcount3 = ukeirereportdao.countByCondition(inEntity3);
        if (1 != hitcount3) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

        }

        // 貸付受入金払出・充当報告書データを排他読込をする。
        UkeirereportEntity inEntity4 = new UkeirereportEntity();
        inEntity4.setID_Report(inDto.getID_ID_Report());
        // （５）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　排他読込」を参照し、条件を設定する。
        try {
            UkeirereportEntity outEntity4 = ukeirereportdao.findByPrimaryKeyForUpdate(inEntity4);

            if (null == outEntity4) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            //
        }
        // （６）排他エラーの場合、業務エラーとする。
        // エラーメッセージ：PTN001,DB007
        // 貸付受入金払出・充当報告書データを削除する。
        // （７）単テーブルアクセス定義「貸付受入金払出・充当報告書データ　削除処理」を参照し、条件を設定する。
        UkeirereportEntity inEntity5 = new UkeirereportEntity();
        inEntity5.setID_Report(inDto.getID_ID_Report());
        try {
            ukeirereportdao.delete(inEntity5);
        } catch (CFWFindParameterException fpe) {
            // // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // ３．扱店別稟議データのレコードを戻し更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの貸付金残高、償還期限年月をデータ取得時の値で更新
        // （１）更正（赤）データの値を設定しなおす。
        // ①取得償還方法コード＝"1"の場合　　（元利均等償還）
        if ("1".equals(inDto.getCharCode_ShokanHouhou())) {
            // （ａ）""⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(null);
            // （ｂ）""⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(null);
            // （ｃ）""⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(null);
            // （ｄ）""⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(null);
            // （ｅ）""⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen("");
            // （ｆ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            // ②取得償還方法コード＝"0" or "2"の場合　　（払出のみ、元金均等償還）
        } else if ("0".equals(inDto.getCharCode_ShokanHouhou())
                || "2".equals(inDto.getCharCode_ShokanHouhou())) {
            // （ａ）退避賦金（非表示）⇒更新用賦金（非表示）
            inDto.setID_Up_M_Fukin(inDto.getID_Keep_M_Fukin());
            // （ｂ）退避元金不均等（非表示）⇒更新用元金不均等（非表示）
            inDto.setID_Up_M_GankinFukinto(inDto.getID_Keep_M_GankinFukinto());
            // （ｃ）退避元金不均等区分（非表示）⇒更新用元金不均等区分（非表示）
            inDto.setID_Up_Kubun_GankinFukinto(inDto.getID_Keep_Kubun_GankinFukinto());
            // （ｄ）退避貸付金残高（非表示）⇒更新用貸付金残高（非表示）
            inDto.setID_Up_M_KashitsukeZan(inDto.getID_Keep_M_KashitsukeZan());
            // （ｅ）退避償還期限年月（非表示）⇒更新用償還期限年月（非表示）
            inDto.setID_Up_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
            // （ｆ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
            // ③取得償還方法コード＝"3" or "9"の場合　　（定期償還・特殊償還）
        } else if ("3".equals(inDto.getCharCode_ShokanHouhou())
                || "9".equals(inDto.getCharCode_ShokanHouhou())) {
            // （ａ）退避条変起案中区分（非表示）⇒更新用条変起案中区分（非表示）
            inDto.setID_Up_Kubun_JohenKianchu(inDto.getID_Keep_JohenKianchu());
        }
        // ④償還方法タイプ識別値 （DB更新時の受渡し領域）⇒更正（赤）データの償還方法タイプ識別値

        // ⑤"1"⇒稟議データ更新フラグ
        inDto.setRingiRedFlg("1");

        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        AringiEntity inEntity6 = new AringiEntity();
        inEntity6.setID_Credit(inDto.getID_ID_Credit());
        inEntity6.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        long hitcount6 = aringidao.countByCondition(inEntity6);
        if (1 != hitcount6) {
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 扱店別稟議データを排他読込をする。
        // （５）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // AringiDAO.findByPrimaryKeyForUpdate
        AringiEntity inEntity7 = new AringiEntity();
        inEntity7.setID_Credit(inDto.getID_ID_Credit());
        try {
            AringiEntity outEntity7 = aringidao.findByPrimaryKeyForUpdate(inEntity7);

            if (null == outEntity7) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);

        }

        // （７）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        AringiEntity inEntity8 = new AringiEntity();
        inEntity8.setID_Credit(inDto.getID_ID_Credit());
        // ①償還タイプ＝"5" or "6"（定期償還・特殊償還）
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity8.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity8.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }

            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity8.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // （ａ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity8.setData_LastUpDate(null);
            } else {
                // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
                inEntity8.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));
            }
            // （ｂ）条変起案中区分の設定
            // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
            inEntity8.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
        } else {
            // ③上記①② 以外の場合
            // （ａ）元金不均等額区分の設定
            // 更新用元金不均等区分（非表示）⇒aRingiEntity.元金不均等額区分
            inEntity8.setKubun_GankinFukintogaku(inDto.getID_Up_Kubun_GankinFukinto());
            // （ｂ）最新更新日時の設定
            if (isEmpty(inDto.getID_Date_Report()) && isEmpty(inDto.getID_Time_Report().replaceAll(":", ""))) {
                inEntity8.setData_LastUpDate(null);
            } else {
                // 更正（赤）データの報告年月日と画面の報告時分秒が空白の場合、"NULL"⇒　aRingiEntity.最新更新日時
                inEntity8.setData_LastUpDate(cnvTimeStamp(inDto.getID_Date_Report(),
                        inDto.getID_Time_Report()));

            }
            // 上記以外の場合、現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            // （ｃ）条変起案中区分の設定
            if (null != cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu())) {
                // 更新用条変起案中区分（非表示）⇒aRingiEntity.条変起案中区分
                inEntity8.setKubun_JohenKianchu(cnvBlankToNull(inDto.getID_Up_Kubun_JohenKianchu()));
            }
            // （ｄ）賦金の設定
            if (null != inDto.getID_Up_M_Fukin()) {
                // 更新用賦金（非表示）⇒aRingiEntity.賦金
                inEntity8.setM_Fukin(inDto.getID_Up_M_Fukin());
            }
            // （ｅ）元金不均等額の設定
            if (null != inDto.getID_Up_M_GankinFukinto()) {
                // 更新用元金不均等（非表示）⇒aRingiEntity.元金不均等額
                inEntity8.setM_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_GankinFukinto()));
            }
            // （ｆ）貸付金残高の設定
            if (null != inDto.getID_Up_M_KashitsukeZan()) {
                // 更新用貸付金残高（非表示）⇒aRingiEntity.貸付金残高
                inEntity8.setM_KashitsukeZandaka(PNCommonComponents.cnvNulltoZero(inDto
                        .getID_Up_M_KashitsukeZan()));
            }
            // （ｇ）償還期限年月の設定
            if (null != cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen())) {
                // 更新用償還期限年月（非表示）⇒aRingiEntity.償還期限年月
                inEntity8.setDate_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
            }
        }
        // 扱店別稟議データを更新をする。
        // （８）償還タイプの判定
        // ①償還タイプ＝"5" or "6"の場合
        if ("5".equals(inDto.getType_Shokan()) || "6".equals(inDto.getType_Shokan())) {
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(定期償還・特殊償還)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity8);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else if ("0".equals(inDto.getType_Shokan()) && "0".equals(inDto.getRingiRedFlg())) {
            // ②償還タイプ＝"0" AND 稟議データ更新フラグ＝"0" の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆修正)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity8);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        } else {
            // ③上記①②以外の場合
            // 単テーブルアクセス定義「扱店別稟議データ　更新処理(資金払出のみ＆取消)」を参照し、条件を設定する。
            try {
                aringidao.update(inEntity8);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }

        // ４．請求ﾃﾞｰﾀのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        // （１）取得償還方法コード＝"1" or "2"の場合　（元利均等償還、元利均等償還）
        if ("1".equals(inDto.getCharCode_ShokanHouhou()) || "2".equals(inDto.getCharCode_ShokanHouhou())) {
            // ①退避約定利息（非表示）＜＞"" AND 退避約定元金（非表示）＜＞"" の場合
            if (null != inDto.getID_Keep_M_YakujoGankin() && null != inDto.getID_Keep_M_YakujoRisoku()) {
                // （ａ）更正（赤）データの値を設定しなおす。
                // （ⅰ）退避約定元金（非表示）⇒更新用約定元金（非表示）
                inDto.setID_Up_M_YakujoGankin(inDto.getID_Keep_M_YakujoGankin());
                // （ⅱ）退避約定利息（非表示）⇒更新用約定利息（非表示）
                inDto.setID_Up_M_YakujoRisoku(inDto.getID_Keep_M_YakujoRisoku());
                // （ⅲ）元金充当後第１回約定日⇒請求データ更新用・Key:払込年月日_領域
                inDto.setID_Key_Date_Haraikomi_SeikyuUp(inDto.getLblID_Date_FirstYakujoAfterGanju_Red());
                // 更新を行うデータの確認
                // （ｂ）単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
                SeikyuEntity inEntity9 = new SeikyuEntity();
                inEntity9.setID_Credit(inDto.getID_ID_Credit());
                inEntity9.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                long hitcount9 = seikyudao.countByCondition(inEntity9);
                if (1 != hitcount9) {
                    // （ｃ）取得した件数＝０の場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB011
                    // （ｄ）取得した件数＞１の場合、業務エラーとする。
                    // エラーメッセージ：BA001,DB004
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

                }
                // 請求データを排他読込をする。
                // （ｅ）単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。

                SeikyuEntity inEntity10 = new SeikyuEntity();
                inEntity10.setID_Credit(inDto.getID_ID_Credit());
                inEntity10.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                try {
                    SeikyuEntity outEntity10 = seikyudao.findByPrimaryKeyForUpdate(inEntity10);
                    //
                    if (null == outEntity10) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // // すでに更新されているかチェック処理を記述
                    //
                } catch (CFWFindParameterException fpe) {
                    // // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    //
                } catch (CFWForUpdateException fue) {
                    // （ｆ）)排他エラーの場合、業務エラーとする。
                    // エラーメッセージ：PTN001,DB007
                    // // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                }
                //
                // }

                // （ｇ）請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                SeikyuEntity inEntity11 = new SeikyuEntity();
                inEntity11.setID_Credit(inDto.getID_ID_Credit());
                inEntity11.setDate_Haraikomi(inDto.getID_Key_Date_Haraikomi_SeikyuUp());
                // （ⅰ）約定利息の設定
                // 更新用約定利息（非表示）⇒SeikyuEntity.約定利息
                inEntity11
                        .setM_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
                // （ⅱ）約定元金の設定
                // 更新用約定元金（非表示）⇒SeikyuEntity.約定元金
                inEntity11
                        .setM_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
                // 請求データを更新をする。
                // （ｈ）単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                try {
                    seikyudao.update(inEntity11);
                } catch (CFWFindParameterException fpe) {
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                    // 主キー更新時の一意性制約エラー
                } catch (CFWDuplicateKeyException dke) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
                }
            }
        }

        // ５．払出データの削除　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞを削除
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合　　（払出のみ・元利均等償還・元金均等償還）
        List<String> checkList = Arrays.asList("0", "1", "2");
        if (checkList.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）"99999990001"⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori("99999990001");
            // 削除を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity12 = new HaraidashiEntity();
            inEntity12.setID_Credit(inDto.getKey_ID_Credit());
            inEntity12.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount12 = haraidashidao.countByCondition(inEntity12);
            if (1 != hitcount12) {
                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB009
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB004
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity13 = new HaraidashiEntity();
            inEntity13.setID_Credit(inDto.getKey_ID_Credit());
            inEntity13.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {

                HaraidashiEntity outEntity13 = haraidashidao.findByPrimaryKeyForUpdate(inEntity13);

                if (null == outEntity13) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PTN001,DB007
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }
            // }

            // 払出データを削除する。
            // ⑦単テーブルアクセス定義「払出データ　削除処理」を参照し、条件を設定する。
            HaraidashiEntity inEntity14 = new HaraidashiEntity();
            inEntity14.setID_Credit(inDto.getKey_ID_Credit());
            inEntity14.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                haraidashidao.delete(inEntity14);
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

            }
        }

        // 更正（赤）データの復活処理
        // ６．履歴データの復活処理
        // （１）更正（赤）データの値を設定しなおす。
        // ①退避履歴番号⇒更正（赤）データの報告書番号（非表示）
        inDto.setID_ID_History(inDto.getID_Keep_ID_History());
        // 更新を行うデータの確認
        // （２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        ReporthistoryEntity inEntity15 = new ReporthistoryEntity();
        inEntity15.setID_History(inDto.getID_ID_History());
        long hitcount15 = reporthistorydao.countByCondition(inEntity);

        if (1 != hitcount15) {
            // （３）取得した件数＝０の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            // （４）取得した件数＞１の場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 報告書履歴データを排他読込をする。
        // （５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        ReporthistoryEntity inEntity16 = new ReporthistoryEntity();
        inEntity16.setID_History(inDto.getID_ID_History());
        try {
            ReporthistoryEntity outEntity16 = reporthistorydao.findByPrimaryKeyForUpdate(inEntity16);

            if (null == outEntity16) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // すでに更新されているかチェック処理を記述
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            // （６）排他エラーの場合、業務エラーとする。
            // エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        }

        // （７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
        ReporthistoryEntity inEntity17 = new ReporthistoryEntity();
        inEntity17.setID_History(inDto.getID_ID_History());
        // ①取消：処理完了以外（更正（赤））の場合
        // （ⅱ）更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity17.setFlag_Torikeshizumi(BigDecimal.ZERO);

        // 報告書履歴データを更新をする。
        // （８）取消済みフラグの判定
        // ①取消済みフラグ＝０の場合
        // 単テーブルアクセス定義「報告書履歴データ　更新処理(処理完了以外：取消（更正（赤））&取消済みフラグ=0)」を参照し、条件を設定する。
        // ReporthistoryDAO.updata
        // ②取消済みフラグ＝０以外の場合
        // 単テーブルアクセス定義「報告書履歴データ　更新処理(処理完了以外：取消（更正（赤））&取消済みフラグ=0以外)」を参照し、条件を設定する。
        // ReporthistoryDAO.updata
        try {
            reporthistorydao.update(inEntity17);
            // 検索条件値エラー
        } catch (CFWFindParameterException fpe) {
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            // 主キー更新時の一意性制約エラー
        } catch (CFWDuplicateKeyException dke) {
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ７．履歴データの追加（更正（赤）取消）
        ReporthistoryEntity inEntity18 = new ReporthistoryEntity();

        // （ａ）履歴番号の再取得および登録値として再設定する。
        // 履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();

        // ③取得した件数＝０の場合、繰り返しから抜ける。
        // （２）取得した件数＝０の場合、データの追加処理を行う。
        // ①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        // ・更正（赤）データの履歴番号⇒ReporthistoryEntity.履歴番号
        inEntity18.setID_History(cnvBlankToNull(strID_History));
        // ・更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号（ブランクを設定）
        inEntity18.setID_Report("");
        // ・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        inEntity18.setDate_Report(cnvBlankToNull(inDto.getID_Date_Report()));
        // ・現在の時刻⇒ReporthistoryEntity.報告時分秒
        inEntity18.setTime_Report(PNCommonComponents.getSysDateTime().replaceAll(":", ""));
        // ・更正（赤）データのステータス⇒ReporthistoryEntity.ステータス
        BigDecimal status = null;
        if (null != inDto.getID_Status()) {
            status = new BigDecimal(inDto.getID_Status());
        }
        inEntity18.setStatus(status);
        // ・更正（赤）データのデータコード⇒ReporthistoryEntity.データコード
        inEntity18.setDataCode(cnvBlankToNull(inDto.getID_Data_Code()));
        // ・更正（赤）データの処理種別⇒ReporthistoryEntity.処理種別
        inEntity18.setType_Process(cnvBlankToNull(inDto.getID_Type_Process()));
        // ・更正（赤）データの取消済フラグ⇒ReporthistoryEntity.取消済フラグ
        inEntity18.setFlag_Torikeshizumi(inDto.getID_Flag_Torikeshizumi());
        // ・更正（赤）データのユーザID⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        inEntity18.setUserID(pnCommonInfo.getLogonID());
        // ・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        inEntity18.setName_Organization(cnvBlankToNull(inDto.getLblID_Name_Organization_Red()));
        // ・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        inEntity18.setName_Customer(cnvBlankToNull(inDto.getLblID_Name_Customer_Red()));
        // ・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        inEntity18.setCode_KoukoShiten(cnvBlankToNull(inDto.getLblID_Code_KoukoShiten_Red()));
        // ・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        inEntity18.setCode_Organization(cnvBlankToNull(inDto.getLblID_Code_Organization_Red()));
        // ・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        inEntity18.setCode_Tenpo(cnvBlankToNull(inDto.getLblID_Code_Tenpo_Red()));
        // ・更正（赤）データの年度⇒ReporthistoryEntity.年度
        inEntity18.setYear(cnvBlankToNull(inDto.getLblID_Year_Red()));
        // ・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        inEntity18.setCode_HoshikiShikin(cnvBlankToNull(inDto.getLblID_Code_HoshikiShikin_Red()));
        // ・更正（赤）データの番号⇒ReporthistoryEntity.番号
        inEntity18.setID_Ringi(cnvBlankToNull(inDto.getLblID_ID_Ringi_Red()));
        // ・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        inEntity18.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));
        // ・更正（赤）データのエラーコード⇒ReporthistoryEntity.エラーコード
        inEntity18.setCode_Error(cnvBlankToNull(inDto.getID_Code_Error()));
        // ・更正（赤）データのエラーメッセージ⇒ReporthistoryEntity.エラーメッセージ
        inEntity18.setErrorMessage(cnvBlankToNull(inDto.getID_ErrorMessage()));
        // ・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        inEntity18.setID_Credit(inDto.getID_ID_Credit());
        // ・更新用賦金（非表示）⇒ReporthistoryEntity.退避賦金
        inEntity18.setKeep_M_Fukin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_Fukin()));
        // ・更新用元金不均等（非表示）⇒ReporthistoryEntity.退避元金不均等額
        inEntity18
                .setKeep_M_GankinFukinto(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_GankinFukinto()));
        // ・更新用元金不均等区分（非表示）⇒ReporthistoryEntity.退避元金不均等区分
        inEntity18.setKeep_Kubun_GankinFukinto(cnvBlankToNull(inDto.getID_Up_Kubun_GankinFukinto()));
        // ・更新用貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        inEntity18
                .setKeep_M_KashitsukeZan(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_KashitsukeZan()));
        // ・更新用約定元金（非表示）⇒ReporthistoryEntity.退避約定元金
        inEntity18.setKeep_M_YakujoGankin(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoGankin()));
        // ・更新用約定利息（非表示）⇒ReporthistoryEntity.退避約定利息
        inEntity18.setKeep_M_YakujoRisoku(PNCommonComponents.cnvNulltoZero(inDto.getID_Up_M_YakujoRisoku()));
        // ・西暦変換した更新用償還期限年月（非表示）⇒ReporthistoryEntity.退避償還期限年月
        inEntity18.setKeep_Date_ShokanKigen(cnvBlankToNull(inDto.getID_Up_Date_ShokanKigen()));
        // ・更新用条変起案中区分（非表示）⇒ReporthistoryEntity.退避条変起案中区分
        inEntity18.setKeep_JohenKianchu(null);
        // ・NULL⇒ReporthistoryEntity.退避報告書履歴番号
        inEntity18.setKeep_ID_History(null);
        // 報告書履歴データを追加する。
        // ②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        try {
            reporthistorydao.insert(inEntity18);
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // ８．払出データの復活　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの復活
        // （１）取得償還方法コード＝"0" or "1" or "2"の場合
        List<String> checkList2 = Arrays.asList("0", "1", "2");
        if (checkList2.contains(inDto.getCharCode_ShokanHouhou())) {
            // ①更正（赤）データの値を設定しなおす。
            // （ａ）取消用払出・債権管理番号⇒Key債権管理番号
            inDto.setKey_ID_Credit(inDto.getID_HDDel1_Keep_ID_Credit());
            // （ｂ）取消用払出・計数管理処理番号⇒Key計数管理処理番号
            inDto.setKey_ID_KeisuKanriShori(inDto.getID_HDDel1_Keep_ID_KeisuKanriShori());
            // 更新を行うデータの確認
            // ②単テーブルアクセス定義「払出データ　件数取得」を参照し、条件を設定する。
            HaraidashiEntity inEntity19 = new HaraidashiEntity();
            inEntity19.setID_Credit(inDto.getKey_ID_Credit());
            inEntity19.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            long hitcount19 = haraidashidao.countByCondition(inEntity19);
            if (1 != hitcount19) {
                // ③取得した件数＝０の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB011
                // ④取得した件数＞１の場合、業務エラーとする。
                // エラーメッセージ：BA001,DB004
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);

            }

            // 払出データを排他読込をする。
            // ⑤単テーブルアクセス定義「払出データ　排他読込」を参照し、条件を設定する。
            HaraidashiEntity inEntity20 = new HaraidashiEntity();
            inEntity20.setID_Credit(inDto.getKey_ID_Credit());
            inEntity20.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            try {
                HaraidashiEntity outEntity20 = haraidashidao.findByPrimaryKeyForUpdate(inEntity20);

                if (null == outEntity20) {
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // すでに更新されているかチェック処理を記述
                //
            } catch (CFWFindParameterException fpe) {
                // // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                //
            } catch (CFWForUpdateException fue) {
                // ⑥排他エラーの場合、業務エラーとする。
                // エラーメッセージ：PTN001,DB007
                // // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                //
            }

            // ⑦払出データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
            HaraidashiEntity inEntity21 = new HaraidashiEntity();
            inEntity21.setID_Credit(inDto.getKey_ID_Credit());
            inEntity21.setID_KeisuKanriShori(inDto.getKey_ID_KeisuKanriShori());
            // （ａ）更正処理区分の設定
            // （ⅰ）画面表示処理のモード＝更正（赤）の取消の場合
            // "0"⇒更正処理区分
            inEntity21.setKubun_KoseiShori("0");
            // 払出データを更新する。
            // ⑧単テーブルアクセス定義「払出データ　更新処理」を参照し、条件を設定する。
            // HaraidashiDAO.updata
            try {
                haraidashidao.update(inEntity21);
            } catch (CFWFindParameterException fpe) {
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                // 主キー更新時の一意性制約エラー
            } catch (CFWDuplicateKeyException dke) {
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
            }
        }
        return outDto;
    }

    /**
     * 日付文字列（西暦yyyyMMdd）と時刻文字（hh:mm:ss）からTimestampを返す。
     *
     * @param strDateTime 日付文字列（yyyyMMdd HH:mm:ss）
     * @return Timestamp
     */
    private Timestamp cnvTimeStamp(String strDateTime) {

        Timestamp ret = null;

        try {
            ret = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDateTime).getTime());
        } catch (ParseException e) {
            ret = null;
        }

        return ret;
    }

    /**
     * 日付文字列（西暦yyyyMMdd）と時刻文字（hh:mm:ss）からTimestampを返す。
     *
     * @param strDate 日付文字列（西暦yyyyMMdd）
     * @param strTime 時刻文字（hh:mm:ss）
     * @return Timestamp
     */
    private Timestamp cnvTimeStamp(String strDate, String strTime) {

        Timestamp ret = null;
        try {
            String strDateTime = PNCommonComponents.concatString(strDate, " ", strTime);
            ret = new Timestamp(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(strDateTime).getTime());

        } catch (IllegalArgumentException iae) {
            ret = null;
        } catch (NullPointerException npe) {
            ret = null;
        } catch (ParseException pe) {
            ret = null;
        }

        return ret;
    }

    /**
     *
     * <pre>
     * 未入力判定
     * </pre>
     *
     * @param value 入力値
     * @return boolean 未入力:true/入力済:false
     */
    private boolean isEmpty(String value) {

        if (null == value || 0 == value.length()) {

            return true;
        }

        return false;
    }

    /**
     *
     * <pre>
     * 引数の値が空白の場合、null値を返却し、空白以外の場合は受け取った値をそのまま返却
     * </pre>
     *
     * @param strVal 判定する値
     * @return
     */
    private String cnvBlankToNull(String strVal) {

        // 引数の値が空白の場合、"NULL"を返却
        String ret = null;
        if (null != strVal && 0 < strVal.length()) {
            // 引数の値が空白以外の場合、引数の値を返却
            ret = strVal;
        }

        return ret;
    }

    /**
     * <pre>
     * 1000を掛けた値を返す。
     * 例外発生時はnullを返す。
     * </pre>
     *
     * @param value BigDecimal 値
     * @return outPercent BigDecimal 1000を掛けた値
     */
    private BigDecimal cnvMultiply1000(BigDecimal bdValue) {
        // 戻り値初期値設定
        BigDecimal ret = null;
        BigDecimal outMultiply = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;

        try {
            // 引数がnullの場合
            if (null == bdValue) {
                // nullを返す。
                return ret;
            } else {
                // 引数がnull以外の場合
                outMultiply = bdValue;
            }

            // 引数に1000を掛ける
            outMultiply = outMultiply.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE);
            if (null == outMultiply) {
                outMultiply = PNCommonConstants.BIGDECIMAL_ZERO_VALUE;
            }

        } catch (IllegalArgumentException ie) {
            // 例外発生時はnullを戻す。
            outMultiply = null;

        } catch (ArithmeticException ae) {
            // 例外発生時はnullを戻す。
            outMultiply = null;
        }
        // 戻り値返却
        ret = outMultiply;

        return ret;
    }
}