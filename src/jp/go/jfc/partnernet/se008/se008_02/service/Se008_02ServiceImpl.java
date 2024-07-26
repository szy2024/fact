//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se008.common.Se008Constants;
import jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsDataDAO;
import jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsDataEntity;
import jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataDAO;
import jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはse008_02のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_02ServiceImpl extends PNBaseService implements Se008_02Service {

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /** se008_02resultsdatadao */
    @Autowired
    private Se008_02ResultsDataDAO se008_02resultsdatadao;

    /** se008_02resultskarikeisandatadao */
    @Autowired
    private Se008_02ResultsKariKeisanDataDAO se008_02resultskarikeisandatadao;

    /**
     * Se008_02ServiceのgetResultsData
     *
     * @param inDto Se008_02DTO
     * @return Se008_02DTO
     */
    @Override
    public Se008_02DTO getResultsData(Se008_02DTO inDto) {
        // エラーリスト
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // エラーリスト初期化
        bizErrors.clear();

        Se008_02DTO outDto = new Se008_02DTO();
        Se008_02ResultsDataEntity inEntity = new Se008_02ResultsDataEntity();

        // 検索開始日、検索終了日を設定
        // DTOより設定値を取得する。
        // 検索開始日の編集
        // 検索開始年月日のパラメータを取得し、連結する。
        String search_start_date = PNCommonComponents.concatString(inDto.getID_SearchStartYear(),
                inDto.getID_SearchStartMonth(), inDto.getID_SearchStartDate());
        inEntity.setSearch_start_date(search_start_date);

        // 検索終了日の編集
        // 検索終了年月日のパラメータを取得し、連結する。
        String search_end_date = PNCommonComponents.concatString(inDto.getID_SearchEndYear(),
                inDto.getID_SearchEndMonth(), inDto.getID_SearchEndDate());
        inEntity.setSearch_end_date(search_end_date);

        // セッションから権限管理データの取得
        String code_Organizatio = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            code_Organizatio = commonInfo.getCode_Organization();
        }
        // ログインユーザの扱店コード
        inEntity.setCode_Organization(PNCommonComponents.cnvNulltoBlank(code_Organizatio));

        // 複数テーブルアクセス定義の「Se008_02ResultsDataDAO」を参照し、条件を設定する。
        List<Se008_02ResultsDataEntity> outEntityList = se008_02resultsdatadao.findByCondition(inEntity);
        // 取得した件数が0件の場合、業務エラーとする。
        if (0 == outEntityList.size()) {
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        List<Se008_02M1DTO> meisaiList = new ArrayList<Se008_02M1DTO>();

        // Entity⇒DTOに転記
        for (Se008_02ResultsDataEntity entity : outEntityList) {
            Se008_02M1DTO m1Dto = new Se008_02M1DTO();
            // 顧客名
            // Se008_02ResultsDataEntity.顧客名⇒Se008_02DTO.顧客名
            m1Dto.setID_Name_Customer(entity.getName_Customer());
            // 公庫支店名
            // Se008_02ResultsDataEntity.公庫支店名⇒Se008_02DTO.公庫支店名
            m1Dto.setID_Name_KoukoShiten(entity.getName_KoukoShiten());
            // 扱店
            // Se008_02ResultsDataEntity.扱店⇒Se008_02DTO.扱店
            m1Dto.setID_Code_Organization(entity.getCode_Organization());
            // 店舗
            // Se008_02ResultsDataEntity.店舗⇒Se008_02DTO.店舗
            m1Dto.setID_Code_Tenpo(entity.getCode_Tenpo());
            // 年度
            // 西暦から和暦に変換して設定する（JSPで対応）
            // 　Se008_02ResultsDataEntity.年度⇒Se008_02DTO.年度
            m1Dto.setID_Year(entity.getYear());
            // 方式資金
            // Se008_02ResultsDataEntity.方式資金⇒Se008_02DTO.方式資金
            m1Dto.setID_Kubun_HoshikiShikin(entity.getKubun_HoshikiShikin());
            // 番号
            // Se008_02ResultsDataEntity.番号⇒Se008_02DTO.番号
            m1Dto.setID_ID_Ringi(entity.getID_Ringi());
            // 枝番
            // Se008_02ResultsDataEntity.枝番⇒Se008_02DTO.枝番
            String strRingBranch = entity.getID_RingiBranch();
            m1Dto.setID_ID_RingiBranch(Se008Constants.DISPLAY_EDA_CHEACK_ZERO.equals(strRingBranch) ? Se008Constants.DISPLAY_EDA_CHEACK_BLANK
                    : strRingBranch);
            // 払込期日
            // 西暦から和暦に変換して設定する（JSPで対応）
            // 　Se008_02ResultsDataEntity.払込年月日⇒Se008_02DTO.払込期日
            m1Dto.setID_Date_Haraikomi(entity.getDate_Haraikomi());
            // 約定利息
            // Se008_02ResultsDataEntity.約定利息⇒Se008_02DTO.約定利息
            m1Dto.setID_M_YakujoRisoku(entity.getM_YakujoRisoku());
            // 約定元金
            // Se008_02ResultsDataEntity.約定元金⇒Se008_02DTO.約定元金
            m1Dto.setID_M_YakujoGankin(entity.getM_YakujoGankin());
            // 控除利息
            m1Dto.setID_M_KojoRisoku(entity.getM_KojoRisoku());
            // 請求繰上償還元金
            // Se008_02ResultsDataEntity.請求繰上償還元金⇒Se008_02DTO.請求繰上償還元金
            m1Dto.setID_M_SeiKuriGankin(entity.getM_SeiKuriGankin());
            // 請求繰上償還利息
            // Se008_02ResultsDataEntity.請求繰上償還利息⇒Se008_02DTO.請求繰上償還利息
            m1Dto.setID_M_SeiKuriRisoku(entity.getM_SeiKuriRisoku());
            // 任意繰上償還利息
            // Se008_02ResultsDataEntity.任意繰上償還利息⇒Se008_02DTO.任意繰上償還利息
            m1Dto.setID_M_NinKuriRisoku(entity.getM_NinKuriRisoku());
            // Se008_02ResultsDataEntity.債権管理番号⇒Se008_02DTO.債権管理番号
            m1Dto.setID_Credit(entity.getID_Credit());
            // 　Se008_02ResultsDataEntity.実行年月日⇒Se008_02DTO.実行年月日
            // 西暦から和暦に変換して設定する（JSPで対応）
            m1Dto.setDate_Jikko(entity.getDate_Jikko());
            // 　Se008_02ResultsDataEntity.特利有効年月日⇒Se008_02DTO.特利有効年月日
            // 西暦から和暦に変換して設定する（JSPで対応）
            m1Dto.setDate_TokuriYuko(entity.getDate_TokuriYuko());
            // Se008_02ResultsDataEntity.償還方法コード⇒Se008_02DTO.償還方法コード
            m1Dto.setCode_ShokanHouhou(entity.getCode_ShokanHouhou());

            BigDecimal Riritsu = new BigDecimal(entity.getRiritsu());
            BigDecimal Tokuri = new BigDecimal(entity.getTokuri());
            m1Dto.setRiritsu(Riritsu);
            m1Dto.setTokuri(Tokuri);

            // 明細リストに追加
            meisaiList.add(m1Dto);
        }

        // 明細リストをDtoに設定
        outDto.setMEISAI_LIST(meisaiList);

        return outDto;
    }

    /**
     * Se008_02ServiceのgetResultsKariKeisanData
     *
     * @param inDto Se008_02DTO
     * @return Se008_02DTO
     */
    @Override
    public Se008_02DTO getResultsKariKeisanData(Se008_02DTO inDto) {

        // エラーリスト
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // エラーリスト初期化
        bizErrors.clear();

        Se008_02DTO outDto = new Se008_02DTO();
        Se008_02ResultsKariKeisanDataEntity inEntity = new Se008_02ResultsKariKeisanDataEntity();

        // 債権管理番号
        inEntity.setID_Credit(inDto.getID_Credit());

        // 複数テーブルアクセス定義「Se008_02ResultsKariKeisanDataDAO」を参照し、条件を設定する。
        long hitcount = se008_02resultskarikeisandatadao.countByCondition(inEntity);
        if (0 < hitcount) {
            // 仮計算中メッセージ
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3580E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        return outDto;
    }

}