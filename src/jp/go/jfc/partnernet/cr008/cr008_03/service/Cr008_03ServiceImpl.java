//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/11 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_03.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.cr008.cr008_03.dao.Cr008_03ResultDataDAO;
import jp.go.jfc.partnernet.cr008.cr008_03.dao.Cr008_03ResultDataEntity;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはcr008_03のサービスクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_03ServiceImpl extends PNBaseService implements Cr008_03Service {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_03ServiceImpl.class);

    /** cr008_03resultdatadao */
    @Autowired
    private Cr008_03ResultDataDAO cr008_03resultdatadao;

    /**
     * Cr008_03ServiceのgetResultData
     *
     * @param inDto Cr008_03DTO
     * @return Cr008_03DTO
     */
    @Override
    public Cr008_03DTO getResultData(Cr008_03DTO inDto) {

        Cr008_03DTO outDto = new Cr008_03DTO();
        Cr008_03ResultDataEntity inEntity = new Cr008_03ResultDataEntity();

        // 顧客候補検索（一覧取得）の検索条件を設定
        // 　複数テーブルアクセス定義の「Cr008_03ResultsDataDAO」を参照し、条件を設定する。
        // 　・貸付先コード入力値にDTOの貸付先コード入力値を設定
        // 　・扱店コード入力値にDTOのログインユーザ扱店コードを設定
        inEntity.setCr008_03_In_Code_Organization(inDto.getCr008_03_In_Code_Organization());
        inEntity.setCr008_03_In_Code_Customer(inDto.getCr008_03_In_Code_Customer());

        List<Cr008_03ResultDataEntity> outEntityList = new ArrayList<Cr008_03ResultDataEntity>();

        // 　Cr008_03ResultsDataDAO.findByCondition
        outEntityList = cr008_03resultdatadao.findByCondition(inEntity);

        List<Cr008_03M1DTO> userList = new ArrayList<Cr008_03M1DTO>(outEntityList.size());

        // 検索結果を取得(Entity→DTOに設定)
        // 　以下の明細項目（Ｍ１）を設定する。
        if (0 != outEntityList.size()) {
            for (Cr008_03ResultDataEntity xEntity : outEntityList) {
                Cr008_03M1DTO userInfo = new Cr008_03M1DTO();
                StringBuilder strMeisaiYuushi = new StringBuilder(50);
                // 　　　　　----------表示項目----------
                // 　・融資番号の編集
                // 　　 所管本支店コード ＋ "-" ＋ 扱店コード ＋ "-" ＋ 店舗コード ＋ "-" ＋ 年度 ＋ "-" ＋ 方式区分 ＋ 資金区分 ＋ "-" ＋
                // 　　 稟議番号 ＋ "-" ＋ 稟議番号枝番

                // 所管本支店コード
                strMeisaiYuushi.append(xEntity.getCode_ShokanHonShiten());
                // ハイフン
                strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                // 扱店コード
                strMeisaiYuushi.append(xEntity.getCode_Organization());
                // ハイフン
                strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                // 店舗コード
                strMeisaiYuushi.append(xEntity.getCode_Tenpo());
                // ハイフン
                strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                // 年度
                // 　　※年度については、和暦変換して編集する。(Hxx)
                String strYear = PNCommonComponents.dateFmtAD_YYYY(xEntity.getYear());
                strMeisaiYuushi.append(strYear);
                // ハイフン
                strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                // 方式区分
                strMeisaiYuushi.append(xEntity.getKubun_Hoshiki());
                // 資金区分
                strMeisaiYuushi.append(xEntity.getKubun_Shikin());
                // ハイフン
                strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                // 稟議番号
                strMeisaiYuushi.append(xEntity.getID_Ringi());

                if (!Cr008Constants.RINGIBRANCH_NUM.equals(xEntity.getID_RingiBranch())) {
                    // 枝番が０でない場合、結合する
                    // ハイフン
                    strMeisaiYuushi.append(Cr008Constants.STR_HYPHEN);
                    // 稟議番号枝番
                    strMeisaiYuushi.append(xEntity.getID_RingiBranch());
                }

                // 結合した融資番号
                userInfo.setID_Code_Yuushi(strMeisaiYuushi.toString());

                // 　　　　　----------非表示項目（画面項目）----------
                // 　・債権管理番号
                userInfo.setID_ID_Credit(xEntity.getID_Credit());
                // 　　　　　----------非表示項目（画面項目）----------

                userList.add(userInfo);

                log.debug("[" + userList.size() + "]" + "債権管理番号:" + userInfo.getID_ID_Credit());
            }
        }

        outDto.setMEISAI_LIST1(userList);
        return outDto;
    }
}