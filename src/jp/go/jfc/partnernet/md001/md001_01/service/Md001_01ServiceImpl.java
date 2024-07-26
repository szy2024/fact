//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.AcustomerDAO;
import jp.go.jfc.partnernet.common.dao.AcustomerEntity;
import jp.go.jfc.partnernet.common.dao.TenpoDAO;
import jp.go.jfc.partnernet.common.dao.TenpoEntity;
import jp.go.jfc.partnernet.md001.common.Md001Constants;
import jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataDAO;
import jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01KinriHenkanDataEntity;
import jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataDAO;
import jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataEntity;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはMd001_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md001_01ServiceImpl extends PNBaseService implements Md001_01Service {

    /** md001_01resultsdatadao */
    @Autowired
    private Md001_01ResultsDataDAO md001_01resultsdatadao;

    /** md001_01kinrihenkandatadao */
    @Autowired
    private Md001_01KinriHenkanDataDAO md001_01kinrihenkandatadao;

    /** acustomerdao */
    @Autowired
    private AcustomerDAO acustomerdao;

    /** tenpodao */
    @Autowired
    private TenpoDAO tenpodao;

    /** pnCommonDBComponents */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    DecimalFormat formatter = new DecimalFormat("#,###");

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Md001_01ServiceのgetResultsData
     *
     * @param inDto Md001_01DTO
     * @return Md001_01DTO
     */
    @Override
    public Md001_01DTO getResultsData(Md001_01DTO inDto) {

        Md001_01DTO outDto = new Md001_01DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 受渡情報の取得
        Md001_01ResultsDataEntity inEntity = new Md001_01ResultsDataEntity();
        CFWBeanUtils.copyProperties(inEntity, inDto);

        // 一覧画面データの取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Md001_01ResultsDataDAO」を参照し、条件を設定する。
        // 扱店　＝　ログインユーザの扱店コード
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());
        // 報告書番号　＝　指定された報告書番号　ID_Report
        inEntity.setID_Report(inDto.getID_Report());
        List<Md001_01ResultsDataEntity> outEntityList = md001_01resultsdatadao.findByCondition(inEntity);
        long count = md001_01resultsdatadao.countByCondition(inEntity);
        // 検索結果判定
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

        // 業務日付取得
        String dateNow = pnCommonDBComponents.getPNBusinessDay(1);

        // Entity⇒DTOに転記
        // Entity.報告年月日⇒DTO.報告年月日(※業務日付に変更)
        outDto.setTxtID_Date_Report(dateNow);
        // Entity.報告書番号⇒DTO.報告書番号
        outDto.setID_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Report()));
        // 更正(黒)用画面情報設定
        // 　更正(黒)用画面情報の場合
        // 　　Entity.顧客名⇒DTO.顧客名(修正)
        outDto.setTxtID_Name_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        // 　　Entity.扱店名⇒DTO.扱店名(修正)
        outDto.setTxtID_Name_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        // 　　Entity.公庫支店⇒DTO.公庫支店(修正)
        outDto.setTxtID_Code_KoukoShiten(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        // 　　Entity.扱店２⇒DTO.扱店(修正)
        outDto.setTxtID_Code_Organization(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        // 　　Entity.店舗⇒DTO.店舗(修正)
        outDto.setTxtID_Code_Tenpo(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Code_Tenpo()));
        // 　　和暦に変換して設定する（表示項目のためJSPにて和暦変換表示）
        // 　　　Entity.年度⇒DTO.年度(修正)
        outDto.setTxtID_Year(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        // 　　Entity.方式資金⇒DTO.方式資金(修正)
        outDto.setTxtID_Code_HoshikiShikin(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        // 　　Entity.番号⇒DTO.番号(修正)
        outDto.setTxtID_ID_Ringi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        // 　　Entity.枝番が0の場合、空白⇒DTO.枝番(修正)
        // 　　　上記以外の場合、Entity.枝番⇒DTO.枝番(修正)
        String ringiBranch = "";
        if (false == Md001Constants.STR_ZERO.equals(outEntityList.get(0).getID_ID_RingiBranch())) {
            ringiBranch = outEntityList.get(0).getID_ID_RingiBranch();
        }
        outDto.setTxtID_ID_RingiBranch(ringiBranch);
        // 　　Entity.資金使途⇒DTO.資金使途(修正)
        outDto.setTxtID_Code_ShikinShito(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_ShikinShito()));
        // 　　Entity.事業別⇒DTO.事業別(修正)
        outDto.setTxtID_Code_Jigyobetsu(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Jigyobetsu()));
        // 　　１０００で割った値を設定する
        // 　　　Entity.利率(%)⇒DTO.利率(％)
        outDto.setTxtID_Riritsu(mathPercent(outEntityList.get(0).getID_Riritsu()));
        // 　　Entity.特利区分⇒DTO.特利区分(修正)
        outDto.setTxtID_Kubun_Tokuri(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Kubun_Tokuri()));
        // 　　１０００で割った値を設定する
        // 　　　Entity.特利(%)⇒DTO.特利(％)(修正)
        outDto.setTxtID_Tokuri(mathPercent(outEntityList.get(0).getID_Tokuri()));
        // 　　和暦に変換して設定する
        // 　　　Entity.据置期限⇒DTO.据置期限(修正)（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_SueokiKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_SueokiKigen()));
        // 　　　Entity.償還期限⇒DTO.償還期限(修正)（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_ShokanKigen()));
        // MM.DDに編集して設定する
        // 　　　Entity.元利金払込日⇒DTO.元利金払込日(修正)
        String sbDateGanrikinHaraiKomi = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_GanrikinHaraikomi());
        String haraikomiTsuki = "";
        String haraikomiBi = "";
        String dateGanrikinHaraiKomi = "";
        if (Md001Constants.LENGTH_4 == sbDateGanrikinHaraiKomi.length()) {
            haraikomiTsuki = String.valueOf(Integer.parseInt(sbDateGanrikinHaraiKomi.substring(0, 2)));
            haraikomiBi = String.valueOf(Integer.parseInt(sbDateGanrikinHaraiKomi.substring(2)));
            dateGanrikinHaraiKomi = PNCommonComponents.concatString(haraikomiTsuki, ".", haraikomiBi);
        }
        outDto.setTxtID_Date_GanrikinHaraikomi(dateGanrikinHaraiKomi);
        // 　　和暦に変換して設定する
        // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(修正)（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_Jtkshori(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Jtkshori()));
// [ADD] Ver 2.0.0 - START
        // 　　　初期元号⇒DTO.貸付実行日(元号) (修正)
        outDto.setID_Date_Kashitsukejikko_Gengo(PNCommonComponents.getInitgengo());
        // 　　　空文字⇒DTO.貸付実行日(年) (修正)
        outDto.setID_Date_Kashitsukejikko_Nen("");
        // 　　　空文字⇒DTO.貸付実行日(月) (修正)
        outDto.setDrpID_Date_KashitsukejikkoTsuki("");
        // 　　　空文字⇒DTO.貸付実行日(日) (修正)
        outDto.setDrpID_Date_KashitsukejikkoBi("");
