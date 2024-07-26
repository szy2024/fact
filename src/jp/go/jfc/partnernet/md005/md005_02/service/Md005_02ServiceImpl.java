//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_02.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AringiDAO;
import jp.go.jfc.partnernet.common.dao.AringiEntity;
import jp.go.jfc.partnernet.common.dao.DaibensaireportDAO;
import jp.go.jfc.partnernet.common.dao.DaibensaireportEntity;
import jp.go.jfc.partnernet.common.dao.ReporthistoryDAO;
import jp.go.jfc.partnernet.common.dao.ReporthistoryEntity;
import jp.go.jfc.partnernet.common.dao.SeikyuDAO;
import jp.go.jfc.partnernet.common.dao.SeikyuEntity;
import jp.go.jfc.partnernet.md000.common.Md000Constants;
import jp.go.jfc.partnernet.md005.common.Md005Constants;
import jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataDAO;
import jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはmd005_02のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md005_02ServiceImpl extends PNBaseService implements Md005_02Service {

    /** md005_02resultsdatadao */
    @Autowired
    private Md005_02ResultsDataDAO md005_02resultsdatadao;

    /** reporthistorydao */
    @Autowired
    private ReporthistoryDAO reporthistorydao;

    /** aringidao */
    @Autowired
    private AringiDAO aringidao;

    /** seikyudao */
    @Autowired
    private SeikyuDAO seikyudao;

    /** daibensaireportdao */
    @Autowired
    private DaibensaireportDAO daibensaireportdao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    DecimalFormat formatter = new DecimalFormat("#,###");

    /**
     * Md005_02ServiceのgetResultsData
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO getResultsData(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 受渡パラメータを取得する。
        Md005_02ResultsDataEntity inEntity = new Md005_02ResultsDataEntity();
        CFWBeanUtils.copyProperties(inEntity, inDto);

        // ログインユーザ情報
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();

        // 一覧画面データの取得
        // 　　１．複数テーブルアクセス定義の「Md005_01ResultsDataDAO」を参照し、条件を設定する。
        // 　　　　Md005_02ResultsDataDAO.findByCondition
        // Md005_02ResultsDataEntity inEntity = new Md005_02ResultsDataEntity();
        // List<Md005_02ResultsDataEntity> outEntityList =
        // md005_02resultsdatadao.findByCondition(inEntity);
        // 扱店　＝　ログインユーザの扱店コード
        inEntity.setID_Code_Organization(pnCommonInfo.getCode_Organization());
        // 報告書番号　＝　指定された報告書番号　ID_Report
        inEntity.setID_ID_Report(inDto.getID_ID_Report());
        List<Md005_02ResultsDataEntity> outEntityList = md005_02resultsdatadao.findByCondition(inEntity);

        long count = md005_02resultsdatadao.countByCondition(inEntity);
        if (0 == count) {
            // 　　２．取得した情報＝０件の場合、業務エラーとする。
            // 　　　　エラーメッセージ：PM9060E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0]));
        } else if (1 < count) {
            // 　　３．取得した情報＞１件の場合、業務エラーとする。
            // 　　　　エラーメッセージ：PM9010E
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9010E, new String[0]));
        }
        // エラー判定
        if (0 < bizErrors.size()) {
            // エラーがある場合はエラー情報をコントローラーに返す
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        // 業務日付取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);

        // Entity⇒DTOに転記
        CFWBeanUtils.copyProperties(inEntity, outEntityList.get(0));
        // 　　・Md005_02ResultsDataEntity.報告書番号⇒Md005_02DTO.ID_ID_Report
        outDto.setID_ID_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
        // 　　・Md005_02ResultsDataEntity.報告年月日⇒Md005_02DTO.ID_Date_Report（※業務日付に変更）
        outDto.setLblID_Date_Report(nowDate);
        // 　　・Md005_02ResultsDataEntity.扱店名⇒Md005_02DTO.ID_Name_Organization
        outDto.setTxtID_Name_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        outDto.setTxtID_Name_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        outDto.setLblID_Name_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        outDto.setLblID_Name_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        // 　　・Md005_02ResultsDataEntity.顧客名⇒Md005_02DTO.ID_Name_Customer
        outDto.setTxtID_Name_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        outDto.setTxtID_Name_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        outDto.setLblID_Name_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        outDto.setLblID_Name_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        // 　　・Md005_02ResultsDataEntity.公庫支店⇒Md005_02DTO.ID_Code_KoukoShiten
        outDto.setTxtID_Code_KoukoShiten(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        outDto.setTxtID_Code_KoukoShiten_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        outDto.setLblID_Code_KoukoShiten(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        outDto.setLblID_Code_KoukoShiten_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        // 　　・Md005_02ResultsDataEntity.扱店⇒Md005_02DTO.ID_Code_Organization
        outDto.setTxtID_Code_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        outDto.setTxtID_Code_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        outDto.setLblID_Code_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        outDto.setLblID_Code_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        // 　　・Md005_02ResultsDataEntity.店舗⇒Md005_02DTO.ID_Code_Tenpo
        outDto.setTxtID_Code_Tenpo(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Code_Tenpo()));
        outDto.setTxtID_Code_Tenpo_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Tenpo()));
        outDto.setLblID_Code_Tenpo(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Code_Tenpo()));
        outDto.setLblID_Code_Tenpo_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Tenpo()));
        // 　　・Md005_02ResultsDataEntity.年度⇒Md005_02DTO.ID_Year
        outDto.setTxtID_Year(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        outDto.setTxtID_Year_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        outDto.setLblID_Year(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        outDto.setLblID_Year_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        // 　　・Md005_02ResultsDataEntity.方式資金⇒Md005_02DTO.ID_Code_HoshikiShikin
        outDto.setTxtID_Code_HoshikiShikin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        outDto.setTxtID_Code_HoshikiShikin_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        outDto.setLblID_Kubun_HoshikiShikin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        outDto.setLblID_Kubun_HoshikiShikin_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        // 　　・Md005_02ResultsDataEntity.番号⇒Md005_02DTO.ID_ID_Ringi
        outDto.setTxtID_ID_Ringi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        outDto.setTxtID_ID_Ringi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        outDto.setLblID_ID_Ringi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        outDto.setLblID_ID_Ringi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        // 　　・Md005_02ResultsDataEntity.枝番⇒Md005_02DTO.ID_ID_RingiBranch
        String ringiBranch = "";
        if (false == Md005Constants.STR_ZERO.equals(outEntityList.get(0).getID_ID_RingiBranch())) {
            ringiBranch = outEntityList.get(0).getID_ID_RingiBranch();
        }
        outDto.setTxtID_ID_RingiBranch(ringiBranch);
        outDto.setTxtID_ID_RingiBranch_Red(ringiBranch);
        outDto.setLblID_ID_RingiBranch(ringiBranch);
        outDto.setLblID_ID_RingiBranch_Red(ringiBranch);
        // 　　・Md005_02ResultsDataEntity.充当対象払込期日⇒Md005_02DTO.ID_Date_JutoTaisho
        outDto.setLblID_Date_JutoTaisho(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho()));
        outDto.setLblID_Date_JutoTaisho_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho()));
        outDto.setTxtID_Date_JutoTaisho_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho()));
        outDto.setID_Date_JutoTaisho(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho()));
        outDto.setID_Date_JutoTaishoYear(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho().substring(0, 4)));
// [UPD] Ver 2.0.0 - START
//        outDto.setDrpID_Date_JutoTaishoGengou(Md005Constants.NENGOU_HEISEI);
//        // 充当対象払込期日(元号)
//        outDto.setID_Date_JutoTaishoGengou(Md005Constants.NENGOU_HEISEI);
        outDto.setDrpID_Date_JutoTaishoGengou(PNCommonComponents.getInitgengo());
        // 充当対象払込期日(元号)
        outDto.setID_Date_JutoTaishoGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
        String dateJutoTaisho = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JutoTaisho());
        if (Md005Constants.LENGTH_8 == dateJutoTaisho.length()) {
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String waDateJutoTaisho = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMMDD(dateJutoTaisho));
            if (0 < waDateJutoTaisho.length()) {
                String[] tmp = waDateJutoTaisho.split("\\.");
                if (0 < tmp.length) {
                    // 　　・Entity.充当対象払込期日⇒DTO.充当対象払込期日(元号)(修正)
                    // 　　和暦年に変換し、元号記号を設定（データ無し時は初期元号)
                    outDto.setDrpID_Date_JutoTaishoGengou(tmp[0].substring(0, 1));
                    // 　　・Entity.充当対象払込期日⇒DTO.充当対象払込期日(年) (修正)　　　和暦に変換し年を設定
                    outDto.setTxtID_Date_JutoTaishoYear(tmp[0].substring(1));
                    // 　　・Entity.充当対象払込期日⇒DTO.充当対象払込期日(月) (修正)　　　月を抽出して設定
                    outDto.setDrpID_Date_JutoTaishoMonth(tmp[1]);
                    // 　　・Entity.充当対象払込期日⇒DTO.充当対象払込期日(日) (修正)　　　日を抽出して設定
                    outDto.setDrpID_Date_JutoTaishoDay(tmp[2]);
                    // 充当対象払込期日(元号)
                    outDto.setID_Date_JutoTaishoGengou(tmp[0].substring(0, 1));
                    // 充当対象払込期日入力
                    outDto.setID_Date_JutoTaishoYear_Input(tmp[0].substring(1));
                    // 充当対象払込期日(月)
                    outDto.setID_Date_JutoTaishoMonth(tmp[1]);
                    // 充当対象払込期日(日)
                    outDto.setID_Date_JutoTaishoDay(tmp[2]);
                }
            }
        }
        // 　　・Md005_02ResultsDataEntity.代弁金払込日⇒Md005_02DTO.ID_Date_DaibenkinHaraikomi
        outDto.setID_Date_DaibenkinHaraikomi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_DaibenkinHaraikomi()));
        outDto.setLblID_Date_DaibenkinHaraikomi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_DaibenkinHaraikomi()));
        outDto.setLblID_Date_DaibenkinHaraikomi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_DaibenkinHaraikomi()));
        outDto.setID_Date_DaibenkinHaraikomiYear(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_DaibenkinHaraikomi().substring(0, 4)));
// [UPD] Ver 2.0.0 - START
//        outDto.setDrpID_Date_DaibenkinHaraikomiGengou(Md005Constants.NENGOU_HEISEI);
//        // 代弁金払込日(元号)
//        outDto.setID_Date_DaibenkinHaraikomiGengou(Md005Constants.NENGOU_HEISEI);
        outDto.setDrpID_Date_DaibenkinHaraikomiGengou(PNCommonComponents.getInitgengo());
        // 代弁金払込日(元号)
        outDto.setID_Date_DaibenkinHaraikomiGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
        String dateDaibenkinHaraikomi = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_DaibenkinHaraikomi());
        if (Md005Constants.LENGTH_8 == dateDaibenkinHaraikomi.length()) {
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String waDateDaibenkinHaraikomi = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMMDD(dateDaibenkinHaraikomi));
            if (0 < waDateDaibenkinHaraikomi.length()) {
                String[] tmp = waDateDaibenkinHaraikomi.split("\\.");
                if (0 < tmp.length) {
                    // 　　・Entity.代弁金払込日⇒DTO.代弁金払込日(元号)(修正)
                    // 　　和暦年に変換し、元号記号を設定（データ無し時は初期元号)
                    outDto.setDrpID_Date_DaibenkinHaraikomiGengou(tmp[0].substring(0, 1));
                    // 　　・Entity.代弁金払込日⇒DTO.代弁金払込日(年) (修正)　　　和暦に変換し年を設定
                    outDto.setTxtID_Date_DaibenkinHaraikomiYear(tmp[0].substring(1));
                    // 　　・Entity.代弁金払込日⇒DTO.代弁金払込日(月) (修正)　　　月を抽出して設定
                    outDto.setDrpID_Date_DaibenkinHaraikomiMonth(tmp[1]);
                    // 　　・Entity.代弁金払込日⇒DTO.代弁金払込日(日) (修正)　　　日を抽出して設定
                    outDto.setDrpID_Date_DaibenkinHaraikomiDay(tmp[2]);
                    // 代弁金払込日(元号)
                    outDto.setID_Date_DaibenkinHaraikomiGengou(tmp[0].substring(0, 1));
                    // 代位金払込日入力
                    outDto.setID_Date_DaibenkinHaraikomiYear_Input(tmp[0].substring(1));
                    // 代弁金払込日(月)
                    outDto.setID_Date_DaibenkinHaraikomiMonth(tmp[1]);
                    // 代弁金払込日(日)
                    outDto.setID_Date_DaibenkinHaraikomiDay(tmp[2]);
                }
            }
        }
        // 　　・Md005_02ResultsDataEntity.遅延損害金⇒Md005_02DTO.ID_M_ChienSongai
        outDto.setTxtID_M_ChienSongai(cnvNulltoZero(outEntityList.get(0).getID_M_ChienSongai(), false));
        outDto.setTxtID_M_ChienSongai_Red(cnvNulltoZero(outEntityList.get(0).getID_M_ChienSongai(), false));
        outDto.setLblID_M_ChienSongai(cnvNulltoZero(outEntityList.get(0).getID_M_ChienSongai(), true));
        outDto.setLblID_M_ChienSongai_Red(cnvNulltoZero(outEntityList.get(0).getID_M_ChienSongai(), true));
        // 　　・Md005_02ResultsDataEntity.利息(約定利息)⇒Md005_02DTO.ID_M_Risoku
        outDto.setTxtID_M_Risoku(cnvNulltoZero(outEntityList.get(0).getID_M_Risoku(), false));
        outDto.setTxtID_M_Risoku_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Risoku(), false));
        outDto.setLblID_M_Risoku(cnvNulltoZero(outEntityList.get(0).getID_M_Risoku(), true));
        outDto.setLblID_M_Risoku_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Risoku(), true));
        // 　　・Md005_02ResultsDataEntity.元金(約定元金)⇒Md005_02DTO.ID_M_Gankin
        outDto.setTxtID_M_Gankin(cnvNulltoZero(outEntityList.get(0).getID_M_Gankin(), false));
        outDto.setTxtID_M_Gankin_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Gankin(), false));
        outDto.setLblID_M_Gankin(cnvNulltoZero(outEntityList.get(0).getID_M_Gankin(), true));
        outDto.setLblID_M_Gankin_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Gankin(), true));
        // 　　・Md005_02ResultsDataEntity.計⇒Md005_02DTO.ID_M_Kei
        outDto.setTxtID_M_Kei(cnvNulltoZero(outEntityList.get(0).getID_M_Kei(), false));
        outDto.setTxtID_M_Kei_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Kei(), false));
        outDto.setLblID_M_Kei(cnvNulltoZero(outEntityList.get(0).getID_M_Kei(), true));
        outDto.setLblID_M_Kei_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Kei(), true));
        // 　　・Md005_02ResultsDataEntity.仮受金(一般口)からの充当額⇒Md005_02DTO.ID_M_KariukeIppanJuto
        String KariukeIppanJuto = "";
        if (!"0".equals(cnvNulltoZero(outEntityList.get(0).getID_M_KariukeIppanJuto(), false))) {
            KariukeIppanJuto = cnvNulltoZero(outEntityList.get(0).getID_M_KariukeIppanJuto(), false);
        }
        outDto.setTxtID_M_KariukeIppanJuto(KariukeIppanJuto);
        outDto.setTxtID_M_KariukeIppanJuto_Red(KariukeIppanJuto);
        outDto.setLblID_M_KariukeIppanJuto(KariukeIppanJuto);
        outDto.setLblID_M_KariukeIppanJuto_Red(KariukeIppanJuto);
        // 　　・Md005_02ResultsDataEntity.代弁金充当後残元金⇒Md005_02DTO.ID_M_ZanGanAfterDaibenJuto
        outDto.setTxtID_M_ZanGanAfterDaibenJuto(cnvNulltoZero(outEntityList.get(0)
                .getID_M_ZanGanAfterDaibenJuto(), false));
        outDto.setTxtID_M_ZanGanAfterDaibenJuto_Red(cnvNulltoZero(outEntityList.get(0)
                .getID_M_ZanGanAfterDaibenJuto(), false));
        outDto.setLblID_M_ZanGanAfterDaibenJuto(cnvNulltoZero(outEntityList.get(0)
                .getID_M_ZanGanAfterDaibenJuto(), true));
        outDto.setLblID_M_ZanGanAfterDaibenJuto_Red(cnvNulltoZero(outEntityList.get(0)
                .getID_M_ZanGanAfterDaibenJuto(), true));
        // 　　・Md005_02ResultsDataEntity.繰上償還手数料⇒Md005_02DTO.ID_M_KurishoCommission
        outDto.setTxtID_M_KurishoCommission(cnvNulltoZero(outEntityList.get(0).getID_M_KurishoCommission(),
                false));
        outDto.setTxtID_M_KurishoCommission_Red(cnvNulltoZero(outEntityList.get(0)
                .getID_M_KurishoCommission(), false));
        outDto.setLblID_M_KurishoCommission(cnvNulltoZero(outEntityList.get(0).getID_M_KurishoCommission(),
                true));
        outDto.setLblID_M_KurishoCommission_Red(cnvNulltoZero(outEntityList.get(0)
                .getID_M_KurishoCommission(), true));
        // 　　・Md005_02ResultsDataEntity.送金額⇒Md005_02DTO.ID_M_Sokin
        outDto.setTxtID_M_Sokin(cnvNulltoZero(outEntityList.get(0).getID_M_Sokin(), false));
        outDto.setTxtID_M_Sokin_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Sokin(), false));
        outDto.setLblID_M_Sokin(cnvNulltoZero(outEntityList.get(0).getID_M_Sokin(), true));
        outDto.setLblID_M_Sokin_Red(cnvNulltoZero(outEntityList.get(0).getID_M_Sokin(), true));
        // 　　・Md005_02ResultsDataEntity.送金日⇒Md005_02DTO.ID_Date_Sokin
        String dateSokin = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Date_Sokin());
        outDto.setLblID_Date_Sokin_Red(dateSokin);
        outDto.setLblID_Date_Sokin(dateSokin);
        outDto.setTxtID_Date_Sokin_Red(dateSokin);
        outDto.setID_Date_Sokin(dateSokin);
// [UPD] Ver 2.0.0 - START
//        outDto.setDrpID_Date_SokinGengou(Md005Constants.NENGOU_HEISEI);
//        // 送信日(年号)
//        outDto.setID_Date_SokinGengou(Md005Constants.NENGOU_HEISEI);
        outDto.setDrpID_Date_SokinGengou(PNCommonComponents.getInitgengo());
        // 送信日(年号)
        outDto.setID_Date_SokinGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
        if (Md005Constants.LENGTH_8 == dateSokin.length()) {
            outDto.setID_Date_SokinYear(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_Sokin().substring(0, 4)));
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String waDateSokin = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMMDD(dateSokin));
            if (0 < waDateSokin.length()) {
                String[] tmp = waDateSokin.split("\\.");
                if (0 < tmp.length) {
                    // 　　・Entity.送金日⇒DTO.送金日(元号)(修正)
                    // 　　和暦年に変換し、元号記号を設定（データ無し時は初期元号)
                    outDto.setDrpID_Date_SokinGengou(tmp[0].substring(0, 1));
                    // 　　・Entity.送金日⇒DTO.送金日(年) (修正)　　　和暦に変換し年を設定
                    outDto.setTxtID_Date_SokinYear(tmp[0].substring(1));
                    // 　　・Entity.送金日⇒DTO.送金日(月) (修正)　　　月を抽出して設定
                    outDto.setDrpID_Date_SokinMonth(tmp[1]);
                    // 　　・Entity.送金日⇒DTO.送金日(日) (修正)　　　日を抽出して設定
                    outDto.setDrpID_Date_SokinDay(tmp[2]);
                    // 送信日(年号)
                    outDto.setID_Date_SokinGengou(tmp[0].substring(0, 1));
                    // 送信日人力
                    outDto.setID_Date_SokinYear_Input(tmp[0].substring(1));
                    // 送信日(月)
                    outDto.setID_Date_SokinMonth(tmp[1]);
                    // 送信日(日)
                    outDto.setID_Date_SokinDay(tmp[2]);
                }
            }
        }
        // 　　・Md005_02ResultsDataEntity.送金日番号⇒Md005_02DTO.ID_ID_Sokinbi
        String ID_Sokinbi = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Sokinbi());
        outDto.setTxtID_ID_Sokinbi(ID_Sokinbi);
        outDto.setTxtID_ID_Sokinbi_Red(ID_Sokinbi);
        outDto.setLblID_ID_Sokinbi(ID_Sokinbi);
        outDto.setLblID_ID_Sokinbi_Red(ID_Sokinbi);
        // 　　・Md005_02ResultsDataEntity.受託者勘定処理年月⇒Md005_02DTO.ID_Date_Jtkshori
        String dateJtkshori = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Date_Jtkshori());
        outDto.setLblID_Date_Jtkshori_Red(dateJtkshori);
        outDto.setLblID_Date_Jtkshori(dateJtkshori);
        outDto.setTxtID_Date_Jtkshori_Red(dateJtkshori);
        outDto.setTxtID_Date_Jtkshori(dateJtkshori);
        outDto.setID_Date_Jtkshori(dateJtkshori);
// [UPD] Ver 2.0.0 - START
//        outDto.setDrpID_Date_JtkshoriGengou(Md005Constants.NENGOU_HEISEI);
        outDto.setDrpID_Date_JtkshoriGengou(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END
        String[] tmpDateJtkshori = null;
        // 受託者勘定処理年月(元号)
// [UPD] Ver 2.0.0 - START
//        outDto.setID_Date_JtkshoriGengou(Md005Constants.NENGOU_HEISEI);
        outDto.setID_Date_JtkshoriGengou(PNCommonComponents.getInitgengo());
        outDto.setDrpID_Date_JtkshoriGengou_Red(PNCommonComponents.getInitgengo());
// [UPD] Ver 2.0.0 - END

        if (Md005Constants.LENGTH_6 == dateJtkshori.length()) {
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String waDateJtkshori = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMM(dateJtkshori));
            if (0 < waDateJtkshori.length()) {
                tmpDateJtkshori = waDateJtkshori.split("\\.");
                if (0 < tmpDateJtkshori.length) {
                    // 　更正(黒)用
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(元号)（修正）
                    // 　　和暦年に変換し、元号記号を設定（データ無し時は初期元号)
                    outDto.setDrpID_Date_JtkshoriGengou(tmpDateJtkshori[0].substring(0, 1));
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(年)（修正）　　　和暦に変換し年を設定
                    outDto.setTxtID_Date_JtkshoriYear(tmpDateJtkshori[0].substring(1));
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(月)（修正）　　　月を抽出して設定
                    outDto.setDrpID_Date_JtkshoriMonth(tmpDateJtkshori[1]);
                    // 　非表示用
                    // 受託者勘定処理年月(元号)
                    outDto.setID_Date_JtkshoriGengou(tmpDateJtkshori[0].substring(0, 1));
                    // 受託者勘定処理年月入力
                    outDto.setID_Date_JtkshoriYear_Input(tmpDateJtkshori[0].substring(1));
                    // 受託者勘定処理年月(年)
                    outDto.setID_Date_JtkshoriYear(tmpDateJtkshori[0].substring(1));
                    // 受託者勘定処理年月(月)
                    outDto.setID_Date_JtkshoriMonth(tmpDateJtkshori[1]);
                    // 　更正(赤)用
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(元号)　　和暦年に変換し、元号記号を設定（データ無し時は"H")
                    outDto.setDrpID_Date_JtkshoriGengou_Red(tmpDateJtkshori[0].substring(0, 1));
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(年)　　　和暦に変換し年を設定
                    outDto.setTxtID_Date_JtkshoriYear_Red(tmpDateJtkshori[0].substring(1));
                    // 　　・Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(月)　　　月を抽出して設定
                    outDto.setDrpID_Date_JtkshoriMonth_Red(tmpDateJtkshori[1]);
                }
            }
        }
        // 　　・Md005_02ResultsDataEntity.貸付金残高（非表示）⇒Md005_02DTO.ID_M_KashitsukeZandaka
        if (null != outEntityList.get(0).getID_M_KashitsukeZandaka()) {
            outDto.setID_M_KashitsukeZandaka(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_M_KashitsukeZandaka().toString()));
        }
        // 　　・Md005_02ResultsDataEntity.報告書番号（非表示）⇒Md005_02DTO.ID_ID_Report
        outDto.setID_ID_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
        // 　　・Md005_02ResultsDataEntity.報告時分秒（非表示）⇒Md005_02DTO.ID_Time_Report
        outDto.setID_Time_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Time_Report()));
        // 　　・Md005_02ResultsDataEntity.ユーザID（非表示）⇒Md005_02DTO.ID_User_ID
        outDto.setID_User_ID(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_User_ID()));
        // 　　・Md005_02ResultsDataEntity.伝送番号（非表示）⇒Md005_02DTO.ID_ID_Denso
        outDto.setID_ID_Denso(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
        // 　　・Md005_02ResultsDataEntity.データコード⇒Md005_02DTO.ID_DataCode
        if (null != outEntityList.get(0).getID_DataCode()) {
            outDto.setID_DataCode(outEntityList.get(0).getID_DataCode());
        }
        // 　　・Md005_02ResultsDataEntity.履歴番号（非表示）⇒Md005_02DTO.ID_ID_History
        outDto.setID_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
        // 　　・Md005_02ResultsDataEntity.ステータス（非表示）⇒Md005_02DTO.ID_Status
        if (null != outEntityList.get(0).getID_Status()) {
            outDto.setID_Status(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Status()));
        }
        // 　　・Md005_02ResultsDataEntity.処理種別⇒Md005_02DTO.ID_Type_Process
        outDto.setID_Type_Process(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_Type_Process()));
        // 　　・Md005_02ResultsDataEntity.取消済みフラグ（非表示）⇒Md005_02DTO.ID_Flag_Torikeshizumi
        outDto.setID_Flag_Torikeshizumi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Flag_Torikeshizumi()));
        // 　　・Md005_02ResultsDataEntity.エラー番号（非表示）⇒Md005_02DTO.ID_Code_Error
        outDto.setID_Code_Error(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
        // 　　・Md005_02ResultsDataEntity.エラーメッセージ（非表示）⇒Md005_02DTO.ID_ErrorMessage
        outDto.setID_ErrorMessage(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_ErrorMessage()));
        // 　　・Md005_02ResultsDataEntity.退避貸付金残高（非表示）⇒Md005_02DTO.ID_Keep_M_KashitsukeZan
        if (null != outEntityList.get(0).getID_Keep_M_KashitsukeZan()) {
            outDto.setID_Keep_M_KashitsukeZan(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_M_KashitsukeZan()));
        }
        // 　　・Md005_02ResultsDataEntity.退避約定元金⇒Md005_02DTO.ID_Keep_M_YakujoGankin
        if (null != outEntityList.get(0).getID_Keep_M_YakujoGankin()) {
            outDto.setID_Keep_M_YakujoGankin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_M_YakujoGankin()));
        }
        // 　　・Md005_02ResultsDataEntity.退避約定利息⇒Md005_02DTO.ID_Keep_M_YakujoRisoku
        if (null != outEntityList.get(0).getID_Keep_M_YakujoRisoku()) {
            outDto.setID_Keep_M_YakujoRisoku(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_M_YakujoRisoku()));
        }
        // 　　・Md005_02ResultsDataEntity.退避償還期限（非表示）⇒Md005_02DTO.ID_Keep_Date_ShokanKigen
        outDto.setID_Keep_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Keep_Date_ShokanKigen()));
        // 　　・Md005_02ResultsDataEntity.債権管理番号（非表示）⇒Md005_02DTO.ID_ID_Credit
        outDto.setID_ID_Credit(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Credit()));
        // 　　・Md005_02ResultsDataEntity.顧客コード（非表示）⇒Md005_02DTO.ID_Code_Customer
        outDto.setID_Code_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Customer()));
        // 　　・Md005_02ResultsDataEntity.退避請求繰償還利息⇒Md005_02DTO.Keep_Seikyu_M_SeiKuriRisoku
        outDto.setID_Keep_Seikyu_M_SeiKuriRisoku(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getKeep_Seikyu_M_SeiKuriRisoku()));
        // 　　・Md005_02ResultsDataEntity.最新データ更新日付（非表示）⇒Md005_02DTO.Data_LastUpDate
        String dateLastUpdate = "";
        if (null != outEntityList.get(0).getData_LastUpDate()
                && !"".equals(outEntityList.get(0).getData_LastUpDate())) {
            dateLastUpdate = new SimpleDateFormat(Md005Constants.STR_DATE_LAST_UPDATE_FORMAT)
                    .format(Timestamp.valueOf(outEntityList.get(0).getData_LastUpDate()));
        }
        outDto.setID_Data_LastUpDate(dateLastUpdate);
        // 　　・Md005_02ResultsDataEntity.退避履歴番号（非表示）⇒Md005_02DTO.ID_Keep_ID_History
        if (null != outEntityList.get(0).getID_Keep_ID_History()) {
            outDto.setID_Keep_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_ID_History().toString()));
        }
        // 　　・Md005_02ResultsDataEntity.退避実行済みフラグ（非表示）⇒Md005_02DTO.ID_Keep_Flag_Kj
        if (null != outEntityList.get(0).getID_Keep_Flag_Kj()) {
            outDto.setID_Keep_Flag_Kj(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Keep_Flag_Kj().toString()));
        }
        // 　　・Md005_02ResultsDataEntity.扱店別稟議データより取得した償還期限年月（非表示）⇒Md005_02DTO.ID_aRingi_Date_ShokanKigen
        outDto.setID_aRingi_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Date_ShokanKigen()));
        // 　　・Md005_02ResultsDataEntity.退避請求繰償還元金⇒Md005_02DTO.Keep_Seikyu_M_SeiKuriGankin
        outDto.setID_Keep_Seikyu_M_SeiKuriGankin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getKeep_Seikyu_M_SeiKuriGankin()));

        return outDto;
    }

    /**
     * Md005_02ServiceのupdateDataNotProcEndDel
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO updateDataNotProcEndDel(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // 現在の日付(業務日付)取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");
        // 現在の日時取得
        Timestamp nowDateTime = PNDateUtils.formatTimestamp(nowDate + nowTime + "000");
        // 画面表示時に取得した報告書番号を保持
        String keepDbIdReport = inDto.getID_ID_Report();

        // 取消：処理完了以外の更新処理。
        // 　＜画面表示時に取得したレコードに対する取消処理＞

        // 　　１．報告書履歴データのレコードを更新　　※画面表示の対象となった履歴データのレコードを更新
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①""⇒更正（赤）データの報告書番号
        String iDReportRed = PNCommonConstants.LITERAL_BLANK;
        // 　　　　　　②"1"⇒更正（赤）データの取消済みフラグ（非表示）
        BigDecimal flagTorikeshizumiRed = BigDecimal.ONE;
        // 　　　　　　③退避貸付金残高（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う払込前残元金
        inDto.setID_M_KashitsukeZandaka_aRingi(inDto.getID_Keep_M_KashitsukeZan());
        // 　　　　　　④退避償還期限（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う償還期限
        inDto.setID_Date_ShokanKigen_aRingi(inDto.getID_Keep_Date_ShokanKigen());
        // 　　　　　　⑤退避約定利息⇒更正（赤）データの請求データに登録を行う約定利息
        inDto.setID_M_YakujoRisoku_Seikyu(inDto.getID_Keep_M_YakujoRisoku());
        // 　　　　　　⑥退避約定元金⇒更正（赤）データの請求データに登録を行う約定元金
        inDto.setID_M_YakujoGankin_Yakujo(inDto.getID_Keep_M_YakujoGankin());
        // 　　　　　　⑦退避請求繰償利息⇒更正（赤）データの請求データに登録を行う請求繰償利息
        inDto.setID_Seikyu_M_SeiKuriRisoku(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        // 　　　　　　⑧退避請求繰償元金⇒更正（赤）データの請求データに登録を行う請求繰償元金
        inDto.setID_Seikyu_M_SeiKuriGankin(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        // 　　　　　　⑨現在の日付⇒更正（赤）データの報告年月日
        inDto.setLblID_Date_Report(nowDate);
        // 　　　　　　⑩現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(nowTime);
        // 　　　　更新を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        // 履歴番号
        inEntity.setID_History(inDto.getID_ID_History());
        // ステータス
        if (true == isAlreadyInput(inDto.getID_Status())) {
            inEntity.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (true == isAlreadyInput(inDto.getID_DataCode())) {
            inEntity.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (true == isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        long hitcount = reporthistorydao.countByCondition(inEntity);

        // 検索結果判定
        if (0 == hitcount) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
            outEntity.setID_Report(iDReportRed);
            // 　　　　　　②更正（赤）データの取消済みフラグ（非表示）⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(flagTorikeshizumiRed);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（８）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　２．扱店別稟議データのレコードを更新　　※画面表示の対象となった債権管理番号を持つレコードの貸付金残高、償還期限年月をデータ取得時の値で更新
        // 　　　　更新を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　最新更新日時
        // 　　　　　　AringiDAO.countByCondition
        AringiEntity inEntity2 = new AringiEntity();
        // 条件を設定
        // 債権管理番号
        inEntity2.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        // 最新更新日時
        if (isAlreadyInput(inDto.getID_Data_LastUpDate())) {
            inEntity2.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        }
        // 件数取得
        long hitcount2 = aringidao.countByCondition(inEntity2);
        // 検索結果判定
        if (0 == hitcount2) {
            // 　　　　（２）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PTN001,DB007
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } else if (1 < hitcount2) {
            // 　　　　（３）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }

        // 　　　　扱店別稟議データを排他読込をする。
        // 　　　　（４）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　AringiDAO.findByPrimaryKeyForUpdate
        // AringiEntity inEntity = new AringiEntity();
        try {
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntity2);

            if (null == outEntity) {
                // 　　　　（５）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（６）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // 　　　　　　①処理完了以外：取消（更正（赤））以外の場合
            // 　　　　　　　　（ａ）扱店別稟議データに登録を行う償還期限⇒aRingiEntity.償還期限年月
            outEntity.setDate_ShokanKigen(inDto.getID_Date_ShokanKigen_aRingi());
            // 　　　　　　　　（ｂ）扱店別稟議データに登録を行う払込前残元金⇒aRingiEntity.貸付金残高
            if (true == isAlreadyInput(inDto.getID_M_KashitsukeZandaka_aRingi())) {
                outEntity.setM_KashitsukeZandaka(new BigDecimal(inDto.getID_M_KashitsukeZandaka_aRingi()));
            }
            // 　　　　　　②現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            outEntity.setData_LastUpDate(nowDateTime);
            // 　　　　扱店別稟議データを更新をする。
            // 　　　　（７）単テーブルアクセス定義「扱店別稟議データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
            // 　　　　　　AringiDAO.updata
            // 債権管理番号
            outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // すでに更新されているかチェック処理を記述
            if (1 < aringidao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　３．請求データのレコードを更新　　
        // 　　　※画面表示の対象となった債権管理番号を持つレコードの約定元金、約定利息をデータ取得時の値で更新
        boolean inputKeepMYakujoRisoku = isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku());
        boolean inputKeepMYakujoGankin = isAlreadyInput(inDto.getID_Keep_M_YakujoGankin());
        boolean inputSeikyuMSeiKuriRisoku = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        boolean inputSeikyuMSeiKuriGankin = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        if (inputKeepMYakujoRisoku && inputKeepMYakujoGankin && inputSeikyuMSeiKuriRisoku
                && inputSeikyuMSeiKuriGankin) {
            // 　　　　（１）更生（赤）データの退避約定利息＜＞NULL AND 更正（赤）データの退避約定元金＜＞NULL AND
            // 　　　　　　　更正（赤）データの退避請求繰償利息＜＞NULL AND　更正（赤）データの退避請求繰償元金＜＞NULL の場合

            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            SeikyuEntity inEntity3 = new SeikyuEntity();
            // 債権管理番号
            inEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 払込年月日
            inEntity3.setDate_Haraikomi(inDto.getID_Date_JutoTaisho());
            // 　　　　　　　　SeikyuDAO.countByCondition
            // 件数取得
            long hitcount3 = seikyudao.countByCondition(inEntity3);

            // 検索結果判定
            if (0 == hitcount3) {
                // 　　　　　　②取得した件数＝０の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            } else if (1 < hitcount3) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　　　請求データを排他読込をする。
            // 　　　　　　④単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
            try {
                SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntity3);
                if (null == outEntity) {
                    // 　　　　　　⑤排他エラーの場合、業務エラーとする。
                    // 　　　　　　　　エラーメッセージ：PTN001,DB007
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // 　　　　　　⑥請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                // 　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                if (isAlreadyInput(inDto.getID_ID_Credit())) {
                    outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                }
                // 　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                    outEntity.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                }
                // 　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                    outEntity.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                }
                // 　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                    outEntity.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                }
                // 　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                    outEntity.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                }
                // 　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                    outEntity.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                }
                // 　　　　　　請求データを更新をする。
                // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                // すでに更新されているかチェック処理を記述
                // 　　　　　　　　SeikyuDAO.updata
                if (1 < seikyudao.update(outEntity)) {
                    // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                    // 　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            } catch (CFWForUpdateException fue) {
                // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            } catch (CFWDuplicateKeyException fue) {
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }
        }

        // 　　４．代位弁済金払込・充当報告書の該当レコードの削除　　※画面表示の対象となったレコードを削除
        DaibensaireportEntity inEntity4 = new DaibensaireportEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①報告書番号⇒更正（赤）データの報告書番号　　　　　（画面表示に取得した際の報告書番号で再設定）
        inEntity4.setID_Report(keepDbIdReport);
        // 　　　　削除を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 報告書番号 DTO項目 ID_Report
        // 　　　　　　DaibensaiReportDAO.countByCondition
        long hitcount4 = daibensaireportdao.countByCondition(inEntity4);

        if (0 == hitcount4) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount4) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　代位弁済金払込・充当報告書データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.findByPrimaryKeyForUpdate
        try {
            DaibensaireportEntity outEntity = daibensaireportdao.findByPrimaryKeyForUpdate(inEntity4);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　代位弁済金払込・充当報告書データを削除する。
            // 　　　　（７）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　削除処理」を参照し、条件を設定する。
            // 　　　　　　DaibensaiReportDAO.delete
            // すでに更新されているかチェック処理を記述
            if (1 < daibensaireportdao.delete(inEntity4)) {
                // 　　　　取得した件数＞１の場合、業務エラーとする。
                // 　　　　　エラーメッセージ：PM9010E
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // 　　取消内容のﾃﾞｰﾀに対するﾚｺｰﾄﾞの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う
        // 　　５．報告書履歴データの追加（取消用）
        ReporthistoryEntity inEntity5 = new ReporthistoryEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　（２）履歴番号の再取得および登録値として再設定する。
        // 　　　　　　　更正（赤）データの履歴番号⇒退避用履歴番号
        String strID_History = inDto.getID_ID_History();
        // 　　　　（３）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 履歴番号
        inEntity5.setID_History(strID_History);
        // ステータス
        if (isAlreadyInput(inDto.getID_Status())) {
            inEntity5.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (isAlreadyInput(inDto.getID_DataCode())) {
            inEntity5.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity5.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        long hitcount5 = reporthistorydao.countByCondition(inEntity5);
        if (0 < hitcount5) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History = pnCommonDBComponents.getIdHistoryRh();
        }
        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity5 = new ReporthistoryEntity();
        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity5.setID_History(strID_History);
        }

        // 　　　　　　　　・NULL⇒ReporthistoryEntity.報告書番号
        outEntity5.setID_Report(null);

        // 　　　　　　　　・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity5.setDate_Report(inDto.getLblID_Date_Report());
        }

        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity5.setTime_Report(nowTime);

        // 　　　　　　　　・１⇒ReporthistoryEntity.ステータス
        outEntity5.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_2));

        // 　　　　　　　　・９０２５７０７１⇒ReporthistoryEntity.データコード
        outEntity5.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　　　・１０⇒ReporthistoryEntity.処理種別
        outEntity5.setType_Process(PNCommonConstants.TYPE_PROCESS_10);

        // 　　　　　　　　・１⇒ReporthistoryEntity.取消済フラグ
        outEntity5.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1));

        // 　　　　　　　　・更正（赤）データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity5.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity5.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity5.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　　　　　・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity5.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　　　・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity5.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity5.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　　　・更正（赤）データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity5.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　　　・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity5.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　　　・更正（赤）データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity5.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　　　・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        outEntity5.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　　　・更正（赤）データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity5.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・更正（赤）データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity5.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity5.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }
        // 　　　　　　　　・更正（赤）データの退避償還期限（非表示）⇒ReporthistoryEntity.退避償還期限年月
        if (isAlreadyInput(inDto.getID_Keep_Date_ShokanKigen())) {
            outEntity5.setKeep_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
        }
        // 　　　　　　　　・更正（赤）データの退避貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_Keep_M_KashitsukeZan())) {
            outEntity5.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_Keep_M_KashitsukeZan()));
        }
        // 　　　　　　　　・更正（赤）データの退避約定元金⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoGankin())) {
            outEntity5.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_Keep_M_YakujoGankin()));
        }
        // 　　　　　　　　・更正（赤）データの退避約定利息⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
            outEntity5.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_Keep_M_YakujoRisoku()));
        }
        // 　　　　　　　　・更正（赤）データの退避請求繰償利息⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku())) {
            outEntity5.setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriRisoku()));
        }
        // 　　　　　　　　・更正（赤）データの退避履歴番号⇒ReporthistoryEntity.退避履歴番号Keep_ID_History
        if (isAlreadyInput(inDto.getID_Keep_ID_History())) {
            outEntity5.setKeep_ID_History(inDto.getID_Keep_ID_History());
        }
        // 　　　　　　　　・更正（赤）データの退避実行済みフラグ⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        if (isAlreadyInput(inDto.getID_Keep_Flag_Kj())) {
            outEntity5.setKeep_Flag_Kj(new BigDecimal(inDto.getID_Keep_Flag_Kj()));
        }
        // 　　　　　　　　・更正（赤）データの退避請求繰償元金⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin())) {
            outEntity5.setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriGankin()));
        }

        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity5)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        return outDto;
    }

    /**
     * Md005_02ServiceのupdateDataProcEndDel
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO updateDataProcEndDel(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // 現在の日付(業務日付)取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");
        // 日付書式パターン
        Timestamp nowDateTime = PNDateUtils.formatTimestamp(nowDate + nowTime + "000");

        // 取消：処理完了の更新処理。
        // 　＜画面表示時に取得したレコードに対する取消処理＞

        // 　　１．報告書履歴データのレコードを更新　　※更正（赤）画面表示の対象となった履歴データのレコードを更新
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①"1"⇒更正（赤）データの取消済みフラグ（非表示）
        BigDecimal flagTorikeshizumiRed = BigDecimal.ONE;
        // 　　　　　　②退避貸付金残高（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う払込前残元金
        inDto.setID_M_KashitsukeZandaka_aRingi(inDto.getID_Keep_M_KashitsukeZan());
        // 　　　　　　③退避償還期限（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う償還期限
        inDto.setID_Date_ShokanKigen_aRingi(inDto.getID_Keep_Date_ShokanKigen());
        // 　　　　　　④退避約定利息⇒更正（赤）データの請求データに登録を行う約定利息
        inDto.setID_M_YakujoRisoku_Seikyu(inDto.getID_Keep_M_YakujoRisoku());
        // 　　　　　　⑤退避約定元金⇒更正（赤）データの請求データに登録を行う約定元金
        inDto.setID_M_YakujoGankin_Yakujo(inDto.getID_Keep_M_YakujoGankin());
        // 　　　　　　⑥退避請求繰償利息⇒更正（赤）データの請求データに登録を行う請求繰償利息
        inDto.setID_Seikyu_M_SeiKuriRisoku(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        // 　　　　　　⑦退避請求繰償元金⇒更正（赤）データの請求データに登録を行う請求繰償元金
        inDto.setID_Seikyu_M_SeiKuriGankin(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        // 　　　　　　⑧現在の日付⇒更正（赤）データの報告年月日
        inDto.setLblID_Date_Report(nowDate);
        // 　　　　　　⑨現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(nowTime);
        // 　　　　更新を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        // 履歴番号
        inEntity.setID_History(inDto.getID_ID_History());
        // ステータス
        if (true == isAlreadyInput(inDto.getID_Status())) {
            inEntity.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (true == isAlreadyInput(inDto.getID_DataCode())) {
            inEntity.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (true == isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        long hitcount = reporthistorydao.countByCondition(inEntity);

        // 検索結果判定
        if (0 == hitcount) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
            outEntity.setID_Report(inDto.getID_ID_Report());
            // 　　　　　　②更正（赤）データの取消済みフラグ（非表示）⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(flagTorikeshizumiRed);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（８）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　２．扱店別稟議データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの貸付金残高、償還期限年月をデータ取得時の値で更新
        // 　　　　更新を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　最新更新日時
        // 　　　　　　AringiDAO.countByCondition
        AringiEntity inEntity2 = new AringiEntity();
        // 条件を設定
        // 債権管理番号
        inEntity2.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        // 最新更新日時
        if (isAlreadyInput(inDto.getID_Data_LastUpDate())) {
            inEntity2.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        }
        // 件数取得
        long hitcount2 = aringidao.countByCondition(inEntity2);
        // 検索結果判定
        if (0 == hitcount2) {
            // 　　　　（２）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PTN001,DB007
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } else if (1 < hitcount2) {
            // 　　　　（３）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　扱店別稟議データを排他読込をする。
        // 　　　　（４）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　AringiDAO.findByPrimaryKeyForUpdate
        // AringiEntity inEntity = new AringiEntity();
        try {
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntity2);

            if (null == outEntity) {
                // 　　　　（５）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（６）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            if (false == Md000Constants.PROCESS_MODE_5.equals(inDto.getProcessMode())) {
                // 　　　　　　①処理完了以外：取消（更正（赤））以外の場合
                // 　　　　　　　　（ａ）扱店別稟議データに登録を行う償還期限⇒aRingiEntity.償還期限年月
                outEntity.setDate_ShokanKigen(inDto.getID_Date_ShokanKigen_aRingi());
                // 　　　　　　　　（ｂ）扱店別稟議データに登録を行う払込前残元金⇒aRingiEntity.貸付金残高
                if (true == isAlreadyInput(inDto.getID_M_KashitsukeZandaka_aRingi())) {
                    outEntity
                            .setM_KashitsukeZandaka(new BigDecimal(inDto.getID_M_KashitsukeZandaka_aRingi()));
                }
            }
            // 　　　　　　②現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            outEntity.setData_LastUpDate(nowDateTime);
            // 　　　　扱店別稟議データを更新をする。
            // 　　　　（７）単テーブルアクセス定義「扱店別稟議データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
            // 　　　　　　AringiDAO.updata
            // 債権管理番号
            outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // すでに更新されているかチェック処理を記述
            if (1 < aringidao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　３．請求データのレコードを更新　　
        // 　　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        boolean inputKeepMYakujoRisoku = isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku());
        boolean inputKeepMYakujoGankin = isAlreadyInput(inDto.getID_Keep_M_YakujoGankin());
        boolean inputSeikyuMSeiKuriRisoku = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        boolean inputSeikyuMSeiKuriGankin = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        if (inputKeepMYakujoRisoku && inputKeepMYakujoGankin && inputSeikyuMSeiKuriRisoku
                && inputSeikyuMSeiKuriGankin) {
            // 　　　　（１）更生（赤）データの退避約定利息＜＞NULL AND 更正（赤）データの退避約定元金＜＞NULL AND
            // 　　　　　　　更正（赤）データの退避請求繰償利息＜＞NULL AND　更正（赤）データの退避請求繰償元金＜＞NULL の場合

            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity3 = new SeikyuEntity();
            SeikyuEntity outEntity3 = null;
            // 債権管理番号
            inEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 払込年月日
            inEntity3.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
            // 　　　　　　　　SeikyuDAO.countByCondition
            // 件数取得
            long hitcount3 = seikyudao.countByCondition(inEntity3);

            // 検索結果判定
            if (0 == hitcount3) {
                // 　　　　　　②取得した件数＝０の場合
                // 　　　　　　　　(ｱ)請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                try {
                    outEntity3 = new SeikyuEntity();
                    // 　　　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity3.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                        outEntity3.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                    }
                    // 　　　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                        outEntity3.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                    }
                    // 　　　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                        outEntity3.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                    }
                    // 　　　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                        outEntity3.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                    }
                    if (1 < seikyudao.insert(outEntity3)) {
                        // 　　　　　取得した件数＞１の場合、業務エラーとする。
                        // 　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
            if (1 < hitcount3) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            if (1 == hitcount3) {
                // 　　　　　　④取得した件数＝１の場合
                // 　　　　　　請求データを排他読込をする。
                // 　　　　　　(ｱ)単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
                try {
                    outEntity3 = seikyudao.findByPrimaryKeyForUpdate(inEntity3);
                    if (null == outEntity3) {
                        // 　　　　　　　　(ｲ)排他エラーの場合、業務エラーとする。
                        // 　　　　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // 　　　　　　　　(ｳ)請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    // 　　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity3.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                        outEntity3.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                    }
                    // 　　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                        outEntity3.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                    }
                    // 　　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                        outEntity3.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                    }
                    // 　　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                        outEntity3.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                    }
                    // 　　　　　　請求データを更新をする。
                    // 　　　　　　　　(ｴ)単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    // すでに更新されているかチェック処理を記述
                    // 　　　　　　　　SeikyuDAO.updata
                    if (1 < seikyudao.update(outEntity3)) {
                        // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                        // 　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWFindParameterException fpe) {
                    // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                } catch (CFWForUpdateException fue) {
                    // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
        }

        // 　　取消内容のデータに対するレコードの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う
        // 　　４．報告書履歴データの追加（取消用）
        ReporthistoryEntity inEntity4 = new ReporthistoryEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　（２）履歴番号の再取得および登録値として再設定する。
        // 　　　　　　　更正（赤）データの履歴番号⇒退避用履歴番号
        String strID_History = inDto.getID_ID_History();
        // 　　　　　　　更正（赤）データの報告書番号⇒退避用報告書番号
        String strID_Report = inDto.getID_ID_Report();
        // 　　　　（３）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 履歴番号
        inEntity4.setID_History(strID_History);
        // ステータス
        if (isAlreadyInput(inDto.getID_Status())) {
            inEntity4.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (isAlreadyInput(inDto.getID_DataCode())) {
            inEntity4.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity4.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        long hitcount4 = reporthistorydao.countByCondition(inEntity4);
        if (0 < hitcount4) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History = pnCommonDBComponents.getIdHistoryRh();
            // 　　　　　　　　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用報告書番号に設定する。
            strID_Report = pnCommonDBComponents.getIdReportRh();
        }

        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity4 = new ReporthistoryEntity();
        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity4.setID_History(strID_History);
        }
        // 　　　　　　　　・退避用報告書番号⇒ReporthistoryEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity4.setID_Report(strID_Report);
        }
        // 　　　　　　　　・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity4.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity4.setTime_Report(nowTime);

        // 　　　　　　　　・１⇒ReporthistoryEntity.ステータス
        outEntity4.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_1));

        // 　　　　　　　　・９０２５７０７１⇒ReporthistoryEntity.データコード
        outEntity4.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　　　・１０⇒ReporthistoryEntity.処理種別
        outEntity4.setType_Process(PNCommonConstants.TYPE_PROCESS_10);

        // 　　　　　　　　・０⇒ReporthistoryEntity.取消済フラグ
        outEntity4.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // 　　　　　　　　・更正（赤）データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity4.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity4.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity4.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　　　　　・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity4.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　　　・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity4.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity4.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　　　・更正（赤）データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity4.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　　　・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity4.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　　　・更正（赤）データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity4.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　　　・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        outEntity4.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　　　・更正（赤）データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity4.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・更正（赤）データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity4.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity4.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }
        // 　　　　　　　　・扱店別稟議データより取得した償還期限年月⇒ReporthistoryEntity.退避償還期限年月
        if (isAlreadyInput(inDto.getID_aRingi_Date_ShokanKigen())) {
            outEntity4.setKeep_Date_ShokanKigen(inDto.getID_aRingi_Date_ShokanKigen());
        }
        // 　　　　　　　　・M_貸付残高（稟議データの貸付金残高（非表示）)⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_M_KashitsukeZandaka())) {
            outEntity4.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_M_KashitsukeZandaka()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「約定元金」⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_M_YakujoGankin_Seikyu_Red())) {
            outEntity4.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「約定利息」⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu_Red())) {
            outEntity4.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「請求繰償利息」⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_M_SeiKuriRisoku_Seikyu_Red())) {
            outEntity4
                    .setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto.getID_M_SeiKuriRisoku_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの履歴番号⇒ReporthistoryEntity.退避履歴番号
        if (isAlreadyInput(inDto.getID_ID_History())) {
            outEntity4.setKeep_ID_History(inDto.getID_ID_History());
        }
        // 　　　　　　　　・更正（赤）データの退避実行済みフラグ⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        if (isAlreadyInput(inDto.getID_Keep_Flag_Kj())) {
            outEntity4.setKeep_Flag_Kj(new BigDecimal(inDto.getID_Keep_Flag_Kj()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「請求繰償元金」⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_M_SeiKuriGankin_Seikyu_Red())) {
            outEntity4
                    .setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto.getID_M_SeiKuriGankin_Seikyu_Red()));
        }
        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity4)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　５．代位弁済金払込・充当報告書の追加（更正（赤））
        // 　　　　追加を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        DaibensaireportEntity inEntity5 = new DaibensaireportEntity();
        // 報告書番号 DTO項目 ID_Report
        inEntity5.setID_Report(strID_Report);
        long hitcount5 = daibensaireportdao.countByCondition(inEntity5);
        if (0 < hitcount5) {
            // 　　　　（２）取得した件数＞＝１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　（３）代位弁済金払込・充当報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        DaibensaireportEntity outEntity5 = new DaibensaireportEntity();
        // 　　　　　　・退避用報告書番号⇒DaibensaiReportEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity5.setID_Report(strID_Report);
        }
        // 　　　　　　・更正（赤）データの報告年月日⇒DaibensaiReportEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity5.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　・更正（赤）データの報告時分秒⇒DaibensaiReportEntity.報告時分秒
        if (isAlreadyInput(inDto.getID_Time_Report())) {
            outEntity5.setTime_Report(inDto.getID_Time_Report());
        }
        // 　　　　　　・更正（赤）データのユーザID（非表示）⇒DaibensaiReportEntity.ユーザID
        outEntity5.setUserID(pnCommonInfo.getLogonID());

        // 　　　　　　・更正（赤）データの伝送番号（非表示）⇒DaibensaiReportEntity.伝送番号
        if (isAlreadyInput(inDto.getID_ID_Denso())) {
            outEntity5.setID_Denso(inDto.getID_ID_Denso());
        }

        // 　　　　　　・９０２５７０７１⇒ReporthistoryEntity.データコード
        outEntity5.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　・更正（赤）データの公庫支店⇒DaibensaiReportEntity.公庫支店コード
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity5.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　・更正（赤）データの扱店⇒DaibensaiReportEntity.扱店コード
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity5.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　・更正（赤）データの店舗⇒DaibensaiReportEntity.店舗コード
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity5.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　・更正（赤）データの受託者勘定処理年月⇒DaibensaiReportEntity.受託者勘定処理年月
        if (isAlreadyInput(inDto.getLblID_Date_Jtkshori_Red())) {
            outEntity5.setDate_Jtkshori(inDto.getLblID_Date_Jtkshori_Red());
        }
        // 　　　　　　・更正（赤）データの送金日⇒DaibensaiReportEntity.送金日
        if (isAlreadyInput(inDto.getLblID_Date_Sokin_Red())) {
            outEntity5.setDate_Sokin(inDto.getLblID_Date_Sokin_Red());
        }
        // 　　　　　　・更正（赤）データの送金日番号⇒DaibensaiReportEntity.送金日番号
        if (isAlreadyInput(inDto.getLblID_ID_Sokinbi_Red())) {
            outEntity5.setID_Sokinbi(inDto.getLblID_ID_Sokinbi_Red());
        }
        // 　　　　　　・更正（赤）データの年度⇒DaibensaiReportEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity5.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　・更正（赤）データの方式資金⇒DaibensaiReportEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity5.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　・更正（赤）データの番号⇒DaibensaiReportEntity.稟議番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity5.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　・更正（赤）データの枝番⇒DaibensaiReportEntity.稟議番号枝番
        outEntity5.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　・更正（赤）データの充当対象払込期日⇒DaibensaiReportEntity.充当対象払込期日
        if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho_Red())) {
            outEntity5.setDate_JutoTaisho(inDto.getLblID_Date_JutoTaisho_Red());
        }
        // 　　　　　　・更正（赤）データの代弁金払込日⇒DaibensaiReportEntity.代弁金払込日
        if (isAlreadyInput(inDto.getLblID_Date_DaibenkinHaraikomi_Red())) {
            outEntity5.setDate_DaibenkinHaraikomi(inDto.getLblID_Date_DaibenkinHaraikomi_Red());
        }
        // 　　　　　　・更正（赤）データの遅延損害金⇒DaibensaiReportEntity.遅延損害金
        if (isAlreadyInput(inDto.getLblID_M_ChienSongai_Red())) {
            outEntity5
                    .setM_ChienSongai(new BigDecimal(inDto.getLblID_M_ChienSongai_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの利息⇒DaibensaiReportEntity.利息
        if (isAlreadyInput(inDto.getLblID_M_Risoku_Red())) {
            outEntity5.setM_Risoku(new BigDecimal(inDto.getLblID_M_Risoku_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの元金⇒DaibensaiReportEntity.元金
        if (isAlreadyInput(inDto.getLblID_M_Gankin_Red())) {
            outEntity5.setM_Gankin(new BigDecimal(inDto.getLblID_M_Gankin_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの計⇒DaibensaiReportEntity.計
        if (isAlreadyInput(inDto.getLblID_M_Kei_Red())) {
            outEntity5.setM_Kei(new BigDecimal(inDto.getLblID_M_Kei_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの仮受金(一般口)からの充当額⇒DaibensaiReportEntity.仮受金（一般口からの）充当
        outEntity5.setM_KariukeIppanJuto(BigDecimal.ZERO);
        if (isAlreadyInput(inDto.getLblID_M_KariukeIppanJuto_Red())) {
            outEntity5.setM_KariukeIppanJuto(new BigDecimal(inDto.getLblID_M_KariukeIppanJuto_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの代弁金充当後残元金⇒DaibensaiReportEntity.代弁金充当後残元金
        if (isAlreadyInput(inDto.getLblID_M_ZanGanAfterDaibenJuto_Red())) {
            outEntity5.setM_ZanGanAfterDaibenJuto(new BigDecimal(inDto.getLblID_M_ZanGanAfterDaibenJuto_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの繰上償還手数料⇒DaibensaiReportEntity.繰上償還手数料
        if (isAlreadyInput(inDto.getLblID_M_KurishoCommission_Red())) {
            outEntity5.setM_KurishoCommission(new BigDecimal(inDto.getLblID_M_KurishoCommission_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの送金額⇒DaibensaiReportEntity.送金額
        if (isAlreadyInput(inDto.getLblID_M_Sokin_Red())) {
            outEntity5.setM_Sokin(new BigDecimal(inDto.getLblID_M_Sokin_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの扱店名⇒DaibensaiReportEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity5.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　・更正（赤）データの顧客名⇒DaibensaiReportEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity5.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　代位弁済金払込・充当報告書データを追加する。
        // 　　　　（４）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.insert
        // DaibensaiReportEntity inEntity = new DaibensaiReportEntity();
        try {
            if (1 < daibensaireportdao.insert(outEntity5)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        return outDto;
    }

    /**
     * Md005_02ServiceのupdateDataNotProcEndMod
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO updateDataNotProcEndMod(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // 現在の日付(業務日付)取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");
        // 現在の日時取得
        Timestamp nowDateTime = PNDateUtils.formatTimestamp(nowDate + nowTime + "000");
        // 画面表示時に取得した報告書番号を保持
        String keepDbIdReport = inDto.getID_ID_Report();

        // 修正：処理完了以外の更新処理。
        // 　＜画面表示時に取得したレコードﾞに対する取消処理＞

        // 　　１．報告書履歴データのレコードを更新　　※更正（赤）画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①""⇒更正（赤）データの報告書番号
        String iDReportRed = PNCommonConstants.LITERAL_BLANK;
        // 　　　　　　②"1"⇒更正（赤）データの取消済みフラグ（非表示）
        BigDecimal flagTorikeshizumiRed = BigDecimal.ONE;
        // 　　　　　　③退避約定利息⇒更正（赤）データの請求データに登録を行う約定利息
        String iD_M_YakujoRisoku_Seikyu = inDto.getID_Keep_M_YakujoRisoku();
        // 　　　　　　④退避約定元金⇒更正（赤）データの請求データに登録を行う約定元金
        String iD_M_YakujoGankin_Yakujo = inDto.getID_Keep_M_YakujoGankin();
        // 　　　　　　⑤退避請求繰償利息⇒更正（赤）データの請求データに登録を行う請求繰償利息
        String iD_Seikyu_M_SeiKuriRisoku = inDto.getID_Keep_Seikyu_M_SeiKuriRisoku();
        // 　　　　　　⑥退避請求繰償元金⇒更正（赤）データの請求データに登録を行う請求繰償元金
        String iD_Seikyu_M_SeiKuriGankin = inDto.getID_Keep_Seikyu_M_SeiKuriGankin();
        // 　　　　　　⑦現在の日付⇒更正（赤）データの報告年月日
        inDto.setLblID_Date_Report(nowDate);
        // 　　　　　　⑧現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(nowTime);
        // 　　　　更新を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        // 履歴番号
        inEntity.setID_History(inDto.getID_ID_History());
        // ステータス
        if (true == isAlreadyInput(inDto.getID_Status())) {
            inEntity.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (true == isAlreadyInput(inDto.getID_DataCode())) {
            inEntity.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (true == isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity.setType_Process(inDto.getID_Type_Process());
        }
        long hitcount = reporthistorydao.countByCondition(inEntity);

        // 検索結果判定
        if (0 == hitcount) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
            outEntity.setID_Report(iDReportRed);
            // 　　　　　　②更正（赤）データの取消済みフラグ（非表示）⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(flagTorikeshizumiRed);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（８）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　２．代位弁済金払込・充当報告書の該当レコードの削除　　※画面表示の対象となったﾚｺｰﾄﾞを削除
        DaibensaireportEntity inEntity2 = new DaibensaireportEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①報告書番号⇒更正（赤）データの報告書番号　　　　　（画面表示に取得した際の報告書番号で再設定）
        inDto.setID_ID_Report(keepDbIdReport);
        inEntity2.setID_Report(inDto.getID_ID_Report());
        // 　　　　削除を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        long hitcount2 = daibensaireportdao.countByCondition(inEntity2);

        if (0 == hitcount2) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount2) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　代位弁済金払込・充当報告書データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.findByPrimaryKeyForUpdate
        try {
            DaibensaireportEntity outEntity = daibensaireportdao.findByPrimaryKeyForUpdate(inEntity2);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　代位弁済金払込・充当報告書データを削除する。
            // 　　　　（７）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　削除処理」を参照し、条件を設定する。
            // 　　　　　　DaibensaiReportDAO.delete
            // DaibensaiReportEntity inEntity = new DaibensaiReportEntity();
            // すでに更新されているかチェック処理を記述
            if (1 < daibensaireportdao.delete(inEntity2)) {
                // 　　　　取得した件数＞１の場合、業務エラーとする。
                // 　　　　　エラーメッセージ：PM9010E
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // 　　４．請求データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        boolean inputKeepMYakujoRisoku = isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku());
        boolean inputKeepMYakujoGankin = isAlreadyInput(inDto.getID_Keep_M_YakujoGankin());
        boolean inputSeikyuMSeiKuriRisoku = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        boolean inputSeikyuMSeiKuriGankin = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        if (inputKeepMYakujoRisoku && inputKeepMYakujoGankin && inputSeikyuMSeiKuriRisoku
                && inputSeikyuMSeiKuriGankin) {
            // 　　　　（１）更生（赤）データの退避約定利息＜＞NULL AND 更正（赤）データの退避約定元金＜＞NULL AND
            // 　　　　　　　更正（赤）データの退避請求繰償利息＜＞NULL AND　更正（赤）データの退避請求繰償元金＜＞NULL の場合

            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity4 = new SeikyuEntity();
            // 債権管理番号
            inEntity4.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 払込年月日
            inEntity4.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
            // 件数取得
            long hitcount4 = seikyudao.countByCondition(inEntity4);

            // 検索結果判定
            if (0 == hitcount4) {
                // 　　　　　　②取得した件数＝０の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PTN001,DB007
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            } else if (1 < hitcount4) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　　　請求データを排他読込をする。
            // 　　　　　　④単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
            try {
                SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntity4);

                if (null == outEntity) {
                    // 　　　　　　⑤排他エラーの場合、業務エラーとする。
                    // 　　　　　　　　エラーメッセージ：PTN001,DB007
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // 　　　　　　⑥請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                // 　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                if (isAlreadyInput(inDto.getID_ID_Credit())) {
                    outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                }
                // 　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                    outEntity.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                }
                // 　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                if (isAlreadyInput(iD_M_YakujoRisoku_Seikyu)) {
                    outEntity.setM_YakujoRisoku(new BigDecimal(iD_M_YakujoRisoku_Seikyu));
                }
                // 　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                if (isAlreadyInput(iD_M_YakujoGankin_Yakujo)) {
                    outEntity.setM_YakujoGankin(new BigDecimal(iD_M_YakujoGankin_Yakujo));
                }
                // 　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                if (isAlreadyInput(iD_Seikyu_M_SeiKuriRisoku)) {
                    outEntity.setM_SeiKuriRisoku(new BigDecimal(iD_Seikyu_M_SeiKuriRisoku));
                }
                // 　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                if (isAlreadyInput(iD_Seikyu_M_SeiKuriGankin)) {
                    outEntity.setM_SeiKuriGankin(new BigDecimal(iD_Seikyu_M_SeiKuriGankin));
                }
                // 　　　　　　請求データを更新をする。
                // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.updata
                // すでに更新されているかチェック処理を記述
                if (1 < seikyudao.update(outEntity)) {
                    // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                    // 　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            } catch (CFWForUpdateException fue) {
                // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            } catch (CFWDuplicateKeyException fue) {
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }
        }

        // 　　修正データの登録

        // 　　５．報告書履歴データの追加（修正用）
        ReporthistoryEntity inEntity5 = new ReporthistoryEntity();

        // 　　　　（１）履歴番号の再取得および登録値として再設定する。
        // 　　　　　　　修正データの履歴番号⇒退避用履歴番号
        String strID_History = inDto.getID_ID_History();
        // 　　　　　　　修正データの報告書番号⇒退避用報告書番号
        String strID_Report = inDto.getID_ID_Report();
        // 履歴番号
        inEntity5.setID_History(strID_History);
        // ステータス
        if (isAlreadyInput(inDto.getID_Status())) {
            inEntity5.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (isAlreadyInput(inDto.getID_DataCode())) {
            inEntity5.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity5.setType_Process(inDto.getID_Type_Process());
        }
        // 　　　　　　①単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        long hitcount5 = reporthistorydao.countByCondition(inEntity5);
        if (0 < hitcount5) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History = pnCommonDBComponents.getIdHistoryRh();
            // 　　　　　　　　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用報告書番号に設定する。
            strID_Report = pnCommonDBComponents.getIdReportRh();
        }
        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity5 = new ReporthistoryEntity();
        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity5.setID_History(strID_History);
        }
        // 　　　　　　　　・退避用報告書番号⇒ReporthistoryEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity5.setID_Report(strID_Report);
        }
        // 　　　　　　　　・修正データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity5.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity5.setTime_Report(nowTime);

        // 　　　　　　　　・１⇒ReporthistoryEntity.ステータス
        outEntity5.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_1));

        // 　　　　　　　　・９０２５７０７０⇒ReporthistoryEntity.データコード
        outEntity5.setDataCode(PNCommonConstants.DATACODE_90257070);

        // 　　　　　　　　・２０⇒ReporthistoryEntity.処理種別
        outEntity5.setType_Process(PNCommonConstants.TYPE_PROCESS_20);

        // 　　　　　　　　・０⇒ReporthistoryEntity.取消済フラグ
        outEntity5.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // 　　　　　　　　・修正データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity5.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・修正データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization())) {
            outEntity5.setName_Organization(inDto.getLblID_Name_Organization());
        }
        // 　　　　　　　　・修正データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer())) {
            outEntity5.setName_Customer(inDto.getLblID_Name_Customer());
        }
        // 　　　　　　　　・修正データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten())) {
            outEntity5.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten());
        }
        // 　　　　　　　　・修正データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization())) {
            outEntity5.setCode_Organization(inDto.getLblID_Code_Organization());
        }
        // 　　　　　　　　・修正データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo())) {
            outEntity5.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
        }
        // 　　　　　　　　・修正データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year())) {
            outEntity5.setYear(inDto.getLblID_Year());
        }
        // 　　　　　　　　・修正データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin())) {
            outEntity5.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin());
        }
        // 　　　　　　　　・修正データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi())) {
            outEntity5.setID_Ringi(inDto.getLblID_ID_Ringi());
        }

        // 　　　　　　　　・修正データの枝番⇒ReporthistoryEntity.枝番(修正データの枝番が空白の場合、0とする。)
        outEntity5.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));

        // 　　　　　　　　・修正データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity5.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・修正データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity5.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・修正データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity5.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }
        // 　　　　　　　　・修正データの退避償還期限（非表示）⇒ReporthistoryEntity.退避償還期限年月
        if (isAlreadyInput(inDto.getID_Keep_Date_ShokanKigen())) {
            outEntity5.setKeep_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
        }
        // 　　　　　　　　・修正データの退避貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_Keep_M_KashitsukeZan())) {
            outEntity5.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_Keep_M_KashitsukeZan()));
        }
        // 　　　　　　　　・修正データの退避約定元金⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoGankin())) {
            outEntity5.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_Keep_M_YakujoGankin()));
        }
        // 　　　　　　　　・修正データの退避約定利息⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
            outEntity5.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_Keep_M_YakujoRisoku()));
        }
        // 　　　　　　　　・修正データの退避請求繰償利息⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku())) {
            outEntity5.setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriRisoku()));
        }
        // 　　　　　　　　・修正データの退避履歴番号⇒ReporthistoryEntity.退避履歴番号
        if (isAlreadyInput(inDto.getID_Keep_ID_History())) {
            outEntity5.setKeep_ID_History(inDto.getID_Keep_ID_History());
        }
        // 　　　　　　　　・修正データの退避実行済みフラグ⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        if (isAlreadyInput(inDto.getID_Keep_Flag_Kj())) {
            outEntity5.setKeep_Flag_Kj(new BigDecimal(inDto.getID_Keep_Flag_Kj()));
        }
        // 　　　　　　　　・修正データの退避請求繰償元金⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin())) {
            outEntity5.setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriGankin()));
        }
        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity5)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：BA001,DB010
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　６．代位弁済金払込・充当報告書の追加（修正）
        // 　　　　追加を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        DaibensaireportEntity inEntity6 = new DaibensaireportEntity();
        // 報告書番号 DTO項目 ID_Report
        inEntity6.setID_Report(strID_Report);
        // 件数取得
        long hitcount6 = daibensaireportdao.countByCondition(inEntity6);
        if (0 < hitcount6) {
            // 　　　　（２）取得した件数＞＝１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　（３）代位弁済金払込・充当報告書データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        DaibensaireportEntity outEntity6 = new DaibensaireportEntity();
        // 　　　　　　・退避用報告書番号⇒DaibensaiReportEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity6.setID_Report(strID_Report);
        }
        // 　　　　　　・修正データの報告年月日⇒DaibensaiReportEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity6.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　・修正データの報告時分秒⇒DaibensaiReportEntity.報告時分秒
        if (isAlreadyInput(inDto.getID_Time_Report())) {
            outEntity6.setTime_Report(inDto.getID_Time_Report());
        }
        // 　　　　　　・修正データのユーザID（非表示）⇒DaibensaiReportEntity.ユーザID
        outEntity6.setUserID(pnCommonInfo.getLogonID());

        // 　　　　　　・修正データの伝送番号（非表示）⇒DaibensaiReportEntity.伝送番号
        if (isAlreadyInput(inDto.getID_ID_Denso())) {
            outEntity6.setID_Denso(inDto.getID_ID_Denso());
        }

        // 　　　　　　・９０２５７０７０⇒ReporthistoryEntity.データコード
        outEntity6.setDataCode(PNCommonConstants.DATACODE_90257070);

        // 　　　　　　・修正データの公庫支店⇒DaibensaiReportEntity.公庫支店コード
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten())) {
            outEntity6.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten());
        }
        // 　　　　　　・修正データの扱店⇒DaibensaiReportEntity.扱店コード
        if (isAlreadyInput(inDto.getLblID_Code_Organization())) {
            outEntity6.setCode_Organization(inDto.getLblID_Code_Organization());
        }
        // 　　　　　　・修正データの店舗⇒DaibensaiReportEntity.店舗コード
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo())) {
            outEntity6.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
        }
        // 　　　　　　・修正データの受託者勘定処理年月⇒DaibensaiReportEntity.受託者勘定処理年月
        if (isAlreadyInput(inDto.getLblID_Date_Jtkshori())) {
            outEntity6.setDate_Jtkshori(inDto.getLblID_Date_Jtkshori());
        }
        // 　　　　　　・修正データの送金日⇒DaibensaiReportEntity.送金日
        if (isAlreadyInput(inDto.getLblID_Date_Sokin())) {
            outEntity6.setDate_Sokin(inDto.getLblID_Date_Sokin());
        }
        // 　　　　　　・修正データの送金日番号⇒DaibensaiReportEntity.送金日番号
        if (isAlreadyInput(inDto.getLblID_ID_Sokinbi())) {
            outEntity6.setID_Sokinbi(inDto.getLblID_ID_Sokinbi());
        }
        // 　　　　　　・修正データの年度⇒DaibensaiReportEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year())) {
            outEntity6.setYear(inDto.getLblID_Year());
        }
        // 　　　　　　・修正データの方式資金⇒DaibensaiReportEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin())) {
            outEntity6.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin());
        }
        // 　　　　　　・修正データの番号⇒DaibensaiReportEntity.稟議番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi())) {
            outEntity6.setID_Ringi(inDto.getLblID_ID_Ringi());
        }

        // 　　　　　　・修正データの枝番⇒DaibensaiReportEntity.稟議番号枝番
        outEntity6.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));

        // 　　　　　　・修正データの充当対象払込期日⇒DaibensaiReportEntity.充当対象払込期日
        if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho())) {
            outEntity6.setDate_JutoTaisho(inDto.getLblID_Date_JutoTaisho());
        }
        // 　　　　　　・修正データの代弁金払込日⇒DaibensaiReportEntity.代弁金払込日
        if (isAlreadyInput(inDto.getLblID_Date_DaibenkinHaraikomi())) {
            outEntity6.setDate_DaibenkinHaraikomi(inDto.getLblID_Date_DaibenkinHaraikomi());
        }
        // 　　　　　　・修正データの遅延損害金⇒DaibensaiReportEntity.遅延損害金
        if (isAlreadyInput(inDto.getLblID_M_ChienSongai())) {
            outEntity6.setM_ChienSongai(new BigDecimal(inDto.getLblID_M_ChienSongai().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの利息⇒DaibensaiReportEntity.利息
        if (isAlreadyInput(inDto.getLblID_M_Risoku())) {
            outEntity6.setM_Risoku(new BigDecimal(inDto.getLblID_M_Risoku().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの元金⇒DaibensaiReportEntity.元金
        if (isAlreadyInput(inDto.getLblID_M_Gankin())) {
            outEntity6.setM_Gankin(new BigDecimal(inDto.getLblID_M_Gankin().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの計⇒DaibensaiReportEntity.計
        if (isAlreadyInput(inDto.getLblID_M_Kei())) {
            outEntity6.setM_Kei(new BigDecimal(inDto.getLblID_M_Kei().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの仮受金(一般口)からの充当額⇒DaibensaiReportEntity.仮受金（一般口からの）充当
        outEntity6.setM_KariukeIppanJuto(BigDecimal.ZERO);
        if (isAlreadyInput(inDto.getLblID_M_KariukeIppanJuto())) {
            outEntity6.setM_KariukeIppanJuto(new BigDecimal(inDto.getLblID_M_KariukeIppanJuto().replaceAll(
                    ",", "")));
        }
        // 　　　　　　・修正データの代弁金充当後残元金⇒DaibensaiReportEntity.代弁金充当後残元金
        if (isAlreadyInput(inDto.getLblID_M_ZanGanAfterDaibenJuto())) {
            outEntity6.setM_ZanGanAfterDaibenJuto(new BigDecimal(inDto.getLblID_M_ZanGanAfterDaibenJuto()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・修正データの繰上償還手数料⇒DaibensaiReportEntity.繰上償還手数料
        if (isAlreadyInput(inDto.getLblID_M_KurishoCommission())) {
            outEntity6.setM_KurishoCommission(new BigDecimal(inDto.getLblID_M_KurishoCommission().replaceAll(
                    ",", "")));
        }
        // 　　　　　　・修正データの送金額⇒DaibensaiReportEntity.送金額
        if (isAlreadyInput(inDto.getLblID_M_Sokin())) {
            outEntity6.setM_Sokin(new BigDecimal(inDto.getLblID_M_Sokin().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの扱店名⇒DaibensaiReportEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization())) {
            outEntity6.setName_Organization(inDto.getLblID_Name_Organization());
        }
        // 　　　　　　・修正データの顧客名⇒DaibensaiReportEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer())) {
            outEntity6.setName_Customer(inDto.getLblID_Name_Customer());
        }
        // 　　　　代位弁済金払込・充当報告書データを追加する。
        // 　　　　（４）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.insert
        // DaibensaiReportEntity inEntity = new DaibensaiReportEntity();
        try {
            if (1 < daibensaireportdao.insert(outEntity6)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　７．扱店別稟議データのレコードを更新（修正）
        // 　　　　更新を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　最新更新日時
        // 　　　　　　AringiDAO.countByCondition
        AringiEntity inEntity7 = new AringiEntity();
        // 条件を設定
        // 債権管理番号
        inEntity7.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        // 最新更新日時
        if (isAlreadyInput(inDto.getID_Data_LastUpDate())) {
            inEntity7.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        }
        // 件数取得
        long hitcount7 = aringidao.countByCondition(inEntity7);
        // 検索結果判定
        if (0 == hitcount7) {
            // 　　　　（２）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } else if (1 < hitcount7) {
            // 　　　　（３）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　扱店別稟議データを排他読込をする。
        // 　　　　（４）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　AringiDAO.findByPrimaryKeyForUpdate
        // AringiEntity inEntity = new AringiEntity();
        try {
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntity7);

            if (null == outEntity) {
                // 　　　　（５）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（６）扱店別稟議データの更新用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            // 　　　　　　　　（ａ）扱店別稟議データに登録を行う償還期限⇒aRingiEntity.償還期限年月
            outEntity.setDate_ShokanKigen(inDto.getID_Date_ShokanKigen_aRingi());
            // 　　　　　　　　（ｂ）扱店別稟議データに登録を行う払込前残元金⇒aRingiEntity.貸付金残高
            if (true == isAlreadyInput(inDto.getID_M_KashitsukeZandaka_aRingi())) {
                outEntity.setM_KashitsukeZandaka(new BigDecimal(inDto.getID_M_KashitsukeZandaka_aRingi()));
            }
            // 　　　　　　②現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            outEntity.setData_LastUpDate(nowDateTime);
            // 　　　　扱店別稟議データを更新をする。
            // 　　　　（７）単テーブルアクセス定義「扱店別稟議データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
            // 　　　　　　AringiDAO.updata
            // 債権管理番号
            outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // すでに更新されているかチェック処理を記述
            if (1 < aringidao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　８．請求データのレコードを更新（修正）　　※約定利息、約定元金の入力値が共に'0'でない（有額の場合）場合に請求データの更新
        // 修正データの利息
        BigDecimal risoku = BigDecimal.ZERO;
        if (isAlreadyInput(inDto.getLblID_M_Risoku())) {
            risoku = new BigDecimal(inDto.getLblID_M_Risoku().replaceAll(",", ""));
        }
        // 修正データの元金
        BigDecimal gankin = BigDecimal.ZERO;
        if (isAlreadyInput(inDto.getLblID_M_Gankin())) {
            gankin = new BigDecimal(inDto.getLblID_M_Gankin().replaceAll(",", ""));
        }
        if (0 != BigDecimal.ZERO.compareTo(risoku) || 0 != BigDecimal.ZERO.compareTo(gankin)) {
            // 　　　　（１）修正データの利息＜＞０ OR 修正データの元金＜＞０　の場合
            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity8 = new SeikyuEntity();
            // 債権管理番号
            inEntity8.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 修正データの充当対象払込期日⇒検索条件の払込年月日
            inEntity8.setDate_Haraikomi(inDto.getLblID_Date_JutoTaisho());
            // 件数取得
            long hitcount8 = seikyudao.countByCondition(inEntity8);

            // 検索結果判定
            if (0 == hitcount8) {
                // 　　　　　　②取得した件数＝０の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            } else if (1 < hitcount8) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　　　請求データを排他読込をする。
            // 　　　　　　④単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
            try {
                SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntity8);
                if (null == outEntity) {
                    // 　　　　　　⑤排他エラーの場合、業務エラーとする。
                    // 　　　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // 　　　　　　⑥請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                // 　　　　　　　　（ａ）修正データの債権管理番号⇒SeikyuEntity.債権管理番号
                if (isAlreadyInput(inDto.getID_ID_Credit())) {
                    outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                }
                // 　　　　　　　　（ｂ）修正データの充当対象払込期日⇒SeikyuEntity.払込年月日
                if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho())) {
                    outEntity.setDate_Haraikomi(inDto.getLblID_Date_JutoTaisho());
                }
                // 　　　　　　　　（ｃ）修正データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                    outEntity.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                }
                // 　　　　　　　　（ｄ）修正データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                    outEntity.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                }
                // 　　　　　　　　（ｅ）修正データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                    outEntity.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                }
                // 　　　　　　　　（ｆ）修正データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                    outEntity.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                }
                // 　　　　　　請求データを更新をする。
                // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.updata
                // すでに更新されているかチェック処理を記述
                if (1 < seikyudao.update(outEntity)) {
                    // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                    // 　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            } catch (CFWForUpdateException fue) {
                // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            } catch (CFWDuplicateKeyException fue) {
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }
        }

        return outDto;
    }

    /**
     * Md005_02ServiceのupdateDataProcEndMod
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO updateDataProcEndMod(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // 現在の日付(業務日付)取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");
        // 現在の日時取得
        Timestamp nowDateTime = PNDateUtils.formatTimestamp(nowDate + nowTime + "000");
        // // 画面表示時に取得した報告書番号を保持
        // String keepDbIdReport = inDto.getID_ID_Report();

        // 修正：処理完了の更新処理。
        // 　＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // 　　　　（２）更正（赤）データの値を設定しなおす。
        // 　　　　　　①"1"⇒更正（赤）データの取消済みフラグ（非表示）
        BigDecimal flagTorikeshizumiRed = BigDecimal.ONE;
        // 　　　　　　②退避約定利息⇒更正（赤）データの請求データに登録を行う約定利息
        String ID_M_YakujoRisoku_Seikyu_Red = inDto.getID_Keep_M_YakujoRisoku();
        // 　　　　　　③退避約定元金⇒更正（赤）データの請求データに登録を行う約定元金
        String ID_M_YakujoGankin_Yakujo_Red = inDto.getID_Keep_M_YakujoGankin();
        // 　　　　　　④退避請求繰償利息⇒更正（赤）データの請求データに登録を行う請求繰償利息
        String ID_Seikyu_M_SeiKuriRisoku_Red = inDto.getID_Keep_Seikyu_M_SeiKuriRisoku().toString();
        // 　　　　　　⑤退避請求繰償元金⇒更正（赤）データの請求データに登録を行う請求繰償元金
        String ID_Seikyu_M_SeiKuriGankin_Red = inDto.getID_Keep_Seikyu_M_SeiKuriGankin();
        // 　　　　　　⑥現在の日付⇒更正（赤）データの報告年月日
        inDto.setLblID_Date_Report(nowDate);
        // 　　　　　　⑦現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(nowTime);
        // 　　　　更新を行うデータの確認
        // 　　　　（３）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        ReporthistoryEntity inEntity = new ReporthistoryEntity();
        // 履歴番号
        inEntity.setID_History(inDto.getID_ID_History());
        // ステータス
        if (true == isAlreadyInput(inDto.getID_Status())) {
            inEntity.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (true == isAlreadyInput(inDto.getID_DataCode())) {
            inEntity.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (true == isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        long hitcount = reporthistorydao.countByCondition(inEntity);

        // 検索結果判定
        if (0 == hitcount) {
            // 　　　　（４）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount) {
            // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：BA001,DB004
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }

        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（６）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity);

            if (null == outEntity) {
                // 　　　　（７）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（８）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
            outEntity.setID_Report(inDto.getID_ID_Report());
            // 　　　　　　②更正（赤）データの取消済みフラグ（非表示）⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(flagTorikeshizumiRed);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（９）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }

        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　３．請求データのレコードを更新　　※画面データ取得時の退避約定利息、退避約定元金の値が共にNULLで無かった（有額）場合のみ請求データの更新
        boolean inputKeepMYakujoRisoku = isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku());
        boolean inputKeepMYakujoGankin = isAlreadyInput(inDto.getID_Keep_M_YakujoGankin());
        boolean inputSeikyuMSeiKuriRisoku = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        boolean inputSeikyuMSeiKuriGankin = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        if (inputKeepMYakujoRisoku && inputKeepMYakujoGankin && inputSeikyuMSeiKuriRisoku
                && inputSeikyuMSeiKuriGankin) {
            // 　　　　（１）更生（赤）データの退避約定利息＜＞NULL AND 更正（赤）データの退避約定元金＜＞NULL AND
            // 　　　　　　　更正（赤）データの退避請求繰償利息＜＞NULL AND　更正（赤）データの退避請求繰償元金＜＞NULL の場合

            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity3 = new SeikyuEntity();
            SeikyuEntity outEntity3 = null;
            // 債権管理番号
            inEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 払込年月日
            inEntity3.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
            // 　　　　　　　　SeikyuDAO.countByCondition
            // 件数取得
            long hitcount3 = seikyudao.countByCondition(inEntity3);

            // 検索結果判定
            if (0 == hitcount3) {
                // 　　　　　　②取得した件数＝０の場合
                // 　　　　　　　　(ｱ)請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                try {
                    outEntity3 = new SeikyuEntity();
                    // 　　　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity3.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity3.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(ID_M_YakujoRisoku_Seikyu_Red)) {
                        outEntity3.setM_YakujoRisoku(new BigDecimal(ID_M_YakujoRisoku_Seikyu_Red));
                    }
                    // 　　　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(ID_M_YakujoGankin_Yakujo_Red)) {
                        outEntity3.setM_YakujoGankin(new BigDecimal(ID_M_YakujoGankin_Yakujo_Red));
                    }
                    // 　　　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(ID_Seikyu_M_SeiKuriRisoku_Red)) {
                        outEntity3.setM_SeiKuriRisoku(new BigDecimal(ID_Seikyu_M_SeiKuriRisoku_Red));
                    }
                    // 　　　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(ID_Seikyu_M_SeiKuriGankin_Red)) {
                        outEntity3.setM_SeiKuriGankin(new BigDecimal(ID_Seikyu_M_SeiKuriGankin_Red));
                    }
                    if (1 < seikyudao.insert(outEntity3)) {
                        // 　　　　　取得した件数＞１の場合、業務エラーとする。
                        // 　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
            if (1 < hitcount3) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            if (1 == hitcount3) {
                // 　　　　　　④取得した件数＝１の場合
                // 　　　　　　請求データを排他読込をする。
                // 　　　　　　　　(ｱ)単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
                try {
                    SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntity3);
                    if (null == outEntity) {
                        // 　　　　　　　　(ｲ)排他エラーの場合、業務エラーとする。
                        // 　　　　　　　　エラーメッセージ：PTN001,DB007
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // 　　　　　　　　(ｳ)請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    // 　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(ID_M_YakujoRisoku_Seikyu_Red)) {
                        outEntity.setM_YakujoRisoku(new BigDecimal(ID_M_YakujoRisoku_Seikyu_Red));
                    }
                    // 　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(ID_M_YakujoGankin_Yakujo_Red)) {
                        outEntity.setM_YakujoGankin(new BigDecimal(ID_M_YakujoGankin_Yakujo_Red));
                    }
                    // 　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(ID_Seikyu_M_SeiKuriRisoku_Red)) {
                        outEntity.setM_SeiKuriRisoku(new BigDecimal(ID_Seikyu_M_SeiKuriRisoku_Red));
                    }
                    // 　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(ID_Seikyu_M_SeiKuriGankin_Red)) {
                        outEntity.setM_SeiKuriGankin(new BigDecimal(ID_Seikyu_M_SeiKuriGankin_Red));
                    }
                    // 　　　　　　請求データを更新をする。
                    // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    // 　　　　　　　　SeikyuDAO.updata
                    // すでに更新されているかチェック処理を記述
                    if (1 < seikyudao.update(outEntity)) {
                        // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                        // 　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWFindParameterException fpe) {
                    // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                } catch (CFWForUpdateException fue) {
                    // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
        }

        // 　　取消内容のﾃﾞｰﾀに対するﾚｺｰﾄﾞの追加　　※更正（赤）画面に表示したﾃﾞｰﾀを使用し、該当ﾃｰﾌﾞﾙの追加・更新処理を行う

        // 　　４．報告書履歴データの追加（取消用）
        ReporthistoryEntity inEntity4 = new ReporthistoryEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　（２）履歴番号の再取得および登録値として再設定する。
        // 　　　　　　　更正（赤）データの履歴番号⇒退避用履歴番号
        String strID_History = inDto.getID_ID_History();
        // 　　　　　　　更正（赤）データの報告書番号⇒退避用報告書番号
        String strID_Report = inDto.getID_ID_Report();
        // 　　　　　　①単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        // 履歴番号
        inEntity4.setID_History(strID_History);
        // ステータス
        if (isAlreadyInput(inDto.getID_Status())) {
            inEntity4.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (isAlreadyInput(inDto.getID_DataCode())) {
            inEntity4.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity4.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        long hitcount4 = reporthistorydao.countByCondition(inEntity4);
        if (0 < hitcount4) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History = pnCommonDBComponents.getIdHistoryRh();
            // 　　　　　　　　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用報告書番号に設定する。
            strID_Report = pnCommonDBComponents.getIdReportRh();
        }
        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity4 = new ReporthistoryEntity();
        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity4.setID_History(strID_History);
        }
        // 　　　　　　　　・退避用報告書番号⇒ReporthistoryEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity4.setID_Report(strID_Report);
        }
        // 　　　　　　　　・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity4.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity4.setTime_Report(nowTime);

        // 　　　　　　　　・１⇒ReporthistoryEntity.ステータス
        outEntity4.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_1));

        // 　　　　　　　　・９０２５７０７１⇒ReporthistoryEntity.データコード
        outEntity4.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　　　・１０⇒ReporthistoryEntity.処理種別
        outEntity4.setType_Process(PNCommonConstants.TYPE_PROCESS_10);

        // 　　　　　　　　・０⇒ReporthistoryEntity.取消済フラグ
        outEntity4.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // 　　　　　　　　・更正（赤）データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity4.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity4.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity4.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　　　　　・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity4.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　　　・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity4.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity4.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　　　・更正（赤）データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity4.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　　　・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity4.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　　　・更正（赤）データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity4.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　　　・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        outEntity4.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　　　・更正（赤）データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity4.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・更正（赤）データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity4.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity4.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }
        // 　　　　　　　　・扱店別稟議データより取得した償還期限年月⇒ReporthistoryEntity.退避償還期限年月
        if (isAlreadyInput(inDto.getID_aRingi_Date_ShokanKigen())) {
            outEntity4.setKeep_Date_ShokanKigen(inDto.getID_aRingi_Date_ShokanKigen());
        }
        // 　　　　　　　　・M_貸付残高（稟議データの貸付金残高（非表示）)⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_M_KashitsukeZandaka())) {
            outEntity4.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_M_KashitsukeZandaka()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「約定元金」⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_M_YakujoGankin_Seikyu_Red())) {
            outEntity4.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「約定利息」⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu_Red())) {
            outEntity4.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「請求繰償利息」⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_M_SeiKuriRisoku_Seikyu_Red())) {
            outEntity4
                    .setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto.getID_M_SeiKuriRisoku_Seikyu_Red()));
        }
        // 　　　　　　　　・更正（赤）データの退避履歴番号⇒ReporthistoryEntity.退避履歴番号
        if (isAlreadyInput(inDto.getID_ID_History())) {
            outEntity4.setKeep_ID_History(inDto.getID_ID_History());
        }
        // 　　　　　　　　・更正（赤）データの退避実行済みフラグ⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        if (isAlreadyInput(inDto.getID_Keep_Flag_Kj())) {
            outEntity4.setKeep_Flag_Kj(new BigDecimal(inDto.getID_Keep_Flag_Kj()));
        }
        // 　　　　　　　　・更正（赤）データの請求データ「請求繰償元金」⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_M_SeiKuriGankin_Seikyu_Red())) {
            outEntity4
                    .setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto.getID_M_SeiKuriGankin_Seikyu_Red()));
        }
        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity4)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　５．代位弁済金払込・充当報告書の追加（更正（赤））
        // 　　　　追加を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        DaibensaireportEntity inEntity5 = new DaibensaireportEntity();
        // 報告書番号 DTO項目 ID_Report
        inEntity5.setID_Report(strID_Report);
        // 件数取得
        long hitcount5 = daibensaireportdao.countByCondition(inEntity5);
        if (0 < hitcount5) {
            // 　　　　（２）取得した件数＞＝１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　（３）代位弁済金払込・充当報告書データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        DaibensaireportEntity outEntity5 = new DaibensaireportEntity();
        // 　　　　　　・退避用報告書番号⇒DaibensaiReportEntity.報告書番号
        if (true == isAlreadyInput(strID_Report)) {
            outEntity5.setID_Report(strID_Report);
        }
        // 　　　　　　・更正（赤）データの報告年月日⇒DaibensaiReportEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity5.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　・更正（赤）データの報告時分秒⇒DaibensaiReportEntity.報告時分秒
        if (isAlreadyInput(inDto.getID_Time_Report())) {
            outEntity5.setTime_Report(inDto.getID_Time_Report());
        }
        // 　　　　　　・更正（赤）データのユーザID（非表示）⇒DaibensaiReportEntity.ユーザID
        outEntity5.setUserID(pnCommonInfo.getLogonID());

        // 　　　　　　・更正（赤）データの伝送番号（非表示）⇒DaibensaiReportEntity.伝送番号
        if (isAlreadyInput(inDto.getID_ID_Denso())) {
            outEntity5.setID_Denso(inDto.getID_ID_Denso());
        }
        // 　　　　　　・９０２５７０７１⇒DaibensaiReportEntity.データコード
        outEntity5.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　・更正（赤）データの公庫支店⇒DaibensaiReportEntity.公庫支店コード
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity5.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　・更正（赤）データの扱店⇒DaibensaiReportEntity.扱店コード
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity5.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　・更正（赤）データの店舗⇒DaibensaiReportEntity.店舗コード
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity5.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　・更正（赤）データの受託者勘定処理年月⇒DaibensaiReportEntity.受託者勘定処理年月
        if (isAlreadyInput(inDto.getLblID_Date_Jtkshori_Red())) {
            outEntity5.setDate_Jtkshori(inDto.getLblID_Date_Jtkshori_Red());
        }
        // 　　　　　　・更正（赤）データの送金日⇒DaibensaiReportEntity.送金日
        if (isAlreadyInput(inDto.getLblID_Date_Sokin_Red())) {
            outEntity5.setDate_Sokin(inDto.getLblID_Date_Sokin_Red());
        }
        // 　　　　　　・更正（赤）データの送金日番号⇒DaibensaiReportEntity.送金日番号
        if (isAlreadyInput(inDto.getLblID_ID_Sokinbi_Red())) {
            outEntity5.setID_Sokinbi(inDto.getLblID_ID_Sokinbi_Red());
        }
        // 　　　　　　・更正（赤）データの年度⇒DaibensaiReportEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity5.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　・更正（赤）データの方式資金⇒DaibensaiReportEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity5.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　・更正（赤）データの番号⇒DaibensaiReportEntity.稟議番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity5.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　・更正（赤）データの枝番⇒DaibensaiReportEntity.稟議番号枝番
        outEntity5.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　・更正（赤）データの充当対象払込期日⇒DaibensaiReportEntity.充当対象払込期日
        if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho_Red())) {
            outEntity5.setDate_JutoTaisho(inDto.getLblID_Date_JutoTaisho_Red());
        }
        // 　　　　　　・更正（赤）データの代弁金払込日⇒DaibensaiReportEntity.代弁金払込日
        if (isAlreadyInput(inDto.getLblID_Date_DaibenkinHaraikomi_Red())) {
            outEntity5.setDate_DaibenkinHaraikomi(inDto.getLblID_Date_DaibenkinHaraikomi_Red());
        }
        // 　　　　　　・更正（赤）データの遅延損害金⇒DaibensaiReportEntity.遅延損害金
        if (isAlreadyInput(inDto.getLblID_M_ChienSongai_Red())) {
            outEntity5
                    .setM_ChienSongai(new BigDecimal(inDto.getLblID_M_ChienSongai_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの利息⇒DaibensaiReportEntity.利息
        if (isAlreadyInput(inDto.getLblID_M_Risoku_Red())) {
            outEntity5.setM_Risoku(new BigDecimal(inDto.getLblID_M_Risoku_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの元金⇒DaibensaiReportEntity.元金
        if (isAlreadyInput(inDto.getLblID_M_Gankin_Red())) {
            outEntity5.setM_Gankin(new BigDecimal(inDto.getLblID_M_Gankin_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの計⇒DaibensaiReportEntity.計
        if (isAlreadyInput(inDto.getLblID_M_Kei_Red())) {
            outEntity5.setM_Kei(new BigDecimal(inDto.getLblID_M_Kei_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの仮受金(一般口)からの充当額⇒DaibensaiReportEntity.仮受金（一般口からの）充当
        outEntity5.setM_KariukeIppanJuto(BigDecimal.ZERO);
        if (isAlreadyInput(inDto.getLblID_M_KariukeIppanJuto_Red())) {
            outEntity5.setM_KariukeIppanJuto(new BigDecimal(inDto.getLblID_M_KariukeIppanJuto_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの代弁金充当後残元金⇒DaibensaiReportEntity.代弁金充当後残元金
        if (isAlreadyInput(inDto.getLblID_M_ZanGanAfterDaibenJuto_Red())) {
            outEntity5.setM_ZanGanAfterDaibenJuto(new BigDecimal(inDto.getLblID_M_ZanGanAfterDaibenJuto_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの繰上償還手数料⇒DaibensaiReportEntity.繰上償還手数料
        if (isAlreadyInput(inDto.getLblID_M_KurishoCommission_Red())) {
            outEntity5.setM_KurishoCommission(new BigDecimal(inDto.getLblID_M_KurishoCommission_Red()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの送金額⇒DaibensaiReportEntity.送金額
        if (isAlreadyInput(inDto.getLblID_M_Sokin_Red())) {
            outEntity5.setM_Sokin(new BigDecimal(inDto.getLblID_M_Sokin_Red().replaceAll(",", "")));
        }
        // 　　　　　　・更正（赤）データの扱店名⇒DaibensaiReportEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity5.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　・更正（赤）データの顧客名⇒DaibensaiReportEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity5.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　代位弁済金払込・充当報告書データを追加する。
        // 　　　　（４）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.insert
        // DaibensaiReportEntity inEntity = new DaibensaiReportEntity();
        try {
            if (1 < daibensaireportdao.insert(outEntity5)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　６．報告書履歴データの追加（修正用）
        ReporthistoryEntity inEntity6 = new ReporthistoryEntity();
        // 　　　　（２）履歴番号の再取得および登録値として再設定する。
        // 　　　　　　　修正データの履歴番号⇒退避用履歴番号
        String strID_History6 = inDto.getID_ID_History();
        // 　　　　　　　修正データの報告書番号⇒退避用報告書番号
        String strID_Report6 = inDto.getID_ID_Report();
        // 履歴番号
        inEntity6.setID_History(strID_History6);
        // ステータス
        if (isAlreadyInput(inDto.getID_Status())) {
            inEntity6.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (isAlreadyInput(inDto.getID_DataCode())) {
            inEntity6.setDataCode(String.valueOf(inDto.getID_DataCode()));
        }
        // 処理種別
        if (isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity6.setType_Process(inDto.getID_Type_Process());
        }
        // 　　　　（３）追加を行うデータの確認を６回繰り返し行う。
        // 　　　　　　①単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        long hitcount6 = reporthistorydao.countByCondition(inEntity6);
        if (0 < hitcount6) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History6 = pnCommonDBComponents.getIdHistoryRh();
            // 　　　　　　　　　　報告書番号最大値報告書取得(履歴データ)(共通部品)を呼び、退避用報告書番号に設定する。
            strID_Report6 = pnCommonDBComponents.getIdReportRh();
        }
        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity6 = new ReporthistoryEntity();
        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity6.setID_History(strID_History6);
        }
        // 　　　　　　　　・退避用報告書番号⇒ReporthistoryEntity.報告書番号
        if (true == isAlreadyInput(strID_Report6)) {
            outEntity6.setID_Report(strID_Report6);
        }
        // 　　　　　　　　・修正データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity6.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity6.setTime_Report(nowTime);

        // 　　　　　　　　・１⇒ReporthistoryEntity.ステータス
        outEntity6.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_1));

        // 　　　　　　　　・９０２５７０７０⇒ReporthistoryEntity.データコード
        outEntity6.setDataCode(PNCommonConstants.DATACODE_90257070);

        // 　　　　　　　　・２０⇒ReporthistoryEntity.処理種別
        outEntity6.setType_Process(PNCommonConstants.TYPE_PROCESS_20);

        // 　　　　　　　　・０⇒ReporthistoryEntity.取消済フラグ
        outEntity6.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_0));

        // 　　　　　　　　・修正データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity6.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・修正データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization())) {
            outEntity6.setName_Organization(inDto.getLblID_Name_Organization());
        }
        // 　　　　　　　　・修正データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer())) {
            outEntity6.setName_Customer(inDto.getLblID_Name_Customer());
        }
        // 　　　　　　　　・修正データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten())) {
            outEntity6.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten());
        }
        // 　　　　　　　　・修正データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization())) {
            outEntity6.setCode_Organization(inDto.getLblID_Code_Organization());
        }
        // 　　　　　　　　・修正データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo())) {
            outEntity6.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
        }
        // 　　　　　　　　・修正データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year())) {
            outEntity6.setYear(inDto.getLblID_Year());
        }
        // 　　　　　　　　・修正データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin())) {
            outEntity6.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin());
        }
        // 　　　　　　　　・修正データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi())) {
            outEntity6.setID_Ringi(inDto.getLblID_ID_Ringi());
        }

        // 　　　　　　　　・修正データの枝番⇒ReporthistoryEntity.枝番(修正データの枝番が空白の場合、0とする。)
        outEntity6.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));

        // 　　　　　　　　・修正データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity6.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・修正データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity6.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・修正データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity6.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }
        // 　　　　　　　　・修正データの退避償還期限（非表示）⇒ReporthistoryEntity.退避償還期限年月
        if (isAlreadyInput(inDto.getID_Keep_Date_ShokanKigen())) {
            outEntity6.setKeep_Date_ShokanKigen(inDto.getID_Keep_Date_ShokanKigen());
        }
        // 　　　　　　　　・修正データの退避貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_Keep_M_KashitsukeZan())) {
            outEntity6.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_Keep_M_KashitsukeZan()));
        }
        // 　　　　　　　　・修正データの退避約定元金⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoGankin())) {
            outEntity6.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_Keep_M_YakujoGankin()));
        }
        // 　　　　　　　　・修正データの退避約定利息⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
            outEntity6.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_Keep_M_YakujoRisoku()));
        }
        // 　　　　　　　　・修正データの退避請求繰償利息⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku())) {
            outEntity6.setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriRisoku()));
        }
        // 　　　　　　　　・修正データの退避履歴番号⇒ReporthistoryEntity.退避履歴番号
        if (isAlreadyInput(inDto.getID_Keep_ID_History())) {
            outEntity6.setKeep_ID_History(inDto.getID_Keep_ID_History());
        }
        // 　　　　　　　　・修正データの退避実行済みフラグ⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        if (isAlreadyInput(inDto.getID_Keep_Flag_Kj())) {
            outEntity6.setKeep_Flag_Kj(new BigDecimal(inDto.getID_Keep_Flag_Kj()));
        }
        // 　　　　　　　　・修正データの退避請求繰償元金⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin())) {
            outEntity6.setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriGankin()));
        }
        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity6)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　７．代位弁済金払込・充当報告書の追加（修正）
        // 　　　　追加を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        DaibensaireportEntity inEntity7 = new DaibensaireportEntity();
        // 報告書番号 DTO項目 ID_Report
        inEntity7.setID_Report(strID_Report6);
        // 件数取得
        long hitcount7 = daibensaireportdao.countByCondition(inEntity7);
        if (0 < hitcount7) {
            // 　　　　（２）取得した件数＞＝１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：BA001,DB010
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　（３）代位弁済金払込・充当報告書データの登録用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        DaibensaireportEntity outEntity7 = new DaibensaireportEntity();
        // 　　　　　　・退避用報告書番号⇒DaibensaiReportEntity.報告書番号
        if (true == isAlreadyInput(strID_Report6)) {
            outEntity7.setID_Report(strID_Report6);
        }
        // 　　　　　　・修正データの報告年月日⇒DaibensaiReportEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity7.setDate_Report(inDto.getLblID_Date_Report());
        }
        // 　　　　　　・修正データの報告時分秒⇒DaibensaiReportEntity.報告時分秒
        if (isAlreadyInput(inDto.getID_Time_Report())) {
            outEntity7.setTime_Report(inDto.getID_Time_Report());
        }
        // 　　　　　　・修正データのユーザID（非表示）⇒DaibensaiReportEntity.ユーザID
        outEntity7.setUserID(pnCommonInfo.getLogonID());

        // 　　　　　　・修正データの伝送番号（非表示）⇒DaibensaiReportEntity.伝送番号
        if (isAlreadyInput(inDto.getID_ID_Denso())) {
            outEntity7.setID_Denso(inDto.getID_ID_Denso());
        }
        // 　　　　　　・９０２５７０７０⇒DaibensaiReportEntity.データコード
        outEntity7.setDataCode(PNCommonConstants.DATACODE_90257070);

        // 　　　　　　・修正データの公庫支店⇒DaibensaiReportEntity.公庫支店コード
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten())) {
            outEntity7.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten());
        }
        // 　　　　　　・修正データの扱店⇒DaibensaiReportEntity.扱店コード
        if (isAlreadyInput(inDto.getLblID_Code_Organization())) {
            outEntity7.setCode_Organization(inDto.getLblID_Code_Organization());
        }
        // 　　　　　　・修正データの店舗⇒DaibensaiReportEntity.店舗コード
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo())) {
            outEntity7.setCode_Tenpo(inDto.getLblID_Code_Tenpo());
        }
        // 　　　　　　・修正データの受託者勘定処理年月⇒DaibensaiReportEntity.受託者勘定処理年月
        if (isAlreadyInput(inDto.getLblID_Date_Jtkshori())) {
            outEntity7.setDate_Jtkshori(inDto.getLblID_Date_Jtkshori());
        }
        // 　　　　　　・修正データの送金日⇒DaibensaiReportEntity.送金日
        if (isAlreadyInput(inDto.getLblID_Date_Sokin())) {
            outEntity7.setDate_Sokin(inDto.getLblID_Date_Sokin());
        }
        // 　　　　　　・修正データの送金日番号⇒DaibensaiReportEntity.送金日番号
        if (isAlreadyInput(inDto.getLblID_ID_Sokinbi())) {
            outEntity7.setID_Sokinbi(inDto.getLblID_ID_Sokinbi());
        }
        // 　　　　　　・修正データの年度⇒DaibensaiReportEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year())) {
            outEntity7.setYear(inDto.getLblID_Year());
        }
        // 　　　　　　・修正データの方式資金⇒DaibensaiReportEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin())) {
            outEntity7.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin());
        }
        // 　　　　　　・修正データの番号⇒DaibensaiReportEntity.稟議番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi())) {
            outEntity7.setID_Ringi(inDto.getLblID_ID_Ringi());
        }

        // 　　　　　　・修正データの枝番⇒DaibensaiReportEntity.稟議番号枝番
        outEntity7.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch()));

        // 　　　　　　・修正データの充当対象払込期日⇒DaibensaiReportEntity.充当対象払込期日
        if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho())) {
            outEntity7.setDate_JutoTaisho(inDto.getLblID_Date_JutoTaisho());
        }
        // 　　　　　　・修正データの代弁金払込日⇒DaibensaiReportEntity.代弁金払込日
        if (isAlreadyInput(inDto.getLblID_Date_DaibenkinHaraikomi())) {
            outEntity7.setDate_DaibenkinHaraikomi(inDto.getLblID_Date_DaibenkinHaraikomi());
        }
        // 　　　　　　・修正データの遅延損害金⇒DaibensaiReportEntity.遅延損害金
        if (isAlreadyInput(inDto.getLblID_M_ChienSongai())) {
            outEntity7.setM_ChienSongai(new BigDecimal(inDto.getLblID_M_ChienSongai().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの利息⇒DaibensaiReportEntity.利息
        if (isAlreadyInput(inDto.getLblID_M_Risoku())) {
            outEntity7.setM_Risoku(new BigDecimal(inDto.getLblID_M_Risoku().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの元金⇒DaibensaiReportEntity.元金
        if (isAlreadyInput(inDto.getLblID_M_Gankin())) {
            outEntity7.setM_Gankin(new BigDecimal(inDto.getLblID_M_Gankin().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの計⇒DaibensaiReportEntity.計
        if (isAlreadyInput(inDto.getLblID_M_Kei())) {
            outEntity7.setM_Kei(new BigDecimal(inDto.getLblID_M_Kei().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの仮受金(一般口)からの充当額⇒DaibensaiReportEntity.仮受金（一般口からの）充当
        outEntity7.setM_KariukeIppanJuto(BigDecimal.ZERO);
        if (isAlreadyInput(inDto.getLblID_M_KariukeIppanJuto())) {
            outEntity7.setM_KariukeIppanJuto(new BigDecimal(inDto.getLblID_M_KariukeIppanJuto().replaceAll(
                    ",", "")));
        }
        // 　　　　　　・修正データの代弁金充当後残元金⇒DaibensaiReportEntity.代弁金充当後残元金
        if (isAlreadyInput(inDto.getLblID_M_ZanGanAfterDaibenJuto())) {
            outEntity7.setM_ZanGanAfterDaibenJuto(new BigDecimal(inDto.getLblID_M_ZanGanAfterDaibenJuto()
                    .replaceAll(",", "")));
        }
        // 　　　　　　・修正データの繰上償還手数料⇒DaibensaiReportEntity.繰上償還手数料
        if (isAlreadyInput(inDto.getLblID_M_KurishoCommission())) {
            outEntity7.setM_KurishoCommission(new BigDecimal(inDto.getLblID_M_KurishoCommission().replaceAll(
                    ",", "")));
        }
        // 　　　　　　・修正データの送金額⇒DaibensaiReportEntity.送金額
        if (isAlreadyInput(inDto.getLblID_M_Sokin())) {
            outEntity7.setM_Sokin(new BigDecimal(inDto.getLblID_M_Sokin().replaceAll(",", "")));
        }
        // 　　　　　　・修正データの扱店名⇒DaibensaiReportEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization())) {
            outEntity7.setName_Organization(inDto.getLblID_Name_Organization());
        }
        // 　　　　　　・修正データの顧客名⇒DaibensaiReportEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer())) {
            outEntity7.setName_Customer(inDto.getLblID_Name_Customer());
        }
        // 　　　　代位弁済金払込・充当報告書データを追加する。
        // 　　　　（４）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.insert
        // DaibensaiReportEntity inEntity = new DaibensaiReportEntity();
        try {
            if (1 < daibensaireportdao.insert(outEntity7)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
        }

        // 　　８．扱店別稟議データのレコードを更新（修正）
        // 　　　　更新を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　最新更新日時
        // 　　　　　　AringiDAO.countByCondition
        AringiEntity inEntity8 = new AringiEntity();
        // 条件を設定
        // 債権管理番号
        inEntity8.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        // 最新更新日時
        if (isAlreadyInput(inDto.getID_Data_LastUpDate())) {
            inEntity8.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        }
        long hitcount8 = aringidao.countByCondition(inEntity8);
        // 検索結果判定
        if (0 == hitcount8) {
            // 　　　　（２）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } else if (1 < hitcount8) {
            // 　　　　（３）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　扱店別稟議データを排他読込をする。
        // 　　　　（４）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　AringiDAO.findByPrimaryKeyForUpdate
        // AringiEntity inEntity = new AringiEntity();
        try {
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntity8);

            if (null == outEntity) {
                // 　　　　（５）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（６）扱店別稟議データの更新用引数を設定する。(但し、修正データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            if (false == Md000Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {
                // 　　　　　　①処理完了以外：取消（修正）以外の場合
                // 　　　　　　　　（ａ）扱店別稟議データに登録を行う償還期限⇒aRingiEntity.償還期限年月
                outEntity.setDate_ShokanKigen(inDto.getID_Date_ShokanKigen_aRingi());
                // 　　　　　　　　（ｂ）扱店別稟議データに登録を行う払込前残元金⇒aRingiEntity.貸付金残高
                if (true == isAlreadyInput(inDto.getID_M_KashitsukeZandaka_aRingi())) {
                    outEntity
                            .setM_KashitsukeZandaka(new BigDecimal(inDto.getID_M_KashitsukeZandaka_aRingi()));
                }
            }
            // 　　　　　　②現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            outEntity.setData_LastUpDate(nowDateTime);
            // 　　　　扱店別稟議データを更新をする。
            // 　　　　（７）単テーブルアクセス定義「扱店別稟議データ　更新処理(処理完了以外：取消（更正（赤））以外)」を参照し、条件を設定する。
            // 　　　　　　AringiDAO.updata
            // 債権管理番号
            outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // すでに更新されているかチェック処理を記述
            if (1 < aringidao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　９．請求データのレコードを更新（修正）　　※約定利息、約定元金の入力値が共に'0'でない（有額の場合）場合に請求データの更新
        // 修正データの利息
        BigDecimal risoku = BigDecimal.ZERO;
        if (isAlreadyInput(inDto.getLblID_M_Risoku())) {
            risoku = new BigDecimal(inDto.getLblID_M_Risoku().replaceAll(",", ""));
        }
        // 修正データの元金
        BigDecimal gankin = BigDecimal.ZERO;
        if (isAlreadyInput(inDto.getLblID_M_Gankin())) {
            gankin = new BigDecimal(inDto.getLblID_M_Gankin().replaceAll(",", ""));
        }
        if (0 != BigDecimal.ZERO.compareTo(risoku) || 0 != BigDecimal.ZERO.compareTo(gankin)) {
            // 　　　　（１）修正データの利息＜＞０ OR 修正データの元金＜＞０　の場合
            // 　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity9 = new SeikyuEntity();
            // 債権管理番号
            inEntity9.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 修正データの充当対象払込期日⇒検索条件の払込年月日
            inEntity9.setDate_Haraikomi(inDto.getLblID_Date_JutoTaisho());
            // 件数取得
            long hitcount9 = seikyudao.countByCondition(inEntity9);

            // 検索結果判定
            if (0 == hitcount9) {
                // 　　　　　　②取得した件数＝０の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            } else if (1 < hitcount9) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            // 　　　　　　請求データを排他読込をする。
            // 　　　　　　④単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
            // SeikyuEntity inEntity = new SeikyuEntity();
            try {
                SeikyuEntity outEntity = seikyudao.findByPrimaryKeyForUpdate(inEntity9);

                if (null == outEntity) {
                    // 　　　　　　⑤排他エラーの場合、業務エラーとする。
                    // 　　　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
                // 　　　　　　⑥請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                // 　　　　　　　　（ａ）修正データの債権管理番号⇒SeikyuEntity.債権管理番号
                if (isAlreadyInput(inDto.getID_ID_Credit())) {
                    outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                }
                // 　　　　　　　　（ｂ）修正データの充当対象払込期日⇒SeikyuEntity.払込年月日
                if (isAlreadyInput(inDto.getLblID_Date_JutoTaisho())) {
                    outEntity.setDate_Haraikomi(inDto.getLblID_Date_JutoTaisho());
                }
                // 　　　　　　　　（ｃ）修正データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                    outEntity.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                }
                // 　　　　　　　　（ｄ）修正データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                    outEntity.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                }
                // 　　　　　　　　（ｅ）修正データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                    outEntity.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                }
                // 　　　　　　　　（ｆ）修正データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                    outEntity.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                }
                // 　　　　　　請求データを更新をする。
                // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.updata
                // すでに更新されているかチェック処理を記述
                if (1 < seikyudao.update(outEntity)) {
                    // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                    // 　　　　　　エラーメッセージ：PM9010E
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                }
            } catch (CFWFindParameterException fpe) {
                // 検索条件値エラー
                throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
            } catch (CFWForUpdateException fue) {
                // 排他エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
            } catch (CFWDuplicateKeyException fue) {
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9990E);
            }
        }

        return outDto;
    }

    /**
     * Md005_02ServiceのupdateDataNotProcEndDelCalcel
     *
     * @param inDto Md005_02DTO
     * @return Md005_02DTO
     */
    @Override
    public Md005_02DTO updateDataNotProcEndDelCalcel(Md005_02DTO inDto) {

        Md005_02DTO outDto = new Md005_02DTO();

        // 現在の日付(業務日付)取得
        String nowDate = pnCommonDBComponents.getPNBusinessDay(1);
        // 現在の時刻取得
        String nowTime = PNCommonComponents.getSysDateTime().replaceAll(":", "");
        // 現在の日時取得
        Timestamp nowDateTime = PNDateUtils.formatTimestamp(nowDate + nowTime + "000");
        // 画面表示時に取得した報告書番号を保持
        String keepDbIdReport = inDto.getID_ID_Report();

        // 更正（赤）：処理完了以外の更新処理。
        // 　＜画面表示時に取得したﾚｺｰﾄﾞに対する取消処理＞

        // 　　１．扱店別稟議データのレコードを更新
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①""⇒更正（赤）データの報告書番号
        String iDReportRed = PNCommonConstants.LITERAL_BLANK;
        // 　　　　　　②"1"⇒更正（赤）データの取消済みフラグ（非表示）
        BigDecimal flagTorikeshizumiRed = BigDecimal.ONE;
        // 　　　　　　③退避貸付金残高（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う払込前残元金
        inDto.setID_M_KashitsukeZandaka_aRingi(inDto.getID_Keep_M_KashitsukeZan());
        // 　　　　　　④退避償還期限（非表示）⇒更正（赤）データの扱店別稟議データに登録を行う償還期限
        inDto.setID_Date_ShokanKigen_aRingi(inDto.getID_Keep_Date_ShokanKigen());
        // 　　　　　　⑤退避約定利息⇒更正（赤）データの請求データに登録を行う約定利息
        inDto.setID_M_YakujoRisoku_Seikyu(inDto.getID_Keep_M_YakujoRisoku());
        // 　　　　　　⑥退避約定元金⇒更正（赤）データの請求データに登録を行う約定元金
        inDto.setID_M_YakujoGankin_Yakujo(inDto.getID_Keep_M_YakujoGankin());
        // 　　　　　　⑦退避請求繰償利息⇒更正（赤）データの請求繰償利息
        inDto.setID_Seikyu_M_SeiKuriRisoku(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        // 　　　　　　⑧退避請求繰償元金⇒更正（赤）データの請求繰償元金
        inDto.setID_Seikyu_M_SeiKuriGankin(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        // 　　　　　　⑨現在の日付⇒更正（赤）データの報告年月日
        inDto.setLblID_Date_Report(nowDate);
        // 　　　　　　⑩現在の時刻⇒更正（赤）データの報告時分秒（非表示）
        inDto.setID_Time_Report(nowTime);
        // 　　　　更新を行うデータの確認
        // 　　　　（１）単テーブルアクセス定義「扱店別稟議データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　最新更新日時
        // 　　　　　　AringiDAO.countByCondition
        AringiEntity inEntity = new AringiEntity();
        // 条件を設定
        // 債権管理番号
        inEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        // 最新更新日時
        if (isAlreadyInput(inDto.getID_Data_LastUpDate())) {
            inEntity.setData_LastUpDate(cnvTimeStamp(inDto.getID_Data_LastUpDate()));
        }
        // 件数取得
        long hitcount = aringidao.countByCondition(inEntity);

        if (0 == hitcount) {
            // 　　　　（２）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        } else if (1 < hitcount) {
            // 　　　　（３）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E);
        }
        // 　　　　扱店別稟議データを排他読込をする。
        // 　　　　（４）単テーブルアクセス定義「扱店別稟議データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　AringiDAO.findByPrimaryKeyForUpdate
        // AringiEntity inEntity = new AringiEntity();
        try {
            AringiEntity outEntity = aringidao.findByPrimaryKeyForUpdate(inEntity);

            if (null == outEntity) {
                // 　　　　（５）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（６）扱店別稟議データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
            if (false == Md000Constants.PROCESS_MODE_5.equals(inDto.getProcessMode())) {
                // 　　　　　　①処理完了以外：取消（更正（赤））以外の場合
                // 　　　　　　　　（ａ）扱店別稟議データに登録を行う償還期限⇒aRingiEntity.償還期限年月
                outEntity.setDate_ShokanKigen(inDto.getID_Date_ShokanKigen_aRingi());
                // 　　　　　　　　（ｂ）扱店別稟議データに登録を行う払込前残元金⇒aRingiEntity.貸付金残高
                if (true == isAlreadyInput(inDto.getID_M_KashitsukeZandaka_aRingi())) {
                    outEntity
                            .setM_KashitsukeZandaka(new BigDecimal(inDto.getID_M_KashitsukeZandaka_aRingi()));
                }
            }
            // 　　　　　　②現在日時を"YYYY/MM/DD hh:mm:ss"に変換⇒aRingiEntity.最新更新日時
            outEntity.setData_LastUpDate(nowDateTime);
            // 　　　　扱店別稟議データを更新をする。
            // 　　　　（７）単テーブルアクセス定義「扱店別稟議データ　更新処理(処理完了以外：取消（更正（赤））)」を参照し、条件を設定する。
            // 　　　　　　AringiDAO.updata
            // 債権管理番号
            outEntity.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // すでに更新されているかチェック処理を記述
            if (1 < aringidao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　２．請求データのレコードを更新　　※画面表示の対象となった債権管理番号を持つﾚｺｰﾄﾞの約定元金、約定利息をデータ取得時の値で更新
        boolean inputKeepMYakujoRisoku = isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku());
        boolean inputKeepMYakujoGankin = isAlreadyInput(inDto.getID_Keep_M_YakujoGankin());
        boolean inputSeikyuMSeiKuriRisoku = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku());
        boolean inputSeikyuMSeiKuriGankin = isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin());
        if (inputKeepMYakujoRisoku && inputKeepMYakujoGankin && inputSeikyuMSeiKuriRisoku
                && inputSeikyuMSeiKuriGankin) {
            // 　　　　（１）更生（赤）データの退避約定利息＜＞NULL AND 更正（赤）データの退避約定元金＜＞NULL AND
            // 　　　　　　　更正（赤）データの退避請求繰償利息＜＞NULL AND　更正（赤）データの退避請求繰償元金＜＞NULL の場合

            // 　　　　　　　更新を行うデータの確認
            // 　　　　　　①単テーブルアクセス定義「請求データ　件数取得」を参照し、条件を設定する。
            // 　　　　　　　　SeikyuDAO.countByCondition
            SeikyuEntity inEntity2 = new SeikyuEntity();
            SeikyuEntity outEntity2 = null;
            // 債権管理番号
            inEntity2.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
            // 払込年月日
            inEntity2.setDate_Haraikomi(inDto.getID_Date_JutoTaisho());
            // 件数取得
            long hitcount2 = seikyudao.countByCondition(inEntity2);

            // 検索結果判定
            if (0 == hitcount2) {
                // 　　　　　　②取得した件数＝０の場合、業務エラーとする。
                // 　　　　　　　　エラーメッセージ：PM9010E
                // 　　　　　　②取得した件数＝０の場合
                // 　　　　　　　　(ｱ)請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                try {
                    outEntity2 = new SeikyuEntity();
                    // 　　　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity2.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity2.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                        outEntity2.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                    }
                    // 　　　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                        outEntity2.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                    }
                    // 　　　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                        outEntity2.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                    }
                    // 　　　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                        outEntity2.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                    }
                    if (1 < seikyudao.insert(outEntity2)) {
                        // 　　　　　取得した件数＞１の場合、業務エラーとする。
                        // 　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
            if (1 < hitcount2) {
                // 　　　　　　③取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
            if (1 == hitcount2) {
                // 　　　　　　④取得した件数＝１の場合
                // 　　　　　　請求データを排他読込をする。
                // 　　　　　　④単テーブルアクセス定義「請求データ　排他読込」を参照し、条件を設定する。
                // 　　　　　　　　SeikyuDAO.findByPrimaryKeyForUpdate
                // SeikyuEntity inEntity = new SeikyuEntity();
                try {
                    outEntity2 = seikyudao.findByPrimaryKeyForUpdate(inEntity2);

                    if (null == outEntity2) {
                        // 　　　　　　⑤排他エラーの場合、業務エラーとする。
                        // 　　　　　　　　エラーメッセージ：PM9010E
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                    // 　　　　　　⑥請求データの更新用引数を設定する。（但し、更新用項目が空白の場合、Entity項目には"NULL"を設定する）
                    // 　　　　　　　　（ａ）更正（赤）データの債権管理番号⇒SeikyuEntity.債権管理番号
                    if (isAlreadyInput(inDto.getID_ID_Credit())) {
                        outEntity2.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
                    }
                    // 　　　　　　　　（ｂ）更正（赤）データの充当対象払込期日⇒SeikyuEntity.払込年月日
                    if (isAlreadyInput(inDto.getTxtID_Date_JutoTaisho_Red())) {
                        outEntity2.setDate_Haraikomi(inDto.getTxtID_Date_JutoTaisho_Red());
                    }
                    // 　　　　　　　　（ｃ）更正（赤）データの請求データに登録を行う約定利息⇒SeikyuEntity.約定利息
                    if (isAlreadyInput(inDto.getID_M_YakujoRisoku_Seikyu())) {
                        outEntity2.setM_YakujoRisoku(new BigDecimal(inDto.getID_M_YakujoRisoku_Seikyu()));
                    }
                    // 　　　　　　　　（ｄ）更正（赤）データの請求データに登録を行う約定元金⇒SeikyuEntity.約定元金
                    if (isAlreadyInput(inDto.getID_M_YakujoGankin_Yakujo())) {
                        outEntity2.setM_YakujoGankin(new BigDecimal(inDto.getID_M_YakujoGankin_Yakujo()));
                    }
                    // 　　　　　　　　（ｅ）更正（赤）データの請求データに登録を行う請求繰償利息⇒SeikyuEntity.請求繰上償還利息
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriRisoku())) {
                        outEntity2.setM_SeiKuriRisoku(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriRisoku()));
                    }
                    // 　　　　　　　　（ｆ）更正（赤）データの請求データに登録を行う請求繰償元金⇒SeikyuEntity.請求繰上償還元金
                    if (isAlreadyInput(inDto.getID_Seikyu_M_SeiKuriGankin())) {
                        outEntity2.setM_SeiKuriGankin(new BigDecimal(inDto.getID_Seikyu_M_SeiKuriGankin()));
                    }
                    // 　　　　　　請求データを更新をする。
                    // 　　　　　　⑦単テーブルアクセス定義「請求データ　更新処理」を参照し、条件を設定する。
                    // 　　　　　　　　SeikyuDAO.updata
                    // すでに更新されているかチェック処理を記述
                    if (1 < seikyudao.update(outEntity2)) {
                        throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
                    }
                } catch (CFWFindParameterException fpe) {
                    // 検索条件値エラー
                    throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
                } catch (CFWForUpdateException fue) {
                    // 排他エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
                } catch (CFWDuplicateKeyException fue) {
                    // 業務エラー
                    throw new PNServiceException(PNCommonMessageConstants.PM9990E);
                }
            }
        }

        // 　　３．報告書履歴データのレコードを更新　　※画面表示の対象となった履歴ﾃﾞｰﾀのﾚｺｰﾄﾞを更新
        // 　　　　※ 取消済みﾌﾗｸﾞ:'1'で更新
        // 　　　　（１）更正（赤）データの値は、１．で設定しているので、ここでは未実施とする
        // 　　　　更新を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        ReporthistoryEntity inEntity3 = new ReporthistoryEntity();
        // 履歴番号
        inEntity3.setID_History(inDto.getID_ID_History());
        // ステータス
        if (true == isAlreadyInput(inDto.getID_Status())) {
            inEntity3.setStatus(new BigDecimal(inDto.getID_Status()));
        }
        // データコード
        if (true == isAlreadyInput(inDto.getID_DataCode())) {
            inEntity3.setDataCode(inDto.getID_DataCode());
        }
        // 処理種別
        if (true == isAlreadyInput(inDto.getID_Type_Process())) {
            inEntity3.setType_Process(inDto.getID_Type_Process());
        }
        // 件数取得
        long hitcount3 = reporthistorydao.countByCondition(inEntity3);

        // 検索結果判定
        if (0 == hitcount3) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount3) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity3);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①更正（赤）データの報告書番号⇒ReporthistoryEntity.報告書番号
            outEntity.setID_Report(iDReportRed);
            // 　　　　　　②更正（赤）データの取消済みフラグ（非表示）⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(flagTorikeshizumiRed);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（８）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　４．代位弁済金払込・充当報告書の該当レコードの削除　　※更正（赤）の報告書を削除
        DaibensaireportEntity inEntity4 = new DaibensaireportEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①報告書番号⇒更正（赤）データの報告書番号　　　　　（画面表示に取得した際の報告書番号で再設定）
        inEntity4.setID_Report(keepDbIdReport);
        // 　　　　削除を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.countByCondition
        long hitcount4 = daibensaireportdao.countByCondition(inEntity4);

        if (0 == hitcount4) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount4) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　代位弁済金払込・充当報告書データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　DaibensaiReportDAO.findByPrimaryKeyForUpdate
        try {
            DaibensaireportEntity outEntity = daibensaireportdao.findByPrimaryKeyForUpdate(inEntity4);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　代位弁済金払込・充当報告書データを削除する。
            // 　　　　（７）単テーブルアクセス定義「代位弁済金払込・充当報告書データ　削除処理」を参照し、条件を設定する。
            // 　　　　　　DaibensaiReportDAO.delete
            // すでに更新されているかチェック処理を記述
            if (1 < daibensaireportdao.delete(inEntity4)) {
                // 　　　　取得した件数＞１の場合、業務エラーとする。
                // 　　　　　エラーメッセージ：PM9010E
                // 業務エラー
                throw new PNServiceException(PNCommonMessageConstants.PM9010E);
            }
        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], fue);
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        }

        // 　　更正（赤）データの復活処理　　※履歴データの復活処理

        // 　　５．報告書履歴データのレコードを更新
        ReporthistoryEntity inEntity5 = new ReporthistoryEntity();
        // 　　　　（１）更正（赤）データの値を設定しなおす。
        // 　　　　　　①退避履歴番号⇒更正（赤）データの履歴番号（非表示）
        inDto.setID_ID_History(inDto.getID_Keep_ID_History());
        // 　　　　更新を行うデータの確認
        // 　　　　（２）単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　但し、以下の項目は値が設定されている場合のみ検索条件に設定
        // 　　　　　　　　ステータス、処理種別、データコード
        // 　　　　　　ReporthistoryDAO.countByCondition
        // 履歴番号
        inEntity5.setID_History(inDto.getID_ID_History());

        // 件数取得
        long hitcount5 = reporthistorydao.countByCondition(inEntity5);

        if (0 == hitcount5) {
            // 　　　　（３）取得した件数＝０の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } else if (1 < hitcount5) {
            // 　　　　（４）取得した件数＞１の場合、業務エラーとする。
            // 　　　　　　エラーメッセージ：PM9010E
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        }
        // 　　　　報告書履歴データを排他読込をする。
        // 　　　　（５）単テーブルアクセス定義「報告書履歴データ　排他読込」を参照し、条件を設定する。
        // 　　　　　　ReporthistoryDAO.findByPrimaryKeyForUpdate
        try {
            ReporthistoryEntity outEntity = reporthistorydao.findByPrimaryKeyForUpdate(inEntity5);

            if (null == outEntity) {
                // 　　　　（６）排他エラーの場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
            // 　　　　（７）報告書履歴データの更新用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する)
            // 　　　　　　①0⇒ReporthistoryEntity.取消済フラグ
            outEntity.setFlag_Torikeshizumi(BigDecimal.ZERO);
            // 　　　　報告書履歴データを更新をする。
            // 　　　　（８）単テーブルアクセス定義「報告書履歴データ　更新処理」を参照し、条件を設定する。
            // 　　　　　　ReporthistoryDAO.updata
            // すでに更新されているかチェック処理を記述
            if (1 < reporthistorydao.update(outEntity)) {
                // 　　　　　更新処理で取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWFindParameterException fpe) {
            // 検索条件値エラー
            throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);

        } catch (CFWForUpdateException fue) {
            // 排他エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
        } catch (CFWDuplicateKeyException fue) {
            // 業務エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9990E);
        }

        // 　　６．報告書履歴データの追加（取消用）

        // 　　更正（赤）データの初期値を設定する。

        // 　　　　（１）更正（赤）データの値を設定しなおす。
        ReporthistoryEntity inEntity6 = new ReporthistoryEntity();

        // 　　　　（２）履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、履歴番号に設定する。
        String strID_History = pnCommonDBComponents.getIdHistoryRh();

        // 　　　　　　　報告書番号最大値取得(報告書履歴データ)(共通部品)を呼び、番号報告書に設定する。
        String strID_Report = pnCommonDBComponents.getIdReportRh();

        // 履歴番号
        inEntity6.setID_History(strID_History);
        // 　　　　・２⇒ステータス
        inEntity6.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_2));
        // 　　　　・９０２５７０７１⇒データコード
        inEntity6.setDataCode(PNCommonConstants.DATACODE_90257071);
        // 　　　　・１０⇒処理種別
        inEntity6.setType_Process(PNCommonConstants.TYPE_PROCESS_10);

        // 　　　　（３）取得した件数＝０の場合、データの追加処理を行う。
        // 　　　　　　①単テーブルアクセス定義「報告書履歴データ　件数取得」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.countByCondition
        long hitcount6 = reporthistorydao.countByCondition(inEntity6);
        if (0 < hitcount6) {
            // 　　　　　　②取得した件数＞０の場合
            // 　　　　　　　　（ａ）履歴番号の再取得および登録値として再設定する。
            // 　　　　　　　　　　履歴番号最大値取得(報告書履歴データ)(共通部品)を呼び、退避用履歴番号に設定する。
            strID_History = pnCommonDBComponents.getIdHistoryRh();
        }

        // 　　　　（４）データの追加処理を行う。
        // 　　　　　　①報告書履歴データの登録用引数を設定する。(但し、更正（赤）データの項目が空白の場合、Entity項目には”NULL”を設定する。)
        ReporthistoryEntity outEntity6 = new ReporthistoryEntity();

        // 　　　　　　　　・退避用履歴番号⇒ReporthistoryEntity.履歴番号
        if (true == isAlreadyInput(strID_History)) {
            outEntity6.setID_History(strID_History);
        }

        // 　　　　　　　　・""⇒ReporthistoryEntity.報告書番号
        outEntity6.setID_Report(PNCommonConstants.LITERAL_BLANK);

        // 　　　　　　　　・更正（赤）データの報告年月日⇒ReporthistoryEntity.報告年月日
        if (isAlreadyInput(inDto.getLblID_Date_Report())) {
            outEntity6.setDate_Report(inDto.getLblID_Date_Report());
        }

        // 　　　　　　　　・現在の時刻⇒ReporthistoryEntity.報告時分秒
        outEntity6.setTime_Report(nowTime);

        // 　　　　　　　　・２⇒ReporthistoryEntity.ステータス
        outEntity6.setStatus(new BigDecimal(PNCommonConstants.STATUS_VALUE_2));

        // 　　　　　　　　・９０２５７０７１⇒ReporthistoryEntity.データコード
        outEntity6.setDataCode(PNCommonConstants.DATACODE_90257071);

        // 　　　　　　　　・１０⇒ReporthistoryEntity.処理種別
        outEntity6.setType_Process(PNCommonConstants.TYPE_PROCESS_10);

        // 　　　　　　　　・１⇒ReporthistoryEntity.取消済フラグ
        outEntity6.setFlag_Torikeshizumi(new BigDecimal(PNCommonConstants.FLAG_TORIKESHIZUMI_1));

        // 　　　　　　　　・更正（赤）データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        if (isAlreadyInput(inDto.getID_User_ID())) {
            outEntity6.setUserID(inDto.getID_User_ID());
        }
        // 　　　　　　　　・更正（赤）データのユーザID（非表示）⇒ReporthistoryEntity.ユーザID
        PNCommonInfo pnCommonInfo = PNCommonInfoHolder.getCommonInfo();
        outEntity6.setUserID(pnCommonInfo.getLogonID());
        // 　　　　　　　　・更正（赤）データの扱店名⇒ReporthistoryEntity.扱店名
        if (isAlreadyInput(inDto.getLblID_Name_Organization_Red())) {
            outEntity6.setName_Organization(inDto.getLblID_Name_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの顧客名⇒ReporthistoryEntity.顧客名
        if (isAlreadyInput(inDto.getLblID_Name_Customer_Red())) {
            outEntity6.setName_Customer(inDto.getLblID_Name_Customer_Red());
        }
        // 　　　　　　　　・更正（赤）データの公庫支店⇒ReporthistoryEntity.公庫支店
        if (isAlreadyInput(inDto.getLblID_Code_KoukoShiten_Red())) {
            outEntity6.setCode_KoukoShiten(inDto.getLblID_Code_KoukoShiten_Red());
        }
        // 　　　　　　　　・更正（赤）データの扱店⇒ReporthistoryEntity.扱店
        if (isAlreadyInput(inDto.getLblID_Code_Organization_Red())) {
            outEntity6.setCode_Organization(inDto.getLblID_Code_Organization_Red());
        }
        // 　　　　　　　　・更正（赤）データの店舗⇒ReporthistoryEntity.店舗
        if (isAlreadyInput(inDto.getLblID_Code_Tenpo_Red())) {
            outEntity6.setCode_Tenpo(inDto.getLblID_Code_Tenpo_Red());
        }
        // 　　　　　　　　・更正（赤）データの年度⇒ReporthistoryEntity.年度
        if (isAlreadyInput(inDto.getLblID_Year_Red())) {
            outEntity6.setYear(inDto.getLblID_Year_Red());
        }
        // 　　　　　　　　・更正（赤）データの方式資金⇒ReporthistoryEntity.方式資金
        if (isAlreadyInput(inDto.getLblID_Kubun_HoshikiShikin_Red())) {
            outEntity6.setCode_HoshikiShikin(inDto.getLblID_Kubun_HoshikiShikin_Red());
        }
        // 　　　　　　　　・更正（赤）データの番号⇒ReporthistoryEntity.番号
        if (isAlreadyInput(inDto.getLblID_ID_Ringi_Red())) {
            outEntity6.setID_Ringi(inDto.getLblID_ID_Ringi_Red());
        }

        // 　　　　　　　　・更正（赤）データの枝番⇒ReporthistoryEntity.枝番(更正（赤）データの枝番が空白の場合、0とする。)
        outEntity6.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getLblID_ID_RingiBranch_Red()));

        // 　　　　　　　　・更正（赤）データのエラー番号（非表示）⇒ReporthistoryEntity.エラーコード
        if (isAlreadyInput(inDto.getID_Code_Error())) {
            outEntity6.setCode_Error(inDto.getID_Code_Error());
        }
        // 　　　　　　　　・更正（赤）データのエラーメッセージ（非表示）⇒ReporthistoryEntity.エラーメッセージ
        if (isAlreadyInput(inDto.getLblMessage())) {
            outEntity6.setErrorMessage(inDto.getLblMessage());
        }
        // 　　　　　　　　・更正（赤）データの債権管理番号⇒ReporthistoryEntity.債権管理番号
        if (isAlreadyInput(inDto.getID_ID_Credit())) {
            outEntity6.setID_Credit(new BigDecimal(inDto.getID_ID_Credit()));
        }

        // 　　　　　　　　・NULL⇒ReporthistoryEntity.退避償還期限年月
        outEntity6.setKeep_Date_ShokanKigen(null);

        // 　　　　　　　　・更正（赤）データの退避貸付金残高（非表示）⇒ReporthistoryEntity.退避貸付金残高
        if (isAlreadyInput(inDto.getID_Keep_M_KashitsukeZan())) {
            outEntity6.setKeep_M_KashitsukeZan(new BigDecimal(inDto.getID_Keep_M_KashitsukeZan()));
        }
        // 　　　　　　　　・更正（赤）データの退避約定元金⇒ReporthistoryEntity.退避約定元金
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoGankin())) {
            outEntity6.setKeep_M_YakujoGankin(new BigDecimal(inDto.getID_Keep_M_YakujoGankin()));
        }
        // 　　　　　　　　・更正（赤）データの退避約定利息⇒ReporthistoryEntity.退避約定利息
        if (isAlreadyInput(inDto.getID_Keep_M_YakujoRisoku())) {
            outEntity6.setKeep_M_YakujoRisoku(new BigDecimal(inDto.getID_Keep_M_YakujoRisoku()));
        }
        // 　　　　　　　　・更正（赤）データの退避請求繰償利息⇒ReporthistoryEntity.請求データの退避請求繰上償還利息
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriRisoku())) {
            outEntity6.setKeep_Seikyu_M_SeiKuriRisoku(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriRisoku()));
        }

        // 　　　　　　　　・NULL⇒ReporthistoryEntity.退避履歴番号
        outEntity6.setKeep_ID_History(null);

        // 　　　　　　　　・NULL⇒ReporthistoryEntity.退避貸付実行報告書作成済みフラグ
        outEntity6.setKeep_Flag_Kj(null);

        // 　　　　　　　　・更正（赤）データの退避請求繰償元金⇒ReporthistoryEntity.請求データの退避請求繰上償還元金
        if (isAlreadyInput(inDto.getID_Keep_Seikyu_M_SeiKuriGankin())) {
            outEntity6.setKeep_Seikyu_M_SeiKuriGankin(new BigDecimal(inDto
                    .getID_Keep_Seikyu_M_SeiKuriGankin()));
        }
        // 　　　　　　報告書履歴データを追加する。
        // 　　　　　　②単テーブルアクセス定義「報告書履歴データ　登録処理」を参照し、条件を設定する。
        // 　　　　　　　　ReporthistoryDAO.insert
        // ReporthistoryEntity inEntity = new ReporthistoryEntity();
        try {
            if (1 < reporthistorydao.insert(outEntity6)) {
                // 　　　　（５）取得した件数＞１の場合、業務エラーとする。
                // 　　　　　　エラーメッセージ：PM9010E
                throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0]);
            }
        } catch (CFWDuplicateKeyException dke) {
            // 主キー更新時の一意性制約エラー
            throw new PNServiceException(PNCommonMessageConstants.PM9010E, new String[0], dke);
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
            ret = new Timestamp(new SimpleDateFormat(Md005Constants.STR_DATE_LAST_UPDATE_FORMAT).parse(
                    strDateTime).getTime());
        } catch (ParseException e) {
            ret = null;
        }

        return ret;
    }

    /**
     *
     * <pre>
     * 入力済みかどうか判定する
     * </pre>
     *
     * @param strVal 判定対象文字列
     * @return false:nullまたは空白 true:null以外かつ空白以外
     */
    private boolean isAlreadyInput(String strVal) {
        // 戻り値初期化
        boolean ret = true;

        // 引数のチェック
        if (null == strVal) {
            // 引数がnullの場合、戻り値にfalseを設定
            ret = false;
        } else {
            if (0 == strVal.trim().length()) {
                // 引数が未入力の場合、戻り値にfalseを設定
                ret = false;
            }
        }
        // 戻り値返却
        return ret;
    }

    /**
     * <pre>
     * 引数の文字がnull値の場合、0を返します。
     * </pre>
     *
     * @param param 変換対象文字列
     * @param addCommaFlg カンマ編集フラグ True：カンマ編集あり
     * @return 文字列
     */
    private String cnvNulltoZero(String param, boolean addCommaFlg) {

        if (null == param) {
            return "0";
        }
        String result = param;
        if (addCommaFlg) {
            result = addComma(new BigDecimal(param));
        }
        return result;
    }

    /**
     * <pre>
     * カンマ編集を行います。
     * </pre>
     */
    private String addComma(BigDecimal param) {
        if (null == param || BigDecimal.ZERO.equals(param)) {
            return "0";
        }
        String result = formatter.format(param);
        return result;
    }

}