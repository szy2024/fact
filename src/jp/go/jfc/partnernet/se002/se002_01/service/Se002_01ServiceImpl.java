//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se002_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se002.se002_01.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01ResultsDataDAO;
import jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01ResultsDataEntity;
import jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanDAO;
import jp.go.jfc.partnernet.se002.se002_01.dao.Se002_01UkeireZanEntity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe002_01のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se002_01ServiceImpl extends PNBaseService implements Se002_01Service {

    /** se002_01resultsdatadao */
    @Autowired
    private Se002_01ResultsDataDAO se002_01resultsdatadao;

    /** se002_01ukeirezandao */
    @Autowired
    private Se002_01UkeireZanDAO se002_01ukeirezandao;

    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Se002_01ServiceのgetResultsData
     *
     * @param inDto Se002_01DTO
     * @return Se002_01DTO
     */
    @Override
    public Se002_01DTO getResultsData(Se002_01DTO inDto) {

        Se002_01DTO outDto = new Se002_01DTO();

        // ２．表示データの抽出
        // 実行未了の検索条件を設定
        Se002_01ResultsDataEntity inEntity = new Se002_01ResultsDataEntity();
        // 扱店コード
        String code_Organization = "";
        //
        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            code_Organization = commonInfo.getCode_Organization();
            roleCode = commonInfo.getRoleCode();
        }
        inEntity.setCode_Organization(code_Organization);
        // 未完結区分
        inEntity.setKubun_Mikanketsu(PNCommonConstants.KUBUN_MIKANKETSU_2);
        // ログインユーザ権限種別
        inEntity.setSe002_01_RoleCode(roleCode);

        List<Se002_01ResultsDataEntity> outEntityList = se002_01resultsdatadao.findByCondition(inEntity);
        // 取得情報の件数をSe002_01DTO.実行未了件数に設定する。
        outDto.setJ_Kensu(outEntityList.size());

        // １．表示制御
        // Entity⇒DTOに転記
        List<Se002_01M1DTO> lstMeisai = new ArrayList<Se002_01M1DTO>(outEntityList.size());
        for (Se002_01ResultsDataEntity outEntity : outEntityList) {
            Se002_01M1DTO se002_01M1DTO = new Se002_01M1DTO();
            // Se002_01ResultsDataEntity.顧客名⇒Se002_01DTO.実行未了_顧客名
            se002_01M1DTO.setID_Name_Customer(outEntity.getName_Customer());
            // Se002_01ResultsDataEntity.公庫支店⇒Se002_01DTO.実行未了_公庫支店
            se002_01M1DTO.setID_Name_KoukoShiten(outEntity.getName_KoukoShiten());
            // Se002_01ResultsDataEntity.扱店⇒Se002_01DTO.実行未了_扱店
            se002_01M1DTO.setID_Code_Organization(outEntity.getCode_Organization());
            // Se002_01ResultsDataEntity.店舗⇒Se002_01DTO.実行未了_店舗
            se002_01M1DTO.setID_Code_Tenpo(outEntity.getCode_Tenpo());
            // 西暦から和暦に変換し設定
            // 　Se002_01ResultsDataEntity.年度⇒Se002_01DTO.実行未了_年度
            se002_01M1DTO.setID_Year(outEntity.getYear());
            // Se002_01ResultsDataEntity.方式＋Se002_01ResultsDataEntity.資金⇒Se002_01DTO.方式資金
            StringBuilder sb = new StringBuilder(PNCommonComponents.cnvNulltoBlank(outEntity
                    .getKubun_Hoshiki()));
            sb.append(outEntity.getKubun_Shikin());
            se002_01M1DTO.setID_Kubun_Hoshiki(sb.toString());
            // Se002_01ResultsDataEntity.資金⇒Se002_01DTO.実行未了_資金
            se002_01M1DTO.setID_Kubun_Shikin(outEntity.getKubun_Shikin());
            // Se002_01ResultsDataEntity.番号⇒Se002_01DTO.実行未了_番号
            se002_01M1DTO.setID_ID_Ringi(outEntity.getID_Ringi());
            // Se002_01ResultsDataEntity.枝番⇒Se002_01DTO.実行未了_枝番
            String ringiBranch = outEntity.getID_RingiBranch();
            if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(ringiBranch)) {
                ringiBranch = "";
            }
            se002_01M1DTO.setID_ID_RingiBranch(ringiBranch);
            // 西暦から和暦に変換し設定
            // 　Se002_01ResultsDataEntity.貸付決定日⇒Se002_01DTO.実行未了_貸付決定日
            se002_01M1DTO.setID_Date_JuriKetteikisan(outEntity.getDate_JuriKetteikisan());
            // Se002_01ResultsDataEntity.貸付決定額⇒Se002_01DTO.実行未了_貸付決定額
            se002_01M1DTO.setID_M_Kettei(outEntity.getM_Kettei());
            // 西暦から和暦に変換し設定
            // Se002_01ResultsDataEntity.貸付実行予定日(進行管理データ)⇒Se002_01DTO.貸付実行予定日
            se002_01M1DTO.setID_Shinko_Kanri_Date_Jikko(outEntity.getShinko_Kanri_Date_Jikko());
            // Se002_01ResultsDataEntity.貸付実行額⇒Se002_01DTO.実行未了_貸付実行額
            se002_01M1DTO.setID_M_Kashitsuke(outEntity.getM_Kashitsuke());
            // Se002_01ResultsDataEntity.資金払出未了額⇒Se002_01DTO.実行未了_資金払出未了額
            se002_01M1DTO.setID_M_KashitsukeukeireZan(outEntity.getM_KashitsukeukeireZan());
            // 貸付実行期限の算出
            // 　Se002_01ResultsDataEntity.貸付決定日の３か月後を求める⇒３か月後の日付
            Date dtJuriKetteikisan = PNDateUtils.toDate(outEntity.getDate_JuriKetteikisan(),
                    PNDateUtils.DATE_PATTERN_YYYYMMDD);
            Date date = PNDateUtils.addMonths(dtJuriKetteikisan, 3);
            // ３か月後の日付の前日を求める⇒３か月後の前日
            Date date2 = PNDateUtils.addDays(date, -1);
            // ３か月後の前日⇒３か月後の日付
            String businessDay = new SimpleDateFormat("yyyyMMdd").format(date2);
            // 営業日判定は行わない
            // 　　３か月後の前日を営業日判定(共通部品)でチェックし、非営業日の場合
            //if (null == pnCommonDBComponents.chkBusinessDay(businessDay)) {
            //    // 　　３か月後の前日の前営業日を求める⇒３か月後の日付
            //    //businessDay = pnCommonDBComponents.getCalculateBusinessDay(businessDay, 1);
            //    businessDay = pnCommonDBComponents.getCalculateBusinessDay(businessDay, -1);
            //}

            se002_01M1DTO.setID_Date_JikkoKigen(businessDay);
            // 　Se002_01ResultsDataEntity.資金払出期限⇒Se002_01DTO.実行未了_資金払出期限
            se002_01M1DTO.setID_Date_HaraidashiKigen(outEntity.getDate_HaraidashiKigen());
            lstMeisai.add(se002_01M1DTO);
        }

        // 払出未了の検索条件を設定
        Se002_01ResultsDataEntity inEntity2 = new Se002_01ResultsDataEntity();
        // 扱店コード
        inEntity2.setCode_Organization(code_Organization);
        // 未完結区分
        inEntity2.setKubun_Mikanketsu(PNCommonConstants.KUBUN_MIKANKETSU_3);
        // ログインユーザ権限種別
        inEntity2.setSe002_01_RoleCode(roleCode);

        List<Se002_01ResultsDataEntity> outEntityList2 = se002_01resultsdatadao.findByCondition(inEntity2);
        // 取得情報の件数をSe002_01DTO.払出未了件数に設定する。
        outDto.setH_Kensu(outEntityList2.size());

        // 払出未了額（進行管理データより取得した「貸付受入金残高」）を直近の払出データの「貸付受入金残高」に置き換える。
        // １．表示制御
        // Entity⇒DTOに転記
        List<Se002_01M2DTO> lstMeisai2 = new ArrayList<Se002_01M2DTO>(outEntityList2.size());
        // 業務日付を取得
        String pnBusinessDay = pnCommonDBComponents.getPNBusinessDay(1);

        for (Se002_01ResultsDataEntity outEntity : outEntityList2) {
            // 払出データからの貸付受入金残高の取得
            // 複数テーブルアクセス定義の「se002_01UkeireZanDAO」を参照し、条件を設定する。
            // se002_01UkeireZanDAO.findByCondition
            Se002_01M2DTO se002_01M2DTO = new Se002_01M2DTO();
            Se002_01UkeireZanEntity inEntity3 = new Se002_01UkeireZanEntity();
            // 債権管理番号
            inEntity3.setID_Credit(outEntity.getID_Credit());
            // 払出充当年月日に業務日付を設定
            inEntity3.setDate_HaraidashiJuto(pnBusinessDay);
            List<Se002_01UkeireZanEntity> outEntityList3 = se002_01ukeirezandao.findByCondition(inEntity3);
            // 払出未了額（進行管理データより取得した「貸付受入金残高」）を直近の払出データの「貸付受入金残高」に置き換える。
            // Se002_01ResultsDataEntity.資金払出未了額⇒Se002_01DTO.払出未了_資金払出未了額
            if (0 < outEntityList3.size()) {
                Se002_01UkeireZanEntity outEntity3 = outEntityList3.get(0);
                se002_01M2DTO.setID_M_KashitsukeukeireZan(outEntity3.getM_KashitsukeukeireZan());
            } else {
                se002_01M2DTO.setID_M_KashitsukeukeireZan(null);
            }
            // Se002_01ResultsDataEntity.顧客名⇒Se002_01DTO.払出未了_顧客名
            // se002_01M2DTO.setID_Name_Customer(outEntity.);
            se002_01M2DTO.setID_Name_Customer(outEntity.getName_Customer());
            // Se002_01ResultsDataEntity.公庫支店⇒Se002_01DTO.払出未了_公庫支店
            se002_01M2DTO.setID_Name_KoukoShiten(outEntity.getName_KoukoShiten());
            // Se002_01ResultsDataEntity.扱店⇒Se002_01DTO.払出未了_扱店
            se002_01M2DTO.setID_Code_Organization(outEntity.getCode_Organization());
            // Se002_01ResultsDataEntity.店舗⇒Se002_01DTO.払出未了_店舗
            se002_01M2DTO.setID_Code_Tenpo(outEntity.getCode_Tenpo());
            // 西暦から和暦に変換し設定
            // 　Se002_01ResultsDataEntity.年度⇒Se002_01DTO.払出未了_年度
            se002_01M2DTO.setID_Year(outEntity.getYear());
            // Se002_01ResultsDataEntity.方式＋Se002_01ResultsDataEntity.資金⇒Se002_01DTO.方式資金
            StringBuilder sb = new StringBuilder(PNCommonComponents.cnvNulltoBlank(outEntity
                    .getKubun_Hoshiki()));
            sb.append(outEntity.getKubun_Shikin());
            se002_01M2DTO.setID_Kubun_Hoshiki(sb.toString());
            // Se002_01ResultsDataEntity.資金⇒Se002_01DTO.払出未了_資金
            se002_01M2DTO.setID_Kubun_Shikin(outEntity.getKubun_Shikin());
            // Se002_01ResultsDataEntity.番号⇒Se002_01DTO.払出未了_番号
            se002_01M2DTO.setID_ID_Ringi(outEntity.getID_Ringi());
            // Se002_01ResultsDataEntity.枝番⇒Se002_01DTO.払出未了_枝番
            String ringiBranch = outEntity.getID_RingiBranch();
            if (PNCommonConstants.RINGI_BRANCH_VALUE_ZERO.equals(ringiBranch)) {
                ringiBranch = "";
            }
            se002_01M2DTO.setID_ID_RingiBranch(ringiBranch);
            // 西暦から和暦に変換し設定
            // 　Se002_01ResultsDataEntity.貸付決定日⇒Se002_01DTO.払出未了_貸付決定日
            se002_01M2DTO.setID_Date_JuriKetteikisan(outEntity.getDate_JuriKetteikisan());
            // Se002_01ResultsDataEntity.貸付決定額⇒Se002_01DTO.払出未了_貸付決定額
            se002_01M2DTO.setID_M_Kettei(outEntity.getM_Kettei());
            // Se002_01ResultsDataEntity.貸付実行予定日(扱店別稟議データ)⇒Se002_01DTO.貸付実行日
            se002_01M2DTO.setID_Date_Jikko(outEntity.getDate_Jikko());
            // Se002_01ResultsDataEntity.貸付実行額⇒Se002_01DTO.払出未了_貸付実行額
            se002_01M2DTO.setID_M_Kashitsuke(outEntity.getM_Kashitsuke());
            // 西暦から和暦に変換し設定
            // Se002_01ResultsDataEntity.貸付実行期限⇒Se002_01DTO.払出未了_貸付実行期限
            se002_01M2DTO.setID_Date_JikkoKigen(outEntity.getDate_JikkoKigen());
            // Se002_01ResultsDataEntity.貸付実行予定日(進行管理データ)⇒Se002_01DTO.資金払出期限
            // se002_01M2DTO.setID_Shinko_Kanri_Date_Jikko(outEntity.getShinko_Kanri_Date_Jikko());

            if (!StringUtils.isEmpty(outEntity.getShinko_Kanri_Date_Jikko())) {
                Date dtShinkokanriDateJikko = PNDateUtils.toDate(outEntity.getShinko_Kanri_Date_Jikko(), PNDateUtils.DATE_PATTERN_YYYYMMDD);
                // 12か月後の日付の前日を求める⇒12か月後の前日
                Date date = PNDateUtils.addDays(PNDateUtils.addMonths(dtShinkokanriDateJikko, 12), -1);
               // 12か月後の前日⇒12か月後の日付
               String businessDay = new SimpleDateFormat(PNDateUtils.DATE_PATTERN_YYYYMMDD).format(date);
               // 営業日判定は行わない
               // 12か月後の前日を営業日判定(共通部品)でチェックし、非営業日の場合
               //if (null == pnCommonDBComponents.chkBusinessDay(businessDay)) {
               //    // 12か月後の前日の前営業日を求める
               //    businessDay = pnCommonDBComponents.getCalculateBusinessDay(businessDay, -1);
               //}
               se002_01M2DTO.setID_Shinko_Kanri_Date_Jikko(businessDay);
            }

            lstMeisai2.add(se002_01M2DTO);
        }
        // 明細リスト１を設定
        outDto.setMEISAI_LIST1(lstMeisai);
        // 明細リスト１を設定
        outDto.setMEISAI_LIST2(lstMeisai2);
        return outDto;
    }
}