// [ADD] Ver 2.0.0 - END
        // 　　年、月、日に分割して和暦に変換して設定する
        StringBuffer sbDateKashitsukejikko = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList
                .get(0).getID_Date_Kashitsukejikko()));
        if (Md001Constants.LENGTH_8 == sbDateKashitsukejikko.length()) {
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String warekiKashitsukejikko = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMMDD(sbDateKashitsukejikko.toString()));
            if (0 < warekiKashitsukejikko.length()) {
                String[] tmp = warekiKashitsukejikko.split("\\.");
                if (0 < tmp.length) {
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(元号) (修正)
                    outDto.setID_Date_Kashitsukejikko_Gengo(tmp[0].substring(0, 1));
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(年) (修正)
                    outDto.setID_Date_Kashitsukejikko_Nen(tmp[0].substring(1));
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(月) (修正)
                    outDto.setDrpID_Date_KashitsukejikkoTsuki(tmp[1]);
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(日) (修正)
                    outDto.setDrpID_Date_KashitsukejikkoBi(tmp[2]);
                }
            }
        }
        String kashitsuke = "0";
        String shikinKofu = "0";
        String kashitukeUkeire = "0";
        if (Md001Constants.PROCESS_MODE_2.equals(inDto.getProcessMode())
                || Md001Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {
            // 処理モード(値)が処理完了：修正(2)または処理完了以外：修正(4)の場合
            // 　　Entity.貸付実行額⇒DTO.貸付実行額(修正)
            // if (null != outEntityList.get(0).getID_M_Kashitsuke()) {
            kashitsuke = PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_Kashitsuke())
                    .toString();
            // }
            // 　　Entity.資金交付額⇒DTO.資金交付額(修正)
            // if (null != outEntityList.get(0).getID_M_ShikinKofu()) {
            shikinKofu = PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_ShikinKofu()
                    .toString());
            // }
            // 　　Entity.貸付受入金受入額⇒DTO.貸付受入金受入額(修正)
            // if (null != outEntityList.get(0).getID_M_KashitukeUkeire()) {
            kashitukeUkeire = PNCommonComponents.cnvNulltoZero(outEntityList.get(0).getID_M_KashitukeUkeire()
                    .toString());
            // }
        } else {
            if (null != outEntityList.get(0).getID_M_Kashitsuke()) {
                kashitsuke = outEntityList.get(0).getID_M_Kashitsuke().toString();
            }
            // 　　Entity.資金交付額⇒DTO.資金交付額(修正)
            if (null != outEntityList.get(0).getID_M_ShikinKofu()) {
                shikinKofu = outEntityList.get(0).getID_M_ShikinKofu().toString();
            }
            // 　　Entity.貸付受入金受入額⇒DTO.貸付受入金受入額(修正)
            if (null != outEntityList.get(0).getID_M_KashitukeUkeire()) {
                kashitukeUkeire = outEntityList.get(0).getID_M_KashitukeUkeire().toString();
            }
        }
        // 貸付実行額(修正)
        outDto.setTxtID_M_Kashitsuke(kashitsuke);
        // 資金交付額(修正)
        outDto.setTxtID_M_ShikinKofu(shikinKofu);
        // 貸付受入金受入額(修正)
        outDto.setTxtID_M_KashitukeUkeire(kashitukeUkeire);
        // 　　Entity.履歴番号（非表示）⇒DTO.履歴番号（非表示）(修正)
        outDto.setID_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
        // 　　Entity.処理種別（非表示）⇒DTO.処理種別（非表示）(修正)
        outDto.setID_Type_Process(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_Type_Process()));
        // 　　Entity.取消済みフラグ（非表示）⇒DTO.取消済みフラグ（非表示）(修正)
        outDto.setID_Flag_Torikeshizumi(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Flag_Torikeshizumi()));
        // 　　Entity.エラーコード（非表示）（非表示）⇒DTO.エラーコード（非表示）（非表示）(修正)
        outDto.setID_Code_Error(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
        // 　　Entity.債権管理番号（非表示）⇒DTO.債権管理番号（非表示）(修正)
        outDto.setID_ID_Credit(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Credit()));
        // 　　Entity.伝送番号（非表示）⇒DTO.伝送番号（非表示）(修正)
        outDto.setID_ID_Denso(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
        // 　　Entity.貸付件数（非表示）⇒DTO.貸付件数（非表示）(修正)
        outDto.setID_Count_Kashitsuke(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Count_Kashitsuke()));
        // 　　Entity.ステータス（値）（非表示）⇒DTO.ステータス（値）（非表示）(修正)
        outDto.setID_Status(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Status()));
        // 　　Entity.データコード（非表示）⇒DTO.データコード（非表示）(修正)
        outDto.setID_DataCode(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_DataCode()));
        // 　　Entity.ユーザID（非表示）⇒DTO.ユーザID（非表示）(修正)
        outDto.setID_UserID(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_UserID()));
        // 　　Entity.報告時分秒（非表示）⇒DTO.報告時分秒（非表示）(修正)
        outDto.setID_Time_Report(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Time_Report()));
        // 　　Entity.貸付実行作成済みフラグ（非表示）⇒DTO.貸付実行作成済みフラグ（非表示）(修正)
        outDto.setID_Flag_Kj(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Flag_Kj()));
        // 　　Entity.顧客コード（非表示）⇒DTO.顧客コード（非表示）(修正)
        outDto.setID_Code_Customer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Customer()));
        // 　　Entity.実行起算予定日（非表示）⇒DTO.実行起算予定日（非表示）(修正)
        outDto.setID_Date_JuriKisan(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JuriKisan()));
        // 　　Entity.決定起算年月日（非表示）⇒DTO.決定起算年月日（非表示）(修正)
        outDto.setID_Date_KetteiKisan(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_KetteiKisan()));
        // 　　Entity.退避償還期限年月（非表示）⇒DTO.退避償還期限年月（非表示）(修正)
        outDto.setID_Keep_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Keep_Date_ShokanKigen()));
        // 　　Entity.退避履歴番号(非表示)⇒DTO.退避履歴番号(非表示)(修正)
        outDto.setID_keep_ID_History(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_keep_ID_History()));
        // 　　Entity.退避実行済みフラグ（非表示）⇒DTO.退避実行済みフラグ（非表示）(修正)
        outDto.setID_Keep_Flag_Kj(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_Keep_Flag_Kj()));
        // 　　Entity.扱店別稟議データより取得した実行済みフラグ（非表示）⇒DTO.扱店別稟議データより取得した実行済みフラグ（非表示）(修正)
        outDto.setID_aRingi_Flag_Kj(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Flag_Kj()));
        // 　　Entity.扱店別稟議データより取得した償還期限年月（非表示）⇒DTO.扱店別稟議データより取得した償還期限年月（非表示）(修正)
        outDto.setID_aRingi_Date_ShokanKigen(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Date_ShokanKigen()));
        // 　　Entity.扱店別稟議データの利率（非表示）⇒DTO.扱店別稟議データの利率(修正)
        outDto.setID_aRingi_Riritsu(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Riritsu()));
        // 　　Entity.扱店別稟議データの特利⇒DTO.扱店別稟議データの特利(修正)
        outDto.setID_aRingi_Tokuri(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Tokuri()));
        // 　　Entity.最新データ更新日付（非表示）⇒DTO.最新データ更新日付（非表示）(修正)
        String dateLastUpdate = "";
        if (null != outEntityList.get(0).getID_Data_LastUpDate()
                && !"".equals(outEntityList.get(0).getID_Data_LastUpDate())) {
            dateLastUpdate = new SimpleDateFormat(Md001Constants.STR_DATE_LAST_UPDATE_FORMAT)
                    .format(Timestamp.valueOf(outEntityList.get(0).getID_Data_LastUpDate()));
        }
        outDto.setID_Data_LastUpDate(dateLastUpdate);
        outDto.setID_Data_LastUpDate_Red(dateLastUpdate);
        // 非表示の赤伝の必須入力チェックを回避させるため、値をセットする。
        if (Md001Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {
            // 処理モード(値)が処理完了以外：修正(4)の場合
            // 　　年、月、日に分割して和暦に変換して設定する
            // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月
            StringBuffer sbDateJtkshori = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList
                    .get(0).getID_Date_Jtkshori()));
            String warekiJtkshori = "";
            if (Md001Constants.LENGTH_6 != sbDateJtkshori.length()) {
                // 業務日付取得
                sbDateJtkshori = new StringBuffer(dateNow.substring(0, 6));
            }
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            warekiJtkshori = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMM(sbDateJtkshori.toString()));
            if (0 < warekiJtkshori.length()) {
                String[] tmp = warekiJtkshori.split("\\.");
                if (0 < tmp.length) {
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(元号)
                    outDto.setID_Date_Jtkshori_Gengo_Red(tmp[0].substring(0, 1));
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(年)
                    outDto.setID_Date_Jtkshori_Nen_Red(tmp[0].substring(1));
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(月)
                    outDto.setDrpID_Date_JtkshoriTsuki_Red(tmp[1]);
                }
            }
        }
// [ADD] Ver 2.0.0 - START
        else {
            // 上記以外の場合
            // 　　　初期元号⇒DTO.受託者勘定処理年月(元号)
            outDto.setID_Date_Jtkshori_Gengo_Red(PNCommonComponents.getInitgengo());
            // 　　　空文字⇒DTO.受託者勘定処理年月(年)
            outDto.setID_Date_Jtkshori_Nen_Red("");
            // 　　　空文字⇒DTO.受託者勘定処理年月(月)
            outDto.setDrpID_Date_JtkshoriTsuki_Red("");
        }
// [ADD] Ver 2.0.0 - END

        // 更正(赤)用画面情報設定
        // 　更正(赤)用画面情報の場合
        // 　　Entity.顧客名⇒DTO.顧客名
        outDto.setTxtID_Name_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Customer()));
        // 　　Entity.扱店名⇒DTO.扱店名
        outDto.setTxtID_Name_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Name_Organization()));
        // 　　Entity.公庫支店⇒DTO.公庫支店
        outDto.setTxtID_Code_KoukoShiten_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_KoukoShiten()));
        // 　　Entity.扱店２⇒DTO.扱店
        outDto.setTxtID_Code_Organization_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Organization()));
        // 　　Entity.店舗⇒DTO.店舗
        outDto.setTxtID_Code_Tenpo_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Tenpo()));
        // 　　和暦に変換して設定する（表示項目のためJSPにて和暦変換表示）
        // 　　　Entity.年度⇒DTO.年度
        outDto.setTxtID_Year_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Year()));
        // 　　Entity.方式資金⇒DTO.方式資金
        outDto.setTxtID_Code_HoshikiShikin_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_HoshikiShikin()));
        // 　　Entity.番号⇒DTO.番号
        outDto.setTxtID_ID_Ringi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Ringi()));
        // 　　Entity.枝番が0の場合、空白⇒DTO.枝番
        // 　　　上記以外の場合、Entity.枝番⇒DTO.枝番
        ringiBranch = "";
        if (false == Md001Constants.STR_ZERO.equals(outEntityList.get(0).getID_ID_RingiBranch())) {
            ringiBranch = outEntityList.get(0).getID_ID_RingiBranch();
        }
        outDto.setTxtID_ID_RingiBranch_Red(ringiBranch);
        // 　　Entity.資金使途⇒DTO.資金使途
        outDto.setTxtID_Code_ShikinShito_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_ShikinShito()));
        // 　　Entity.事業別⇒DTO.事業別
        outDto.setTxtID_Code_Jigyobetsu_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Jigyobetsu()));
        // 　　１０００で割った値を設定する
        // 　　　Entity.利率(%)⇒DTO.利率(％)
        outDto.setTxtID_Riritsu_Red(mathPercent(outEntityList.get(0).getID_Riritsu()));
        // 　　Entity.特利区分⇒DTO.特利区分
        outDto.setTxtID_Kubun_Tokuri_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Kubun_Tokuri()));
        // 　　１０００で割った値を設定する
        // 　　　Entity.特利(%)⇒DTO.特利(％)
        outDto.setTxtID_Tokuri_Red(mathPercent(outEntityList.get(0).getID_Tokuri()));
        // 　　和暦に変換して設定する
        // 　　　Entity.据置期限⇒DTO.据置期限（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_SueokiKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_SueokiKigen()));
        // 　　　Entity.償還期限⇒DTO.償還期限（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_ShokanKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_ShokanKigen()));
        // MM.DDに編集して設定する
        // 　　　Entity.元利金払込日⇒DTO.元利金払込日
        sbDateGanrikinHaraiKomi = PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_GanrikinHaraikomi());
        haraikomiTsuki = "";
        haraikomiBi = "";
        dateGanrikinHaraiKomi = "";
        if (Md001Constants.LENGTH_4 == sbDateGanrikinHaraiKomi.length()) {
            haraikomiTsuki = String.valueOf(Integer.parseInt(sbDateGanrikinHaraiKomi.substring(0, 2)));
            haraikomiBi = String.valueOf(Integer.parseInt(sbDateGanrikinHaraiKomi.substring(2)));
            dateGanrikinHaraiKomi = PNCommonComponents.concatString(haraikomiTsuki, ".", haraikomiBi);
        }
        outDto.setTxtID_Date_GanrikinHaraikomi_Red(dateGanrikinHaraiKomi);
        // 　　和暦に変換して設定する
        // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_Jtkshori_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Jtkshori()));
        // 　　　Entity.貸付実行日⇒DTO.貸付実行日（表示項目のためJSPにて和暦変換表示）
        outDto.setTxtID_Date_Kashitsukejikko_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_Kashitsukejikko()));
        // 　　Entity.貸付実行額⇒DTO.貸付実行額
        outDto.setTxtID_M_Kashitsuke_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_Kashitsuke()).toString());

        // 　　Entity.資金交付額⇒DTO.資金交付額
        outDto.setTxtID_M_ShikinKofu_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_ShikinKofu()).toString());

        // 　　Entity.貸付受入金受入額⇒DTO.貸付受入金受入額
        outDto.setTxtID_M_KashitukeUkeire_Red(PNCommonComponents.cnvNulltoZero(
                outEntityList.get(0).getID_M_KashitukeUkeire()).toString());

        // 　　Entity.履歴番号（非表示）⇒DTO.履歴番号（非表示）
        outDto.setID_ID_History_Red(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_ID_History()));
        // 　　Entity.処理種別（非表示）⇒DTO.処理種別（非表示）(修正)
        outDto.setID_Type_Process_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Type_Process()));
        // 　　Entity.取消済みフラグ（非表示）⇒DTO.取消済みフラグ（非表示）(修正)
        outDto.setID_Flag_Torikeshizumi_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Flag_Torikeshizumi()));
        // 　　Entity.エラーコード（非表示）（非表示）⇒DTO.エラーコード（非表示）（非表示）(修正)
        outDto.setID_Code_Error_Red(PNCommonComponents
                .cnvNulltoBlank(outEntityList.get(0).getID_Code_Error()));
        // 　　Entity.債権管理番号（非表示）⇒DTO.債権管理番号（非表示）(修正)
        outDto.setID_ID_Credit_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Credit()));
        // 　　Entity.伝送番号（非表示）⇒DTO.伝送番号（非表示）(修正)
        outDto.setID_ID_Denso_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ID_Denso()));
        // 　　Entity.貸付件数（非表示）⇒DTO.貸付件数（非表示）(修正)
        outDto.setID_Count_Kashitsuke_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Count_Kashitsuke()));
        // 　　Entity.ステータス（値）（非表示）⇒DTO.ステータス（値）（非表示）(修正)
        outDto.setID_Status_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Status()));
        // 　　Entity.データコード（非表示）⇒DTO.データコード（非表示）(修正)
        outDto.setID_DataCode_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_DataCode()));
        // 　　Entity.ユーザID（非表示）⇒DTO.ユーザID（非表示）(修正)
        outDto.setID_UserID_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_UserID()));
        // 　　Entity.報告時分秒（非表示）⇒DTO.報告時分秒（非表示）(修正)
        outDto.setID_Time_Report_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Time_Report()));
        // 　　Entity.貸付実行作成済みフラグ（非表示）⇒DTO.貸付実行作成済みフラグ（非表示）(修正)
        outDto.setID_Flag_Kj_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_Flag_Kj()));
        // 　　Entity.顧客コード（非表示）⇒DTO.顧客コード（非表示）(修正)
        outDto.setID_Code_Customer_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Code_Customer()));
        // 　　Entity.実行起算予定日（非表示）⇒DTO.実行起算予定日（非表示）(修正)
        outDto.setID_Date_JuriKisan_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_JuriKisan()));
        // 　　Entity.決定起算年月日（非表示）⇒DTO.決定起算年月日（非表示）(修正)
        outDto.setID_Date_KetteiKisan_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Date_KetteiKisan()));
        // 　　Entity.退避償還期限年月（非表示）⇒DTO.退避償還期限年月（非表示）(修正)
        outDto.setID_Keep_Date_ShokanKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Keep_Date_ShokanKigen()));
        // 　　Entity.退避履歴番号(非表示)⇒DTO.退避履歴番号(非表示)(修正)
        outDto.setID_keep_ID_History_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_keep_ID_History()));
        // 　　Entity.退避実行済みフラグ（非表示）⇒DTO.退避実行済みフラグ（非表示）(修正)
        outDto.setID_Keep_Flag_Kj_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_Keep_Flag_Kj()));
        // 　　Entity.扱店別稟議データより取得した実行済みフラグ（非表示）⇒DTO.扱店別稟議データより取得した実行済みフラグ（非表示）(修正)
        outDto.setID_aRingi_Flag_Kj_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Flag_Kj()));
        // 　　Entity.扱店別稟議データより取得した償還期限年月（非表示）⇒DTO.扱店別稟議データより取得した償還期限年月（非表示）(修正)
        outDto.setID_aRingi_Date_ShokanKigen_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Date_ShokanKigen()));
        // 　　Entity.扱店別稟議データの利率（非表示）⇒DTO.扱店別稟議データの利率(修正)
        outDto.setID_aRingi_Riritsu_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Riritsu()));
        // 　　Entity.扱店別稟議データの特利⇒DTO.扱店別稟議データの特利(修正)
        outDto.setID_aRingi_Tokuri_Red(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                .getID_aRingi_Tokuri()));
// [ADD] Ver 2.0.0 - START
        // 　　　初期元号⇒DTO.受託者勘定処理年月(元号)
        outDto.setID_Date_Jtkshori_Gengo(PNCommonComponents.getInitgengo());
        // 　　　空文字⇒DTO.受託者勘定処理年月(年)
        outDto.setID_Date_Jtkshori_Nen("");
        // 　　　空文字⇒DTO.受託者勘定処理年月(月)
        outDto.setDrpID_Date_JtkshoriTsuki("");
// [ADD] Ver 2.0.0 - END
        // 非表示の黒伝の必須入力チェックを回避させるため、値をセットする。
        if (Md001Constants.PROCESS_MODE_1.equals(inDto.getProcessMode())
                || Md001Constants.PROCESS_MODE_3.equals(inDto.getProcessMode())) {
            // 処理モード(値)が処理完了：取消(1)または処理完了以外：取消(3)の場合
            // 　　１０００で割った値を設定する
            // 　　　Entity.利率(%)⇒DTO.利率(％)
            outDto.setTxtID_Riritsu(mathPercent(outEntityList.get(0).getID_Riritsu()));
            // 　　年、月、日に分割して和暦に変換して設定する
            sbDateKashitsukejikko = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0)
                    .getID_Date_Kashitsukejikko()));
            if (Md001Constants.LENGTH_8 != sbDateKashitsukejikko.length()) {
                // 業務日付取得
                sbDateKashitsukejikko = new StringBuffer(dateNow);
            }
            // 和暦変換
            String warekiKashitsukejikko = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMMDD(sbDateKashitsukejikko.toString()));
            if (0 < warekiKashitsukejikko.length()) {
                String[] tmp = warekiKashitsukejikko.split("\\.");
                if (0 < tmp.length) {
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(元号) (修正)
                    outDto.setID_Date_Kashitsukejikko_Gengo(tmp[0].substring(0, 1));
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(年) (修正)
                    outDto.setID_Date_Kashitsukejikko_Nen(tmp[0].substring(1));
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(月) (修正)
                    outDto.setDrpID_Date_KashitsukejikkoTsuki(tmp[1]);
                    // 　　　Entity.貸付実行日⇒DTO.貸付実行日(日) (修正)
                    outDto.setDrpID_Date_KashitsukejikkoBi(tmp[2]);
                }
            }
            // 　　Entity.資金交付額⇒DTO.資金交付額(修正)
            shikinKofu = "0";
            if (null != outEntityList.get(0).getID_M_ShikinKofu()) {
                shikinKofu = outEntityList.get(0).getID_M_ShikinKofu().toString();
            }
            outDto.setTxtID_M_ShikinKofu(shikinKofu);
            // 処理モード(値)が処理完了以外：修正(4)の場合
            // 　　年、月、日に分割して和暦に変換して設定する
            // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月
            StringBuffer sbDateJtkshori = new StringBuffer(PNCommonComponents.cnvNulltoBlank(outEntityList
                    .get(0).getID_Date_Jtkshori()));
            if (Md001Constants.LENGTH_6 != sbDateJtkshori.length()) {
                // 業務日付取得
                sbDateJtkshori = new StringBuffer(dateNow.substring(0, 6));
            }
            // 和暦変換 (YYYYMMDD⇒Gyy.mm.dd変換) して区切り文字を除去
            String warekiJtkshori = PNCommonComponents.cnvNulltoBlank(PNCommonComponents
                    .dateFmtAD_YYYYMM(sbDateJtkshori.toString()));
            if (0 < warekiJtkshori.length()) {
                String[] tmp = warekiJtkshori.split("\\.");
                if (0 < tmp.length) {
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(元号)
                    outDto.setID_Date_Jtkshori_Gengo(tmp[0].substring(0, 1));
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(年)
                    outDto.setID_Date_Jtkshori_Nen(tmp[0].substring(1));
                    // 　　　Entity.受託者勘定処理年月⇒DTO.受託者勘定処理年月(月)
                    outDto.setDrpID_Date_JtkshoriTsuki(tmp[1]);
                }
            }
        }
        // エラーメッセージ
        outDto.setLblMessage(PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getID_ErrorMessage()));

        // 処理モード
        outDto.setProcessMode(inDto.getProcessMode());

        return outDto;
    }

    /**
     * Md001_01ServiceのgetAｃustomer
     *
     * @param inDto Md001_01DTO
     * @return Md001_01DTO
     */
    @Override
    public Md001_01DTO getAcustomer(Md001_01DTO inDto) {

        Md001_01DTO outDto = new Md001_01DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 顧客名の存在チェック
        AcustomerEntity inEntity = new AcustomerEntity();
        // 検索条件を設定
        // 単テーブルアクセス定義の「扱店別顧客データ　顧客名の存在チェック」を参照し、条件を設定する。
        inEntity.setCode_Customer(inDto.getID_Code_Customer());
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());
        long hitcount = acustomerdao.countByCondition(inEntity);

        // 　取得した件数が0件の場合、エラーとする。
        // 　　エラーメッセージ：顧客名、エラー追加情報、PTN_JKSN_015、PTN001
        if (0 == hitcount) {
            // 　　エラーメッセージ：PTN_JKSN_015、PTN001
            // メッセージを追加して継続
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E, new String[]{"存在しない顧客名です。"},
                    false));
        }

        // エラー情報をControllerに返却
        outDto.setBizErrors(bizErrors);

        return outDto;
    }

    /**
     * Md001_01ServiceのgetTenpo
     *
     * @param inDto Md001_01DTO
     * @return Md001_01DTO
     */
    @Override
    public Md001_01DTO getTenpo(Md001_01DTO inDto) {

        Md001_01DTO outDto = new Md001_01DTO();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 扱店名の存在チェック
        TenpoEntity inEntity = new TenpoEntity();
        // 検索条件を設定
        inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());
        // 単テーブルアクセス定義の「金融機関店舗データ　扱店名の存在チェック」を参照し、条件を設定する。
        // 　TenpoDAO.countByCondition
        long hitcount = tenpodao.countByCondition(inEntity);

        // 　取得した件数が0件の場合、業務エラーとする。
        if (0 == hitcount) {
            // 　　エラーメッセージ：PTN_JKSN_016、PTN001
            // メッセージを追加して継続
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3000E, new String[]{"存在しない扱店名です。"},
                    false));
        }

        // エラー情報をControllerに返却
        outDto.setBizErrors(bizErrors);

        return outDto;
    }

    /**
     * Md001_01ServiceのgetRiritsuTokuri
     *
     * <pre>
     * Cr001_01ServiceのgetRiritsuTokuriの持ち込みとなります。
     * 基本的な処理は変わらないのですが、Crが複数件選択可能に対して Mdは1件のみとなります。
     * Cr001_01ServiceのgetRiritsuTokuriのロジックが変更になった場合、こちらも変更してください。
     *
     * 修正(更生黒)のみ対応します。
     *
     * </pre>
     *
     * @param inDto Md001_01DTO
     * @return Md001_01DTO
     */
    public Md001_01DTO getRiritsuTokuri(Md001_01DTO inDto) {

        Md001_01DTO outDto = new Md001_01DTO();
        CFWBeanUtils.copyProperties(outDto, inDto);

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 実行日の利率
        int intDateJikkoRiritsu = 0;
        // 実行日の利子助成率
        int intJikkoJoseiRitsu = 0;
        // 決定起算日の利率
        int intDateKetteiKisanRiritsu = 0;
        // 決定起算日の利子助成率
        int intKetteiJoseiRitsu = 0;

        // エラーフラグ
        // boolean blnErr = false;
        int intLine = 1; // ループはないので1行目固定とする
        String strLineInfo = "";
        String errMsg = "";

        if (Md001Constants.PROCESS_MODE_2.equals(inDto.getProcessMode())) {
            strLineInfo = "(更正黒)";
        } else if (Md001Constants.PROCESS_MODE_4.equals(inDto.getProcessMode())) {
            strLineInfo = "(修正内容)";
        }

        // DBより取得した利率
        String strID_Riritsu_Org = "";
        // DBより取得した特利
        String strID_Tokuri_Org = "";

        // DB取得時の値を保持
        if (null != inDto.getTxtID_Tokuri()) {
            strID_Tokuri_Org = inDto.getTxtID_Tokuri();
        }

        // ----- 貸付期間年数の取得 -----
        // 貸付期間年数
        String srtKashitsukeKikanYears = "";
        // 報告書の貸付実行日
        String srtDate_Jikko = "";

        // 　貸付期間年数の取得を行う。　
        // 　　最終償還日の組立（償還期限年月+元利金払込年月日の日）
        String lastShokan = "";
        // Cr001とは違い償還期限は既に西暦になっている
        String[] ganrikinHaraiKomi = inDto.getTxtID_Date_GanrikinHaraikomi().split("\\.");
        if (StringUtils.isNotEmpty(inDto.getTxtID_Date_ShokanKigen())
                && inDto.getTxtID_Date_ShokanKigen().length() == 6 && 0 < ganrikinHaraiKomi.length) {

            String shokanKigenYear = inDto.getTxtID_Date_ShokanKigen().substring(0, 4);
            String shokanKigenMonth = inDto.getTxtID_Date_ShokanKigen().substring(4, 6);
            lastShokan = PNCommonComponents.concatString(shokanKigenYear,
                    String.format("%02d", Integer.parseInt(shokanKigenMonth)),
                    String.format("%02d", Integer.parseInt(ganrikinHaraiKomi[1])));
        }

        // 　　貸付実行日の組立（貸付実行日(年)＋貸付実行日(月)＋貸付実行日(日)）
        srtDate_Jikko = PNCommonComponents
                .cnvNulltoBlank(PNCommonComponents.dateFmtJC_Gyymmdd(
                        PNCommonComponents.concatString(
                                inDto.getID_Date_Kashitsukejikko_Gengo(),
                                String.format("%02d",
                                        Integer.parseInt(inDto.getID_Date_Kashitsukejikko_Nen())),
                                String.format("%02d",
                                        Integer.parseInt(inDto.getDrpID_Date_KashitsukejikkoTsuki())),
                                String.format("%02d",
                                        Integer.parseInt(inDto.getDrpID_Date_KashitsukejikkoBi()))), ""));
        // 　　貸付期間年数の取得
        int kashitsukeNensu = 0;
        if (0 < lastShokan.length() && 0 < srtDate_Jikko.length() && lastShokan.matches("^[0-9]{8}$")
                && srtDate_Jikko.matches("^[0-9]{8}$")) {
            int shokan = Integer.parseInt(lastShokan);
            int kashitsuke = Integer.parseInt(srtDate_Jikko);
            // 　　　貸付期間年数＝((最終償還日－貸付実行日)/10000)＋1)
            kashitsukeNensu = ((shokan - kashitsuke) / 10000) + 1;
            // 　　　貸付期間年数が5年以内の場合、5年換算とする。
            if (5 >= kashitsukeNensu) {
                // 　　　　貸付期間年数＝5
                kashitsukeNensu = 5;
            }
            srtKashitsukeKikanYears = String.valueOf(kashitsukeNensu);
        }
        // 　貸付期間年数がある場合のみ利率、特利の再計算を行う。
        if (false == PNCommonConstants.LITERAL_BLANK.equals(srtKashitsukeKikanYears)) {
            // try {
            String strDateJikkoRiritsu = "";
            String strDateKetteiKisanRiritsu = "";

            // 　　金利変換テーブルより金利呼称コード、金利呼称細目コードを取得する。
            LinkedHashMap<String, String> dataEntity = getKinriHenkanData(inDto);
            if (null == dataEntity) {
                // 戻り値がnullの場合(２件以上取得できた場合)
                // メッセージを追加して継続
                errMsg = PNCommonComponents.concatString("利率データ取得", strLineInfo);
                bizErrors
                        .add(new PNMessageInfo(PNCommonMessageConstants.PM3190E, new String[]{errMsg}, false));

                // この時点でエラーを返す。
                // エラー情報をControllerに返却
                outDto.setBizErrors(bizErrors);
                return outDto;
            }

            String[] itemNames = null;
            // 　　画面の利率項目に入力がない場合に利率の再計算を行い、利率を設定する。
            // 利率の低い値を保持
            String strMinRiritsuValu = "";
            if (0 == inDto.getTxtID_Riritsu().trim().length()) {
                // ----- 利率の再計算取得 -----
                // 実行日の利子助成率
                String strJikkoJoseiRitsu = "";
                // 決定起算日の利子助成率
                String strKetteiJoseiRitsu = "";

                itemNames = new String[]{"strDateJikkoRiritsu", "strJikkoJoseiRitsu",
                        "strDateKetteiKisanRiritsu", "strKetteiJoseiRitsu"};
                HashMap<String, String> ritsuMap = new HashMap<String, String>();

                // 　　　利率および利子助成率を取得する。
                // 　　　　引数：入力された貸付実行日
                // 　　　　引数：扱店別稟議データの決定起算日
                ritsuMap = getRitsuData(itemNames, dataEntity, intLine, srtDate_Jikko,
                        inDto.getID_Date_KetteiKisan(), srtKashitsukeKikanYears);

                // 　　　　取得した利率を「実行日の利率」に設定する。
                strDateJikkoRiritsu = ritsuMap.get(itemNames[0]);
                // 　　　　取得した利子助成率を「実行日の利子助成率」に設定する。
                strJikkoJoseiRitsu = ritsuMap.get(itemNames[1]);
                // 　　　　取得した利率を「決定起算日の利率」に設定する。
                strDateKetteiKisanRiritsu = ritsuMap.get(itemNames[2]);
                // 　　　　取得した利子助成率を「決定起算日の利子助成率」に設定する。
                strKetteiJoseiRitsu = ritsuMap.get(itemNames[3]);

                // 　　　画面の利率が空白の場合、0とする。
                if (0 == strID_Riritsu_Org.length()) {
                    strID_Riritsu_Org = "0";
                }

                // 　　　ワークの利率に「決定起算日の利率」を設定する。
                // 決定起算日より求めた利率を保持
                strMinRiritsuValu = strDateKetteiKisanRiritsu;
                // 　　　（実行日の利率-利子助成率）<=
                // (決定起算日の利率-利子助成率）の場合、ワークの利率に「実行日の利率」を設定する。
                if (strDateJikkoRiritsu.matches("^[0-9]*$") && strJikkoJoseiRitsu.matches("^[0-9]*$")
                        && strDateKetteiKisanRiritsu.matches("^[0-9]*$")
                        && strKetteiJoseiRitsu.matches("^[0-9]*$")) {

                    intDateJikkoRiritsu = Integer.parseInt(strDateJikkoRiritsu);
                    intJikkoJoseiRitsu = Integer.parseInt(strJikkoJoseiRitsu);
                    intDateKetteiKisanRiritsu = Integer.parseInt(strDateKetteiKisanRiritsu);
                    intKetteiJoseiRitsu = Integer.parseInt(strKetteiJoseiRitsu);

                    if ((intDateJikkoRiritsu - intJikkoJoseiRitsu) <= (intDateKetteiKisanRiritsu - intKetteiJoseiRitsu)) {
                        // 貸付実行日より求めた利率を保持
                        strMinRiritsuValu = strDateJikkoRiritsu;
                    }
                }
                // 　　　スーパーL資金の無利子対象案件か否かの判定を行う。
                if ("06".equals(dataEntity.get("Code_KinriKosho"))
                        && "54".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                    // 　　　　金利呼称コード=06、金利呼称細目コード=54の場合

                    // 実行日の利率
                    String strDateJikkoRiritsu0652 = "";
                    // 決定起算日の利率
                    String strDateKetteiKisanRiritsu0652 = "";
                    // 実行日の利子助成率
                    String strJikkoJoseiRitsu0652 = "";
                    // 決定起算日の利子助成率
                    String strKetteiJoseiRitsu0652 = "";

                    itemNames = new String[]{"strDateJikkoRiritsu0652", "strJikkoJoseiRitsu0652",
                            "strDateKetteiKisanRiritsu0652", "strKetteiJoseiRitsu0652"};
                    // 　　　　　　　金利呼称細目コードを52に設定する。
                    dataEntity.put("Code_KinriKoshoSaimoku", "52");

                    // 　　　利率および利子助成率を取得する。
                    // 　　　　引数：入力された貸付実行日
                    // 　　　　引数：扱店別稟議データの決定起算日
                    HashMap<String, String> ritsuMap0652 = new HashMap<String, String>();
                    ritsuMap0652 = getRitsuData(itemNames, dataEntity, intLine, srtDate_Jikko,
                            inDto.getID_Date_KetteiKisan(), srtKashitsukeKikanYears);

                    // 　　　　　　取得した利率を「スーパーL資金の実行日の利率」に設定する。
                    strDateJikkoRiritsu0652 = ritsuMap0652.get(itemNames[0]);
                    // 　　　　　　取得した利子助成率を「スーパーL資金の実行日の利子助成率」に設定する。
                    strJikkoJoseiRitsu0652 = ritsuMap0652.get(itemNames[1]);
                    // 　　　　　　取得した利率を「スーパーL資金の決定起算日の利率」に設定する。
                    strDateKetteiKisanRiritsu0652 = ritsuMap0652.get(itemNames[2]);
                    // 　　　　　　取得した利子助成率を「スーパーL資金の決定起算日の利子助成率」に設定する。
                    strKetteiJoseiRitsu0652 = ritsuMap0652.get(itemNames[3]);

                    // 決定起算日より求めた利率を採用する場合、金利呼称コード=06、金利呼称細目コード=54で
                    // 得た決定起算日の利率を採用
                    strMinRiritsuValu = strDateKetteiKisanRiritsu;
                    // 　　　　　（スーパーL資金の実行日の利率-スーパーL資金の利子助成率）<=
                    // (スーパーL資金の決定起算日の利率-スーパーL資金の利子助成率）の場合、
                    // 　　　　　　ワークの利率に「スーパーL資金の実行日の利率」を設定する。
                    // 　　　　　上記以外の場合、ワークの利率に「スーパーL資金の決定起算日の利率」を設定する。
                    if (strDateJikkoRiritsu0652.matches("^[0-9]*$")
                            && strJikkoJoseiRitsu0652.matches("^[0-9]*$")
                            && strDateKetteiKisanRiritsu0652.matches("^[0-9]*$")
                            && strKetteiJoseiRitsu0652.matches("^[0-9]*$")) {

                        intDateJikkoRiritsu = Integer.parseInt(strDateJikkoRiritsu0652);
                        intJikkoJoseiRitsu = Integer.parseInt(strJikkoJoseiRitsu0652);
                        intDateKetteiKisanRiritsu = Integer.parseInt(strDateKetteiKisanRiritsu0652);
                        intKetteiJoseiRitsu = Integer.parseInt(strKetteiJoseiRitsu0652);

                        if ((intDateJikkoRiritsu - intJikkoJoseiRitsu) <= (intDateKetteiKisanRiritsu - intKetteiJoseiRitsu)) {
                            // 貸付実行日より求めた利率を採用する場合、金利呼称コード=06、金利呼称細目コード=54で
                            // 得た実行日の利率を採用
                            strMinRiritsuValu = strDateJikkoRiritsu;
                        }
                    }
                }
                // 　　　省エネ案件か否かの判定を行う。
                if ("05".equals(dataEntity.get("Code_KinriKosho"))
                        && "53".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                    // 　　　　金利呼称コード=05、金利呼称細目コード=53の場合
                    // 省エネ案件の場合は、金利呼称コード=05、金利呼称細目コード=03で
                    // 実行時の利率を採用するか決定起算日の利率を採用するかを判定。

                    // 実行日の利率
                    String strDateJikkoRiritsu0503 = "";
                    // 決定起算日の利率
                    String strDateKetteiKisanRiritsu0503 = "";
                    // 実行日の利子助成率
                    String strJikkoJoseiRitsu0503 = "";
                    // 決定起算日の利子助成率
                    String strKetteiJoseiRitsu0503 = "";

                    itemNames = new String[]{"strDateJikkoRiritsu0503", "strJikkoJoseiRitsu0503",
                            "strDateKetteiKisanRiritsu0503", "strKetteiJoseiRitsu0503"};
                    // 　　　　　　　金利呼称細目コードを03に設定する。
                    dataEntity.put("Code_KinriKoshoSaimoku", "03");

                    // 　　　利率および利子助成率を取得する。
                    // 　　　　引数：入力された貸付実行日
                    // 　　　　引数：扱店別稟議データの決定起算日
                    HashMap<String, String> ritsuMap0503 = new HashMap<String, String>();
                    ritsuMap0503 = getRitsuData(itemNames, dataEntity, intLine, srtDate_Jikko,
                            inDto.getID_Date_KetteiKisan(), srtKashitsukeKikanYears);

                    // 　　　　　　取得した利率を「省エネの実行日の利率」に設定する。
                    strDateJikkoRiritsu0503 = ritsuMap0503.get(itemNames[0]);
                    // 　　　　　　取得した利子助成率を「省エネの実行日の利子助成率」に設定する。
                    strJikkoJoseiRitsu0503 = ritsuMap0503.get(itemNames[1]);
                    // 　　　　　　取得した利率を「省エネの決定起算日の利率」に設定する。
                    strDateKetteiKisanRiritsu0503 = ritsuMap0503.get(itemNames[2]);
                    // 　　　　　　取得した利子助成率を「省エネの決定起算日の利子助成率」に設定する。
                    strKetteiJoseiRitsu0503 = ritsuMap0503.get(itemNames[3]);
                    // 　　　　　ワークの利率に「省エネの決定起算日の利率」を設定する。
                    // 決定起算日より求めた利率を採用する場合、金利呼称コード=05、金利呼称細目コード=53で
                    // 得た決定起算日の利率を採用
                    strMinRiritsuValu = strDateKetteiKisanRiritsu;
                    // 　　　　　（省エネの実行日の利率-省エネの利子助成率）<=
                    // (省エネの決定起算日の利率-省エネの利子助成率）の場合、
                    // 　　　　　　ワークの利率に「省エネの実行日の利率」を設定する。
                    if (strDateJikkoRiritsu0503.matches("^[0-9]*$")
                            && strJikkoJoseiRitsu0503.matches("^[0-9]*$")
                            && strDateKetteiKisanRiritsu0503.matches("^[0-9]*$")
                            && strKetteiJoseiRitsu0503.matches("^[0-9]*$")) {

                        intDateJikkoRiritsu = Integer.parseInt(strDateJikkoRiritsu0503);
                        intJikkoJoseiRitsu = Integer.parseInt(strJikkoJoseiRitsu0503);
                        intDateKetteiKisanRiritsu = Integer.parseInt(strDateKetteiKisanRiritsu0503);
                        intKetteiJoseiRitsu = Integer.parseInt(strKetteiJoseiRitsu0503);

                        if ((intDateJikkoRiritsu - intJikkoJoseiRitsu) <= (intDateKetteiKisanRiritsu - intKetteiJoseiRitsu)) {
                            // 貸付実行日より求めた利率を採用する場合、金利呼称コード=05、金利呼称細目コード=53で
                            // 得た実行日の利率を採用
                            strMinRiritsuValu = strDateJikkoRiritsu;
                        }
                    }
                }
                // 　　　東日本大震災対応（2点間比較の対応）
                // 　　　　　取得した利率をワークの利率に設定する。
                String str2tenkanRiritsuValu = get2tenkanHikakuRiritsu(dataEntity, intLine, srtDate_Jikko,
                        inDto.getID_Date_KetteiKisan(), srtKashitsukeKikanYears);
                if (null != str2tenkanRiritsuValu && 0 < str2tenkanRiritsuValu.length()) {
                    strMinRiritsuValu = str2tenkanRiritsuValu;
                }

            } else {
                // 　　利率項目に入力がある場合は、入力値を設定する。
                String strInputRiritsu = "";
                strInputRiritsu = inDto.getTxtID_Riritsu();
                // 　　　入力値は小数点表示のまま保持されているため、1000倍した値をワークの利率に設定する。
                if (null != strInputRiritsu) {
                    BigDecimal inpRiritsu = new BigDecimal(strInputRiritsu);
                    BigDecimal riritsu = inpRiritsu.multiply(PNCommonConstants.BIGDECIMAL_1000_VALUE);
                    strInputRiritsu = riritsu.toString();
                }
                strMinRiritsuValu = strInputRiritsu;
            }

            // 　　特利の再計算取得
            String strDateJikkoTokuri = "";
            String strDateKetteiKisanTokuri = "";
            // 特利の低い値を保持
            String strMinTokuriValu = "";

            // 　　　特利区分が１または３または９または８の場合は特利を再計算する
            if (null != inDto.getTxtID_Kubun_Tokuri()) {
                if ("1".equals(inDto.getTxtID_Kubun_Tokuri()) || "3".equals(inDto.getTxtID_Kubun_Tokuri())
                        || "9".equals(inDto.getTxtID_Kubun_Tokuri())
                        || "8".equals(inDto.getTxtID_Kubun_Tokuri())) {

                    String strGetItemName = "";

                    if ("1".equals(inDto.getTxtID_Kubun_Tokuri())) {
                        // 　　　　特利区分が１の場合
                        // 　　　　　　据置中特利取得(共通部品)を呼び、特利を取得する。
                        strGetItemName = Md001Constants.ITEM_NAME_SUEOKI_CHU_TOKURI;
                    } else {
                        // 　　　　特利区分が３，９，８の場合は、実行後３年特利取得の共通部品を使用する。
                        // 　　　　　　実行後３年特利取得(共通部品)を呼び、特利を取得する。
                        strGetItemName = Md001Constants.ITEM_NAME_THREE_YEARS_TOKURI;
                    }

                    // 　　　　入力された貸付実行日を比較対象の日付として特利を取得する。
                    // 　　　　　引数：入力された貸付実行日
                    // 　　　　　特利取得(共通部品)を呼び、特利を取得する。
                    // 　　　　扱店別稟議データの決定起算日を比較対象の日付として特利を取得する。
                    // 　　　　　引数：扱店別稟議データの決定起算日
                    // 　　　　　特利取得(共通部品)を呼び、特利を取得する。
                    itemNames = new String[]{"strDateJikkoTokuri", "strDateKetteiKisanTokuri"};

                    // 　　　利率および利子助成率を取得する。
                    // 　　　　引数：入力された貸付実行日
                    // 　　　　引数：扱店別稟議データの決定起算日
                    HashMap<String, String> tokuriMap = new HashMap<String, String>();

                    tokuriMap = getTokuriData(itemNames, dataEntity, intLine, srtDate_Jikko,
                            inDto.getID_Date_KetteiKisan(), strGetItemName, srtKashitsukeKikanYears);

                    // 　　　　　取得した特利を「実行日の特利」に設定する。
                    strDateJikkoTokuri = tokuriMap.get(itemNames[0]);
                    // 　　　　　取得した特利を「決定起算日の特利」に設定する。
                    strDateKetteiKisanTokuri = tokuriMap.get(itemNames[1]);

                    // 　　　　画面の特利が空白の場合、0とする。
                    if (0 == strID_Tokuri_Org.length()) {
                        strID_Tokuri_Org = "0";
                    }
                    // 　　　　　決定起算日の特利をワークの特利に設定する。
                    // 決定起算日より求めた特利を保持
                    strMinTokuriValu = strDateKetteiKisanTokuri;
                    // 　　　　貸付実行日より求めた特利と決定起算日より求めた特利の比較を行う。
                    // 　　　　　(貸付実行日の特利＜＝決定起算日の特利)の場合、貸付実行日の特利をワークの特利に設定する。
                    if (0 < strDateJikkoTokuri.length() && 0 < strDateKetteiKisanTokuri.length()
                            && strDateJikkoTokuri.matches("^[0-9]*$")
                            && strDateKetteiKisanTokuri.matches("^[0-9]*$")) {

                        int intDateJikkoTokuri = Integer.parseInt(strDateJikkoTokuri);
                        int intDateKetteiKisanTokuri = Integer.parseInt(strDateKetteiKisanTokuri);

                        if (intDateJikkoTokuri <= intDateKetteiKisanTokuri) {
                            // 貸付実行日より求めた特利を保持
                            strMinTokuriValu = strDateJikkoTokuri;
                        }
                    }

                } else {
                    // 　　　特利区分が１または３または９または８以外の場合は、画面の特利をワークの特利に設定する。
                    if (null != strID_Tokuri_Org) {
                        BigDecimal deci1000 = new BigDecimal("1000");
                        BigDecimal tokuriOrg = new BigDecimal(strID_Tokuri_Org);
                        strID_Tokuri_Org = tokuriOrg.multiply(deci1000).toString();
                        strMinTokuriValu = strID_Tokuri_Org;
                    }
                }

            }

            // 　　再計算が成功した場合値の低い利率、特利を設定する。
            // 　　　ワークの利率を画面の利率に設定する。
            inDto.setTxtID_Riritsu(mathPercent(strMinRiritsuValu));
            // 　　　ワークの特利を画面の特利に設定する。
            inDto.setTxtID_Tokuri(mathPercent(strMinTokuriValu));
        }

        // エラー情報をControllerに返却
        outDto.setBizErrors(bizErrors);

        if (0 == bizErrors.size()) {
            // エラーでない場合は、編集結果を返却する
            CFWBeanUtils.copyProperties(outDto, inDto);
        }

        return outDto;
    }

    /**
     * <pre>
     * 1000で割った値を小数点以下第３位（小数点以下第四位以降切り捨て）までを表示。(String型に拡張)
     * </pre>
     */
    private String mathPercent(String param) {
        if (null == param || PNCommonConstants.LITERAL_BLANK.equals(param.trim())) {
            return "0.000";
        }
        BigDecimal outResultMath = new BigDecimal(param);
        outResultMath = PNCommonComponents.mathPercent1000(outResultMath);
        return outResultMath.toString();
    }

    // 以下、利率・特利計算の計算ロジック(Cr001_01ServiceImplからの持ち込み)

    /**
     *
     * <pre>
     * 金利変換テーブルより金利呼称コード、金利呼称細目コードを取得する。
     *
     * Cr001_01ServiceImplから持ち込んでいます。
     * </pre>
     *
     * @param inM1Dto Cr001_01M1DTO
     * @return 金利変換テーブルデータMAP
     */
    private LinkedHashMap<String, String> getKinriHenkanData(Md001_01DTO inM1Dto) {

        int itemCnt = 0;

        LinkedHashMap<String, String> dataEntity = new LinkedHashMap<String, String>(1);
        // 　　　複数テーブルアクセス定義「Md001_01KinriHenkanDataDAO」を参照し、条件を設定する。
        // 　　　　Md001_01KinriHenkanDataDAO.findByCondition
        Md001_01KinriHenkanDataEntity inEntity = new Md001_01KinriHenkanDataEntity();
        // 資金使途コード　＝　画面の資金使途
        inEntity.setCode_ShikinShito(inM1Dto.getTxtID_Code_ShikinShito());
        // 事業別コード　＝　画面の事業別
        inEntity.setCode_Jigyoubetsu(inM1Dto.getTxtID_Code_Jigyobetsu());
        // 受理開始年月日　＝　画面の受理起算日
        inEntity.setDate_JuriStart(inM1Dto.getID_Date_JuriKisan());
        // 貸付先コード　＝　画面の貸付先ｺｰﾄﾞ
        inEntity.setCode_Customer(inM1Dto.getID_Code_Customer());
        // Cr001_01KinriHenkanDataDAO呼び出し
        List<Md001_01KinriHenkanDataEntity> outEntityList = md001_01kinrihenkandatadao
                .findByCondition(inEntity);
        if (null == outEntityList || outEntityList.isEmpty()) {
            // データが取得できない場合
            dataEntity.put("Code_KinriKoshoSaimoku", "");
            dataEntity.put("Code_KinriKosho", "");
            dataEntity.put("Date_JuriStart", "");
            dataEntity.put("Date_JuriEnd", "");
        } else {
            // データが取得できた場合
            for (Md001_01KinriHenkanDataEntity outEntity : outEntityList) {

                if (1 < itemCnt) {
                    // ２件以上の場合、繰返し処理終了
                    break;
                }

                // ﾃﾞｰﾀが１件目のみ処理
                if (0 == itemCnt) {
                    // 金利呼称細目コード
                    if (null != outEntity.getCode_KinriKoshoSaimoku()) {
                        dataEntity.put("Code_KinriKoshoSaimoku", outEntity.getCode_KinriKoshoSaimoku());
                    }
                    // 金利呼称コード
                    if (null != outEntity.getCode_KinriKosho()) {
                        dataEntity.put("Code_KinriKosho", outEntity.getCode_KinriKosho());
                    }
                    // 適用開始年月日
                    if (null != outEntity.getDate_JuriStart()) {
                        dataEntity.put("Date_JuriStart", outEntity.getDate_JuriStart());
                    }
                    // 適用終了年月日
                    if (null != outEntity.getDate_JuriEnd()) {
                        dataEntity.put("Date_JuriEnd", outEntity.getDate_JuriEnd());
                    }
                }

                // データ件数カウント
                itemCnt++;
            }
        }

        if (1 < itemCnt) {
            // ２件以上取得できた場合は、null返却
            return null;
        }

        return dataEntity;
    }

    /**
     *
     * <pre>
     * 実行日の利率、実行日の利子助成率、決定起算日の利率、決定起算日の利子助成率を取得する。
     *
     * Cr001_01ServiceImplから持ち込んでいます。
     * </pre>
     *
     * @param itemNames 項目名を下記の順で格納した配列<br>
     *        {実行日の利率項目名,実行日の利子助成率項目名,決定起算日の利率項目名,決定起算日の利子助成率項目名}
     * @param dataEntity 金利変換テーブルデータ
     * @param intLine 案件番号
     * @param jikkoDate 実行日
     * @param ketteiKisanDate 決定起算日
     * @return 実行日の利率、実行日の利子助成率、決定起算日の利率、決定起算日の利子助成率が格納されたMAP
     * @throws PNSystemException
     */
    private LinkedHashMap<String, String> getRitsuData(String[] itemNames,
            LinkedHashMap<String, String> dataEntity, int intLine, String jikkoDate, String ketteiKisanDate,
            String srtKashitsukeKikanYears) {

        String strDateJikkoRiritsu = "0";
        String strDateKetteiKisanRiritsu = "0";
        String strJikkoJoseiRitsu = "0";
        String strKetteiJoseiRitsu = "0";

        // 戻り値
        LinkedHashMap<String, String> outMap = new LinkedHashMap<String, String>();
        // 金利体系変換Entityの金利呼称コード、金利呼称細目コードが空文字の時は利率取得しない。
        // 共通部品でSQLExceptionになるから。
        if (PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKosho"))
                || PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
            outMap.put(itemNames[0], strDateJikkoRiritsu);
            outMap.put(itemNames[1], strJikkoJoseiRitsu);
            outMap.put(itemNames[2], strDateKetteiKisanRiritsu);
            outMap.put(itemNames[3], strKetteiJoseiRitsu);
            return outMap;
        }

        try {

            // 　　　引数の貸付実行日を比較対象の日付として利率および利子助成率を取得する。
            // 　　　　引数：引数の貸付実行日
            // 　　　　利率取得(共通部品)を呼び、利率を取得する。
            // 　　　　取得した利率を「実行日の利率」に設定する。
            BigDecimal jikkoRiritsu = pnCommonDBComponents.getRiritsuData(dataEntity, intLine, jikkoDate,
                    srtKashitsukeKikanYears);
            if (null != jikkoRiritsu) {
                strDateJikkoRiritsu = jikkoRiritsu.toString();
            }
            outMap.put(itemNames[0], strDateJikkoRiritsu);
            // 　　　　取得した利子助成率を「実行日の利子助成率」に設定する。
            BigDecimal jikkoJoseiRitsu = pnCommonDBComponents.getJoseiRiritsuData(dataEntity, intLine,
                    jikkoDate, srtKashitsukeKikanYears);
            if (null != jikkoJoseiRitsu) {
                strJikkoJoseiRitsu = jikkoJoseiRitsu.toString();
            }
            outMap.put(itemNames[1], strJikkoJoseiRitsu);
            // 　　　扱店別稟議データの決定起算日を比較対象の日付として利率および利子助成率を取得する。
            // 　　　　引数：扱店別稟議データの決定起算日
            // 　　　　利率取得(共通部品)を呼び、利率を取得する。
            // 　　　　取得した利率を「決定起算日の利率」に設定する。
            BigDecimal ketteiKisanRiritsu = pnCommonDBComponents.getRiritsuData(dataEntity, intLine,
                    ketteiKisanDate, srtKashitsukeKikanYears);
            if (null != ketteiKisanRiritsu) {
                strDateKetteiKisanRiritsu = ketteiKisanRiritsu.toString();
            }
            outMap.put(itemNames[2], strDateKetteiKisanRiritsu);
            // 　　　　取得した利子助成率を「決定起算日の利子助成率」に設定する。
            BigDecimal ketteiJoseiRitsu = pnCommonDBComponents.getJoseiRiritsuData(dataEntity, intLine,
                    ketteiKisanDate, srtKashitsukeKikanYears);
            if (null != ketteiJoseiRitsu) {
                strKetteiJoseiRitsu = ketteiJoseiRitsu.toString();
            }
            outMap.put(itemNames[3], strKetteiJoseiRitsu);

        } catch (PNSystemException e) {
            throw e;
        }

        return outMap;
    }

    /**
     *
     * <pre>
     * 実行日の特利、決定起算日の特利を取得する。
     * </pre>
     *
     * @param itemNames 項目名を下記の順で格納した配列<br>
     *        {実行日の特利項目名,決定起算日の特利項目名}
     * @param dataEntity 金利変換テーブルデータ
     * @param intLine 案件番号
     * @param jikkoDate 実行日
     * @param ketteiKisanDate 決定起算日
     * @param getItemName 特利テーブルから取得する項目名
     * @return 実行日の特利、決定起算日の特利が格納されたMAP
     * @throws PNSystemException
     */
    private LinkedHashMap<String, String> getTokuriData(String[] itemNames,
            LinkedHashMap<String, String> dataEntity, int intLine, String jikkoDate, String ketteiKisanDate,
            String getItemName, String strKashitsukeKikanYear) {

        String strSueokiChuJoseiRitsu = "0";
        String strThreeYearsTokuri = "0";
        String strSueokiChuTokuri = "0";

        // 戻り値
        LinkedHashMap<String, String> outMap = new LinkedHashMap<String, String>();
        // 金利体系変換Entityの金利呼称コード、金利呼称細目コードが空文字の時は利率取得しない。
        // 共通部品でSQLExceptionになるから。
        if (PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKosho"))
                || PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
            outMap.put(itemNames[0], strSueokiChuJoseiRitsu);
            outMap.put(itemNames[1], strSueokiChuJoseiRitsu);
            return outMap;
        }

        try {
            // 据置中利子助成率取得
            if (Md001Constants.ITEM_NAME_SUEOKI_CHU_JOSEI_RITSU.equals(getItemName)) {
                // 実行日の特利
                BigDecimal sueokiChuJoseiRitsu = pnCommonDBComponents.getSueokiChuJoseiRitsu(dataEntity,
                        intLine, jikkoDate, strKashitsukeKikanYear);
                if (null != sueokiChuJoseiRitsu) {
                    strSueokiChuJoseiRitsu = sueokiChuJoseiRitsu.toString();
                }
                outMap.put(itemNames[0], strSueokiChuJoseiRitsu);
                // 決定起算日の特利
                sueokiChuJoseiRitsu = pnCommonDBComponents.getSueokiChuJoseiRitsu(dataEntity, intLine,
                        ketteiKisanDate, strKashitsukeKikanYear);
                if (null != sueokiChuJoseiRitsu) {
                    strSueokiChuJoseiRitsu = sueokiChuJoseiRitsu.toString();
                }
                outMap.put(itemNames[1], strSueokiChuJoseiRitsu);

            }

            // 実行後３年特利取得
            if (Md001Constants.ITEM_NAME_THREE_YEARS_TOKURI.equals(getItemName)) {
                // 実行日の特利
                BigDecimal threeYearsTokuri = pnCommonDBComponents.getThreeYearsTokuri(dataEntity, intLine,
                        jikkoDate, strKashitsukeKikanYear);
                if (null != threeYearsTokuri) {
                    strThreeYearsTokuri = threeYearsTokuri.toString();
                }
                outMap.put(itemNames[0], strThreeYearsTokuri);
                // 決定起算日の特利
                threeYearsTokuri = pnCommonDBComponents.getThreeYearsTokuri(dataEntity, intLine,
                        ketteiKisanDate, strKashitsukeKikanYear);
                if (null != threeYearsTokuri) {
                    strThreeYearsTokuri = threeYearsTokuri.toString();
                }
                outMap.put(itemNames[1], strThreeYearsTokuri);
            }

            // 据置中特利取得
            if (Md001Constants.ITEM_NAME_SUEOKI_CHU_TOKURI.equals(getItemName)) {
                // 実行日の特利
                BigDecimal sueokiChuTokuri = pnCommonDBComponents.getSueokiChuTokuri(dataEntity, intLine,
                        jikkoDate, strKashitsukeKikanYear);
                if (null != sueokiChuTokuri) {
                    strSueokiChuTokuri = sueokiChuTokuri.toString();
                }
                outMap.put(itemNames[0], strSueokiChuTokuri);
                // 定起算日の特利
                sueokiChuTokuri = pnCommonDBComponents.getSueokiChuTokuri(dataEntity, intLine,
                        ketteiKisanDate, strKashitsukeKikanYear);
                if (null != sueokiChuTokuri) {
                    strSueokiChuTokuri = sueokiChuTokuri.toString();
                }
                outMap.put(itemNames[1], strSueokiChuTokuri);
            }

        } catch (PNSystemException e) {
            throw e;
        }

        return outMap;
    }

    /**
     *
     * <pre>
     * ２点間比較利率を取得する。
     * </pre>
     *
     * @param dataEntity 金利変換テーブルデータ
     * @param intLine 案件番号
     * @param jikkoDate 実行日
     * @param ketteiKisanDate 決定起算日
     * @return ２点間比較利率
     * @throws PNSystemException
     */
    private String get2tenkanHikakuRiritsu(LinkedHashMap<String, String> dataEntity, int intLine,
            String jikkoDate, String ketteiKisanDate, String srtKashitsukeKikanYears) {
        // 戻り値
        String ret = "";
        BigDecimal riritsuValu;
        String codeKinriKosho = "";
        String codeKinriKoshoSaimoku = "";

        // 金利体系変換Entityの金利呼称コード、金利呼称細目コードが空文字の時は利率取得しない。
        // 共通部品でSQLExceptionになるから。
        if (PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKosho"))
                || PNCommonConstants.LITERAL_BLANK.equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
            return ret;
        }

        try {

            // 　　　東日本大震災対応（2点間比較の対応）
            // 　　　　金利呼称コード=02、金利呼称細目コード=61の場合
            if ("02".equals(dataEntity.get("Code_KinriKosho"))
                    && "61".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを02、金利呼称細目コードを01に設定する。
                codeKinriKosho = "02";
                codeKinriKoshoSaimoku = "01";
            }
            // 　　　　金利呼称コード=03、金利呼称細目コード=62の場合
            if ("03".equals(dataEntity.get("Code_KinriKosho"))
                    && "62".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを03、金利呼称細目コードを02に設定する。
                codeKinriKosho = "03";
                codeKinriKoshoSaimoku = "02";
            }
            // 　　　　金利呼称コード=03、金利呼称細目コード=63の場合
            if ("03".equals(dataEntity.get("Code_KinriKosho"))
                    && "63".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを03、金利呼称細目コードを03に設定する。
                codeKinriKosho = "03";
                codeKinriKoshoSaimoku = "03";
            }
            // 　　　　金利呼称コード=04、金利呼称細目コード=61の場合
            if ("04".equals(dataEntity.get("Code_KinriKosho"))
                    && "61".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを01に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "01";
            }
            // 　　　　金利呼称コード=04、金利呼称細目コード=62の場合
            if ("04".equals(dataEntity.get("Code_KinriKosho"))
                    && "62".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを02に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "02";
            }
            // 　　　　金利呼称コード=04、金利呼称細目コード=63の場合
            if ("04".equals(dataEntity.get("Code_KinriKosho"))
                    && "63".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを03に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "03";
            }
            // 　　　　金利呼称コード=04、金利呼称細目コード=64の場合
            if ("04".equals(dataEntity.get("Code_KinriKosho"))
                    && "64".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを04に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "04";
            }
            // 　　　　金利呼称コード=04、金利呼称細目コード=65の場合
            if ("04".equals(dataEntity.get("Code_KinriKosho"))
                    && "65".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを05に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "05";
            }
            // 　　　　金利呼称コード=05、金利呼称細目コード=63の場合
            if ("05".equals(dataEntity.get("Code_KinriKosho"))
                    && "63".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを05、金利呼称細目コードを03に設定する。
                codeKinriKosho = "05";
                codeKinriKoshoSaimoku = "03";
            }
            // 　　　　金利呼称コード=05、金利呼称細目コード=61の場合
            if ("05".equals(dataEntity.get("Code_KinriKosho"))
                    && "61".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを05、金利呼称細目コードを01に設定する。
                codeKinriKosho = "05";
                codeKinriKoshoSaimoku = "01";
            }
            // 　　　　金利呼称コード=05、金利呼称細目コード=64の場合
            if ("05".equals(dataEntity.get("Code_KinriKosho"))
                    && "64".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを05、金利呼称細目コードを04に設定する。
                codeKinriKosho = "05";
                codeKinriKoshoSaimoku = "04";
            }
            // 　　　　金利呼称コード=05、金利呼称細目コード=65の場合
            if ("05".equals(dataEntity.get("Code_KinriKosho"))
                    && "65".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを05、金利呼称細目コードを04に設定する。
                codeKinriKosho = "05";
                codeKinriKoshoSaimoku = "04";
            }
            // 　　　　金利呼称コード=06、金利呼称細目コード=65の場合
            if ("06".equals(dataEntity.get("Code_KinriKosho"))
                    && "65".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを06、金利呼称細目コードを05に設定する。
                codeKinriKosho = "06";
                codeKinriKoshoSaimoku = "05";
            }
            // 　　　　金利呼称コード=06、金利呼称細目コード=61の場合
            if ("06".equals(dataEntity.get("Code_KinriKosho"))
                    && "61".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを06、金利呼称細目コードを01に設定する。
                codeKinriKosho = "06";
                codeKinriKoshoSaimoku = "01";
            }
            // 　　　　金利呼称コード=06、金利呼称細目コード=62の場合
            if ("06".equals(dataEntity.get("Code_KinriKosho"))
                    && "62".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを06、金利呼称細目コードを02に設定する。
                codeKinriKosho = "06";
                codeKinriKoshoSaimoku = "02";
            }
            // 　　　　金利呼称コード=06、金利呼称細目コード=63の場合
            if ("06".equals(dataEntity.get("Code_KinriKosho"))
                    && "63".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを04、金利呼称細目コードを02に設定する。
                codeKinriKosho = "04";
                codeKinriKoshoSaimoku = "02";
            }
            // 　　　　金利呼称コード=10、金利呼称細目コード=71の場合
            if ("10".equals(dataEntity.get("Code_KinriKosho"))
                    && "71".equals(dataEntity.get("Code_KinriKoshoSaimoku"))) {
                // 　　　　　引数：金利呼称コードを10、金利呼称細目コードを01に設定する。
                codeKinriKosho = "10";
                codeKinriKoshoSaimoku = "01";
            }

            // 金利呼称コード、金利呼称細目コードが設定されている場合、２点間比較利率取得(共通部品)から利率を取得する。
            if (false == PNCommonConstants.LITERAL_BLANK.equals(codeKinriKosho)
                    && false == PNCommonConstants.LITERAL_BLANK.equals(codeKinriKoshoSaimoku)) {
                riritsuValu = pnCommonDBComponents.getNitenkanHikakuRiritsu(dataEntity, codeKinriKosho,
                        codeKinriKoshoSaimoku, jikkoDate, ketteiKisanDate, srtKashitsukeKikanYears, intLine);
                if (null != riritsuValu) {
                    ret = riritsuValu.toString();
                }
            }
        } catch (PNSystemException e) {
            throw e;
        }

        // 利率を返却する
        return ret;
    }

}